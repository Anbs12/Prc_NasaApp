package com.example.prc_nasaapp.data.repository

import com.example.prc_nasaapp.data.model.MarsRoverPhotos
import com.example.prc_nasaapp.data.network.MarsPhotoApiService
import retrofit2.Response

class MarsPhotoRepository(
    private val api: MarsPhotoApiService
) {

    /**Devuelve la informacion de fotos de rovers Mars desde la API*/
    suspend fun getMarsPhotos(): Response<MarsRoverPhotos> {
        return getApodInfoRemote()
    }

    private suspend fun getApodInfoRemote(): Response<MarsRoverPhotos> {
        return api.getRoversPhotos()
    }

}