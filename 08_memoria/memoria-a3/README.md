# Memoria en A3 horizontal

**Fecha:** 12 de octubre de 2026. **Decisión:** D-132. **Archivo para leer:** [memoria-relevo-a3.pdf](memoria-relevo-a3.pdf), de 32 páginas A3 horizontales y 6,3 MB. La [versión HTML](memoria-relevo-a3.html) es la misma composición y se abre en el navegador.

## Pedido

El autor pidió hacer su memoria diseñada en A3 horizontal, a partir de la v5 subida al repositorio: «bien diseñada, no como un documento aburrido», con el diseño de Relevo.

## Qué es

Es la composición del [borrador v5](../borrador-memoria-v5-2026-10-11.md) en la línea visual de Relevo. **El texto de la v5 no cambia:** no se corrigió, resumió ni reordenó. Sus 24 marcadores «Confirmar» siguen a la vista, resaltados en amarillo, para que se resuelvan antes de la entrega.

Lo único que se agregó al texto:

- **Nota de la figura 2:** dice que las capturas son de la versión 3.2, tomadas en el emulador con datos de prueba, mientras el texto describe la 2.30. Lleva su propio marcador: hay que confirmar qué versión se presentará.
- **Figura 3:** la v5 la pide como fotografía, que todavía no existe. En su lugar va un recuadro rotulado «Fotografía pendiente» con la descripción de la v5.

## Diseño

| Elemento | Cómo va |
| --- | --- |
| Hoja | A3 horizontal (420 × 297 mm), papel `#F7F4F0` hasta el borde. Márgenes de 20 mm arriba, 19 mm abajo y 22 mm a los lados. |
| Texto | Instrument Sans, la letra de la app, en 10 pt con interlineado 1,5, en tres columnas de 118 mm con 11 mm de separación. |
| Encabezado y pie | Arriba, «Relevo · Memoria de título» y el capítulo de la página. Abajo, «Borrador de diseño · texto de la v5 del 11 de octubre de 2026» y el número de página. |
| Portada | El logo, el título y, como en la bienvenida de la app, la actividad «Leer» en su cielo, con su primer paso y su lugar en filas que flotan sobre el aura. La identificación académica va abajo, tal como está en la v5. |
| Apertura de capítulo | Un panel del alto de la columna, con el aura con grano, el número grande, el título y la lista de secciones. Cada capítulo empieza en la columna libre que deja el anterior; si queda poco espacio, el panel se achica, y si no cabe, pasa a la página siguiente. Así no quedan páginas casi vacías. |
| Capítulos breves | El 1, «Motivación personal», se lee a una columna y en letra grande. El 4, «Justificación», ocupa dos columnas con la letra mayor que cabe. Cada uno llena su página. |
| Pregunta e hipótesis | En una ficha sobre el aura, con su rótulo en una cápsula. |
| Criterios de diseño | Numerados en un círculo de tinta. |
| Tablas y figuras | A lo ancho de la página: al pie de la página donde se mencionan, si caben, o arriba de la siguiente. El rótulo «Tabla N» o «Figura N» va en una cápsula de tinta; el título, en cursiva, y la nota, debajo, según APA 7. |
| Figuras | La 1 (intención, lugar, condición y decisión) y la 4 (diseño de la prueba de 21 días) se dibujaron con lo que dice la propia v5 y con los íconos de Relevo (D-124). La 2 son seis capturas de la app. La 3 es el recuadro «Fotografía pendiente». |
| Índice | Capítulos, tablas y figuras con su página. Los números se calculan al componer. |
| Referencias y glosario | En tres columnas, en letra menor; las referencias, con sangría francesa. Si la última página del glosario queda casi vacía, se compone de nuevo con la letra un poco menor. |
| Anexos | Una ficha por anexo, con su letra. |
| Contraportada | El logo sobre el aura y el descriptor. |

El aura y el cielo se dibujan con grano, como en la app, y se guardan como JPEG en [`figuras/aura/`](figuras/aura/). Antes eran degradados del navegador, y el PDF pesaba 31 MB.

## Figura 2: cómo se tomaron las capturas

Las seis pantallas de «Preparar» se capturaron el 12 de octubre de 2026 en el emulador, con la app 3.2 y sus textos finales («Tus pasos»):

1. Primero se respaldaron los datos del autor que había en el emulador.
2. Con el modo avión activo, se borraron los datos de la app y se recorrió la primera vez con un perfil de prueba.
3. Se preparó un relevo: «Leer 10 páginas», «Abrir el libro», «En el velador», 15 minutos en Chrome y Clock (los nombres de las apps del emulador), y el teléfono como lugar donde suena.
4. Después se restauraron los datos del autor. Quedaron idénticos (MD5) y con los mismos permisos.

Las capturas no muestran nombres ni códigos. Se guardaron a la mitad de su tamaño: 540 × 1200 píxeles, unos 250 ppp en la página.

## Cómo se genera

```bash
node construir.js
```

[`construir.js`](construir.js) se corre desde esta carpeta y necesita Node y Google Chrome. Tarda unos 10 segundos y hace tres cosas:

1. Lee la v5 y arma una página HTML con todos sus bloques.
2. Chrome sin ventana corre un paginador que llena cada A3 bloque por bloque y corta los párrafos al final de la página. Deja al menos dos líneas a cada lado del corte y no deja un título solo al pie. Ubica las tablas y figuras y escribe los números del índice. El resultado se guarda como [memoria-relevo-a3.html](memoria-relevo-a3.html).
3. Chrome imprime ese HTML como PDF.

