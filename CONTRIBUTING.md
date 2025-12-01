# Contributing
<!--
tag::forDocSiteContributing[]
-->
We hope you love using FusionAuth Android SDK, but in case you encounter a bug or an issue with the SDK, please do let us know.

Please only report issues for the FusionAuth Android SDK itself if you have an issue with documentation or a client library follow [these instructions.](https://github.com/FusionAuth/fusionauth-issues)

## Reporting an Issue

Before reporting an issue, please search through the already open issues to see if you could contribute.

To report an issue, please follow the instructions of the bug, feature and general issue templates.

## Contributing Features and Fixes

Before starting with contributing, you'll want to look at and choose an issue to work on. Here is a basic workflow you want to work from:

1. Search the issue tracker for an issue that you want to work on. If your issue does not exist, please create a new one.
2. Search GitHub for an open or closed Pull Request that relates to the issue you want to work on. You may find that someone else is already working on it, or that the issue is already resolved in a different branch.

You can find all the open issues [here](https://github.com/FusionAuth/fusionauth-android-sdk/issues).

Once you have found an issue you want to work on, we suggest to:

1. Fork the repository to your personal account.
2. Create a new branch with the name fix/issue-id or feat/issue-id.
3. And start working on that branch on the issue.

## Development

This SDK was developed with [IntelliJ IDEA](https://www.jetbrains.com/idea/) and because of delayed latest APG compatibility [Android Studio](https://developer.android.com/studio).

Checking out this repository will provide you with the full development environment including a fully functional example application with a FusionAuth runtime.

### Library

The SDK is located in [library/](library) including the docs and tests.

### App

To use the functionality of the [library/](library) we load it in to the [app/](app) which you can start with the Android App configuration in this project.

To run the App we suggest to use the latest emulator with either the standard Google Play variant or the Google API variant which is used in the [automated end to end tests](.github/workflows).

The emulator stores certain data in the device configuration, because of that we suggest to Wipe Data every time you switch between branches or you discover problems during tests.

### FusionAuth

The [app/](app) is using FusionAuth for the different use cases (e.g. login, logout) and is preconfigured to work with the [fusionauth/](fusionauth) located versions.

We suggest to use the following commands to switch between the different versions.

* Create: `docker compose up -d` to start fusionauth in the background.
* Logs: `docker compose logs app` it will take a moment until the kickstart is initialized.
* Destroy: `docker compose down -v` we destroy the volumes because we always want a fresh install.

### Development Tooling

During development of new features and fixes, we suggest using the following code quality tools which are preconfigured for this project:
* Detekt: `./gradlew clean detektRelease detektTest --continue` or use an [IDE plugin](https://plugins.jetbrains.com/plugin/10761-detekt)
* Android Lint: `./gradlew clean lint --continue` 
* Android Test: `./gradlew connectedAndroidTest`

#### Testing

See [FusionAuth Android SDK Quickstart Testing](https://github.com/FusionAuth/fusionauth-quickstart-kotlin-android-native/blob/main/TESTING.md) for a full tutorial on Android Test.

## Submitting a Pull Request

When you are ready to submit your pull request, visit the main repository on GitHub and click the "Compare & pull request" button. Here you can select the branch you have been working on and create a pull request.

If you're creating a pull request for an issue, please include `Closes #XXX` in the message body where `#XXX` is the issue you're fixing. For example, `Closes #42` would close issue #42.

After you have submitted your pull request, several checks will be run to ensure the changes meet the project's guidelines. If they do, the pull request will be reviewed by a maintainer and subsequently merged.
<!--
end::forDocSiteContributing[]
-->

# Release
<!--
tag::forDocSiteRelease[]
-->
The release proceeds through three sequential steps: [Pre-Release Process](#pre-release-process), [Release Process](#release-process) and [Quickstart Release Process](#quickstart-release-process). Where [Pre-Release Process](#pre-release-process) gets repeated untill a stable release is possible.

## Pre-Release Process

The pre-release process is as follows:
- Check if the latest FusionAuth version is used in the different jobs and configuraitons.
- Compare the gradlew version `./gradlew -v` with the latest [gradle release](https://gradle.org/releases/) and update if necessary.
- Review, test and merge any open [Dependency Pull Requests](https://github.com/FusionAuth/fusionauth-android-sdk/pulls).
- Update the version in the `library/build.gradle.kts` file with a pre-release version according to the [Semantic Versioning](https://semver.org/) guidelines.
- Commit the changes with the commit message `chore(release): <pre-release-version> 🎉`.
- Create a new tag `v<pre-release-version>`.
- Make sure all Workflows where successful in [Actions](https://github.com/FusionAuth/fusionauth-android-sdk/actions).

The `pre-release.yml` workflow will automatically create a GitHub release, build the library, and add the artifact to GitHub.

## Release Process

The release process is as follows:
- Check if a pre-release exists, if not start with the pre-release process.
- Update the release version in the `library/build.gradle.kts` file, derived from the pre-release version according to the [Semantic Versioning](https://semver.org/) guidelines.
- Update the [SECURITY.md](SECURITY.md) version information with the latest `Supported Versions` according to the current specification E2E test workflows.
- Commit the changes with the commit message `chore(release): <version> 🎉`.
- Create a new tag `v<version>`.
- Push the changes and the tag to the repository.

The `release.yml` workflow will automatically create a GitHub release, build the library, and publish it to Maven Central.

### Quickstart Release Process

After the release is published, update the version in the [FusionAuth Android Quickstart Repository](https://github.com/FusionAuth/fusionauth-quickstart-java-android-fusionauth-sdk/):
- Check out the https://github.com/FusionAuth/fusionauth-quickstart-kotlin-android-native repository.
- Replace the `complete-application/app/src` directory with the `app/src` of this repository.
- Update `implementation("io.fusionauth:fusionauth-android-sdk:${version}")` in the `app/build.gradle` file.
- (Optional) If the `app/build.gradle.kts` and `build.gradle.kts` file was changed, update the content of the according files in `complete-application/` in the quickstart repository.
- (Optional) If the FusionAuth configuration changed, update the according `docker-compose.yml`, `.env` and `kickstart/` files in the quickstart repository.
- (Optional) Compare the gradlew version `./gradlew -v` with the version used in the SDK and copy or update if necessary.
- Commit the changes with the commit message `chore(release): <version> 🎉`.
- Create a new tag `v<version>`.
- Push the changes and the tag to the repository.
<!--
end::forDocSiteRelease[]
-->
