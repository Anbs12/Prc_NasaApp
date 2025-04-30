package com.example.prc_nasaapp.ui.screens.MarsRoverPhotosScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.prc_nasaapp.data.model.Camera
import com.example.prc_nasaapp.data.model.MarsRoverPhotos
import com.example.prc_nasaapp.data.model.Photo
import com.example.prc_nasaapp.data.model.Rover
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

    when (uiState) {
        is MarsRoverPhotosUIState.Success -> {
            Lista(modifier = fillmaxSize, data = uiState.photos)
        }

        is MarsRoverPhotosUIState.Loading -> {
            LoadingScreen(fillmaxSize)
        }

        is MarsRoverPhotosUIState.Error -> {
            ErrorScreen(modifier = fillmaxSize, message = uiState.message)
        }
    }
}

@Composable
fun Lista(modifier: Modifier = Modifier, data: MarsRoverPhotos) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(data.photos) { fotos ->
            PhotoCard(photo = fotos)
        }
    }
}

@Composable
fun PhotoCard(
    photo: Photo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photo.img_src)
                    .crossfade(true) // Efecto de transición al cargar
                    .build(),
                loading = {
                    LoadingScreen(
                        Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                },
                contentDescription = "Foto tomada por ${photo.rover.name} - Cámara ${photo.camera.name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Rover: ${photo.rover.name} (${photo.rover.status.capitalize()})",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Cámara: ${photo.camera.full_name} (${photo.camera.name})",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "Fecha en Tierra: ${photo.earth_date}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = "Sol (día marciano): ${photo.sol}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 2.dp)
            )
            Text(
                text = "ID de Foto: ${photo.id}",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

@Composable
fun CameraInfo(
    camera: Camera,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Cámara: ${camera.full_name}", style = MaterialTheme.typography.titleSmall)
        Text(text = "Abreviatura: ${camera.name}", style = MaterialTheme.typography.bodySmall)
        Text(text = "ID: ${camera.id}", style = MaterialTheme.typography.bodySmall)
        Text(text = "Rover ID: ${camera.rover_id}", style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun RoverInfo(
    rover: Rover,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(8.dp)) {
        Text(text = "Rover: ${rover.name}", style = MaterialTheme.typography.titleSmall)
        Text(
            text = "Estado: ${rover.status.capitalize()}",
            style = MaterialTheme.typography.bodySmall
        )
        Text(text = "Lanzamiento: ${rover.launch_date}", style = MaterialTheme.typography.bodySmall)
        Text(text = "Aterrizaje: ${rover.landing_date}", style = MaterialTheme.typography.bodySmall)
        Text(text = "ID: ${rover.id}", style = MaterialTheme.typography.bodySmall)
    }
}