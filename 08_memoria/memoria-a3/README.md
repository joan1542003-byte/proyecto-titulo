# Memoria en A3 horizontal

**Decisiones:** D-132 (la memoria en A3 con la línea de Relevo), D-134 (tablas y cifras como piezas de la marca), D-135 (letra grande, aire y control de viudas sobre el diseño del 12 de octubre) y D-145 (líneas de 8 a 12 palabras, cada sección en página nueva y portada limpia).

**Para leer:** [memoria-relevo-a3.pdf](memoria-relevo-a3.pdf), de 57 páginas A3 horizontales. La [versión HTML](memoria-relevo-a3.html) es la misma composición y se abre en el navegador.

**Para editar:** `memoria-relevo-a3.idml`, que se abre en Affinity o InDesign. No se guarda en el repositorio (ver «Cómo se genera»).

## Pedidos

- **12 de octubre de 2026:** hacer la memoria diseñada en A3 horizontal, a partir de la v5: «bien diseñada, no como un documento aburrido», con el diseño de Relevo.
- **13 de octubre, primera ronda:** texto más grande y lectura más cómoda; una escala de tamaños coherente; mejores tablas; ninguna viuda; sin etiquetas innecesarias, como «Capítulo»; un archivo editable en InDesign, Affinity o similares.
- **13 de octubre, segunda ronda:** tablas y estadísticas diseñadas, sin tablas genéricas: «es una memoria de diseño, debe verse como tal».
- **13 de octubre, tercera ronda:** instalar la tipografía; volver a un diseño más fiel al del 12 de octubre; todo se veía muy pequeño y amontonado; debe leerse perfecto en tamaño real y en pantalla; sin viudas.
- **28 de octubre:** ordenarla, con no más de 8 a 12 palabras por línea en los párrafos; entregarla para Affinity; una portada más limpia; por ahora, sin agradecimientos y sin tablas ni figuras en el índice.

## Qué es

Es la composición del [borrador v5](../borrador-memoria-v5-2026-10-11.md) en la línea visual de Relevo. **El texto de la v5 no cambia:** no se corrige, resume ni reordena al componer. Sus marcadores «Confirmar» siguen a la vista.

Lo único que la composición agrega o adapta:

- **Portada:** solo la institución, el logo, el título y los datos de la v5. Lo que falta confirmar va en gris, sin resaltar.
- **Omisiones, por ahora:** los agradecimientos y los índices de tablas y de figuras (D-145). Se vuelven a poner en `construir-idml.js`, con `OMITIR` e `INDICE_DE_PIEZAS`.
- **Tablas:** el estado («Implementado», «Parcial», «Pendiente», «Cumplido») pasa a una cápsula y su detalle empieza con mayúscula; los objetivos numerados llevan su número en un círculo; las versiones van en cápsulas.
- **Figuras 2 y 5:** se dibujan con lo que dice la propia v5. La figura 4 compone las tres fotos de la v5 en fila, en dos columnas, cada una con su letra y su pie, y el título y la nota en la tercera columna.

## Diseño

