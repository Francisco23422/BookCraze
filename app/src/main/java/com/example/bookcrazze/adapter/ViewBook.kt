package com.example.bookcrazze.adapter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookcrazze.controller.Controller
import com.example.bookcrazze.dialogos.DialogoBorrar
import com.example.bookcrazze.databinding.ItemHotelBinding
import com.example.bookcrazze.dialogos.DialogoEditar
import com.example.bookcrazze.models.Book

class ViewBook (
    view: View,
    private val controller: Controller,
    var deleteOnClick: (Int) -> Unit,
    var updateOnClick: (Int) -> Unit):  RecyclerView.ViewHolder (view){

    var binding: ItemHotelBinding
    init {
        binding = ItemHotelBinding.bind(view)
    }

    fun renderize(hotel : Book){
        binding.nameTextView.setText(hotel. name)
        binding.cityTextView.setText(hotel. edad)

        Glide
            .with( itemView.context)
            .load(hotel. image)
            .centerCrop()
            .into( binding.iconImageView)
        setOnClickListener(adapterPosition,hotel)
    }

    fun setOnClickListener(position : Int, hotel: Book) {
        binding.btnEdit.setOnClickListener {
            val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
            val dialogFragment = DialogoEditar(position,hotel,controller)
            dialogFragment.show(fragmentManager, "editarDialog")
            dialogFragment.isCancelable = false
        }

        binding.btnDelete.setOnClickListener {
            val fragmentManager = (itemView.context as AppCompatActivity).supportFragmentManager
            val dialogFragment = DialogoBorrar()

            // Pasa el nombre del libro seleccionado al DialogoBorrar
            val args = Bundle()
            args.putString("bookName", binding.nameTextView.text.toString())
            args.putInt("position", position)
            dialogFragment.arguments = args

            dialogFragment.show(fragmentManager, "confirmacionDialog")
            dialogFragment.isCancelable = false
        }
    }

}