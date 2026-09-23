# Compra para el testeo sonoro: opciones con disponibilidad visible en Chile

**Consulta:** 23 de septiembre de 2026. **Estado:** recomendación condicionada de compra; no se efectuó compra ni ensayo. **Necesidad:** objeto pequeño, ya fabricado, que permanezca callado durante el uso ordinario del teléfono y emita la señal de Relevo de forma sencilla para la persona. Los precios, stock y entrega cambian; confirmar en el carrito con la comuna de destino antes de pagar.

**Ampliación del mismo día:** la [exploración de más dispositivos](exploracion-dispositivos-sonoros-chile-2026-09-23.md) incorpora micro:bit V2 GO de MCI con pilas y portapilas incluidos, M5Stack StickS3 con batería y altavoz, Atom Echo USB y un kit ESP32 con buzzer. Para una compra local de banco técnico portátil, el paquete GO de MCI es más completo que la placa suelta de Hubot descrita abajo. Esta nota conserva el análisis inicial y sus precios observados.

## Decisión de compra

**Para el test de la app Android actual, comprar un parlante multimedia solo si el teléfono de prueba permite separar el sonido por aplicación y esa función se ha comprobado.** La opción concreta encontrada es [JBL Go 4 negro, vendido por Paris](https://www.paris.cl/parlante-bluetooth-go-4-negro-755804999.html): la página consultada hoy mostraba **$34.990 CLP**, botón de compra, Bluetooth, tamaño de 9,4 × 7,6 × 4,2 cm, cable USB-C y hasta siete horas de reproducción. Es un parlante terminado y compacto. La separación depende del teléfono, no del modelo JBL: un Android que lo seleccione como salida multimedia puede enviarle también YouTube e Instagram. En ciertos Galaxy, Samsung ofrece *Separate app sound* para elegir una app para el parlante y conservar el audio general en el teléfono ([guía de Samsung](https://www.samsung.com/uk/support/mobile-devices/useful-audio-settings-on-the-galaxy-phone-including-separate-app-sound/)). Hay que verificar en el modelo real que Relevo aparezca entre las apps seleccionables y que ambas rutas funcionen antes de compra o reclutamiento.

**Si el teléfono no tiene una separación por app comprobada, no comprar todavía un parlante Bluetooth multimedia como solución de ese requisito.** El código actual solo dirige la pista de Relevo; no controla las otras apps ([análisis de enrutamiento](enrutamiento-audio-parlante-exclusivo-2026-09-23.md)). El JBL sí podría servir para una demostración sonora menos exigente, pero no se debe presentar como objeto reservado para Relevo.

La comprobación es necesaria incluso si el teléfono es Samsung y fue lanzado en los últimos seis años: el [análisis por manuales](enrutamiento-audio-parlante-exclusivo-2026-09-23.md#está-en-todos-los-samsung-lanzados-desde-septiembre-de-2020) registra un Galaxy A03 Core de 2021 cuyos manuales no documentan *Separate app sound*. La guía general de Samsung no es una lista de compatibilidad por modelo.

## Alternativa física sin compartir el audio multimedia

La [BBC micro:bit V2.2 de Hubot](https://hubot.cl/producto/nueva-microbit-v2-0-sku-684/) figuraba hoy con **existencias y $26.900 CLP**. Es una placa ya fabricada con parlante integrado, botones, Bluetooth y LED rojos. La fundación micro:bit confirma el parlante integrado y el enlace Bluetooth; el [programa de mesa del repositorio](prueba-microbit-ble/README.md) ya recibe una orden `activar` por BLE para emitir sonido y admite silencio local ([características oficiales](https://www.microbit.org/get-started/features/overview/), [UART BLE oficial](https://support.microbit.org/support/solutions/articles/19000062330-using-the-micro-bit-bluetooth-low-energy-uart-serial-over-bluetooth-)). Se alimenta por USB o baterías; la tienda mostraba un [cable USB de datos compatible](https://hubot.cl/producto/cable-usb-a-microusb-30-cm-otg-sku-438f2/) a $1.390 CLP, pero hay que confirmar si ya se dispone de uno. La placa sola no incluye necesariamente alimentación portátil ni una cubierta.

Esta micro:bit permite una **prueba técnica/manual del objeto** sin que el contenido multimedia del teléfono suene en ella. **No funciona con el APK actual simplemente conectándola:** la app vigente busca una salida de audio A2DP o LE Audio, mientras el programa micro:bit espera una orden BLE. También falta resolver la luz blanca cálida difusa exigida por el protocolo con personas; la matriz de la placa es roja y se limita al banco de prueba. Por eso no es una compra «lista para usar» en el test integrado de la app sin trabajo adicional.

**Energía y sonido de la micro:bit.** La V2/V2.2 incorpora un pequeño altavoz para tonos y melodías; no es un parlante Bluetooth multimedia al que Android envíe YouTube o Instagram. No tiene batería recargable incorporada: funciona por micro-USB o con un portapilas de **dos AAA** ([fundación micro:bit: alimentación](https://support.microbit.org/support/solutions/articles/19000013982-how-do-i-power-my-micro-bit-), [características V2](https://support.microbit.org/support/solutions/articles/19000119052)). El paquete oficial **Single** contiene solo placa y folleto: no incluye portapilas, pilas ni cable ([contenido oficial Single](https://microbit.org/buy/bbc-microbit-single/)). El paquete oficial **Go** sí incluye placa, cable, portapilas y dos AAA ([contenido oficial Go](https://microbit.org/buy/bbc-microbit-go/)). La ficha de la placa suelta de Hubot citada arriba no detalla el contenido de la caja; **no se puede afirmar que incluya pilas o portapilas** sin confirmarlo con la tienda. Para una sesión móvil, presupuestar ambos por separado si se compra esa ficha.

La fundación no da una autonomía única para V2 con el programa de Relevo. La duración depende del tiempo de conexión inalámbrica, brillo de LED, frecuencia del sonido y accesorios; el uso de radio y LED aumenta el gasto ([consejos oficiales para prolongar la batería](https://support.microbit.org/support/solutions/articles/19000087231-prolonging-battery-life)). El dato de «300 mA» en especificaciones es capacidad máxima de alimentación, **no consumo continuo**; no sirve para calcular horas de uso de este montaje. Antes del test con personas, medir la autonomía del firmware y pilas elegidos durante una sesión completa más un margen para reconexiones. Para las pruebas de mesa se puede alimentar por micro-USB.

El [kit de inicio micro:bit de Hubot](https://hubot.cl/producto/kit-inicio-microbit-v2-de-keyestudio-sku-752/) aparecía con existencias a $59.000 CLP e incluye cable, portapilas y muchos componentes de robótica. Para probar solo la señal sonora, la mayoría sobraría. El [portapilas individual compatible](https://hubot.cl/producto/porta-pilas-aaa-x-2-3v-compatible-microbit-sku-644h1/) aparecía **sin existencias** al abrir su ficha hoy, aunque la búsqueda lo mostraba disponible: se toma como válida la ficha abierta, no el resumen de búsqueda.

## Recomendación práctica según el teléfono

| Situación | Compra indicada ahora | Qué quedaría por comprobar |
| --- | --- | --- |
| Galaxy compatible con *Separate app sound*, confirmado en Ajustes | JBL Go 4 de Paris, si el precio y stock siguen vigentes al pagar. | Antes de reclutar: configurar Relevo → JBL; YouTube/Instagram → teléfono; silencio del parlante en reposo; señal, volumen y reconexión. |
| Android sin esa función o modelo todavía desconocido | **Posponer compra de parlante multimedia**. Para banco técnico del objeto, micro:bit V2.2 de Hubot si se acepta programar y probar BLE. | La integración BLE en Relevo y, para personas, luz cálida, cubierta, energía y prueba de fiabilidad. |
| La prueba requiere luz y sonido integrados, colocación en el hogar y uso autónomo de varios participantes | Ninguna de las dos fichas acredita hoy un objeto terminado que cumpla todo el protocolo. | Definir primero el montaje final de la sesión y superar la puerta técnica. |

**Paso que falta para cerrar la compra:** conocer el modelo y versión Android del teléfono que usará Relevo. También hay que decidir si se evaluará la app actual con parlante multimedia o la asociación con un objeto BLE controlado; son pruebas distintas. La facilidad del usuario requiere observar la primera conexión y la reconexión, no solo que el investigador logre emparejar el dispositivo.

## Registro de cambios (disclaimer)

### 2026-09-23 — Ampliación de alternativas

- **Cambio:** se enlazó la comparación de cinco productos y se señaló que el kit micro:bit GO de MCI incluye alimentación portátil, a diferencia de la placa suelta inicialmente investigada.
- **Antes:** esta nota podía leerse como si solo existieran JBL y la placa suelta de Hubot.
- **Motivo:** ofrecer una compra de prueba más completa y separar stock local de importación.
- **Alcance y límites:** investigación documental; sin compra ni prueba física.

### 2026-09-23 — Compatibilidad Samsung por modelo

- **Cambio:** se precisó que «Samsung reciente» no basta como criterio de compra y se enlazó el contraste de manuales oficiales.
- **Antes:** la recomendación exigía verificar el teléfono, pero no aportaba una excepción concreta dentro del período 2020–2026.
- **Motivo:** impedir que se compre el parlante por una presunta compatibilidad universal.
- **Alcance y límites:** evidencia documental; falta confirmar el teléfono real del test.

### 2026-09-23 — Aclaración de alimentación y autonomía de micro:bit

- **Cambio:** se diferenciaron las cajas oficiales Single y Go, el contenido no confirmado de la ficha de Hubot, el altavoz integrado y la ausencia de una cifra de autonomía válida para el programa BLE propuesto.
- **Antes:** «se alimenta por USB o baterías» no permitía estimar los componentes mínimos de compra y podía confundirse con una batería incorporada.
- **Motivo:** evitar comprar una placa suelta sin alimentación portátil o prometer una duración que no se ha medido.
- **Alcance y límites:** documentación del fabricante y del distribuidor; no se abrió el producto ni se midió el consumo.

### 2026-09-23 — Primera recomendación de compra

- **Cambio:** se contrastaron dos productos con precio y disponibilidad visibles en Chile con el requisito de reservar el sonido para Relevo.
- **Antes:** la investigación describía categorías de parlante y dispositivo BLE, pero no una compra concreta ni sus dependencias.
- **Motivo:** evitar pagar por un parlante que no resuelva la separación de audio o por una placa que no funcione con el APK vigente.
- **Alcance y límites:** precios y stock son observaciones de las fichas consultadas, no reservas; no se verificaron en carrito, no hubo compra ni prueba en dispositivos físicos.
