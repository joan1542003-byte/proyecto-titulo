# Especificación mínima de materiales — fase A

**Estado:** lista para construcción y ensayo técnico
**Propósito:** probar la asociación entre intención, señal y lugar sin integrar Android ni Bluetooth

## Principio de construcción

El material debe funcionar como una señal controlada, no como una representación de la forma final de Relevo. Su apariencia solo necesita evitar significados ajenos, permitir situarlo con estabilidad y hacer visible el pulso. No se evaluarán color de marca, acabado, tamaño definitivo, autonomía energética ni fabricación.

## Componentes funcionales

| Componente | Requisito mínimo | Fuera de alcance |
| --- | --- | --- |
| Cuerpo neutro | Volumen estable, sin texto, pantalla ni iconos; permite colocar un difusor. | Forma circular definitiva, material industrial o portabilidad final. |
| Fuente de luz | Luz blanca cálida regulable y visible desde varios ángulos. | Decisión final entre luz, sonido y vibración. |
| Difusor | Evita puntos luminosos directos y distribuye el pulso. | Textura, color o proceso productivo definitivo. |
| Activación remota | Permite al investigador iniciar el patrón sin acercarse al objeto. | Detección automática, aplicación Android o comunicación Bluetooth. |
| Silenciamiento | Control físico evidente que detiene el patrón durante la práctica y cualquier repetición accidental. | Arquitectura final del botón o gesto definitivo. |
| Control del patrón | Ejecuta tres pulsos dentro de tres segundos y vuelve a reposo. | Biblioteca completa de señales o personalización. |
| Alimentación segura | Fuente protegida y estable durante toda la sesión. | Autonomía de batería o sistema de carga final. |

## Comportamiento esperado

1. El material permanece apagado al conectarse.
2. Una activación produce una sola secuencia de tres pulsos durante tres segundos.
3. Una nueva orden recibida durante la secuencia no acumula señales.
4. El control físico detiene el pulso y devuelve el material a reposo.
5. No existe repetición automática.
6. El material no guarda intención, identidad, respuesta ni historial de activaciones.
7. Una desconexión no produce un pulso al recuperar energía.

## Ensayo técnico sin participantes

### Preparación

- ubicar el material en tres superficies: mesa clara, mesa oscura y suelo o mueble bajo;
- probar con iluminación diurna y artificial disponible;
- marcar distancias de uno, dos y tres metros;
- preparar cronómetro y ficha técnica sin datos personales.

### Comprobaciones

| Prueba | Repeticiones | Criterio para continuar |
| --- | ---: | --- |
| Activación desde reposo | 10 | Diez secuencias únicas, sin disparos dobles. |
| Duración del patrón | 10 | Cada secuencia dura 3 s ± 0,3 s. |
| Silenciamiento | 10 | Detiene la señal en menos de 1 s y no vuelve a encenderse. |
| Recuperación de energía | 5 | Reinicia apagado y espera una nueva orden. |
| Perceptibilidad instrumental | 3 superficies × 3 distancias | El investigador identifica el comienzo del pulso sin mirar directamente la fuente. Esto no reemplaza una prueba de accesibilidad. |
| Estabilidad | 3 superficies | No vuelca ni se desplaza al accionar el control. |
| Temperatura y alimentación | 30 min encendido | No aparece calentamiento perceptible, cable expuesto ni interrupción. |

Si una comprobación falla, el material no pasa a sesión con participantes. Se corrige la causa y se repite la serie completa afectada.

## Registro técnico

La ficha deberá conservar fecha, versión, componentes utilizados, superficie, distancia, iluminación aproximada, resultado por repetición, fallo observado, corrección y decisión. No se registrarán impresiones sobre eficacia o preferencia, porque todavía no existe una experiencia de usuario.

## Decisión posterior

- **Preparado para revisión académica:** cumple todas las comprobaciones y el consentimiento tiene contacto y fecha de eliminación.
- **Modificar:** falla repetibilidad, silenciamiento, estabilidad o alimentación, pero la causa puede aislarse.
- **Detener:** requiere una intensidad invasiva, genera riesgo eléctrico o no admite una salida física comprensible.

Cumplir esta especificación solo demuestra que el material puede ejecutar el ensayo de manera estable. No demuestra que la señal se perciba, se comprenda o recupere una intención.

---

## Registro de cambios (disclaimer)

### 2026-08-27 — Creación

- **Cambio:** se definieron componentes, comportamiento y comprobaciones previas de la fase A.
- **Versión anterior:** el ensayo interno indicaba construir un objeto simple, pero no establecía cuándo era suficientemente estable y seguro para una sesión.
- **Motivo:** separar fallos del material de fallos de asociación antes de involucrar participantes.
- **Alcance:** la especificación no diseña la forma final, no integra Android o Bluetooth y todavía no registra resultados técnicos.
