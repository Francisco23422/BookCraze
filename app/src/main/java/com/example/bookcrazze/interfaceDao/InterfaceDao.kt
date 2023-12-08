package com.example.bookcrazze.interfaceDao

import com.example.bookcrazze.models.Hotel

interface InterfaceDao {
    fun getDataHotels(): List<Hotel>
}