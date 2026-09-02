# Wireframes HTML de Relevo

## Resultado vigente

El tablero reúne los nueve wireframes de la ruta principal y 35 estados complementarios. Su interfaz de revisión separa tres capas: catálogo, wireframe y fundamento. La navegación, la explicación y la descarga permanecen fuera del área exportable para no confundirse con funciones de Relevo.

Cada wireframe usa una ventana representativa de Android de **412 × 915 dp** y se exporta a **824 × 1830 px**. Esta medida no se presenta como un promedio estadístico ni como un modelo de teléfono específico: es una base de trabajo contemporánea para revisar jerarquía, alcance táctil y distribución vertical. No se dibuja hardware, barra de estado ni navegación del sistema.

## Criterios de representación

- Retícula de 8 dp y margen interior de 24 dp.
- Controles representados con un mínimo de 48 dp.
- IBM Plex Sans para lectura e IBM Plex Mono para identificadores técnicos.
- Fondo `#111314`, superficies `#1B1D1E`, texto principal `#F1F1F1` y texto secundario `#B6B8B7`.
- El rojo `#D71921` se reserva para la señal situada; no identifica botones, errores ni decoración.
- Sin sombras, degradados, texturas ni recursos que alteren la lectura estructural.

Aunque corresponde a baja fidelidad, la composición utiliza el sistema visual de Relevo para mantener consistencia. Esto no convierte los wireframes en una interfaz validada ni en el diseño definitivo de Android.

## Uso

El tablero permite cambiar entre ruta principal y cobertura, revisar la justificación de cada marco y descargar cada PNG por separado. Los archivos están en [`public/exports`](public/exports/). La fuente de contenido está en [`src/wireframes.ts`](src/wireframes.ts), la presentación en [`src/Prototype.tsx`](src/Prototype.tsx) y la especificación en [`DECISIONES-DE-DISENO.md`](DECISIONES-DE-DISENO.md).

## Verificación vigente

- 44 vistas exportadas a 824 × 1830 px.
- Sin simulación de teléfono ni controles del tablero en los PNG.
- Sin desborde interno en las 44 vistas.
- Navegación, cambio de conjunto y descarga aprobados.
- Tablero revisado a 1366, 1536 y 1920 px de ancho.
- Compilación y auditoría automatizada aprobadas; errores de consola: 0.

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Ajuste a ventana Android representativa

- **Cambio:** el lienzo 4:5 de 920 × 1150 px se sustituyó por una ventana de 412 × 915 dp, exportada al doble de densidad.
- **Antes:** la lámina priorizaba comparación editorial, pero no conservaba proporciones propias de una pantalla móvil.
- **Motivo:** permitir que cada exportable pueda reconstruirse como pantalla Android sin simular un dispositivo ni atribuirle un modelo específico.
