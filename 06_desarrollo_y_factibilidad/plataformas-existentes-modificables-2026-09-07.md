# Plataformas físicas existentes y modificables

**Fecha de corte:** 7 de septiembre de 2026  
**Propósito:** reducir la fabricación necesaria para probar Relevo sin confundir una plataforma de desarrollo con el producto final.

## Pregunta

¿Qué objeto ya disponible permite probar una señal situada de luz y sonido desde Android, con la menor cantidad posible de electrónica, fabricación y riesgo?

La investigación separa dos tareas que antes se mezclaban. La primera es comprobar que una señal llega desde Android y se entiende junto al primer paso de una actividad. La segunda es construir un objeto compacto y coherente con Relevo. No necesitan resolverse con la misma plataforma.

## Criterios

- salida de luz y sonido ya integrada;
- Bluetooth de baja energía utilizable desde Android;
- un control local para silenciar;
- alimentación portátil;
- programación documentada;
- carcasa o integración física posible;
- disponibilidad y costo comprobables;
- ausencia de pantalla como interfaz del objeto.

La última condición no prohíbe que una placa tenga LED. Relevo puede usar una matriz o varios LED exclusivamente como luz; no debe mostrar texto, menús, tiempo ni información en el objeto.

## Alternativas encontradas

| Plataforma | Ya resuelto | Trabajo adicional | Adecuación a Relevo | Dictamen |
|---|---|---|---|---|
| **BBC micro:bit V2** | BLE 5.0, matriz LED 5 × 5, altavoz, botones, suspensión, programación visual o Python | Alimentación portátil y carcasa; una integración Android propia para el recorrido final | Muy buena para probar el vínculo Android → luz/sonido y comprensión del objeto; su placa expuesta no representa el acabado final | **Ruta inmediata de prueba** |
| **Circuit Playground Bluefruit** | nRF52840, BLE, diez LED, altavoz de 7,5 mm, dos botones, interruptor, alimentación externa o LiPo y forma circular de 50,6 mm | Batería, sistema de carga externo o pilas y carcasa/difusor; comprobar disponibilidad | Muy buena para una maqueta portátil sin soldar: integra casi todo lo requerido y admite una carcasa circular | **Ruta preferente si se consigue** |
| **BleenyButton sobre XIAO nRF52840** | Repositorio abierto con XIAO, batería LiPo de 170 mAh, pulsador, firmware BLE, archivos STL y carcasa atornillada | Reemplazar el propósito de botón por el comportamiento de Relevo y añadir luz controlada más un transductor sonoro | No es un producto terminado, pero aporta una receta mecánica y de alimentación reproducible para la integración final | **Antecedente constructivo prioritario** |
| **M5Stack ATOM Echo** | Cuerpo comercial de 24 × 24 × 17 mm, BLE, LED RGB, altavoz, botón y orificio de fijación | Alimentación portátil, gestión de batería, firmware BLE de bajo consumo y control de volumen | Muy compacto, pero la necesidad de agregar energía reabre la dificultad que se busca evitar; su altavoz de 0,5 W requiere regular cuidadosamente la salida | **Referencia de escala, no ruta inicial** |
| **Bangle.js 2 u otro smartwatch hackeable** | Batería, BLE, botón y programación de aplicaciones | Adaptar una lógica de reloj a un objeto situado; ocultar o inutilizar pantalla; modificar una carcasa poco reparable | El reloj se usa en la muñeca, no junto al primer paso de una actividad. Además, Bangle.js 2 no posee altavoz piezoeléctrico; el sonido procede del motor de vibración y es muy débil | **Descartado como plataforma de Relevo** |
| **XIAO nRF52840 con componentes externos** | BLE, carga de batería y LED de placa | Elegir batería, luz, transductor, botón, cableado y carcasa | Es la mejor ruta para una versión integrada y sobria, pero no la más rápida para probar el valor de la interacción | **Ruta de integración posterior** |

