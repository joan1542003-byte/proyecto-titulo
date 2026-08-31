# Lista de materiales y compra escalonada para el núcleo de 5 V

**Fecha de corte:** 30 de agosto de 2026

**Estado:** decisión de abastecimiento anterior a la compra; valores por verificar al pagar

**Alcance:** prototipo técnico abierto, sin forma final y sin participantes

## Decisión que debe apoyar esta lista

La arquitectura de 5 V sigue siendo la candidata más conveniente para la siguiente comprobación porque reúne controlador y señal luminosa bajo una misma alimentación y permite conservar la XIAO ESP32-C3 al integrar Android mediante Bluetooth. Sin embargo, el anillo RGB considerado hasta ahora no es la única forma de producir el pulso cálido que necesita Relevo.

Se distinguen, por tanto, dos variantes dentro de la misma arquitectura:

- **B1, luz direccionable:** XIAO ESP32-C3 y anillo WS2812. Facilita programar cada punto, pero exige convertir correctamente la señal de 3,3 V a 5 V y añadir componentes de protección recomendados para el anillo.
- **B2, luz cálida no direccionable:** XIAO ESP32-C3 y una pequeña fuente de luz blanca cálida controlada mediante un transistor o módulo MOSFET. Responde de manera más directa a la única salida visual prevista, aunque obliga a definir cantidad de LED, resistencias y distribución óptica mediante una prueba.

Ninguna variante queda seleccionada por su apariencia o por el precio publicado de su pieza principal. La elección depende de cuál produzca tres pulsos reconocibles, regulables y silenciosos con menos piezas, menos estados de fallo y una compra local más clara.

## Cómo se contabilizan los costos

Para evitar una comparación engañosa se usan tres cifras distintas:

1. **Desembolso de compra:** dinero que habría que pagar por el formato mínimo vendido, aunque sobren unidades.
2. **Costo atribuible al prototipo:** valor de las unidades efectivamente incorporadas. Solo puede cerrarse después de definir cantidades y registrar sobrantes reutilizables.
3. **Costo evitado por disponibilidad:** piezas, herramientas o cargadores existentes que no requieren una compra nueva. No se valoran como gratuitos en una futura estimación de producción.

Los subtotales siguientes son desembolsos identificados. No representan el costo unitario de Relevo, un precio de venta ni una cotización de fabricación.

## Núcleo común a B1 y B2

