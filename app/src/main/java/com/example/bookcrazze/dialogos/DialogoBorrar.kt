package com.example.bookcrazze.dialogos

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrazze.R
import com.example.bookcrazze.adapter.Adapter

class DialogoBorrar : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bookName = arguments?.getString("bookName")
        val position = arguments?.getInt("position", -1) ?: -1

        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage("¿Deseas borrar el libro '$bookName'?")
                .setPositiveButton("Sí",
                    DialogInterface.OnClickListener { _, _ ->
                        if (position != -1) {
                            (activity as? AppCompatActivity)?.let { activity ->
                                (activity.findViewById<RecyclerView>(R.id.myRecyclerView)?.adapter as? Adapter)?.let { adapter ->
                                    adapter.deleteOnClick(position)
                                }
                            }
                        }
                        dismiss()
                    })
                .setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { _, _ ->
                        // Acciones a realizar cuando se cancela el borrado
                        dismiss()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
