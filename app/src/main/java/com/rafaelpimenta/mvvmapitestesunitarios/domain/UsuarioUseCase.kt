package com.rafaelpimenta.mvvmapitestesunitarios.domain

import com.rafaelpimenta.mvvmapitestesunitarios.data.remote.dto.Usuario
import com.rafaelpimenta.mvvmapitestesunitarios.data.remote.repository.IUsuarioRepository

class UsuarioUseCase(
    private val iUsuarioRepository: IUsuarioRepository
) {

    suspend operator fun invoke(): List<Usuario> {//getListUserUseCase
        val listaUsuarios = iUsuarioRepository.listar()
        return listaUsuarios.filter {
            it.age >= 40
        }
    }
}