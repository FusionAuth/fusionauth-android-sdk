package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable

@Serializable
data class FusionAuthState(
    var accessToken: String? = null,
    var accessTokenExpirationTime: Long? = null,
    val idToken: String?,
)