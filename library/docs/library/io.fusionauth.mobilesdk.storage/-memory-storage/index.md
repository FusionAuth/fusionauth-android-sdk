//[library](../../../index.md)/[io.fusionauth.mobilesdk.storage](../index.md)/[MemoryStorage](index.md)

# MemoryStorage

[androidJvm]\
class [MemoryStorage](index.md) : [Storage](../-storage/index.md)

A storage implementation that stores key-value pairs in memory.

## Constructors

| | |
|---|---|
| [MemoryStorage](-memory-storage.md) | [androidJvm]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [get](get.md) | [androidJvm]<br>open override fun [get](get.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Retrieves the value associated with the specified key. |
| [remove](remove.md) | [androidJvm]<br>open override fun [remove](remove.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Removes the key-value pair associated with the specified key from the storage. |
| [set](set.md) | [androidJvm]<br>open override fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), content: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html))<br>Sets the value associated with the specified key in the storage. |
