package com.bomb.app.weatherapp.presentation.ui.screens.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bomb.app.weatherapp.R
import com.bomb.app.weatherapp.domain.model.City

@Composable
fun CityItem(modifier: Modifier,city: City) {
    Card(
        modifier = modifier.width(342.dp)
            .height(150.dp),
        colors = CardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent,
        )

    ) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(R.drawable.city_item_background),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Row(modifier = Modifier.width(342.dp),
                horizontalArrangement = Arrangement.SpaceAround) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = "${city.name} , ${city.country}", style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0XFFEBEBF5)
                        ),
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                }
                Image(
                    modifier = Modifier
                        .height(160.dp)
                        .fillMaxWidth(), painter = painterResource(R.drawable.house),
                    contentDescription = null
                )

            }
            /*Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = "${city.name} , ${city.country}", style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0XFFEBEBF5)
                    ),
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }*/

        }
    }
}