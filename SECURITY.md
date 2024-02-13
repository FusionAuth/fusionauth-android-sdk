# Security Policy

For Responsible Disclosure Program, Discovering Security Vulnerabilities
 and Reporting a Vulnerability please follow https://fusionauth.io/security

## Supported Versions

| SDK Version | Supported FusionAuth Version | Supported          |
|-------------|------------------------------|--------------------|
| 0.3.x       | 1.48 or newer                | :white_check_mark: |
| 0.2.x       | 1.45 - 1.47                  | :white_check_mark: |
| \< 0.1      | 1.44 - 1.45                  | :x:                |

## Versioning Guidelines

We use [Semantic Versioning 2.0.0](https://semver.org/) with the following release examples:

### Major

When the Authentication / Token Manager API is changed in a non-backwards compatible way.

### Minor

When the Authentication / Token Manager API is extended with new functionality in a backwards compatible way.

### Patch

When the Authentication / Token Manager API is not changed, but an internal bug is fixed.

### FusionAuth Server Compatibility

The Mobile SDK version may be tied to the FusionAuth Server version. This is to ensure that the Mobile SDK is compatible with the FusionAuth Server. 

If the resulting SDK release stays compatible with the new and earlier Fusionauth Server version, the SDK is published as a Minor release. 

If the resulting SDK release is only compatible with the new FusionAuth Server version. It is considered a non-backwards compatible change, and the SDK is released in a Major release.