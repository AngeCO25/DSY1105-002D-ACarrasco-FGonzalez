package com.example.appmodoguardian
// Punto de entrada de la aplicación

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appmodoguardian.ui.screens.HomeScreen2
import com.example.appmodoguardian.ui.theme.AppModoGuardianTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppModoGuardianTheme {
                HomeScreen2()
            }
        }
    }
}
//Guía 8 - Se elimina @composable hacia abajo ya que las funciones Greeting y GreetingPreview. Ya no se usan.
//Guia 9 - Se borra linea  import com.example.appmodoguardian.ui.HomeScreen y
//se en setContent se cambia de HomeScreen() a HomeScreen2()