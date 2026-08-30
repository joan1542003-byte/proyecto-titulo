# Alternativas para simplificar la arquitectura física de Relevo

**Fecha de corte:** 30 de agosto de 2026

**Estado:** exploración comparativa; no reemplaza la arquitectura provisional ni autoriza compras o energización

**Pregunta:** ¿cuál es el montaje mínimo capaz de producir una señal física situada, perceptible y controlable sin añadir complejidad que la prueba todavía no necesita?

## Punto de partida

La parte física de Relevo no se justifica por contener electrónica, sino por sacar la señal de la pantalla y vincularla con un lugar elegido. Cualquier simplificación debe conservar cuatro funciones:

1. emitir una señal breve sin texto;
2. permitir que la persona la asocie con una intención y un primer paso;
3. permanecer físicamente junto a ese primer paso;
4. admitir silencio o detención local sin exigir volver al teléfono.

La arquitectura provisional de fase A puede cumplirlas, pero utiliza dos niveles de tensión, una tira de 12 V, un convertidor, un MOSFET y una rama cercana a 1,17 A. Esa configuración sirve como referencia construible, no como obligación de diseño. Su costo parcial documentado es CLP 28.130 y aún excluye terminales y protección de potencia.

## Criterios de comparación

Las alternativas se revisaron según seis preguntas. La prioridad sigue el propósito de la próxima prueba, no una forma final imaginada.

| Criterio | Pregunta de control | Prioridad |
| --- | --- | --- |
| Validez de la prueba | ¿Permite estudiar señal, asociación y lugar sin introducir otra interacción dominante? | Crítica |
| Seguridad | ¿Reduce tensión, corriente, conexiones expuestas y modos de fallo? | Crítica |
| Simplicidad | ¿Disminuye piezas, fuentes, conversiones y pasos de montaje? | Alta |
| Continuidad técnica | ¿Puede evolucionar hacia comunicación local con Android? | Alta |
| Control de la persona | ¿Conserva una acción física para detener la señal? | Alta |
| Costo trazable | ¿Sus partidas pueden cotizarse sin confundir prototipo con producto? | Media |

## Alternativas

### A. Arquitectura provisional de 12 V

Combina Arduino Nano, tira LED de 12 V, fuente, convertidor reductor, módulo MOSFET, interruptor y activación cableada. Su principal ventaja es disponer de una fuente luminosa amplia y regulable. A cambio, incorpora una rama de potencia que exige revisión, protección y terminales antes de energizar.

**Mantenerla si:** una fuente de 5 V no alcanza la perceptibilidad necesaria o el difusor exige una superficie luminosa mayor.

**No elegirla todavía como forma final:** resolvería luminosidad antes de saber cuánta luz necesita realmente la experiencia.

### B. Núcleo único de 5 V con ESP32-C3 — candidata prioritaria

La propuesta reúne una placa ESP32-C3, un anillo WS2812 de 12 LED, un pulsador o interruptor físico, alimentación USB de 5 V y un difusor temporal. La placa integra Bluetooth Low Energy, por lo que puede recibir la activación remota y, más adelante, comunicarse localmente con Android. El anillo necesita una sola línea de datos y permite limitar por software cantidad de LED, color y brillo.

Esta opción elimina del primer montaje la fuente de 12 V, el convertidor LM2596S, la tira rígida y el módulo MOSFET. No elimina la revisión electrónica: deben confirmarse la alimentación del anillo, la compatibilidad entre la señal lógica de 3,3 V y su entrada de datos, la corriente máxima configurada, la condición de apagado al iniciar y el control físico.

