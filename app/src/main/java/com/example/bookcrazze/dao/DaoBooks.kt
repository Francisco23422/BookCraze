package com.example.bookcrazze.dao

import com.example.bookcrazze.interfaceDao.InterfaceDao
import com.example.bookcrazze.models.Book
import com.example.bookcrazze.object_model.Repository


class DaoHotels private constructor(): InterfaceDao {
    companion object {
        val myDao: DaoHotels by lazy{
            DaoHotels()
        }
    }

    override
    fun getDataHotels(): List<Book> = Repository. listHotels
}

object DaoHotels2 {
    val myDao by lazy {
        getDataHotels()
    }
    private fun getDataHotels() : List<Book> = Repository. listHotels
}