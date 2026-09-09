# Señal física: luz, sonido y evaluación de vibración

**Estado:** luz y sonido seleccionados para la prueba; parámetros perceptivos sin validar. Vibración como alternativa condicionada, no componente requerido del primer montaje.

## Respuesta al feedback

Relevo debe permitir percibir una señal breve, asociarla a una intención y detenerla localmente. La combinación inicial es luz blanca cálida difundida y un tono breve. La [especificación de materiales](../07_validacion/especificacion-materiales-fase-a.md) fija el patrón y sus controles; este documento no los cambia. El ámbar de identidad pertenece al sistema gráfico y no sustituye automáticamente el blanco cálido del ensayo.

| Canal | Función prevista | Qué medir | Límite |
| --- | --- | --- | --- |
| Luz | Hacer perceptible el objeto y el lugar durante el pulso. | Distancia, ángulo, iluminación, obstáculos y confusión con indicadores técnicos. | No suponer percepción cuando el objeto está fuera de la vista. |
| Sonido | Hacer notar el inicio de la señal. | Audibilidad en el entorno, asociación, molestia y acceso al silencio. | No adoptar volumen de localizador como nivel adecuado para Relevo. |
| Vibración | Alternativa que podría aportar percepción mediante contacto o una superficie. | Qué contacto existe, cómo se detecta y si añade ruido o desplazamiento. | Una vibración percibida por ruido es evidencia acústica, no de percepción táctil a distancia. |

## Cómo evaluar vibración sin ampliar el montaje por defecto

La evaluación comienza por una pregunta: ¿qué fallo de percepción o necesidad de acceso resolvería? Si luz y sonido son perceptibles y aceptables en el contexto probado, no existe evidencia para añadir un motor solo por aumentar modalidades.

Como exploración técnica posterior, usar un módulo háptico con control y alimentación revisados; comparar contacto con la mano, apoyo sobre superficie rígida y apoyo amortiguado. Mantener duración y posición documentadas. Registrar percepción táctil, ruido producido, desplazamiento, acceso al silencio y consumo cuando exista integración. No conectar un motor directamente a un pin sin verificar su circuito de control.

La conclusión posible es mantenerla como alternativa, descartarla para el objeto situado o reformular el contacto físico. Llevarlo a la muñeca o al bolsillo cambiaría su relación con el lugar y requiere una decisión explícita; no es una modificación menor.

Una prueba con participantes necesita una variante previamente documentada y revisada. Los resultados de modalidades diferentes se analizan por separado. El protocolo vigente ya permite acordar una variante accesible antes de la sesión; si fuera necesario modificar una señal durante el estudio por seguridad o un fallo crítico, se distinguen las versiones y sus resultados.

## Puerta actual

El [paquete micro:bit](prueba-microbit-ble/README.md) contiene un binario de mesa con matriz roja. Primero se comprueban enlace, tiempos, sonido y silencio local sin participantes. Para fase A se añade la salida cálida externa difundida y revisada. La [ficha técnica](../07_validacion/ficha-ensayo-tecnico-fase-a.md) conserva los valores observados; este documento no afirma que ya existan mediciones.

La intensidad, el ritmo y el timbre final se decidirán por percepción y convivencia. La ausencia de resultados impide declarar que la combinación elegida sea superior o accesible para todas las personas. Seguimiento: Issues [#11](https://github.com/joan1542003-byte/proyecto-titulo/issues/11), [#8](https://github.com/joan1542003-byte/proyecto-titulo/issues/8) y [#10](https://github.com/joan1542003-byte/proyecto-titulo/issues/10), en ese orden de dependencia.

## Fundamento

Este documento operacionaliza las decisiones D-045, D-048 y D-049 del [registro](../09_decisiones/registro-de-decisiones.md), los requisitos RU-08/RU-11 de la [matriz de usuarios](../03_usuarios/matriz-requisitos-de-usuarios.md) y el [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md). La exploración de vibración es una propuesta de prueba, no un hallazgo empírico.

## Registro de cambios (disclaimer)

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se precisaron funciones sensoriales, parámetros gobernados por el protocolo y una evaluación condicionada de vibración.
- **Versión anterior:** No existía un documento específico.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.
