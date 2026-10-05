package com.example.appmodoguardian.ui.screens
// Version de la pantalla para teléfonos

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmodoguardian.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCompacta(onCerrarSesion: () -> Unit = {}) {
    Scaffold(
        topBar = {
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

        // En pantallas angostas los elementos van uno debajo del otro
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            Text(
                text = "Bienvenido",
                style = MaterialTheme.typography.titleLarge
            )

            Button(onClick = { }) {
                Text("Ingresar")
            }

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de la aplicacion",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(name = "Compacta", widthDp = 360, heightDp = 800, showBackground = true)
@Composable
fun HomeScreenCompactaPreview() {
    HomeScreenCompacta()
}