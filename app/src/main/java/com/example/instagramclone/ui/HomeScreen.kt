package com.example.instagramclone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ============================================================
// HomeScreen
// A very simple "feed" screen shown right after the user logs in.
// It shows a top bar (with app name + logout button) and a
// scrollable list of fake "posts" (just colored boxes, since this
// is a bare-bones clone with no real photos/backend).
//
// onLogout: callback passed from MainActivity, called when the
// user taps the logout icon, which sends them back to LoginScreen.
// ============================================================
@Composable
fun HomeScreen(onLogout: () -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {

        // ---- Top bar: app title + logout button ----
        TopAppBar(
            title = {
                Text(
                    text = "Instagram",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            },
            actions = {
                // Tapping this icon logs the user out
                IconButton(onClick = onLogout) {
                    Icon(
                        imageVector = Icons.Filled.ExitToApp,
                        contentDescription = "Log out"
                    )
                }
            }
        )

        Divider()

        // ---- Feed: a scrollable list of fake posts ----
        // LazyColumn only draws items currently visible on screen,
        // which makes long scrolling lists fast/efficient.
        LazyColumn(modifier = Modifier.fillMaxSize()) {

            // We just generate 10 fake posts, numbered 1..10,
            // since there's no real backend/database in this demo.
            items(10) { index ->
                FakePostItem(postNumber = index + 1)
            }
        }
    }
}

// One single fake "post" in the feed: a header row (fake profile
// picture + fake username) and a colored square standing in for
// a photo. No real images are used since this is just a UI demo.
@Composable
private fun FakePostItem(postNumber: Int) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {

        // ---- Post header: fake avatar circle + fake username ----
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // A plain colored circle standing in for a profile picture
            Box(
                modifier = Modifier
                    .height(36.dp)
                    .aspectRatio(1f) // keeps it perfectly circular
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )

            Spacer(modifier = Modifier.padding(start = 8.dp))

            Text(
                text = "user_$postNumber",
                fontWeight = FontWeight.SemiBold
            )
        }

        // ---- Fake "photo": just a colored square ----
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f) // square, like a typical Instagram post
                .background(
                    // Alternates two shades so the feed isn't visually flat
                    if (postNumber % 2 == 0) Color(0xFFE0E0E0) else Color(0xFFBDBDBD)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Post #$postNumber", color = Color.DarkGray)
        }
    }
}
