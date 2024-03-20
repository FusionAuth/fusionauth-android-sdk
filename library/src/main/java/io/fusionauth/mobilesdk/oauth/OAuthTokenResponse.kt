package io.fusionauth.mobilesdk.oauth

import kotlinx.serialization.Serializable

/**
 * Represents the response received from the OAuth token request.
 *
 * See [FusionAuth OAuth Endpoints](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#response-3)
 *
 * @property access_token The access token.
 * @property expires_in The expiration time of the access token in seconds.
 * @property id_token The ID token.
 * @property refresh_token The refresh token.
 * @property refresh_token_id The ID of the refresh token.
 * @property scope The scope of the access token.
 * @property token_type The token type as defined by RFC 6749 Section 7.1. This value will always be Bearer.
 * @property userId The unique Id of the user that has been authenticated.
 */
@Suppress("PropertyName", "ConstructorParameterNaming")
@Serializable
data class OAuthTokenResponse(
    val access_token: String,
    val expires_in: Long,
    val id_token: String,
    val refresh_token: String,
    val refresh_token_id: String,
    val scope: String,
    val token_type: String,
    val userId: String,
)
