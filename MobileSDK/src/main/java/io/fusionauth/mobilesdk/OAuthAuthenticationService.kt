package io.fusionauth.mobilesdk

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import net.openid.appauth.*
import net.openid.appauth.connectivity.ConnectionBuilder
import net.openid.appauth.connectivity.DefaultConnectionBuilder
import java.net.HttpURLConnection
import java.util.logging.Logger
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class OAuthAuthenticationService internal constructor(
    var context: Context,
    var fusionAuthUrl: String,
    var clientId: String,
    var tenant: String?,
    var tokenManager: TokenManager?,
    var allowUnsecureConnection: Boolean = false,
) {

    val json = Json { ignoreUnknownKeys = true }

    suspend fun authorize(completedIntent: PendingIntent, cancelIntent: PendingIntent? = null) {
        return withContext(Dispatchers.IO) {
            val config = getConfiguration()

            val authRequest =
                AuthorizationRequest.Builder(
                    config,
                    clientId,
                    ResponseTypeValues.CODE,
                    Uri.parse("io.fusionauth.app:/oauth2redirect"),
                )
                    .setScope("openid offline_access")
                    .build()

            val authService = getAuthorizationService()
            if (cancelIntent == null) {
                authService.performAuthorizationRequest(
                    authRequest,
                    completedIntent,
                )
                return@withContext;
            }
            authService.performAuthorizationRequest(
                authRequest,
                completedIntent,
                cancelIntent,
            )
        }
    }

    suspend fun handleRedirect(intent: Intent): FusionAuthState {
        return withContext(Dispatchers.IO) {
            val response = AuthorizationResponse.fromIntent(intent)
            val exception = AuthorizationException.fromIntent(intent)

            if (response != null) {
                val tokenResponse = async { performTokenRequest(response, exception) }
                val t = tokenResponse.await()
                val authState = FusionAuthState(
                    accessToken = t.accessToken,
                    accessTokenExpirationTime = t.accessTokenExpirationTime,
                    idToken = t.idToken
                )
                tokenManager?.saveAuthState(authState);
                authState
            } else {
                throw exception!!
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

    @OptIn(ExperimentalSerializationApi::class)
    suspend fun getUserInfo(): UserInfo? {
        return withContext(Dispatchers.IO) {
            val authState = tokenManager?.getAuthState() ?: return@withContext null

            val config = getConfiguration()

            val conn: HttpURLConnection = getConnectionBuilder().openConnection(
                config.discoveryDoc!!.userinfoEndpoint!!
            )
            conn.setRequestProperty("Authorization", "Bearer ${authState!!.accessToken}")
            conn.instanceFollowRedirects = false

            json.decodeFromStream<UserInfo>(conn.inputStream)
        }
    }

    suspend fun logout(completedIntent: PendingIntent, cancelIntent: PendingIntent? = null) {
        return withContext(Dispatchers.IO) {
            val authState = tokenManager?.getAuthState() ?: return@withContext
            Logger.getLogger("OAuthAuthenticationService").info("Logout request: $authState")

            AuthenticationManager.clearState()

            val config = getConfiguration()

            val logoutRequest = EndSessionRequest.Builder(
                config
            )
                .setIdTokenHint(authState.idToken)
                .setPostLogoutRedirectUri(Uri.parse("io.fusionauth.app:/oauth2redirect"))
                .build()

            Logger.getLogger("OAuthAuthenticationService").info("Logout request: $logoutRequest")

            val authService = getAuthorizationService()
            if (cancelIntent == null) {
                authService.performEndSessionRequest(
                    logoutRequest,
                    completedIntent,
                )
                return@withContext
            }
            authService.performEndSessionRequest(
                logoutRequest,
                completedIntent,
                cancelIntent,
            )
        }
    }

    private suspend fun performTokenRequest(
        response: AuthorizationResponse,
        ex: AuthorizationException?
    ): TokenResponse {
        return suspendCoroutine { continuation ->
            val authService = getAuthorizationService()

            val authState = AuthState()
            authState.update(response, ex)

            authService.performTokenRequest(
                response.createTokenExchangeRequest(),
                authState.clientAuthentication
            ) { tokenResponse, exception ->
                if (tokenResponse != null) {
                    continuation.resume(tokenResponse)
                } else {
                    continuation.resumeWithException(exception!!)
                }
            }
        }
    }

    private suspend fun getConfiguration(): AuthorizationServiceConfiguration {
        return suspendCoroutine { continuation ->
            AuthorizationServiceConfiguration.fetchFromIssuer(
                Uri.parse(fusionAuthUrl),
                { configuration, ex ->
                    if (ex != null) {
                        continuation.resumeWithException(ex)
                    } else {
                        continuation.resume(configuration!!)
                    }
                },
                getConnectionBuilder(),
            )
        }
    }

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

}
