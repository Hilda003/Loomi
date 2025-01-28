package com.example.loomi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loomi.data.model.Resource
import com.example.loomi.data.repository.FirebaseAuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val firebaseAuthRepository: FirebaseAuthRepository) : ViewModel() {
    private val _loginState = MutableStateFlow<Resource<String>>(Resource.Idle)
    val loginState: StateFlow<Resource<String>> = _loginState


    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = Resource.Loading
            _loginState.value = firebaseAuthRepository.loginUser(email, password)
        }
    }

    fun resetState() {
        _loginState.value = Resource.Idle
    }
}