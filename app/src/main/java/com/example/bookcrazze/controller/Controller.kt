package com.example.bookcrazze.controller

import android.content.Context
import android.widget.Toast
import com.example.bookcrazze.MainActivity
import com.example.bookcrazze.adapter.Adapter
import com.example.bookcrazze.dao.DaoHotels
import com.example.bookcrazze.models.Book

class Controller ( val context : Context){
    private lateinit var listHotels: MutableList<Book>
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
    
    fun setAdapter() {
        val myActivity = context as MainActivity
        myActivity.binding.myRecyclerView.adapter = Adapter(listHotels,
            { pos -> delHotel(pos) }, { pos -> updateHotel(pos) })

        val h = Book(
            "AÑADIDO",
            "12",
            "https://l450v.alamy.com/450ves/pdek31/1950-foto-muestra-la-portada-de-un-libro-guia-ingles-visitantes-a-paris-como-el-usado-por-el-fotografo-j-allan-efectivo-en-sus-viajes-a-la-ciudad-francesa-mostrando-el-famoso-simbolo-de-paris-la-torre-eiffel-uno-puede-notar-el-glosario-de-salones-de-te-lo-cual-seria-importante-para-visitantes-en-ingles-en-este-momento-pdek31.jpg"
        )
        myActivity.binding.btnAdd.setOnClickListener {
            listHotels.add(h)
            myActivity.binding.myRecyclerView.adapter?.notifyItemInserted(listHotels.size)
        }
    }

    fun delHotel(pos: Int) {
        val myActivity = context as MainActivity
        val adapter = myActivity.binding.myRecyclerView.adapter as Adapter

        listHotels.removeAt(pos)
        adapter.notifyItemRemoved(pos)
        adapter.notifyDataSetChanged()
    }


    fun updateHotel(pos: Int) {
        val myActivity = context as MainActivity
        val adapter = myActivity.binding.myRecyclerView.adapter as Adapter

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