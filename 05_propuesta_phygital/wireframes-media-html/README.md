# Wireframes HTML de Relevo

## Resultado vigente

El tablero reúne los nueve wireframes de la ruta principal y 35 estados complementarios. Su interfaz de revisión separa tres capas: catálogo, wireframe y fundamento. La navegación, la explicación y la descarga permanecen fuera del área exportable para no confundirse con funciones de Relevo.

Cada wireframe usa una ventana representativa de Android de **412 × 915 dp** y se exporta a **824 × 1830 px**. Esta medida no se presenta como un promedio estadístico ni como un modelo de teléfono específico: es una base de trabajo contemporánea para revisar jerarquía, alcance táctil y distribución vertical. No se dibuja hardware, barra de estado ni navegación del sistema.

El entorno de revisión puede conservar recursos auxiliares de marco y teclado para comprobar el comportamiento del tablero. Esos elementos pertenecen a la herramienta de revisión: no forman parte de Relevo, no aparecen en los PNG exportados y no agregan una decisión de plataforma al proyecto.

## Criterios de representación

- Retícula de 8 dp y margen interior de 24 dp.
- Controles representados con un mínimo de 48 dp.
- IBM Plex Sans para lectura e IBM Plex Mono para identificadores técnicos.
- Fondo `#111314`, superficies `#1B1D1E`, texto principal `#F1F1F1` y texto secundario `#B6B8B7`.
- El rojo `#D71921` se reserva para la señal situada; no identifica botones, errores ni decoración.
- Sin sombras, degradados, texturas ni recursos que alteren la lectura estructural.

Los 35 estados de cobertura se mantienen en baja fidelidad. Las nueve pantallas principales avanzan a fidelidad media: muestran la jerarquía, la tipografía, el contraste y la distinción entre controles y contenido, pero siguen abiertas a corrección. Esta diferencia no convierte la interfaz en una propuesta validada ni en el diseño definitivo de Android.

## Uso

El tablero permite cambiar entre ruta principal y cobertura, revisar la justificación de cada marco y descargar cada PNG por separado. Los archivos están en [`public/exports`](public/exports/) y los tres mapas en [`public/exports/maps`](public/exports/maps/). La fuente de contenido está en [`src/wireframes.ts`](src/wireframes.ts), la presentación en [`src/Prototype.tsx`](src/Prototype.tsx) y la especificación en [`decisiones-de-diseno.md`](decisiones-de-diseno.md).

## Verificación vigente

- 44 vistas exportadas a 824 × 1830 px.
- Sin simulación de teléfono ni controles del tablero en los PNG.
- Sin desborde interno en las 44 vistas.
- Navegación, cambio de conjunto y descarga aprobados.
- Tablero revisado a 1366, 1536 y 1920 px de ancho.
- Compilación y auditoría automatizada aprobadas; errores de consola: 0.

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Desarrollo visual de la ruta principal

- **Cambio:** las nueve pantallas principales se reconstruyeron con el sistema oscuro de Relevo y se incorporaron tres mapas exportables.
- **Antes:** los marcos principales funcionaban como esquemas estructurales y el mapa completo reducía las vistas hasta dificultar su lectura.
- **Motivo:** elevar la calidad del recorrido principal y separar la arquitectura general, la secuencia legible y la cobertura técnica.
- **Alcance:** los estados complementarios permanecen en baja fidelidad y todo el conjunto requiere pruebas de interacción y accesibilidad.

### 2026-09-01 — Ajuste a ventana Android representativa

- **Cambio:** el lienzo 4:5 de 920 × 1150 px se sustituyó por una ventana de 412 × 915 dp, exportada al doble de densidad.
- **Antes:** la lámina priorizaba comparación editorial, pero no conservaba proporciones propias de una pantalla móvil.
- **Motivo:** permitir que cada exportable pueda reconstruirse como pantalla Android sin simular un dispositivo ni atribuirle un modelo específico.

### 2026-09-02 — Separación entre entorno de revisión y exportables

- **Qué cambió:** se aclaró que los recursos auxiliares que pueda usar el tablero para revisar dimensiones o teclado pertenecen a la herramienta y no a los wireframes exportados.
- **Cómo estaba antes:** el README explicaba que los PNG no tenían hardware, pero no distinguía esa condición del entorno de revisión.
- **Por qué se decidió:** evitar que una persona confunda el soporte técnico del tablero con una decisión visual o de plataforma de Relevo.
- **Alcance:** no se modificaron el runtime, las exportaciones, la cobertura ni las medidas de trabajo.
