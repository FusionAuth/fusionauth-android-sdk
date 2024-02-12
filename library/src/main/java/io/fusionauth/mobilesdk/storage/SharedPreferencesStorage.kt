package io.fusionauth.mobilesdk.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

/**
 * A class that implements the [Storage] interface for storing data in SharedPreferences.
 *
 * @property context The application context.
 */
class SharedPreferencesStorage(context: Context) : Storage {

    private val sharedPreferences: SharedPreferences

    init {
        val masterKey =
            MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
        this.sharedPreferences =
            EncryptedSharedPreferences.create(
                context,
                "fusionauth-mobile-sdk",
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
            )
    }

    /**
     * Retrieves the value associated with the given [key] from SharedPreferences.
     *
     * @param key The key used to retrieve the value.
     * @return The value associated with the key, or null if the key does not exist.
     */
    override fun get(key: String): String? {
        return this.sharedPreferences.getString(key, null)
    }

    /**
     * Sets the value for the given [key] in SharedPreferences.
     *
     * @param key The key to associate with the value.
     * @param content The value to be stored. It can be of any type.
     */
    override fun set(
        key: String,
        content: Any,
    ) {
        this.sharedPreferences.edit().putString(key, content.toString()).apply()
    }

    /**
     * Removes the value associated with the given [key] from SharedPreferences.
     *
     * @param key The key of the value to be removed.
     */
    override fun remove(key: String) {
        this.sharedPreferences.edit().remove(key).apply()
    }
}
