package com.example.appmodoguardian.navigation
// Define las rutas de la aplicación
// Cada pantalla tiene un nombre con el que se la identifica al navegar

sealed class Screen(val route: String) {

    // Pantalla de inicio
    data object Inicio : Screen(route = "inicio")

    // Pantalla con la lista de eventos
    data object Eventos : Screen(route = "eventos")

    // Pantalla de configuración
    data object Configuracion : Screen(route = "configuracion")
}

// Este archivo solo define los nombres de las rutas.
// Cada pantalla se identifica por su texto, por ejemplo "inicio" o "eventos".
// MainActivity usa estos nombres para saber que pantalla mostrar.