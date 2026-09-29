# Android 2.13: guía de la primera vez, intereses concretos y nombre guardado aparte

**Fecha:** 29 de septiembre de 2026. **Versión:** 2.13 (`versionCode 25`). **Rama:** `android-2.7`. **Consentimiento en la app:** `2026-09-29-v9`.
**Base:** [Android 2.12](version-2.12-mas-simple-y-mas-datos-2026-09-29.md). La 2.13 explica paso a paso cómo usar la app la primera vez, cambia los intereses amplios por actividades de las entrevistas, guarda el nombre aparte, muestra un resumen del relevo activo en Inicio y ajusta el audio del video. Cada cambio se contrastó con la memoria en [coherencia de la app con la memoria](../../08_memoria/coherencia-app-con-la-memoria-2026-09-29.md).

## Qué pidió el autor

> «"crear con las manos" "cudiar la casa y a mi" no se, son muy ambiguas ,.deberia nser actividades ams concretas , inspiradas en las encuestas al usaurio (entevistas) seria bueno que cuand oel usaurio se registra, obviaemnte guardamos su noimbre. bueno a lo que voy, su primera vez debe tener un tutorial guaido explicando CADA COSA de lo principal, es decir como funciona uan actividad, etc. PD: el audio se escucha saturado n ose por que, incluso sient un pitido constante en la app. en inicio cuando hay u nreleov activo seria util u nresumen de cosas, si es que hay o quizas no, depende de la memoria. Me interesa mucho que siempre respondamos a nuestra memoria, amrco teorico y demas. Si algo se contradice me lo haces saber, si algo es nuevo pero se fudnamenta con el marco, perfecto.»

Después, ante la pregunta por el nombre: «deberiamso guardar el nombre, en base a que tgoammos esa decisi0n? proque veo improtante tener ese registro del usaurio». Sobre el aviso semanal eligió «Preguntar Sí/No al inicio».

## Qué cambió

| Pedido | En la app |
| --- | --- |
| Actividades concretas | Los cinco intereses amplios de la 2.8 («Moverme», «Leer», «Crear con las manos», «Cuidar la casa y a mí», «Aprender algo») pasan a doce: dormir a tiempo, leer, hacer ejercicio, salir en bicicleta, pasear o jugar con tu perro, dibujar o pintar, manualidades o maquetas, cocinar, ordenar tu pieza, meditar, estudiar o hacer tareas, y compartir con alguien. Cada uno tiene tres pasos concretos y cita en el código las respuestas de P1–P8 que lo sostienen. Las ideas de Inicio también salen solo de las entrevistas: se sumaron «Dormir a tiempo», «Armar una maqueta», «Salir en bicicleta», «Meditar», «Leer manga» y «Ordenar tu pieza», y se quitaron «Tocar un instrumento», «Cuidar las plantas» y «Escribir», que no aparecen en el corpus. |
| Guardar el nombre | El nombre es obligatorio al registrarse (el emoji y los intereses se pueden saltar). Se guarda en una tabla aparte de Supabase, `relevo_participants`, solo con el código; las tablas de relevos, respuestas y uso siguen sin nombre. El investigador lo ve en `analisis.participantes`. «Borrar mis datos» también lo borra. |
| Guía de la primera vez | «Cómo funciona» pasa a ser una guía de nueve pantallas cortas, antes del consentimiento: qué es Relevo (con el video), anotar la actividad, el primer paso, dónde dejar el parlante, cuándo avisa, qué pasa cuando suena, cómo se responde, ideas, ruta y actividades, y una última pregunta por el aviso semanal. Cada pantalla trae un ejemplo con el aspecto de la app. Se puede saltar. Después, en el primer relevo, cada paso de la preparación, la señal y la respuesta muestra una nota corta que dice qué hacer y para qué; las notas desaparecen después del primer relevo. Inicio muestra «Empieza aquí» mientras no haya relevos. |
| Aviso semanal | Vuelve a empezar apagado (en la 2.12 empezaba encendido). La guía pregunta «Sí, avísame» o «No, gracias», sin respuesta marcada; la respuesta se registra. |
| Resumen del relevo activo | Bajo la foto del relevo activo, Inicio muestra «Tu relevo»: cómo empezar, dónde está el parlante (o dónde empiezas), las apps que cuentan, cuánto falta, la condición de la semana si la hay y «Ver o desactivar». No muestra rachas ni comparaciones. |
| Audio saturado | La música del video de la guía se rehízo para parlantes de teléfono: en mono, sin los graves bajo 180 Hz (el bombo y el zumbido del comienzo, que un parlante pequeño distorsiona), con los agudos repetidos más suaves y un pico de −6 dBFS (antes −1). La señal de Relevo no cambió: su pico es −3 dBFS, como en la receta de D-071. |
| Registrar la guía | Lo que la persona hace en la guía antes de aceptar (pantallas vistas, cuánto del video vio, la respuesta del aviso semanal) queda en memoria y se guarda recién al aceptar, marcado «antes_de_aceptar». Si no acepta, se pierde. |

