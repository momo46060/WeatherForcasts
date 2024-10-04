package com.bomb.app.weatherapp.presentation.ui.screens.six_days_forecasts

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bomb.app.weatherapp.R
import com.bomb.app.weatherapp.domain.model.City
import com.bomb.app.weatherapp.domain.model.Historical
import com.bomb.app.weatherapp.utils.getDaysFromDateTime
import com.bomb.app.weatherapp.utils.toCelsius

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FiveDayForecastsContent(fiveDayHistory: List<Historical>,
                            modifier: Modifier = Modifier,
                            onItemClick: (String) -> Unit ) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.on_bording_cover),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(50.dp))
            Text(
                text = "North America",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White
                )
            )
            Text(
                modifier = Modifier.height(52.dp),
                text = "Max: 24°   Min:18°",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White
                )
            )
            Text(
                modifier = Modifier
                    .width(260.dp)
                    .height(32.dp),
                text = "5-Days Forecasts",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )

            LazyColumn(modifier = Modifier.width(300.dp)) {
                items(fiveDayHistory) { item ->
                    Card(
                        modifier = Modifier
                            .clickable {
                                onItemClick(item.date.getDaysFromDateTime())
                            }
                            .height(172.dp)
                            .width(348.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(30.dp)
                    ) {
                        Row(
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
                            Box(
                                modifier = Modifier
                                    .width(82.dp)
                                    .fillMaxHeight(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "${item.temperature.toCelsius()}°",
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.White
                                    )
                                )
                            }
                            Image(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(66.dp),
                                painter = painterResource(R.drawable.icon),
                                contentDescription = null,
                            )
                            Box(
                                modifier = Modifier
                                    .width(150.dp)
                                    .fillMaxHeight(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    modifier = Modifier
                                        .height(23.dp),
                                    text = item.date.getDaysFromDateTime(),
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Medium,
                                        color = Color.White
                                    )
                                )
                            }


                        }
                    }
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun funFiveDayForcastpreview() {
    FiveDayForecastsContent(
        listOf(
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

                )
        ),
        onItemClick = {}
    )
}