package com.example.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Adapters.GamesAdapter
import com.example.Data.Game
import com.example.practicandodiseo.R
import repositories.GameRepository

class GamesFragment : Fragment(R.layout.fragment_gamess),GamesAdapter.eventoComprar{

    var listaDeJuegos: MutableList<Game> = GameRepository.get()
    private lateinit var adapter: GamesAdapter
    private lateinit var llmanager : GridLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf("Todos","Survival Horror","Sandbox","Deporte","Shooter","Pelea","Carreras","Accion","Aventura")
        val autoComplete: AutoCompleteTextView = requireView().findViewById(R.id.auto_complete)

        val adapterFiltro = activity?.let { ArrayAdapter(it,R.layout.list_item,items) }
        autoComplete.setAdapter(adapterFiltro)

        ///filtro
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
                adapterView, view, i, l ->

            val itemSelectedListener = adapterView.getItemAtPosition(i)

            if (itemSelectedListener.toString() == "Todos") {
                listaDeJuegos = GameRepository.get() as MutableList<Game>
            } else {
                listaDeJuegos = GameRepository.getGameforGener(itemSelectedListener.toString()) as MutableList<Game>
            }
            adapter.setListaFiltrada(listaDeJuegos)
        }
        initRecyclerview()///ahora lo instanciamos

    }

    fun initRecyclerview(){
        val rv: RecyclerView = requireView().findViewById(R.id.rv_juegos_disponible)
        adapter = GamesAdapter(listaDeJuegos,this)
        llmanager = GridLayoutManager(context,1, LinearLayoutManager.VERTICAL,false)
        rv.layoutManager = llmanager
        rv.adapter = adapter
    }
    override fun comprarEvento(id: Long, price: Double) {
        ///fragment
        //val intent = Intent(this,)///ahora lo hago un poputView
        //intent.putExtra("total",price)
        //intent.putExtra("id_game",id)
        //aca tengo que pasarle tambien el id del usuario y

        //startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_gamess, container, false)
        return vista
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GamesFragment().apply {
                arguments = Bundle().apply {
                    //putString, param1)
                    //putString(, param2)
                }
            }
    }
}