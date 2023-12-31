package com.example.bookcrazze.fragmentos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookcrazze.databinding.FragmentFragmentoPaginaPrincipalBinding
import com.example.bookcrazze.databinding.FragmentSecondBinding

class FragmentoPaginaPrincipal : Fragment() {
    private lateinit var binding : FragmentFragmentoPaginaPrincipalBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragmentoPaginaPrincipalBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}