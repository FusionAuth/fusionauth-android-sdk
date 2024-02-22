package io.fusionauth.mobilesdk.oauth

import kotlinx.serialization.Serializable

/**
 * Represents the device authorization response retrieved from FusionAuth.
 */
@Suppress("PropertyName", "ConstructorParameterNaming")
@Serializable
data class OAuthDeviceAuthorizationResponse (
    val device_code: String,
    val expires_in: Long,
    val interval: Long,
    val user_code: String,
    val verification_uri: String,
    val verification_uri_complete: String,
)
