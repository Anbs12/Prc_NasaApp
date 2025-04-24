package com.example.prc_nasaapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/**Pantalla de comienzo al recien abrir la aplicacion. */
@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    /**Version actual de API/Android del dispositivo. */
    private val actualAndroidVersion = Build.VERSION.SDK_INT

    /**Android 12 - API 31*/
    private val apiLvl12 = Build.VERSION_CODES.S

    /**Duracion de la pantalla antes que pase al MainActivity*/
    private val duration: Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (actualAndroidVersion < apiLvl12) {
            setContent {
                SplashScreen(modifier = Modifier.fillMaxSize())
                LaunchedEffect(Unit) {
                    delay(duration)
                    goMainActivity()
                }
            }
        } else {
            goMainActivity()
        }
    }

    private fun goMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    @Composable
    private fun SplashScreen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(300.dp)
                    .shadow(elevation = 8.dp, shape = CircleShape),
                painter = painterResource(R.drawable.rocket_icon_splashscreen),
                contentDescription = "splash screen.",
                contentScale = ContentScale.Fit
            )
            Text(text = "Nasa App", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }

}