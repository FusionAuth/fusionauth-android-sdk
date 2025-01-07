//[library](../../../index.md)/[io.fusionauth.mobilesdk.oauth](../index.md)/[OAuthLogoutOptions](index.md)

# OAuthLogoutOptions

[androidJvm]\
data class [OAuthLogoutOptions](index.md)(val postLogoutRedirectUri: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;io.fusionauth.app:/oauth2redirect&quot;, val state: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val cancelIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)? = null)

OAuthLogoutOptions is a data class that represents the options for the OAuth logout request.

See [FusionAuth OAuth 2.0 Logout Endpoint](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#logout) for more information.

## Constructors

| | |
|---|---|
| [OAuthLogoutOptions](-o-auth-logout-options.md) | [androidJvm]<br>constructor(postLogoutRedirectUri: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;io.fusionauth.app:/oauth2redirect&quot;, state: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, cancelIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [cancelIntent](cancel-intent.md) | [androidJvm]<br>val [cancelIntent](cancel-intent.md): [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)? = null<br>An optional intent to be used when the user cancels the OAuth logout request. |
| [postLogoutRedirectUri](post-logout-redirect-uri.md) | [androidJvm]<br>val [postLogoutRedirectUri](post-logout-redirect-uri.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The post logout redirect URI to be used for the OAuth logout request. |
| [state](state.md) | [androidJvm]<br>val [state](state.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>An opaque value used by the client to maintain state between the request and callback. The authorization server includes this value when redirecting the user-agent back to the client. |