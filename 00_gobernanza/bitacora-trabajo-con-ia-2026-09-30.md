# Bitácora del trabajo con IA: 30 de septiembre de 2026

**Estado:** registro de lo hecho con Claude Code el 30 de septiembre de 2026, a pedido del autor. Continúa la [bitácora del 29 de septiembre](bitacora-trabajo-con-ia-2026-09-29.md). Cada pedido está en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| Presentación | La diapositiva 14 es una carta Gantt de lo que sigue hasta el examen, con etapas concretas, un detalle por tarea en tercera persona, la compra de materiales de esta semana y sin la revisión del consentimiento ([documento 24](../10_recursos_visuales/24_presentacion-correccion-cruzada-2026-09-30.md)). | — |
| Activación automática | [Android 2.16](../06_desarrollo_y_factibilidad/app-android/version-2.16-activacion-automatica-y-mensajes-2026-09-30.md): Relevo repite solo el último relevo al abrir una de sus apps, también durante el testeo, con 30 minutos de pausa entre relevos. | D-095 |
| Mensajes y panel | Mensajes del investigador que llegan como notificación, con registro de llegada y apertura; tablas nuevas en Supabase con RLS; [panel privado](../06_desarrollo_y_factibilidad/panel-admin/README.md) en claude.ai, rediseñado con el diseño de la app y ordenado en cuatro pestañas. | D-096 |
| Mensajes al instante | [Android 2.17](../06_desarrollo_y_factibilidad/app-android/version-2.17-mensajes-al-instante-2026-09-30.md): conexión Realtime mientras Relevo cuenta o espera; en emulador, el mensaje llegó en 0,8 segundos. | D-096 |
| Registro completo | [Android 2.18](../06_desarrollo_y_factibilidad/app-android/version-2.18-registro-completo-y-avisos-2026-09-30.md): uso diario de las apps elegidas y tiempo total de pantalla desde 7 días antes de aceptar, estado del teléfono, «Eliminar este relevo» en el relevo activo y avisos de qué falta al tocar «Seguir». | D-097 |
| Panel v3 | 12 mensajes listos para coordinar, «Para revisar» (permisos, batería, datos que no llegan, versión), uso diario con gráfico y tabla, configuración, perfil y ruta de cada persona, y descarga de sus datos en JSON. | D-097 |
| Consentimiento | Versión v10: explica la activación automática y los mensajes. Versión v11: suma el uso diario, el tiempo total de pantalla, el equipo, los permisos y los relevos eliminados ([documento](../07_validacion/consentimiento-android-vigente-2026-09-23.md)). | D-095 a D-097 |

## 2. Cómo se usó la IA

- **El autor decidió y la IA propuso y ejecutó.** Antes de construir, la IA preguntó tres decisiones: cómo activarse solo, cómo enviar notificaciones y dónde publicar el panel. El autor eligió permitir la activación automática en el testeo, usar el Supabase del proyecto y una página privada.
- **Límites que la IA hizo explícitos:** la activación automática cambia la elección deliberada de la actividad y se registra aparte; los mensajes no son instantáneos y, durante el testeo, son una intervención; el consentimiento tuvo que cambiar.
- **Datos:** la prueba en emulador usó un usuario y un código de prueba. Después se borraron solo esas filas de Supabase y se devolvieron al emulador los datos que tenía antes.

## 3. Qué se comprobó y qué no

- **Comprobado:** compilación limpia y 69 pruebas unitarias en la 2.16 y en la 2.17; en la 2.17, un mensaje llegó 0,8 segundos después de guardarse. Además, el autor envió desde el panel un mensaje general («Hola»), lo que confirma que el panel funciona desde su cuenta. En emulador, con conexión: activación al abrir la app elegida, señal, regreso a la espera, pausa de 30 minutos, apagado, llegada y apertura de un mensaje, y filas correctas en Supabase. También se comprobó que la consulta del panel funciona contra la base y el revisor de seguridad de Supabase no marcó problemas nuevos.
- **Comprobado en la 2.18:** compilación limpia y 75 pruebas unitarias. En emulador: llegaron el estado del teléfono y el uso diario del 23 al 30 de septiembre; el aviso «Escribe qué quieres hacer o toca una idea.» apareció al tocar «Seguir» sin actividad; un relevo activo eliminado quedó como `deleted`; y «Borrar mis datos» dejó en cero el estado, el uso diario y los eventos del usuario de prueba en Supabase. Las consultas nuevas del panel funcionaron contra la base, y su diseño se revisó en local con datos de ejemplo.
- **No comprobado:** el teléfono real y el parlante; el diseño nuevo del panel visto desde la cuenta del autor; la descarga de datos y los mensajes listos dentro de claude.ai; el aviso que crece al tocar de nuevo y el corte del tiempo con la pantalla bloqueada; la revisión del consentimiento v10 y v11.

## 4. Pendientes

- Decidir si se agrega Firebase Cloud Messaging para que los mensajes lleguen al instante también con la app cerrada; requiere que el autor cree un proyecto gratuito de Firebase.
- Instalar la 2.18 en el teléfono de la prueba y comprobar que la activación automática sigue funcionando con el ahorro de batería del fabricante, y que el uso diario coincide con Bienestar digital.
- Abrir el panel, permitir el conector de Supabase y enviar un mensaje de prueba a ese teléfono.
- Revisar el consentimiento v11 con el profesor guía: ahora incluye el tiempo total de pantalla por día.
- Decidir si el capítulo 11 de la memoria describe la 2.16 como la app del testeo.

## Registro de cambios (disclaimer)

### 2026-09-30 — Android 2.18 y panel v3

- **Qué cambió:** se sumaron la 2.18 (registro completo, eliminar un relevo activo y avisos de campos faltantes), el panel v3 con mensajes listos, el consentimiento v11, sus comprobaciones y pendientes.
- **Cómo estaba antes:** la bitácora terminaba en la 2.17 y el panel rediseñado.
- **Por qué:** pedido del autor (D-097).

### 2026-09-30 — Panel rediseñado y 2.17

- **Qué cambió:** se sumaron el rediseño del panel, la 2.17 con mensajes al instante, la prueba de 0,8 segundos y el pendiente de Firebase.
- **Cómo estaba antes:** la bitácora terminaba en la 2.16 y la primera versión del panel.
- **Por qué:** el autor pidió ordenar y diseñar el panel como la app, y preguntó si la notificación podía llegar al instante.

### 2026-09-30 — Creación

- **Qué se añadió:** resumen del trabajo del 30 de septiembre: presentación, Android 2.16, mensajes, panel y consentimiento v10, con comprobaciones y pendientes.
- **Cómo estaba antes:** la última bitácora era la del 29 de septiembre.
- **Por qué:** mantener el estado del proyecto al día para el autor y para la próxima sesión.
