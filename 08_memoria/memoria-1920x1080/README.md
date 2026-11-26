# Memoria en 1920 × 1080

**Decisiones:** D-146 a D-152, D-182, D-183 y D-186. Reemplaza a la [versión A3](../memoria-a3/README.md), que queda como registro.

**Después del 11 de noviembre:** el autor abrió el IDML de esta versión en Affinity y terminó ahí la memoria que entregó para el Pase. Su texto es el [borrador v7](../borrador-memoria-v7-2026-11-11.md).

**Desde el 21 de noviembre (D-186):** el generador compone el [borrador v8](../borrador-memoria-v8-2026-11-21.md), con los comentarios de los profesores y las siete figuras nuevas de [`../figuras/v8/`](../figuras/v8/README.md). Resultado: [memoria-relevo-v8-1920x1080.pdf](memoria-relevo-v8-1920x1080.pdf), de 75 páginas, su [HTML](memoria-relevo-v8-1920x1080.html) y su IDML para Affinity, con los fondos de cada pieza en `figuras/idml-v8/`. Si el autor hizo ajustes de diseño a mano en su Affinity, hay que repetirlos sobre esta versión. La versión del 11 de noviembre queda con sus archivos y se obtiene con `FUENTE=borrador-memoria-v6-2026-10-28.md node construir-idml.js`.

**Para leer (11 de noviembre):** [memoria-relevo-1920x1080.pdf](memoria-relevo-1920x1080.pdf), de 68 páginas de 1920 × 1080 puntos (los píxeles de una pantalla, a 72 ppp). La [versión HTML](memoria-relevo-1920x1080.html) es la misma composición.

**Para editar en Affinity (desde el 25 de noviembre):** `memoria-relevo-v8-1920x1080.idml`. Todo su texto es editable: el cuerpo, los títulos de los paneles, y los rótulos, leyendas, números, letras y notas de cada tabla y figura, también los de las siete figuras dibujadas aparte. Cada pieza va como un fondo vectorial sin texto, con sus textos vivos encima, en su lugar y con sus estilos. Exportado desde Affinity 3.2, el IDML da el mismo PDF: las 25 145 palabras quedan en el mismo lugar (ver Verificación; `python3 comparar-pdf-affinity.py <pdf de Chrome> <pdf de Affinity>` repite la comparación). Para trabajar en otro computador, `python3 empaquetar-idml.py <idml> .. <carpeta>` copia los vínculos a `<carpeta>/vinculos` y los enlaza ahí. Antes, instala las tipografías de [`letra/estaticas/`](letra/estaticas/) (ver [letra](letra/LEEME.md)).

