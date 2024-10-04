package com.bomb.app.weatherapp.data.repository

import android.util.Log
import com.bomb.app.weatherapp.data.local.dao.CityDao
import com.bomb.app.weatherapp.data.local.dao.HistoricalDao
import com.bomb.app.weatherapp.data.local.entites.CityEntity
import com.bomb.app.weatherapp.data.local.entites.HistoricalEntity
import com.bomb.app.weatherapp.data.local.entites.toEntity
import com.bomb.app.weatherapp.data.local.entites.toModel
import com.bomb.app.weatherapp.data.remote.WeatherAPIService
import com.bomb.app.weatherapp.data.remote.response.WeatherData
import com.bomb.app.weatherapp.data.utils.toResource
import com.bomb.app.weatherapp.domain.model.City
import com.bomb.app.weatherapp.domain.model.Historical
import com.bomb.app.weatherapp.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class WeatherRepositoryImpl(
    private  val apiService: WeatherAPIService,
    private val cityDao: CityDao,
    private val historicalDao: HistoricalDao
) :
    WeatherRepository {
    override suspend fun addCity(cityName: String) {
        val response = apiService.getHistoricalData(cityName).toResource()
        response.data?.let { response ->
            val city = CityEntity(
                response.city.id,
                response.city.name,
                response.city.country
            )
            cityDao.insert(city)
            response.list?.let { list ->
                val dataList = getHistoricalList(city,list)
                historicalDao.insertList(dataList)
            }
        }
    }

    override suspend fun getCities(): Flow<List<City>> =
        cityDao.getCities().map { list -> list.map { it.toModel() } }


    override suspend fun getHistoricalData(id: Int): Flow<List<Historical>> =
        historicalDao.getHistoricalData(id).map { list ->
            list.map { it.toModel() }
        }


    private fun getHistoricalList(
        cityEntity: CityEntity,
        list: List<WeatherData>
    ): List<HistoricalEntity> {
        val dataList = ArrayList<HistoricalEntity>()
        list.forEach { item ->
            dataList.add(
                HistoricalEntity(
                    0,
                    cityEntity,
                    item.weather[0].icon,
                    item.dt_txt,
                    item.weather[0].description,
                    item.main.temp,
                    item.main.humidity,
                    item.wind.speed
                )
            )
        }
        return dataList
    }
}

