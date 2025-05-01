package com.example.prc_nasaapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Mars Rover Photos: Image data gathered by NASA's Curiosity, Opportunity, and Spirit rovers on Mars
 * */
data class MarsRoverPhotos(
    @SerializedName(value = "latest_photos")
    val photos: List<Photo>
)

/**Imagen e informacion de la foto tomada por el Rover*/
data class Photo(
    val camera: Camera,
    val earth_date: String,
    val id: Int,
    val img_src: String,
    val rover: Rover,
    val sol: Int
)

/**Informacion sobre la camara*/
data class Camera(
    val full_name: String,
    val id: Int,
    val name: String,
    val rover_id: Int
)

/**Informacion del Rover*/
data class Rover(
    val id: Int,
    val landing_date: String,
    val launch_date: String,
    val name: String,
    val status: String
)