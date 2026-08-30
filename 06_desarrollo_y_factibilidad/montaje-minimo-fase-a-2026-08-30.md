# Montaje mínimo para el ensayo técnico de fase A

**Fecha de corte:** 30 de agosto de 2026

**Estado:** arquitectura provisional seleccionada; componentes no comprados y montaje no construido

**Función:** producir una señal luminosa estable para ejecutar la [ficha de ensayo técnico](../07_validacion/ficha-ensayo-tecnico-fase-a.md)

## Alcance de la decisión

Este montaje existe para comprobar el material antes de involucrar participantes. Debe emitir tres pulsos en 3 s ± 0,3 s, responder a una activación ubicada a tres metros, permitir silenciamiento físico y volver a reposo. No integra Android, Bluetooth, batería, forma final ni automatización.

La selección no define la electrónica de Relevo. Aísla las variables necesarias para la fase A y debe desmontarse, modificarse o descartarse cuando deje de servir a esa pregunta.

## Alternativas comparadas

Los subtotales corresponden a precios publicados por un comercio chileno y consultados en la fecha de corte. Incluyen controlador, luz, regulación, alimentación, conversión de voltaje, silenciamiento y montaje de protoboard. No incluyen cuerpo, difusor, envío, herramientas ni trabajo profesional.

| Alternativa | Activación | Ventaja para la prueba | Riesgo o variable añadida | Subtotal verificado | Decisión |
| --- | --- | --- | --- | ---: | --- |
| A | Pulsador conectado mediante 3 m de cable | Elimina fallos de radio y línea visual; permite repetir la orden de manera directa. | El cable puede interferir con el espacio o producir tropiezos si no se fija fuera del recorrido. | CLP 35.000 | Seleccionada para construir y ensayar. |
| B | Control y receptor infrarrojos | Separa al investigador sin tender un cable hasta el pulsador. | Depende de orientación, línea visual, receptor y luz ambiental. | CLP 35.840 | Reserva si el cable altera el ensayo. |
| C | Control y receptor de radio de 433 MHz | No exige línea visual. | Añade radio, consumo, emparejamiento y posibles activaciones no deseadas que la fase A no necesita estudiar. | CLP 42.730 | Descartada para fase A; no se infiere su pertinencia futura. |

La diferencia de precio no decide por sí sola. La alternativa A se selecciona porque introduce menos causas de fallo entre la orden del investigador y el patrón observado. El cable se fijará al perímetro del espacio y no cruzará el recorrido de la persona.

## Lista provisional de materiales — alternativa A

