package com.example.appmodoguardian.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appmodoguardian.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    // Scaffold arma la estructura general de la pantalla
    Scaffold(
        topBar = {
            // Barra superior con el nombre de la app
            TopAppBar(title = { Text("Modo Guardian") })
        }
    ) { innerPadding ->

        // Column ordena los elementos uno debajo del otro
        Column(
            modifier = Modifier
                .padding(innerPadding)   // espacio para no quedar bajo la barra superior
                .fillMaxSize()           // ocupa toda la pantalla
                .padding(16.dp),         // margen interno
            verticalArrangement = Arrangement.spacedBy(20.dp)  // separacion entre elementos
        ) {

            Text(text = "Bienvenido")

            Button(onClick = { }) {
                Text("Ingresar")
            }

            Image(
                //Que imagen mostrar, al tener logo propio cambiar imagen
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Logo de la aplicacion",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

// Permite ver la pantalla sin ejecutar la app
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}