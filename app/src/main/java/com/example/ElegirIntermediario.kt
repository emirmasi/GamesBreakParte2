package com.example

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
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
import repositories.GameRepository
import repositories.UserRepository

class ElegirIntermediario: AppCompatActivity() {

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


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.elegit_intermediario)
        ///inicializo las compras

        Toast.makeText(this,"estamos en el intermiediario",Toast.LENGTH_LONG)
        tvTotal = findViewById(R.id.en_total_compra)
        tvTotal.text = juegoElegido.price.toString()

        tvCashBack = findViewById(R.id.tv_cashback)

        btnConfirmarCompra = findViewById(R.id.btn_confirmar_compra)
        btnConfirmarCompra.setOnClickListener{

            try {
                if(intermediarioElegido!=null ){
                    usuarioLogueado?.realizarCompra(intermediarioElegido,juegoElegido)

                }
            }catch (sal:saldont){

                    Toast.makeText(this,sal.message,Toast.LENGTH_LONG)
            }
        }
        bt_atras = findViewById(R.id.ib_volver_Inter)
        bt_atras.setOnClickListener {
            var intent = Intent(this,HomePrueba2Activity::class.java)
            startActivity(intent)
        }

                ///tengo que hacer que haga un click en cada
        cardSteam = findViewById(R.id.cv_steam)
        cardSteam.setOnClickListener {
            intermediarioElegido = Steam()
            tvTotal.text = intermediarioElegido.aplicarComision(juegoElegido.price).toString()
        }
        cardNakama = findViewById(R.id.cv_nakama)
        cardNakama.setOnClickListener {
            intermediarioElegido = Nakama()
            tvTotal.text = intermediarioElegido.aplicarComision(juegoElegido.price).toString()
        }
        cardEpicGames = findViewById(R.id.cv_epicgames)
        cardEpicGames.setOnClickListener {
            intermediarioElegido = EpicGames()
            tvTotal.text = intermediarioElegido.aplicarComision(juegoElegido.price).toString()
        }
    }


}