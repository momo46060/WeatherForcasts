package com.bomb.app.weatherapp.presentation.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bomb.app.weatherapp.domain.model.City
import com.bomb.app.weatherapp.domain.model.Historical
import com.bomb.app.weatherapp.domain.usecase.city.AddCityUseCase
import com.bomb.app.weatherapp.domain.usecase.city.GetCitiesUseCase
import com.bomb.app.weatherapp.domain.usecase.historical.GetHistoricalDataUseCase
import com.bomb.app.weatherapp.utils.getDaysFromDateTime
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import kotlinx.coroutines.launch

class WeatherViewModel(
    private val addCityUseCase: AddCityUseCase,
    private val getCitiesUseCase: GetCitiesUseCase,
    private val getHistoricalDataUseCase: GetHistoricalDataUseCase,

    ) : ViewModel() {
    var _cities: MutableStateFlow<List<City>> = MutableStateFlow(emptyList())
    val cities: StateFlow<List<City>> = _cities;

    var _cityId: MutableStateFlow<Int> = MutableStateFlow(0)

    var _historicalData: MutableStateFlow<List<Historical>> = MutableStateFlow(emptyList())

    var _fiveDayHistory: MutableStateFlow<List<Historical>> = MutableStateFlow(emptyList())
    val fiveDayHistory: StateFlow<List<Historical>> = _fiveDayHistory;

    var _dayHistory: MutableStateFlow<List<Historical>> = MutableStateFlow(emptyList())
    val dayHistory: StateFlow<List<Historical>> = _dayHistory;

    init {
        viewModelScope.launch(IO) {
            getCitiesUseCase.execute().collect {
                _cities.value = it
            }
        }
    }


    fun getCities() {
        viewModelScope.launch(IO) {
            getCitiesUseCase.execute().collect {
                _cities.value = it
            }
        }
    }

    fun addCity(cityName: String) {
        viewModelScope.launch(IO) {
            addCityUseCase.execute(cityName)
        }
    }

    fun searchCity(cityName: String) {
        viewModelScope.launch(IO) {
            _cities.value = _cities.value.filter { it.name.contains(cityName) }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateCityId(id: Int) {
        viewModelScope.launch {
            _cityId.value = id
            getHistoricalDataUseCase.execute(id).collect {
                _historicalData.value = it
                sixDayForecastshistory()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun sixDayForecastshistory() {
        viewModelScope.launch(IO) {
            _fiveDayHistory.value =
                _historicalData.value.distinctBy { it.date.getDaysFromDateTime() }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDayDetails(date: String) {
        viewModelScope.launch(IO) {
            _dayHistory.value =
                _historicalData.value.filter { it.date.getDaysFromDateTime() == date }
        }
    }

}

