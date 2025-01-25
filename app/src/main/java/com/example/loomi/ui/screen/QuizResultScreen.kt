package com.example.loomi.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loomi.R

@Composable
fun QuizSummaryScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(
            title = "Quiz Summary",
            icon = R.drawable.ic_home_unselected
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_trophy), // Replace with your trophy resource
            contentDescription = "Trophy",
            modifier = Modifier.size(220.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Congratulations!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4A6242)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Lorem Ipsum is simply dummy text",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(32.dp))

        ScoreSection(
            score = "80/100",
            points = 500
        )

//        Spacer(modifier = Modifier.weight(12.dp))

        ButtonRow(
            leftButtonText = "Share",
            rightButtonText = "Review",
            onLeftButtonClick = { /* TODO: Handle Share Result */ },
            onRightButtonClick = { /* TODO: Handle Review */ }
        )
    }
}

@Composable
fun Header(title: String, icon: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,

        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF4A6242)
        )
        IconButton(onClick = { /* TODO: Handle Home Click */ }) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Home Icon",
                tint = Color(0xFF4A6242)
            )
        }
    }
}

@Composable
fun ScoreSection(score: String, points: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Your Score",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = score,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4A6242)
        )
        Spacer(modifier = Modifier.height(22.dp))
        Text(
            text = "Earned points",
            fontSize = 16.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_coin), // Replace with your coin resource
                contentDescription = "Coin Icon",
                tint = Color(0xFFFFC107),
                modifier = Modifier.size(45.dp)
            )
//            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = points.toString(),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4A6242)
            )
        }
    }
}

@Composable
fun ButtonRow(
    leftButtonText: String,
    rightButtonText: String,
    onLeftButtonClick: () -> Unit,
    onRightButtonClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = onLeftButtonClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            border = BorderStroke(1.dp, Color(0xFF4A6242)),
            shape = RoundedCornerShape(8.dp),
//            modifier = Modifier.weight(1f)
        ) {
//            Icon(painter = painterResource(id = R.drawable.ic_share), contentDescription = "Share Icon", tint = Color(0xFF4A6242))
            Text(text = leftButtonText, color = Color(0xFF4A6242))
        }

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = onRightButtonClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A6242)),
            shape = RoundedCornerShape(8.dp),
//            modifier = Modifier.weight(1f)
        ) {
            Text(text = rightButtonText, color = Color.White)
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewQuizSummaryScreen() {
    QuizSummaryScreen()
}