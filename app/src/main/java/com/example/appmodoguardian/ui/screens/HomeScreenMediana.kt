package com.example.appmodoguardian.ui.screens
// Versión de la pantalla para tablets pequeñas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmodoguardian.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenMediana(onCerrarSesion: () -> Unit = {}) {

    // Scaffold arma la estructura general de la pantalla
    Scaffold(
        topBar = {
            // Barra superior con el nombre de la app
            TopAppBar(
                title = { Text("Modo Guardián") },
                actions = {
                    // Vuelve a la pantalla de inicio de sesion
                    TextButton(onClick = onCerrarSesion) {
                        Text("Cerrar sesión")
                    }
                }
            )
        }
    ) { innerPadding ->

        // Row distribuye en horizontal para aprovechar el ancho de la tablet
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(28.dp),
            horizontalArrangement = Arrangement.spacedBy(28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Columna izquierda: imagen
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo de la aplicacion",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Fit
                )
            }

            // Columna derecha: texto y boton
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(text = "Bienvenido")

                Button(onClick = { }) {
                    Text("Ingresar")
                }
            }
        }
    }
}

// Vista previa para tablets pequenas, pantalla mediana
@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun HomeScreenMedianaPreview() {
    HomeScreenMediana()
}