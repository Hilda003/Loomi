package com.example.loomi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loomi.R
import com.example.loomi.ui.components.InputField

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Sign Up",
            fontSize = 24.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Fill your information below",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(16.dp))

        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }
        var termsChecked by remember { mutableStateOf(false) }

        InputField(
            label = "Name",
            value = name,
            onValueChange = { name = it }
        )

        Spacer(modifier = Modifier.height(8.dp))

        InputField(
            label = "Email",
            value = email,
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(8.dp))

        InputField(
            label = "Password",
            value = password,
            onValueChange = { password = it },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = if (passwordVisible) R.drawable.ic_visibility else R.drawable.ic_visibility_off),
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.End
        ) {
            Checkbox(
                checked = termsChecked,
                onCheckedChange = { termsChecked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Agree with Terms & conditions")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Handle Sign Up */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A6242))
        ) {
            Text(text = "Sign Up", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Already have an account? ", color = Color.Gray)
            TextButton(onClick = { /* TODO: Handle Sign In */ }) {
                Text(text = "Sign In", color = Color(0xFF4A6242))
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
