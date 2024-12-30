//[library](../../../index.md)/[io.fusionauth.mobilesdk.oauth](../index.md)/[OAuthAuthorizeOptions](index.md)

# OAuthAuthorizeOptions

[androidJvm]\
data class [OAuthAuthorizeOptions](index.md)(val redirectUri: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;io.fusionauth.app:/oauth2redirect&quot;, val idpHint: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val loginHint: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val deviceDescription: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val nonce: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val state: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val userCode: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val cancelIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)? = null)

OAuthAuthorizeOptions is a data class that represents the options for the OAuth authorize request.

See [FusionAuth OAuth 2.0 Authorization Endpoint](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#authorize) for more information.

## Constructors

| | |
|---|---|
| [OAuthAuthorizeOptions](-o-auth-authorize-options.md) | [androidJvm]<br>constructor(redirectUri: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;io.fusionauth.app:/oauth2redirect&quot;, idpHint: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, loginHint: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, deviceDescription: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, nonce: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, state: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, userCode: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, cancelIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [cancelIntent](cancel-intent.md) | [androidJvm]<br>val [cancelIntent](cancel-intent.md): [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)? = null<br>An optional intent to be used when the user cancels the OAuth authorize request. |
| [deviceDescription](device-description.md) | [androidJvm]<br>val [deviceDescription](device-description.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>An optional human-readable description of the device used during login. |
| [idpHint](idp-hint.md) | [androidJvm]<br>val [idpHint](idp-hint.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The identity provider hint to be used for the OAuth authorize request. |
| [loginHint](login-hint.md) | [androidJvm]<br>val [loginHint](login-hint.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>An optional email address or top level domain that can allow you to bypass the FusionAuth login     page when using managed domains. |
| [nonce](nonce.md) | [androidJvm]<br>val [nonce](nonce.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>When this parameter is provided during the Authorization request, the value will be returned in the     id_token. |
| [redirectUri](redirect-uri.md) | [androidJvm]<br>val [redirectUri](redirect-uri.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The redirect URI to be used for the OAuth authorize request.     Default is &quot;io.fusionauth.app:/oauth2redirect&quot;. |
| [state](state.md) | [androidJvm]<br>val [state](state.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>An opaque value used by the client to maintain state between the request and callback. The     authorization server includes this value when redirecting the user-agent back to the client. |
| [userCode](user-code.md) | [androidJvm]<br>val [userCode](user-code.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The end-user verification code. |