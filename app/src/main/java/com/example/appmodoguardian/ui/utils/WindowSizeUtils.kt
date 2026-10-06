package com.example.appmodoguardian.ui.utils

import android.app.Activity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun obtenerWindowSizeClass(): WindowSizeClass {
    // Toma la pantalla donde se esta ejecutando la app usando LocalContext
    val actividad = LocalContext.current as Activity

    // Devuelve si esa pantalla es compacta, mediana o expandida
    return calculateWindowSizeClass(activity = actividad)
}