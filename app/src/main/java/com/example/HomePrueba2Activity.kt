package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practicandodiseo.R

import com.example.practicandodiseo.databinding.ActivityHomePrueba2Binding
import com.example.ui.cargarSaldo.CargarSaldoFragment
import repositories.UserRepository

class HomePrueba2Activity : AppCompatActivity(),CargarSaldoFragment.RefreshListener {

    private lateinit var binding: ActivityHomePrueba2Binding

    private lateinit var tvCerrarSesion:TextView
    private lateinit var tvSaldo:TextView
    private lateinit var tvNickName:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomePrueba2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home_prueba2)

        navView.setupWithNavController(navController)

        tvCerrarSesion = binding.root.findViewById(R.id.tv_cerrar_sesion)

        tvCerrarSesion.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        tvSaldo = binding.root.findViewById(R.id.saldo_disponible)
        tvSaldo.text = UserRepository.usuario?.money.toString()

        ///inicializamos nickname
        tvNickName = binding.root.findViewById(R.id.tv_nickName)
        tvNickName.text = UserRepository.usuario?.name.toString()

    }
    override fun onRefreshRequested() {
        tvSaldo.text = UserRepository.usuario?.money.toString()
    }
}