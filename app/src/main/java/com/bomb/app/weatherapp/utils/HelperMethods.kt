package com.bomb.app.weatherapp.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter



@RequiresApi(Build.VERSION_CODES.O)
fun String.getHourFromDateTime(): String {

    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    val dateTime = LocalDateTime.parse(this, inputFormatter)

    val outputFormatter = DateTimeFormatter.ofPattern("HH-mm")

    val formattedTime = dateTime.format(outputFormatter)
    return formattedTime
}
@RequiresApi(Build.VERSION_CODES.O)
fun String.getDaysFromDateTime(): String {

    val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    val dateTime = LocalDateTime.parse(this, inputFormatter)

    val outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    val formattedTime = dateTime.format(outputFormatter)
    return formattedTime

}
fun Double.toCelsius(): String {
    return String.format("%.2f", this - 273.15)
}