# Panel del testeo de Relevo

**Enlace:** [Panel de Relevo](https://claude.ai/artifact/QMsAiSqpkuivix6FJzh9uM), una página privada en claude.ai. Solo la ven su dueño y las personas a quienes se invite desde el menú Compartir. **Decisión:** D-096. **Fecha:** 30 de septiembre de 2026.

## Qué muestra

- **Resumen:** participantes, cuántos tuvieron actividad en los últimos 15 minutos, cuántos están contando, cuántos esperan responder, relevos de hoy, respuestas por señales y relevos automáticos.
- **Participantes:** código, nombre, estado (contando, espera responder, se activará solo, sin relevo), condición y día de la prueba, relevos respondidos, activación automática, versión de la app y última actividad.
- **Respuestas a la señal:** los 30 relevos más recientes, con cómo empezó (a mano o solo), condición y salida, si supo qué quería hacer, si recordó cómo empezar, qué decidió, cómo le cayó el aviso y en cuánto respondió.
- **Otras respuestas:** tarjetas semanales, cierre del día 21, opiniones y reportes.
- **Por condición:** para A, B y C, cuántas veces supo qué quería hacer, a medias o no.
- **Relevos por día** en los últimos 21 días, **actividad** reciente y **mensajes enviados**, con cuántos llegaron y cuántos se abrieron.

## Enviar una notificación

Se elige «Todos los participantes» o un código, se escribe un título (hasta 60 caracteres) y el mensaje (hasta 400), y se confirma. El mensaje llega como notificación de Relevo en cerca de un minuto si la app está contando o esperando, y en hasta 15 minutos en segundo plano. Durante el testeo se usa para coordinar, no para recordar la actividad (protocolo 02). No hay que escribir datos personales.

## Cómo funciona

La página no guarda datos ni claves. Cada 30 segundos consulta Supabase con el conector de Supabase de claude.ai de quien la abre (`execute_sql`), y al enviar un mensaje inserta una fila en `relevo_messages`. Quien no tenga ese conector con acceso al proyecto no ve datos. Los datos llegan al panel cuando los teléfonos los envían: al activar un relevo, cuando suena, al cerrar la app y cada 15 minutos mientras cuentan.

Este archivo, [panel-relevo.html](panel-relevo.html), es una copia del código publicado, para trazabilidad. Para cambiar el panel hay que volver a publicarlo en la misma dirección.

## Límites

- Muestra nombres, porque es solo para el investigador; no se debe compartir con otras personas.
- No es tiempo real exacto: depende de cuándo cada teléfono envía sus datos.
- El estado de cada participante se deduce de lo último que llegó; un teléfono sin conexión puede verse desactualizado.

## Registro de cambios (disclaimer)

### 2026-09-30 — Creación

- **Qué se añadió:** el panel privado del testeo y su documentación.
- **Cómo estaba antes:** los datos solo se veían en Supabase, con las vistas del esquema `analisis`.
- **Por qué:** el autor pidió un panel con respuestas, usuarios activos y estadísticas en tiempo real, y poder enviar notificaciones (D-096).
