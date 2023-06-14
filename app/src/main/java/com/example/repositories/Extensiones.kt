package src.main.kotlin.src.main.kotlin.repositories

import android.os.Build
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun LocalDate.hoyConMiFormato():String{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")).toString()
    } else {
        TODO("VERSION.SDK_INT < O")
    }
}
fun LocalDate.calcularDifenMeses(fecha: String):Int{
    var formatter = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        DateTimeFormatter.ofPattern("yyyy/MM/dd")
    } else {
        TODO("VERSION.SDK_INT < O")
    }
    val fechaDeRegistro: LocalDate = LocalDate.parse(fecha,formatter)

    val hoy: LocalDate = LocalDate.now()
    var period : Period = Period.between(fechaDeRegistro, hoy)
    return period.months;
}