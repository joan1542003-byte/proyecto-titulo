# Especificación provisional de interfaz

**Estado:** base de diseño para las primeras pantallas de media y alta fidelidad.

**Fecha:** 15 de septiembre de 2026.

## Criterio general

La interfaz debe sentirse propia sin abandonar las convenciones de Android. La diferenciación se concentra en contenido, voz, tipografía y color; navegación, campos, permisos, controles y retroalimentación conservan patrones conocidos. Personalizar un componente solo se justifica cuando el componente habitual no comunica correctamente la función de Relevo.

La estructura previa de wireframes se utiliza como mapa funcional, no como referencia estética.

## Retícula y espacio

Android utiliza unidades independientes de densidad y una retícula basada en múltiplos de 4 y 8. Relevo adopta una escala breve para evitar correcciones aisladas (Android Developers, s. f.-e):

| Token | Valor | Uso habitual |
| --- | ---: | --- |
| espacio-1 | 4 dp | separación interna mínima |
| espacio-2 | 8 dp | relación entre icono y etiqueta |
| espacio-3 | 12 dp | agrupaciones compactas |
| espacio-4 | 16 dp | margen lateral mínimo y separación habitual |
| espacio-5 | 24 dp | cambio de grupo o sección |
| espacio-6 | 32 dp | transición entre contenido principal y apoyo |
| espacio-7 | 48 dp | pausa amplia y área táctil mínima recomendada |

En pantallas compactas, el contenido utiliza márgenes laterales de 16 dp. En anchos mayores puede aumentar a 24 dp y limitar el ancho de lectura. Las pantallas no se diseñan para una captura fija: deben adaptarse a densidad, relación de aspecto y tamaño de texto.

## Arquitectura de cada pantalla

Cada pantalla contiene, en este orden:

1. **Ubicación:** barra superior o título que permite saber en qué parte del recorrido se encuentra la persona.
2. **Decisión o estado:** contenido principal expresado con una pregunta, una intención o un estado inequívoco.
3. **Información necesaria:** explicación breve, consecuencia o dato técnico que afecta la decisión.
4. **Acción principal:** verbo que anticipa el resultado.
5. **Salida o recuperación:** acción secundaria, regreso, edición o ayuda cuando corresponda.

El orden puede desplazarse al aparecer el teclado o un error, pero no debe invertir la jerarquía. Un gráfico de marca nunca se inserta entre una pregunta y sus opciones.

## Componentes

### Botones

- altura mínima de 48 dp;
- texto de 16 sp Semibold;
- radio de 12 dp;
- una sola acción rellena por pantalla;
- acciones secundarias con contorno o texto, según importancia;
- verbos específicos: `Revisar`, `Vincular`, `Probar`, `Preparar`, `Silenciar` o `Cerrar ciclo`;
- estado deshabilitado acompañado de la condición que falta, cuando no sea evidente.

`Continuar` se utiliza únicamente cuando el paso siguiente ya se entiende por el contexto.

### Campos de texto

- etiqueta persistente sobre el campo;
- altura mínima de 56 dp;
- radio de 8 dp;
- ejemplo breve dentro del campo, sin reemplazar la etiqueta;
- contador solo cuando exista un límite real;
- error debajo del campo con causa y forma de corregirlo.

### Opciones

Las decisiones excluyentes usan controles de selección reconocibles y una etiqueta completa. Los interruptores se reservan para ajustes que cambian inmediatamente; no se usan para avanzar entre etapas. Las cápsulas solo corresponden a filtros o elecciones breves y no se convierten en decoración.

### Tarjetas y superficies

La agrupación se resuelve primero con alineación y espacio. Una tarjeta se incorpora cuando un conjunto necesita selección, expansión, arrastre o separación del fondo. Su radio inicial es de 12 dp y no usa sombra cuando el contorno o el cambio de superficie bastan.

### Iconos

Se utilizan Material Symbols Outlined para acciones conocidas, con tamaño base de 24 dp, peso visual coherente y etiqueta cuando el significado no sea universal. Los conceptos propios —intención, forma de comenzar, testigo y ciclo— no reciben un icono hasta comprobar que aporta más que la palabra.

## Estados

| Estado | Qué debe aparecer | Acción disponible |
| --- | --- | --- |
| Sin configurar | tarea pendiente expresada en lenguaje común | comenzar configuración |
| Preparado | actividad, forma de comenzar, condición y testigo asociados | editar o desarmar |
| Esperando | estado actual y próxima condición relevante | revisar o cerrar |
| Señal activa | actividad, forma de comenzar, procedencia y estado del testigo | silenciar, cerrar o mantener |
| Conexión perdida | qué ocurrió y qué contenido permanece guardado | acercar y reintentar |
| Permiso requerido | para qué se necesita y qué ocurre si se rechaza | conceder o continuar sin la función, si es posible |
| Cerrado | confirmación neutral | volver al inicio o preparar otro ciclo |

