package com.example.kotlinuniversityfinalproject.domain

import com.example.kotlinuniversityfinalproject.data.CoffeeRepos

object UseCaseCoffee {
    private val remoteCoffeeRepos = CoffeeRepos

    suspend fun getCoffee(): String {

        val coffeeImage = remoteCoffeeRepos.getCoffee()?.file ?: String()
        return coffeeImage
    }

}