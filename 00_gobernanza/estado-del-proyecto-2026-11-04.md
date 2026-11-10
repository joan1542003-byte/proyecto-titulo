# Estado del proyecto al 4 de noviembre de 2026

**Corte:** 4 de noviembre de 2026, sobre `main` en `c213b28` (29 de octubre, D-152). **Para qué:** saber dónde está cada cosa, qué trabajo vive en ramas que todavía no entran a `main`, qué ya está hecho para no repetirlo y qué hay que aclarar con el autor. **Antes:** el [estado del 25 de octubre](estado-del-proyecto-2026-10-25.md), que se conserva.

Por decisión del autor del 4 de noviembre, ninguna rama se fusiona a `main` todavía. Este documento sirve para hacerlo después sin perder nada.

> **Al 10 de noviembre:** las ramas de textos y la app 4.7.2 (`android-4.6`, con los íconos propios) ya están en `main`. El detalle está en la [fusión de los textos](fusion-de-textos-en-main-2026-11-10.md).

> **Al 5 de noviembre:** esta rama ya tiene `main` al día. Lo que cambió después del corte está en la [sección 7](#7-después-del-corte-5-de-noviembre).

## 1. Dónde está cada cosa

| Qué | Dónde | Estado al 4 de noviembre |
| --- | --- | --- |
| Texto de la memoria | [Borrador v6](../08_memoria/borrador-memoria-v6-2026-10-28.md) y sus [notas](../08_memoria/notas-del-borrador-v6-2026-10-28.md) | Reescrito en torno a las decisiones de diseño (D-146 a D-152): 14 481 palabras en los capítulos 1 a 14, 78 referencias y 11 marcadores «Confirmar». |
| Memoria diseñada | [Memoria en 1920 × 1080](../08_memoria/memoria-1920x1080/README.md) | PDF de 62 páginas e IDML para Affinity, con sus tipografías. Se genera con `node construir-idml.js`. Reemplaza a la [versión en A3](../08_memoria/memoria-a3/README.md). |
| Memoria enviada al profesor el 30 de octubre | Fuera del repositorio | PDF de 58 páginas, para revisión y no como entrega oficial. Su texto no coincide con el borrador v6 del repositorio: ver la sección 5. |
| Anexos A a I | [Anexos](../08_memoria/anexos/README.md) | Regenerados el 28 de octubre. Se rehacen con `node construir-anexos.js` cuando cambia una fuente. |
| Aplicación | [Android](../06_desarrollo_y_factibilidad/app-android/README.md) | La 2.33 para la prueba y la 3.3 en `main` (D-138), sin cambios desde el 20 de octubre. El [estudio de los textos](../06_desarrollo_y_factibilidad/app-android/textos/README.md) es del 24 de octubre. |
| Prueba en los hogares | [Protocolo 02](../07_validacion/protocolo-02-prueba-21-dias.md) e [instrumento de cierre](../07_validacion/instrumentos/instrumento-de-cierre-2026-10-28.md) | Tres personas: dos semanas con el Tag desde el 7 de octubre y una con la señal solo en el teléfono desde el 21. El cierre estaba previsto para el 30 de octubre, en papel (D-144). Los datos en `datos_sensibles/` llegan al 20 de octubre. |
| Objeto propio | [Testigo para impresión 3D](../06_desarrollo_y_factibilidad/testigo-impresion-3d/README.md) | Versión 0 (D-143), con tres proyectos de Bambu Studio listos. Las medidas de la placa del Tag son supuestas y no se ha impreso. |
| Presupuesto | [Presupuesto de Relevo](../06_desarrollo_y_factibilidad/presupuesto-2026-10-27.md) | Cerrado el 27 de octubre. Faltan las cotizaciones de serie corta, que piden el objeto terminado. |
| Documentos de la Universidad | [Documentos institucionales](../01_contexto_y_fuentes/documentos_institucionales/README.md) | Calendario, instructivos, pauta, matriz y logos (D-142). |
| Uso de inteligencia artificial | [Uso de IA](uso-de-ia-2026-10-27.md) y [registro de pedidos](registro-de-pedidos-a-la-ia.md) | Codex y Claude Code. |
| Tareas | [Por hacer](por-hacer.md) | En `main` llegan hasta la tarea 10. Las tareas 11 a 14 están en ramas (sección 2). |
| Decisiones | [Registro de decisiones](../09_decisiones/registro-de-decisiones.md) | La última es D-152; la siguiente es D-153. |
| Riesgos | [Registro de riesgos](registro-de-riesgos.md) | Al 25 de octubre. |

## 2. Trabajo que no está en `main`

Las cinco ramas parten del mismo commit de `main` (`c213b28`) y están abiertas en GitHub como solicitudes de cambio (PR) en borrador. Ninguna borra archivos.

| PR | Rama | Fechas y commits | Qué contiene |
| --- | --- | --- | --- |
| [#15](https://github.com/joan1542003-byte/proyecto-titulo/pull/15) | `tarea-11-pregunta-de-investigacion` | 30 de octubre, 3 | En Por hacer: la tarea 11 (la pregunta y las «dos partes» que se le atribuyen, con tres soluciones), la 12 (lo que hay que corregir en el PDF enviado el 30 de octubre) y la 13 (el camino a la nota máxima, con calendario y nota estimada por bloque). |
| [#16](https://github.com/joan1542003-byte/proyecto-titulo/pull/16) | `alinear-pregunta-archivos-satelite` | 30 de octubre, 1 | La nueva redacción de la pregunta, que el autor aprobó el 30 de octubre, llevada al resumen vigente, al Anexo I, a la guía de comunicación y al protocolo 02. No toca la memoria: el autor aplica el cambio en ella. |
| [#17](https://github.com/joan1542003-byte/proyecto-titulo/pull/17) | `decisiones-de-diseno` | 2 de noviembre, 1 | El [documento 43](https://github.com/joan1542003-byte/proyecto-titulo/blob/decisiones-de-diseno/10_recursos_visuales/43_decisiones-de-diseno-2026-11-02.md): cada decisión de diseño explicada y verificada contra el código y las fuentes, las incoherencias entre documentos, cómo defender cada decisión y lo que falta. |
| [#18](https://github.com/joan1542003-byte/proyecto-titulo/pull/18) | `fuentes-de-la-memoria` | 2 de noviembre, 2 | El estado de las 78 referencias, la verificación de las 40 citas de los capítulos 1 a 6, la fundamentación de esos capítulos con el texto propuesto para cada cambio y la tarea 14 de Por hacer. Los textos de las fuentes quedan en una carpeta local que no se sube, por derechos de autor. |
| [#19](https://github.com/joan1542003-byte/proyecto-titulo/pull/19) | `claude/funny-bohr-yvmki9` | 2 y 3 de noviembre, 25 | Entrevistas a expertos: cinco perfiles en Chile, guía, un guion por persona, correos, material para mostrar y un video de 53 segundos que no se envió. Además, la comparación con otra memoria del taller, que devuelve el subcriterio 8.1 de la matriz a «en desarrollo». |

Esta actualización vive en la rama `estado-del-proyecto-2026-11-04` y solo toca documentos: este estado, el README, el traspaso, los índices de gobernanza y el registro de pedidos.

### Choques al fusionar

Se midieron el 4 de noviembre con `git merge-tree`, rama contra rama:

- **Registro de pedidos:** todas las ramas agregan filas al final de la misma tabla, así que chocan entre sí. Ninguna borra filas. Al resolver, se conservan las filas de los dos lados, en orden de fecha.
- **Por hacer:** chocan #15 (tareas 11 a 13), #18 (tarea 14) y #19 (una línea de la tarea 10). Los números no se repiten, así que se conserva todo y los registros de cambios se ordenan por fecha.
- **El resto de los archivos:** sin choques.

**Orden sugerido:** por fecha, #15, #16, #17, #18 y #19, y al final esta rama. Después de cada fusión, comprobar que el registro de pedidos tenga tantas filas como sumaban las dos versiones (`grep -c '^| ' 00_gobernanza/registro-de-pedidos-a-la-ia.md`).

**Mientras tanto:** si #16 entra antes de que el autor cambie la pregunta en la memoria, el resumen vigente, el Anexo I, la guía y el protocolo 02 dirán la redacción nueva, y la memoria, la anterior.

### Otras ramas

- **#12 (`claude/wizardly-ptolemy-5u3fl6`, 29 de septiembre) y #13 (`claude/trusting-fermi-axbp2m`, 9 de octubre):** borradores antiguos, con un commit cada uno, que quedaron 185 y 101 commits atrás de `main`. La #13 usa los números D-121 y documento 38, que hoy son de «Relevo con aura». La tarea 9 de Por hacer mantiene abierta la decisión de cerrarlas o rescatar algo de ellas.
- **`android-2.31`, `android-2.32` y `android-2.33`:** el código de las versiones que usó la prueba. Sus arreglos ya están en `main` sobre la 3.3. Se conservan como registro y no se fusionan.
- **`android-2.7`:** la rama de trabajo hasta el 29 de octubre. En GitHub quedó en `ffbba78`, ocho commits atrás de `main`, sin trabajo propio.

## 3. Lo que ya existe: no hay que rehacerlo

- **Objeto:** el [modelo paramétrico](../06_desarrollo_y_factibilidad/testigo-impresion-3d/testigo.py), las cinco piezas, los [proyectos de Bambu Studio](../06_desarrollo_y_factibilidad/testigo-impresion-3d/imprimir/bambu/) y las instrucciones de impresión y armado. Falta lo que solo puede hacer el autor: medir la placa ([`medidas.json`](../06_desarrollo_y_factibilidad/testigo-impresion-3d/medidas.json)), imprimir y probar. Los pasos están en la tarea 13, punto A (#15).
- **Cierre de la prueba:** el [instrumento](../07_validacion/instrumentos/instrumento-de-cierre-2026-10-28.md) con su [PDF](../07_validacion/instrumentos/instrumento-de-cierre.pdf) (D-144) y [`unir-datos.js`](../07_validacion/analisis/), que une la base remota, las copias del teléfono y lo respondido en papel.
- **Presupuesto:** hecho (tarea 5).
- **Pantallas y textos de la app:** las 39 pantallas de la 2.32 en *wireframes* (Anexo F) y el [inventario y estudio de los textos](../06_desarrollo_y_factibilidad/app-android/textos/README.md) (tarea 3).
- **Generadores:** la memoria en 1920 × 1080 y los anexos se rehacen solos desde sus fuentes.
- **Decisiones de diseño explicadas:** el documento 43 (#17). Es la base para el párrafo «por qué Apple y no Material Design» y para las respuestas a la comisión (tarea 12, puntos C y H).
- **Fundamentación de los capítulos 1 a 6:** el texto de cada cambio ya está escrito en la fundamentación (#18). Falta aplicarlo, no redactarlo de nuevo.
- **Entrevistas a expertos:** guiones y correos listos (#19).
- **Revisión del PDF del 30 de octubre:** la lista de marcas, fallas del generador y erratas, con su solución (tarea 12, #15).

## 4. Pendientes que aparecen en más de una lista

Son una sola tarea cada uno, aunque aparezcan en varios lugares.

| Pendiente | Dónde aparece | Cómo tratarlo |
| --- | --- | --- |
| Resultados de la semana con el teléfono | Tareas 6 y 8; tarea 12, punto C; tarea 13, punto B | Una sola vez, con los pasos de la tarea 13, punto B. |
| Imprimir el objeto, medir su sonido y hacer los planos | Tarea 4; tarea 13, punto A; documento 43, sección 16 | Con los pasos de la tarea 13, punto A. |
| Los límites de la pauta de entrevistas | Tarea 12, punto C; tarea 13, punto C1 | Un mismo párrafo del capítulo 7. |
| Qué aportó la investigación a través del diseño | Tarea 12, punto C; tarea 13, punto D3 | Un mismo párrafo del capítulo 10. |
| Por qué Apple y no Material Design | Tarea 12, puntos C y H | Un párrafo del capítulo 11, apoyado en el documento 43, sección 6.2. |
| Autorización de las fotos y revisión ética | Tareas 2 y 9; tarea 12, punto G; tarea 13, puntos E3 y E4 | Una consulta a la Escuela y una autorización escrita por foto. |
| Cambios de la app tras la prueba | Tarea 10; Tabla 4 de la v6; documento 43, sección 16 | Una lista. El documento 43 suma las áreas táctiles de 48 dp. |
| Color sin promedios | Tarea 10; documento 43, sección 13 | La v6 ya está corregida; faltan el documento 42, el Anexo H y la Figura 16. |
| Las 1000 palabras que faltan para el mínimo | Tarea 12, punto C; tarea 14, puntos B a D | La tarea 14 aporta unas 650 en lugares que pide la pauta. |
| Erratas | Tarea 12, punto D; tarea 14 | Ya separadas: la tarea 14 solo agrega las que la 12 no tiene. |
| Párrafo de autoría en «Uso de inteligencia artificial» | Tarea 12, puntos C y G | Falta en el PDF enviado; el borrador v6 del repositorio todavía lo tiene. |

**Issues de GitHub abiertas:** #4, #8, #9, #10 y #14. El título de la #10 («testigo portátil con luz y sonido») ya no calza con la decisión de no usar luz (D-070 y D-143). La #14 (tarea 1, el tono) se trabajó sobre la v5, y la v6 reescribió ese texto. Cerrarlas o renombrarlas lo decide el autor.

## 5. Por aclarar con el autor

Son observaciones, no conclusiones.

1. **La versión de la memoria que se está editando.** El PDF enviado el 30 de octubre tiene cosas que el borrador v6 del repositorio no tiene: resaltados, texto tachado, notas como «EN DESARROLLO», erratas y la frase «Está decidiendo por mi». Además, según la tarea 14, la Introducción tiene 492 palabras y la Justificación 220; en el borrador v6 del repositorio tienen 627 y 325. Las tareas 12 y 14 se midieron sobre ese PDF. Antes de aplicarlas hay que saber dónde está la versión editada y cuál es la base.
2. **El cierre de la prueba del 30 de octubre:** si se aplicó el instrumento y dónde están sus respuestas y la última exportación de las tres personas.
3. **La pregunta de investigación:** la redacción nueva está aprobada desde el 30 de octubre, pero el borrador v6 tiene la anterior. Falta decidir en qué versión se aplica.
4. **Las entrevistas a expertos:** qué pasó después del 3 de noviembre con Parada, Parra y Zamorano.
5. **El objeto:** si se midió la placa o se imprimió algo después del 28 de octubre.

## 6. Fechas

Cierre interno el 15 de noviembre, Pase el 25 de noviembre, memoria el 2 de diciembre antes de las 12:00 y exámenes del 14 al 18 de diciembre ([calendario oficial](calendario-oficial-segundo-semestre-2026.md)). El calendario de la tarea 13 (#15) dejaba el objeto para el 31 de octubre al 2 de noviembre y el cierre de los datos para el 3 al 7 de noviembre.

## 7. Después del corte (5 de noviembre)

El 5 de noviembre se fusionó `main` (`f34f668`) en esta rama. Solo chocó el registro de pedidos, y se conservaron las filas de los dos lados.

| Qué | Dónde | Qué cambia en este estado |
| --- | --- | --- |
| Memoria, D-153 y D-154 (4 de noviembre, noche) | `main` | El [borrador v6](../08_memoria/borrador-memoria-v6-2026-10-28.md) recoge las ediciones del PDF del 30 de octubre, la pregunta aprobada y las tareas 11 a 14. Después usa los términos de los autores, cuenta lo logrado y suma el análisis visual del documento 43. Tiene 16 478 palabras en los capítulos, 82 referencias y 2 marcadores «Confirmar». El PDF y el IDML no se regeneraron. Quedan resueltos los puntos 1 y 3 de la sección 5. |
| App 4.0 a 4.3, D-155 a D-158 (5 de noviembre) | Rama `android-4.0-rediseno`, en GitHub, sin PR | Otra sesión rediseñó la app desde la 3.3: papel y tinta, actividades en anillos y sin aura. Suma varios relevos a la vez, sugerencias según lo que se escribe y sonidos a elección. Conserva la prueba de 21 días y el consentimiento v13. Su APK se instala aparte, como «Relevo 4.3». |
| App 1.0.0 (4 de noviembre) | Rama `android-1.0.0`, solo en el computador del autor | Quita la prueba de 21 días y pasa al consentimiento v14. Suma horas sin sonar y el teléfono como respaldo cuando el Tag no responde, y acorta la primera vez. El autor pidió dejarla local. La 4.3 no la incluye. Sus decisiones se numeraron D-153 y D-154, que en `main` ya son de la memoria: hay que renumerarlas antes de subirla. |
| Decisiones | [Registro de decisiones](../09_decisiones/registro-de-decisiones.md) | En `main` la última es D-154; en `android-4.0-rediseno`, D-158. La siguiente libre es D-159. |

## Registro de cambios (disclaimer)

### 2026-11-10 — La app en main

- **Qué cambió:** la nota del inicio dice que la app también entró a `main`.
- **Cómo estaba antes:** decía que la app y los íconos seguían aparte.
- **Por qué:** el autor pidió juntar también la app.

### 2026-11-10 — Fusión de los textos

- **Qué cambió:** una nota al inicio dice que las ramas de textos ya entraron a `main` y enlaza el registro de la fusión.
- **Cómo estaba antes:** decía que ninguna rama se fusionaba todavía.
- **Por qué:** el autor autorizó juntar los textos en `main`.

### 2026-11-05 — Fusión con main

- **Qué cambió:** se agregó la sección 7, con lo que entró al fusionar `main` (D-153 y D-154 de la memoria), las ramas de la app 4.3 y 1.0.0 y la siguiente decisión libre. Un aviso al inicio remite a ella.
- **Cómo estaba antes:** el estado describía `main` en `c213b28` y daba D-153 como la siguiente decisión.
- **Por qué:** el autor pidió fusionar la rama base en esta rama y resolver los choques. Sin esta sección, el estado habría quedado desactualizado frente a lo que trae la fusión.

### 2026-11-04 — Creación

- **Qué cambió:** se creó el estado al 4 de noviembre, con dónde está cada cosa, las cinco ramas sin fusionar y sus choques medidos, lo que ya existe, los pendientes que se repiten entre listas y lo que hay que aclarar con el autor.
- **Cómo estaba antes:** el estado más reciente era el del 25 de octubre, y el trabajo del 30 de octubre al 3 de noviembre solo se veía al abrir cada rama.
- **Por qué:** el autor pidió actualizar los documentos sin fusionar todavía a `main`, con trazabilidad de qué es cada cosa, para no perder trabajo ni repetir lo hecho.
