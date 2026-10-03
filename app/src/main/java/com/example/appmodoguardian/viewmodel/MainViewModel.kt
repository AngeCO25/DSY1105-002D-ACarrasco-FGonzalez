package com.example.appmodoguardian.viewmodel
// Centraliza la navegación de la aplicación

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appmodoguardian.navigation.NavigationEvent
import com.example.appmodoguardian.navigation.Screen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // Canal interno donde se guardan los eventos de navegación
    private val _navigationEvents = MutableSharedFlow<NavigationEvent>()

    // Version de solo lectura que observa MainActivity
    val navigationEvents: SharedFlow<NavigationEvent> = _navigationEvents.asSharedFlow()

    // Ir a una pantalla determinada
    fun navigateTo(screen: Screen) {
        viewModelScope.launch {
            _navigationEvents.emit(NavigationEvent.NavigateTo(route = screen))
        }
    }

    // Volver a la pantalla anterior
    fun navigateBack() {
        viewModelScope.launch {
            _navigationEvents.emit(NavigationEvent.PopBackStack)
        }
    }

    // Subir un nivel
    fun navigateUp() {
        viewModelScope.launch {
            _navigationEvents.emit(NavigationEvent.NavigateUp)
        }
    }
}

// Este archivo es el intermediario de la navegación.
// Las pantallas llaman a navigateTo, navigateBack o navigateUp.
// El ViewModel emite el evento correspondiente y MainActivity lo escucha.
// Asi la logica de navegacion queda en un solo lugar y no repartida por las pantallas.