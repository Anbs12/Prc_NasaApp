package com.example.prc_nasaapp.ui.screens.mainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.ui.components.ErrorScreen
import com.example.prc_nasaapp.ui.components.LoadingScreen

@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel()
) {

    val uiState = viewModel.uiState

    when (uiState) {
        is MainScreenUIState.Success -> {
            ApodCard(modifier = Modifier.fillMaxSize(), fetch = uiState.data)
        }

        is MainScreenUIState.Loading -> {
            LoadingScreen(Modifier.fillMaxSize())
        }

        is MainScreenUIState.Error -> {
            ErrorScreen(Modifier.fillMaxSize())
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
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            //Titulo
            Text(
                modifier = Modifier.padding(8.dp),
                text = fetch.title, fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )
            // Imagen
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = CardDefaults.shape,
                elevation = CardDefaults.cardElevation()
            ) {
                AsyncImage(
                    model = fetch.hdurl,
                    contentDescription = fetch.service_version,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }
            Row(Modifier.padding(8.dp)) {
                Text("Fecha: ${fetch.date}")
            }
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Text(text = fetch.explanation)
            }
        }
    }
}

@Preview(widthDp = 400, heightDp = 400)
@Composable
fun ApodCardPreview(modifier: Modifier = Modifier) {
    ApodCard(
        modifier = TODO(),
        fetch = TODO()
    )
}