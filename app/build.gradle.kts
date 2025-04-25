import org.gradle.kotlin.dsl.support.kotlinCompilerOptions

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.0"
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.prc_nasaapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.prc_nasaapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //Dependencias tests instaladas manualmente.
    //Mockito
    testImplementation (libs.mockk)

    // Para usar ViewModel en Kotlin Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // Kotlin serialization
    implementation(libs.kotlinx.serialization.json)

    //Coroutines.
    implementation(libs.kotlinx.coroutines.android)

    //Para navegación entre pantallas con Jetpack Compose.
    implementation(libs.androidx.navigation.compose)
    //Para navegación con Hilt y viewModel
    implementation(libs.androidx.hilt.navigation.compose)

    //Retrofit.
    implementation(libs.retrofit)
    //Convertidor JSON Google
    implementation(libs.converter.gson)

    //Coil.
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)

    //Dagger Hilt 2
    implementation(libs.hilt.android.v2562)
    ksp(libs.hilt.android.compiler)
    testImplementation(kotlin("test"))


}