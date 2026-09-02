# Códigos cromáticos de Relevo

## Principio

El color organiza funciones; no decora estados. La paleta se sostiene sobre neutros de alto contraste y reserva un único rojo para la señal situada. Así, una aparición cromática excepcional corresponde a un acontecimiento excepcional del sistema.

## Aplicación Android: modo oscuro (por defecto)

| Aplicación | HEX | RGB | Función |
|---|---|---|---|
| Canvas | `#111314` | 17, 19, 20 | Fondo general |
| Superficie funcional | `#1B1D1E` | 27, 29, 30 | Agrupación que necesita límite propio |
| Superficie secundaria | `#242728` | 36, 39, 40 | Estado o agrupación subordinada |
| Texto principal | `#F1F1F1` | 241, 241, 241 | Títulos, valores y acciones |
| Texto secundario | `#B6B8B7` | 182, 184, 183 | Explicaciones y metadatos legibles |
| Regla | `#3A3D3E` | 58, 61, 62 | Separación estructural no interactiva |
| Borde funcional | `#767A79` | 118, 122, 121 | Controles y límites necesarios |
| Señal situada | `#D71921` | 215, 25, 33 | Únicamente el nodo de señal situada |

## Editorial (claro)

| Aplicación | HEX | RGB | Función |
|---|---|---|---|
| Papel cálido | `#F4F2ED` | 244, 242, 237 | Campo editorial principal |
| Tinta | `#181A1B` | 24, 26, 27 | Texto y estructura principal |
| Texto secundario | `#616566` | 97, 101, 102 | Notas, folios y jerarquía secundaria |
| Regla clara | `#C9CBC8` | 201, 203, 200 | Retícula visible y divisiones |
| Señal situada | `#D71921` | 215, 25, 33 | Nodo informativo excepcional, nunca adorno |

Android y editorial comparten roles, no fondos. La aplicación necesita continuidad oscura; la memoria necesita lectura prolongada, impresión controlable y espacio para imágenes, tablas y citas. Copiar la misma superficie entre soportes debilitaría sus funciones.

## Regla del rojo

`#D71921` no identifica botones, vínculos, selección, navegación, batería, error, éxito, peligro, títulos ni elementos decorativos. Solo representa la señal ya situada o su explicación directa. Antes de ese acontecimiento, la interfaz permanece neutral.

El rojo no debe cargar texto pequeño en Android: su contraste sobre `#111314` es **3,59:1**, insuficiente para texto normal según WCAG 2.2. En cambio, puede emplearse como nodo gráfico grande acompañado de una etiqueta textual. Sobre el papel cálido alcanza **4,63:1**, pero se mantiene reservado y no sustituye jerarquías tipográficas.

## Contrastes comprobados

| Combinación | Relación | Uso |
|---|---:|---|
| `#F1F1F1` / `#111314` | 16,50:1 | Texto principal Android |
| `#B6B8B7` / `#111314` | 9,34:1 | Texto secundario Android |
| `#767A79` / `#111314` | 4,29:1 | Bordes e iconos funcionales |
| `#181A1B` / `#F4F2ED` | 15,61:1 | Texto principal editorial |
| `#616566` / `#F4F2ED` | 5,27:1 | Texto secundario editorial |
| `#D71921` / `#F4F2ED` | 4,63:1 | Nodo o texto excepcional en gran formato |

WCAG 2.2 establece 4,5:1 como contraste mínimo para texto normal y 3:1 para texto grande y componentes gráficos necesarios. Los valores calculados orientan la especificación, pero deben volver a verificarse en implementación, brillo real e impresión.

## Producción impresa

Los valores CMYK no se fijan todavía como equivalencias universales. La conversión depende del perfil ICC, el papel, la tinta y el sistema de impresión. Para la memoria se debe realizar una prueba de color con el perfil de la imprenta y registrar la conversión aprobada; inventar porcentajes CMYK sin esas condiciones produciría una precisión falsa.

## Referencias

Norman, D. A. (2013). *The design of everyday things* (Rev. and expanded ed.). Basic Books.

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Contrato cromático consolidado

- **Cambio:** se reunieron las paletas Android y editorial, sus roles, restricciones y contrastes calculados.
- **Situación anterior:** los valores estaban distribuidos entre el manual visual, los tokens y documentos Android.
- **Motivo:** disponer de una fuente breve para diseño, implementación y revisión.
- **Decisión corregida:** el rojo vigente es `#D71921`; `#EF3E45` queda como antecedente y no debe utilizarse en piezas nuevas.
- **Pendiente de producción:** fijar CMYK solo después de una prueba con perfil ICC y papel reales.
