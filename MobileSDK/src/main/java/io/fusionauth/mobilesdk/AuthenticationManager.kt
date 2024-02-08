package io.fusionauth.mobilesdk

import android.content.Context
import io.fusionauth.mobilesdk.storage.MemoryStorage
import io.fusionauth.mobilesdk.storage.Storage
import kotlinx.serialization.json.Json

object AuthenticationManager {
    private val isUserAuthenticated: Boolean? = null
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

    fun oAuth(context: Context): OAuthAuthenticationService {
        return OAuthAuthenticationService(
            context = context,
            fusionAuthUrl = configuration.fusionAuthUrl,
            clientId = configuration.clientId,
            tenant = configuration.tenant,
            tokenManager = tokenManager,
            allowUnsecureConnection = configuration.allowUnsecureConnection,
        )
    }

    fun getAccessToken(): String? {
        return tokenManager.getAuthState()?.accessToken
    }

    fun getAccessTokenExpirationTime(): Long? {
        return tokenManager.getAuthState()?.accessTokenExpirationTime
    }

    fun isAccessTokenExpired(): Boolean {
        return tokenManager.getAuthState()?.accessTokenExpirationTime?.let {
            it < System.currentTimeMillis()
        } ?: true
    }

    fun getIdToken(): String? {
        return tokenManager.getAuthState()?.idToken
    }

    fun dispose() {
        // TODO: Implement
    }

    fun getParsedIdToken(): IdToken? {
        return tokenManager.getAuthState()?.idToken?.let {
            Json.decodeFromString<IdToken>(it)
        }
    }

    fun clearState() {
        tokenManager.clearAuthState()
    }

}
