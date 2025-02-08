package com.example.loomi.ui.screen

import CompleteCard
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loomi.ui.components.SettingMenu

@Composable
fun ProfileScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        AvatarSection()
        Spacer(modifier = Modifier.height(16.dp))
        CompleteCard()
        Spacer(modifier = Modifier.height(24.dp))
        SettingMenu()
    }
}

@Composable
fun AvatarSection() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.LightGray, CircleShape),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_camera),
            contentDescription = "Avatar",
            modifier = Modifier.size(50.dp)
        )
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}