# Android 4.6.2: textos que dicen qué cuentan y el Bluetooth solo al buscar el Tag

**Fecha:** 7 de noviembre de 2026. **Decisión:** [D-166](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.6`. **Versión:** 4.6.2, `versionCode` 59. **APK:** [relevo-android-4.6.2-2026-11-07.apk](releases/relevo-android-4.6.2-2026-11-07.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.6.1 y de las anteriores sin perder datos. SHA-256: `41811237B8FB9AA44CAE8621E6A932001A7EC319D131FFA58131E89A7891D82F`.

## Qué se pidió

El autor señaló textos que confunden:
- «Deja de contar»: ¿contar qué?
- «Suena en tu teléfono», para algo que todavía no pasa, debería ser «sonará».
- «Batería: para que Relevo siga contando aunque pasen días»: ¿batería de qué?, ¿contar qué?
- «El perfil»: ¿el de quién?
- «Ej.: leer 10 páginas»: ¿de qué?

Pidió corregir ese tipo de fallas en toda la app. Además, decidió que el permiso de Bluetooth se pida solo al tocar un botón relacionado con el Tag, y no al entrar a «¿Dónde suena?».

## Las reglas que se aplicaron

Se revisaron los 1381 textos de la app buscando las mismas cinco fallas, no solo los ejemplos señalados.

1. **«Contar» siempre dice qué se cuenta:** el tiempo en tus apps. «Deja de contar» pasa a «Se deja de contar el tiempo».
2. **Lo que todavía no pasa va en futuro:** «sonará», no «suena». El presente queda para lo que ocurre ahora, como «Suena en el Tag» mientras suena, y para explicar cómo funciona, como «¿Dónde suena?».
3. **Lo que es de la persona lleva «tu»:** «tu perfil», «tu nombre».
4. **Los ejemplos se completan:** «leer 10 páginas de un libro».
5. **Los títulos dicen de qué se trata:** «Batería del teléfono», porque el Tag también tiene batería. El texto dice además por qué importa: Android puede detener Relevo para ahorrar batería.

Un caso aparte: «El volumen multimedia del teléfono también cuenta» usaba «cuenta» en el sentido de «importa», justo en una app que cuenta tiempo. Pasa a «también influye».

## Antes y ahora

| Dónde | Antes | Ahora |
| --- | --- | --- |
| Aviso de batería (Inicio y paso 6) | **Batería.** Para que Relevo siga contando aunque pasen días. | **Batería del teléfono.** Android puede detener Relevo para ahorrar batería. Quita la restricción para que siga contando el tiempo en tus apps aunque pasen días. |
| Ajustes | Batería | Batería del teléfono |
| Inicio, el relevo activo | Contando · Suena en tu teléfono | Contando el tiempo · Sonará en tu teléfono |
| Hoja al activar | El relevo está contando. Suena en tu teléfono cuando sumes 15 min en Chrome. | El relevo está contando el tiempo. Sonará en tu teléfono cuando sumes 15 min en Chrome. |
| Hoja al activar | Mientras tanto, puedes completar el perfil: el nombre y lo que… · Completar el perfil | Mientras tanto, puedes completar tu perfil: tu nombre y lo que… · Completar tu perfil |
| Aviso de Inicio | **Completa el perfil.** El nombre y lo que te gustaría hacer más seguido. | **Completa tu perfil.** Tu nombre y lo que te gustaría hacer más seguido. |
| Perfil | Editar el perfil | Editar tu perfil |
| Menú del relevo | Deja de contar y no suena. | Se deja de contar el tiempo y no sonará. |
| Eliminar un relevo | Deja de contar, no suena y no queda en Relevos. | Se deja de contar el tiempo, no sonará y no quedará en Relevos. |
| Terminar antes | Deja de contar y no suena. Después puedes decir qué decidiste. | Se deja de contar el tiempo y no sonará. Después puedes decir qué decidiste. |
| Editar el relevo | Mientras lo editas no cuenta. | Mientras lo editas, no se cuenta el tiempo. |
| Paso 1 | Ej.: leer 10 páginas | Ej.: leer 10 páginas de un libro |
| Paso 4 | Elige las apps · Apps que cuentan | Elige las apps · En las que se cuenta el tiempo |
| Paso 4 | Al empezar, conviene un tiempo breve: suena antes de que te pierdas en las apps. | …: sonará antes de que te pierdas en las apps. |
| Paso 4, sin apps | Elige al menos una app que cuente. | Elige al menos una app en la que contar el tiempo. |
| Inicio, avisos | Relevo no puede contar · Horas sin sonar: vuelve a contar a las 8:00 | Relevo no puede contar el tiempo · Horas sin sonar: vuelve a contar el tiempo a las 8:00 |
| Ajustes | Todo listo para contar · En esas horas Relevo no cuenta ni suena. | Todo listo para contar el tiempo · En esas horas, Relevo no cuenta el tiempo ni suena. |
| Ajustes | Al abrir las apps del último relevo, empieza a contar solo. | Al abrir las apps del último relevo, Relevo lo activa solo y empieza a contar el tiempo. |
| Paso 5 y Ajustes | El volumen multimedia del teléfono también cuenta. | El volumen multimedia del teléfono también influye. |
| Borrar los datos | …Sales del proyecto y Relevo deja de contar. | …Sales del proyecto y Relevo deja de contar el tiempo en tus apps. |
| Señal, al volver a probar | Todavía no suena. | Tampoco sonó. |
| Notificación permanente | Contando para «Leer» · Suena al sumar 15 min | Contando el tiempo para «Leer» · Sonará al sumar 15 min |
| Notificación, Tag sin respuesta | El Tag no responde; si sigue así, suena en tu teléfono | …, sonará en tu teléfono |
| Notificación de permiso perdido | Dejó de contar | Dejó de contar el tiempo |

Se cambiaron 48 lugares del código, en siete archivos. Los que no están en la tabla siguen las mismas reglas y se ve en el [inventario de textos](textos/inventario-de-textos.md).

## Qué no se cambió

- **El texto del consentimiento,** como «Relevo cuenta solo las que eliges»: cambiarlo exige una nueva versión del consentimiento. Además, ahí «las» ya dice qué se cuenta: las apps.
- **«¿Cuándo suena?» y «¿Dónde suena?»:** preguntan cómo funciona el relevo, no anuncian algo.
- **«Suena en el Tag»** en la pantalla de la señal: se muestra mientras está sonando.

## El permiso de Bluetooth

**Antes:** el Tag viene elegido por defecto en «¿Dónde suena?» y la búsqueda empezaba sola al llegar. Por eso Android pedía el permiso de dispositivos cercanos apenas se entraba al paso, aunque la persona no tuviera un Tag.

**Ahora:** el permiso se pide solo al tocar algo del Tag: «Buscar el Tag», «Buscar de nuevo», «Buscar mi Tag» al final de la guía, «Ver todos los aparatos cercanos» o «Probar el Tag». La búsqueda sola al llegar ocurre únicamente si el permiso ya estaba dado. Bajo el botón sigue el aviso «Para buscarlo, Android te pedirá permiso para encontrar dispositivos cercanos».

El cambio está en `ui/PrepareScreen.kt`. Es el único lugar de la app que pide este permiso.

## Lo que apareció al revisar: el aviso del primer relevo

Al activar el primer relevo, Android pregunta por el permiso de notificaciones mientras el servicio que cuenta el tiempo ya arrancó. El aviso permanente «Contando el tiempo para…» se publicaba antes de tener el permiso y quedaba oculto: no aparecía en la cortina de notificaciones hasta reiniciar la app o el teléfono. El relevo contaba y sonaba igual; solo faltaba el aviso.

**Arreglo:** el servicio recuerda si publicó el aviso sin permiso y, en cuanto lo tiene, lo publica de nuevo (`monitor/AppUsageMonitorService.kt`).

## Verificación

- **Compilación desde cero:** 97 pruebas unitarias, sin fallas. Las únicas advertencias son de la API experimental de Haze en `ui/components/Edges.kt`, que no se tocó.
- **APK:** paquete `cl.udp.relevo`, versión 4.6.2 (`versionCode` 59), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **En una copia aparte** (paquete `cl.udp.relevo.prueba`), sin conexión de principio a fin:
  - **La primera vez:** el ejemplo del paso 1, «En las que se cuenta el tiempo», el aviso «Batería del teléfono», la hoja «El relevo está contando el tiempo» y el Inicio con «Contando el tiempo», «Sonará en tu teléfono» y «Completa tu perfil» se leen en pantalla como en la tabla.
  - **Bluetooth:** al entrar a «¿Dónde suena?» no apareció ningún diálogo, y Relevo siguió al frente. Al tocar «Buscar el Tag» apareció el permiso de Android. Al rechazarlo apareció «Falta un permiso», y se pudo seguir con «Notificaciones».
  - **El aviso permanente:** con el permiso de notificaciones quitado, el servicio contaba sin aviso visible. Al dar el permiso, el aviso «Contando el tiempo para «Leer»» · «Sonará al sumar 15 min» apareció en 3 segundos.
  - **Al terminar:** la copia se desinstaló y el emulador volvió a tener conexión. La app del autor no se tocó.
- **Inventario:** se regeneró. Fuera del consentimiento, ningún «contar» quedó sin decir qué cuenta.

**Falta probar:** los textos de Ajustes y de las notificaciones de permisos en pantalla (se revisaron en el código y en el inventario), y la 4.6.2 en un teléfono real con un Tag.

## Registro de cambios (disclaimer)

### 2026-11-07 — Creación

- **Qué cambió:** se documentan las reglas de escritura, los textos corregidos, el permiso de Bluetooth y el arreglo del aviso permanente de la 4.6.2.
- **Cómo estaba antes:** varios textos decían «contar» sin decir qué, anunciaban en presente lo que aún no pasa o hablaban de «el perfil». Android pedía el Bluetooth al entrar a «¿Dónde suena?».
- **Por qué:** el autor señaló esos textos como confusos y decidió pedir el Bluetooth solo al tocar algo del Tag.
