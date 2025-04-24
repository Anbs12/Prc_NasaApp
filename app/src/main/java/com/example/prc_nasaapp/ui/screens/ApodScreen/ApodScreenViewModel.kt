package com.example.prc_nasaapp.ui.screens.ApodScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.data.repository.NasaRepository
import com.example.prc_nasaapp.ui.utils.UITAGS.ApodScreenVM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/** Estados de la UI
 * @sample com.example.prc_nasaapp.ui.screens.ApodScreen.ApodScreenUIState*/
sealed interface ApodScreenUIState {
    data class Success(val data: Apod) : ApodScreenUIState
    object Loading : ApodScreenUIState
    data class Error(val message: String) : ApodScreenUIState
}

/**ViewModel de ApodScreen.
 * @param repository Obtiene metodos del repositorio dado.
 * @since Nota: Para que funcione con navigation compose, instalar dependencias hilt-navigation,
 * si no causara error de instancia de los VM cada vez que se dirige a la pantalla seleccionada.
 * */
@HiltViewModel
class ApodScreenViewModel @Inject constructor(
    private val repository: NasaRepository
) : ViewModel() {

    /**Gestiona el estado de la UI.*/
    var uiState: ApodScreenUIState by mutableStateOf(ApodScreenUIState.Loading)

    init {
        getApod()
    }

    private fun getApod() {
        viewModelScope.launch {
            try {
                val data = repository.getApodInfo()
                delay(400)
                uiState = ApodScreenUIState.Success(data)
            } catch (e: Exception) {
                uiState = ApodScreenUIState.Error(e.message.toString())
                Log.e(ApodScreenVM, e.message.toString())
            } catch (e: HttpException) {
                uiState = ApodScreenUIState.Error(e.message.toString())
                Log.e(ApodScreenVM, e.message.toString())
            } catch (e: IOException) {
                uiState = ApodScreenUIState.Error(e.message.toString())
                Log.e(ApodScreenVM, e.message.toString())
            }
        }
    }

}