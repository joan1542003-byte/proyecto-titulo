# Anexos de la memoria v5

**Fecha:** 24 de octubre de 2026
**Documento principal:** [borrador v5 de la memoria](../borrador-memoria-v5-2026-10-11.md), sección «Anexos»

Los nueve anexos que nombra la memoria, armados desde los documentos del proyecto. Se leen de tres maneras:

- **[`anexos-relevo.pdf`](anexos-relevo.pdf):** el documento para entregar, en A4, con la línea de Relevo (papel, tinta, fichas de color e Instrument Sans), índice con páginas, marcadores, diagramas y láminas.
- **[`anexos-relevo.html`](anexos-relevo.html):** la misma composición, para abrir en el navegador.
- **Un Markdown por anexo:** para leer en GitHub, con sus imágenes, sus diagramas y enlaces a cada documento fuente.

## Los nueve anexos

| Anexo | Qué contiene | Fuentes |
| --- | --- | --- |
| [A. Entrevistas: pauta, corpus y análisis](anexo-a-entrevistas.md) | La pauta de 13 preguntas y sus condiciones, el corpus anonimizado P1–P8, el método, el libro de códigos, la reconstrucción de cada caso y la comparación entre casos. | `99_archivo/fuentes-locales/instrumentos`, `03_usuarios` |
| [B. Encuesta: 53 respuestas](anexo-b-encuesta.md) | Las 16 preguntas, el método, los recuentos y la codificación de cada respuesta, sin citas textuales. | `03_usuarios` |
| [C. Estado del arte y referentes](anexo-c-referentes.md) | El registro de la búsqueda, las fichas de los referentes y la exploración de patentes. | `04_mercado_y_referentes` |
| [D. Trazabilidad de los criterios de diseño](anexo-d-criterios.md) | Cada criterio con su evidencia, cómo lo aplica Relevo, lo que mostró la prueba al 19 de octubre y lo que sigue. | Capítulos 9, 11 y 13 de la memoria |
| [E. Uso de inteligencia artificial](anexo-e-ia.md) | La declaración, cómo cambió el proceso, la ficha para cada producción y el registro de pedidos del autor. | `00_gobernanza` |
| [F. Estados del ciclo y wireframes](anexo-f-estados.md) | Los 35 estados del ciclo con sus 14 láminas de agosto y los wireframes de las 39 pantallas de la app. | `05_propuesta_phygital`, `06_desarrollo_y_factibilidad` |
| [G. Prototipo Android y registro de versiones](anexo-g-android.md) | Capturas de la 3.3, el sistema completo, la app, los datos y el panel, y las versiones desde la 2.7. | `06_desarrollo_y_factibilidad` |
| [H. Identidad visual y sistema de marca](anexo-h-identidad.md) | El logo, las dos letras, los 72 íconos, el color y los cielos, con su fundamento; lo que se mantiene del 16 de septiembre y las propuestas anteriores. | `10_recursos_visuales` |
| [I. Protocolo de la prueba, consentimiento e instrumentos](anexo-i-prueba.md) | El protocolo de 21 días, la semana para comparar, el consentimiento vigente, las preguntas de la app y las fichas de registro. | `07_validacion`, código de la app |

## Cómo se arman

```bash
node construir-anexos.js
```

Escribe los nueve Markdown, el HTML y el PDF en esta carpeta, en unos 30 segundos. Con `--sin-pdf` solo escribe los Markdown y el HTML. Necesita Node 18 o posterior y Google Chrome.

- **Qué entra en cada anexo** está en [`contenido-anexos.js`](contenido-anexos.js): de qué documento sale cada parte y qué secciones toma, o el texto escrito para el anexo.
- **Los documentos fuente no se reescriben.** El constructor toma sus secciones tal como están, quita el historial de cambios de cada uno, ajusta los títulos y reescribe los enlaces desde esta carpeta. Para corregir un anexo se corrige su fuente y se vuelve a generar.
- **Lo que se calcula:** el registro de versiones sale del encabezado de cada documento de versión; el consentimiento, del código de la app, sin el correo del investigador; los cielos, de los colores que usa la app.
- **Tablas, figuras y referencias:** las tablas y figuras de cada fuente se numeran dentro del anexo (Tabla G1, Figura G2…). Cada anexo que cita obras cierra con sus referencias, tomadas de la memoria y de sus fuentes, en APA 7 y sin repetir.
- **Diagramas:** los de mermaid se guardan como SVG en [`imagenes/diagramas`](imagenes/diagramas). Solo un diagrama nuevo o cambiado necesita internet, porque mermaid se carga una vez desde jsDelivr.
- **Privacidad:** el constructor se detiene si un archivo de salida contiene un correo. No entra ningún dato de las personas participantes: solo recuentos que ya están en la memoria.

## Criterio de selección

Los anexos permiten comprobar cómo se obtuvo, organizó y tradujo cada antecedente de la memoria, y repetir la prueba. No repiten capítulos ni agregan resultados que la memoria no informa. Las imágenes de agosto son copias livianas de las láminas 4K de [`05_propuesta_phygital/wireframes-referencia-4k`](../../05_propuesta_phygital/wireframes-referencia-4k), y las capturas de la app vienen de la versión 3.3 en un teléfono Android.

## Lo que no entra

Queda en el repositorio como respaldo del proceso:

- informes de agentes, auditorías internas y versiones antiguas de la memoria;
- el código de la app, del panel y de las herramientas de diseño;
- los datos de la prueba, que están solo en `datos_sensibles/`, fuera del repositorio;
- el registro de decisiones completo, los documentos de coordinación y las exploraciones visuales descartadas, salvo su resumen en el Anexo H.

## Registro de cambios (disclaimer)

### 2026-10-24 — Anexos de la memoria v5

- **Qué cambió:** el índice pasa a los nueve anexos de la memoria v5, armados en Markdown, HTML y PDF por `construir-anexos.js`, con su contenido en `contenido-anexos.js` y sus imágenes en `imagenes/`.
- **Cómo estaba antes:** era el índice de la memoria v4, con cinco anexos que solo enlazaban a sus documentos.
- **Por qué:** el autor pidió terminar un pendiente de prioridad alta; la memoria v5 remite a nueve anexos que no estaban armados.

### 2026-08-27 — Creación y selección inicial

- **Cambio:** se definió un paquete de cinco anexos y se separó de la documentación interna del repositorio.
- **Versión anterior:** las fuentes metodológicas, el corpus, el análisis, el mercado y los wireframes estaban disponibles, pero no existía una selección para la entrega formal.
- **Motivo:** permitir que la memoria remita a evidencia verificable sin duplicar archivos ni adjuntar todo el proceso.
- **Alcance:** la selección corresponde al estado actual de la memoria v4; deberán añadirse protocolos y resultados únicamente después de ejecutar las pruebas.
