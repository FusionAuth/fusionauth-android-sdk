package io.fusionauth.mobilesdk.exceptions

import net.openid.appauth.AuthorizationException

class AuthenticationException: Exception {

    constructor(message: String): super(message)

    constructor(message: String, cause: Throwable): super(message, cause)

    constructor(exception: AuthorizationException): super(exception.error.toString(), exception)

    constructor(cause: Throwable): super(cause)

    constructor(): super()

    companion object {
        fun fromException(exception: AuthorizationException): AuthenticationException {
            return AuthenticationException(exception)
        }
    }
}
