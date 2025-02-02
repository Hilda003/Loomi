package com.example.loomi.ui.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loomi.R
import com.example.loomi.data.model.Course


@Composable
fun CourseCard(course: Course, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
//        elevation = 4.Dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.article1),
                contentDescription = "Course image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = course.title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = course.author,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black.copy(alpha = 0.6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "${course.lessonCount} lessons",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black.copy(alpha = 0.6f),
                )
                Spacer(modifier = Modifier.width(16.dp))
                LinearProgressIndicator(
                    progress = 0.2f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    color = Color(0xFF708D68),
                    trackColor = Color(0xFFECECEC)
                )
            }

        }
    }
}

@Composable
fun CourseList() {
    Column {
        repeat(5) {
            CourseCard(
                course = Course(
                    id = it,
                    title = "Learn Compose",
                    description = "Learn Jetpack Compose",
                    author = "Loomi",
                    image = com.example.loomi.R.drawable.ic_launcher_background,
                    progress = 50,
                    lessonCount = 10
                ),
                onClick = {}
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}


@Preview
@Composable
fun CourseCardPreview() {
    CourseCard(
        course = Course(
            id = 1,
            title = "Learn Compose",
            description = "Learn Jetpack Compose",
            author = "Loomi",
            image = com.example.loomi.R.drawable.ic_launcher_background,
            progress = 50,
            lessonCount = 10
        ),
        onClick = {}
    )
}