# Logotipo, renglón e ícono

## El logotipo

«relevo» en minúsculas, en Schibsted Grotesk 650 con −3 %, sobre un renglón azul del ancho de la palabra. Las letras son contornos del archivo `relevo-tinta.svg` del sistema 2.0; el renglón es el agregado de 3.0.

**Construcción** (en unidades de la letra, 1 em = alto del cuerpo):

- Renglón de 0,075 em de alto (7,5 % del cuerpo).
- Borde superior del renglón a 0,236 em bajo la línea base.
- Largo: desde el asta de la «r» hasta el borde de la «o».

**Versiones** (grupo Logotipo):

| Archivo | Letras | Renglón | Fondo |
| --- | --- | --- | --- |
| `relevo-tinta.svg` | `tinta` | `azul-500` | `paper`, blanco, fotos claras (principal) |
| `relevo-papel.svg` | `papel` | `azul-300` | `tinta`, fotos oscuras |
| `relevo-blanco.svg` | `blanco` | `blanco` | `azul-500` |

En código, `Wordmark` (tonos `ink`, `paper`, `white` y `on-blue`).

**Tamaño y aire:** al menos 64 px de ancho (16 px de alto de letras). Alrededor, un espacio libre igual a la altura de la «o». En la barra de la app mide 22 px de alto.

**No:** con mayúscula; en azul; con el renglón más fino, punteado o separado; estirado o con sombra; sobre la trama o una foto sin tarjeta; acompañado de un símbolo.

## El renglón como recurso

El renglón une las piezas: el del logotipo, el que subraya la idea clave de cada diapositiva, el campo donde la persona escribe y la banda azul en la base del parlante. En texto se dibuja con `Subrayado` o `Signature`: 0,09 em de grosor, en `blue`, continuo bajo la palabra. Uno por pantalla.

## Ícono de la app

La «r» del logotipo sobre su renglón, centrada en un cuadrado de 512 px con esquinas de 114 px.

| Archivo | Fondo | «r» y renglón | Uso |
| --- | --- | --- | --- |
| `icono-azul.svg` | `azul-500` | `blanco` | Principal: lanzador, tienda, presentación |
| `icono-tinta.svg` | `tinta` | `papel` y renglón `azul-300` | Fondos claros, impresión en negro |
| `icono-trama.svg` | `azul-500` con trama | `blanco` | Portadas y piezas grandes, desde 96 px |

**Construcción:** la «r» mide 0,667 del alto de la caja en cuerpo (64 px en 96), y el renglón, un tercio del ancho y 5/96 de alto, a 4/96 bajo la línea base. El conjunto va centrado ópticamente.

Para Android, la versión adaptable lleva la «r» y el renglón en primer plano y `azul-500` de fondo; el ícono monocromo, solo la «r» y el renglón.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
