package com.example.appmodoguardian.ui.screens

// Pantalla de registro de un nuevo usuario

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appmodoguardian.ui.theme.AppModoGuardianTheme
import com.example.appmodoguardian.viewmodel.UsuarioViewModel

@Composable
fun RegistroScreen(
    viewModel: UsuarioViewModel = viewModel(),
    onRegistroExitoso: () -> Unit = {}
) {
    // Se conecta con el estado del formulario que vive en el ViewModel
    val estado by viewModel.estado.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Crear cuenta", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(24.dp))

        // Campo nombre
        OutlinedTextField(
            value = estado.nombre,
            onValueChange = { viewModel.onNombreChange(it) },
            label = { Text("Nombre") },
            isError = estado.errores.nombre != null,
            supportingText = {
                if (estado.errores.nombre != null) Text(estado.errores.nombre!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Campo correo
        OutlinedTextField(
            value = estado.correo,
            onValueChange = { viewModel.onCorreoChange(it) },
            label = { Text("Correo") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = estado.errores.correo != null,
            supportingText = {
                if (estado.errores.correo != null) Text(estado.errores.correo!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Campo contraseña, se muestra oculta con asteriscos
        OutlinedTextField(
            value = estado.clave,
            onValueChange = { viewModel.onClaveChange(it) },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            isError = estado.errores.clave != null,
            supportingText = {
                if (estado.errores.clave != null) Text(estado.errores.clave!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Campo dirección
        OutlinedTextField(
            value = estado.direccion,
            onValueChange = { viewModel.onDireccionChange(it) },
            label = { Text("Dirección") },
            isError = estado.errores.direccion != null,
            supportingText = {
                if (estado.errores.direccion != null) Text(estado.errores.direccion!!)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Casilla para aceptar los términos
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = estado.aceptaTerminos,
                onCheckedChange = { viewModel.onAceptarTerminosChange(it) }
            )
            Text("Acepto los términos y condiciones")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón que manda a validar el formulario completo
        Button(
            onClick = {
                val esValido = viewModel.validarFormulario()
                if (esValido) {
                    onRegistroExitoso()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroScreenPreview() {
    AppModoGuardianTheme {
        RegistroScreen()
    }
}