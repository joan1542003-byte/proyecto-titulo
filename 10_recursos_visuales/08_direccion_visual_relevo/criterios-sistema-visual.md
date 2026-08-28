# Criterios para el sistema visual de Relevo

## Concepto provisional

**La intención toma relevo.**

El sistema visual representa el momento en que una intención deja de permanecer únicamente como información digital y vuelve a hacerse perceptible desde un lugar. La identidad no celebra obediencia ni muestra una meta cumplida. Comunica una transición y deja abierto lo que la persona decide después.

## Principios

### 1. Señal, no alarma

El acento visual debe llamar la atención sin adoptar códigos de urgencia, error o sanción. El rojo se evaluará como color de identidad y transición; no se asumirá como color definitivo del pulso físico. Los errores técnicos utilizarán icono, texto y estructura, no solo color.

### 2. Matriz con función

Los puntos representan estados, asociación o transferencia. No se utilizarán como textura automática. La tipografía matricial se limitará a logotipo exploratorio, títulos breves, numerales grandes o signos. El cuerpo de lectura y las acciones permanecerán en una tipografía continua.

### 3. Una jerarquía tranquila

Cada superficie debe mostrar una acción principal y pocas decisiones secundarias. El vacío, la escala y la alineación tendrán prioridad sobre bordes, sombras y tarjetas. La interfaz no debe parecer un tablero de productividad.

### 4. Coherencia sin duplicación

La aplicación, el objeto y la comunicación comparten ritmo, contraste y transformación de puntos. No deben mostrar lo mismo. El teléfono configura y explica; el objeto hace perceptible una intención mediante presencia y señal; la gráfica editorial narra la relación entre ambos.

### 5. La persona conserva la salida

Los estados visuales deben hacer visibles las alternativas de continuar, silenciar, editar, reubicar o cerrar. No se usarán marcas de éxito, rachas, trofeos, advertencias morales ni mensajes de culpa.

### 6. Identidad adaptable a decisiones abiertas

La dirección debe sobrevivir si cambia la forma del objeto, el material o el canal de señal. Por ello, la identidad se apoyará en una gramática de transición y no en la silueta definitiva del producto.

## Gramática visual provisional

### Paleta funcional

| Token provisional | Valor de exploración | Función | Restricción |
| --- | --- | --- | --- |
| `ink-950` | `#1B1D1E` | Fondo oscuro, texto principal, estructura. | No usar negro puro en grandes superficies si reduce comodidad visual. |
| `paper-050` | `#F1F1F1` | Fondo claro, texto inverso y espacio editorial. | Comprobar contraste con grises secundarios. |
| `signal-600` | `#D71921` | Momento de transición, foco editorial o estado activo. | No comunicar error, obligación ni resultado mediante rojo solamente. |
| `neutral-500` | Por definir | Estados secundarios y elementos desactivados. | Debe mantener contraste no textual mínimo cuando transmita información. |

La paleta reproduce inicialmente los valores observados en la referencia del autor para poder evaluar la dirección. Su adopción definitiva, ajuste tonal y aplicación impresa quedan pendientes. El color de identidad y el canal luminoso del objeto son decisiones distintas.

En pantalla, `ink-950` sobre `paper-050` alcanza una relación aproximada de 14,98:1. `signal-600` sobre `paper-050` alcanza 4,59:1 y sobre `ink-950`, 3,26:1. El rojo cumple por un margen estrecho para texto normal sobre el fondo claro y solo resulta apropiado para texto grande o gráficos sobre el fondo oscuro. Para evitar fallos por tamaño, peso o renderizado, se reservará preferentemente para superficies, puntos, líneas y títulos grandes.

### Tipografía

Se propone explorar tres niveles:

1. **Texto y acciones:** IBM Plex Sans o una sans serif de alta legibilidad con soporte completo para español.
2. **Datos técnicos y etiquetas:** IBM Plex Mono, usada con moderación.
3. **Signos matriciales:** alfabeto o conjunto de glifos propio, limitado a expresiones breves.

Mantener una familia principal y una complementaria evita que la identidad dependa de una tipografía decorativa. No se compondrán párrafos, consentimientos, instrucciones ni botones críticos con letras de puntos.

### Retícula y geometría

- Retícula digital base de 8 unidades.
- Retícula editorial de doce columnas con amplios campos de vacío.
- Radios asignados por función; las cápsulas se reservan para acciones breves o estados compactos.
- Círculos asociados a señal, ubicación o representación abstracta del testigo, no a todo componente.
- Matrices construidas desde una unidad común, con densidad variable para representar transición.
- Una composición debe contener un foco dominante; no se organizará como inventario de widgets.

