package com.example.prc_nasaapp

import com.example.prc_nasaapp.data.network.MarsPhotoApiService
import com.example.prc_nasaapp.data.network.NasaApiService
import com.example.prc_nasaapp.data.utils.DATATAGS.NASA_BASE_URL
import io.mockk.coEvery
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**Testeo de Apis en llamadas reales.*/
class NasaRepositoryTest {

    private lateinit var nasaApiService: NasaApiService
    private lateinit var marsApiService: MarsPhotoApiService

    @Before
    fun setup() {
        //Configura cliente OkHttp con timeout adecuado para tests
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        //Configura retrofit con la URL real
        val retrofit = Retrofit.Builder()
            .baseUrl(NASA_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        nasaApiService = retrofit.create(NasaApiService::class.java)
        marsApiService = retrofit.create(MarsPhotoApiService::class.java)
    }

    @Test
    fun `deberia obtener una respuesta de las fotos del APOD `() = runBlocking {
        val dataResponse = nasaApiService.getAPODInfo()
        val statusCodesOK = 200

        //assertTrue(dataResponse.isSuccessful, "Funciona")
        assertEquals(statusCodesOK, dataResponse.code())
    }

    @Test
    fun `deberia obtener una respuesta de las fotos del ROVERS MARTE `() = runBlocking {
        val dataResponse = marsApiService.getRoversPhotos()
        val statusCodesOK = 200

        //assertTrue(dataResponse.isSuccessful, "Funciona")
        assertEquals(statusCodesOK, dataResponse.code())
    }
}