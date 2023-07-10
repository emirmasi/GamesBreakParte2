package com.example.ui.cargarSaldo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practicandodiseo.R
import com.example.practicandodiseo.databinding.FragmentCargarSaldoBinding
import repositories.UserRepository

class CargarSaldoFragment : Fragment() {
    //var usuarioLogueado = UserRepository.usuario
    private var _binding: FragmentCargarSaldoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCargarSaldoBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val saldo: EditText = root.findViewById(R.id.saldoinput)

        val btnCargar: Button = root.findViewById(R.id.btnCargarSaldo)

        btnCargar.setOnClickListener {
            UserRepository.usuario?.cargarSaldo(saldo.text.toString().toDouble())
            val mostrar = UserRepository.usuario?.money.toString()
            Toast.makeText(context,mostrar,Toast.LENGTH_LONG).show()
        }

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}