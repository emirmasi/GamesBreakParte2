package com.example.ui.cargarSaldo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practicandodiseo.databinding.FragmentCargarSaldoBinding

class CargarSaldoFragment : Fragment() {

    lateinit var btnCargar: Button
    lateinit var monto: EditText
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
        val textView: TextView = binding.textDashboard
        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}