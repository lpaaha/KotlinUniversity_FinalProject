package com.example.kotlinuniversityfinalproject.data

import com.example.kotlinuniversityfinalproject.data.remote.CoffeeApiFactory
import com.example.kotlinuniversityfinalproject.data.remote.model.CoffeeApiModel

object CoffeeRepos {

    private val coffeeApi = CoffeeApiFactory.coffeeApi

    suspend fun getCoffee(): CoffeeApiModel? {
        val response = coffeeApi.getImages()
        if (response.isSuccessful) {
            if (response.body() != null) {
                val body = response.body()
                return body!!
            }
        }
        return null
    }
}