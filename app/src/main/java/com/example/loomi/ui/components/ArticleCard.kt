package com.example.loomi.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loomi.R
import com.example.loomi.data.model.Article



@Composable
fun ArticleCard(article: Article) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(painter = painterResource(id = R.drawable.article1), contentDescription = "Image Article", modifier = Modifier.fillMaxWidth())
            Text(text = article.title, fontWeight = FontWeight.Bold)
            Text(text = "${article.description} • ${article.readTime}", color = Color.Gray)
        }
    }
}

@Composable
fun RecommendationArticleSection(articles: List<Article>) {
    Column {
        Text(text = "Recommendation Article", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        articles.forEach { article ->
            ArticleCard(article)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun ArticleCardPreview() {
    RecommendationArticleSection(articles = listOf(
        Article(
            id = 1,
            title = "Learn Compose",
            description = "Learn Jetpack Compose",
            author = "Loomi",
            readTime = 5
        )
    )
    )
}