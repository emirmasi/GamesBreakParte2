package com.example

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.Data.User
import com.example.practicandodiseo.R
import com.example.practicandodiseo.databinding.ActivityCrearUsuarioBinding
import com.example.practicandodiseo.databinding.ActivityLoginBinding
import repositories.UserRepository
import repositories.UserRepository.addUser
import repositories.UserRepository.getLastId
import repositories.UserRepository.usuario
import src.main.kotlin.src.main.kotlin.repositories.hoyConMiFormato
import java.time.LocalDate

class CrearUsuarioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearUsuarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCrearUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textNickname = binding.editTextNickname.getText().toString()
        val textPassword = binding.editTextPassword.getText().toString()
        val textNombre = binding.editTextNombre.getText().toString()
        val textApellido = binding.editTextApellido.getText().toString()
        val textDinero = binding.editTextDinero.getText().toString()
        var usuario: User
        val botonConfirmarCreacionUsuario = binding.buttonConfirmarCrearUsuario

        //User(getLastId(),nickname,password,name,surname,money,hoy.hoyConMiFormato())


        val hoy: LocalDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now()
        } else {
            TODO("VERSION.SDK_INT < O")
        }




        //boton para ir a LoginActivity

        botonConfirmarCreacionUsuario.setOnClickListener {
            if(textNickname.isNotEmpty() || textPassword.isNotEmpty() || textNombre.isNotEmpty() || textApellido.isNotEmpty() || textDinero.isNotEmpty()) {
                /*usuario = User(getLastId(),textNickname,textPassword,textNombre,textApellido,textDinero.toDouble(),hoy.hoyConMiFormato())
                UserRepository.addUser(usuario)*/
                Toast.makeText(this, "Usuario creado con exito", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            }

            Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}