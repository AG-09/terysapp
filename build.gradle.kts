// ============================================================
// PROJECT-LEVEL build.gradle.kts
// This file applies to the WHOLE project (not just one module).
// It just tells Gradle which plugins are available to use,
// but does NOT apply them yet (apply false).
// The actual "app" module (app/build.gradle.kts) applies them.
// ============================================================
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
}
