# Registro de lectura y cobertura

## Método

La revisión se hizo sobre las cuatro copias locales de `originales/`. Primero se comprobó el número de páginas, los metadatos disponibles y el hash SHA-256. Después se extrajo el texto de cada página con `pypdf` 6.10.0 y se guardó temporalmente un archivo de texto por página. Esto permitió recorrer el contenido completo por rangos, localizar capítulos y volver a las páginas donde aparecía cada concepto.

La extracción no utilizó OCR. En consecuencia, el texto depende de la capa textual que traía cada PDF. Se observaron palabras partidas, caracteres mal reconocidos, numeración deformada y páginas compuestas principalmente por imágenes. Cuando la ausencia de texto podía ocultar una lámina, se hizo una comprobación visual mediante renderizado de página. La extracción temporal no forma parte de la biblioteca académica y no reemplaza la consulta del PDF original.

La cobertura se verificó de cuatro maneras:

1. se recorrió cada página del archivo, incluida la última;
2. se contrastaron los índices y los comienzos de capítulos con los marcadores encontrados en la extracción;
3. se revisaron las páginas finales y el tipo de contenido con que termina cada archivo;
4. se distinguieron páginas sin texto, páginas con imágenes y posibles faltantes de edición.

La numeración indicada abajo corresponde a la secuencia de páginas del PDF. Cuando el libro muestra otra numeración impresa, se señala expresamente. Las ideas se registraron como paráfrasis; no se copiaron fragmentos extensos.

## Cobertura por obra

### Don Norman — *The Design of Everyday Things*

- **Archivo revisado:** 270 páginas.
- **Cobertura:** portada y contenidos; prefacio a la edición de 2002; prefacio; capítulos 1–7; notas; lecturas sugeridas; referencias e índice.
- **Recorrido temático:** problemas de visibilidad y comprensión; estructura de la acción; conocimiento interno y externo; affordances percibidas, claves visibles y modelos conceptuales; mapeo y retroalimentación; restricciones físicas, semánticas, culturales y lógicas; errores y recuperación; proceso de diseño; diseño centrado en las personas. El término *signifier* no aparece en esta copia de 2002 y no se atribuye a ella.
- **Páginas sin texto extraíble:** la primera, correspondiente a la cubierta visual.
- **Comprobación final:** la página 270 contiene el final del índice alfabético. No hay páginas posteriores en el archivo.
- **Limitación editorial:** el archivo incluye una introducción de la edición de 2002, pero no muestra con claridad todos los datos de la página legal; el año y la editorial deben confirmarse en una ficha bibliográfica externa antes de citar la edición exacta.

### Josef Albers — *Interaction of Color*

- **Archivo revisado:** 210 páginas.
- **Cobertura:** portada y página legal de la cuarta edición; prólogo; introducción; capítulos I–XXVI; sección `Plates and commentary`, con las placas y sus comentarios hasta el final.
- **Recorrido temático:** memoria visual y recuerdo de color; lectura y contexto; papel frente a pigmento; relatividad; luz y oscuridad; interacción, sustracción y postimagen; mezclas ilusorias y físicas; transparencia; mezcla óptica; intervalos; cantidad; color de película y volumen; estudios libres; análisis de maestros; progresiones; temperatura; límites vibrantes y desaparecidos; sistemas de color; enseñanza y terminología.
- **Páginas sin texto extraíble:** 28 páginas. Varias corresponden a reversos o placas sin capa textual. Se comprobó visualmente que las páginas de la sección de placas contienen material gráfico y que la página 210 contiene el cierre editorial de Yale University Press.
- **Comprobación final:** la página 210 es la última del PDF y contiene la identificación de la editorial y una composición de color.
- **Limitación editorial:** la obra está disponible como cuarta edición de 2013, con ISBN visible. La extracción de las placas no siempre conserva todos sus colores o textos; para decidir color se debe trabajar con el PDF y con pruebas físicas o digitales, no con el texto extraído.

### Bruno Munari — *Design as Art*

- **Archivo revisado:** 155 páginas.
- **Cobertura:** portada; prefacio a la edición inglesa; prefacio sobre las máquinas inútiles; capítulos y ensayos desde `Design as Art` hasta `Fancy Goods`; imágenes y páginas sin texto extraíble.
- **Recorrido temático presente:** función social del diseño; diferencia entre diseñador y estilista; diseño visual, industrial, gráfico y de investigación; lenguaje visual; signos y símbolos; tipografía; carteles; libros infantiles; diseño industrial; bambú y forma espontánea; lámparas; desgaste; objetos naturales y modularidad; utensilios; mercancía decorativa.
- **Páginas sin texto extraíble:** 15 páginas. Las páginas 144–150 incluyen principalmente imágenes de sillas y material gráfico, por lo que se comprobó visualmente su presencia.
- **Comprobación final:** la página 155 es la última del archivo y continúa el ensayo `Fancy Goods`.
- **Limitación crítica:** el índice de la propia edición anuncia `Research Design` en la página 157 y un apéndice en la página 221. Esas secciones no aparecen en el PDF suministrado, que termina en la página 155. Por lo tanto, se leyó completamente el archivo entregado, pero no puede afirmarse que se haya leído la obra completa de esa edición. Las conclusiones sobre Munari se limitan al contenido disponible.

