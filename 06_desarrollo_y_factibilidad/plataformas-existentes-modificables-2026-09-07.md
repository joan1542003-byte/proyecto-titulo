# Plataformas físicas existentes y modificables

**Fecha de corte:** 7 de septiembre de 2026; ruta de compra actualizada el 11 de septiembre de 2026
**Propósito:** reducir la fabricación necesaria para probar Relevo sin confundir una plataforma de desarrollo con el producto final.

**Vigencia:** la búsqueda nacional posterior incorporó una puerta anterior a las placas: probar dos iTag clásicos, comprados a vendedores distintos, para saber si una aplicación Android propia puede gobernar su zumbador. Esta prueba no aprueba por anticipado su luz, estabilidad ni uso con participantes. La comparación completa y las publicaciones vigentes se encuentran en [Productos terminados disponibles en Chile](busqueda-productos-terminados-chile-2026-09-11.md).

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
| **iTag BLE clásico, dos muestras** | Carcasa compacta, CR2032, zumbador y posible servicio estándar Immediate Alert | Inspeccionar GATT, reconexión, espera, control local y respuesta de cualquier LED; implementar la escritura desde Android | Es la única opción comercial local encontrada que podría evitar la construcción del enlace sonoro; sus clones varían y la luz no está garantizada | **Primera puerta de compra y ensayo** |
| **BBC micro:bit V2** | BLE 5.0, matriz de 25 LED rojos, altavoz, botones, suspensión y programación documentada | Alimentación, cubierta y una luz cálida externa antes de trabajar con participantes; integración Android propia para el recorrido final | Muy buena para aislar BLE, tiempos, sonido y silencio local; la matriz integrada no reproduce la señal cromática definida para fase A | **Respaldo de banco si los iTag fallan** |
| **Circuit Playground Bluefruit** | nRF52840, BLE, diez LED, altavoz de 7,5 mm, dos botones, interruptor, alimentación externa o LiPo y forma circular de 50,6 mm | Batería, sistema de carga externo o pilas y carcasa/difusor; comprobar disponibilidad | Muy buena para una maqueta portátil sin soldar: integra casi todo lo requerido y admite una carcasa circular | **Ruta preferente si se consigue** |
| **BleenyButton sobre XIAO nRF52840** | Repositorio abierto con XIAO, batería LiPo de 170 mAh, pulsador, firmware BLE, archivos STL y carcasa atornillada | Reemplazar el propósito de botón por el comportamiento de Relevo y añadir luz controlada más un transductor sonoro | No es un producto terminado, pero aporta una receta mecánica y de alimentación reproducible para la integración final | **Antecedente constructivo prioritario** |
| **M5Stack ATOM Echo** | Cuerpo comercial de 24 × 24 × 17 mm, BLE, LED RGB, altavoz, botón y orificio de fijación | Alimentación portátil, gestión de batería, firmware BLE de bajo consumo y control de volumen | Muy compacto, pero la necesidad de agregar energía reabre la dificultad que se busca evitar; su altavoz de 0,5 W requiere regular cuidadosamente la salida | **Referencia de escala, no ruta inicial** |
| **Bangle.js 2 u otro smartwatch hackeable** | Batería, BLE, botón y programación de aplicaciones | Adaptar una lógica de reloj a un objeto situado; ocultar o inutilizar pantalla; modificar una carcasa poco reparable | El reloj se usa en la muñeca, no junto al primer paso de una actividad. Además, Bangle.js 2 no posee altavoz piezoeléctrico; el sonido procede del motor de vibración y es muy débil | **Descartado como plataforma de Relevo** |
| **XIAO nRF52840 con componentes externos** | BLE, carga de batería y LED de placa | Elegir batería, luz, transductor, botón, cableado y carcasa | Es la mejor ruta para una versión integrada y sobria, pero no la más rápida para probar el valor de la interacción | **Ruta de integración posterior** |

## Ruta recomendada por etapas

```text
Dos iTag clásicos de partidas distintas
        │
        ├─ si no aceptan control directo o no reconectan →
        │  micro:bit V2 como respaldo de banco
        │
        └─ si aceptan la orden desde Android →
           conservar la muestra apta para ensayar vínculo y sonido
           ├─ si su luz también es gobernable y cumple el patrón → evaluar fase A
           └─ si no → mantenerla como prueba sonora, no como material completo

Después de comprobar la interacción
        ├─ si se consigue Circuit Playground Bluefruit → maqueta portátil
        └─ si el aporte físico justifica una versión propia →
           XIAO nRF52840 + luz única + transductor + LiPo + carcasa
```

