package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable

/**
 * Represents an ID token.
 */
@Serializable
@Suppress("PropertyName", "ConstructorParameterNaming")
data class IdToken(
    /**
     * The access token hash.
     */
    val at_hash: String? = null,
    /**
     * The audience.
     */
    val aud: String? = null,
    /**
     * The authentication type.
     */
    val authenticationType: String? = null,
    /**
     * The authentication time.
     */
    val auth_time: Long? = null,
    /**
     * The code hash.
     */
    val c_hash: String? = null,
    /**
     * The user's email address.
     */
    val email: String? = null,
    /**
     * Indicates whether the user's email address has been verified.
     */
    val email_verified: Boolean? = null,
    /**
     * The expiration time.
     */
    val exp: Long? = null,
    /**
     * The issued at time.
     */
    val iat: Long? = null,
    /**
     * The issuer.
     */
    val iss: String? = null,
    /**
     * The JSON token identifier.
     */
    val jti: String? = null,
    /**
     * The nonce.
     */
    val nonce: String? = null,
    /**
     * The preferred username.
     */
    val preferred_username: String? = null,
    /**
     * The scope.
     */
    val scope: String? = null,
    /**
     * The session identifier.
     */
    val sid: String? = null,
    /**
     * The subject identifier.
     */
    val sub: String? = null,
    /**
     * The tenant identifier.
     */
    val tid: String? = null,
)
