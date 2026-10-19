# Bitácora del trabajo con IA: 8 al 11 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code entre el 8 y el 11 de octubre de 2026. Continúa la [bitácora del 7 de octubre](bitacora-trabajo-con-ia-2026-10-07.md). Cada pedido está, con sus palabras resumidas, en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Fecha | Trabajo | Resultado | Decisión |
| --- | --- | --- | --- |
| 8 oct. | Apps y productos parecidos | Respuesta en la conversación: one sec, Brick, Unpluq, ScreenZen y Tiempo de pantalla resuelven partes del problema, pero ninguno recuerda una actividad propia con su primer paso ni avisa desde un objeto ubicado donde se empieza. Se recomendó no llamar «único» a Relevo y hacer una revisión formal para la memoria. | — |
| 9 oct. | Android 2.30 | Editar un relevo sin borrarlo, antes y después de activarlo; si cuenta las mismas apps, sigue con el tiempo que llevaba ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.30-editar-sin-borrar-2026-10-09.md)). | D-120 |
| 10 oct. | Relevo con aura, versiones 1 y 2 | Exploración inspirada en Dafi (Behance). El autor pidió perfeccionarla, verla en blanco y no traer nada de lo que ya existe de Relevo; la versión 2 tiene solo modo claro, aura dibujada en tiempo real con grano, cielos por actividad, seis pantallas y piezas nuevas ([documento 38](../10_recursos_visuales/38_relevo-con-aura-2026-10-10.md)). | D-121 |
| 11 oct. | Relevo con aura, versión 3 | El aura es de la pantalla y se personaliza en Perfil › Tu aura; el Tag solo suena. Tablero de presentaciones. | D-121 |
| 11 oct. | Taller de auras, versión 1 | Generador de fondos con aura: presets de presentación, auras, cielos y elementos; formatos para diapositivas y la memoria; descarga en PNG. | D-121 |
| 11 oct. | Taller de auras, versión 2 | El autor pidió las piezas con diseño de la exploración, como «3 de 5». Ahora son 39 piezas editables (datos, fichas, tarjetas, controles, marca y siete pantallas), que salen solas en PNG transparente, copiadas, en lámina o en ZIP ([taller](../10_recursos_visuales/relevo-con-aura-2026-10-10/taller-de-auras.html)). | D-121 |
| 11 oct. | Sin giros | Las tarjetas y las piezas quedan derechas en el taller y en la lámina de la exploración. | D-121 |
| 11 oct. | Relevo con aura, versión 4 | Una gráfica propia: íconos después de lo que nombran, un color con un solo papel, la marca de los cuatro peldaños, el Tag que suena en anillos, y los tableros «El traspaso» y «Sistema» ([documento 38](../10_recursos_visuales/38_relevo-con-aura-2026-10-10.md)). | D-122 |
| 11 oct. | Íconos y color con fundamento | 72 íconos propios y la paleta 2. Cada color tiene un papel, fundado en estudios de 31 países, en ISO 3864 y en medidas en OKLCH, contraste y daltonismo ([documento 39](../10_recursos_visuales/39_iconos-y-color-con-fundamento-2026-10-11.md); [lámina](https://claude.ai/artifact/NHpnEr63JXn6JqCfDotPC2)). | D-124 |
| 11 oct. | Logo, colores y recorrido | Un logo de cuatro luces planas con Chillax Semibold; la evidencia de color de Chile y Latinoamérica; siete familias de cielos para las actividades; y el recorrido en 12 wireframes con notas ([documento 40](../10_recursos_visuales/40_logo-colores-y-recorrido-2026-10-11.md); [lámina](https://claude.ai/artifact/5FCdqi76iF52dfNoFyYoeX)). | D-125 y D-126 |
| 11 oct. | Texto académico, rediseño y el lugar | El fundamento del color en el registro de la memoria. Además: 25 pantallas de la app con la línea nueva, el logo con degradado «Luz» y el lugar en vez del Tag como tercera luz. Se sumó el plan para actualizar a la 3.0 sin perder datos ([documento 41](../10_recursos_visuales/41_fundamento-del-color-texto-academico-2026-10-11.md); [lámina](https://claude.ai/artifact/E6nkPDDmDrDF9Gw8zNxnqM); [plan](../06_desarrollo_y_factibilidad/app-android/plan-rediseno-3.0-2026-10-11.md)). | D-127 y D-128 |
| 12 oct. | Android 3.0 | La línea nueva en la app, sin perder datos: se instaló sobre la 2.30 con datos y quedaron idénticos byte a byte; un relevo activo siguió contando tras actualizar ([versión 3.0](../06_desarrollo_y_factibilidad/app-android/version-3.0-la-linea-nueva-2026-10-12.md)). | D-129 |
| 12 oct. | Android 3.1 | El autor notó que la 3.0 no se parecía a la lámina. Se recompuso cada pantalla según la lámina: tarjetas sueltas, cápsulas sobre los cielos, el aura y el cielo a pantalla completa, la ruta en escalera y el perfil en una tarjeta. Mismos datos ([versión 3.1](../06_desarrollo_y_factibilidad/app-android/version-3.1-las-pantallas-de-la-lamina-2026-10-12.md)). | D-130 |
| 12 oct. | Android 3.2 | La 3.1 tampoco se parecía lo suficiente. La lámina se capturó a la escala del teléfono y se comparó pantalla por pantalla. Se rehicieron las piezas con sus medidas, las ideas se ordenaron por familia de color y se aclararon los textos que el autor encontró raros ([versión 3.2](../06_desarrollo_y_factibilidad/app-android/version-3.2-igual-a-la-lamina-2026-10-12.md)). | D-131 |
| 12 oct. | Memoria en A3 | La v5 compuesta en A3 horizontal con la línea de Relevo, en 32 páginas. Un paginador en Chrome llena cada página, ubica tablas y figuras y escribe el índice. Las capturas de la figura 2 se tomaron de nuevo con la 3.2, con datos de prueba ([memoria en A3](../08_memoria/memoria-a3/README.md)). | D-132 |
| 13 oct. | Memoria editable | El autor pidió letra más grande, tamaños coherentes, mejores tablas, sin viudas ni etiquetas sobrantes, y un archivo para InDesign o Affinity. Se instaló Instrument Sans y se escribió un generador de IDML. Su página de muestra se abrió bien en Affinity; el rediseño quedó en pausa. | D-132 |
| 13 oct. | Herramientas sin claude.ai | El panel, las láminas, el taller y los íconos pasan a funcionar solos desde el repositorio, con la guía [HERRAMIENTAS.md](../HERRAMIENTAS.md). | D-133 |
| 11 oct. | Documentación | El autor preguntó si todo estaba documentado. Faltaban esta bitácora, el estado en el README general y en el traspaso desde la app 2.24, y la decisión de la dirección visual; se completaron. | D-121 |

## 2. Cómo se usó la IA

- **La referencia se miró, no se copió:** las imágenes y videos de Dafi se revisaron en el navegador, sin descargarlos ni guardarlos. Todo lo de la exploración y del taller se dibujó de nuevo, sin material de la referencia.
- **El autor corrigió el rumbo cuatro veces:**
  - La versión 1 «no era similar» y se veía en oscuro.
  - El Tag no emite luz, así que el aura pasó a ser de la pantalla.
  - El taller no traía las piezas diseñadas.
  - Las piezas no debían girarse.

  En los cuatro casos la IA propuso y ejecutó, y el autor decidió.
- **Revisión con capturas:** cada versión se revisó en Chrome sin ventana, con capturas de escritorio y de teléfono y hojas de contacto con todas las piezas exportadas. Así se encontraron:
  - un grano con patrón diagonal en algunas pantallas, que se cambió por otro generador de ruido;
  - capturas en blanco por el desplazamiento de la página;
  - un error del taller que perdía lo editado: cada lectura recreaba los valores de la pieza;
  - miniaturas de pantallas demasiado chicas;
  - y el collage de la lámina disperso tras quitar los giros, que se ordenó en dos filas.
- **Referencias verificadas:** para la versión 4 se buscaron y se leyeron las fuentes de Apple (2024), Google Gemini e Instagram antes de citarlas; una afirmación sobre Instagram («momentos de descubrimiento») no se pudo confirmar en la fuente y se dejó fuera.
- **Medir antes de afirmar:**
  - Para los íconos se midió el asta de Instrument Sans en el navegador.
  - Para el color se calcularon la luminosidad y la saturación en OKLCH, el contraste según WCAG y la separación entre colores con daltonismo simulado. Así apareció que el amarillo y el lima casi se confundían, y se corrigió.
  - Los datos de las citas se comprobaron en Crossref.
  - Para los cielos se midió el contraste del texto en capturas, sobre el píxel más desfavorable del fondo. El texto blanco quedaba entre 2,6:1 y 3,7:1 en los cielos claros; con la cápsula blanca sube a entre 15:1 y 17,8:1.
- **Probar sin ensuciar los datos:** antes de probar la 3.0 se respaldó la clave de firma y los datos del emulador. Se trabajó sin conexión y, al terminar, se restauró el respaldo. Se comprobó que los datos quedaran idénticos (MD5) y que no se escribieran archivos en Documentos/Relevo. Durante la prueba apareció un relevo activo que no se había pedido; se descartó al restaurar.
- **Error de la IA en la 3.0:** aplicó la línea nueva a la superficie (colores, letra, íconos y cielos) y dejó la composición de la 2.30. Lo notó el autor, no la IA. En la 3.1 cada pantalla del emulador se comparó con la lámina, con capturas, antes de darla por terminada.
- **Un artefacto no es la única salida:** las páginas dependían de `window.claude` para leer datos y descargar. Un conector que ofrece la misma interfaz fuera de claude.ai las hizo funcionar sin tocar su lógica. El panel usa el servidor local con un token o, sin él, datos de ejemplo.
- **Mirar cada página, no solo el total:** la primera versión de la memoria en A3 tenía las auras invisibles, porque las comillas de `url()` cortaban el atributo `style`. Además pesaba 31 MB y dejaba páginas casi vacías: las tablas a lo ancho no cabían en la página que abre el capítulo. Solo se vio al revisar las páginas en hojas de contacto. El paginador propio resolvió los vacíos, pero partía el panel en dos columnas: su altura se redondeaba hacia arriba. Se midió antes de ubicarlo.
- **Comparar con la referencia, no de memoria:** en la 3.1 las pantallas se compararon con la lámina de memoria y quedaron diferencias que el autor sí vio. En la 3.2 la lámina se capturó a 411 dp con Chrome sin ventana y cada captura se puso junto a la del emulador. Así aparecieron la escala de 1,5, las fichas sin íconos, el botón que tapaba contenido y los colores salpicados.
- **Buscar evidencia local antes de suponerla:** se buscó un estudio de color hecho en Chile y no se encontró. Se usó una encuesta que incluye a Chile, presentada por la UNAM; por ser un boletín de prensa se marcó como apoyo y no como prueba. Una cifra del estudio de Medellín se corrigió antes de publicar: el azul tiene cerca de 75 % de aceptación, pero no es el color preferido.
- **El logo se probó en lo difícil:** la primera marca, con las luces mezcladas, dejaba un centro turbio; la elegida usa cortes planos. Se compararon 20 letras antes de elegir Chillax, y la fuente quedó fuera del repositorio.
- **Datos honestos:** las cifras de las piezas («3 de 5», «12 de 30 min», los minutos por app) son ejemplos de interfaz, no resultados. La única cifra real es la de las 53 respuestas de la encuesta (D-092). El saludo de la pantalla de inicio ya no usa un nombre de persona.

## 3. Qué se comprobó y qué no

- **Comprobado:**
  - En el taller se exportaron las 39 piezas sin errores y se recorrieron con clics la edición, la lámina, el respaldo cuando no hay descarga, los fondos y la persistencia al recargar.
  - Se generó y se abrió un ZIP.
  - Ni el taller ni la lámina se desbordan a lo ancho en un teléfono de 390 px.
  - La 2.30 se compiló, pasó sus pruebas unitarias y se revisó en el emulador.
  - La 3.0 y la 3.1 se compilaron limpias, pasaron 85 pruebas y se revisaron en el emulador; los datos del autor quedaron idénticos (MD5).
- **No comprobado:**
  - La descarga y el botón «Copiar» dentro de claude.ai con la confirmación real; en la prueba solo se vio el respaldo.
  - La 2.30 en un teléfono real, incluido que siga con el tiempo contado al editar.
  - La 3.0 y la 3.1 en un teléfono real, con TalkBack y con la letra al 200 %.

**14 de octubre, Android 2.31 (D-136):** una participante reportó que el Tag siguió sonando después de la prueba y, más tarde, sin parar. Se leyó su registro en Supabase, se encontró la causa en el código (órdenes que fallaban sin aviso y una desconexión sin esperar) y se hizo la [2.31](../06_desarrollo_y_factibilidad/app-android/version-2.31-el-tag-se-calla-2026-10-14.md) sobre la 2.30, con el ícono y el logo nuevos y la pila del Tag. El mismo arreglo quedó en la 3.2 de `main`. Se probó en el emulador, sin Tag real.

**17 de octubre, Android 2.32 (D-137):** la participante contó que el Tag suena lento y sin parar después de mucho tiempo sin uso. El registro de la 2.31 apuntó a la primera conexión después de mucho rato: el Tag respondía lento y la app cortaba la conexión, lo que dispara su alarma. La [2.32](../06_desarrollo_y_factibilidad/app-android/version-2.32-el-tag-no-se-corta-2026-10-17.md) nunca corta la conexión con esa alarma encendida, espera más y pide una conexión rápida.

**18 de octubre, Relevo como sistema:** se escribió un [documento](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/relevo-frontend-y-backend.md) que explica el frontend, el backend y el proyecto con sus fundamentos, a partir del código, la base remota, la memoria v5 y los registros. Las 39 pantallas de la 2.32 se recorrieron en el emulador sin conexión, y su árbol se convirtió en [wireframes de muy baja fidelidad](../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-relevo.html). Los datos del autor quedaron idénticos (MD5).

## 4. Pendientes

- Probar la 2.32 con el Tag real después de horas sin uso, con una pila nueva para descartar la pila.

- Probar la 2.31 con el Tag real de la participante: la prueba, una señal completa y la pila.

- Que el autor decida cuándo instalar la 3.1: no conviene a mitad de la prueba de 21 días.
- Que el autor revise el logo (D-125) y los colores de las actividades (D-126), y buscar en INAPI si hay marcas parecidas.
- Rehacer el video de «Cómo funciona» y actualizar el capítulo 11 de la memoria a la línea nueva.
- Probar la 2.30 en un teléfono real.
- Revisar el consentimiento v13 con el profesor.
- Hacer la revisión formal de apps y productos parecidos para la memoria.
- Probar en claude.ai la descarga, el ZIP y «Copiar» del taller.

## Registro de cambios (disclaimer)

### 2026-10-18 — Relevo como sistema

- **Qué cambió:** se sumaron el documento del sistema y los wireframes.
- **Cómo estaba antes:** terminaba en la 2.32.
- **Por qué:** pedido del autor.

### 2026-10-17 — Android 2.32

- **Qué cambió:** se sumó la 2.32 y su pendiente.
- **Cómo estaba antes:** terminaba en la 2.31.
- **Por qué:** pedido del autor (D-137).

### 2026-10-14 — Android 2.31

- **Qué cambió:** se sumaron el arreglo del Tag y la 2.31, con su pendiente.
- **Cómo estaba antes:** terminaba en las herramientas del 13 de octubre.
- **Por qué:** pedido del autor (D-136).

### 2026-10-13 — Herramientas y memoria editable

- **Qué cambió:** se sumaron la memoria editable en curso y las herramientas que funcionan sin claude.ai.
- **Cómo estaba antes:** terminaba en la memoria en A3 del 12 de octubre.
- **Por qué:** pedidos del autor (D-132, D-133).

### 2026-10-12 — Memoria en A3

- **Qué cambió:** se sumaron la memoria en A3 y lo aprendido al revisarla.
- **Cómo estaba antes:** terminaba en la app 3.2.
- **Por qué:** pedido del autor (D-132).

### 2026-10-12 — Android 3.2

- **Qué cambió:** se sumaron la 3.2 y el método de comparación con la lámina.
- **Cómo estaba antes:** terminaba en la 3.1.
- **Por qué:** pedidos del autor (D-131).

### 2026-10-12 — Android 3.1

- **Qué cambió:** se sumaron la 3.1, el error de la 3.0 y cómo se comparó con la lámina; se actualizaron lo comprobado y los pendientes, que aún decían que el aura no estaba en la app.
- **Cómo estaba antes:** terminaba en la 3.0, y las secciones 3 y 4 seguían en el estado anterior a la 3.0.
- **Por qué:** pedido del autor (D-130).

### 2026-10-12 — Android 3.0

- **Qué cambió:** se sumó la implementación de la 3.0 y cómo se probó sin ensuciar los datos.
- **Cómo estaba antes:** terminaba en el texto académico, el rediseño propuesto y el plan.
- **Por qué:** pedido del autor (D-129).

### 2026-10-11 — Texto académico, rediseño y el lugar

- **Qué cambió:** se sumaron el texto académico, el rediseño de la app y el plan 3.0.
- **Cómo estaba antes:** terminaba en el logo, los colores y el recorrido.
- **Por qué:** pedido del autor (D-127 y D-128).

### 2026-10-11 — Logo, colores y recorrido

- **Qué cambió:** se sumaron el logo, la evidencia regional, los colores de las actividades y el recorrido, con cómo se midieron.
- **Cómo estaba antes:** terminaba en los íconos y la paleta 2.
- **Por qué:** pedido del autor (D-125 y D-126).

### 2026-10-11 — Íconos y color

- **Qué cambió:** se sumaron los íconos y la paleta 2, y cómo se midieron.
- **Cómo estaba antes:** terminaba en la versión 4 de la gráfica.
- **Por qué:** pedido del autor (D-124).

### 2026-10-11 — Versión 4

- **Qué cambió:** se sumó la versión 4 de la gráfica y cómo se verificaron sus referencias.
- **Cómo estaba antes:** la bitácora terminaba en la documentación pendiente.
- **Por qué:** pedido del autor (D-122).

### 2026-10-11 — Creación

- **Qué se añadió:** la bitácora del 8 al 11 de octubre: apps parecidas, Android 2.30, «Relevo con aura» de la versión 1 a la 3, el Taller de auras en sus dos versiones, las piezas sin giros y la documentación que faltaba.
- **Cómo estaba antes:** la última bitácora era la del 7 de octubre; lo hecho después solo estaba en el registro de pedidos y en los documentos de cada entrega.
- **Por qué:** el autor preguntó si todo estaba documentado y la revisión mostró este vacío.
