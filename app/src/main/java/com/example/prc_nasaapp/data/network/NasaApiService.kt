package com.example.prc_nasaapp.data.network

import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.data.utils.DATATAGS.APIKEY
import retrofit2.http.GET
import retrofit2.http.Query

/**Define los ENDPOINTS de la API*/
interface NasaApiService {


    /**Devuelve la informacion de la foto del Astronomy Picture of the Day*/
    @GET("apod")
    suspend fun getAPODInfo(@Query ("api_key") apikey: String = APIKEY): Apod

}