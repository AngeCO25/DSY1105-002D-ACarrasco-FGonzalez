package com.example.appmodoguardian.viewmodel

import androidx.lifecycle.ViewModel
import com.example.appmodoguardian.model.UsuarioErrores
import com.example.appmodoguardian.model.UsuarioUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UsuarioViewModel : ViewModel() {

    // Estado interno, solo el ViewModel lo modifica
    private val _estado = MutableStateFlow(UsuarioUiState())

    // Version de solo lectura que observa la pantalla
    val estado: StateFlow<UsuarioUiState> = _estado

    // Cada funcion guarda el valor nuevo y borra el error de ese campo
    fun onNombreChange(valor: String) {
        _estado.update { it.copy(nombre = valor, errores = it.errores.copy(nombre = null)) }
    }

    fun onCorreoChange(valor: String) {
        _estado.update { it.copy(correo = valor, errores = it.errores.copy(correo = null)) }
    }

    fun onClaveChange(valor: String) {
        _estado.update { it.copy(clave = valor, errores = it.errores.copy(clave = null)) }
    }

    fun onDireccionChange(valor: String) {
        _estado.update { it.copy(direccion = valor, errores = it.errores.copy(direccion = null)) }
    }

    fun onAceptarTerminosChange(valor: Boolean) {
        _estado.update { it.copy(aceptaTerminos = valor) }
    }

    // Revisa todos los campos y devuelve si el formulario esta correcto
    fun validarFormulario(): Boolean {
        val actual = _estado.value

        val errores = UsuarioErrores(
            nombre = if (actual.nombre.isBlank()) "Campo obligatorio" else null,
            correo = if (!actual.correo.contains("@")) "Correo invalido" else null,
            clave = if (actual.clave.length < 6) "Debe tener al menos 6 caracteres" else null,
            direccion = if (actual.direccion.isBlank()) "Campo obligatorio" else null
        )

        // listOfNotNull descarta los nulos, asi que si queda algo es porque hay errores
        val hayErrores = listOfNotNull(
            errores.nombre,
            errores.correo,
            errores.clave,
            errores.direccion
        ).isNotEmpty()

        _estado.update { it.copy(errores = errores) }

        return !hayErrores
    }
}