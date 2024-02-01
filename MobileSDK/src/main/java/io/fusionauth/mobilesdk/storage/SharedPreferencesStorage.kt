package io.fusionauth.mobilesdk.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class SharedPreferencesStorage
    (context: Context) : Storage {
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

    override fun get(key: String): String? {
        return this.sharedPreferences.getString(key, null)
    }

    override fun set(
        key: String,
        content: Any,
    ) {
        this.sharedPreferences.edit().putString(key, content.toString()).apply()
    }

    override fun remove(key: String) {
        TODO("Not yet implemented")
    }
}
