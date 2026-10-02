# Logotipo, símbolo e ícono

## La idea

«Relevar» también quiere decir resaltar (D-071 tomó esa acepción y la de liberar de un peso). El logotipo la dibuja: un renglón que resalta la palabra y que sigue después de la «o», dejando lugar. Es la frase de la memoria, «Hazle lugar a lo que quieres hacer» (D-062), hecha forma. La marca no usa metáforas de carrera ni de turno, que quedaron atrás en D-071.

## Construcción

En unidades de la fuente (2048 por eme; la «l» mide 1500):

| Parte | Medida | Por qué |
| --- | --- | --- |
| Letra | Schibsted Grotesk 600 | La letra de la app. Un paso más fino que los títulos (650): la palabra se lee como dibujo y no como título. |
| Espaciado | −2,2 % | Cierra la palabra sin que las letras se toquen en tamaños chicos. |
| Kerning | el −40, le −10, vo −8 | Empareja los huecos que deja la «l» alta y la diagonal de la «v». |
| Renglón | 160 de alto, en cápsula | El grosor del travesaño de la «e»: el renglón pesa lo mismo que las letras. Cápsula como los controles de la app. |
| Distancia | 180 bajo la línea base | Cerca para leerse como parte de la palabra, lejos para no tocar las letras. |
| Largo | desde el asta de la «r» hasta una altura de x (1080) después de la «o» | Hace lugar. |

La lámina `construccion.svg` muestra las medidas y el área de respeto: la altura de la «o» alrededor.

## Exploración

Se probaron seis posiciones del renglón con la misma palabra (`exploracion-renglon.svg`): el rectángulo de 3.0, sobre la línea base, bajo la palabra y pasando la «o» (elegida), del ancho exacto de la palabra, la «o» como parlante y la «o» llena. Quedó la que se lee como renglón y deja lugar; la «o» como parlante ponía el objeto en el centro, lo que D-072 dejó atrás. Después se ajustaron peso (560, 600, 700), espaciado (0 y −3,5 %) y distancia (166, 180, 240) en `exploracion-ajustes.svg`.

## Versiones

| Archivo | Letras | Renglón | Fondo |
| --- | --- | --- | --- |
| `relevo.svg` | `tinta` | `azul-500` | `papel`, blanco, fotos claras (principal) |
| `relevo-papel.svg` | `papel` | `azul-300` | `tinta`, fotos oscuras |
| `relevo-blanco.svg` | `blanco` | `blanco` | `azul-500` |
| `relevo-tinta.svg` | `tinta` | `tinta` | Una sola tinta: sellos, grabado, fotocopia |
| `relevo-azul-profundo.svg` | `tinta` | `azul-700` | Impresión, donde el azul eléctrico se apaga |
| `relevo-compacto.svg` | `tinta` | `azul-500` | Espacios estrechos: el renglón del ancho de la palabra |
| `relevo-trama.svg` | `tinta` en medio tono | puntos `azul-500` | Momentos de marca, desde 240 px de ancho |
| `relevo-<familia>.svg` | `tinta` | `<familia>-600` | Piezas de una sola categoría |

En código: `Wordmark` con `tone` (`ink`, `paper`, `white`, `on-blue`, `mono`), `renglon` (una categoría como `leer`, una familia como `salvia` o un color) y `compact`. El tamaño es el alto de la «l».

## Firmas

- `firma-horizontal.svg`: el logotipo con «Vuelve a lo que querías hacer.» en dos líneas a la derecha.
- `firma-vertical.svg`: la firma debajo, para portadas y cierres.
- `firma-descriptor.svg`: con «Un recordatorio físico que preparas desde el teléfono.», cuando la audiencia no conoce Relevo.

## Símbolo e ícono de la app

- **Símbolo:** la «r» del logotipo con su renglón, que también la pasa en una altura de x (`simbolo.svg`, `Symbol`). Va solo; nunca al lado del logotipo.
- **Ícono de la app:** el símbolo al 62 % del ancho de una caja de 512 con esquinas de 114, centrado ópticamente (`AppIcon`). `icono-azul.svg` es el principal; `icono-tinta.svg` y `icono-papel.svg` para fondos oscuros y claros; `icono-trama.svg` lleva puntos que crecen hacia una esquina y se usa desde 96 px.
- **Android:** `android-frente.svg` y `android-fondo.svg` forman el ícono adaptable (zona segura de 66 dp); `android-monocromo.svg` es para los íconos temáticos; `notificacion.svg`, la silueta blanca de 24 dp.
- **Favicon:** `favicon.svg`, con esquinas más redondas para 16 px.

## Tamaño y aire

- Logotipo: al menos 64 px de ancho; la versión en trama, 240 px. En la barra de la app, 22 px de alto de «l».
- Espacio libre: la altura de la «o» por todos lados.

## No

- Con mayúscula inicial: el logotipo es «relevo»; en el texto se escribe «Relevo».
- Letras en azul o renglón en un color que no sea azul, tinta, blanco o el de la categoría de la pieza.
- Renglón separado, punteado (salvo la versión en trama), más fino o sin la parte que pasa la «o» (salvo la compacta).
- Estirado, inclinado, con sombra, contorneado o sobre una foto o trama sin tarjeta.
- El símbolo junto al logotipo, o el logotipo dentro de una frase.

## Historia

El grupo de recursos Logotipo 3.0 guarda la versión anterior (Schibsted Grotesk 650 con un rectángulo del ancho de la palabra). Es histórica: no se usa en piezas nuevas.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** sección nueva del logotipo 3.1: idea, construcción, exploración, versiones, firmas, símbolo e íconos.
- **Cómo estaba antes:** la sección 03-logotipo.md de 3.0 describía el logotipo en 650 con un rectángulo del ancho de la palabra.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
