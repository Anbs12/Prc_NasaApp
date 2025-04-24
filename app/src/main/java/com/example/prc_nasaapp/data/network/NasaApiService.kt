package com.example.prc_nasaapp.data.network

import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.data.model.MarsRoverPhotos
import com.example.prc_nasaapp.data.utils.DATATAGS.NASAAPIKEY
import retrofit2.http.GET
import retrofit2.http.Query

/**Define las funciones ENDPOINTS de esta API
 * @sample com.example.prc_nasaapp.data.network.NasaApiService*/
interface NasaApiService {

    /**Devuelve la informacion de la foto del Astronomy Picture of the Day*/
    @GET("apod")
    suspend fun getAPODInfo(@Query("api_key") apikey: String = NASAAPIKEY): Apod

    /**Devuelve la coleccion de imagenes del Rover Curiosity*/
    @GET("mars-photos/api/v1/rovers/curiosity/latest_photos")
    suspend fun getRoversPhotos(@Query("api_key") apikey: String = NASAAPIKEY): MarsRoverPhotos

    //TODO Continuar y terminar marsphoto y reparar api que parece que tiene errores.

}