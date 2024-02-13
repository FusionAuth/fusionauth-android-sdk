package io.fusionauth.mobilesdk.storage

/**
 * This interface represents a storage mechanism for storing and retrieving key-value pairs.
 */
interface Storage {

    /**
     * Retrieves the value associated with the given key from the storage.
     *
     * @param key The key for which to retrieve the value.
     * @return The value associated with the key, or null if the key is not found in the storage.
     */
    fun get(key: String): String?

    /**
     * Sets the value associated with the given key in the storage.
     *
     * @param key The key for which to set the value.
     * @param content The value to be set for the key.
     */
    fun set(
        key: String,
        content: Any,
    )

    /**
     * Removes the value associated with the given key from the storage.
     *
     * @param key The key for which to remove the value.
     */
    fun remove(key: String)

}
