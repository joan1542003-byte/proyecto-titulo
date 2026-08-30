# Esquema de conexión provisional para fase A

**Fecha de corte:** 30 de agosto de 2026

**Estado:** borrador para revisión electrónica; no aprobado para energizar

**Relación:** desarrolla el [montaje mínimo](montaje-minimo-fase-a-2026-08-30.md) y el [firmware provisional](prototipo-fase-a/README.md)

## Propósito y límite

Este documento convierte la arquitectura funcional en una tabla de conexiones que pueda revisar una persona competente en electrónica. Define relaciones entre componentes, pero no asigna terminales físicos a partir de fotografías. Las etiquetas, polaridades y continuidades deben comprobarse en las piezas reales antes de conectar alimentación.

Toda la zona de prototipado opera en baja tensión continua. La alimentación de red permanece dentro de un adaptador comercial cerrado, que no debe abrirse ni modificarse.

## Datos disponibles

| Componente | Dato utilizado | Implicación provisional | Límite |
| --- | --- | --- | --- |
| Fuente cerrada | Salida nominal de 12 V y 2 A. | Es candidata para alimentar una rama luminosa de 12 V y el convertidor. | La ficha comercial contiene valores secundarios contradictorios; se adopta 2 A como límite y se debe medir la unidad real. |
| Tira LED rígida | 12 V, 14 W por metro. | Un metro demanda aproximadamente 1,17 A porque corriente = potencia / voltaje. | Debe medirse el segmento finalmente utilizado, su corriente y su temperatura. |
| LM2596S | Entrada de 4–35 V; salida ajustable; hasta 3 A y recomendación comercial de no superar 2,5 A durante periodos largos sin disipación adicional. | Puede reducir 12 V a 5 V para el controlador. | La salida no queda fijada de fábrica para este montaje: debe ajustarse y medirse sin el Nano conectado. |
| Nano compatible | Operación lógica de 5 V y salidas PWM, incluida D9. | D9 puede entregar la orden de control, no alimentar la tira. | Es una placa compatible; se debe confirmar su rotulado y el modo de alimentación de la unidad comprada. |
| Módulo MOSFET | Carga de 5–36 V, entrada de control de 3,3–20 V y señal PWM de hasta 20 kHz. | Puede conmutar la tira de 12 V desde la salida del Nano. | La ficha no basta para fijar el orden físico de todos los bornes ni demostrar su estado durante el arranque. |
| Interruptor DPDT | Dos polos ON-ON independientes. | Un polo puede abrir la rama luminosa dejando un terminal sin conexión; el otro comunica silencio a D3. | Los comunes y terminales laterales deben identificarse por continuidad. |

La fuente declara 24 W nominales y la tira completa 14 W. Quedan 10 W teóricos antes de considerar controlador, convertidor, pérdidas y arranque. Este presupuesto no aprueba la fuente: la corriente del segmento elegido y del conjunto debe medirse antes del ensayo continuo.

La rama de potencia de la tira no se conducirá por una protoboard sin soldadura. Su corriente nominal aproximada exige conectores, conductores y protección seleccionados por la persona revisora. La protoboard queda restringida a señales y conexiones de baja corriente.

## Tabla funcional de conexiones

Un **nodo común** es un conjunto de puntos unidos eléctricamente. En este montaje, GND reúne los retornos de baja tensión que necesitan una misma referencia.

| Tramo | Origen funcional | Destino funcional | Condición anterior a conexión |
| --- | --- | --- | --- |
| Alimentación de 12 V | Positivo de la fuente cerrada | Rama luminosa y entrada positiva del LM2596S | Medir tensión y polaridad del conector. |
| Retorno común | Negativo de la fuente cerrada | Entrada negativa del LM2596S, GND del Nano y GND de control del MOSFET | Confirmar continuidad y rotulado en cada módulo. |
| Alimentación del controlador | Salida del LM2596S ajustada a 5 V | Pin de 5 V y GND del Nano, solo si la placa real y la revisión electrónica confirman esta vía | Ajustar con el Nano desconectado; no aplicar 12 V al pin de 5 V ni mantener USB y alimentación externa simultáneos durante esta prueba. |
| Orden luminosa | D9 del Nano | Entrada de control del MOSFET | Identificar entrada y polaridad; comprobar primero sin la tira conectada. |
| Potencia luminosa | Rama de 12 V y salida de carga del MOSFET | Tira LED respetando positivo y negativo | Identificar en la placa real alimentación y carga; D9 nunca alimenta la tira. |
| Corte físico | Polo 1 del DPDT en serie con la rama luminosa | Posición activa cerrada; posición silenciosa con el terminal correspondiente sin conexión | Completar el mapa de continuidad con el sistema desconectado. |
| Estado de silencio | Polo 2 del DPDT | Común a GND; terminal silencioso a D3; terminal activo sin conexión | Confirmar HIGH en activo y LOW en silencio mediante medición. |
| Activación remota | D2 del Nano | Pulsador y retorno GND mediante 3 m de cable paralelo | Comprobar continuidad, ausencia de corto y activación estable antes de instalarlo en el espacio. |

La posición del DPDT se define por su efecto y no por izquierda o derecha, porque la orientación mecánica puede cambiar durante el montaje.

## Registro de terminales reales

Esta tabla debe completarse con las piezas presentes y el sistema desconectado. Una fila vacía impide energizar.

