# Memoria en 1920 × 1080

**Decisiones:** D-146 a D-152, D-182, D-183 y D-186. Reemplaza a la [versión A3](../memoria-a3/README.md), que queda como registro.

**Después del 11 de noviembre:** el autor abrió el IDML de esta versión en Affinity y terminó ahí la memoria que entregó para el Pase. Su texto es el [borrador v7](../borrador-memoria-v7-2026-11-11.md).

**Desde el 21 de noviembre (D-186):** el generador compone el [borrador v8](../borrador-memoria-v8-2026-11-21.md), con los comentarios de los profesores y las siete figuras nuevas de [`../figuras/v8/`](../figuras/v8/README.md). Resultado: [memoria-relevo-v8-1920x1080.pdf](memoria-relevo-v8-1920x1080.pdf), de 73 páginas, su [HTML](memoria-relevo-v8-1920x1080.html) y su IDML para Affinity, con los fondos de cada pieza en `figuras/idml-v8/`. Si el autor hizo ajustes de diseño a mano en su Affinity, hay que repetirlos sobre esta versión. La versión del 11 de noviembre queda con sus archivos y se obtiene con `FUENTE=borrador-memoria-v6-2026-10-28.md node construir-idml.js`.

**Para leer (11 de noviembre):** [memoria-relevo-1920x1080.pdf](memoria-relevo-1920x1080.pdf), de 68 páginas de 1920 × 1080 puntos (los píxeles de una pantalla, a 72 ppp). La [versión HTML](memoria-relevo-1920x1080.html) es la misma composición.

**Para editar en Affinity:** `memoria-relevo-1920x1080.idml`, que se abre en Affinity Publisher o InDesign. No se guarda en el repositorio, porque sus imágenes se enlazan con la ruta completa del computador donde se generó: se genera en la carpeta donde se va a trabajar. Antes, instala las tipografías de [`letra/estaticas/`](letra/estaticas/) (ver [letra](letra/LEEME.md)).

**Texto:** el [borrador v6](../borrador-memoria-v6-2026-10-28.md), sin cambios al componer. Sus marcadores «Confirmar» siguen a la vista.

## Pedido

El 28 de octubre de 2026, tras la revisión con los profesores, el autor pidió reescribir la memoria con más figuras para explicar lo difícil de forma simple, con imágenes y esquemas citados, con todo lo que es diseño y con la letra del texto continuo más grande, y seguir trabajando en Affinity, con las tipografías en el repositorio. Los apuntes de la revisión, en la tarea 10 de [Por hacer](../../00_gobernanza/por-hacer.md), piden además el formato de 1920 × 1080, un poco más de interlineado y que ninguna página quede con un solo párrafo ni con una columna sola y poco texto.

## Diseño

