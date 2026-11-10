# Android 4.6.3: el pulido y la señal que sonaba dos veces

**Fecha:** 7 de noviembre de 2026. **Decisión:** [D-167](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.6`. **Versión:** 4.6.3, `versionCode` 60. **APK:** [relevo-android-4.6.3-2026-11-07.apk](releases/relevo-android-4.6.3-2026-11-07.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.6.2 y de las anteriores sin perder datos. SHA-256: `52BF7375034F4F3668FE9B830CF985882C59FDF4E314FFE19E9059F79F7E439A`.

## Qué se pidió

El autor preguntó si quedaba algún detalle por arreglar y pidió dejar la app lo más pulida posible.

## Cómo se revisó

Se recorrió la app en una copia aparte (paquete `cl.udp.relevo.prueba`), sin conexión de principio a fin:
- la primera vez, Inicio, Actividades (las tres pestañas), Perfil y Ajustes (Sonido, Horas sin sonar, Avisos, Apariencia, Permisos);
- un relevo activo, su menú, la señal, las cuatro preguntas, «¿Qué decidiste?» y «Dejarla lista»;
- el tema oscuro y la letra al 200 %.

Para ver la señal sin esperar 15 minutos, el relevo de prueba se acortó a 20 segundos en los datos de la copia.

Además, se revisaron los 1381 textos del inventario buscando puntos suspensivos, comillas rectas, dobles espacios, mayúsculas sostenidas y signos sin abrir. No apareció ninguno.

## Lo más importante: la señal sonaba dos veces

**Qué pasaba:** después de «Dejarla lista», la señal volvió a sonar para el mismo relevo, menos de un segundo después de responder. En el registro de la copia quedaron dos `signal_emitted` con la misma sesión, y «Esta semana» contó dos relevos.

**Por qué:**
1. Al cumplirse el tiempo, el servicio pasa el relevo a la memoria de «lo que suena» mientras empieza a sonar. En ese instante todavía figura como «contando» (`WAITING`).
2. Al abrir la app o al arrancar el servicio, un paso pensado para traer los datos de la 4.2 (`ActiveStore.migrate`) revisaba esa memoria cada vez. Si encontraba un relevo «contando», lo devolvía a la lista de relevos activos.
3. Si la app se abría justo en ese instante, el relevo quedaba en las dos partes. Siguió contando en segundo plano y, al responder, volvió a sonar. En la prueba, la app se abrió sola con la señal.

Con el Tag, ese instante dura hasta 30 segundos, lo que tarda en conectarse.

**Arreglo:**
- El paso desde la 4.2 se hace una sola vez y queda marcado (`data/ActiveStore.kt`).
- Al responder, el relevo respondido se quita de los activos, por si quedó ahí de antes (`ui/RelevoViewModel.kt`). Eso también limpia los teléfonos donde ya pasó.

## Los demás detalles

| Dónde | Antes | Ahora |
| --- | --- | --- |
| Perfil › Apps | Las que cuentan el tiempo (como si las apps contaran) | En las que se cuenta el tiempo |
| Avisos › Activación automática | …Después de cada relevo espera 30 minutos. | …Después de cada relevo, espera 30 minutos antes de volver a activarlo. |
| Avisos › Veces por semana | Cuántas veces quieres hacerlo. | Cuántas veces a la semana quieres hacer tus actividades. |
| «¿La dejas lista para después?» | No suena sola. | No sonará sola. |
| Inicio, «Para después» | 15 min en Chrome · suena en tu teléfono | … · sonará en tu teléfono |
| Menú del relevo activo | Título «Relevo», como el nombre de la app | El nombre de la actividad, por ejemplo «Leer» |
| Permisos | Solo algunas filas tenían flecha, así que los valores no quedaban alineados, y «Batería del teléfono» se partía en dos líneas junto a «Con restricciones» | Las tres filas se tocan y llevan flecha, y la batería dice «Permitida» o «Restringida». «Notificaciones» abre sus ajustes en Android: ahí se encienden aunque Android ya no muestre su pregunta. |
| Horas sin sonar | El «+» de «Desde las 23:00» quedaba apagado; no se podía pasar a las 0:00 | La hora da la vuelta: de 23 a 0 y de 0 a 23 |
| Horas sin sonar, con TalkBack | Los cuatro botones se leían «Restar» o «Sumar», sin decir cuál hora | «Sumar, Desde las 23:00» |
| Barra de pestañas, letra al 200 % | «Actividades» se cortaba en «Activida» | Los nombres crecen con la letra del teléfono hasta 1,3 veces, como en las barras de iOS, y caben |

## Qué se dejó igual

- **Las preguntas después de la señal,** como «¿Notaste el aviso apenas sonó?». Son las preguntas del registro del estudio; cambiarlas cambia lo que se mide.
- **Los dos botones de «¿La dejas lista para después?»** pesan lo mismo a propósito: ninguna respuesta es mejor que otra.
- **«Ver todas» en gris junto a «Actividades»:** es el enlace de un encabezado, como en iOS. «Ver ideas» va en tinta porque es una acción aparte.
- **El título «Horas sin sonar» y su interruptor con el mismo nombre:** es el patrón de Ajustes de iOS, como «Wi-Fi».

## Verificación

- **Compilación desde cero:** 99 pruebas unitarias sin fallas, dos de ellas nuevas para la hora que da la vuelta. Las únicas advertencias son de la API experimental de Haze en `ui/components/Edges.kt`, que no se tocó.
- **APK:** paquete `cl.udp.relevo`, versión 4.6.3 (`versionCode` 60), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **En la copia aparte, con la 4.6.3:**
  - **La señal:** se repitió el caso, es decir, un relevo de 20 segundos, la señal, las preguntas y «Dejarla lista». Durante 50 segundos no volvió a sonar, Inicio mostró «Para después» y la lista de activos quedó vacía.
  - **El instante en que fallaba:** se dejó el relevo «contando» en la memoria de lo que suena y se abrió la app. Esta vez no volvió a la lista de activos.
  - **Permisos:** las tres filas quedan alineadas y «Batería del teléfono» cabe en una línea. «Notificaciones» abrió los ajustes de notificaciones de Relevo en Android.
  - **Horas sin sonar:** pasó de 23:00 a 0:00 con «+» y volvió a 23:00 con «−».
  - **Textos y menú:** los textos nuevos y el título «Leer» del menú se leen en pantalla.
  - **Letra al 200 %:** «Actividades» cabe en la barra (76 dp en una pestaña de 92 dp).
  - **Al terminar:** la copia se desinstaló, la letra volvió al 100 % y el emulador volvió a tener conexión. La app del autor no se tocó.

**Falta probar:** el caso de la señal doble con un Tag real, que es donde ese instante dura más, y la 4.6.3 en un teléfono real.

## Registro de cambios (disclaimer)

### 2026-11-07 — Creación

- **Qué cambió:** se documenta el recorrido de pulido de la 4.6.3, el arreglo de la señal que sonaba dos veces y los demás detalles.
- **Cómo estaba antes:** la señal podía sonar dos veces si la app se abría justo al cumplirse el tiempo, y quedaban textos y detalles de diseño sin revisar en pantalla.
- **Por qué:** el autor pidió dejar la app lo más pulida posible.
