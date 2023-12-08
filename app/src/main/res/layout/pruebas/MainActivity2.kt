package com.example.bookcrazze.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.FragmentManager

class MainActivity2 : AppCompatActivity() {
    private val firstFragment = FirstFragment()
    private val secondFragment= SecondFragment()
    private lateinit var fragmentManager : FragmentManager
    private lateinit var btnFirstFragment: ImageButton
    private lateinit var btnSecondFragment: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initComponent()
        initEvent()
    }
    private fun initComponent() {
        fragmentManager = supportFragmentManager
        btnFirstFragment = findViewById(R.id.btn_favoritos)
        btnSecondFragment = findViewById(R.id. btn_inicio)
    }
    private fun initEvent() {
       btnFirstFragment.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, firstFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        btnSecondFragment.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container_view_dinamic, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

}