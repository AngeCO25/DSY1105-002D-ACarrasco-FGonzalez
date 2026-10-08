package com.example.appmodoguardian
// Punto de entrada de la aplicación

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmodoguardian.navigation.NavigationEvent
import com.example.appmodoguardian.navigation.Screen
import com.example.appmodoguardian.ui.screens.ConfiguracionScreen
import com.example.appmodoguardian.ui.screens.EventosScreen
import com.example.appmodoguardian.ui.screens.HomeScreen2
import com.example.appmodoguardian.ui.screens.LoginScreen
import com.example.appmodoguardian.ui.theme.AppModoGuardianTheme
import com.example.appmodoguardian.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppModoGuardianTheme {

                val viewModel: MainViewModel = viewModel()

                // Lleva el registro de en que pantalla esta la aplicacion
                val navController = rememberNavController()

                // Observa quien tiene la sesion iniciada
                val usuario by viewModel.usuarioActual.collectAsState()

                // Queda atento a los eventos que emite el ViewModel
                LaunchedEffect(Unit) {
                    viewModel.navigationEvents.collect { evento ->
                        when (evento) {
                            is NavigationEvent.NavigateTo -> navController.navigate(evento.route.route)
                            is NavigationEvent.PopBackStack -> navController.popBackStack()
                            is NavigationEvent.NavigateUp -> navController.navigateUp()
                        }
                    }
                }

                // Contenedor que muestra la pantalla correspondiente a la ruta actual
                NavHost(
                    navController = navController,
                    startDestination = Screen.Login.route
                ) {
                    composable(Screen.Login.route) {
                        // El ViewModel guarda el usuario validado y navega al inicio
                        LoginScreen(onIngresar = { usuarioValidado ->
                            viewModel.iniciarSesion(usuarioValidado)
                        })
                    }
                    composable(Screen.Inicio.route) {
                        HomeScreen2(
                            nombre = usuario?.nombre ?: "",
                            rol = usuario?.rol ?: "",
                            onCerrarSesion = { viewModel.cerrarSesion() }
                        )
                    }
                    composable(Screen.Eventos.route) {
                        EventosScreen()
                    }
                    composable(Screen.Configuracion.route) {
                        ConfiguracionScreen()
                    }
                }
            }
        }
    }
}

// Este archivo conecta todo:
// crea el MainViewModel, escucha sus eventos de navegacion y los ejecuta,
// y define en el NavHost que pantalla corresponde a cada ruta.

//Guía 8 - Se elimina @composable hacia abajo ya que las funciones Greeting y GreetingPreview. Ya no se usan.
//Guia 9 - Se borra linea import com.example.appmodoguardian.ui.HomeScreen y
//se en setContent se cambia de HomeScreen() a HomeScreen2()
//Guia 10 - Se agrega el NavHost y se escuchan los eventos del MainViewModel
//Se agregan los perfiles: el ViewModel guarda el usuario que inicio sesion
//y la pantalla de inicio muestra su nombre y su rol