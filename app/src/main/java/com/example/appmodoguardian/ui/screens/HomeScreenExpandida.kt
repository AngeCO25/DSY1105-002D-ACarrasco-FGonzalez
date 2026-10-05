package com.example.appmodoguardian.ui.screens
// Version de la pantalla para pantallas anchas
// Mientras se construye su diseno propio, reutiliza el compacto

import androidx.compose.runtime.Composable

@Composable
fun HomeScreenExpandida(onCerrarSesion: () -> Unit = {}) {
    HomeScreenCompacta(onCerrarSesion)
}