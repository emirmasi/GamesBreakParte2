package com.example.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Data.Game
import com.example.practicandodiseo.R
import com.squareup.picasso.Picasso
import data.Purchase
import repositories.GameRepository
import src.main.kotlin.src.main.kotlin.repositories.format

class HistorialComprasAdapter(private var data: MutableList<Purchase>): RecyclerView.Adapter<HistorialComprasAdapter.MyViewHolder>() {

    class MyViewHolder (row: View) :RecyclerView.ViewHolder(row) {
        val imageView = row.findViewById<ImageView>(R.id.iv_historialCompra)
        val nombreJuego = row.findViewById<TextView>(R.id.tv_nombre)
        val generoJuego = row.findViewById<TextView>(R.id.tv_genero)
        val precioJuego = row.findViewById<TextView>(R.id.tv_precio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_historial_compras,parent,false)
        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val datos = data.get(position)

        holder.nombreJuego.text =GameRepository.getById(datos.gameId).name
        holder.generoJuego.text = GameRepository.getById(datos.gameId).genre
        holder.precioJuego.text = datos.amount.format()

        Picasso.get().
        load(GameRepository.getById(datos.gameId).permalink).
        placeholder(R.drawable.game_break_logo).
        into(holder.imageView)
    }

}