| Elemento | Cómo va |
| --- | --- |
| Hoja | 1920 × 1080 puntos (677,3 × 381 mm), papel `#F7F4F0` hasta el borde. Tres columnas. |
| Escala | El generador compone a escala 7:11, en una hoja de 431 × 242 mm, y amplía el PDF y el IDML por 22/14. Así conserva las piezas, las proporciones y la escala tipográfica de la versión A3. |
| Texto | Instrument Sans de 24 pt, con interlineado de 36,1 pt (1,5 veces la letra) y media línea entre párrafos. Desde el 11 de noviembre de 2026, todo el texto —cuerpo, tablas, figuras, notas, referencias y paneles— va un punto más grande que antes (D-183). 25 líneas por columna. |
| Escala completa | 14, 17, 19, 22, 28 y 44 pt en el cuerpo, las tablas y las figuras (la escala de la A3, por 22/14). |
| Aperturas | Número de 95 pt en peso regular —el más liviano de Instrument Sans, que no tiene versión light— y título de 64 pt en negrita (700): manda el título. |
| Rótulos | Como en una tesis: «Figura 1» o «Tabla 1» en negrita y el título en cursiva, debajo; nada en cápsulas. Cabeceras de tabla, encabezados y fechas de 17 pt. |
| Tablas | Como antes de D-148: cada fila en una ficha blanca, con números sueltos y sin círculos ni cápsulas; el total, con un borde. |
| Números y fondos | Números sueltos, sin círculos. El fondo blanco queda para los esquemas y gráficos; las fotos, las capturas, las cifras, la identidad y la línea de la prueba van sobre el papel con sus propias fichas blancas. Ninguna ficha ni cuadro de color va dentro de otra ficha. |
| Letra de figuras y tablas | 20 pt en celdas y rótulos de las figuras, 19 pt en las notas (antes, 17). |
| Cortes | Un párrafo de cinco líneas o menos no se corta. Al cortar uno, quedan al menos tres líneas arriba y pasan al menos tres a la columna siguiente, o cuatro si la siguiente está en otra página. |
| Cifras | Los miles se separan con un espacio que no se corta: «1 577 000» va siempre en una sola línea. |
| Secciones | Cada una abre en una página nueva, con su panel de aura en la primera columna. |
| Final de cada sección | El texto llena cada columna de arriba abajo, sin repartirse en columnas parejas (se quitó el reparto del 10 de noviembre, que dejaba páginas con columnas cortas). Ningún capítulo termina en una columna sola: si pasa, se resuelve con el contenido —una figura de concepto o lo repetido dicho una vez—. Una tabla o figura que queda después del último texto de su sección vuelve a esa página solo si cabe bajo el texto. |
| Tablas y figuras (desde D-186) | En la página de su primera mención o en la siguiente, nunca más lejos ni antes, y de preferencia en la misma. Una figura de una o dos columnas en la página de su mención va junto a la columna que la menciona; en otra página, a la derecha. En una misma página, las figuras se leen en orden: de izquierda a derecha y, al pie, después. Una búsqueda elige la página y el lado de cada pieza en tres pasos: en orden, con un haz de repartos parciales; un ajuste pieza por pieza, y cambios al azar de dos o tres piezas seguidas, con semilla fija. |
| Tablas y figuras (hasta D-183) | En la página de su primera mención o en la siguiente, nunca más lejos ni antes (D-183): una búsqueda prueba reservar cada pieza en esas páginas y se queda con el reparto que deja menos piezas lejos, menos finales cortos y menos páginas a medio llenar. Por defecto, al pie de la página siguiente a su mención, en el orden en que aparecen, con el título arriba y la nota abajo: el texto sigue arriba, hacia el lado, y nunca continúa debajo de una figura. Una página solo de piezas las centra en el alto. Una tabla más alta que la página llena la primera con todas las filas que caben, y esa página no lleva texto; la continuación repite la cabecera y lleva al menos dos filas y la nota. |
| Orden de lectura | Como en una página doble: el texto llena cada columna y sigue hacia el lado. Sobre una pieza, el texto ocupa al menos siete líneas y media por columna; si no caben, la página queda para la pieza. Un subtítulo no queda solo al pie de una columna. |
| Figuras de dos columnas | El mapa de la Figura 10 y las fotos, capturas y bocetos de las Figuras 14, 16, 19, 20, 21 y 23 ocupan dos columnas a la derecha, junto a la columna de texto que las menciona (marca `(doble)` o `<!-- doble -->` en la v6). En la v8: las Figuras 6, 9, 11, 13, 17, 20, 23, 24 y 25; la 28, las fotos de la prueba, va a lo ancho, al pie de la página que abre el capítulo 13. |
| Figuras de una columna (v8) | Las Figuras 1 a 5, 7, 10, 12, 14, 15, 18, 32, 33 y 34, junto a la columna que las menciona (marca `(columna)` o `<!-- columna -->`). La cronología (Figura 15) se dibuja de arriba abajo, con un punto por hito. |
| Figuras dibujadas aparte (v8) | Las siete de [`../figuras/v8/`](../figuras/v8/README.md) se colocan en SVG, al ancho con que se diseñaron, que es su ancho en la página: su letra queda como la de las demás figuras (20,6 pt). |
| Degradados (v8) | Sutiles, como los de la app: tres tonos vecinos de cada papel en las superficies de color, y del papel al tono intenso en las barras de las cifras, el gráfico de barras y los puntos de resultados. Cada grupo del gráfico de barras lleva el color de lo que mide: lugar, sonido o personas. Se imprimen como vectores. |
| Figuras de una columna | Los esquemas breves (Figuras 1 a 5, 8 y 10) van en su propia columna, a la derecha y desde arriba, junto al texto que los menciona: el texto nunca sigue debajo de una figura en la misma columna. |
| Imágenes | Las imágenes enteras de una figura quedan del mismo alto, en columnas proporcionales; los flujos llevan flechas; las figuras anchas usan todo el ancho. Las personas llevan el ícono de perfil. |
| Índice | Las secciones en una página, y las tablas y figuras en otra, como exige la pauta de la Biblioteca. Las filas de tablas y figuras se reparten donde las dos columnas quedan parejas, medidas. En la v8, a pedido de los profesores, el índice de tablas y figuras va al final, después de las referencias, a lo ancho y sin panel, porque son 38 filas. |
| Portada (v8) | Suma el logo DIP, Diseño de Interfaces Phigitales, arriba a la derecha, frente al logo de la Escuela. |
| Portada | El logo FaAAD udp · Escuela de Diseño como membrete, el logo de Relevo, el título y los datos que piden el instructivo de la Escuela y la pauta de la Biblioteca: nombre completo, título y mención, profesores guía, modalidad, Facultad y Escuela, lugar y fecha. |

