package com.bomb.app.weatherapp.presentation.ui.screens.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bomb.app.weatherapp.R
import com.bomb.app.weatherapp.domain.model.City
import com.bomb.app.weatherapp.presentation.navigition.Screen
import kotlinx.coroutines.launch

@Composable
fun SheetContent(modifier: Modifier = Modifier,
                 addCity:(String)->Unit) {
    var cityName by remember { mutableStateOf("") }
    Box {
        Image(
            modifier = Modifier.fillMaxSize()
                .fillMaxWidth(),
            painter = painterResource(R.drawable.on_bording_cover),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Add a New City", modifier = Modifier
                    .width(429.dp), style = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            // Input for city name

            OutlinedTextField(
                modifier = Modifier
                    .width(358.dp)
                    .height(58.dp),
                value = cityName,
                onValueChange = { cityName = it },
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
                }
            )
            Spacer(modifier = Modifier.height(30.dp))

            // Button to add the city
            Button(
                onClick = {
                    addCity(cityName)
                }, modifier = Modifier
                    .width(304.dp)
                    .height(72.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFFDDB130),
                )
            ) {
                Text(
                    "Add City", style = TextStyle(
                        color = Color(0XFF362A84),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontSize = 28.sp
                    )
                )
            }

        }
    }
}