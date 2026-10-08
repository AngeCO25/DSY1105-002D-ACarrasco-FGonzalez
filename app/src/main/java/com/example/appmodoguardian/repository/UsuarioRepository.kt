package com.example.appmodoguardian.repository

// Entrega los usuarios de prueba de la aplicacion

import com.example.appmodoguardian.model.Usuario

class UsuarioRepository {

    // Lista de usuarios simulados, en reemplazo de una base de datos
    private val usuarios = listOf(
        Usuario("admin@empresa.cl", "12345678", "Fernanda González", "Administrador"),
        Usuario("supervisor@empresa.cl", "12345678", "Ángela Carrasco", "Supervisor"),
        Usuario("operador@empresa.cl", "12345678", "Marco Díaz", "Operador")
    )

    // Busca un usuario cuyo correo y clave coincidan
    // Si no encuentra ninguno devuelve null
    fun validar(correo: String, clave: String): Usuario? {
        return usuarios.find { it.correo == correo && it.clave == clave }
    }
}