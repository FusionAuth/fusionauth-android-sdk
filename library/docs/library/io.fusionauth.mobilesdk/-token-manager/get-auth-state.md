//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[TokenManager](index.md)/[getAuthState](get-auth-state.md)

# getAuthState

[androidJvm]\
fun [getAuthState](get-auth-state.md)(): [FusionAuthState](../-fusion-auth-state/index.md)?

Retrieves the authorization state from the storage.

#### Return

The authorization state if available, or null if not present or unable to decode from storage.

#### Throws

| | |
|---|---|
| [StorageException](../../io.fusionauth.mobilesdk.exceptions/-storage-exception/index.md) | if an error occurs while decoding the authorization state. |
