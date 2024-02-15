package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable
import java.util.logging.Logger

/**
 * AuthorizationConfiguration is a data class that represents the configuration for authorization.
 *
 * @property clientId The client ID used for authorization.
 * @property fusionAuthUrl The URL of the FusionAuth server.
 * @property tenant The tenant ID for the FusionAuth server. (Optional)
 * @property allowUnsecureConnection Flag to allow unsecure connections. Default is false.
 * @property additionalScopes Additional scopes to be requested during authorization. Default is empty.
 * @property locale The locale to be used for authorization. (Optional)
 */
@Suppress("unused")
@Serializable
data class AuthorizationConfiguration(
    val clientId: String,
    val fusionAuthUrl: String,
    val tenant: String? = null,
    val allowUnsecureConnection: Boolean = false,
    val additionalScopes: Set<String> = emptySet(),
    val locale: String? = null
) {
    init {
        if (!allowUnsecureConnection) {
            Logger.getLogger("FusionAuth Mobile SDK")
                .warning("Unsecure connections should only be used for testing")
        }
    }

    fun withAdditionalScopes(scopes: Set<String>): AuthorizationConfiguration {
        return this.copy(additionalScopes = scopes)
    }
}
