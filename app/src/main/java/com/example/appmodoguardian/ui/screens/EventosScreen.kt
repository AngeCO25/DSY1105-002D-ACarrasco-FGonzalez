package com.example.appmodoguardian.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Colores definidos localmente
private val AmarilloCol = Color(0xFFFFC107)
private val RojoErrorCol = Color(0xFFF44336)
private val AzulClaroCol = Color(0xFF03A9F4)
private val SuperficieOscuraCol = Color(0xFF1E1E2C)
private val TextoClaroCol = Color(0xFFFFFFFF)
private val TextoSecundarioCol = Color(0xFFA0A0B0)

data class EventoSimulado(
    val id: Int,
    val titulo: String,
    val dispositivo: String,
    val hora: String,
    val colorPrioridad: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventosScreen() {
    // Lista de 5 eventos simulados
    val listaEventos = remember {
        listOf(
            EventoSimulado(1, "Movimiento no autorizado", "Cámara 03 · Bodega norte", "14:32", RojoErrorCol),
            EventoSimulado(2, "Dispositivo sin conexión", "Sensor 07 · Acceso sur", "13:05", AmarilloCol),
            EventoSimulado(3, "Puerta de emergencia abierta", "Sensor 02 · Salida oeste", "11:45", RojoErrorCol),
            EventoSimulado(4, "Reinicio de sistema", "Panel central · Recepción", "09:12", AzulClaroCol),
            EventoSimulado(5, "Detección de humo leve", "Sensor 12 · Cocina", "08:30", AmarilloCol)
        )
    }

    // Estado para la sección activa (sección 1 = Eventos)
    var selectedIndex by remember { mutableIntStateOf(1) }

    val itemsMenu = listOf("Inicio", "Eventos", "Ajustes")
    val iconosMenu = listOf(Icons.Default.Home, Icons.Default.Notifications, Icons.Default.Settings)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Historial de Eventos") }
            )
        },
        bottomBar = {
            NavigationBar {
                itemsMenu.forEachIndexed { index, label ->
                    NavigationBarItem(
                        icon = { Icon(iconosMenu[index], contentDescription = label) },
                        label = { Text(label) },
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Eventos Registrados",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoClaroCol,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
            }

            items(listaEventos) { evento ->
                TarjetaEventoItem(evento = evento)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
private fun TarjetaEventoItem(evento: EventoSimulado) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = SuperficieOscuraCol)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(evento.colorPrioridad, CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = evento.titulo,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextoClaroCol
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = evento.dispositivo,
                    fontSize = 12.sp,
                    color = TextoSecundarioCol
                )
            }
            Text(
                text = evento.hora,
                fontSize = 11.sp,
                color = TextoSecundarioCol
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventosScreenPreview() {
    EventosScreen()
}