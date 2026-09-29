# Android 2.11: «Cómo funciona», video vertical y datos guardados en dos lugares

**Fecha:** 28 de septiembre de 2026. **Versión:** 2.11 (`versionCode 23`). **Rama:** `android-2.7`. **Consentimiento en la app:** `2026-09-28-v7`.
**Base:** [Android 2.10](version-2.10-participacion-y-claridad-2026-09-27.md). La 2.11 prepara la app para el primer testeo real: explica cómo usarla la primera vez, con el video de Relevo en vertical, y asegura que cada dato quede en Supabase y en una copia en el teléfono. No cambia la lógica de la prueba ni la interfaz de las demás pantallas.

## Qué pidió el autor

> «no se que tal esta la ultima version de la app, revisala, dejala lista para el primer testeo real. por ahora la opcion de parlante o telefono se mantiene. Necesitamos que se xplique bien y facil en la primera vez que la spersoan entra, como usar la app. podrias agregar e lvideo incluso, el ultimo que hiciste, pero habri que ajustarlo a vertical. y es importante que TODO se guarde de verdad en nuyestra abse de datos y en el telefono localmente, para tener copia de resultados y estadisticas.»

## Revisión de la 2.10

Antes de cambiar nada se revisaron el registro local, el envío a Supabase y la base remota:

- **Esquema:** las tablas, columnas y restricciones de Supabase coinciden con lo que envía la app. Los largos máximos de los campos de texto de la app (120 caracteres) caben en los de la base.
- **Respuestas:** la tabla `relevo_answers` nunca había recibido una fila: hasta la 2.10, las respuestas solo se habían probado sin conexión. En esta revisión se comprobó con red que llegan (ver «Comprobaciones»).
- **Lo que faltaba para el análisis:** la base guardaba la condición de la semana, pero no por dónde sonó de verdad cada aviso (parlante o teléfono) ni con qué versión de la app se hizo cada relevo.
- **Riesgo de pérdida:** los datos pendientes vivían solo en la base interna de la app. Si la persona desinstalaba la app sin conexión, o la base remota rechazaba una fila, no quedaba otra copia.
- **Salida del sonido:** se mantiene como estaba. Durante la prueba, la condición de la semana fija si suena el parlante o el teléfono; el día 0 y fuera de la prueba, la persona elige.

## Qué cambió

| Pedido | En la app |
| --- | --- |
| Explicar cómo usar la app la primera vez | Después de la bienvenida y antes del consentimiento aparece «Cómo funciona»: el video arriba y cinco pasos numerados (elegir qué hacer; elegir apps y tiempo; dejar el parlante donde se empieza; cuando suena, decidir; responder con un toque). Una nota dice que en la prueba el objeto es un parlante Bluetooth y dónde se guardan los datos. La misma pantalla se abre después desde Perfil › Ayuda › «Cómo funciona Relevo». |
| El video, en vertical | El video de 30 segundos se rehízo en 1080 × 1920 con la misma animación y banda sonora. En la app va una versión liviana (720 × 1280, 30 cuadros por segundo, 2 MB). Empieza sin sonido y tiene botones para activar el sonido, pausar y verlo de nuevo; tocarlo lo pausa. Con «Reducir movimiento» de Android no empieza solo. |
| Que todo se guarde en la base de datos | Cada relevo guarda además la salida real del sonido (`signal_route`: `bluetooth` o `phone`) y la versión de la app (`app_version`), en el teléfono y en Supabase. Al aceptar el consentimiento, la app envía de inmediato lo pendiente. |
| Y en el teléfono, como copia | Cada vez que la app intenta enviar datos, haya o no conexión, escribe una copia en la carpeta **Documentos/Relevo** del teléfono: `relevo-<código>.json` (todo el registro del estudio) y dos tablas que se abren en una planilla, `relevo-<código>-relevos.csv` y `relevo-<código>-respuestas.csv`. La copia no incluye el nombre ni la imagen del perfil. Queda aunque se desinstale la app, y se borra con «Borrar mis datos». Privacidad y datos muestra «Copia en el teléfono» con la hora de la última copia. |
| Estadísticas | En Supabase se creó el esquema `analisis`, no expuesto a la app, con tres vistas: `analisis.relevos` (cada relevo con horas de Chile), `analisis.resumen_por_condicion` (por persona y condición: relevos, señales, qué decidió, si supo qué hacer, mediana del tiempo de respuesta y uso de las apps 10 minutos antes y después) y `analisis.respuestas`. Se consultan desde el editor SQL del panel de Supabase. |
| Consentimiento | El texto dice que existe la copia en Documentos/Relevo y que se borra al pedir la eliminación. Por eso sube a la versión `2026-09-28-v7`: quien tenía la 2.10 instalada debe aceptarlo de nuevo. La [hoja de consentimiento](../../07_validacion/consentimiento-android-vigente-2026-09-23.md) se actualizó igual. |

El SQL de estos cambios está al final de [base-remota-supabase.sql](base-remota-supabase.sql) y se aplicó en el proyecto de Supabase el 28 de septiembre.

## Comprobaciones

En un emulador Android 16 (API 36), **con conexión** y datos de prueba:

