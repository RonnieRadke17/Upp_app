package com.example.upp_app.model

data class RegisterResponse(
    val success: Boolean,
    val data: User?,          // Solo viene si success == true
    val errors: Map<String, List<String>>? // Solo viene si success == false
)
