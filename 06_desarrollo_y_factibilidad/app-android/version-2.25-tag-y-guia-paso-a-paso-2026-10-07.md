# Android 2.25: el Tag y su guía paso a paso

**Fecha:** 7 de octubre de 2026. **Decisión:** D-114. **Estado:** compilada desde cero, con 83 pruebas unitarias aprobadas. La guía se revisó en el emulador: se abre sola al elegir el Tag por primera vez. No se ha probado en un teléfono real. El consentimiento no cambia (v13): el texto solo cambia «llavero» por «Tag».

## Qué pidió el autor

- Una guía más intuitiva y paso a paso, que aparezca la primera vez que se elige el llavero.
- Llamarlo «Tag».
- Mostrarlo redondo, como el que compró.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Nombre | En pantalla se llama «el Tag» («Buscar el Tag», «Probar el Tag», «Tags cerca», «No se encontró el Tag»). Los nombres internos y de los eventos no cambian (\`TAG\`, \`llavero_*\`), así que los datos siguen siendo comparables. |
| Guía paso a paso | Ocho pasos, uno por pantalla, con «Atrás» y «Siguiente» y puntos de avance: este es tu Tag, enciéndelo, búscalo en Relevo, déjalo en su lugar, para callarlo un toque, para apagarlo, la pila y si no aparece. |
| Dibujo | Un Tag redondo con un botón al centro y una luz pequeña, sobre un halo de colores. Cada paso anima lo que hay que hacer: un arco que se llena en 3 segundos para encender y apagar, un anillo que se abre para el toque, ondas hacia el teléfono, un segundo teléfono tachado y la pila. Con «reducir movimiento», el dibujo queda quieto. |
| Primera vez | La guía se abre sola la primera vez que se elige el Tag en «¿Dónde suena?». Si todavía no hay un Tag elegido, termina con «Buscar mi Tag», que empieza la búsqueda. Después se abre desde «Cómo usar el Tag» y desde Perfil › Ayuda. |

**APK:** [relevo-android-2.25-2026-10-07.apk](releases/relevo-android-2.25-2026-10-07.apk), SHA-256 `7D4AA86940F3CA39A8D85CC41D659119D0BB58B186D2F370F04AB1BAB078B492` (41,4 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-10-07 — Creación

- **Qué se añadió:** la versión 2.25, con el nombre «Tag» y la guía paso a paso con un Tag redondo animado, que se abre sola la primera vez.
- **Cómo estaba antes:** la 2.24 llamaba «llavero» al objeto y mostraba la guía como una lista de seis puntos.
- **Por qué:** pedido del autor (D-114).
