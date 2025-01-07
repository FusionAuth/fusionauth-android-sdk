package io.fusionauth.mobilesdk

import android.content.Context
import kotlinx.serialization.Serializable
import java.util.logging.Logger

/**
 * AuthorizationConfiguration is a data class that represents the configuration for authorization.
 *
 * Make sure the issuer URL of the FusionAuth Application configuration is a valid URL including
 * http/https which is validated while generating the [AuthorizationServiceConfiguration] object.
 */
@Suppress("unused")
@Serializable
data class AuthorizationConfiguration(
    /**
     * The client ID used for authorization.
     */
    val clientId: String,
    /**
     * The URL of the FusionAuth server.
     */
    val fusionAuthUrl: String,
    /**
     * The tenant ID for the FusionAuth server. (Optional)
     */
    val tenant: String? = null,
    /**
     * Flag to allow unsecure connections. Default is false.
     */
    val allowUnsecureConnection: Boolean = false,
    /**
     * Additional scopes to be requested during authorization. Default is empty.
     */
    val additionalScopes: Set<String> = emptySet(),
    /**
     * The locale to be used for authorization. (Optional)
     */
    val locale: String? = null
) {
    init {
        if (!allowUnsecureConnection) {
            Logger.getLogger("FusionAuth Android SDK")
                .warning("Unsecure connections should only be used for testing")
        }
    }

    fun withAdditionalScopes(scopes: Set<String>): AuthorizationConfiguration {
        return this.copy(additionalScopes = scopes)
    }

    companion object {

        /**
         * Reads a JSON file from resources and converts it into an AuthorizationConfiguration object.
         *
         * @param context The context used to access resources.
         * @param resource The resource ID of the JSON file.
         * @return The AuthorizationConfiguration object created from the JSON file.
         */
        fun fromResources(context: Context, resource: Int): AuthorizationConfiguration {
            val json = context.resources.openRawResource(resource).bufferedReader().use { it.readText() }
            return kotlinx.serialization.json.Json.decodeFromString(json)
        }

    }
}
