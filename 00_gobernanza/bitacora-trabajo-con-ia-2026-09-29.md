# Bitácora del trabajo con IA: 29 de septiembre de 2026

**Estado:** registro de lo hecho con Claude Code el 29 de septiembre de 2026, a pedido del autor. Continúa la [bitácora del 26 al 28 de septiembre](bitacora-trabajo-con-ia-2026-09-26-28.md). Enlaza los documentos de cada trabajo; no los reemplaza. Cada pedido del autor está en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** el trabajo se hizo en `android-2.7`. El 29 de septiembre, a pedido del autor, `main` avanzó hasta el mismo commit, sin conflictos. Todo está en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| App para el testeo real | [Android 2.12](../06_desarrollo_y_factibilidad/app-android/version-2.12-mas-simple-y-mas-datos-2026-09-29.md), [2.13](../06_desarrollo_y_factibilidad/app-android/version-2.13-guia-intereses-y-nombre-2026-09-29.md) y [2.14](../06_desarrollo_y_factibilidad/app-android/version-2.14-guia-y-primer-relevo-2026-09-29.md): más simple, más datos, intereses de las entrevistas, nombre aparte, guía que acompaña el primer relevo. | D-087 a D-090 |
| Registro de pedidos | [Registro de pedidos a la IA](registro-de-pedidos-a-la-ia.md) y regla en `CLAUDE.md`. | — |
| Hipótesis | Ocho versiones, trabajadas con el autor, hasta la final: «Si se diseña un sistema phygital que vincula una actividad elegida con el lugar donde comienza, entonces la persona la recordará a tiempo durante el ocio digital, porque una intención se recupera cuando aparece una señal asociada a ella». Se contrastó con los encargos del seminario y con el feedback del pase y del examen de julio. | D-091 |
| Memoria | Marco multiproceso de McDaniel y Einstein (2000) en el capítulo 6. Capítulos 11 y 13 al día con la app 2.14 y la prueba con una persona. Citas en APA 7 en español. Revisión completa del texto. | D-091 |
| Encuesta | [53 respuestas analizadas](../03_usuarios/encuesta-53-respuestas-2026-09.md) e incorporadas como evidencia complementaria, con sus límites. | D-092 |
| Presentación | [Archivo nuevo en Figma](https://www.figma.com/slides/zhLK5LTPQWXPHIQeq4wuE8), simplificado para 5 minutos y corregido con las notas del autor; la diapositiva 14 muestra lo que sigue hasta el examen ([estado y cómo se hizo](../10_recursos_visuales/24_presentacion-correccion-cruzada-2026-09-30.md)). | — |
| Objetos que suenan | [Estudio de opciones baratas](../06_desarrollo_y_factibilidad/objetos-que-suenan-2026-09-29.md) y [Android 2.15](../06_desarrollo_y_factibilidad/app-android/version-2.15-reloj-como-llamada-2026-09-29.md) con la salida experimental «El reloj». | D-093 |
| Marco teórico | Títulos simples para los tres ámbitos: «La experiencia del ocio digital», «El diseño de la atención» y «Recordar con objetos y lugares». | D-094 |

## 2. Cómo se usó la IA

- **El autor dirigió; la IA propuso y ejecutó.** Con frecuencia el autor corrigió el rumbo: rechazó dos versiones de la hipótesis, pidió que fuera teórica y más simple, recuperó las intersecciones de su propio Venn y pidió títulos sin jerga.
- **Contraste con fuentes propias del proyecto:** encargos del seminario, feedback del pase y del examen, presentaciones de compañeros y la memoria vigente. La IA buscó respaldo antes de cambiar textos académicos.
- **Límites que la IA hizo explícitos:** preguntó por el origen y el consentimiento de la encuesta antes de usarla; no descargó un APK desde un sitio espejo y verificó el iTag en código abierto; declaró que la salida del reloj no se probó con hardware real.

## 3. Qué se comprobó y qué no

- **Comprobado:** compilación y 62 pruebas unitarias de Android 2.15; la restricción de Supabase que acepta `watch`; los totales de la encuesta, verificados con un script; la extensión de la memoria (16.965 palabras), del resumen (298) y del *abstract* (289); los márgenes de las 26 diapositivas.
- **No comprobado:** la app en un teléfono real; el reloj y el llavero iTag con hardware; la codificación de la encuesta por una segunda persona; el ensayo de la presentación.

## 4. Pendientes

- Probar Android 2.15 con el Huawei Watch Fit 5 y comprar dos iTag para probarlos con iTag.One.
- Decidir la duración de la señal: 41 de 53 personas preferirían 15 segundos o menos.
- Revisar la codificación de la encuesta y documentar su fecha y convocatoria.
- Revisar las notas del orador y ensayar la presentación.
- Revisión ética del consentimiento v9 y prueba técnica en el teléfono y el parlante reales antes del 8 de octubre.

## Registro de cambios (disclaimer)

### 2026-09-29 — Rama principal y diapositiva 14

- **Qué cambió:** la bitácora registra que `main` quedó igual a `android-2.7` y que la diapositiva 14 muestra lo que sigue hasta el examen.
- **Cómo estaba antes:** decía que el trabajo no se había fusionado con `main`.
- **Por qué:** el autor pidió enviar el trabajo a `main` y rehacer la diapositiva.

### 2026-09-29 — Creación

- **Qué se añadió:** resumen del trabajo del 29 de septiembre: app, hipótesis, memoria, encuesta, presentación, objetos que suenan y títulos de los ámbitos, con decisiones, uso de la IA, comprobaciones y pendientes.
- **Cómo estaba antes:** la última bitácora cubría del 26 al 28 de septiembre.
- **Por qué:** el autor pidió subir todo, documentar el estado y explicar cómo se hizo la presentación.
