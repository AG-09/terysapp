// ============================================================
// APP-LEVEL build.gradle.kts
// This is the config for the actual "app" module.
// It says: use Kotlin, use Jetpack Compose (Google's modern UI
// toolkit), and what the app's package name / version is.
// ============================================================
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    // The unique ID that identifies this app on a phone / Play Store
    namespace = "com.example.instagramclone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.instagramclone"
        minSdk = 24        // Lowest Android version supported (Android 7.0)
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    // Turn on Jetpack Compose (declarative UI, like React but for Android)
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
}

dependencies {
    // Core Android + Kotlin support
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // Jetpack Compose - the toolkit we use to build the screens
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    // Needed for built-in icons like Icons.Filled.ExitToApp used in HomeScreen
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.compose.material:material-icons-extended")
}
