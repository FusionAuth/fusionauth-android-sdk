package io.fusionauth.mobilesdk.storage

interface Storage {
    fun get(key: String): String?

    fun set(
        key: String,
        content: Any,
    )

    fun remove(key: String)
}
