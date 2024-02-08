package io.fusionauth.mobilesdk

import kotlinx.serialization.Serializable
import java.util.logging.Logger

@Serializable
data class AuthenticationConfiguration(
    val clientId: String,
    val fusionAuthUrl: String,
    val tenant: String? = null,
    val allowUnsecureConnection: Boolean = false,
) {
    init {
        if (!allowUnsecureConnection) {
            Logger.getLogger("FusionAuth Mobile SDK")
                .warning("Unsecure connections should only be used for testing")
        }
    }
}
