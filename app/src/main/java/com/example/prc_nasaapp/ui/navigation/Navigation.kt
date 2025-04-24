package com.example.prc_nasaapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prc_nasaapp.ui.screens.ApodScreen.ApodScreenMain
import com.example.prc_nasaapp.ui.screens.ApodScreen.ApodScreenViewModel
import com.example.prc_nasaapp.ui.screens.MarsRoverPhotosScreen.MarsRoverPhotosScreen
import com.example.prc_nasaapp.ui.screens.MarsRoverPhotosScreen.MarsRoverPhotosScreenViewModel
import com.example.prc_nasaapp.ui.screens.selectionScreen.SelectionScreenMain

@Composable
fun MainNavigationApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SelectionScreen.name,
        modifier = modifier
    ) {
        composable(route = Routes.SelectionScreen.name) {
            SelectionScreenMain(
                modifier = Modifier.fillMaxSize(),
                onGoApodScreen = { navController.navigate(route = Routes.AstronomyPictureoftheDay.name) },
                onGoMarsRoverPhotosScreen = { navController.navigate(route = Routes.MarsRoverPhotos.name) }
            )
        }
        composable(route = Routes.AstronomyPictureoftheDay.name) {
            //Crea una instancia del viewModel con inyeccion de Dagger Hilt(Obligatorio siempre para VM con Hilt).
            val hiltViewModel = hiltViewModel<ApodScreenViewModel>()
            ApodScreenMain(viewModel = hiltViewModel)
        }
        composable(route = Routes.MarsRoverPhotos.name) {
            val hiltViewModel = hiltViewModel<MarsRoverPhotosScreenViewModel>()
            MarsRoverPhotosScreen(Modifier.fillMaxSize(), viewModel = hiltViewModel)
        }
    }
}