package com.example.Diseño

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Data.Game
import com.example.practicandodiseo.R
import repositories.GameRepository

class gamesActivity : AppCompatActivity() {

    var listaDeJuegos: List<Game> = GameRepository.get()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)




        val items = listOf("Todos","Survival Horror","Sandbox","Deporte","Shooter","Pelea","Carreras","Accion","Aventura")

        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this,R.layout.list_item,items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->
            val itemSelectedListener = adapterView.getItemAtPosition(i)

            if(itemSelectedListener.toString() == "Todos"){
                listaDeJuegos= GameRepository.get()
            }else{
                listaDeJuegos = GameRepository.getGameforGener(itemSelectedListener.toString())
            }
            onStart()
        }

        onStart()

    }

    override fun onStart() {
        super.onStart()
        val rv: RecyclerView = findViewById(R.id.rv_juegos_disponible)
        rv.layoutManager = GridLayoutManager(this,1,LinearLayoutManager.VERTICAL,false)

        rv.adapter = GamesAdapter(listaDeJuegos)
    }
}