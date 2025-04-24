package com.example.prc_nasaapp.ui.screens.selectionScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**Pantalla principal de seleccion de pantallas.*/
@Composable
fun SelectionScreenMain(
    modifier: Modifier = Modifier,
    onGoApodScreen: () -> Unit,
    onGoMarsRoverPhotosScreen: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ButtonSelection("Ver foto astronomica del dia") { onGoApodScreen() }
        ButtonSelection("Ver fotos del Mars Rover") { onGoMarsRoverPhotosScreen() }
    }
}

@Composable
private fun ButtonSelection(
    text: String = "",
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                onClick()
            }
            .padding(8.dp),
        shape = CardDefaults.shape,
        elevation = CardDefaults.cardElevation(8.dp),
        border = CardDefaults.outlinedCardBorder()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(modifier = Modifier.fillMaxWidth(0.9f), text = text, textAlign = TextAlign.Center)
            Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "")
        }
    }
}
