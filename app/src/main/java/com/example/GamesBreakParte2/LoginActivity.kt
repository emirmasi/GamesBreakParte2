package com.example.GamesBreakParte2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.HomePrueba2Activity
import com.example.practicandodiseo.R
import repositories.UserRepository

import repositories.UserRepository.usuario

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val nickName: TextView = findViewById(R.id.textNickName)
        val password: TextView = findViewById(R.id.textPassword)
        val botonIngresar : Button = findViewById(R.id.botonIngresar)

nickName.getText().toString()

    botonIngresar.setOnClickListener {

        if (UserRepository.login(nickName.getText().toString(),password.getText().toString())){
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomePrueba2Activity::class.java)}
            else {
                Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
            }

    }




        }


    }
