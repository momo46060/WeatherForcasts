package com.bomb.app.weatherapp.domain.usecase.city

import com.bomb.app.weatherapp.domain.model.City
import com.bomb.app.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetCitiesUseCase (private val weatherRepository: WeatherRepository) {

    suspend fun execute(): Flow<List<City>> = weatherRepository.getCities()

}