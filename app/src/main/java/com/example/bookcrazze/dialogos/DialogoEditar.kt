package com.example.bookcrazze.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.bookcrazze.R
import com.example.bookcrazze.controller.Controller
import com.example.bookcrazze.models.Book

class DialogoEditar(private val position: Int,private val hotel: Book,private val controller: Controller) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())

        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.activity_dialogo_annadir, null)
        val editTextNombre = view.findViewById<EditText>(R.id.editTextNombre)
        val editTextEdad = view.findViewById<EditText>(R.id.editTextEdad)
        val editTextImagen = view.findViewById<EditText>(R.id.editTextImagen)
        view.findViewById<TextView>(R.id.customDialogTitle).text = "Editar Libro"
        // Setear valores iniciales
        editTextNombre.setText(hotel.name)
        editTextEdad.setText(hotel.edad)
        editTextImagen.setText(hotel.image)

        builder.setView(view)
            .setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, id ->
                val nuevoNombre = editTextNombre.text.toString()
                val nuevaEdad = editTextEdad.text.toString()
                val nuevaImagen = editTextImagen.text.toString()

                // Llamar al método addBook del controlador para agregar el nuevo libro
                controller.updateBook(position, nuevoNombre, nuevaEdad, nuevaImagen)
            })
            .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, id ->
                // Cierra el diálogo
                dialog.cancel()
            })

        return builder.create()
    }

}
