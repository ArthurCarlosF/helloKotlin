package com.arthurc.trackesp.data

import com.arthurc.trackesp.modelos.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call

interface ApiService {
    /*
    * basicamente quando vc chama essa função, ele chama o BASE_URL que
    * voce botou lá em baixo concatenando com essa string que vc passou
    * dentro do get, ai vai ficar tipo isso: "https://api.example.com/users"
    * */
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): User
}


object RetrofitClient {
    // muda essa url
    private const val BASE_URL = "https://api.example.com/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
