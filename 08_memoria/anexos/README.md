# Anexos de la memoria

**Fecha:** 24 de noviembre de 2026
**Documento principal:** [borrador v7 de la memoria](../borrador-memoria-v7-2026-11-11.md), sección «Anexos»
**Versión:** los Markdown copian el texto del PDF de anexos que el autor entregó para el Pase (127 páginas), con sus errores; los errores y las mejoras están en la [tarea 15 de Por hacer](../../00_gobernanza/por-hacer.md#15-errores-y-mejoras-de-la-memoria-y-los-anexos-del-pase). Desde el 24 de noviembre suman las pantallas de la versión 4.7.2 (Anexo F), las variantes del logo (Anexo H) y la pregunta de investigación de la memoria v8 (Anexo I).

Los nueve anexos que nombra la memoria. Cada uno recopila lo más relevante de los documentos del proyecto: decisiones y logros primero, los límites una sola vez. Son un documento formal, sin diseño propio, con el formato de la [pauta de tesis de la Biblioteca UDP](../../01_contexto_y_fuentes/pauta-biblioteca-tesis.md):

- **[`anexos-relevo.docx`](anexos-relevo.docx):** el Word. Carta, márgenes de 3,5 cm a la izquierda y 2,5 cm en los demás, Arial 12, interlineado 1,5, texto negro y el número de página centrado abajo. La portada sigue la pauta de la Biblioteca UDP, con el logo de la Universidad arriba y los datos en tres grupos: el título, en negrita, con su subtítulo y «Anexos»; el autor en mayúsculas, el título al que se opta y los profesores guía con la modalidad, y, al pie, la facultad y la escuela en mayúsculas, con la ciudad y el año en Arial 11. Después del índice vienen el índice de tablas y el de figuras, que la pauta pide. Usa los estilos de título, índice y tabla de Word, así que al pegarlo en otro documento toma los de ese documento. Al abrirlo, Word pregunta si actualiza los campos: con un sí, el índice queda con las páginas que calcula Word.
- **[`anexos-relevo.pdf`](anexos-relevo.pdf):** el mismo Word, exportado a PDF, con las páginas en el índice.
- **Estado:** el Word y el PDF se regeneraron el 25 de noviembre de 2026 con los Markdown de esta carpeta, en 135 páginas: el texto del Pase, los primeros conceptos de Relevo (Anexo F), las pantallas de la 4.7.2, los íconos de Lucide de la 4.8.2 y las variantes del logo (Anexo H) y la pregunta de investigación vigente (Anexo I).
- **Un Markdown por anexo:** para leer en GitHub. Es también la fuente de los otros dos.

## Los nueve anexos

| Anexo | Qué contiene |
| --- | --- |
| [A. Entrevistas: pauta, corpus y análisis](anexo-a-entrevistas.md) | La ficha y la pauta de 13 preguntas, la síntesis de las ocho entrevistas (Persona 1 a Persona 8), el método, el libro de 23 códigos, cada caso y los dos tipos de usuario. |
| [B. Encuesta: 53 respuestas](anexo-b-encuesta.md) | Las 16 preguntas, el método, los recuentos, lo que tomó el diseño y la codificación de cada respuesta, sin citas textuales. |
| [C. Estado del arte y referentes](anexo-c-referentes.md) | La búsqueda, una ficha por referente del mapa del capítulo 8 y los prototipos y patentes con piezas parecidas. |
| [D. Trazabilidad de los criterios de diseño](anexo-d-criterios.md) | Cada criterio con su evidencia, cómo lo aplica Relevo, lo que mostró la prueba y lo que la app ya cambió. |
| [E. Uso de inteligencia artificial](anexo-e-ia.md) | Las tres herramientas, las cinco tareas en que ayudaron y el trabajo propio. |
| [F. Estados del ciclo y *wireframes*](anexo-f-estados.md) | Los 35 estados del ciclo de agosto, con sus *wireframes*; los bocetos del primer uso con los *wireframes* de las 39 pantallas de la app, y 18 capturas de la versión 4.7.2, la más reciente. |
| [G. Prototipo Android y registro de versiones](anexo-g-android.md) | Cómo funciona la app que se usó en la prueba, qué datos guarda y cómo los cuida, cómo cambió entre septiembre y noviembre de 2026 y con qué palabras reconoce cada actividad. |
| [H. Identidad visual y sistema de marca](anexo-h-identidad.md) | El logo, con sus bocetos, su construcción y sus variantes del 23 de noviembre, las dos tipografías, los 118 íconos, comparados con Lucide, y la paleta cromática, cada uno con su fundamento, y las propuestas anteriores. |
| [I. Protocolo de la prueba, consentimiento e instrumentos](anexo-i-prueba.md) | La prueba aplicada, el protocolo de 21 días, la semana para comparar, el consentimiento, las preguntas de la app, la ficha de la sesión inicial y el instrumento de cierre. |

## Cómo se arman

```bash
node construir-anexos.js
```

Lee los nueve Markdown y escribe el Word y el PDF en esta carpeta, en menos de un minuto. Con `--sin-pdf` escribe solo el Word. Necesita Node 18 o posterior y Google Chrome y, para el PDF, LibreOffice y `pdftotext` (Poppler); no usa paquetes de npm. La ruta de Chrome del constructor es la de Windows: en otro sistema, Chrome solo hace falta cuando cambia un diagrama o una figura de la identidad.

- **Cómo se escriben:** sin códigos internos —las personas son Persona 1 a Persona 8; las preguntas y las respuestas, su número— y sin mencionar el repositorio, sus carpetas ni sus archivos (D-170).
- **Para corregir un anexo** se edita su Markdown y se vuelve a correr el constructor. El orden y el título de los anexos están en [`contenido-anexos.js`](contenido-anexos.js), que explica también las convenciones del Markdown: tablas y figuras en APA 7, galerías, filas de grupo, diagramas y figuras de la identidad.
- **El Word** lo escribe [`word.js`](word.js): un ZIP con las partes de Office Open XML, sin dependencias. Los datos de la portada salen de la portada de la memoria v6, y el logo de la Universidad, [`imagenes/logo-udp-biblioteca.png`](imagenes/logo-udp-biblioteca.png), se recortó a 600 ppp de la [portada de ejemplo de la Biblioteca](../../01_contexto_y_fuentes/documentos_institucionales/biblioteca-portada-ejemplo.pdf). Los índices de tablas y de figuras se arman con los rótulos de cada pieza, y sus páginas, como las del índice, salen del PDF.
- **El PDF** lo exporta LibreOffice desde el Word. `pdftotext` lee en qué página quedó cada título, y el constructor arma el Word otra vez con esas páginas en el índice, hasta que no cambian.
- **Figuras:** los diagramas y las figuras de la identidad (el logo y su construcción, los íconos, la paleta cromática y los degradados) entran como imágenes, en Arial y negro sobre blanco. Chrome las fotografía una vez y quedan en [`imagenes/word`](imagenes/word); solo se rehacen si cambian.
- **Diagramas:** los de mermaid se guardan como SVG en [`imagenes/diagramas`](imagenes/diagramas). Solo un diagrama nuevo o cambiado necesita internet, porque mermaid se carga una vez desde jsDelivr.
- **Comprobaciones:** el constructor se detiene si un Markdown contiene un correo, si el título de un anexo no coincide con `contenido-anexos.js` o si el Word conserva alguna marca de Markdown.

## Criterio de selección

Los anexos permiten comprobar cómo se obtuvo, organizó y tradujo cada antecedente de la memoria, y repetir la prueba. No repiten capítulos ni agregan resultados que la memoria no informa. Los datos, las citas y los participantes son los del proyecto: el corpus de las ocho entrevistas, la codificación de la encuesta, el consentimiento y las preguntas de la app se copian textuales. Las imágenes de agosto son copias livianas de los wireframes 4K de [`05_propuesta_phygital/wireframes-referencia-4k`](../../05_propuesta_phygital/wireframes-referencia-4k), y las capturas de la app vienen de la versión 3.3, en un teléfono Android, y de la 4.7.2, en un teléfono Android emulado y con un perfil de prueba.

## Lo que no entra

Queda en el repositorio como respaldo del proceso:

- los documentos fuente completos, con su historial: el corpus, el libro de códigos con sus criterios de inclusión y exclusión, las fichas de mercado, los documentos técnicos y los protocolos;
- informes de agentes, auditorías internas y versiones antiguas de la memoria;
- el código de la app, del panel y de las herramientas de diseño;
- los datos de la prueba, que están solo en `datos_sensibles/`, fuera del repositorio;
- el registro de decisiones completo, el registro de pedidos a la IA y las exploraciones visuales descartadas, salvo su resumen en los anexos E y H.

## Registro de cambios (disclaimer)

### 2026-11-25 — Primeros conceptos, íconos de Lucide y Chrome en el Mac

- **Qué cambió:** el Anexo F suma los primeros conceptos y dos pantallas de la primera versión de la app; el Anexo H, los íconos de Lucide de la 4.8.2; el Anexo C nombra sus tres obras fundacionales, y el Anexo G, la versión 4.8. El constructor busca Chrome también en el Mac y en Linux. El Word y el PDF se regeneraron.
- **Cómo estaba antes:** el constructor solo buscaba Chrome en Windows, y los anexos tenían 132 páginas.
- **Por qué:** el autor pidió sumar los primeros conceptos y llevar los íconos de la 4.8.2 a los anexos (D-192).

### 2026-11-24 — Pantallas de la 4.7.2, variantes del logo y Word y PDF al día

- **Qué cambió:** el Anexo F suma «F.4 Pantallas de la aplicación 4.7.2», con las 18 capturas de la versión 4.7.2 (Figuras F8 a F10); el Anexo H suma las variantes del logo del 23 de noviembre (Figura H6), y sus figuras siguientes pasan a H7–H11; la Figura G4 vuelve a mostrar sus capturas, y el Anexo I cita la pregunta de investigación de la memoria v8. Las imágenes nuevas están en `imagenes/`: `app-4.7.2-pantalla-*.jpg` y `logo-variantes-2026-11-23-parte-*.png`. El Word y el PDF se regeneraron con todos los Markdown: el PDF pasa a 132 páginas. Se armaron en un Mac, con una copia parcial del repositorio que no tiene el código de la app ni los archivos del logo; como ninguna figura de la identidad cambió, se usaron las imágenes guardadas en `imagenes/word`, también la de los degradados, que el constructor arma leyendo el código de la app. Al terminar, el constructor borró, como siempre, cinco imágenes que ningún anexo usa desde el Pase: las láminas de la construcción del logo, los íconos y la paleta y un diagrama, en `imagenes/word` y `imagenes/diagramas`. El índice de anexos describe lo nuevo, las capturas nombran sus dos versiones y se anota que la ruta de Chrome del constructor es la de Windows.
- **Cómo estaba antes:** el Word y el PDF eran del 9 y el 10 de noviembre y no tenían el texto del Pase; el Anexo F no mostraba la app actual, y el Anexo H no tenía las variantes del logo.
- **Por qué:** el autor pidió agregar todas las pantallas de la app y avisó que se agregaron variantes al logo de Relevo.

### 2026-11-18 — Texto del PDF de anexos del Pase

- **Qué cambió:** los nueve Markdown pasan al texto del PDF de anexos que el autor entregó para el Pase, con sus errores: cambian la redacción de buena parte de los anexos E, G y H, algunas tablas y figuras, y los títulos de E.3, G.1, G.4, G.5 y H.7. Las figuras nuevas o que cambiaron se extrajeron del PDF a `imagenes/` (las que empiezan con «pase-»); los bocetos del logo son los de la Figura 19 de la memoria. El documento principal pasa al borrador v7, y se anota que el Word y el PDF de esta carpeta siguen siendo los del 9 y el 10 de noviembre.
- **Cómo estaba antes:** los Markdown tenían la versión del 10 de noviembre, y el documento principal era el borrador v6.
- **Por qué:** el autor pidió que el repositorio coincida con la memoria y los anexos en PDF del Pase. Antes de guardarlos se comprobó, en una copia aparte, que el constructor arma con ellos un documento cuyo texto coincide en un 99,97 % con el del PDF del Pase; esa copia no se guardó porque en la nube no está Arial y la lámina de los degradados habría salido con otra letra.

### 2026-11-10 — Versión 4.7.2 y resultados

- **Qué cambió:** el Anexo G llega a la versión 4.7.2, con sus pantallas, y el Anexo I suma la entrevista según la guía y los resultados por persona.
- **Cómo estaba antes:** el Anexo G llegaba a la 4.6.3.
- **Por qué:** el autor entregó los datos finales de la prueba y pidió capturas de la versión más reciente.

### 2026-11-09 — Portada ordenada

- **Qué cambió:** la portada agrupa sus datos en tres bloques, deja el título en negrita como único énfasis, achica el logo a 70 mm, parte las líneas largas en dos y pone la ciudad y el año al pie, en Arial 11; la tesis de Smits se cita por su copia archivada.
- **Cómo estaba antes:** la portada copiaba las alturas de la de ejemplo de la Biblioteca, con seis bloques del mismo peso, y decía «Diciembre de 2026».
- **Por qué:** el autor pidió ordenarla mejor y controlar los pesos visuales (D-174).

### 2026-11-09 — Referencias en APA 7

- **Qué cambió:** las referencias de los Anexos C, D, E y H se corrigieron tras verificarlas en línea, y se regeneraron el Word y el PDF.
- **Cómo estaba antes:** FocuShift tenía un enlace muerto, las patentes llevaban a la empresa como autora y había letras de año sin otra obra del mismo año.
- **Por qué:** revisión de todas las citas y fuentes pedida por el autor (D-173; detalle en la verificación de referencias).

### 2026-11-09 — Títulos formales

- **Qué cambió:** los títulos y rótulos de los nueve anexos son frases nominales, sin artículo al comienzo ni segunda persona, y las figuras del logo, de la paleta cromática, de los íconos y de los degradados nombran así las partes, los íconos y las familias.
- **Cómo estaba antes:** había títulos como «El logo» o «Las dos tipografías» y rótulos como «Tu tiempo» o «Lo que decides».
- **Por qué:** pedido del autor (D-172).

### 2026-11-09 — La marca sin luz ni aura

- **Qué cambió:** el Anexo H explica la construcción del logo con una figura nueva y ya no habla de luces ni de aura; las figuras de la identidad incluyen la construcción del logo.
- **Cómo estaba antes:** el logo se describía como cuatro luces y la marca incluía el aura.
- **Por qué:** pedido del autor (D-171).

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
