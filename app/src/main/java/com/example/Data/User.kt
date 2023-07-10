package com.example.Data

import android.os.Build
import com.example.GamesBreakParte2.saldont
import data.Purchase
import repositories.PurchaseRepository
import src.main.kotlin.src.main.kotlin.repositories.hoyConMiFormato
import java.time.LocalDate

class User (
    val id: Long,
    val nickName: String,
    val password: String,
    val name: String,
    val surname: String,
    var money: Double,
    val createdDate: String
){
    override fun toString(): String {
        return "User(id=$id, nickName='$nickName', password='$password', name='$name', surname='$surname', money=$money, createdDate='$createdDate')"
    }
    fun realizarCompra(intermediario:Intermediario,juego:Game):Double{

        val precioTotal = intermediario.aplicarComision(juego.price)
        val cashBack:Double

        if(comprobarSaldo(precioTotal)){
            val hoy = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                LocalDate.now()
            } else {
                TODO("VERSION.SDK_INT < O")
            }
            val compra = Purchase(PurchaseRepository.getLastId(), this.id, juego.id,precioTotal,hoy.hoyConMiFormato())
            PurchaseRepository.add(compra)

            cashBack = intermediario.calcularCashBack(this.createdDate,precioTotal)

            actualizarSaldo(precioTotal,cashBack)

        }else{
            throw saldont()
        }
        return cashBack
    }
    fun actualizarSaldo(precioTotal: Double,cashBack: Double){
        this.money -= (precioTotal - cashBack)
    }

    fun comprobarSaldo(precioDelJuego: Double): Boolean{
        return this.money >= precioDelJuego;
    }

    fun cargarSaldo(monto: Double){
        this.money += monto
        println("nuevo saldo: ${this.money}")
    }

    fun mostrarHistorialDeCompra(){

        val historialDeCompra: List<Purchase> = PurchaseRepository.getHistorialDeCompra(this.id)

        if(historialDeCompra.isEmpty()){
            println("no posee un historial de compra")
        }else{
            for(compra in historialDeCompra){
                println(compra)
            }
        }

    }

}