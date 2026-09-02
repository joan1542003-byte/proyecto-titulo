# Wireframes HTML de Relevo

## Resultado vigente

Esta implementación convierte el Encargo 17 y su cobertura complementaria en un tablero HTML navegable. La presentación no simula un teléfono: separa el catálogo, el lienzo exportable y la fundamentación para que los controles de revisión no se confundan con funciones de Relevo.

El sistema contiene:

- nueve marcos de la ruta principal, organizados en tres interacciones;
- 35 estados de cobertura para permisos, fallos, salidas y recuperaciones;
- una URL independiente para cada marco;
- una exportación PNG individual de 1840 × 2300 px;
- un mapa general actualizado a partir de esas 44 imágenes.

## Cómo leer el tablero

1. **Catálogo:** permite elegir ruta principal o cobertura y abrir cualquier marco.
2. **Lienzo:** contiene únicamente la estructura del wireframe, su acción, objetivo, jerarquía y salida.
3. **Fundamento:** explica por qué existe cada elemento y qué continuidad debe conservar.

El botón `Exportar PNG` se encuentra fuera del lienzo. Por ello no aparece en la imagen descargada. Tampoco se exportan navegación, selector, anotaciones del tablero, barras del sistema operativo ni marcos de hardware.

## Criterio de fidelidad

La versión vigente utiliza media fidelidad estructural:

- escala de grises;
- tipografía utilitaria;
- campos, selectores, estados, acciones y alternativas reconocibles;
- contenido real del proyecto;
- proporciones y espaciado estables;
- ausencia de color de identidad, fotografías, texturas, degradados y sombras.

La composición facilita lectura y comparación, pero no constituye la interfaz visual final. El formato 4:5 pertenece a la lámina exportable y no representa las dimensiones de un teléfono.

## Coherencia phygital

- La aplicación organiza intención, primer paso, condición provisional, vigencia, lugar y vínculo.
- El testigo emite el pulso ambiental en el lugar relacionado con el primer paso.
- El marco 3.2 y el estado 23 son momentos físicos; se distinguen mediante borde discontinuo y un diagrama contextual.
- La señal no ordena una conducta y el sistema no registra cumplimiento.
- Ignorar, continuar, silenciar, cambiar de decisión y cerrar son salidas válidas.
- Condición, señal, gesto de armado y forma física permanecen sujetos a prueba.

## Archivos principales

- [`src/wireframes.ts`](src/wireframes.ts): fuente estructurada de 9 + 35 vistas.
- [`src/Prototype.tsx`](src/Prototype.tsx): tablero, lienzo y fundamento.
- [`src/prototype.css`](src/prototype.css): retícula, fidelidad y adaptación.
- [`DECISIONES-DE-DISENO.md`](DECISIONES-DE-DISENO.md): fundamento y método de verificación.
- [`COBERTURA.md`](COBERTURA.md): arquitectura completa del recorrido.
- [`public/exports`](public/exports/): 44 PNG individuales y manifiesto.
- [`scripts/export-wireframes.mjs`](scripts/export-wireframes.mjs): regeneración de exportaciones.
- [`scripts/qa-wireframes.mjs`](scripts/qa-wireframes.mjs): auditoría automatizada.
- [`design-qa.md`](design-qa.md): resultado de la revisión vigente.

## Verificación vigente

- compilación TypeScript y build de producción: aprobados;
- lienzo exportable: 920 × 1150 CSS px;
- PNG: 1840 × 2300 px;
- simulación de teléfono: ausente;
- ruta siguiente y cambio de conjunto: aprobados;
- 44 exportaciones y manifiesto: presentes;
- desborde horizontal: ausente;
- errores de consola: 0.

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Tablero HTML sin simulación de teléfono

- **Cambio:** se sustituyó el runtime de dispositivo por una mesa de trabajo con catálogo, lienzo exportable y fundamento.
- **Versión anterior:** los wireframes se recorrían dentro de una simulación móvil y las exportaciones dependían de ocultar su cromo.
- **Motivo:** distinguir con rigor las herramientas de presentación de las funciones del producto y permitir exportaciones limpias y comparables.
- **Alcance:** se conserva la arquitectura de nueve marcos y 35 estados; no se agregan funciones ni se acredita validación.