| Elemento | Cómo va |
| --- | --- |
| Hoja | A3 horizontal (420 × 297 mm), papel `#F7F4F0` hasta el borde. Márgenes: 24 mm arriba, 26 mm abajo y 22 mm a los lados. Tres columnas de 118 mm con 11 mm de separación. |
| Escala | Siete tamaños: 9, 11, 14, 18, 28, 44 y 150 pt. |
| Texto | Instrument Sans de 14 pt con interlineado de 20 pt, en bandera y sin división de palabras: unas 48 letras y 8 palabras por línea, y 35 líneas por columna. |
| Largo de línea | Todo el texto corrido va en columnas de 118 mm, también el resumen, el abstract y el capítulo 1, para que las líneas tengan de 8 a 12 palabras (D-145). Las notas de tablas y figuras, en 11 pt, también: en una columna o, si son largas, en dos. |
| Encabezado y pie | Arriba, «Relevo · Memoria de título» y la sección de la página. Abajo, el número de página. |
| Portada | El aura a sangre, la institución, el logo, el título en 44 pt y los datos. |
| Apertura de sección | Un panel de aura con grano del alto de la columna, con el número en 150 pt, el título en 28 pt y la lista de secciones. Cada sección abre en una página nueva: el panel en la primera columna y el texto desde la segunda. Sin la etiqueta «Capítulo». |
| Pregunta e hipótesis | En una ficha sobre el aura, con su rótulo en una cápsula. Viajan con el párrafo que las anuncia. |
| Tablas y figuras | A lo ancho, arriba de la página siguiente a su mención. El rótulo va en una cápsula de tinta; el título, en cursiva, y la nota, debajo (APA 7). Las tablas de hasta tres columnas llevan título y nota al lado. Una tabla más alta que la página se parte en dos: la segunda parte repite la cabecera y dice «(continuación)». |
| Tablas | Una ficha blanca por fila; círculo de tinta con un icono de la app, el número de la fila o la versión; estados en cápsulas. Texto de 11 pt. |
| Cifras (figuras 1 y 6) | Una ficha por dato: valor en 44 pt, total en gris, explicación y una barra o un punto por caso, con el color del papel al que pertenece el dato. |
| Color | Solo donde nombra un papel del sistema («un color, un papel»). |
| Índice | Fichas con el número de la sección, su título y su página, en dos columnas. Los números se calculan al componer. Por ahora no lista tablas ni figuras. |
| Referencias y glosario | En tres columnas, en 11 pt; las referencias, con sangría francesa. |
| Anexos | Una ficha por anexo, con su letra. |
| Contraportada | El logo sobre el aura y el descriptor. |

### Aire

- Todo el espacio vertical va después de cada párrafo; un subtítulo lleva 15 pt extra arriba, salvo cuando cae al inicio de una columna.
- Entre las tablas o figuras de arriba y el texto hay 12 mm. Si bajo ellas quedan menos de 60 mm, la página queda solo para ellas.
- Cada sección empieza en una página nueva. Una tabla o figura que quedaría sola después del texto de su sección sube a la última página de ese texto, si cabe.

### Viudas

- **Líneas sueltas:** ningún párrafo deja menos de dos líneas a cada lado de un corte de columna, y ningún subtítulo queda al pie sin dos líneas de su texto. El generador reparte el texto línea por línea con esa regla, y los estilos del IDML la llevan también (Affinity la respeta).
- **Palabras sueltas:** las últimas palabras de cada párrafo van unidas con espacios fijos, de modo que el último renglón tenga al menos unas doce letras. En las celdas se unen las dos últimas palabras.

## Figura 3: cómo se tomaron las capturas

Las seis pantallas de «Preparar» se capturaron el 12 de octubre de 2026 en el emulador, con la app 3.2 y sus textos finales («Tus pasos»):

1. Primero se respaldaron los datos del autor que había en el emulador.
2. Con el modo avión activo, se borraron los datos de la app y se recorrió la primera vez con un perfil de prueba.
3. Se preparó un relevo: «Leer 10 páginas», «Abrir el libro», «En el velador», 15 minutos en Chrome y Clock (los nombres de las apps del emulador), y el teléfono como lugar donde suena.
4. Después se restauraron los datos del autor. Quedaron idénticos (MD5) y con los mismos permisos.

Las capturas no muestran nombres ni códigos. Se guardaron a la mitad de su tamaño: 540 × 1200 píxeles.

## Cómo se genera

```bash
node construir-idml.js
```

[`construir-idml.js`](construir-idml.js) se corre desde esta carpeta y necesita Node y Google Chrome. Tarda cerca de un minuto y escribe tres archivos con el mismo reparto: el IDML, el HTML y el PDF.

1. Lee la v5 y la parte en secciones, párrafos, tablas y figuras.
2. Chrome sin ventana mide cuántas líneas ocupa cada párrafo en su columna y cuánto mide cada pieza.
3. Node reparte el texto línea por línea, con las reglas de viudas, y ubica paneles, tablas y figuras.
4. Cada pieza (tabla, figura, panel, frase, índice, anexos, portada) se compone en Chrome. Su fondo se guarda como PDF vectorial en `figuras/idml/`; en el IDML, su texto va encima como texto vivo, con su estilo de párrafo.
5. Chrome imprime el HTML como PDF.

Otros archivos:

