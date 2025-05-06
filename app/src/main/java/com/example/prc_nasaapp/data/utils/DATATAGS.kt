package com.example.prc_nasaapp.data.utils

import com.example.prc_nasaapp.ConfigApp

object DATATAGS {

    /**Api key para utilizar la API de la NASA.*/
    val NASAAPIKEY = ConfigApp().getApiKey()

    /**Url base para acceso al APOD(Astronomy Picture of the Day)
     * @sample com.example.prc_nasaapp.data.utils.DATATAGS.NASA_BASE_URL*/
    const val NASA_BASE_URL = "https://api.nasa.gov/planetary/"

    /**Url base para acceso al APOD(Astronomy Picture of the Day)
     * @sample com.example.prc_nasaapp.data.utils.DATATAGS.NASA_BASE_URL*/
    const val NASA_MARS_PHOTOS_BASE_URL = "https://api.nasa.gov/"

}