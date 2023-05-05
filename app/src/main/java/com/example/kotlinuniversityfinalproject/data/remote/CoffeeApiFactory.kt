package com.example.kotlinuniversityfinalproject.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CoffeeApiFactory {
    const val URL = "https://coffee.alexflipnote.dev"

    val coffeeApi: CoffeeApiInterface = createRetrofit().create(CoffeeApiInterface::class.java)

    private fun createRetrofit(): Retrofit {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}