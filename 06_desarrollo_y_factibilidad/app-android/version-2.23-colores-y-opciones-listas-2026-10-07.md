# Android 2.23: degradados de varios colores, más actividades y opciones listas

**Fecha:** 7 de octubre de 2026. **Decisión:** D-113. **Estado:** compilada desde cero, con 83 pruebas unitarias aprobadas y revisada en el emulador como persona nueva, de los intereses a Inicio. No se ha probado en un teléfono real. El consentimiento no cambia (v13).

## Qué pidió el autor

- Degradados con estilo y de varios colores, como en las referencias que dio para la marca.
- Sumar actividades como jugar videojuegos, que son igual de válidas.
- Que cada actividad traiga todo predefinido, para que la persona no tenga que escribir.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Degradados | Cada imagen combina tres colores de la familia de la casa (D-104). Lleva una base diagonal entre dos colores, una luz del tercero desde una esquina y un brillo suave al centro, «iluminado desde dentro», como en la referencia de Rose Pilkington (documento 30). Cada icono parte de una esquina distinta, para que las fichas vecinas no se vean iguales. El amarillo no se mezcla con el verde, porque juntos dan un tono oliva. En tema oscuro la mezcla es más suave. |
| Icono | Queda un poco sobre el centro, para que no lo tape la banda de texto de las fichas grandes. |
| Actividades nuevas | Las rutas suman «Jugar videojuegos», «Escuchar música» y «Ver una película o serie». En «Compartir con alguien» se agrega «Llamar a alguien». Las ideas suman jugar videojuegos, escuchar música, ver una película, llamar a alguien y jugar un juego de mesa. Todas aparecen en las entrevistas P1–P8: los videojuegos en P3, P6, P7 y P8. |
| Icono nuevo | Un control de videojuegos con el mismo trazo y la misma retícula del kit. |
| Sin escribir | «¿Cómo empiezas?» ofrece hasta seis primeros pasos con un toque: los de la misma actividad, los de su ruta y los de actividades parecidas. «¿Dónde empiezas?» ofrece hasta ocho lugares: los de la actividad y los comunes de la casa. En la semana B solo aparecen lugares de la casa. Escribir sigue siendo posible, pero ya no hace falta. |
| Textos | Las ayudas dicen «Toca una opción o escribe la tuya» en vez de pedir que la persona escriba. |

## Lo que se comprobó

En el emulador, como persona nueva:

- Los degradados se ven en los intereses, en Inicio y en la ruta.
- Las cuatro actividades nuevas aparecen entre los intereses.
- La ruta de videojuegos funciona.
- «¿Cómo empiezas?» y «¿Dónde empiezas?» ofrecen opciones que se eligen con un toque.

Los datos del emulador se devolvieron al terminar.

**Límite:** las rutas que ya estaban guardadas conservan sus textos. Las nuevas usan los de esta versión.

**APK:** [relevo-android-2.23-2026-10-07.apk](releases/relevo-android-2.23-2026-10-07.apk), SHA-256 `6345204B15959D7097A305E976204AC9B1957CAAD1F8DA8376ED7235123FA792` (41,3 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-10-07 — Creación

- **Qué se añadió:** la versión 2.23, con degradados de tres colores, cuatro actividades nuevas, el icono de videojuegos y opciones de un toque para el primer paso y el lugar.
- **Cómo estaba antes:** la 2.22 usaba degradados de un solo color y pedía escribir el primer paso y el lugar si no venían de una idea.
- **Por qué:** pedido del autor del 6 de octubre (D-113).
