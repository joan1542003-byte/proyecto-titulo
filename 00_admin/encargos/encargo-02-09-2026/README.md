# Encargo 02-09-2026 — Wireframes de Relevo

## Qué contiene esta entrega

Esta carpeta reúne el recorrido digital de Relevo en un formato listo para revisar y presentar. Las nueve pantallas principales se desarrollan en fidelidad media con el lenguaje visual vigente: jerarquía tipográfica, retícula, contraste, controles y estados se reconocen, pero la interacción todavía puede corregirse. La pantalla **3.1 Esperar** conserva además una exploración de alta fidelidad porque reúne las variables centrales del ciclo.

La ruta principal tiene nueve marcos, organizados en tres interacciones. A ellos se suman 35 estados de cobertura que permiten anticipar permisos, fallos, salidas y recuperaciones. Estos estados no son 35 pasos nuevos ni forman un segundo recorrido obligatorio.

## Organización

- `01_pantalla_principal_alta_fidelidad`: desarrollo visual vigente de **3.1 Esperar** y registro de la exploración anterior.
- `02_wireframes_ruta_principal`: nueve marcos que resumen el recorrido evaluable.
- `03_estados_cobertura`: 35 variantes de estado y excepción.
- `04_mapa_completo`: mapa general, ruta dividida en tres interacciones, cobertura dividida en cinco familias y una carpeta por wireframe.
- `05_referencias_visuales_rescatadas`: cuatro exploraciones útiles recuperadas del archivo local.
- `INVENTARIO-DE-RECURSOS-VISUALES.md`: comprobación del respaldo de 198 PNG y de las 25 imágenes transparentes.
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
- uso contenido de superficies y divisores, sin elementos decorativos que parezcan controles;
- rojo `#D71921` reservado para el acontecimiento de la señal situada. Por eso no aparece en la pantalla **Ciclo activo** mientras la condición sigue en espera.

La interfaz separa contenido, elección, acción y estado. Los campos se reconocen como editables; la acción principal tiene mayor jerarquía que la salida secundaria; la información técnica no se presenta como botón. Esta diferencia es necesaria para que la apariencia no contradiga el funcionamiento.

## Cómo leer la entrega

Conviene comenzar por `04_mapa_completo/00_mapa_general/mapa-general-jerarquico.png`. El atlas `mapa-ruta-principal-legible.png` permite leer las nueve pantallas en secuencia, mientras `mapa-cobertura-por-familias.png` ordena las excepciones sin confundirlas con pasos obligatorios. La pantalla de alta fidelidad funciona como una muestra de dirección, no como prueba de que toda la aplicación esté terminada. El marco 3.2 y el estado 23 representan un momento físico: el pulso ocurre en el testigo situado y no en una pantalla instalada en el objeto.

## Verificación

- Ruta principal: 9 archivos PNG.
- Cobertura: 35 archivos PNG.
- Dimensión de cada wireframe: 824 × 1830 px.
- Pantalla destacada: 3.1 Ciclo activo, revisada y sin elementos rojos.
- Mapas vigentes: arquitectura general de 3840 × 2160 px, ruta principal ampliada de 3168 × 7080 px y cobertura por familias de 3840 × 3000 px.
- La navegación, la descarga y las explicaciones del tablero HTML no aparecen dentro de las imágenes.

## Fuentes internas

- `05_propuesta_phygital/wireframes-media-html/src/wireframes.ts`
- `05_propuesta_phygital/wireframes-media-html/COBERTURA.md`
- `05_propuesta_phygital/wireframes-media-html/DECISIONES-DE-DISENO.md`
- `10_recursos_visuales/08_direccion_visual_relevo/sistema-v4/`

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Rediseño de la ruta y reemplazo del mapa ilegible

- **Qué se incorporó:** nueve pantallas principales con el lenguaje visual oscuro vigente, fundamentos visuales individuales y tres mapas con niveles de lectura diferentes.
- **Cómo estaba antes:** los marcos principales conservaban una apariencia estructural genérica y una sola lámina reducía las 44 vistas hasta volver ilegible su contenido.
- **Qué se reemplazó:** el mapa de miniaturas se trasladó al historial; en su lugar se incorporaron una arquitectura general, un atlas ampliado y una lámina de cobertura.
- **Por qué se hizo:** permitir que la estructura completa y el diseño de cada pantalla puedan revisarse sin competir dentro de una misma imagen.

### 2026-09-02 — Reorganización y auditoría visual

- **Qué se incorporó:** una carpeta por wireframe, agrupación por interacción y familia, inventario de 198 PNG, rescate de cuatro referencias y una nueva pantalla destacada.
- **Cómo estaba antes:** las exportaciones estaban en carpetas planas y 1.1 Formular funcionaba como pantalla principal.
- **Qué se reemplazó:** la jerarquía principal pasó a 3.1 Esperar; la pieza anterior se conserva como parte del proceso.
- **Por qué se hizo:** permitir una revisión clara, demostrar qué imágenes están respaldadas y destacar un momento que represente mejor el funcionamiento de Relevo.

### 2026-09-02 — Creación de la entrega consolidada

- **Qué se incorporó:** pantalla principal de alta fidelidad, nueve wireframes principales, 35 estados de cobertura, mapa completo, manifiesto y explicación individual.
- **Cómo estaba antes:** las imágenes y sus fundamentos se encontraban distribuidos entre el prototipo HTML, el sistema visual y los entregables del Encargo 17.
- **Por qué se hizo:** reunir una entrega fechada, legible y autónoma sin perder la diferencia entre dirección visual, arquitectura principal y cobertura técnica.
- **Alcance:** la entrega organiza y representa decisiones vigentes; no acredita validación con personas ni cierre técnico de Android o del testigo físico.
