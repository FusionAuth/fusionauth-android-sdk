# Changelog

## [1.1.0-rc](https://github.com/FusionAuth/fusionauth-android-sdk/compare/v1.0.0...v1.1.0-rc) (2026-04-09)


### Features

* Add prompt parameter support to OAuth2 authorization request ([#295](https://github.com/FusionAuth/fusionauth-android-sdk/issues/295)) ([e7c7e7a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e7c7e7a3841bf156af2c461faa23ee877a9b05e9))


### Miscellaneous Chores
* Updated all docker-compose files with installation source ([#287](https://github.com/FusionAuth/fusionauth-android-sdk/pull/287)) ([bfe4834](https://github.com/FusionAuth/fusionauth-android-sdk/commit/bfe48345485cec1a42f9478b15eb30f23db447de))


### Build System and Dependencies

* **deps:** bump github/codeql-action in the prod-github-actions group ([#293](https://github.com/FusionAuth/fusionauth-android-sdk/issues/293)) ([b6d869c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b6d869c552d2cb1d6d9b468a967d22f70e67ccb9))
* **deps:** bump the prod-github-actions group across 1 directory with 6 updates ([#285](https://github.com/FusionAuth/fusionauth-android-sdk/issues/285)) ([88c5cfd](https://github.com/FusionAuth/fusionauth-android-sdk/commit/88c5cfd41e76b520dfa08bed7b6f3027e18ef3ac))
* **ci:** workflows update ([#214](https://github.com/FusionAuth/fusionauth-android-sdk/pull/214)) ([d5c68ee](https://github.com/FusionAuth/fusionauth-android-sdk/commit/d5c68ee986384156d383801aa3f6d62e4f5eae31))
* **deps:** bump opensearchproject/opensearch in /fusionauth/latest ([#284](https://github.com/FusionAuth/fusionauth-android-sdk/issues/284)) ([b51b360](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b51b360ba519a4e2881c63e4a971f3dcbacd646d))


## [1.0.0](https://github.com/FusionAuth/fusionauth-android-sdk/compare/v0.2.0...v1.0.0) (2026-01-27)


### Features

* **feat:** Support Android SDK 36 ([#243](https://github.com/FusionAuth/fusionauth-android-sdk/pull/243))
* **feat:** Use dokka v2 to generate html vs markdown documentation. ([#253](https://github.com/FusionAuth/fusionauth-android-sdk/pull/253))
* **feat:** DataStoreStorage replaces the deprecated SharedPreferencesStorage ([#259](https://github.com/FusionAuth/fusionauth-android-sdk/pull/259))


### Bug Fixes

* **fix:** Don't run the GitHub Action Deploy Dokka Docs on a PR ([#257](https://github.com/FusionAuth/fusionauth-android-sdk/pull/257))
* **release:** add prerelease-manifest.json to release-config.json ([96859aa](https://github.com/FusionAuth/fusionauth-android-sdk/commit/96859aaf9563092159ef257fc114ee76689591c4))


### Code Refactoring

* **refactor:** use KTX extensions ([#208](https://github.com/FusionAuth/fusionauth-android-sdk/pull/208))
* **refactor:** Update the Sample Application View to match the UI in iOS SDK ([#265](https://github.com/FusionAuth/fusionauth-android-sdk/pull/265))


### Miscellaneous Chores

* manual version sync to prerelease-manifest.json ([62901e1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/62901e13c246d8805cad1edd3c2e1501268a3eb9))


### Build System and Dependencies

* **deps:** bump fusionauth/fusionauth-app in /fusionauth/latest ([#188](https://github.com/FusionAuth/fusionauth-android-sdk/issues/188)) ([6c79e0d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6c79e0d38a3ecc3f0c531504b76df152eda93256))
* **deps:** bump fusionauth/fusionauth-app in /fusionauth/latest ([#198](https://github.com/FusionAuth/fusionauth-android-sdk/issues/198)) ([11b36f0](https://github.com/FusionAuth/fusionauth-android-sdk/commit/11b36f003b6c540c4883dc9996fddd55e5fd21db))
* **deps:** bump opensearchproject/opensearch in /fusionauth/latest ([#201](https://github.com/FusionAuth/fusionauth-android-sdk/issues/201)) ([2f86c43](https://github.com/FusionAuth/fusionauth-android-sdk/commit/2f86c4327cb8e357ca9cf8ec71cd572b9d358e37))
* **deps:** bump postgres from 16.9-bookworm to 18.0-bookworm in /fusionauth/latest ([cd4f407](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cd4f407bc2b70bdb335a2b16d944e144edaa582d))
* **deps:** bump postgres from 18.0-bookworm to 18.1-bookworm in /fusionauth/latest ([aee163e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/aee163ea18504297c6f56a6fdf60c84577487810))
* **deps:** bump postgres in /fusionauth/latest ([9593603](https://github.com/FusionAuth/fusionauth-android-sdk/commit/95936034ee9f252737725a60ad77d9cb8599a67a))
* **deps:** bump postgres in /fusionauth/latest ([b892ea2](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b892ea236e06cc8eb86010fab7bcee58441a9208))
* **deps:** bump postgres in /fusionauth/latest ([#176](https://github.com/FusionAuth/fusionauth-android-sdk/issues/176)) ([e7747b1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e7747b15afd3d6c7396eda50fe124a5728ab014a))
* **deps:** bump postgres in /fusionauth/latest ([#205](https://github.com/FusionAuth/fusionauth-android-sdk/issues/205)) ([451803c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/451803cbf9b18f785915d30d355604ea306e2683))
* **deps:** bump the gradle-minor-dependencies group ([#213](https://github.com/FusionAuth/fusionauth-android-sdk/issues/213)) ([a511679](https://github.com/FusionAuth/fusionauth-android-sdk/commit/a511679a9a6729fce3fe8bb67d4343172b6e73db))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 10 updates ([b8a8104](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b8a81044106338306f44b46bb626cba04b0c3527))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 10 updates ([e142c9c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e142c9ceddf6b4a6e18250013f09de0d209a2eb8))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 4 updates ([#189](https://github.com/FusionAuth/fusionauth-android-sdk/issues/189)) ([389936f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/389936f5d062361d1a67d24c4b21749404c44646))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 5 updates ([#182](https://github.com/FusionAuth/fusionauth-android-sdk/issues/182)) ([68f2e20](https://github.com/FusionAuth/fusionauth-android-sdk/commit/68f2e207cab81196bcfff93594bfe97cb7f667a8))
* **deps:** bump the gradle-minor-dependencies group with 2 updates ([#175](https://github.com/FusionAuth/fusionauth-android-sdk/issues/175)) ([b9cbfa6](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b9cbfa6bfb3cdd480ecff9adc58f393fd342cf7a))
* **deps:** bump the prod-github-actions group across 1 directory with 4 updates ([477958e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/477958e7cc3a2af698c557643b8f628d740c01a3))
* **deps:** bump the prod-github-actions group across 1 directory with 4 updates ([cd2cf36](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cd2cf36fe94c84a88c27f9e2dd6d0391b5547b77))
* **deps:** bump the prod-github-actions group across 1 directory with 9 updates ([72fe708](https://github.com/FusionAuth/fusionauth-android-sdk/commit/72fe708b1a6ec604cd35438cb4097ecb9104f7e9))
* **deps:** bump the prod-github-actions group across 1 directory with 9 updates ([74f8d2f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/74f8d2f11b9e0c4a3cd1e67af1a668a96bee1cd0))

## [1.0.0-rc](https://github.com/FusionAuth/fusionauth-android-sdk/compare/v0.2.0...v1.0.0-rc) (2026-01-22)

### Features

* **feat:** Support Android SDK 36 ([#243](https://github.com/FusionAuth/fusionauth-android-sdk/pull/243))
* **feat:** Use dokka v2 to generate html vs markdown documentation. ([#253](https://github.com/FusionAuth/fusionauth-android-sdk/pull/253))
* **feat:** DataStoreStorage replaces the deprecated SharedPreferencesStorage ([#259](https://github.com/FusionAuth/fusionauth-android-sdk/pull/259))


### Bug Fixes

* **fix:** Don't run the GitHub Action Deploy Dokka Docs on a PR ([#257](https://github.com/FusionAuth/fusionauth-android-sdk/pull/257))
* **release:** add prerelease-manifest.json to release-config.json ([96859aa](https://github.com/FusionAuth/fusionauth-android-sdk/commit/96859aaf9563092159ef257fc114ee76689591c4))


### Code Refactoring

* **refactor:** use KTX extensions ([#208](https://github.com/FusionAuth/fusionauth-android-sdk/pull/208))
* **refactor:** Update the Sample Application View to match the UI in iOS SDK ([#265](https://github.com/FusionAuth/fusionauth-android-sdk/pull/265))


### Miscellaneous Chores

* manual version sync to prerelease-manifest.json ([62901e1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/62901e13c246d8805cad1edd3c2e1501268a3eb9))


### Build System and Dependencies

* **deps:** bump fusionauth/fusionauth-app in /fusionauth/latest ([#188](https://github.com/FusionAuth/fusionauth-android-sdk/issues/188)) ([6c79e0d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6c79e0d38a3ecc3f0c531504b76df152eda93256))
* **deps:** bump fusionauth/fusionauth-app in /fusionauth/latest ([#198](https://github.com/FusionAuth/fusionauth-android-sdk/issues/198)) ([11b36f0](https://github.com/FusionAuth/fusionauth-android-sdk/commit/11b36f003b6c540c4883dc9996fddd55e5fd21db))
* **deps:** bump opensearchproject/opensearch in /fusionauth/latest ([#201](https://github.com/FusionAuth/fusionauth-android-sdk/issues/201)) ([2f86c43](https://github.com/FusionAuth/fusionauth-android-sdk/commit/2f86c4327cb8e357ca9cf8ec71cd572b9d358e37))
* **deps:** bump postgres from 16.9-bookworm to 18.0-bookworm in /fusionauth/latest ([cd4f407](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cd4f407bc2b70bdb335a2b16d944e144edaa582d))
* **deps:** bump postgres from 18.0-bookworm to 18.1-bookworm in /fusionauth/latest ([aee163e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/aee163ea18504297c6f56a6fdf60c84577487810))
* **deps:** bump postgres in /fusionauth/latest ([9593603](https://github.com/FusionAuth/fusionauth-android-sdk/commit/95936034ee9f252737725a60ad77d9cb8599a67a))
* **deps:** bump postgres in /fusionauth/latest ([b892ea2](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b892ea236e06cc8eb86010fab7bcee58441a9208))
* **deps:** bump postgres in /fusionauth/latest ([#176](https://github.com/FusionAuth/fusionauth-android-sdk/issues/176)) ([e7747b1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e7747b15afd3d6c7396eda50fe124a5728ab014a))
* **deps:** bump postgres in /fusionauth/latest ([#205](https://github.com/FusionAuth/fusionauth-android-sdk/issues/205)) ([451803c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/451803cbf9b18f785915d30d355604ea306e2683))
* **deps:** bump the gradle-minor-dependencies group ([#213](https://github.com/FusionAuth/fusionauth-android-sdk/issues/213)) ([a511679](https://github.com/FusionAuth/fusionauth-android-sdk/commit/a511679a9a6729fce3fe8bb67d4343172b6e73db))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 10 updates ([b8a8104](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b8a81044106338306f44b46bb626cba04b0c3527))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 10 updates ([e142c9c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e142c9ceddf6b4a6e18250013f09de0d209a2eb8))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 4 updates ([#189](https://github.com/FusionAuth/fusionauth-android-sdk/issues/189)) ([389936f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/389936f5d062361d1a67d24c4b21749404c44646))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 5 updates ([#182](https://github.com/FusionAuth/fusionauth-android-sdk/issues/182)) ([68f2e20](https://github.com/FusionAuth/fusionauth-android-sdk/commit/68f2e207cab81196bcfff93594bfe97cb7f667a8))
* **deps:** bump the gradle-minor-dependencies group with 2 updates ([#175](https://github.com/FusionAuth/fusionauth-android-sdk/issues/175)) ([b9cbfa6](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b9cbfa6bfb3cdd480ecff9adc58f393fd342cf7a))
* **deps:** bump the prod-github-actions group across 1 directory with 4 updates ([477958e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/477958e7cc3a2af698c557643b8f628d740c01a3))
* **deps:** bump the prod-github-actions group across 1 directory with 4 updates ([cd2cf36](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cd2cf36fe94c84a88c27f9e2dd6d0391b5547b77))
* **deps:** bump the prod-github-actions group across 1 directory with 9 updates ([72fe708](https://github.com/FusionAuth/fusionauth-android-sdk/commit/72fe708b1a6ec604cd35438cb4097ecb9104f7e9))
* **deps:** bump the prod-github-actions group across 1 directory with 9 updates ([74f8d2f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/74f8d2f11b9e0c4a3cd1e67af1a668a96bee1cd0))

## [0.2.0](https://github.com/FusionAuth/fusionauth-android-sdk/compare/v0.1.7...v0.2.0) (2025-03-14)


### Features

* soc 2 compliant release workflow ([#149](https://github.com/FusionAuth/fusionauth-android-sdk/issues/149)) ([013c509](https://github.com/FusionAuth/fusionauth-android-sdk/commit/013c509e142c8ed3e24bcd6c738f7d5e972ab154))


### Bug Fixes

* add fusionauth-1.56.0 ([#168](https://github.com/FusionAuth/fusionauth-android-sdk/issues/168)) ([f8990c4](https://github.com/FusionAuth/fusionauth-android-sdk/commit/f8990c4a35b6cafeb02ddd14b4bd56e371580a8e))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 6 updates ([#162](https://github.com/FusionAuth/fusionauth-android-sdk/issues/162)) ([4ac165d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/4ac165dd7a361c8c938261cc9bbb2f96fd7fc619))
* **oauth:** update handleRedirect exception handling ([#138](https://github.com/FusionAuth/fusionauth-android-sdk/issues/138)) ([6f0bc21](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6f0bc21ed0d770610c98033c681e309a5f0e4b4b))
* **release:** add missed detekt pre-check and workflow_call ([#154](https://github.com/FusionAuth/fusionauth-android-sdk/issues/154)) ([db25cc6](https://github.com/FusionAuth/fusionauth-android-sdk/commit/db25cc61b47761c6d958aa0040037ff84020dd69))
* **release:** move pre-checks to commit-checks ([a665944](https://github.com/FusionAuth/fusionauth-android-sdk/commit/a665944d7472e95a9bafca0cb53a35a8e5af79a8))
* **release:** move pre-checks to commit-checks ([d21b71f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/d21b71fee61cc244e20441334f19fe86e5d2830f))
* remove codeChallenge and codeChallengeMethod ([#136](https://github.com/FusionAuth/fusionauth-android-sdk/issues/136)) ([eebb80a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/eebb80a503e46ae37b92e5c2964cf81774f1104b)), closes [#130](https://github.com/FusionAuth/fusionauth-android-sdk/issues/130)

## [0.2.0-rc](https://github.com/FusionAuth/fusionauth-android-sdk/compare/v0.1.7...v0.2.0-rc) (2025-03-14)


### Features

* soc 2 compliant release workflow ([#149](https://github.com/FusionAuth/fusionauth-android-sdk/issues/149)) ([013c509](https://github.com/FusionAuth/fusionauth-android-sdk/commit/013c509e142c8ed3e24bcd6c738f7d5e972ab154))


### Bug Fixes

* add fusionauth-1.56.0 ([#168](https://github.com/FusionAuth/fusionauth-android-sdk/issues/168)) ([f8990c4](https://github.com/FusionAuth/fusionauth-android-sdk/commit/f8990c4a35b6cafeb02ddd14b4bd56e371580a8e))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 6 updates ([#162](https://github.com/FusionAuth/fusionauth-android-sdk/issues/162)) ([4ac165d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/4ac165dd7a361c8c938261cc9bbb2f96fd7fc619))
* **oauth:** update handleRedirect exception handling ([#138](https://github.com/FusionAuth/fusionauth-android-sdk/issues/138)) ([6f0bc21](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6f0bc21ed0d770610c98033c681e309a5f0e4b4b))
* **release:** add missed detekt pre-check and workflow_call ([#154](https://github.com/FusionAuth/fusionauth-android-sdk/issues/154)) ([db25cc6](https://github.com/FusionAuth/fusionauth-android-sdk/commit/db25cc61b47761c6d958aa0040037ff84020dd69))
* **release:** move pre-checks to commit-checks ([a665944](https://github.com/FusionAuth/fusionauth-android-sdk/commit/a665944d7472e95a9bafca0cb53a35a8e5af79a8))
* **release:** move pre-checks to commit-checks ([d21b71f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/d21b71fee61cc244e20441334f19fe86e5d2830f))
* remove codeChallenge and codeChallengeMethod ([#136](https://github.com/FusionAuth/fusionauth-android-sdk/issues/136)) ([eebb80a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/eebb80a503e46ae37b92e5c2964cf81774f1104b)), closes [#130](https://github.com/FusionAuth/fusionauth-android-sdk/issues/130)
