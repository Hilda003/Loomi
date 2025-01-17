package com.example.loomi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.loomi.R

@Composable
fun PlaylistItem(title: String, duration: String, isLocked: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = { /* Handle play action */ },
            enabled = !isLocked
        ) {
            Icon(
                painter = painterResource(
                    id = if (isLocked) R.drawable.ic_play else R.drawable.ic_play
                ), // Replace with your icons
                contentDescription = null,
                tint = if (isLocked) Color.Gray else colorResource(id = R.color.gray)
            )
        }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = duration,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.gray)
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_lock), // Replace with lock icon
            contentDescription = null,
            tint = if (isLocked) Color.Gray else Color.Gray
        )
    }
}

@Composable
fun PlaylistContent() {
    Column {
        val playlistItems = listOf(
            "Pengenalan Algoritma" to "2 min 33 sec",
            "Pengenalan Algoritma" to "2 min 33 sec",
            "Pengenalan Algoritma" to "2 min 33 sec",
            "Pengenalan Algoritma" to "2 min 33 sec",
            "Quiz" to "10 Soal"
        )

        playlistItems.forEachIndexed { index, item ->
            PlaylistItem(
                title = item.first,
                duration = item.second,
                isLocked = index > 0 // First item unlocked, others locked
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}