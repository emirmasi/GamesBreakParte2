package com.example

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
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
import com.example.Data.User
import com.example.GamesBreakParte2.saldont
import com.example.practicandodiseo.R
import com.example.practicandodiseo.databinding.ElegitIntermediarioBinding
import repositories.GameRepository
import repositories.UserRepository
import src.main.kotlin.src.main.kotlin.repositories.hoyConMiFormato
import java.time.LocalDate

class ElegirIntermediario: AppCompatActivity() {

    ///vamos a usar binding
    private lateinit var binding: ElegitIntermediarioBinding

    private var usuarioLogueado = UserRepository.usuario
    private var juegoElegido = GameRepository.getById(UserRepository.idGame)
    private lateinit var tvTotal:TextView
    private lateinit var btnConfirmarCompra:Button
    private lateinit var intermediarioElegido:Intermediario
    private lateinit var bt_atras:ImageButton
    private lateinit var tvCashBack:TextView
    private lateinit var cardSteam:CardView
    private lateinit var cardNakama:CardView
    private lateinit var cardEpicGames:CardView


    @SuppressLint("MissingInflatedId", "SetTextI18n")
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

            var cashback = 0.0
            var hoy  = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                LocalDate.now()
            } else {
                TODO("VERSION.SDK_INT < O")
            }

            try {
                if(intermediarioElegido!=null ){
                    usuarioLogueado?.realizarCompra(intermediarioElegido,juegoElegido)
                    cashback = intermediarioElegido.calcularCashBack(hoy.hoyConMiFormato(),tvTotal.text.toString().toDouble())

                    tvCashBack.text = "Gracias por su compra le devolvemos $cashback por un beneficio que tenemos "
                    tvCashBack.visibility = View.VISIBLE
                }
            }catch (sal:saldont){

                    Toast.makeText(this,sal.message,Toast.LENGTH_LONG)
            }
        }

        bt_atras.setOnClickListener {
            var intent = Intent(this,HomePrueba2Activity::class.java)
            startActivity(intent)
        }

        cardSteam.setOnClickListener { setIntermediarioElegido(Steam()) }
        cardNakama.setOnClickListener { setIntermediarioElegido(Nakama()) }
        cardEpicGames.setOnClickListener { setIntermediarioElegido(EpicGames()) }
    }
    fun setIntermediarioElegido(intermediario: Intermediario) {
        intermediarioElegido = intermediario
        tvTotal.text = intermediario.aplicarComision(juegoElegido.price).toString()
    }
}