package com.example.loomi.ui.components

import android.view.MenuItem
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.loomi.R

@Composable
fun SettingMenu() {

    var isNightModeEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        MenuItemWithSwitch(
            iconRes = R.drawable.ic_dark_mode,
            title = "Night mode",
            isChecked = isNightModeEnabled,
            onCheckedChange = { isNightModeEnabled = it }
        )
        MenuItem(
            iconRes = R.drawable.ic_notification,
            title = "Notification",
            onClick = { }
        )

        MenuItem(
            iconRes = R.drawable.ic_language,
            title = "Language",
            onClick = { }
        )

        MenuItem(
            iconRes = R.drawable.ic_logout,
            title = "Logout",
            onClick = {  }
        )
    }
}

@Composable
fun MenuItemWithSwitch(
    iconRes: Int,
    title: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFF90A892), shape = RoundedCornerShape(50))
                .padding(8.dp),
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = TextStyle(fontSize = 16.sp, color = Color(0xFF4D6658)),
            modifier = Modifier.weight(1f)

            )
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF4D6658),
                uncheckedThumbColor = Color.Gray
            )
        )

    }

    }


@Composable
fun MenuItem(iconRes: Int, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFF90A892), shape = RoundedCornerShape(50))
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            style = TextStyle(fontSize = 16.sp, color = Color(0xFF4D6658)),
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_chevron),
            contentDescription = null,
            tint = Color(0xFF4D6658),
            modifier = Modifier.size(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsMenu() {
    SettingMenu()
}
