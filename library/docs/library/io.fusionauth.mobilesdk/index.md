//[library](../../index.md)/[io.fusionauth.mobilesdk](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AuthorizationConfiguration](-authorization-configuration/index.md) | [androidJvm]<br>@Serializable<br>data class [AuthorizationConfiguration](-authorization-configuration/index.md)(val clientId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val fusionAuthUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val tenant: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val allowUnsecureConnection: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val additionalScopes: [Set](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptySet(), val locale: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)<br>AuthorizationConfiguration is a data class that represents the configuration for authorization. |
| [AuthorizationManager](-authorization-manager/index.md) | [androidJvm]<br>object [AuthorizationManager](-authorization-manager/index.md)<br>AuthorizationManager is a singleton object that manages the authorization state of the user. It provides methods to initialize the authorization manager, check if the user is authenticated, retrieve access tokens, refresh access tokens, and clear the authorization state. |
| [FusionAuthState](-fusion-auth-state/index.md) | [androidJvm]<br>@Serializable<br>data class [FusionAuthState](-fusion-auth-state/index.md)(var accessToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, var accessTokenExpirationTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val idToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val refreshToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)<br>Represents the state of FusionAuth authorization. |
| [IdToken](-id-token/index.md) | [androidJvm]<br>data class [IdToken](-id-token/index.md)(val at_hash: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val aud: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val authenticationType: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val auth_time: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val c_hash: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val email_verified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, val exp: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val iat: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val iss: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val jti: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val nonce: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val preferred_username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val sid: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val sub: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)? = null, val tid: [UUID](https://developer.android.com/reference/kotlin/java/util/UUID.html)? = null)<br>Represents an ID token. |
| [SingletonUnsecureConnectionBuilder](-singleton-unsecure-connection-builder/index.md) | [androidJvm]<br>object [SingletonUnsecureConnectionBuilder](-singleton-unsecure-connection-builder/index.md) : ConnectionBuilder |
| [TokenManager](-token-manager/index.md) | [androidJvm]<br>class [TokenManager](-token-manager/index.md)<br>The TokenManager class handles the storage and retrieval of authorization state tokens. |
| [UnsecureConnectionBuilder](-unsecure-connection-builder/index.md) | [androidJvm]<br>class [UnsecureConnectionBuilder](-unsecure-connection-builder/index.md) : ConnectionBuilder<br>Connection Builder that allows for unsecure connections. |
| [UserInfo](-user-info/index.md) | [androidJvm]<br>@Serializable<br>data class [UserInfo](-user-info/index.md)(val applicationId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val birthdate: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val email: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val email_verified: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val family_name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val given_name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val middle_name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val phone_number: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val picture: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val preferred_username: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val roles: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, val sub: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Represents the user information retrieved from the authorization service. More information about the user info can be found in the [FusionAuth documentation](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#userinfo) |