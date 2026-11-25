# Capturas y GIF de la interfaz 4.8.2

Recorrido completo de la [versión 4.8.2](../../version-4.8.2-iconos-con-las-reglas-de-lucide-2026-11-22.md) (D-187), la más reciente y la primera con los íconos de Lucide. Se grabó el 23 de noviembre de 2026 en el emulador de Android 16 (1080 × 2400), con una copia aparte de la app (`cl.udp.relevo.prueba`, compilada desde el mismo código de la rama `iconos-lucide`), sin conexión y desde una instalación nueva. El nombre es el del autor; las actividades, los lugares y el código son de ejemplo, y no hay datos de participantes.

- **`gifs/`:** un GIF por flujo, de 400 px de ancho y a 12 cuadros por segundo.
- **`videos/`:** los mismos flujos en MP4, de 540 px de ancho, más nítidos y livianos.
- **`pantallas/`:** 110 capturas en tamaño real, numeradas en el orden del recorrido.
- **`hoja-de-contacto.png`:** las 110 capturas en una sola imagen.

## Los flujos

| GIF | Qué muestra | Capturas |
| --- | --- | --- |
| `01-primera-vez.gif` | La primera vez, de la bienvenida a Inicio: el consentimiento, el permiso de tiempo de uso, los seis pasos del primer relevo (Leer, abrir el libro, en el velador, 15 minutos en el Reloj, por notificaciones), el permiso de notificaciones y el perfil (nombre, emoji e intereses). | 001–024 |
| `02-cuando-suena.gif` | Cuando suena: Inicio contando, el aviso mientras se usa otra app, la notificación, la pantalla «Es momento de volver a elegir», las cuatro preguntas de un toque, «¿Qué decidiste?» y el agradecimiento en Inicio. La espera en el Reloj va acelerada. | 025–032 |
| `03-crear-un-relevo.gif` | Crear un relevo desde Inicio con «Elegir otra»: Dibujar 10 minutos, cómo empieza, dónde, las apps y 30 minutos, dónde suena y «Activar el relevo». | 033–046 |
| `04-relevo-activo-y-aviso-sonando.gif` | El relevo activo: su detalle y «Cambiar o desactivar». Después suena (con la espera acelerada), se abre mientras todavía suena, se silencia, se responde y se deja «lista para después». | 047–057 |
| `05-editar-perfil.gif` | Editar el perfil: cambiar el emoji y los intereses, y guardar. | 058–064 |
| `06-actividades-y-nueva-actividad.gif` | La pestaña Actividades vacía, crear «Pasear al perro» y elegir su ícono, y las pestañas «Paso a paso» e «Ideas». | 065–074 |
| `07-perfil-y-ayuda.gif` | Desde Perfil: tus relevos, las apps, «Cómo funciona Relevo» (2 pantallas), «Cómo usar el Tag» (8 pasos), enviar un comentario y reportar un problema. | 075–088 |
| `08-ajustes.gif` | Ajustes: sonido, horas sin sonar, avisos, apariencia, permisos y tus datos. | 089–097 |
| `09-tema-oscuro.gif` | El tema oscuro en Apariencia, Perfil, Inicio y Actividades, y «Activar ahora» de una actividad dejada para después. | 098–103 |
| `10-actividad-propia-y-pasos.gif` | El detalle de una actividad propia, editar los pasos de una ruta (opciones y un paso nuevo) y la ruta actualizada. | 104–110 |

## Lo que hay que saber

- **Textos del sistema en inglés:** el emulador está en inglés, así que los diálogos de Android (permiso de notificaciones, ajustes de tiempo de uso, panel de notificaciones) salen en inglés. En un teléfono en español salen en español.
- **Nombre de la app:** el permiso de notificaciones dice «Relevo 4.8.2» porque es el nombre de la copia de prueba; la app instalada se llama «Relevo».
- **Sin Tag ni parlante:** el emulador no tiene Bluetooth, así que todos los relevos suenan por notificaciones. Las pantallas del Tag (paso 5 y la guía de 8 pasos) se ven, pero no la búsqueda de un Tag real.
- **Tiempos acortados:** para que sonara durante la grabación, el tiempo del relevo activo se bajó a 10 y 8 segundos editando sus datos en la copia de prueba. Por eso Inicio dice «Faltan 10 s» o «Faltan 8 s».
- **Barra de estado:** se usó el modo de demostración de Android, con la hora fija en 9:30 y sin íconos de red.
- **No se muestra el cierre de la prueba:** en una instalación nueva no aparece; solo lo ven quienes ya usaban Relevo. Está en las [capturas de la 4.7.2](../interfaz-4.7.2/README.md).

## Un error encontrado al grabar

**«Editar» un relevo activo no abre la edición.** En el detalle del relevo activo, «Cambiar o desactivar» → «Editar» deja de contar el tiempo, pero la app vuelve a Inicio en vez de abrir «Todo listo» para editarlo. El relevo queda como borrador: no se pierde, y reaparece al tocar «Elegir otra», con el aviso «Estás editando tu relevo». Se repitió dos veces, con el mismo resultado.

**La causa probable,** en `ui/RelevoApp.kt`, en la ruta `Route.ACTIVE`: `editActive()` saca el relevo de la lista de activos y después la app navega a `PREPARE`. La pantalla del relevo activo sigue dibujándose durante la transición. Al no encontrar el relevo, su `LaunchedEffect` ejecuta `replace(listOf(Route.TABS))` y deja la app en Inicio. Corregirlo, por ejemplo haciendo que ese `LaunchedEffect` solo actúe si la ruta de arriba todavía es `ACTIVE`, queda pendiente de que el autor lo pida. No se grabó este flujo, para no mostrar el error como funcionamiento.

## Registro de cambios (disclaimer)

### 2026-11-23 — Creación

- **Qué se añadió:** 10 GIF y 10 MP4 de los flujos, 110 capturas, una hoja de contacto y la descripción de un error de «Editar» en el relevo activo.
- **Cómo estaba antes:** la 4.8.2 no se había abierto en un teléfono ni en un emulador, y no tenía capturas.
- **Por qué:** el autor pidió un GIF de cada pantalla e interacción (crear un relevo, la primera vez, editar el perfil, cuando suena) y capturas de todas las pantallas de la versión más reciente, con los íconos nuevos y su nombre.
