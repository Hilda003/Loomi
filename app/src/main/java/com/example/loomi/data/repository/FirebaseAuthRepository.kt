package com.example.loomi.data.repository

import com.example.loomi.data.model.Resource
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository(private val firebaseAuth: FirebaseAuth) {

    suspend fun registerUser(email: String, password: String): Resource<String> {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Resource.Success("Registration successful")
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Registration failed")
        }
    }

    suspend fun loginUser(email: String, password: String): Resource<String> {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success("Login successful")
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Login failed")
        }
    }
}