### Walter Isaacson — *Steve Jobs*

- **Archivo revisado:** 1.412 páginas.
- **Cobertura:** presentación, datos de traducción, personajes, introducción; capítulos 1–41; agradecimientos; fuentes; bibliografía; anotaciones por capítulo y notas finales.
- **Recorrido estructural:** infancia y formación; Apple I y Apple II; Macintosh; conflictos y salida de Apple; NeXT y Pixar; regreso a Apple; publicidad, diseño y tiendas; centro digital, iPod, iTunes, iPhone e iPad; nuevas batallas; enfermedad y legado.
- **Páginas sin texto extraíble:** 26. La primera corresponde a una cubierta visual; otras se concentran en separadores o páginas de transición. Las páginas 1327–1349 son páginas sin capa textual ubicadas antes de los agradecimientos y fueron registradas como vacías, sin tratarlas como evidencia ausente del relato principal.
- **Comprobación final:** la página 1412 contiene la nota final número 10. No hay páginas posteriores en el archivo.
- **Limitación editorial:** el texto es una traducción al español y permite confirmar autor, título original, año 2011 y traductor, pero no editorial, ISBN ni edición española desde la información extraíble. La fecha de creación del PDF pertenece al archivo digital, no a la publicación.

## Tratamiento de errores de extracción

Los PDF de Albers y Munari contienen imágenes que no siempre tienen texto seleccionable. En Albers, las placas son parte esencial de la obra y no deben reducirse a sus comentarios. En Munari, algunas páginas de imágenes interrumpen el texto y el archivo termina antes de las secciones anunciadas. En Isaacson, la extracción procede de un PDF generado con calibre y conserva la estructura de la traducción, aunque presenta guiones de salto de línea y páginas de transición. En Norman, la capa textual es amplia y permite recorrer el índice y el contenido, pero algunos caracteres y palabras aparecen alterados por la digitalización.

La regla de interpretación es conservadora: cuando una frase extraída parece incompleta, se consulta la página completa; cuando el archivo no permite confirmar una edición o un contenido, se marca como pendiente; cuando una obra propone un ejercicio visual, se registra como método de observación y no como prueba universal.

## Clasificación de las fuentes

| Obra | Tipo principal | Uso dentro del proyecto |
| --- | --- | --- |
| Norman | Teórica y profesional | Comprender acciones, señales, modelos, retroalimentación, restricciones y errores en la aplicación y el objeto. |
| Albers | Teórica, pedagógica y profesional | Formular pruebas de contraste, contexto, color y percepción para Android, editorial y señal física. |
| Munari | Teórica y profesional | Relacionar función, comunicación, materialidad, método, variantes y experimentación visual. |
| Isaacson | Histórica y biográfica | Comprender episodios de integración, simplificación, prototipado y cultura de producto; no demostrar usabilidad. |

## Criterios para citar y trasladar hallazgos

Los resúmenes deben mencionar capítulo o rango de páginas cuando el dato sea importante. No se presentará una anécdota como evidencia empírica de los usuarios de Relevo. No se tratará una recomendación de un autor como una validación del proyecto. La traducción hacia Relevo debe aparecer como interpretación, hipótesis o decisión, y debe incluir una forma de prueba cuando corresponda.

---

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación del registro de lectura

- **Cambio:** se documentaron el método de extracción, el recorrido completo por archivo, los capítulos o secciones cubiertos, las páginas finales, las limitaciones de OCR/capa textual y la clasificación académica de cada obra.
- **Situación anterior:** los PDF estaban almacenados sin un registro que permitiera demostrar qué se había revisado y qué contenido podía faltar.
- **Motivo:** hacer auditable la lectura y evitar que la extracción parcial o la memoria del investigador se presenten como lectura completa de una edición.
- **Asunto abierto:** confirmar datos editoriales faltantes y conseguir una copia completa de Munari si se necesita citar `Research Design` o el apéndice.

### 2026-08-29 — Precisión de cobertura conceptual en Norman

- **Cambio:** se distinguieron las claves visibles de la terminología posterior de los significantes.
- **Situación anterior:** el recorrido temático incluía significantes como si el término estuviera presente en el PDF revisado.
- **Motivo:** hacer que el registro de lectura corresponda estrictamente a la edición suministrada.