- 58 pruebas unitarias pasan y el APK sale de una compilación limpia.
- **Primera vez:** bienvenida, «Cómo funciona» con el video reproduciéndose hasta el final y los cinco pasos, consentimiento v7, permiso de Tiempo de uso y perfil.
- **Prueba:** desde Perfil › Prueba de 21 días se eligió una secuencia. La respuesta `prueba_inicio` llegó a Supabase: es la primera fila que recibe `relevo_answers`.
- **Dos relevos de 15 segundos** con YouTube y salida por el teléfono: señal, «Silenciar y continuar», las dos preguntas y la decisión. En Supabase quedaron ambas sesiones con `signal_route = phone`, `app_version = 2.11`, la decisión, las respuestas a las preguntas, el fin del sonido, el tiempo de respuesta y el uso de los 10 minutos anteriores, además de sus eventos.
- **Copia en el teléfono:** los tres archivos aparecieron en Documentos/Relevo con los mismos datos. El CSV de relevos tiene 25 columnas y las horas en formato ISO.
- **Borrar mis datos:** dejó 0 filas de ese código en las tres tablas de Supabase y vació Documentos/Relevo.
- **Sin conexión** (modo avión): al empezar la prueba, el dato quedó pendiente y la copia se escribió igual. Al volver la red, se envió en cuanto se abrió la app.
- **Actualización desde la 2.10:** con una copia de los datos que ya tenía el emulador (base local versión 5), la app pasó a la versión 6 sin errores y la copia incluyó las columnas nuevas.

Los datos de prueba se borraron desde la app; Supabase quedó con las mismas filas que antes de la prueba (8 sesiones, 9 eventos y 0 respuestas). Los datos que ya tenía el emulador se respaldaron antes y se restauraron después, sin enviar nada.

## Lo que no se comprobó

- El teléfono real de la prueba ni un parlante Bluetooth: el emulador no tiene Bluetooth, así que la salida por parlante no se probó en esta versión.
- Otras versiones de Android: la copia usa la carpeta Documentos por medio de MediaStore, que existe desde Android 10, pero solo se probó en Android 16.
- Las tarjetas del cierre de cada semana y del día 21 con conexión: requieren adelantar la fecha. Usan el mismo camino que la respuesta `prueba_inicio`, que sí se comprobó.
- El uso de las apps en los 10 minutos posteriores a la señal se calcula al abrir la app pasados esos 10 minutos; en esta prueba no se esperó.

## Límites conocidos

- **Envío:** la app envía al activar un relevo, al sonar la señal, al responder y al abrirse. Si no hay conexión en esos momentos, lo pendiente espera hasta la próxima vez que se abra la app. Nada se pierde, porque también queda en la copia.
- **Reinstalación:** si la app se desinstala y se vuelve a instalar, la nueva instalación no puede borrar las copias de la anterior (Android no se lo permite). Esas copias quedan en Documentos/Relevo hasta que alguien las borre con un explorador de archivos.
- **Parlante apagado:** si el parlante no está conectado cuando se cumple el tiempo, el aviso no suena y queda registrado como `signal_failed`. La app no cambia sola al teléfono, porque eso mezclaría las condiciones de la prueba.
- **Tamaño:** el APK de depuración pesa unos 41 MB; el video suma 2 MB.

## Para el primer testeo

1. Instalar el [APK 2.11](releases/relevo-android-2.11-2026-09-28.apk) en el teléfono de la persona (Android 12 o posterior).
2. Ver juntos «Cómo funciona», aceptar el consentimiento, dar el permiso de Tiempo de uso y las notificaciones, y quitar la restricción de batería si la app lo pide.
3. En Perfil › Prueba de 21 días, elegir la secuencia. Con tres personas, las secuencias 1 (A → B → C), 4 (B → C → A) y 5 (C → A → B) hacen que cada condición quede una vez primera, una vez segunda y una vez tercera. Hoy [D-081](../../09_decisiones/registro-de-decisiones.md) dice que la prueba es con una persona; ampliarla es una decisión pendiente del autor.
4. Conectar el parlante, usar «Probar el sonido» y hacer un primer relevo con «Probar con 15 segundos».
5. Anotar el código de participación (Privacidad y datos) en la hoja de consentimiento firmada, que se guarda aparte.
6. Durante la prueba, revisar en Supabase `analisis.resumen_por_condicion`. Al final, copiar la carpeta Documentos/Relevo del teléfono por cable, como respaldo.

## Registro de cambios (disclaimer)

### 2026-09-28 — Creación

- **Qué se añadió:** el registro de Android 2.11: revisión de la 2.10, «Cómo funciona» con el video vertical, la salida y la versión en cada relevo, la copia en Documentos/Relevo, las vistas de análisis en Supabase, el consentimiento v7, las comprobaciones, los límites y los pasos para el primer testeo.
- **Cómo estaba antes:** la versión más reciente era la 2.10, sin explicación inicial ni copia de los datos fuera de la app.
- **Por qué:** el autor pidió dejar la app lista para el primer testeo real, con una explicación clara la primera vez, el video en vertical y todos los datos guardados en la base y en el teléfono.
