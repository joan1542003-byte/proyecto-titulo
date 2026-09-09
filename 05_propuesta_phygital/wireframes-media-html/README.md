# Wireframes HTML de Relevo

## Resultado estructural vigente

El tablero reúne los nueve wireframes de la ruta principal y 35 estados complementarios. Su interfaz de revisión separa tres capas: catálogo, wireframe y fundamento. La navegación, la explicación y la descarga permanecen fuera del área exportable para no confundirse con funciones de Relevo.

La estructura, la cobertura y las medidas quedaron congeladas como wireframe v1 el 9 de septiembre. La base visual proviene del tablero construido el 2 de septiembre y su color de señal fue alineado con la [dirección actual de comunicación y color](../../10_recursos_visuales/comunicacion-naming-y-paleta-2026-09-07.md).

Cada wireframe usa una ventana representativa de Android de **412 × 915 dp** y se exporta a **824 × 1830 px**. Esta medida no se presenta como un promedio estadístico ni como un modelo de teléfono específico: es una base de trabajo contemporánea para revisar jerarquía, alcance táctil y distribución vertical. No se dibuja hardware, barra de estado ni navegación del sistema.

El entorno de revisión puede conservar recursos auxiliares de marco y teclado para comprobar el comportamiento del tablero. Esos elementos pertenecen a la herramienta de revisión: no forman parte de Relevo, no aparecen en los PNG exportados y no agregan una decisión de plataforma al proyecto.

## Criterios de representación

- Retícula de 8 dp y margen interior de 24 dp.
- Controles representados con un mínimo de 48 dp.
- IBM Plex Sans para lectura e IBM Plex Mono para identificadores técnicos.
- Fondo `#17191B`, superficies `#1F2326`, texto principal `#F4F1EA` y texto secundario `#AEB4B8`.
- El ámbar `#FFB000` se reserva para la señal situada; no identifica botones, errores ni decoración.
- Sin sombras, degradados, texturas ni recursos que alteren la lectura estructural.

Los 35 estados de cobertura se mantienen en baja fidelidad. Las nueve pantallas principales están en fidelidad media: muestran la jerarquía, la tipografía, el contraste y la distinción entre controles y contenido. Su estructura solo se reabre ante una prueba, un fallo de implementación o una contradicción verificable. Esta condición no convierte la interfaz en una propuesta validada ni en el diseño definitivo de Android.

## Uso

El tablero permite cambiar entre ruta principal y cobertura, revisar la justificación de cada marco y descargar cada PNG por separado. Los archivos están en [`public/exports`](public/exports/) y los tres mapas en [`public/exports/maps`](public/exports/maps/). La fuente de contenido está en [`src/wireframes.ts`](src/wireframes.ts), la presentación en [`src/Prototype.tsx`](src/Prototype.tsx) y la especificación en [`decisiones-de-diseno.md`](decisiones-de-diseno.md).

## Verificación vigente

- 44 vistas exportadas a 824 × 1830 px.
- Sin simulación de teléfono ni controles del tablero en los PNG.
- Sin desborde interno en las 44 vistas.
- Navegación, cambio de conjunto y descarga aprobados.
- Tablero revisado a 1366, 1536 y 1920 px de ancho.
- Compilación y auditoría automatizada aprobadas; errores de consola: 0.

## Reproducir la verificación

Con las dependencias instaladas, ejecutar `pnpm run build` y mantener `pnpm run dev` activo. En una segunda terminal de PowerShell:

```powershell
$env:RELEVO_PREVIEW_URL='http://127.0.0.1:5173'
pnpm run qa:wireframes
pnpm run test:sites
```

El control comprueba medidas, archivos exportados, navegación, adaptación del tablero, uso restringido del ámbar y ausencia de errores de consola. La auditoría necesita la vista local activa porque revisa el resultado renderizado, no solo el código fuente.

Si el navegador de Playwright no está instalado, la suite del runtime puede utilizar un Chromium local sin descargar otro binario. Antes de ejecutarla, se define `PLAYWRIGHT_CHROMIUM_EXECUTABLE_PATH` con la ruta absoluta de Chrome o Edge. La variable solo cambia el ejecutable de prueba; no modifica el tablero ni sus exportaciones.

---

## Registro de cambios (disclaimer)

### 2026-09-09 — Línea base congelada

- **Cambio:** los nueve marcos, las recuperaciones prioritarias y sus exportaciones quedan identificados como wireframe v1 para desarrollo.
- **Antes:** la versión estaba técnicamente verificada, pero seguía abierta a correcciones generales.
- **Motivo:** impedir que el prototipo Android se construya sobre una secuencia móvil.
- **Alcance:** los resultados y límites del cierre se documentan en [`cierre-wireframe-v1-2026-09-09.md`](../cierre-wireframe-v1-2026-09-09.md).

### 2026-09-09 — Color de señal alineado con la dirección vigente

- **Cambio:** los tokens base adoptan carbón, superficie, papel cálido y gris vigentes; la señal pasa de rojo `#D71921` a ámbar `#FFB000`.
- **Antes:** el tablero conservaba los códigos de la etapa v4 y remitía el ámbar a una reconstrucción posterior.
- **Motivo:** eliminar la contradicción con la dirección cromática adoptada el 7 de septiembre antes de congelar el wireframe v1.
- **Alcance:** cambia la codificación visual de la señal; no cambia el flujo, la jerarquía, el contenido ni la condición provisional.

### 2026-09-08 — Runtime interactivo restablecido

- **Cambio:** se incorporaron los estilos compartidos que necesita la simulación, se impidió que el marco decorativo capture entradas y se corrigieron el cierre de la lámina inferior y el gesto de ocultar el teclado.
- **Antes:** el proyecto compilaba, pero la capa del marco bloqueaba clics y gestos en siete pruebas; después de retirarla quedaban dos comportamientos sin cerrar.
- **Motivo:** asegurar que el entorno de revisión responda a las interacciones que declara documentar.
- **Verificación:** 8 pruebas interactivas, 4 pruebas de publicación y la compilación de producción terminaron correctamente.

### 2026-09-08 — Vigencia estructural separada de la visual

- **Cambio:** se aclaró que el tablero sigue vigente por su flujo y cobertura, mientras su paleta documenta la etapa v4.
- **Antes:** estructura y apariencia se presentaban como una sola decisión vigente.
- **Motivo:** conservar un entregable funcional sin contradecir la dirección cromática adoptada el 7 de septiembre.
- **Alcance:** no se modificaron las 44 vistas ni sus exportaciones; la configuración de pruebas acepta ahora un navegador Chromium local cuando Playwright no dispone de su binario descargado.

### 2026-09-07 — Verificación reproducible

- **Cambio:** se registraron los comandos y las condiciones utilizadas para comprobar el tablero y sus exportaciones.
- **Antes:** el README declaraba los resultados, pero no indicaba que la auditoría necesitaba la vista local activa ni cómo repetirla.
- **Motivo:** evitar falsos fallos por conexión rechazada y permitir que otra persona reproduzca el control.
- **Alcance:** la verificación técnica no sustituye pruebas de comprensión, interacción o accesibilidad con usuarios.

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
