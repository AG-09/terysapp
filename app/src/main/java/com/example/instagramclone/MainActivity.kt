package com.example.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import com.example.instagramclone.ui.HomeScreen
import com.example.instagramclone.ui.LoginScreen

// ============================================================
// MainActivity
// This is the ONE screen (Activity) that Android actually opens.
// Instead of creating a separate Activity for "Login" and another
// for "Home" (the old-school way), we use Jetpack Compose and just
// swap out what is drawn on screen based on a simple boolean state:
//   isLoggedIn = false -> show LoginScreen
//   isLoggedIn = true  -> show HomeScreen
// This is the modern, simple way to do it for a small app like this.
// ============================================================
class MainActivity : ComponentActivity() {

    // onCreate() is called automatically by Android when this
    // screen is first created / opened.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContent {} is how we tell Compose "here is what to draw"
        setContent {
            InstagramCloneApp()
        }
    }
}

// The @Composable annotation marks a function as "drawable UI",
// so Compose knows it can render it and re-render it when state changes.
@Composable
fun InstagramCloneApp() {

    // MaterialTheme wraps everything so all screens share the same
    // fonts / colors / shapes automatically.
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {

            // "remember" keeps this value alive across re-draws (recompositions).
            // "mutableStateOf(false)" means: start on the Login screen.
            // When this value changes, Compose automatically re-draws
            // whatever depends on it (that's the "reactive" part of Compose).
            var isLoggedIn by remember { mutableStateOf(false) }

            if (isLoggedIn) {
                // User has logged in successfully -> show the Home feed
                HomeScreen(
                    onLogout = {
                        // Pressing "logout" flips the state back,
                        // which sends the user back to LoginScreen
                        isLoggedIn = false
                    }
                )
            } else {
                // Not logged in yet -> show the Login form
                LoginScreen(
                    onLoginSuccess = {
                        // Called by LoginScreen once username+password
                        // pass the (very simple) check.
                        isLoggedIn = true
                    }
                )
            }
        }
    }
}
