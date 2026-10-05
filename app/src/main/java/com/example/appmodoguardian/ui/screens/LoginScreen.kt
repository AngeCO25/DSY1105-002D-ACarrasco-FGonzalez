package com.example.appmodoguardian.ui.screens
// Pantalla de inicio de sesión

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appmodoguardian.R
import com.example.appmodoguardian.ui.theme.AppModoGuardianTheme
import com.example.appmodoguardian.ui.theme.AzulPrincipal
import com.example.appmodoguardian.ui.theme.FondoOscuro
import com.example.appmodoguardian.ui.theme.RojoError
import com.example.appmodoguardian.ui.theme.TextoClaro
import com.example.appmodoguardian.ui.theme.TextoSecundario

@Composable
fun LoginScreen(onIngresar: () -> Unit = {}) {
    // Guardan lo que el usuario escribe en cada campo
    var correo by remember { mutableStateOf("") }
    var clave by remember { mutableStateOf("") }
    // Mensaje que aparece cuando los datos no son correctos
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoOscuro)
            .verticalScroll(rememberScrollState())
            .widthIn(max = 420.dp)
            .padding(horizontal = 28.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de Modo Guardian",
            modifier = Modifier.size(110.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Modo Guardián",
            fontSize = 26.sp,
            fontWeight = FontWeight.ExtraBold,
            color = TextoClaro
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = "Monitoreo de eventos y alertas",
            fontSize = 13.sp,
            color = TextoSecundario
        )

        Spacer(modifier = Modifier.height(44.dp))

        Text(
            text = "Correo",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextoClaro,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(7.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Contraseña",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextoClaro,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(7.dp))

        OutlinedTextField(
            value = clave,
            onValueChange = { clave = it },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            // Oculta la contrasena mostrando puntos
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        if (error.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = error,
                fontSize = 13.sp,
                color = RojoError,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = {
                // Usuario de prueba definido en el codigo
                if (correo == "supervisor@empresa.cl" && clave == "12345678") {
                    error = ""
                    onIngresar()
                } else {
                    error = "Correo o contraseña incorrectos"
                }
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = AzulPrincipal),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text(
                text = "Ingresar",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "¿Problemas para acceder?\nContacta al administrador del sistema.",
            fontSize = 12.sp,
            color = TextoSecundario,
            lineHeight = 18.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Modo Guardián - versión 1.0",
            fontSize = 11.sp,
            color = TextoSecundario
        )
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun LoginScreenPreview() {
    AppModoGuardianTheme {
        LoginScreen()
    }
}