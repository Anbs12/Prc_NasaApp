package com.example.prc_nasaapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** Objeto singleton para configuracion retrofit. */
object RetrofitInstance {

    /**Api key para utilizar la API de la NASA.*/
    val APIKEY = "yJPcDJNN6F62JFCeqdOU6mPc7wWpmAa9CEc6p8Gt"

    private const val APOD_BASE_URL = "https://api.nasa.gov/planetary/"

    val retrofitBuilder: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(APOD_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}