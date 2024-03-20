package io.fusionauth.mobilesdk.oauth

import kotlinx.serialization.Serializable

/**
 * Represents an OAuth error response.
 *
 * @property error The error code.
 * @property error_description A human-readable description of the error.
 * @property error_reason The reason for the error, if available.
 * @property state The state parameter, if provided in the request.
 */
@Suppress("PropertyName", "ConstructorParameterNaming")
@Serializable
data class OAuthErrorResponse(
    val error: String,
    val error_description: String,
    val error_reason: String? = null,
    val state: String? = null
)