## Figuras nuevas

El generador dibuja once tipos de figura, que leen su contenido de la propia v6 (grupos separados por «; » y campos por « | »), y compone fotos, capturas y bocetos sin recortarlos (numeración del 11 de noviembre de 2026):

- **Esquema en filas y columnas:** cada grupo, una columna con su cabecera y sus filas: el recorrido del usuario (Figura 13), la arquitectura de información (Figura 15), la voz de Relevo (Figura 17) y las etapas del proyecto (Figura 22); en una columna, las causas (Figura 2), los caminos de la memoria prospectiva (Figura 3), la señal y el mensaje (Figura 4), las fuentes (Figura 6), las situaciones de uso (Figura 9), los criterios (Figura 11) y las condiciones para que una intención vuelva a tiempo (Figura 27).
- **Mapa de dos ejes:** qué hace cada herramienta —limitar el uso del teléfono o recordar lo que la persona quería hacer— y si ocurre en la pantalla o fuera de ella, con Relevo en su cuadrante (Figura 10), a dos columnas junto al texto.
- **Momentos de la atención:** antes de la señal, cuando suena y cuando termina, con lo que queda en primer y en segundo plano (Figura 5).
- **Matriz de dos por dos:** motivación y facilidad para empezar (Figura 26), en una columna.
- **Cronología:** el proceso del proyecto, de marzo a noviembre (Figura 12).
- **Lámina de identidad:** logo, colores, tipografía e íconos, cada uno en su ficha blanca (Figura 18).
- **Cifras:** una ficha por dato, con una barra de progreso del color de su papel (Figura 7).
- **Prueba aplicada:** las cuatro etapas de la prueba en los hogares (Figura 24).
- **Resultados por persona:** un punto por respuesta, lleno si declaró haber empezado (Figura 25).
- **Fotos, bocetos y modelos:** bocetos del logo (Figura 19) y del objeto (Figura 20), Relevo en 3D (Figura 21) y el Tag durante la prueba (Figura 23), con su pie numerado.
- **Gráfico de barras:** opiniones de la encuesta (Figura 8), con barras horizontales y el número al lado.
- **Flujo con flechas:** el flujo de la aplicación, de preparar a decidir, en seis capturas (Figura 14); las pantallas de la prueba están en el Anexo F.

## Cómo se genera

```bash
node construir-idml.js
```

Necesita Node y Google Chrome, y tarda unos cuatro minutos. Escribe el IDML, el HTML y el PDF con el mismo reparto, y los fondos de cada pieza en `figuras/idml/`. Con `DIAG=1` imprime dónde quedó cada pieza y cada marco de texto.

## Verificación

