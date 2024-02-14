package io.fusionauth.mobilesdk

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import io.fusionauth.mobilesdk.exceptions.AuthenticationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import net.openid.appauth.AppAuthConfiguration
import net.openid.appauth.AuthState
import net.openid.appauth.AuthorizationException
import net.openid.appauth.AuthorizationRequest
import net.openid.appauth.AuthorizationResponse
import net.openid.appauth.AuthorizationService
import net.openid.appauth.AuthorizationServiceConfiguration
import net.openid.appauth.EndSessionRequest
import net.openid.appauth.GrantTypeValues
import net.openid.appauth.ResponseTypeValues
import net.openid.appauth.TokenRequest
import net.openid.appauth.TokenResponse
import net.openid.appauth.connectivity.ConnectionBuilder
import net.openid.appauth.connectivity.DefaultConnectionBuilder
import java.net.HttpURLConnection
import java.util.concurrent.atomic.AtomicReference
import java.util.logging.Logger
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * OAuthAuthenticationService class is responsible for handling OAuth authorization and authentication process.
 * It provides methods to authorize the user, handle the redirect intent, fetch user information,
 * perform logout, retrieve fresh access token, and get the authorization service.
 *
 * @property context The Android application context.
 * @property fusionAuthUrl The URL of the FusionAuth server.
 * @property clientId The client ID registered in the FusionAuth server.
 * @property tenantId The tenant ID, or null if not applicable.
 * @property tokenManager The token manager to handle token storage and retrieval, or null if not used.
 * @property allowUnsecureConnection Boolean value indicating whether unsecure connections are allowed.
 * @property defaultDispatcher The default coroutine dispatcher. Default is Dispatchers.Default
 * @property additionalScopes Additional scopes to be requested during authentication. Default is empty.
 * @property locale The locale to be used for authentication. Default is null.
 */