- [`idml.js`](idml.js) escribe el IDML: estilos de párrafo y de carácter, colores, capas, página maestra, marcos de texto enlazados e imágenes o PDF vinculados.
- [`marca-e-iconos.json`](marca-e-iconos.json) guarda el logo y los 72 íconos, sacados de la lámina [«Relevo, la app»](../../10_recursos_visuales/rediseno-app-2026-10-11/relevo-la-app.html).
- [`figuras/aura/`](figuras/aura/) guarda las auras con grano, como JPEG. El generador dibuja las que falten; la misma semilla da siempre la misma imagen.
- [`construir.js`](construir.js) es el generador del 12 de octubre (texto de 10 pt, HTML paginado en el navegador). Queda como registro: escribe los mismos archivos de salida, así que no hay que correrlo.

**El IDML no se guarda en el repositorio:** sus fondos se enlazan con la ruta completa del computador donde se generó. Hay que generarlo en la carpeta donde se va a trabajar.

**Para cambiar el texto o una tabla:** se edita la v5 y se vuelve a correr el generador. En Affinity se puede corregir el texto vivo, pero las fichas no crecen solas.

## Letra

- **En el generador:** la redonda es la Instrument Sans variable de la app; la cursiva está en [`letra/`](letra/), con su licencia (SIL Open Font License 1.1). Viene de Google Fonts.
- **En el computador:** Affinity necesita Instrument Sans instalada. El 13 de octubre de 2026 se instaló en el Mac del autor, con su permiso, en `~/Library/Fonts`.
- **Estilos fijos, no la letra variable:** con el archivo variable, Affinity dibujaba todos los pesos en regular. Se instalaron ocho estilos fijos (Regular, Medium, SemiBold y Bold, con sus cursivas), generados de los archivos variables con fontTools (`varLib.instancer`, ancho 100).

## Verificación

- **Avisos:** el generador avisa si una página de entrada, el índice, los anexos o una tabla no caben, o si tuvo que cortar un párrafo a la fuerza. El 28 de octubre no dio ningún aviso.
- **Palabras por línea,** contadas en el PDF del 28 de octubre con `pdftotext`:
  - Texto: 7,8 en promedio y 11 o menos en el 95 % de las 2178 líneas. Seis tienen 13 o 14 palabras por las cifras, como «el 11 y el 12 de junio de 2026».
  - Notas, referencias y glosario, a 11 pt: 12 o menos en el 95 % de las líneas. Las que pasan son referencias con iniciales y algunas celdas de tabla, de hasta 16.
  - Antes, el resumen y el abstract tenían de 13 a 17 palabras por línea, y una nota llegaba a 41.
- **PDF:** 57 páginas. Se revisaron la vista de todas y, de cerca, la portada, el resumen, el índice, la tabla 2 con su nota en dos columnas y las dos partes de la tabla 7.
- **IDML del 28 de octubre:** 541 archivos, todos los XML bien formados y sus 46 enlaces existen. No se abrió en Affinity en esta ronda.
- **Affinity 3.2 (Mac), con Instrument Sans instalada,** el 13 de octubre:
  - Una prueba aparte confirmó que Affinity respeta el control de viudas y huérfanas del IDML y que parte las líneas igual que Chrome.
  - Las páginas 9 y 36 del archivo coinciden línea por línea con el PDF; la 36 cierra el capítulo más largo.
  - Se revisaron la portada, un panel, la tabla 1, la tabla 8 y la figura 1: fondos, iconos y texto vivo en su lugar.
- **No comprobado:** no se recorrieron las 53 páginas en Affinity, no se exportó el PDF desde Affinity y no se imprimió.

## Límites y pendientes

- **Texto:** faltan los marcadores de la v5 y el resto de los resultados de la prueba.
- **Marcadores «Confirmar»:** en el PDF van resaltados en amarillo; en Affinity, subrayados.
- **Páginas con aire de sobra:** cuando una tabla alta coincide con el fin de un capítulo, la página queda con la tabla sola, como la tabla 8 y la tabla 11. Cada sección en página nueva suma también columnas en blanco al final de algunas.
- **Biblioteca:** su pauta exige índices de tablas y de figuras para el depósito; por ahora el índice no los tiene.
- **Impresión:** los colores no tienen prueba de imprenta, y el aura puede verse distinta en una impresora de oficina.
- **Accesibilidad:** no se revisó con un lector de pantalla.

## Registro de cambios (disclaimer)

### 2026-10-28 — Ordenada, con líneas de 8 a 12 palabras