**Saltos de línea forzados en el IDML:** para que Affinity corte donde corta el PDF, 43 textos de tablas y figuras y las direcciones de 96 referencias llevan saltos de línea forzados (Mayús + Intro) en los cortes que Chrome hizo al límite. Si se edita uno de esos textos, hay que mover o quitar esos saltos a mano. El resto del texto fluye solo.

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
| Tablas y figuras (desde D-193) | En la página donde se nombran, nunca en otra. La página de la mención es la de la línea que nombra la pieza. Una figura de columna se coloca al llegar a esa línea: al pie de la columna de la mención o en una columna libre a su derecha; una doble, en las columnas 2 y 3, enteras o al pie. La única excepción es una página completa en la siguiente, compuesta para esa página: `<!-- página -->` la pide, y la búsqueda puede elegirla para cualquier figura doble o ancha y para las tablas (fotografías en fila, figuras de dos columnas junto al rótulo y la nota, figuras anchas bajo el rótulo, tablas estiradas). Vale también una página sin texto cuyas figuras de columna llenan las tres columnas: empiezan y terminan a la misma altura. Figuras vecinas empiezan a la misma altura. La búsqueda al azar cuenta pruebas (`BUSQUEDA_PRUEBAS`), no segundos, y da el mismo reparto en cualquier computador. |
| Tablas y figuras (desde D-186) | En la página de su primera mención o en la siguiente, nunca más lejos ni antes, y de preferencia en la misma. Una figura de una o dos columnas en la página de su mención va junto a la columna que la menciona; en otra página, a la derecha. En una misma página, las figuras se leen en orden: de izquierda a derecha y, al pie, después. Una búsqueda elige la página y el lado de cada pieza en tres pasos: en orden, con un haz de repartos parciales; un ajuste pieza por pieza, y cambios al azar de dos o tres piezas seguidas, con semilla fija. |
| Tablas y figuras (hasta D-183) | En la página de su primera mención o en la siguiente, nunca más lejos ni antes (D-183): una búsqueda prueba reservar cada pieza en esas páginas y se queda con el reparto que deja menos piezas lejos, menos finales cortos y menos páginas a medio llenar. Por defecto, al pie de la página siguiente a su mención, en el orden en que aparecen, con el título arriba y la nota abajo: el texto sigue arriba, hacia el lado, y nunca continúa debajo de una figura. Una página solo de piezas las centra en el alto. Una tabla más alta que la página llena la primera con todas las filas que caben, y esa página no lleva texto; la continuación repite la cabecera y lleva al menos dos filas y la nota. |
| Orden de lectura | Como en una página doble: el texto llena cada columna y sigue hacia el lado. Sobre una pieza, el texto ocupa al menos siete líneas y media por columna; si no caben, la página queda para la pieza. Un subtítulo no queda solo al pie de una columna. |
| Figuras de dos columnas | El mapa de la Figura 10 y las fotos, capturas y bocetos de las Figuras 14, 16, 19, 20, 21 y 23 ocupan dos columnas a la derecha, junto a la columna de texto que las menciona (marca `(doble)` o `<!-- doble -->` en la v6). En la v8: las Figuras 8, 11, 13, 17, 21, 22, 25, 28, 29, 30, 31 y 33. Una figura doble puede ir al pie de las otras dos columnas, también en la página que abre un capítulo: el panel conserva su columna entera. |
| Figuras de una columna (v8) | Las Figuras 2 a 6, 9, 10, 12, 15, 16, 18, 19, 37, 38, 39 y 41, junto a la columna que las menciona (marca `(columna)` o `<!-- columna -->`). La cronología (Figura 19) se dibuja de arriba abajo, con un punto por hito; las cifras de la Figura 10, en lista. Dos figuras chicas pueden compartir una columna si caben. |
| Imágenes de las fuentes (v8, de D-190 a D-194) | Desde D-194 la memoria no reproduce figuras de otras fuentes: la Figura 1 es propia y la única imagen de `../figuras/fuentes/` es la foto propia del Tag, Relevo Home y Relevo Go. Antes eran seis figuras con imágenes reales de las fuentes citadas y del objeto (Figuras 1, 7, 14, 19, 37 y 39), en `../figuras/fuentes/`. Las que llevan `<!-- cola -->` van bajo la última columna de texto de su capítulo, cuando esa columna quedó corta, sin mover el texto; `<!-- cola 60 -->` limita el alto de la imagen a 60 mm de composición. |
| Índices (desde D-190) | El índice general tiene más margen dentro de sus cajas, a ambos lados. El índice de tablas y figuras va solo con texto, sin cajas, con el espaciado de una lista (pedido de Majluf). |
| Esquemas (v8, desde D-190) | Sin fichas ni reglas de tabla: cada grupo lleva un punto de color, su título, una bajada y sus elementos. Las secuencias (problema, recorrido, etapas y atención) llevan número y flechas. La matriz de dos por dos tiene ejes con nombre y extremos. Una coma dentro de una frase o de una cita ya no parte un elemento en dos. |
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

- **El IDML en Affinity, el 25 de noviembre de 2026 (v8):** se abrió en Affinity 3.2, con sus 75 páginas y sus 81 vínculos, y se exportó a PDF. Ese PDF se comparó palabra por palabra con el de Chrome (`pdftotext -bbox`): de 25 145 palabras, 25 143 quedan en el mismo lugar, con 0,02 pt de desvío horizontal típico; las otras dos son una sola palabra que cada programa divide distinto (“tiempo,”). En vertical, el texto de Affinity queda a menos de 1 pt del de Chrome (2 pt en una columna), en una hoja de 1080 pt. La primera exportación tenía 3294 palabras corridas: textos de figuras que Affinity cortaba más tarde, un subtítulo que saltaba al marco siguiente y direcciones que Affinity cortaba tras “https://” o tras un punto. Las 264 palabras sacadas de los fondos (números, letras y títulos de panel) coinciden con el PDF.
- **Duodécima ronda, el 24 de noviembre de 2026 (v8):** 40 figuras y 4 tablas: 24 quedan en la página de su mención y 20 en la siguiente, todas en orden. Seis imágenes reales rellenan los finales de los capítulos 2, 6, 8, 10, 13 y 14; el glosario ya no termina en una columna diminuta. El capítulo 4 termina en una columna casi llena, que el autor acepta. El índice de tablas y figuras cabe en su página (199,5 de 201,8 mm).
- **Duodécima ronda, el 25 de noviembre de 2026 (v8):** 73 páginas, PDF de 12,6 MB. De 41 figuras y 4 tablas, todas quedan en la página de su mención o en la siguiente, en orden. La nueva Figura 16, «Dónde actúa Relevo en la tensión de la decisión», es un esquema de tensión: una secuencia con número y flechas, en lila, amarillo, verde y rosa. Las referencias se compusieron con un interlineado de 13,4 y 1,2 de espacio entre ellas, para que terminen en una página llena. El capítulo 4 sigue terminando en una columna casi llena.
- **Undécima ronda, el 24 de noviembre de 2026 (v8):** 72 páginas, PDF de 11,3 MB. De 38 tablas y figuras, 18 quedan en la página de su mención y 20 en la siguiente; ninguna más lejos ni antes, y todas en orden. Los paneles de apertura conservan su columna entera. Se revisó la vista de todas y, de cerca, las páginas 13, 22, 34, 36 y 37. Una página sin texto con una sola figura chica cuenta como casi vacía. Quedan, para resolver con el contenido, los finales de los capítulos 4 (una columna en la página 14), 10, 13 (la continuación de la Tabla 4) y 14, y del glosario.
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

