package com.example.loomi.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loomi.R
import com.example.loomi.ui.components.PlaylistContent
import com.example.loomi.ui.components.TabSwitch


@Composable
fun CourseDetailScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Back button
        IconButton(onClick = { /* Handle back action */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back), // Replace with your back icon resource
                contentDescription = "Back",
                tint = colorResource(id = R.color.gray_light)
            )
        }

        // Course Image
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray) // Replace with actual image
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tab Row for Playlist and Description
        var selectedTab by remember { mutableIntStateOf(0) }
        TabSwitch(
            selectedIndex = selectedTab,
            items = listOf("Playlist", "Description"),
            onSelectionChange = { selectedTab = it }
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (selectedTab == 0) {
            PlaylistContent()
        } else {
            DescriptionContent()
        }
    }
}



@Composable
fun DescriptionContent() {
    Text(
        text = "This is the description of the course. Provide details about the course content, objectives, and what users can learn.",
        style = MaterialTheme.typography.bodyLarge,
        color = colorResource(id = R.color.gray)
    )
}

@Preview(showBackground = true)
@Composable
fun CourseDetailScreenPreview() {
    CourseDetailScreen()
}
