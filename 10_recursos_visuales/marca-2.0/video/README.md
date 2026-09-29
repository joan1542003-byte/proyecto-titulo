# Relevo en 30 segundos

Video de animación que presenta qué es Relevo, en español, con el lenguaje de la [marca 2.0](../../22_sistema-de-marca-2.0-figma-2026-09-27.md).

| Archivo | Formato |
| --- | --- |
| [relevo-30s.mp4](relevo-30s.mp4) | Versión vigente. 1920 × 1080, 60 cuadros por segundo, H.264 con audio AAC; 30 s y 10,4 MB |
| [relevo-30s-vertical.mp4](relevo-30s-vertical.mp4) | La misma pieza en vertical, 1080 × 1920, 60 cuadros por segundo; 30 s y 8,7 MB. En la app 2.11 va una versión de 720 × 1280 y 30 cuadros por segundo (2 MB) en la pantalla «Cómo funciona» |
| [relevo-15s.mp4](relevo-15s.mp4) | Primera versión, de 15 s (6,9 MB). Se conserva como antecedente |
| [fuente/](fuente/) | La escena en HTML (`index.html`), el renderizador (`render.js`) y la banda sonora (`audio.js`) de la versión de 30 s; las de 15 s están en `fuente/version-15s/`, y la versión vertical (`vertical.html`, el script que la deriva de `index.html` y el renderizador con tamaño configurable) en `fuente/version-vertical/` |

## Guion

| Segundos | Escena | Qué pasa |
| --- | --- | --- |
| 0–6 | El problema | Un feed se acelera dentro de un teléfono. «Abres una app para descansar.» Un reloj corre hasta 1:47 h: «Y lo que querías hacer quedó esperando.» Luego: «Acordarse después no es acordarse a tiempo.» |
| 6–11,5 | La idea | Un círculo de papel abre la escena. Se dibujan renglones de cuaderno y aparece «Vuelve a ___.» con «leer.», «dibujar.» y «caminar.» en azul, cada una con su emoji. Debajo: «Relevo es un recordatorio físico que preparas desde el teléfono.» |
| 11,5–19,3 | Cómo funciona | El renglón se vuelve una barra de tres pasos. Se escribe el relevo («Leer 10 páginas», «Abrir el libro», «En el velador»), el objeto cae junto al libro y, al completarse 15 minutos en YouTube, suena la firma sonora con ondas azules. |
| 19,3–24,9 | La decisión | La foto se convierte en la pantalla de la señal de la app. «Tú decides.», con las tres respuestas del mismo peso. |
| 24,9–27,2 | El sistema | «La app lo prepara.» «El objeto suena donde empiezas.» «Tú decides qué hacer.» |
| 27,2–30 | Cierre | Barrido azul y de papel. El logotipo se dibuja y se rellena; luego «Vuelve a lo que querías hacer.» y los emoji del perfil. |

## Cómo se hizo

- **Animación:** una página HTML en la que cada elemento se calcula según el tiempo, con curvas de aceleración propias. Chrome sin ventana captura los 1800 cuadros (`node render.js all 30`) y ffmpeg los une con el audio.
- **Sonido:** sintetizado por código (`audio.js`): clics de scroll que se aceleran, golpes suaves a 120 pulsos por minuto, barridos, notas al aparecer cada palabra y acordes. A los 17,95 s suena la firma sonora de D-071 (`../../marca-a-tiempo/sonido/firma-relevo.wav`).
- **Recursos:** Schibsted Grotesk (SIL OFL); seis fotografías CC0 de la app (libro, guitarra, pintar, pan, escribir y aprender), sin imágenes generadas con IA; emoji Noto 3D de Google (SIL OFL); iconos y logotipo propios. Créditos en las [licencias de la app](../../../06_desarrollo_y_factibilidad/app-android/licencias/README.md).
- **Para regenerar:** copia en una carpeta `a/` las fotos, emoji, iconos, la fuente `sg.ttf` y la firma sonora que carga `index.html`; instala `puppeteer-core`; ejecuta `node render.js all 30` y `node audio.js`, y une el resultado con ffmpeg (`-framerate 60 -i frames/f%04d.jpg -i banda.wav`).

## Versión vertical

Mismo guion, tiempos y sonido. Cambia la composición: el teléfono del comienzo va arriba y el texto debajo; «Vuelve a» y la actividad van en dos líneas; la foto del libro ocupa el centro y, en la decisión, la pantalla de la señal queda arriba y las tres respuestas abajo; las tres frases del sistema y los emoji del cierre se reparten a lo alto. Para regenerarla: `node vert-edits.js` sobre una copia de `index.html` llamada `vertical.html`, y `PAGE=vertical.html W=1080 H=1920 OUT=framesv node renderv.js all 30`.

## Límites

- La pantalla de la señal es una recreación animada de la app 2.10, no una captura. El GIF grabado en la app está en [capturas/como-funciona-2.10](../../../06_desarrollo_y_factibilidad/app-android/capturas/como-funciona-2.10/README.md).
- «1:47 h» en el teléfono es un ejemplo, no un dato de las entrevistas.
- Usa la marca 2.0, que todavía es una propuesta (D-085).

## Registro de cambios (disclaimer)

### 2026-09-28 — Versión vertical

- **Qué cambió:** se añadió la versión vertical de 30 segundos, sus fuentes y la explicación de su composición.
- **Cómo estaba antes:** el video solo existía en horizontal.
- **Por qué:** el autor pidió incluir el video en la app, ajustado a vertical.

### 2026-09-28 — Versión de 30 segundos

- **Qué cambió:** el video pasa a 30 segundos, con más tiempo en cada escena, una frase sobre recordar a tiempo, otra que dice qué es Relevo y una escena nueva sobre el sistema (app, objeto y persona). Se quitaron el crédito «Proyecto de título · Diseño UDP · 2026», los rótulos numerados de cada escena y el descriptor repetido del cierre.
- **Cómo estaba antes:** duraba 15 segundos y tenía esos rótulos y el crédito. Esa versión y sus fuentes se conservan.
- **Por qué:** el autor pidió una versión de 30 segundos sin textos que no aporten.

### 2026-09-28 — Creación

- **Qué se añadió:** el video de 15 segundos, sus fuentes y este documento.
- **Cómo estaba antes:** no había una pieza breve en video que explicara Relevo.
- **Por qué:** el autor pidió un video de animación de 15 segundos, en español, que muestre qué es Relevo.
