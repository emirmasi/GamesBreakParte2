package com.example.Diseño

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.example.practicandodiseo.R

class gamesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        val items = listOf("todos","accion","aventura","otros")

        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this,R.layout.list_item,items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
            adapterView, view, i, l ->
            val itemSelectedListener = adapterView.getItemAtPosition(i)
            Toast.makeText(this,"Items $itemSelectedListener",Toast.LENGTH_SHORT).show()
        }
    }
}