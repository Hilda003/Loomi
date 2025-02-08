package com.example.loomi.ui.screen

import Search
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loomi.data.model.Article
import com.example.loomi.data.model.Course
import com.example.loomi.ui.components.CourseCard
import com.example.loomi.ui.components.GreetingSection
import com.example.loomi.ui.components.ProgressSection
import com.example.loomi.ui.components.RecommendationArticleSection


@Composable
fun HomeScreen(
modifier: Modifier = Modifier
) {
    val state by remember { mutableStateOf(true) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(20.dp)
//            .background(Color)
    ){
        Spacer(modifier = Modifier.padding(top = 16.dp))
        GreetingSection(name = "Hilda")
        Spacer(modifier = Modifier.padding(8.dp))
        Search(text = "Search material...", onTextChange ={} , placeHolder = "Search material...")
        Spacer(modifier = Modifier.padding(16.dp))
        ProgressSection(progress = 80)
        Spacer(modifier = Modifier.padding(16.dp))
        Text(text = "Continue Studying", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.padding(8.dp))
        CourseCard(course = Course(
            id = 1,
            title = "Learn Compose",
            description = "Learn Jetpack Compose",
            author = "Loomi",
            image = com.example.loomi.R.drawable.ic_launcher_background,
            progress = 50,
            lessonCount = 10
        ), onClick = {})
        Spacer(modifier = Modifier.padding(16.dp))
        RecommendationArticleSection(articles = listOf(
            Article(
                id = 1,
                title = "Learn Compose",
                description = "Learn Jetpack Compose",
                author = "Loomi",
                readTime = 5
            )
        ))
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}