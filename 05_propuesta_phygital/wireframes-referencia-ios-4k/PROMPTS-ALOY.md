# Registro de generación — ALOY

## Propósito

Este documento registra la generación, corrección y auditoría de las cuatro láminas nuevas de referencia visual para los estados 15–24 del Encargo 17. Las imágenes sirven para calcar y discutir en Figma; no son una interfaz final ni sustituyen los wireframes estructurales editables.

**Fecha:** 25 de agosto de 2026  
**Generador:** built-in `image_gen`  
**Referencia visual obligatoria:** [`A2-configuracion-ios-4k.png`](A2-configuracion-ios-4k.png)  
**Contrato visual preservado:** [`STYLE-CONTRACT.md`](STYLE-CONTRACT.md)  
**Base conceptual:** [`memoria-vigente-v2.md`](../../08_memoria/memoria-vigente-v2.md), [`encargo-17-requisitos.md`](../../01_contexto_y_fuentes/encargo-17-requisitos.md) y [`anexo-cobertura-interacciones-encargo-17.md`](anexo-cobertura-interacciones-encargo-17.md).

## Criterio global utilizado

Se pidió una lámina horizontal de 3840 × 2160 px, 16:9, con dos o tres wireframes o paneles grandes, completos y fáciles de reconstruir. La dirección visual mantiene el lenguaje de A2: fondo blanco cálido, retícula tenue, superficies agrupadas, bordes cálidos, radios suaves, tipografía sans serif de sistema, jerarquía sobria y escala de grises.

La referencia visual se interpretó como un sistema compositivo contemporáneo e iOS-inspired original. No se imitó una interfaz de Android ni se incorporaron barras del sistema, menús de ajustes, botones Android, logotipos o marcos de dispositivo.

El contrato conceptual aplicado a todas las láminas fue:

- una intención propia;
- un primer paso concreto;
- una condición observable provisional;
- una vigencia;
- un testigo físico situado;
- un pulso ambiental posterior.

La aplicación conserva significado y comunica estados técnicos. El testigo físico no contiene pantalla, texto, menú, historial ni puntuación. Relevo no bloquea, no vigila, no infiere estados subjetivos, no registra cumplimiento y no rearma automáticamente.

## Prompt común

```text
Use case: ui-mockup or infographic-diagram.
Asset type: 4K landscape wireframe reference sheet for Relevo, a phygital Design graduation project.
Input images: Image 1 is the mandatory A2 Relevo iOS 4K visual reference only. Match its warm-white canvas, faint warm grid, flat rounded surfaces, grouped cards, calm contemporary iOS-inspired hierarchy, restrained grayscale, thin warm-gray borders, generous spacing, soft neutral shadows, and system-like sans-serif typography. Create a new composition; do not copy the reference screens.
Style/medium: original contemporary minimal product-design reference, low-to-medium fidelity, intended for tracing in Figma, not final UI and not concept art.
Color palette: #FCFBF8, #FFFFFF, #F1EEE9, #D8D4CE, #262522, #6D6A65 only.
Constraints: Spanish text must be rendered verbatim and legibly; exact state labels; no logo or watermark; no saturated colors; no gradients; no Android system UI; no iPhone device frame; no blocking, scoring, streaks, compliance tracking, surveillance, subjective inference, automatic re-arm, or screen/text on the physical token.
Output intent: a clean 16:9 landscape sheet with two or three large, complete, aligned and traceable states.
```

La instrucción de 3840 × 2160 se incluyó en cada llamada. El built-in produjo salidas nativas de 1672 × 941 px; por ello se realizó una normalización posterior proporcional, descrita en la sección técnica.

## Prompts específicos y estados cubiertos

### C1 — `C1-armado-ios-4k.png`

Se generaron tres superficies móviles alineadas para:

1. **15 · Armando** — título `Armando el ciclo`; vínculo del testigo en curso; condición provisional por validar; vigencia visible; estado `Esperando confirmación`; acción `Cancelar`.
2. **16 · Armado** — ciclo activo; intención `Leer un capítulo`; primer paso `Abrir el libro`; condición provisional en espera; testigo situado; acción `Desarmar`.
3. **17 · Armado no confirmado** — vínculo no confirmado; acciones `Reintentar`, `Revisar enlace` y `Desarmar`; sin culpar a la persona ni declarar que el ciclo está activo.

La instrucción crítica fue separar confirmación técnica de cumplimiento personal. El estado 17 se describió como incertidumbre del vínculo, no como error de usuario.

### C2 — `C2-armado-ios-4k.png`

Se generaron dos superficies móviles alineadas para:

1. **18 · Desarmado voluntario** — estado detenido, sin pulso posterior; acciones `Preparar de nuevo` y `Cerrar ciclo`; la salida se muestra como decisión válida.
2. **19 · Editar ciclo armado** — aviso `El ciclo está armado`; la edición requiere desarmar primero; acciones `Desarmar y editar` y `Conservar ciclo`; la transición es reversible y no se representa como bloqueo.

### D1 — `D1-espera-ios-4k.png`

Se generaron tres superficies móviles alineadas para:

1. **20 · Armado en espera** — intención, primer paso, condición provisional, vigencia, testigo situado y acción `Desarmar`.
2. **21 · Condición cumplida** — condición reconocida y orden vigente; estado `Enviando la orden al testigo`; no se declara que la intención fue realizada ni que la entrega física ya fue confirmada.
3. **22 · Orden expirada** — la vigencia terminó antes de una entrega válida; se explicita `No se emitirá un pulso tardío`; acciones `Cerrar ciclo` y `Preparar de nuevo`.

La primera salida D1 omitió el nombre `RELEVO` en la navegación superior. Se revisó visualmente y se realizó una edición focalizada que añadió `RELEVO` a las tres superficies sin alterar la arquitectura, los estados ni el contenido. La versión corregida es la utilizada como archivo final.

### D2 — `D2-senal-ios-4k.png`

Se construyeron dos paneles diagramáticos, porque estos estados dejan de ser una pantalla móvil:

1. **23 · Señal física activa** — escena situada con mesa, libro abierto y un testigo físico sin pantalla, texto, botón ni teléfono; el pulso ambiental se muestra mediante anillos monocromos; el primer paso se rotula `Abrir el libro`.
2. **24 · Respuesta libre** — diagrama de tres ramas con igual peso visual: `Iniciar el primer paso`, `Continuar` e `Ignorar o silenciar`; la nota `Ninguna respuesta se registra como cumplimiento` explicita la ausencia de registro móvil obligatorio.

El estado 23 no se convirtió en una pantalla del objeto. La escena conserva la relación phygital entre aplicación, lugar, testigo y decisión humana sin dibujar una interfaz de consulta.

## Corrección y normalización técnica

Las salidas nativas de `image_gen` fueron inspeccionadas antes de copiarlas al repositorio. Todas midieron 1672 × 941 px. Para obtener el formato solicitado sin deformar el contenido:

1. se creó un lienzo final de 3840 × 2160 px con fondo `#FCFBF8`;
2. cada salida se escaló proporcionalmente a 3838 × 2160 px mediante interpolación bicúbica de alta calidad;
3. se centró con un margen de un píxel a cada lado;
4. se guardó como PNG con el nombre final solicitado;
5. se verificaron las dimensiones del archivo final con lectura de imagen.

Esta operación no recortó pantallas, no estiró el contenido y no modificó las láminas A1, A2 ni las referencias A/B existentes.

## Auditoría final

| Criterio | Resultado |
| --- | --- |
| C1 contiene 15, 16 y 17 | Conforme |
| C2 contiene 18 y 19 | Conforme |
| D1 contiene 20, 21 y 22 | Conforme |
| D2 contiene 23 y 24 | Conforme |
| Dimensiones exactas de las cuatro salidas | 3840 × 2160 px |
| Relación 16:9 | Conforme |
| Fondo, retícula, radios, bordes y tipografía coherentes con A2 | Conforme |
| Texto en español y acentos revisados visualmente | Conforme |
| Baja/media fidelidad; fácil de calcar | Conforme |
| Sin barras, botones o ajustes Android | Conforme |
| Sin pantalla ni texto en el testigo físico | Conforme |
| Estado 23 como escena física situada | Conforme |
| Estado 24 como diagrama de respuestas equivalentes | Conforme |
| Sin bloqueo, puntuación, racha, vigilancia o cumplimiento | Conforme |
| Sin afirmación de acción realizada | Conforme |
| Sin rearme automático | Conforme |
| `STYLE-CONTRACT.md` modificado | No; preservado |

## Archivos finales

- [`C1-armado-ios-4k.png`](C1-armado-ios-4k.png)
- [`C2-armado-ios-4k.png`](C2-armado-ios-4k.png)
- [`D1-espera-ios-4k.png`](D1-espera-ios-4k.png)
- [`D2-senal-ios-4k.png`](D2-senal-ios-4k.png)

## Disclaimer y registro de cambios

**Archivo nuevo:** `PROMPTS-ALOY.md` se creó para registrar la generación y auditoría de las cuatro láminas nuevas.

**Archivos nuevos:** se añadieron `C1-armado-ios-4k.png`, `C2-armado-ios-4k.png`, `D1-espera-ios-4k.png` y `D2-senal-ios-4k.png`. No reemplazan las láminas A1, A2 ni las referencias A/B existentes.

**Corrección aplicada:** D1 tuvo una edición focalizada para añadir `RELEVO` en la navegación superior y hacer consistente la serie. No se modificó el significado de los estados 20–22.

**Corrección posterior:** en el estado 21 de D1 se reemplazó únicamente `Enviando el patrón al testigo` por `Enviando la orden al testigo`. Se conservaron la composición, los estados 20–22, la navegación, los iconos, los botones, la paleta y el resto del texto. La imagen fue inspeccionada y conservada en 3840 × 2160 px. No se hizo commit ni push.

**Decisión:** D2 utiliza una escena física y un diagrama porque los estados 23–24 no deben representarse como una pantalla del testigo ni como un registro móvil obligatorio.

**Límites:** estas imágenes son referencias visuales generadas para calcar y revisar. No validan percepción, atribución, eficacia, accesibilidad, convivencia, Android/BLE, producción ni el aporte del objeto frente a una notificación.
