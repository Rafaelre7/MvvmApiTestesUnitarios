package com.rafaelpimenta.mvvmapitestesunitarios.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCustom {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")//users
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun recuperarDummyAPI(): DummyAPIService {
        return getRetrofit().create(DummyAPIService::class.java)
    }
}