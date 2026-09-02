# Auditoría de A1 · Configuración 4K

## Alcance

Esta intervención corrige exclusivamente la copia del estado 03, `Permiso requerido`, en `A1-configuracion-4k.png`. La lámina A2 se utilizó como referencia visual para conservar composición, jerarquía, paleta y tratamiento de estados técnicos. No se modificó A2 ni se produjeron otras láminas.

## Fuentes revisadas

- `08_memoria/memoria-vigente-v2.md`.
- `01_contexto_y_fuentes/encargo-17-requisitos.md`.
- `05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md`.
- `05_propuesta_phygital/wireframes-referencia-4k/contrato-visual.md`.
- `A2-configuracion-4k.png`, como referencia visual.

La revisión conceptual confirma que Android solo configura, informa estados técnicos y facilita la recuperación del ciclo. El permiso no se presenta como juicio sobre la persona; el testigo físico no incorpora pantalla, texto ni interfaz de consulta.

## Prompt utilizado

```text
Use case: text-localization.
Asset type: Relevo Encargo 17 low/medium-fidelity wireframe reference sheet.
Input images: Image 1: EDIT TARGET, A1-configuracion-4k.png. Image 2: STYLE REFERENCE ONLY, A2-configuracion-4k.png.
Primary request: Correct only the copy in screen 03, the rightmost mobile wireframe titled “03 · PERMISO REQUERIDO”. Replace the entire explanatory paragraph under “Permiso requerido” with this exact Spanish sentence, rendered verbatim and legibly: “Relevo necesita consultar el estado de uso de la aplicación elegida para observar la condición provisional durante el ciclo”.
Important text constraint: the obsolete malformed wording must not appear anywhere in the result. Use “observar” exactly once in the corrected paragraph.
Constraints: change only the state 03 explanatory paragraph; keep all other text, screens 01 and 02, layout, composition, dimensions, backgrounds, warm neutral palette, grouped cards, typography, icons, progress dots, borders, spacing, shadows, and hierarchy unchanged. Use Image 2 only to preserve the established visual language. Do not add Android system bars, Android settings UI, a testigo screen, blocking, compliance, scoring, tracking, subjective inference, or automatic rearming.
```

## Auditoría visual y conceptual

| Criterio | Resultado |
| --- | --- |
| Texto exacto del estado 03 | Conforme: `Relevo necesita consultar el estado de uso de la aplicación elegida para observar la condición provisional durante el ciclo`. |
| Residuo de la copia anterior | No aparece en la imagen final. |
| Estado 03 | Mantiene permiso pendiente, estado técnico no punitivo y acciones de recuperación. |
| Estados 01–02 | Conservados como referencias de la misma lámina. |
| Composición | Tres wireframes completos, misma lectura de configuración y misma jerarquía general. |
| Estilo | Minimalista contemporáneo, tarjetas agrupadas, fondo cálido, escala acromática y tipografía sobria. |
| Encargo 17 | Compatible como referencia visual de baja/media fidelidad; no sustituye el tablero estructural de Figma. |
| Memoria v2 | Compatible con phygitalidad, autonomía, permiso técnico limitado y ausencia de evaluación conductual. |
| Testigo físico | No se representa con pantalla, texto ni controles móviles. |

## Resolución

- Salida original: `1672 × 941 px`.
- Normalización: ampliación proporcional con ajuste a lienzo 16:9 y fondo `#FCFBF8`, sin estirar ni recortar el contenido.
- Archivo final: `A1-configuracion-4k.png`.
- Resolución final verificada: `3840 × 2160 px`.
- Método: edición localizada y normalización posterior para cumplir el formato final.

## Disclaimer de cambios

### 2026-09-02 — Normalización del nombre y del registro

- **Cambio:** se eliminó la referencia a una plataforma del nombre de la carpeta y de los archivos, y se retiró el identificador de colaboración del encabezado.
- **Cómo estaba antes:** el título y las referencias utilizaban “iOS” y un nombre de trabajo, aunque la lámina solo cumple una función de referencia compositiva.
- **Motivo:** evitar confundir una referencia estética con la decisión técnica del proyecto y ordenar el registro por función, sin modificar la corrección ni la imagen.

Antes, el estado 03 contenía una variante textual incorrecta. Ahora utiliza `observar la condición provisional durante el ciclo`, porque esa formulación describe el alcance técnico sin convertir el permiso en una promesa de detección subjetiva. No se modificaron A2, el tablero de E17, la memoria ni otros archivos visuales.
