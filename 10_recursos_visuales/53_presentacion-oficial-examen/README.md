# Presentación oficial del examen

La presentación del examen de título, en dos formatos:

- **[`index.html`](index.html):** la versión animada, para proyectar. Tiene 28 láminas y 9 de respaldo, con ocho grabaciones de la app 4.8.2 a 1,2 veces su velocidad.
- **[`presentacion-relevo-examen.pdf`](presentacion-relevo-examen.pdf):** el respaldo oficial. Tiene 34 páginas, una por lámina y por estado, y termina en “Gracias”. Pesa menos de 15 MB.
- **[`respaldo-para-preguntas.pdf`](respaldo-para-preguntas.pdf):** las 9 láminas de respaldo, aparte. No se muestran salvo que la comisión pregunte por ese tema.

La estructura, el guion completo y lo que se hizo con el feedback del Pase están en el [documento 53](../53_presentacion-oficial-examen-2026-12.md).

## Cómo presentar

1. Abrir `index.html` con doble clic en Chrome. Funciona sin internet: las letras, las imágenes y las grabaciones están en esta carpeta.
2. Pulsar **F** para la pantalla completa.
3. Pulsar **P** para abrir la vista del presentador en otra ventana. Muestra la lámina actual, la siguiente, el guion de cada lámina y un cronómetro que parte al primer avance. A los 14 minutos el cronómetro se pone rosado.
4. Pulsar **→**, la barra espaciadora o hacer clic para pasar a la lámina siguiente. **←** vuelve. Se puede avanzar desde cualquiera de las dos ventanas.

**Todo lo de cada lámina entra solo**, en orden y sin tocar nada: los textos, las líneas, los puntos, las barras y las grabaciones. La tecla solo cambia de lámina. Hay dos excepciones, porque cada estado funciona como una lámina: la rueda de las tres palabras (lámina 2) y los cuatro momentos de “Cómo funciona Relevo” (lámina 14). Ahí cada pulsación pasa a la palabra o al momento siguiente.

**La presentación se detiene en “Gracias”.** Después de esa lámina, la tecla no avanza. El respaldo se abre con **R** y se cierra con **R** o **Esc**, que vuelven a la lámina donde se estaba.

| Tecla | Qué hace |
| --- | --- |
| → o espacio | Lámina siguiente |
| ← | Lámina anterior |
| F | Pantalla completa |
| P | Vista del presentador |
| R | Abre el respaldo; otra vez R, o Esc, vuelve |
| G | Todas las láminas en una grilla; un clic abre una |
| B | Pantalla negra; se vuelve con B |
| H | Muestra la ayuda de teclas |
| Inicio y Fin | Primera lámina y “Gracias” |

Para abrir una lámina directo se escribe su número al final de la dirección, por ejemplo `index.html#14` o `index.html#14.2` para el tercer momento de la lámina 14.

## Las grabaciones de la app

Hay ocho grabaciones de la app 4.8.2, sacadas de las [capturas de la 4.8.2](../../06_desarrollo_y_factibilidad/app-android/capturas/interfaz-4.8.2/README.md). Están aceleradas a 1,2 veces dentro del mismo archivo, así que se ven igual en cualquier navegador. Cada una parte desde el comienzo cuando aparece y se repite sin fin.

| Lámina | Archivo | Tramo de la grabación original | Duración |
| --- | --- | --- | --- |
| 14 · Preparar | [`videos/app-preparar.mp4`](videos/app-preparar.mp4) | `01-primera-vez`, de 0:33,4 a 1:20,8: las seis preguntas para leer | 41 s |
| 14 · Seguir en el teléfono | [`videos/app-seguir.mp4`](videos/app-seguir.mp4) | `02-cuando-suena`, de 0:00 a 0:09,9: Inicio cuenta el tiempo y la persona usa otra app | 9 s |
| 14 · Oír la señal | [`videos/app-oir.mp4`](videos/app-oir.mp4) | `04-relevo-activo-y-aviso-sonando`, de 0:25,6 a 0:33,6: el aviso suena y se silencia | 7 s |
| 14 · Decidir | [`videos/app-decidir.mp4`](videos/app-decidir.mp4) | `02-cuando-suena`, de 0:16,2 al final: las preguntas breves y la decisión | 16 s |
| 15 · La primera vez | [`videos/app-primera-vez.mp4`](videos/app-primera-vez.mp4) | `01-primera-vez`, de 0:03 a 0:27,5: la bienvenida, el consentimiento y el permiso | 21 s |
| 15 · Actividades | [`videos/app-actividades.mp4`](videos/app-actividades.mp4) | `06-actividades-y-nueva-actividad`, de 0:05,5 al final | 27 s |
| 15 · Ayuda | [`videos/app-ayuda.mp4`](videos/app-ayuda.mp4) | `07-perfil-y-ayuda`, de 0:13,6 a 0:53,8: cómo funciona Relevo y cómo usar el Tag | 35 s |
| 15 · Ajustes | [`videos/app-ajustes.mp4`](videos/app-ajustes.mp4) | `08-ajustes`, de 0:02,6 al final: sonido, horas sin sonar, avisos, permisos y datos | 31 s |