El script avisa si una página se desborda, si una pieza no cabe o si el PDF tiene un número de páginas distinto del que calculó el paginador.

Otros archivos de la carpeta:

- [`marca-e-iconos.json`](marca-e-iconos.json) guarda el logo y los 72 íconos, sacados de la lámina [«Relevo, la app»](../../10_recursos_visuales/rediseno-app-2026-10-11/relevo-la-app.html).
- La letra es la Instrument Sans que ya está en la app (licencia OFL). No se agregó ningún archivo de letra.

Si la v5 cambia, basta con volver a correr el script.

## Verificación

- **Páginas:** 32, y el paginador y el PDF coinciden.
- **Avisos:** ninguna página se desborda y ninguna pieza queda sin lugar.
- **Revisión:** se revisaron todas las páginas en hojas de contacto y varias de cerca: la portada, la página de la figura 2 y aperturas de capítulo en la columna 1, 2 y 3.
- **Índice:** sus números coinciden con las páginas del PDF.

## Límites y pendientes

- **Texto:** todavía faltan los 24 marcadores de la v5, la fotografía de la figura 3 y los resultados de la prueba de 21 días.
- **Versión de la app:** la v5 describe la app 2.30 y las capturas son de la 3.2. El capítulo 11 debe ponerse al día o las capturas deben coincidir con la versión que se presente.
- **Impresión:** no se probó en papel. Los colores no tienen prueba de imprenta, y el aura puede verse distinta en una impresora de oficina.
- **Formato:** el texto va en bandera, sin división de palabras, y no se revisó con un lector de pantalla.
- **App:** al tomar las capturas aparecieron dos textos para revisar, que no se cambiaron:
  - En la primera vez, el botón dice «Armar mi ruta».
  - En «¿Dónde suena?», la línea «Suena en el Tag. Si prefieres otra cosa, elígela.» sigue visible aunque se haya elegido el teléfono.

## En curso: la versión editable y el rediseño (13 de octubre de 2026)

**Lo que pidió el autor:**

- texto más grande y una lectura más cómoda;
- una escala de tamaños coherente;
- menos repetición y más juego de diseño;
- mejores tablas;
- ninguna viuda;
- sin etiquetas innecesarias, como «Capítulo»;
- sin el panel grande repetido en cada apertura;
- un archivo que se pueda editar en InDesign, Affinity o similares.

**Lo hecho:**

- **Letra:** Instrument Sans, redonda y cursiva, quedó instalada para el usuario de Windows, con permiso del autor. La cursiva es de Google Fonts (OFL) y no se guardó en el repositorio.
- **Escritor de IDML:** [idml.js](idml.js) escribe IDML, el formato de intercambio que abren InDesign y Affinity. Incluye estilos de párrafo y de carácter, colores, capas, una página maestra con el número de página, marcos de texto enlazados, tablas e imágenes o PDF vinculados.
- **Prueba en Affinity:** una página de muestra se abrió bien, con estilos, texto enlazado entre páginas, tabla con reglas, imágenes, PDF colocado y el idioma español (`$ID/Spanish: Castilian`).

**Archivo editable (13 de octubre de 2026):**

- **Generador:** [construir-idml.js](construir-idml.js) lee la v5 y escribe `memoria-relevo-a3.idml`, que se abre en Affinity o InDesign. Se corre con `node construir-idml.js` y necesita Google Chrome, que dibuja las luces, el logo y las figuras 1 y 4, y mide el alto de cada bloque para repartir las columnas.
- **Qué trae:** 33 páginas A3 horizontales, tres columnas con texto de 11,5 pt y la escala única (8, 9,5, 11,5, 15, 20 y 200 pt); una luz de color con el número de cada capítulo; un texto enlazado por capítulo, que se reacomoda al editar; tablas y figuras a lo ancho, arriba de la página siguiente a su mención, y las tablas de hasta tres columnas con el título y la nota al lado; índice con los números de página; estilos de párrafo y de carácter con nombre; y los marcadores «Confirmar» resaltados.
- **Viudas:** cada párrafo lleva un espacio fijo entre sus dos últimas palabras.
- **El IDML no se guarda en el repositorio:** sus imágenes se enlazan con la ruta completa del computador donde se generó. Hay que generarlo en la carpeta donde se va a trabajar.
- **Comprobado en Affinity 3.2 (Mac):** abre con sus 33 páginas, el texto enlazado, las tablas con sus reglas y el alto de fila, las imágenes y los PDF colocados.
- **No comprobado:** el aspecto con Instrument Sans, que no estaba instalada en ese computador; Affinity usó una letra de reemplazo. Tampoco se imprimió ni se exportó el PDF.
- **Límites:** Affinity no lee el relleno de las celdas del IDML, así que el aire de cada fila se da con su alto mínimo. El reparto de columnas se calcula con holgura: si al cambiar la letra o el texto sobra o falta una columna, se ajusta a mano o se vuelve a correr el generador. La figura 3 sigue como «Fotografía pendiente».

**Lo que sigue:**

- **Letra:** instalar Instrument Sans, redonda y cursiva, antes de abrir el archivo.
- **Revisión en Affinity:** recorrer las 33 páginas con la letra instalada y exportar el PDF desde ahí.

## Registro de cambios (disclaimer)

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
