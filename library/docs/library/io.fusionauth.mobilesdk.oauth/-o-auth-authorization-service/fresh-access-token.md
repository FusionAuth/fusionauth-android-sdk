//[library](../../../index.md)/[io.fusionauth.mobilesdk.oauth](../index.md)/[OAuthAuthorizationService](index.md)/[freshAccessToken](fresh-access-token.md)

# freshAccessToken

[androidJvm]\
suspend fun [freshAccessToken](fresh-access-token.md)(): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?

Retrieves a fresh access token.

#### Return

the fresh access token or null if an error occurs

#### Throws

| | |
|---|---|
| [AuthorizationException](../../io.fusionauth.mobilesdk.exceptions/-authorization-exception/index.md) | if the refresh token is not available or an unknown error occurs |