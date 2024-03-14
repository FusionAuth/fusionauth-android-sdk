//[library](../../../index.md)/[io.fusionauth.mobilesdk.oauth](../index.md)/[OAuthAuthorizationService](index.md)/[handleRedirect](handle-redirect.md)

# handleRedirect

[androidJvm]\
suspend fun [handleRedirect](handle-redirect.md)(intent: [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)): [FusionAuthState](../../io.fusionauth.mobilesdk/-fusion-auth-state/index.md)

Handles the redirect intent from the authorization process.

#### Return

The FusionAuthState object that contains the access token, access token expiration time, and id token.

#### Parameters

androidJvm

| | |
|---|---|
| intent | The intent received from the authorization process. |

#### Throws

| | |
|---|---|
| [AuthorizationException](../../io.fusionauth.mobilesdk.exceptions/-authorization-exception/index.md) | If the authorization process failed. |
