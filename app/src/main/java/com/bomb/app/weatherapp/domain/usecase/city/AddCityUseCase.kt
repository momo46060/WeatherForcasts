package com.bomb.app.weatherapp.domain.usecase.city

import com.bomb.app.weatherapp.domain.repository.WeatherRepository

class AddCityUseCase (private val weatherRepository: WeatherRepository) {

    suspend fun execute(cityName: String)= weatherRepository.addCity(cityName)

}