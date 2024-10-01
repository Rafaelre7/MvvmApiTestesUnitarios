package com.rafaelpimenta.mvvmapitestesunitarios.view.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rafaelpimenta.mvvmapitestesunitarios.domain.UsuarioUseCase

class UsuarioViewModelFactory(
    private val usuarioUseCase: UsuarioUseCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UsuarioViewModel(usuarioUseCase) as T
    }
}