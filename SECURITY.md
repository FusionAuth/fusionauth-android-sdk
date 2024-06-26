# Security Policy

For Responsible Disclosure Program, Discovering Security Vulnerabilities
 and Reporting a Vulnerability please follow https://fusionauth.io/security

## Supported Versions

| SDK Version   | Tested FusionAuth Version | Tested Android API Level | Supported          |
|---------------|---------------------------|--------------------------|--------------------|
| \>= 0.1.6     | 1.47 - 1.51               | 29 - 34                  | :white_check_mark: |
| 0.1.4 - 0.1.5 | 1.47 - 1.50               | 29 - 34                  | :x:                |
| 0.1.1         | 1.46 - 1.49               | 29 - 34                  | :x:                |
| \<= 0.1.0     | \<= 1.49                  | 29 - 34                  | :x:                |

## Versioning Guidelines

We use [Semantic Versioning 2.0.0](https://semver.org/) with the following release examples:

### Major

When the Authorization / Token Manager API is changed in a non-backwards compatible way.

### Minor

When the Authorization / Token Manager API is extended with new functionality in a backwards compatible way.

### Patch

When the Authorization / Token Manager API is not changed, but an internal bug is fixed.

### FusionAuth Server Compatibility

The Mobile SDK version may be tied to the FusionAuth Server version. This is to ensure that the Mobile SDK is compatible with the FusionAuth Server. 

If the resulting SDK release stays compatible with the new and earlier Fusionauth Server version, the SDK is published as a Minor release. 

If the resulting SDK release is only compatible with the new FusionAuth Server version. It is considered a non-backwards compatible change, and the SDK is released in a Major release.
