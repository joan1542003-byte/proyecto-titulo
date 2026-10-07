# Android 2.26: el Tag pita y la prueba pregunta si se escuchó

**Fecha:** 7 de octubre de 2026. **Decisión:** D-115. **Estado:** compilada desde cero, con 85 pruebas unitarias aprobadas. **No se ha probado con el Tag real:** el emulador no tiene Bluetooth, así que la conexión, el pitido y la pregunta nueva quedan por probar en el teléfono del autor. El consentimiento no cambia (v13).

## Qué pasó

Con la 2.25, en el teléfono del autor, Relevo encontraba el Tag y se conectaba, pero el Tag no pitaba; el teléfono vibraba, como en cada señal. El registro de esa prueba muestra que todo funcionaba por Bluetooth: la conexión, el aviso del botón, el interruptor de la alarma de desconexión y la orden de pitar. La orden se aceptaba, pero el Tag no sonaba. Con iSearching en el iPhone, el mismo Tag sí pita.

## Causa probable

Al conectarse, Relevo escribía 0 en la característica FFE2 del Tag para apagar su alarma de desconexión. Así lo documentó Shing Lyu (2023) con un iTag que la nombra «Set LinkLost Alert». Pero los iTag no son todos iguales: en algunos, un interruptor de ese tipo en 0 hace que el Tag reciba la orden y solo encienda su luz, sin pitar, y lo recuerda hasta que se apaga (Niedermayer, s. f.). Es la explicación que mejor calza con lo observado; no está confirmada, porque no se conoce el interior de este modelo (NEWOTAG-BL).

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Interruptor FFE2 | Relevo lo apaga solo si el propio Tag lo nombra como alarma de desconexión. Si no, escribe 1, que además deshace el 0 que dejaron las versiones 2.19 a 2.25. La alarma estándar de desconexión (0x1803) se sigue apagando. |
| Prueba con pregunta | «Probar el Tag» ya no da por hecho que sonó: pregunta «¿Lo escuchaste pitar?», con «Sí, pitó» y «No pitó» del mismo peso. |
| Otras formas | Si no pitó, prueba sola la forma siguiente: nivel alto (2), nivel medio (1) y, si el interruptor FFE2 se había apagado, dejarlo encendido. Guarda la forma que la persona confirmó y la usa en cada señal. Si ninguna funciona, explica cómo apagar y encender el Tag y sugiere elegir otra salida. |
| Registro | `prueba_de_sonido` dice si la orden salió, el intento, el nivel y el estado de FFE2; `llavero_escuchado` guarda la respuesta; `llavero_perfil` guarda, una vez por prueba, los servicios y características del Tag con sus propiedades, y el nombre y valor de FFE2. No incluye su dirección ni su nombre. Con eso se puede saber cómo es este modelo por dentro sin tenerlo a mano. |
| Textos | Si el Tag mantiene su alarma de alejamiento, la app avisa que puede pitar solo si el teléfono se aleja mucho mientras espera. La guía nombra su último paso «Si no aparece o no pita». |

## Qué hacer en el teléfono

1. Instalar la 2.26 encima de la 2.25 (los datos se mantienen).
2. Apagar y encender el Tag una vez: mantener su botón 3 segundos hasta el pitido largo, y otra vez hasta que pite dos veces. Así olvida el ajuste que dejó la versión anterior.
3. Revisar que iSearching no esté conectado al Tag: cerrarlo en el iPhone o apagar el Bluetooth del iPhone.
4. En Relevo, «Probar el Tag» y responder si se escuchó.

**El teléfono vibra en cada señal**, con cualquier salida: es una vibración corta al empezar, que ya existía. No significa que la señal se haya ido al teléfono.

**APK:** [relevo-android-2.26-2026-10-07.apk](releases/relevo-android-2.26-2026-10-07.apk), SHA-256 `AF4AAAC7CA7442F66FBEDF2EAA86459411AD8E96D57C72112320C27B94A21552` (41,4 MB), compilación limpia de depuración.

## Referencias

Lyu, S. (2023, 3 de junio). *Disabling the link lost alarm on iTag BLE tracker*. https://shinglyu.com/web/2023/06/03/disabling-the-link-lost-alarm-on-itag-ble-tracker.html

Niedermayer, M. (s. f.). *Lair of the multimedia guru* [Entrada sobre el iTag]. https://guru.multimedia.cx/?p=405

S4Y Solutions. (s. f.). *iTag* [Código fuente]. GitHub. https://github.com/s4ysolutions/itag

## Registro de cambios (disclaimer)

### 2026-10-07 — Creación

- **Qué se añadió:** la versión 2.26: Relevo ya no apaga a ciegas el interruptor FFE2 del Tag, y la prueba pregunta si se escuchó y prueba otras formas de hacerlo pitar.
- **Cómo estaba antes:** la 2.25 escribía 0 en FFE2 al conectarse y daba la prueba por buena si el Tag aceptaba la orden.
- **Por qué:** en el teléfono del autor, el Tag se conectaba pero no pitaba (D-115).
