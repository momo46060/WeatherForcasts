package com.bomb.app.weatherapp.presentation.ui.screens.day_details_screen.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.bomb.app.weatherapp.domain.model.Historical
import com.bomb.app.weatherapp.utils.getHourFromDateTime
import com.bomb.app.weatherapp.utils.toCelsius

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HistoryItem(item: Historical) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .width(89.dp)
                .height(23.dp),
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
                .height(66.dp)
                .width(66.dp),
            painter = painterResource(R.drawable.icon),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = Modifier
                .width(89.dp)
                .height(23.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier,
                text = item.date.getHourFromDateTime(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
            )
        }


    }

}