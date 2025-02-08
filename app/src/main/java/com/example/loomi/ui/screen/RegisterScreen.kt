package com.example.loomi.ui.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.loomi.R
import com.example.loomi.ViewModelFactory
import com.example.loomi.data.model.Resource
import com.example.loomi.data.repository.FirebaseAuthRepository
import com.example.loomi.ui.components.InputField
import com.example.loomi.ui.navigation.Screen
import com.example.loomi.viewmodel.RegisterViewModel
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("ShowToast")
@Composable
fun RegisterScreen(
    firebaseAuthRepository: FirebaseAuthRepository,
    navController: NavHostController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var termsChecked by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    val registerViewModel: RegisterViewModel = viewModel(
        factory = ViewModelFactory(firebaseAuthRepository)
    )
    val registerState by registerViewModel.registerState.collectAsState()
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
            modifier = Modifier.fillMaxWidth(),
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
            onClick = {
                isLoading = true
                      registerViewModel.register(email, password)
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A6242))
        ) {
            Text(text = "Sign Up", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Already have an account? ", color = Color.Gray)
            TextButton(onClick = {
                navController.navigate(Screen.LoginScreen.route)

            }) {
                Text(text = "Sign In", color = Color(0xFF4A6242))
            }

        }
        when (registerState) {
            is Resource.Loading -> {
                CircularProgressIndicator()
            }
            is Resource.Success -> {
                navController.navigate(Screen.HomeScreen.route)
                registerViewModel.resetState()
            }
            is Resource.Error -> {
//                Text(text = "Error: ${(registerState as Resource.Error).message}")
                Toast.makeText(
                    navController.context,
                    (registerState as Resource.Error).message,
                    Toast.LENGTH_SHORT
                )
                registerViewModel.resetState()

            }
            is Resource.Idle -> { }
        }

    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(
        FirebaseAuthRepository(FirebaseAuth.getInstance()),
        rememberNavController()
    )
}