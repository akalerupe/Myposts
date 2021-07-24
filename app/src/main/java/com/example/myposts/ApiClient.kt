package com.example.myposts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//    Generic function
    fun <T> buildApiClient(apiInterface:Class<T>):T{
        return retrofit.create(apiInterface)
    }
}