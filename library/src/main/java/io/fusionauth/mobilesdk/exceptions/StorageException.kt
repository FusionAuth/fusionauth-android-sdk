package io.fusionauth.mobilesdk.exceptions

/**
 * Exception thrown for storage-related errors in the application.
 */
class StorageException: RuntimeException {

    private constructor(message: String): super(message)

    private constructor(message: String, cause: Throwable): super(message, cause)

    companion object {

        /**
         * Creates a [StorageException] indicating that the storage implementation is not set.
         *
         * @return A new [StorageException] indicating that the storage is not set.
         */
        fun notSet(): StorageException {
            return StorageException("Storage is not set. " +
                    "Please set the storage implementation using TokenManager.withStorage.")
        }

        /**
         * Creates a [StorageException] indicating that the data could not be decoded from the storage.
         *
         * @param cause The [Throwable] cause of the exception.
         * @return A new [StorageException] indicating the decoding failure.
         */
        fun unableToDecode(cause: Throwable): StorageException {
            return StorageException("Unable to deserialize the data from the storage.", cause)
        }
    }
}