| Partida | Cantidad | Función | Desembolso observado | Condición |
| --- | ---: | --- | ---: | --- |
| Seeed Studio XIAO ESP32-C3 | 1 | Ejecutar estados y permitir la integración Bluetooth posterior. | CLP 8.830 | [MechatronicStore](https://www.mechatronicstore.cl/seeed-studio-xiao-esp32-c3/); placa documentada por el fabricante. |
| Pulsador momentáneo | 1 | Activación técnica cableada durante la comprobación. | CLP 290 | [MechatronicStore](https://www.mechatronicstore.cl/boton-pulsador-switch-2-pines-6x6x7mm/). |
| Cable paralelo de dos conductores, 24 AWG | 3 m | Situar la activación técnica a la misma distancia definida para la fase A. | CLP 600 | [MechatronicStore](https://www.mechatronicstore.cl/cable-paralelo-variedad-calibres/); CLP 200 por metro en la variante consultada. Debe fijarse fuera del recorrido. |
| Interruptor físico | 1 | Detener o silenciar localmente la señal. | CLP 240 | [Hubot, KCD11](https://hubot.cl/productos/?orderby=price&per_page=24&per_row=2&shop_view=grid&stock_status=instock); el modelo debe aprobarse al revisar el circuito. |
| Bornera de dos terminales | 2 | Separar y asegurar la distribución de alimentación. | CLP 480 | [Hubot, DG301](https://hubot.cl/producto/bornera-2-terminales-dg301-5mm-c-pernos-sku-469f2/); CLP 240 por unidad. |
| Fuente cerrada de 5 V y 3 A, con jack 5,5 × 2,1 mm | 1 | Alimentar un punto de distribución independiente de la placa. | CLP 3.990 | [MechatronicStore](https://www.mechatronicstore.cl/transformador-cargador-fuente-de-alimentacion-5v-3a/); su salida debe medirse antes de conectar cargas. |
| Jack hembra 5,5 × 2,1 mm, 3 A | 1 | Llevar la fuente al punto de distribución de 5 V. | CLP 506 | [Altronics](https://altronics.cl/plug-hembra-21x55mm-panel); exige conexión y aislación revisadas. |
| Cable USB-C de un metro | 1 | Programar la placa. | CLP 2.190 | Precio citado por [MechatronicStore](https://www.mechatronicstore.cl/blog/matriz-led-ws2812b-8x8-con-esp32-fastled); no se conectará simultáneamente con la alimentación externa sin aprobación. |
| **Subtotal común si todo debe comprarse** |  |  | **CLP 17.126** | Excluye luz, control de potencia o datos, protección, base de ensayo, soporte y envío. |
| **Subtotal común reutilizando fuente, jack y cable USB-C equivalentes** |  |  | **CLP 10.440** | La reutilización debe anotarse en el registro del montaje. |

La fuente, su conector y el cable USB-C no deben comprarse automáticamente. Primero se revisará si existen piezas equivalentes, rotuladas y en buen estado. Esta comprobación puede evitar CLP 6.686 sin alterar el prototipo. El cable paralelo de activación no se elimina por introducir Bluetooth: se necesita antes para comprobar la señal sin confundirla con fallos de radio.

La fuente con jack sustituye la primera idea de alimentar todo mediante un cable USB-C. Ese planteamiento todavía no definía cómo separar 5 V hacia la placa y la luz sin hacer pasar la corriente del anillo por la XIAO. El jack permite crear un punto de distribución visible y medible. La ruta exacta hacia el pin 5V/VBUS de la placa debe aprobarse y no puede coexistir con USB-C conectado al computador hasta revisar el esquema.

### Base de ensayo condicional

El montaje de 12 V incorpora un kit de protoboard, fuente y cables por CLP 5.690. Para comparar alcances equivalentes, el núcleo de 5 V debe registrar una base abierta y conexiones de baja corriente. Si el taller no dispone de protoboard y puentes aptos, se añade el mismo [kit publicado por MechatronicStore](https://www.mechatronicstore.cl/kit-protoboard-fuente-mb102-usb-set-de-cables/) como desembolso condicional. La protoboard no transportará la corriente de la fuente luminosa.

## Variante B1: anillo direccionable

| Partida específica | Cantidad | Función | Desembolso observado | Estado |
| --- | ---: | --- | ---: | --- |
| Anillo WS2812 de 12 LED, 5 V | 1 | Producir el patrón y regular brillo por software. | CLP 2.900 | [Hubot](https://hubot.cl/producto/anillo-led-rgb-neopixel-12-leds-ws2812-sku-4001f3/); figuraba con existencias y declara 18 mA por LED. La corriente real se medirá. |
| Conversor lógico 74AHCT125 o equivalente aprobado | 1 | Llevar la señal de datos de 3,3 V a un nivel compatible con el anillo alimentado a 5 V. | **Pendiente** | [Adafruit](https://www.adafruit.com/product/1787) publica la pieza a USD 1,50, sin envío ni impuestos; no se verificó una oferta local equivalente. |
| Resistencia de datos de 330 Ω, 1/2 W | 1 | Atenuar transitorios en la entrada de datos. | CLP 60 | [Electrónica Real](https://electronicareal.cl/categoria-producto/electronica/componentes/page/27/); precio observado en catálogo. Su valor debe verificarse con multímetro. |
| Condensador electrolítico de 1000 µF, 25 V | 1 | Estabilizar la alimentación junto al anillo. | CLP 290 | [Electrónica CM2](https://electronicacm2.cl/tienda/); disponibilidad observada en catálogo. Verificar variante y polaridad. |
| Conector desmontable JST-SM de tres pines | 1 | Separar +5 V, GND y datos del anillo sin improvisar uniones. | CLP 713 | [Altronics](https://altronics.cl/conector-jst-sm-3p); precio y stock deben reconfirmarse. |
| Portafusible en línea de 5 × 20 mm | 1 | Alojar la protección de la rama luminosa. | CLP 494 | [Altronics](https://altronics.cl/portafusible-5x20-volante). |
| Pack de cinco fusibles rápidos de 1 A | 1 pack | Proporcionar una protección candidata y repuestos. | CLP 800 | [MechatronicStore](https://www.mechatronicstore.cl/pack-5-fusibles-ceramicos-5x20mm-250v-accion-rapida-distintos-amper/). El valor de 1 A es provisional y debe aprobarse después de medir; no se aumenta si actúa sin investigar la causa. |
| **Subtotal B1 identificado, comprando todas las partidas con precio** |  |  | **CLP 22.383 + conversor lógico** | Incluye el pack completo de fusibles; todavía excluye el 74AHCT125, conductores internos, revisión y envío. |
| **Subtotal B1 identificado, reutilizando fuente, jack y cable USB-C** |  |  | **CLP 15.697 + conversor lógico** | La procedencia de cada pieza reutilizada debe registrarse. |
| **B1 si además debe comprarse la base de ensayo** |  |  | **CLP 28.073 + conversor lógico** | Escenario más próximo al alcance del montaje de 12 V, todavía sin envío ni revisión. |

El conversor lógico es el principal obstáculo de abastecimiento de B1. Una publicación internacional no garantiza plazo, compatibilidad ni costo puesto en Chile. Tampoco corresponde omitirlo para abaratar la tabla: la guía técnica consultada recomienda conversión cuando un NeoPixel recibe 5 V desde una lógica de 3,3 V ([Adafruit Industries, s. f.](https://learn.adafruit.com/neopixel-levelshifter)). La búsqueda no encontró una oferta chilena suficientemente verificable; por eso la cifra permanece abierta.

## Variante B2: luz cálida no direccionable

| Partida específica | Cantidad | Función | Desembolso observado | Estado |
| --- | ---: | --- | ---: | --- |
| Paquete de LED blancos cálidos, 3000 K | 1 paquete | Permitir ensayar cantidad, separación y difusión. | CLP 2.249 | [Mercado Libre Chile](https://www.mercadolibre.cl/diodo-led-pirana-5x5mm-luz-calida-3000k-alto-brillo-80-x20/up/MLCU110634405); formato de veinte unidades. Verificar vendedor y plazo antes de comprar. |
| Módulo MOSFET para PWM, 5–36 V | 1 | Regular la luz sin cargar una salida de la XIAO. | CLP 1.590 | [MechatronicStore](https://www.mechatronicstore.cl/modulo-regulador-switch-pwm-circuitos-de-potencia-15a-400w-mosfet/); su funcionamiento a 5 V y con lógica de 3,3 V debe revisarse en la unidad real. |
| Resistencias para cada rama LED y condición de apagado | Por definir | Limitar corriente y mantener la salida apagada durante el arranque. | **Pendiente** | La cantidad y el valor dependen del arreglo eléctrico aprobado; no deben inferirse desde una imagen. |
| **Subtotal B2 identificado, comprando fuente, jack y cable USB-C** |  |  | **CLP 20.965 + pendientes** | Incluye el paquete completo de LED, no solo los finalmente usados. |
| **Subtotal B2 identificado, reutilizando fuente, jack y cable USB-C** |  |  | **CLP 14.279 + pendientes** | Excluye resistencias, protección y soporte. |
| **B2 si además debe comprarse la base de ensayo** |  |  | **CLP 26.655 + pendientes** | Escenario comparable con la inclusión del kit en el montaje de 12 V. |

B2 no es automáticamente más barata que B1 en el primer desembolso: el módulo de control compensa parte del ahorro de la fuente luminosa. Su posible ventaja está en reducir funciones que Relevo no necesita —color y control individual de doce puntos— y evitar el conversor lógico de disponibilidad incierta. Esa ventaja solo existe si la revisión confirma el control desde 3,3 V, el arreglo de LED es seguro y la luz difundida cumple la prueba.

## Comparación justa con el montaje de 12 V

| Aspecto | A. Montaje de 12 V | B1. 5 V direccionable | B2. 5 V cálida no direccionable |
| --- | --- | --- | --- |
| Alimentación | 12 V para la luz y conversión a 5 V para el controlador. | Una fuente de 5 V. | Una fuente de 5 V. |
| Controlador | Nano compatible; requeriría otra solución para Bluetooth. | XIAO ESP32-C3, reutilizable en la integración Android. | XIAO ESP32-C3, reutilizable en la integración Android. |
| Control de luz | MOSFET y tira cálida de un metro. | Datos digitales, conversor lógico, resistencia y condensador. | MOSFET, resistencias y arreglo cálido por definir. |
| Superficie luminosa disponible | Amplia; puede cortarse y distribuirse. | Pequeña y circular. | Variable según número y disposición de LED. |
| Subtotal publicado o identificado | CLP 28.130. | CLP 22.383 más conversor lógico; CLP 28.073 más conversor si también debe comprarse la base de ensayo. | CLP 20.965 más partidas pendientes; CLP 26.655 si también debe comprarse la base de ensayo. |
| Exclusiones relevantes | Terminales, protección, cuerpo, difusor, herramientas, envío y revisión. | Conversor, resistencia, condensador, protección, conductores, cuerpo, difusor, herramientas, envío y revisión. | Resistencias, protección, conductores, cuerpo, difusor, herramientas, envío y revisión. |
| Razón para conservarla | Si las fuentes pequeñas no alcanzan visibilidad o superficie. | Si el control digital simplifica el patrón y el conversor se consigue con trazabilidad. | Si una salida cálida única cumple la señal con menos funciones y fallos. |

La diferencia porcentual publicada entre 12 V y 5 V no debe seguir utilizándose como prueba de ahorro. Las exclusiones no son equivalentes y, en B1, falta justamente el componente que permite controlar el anillo de manera robusta. Cuando se iguala al menos la base de ensayo, B1 alcanza CLP 28.073 antes del conversor lógico y B2 llega a CLP 26.655 antes de sus partidas pendientes. La comparación válida se cerrará después de completar auxiliares y registrar qué elementos ya estaban disponibles.

Tampoco existen costos hundidos que obliguen a continuar con 12 V: el repositorio registra que sus componentes no fueron comprados y el montaje no fue construido. La arquitectura debe elegirse por la calidad y claridad de la prueba siguiente, no para justificar una inversión inexistente.

## Compra por puertas

### Puerta 0 — inventario y revisión, sin comprar

- comprobar fuente de 5 V, cable USB-C, resistencias, condensadores, borneras, pulsadores y módulos disponibles en taller;
- comprobar también protoboard, cables de señal, material aislante y el cable paralelo necesario para la activación a tres metros;
- solicitar a una persona competente que revise B1 y B2, incluida la protección de baja tensión;
- confirmar si puede conseguirse localmente un 74AHCT125 o equivalente exacto con hoja de datos;
- registrar fotografía, marca, modelo, cantidad y estado de cada pieza reutilizable.

**Criterio de salida:** existe una lista de piezas disponibles y faltantes; ninguna sustitución se acepta solo porque encaja físicamente.

### Puerta 1 — compra mínima para comparar luz

- comprar la XIAO ESP32-C3, que sirve en ambas variantes;
- adquirir una muestra del anillo y una muestra de luz cálida únicamente si no pueden obtenerse prestadas;
- fabricar dos soportes abiertos equivalentes y usar el mismo difusor, distancia y condiciones de iluminación;
- comparar visibilidad, uniformidad, temperatura y posibilidad de producir el patrón, primero sin participantes.

**Criterio de salida:** una variante produce tres pulsos legibles a uno, dos y tres metros, sin puntos molestos ni calentamiento apreciable, y puede silenciarse de forma estable.

### Puerta 2 — completar solo la variante elegida

- comprar el control de datos o potencia y sus auxiliares aprobados;
- definir terminales, protección y conductores a partir de la corriente medida;
- actualizar esquema, lista de materiales y firmware antes de energizar el conjunto completo;
- mantener la variante descartada como evidencia comparativa, no como inventario obligatorio.

**Criterio de salida:** la lista de materiales coincide con el montaje real, todas las partidas tienen fuente o procedencia y la revisión electrónica permite ejecutar el ensayo técnico.

### Puerta 3 — cuerpo y difusión

El cuerpo no se compra ni fabrica en forma final antes de resolver la fuente luminosa. Tras elegir B1 o B2 se construirá un difusor temporal, ventilado y estable. Solo entonces se estudiarán dimensiones, material, fijación y fabricación del cuerpo como una decisión de producto.

## Registro de compra y reutilización

| Partida | Variante | Proveedor o procedencia | Cantidad comprada | Cantidad usada | Precio pagado | Sobrante reutilizable | Evidencia |
| --- | --- | --- | ---: | ---: | ---: | ---: | --- |
| ____ | ____ | ____ | ____ | ____ | ____ | ____ | Boleta, foto o inventario |

Este registro debe completarse al momento de adquirir o retirar una pieza. Así será posible separar el gasto de experimentación del costo atribuible al prototipo y evitar que un kit de veinte LED o cientos de resistencias se contabilice como si quedara completo dentro del objeto.

## Decisión provisional

No corresponde comprar todavía el conjunto completo de 12 V ni cerrar B1 como arquitectura definitiva. El paso más eficiente es revisar B1 y B2 y comparar sus fuentes luminosas bajo las mismas condiciones. La XIAO ESP32-C3 se mantiene como pieza común y compra defendible; fuente y cable se adquieren solo si el inventario no ofrece unidades verificables.

B2 pasa a ser **alternativa desafiante** y no nueva ganadora. Puede resultar más coherente con una señal blanca cálida y breve, pero todavía debe demostrar distribución, control y seguridad. B1 conserva la ventaja de una programación luminosa directa, aunque su conversor lógico debe resolverse antes de considerar completa su lista de materiales.

## Referencias

Adafruit Industries. (s. f.). *Logic level shifter*. https://learn.adafruit.com/neopixel-levelshifter

Adafruit Industries. (s. f.). *Quad level-shifter (74AHCT125)*. https://www.adafruit.com/product/1787

Afel. (s. f.). *Anillo LED RGB WS2812 de 12 leds*. Recuperado el 30 de agosto de 2026, de https://afel.cl/products/anillo-led-rgb-ws2812-de-12-leds

Hubot. (s. f.). *Bornera 2 terminales DG301 5 mm con pernos*. Recuperado el 30 de agosto de 2026, de https://hubot.cl/producto/bornera-2-terminales-dg301-5mm-c-pernos-sku-469f2/

MechatronicStore. (s. f.). *Matriz LED WS2812B 8 × 8 con ESP32 y FastLED*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/blog/matriz-led-ws2812b-8x8-con-esp32-fastled

MechatronicStore. (s. f.). *Transformador cargador fuente de alimentación 5 V 3 A*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/transformador-cargador-fuente-de-alimentacion-5v-3a/

MechatronicStore. (s. f.). *Módulo regulador PWM de potencia con MOSFET*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/modulo-regulador-switch-pwm-circuitos-de-potencia-15a-400w-mosfet/

MechatronicStore. (s. f.). *Seeed Studio XIAO ESP32-C3*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/seeed-studio-xiao-esp32-c3/

## Registro de cambios (disclaimer)

### 2026-08-30 — Creación de la comparación de compra

- **Cambio:** se completaron las partidas comunes del núcleo de 5 V, se separó el desembolso del costo atribuible y se añadió una alternativa de luz cálida no direccionable.
- **Versión anterior:** el subtotal de 5 V solo contenía controlador, anillo, pulsador, fuente y cable; podía compararse de manera incorrecta con el montaje de 12 V pese a excluir auxiliares distintos.
- **Motivo:** impedir una compra prematura y elegir la fuente luminosa por desempeño, simplicidad y trazabilidad, no por un subtotal incompleto.
- **Alcance:** no se seleccionó un circuito final, no se fijó una protección y no se autoriza montaje ni energización antes de revisión electrónica.

### 2026-08-30 — Corrección de equivalencia entre listas

- **Cambio:** se añadieron el cable de activación a tres metros y el escenario condicional de una base de ensayo de CLP 5.690; se recalcularon todos los subtotales de 5 V.
- **Versión anterior:** los escenarios de 5 V incluían la activación técnica, pero no su tendido a distancia ni una base comparable con la ya contabilizada en 12 V.
- **Motivo:** comparar prototipos preparados para la misma comprobación y hacer visible qué ahorro depende de reutilizar materiales.
- **Alcance:** los nuevos montos siguen incompletos mientras los auxiliares eléctricos y la protección permanezcan pendientes.

### 2026-08-30 — Fuente distribuible y auxiliares cotizados

- **Cambio:** se reemplazó la alimentación USB no distribuida por una fuente de 5 V y 3 A con jack, se actualizó el anillo a una oferta local de CLP 2.900 y se añadieron resistencia, condensador, conector desmontable y protección candidata.
- **Versión anterior:** la lista suponía una fuente USB y un cable USB-C, pero no definía cómo separar su salida hacia la XIAO y la luz sin atravesar la placa; varios auxiliares permanecían sin precio.
- **Motivo:** convertir el subtotal en una ruta físicamente revisable y hacer visible que B1 se aproxima al costo de 12 V antes de conseguir el conversor lógico.
- **Alcance:** el fusible de 1 A es una hipótesis de revisión, no una selección aprobada; la conexión simultánea de USB-C y alimentación externa permanece prohibida hasta revisión.
