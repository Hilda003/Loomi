package com.example.loomi.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class Navigation(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screen: Screen
)
