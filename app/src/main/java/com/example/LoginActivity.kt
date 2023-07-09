package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicandodiseo.databinding.ActivityLoginBinding
import repositories.UserRepository

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val email = binding.email
        val password = binding.password
        val botonIngresar = binding.botonIngresar



        botonIngresar.setOnClickListener {
            if (UserRepository.login(email.getText().toString(), password.getText().toString())){
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomePrueba2Activity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }




    }


}
