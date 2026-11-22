# Íconos desde Lucide

**Fecha:** 22 de noviembre de 2026. **Decisión:** [D-187](../09_decisiones/registro-de-decisiones.md). **Rama:** `iconos-lucide`. **App:** [4.8](../06_desarrollo_y_factibilidad/app-android/version-4.8-iconos-de-lucide-2026-11-22.md). **Carpeta:** [iconos-lucide](iconos-lucide/README.md), con el mapeo, los SVG, el generador y la licencia. **Imágenes:** [antes y después](iconos-lucide/antes-y-despues.png), [los 118 íconos](iconos-lucide/set-completo.png) y [los propios junto a Lucide](iconos-lucide/propios-junto-a-lucide.png).

## Qué se pidió

El autor propuso usar los íconos de Lucide, que son de código abierto, adaptar los que lo requieran y crear nuevos siguiendo cómo funcionan los de Lucide: «si nuestro usuario hace algo, pero Lucide no tiene un ícono de ese algo, habría que crearlo».

## Qué cambió

Hasta la 4.7.2, Relevo dibujaba sus 118 íconos a mano, con las reglas de construcción de Lucide como referencia ([documento 43](43_por-que-iconos-propios-2026-11-06.md)). Desde la 4.8, cada ícono sale de Lucide 1.70.0:

| Origen | Cuántos | Cuáles |
| --- | --- | --- |
| **Lucide tal cual** | 109 | Todos los demás: la interfaz, la prueba y 31 de las 34 actividades. |
| **Adaptado de Lucide** | 5 | Suena, Silenciar, Sistema phygital, Actividades y Leer manga. |
| **Propio, con las reglas de Lucide** | 4 | El Tag (Objeto), Estirar, Meditar y Cómo empieza. |

![Los 118 íconos de Relevo desde Lucide](iconos-lucide/set-completo.png)

Ninguna pantalla cambia de texto ni de orden. Siguen el trazo según el tamaño, de 2,0 a 16 px a 1,3 a 48 px (D-124); el centro óptico (D-156), y la palabra que acompaña a cada ícono.

## Cómo se eligió cada ícono

1. **Lucide primero.** Se buscó en Lucide el ícono que dice lo mismo, por nombre y por sus etiquetas.
2. **Con las reglas de D-162:** un significado por dibujo; cada actividad con el objeto con que empieza, como lo sugiere la app; legible a 17 px, y neutro donde la app no juzga.
3. **Si Lucide tenía varios,** se compararon a los tamaños de la app. Si tenía una pieza, se adaptó. Si no tenía el objeto, se dibujó.

Los casos con más de una opción:

| Ícono | Lucide | Por qué |
| --- | --- | --- |
| La dejé para después | `rotate-cw-clock` | Es el mismo dibujo de antes: un reloj con la flecha hacia adelante. |
| Dibujar y Editar | `pencil-line` y `pencil` | El lápiz con el trazo que deja es Dibujar; el lápiz solo, Editar (D-162). |
| Escribir | `notebook-pen` | «Dejar un lápiz sobre el cuaderno», como sugiere la app. |
| Estudiar | `notebook-text` | «Abrir los apuntes», como sugiere la app. |
| Pintar | `palette` | «Preparar las acuarelas». El pincel se parecía al lápiz de Dibujar. |
| Dormir | `bed` | La cama, el objeto de la actividad. La luna llevaba un destello, y D-162 evitó los destellos, que se leen como inteligencia artificial. |
| Ordenar | `shirt` | Lucide no tiene un colgador. La polera dice «Juntar la ropa en el canasto», la primera sugerencia de la app. |
| Tejer o coser | `spool` | Lucide no tiene un ovillo. El carrete dice «Enhebrar la aguja». |
| Pelota | `volleyball` | Una pelota genérica: el concepto reúne fútbol, básquetbol, vóleibol, tenis y otros. |
| Nadar | `waves-ladder` | La escalera de la piscina. |
| Correr | `sport-shoe` | «Ponerte las zapatillas». |
| Salir | `door-open` | Salir de la casa. La huella de mascota de antes decía otra cosa (D-162). |
| Actividad, Sin respuesta y Tema | `shapes`, `circle-dashed` y `contrast` | Lucide tiene los mismos signos que eligió D-162: las formas de base, el círculo punteado y el contraste. |

El mapeo completo, con el origen y la nota de cada ícono, está en [`mapeo.json`](iconos-lucide/mapeo.json).

