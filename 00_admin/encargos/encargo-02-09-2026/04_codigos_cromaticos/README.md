# Códigos cromáticos de Relevo

**Estado:** registro histórico de la entrega del 2 de septiembre de 2026. Esta paleta documenta lo presentado en esa fecha y no gobierna piezas nuevas. El color volvió a abrirse como decisión dentro de la [investigación visual vigente](../../../../10_recursos_visuales/README.md).

## Principio

El color diferencia funciones y estados. La paleta utiliza neutros de alto contraste y reserva el rojo para la aparición de la señal situada. De esta manera, un acontecimiento excepcional del sistema recibe también un tratamiento cromático excepcional.

## Aplicación: modo oscuro

| Color | Código | Función |
|---|---|---|
| Fondo general | `#111314` | Superficie principal de la aplicación. |
| Superficie funcional | `#1B1D1E` | Agrupaciones que necesitan un límite propio. |
| Superficie secundaria | `#242728` | Estados o contenidos subordinados. |
| Texto principal | `#F1F1F1` | Títulos, valores y acciones. |
| Texto secundario | `#B6B8B7` | Explicaciones y metadatos. |
| Regla | `#3A3D3E` | Separaciones no interactivas. |
| Borde funcional | `#767A79` | Límites e iconos necesarios. |
| Señal situada | `#D71921` | Nodo que representa la señal ya situada. |

## Memoria: modo claro

| Color | Código | Función |
|---|---|---|
| Papel cálido | `#F4F2ED` | Campo editorial principal. |
| Tinta | `#181A1B` | Texto y estructura principal. |
| Texto secundario | `#616566` | Notas, folios y jerarquía secundaria. |
| Regla clara | `#C9CBC8` | Retícula y divisiones. |
| Señal situada | `#D71921` | Nodo informativo excepcional. |

## Regla del rojo

El rojo `#D71921` no se utiliza para botones, navegación, títulos, errores, éxito, batería ni decoración. Aparece únicamente cuando se representa la señal situada o cuando se explica directamente ese acontecimiento. Antes de ese momento, la interfaz permanece neutral.

## Contraste

| Combinación | Relación |
|---|---:|
| `#F1F1F1` sobre `#111314` | 16,50:1 |
| `#B6B8B7` sobre `#111314` | 9,34:1 |
| `#767A79` sobre `#111314` | 4,29:1 |
| `#181A1B` sobre `#F4F2ED` | 15,61:1 |
| `#616566` sobre `#F4F2ED` | 5,27:1 |
| `#D71921` sobre `#F4F2ED` | 4,63:1 |

WCAG 2.2 establece una relación mínima de 4,5:1 para texto normal y de 3:1 para texto grande y componentes gráficos necesarios. El rojo sobre el fondo oscuro alcanza 3,59:1, por lo que no debe utilizarse como texto pequeño; funciona como nodo gráfico acompañado por una etiqueta legible.

## Producción impresa

Los valores CMYK se definirán después de una prueba con el perfil ICC, el papel y el sistema de impresión reales. Establecerlos sin esas condiciones produciría una equivalencia imprecisa.

## Referencia

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

---

## Registro de cambios (disclaimer)

### 2026-09-11 — Paleta reclasificada como histórica

- **Qué cambió:** la paleta permanece como evidencia de la entrega, pero ya no deriva hacia una segunda dirección obsoleta.
- **Cómo estaba antes:** remitía a una paleta posterior como regla para piezas nuevas.
- **Por qué se decidió:** el color volvió a abrirse y se evaluará por roles, contraste y pruebas en soporte.

### 2026-09-02 — Incorporación a la entrega

- **Qué cambió:** las paletas digital y editorial, sus funciones y restricciones quedaron reunidas dentro del encargo.
- **Cómo estaba antes:** estos criterios estaban distribuidos entre el manual visual y una carpeta transversal de entregables.
- **Decisión para esta entrega:** `#D71921` fue el único rojo del sistema presentado el 2 de septiembre; hoy queda como registro histórico.
- **Por qué se decidió:** facilitar la aplicación y revisión consistente del color en cada soporte.

### 2026-09-08 — Vigencia temporal aclarada

- **Qué cambió:** se identificó la paleta como decisión de la entrega fechada y se enlazó la autoridad cromática actual.
- **Cómo estaba antes:** el documento seguía llamando vigente al rojo aun después de su sustitución.
- **Por qué se decidió:** conservar la entrega sin permitir que gobierne piezas posteriores.
- **Alcance:** los valores y cálculos originales no se modificaron retrospectivamente.
