package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable

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
