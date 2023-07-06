package com.example

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practicandodiseo.R
import com.example.practicandodiseo.R.id.navigation_dashboard
import com.example.practicandodiseo.R.id.navigation_home
import com.example.practicandodiseo.R.id.navigation_notifications
import com.example.practicandodiseo.databinding.ActivityHomePrueba2Binding

class HomePrueba2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePrueba2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomePrueba2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home_prueba2)
        val appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout = null)
            //setOf(
             //   navigation_home, navigation_dashboard, navigation_notifications
           // )
        //)
        //setupActionBarWithNavController(navController.graph, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}