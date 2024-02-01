package io.fusionauth.mobilesdk

import java.util.UUID

@Suppress("PropertyName")
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
