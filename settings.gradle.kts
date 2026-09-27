// ============================================================
// settings.gradle.kts
// Tells Gradle: "where do I download plugins/libraries from?"
// and "which modules/folders belong to this project?"
// ============================================================
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "InstagramClone"
// "app" is our one and only module (the actual application code)
include(":app")
