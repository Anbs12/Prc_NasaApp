package com.example.prc_nasaapp.ui.screens.ApodScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.ui.components.ErrorScreen
import com.example.prc_nasaapp.ui.components.LoadingScreen

/**Pantalla con la Astronomy Picture of the Day*/
@Composable
fun ApodScreenMain(
    viewModel: ApodScreenViewModel = viewModel()
) {
    val uiState = viewModel.uiState
    when (uiState) {
        is ApodScreenUIState.Success -> {
            ApodCard(modifier = Modifier.fillMaxSize(), fetch = uiState.data)
        }

        is ApodScreenUIState.Loading -> {
            LoadingScreen(Modifier.fillMaxSize())
        }

        is ApodScreenUIState.Error -> {
            ErrorScreen(Modifier.fillMaxSize(), message = uiState.message)
        }
    }
}

@Composable
private fun ApodCard(
    modifier: Modifier = Modifier,
    fetch: Apod
) {
    Card(
        modifier = modifier
            .size(300.dp)
            .padding(8.dp),
        shape = CardDefaults.shape,
        elevation = CardDefaults.cardElevation()
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            //Titulo
            Text(
                modifier = Modifier.padding(8.dp),
                text = fetch.title, fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            //Imagen
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = CardDefaults.shape,
                elevation = CardDefaults.cardElevation()
            ) {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(fetch.hdurl)
                        .crossfade(true) // Efecto de transición al cargar
                        .build(),
                    loading = {
                        LoadingScreen(
                            Modifier
                                .fillMaxWidth()
                                .height(300.dp)
                        )
                    },
                    contentDescription = "Imagen del dia.",
                )
            }
            //Fecha
            Row(Modifier.padding(8.dp)) {
                Text("Fecha: ${fetch.date}")
            }
            Text(text = fetch.explanation)
        }
    }
}