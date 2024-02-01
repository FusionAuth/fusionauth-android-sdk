package io.fusionauth.mobilesdk

import io.fusionauth.mobilesdk.storage.Storage
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.decodeFromHexString
import kotlinx.serialization.encodeToHexString

@OptIn(ExperimentalSerializationApi::class)
class TokenManager {
    private var storage: Storage? = null

    fun withStorage(storage: Storage): TokenManager {
        this.storage = storage
        return this
    }

    fun getAuthState(): AuthState? {
        return this.storage?.get("authState")?.let { authState ->
            return Cbor.decodeFromHexString<AuthState>(authState)
        }
    }

    fun saveAuthState(authState: AuthState) {
        this.storage?.set("authState", Cbor.encodeToHexString(authState))
    }

    fun clearAuthState() {
        this.storage?.remove("authState")
    }
}
