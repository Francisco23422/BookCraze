package com.example.bookcrazze

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookcrazze.adapter.AdapterHotel
import com.example.bookcrazze.controller.Controller
import com.example.bookcrazze.databinding.FragmentFragmentoListaBinding

class FragmentoLista : Fragment() {
    lateinit var binding : FragmentFragmentoListaBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterHotel
    private lateinit var controller: Controller

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragmento_lista, container, false)
        recyclerView = view.findViewById(R.id.myRecyclerView)

        // Configurar el RecyclerView con un LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Obtener la lista de hoteles del Controller
        controller = Controller(requireContext())
        val listHotels = controller.getListHotels()

        // Configurar el adaptador con la lista de hoteles y el fragmento como oyente
        adapter = AdapterHotel(listHotels, this::onDeleteClick, this::onUpdateClick)
        recyclerView.adapter = adapter

        return view
    }

    private fun onDeleteClick(position: Int) {
        controller.delHotel(position)
    }

    private fun onUpdateClick(position: Int) {
        controller.updateHotel(position)
    }
}
