# Bluetooth BLE o Wi-Fi/Supabase para activar el objeto de Relevo

**Fecha:** 23 de septiembre de 2026. **Estado:** estudio de arquitectura; no se implementó ni probó un objeto Wi-Fi. Esta nota compara la señal sonora que recibe un objeto programable y se reproduce en su propio altavoz, sin convertirlo en salida multimedia de YouTube/Instagram.

## Punto de partida real

La [app Android 2.3](app-android/README.md) detecta localmente que la aplicación elegida permanece en primer plano durante el tiempo configurado. Guarda primero sesiones y eventos en SQLite y los sincroniza con Supabase cuando está configurada. Su sonido actual se dirige a un parlante Bluetooth multimedia; **todavía no envía órdenes BLE ni Wi-Fi a un objeto programable**. El [programa de banco micro:bit](prueba-microbit-ble/README.md) sí está compilado para recibir `activar` por BLE, pero no ensayado en hardware ni conectado a la app. La [micro:bit V2](https://tech.microbit.org/hardware/) tiene BLE y altavoz, **no Wi-Fi**: comprar el GO no permite conectarla directamente al Wi-Fi doméstico ni a Supabase.

## Dos recorridos posibles

### A. Android → BLE → objeto cercano

```text
Android detecta la condición → envía «activar» por BLE → objeto reproduce el tono
```

La señal no necesita Internet, router ni Supabase. La persona puede mover el objeto entre habitaciones o llevarlo a otro lugar sin introducir una contraseña de Wi-Fi. El alcance y las reconexiones con Android son los límites principales. La [guía Android de BLE en segundo plano](https://developer.android.com/develop/connectivity/bluetooth/ble/background) explica que el proceso puede ser terminado y que existen mecanismos de presencia y reconexión; no promete una conexión ininterrumpida. Relevo tendría que integrar el envío y la recuperación del enlace. Esta ruta responde bien a una intención situada cerca del teléfono y a la prueba técnica con micro:bit.

### B. Android → Supabase → Wi-Fi → objeto de la casa

```text
Android detecta la condición → crea una orden para ese objeto en Supabase
Supabase Realtime avisa a un objeto conectado por Wi-Fi → objeto reproduce el tono
```

**Sí es posible técnicamente**, usando un dispositivo con Wi-Fi y altavoz programables; por ejemplo, [M5Stack StickS3](https://docs.m5stack.com/en/core/StickS3) o [Atom Echo](https://docs.m5stack.com/en/atom/atomecho), sujetos a firmware propio. Una alternativa más simple de firmware es que el objeto consulte periódicamente por HTTPS si tiene una orden pendiente; eso añade demora y solicitudes repetidas. Con [Supabase Realtime Broadcast desde cambios de base de datos](https://supabase.com/docs/guides/realtime/subscribing-to-database-changes), puede recibir una señal por WebSocket mientras esté conectado. Supabase recomienda Broadcast para escalabilidad y seguridad frente a Postgres Changes.

Supabase **no conoce por sí solo** qué app está abierta en Android. En el funcionamiento actual de Relevo, el teléfono debe detectar la condición y crear la orden. Se podría definir una condición puramente horaria en servidor en otro diseño, pero no reemplaza la detección local de uso. La base tampoco puede iniciar una conexión entrante hacia un objeto cualquiera detrás del router doméstico: el objeto debe abrir su propia conexión saliente a Supabase y mantenerse suscrito o consultar. Esto es una inferencia de la arquitectura cliente-servidor descrita en el [protocolo Realtime](https://supabase.com/docs/guides/realtime/protocol) y en el mecanismo de [Broadcast](https://supabase.com/docs/guides/realtime/broadcast), no una función ya construida en Relevo.

Existe una tercera posibilidad: **Android → Wi-Fi local → objeto**, ambos en la misma red doméstica y sin Supabase para la orden. Evita depender de Internet para sonar, pero exige que el objeto tenga Wi-Fi, que ambos equipos compartan una red que permita comunicarse y un proceso de configuración inicial. Tampoco puede usarla la micro:bit GO por sí sola.

| Criterio | BLE desde Android | Wi-Fi con Supabase |
| --- | --- | --- |
| Internet para sonar | No | Sí; Wi-Fi local sin Internet no alcanza a Supabase |
| Teléfono cerca del objeto | Sí, dentro del alcance medido | No para entregar la orden al objeto; **sí debe tener Internet cuando detecta y envía la condición** |
| Instalación inicial | Emparejar/asociar objeto con el teléfono | Dar acceso a una red Wi-Fi, asociar objeto con la cuenta y mantener credenciales |
| Cambio de lugar | Relativamente sencillo | Reconfigurar si cambia la red |
| Autonomía portátil | Más favorable como hipótesis para un objeto de señales breves; medir el montaje | Mantener Wi-Fi/WebSocket puede aumentar la carga de energía; medir el montaje, no inferir horas desde el chip |
| Fallos que se deben ensayar | Distancia, paredes, Bluetooth apagado, cierre del proceso Android, reconexión | Internet y router caídos, proyecto remoto no disponible, token caducado, reconexión, órdenes duplicadas o atrasadas |
| Estado actual de Relevo | Firmware de banco micro:bit compilado; integración Android pendiente | No existe ruta de órdenes a objeto; la sincronización existente es de sesiones/eventos |

## Fiabilidad y privacidad de la ruta remota

Un Broadcast en vivo se entrega a clientes conectados. Supabase ofrece [Broadcast Replay](https://supabase.com/docs/guides/realtime/broadcast) para mensajes enviados **desde la base de datos** en canales privados, con ventana limitada de retención; eso no convierte cualquier emisión en una orden garantizada. Para Relevo, una eventual implementación robusta debería conservar una orden propia con identificador, destinatario, hora de expiración y confirmación, y comprobar pendientes tras reconectar. Una orden vencida **no debe hacer sonar** el objeto minutos u horas después, porque perdería el sentido de la señal situada. La documentación oficial señala además que [un broadcast de base puede perderse si no había ningún cliente WebSocket conectado](https://supabase.com/docs/guides/troubleshooting/realtime-warn-sending-broadcast-message).

Un objeto Wi-Fi conectado a Supabase necesita identidad y autorización por dispositivo. Usar canales privados y políticas [Realtime Authorization/RLS](https://supabase.com/docs/guides/realtime/authorization) que limiten lo que cada objeto puede recibir. La clave publicable puede estar en un cliente; **no colocar una clave secreta ni la antigua `service_role` en el hardware**, que puede extraviarse o inspeccionarse. No enviar al objeto historial de navegación ni textos personales si basta una orden efímera `activar` con identificador y caducidad. Esto añade trabajo de aprovisionamiento, revocación y recuperación si se cambia el router o se pierde el objeto.

## Juicio para el test de Relevo

**BLE sigue siendo la mejor ruta inicial si el objeto estará cerca del teléfono y se busca una prueba portable, económica y capaz de funcionar sin Internet.** En ese escenario, micro:bit GO es banco técnico, no producto listo para participantes. **Wi-Fi/Supabase merece un prototipo separado** si el requisito real es dejar el objeto fijo en una casa, mantenerlo alimentado y activarlo aunque el teléfono esté fuera del alcance BLE. Allí StickS3 o Atom Echo son candidatos de hardware; ninguno funciona con la app actual al sacarlo de la caja. Wi-Fi no elimina la detección Android ni los fallos de red; traslada el tramo teléfono–objeto a un servicio remoto. La elección final requiere medir latencia, entrega, reconexión, consumo y experiencia de configuración en el contexto de uso.

## Registro de cambios (disclaimer)

### 2026-09-23 — Comparación inicial

- **Cambio:** se compararon BLE local y Wi-Fi/Supabase, el recorrido de órdenes, compatibilidad de micro:bit, requisitos de seguridad y modos de fallo.
- **Antes:** la exploración de compra describía dispositivos Wi-Fi, pero no evaluaba que Supabase dirigiera la activación del objeto.
- **Motivo:** responder si un dispositivo conectado al Wi-Fi de casa puede sonar cuando Relevo/Supabase lo indiquen y si supera a Bluetooth para el test.
- **Alcance y límites:** investigación documental de guías oficiales y estado del repositorio; sin cambios en app, base de datos o firmware, y sin mediciones físicas.
