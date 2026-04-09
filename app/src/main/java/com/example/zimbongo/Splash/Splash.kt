package com.example.zimbongo.Splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zimbongo.ui.theme.BlurEffect
import kotlinx.coroutines.delay
import com.example.zimbongo.R


@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(key1 = true) {

        delay(timeMillis = 5000)
        navController.navigate(route = "home")

    }


    // Configuração da tela

    Column(
        modifier = Modifier.fillMaxSize().background(color = BlurEffect),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = null,
            modifier = Modifier.size(size=250.dp)
        )

        Text(
            text = "ZIMBONGO YETU",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = White
        )
    }

}