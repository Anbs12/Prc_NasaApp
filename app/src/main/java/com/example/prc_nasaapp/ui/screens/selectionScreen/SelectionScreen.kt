package com.example.prc_nasaapp.ui.screens.selectionScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prc_nasaapp.R

/**Pantalla principal de seleccion de pantallas.*/
@Composable
fun SelectionScreenMain(
    modifier: Modifier = Modifier,
    onGoApodScreen: () -> Unit,
    onGoMarsRoverPhotosScreen: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.nebulosa_astronaut_wallpaper),
            contentDescription = "foto wallpaper.",
            modifier = Modifier.fillMaxWidth(),
            alignment = Alignment.Center
        )
        Text(modifier = Modifier.padding(16.dp), text = "Explora el Cosmos...", fontSize = 24.sp)
        ButtonSelection(
            text = "Ver foto astronomica del dia",
            onClick = { onGoApodScreen() },
            cardColors = MaterialTheme.colorScheme.primary,
        )
        ButtonSelection(
            text = "Ver fotos del Mars Rover",
            onClick = { onGoMarsRoverPhotosScreen() },
            cardColors = MaterialTheme.colorScheme.secondary,
        )
    }
}

/**Botones de seleccion de pantallas.
 * @param text Texto del boton.
 * @param onClick Accion al hacer click.
 * @param cardColors Color de fondo del boton.*/
@Composable
private fun ButtonSelection(
    text: String = "",
    onClick: () -> Unit,
    cardColors: Color,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clickable {
                onClick()
            }
            .padding(8.dp),
        shape = CardDefaults.shape,
        elevation = CardDefaults.cardElevation(8.dp),
        border = CardDefaults.outlinedCardBorder(),
        colors = CardDefaults.cardColors(
            containerColor = cardColors
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = text,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}