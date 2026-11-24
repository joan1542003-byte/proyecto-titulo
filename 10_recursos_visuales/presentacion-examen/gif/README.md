# GIF de la presentación del examen

Estos son los nueve GIF que usa la [presentación del examen](../../47_presentacion-examen-2026-11-23.md), tal como están en Figma Slides. Su huella SHA-1 coincide con la de la imagen de cada lámina, así que son los mismos archivos. En Figma, cada GIF va sobre un cuadro fijo, que se ve cuando la imagen no se mueve: en la vista de todas las láminas, en las capturas y al exportar a PDF. Todos se repiten sin fin.

| Lámina | Archivo | Qué muestra | Tamaño | Cuadros y duración |
| --- | --- | --- | --- | --- |
| 1 · Portada | [`lamina-01-portada-logo.gif`](lamina-01-portada-logo.gif) | El logo «pasa el turno», sobre el aura de la portada de la memoria | 1056 × 312 | 150 cuadros, 6 s |
| 28 · Relevo | [`lamina-28-como-funciona.gif`](lamina-28-como-funciona.gif) | «Cómo funciona», en su versión simple | 1280 × 720 | 330 cuadros, 13,2 s |
| 29 · Cómo se usa | [`lamina-29-1-preparar.gif`](lamina-29-1-preparar.gif) | Preparar: el primer paso | 480 × 480 | 115 cuadros, 4,6 s |
| 29 · Cómo se usa | [`lamina-29-2-seguir-en-el-telefono.gif`](lamina-29-2-seguir-en-el-telefono.gif) | Seguir en el teléfono: el tiempo | 480 × 480 | 120 cuadros, 4,8 s |
| 29 · Cómo se usa | [`lamina-29-3-oir-la-senal.gif`](lamina-29-3-oir-la-senal.gif) | Oír la señal desde el lugar | 480 × 480 | 60 cuadros, 2,4 s |
| 29 · Cómo se usa | [`lamina-29-4-decidir.gif`](lamina-29-4-decidir.gif) | Decidir | 480 × 480 | 110 cuadros, 4,4 s |
| 30 · La aplicación | [`lamina-30-preparar-un-relevo-en-la-app.gif`](lamina-30-preparar-un-relevo-en-la-app.gif) | Cómo se prepara un relevo en la app 4.8.2 | 400 × 889 | 453 cuadros, 39,2 s |
| 31 · Identidad | [`lamina-31-identidad-logo.gif`](lamina-31-identidad-logo.gif) | El logo «pasa el turno», sobre blanco | 960 × 284 | 150 cuadros, 6 s |
| 41 · Cierre | [`lamina-41-cierre-logo.gif`](lamina-41-cierre-logo.gif) | El logo «pasa el turno», sobre el aura de la contraportada de la memoria | 1160 × 343 | 150 cuadros, 6 s |

## De dónde salen

- **El logo y las animaciones de Relevo** se hicieron con [`gif-sobre-fondo.sh`](../gif-sobre-fondo.sh). El script parte de las animaciones WebM con transparencia del [logo](../../logo-relevo-variantes-2026-11-23/README.md#animaciones-del-logo) y de [«sin palabras»](../../animaciones-de-relevo-2026-11-23/README.md), y las pone sobre el fondo exacto de su lámina. Sus comentarios dicen con qué tamaño y fondo se hizo cada uno.
- **El GIF de la lámina 30** es la grabación «Crear un relevo» de la app 4.8.2, con el mismo tamaño, los mismos cuadros y la misma duración que la de las [capturas de la 4.8.2](../../../06_desarrollo_y_factibilidad/app-android/capturas/interfaz-4.8.2/README.md).

## Antes del examen

En Figma los GIF se mueven en el modo presentación. Conviene abrir la presentación en el computador del examen y pasar por las láminas 1, 28 a 31 y 41 para ver que se muevan. Si no se mueven, se ve el cuadro fijo de cada una, y estos archivos se pueden abrir aparte.

## Registro de cambios (disclaimer)

### 2026-11-24 — Creación

- **Qué cambió:** se guardaron en el repositorio los nueve GIF de la presentación, con el número de su lámina en el nombre, y esta tabla.
- **Cómo estaba antes:** los GIF estaban solo en Figma y en la carpeta temporal de la sesión.
- **Por qué:** el autor preguntó si los GIF funcionan y pidió tenerlos aparte, con su enlace de descarga y su lámina.
