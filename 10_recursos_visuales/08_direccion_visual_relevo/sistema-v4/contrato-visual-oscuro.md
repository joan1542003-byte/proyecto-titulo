# Contrato visual oscuro de Relevo

## Propósito

Este contrato define cómo debe continuar la interfaz Android de Relevo. Es una guía propia para producir y auditar pantallas, no un manual de marca cerrado ni una validación de la experiencia.

Relevo es un sistema phygital: la aplicación conserva y organiza una intención, un primer paso, una condición, un lugar y un testigo; el testigo físico emite un pulso situado. La interfaz no debe sustituir ese momento ni convertirlo en una métrica de cumplimiento.

Las pantallas claras `01-inicio-ciclo-activo-claro-v1.png` y `02-configurar-intencion-claro-v1.png` quedan clasificadas como exploraciones históricas. No son dirección vigente para nuevas pantallas. Las nuevas piezas Android se desarrollan exclusivamente en modo oscuro.

## Principio rector

La interfaz organiza y confirma. El testigo físico señala. La persona decide.

Cada recurso visual debe responder a una función documentada del flujo. Si puede eliminarse sin perder comprensión, es decoración y debe tener un peso claramente secundario.

## Clasificación obligatoria

### Contenido

Información que la persona necesita comprender: intención, primer paso, condición, vigencia, lugar o explicación técnica.

### Icono

Signo convencional que representa una acción o entidad. Debe tener significado inequívoco; si es interactivo, requiere etiqueta accesible y un objetivo táctil suficiente.

### Elección

Alternativa seleccionable. Debe mostrar sus límites, el estado seleccionado y el no seleccionado, y la consecuencia de elegirla. Nunca se diferencia solo mediante color.

### Acción

Control que ejecuta o avanza. Debe tener una jerarquía visible, un texto claro y un objetivo táctil mínimo de 48 × 48 dp.

### Estado

Información del sistema que no debe parecer pulsable: vínculo, batería, permiso, vigencia, espera o fallo técnico.

### Gráfico informativo

Recurso visual que comunica una relación. La matriz de puntos solo pertenece a esta categoría cuando representa explícitamente intención, transferencia o señal situada y cuenta con texto equivalente.

### Decoración

Elemento prescindible. No contiene información indispensable ni interacción. No debe compartir contenedor con una elección, parecer botón, pestaña, paginación, progreso o estado, ni interrumpir la lectura.

## Paleta oscura

| Rol | Valor | Uso |
| --- | --- | --- |
| Canvas | `#111314` | Fondo general de la pantalla. |
| Superficie | `#1B1D1E` | Agrupación funcional puntual. |
| Superficie quieta | `#242728` | Estado secundario no interactivo. |
| Texto principal | `#F1F1F1` | Títulos, contenido y acciones principales. |
| Texto secundario | `#B6B8B7` | Ayudas, metadatos y estados secundarios. |
| Regla | `#3A3D3E` | Separación que no comunica un estado. |
| Borde funcional | `#767A79` | Campos, foco y acciones delineadas. |
| Señal situada | `#D71921` | Únicamente el nodo de señal situada; no sirve como navegación ni decoración. |

El rojo no se utiliza en pantallas previas a situar la intención ni para errores, batería, conexión, selección o acción primaria. La información crítica debe conservarse en texto, forma y estructura aunque el color desaparezca.

## Tipografía

- **IBM Plex Sans:** lectura, instrucciones, contenido y acciones.
- **IBM Plex Mono:** etiquetas breves, datos técnicos y numerales.
- **Alfabeto de puntos:** marca, numerales grandes o señales breves no esenciales.

La matriz nunca compone párrafos, instrucciones, permisos, botones ni mensajes de error.

| Rol Android | Tamaño / interlínea |
| --- | ---: |
| Título principal | 32 / 40 sp |
| Título de pantalla | 24 / 32 sp |
| Título de sección | 20 / 28 sp |
| Cuerpo | 16 / 24 sp |
| Secundario | 14 / 20 sp |
| Etiqueta | 12 / 16 sp |

