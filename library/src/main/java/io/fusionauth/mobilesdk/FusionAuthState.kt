package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable

/**
 * Represents the state of FusionAuth authorization.
 */
@Serializable
data class FusionAuthState(
    /**
     * The access token string.
     */
    var accessToken: String? = null,
    /**
     * The expiration time of the access token.
     */
    var accessTokenExpirationTime: Long? = null,
    /**
     * The ID token string.
     */
    val idToken: String?,
    /**
     * The refresh token string.
     */
    val refreshToken: String?,
)
