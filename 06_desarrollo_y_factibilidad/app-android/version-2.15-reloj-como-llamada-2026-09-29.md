# Android 2.15: el reloj como objeto que suena (experimental)

**Fecha:** 29 de septiembre de 2026. **Decisión:** D-093. **Estado:** compilada y con 62 pruebas unitarias aprobadas; **no se ha probado con un reloj real**.

## Qué cambia

La 2.15 agrega una tercera forma de avisar: **«El reloj»**. Sirve para usar un reloj que contesta llamadas, como el Huawei Watch Fit 5, **como objeto dejado donde empieza la actividad**, no en la muñeca. El reloj ya está fabricado, tiene altavoz y batería, y cabe junto al libro o las zapatillas.

Relevo no necesita permisos de Huawei. El reloj contesta llamadas, así que Android lo reconoce como un equipo de llamadas por Bluetooth. Al cumplirse el tiempo, Relevo abre ese canal (`setCommunicationDevice` y modo de comunicación) y envía el mismo tono de unos 30 segundos como si fuera audio de una llamada. Al terminar, devuelve el audio del teléfono a su estado normal.

| Parte | Cambio |
| --- | --- |
| `SignalRoute` | Nuevo valor `WATCH`. |
| `SignalPlayer` | Busca un equipo de llamadas conectado (`TYPE_BLUETOOTH_SCO` o `TYPE_BLE_HEADSET`), abre el canal de llamada, espera hasta unos 4 s a que se abra, reproduce el tono con uso `VOICE_COMMUNICATION` y cierra el canal al terminar o al detenerse. Si no hay reloj, vibra el teléfono y avisa que no sonó, como con el parlante. |
| «¿Cómo te avisa?» | Tercera opción, «El reloj», que indica si hay un reloj conectado para llamadas. Pide dejarlo donde empieza la actividad, con las llamadas por Bluetooth activadas. |
| Prueba de 21 días | En las semanas A y B, que piden el objeto, se puede elegir el parlante o el reloj; si la persona usa el reloj, se mantiene (`StudyCondition.routeFor`). La semana C sigue sonando en el teléfono. |
| Registros | `signal_route = 'watch'`. En Supabase, la restricción de `relevo_sessions` acepta `watch` (migración `relevo_signal_route_watch`, también al final de `base-remota-supabase.sql`). |
| Permisos | `MODIFY_AUDIO_SETTINGS`, un permiso normal que no muestra un diálogo. |
| Prueba unitaria | Nueva: el reloj se mantiene en las semanas A y B y la semana C usa el teléfono. |

## Cómo probarla con el reloj

1. Instalar el [APK 2.15](releases/relevo-android-2.15-2026-09-29.apk) en el teléfono Android.
2. Vincular el reloj con la app Huawei Salud y **activar las llamadas por Bluetooth** en el reloj. Comprobar que una llamada normal se oye en el reloj.
3. En Relevo, preparar un relevo y, en «¿Cómo te avisa?», elegir **El reloj**. Debe decir «Suena como una llamada»; si dice «Sin reloj conectado para llamadas», Android todavía no lo ve como equipo de llamadas.
4. Tocar **Probar el sonido**.
5. Si suena en el reloj, activar un relevo corto (15 segundos, con la opción «Probar con 15 segundos») y dejar el reloj en otra habitación para ver si se oye.

**Qué registrar:** si sonó, cuánto tardó en empezar, si se oye desde otra habitación, si el reloj muestra una pantalla de llamada y si el teléfono quedó con el audio normal al terminar.

## Lo que no se sabe

- **No se probó con un reloj real:** el emulador no tiene Bluetooth. Es posible que el Watch Fit 5 solo reproduzca audio durante una llamada real y que no suene; eso solo se sabe probándolo.
- **Calidad del sonido:** el canal de llamada tiene calidad de voz, no de música, así que el tono puede sonar distinto.
- **Llamadas reales:** mientras suena la señal, el teléfono queda en modo de comunicación. Si entra una llamada real en ese momento, el comportamiento no está probado.
- **Consumo de batería:** mantener el reloj conectado para llamadas puede gastar más batería.
- **Hipótesis y protocolo:** el reloj reemplazaría al parlante como objeto situado, así que la hipótesis no cambia. Usarlo en la prueba de 21 días es una decisión pendiente del autor; los textos de la prueba todavía hablan del parlante.

## Alternativas estudiadas

Ver [objetos baratos que Relevo puede hacer sonar](../objetos-que-suenan-2026-09-29.md): el llavero iTag, la placa ESP32 y el reloj con Wear Engine.

## Registro de cambios (disclaimer)

### 2026-09-29 — Creación

- **Qué se añadió:** la descripción de la salida experimental «El reloj», cómo probarla y sus límites.
- **Cómo estaba antes:** la app solo sonaba en un parlante multimedia o en el teléfono.
- **Por qué:** el autor pidió probar el reloj, cuya forma ya está fabricada, como objeto que suena con audio de llamada (D-093).
