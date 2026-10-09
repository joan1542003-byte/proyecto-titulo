# La memoria en Affinity

**Fecha:** 9 de octubre de 2026. **Estado:** propuesta de maqueta (D-121), pendiente de que el autor la abra en Affinity y la apruebe. **Dónde está:** [plantilla y fuentes](memoria-affinity/README.md).

## Qué se pidió y qué se entrega

El autor pidió configurar Affinity para que funcione como Adobe InDesign y dejarlo listo para diagramar la memoria de Relevo con calidad de diseño gráfico.

Desde este entorno no se puede abrir ni configurar el Affinity instalado en el computador del autor. Por eso la entrega tiene dos partes:

1. **Una plantilla que Affinity abre directamente:** [`plantilla-memoria-relevo-a3.idml`](memoria-affinity/plantilla-memoria-relevo-a3.idml). IDML es el formato de intercambio de InDesign; Affinity Publisher 2 y la app Affinity de Canva lo abren (Serif, s. f.). Trae el formato, la retícula, los estilos, las páginas maestras, los colores y el texto de la [memoria vigente](../08_memoria/memoria-vigente-v4.md) repartido en 40 páginas.
2. **Esta guía:** los ajustes y atajos de teclado que el autor debe hacer una vez para que Affinity se comporte como InDesign, y los pasos para abrir la plantilla, revisarla y exportar.

## Parte 1. Affinity como InDesign

Affinity guarda los ajustes por equipo, así que estos pasos se hacen una sola vez. Los nombres de menú pueden variar un poco entre Affinity Publisher 2 y la app Affinity de Canva; si un comando no aparece donde se indica, búscalo con el buscador de **Ajustes › Atajos de teclado** o en la ayuda de la app.

### 1. Instalar las fuentes

Antes de abrir la plantilla, instala las once fuentes de [`memoria-affinity/fuentes/`](memoria-affinity/fuentes/): Schibsted Grotesk en ocho estilos e IBM Plex Mono en tres. En Mac, doble clic y «Instalar»; en Windows, clic derecho e «Instalar para todos los usuarios». Son archivos estáticos (un archivo por estilo) porque los programas de maquetación reconocen mejor esos estilos que los de una fuente variable. Las dos familias tienen licencia OFL, que permite usarlas y redistribuirlas.

### 2. Ajustes generales

En **Ajustes** (Mac: menú Affinity › Ajustes; Windows: Edición › Ajustes):

| Ajuste | Valor | Por qué |
| --- | --- | --- |
| Unidades del documento | Milímetros | InDesign trabaja en milímetros en Chile; la plantilla también. |
| Unidades de texto | Puntos | Tamaños e interlineados se expresan en puntos, como en InDesign. |
| Idioma del texto | Español | Activa la división en sílabas y la ortografía en español. |
| Perfil de color RGB | sRGB IEC61966-2.1 | El mismo que usa la plantilla y el más seguro para PDF en pantalla. |
| Perfil de color CMYK | Coated FOGRA39 | Perfil europeo por defecto de InDesign; confírmalo con la imprenta. |
| Guardado automático | Cada 5 minutos | InDesign recupera los documentos tras un cierre inesperado; Affinity también, si se activa. |

### 3. Espacio de trabajo

InDesign muestra a la derecha los paneles Páginas, Capas, Estilos de párrafo, Estilos de carácter, Muestras y Ajustar texto. En Affinity:

1. Abre la plantilla y entra en el modo de maquetación (en la app de Canva, el estudio **Layout**).
2. Desde el menú **Ventana**, deja visibles: **Páginas**, **Capas**, **Estilos de texto**, **Muestras**, **Carácter**, **Párrafo**, **Marco de texto**, **Transformar** y **Navegador**.
3. Arrastra Páginas y Capas a la columna izquierda, como el panel Páginas de InDesign, y el resto a la derecha.
4. Guarda la disposición con **Ventana › Estudio › Añadir preajuste** y llámala «InDesign». Si algo se mueve, **Ventana › Estudio › InDesign** la recupera.

### 4. Atajos de teclado de InDesign

Las herramientas básicas usan las mismas letras en los dos programas: **V** seleccionar, **A** nodos o selección directa, **T** texto, **P** pluma, **M** rectángulo, **H** mano y **Z** zoom. Los comandos de maquetación cambian. En **Ajustes › Atajos de teclado**, busca cada comando por su nombre y asígnale el atajo de InDesign. Si Affinity avisa que el atajo ya está en uso, acepta reemplazarlo: el comando anterior queda sin atajo, no se borra.

