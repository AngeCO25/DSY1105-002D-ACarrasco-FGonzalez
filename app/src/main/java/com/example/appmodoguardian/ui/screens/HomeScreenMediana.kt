package com.example.appmodoguardian.ui.screens

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
fun HomeScreenMediana() {

    // Scaffold arma la estructura general de la pantalla
    Scaffold(
        topBar = {
            // Barra superior con el nombre de la app
            TopAppBar(title = { Text("Modo Guardian - Tablet") })
        }
    ) { innerPadding ->

        // Row distribuye en horizontal para aprovechar el ancho de la tablet
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Columna 1 (Izquierda): Imagen
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo de la aplicacion",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Fit
                )
            }

            // Columna 2 (Derecha): Texto y Botón
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

// Vista previa para tablets pequeñas / pantalla mediana (widthDp > 600)
@Preview(showBackground = true, widthDp = 700, heightDp = 500)
@Composable
fun HomeScreenMedianaPreview() {
    HomeScreenMediana()
}