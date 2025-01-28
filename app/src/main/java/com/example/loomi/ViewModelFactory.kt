package com.example.loomi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loomi.data.repository.FirebaseAuthRepository
import com.example.loomi.viewmodel.LoginViewModel
import com.example.loomi.viewmodel.RegisterViewModel

class ViewModelFactory(
    private val firebaseAuthRepository: FirebaseAuthRepository
): ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(firebaseAuthRepository) as T
        }
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(firebaseAuthRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}