## Ruta recomendada por etapas

```text
Prueba de comprensión y conexión
micro:bit V2 + portapilas + funda simple
        │
        ├─ si se consigue la placa circular con batería →
        │  Circuit Playground Bluefruit + LiPo + carcasa/difusor
        │
        └─ si el aporte físico justifica una versión propia →
           XIAO nRF52840 + luz única + transductor + LiPo + carcasa
           └─ montaje basado en el precedente BleenyButton
```

### Etapa 1 — micro:bit V2

Es la vía más rápida y disponible para evitar que Android, BLE, luz, sonido y control local se transformen simultáneamente en un problema de electrónica. La placa mide aproximadamente 4 × 5 cm, tiene un altavoz y 25 LED, y MCI Electronics la lista disponible por CLP 24.990 al 7 de septiembre de 2026. El soporte oficial documenta Bluetooth 5.0 en V2, un perfil BLE propio, servicio UART y uso desde Android.

Su carcasa inicial debe ser una funda impresa o de cartón rígido que:

1. deje pasar un halo de luz sin presentar una pantalla;
2. conserve una salida acústica;
3. permita acceder a los botones de silencio y reinicio;
4. mantenga visible el cable de alimentación únicamente durante la prueba de mesa;
5. no simule un acabado industrial ni oculte que es una plataforma de ensayo.

Para el primer recorrido portátil se puede usar el portapilas oficial de dos AAA. Esta solución aumenta el volumen y no es la forma final, pero permite ensayar la situación sin diseñar alimentación ni carga. La prueba no requiere rastrear, contar pasos ni usar los sensores del micro:bit.

### Etapa 2 — Circuit Playground Bluefruit, condicionada a disponibilidad

Esta placa circular reúne el conjunto más cercano a Relevo ya integrado: Bluetooth de baja energía sobre nRF52840, altavoz amplificado de 7,5 mm, LED direccionables, dos botones e interruptor. Mide 50,6 mm de diámetro y pesa 8,9 g antes de sumar batería y carcasa. Puede alimentarse con USB, pilas AAA o una LiPo. La documentación revisada no confirma un cargador LiPo integrado, por lo que la carga no debe suponerse resuelta. Su diseño abierto, archivos de PCB y ejemplos oficiales de BLE permiten estudiarla y modificar su comportamiento sin ingeniería inversa.

La propuesta no consiste en exponer una placa educativa. Una carcasa de dos piezas puede dejar solo un área de luz difusa y un pequeño orificio de sonido. El firmware encendería como máximo uno o dos LED en blanco cálido o ámbar y reproduciría un tono corto; los demás sensores y entradas permanecen apagados. La placa tiene una función de desconexión de sensores y NeoPixels para reducir consumo, pero la autonomía debe medirse con el patrón real.

Al momento de esta revisión, la tienda oficial la declara agotada. Por eso no se recomienda comprarla ni diseñar alrededor de ella sin confirmar un distribuidor con stock, precio final y plazo de llegada.

### Etapa 3 — XIAO nRF52840

Si las pruebas muestran que el lugar aporta comprensión frente a una notificación, se justifica trasladar el comportamiento aprendido a una pieza más sobria. La XIAO mantiene BLE y carga de batería, pero obliga a resolver luz, sonido y carcasa. Su ventaja no es ser más rápida: permite quitar sensores, LEDs y controles que no forman parte de Relevo, bajar el volumen visual y lograr un objeto más cercano a la forma final.

### Antecedente constructivo prioritario — BleenyButton

