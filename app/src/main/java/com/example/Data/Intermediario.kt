package com.example.Data

import android.os.Build
import src.main.kotlin.src.main.kotlin.repositories.calcularDifenMeses
import java.time.LocalDate

abstract class Intermediario() {
    abstract fun aplicarComision(precio: Double):Double
    fun calcularCashBack(createdDate: String, amount:Double):Double {
        val cashback: Double
        val fecha:LocalDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDate.now()
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        val mesCreacion = fecha.calcularDifenMeses(createdDate)
        cashback = when(mesCreacion){
            in 1..3 -> 0.05
            in 4..12 ->0.03
            else -> 0.0
        }
        return amount.times(cashback)
    }

}


