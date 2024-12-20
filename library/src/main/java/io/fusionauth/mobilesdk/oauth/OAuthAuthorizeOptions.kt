package io.fusionauth.mobilesdk.oauth

import android.content.Intent

/**
 * OAuthAuthorizeOptions is a data class that represents the options for the OAuth authorize request.
 *
 * See [FusionAuth OAuth 2.0 Authorization Endpoint](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#authorize)
 * for more information.
 *
 * @property redirectUri The redirect URI to be used for the OAuth authorize request.
 *                       Default is "io.fusionauth.app:/oauth2redirect".
 * @property idpHint The identity provider hint to be used for the OAuth authorize request.
 * @property loginHint An optional email address or top level domain that can allow you to bypass the FusionAuth login
 *                     page when using managed domains.
 * @property deviceDescription An optional human-readable description of the device used during login.
 * @property nonce When this parameter is provided during the Authorization request, the value will be returned in the
 *                 id_token.
 * @property state An opaque value used by the client to maintain state between the request and callback. The
 *                 authorization server includes this value when redirecting the user-agent back to the client.
 * @property userCode The end-user verification code.
 * @property cancelIntent An optional intent to be used when the user cancels the OAuth authorize request.
 */
data class OAuthAuthorizeOptions(
    val redirectUri: String = "io.fusionauth.app:/oauth2redirect",
    val idpHint: String? = null,
    val loginHint: String? = null,
    val deviceDescription: String? = null,
    val nonce: String? = null,
    // val responseMode: String? = null,
    // val responseType: String? = null,
    val state: String? = null,
    val userCode: String? = null,
    val cancelIntent: Intent? = null,
)
