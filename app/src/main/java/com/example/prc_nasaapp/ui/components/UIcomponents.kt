package com.example.prc_nasaapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.util.Locale

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

/**Muestra una pantalla de error.
 * @param message Mensaje de error a mostrar al usuario.*/
@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    message: String = ""
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Error: $message")
    }
}

/**Convierte la primera letra de una palabra en mayuscula.
 *
 * Utiliza "replaceFirstChar" para convertir primera letra en mayuscula en esta
 * funcion de extension.*/
fun String.capitalizeFirstCharacterString() = replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
}