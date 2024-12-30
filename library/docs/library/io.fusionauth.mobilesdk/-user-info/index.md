//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[UserInfo](index.md)

# UserInfo

[androidJvm]\
@Serializable

data class [UserInfo](index.md)(val applicationId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val birthdate: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val email: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val email_verified: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null, val family_name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val given_name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val middle_name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val phone_number: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val picture: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val preferred_username: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val roles: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;? = null, val sub: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))

Represents the user information retrieved from the authorization service. More information about the user info can be found in the [FusionAuth documentation](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#userinfo)

## Constructors

| | |
|---|---|
| [UserInfo](-user-info.md) | [androidJvm]<br>constructor(applicationId: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, birthdate: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, email: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, email_verified: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null, family_name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, given_name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, middle_name: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, phone_number: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, picture: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, preferred_username: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, roles: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;? = null, sub: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [applicationId](application-id.md) | [androidJvm]<br>val [applicationId](application-id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The ID of the application. |
| [birthdate](birthdate.md) | [androidJvm]<br>val [birthdate](birthdate.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The user's birthdate. |
| [email](email.md) | [androidJvm]<br>val [email](email.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The user's email address. |
| [email_verified](email_verified.md) | [androidJvm]<br>val [email_verified](email_verified.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null<br>Indicates if the user's email address has been verified. |
| [family_name](family_name.md) | [androidJvm]<br>val [family_name](family_name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The user's family name. |
| [given_name](given_name.md) | [androidJvm]<br>val [given_name](given_name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The user's given name. |
| [middle_name](middle_name.md) | [androidJvm]<br>val [middle_name](middle_name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The user's middle name. |
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The user's full name. |
| [phone_number](phone_number.md) | [androidJvm]<br>val [phone_number](phone_number.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The user's phone number. |
| [picture](picture.md) | [androidJvm]<br>val [picture](picture.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The URL of the user's profile picture. |
| [preferred_username](preferred_username.md) | [androidJvm]<br>val [preferred_username](preferred_username.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>The user's preferred username. |
| [roles](roles.md) | [androidJvm]<br>val [roles](roles.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)&gt;? = null<br>The roles the user is assigned to. |
| [sub](sub.md) | [androidJvm]<br>val [sub](sub.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>The subject identifier of the user. |