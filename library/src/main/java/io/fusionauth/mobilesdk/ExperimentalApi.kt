package io.fusionauth.mobilesdk

/**
 * Marks the API as experimental and may be subject to change in the future.
 */
@RequiresOptIn(
    message = "This API is experimental and may be subject to change in the future.",
    level = RequiresOptIn.Level.WARNING
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
annotation class ExperimentalApi
