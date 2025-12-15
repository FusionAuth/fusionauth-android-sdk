package io.fusionauth.mobilesdk.storage

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

// Define the DataStore instance as an extension on Context.
// The name "fusionauth_settings" is the file name where preferences will be stored.
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "fusionauth_settings")

/**
 * An implementation of the [Storage] interface that uses Android's Jetpack DataStore for persistence.
 * This class is designed to be a modern replacement for SharedPreferences-based storage.
 *
 * @param context The application context, used to get the DataStore instance.
 */
class DataStoreStorage(private val context: Context) : Storage {

    /**
     * Retrieves the value associated with the given key from DataStore.
     * This operation is performed asynchronously.
     *
     * @param key The key for which to retrieve the value.
     * @return The value associated with the key, or null if the key is not found.
     */
    override suspend fun get(key: String): String? {
        val prefKey = stringPreferencesKey(key)
        return context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    Log.e("DataStoreStorage", "Error reading from DataStore", exception)
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[prefKey]
            }.first()
    }

    /**
     * Sets the value for the given key in DataStore. The content is converted to a String.
     * This operation is performed asynchronously.
     *
     * @param key The key for which to set the value.
     * @param content The value to be set. It will be stored as a String.
     */
    override suspend fun set(key: String, content: Any) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[prefKey] = content.toString()
        }
    }

    /**
     * Removes the value associated with the given key from DataStore.
     * This operation is performed asynchronously.
     *
     * @param key The key for which to remove the value.
     */
    override suspend fun remove(key: String) {
        val prefKey = stringPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings.remove(prefKey)
        }
    }
}
