package com.example.upp_app.model

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val remember_token: String,
    val created_at: String?,
    val updated_at: String?
)

data class UserResponse(
    val status: String,
    val data: List<User>
)