- **Décima ronda, el 21 de noviembre de 2026 (v8):** 73 páginas, PDF de 11,2 MB. De 38 tablas y figuras, 18 quedan en la página de su mención y 20 en la siguiente; ninguna más lejos ni antes, y ninguna fuera de orden en su página. Se revisó la vista de todas y, de cerca, las páginas 20, 49 y 55; los títulos de los paneles caben aunque haya una pieza al pie de la apertura. Avisos que dependen del texto: los capítulos 4, 10 y 14 y el glosario terminan en una columna corta, y la continuación de la Tabla 4, con dos filas, ocupa sola la página 61.
- **Novena ronda, el 11 de noviembre de 2026:** 68 páginas, sin avisos del generador. Cada tabla y figura queda en la página de su primera mención o en la siguiente, ningún capítulo termina en una columna sola o corta y no queda ninguna tabla partida. Las únicas páginas solo de piezas son la Tabla 1, al cierre del capítulo 11, y la Tabla 4, al cierre del 13. Se revisó la vista de todas y, de cerca, las páginas 10, 11, 22, 27, 43 a 45, 49, 53, 54, 56, 57 y 62.
- **Octava ronda, el 10 de noviembre de 2026:** 75 páginas, sin avisos del generador. Se revisó la vista de todas y, de cerca, cada figura: sin texto desbordado, sin etiquetas sobre los ejes y sin encabezados partidos. Los íconos de las figuras salen del código de la app 4.7.2 (`marca-e-iconos.json`); un capítulo que termina en una sola columna corta reparte esa página en dos; la contraportada lleva la frase de marca. Las cursivas usan Instrument Sans Italic y SemiBold Italic, incluidas en `letra/`. PDF de 9,4 MB.
- **Séptima ronda, el 29 de octubre de 2026:** 62 páginas, sin avisos del generador; ningún texto sigue debajo de una figura en su columna y ningún capítulo termina en una columna sola. Se revisó la vista de todas. Texto: 8,1 palabras por línea en promedio; 7 de 1458 líneas pasan de 12, por cifras. PDF de 7,2 MB. El IDML enlaza sus 60 imágenes, y el índice de tablas y figuras se mide bien: antes, sus filas compartían la clase de la medición y el IDML recibía posiciones encimadas.
- **Sexta ronda, el 29 de octubre de 2026:** 66 páginas, sin avisos del generador; el texto llena cada columna y sigue hacia el lado, sin continuar debajo de una figura; ningún subtítulo queda solo al pie de una columna. Se revisó la vista de todas. Texto: 8,1 palabras por línea en promedio; 7 de 1521 líneas pasan de 12, por cifras. PDF de 7,2 MB (el máximo del instructivo es 15). El IDML enlaza sus 58 imágenes.
- **Quinta ronda, el 29 de octubre de 2026:** 68 páginas, sin avisos del generador; ninguna tabla partida deja texto entre sus partes, y bajo cada pieza el texto ocupa al menos siete líneas por columna. Se revisó la vista de todas. Texto: 8,1 palabras por línea en promedio; 11 de 1686 líneas pasan de 12, por cifras. El IDML enlaza sus 57 imágenes y declara solo los cinco estilos de Instrument Sans.
- **Cuarta ronda, el 28 de octubre de 2026:** 72 páginas, sin avisos del generador; ninguna columna con una o dos líneas y ningún final de párrafo solo en otra página. Las páginas que solo tienen una tabla o una figura la centran en el alto. Texto: 8,1 palabras por línea en promedio; 9 de 1825 líneas pasan de 12, por cifras.
- **Tercera ronda, el 28 de octubre de 2026:** 69 páginas, sin avisos del generador; ninguna sección termina en una columna sola. Se revisó la vista de todas. Texto: 8,1 palabras por línea en promedio; 8 de 1843 líneas pasan de 12, por cifras.
- **Segunda ronda, el 28 de octubre de 2026:** 75 páginas, sin avisos del generador. Se revisó la vista de todas. Texto: 8,4 palabras por línea en promedio; 17 de 1824 líneas pasan de 12, por cifras.
- **El 28 de octubre de 2026:** 66 páginas, sin avisos del generador. Se revisó la vista de todas y, de cerca, las páginas de las figuras nuevas.
- **Palabras por línea** (`pdftotext`): texto, 8,4 en promedio; 17 de 1872 líneas pasan de 12, por cifras. Notas, celdas, referencias y glosario: 12 o menos en el 95 % de las líneas.
- **Final de las secciones:** ninguna termina en una columna sola; las que terminan en una tabla la dejan a página completa.
- **No comprobado:** el IDML no se abrió en Affinity en esta ronda.

## Límites

- El IDML está en el repositorio desde el 29 de octubre de 2026, pero sus imágenes se enlazan con la ruta del computador donde se generó: en otro computador hay que volver a enlazarlas desde `figuras/idml/`, o generar el IDML de nuevo con `node construir-idml.js`.
- Algunas tablas y láminas altas quedan en páginas propias, con aire debajo, porque no dejan espacio útil para texto.
- Las capturas de la aplicación son de la versión actual; la prueba usó otra interfaz, con los mismos pasos.
- La Biblioteca exige los índices de tablas y de figuras para el depósito.

## Registro de cambios (disclaimer)

### 2026-11-21 — La v8, con las figuras junto a su mención

