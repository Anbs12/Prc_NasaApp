package com.example.prc_nasaapp.ui.screens.MarsRoverPhotosScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prc_nasaapp.data.model.MarsRoverPhotos
import com.example.prc_nasaapp.data.repository.MarsPhotoRepository
import com.example.prc_nasaapp.di.HiltMarsPhotos
import com.example.prc_nasaapp.ui.utils.UITAGS.MarsRoverPhotosScreenVM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

sealed interface MarsRoverPhotosUIState {
    data class Success(val photos: MarsRoverPhotos) : MarsRoverPhotosUIState
    object Loading : MarsRoverPhotosUIState
    data class Error(val message: String = "") : MarsRoverPhotosUIState
}

@HiltViewModel
class MarsRoverPhotosScreenViewModel @Inject constructor(
    @HiltMarsPhotos private val repository: MarsPhotoRepository
) : ViewModel() {

    var uiState: MarsRoverPhotosUIState by mutableStateOf(MarsRoverPhotosUIState.Loading)

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
            try {
                val photos = repository.getMarsPhotos()
                if (photos.isSuccessful) {
                    uiState = MarsRoverPhotosUIState.Success(photos.body()!!)
                }
                delay(1000)
            } catch (e: Exception) {
                Log.e(MarsRoverPhotosScreenVM, e.message.toString())
                uiState = MarsRoverPhotosUIState.Error(e.message.toString())
            } catch (e: HttpException) {
                Log.e(MarsRoverPhotosScreenVM, e.message.toString())
                uiState = MarsRoverPhotosUIState.Error(e.message.toString())
            } catch (e: IOException) {
                Log.e(MarsRoverPhotosScreenVM, e.message.toString())
                uiState = MarsRoverPhotosUIState.Error(e.message.toString())
            }
        }
    }

}