# Android 2.27: el Tag suena en la señal, seguido

**Fecha:** 7 de octubre de 2026. **Decisión:** D-116. **Estado:** compilada desde cero, con 83 pruebas unitarias aprobadas. **No se ha probado con el Tag real:** el emulador no tiene Bluetooth. El consentimiento no cambia (v13).

## Qué pasó

Con la 2.26, «Probar el Tag» por fin pitó en el teléfono del autor, pero en un relevo real el Tag no sonó. Según el registro, la señal sí se emitió («signal_emitted») y la conexión estaba abierta. El autor pidió además que el pitido sea constante, no uno solo.

## Qué muestra el registro

La 2.26 registró cómo es este Tag por dentro: además de la alerta estándar (0x1802), su servicio propio FFE0 tiene siete características, de FFE1 a FFE7. FFE2 solo admite escritura con respuesta. Las tres situaciones observadas calzan con una sola explicación:

| Versión y momento | Qué se escribió en FFE2 justo antes | ¿Pitó? |
| --- | --- | --- |
| 2.25, prueba y señal | 0 | No |
| 2.26, prueba | 1, justo antes de la alerta | Sí |
| 2.26, señal | 1, pero unos 20 s antes, al activar el relevo | No |

**Interpretación probable:** en este modelo, escribir 1 en FFE2 es lo que lo hace pitar, y la alerta estándar sola no basta. No está confirmado: se deduce de tres observaciones.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Encender y callar | Para pitar, Relevo escribe 1 en FFE2 y 2 en la alerta estándar; para callar, 0 en ambas. Mientras el relevo espera, FFE2 queda en 0. Así funciona con este Tag y con los iTag clásicos, donde FFE2 es la alarma por desconexión. |
| Pitido continuo | La señal pita seguido durante 30 segundos, o hasta que se toca el Tag. La orden se repite cada segundo, porque algunos Tag pitan un rato y se detienen solos. Antes eran seis pitidos de 2 segundos. La prueba pita 3 segundos seguidos. |
| Confirmación | La escritura en FFE2 tiene respuesta del Tag. Si el Tag no responde al empezar la señal, Relevo cierra la conexión, la abre de nuevo y vuelve a intentar. Si la orden falla tres veces seguidas mientras suena, la señal cuenta como interrumpida. |
| Prueba | La pregunta «¿Lo escuchaste pitar?» se mantiene. Si no se escuchó, prueba el nivel medio; ya no prueba dejar FFE2 como viene, porque ahora FFE2 es parte del pitido. |

## Qué hacer en el teléfono

1. Instalar la 2.27 encima de la 2.26.
2. Revisar que iSearching no esté conectado al Tag.
3. «Probar el Tag»: debe pitar 3 segundos seguidos.
4. Activar un relevo con «Probar con 15 segundos», salir a una de las apps elegidas y esperar: el Tag debe pitar seguido hasta 30 segundos. Un toque en el Tag lo calla.

**APK:** [relevo-android-2.27-2026-10-07.apk](releases/relevo-android-2.27-2026-10-07.apk), SHA-256 `B5C3BA184592CF70C571D5482E01C6A0B6002BD205E6391A99F3925E95DC50AF` (41,4 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-10-07 — Creación

- **Qué se añadió:** la versión 2.27: el Tag pita en la señal, porque FFE2 se escribe en 1 junto con la alerta, y el pitido es continuo.
- **Cómo estaba antes:** la 2.26 escribía FFE2 solo al conectarse y la señal eran seis pitidos de 2 segundos; en un relevo real, el Tag no sonaba.
- **Por qué:** pedido del autor (D-116).
