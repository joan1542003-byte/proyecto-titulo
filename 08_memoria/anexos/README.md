# Anexos de la memoria

**Fecha:** 8 de noviembre de 2026
**Documento principal:** [borrador v6 de la memoria](../borrador-memoria-v6-2026-10-28.md), sección «Anexos»

Los nueve anexos que nombra la memoria. Cada uno recopila lo más relevante de los documentos del proyecto: decisiones y logros primero, los límites una sola vez. Son un documento formal, sin diseño propio, con el formato de la [pauta de tesis de la Biblioteca UDP](../../01_contexto_y_fuentes/pauta-biblioteca-tesis.md):

- **[`anexos-relevo.docx`](anexos-relevo.docx):** el Word. Carta, márgenes de 3,5 cm a la izquierda y 2,5 cm en los demás, Arial 12, interlineado 1,5, texto negro y el número de página centrado abajo. La portada copia la de ejemplo de la Biblioteca UDP, con el logo de la Universidad y cada bloque a la misma altura: el título y el autor en mayúsculas, el título al que se opta, los profesores guía y la modalidad, la facultad y la escuela, y la ciudad y la fecha. Después del índice vienen el índice de tablas y el de figuras, que la pauta pide. Usa los estilos de título, índice y tabla de Word, así que al pegarlo en otro documento toma los de ese documento. Al abrirlo, Word pregunta si actualiza los campos: con un sí, el índice queda con las páginas que calcula Word.
- **[`anexos-relevo.pdf`](anexos-relevo.pdf):** el mismo Word, exportado a PDF, con las páginas en el índice.
- **Un Markdown por anexo:** para leer en GitHub. Es también la fuente de los otros dos.

## Los nueve anexos

| Anexo | Qué contiene |
| --- | --- |
| [A. Entrevistas: pauta, corpus y análisis](anexo-a-entrevistas.md) | La ficha y la pauta de 13 preguntas, la síntesis de las ocho entrevistas (Persona 1 a Persona 8), el método, el libro de 23 códigos, cada caso y los dos tipos de usuario. |
| [B. Encuesta: 53 respuestas](anexo-b-encuesta.md) | Las 16 preguntas, el método, los recuentos, lo que tomó el diseño y la codificación de cada respuesta, sin citas textuales. |
| [C. Estado del arte y referentes](anexo-c-referentes.md) | La búsqueda, una ficha por referente del mapa del capítulo 8 y los prototipos y patentes con piezas parecidas. |
| [D. Trazabilidad de los criterios de diseño](anexo-d-criterios.md) | Cada criterio con su evidencia, cómo lo aplica Relevo, lo que mostró la prueba y lo que la app ya cambió. |
| [E. Uso de inteligencia artificial](anexo-e-ia.md) | Las herramientas, las cinco tareas en que ayudaron y lo que hizo el autor. |
| [F. Estados del ciclo y *wireframes*](anexo-f-estados.md) | Los 35 estados del ciclo de agosto, con sus *wireframes*, y los *wireframes* de las 39 pantallas de la app. |
| [G. Prototipo Android y registro de versiones](anexo-g-android.md) | La app de la prueba, el Tag, los datos, la seguridad y el panel, cada versión desde la 2.7 hasta la 4.6.3 y las palabras clave con que la app reconoce cada actividad. |
| [H. Identidad visual y sistema de marca](anexo-h-identidad.md) | El logo, las dos tipografías, los 72 íconos y la paleta cromática, cada uno con su fundamento, y las propuestas anteriores. |
| [I. Protocolo de la prueba, consentimiento e instrumentos](anexo-i-prueba.md) | La prueba aplicada, el protocolo de 21 días, la semana para comparar, el consentimiento, las preguntas de la app, la ficha de la sesión inicial y el instrumento de cierre. |

## Cómo se arman

```bash
node construir-anexos.js
```

Lee los nueve Markdown y escribe el Word y el PDF en esta carpeta, en menos de un minuto. Con `--sin-pdf` escribe solo el Word. Necesita Node 18 o posterior y Google Chrome y, para el PDF, LibreOffice y `pdftotext` (Poppler); no usa paquetes de npm.