### Motivo propio: transferencia situada

El motivo se construye con dos campos y un vínculo. Un grupo representa la intención conservada; otro, la señal situada. El relevo aparece cuando la densidad, el ritmo o el acento se trasladan entre ambos. La secuencia puede detenerse sin convertirse en progreso, recompensa o cumplimiento.

### Iconografía

Las acciones esenciales utilizarán símbolos convencionales y etiquetas claras. Los glifos de puntos se reservarán para identidad, estados ambientales o ilustración. Esta separación evita obligar a aprender una iconografía completa antes de usar la aplicación.

### Movimiento

- Transiciones breves y reversibles.
- El movimiento principal desplaza atención entre dos estados; no celebra una conducta.
- No usar bucles permanentes, destellos rápidos ni pulsos que compitan con el control de la persona.
- No superar tres destellos por segundo; esta regla preventiva no sustituye una evaluación de la señal física.
- La aplicación deberá respetar las preferencias de reducción de movimiento.
- El patrón físico se definirá mediante pruebas de percepción, convivencia y accesibilidad.

## Aplicación por soporte

### Aplicación Android

- Contenido legible en sans serif; matriz solo en identidad y señalización breve.
- Texto principal de exploración a 16 sp, información secundaria a 14 sp y títulos desde 20 sp; comprobar ampliación hasta 200 % sin pérdida de contenido.
- Acciones táctiles con área mínima de 48 dp.
- Contraste mínimo de 4,5:1 para texto pequeño y 3:1 para texto grande y elementos no textuales relevantes.
- Estados identificados mediante forma, texto o icono además del color.
- Intención personal separada visualmente de batería, conexión y permisos.
- Sin cronologías de cumplimiento, puntuaciones ni paneles de desempeño.

### Objeto situado

- Lenguaje material neutro y reparable; acabado y color permanecen abiertos.
- Una región difusa puede comunicar la señal, pero no debe confundirse con una pantalla.
- Control físico identificable por tacto y accesible sin movimientos precisos.
- Reposo, pulso y atención técnica deben diferenciarse sin exigir vigilancia constante.
- El código visual no debe revelar el contenido de la intención a terceros.

### Memoria y comunicación

- La matriz puede ampliar conceptos, transiciones y diagramas, pero no reemplaza evidencia.
- Las piezas editoriales deben diferenciar investigación, hipótesis, decisión y resultado.
- Una imagen no debe mostrar como definitiva la forma del objeto o el color del pulso.
- La dirección puede utilizar macrográfica, numerales y campos de puntos con mayor libertad que la aplicación, manteniendo legibilidad de citas y texto académico.

## Usos que deben evitarse

- copiar composiciones, glifos o widgets reconocibles de Nothing;
- utilizar el rojo para culpa, fallo de conducta o bloqueo;
- componer párrafos completos con tipografía matricial;
- convertir cada sección en una tarjeta redondeada;
- usar la matriz como decoración sin relación con una transición;
- mostrar métricas ficticias, rachas o resultados no obtenidos;
- representar el objeto como una pantalla física;
- fijar una forma industrial antes de las pruebas correspondientes.

## Fundamento de accesibilidad

WCAG 2.2 establece que el color no debe ser el único medio para comunicar información y exige relaciones mínimas de contraste para texto y componentes (World Wide Web Consortium, 2023). Android recomienda objetivos táctiles de al menos 48 dp, contraste de 4,5:1 para texto pequeño, 3:1 para texto grande y gráficos, descripciones comprensibles y texto escalable (Android Developers, 2026). Estos valores constituyen una base preventiva; no reemplazan pruebas con personas ni validan el canal físico.

## Fuentes

- Android Developers. (2026). *Make apps more accessible*. https://developer.android.com/guide/topics/ui/accessibility/apps
- Nothing Technology Limited. (2026). *Nothing OS evolution*. https://nothing.community/en/d/61774
- World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

---

## Registro de cambios (disclaimer)

### 2026-08-28 — Primera gramática visual

- **Cambio:** se tradujeron los principios de Relevo a reglas de color, tipografía, retícula, iconografía, movimiento y aplicación por soporte.
- **Versión anterior:** las exploraciones visuales describían paletas y motivos, pero no relacionaban cada recurso con autonomía, señal situada, accesibilidad y decisiones abiertas.
- **Motivo:** permitir que las alternativas visuales puedan evaluarse y que una selección posterior tenga fundamento.
- **Alcance:** los valores, familias tipográficas y comportamientos son provisionales; requieren comparación visual, revisión de licencias y pruebas de uso.
