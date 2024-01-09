package com.example.bookcrazze

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.FragmentManager
import com.example.bookcrazze.databinding.ActivityInicioBinding
import com.example.bookcrazze.fragmentos.FragmentoLista
import com.example.bookcrazze.fragmentos.FragmentoPaginaPrincipal
import com.example.bookcrazze.fragmentos.SecondFragment

class Inicio : AppCompatActivity() {
    private val secondFragment = SecondFragment()
    private val secondFragment23 = FragmentoPaginaPrincipal()
    private val secondFragment2 = FragmentoLista()
    private lateinit var binding: ActivityInicioBinding
    private lateinit var fragmentManager: FragmentManager

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
        // Tu código actual de inicialización de eventos

        // Añadir la siguiente línea para habilitar el menú
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_inicio, menu)
        return true
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_inicio -> {
                showFragment(secondFragment23, "INICIO", 4f)
                true
            }
            R.id.menu_libros -> {
                showFragment(secondFragment2, "LIBROS", 2f)
                true
            }
            R.id.menu_favoritos -> {
                showFragment(secondFragment, "FAVORITOS", 2f)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showFragment(fragment: androidx.fragment.app.Fragment, title: String, weight: Float) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_view_dinamic, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        binding.txtTitulo.text = title
        val params = findViewById<LinearLayoutCompat>(R.id.principal_linear).layoutParams as LinearLayoutCompat.LayoutParams
        params.weight = weight
        findViewById<LinearLayoutCompat>(R.id.principal_linear).layoutParams = params
    }
}
