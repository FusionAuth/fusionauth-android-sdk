package io.fusionauth.mobilesdk.exceptions

/**
 * Thrown when an OAuth authorization or end-session flow cannot be launched because the device
 * has no browser (or no Custom Tabs / browser activity) capable of handling the request.
 *
 * This typically wraps an [android.content.ActivityNotFoundException] raised by the underlying
 * AppAuth call when no `android.intent.action.VIEW` handler for `https` is available.
 *
 * Consumers should catch this exception (or [AuthorizationException]) and surface a recoverable
 * error to the user — for example, prompting them to install a browser.
 */
class BrowserNotAvailableException : AuthorizationException {

    constructor(message: String) : super(message)

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(cause: Throwable) : super(cause)
}