| Acción | Atajo de InDesign (Mac / Windows) | Comando que se busca en Affinity |
| --- | --- | --- |
| Colocar imagen o texto | ⌘D / Ctrl+D | Colocar (*Place*) |
| Duplicar | ⌥⇧⌘D / Alt+Mayús+Ctrl+D | Duplicar (*Duplicate*) |
| Agrupar y desagrupar | ⌘G y ⇧⌘G / Ctrl+G y Mayús+Ctrl+G | Agrupar, Desagrupar |
| Bloquear | ⌘L / Ctrl+L | Bloquear (*Lock*) |
| Traer al frente y enviar atrás | ⇧⌘] y ⇧⌘[ / Mayús+Ctrl+] y Mayús+Ctrl+[ | Traer al frente, Enviar al fondo |
| Mostrar u ocultar guías | ⌘; / Ctrl+; | Mostrar guías |
| Ajustar a guías | ⇧⌘; / Mayús+Ctrl+; | Ajuste (*Snapping*) |
| Mostrar retícula base | ⌥⌘' / Alt+Ctrl+' | Mostrar cuadrícula de línea base (*Show Baseline Grid*) |
| Mostrar caracteres ocultos | ⌥⌘I / Alt+Ctrl+I | Mostrar caracteres especiales (*Show Special Characters*) |
| Vista previa sin guías | W | Modo de vista previa |
| Página entera en la ventana | ⌘0 / Ctrl+0 | Ajustar a la ventana (*Zoom to Fit*) |
| Tamaño real | ⌘1 / Ctrl+1 | Tamaño real (100 %) |
| Número de página actual | ⌥⇧⌘N / Alt+Mayús+Ctrl+N | Insertar › Campos › Número de página |
| Encajar contenido proporcionalmente | ⌥⇧⌘E / Alt+Mayús+Ctrl+E | Escalar para llenar (*Scale to Fill*) |
| Exportar | ⌘E / Ctrl+E | Exportar |
| Estilos de párrafo | ⌘F11 / F11 | Panel Estilos de texto |
| Muestras | F5 | Panel Muestras |
| Páginas | ⌘F12 / F12 | Panel Páginas |

Cuando termines, usa el botón **Exportar** de esa misma ventana para guardar los atajos en un archivo y conservarlos si cambias de equipo. En InDesign, ⌘D, ⌘G y ⌘L tienen el mismo efecto en Windows con Ctrl; en Mac, algunos atajos con F11 y F12 los usa el sistema y hay que liberarlos en Ajustes del Sistema › Teclado.

### 5. Equivalencias de vocabulario

| InDesign | Affinity |
| --- | --- |
| Página maestra | Página maestra (en algunas versiones, «página principal») |
| Estilo de párrafo y de carácter | Estilos de texto (un solo panel con los dos tipos) |
| Hilo de texto | Flujo de texto: el triángulo del borde del marco |
| Texto desbordado | Triángulo rojo en el borde del marco |
| Retícula base | Cuadrícula de línea base |
| Encaje de contenido | Ajustes del marco de imagen |
| Libro | Varios documentos con numeración continua: Affinity no tiene libros; la memoria cabe en un archivo |

## Parte 2. La plantilla

### Abrir y guardar

1. Instala las fuentes (paso 1) y cierra y vuelve a abrir Affinity.
2. **Archivo › Abrir** y elige `plantilla-memoria-relevo-a3.idml`. Si Affinity avisa de fuentes que faltan, revisa que estén instaladas antes de seguir, porque si las reemplaza cambian los cortes de línea.
3. Guarda de inmediato en el formato de Affinity, con otro nombre. El IDML queda como respaldo.

### Formato y retícula

| Elemento | Valor |
| --- | --- |
| Formato | A3 horizontal, 420 × 297 mm, páginas sueltas |
| Sangrado | 3 mm por lado |
| Márgenes | Superior 20 mm, inferior 28,3 mm, izquierdo y derecho 20 mm |
| Columnas | 12, con medianil de 15 pt (5,3 mm); cada columna mide 26,8 mm |
| Línea base | 15 pt desde el margen superior; la caja tiene 47 líneas |
| Filas | 6 filas de 7 líneas, separadas por una línea |
| Texto de lectura | Dos marcos de 4 columnas (columnas 5–8 y 9–12), de unos 64 caracteres por línea |
| Columna libre | Columnas 1–4, para figuras, notas, citas destacadas o aire |

La retícula sigue el [documento 07](07_producto-y-editorial.md): doce columnas, líneas de 55 a 75 caracteres y una línea base común. Bringhurst (2012) considera cómodas para un texto continuo las líneas de 45 a 75 caracteres; con 10,5 pt en Schibsted Grotesk, cuatro columnas dan unos 64. El formato A3 horizontal es el que pidió el autor para trabajar la memoria como publicación ([dirección del autor](../00_gobernanza/direccion-del-autor-y-referencias-2026-09-27.md), C04), con la página como unidad de lectura en vez del pliego.

Dos ajustes pueden no llegar desde el IDML y conviene revisarlos al abrir:

- **Cuadrícula de línea base:** en **Vista › Administrador de cuadrícula de línea base**, inicio 20 mm desde el borde superior y espaciado 15 pt.
- **Filas:** en **Vista › Administrador de guías**, 6 filas con medianil de 5,3 mm dentro de los márgenes.

### Páginas maestras

| Maestra | Uso | Contenido |
| --- | --- | --- |
| A-Lectura | Páginas de texto | Cornisa arriba y folio abajo a la derecha |
| B-Apertura | Primera página de cada capítulo | Solo el folio |
| C-Tres columnas | Referencias y glosario | Cornisa y folio |
| D-Portada | Portada | Vacía; el fondo azul está en la página |

Cada apertura tiene el número del capítulo en azul en las columnas 1–4, el título en las columnas 5–12 y el texto desde la fila 3. Cada capítulo es un hilo propio de marcos: si un capítulo crece, solo se desplaza dentro de su hilo y no mueve a los demás.

### Estilos de párrafo

| Estilo | Letra | Uso |
| --- | --- | --- |
| Cuerpo | Schibsted Grotesk Regular 10,5/15, sangría de 15 pt | Párrafos que siguen a otro párrafo |
| Cuerpo sin sangría | Igual, sin sangría | Primer párrafo después de un título, una tabla o una lista |
| Título 2 | SemiBold 14/15, dos líneas antes | Subtítulos de cada capítulo |
| Título 3 | SemiBold 10,5/15 | Subtítulos menores |
| Capítulo número | Bold 150/150, azul | Número de la apertura |
| Capítulo título | Bold 42/45 | Título de la apertura; también alimenta el índice |
| Título preliminar | Bold 30/30 | Resumen, Abstract e Índice |
| Destacado | Medium 16/22,5 | Pregunta de investigación e hipótesis |
| Lista viñeta y Lista numerada | Regular 10,5/15, sangría francesa | Listas automáticas |
| Tabla número y Tabla título | SemiBold y cursiva 10,5/15 | Rótulo de tabla según APA 7 |
| Figura número, Figura título y Figura contenido | Igual; contenido en SemiBold 13 azul | Rótulo y contenido de figura |
| Tabla encabezado y Tabla texto | SemiBold y Regular 8,5/12 | Celdas |
| Nota | Regular 9/15 | Nota bajo tablas y figuras |
| Referencia | Regular 9,5/15, sangría francesa | Lista de referencias APA 7 |
| Glosario | Regular 9,5/15 | Entradas del glosario |
| Índice 1 e Índice 2 | SemiBold y Regular 10,5/15, tabulación con número a la derecha | Índice |
| Cornisa y Folio | IBM Plex Mono 7,5/15, grafito | Encabezado y número de página |
| Portada título, subtítulo, datos y etiqueta | Bold 230, Medium 24, Regular 10,5 y Mono 7,5, en papel | Portada |
| Nota de maqueta | IBM Plex Mono 8, azul | Instrucciones que se borran antes de exportar |

Los estilos de carácter son **Cursiva**, **Negrita** (SemiBold), **Negrita cursiva**, **Dato** (IBM Plex Mono), **Voz de la persona** (cursiva) y **Superíndice**. La tabla usa el estilo **Tabla Relevo**: filetes horizontales arriba, bajo el encabezado y al final, sin líneas verticales, como pide APA 7 (American Psychological Association, 2020).

La memoria usa una sola familia, Schibsted Grotesk, la misma de la app. Es la primera de las dos rutas del [documento 07](07_producto-y-editorial.md) («una sola familia sans serif con amplio repertorio y cifras claras»), coincide con D-102 (solo Schibsted Grotesk, IBM Plex Mono para datos) y respeta la decisión del autor de no usar serif en titulares. Si después elige otra letra, basta con cambiarla en los estilos.

### Colores

| Grupo | Muestras |
| --- | --- |
| Relevo | Tinta `#17181C`, Papel `#F2F2EF`, Azul Relevo `#1C3891`, Grafito `#5B5F68`, Línea `#D5D6D8`, Niebla `#E5E5E2`, Error `#B3261E` |
| Actividades | Sol, Naranja, Rosa, Menta, Celeste y Lila; Violeta, Petróleo, Bosque y Vino (D-104) |

Tinta, papel, grafito, línea y niebla son los de la app. El azul es el `#1C3891` propuesto en D-105; la app usa todavía `#2A4BD7` para la voz de la persona. Siguiendo el [documento 07](07_producto-y-editorial.md) y D-104, en la memoria el texto va en tinta sobre blanco y el azul se reserva para orientarse: número de capítulo, contenido de figuras y la portada.

### El texto que trae

La plantilla trae la [memoria vigente](../08_memoria/memoria-vigente-v4.md) tal como estaba el 9 de octubre: resumen, *abstract*, capítulos 1 a 14 y glosario, con títulos, listas, las cinco tablas, la figura 1, cursivas y negritas convertidas en estilos. El registro de cambios del Markdown no se incluye. La portada tiene «[completar]» en estudiante y profesores guía para no copiar nombres a otro archivo del repositorio, y conserva el pendiente de confirmar la denominación del título.

El número de páginas de cada capítulo se calculó con las anchuras reales de la letra y un margen de holgura. Affinity divide en sílabas y compone distinto, así que al abrirla puede quedar una página con poco texto al final de un capítulo (se borra en el panel Páginas) o un triángulo rojo de texto desbordado. Para resolver un desborde, agrega una página con la maestra A, dibuja o copia los dos marcos de lectura y conecta el último marco del capítulo con el nuevo haciendo clic en su triángulo.

El índice de la página 3 trae los números de página de cada apertura, que son exactos para esta plantilla. Si cambias la paginación, reemplázalo con la tabla de contenidos de Affinity (**Texto › Tabla de contenidos**) usando los estilos «Capítulo título» y «Tabla título»; el índice de tablas y figuras sale igual con «Tabla título» y «Figura título».

### Variantes

- [`plantilla-memoria-relevo-a3-tablas-como-texto.idml`](memoria-affinity/plantilla-memoria-relevo-a3-tablas-como-texto.idml): igual, pero con las tablas como párrafos separados por tabulaciones, por si Affinity no importa bien las tablas. Se rehacen con la herramienta Tabla.
- [`plantilla-memoria-relevo-a3-vacia.idml`](memoria-affinity/plantilla-memoria-relevo-a3-vacia.idml): portada, resumen, índice y una apertura, sin el texto, para empezar desde cero.
- Si la memoria cambia, [`generar_plantilla_idml.py`](memoria-affinity/generar_plantilla_idml.py) vuelve a crear la plantilla con el Markdown actualizado.

### Exportar

- **Para imprimir:** **Archivo › Exportar › PDF**, preajuste **PDF/X-4**, con sangrado de 3 mm y marcas de corte si la imprenta las pide. Confirma con la imprenta el perfil CMYK.
- **Para entregar en digital:** preajuste **PDF (digital, alta calidad)**, sin sangrado.
- Antes de exportar, borra las notas de maqueta y revisa en el panel **Comprobación previa** que no queden textos desbordados ni fuentes faltantes.

## Qué se comprobó y qué no

- **Comprobado:** el IDML está bien formado (todas sus partes se leen como XML), todos los estilos citados existen y los 120 marcos están bien enlazados en sus hilos. Se abrió en Scribus 1.6.1, que también importa IDML: reconoció las 40 páginas, los marcos, los 31 estilos de párrafo propios, los 6 de carácter, los 17 colores y las fuentes, y se exportó a PDF. Las [vistas](memoria-affinity/vistas/) son de esa importación.
- **No comprobado:** la plantilla **no se abrió en Affinity**, porque no está disponible en este entorno. Scribus no aplica la cuadrícula de línea base ni hace crecer las filas de las tablas, así que las vistas no son idénticas a lo que mostrará Affinity. Los menús y atajos de la Parte 1 se describen según la documentación y el uso habitual de Affinity Publisher; en la app de Canva pueden tener otro nombre. No se verificó si la UDP exige un formato de memoria distinto del A3 horizontal.
- **Pendiente del autor:** abrir la plantilla en Affinity e informar qué no llegó bien; aprobar o cambiar el formato, la letra y la retícula (D-121); poner el logotipo cuando elija la letra (D-108); completar la portada.

## Referencias

American Psychological Association. (2020). *Publication manual of the American Psychological Association* (7.ª ed.). https://doi.org/10.1037/0000165-000

Bringhurst, R. (2012). *The elements of typographic style* (versión 4.0). Hartley & Marks.

Serif. (s. f.). *Is it possible to import .INDD (Adobe InDesign) files into Affinity?* Affinity Help Center. Recuperado el 9 de octubre de 2026, de https://www.affinity.studio/help/import-indd/

---

## Registro de cambios (disclaimer)

### 2026-10-09 — Creación

- **Qué cambió:** se creó la guía para usar Affinity como InDesign y la plantilla IDML de la memoria en A3 horizontal, con retícula, estilos, maestras, colores y el texto de la memoria vigente.
- **Cómo estaba antes:** el [documento 07](07_producto-y-editorial.md) fijaba criterios editoriales y dejaba la diagramación pendiente; no había plantilla ni guía de programa.
- **Por qué:** el autor pidió configurar Affinity igual que InDesign y dejarlo listo para diseñar la memoria a nivel gráfico.
