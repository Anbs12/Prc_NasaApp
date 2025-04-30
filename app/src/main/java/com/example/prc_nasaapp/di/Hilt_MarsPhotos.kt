package com.example.prc_nasaapp.di

import com.example.prc_nasaapp.data.network.MarsPhotoApiService
import com.example.prc_nasaapp.data.repository.MarsPhotoRepository
import com.example.prc_nasaapp.data.utils.DATATAGS.NASA_MARS_PHOTOS_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**Inyeccion de dependencia Hilt para MarsPhotos.*/
@Module
@InstallIn(SingletonComponent::class)
object Hilt_MarsPhotos {

    @Provides
    @Singleton
    @HiltMarsPhotos
    fun providedMarsAPi(): MarsPhotoApiService {
        return Retrofit.Builder()
            .baseUrl(NASA_MARS_PHOTOS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarsPhotoApiService::class.java)
    }

    @Provides
    @Singleton
    @HiltMarsPhotos
    fun providedMarsRepository(@HiltMarsPhotos api: MarsPhotoApiService): MarsPhotoRepository {
        return MarsPhotoRepository(api = api)
    }

}