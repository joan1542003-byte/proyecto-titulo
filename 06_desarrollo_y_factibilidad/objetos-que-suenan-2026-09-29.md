# Objetos baratos que Relevo puede hacer sonar

**Fecha:** 29 de septiembre de 2026; actualizado el 5 de octubre. **Estado:** investigación de escritorio; ningún objeto se ha probado todavía. El llavero iTag ya está integrado en [Android 2.19](app-android/version-2.19-llavero-itag-2026-10-05.md), sin probar con un llavero real. **Decisiones relacionadas:** D-093 y D-109.

**Pregunta del autor:** ¿existe en Chile algo barato, ya fabricado, que Relevo pueda hacer sonar en el lugar donde empieza la actividad? ¿Serviría su reloj Huawei Watch Fit 5?

## Resumen

| Opción | Precio en Chile | ¿Relevo lo puede hacer sonar? | Qué falta |
| --- | --- | --- | --- |
| **Llavero antipérdida iTag** | CLP 6.990 ([Tienda8](https://www.tienda8.cl/inicio/llavero-localizador-anti-perdida-conexion-bluetooth-uso-profesional)); CLP 5.930 a 7.990 en MercadoLibre (sección 1) | Sí, con un servicio Bluetooth estándar. Verificado en código abierto (sección 1). Integrado en Android 2.19 (D-109). | Comprarlo y probarlo con los pasos de la 2.19. |
| **Reloj que contesta llamadas** (Watch Fit 5 del autor) | Ya lo tiene | Posible, enviando el tono como audio de llamada. Implementado en Android 2.15 sin probar (sección 2). | Probarlo con el reloj real. |
| **Reloj con Wear Engine** (kit de Huawei) | Ya lo tiene | Probablemente solo vibración. No se encontró que una app de terceros pueda usar el altavoz. | Cuenta de desarrollador y aprobación de Huawei (sección 3). |
| **Placa ESP32 con zumbador** | CLP 7.000 a 10.000 más un zumbador | Sí, con sonido y duración a gusto. | Armar y programar; es el camino del objeto propio (sección 4). |

## 1. Llavero antipérdida iTag

**Cómo suena.** El iTag clásico, el que se configura con las apps iSearching o Kindelf, implementa el servicio estándar de Bluetooth [«Alerta inmediata»](https://www.bluetooth.com/specifications/specs/immediate-alert-service-1-0/) (`0x1802`), con la característica «Nivel de alerta» (`0x2A06`). Escribir `0x01` o `0x02` lo hace pitar y escribir `0x00` lo detiene.

**Cómo se verificó.** No hizo falta descompilar la app oficial.
- La app Android de código abierto [iTag](https://github.com/s4ysolutions/itag), publicada en Google Play con licencia GPL-3.0, lo hace sonar exactamente así.
- En `itagble/src/main/java/s4y/itag/ble/BLEConnectionDefault.java`, su método `writeImmediateAlert` escribe en `00002a06-0000-1000-8000-00805f9b34fb` del servicio `00001802-0000-1000-8000-00805f9b34fb`.
- En `AlertVolume.java`, los valores son `NO_ALERT = 0x00`, `MEDIUM_ALERT = 0x01` y `HIGH_ALERT = 0x02`.
- Lo confirman otros análisis independientes: [Thejesh GN](https://thejeshgn.com/2017/06/20/reverse-engineering-itag-bluetooth-low-energy-button/), [ESPHome](https://t-shaped.nl/using-cheap-bluetooth-key-finder-fobs-with-esphome-and-home-assistant), [MicroPython](https://github.com/mcauser/micropython-aioble-itag) y [Hackster](https://www.hackster.io/esikora/alarm-device-controlled-by-bluetooth-or-wifi-part-1-b4887f).

**Cómo asegurarse antes de programar.** Con la app gratuita nRF Connect se conecta el iTag y, en *Immediate Alert* → *Alert Level*, se escribe `01`. Si pita, pitará desde Relevo, porque es la misma instrucción. Si algún modelo no respondiera, se puede activar el registro de Bluetooth de Android (opciones de desarrollador), usar una vez la app oficial y copiar la instrucción exacta que envía, sin descompilar nada.

**En MercadoLibre (5 de octubre).** Publicaciones que indican la app iSearching, según los resultados de búsqueda (las páginas piden iniciar sesión y no se abrieron): [llavero localizador antipérdida](https://articulo.mercadolibre.cl/MLC-1376482113-llavero-localizador-anti-perdida-conexion-bluetooth-itag-_JM), CLP 5.930; [localizador rastreador iTag con llavero](https://articulo.mercadolibre.cl/MLC-2478783150-localizador-rastreador-itag-bluetooth-con-llavero-android-_JM), CLP 7.990 con pila, y [mini llavero rastreador iTag](https://www.mercadolibre.cl/mini-llavero-rastreador-itag-localizador-gps-bluetooth-celular-color-negro/p/MLC32345367).

**Integración (Android 2.19).** Relevo apaga la alarma por desconexión de dos formas (`0xFFE2` y el servicio estándar de pérdida de enlace `0x1803`), mantiene la conexión mientras el relevo espera y usa el botón (`0xFFE1`) para callar la señal. [Detalle y pasos para probarlo](app-android/version-2.19-llavero-itag-2026-10-05.md).

**Límites.**
- El pitido es fijo y agudo, y no se puede elegir la melodía. La duración sí se controla: se enciende y se apaga cuando Relevo decide.
- El llavero pita cuando pierde la conexión con el teléfono. Relevo tendría que desactivar esa alarma; según [Shing Lyu](https://shinglyu.com/web/2023/06/03/disabling-the-link-lost-alarm-on-itag-ble-tracker.html), en algunos modelos se hace escribiendo `0` en la característica `0xFFE2`.
- Solo acepta una conexión a la vez, así que la app oficial no puede estar conectada al mismo tiempo.
- La calidad varía según el fabricante, y la pila CR2032 dura de 2 a 8 meses según el vendedor.

## 2. Reloj que contesta llamadas, como objeto

El Huawei Watch Fit 5 tiene [altavoz y micrófono](https://consumer.huawei.com/latin/wearables/watch-fit5/specs/) para contestar llamadas, también de WhatsApp. Por eso Android lo trata como un equipo de llamadas por Bluetooth, y una app puede enviarle audio de comunicación sin permisos de Huawei. Android 2.15 implementa esa salida («El reloj») y deja el reloj donde empieza la actividad. [Detalle y pasos de prueba](app-android/version-2.15-reloj-como-llamada-2026-09-29.md). **No se ha probado con el reloj.**

## 3. Reloj con el kit de Huawei (Wear Engine)

- **Costo y plazos:** la cuenta de desarrollador de Huawei es [gratuita](https://developer.huawei.com/consumer/en/doc/start/ibca-0000001062388135) y la verificación de identidad tarda 1 a 2 días hábiles. [Wear Engine](https://developer.huawei.com/consumer/en/hms/huawei-wearengine), que permite que una app del teléfono se comunique con el reloj, requiere postular con formularios sobre el uso de datos; la aprobación suele tardar [1 a 2 semanas](https://medium.com/huawei-developers/how-to-send-notifications-to-huawei-smartwatches-using-wear-engine-2025-90cd626f057e).
- **Cómo se prueba una app en el reloj:** se activa el modo desarrollador, tocando varias veces «Versión de software». Después se registra el reloj en AppGallery Connect con su UDID, se genera un certificado de depuración y se instala con DevEco Studio y DevEco Assistant ([guía](https://dev.to/harmonyos/running-debugging-harmonyos-apps-on-huawei-watches-a-complete-setup-guide-for-developers-4903)). Hay un [ejemplo oficial](https://github.com/Explore-In-HMOS-Wearable/wear-engine-lite-wearable-to-mobile) para la línea Fit 3 y 4.
- **Límite:** la línea Fit usa el sistema liviano de Huawei. La documentación revisada confirma vibración y notificaciones para apps de terceros, pero no el uso del altavoz. No alcanza para la prueba que empieza el 8 de octubre.

## 4. Placa ESP32 con zumbador

Hay placas ESP32 a CLP 9.990 en [MCI Electronics](https://mcielectronics.cl/shop/product/tarjeta-de-desarrollo-de-esp-32-esp32-29541/) y a CLP 7.191 en [Makers Chile](https://makerschile.cl/producto/esp32-esp32s-wifi-bluetooth-32-gpio-esp8266-esp-lolin/); ambas estaban agotadas el 29 de septiembre de 2026. Con un zumbador permiten elegir el sonido y la duración, pero hay que armarlas y programarlas. La memoria ya considera la micro:bit y la XIAO nRF52840 para ese camino.

## Registro de cambios (disclaimer)

### 2026-10-05 — Llavero integrado y en MercadoLibre

- **Qué cambió:** el estado y la fila del iTag dicen que está integrado en Android 2.19; la sección 1 suma tres publicaciones de MercadoLibre y cómo lo usa Relevo.
- **Cómo estaba antes:** el llavero figuraba como pendiente de compra, prueba e integración.
- **Por qué:** el autor decidió comprarlo y pidió que la app lo haga sonar (D-109).

### 2026-09-29 — Creación

- **Qué se añadió:** comparación de cuatro objetos que Relevo podría hacer sonar, con precios en Chile, verificación del iTag en código abierto y plazos de Huawei.
- **Cómo estaba antes:** el proyecto solo consideraba un parlante comercial y, a futuro, un objeto propio con micro:bit o XIAO.
- **Por qué:** el autor pidió buscar algo barato y ya fabricado que Relevo pudiera hacer sonar, y evaluar su reloj.
