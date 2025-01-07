package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable

/**
 * Represents the user information retrieved from the authorization service.
 * More information about the user info can be found in the
 * [FusionAuth documentation](https://fusionauth.io/docs/lifecycle/authenticate-users/oauth/endpoints#userinfo)
 */
@Suppress("PropertyName", "ConstructorParameterNaming")
@Serializable
data class UserInfo(
    /**
     * The ID of the application.
     */
    val applicationId: String? = null,
    /**
     * The user's birthdate.
     */
    val birthdate: String? = null,
    /**
     * The user's email address.
     */
    val email: String? = null,
    /**
     * Indicates if the user's email address has been verified.
     */
    val email_verified: Boolean? = null,
    /**
     * The user's family name.
     */
    val family_name: String? = null,
    /**
     * The user's given name.
     */
    val given_name: String? = null,
    /**
     * The user's full name.
     */
    val name: String? = null,
    /**
     * The user's middle name.
     */
    val middle_name: String? = null,
    /**
     * The user's phone number.
     */
    val phone_number: String? = null,
    /**
     * The URL of the user's profile picture.
     */
    val picture: String? = null,
    /**
     * The user's preferred username.
     */
    val preferred_username: String? = null,
    /**
     * The roles the user is assigned to.
     */
    val roles: List<String>? = null,
    /**
     * The subject identifier of the user.
     */
    val sub: String,
)
