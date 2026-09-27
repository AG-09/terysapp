package com.example.instagramclone.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ============================================================
// LoginScreen
// A simple login form: username field, password field, and a
// "Log In" button. This is a @Composable function, meaning it
// just describes what should appear on screen - Compose handles
// actually drawing/updating it.
//
// onLoginSuccess: a callback (a function passed in from outside)
// that we call once the user "successfully" logs in. MainActivity
// gave us this function, so this screen doesn't need to know
// anything about what happens after login - it just reports back.
// ============================================================
@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {

    // These hold the current text typed into each field.
    // "remember { mutableStateOf(...) }" = a variable that survives
    // screen redraws and triggers a redraw whenever it changes.
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // A simple error message shown if login fields are empty.
    var errorMessage by remember { mutableStateOf("") }

    // Column = stack items vertically (like a <div style="flex-direction:column">)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // App logo/title text at the top, styled like an Instagram wordmark
        Text(
            text = "Instagram",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(48.dp))

        // ---- Username input field ----
        OutlinedTextField(
            value = username,
            onValueChange = { username = it }, // updates state as user types
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // ---- Password input field ----
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            // Hides the typed characters (shows dots instead)
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Show an error message only if there is one
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        // ---- Log In button ----
        Button(
            onClick = {
                // Very simple check: both fields just need to be non-empty.
                // (This is a demo app, so there's no real backend/server
                // checking real accounts - it's just for learning purposes.)
                if (username.isNotBlank() && password.isNotBlank()) {
                    errorMessage = ""
                    onLoginSuccess() // tells MainActivity "log this user in"
                } else {
                    errorMessage = "Please enter both username and password"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors()
        ) {
            Text("Log In")
        }
    }
}
