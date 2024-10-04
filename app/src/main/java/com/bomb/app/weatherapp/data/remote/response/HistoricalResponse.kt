package com.bomb.app.weatherapp.data.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class HistoricalResponse(

    @SerialName("city")
    val city: City,

    @SerialName("cod")
    val cod: String,

    @SerialName("message")
    val message: Int,

    @SerialName("list")
    val list: List<WeatherData>
)

@Serializable
data class City(

    @SerialName("country")
    val country: String,

    @SerialName("name")
    val name: String,

    @SerialName("id")
    val id: Int
)

@Serializable
data class Wind(
    @SerialName("speed")
    val speed: Double
)

@Serializable
data class WeatherData(

    val dt_txt: String,

    @SerialName("weather")
    val weather: List<WeatherItem>,

    @SerialName("main")
    val main: Main,

    @SerialName("wind")
    val wind: Wind,

)

@Serializable
data class Main(

    @SerialName("temp")
    val temp: Double,

    @SerialName("humidity")
    val humidity: Double
)
@Serializable

data class WeatherItem(

    @SerialName("icon")
    val icon: String,

    @SerialName("description")
    val description: String
)