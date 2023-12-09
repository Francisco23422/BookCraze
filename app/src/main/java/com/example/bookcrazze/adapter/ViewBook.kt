package com.example.bookcrazze.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookcrazze.databinding.ItemHotelBinding
import com.example.bookcrazze.models.Book

class ViewBook (
    view: View, var deleteOnClick: (Int) -> Unit,
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
        setOnClickListener(adapterPosition)
    }

    fun setOnClickListener(position : Int) {
        binding.btnEdit.setOnClickListener {
            updateOnClick(position )
        }
        binding.btnDelete.setOnClickListener {
            deleteOnClick(position)
        }
    }

}