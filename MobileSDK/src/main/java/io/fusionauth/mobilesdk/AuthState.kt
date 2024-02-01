package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable

@Serializable
data class AuthState(
    var accessToken: String? = null,
    var accessTokenExpirationTime: Long? = null,
    val idToken: String?,
)