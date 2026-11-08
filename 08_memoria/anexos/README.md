# Anexos de la memoria

**Fecha:** 8 de noviembre de 2026
**Documento principal:** [borrador v6 de la memoria](../borrador-memoria-v6-2026-10-28.md), sección «Anexos»

Los nueve anexos que nombra la memoria. Cada uno recopila lo más relevante de los documentos del proyecto: decisiones y logros primero, los límites una sola vez. Se leen de cuatro maneras:

- **[`anexos-relevo.docx`](anexos-relevo.docx):** el Word, para editarlo o sumarlo a otro documento. Tiene el formato de la [pauta de tesis de la Biblioteca UDP](../../01_contexto_y_fuentes/pauta-biblioteca-tesis.md): carta, márgenes de 3,5 cm a la izquierda y 2,5 cm en los demás, Arial 12, interlineado 1,5 y el número de página centrado. Usa los estilos de título de Word, así que al pegarlo en otro documento los títulos toman los de ese documento. Al abrirlo, Word pregunta si actualiza los campos: con un sí, el índice queda con sus páginas.
- **[`anexos-relevo.pdf`](anexos-relevo.pdf):** el documento diseñado, en A4, con la línea de Relevo (papel, tinta, fichas de color e Instrument Sans), índice con páginas, marcadores, diagramas y láminas.
- **[`anexos-relevo.html`](anexos-relevo.html):** la misma composición, para abrir en el navegador.
- **Un Markdown por anexo:** para leer en GitHub. Es también la fuente de los otros tres.

## Los nueve anexos

| Anexo | Qué contiene |
| --- | --- |
| [A. Entrevistas: pauta, corpus y análisis](anexo-a-entrevistas.md) | La ficha y la pauta de 13 preguntas, la síntesis de las ocho entrevistas (P1–P8), el método, el libro de 23 códigos, cada caso y los dos tipos de usuario. |
| [B. Encuesta: 53 respuestas](anexo-b-encuesta.md) | Las 16 preguntas, el método, los recuentos, lo que tomó el diseño y la codificación de cada respuesta, sin citas textuales. |
| [C. Estado del arte y referentes](anexo-c-referentes.md) | La búsqueda, una ficha por referente del mapa del capítulo 8 y los prototipos y patentes con piezas parecidas. |
| [D. Trazabilidad de los criterios de diseño](anexo-d-criterios.md) | Cada criterio con su evidencia, cómo lo aplica Relevo, lo que mostró la prueba y lo que la app ya cambió. |
| [E. Uso de inteligencia artificial](anexo-e-ia.md) | Las herramientas, las cinco tareas en que ayudaron, lo que decidió el autor y los resguardos. |
| [F. Estados del ciclo y wireframes](anexo-f-estados.md) | Los 35 estados del ciclo de agosto, con sus láminas, y los wireframes de las 39 pantallas de la app. |
| [G. Prototipo Android y registro de versiones](anexo-g-android.md) | La app de la prueba, el Tag, los datos, la seguridad y el panel, y cada versión desde la 2.7 hasta la 4.6.3. |
| [H. Identidad visual y sistema de marca](anexo-h-identidad.md) | El logo, las dos letras, los 72 íconos y el color, cada uno con su fundamento, y las propuestas anteriores. |
| [I. Protocolo de la prueba, consentimiento e instrumentos](anexo-i-prueba.md) | La prueba aplicada, el protocolo de 21 días, la semana para comparar, el consentimiento, las preguntas de la app, la ficha de la sesión inicial y el instrumento de cierre. |

## Cómo se arman

```bash
node construir-anexos.js
```

Lee los nueve Markdown y escribe el HTML, el PDF y el Word en esta carpeta, en unos 40 segundos. Con `--sin-pdf` escribe solo el HTML y el Word. Necesita Node 18 o posterior y Google Chrome; no usa paquetes de npm.

