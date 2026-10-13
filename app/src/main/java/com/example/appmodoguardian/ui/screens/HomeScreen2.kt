package com.example.appmodoguardian.ui.screens

//Guía 9

// Selector: Decide que version de la pantalla mostrar según el ancho del dispositivo



import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

import androidx.compose.runtime.Composable

import com.example.appmodoguardian.ui.utils.obtenerWindowSizeClass



@Composable

fun HomeScreen2(

    nombre: String = "",

    rol: String = "",

    onCerrarSesion: () -> Unit = {},

    onIrAEventos: () -> Unit = {},

    onIrAConfiguracion: () -> Unit = {}

) {

    val windowSizeClass = obtenerWindowSizeClass()

    when (windowSizeClass.widthSizeClass) {

        WindowWidthSizeClass.Compact -> HomeScreenCompacta(

            nombre = nombre,

            rol = rol,

            onCerrarSesion = onCerrarSesion,

            onIrAEventos = onIrAEventos,

            onIrAConfiguracion = onIrAConfiguracion

        )

        WindowWidthSizeClass.Medium -> HomeScreenMediana(onCerrarSesion)

        WindowWidthSizeClass.Expanded -> HomeScreenExpandida(onCerrarSesion)

        else -> HomeScreenCompacta(

            nombre = nombre,

            rol = rol,

            onCerrarSesion = onCerrarSesion,

            onIrAEventos = onIrAEventos,

            onIrAConfiguracion = onIrAConfiguracion

        )

    }

}