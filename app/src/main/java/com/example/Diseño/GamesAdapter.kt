package com.example.Diseño

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Data.Game
import com.example.practicandodiseo.R
import com.squareup.picasso.Picasso

class GamesAdapter(val data: List<Game>): RecyclerView.Adapter<GamesAdapter.MyViewHolder>() {
    class MyViewHolder(row: View) :RecyclerView.ViewHolder(row){
        val imageView = row.findViewById<ImageView>(R.id.games_imagen)
        val nombreJuego = row.findViewById<TextView>(R.id.games_nombre)
        val generoJueog = row.findViewById<TextView>(R.id.games_genero)
        val precioJuego = row.findViewById<TextView>(R.id.games_precio)

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

    }
}