### Etapa 1 — dos iTag clásicos

El primer desembolso recomendado corresponde a dos unidades económicas de vendedores distintos. Los iTag clásicos suelen ofrecer el servicio Bluetooth Immediate Alert, que permite solicitar una alerta desde Android sin conservar la aplicación del vendedor. Sin embargo, el nombre comercial no identifica un circuito estable: la inspección física debe confirmar el servicio `0x1802`, la característica `0x2A06`, la respuesta a los valores `0x00`, `0x01` y `0x02`, la reconexión y el silenciamiento.

Una unidad que solo emita sonido puede servir para desarrollar el vínculo Android–objeto y representar parcialmente el comportamiento. No puede aprobar el material de fase A si no produce la luz prevista, no ejecuta el patrón completo o se apaga durante la espera. La prueba de aceptación y las compras priorizadas están documentadas en la [búsqueda de productos terminados](busqueda-productos-terminados-chile-2026-09-11.md).

### Etapa 2 — micro:bit V2, como respaldo

Es la vía más rápida y disponible para evitar que Android, BLE, sonido y control local se transformen simultáneamente en un problema de electrónica. La placa mide aproximadamente 4 × 5 cm, tiene un altavoz y una matriz de 25 LED rojos, y MCI Electronics la lista disponible por CLP 24.990 al 7 de septiembre de 2026. El soporte oficial documenta Bluetooth 5.0 en V2, un perfil BLE propio, servicio UART y uso desde Android.

Su carcasa inicial debe ser una funda impresa o de cartón rígido que:

1. deje pasar un halo de luz sin presentar una pantalla;
2. conserve una salida acústica;
3. permita acceder a los botones de silencio y reinicio;
4. mantenga visible el cable de alimentación únicamente durante la prueba de mesa;
5. no simule un acabado industrial ni oculte que es una plataforma de ensayo.

Para el primer recorrido portátil se puede usar el portapilas oficial de dos AAA. Esta solución aumenta el volumen y no es la forma final, pero permite ensayar la situación sin diseñar alimentación ni carga. La prueba no requiere rastrear, contar pasos ni usar los sensores del micro:bit.

La matriz integrada permite revisar sin participantes la recepción del comando, los tres pulsos, el tono, la interrupción y la reconexión. No permite aprobar el material de fase A porque su emisión es roja y el protocolo exige luz blanca cálida. Para esa segunda puerta se incorpora un LED cálido externo en P1 con resistencia limitadora, difusor y revisión previa. Si la fuente no alcanza la perceptibilidad prevista, no se fuerza el pin ni se modifica la resistencia sin revisar la ficha del componente y el circuito.

El [paquete Android–BLE para micro:bit](prueba-microbit-ble/README.md) contiene el proyecto MakeCode, el binario de mesa, los parámetros de señal y el procedimiento de instalación. La compilación quedó comprobada; el comportamiento físico y la salida cálida continúan sin medir.

### Etapa 3 — Circuit Playground Bluefruit, condicionada a disponibilidad

Esta placa circular reúne el conjunto más cercano a Relevo ya integrado: Bluetooth de baja energía sobre nRF52840, altavoz amplificado de 7,5 mm, LED direccionables, dos botones e interruptor. Mide 50,6 mm de diámetro y pesa 8,9 g antes de sumar batería y carcasa. Puede alimentarse con USB, pilas AAA o una LiPo. La documentación revisada no confirma un cargador LiPo integrado, por lo que la carga no debe suponerse resuelta. Su diseño abierto, archivos de PCB y ejemplos oficiales de BLE permiten estudiarla y modificar su comportamiento sin ingeniería inversa.

La propuesta no consiste en exponer una placa educativa. Una carcasa de dos piezas puede dejar solo un área de luz difusa y un pequeño orificio de sonido. El firmware encendería como máximo uno o dos LED en blanco cálido o ámbar y reproduciría un tono corto; los demás sensores y entradas permanecen apagados. La placa tiene una función de desconexión de sensores y NeoPixels para reducir consumo, pero la autonomía debe medirse con el patrón real.

Al momento de esta revisión, la tienda oficial la declara agotada. Por eso no se recomienda comprarla ni diseñar alrededor de ella sin confirmar un distribuidor con stock, precio final y plazo de llegada.

### Etapa 4 — XIAO nRF52840

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

