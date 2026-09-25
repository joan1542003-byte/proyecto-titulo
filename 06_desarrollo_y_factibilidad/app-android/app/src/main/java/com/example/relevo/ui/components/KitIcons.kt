package com.example.relevo.ui.components

// Generado a partir de 10_recursos_visuales/marca-a-tiempo/iconos (kit D-073): 97 iconos
// en retícula de 24, trazo redondeado. No editar a mano; volver a generar desde los SVG.

internal enum class KitFill { NONE, INK, PAPER }

internal class KitShape(val pathData: String, val stroke: Boolean, val fill: KitFill)

/** Iconos propios de Relevo. [label] es su nombre accesible; en pantalla siempre van con una palabra. */
enum class KitIcon(val label: String, internal val shapes: List<KitShape>) {
  ACCESIBILIDAD(
    "Accesibilidad",
    listOf(
      KitShape("M3.25 12A8.75 8.75 0 1 0 20.75 12A8.75 8.75 0 1 0 3.25 12Z", true, KitFill.NONE),
      KitShape("M10.9 7.75A1.1 1.1 0 1 0 13.1 7.75A1.1 1.1 0 1 0 10.9 7.75Z", false, KitFill.INK),
      KitShape("M7.75 10.25H16.25", true, KitFill.NONE),
      KitShape("M12 10.25V13.25L9.75 17.25M12 13.25L14.25 17.25", true, KitFill.NONE),
    ),
  ),
  ACTIVIDAD(
    "Actividad",
    listOf(
      KitShape("M3.5 20.5H20.5", true, KitFill.NONE),
      KitShape("M5 17V14.4L14.6 4.8A1.9 1.9 0 0 1 17.3 4.8L17.7 5.2A1.9 1.9 0 0 1 17.7 7.9L8.1 17.5H5.5A.5.5 0 0 1 5 17Z", true, KitFill.NONE),
      KitShape("M13 6.4L16.1 9.5", true, KitFill.NONE),
    ),
  ),
  ADVERTENCIA(
    "Advertencia",
    listOf(
      KitShape("M10.3 4.75A1.95 1.95 0 0 1 13.7 4.75L20.8 17.1A1.95 1.95 0 0 1 19.1 20H4.9A1.95 1.95 0 0 1 3.2 17.1Z", true, KitFill.NONE),
      KitShape("M12 9.5V13.75", true, KitFill.NONE),
      KitShape("M11 16.75A1 1 0 1 0 13 16.75A1 1 0 1 0 11 16.75Z", false, KitFill.INK),
    ),
  ),
  AGREGAR(
    "Agregar",
    listOf(
      KitShape("M12 4.5V19.5M4.5 12H19.5", true, KitFill.NONE),
    ),
  ),
  AJUSTES(
    "Ajustes",
    listOf(
      KitShape("M3.5 7H20.5M3.5 17H20.5", true, KitFill.NONE),
      KitShape("M6.5 7A2.5 2.5 0 1 0 11.5 7A2.5 2.5 0 1 0 6.5 7Z", true, KitFill.PAPER),
      KitShape("M12.5 17A2.5 2.5 0 1 0 17.5 17A2.5 2.5 0 1 0 12.5 17Z", true, KitFill.PAPER),
    ),
  ),
  APPS(
    "Apps elegidas",
    listOf(
      KitShape("M5.5 3.5H8.5A2 2 0 0 1 10.5 5.5V8.5A2 2 0 0 1 8.5 10.5H5.5A2 2 0 0 1 3.5 8.5V5.5A2 2 0 0 1 5.5 3.5Z", true, KitFill.NONE),
      KitShape("M15.5 3.5H18.5A2 2 0 0 1 20.5 5.5V8.5A2 2 0 0 1 18.5 10.5H15.5A2 2 0 0 1 13.5 8.5V5.5A2 2 0 0 1 15.5 3.5Z", true, KitFill.NONE),
      KitShape("M5.5 13.5H8.5A2 2 0 0 1 10.5 15.5V18.5A2 2 0 0 1 8.5 20.5H5.5A2 2 0 0 1 3.5 18.5V15.5A2 2 0 0 1 5.5 13.5Z", true, KitFill.NONE),
      KitShape("M15.5 13.5H18.5A2 2 0 0 1 20.5 15.5V18.5A2 2 0 0 1 18.5 20.5H15.5A2 2 0 0 1 13.5 18.5V15.5A2 2 0 0 1 15.5 13.5Z", true, KitFill.NONE),
    ),
  ),
  AVISOS(
    "Avisos del teléfono",
    listOf(
      KitShape("M8.5 2.75H13.5A3 3 0 0 1 16.5 5.75V18.25A3 3 0 0 1 13.5 21.25H8.5A3 3 0 0 1 5.5 18.25V5.75A3 3 0 0 1 8.5 2.75Z", true, KitFill.NONE),
      KitShape("M9.5 18H12.5", true, KitFill.NONE),
      KitShape("M14.5 6A3 3 0 1 0 20.5 6A3 3 0 1 0 14.5 6Z", true, KitFill.PAPER),
      KitShape("M15.75 6A1.75 1.75 0 1 0 19.25 6A1.75 1.75 0 1 0 15.75 6Z", false, KitFill.INK),
    ),
  ),
  AYUDA(
    "Ayuda",
    listOf(
      KitShape("M3.25 12A8.75 8.75 0 1 0 20.75 12A8.75 8.75 0 1 0 3.25 12Z", true, KitFill.NONE),
      KitShape("M9.6 9.6A2.5 2.5 0 1 1 13.3 11.8C12.5 12.3 12 12.9 12 13.75", true, KitFill.NONE),
      KitShape("M11 16.9A1 1 0 1 0 13 16.9A1 1 0 1 0 11 16.9Z", false, KitFill.INK),
    ),
  ),
  BATERIA(
    "Batería del objeto",
    listOf(
      KitShape("M5.5 7.25H16.5A2.75 2.75 0 0 1 19.25 10V14A2.75 2.75 0 0 1 16.5 16.75H5.5A2.75 2.75 0 0 1 2.75 14V10A2.75 2.75 0 0 1 5.5 7.25Z", true, KitFill.NONE),
      KitShape("M21.25 10.5V13.5", true, KitFill.NONE),
      KitShape("M6.25 9.75H10.75A1 1 0 0 1 11.75 10.75V13.25A1 1 0 0 1 10.75 14.25H6.25A1 1 0 0 1 5.25 13.25V10.75A1 1 0 0 1 6.25 9.75Z", false, KitFill.INK),
    ),
  ),
  BICICLETA(
    "Andar en bicicleta",
    listOf(
      KitShape("M2.25 16A3.75 3.75 0 1 0 9.75 16A3.75 3.75 0 1 0 2.25 16Z", true, KitFill.NONE),
      KitShape("M14.25 16A3.75 3.75 0 1 0 21.75 16A3.75 3.75 0 1 0 14.25 16Z", true, KitFill.NONE),
      KitShape("M6 16L9.75 9H15.5L18 16", true, KitFill.NONE),
      KitShape("M9.75 9L12.75 16H6", true, KitFill.NONE),
      KitShape("M8.5 6.75H11", true, KitFill.NONE),
      KitShape("M15.5 9L14.75 6.5H16.75", true, KitFill.NONE),
    ),
  ),
  BORRAR(
    "Borrar",
    listOf(
      KitShape("M4 6.5H20", true, KitFill.NONE),
      KitShape("M9.5 6.5V4.25H14.5V6.5", true, KitFill.NONE),
      KitShape("M6.25 6.5L7.1 19.4A1.75 1.75 0 0 0 8.85 21H15.15A1.75 1.75 0 0 0 16.9 19.4L17.75 6.5", true, KitFill.NONE),
      KitShape("M10.25 10.5V16.75M13.75 10.5V16.75", true, KitFill.NONE),
    ),
  ),
  BUSCAR(
    "Buscar",
    listOf(
      KitShape("M3.75 10.5A6.75 6.75 0 1 0 17.25 10.5A6.75 6.75 0 1 0 3.75 10.5Z", true, KitFill.NONE),
      KitShape("M15.5 15.5L20.5 20.5", true, KitFill.NONE),
    ),
  ),
  CALENDARIO(
    "Calendario",
    listOf(
      KitShape("M6 5H18A2.5 2.5 0 0 1 20.5 7.5V18A2.5 2.5 0 0 1 18 20.5H6A2.5 2.5 0 0 1 3.5 18V7.5A2.5 2.5 0 0 1 6 5Z", true, KitFill.NONE),
      KitShape("M3.5 9.75H20.5", true, KitFill.NONE),
      KitShape("M8 3V6.75M16 3V6.75", true, KitFill.NONE),
    ),
  ),
  CAMBIE(
    "Cambié de idea",
    listOf(
      KitShape("M4 8.5H19", true, KitFill.NONE),
      KitShape("M15.5 5L19 8.5L15.5 12", true, KitFill.NONE),
      KitShape("M20 15.5H5", true, KitFill.NONE),
      KitShape("M8.5 12L5 15.5L8.5 19", true, KitFill.NONE),
    ),
  ),
  CAMINAR(
    "Caminar",
    listOf(
      KitShape("M3.5 16.5V9.6C3.5 8.6 4.6 8.1 5.4 8.6L7.9 10.2L10.9 7.6C12 9.7 14.1 11.1 17.1 11.6C19.2 11.9 20.5 13.2 20.5 15.1V16.5Z", true, KitFill.NONE),
      KitShape("M3.5 16.5V18.25A1 1 0 0 0 4.5 19.25H19.5A1 1 0 0 0 20.5 18.25V16.5", true, KitFill.NONE),
      KitShape("M9.2 11.3L10.4 12.6M11.3 9.9L12.4 11.2", true, KitFill.NONE),
    ),
  ),
  CARTA(
    "Escribirle a alguien",
    listOf(
      KitShape("M5.5 5.5H18.5A2.5 2.5 0 0 1 21 8V16A2.5 2.5 0 0 1 18.5 18.5H5.5A2.5 2.5 0 0 1 3 16V8A2.5 2.5 0 0 1 5.5 5.5Z", true, KitFill.NONE),
      KitShape("M3.75 7L12 13L20.25 7", true, KitFill.NONE),
    ),
  ),
  CERRAR_SESION(
    "Cerrar sesión",
    listOf(
      KitShape("M14 20.5H6.5A2 2 0 0 1 4.5 18.5V5.5A2 2 0 0 1 6.5 3.5H14", true, KitFill.NONE),
      KitShape("M10 12H20.5", true, KitFill.NONE),
      KitShape("M16.5 8L20.5 12L16.5 16", true, KitFill.NONE),
    ),
  ),
  CERRAR(
    "Cerrar",
    listOf(
      KitShape("M6 6L18 18M18 6L6 18", true, KitFill.NONE),
    ),
  ),
  COCINAR(
    "Cocinar",
    listOf(
      KitShape("M4.5 10.5H19.5V17.5A2.5 2.5 0 0 1 17 20H7A2.5 2.5 0 0 1 4.5 17.5Z", true, KitFill.NONE),
      KitShape("M2.5 12.5H4.5M19.5 12.5H21.5", true, KitFill.NONE),
      KitShape("M6 8H18", true, KitFill.NONE),
      KitShape("M12 8V5.75", true, KitFill.NONE),
      KitShape("M10.5 5.75H13.5", true, KitFill.NONE),
    ),
  ),
  CODIGO(
    "Código de participante",
    listOf(
      KitShape("M9.75 3.5L7.75 20.5M16.25 3.5L14.25 20.5M4.5 9H20M4 15H19.5", true, KitFill.NONE),
    ),
  ),
  COMENCE(
    "Comencé",
    listOf(
      KitShape("M4.75 12.75L9.75 17.5L19.25 6.75", true, KitFill.NONE),
    ),
  ),
  COMENTARIO(
    "Comentario",
    listOf(
      KitShape("M5.5 4.5H18.5A2 2 0 0 1 20.5 6.5V15A2 2 0 0 1 18.5 17H10.25L6.25 20.25V17H5.5A2 2 0 0 1 3.5 15V6.5A2 2 0 0 1 5.5 4.5Z", true, KitFill.NONE),
    ),
  ),
  CONEXION(
    "Conexión",
    listOf(
      KitShape("M10 14L14 10", true, KitFill.NONE),
      KitShape("M8.5 11L6.6 12.9A3.35 3.35 0 0 0 11.1 17.4L13 15.5", true, KitFill.NONE),
      KitShape("M11 8.5L12.9 6.6A3.35 3.35 0 0 1 17.4 11.1L15.5 13", true, KitFill.NONE),
    ),
  ),
  CONSENTIMIENTO(
    "Consentimiento",
    listOf(
      KitShape("M6 4.5A1.5 1.5 0 0 1 7.5 3H14L18.5 7.5V19.5A1.5 1.5 0 0 1 17 21H7.5A1.5 1.5 0 0 1 6 19.5Z", true, KitFill.NONE),
      KitShape("M14 3V7.5H18.5", true, KitFill.NONE),
      KitShape("M9.25 14.25L11.25 16.25L15 12", true, KitFill.NONE),
    ),
  ),
  CONTRAER(
    "Contraer",
    listOf(
      KitShape("M4.75 15L12 7.75L19.25 15", true, KitFill.NONE),
    ),
  ),
  COPIAR(
    "Copiar",
    listOf(
      KitShape("M11 8.5H18A2.5 2.5 0 0 1 20.5 11V18A2.5 2.5 0 0 1 18 20.5H11A2.5 2.5 0 0 1 8.5 18V11A2.5 2.5 0 0 1 11 8.5Z", true, KitFill.NONE),
      KitShape("M15.5 8.5V5.5A2 2 0 0 0 13.5 3.5H5.5A2 2 0 0 0 3.5 5.5V13.5A2 2 0 0 0 5.5 15.5H8.5", true, KitFill.NONE),
    ),
  ),
  DATOS(
    "Datos del estudio",
    listOf(
      KitShape("M7.5 4.5H16.5A2.5 2.5 0 0 1 19 7V18.5A2.5 2.5 0 0 1 16.5 21H7.5A2.5 2.5 0 0 1 5 18.5V7A2.5 2.5 0 0 1 7.5 4.5Z", true, KitFill.NONE),
      KitShape("M10.25 2.75H13.75A1.25 1.25 0 0 1 15 4V5A1.25 1.25 0 0 1 13.75 6.25H10.25A1.25 1.25 0 0 1 9 5V4A1.25 1.25 0 0 1 10.25 2.75Z", true, KitFill.PAPER),
      KitShape("M8.5 11H15.5M8.5 15H13", true, KitFill.NONE),
    ),
  ),
  DECISION(
    "Decisión",
    listOf(
      KitShape("M12 20.75V13", true, KitFill.NONE),
      KitShape("M12 13L6.25 7.25M12 13L17.75 7.25", true, KitFill.NONE),
      KitShape("M6 11V7H10M18 11V7H14", true, KitFill.NONE),
    ),
  ),
  DESBLOQUEADO(
    "Acceso abierto",
    listOf(
      KitShape("M7.25 10.25H16.75A2.5 2.5 0 0 1 19.25 12.75V18.25A2.5 2.5 0 0 1 16.75 20.75H7.25A2.5 2.5 0 0 1 4.75 18.25V12.75A2.5 2.5 0 0 1 7.25 10.25Z", true, KitFill.NONE),
      KitShape("M8.25 10.25V7.75A3.75 3.75 0 0 1 15.4 6.2", true, KitFill.NONE),
    ),
  ),
  DESCARGAR(
    "Descargar",
    listOf(
      KitShape("M12 3.5V14.5", true, KitFill.NONE),
      KitShape("M8 10.5L12 14.5L16 10.5", true, KitFill.NONE),
      KitShape("M4.5 13V18.5A2 2 0 0 0 6.5 20.5H17.5A2 2 0 0 0 19.5 18.5V13", true, KitFill.NONE),
    ),
  ),
  DESPUES(
    "La dejé para después",
    listOf(
      KitShape("M6.5 4.75A1.75 1.75 0 0 1 8.25 3H15.75A1.75 1.75 0 0 1 17.5 4.75V20.5L12 16.5L6.5 20.5Z", true, KitFill.NONE),
    ),
  ),
  DETENER(
    "Detener",
    listOf(
      KitShape("M8.5 6H15.5A2.5 2.5 0 0 1 18 8.5V15.5A2.5 2.5 0 0 1 15.5 18H8.5A2.5 2.5 0 0 1 6 15.5V8.5A2.5 2.5 0 0 1 8.5 6Z", true, KitFill.NONE),
    ),
  ),
  DIBUJAR(
    "Dibujar",
    listOf(
      KitShape("M9.5 16V13.4L17.1 5.8A1.9 1.9 0 0 1 19.8 5.8L20.2 6.2A1.9 1.9 0 0 1 20.2 8.9L12.6 16.5H10A.5.5 0 0 1 9.5 16Z", true, KitFill.NONE),
      KitShape("M3.5 19.5C5.5 17 7 21.5 9.25 19.5C10.25 18.6 11 19.2 12 19.75", true, KitFill.NONE),
    ),
  ),
  DORMIR(
    "Dormir",
    listOf(
      KitShape("M3.5 6.5V19M3.5 16H20.5V19", true, KitFill.NONE),
      KitShape("M3.5 12.75H17.25A3.25 3.25 0 0 1 20.5 16", true, KitFill.NONE),
      KitShape("M7 9.25H8.75A1.5 1.5 0 0 1 10.25 10.75V11.25A1.5 1.5 0 0 1 8.75 12.75H7A1.5 1.5 0 0 1 5.5 11.25V10.75A1.5 1.5 0 0 1 7 9.25Z", true, KitFill.NONE),
    ),
  ),
  EDITAR(
    "Editar",
    listOf(
      KitShape("M5 19V16.4L14.6 6.8A1.9 1.9 0 0 1 17.3 6.8L17.2 6.7A1.9 1.9 0 0 1 17.2 9.4L7.6 19H5Z", true, KitFill.NONE),
      KitShape("M13 8.4L15.6 11", true, KitFill.NONE),
    ),
  ),
  EJERCICIO(
    "Hacer ejercicio",
    listOf(
      KitShape("M6.5 7.5V16.5M17.5 7.5V16.5M3.5 10V14M20.5 10V14M6.5 12H17.5", true, KitFill.NONE),
    ),
  ),
  ENLACE_EXTERNO(
    "Abrir fuera de la app",
    listOf(
      KitShape("M13.5 3.5H20.5V10.5", true, KitFill.NONE),
      KitShape("M20.5 3.5L11 13", true, KitFill.NONE),
      KitShape("M18 14V18.5A2 2 0 0 1 16 20.5H5.5A2 2 0 0 1 3.5 18.5V8A2 2 0 0 1 5.5 6H10", true, KitFill.NONE),
    ),
  ),
  ENTREVISTAS(
    "Entrevistas",
    listOf(
      KitShape("M3.5 4.75H14V12.25H8.5L5.5 14.75V12.25H3.5Z", true, KitFill.NONE),
      KitShape("M17 9H20.5V16.5H18.75V19L15.75 16.5H10V15", true, KitFill.NONE),
    ),
  ),
  ENVIAR(
    "Enviar",
    listOf(
      KitShape("M20.5 3.5L3.5 10.25L10.5 13.5L13.75 20.5Z", true, KitFill.NONE),
      KitShape("M20.5 3.5L10.5 13.5", true, KitFill.NONE),
    ),
  ),
  ERROR(
    "Error",
    listOf(
      KitShape("M3.25 12A8.75 8.75 0 1 0 20.75 12A8.75 8.75 0 1 0 3.25 12Z", true, KitFill.NONE),
      KitShape("M12 7.25V13", true, KitFill.NONE),
      KitShape("M11 16.25A1 1 0 1 0 13 16.25A1 1 0 1 0 11 16.25Z", false, KitFill.INK),
    ),
  ),
  ESCRIBIR(
    "Escribir",
    listOf(
      KitShape("M12 3.25L18 11L14.5 20.75H9.5L6 11Z", true, KitFill.NONE),
      KitShape("M12 20.75V14.75", true, KitFill.NONE),
      KitShape("M10.75 12.75A1.25 1.25 0 1 0 13.25 12.75A1.25 1.25 0 1 0 10.75 12.75Z", true, KitFill.NONE),
    ),
  ),
  ESPERANDO(
    "Esperando",
    listOf(
      KitShape("M7 3.25H17M7 20.75H17", true, KitFill.NONE),
      KitShape("M8.5 3.25V6.2L12 12L15.5 6.2V3.25", true, KitFill.NONE),
      KitShape("M8.5 20.75V17.8L12 12L15.5 17.8V20.75", true, KitFill.NONE),
    ),
  ),
  ESTIRAR(
    "Estirar",
    listOf(
      KitShape("M10.25 5A1.75 1.75 0 1 0 13.75 5A1.75 1.75 0 1 0 10.25 5Z", true, KitFill.NONE),
      KitShape("M12 9V14.25", true, KitFill.NONE),
      KitShape("M12 9.25L6.75 4.25M12 9.25L17.25 4.25", true, KitFill.NONE),
      KitShape("M12 14.25L8.25 20.5M12 14.25L15.75 20.5", true, KitFill.NONE),
    ),
  ),
  ESTRELLA_LLENA(
    "Estrella llena",
    listOf(
      KitShape("M12 3.5L14.56 9.08L20.65 9.79L16.14 13.94L17.35 19.96L12 16.95L6.65 19.96L7.86 13.94L3.35 9.79L9.44 9.08Z", true, KitFill.INK),
    ),
  ),
  ESTRELLA_MEDIA(
    "Media estrella",
    listOf(
      KitShape("M12 3.5L9.44 9.08L3.35 9.79L7.86 13.94L6.65 19.96L12 16.95Z", false, KitFill.INK),
      KitShape("M12 3.5L14.56 9.08L20.65 9.79L16.14 13.94L17.35 19.96L12 16.95L6.65 19.96L7.86 13.94L3.35 9.79L9.44 9.08Z", true, KitFill.NONE),
    ),
  ),
  ESTRELLA(
    "Estrella vacía",
    listOf(
      KitShape("M12 3.5L14.56 9.08L20.65 9.79L16.14 13.94L17.35 19.96L12 16.95L6.65 19.96L7.86 13.94L3.35 9.79L9.44 9.08Z", true, KitFill.NONE),
    ),
  ),
  ESTUDIAR(
    "Estudiar",
    listOf(
      KitShape("M8 3H17.5A2 2 0 0 1 19.5 5V19A2 2 0 0 1 17.5 21H8A2 2 0 0 1 6 19V5A2 2 0 0 1 8 3Z", true, KitFill.NONE),
      KitShape("M4 7H8M4 12H8M4 17H8", true, KitFill.NONE),
      KitShape("M11.5 8H16M11.5 12H16", true, KitFill.NONE),
    ),
  ),
  EXPANDIR(
    "Expandir",
    listOf(
      KitShape("M4.75 9L12 16.25L19.25 9", true, KitFill.NONE),
    ),
  ),
  EXPORTAR(
    "Exportar o compartir",
    listOf(
      KitShape("M12 14.5V3.5", true, KitFill.NONE),
      KitShape("M8 7.5L12 3.5L16 7.5", true, KitFill.NONE),
      KitShape("M4.5 13V18.5A2 2 0 0 0 6.5 20.5H17.5A2 2 0 0 0 19.5 18.5V13", true, KitFill.NONE),
    ),
  ),
  FILTRAR(
    "Filtrar",
    listOf(
      KitShape("M3.5 4.75H20.5L14 12.5V18.75L10 20.75V12.5Z", true, KitFill.NONE),
    ),
  ),
  FOTOGRAFIA(
    "Fotografiar",
    listOf(
      KitShape("M3.5 8.5A2 2 0 0 1 5.5 6.5H8L9.5 4.5H14.5L16 6.5H18.5A2 2 0 0 1 20.5 8.5V17.5A2 2 0 0 1 18.5 19.5H5.5A2 2 0 0 1 3.5 17.5Z", true, KitFill.NONE),
      KitShape("M8.5 13A3.5 3.5 0 1 0 15.5 13A3.5 3.5 0 1 0 8.5 13Z", true, KitFill.NONE),
    ),
  ),
  GUITARRA(
    "Tocar un instrumento",
    listOf(
      KitShape("M9.76 13.99A3 3 0 1 1 14.24 13.99A3.75 3.75 0 1 1 9.76 13.99Z", true, KitFill.NONE),
      KitShape("M10.75 16.6A1.25 1.25 0 1 0 13.25 16.6A1.25 1.25 0 1 0 10.75 16.6Z", true, KitFill.NONE),
      KitShape("M12 9V3.25", true, KitFill.NONE),
      KitShape("M10.5 3.25H13.5", true, KitFill.NONE),
    ),
  ),
  HIPOTESIS(
    "Hipótesis y prueba",
    listOf(
      KitShape("M9.5 3.25H14.5", true, KitFill.NONE),
      KitShape("M10.5 3.25V9.25L5.4 18.2A1.75 1.75 0 0 0 6.9 20.75H17.1A1.75 1.75 0 0 0 18.6 18.2L13.5 9.25V3.25", true, KitFill.NONE),
      KitShape("M7.75 15H16.25", true, KitFill.NONE),
    ),
  ),
  HISTORIAL(
    "Historial",
    listOf(
      KitShape("M4.25 12A7.75 7.75 0 1 0 6.5 6.5", true, KitFill.NONE),
      KitShape("M3.75 3.75V7.25H7.25", true, KitFill.NONE),
      KitShape("M12 8V12L14.75 13.75", true, KitFill.NONE),
    ),
  ),
  INFO(
    "Información",
    listOf(
      KitShape("M3.25 12A8.75 8.75 0 1 0 20.75 12A8.75 8.75 0 1 0 3.25 12Z", true, KitFill.NONE),
      KitShape("M12 11V16.5", true, KitFill.NONE),
      KitShape("M11 7.75A1 1 0 1 0 13 7.75A1 1 0 1 0 11 7.75Z", false, KitFill.INK),
    ),
  ),
  INICIO(
    "Inicio",
    listOf(
      KitShape("M4 10.5L12 3.75L20 10.5V19.25A1.75 1.75 0 0 1 18.25 21H5.75A1.75 1.75 0 0 1 4 19.25Z", true, KitFill.NONE),
      KitShape("M9.75 21V15.25H14.25V21", true, KitFill.NONE),
    ),
  ),
  INVESTIGACION(
    "Investigación",
    listOf(
      KitShape("M16.5 10V5A1.5 1.5 0 0 0 15 3.5H5.5A1.5 1.5 0 0 0 4 5V19A1.5 1.5 0 0 0 5.5 20.5H10", true, KitFill.NONE),
      KitShape("M7.5 7.5H13M7.5 11H10.5", true, KitFill.NONE),
      KitShape("M11.75 15.25A3.5 3.5 0 1 0 18.75 15.25A3.5 3.5 0 1 0 11.75 15.25Z", true, KitFill.NONE),
      KitShape("M17.75 17.75L20.5 20.5", true, KitFill.NONE),
    ),
  ),
  JUEGO_DE_MESA(
    "Jugar un juego de mesa",
    listOf(
      KitShape("M7.5 4H16.5A3.5 3.5 0 0 1 20 7.5V16.5A3.5 3.5 0 0 1 16.5 20H7.5A3.5 3.5 0 0 1 4 16.5V7.5A3.5 3.5 0 0 1 7.5 4Z", true, KitFill.NONE),
      KitShape("M7.25 8.5A1.25 1.25 0 1 0 9.75 8.5A1.25 1.25 0 1 0 7.25 8.5Z", false, KitFill.INK),
      KitShape("M10.75 12A1.25 1.25 0 1 0 13.25 12A1.25 1.25 0 1 0 10.75 12Z", false, KitFill.INK),
      KitShape("M14.25 15.5A1.25 1.25 0 1 0 16.75 15.5A1.25 1.25 0 1 0 14.25 15.5Z", false, KitFill.INK),
    ),
  ),
  LEER(
    "Leer",
    listOf(
      KitShape("M12 6.25C9.75 4.75 6.75 4.25 3.5 4.75V18.5C6.75 18 9.75 18.5 12 20C14.25 18.5 17.25 18 20.5 18.5V4.75C17.25 4.25 14.25 4.75 12 6.25Z", true, KitFill.NONE),
      KitShape("M12 6.25V20", true, KitFill.NONE),
      KitShape("M15.5 5.1V10.25L16.9 9.1L18.3 10.25V4.85", true, KitFill.NONE),
    ),
  ),
  LISTO(
    "Listo",
    listOf(
      KitShape("M3.25 12A8.75 8.75 0 1 0 20.75 12A8.75 8.75 0 1 0 3.25 12Z", true, KitFill.NONE),
      KitShape("M8 12.25L10.75 15L16 9.25", true, KitFill.NONE),
    ),
  ),
  LLAMAR(
    "Llamar a alguien",
    listOf(
      KitShape("M6.6 3.5H9L10.5 7.5L8.6 9A11 11 0 0 0 15 15.4L16.5 13.5L20.5 15V17.4A2.5 2.5 0 0 1 17.9 19.9C10.3 19.4 4.6 13.7 4.1 6.1A2.5 2.5 0 0 1 6.6 3.5Z", true, KitFill.NONE),
    ),
  ),
  LUGAR(
    "Lugar",
    listOf(
      KitShape("M12 20.5C12 20.5 5.75 14.6 5.75 9.75A6.25 6.25 0 0 1 18.25 9.75C18.25 14.6 12 20.5 12 20.5Z", true, KitFill.NONE),
      KitShape("M9.75 9.75A2.25 2.25 0 1 0 14.25 9.75A2.25 2.25 0 1 0 9.75 9.75Z", true, KitFill.NONE),
    ),
  ),
  MANUALIDADES(
    "Hacer manualidades",
    listOf(
      KitShape("M3.75 17A2.75 2.75 0 1 0 9.25 17A2.75 2.75 0 1 0 3.75 17Z", true, KitFill.NONE),
      KitShape("M14.75 17A2.75 2.75 0 1 0 20.25 17A2.75 2.75 0 1 0 14.75 17Z", true, KitFill.NONE),
      KitShape("M8.4 15L17.5 3.75M15.6 15L6.5 3.75", true, KitFill.NONE),
    ),
  ),
  MAS(
    "Más opciones",
    listOf(
      KitShape("M4 12A1.5 1.5 0 1 0 7 12A1.5 1.5 0 1 0 4 12Z", false, KitFill.INK),
      KitShape("M10.5 12A1.5 1.5 0 1 0 13.5 12A1.5 1.5 0 1 0 10.5 12Z", false, KitFill.INK),
      KitShape("M17 12A1.5 1.5 0 1 0 20 12A1.5 1.5 0 1 0 17 12Z", false, KitFill.INK),
    ),
  ),
  MENU(
    "Menú",
    listOf(
      KitShape("M4 7H20M4 12H20M4 17H20", true, KitFill.NONE),
    ),
  ),
  MOSTRAR(
    "Mostrar",
    listOf(
      KitShape("M2.75 12C5 7.5 8.3 5.5 12 5.5S19 7.5 21.25 12C19 16.5 15.7 18.5 12 18.5S5 16.5 2.75 12Z", true, KitFill.NONE),
      KitShape("M9 12A3 3 0 1 0 15 12A3 3 0 1 0 9 12Z", true, KitFill.NONE),
    ),
  ),
  MUSICA(
    "Escuchar música",
    listOf(
      KitShape("M4 15V12A8 8 0 0 1 20 12V15", true, KitFill.NONE),
      KitShape("M5.5 13.5H6A2 2 0 0 1 8 15.5V18.5A2 2 0 0 1 6 20.5H5.5A2 2 0 0 1 3.5 18.5V15.5A2 2 0 0 1 5.5 13.5Z", true, KitFill.NONE),
      KitShape("M18 13.5H18.5A2 2 0 0 1 20.5 15.5V18.5A2 2 0 0 1 18.5 20.5H18A2 2 0 0 1 16 18.5V15.5A2 2 0 0 1 18 13.5Z", true, KitFill.NONE),
    ),
  ),
  OBJETO(
    "Objeto",
    listOf(
      KitShape("M4 8.75A8 3 0 1 0 20 8.75A8 3 0 1 0 4 8.75Z", true, KitFill.NONE),
      KitShape("M4 8.75V15.25C4 16.9 7.6 18.25 12 18.25C16.4 18.25 20 16.9 20 15.25V8.75", true, KitFill.NONE),
      KitShape("M11 8.75A1 1 0 1 0 13 8.75A1 1 0 1 0 11 8.75Z", false, KitFill.INK),
    ),
  ),
  OCULTAR(
    "Ocultar",
    listOf(
      KitShape("M2.75 12C5 7.5 8.3 5.5 12 5.5S19 7.5 21.25 12C19 16.5 15.7 18.5 12 18.5S5 16.5 2.75 12Z", true, KitFill.NONE),
      KitShape("M9 12A3 3 0 1 0 15 12A3 3 0 1 0 9 12Z", true, KitFill.NONE),
      KitShape("M4.5 4.5L19.5 19.5", true, KitFill.NONE),
    ),
  ),
  ORDENAR(
    "Ordenar",
    listOf(
      KitShape("M3.5 8L12 3.75L20.5 8V16L12 20.25L3.5 16Z", true, KitFill.NONE),
      KitShape("M3.5 8L12 12.25L20.5 8", true, KitFill.NONE),
      KitShape("M12 12.25V20.25", true, KitFill.NONE),
    ),
  ),
  PARLANTE(
    "Parlante",
    listOf(
      KitShape("M9 2.75H15A3 3 0 0 1 18 5.75V18.25A3 3 0 0 1 15 21.25H9A3 3 0 0 1 6 18.25V5.75A3 3 0 0 1 9 2.75Z", true, KitFill.NONE),
      KitShape("M8.75 14.5A3.25 3.25 0 1 0 15.25 14.5A3.25 3.25 0 1 0 8.75 14.5Z", true, KitFill.NONE),
      KitShape("M11 7.5A1 1 0 1 0 13 7.5A1 1 0 1 0 11 7.5Z", false, KitFill.INK),
    ),
  ),
  PAUSAR(
    "Pausar",
    listOf(
      KitShape("M9 5.5V18.5M15 5.5V18.5", true, KitFill.NONE),
    ),
  ),
  PERFIL(
    "Perfil",
    listOf(
      KitShape("M5.25 5H18.75A2.5 2.5 0 0 1 21.25 7.5V16.5A2.5 2.5 0 0 1 18.75 19H5.25A2.5 2.5 0 0 1 2.75 16.5V7.5A2.5 2.5 0 0 1 5.25 5Z", true, KitFill.NONE),
      KitShape("M6.25 10.75A2.25 2.25 0 1 0 10.75 10.75A2.25 2.25 0 1 0 6.25 10.75Z", true, KitFill.NONE),
      KitShape("M5.25 16.25C5.6 14.6 6.9 13.75 8.5 13.75S11.4 14.6 11.75 16.25", true, KitFill.NONE),
      KitShape("M14.5 10H18M14.5 13.5H17", true, KitFill.NONE),
    ),
  ),
  PERMISO(
    "Permiso",
    listOf(
      KitShape("M3.75 12A4 4 0 1 0 11.75 12A4 4 0 1 0 3.75 12Z", true, KitFill.NONE),
      KitShape("M11.75 12H20.5V15", true, KitFill.NONE),
      KitShape("M17 12V14.5", true, KitFill.NONE),
    ),
  ),
  PINTAR(
    "Pintar",
    listOf(
      KitShape("M13.75 10.25L19.1 4.9A1.5 1.5 0 0 1 21.2 7L15.85 12.35", true, KitFill.NONE),
      KitShape("M12.75 11.25L14.85 13.35", true, KitFill.NONE),
      KitShape("M9.6 13.1C11.9 12.9 13.4 15.4 11.8 17.2C9.9 19.3 6.3 18.9 3.5 20.5C3.9 17.6 5.2 16.2 6.6 14.9C7.4 13.9 8.4 13.2 9.6 13.1Z", true, KitFill.NONE),
    ),
  ),
  PLANTAS(
    "Cuidar las plantas",
    listOf(
      KitShape("M6.5 13H17.5L16.25 20.5H7.75Z", true, KitFill.NONE),
      KitShape("M12 13V8.5", true, KitFill.NONE),
      KitShape("M12 9.75C12 6.75 14.4 4.75 17.5 5C17.5 7.9 15.1 9.75 12 9.75Z", true, KitFill.NONE),
      KitShape("M12 11.25C12 9 10.2 7.5 7.25 7.75C7.25 9.9 9.1 11.25 12 11.25Z", true, KitFill.NONE),
    ),
  ),
  PRIMER_PASO(
    "Cómo empieza",
    listOf(
      KitShape("M3.5 19.5H8.5V14H14V8.5H20.5", true, KitFill.NONE),
    ),
  ),
  PRIVACIDAD(
    "Privacidad",
    listOf(
      KitShape("M7.25 10.25H16.75A2.5 2.5 0 0 1 19.25 12.75V18.25A2.5 2.5 0 0 1 16.75 20.75H7.25A2.5 2.5 0 0 1 4.75 18.25V12.75A2.5 2.5 0 0 1 7.25 10.25Z", true, KitFill.NONE),
      KitShape("M8.25 10.25V7.75A3.75 3.75 0 0 1 15.75 7.75V10.25", true, KitFill.NONE),
    ),
  ),
  PROBAR(
    "Probar sonido",
    listOf(
      KitShape("M3.5 9.5H6.75L11.5 5.5V18.5L6.75 14.5H3.5Z", true, KitFill.NONE),
      KitShape("M15 9.25A4 4 0 0 1 15 14.75", true, KitFill.NONE),
      KitShape("M17.75 6.5A8 8 0 0 1 17.75 17.5", true, KitFill.NONE),
    ),
  ),
  PROBLEMA(
    "Reportar un problema",
    listOf(
      KitShape("M9.4 8.9A2.6 2.6 0 0 1 14.6 8.9", true, KitFill.NONE),
      KitShape("M12 8.25C15 8.25 16.75 10.6 16.75 14C16.75 17.4 14.6 19.75 12 19.75S7.25 17.4 7.25 14C7.25 10.6 9 8.25 12 8.25Z", true, KitFill.NONE),
      KitShape("M12 11V19.5", true, KitFill.NONE),
      KitShape("M7.25 13H4M7.3 16.5L4.75 18.25M16.75 13H20M16.7 16.5L19.25 18.25M8.4 10L6 7.75M15.6 10L18 7.75", true, KitFill.NONE),
    ),
  ),
  REINTENTAR(
    "Reintentar",
    listOf(
      KitShape("M19.75 12A7.75 7.75 0 1 1 17.5 6.5", true, KitFill.NONE),
      KitShape("M20.25 3.75V7.25H16.75", true, KitFill.NONE),
    ),
  ),
  RELEVOS(
    "Relevos",
    listOf(
      KitShape("M9 6.5H20.5M9 12H20.5M9 17.5H20.5", true, KitFill.NONE),
      KitShape("M3.5 6.5A1.25 1.25 0 1 0 6 6.5A1.25 1.25 0 1 0 3.5 6.5Z", false, KitFill.INK),
      KitShape("M3.5 12A1.25 1.25 0 1 0 6 12A1.25 1.25 0 1 0 3.5 12Z", false, KitFill.INK),
      KitShape("M3.5 17.5A1.25 1.25 0 1 0 6 17.5A1.25 1.25 0 1 0 3.5 17.5Z", false, KitFill.INK),
    ),
  ),
  REPRODUCIR(
    "Reproducir",
    listOf(
      KitShape("M7.5 5.25L18.5 12L7.5 18.75Z", true, KitFill.NONE),
    ),
  ),
  SALIR(
    "Salir",
    listOf(
      KitShape("M6 20.5V4.75A1.25 1.25 0 0 1 7.25 3.5H16.75A1.25 1.25 0 0 1 18 4.75V20.5", true, KitFill.NONE),
      KitShape("M3.75 20.5H20.25", true, KitFill.NONE),
      KitShape("M13.75 12.5A1 1 0 1 0 15.75 12.5A1 1 0 1 0 13.75 12.5Z", false, KitFill.INK),
    ),
  ),
  SIGUIENTE(
    "Siguiente",
    listOf(
      KitShape("M9 4.75L16.25 12L9 19.25", true, KitFill.NONE),
    ),
  ),
  SILENCIAR(
    "Silenciar",
    listOf(
      KitShape("M3.5 9.5H6.75L11.5 5.5V18.5L6.75 14.5H3.5Z", true, KitFill.NONE),
      KitShape("M15.5 9.5L20.5 14.5M20.5 9.5L15.5 14.5", true, KitFill.NONE),
    ),
  ),
  SIN_CONEXION(
    "Sin conexión",
    listOf(
      KitShape("M7 18.5A4.25 4.25 0 0 1 6.35 10.05A5.75 5.75 0 0 1 17.45 9.4A4.55 4.55 0 0 1 17.25 18.5Z", true, KitFill.NONE),
      KitShape("M4 4L20 20", true, KitFill.NONE),
    ),
  ),
  SINCRONIZAR(
    "Sincronizar datos",
    listOf(
      KitShape("M7 18.5A4.25 4.25 0 0 1 6.35 10.05A5.75 5.75 0 0 1 17.45 9.4A4.55 4.55 0 0 1 17.25 18.5Z", true, KitFill.NONE),
      KitShape("M12 16V11.25M9.9 13.25L12 11.15L14.1 13.25", true, KitFill.NONE),
    ),
  ),
  SISTEMA(
    "Sistema phygital",
    listOf(
      KitShape("M5.25 3.75H8.75A2.25 2.25 0 0 1 11 6V18A2.25 2.25 0 0 1 8.75 20.25H5.25A2.25 2.25 0 0 1 3 18V6A2.25 2.25 0 0 1 5.25 3.75Z", true, KitFill.NONE),
      KitShape("M17 10.5H19A2 2 0 0 1 21 12.5V18.25A2 2 0 0 1 19 20.25H17A2 2 0 0 1 15 18.25V12.5A2 2 0 0 1 17 10.5Z", true, KitFill.NONE),
      KitShape("M12.5 15.25H13.5", true, KitFill.NONE),
    ),
  ),
  TELEFONO(
    "Este teléfono",
    listOf(
      KitShape("M9.5 2.75H14.5A3 3 0 0 1 17.5 5.75V18.25A3 3 0 0 1 14.5 21.25H9.5A3 3 0 0 1 6.5 18.25V5.75A3 3 0 0 1 9.5 2.75Z", true, KitFill.NONE),
      KitShape("M10.5 18H13.5", true, KitFill.NONE),
    ),
  ),
  TEMA(
    "Tema claro u oscuro",
    listOf(
      KitShape("M3.25 12A8.75 8.75 0 1 0 20.75 12A8.75 8.75 0 1 0 3.25 12Z", true, KitFill.NONE),
      KitShape("M12 3.25A8.75 8.75 0 0 1 12 20.75Z", false, KitFill.INK),
    ),
  ),
  TEXTO(
    "Tamaño del texto",
    listOf(
      KitShape("M3.5 18L8 6L12.5 18M5.3 13.5H10.7", true, KitFill.NONE),
      KitShape("M15.25 11.4C16.2 10.4 20.25 10 20.25 13V18M20.25 14.4C19.1 13.8 15 13.6 15 16.1C15 18.6 19.1 18.5 20.25 16.4", true, KitFill.NONE),
    ),
  ),
  TIEMPO(
    "Tiempo",
    listOf(
      KitShape("M3.25 12A8.75 8.75 0 1 0 20.75 12A8.75 8.75 0 1 0 3.25 12Z", true, KitFill.NONE),
      KitShape("M12 6.75V12H16", true, KitFill.NONE),
    ),
  ),
  USO(
    "Después de cuánto uso",
    listOf(
      KitShape("M4.25 13.25A7.75 7.75 0 1 0 19.75 13.25A7.75 7.75 0 1 0 4.25 13.25Z", true, KitFill.NONE),
      KitShape("M12 13.25V9.25", true, KitFill.NONE),
      KitShape("M9.75 2.75H14.25", true, KitFill.NONE),
      KitShape("M12 2.75V5.5", true, KitFill.NONE),
    ),
  ),
  USUARIO(
    "Persona",
    listOf(
      KitShape("M8 8A4 4 0 1 0 16 8A4 4 0 1 0 8 8Z", true, KitFill.NONE),
      KitShape("M4.5 20.5C4.5 16.4 7.9 13.5 12 13.5S19.5 16.4 19.5 20.5", true, KitFill.NONE),
    ),
  ),
  VALIDACION(
    "Validación",
    listOf(
      KitShape("M6.75 3.25H17.25A2.5 2.5 0 0 1 19.75 5.75V18.25A2.5 2.5 0 0 1 17.25 20.75H6.75A2.5 2.5 0 0 1 4.25 18.25V5.75A2.5 2.5 0 0 1 6.75 3.25Z", true, KitFill.NONE),
      KitShape("M7.75 8.75L9.1 10L11.25 7.5M13.25 8.75H16.5M7.75 14.75L9.1 16L11.25 13.5M13.25 14.75H16.5", true, KitFill.NONE),
    ),
  ),
  VOLVER(
    "Volver",
    listOf(
      KitShape("M15 4.75L7.75 12L15 19.25", true, KitFill.NONE),
    ),
  ),
}
