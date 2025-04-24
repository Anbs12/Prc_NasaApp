package com.example.prc_nasaapp.ui.screens.MarsRoverPhotosScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.prc_nasaapp.ui.components.ErrorScreen
import com.example.prc_nasaapp.ui.components.LoadingScreen

/**Pantalla con lista de fotografias de Marte de los distintos Rovers.*/
@Composable
fun MarsRoverPhotosScreen(
    modifier: Modifier = Modifier,
    viewModel: MarsRoverPhotosScreenViewModel = viewModel()
) {
    val fillmaxSize = Modifier.fillMaxSize()
    val uiState = viewModel.uiState

    when(uiState){
        is MarsRoverPhotosUIState.Success -> {

        }
        is MarsRoverPhotosUIState.Loading -> {
            LoadingScreen(fillmaxSize)
        }
        is MarsRoverPhotosUIState.Error -> {
            ErrorScreen(modifier = fillmaxSize, message = uiState.message)
        }
    }
}