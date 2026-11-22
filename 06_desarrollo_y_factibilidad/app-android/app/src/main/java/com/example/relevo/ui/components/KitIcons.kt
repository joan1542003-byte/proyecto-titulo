package com.example.relevo.ui.components

// Generado por 10_recursos_visuales/iconos-lucide/generar_kiticons.py desde mapeo.json (D-187).
// Los íconos salen de Lucide 1.70.0 (https://lucide.dev), tal cual, adaptados o dibujados
// con sus reglas cuando Lucide no tiene lo que la persona hace. Retícula de 24, trazo redondeado; el grosor
// lo pone la app según el tamaño (D-124). No se edita a mano: se cambia mapeo.json o un SVG y se vuelve a generar.
//
// Lucide: ISC License, Copyright (c) 2026 Lucide Icons and Contributors. Los íconos que vienen de Feather
// tienen además la MIT License, Copyright (c) 2013-present Cole Bemis. El texto completo de ambas está en
// app/licenses/LUCIDE_LICENSE.md y en app/src/main/assets/licencias/LUCIDE_LICENSE.txt.

internal enum class KitFill { NONE, INK, PAPER }

internal class KitShape(val pathData: String, val stroke: Boolean, val fill: KitFill)

/** Íconos de Relevo (D-187): de Lucide, adaptados o propios. [label] es su nombre accesible; en pantalla siempre van con una palabra. */
enum class KitIcon(val label: String, internal val shapes: List<KitShape>) {
  /** Lucide «accessibility». */
  ACCESIBILIDAD(
    "Accesibilidad",
    listOf(
      KitShape("M15 4A1 1 0 1 0 17 4A1 1 0 1 0 15 4Z", true, KitFill.NONE),
      KitShape("m18 19 1 -7 -6 1", true, KitFill.NONE),
      KitShape("m5 8 3 -3 5.5 3 -2.36 3.5", true, KitFill.NONE),
      KitShape("M4.24 14.5a5 5 0 0 0 6.88 6", true, KitFill.NONE),
      KitShape("M13.76 17.5a5 5 0 0 0 -6.88 -6", true, KitFill.NONE),
    ),
  ),
  /** Lucide «shapes». Las formas de base: una actividad cualquiera (D-162). */
  ACTIVIDAD(
    "Actividad",
    listOf(
      KitShape("M8.3 10a0.7 0.7 0 0 1 -0.626 -1.079L11.4 3a0.7 0.7 0 0 1 1.198 -0.043L16.3 8.9a0.7 0.7 0 0 1 -0.572 1.1Z", true, KitFill.NONE),
      KitShape("M4 14H9A1 1 0 0 1 10 15V20A1 1 0 0 1 9 21H4A1 1 0 0 1 3 20V15A1 1 0 0 1 4 14Z", true, KitFill.NONE),
      KitShape("M14 17.5A3.5 3.5 0 1 0 21 17.5A3.5 3.5 0 1 0 14 17.5Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «triangle-alert». */
  ADVERTENCIA(
    "Advertencia",
    listOf(
      KitShape("m21.73 18 -8 -14a2 2 0 0 0 -3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73 -3", true, KitFill.NONE),
      KitShape("M12 9v4", true, KitFill.NONE),
      KitShape("M12 17h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «plus». */
  AGREGAR(
    "Agregar",
    listOf(
      KitShape("M5 12h14", true, KitFill.NONE),
      KitShape("M12 5v14", true, KitFill.NONE),
    ),
  ),
  /** Lucide «sliders-horizontal». */
  AJUSTES(
    "Ajustes",
    listOf(
      KitShape("M10 5H3", true, KitFill.NONE),
      KitShape("M12 19H3", true, KitFill.NONE),
      KitShape("M14 3v4", true, KitFill.NONE),
      KitShape("M16 17v4", true, KitFill.NONE),
      KitShape("M21 12h-9", true, KitFill.NONE),
      KitShape("M21 19h-5", true, KitFill.NONE),
      KitShape("M21 5h-7", true, KitFill.NONE),
      KitShape("M8 10v4", true, KitFill.NONE),
      KitShape("M8 12H3", true, KitFill.NONE),
    ),
  ),
  /** Lucide «layout-grid». */
  APPS(
    "Apps elegidas",
    listOf(
      KitShape("M4 3H9A1 1 0 0 1 10 4V9A1 1 0 0 1 9 10H4A1 1 0 0 1 3 9V4A1 1 0 0 1 4 3Z", true, KitFill.NONE),
      KitShape("M15 3H20A1 1 0 0 1 21 4V9A1 1 0 0 1 20 10H15A1 1 0 0 1 14 9V4A1 1 0 0 1 15 3Z", true, KitFill.NONE),
      KitShape("M15 14H20A1 1 0 0 1 21 15V20A1 1 0 0 1 20 21H15A1 1 0 0 1 14 20V15A1 1 0 0 1 15 14Z", true, KitFill.NONE),
      KitShape("M4 14H9A1 1 0 0 1 10 15V20A1 1 0 0 1 9 21H4A1 1 0 0 1 3 20V15A1 1 0 0 1 4 14Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «bell». */
  AVISOS(
    "Avisos del teléfono",
    listOf(
      KitShape("M10.268 21a2 2 0 0 0 3.464 0", true, KitFill.NONE),
      KitShape("M3.262 15.326A1 1 0 0 0 4 17h16a1 1 0 0 0 0.74 -1.673C19.41 13.956 18 12.499 18 8A6 6 0 0 0 6 8c0 4.499 -1.411 5.956 -2.738 7.326", true, KitFill.NONE),
    ),
  ),
  /** Lucide «circle-question-mark». */
  AYUDA(
    "Ayuda",
    listOf(
      KitShape("M2 12A10 10 0 1 0 22 12A10 10 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("M9.09 9a3 3 0 0 1 5.83 1c0 2 -3 3 -3 3", true, KitFill.NONE),
      KitShape("M12 17h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «battery-medium». */
  BATERIA(
    "Batería del objeto",
    listOf(
      KitShape("M10 14v-4", true, KitFill.NONE),
      KitShape("M22 14v-4", true, KitFill.NONE),
      KitShape("M6 14v-4", true, KitFill.NONE),
      KitShape("M4 6H16A2 2 0 0 1 18 8V16A2 2 0 0 1 16 18H4A2 2 0 0 1 2 16V8A2 2 0 0 1 4 6Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «bike». */
  BICICLETA(
    "Andar en bicicleta",
    listOf(
      KitShape("M15 17.5A3.5 3.5 0 1 0 22 17.5A3.5 3.5 0 1 0 15 17.5Z", true, KitFill.NONE),
      KitShape("M2 17.5A3.5 3.5 0 1 0 9 17.5A3.5 3.5 0 1 0 2 17.5Z", true, KitFill.NONE),
      KitShape("M14 5A1 1 0 1 0 16 5A1 1 0 1 0 14 5Z", true, KitFill.NONE),
      KitShape("M12 17.5V14l-3 -3 4 -3 2 3h2", true, KitFill.NONE),
    ),
  ),
  /** Lucide «trash-2». */
  BORRAR(
    "Borrar",
    listOf(
      KitShape("M10 11v6", true, KitFill.NONE),
      KitShape("M14 11v6", true, KitFill.NONE),
      KitShape("M19 6v14a2 2 0 0 1 -2 2H7a2 2 0 0 1 -2 -2V6", true, KitFill.NONE),
      KitShape("M3 6h18", true, KitFill.NONE),
      KitShape("M8 6V4a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v2", true, KitFill.NONE),
    ),
  ),
  /** Lucide «search». */
  BUSCAR(
    "Buscar",
    listOf(
      KitShape("m21 21 -4.34 -4.34", true, KitFill.NONE),
      KitShape("M3 11A8 8 0 1 0 19 11A8 8 0 1 0 3 11Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «calendar». */
  CALENDARIO(
    "Calendario",
    listOf(
      KitShape("M8 2v3", true, KitFill.NONE),
      KitShape("M16 2v3", true, KitFill.NONE),
      KitShape("M5 3H19A2 2 0 0 1 21 5V19A2 2 0 0 1 19 21H5A2 2 0 0 1 3 19V5A2 2 0 0 1 5 3Z", true, KitFill.NONE),
      KitShape("M3 9h18", true, KitFill.NONE),
    ),
  ),
  /** Lucide «arrow-right-left». Las mismas flechas opuestas de antes. */
  CAMBIE(
    "Cambié de idea",
    listOf(
      KitShape("m16 3 4 4 -4 4", true, KitFill.NONE),
      KitShape("M20 7H4", true, KitFill.NONE),
      KitShape("m8 21 -4 -4 4 -4", true, KitFill.NONE),
      KitShape("M4 17h16", true, KitFill.NONE),
    ),
  ),
  /** Lucide «footprints». */
  CAMINAR(
    "Caminar",
    listOf(
      KitShape("M4 16v-2.38C4 11.5 2.97 10.5 3 8c0.03 -2.72 1.49 -6 4.5 -6C9.37 2 10 3.8 10 5.5c0 3.11 -2 5.66 -2 8.68V16a2 2 0 1 1 -4 0Z", true, KitFill.NONE),
      KitShape("M20 20v-2.38c0 -2.12 1.03 -3.12 1 -5.62 -0.03 -2.72 -1.49 -6 -4.5 -6C14.63 6 14 7.8 14 9.5c0 3.11 2 5.66 2 8.68V20a2 2 0 1 0 4 0Z", true, KitFill.NONE),
      KitShape("M16 17h4", true, KitFill.NONE),
      KitShape("M4 13h4", true, KitFill.NONE),
    ),
  ),
  /** Lucide «mail». */
  CARTA(
    "Escribirle a alguien",
    listOf(
      KitShape("m22 7 -8.991 5.727a2 2 0 0 1 -2.009 0L2 7", true, KitFill.NONE),
      KitShape("M4 4H20A2 2 0 0 1 22 6V18A2 2 0 0 1 20 20H4A2 2 0 0 1 2 18V6A2 2 0 0 1 4 4Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «log-out». */
  CERRAR_SESION(
    "Cerrar sesión",
    listOf(
      KitShape("m16 17 5 -5 -5 -5", true, KitFill.NONE),
      KitShape("M21 12H9", true, KitFill.NONE),
      KitShape("M9 21H5a2 2 0 0 1 -2 -2V5a2 2 0 0 1 2 -2h4", true, KitFill.NONE),
    ),
  ),
  /** Lucide «x». */
  CERRAR(
    "Cerrar",
    listOf(
      KitShape("M18 6 6 18", true, KitFill.NONE),
      KitShape("m6 6 12 12", true, KitFill.NONE),
    ),
  ),
  /** Lucide «cooking-pot». */
  COCINAR(
    "Cocinar",
    listOf(
      KitShape("M2 12h20", true, KitFill.NONE),
      KitShape("M20 12v8a2 2 0 0 1 -2 2H6a2 2 0 0 1 -2 -2v-8", true, KitFill.NONE),
      KitShape("m4 8 16 -4", true, KitFill.NONE),
      KitShape("m8.86 6.78 -0.45 -1.81a2 2 0 0 1 1.45 -2.43l1.94 -0.48a2 2 0 0 1 2.43 1.46l0.45 1.8", true, KitFill.NONE),
    ),
  ),
  /** Lucide «hash». */
  CODIGO(
    "Código de participante",
    listOf(
      KitShape("M4 9L20 9", true, KitFill.NONE),
      KitShape("M4 15L20 15", true, KitFill.NONE),
      KitShape("M10 3L8 21", true, KitFill.NONE),
      KitShape("M16 3L14 21", true, KitFill.NONE),
    ),
  ),
  /** Lucide «circle-play». */
  COMENCE(
    "Comencé",
    listOf(
      KitShape("M9 9.003a1 1 0 0 1 1.517 -0.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997A1 1 0 0 1 9 14.996z", true, KitFill.NONE),
      KitShape("M2 12A10 10 0 1 0 22 12A10 10 0 1 0 2 12Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «message-square». */
  COMENTARIO(
    "Comentario",
    listOf(
      KitShape("M22 17a2 2 0 0 1 -2 2H6.828a2 2 0 0 0 -1.414 0.586l-2.202 2.202A0.71 0.71 0 0 1 2 21.286V5a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «bluetooth». */
  CONEXION(
    "Conexión",
    listOf(
      KitShape("m7 7 10 10 -5 5V2l5 5L7 17", true, KitFill.NONE),
    ),
  ),
  /** Lucide «file-check». */
  CONSENTIMIENTO(
    "Consentimiento",
    listOf(
      KitShape("M6 22a2 2 0 0 1 -2 -2V4a2 2 0 0 1 2 -2h8a2.4 2.4 0 0 1 1.704 0.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1 -2 2z", true, KitFill.NONE),
      KitShape("M14 2v5a1 1 0 0 0 1 1h5", true, KitFill.NONE),
      KitShape("m9 15 2 2 4 -4", true, KitFill.NONE),
    ),
  ),
  /** Lucide «chevron-up». */
  CONTRAER(
    "Contraer",
    listOf(
      KitShape("m18 15 -6 -6 -6 6", true, KitFill.NONE),
    ),
  ),
  /** Lucide «copy». */
  COPIAR(
    "Copiar",
    listOf(
      KitShape("M10 8H20A2 2 0 0 1 22 10V20A2 2 0 0 1 20 22H10A2 2 0 0 1 8 20V10A2 2 0 0 1 10 8Z", true, KitFill.NONE),
      KitShape("M4 16c-1.1 0 -2 -0.9 -2 -2V4c0 -1.1 0.9 -2 2 -2h10c1.1 0 2 0.9 2 2", true, KitFill.NONE),
    ),
  ),
  /** Lucide «clipboard-list». */
  DATOS(
    "Datos del estudio",
    listOf(
      KitShape("M9 2H15A1 1 0 0 1 16 3V5A1 1 0 0 1 15 6H9A1 1 0 0 1 8 5V3A1 1 0 0 1 9 2Z", true, KitFill.NONE),
      KitShape("M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2H6a2 2 0 0 1 -2 -2V6a2 2 0 0 1 2 -2h2", true, KitFill.NONE),
      KitShape("M12 11h4", true, KitFill.NONE),
      KitShape("M12 16h4", true, KitFill.NONE),
      KitShape("M8 11h0.01", true, KitFill.NONE),
      KitShape("M8 16h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «flag». */
  DECISION(
    "Decisión",
    listOf(
      KitShape("M4 22V4a1 1 0 0 1 0.4 -0.8A6 6 0 0 1 8 2c3 0 5 2 7.333 2q2 0 3.067 -0.8A1 1 0 0 1 20 4v10a1 1 0 0 1 -0.4 0.8A6 6 0 0 1 16 16c-3 0 -5 -2 -8 -2a6 6 0 0 0 -4 1.528", true, KitFill.NONE),
    ),
  ),
  /** Lucide «lock-open». */
  DESBLOQUEADO(
    "Acceso abierto",
    listOf(
      KitShape("M5 11H19A2 2 0 0 1 21 13V20A2 2 0 0 1 19 22H5A2 2 0 0 1 3 20V13A2 2 0 0 1 5 11Z", true, KitFill.NONE),
      KitShape("M7 11V7a5 5 0 0 1 9.9 -1", true, KitFill.NONE),
    ),
  ),
  /** Lucide «download». */
  DESCARGAR(
    "Descargar",
    listOf(
      KitShape("M12 15V3", true, KitFill.NONE),
      KitShape("M21 15v4a2 2 0 0 1 -2 2H5a2 2 0 0 1 -2 -2v-4", true, KitFill.NONE),
      KitShape("m7 10 5 5 5 -5", true, KitFill.NONE),
    ),
  ),
  /** Lucide «rotate-cw-clock». El mismo dibujo de antes: un reloj con la flecha hacia adelante. */
  DESPUES(
    "La dejé para después",
    listOf(
      KitShape("M12 7v5l4 2", true, KitFill.NONE),
      KitShape("M16 8h5V3", true, KitFill.NONE),
      KitShape("m21 8 -2.3 -2.3A9.7 9.7 0 0 0 12 3a9 9 0 1 0 9 9", true, KitFill.NONE),
    ),
  ),
  /** Lucide «square». */
  DETENER(
    "Detener",
    listOf(
      KitShape("M5 3H19A2 2 0 0 1 21 5V19A2 2 0 0 1 19 21H5A2 2 0 0 1 3 19V5A2 2 0 0 1 5 3Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «pencil-line». El lápiz con el trazo que deja; Editar es el lápiz solo (D-162). */
  DIBUJAR(
    "Dibujar",
    listOf(
      KitShape("M13 21h8", true, KitFill.NONE),
      KitShape("m15 5 4 4", true, KitFill.NONE),
      KitShape("M21.174 6.812a1 1 0 0 0 -3.986 -3.987L3.842 16.174a2 2 0 0 0 -0.5 0.83l-1.321 4.352a0.5 0.5 0 0 0 0.623 0.622l4.353 -1.32a2 2 0 0 0 0.83 -0.497z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «bed». La cama, el objeto de la actividad. Deja la luna con destello: D-162 evitó los destellos, que se leen como inteligencia artificial. */
  DORMIR(
    "Dormir",
    listOf(
      KitShape("M2 4v16", true, KitFill.NONE),
      KitShape("M2 8h18a2 2 0 0 1 2 2v10", true, KitFill.NONE),
      KitShape("M2 17h20", true, KitFill.NONE),
      KitShape("M6 8v9", true, KitFill.NONE),
    ),
  ),
  /** Lucide «pencil». */
  EDITAR(
    "Editar",
    listOf(
      KitShape("M21.174 6.812a1 1 0 0 0 -3.986 -3.987L3.842 16.174a2 2 0 0 0 -0.5 0.83l-1.321 4.352a0.5 0.5 0 0 0 0.623 0.622l4.353 -1.32a2 2 0 0 0 0.83 -0.497z", true, KitFill.NONE),
      KitShape("m15 5 4 4", true, KitFill.NONE),
    ),
  ),
  /** Lucide «dumbbell». */
  EJERCICIO(
    "Hacer ejercicio",
    listOf(
      KitShape("M17.596 12.768a2 2 0 1 0 2.829 -2.829l-1.768 -1.767a2 2 0 0 0 2.828 -2.829l-2.828 -2.828a2 2 0 0 0 -2.829 2.828l-1.767 -1.768a2 2 0 1 0 -2.829 2.829z", true, KitFill.NONE),
      KitShape("m2.5 21.5 1.4 -1.4", true, KitFill.NONE),
      KitShape("m20.1 3.9 1.4 -1.4", true, KitFill.NONE),
      KitShape("M5.343 21.485a2 2 0 1 0 2.829 -2.828l1.767 1.768a2 2 0 1 0 2.829 -2.829l-6.364 -6.364a2 2 0 1 0 -2.829 2.829l1.768 1.767a2 2 0 0 0 -2.828 2.829z", true, KitFill.NONE),
      KitShape("m9.6 14.4 4.8 -4.8", true, KitFill.NONE),
    ),
  ),
  /** Lucide «external-link». */
  ENLACE_EXTERNO(
    "Abrir fuera de la app",
    listOf(
      KitShape("M15 3h6v6", true, KitFill.NONE),
      KitShape("M10 14 21 3", true, KitFill.NONE),
      KitShape("M18 13v6a2 2 0 0 1 -2 2H5a2 2 0 0 1 -2 -2V8a2 2 0 0 1 2 -2h6", true, KitFill.NONE),
    ),
  ),
  /** Lucide «messages-square». */
  ENTREVISTAS(
    "Entrevistas",
    listOf(
      KitShape("M16 10a2 2 0 0 1 -2 2H6.828a2 2 0 0 0 -1.414 0.586l-2.202 2.202A0.71 0.71 0 0 1 2 14.286V4a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2z", true, KitFill.NONE),
      KitShape("M20 9a2 2 0 0 1 2 2v10.286a0.71 0.71 0 0 1 -1.212 0.502l-2.202 -2.202A2 2 0 0 0 17.172 19H10a2 2 0 0 1 -2 -2v-1", true, KitFill.NONE),
    ),
  ),
  /** Lucide «send». */
  ENVIAR(
    "Enviar",
    listOf(
      KitShape("M14.536 21.686a0.5 0.5 0 0 0 0.937 -0.024l6.5 -19a0.496 0.496 0 0 0 -0.635 -0.635l-19 6.5a0.5 0.5 0 0 0 -0.024 0.937l7.93 3.18a2 2 0 0 1 1.112 1.11z", true, KitFill.NONE),
      KitShape("m21.854 2.147 -10.94 10.939", true, KitFill.NONE),
    ),
  ),
  /** Lucide «circle-x». */
  ERROR(
    "Error",
    listOf(
      KitShape("M2 12A10 10 0 1 0 22 12A10 10 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("m15 9 -6 6", true, KitFill.NONE),
      KitShape("m9 9 6 6", true, KitFill.NONE),
    ),
  ),
  /** Lucide «notebook-pen». «Dejar un lápiz sobre el cuaderno», como sugiere la app. */
  ESCRIBIR(
    "Escribir",
    listOf(
      KitShape("M13.4 2H6a2 2 0 0 0 -2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-7.4", true, KitFill.NONE),
      KitShape("M2 6h4", true, KitFill.NONE),
      KitShape("M2 10h4", true, KitFill.NONE),
      KitShape("M2 14h4", true, KitFill.NONE),
      KitShape("M2 18h4", true, KitFill.NONE),
      KitShape("M21.378 5.626a1 1 0 1 0 -3.004 -3.004l-5.01 5.012a2 2 0 0 0 -0.506 0.854l-0.837 2.87a0.5 0.5 0 0 0 0.62 0.62l2.87 -0.837a2 2 0 0 0 0.854 -0.506z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «hourglass». */
  ESPERANDO(
    "Esperando",
    listOf(
      KitShape("M5 22h14", true, KitFill.NONE),
      KitShape("M5 2h14", true, KitFill.NONE),
      KitShape("M17 22v-4.172a2 2 0 0 0 -0.586 -1.414L12 12l-4.414 4.414A2 2 0 0 0 7 17.828V22", true, KitFill.NONE),
      KitShape("M7 2v4.172a2 2 0 0 0 0.586 1.414L12 12l4.414 -4.414A2 2 0 0 0 17 6.172V2", true, KitFill.NONE),
    ),
  ),
  /** Propio, con las reglas de construcción de Lucide (D-187). La colchoneta a medio desenrollar (D-162). Lucide no tiene colchoneta. */
  ESTIRAR(
    "Estirar",
    listOf(
      KitShape("M2 12A6.5 6.5 0 1 0 15 12A6.5 6.5 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("M11 12a2.5 2.5 0 1 1 -2.5 -2.5", true, KitFill.NONE),
      KitShape("M8.5 18.5H20a2 2 0 0 0 0 -4h-1.5", true, KitFill.NONE),
    ),
  ),
  /** Lucide «star». La estrella de Lucide, rellena. */
  ESTRELLA_LLENA(
    "Estrella llena",
    listOf(
      KitShape("M11.525 2.295a0.53 0.53 0 0 1 0.95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166 0.756a0.53 0.53 0 0 1 0.294 0.904l-3.736 3.638a2.123 2.123 0 0 0 -0.611 1.878l0.882 5.14a0.53 0.53 0 0 1 -0.771 0.56l-4.618 -2.428a2.122 2.122 0 0 0 -1.973 0L6.396 21.01a0.53 0.53 0 0 1 -0.77 -0.56l0.881 -5.139a2.122 2.122 0 0 0 -0.611 -1.879L2.16 9.795a0.53 0.53 0 0 1 0.294 -0.906l5.165 -0.755a2.122 2.122 0 0 0 1.597 -1.16z", true, KitFill.INK),
    ),
  ),
  /** Lucide «star-half». */
  ESTRELLA_MEDIA(
    "Media estrella",
    listOf(
      KitShape("M12 18.338a2.1 2.1 0 0 0 -0.987 0.244L6.396 21.01a0.53 0.53 0 0 1 -0.77 -0.56l0.881 -5.139a2.12 2.12 0 0 0 -0.611 -1.879L2.16 9.795a0.53 0.53 0 0 1 0.294 -0.906l5.165 -0.755a2.12 2.12 0 0 0 1.597 -1.16l2.309 -4.679A0.53 0.53 0 0 1 12 2", true, KitFill.NONE),
    ),
  ),
  /** Lucide «star». */
  ESTRELLA(
    "Estrella vacía",
    listOf(
      KitShape("M11.525 2.295a0.53 0.53 0 0 1 0.95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166 0.756a0.53 0.53 0 0 1 0.294 0.904l-3.736 3.638a2.123 2.123 0 0 0 -0.611 1.878l0.882 5.14a0.53 0.53 0 0 1 -0.771 0.56l-4.618 -2.428a2.122 2.122 0 0 0 -1.973 0L6.396 21.01a0.53 0.53 0 0 1 -0.77 -0.56l0.881 -5.139a2.122 2.122 0 0 0 -0.611 -1.879L2.16 9.795a0.53 0.53 0 0 1 0.294 -0.906l5.165 -0.755a2.122 2.122 0 0 0 1.597 -1.16z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «notebook-text». «Abrir los apuntes», como sugiere la app. */
  ESTUDIAR(
    "Estudiar",
    listOf(
      KitShape("M2 6h4", true, KitFill.NONE),
      KitShape("M2 10h4", true, KitFill.NONE),
      KitShape("M2 14h4", true, KitFill.NONE),
      KitShape("M2 18h4", true, KitFill.NONE),
      KitShape("M6 2H18A2 2 0 0 1 20 4V20A2 2 0 0 1 18 22H6A2 2 0 0 1 4 20V4A2 2 0 0 1 6 2Z", true, KitFill.NONE),
      KitShape("M9.5 8h5", true, KitFill.NONE),
      KitShape("M9.5 12H16", true, KitFill.NONE),
      KitShape("M9.5 16H14", true, KitFill.NONE),
    ),
  ),
  /** Lucide «chevron-down». */
  EXPANDIR(
    "Expandir",
    listOf(
      KitShape("m6 9 6 6 6 -6", true, KitFill.NONE),
    ),
  ),
  /** Lucide «share». */
  EXPORTAR(
    "Exportar o compartir",
    listOf(
      KitShape("M12 2v13", true, KitFill.NONE),
      KitShape("m16 6 -4 -4 -4 4", true, KitFill.NONE),
      KitShape("M4 12v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-8", true, KitFill.NONE),
    ),
  ),
  /** Lucide «funnel». */
  FILTRAR(
    "Filtrar",
    listOf(
      KitShape("M10 20a1 1 0 0 0 0.553 0.895l2 1A1 1 0 0 0 14 21v-7a2 2 0 0 1 0.517 -1.341L21.74 4.67A1 1 0 0 0 21 3H3a1 1 0 0 0 -0.742 1.67l7.225 7.989A2 2 0 0 1 10 14z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «camera». */
  FOTOGRAFIA(
    "Fotografiar",
    listOf(
      KitShape("M13.997 4a2 2 0 0 1 1.76 1.05l0.486 0.9A2 2 0 0 0 18.003 7H20a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2H4a2 2 0 0 1 -2 -2V9a2 2 0 0 1 2 -2h1.997a2 2 0 0 0 1.759 -1.048l0.489 -0.904A2 2 0 0 1 10.004 4z", true, KitFill.NONE),
      KitShape("M9 13A3 3 0 1 0 15 13A3 3 0 1 0 9 13Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «guitar». */
  GUITARRA(
    "Tocar un instrumento",
    listOf(
      KitShape("m11.9 12.1 4.514 -4.514", true, KitFill.NONE),
      KitShape("M20.1 2.3a1 1 0 0 0 -1.4 0l-1.114 1.114A2 2 0 0 0 17 4.828v1.344a2 2 0 0 1 -0.586 1.414A2 2 0 0 1 17.828 7h1.344a2 2 0 0 0 1.414 -0.586L21.7 5.3a1 1 0 0 0 0 -1.4z", true, KitFill.NONE),
      KitShape("m6 16 2 2", true, KitFill.NONE),
      KitShape("M8.23 9.85A3 3 0 0 1 11 8a5 5 0 0 1 5 5 3 3 0 0 1 -1.85 2.77l-0.92 0.38A2 2 0 0 0 12 18a4 4 0 0 1 -4 4 6 6 0 0 1 -6 -6 4 4 0 0 1 4 -4 2 2 0 0 0 1.85 -1.23z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «flask-conical». */
  HIPOTESIS(
    "Hipótesis y prueba",
    listOf(
      KitShape("M14 2v6a2 2 0 0 0 0.245 0.96l5.51 10.08A2 2 0 0 1 18 22H6a2 2 0 0 1 -1.755 -2.96l5.51 -10.08A2 2 0 0 0 10 8V2", true, KitFill.NONE),
      KitShape("M6.453 15h11.094", true, KitFill.NONE),
      KitShape("M8.5 2h7", true, KitFill.NONE),
    ),
  ),
  /** Lucide «history». Sin uso en la app. */
  HISTORIAL(
    "Historial",
    listOf(
      KitShape("M3 12a9 9 0 1 0 9 -9 9.75 9.75 0 0 0 -6.74 2.74L3 8", true, KitFill.NONE),
      KitShape("M3 3v5h5", true, KitFill.NONE),
      KitShape("M12 7v5l4 2", true, KitFill.NONE),
    ),
  ),
  /** Lucide «info». */
  INFO(
    "Información",
    listOf(
      KitShape("M2 12A10 10 0 1 0 22 12A10 10 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("M12 16v-4", true, KitFill.NONE),
      KitShape("M12 8h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «house». */
  INICIO(
    "Inicio",
    listOf(
      KitShape("M15 21v-8a1 1 0 0 0 -1 -1h-4a1 1 0 0 0 -1 1v8", true, KitFill.NONE),
      KitShape("M3 10a2 2 0 0 1 0.709 -1.528l7 -6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1 -2 2H5a2 2 0 0 1 -2 -2z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «file-search». */
  INVESTIGACION(
    "Investigación",
    listOf(
      KitShape("M6 22a2 2 0 0 1 -2 -2V4a2 2 0 0 1 2 -2h8a2.4 2.4 0 0 1 1.704 0.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1 -2 2z", true, KitFill.NONE),
      KitShape("M14 2v5a1 1 0 0 0 1 1h5", true, KitFill.NONE),
      KitShape("M9 14.5A2.5 2.5 0 1 0 14 14.5A2.5 2.5 0 1 0 9 14.5Z", true, KitFill.NONE),
      KitShape("M13.3 16.3 15 18", true, KitFill.NONE),
    ),
  ),
  /** Lucide «dice-3». */
  JUEGO_DE_MESA(
    "Jugar un juego de mesa",
    listOf(
      KitShape("M5 3H19A2 2 0 0 1 21 5V19A2 2 0 0 1 19 21H5A2 2 0 0 1 3 19V5A2 2 0 0 1 5 3Z", true, KitFill.NONE),
      KitShape("M16 8h0.01", true, KitFill.NONE),
      KitShape("M12 12h0.01", true, KitFill.NONE),
      KitShape("M8 16h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «book-open». */
  LEER(
    "Leer",
    listOf(
      KitShape("M12 5v16", true, KitFill.NONE),
      KitShape("M20.001 19A2 2 0 0 0 22 17V5a2 2 0 0 0 -1.999 -2L16 3.002A5 5 0 0 0 12 5a5 5 0 0 0 -4 -2H4a2 2 0 0 0 -2 2v12a2 2 0 0 0 1.999 2H8a5 5 0 0 1 4 2 5 5 0 0 1 4 -2z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «check». */
  LISTO(
    "Listo",
    listOf(
      KitShape("M20 6 9 17l-5 -5", true, KitFill.NONE),
    ),
  ),
  /** Lucide «gamepad-2». */
  VIDEOJUEGOS(
    "Jugar videojuegos",
    listOf(
      KitShape("M6 11L10 11", true, KitFill.NONE),
      KitShape("M8 9L8 13", true, KitFill.NONE),
      KitShape("M15 12L15.01 12", true, KitFill.NONE),
      KitShape("M18 10L18.01 10", true, KitFill.NONE),
      KitShape("M17.32 5H6.68a4 4 0 0 0 -3.978 3.59c-0.006 0.052 -0.01 0.101 -0.017 0.152C2.604 9.416 2 14.456 2 16a3 3 0 0 0 3 3c1 0 1.5 -0.5 2 -1l1.414 -1.414A2 2 0 0 1 9.828 16h4.344a2 2 0 0 1 1.414 0.586L17 18c0.5 0.5 1 1 2 1a3 3 0 0 0 3 -3c0 -1.545 -0.604 -6.584 -0.685 -7.258 -0.007 -0.05 -0.011 -0.1 -0.017 -0.151A4 4 0 0 0 17.32 5z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «phone». */
  LLAMAR(
    "Llamar a alguien",
    listOf(
      KitShape("M13.832 16.568a1 1 0 0 0 1.213 -0.303l0.355 -0.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2A18 18 0 0 1 2 4a2 2 0 0 1 2 -2h3a2 2 0 0 1 2 2v3a2 2 0 0 1 -0.8 1.6l-0.468 0.351a1 1 0 0 0 -0.292 1.233 14 14 0 0 0 6.392 6.384", true, KitFill.NONE),
    ),
  ),
  /** Lucide «map-pin». */
  LUGAR(
    "Lugar",
    listOf(
      KitShape("M20 10c0 4.993 -5.539 10.193 -7.399 11.799a1 1 0 0 1 -1.202 0C9.539 20.193 4 14.993 4 10a8 8 0 0 1 16 0", true, KitFill.NONE),
      KitShape("M9 10A3 3 0 1 0 15 10A3 3 0 1 0 9 10Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «scissors». */
  MANUALIDADES(
    "Hacer manualidades",
    listOf(
      KitShape("M3 6A3 3 0 1 0 9 6A3 3 0 1 0 3 6Z", true, KitFill.NONE),
      KitShape("M8.12 8.12 12 12", true, KitFill.NONE),
      KitShape("M20 4 8.12 15.88", true, KitFill.NONE),
      KitShape("M3 18A3 3 0 1 0 9 18A3 3 0 1 0 3 18Z", true, KitFill.NONE),
      KitShape("M14.8 14.8 20 20", true, KitFill.NONE),
    ),
  ),
  /** Lucide «ellipsis». */
  MAS(
    "Más opciones",
    listOf(
      KitShape("M11 12A1 1 0 1 0 13 12A1 1 0 1 0 11 12Z", true, KitFill.NONE),
      KitShape("M18 12A1 1 0 1 0 20 12A1 1 0 1 0 18 12Z", true, KitFill.NONE),
      KitShape("M4 12A1 1 0 1 0 6 12A1 1 0 1 0 4 12Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «menu». */
  MENU(
    "Menú",
    listOf(
      KitShape("M4 5h16", true, KitFill.NONE),
      KitShape("M4 12h16", true, KitFill.NONE),
      KitShape("M4 19h16", true, KitFill.NONE),
    ),
  ),
  /** Lucide «eye». */
  MOSTRAR(
    "Mostrar",
    listOf(
      KitShape("M2.062 12.348a1 1 0 0 1 0 -0.696 10.75 10.75 0 0 1 19.876 0 1 1 0 0 1 0 0.696 10.75 10.75 0 0 1 -19.876 0", true, KitFill.NONE),
      KitShape("M9 12A3 3 0 1 0 15 12A3 3 0 1 0 9 12Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «headphones». */
  MUSICA(
    "Escuchar música",
    listOf(
      KitShape("M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2H5a2 2 0 0 1 -2 -2v-7a9 9 0 0 1 18 0v7a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2v-3a2 2 0 0 1 2 -2h3", true, KitFill.NONE),
    ),
  ),
  /** Propio, con las reglas de construcción de Lucide (D-187). El Tag visto desde arriba: cuerpo, botón y argolla. Lucide no tiene el Tag. */
  OBJETO(
    "Objeto",
    listOf(
      KitShape("M2 12A10 10 0 1 0 22 12A10 10 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("M9 13A3 3 0 1 0 15 13A3 3 0 1 0 9 13Z", true, KitFill.NONE),
      KitShape("M12 6h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «eye-off». */
  OCULTAR(
    "Ocultar",
    listOf(
      KitShape("M10.733 5.076a10.744 10.744 0 0 1 11.205 6.575 1 1 0 0 1 0 0.696 10.747 10.747 0 0 1 -1.444 2.49", true, KitFill.NONE),
      KitShape("M14.084 14.158a3 3 0 0 1 -4.242 -4.242", true, KitFill.NONE),
      KitShape("M17.479 17.499a10.75 10.75 0 0 1 -15.417 -5.151 1 1 0 0 1 0 -0.696 10.75 10.75 0 0 1 4.446 -5.143", true, KitFill.NONE),
      KitShape("m2 2 20 20", true, KitFill.NONE),
    ),
  ),
  /** Lucide «shirt». Lucide no tiene un colgador: la polera dice «juntar la ropa», la primera sugerencia de la app. Revisar. */
  ORDENAR(
    "Ordenar",
    listOf(
      KitShape("M20.38 3.46 16 2a4 4 0 0 1 -8 0L3.62 3.46a2 2 0 0 0 -1.34 2.23l0.58 3.47a1 1 0 0 0 0.99 0.84H6v10c0 1.1 0.9 2 2 2h8a2 2 0 0 0 2 -2V10h2.15a1 1 0 0 0 0.99 -0.84l0.58 -3.47a2 2 0 0 0 -1.34 -2.23z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «speaker». */
  PARLANTE(
    "Parlante",
    listOf(
      KitShape("M6 2H18A2 2 0 0 1 20 4V20A2 2 0 0 1 18 22H6A2 2 0 0 1 4 20V4A2 2 0 0 1 6 2Z", true, KitFill.NONE),
      KitShape("M12 6h0.01", true, KitFill.NONE),
      KitShape("M8 14A4 4 0 1 0 16 14A4 4 0 1 0 8 14Z", true, KitFill.NONE),
      KitShape("M12 14h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «pause». */
  PAUSAR(
    "Pausar",
    listOf(
      KitShape("M15 3H18A1 1 0 0 1 19 4V20A1 1 0 0 1 18 21H15A1 1 0 0 1 14 20V4A1 1 0 0 1 15 3Z", true, KitFill.NONE),
      KitShape("M6 3H9A1 1 0 0 1 10 4V20A1 1 0 0 1 9 21H6A1 1 0 0 1 5 20V4A1 1 0 0 1 6 3Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «user». */
  PERFIL(
    "Perfil",
    listOf(
      KitShape("M19 21v-2a4 4 0 0 0 -4 -4H9a4 4 0 0 0 -4 4v2", true, KitFill.NONE),
      KitShape("M8 7A4 4 0 1 0 16 7A4 4 0 1 0 8 7Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «shield-check». */
  PERMISO(
    "Permiso",
    listOf(
      KitShape("M20 13c0 5 -3.5 7.5 -7.66 8.95a1 1 0 0 1 -0.67 -0.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1 -1c2 0 4.5 -1.2 6.24 -2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z", true, KitFill.NONE),
      KitShape("m9 12 2 2 4 -4", true, KitFill.NONE),
    ),
  ),
  /** Lucide «palette». «Preparar las acuarelas», como sugiere la app, y se distingue mejor del lápiz de Dibujar. */
  PINTAR(
    "Pintar",
    listOf(
      KitShape("M12 22a1 1 0 0 1 0 -20 10 9 0 0 1 10 9 5 5 0 0 1 -5 5h-2.25a1.75 1.75 0 0 0 -1.4 2.8l0.3 0.4a1.75 1.75 0 0 1 -1.4 2.8z", true, KitFill.NONE),
      KitShape("M13 6.5A0.5 0.5 0 1 0 14 6.5A0.5 0.5 0 1 0 13 6.5Z", true, KitFill.INK),
      KitShape("M17 10.5A0.5 0.5 0 1 0 18 10.5A0.5 0.5 0 1 0 17 10.5Z", true, KitFill.INK),
      KitShape("M6 12.5A0.5 0.5 0 1 0 7 12.5A0.5 0.5 0 1 0 6 12.5Z", true, KitFill.INK),
      KitShape("M8 7.5A0.5 0.5 0 1 0 9 7.5A0.5 0.5 0 1 0 8 7.5Z", true, KitFill.INK),
    ),
  ),
  /** Lucide «plant-pot». */
  PLANTAS(
    "Cuidar las plantas",
    listOf(
      KitShape("M14 8.536V6a4 4 0 0 1 4 -4h1.5a0.5 0.5 0 0 1 0.5 0.5V4a4 4 0 0 1 -4 4 4 4 0 0 0 -4 4 5 5 0 0 1 -8 -4 5 5 0 0 1 8 4c0 2 1 3 1 5", true, KitFill.NONE),
      KitShape("m18 17 -1.085 3.58A2 2 0 0 1 15 22H9.002a2 2 0 0 1 -1.913 -1.418L6 17", true, KitFill.NONE),
      KitShape("M5 17h14", true, KitFill.NONE),
    ),
  ),
  /** Adaptado de Lucide (D-187). De «footprints»: una sola huella, sin girar y más grande, el primer paso. Sin uso en la app. */
  PRIMER_PASO(
    "Cómo empieza",
    listOf(
      KitShape("M9 19.5v-2.975C9 13.875 7.713 12.625 7.75 9.5c0.038 -3.4 1.863 -7.5 5.625 -7.5C15.713 2 16.5 4.25 16.5 6.375c0 3.888 -2.5 7.075 -2.5 10.85V19.5a2.5 2.5 0 1 1 -5 0Z", true, KitFill.NONE),
      KitShape("M9 16h5", true, KitFill.NONE),
    ),
  ),
  /** Lucide «lock». */
  PRIVACIDAD(
    "Privacidad",
    listOf(
      KitShape("M5 11H19A2 2 0 0 1 21 13V20A2 2 0 0 1 19 22H5A2 2 0 0 1 3 20V13A2 2 0 0 1 5 11Z", true, KitFill.NONE),
      KitShape("M7 11V7a5 5 0 0 1 10 0v4", true, KitFill.NONE),
    ),
  ),
  /** Lucide «volume-2». */
  PROBAR(
    "Probar sonido",
    listOf(
      KitShape("M11 4.702a0.705 0.705 0 0 0 -1.203 -0.498L6.413 7.587A1.4 1.4 0 0 1 5.416 8H3a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h2.416a1.4 1.4 0 0 1 0.997 0.413l3.383 3.384A0.705 0.705 0 0 0 11 19.298z", true, KitFill.NONE),
      KitShape("M16 9a5 5 0 0 1 0 6", true, KitFill.NONE),
      KitShape("M19.364 18.364a9 9 0 0 0 0 -12.728", true, KitFill.NONE),
    ),
  ),
  /** Lucide «bug». */
  PROBLEMA(
    "Reportar un problema",
    listOf(
      KitShape("M12 20v-9", true, KitFill.NONE),
      KitShape("M14 7a4 4 0 0 1 4 4v3a6 6 0 0 1 -12 0v-3a4 4 0 0 1 4 -4z", true, KitFill.NONE),
      KitShape("M14.12 3.88 16 2", true, KitFill.NONE),
      KitShape("M21 21a4 4 0 0 0 -3.81 -4", true, KitFill.NONE),
      KitShape("M21 5a4 4 0 0 1 -3.55 3.97", true, KitFill.NONE),
      KitShape("M22 13h-4", true, KitFill.NONE),
      KitShape("M3 21a4 4 0 0 1 3.81 -4", true, KitFill.NONE),
      KitShape("M3 5a4 4 0 0 0 3.55 3.97", true, KitFill.NONE),
      KitShape("M6 13H2", true, KitFill.NONE),
      KitShape("m8 2 1.88 1.88", true, KitFill.NONE),
      KitShape("M9 7.13V6a3 3 0 1 1 6 0v1.13", true, KitFill.NONE),
    ),
  ),
  /** Lucide «rotate-cw». */
  REINTENTAR(
    "Reintentar",
    listOf(
      KitShape("M21 12a9 9 0 1 1 -9 -9c2.52 0 4.93 1 6.74 2.74L21 8", true, KitFill.NONE),
      KitShape("M21 3v5h-5", true, KitFill.NONE),
    ),
  ),
  /** Lucide «list». */
  RELEVOS(
    "Relevos",
    listOf(
      KitShape("M3 5h0.01", true, KitFill.NONE),
      KitShape("M3 12h0.01", true, KitFill.NONE),
      KitShape("M3 19h0.01", true, KitFill.NONE),
      KitShape("M8 5h13", true, KitFill.NONE),
      KitShape("M8 12h13", true, KitFill.NONE),
      KitShape("M8 19h13", true, KitFill.NONE),
    ),
  ),
  /** Lucide «play». */
  REPRODUCIR(
    "Reproducir",
    listOf(
      KitShape("M5 5a2 2 0 0 1 3.008 -1.728l11.997 6.998a2 2 0 0 1 0.003 3.458l-12 7A2 2 0 0 1 5 19z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «door-open». Salir de la casa; la huella de mascota decía otra cosa (D-162). */
  SALIR(
    "Salir",
    listOf(
      KitShape("M10 21H2", true, KitFill.NONE),
      KitShape("M10 3H7a2 2 0 0 0 -2 2v16", true, KitFill.NONE),
      KitShape("M14 12h0.01", true, KitFill.NONE),
      KitShape("M19 21V5a2 2 0 0 0 -1.675 -1.974l-6.163 -1.013A1 1 0 0 0 10 3v18a1 1 0 0 0 1.124 0.992z", true, KitFill.NONE),
      KitShape("M22 21h-3", true, KitFill.NONE),
    ),
  ),
  /** Lucide «arrow-right». */
  SIGUIENTE(
    "Siguiente",
    listOf(
      KitShape("M5 12h14", true, KitFill.NONE),
      KitShape("m12 5 7 7 -7 7", true, KitFill.NONE),
    ),
  ),
  /** Adaptado de Lucide (D-187). De «volume-x»: el mismo Tag de Suena, con la cruz de «volume-x». */
  SILENCIAR(
    "Silenciar",
    listOf(
      KitShape("M2 12A5.5 5.5 0 1 0 13 12A5.5 5.5 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("M7.5 12h0.01", true, KitFill.NONE),
      KitShape("m17 9.5 5 5", true, KitFill.NONE),
      KitShape("m22 9.5 -5 5", true, KitFill.NONE),
    ),
  ),
  /** Lucide «cloud-off». */
  SIN_CONEXION(
    "Sin conexión",
    listOf(
      KitShape("M10.94 5.274A7 7 0 0 1 15.71 10h1.79a4.5 4.5 0 0 1 4.222 6.057", true, KitFill.NONE),
      KitShape("M18.796 18.81A4.5 4.5 0 0 1 17.5 19H9A7 7 0 0 1 5.79 5.78", true, KitFill.NONE),
      KitShape("m2 2 20 20", true, KitFill.NONE),
    ),
  ),
  /** Lucide «cloud-upload». */
  SINCRONIZAR(
    "Sincronizar datos",
    listOf(
      KitShape("M12 13v8", true, KitFill.NONE),
      KitShape("M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242", true, KitFill.NONE),
      KitShape("m8 17 4 -4 4 4", true, KitFill.NONE),
    ),
  ),
  /** Adaptado de Lucide (D-187). De «smartphone»: el teléfono junto al Tag. Sin uso en la app. */
  SISTEMA(
    "Sistema phygital",
    listOf(
      KitShape("M4 2H8A2 2 0 0 1 10 4V20A2 2 0 0 1 8 22H4A2 2 0 0 1 2 20V4A2 2 0 0 1 4 2Z", true, KitFill.NONE),
      KitShape("M6 18h0.01", true, KitFill.NONE),
      KitShape("M14 17A4 4 0 1 0 22 17A4 4 0 1 0 14 17Z", true, KitFill.NONE),
      KitShape("M18 17h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «smartphone». */
  TELEFONO(
    "Este teléfono",
    listOf(
      KitShape("M7 2H17A2 2 0 0 1 19 4V20A2 2 0 0 1 17 22H7A2 2 0 0 1 5 20V4A2 2 0 0 1 7 2Z", true, KitFill.NONE),
      KitShape("M12 18h0.01", true, KitFill.NONE),
    ),
  ),
  /** Lucide «contrast». El signo de contraste (D-162). */
  TEMA(
    "Tema claro u oscuro",
    listOf(
      KitShape("M2 12A10 10 0 1 0 22 12A10 10 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("M12 18a6 6 0 0 0 0 -12v12z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «a-large-small». */
  TEXTO(
    "Tamaño del texto",
    listOf(
      KitShape("m15 16 2.536 -7.328a1.02 1.02 1 0 1 1.928 0L22 16", true, KitFill.NONE),
      KitShape("M15.697 14h5.606", true, KitFill.NONE),
      KitShape("m2 16 4.039 -9.69a0.5 0.5 0 0 1 0.923 0L11 16", true, KitFill.NONE),
      KitShape("M3.304 13h6.392", true, KitFill.NONE),
    ),
  ),
  /** Lucide «timer». */
  TIEMPO(
    "Tiempo",
    listOf(
      KitShape("M10 2L14 2", true, KitFill.NONE),
      KitShape("M12 14L15 11", true, KitFill.NONE),
      KitShape("M4 14A8 8 0 1 0 20 14A8 8 0 1 0 4 14Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «clock». */
  USO(
    "Después de cuánto uso",
    listOf(
      KitShape("M2 12A10 10 0 1 0 22 12A10 10 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("M12 6v6l4 2", true, KitFill.NONE),
    ),
  ),
  /** Lucide «user-round». */
  USUARIO(
    "Persona",
    listOf(
      KitShape("M7 8A5 5 0 1 0 17 8A5 5 0 1 0 7 8Z", true, KitFill.NONE),
      KitShape("M20 21a8 8 0 0 0 -16 0", true, KitFill.NONE),
    ),
  ),
  /** Lucide «clipboard-check». */
  VALIDACION(
    "Validación",
    listOf(
      KitShape("M9 2H15A1 1 0 0 1 16 3V5A1 1 0 0 1 15 6H9A1 1 0 0 1 8 5V3A1 1 0 0 1 9 2Z", true, KitFill.NONE),
      KitShape("M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2H6a2 2 0 0 1 -2 -2V6a2 2 0 0 1 2 -2h2", true, KitFill.NONE),
      KitShape("m9 14 2 2 4 -4", true, KitFill.NONE),
    ),
  ),
  /** Lucide «arrow-left». */
  VOLVER(
    "Volver",
    listOf(
      KitShape("m12 19 -7 -7 7 -7", true, KitFill.NONE),
      KitShape("M19 12H5", true, KitFill.NONE),
    ),
  ),
  /** Adaptado de Lucide (D-187). De «radio» y «volume-2»: el Tag en lugar del parlante, con los anillos concéntricos de «radio». */
  SUENA(
    "Suena",
    listOf(
      KitShape("M2 12A5.5 5.5 0 1 0 13 12A5.5 5.5 0 1 0 2 12Z", true, KitFill.NONE),
      KitShape("M7.5 12h0.01", true, KitFill.NONE),
      KitShape("M14.218 5.282a9.5 9.5 0 0 1 0 13.435", true, KitFill.NONE),
      KitShape("M17.046 2.454a13.5 13.5 0 0 1 0 19.092", true, KitFill.NONE),
    ),
  ),
  /** Lucide «route». */
  RUTA(
    "Ruta",
    listOf(
      KitShape("M3 19A3 3 0 1 0 9 19A3 3 0 1 0 3 19Z", true, KitFill.NONE),
      KitShape("M9 19h8.5a3.5 3.5 0 0 0 0 -7h-11a3.5 3.5 0 0 1 0 -7H15", true, KitFill.NONE),
      KitShape("M15 5A3 3 0 1 0 21 5A3 3 0 1 0 15 5Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «chart-no-axes-column». */
  AVANCE(
    "Avance",
    listOf(
      KitShape("M5 21v-6", true, KitFill.NONE),
      KitShape("M12 21V3", true, KitFill.NONE),
      KitShape("M19 21V9", true, KitFill.NONE),
    ),
  ),
  /** Lucide «chevron-right». */
  ABRIR(
    "Abrir",
    listOf(
      KitShape("m9 18 6 -6 -6 -6", true, KitFill.NONE),
    ),
  ),
  /** Lucide «settings». */
  TUERCA(
    "Ajustes",
    listOf(
      KitShape("M9.671 4.136a2.34 2.34 0 0 1 4.659 0 2.34 2.34 0 0 0 3.319 1.915 2.34 2.34 0 0 1 2.33 4.033 2.34 2.34 0 0 0 0 3.831 2.34 2.34 0 0 1 -2.33 4.033 2.34 2.34 0 0 0 -3.319 1.915 2.34 2.34 0 0 1 -4.659 0 2.34 2.34 0 0 0 -3.32 -1.915 2.34 2.34 0 0 1 -2.33 -4.033 2.34 2.34 0 0 0 0 -3.831A2.34 2.34 0 0 1 6.35 6.051a2.34 2.34 0 0 0 3.319 -1.915", true, KitFill.NONE),
      KitShape("M9 12A3 3 0 1 0 15 12A3 3 0 1 0 9 12Z", true, KitFill.NONE),
    ),
  ),
  /** Adaptado de Lucide (D-187). De «layout-grid»: cuatro círculos, como los del logo (D-155). */
  ACTIVIDADES(
    "Actividades",
    listOf(
      KitShape("M3 6.5A3.5 3.5 0 1 0 10 6.5A3.5 3.5 0 1 0 3 6.5Z", true, KitFill.NONE),
      KitShape("M14 6.5A3.5 3.5 0 1 0 21 6.5A3.5 3.5 0 1 0 14 6.5Z", true, KitFill.NONE),
      KitShape("M3 17.5A3.5 3.5 0 1 0 10 17.5A3.5 3.5 0 1 0 3 17.5Z", true, KitFill.NONE),
      KitShape("M14 17.5A3.5 3.5 0 1 0 21 17.5A3.5 3.5 0 1 0 14 17.5Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «dog». */
  PERRO(
    "Perro",
    listOf(
      KitShape("M11.25 16.25h1.5L12 17z", true, KitFill.NONE),
      KitShape("M16 14v0.5", true, KitFill.NONE),
      KitShape("M4.42 11.247A13.152 13.152 0 0 0 4 14.556C4 18.728 7.582 21 12 21s8 -2.272 8 -6.444a11.702 11.702 0 0 0 -0.493 -3.309", true, KitFill.NONE),
      KitShape("M8 14v0.5", true, KitFill.NONE),
      KitShape("M8.5 8.5c-0.384 1.05 -1.083 2.028 -2.344 2.5 -1.931 0.722 -3.576 -0.297 -3.656 -1 -0.113 -0.994 1.177 -6.53 4 -7 1.923 -0.321 3.651 0.845 3.651 2.235A7.497 7.497 0 0 1 14 5.277c0 -1.39 1.844 -2.598 3.767 -2.277 2.823 0.47 4.113 6.006 4 7 -0.08 0.703 -1.725 1.722 -3.656 1 -1.261 -0.472 -1.855 -1.45 -2.239 -2.5", true, KitFill.NONE),
    ),
  ),
  /** Lucide «sport-shoe». La zapatilla: «Ponerte las zapatillas», como sugiere la app. */
  CORRER(
    "Correr",
    listOf(
      KitShape("m15 10.42 4.8 -5.07", true, KitFill.NONE),
      KitShape("M19 18h3", true, KitFill.NONE),
      KitShape("M9.5 22 21.414 9.415A2 2 0 0 0 21.2 6.4l-5.61 -4.208A1 1 0 0 0 14 3v2a2 2 0 0 1 -1.394 1.906L8.677 8.053A1 1 0 0 0 8 9c-0.155 6.393 -2.082 9 -4 9a2 2 0 0 0 0 4h14", true, KitFill.NONE),
    ),
  ),
  /** Lucide «waves-ladder». La escalera de la piscina. */
  NADAR(
    "Nadar",
    listOf(
      KitShape("M19 5a2 2 0 0 0 -2 2v11", true, KitFill.NONE),
      KitShape("M2 18c0.6 0.5 1.2 1 2.5 1 2.5 0 2.5 -2 5 -2 2.6 0 2.4 2 5 2 2.5 0 2.5 -2 5 -2 1.3 0 1.9 0.5 2.5 1", true, KitFill.NONE),
      KitShape("M7 13h10", true, KitFill.NONE),
      KitShape("M7 9h10", true, KitFill.NONE),
      KitShape("M9 5a2 2 0 0 0 -2 2v11", true, KitFill.NONE),
    ),
  ),
  /** Lucide «volleyball». Una pelota genérica: el concepto reúne fútbol, básquetbol, vóleibol y otros deportes. Revisar. */
  PELOTA(
    "Pelota",
    listOf(
      KitShape("M11 7a16 16 20 0 1 10.98 4.362", true, KitFill.NONE),
      KitShape("M12 12a13 13 0 0 1 -8.66 5", true, KitFill.NONE),
      KitShape("M16.83 13.634a16 16 0 0 1 -9.267 7.328", true, KitFill.NONE),
      KitShape("M20.66 17A13 13 0 0 0 12 12a13 13 0 0 1 0 -10", true, KitFill.NONE),
      KitShape("M8.17 15.366a16 16 0 0 1 -1.713 -11.69", true, KitFill.NONE),
      KitShape("M2 12A10 10 0 1 0 22 12A10 10 0 1 0 2 12Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «clapperboard». */
  PELICULA(
    "Ver una película",
    listOf(
      KitShape("m12.296 3.464 3.02 3.956", true, KitFill.NONE),
      KitShape("M20.2 6 3 11l-0.9 -2.4c-0.3 -1.1 0.3 -2.2 1.3 -2.5l13.5 -4c1.1 -0.3 2.2 0.3 2.5 1.3z", true, KitFill.NONE),
      KitShape("M3 11h18v8a2 2 0 0 1 -2 2H5a2 2 0 0 1 -2 -2z", true, KitFill.NONE),
      KitShape("m6.18 5.276 3.1 3.899", true, KitFill.NONE),
    ),
  ),
  /** Adaptado de Lucide (D-187). De «book»: el tomo con un globo de diálogo (D-162). */
  MANGA(
    "Leer manga",
    listOf(
      KitShape("M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1 -1 1H6.5a1 1 0 0 1 0 -5H20", true, KitFill.NONE),
      KitShape("M10 6h5a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-2l-2 2v-2h-1a1 1 0 0 1 -1 -1V7a1 1 0 0 1 1 -1z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «toy-brick». */
  MAQUETA(
    "Armar una maqueta",
    listOf(
      KitShape("M4 8H20A1 1 0 0 1 21 9V19A1 1 0 0 1 20 20H4A1 1 0 0 1 3 19V9A1 1 0 0 1 4 8Z", true, KitFill.NONE),
      KitShape("M10 8V5c0 -0.6 -0.4 -1 -1 -1H6a1 1 0 0 0 -1 1v3", true, KitFill.NONE),
      KitShape("M19 8V5c0 -0.6 -0.4 -1 -1 -1h-3a1 1 0 0 0 -1 1v3", true, KitFill.NONE),
    ),
  ),
  /** Lucide «spool». El carrete de hilo: «Enhebrar la aguja», como sugiere la app. Lucide no tiene un ovillo. Revisar. */
  TEJER(
    "Tejer o coser",
    listOf(
      KitShape("M17 13.44 4.442 17.082A2 2 0 0 0 4.982 21H19a2 2 0 0 0 0.558 -3.921l-1.115 -0.32A2 2 0 0 1 17 14.837V7.66", true, KitFill.NONE),
      KitShape("m7 10.56 12.558 -3.642A2 2 0 0 0 19.018 3H5a2 2 0 0 0 -0.558 3.921l1.115 0.32A2 2 0 0 1 7 9.163v7.178", true, KitFill.NONE),
    ),
  ),
  /** Lucide «piano». */
  PIANO(
    "Tocar el piano",
    listOf(
      KitShape("M10 13v4", true, KitFill.NONE),
      KitShape("M14 13v4", true, KitFill.NONE),
      KitShape("M18 13v4", true, KitFill.NONE),
      KitShape("M2 13h20", true, KitFill.NONE),
      KitShape("M22 11.5A3.5 3.5 0 0 0 18.5 8a3.52 3.52 0 0 1 -3.173 -2A7 7 0 0 0 2 9v10a2 2 0 0 0 2 2h16a2 2 0 0 0 2 -2z", true, KitFill.NONE),
      KitShape("M6 13v4", true, KitFill.NONE),
    ),
  ),
  /** Propio, con las reglas de construcción de Lucide (D-187). La flor de loto, con pétalos como las hojas de «flower-2». Lucide no tiene un ícono de meditar. */
  MEDITAR(
    "Meditar",
    listOf(
      KitShape("M12 2A9 9 0 0 1 12 16A9 9 0 0 1 12 2Z", true, KitFill.NONE),
      KitShape("M12 16A7 7 0 0 1 3 10A7 7 0 0 1 12 16Z", true, KitFill.NONE),
      KitShape("M21 10A7 7 0 0 1 12 16A7 7 0 0 1 21 10Z", true, KitFill.NONE),
      KitShape("M5 21h14", true, KitFill.NONE),
    ),
  ),
  /** Lucide «languages». */
  IDIOMAS(
    "Aprender un idioma",
    listOf(
      KitShape("m5 8 6 6", true, KitFill.NONE),
      KitShape("m4 14 6 -6 2 -3", true, KitFill.NONE),
      KitShape("M2 5h12", true, KitFill.NONE),
      KitShape("M7 2h1", true, KitFill.NONE),
      KitShape("m22 22 -5 -10 -5 10", true, KitFill.NONE),
      KitShape("M14 18h6", true, KitFill.NONE),
    ),
  ),
  /** Lucide «playing-cards». */
  CARTAS(
    "Jugar a las cartas",
    listOf(
      KitShape("M14.832 8.445a1 1 0 0 0 -1.589 -0.098l-2.075 3.098a1 1 0 0 0 0 1.11l2 3a1 1 0 0 0 1.664 0l2 -3a1 1 0 0 0 0 -1.11z", true, KitFill.NONE),
      KitShape("m7.18 20.827 -5 -11a2 2 0 0 1 0.993 -2.647L7 5.44", true, KitFill.NONE),
      KitShape("M9 2H19A2 2 0 0 1 21 4V20A2 2 0 0 1 19 22H9A2 2 0 0 1 7 20V4A2 2 0 0 1 9 2Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «users». */
  COMPARTIR(
    "Con otras personas",
    listOf(
      KitShape("M16 21v-2a4 4 0 0 0 -4 -4H6a4 4 0 0 0 -4 4v2", true, KitFill.NONE),
      KitShape("M16 3.128a4 4 0 0 1 0 7.744", true, KitFill.NONE),
      KitShape("M22 21v-2a4 4 0 0 0 -3 -3.87", true, KitFill.NONE),
      KitShape("M5 7A4 4 0 1 0 13 7A4 4 0 1 0 5 7Z", true, KitFill.NONE),
    ),
  ),
  /** Lucide «circle-dashed». Círculo punteado, sin juicio (D-162). */
  SIN_RESPUESTA(
    "Sin respuesta",
    listOf(
      KitShape("M10.1 2.182a10 10 0 0 1 3.8 0", true, KitFill.NONE),
      KitShape("M13.9 21.818a10 10 0 0 1 -3.8 0", true, KitFill.NONE),
      KitShape("M17.609 3.721a10 10 0 0 1 2.69 2.7", true, KitFill.NONE),
      KitShape("M2.182 13.9a10 10 0 0 1 0 -3.8", true, KitFill.NONE),
      KitShape("M20.279 17.609a10 10 0 0 1 -2.7 2.69", true, KitFill.NONE),
      KitShape("M21.818 10.1a10 10 0 0 1 0 3.8", true, KitFill.NONE),
      KitShape("M3.721 6.391a10 10 0 0 1 2.7 -2.69", true, KitFill.NONE),
      KitShape("M6.391 20.279a10 10 0 0 1 -2.69 -2.7", true, KitFill.NONE),
    ),
  ),
}
