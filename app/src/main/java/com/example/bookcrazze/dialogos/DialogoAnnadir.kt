package com.example.bookcrazze.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrazze.R
import com.example.bookcrazze.controller.Controller

class DialogoAnnadir(private val controller: Controller,private val reciclerView: RecyclerView) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())

        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.activity_dialogo_annadir, null)
        view.findViewById<TextView>(R.id.customDialogTitle).text = "Nuevo Libro"

        builder.setView(view)
            .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, id ->
                val nombre = view.findViewById<EditText>(R.id.editTextNombre).text.toString()
                val edad = view.findViewById<EditText>(R.id.editTextEdad).text.toString()
                val imageUrl = view.findViewById<EditText>(R.id.editTextImagen).text.toString()

                // Agregar un nuevo libro utilizando el controlador
                controller.addBook(nombre, edad, imageUrl)
                reciclerView.smoothScrollToPosition(controller.getLastPosition())
                // Cierra el diálogo
                dialog.dismiss()

            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                // Cierra el diálogo
                dialog.cancel()
            })

        return builder.create()
    }
}
