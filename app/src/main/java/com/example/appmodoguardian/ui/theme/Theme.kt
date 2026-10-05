package com.example.appmodoguardian.ui.theme

// Tema de la aplicacion

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Colores que Material usa en toda la aplicacion
private val EsquemaOscuro = darkColorScheme(
    primary = AzulPrincipal,
    onPrimary = Color.White,
    secondary = AzulClaro,
    background = FondoOscuro,
    onBackground = TextoClaro,
    surface = SuperficieOscura,
    onSurface = TextoClaro,
    error = RojoError
)

@Composable
fun AppModoGuardianTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EsquemaOscuro,
        typography = Typography,
        content = content
    )
}