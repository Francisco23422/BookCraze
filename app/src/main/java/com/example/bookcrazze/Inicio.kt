package com.example.bookcrazze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.FragmentManager

class Inicio : AppCompatActivity() {
    private val secondFragment= SecondFragment()
    private val secondFragment2= FragmentoLista()
    private lateinit var fragmentManager : FragmentManager
    private lateinit var btnInicio: ImageButton
    private lateinit var btnLibros: ImageButton
    private lateinit var btnFavoritos: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        initComponent()
        initEvent()
    }
    private fun initComponent() {
        fragmentManager = supportFragmentManager
        btnInicio = findViewById(R.id.btn_inicio)
        btnLibros = findViewById(R.id. btn_libros)
        btnFavoritos = findViewById(R.id. btn_favoritos)
    }
    private fun initEvent() {
        val principalLinear = findViewById<LinearLayoutCompat>(R.id.principal_linear)
        btnInicio.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            
            val params = principalLinear.layoutParams as LinearLayoutCompat.LayoutParams
            params.weight = 4f
            principalLinear.layoutParams = params
        }
        btnLibros.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, secondFragment2)
            transaction.addToBackStack(null)
            transaction.commit()

            val params = principalLinear.layoutParams as LinearLayoutCompat.LayoutParams
            params.weight = 2f
            principalLinear.layoutParams = params
        }
        btnFavoritos.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()

            val params = principalLinear.layoutParams as LinearLayoutCompat.LayoutParams
            params.weight = 2f
            principalLinear.layoutParams = params
        }
    }

}