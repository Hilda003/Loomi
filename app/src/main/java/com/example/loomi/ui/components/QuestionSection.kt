package com.example.loomi.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loomi.ui.screen.OptionItem

@Composable
fun QuestionSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(vertical = 16.dp)
            .background(color = Color(0xFFEDE5D6), shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Lorem ipsum lorem",
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun OptionsSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        OptionItem(text = "Lorem", isSelected = false)
        OptionItem(text = "Lorem", isSelected = false)
        OptionItem(text = "Lorem", isSelected = true)
        OptionItem(text = "Lorem", isSelected = false)
    }
}

@Preview
@Composable
fun QuestionSectionPreview() {
    QuestionSection()
}