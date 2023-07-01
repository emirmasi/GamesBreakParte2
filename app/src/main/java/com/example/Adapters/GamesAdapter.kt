package com.example.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Data.Game
import com.example.practicandodiseo.R
import com.squareup.picasso.Picasso

class GamesAdapter(private var data: MutableList<Game>,private val itemClickListener: eventoComprar): RecyclerView.Adapter<GamesAdapter.MyViewHolder>(){

    interface eventoComprar{
        fun comprarEvento(id: Long, price: Double)
    }
    class MyViewHolder(row: View) :RecyclerView.ViewHolder(row){
        val imageView = row.findViewById<ImageView>(R.id.games_imagen)
        val nombreJuego = row.findViewById<TextView>(R.id.games_nombre)
        val generoJueog = row.findViewById<TextView>(R.id.games_genero)
        val precioJuego = row.findViewById<TextView>(R.id.games_precio)
        val btn_comprar = row.findViewById<Button>(R.id.b_comprar)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.cardview_list_games,parent,false)
        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nombreJuego.text = data.get(position).name
        holder.generoJueog.text = data.get(position).genre
        holder.precioJuego.text = data.get(position).price.toString()

        Picasso.get().load(data.get(position).permalink).into(holder.imageView)
        holder.btn_comprar.setOnClickListener{itemClickListener.comprarEvento(data.get(position).id,data.get(position).price)}
    }

    fun setListaFiltrada(listaFiltrada: MutableList<Game>){
        this.data = listaFiltrada
        notifyDataSetChanged()
    }


}
