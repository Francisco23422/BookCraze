    package com.example.bookcrazze.fragmentos

    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.recyclerview.widget.RecyclerView
    import com.example.bookcrazze.R
    import com.example.bookcrazze.controller.Controller
    import com.example.bookcrazze.databinding.FragmentFragmentoListaBinding
    import com.example.bookcrazze.dialogos.DialogoAnnadir


    class FragmentoLista : Fragment() {
        lateinit var binding: FragmentFragmentoListaBinding
        private lateinit var controller: Controller
        private  lateinit var reciclerView: RecyclerView

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentFragmentoListaBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            reciclerView = binding.myRecyclerView.findViewById(R.id.myRecyclerView)
            controller = Controller(requireContext())

            // Configurar el RecyclerView y el adaptador
            controller.reciclerViewBotones(reciclerView)

            // Añadir un nuevo libro cuando se hace clic en el botón
            binding.btnAdd.setOnClickListener {
                val dialogoAnnadir = DialogoAnnadir(controller,reciclerView)
                dialogoAnnadir.show(parentFragmentManager, "DialogoAnnadir")
                //controller.addBook("Caroline", "+11", "https://img.remediosdigitales.com/caa8b5/81lu6i-sgdl/450_1000.jpeg")
            }

        }

    }

