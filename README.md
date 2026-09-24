AppModoGuardian

Aplicación móvil Android para el monitoreo de eventos y alertas.

Contexto
Modo Guardián es una plataforma web de monitoreo de cámaras, eventos y alertas de seguridad. Hoy sus usuarios dependen del computador para revisar esta información, lo que retrasa la atención de eventos cuando están fuera de su puesto de trabajo.

Este proyecto corresponde a un MVP académico que lleva esas funciones al celular. Todos los datos utilizados son simulados.

Estado del proyecto
En desarrollo. Actualmente está terminada la configuración inicial del proyecto con la estructura base MVVM.

Tecnologías
Kotlin
Jetpack Compose
Material Design 3
Android Studio
Patrón arquitectónico MVVM
Estructura del proyecto
app/src/main/java/com/example/appmodoguardian/
├── model/        Clases de datos
├── repository/   Origen de los datos
├── ui/           Pantallas de la aplicación
└── viewmodel/    Lógica de presentación
Cómo ejecutar
Abrir el proyecto en Android Studio.
Esperar a que termine la sincronización de Gradle.
Seleccionar un dispositivo en el Device Manager.
Ejecutar la aplicación con el botón Run.

Versión mínima de Android: API 25.

Planificación
El seguimiento de tareas se lleva en Trello: https://trello.com/b/wlsBSqeH/appmodoguardian
