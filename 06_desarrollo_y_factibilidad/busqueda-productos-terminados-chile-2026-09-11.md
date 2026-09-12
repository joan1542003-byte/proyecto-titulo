# Productos terminados disponibles en Chile para el primer prototipo físico

**Fecha de revisión:** 11 de septiembre de 2026  
**Estado:** investigación de compra; compatibilidad física pendiente de comprobar  
**Pregunta:** ¿es posible construir el primer prototipo de Relevo a partir de un producto terminado, evitando una placa de desarrollo?

## Respuesta breve

Sí, pero con una condición importante. La alternativa local más cercana es un **iTag Bluetooth Low Energy clásico**: es pequeño, económico, funciona con una pila reemplazable y puede recibir desde Android una orden para hacer sonar su zumbador. Esa posibilidad no depende necesariamente de la aplicación del vendedor, porque varios iTag implementan el servicio estándar *Immediate Alert* de Bluetooth.

No se encontró en el comercio chileno un producto terminado que, además de cumplir lo anterior, garantice por documentación el control independiente de una luz desde una aplicación propia. Algunos iTag incorporan un indicador luminoso, pero la publicación comercial no permite saber si responde a la misma orden que el sonido. Los parlantes compactos con RGB reúnen sonido y luz, aunque la aplicación solo controla directamente el audio: la iluminación suele seguir la música o un modo elegido con botones físicos. Tampoco está asegurado que permanezcan conectados durante una espera prolongada.

Por lo tanto, la compra responsable no consiste en elegir un supuesto AirTag universal. Consiste en adquirir **dos iTag clásicos de vendedores distintos**, inspeccionar sus servicios Bluetooth y conservar únicamente la unidad que supere la prueba técnica. Un parlante compacto puede respaldar una demostración de comportamiento, pero no debe presentarse como arquitectura final.

## Requisitos de búsqueda

La comparación utilizó siete condiciones. Las tres primeras son excluyentes.

1. La aplicación de Relevo debe poder enviar la orden sin depender, durante el uso, de Apple Find My, Google Find Hub, SmartThings, iSearching u otra aplicación de terceros.
2. El dispositivo debe producir sonido cuando recibe la orden.
3. La comunicación debe estar documentada mediante un estándar público, un SDK o una implementación abierta verificable.
4. Se valora que la misma orden produzca luz, sin darlo por cumplido cuando la publicación solo menciona un LED de estado.
5. Debe ser pequeño, transportable y ubicable junto al primer paso de una actividad.
6. Debe usar batería reemplazable o recargable.
7. La publicación debe permitir compra y despacho en Chile al momento de la consulta.

Se revisaron Mercado Libre Chile, Kyrios, Falabella, Ripley, Sodimac, SP Digital, Casa Royal y comercios especializados encontrados mediante búsqueda nacional. “Disponible” significa que la página informaba unidades, mostraba stock o mantenía habilitada la compra durante la revisión. No garantiza que el inventario continúe cuando se realice el pago; debe comprobarse nuevamente en el carrito.

## Por qué un iTag clásico puede funcionar con Relevo

Bluetooth Low Energy, o BLE, es una modalidad de Bluetooth diseñada para intercambiar pequeñas cantidades de datos con bajo consumo. En este sistema, el teléfono actúa como cliente y consulta los servicios que ofrece el objeto. El **Perfil de Atributos Genéricos**, conocido como GATT, organiza esos servicios y los valores que pueden leerse o escribirse.

