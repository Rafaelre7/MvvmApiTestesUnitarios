package com.rafaelpimenta.mvvmapitestesunitarios.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rafaelpimenta.mvvmapitestesunitarios.data.remote.api.RetrofitCustom
import com.rafaelpimenta.mvvmapitestesunitarios.data.remote.repository.UsuarioRepositoryImpl
import com.rafaelpimenta.mvvmapitestesunitarios.databinding.ActivityMainBinding
import com.rafaelpimenta.mvvmapitestesunitarios.domain.UsuarioUseCase
import com.rafaelpimenta.mvvmapitestesunitarios.view.viewmodel.UsuarioViewModel
import com.rafaelpimenta.mvvmapitestesunitarios.view.viewmodel.UsuarioViewModelFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()
        initObservables()
    }

    private fun initObservables() {
        usuarioViewModel.listaUsuarios.observe(this){ listaUsuarios ->

            var dadosUSuarios = ""
            listaUsuarios.forEach { usuario ->
                dadosUSuarios += "+ ${usuario.firstName} (${usuario.age}) \n"
                dadosUSuarios += "------------------------------\n"
            }

            binding.textList.text = dadosUSuarios
        }
    }

    override fun onStart() {
        super.onStart()
        usuarioViewModel.recuperarListaUsuarios()
    }

    private fun initView() {

        val dummyAPI = RetrofitCustom.recuperarDummyAPI()
        val usarioRepository = UsuarioRepositoryImpl(dummyAPI)
        val usuarioUseCase = UsuarioUseCase(usarioRepository)

        usuarioViewModel = ViewModelProvider(
            this, UsuarioViewModelFactory(usuarioUseCase)
        )[UsuarioViewModel::class.java]

    }
}