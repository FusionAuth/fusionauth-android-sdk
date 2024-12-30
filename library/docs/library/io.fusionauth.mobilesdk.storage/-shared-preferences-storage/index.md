//[library](../../../index.md)/[io.fusionauth.mobilesdk.storage](../index.md)/[SharedPreferencesStorage](index.md)

# SharedPreferencesStorage

class [SharedPreferencesStorage](index.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), fileName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;_fusionauth_mobile_sdk&quot;) : [Storage](../-storage/index.md)

SharedPreferencesStorage is a class that implements the Storage interface and provides a storage mechanism using SharedPreferences.

#### Parameters

androidJvm

| | |
|---|---|
| context | The context used to access the application's SharedPreferences. |
| fileName | The name of the SharedPreferences file. Default value is &quot;_fusionauth_mobile_sdk&quot;. |

## Constructors

| | |
|---|---|
| [SharedPreferencesStorage](-shared-preferences-storage.md) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), fileName: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = &quot;_fusionauth_mobile_sdk&quot;) |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [androidJvm]<br>open override fun [get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>Retrieves the value associated with the given [key](get.md) from SharedPreferences. |
| [remove](remove.md) | [androidJvm]<br>open override fun [remove](remove.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>Removes the value associated with the given [key](remove.md) from SharedPreferences. |
| [set](set.md) | [androidJvm]<br>open override fun [set](set.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), content: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html))<br>Sets the value for the given [key](set.md) in SharedPreferences. |