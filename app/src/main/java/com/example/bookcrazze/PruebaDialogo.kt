package com.example.bookcrazze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bookcrazze.dialogos.DialogoBorrar


class PruebaDialogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba_dialogo)

        val btnBorrar = findViewById<Button>(R.id.btnBorrar)
        btnBorrar.setOnClickListener {
            val dialog = DialogoBorrar()
            dialog.show(supportFragmentManager, "confirmacionDialog")
        }
    }
}