package com.example.loomi.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Course(
    val id: Int,
    val title: String,
    val description: String,
    val author: String,
    val image: Int,
    val progress: Int,
    val lessonCount: Int,
)
