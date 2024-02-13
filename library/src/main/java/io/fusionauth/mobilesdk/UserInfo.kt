package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable

/**
 * Represents the user information retrieved from the authentication service.
 * More information about the user info can be found in the
 * [FusionAuth documentation](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#userinfo)
 *
 * @property applicationId The ID of the application.
 * @property birthdate The user's birthdate.
 * @property email The user's email address.
 * @property email_verified Indicates if the user's email address has been verified.
 * @property family_name The user's family name.
 * @property given_name The user's given name.
 * @property name The user's full name.
 * @property middle_name The user's middle name.
 * @property phone_number The user's phone number.
 * @property picture The URL of the user's profile picture.
 * @property preferred_username The user's preferred username.
 * @property roles The roles the user is assigned to.
 * @property sub The subject identifier of the user.
 */
@Suppress("PropertyName", "ConstructorParameterNaming")
@Serializable
data class UserInfo(
    val applicationId: String? = null,
    val birthdate: String? = null,
    val email: String? = null,
    val email_verified: Boolean,
    val family_name: String? = null,
    val given_name: String? = null,
    val name: String? = null,
    val middle_name: String? = null,
    val phone_number: String? = null,
    val picture: String? = null,
    val preferred_username: String? = null,
    val roles: List<String>? = null,
    val sub: String,
)
