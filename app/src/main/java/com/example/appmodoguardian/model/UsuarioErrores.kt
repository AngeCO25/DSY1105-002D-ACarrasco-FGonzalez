package com.example.appmodoguardian.model

// Guarda el mensaje de error de cada campo del formulario
// Si el campo esta correcto su valor queda en null

data class UsuarioErrores(
    val nombre: String? = null,
    val correo: String? = null,
    val clave: String? = null,
    val direccion: String? = null
)