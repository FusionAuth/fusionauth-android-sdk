package io.fusionauth.mobilesdk

import java.util.UUID

/**
 * Represents an ID token.
 *
 * @property at_hash The access token hash.
 * @property aud The audience.
 * @property authenticationType The authentication type.
 * @property auth_time The authentication time.
 * @property c_hash The code hash.
 * @property email The user's email address.
 * @property email_verified Indicates whether the user's email address has been verified.
 * @property exp The expiration time.
 * @property iat The issued at time.
 * @property iss The issuer.
 * @property jti The JSON token identifier.
 * @property nonce The nonce.
 * @property preferred_username The preferred username.
 * @property sid The session identifier.
 * @property sub The subject identifier.
 * @property tid The tenant identifier.
 */
@Suppress("PropertyName", "ConstructorParameterNaming")
data class IdToken (
    val at_hash: String? = null,
    val aud: String? = null,
    val authenticationType: String? = null,
    val auth_time: Long? = null,
    val c_hash: String? = null,
    val email: String? = null,
    val email_verified: Boolean? = null,
    val exp: Long? = null,
    val iat: Long? = null,
    val iss: String? = null,
    val jti: String? = null,
    val nonce: String? = null,
    val preferred_username: String? = null,
    val sid: String? = null,
    val sub: UUID? = null,
    val tid: UUID? = null,
)
