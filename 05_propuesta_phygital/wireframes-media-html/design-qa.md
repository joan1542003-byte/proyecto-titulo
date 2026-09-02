# Auditoría vigente de los wireframes HTML

## Muestra revisada

Se inspeccionaron visualmente tres casos con funciones distintas:

- `1.1 Formular`: campos y acción principal;
- `3.2 Recibir el pulso situado`: relación phygital fuera de la pantalla;
- `20 Armado en espera`: estado, continuidad y salida.

También se ejecutó la auditoría automatizada sobre navegación, dimensiones, exportaciones, consola y ausencia de simulación de teléfono.

## Resultados

| Control | Resultado |
|---|---|
| Lienzo CSS | 920 × 1150 px |
| PNG exportado | 1840 × 2300 px |
| Ruta principal | 9 vistas |
| Cobertura | 35 vistas |
| Simulación de teléfono | Ausente |
| Idioma del documento | Español |
| Color de identidad | Ausente |
| Botón de descarga dentro del PNG | Ausente |
| Navegación siguiente | Aprobada |
| Cambio a cobertura | Aprobado |
| Desborde horizontal | No detectado |
| Errores de consola | 0 |
| Build TypeScript y producción | Aprobado |

## Auditoría de diseño

- La presentación distingue con claridad catálogo, wireframe y fundamento.
- La escala de grises evita adelantar códigos cromáticos del sistema visual final.
- No se utilizan sombras, texturas, fotografías, degradados ni marcos de hardware.
- Los componentes declaran su función mediante etiquetas simples.
- La acción primaria conserva mayor peso que las alternativas.
- El momento físico utiliza otra convención de borde y un diagrama contextual.
- La leyenda registra objetivo, jerarquía y error o salida en cada PNG.
- La cobertura muestra continuidades sin convertirlas en una cuarta interacción.

## Límites que permanecen

La aprobación corresponde a estructura, presentación y exportación. No equivale a validar la experiencia, la accesibilidad de la futura aplicación, la percepción del pulso, el comportamiento técnico o la eficacia de Relevo.

**Resultado final de esta auditoría: aprobado.**

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Auditoría posterior a la eliminación del runtime móvil

- **Cambio:** se reemplazó la auditoría basada en un viewport de teléfono por controles sobre el tablero editorial y el lienzo exportable.
- **Versión anterior:** la QA comprobaba pantalla móvil, ficha desplegable y ocultamiento posterior del cromo.
- **Motivo:** alinear las pruebas con la nueva presentación sin simulación de dispositivo.
- **Evidencia:** `scripts/qa-wireframes.mjs` y las 44 imágenes de `public/exports/`.