1. Comprar las dos muestras iTag priorizadas y ejecutar la prueba de aceptación antes de desarrollar la integración definitiva.
2. Si una muestra permite control directo, usarla solo para las capacidades que demuestre: vínculo y sonido, o material completo si también supera luz, patrón, espera y silenciamiento.
3. Si ambas muestras fallan, conseguir prestado o acceder a un micro:bit V2 para comprobar BLE, tiempos, sonido y silencio con la matriz roja, sin participantes.
4. Añadir y revisar una luz blanca cálida externa antes de usar micro:bit como material de fase A; la matriz integrada no se considera equivalente.
5. Consultar Circuit Playground Bluefruit solo si su disponibilidad y el avance de las pruebas justifican otra compra.
6. Mantener BleenyButton y XIAO nRF52840 como antecedentes de una integración posterior, no como obligación inmediata de fabricación.
7. Descartar rastreadores sujetos a Find My, Find Hub o SmartThings, y los relojes cuya forma y controles no responden al uso situado.

## Prueba mínima con plataforma existente

- Android envía una orden `activar` por BLE.
- El objeto confirma recepción y ejecuta tres pulsos de luz más un tono corto.
- Un botón local silencia inmediatamente y apaga la señal.
- La persona deja el objeto junto al primer paso de una actividad elegida.
- Se registra si entiende qué significa, qué opciones reconoce y si percibe la señal.

La primera versión puede utilizar un temporizador manual desde Android. Si se cancela antes del momento definido, la aplicación no envía la orden. La detección de uso de aplicaciones y un protocolo BLE más amplio se incorporan solo después de demostrar conexión, percepción y comprensión.

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
- Micro:bit Educational Foundation. (s. f.). *Connecting an LED to the micro:bit*. https://support.microbit.org/support/solutions/articles/19000101863-connecting-an-led-to-the-micro-bit
- Micro:bit Educational Foundation. (s. f.). *Hardware*. https://tech.microbit.org/hardware/
- Micro:bit Educational Foundation. (2025). *Using the micro:bit Bluetooth Low Energy UART*. https://support.microbit.org/support/solutions/articles/19000062330-using-the-micro-bit-bluetooth-low-energy-uart-serial-over-bluetooth-

## Registro de cambios (disclaimer)

### 2026-09-11 — Producto terminado antes de la placa

- **Qué cambió:** se incorporó la prueba de dos iTag clásicos como primera puerta y micro:bit pasó a ser el respaldo de banco.
- **Cómo era antes:** micro:bit era la primera plataforma prevista y los localizadores comerciales se descartaban como una sola categoría.
- **Por qué:** la revisión técnica distinguió los rastreadores cerrados de los iTag que posiblemente exponen el servicio estándar Immediate Alert; comprobar dos unidades puede evitar fabricar el enlace sonoro.
- **Límite:** ningún iTag ha sido inspeccionado. La luz, el patrón, el tiempo de espera, la reconexión y el silenciamiento continúan abiertos y deben superar la ficha técnica antes de trabajar con participantes.

### 2026-09-08 — Matriz roja separada de la luz cálida

- **Qué cambió:** la matriz integrada queda limitada al banco técnico; la prueba con participantes exige una fuente cálida externa revisada, y se enlaza el paquete MakeCode ya compilado.
- **Cómo era antes:** el documento trataba los 25 LED de micro:bit como una salida capaz de cubrir conexión y comprensión sin declarar que todos emiten luz roja.
- **Por qué:** la especificación oficial de la placa contradice la luz blanca cálida fijada en el protocolo; mantener ambas como equivalentes habría invalidado el control del material.
- **Alcance:** no se ha conectado el LED externo ni instalado el binario; brillo, difusión, volumen, latencia y estabilidad siguen sujetos al ensayo técnico.

### 2026-09-08 — Interfaz BLE mínima para la primera prueba

- **Qué cambió:** la plataforma de prueba recibe únicamente la orden `activar`; el silencio se resuelve mediante el control físico y una cancelación previa ocurre en Android antes de transmitir.
- **Cómo era antes:** la prueba mínima proponía enviar `activar`, `silenciar` y `cancelar` al objeto por BLE.
- **Por qué:** reducir estados y fallos ajenos a la pregunta principal, sin eliminar la salida local que debe comprender la persona.
- **Límite:** esta simplificación gobierna la fase A; no fija el protocolo BLE ni los controles definitivos del producto integrado.

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
