package com.example.loomi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loomi.data.model.Resource
import com.example.loomi.data.repository.FirebaseAuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val firebaseAuthRepository: FirebaseAuthRepository
) : ViewModel() {
    private val _registerState = MutableStateFlow<Resource<String>>(Resource.Idle)
    val registerState: StateFlow<Resource<String>> = _registerState


    fun register(email: String, password: String) {
        viewModelScope.launch {
            _registerState.value = Resource.Loading
            _registerState.value = firebaseAuthRepository.registerUser(email, password)
        }
    }

    fun resetState() {
        _registerState.value = Resource.Idle
    }
}