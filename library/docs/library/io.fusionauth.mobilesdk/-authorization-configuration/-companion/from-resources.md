//[library](../../../../index.md)/[io.fusionauth.mobilesdk](../../index.md)/[AuthorizationConfiguration](../index.md)/[Companion](index.md)/[fromResources](from-resources.md)

# fromResources

[androidJvm]\
fun [fromResources](from-resources.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), resource: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [AuthorizationConfiguration](../index.md)

Reads a JSON file from resources and converts it into an AuthorizationConfiguration object.

#### Return

The AuthorizationConfiguration object created from the JSON file.

#### Parameters

androidJvm

| | |
|---|---|
| context | The context used to access resources. |
| resource | The resource ID of the JSON file. |