- **Qué cambió:** el generador compone el borrador v8 y escribe `memoria-relevo-v8-1920x1080` (PDF, HTML e IDML), con los fondos en `figuras/idml-v8/`; coloca las siete figuras nuevas en SVG, a su tamaño real; pone el logo DIP en la portada y el índice de tablas y figuras al final; una figura en la página de su mención va junto a la columna que la menciona; la búsqueda del reparto prueba también las figuras de columna, prefiere la página de la mención y respeta el orden de lectura dentro de la página; los colores llevan degradados sutiles, que se imprimen como vectores; el panel de una apertura con una pieza al pie achica su título para que no se corte; una página solo de figuras las alinea arriba, como grupo.
- **Cómo estaba antes:** componía el borrador v6; las figuras de columna se iban siempre a la derecha y la búsqueda solo movía las anchas; casi la mitad de las piezas quedaba en la página siguiente a su mención, y cinco quedaban a dos páginas.
- **Por qué:** el autor pidió revisar el tamaño de las figuras en la memoria real, que una figura y su mención en la misma página queden juntas, y degradados sutiles como los de la app (D-186).

### 2026-11-21 — La memoria sigue en Affinity

- **Qué cambió:** se aclara que, desde el 11 de noviembre, la memoria se corrige en el documento de Affinity del autor y no con este generador.
- **Cómo estaba antes:** el README describía el generador como la forma de producir la memoria; esta versión, del 11 de noviembre, estaba solo en la copia local del autor.
- **Por qué:** al ordenar los pendientes se trajo al repositorio el trabajo del 10 y el 11 de noviembre.

### 2026-11-11 — Memoria final, segunda vuelta

- **Qué cambió:** todo el texto sube un punto; los títulos de apertura van en negrita y el número sigue en regular; vuelven los agradecimientos; las cifras de la Figura 7 llevan una barra de progreso de un color en vez de una barra por respuesta; los segundos de la Tabla 3 van sueltos, sin círculo; hay figuras de dos columnas junto al texto; cada pieza queda en la página de su mención o la siguiente, con una búsqueda que lo comprueba y avisa si no; se quitó el reparto de los finales en columnas cortas y se avisa cuando un capítulo termina en una columna sola o corta.
- **Cómo estaba antes:** texto de 23 pt, títulos en seminegrita, sin agradecimientos, una barra por respuesta, segundos en círculos, figuras a dos o tres páginas de su mención (por ejemplo, la Tabla 1 y las Figuras 12 y 13) y finales repartidos en dos columnas cortas, que dejaban páginas casi vacías (13, 16 y 63, entre otras).
- **Por qué:** pedido del autor del 10 de noviembre de 2026, en la noche (D-183).

### 2026-11-10 — Memoria final

- **Qué cambió:** los íconos de las figuras son los de la app 4.7.2; la lámina de identidad muestra siete; el mapa evita que una etiqueta cruce el eje; un capítulo que termina en una sola columna corta reparte esa página en dos, y la contraportada lleva la frase de marca.
- **Cómo estaba antes:** los íconos eran los del 11 de octubre, la contraportada decía «Un recordatorio físico preparado desde el teléfono» y los finales de capítulo nunca se repartían.
- **Por qué:** pedido del autor del 10 de noviembre de 2026 (D-182).

### 2026-11-09 — Lámina de identidad

- **Qué cambió:** la lámina de identidad rotula sus cuatro colores como Tiempo, Primer paso, Lugar y Decisión.
- **Cómo estaba antes:** los rotulaba con las preguntas de la aplicación, como «¿Cuándo suena?» o «¿Qué decidiste?».
- **Por qué:** títulos y rótulos formales, a pedido del autor (D-172). La versión diseñada no se regeneró.

### 2026-10-29 — El IDML entra al repositorio

- **Qué cambió:** el IDML se sube junto al PDF y las tipografías.
- **Cómo estaba antes:** quedaba fuera del repositorio (`.gitignore`) por sus enlaces con ruta absoluta.
- **Por qué:** pedido del autor, que no lo veía en la carpeta.

### 2026-10-29 — Séptima ronda

- **Qué cambió:** las figuras de una columna van en su propia columna, a la derecha; ningún capítulo termina en una columna sola; las referencias, más juntas; una pieza que queda después del texto vuelve a su página solo si cabe bajo el texto; el índice de tablas y figuras, con filas compactas y columnas parejas; el mapa con rótulos naturales; las cifras no se cortan entre líneas; la medición ya no confunde las filas del índice.
- **Cómo estaba antes:** las figuras de una columna iban al pie de la columna de texto; algunos capítulos terminaban en una columna sola; el índice de figuras tocaba el número de página.
- **Por qué:** pedido del autor del 29 de octubre de 2026, de noche (D-152).

