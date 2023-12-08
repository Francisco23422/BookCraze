package com.example.bookcrazze.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookcrazze.databinding.ItemHotelBinding
import com.example.bookcrazze.models.Hotel

class ViewHHotel (view: View,var deleteOnClick: (Int) -> Unit,
                  var updateOnClick: (Int) -> Unit):
    RecyclerView.ViewHolder (view){
    lateinit var binding: ItemHotelBinding
    init {
        binding = ItemHotelBinding.bind(view)
    }
    //método que se encarga de mapear los item por propiedad del modelo.
    fun renderize(hotel : Hotel){
        binding.nameTextView.setText(hotel. name)
        binding.cityTextView.setText(hotel. city)

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