## Los nueve que no son de Lucide tal cual

| Ícono | Origen | Qué dibuja | Por qué |
| --- | --- | --- | --- |
| **Objeto** | Propio | El Tag visto desde arriba: el cuerpo, el botón y el agujero de la argolla. | Lucide no tiene un llavero localizador. El objeto físico y la pantalla se nombran igual: es lo *phygital* del proyecto. |
| **Suena** | Adaptado de `volume-2` | El Tag con los dos anillos del sonido. | Los anillos son los de Lucide; el Tag reemplaza al parlante, porque suena el objeto. |
| **Silenciar** | Adaptado de `volume-x` | El Tag con la cruz. | Callar el Tag, como explica la guía del Tag. |
| **Sistema phygital** | Adaptado de `smartphone` | El teléfono, más angosto, junto al Tag. | Sin uso en pantalla; se conserva. |
| **Actividades** | Adaptado de `layout-grid` | Cuatro círculos en vez de cuatro cuadrados. | Son los círculos del logo (D-155); Apps elegidas conserva los cuadrados. |
| **Leer manga** | Adaptado de `book` | El libro con un globo de diálogo en la tapa. | «Sacar el tomo del estante» (D-162). |
| **Estirar** | Propio | La colchoneta a medio desenrollar. | «Desenrollar la colchoneta» (D-162). Lucide no tiene colchoneta. |
| **Meditar** | Propio | La flor de loto sobre una base. | Lucide no tiene un ícono de meditar. |
| **Cómo empieza** | Propio | La escalera con un punto en el primer escalón. | Sin uso en pantalla; se conserva. |

![Los nueve, junto a su referente de Lucide, a 48, 24 y 17 px y dentro de un anillo](iconos-lucide/propios-junto-a-lucide.png)

