package com.example.kotlinuniversityfinalproject.data.remote

import com.example.kotlinuniversityfinalproject.data.remote.model.CoffeeApiModel
import retrofit2.Response
import retrofit2.http.GET

interface CoffeeApiInterface {

    @GET("/random.json")
    suspend fun getImages(): Response<CoffeeApiModel>
}