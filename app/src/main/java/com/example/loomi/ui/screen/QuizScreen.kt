package com.example.loomi.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuizScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopBar()
        ProgressBar()
        QuestionSection()
        OptionsSection()
        NextButton()
    }
}

@Composable
fun TopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(onClick = { /* TODO: Handle back action */ }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "02 of 10", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ProgressBar() {
    LinearProgressIndicator(
        progress = 0.2f,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        color = Color(0xFF708D68),
        trackColor = Color(0xFFECECEC)
    )
}

@Composable
fun QuestionSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
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
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        OptionItem(text = "Lorem", isSelected = false)
        OptionItem(text = "Lorem", isSelected = false)
        OptionItem(text = "Lorem", isSelected = true)
        OptionItem(text = "Lorem", isSelected = false)
    }
}

@Composable
fun OptionItem(text: String, isSelected: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = if (isSelected) Color(0xFF4A6242) else Color(0xFFECECEC),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.White else Color.Black,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun NextButton() {
    Button(
        onClick = { /* TODO: Handle next action */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A6242))
    ) {
        Text(text = "Next", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    QuizScreen()
}