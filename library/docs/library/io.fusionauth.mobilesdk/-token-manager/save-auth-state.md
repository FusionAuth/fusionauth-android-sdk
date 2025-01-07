//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[TokenManager](index.md)/[saveAuthState](save-auth-state.md)

# saveAuthState

[androidJvm]\
fun [saveAuthState](save-auth-state.md)(authState: [FusionAuthState](../-fusion-auth-state/index.md))

Saves the authorization state to the storage.

#### Parameters

androidJvm

| | |
|---|---|
| authState | The authorization state to be saved. |

#### Throws

| | |
|---|---|
| [NullPointerException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-null-pointer-exception/index.html) | if `storage` is null. |