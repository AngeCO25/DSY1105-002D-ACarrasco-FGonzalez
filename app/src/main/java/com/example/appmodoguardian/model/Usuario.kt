package com.example.appmodoguardian.model
// Representa a un usuario del sistema

data class Usuario(
    val correo: String,
    val clave: String,
    val nombre: String,
    val rol: String
)