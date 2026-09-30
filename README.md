# Modo Guardián

Aplicación móvil Android para el monitoreo de dispositivos, eventos y alertas de seguridad.

Modo Guardián es una plataforma web de monitoreo de cámaras, eventos y alertas. Hoy sus usuarios dependen del computador para revisar esa información, lo que retrasa la atención de eventos cuando están fuera de su puesto de trabajo. Esta aplicación lleva esas funciones al teléfono.

---

## Estado

Interfaz en construcción. Pantalla base terminada y estructura adaptativa en desarrollo.

| Entrega | Fecha |
|---|---|
| Primera presentación | Semana del 5 al 9 de octubre |

---

## Tecnologías

| Herramienta | Uso |
|---|---|
| Kotlin | Lenguaje de desarrollo |
| Jetpack Compose | Construcción de la interfaz |
| Material Design 3 | Sistema de diseño |
| Window Size Classes | Adaptación a distintos tamaños de pantalla |
| MVVM | Patrón de arquitectura |
| Android Studio | Entorno de desarrollo |
| Gradle (Kotlin DSL) | Gestión de dependencias |
| Git y GitHub | Control de versiones |

Versión mínima de Android: **API 25**

---

## Estructura

```
app/src/main/java/com/example/appmodoguardian/
│
├── model/                    Clases de datos
├── repository/               Origen de los datos
├── viewmodel/                Lógica de presentación
│
├── ui/
│   ├── screens/              Versiones de pantalla por tamaño
│   │   ├── HomeScreenCompacta.kt
│   │   ├── HomeScreenMediana.kt
│   │   └── HomeScreenExpandida.kt
│   ├── utils/
│   │   └── WindowSizeUtils.kt
│   ├── theme/                Colores y tipografías
│   └── HomeScreen.kt
│
└── MainActivity.kt           Punto de entrada
```

---

## Cómo ejecutar

1. Clonar el repositorio
```
   git clone https://github.com/AngeCO25/AppModoGuardian.git
```
2. Abrir el proyecto en Android Studio
3. Esperar a que termine la sincronización de Gradle
4. Seleccionar un dispositivo en el Device Manager
5. Ejecutar con el botón **Run**

---

## Control de versiones

El desarrollo se organiza en ramas por funcionalidad. Cada funcionalidad se trabaja en una rama independiente, se revisa mediante Pull Request y luego se integra a `master`.

```
master                    Rama estable
└── feature/<nombre>      Una rama por funcionalidad
```

**Regla del equipo:** hacer `Pull` antes de comenzar a trabajar y `Push` antes de cerrar sesión.

---

## Metodología de trabajo

### Trello

El avance se gestiona en un tablero con tres listas:

| Lista | Contenido |
|---|---|
| **Por hacer** | Tareas pendientes |
| **En curso** | Tareas en desarrollo |
| **Finalizado** | Tareas completadas |

El trabajo avanza **guía por guía**. Cada tarjeta incluye:

- **Etiqueta de color** que identifica la guía a la que pertenece
- **Responsable** asignado
- **Fecha de inicio y término**
- **Checklist** con los pasos de la tarea
- **Imagen de evidencia** adjunta al completarla

**[Ver tablero](https://trello.com/b/wlsBSqeH/appmodoguardian)**

### Comunicación

| Canal | Uso |
|---|---|
| WhatsApp | Coordinación diaria y consultas rápidas |
| Google Drive | Documentación y archivos compartidos |

---

## Equipo

| Integrante | GitHub |
|---|---|
| Ángela Carrasco | [@AngeCO25](https://github.com/AngeCO25) |
| Fernanda González | [@fmgonzalez-alt](https://github.com/fmgonzalez-alt) |

---

## Información del curso

| | |
|---|---|
| Asignatura | Desarrollo de Aplicaciones Móviles (DSY1105) |
| Sección | 002D |
| Docente | Víctor Pinochet | @gamersx2025
| Institución | Duoc UC |
