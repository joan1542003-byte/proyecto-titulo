# Presentación oficial del examen

La presentación del examen de título, en dos formatos:

- **[`index.html`](index.html):** la versión animada, para proyectar. Tiene 27 láminas y 9 de respaldo, con las grabaciones de la app 4.8.2 a 1,2 veces su velocidad.
- **[`presentacion-relevo-examen.pdf`](presentacion-relevo-examen.pdf):** el respaldo oficial. Tiene 42 páginas, una por lámina y por estado, y pesa menos de 15 MB.

La estructura, el guion completo y lo que se hizo con el feedback del Pase están en el [documento 53](../53_presentacion-oficial-examen-2026-12.md).

## Cómo presentar

1. Abrir `index.html` con doble clic en Chrome. Funciona sin internet: las letras, las imágenes y las grabaciones están en esta carpeta.
2. Pulsar **F** para la pantalla completa.
3. Pulsar **P** para abrir la vista del presentador en otra ventana. Muestra la lámina actual, la siguiente, el guion de cada lámina y un cronómetro que parte al primer avance. A los 14 minutos el cronómetro se pone rosado.
4. Avanzar con **→**, la barra espaciadora o un clic. Volver con **←**. Se puede avanzar desde cualquiera de las dos ventanas.

En el guion, **[avanzo]** marca cuándo pulsar para que aparezca lo siguiente en la misma lámina.

| Tecla | Qué hace |
| --- | --- |
| → o espacio | Avanza un paso |
| ← | Vuelve un paso |
| F | Pantalla completa |
| P | Vista del presentador |
| G | Todas las láminas en una grilla; un clic abre una |
| R | Salta al respaldo |
| B | Pantalla negra; se vuelve con B |
| H | Muestra la ayuda de teclas |
| Inicio y Fin | Primera y última lámina |

Para abrir una lámina directo se escribe su número al final de la dirección, por ejemplo `index.html#14` o `index.html#14.2` para el tercer estado de la lámina 14.

## Las grabaciones de la app

“Cómo funciona Relevo” (lámina 14) muestra la app 4.8.2 funcionando, en tres grabaciones de las [capturas de la 4.8.2](../../06_desarrollo_y_factibilidad/app-android/capturas/interfaz-4.8.2/README.md). Están aceleradas a 1,2 veces en el mismo archivo, así que se ven igual en cualquier navegador. Cada una corre solo en su momento, parte desde el comienzo y se repite sin fin.

| Momento | Archivo | Tramo de la grabación original | Duración |
| --- | --- | --- | --- |
| Preparar | [`videos/app-preparar.mp4`](videos/app-preparar.mp4) | `01-primera-vez`, de 0:33,4 a 1:20,8: las seis preguntas para leer | 41 s |
| Seguir en el teléfono | [`videos/app-seguir.mp4`](videos/app-seguir.mp4) | `02-cuando-suena`, de 0:00 a 0:09,9: Inicio cuenta el tiempo y la persona usa otra app | 9 s |
| Decidir | [`videos/app-decidir.mp4`](videos/app-decidir.mp4) | `02-cuando-suena`, de 0:16,2 al final: las preguntas breves y la decisión | 16 s |

En Preparar, la lista de la izquierda marca la pregunta que se ve en la grabación. En el PDF cada grabación es una captura de la misma versión.

Las grabaciones se hicieron en el emulador de Android, así que los textos del sistema salen en inglés y el aviso suena por notificación (ver las [notas de la grabación](../../06_desarrollo_y_factibilidad/app-android/capturas/interfaz-4.8.2/README.md#lo-que-hay-que-saber)). La pantalla de “Todo listo” en Criterios (lámina 16) sigue siendo de la 4.7.2, la versión de la prueba, porque dice “15 min en Chrome”, el mismo ejemplo del dibujo de la lámina 14.

## Cómo rehacer el PDF

Con un servidor local o directo desde el archivo, la dirección `index.html?pdf` pone cada lámina y cada estado en una página de 1920 × 1080. Chrome la imprime sin ventana:

```bash
"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome" --headless=new --no-pdf-header-footer --virtual-time-budget=10000 --print-to-pdf=presentacion-relevo-examen.pdf "file://$PWD/index.html?pdf"
```

Si la carpeta tiene espacios en la ruta, hay que escribirlos como `%20` en la dirección.

## Contenido de la carpeta

- `index.html`: las láminas, los estilos, el guion (`NOTAS`) y el código, en un solo archivo.
- `imagenes/`: fotos del Tag, modelos de Relevo Home y Go, planos, el logo, el logo de la Escuela, la pantalla “Todo listo” y las capturas de la app 4.8.2 que van en el PDF en lugar de las grabaciones.
- `videos/`: las tres grabaciones de la app.
- `fuentes/`: Instrument Sans en cinco pesos, con licencia SIL Open Font License dentro de cada archivo.

## Registro de cambios (disclaimer)

### 2026-11-26 — Creación

- **Qué cambió:** se crea la presentación oficial del examen como página HTML animada, con su PDF de respaldo, la vista del presentador y las grabaciones de la app a 1,2 veces.
- **Cómo estaba antes:** la presentación estaba en Figma Slides, como PDF sin animaciones (D-189).
- **Por qué:** el autor pidió la presentación oficial a partir del feedback del Pase. Aclaró que no tenía que ser en Figma, que hacía falta un PDF de 15 MB como máximo y que el otro formato podía ser más animado. Después pidió sumar los GIF de la app a 1,2 veces su velocidad.