### 2026-10-29 — Sexta ronda

- **Qué cambió:** el texto llena cada columna y sigue hacia el lado; las tablas y figuras anchas van al pie de la página y las de una columna, al pie de su columna; sin finales equilibrados; un subtítulo no queda solo al pie; la pregunta de investigación, sin rótulo; la Figura 3 en primer y segundo plano; la identidad con las preguntas de la aplicación; la prueba aplicada sin letras de condiciones; portada con el logo de la Escuela y los datos del instructivo; índice de tablas y figuras en una segunda página.
- **Cómo estaba antes:** las piezas iban arriba de la página y el texto seguía debajo; los finales de sección se repartían en columnas parejas; la portada llevaba la institución en texto y el índice, solo las secciones.
- **Por qué:** pedido del autor del 29 de octubre de 2026 (D-151).

### 2026-10-29 — Quinta ronda

- **Qué cambió:** tablas en fichas blancas otra vez, con el título arriba; una tabla partida llena su primera página, sola, y la continuación lleva la nota y el texto; al menos siete líneas por columna bajo una pieza; el fondo blanco solo para esquemas y gráficos, sin fichas ni cuadros de color dentro de otra ficha; la matriz de la Figura 20 a dos columnas de ancho; los textos de la identidad ya no se cortan; el IDML declara solo los cinco estilos usados.
- **Cómo estaba antes:** tablas con filetes; las de tres columnas o menos llevaban el título al lado; las tablas partidas por la mitad dejaban texto entre sus partes; bajo una pieza podían quedar columnas de tres a seis líneas; la identidad iba en una ficha blanca con fichas color papel adentro.
- **Por qué:** pedido del autor del 29 de octubre de 2026 (D-150).

### 2026-10-28 — Cuarta ronda

- **Qué cambió:** figuras sobre fondo blanco, con letra más grande y esquemas en filas y columnas; la Figura 3 en tres momentos; ningún párrafo de cinco líneas o menos se corta, y los cortes dejan al menos tres líneas a cada lado (cuatro si cambia de página); el final de una sección se reparte solo con ocho líneas o más por columna.
- **Cómo estaba antes:** quedaban finales de párrafo de dos o tres líneas solos en otra columna o página, y finales de sección repartidos en columnas de pocas líneas; las figuras no tenían fondo.
- **Por qué:** pedido del autor del 28 de octubre de 2026, de noche (D-149).

### 2026-10-28 — Tercera ronda

- **Qué cambió:** rótulos de tesis; tablas con filetes; números sueltos; fondos blancos solo para lo relevante; número de apertura en peso regular; texto de 23 pt con interlineado de 34,6; figuras de una columna arriba de la columna; mapa de dos ejes, centro y periferia y matriz de dos por dos; el final de una sección no deja una última columna de una o dos líneas.
- **Cómo estaba antes:** rótulos en cápsulas negras, tablas en fichas blancas con números en círculos, texto de 22 pt y portadas de libros como figuras de columna.
- **Por qué:** pedido del autor del 28 de octubre de 2026, de noche (D-148).

### 2026-10-28 — Segunda ronda

- **Qué cambió:** aperturas con el número más chico y el título más grande; rótulos y cabeceras más grandes; el ícono de perfil para las personas; figuras de una columna, gráfico de barras, flujos con flechas y láminas de pantallas; imágenes del mismo alto; el final de cada sección se reparte aunque las tablas muevan su última página.
- **Cómo estaba antes:** el número de apertura medía 236 pt y el título 44; los rótulos, 14 pt; las personas llevaban una estrella; no había figuras dentro del texto, y algunas secciones terminaban en una columna sola.
- **Por qué:** pedido del autor del 28 de octubre de 2026, de noche (D-147).

### 2026-10-28 — Creación

- **Qué se añadió:** la memoria v6 compuesta en 1920 × 1080, con el generador derivado del de la versión A3: la hoja a escala, texto de 22 pt con más interlineado, el final de cada sección equilibrado, cinco tipos de figura nuevos, capturas y modelos sin recortar, y las tipografías estáticas para Affinity.
- **Cómo estaba antes:** la memoria diseñada era la v5 en A3 horizontal, con texto de 14 pt y una columna sola al final de varias secciones.
- **Por qué:** pedido del autor del 28 de octubre de 2026, con los apuntes de la revisión con los profesores (D-146).
