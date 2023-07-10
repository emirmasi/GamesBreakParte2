package com.example.ui.verHistorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Adapters.HistorialComprasAdapter
import com.example.practicandodiseo.databinding.FragmentVerHistorialBinding
import data.Purchase
import repositories.PurchaseRepository
import repositories.UserRepository

class VerHistorialFragment : Fragment() {

    private var _binding: FragmentVerHistorialBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var historialAdapter : HistorialComprasAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerHistorialBinding.inflate(inflater, container, false)
        val root: View = binding.root
        iniciarRecyclerViewHistorialCompras()



        return root
    }

    private fun iniciarRecyclerViewHistorialCompras(){
        var layouttManager = LinearLayoutManager(context)
        recyclerView = binding.rvHistoriaslCompras
        recyclerView.layoutManager = layouttManager
        historialAdapter = HistorialComprasAdapter(PurchaseRepository.getHistorialDeCompra(
            UserRepository.usuario?.id
        )as MutableList<Purchase>)
        recyclerView.adapter = historialAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}