| Partida | Cantidad | Función | Precio publicado | Fuente y condición |
| --- | ---: | --- | ---: | --- |
| Arduino Nano V3.0 compatible, con cable | 1 | Ejecutar el patrón y controlar estados. | CLP 8.990 | [MechatronicStore](https://www.mechatronicstore.cl/arduino-nano-v3-0-atmega328-cable/); unidad publicada. Arduino documenta las capacidades generales de la [placa Nano](https://docs.arduino.cc/hardware/nano). |
| Tira LED rígida 5050, 12 V, blanca cálida | 1 m | Producir luz regulable; se utilizará solo el segmento necesario. | CLP 7.500 | [MechatronicStore](https://www.mechatronicstore.cl/tira-led-5050-rigida-1m-12v-blanco-calido-frio/); compra mínima publicada. |
| Módulo MOSFET para PWM, 5–36 V | 1 | Conmutar la tira desde una salida de control sin alimentarla desde el pin del microcontrolador. | CLP 1.590 | [MechatronicStore](https://www.mechatronicstore.cl/modulo-regulador-switch-pwm-circuitos-de-potencia-15a-400w-mosfet/). |
| Fuente comercial 12 V, 2 A | 1 | Alimentar la rama luminosa mediante una fuente cerrada. | CLP 4.490 | [MechatronicStore](https://www.mechatronicstore.cl/transformador-cargador-fuente-de-alimentacion-12v-2a/). |
| Convertidor reductor LM2596S | 1 | Entregar 5 V al controlador desde la fuente de 12 V. | CLP 1.990 | [MechatronicStore](https://www.mechatronicstore.cl/modulo-de-fuente-de-alimentacion-reductora-ajustable-lm2596s-dc-dc-1-25-30v/); su salida debe ajustarse y medirse antes de conectar la placa. |
| Interruptor de palanca estable | 1 | Interrumpir físicamente la rama luminosa para silenciar. | CLP 1.990 | [MechatronicStore](https://www.mechatronicstore.cl/interruptor-de-palanca-2-posiciones-2-pines-6a-250v/); se utiliza solo en baja tensión. |
| Cable de ocho conductores | 3 m | Separar el pulsador de activación del montaje. | CLP 1.470 | [MechatronicStore](https://www.mechatronicstore.cl/cable-apantallado-8-hilos-24awg-por-metro/); CLP 490 por metro. |
| Pulsador momentáneo | 1 | Iniciar la secuencia desde tres metros. | CLP 290 | [MechatronicStore](https://www.mechatronicstore.cl/boton-pulsador-switch-2-pines-6x6x7mm/). |
| Kit de protoboard, fuente y cables | 1 | Mantener el montaje modificable durante el ensayo. | CLP 6.690 | [MechatronicStore](https://www.mechatronicstore.cl/kit-protoboard-fuente-mb102-usb-set-de-cables/). La fuente incluida no sustituye la conversión medida para el conjunto. |
| **Subtotal electrónico** |  |  | **CLP 35.000** | Sin envío, cuerpo, difusor, herramientas ni fabricación. |
| **Subtotal con 15 % de contingencia** |  |  | **CLP 40.250** | Reserva de planificación; no es cotización ni costo final. |

La disponibilidad de una página no reserva stock. Precio, variante y existencia deben comprobarse nuevamente antes de comprar. El cuerpo y el difusor se resolverán con material reutilizable o una compra separada solo después de confirmar estabilidad, distribución de luz y ausencia de contacto con partes eléctricas.

## Arquitectura funcional del montaje

1. La fuente comercial entrega 12 V sin exponer alimentación de red.
2. Una rama alimenta la tira LED mediante el interruptor de silenciamiento y el módulo MOSFET.
3. Otra rama pasa por el convertidor reductor, cuya salida se ajusta y comprueba en 5 V antes de conectar el controlador.
4. El controlador envía la señal PWM al módulo MOSFET; la tira no se conecta directamente a un pin de la placa.
5. El pulsador de activación llega al controlador mediante el cable de tres metros.
6. Al encender o recuperar energía, el programa parte en reposo.
7. Una orden durante el patrón no genera otra secuencia ni acumula pulsos.
8. Abrir el interruptor de silenciamiento corta la salida luminosa y el controlador vuelve al estado de reposo.

Esta arquitectura es una especificación de prototipo. La conexión final debe ser revisada por una persona competente en electrónica antes de operar el montaje cerca de participantes.

## Secuencia de construcción y comprobación

1. Revisar visualmente fuente, cables, aislación y conectores sin energizar.
2. Ajustar el convertidor reductor y medir su salida antes de conectar el controlador.
3. Programar reposo inicial, secuencia única, duración, rechazo de órdenes acumuladas y retorno a reposo.
4. Comprobar la rama LED mediante el MOSFET y el interruptor de silenciamiento.
5. Instalar el pulsador a tres metros y fijar el cable fuera del recorrido.
6. Incorporar un cuerpo estable y un difusor temporal que oculte los puntos luminosos sin encerrar calor.
7. Identificar la versión del montaje y fotografiar conexiones antes de cerrar el cuerpo.
8. Ejecutar completa la ficha técnica. Un fallo o fila incompleta impide solicitar revisión para trabajar con participantes.

## Herramientas y recursos no incluidos en el subtotal

- multímetro para ajustar y comprobar tensión;
- cronómetro;
- material aislante y fijación del cable;
- herramientas de corte y conexión;
- cuerpo estable y difusor;
- revisión electrónica del montaje;
- reposición por piezas defectuosas;
- envío.

Si estas herramientas no están disponibles, el subtotal no representa el costo real de preparación.

## Riesgos y controles

| Riesgo | Control anterior a participantes |
| --- | --- |
| Tropiezo o alteración del espacio por el cable | Trazar el cable por el perímetro, fijarlo y excluirlo del recorrido. |
| Tensión incorrecta en el controlador | Medir 5 V en la salida del reductor antes de conectar la placa. |
| Sobrecarga de un pin | Controlar la tira mediante MOSFET y alimentación separada. |
| Contacto o daño de conductor | Utilizar fuente comercial cerrada, baja tensión, aislación y cuerpo que impida acceso. |
| Calor o comportamiento imprevisto | Interrumpir alimentación, registrar el incidente y repetir la serie después de corregir. |
| Pulso demasiado intenso | Comenzar desde el nivel más bajo, regular antes del ensayo y detener si la señal exige una intensidad invasiva. |
| Silenciamiento dependiente del programa | Mantener un interruptor físico en la rama luminosa. |

## Puerta de decisión

La arquitectura A pasa de seleccionada a construida solo cuando exista una lista de compra revisada y una persona competente confirme la conexión prevista. Pasa de construida a técnicamente preparada únicamente después de completar la ficha sin fallos abiertos.

Ninguno de estos estados autoriza a reclutar. El consentimiento, la revisión académica y las correcciones metodológicas siguen siendo puertas independientes.

## Referencias

Arduino. (s. f.). *Arduino Nano*. Recuperado el 30 de agosto de 2026, de https://docs.arduino.cc/hardware/nano

MechatronicStore. (s. f.-a). *Arduino Nano V3.0 CH340 compatible + cable*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/arduino-nano-v3-0-atmega328-cable/

MechatronicStore. (s. f.-b). *Botón pulsador switch 2 pines 6 × 6 × 7 mm*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/boton-pulsador-switch-2-pines-6x6x7mm/

MechatronicStore. (s. f.-c). *Cable apantallado 8 hilos 24 AWG por metro*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/cable-apantallado-8-hilos-24awg-por-metro/

MechatronicStore. (s. f.-d). *Convertidor buck step down LM2596S regulador de voltaje*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/modulo-de-fuente-de-alimentacion-reductora-ajustable-lm2596s-dc-dc-1-25-30v/

MechatronicStore. (s. f.-e). *Fuente de alimentación 12 V, 2 A*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/transformador-cargador-fuente-de-alimentacion-12v-2a/

MechatronicStore. (s. f.-f). *Interruptor de palanca de dos posiciones y dos pines*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/interruptor-de-palanca-2-posiciones-2-pines-6a-250v/

MechatronicStore. (s. f.-g). *Kit protoboard, fuente MB102 USB y cables*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/kit-protoboard-fuente-mb102-usb-set-de-cables/

MechatronicStore. (s. f.-h). *Módulo regulador PWM de potencia con MOSFET*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/modulo-regulador-switch-pwm-circuitos-de-potencia-15a-400w-mosfet/

MechatronicStore. (s. f.-i). *Tira LED 5050 rígida de 1 m, 12 V, blanco cálido o frío*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/tira-led-5050-rigida-1m-12v-blanco-calido-frio/

---

## Registro de cambios (disclaimer)

### 2026-08-30 — Creación del montaje provisional

- **Cambio:** se compararon activación cableada, infrarroja y por radio; se seleccionó la primera y se documentaron componentes, precios, arquitectura, secuencia y riesgos.
- **Versión anterior:** la especificación de fase A definía funciones y umbrales, pero no una configuración construible con fuentes y fecha de corte.
- **Motivo:** convertir el siguiente paso crítico en una decisión ejecutable sin adelantar Android, Bluetooth, forma ni producto final.
- **Alcance:** precios de referencia, sin compra ni stock reservado; no existe montaje, resultado técnico ni autorización para participantes.
