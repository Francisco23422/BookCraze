package com.example.bookcrazze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookcrazze.controller.Controller
import com.example.bookcrazze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {/*
    lateinit var binding : ActivityMainBinding
    // lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate( layoutInflater)
        setContentView( binding.root)
        init() //inicializo la clase
    }
    fun init(){
        initRecyclerView()
        //controller.loggOut() //muestro el log en pantalla
    }
    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager( this)
    }*/
    lateinit var controller : Controller
    lateinit var binding : ActivityMainBinding
    // lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate( layoutInflater)
        setContentView( binding.root)
        init() //inicializo la clase
    }
    fun init(){
        initRecyclerView()
        controller = Controller( this) //Creamos el controler
        controller.setAdapter()
        //controller.loggOut() //muestro el log en pantalla
    }
    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager( this)
    }
}