package io.fusionauth.mobilesdk.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.core.content.edit

/**
 * SharedPreferencesStorage is a class that implements the Storage interface and provides a
 * storage mechanism using SharedPreferences.
 *
 * @param context The context used to access the application's SharedPreferences.
 * @param fileName The name of the SharedPreferences file. Default value is "_fusionauth_mobile_sdk".
 */
@Deprecated(
    message = "Use DataStoreStorage instead",
    replaceWith = ReplaceWith("DataStoreStorage"),
    level = DeprecationLevel.WARNING
)
class SharedPreferencesStorage(context: Context, fileName: String = "_fusionauth_mobile_sdk") : Storage {

    private val sharedPreferences: SharedPreferences

    init {
        val masterKey =
            MasterKey.Builder(context, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build()
        this.sharedPreferences =
            EncryptedSharedPreferences.create(
                context,
                fileName,
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
    override suspend fun get(key: String): String? {
        return this.sharedPreferences.getString(key, null)
    }

    /**
     * Sets the value for the given [key] in SharedPreferences.
     *
     * @param key The key to associate with the value.
     * @param content The value to be stored. It can be of any type.
     */
    override suspend fun set(
        key: String,
        content: Any,
    ) {
        this.sharedPreferences.edit { putString(key, content.toString()) }
    }

    /**
     * Removes the value associated with the given [key] from SharedPreferences.
     *
     * @param key The key of the value to be removed.
     */
    override suspend fun remove(key: String) {
        this.sharedPreferences.edit { remove(key) }
    }
}