@Suppress("LongParameterList", "TooManyFunctions", "MemberVisibilityCanBePrivate", "unused")
class OAuthAuthenticationService internal constructor(
    val context: Context,
    val fusionAuthUrl: String,
    val clientId: String,
    val tenantId: String?,
    val tokenManager: TokenManager?,
    val allowUnsecureConnection: Boolean = false,
    val additionalScopes: Set<String> = emptySet(),
    val locale: String? = null,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default,
) {

    private val json = Json { ignoreUnknownKeys = true }
    private val authenticationConfiguration = AtomicReference<AuthorizationServiceConfiguration?>()
    private val authState = AtomicReference<AuthState?>()

    /**
     * Authorizes the user using OAuth authentication.
     *
     * @param completedIntent The PendingIntent to be used when the authorization process is completed.
     * @param options The options for the authorize request. Default is null.
     */
    suspend fun authorize(completedIntent: Intent, options: OAuthAuthorizeOptions?) {
        return authorize(completedIntent, null, options)
    }

    /**
     * Authorizes the user using OAuth authentication.
     *
     * @param completedIntent The PendingIntent to be used when the authorization process is completed.
     * @param cancelIntent The PendingIntent to be used when the authorization process is cancelled. Default is null.
     * @param options The options for the authorize request. Default is null.
     */
    suspend fun authorize(
        completedIntent: Intent,
        cancelIntent: Intent? = null,
        options: OAuthAuthorizeOptions? = null
    ) {
        val config = getConfiguration()

        // Additional parameters supported by FusionAuth
        // See https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#authorize
        val additionalParameters = mutableMapOf<String, String>()

        // Global Options
        tenantId?.let { additionalParameters["tenantId"] = it }
        locale?.let { additionalParameters["locale"] = it }

        // Authorize Options
        options?.codeChallenge?.let { additionalParameters["code_challenge"] = it }
        options?.codeChallengeMethod?.let { additionalParameters["code_challenge_method"] = it.name }
        options?.idpHint?.let { additionalParameters["idp_hint"] = it }
        options?.deviceDescription?.let { additionalParameters["metaData.device.description"] = it }
        options?.userCode?.let { additionalParameters["user_code"] = it }

        val authRequestBuilder =
            AuthorizationRequest.Builder(
                config,
                clientId,
                ResponseTypeValues.CODE,
                Uri.parse(options?.redirectUri ?: "io.fusionauth.app:/oauth2redirect"),
            )
                .setScope(scopes)
                .setAdditionalParameters(additionalParameters)

        options?.state?.let { authRequestBuilder.setState(it) }
        options?.loginHint?.let { authRequestBuilder.setLoginHint(it) }
        options?.nonce?.let { authRequestBuilder.setNonce(it) }

        val completedPendingIntent = PendingIntent.getActivity(
            context,
            0,
            Intent(completedIntent).also {
                if (options?.state != null) it.putExtra(EXTRA_STATE, options.state)
            },
            PendingIntent.FLAG_MUTABLE
        )

        val authRequest = authRequestBuilder.build()

        val authService = getAuthorizationService()
        if (cancelIntent == null) {
            authService.performAuthorizationRequest(
                authRequest,
                completedPendingIntent,
            )
            return
        }
        authService.performAuthorizationRequest(
            authRequest,
            completedPendingIntent,
            PendingIntent.getActivity(
                context,
                0,
                cancelIntent
                    .putExtra(EXTRA_FAILED, true),
                PendingIntent.FLAG_MUTABLE
            ),
        )
    }

    /**
     * Handles the redirect intent from the authorization process.
     *
     * @param intent The intent received from the authorization process.
     * @return The FusionAuthState object that contains the access token, access token expiration time, and id token.
     * @throws AuthenticationException If the authorization process failed.
     */
    suspend fun handleRedirect(intent: Intent): FusionAuthState {
        return withContext(defaultDispatcher) {
            val response = AuthorizationResponse.fromIntent(intent)
            val exception = AuthorizationException.fromIntent(intent)

            // Validate the state
            val state = intent.getStringExtra(EXTRA_STATE)
            if (state.orEmpty() != response?.state.orEmpty()) {
                throw AuthenticationException("State mismatch")
            }

            appAuthState.update(response, exception)

            if (response != null) {
                val tokenResponse = async { performTokenRequest(response, exception) }
                val t = tokenResponse.await()
                appAuthState.update(t, exception)
                val authState = FusionAuthState(
                    accessToken = t.accessToken,
                    accessTokenExpirationTime = t.accessTokenExpirationTime,
                    idToken = t.idToken,
                    refreshToken = t.refreshToken,
                )
                tokenManager?.saveAuthState(authState)
                authState
            } else {
                throw exception?.let { AuthenticationException(it) } ?: AuthenticationException("Unknown error")
            }
        }
    }

    /**
     * Checks if the authorization process has failed by examining the given intent.
     * This method should be called inside a coroutine.
     *
     * @param intent The intent to examine.
     * @return `true` if the authorization process has failed, `false` otherwise.
     */
    fun isFailed(intent: Intent): Boolean {
        val exception = AuthorizationException.fromIntent(intent)
        Logger.getLogger("OAuthAuthenticationService").info("Authorization failed: $exception")
        return exception != null
    }

    /**
     * Retrieves the user information for the authenticated user.
     *
     * @return The user information if available, or null if not authenticated or unable to fetch user info.
     */
    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getUserInfo(): UserInfo? {
        return withContext(defaultDispatcher) {
            val authState = tokenManager?.getAuthState() ?: return@withContext null

            val config = getConfiguration()

            val conn: HttpURLConnection = config.discoveryDoc?.userinfoEndpoint.let {
                if (it == null) {
                    return@withContext null
                }
                getConnectionBuilder().openConnection(it)
            }

            conn.setRequestProperty("Authorization", "Bearer ${authState.accessToken}")
            conn.instanceFollowRedirects = false

            json.decodeFromStream<UserInfo>(conn.inputStream)
        }
    }

    /**
     * Log out the user.
     *
     * @param completedIntent The PendingIntent to be used when the logout process is completed.
     * @param options The options for the logout request. Default is null.
     */
    suspend fun logout(
        completedIntent: Intent,
        options: OAuthLogoutOptions? = null
    ) {
        return logout(completedIntent, null, options)
    }

    /**
     * Log out the user.
     *
     * @param completedIntent The PendingIntent to be used when the logout process is completed.
     * @param cancelIntent The PendingIntent to be used when the logout process is cancelled. Default is null.
     * @param options The options for the logout request. Default is null.
     */
    suspend fun logout(
        completedIntent: Intent,
        cancelIntent: Intent? = null,
        options: OAuthLogoutOptions? = null
    ) {
        val authState = tokenManager?.getAuthState() ?: return

        AuthenticationManager.clearState()

        val config = getConfiguration()

        val logoutRequestBuilder = EndSessionRequest.Builder(
            config
        )
            .setIdTokenHint(authState.idToken)
            .setPostLogoutRedirectUri(Uri.parse(options?.postLogoutRedirectUri ?: "io.fusionauth.app:/oauth2redirect"))
            .setAdditionalParameters(
                mapOf(
                    "client_id" to clientId,
                    "tenantId" to tenantId
                )
            )

        options?.state?.let { logoutRequestBuilder.setState(it) }

        val completedPendingIntent = PendingIntent.getActivity(
            context,
            0,
            Intent(completedIntent).also {
                if (options?.state != null) it.putExtra(EXTRA_STATE, options.state)
            },
            PendingIntent.FLAG_MUTABLE
        )

        val logoutRequest = logoutRequestBuilder.build()

        val authService = getAuthorizationService()
        if (cancelIntent == null) {
            authService.performEndSessionRequest(
                logoutRequest,
                completedPendingIntent,
            )
            return
        }
        authService.performEndSessionRequest(
            logoutRequest,
            completedPendingIntent,
            PendingIntent.getActivity(
                context,
                0,
                cancelIntent
                    .putExtra(EXTRA_FAILED, true),
                PendingIntent.FLAG_MUTABLE
            ),
        )
    }

    /**
     * Performs a token request to the authorization service using the given response and exception.
     *
     * @param response The authorization response received from the authorization process.
     * @param ex The authorization exception received from the authorization process, or null if no exception occurred.
     * @return The token response from the authorization service.
     */
    private suspend fun performTokenRequest(
        response: AuthorizationResponse,
        ex: AuthorizationException?
    ): TokenResponse {
        return suspendCoroutine { continuation ->
            val authService = getAuthorizationService()

            appAuthState.update(response, ex)

            authService.performTokenRequest(
                response.createTokenExchangeRequest(),
                appAuthState.clientAuthentication
            ) { tokenResponse, exception ->
                appAuthState.update(tokenResponse, exception)
                if (tokenResponse != null) {
                    continuation.resume(tokenResponse)
                } else {
                    continuation.resumeWithException(exception?.let { AuthenticationException(it) }
                        ?: AuthenticationException("Unknown error"))
                }
            }
        }
    }

    /**
     * Retrieves the [AuthorizationServiceConfiguration].
     *
     * @param force Boolean value indicating whether to force fetching a new configuration, even if it already exists.
     *              Default value is false.
     * @return The [AuthorizationServiceConfiguration] object.
     */
    private suspend fun getConfiguration(force: Boolean = false): AuthorizationServiceConfiguration {
        if (!force) {
            val config = authenticationConfiguration.get()
            if (config != null) {
                return config
            }
        }

        val uriBuilder = Uri.parse(fusionAuthUrl).buildUpon()

        // If tenant is specified, append it to the URL
        // See https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#openid-configuration
        if (tenantId != null) uriBuilder.appendPath(tenantId)

        uriBuilder.appendPath(AuthorizationServiceConfiguration.WELL_KNOWN_PATH)
            .appendPath(AuthorizationServiceConfiguration.OPENID_CONFIGURATION_RESOURCE)

        return suspendCoroutine { continuation ->
            AuthorizationServiceConfiguration.fetchFromUrl(
                uriBuilder.build(),
                { configuration, ex ->
                    if (configuration != null) {
                        authenticationConfiguration.set(configuration)
                        continuation.resume(configuration)
                    } else {
                        continuation.resumeWithException(ex?.let { AuthenticationException(it) }
                            ?: AuthenticationException("Unknown error"))
                    }
                },
                getConnectionBuilder(),
            )
        }
    }

    /**
     * Retrieves a fresh access token.
     *
     * @return the fresh access token or null if an error occurs
     * @throws AuthenticationException if the refresh token is not available or an unknown error occurs
     */
    suspend fun freshAccessToken(): String? {
        val config = getConfiguration()

        return suspendCoroutine {
            val authService = getAuthorizationService()

            val refreshToken = tokenManager?.getAuthState()?.refreshToken
            if (refreshToken == null) {
                it.resumeWithException(AuthenticationException("No refresh token available"))
                return@suspendCoroutine
            }

            authService.performTokenRequest(
                TokenRequest.Builder(
                    config,
                    clientId
                )
                    .setGrantType(GrantTypeValues.REFRESH_TOKEN)
                    .setRefreshToken(refreshToken)
                    .build(),
                appAuthState.clientAuthentication
            ) { response, exception ->
                if (response != null) {
                    val authState = tokenManager?.getAuthState()
                    if (authState != null) {
                        val newAuthState = authState.copy(
                            accessToken = response.accessToken,
                            accessTokenExpirationTime = response.accessTokenExpirationTime,
                            idToken = response.idToken,
                            refreshToken = response.refreshToken,
                        )
                        tokenManager?.saveAuthState(newAuthState)
                    }
                    it.resume(response.accessToken)
                } else {
                    it.resumeWithException(exception?.let { AuthenticationException(it) }
                        ?: AuthenticationException("Unknown error"))
                }
            }
        }
    }

    /**
     * Returns the appropriate ConnectionBuilder based on the value of allowUnsecureConnection.
     *
     * @return The ConnectionBuilder object to be used for creating connections.
     */
    private fun getConnectionBuilder(): ConnectionBuilder {
        return if (allowUnsecureConnection) SingletonUnsecureConnectionBuilder else DefaultConnectionBuilder.INSTANCE
    }

    /**
     * Retrieves the authorization service used for OAuth authentication.
     *
     * @return The authorization service instance.
     */
    private fun getAuthorizationService(): AuthorizationService {
        return AuthorizationService(
            context, AppAuthConfiguration.Builder()
                .setConnectionBuilder(getConnectionBuilder())
                .setSkipIssuerHttpsCheck(allowUnsecureConnection)
                .build()
        )
    }

    /**
     * Internal AppAuthState
     */
    private val appAuthState: AuthState
        get() {
            var authState = this.authState.get()
            if (authState != null) {
                return authState
            }

            authState = AuthState()
            this.authState.set(authState)
            return authState
        }

    /**
     * This property represents the scopes used for OAuth authentication.
     */
    private val scopes: String
        get() = setOf("openid", "offline_access").union(additionalScopes).joinToString(" ")

    companion object {
        private const val EXTRA_STATE: String = "_fusionauth_mobile_sdk_state"
        private const val EXTRA_FAILED: String = "_fusionauth_mobile_sdk_failed"
    }

}
