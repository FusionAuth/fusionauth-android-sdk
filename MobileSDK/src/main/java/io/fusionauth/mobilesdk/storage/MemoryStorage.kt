package io.fusionauth.mobilesdk.storage

/**
 * A storage implementation that stores key-value pairs in memory.
 */
class MemoryStorage : Storage {
    private val storageMap = mutableMapOf<String, Any>()

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key the key whose associated value is to be retrieved
     * @return the value associated with the specified key, or null if the key is not found
     */
    override fun get(key: String): String? {
        return storageMap[key]?.toString()
    }

    /**
     * Sets the value associated with the specified key in the storage.
     *
     * @param key the key to set
     * @param content the content to associate with the key
     */
    override fun set(key: String, content: Any) {
        storageMap[key] = content
    }

    override fun remove(key: String) {
        storageMap.remove(key)
    }
}