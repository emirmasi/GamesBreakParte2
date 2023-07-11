package com.example

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.practicandodiseo.databinding.ActivityCrearUsuarioBinding

import repositories.UserRepository



class CrearUsuarioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearUsuarioBinding
    private lateinit var textDinero:EditText
    private lateinit var textNickname:EditText
    private lateinit var textPassword:EditText
    private lateinit var textNombre:EditText
    private lateinit var textApellido:EditText
    private lateinit var botonConfirmarCreacionUsuario:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCrearUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

         textNickname = binding.editTextNickname
         textPassword = binding.editTextPassword
         textNombre = binding.editTextNombre
         textApellido = binding.editTextApellido
         textDinero = binding.editTextDinero
         botonConfirmarCreacionUsuario = binding.buttonConfirmarCrearUsuario

        botonConfirmarCreacionUsuario.setOnClickListener {
            val nickname = textNickname.text.toString().trim()
            val password = textPassword.text.toString().trim()
            val nombre = textNombre.text.toString().trim()
            val apellido = textApellido.text.toString().trim()
            val dineroText = textDinero.text.toString().trim()

            if (nickname.isEmpty() || password.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
                Toast.makeText(this, "Error, completa todos los campos", Toast.LENGTH_LONG).show()
            } else {
                val dinero = if (dineroText.isNotEmpty()) dineroText.toDouble() else 0.0
                UserRepository.crearUsuario(nickname, password, nombre, apellido, dinero)
                Toast.makeText(this, "Usuario creado con éxito", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }
        }
    }
}