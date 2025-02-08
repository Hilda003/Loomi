package com.example.loomi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loomi.R


@Composable
fun GreetingSection(name : String) {

    Column {
        Row {
            Icon(painter = painterResource(id = R.drawable.hand), contentDescription = "say hi",
                tint = colorResource(id = R.color.yellow),
                modifier = Modifier.size(20.dp)
            )
            Text(text = " Hallo, $name", color = colorResource(id = R.color.gray_dark), fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                fontSize = 16.sp)
        }
        Text("Great to see you again!", color = Color.Gray, fontSize = 10.sp)
    }
}

@Preview
@Composable
fun GreetingSectionPreview() {
    GreetingSection("Loomi")
}