package io.fusionauth.mobilesdk

import io.fusionauth.mobilesdk.exceptions.StorageException
import io.fusionauth.mobilesdk.storage.Storage
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerializationException
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.decodeFromHexString
import kotlinx.serialization.encodeToHexString
import java.util.concurrent.atomic.AtomicReference

/**
 * The TokenManager class handles the storage and retrieval of authorization state tokens.
 *
 * @constructor Creates a TokenManager instance.
 */
@OptIn(ExperimentalSerializationApi::class)
class TokenManager {
    private var storage: Storage? = null

    private val authState = AtomicReference<FusionAuthState?>()

    /**
     * Sets the storage implementation to be used for storing data in the TokenManager.
     *
     * @param storage The storage implementation to be used.
     * @return The TokenManager instance with the updated storage.
     * @see Storage
     */
    fun withStorage(storage: Storage): TokenManager {
        this.storage = storage
        return this
    }

    /**
     * Retrieves the authorization state from the storage.
     *
     * @return The authorization state if available, or null if not present or unable to decode from storage.
     * @throws StorageException if an error occurs while decoding the authorization state.
     */
    @Suppress("TooGenericExceptionCaught")
    fun getAuthState(): FusionAuthState? {
        if (this.authState.get() != null) {
            return this.authState.get()
        }

        return this.storage?.get("authState")?.let { authState ->
            try {
                Cbor.decodeFromHexString<FusionAuthState>(authState)
            } catch (e: Exception) {
                when (e) {
                    is SerializationException, is IllegalArgumentException -> throw StorageException.unableToDecode(e)
                    else -> throw e
                }
            }
        }
    }

    /**
     * Saves the authorization state to the storage.
     *
     * @param authState The authorization state to be saved.
     * @throws NullPointerException if `storage` is null.
     */
    fun saveAuthState(authState: FusionAuthState) {
        if (this.storage == null) throw StorageException.notSet()

        this.authState.set(authState)
        this.storage?.set("authState", Cbor.encodeToHexString(authState))
    }

    /**
     * Clears the authorization state by removing the "authState" key from the storage.
     *
     * @throws StorageException if the storage implementation is not set.
     */
    fun clearAuthState() {
        if (this.storage == null) throw StorageException.notSet()

        this.authState.set(null)
        this.storage?.remove("authState")
    }
}
