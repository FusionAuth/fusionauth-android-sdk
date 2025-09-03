package io.fusionauth.mobilesdk

import android.content.Context
import io.fusionauth.mobilesdk.exceptions.AuthorizationException
import io.fusionauth.mobilesdk.oauth.OAuthAuthorizationService
import io.fusionauth.mobilesdk.storage.MemoryStorage
import io.fusionauth.mobilesdk.storage.Storage
import kotlinx.serialization.json.Json
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

/**
 * AuthorizationManager is a singleton object that manages the authorization state of the user.
 * It provides methods to initialize the authorization manager, check if the user is authenticated,
 * retrieve access tokens, refresh access tokens, and clear the authorization state.
 *
 * AuthorizationManager uses a TokenManager to manage the access tokens and a Storage implementation
 * to store the authorization state.
 *
 * @see TokenManager
 * @see Storage
 * @see AuthorizationConfiguration
 */
@Suppress("TooManyFunctions", "unused", "MemberVisibilityCanBePrivate")
object AuthorizationManager {
    private const val JWT_PARTS = 3
    private val json = Json { ignoreUnknownKeys = true }
    private var tokenManager: TokenManager
    private lateinit var storage: Storage
    private lateinit var configuration: AuthorizationConfiguration
    private var isInitialized = false

    /**
     * Initializes the storage and token manager for the application.
     */
    init {
        tokenManager = TokenManager()
        if (::storage.isInitialized) {
            tokenManager.withStorage(storage)
        } else {
            tokenManager.withStorage(MemoryStorage())
        }
    }

    /**
     * Initializes the authorization manager with the given configuration and optional storage.
     *
     * @param configuration The authorization configuration to be used.
     * @param storage The storage implementation to be used for storing data. (Optional)
     */
    @Synchronized
    fun initialize(configuration: AuthorizationConfiguration, storage: Storage? = null) {
        this.configuration = configuration
        this.storage = storage ?: MemoryStorage()
        this.tokenManager = tokenManager.withStorage(this.storage)
        isInitialized = true
    }

    /**
     * Checks if the user is authenticated.
     *
     * @return true if the user is authenticated, false otherwise
     */
    fun isAuthenticated(): Boolean {
        ensureInitialized()
        return !isAccessTokenExpired()
    }

    /**
     * Creates an instance of the [OAuthAuthorizationService] using the provided [context].
     *
     * @param context The application context.
     * @return An instance of the [OAuthAuthorizationService].
     */
    fun oAuth(context: Context): OAuthAuthorizationService {
        return OAuthAuthorizationService(
            context = context,
            fusionAuthUrl = configuration.fusionAuthUrl,
            clientId = configuration.clientId,
            tenantId = configuration.tenant,
            tokenManager = tokenManager,
            allowUnsecureConnection = configuration.allowUnsecureConnection,
            additionalScopes = configuration.additionalScopes,
            locale = configuration.locale
        )
    }

    /**
     * Retrieves a fresh access token.
     *
     * If the current access token is not expired, it will be returned. Otherwise, a fresh access token will be
     * obtained using the refresh token.
     *
     * @param context The application context.
     * @param force Flag indicating whether to force obtaining a fresh access token even if the current one is not
     *              expired.
     * @return The fresh access token or null if an error occurs.
     */
    suspend fun freshAccessToken(context: Context, force: Boolean = false): String? {
        if (!force && !isAccessTokenExpired()) return getAccessToken()

        val oAuth = oAuth(context)
        return oAuth.freshAccessToken()
    }

    /**
     * Retrieves the access token from the token manager.
     *
     * @return The access token string or null if not available.
     */
    fun getAccessToken(): String? {
        return tokenManager.getAuthState()?.accessToken
    }

    /**
     * Retrieves the expiration time of the access token.
     *
     * @return The expiration time of the access token, or null if the token manager is not set or the access token is
     * not available.
     */
    fun getAccessTokenExpirationTime(): Long? {
        return tokenManager.getAuthState()?.accessTokenExpirationTime
    }

    /**
     * Checks if the access token is expired.
     *
     * @return true if the access token is expired, false otherwise.
     */
    fun isAccessTokenExpired(): Boolean {
        return getAccessTokenExpirationTime()?.let {
            it < System.currentTimeMillis()
        } ?: true
    }

    /**
     * Retrieves the ID token associated with the authenticated user.
     *
     * @return The ID token string, or null if the user is not authenticated.
     */
    fun getIdToken(): String? {
        return tokenManager.getAuthState()?.idToken
    }

    /**
     * Clears the state of the authorization manager.
     */
    fun dispose() {
        // Clear the state
    }

    /**
     * Retrieves and parses the ID token from the token manager.
     *
     * @return The parsed ID token, or null if it cannot be parsed.
     */
    @OptIn(ExperimentalEncodingApi::class)
    fun getParsedIdToken(): IdToken? {
        return tokenManager.getAuthState()?.idToken?.let {
            val parts = it.split(".")
            require(parts.size == JWT_PARTS) { "Invalid JWT token" }
            json.decodeFromString<IdToken>(Base64.UrlSafe.decode(parts[1]).decodeToString())
        }
    }

    /**
     * Clears the state of the authorization.
     *
     * This method clears the authorization state by removing the "authState" key from the storage.
     */
    fun clearState() {
        tokenManager.clearAuthState()
    }

    /**
     * Reset the configuration.
     *
     * @param configuration The authorization configuration to be used.
     */
    @Synchronized
    fun resetConfiguration(configuration: AuthorizationConfiguration) {
        ensureInitialized()
        this.configuration = configuration
    }

    /**
     * Retrieves the initialization status of the AuthorizationManager.
     *
     * @return true if the AuthorizationManager is initialized, false otherwise.
     */
    fun getIsInitialized(): Boolean {
        return isInitialized
    }

    /**
     * Sets the initialization status of the AuthorizationManager.
     *
     * @param isInitialized A boolean value indicating whether the AuthorizationManager is initialized.
     */
    internal fun setIsInitialized(isInitialized: Boolean) {
        this.isInitialized = isInitialized
    }

    internal fun getConfiguration(): AuthorizationConfiguration {
        ensureInitialized()
        return configuration
    }

    private fun ensureInitialized() {
        if (!isInitialized) {
            throw AuthorizationException("AuthorizationManager must be initialized by calling initialize() first.")
        }
    }
}
