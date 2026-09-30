package com.example.appmodoguardian.ui.screens
//Guía 9
// Selector: Decide que version de la pantalla mostrar según el ancho del dispositivo

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.example.appmodoguardian.ui.utils.obtenerWindowSizeClass

@Composable
fun HomeScreen2() {

    // Consulta el tamaño de la pantalla donde se está ejecutando la app
    val windowSizeClass = obtenerWindowSizeClass()

    // Muestra la versión que corresponde a ese ancho
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> HomeScreenCompacta()
        WindowWidthSizeClass.Medium -> HomeScreenMediana()
        WindowWidthSizeClass.Expanded -> HomeScreenExpandida()
        else -> HomeScreenCompacta()
    }
}
