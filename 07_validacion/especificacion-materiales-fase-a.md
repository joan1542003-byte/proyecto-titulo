# Especificación mínima de materiales — fase A

**Estado:** preparada documentalmente; implementación y ensayo técnico pendientes
**Propósito:** comprobar que la señal situada puede ejecutarse de manera estable y controlable antes de evaluar su comprensión con participantes

## Principio de construcción

El material debe funcionar como una señal controlada, no como una representación de la forma final de Relevo. La vía inmediata es una plataforma ya fabricada, preferentemente micro:bit V2, dentro de una cubierta neutra. Su apariencia solo necesita evitar significados ajenos, permanecer estable y permitir percibir luz y sonido. No se evaluarán identidad visual, acabado, tamaño definitivo, autonomía energética ni fabricación.

En esta etapa, **manual** describe la decisión de activación: el investigador determina cuándo enviar la orden desde Android. La orden puede viajar por Bluetooth de baja energía (BLE), siempre que el enlace haya sido comprobado antes de la sesión. No se incorporan todavía detección de aplicaciones, automatización ni reglas contextuales.

## Componentes funcionales

| Componente | Requisito mínimo | Fuera de alcance |
| --- | --- | --- |
| Cuerpo neutro | Volumen estable, sin texto ni iconos; cubre la placa sin impedir el paso de luz y sonido ni el acceso al control local. | Forma, material industrial o portabilidad final. |
| Fuente de luz | Luz blanca cálida regulable y visible desde varios ángulos; no muestra letras, números ni información. | Patrón luminoso definitivo o color de identidad. |
| Difusor | Evita puntos luminosos directos y distribuye el pulso. | Textura, color o proceso productivo definitivo. |
| Fuente sonora | Tono breve, sin voz, regulable y reconocible en el entorno registrado. | Timbre definitivo, mensajes hablados o volumen comercial. |
| Activación remota | Recibe desde Android una orden BLE iniciada por el investigador, sin que este se acerque al material. | Detección automática de actividad, sincronización en la nube o configuración final de la aplicación. |
| Silenciamiento | Control físico evidente que detiene la señal y devuelve el sistema a reposo sin depender del enlace. | Arquitectura final del botón o del gesto. |
| Control del patrón | Ejecuta una sola secuencia de tres pulsos luminosos y un tono breve, y luego vuelve a reposo. | Biblioteca completa de señales o personalización. |
| Alimentación segura | Fuente protegida y estable durante toda la sesión. | Autonomía de batería o sistema de carga final. |

## Comportamiento esperado

1. El material permanece apagado al conectarse.
2. La orden `activar` produce una sola secuencia de tres pulsos luminosos cuya duración total es de 3 s ± 0,3 s y un tono breve sincronizado con el inicio.
3. Una nueva orden recibida durante la secuencia no acumula señales.
4. El control físico detiene la señal en menos de un segundo y devuelve el material a reposo.
5. Si el temporizador se cancela en Android antes de la activación, no se envía una orden al objeto.
6. No existe repetición automática.
7. El material no guarda intención, identidad, respuesta ni historial de activaciones.
8. Una reconexión o recuperación de energía no produce una señal por sí sola.

## Ensayo técnico sin participantes

### Preparación

- ubicar el material en tres superficies: mesa clara, mesa oscura y suelo o mueble bajo;
- probar con iluminación diurna y artificial disponible;
- registrar si el entorno sonoro está en silencio relativo o contiene ruido doméstico estable;
- marcar distancias de uno, dos y tres metros;
- registrar el dispositivo Android, su versión, la aplicación o control utilizado, el firmware y la alimentación;
- preparar cronómetro y la [ficha de ensayo técnico](ficha-ensayo-tecnico-fase-a.md), sin datos personales.

### Comprobaciones

