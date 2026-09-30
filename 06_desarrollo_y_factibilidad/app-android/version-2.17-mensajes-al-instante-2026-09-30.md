# Android 2.17: mensajes al instante

**Fecha:** 30 de septiembre de 2026. **Decisión:** D-096. **Estado:** compilada desde cero y con 69 pruebas unitarias aprobadas. Probada en emulador con conexión, pero no en un teléfono real. El consentimiento sigue en v10.

## Qué cambia

En la 2.16, un mensaje del panel tardaba cerca de un minuto si Relevo estaba contando o esperando, y hasta 15 minutos en segundo plano. En la 2.17, mientras Relevo cuenta un relevo o espera con la activación automática encendida, el servicio mantiene abierta una conexión en vivo con Supabase (Realtime). Cuando el panel guarda un mensaje, la base avisa por esa conexión y la app lo muestra enseguida.

| Parte | Cambio |
| --- | --- |
| `MessageStream` | Conexión Realtime por WebSocket (OkHttp 4.12.0, licencia Apache 2.0). Escucha las inserciones en `relevo_messages` con el token de la sesión anónima, así que Realtime aplica las mismas reglas que la base: cada teléfono solo recibe avisos de los mensajes generales y los suyos. Envía un latido cada 25 segundos, se reconecta si cae y renueva el token antes de una hora. |
| `AppUsageMonitorService` | Abre la conexión al empezar a contar o a esperar, y la cierra al detenerse. |
| `ProjectMessages` | Con el aviso en vivo busca el mensaje de inmediato y usa un candado para no mostrar dos veces el mismo mensaje. La revisión cada 15 minutos y al abrir la app siguen como respaldo. |
| Supabase | Migración `relevo_messages_realtime`: la tabla de mensajes entra en la publicación de Realtime. También al final de `base-remota-supabase.sql`. |

## Lo que se comprobó en el emulador

Con la activación automática encendida y el servicio esperando, un mensaje dirigido al teléfono de prueba se guardó a las 04:06:46,019 (UTC) y llegó a la notificación a las 04:06:46,816: **0,8 segundos**. Después se borraron de Supabase las filas del usuario de prueba y se devolvieron al emulador sus datos anteriores. Un mensaje general «Hola», enviado desde el panel por el autor, se dejó intacto.

## Cuándo llega un mensaje

| Situación del teléfono | Cuándo llega |
| --- | --- |
| Relevo está contando un relevo | Al instante |
| Activación automática encendida | Al instante |
| Ninguna de las dos | Al abrir Relevo, o en hasta 15 minutos (más si Android ahorra batería) |

Para que llegue siempre al instante, incluso con la app cerrada, haría falta Firebase Cloud Messaging: un proyecto gratuito de Firebase que tendría que crear el autor, más una función en Supabase que envíe la notificación.

## Límites

- No se probó en un teléfono real. La conexión en vivo depende de que Android no detenga el servicio: conviene quitar la restricción de batería.
- La conexión abierta gasta algo de batería y datos: un latido pequeño cada 25 segundos mientras el servicio está activo.

**APK:** [relevo-android-2.17-2026-09-30.apk](releases/relevo-android-2.17-2026-09-30.apk), SHA-256 `CF143712A9F5077025E29499D92302068325FE772A0594A0C8FAB524484B887C` (41,1 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-09-30 — Creación

- **Qué se añadió:** la versión 2.17, con mensajes al instante por Realtime mientras Relevo cuenta o espera, y la prueba en emulador.
- **Cómo estaba antes:** en la 2.16, los mensajes tardaban cerca de un minuto con el servicio activo y hasta 15 minutos sin él.
- **Por qué:** el autor preguntó si la notificación podía llegar al instante.
