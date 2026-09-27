# Licencias de recursos de terceros

La aplicación Android incluye recursos que no fueron creados para el proyecto. Este registro indica bajo qué condiciones pueden redistribuirse junto con el código y el APK.

| Recurso | Ubicación | Autor | Licencia | Condición |
| --- | --- | --- | --- | --- |
| Schibsted Grotesk, fuente variable (desde 2.8) | `app/src/main/res/font/schibsted_grotesk.ttf` | The Schibsted-Grotesk Project Authors | SIL Open Font License 1.1 | Se puede usar, incluir en la app y redistribuir si se acompaña del aviso de licencia y no se vende la fuente por separado. El texto completo está en [`app/licenses/SCHIBSTED_GROTESK_LICENSE.md`](../app/licenses/SCHIBSTED_GROTESK_LICENSE.md) y proviene del [repositorio oficial](https://github.com/schibsted/schibsted-grotesk). |
| Seis fotografías (desde 2.8) | `app/src/main/res/drawable-nodpi/`, ver la tabla siguiente | Ver la tabla siguiente | CC0 1.0, dedicación al dominio público | Se pueden usar, modificar y redistribuir sin pedir permiso ni atribuir. Los créditos se dan por transparencia. |
| Emoji Noto 3D de Google, 24 imágenes (desde 2.9) | `app/src/main/res/drawable-nodpi/emoji_*.png` | Google | SIL Open Font License 1.1 | Se pueden usar, modificar y redistribuir con la app si se incluye el aviso de licencia y no se venden por separado. Se redujeron de 512 a 256 px; siguen bajo la misma licencia. El texto está en [`app/licenses/NOTO_EMOJI_LICENSE.md`](../app/licenses/NOTO_EMOJI_LICENSE.md). |
| Source Sans 3, cuatro pesos (hasta 2.7) | Ya no está en la app | Adobe | SIL Open Font License 1.1 | Antecedente. Su aviso se conserva en [`app/licenses/SOURCE_SANS_LICENSE.md`](../app/licenses/SOURCE_SANS_LICENSE.md) porque los APK anteriores la incluyen. |

## Emoji Noto 3D

Se tomaron del repositorio oficial [googlefonts/noto-emoji](https://github.com/googlefonts/noto-emoji), carpeta `3D/png/512`, publicada el 17 de septiembre de 2026. El archivo `LICENSE` del repositorio es la SIL Open Font License 1.1 desde 2024; su README aún dice que «la mayoría de los recursos de imagen» están bajo Apache 2.0. Las dos licencias permiten este uso con el aviso incluido. La app usa 24 emoji, reducidos a 256 px: zapatilla, libros, guitarra, paleta, planta, sartén, ovillo, bicicleta, cámara, audífonos, lápiz, pieza de rompecabezas, teclado, pelota, taza de café, pan, perro, gato, zorro, tortuga, girasol, ola, luna y sol.

## Fotografías CC0

Se obtuvieron mediante Openverse el 25 de septiembre de 2026 para el [estudio de marca](../../../10_recursos_visuales/marca-desde-cero/README.md), que ya las había tratado con la receta de imagen de D-073. La app usa esas versiones tratadas.

| Archivo en la app | Título original | Autor | Sitio | Enlace |
| --- | --- | --- | --- | --- |
| `foto_libro.jpg` | Open book and a cup of tea | freestocks.org | Flickr | https://www.flickr.com/photos/135396164@N05/29364151550 |
| `foto_escribir.jpg` | Writing Drawing | Green Chameleon | StockSnap | https://stocksnap.io/photo/writing-drawing-8Y0EDX4VP9 |
| `foto_aprender.jpg` | Student School | Tamarcus Brown | StockSnap | https://stocksnap.io/photo/student-school-KBTSP7FFIY |
| `foto_guitarra.jpg` | Ibanez guitar | freestocks.org | Flickr | https://www.flickr.com/photos/135396164@N05/22366640582 |
| `foto_pan.jpg` | Homemade Bread | Matt Bango | StockSnap | https://stocksnap.io/photo/homemade-bread-F2ICILB1GL |
| `foto_pintar.jpg` | Still Items | Tim Arterbury | StockSnap | https://stocksnap.io/photo/still-items-ATTVTHA1AW |

## Fotografías generadas con IA

Las otras quince fotografías de `drawable-nodpi` no son obras de terceros: salen de doce imágenes generadas con IA para el proyecto entre las versiones 2.3 y 2.6; tres de ellas se usan en dos encuadres. Hasta 2.7 se usaban como PNG; esos originales se conservan en [`assets-explorados/fotos-app-hasta-2.7`](../assets-explorados/fotos-app-hasta-2.7). En 2.8 se recortaron y trataron con la receta de imagen de D-073. Su procedencia se registra en [assets-explorados](../assets-explorados/README.md) y en la [trazabilidad del uso de IA](../../../00_gobernanza/trazabilidad-uso-ia-2026-09-23.md). Deben presentarse como imágenes generadas, no como fotografías documentales.

## Registro de cambios (disclaimer)

### 2026-09-27 — Emoji Noto 3D

- **Qué cambió:** se registran los 24 emoji 3D de Google del perfil, con su origen, licencia y tratamiento.
- **Cómo estaba antes:** el registro solo tenía la fuente y las fotografías.
- **Por qué:** la versión 2.9 usa esos emoji para la imagen del perfil (D-083).

### 2026-09-26 — Versión 2.8

- **Qué cambió:** Schibsted Grotesk pasa a ser la fuente de la app; se registran las seis fotografías CC0 con sus créditos y el tratamiento de las quince generadas con IA. Source Sans 3 queda como antecedente.
- **Cómo estaba antes:** el registro solo nombraba Source Sans 3 y decía que todas las fotografías se habían generado con IA.
- **Por qué:** la versión 2.8 cambió la fuente e incorporó fotografías de terceros; el repositorio y el APK son públicos.

### 2026-09-25 — Creación

- **Qué se añadió:** este registro de licencias y procedencia.
- **Cómo estaba antes:** el aviso de la OFL ya existía en `app/licenses/`, pero no había un índice que reuniera las licencias y la procedencia de las imágenes.
- **Por qué:** facilitar la comprobación de que todo el material ajeno se usa legalmente, ya que el código y el APK se publican en un repositorio público. Una primera versión de este registro duplicó por error el texto de la OFL; se retiró el duplicado.
