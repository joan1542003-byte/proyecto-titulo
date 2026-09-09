# Qué prototipar y cómo validar el valor

**Estado:** plan operativo que reúne la documentación vigente; ejecución pendiente.
**Pregunta:** ¿qué material permite probar la experiencia y qué conclusión autoriza cada prototipo?

## Respuesta breve

Prototipar el ciclo que relaciona intención, primer paso, lugar, señal y decisión. Primero comprobar el comportamiento físico; después, comprensión y asociación; finalmente, comparar el aporte del lugar y del soporte. Una demostración explica el mecanismo; solo una prueba registrada puede aportar evidencia sobre su valor.

## Prototipos y materiales concretos

| Etapa | Pregunta | Material necesario | Evidencia de salida |
| --- | --- | --- | --- |
| Recorrido de interacción | ¿Se comprende preparar, situar, probar, armar y cerrar? | [Wireframe v1](../05_propuesta_phygital/cierre-wireframe-v1-2026-09-09.md), teléfono Android para la navegación mínima, ejemplo de intención y un objeto/material de comienzo. | Errores de comprensión, pasos innecesarios y salidas ambiguas. El wireframe está cerrado estructuralmente; no prueba comportamiento físico. |
| Banco de comportamiento | ¿La orden produce una sola señal y se puede detener? | micro:bit V2, [HEX de banco](../06_desarrollo_y_factibilidad/prueba-microbit-ble/README.md), Android con terminal UART compatible, cable y alimentación conforme al paquete, cronómetro y [ficha técnica](ficha-ensayo-tecnico-fase-a.md). | Conexión, reconexión, latencia, patrón, sonido, silencio local y fallos registrados. La matriz roja solo representa luz en este banco. |
| Preparación material | ¿La señal de fase A es estable y revisable? | Luz cálida externa, resistencia y circuito indicados en el paquete, difusor, cubierta neutra, control accesible, alimentación revisada y superficies/distancias de ensayo. | Ficha técnica completa y revisión del material. No equivale a comprensión con personas. |
| Asociación con participantes | ¿Se recuperan intención y primer paso? | Material aprobado, intención personal, primer paso realizable, lugar elegido, consentimiento revisado y [ficha de registro](ficha-registro-protocolo-01.md). | Percepción, atribución, intención y primer paso, sin pistas ni consulta del teléfono; autonomía por separado. |
| Comparación de valor | ¿El lugar y el soporte aportan algo? | Mismo objeto en lugar relacionado y neutro; notificación Android equivalente; orden contrabalanceado. | Asociación, consultas del teléfono, carga, intrusión y razones de preferencia. |
| Integración y forma | ¿Se sostiene el ciclo en el objeto portátil? | Arquitectura XIAO, componentes reales y dos maquetas/carcasas comparables según Issue #10. | Medidas, manipulación, consumo, fiabilidad y límites. Solo procede cuando la evidencia justifique esa fidelidad. |

La lista permite preparar la experiencia; no sustituye el inventario, el esquema o la revisión técnica. Las referencias de componentes y conexión se mantienen en factibilidad para evitar dos listas de compra divergentes.

## Comportamiento que debe poder demostrarse

Reposo → conexión sin señal → recepción de `activar` → tres pulsos y tono inicial → silencio local o final del patrón → reposo. Una reconexión no produce un pulso nuevo. Cancelar antes de la activación significa no enviar la orden desde Android. El banco no implementa detección automática de uso ni el armado físico completo previsto en la interfaz final.

El primer prototipo Android conserva los nueve marcos y recuperaciones prioritarias del [alcance mínimo](../05_propuesta_phygital/alcance-primer-prototipo-y-backlog-2026-09-07.md). La terminal temporal sirve para probar transporte; no reemplaza ese recorrido.

## Qué significa «si estoy X tiempo»

Hay tres tiempos diferentes:

| Tiempo | Estado | Qué permite concluir |
| --- | --- | --- |
| Ocho minutos después de configurar | Intervalo del Protocolo 01; activación controlada por el investigador. | Asociación en ese ensayo breve; no recuerdo prolongado ni umbral ideal. |
| Tres segundos de patrón, con tolerancia técnica | Parámetro provisional de la señal. | Si el dispositivo ejecuta el comportamiento previsto; no eficacia personal. |
| Umbral o franja de uso del producto | Pendiente entre continuidad, acumulación y horario. | Requiere prueba específica de pertinencia y viabilidad; el dispositivo no infiere intención desplazada a partir del tiempo. |

Para decidir después una condición, definir antes qué evento se observa, qué se considera interrupción, qué ventana está vigente y qué pasa si cambia la intención. Probar ejemplos como una sesión continua, varias sesiones cortas y una franja sin uso; preguntar qué esperaba la persona y registrar activaciones pertinentes o inoportunas. Es una etapa posterior: no se agrega al Protocolo 01 ni se elige un valor arbitrario como solución universal.

## Indicadores y decisiones

La fase A prevista incluye seis personas. Avanza cuando al menos cinco reconstruyen percepción, atribución, intención y primer paso sin teléfono ni pistas, se comprenden las salidas y no aparecen fallos críticos. Tres o cuatro requieren modificar y repetir; dos o menos después de una iteración obligan a detener la configuración. Una falla técnica invalida el intento afectado y se registra separadamente.

La fase B compara objeto situado, objeto neutro y notificación, con las seis secuencias posibles distribuidas entre participantes. Se conservan las reglas del [protocolo](protocolo-01-asociacion-y-comparacion.md): asociación igual o mejor que la notificación, diferencia respecto del lugar neutro para una mayoría y ausencia de carga o intrusión recurrentes. No se modifica la muestra ni se añaden umbrales aquí.

Recordar, elegir actuar, iniciar, completar y sostener una actividad son resultados distintos. Las fichas de investigación documentan la prueba; Relevo no necesita un historial de cumplimiento. Continuar con el teléfono puede ser una decisión válida. Esta evaluación formativa no demuestra bienestar, hábitos, reducción de pantalla ni eficacia poblacional.

## Orden inmediato

1. Ejecutar y registrar el banco de la [Issue #11](https://github.com/joan1542003-byte/proyecto-titulo/issues/11).
2. Completar la luz cálida y las comprobaciones de materiales.
3. Cerrar la revisión académica del consentimiento, contacto y procedimiento antes de reclutar.
4. Ejecutar fase A de la [Issue #8](https://github.com/joan1542003-byte/proyecto-titulo/issues/8).
5. Si permite avanzar, disponer de notificación equivalente y realizar fase B; integrar después la [Issue #10](https://github.com/joan1542003-byte/proyecto-titulo/issues/10).

El calendario acompaña esas dependencias; una fecha cumplida no sustituye un criterio de entrada. No existen resultados en este documento.

## Registro de cambios (disclaimer)

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se enlazaron prototipo, materiales, comportamiento, tiempos y conclusiones permitidas en una secuencia única.
- **Versión anterior:** No existía un documento específico.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.
