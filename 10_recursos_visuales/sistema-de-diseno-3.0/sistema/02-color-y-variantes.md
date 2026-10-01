# Color y variantes

Relevo es casi monocromo: papel, tinta y un azul eléctrico. El azul es el de la presentación (`#3D38F5`), el que se recordó en la corrección cruzada. Es saturado y cercano al azul con que la pantalla forma la imagen: si la trama son los píxeles, el azul es su luz. Se distingue del verde de las apps de bienestar digital y del rojo de error, y se imprime con dos tintas.

## Escala

| Token | Valor | Uso |
| --- | --- | --- |
| `azul-700` | `#1F1BB4` | Azul presionado; impresión de una tinta |
| `azul-500` | `#3D38F5` | El azul de Relevo: logotipo, renglón, ícono de la app, portadas |
| `azul-300` | `#9A97FF` | El azul sobre fondos oscuros y en el tema oscuro |
| `azul-200` | `#C4C2FC` | Puntos claros de la trama |
| `azul-50` | `#ECEBFE` | Selección y fondos de etiqueta |
| `tinta` | `#17181C` | Fondos oscuros fijos e impresión en negro |
| `papel` | `#F2F2EF` | Fondo de piezas y letras sobre tinta |
| `blanco` | `#FFFFFF` | Letras sobre `azul-500` |

En la interfaz se usan los tokens semánticos (`paper`, `card`, `ink`, `graphite`, `blue`…), que cambian con el tema. La escala fija es para el logotipo, el ícono, la impresión y las piezas de comunicación.

## Proporción

En una pantalla de la app, el azul ocupa cerca del 10 %: el renglón, el tiempo y la pestaña elegida. El resto es papel, tarjetas y tinta. En portadas y afiches el azul puede llenar el fondo, siempre con el logotipo y la trama; el color solo es lo que menos distingue a una marca (Ward et al., 2020).

## Combinaciones

| Fondo | Texto | Renglón | Contraste del texto |
| --- | --- | --- | --- |
| `paper` / `card` (claro) | `ink` | `blue` | 15,8:1 / 17,3:1 |
| `paper` / `card` (oscuro) | `ink` | `blue` (`azul-300`) | 15,6:1 / 14,1:1 |
| `tinta` | `papel` | `azul-300` | 15,8:1 |
| `azul-500` | `blanco` | `blanco` | 6,81:1 |
| `azul-300` (tema oscuro) | `on-blue` | `on-blue` | 7,35:1 |
| Vidrio sobre la trama | `ink` | `blue` | 9,3:1 o más |

**No:** texto azul subrayado; azul sobre azul; texto de color sobre la trama sin tarjeta; el azul en botones; otros colores de acento.

## Temas

- **Claro** (por omisión): papel `#F2F2EF`, tarjetas `#FCFCFA` y tinta `#17181C`.
- **Oscuro:** noche `#111215`, tarjetas `#1B1C20` y tinta clara `#E9EAEC`. El azul pasa a `azul-300` para mantener 6,7:1 sobre las tarjetas.
- La persona elige claro, oscuro o automático en Apariencia.

## Variante «azul a celeste»

Un paso de `azul-700` a `azul-500`, `#2E7BFF` y `#7CC4FF`, en vez de una sola tinta. Es más viva, pero su cambio de color no tiene un significado propio, así que queda como variante para piezas de comunicación y no entra en la interfaz. Se usa solo en el renglón de afiches y en campos de trama de portadas, nunca en texto.

## Estados

- Error: `error` con `error-soft` (botón destructivo) o `error-tint` (aviso). Siempre con ícono y palabras, nunca solo el color.
- Deshabilitado: `gray` sobre `mist`. Exento del contraste mínimo, pero nunca es la única pista: el botón que falta completar usa GuardedButton y dice qué falta.
- Presionado: `slate` (tinta), `line` (niebla), `row-pressed` (filas).

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
