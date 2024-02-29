An SDK for using FusionAuth in Android Apps.

# Table of Contents

- [Overview](#overview)

- [Getting Started](#getting-started)

- [Usage](#usage)

- [Example App](#example-app)

- [Documentation](#documentation)

<!--
this tag, and the corresponding end tag, are used to delineate what is pulled into the FusionAuth docs site (the client libraries pages). Don't remove unless you also change the docs site.

Please also use ``` instead of indenting for code blocks. The backticks are translated correctly to adoc format.
-->

<!--
tag::forDocSite[]
-->

## Overview

This SDK allows you to use OAuth 2.0 and OpenId Connect functionality in an Android app with FusionAuth as the
authorization server.
It also provides Token Manager to store, refresh and retrieve tokens.

Following OAuth 2.0 and OpenID Connect functionality are covered:
- OAuth 2.0 Authorization Code Grant
- OAuth 2.0 Refresh Token Grant
- OpenID Connect UserInfo
- OpenID Connect End Session

[AppAuth-Android](https://github.com/openid/AppAuth-Android) is used for the OAuth 2.0 Authorization Code Grant flow and OpenID Connect functionality.

The SDK is written in Kotlin and is compatible with Java.

## Getting Started

To use the FusionAuth Android SDK, add the following dependency to your `build.gradle` file:

```dsl
dependencies {
    implementation('io.fusionauth:fusionauth-android-sdk:<latest-version>')
}
```

After adding the dependency, you will need to initialize the `AuthorizationManager` with
the `AuthorizationConfiguration`:

```kotlin
AuthorizationManager.initialize(
    AuthorizationConfiguration(
        fusionAuthUrl = "http://10.0.2.2:9011",
        clientId = "21e13847-4f30-4477-a2d9-33c3a80bd15a",
        allowUnsecureConnection = true
    )
)
```

This will initialize the `AuthorizationManager` with the provided `AuthorizationConfiguration`.
The `AuthorizationManager` is a singleton and can be accessed from anywhere in your app.
The example configuration uses the IP address for your local machine, which is the default for the Android Emulator. If
you are running the FusionAuth server on a different machine, you will need to replace the `fusionAuthUrl` with the
correct URL.

Instead of specifying the `AuthorizationConfiguration` in code, you could also read it from a resource file:

```kotlin
AuthorizationManager.initialize(
    AuthorizationConfiguration.fromResources(this, R.raw.fusionauth_config)
)
```

The `fusionauth_config.json` file should be placed in the `res/raw` directory and should look like this:

```json
{
  "fusionAuthUrl": "http://10.0.2.2:9011",
  "clientId": "21e13847-4f30-4477-a2d9-33c3a80bd15a",
  "allowUnsecureConnection": true
}
```

By default, the SDK uses the `MemoryStorage` for storing tokens. This means that tokens will be lost when the app is
closed.
To persist tokens, you can use the `SharedPreferencesStorage` or implement your own `TokenStorage`.

## Usage

To start the OAuth 2.0 Authorization Code Grant, you can use the `oAuth()` function on the `AuthorizationManager` to
retrieve the `OAuthAuthorizationService`:

```kotlin
AuthorizationManager
    .oAuth(this@LoginActivity)
    .authorize(
        Intent(this@LoginActivity, TokenActivity::class.java),
        OAuthAuthorizeOptions(
            cancelIntent = Intent(this@LoginActivity, LoginActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP),
            state = "state-${System.currentTimeMillis()}"
        )
    )
```

The `authorize` function will start the OAuth 2.0 Authorization Code Grant flow and open the provided `Intent` when the
flow is completed.
The `OAuthAuthorizeOptions` allows you to specify additional options for the flow, such as the `cancelIntent` and
the `state`.

If the user completes the flow, the `TokenActivity` will be opened, and you are required to handle the redirect:

```kotlin
AuthorizationManager.oAuth(this@TokenActivity)
    .handleRedirect(intent)
```

This will retrieve the authorization response, validates the `state` if it was provided, and exchanges the authorization
code for an access token.
The result of the exchange will be stored in the `TokenManager`.

After the user is authorized, you can use `getUserInfo()` to retrieve information about the user:

```kotlin
AuthorizationManager.oAuth(this@TokenActivity).getUserInfo()
```

To call your API with an access token, you can use the `AuthorizationManager` to retrieve a valid access token:

```kotlin
val accessToken = AuthorizationManager.freshAccessToken(this@TokenActivity)
```

This will retrieve a fresh access token from the `TokenManager` and return it. If the access token is expired,
the `TokenManager` will refresh it automatically.

Finally, you can use the `AuthorizationManager` to sign out the user and remove the tokens from the `TokenManager`:

```kotlin
AuthorizationManager
    .oAuth(this@TokenActivity)
    .logout(
        Intent(this@TokenActivity, LoginActivity::class.java)
            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    )
```

If the user is signed out, the `LoginActivity` will be opened.

## Example App

See the [FusionAuth Android SDK Example]() for a functional example of an Android client that utilizes the SDK.

## Quickstart

See the [FusionAuth Android Quickstart]() for a full tutorial on using FusionAuth and Android.

## Documentation

[Full library documentation](https://github.com/FusionAuth/fusionauth-android-sdk/blob/main/library/docs/index.md)

<!--
end::forDocSite[]
-->
