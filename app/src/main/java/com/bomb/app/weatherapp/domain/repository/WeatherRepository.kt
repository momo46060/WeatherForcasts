package com.bomb.app.weatherapp.domain.repository

import com.bomb.app.weatherapp.domain.model.City
import com.bomb.app.weatherapp.domain.model.Historical
import com.bomb.app.weatherapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {


    suspend fun addCity(cityName: String)

    suspend fun getCities(): Flow<List<City>>

    suspend fun getHistoricalData(id: Int): Flow<List<Historical>>
}