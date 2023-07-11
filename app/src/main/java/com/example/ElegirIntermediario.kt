package com.example

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.Data.EpicGames
import com.example.Data.Intermediario
import com.example.Data.Nakama
import com.example.Data.Steam

import com.example.GamesBreakParte2.saldont

import com.example.practicandodiseo.databinding.ElegitIntermediarioBinding
import repositories.GameRepository
import repositories.UserRepository
import src.main.kotlin.src.main.kotlin.repositories.format

class ElegirIntermediario: AppCompatActivity() {

    ///vamos a usar binding
    private lateinit var binding: ElegitIntermediarioBinding

    private var usuarioLogueado = UserRepository.usuario
    private var juegoElegido = GameRepository.getById(UserRepository.idGame)
    private lateinit var tvTotal:TextView
    private lateinit var btnConfirmarCompra:Button
    private  var intermediarioElegido: Intermediario? =null
    private lateinit var bt_atras:ImageButton
    private lateinit var tvCashBack:TextView
    private lateinit var cardSteam:CardView
    private lateinit var cardNakama:CardView
    private lateinit var cardEpicGames:CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ElegitIntermediarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ///inicializo laas variables

        tvTotal = binding.enTotalCompra
        tvTotal.text = juegoElegido.price.toString()
        bt_atras = binding.ibVolverInter
        cardNakama = binding.cvNakama
        cardSteam = binding.cvSteam
        cardEpicGames = binding.cvEpicgames
        tvCashBack = binding.tvCashback
        btnConfirmarCompra = binding.btnConfirmarCompra

        btnConfirmarCompra.setOnClickListener{

            if(intermediarioElegido != null){
                try {
                    val cashback =  usuarioLogueado?.realizarCompra(intermediarioElegido!!,juegoElegido)
                    val cashbackText = if (cashback != 0.0) {
                        "Gracias por su compra. Le devolvemos ${cashback?.format()} por un beneficio que tenemos."
                    } else {
                        "Gracias por su compra. Vuelva pronto."
                    }
                    tvCashBack.text = cashbackText
                    tvCashBack.visibility = View.VISIBLE
                }catch (sal:saldont){
                    Toast.makeText(this,sal.message,Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,"elija un intermediario",Toast.LENGTH_LONG).show()
            }


        }

        bt_atras.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        cardSteam.setOnClickListener { setIntermediarioElegido(Steam()) }
        cardNakama.setOnClickListener { setIntermediarioElegido(Nakama()) }
        cardEpicGames.setOnClickListener { setIntermediarioElegido(EpicGames()) }
    }
    fun setIntermediarioElegido(intermediario: Intermediario) {
        intermediarioElegido = intermediario
        tvTotal.text = "$${intermediario.aplicarComision(juegoElegido.price).format()}"
    }
}