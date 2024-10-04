package com.bomb.app.weatherapp.presentation.ui.screens.six_days_forecasts

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.bomb.app.weatherapp.presentation.navigition.Screen
import com.bomb.app.weatherapp.presentation.viewmodel.WeatherViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FiveDayForecasts(navController: NavController, viewModel: WeatherViewModel) {
    val fiveDayHistory by viewModel.fiveDayHistory.collectAsState()
    FiveDayForecastsContent(fiveDayHistory = fiveDayHistory,
        onItemClick = { date ->
            viewModel.getDayDetails(date)
            navController.navigate(Screen.HistoricalScreen.route)
        }
    )
}


