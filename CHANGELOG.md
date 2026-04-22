# Changelog

## [1.0.0-rc](https://github.com/FusionAuth/fusionauth-android-sdk/compare/v1.0.0...v1.0.0-rc) (2026-04-22)


### Features

* add "Refresh Token" button to TokenActivity ([981247d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/981247d95d52702fc26cd3144dca03b8762e4a8b))
* add additionalScope param ([9e6f7bf](https://github.com/FusionAuth/fusionauth-android-sdk/commit/9e6f7bf94357e749bc8e500e71635fbe788b7ef4))
* add freshAccessToken method ([df07b1f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/df07b1fd25530d1fdb79ac71497d8bc72cbef55f))
* add method to load AuthorizationConfiguration from JSON resource file ([#28](https://github.com/FusionAuth/fusionauth-android-sdk/issues/28)) ([16ce5e4](https://github.com/FusionAuth/fusionauth-android-sdk/commit/16ce5e4dd12f631fa1d16d5006ad4e11bda8baa5))
* Add prompt parameter support to OAuth2 authorization request ([#295](https://github.com/FusionAuth/fusionauth-android-sdk/issues/295)) ([e7c7e7a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e7c7e7a3841bf156af2c461faa23ee877a9b05e9))
* expand options based on FusionAuth capabilities ([cdede6e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cdede6ebf915d2816ba42d6db5b18d8a9b8461b9))
* prototype ([856fb79](https://github.com/FusionAuth/fusionauth-android-sdk/commit/856fb795af3bb2dc68cdf00fca7b339a4c340329))
* soc 2 compliant release workflow ([#149](https://github.com/FusionAuth/fusionauth-android-sdk/issues/149)) ([013c509](https://github.com/FusionAuth/fusionauth-android-sdk/commit/013c509e142c8ed3e24bcd6c738f7d5e972ab154))
* use tenant for OpenID Configuration request ([a1f6ed1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/a1f6ed1346bc3e97d922e6b30522ca8aab321282))


### Bug Fixes

* Add additional scopes in fusionauth config and make email_verified optional in UserInfo ([#63](https://github.com/FusionAuth/fusionauth-android-sdk/issues/63)) ([6aca131](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6aca131b1ffe54868f05e31800d8581378650c3e))
* add fusionauth-1.56.0 ([#168](https://github.com/FusionAuth/fusionauth-android-sdk/issues/168)) ([f8990c4](https://github.com/FusionAuth/fusionauth-android-sdk/commit/f8990c4a35b6cafeb02ddd14b4bd56e371580a8e))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 6 updates ([#162](https://github.com/FusionAuth/fusionauth-android-sdk/issues/162)) ([4ac165d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/4ac165dd7a361c8c938261cc9bbb2f96fd7fc619))
* **fusionauth:** kickstart styling and latest config ([55b0c23](https://github.com/FusionAuth/fusionauth-android-sdk/commit/55b0c2335d101eb6f50c4807c1ec0254f4e83e9d))
* Implement IdToken deserialization ([#45](https://github.com/FusionAuth/fusionauth-android-sdk/issues/45)) ([8760a02](https://github.com/FusionAuth/fusionauth-android-sdk/commit/8760a02548a4592a5f19c02dda1b1804d4ae519b))
* improve handling of cancel / logged out ([3a33917](https://github.com/FusionAuth/fusionauth-android-sdk/commit/3a33917fbfb620a4a9cd634dad27c11e194dc304))
* improve handling of cancel / logged out ([0978df2](https://github.com/FusionAuth/fusionauth-android-sdk/commit/0978df24eec8c137937babc97321390467d7948a))
* move cancelIntent ([63f388a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/63f388a8be0f2458a569823a5bae4402cf5fe43f))
* **oauth:** update handleRedirect exception handling ([#138](https://github.com/FusionAuth/fusionauth-android-sdk/issues/138)) ([6f0bc21](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6f0bc21ed0d770610c98033c681e309a5f0e4b4b))
* **release:** add missed detekt pre-check and workflow_call ([#154](https://github.com/FusionAuth/fusionauth-android-sdk/issues/154)) ([db25cc6](https://github.com/FusionAuth/fusionauth-android-sdk/commit/db25cc61b47761c6d958aa0040037ff84020dd69))
* **release:** add prerelease-manifest.json to release-config.json ([96859aa](https://github.com/FusionAuth/fusionauth-android-sdk/commit/96859aaf9563092159ef257fc114ee76689591c4))
* **release:** align release and prerelease-config.json ([1e0c34e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/1e0c34e49b108e01b8d85f7f3ef68dae88e1584e))
* **release:** move pre-checks to commit-checks ([a665944](https://github.com/FusionAuth/fusionauth-android-sdk/commit/a665944d7472e95a9bafca0cb53a35a8e5af79a8))
* **release:** move pre-checks to commit-checks ([d21b71f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/d21b71fee61cc244e20441334f19fe86e5d2830f))
* **release:** remove sync prerelease manifest steps ([3fec835](https://github.com/FusionAuth/fusionauth-android-sdk/commit/3fec8356dd4d9760905b6d767ba31888b3acb8c9))
* remove codeChallenge and codeChallengeMethod ([#136](https://github.com/FusionAuth/fusionauth-android-sdk/issues/136)) ([eebb80a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/eebb80a503e46ae37b92e5c2964cf81774f1104b)), closes [#130](https://github.com/FusionAuth/fusionauth-android-sdk/issues/130)
* replace dynamic ic_launcher icons, remove un-used assets ([#53](https://github.com/FusionAuth/fusionauth-android-sdk/issues/53)) ([854d8f9](https://github.com/FusionAuth/fusionauth-android-sdk/commit/854d8f996e177a7ef1703a14be66eef13233a29c))
* replace ic_launcher icons ([#52](https://github.com/FusionAuth/fusionauth-android-sdk/issues/52)) ([cd976ee](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cd976ee06e9822a322335d003a187d1943e6f6e3))
* set manifestPlaceholders ([c2e2148](https://github.com/FusionAuth/fusionauth-android-sdk/commit/c2e21485f6bd63e07f05e4b868fe2cbb305318e7))


### Code Refactoring

* add some files to gitignore ([df4d354](https://github.com/FusionAuth/fusionauth-android-sdk/commit/df4d3546ffe91e5aadb5bd7ff631cbcec6448c88))
* cancelIntent parameter from authorize/logout to options ([72329fb](https://github.com/FusionAuth/fusionauth-android-sdk/commit/72329fb637dc3493ea52ba11d4a3abe1a0a51f9c))
* detekt findings ([5be7532](https://github.com/FusionAuth/fusionauth-android-sdk/commit/5be75323d6f24e71bfb994fdfa7088f88eeddb2f))
* **fusionauth:** bump fusionauth to 1.51.1 ([dcdc222](https://github.com/FusionAuth/fusionauth-android-sdk/commit/dcdc222360c3c674c1d2d621553a12bf9bf505a9))
* **fusionauth:** bump fusionauth to 1.51.2 ([0138e8c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/0138e8cb6878b0900054f1f63670c1937d73ce5b))
* **fusionauth:** update e2e-tests with version 1.50.1 ([#60](https://github.com/FusionAuth/fusionauth-android-sdk/issues/60)) ([7eab1f4](https://github.com/FusionAuth/fusionauth-android-sdk/commit/7eab1f4083dd257737d5e0307b29c276ea3292ac))
* **fusionauth:** update e2e-tests with version 1.51.0 ([#76](https://github.com/FusionAuth/fusionauth-android-sdk/issues/76)) ([dd1fc1d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/dd1fc1dc4e5f10e1e51b1f2030ff6d1dadd98f39))
* **kickstart:** update application ID ([1e461f2](https://github.com/FusionAuth/fusionauth-android-sdk/commit/1e461f256a4a0caf2aeaf6d485d6726b689239e6))
* move json Instance to companion object ([7868ccf](https://github.com/FusionAuth/fusionauth-android-sdk/commit/7868ccfa3d88946db5bb7d8f14d3fb3fd1a62885))
* move OAuth classes to oauth package ([ef771ee](https://github.com/FusionAuth/fusionauth-android-sdk/commit/ef771ee4f47b57cbb4900a429f99822764e14e01))
* remove initStorage method from AuthorizationManager ([3e3092d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/3e3092d145717c122c896f71a9148b4e9cf159aa))
* remove KeystoreStorage, add fileName param to SharedPreferencesStorage ([fe20fe5](https://github.com/FusionAuth/fusionauth-android-sdk/commit/fe20fe5ec828870d8655ac4c63d8262001ecc6d7))
* rename Authentication to Authorization ([c95d255](https://github.com/FusionAuth/fusionauth-android-sdk/commit/c95d2557fed9c884d1354008acd9ca77a4ef28bb))
* simplify authorize, logout; move state to Intent extras ([e3ee619](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e3ee619f3218e70a1f8c182d54c86166d77658d0))
* simplify issuer scheme validation by removing unnecessary try-catch ([#139](https://github.com/FusionAuth/fusionauth-android-sdk/issues/139)) ([79fdfd1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/79fdfd10f9c5b95d1f43872602d096410cf67dfb))
* Update project naming ([fb7fd6b](https://github.com/FusionAuth/fusionauth-android-sdk/commit/fb7fd6ba6493314de23959482f151b2cad2ad913))
* use freshAccessToken in getUserInfo ([7eb4b0d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/7eb4b0df943675eb85fb7feacf6376c2ddfa7d8b))
* use KTX extensions ([#208](https://github.com/FusionAuth/fusionauth-android-sdk/issues/208)) ([48963b9](https://github.com/FusionAuth/fusionauth-android-sdk/commit/48963b9ccbe28fa5a579056ec634d4be96444e8e))
* validate issuer (url) when retrieving configuration ([#137](https://github.com/FusionAuth/fusionauth-android-sdk/issues/137)) ([be583a0](https://github.com/FusionAuth/fusionauth-android-sdk/commit/be583a0b2696b3de782f0aa561d5c9c5c9645cc4)), closes [#114](https://github.com/FusionAuth/fusionauth-android-sdk/issues/114)


### Miscellaneous Chores

* forcing version 1.1.0-rc to be created. ([add3cff](https://github.com/FusionAuth/fusionauth-android-sdk/commit/add3cffc717d9ad5ab62446892869d568893ade4))
* getting ready for the next release. ([b9b2bbc](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b9b2bbc00927ae5bef2dcb5b4b1989000477a579))
* **main:** release 0.2.0 ([6493c4e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6493c4ef30f7bf5ffb5dd1d7d260c9d974677087))
* **main:** release 0.2.0 ([ba98d2f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/ba98d2fe8288cebc1cb738516bb63f53f10d84b8))
* **main:** release 0.2.0-rc ([2da6738](https://github.com/FusionAuth/fusionauth-android-sdk/commit/2da6738f78a92c995fdf062966cfd69b6ff1c1c2))
* **main:** release 0.2.0-rc ([c4ae01e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/c4ae01ed3869a81c276b1abdce6e0c98ae86b8be))
* **main:** release 1.0.0 ([#272](https://github.com/FusionAuth/fusionauth-android-sdk/issues/272)) ([70a7f85](https://github.com/FusionAuth/fusionauth-android-sdk/commit/70a7f85ae2300af1ffcbbb2811dfb8fa34c1d820))
* **main:** release 1.0.0-rc ([#269](https://github.com/FusionAuth/fusionauth-android-sdk/issues/269)) ([edd1bc4](https://github.com/FusionAuth/fusionauth-android-sdk/commit/edd1bc42a25b747ebfa08e033bafa8988ca88111))
* **main:** release 1.1.0-rc ([#299](https://github.com/FusionAuth/fusionauth-android-sdk/issues/299)) ([f6c0d0f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/f6c0d0f5def31b2cf4bc602642e1549dd1a5db89))
* manual version sync to prerelease-manifest.json ([62901e1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/62901e13c246d8805cad1edd3c2e1501268a3eb9))
* Moving from OSSRH to the Maven Central Portal to publish the SDK library release. ([#276](https://github.com/FusionAuth/fusionauth-android-sdk/issues/276)) ([6f1591d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6f1591daf334fef7f3f57d57cc480e919f98a482))
* **pre-release:** 0.1.3-0 🎉 ([1a00655](https://github.com/FusionAuth/fusionauth-android-sdk/commit/1a00655f3d8d19f77b4791180ffe856b2e7705eb))
* **pre-release:** 0.1.3-1 🎉 ([c592fec](https://github.com/FusionAuth/fusionauth-android-sdk/commit/c592fecdc37ae73dda04fb7b9e9331512d887397))
* **pre-release:** 0.1.5-0 🎉 ([9b69e3a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/9b69e3a9590067feb9d89e57c84fc9ae93f6150b))
* **pre-release:** 0.1.7-0 🎉 ([b60bef2](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b60bef2e5f283763d7b24b5e202095d3e692adbd))
* **pre-release:** 0.1.7-1 🎉 ([a2144de](https://github.com/FusionAuth/fusionauth-android-sdk/commit/a2144de1373799b35036982ffb40c750d4989a13))
* release 1.0.0-rc ([f5038f5](https://github.com/FusionAuth/fusionauth-android-sdk/commit/f5038f52ff491e2c2a32568e685feb2736a3c009))
* release 1.0.0-rc ([545cf93](https://github.com/FusionAuth/fusionauth-android-sdk/commit/545cf93b6ffdc828bac96a379bc30e1251389771))
* **release:** 0.1.3 🎉 ([ffff208](https://github.com/FusionAuth/fusionauth-android-sdk/commit/ffff20870320f72918969e0f5a4d2696d6009ae9))
* **release:** 0.1.4 🎉 ([7eb3088](https://github.com/FusionAuth/fusionauth-android-sdk/commit/7eb30888fd89a721202cbef314a343196600aab2))
* **release:** 0.1.5 🎉 ([c9e6aed](https://github.com/FusionAuth/fusionauth-android-sdk/commit/c9e6aed956a137866db85cf4598f0c36ccc8f36c))
* **release:** 0.1.6 🎉 ([7079c48](https://github.com/FusionAuth/fusionauth-android-sdk/commit/7079c48b6b7fc26f7529f121c2e5062da71434a1))
* **release:** 0.1.7 🎉 ([961b4a7](https://github.com/FusionAuth/fusionauth-android-sdk/commit/961b4a7becc408e4331581c29398ad7e0d967d60))
* **release:** 0.1.7-2 🎉 ([efd6c36](https://github.com/FusionAuth/fusionauth-android-sdk/commit/efd6c3659562c9089ede939d051802b49e0b8a25))
* **release:** 0.1.7-3 🎉 ([51e8bb8](https://github.com/FusionAuth/fusionauth-android-sdk/commit/51e8bb8f561a675ecf34d9378e2733f670b59e9a))
* **release:** 0.1.7-4 🎉 ([6999adf](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6999adf2830def286bd1b9139ee3fc8680fb898a))
* set the current release. ([390c9f1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/390c9f1977fb9c5a5d9640a530c1e82de9b4a827))


### Build System and Dependencies

* **app:** update version to 1.0.0 ([b7b7f33](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b7b7f33e851ec24f6c509ac346a76a7692f291ec))
* **deps:** bump androidx.lifecycle:lifecycle-runtime-ktx ([#67](https://github.com/FusionAuth/fusionauth-android-sdk/issues/67)) ([2864035](https://github.com/FusionAuth/fusionauth-android-sdk/commit/2864035d7f7ba2bd79fe74d6dc5c39f73ae9636f))
* **deps:** bump androidx.lifecycle:lifecycle-runtime-ktx ([#96](https://github.com/FusionAuth/fusionauth-android-sdk/issues/96)) ([16885d0](https://github.com/FusionAuth/fusionauth-android-sdk/commit/16885d03308d7dd5a2ccf2bb632e9e86b358e10b))
* **deps:** bump androidx.test:runner ([#102](https://github.com/FusionAuth/fusionauth-android-sdk/issues/102)) ([909c612](https://github.com/FusionAuth/fusionauth-android-sdk/commit/909c61237b0c6d555dd5c942e5ff1a5ee158c519))
* **deps:** bump fusionauth to 1.54.0 and android to 35 ([#105](https://github.com/FusionAuth/fusionauth-android-sdk/issues/105)) ([34526b7](https://github.com/FusionAuth/fusionauth-android-sdk/commit/34526b759edc500d227c8995087e7e7db51873f3))
* **deps:** bump fusionauth/fusionauth-app in /fusionauth/latest ([#166](https://github.com/FusionAuth/fusionauth-android-sdk/issues/166)) ([40b0a73](https://github.com/FusionAuth/fusionauth-android-sdk/commit/40b0a7334893c5c46f30659447b85aefa6b37906))
* **deps:** bump fusionauth/fusionauth-app in /fusionauth/latest ([#188](https://github.com/FusionAuth/fusionauth-android-sdk/issues/188)) ([6c79e0d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/6c79e0d38a3ecc3f0c531504b76df152eda93256))
* **deps:** bump fusionauth/fusionauth-app in /fusionauth/latest ([#198](https://github.com/FusionAuth/fusionauth-android-sdk/issues/198)) ([11b36f0](https://github.com/FusionAuth/fusionauth-android-sdk/commit/11b36f003b6c540c4883dc9996fddd55e5fd21db))
* **deps:** bump github/codeql-action in the prod-github-actions group ([#293](https://github.com/FusionAuth/fusionauth-android-sdk/issues/293)) ([b6d869c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b6d869c552d2cb1d6d9b468a967d22f70e67ccb9))
* **deps:** bump github/codeql-action in the prod-github-actions group ([#90](https://github.com/FusionAuth/fusionauth-android-sdk/issues/90)) ([c800508](https://github.com/FusionAuth/fusionauth-android-sdk/commit/c800508ef248873ec9ac2f98deee9f0ca51a5e18))
* **deps:** bump gradle to 8.6 ([17962d9](https://github.com/FusionAuth/fusionauth-android-sdk/commit/17962d9d3b56bc353f056f8e1fe5d4a733c1d3ac))
* **deps:** bump gradle-major-dependencies ([#74](https://github.com/FusionAuth/fusionauth-android-sdk/issues/74)) ([ce87629](https://github.com/FusionAuth/fusionauth-android-sdk/commit/ce87629dad3972377e3083c4a3ec2d538e7f415c))
* **deps:** bump gradle/actions ([#87](https://github.com/FusionAuth/fusionauth-android-sdk/issues/87)) ([4d20664](https://github.com/FusionAuth/fusionauth-android-sdk/commit/4d20664ffb6b9c55055c22f49b16f974a32d32c3))
* **deps:** bump gradle/actions in the prod-github-actions group ([#55](https://github.com/FusionAuth/fusionauth-android-sdk/issues/55)) ([2d16df0](https://github.com/FusionAuth/fusionauth-android-sdk/commit/2d16df0fa86c8acba3d9bdf35bee3ef94fc3f04f))
* **deps:** bump gradlew to 8.12 ([#145](https://github.com/FusionAuth/fusionauth-android-sdk/issues/145)) ([4095ea0](https://github.com/FusionAuth/fusionauth-android-sdk/commit/4095ea00b16311e06220f843c494c00ad0b6fbe5))
* **deps:** bump gradlew to 8.8 ([5ea952e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/5ea952ef9870de6fde60a60d27fd8a5f9a5470c4))
* **deps:** bump gradlew to 8.9 ([9d0ab96](https://github.com/FusionAuth/fusionauth-android-sdk/commit/9d0ab9614d70525934b2942393cd4d4ab26c23e1))
* **deps:** bump io.github.gradle-nexus.publish-plugin ([#78](https://github.com/FusionAuth/fusionauth-android-sdk/issues/78)) ([cc2b3fd](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cc2b3fdb30028c0fd01eb15caf5d32b1b52d2788))
* **deps:** bump opensearchproject/opensearch in /fusionauth/latest ([#165](https://github.com/FusionAuth/fusionauth-android-sdk/issues/165)) ([b5b2d79](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b5b2d791726388cd63e131ce9432ef08b39db903))
* **deps:** bump opensearchproject/opensearch in /fusionauth/latest ([#201](https://github.com/FusionAuth/fusionauth-android-sdk/issues/201)) ([2f86c43](https://github.com/FusionAuth/fusionauth-android-sdk/commit/2f86c4327cb8e357ca9cf8ec71cd572b9d358e37))
* **deps:** bump opensearchproject/opensearch in /fusionauth/latest ([#284](https://github.com/FusionAuth/fusionauth-android-sdk/issues/284)) ([b51b360](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b51b360ba519a4e2881c63e4a971f3dcbacd646d))
* **deps:** bump org.jetbrains.dokka from 1.9.20 to 2.0.0 ([#143](https://github.com/FusionAuth/fusionauth-android-sdk/issues/143)) ([d397865](https://github.com/FusionAuth/fusionauth-android-sdk/commit/d397865310125091be3e22a6b1562672dc726c26))
* **deps:** bump postgres from 16.9-bookworm to 18.0-bookworm in /fusionauth/latest ([cd4f407](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cd4f407bc2b70bdb335a2b16d944e144edaa582d))
* **deps:** bump postgres from 18.0-bookworm to 18.1-bookworm in /fusionauth/latest ([aee163e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/aee163ea18504297c6f56a6fdf60c84577487810))
* **deps:** bump postgres in /fusionauth/latest ([9593603](https://github.com/FusionAuth/fusionauth-android-sdk/commit/95936034ee9f252737725a60ad77d9cb8599a67a))
* **deps:** bump postgres in /fusionauth/latest ([b892ea2](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b892ea236e06cc8eb86010fab7bcee58441a9208))
* **deps:** bump postgres in /fusionauth/latest ([#176](https://github.com/FusionAuth/fusionauth-android-sdk/issues/176)) ([e7747b1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e7747b15afd3d6c7396eda50fe124a5728ab014a))
* **deps:** bump postgres in /fusionauth/latest ([#205](https://github.com/FusionAuth/fusionauth-android-sdk/issues/205)) ([451803c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/451803cbf9b18f785915d30d355604ea306e2683))
* **deps:** bump the gradle-minor-dependencies group ([#213](https://github.com/FusionAuth/fusionauth-android-sdk/issues/213)) ([a511679](https://github.com/FusionAuth/fusionauth-android-sdk/commit/a511679a9a6729fce3fe8bb67d4343172b6e73db))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 10 updates ([b8a8104](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b8a81044106338306f44b46bb626cba04b0c3527))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 10 updates ([e142c9c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e142c9ceddf6b4a6e18250013f09de0d209a2eb8))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 10 updates ([#65](https://github.com/FusionAuth/fusionauth-android-sdk/issues/65)) ([21822eb](https://github.com/FusionAuth/fusionauth-android-sdk/commit/21822eb9ad19726a287b76121b690b62539442a5))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 3 updates ([#94](https://github.com/FusionAuth/fusionauth-android-sdk/issues/94)) ([f7ab3da](https://github.com/FusionAuth/fusionauth-android-sdk/commit/f7ab3da8708f15101c7697a221e9127d5fe0a58f))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 4 updates ([#189](https://github.com/FusionAuth/fusionauth-android-sdk/issues/189)) ([389936f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/389936f5d062361d1a67d24c4b21749404c44646))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 5 updates ([#182](https://github.com/FusionAuth/fusionauth-android-sdk/issues/182)) ([68f2e20](https://github.com/FusionAuth/fusionauth-android-sdk/commit/68f2e207cab81196bcfff93594bfe97cb7f667a8))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 7 updates ([#118](https://github.com/FusionAuth/fusionauth-android-sdk/issues/118)) ([df48f74](https://github.com/FusionAuth/fusionauth-android-sdk/commit/df48f747907aa03b5ca704b34e1d259e01c8720c))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 8 updates ([#108](https://github.com/FusionAuth/fusionauth-android-sdk/issues/108)) ([473753c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/473753c2cf5b141b105c08e0d369fc341d7c32b3))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 8 updates ([#89](https://github.com/FusionAuth/fusionauth-android-sdk/issues/89)) ([12c603e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/12c603ea2c55b913c07f87e9da639394d9d57756))
* **deps:** bump the gradle-minor-dependencies group across 1 directory with 9 updates ([#150](https://github.com/FusionAuth/fusionauth-android-sdk/issues/150)) ([cb33e7b](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cb33e7b3920e5dbe9331ca482cf9def43cd6fb45))
* **deps:** bump the gradle-minor-dependencies group with 13 updates ([#27](https://github.com/FusionAuth/fusionauth-android-sdk/issues/27)) ([783906f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/783906f4a67727fec23492ccf2d4391f412b081d))
* **deps:** bump the gradle-minor-dependencies group with 2 updates ([#109](https://github.com/FusionAuth/fusionauth-android-sdk/issues/109)) ([88e45f4](https://github.com/FusionAuth/fusionauth-android-sdk/commit/88e45f4aa8d4897599e80907476fbc76cd1b1296))
* **deps:** bump the gradle-minor-dependencies group with 2 updates ([#175](https://github.com/FusionAuth/fusionauth-android-sdk/issues/175)) ([b9cbfa6](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b9cbfa6bfb3cdd480ecff9adc58f393fd342cf7a))
* **deps:** bump the gradle-minor-dependencies group with 2 updates ([#69](https://github.com/FusionAuth/fusionauth-android-sdk/issues/69)) ([514787d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/514787d59d9836bc827291c31a45cedcd53ba555))
* **deps:** bump the gradle-minor-dependencies group with 2 updates ([#77](https://github.com/FusionAuth/fusionauth-android-sdk/issues/77)) ([504045d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/504045da2318edb6abb56303278e2c737da96233))
* **deps:** bump the gradle-minor-dependencies group with 2 updates ([#82](https://github.com/FusionAuth/fusionauth-android-sdk/issues/82)) ([670587a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/670587af114705e35824499c450cb083ce6016cb))
* **deps:** bump the gradle-minor-dependencies group with 2 updates ([#83](https://github.com/FusionAuth/fusionauth-android-sdk/issues/83)) ([bf7498b](https://github.com/FusionAuth/fusionauth-android-sdk/commit/bf7498b8858e4db23e31caccf7466080974d56b4))
* **deps:** bump the gradle-minor-dependencies group with 3 updates ([#104](https://github.com/FusionAuth/fusionauth-android-sdk/issues/104)) ([4d9ba0b](https://github.com/FusionAuth/fusionauth-android-sdk/commit/4d9ba0bf3228e23d7ec3d4cf964935170466416b))
* **deps:** bump the gradle-minor-dependencies group with 3 updates ([#84](https://github.com/FusionAuth/fusionauth-android-sdk/issues/84)) ([829c7b2](https://github.com/FusionAuth/fusionauth-android-sdk/commit/829c7b2410cc3fc71f6d39e99b1c298e42740208))
* **deps:** bump the gradle-minor-dependencies group with 4 updates ([#119](https://github.com/FusionAuth/fusionauth-android-sdk/issues/119)) ([be261cc](https://github.com/FusionAuth/fusionauth-android-sdk/commit/be261cc934972ec98c6d178423e43d1a5c85a51c))
* **deps:** bump the gradle-minor-dependencies group with 5 updates ([#99](https://github.com/FusionAuth/fusionauth-android-sdk/issues/99)) ([db4dda1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/db4dda18f134ed08aaaf8a940e2902c8ad53036b))
* **deps:** bump the gradle-minor-dependencies group with 7 updates ([#111](https://github.com/FusionAuth/fusionauth-android-sdk/issues/111)) ([aea1611](https://github.com/FusionAuth/fusionauth-android-sdk/commit/aea161127d24f09aa5a5e664c4fd5bdccc65e788))
* **deps:** bump the gradle-minor-dependencies group with 7 updates ([#43](https://github.com/FusionAuth/fusionauth-android-sdk/issues/43)) ([19d7480](https://github.com/FusionAuth/fusionauth-android-sdk/commit/19d748025c01a8e43b8f41fcd4b9a2d75b94b15f))
* **deps:** bump the prod-github-actions group across 1 directory with 2 updates ([#97](https://github.com/FusionAuth/fusionauth-android-sdk/issues/97)) ([b5a85e1](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b5a85e1c3c22777fbd3f37e45fd3d38ede374185))
* **deps:** bump the prod-github-actions group across 1 directory with 3 updates ([10e737c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/10e737cb3b6b2ee7dd7a213e7db50cfb2d2c0c5d))
* **deps:** bump the prod-github-actions group across 1 directory with 3 updates ([b753dd4](https://github.com/FusionAuth/fusionauth-android-sdk/commit/b753dd49315ed4abeae3abce6d44804af253fb33))
* **deps:** bump the prod-github-actions group across 1 directory with 3 updates ([#93](https://github.com/FusionAuth/fusionauth-android-sdk/issues/93)) ([7595706](https://github.com/FusionAuth/fusionauth-android-sdk/commit/7595706cccb227144540fdf4ae51bd5993749f82))
* **deps:** bump the prod-github-actions group across 1 directory with 4 updates ([477958e](https://github.com/FusionAuth/fusionauth-android-sdk/commit/477958e7cc3a2af698c557643b8f628d740c01a3))
* **deps:** bump the prod-github-actions group across 1 directory with 4 updates ([cd2cf36](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cd2cf36fe94c84a88c27f9e2dd6d0391b5547b77))
* **deps:** bump the prod-github-actions group across 1 directory with 4 updates ([#303](https://github.com/FusionAuth/fusionauth-android-sdk/issues/303)) ([3151013](https://github.com/FusionAuth/fusionauth-android-sdk/commit/3151013c7879804694b09852fd1d0a4ca89279a1))
* **deps:** bump the prod-github-actions group across 1 directory with 4 updates ([#81](https://github.com/FusionAuth/fusionauth-android-sdk/issues/81)) ([002058d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/002058d38ad8aac56ed97a033507387c9e955bb2))
* **deps:** bump the prod-github-actions group across 1 directory with 5 updates ([#151](https://github.com/FusionAuth/fusionauth-android-sdk/issues/151)) ([42b8762](https://github.com/FusionAuth/fusionauth-android-sdk/commit/42b8762e1741c88b28201fcac78e8a7d1f86f9d8))
* **deps:** bump the prod-github-actions group across 1 directory with 6 updates ([#285](https://github.com/FusionAuth/fusionauth-android-sdk/issues/285)) ([88c5cfd](https://github.com/FusionAuth/fusionauth-android-sdk/commit/88c5cfd41e76b520dfa08bed7b6f3027e18ef3ac))
* **deps:** bump the prod-github-actions group across 1 directory with 9 updates ([72fe708](https://github.com/FusionAuth/fusionauth-android-sdk/commit/72fe708b1a6ec604cd35438cb4097ecb9104f7e9))
* **deps:** bump the prod-github-actions group across 1 directory with 9 updates ([74f8d2f](https://github.com/FusionAuth/fusionauth-android-sdk/commit/74f8d2f11b9e0c4a3cd1e67af1a668a96bee1cd0))
* **deps:** bump the prod-github-actions group with 1 update ([#21](https://github.com/FusionAuth/fusionauth-android-sdk/issues/21)) ([d2cf57d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/d2cf57dda9d741a077f15821399f5add73762aad))
* **deps:** bump the prod-github-actions group with 1 update ([#51](https://github.com/FusionAuth/fusionauth-android-sdk/issues/51)) ([f91b425](https://github.com/FusionAuth/fusionauth-android-sdk/commit/f91b4257e25b8467a7e7003e063edcef2552df8a))
* **deps:** bump the prod-github-actions group with 2 updates ([#26](https://github.com/FusionAuth/fusionauth-android-sdk/issues/26)) ([e4a2a88](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e4a2a88e2652e8d45bd3bca6a92a1e1ebb3c4e62))
* **deps:** bump the prod-github-actions group with 2 updates ([#33](https://github.com/FusionAuth/fusionauth-android-sdk/issues/33)) ([e5994a9](https://github.com/FusionAuth/fusionauth-android-sdk/commit/e5994a902b5c2f9e3bef1e51a89eb14aa93c9c32))
* **deps:** bump the prod-github-actions group with 2 updates ([#47](https://github.com/FusionAuth/fusionauth-android-sdk/issues/47)) ([7dc5add](https://github.com/FusionAuth/fusionauth-android-sdk/commit/7dc5add78ccdf448fafb68ad7abe40f67f6a1c80))
* **deps:** bump the prod-github-actions group with 2 updates ([#49](https://github.com/FusionAuth/fusionauth-android-sdk/issues/49)) ([fd10a05](https://github.com/FusionAuth/fusionauth-android-sdk/commit/fd10a0550d10a23559ac4f3c718eed965d9ae62c))
* **deps:** bump the prod-github-actions group with 2 updates ([#54](https://github.com/FusionAuth/fusionauth-android-sdk/issues/54)) ([1f2f8ab](https://github.com/FusionAuth/fusionauth-android-sdk/commit/1f2f8aba9725f234dd0a10457486718aa2eddf67))
* **deps:** bump the prod-github-actions group with 2 updates ([#66](https://github.com/FusionAuth/fusionauth-android-sdk/issues/66)) ([af2ea99](https://github.com/FusionAuth/fusionauth-android-sdk/commit/af2ea9981081630ee2c37597772b41e47a5ed02b))
* **deps:** bump the prod-github-actions group with 2 updates ([#68](https://github.com/FusionAuth/fusionauth-android-sdk/issues/68)) ([cf0b81a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cf0b81ad61b9130882077ee7411e5ba3f2a24b17))
* **deps:** bump the prod-github-actions group with 2 updates ([#73](https://github.com/FusionAuth/fusionauth-android-sdk/issues/73)) ([0144f4a](https://github.com/FusionAuth/fusionauth-android-sdk/commit/0144f4aa0e2ebd917a0f175b112c19e96b2e241c))
* **deps:** bump the prod-github-actions group with 3 updates ([#85](https://github.com/FusionAuth/fusionauth-android-sdk/issues/85)) ([fba2123](https://github.com/FusionAuth/fusionauth-android-sdk/commit/fba212378d1be65c96f26bdf288cf5ebff49d53b))
* **deps:** bump the prod-github-actions group with 4 updates ([#44](https://github.com/FusionAuth/fusionauth-android-sdk/issues/44)) ([749e9ee](https://github.com/FusionAuth/fusionauth-android-sdk/commit/749e9ee2319cb9cc94bfec40773e71ac407ca7d3))
* **deps:** bump the prod-github-actions group with 4 updates ([#58](https://github.com/FusionAuth/fusionauth-android-sdk/issues/58)) ([9df9bf7](https://github.com/FusionAuth/fusionauth-android-sdk/commit/9df9bf7f7a049eb7d23e99944f675b41eac8beeb))
* **deps:** bump the prod-github-actions group with 4 updates ([#59](https://github.com/FusionAuth/fusionauth-android-sdk/issues/59)) ([827effa](https://github.com/FusionAuth/fusionauth-android-sdk/commit/827effa67c05e718f183d690db7e2af9006c11df))
* **deps:** downgrade com.android.application to 8.2.2 ([ee0e582](https://github.com/FusionAuth/fusionauth-android-sdk/commit/ee0e58263475c28e7e92f301e83c9ad0db8710b3))


### Docs

* add docs to AuthenticationManager ([cebb24c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/cebb24c613cc0d0610bcdfabc6518893b5c4c99d))
* add more docs ([36aebc3](https://github.com/FusionAuth/fusionauth-android-sdk/commit/36aebc34014e98f2184893bd8b0a1ab8183a2844))
* **FullE2ETest:** update test description ([01f7faa](https://github.com/FusionAuth/fusionauth-android-sdk/commit/01f7faab1f8aafbe470cc8714a17cb4591999c8e))
* initial draft ([85e1fa7](https://github.com/FusionAuth/fusionauth-android-sdk/commit/85e1fa7b4964b5c1742c932430dcf6e372532c14))
* **README:** add Supported Versions to release process ([605abac](https://github.com/FusionAuth/fusionauth-android-sdk/commit/605abaca512a5999722d48f5feb1f99231af5ea2))
* **README:** additional instructions to release process ([107705d](https://github.com/FusionAuth/fusionauth-android-sdk/commit/107705d20064b93a606567ae7853f9b50191030d))
* **README:** fix broken link ([efe496c](https://github.com/FusionAuth/fusionauth-android-sdk/commit/efe496cca0de8e77eaff76971aa79aac3ab30d01))
* **README:** fix code highlighting ([#160](https://github.com/FusionAuth/fusionauth-android-sdk/issues/160)) ([ec19632](https://github.com/FusionAuth/fusionauth-android-sdk/commit/ec19632b741b0a37acc5f9450eccebd26d5fc087))
* **README:** fix wrong link ([58dfe07](https://github.com/FusionAuth/fusionauth-android-sdk/commit/58dfe07701a2fc70b8e625d35160df42fa43118e))
* **README:** further detail release process ([8ee26b2](https://github.com/FusionAuth/fusionauth-android-sdk/commit/8ee26b226398e8a2588397e779962ec7d5f940f2))
* **README:** update quickstart reference ([f958a73](https://github.com/FusionAuth/fusionauth-android-sdk/commit/f958a739040d7c31e11f2688a0b26c375f1cd8d7))
* **README:** update quickstart reference ([caee875](https://github.com/FusionAuth/fusionauth-android-sdk/commit/caee875ecd3b63159912479fd1df91abe7e7c144))
* **README:** update quickstart URL ([12c0596](https://github.com/FusionAuth/fusionauth-android-sdk/commit/12c0596589dd269aad25088cbd22c8e6aceacd29))
* **README:** update release workflow details ([80e89a7](https://github.com/FusionAuth/fusionauth-android-sdk/commit/80e89a7c8c554b5152ebf251ebfd67524a0157aa))
* **README:** update structure, ToC and add testing reference ([2b891a0](https://github.com/FusionAuth/fusionauth-android-sdk/commit/2b891a02272d5f3948c64e03662e36fbd97f16ff))
* split README into CONTRIBUTING and CODE_OF_CONDUCT ([007dbc9](https://github.com/FusionAuth/fusionauth-android-sdk/commit/007dbc910e44f7a277632c586d508c4b12430701))

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