Las unidades deben declararse en dp y sp, no en píxeles, para permitir adaptación y escalamiento. Android utiliza una retícula de 8 dp y submúltiplos de 4 dp para elementos pequeños ([Android Developers](https://developer.android.com/design/ui/mobile/guides/layout-and-content/grids-and-units?hl=es-419)).

## Retícula y composición

- margen lateral base: 24 dp;
- retícula principal: 8 dp;
- subretícula para iconos y detalles: 4 dp;
- objetivo táctil mínimo: 48 × 48 dp;
- una tarea y una acción principal por pantalla;
- encabezado sobrio, sin menú innecesario;
- grupos separados por espacio y reglas, no por una tarjeta para cada dato;
- pocas esquinas redondeadas y ningún radio sin función;
- sin barra de navegación inferior durante el recorrido único;
- sin marcos de teléfono, tableros ni anotaciones de entrega en las imágenes finales.

Los 48 dp son una base preventiva de accesibilidad, no una garantía de usabilidad. Deben comprobarse con foco, TalkBack, texto ampliado y pruebas con personas ([Android Accessibility](https://developer.android.com/design/ui/mobile/guides/foundations/accessibility?hl=en)).

## Motivo gráfico

La gramática de Relevo se compone de:

1. **Origen:** intención y primer paso aún concentrados en la aplicación.
2. **Vínculo:** relación explícita con testigo y lugar.
3. **Señal situada:** nodo localizado que indica que el pulso ocurrió en el espacio físico.

Esta secuencia no representa avance, porcentaje, racha, logro ni cumplimiento. En pantallas donde todavía no existe señal situada, la matriz y el rojo deben omitirse o justificarse mediante otra función documentada.

## Componentes y estados

### Contenido

Debe aparecer en tipografía continua, con etiquetas que expliquen la relación entre intención, primer paso, condición y lugar.

### Elecciones

Se presentan como alternativas claramente delimitadas. El estado seleccionado debe reconocerse por más de una señal: contorno, posición, texto, icono o descripción.

### Acciones

La acción principal tiene mayor contraste y un nombre verbal. Las acciones secundarias no deben parecer estados ni enlaces invisibles.

### Estados técnicos

Vínculo, batería, permisos, vigencia y segundo plano deben utilizar texto y estructura. No se comunican solo con color y no deben usar el mismo contenedor que una selección.

### Iconos

Se utilizan pocos iconos convencionales. Un icono interactivo requiere etiqueta accesible. Un signo experimental puede funcionar como identidad, pero no como control esencial.

### Puntos

Los puntos son decorativos solo cuando pueden eliminarse sin modificar la comprensión. Si forman un gráfico de intención, transferencia y señal, dejan de ser decoración y deben tener texto equivalente. Nunca deben parecer opciones, paginación, progreso o estados seleccionados.

## Reglas para el rojo

- un solo nodo rojo en la señal situada;
- no usar rojo en `Emitir pulso`, `Vincular testigo`, `Continuar`, batería o error;
- no usar rojo para indicar selección;
- no combinar rojo con parpadeo, alarma o urgencia;
- acompañar siempre la señal con texto y contexto;
- probar la pantalla en escala de grises.

## Movimiento

Las transiciones deben ser breves, reversibles y respetar la reducción de movimiento. No se permiten bucles permanentes, destellos rápidos ni animaciones que celebren una conducta. El límite visual de destellos debe revisarse con WCAG 2.2 y no sustituye una prueba específica del pulso físico.

## Aplicación por superficie

### Configurar

Prioriza intención, primer paso, condición y vigencia. No utiliza rojo ni señal situada.

### Vincular y probar

Hace explícita la relación entre testigo, primer paso y lugar. El testigo no tiene pantalla. `Emitir pulso` ejecuta una prueba física y no arma el ciclo.

### Esperar

Muestra el ciclo activo y permite desarmarlo. No muestra métricas ni exige mantener la aplicación abierta.

### Señal situada

El rojo puede aparecer únicamente como nodo de señal situada, acompañado por texto. El teléfono no simula que allí ocurrió el pulso.

### Cerrar o recuperar

Distingue una decisión personal de un fallo técnico. El cierre no registra cumplimiento y el rearme siempre es explícito.

## Accesibilidad y control de calidad

- texto pequeño con contraste mínimo de 4,5:1;
- texto grande y elementos no textuales relevantes con al menos 3:1;
- ningún estado comunicado únicamente por color;
- objetivos táctiles de 48 × 48 dp;
- orden de foco lógico;
- etiquetas accesibles para controles e iconos;
- lectura correcta con TalkBack;
- contenido conservado con texto ampliado hasta 200 %;
- prueba en escala de grises;
- posibilidad de reducir movimiento;
- errores técnicos recuperables y no moralizantes.

WCAG 2.2 establece requisitos de contraste, uso no exclusivo del color, redimensionamiento y contraste no textual ([W3C, WCAG 2.2](https://www.w3.org/TR/WCAG22/)). Estas reglas son criterios de diseño y no constituyen una declaración automática de conformidad.

## Usos incorrectos

No utilizar:

- tarjetas gigantes como estructura general;
- cápsulas universales;
- sombras, glassmorphism o fondos texturizados;
- matrices como relleno;
- indicadores de progreso;
- puntos como selección;
- iconos ambiguos;
- frases de culpa, evaluación o productividad;
- notificaciones tardías;
- interfaz, texto o menú en el testigo;
- fotografías como fondo de la app;
- una forma industrial presentada como definitiva.

## Decisiones abiertas

Este contrato no cierra la forma, materialidad, canal, duración o intensidad del pulso; el gesto físico de armado; la condición de activación; la fuente definitiva; ni la respuesta perceptiva en distintos contextos. Cada decisión pasa a vigente solo después de una prueba pertinente, un registro y una consecuencia documentada.

---

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación

- **Cambio:** se creó el contrato oscuro propio de Relevo con roles de color, tipografía, retícula, clasificación semántica, componentes, accesibilidad y usos incorrectos.
- **Versión anterior:** el sistema V4 reunía exploraciones claras y oscuras, pero no distinguía con suficiente precisión decoración, iconografía, elección, acción, estado y gráfico informativo.
- **Motivo:** establecer un criterio común para continuar Android sin confundir identidad visual con función de interfaz.
- **Alcance:** el contrato gobierna nuevas exploraciones; no convierte las imágenes existentes en diseños finales ni valida el producto.

### 2026-09-01 — Unificación cromática

- **Cambio:** el token de señal se actualizó a `#D71921` y se excluyó de navegación y decoración.
- **Versión anterior:** el contrato usaba `#EF3E45` sin registrar la discrepancia con los criterios visuales generales.
- **Motivo:** mantener una única fuente cromática para soportes editoriales y digitales.
- **Alcance:** no altera los estados funcionales ni modifica imágenes anteriores.
