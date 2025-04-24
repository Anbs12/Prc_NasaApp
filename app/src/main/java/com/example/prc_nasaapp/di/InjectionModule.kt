package com.example.prc_nasaapp.di

import com.example.prc_nasaapp.data.network.NasaApiService
import com.example.prc_nasaapp.data.repository.NasaRepository
import com.example.prc_nasaapp.data.utils.DATATAGS.APOD_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**Inyeccion de dependencia Hilt.*/
@Module
@InstallIn(SingletonComponent::class)
object InjectionModule {

    /**Instancia Singleton.
     *
     * Instancia de Retrofit y funciones de la NasaApiService*/
    @Provides
    @Singleton
    fun providedNasaApi(): NasaApiService {
        return Retrofit.Builder()
            .baseUrl(APOD_BASE_URL)
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
    fun providedRepository(api: NasaApiService): NasaRepository {
        return NasaRepository(api = api)
    }
}