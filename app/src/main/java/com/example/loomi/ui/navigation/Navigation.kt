package com.example.loomi.ui.navigation

import androidx.compose.ui.graphics.painter.Painter

data class Navigation(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val screen: Screen
)