[BleenyButton](https://github.com/asterics/BleenyButton) no es un referente de uso para Relevo: es un botón BLE de accesibilidad. Sí resuelve una dificultad concreta que el proyecto no necesita reinventar: cómo alojar una XIAO nRF52840, una LiPo de 170 mAh y un pulsador en una carcasa pequeña que se puede abrir. El repositorio incluye firmware PlatformIO, esquema de cableado, piezas STL para base, tapa y aro, y una unión mediante tres tornillos M2.

Este antecedente permite separar dos decisiones. La disposición física —placa, batería, fijación y acceso a carga— puede estudiarse y reproducirse de manera controlada. El comportamiento debe diseñarse desde cero para Relevo: una luz breve y un sonido moderado activados desde Android, con un control local de silencio. No se trasladan su finalidad, su mensaje ni su interacción de asistencia.

Antes de reutilizar código, archivos STL o modificaciones derivadas, debe revisarse la licencia GPL-3.0 del repositorio. Para esta etapa se utiliza como evidencia técnica de ensamblaje, no como material incorporado al producto.

## Por qué no un smartwatch

Un reloj hackeable parece conveniente porque ya tiene batería, Bluetooth y software. Sin embargo, cambia el sentido de Relevo: el objeto pasa a estar sobre el cuerpo, junto al mismo flujo de atención, en lugar de permanecer cerca de las pesas, un libro o unas zapatillas. También añade una pantalla que invita a notificaciones, estados y navegación; esa capa contradice la señal breve buscada.

Bangle.js 2 es valioso como antecedente técnico de plataforma abierta y BLE de bajo consumo. No es una buena base física: su sonido se produce mediante el motor de vibración, sin altavoz piezoeléctrico, y la modificación física exige abrir un cuerpo diseñado como reloj. Por ese motivo se registra como referente, no como compra recomendada.

M5StickS3 representa la alternativa más cercana a un dispositivo terminado —incluye batería, altavoz, botones y carcasa—, pero también incorpora una pantalla y está pensado para interacción continua. Podría servir para una demostración técnica aislada, aunque no para representar Relevo ni orientar su forma. Además, su documentación advierte que un volumen alto con alimentación desde batería puede provocar reinicios. No reduce el riesgo de la solución final de manera suficiente para justificar una compra.

## Comparación de esfuerzo

Escala de 1 a 5, donde 5 reduce más el esfuerzo en la etapa indicada.

| Criterio | micro:bit V2 | Circuit Playground Bluefruit | BleenyButton + XIAO | ATOM Echo | Bangle.js 2 |
|---|---:|---:|---:|---:|---:|
| Disponibilidad local comprobada | 5 | 1 | 4 | 2 | 1 |
| Luz y sonido sin cableado | 5 | 5 | 1 | 5 | 2 |
| BLE documentado | 4 | 5 | 5 | 3 | 4 |
| Alimentación portátil sin rediseño | 3 | 3 | 4 | 1 | 5 |
| Coherencia con objeto situado | 3 | 4 | 5 | 4 | 1 |
| Potencial de acabado final | 2 | 3 | 5 | 3 | 1 |
| **Uso recomendado** | **probar pronto** | **maqueta portátil** | **integrar después** | **referencia compacta** | **no usar** |

## Decisión de trabajo

1. Conseguir prestado o acceder a un micro:bit V2 solo para demostrar el recorrido físico y BLE.
2. En paralelo, consultar disponibilidad real de Circuit Playground Bluefruit en un distribuidor. Solo después de confirmar precio, plazo y necesidad de la prueba se decidirá si vale la pena incorporarla.
3. Usar BleenyButton como referencia concreta de carcasa, batería y fijación para la XIAO; no copiar su finalidad ni sus archivos sin revisar la licencia.
4. No usar un smartwatch ni modificar un localizador comercial: ambos añaden pantalla, restricciones de firmware o ingeniería inversa sin responder mejor a la hipótesis.
5. Mantener la XIAO nRF52840 como ruta de integración cuando ya existan medidas de luz, sonido, latencia y comprensión.

## Prueba mínima con plataforma existente

- Android envía `activar`, `silenciar` o `cancelar` por BLE.
- El objeto confirma recepción y ejecuta tres pulsos de luz más un tono corto.
- Un botón local silencia inmediatamente y apaga la señal.
- La persona deja el objeto junto al primer paso de una actividad elegida.
- Se registra si entiende qué significa, qué opciones reconoce y si percibe la señal.

La primera versión puede utilizar un temporizador manual desde Android. La detección de uso de aplicaciones se incorpora después de demostrar conexión, percepción y comprensión.

El trabajo quedó trazado en la [Issue #11: Probar la señal situada con una plataforma existente](https://github.com/joan1542003-byte/proyecto-titulo/issues/11). La Issue #10 conserva la construcción y verificación del testigo portátil integrado; no son tareas equivalentes.

## Fuentes

- Adafruit. (s. f.). *Circuit Playground Bluefruit—Bluetooth Low Energy*. https://www.adafruit.com/product/4333
- Adafruit. (2025). *Arduino BLE examples: Circuit Playground Bluefruit*. https://learn.adafruit.com/adafruit-circuit-playground-bluefruit/arduino-examples
- Adafruit. (s. f.). *Adafruit Circuit Playground Bluefruit PCB*. GitHub. https://github.com/adafruit/Adafruit-Circuit-Playground-Bluefruit-PCB
- Asterics Foundation. (s. f.). *BleenyButton*. GitHub. https://github.com/asterics/BleenyButton
- Espruino. (s. f.). *Bangle.js 2 technical information*. GitHub. https://github.com/espruino/EspruinoDocs/blob/master/boards/Bangle.js2.md
- M5Stack. (s. f.). *ATOM Echo*. https://docs.m5stack.com/en/atom/atomecho
- M5Stack. (s. f.). *M5StickS3 ESP32S3 mini IoT development kit*. https://shop.m5stack.com/products/m5sticks3-esp32s3-mini-iot-dev-kit
- MCI Electronics. (s. f.). *Placa BBC micro:bit V2*. https://mcielectronics.cl/shop/product/bbc-microbit-v2-placa-unica/
- Micro:bit Educational Foundation. (s. f.). *Bluetooth*. https://tech.microbit.org/bluetooth/
- Micro:bit Educational Foundation. (2025). *Using the micro:bit Bluetooth Low Energy UART*. https://support.microbit.org/support/solutions/articles/19000062330-using-the-micro-bit-bluetooth-low-energy-uart-serial-over-bluetooth-

## Registro de cambios (disclaimer)

### 2026-09-07 — Creación

- **Qué cambió:** se añadieron plataformas ya fabricadas y modificables al estudio físico: micro:bit V2, Circuit Playground Bluefruit, ATOM Echo y Bangle.js 2.
- **Cómo era antes:** la factibilidad comparaba principalmente una placa XIAO, componentes individuales y localizadores comerciales.
- **Por qué:** el proyecto necesita comprobar pronto la experiencia phygital y evitar que una primera prueba dependa de fabricar electrónica propia.
- **Límite:** disponibilidad, precio, autonomía, latencia y percepción deben confirmarse antes de una compra. Ninguna plataforma prueba por sí sola el valor de Relevo ni define su objeto final.

### 2026-09-07 — Ampliación con precedente constructivo

- **Qué cambió:** se incorporó BleenyButton como antecedente abierto de ensamblaje con XIAO, LiPo, carcasa atornillada y firmware BLE; también se descartó explícitamente M5StickS3 como forma de representación del proyecto.
- **Cómo era antes:** el estudio comparaba placas y formatos disponibles, pero no contaba con un caso reproducible de batería, fijación y carcasa para la ruta XIAO.
- **Por qué:** reducir la incertidumbre de fabricación sin adoptar un smartwatch, una pantalla o un producto comercial ajeno al uso situado.
- **Límite:** el precedente no autoriza reutilizar código o archivos bajo GPL-3.0 sin revisar su alcance; siguen pendientes las medidas de autonomía, sonido, luz y tamaño.
