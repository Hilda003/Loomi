package com.example.loomi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.loomi.R


@Composable
fun GreetingSection(name : String) {

    Column {
        Row {
            Icon(painter = painterResource(id = R.drawable.hand), contentDescription = "say hi" )
            Text(text = "Hallo, $name ")
        }
        Text("Great to see you again")
    }
}

@Preview
@Composable
fun GreetingSectionPreview() {
    GreetingSection("Loomi")
}