package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable

/**
 * Represents the state of FusionAuth authorization.
 *
 * @property accessToken The access token string.
 * @property accessTokenExpirationTime The expiration time of the access token.
 * @property idToken The ID token string.
 * @property refreshToken The refresh token string.
 */
@Serializable
data class FusionAuthState(
    var accessToken: String? = null,
    var accessTokenExpirationTime: Long? = null,
    val idToken: String?,
    val refreshToken: String?,
)
