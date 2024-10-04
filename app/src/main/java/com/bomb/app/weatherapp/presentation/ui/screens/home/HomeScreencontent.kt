package com.bomb.app.weatherapp.presentation.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.bomb.app.weatherapp.presentation.ui.screens.home.views.CityItem
import com.bomb.app.weatherapp.utils.Resource

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    searchCity: (String) -> Unit,
    cities: List<City>,
    onFloatingButtonClicked: () -> Unit,
    onCityClicked: (Int) -> Unit,
) {
    var cityName by remember { mutableStateOf("") }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onFloatingButtonClicked()
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add City")
            }
        }
    ) { _ ->
                  Box(
                      modifier = Modifier
                          .fillMaxSize()
                          .padding()
                  ) {
                      Image(
                          painter = painterResource(R.drawable.on_bording_cover),
                          contentScale = ContentScale.FillHeight,
                          contentDescription = null
                      )
                      Column(
                          modifier = modifier
                              .padding()
                              .fillMaxSize(),
                          horizontalAlignment = Alignment.CenterHorizontally
                      ) {
                          // Input for city name
                          Spacer(Modifier.height(10.dp))
                          OutlinedTextField(
                              modifier = Modifier
                                  .width(358.dp)
                                  .height(58.dp),
                              value = cityName,
                              onValueChange = { cityName = it
                                  searchCity(it)},
                              shape = RoundedCornerShape(15.dp),
                              colors = OutlinedTextFieldDefaults.colors(
                                  unfocusedContainerColor = Color(0XFF1C1B33),
                                  focusedContainerColor = Color(0XFF1C1B33),
                                  focusedTextColor = Color(0XFFEBEBF5),
                                  unfocusedTextColor = Color(0XFFEBEBF5),
                              ),
                              label = {
                                  Text(
                                      "Search For city", style = TextStyle(
                                          fontSize = 12.sp,
                                          color = Color(0XFFEBEBF5)
                                      ),
                                      fontWeight = FontWeight.Normal
                                  )
                              },
                              leadingIcon = {
                                  Icon(
                                      Icons.Default.Search,
                                      contentDescription = null,
                                      tint = Color(0XFFEBEBF5)
                                  )
                              },
                          )
                          // Display the list of cities
                          LazyColumn(
                              modifier = Modifier.padding(top = 35.dp),
                              verticalArrangement = Arrangement.spacedBy(40.dp)
                          ) {
                              items(cities) { city ->
                                  CityItem(modifier = Modifier.clickable {
                                      onCityClicked(city.id) },
                                      city = city)
                              }
                          }
                      }
                  }
              }

          }


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenContentPreview() {
    HomeScreenContent(
        cities =  listOf(
            City(
                id = 0,
                name = "Cairo",
                country = "Egypt"
            ),
            City(
                id = 0,
                name = "Cairo",
                country = "Egypt"
        )),
        onFloatingButtonClicked = {},
        onCityClicked = {},
        searchCity = {},
    )
}