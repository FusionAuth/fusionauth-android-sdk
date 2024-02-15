package io.fusionauth.mobilesdk.exceptions

class AuthorizationException: Exception {

    constructor(message: String): super(message)

    constructor(message: String, cause: Throwable): super(message, cause)

    constructor(exception: net.openid.appauth.AuthorizationException): super(exception.error.toString(), exception)

    constructor(cause: Throwable): super(cause)

    constructor(): super()

    companion object {
        fun fromException(exception: net.openid.appauth.AuthorizationException): AuthorizationException {
            return AuthorizationException(exception)
        }
    }
}
