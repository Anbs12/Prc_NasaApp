package com.example.prc_nasaapp.data.model

/**Clase de datos para la obtencion de datos de la API
 *
 * Datos que representan al APOD. ¿Que significa APOD? Astronomy Picture of the Day
 * @param date fecha actual
 * @param explanation Explicacion de la imagen
 * @param hdurl Url de imagen en HD
 * @param media_type Tipo de medios
 * @param service_version version del servicio
 * @param title Titulo de la foto
 * @param url Url de imagen con algo menos de calidad.*/
data class Apod(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)