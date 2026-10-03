package com.example.appmodoguardian.navigation

// Define los tipos de movimiento posibles dentro de la aplicacion

sealed class NavigationEvent {

    // Ir a una pantalla determinada
    data class NavigateTo(
        val route: Screen,
        val popUpToRoute: Screen? = null,  // elimina pantallas anteriores hasta esta
        val inclusive: Boolean = false,    // indica si tambien se elimina la pantalla indicada
        val singleTop: Boolean = false     // evita abrir dos veces la misma pantalla
    ) : NavigationEvent()

    // Volver a la pantalla anterior
    data object PopBackStack : NavigationEvent()

    // Subir un nivel en la jerarquia de la aplicación
    data object NavigateUp : NavigationEvent()
}

// Este archivo define los tipos de movimiento, no las pantallas.
// Una pantalla no navega por si sola: genera un evento de este tipo
// y MainActivity es quien lo ejecuta.