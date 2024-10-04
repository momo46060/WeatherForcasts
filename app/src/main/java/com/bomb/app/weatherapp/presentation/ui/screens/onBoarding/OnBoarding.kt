package com.bomb.app.weatherapp.presentation.ui.screens.onBoarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bomb.app.weatherapp.R
import com.bomb.app.weatherapp.presentation.navigition.Screen

@Composable
fun OnBoarding(navHostController: NavHostController= rememberNavController()) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.on_bording_cover),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
        Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(428.dp),
                painter = painterResource(R.drawable.icon),
                contentDescription = null
            )
            Text(
                "Weather", modifier = Modifier
                    .width(429.dp), style = TextStyle(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 64.sp
                )
            )
            Text(
                "ForeCasts", modifier = Modifier
                    .width(429.dp), style = TextStyle(
                    color = Color(0XFFDDB130),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    fontSize = 64.sp
                )
            )
            Spacer(
                Modifier.height(50.dp)
            )
            Button(onClick = {
                navHostController.navigate(Screen.Home.route) {
                    // This clears the back stack and prevents returning to the MainScreen
                    popUpTo(Screen.onBoarding.route) { inclusive = true }
                }
            }, modifier = Modifier.width(304.dp)
                .height(72.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0XFFDDB130),
                )
            ) { Text("Get Start", style = TextStyle(
                color = Color(0XFF362A84),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
                fontSize = 28.sp
            )) }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnBoardingPreview() {
    OnBoarding()
}