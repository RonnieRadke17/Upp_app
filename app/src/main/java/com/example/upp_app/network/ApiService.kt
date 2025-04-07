package com.example.upp_app.network

import com.example.upp_app.model.UserResponse
import com.example.upp_app.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    // Obtener usuarios
    @GET("users")
    suspend fun getUsers(): UserResponse

    // Registrar un nuevo usuario
    @POST("register")
    suspend fun registerUser(@Body request: RegisterRequest): RegisterResponse



}