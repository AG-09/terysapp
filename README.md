# Instagram Clone (Simple Demo App)

A minimal Android app built with **Kotlin + Jetpack Compose**.
It has exactly two screens, as requested:

1. **Login screen** — username field, password field, "Log In" button.
   (No real server check — any non-empty username + password logs you in.
   This is just a UI demo, not a real authentication system.)
2. **Home screen** — a scrollable fake feed with 10 placeholder "posts"
   and a logout button in the top bar.

## How to open and run it
1. Install **Android Studio** (free, from developer.android.com).
2. Open Android Studio → "Open" → select this `InstagramClone` folder.
3. Let Gradle sync (it will download dependencies automatically —
   needs internet access the first time).
4. Press the green ▶ "Run" button, choose an emulator or a connected
   phone, and the app will install and launch.

## Project structure
```
InstagramClone/
├── build.gradle.kts              <- project-level build config
├── settings.gradle.kts           <- lists modules (just "app")
├── app/
│   ├── build.gradle.kts          <- app dependencies (Compose, etc.)
│   └── src/main/
│       ├── AndroidManifest.xml   <- app's "ID card"
│       ├── java/com/example/instagramclone/
│       │   ├── MainActivity.kt      <- entry point; switches Login/Home
│       │   └── ui/
│       │       ├── LoginScreen.kt   <- login form UI
│       │       └── HomeScreen.kt    <- home feed UI
│       └── res/values/           <- colors, strings, theme
```

Every file has comments explaining what each part does — open them
in Android Studio (or any text editor) to read through the code.
