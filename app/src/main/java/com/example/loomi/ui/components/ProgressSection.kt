package com.example.loomi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loomi.R

@Composable
fun ProgressSection(progress: Int) {
    Card (modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.gray_light)),

        ) {
        Row(
            modifier = Modifier.padding(25.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CircularProgressIndicator(progress = progress / 100f, modifier = Modifier.padding(end = 16.dp))
            Spacer(modifier = Modifier.padding(16.dp))
            Column {
                Text(text = "Your Progress is amazing!",
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    color = Color.White,
                    fontSize = 18.sp)
                Text(text = "Keep up the good work!", color = Color.White, fontSize = 12.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.ExtraLight)

            }
        }
    }
}

@Composable
fun ProgressBar() {
    LinearProgressIndicator(
        progress = 0.2f,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
        .clip(RoundedCornerShape(50)),
        color = Color(0xFF708D68),
        trackColor = Color(0xFFECECEC)

    )
}

@Preview
@Composable
fun ProgressSectionPreview() {
    ProgressSection(50)
}