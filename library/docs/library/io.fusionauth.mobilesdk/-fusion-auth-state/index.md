//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[FusionAuthState](index.md)

# FusionAuthState

[androidJvm]\
@Serializable

data class [FusionAuthState](index.md)(var accessToken: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, var accessTokenExpirationTime: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)? = null, val idToken: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, val refreshToken: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?)

Represents the state of FusionAuth authorization.

## Constructors

| | |
|---|---|
| [FusionAuthState](-fusion-auth-state.md) | [androidJvm]<br>constructor(accessToken: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, accessTokenExpirationTime: [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)? = null, idToken: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, refreshToken: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [accessToken](access-token.md) | [androidJvm]<br>var [accessToken](access-token.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>The access token string. |
| [accessTokenExpirationTime](access-token-expiration-time.md) | [androidJvm]<br>var [accessTokenExpirationTime](access-token-expiration-time.md): [Long](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-long/index.html)?<br>The expiration time of the access token. |
| [idToken](id-token.md) | [androidJvm]<br>val [idToken](id-token.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>The ID token string. |
| [refreshToken](refresh-token.md) | [androidJvm]<br>val [refreshToken](refresh-token.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>The refresh token string. |