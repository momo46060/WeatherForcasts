package com.bomb.app.weatherapp.presentation.ui.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bomb.app.weatherapp.presentation.navigition.Screen
import com.bomb.app.weatherapp.presentation.ui.screens.home.views.SheetContent
import com.bomb.app.weatherapp.presentation.viewmodel.WeatherViewModel
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel , navController: NavController) {
    val cities by viewModel.cities.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    // Bottom Sheet state
    val bottomSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            SheetValue.Hidden,
            skipHiddenState = false
        )
    )

    BottomSheetScaffold(
        scaffoldState = bottomSheetState,
        sheetContent = {
           SheetContent(
               addCity = {cityName->
                   viewModel.addCity(cityName)
                   coroutineScope.launch {
                       bottomSheetState.bottomSheetState.hide() // Hide the sheet after adding
                   }
               }
           )
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Weather",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .height(30.dp)
                            .width(130.dp),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0XFF2E335A)
                ),
                modifier = Modifier.height(90.dp),
            )
        },
        sheetPeekHeight = 0.dp,  // Keeps the sheet hidden when not shown
        content = { _ ->
            HomeScreenContent(
                modifier = Modifier.padding(),
                cities = cities,
                onFloatingButtonClicked = {
                    coroutineScope.launch {
                        bottomSheetState.bottomSheetState.expand()  // Show the bottom sheet
                    }
                },
                onCityClicked = { id->
                    viewModel.updateCityId(id)
                    navController.navigate(Screen.FiveDayForecasts.route)
                },
                searchCity = {
                    viewModel.searchCity(it)
                }
            )
        }
    )

}
