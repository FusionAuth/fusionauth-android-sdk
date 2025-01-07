package io.fusionauth.mobilesdk.oauth

import android.content.Intent

/**
 * OAuthAuthorizeOptions is a data class that represents the options for the OAuth authorize request.
 *
 * See [FusionAuth OAuth 2.0 Authorization Endpoint](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#authorize)
 * for more information.
 */
data class OAuthAuthorizeOptions(
    /**
     * The redirect URI to be used for the OAuth authorize request.
     * Default is "io.fusionauth.app:/oauth2redirect".
     */
    val redirectUri: String = "io.fusionauth.app:/oauth2redirect",
    /**
     * The identity provider hint to be used for the OAuth authorize request.
     */
    val idpHint: String? = null,
    /**
     * An optional email address or top level domain that can allow you to bypass the FusionAuth login
     * page when using managed domains.
     */
    val loginHint: String? = null,
    /**
     * An optional human-readable description of the device used during login.
     */
    val deviceDescription: String? = null,
    /**
     * When this parameter is provided during the Authorization request, the value will be returned in the id_token.
     */
    val nonce: String? = null,
    // val responseMode: String? = null,
    // val responseType: String? = null,
    /**
     * An opaque value used by the client to maintain state between the request and callback. The
     * authorization server includes this value when redirecting the user-agent back to the client.
     */
    val state: String? = null,
    /**
     * The end-user verification code.
     */
    val userCode: String? = null,
    /**
     * An optional intent to be used when the user cancels the OAuth authorize request.
     */
    val cancelIntent: Intent? = null,
)
