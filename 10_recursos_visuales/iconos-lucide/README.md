# Íconos de Relevo desde Lucide

Fuente de los 118 íconos de la app desde la 4.8 (D-187). El fundamento y cada elección están en el [documento 46](../46_iconos-desde-lucide-2026-11-22.md).

## Qué hay

- **[`mapeo.json`](mapeo.json):** de dónde sale cada ícono de la app y, si hace falta, por qué. Cada ícono tiene un origen:
  - `lucide`: el de Lucide tal cual; son 109.
  - `adaptado`: uno de Lucide con una pieza cambiada; son 6.
  - `propio`: un dibujo con las reglas de Lucide, porque Lucide no tiene ese objeto; son 3.
- **[`lucide/`](lucide):** los 108 SVG de Lucide 1.70.0 que usa la app, copiados sin cambios del paquete [`lucide-static`](https://www.npmjs.com/package/lucide-static/v/1.70.0). Son 108 para 109 íconos, porque la estrella llena y la vacía comparten el dibujo.
- **[`propios/`](propios):** los nueve adaptados o propios, dibujados con la [guía](https://lucide.dev/contribute/icons/design-principles), la [especificación](https://lucide.dev/contribute/icons/specification) y las [convenciones de SVG](https://lucide.dev/contribute/icons/code-conventions) de Lucide. El comentario de cada SVG dice de dónde sale. Las reglas, resumidas, están en el [documento 46](../46_iconos-desde-lucide-2026-11-22.md#cómo-funcionan-los-íconos-de-lucide).
- **[`propuestas/`](propuestas):** bocetos que todavía no están en la app y esperan la elección del autor: una pelota de fútbol, un ovillo, una parrilla y un volantín, con su [hoja de revisión](propuestas/propuestas-2026-11-22.png). Su fundamento está en el [documento 46](../46_iconos-desde-lucide-2026-11-22.md#más-íconos-propuestas). El generador no los lee mientras no tengan una entrada en el mapeo.
- **[`generar_kiticons.py`](generar_kiticons.py):** escribe `KitIcons.kt`, el archivo de íconos de la app, desde el mapeo y los SVG.
- **[`verificar_reglas.py`](verificar_reglas.py):** comprueba las reglas medibles de Lucide en los nueve adaptados o propios: el trazo a 1 o más del borde y 2 o más de aire entre elementos distintos. Las piezas que el dibujo une, como los brazos de una cruz, se declaran en el mapeo como `uniones`. También cuenta los números que quedan fuera de la retícula. Necesita Python con numpy, y termina con error si un ícono no cumple.
- **[`medir_tamano_optico.js`](medir_tamano_optico.js):** la prueba del desenfoque. Mide la mancha de cada ícono adaptado o propio y la compara con la de los íconos de Lucide de la app. Necesita Node y Playwright.
- **[`LICENSE`](LICENSE):** la licencia de Lucide, ISC, con la MIT de los íconos que vienen de Feather. Hay que conservarla con los SVG.
- **Imágenes para revisar:**
  - [los 118 íconos](set-completo.png);
  - [antes y después](antes-y-despues.png), a 32 px y dentro de un anillo de 40 px;
  - [los nueve propios y adaptados junto a su referente de Lucide](propios-junto-a-lucide.png);
  - [de la 4.8.1 a la 4.8.2](tamano-optico.png): los cinco que cambiaron, desenfocados junto al círculo y el cuadrado de Lucide y entre sus vecinos.

## Cómo cambiar un ícono

1. Elegir otro ícono de Lucide y copiar su SVG a `lucide/`, o dibujar uno en `propios/` con las reglas de Lucide. Si una pieza ya existe en Lucide, se toma igual, sin cambiar su forma ni su orientación.
2. Cambiar su entrada en `mapeo.json`, con una nota si la elección no es obvia.
3. Si es adaptado o propio, desde la raíz del repositorio:
   - comprobar las reglas con `python3 10_recursos_visuales/iconos-lucide/verificar_reglas.py`;
   - medir su tamaño óptico con `node 10_recursos_visuales/iconos-lucide/medir_tamano_optico.js`: su mancha debe parecerse a la de su equivalente en Lucide y quedar cerca de la mitad central de los íconos de la app. Si se ve chico, se redibuja para que gane peso, sin bajar de 2 el aire entre elementos, que en Lucide es obligatorio.
4. Correr `python3 10_recursos_visuales/iconos-lucide/generar_kiticons.py`.
5. Compilar la app y correr sus pruebas: `KitIconsTest` comprueba que Android lea cada trazado y que ningún ícono repita el dibujo de otro.

Para agregar un ícono nuevo, primero se suma a `KitIcons.kt` con su nombre y su palabra, y después se le da una entrada en el mapeo. El generador conserva el orden y las palabras de `KitIcons.kt`, y avisa si el mapeo no calza.

## Registro de cambios (disclaimer)

### 2026-11-22 — Propuestas

- **Qué cambió:** se suma la carpeta `propuestas/`, con cuatro bocetos y su hoja de revisión.
- **Cómo estaba antes:** la carpeta tenía solo los íconos que usa la app.
- **Por qué:** el autor preguntó si quedaban íconos por hacer y propuso sumar cosas cotidianas de Chile.

### 2026-11-22 — Reglas de Lucide

- **Qué cambió:** se suma `verificar_reglas.py`, que comprueba el margen y el aire de los íconos adaptados y propios, y el paso para correrlo. Si un ícono se ve chico, ahora se redibuja sin bajar de 2 el aire. La hoja del tamaño muestra el paso de la 4.8.1 a la 4.8.2.
- **Cómo estaba antes:** si un ícono se veía chico, se agrandaba a la vista aunque perdiera algo de la regla de los 2 de aire, y no había un script que la comprobara.
- **Por qué:** el autor pidió perfeccionar los íconos y estudiar cómo funcionan los de Lucide, cuya guía marca esos 2 de aire como obligatorios.

### 2026-11-22 — Tamaño óptico

- **Qué cambió:** se suman la prueba del desenfoque (`medir_tamano_optico.js`), su hoja y un paso para medir el tamaño de cada ícono adaptado o propio. El primer paso pasa a ser una huella adaptada: quedan seis adaptados y tres propios.
- **Cómo estaba antes:** había cinco adaptados y cuatro propios, y el tamaño se cuidaba solo con las medidas de la especificación de Lucide.
- **Por qué:** el autor pidió que el tamaño fuera óptico, no matemático, y que el primer paso no fuera una escalera.

### 2026-11-22 — Creación

- **Qué cambió:** se creó la carpeta con el mapeo, los SVG de Lucide y los propios, el generador, la licencia y las imágenes para revisar.
- **Cómo estaba antes:** los íconos se dibujaban a mano en `KitIcons.kt`, con su SVG en el kit de [`marca-a-tiempo/iconos`](../marca-a-tiempo/iconos).
- **Por qué:** el autor propuso usar los íconos de Lucide y dibujar solo lo que Lucide no tiene (D-187).
