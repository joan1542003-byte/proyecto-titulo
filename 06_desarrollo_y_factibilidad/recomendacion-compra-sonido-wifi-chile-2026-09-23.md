# Compra económica de un objeto sonoro para Relevo

**Revisión:** 23 de septiembre de 2026. Investigación documental y de mercado, sin compra ni prueba física. Precios en CLP observados sin ingresar una comuna ni llegar al pago; el total exigible puede cambiar.

**Actualización sobre portabilidad:** si debe ser recargable y durar una jornada sin cable, esta recomendación de Atom Echo solo cubre el **núcleo de prueba**. Véase el [análisis de energía y autonomía](energia-autonomia-atom-echo-2026-09-23.md): una solución de 200 mAh exige modificar un pin y no permite prometer horas suficientes; el tamaño final debe incluir batería y cargador.

## Decisión para una sola unidad

**Candidato de mejor relación entre formato, función y precio: M5Stack Atom Echo C008-C.** Integra carcasa, Wi-Fi de 2,4 GHz, BLE y altavoz en 24 × 24 × 17 mm. La [ficha oficial](https://docs.m5stack.com/en/atom/atomecho) permite programarlo para recibir una orden y reproducir un tono local. No incluye batería: requiere alimentación USB-C permanente o una batería externa USB. El altavoz pequeño sirve para una señal breve en una habitación; su volumen y agrado para participantes aún deben medirse.

La [ficha de Mouser Chile](https://www.mouser.cl/es/ProductDetail/M5Stack/C008-C?qs=sGAEpiMZZMvI685ayE5Sa5PAHlHatIkcoQyhSSALZFsX0Dw9wIn2fg%3D%3D) identifica fabricante y SKU con claridad y muestra **$14.198** y existencias del distribuidor. Ese **no es el costo puesto en casa**: envío, impuestos y aduana deben consultarse antes de pagar. Conviene comprar allí si el total final de una unidad, cable/fuente que no se tengan incluidos, queda bajo unos **$35.000**. Este umbral es una regla presupuestaria para comparar, no una cotización.

La [publicación internacional de Mercado Libre que declara C008-C](https://www.mercadolibre.cl/modulo-de-control-de-voz-esp32-programable-atom-echo-m5stack/p/MLC2092578684) mostró en navegación directa **$29.517 + $5.609 de impuestos estimados = $35.126**, envío gratis desde China y stock. Es una segunda vía si Mouser supera ese total; presenta riesgo mayor: el título dice M5Stack, la ficha dice modelo «Generic», la descripción nombra «FMai» y el vendedor exhibe cuatro ventas. Antes de pagar, confirmar en la oferta elegida que se entregará el **M5Stack original C008-C**, el total final y la política de devolución. La protección de compra no acredita por sí sola la autenticidad.

**No comprar el Atom Echo pensando que se enlazará al APK actual:** el APK todavía no le envía órdenes. El software de fábrica permite uso como parlante Bluetooth, pero ese modo puede reproducir audio de otras apps. La exclusividad que busca Relevo exige firmware de comandos en el objeto y una futura integración Android o Wi-Fi. Si el dispositivo consulta Supabase, hará falta además diseñar autenticación, permisos y entrega fiable de eventos; [análisis de arquitectura](comparacion-ble-wifi-supabase-dispositivo-2026-09-23.md).

## Comparación de dinero y conveniencia

| Alternativa | Precio visto | Qué se recibe | Veredicto económico |
| --- | ---: | --- | --- |
| [ESP32-C3 + buzzer Pinout](https://pinout.cl/producto/kit-esp32-c3-supermini-con-pantalla-lcd-1602-i2c-y-buzzer) | **$9.990** más despacho | Placa Wi-Fi/BLE, buzzer pasivo, pantalla y cables; sin USB-C, batería ni caja. Stock indicado en tienda chilena. | Menor desembolso para probar comunicación y pitido en mesa, pero implica cablear y el sonido será un buzzer. No es el objeto ya armado pedido para participantes. |
| [Atom Echo C008-C, Mouser](https://www.mouser.cl/es/ProductDetail/M5Stack/C008-C?qs=sGAEpiMZZMvI685ayE5Sa5PAHlHatIkcoQyhSSALZFsX0Dw9wIn2fg%3D%3D) | **$14.198** antes de envío e importación | Carcasa y altavoz integrados; sin batería interna. | Mejor candidato si el carrito total es competitivo. Precio publicado no basta para llamarlo la opción más barata entregada. |
| [Atom Echo, Mercado Libre](https://www.mercadolibre.cl/modulo-de-control-de-voz-esp32-programable-atom-echo-m5stack/p/MLC2092578684) | **$35.126 estimados** con impuesto mostrado y envío gratis | Publicación internacional del supuesto C008-C. | Techo de comparación práctico; verificar SKU y vendedor por ficha inconsistente. |
| [micro:bit V2 GO, MCI](https://mcielectronics.cl/shop/product/bbc-microbit-v2-go-kit-de-inicio/) | **$36.990** más despacho si corresponde | Placa BLE con altavoz, portapilas, dos AAA y cable; tienda chilena. | Más claro para un primer ensayo BLE y con programa de mesa en el repositorio, pero más grande, consume pilas y no tiene Wi-Fi. |
| [M5StickS3, Mercado Libre](https://www.mercadolibre.cl/kit-de-desarrollo-iot-m5stack-m5sticks3-esp32-s3-pantalla/p/MLC2080263766) | **$40.290 + $7.660 de impuestos estimados = $47.950** | Wi-Fi, BLE, carcasa, altavoz y batería recargable de 250 mAh según [fabricante](https://docs.m5stack.com/en/core/StickS3). | Pagar la diferencia solo si la batería integrada es esencial. El vendedor seleccionado tenía cuatro ventas; la autonomía con conexión Wi-Fi continua no está acreditada. |

Una [otra publicación de Mercado Libre presentada en resultados como Atom Echo](https://www.mercadolibre.cl/altavoz-inteligente-programable-para-atom-con-esp32-incorpor/p/MLC2039361558) redirigió, al abrirla, a un producto «Generic» de $25.000 con $4.749 de impuestos estimados. Su tabla marcaba **Wi-Fi: No**, aunque el texto de descripción afirmaba lo contrario. Se excluye de la recomendación: el resultado indexado era obsoleto y la ficha viva no identifica de forma fiable el C008-C.

## Regla para cuidar el presupuesto

1. Si se probará únicamente el flujo de señal en una mesa y se acepta cableado, comprar **solo el kit Pinout de $9.990**; no comprar a la vez un altavoz Bluetooth ni una placa adicional.
2. Si se necesita un objeto compacto, ya encerrado, con sonido propio y opción Wi-Fi, elegir **un Atom Echo C008-C**. Mirar primero el total final de Mouser, incluidos envío, tributos y alimentación; compararlo con los **$35.126 estimados** de la publicación internacional. Si el total no es claro, no tratar el precio base como oferta mejor.
3. Si debe operar sin enchufe o batería USB externa, el Atom Echo deja de cumplir esa condición. Considerar StickS3, pero presupuestar su mayor costo y medir autonomía antes de usarlo con personas.
4. La compra no resuelve por sí sola la conexión con Relevo. Registrar como trabajo futuro la programación del dispositivo, la orden desde la app o servicio, la recuperación tras caída de red, la prueba de silencio frente a otras apps y la medición de volumen.

**Límite de la investigación:** se comprobó la información pública de vendedores y fabricantes, no se verificó un carrito completo con destino, la originalidad de una unidad recibida, su altavoz en el contexto real, ni la estabilidad del enlace. Las fichas de Mercado Libre pueden cambiar de oferta concreta para un mismo enlace.
