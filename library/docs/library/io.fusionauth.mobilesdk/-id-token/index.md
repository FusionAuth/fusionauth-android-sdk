//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[IdToken](index.md)

# IdToken

[androidJvm]\
data class [IdToken](index.md)(val at_hash: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val aud: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val authenticationType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val auth_time: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val c_hash: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val email_verified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, val exp: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val iat: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val iss: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val jti: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val nonce: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val preferred_username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val sid: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val sub: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)? = null, val tid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)? = null)

Represents an ID token.

## Constructors

| | |
|---|---|
| [IdToken](-id-token.md) | [androidJvm]<br>constructor(at_hash: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, aud: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, authenticationType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, auth_time: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, c_hash: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, email_verified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, exp: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, iat: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, iss: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, jti: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, nonce: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, preferred_username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, sid: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, sub: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)? = null, tid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [at_hash](at_hash.md) | [androidJvm]<br>val [at_hash](at_hash.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The access token hash. |
| [aud](aud.md) | [androidJvm]<br>val [aud](aud.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The audience. |
| [auth_time](auth_time.md) | [androidJvm]<br>val [auth_time](auth_time.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null<br>The authentication time. |
| [authenticationType](authentication-type.md) | [androidJvm]<br>val [authenticationType](authentication-type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The authentication type. |
| [c_hash](c_hash.md) | [androidJvm]<br>val [c_hash](c_hash.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The code hash. |
| [email](email.md) | [androidJvm]<br>val [email](email.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The user's email address. |
| [email_verified](email_verified.md) | [androidJvm]<br>val [email_verified](email_verified.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null<br>Indicates whether the user's email address has been verified. |
| [exp](exp.md) | [androidJvm]<br>val [exp](exp.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null<br>The expiration time. |
| [iat](iat.md) | [androidJvm]<br>val [iat](iat.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null<br>The issued at time. |
| [iss](iss.md) | [androidJvm]<br>val [iss](iss.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The issuer. |
| [jti](jti.md) | [androidJvm]<br>val [jti](jti.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The JSON token identifier. |
| [nonce](nonce.md) | [androidJvm]<br>val [nonce](nonce.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The nonce. |
| [preferred_username](preferred_username.md) | [androidJvm]<br>val [preferred_username](preferred_username.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The preferred username. |
| [sid](sid.md) | [androidJvm]<br>val [sid](sid.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null<br>The session identifier. |
| [sub](sub.md) | [androidJvm]<br>val [sub](sub.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)? = null<br>The subject identifier. |
| [tid](tid.md) | [androidJvm]<br>val [tid](tid.md): [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)? = null<br>The tenant identifier. |
