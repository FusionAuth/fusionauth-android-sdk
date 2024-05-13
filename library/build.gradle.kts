plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlinx-serialization")
    id("org.jetbrains.dokka")
}

android {
    namespace = "io.fusionauth.mobilesdk"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        manifestPlaceholders["appAuthRedirectScheme"] = "io.fusionauth.app"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    lint {
        sarifReport = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.androidbrowserhelper:androidbrowserhelper:2.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-cbor:1.6.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation("net.openid:appauth:0.11.1")
    implementation("androidx.security:security-crypto-ktx:1.1.0-alpha06")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

tasks.dokkaGfm {
    outputDirectory.set(layout.projectDirectory.dir("docs"))
}
