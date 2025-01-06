//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[AuthorizationConfiguration](index.md)

# AuthorizationConfiguration

[androidJvm]\
@Serializable

data class [AuthorizationConfiguration](index.md)(val clientId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val fusionAuthUrl: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), val tenant: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val allowUnsecureConnection: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, val additionalScopes: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; = emptySet(), val locale: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null)

AuthorizationConfiguration is a data class that represents the configuration for authorization.

Make sure that the issuer URL issuer of the FusionAuth Application configuration is a valid URL including http/https which is validated while generating the AuthorizationServiceConfiguration object.

## Constructors

| | |
|---|---|
| [AuthorizationConfiguration](-authorization-configuration.md) | [androidJvm]<br>constructor(clientId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), fusionAuthUrl: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), tenant: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, allowUnsecureConnection: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false, additionalScopes: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt; = emptySet(), locale: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [additionalScopes](additional-scopes.md) | [androidJvm]<br>val [additionalScopes](additional-scopes.md): [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;<br>Additional scopes to be requested during authorization. Default is empty. |
| [allowUnsecureConnection](allow-unsecure-connection.md) | [androidJvm]<br>val [allowUnsecureConnection](allow-unsecure-connection.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html) = false<br>Flag to allow unsecure connections. Default is false. |
| [clientId](client-id.md) | [androidJvm]<br>val [clientId](client-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The client ID used for authorization. |
| [fusionAuthUrl](fusion-auth-url.md) | [androidJvm]<br>val [fusionAuthUrl](fusion-auth-url.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The URL of the FusionAuth server. |
| [locale](locale.md) | [androidJvm]<br>val [locale](locale.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The locale to be used for authorization. (Optional) |
| [tenant](tenant.md) | [androidJvm]<br>val [tenant](tenant.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The tenant ID for the FusionAuth server. (Optional) |

## Functions

| Name | Summary |
|---|---|
| [withAdditionalScopes](with-additional-scopes.md) | [androidJvm]<br>fun [withAdditionalScopes](with-additional-scopes.md)(scopes: [Set](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-set/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;): [AuthorizationConfiguration](index.md) |