package com.example.appmodoguardian.ui.screens
// Pantalla con la lista de eventos y alertas - guia 10


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EventosScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Pantalla de eventos")
    }
}

@Preview(showBackground = true)
@Composable
fun EventosScreenPreview() {
    EventosScreen()
}

// Este archivo solo define los nombres de las rutas.
// Cada pantalla se identifica por su texto, por ejemplo "inicio" o "eventos".
// MainActivity usa estos nombres para saber que pantalla mostrar.