| Prueba | Repeticiones | Criterio para continuar |
| --- | ---: | --- |
| Conexión y reconexión BLE | 5 | El dispositivo puede enlazarse, reiniciarse y volver a recibir una orden sin activar la señal durante la reconexión. |
| Activación, latencia y patrón | 10 | Las diez órdenes producen una sola secuencia, sin duplicación; se registra el tiempo entre orden y comienzo, y el patrón dura 3 s ± 0,3 s. |
| Luz y sonido | 3 superficies × 3 distancias | Ambos canales se reconocen al nivel mínimo reproducible elegido para la sesión. Esta comprobación instrumental no reemplaza la prueba de percepción con participantes. |
| Silenciamiento local | 10 | El control físico detiene la señal en menos de 1 s y no existe reactivación espontánea. |
| Recuperación de energía | 5 | Reinicia apagado y espera una nueva orden. |
| Estabilidad | 3 superficies | No vuelca ni se desplaza al accionar el control. |
| Temperatura y alimentación | 30 min encendido | No aparece calentamiento perceptible, conductor expuesto, aislación dañada, deformación, olor, parpadeo no programado ni interrupción. |

Si una comprobación falla, el material no pasa a sesión con participantes. Se corrige la causa y se repite la serie completa afectada. Si el enlace falla durante una sesión posterior, ese intento se registra como incidente técnico y no se utiliza para juzgar la asociación; solo puede repetirse después de restablecer y volver a comprobar el sistema.

## Registro técnico

La ficha deberá conservar fecha, plataforma, dispositivo Android, versión del control, firmware, alimentación, superficie, distancia, iluminación, condición sonora aproximada, latencia, resultado por repetición, fallo observado, corrección y decisión. No se registrarán impresiones sobre eficacia o preferencia, porque todavía no existe una experiencia de usuario.

## Decisión posterior

- **Material técnicamente preparado para revisión académica:** cumple todas las comprobaciones y conserva el registro completo.
- **Modificar:** falla repetibilidad, silenciamiento, estabilidad o alimentación, pero la causa puede aislarse.
- **Detener:** requiere una intensidad invasiva, genera riesgo eléctrico o no admite una salida física comprensible.

El resultado técnico no autoriza por sí solo a trabajar con participantes. Antes del reclutamiento debe completarse el correo del responsable, obtenerse la revisión académica del conjunto y cerrarse cualquier corrección solicitada. La fecha máxima de eliminación ya está fijada en el consentimiento. La plataforma y la secuencia de comprobación se fundamentan en el [estudio de alternativas existentes](../06_desarrollo_y_factibilidad/plataformas-existentes-modificables-2026-09-07.md) y se controlan mediante la [Issue #11](https://github.com/joan1542003-byte/proyecto-titulo/issues/11).

Cumplir esta especificación solo demuestra que el material puede ejecutar el ensayo de manera estable. No demuestra que la señal se perciba, se comprenda o recupere una intención.

---

## Registro de cambios (disclaimer)

### 2026-09-08 — Puerta técnica adaptada a la plataforma existente

- **Cambio:** se incorporaron Android, BLE, sonido, reconexión, activación remota y silenciamiento local a la comprobación previa; se mantuvo la activación manual como decisión del investigador y se añadió una regla para invalidar incidentes técnicos durante una sesión.
- **Versión anterior:** la especificación excluía Android y Bluetooth, consideraba solo una señal luminosa y remitía a construir un montaje propio antes de probar.
- **Motivo:** utilizar una plataforma existente reduce fabricación temprana, pero exige demostrar de forma separada que conexión, luz, sonido y controles son estables antes de interpretar respuestas de participantes.
- **Alcance:** la especificación continúa sin ejecutar; no demuestra comprensión, accesibilidad, autonomía ni ventaja frente a una notificación.

### 2026-08-30 — Bloqueo administrativo actualizado

- **Cambio:** se retiró la fecha de eliminación de los campos pendientes y se mantuvieron correo y revisión académica.
- **Versión anterior:** la especificación seguía tratando contacto y fecha como dos vacíos.
- **Motivo:** sincronizar la puerta técnica con el consentimiento vigente.
- **Alcance:** completar el material no autoriza reclutamiento.

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
- **Alcance en esa versión:** la especificación no diseñaba la forma final, no integraba Android o Bluetooth y no registraba resultados técnicos. La integración de prueba se incorporó el 7 de septiembre.
