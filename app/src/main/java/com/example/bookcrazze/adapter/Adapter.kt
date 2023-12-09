package com.example.bookcrazze.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrazze.R
import com.example.bookcrazze.models.Book

class Adapter(
    var listHotel : MutableList<Book>,
    var deleteOnClick: (Int) -> Unit,
    var updateOnClick: (Int) -> Unit
) : RecyclerView.Adapter<ViewBook>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewBook {
        val layoutInflater = LayoutInflater.from(parent. context)
        val layoutItemHotel = R.layout. item_hotel
        return ViewBook(
            layoutInflater.inflate(layoutItemHotel, parent, false),
            deleteOnClick,
            updateOnClick
        )

    }

    override fun onBindViewHolder(holder: ViewBook, position: Int) {
        holder.renderize( listHotel.get(position))
        holder.itemView.setOnClickListener {
            updateOnClick(position)
        }
        holder.itemView.setOnLongClickListener {
            deleteOnClick(position)
            true
        }
    }

    override fun getItemCount(): Int = listHotel.size
}