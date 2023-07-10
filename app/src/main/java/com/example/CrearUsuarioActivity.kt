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

         textNickname= binding.editTextNickname
         textPassword = binding.editTextPassword
         textNombre = binding.editTextNombre
         textApellido = binding.editTextApellido
         textDinero = binding.editTextDinero
         botonConfirmarCreacionUsuario = binding.buttonConfirmarCrearUsuario

        botonConfirmarCreacionUsuario.setOnClickListener {
            if(UserRepository.crearUsuario(textNickname.text.toString(),textPassword.text.toString(),textNombre.text.toString(),textApellido.text.toString(),textDinero.text.toString().toDouble())) {
                Toast.makeText(this, "Usuario creado con exito", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomePrueba2Activity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Completar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}