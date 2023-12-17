package com.example.bookcrazze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.FragmentManager
import com.example.bookcrazze.databinding.ActivityInicioBinding
import com.example.bookcrazze.fragmentos.FragmentoLista
import com.example.bookcrazze.fragmentos.FragmentoPaginaPrincipal
import com.example.bookcrazze.fragmentos.SecondFragment

class Inicio : AppCompatActivity() {
    private val secondFragment= SecondFragment()
    private val secondFragment23= FragmentoPaginaPrincipal()
    private val secondFragment2= FragmentoLista()
    private lateinit var binding : ActivityInicioBinding
    private lateinit var fragmentManager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponent()
        initEvent()
    }
    private fun initComponent() {
        fragmentManager = supportFragmentManager
    }
    private fun initEvent() {
        val principalLinear = findViewById<LinearLayoutCompat>(R.id.principal_linear)
        binding.btnInicio.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, secondFragment23)
            transaction.addToBackStack(null)
            transaction.commit()
            binding.txtTitulo.text = "INICIO"
            val params = principalLinear.layoutParams as LinearLayoutCompat.LayoutParams
            params.weight = 4f
            principalLinear.layoutParams = params
        }
        binding.btnLibros.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, secondFragment2)
            transaction.addToBackStack(null)
            transaction.commit()
            binding.txtTitulo.text = "LIBROS"
            val params = principalLinear.layoutParams as LinearLayoutCompat.LayoutParams
            params.weight = 2f
            principalLinear.layoutParams = params

        }
        binding.btnFavoritos.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            binding.txtTitulo.text = "FAVORITOS"
            val params = principalLinear.layoutParams as LinearLayoutCompat.LayoutParams
            params.weight = 2f
            principalLinear.layoutParams = params
        }
    }

}