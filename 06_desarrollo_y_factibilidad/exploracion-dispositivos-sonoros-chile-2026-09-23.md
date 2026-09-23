# Dispositivos compactos para que Relevo active un sonido

**Consulta:** 23 de septiembre de 2026. **Alcance:** investigación de productos comprables desde Chile y de la ruta técnica para activar un sonido. No se compró ni ensayó hardware; no se modificó la app. Precio, stock y despacho son observaciones de las fichas consultadas, sujetos al carrito y comuna de entrega.

## Requisito y distinción clave

El objeto debe estar callado hasta recibir una señal de Relevo. El uso de YouTube, Instagram u otras apps no debe activar el objeto. Hay dos rutas técnicamente diferentes:

1. **Objeto programable que recibe un comando BLE o Wi-Fi y toca localmente un tono.** No se registra como salida multimedia general del teléfono. Requiere firmware del objeto y una futura integración de Relevo con el protocolo elegido; no basta emparejarlo con el APK actual.
2. **Parlante Bluetooth A2DP convencional.** El APK actual puede intentar enviarle su propia pista, pero otras apps también pueden usarlo. Solo cumple la separación exigida si el teléfono y su configuración la hacen efectiva, por ejemplo en un Galaxy con *Separate app sound* comprobado; la [investigación de compatibilidad](enrutamiento-audio-parlante-exclusivo-2026-09-23.md) descarta suponerla para todos los Samsung.

## Opciones verificadas

