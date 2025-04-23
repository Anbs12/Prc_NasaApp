package com.example.prc_nasaapp.ui.screens.mainScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.data.network.NasaApiService
import com.example.prc_nasaapp.data.network.RetrofitInstance
import com.example.prc_nasaapp.ui.utils.UITAGS.MainScreenVM
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

/** Estados de la UI
 * @sample com.example.prc_nasaapp.ui.screens.mainScreen.MainScreenUIState*/
sealed interface MainScreenUIState {
    data class Success(val data: Apod) : MainScreenUIState
    object Loading : MainScreenUIState
    data class Error(val message: String) : MainScreenUIState
}

class MainScreenViewModel(
    private val api: NasaApiService
) : ViewModel() {

    var uiState: MainScreenUIState by mutableStateOf(MainScreenUIState.Loading)
    val retrofit = RetrofitInstance.retrofitBuilder

    init {
        getApod()
    }

    private fun getApod() {
        viewModelScope.launch {
            try {
                val data = retrofit.getAPODInfo()
                delay(400)
                uiState = MainScreenUIState.Success(data)
            } catch (e: Exception) {
                uiState = MainScreenUIState.Error(e.message.toString())
                Log.e(MainScreenVM, e.message.toString())
            } catch (e: HttpException) {
                uiState = MainScreenUIState.Error(e.message.toString())
                Log.e(MainScreenVM, e.message.toString())
            } catch (e: IOException) {
                uiState = MainScreenUIState.Error(e.message.toString())
                Log.e(MainScreenVM, e.message.toString())
            }
        }
    }

}