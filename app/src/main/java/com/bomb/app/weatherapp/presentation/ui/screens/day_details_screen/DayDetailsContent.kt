package com.bomb.app.weatherapp.presentation.ui.screens.day_details_screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bomb.app.weatherapp.R
import com.bomb.app.weatherapp.domain.model.City
import com.bomb.app.weatherapp.domain.model.Historical
import com.bomb.app.weatherapp.presentation.ui.screens.day_details_screen.views.HistoryItem
import com.bomb.app.weatherapp.utils.getDaysFromDateTime
import com.bomb.app.weatherapp.utils.toCelsius

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoricalContent(historicalData: List<Historical>, main: Historical) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding()
    ) {
        Image(
            painter = painterResource(R.drawable.on_bording_cover),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(244.dp)
                    .width(244.dp),
                painter = painterResource(R.drawable.icon),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = "${main.temperature.toCelsius()}°",
                style = TextStyle(
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
            Text(
                text = main.description,
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White
                )
            )
            Text(
                text = "humidity: ${main.humidity}% ",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White
                )
            )
            Text(
                text = "wind speed : ${main.windSpeed}km/h ",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White
                )
            )
            Image(
                modifier = Modifier
                    .height(198.dp)
                    .width(336.dp),
                painter = painterResource(R.drawable.house2),
                contentDescription = null
            )
            Card(
                modifier = Modifier
                    .height(248.dp)
                    .width(428.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.elevatedCardElevation(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFF9D52AC),
                                    Color(0xFF3E2D8F),
                                )
                            )
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = main.date.getDaysFromDateTime(), modifier = Modifier
                                .height(20.dp),
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                        Text(
                            text = "${main.city.name},${main.city.country}", modifier = Modifier
                                .height(20.dp)
                                .width(78.dp),
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                        )
                    }
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color.White)
                    )
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        items(historicalData) { item ->
                            HistoryItem(item = item)
                        }
                    }
                }
            }

        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HistoricalScreenPreview() {
    HistoricalContent(
        historicalData = listOf(
            Historical(
                id = 0,
                city = City(
                    id = 0,
                    name = "Cairo",
                    country = "Egypt",
                ),
                icon = "icon",
                date = "2-12-2023",
                description = "description",
                temperature = 29.0,
                humidity = 0.0,
                windSpeed = 12.0,

                ),
            Historical(
                id = 0,
                city = City(
                    id = 0,
                    name = "Cairo",
                    country = "Egypt",
                ),
                icon = "icon",
                date = "2-12-2023",
                description = "description",
                temperature = 25.0,
                humidity = 0.0,
                windSpeed = 12.0,
            ),


            ),
        main = Historical(
            id = 0,
            city = City(
                id = 0,
                name = "Cairo",
                country = "Egypt",
            ),
            icon = "icon",
            date = "2-12-2023",
            description = "description",
            temperature = 29.0,
            humidity = 0.0,
            windSpeed = 12.0,
            )
    )
}