- **Cómo se escriben:** sin códigos internos —las personas son Persona 1 a Persona 8; las preguntas y las respuestas, su número— y sin mencionar el repositorio, sus carpetas ni sus archivos (D-170).
- **Para corregir un anexo** se edita su Markdown y se vuelve a correr el constructor. El orden y el título de los anexos están en [`contenido-anexos.js`](contenido-anexos.js), que explica también las convenciones del Markdown: tablas y figuras en APA 7, galerías, filas de grupo, diagramas y figuras de la identidad.
- **El Word** lo escribe [`word.js`](word.js): un ZIP con las partes de Office Open XML, sin dependencias. Los datos de la portada salen de la portada de la memoria v6, y el logo de la Universidad, [`imagenes/logo-udp-biblioteca.png`](imagenes/logo-udp-biblioteca.png), se recortó a 600 ppp de la [portada de ejemplo de la Biblioteca](../../01_contexto_y_fuentes/documentos_institucionales/biblioteca-portada-ejemplo.pdf). Los índices de tablas y de figuras se arman con los rótulos de cada pieza, y sus páginas, como las del índice, salen del PDF.
- **El PDF** lo exporta LibreOffice desde el Word. `pdftotext` lee en qué página quedó cada título, y el constructor arma el Word otra vez con esas páginas en el índice, hasta que no cambian.
- **Figuras:** los diagramas y las figuras de la identidad (logo, íconos, color y cielos) entran como imágenes, en Arial y negro sobre blanco. Chrome las fotografía una vez y quedan en [`imagenes/word`](imagenes/word); solo se rehacen si cambian.
- **Diagramas:** los de mermaid se guardan como SVG en [`imagenes/diagramas`](imagenes/diagramas). Solo un diagrama nuevo o cambiado necesita internet, porque mermaid se carga una vez desde jsDelivr.
- **Comprobaciones:** el constructor se detiene si un Markdown contiene un correo, si el título de un anexo no coincide con `contenido-anexos.js` o si el Word conserva alguna marca de Markdown.

## Criterio de selección

Los anexos permiten comprobar cómo se obtuvo, organizó y tradujo cada antecedente de la memoria, y repetir la prueba. No repiten capítulos ni agregan resultados que la memoria no informa. Los datos, las citas y los participantes son los del proyecto: el corpus de las ocho entrevistas, la codificación de la encuesta, el consentimiento y las preguntas de la app se copian textuales. Las imágenes de agosto son copias livianas de los wireframes 4K de [`05_propuesta_phygital/wireframes-referencia-4k`](../../05_propuesta_phygital/wireframes-referencia-4k), y las capturas de la app vienen de la versión 3.3 en un teléfono Android.

## Lo que no entra

Queda en el repositorio como respaldo del proceso:

- los documentos fuente completos, con su historial: el corpus, el libro de códigos con sus criterios de inclusión y exclusión, las fichas de mercado, los documentos técnicos y los protocolos;
- informes de agentes, auditorías internas y versiones antiguas de la memoria;
- el código de la app, del panel y de las herramientas de diseño;
- los datos de la prueba, que están solo en `datos_sensibles/`, fuera del repositorio;
- el registro de decisiones completo, el registro de pedidos a la IA y las exploraciones visuales descartadas, salvo su resumen en los anexos E y H.

## Registro de cambios (disclaimer)

### 2026-11-08 — Portada de la Biblioteca, índices y palabras clave

- **Qué cambió:** la portada copia la de ejemplo de la Biblioteca UDP, con su logo y sus alturas; se suman el índice de tablas y el de figuras, y el Anexo G suma las palabras clave de la app (G.6).
- **Cómo estaba antes:** la portada llevaba el logo de la Escuela de Diseño, con otras distancias, y no había índices de tablas ni de figuras.
- **Por qué:** el autor pidió una portada copiada de una referencia de la UDP, sumar las palabras clave de la app y corregir los errores de formato (D-170).

### 2026-11-08 — Repreguntas y terminología de diseño

- **Qué cambió:** el índice describe el Anexo H con «las dos tipografías» y «la paleta cromática».
- **Cómo estaba antes:** decía «las dos letras» y «el color».
- **Por qué:** el autor pidió poner bien las repreguntas y hablar de lo visual con terminología de diseñador: tipografía y paleta cromática, no letras, fuentes ni texto (D-170).

### 2026-11-08 — Correcciones del autor

- **Qué cambió:** el índice nombra a las personas como Persona 1 a Persona 8, describe el Anexo E corregido y los wireframes de agosto, y suma cómo se escriben los anexos: sin códigos y sin mencionar el repositorio.
- **Cómo estaba antes:** hablaba de P1–P8, de las láminas de agosto y de los resguardos del Anexo E.
- **Por qué:** el autor revisó los anexos y los corrigió (D-170).

### 2026-11-08 — Anexos formales, sin diseño

- **Qué cambió:** los anexos son un documento formal. El Word sigue la pauta de la Biblioteca, en negro y con los estilos de Word, y su portada es la de la pauta, con el logo de la Escuela de Diseño. El PDF es el mismo Word exportado, con las páginas en el índice, y los diagramas y las figuras de la identidad pasan a Arial, negro sobre blanco. Se retiran el HTML y el PDF diseñado (D-169).
- **Cómo estaba antes:** el HTML y el PDF tenían la línea de Relevo —papel, tinta, fichas de color e Instrument Sans— y una portada de marca con el logo de Relevo; el Word repetía esa portada y tenía tablas con fondo de color y figuras sobre fondo papel.
- **Por qué:** el autor pidió que los anexos no se diseñen: son formales, como un documento común, según las pautas de la universidad y con el logo de la universidad.

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
