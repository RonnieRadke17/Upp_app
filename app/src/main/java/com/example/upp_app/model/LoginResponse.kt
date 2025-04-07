package com.example.upp_app.model

data class LoginResponse(
    val success: Boolean,
    val data: User? = null
)
