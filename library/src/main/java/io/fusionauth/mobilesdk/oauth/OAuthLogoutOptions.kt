package io.fusionauth.mobilesdk.oauth

import android.content.Intent

/**
 * OAuthLogoutOptions is a data class that represents the options for the OAuth logout request.
 *
 * See [FusionAuth OAuth 2.0 Logout Endpoint](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#logout)
 * for more information.
 *
 * @property postLogoutRedirectUri The post logout redirect URI to be used for the OAuth logout request.
 * @property state An opaque value used by the client to maintain state between the request and callback.
 *                 The authorization server includes this value when redirecting the user-agent back to the client.
 * @property cancelIntent An optional intent to be used when the user cancels the OAuth logout request.
 */
data class OAuthLogoutOptions(
    val postLogoutRedirectUri: String = "io.fusionauth.app:/oauth2redirect",
    val state: String? = null,
    val cancelIntent: Intent? = null,
)
