package io.fusionauth.mobilesdk.oauth

import android.content.Intent

/**
 * OAuthLogoutOptions is a data class that represents the options for the OAuth logout request.
 *
 * See [FusionAuth OAuth 2.0 Logout Endpoint](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#logout)
 * for more information.
 */
data class OAuthLogoutOptions(
    /**
     * The post logout redirect URI to be used for the OAuth logout request.
     */
    val postLogoutRedirectUri: String = "io.fusionauth.app:/oauth2redirect",
    /**
     * An opaque value used by the client to maintain state between the request and callback. The
     * authorization server includes this value when redirecting the user-agent back to the client.
     */
    val state: String? = null,
    /**
     * An optional intent to be used when the user cancels the OAuth logout request.
     */
    val cancelIntent: Intent? = null,
)
