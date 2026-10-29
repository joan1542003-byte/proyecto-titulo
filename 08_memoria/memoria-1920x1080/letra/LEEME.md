# Letra

La memoria usa Instrument Sans, de Rodrigo Fuenzalida y Jordan Egstad, con licencia SIL Open Font License 1.1 ([OFL.txt](OFL.txt)). La licencia permite usarla, copiarla y redistribuirla junto con la licencia.

## Para Affinity: las estáticas

[`estaticas/`](estaticas/) tiene los cinco estilos que usa la memoria. Se instalan con doble clic en cada archivo (Mac: Catálogo Tipográfico; Windows: Instalar) antes de abrir el IDML.

| Estilo | Archivo | Dónde se usa |
| --- | --- | --- |
| Regular | `InstrumentSans-Regular.ttf` | Texto continuo, celdas, notas y números de apertura. |
| Italic | `InstrumentSans-Italic.ttf` | Cursivas del texto y títulos de tablas y figuras. |
| Medium | `InstrumentSans-Medium.ttf` | El «de 24» que acompaña a las cifras de resultados. |
| SemiBold | `InstrumentSans-SemiBold.ttf` | Títulos, subtítulos, rótulos, negritas y cifras. |
| SemiBold Italic | `InstrumentSans-SemiBoldItalic.ttf` | Cursivas dentro de títulos y negritas. |

El logotipo usa Chillax Semibold, pero va dibujado como vector dentro de la memoria: no hace falta instalarla.

Son estáticas porque, con el archivo variable, Affinity dibujaba todos los pesos en regular. Se generaron el 13 de octubre de 2026 a partir de los archivos variables, con fontTools (`varLib.instancer`, ancho 100), y son las mismas que están instaladas en el computador del autor.

## Para el generador: las variables

- **Redonda:** la de la app, `06_desarrollo_y_factibilidad/app-android/app/src/main/res/font/instrument_sans.ttf`.
- **Cursiva:** [`InstrumentSans-Italic.ttf`](InstrumentSans-Italic.ttf), la cursiva variable de Google Fonts (<https://github.com/google/fonts/tree/main/ofl/instrumentsans>), descargada el 13 de octubre de 2026.

## Registro de cambios (disclaimer)

### 2026-10-29 — Solo los estilos usados

- **Qué cambió:** salen Bold, Bold Italic y Medium Italic, que la memoria no usa; quedan cinco estilos, con lo que hace cada uno. El IDML declara solo esos cinco.
- **Cómo estaba antes:** ocho estilos estáticos.
- **Por qué:** el autor pidió revisar las fuentes y eliminar las que no se usan (D-150).

### 2026-10-28 — Creación

- **Qué se añadió:** los ocho estilos estáticos de Instrument Sans para Affinity, la cursiva variable y la licencia.
- **Cómo estaba antes:** las estáticas existían solo en el computador del autor, y el repositorio guardaba solo la cursiva variable, en la carpeta de la versión A3.
- **Por qué:** el autor pidió subir las tipografías al repositorio para seguir trabajando en Affinity (D-146).
