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

### B. Núcleo único de 5 V con XIAO ESP32-C3 — familia prioritaria

La propuesta reúne una placa Seeed Studio XIAO ESP32-C3, un anillo WS2812 de 12 LED, controles físicos, una fuente cerrada de 5 V y un difusor temporal. La placa integra Bluetooth Low Energy, por lo que puede recibir la activación remota y, más adelante, comunicarse localmente con Android. El anillo necesita una sola línea de datos y permite limitar por software cantidad de LED, color y brillo.

La primera comparación consideró una ESP32-C3 Super Mini genérica. Se reemplaza como candidata porque la [ficha comercial consultada](https://www.mechatronicstore.cl/placa-de-desarrollo-esp32-c3-super-mini/) asigna su LED a GPIO48, pin que no corresponde al mapa documentado del ESP32-C3, y no aporta un esquema del fabricante que permita resolver esa contradicción. La XIAO cuesta más, pero dispone de documentación oficial, esquema, mapa de pines y archivos de diseño. En una arquitectura que aún debe revisarse antes de energizar, esa trazabilidad pesa más que ahorrar CLP 840.

Esta opción elimina del primer montaje la fuente de 12 V, el convertidor LM2596S, la tira rígida y el módulo MOSFET. No elimina la revisión electrónica: deben confirmarse la alimentación del anillo, la compatibilidad entre la señal lógica de 3,3 V y su entrada de datos, la corriente máxima configurada, la condición de apagado al iniciar y el control físico.

| Partida preliminar | Precio observado | Fuente |
| --- | ---: | --- |
| Seeed Studio XIAO ESP32-C3 | CLP 8.830 | [MechatronicStore](https://www.mechatronicstore.cl/seeed-studio-xiao-esp32-c3/) |
| Anillo WS2812 de 12 LED, 5 V | CLP 2.900 | [Hubot](https://hubot.cl/producto/anillo-led-rgb-neopixel-12-leds-ws2812-sku-4001f3/) |
| Pulsador simple | CLP 290 | [MechatronicStore](https://www.mechatronicstore.cl/boton-pulsador-switch-2-pines-6x6x7mm/) |
| Cable paralelo de activación, 3 m | CLP 600 | [MechatronicStore](https://www.mechatronicstore.cl/cable-paralelo-variedad-calibres/) |
| Interruptor físico provisional | CLP 240 | [Hubot](https://hubot.cl/productos/?orderby=price&per_page=24&per_row=2&shop_view=grid&stock_status=instock) |
| Dos borneras de distribución | CLP 480 | [Hubot](https://hubot.cl/producto/bornera-2-terminales-dg301-5mm-c-pernos-sku-469f2/) |
| Fuente cerrada de 5 V y 3 A | CLP 3.990 | [MechatronicStore](https://www.mechatronicstore.cl/transformador-cargador-fuente-de-alimentacion-5v-3a/) |
| Jack hembra para la fuente | CLP 506 | [Altronics](https://altronics.cl/plug-hembra-21x55mm-panel) |
| Cable USB-C de programación | CLP 2.190 | [MechatronicStore, precio citado en guía técnica](https://www.mechatronicstore.cl/blog/matriz-led-ws2812b-8x8-con-esp32-fastled) |
| **Subtotal preliminar identificado** | **CLP 20.026** | Sin conversor lógico, resistencia, condensador, conector del anillo, protección, base de ensayo, cuerpo, difusor, envío ni revisión |

Este subtotal no debe traducirse en un porcentaje de ahorro. El montaje de 12 V ya contabiliza una base de ensayo y una activación cableada a tres metros, mientras esta primera lista todavía omite auxiliares eléctricos. La [comparación de compra corregida](lista-materiales-y-compra-escalonada-5v-2026-08-30.md) eleva B1 a CLP 28.073 más el conversor lógico cuando se incluyen auxiliares cotizados y una base equivalente. Los montos solo podrán compararse como costos completos después de cerrar las partidas restantes.

**Ventaja principal:** una sola familia de alimentación y una placa que puede servir tanto en la prueba manual como en la integración Android.

**Riesgo principal:** reducir piezas puede trasladar complejidad al enlace Bluetooth y a la programación. Android admite el intercambio de pequeñas cantidades de datos mediante Bluetooth Low Energy, pero exige permisos, descubrimiento, conexión y manejo explícito de desconexiones ([Android Developers, 2026](https://developer.android.com/develop/connectivity/bluetooth/ble/ble-overview)).

#### B2. Variante con luz cálida no direccionable

Una segunda variante conserva la XIAO y la alimentación de 5 V, pero reemplaza el anillo RGB por un pequeño arreglo de LED blancos cálidos regulado mediante un transistor o módulo MOSFET. Esta opción se aproxima a la única salida visual que Relevo necesita y evita controlar color o puntos individuales. No se considera más sencilla hasta definir resistencias, distribución óptica, control desde 3,3 V y condición de apagado.

Su función es desafiar a B1 bajo las mismas condiciones de distancia, iluminación y difusión. Si produce el patrón con menos estados de fallo y componentes disponibles localmente, podrá reemplazar al anillo. Si la superficie resulta irregular o exige una fabricación más compleja, B1 conservará prioridad.

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
| B1. XIAO ESP32-C3 + anillo 5 V | Media; una fuente, conversión lógica y auxiliares | Alta, mediante Bluetooth Low Energy | Alto; señal autónoma y desplazable | Comparar con B2 antes de completar la compra |
| B2. XIAO ESP32-C3 + luz cálida 5 V | Media; una fuente y control de potencia | Alta, mediante Bluetooth Low Energy | Alto; salida acotada a la señal necesaria | Alternativa desafiante de B1 |
| C. Nano + anillo 5 V | Baja; una fuente de 5 V | Baja; necesita sustitución posterior | Alto | Reserva para aislar radio |
| D. Luminaria comercial | Baja fabricación, alta dependencia externa | Variable según fabricante | Medio; forma y lugar condicionados | Solo exploración perceptiva |
| E. NFC pasivo | Mínima | Alta como entrada al teléfono | Bajo como salida física | No usar como señal principal |

## Ruta de decisión propuesta

No se recomienda comprar todavía el montaje completo de 12 V ni todos los auxiliares de B1. El siguiente paso es una **comparación técnica de fuentes luminosas de 5 V**, sin participantes y sin forma final:

1. inventariar fuente, cable, base de ensayo y auxiliares reutilizables;
2. revisar con una persona competente los esquemas de B1 y B2 antes de energizar;
3. comparar el anillo y una fuente cálida sencilla con el mismo soporte, difusor y límite perceptivo;
4. completar solo la variante que produzca una señal uniforme, controlable y estable;
5. ejecutar las mismas series de activación, duración, silencio, reinicio, distancia y estabilidad ya definidas para fase A;
6. probar por separado la activación cableada y la activación Bluetooth, para distinguir fallos de señal de fallos de enlace;
7. reemplazar la arquitectura de 12 V solo si la versión de 5 V cumple la ficha sin aumentar ambigüedad o intrusión.

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

Espressif Systems. (2025). *ESP32-C3 series datasheet* (versión 2.3). https://documentation.espressif.com/esp32-c3_datasheet_en.html

MechatronicStore. (s. f.). *Seeed Studio XIAO ESP32-C3*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/seeed-studio-xiao-esp32-c3/

Seeed Studio. (s. f.). *Getting started with Seeed Studio XIAO ESP32C3*. Recuperado el 30 de agosto de 2026, de https://wiki.seeedstudio.com/XIAO_ESP32C3_Getting_Started/

## Registro de cambios (disclaimer)

### 2026-08-30 — Comparación interna de las fuentes de 5 V

- **Cambio:** el núcleo de 5 V se dividió en B1, con anillo direccionable, y B2, con luz cálida no direccionable; se corrigió la afirmación de ahorro y la ruta de compra.
- **Versión anterior:** B1 aparecía como primera arquitectura a prototipar y su subtotal preliminar se describía como aproximadamente 35 % menor que el de 12 V.
- **Motivo:** las listas no compartían las mismas exclusiones y el anillo incorpora funciones visuales que todavía deben justificarse frente a una salida cálida más simple.
- **Alcance:** B2 es una alternativa de comparación, no una solución elegida ni un circuito aprobado.

### 2026-08-30 — Controlador sustituido por una placa documentada

- **Cambio:** la ESP32-C3 Super Mini genérica se sustituyó por una Seeed Studio XIAO ESP32-C3 y el subtotal identificado pasó de CLP 17.460 a CLP 18.300.
- **Versión anterior:** la candidata dependía de una ficha comercial cuyo pin para el LED integrado no corresponde al mapa del ESP32-C3 y que no enlaza un esquema de fabricante.
- **Motivo:** una placa con esquema, pinout y archivos oficiales permite preparar una revisión eléctrica reproducible; la diferencia de CLP 840 no justifica conservar una base ambigua.
- **Alcance:** el nuevo subtotal sigue incompleto y la sustitución no aprueba conexiones, compra ni energización.

### 2026-08-30 — Exploración inicial

- **Cambio:** se compararon cinco maneras de materializar la señal física y se definió una ruta de prueba para una arquitectura de 5 V.
- **Versión anterior:** el repositorio comparaba modos de activación para el montaje de 12 V, pero no cuestionaba su nivel de potencia ni su cantidad de piezas.
- **Motivo:** comprobar si Relevo puede conservar su función física situada con menor costo, riesgo y complejidad antes de comprar componentes.
- **Alcance:** no se seleccionó una arquitectura final, no se compraron piezas y no se modificaron firmware, protocolo, memoria ni montaje vigente.
