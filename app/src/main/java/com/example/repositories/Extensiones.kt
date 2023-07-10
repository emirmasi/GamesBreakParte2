package src.main.kotlin.src.main.kotlin.repositories

import android.os.Build
import java.text.DecimalFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun LocalDate.hoyConMiFormato():String{
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        this.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
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

    var period : Period = Period.between(fechaDeRegistro, this)
    return period.months;
}

fun Double.format():String{
    val formato = DecimalFormat("#.##")
    return formato.format(this)
}