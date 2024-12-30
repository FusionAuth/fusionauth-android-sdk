//[library](../../../index.md)/[io.fusionauth.mobilesdk.storage](../index.md)/[Storage](index.md)

# Storage

interface [Storage](index.md)

This interface represents a storage mechanism for storing and retrieving key-value pairs.

#### Inheritors

| |
|---|
| [MemoryStorage](../-memory-storage/index.md) |
| [SharedPreferencesStorage](../-shared-preferences-storage/index.md) |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [androidJvm]<br>abstract fun [get](get.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>Retrieves the value associated with the given key from the storage. |
| [remove](remove.md) | [androidJvm]<br>abstract fun [remove](remove.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html))<br>Removes the value associated with the given key from the storage. |
| [set](set.md) | [androidJvm]<br>abstract fun [set](set.md)(key: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), content: [Any](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-any/index.html))<br>Sets the value associated with the given key in the storage. |