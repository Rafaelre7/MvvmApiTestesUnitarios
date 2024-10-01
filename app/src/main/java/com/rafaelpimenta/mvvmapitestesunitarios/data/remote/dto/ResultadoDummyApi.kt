package com.rafaelpimenta.mvvmapitestesunitarios.data.remote.dto

data class ResultadoDummyApi(
    val limit: Int,
    val skip: Int,
    val total: Int,
    val users: List<Usuario>
)