| Producto y ficha de compra | Precio y disponibilidad observados | Alimentación / tamaño / sonido | Cómo podría recibir la señal de Relevo | Trabajo y límite |
| --- | --- | --- | --- | --- |
| [BBC micro:bit V2 GO, MCI Electronics](https://mcielectronics.cl/shop/product/bbc-microbit-v2-go-kit-de-inicio/) | **$36.990 CLP; disponible online y en tienda en Chile**. Incluye placa, portapilas, 2 AAA y cable micro-USB. | Placa de 4 × 5 cm; altavoz para tonos y melodías; batería de 2 AAA. | Orden corta por BLE al firmware del objeto; el [programa de mesa del repositorio](prueba-microbit-ble/README.md) ya describe una orden `activar`. | Requiere integrar el comando BLE en Relevo y medir conexión, volumen y autonomía. La placa queda expuesta; sus LED son rojos, no sustituyen luz cálida difusa. Es la compra local más completa para un primer banco técnico portátil. |
| [M5Stack StickS3 K150, Mouser Chile](https://www.mouser.cl/en/ProductDetail/M5Stack/K150?qs=vcFyY%252BOcAyhupjyuZj532Q%3D%3D) | **$23.606 CLP por unidad; 638 unidades en stock del distribuidor** al abrir la ficha. El total con envío e importación a Chile no fue calculado. | Carcasa de 48 × 24 × 15 mm, altavoz de 1 W, pantalla, batería interna de 250 mAh; ficha [oficial M5Stack](https://docs.m5stack.com/en/core/StickS3). | Programa propio que reciba un comando BLE (el ESP32-S3 [admite Bluetooth LE](https://documentation.espressif.com/esp32-s3_datasheet_en.pdf)) o por Wi-Fi local de 2,4 GHz y toque un sonido almacenado. | Hay que programar el dispositivo y la futura integración en Relevo; no existe compatibilidad de fábrica con la app actual. Autonomía del uso real sin medir; el fabricante recomienda volumen bajo 75 % con batería para evitar reinicios y advierte que las primeras partidas pueden producir un leve ruido tras encenderse, riesgo específico para el requisito de silencio. El stock del distribuidor no acredita una bodega chilena. Mejor hardware integrado si el costo final de importación resulta razonable. |
| [M5Stack Atom Echo C008-C, Mouser Chile](https://www.mouser.cl/es/ProductDetail/M5Stack/C008-C?qs=sGAEpiMZZMvI685ayE5Sa5PAHlHatIkcoQyhSSALZFsX0Dw9wIn2fg%3D%3D) | **$14.198 CLP; con stock del distribuidor** en la ficha; envío e importación no calculados. | Carcasa de 24 × 24 × 17 mm y altavoz integrado de 0,8 W; [ficha técnica oficial](https://docs.m5stack.com/en/atom/atomecho). Alimentación USB; no se documenta batería interna. | Firmware propio por Wi-Fi local o BLE que reciba `activar` y reproduzca localmente un tono. | Requiere cable/alimentación USB, firmware e integración de la app. Aunque M5Stack ofrece un firmware de parlante Bluetooth A2DP, **ese modo no satisface por sí solo la exclusividad**: puede reproducir audio de otras apps. Para Relevo usar modo de comandos, no modo A2DP. |
| [JBL Go 4, Paris](https://www.paris.cl/parlante-bluetooth-go-4-negro-755804999.html) | **$34.990 CLP; ficha con botón de compra de Paris**. | Producto terminado de 9,4 × 7,6 × 4,2 cm, batería recargable, hasta 7 h indicadas por tienda. | Audio Bluetooth A2DP desde el `AudioTrack` de la app Android actual. | Es el único de la tabla que puede ensayarse con el APK actual sin programar el objeto. No reserva el parlante para Relevo: exige probar separación por app en el **teléfono concreto** antes de usarlo con participantes. |
| [ESP32-C3 SuperMini + buzzer pasivo, Pinout](https://pinout.cl/producto/kit-esp32-c3-supermini-con-pantalla-lcd-1602-i2c-y-buzzer) | **$9.990 CLP; en stock y envío dentro de Chile** en la ficha. | Placa, buzzer y cables separados; sin caja, batería ni cable USB-C. | Firmware propio por Wi-Fi o BLE que encienda el buzzer al recibir una orden. | Económico para laboratorio, pero requiere cableado, montaje y desarrollo. No cumple el requisito de objeto compacto ya armado para entregar a una persona. La pantalla incluida sobra para un primer ensayo sonoro. |

**La tienda de MCI es stock local declarado.** Mouser Chile muestra precio en pesos y existencias para despacho, pero [sus condiciones internacionales](https://www.mouser.cl/) indican que aranceles, aduana e impuestos pueden cobrarse aparte; no se equipara esa disponibilidad con stock en Chile. Las publicaciones de Mercado Libre Internacional de StickS3/Atom Echo muestran oferta adicional, pero tampoco equivalen a inventario local ni garantizan plazo de entrega, por lo que no son la base de la recomendación.

## ¿Puede micro:bit V2 GO permanecer conectado a Relevo?

**Es viable como prototipo, no está garantizado al comprar el kit.** La placa V2 dispone de BLE y altavoz, y el paquete GO trae dos pilas AAA. El [programa de prueba del repositorio](prueba-microbit-ble/README.md) está compilado para recibir `activar` y reproducir un tono, pero sigue pendiente de ensayo en hardware. La app Android actual aún no envía esa orden BLE. Emparejar la placa con el teléfono no equivale a integrarla con Relevo ni garantiza que el enlace GATT permanezca activo.

La [guía oficial de Android para BLE en segundo plano](https://developer.android.com/develop/connectivity/bluetooth/ble/background) indica que el sistema puede cerrar una conexión si mata el proceso y ofrece mecanismos para detectar presencia y reconectar. Para Relevo hay que decidir si mantener enlace durante el periodo de uso o conectar al dispararse el evento, y medir latencia y energía. En ambos casos se debe ensayar pantalla apagada, cambio a YouTube/Instagram, ahorro de batería, salida de alcance y reconexión. La facilidad para la persona depende del flujo de emparejamiento y recuperación que se diseñe después; no viene resuelta por el kit.

### Pilas, autonomía y batería recargable

El GO trae portapilas y [dos AAA](https://mcielectronics.cl/shop/product/bbc-microbit-v2-go-kit-de-inicio/); no tiene batería recargable interna ni circuito para cargar por su puerto micro-USB. La [Fundación micro:bit](https://support.microbit.org/support/solutions/articles/19000013982-how-do-i-power-my-micro-bit-) confirma la alimentación por dos AAA y advierte sobre el voltaje de baterías recargables. Las pilas sí se agotarán. No hay una duración oficial verificada para **este** firmware BLE, con estos intervalos de conexión, sonido y posible luz externa: citar horas de otro programa como autonomía de Relevo sería engañoso. La guía oficial indica que el uso de radio, LED y accesorios modifica el consumo; un nivel bajo de batería puede [afectar Bluetooth antes de apagar la placa](https://support.microbit.org/support/solutions/articles/19000157495-troubleshooting-connection-issues-in-the-machine-learning-tool).

Para una primera prueba, usar AAA alcalinas nuevas y llevar otro par. Medir al menos una jornada completa con el patrón real de activaciones, la conexión elegida y el teléfono previsto; registrar hora de inicio, tensión o aviso de pila baja, desconexiones y momento de fallo. Para una prueba de varias jornadas, no fijar recambio ni prometer autonomía hasta medir. La V2 puede apagarse manteniendo pulsado el botón de encendido, pero [al hacerlo se detiene el programa](https://support.microbit.org/support/solutions/articles/19000120358-how-do-i-power-off-or-put-the-micro-bit-to-sleep-/1000), por lo que no recibirá avisos mientras esté apagada.

Sí se puede diseñar una alimentación recargable **externa** con salida regulada dentro de las [especificaciones eléctricas oficiales](https://tech.microbit.org/hardware/powersupply/), con cargador/protección y conector apropiados. Eso añade componentes y validación eléctrica; una celda LiPo de 3,7 V nominales llega a unos 4,2 V cargada y no debe conectarse directamente a la entrada de batería de la placa, cuyo límite de operación es 3,6 V. La [guía de seguridad](https://microbit.org/get-started/user-guide/electrical-product-guidance/) aconseja usar las AAA previstas y desaconseja las recargables sin una solución comprobada. El micro-USB alimenta/programa la placa; **no carga las AAA ni convierte el GO en un dispositivo recargable**. Para el primer test, cambiar pilas es más simple que agregar electrónica de carga.

### Alcance BLE

La [ficha técnica oficial](https://tech.microbit.org/hardware/) publica antena, sensibilidad y potencia de transmisión, pero no una distancia garantizada de 10 m para micro:bit V2 con un teléfono específico. **Diez metros en línea de vista pueden ser plausibles; diez metros constantes a través de paredes no están acreditados.** La [ayuda oficial](https://support.microbit.org/support/solutions/articles/19000157495-troubleshooting-connection-issues-in-the-machine-learning-tool) recomienda acercar el dispositivo al resolver pérdidas de Bluetooth y advierte que la batería baja puede afectar el enlace. Para Relevo, tratar 2–5 m en la misma habitación como objetivo inicial de diseño, no como especificación certificada; ensayar a 1, 5 y 10 m y con una pared, anotando tasa de órdenes recibidas, latencia y recuperación. Si la sesión exige más de 10 m fiables, no decidirlo por la versión de Bluetooth: medir el montaje real o elegir otra arquitectura.

**Juicio para Relevo:** micro:bit V2 GO es una compra razonable para demostrar la cadena teléfono → orden BLE → sonido local silencioso para otras apps. No es todavía el objeto ideal para entregar sin asistencia: faltan integración Android, ensayos de estabilidad/autonomía/alcance, carcasa y la luz cálida requerida por la propuesta de fase A.

## Opciones revisadas que no conviene usar como primera compra

- **Sirena de alarma Wi-Fi Tuya/Smart Life:** existe una [ficha chilena de kit con sirena](https://www.solomon.cl/product/kit-sistema-de-alarma-inteligente-wifi-con-sirena-tuyasmart) a $59.990, pero declara hasta **120 dB**, un sonido de intrusión desproporcionado para una señal cómoda de hábito. La ficha no documenta una API local ni un tono suave seleccionable desde Relevo y muestra «Avísame cuando llegue», por lo que tampoco hay stock confirmado. No comprar para el test.
- **Rastreadores Bluetooth con pitido:** el hecho de que la app propietaria pueda hacerlos sonar no demuestra que Relevo pueda enviarles un comando. Sin protocolo público y SKU verificado, no son una opción de integración acreditada.
- **Parlantes inteligentes de voz:** reciben audio/órdenes mediante servicios y cuentas propias, pero la investigación no identificó un modelo barato en Chile con API documentada para que Relevo emita una señal local, breve y exclusiva. Tampoco se debe inferir exclusividad por ser Wi-Fi.

## Recomendación de decisión

1. **Para investigar ahora con una compra local y portátil:** micro:bit V2 GO de MCI. Incluye energía y altavoz y permite demostrar una señal BLE sin compartir el audio del teléfono. Sigue siendo un prototipo programable; la futura integración con Relevo debe quedar presupuestada. La disponibilidad de MCI es la más clara entre los objetos de comandos revisados.
2. **Si se prioriza un objeto pequeño ya encerrado, con batería y sonido más rico:** pedir cotización final del StickS3 K150 a Mouser Chile. Es una opción técnica más cercana al formato de objeto de test, con precio base menor, pero logística/costo final inciertos y necesidad de firmware.
3. **Si el objeto puede quedar enchufado y se quiere minimizar el tamaño:** Atom Echo con firmware de comandos. Su precio base es el menor entre los objetos con altavoz ya integrado; el total de importación y la alimentación pueden cambiar esa comparación.
4. **Si el test inmediato debe usar el APK actual:** JBL Go 4 solo después de probar en el Galaxy exacto *Separate app sound*, Relevo en el parlante y YouTube/Instagram en el teléfono. Esa vía prueba la experiencia sonora actual, no la arquitectura universal del objeto.

## Verificación antes de la sesión

- Confirmar precio final, stock y entrega en carrito con la comuna real.
- Comprobar que el objeto permanece silencioso al conectar y durante el uso de otras apps.
- Medir tono, volumen, duración, latencia y reconexión con la versión exacta de firmware y teléfono.
- Medir autonomía del montaje seleccionado; ninguna duración publicada reemplaza el ensayo con el patrón real de Relevo.
- En micro:bit y M5Stack, diferenciar prueba de mesa del test integrado: **el APK actual no envía la orden de comando**.

## Registro de cambios (disclaimer)

### 2026-09-23 — Evaluación de conexión, energía y alcance del kit GO

- **Cambio:** se precisó el estado de integración con Relevo, el riesgo de conexión en segundo plano, la ausencia de una autonomía demostrada para el firmware, los límites de alimentación recargable y la incertidumbre de los 10 m BLE.
- **Antes:** la comparación recomendaba el kit GO para banco técnico portátil sin detallar estas condiciones de uso continuado.
- **Motivo:** responder si la compra permite un enlace constante y si sirve como dispositivo de test con participantes.
- **Alcance y límites:** análisis de documentación oficial y del repositorio; no se adquirió la placa ni se midieron horas de batería o metros de alcance.

### 2026-09-23 — Exploración inicial de compra

- **Cambio:** se compararon fichas reales de venta en Chile o con despacho a Chile con datos oficiales de hardware, energía y modo de control.
- **Antes:** la recomendación de compra solo contrastaba JBL Go 4 y placa micro:bit suelta.
- **Motivo:** buscar un objeto compacto y razonablemente barato que pueda sonar exclusivamente cuando Relevo emita una señal.
- **Alcance y límites:** investigación documental; no compra, no ensayo, no firmware nuevo y no modificación de la app. Precio y stock pueden cambiar.
