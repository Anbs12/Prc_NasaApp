package com.example.prc_nasaapp

class ConfigApp {

    // Declara que esta función será implementada en código nativo (en el .cpp)
    external fun getApiKey(): String

    companion object {
        // Carga la biblioteca nativa que contiene la implementación de la función C++.

        init {
            try {
                System.loadLibrary("prc_nasaapp") // Usa el nombre base de tu biblioteca nativa
                println("Biblioteca nativa 'prc_nasaapp' cargada con éxito.")
            } catch (e: UnsatisfiedLinkError) {
                System.err.println("Error al cargar la biblioteca nativa: " + e.message)
            }
        }
    }
}