**Cómo se dibujaron.** Con la [especificación de Lucide](https://lucide.dev/contribute/icons/specification): lienzo de 24 con 1 de margen, trazo de 2 en el diseño, puntas y uniones redondas, esquinas de 2 en las formas de 8 o más y de 1 en las menores, y 2 de aire entre trazos. Los puntos son trazos de largo casi nulo («h.01»), como los de Lucide. En Suena y Silenciar, el Tag es más chico que en Objeto. Así quedan 2 de aire entre el Tag y los anillos, y por eso lleva un punto en vez del botón.

## Antes y después

![Antes y después de cada ícono, a 32 px y dentro de un anillo de 40 px](iconos-lucide/antes-y-despues.png)

## Verificación

- **Los dibujos:** cada trazado generado se dibujó junto a su SVG de origen, a 96 px, y los 118 coincidieron píxel a píxel.
- **En Android:** las 110 pruebas unitarias pasan. Cuatro son nuevas y comprueban que el lector de trazados de Android lee cada paso de cada trazado, que las banderas de los arcos van separadas y que ningún ícono repite el dibujo de otro.
- **Un detalle técnico:** seis SVG de Lucide escriben pegadas las banderas de sus arcos («A5 5 0 0012 5»), como permite el estándar. El generador las separa, porque Android podría leer «0012» como un solo número.
- **APK 4.8:** firmado con la clave de siempre y con el aviso de licencia de Lucide adentro.
- **No se vio en un teléfono** ni en un emulador.

## Por revisar con el autor

1. **En el teléfono:** los íconos a 17 px dentro de los anillos, en tema claro y oscuro y con letra grande.
2. **Cinco elecciones:** Ordenar (la polera), Tejer (el carrete), Pelota (la de vóleibol), Dormir (la cama), y Escribir y Estudiar, que son dos cuadernos.
3. **El trazo:** la app dibuja los íconos de Lucide con su trazo según el tamaño (1,6 a 24 px), no con el de 2 de Lucide. Probar la línea de 2 sigue pendiente desde el documento 43.

## Lo que arrastra el cambio

Nada de esto se cambió todavía, porque depende de que el autor apruebe los íconos:

- **Memoria v8, «Iconografía»:** dice que los íconos «son propios: 118 dibujos de línea». Texto propuesto más abajo.
- **Memoria v8, lámina de identidad:** dice «Íconos propios: retícula de 24, trazo de 1,6». Propuesta: «Íconos de Lucide y propios con sus reglas: retícula de 24, trazo de 1,6».
- **Anexo H, H.3:**
  - el texto;
  - la Tabla H2: retícula, esquinas, color y relleno, y el número de íconos que corre el centro óptico;
  - la Figura H6, el conjunto;
  - la Figura H7, la construcción con Suena y Leer;
  - la Figura H8, Lucide y Relevo.
- **Figuras de la memoria:** toman los íconos de [`marca-e-iconos.json`](../08_memoria/memoria-1920x1080/marca-e-iconos.json), los de la app 4.7.2. Hay que pasarlos a los de la 4.8 y volver a componer. Ese archivo tiene además seis íconos que no son de la app: `tag`, `decidir`, `empece`, `contando`, `pasear-perro` y `aura`.
- **Capturas de la app:** las de la 4.7.2 y las figuras que las usan muestran los íconos anteriores.
- **Documentos 43 y 44:** quedan como el fundamento de la etapa anterior. Sus reglas para elegir siguen vigentes.
- **El kit de marca** en [`marca-a-tiempo/iconos`](marca-a-tiempo/iconos) queda como antecedente. La fuente de los íconos es ahora [`iconos-lucide`](iconos-lucide/README.md).

### Texto propuesto para la memoria

> **Iconografía.** Los íconos de la aplicación salen de Lucide, un conjunto de íconos de línea de código abierto cuya licencia permite usarlos, modificarlos y redistribuirlos siempre que se conserve su aviso (Lucide Contributors, s. f.-b). De los 118, 109 son de Lucide tal cual. Cinco se adaptaron, como Suena, que lleva el Tag en lugar del parlante, y cuatro se dibujaron con sus reglas de construcción (Lucide Contributors, s. f.-a) porque Lucide no los tiene: el Tag, la colchoneta, la flor de loto y la escalera del primer paso. Así, el dibujo propio queda para lo que es de Relevo, y todos los íconos hablan con una sola voz. Entre las opciones de Lucide, cada actividad se dibuja con el objeto con que empieza, como un libro abierto para leer. El trazo, de 1,6 en el tamaño base, se afina en los tamaños grandes y se engruesa en los pequeños, para que el ícono pese parecido a la palabra que siempre lo acompaña. Su construcción está en el Anexo H.

Usa las dos referencias de Lucide que la memoria ya tiene, así que no suma citas.

### Texto propuesto para el Anexo H, H.3

> Los íconos de Relevo salen de Lucide, un conjunto abierto de íconos de línea: 118 dibujos en una retícula de 24, de un solo color y siempre acompañados de su palabra. De ellos, 109 son de Lucide tal cual, cinco se adaptaron y cuatro se dibujaron con sus reglas de construcción, porque lo que la app tiene que mostrar —el Tag y algunas actividades que nombraron las personas entrevistadas— no está en Lucide (Figura H6).

En la Tabla H2 cambian tres filas. La retícula y el margen pasan a ser los de Lucide: lienzo de 24, con el trazo a 1 o más del borde. Las esquinas, 2 en las formas de 8 o más y 1 en las menores. En color y relleno, contorno y un solo color; solo se rellenan los puntos de la paleta, como en Lucide, y la estrella llena. Las filas del trazo, los tamaños ópticos y el equilibrio no cambian. Hay que recontar cuántos íconos corre el centro óptico.

## Referencias

Lucide Contributors. (s. f.-a). *Lucide design language*. Lucide. Recuperado el 10 de noviembre de 2026, de https://lucide.dev/contribute/icons/design-principles

Lucide Contributors. (s. f.-b). *Lucide license*. Lucide. Recuperado el 10 de noviembre de 2026, de https://lucide.dev/license

Lucide Contributors. (2026). *lucide-static* (Versión 1.70.0) [Software]. npm. https://www.npmjs.com/package/lucide-static/v/1.70.0

## Registro de cambios (disclaimer)

### 2026-11-22 — Creación

- **Qué cambió:** se documenta el paso de los íconos a Lucide: cómo se eligió cada uno, los nueve que no son de Lucide tal cual, la verificación, lo que falta revisar y lo que arrastra el cambio, con textos propuestos para la memoria y el Anexo H.
- **Cómo estaba antes:** los íconos eran dibujos propios con las reglas de Lucide ([documentos 43](43_por-que-iconos-propios-2026-11-06.md) y [44](44_iconos-desde-lo-que-pide-la-app-2026-11-06.md)).
- **Por qué:** el autor propuso usar los íconos de Lucide y dibujar solo lo que Lucide no tiene (D-187).