| Partida preliminar | Precio observado | Fuente |
| --- | ---: | --- |
| ESP32-C3 Super Mini | CLP 7.990 | [MechatronicStore](https://www.mechatronicstore.cl/placa-de-desarrollo-esp32-c3-super-mini/) |
| Anillo WS2812 de 12 LED, 5 V | CLP 3.500 | [Afel](https://afel.cl/products/anillo-led-rgb-ws2812-de-12-leds) |
| Pulsador simple | CLP 290 | [MechatronicStore](https://www.mechatronicstore.cl/boton-pulsador-switch-2-pines-6x6x7mm/) |
| Fuente cerrada USB de 5 V y 2 A | CLP 3.490 | [MechatronicStore, precio citado en guía técnica](https://www.mechatronicstore.cl/blog/matriz-led-ws2812b-8x8-con-esp32-fastled) |
| Cable USB-C de un metro | CLP 2.190 | [MechatronicStore, precio citado en guía técnica](https://www.mechatronicstore.cl/blog/matriz-led-ws2812b-8x8-con-esp32-fastled) |
| **Subtotal preliminar identificado** | **CLP 17.460** | Sin cuerpo, difusor, interruptor definitivo, protecciones, conexiones, envío ni revisión |

El subtotal es aproximadamente 38 % menor que las partidas identificadas del montaje de 12 V. La comparación no demuestra todavía un costo final menor, porque las exclusiones no son idénticas y el hardware no ha sido probado.

**Ventaja principal:** una sola familia de alimentación y una placa que puede servir tanto en la prueba manual como en la integración Android.

**Riesgo principal:** reducir piezas puede trasladar complejidad al enlace Bluetooth y a la programación. Android admite el intercambio de pequeñas cantidades de datos mediante Bluetooth Low Energy, pero exige permisos, descubrimiento, conexión y manejo explícito de desconexiones ([Android Developers, 2026](https://developer.android.com/develop/connectivity/bluetooth/ble/ble-overview)).

### C. Núcleo de 5 V con Arduino Nano y activación cableada

Reemplaza la tira de 12 V por el mismo anillo WS2812, conserva el Nano y utiliza USB para alimentación. Es la alternativa más directa para una fase A sin Bluetooth y reutiliza el firmware ya preparado con ajustes en la salida luminosa.

**Ventaja:** reduce riesgos eléctricos y conserva una activación determinista.

**Límite:** obliga a cambiar de controlador cuando se integre Android, duplicando parte del desarrollo. Por eso funciona como reserva si Bluetooth interfiere con la primera prueba, no como primera ruta de continuidad.

### D. Lámpara o bombilla inteligente comercial

Una luminaria existente podría emitir el pulso mediante una integración local o una automatización. Reduciría la fabricación electrónica inicial, pero introduciría ecosistema del fabricante, configuración de red, forma y luminosidad no controladas, y posibles dependencias de nube. También debilitaría la relación entre objeto transportable, lugar elegido y primer paso.

**Uso pertinente:** referencia o prototipo de percepción muy temprano.

**Descarte para el prototipo central:** simplifica la construcción a costa de perder control sobre la experiencia, la privacidad y la identidad física de Relevo.

### E. Etiqueta NFC o marcador físico pasivo

Una etiqueta NFC es barata, no necesita alimentación y puede vincular un lugar con una acción del teléfono. Sin embargo, exige acercar o desbloquear el teléfono para activar o leer la interacción. La señal vuelve a depender de la pantalla y deja de aparecer de manera situada cuando se cumple la condición.

**Uso pertinente:** emparejamiento, identificación o configuración futura.

**Descarte como señal principal:** cambia la hipótesis que se necesita estudiar; el objeto se convierte en un acceso al teléfono, no en una salida física situada.

## Comparación sintética

| Alternativa | Piezas y alimentación | Continuidad con Android | Aporte físico situado | Decisión provisional |
| --- | --- | --- | --- | --- |
| A. 12 V actual | Alta complejidad; 12 V y 5 V | Requiere añadir Bluetooth o cambiar placa | Alto si la luz amplia resulta necesaria | Conservar como respaldo |
| B. ESP32-C3 + anillo 5 V | Baja; una fuente de 5 V | Alta, mediante Bluetooth Low Energy | Alto; señal autónoma y desplazable | **Prototipar primero** |
| C. Nano + anillo 5 V | Baja; una fuente de 5 V | Baja; necesita sustitución posterior | Alto | Reserva para aislar radio |
| D. Luminaria comercial | Baja fabricación, alta dependencia externa | Variable según fabricante | Medio; forma y lugar condicionados | Solo exploración perceptiva |
| E. NFC pasivo | Mínima | Alta como entrada al teléfono | Bajo como salida física | No usar como señal principal |

## Ruta de decisión propuesta

No se recomienda comprar todavía el montaje completo de 12 V. El siguiente paso es un **prototipo técnico comparativo de 5 V**, sin participantes y sin forma final:

1. revisar con una persona competente un esquema de ESP32-C3, anillo, control físico y USB;
2. construir el núcleo sobre una base abierta y limitar el brillo desde el programa;
3. ejecutar las mismas series de activación, duración, silencio, reinicio, distancia y estabilidad ya definidas para fase A;
4. registrar perceptibilidad en las tres superficies e iluminaciones previstas;
5. probar por separado la activación cableada y la activación Bluetooth, para distinguir fallos de señal de fallos de enlace;
6. reemplazar la arquitectura de 12 V solo si la versión de 5 V cumple la ficha sin aumentar ambigüedad o intrusión.

La prueba no debe comparar objetos terminados. Debe responder si una fuente luminosa pequeña y difusa basta para hacer visible la señal. Si no basta, el resultado justificará aumentar superficie o potencia. Si basta, se habrá evitado una rama eléctrica innecesaria y se podrá avanzar con una arquitectura más coherente con el prototipo Android.

## Preguntas que siguen abiertas

- ¿Cuántos LED y qué límite de brillo permiten percibir el pulso sin convertirlo en alarma?
- ¿El difusor mantiene la señal visible a uno, dos y tres metros con luz diurna?
- ¿Un solo control físico puede silenciar y comunicar claramente su estado sin añadir modos ambiguos?
- ¿La conexión Bluetooth puede mantenerse solo durante la ventana armada para reducir consumo y estados inciertos?
- ¿Conviene mantener alimentación USB durante la investigación y posponer batería hasta medir consumo real?

## Referencias

Adafruit Industries. (s. f.). *NeoPixel Überguide*. https://cdn-learn.adafruit.com/downloads/pdf/adafruit-neopixel-uberguide.pdf

Android Developers. (2026, 26 de febrero). *Bluetooth Low Energy overview*. https://developer.android.com/develop/connectivity/bluetooth/ble/ble-overview

Afel. (s. f.). *Anillo LED RGB WS2812 de 12 leds*. Recuperado el 30 de agosto de 2026, de https://afel.cl/products/anillo-led-rgb-ws2812-de-12-leds

Espressif Systems. (s. f.). *Bluetooth Low Energy: ESP32-C3*. Recuperado el 30 de agosto de 2026, de https://docs.espressif.com/projects/esp-idf/en/stable/esp32c3/api-guides/ble/index.html

MechatronicStore. (s. f.). *Placa de desarrollo ESP32-C3 Super Mini*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/placa-de-desarrollo-esp32-c3-super-mini/

## Registro de cambios (disclaimer)

### 2026-08-30 — Exploración inicial

- **Cambio:** se compararon cinco maneras de materializar la señal física y se definió una ruta de prueba para una arquitectura de 5 V.
- **Versión anterior:** el repositorio comparaba modos de activación para el montaje de 12 V, pero no cuestionaba su nivel de potencia ni su cantidad de piezas.
- **Motivo:** comprobar si Relevo puede conservar su función física situada con menor costo, riesgo y complejidad antes de comprar componentes.
- **Alcance:** no se seleccionó una arquitectura final, no se compraron piezas y no se modificaron firmware, protocolo, memoria ni montaje vigente.
