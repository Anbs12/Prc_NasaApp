package com.example.prc_nasaapp.di

import com.example.prc_nasaapp.data.network.NasaApiService
import com.example.prc_nasaapp.data.repository.NasaRepository
import com.example.prc_nasaapp.data.utils.DATATAGS.NASA_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**Inyeccion de dependencia Hilt para Nasa APOD.*/
@Module
@InstallIn(SingletonComponent::class)
object Hilt_NasaAPOD {

    /**Instancia Singleton.
     *
     * Instancia de Retrofit y funciones de la NasaApiService*/
    @Provides
    @Singleton
    @HiltApod
    fun providedNasaApi(): NasaApiService {
        return Retrofit.Builder()
            .baseUrl(NASA_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NasaApiService::class.java)
    }

    /**Instancia Singleton.
     *
     * Repositorio consume providedNasaApi() y utiliza funciones de clase NasaRepository.
     * Utilizado en MainScreenViewModel como arg de api*/
    @Provides
    @Singleton
    @HiltApod
    fun providedNasaRepository(@HiltApod api: NasaApiService): NasaRepository {
        return NasaRepository(api = api)
    }
}