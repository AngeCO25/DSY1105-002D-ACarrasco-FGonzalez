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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appmodoguardian.ui.theme.Amarillo
import com.example.appmodoguardian.ui.theme.AppModoGuardianTheme
import com.example.appmodoguardian.ui.theme.AzulClaro
import com.example.appmodoguardian.ui.theme.RojoError
import com.example.appmodoguardian.ui.theme.SuperficieOscura
import com.example.appmodoguardian.ui.theme.TextoClaro
import com.example.appmodoguardian.ui.theme.TextoSecundario

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCompacta(
    nombre: String = "",
    rol: String = "",
    onCerrarSesion: () -> Unit = {}
) {

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

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {

            // Saludo con el nombre de quien inicio sesion
            Text(
                text = "Hola, $nombre",
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextoClaro
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Etiqueta con el perfil del usuario
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(AzulClaro, CircleShape)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Perfil $rol",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AzulClaro
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            // Indicador destacado de alertas sin atender
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = SuperficieOscura)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(Amarillo, CircleShape)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Alertas pendientes",
                            fontSize = 13.sp,
                            color = TextoSecundario
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "4",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Amarillo
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
                color = TextoClaro
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilaEvento(
                titulo = "Movimiento no autorizado",
                detalle = "Cámara 03 · Bodega norte",
                hora = "14:32",
                colorPrioridad = RojoError
            )

            Spacer(modifier = Modifier.height(10.dp))

            FilaEvento(
                titulo = "Dispositivo sin conexión",
                detalle = "Sensor 07 · Acceso sur",
                hora = "13:05",
                colorPrioridad = Amarillo
            )
        }
    }
}

// Tarjeta pequena con un indicador del resumen
@Composable
private fun TarjetaResumen(
    titulo: String,
    valor: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = SuperficieOscura)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = titulo,
                fontSize = 12.sp,
                color = TextoSecundario
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = valor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextoClaro
            )
        }
    }
}

// Fila que muestra un evento reciente
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
        colors = CardDefaults.cardColors(containerColor = SuperficieOscura)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // El color del punto indica la prioridad del evento
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
                    color = TextoClaro
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = detalle,
                    fontSize = 12.sp,
                    color = TextoSecundario
                )
            }
            Text(
                text = hora,
                fontSize = 11.sp,
                color = TextoSecundario
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun HomeScreenCompactaPreview() {
    AppModoGuardianTheme {
        HomeScreenCompacta(nombre = "Ángela Carrasco", rol = "Supervisor")
    }
}