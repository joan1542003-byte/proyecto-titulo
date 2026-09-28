# Sistema de marca 2.0 de Relevo, en Figma

**Estado:** propuesta registrada como [D-085](../09_decisiones/registro-de-decisiones.md), pendiente de aprobación del autor. Reúne la marca [«Vuelve a lo que querías hacer»](21_marca-relevo-a-tiempo-2026-09-25.md) (D-073) con los cambios que la app hizo en las versiones 2.9 (D-083) y 2.10 (D-084). No cambia la app. Mientras el autor no decida, siguen vigentes D-062 y la propuesta D-073, con las excepciones que D-083 y D-084 fijaron para la app.

**Archivo:** [Relevo · Sistema de marca 2.0](https://www.figma.com/design/AUHfsQ6LMMOw7VS07l5ZIz), en el equipo de Figma del autor. Se abre con la cuenta del autor; el enlace no da acceso por sí solo.

**Vistas en el repositorio:** [`marca-2.0/vistas/`](marca-2.0/vistas/), doce imágenes JPEG de 1000 px de ancho exportadas del archivo el 27 de septiembre de 2026. Conservan el estado de esa fecha aunque el archivo de Figma cambie.

## 1. Por qué existe

El 27 de septiembre el autor pidió usar Figma para desarrollar la marca «lo mejor posible, considerando todo», acorde al diseño nuevo de la app, con vidrio líquido, iconos, emoji y tratamiento de imagen. Había una razón práctica: las versiones 2.9 y 2.10 cambiaron en la app reglas del manual D-073 (vidrio, cápsulas, texto sobre fotos, notas en mayúsculas y emoji), y el manual quedó desalineado con lo que se ve en el teléfono.

## 2. Qué contiene

| Página | Contenido | Vista |
| --- | --- | --- |
| Portada | Firma, logotipo, renglón sobre una foto con vidrio oscuro, índice y tabla de cambios respecto de D-073. | [portada](marca-2.0/vistas/00-portada.jpg) · [contenido y cambios](marca-2.0/vistas/00-contenido-y-cambios.jpg) |
| 01 Fundamentos | Color en modo claro y oscuro, proporción y contraste; letra con los 14 estilos de la app; formas, espacio, alturas y movimiento. | [vista](marca-2.0/vistas/01-fundamentos.jpg) |
| 02 Vidrio líquido | El vidrio como capa de navegación sobre una pantalla, cinco niveles de desenfoque, vidrio claro y oscuro según la foto, vidrio líquido para piezas de marca y reglas. | [vista](marca-2.0/vistas/02-vidrio-liquido.jpg) |
| 03 Logotipo | Usos de color, área de respeto, escalas, ícono de la app con máscaras de Android, propuesta de «r» de vidrio y usos incorrectos. | [vista](marca-2.0/vistas/03-logotipo.jpg) |
| 04 Iconos | Los 97 iconos propios como componentes, en sus nueve grupos, con retícula, tamaños y reglas. | [vista](marca-2.0/vistas/04-iconos.jpg) |
| 05 Emoji | Los 84 emoji 3D del perfil en cinco grupos, tamaños del avatar, selección y reglas. | [vista](marca-2.0/vistas/05-emoji.jpg) |
| 06 Imagen | Criterios, receta de color, cuatro formas de mostrar una imagen, banda de vidrio con tono y biblioteca de 21 imágenes de la app, con su origen y su tono. | [vista](marca-2.0/vistas/06-imagen.jpg) |
| 07 Voz y texto | El renglón y las dos voces, cuatro reglas de escritura, vocabulario fijo, cambios de texto de 2.9 a 2.10 y tono. | [vista](marca-2.0/vistas/07-voz-y-texto.jpg) |
| 08 Componentes | Botones, botón de vidrio, etiqueta, control segmentado, barra de pestañas, filas, pasos, avisos, campo renglón, avatar, ficha, foto con banda y hoja; «Tu ruta» armada con ellos en claro, con hoja y en oscuro. | [vista](marca-2.0/vistas/08-componentes.jpg) |
| 09 Pantallas | Las 33 capturas de Android 2.10, agrupadas por recorrido. | [vista](marca-2.0/vistas/09-pantallas.jpg) |
| 10 Aplicaciones | Tres afiches 4:5, cuatro diapositivas 16:9 y la tarjeta del objeto. | [vista](marca-2.0/vistas/10-aplicaciones.jpg) |

## 3. Qué cambia respecto de D-073

| Tema | D-073 | Sistema 2.0 |
| --- | --- | --- |
| Formas | Esquinas rectas en impresos, 12 en botones y 20 en paneles. Nunca botones en píldora. | Cápsulas para todo lo que se toca; círculos para avatar y botones de icono; paneles de 28, fichas de 22 y hojas de 34. En papel impreso, esquinas rectas. |
| Vidrio | Sin desenfoques ni efecto de vidrio. | Vidrio con desenfoque sutil solo en la capa de navegación: botones (12), pestañas (16), bordes de desplazamiento (18), hojas (24) y banda sobre fotos (26). Sin brillo. |
| Fotos | El texto va fuera de la foto, sin velos. | El texto puede ir sobre una foto grande, en una banda de vidrio que toma el tono de la foto: tinta si la zona es clara, blanco si es oscura (luminancia bajo 0,19). |
| Notas | En mayúsculas con espaciado +6 %. | Nunca mayúsculas sostenidas: los rótulos son frases en seminegrita. |
| Emoji | Sin emoji. | 84 emoji 3D de Google, solo como imagen del perfil; nunca dentro de una frase ni en lugar de un icono. |
| Textos | Tú, presente, doce palabras o menos. | Igual, más el vocabulario fijo de 2.10: «Para empezar», «Dónde empiezas» y «paso» solo para la ruta. |
| Piezas de marca | Colores planos. | Además, vidrio líquido de Figma (con refracción) en afiches, presentaciones y el ícono, con la luz al mínimo. En la app se mantiene el vidrio de desenfoque con tinte. |

**Sin cambios:** la firma, el renglón con dos voces, el logotipo, Schibsted Grotesk, la paleta, los 97 iconos, la fotografía del comienzo, el tono de comunicación y la firma sonora. El sistema agrega tintes de vidrio como variables y una propuesta de ícono de vidrio que la app no usa.

## 4. Cómo está construido

- **Variables:**
  - *Color*, con modos Claro y Oscuro: 16 colores de `theme/Color.kt` y 6 transparencias de los componentes (pestaña elegida, hoja de vidrio y cuatro tintes de error).
  - *Forma y espacio*: 4 radios, 7 espacios y 4 alturas.
  - *Vidrio*: los 5 desenfoques.
  - Cada variable indica su nombre en el código de Android.
- **Estilos:** 14 de texto de la app (`Relevo/…`) y 6 para láminas (`Marca/…`); 5 de vidrio con desenfoque y 2 de vidrio líquido. El peso 650 del logotipo y los títulos se representa con Bold, el estilo más cercano disponible en Figma.
- **Componentes:** los 97 iconos (trazo enlazado a la tinta, para que cambien con el modo) y 18 componentes o conjuntos de variantes:
  - conjuntos: Botón (12 variantes, con propiedades de texto, icono y visibilidad del icono), Botón destructivo, Botón de vidrio, Etiqueta, Barra de pestañas, Fila, Paso de la ruta, Aviso, Marca de selección, Campo renglón, Avatar, Foto con banda, Logotipo e Ícono de la app;
  - componentes sueltos: Control segmentado, Estado en cápsula, Ficha de actividad y Hoja.
- **Imágenes:** se subieron desde el repositorio los 84 emoji, las 21 imágenes de la app, las 3 muestras de D-073 y las 33 capturas de 2.10. No se generaron imágenes nuevas.

## 5. De dónde sale cada valor

| Tema | Fuente |
| --- | --- |
| Color, letra, formas | `app/src/main/java/com/example/relevo/theme/` (`Color.kt`, `Type.kt`, `Theme.kt`) de Android 2.10 |
| Vidrio y tono | `ui/components/Glass.kt`, `Tone.kt` y `TabBar.kt` |
| Componentes | `ui/components/Controls.kt`, `Lists.kt`, `Photos.kt` y las capturas de 2.10 |
| Iconos y logotipo | `marca-a-tiempo/iconos/` y `marca-a-tiempo/logotipo/` |
| Contrastes, reglas de iconos, fotografía y tono | [Marca D-073](21_marca-relevo-a-tiempo-2026-09-25.md) |
| Receta de color | `marca-desde-cero/receta-imagen.py` |
| Origen y licencias | [licencias de la app](../06_desarrollo_y_factibilidad/app-android/licencias/README.md) y [créditos de las muestras](marca-a-tiempo/README.md) |

## 6. Cómo se revisó

- Cada página se revisó con capturas del archivo durante la construcción. Se corrigieron textos que se salían de sus paneles, conjuntos de variantes recortados, elementos ubicados antes de que su columna tomara el ancho final y dos errores de contenido: el origen de las imágenes y sus tamaños.
- Figma no conservó en las instancias la opacidad de una pintura enlazada a una variable. Por eso las transparencias de los componentes quedaron como variables con transparencia propia, igual que en el código.
- La tercera pantalla de «Tu ruta» cambia al modo Oscuro solo con la variable del marco; la foto clara conserva su banda clara, como en la captura 30 de la app.
- El tono de las 21 imágenes se calculó con la fórmula de `ToneMath` (sRGB a lineal y pesos de Rec. 709), en la franja del 60 al 100 % de un marco 0,9, que es el valor inicial de la app. Dos quedan oscuras: la guitarra (0,085) y las acuarelas (0,180). La app mide la zona real de cada composición, así que en pantalla el resultado puede variar.

## 7. Límites y pendientes

- **Decisión del autor:** aprobar o no esta versión como manual vigente (D-085). Si se aprueba, siguen pendientes de D-073 la frase de marca del capítulo 11 de la memoria, la guía de comunicación, el documento 14 y el resumen breve.
- **Vidrio líquido:** las vistas exportadas por Figma muestran casi planas las piezas con vidrio líquido; hay que revisarlas en el editor y, si se imprimen, en papel.
- **Ícono de vidrio:** es una exploración. No se comprobó que se reconozca entre otros íconos ni se aplicó a la app.
- **Imágenes:** 15 de las 21 imágenes de la app se generaron con IA y 6 son fotografías CC0. Son provisionales, no documentan hogares reales y así se señala en cada página que las usa. La identidad final necesita una sesión fotográfica propia, con consentimiento.
- **Personas:** falta comprobar con personas que no conocen el proyecto que la frase y el renglón se entienden solos, y que el vidrio se lee bien en el teléfono de la prueba.
- **Manual HTML y kit de D-073:** no se modificaron. Quedan como antecedente; si D-085 se aprueba, el archivo de Figma los reemplaza.

## Registro de cambios (disclaimer)

### 2026-09-27 — Creación

- **Qué se añadió:** el sistema de marca 2.0 en Figma, con once páginas, variables, estilos, componentes e imágenes, y doce vistas exportadas en `marca-2.0/vistas/`.
- **Cómo estaba antes:** la marca se describía en el manual HTML y el kit de D-073, que no incluían el vidrio, las cápsulas, el texto sobre fotos ni los emoji de las versiones 2.9 y 2.10 de la app.
- **Por qué:** el autor pidió desarrollar la marca en Figma, acorde al diseño nuevo de la app, con vidrio líquido, iconos, emoji y tratamiento de imagen.
