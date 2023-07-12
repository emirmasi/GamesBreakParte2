package com.example.Data
import android.os.Build
import java.time.LocalTime

class EpicGames(): Intermediario() {

    private val fechaActual = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalTime.now()
    } else {
        TODO("VERSION.SDK_INT < O")
    }//"yyyy-mm-dd: hh:mm:ss"
    private val hora = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        fechaActual.hour
    } else {
        TODO("VERSION.SDK_INT < O")
    }

    override fun aplicarComision(precio:Double):Double {
        if(hora<24 && hora>=20){
            return precio*1.01
        }else{
            return precio*1.03
        }
    }

}