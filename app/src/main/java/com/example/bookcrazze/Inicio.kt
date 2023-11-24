package com.example.bookcrazze

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val textView: TextView = findViewById(R.id.txt_cardview)

        val username = intent.getStringExtra("username")
        if (username != null) {
            textView.text = username
        }else{
            textView.text = "usuario no encontrado"
        }

    }
}