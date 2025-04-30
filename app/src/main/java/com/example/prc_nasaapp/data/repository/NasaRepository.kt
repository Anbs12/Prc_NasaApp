package com.example.prc_nasaapp.data.repository

import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.data.network.NasaApiService
import retrofit2.Response

/** Repositorio para objetos e informacion de la NASA.
 * @param api Recibe la API que se utiliza para este repositorio*/
class NasaRepository(
    private val api: NasaApiService
) {

    /**Devuelve la informacion de la foto del Astronomy Picture of the Day desde la API*/
    suspend fun getApodInfo(): Response<Apod> {
        return getApodInfoRemote()
    }

    private suspend fun getApodInfoRemote(): Response<Apod> {
        return api.getAPODInfo()
    }

}