package com.example.ui.comprarJuego

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Adapters.GamesAdapter
import com.example.Data.Game
import com.example.ElegirIntermediario
import com.example.practicandodiseo.R
import com.example.practicandodiseo.databinding.FragmentComprarJuegoBinding
import repositories.GameRepository
import repositories.UserRepository


class ComprarJuegoFragment : Fragment(),GamesAdapter.eventoComprar {

    private var _binding:FragmentComprarJuegoBinding? = null
    private lateinit var adapterJuego: GamesAdapter
    private lateinit var recyclerView: RecyclerView
    private var listaDeJuegos = GameRepository.get()
    private var usuarioLogueado = UserRepository.usuario

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentComprarJuegoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        ///aca hago lo del filtro

        val items = listOf("Todos","Survival Horror","Sandbox","Deporte","Shooter","Pelea","Carreras","Accion","Aventura")
        val autoComplete: AutoCompleteTextView = root.findViewById(R.id.auto_complete)

        val adapterFil = ArrayAdapter(requireActivity(), R.layout.list_item,items)
        autoComplete.setAdapter(adapterFil)

        ///filtro
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
                adapterView, view, i, l ->

            val itemSelectedListener = adapterView.getItemAtPosition(i)

            if (itemSelectedListener.toString() == "Todos") {
                listaDeJuegos = GameRepository.get() as MutableList<Game>
            } else {
                listaDeJuegos = GameRepository.getGameforGener(itemSelectedListener.toString()) as MutableList<Game>
            }
            adapterJuego.setListaFiltrada(listaDeJuegos)
        }
        initRecyclerview()
        return root
    }


    private fun initRecyclerview() {
        val layoutManager = LinearLayoutManager(context)
        recyclerView = binding.rvJuegosDisponible
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapterJuego = GamesAdapter(GameRepository.get(),this)
        recyclerView.adapter = adapterJuego
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    ///nos pasaron el id del juego y el precio ahora se lo tenemos que pasar al elegir intermediario
    override fun comprarEvento(id: Long) {
        ///aca deberiamos ir al intermediario.kt y calcular la comision y el casback
        UserRepository.idGame = id
        val intent = Intent(activity,ElegirIntermediario::class.java)
        Toast.makeText(context,"vamos a elegir intermetdiario",Toast.LENGTH_SHORT)
        context?.startActivity(intent)
    }
}

