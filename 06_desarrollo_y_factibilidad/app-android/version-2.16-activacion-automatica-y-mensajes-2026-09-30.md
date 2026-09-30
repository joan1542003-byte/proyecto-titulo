# Android 2.16: activación automática y mensajes del proyecto

**Fecha:** 30 de septiembre de 2026. **Decisiones:** D-095 y D-096. **Estado:** compilada desde cero y con 69 pruebas unitarias aprobadas. Probada en emulador con conexión, pero **no en un teléfono real ni con personas**. El consentimiento pasa a v10, así que hay que aceptarlo de nuevo.

## Qué cambia

**Activación automática (D-095).** En Perfil, en Avisos y resúmenes, la persona puede encender «Activación automática». Con ella, Relevo repite solo el último relevo cada vez que se abre una de sus apps: misma actividad, primer paso, lugar, apps y tiempo. Durante el testeo usa la condición de la semana, igual que uno activado a mano. Después de cada relevo espera 30 minutos antes de activarse otra vez. Empieza apagada, Inicio lo muestra con el aviso «Se activa solo» y se apaga con un toque.

**Mensajes del proyecto (D-096).** El investigador escribe un mensaje en el [panel privado](../panel-admin/README.md) y Relevo lo muestra como notificación. En la pantalla de bloqueo solo dice «Tienes un mensaje nuevo». La base registra cuándo llegó y cuándo se abrió cada uno.

| Parte | Cambio |
| --- | --- |
| `AutoMode` y `AutoModeStore` | Reglas de la activación automática sin Android, para probarlas: hay un último relevo completo, la app abierta es una de las suyas, no hay otro en curso ni esperando respuesta y pasaron 30 minutos. El relevo automático queda marcado con `autoActivated`. |
| `AppUsageMonitorService` | Nuevo modo de espera: con la activación encendida, el servicio mira cada 3 segundos qué app está en primer plano (solo su nombre). Al abrirse una app elegida activa el relevo y pasa a contar. Al terminar, vuelve a esperar en vez de detenerse. La notificación fija dice «Relevo se activará solo» o «Relevo está contando…». |
| `RestoreMonitorReceiver` | Después de reiniciar el teléfono o actualizar la app, retoma la espera y la revisión de mensajes. |
| `ProjectMessages` y `MessageCheckJob` | Busca mensajes al abrir la app, cada minuto mientras Relevo cuenta o espera y cada 15 minutos en segundo plano con `JobScheduler`. Muestra cada mensaje una sola vez y registra su llegada y su apertura. |
| `RemoteSync` | Lee los mensajes generales y propios (la base no entrega otros) y envía la llegada y la apertura. El borrado de datos incluye esas filas. |
| Registros | `activation` (`manual` o `auto`) en cada relevo, local (base versión 8) y en Supabase. Eventos de uso nuevos: `activacion_automatica`, `relevo_automatico`, `mensaje_recibido`, `mensaje_abierto` y `mensaje_sin_notificaciones`. |
| Consentimiento | v10 (`2026-09-30-v10`): explica la activación automática, los mensajes y lo que se registra de ambos. |
| Supabase | Migración `relevo_auto_activation_and_messages`: columna `activation` y tablas `relevo_messages` y `relevo_message_receipts` con RLS (cada teléfono lee sus mensajes y los generales, y escribe solo sus recibos). También al final de `base-remota-supabase.sql`. |
| Pruebas unitarias | `AutoModeTest`, con siete pruebas: pausa, apps que no cuentan, relevo en curso, último relevo incompleto, condición del día y salida fuera del testeo. |

## Lo que se comprobó en el emulador

Con datos de prueba (código `EMU-TEST`) y conexión a Supabase:

1. Con la activación encendida y sin relevo activo, el servicio queda esperando e Inicio muestra «Se activa solo».
2. Al abrir Chrome, una de las apps del último relevo, se activó un relevo en unos 3 segundos, marcado como automático. A los 45 segundos sonó en el teléfono y apareció la notificación con la actividad y el primer paso.
3. En Supabase quedaron el relevo con `activation = 'auto'`, sus eventos y el uso `relevo_automatico`.
4. Un mensaje dirigido a ese teléfono llegó como notificación en poco más de un minuto. Al abrir la app desde el mensaje, la base registró la llegada y la apertura.
5. Después de responder, el servicio volvió a esperar y, al abrir Chrome otra vez dentro de los 30 minutos, no se activó otro relevo.
6. Al apagar la activación, el servicio se detuvo y la notificación fija desapareció.

Después se borraron de Supabase las filas del usuario de prueba y se devolvieron al emulador los datos que tenía antes.

## Cómo usarla en el teléfono

1. Instalar el [APK 2.16](releases/relevo-android-2.16-2026-09-30.apk) sobre la versión anterior y aceptar el consentimiento v10.
2. Hacer un relevo completo a mano: la activación automática repite ese.
3. En Perfil, en Avisos y resúmenes, elegir **Sí** en «Activación automática».
4. Abrir una de las apps de ese relevo. En Inicio debe aparecer el relevo contando, con «Cómo empezó · Se activó solo».
5. Para los mensajes, abrir el [panel](https://claude.ai/artifact/QMsAiSqpkuivix6FJzh9uM), elegir el código del teléfono y enviar uno de prueba.

## Límites

- No se probó en un teléfono real: algunos fabricantes detienen servicios en segundo plano aunque haya notificación fija. Por eso conviene quitar la restricción de batería.
- Los mensajes no son instantáneos: tardan cerca de un minuto si Relevo cuenta o espera, y hasta 15 minutos en segundo plano, o más si Android ahorra batería.
- La pausa de 30 minutos es una propuesta; no hay un tope diario de relevos automáticos.
- El consentimiento v10 no está revisado por el profesor guía.

**APK:** [relevo-android-2.16-2026-09-30.apk](releases/relevo-android-2.16-2026-09-30.apk), SHA-256 `BA6B6291359965A4B148FB4527A803CA602446EF8D4053A557DF9F484044B5B7` (39,9 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-09-30 — Creación

- **Qué se añadió:** la versión 2.16, con activación automática, mensajes del proyecto, consentimiento v10, migración de Supabase, pruebas y resultados del emulador.
- **Cómo estaba antes:** la 2.15 solo se activaba a mano y no recibía mensajes.
- **Por qué:** el autor pidió que Relevo se active solo al usar las apps, también en el testeo (D-095), y enviar notificaciones desde un panel (D-096).
