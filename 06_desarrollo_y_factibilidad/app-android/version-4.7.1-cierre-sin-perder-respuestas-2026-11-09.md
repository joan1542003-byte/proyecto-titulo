# Android 4.7.1: el cierre sin perder respuestas, y el panel al día

**Fecha:** 9 de noviembre de 2026. **Decisión:** [D-176](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.6`. **Versión:** 4.7.1, `versionCode` 62. **APK:** [relevo-android-4.7.1-2026-11-09.apk](releases/relevo-android-4.7.1-2026-11-09.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.7 y de las anteriores sin perder datos. SHA-256: `1D526964692181C4A1D3BF3F6CCEA01576D49A237BC06699D8565150D52D6F85`.

## Qué se pidió

El autor preguntó si el instrumento de cierre estaba actualizado, porque recordaba una entrevista más reciente. Pidió que esté integrado en la app, que se suba a Supabase y que se vea en el panel de Relevo, sin perder ningún dato ni respuesta.

## El instrumento: no hay uno más reciente

Se buscó en todas las ramas del repositorio, en las conversaciones con la IA y en las carpetas del autor:

- **Para las personas de la prueba, el más reciente es el del 28 de octubre** ([instrumento de cierre](../../07_validacion/instrumentos/instrumento-de-cierre-2026-10-28.md), D-144). El Anexo I de los anexos para Word, del 9 de noviembre, copia las mismas preguntas; solo cambia la forma de la pregunta 3 de la entrevista. Es el que tiene la app desde la 4.7.
- **Lo posterior, del 2 de noviembre, son otras entrevistas:**
  - la guía de los profesores para la entrevista semiestructurada y el análisis del discurso, con un guion de ejemplo;
  - la guía de entrevista a expertos, que sigue esa guía (rama `claude/funny-bohr-yvmki9`, sin fusionar).
- **Lo que esa guía pide y la entrevista del 28 de octubre aún no cumple:** preguntas abiertas, nunca de sí o no; un orden de lo general a lo particular, y una pregunta final proyectiva. Varias preguntas de la entrevista de cierre empiezan con «¿Supiste…?», «¿Lo moviste?» o «¿Falló algo?». Ajustarla queda para el autor, porque cambiaría el instrumento.

## Qué cambió en la app

**La 4.7 saltaba las preguntas que la persona ya había respondido en el teléfono.** Era un riesgo de perder respuestas. Las claves `semana1_*` y `cierre_*` también las usaron las tarjetas de la prueba de 21 días, con otro sentido: la primera semana y la semana que más ayudó. Si alguien las tenía guardadas, la app podía dar por respondida la semana con el teléfono y no preguntarla.

**Desde la 4.7.1, se muestran siempre todas las preguntas.** Lo respondido antes queda guardado con su fecha y no se borra. La persona solo retoma desde la parte en que quedó.

## Ningún dato se pierde

- **Al actualizar la app:** la base de datos del teléfono tiene la misma versión (9) desde la 2.33 hasta la 4.7.1, así que actualizar no borra ni transforma nada. Lo que no se había enviado, como los datos de quienes usaban la app sin conexión, se sube a Supabase.
- **Lo que se respondió en papel** no está en el teléfono: si la misma persona responde en la app, quedan las dos respuestas, con su fecha.
- **En Supabase no se borró ni cambió nada.** Las nueve tablas de Relevo tenían las mismas filas antes y después de este trabajo:

| Tabla | Filas |
| --- | --- |
| `relevo_answers` | 23 |
| `relevo_sessions` | 25 |
| `relevo_events` | 587 |
| `relevo_app_events` | 924 |
| `relevo_daily_usage` | 234 |
| `relevo_participant_state` | 2 |
| `relevo_participants` | 2 |
| `relevo_messages` | 8 |
| `relevo_message_receipts` | 3 |

Todavía no hay respuestas del cierre en Supabase: llegarán cuando las personas respondan en la app 4.7.1.

## El panel de Relevo

- **En la ficha de cada persona:** nueva sección «Cierre de la prueba», con su salto «Cierre». Muestra las cuatro partes en el orden del instrumento, cada pregunta con su respuesta en palabras y su fecha. Si una pregunta se respondió más de una vez, aparecen todas las respuestas: ninguna se oculta. La consulta trae todas las respuestas del cierre de la persona, sin el límite de 80 de las demás.
- **«Otras respuestas»** ya no repite las del cierre.
- **El diccionario de la exportación** nombra las claves del cierre y de la entrevista final.
- **El artefacto del panel en claude.ai** se volvió a publicar con esta versión (versión 20, el mismo enlace, con su conexión a Supabase). Antes estaba en la versión del 7 de octubre, la de la app 2.30. La página publicada no lleva `conector-local.js`, que solo sirve para abrir el panel fuera de claude.ai.

## Verificación

- **Compilación desde cero:** 104 pruebas unitarias sin fallas. Las únicas advertencias son las de siempre, de la API experimental de Haze.
- **APK:** paquete `cl.udp.relevo`, versión 4.7.1 (`versionCode` 62), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **Panel:**
  - la consulta del cierre se probó contra la base real con un código inexistente: responde sin errores y no lee datos de nadie;
  - el script de la página no tiene errores de sintaxis;
  - en modo de ejemplo, la ficha muestra la sección «Cierre de la prueba» con sus partes, preguntas, respuestas y fechas.
- **Supabase:** se contaron las filas de cada tabla antes y después.

**Falta probar:** el panel publicado en claude.ai con la cuenta del autor (el navegador de esta sesión no tiene sesión en claude.ai) y el cierre respondido en un teléfono real con conexión.

## Registro de cambios (disclaimer)

### 2026-11-09 — Creación

- **Qué cambió:** se documentan la búsqueda del instrumento, el cierre que ya no salta preguntas, la protección de los datos y el panel al día.
- **Cómo estaba antes:** la 4.7 podía saltar preguntas ya respondidas y el panel publicado en claude.ai era el del 7 de octubre.
- **Por qué:** el autor pidió el instrumento más reciente en la app, en Supabase y en el panel, sin perder ningún dato.
