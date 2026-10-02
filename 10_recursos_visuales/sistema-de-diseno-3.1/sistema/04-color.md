# Color

## La pantalla es azul; la casa, de colores

Relevo trabaja entre dos lugares: el teléfono, donde la persona se quedó, y la casa, donde empieza lo que quería hacer. El color dice en cuál de los dos estás. El azul eléctrico es Relevo: la pantalla, el sistema, el renglón y el tiempo. Los seis colores de la casa son las actividades de la persona, y cada uno sale del material donde esa actividad empieza.

## El azul

El azul de la presentación (`#3D38F5`), el que se recordó en la corrección cruzada. Es saturado y cercano al azul con que la pantalla forma la imagen: si la trama son los píxeles, el azul es su luz.

| Token | Valor | Uso |
| --- | --- | --- |
| `azul-700` | `#1F1BB4` | Azul presionado; impresión de una tinta |
| `azul-500` | `#3D38F5` | Logotipo, renglón, ícono de la app, portadas |
| `azul-300` | `#9A97FF` | El azul sobre fondos oscuros y en el tema oscuro |
| `azul-200` | `#C4C2FC` | Puntos claros de la trama |
| `azul-50` | `#ECEBFE` | Selección y fondos de etiqueta |

En la interfaz se usa `blue`, que pasa a `azul-300` en el tema oscuro. El azul ocupa cerca del 10 % de una pantalla y nunca se usa en botones ni para una categoría.

## Los colores de la casa

| Categoría | Familia | Firma | Material | Rol |
| --- | --- | --- | --- | --- |
| Moverme | terracota | 600 · `#B0582D` | el ladrillo y la tierra de afuera | `moverme` |
| Leer | mostaza | 300 · `#DAB974` | el papel y la luz de una lámpara | `leer` |
| Crear con las manos | arcilla | 400 · `#DA8C8E` | la arcilla y el pigmento | `crear` |
| Aprender algo | pizarra | 800 · `#1A4D55` | el pizarrón y la tinta | `aprender` |
| Cuidar la casa y a mí | salvia | 500 · `#649C66` | las hojas de una planta | `cuidar` |
| Con otras personas | ciruela | 700 · `#82466F` | una tela de sobremesa | `compartir` |

Las categorías son los cinco intereses de la app y «Con otras personas», que reúnen las actividades de las entrevistas P1 a P8 (documento 23). Cada familia tiene diez pasos constantes, de 50 a 900 (`terracota-50` … `terracota-900`), iguales en los dos temas.

## Roles por categoría

| Rol | Claro | Oscuro | Uso |
| --- | --- | --- | --- |
| `<cat>` | la firma | la firma | Campos de color, afiches, fotos en trama. Sin texto encima. |
| `<cat>-line` | 600 | 300 | El renglón y los íconos de la categoría. |
| `<cat>-text` | 700 | 200 | Rótulos de la categoría (`ActivityTag`). |
| `<cat>-soft` | 100 | 900 | Fondo de etiquetas y tarjetas de la categoría. |

## Contraste medido

| Familia | 600 sobre `paper` | 600 sobre `card` | 700 sobre `paper` | 700 sobre su 100 | 300 sobre la tarjeta oscura | 200 sobre su 900 |
| --- | --- | --- | --- | --- | --- | --- |
| mostaza | 4,20:1 | 4,59:1 | 5,91:1 | 5,56:1 | 9,06:1 | 9,52:1 |
| arcilla | 4,38:1 | 4,78:1 | 6,11:1 | 5,69:1 | 8,80:1 | 9,59:1 |
| salvia | 3,96:1 | 4,32:1 | 5,59:1 | 5,31:1 | 9,39:1 | 9,45:1 |
| terracota | 4,37:1 | 4,78:1 | 6,11:1 | 5,69:1 | 8,80:1 | 9,64:1 |
| ciruela | 4,38:1 | 4,79:1 | 6,13:1 | 5,70:1 | 8,79:1 | 9,60:1 |
| pizarra | 4,01:1 | 4,38:1 | 5,70:1 | 5,41:1 | 9,28:1 | 9,54:1 |

Los renglones e íconos piden 3:1 y el texto 4,5:1 (W3C, 2023). La tinta sobre cualquier `<cat>-soft` claro pasa 14,7:1.

## Por qué así

- **Apagados a propósito.** En OKLCH, el croma de las firmas va de 0,055 a 0,128; el del azul es 0,266. La casa no compite con la pantalla, y Relevo no usa colores vivos para llamar la atención, que es justo lo que critica.
- **Una claridad distinta para cada firma.** Las firmas van de 0,80 (mostaza) a 0,39 (pizarra) de luminosidad, así se distinguen también por lo claras u oscuras. La distancia mínima entre firmas (ΔEok × 100) es 13,2 con visión típica, 4,8 con protanopía (ciruela y pizarra), 8,5 con deuteranopía (salvia y terracota) y 9,8 con tritanopía (mostaza y arcilla), según la simulación de Machado et al. (2009). Todas quedan lejos del azul (24,7 o más). Aun así, una categoría siempre va con su ícono y su nombre.
- **Escalas en OKLCH.** Cada paso tiene la misma luminosidad en las seis familias (Ottosson, 2020): el 600 de todas pesa lo mismo y ningún renglón se ve más fuerte que otro.
- **El color no es la marca.** Los colores son lo que menos distingue a una marca por sí solo (Ward et al., 2020): por eso siempre van con el renglón, la trama o el logotipo.

## Combinaciones

| Fondo | Texto | Renglón | Contraste del texto |
| --- | --- | --- | --- |
| `paper` / `card` (claro) | `ink` | `blue` o `<cat>-line` | 15,8:1 / 17,3:1 |
| `paper` / `card` (oscuro) | `ink` | `blue` (`azul-300`) o `<cat>-line` (300) | 15,6:1 / 14,1:1 |
| `<cat>-soft` | `<cat>-text` o `ink` | `<cat>-line` | 5,3:1 o más |
| `tinta` | `papel` | `azul-300` | 15,8:1 |
| `azul-500` | `blanco` | `blanco` | 6,81:1 |
| Campo `<familia>-50` (afiches) | `ink` | `<familia>-600` | 16,1:1 o más |

**No:** texto azul subrayado; texto sobre una firma o un campo de trama sin tarjeta; un color de la casa en botones, foco, tiempo o progreso; dos categorías mezcladas en un mismo renglón; más de una categoría por afiche.

## Temas

- **Claro** (por omisión): papel `#F2F2EF`, tarjetas `#FCFCFA` y tinta `#17181C`.
- **Oscuro:** noche `#111215`, tarjetas `#1B1C20` y tinta clara `#E9EAEC`. El azul pasa a `azul-300`; los renglones de la casa, a su 300; los rótulos, a su 200, y los fondos suaves, a su 900.

## Estados

- Error: `error` con `error-soft` (botón destructivo) o `error-tint` (aviso). Siempre con ícono y palabras.
- Deshabilitado: `gray` sobre `mist`. Nunca es la única pista: `GuardedButton` dice qué falta.
- Presionado: `slate` (tinta), `line` (niebla), `row-pressed` (filas).

## La variante «azul a celeste»

En 3.0 quedó descrita una variante de `azul-700` a `#7CC4FF` para piezas. En 3.1 la variedad la dan los colores de la casa, que sí tienen un significado; la variante queda como antecedente y no se usa.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** reemplaza a 02-color-y-variantes.md: suma los seis colores de la casa, sus roles por categoría, el contraste medido y las razones.
- **Cómo estaba antes:** el color era de una sola tinta azul, con la variante «azul a celeste».
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
