package com.example.appmodoguardian.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appmodoguardian.ui.theme.AppModoGuardianTheme
import com.example.appmodoguardian.ui.theme.AzulClaro
import com.example.appmodoguardian.ui.theme.RojoError
import com.example.appmodoguardian.ui.theme.SuperficieOscura
import com.example.appmodoguardian.ui.theme.TextoClaro
import com.example.appmodoguardian.ui.theme.TextoSecundario

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfiguracionScreen(
    onNavegarInicio: () -> Unit = {},
    onNavegarEventos: () -> Unit = {},
    onCerrarSesion: () -> Unit = {}
) {
    var notificacionesActivadas by remember { mutableStateOf(true) }
    var modoOscuroActivado by remember { mutableStateOf(true) }
    var alertasSonorasActivadas by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Configuración",
                        color = TextoClaro,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = SuperficieOscura
                )
            )
        },
        containerColor = SuperficieOscura
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Perfil de Usuario
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Perfil de Usuario",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoClaro
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Nombre: Ángela Castro", fontSize = 14.sp, color = TextoClaro)
                    Text(text = "Correo: angela.castro@modoguardian.cl", fontSize = 14.sp, color = TextoSecundario)
                    Text(text = "Perfil: Supervisor de Seguridad", fontSize = 14.sp, color = AzulClaro)
                }
            }

            // Preferencias
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Preferencias",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextoClaro
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Notificaciones Push", color = TextoClaro)
                        Switch(
                            checked = notificacionesActivadas,
                            onCheckedChange = { notificacionesActivadas = it }
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Modo Oscuro", color = TextoClaro)
                        Switch(
                            checked = modoOscuroActivado,
                            onCheckedChange = { modoOscuroActivado = it }
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Alertas Sonoras de Emergencia", color = TextoClaro)
                        Switch(
                            checked = alertasSonorasActivadas,
                            onCheckedChange = { alertasSonorasActivadas = it }
                        )
                    }
                }
            }

            // Accesos Rápidos
            Text(
                text = "Accesos Rápidos",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextoClaro
            )

            OutlinedButton(
                onClick = onNavegarInicio,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "🏠 Ir a Inicio", color = TextoClaro)
            }

            OutlinedButton(
                onClick = onNavegarEventos,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "📋 Ir a Eventos", color = TextoClaro)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de Cerrar Sesión
            Button(
                onClick = onCerrarSesion,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = RojoError)
            ) {
                Text(text = "🚪 Cerrar Sesión", color = TextoClaro, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConfiguracionScreenPreview() {
    AppModoGuardianTheme {
        ConfiguracionScreen()
    }
}