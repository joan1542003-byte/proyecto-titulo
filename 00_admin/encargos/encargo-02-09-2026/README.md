# Encargo 02-09-2026 — Wireframes de Relevo

## Qué contiene esta entrega

Esta carpeta reúne el recorrido digital de Relevo en un formato listo para revisar y presentar. La entrega no mezcla niveles de definición: la pantalla **1.1 Formular** se desarrolla en alta fidelidad para fijar una dirección visual, mientras que el resto se mantiene como wireframes. De este modo, la propuesta muestra cómo podría verse la interfaz sin ocultar las decisiones de estructura que todavía deben probarse.

La ruta principal tiene nueve marcos, organizados en tres interacciones. A ellos se suman 35 estados de cobertura que permiten anticipar permisos, fallos, salidas y recuperaciones. Estos estados no son 35 pasos nuevos ni forman un segundo recorrido obligatorio.

## Organización

- `01_pantalla_principal_alta_fidelidad`: desarrollo visual de **1.1 Formular**.
- `02_wireframes_ruta_principal`: nueve marcos que resumen el recorrido evaluable.
- `03_estados_cobertura`: 35 variantes de estado y excepción.
- `04_mapa_completo`: vista general de la arquitectura.
- `EXPLICACION-Y-JUSTIFICACION.md`: lectura breve de cada marco y de cada estado.
- `VERIFICACION.md`: control de archivos, dimensiones y coincidencia entre copias.
- `manifest.json`: inventario técnico de las 44 exportaciones.

## Criterio visual

Los wireframes utilizan una ventana Android representativa de **412 × 915 dp** y se exportan a **824 × 1830 px**. No incluyen carcasa, barra de estado ni navegación del sistema porque esos elementos no forman parte de la interfaz que se evalúa.

La pantalla de alta fidelidad conserva la retícula y la semántica del sistema visual vigente:

- IBM Plex Sans para lectura e IBM Plex Mono para etiquetas técnicas;
- retícula de 8 unidades, margen de 24 y objetivos táctiles de al menos 48;
- fondo `#111314`, superficies `#1B1D1E` y `#242728`;
- texto principal `#F1F1F1`, texto secundario `#B6B8B7`, reglas `#3A3D3E` y bordes `#767A79`;
- ausencia de sombras, degradados, texturas y elementos decorativos que parezcan controles;
- rojo `#D71921` reservado para el acontecimiento de la señal situada. Por eso no aparece en la pantalla **Formular**.

La interfaz separa contenido, elección, acción y estado. Los campos se reconocen como editables; la acción principal tiene mayor jerarquía que la salida secundaria; la información técnica no se presenta como botón. Esta diferencia es necesaria para que la apariencia no contradiga el funcionamiento.

## Cómo leer la entrega

Conviene comenzar por el mapa completo, continuar con los nueve marcos y revisar después los estados de cobertura. La pantalla de alta fidelidad funciona como una muestra de dirección, no como prueba de que toda la aplicación esté terminada. El marco 3.2 y el estado 23 representan un momento físico: el pulso ocurre en el testigo situado y no en una pantalla instalada en el objeto.

## Verificación

- Ruta principal: 9 archivos PNG.
- Cobertura: 35 archivos PNG.
- Dimensión de cada wireframe: 824 × 1830 px.
- Pantalla principal: texto corregido y sin elementos rojos.
- Mapa general: actualizado con las 44 exportaciones vigentes.
- La navegación, la descarga y las explicaciones del tablero HTML no aparecen dentro de las imágenes.

## Fuentes internas

- `05_propuesta_phygital/wireframes-media-html/src/wireframes.ts`
- `05_propuesta_phygital/wireframes-media-html/COBERTURA.md`
- `05_propuesta_phygital/wireframes-media-html/DECISIONES-DE-DISENO.md`
- `10_recursos_visuales/08_direccion_visual_relevo/sistema-v4/`

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Creación de la entrega consolidada

- **Qué se incorporó:** pantalla principal de alta fidelidad, nueve wireframes principales, 35 estados de cobertura, mapa completo, manifiesto y explicación individual.
- **Cómo estaba antes:** las imágenes y sus fundamentos se encontraban distribuidos entre el prototipo HTML, el sistema visual y los entregables del Encargo 17.
- **Por qué se hizo:** reunir una entrega fechada, legible y autónoma sin perder la diferencia entre dirección visual, arquitectura principal y cobertura técnica.
- **Alcance:** la entrega organiza y representa decisiones vigentes; no acredita validación con personas ni cierre técnico de Android o del testigo físico.
