# Tipografía

## Dos voces

Relevo habla en Schibsted Grotesk y, en su frase principal, en Newsreader romana. Lo que escribió la persona va en Newsreader itálica, en tinta y sobre el renglón. En la app 2.18 la voz de la persona era azul; en 3.1 el azul queda para el sistema y la letra hace la diferencia. Así funciona también en blanco y negro, sin depender del color (W3C, 2023, criterio 1.4.1).

| Voz | Letra | Estilos | Dónde |
| --- | --- | --- | --- |
| Relevo, la interfaz | Schibsted Grotesk | Grupo Interfaz | Todo lo que se toca y se lee de corrido |
| Relevo, la frase principal | Newsreader romana | Grupo Titulares | Una frase por pantalla, lámina o afiche |
| La persona | Newsreader itálica | Grupo Voz de la persona | Lo que escribió: actividad, cómo empieza, dónde |
| Los datos | IBM Plex Mono 300 | `mono` | Registros, fichas de actividad y el panel del investigador |

## Schibsted Grotesk

Variable de 400 a 900 (`fonts/schibsted-grotesk.ttf`). Es la letra de la app 2.18, del logotipo y, desde 3.0, de las presentaciones, que dejan Inter.

- Texto: `body` 17/26 en 400. Destacados: `headline` 17/22 en 600.
- Títulos: `title2` 22/28 en 600, `title` 28/34 y `largeTitle` 34/40 en 650 con −2 %.
- Rótulos: `label` 14/18 y `section` 15/20 en 600, como frase («Ahora», «La última vez»).
- Logotipo: 600, un paso más fino que los títulos.

## Newsreader

Serif con tamaño óptico de 6 a 72 (eje `opsz`): a 72 px es fina y contrastada; a 19 px, más robusta y abierta (Microsoft, 2024). El navegador elige la forma según el tamaño (`font-optical-sizing: auto`).

- Romana 380 con −1,5 %: `displayTitle` 36/40 (pantallas principales), `displayCard` 30/34 (la tarjeta del relevo), `displaySignal` 44/46 (la señal), `displaySlide` 54/58 (láminas) y `displayPoster` 72/74 (afiches). Desde 28 px; nunca en botones, filas ni párrafos.
- Itálica: `personaDisplay` 36/40 en 380, dentro de un titular («Vuelve a *leer*.»); `persona` 22/28 en el campo donde se escribe; `personaBody` 19/26 en los valores de las filas, junto a texto de 17.

## IBM Plex Mono

Solo en 300 (`mono`, 13/18) y solo para datos: la ficha de la actividad en afiches («Leer · Abrir el libro · Junto al sillón»), números de lámina, registros y el panel del investigador. Sus cifras tienen el mismo ancho, así las columnas se alinean.

## Reglas

- Nada en mayúsculas sostenidas ni con letras espaciadas.
- Una frase en serif por pantalla. La itálica es solo de la persona.
- Cifras de tiempo con números tabulares: «6 min de 15», «1 h 15 min».
- La app respeta el tamaño de texto del sistema y suma un 15 % con «Texto grande»; los estilos crecen juntos.

## Por qué así

- **Ninguna letra es la más rápida para todos.** En un estudio con muchas letras y lectores, cada persona leyó más rápido con letras distintas (Wallace et al., 2022). Por eso lo que se lee de corrido queda en la grotesca que ya usa la app, y la serif se reserva para una frase.
- **La serif la pidió el autor.** Pidió serif en titulares (D-098, 30 de septiembre). Newsreader se eligió entre cinco serifas libres (Instrument Serif, Newsreader, Literata, Source Serif 4 y Fraunces) por su tamaño óptico, que la hace servir en pantalla desde 19 px.
- **La itálica como voz.** Distingue las palabras de la persona sin comillas ni color, y se lee igual en blanco y negro o con una visión del color distinta.
- **Alternativa abierta.** Instrument Serif, más condensada y sin tamaño óptico, sigue en la mesa. Cambiarla es tocar solo `type.families.serif`.

## Licencias

Schibsted Grotesk (The Schibsted-Grotesk Project Authors), Newsreader (Production Type) e IBM Plex Mono (IBM) tienen licencia SIL Open Font. Schibsted Grotesk va en `fonts/`; las otras dos se cargan de Google Fonts.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** sección nueva de tipografía: las dos voces, Newsreader con tamaño óptico, IBM Plex Mono para datos y razones.
- **Cómo estaba antes:** la tipografía se describía solo en el README.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
