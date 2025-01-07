//[library](../../index.md)/[io.fusionauth.mobilesdk.storage](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [MemoryStorage](-memory-storage/index.md) | [androidJvm]<br>class [MemoryStorage](-memory-storage/index.md) : [Storage](-storage/index.md)<br>A storage implementation that stores key-value pairs in memory. |
| [SharedPreferencesStorage](-shared-preferences-storage/index.md) | [androidJvm]<br>class [SharedPreferencesStorage](-shared-preferences-storage/index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), fileName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;_fusionauth_mobile_sdk&quot;) : [Storage](-storage/index.md)<br>SharedPreferencesStorage is a class that implements the Storage interface and provides a storage mechanism using SharedPreferences. |
| [Storage](-storage/index.md) | [androidJvm]<br>interface [Storage](-storage/index.md)<br>This interface represents a storage mechanism for storing and retrieving key-value pairs. |