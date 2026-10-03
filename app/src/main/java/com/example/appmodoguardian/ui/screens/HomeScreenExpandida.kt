package com.example.appmodoguardian.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
fun HomeScreenExpandida() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Modo Guardian - Tablet Grande") }
            )
        }
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Zona 1 / Costado Izquierdo: Imagen Grande
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Logo App",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp),
                    contentScale = ContentScale.Fit
                )
            }

            // Zona 2 / Costado Derecho: Texto y Botón
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¡Bienvenido!",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Vista optimizada para pantalla expandida / tablet grande.",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = { /* acción futura */ }) {
                    Text(text = "Presioname")
                }
            }
        }
    }
}

// Preview para pantalla Expandida (widthDp > 840)
@Preview(name = "Expanded", widthDp = 900, heightDp = 600, showBackground = true)
@Composable
fun HomeScreenExpandidaPreview() {
    HomeScreenExpandida()
}