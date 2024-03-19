//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[AuthorizationManager](index.md)/[freshAccessToken](fresh-access-token.md)

# freshAccessToken

[androidJvm]\
suspend fun [freshAccessToken](fresh-access-token.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), force: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?

Retrieves a fresh access token.

If the current access token is not expired, it will be returned. Otherwise, a fresh access token will be obtained using the refresh token.

#### Return

The fresh access token or null if an error occurs.

#### Parameters

androidJvm

| | |
|---|---|
| context | The application context. |
| force | Flag indicating whether to force obtaining a fresh access token even if the current one is not     expired. |
