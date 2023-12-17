package com.example.bookcrazze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrazze.controller.Controller
import com.example.bookcrazze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var controller: Controller
    lateinit var binding: ActivityMainBinding
    private  lateinit var reciclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init() {
        initRecyclerView()
        controller = Controller(this)
        reciclerView = binding.myRecyclerView.findViewById(R.id.myRecyclerView)
        //controller.setAdapter()
    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}