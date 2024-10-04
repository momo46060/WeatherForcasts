package com.bomb.app.weatherapp.domain.model

data class Historical(
    val id: Int,
    val city: City,
    val icon: String,
    val date: String,
    val description: String,
    val temperature: Double,
    val humidity: Double,
    val windSpeed: Double,
)