Los estados no reciben puntuaciones, celebraciones ni mensajes de fracaso.

## Pantalla clave: señal activa

La pantalla más importante debe explicar el momento phygital sin competir con el objeto. Su jerarquía recomendada es:

1. estado breve: `La señal está activa`;
2. intención, en el mayor tamaño de texto;
3. forma concreta de comenzar;
4. lugar declarado y nombre del testigo;
5. explicación opcional de una línea;
6. acción principal coherente con la prueba;
7. salida secundaria visible.

En esta variante de prototipo, el verde turquesa se utiliza en el vínculo activo o en una acción principal, no como ilustración de fondo ni como confirmación de cumplimiento. No se presenta como color definitivo de marca. Si una persona no percibe el color, la jerarquía continúa siendo legible por texto, peso, posición y forma.

## Lenguaje de configuración

La documentación puede utilizar `primer paso` como concepto analítico definido, pero la interfaz debe describir la tarea con preguntas directas:

| Pantalla | Título o etiqueta |
| --- | --- |
| Actividad | `¿Qué quieres hacer?` |
| Comienzo | `¿Cómo podrías empezar?` |
| Ayuda del campo | `Escribe una acción breve y concreta. Por ejemplo: ponerme las zapatillas.` |
| Revisión | `Cómo empezar` |

No se utiliza `primer paso` como etiqueta aislada. La decisión evita exigir aprendizaje terminológico antes de configurar el sistema y debe comprobarse mediante paráfrasis y tareas.

## Forma, movimiento y profundidad

- radios de 8 y 12 dp como base;
- círculos solo para iconos, selección o controles cuya función lo requiera;
- sombras escasas y ligadas a superposición real;
- movimiento de 150 a 250 ms para confirmar cambios de estado;
- ninguna animación continua durante la espera;
- respeto a la preferencia de reducción de movimiento;
- la señal física no se imita mediante parpadeo intenso en pantalla.

## Tema claro y oscuro

La aplicación sigue la preferencia del sistema. Ambos temas mantienen la misma jerarquía y los mismos roles; no son dos identidades distintas. Android recomienda considerar preferencias del sistema y conservar un tema propio como respaldo cuando el color dinámico no esté disponible (Android Developers, s. f.-b).

El color dinámico puede evaluarse más adelante. En el prototipo inicial se mantiene la paleta controlada para que las pruebas comparen la interfaz y no combinaciones generadas por distintos fondos de pantalla.

## Lista de control por pantalla

- ¿Puede describirse su propósito en una frase?
- ¿Existe una sola acción de mayor énfasis?
- ¿La salida es visible?
- ¿Cada elemento interactivo parece interactivo?
- ¿Los elementos decorativos podrían confundirse con controles?
- ¿El estado se entiende en escala de grises?
- ¿El texto sobrevive al aumento sin quedar cortado?
- ¿El error indica cómo recuperarse?
- ¿La pantalla evita repetir el mismo mensaje en título, cuerpo y botón?
- ¿La identidad ayuda a reconocer Relevo sin interrumpir la decisión?

---

## Registro de cambios (disclaimer)

### 2026-09-15 — Interfaz separada del cierre de marca

- **Qué cambió:** el turquesa quedó limitado a esta variante de interfaz y `cómo podrías empezar` se mantiene como texto de prueba, no como expresión definitoria de Relevo.
- **Cómo era antes:** la interfaz se presentaba como una manifestación directa de un relato de marca ya resuelto.
- **Por qué se decidió:** el proyecto completo incluye producto, objeto, aplicación, comunicación y documentación; ninguna pantalla puede definir por sí sola la marca.
- **Límite:** la especificación permite construir y comparar pantallas, pero no cierra identidad, significado cromático ni lenguaje final.

### 2026-09-15 — Lenguaje público y función de marca sincronizados

- **Qué cambió:** la interfaz pregunta `¿Cómo podrías empezar?`, muestra `Cómo empezar` en revisión y utiliza el turquesa como color de presencia, no de logro.
- **Cómo era antes:** `primer paso` aparecía como etiqueta pública y el acento se describía solo como recurso funcional de estado o acción.
- **Por qué se decidió:** la interfaz debe usar palabras reconocibles y expresar el relato de marca sin añadir decoración ni juicios sobre la conducta.
- **Límite:** los textos y la jerarquía cromática permanecen sujetos a pruebas de comprensión, accesibilidad y uso.

### 2026-09-15 — Primera especificación de interfaz

- **Qué cambió:** se definieron retícula, espacio, componentes, estados, pantalla clave, forma, movimiento y criterios de revisión.
- **Cómo era antes:** el documento de interfaz fijaba principios, pero no ofrecía valores suficientes para producir pantallas comparables.
- **Por qué se decidió:** traducir la dirección visual y la accesibilidad en reglas aplicables a los wireframes vigentes.
- **Límite:** estas reglas no sustituyen una prueba de tareas ni una implementación adaptativa en Android.
