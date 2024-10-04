package com.bomb.app.weatherapp.domain.usecase.historical

import com.bomb.app.weatherapp.domain.model.Historical
import com.bomb.app.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow

class GetHistoricalDataUseCase (private val weatherRepository: WeatherRepository) {

    suspend fun execute(id: Int): Flow<List<Historical>> =
        weatherRepository.getHistoricalData(id)
}