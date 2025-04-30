package com.example.prc_nasaapp.di

import javax.inject.Qualifier

//Definimos calificadores personalizados para
// que hilt pueda distinguir que modulo otorga datos a
// que viewmodel y repository.

/**Calificador para definir modulos y usos de MarsApiPhotos*/
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HiltMarsPhotos

/**Calificador para definir modulos y usos de Apod.*/
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HiltApod
