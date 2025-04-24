package com.example.prc_nasaapp.data.repository

import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.data.model.MarsRoverPhotos
import com.example.prc_nasaapp.data.network.NasaApiService

/** Repositorio para objetos e informacion de la NASA.
 * @param api Recibe la API que se utiliza para este repositorio*/
class NasaRepository(
    private val api: NasaApiService
) {

    /**Devuelve la informacion de la foto del Astronomy Picture of the Day desde la API*/
    suspend fun getApodInfo(): Apod {
        return getApodInfoRemote()
    }

    suspend fun getMarsRoverPhotos(): MarsRoverPhotos {
        return getMarsRoverPhotosRemote()
    }

    private suspend fun getApodInfoRemote(): Apod {
        return api.getAPODInfo()
    }

    private suspend fun getMarsRoverPhotosRemote(): MarsRoverPhotos {
        return api.getRoversPhotos()
    }

}