package com.example.appmodoguardian.ui.screens

// Version de la pantalla para tablet en tamano mediano
// Mientras se construye su diseno propio, reutiliza el compacto

import androidx.compose.runtime.Composable

@Composable
fun HomeScreenMediana(onCerrarSesion: () -> Unit = {}) {
    HomeScreenCompacta(onCerrarSesion)
}