- **Para corregir un anexo** se edita su Markdown y se vuelve a correr el constructor. El orden de los anexos, el color de su ficha y el resumen del índice están en [`contenido-anexos.js`](contenido-anexos.js), que explica también las convenciones del Markdown: tablas y figuras en APA 7, galerías, filas de grupo, diagramas y láminas.
- **El Word** lo escribe [`word.js`](word.js): un ZIP con las partes de Office Open XML, sin dependencias. Las láminas (logo, íconos, color y cielos) y los diagramas entran como imágenes, que Chrome fotografía una vez y quedan en [`imagenes/word`](imagenes/word); solo se rehacen si cambian.
- **Diagramas:** los de mermaid se guardan como SVG en [`imagenes/diagramas`](imagenes/diagramas). Solo un diagrama nuevo o cambiado necesita internet, porque mermaid se carga una vez desde jsDelivr.
- **Comprobaciones:** el constructor se detiene si un Markdown contiene un correo, si el título de un anexo no coincide con `contenido-anexos.js` o si el Word conserva alguna marca de Markdown.

## Criterio de selección

Los anexos permiten comprobar cómo se obtuvo, organizó y tradujo cada antecedente de la memoria, y repetir la prueba. No repiten capítulos ni agregan resultados que la memoria no informa. Los datos, las citas y los participantes son los del repositorio: el corpus P1–P8, la codificación de la encuesta, el consentimiento y las preguntas de la app se copian textuales. Las imágenes de agosto son copias livianas de las láminas 4K de [`05_propuesta_phygital/wireframes-referencia-4k`](../../05_propuesta_phygital/wireframes-referencia-4k), y las capturas de la app vienen de la versión 3.3 en un teléfono Android.

## Lo que no entra

Queda en el repositorio como respaldo del proceso:

- los documentos fuente completos, con su historial: el corpus, el libro de códigos con sus criterios de inclusión y exclusión, las fichas de mercado, los documentos técnicos y los protocolos;
- informes de agentes, auditorías internas y versiones antiguas de la memoria;
- el código de la app, del panel y de las herramientas de diseño;
- los datos de la prueba, que están solo en `datos_sensibles/`, fuera del repositorio;
- el registro de decisiones completo, el registro de pedidos a la IA y las exploraciones visuales descartadas, salvo su resumen en los anexos E y H.

## Registro de cambios (disclaimer)

### 2026-11-08 — Anexos recopilados y en Word

- **Qué cambió:** los nueve anexos se reescribieron como recopilaciones directas, alineadas con la memoria v6, y cada Markdown pasa a ser la fuente de su anexo. Se suma el Word, con el formato de la pauta de la Biblioteca, y el constructor lee los Markdown en vez de copiar los documentos fuente. El PDF pasa de 94 a 67 páginas.
- **Cómo estaba antes:** el constructor copiaba secciones completas de los documentos fuente, con sus advertencias y su historial; los anexos sumaban unas 37 000 palabras y no había versión en Word.
- **Por qué:** el autor pidió revisar todos los anexos y dejarlos listos para un documento de Word: directos, sin sobreexplicar, con su forma de escribir y con lo más relevante (D-168).

### 2026-10-24 — Anexos de la memoria v5

- **Qué cambió:** el índice pasa a los nueve anexos de la memoria v5, armados en Markdown, HTML y PDF por `construir-anexos.js`, con su contenido en `contenido-anexos.js` y sus imágenes en `imagenes/`.
- **Cómo estaba antes:** era el índice de la memoria v4, con cinco anexos que solo enlazaban a sus documentos.
- **Por qué:** el autor pidió terminar un pendiente de prioridad alta; la memoria v5 remite a nueve anexos que no estaban armados.

### 2026-08-27 — Creación y selección inicial

- **Cambio:** se definió un paquete de cinco anexos y se separó de la documentación interna del repositorio.
- **Versión anterior:** las fuentes metodológicas, el corpus, el análisis, el mercado y los wireframes estaban disponibles, pero no existía una selección para la entrega formal.
- **Motivo:** permitir que la memoria remita a evidencia verificable sin duplicar archivos ni adjuntar todo el proceso.
- **Alcance:** la selección corresponde al estado actual de la memoria v4; deberán añadirse protocolos y resultados únicamente después de ejecutar las pruebas.
