# Relevo en 15 segundos

Video de animación que presenta qué es Relevo, en español, con el lenguaje de la [marca 2.0](../../22_sistema-de-marca-2.0-figma-2026-09-27.md).

| Archivo | Formato |
| --- | --- |
| [relevo-15s.mp4](relevo-15s.mp4) | 1920 × 1080, 60 cuadros por segundo, H.264 con audio AAC; 15 s y 6,9 MB |
| [fuente/](fuente/) | La escena en HTML (`index.html`), el renderizador (`render.js`) y la banda sonora (`audio.js`) |

## Guion

| Segundos | Escena | Qué pasa |
| --- | --- | --- |
| 0–3 | El problema | Un feed se acelera dentro de un teléfono. «Abres una app para descansar.» Un reloj corre hasta 1:47 h: «Y lo que querías hacer quedó esperando.» |
| 3–6 | La idea | Un círculo de papel abre la escena. Se dibujan renglones de cuaderno y aparece «Vuelve a ___.» con «leer.», «dibujar.» y «caminar.» en azul, cada una con su emoji. |
| 6–9,4 | Cómo funciona | El renglón se vuelve una barra de tres pasos. Se escribe el relevo («Leer 10 páginas», «Abrir el libro», «En el velador»), el objeto cae junto al libro y, al cumplirse 15 minutos en YouTube, suena la firma sonora con ondas azules. |
| 9,4–12 | La decisión | La foto se convierte en la pantalla de la señal de la app. «Tú decides.», con las tres respuestas del mismo peso. |
| 12–15 | Cierre | Barrido azul y de papel. El logotipo se dibuja y se rellena; luego «Vuelve a lo que querías hacer.», el descriptor y los emoji del perfil. |

## Cómo se hizo

- **Animación:** una página HTML en la que cada elemento se calcula según el tiempo, con curvas de aceleración propias. Chrome sin ventana captura los 900 cuadros (`render.js`) y ffmpeg los une con el audio.
- **Sonido:** sintetizado por código (`audio.js`): clics de scroll que se aceleran, golpes suaves a 120 pulsos por minuto, barridos, notas al aparecer cada palabra y acordes. A los 8,45 s suena la firma sonora de D-071 (`../../marca-a-tiempo/sonido/firma-relevo.wav`).
- **Recursos:** Schibsted Grotesk (SIL OFL); seis fotografías CC0 de la app (libro, guitarra, pintar, pan, escribir y aprender), sin imágenes generadas con IA; emoji Noto 3D de Google (SIL OFL); iconos y logotipo propios. Créditos en las [licencias de la app](../../../06_desarrollo_y_factibilidad/app-android/licencias/README.md).
- **Para regenerar:** copia en una carpeta `a/` las fotos, emoji, iconos, la fuente `sg.ttf` y la firma sonora que carga `index.html`; instala `puppeteer-core`; ejecuta `node render.js all` y `node audio.js`, y une el resultado con ffmpeg (`-framerate 60 -i frames/f%04d.jpg -i banda.wav`).

## Límites

- La pantalla de la señal es una recreación animada de la app 2.10, no una captura; el GIF grabado en la app está en [capturas/como-funciona-2.10](../../../06_desarrollo_y_factibilidad/app-android/capturas/como-funciona-2.10/README.md).
- «1:47 h» en el teléfono es un ejemplo, no un dato de las entrevistas.
- Usa la marca 2.0, que todavía es una propuesta (D-085).

## Registro de cambios (disclaimer)

### 2026-09-28 — Creación

- **Qué se añadió:** el video de 15 segundos, sus fuentes y este documento.
- **Cómo estaba antes:** no había una pieza breve en video que explicara Relevo.
- **Por qué:** el autor pidió un video de animación de 15 segundos, en español, que muestre qué es Relevo.