| Componente | Función | Etiqueta o terminal real | Método de comprobación | Iniciales y fecha |
| --- | --- | --- | --- | --- |
| Fuente | +12 V | ____ | Tensión y polaridad con multímetro | ____ |
| Fuente | GND | ____ | Tensión y continuidad | ____ |
| LM2596S | IN+ / IN− | ____ | Rotulado y continuidad | ____ |
| LM2596S | OUT+ / OUT− | ____ | Salida ajustada a 5,00 V sin carga | ____ |
| MOSFET | Entrada PWM y GND de control | ____ | Rotulado y prueba sin carga | ____ |
| MOSFET | Alimentación y salida de carga | ____ | Rotulado, continuidad y ficha de la unidad | ____ |
| DPDT, polo 1 | Común / activo / silencio | ____ | Continuidad en ambas posiciones | ____ |
| DPDT, polo 2 | Común / activo / silencio | ____ | Continuidad en ambas posiciones | ____ |
| Tira LED | Positivo / negativo | ____ | Rotulado y prueba limitada | ____ |

## Puertas antes de energizar

- [ ] La persona revisora confirma la ruta de alimentación del Nano.
- [ ] La fuente mide 12 V con la polaridad registrada.
- [ ] El LM2596S mide 5,00 V antes de conectar el controlador.
- [ ] No existe conexión simultánea no revisada entre USB y la alimentación externa.
- [ ] Todos los retornos necesarios comparten GND y no existe un corto entre positivo y GND.
- [ ] La persona revisora definió protección ante sobrecorriente o una fuente limitada para la primera energización.
- [ ] La rama LED utiliza terminales y conductores adecuados; no atraviesa la protoboard sin soldadura.
- [ ] D9 llega solo a la entrada de control del MOSFET.
- [ ] El DPDT abre físicamente la rama luminosa en silencio.
- [ ] D3 mide HIGH en activo y LOW en silencio.
- [ ] La entrada del MOSFET mantiene la salida apagada durante encendido y reinicio; si no, se define y registra una resistencia de apagado antes de continuar.
- [ ] El cable remoto está fijado fuera del recorrido.

## Orden de comprobación

1. Revisar componentes y completar el registro de terminales sin alimentación.
2. Conectar solo fuente y LM2596S; ajustar y medir 5,00 V.
3. Desconectar la fuente, añadir el Nano sin tira LED y compilar el firmware.
4. Comprobar D2, D3 y D9 con instrumentos o una carga de prueba adecuada.
5. Desconectar, añadir MOSFET, DPDT y un segmento LED limitado.
6. Verificar arranque apagado, corte físico y polaridad antes de ejecutar pulsos.
7. Medir corriente, tensión y temperatura con el segmento seleccionado.
8. Solo después completar la [ficha de ensayo técnico](../07_validacion/ficha-ensayo-tecnico-fase-a.md).

## Bloqueos que este documento no resuelve

- pinout físico del módulo MOSFET comprado;
- vía de alimentación aprobada para la placa Nano compatible;
- necesidad y valor de una resistencia de apagado;
- corriente y temperatura reales;
- terminales, calibre y protección de la rama de potencia;
- longitud final del segmento LED;
- ausencia de ruido en el cable de tres metros;
- compilación y funcionamiento del firmware;
- seguridad y estabilidad del montaje cerrado.

Los terminales y la protección que determine la revisión no están incluidos en el subtotal actual. La lista de materiales debe actualizarse antes de comprar.

## Referencias

Arduino. (s. f.). *Arduino Nano*. Recuperado el 30 de agosto de 2026, de https://docs.arduino.cc/hardware/nano

MechatronicStore. (s. f.-a). *Arduino Nano V3.0 CH340 compatible + cable*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/arduino-nano-v3-0-atmega328-cable/

MechatronicStore. (s. f.-b). *Convertidor buck step down LM2596S regulador de voltaje*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/modulo-de-fuente-de-alimentacion-reductora-ajustable-lm2596s-dc-dc-1-25-30v/

MechatronicStore. (s. f.-c). *Fuente de alimentación 12 V, 2 A*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/transformador-cargador-fuente-de-alimentacion-12v-2a/

MechatronicStore. (s. f.-d). *Interruptor de palanca DPDT de seis pines*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/interruptor-palanca-dpdt-6-pines-3a/

MechatronicStore. (s. f.-e). *Módulo regulador PWM de potencia con MOSFET*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/modulo-regulador-switch-pwm-circuitos-de-potencia-15a-400w-mosfet/

MechatronicStore. (s. f.-f). *Tira LED 5050 rígida de 1 m, 12 V, blanco cálido o frío*. Recuperado el 30 de agosto de 2026, de https://www.mechatronicstore.cl/tira-led-5050-rigida-1m-12v-blanco-calido-frio/

---

## Registro de cambios (disclaimer)

### 2026-08-30 — Creación

- **Cambio:** se creó una tabla funcional, un registro vacío de terminales y puertas anteriores a la energización.
- **Versión anterior:** el montaje describía componentes y relaciones, pero no separaba conexiones deducibles de terminales que exigen identificación física.
- **Motivo:** preparar una revisión electrónica reproducible sin convertir una ficha comercial en un pinout.
- **Alcance:** borrador sin aprobación, mediciones, compra, compilación ni construcción.
