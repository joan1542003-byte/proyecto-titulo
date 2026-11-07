package com.example.relevo.ui.components

// Generado a partir de 10_recursos_visuales/marca-a-tiempo/iconos (kit D-073): 97 iconos
// en retícula de 24, trazo redondeado. Desde la 4.0 se agregan a mano los que faltan, con su SVG en el kit.

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
  /** D-162: formas de base: una actividad cualquiera, sin el lápiz de Editar. */
  ACTIVIDAD(
    "Actividad",
    listOf(
      KitShape("M12 3.5L16 10.5H8Z", true, KitFill.NONE),
      KitShape("M5 13.5H9A1.5 1.5 0 0 1 10.5 15V19A1.5 1.5 0 0 1 9 20.5H5A1.5 1.5 0 0 1 3.5 19V15A1.5 1.5 0 0 1 5 13.5Z", true, KitFill.NONE),
      KitShape("M13.5 17A3.5 3.5 0 1 0 20.5 17A3.5 3.5 0 1 0 13.5 17Z", true, KitFill.NONE),
    ),
  ),
  ADVERTENCIA(
    "Advertencia",
    listOf(
      KitShape("M10.3 4.6a2 2 0 0 1 3.4 0l7.5 12.9a2 2 0 0 1-1.7 3H4.5a2 2 0 0 1-1.7-3z", true, KitFill.NONE),
      KitShape("M12 9.6v4", true, KitFill.NONE),
      KitShape("M11 16.7A1 1 0 1 0 13 16.7A1 1 0 1 0 11 16.7Z", false, KitFill.INK),
    ),
  ),
  AGREGAR(
    "Agregar",
    listOf(
      KitShape("M12 5v14M5 12h14", true, KitFill.NONE),
    ),
  ),
  AJUSTES(
    "Ajustes",
    listOf(
      KitShape("M4 7.5h9M17 7.5h3M4 16.5h3M11 16.5h9", true, KitFill.NONE),
      KitShape("M13 7.5A2 2 0 1 0 17 7.5A2 2 0 1 0 13 7.5Z", true, KitFill.NONE),
      KitShape("M7 16.5A2 2 0 1 0 11 16.5A2 2 0 1 0 7 16.5Z", true, KitFill.NONE),
    ),
  ),
  APPS(
    "Apps elegidas",
    listOf(
      KitShape("M6.2 4H8.8A2.2 2.2 0 0 1 11 6.2V8.8A2.2 2.2 0 0 1 8.8 11H6.2A2.2 2.2 0 0 1 4 8.8V6.2A2.2 2.2 0 0 1 6.2 4Z", true, KitFill.NONE),
      KitShape("M15.2 4H17.8A2.2 2.2 0 0 1 20 6.2V8.8A2.2 2.2 0 0 1 17.8 11H15.2A2.2 2.2 0 0 1 13 8.8V6.2A2.2 2.2 0 0 1 15.2 4Z", true, KitFill.NONE),
      KitShape("M6.2 13H8.8A2.2 2.2 0 0 1 11 15.2V17.8A2.2 2.2 0 0 1 8.8 20H6.2A2.2 2.2 0 0 1 4 17.8V15.2A2.2 2.2 0 0 1 6.2 13Z", true, KitFill.NONE),
      KitShape("M15.2 13H17.8A2.2 2.2 0 0 1 20 15.2V17.8A2.2 2.2 0 0 1 17.8 20H15.2A2.2 2.2 0 0 1 13 17.8V15.2A2.2 2.2 0 0 1 15.2 13Z", true, KitFill.NONE),
    ),
  ),
  AVISOS(
    "Avisos del teléfono",
    listOf(
      KitShape("M6.5 16.5V11a5.5 5.5 0 0 1 11 0v5.5l1.5 2H5z", true, KitFill.NONE),
      KitShape("M10 20.5a2.2 2.2 0 0 0 4 0", true, KitFill.NONE),
    ),
  ),
  AYUDA(
    "Ayuda",
    listOf(
      KitShape("M3 12A9 9 0 1 0 21 12A9 9 0 1 0 3 12Z", true, KitFill.NONE),
      KitShape("M9.6 9.5a2.5 2.5 0 0 1 4.9.7c0 1.7-2.5 2.1-2.5 3.8", true, KitFill.NONE),
      KitShape("M11 16.9A1 1 0 1 0 13 16.9A1 1 0 1 0 11 16.9Z", false, KitFill.INK),
    ),
  ),
  BATERIA(
    "Batería del objeto",
    listOf(
      KitShape("M5.4 7.5H16.2A2.6 2.6 0 0 1 18.8 10.1V13.9A2.6 2.6 0 0 1 16.2 16.5H5.4A2.6 2.6 0 0 1 2.8 13.9V10.1A2.6 2.6 0 0 1 5.4 7.5Z", true, KitFill.NONE),
      KitShape("M21.3 10.8v2.4", true, KitFill.NONE),
      KitShape("M6.5 10.5v3M9.7 10.5v3", true, KitFill.NONE),
    ),
  ),
  BICICLETA(
    "Andar en bicicleta",
    listOf(
      KitShape("M2.2 15.5A3.8 3.8 0 1 0 9.8 15.5A3.8 3.8 0 1 0 2.2 15.5Z", true, KitFill.NONE),
      KitShape("M14.2 15.5A3.8 3.8 0 1 0 21.8 15.5A3.8 3.8 0 1 0 14.2 15.5Z", true, KitFill.NONE),
      KitShape("M6 15.5h5.5l3.6-6.3M11.5 15.5L9.6 9.2h5.5M15.1 9.2L18 15.5", true, KitFill.NONE),
      KitShape("M8.2 9.2h2.9M14.2 7h2.4", true, KitFill.NONE),
    ),
  ),
  BORRAR(
    "Borrar",
    listOf(
      KitShape("M4.5 6.5h15", true, KitFill.NONE),
      KitShape("M9.5 6.5V4.8c0-.7.6-1.3 1.3-1.3h2.4c.7 0 1.3.6 1.3 1.3v1.7", true, KitFill.NONE),
      KitShape("M6.5 6.5l.9 12c.1 1.1 1 1.9 2 1.9h5.2c1 0 1.9-.8 2-1.9l.9-12", true, KitFill.NONE),
      KitShape("M10.3 10.5v6M13.7 10.5v6", true, KitFill.NONE),
    ),
  ),
  BUSCAR(
    "Buscar",
    listOf(
      KitShape("M4 10.5A6.5 6.5 0 1 0 17 10.5A6.5 6.5 0 1 0 4 10.5Z", true, KitFill.NONE),
      KitShape("M15.4 15.4l5.1 5.1", true, KitFill.NONE),
    ),
  ),
  CALENDARIO(
    "Calendario",
    listOf(
      KitShape("M6.5 5H17.5A3 3 0 0 1 20.5 8V17.5A3 3 0 0 1 17.5 20.5H6.5A3 3 0 0 1 3.5 17.5V8A3 3 0 0 1 6.5 5Z", true, KitFill.NONE),
      KitShape("M3.5 10h17M8 3v4M16 3v4", true, KitFill.NONE),
      KitShape("M7.3 14.4A1.1 1.1 0 1 0 9.5 14.4A1.1 1.1 0 1 0 7.3 14.4Z", false, KitFill.INK),
    ),
  ),
  CAMBIE(
    "Cambié de idea",
    listOf(
      KitShape("M4 8.2h13.5M14 4.7l3.5 3.5-3.5 3.5", true, KitFill.NONE),
      KitShape("M20 15.8H6.5M10 12.3l-3.5 3.5 3.5 3.5", true, KitFill.NONE),
    ),
  ),
  CAMINAR(
    "Caminar",
    listOf(
      KitShape("M4.9 11.4c0-2.8 1.1-4.6 2.4-4.6s2.4 1.8 2.4 4.6c0 1.7-.6 2.9-1.1 4.1h-2.6c-.5-1.2-1.1-2.4-1.1-4.1z", true, KitFill.NONE),
      KitShape("M5.8 16.8h3c.3 0 .5.2.5.5v.7c0 1-.9 1.8-2 1.8s-2-.8-2-1.8v-.7c0-.3.2-.5.5-.5z", true, KitFill.NONE),
      KitShape("M14.3 7.4c0-2.8 1.1-4.6 2.4-4.6s2.4 1.8 2.4 4.6c0 1.7-.6 2.9-1.1 4.1h-2.6c-.5-1.2-1.1-2.4-1.1-4.1z", true, KitFill.NONE),
      KitShape("M15.2 12.8h3c.3 0 .5.2.5.5v.7c0 1-.9 1.8-2 1.8s-2-.8-2-1.8v-.7c0-.3.2-.5.5-.5z", true, KitFill.NONE),
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
      KitShape("M6.5 6.5l11 11M17.5 6.5l-11 11", true, KitFill.NONE),
    ),
  ),
  COCINAR(
    "Cocinar",
    listOf(
      KitShape("M4.5 10.5h15v6.5a3 3 0 0 1-3 3h-9a3 3 0 0 1-3-3z", true, KitFill.NONE),
      KitShape("M4.5 12.8H2.8M19.5 12.8h1.7", true, KitFill.NONE),
      KitShape("M5.5 8c4.3-1.5 8.7-1.5 13 0", true, KitFill.NONE),
      KitShape("M12 5.2v1.6", true, KitFill.NONE),
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
      KitShape("M3 12A9 9 0 1 0 21 12A9 9 0 1 0 3 12Z", true, KitFill.NONE),
      KitShape("M10.3 8.7c0-.6.7-1 1.2-.7l4.6 3.3c.5.3.5 1 0 1.4l-4.6 3.3c-.5.3-1.2 0-1.2-.7z", true, KitFill.NONE),
    ),
  ),
  COMENTARIO(
    "Comentario",
    listOf(
      KitShape("M5 5.5h14a1.5 1.5 0 0 1 1.5 1.5v9a1.5 1.5 0 0 1-1.5 1.5h-7l-4.6 3.4V17.5H5A1.5 1.5 0 0 1 3.5 16V7A1.5 1.5 0 0 1 5 5.5z", true, KitFill.NONE),
    ),
  ),
  CONEXION(
    "Conexión",
    listOf(
      KitShape("M6.5 7.5l10 9-4.5 4V3.5l4.5 4-10 9", true, KitFill.NONE),
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
      KitShape("M5.5 14.5L12 8l6.5 6.5", true, KitFill.NONE),
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
      KitShape("M6 20.5V3.8", true, KitFill.NONE),
      KitShape("M6 4.5h11.2l-2.4 3.9 2.4 3.9H6", true, KitFill.NONE),
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
      KitShape("M12 4v11M7.5 10.5L12 15l4.5-4.5", true, KitFill.NONE),
      KitShape("M5 19.5h14", true, KitFill.NONE),
    ),
  ),
  DESPUES(
    "La dejé para después",
    listOf(
      KitShape("M20.5 12a8.5 8.5 0 1 1-2.5-6", true, KitFill.NONE),
      KitShape("M18.4 3.2l-.2 3.1-3.1-.3", true, KitFill.NONE),
      KitShape("M12 7.8v4.4l2.8 1.7", true, KitFill.NONE),
    ),
  ),
  DETENER(
    "Detener",
    listOf(
      KitShape("M8.5 6H15.5A2.5 2.5 0 0 1 18 8.5V15.5A2.5 2.5 0 0 1 15.5 18H8.5A2.5 2.5 0 0 1 6 15.5V8.5A2.5 2.5 0 0 1 8.5 6Z", true, KitFill.NONE),
    ),
  ),
  /** D-162: el lápiz con su trazo, distinto de Editar. */
  DIBUJAR(
    "Dibujar",
    listOf(
      KitShape("M6.3 15.7L7.2 12.4L16.4 3.2A1.7 1.7 0 0 1 18.8 5.6L9.6 14.8Z", true, KitFill.NONE),
      KitShape("M14.6 5L17 7.4", true, KitFill.NONE),
      KitShape("M3.5 20c2.2-1.6 4-1.8 5.5-.6 1.6 1.3 3.3 1.3 5.1 0 1.6-1.1 3.6-1.3 6.4-.2", true, KitFill.NONE),
    ),
  ),
  DORMIR(
    "Dormir",
    listOf(
      KitShape("M19.5 14.8A8 8 0 0 1 9.2 4.5a8 8 0 1 0 10.3 10.3z", true, KitFill.NONE),
      KitShape("M16.6 3.2c.3 1.6.8 2.1 2.4 2.4-1.6.3-2.1.8-2.4 2.4-.3-1.6-.8-2.1-2.4-2.4 1.6-.3 2.1-.8 2.4-2.4z", true, KitFill.NONE),
    ),
  ),
  EDITAR(
    "Editar",
    listOf(
      KitShape("M14.6 5.4a2.1 2.1 0 0 1 3 0l1 1a2.1 2.1 0 0 1 0 3L9 19H5v-4z", true, KitFill.NONE),
      KitShape("M12.8 7.2l4 4", true, KitFill.NONE),
      KitShape("M13.5 20h6", true, KitFill.NONE),
    ),
  ),
  EJERCICIO(
    "Hacer ejercicio",
    listOf(
      KitShape("M8 12h8", true, KitFill.NONE),
      KitShape("M5.8 7.2H6.7A1.3 1.3 0 0 1 8 8.5V15.5A1.3 1.3 0 0 1 6.7 16.8H5.8A1.3 1.3 0 0 1 4.5 15.5V8.5A1.3 1.3 0 0 1 5.8 7.2Z", true, KitFill.NONE),
      KitShape("M17.3 7.2H18.2A1.3 1.3 0 0 1 19.5 8.5V15.5A1.3 1.3 0 0 1 18.2 16.8H17.3A1.3 1.3 0 0 1 16 15.5V8.5A1.3 1.3 0 0 1 17.3 7.2Z", true, KitFill.NONE),
      KitShape("M2.6 10v4M21.4 10v4", true, KitFill.NONE),
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
      KitShape("M20.5 3.5L3.6 10.4c-.6.2-.6 1.1 0 1.3l6.9 2.8 2.8 6.9c.2.6 1.1.6 1.3 0z", true, KitFill.NONE),
      KitShape("M10.5 13.5l4.2-4.2", true, KitFill.NONE),
    ),
  ),
  ERROR(
    "Error",
    listOf(
      KitShape("M3 12A9 9 0 1 0 21 12A9 9 0 1 0 3 12Z", true, KitFill.NONE),
      KitShape("M9.2 9.2l5.6 5.6M14.8 9.2l-5.6 5.6", true, KitFill.NONE),
    ),
  ),
  ESCRIBIR(
    "Escribir",
    listOf(
      KitShape("M12 3.5l4.8 6.3L15 18.5H9L7.2 9.8z", true, KitFill.NONE),
      KitShape("M12 3.5v7.2", true, KitFill.NONE),
      KitShape("M10.6 12.2A1.4 1.4 0 1 0 13.4 12.2A1.4 1.4 0 1 0 10.6 12.2Z", true, KitFill.NONE),
      KitShape("M8 21h8", true, KitFill.NONE),
    ),
  ),
  ESPERANDO(
    "Esperando",
    listOf(
      KitShape("M6.5 3.5h11M6.5 20.5h11", true, KitFill.NONE),
      KitShape("M8 3.5c0 4.6 4 5.2 4 8.5s-4 3.9-4 8.5M16 3.5c0 4.6-4 5.2-4 8.5s4 3.9 4 8.5", true, KitFill.NONE),
      KitShape("M10.2 18.2c.6-.9 1.2-1.4 1.8-1.4s1.2.5 1.8 1.4z", true, KitFill.NONE),
    ),
  ),
  /** D-162: la colchoneta a medio desenrollar, como sugiere la app; era igual a Meditar. */
  ESTIRAR(
    "Estirar",
    listOf(
      KitShape("M2 13.5A6 6 0 1 0 14 13.5A6 6 0 1 0 2 13.5Z", true, KitFill.NONE),
      KitShape("M11 13.5A3 3 0 1 1 8 10.5", true, KitFill.NONE),
      KitShape("M8 19.5H19.8A1.25 1.25 0 0 0 19.8 17H12.9", true, KitFill.NONE),
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
      KitShape("M12 3.9l2.4 4.9 5.4.8-3.9 3.8.9 5.4-4.8-2.6-4.8 2.6.9-5.4-3.9-3.8 5.4-.8z", true, KitFill.NONE),
    ),
  ),
  ESTUDIAR(
    "Estudiar",
    listOf(
      KitShape("M8.5 3.5H16.5A2.5 2.5 0 0 1 19 6V18A2.5 2.5 0 0 1 16.5 20.5H8.5A2.5 2.5 0 0 1 6 18V6A2.5 2.5 0 0 1 8.5 3.5Z", true, KitFill.NONE),
      KitShape("M6 7.5H4M6 12H4M6 16.5H4", true, KitFill.NONE),
      KitShape("M10 8.5h5M10 12h5", true, KitFill.NONE),
    ),
  ),
  EXPANDIR(
    "Expandir",
    listOf(
      KitShape("M5.5 9.5l6.5 6.5 6.5-6.5", true, KitFill.NONE),
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
      KitShape("M6 7H18A3 3 0 0 1 21 10V17A3 3 0 0 1 18 20H6A3 3 0 0 1 3 17V10A3 3 0 0 1 6 7Z", true, KitFill.NONE),
      KitShape("M8.6 7l1.2-2.1c.2-.4.6-.6 1.1-.6h2.2c.5 0 .9.2 1.1.6L15.4 7", true, KitFill.NONE),
      KitShape("M8.6 13.5A3.4 3.4 0 1 0 15.4 13.5A3.4 3.4 0 1 0 8.6 13.5Z", true, KitFill.NONE),
      KitShape("M16.55 10.2A0.85 0.85 0 1 0 18.25 10.2A0.85 0.85 0 1 0 16.55 10.2Z", false, KitFill.INK),
    ),
  ),
  GUITARRA(
    "Tocar un instrumento",
    listOf(
      KitShape("M9.02 11.04A3.2 3.2 0 1 1 12.96 14.98A4.6 4.6 0 1 1 9.02 11.04Z", true, KitFill.NONE),
      KitShape("M13.9 10.1l5.4-5.4", true, KitFill.NONE),
      KitShape("M18.2 3.6l2.2 2.2", true, KitFill.NONE),
      KitShape("M8.3 14.4A1.3 1.3 0 1 0 10.9 14.4A1.3 1.3 0 1 0 8.3 14.4Z", true, KitFill.NONE),
      KitShape("M6.2 18.6l1.7-1.7", true, KitFill.NONE),
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
      KitShape("M5 20v-6M10 20V9M15 20v-4M20 20V5", true, KitFill.NONE),
    ),
  ),
  INFO(
    "Información",
    listOf(
      KitShape("M3 12A9 9 0 1 0 21 12A9 9 0 1 0 3 12Z", true, KitFill.NONE),
      KitShape("M12 11v5.6", true, KitFill.NONE),
      KitShape("M11 7.9A1 1 0 1 0 13 7.9A1 1 0 1 0 11 7.9Z", false, KitFill.INK),
    ),
  ),
  INICIO(
    "Inicio",
    listOf(
      KitShape("M4 10.3L12 4l8 6.3V19a1.5 1.5 0 0 1-1.5 1.5H15v-5.2a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v5.2H5.5A1.5 1.5 0 0 1 4 19z", true, KitFill.NONE),
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
      KitShape("M7.6 4H16.4A3.6 3.6 0 0 1 20 7.6V16.4A3.6 3.6 0 0 1 16.4 20H7.6A3.6 3.6 0 0 1 4 16.4V7.6A3.6 3.6 0 0 1 7.6 4Z", true, KitFill.NONE),
      KitShape("M7.35 8.6A1.25 1.25 0 1 0 9.85 8.6A1.25 1.25 0 1 0 7.35 8.6Z", false, KitFill.INK),
      KitShape("M10.75 12A1.25 1.25 0 1 0 13.25 12A1.25 1.25 0 1 0 10.75 12Z", false, KitFill.INK),
      KitShape("M14.15 15.4A1.25 1.25 0 1 0 16.65 15.4A1.25 1.25 0 1 0 14.15 15.4Z", false, KitFill.INK),
    ),
  ),
  LEER(
    "Leer",
    listOf(
      KitShape("M3.5 6.3c2.8-1 5.6-.8 8.5 1v12.2c-2.9-1.8-5.7-2-8.5-1z", true, KitFill.NONE),
      KitShape("M20.5 6.3c-2.8-1-5.6-.8-8.5 1v12.2c2.9-1.8 5.7-2 8.5-1z", true, KitFill.NONE),
    ),
  ),
  LISTO(
    "Listo",
    listOf(
      KitShape("M5 12.5l4.4 4.4L19 7.5", true, KitFill.NONE),
    ),
  ),
  VIDEOJUEGOS(
    "Jugar videojuegos",
    listOf(
      KitShape("M7.6 7.5h8.8a4.5 4.5 0 0 1 4.4 3.6l.9 4.6a2.6 2.6 0 0 1-4.4 2.3L15.6 16H8.4l-1.7 2a2.6 2.6 0 0 1-4.4-2.3l.9-4.6a4.5 4.5 0 0 1 4.4-3.6z", true, KitFill.NONE),
      KitShape("M8 10.5v3M6.5 12h3", true, KitFill.NONE),
      KitShape("M14.65 11A0.95 0.95 0 1 0 16.55 11A0.95 0.95 0 1 0 14.65 11Z", false, KitFill.INK),
      KitShape("M16.45 12.9A0.95 0.95 0 1 0 18.35 12.9A0.95 0.95 0 1 0 16.45 12.9Z", false, KitFill.INK),
    ),
  ),
  LLAMAR(
    "Llamar a alguien",
    listOf(
      KitShape("M8.3 3.8H6.1c-1.2 0-2.1 1-2 2.2.9 7.7 6.1 12.9 13.8 13.8 1.2.1 2.2-.8 2.2-2v-2.2c0-.5-.3-.9-.8-1.1l-3-.9c-.4-.1-.8 0-1.1.3l-1.3 1.4c-2.5-1.1-4.5-3.1-5.6-5.6l1.4-1.3c.3-.3.4-.7.3-1.1l-.9-3c-.2-.5-.6-.8-1.1-.8z", true, KitFill.NONE),
    ),
  ),
  LUGAR(
    "Lugar",
    listOf(
      KitShape("M12 21s-6.5-5.8-6.5-10.8a6.5 6.5 0 0 1 13 0C18.5 15.2 12 21 12 21z", true, KitFill.NONE),
      KitShape("M9.7 10.2A2.3 2.3 0 1 0 14.3 10.2A2.3 2.3 0 1 0 9.7 10.2Z", true, KitFill.NONE),
    ),
  ),
  MANUALIDADES(
    "Hacer manualidades",
    listOf(
      KitShape("M3.8 17.4A2.8 2.8 0 1 0 9.4 17.4A2.8 2.8 0 1 0 3.8 17.4Z", true, KitFill.NONE),
      KitShape("M14.6 17.4A2.8 2.8 0 1 0 20.2 17.4A2.8 2.8 0 1 0 14.6 17.4Z", true, KitFill.NONE),
      KitShape("M8.6 15.4L18.4 4.4M15.4 15.4L5.6 4.4", true, KitFill.NONE),
    ),
  ),
  MAS(
    "Más opciones",
    listOf(
      KitShape("M4.6 12A1.4 1.4 0 1 0 7.4 12A1.4 1.4 0 1 0 4.6 12Z", false, KitFill.INK),
      KitShape("M10.6 12A1.4 1.4 0 1 0 13.4 12A1.4 1.4 0 1 0 10.6 12Z", false, KitFill.INK),
      KitShape("M16.6 12A1.4 1.4 0 1 0 19.4 12A1.4 1.4 0 1 0 16.6 12Z", false, KitFill.INK),
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
      KitShape("M4.5 14.5V12a7.5 7.5 0 0 1 15 0v2.5", true, KitFill.NONE),
      KitShape("M4.5 14.5h1.6c.8 0 1.4.6 1.4 1.4v3.2c0 .8-.6 1.4-1.4 1.4h-.2c-.8 0-1.4-.6-1.4-1.4z", true, KitFill.NONE),
      KitShape("M19.5 14.5h-1.6c-.8 0-1.4.6-1.4 1.4v3.2c0 .8.6 1.4 1.4 1.4h.2c.8 0 1.4-.6 1.4-1.4z", true, KitFill.NONE),
    ),
  ),
  OBJETO(
    "Objeto",
    listOf(
      KitShape("M3.5 12.5A8.5 8.5 0 1 0 20.5 12.5A8.5 8.5 0 1 0 3.5 12.5Z", true, KitFill.NONE),
      KitShape("M9 13.4A3 3 0 1 0 15 13.4A3 3 0 1 0 9 13.4Z", true, KitFill.NONE),
      KitShape("M10.9 6.9A1.1 1.1 0 1 0 13.1 6.9A1.1 1.1 0 1 0 10.9 6.9Z", false, KitFill.INK),
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
  /** D-162: el colgador: las sugerencias son de ropa; la caja se leía «archivar». */
  ORDENAR(
    "Ordenar",
    listOf(
      KitShape("M10.2 6.2A1.8 1.8 0 1 1 12 8V9.3", true, KitFill.NONE),
      KitShape("M12 9.3L3.7 15.5C2.9 16.1 3.3 17.5 4.4 17.5H19.6C20.7 17.5 21.1 16.1 20.3 15.5Z", true, KitFill.NONE),
    ),
  ),
  PARLANTE(
    "Parlante",
    listOf(
      KitShape("M9 3H15A3 3 0 0 1 18 6V18A3 3 0 0 1 15 21H9A3 3 0 0 1 6 18V6A3 3 0 0 1 9 3Z", true, KitFill.NONE),
      KitShape("M8.9 14.4A3.1 3.1 0 1 0 15.1 14.4A3.1 3.1 0 1 0 8.9 14.4Z", true, KitFill.NONE),
      KitShape("M11 7.5A1 1 0 1 0 13 7.5A1 1 0 1 0 11 7.5Z", false, KitFill.INK),
    ),
  ),
  PAUSAR(
    "Pausar",
    listOf(
      KitShape("M9 6.2v11.6M15 6.2v11.6", true, KitFill.NONE),
    ),
  ),
  PERFIL(
    "Perfil",
    listOf(
      KitShape("M8.1 8.4A3.9 3.9 0 1 0 15.9 8.4A3.9 3.9 0 1 0 8.1 8.4Z", true, KitFill.NONE),
      KitShape("M4.5 20.5c.8-3.8 3.8-6 7.5-6s6.7 2.2 7.5 6", true, KitFill.NONE),
    ),
  ),
  PERMISO(
    "Permiso",
    listOf(
      KitShape("M12 3.5l7 2.7v5.1c0 4.4-2.9 8-7 9.2-4.1-1.2-7-4.8-7-9.2V6.2z", true, KitFill.NONE),
      KitShape("M9 12l2.2 2.2 3.8-4", true, KitFill.NONE),
    ),
  ),
  PINTAR(
    "Pintar",
    listOf(
      KitShape("M20 4c-.9-.9-2.3-.9-3.2 0L10 10.8l3.2 3.2L20 7.2c.9-.9.9-2.3 0-3.2z", true, KitFill.NONE),
      KitShape("M10 10.8c-2.3-.4-4.1 1.2-4.3 3.5-.1 1.6-.8 2.8-2.2 3.5 3.3 1.3 7.3.8 8.8-2.3.6-1.4.4-1.9.9-1.5", true, KitFill.NONE),
    ),
  ),
  PLANTAS(
    "Cuidar las plantas",
    listOf(
      KitShape("M6.8 14h10.4l-1.3 5.3a1.5 1.5 0 0 1-1.5 1.2H9.6a1.5 1.5 0 0 1-1.5-1.2z", true, KitFill.NONE),
      KitShape("M12 14V9.3", true, KitFill.NONE),
      KitShape("M12 10.2C12 7.4 10.1 5.7 7 5.7c0 2.8 1.9 4.5 5 4.5z", true, KitFill.NONE),
      KitShape("M12 9.3c0-2.5 1.7-4 4.6-4 0 2.5-1.7 4-4.6 4z", true, KitFill.NONE),
    ),
  ),
  PRIMER_PASO(
    "Cómo empieza",
    listOf(
      KitShape("M3.5 20H8v-4.5h4.5V11H17V6.5h3.5", true, KitFill.NONE),
      KitShape("M4.25 17.1A1.35 1.35 0 1 0 6.95 17.1A1.35 1.35 0 1 0 4.25 17.1Z", false, KitFill.INK),
    ),
  ),
  PRIVACIDAD(
    "Privacidad",
    listOf(
      KitShape("M7.6 10.5H16.4A2.6 2.6 0 0 1 19 13.1V17.9A2.6 2.6 0 0 1 16.4 20.5H7.6A2.6 2.6 0 0 1 5 17.9V13.1A2.6 2.6 0 0 1 7.6 10.5Z", true, KitFill.NONE),
      KitShape("M8 10.5V8a4 4 0 0 1 8 0v2.5", true, KitFill.NONE),
      KitShape("M12 14.4v2.2", true, KitFill.NONE),
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
      KitShape("M19.5 12a7.5 7.5 0 1 1-2.2-5.3", true, KitFill.NONE),
      KitShape("M19.6 4.2v3.6H16", true, KitFill.NONE),
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
      KitShape("M8 6.3c0-.9 1-1.4 1.7-.9l8.4 5.7c.6.4.6 1.4 0 1.8l-8.4 5.7c-.7.5-1.7 0-1.7-.9z", true, KitFill.NONE),
    ),
  ),
  SALIR(
    "Salir",
    listOf(
      KitShape("M8.3 16.4c.6-2.6 2-3.9 3.7-3.9s3.1 1.3 3.7 3.9c.4 1.9-.8 3.6-2.6 3.6h-2.2c-1.8 0-3-1.7-2.6-3.6z", true, KitFill.NONE),
      KitShape("M4.2 10.9A1.7 1.7 0 1 0 7.6 10.9A1.7 1.7 0 1 0 4.2 10.9Z", true, KitFill.NONE),
      KitShape("M7.7 6.9A1.8 1.8 0 1 0 11.3 6.9A1.8 1.8 0 1 0 7.7 6.9Z", true, KitFill.NONE),
      KitShape("M12.7 6.9A1.8 1.8 0 1 0 16.3 6.9A1.8 1.8 0 1 0 12.7 6.9Z", true, KitFill.NONE),
      KitShape("M16.4 10.9A1.7 1.7 0 1 0 19.8 10.9A1.7 1.7 0 1 0 16.4 10.9Z", true, KitFill.NONE),
    ),
  ),
  SIGUIENTE(
    "Siguiente",
    listOf(
      KitShape("M4.5 12h15M14 6.5l5.5 5.5-5.5 5.5", true, KitFill.NONE),
    ),
  ),
  SILENCIAR(
    "Silenciar",
    listOf(
      KitShape("M3 12.5A6 6 0 1 0 15 12.5A6 6 0 1 0 3 12.5Z", true, KitFill.NONE),
      KitShape("M6.9 13.2A2.1 2.1 0 1 0 11.1 13.2A2.1 2.1 0 1 0 6.9 13.2Z", true, KitFill.NONE),
      KitShape("M8.1 8.4A0.9 0.9 0 1 0 9.9 8.4A0.9 0.9 0 1 0 8.1 8.4Z", false, KitFill.INK),
      KitShape("M16.5 10l4.5 4.5M21 10l-4.5 4.5", true, KitFill.NONE),
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
      KitShape("M9.3 3H14.7A2.8 2.8 0 0 1 17.5 5.8V18.2A2.8 2.8 0 0 1 14.7 21H9.3A2.8 2.8 0 0 1 6.5 18.2V5.8A2.8 2.8 0 0 1 9.3 3Z", true, KitFill.NONE),
      KitShape("M10.5 18h3", true, KitFill.NONE),
    ),
  ),
  /** D-162: el signo de contraste; los destellos se leían como inteligencia artificial. */
  TEMA(
    "Tema claro u oscuro",
    listOf(
      KitShape("M3.5 12A8.5 8.5 0 1 0 20.5 12A8.5 8.5 0 1 0 3.5 12Z", true, KitFill.NONE),
      KitShape("M12 3.5A8.5 8.5 0 0 1 12 20.5Z", false, KitFill.INK),
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
      KitShape("M4.5 13.5A7.5 7.5 0 1 0 19.5 13.5A7.5 7.5 0 1 0 4.5 13.5Z", true, KitFill.NONE),
      KitShape("M10 3.5h4M12 3.5V6", true, KitFill.NONE),
      KitShape("M12 9.6v3.9l2.6 1.7", true, KitFill.NONE),
      KitShape("M18.3 7.2l1.2-1.2", true, KitFill.NONE),
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
      KitShape("M19.5 12h-15M10 6.5L4.5 12l5.5 5.5", true, KitFill.NONE),
    ),
  ),
  SUENA(
    "Suena",
    listOf(
      KitShape("M3 12.5A6 6 0 1 0 15 12.5A6 6 0 1 0 3 12.5Z", true, KitFill.NONE),
      KitShape("M6.9 13.2A2.1 2.1 0 1 0 11.1 13.2A2.1 2.1 0 1 0 6.9 13.2Z", true, KitFill.NONE),
      KitShape("M8.1 8.4A0.9 0.9 0 1 0 9.9 8.4A0.9 0.9 0 1 0 8.1 8.4Z", false, KitFill.INK),
      KitShape("M16.4 9.3a4.6 4.6 0 0 1 0 6.4", true, KitFill.NONE),
      KitShape("M19 6.5a9 9 0 0 1 0 12", true, KitFill.NONE),
    ),
  ),
  RUTA(
    "Ruta",
    listOf(
      KitShape("M3.5 20H8v-4.5h4.5V11H17V6.5h3.5", true, KitFill.NONE),
      KitShape("M4.25 17.1A1.35 1.35 0 1 0 6.95 17.1A1.35 1.35 0 1 0 4.25 17.1Z", false, KitFill.INK),
    ),
  ),
  /** 3.2: tu semana, en barras. */
  AVANCE(
    "Avance",
    listOf(KitShape("M5 20v-6M10 20V9M15 20v-4M20 20V5", true, KitFill.NONE)),
  ),
  /** 3.2: abrir una fila, el galón de las listas. */
  ABRIR(
    "Abrir",
    listOf(KitShape("M9.5 5.5l6.5 6.5-6.5 6.5", true, KitFill.NONE)),
  ),
  /** 4.0 (D-155): la tuerca de los ajustes, en Perfil. Ocho dientes y el centro abierto. */
  TUERCA(
    "Ajustes",
    listOf(
      KitShape("M10.28 5.37L10.75 3.09A9 9 0 0 1 13.25 3.09L13.72 5.37A6.85 6.85 0 0 1 15.48 6.1L17.42 4.81A9 9 0 0 1 19.19 6.58L17.9 8.52A6.85 6.85 0 0 1 18.63 10.28L20.91 10.75A9 9 0 0 1 20.91 13.25L18.63 13.72A6.85 6.85 0 0 1 17.9 15.48L19.19 17.42A9 9 0 0 1 17.42 19.19L15.48 17.9A6.85 6.85 0 0 1 13.72 18.63L13.25 20.91A9 9 0 0 1 10.75 20.91L10.28 18.63A6.85 6.85 0 0 1 8.52 17.9L6.58 19.19A9 9 0 0 1 4.81 17.42L6.1 15.48A6.85 6.85 0 0 1 5.37 13.72L3.09 13.25A9 9 0 0 1 3.09 10.75L5.37 10.28A6.85 6.85 0 0 1 6.1 8.52L4.81 6.58A9 9 0 0 1 6.58 4.81L8.52 6.1A6.85 6.85 0 0 1 10.28 5.37Z", true, KitFill.NONE),
      KitShape("M9.1 12A2.9 2.9 0 1 0 14.9 12A2.9 2.9 0 1 0 9.1 12Z", true, KitFill.NONE),
    ),
  ),
  /** 4.0 (D-155): la pestaña Actividades, cuatro anillos como su cuadrícula. */
  ACTIVIDADES(
    "Actividades",
    listOf(
      KitShape("M4.1 7.6A3.5 3.5 0 1 0 11.1 7.6A3.5 3.5 0 1 0 4.1 7.6Z", true, KitFill.NONE),
      KitShape("M12.9 7.6A3.5 3.5 0 1 0 19.9 7.6A3.5 3.5 0 1 0 12.9 7.6Z", true, KitFill.NONE),
      KitShape("M4.1 16.4A3.5 3.5 0 1 0 11.1 16.4A3.5 3.5 0 1 0 4.1 16.4Z", true, KitFill.NONE),
      KitShape("M12.9 16.4A3.5 3.5 0 1 0 19.9 16.4A3.5 3.5 0 1 0 12.9 16.4Z", true, KitFill.NONE),
    ),
  ),
  // 4.3 (D-158): trece íconos nuevos para las actividades, dibujados con la misma retícula de 24 y trazo
  // redondeado; sus SVG están en 10_recursos_visuales/marca-a-tiempo/iconos.
  /** D-162: orejas separadas y sin boca, legible a 17 px. */
  PERRO(
    "Perro",
    listOf(
      KitShape("M8.5 9.6C8.5 7.4 10 5.7 12 5.7S15.5 7.4 15.5 9.6V14.4C15.5 16.8 14 18.6 12 18.6S8.5 16.8 8.5 14.4Z", true, KitFill.NONE),
      KitShape("M8.1 6.4C6 5.9 4.2 7.1 3.8 9.4C3.5 11.3 3.9 13 4.9 13.7C5.6 14.2 6.4 13.9 6.6 13.1L7 11.5", true, KitFill.NONE),
      KitShape("M15.9 6.4C18 5.9 19.8 7.1 20.2 9.4C20.5 11.3 20.1 13 19.1 13.7C18.4 14.2 17.6 13.9 17.4 13.1L17 11.5", true, KitFill.NONE),
      KitShape("M10.6 15.1A1.4 1.1 0 1 0 13.4 15.1A1.4 1.1 0 1 0 10.6 15.1Z", false, KitFill.INK),
      KitShape("M9.8 10.8A.8 .8 0 1 0 11.4 10.8A.8 .8 0 1 0 9.8 10.8Z", false, KitFill.INK),
      KitShape("M12.6 10.8A.8 .8 0 1 0 14.2 10.8A.8 .8 0 1 0 12.6 10.8Z", false, KitFill.INK),
    ),
  ),
  CORRER(
    "Correr",
    listOf(
      KitShape("M3.5 18.2v-7.8c0-.6.6-1.1 1.2-.9l2.7.9c.5.2 1.1 0 1.4-.4l1.3-1.9c.3-.4.9-.5 1.3-.2l2 1.3c2.2 1.5 4.8 2.5 7.3 2.9.7.1 1.3.7 1.3 1.4v4.7z", true, KitFill.NONE),
      KitShape("M3.5 14.9h17", true, KitFill.NONE),
      KitShape("M11.4 10.6l1 1", true, KitFill.NONE),
      KitShape("M13.6 11.9l.9 1", true, KitFill.NONE),
    ),
  ),
  NADAR(
    "Nadar",
    listOf(
      KitShape("M3 15.8c1.5 0 1.5 1 3 1s1.5-1 3-1 1.5 1 3 1 1.5-1 3-1 1.5 1 3 1 1.5-1 3-1", true, KitFill.NONE),
      KitShape("M3 19.3c1.5 0 1.5 1 3 1s1.5-1 3-1 1.5 1 3 1 1.5-1 3-1 1.5 1 3 1 1.5-1 3-1", true, KitFill.NONE),
      KitShape("M14.2 7.6a1.9 1.9 0 1 0 3.8 0a1.9 1.9 0 1 0 -3.8 0z", true, KitFill.NONE),
      KitShape("M5.5 12.6l4.4-3.4c.5-.4 1.2-.4 1.7 0l3.7 3.4", true, KitFill.NONE),
    ),
  ),
  PELOTA(
    "Pelota",
    listOf(
      KitShape("M3.5 12a8.5 8.5 0 1 0 17 0a8.5 8.5 0 1 0 -17 0z", true, KitFill.NONE),
      KitShape("M12 8.7l3 2.2-1.1 3.5h-3.8L9 10.9z", true, KitFill.NONE),
      KitShape("M12 8.7V3.6M15 10.9l4.6-1.6M13.9 14.4l2.8 3.9M10.1 14.4l-2.8 3.9M9 10.9L4.4 9.3", true, KitFill.NONE),
    ),
  ),
  PELICULA(
    "Ver una película",
    listOf(
      KitShape("M3.5 10h17v8.5c0 .8-.7 1.5-1.5 1.5H5c-.8 0-1.5-.7-1.5-1.5z", true, KitFill.NONE),
      KitShape("M3.5 10V6.5C3.5 5.7 4.2 5 5 5h14c.8 0 1.5.7 1.5 1.5V10", true, KitFill.NONE),
      KitShape("M8.5 5L7 10M13 5l-1.5 5M17.5 5L16 10", true, KitFill.NONE),
    ),
  ),
  /** D-162: un tomo con un globo de diálogo, legible a 17 px. */
  MANGA(
    "Leer manga",
    listOf(
      KitShape("M7 3.5H17.5A1.5 1.5 0 0 1 19 5V19A1.5 1.5 0 0 1 17.5 20.5H7A2 2 0 0 1 5 18.5V5.5A2 2 0 0 1 7 3.5Z", true, KitFill.NONE),
      KitShape("M8.5 3.5V20.5", true, KitFill.NONE),
      KitShape("M12 7.5H15.5A1.5 1.5 0 0 1 17 9V10.5A1.5 1.5 0 0 1 15.5 12H13.6L12 13.6V12A1.5 1.5 0 0 1 10.5 10.5V9A1.5 1.5 0 0 1 12 7.5Z", true, KitFill.NONE),
    ),
  ),
  /** D-162: una pieza para armar; el cubo se leía «paquete». */
  MAQUETA(
    "Armar una maqueta",
    listOf(
      KitShape("M5.5 10.5H18.5A2 2 0 0 1 20.5 12.5V17.5A2 2 0 0 1 18.5 19.5H5.5A2 2 0 0 1 3.5 17.5V12.5A2 2 0 0 1 5.5 10.5Z", true, KitFill.NONE),
      KitShape("M6.5 10.5V8.5A1 1 0 0 1 7.5 7.5H10.5A1 1 0 0 1 11.5 8.5V10.5", true, KitFill.NONE),
      KitShape("M12.5 10.5V8.5A1 1 0 0 1 13.5 7.5H16.5A1 1 0 0 1 17.5 8.5V10.5", true, KitFill.NONE),
    ),
  ),
  /** D-162: dos hebras en vez de tres, legible a 17 px. */
  TEJER(
    "Tejer o coser",
    listOf(
      KitShape("M4 14A6.2 6.2 0 1 0 16.4 14A6.2 6.2 0 1 0 4 14Z", true, KitFill.NONE),
      KitShape("M5.2 11.3C7.8 10.9 11.6 12.1 14.8 15.5", true, KitFill.NONE),
      KitShape("M7.6 8.6C10.3 9.5 13 11.8 15 15", true, KitFill.NONE),
      KitShape("M14.6 9.4L20.5 3.5", true, KitFill.NONE),
    ),
  ),
  PIANO(
    "Tocar el piano",
    listOf(
      KitShape("M3.5 6.5h17v11c0 .8-.7 1.5-1.5 1.5H5c-.8 0-1.5-.7-1.5-1.5z", true, KitFill.NONE),
      KitShape("M8.2 13.2V19M12 13.2V19M15.8 13.2V19", true, KitFill.NONE),
      KitShape("M7 6.5h2.4v6.7H7zM10.8 6.5h2.4v6.7h-2.4zM14.6 6.5H17v6.7h-2.4z", false, KitFill.INK),
    ),
  ),
  MEDITAR(
    "Meditar",
    listOf(
      KitShape("M12 6.3c1.8 1.6 2.7 3.6 2.7 5.8S13.8 16.3 12 17.9c-1.8-1.6-2.7-3.6-2.7-5.8S10.2 7.9 12 6.3z", true, KitFill.NONE),
      KitShape("M12 17.9c-3.3-.1-6.2-2.3-7.5-5.5 1.9-.3 3.6.1 5 .8", true, KitFill.NONE),
      KitShape("M12 17.9c3.3-.1 6.2-2.3 7.5-5.5-1.9-.3-3.6.1-5 .8", true, KitFill.NONE),
      KitShape("M7.5 20.5h9", true, KitFill.NONE),
    ),
  ),
  /** D-162: dos globos sin línea interior, legible a 17 px. */
  IDIOMAS(
    "Aprender un idioma",
    listOf(
      KitShape("M4.5 3.5H12A1.5 1.5 0 0 1 13.5 5V11A1.5 1.5 0 0 1 12 12.5H8.2L5.5 14.8V12.5H4.5A1.5 1.5 0 0 1 3 11V5A1.5 1.5 0 0 1 4.5 3.5Z", true, KitFill.NONE),
      KitShape("M6.3 10.3L8.25 5.7L10.2 10.3M7 8.8H9.5", true, KitFill.NONE),
      KitShape("M15.5 9H19.5A1.5 1.5 0 0 1 21 10.5V16.5A1.5 1.5 0 0 1 19.5 18H18.5V20.3L15.8 18H12A1.5 1.5 0 0 1 10.5 16.5V14.5", true, KitFill.NONE),
    ),
  ),
  CARTAS(
    "Jugar a las cartas",
    listOf(
      KitShape("M9.5 6.5h8c.8 0 1.5.7 1.5 1.5v11c0 .8-.7 1.5-1.5 1.5h-8c-.8 0-1.5-.7-1.5-1.5V8c0-.8.7-1.5 1.5-1.5z", true, KitFill.NONE),
      KitShape("M8 16.5H6.5c-.8 0-1.5-.7-1.5-1.5V5c0-.8.7-1.5 1.5-1.5h8c.8 0 1.5.7 1.5 1.5v1.5", true, KitFill.NONE),
      KitShape("M13.5 10.6l2 2.5-2 2.5-2-2.5z", true, KitFill.NONE),
    ),
  ),
  COMPARTIR(
    "Con otras personas",
    listOf(
      KitShape("M6.3 8.2a2.6 2.6 0 1 0 5.2 0a2.6 2.6 0 1 0 -5.2 0z", true, KitFill.NONE),
      KitShape("M3.8 19.5c0-3.1 2.3-5.6 5.1-5.6s5.1 2.5 5.1 5.6", true, KitFill.NONE),
      KitShape("M14.6 7.6a2.3 2.3 0 1 0 4.6 0a2.3 2.3 0 1 0 -4.6 0z", true, KitFill.NONE),
      KitShape("M15.6 13.7c.4-.1.9-.2 1.3-.2 2.6 0 4.6 2.4 4.6 5.4", true, KitFill.NONE),
    ),
  ),
  /** D-162: un relevo sin respuesta: círculo punteado, sin juicio; usaba el gráfico de Historial. */
  SIN_RESPUESTA(
    "Sin respuesta",
    listOf(
      KitShape("M20.89 13.41A9 9 0 0 1 19.28 17.29M17.29 19.28A9 9 0 0 1 13.41 20.89M10.59 20.89A9 9 0 0 1 6.71 19.28M4.72 17.29A9 9 0 0 1 3.11 13.41M3.11 10.59A9 9 0 0 1 4.72 6.71M6.71 4.72A9 9 0 0 1 10.59 3.11M13.41 3.11A9 9 0 0 1 17.29 4.72M19.28 6.71A9 9 0 0 1 20.89 10.59", true, KitFill.NONE),
    ),
  ),
}
