package com.example.appmodoguardian.ui.screens
// Versión de la pantalla de inicio para teléfonos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// Definición local de colores de fallback para evitar problemas de paquete
private val AmarilloCol = Color(0xFFFFC107)
private val AzulClaroCol = Color(0xFF03A9F4)
private val RojoErrorCol = Color(0xFFF44336)
private val SuperficieOscuraCol = Color(0xFF1E1E2C)
private val TextoClaroCol = Color(0xFFFFFFFF)
private val TextoSecundarioCol = Color(0xFFA0A0B0)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCompacta(onCerrarSesion: () -> Unit = {}) {

    // Estados para el Drawer y la corrutina para abrir/cerrar
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = "Menú Principal",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                NavigationDrawerItem(
                    label = { Text("Inicio") },
                    selected = true,
                    icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    label = { Text("Eventos") },
                    selected = false,
                    icon = { Icon(Icons.Default.Notifications, contentDescription = "Eventos") },
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    label = { Text("Configuración") },
                    selected = false,
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Configuración") },
                    onClick = {
                        scope.launch { drawerState.close() }
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Modo Guardián") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Abrir Menú")
                        }
                    },
                    actions = {
                        TextButton(onClick = onCerrarSesion) {
                            Text("Cerrar sesión")
                        }
                    }
                )
            }
        ) { innerPadding ->

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(20.dp)
            ) {

                Text(
                    text = "Hola, Ángela",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextoClaroCol
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(AzulClaroCol, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Perfil Supervisor",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AzulClaroCol
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = SuperficieOscuraCol)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(AmarilloCol, CircleShape)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Alertas pendientes",
                                fontSize = 13.sp,
                                color = TextoSecundarioCol
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "4",
                            fontSize = 34.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = AmarilloCol
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    TarjetaResumen(
                        titulo = "Eventos hoy",
                        valor = "12",
                        modifier = Modifier.weight(1f)
                    )
                    TarjetaResumen(
                        titulo = "Dispositivos",
                        valor = "8/9",
                        modifier = Modifier.weight(1f)
                    )
                }

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Eventos recientes",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextoClaroCol
                )

                Spacer(modifier = Modifier.height(12.dp))

                FilaEvento(
                    titulo = "Movimiento no autorizado",
                    detalle = "Cámara 03 · Bodega norte",
                    hora = "14:32",
                    colorPrioridad = RojoErrorCol
                )

                Spacer(modifier = Modifier.height(10.dp))

                FilaEvento(
                    titulo = "Dispositivo sin conexión",
                    detalle = "Sensor 07 · Acceso sur",
                    hora = "13:05",
                    colorPrioridad = AmarilloCol
                )
            }
        }
    }
}

@Composable
private fun TarjetaResumen(
    titulo: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = SuperficieOscuraCol)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = titulo,
                fontSize = 12.sp,
                color = TextoSecundarioCol
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = valor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextoClaroCol
            )
        }
    }
}

@Composable
private fun FilaEvento(
    titulo: String,
    detalle: String,
    hora: String,
    colorPrioridad: Color
) {
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
                    .background(colorPrioridad, CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = titulo,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = TextoClaroCol
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = detalle,
                    fontSize = 12.sp,
                    color = TextoSecundarioCol
                )
            }
            Text(
                text = hora,
                fontSize = 11.sp,
                color = TextoSecundarioCol
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun HomeScreenCompactaPreview() {
    HomeScreenCompacta()
}