package com.example.upp_app.network
import com.example.upp_app.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
//aqui cambias la ip por la de tu compu ipv4
    private const val BASE_URL = "http://192.168.1.72:8000/api/"
    //Si estás probando en un dispositivo físico conectado
    // a la misma red local, reemplaza 10.0.2.2 por la IP local de tu PC.
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}