- El IDML está en el repositorio desde el 29 de octubre de 2026, pero sus imágenes se enlazan con la ruta del computador donde se generó: en otro computador hay que empaquetarlo con `empaquetar-idml.py`, volver a enlazarlas desde `figuras/idml-v8/` o generar el IDML de nuevo con `node construir-idml.js`.
- La comparación con el PDF se hizo con la exportación de Affinity 3.2 en este computador. Otra versión de Affinity, o de InDesign, puede cortar distinto alguna línea al límite del cuerpo del texto, que fluye sin saltos forzados.
- Algunas tablas y láminas altas quedan en páginas propias, con aire debajo, porque no dejan espacio útil para texto.
- Las capturas de la aplicación son de la versión actual; la prueba usó otra interfaz, con los mismos pasos.
- La Biblioteca exige los índices de tablas y de figuras para el depósito.

## Registro de cambios (disclaimer)

### 2026-11-25 — Todo el texto vivo en el IDML, con los cortes del PDF

- **Qué cambió:** el IDML lleva vivo todo el texto que los fondos todavía dibujaban: los textos de las siete figuras dibujadas aparte, los números, letras y leyendas de las piezas y los títulos de los paneles. Cada texto se mide en Chrome, se oculta en el fondo y va encima con su cuerpo, peso, color y alineación. Para que Affinity corte cada línea donde la corta el PDF, el marco de un texto de pieza mide el ancho real del texto (sin el margen de seguridad de 3 %) más una holgura mínima; si una línea quedó al límite, el IDML repite el corte de Chrome con un salto forzado. Un subtítulo que cierra un marco antes de su frase destacada lleva “conservar con el siguiente” en cero, y las direcciones de las referencias cortan en el IDML donde las corta el PDF. En el PDF, una dirección ahora se corta después de una barra, y la raya de un inciso queda pegada a su palabra.
- **Cómo estaba antes:** los textos de las figuras v8, los números, las letras y los títulos de los paneles venían dibujados en el fondo y no se podían editar. En Affinity, 3294 palabras quedaban en otro lugar que en el PDF: la Figura 21 cortaba “mientras Relevo cuenta / el tiempo”, “Hipótesis y objetivos” saltaba debajo de su tarjeta y corría todo el capítulo, y las referencias se cortaban en otros lugares. En el PDF, una línea de las conclusiones empezaba con la raya de cierre (“— y la convirtió”) y otra terminaba con la de apertura; algunas direcciones se cortaban a mitad de palabra (“bluetoot / h”).
- **Por qué:** el autor pidió dejar la memoria lista en IDML para editarla, con los textos de las figuras editables sin romper su diseño.

### 2026-11-25 — Títulos de panel, cortes de línea y tablas partidas

- **Qué cambió:** el generador ajusta el tamaño del título de un panel si una palabra no cabe, para dejar el mismo margen a ambos lados. Une con espacios que no se cortan una cifra y su “%”, “p.” o “pp.” y su página, “s. f.” y unas iniciales con su apellido, y un estilo de carácter “Sin corte” (NoBreak en el IDML) mantiene unidas iniciales con guion como “B.-N.”. Antes de partir una tabla, prueba si cabe con filas compactas; si igual hay que partirla y la continuación quedaría con dos filas, la parte en mitades parejas, cada una a página completa.
- **Cómo estaba antes:** “Agradecimientos” casi tocaba el borde del panel; “%”, “S138”, “f.)” o “Sanders” podían quedar solos al comienzo de una línea, y la Tabla 4 dejaba dos filas en una página casi vacía.
- **Por qué:** la revisión página por página del 25 de noviembre, pedida por el autor para dejar la memoria lista.