## Sobre el pitido y el sonido saturado

No se pudo escuchar el audio en un teléfono. Hay dos causas probables:

1. **El video:** tenía graves muy bajos y un pico casi al máximo. En un parlante de teléfono, eso suena saturado. Se corrigió.
2. **El emulador:** entre la 00:03 y la 00:41 del 29 de septiembre hubo uso de la app en el emulador con el código `9P6E` (no fueron pruebas de esta revisión), con una señal a las 00:16. El audio del emulador en Windows suele sonar entrecortado o con zumbido. Si el pitido aparece en un teléfono real, hay que anotar en qué pantalla y avisar.

## Comprobaciones

En un emulador Android 16, con conexión y datos de prueba:

- 61 pruebas unitarias pasan (las de rutas se actualizaron a los intereses nuevos) y el APK sale de una compilación limpia.
- **Guía:** las nueve pantallas, con sus ejemplos. Con «No, gracias», el aviso quedó apagado; «Sí, avísame» se eligió en otra prueba, pero no se revisó el ajuste guardado.
- **Registro:** el nombre llegó a `relevo_participants` con el código; en la tabla de uso llegaron las pantallas de la guía, el video y los permisos con la marca «antes_de_aceptar», y después el consentimiento, el nombre (sin su texto) y el perfil.
- **Intereses concretos:** la cuadrícula muestra los doce con foto o icono; la ruta de «Leer» empieza en «Leer 10 páginas».
- **Primer relevo guiado:** la nota de cada paso de la preparación, «Empieza aquí» en Inicio, la nota en la señal y en la respuesta; las caras ya no se recortan.
- **Resumen del relevo activo:** apareció bajo la foto con cómo empezar, el lugar, las apps y cuánto falta.
- **Borrar mis datos:** dejó en 0 las filas del código de prueba, también en `relevo_participants`.

Los datos de prueba se borraron desde la app. Los del código `9P6E` y de `P-54F8805B` se dejaron intactos, porque no eran de estas pruebas. Los datos del emulador se respaldaron antes y se restauraron después.

## Lo que no se comprobó

- El audio en un teléfono real y con el parlante.
- La guía con personas: si se entiende y si pesa (criterio 6 de la memoria).
- El borrado sin conexión.

## Registro de cambios (disclaimer)

### 2026-09-29 — Creación

- **Qué se añadió:** el registro de Android 2.13: guía de la primera vez, intereses e ideas de las entrevistas, nombre guardado aparte, aviso semanal preguntado, resumen del relevo activo, audio del video y registro de la guía.
- **Cómo estaba antes:** la 2.12 tenía una pantalla de «Cómo funciona», cinco intereses amplios, el nombre solo en el teléfono y el aviso semanal encendido.
- **Por qué:** pedidos del autor del 29 de septiembre (D-088 y D-089).
