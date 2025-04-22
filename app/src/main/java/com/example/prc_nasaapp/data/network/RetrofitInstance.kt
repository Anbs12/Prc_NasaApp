package com.example.prc_nasaapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/** Objeto singleton para configuracion retrofit. */
object RetrofitInstance {

    private val APOD_BASE_URL = "https://api.nasa.gov/planetary/"

    val retrofitBuilder: NasaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(APOD_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NasaApiService::class.java)
    }

}