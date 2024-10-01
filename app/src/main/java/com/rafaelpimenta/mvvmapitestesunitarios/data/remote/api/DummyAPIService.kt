package com.rafaelpimenta.mvvmapitestesunitarios.data.remote.api

import com.rafaelpimenta.mvvmapitestesunitarios.data.remote.dto.ResultadoDummyApi
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPIService {

    @GET("users")
    suspend fun recuperarListaUsuarios(): Response<ResultadoDummyApi>
}