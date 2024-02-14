package io.fusionauth.mobilesdk

import android.content.Context
import io.fusionauth.mobilesdk.storage.MemoryStorage
import io.fusionauth.mobilesdk.storage.Storage
import kotlinx.serialization.json.Json

/**
 * AuthenticationManager is a singleton object that manages the authentication state of the user.
 * It provides methods to initialize the authentication manager, check if the user is authenticated,
 * retrieve access tokens, refresh access tokens, and clear the authentication state.
 *
 * AuthenticationManager uses a TokenManager to manage the access tokens and a Storage implementation
 * to store the authentication state.
 *
 * @see TokenManager
 * @see Storage
 * @see AuthenticationConfiguration
 */
@Suppress("TooManyFunctions", "unused", "MemberVisibilityCanBePrivate")
object AuthenticationManager {
    private var tokenManager: TokenManager
    private lateinit var storage: Storage
    private lateinit var configuration: AuthenticationConfiguration

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
     * Initializes the storage and token manager for the application.
     *
     * @param storage The storage implementation to be used for storing data.
     * @see Storage
     */
    fun initStorage(storage: Storage) {
        this.storage = storage
        this.tokenManager = tokenManager.withStorage(storage)
    }

    /**
     * Initializes the authentication manager with the given configuration and optional storage.
     *
     * @param configuration The authentication configuration to be used.
     * @param storage The storage implementation to be used for storing data. (Optional)
     */
    fun initialize(configuration: AuthenticationConfiguration, storage: Storage? = null) {
        this.configuration = configuration
        if (storage != null) {
            initStorage(storage)
        }
    }

    /**
     * Checks if the user is authenticated.
     *
     * @return true if the user is authenticated, false otherwise
     */
    fun isAuthenticated(): Boolean {
        return !isAccessTokenExpired()
    }

    /**
     * Creates an instance of the [OAuthAuthenticationService] using the provided [context].
     *
     * @param context The application context.
     * @return An instance of the [OAuthAuthenticationService].
     */
    fun oAuth(context: Context): OAuthAuthenticationService {
        return OAuthAuthenticationService(
            context = context,
            fusionAuthUrl = configuration.fusionAuthUrl,
            clientId = configuration.clientId,
            tenantId = configuration.tenant,
            tokenManager = tokenManager,
            allowUnsecureConnection = configuration.allowUnsecureConnection,
            additionalScopes = configuration.additionalScopes
        )
    }

    /**
     * Retrieves a fresh access token.
     *
     * @param context The application context.
     * @param force Flag indicating whether to force obtaining a fresh access token even if the current one is not expired. Default is false.
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
     * Clears the state of the authentication manager.
     */
    fun dispose() {
        // Clear the state
    }

    /**
     * Retrieves and parses the ID token from the token manager.
     *
     * @return The parsed ID token, or null if it cannot be parsed.
     */
    fun getParsedIdToken(): IdToken? {
        return tokenManager.getAuthState()?.idToken?.let {
            Json.decodeFromString<IdToken>(it)
        }
    }

    /**
     * Clears the state of the authentication.
     *
     * This method clears the authentication state by removing the "authState" key from the storage.
     */
    fun clearState() {
        tokenManager.clearAuthState()
    }

}
