package com.example.prc_nasaapp.data.network

import com.example.prc_nasaapp.data.model.Apod
import com.example.prc_nasaapp.data.utils.DATATAGS.NASAAPIKEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**Define las funciones ENDPOINTS de esta API
 * @sample com.example.prc_nasaapp.data.network.NasaApiService*/
interface NasaApiService {

    /**Devuelve la informacion de la foto del Astronomy Picture of the Day*/
    @GET("apod")
    suspend fun getAPODInfo(@Query("api_key") apikey: String = NASAAPIKEY): Response<Apod>

}