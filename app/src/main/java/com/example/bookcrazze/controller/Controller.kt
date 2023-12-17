package com.example.bookcrazze.controller

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrazze.fragmentos.FragmentoLista
import com.example.bookcrazze.MainActivity
import com.example.bookcrazze.adapter.Adapter
import com.example.bookcrazze.dao.DaoHotels
import com.example.bookcrazze.models.Book

class Controller ( val context : Context){
    private lateinit var listHotels: MutableList<Book>
    private lateinit var adapter: Adapter
    private var esto = this.context;
    init {
        initData()
    }
    fun initData(){
        listHotels = DaoHotels. myDao.getDataHotels(). toMutableList()

    }
    fun loggOut() {
        listHotels.forEach{
            println (it)
        }
    }
    fun getListHotels(): MutableList<Book> {
        return listHotels
    }

    fun addBook(nombre: String, edad: String, imagenUrl: String) {
        val newHotel = Book(nombre, edad, imagenUrl)
        listHotels.add(newHotel)

        val insertedPosition = listHotels.size - 1
        adapter.notifyItemInserted(insertedPosition)

    }

    fun reciclerViewBotones(recyclerView: RecyclerView){
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = Adapter(listHotels, { pos -> delHotel(pos, recyclerView) }, { pos -> updateHotel(pos, recyclerView) },this)
        recyclerView.adapter = adapter
    }
    fun getLastPosition(): Int {
        return if (listHotels.isNotEmpty()) listHotels.size - 1 else 0
    }

    fun delHotel(pos: Int, recyclerView: RecyclerView) {
        val adapter = recyclerView.adapter as Adapter

        listHotels.removeAt(pos)
        adapter.notifyItemRemoved(pos)
        adapter.notifyDataSetChanged()
    }

    fun updateBook(pos: Int, nombre: String, edad: String, imagenUrl: String) {
        val updatedHotel = Book(nombre, edad, imagenUrl)
        listHotels[pos] = updatedHotel
        adapter.notifyItemChanged(pos)
    }


    fun updateHotel(pos: Int, recyclerView: RecyclerView) {
        val adapter = recyclerView.adapter as Adapter

        val hotelToUpdate = listHotels[pos]

        val updatedHotel = Book(
            "BookCrazeEditado",
            hotelToUpdate.edad,
            "https://l450v.alamy.com/450ves/pdek31/1950-foto-muestra-la-portada-de-un-libro-guia-ingles-visitantes-a-paris-como-el-usado-por-el-fotografo-j-allan-efectivo-en-sus-viajes-a-la-ciudad-francesa-mostrando-el-famoso-simbolo-de-paris-la-torre-eiffel-uno-puede-notar-el-glosario-de-salones-de-te-lo-cual-seria-importante-para-visitantes-en-ingles-en-este-momento-pdek31.jpg"
        )

        listHotels[pos] = updatedHotel

        adapter.notifyItemChanged(pos)
    }
}