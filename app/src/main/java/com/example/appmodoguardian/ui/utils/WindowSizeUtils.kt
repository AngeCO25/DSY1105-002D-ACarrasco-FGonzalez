// Detecta el tamaño de la pantalla del dispositivo para mostrar la version adecuada de la interfaz
package com.example.appmodoguardian.ui.utils

import android.app.Activity
import androidx.activity.compose.LocalActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun obtenerWindowSizeClass(): WindowSizeClass {

    // Toma la pantalla donde se esta ejecutando la app
    val actividad = LocalActivity.current as Activity

    // Devuelve si esa pantalla es compacta, mediana o expandida
    return calculateWindowSizeClass(actividad)
}