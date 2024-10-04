package com.bomb.app.weatherapp.presentation.navigition

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bomb.app.weatherapp.presentation.ui.screens.day_details_screen.HistoricalScreen
import com.bomb.app.weatherapp.presentation.ui.screens.six_days_forecasts.FiveDayForecasts
import com.bomb.app.weatherapp.presentation.ui.screens.home.WeatherScreen
import com.bomb.app.weatherapp.presentation.ui.screens.onBoarding.OnBoarding
import com.bomb.app.weatherapp.presentation.viewmodel.WeatherViewModel
import org.koin.androidx.compose.koinViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost(navController: NavHostController, viewModel: WeatherViewModel = koinViewModel()) {
    NavHost(navController = navController, startDestination = Screen.onBoarding.route) {
        composable(Screen.Home.route) {
            WeatherScreen(navController = navController, viewModel = viewModel)
        }
        composable(Screen.onBoarding.route) {
            OnBoarding(navHostController = navController)
        }
        composable(Screen.HistoricalScreen.route) {
            HistoricalScreen( viewModel = viewModel)
        }
        composable(Screen.FiveDayForecasts.route) {
            FiveDayForecasts(navController = navController, viewModel = viewModel)
        }
    }
}
