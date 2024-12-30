//[library](../../../index.md)/[io.fusionauth.mobilesdk.oauth](../index.md)/[OAuthAuthorizationService](index.md)

# OAuthAuthorizationService

[androidJvm]\
class [OAuthAuthorizationService](index.md)

OAuthAuthorizationService class is responsible for handling OAuth authorization and authorization process. It provides methods to authorize the user, handle the redirect intent, fetch user information, perform logout, retrieve fresh access token, and get the authorization service.

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [additionalScopes](additional-scopes.md) | [androidJvm]<br>val [additionalScopes](additional-scopes.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;<br>Additional scopes to be requested during authorization. Default is empty. |
| [allowUnsecureConnection](allow-unsecure-connection.md) | [androidJvm]<br>val [allowUnsecureConnection](allow-unsecure-connection.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false<br>Boolean value indicating whether unsecure connections are allowed. |
| [clientId](client-id.md) | [androidJvm]<br>val [clientId](client-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The client ID registered in the FusionAuth server. |
| [context](context.md) | [androidJvm]<br>val [context](context.md): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)<br>The Android application context. |
| [fusionAuthUrl](fusion-auth-url.md) | [androidJvm]<br>val [fusionAuthUrl](fusion-auth-url.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The URL of the FusionAuth server. |
| [locale](locale.md) | [androidJvm]<br>val [locale](locale.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The locale to be used for authorization. Default is null. |
| [tenantId](tenant-id.md) | [androidJvm]<br>val [tenantId](tenant-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>The tenant ID, or null if not applicable. |
| [tokenManager](token-manager.md) | [androidJvm]<br>val [tokenManager](token-manager.md): [TokenManager](../../io.fusionauth.mobilesdk/-token-manager/index.md)?<br>The token manager to handle token storage and retrieval, or null if not used. |

## Functions

| Name | Summary |
|---|---|
| [authorize](authorize.md) | [androidJvm]<br>suspend fun [authorize](authorize.md)(completedIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), options: [OAuthAuthorizeOptions](../-o-auth-authorize-options/index.md)? = null)<br>Authorizes the user using OAuth authorization. |
| [freshAccessToken](fresh-access-token.md) | [androidJvm]<br>suspend fun [freshAccessToken](fresh-access-token.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>Retrieves a fresh access token. |
| [getUserInfo](get-user-info.md) | [androidJvm]<br>suspend fun [getUserInfo](get-user-info.md)(): [UserInfo](../../io.fusionauth.mobilesdk/-user-info/index.md)?<br>Retrieves the user information for the authenticated user. |
| [handleRedirect](handle-redirect.md) | [androidJvm]<br>suspend fun [handleRedirect](handle-redirect.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)): [FusionAuthState](../../io.fusionauth.mobilesdk/-fusion-auth-state/index.md)<br>Handles the redirect intent from the authorization process. |
| [isAuthorized](is-authorized.md) | [androidJvm]<br>fun [isAuthorized](is-authorized.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the authorization process has succeeded by examining the given intent. |
| [isCancelled](is-cancelled.md) | [androidJvm]<br>fun [isCancelled](is-cancelled.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the authorization process has been cancelled by examining the given intent. |
| [isLoggedOut](is-logged-out.md) | [androidJvm]<br>fun [isLoggedOut](is-logged-out.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the logout process has succeeded by examining the given intent. |
| [logout](logout.md) | [androidJvm]<br>suspend fun [logout](logout.md)(completedIntent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html), options: [OAuthLogoutOptions](../-o-auth-logout-options/index.md)? = null)<br>Log out the user. |