- **Qué cambió:** todo el texto corrido pasa a columnas de 118 mm, también el resumen, el abstract y el capítulo 1; las notas de tablas y figuras van en una o dos columnas de ese ancho. Cada sección abre en una página nueva, y una tabla o figura que quedaría sola al final de su sección sube a su última página de texto. La tabla 7, más alta que la página, se parte en dos. La portada queda con la institución, el logo, el título y los datos; los marcadores van en gris. Se quitan, por ahora, los agradecimientos y las tablas y figuras del índice. Chrome se reintenta si falla.
- **Cómo estaba antes:** el resumen, el abstract, los agradecimientos y el capítulo 1 iban en 18 pt a una columna ancha, con 13 a 17 palabras por línea; las notas iban a todo el ancho, con hasta 41; cada sección abría en la primera columna libre; la tabla 7 se salía de la página; la portada tenía el ejemplo de la app y el descriptor «Memoria de título». Eran 54 páginas.
- **Por qué:** el autor pidió ordenarla, con no más de 8 a 12 palabras por línea en los párrafos, una portada más limpia, sin agradecimientos y sin tablas ni figuras en el índice, y el archivo para Affinity (D-145).

### 2026-10-20 — Fotos de la Figura 4

- **Qué cambió:** el generador lee imágenes de la v5 (`![pie](ruta)`) y compone una figura de fotos en dos columnas, con su letra, su pie como texto vivo y el título y la nota al lado. Se regeneró con la v5 del día: fotos, seis lecturas nuevas y el recorte.
- **Cómo estaba antes:** la figura 4 era un recuadro «Fotografía pendiente».
- **Por qué:** el autor entregó las fotos de la prueba (D-140).

### 2026-10-20 — Memoria con el tono revisado

- **Qué cambió:** se regeneró con el borrador v5 revisado (logros primero, límites una sola vez, tres personas en la prueba). Las cápsulas de estado reconocen «En curso» y «Avanzado».
- **Cómo estaba antes:** la versión A3 era del 13 de octubre, con los resultados de una persona.
- **Por qué:** el autor pidió actualizar la memoria con los datos nuevos y revisar su tono.

### 2026-10-13 — Letra grande, aire y viudas sobre el diseño del 12 de octubre

- **Qué cambió:** el generador se rehízo. Vuelven los paneles de aura, la portada con el ejemplo de la app, las fichas del índice y de los anexos y las frases sobre el aura; el texto pasa a 14 pt; el reparto es línea por línea; el generador escribe también el HTML y el PDF. Se instaló Instrument Sans y se añadió su cursiva. Este documento se reescribió entero.
- **Cómo estaba antes:** texto de 11,5 pt, una luz de color por capítulo en vez del panel, reparto por alto estimado y un PDF del 12 de octubre que no traía los cambios posteriores.
- **Por qué:** el autor dijo que todo se veía muy pequeño y amontonado, y pidió un diseño más fiel al del 12 de octubre, sin viudas (D-135).

### 2026-10-13 — Tablas y cifras con la línea de la marca

- **Qué cambió:** se documentó el rediseño de las tablas y de las cifras, la página de agradecimientos y el reconocimiento de las figuras por su contenido.
- **Cómo estaba antes:** las tablas eran tablas nativas con reglas finas y las figuras se elegían por su número.
- **Por qué:** el autor pidió que la memoria se viera como una memoria de diseño, sin tablas genéricas.

### 2026-10-13 — Archivo editable para Affinity

- **Qué cambió:** se añadió el generador del IDML y se documentó qué trae, qué se comprobó en Affinity y sus límites.
- **Cómo estaba antes:** existía el escritor de IDML y una página de prueba, pero no la memoria completa en ese formato.
- **Por qué:** el autor pidió diseñar la memoria para Affinity.

### 2026-10-13 — Versión editable en curso

- **Qué cambió:** se sumaron el pedido de rediseño, el escritor de IDML y su prueba en Affinity, y lo que sigue.
- **Cómo estaba antes:** la memoria en A3 era solo HTML y PDF.
- **Por qué:** pedido del autor del 13 de octubre (D-132).

### 2026-10-12 — Creación

- **Qué se añadió:** la memoria v5 compuesta en A3 horizontal con la línea de Relevo (PDF y HTML), su generador, el logo y los íconos, los fondos de aura y las capturas nuevas de la figura 2.
- **Cómo estaba antes:** la v5 existía solo en Markdown, sin diagramación.
- **Por qué:** pedido del autor del 12 de octubre (D-132).
