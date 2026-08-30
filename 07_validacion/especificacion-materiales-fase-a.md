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
2. Una activación produce una sola secuencia de tres pulsos cuya duración total es de 3 s ± 0,3 s.
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
- preparar cronómetro y la [ficha de ensayo técnico](ficha-ensayo-tecnico-fase-a.md), sin datos personales.

### Comprobaciones

| Prueba | Repeticiones | Criterio para continuar |
| --- | ---: | --- |
| Activación y duración | 10 | Las mismas diez secuencias son únicas, no presentan disparos dobles y duran 3 s ± 0,3 s. |
| Silenciamiento | 10 | Detiene la señal en menos de 1 s y no vuelve a encenderse. |
| Recuperación de energía | 5 | Reinicia apagado y espera una nueva orden. |
| Perceptibilidad instrumental | 3 superficies × 3 distancias | El investigador identifica el comienzo del pulso sin mirar directamente la fuente. Esto no reemplaza una prueba de accesibilidad. |
| Estabilidad | 3 superficies | No vuelca ni se desplaza al accionar el control. |
| Temperatura y alimentación | 30 min encendido | No aparece calentamiento perceptible, conductor expuesto, aislación dañada, deformación, olor, parpadeo no programado ni interrupción. |

Si una comprobación falla, el material no pasa a sesión con participantes. Se corrige la causa y se repite la serie completa afectada.

## Registro técnico

La ficha deberá conservar fecha, versión, componentes utilizados, superficie, distancia, iluminación aproximada, resultado por repetición, fallo observado, corrección y decisión. No se registrarán impresiones sobre eficacia o preferencia, porque todavía no existe una experiencia de usuario.

## Decisión posterior

- **Material técnicamente preparado para revisión académica:** cumple todas las comprobaciones y conserva el registro completo.
- **Modificar:** falla repetibilidad, silenciamiento, estabilidad o alimentación, pero la causa puede aislarse.
- **Detener:** requiere una intensidad invasiva, genera riesgo eléctrico o no admite una salida física comprensible.

El resultado técnico no autoriza por sí solo a trabajar con participantes. Antes del reclutamiento deben completarse contacto y fecha de eliminación del consentimiento, obtenerse la revisión académica del conjunto y cerrarse cualquier corrección solicitada.

Cumplir esta especificación solo demuestra que el material puede ejecutar el ensayo de manera estable. No demuestra que la señal se perciba, se comprenda o recupere una intención.

---

## Registro de cambios (disclaimer)

### 2026-08-30 — Correcciones posteriores a auditoría

- **Cambio:** se unificaron activación y duración en una serie de diez secuencias, se amplió el criterio observable de seguridad y se separó la aptitud técnica de la autorización para participantes.
- **Versión anterior:** activación y duración podían leerse como veinte pruebas distintas; la decisión mezclaba cumplimiento material con campos administrativos del consentimiento.
- **Motivo:** hacer reproducible la ficha y evitar que una comprobación técnica se interprete como autorización metodológica.
- **Alcance:** no se modificó el patrón de señal ni se registraron resultados.

### 2026-08-30 — Instrumento de registro enlazado

- **Cambio:** la preparación remite a una ficha independiente para registrar todas las repeticiones, incidentes y decisiones.
- **Versión anterior:** la especificación enumeraba los campos requeridos, pero el instrumento todavía no existía.
- **Motivo:** convertir la puerta técnica en un procedimiento ejecutable y auditable.
- **Alcance:** no se modificaron componentes, umbrales ni criterios de decisión; el ensayo continúa sin ejecutar.

### 2026-08-27 — Creación

- **Cambio:** se definieron componentes, comportamiento y comprobaciones previas de la fase A.
- **Versión anterior:** el ensayo interno indicaba construir un objeto simple, pero no establecía cuándo era suficientemente estable y seguro para una sesión.
- **Motivo:** separar fallos del material de fallos de asociación antes de involucrar participantes.
- **Alcance:** la especificación no diseña la forma final, no integra Android o Bluetooth y todavía no registra resultados técnicos.
