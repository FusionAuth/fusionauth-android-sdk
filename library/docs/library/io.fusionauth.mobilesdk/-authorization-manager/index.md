//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[AuthorizationManager](index.md)

# AuthorizationManager

object [AuthorizationManager](index.md)

AuthorizationManager is a singleton object that manages the authorization state of the user. It provides methods to initialize the authorization manager, check if the user is authenticated, retrieve access tokens, refresh access tokens, and clear the authorization state.

AuthorizationManager uses a TokenManager to manage the access tokens and a Storage implementation to store the authorization state.

#### See also

| |
|---|
| [TokenManager](../-token-manager/index.md) |
| [Storage](../../io.fusionauth.mobilesdk.storage/-storage/index.md) |
| [AuthorizationConfiguration](../-authorization-configuration/index.md) |

## Functions

| Name | Summary |
|---|---|
| [clearState](clear-state.md) | [androidJvm]<br>fun [clearState](clear-state.md)()<br>Clears the state of the authorization. |
| [dispose](dispose.md) | [androidJvm]<br>fun [dispose](dispose.md)()<br>Clears the state of the authorization manager. |
| [freshAccessToken](fresh-access-token.md) | [androidJvm]<br>suspend fun [freshAccessToken](fresh-access-token.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), force: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>Retrieves a fresh access token. |
| [getAccessToken](get-access-token.md) | [androidJvm]<br>fun [getAccessToken](get-access-token.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>Retrieves the access token from the token manager. |
| [getAccessTokenExpirationTime](get-access-token-expiration-time.md) | [androidJvm]<br>fun [getAccessTokenExpirationTime](get-access-token-expiration-time.md)(): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)?<br>Retrieves the expiration time of the access token. |
| [getIdToken](get-id-token.md) | [androidJvm]<br>fun [getIdToken](get-id-token.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>Retrieves the ID token associated with the authenticated user. |
| [getParsedIdToken](get-parsed-id-token.md) | [androidJvm]<br>fun [getParsedIdToken](get-parsed-id-token.md)(): [IdToken](../-id-token/index.md)?<br>Retrieves and parses the ID token from the token manager. |
| [initialize](initialize.md) | [androidJvm]<br>fun [initialize](initialize.md)(configuration: [AuthorizationConfiguration](../-authorization-configuration/index.md), storage: [Storage](../../io.fusionauth.mobilesdk.storage/-storage/index.md)? = null)<br>Initializes the authorization manager with the given configuration and optional storage. |
| [isAccessTokenExpired](is-access-token-expired.md) | [androidJvm]<br>fun [isAccessTokenExpired](is-access-token-expired.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the access token is expired. |
| [isAuthenticated](is-authenticated.md) | [androidJvm]<br>fun [isAuthenticated](is-authenticated.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the user is authenticated. |
| [oAuth](o-auth.md) | [androidJvm]<br>fun [oAuth](o-auth.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [OAuthAuthorizationService](../../io.fusionauth.mobilesdk.oauth/-o-auth-authorization-service/index.md)<br>Creates an instance of the [OAuthAuthorizationService](../../io.fusionauth.mobilesdk.oauth/-o-auth-authorization-service/index.md) using the provided [context](o-auth.md). |