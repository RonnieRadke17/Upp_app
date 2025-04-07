package com.example.upp_app.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upp_app.model.User
import com.example.upp_app.network.RetrofitClient
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    var userList = mutableStateListOf<User>()
        private set

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getUsers()
                userList.clear()
                userList.addAll(response.data)
            } catch (e: Exception) {
                // Manejar errores aquí
                println("Error obteniendo usuarios: ${e.message}")
            }
        }
    }
}