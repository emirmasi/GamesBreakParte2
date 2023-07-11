package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.Data.User
import com.example.practicandodiseo.databinding.ActivityLoginBinding
import repositories.UserRepository

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.etLoginNickname
        val password = binding.password
        val botonIngresar = binding.botonIngresar


        botonIngresar.setOnClickListener {
            val nickName = email.text.toString().trim()
            val passwordUser = password.text.toString().trim()
            if (nickName.isEmpty() || passwordUser.isEmpty()){
                Toast.makeText(this,"alguno de los campos esta vacio",Toast.LENGTH_LONG).show()
            }else{
                if(UserRepository.login(nickName,passwordUser)){
                    Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }else {
                    Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }


}
