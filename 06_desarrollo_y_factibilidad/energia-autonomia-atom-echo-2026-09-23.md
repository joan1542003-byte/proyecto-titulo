# Energía, recarga y viabilidad del Atom Echo portátil

**Consulta:** 23 de septiembre de 2026. Alcance: investigación de fichas técnicas y ofertas; no se compró, midió ni modificó hardware o software. El autor confirmó un objetivo de **8–12 h sin cargar**.

## Respuesta de compra inmediata

El [M5Stack Atom Echo/Atom Voice C008-C](https://docs.m5stack.com/en/atom/atomecho) mide 24 × 24 × 16,8 mm y trae Wi-Fi, BLE y altavoz, **pero no batería ni cargador**. Para probarlo conectado se necesita un cable USB-C y una fuente USB de 5 V (un cargador de teléfono con salida de 5 V o un puerto USB apto); no hace falta comprar una batería. Conviene comprobar el cable y la fuente disponibles antes de añadirlos al pedido. El producto solo incluye la unidad Atom según la ficha del fabricante.

Para una primera prueba portátil, se puede conectarlo por USB-C a una **batería externa comercial** con salida USB de 5 V y cable corto. Una [batería HOCO J115 de 5000 mAh en tienda chilena](https://tienda.pcbeach.cl/product/mini-size-power-bank-ultraslim-5000mah-hoco) figuraba a $14.990, pero su ficha no certifica que la salida permanezca encendida con la carga baja del Atom; [Anker explica](https://service.anker.com/ca/article-description/What-is-Trickle-Charging-Mode) por qué algunos bancos de energía necesitan un modo especial de baja corriente para evitar el apagado automático. **No comprar ese modelo solo por la capacidad anunciada** antes de ensayar su salida continua, dimensiones y disponibilidad local. Este montaje permite medir autonomía sin manipular celdas de litio, aunque suma un segundo objeto y no representa el volumen final.

## La base oficial de 200 mAh no resuelve una jornada larga

La [Atomic Battery Base A151](https://docs.m5stack.com/en/atom/Atomic%20Battery%20Base) integra batería recargable de **200 mAh** y entrega 5 V con corriente máxima declarada de **300 mA**. Su cuerpo mide 24 × 24 × 23,93 mm; apilado con el Atom, el conjunto sería aproximadamente 24 × 24 × 41 mm antes de considerar holguras, pero **no es plug and play** con C008-C. M5Stack indica expresamente que para Atom Voice/Echo debe **cortarse la conexión G33**, utilizada por el audio. En esta combinación no se puede leer el voltaje de batería desde el Atom mediante la base. Además, la base debe ponerse manualmente en posición **OFF para cargar** a través del USB del Atom; no carga y alimenta al objeto al mismo tiempo según la guía. Queda por medir si los picos simultáneos de Wi-Fi y sonido caben dentro de esos 300 mA.

No se recomienda comprar A151 para Relevo en esta etapa: añade modificación física, un paso manual de carga poco cómodo para participantes y una capacidad demasiado pequeña para prometer una jornada conectada. La oferta oficial de [US$5,95 antes de envío](https://shop.m5stack.com/products/atomic-battery-base-200mah) no cambia esos límites. **No conectar el módulo sin resolver G33 conforme a la instrucción del fabricante**.

## Cálculo de capacidad, sin prometer horas

No existe una medición publicada del conjunto Atom Echo + firmware de Relevo + volumen de señal + patrón de red. La [hoja de datos de Espressif para ESP32-PICO](https://documentation.espressif.com/esp32-pico_series_datasheet_en.html) muestra que el consumo varía ampliamente entre sueño, recepción y transmisión Wi-Fi; esos valores corresponden al chip y **no** a toda la placa, altavoz y regulador. La relación para dimensionar una batería de 3,7 V es:

`horas ≈ (capacidad_mAh × 3,7 V × eficiencia) / (consumo_mA_a_5V × 5 V)`.

Como **escenario ilustrativo**, con 80 % de eficiencia y un consumo medio hipotético de 80 mA a 5 V:

| Batería | Energía utilizable aproximada | Horas calculadas, no medidas |
| --- | ---: | ---: |
| 200 mAh (A151) | 0,59 Wh | 1,5 h |
| 900 mAh (base Motion v1.2) | 2,66 Wh | 6,7 h |
| 1600 mAh | 4,74 Wh | 11,8 h |

Los números cambian con el firmware, ahorro de Wi-Fi, reconexiones, señal, volumen, temperatura y estado de la batería. **No son predicción de autonomía real** ni demuestran que 1600 mAh basten. Para las **8–12 h confirmadas** y respuesta casi inmediata, partir de una batería protegida de alrededor de **1500–2000 mAh** para diseño y medir el consumo promedio y los picos en el objeto real. Como referencia de tamaño físico, una [LiPo de 2000 mAh ofrecida por Hubot](https://hubot.cl/producto/bateria-recargable-lipo-3-7v-2000mah-sku-4064/) mide **50 × 34 × 10 mm**, y estaba **sin stock**; no es una compra propuesta ni se conecta directamente al USB del Atom. A ello deben sumarse carga, conversión eléctrica y carcasa. La capacidad comercial de una batería externa no se traduce íntegramente en energía de salida a 5 V. Si se permite revisar eventos con intervalos más largos, se puede dormir entre consultas y ahorrar energía, pero aumenta la demora del aviso. BLE con el teléfono cercano puede reducir la dependencia de Wi-Fi, a costa de gestionar conexión y reconexión.

## ¿Hay una base mayor ya hecha?

La [Atomic Motion Base v1.2 A090-V12](https://docs.m5stack.com/en/atom/Atomic_Motion_Base_v1.2) incluye celda recargable de 900 mAh, carga y protección, y acepta controladores Atom en general. Mide **75,4 × 24 × 20,7 mm** sin sumar la altura del Atom; integra controladores de motores que Relevo no necesita. La tienda oficial la listaba a [US$8,50 antes de envío](https://shop.m5stack.com/products/atomic-motion-base-v1-2-with-power-monitor). No se identificó prueba oficial específica de audio con C008-C apilado, ni stock/precio final en Chile. Es un posible banco de experimentación, pero ocupa más espacio y 900 mAh tampoco demuestra 8–12 h. No comprarla como solución final sin ensayo de compatibilidad y duración.

El [M5StickS3 K150](https://docs.m5stack.com/en/core/StickS3) ya integra batería recargable y altavoz en 48 × 24 × 15 mm, pero su batería es de **250 mAh**. Por sí mismo tampoco acredita una jornada larga en Wi-Fi. El fabricante advierte que a batería conviene mantener el volumen bajo 75 % para evitar reinicios.

## ¿Sirve como producto final?

**Como demostrador funcional o pequeño piloto, sí puede ser el núcleo físico.** Permite probar si la señal, el tamaño y el comportamiento ayudan a la experiencia. Para un producto portátil final con recarga sencilla y autonomía de una jornada, el Atom Echo por sí solo **no cumple el requisito energético**. Una fuente externa aumenta volumen y piezas; la A151 es pequeña pero insuficiente y exige cortar un pin; la Motion Base es mayor y contiene funciones sobrantes.

También importa la continuidad de componentes: el Atom Echo usa **ESP32-PICO-D4**, y [Espressif lo marca «Not Recommended for New Designs»](https://documentation.espressif.com/esp32-pico_series_datasheet_en.html). Eso no impide una prueba con unidades existentes, pero desaconseja fijarlo como componente inamovible para una producción nueva. La decisión de producto final debería tomarse después de medir: consumo y picos, autonomía, carga, volumen, temperatura de la batería, conexión/reconexión, tamaño del conjunto completo y facilidad de uso. Si el requisito de 8–12 h se confirma, evaluar una electrónica más reciente con batería protegida de la capacidad medida y una carcasa común, manteniendo como referencia el comportamiento validado con Atom Echo.

## Próxima prueba que evita compras equivocadas

1. Alimentar un Atom Echo con USB 5 V; registrar corriente media y picos con Wi-Fi conectado en espera, recepción de orden y reproducción del tono.
2. Probar con una batería externa ya disponible y verificar que no corte la salida durante al menos una jornada; registrar horas hasta fallo y reconexiones.
3. Solo después dimensionar una batería recargable integrada y decidir si el volumen resultante cumple el objetivo de compactación.

Esta evaluación sustituye la lectura de «Atom Echo compacto» como «producto portátil final compacto»: la dimensión relevante es **Atom + batería + carga + carcasa**, no solo la placa.
