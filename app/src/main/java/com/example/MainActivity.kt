package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
            val intent = Intent(this, CrearUsuarioActivity::class.java)
            startActivity(intent)

        }
        //boton para ir a la activity de ingresar
        //en este caso quiero ir al activityHome
        b_ingresar.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}