package com.example.loomi.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loomi.ui.components.CourseList
import com.example.loomi.ui.components.GreetingSection


@Composable
fun CourseScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F6F6))
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        GreetingSection(name = "Loomi")
        Spacer(modifier = Modifier.padding(8.dp))
        Search(text = "Search material...", onTextChange ={} , placeHolder = "Search material...")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Courses", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.padding(5.dp))
        CourseList()
    }
}

@Preview
@Composable
fun CourseScreenPreview() {
    CourseScreen()
}