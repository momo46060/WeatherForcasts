package com.bomb.app.weatherapp.presentation.ui.screens.day_details_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.bomb.app.weatherapp.presentation.viewmodel.WeatherViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoricalScreen(
    viewModel: WeatherViewModel
) {
    val dayHistory by viewModel.dayHistory.collectAsState()
    if (dayHistory.isNotEmpty()){
        HistoricalContent(
            historicalData = dayHistory,
            main = dayHistory.first()
        )
    }else{
        CircularProgressIndicator()
    }

}