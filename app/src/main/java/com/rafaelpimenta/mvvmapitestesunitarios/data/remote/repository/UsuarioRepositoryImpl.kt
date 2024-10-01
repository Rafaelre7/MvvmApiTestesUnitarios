package com.rafaelpimenta.mvvmapitestesunitarios.data.remote.repository

import com.rafaelpimenta.mvvmapitestesunitarios.data.remote.api.DummyAPIService
import com.rafaelpimenta.mvvmapitestesunitarios.data.remote.dto.Usuario

class UsuarioRepositoryImpl(
    private val dummyAPIService: DummyAPIService
) : IUsuarioRepository {
    override suspend fun listar(): List<Usuario> {

        val response = dummyAPIService.recuperarListaUsuarios()

        if (response.isSuccessful && response.body() != null) {
            val listaUsuarios = response.body()?.users
            if (listaUsuarios != null) {
                return listaUsuarios
            }
        }

        return emptyList()
    }
}