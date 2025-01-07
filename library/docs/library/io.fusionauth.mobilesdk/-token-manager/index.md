//[library](../../../index.md)/[io.fusionauth.mobilesdk](../index.md)/[TokenManager](index.md)

# TokenManager

[androidJvm]\
class [TokenManager](index.md)

The TokenManager class handles the storage and retrieval of authorization state tokens.

## Constructors

| | |
|---|---|
| [TokenManager](-token-manager.md) | [androidJvm]<br>constructor()<br>Creates a TokenManager instance. |

## Functions

| Name | Summary |
|---|---|
| [clearAuthState](clear-auth-state.md) | [androidJvm]<br>fun [clearAuthState](clear-auth-state.md)()<br>Clears the authorization state by removing the &quot;authState&quot; key from the storage. |
| [getAuthState](get-auth-state.md) | [androidJvm]<br>fun [getAuthState](get-auth-state.md)(): [FusionAuthState](../-fusion-auth-state/index.md)?<br>Retrieves the authorization state from the storage. |
| [saveAuthState](save-auth-state.md) | [androidJvm]<br>fun [saveAuthState](save-auth-state.md)(authState: [FusionAuthState](../-fusion-auth-state/index.md))<br>Saves the authorization state to the storage. |
| [withStorage](with-storage.md) | [androidJvm]<br>fun [withStorage](with-storage.md)(storage: [Storage](../../io.fusionauth.mobilesdk.storage/-storage/index.md)): [TokenManager](index.md)<br>Sets the storage implementation to be used for storing data in the TokenManager. |