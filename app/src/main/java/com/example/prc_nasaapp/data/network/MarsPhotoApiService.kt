package com.example.prc_nasaapp.data.network

import com.example.prc_nasaapp.data.model.MarsRoverPhotos
import com.example.prc_nasaapp.data.utils.DATATAGS.NASAAPIKEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarsPhotoApiService {
//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY

    /**Devuelve la coleccion de imagenes del Rover Curiosity*/
    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getRoversPhotos(
        @Query("sol") sol: Int = 1000, // O Long, dependiendo de los valores posibles
        @Query("api_key") apiKey: String = NASAAPIKEY
    ): Response<MarsRoverPhotos>

}