Bluetooth SIG define el servicio **Immediate Alert** con el identificador `0x1802` y la característica **Alert Level** con el identificador `0x2A06`. Al escribir `0x00`, el objeto queda sin alerta; `0x01` solicita una alerta leve y `0x02`, la alerta más intensa disponible. La acción concreta depende del fabricante y puede consistir en sonido, luz u otro comportamiento. La especificación exige la escritura sin respuesta, pero no obliga a que todos los objetos usen el mismo canal perceptivo ([Bluetooth SIG, 2011](https://www.bluetooth.com/wp-content/uploads/Files/Specification/HTML/IAS_v1.0/out/en/index-en.html); [Bluetooth SIG, 2023](https://www.bluetooth.com/wp-content/uploads/Files/Specification/HTML/Assigned_Numbers/out/en/index-en.html)).

La implementación abierta [iTag MQTT Bridge](https://github.com/tomasgatial/itag-mqtt-bridge) documenta en unidades iTag económicas el servicio `0x1802`, la característica `0x2A06` y los tres valores de alerta. [iTag One](https://github.com/s4ysolutions/itag), aplicación Android de código abierto y actualizada en 2026, demuestra que un teléfono puede hacer sonar estos dispositivos sin limitarse al software incluido por el vendedor. [iTracing2](https://github.com/sylvek/itracing2) confirma la compatibilidad con el perfil de proximidad, pero advierte que existen clones construidos con componentes y comportamientos diferentes. Esa variación impide afirmar compatibilidad a partir de una fotografía o del nombre iTag.

Android proporciona soporte nativo para BLE, descubrimiento de servicios y escritura de características. En Android 12 o posterior, la aplicación debe solicitar permisos de exploración y conexión; además, una comunicación prolongada en segundo plano requiere administrar el ciclo de vida mediante las opciones documentadas para dispositivos asociados o servicios en primer plano ([Android Developers, 2026a](https://developer.android.com/develop/connectivity/bluetooth/ble/ble-overview), [2026b](https://developer.android.com/reference/android/bluetooth/BluetoothGatt), [2026c](https://developer.android.com/develop/connectivity/bluetooth/ble/background)). Esto hace técnicamente posible una integración propia, pero no elimina la obligación de probar reconexión, consumo y diferencias entre teléfonos.

## Compra recomendada

### 1. Muestra principal: iTag NEWOTAG de Netexpertos

- [Publicación en Mercado Libre Chile](https://www.mercadolibre.cl/localizador-rastreador-itag-bluetooth-con-llavero-android/up/MLCU381331275)
- Precio observado: **CLP 7.990**.
- Disponibilidad observada: **más de 25 unidades**; compra limitada a dos por operación.
- Forma declarada: aproximadamente 30 mm de diámetro.
- Alimentación: pila reemplazable CR2032.
- Vendedor: tienda oficial Netexpertos, más de 5.000 ventas, seis meses de garantía y despacho nacional.
- Razón de prioridad: combina stock, devolución, garantía y una forma cercana a la escala buscada.
- Incertidumbre: la publicación no identifica el conjunto de servicios GATT ni el fabricante del circuito.

### 2. Muestra de contraste: iTag para iTracing de petsandtools

- [Publicación en Mercado Libre Chile](https://www.mercadolibre.cl/llavero-rastreador-con-gps-anti-perdida-conexion-bluetooth/up/MLCU10739395)
- Precio observado: **CLP 5.990**.
- Disponibilidad observada: **más de cinco unidades**.
- Forma declarada: 50 × 30 × 5 mm; 25 g y pila CR2032 incluida.
- Vendedor: petsandtools, MercadoLíder Gold con más de 1.000 ventas, devolución dentro de 30 días y sin garantía propia.
- Razón de prioridad: la publicación identifica expresamente la aplicación iTracing y la familia BLE 4.0 estudiada por implementaciones abiertas. Es una muestra distinta del NEWOTAG y, por ello, mejora la comparación entre partidas.
- Incertidumbre: la compatibilidad con iTracing orienta la inspección, pero no prueba por sí sola que esta unidad exponga `0x1802/0x2A06`.

### 3. Alternativa con garantía: iTag de Kyrios

- [Publicación en Kyrios](https://kyrios.cl/products/itag-smart-wireless-bluetooth-v4-0-tracker-finder-key-anti-lost-alarm-locator-tracker-negro)
- Precio observado: **CLP 12.990**.
- Disponibilidad observada: botones de compra activos, sin conteo público.
- Condiciones: Bluetooth 4.0, CR2032, envío a todo Chile y seis meses de garantía.
- Razón de inclusión: es la opción más respaldada por un comercio local fuera de un mercado abierto.
- Incertidumbre: no informa modelo del chip ni servicios GATT; cuesta casi el doble de las muestras anteriores.

### Decisión de compra

Comprar las opciones 1 y 2. El costo conjunto observado es **CLP 13.980**, antes del envío. Comprar dos unidades no busca duplicar el prototipo: reduce el riesgo de que una sola partida corresponda a un clon incompatible. Kyrios queda como reemplazo si la segunda publicación se agota.

No conviene comprar todavía un SmartTag2, Moto Tag, AirTag, UGREEN FineTrack, Hoco E101 u otro rastreador conectado a una red de localización. Aunque puedan emitir sonido, sus recorridos oficiales dependen de SmartThings, Find Hub o Find My y no ofrecen una interfaz pública que permita a Relevo gobernar la alerta desde su propia aplicación.

## Respaldo para demostrar comportamiento

Si ambos iTag fallan, o si se necesita demostrar de inmediato una secuencia sonora exacta, la alternativa más simple es un parlante Bluetooth. Una aplicación Android puede reproducir un archivo de tres pulsos por la salida de audio emparejada. Esta ruta controla bien el sonido, pero no resuelve por sí sola la luz ni la espera prolongada.

| Prioridad | Producto | Precio y disponibilidad observados | Tamaño declarado | Qué permite | Límite para Relevo |
| ---: | --- | --- | --- | --- | --- |
| 1 | [Mini parlante 240123](https://www.mercadolibre.cl/mini-parlante-bluetooth-recargable-usb-portatil-speaker-color-negro-240123/p/MLC41809681?pdp_filters=seller_id%3A494294258) | CLP 4.990; dos opciones de compra | 48,5 × 48,5 × 33 mm | Reproducir desde la app un sonido exacto; batería recargable, 4,3/5 en 74 evaluaciones | No tiene luz |
| 2 | [L59 con luz de respiración](https://www.mercadolibre.cl/mini-parlante-bluetooth-portatil-recargable-rgb-l59-color-negro/p/MLC29485049) | CLP 4.999; más de 50 unidades | 64 × 79 mm | Sonido desde la app y luz integrada | La luz no está documentada como controlable ni sincronizada; el volumen es mayor que el deseado |
| 3 | [M Casa T11](https://articulo.mercadolibre.cl/MLC-1573094633-mini-parlante-bluetooth-rgb-fidget-spinner-diferente-colores-_JM) | CLP 12.990; más de 50 unidades | No publicado de forma confiable | Sonido desde Android y RGB que sigue la música | Forma llamativa, luz no independiente y tiempo de espera sin comprobar |
| 4 | [Vidvie SP922](https://www.mercadolibre.cl/parlante-portatil-vidvie-sp922-bluetooth-inalambrico-con-radio-y-luces-led/p/MLC29490104) | Más de cinco unidades; opciones desde CLP 6.980 | 79 × 67 × 79 mm | USB-C, sonido y luces que cambian con la música | Demasiado grande para la dirección compacta; 211 g |
| 5 | [Practiled LWM-5B](https://www.mercadolibre.cl/mini-parlante-practiled-bluetooth-magnetico-iman-portatil-luces-rgb-funcion-tws-color-negro/p/MLC51903202) | CLP 21.990; más de cinco unidades | 63 × 55 × 63 mm | Sonido, seis modos de luz, USB-C y fijación magnética | La luz se elige con controles propios; autonomía declarada de 2 h 16 min con luces |

Para una prueba breve, el T11 o el SP922 podrían convertir la amplitud del sonido en una respuesta luminosa sin fabricar electrónica. Se debe comprobar con el audio específico de Relevo: una frase como “luces al ritmo de la música” no garantiza que tres tonos breves produzcan tres destellos perceptibles. Tampoco permite seleccionar el blanco cálido definido en la especificación vigente. Por estas razones son materiales de respaldo, no sustitutos automáticos del testigo.

## Productos y familias descartados

La tabla conserva las opciones revisadas para evitar repetir búsquedas o confundir disponibilidad comercial con apertura técnica.

| Producto o familia | Situación observada | Decisión | Motivo principal |
| --- | --- | --- | --- |
| [iTag OEM-AP008/Loc08R](https://www.mercadolibre.cl/llavero-localizador-bluetooth-anti-perdida-multiples-usos/up/MLCU81914652) | Última unidad, CLP 6.190; vendedor local con más de 10.000 ventas | No priorizar | La descripción coincide con la familia clásica, pero la evaluación disponible informa una falla grave y la publicación no ofrece garantía propia |
| [iTag Riva/BT2005CL](https://www.mercadolibre.cl/llavero-localizador-bluetooth-itag-llaves-o-celular-color-negro/p/MLC41989702) | Unidades disponibles y precio cercano a CLP 6.640 | Respaldo distante | Evaluaciones informan desconexiones y fallos de detección; protocolo sin identificar |
| [Mini iTag VILORIAOROZCO](https://www.mercadolibre.cl/mini-llavero-rastreador-itag-localizador-bluetooh-negro/p/MLC32345367) | Tres unidades, CLP 5.120 | No comprar | 3,1/5; hay opiniones sobre imposibilidad de sincronizar y deterioro de la tapa |
| [Samsung Galaxy SmartTag2](https://www.samsung.com/us/mobile-accessories/galaxy-smarttag2-black-ei-t5600bbegus/) | Disponible en el mercado chileno | Descartado | Samsung exige equipo Galaxy, cuenta Samsung y SmartThings Find |
| [Moto Tag](https://en-us.support.motorola.com/app/answers/detail/a_id/180790/~/moto-tag-app) | Disponible en Chile según publicaciones revisadas | Descartado | La alerta se administra con Moto Tag y la localización con Google Find Hub; no hay API de alerta pública |
| [UGREEN FineTrack G](https://www.ugreen.com/en-au/products/au-65543p) | Disponible en Chile según publicaciones revisadas | Descartado | El fabricante lo integra con Google Find Hub |
| [Hoco E101](https://www.mercadolibre.cl/localizador-de-objetos-hoco-e101-color-negro/p/MLC75178434) | Más de diez unidades en la revisión | Descartado | Publicación orientada a Find Hub o Find My; control propio no documentado |
| [Hoco E98A](https://www.mercadolibre.cl/dispositivo-anti-perdida-hoco-e98a-loshall-ring-gps-android-negro/p/MLC64891284) | Pocas unidades en la revisión | Descartado | Depende de Google Find Hub |
| [Tile Mate](https://www.mercadolibre.cl/localizador-de-llaves-tile-mate-rango-de-250-pies-negro-color-negro/p/MLC29012781) | Publicación no disponible | Descartado | Sin stock y protocolo protegido por credenciales del fabricante |
| Baseus T2/T2 Pro | Publicaciones variables | Descartado | Aplicación y cuenta propietarias; no se encontró protocolo público de alarma |
| Nut Mini | Sin oferta local fiable | Descartado | La integración depende de autenticación propietaria y presenta problemas documentados de compatibilidad |
| [Parlante Alaxe RGB](https://www.mercadolibre.cl/parlante-bluetooth-mini-alaxe-rgb-color-negro/p/MLC74279021) | Cinco unidades, CLP 17.990 | No priorizar | Dimensiones no publicadas y luz sin control documentado |
| [Parlante Prosound RGB](https://articulo.mercadolibre.cl/MLC-2866630712-parlante-mini-bluetooth-luz-rgb-6w-usb-fm-prosound-recargabl-_JM) | Tres unidades, CLP 5.584 | No priorizar | Dimensiones y respuesta luminosa sin documentar |
| [Parlante TYG RGBL](https://www.mercadolibre.cl/mini-parlante-rgb-bluetooth-50-usb-portatil-stereo-radio-fm/up/MLCU58000851) | Última unidad, CLP 8.540 | No priorizar | Más funciones que las necesarias y sin dimensiones fiables |
| [Parlante genérico RGB de SP Digital](https://www.spdigital.cl/bluetooth-speaker/) | Stock en línea, CLP 17.990 | No priorizar | Sin medidas ni control de la luz documentados |
| [AUDIOPRO magnético](https://www.sodimac.cl/sodimac-cl/articulo/151337588/parlante-mini-bluetooth-rgb-5w-magnetico-usb-c-sc) | Compra activa, CLP 13.490; stock depende de la ubicación | Respaldo distante | 300 mAh, dos horas y luz no gobernada por la app |
| [Motomo ILLUM](https://www.spdigital.cl/categories/audio-y-musica-audio-parlante-portatil/) | Stock en tienda, CLP 12.990 por transferencia | No priorizar | No publica tamaño ni relación entre sonido y luz |
| [Parlante RGB de Fernapet](https://www.fernapet.cl/mini-parlante-bluetooth-impermeable-ipx6--5w--luz-led-rgb/p) | Compra activa, CLP 5.750 | Descartado | 106 × 70 × 106 mm; excede ampliamente la escala buscada |
| [Parlante RGB con fidget de Ripley](https://simple.ripley.cl/parlante-bluetooth-mini-rgb-con-fidget-spinner-portatil-mpm10003025871) | Compra activa, CLP 38.990 | Descartado | Precio elevado y una forma que añade una interacción ajena a Relevo |
| [Parlante de rueda Click Ventas](https://simple.ripley.cl/mini-altavoz-bluetooth-portatil-forma-de-rueda-rgb-altavoz-mpm10001472948) | Compra activa, CLP 15.490 | No priorizar | Luz reactiva, pero dimensiones y espera sin comprobar |
| [Parlante MK-102](https://simple.ripley.cl/mini-parlante-click-ventas-portatil-5w-luz-rgb-mk-102-speaker-mpm10001720258) | Compra activa en la revisión | Descartado | Aproximadamente 150 × 80 × 70 mm; demasiado grande |
| [Parlante Master-G MGSPLASH](https://www.casaroyal.cl/master-g-parlante-portable-225-mgsplash-con-bluetooth-5-4--/p) | Compra activa, CLP 9.990 | Descartado | Formato de parlante convencional, mayor que un testigo transportable |
| [KBeacon B2](https://www.beaconzone.co.uk/KKM/B2Button) | Stock extranjero; sin venta local encontrada | Referente técnico | Es el mejor ajuste funcional: 50 × 50 × 18 mm, CR2032, zumbador y SDK Android; no cumple el requisito de compra nacional |

El KBeacon B2 demuestra que la combinación buscada existe en el mercado profesional. Su [SDK Android](https://github.com/kkmhogen/KBeaconDemo_Android/blob/master/README.md) permite ordenar sonido o destello y fijar tiempos de encendido y apagado. Su ausencia en Chile explica el vacío encontrado entre rastreadores cerrados y parlantes de consumo, pero no justifica atribuir esas capacidades a un iTag genérico.

## Prueba de aceptación al recibir los iTag

La primera revisión no necesita una aplicación de Relevo terminada. Puede utilizarse nRF Connect u otro explorador GATT únicamente como instrumento de diagnóstico; esa herramienta no formará parte del uso posterior.

1. Asignar un código físico a cada unidad y fotografiar envase, frente, reverso y compartimento de batería.
2. Encenderla y registrar el nombre con que aparece en BLE. Los nombres `iTag`, `PROXPR` o similares son orientativos, no una aprobación.
3. Conectar, descubrir servicios y buscar `00001802-0000-1000-8000-00805f9b34fb`.
4. Dentro del servicio, confirmar que `00002a06-0000-1000-8000-00805f9b34fb` admite escritura sin respuesta.
5. Escribir `02` y registrar sonido, luz, duración y posibilidad de detenerlo con `00`.
6. Si responde, escribir `01` y comparar el patrón. No repetir órdenes durante más tiempo que el necesario para observar el comportamiento.
7. Comprobar cinco conexiones desde reposo, cinco reconexiones tras apagar y encender el objeto y diez activaciones consecutivas.
8. Repetir después de 5 y 30 minutos con la pantalla del teléfono apagada. Registrar si la unidad sigue anunciándose, se apaga o exige pulsar su botón.
9. Medir el tiempo entre orden y comienzo de la alerta. No reemplazar fallos por un promedio.
10. Observar si el botón físico detiene la alerta en menos de un segundo. Si no lo hace, la unidad no cumple el silenciamiento local previsto.

### Resultado posible

- **Aprobación técnica parcial:** la unidad expone `0x1802/0x2A06`, suena de forma repetible y reconecta. Puede emplearse para desarrollar el vínculo Android–objeto y probar la señal sonora.
- **Aprobación técnica completa para la fase A:** además produce una luz perceptible gobernable con la secuencia requerida, permite silencio local y supera la ficha técnica vigente. Este resultado no puede anticiparse.
- **Rechazo:** no expone el servicio, se apaga durante la espera, no reconecta, produce activaciones espontáneas o no admite detener la señal. Se conserva el registro y se solicita devolución dentro del plazo.

## Consecuencia para el desarrollo

La aplicación de Relevo no debe copiar el código de una aplicación abierta sin revisar su licencia. El camino más limpio es implementar la operación mínima con las APIs de Android y la especificación pública de Bluetooth: asociación, descubrimiento del servicio, escritura del nivel de alerta y recuperación de conexión. Los repositorios iTag One e iTracing2 pueden estudiarse como antecedentes; sus licencias GPL-3.0 y GPL-2.0 obligan a evaluar las condiciones si se reutiliza código.

La prueba con iTag se ubica antes del banco micro:bit. Si una de las muestras aprueba, evita fabricar el enlace sonoro y reduce el trabajo a la aplicación y al comportamiento del objeto disponible. Si ninguna aprueba, la evidencia justifica volver a una plataforma programable o importar un beacon con SDK; no sería una preferencia arbitraria por electrónica propia.

## Referencias

- Android Developers. (2026a). *Bluetooth Low Energy overview*. https://developer.android.com/develop/connectivity/bluetooth/ble/ble-overview
- Android Developers. (2026b). *BluetoothGatt*. https://developer.android.com/reference/android/bluetooth/BluetoothGatt
- Android Developers. (2026c). *Communicate in the background*. https://developer.android.com/develop/connectivity/bluetooth/ble/background
- Android Developers. (2026d). *Bluetooth permissions*. https://developer.android.com/develop/connectivity/bluetooth/bt-permissions
- Bluetooth Special Interest Group. (2011). *Immediate Alert Service 1.0*. https://www.bluetooth.com/wp-content/uploads/Files/Specification/HTML/IAS_v1.0/out/en/index-en.html
- Bluetooth Special Interest Group. (2023). *Assigned numbers*. https://www.bluetooth.com/wp-content/uploads/Files/Specification/HTML/Assigned_Numbers/out/en/index-en.html
- Gatial, T. (s. f.). *iTag MQTT Bridge* [Repositorio de código]. GitHub. https://github.com/tomasgatial/itag-mqtt-bridge
- KKM. (s. f.). *KBeacon Android SDK demo* [Repositorio de código]. GitHub. https://github.com/kkmhogen/KBeaconDemo_Android
- S4Y Solutions. (2026). *iTag One* [Repositorio de código]. GitHub. https://github.com/s4ysolutions/itag
- Sylvek. (s. f.). *iTracing2* [Repositorio de código]. GitHub. https://github.com/sylvek/itracing2

---

## Registro de cambios (disclaimer)

### 2026-09-11 — Verificación de la segunda muestra

- **Cambio:** se reemplazó una publicación con dos unidades por un iTag identificado para iTracing, con más de cinco unidades y un vendedor MercadoLíder Gold; el costo conjunto bajó de CLP 14.920 a CLP 13.980.
- **Versión anterior:** la segunda muestra correspondía a un OEM-AP008 con menor stock y menor respaldo comercial.
- **Motivo:** priorizar una compra disponible en Chile que conserve diversidad de partida y ofrezca una señal técnica más clara sobre la familia BLE que se debe inspeccionar.
- **Alcance:** la mención de iTracing sigue sin demostrar el perfil GATT; la compra continúa condicionada a la prueba física descrita en este documento.

### 2026-09-11 — Creación

- **Cambio:** se realizó una búsqueda nacional de productos terminados, se separó disponibilidad comercial de control técnico y se definió una compra de dos muestras iTag con prueba de aceptación.
- **Cómo estaba antes:** la ruta vigente comenzaba con micro:bit V2 y los rastreadores se trataban principalmente como referentes formales; no existía una comparación de publicaciones chilenas con protocolos abiertos.
- **Por qué se decidió:** reducir fabricación y costo sin depender de una aplicación ajena ni presentar como compatible un producto cerrado.
- **Alcance:** precios y stock corresponden a la consulta del 11 de septiembre de 2026. No se compró ni ensayó hardware y no se afirma control luminoso hasta inspeccionar las unidades.
