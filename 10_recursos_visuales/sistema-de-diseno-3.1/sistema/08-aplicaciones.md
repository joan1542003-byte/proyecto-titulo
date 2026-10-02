# Aplicaciones

El mismo sistema en la app, el objeto, la presentación, la memoria y las piezas de comunicación. En la corrección cruzada se recordó la presentación y no se reconoció en la app; por eso cada pieza repite los mismos recursos: el logotipo con su renglón, el azul, la trama y, cuando hay una actividad, su color.

## App

| Pantalla | Cómo se aplica |
| --- | --- |
| Inicio | Logotipo en la barra; saludo en serif (`displayTitle`); la tarjeta del relevo activo con la foto en trama del color de su categoría, `StatusChip`, la firma en `displayCard` y el tiempo en `TimeDots`; pestañas con la elegida llena y sobre el renglón. |
| Preparar | Título en pregunta y en serif; la actividad en `RenglonField`, en itálica sobre el renglón de su categoría; ideas en `QuickChoice` con `ActivityTag`; `GuardedButton` dice qué falta; el avance en `StepProgress` azul. |
| La señal | Trama que late a pantalla completa; tarjeta de vidrio con el logotipo, «Suena en el parlante» y la firma en `displaySignal`; «Silenciar y continuar» en tinta. |
| Después de la señal | «¿Qué decidiste?» con tres respuestas iguales en botones secundarios. Sin trama. |
| Ruta, Perfil y ajustes | Listas en `ListSection`; sin trama ni serif salvo el título; los valores escritos por la persona en `personaBody`. |

La app 2.19 llevaría, en este orden: color y tokens; logotipo, ícono de la app y pestañas; campo renglón y firma en itálica; tiempo en puntos y pantalla de la señal; colores de categoría en las ideas; titulares en serif; el resto de los íconos.

## Afiches

Serie «Vuelve a…», una por categoría (`afiche-<categoría>.png`, 1080 × 1528, proporción A):

- Fondo: el 50 de la familia. Arriba, la etiqueta de la categoría y el número en la serie.
- Al centro, la ilustración de la categoría.
- «Vuelve a» en `displayPoster` romana y, debajo, la actividad en itálica sobre un renglón del 600 de la familia que llega al borde derecho: deja lugar.
- La explicación corta de la guía de la app en Schibsted Grotesk y, abajo, el logotipo y la ficha de la actividad en mono: actividad · cómo empieza · dónde, tomadas de las ideas de la app (documento 23).

Para una pieza nueva: una categoría por afiche, una actividad de las ideas y nunca texto sobre la ilustración.

## Redes

- Carrusel «¿Te ha pasado?» (`redes-carrusel-1` a `-4`, 1080 × 1350): la escena, la app, el parlante y tú, con los textos de la pantalla «Cómo funciona» de la app. Un renglón en todo el carrusel, bajo «Decides».
- Historia «Vuelve a ___» (`redes-historia-escribe`): un renglón vacío para escribir con el texto de la historia.
- Historia azul (`redes-historia-trama`): el campo de trama, una tarjeta de vidrio con el logotipo y el descriptor, y el pie de la guía de comunicación sobre lo que aún no se valida.
- Publicación «¿Qué quieres hacer?» (`redes-categorias`, 1080 × 1080): las seis categorías con su ícono y su color.

## Presentación

Seis láminas de 1920 × 1080 (`presentacion-1-portada` a `-6-cierre`):

- Fondo blanco, rótulo de sección arriba a la izquierda y número arriba a la derecha, como en las láminas del autor.
- Schibsted Grotesk en todo (las láminas dejan Inter) y titulares en Newsreader (`displaySlide`).
- Una idea subrayada por lámina, con el renglón azul.
- Portada con el logotipo, el campo de trama azul y el ícono de la app.
- Datos solo con lo que existe y sus límites: 8 entrevistas, 53 respuestas y una prueba de 21 días diseñada, que aún no se realiza. Los tres ámbitos con sus títulos exactos (D-094).

## Memoria

Portada A4 (`memoria-portada.png`): el logotipo grande, el título académico exacto en Newsreader, los renglones de colores y la institución. El nombre del estudiante y de los profesores se agregan al imprimir. En el interior: Schibsted Grotesk para el texto, Newsreader para los títulos de capítulo y las ilustraciones para abrir capítulos.

## Objeto

El parlante lleva una banda en `azul-500` en la base: el renglón puesto en la casa, bajo el lugar donde empieza la actividad. Su rejilla es la trama. El cuerpo va en `papel` o `tinta`, sin texto ni colores de categoría, porque la señal debe ser genérica (documento 05). Las medidas, 42 a 48 mm de diámetro y 12 a 16 mm de alto, son metas de diseño de D-045. La prueba usa un parlante Bluetooth comercial (D-063); `objeto-renglon-y-trama.png` muestra cómo llevaría la marca un objeto propio.

## Impresos

- Tarjeta de bolsillo de 85 × 55 mm (`tarjeta-frente`, `tarjeta-reverso`): al frente «Vuelve a ___.» para completar a mano; atrás, la explicación principal de la guía de comunicación sobre `azul-500`.
- Pliego de stickers (`stickers.png`): íconos de la app, el logotipo, las seis categorías, «Vuelve a ___.» y el tiempo en puntos, para marcar los lugares donde empieza una actividad.

## Panel del investigador

Mismos tokens que la app. Cifras en `mono`; gráficos en `blue` y `graphite`; las categorías, si aparecen, con su `<cat>-line` y su nombre. Sin trama.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** renumerada desde 06-aplicaciones.md; suma afiches, redes, presentación, memoria, objeto, tarjeta y stickers.
- **Cómo estaba antes:** describía la app, el objeto, la presentación y tres formatos de afiche sin piezas hechas.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