En Preparar, la lista de la izquierda marca la pregunta que se ve en la grabación. En el PDF, cada grabación es una captura de la misma versión.

Las grabaciones se hicieron en el emulador de Android, así que los textos del sistema salen en inglés y el aviso suena por notificación (ver las [notas de la grabación](../../06_desarrollo_y_factibilidad/app-android/capturas/interfaz-4.8.2/README.md#lo-que-hay-que-saber)). La lámina 15 lo dice abajo. La pantalla de “Todo listo” en Criterios (lámina 17) sigue siendo de la 4.7.2, la versión de la prueba, porque dice “15 min en Chrome”, el mismo ejemplo del dibujo de la lámina 14.

## Movimiento

- Las láminas se funden entre sí en menos de un segundo.
- Lo de adentro entra en orden, cada unos 1,9 segundos, con un resorte sin rebote: sube un poco, se enfoca y se queda quieto. Las líneas se dibujan en casi 2 segundos y las barras crecen en 1,7.
- Si el computador tiene activado “Reducir movimiento”, todo aparece con un fundido simple.

## Cómo rehacer los PDF

La dirección `index.html?pdf` pone cada lámina y cada estado en una página de 1920 × 1080, y `index.html?pdf=respaldo` hace lo mismo con el respaldo. Chrome las imprime sin ventana:

```bash
"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome" --headless=new --no-pdf-header-footer --virtual-time-budget=10000 --print-to-pdf=presentacion-relevo-examen.pdf "file://$PWD/index.html?pdf"
```

```bash
"/Applications/Google Chrome.app/Contents/MacOS/Google Chrome" --headless=new --no-pdf-header-footer --virtual-time-budget=10000 --print-to-pdf=respaldo-para-preguntas.pdf "file://$PWD/index.html?pdf=respaldo"
```

Si la carpeta tiene espacios en la ruta, hay que escribirlos como `%20` en la dirección.

## Contenido de la carpeta

- `index.html`: las láminas, los estilos, el guion (`NOTAS`) y el código, en un solo archivo.
- `imagenes/`: fotos del Tag, modelos de Relevo Home y Go, planos, el logo, el logo de la Escuela, la pantalla “Todo listo”, el primer cuadro de cada grabación y la captura que la reemplaza en el PDF.
- `videos/`: las ocho grabaciones de la app.
- `fuentes/`: Instrument Sans en cinco pesos, con licencia SIL Open Font License dentro de cada archivo.

## Registro de cambios (disclaimer)

### 2026-11-26 — Animaciones solas, más app y el respaldo aparte

- **Qué cambió:** lo de cada lámina entra solo y la tecla solo cambia de lámina, salvo en la rueda de las tres palabras y en los cuatro momentos de Relevo. Las animaciones son más lentas y suaves. Se suman la lámina 15, “La aplicación, más allá de un relevo”, con cuatro grabaciones, y una grabación en “Oír la señal”. Los teléfonos de la lámina 14 son más grandes y tienen el marco de un equipo real. La presentación termina en “Gracias”: el respaldo se abre con R y va en un PDF aparte.
- **Cómo estaba antes:** cada aparición pedía una pulsación, las animaciones eran más rápidas, había tres grabaciones y el respaldo seguía después de “Gracias”, también en el PDF.
- **Por qué:** el autor preguntó qué era lo que venía después de “Gracias”, y pidió animaciones más suaves y lentas, que se reproduzcan solas, ver más de la app en el teléfono y un diseño a nivel de Apple.

### 2026-11-26 — Creación

- **Qué cambió:** se crea la presentación oficial del examen como página HTML animada, con su PDF de respaldo, la vista del presentador y las grabaciones de la app a 1,2 veces.
- **Cómo estaba antes:** la presentación estaba en Figma Slides, como PDF sin animaciones (D-189).
- **Por qué:** el autor pidió la presentación oficial a partir del feedback del Pase. Aclaró que no tenía que ser en Figma, que hacía falta un PDF de 15 MB como máximo y que el otro formato podía ser más animado. Después pidió sumar los GIF de la app a 1,2 veces su velocidad.
