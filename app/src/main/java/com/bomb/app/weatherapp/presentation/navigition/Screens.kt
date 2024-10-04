package com.bomb.app.weatherapp.presentation.navigition

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object onBoarding : Screen("onBoarding")
    object HistoricalScreen : Screen("HistoricalScreen")
    object FiveDayForecasts : Screen("FiveDayForecasts")
}