### 2026-11-25 — Cada figura en la página de su mención

- **Qué cambió:** el generador coloca cada figura en la página de la línea que la nombra (D-193): las figuras de columna, al llegar a esa línea, al pie de su columna o en una columna libre a su derecha; las dobles, en las columnas 2 y 3. Suma la marca `<!-- página -->`, una versión a página completa que la búsqueda puede elegir para las figuras dobles o anchas y para las tablas, páginas de figuras alineadas arriba y abajo, figuras vecinas que empiezan a la misma altura, la marca de Relevo en el mapa y piezas al pie que suben bajo el texto en la última página de un capítulo. La búsqueda al azar cuenta pruebas (`BUSQUEDA_PRUEBAS`) y `PROBAR` acepta `fN=auto`. Un final con dos o tres líneas solas pesa como una columna sola.
- **Cómo estaba antes:** una pieza podía ir en la página siguiente a su mención, la mención era la del párrafo entero y la búsqueda duraba un tiempo fijo, así que el reparto cambiaba según el computador.
- **Por qué:** el autor pidió que una figura no se mencione en una página y aparezca en la siguiente, salvo a página completa.

### 2026-11-25 — Esquema de tensión, íconos de Lucide y referencias más juntas

- **Qué cambió:** el generador reconoce el «esquema de tensión» como secuencia, con sus colores; la lámina de identidad dice «Íconos de Lucide y propios con sus reglas»; los íconos de `marca-e-iconos.json` son los de la app 4.8.2, tomados de los SVG de Lucide y de los propios, y las referencias usan un interlineado de 13,4 y 1,2 de espacio entre ellas. Las tablas de este documento siguen la numeración nueva, con 41 figuras.
- **Cómo estaba antes:** los íconos eran los de la 4.7.2, la lámina decía «Íconos propios» y las referencias, con un interlineado de 14 y 1,5 de espacio, habrían terminado en una columna corta con las cuatro fuentes nuevas.
- **Por qué:** el autor decidió llevar a la memoria los íconos de la 4.8.2 y los tres puntos de fondo (D-191, D-192).

### 2026-11-24 — Imágenes al cierre de los capítulos e índices de Majluf

- **Qué cambió:** el generador pone una figura bajo la última columna de texto de su capítulo (`<!-- cola -->`) y cuenta como casi vacía una página sin texto con una sola figura chica; seis imágenes reales rellenan los finales cortos; el índice general tiene más margen en sus cajas y el de tablas y figuras va sin cajas.
- **Cómo estaba antes:** cinco capítulos y el glosario terminaban en una columna corta; las cajas del índice general tenían poco margen a la izquierda y el índice de tablas y figuras apretaba sus filas en cajas blancas.
- **Por qué:** el autor pidió que ninguna página quede con una columna diminuta de texto y rellenar con imágenes reales; Majluf pidió más margen y un índice de tablas y figuras sin cajas (D-190).

### 2026-11-24 — D-190

- **Qué cambió:** la decisión de las figuras claras y en orden, esquemas sin fichas y menos comas se cita como D-190.
- **Cómo estaba antes:** se citaba como D-187, el mismo número que la rama `iconos-lucide` usa para los íconos de Lucide.
- **Por qué:** al unir `main` con la rama, los dos D-187 chocaban; se renumeró el que tenía menos referencias y ninguna en el código de la app.

### 2026-11-24 — Esquemas sin fichas, figuras en orden y paneles completos

- **Qué cambió:** los esquemas dejan las fichas con reglas de tabla y usan puntos de color, números y flechas en las secuencias; la matriz de dos por dos lleva ejes con nombre; una coma dentro de una cita ya no parte un elemento (Figuras 10 y 21). Las aperturas conservan su panel completo: una figura doble puede ir al pie de las otras dos columnas. Las Figuras 8 (en lista), 9 y 16 cambian de ancho para quedar junto a su mención y en orden. Dos figuras chicas pueden compartir una columna, y una página sin texto con una sola figura chica cuenta como casi vacía. En dos columnas, el gráfico de barras lleva los dos primeros grupos a la izquierda.
- **Cómo estaba antes:** los esquemas eran fichas blancas con filas separadas por líneas, algunas aperturas tenían el panel acortado y, con el texto nuevo, dos figuras quedaban dos páginas después de su mención.
- **Por qué:** el autor pidió figuras claras, ordenadas y con un orden de lectura evidente, y paneles completos como el de Introducción (D-190).

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
