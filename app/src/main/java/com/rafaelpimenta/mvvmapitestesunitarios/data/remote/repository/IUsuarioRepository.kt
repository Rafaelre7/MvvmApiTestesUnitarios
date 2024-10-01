package com.rafaelpimenta.mvvmapitestesunitarios.data.remote.repository

import com.rafaelpimenta.mvvmapitestesunitarios.data.remote.dto.Usuario

interface IUsuarioRepository {

    suspend fun listar(): List<Usuario>
}