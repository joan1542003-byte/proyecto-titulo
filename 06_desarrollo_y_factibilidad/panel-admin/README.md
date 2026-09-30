# Panel del testeo de Relevo

**Enlace:** [Panel de Relevo](https://claude.ai/artifact/QMsAiSqpkuivix6FJzh9uM), una página privada en claude.ai. Solo la ven su dueño y las personas a quienes se invite desde el menú Compartir. **Decisión:** D-096. **Fecha:** 30 de septiembre de 2026.

## Diseño

Desde la segunda versión, el panel usa el diseño de la app: el papel de fondo, las tarjetas de esquinas amplias (28 px), la fuente Schibsted Grotesk, las cápsulas, el azul solo para lo que escribe la persona y el vidrio solo en la barra de navegación. No hay textos en mayúsculas. Tiene modo claro y oscuro con los colores de la app. En el teléfono, las pestañas bajan a una barra en cápsula, como en la app.

## Qué muestra

El panel se ordena en cuatro pestañas:

1. **Ahora.** Cifras del testeo (contando ahora, esperan responder, relevos de hoy, respuestas de las señales, relevos que se activaron solos y participantes con actividad reciente), quién está contando o esperando responder, y lo último que llegó.
2. **Participantes.** Cada persona con su estado, su condición y cuántos relevos respondió. Al tocarla se abre una hoja con sus datos, sus relevos, sus respuestas y un botón para escribirle.
3. **Respuestas.** Por condición, si supo qué quería hacer al sonar. También los relevos por día, las respuestas a cada señal y las tarjetas semanales, el cierre y las opiniones. Lo que escribió la persona va en azul.
4. **Mensajes.** Formulario para escribir y lista de enviados, con a cuántos les llegó y cuántos lo abrieron.

## Enviar una notificación

Se elige «Todos» o una persona, se escribe un título (hasta 60 caracteres) y el mensaje (hasta 400), y se revisa en una hoja con la vista previa de la notificación antes de enviarla. Con la app 2.17 o posterior, el mensaje llega al instante si Relevo está contando o tiene la activación automática encendida. Si no, llega al abrir la app o en hasta 15 minutos. El panel muestra qué caso corresponde a cada persona. Durante el testeo se usa para coordinar, no para recordar la actividad (protocolo 02). No hay que escribir datos personales.

## Cómo funciona

La página no guarda datos ni claves. Cada 30 segundos consulta Supabase con el conector de Supabase de claude.ai de quien la abre (`execute_sql`). Al abrir a una persona hace otra consulta con sus relevos y respuestas. Al enviar un mensaje, inserta una fila en `relevo_messages`. Quien no tenga ese conector con acceso al proyecto no ve datos. Los datos llegan al panel cuando los teléfonos los envían: al activar un relevo, cuando suena, al cerrar la app y cada 15 minutos mientras cuentan.

Este archivo, [panel-relevo.html](panel-relevo.html), es una copia del código publicado, para trazabilidad. Para cambiar el panel hay que volver a publicarlo en la misma dirección.

## Límites

- Muestra nombres, porque es solo para el investigador; no se debe compartir con otras personas.
- No es tiempo real exacto: depende de cuándo cada teléfono envía sus datos.
- El estado de cada participante se deduce de lo último que llegó; un teléfono sin conexión puede verse desactualizado.

## Registro de cambios (disclaimer)

### 2026-09-30 — Diseño de la app y pestañas

- **Qué cambió:** el panel usa el diseño de la app y se ordena en cuatro pestañas (Ahora, Participantes, Respuestas y Mensajes). Suma una hoja por persona, una vista previa antes de enviar y el tiempo de llegada de cada mensaje.
- **Cómo estaba antes:** todo estaba en una sola página con tablas, colores propios y encabezados en mayúsculas.
- **Por qué:** el autor pidió ordenar mejor el panel y diseñarlo como la app.

### 2026-09-30 — Creación

- **Qué se añadió:** el panel privado del testeo y su documentación.
- **Cómo estaba antes:** los datos solo se veían en Supabase, con las vistas del esquema `analisis`.
- **Por qué:** el autor pidió un panel con respuestas, usuarios activos y estadísticas en tiempo real, y poder enviar notificaciones (D-096).
