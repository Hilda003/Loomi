package com.example.loomi.data.model

sealed class Resource<out T> {
    object Idle : Resource<Nothing>() // Tidak mengandung data
    object Loading : Resource<Nothing>() // Tidak mengandung data
    data class Success<out T>(val data: T) : Resource<T>() // Sukses mengandung data
    data class Error(val message: String) : Resource<Nothing>() // Error hanya punya message
}
