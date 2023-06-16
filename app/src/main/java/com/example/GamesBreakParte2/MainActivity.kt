package com.example.GamesBreakParte2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.Diseño.gamesActivity
import com.example.practicandodiseo.R

class MainActivity : AppCompatActivity( ) {

    private lateinit var b_crear_usario: Button
    private lateinit var b_ingresar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b_crear_usario = findViewById(R.id.b_crear_usuario)
        b_ingresar = findViewById(R.id.b_ingresar)

        ///boton para ir a la activity de crear un usuario
        b_crear_usario.setOnClickListener{
            val intent = Intent(this,gamesActivity::class.java)
            startActivity(intent)
        }
        //boton para ir a la activity de ingresar
        b_ingresar.setOnClickListener {

        }
    }
}