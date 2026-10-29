# Memoria en 1920 × 1080

**Decisiones:** D-146, D-147 y D-148. Reemplaza a la [versión A3](../memoria-a3/README.md), que queda como registro.

**Para leer:** [memoria-relevo-1920x1080.pdf](memoria-relevo-1920x1080.pdf), de 69 páginas de 1920 × 1080 puntos (los píxeles de una pantalla, a 72 ppp). La [versión HTML](memoria-relevo-1920x1080.html) es la misma composición.

**Para editar en Affinity:** `memoria-relevo-1920x1080.idml`, que se abre en Affinity Publisher o InDesign. No se guarda en el repositorio, porque sus imágenes se enlazan con la ruta completa del computador donde se generó: se genera en la carpeta donde se va a trabajar. Antes, instala las tipografías de [`letra/estaticas/`](letra/estaticas/) (ver [letra](letra/LEEME.md)).

**Texto:** el [borrador v6](../borrador-memoria-v6-2026-10-28.md), sin cambios al componer. Sus marcadores «Confirmar» siguen a la vista.

## Pedido

El 28 de octubre de 2026, tras la revisión con los profesores, el autor pidió reescribir la memoria con más figuras para explicar lo difícil de forma simple, con imágenes y esquemas citados, con todo lo que es diseño y con la letra del texto continuo más grande, y seguir trabajando en Affinity, con las tipografías en el repositorio. Los apuntes de la revisión, en la tarea 10 de [Por hacer](../../00_gobernanza/por-hacer.md), piden además el formato de 1920 × 1080, un poco más de interlineado y que ninguna página quede con un solo párrafo ni con una columna sola y poco texto.

## Diseño

| Elemento | Cómo va |
| --- | --- |
| Hoja | 1920 × 1080 puntos (677,3 × 381 mm), papel `#F7F4F0` hasta el borde. Tres columnas. |
| Escala | El generador compone a escala 7:11, en una hoja de 431 × 242 mm, y amplía el PDF y el IDML por 22/14. Así conserva las piezas, las proporciones y la escala tipográfica de la versión A3. |
| Texto | Instrument Sans de 23 pt, con interlineado de 34,6 pt (1,5 veces la letra) y media línea entre párrafos. En el PDF, 8,1 palabras por línea en promedio. 26 líneas por columna. |
| Escala completa | 14, 17, 19, 22, 28 y 44 pt en el cuerpo, las tablas y las figuras (la escala de la A3, por 22/14). |
| Aperturas | Número de 94 pt en peso regular —el más liviano de Instrument Sans, que no tiene versión light— y título de 63 pt: manda el título. |
| Rótulos | Como en una tesis: «Figura 1» o «Tabla 1» en negrita y el título en cursiva, debajo; nada en cápsulas. Cabeceras de tabla, encabezados y fechas de 17 pt. |
| Tablas | Con filetes: uno grueso arriba y abajo, uno bajo la cabecera y uno fino entre filas. Sin fichas blancas ni círculos. |
| Números y fondos | Números sueltos, sin círculos. El fondo blanco queda para lo que importa: las cifras de resultados, la identidad y las capturas. |
| Secciones | Cada una abre en una página nueva, con su panel de aura en la primera columna. |
| Final de cada sección | Su última página reparte el texto en columnas del mismo alto; una columna sola se abre en dos o en tres. Si la sección termina en un párrafo corto y tiene tablas o figuras, la última baja a esa página. |
| Tablas y figuras | Arriba de la página, después de su lugar en el texto, en el orden en que aparecen. Una tabla más alta que la página se parte en dos y repite su cabecera. La nota va en una columna, o en dos si es larga. |
| Figuras de una columna | Los esquemas breves y el gráfico de la encuesta van dentro del texto, siempre arriba de una columna: texto, figura, texto. |
| Imágenes | Las imágenes enteras de una figura quedan del mismo alto, en columnas proporcionales; los flujos llevan flechas; las figuras anchas usan todo el ancho. Las personas llevan el ícono de perfil. |
| Índice | Solo las secciones, por ahora (D-145). |
| Portada | Institución, logo, título y datos; lo que falta confirmar, en gris. |

## Figuras nuevas

El generador dibuja once tipos de figura, que leen su contenido de la propia v6 (grupos separados por «; » y campos por « | »), y compone fotos y capturas sin recortarlas:

- **Esquema en columnas:** los ocho criterios (Figura 8) y la arquitectura de información de la aplicación (Figura 15); en una columna, las ideas de McDaniel y Einstein (Figura 1), Norman (Figura 2) y Sanders y Stappers (Figura 4).
- **Mapa de dos ejes:** sobre qué actúan las herramientas y dónde ocurren (Figura 7).
- **Centro y periferia:** dos círculos y la señal que pasa al centro (Figura 3).
- **Matriz de dos por dos:** motivación y facilidad para empezar (Figura 22).
- **Cronología:** el proceso del proyecto, de marzo a octubre (Figura 9).
- **Lámina de identidad:** logo, luces con su papel, letra e íconos (Figura 16).
- **Prueba aplicada:** las cuatro etapas de la prueba en los hogares (Figura 19).
- **Resultados por persona:** un punto por respuesta, lleno si declaró haber empezado (Figura 21).
- **Capturas y modelos:** las pantallas de la versión 3.3 (Figura 13) y el testigo en 3D (Figura 18), enteros y con su pie numerado.
- **Gráfico de barras:** opiniones de la encuesta (Figura 6), con barras horizontales y el número al lado.
- **Flujo con flechas:** el recorrido de la aplicación en *wireframes* (Figura 11) y la preparación en capturas (Figura 12).
- **Lámina de pantallas:** la primera vez, en *wireframes* (Figura 14); las 39 pantallas están en el Anexo F.

## Cómo se genera

```bash
node construir-idml.js
```

Necesita Node y Google Chrome, y tarda unos cuatro minutos. Escribe el IDML, el HTML y el PDF con el mismo reparto, y los fondos de cada pieza en `figuras/idml/`. Con `DIAG=1` imprime dónde quedó cada pieza y cada marco de texto.

## Verificación

- **Tercera ronda, el 28 de octubre de 2026:** 69 páginas, sin avisos del generador; ninguna sección termina en una columna sola. Se revisó la vista de todas. Texto: 8,1 palabras por línea en promedio; 8 de 1843 líneas pasan de 12, por cifras.
- **Segunda ronda, el 28 de octubre de 2026:** 75 páginas, sin avisos del generador. Se revisó la vista de todas. Texto: 8,4 palabras por línea en promedio; 17 de 1824 líneas pasan de 12, por cifras.
- **El 28 de octubre de 2026:** 66 páginas, sin avisos del generador. Se revisó la vista de todas y, de cerca, las páginas de las figuras nuevas.
- **Palabras por línea** (`pdftotext`): texto, 8,4 en promedio; 17 de 1872 líneas pasan de 12, por cifras. Notas, celdas, referencias y glosario: 12 o menos en el 95 % de las líneas.
- **Final de las secciones:** ninguna termina en una columna sola; las que terminan en una tabla la dejan a página completa.
- **No comprobado:** el IDML no se abrió en Affinity en esta ronda.

## Límites

- Algunas tablas y láminas altas quedan en páginas propias, con aire debajo, porque no dejan espacio útil para texto.
- Las capturas de la aplicación son de la línea 3.x; la prueba usó la interfaz de la 2.30.
- La Biblioteca exige los índices de tablas y de figuras para el depósito.

## Registro de cambios (disclaimer)

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
