# Metodología para validar el sistema visual de Relevo

## Propósito

Este protocolo define cómo pasar de una regla visual a una decisión respaldada. No busca medir si una persona obedeció una señal ni si redujo su uso del teléfono. Evalúa si comprende la interfaz, reconoce sus opciones, distingue los estados, percibe la señal, asocia el lugar con el primer paso y conserva la posibilidad de decidir.

La metodología combina el Doble Diamante del Design Council con cuatro aportes de la biblioteca de diseño y con estándares profesionales. Norman se utiliza para comprensión, acción, retroalimentación, errores y recuperación; Albers, para comparación cromática en contexto; Munari, para comunicación, función, materialidad y experimentación; Isaacson, únicamente como caso histórico de integración de producto. WCAG 2.2, Android Accessibility, Material 3, la ley de Fitts y los tokens de diseño complementan la revisión técnica.

## Principios metodológicos

1. Una fuente no puede demostrar más de lo que estudia.
2. Una preferencia visual no se presenta como hallazgo de usuario.
3. Una imagen rasterizada orienta; un prototipo permite interactuar; una prueba permite revisar una afirmación.
4. La percepción y la comprensión se estudian antes de declarar una solución eficaz.
5. La persona puede ignorar, silenciar, modificar o cerrar sin que la prueba lo interprete como fracaso.
6. La forma del testigo se decide después de comparar función, contexto, producción, mantenimiento y percepción.
7. Cada prueba debe tener una pregunta principal; no se desarrollan dos áreas distintas dentro de la misma fase.

## Tipos de evidencia

| Evidencia | Qué puede responder | Qué no puede responder |
|---|---|---|
| Memoria, entrevistas y estado del arte | Problema, necesidades relatadas, contraejemplos y antecedentes | Que una interfaz o señal funcione en uso real |
| Auditoría experta | Contradicciones, legibilidad preventiva, semántica y cobertura del flujo | Que las personas interpreten el sistema de la misma manera |
| Prueba de comprensión | Qué entiende una persona frente a una pantalla, gráfico o señal | Eficacia a largo plazo o representatividad estadística |
| Prueba de tarea | Errores, recorridos, recuperación y ambigüedades | Que la persona mantendrá la intención fuera de la prueba |
| Prueba cromática | Diferencias perceptuales en fondos, tamaños y soportes | Que un color tenga un significado universal |
| Prueba física situada | Detección, asociación, convivencia, privacidad y ajuste | Que la señal cambie una conducta o sea adecuada para todos los hogares |
| Registro técnico | Conexión, permisos, batería, entrega y fallos | Que una entrega técnica haya sido comprendida o deseada |

## Secuencia de trabajo

### Fase 0 — Auditoría del problema y del alcance

**Objetivo:** asegurar que la pieza visual responde a Relevo y no a una función inventada.

**Entradas:** memoria v4, resumen vigente, decisiones D-023, D-024, D-027, D-031, D-032, D-034, D-036 y D-037; wireframes; anexo de 35 estados; biblioteca de diseño; contrato visual.

**Preguntas:**

- ¿Qué momento del flujo representa la pieza?
- ¿Qué debe comprender la persona?
- ¿Qué acción puede realizar y cuál queda fuera?
- ¿El testigo aporta una función física real o solo una imagen?
- ¿La forma, el color o la animación están cerrados o siguen siendo hipótesis?

**Salida:** ficha de alcance con marco, estado, función, categorías semánticas, decisión, fuente, límite y método de validación.

### Fase 1 — Auditoría semántica

**Objetivo:** comprobar que contenido, icono, elección, acción, estado, gráfico informativo y decoración no se confunden.

**Método:** recorrido cognitivo inspirado en Norman (2002). Para cada elemento se pregunta si la persona puede percibir qué es, qué puede hacer, qué ocurrió y cómo volver atrás.

**Tareas:**

1. señalar qué información debe leerse;
2. identificar qué se puede elegir;
3. identificar qué control ejecuta una acción;
4. separar un estado técnico de una acción;
5. explicar qué representa un gráfico de puntos;
6. retirar la decoración y comprobar si la comprensión se conserva.

**Criterio de revisión:** una confusión crítica entre acción, elección o estado obliga a rediseñar antes de continuar. No se compensa con una preferencia estética mayoritaria.

### Fase 2 — Auditoría visual y cromática

**Objetivo:** revisar jerarquía, contraste, ritmo, proporción y rol del color en contexto.

**Método:** comparar variantes que cambien una relación a la vez: fondo, cantidad de rojo, densidad de puntos, tamaño tipográfico, separación o tratamiento de superficie. La lógica de comparación proviene de Albers (2013): un valor no se juzga aislado de su contexto.

**Pruebas:**

- pantalla oscura a brillo alto, medio y bajo;
- texto pequeño y ampliado;
- pantalla en escala de grises;
- impresión o reproducción de la pieza editorial;
- fondo, superficie y proporción diferentes;
- combinación con fotografías y posibles materiales del testigo.

**Criterio de aprobación provisional:** la jerarquía, la acción y los estados deben seguir siendo comprensibles sin rojo ni matriz. El rojo solo puede permanecer si identifica la señal situada y no se confunde con error, selección, batería o acción.

### Fase 3 — Interacción y accesibilidad

**Objetivo:** comprobar que el sistema visual puede convertirse en una interfaz operable.

**Método:** auditoría de prototipo funcional y recorrido de tareas. Las pautas de Android y WCAG orientan contraste, tamaño, texto escalable, foco, nombres accesibles y uso no exclusivo del color.

**Revisar:**

- objetivos táctiles de al menos 48 × 48 dp;
- orden de foco y lectura con TalkBack;
- etiquetas de iconos y acciones;
- texto ampliado hasta 200 %;
- estados vacío, completo, incompleto, error, espera y recuperación;
- reducción de movimiento;
- ausencia de acciones ocultas o de estados con apariencia pulsable;
- comprensión de mensajes sin depender de iconos ambiguos.

**Criterio de aprobación provisional:** ningún control crítico puede quedar sin nombre, foco, salida o consecuencia comprensible. El contraste técnico debe cumplir el valor adoptado antes de presentar la pantalla como lista para implementación.

### Fase 4 — Prueba de sistema phygital

**Objetivo:** comprobar si el vínculo entre Android, testigo, lugar y señal aporta algo que una notificación digital equivalente no aporta.

**Método:** comparar dos condiciones con el mismo contenido de intención y primer paso: una notificación local del teléfono y una señal del testigo situado. El orden de presentación se contrabalancea cuando sea posible para no atribuir el resultado al orden de la prueba.

**Tareas posibles:**

1. formular una intención y un primer paso;
2. elegir una condición provisional;
3. situar y vincular el testigo;
4. probar la señal y declarar si se percibe;
5. explicar qué relación tiene el lugar con el primer paso;
6. elegir libremente entre ignorar, silenciar, continuar o cerrar;
7. recuperar un fallo de vínculo o un cambio de lugar.

**Observaciones:** detección, interpretación, asociación, tiempo hasta la primera explicación correcta, intrusión percibida, privacidad, convivencia, posibilidad de detener y comprensión de la salida. No se registra si la persona inició la actividad como resultado de la prueba.

**Criterio de aprobación provisional:** la señal debe poder reconocerse y relacionarse con la intención sin convertirla en una orden. Si el testigo no aporta comprensión, contexto, control o una experiencia significativamente distinta de la notificación, la decisión phygital debe reabrirse.

### Fase 5 — Editorial y documentación

**Objetivo:** verificar que la memoria y las láminas explican el sistema sin presentar hipótesis como resultados.

**Método:** lectura independiente con contenido real. La persona lectora debe poder identificar problema, hallazgo, decisión, hipótesis y prueba sin explicación oral del autor.

**Revisar:**

- estructura y jerarquía de capítulos;
- citas, referencias, figuras y tablas en APA 7;
- leyendas de puntos y diagramas;
- pies de fotografía y procedencia;
- diferencia entre exploración, prototipo y resultado;
- legibilidad en impresión y pantalla;
- continuidad entre texto, imagen y sistema visual.

**Criterio de aprobación provisional:** si una pieza visual parece afirmar una forma, color, canal o resultado que el texto todavía considera abierto, la pieza debe corregirse o marcarse como exploración.

### Fase 6 — Decisión y registro

Cada prueba termina con una de cuatro decisiones:

- **mantener:** la regla responde a la pregunta y no presenta contradicciones;
- **ajustar:** la regla funciona parcialmente y necesita una modificación acotada;
- **reabrir:** la evidencia contradice el supuesto o muestra un riesgo central;
- **descartar:** la solución no aporta función o produce un riesgo que no puede aceptarse.

La decisión se registra con fecha, pregunta, versión, participantes o condiciones, tareas, observaciones, datos, limitaciones, decisión y consecuencia para Android, editorial u objeto.

## Muestra y participantes

Los dos tipos de usuario del proyecto son lentes de análisis, no etiquetas rígidas: usuario principal, cuando existe una intención alternativa que pierde presencia durante una sesión digital; y usuario límite, cuando la actividad digital es significativa o no existe una intención alternativa pertinente. Una misma persona puede ocupar ambas posiciones según la situación.

Para una prueba formativa se propone trabajar con participantes de ambos perfiles y describir la cantidad final antes de convocar. Como orientación inicial, cinco a ocho personas por ronda pueden revelar problemas de comprensión, pero no representan a la población ni validan el proyecto por sí mismas. La cantidad, reclutamiento, consentimiento y tratamiento de datos deben quedar registrados en el protocolo de cada ronda.

El corpus original de entrevistas y una prueba visual posterior no deben mezclarse como si fueran la misma evidencia. Las entrevistas explican experiencias relatadas; la validación visual observa respuestas frente a una propuesta concreta.

## Métricas no moralizantes

| Medida | Definición | Uso correcto |
|---|---|---|
| Comprensión | Explicación correcta de una pantalla, señal o relación | Revisar lenguaje y jerarquía |
| Interpretación errónea | Lectura que atribuye una función inexistente | Detectar ambigüedad semántica |
| Error de interacción | Acción distinta a la esperada para completar la tarea | Revisar mapeo, foco y consecuencia |
| Recuperación | Capacidad de volver desde un fallo o cambio | Revisar reversibilidad y mensajes |
| Detección | Momento en que la persona percibe la señal | Estudiar distancia, intensidad y convivencia |
| Asociación | Relación que establece entre señal, lugar e intención | Revisar contexto y texto equivalente |
| Intrusión percibida | Interferencia declarada por la persona | Ajustar canal, duración, volumen o ubicación |
| Autonomía percibida | Claridad de que puede ignorar, silenciar, cambiar o cerrar | Revisar tono y salidas |
| Carga de configuración | Esfuerzo observado para formular, vincular y preparar | Reducir pasos sin ocultar decisiones |

No se utilizan como resultados principales tiempo de pantalla, rachas, minutos recuperados, porcentaje de cumplimiento, cantidad de actividades iniciadas ni puntuaciones personales. Esas medidas alterarían la pregunta del proyecto y convertirían una ayuda opcional en evaluación.

## Criterios de aprobación y rechazo

### Puertas obligatorias

Una pieza no avanza si:

- el rojo aparece fuera de la señal situada;
- una elección se distingue solo por color;
- un estado parece botón o una acción parece estado;
- un icono crítico es ambiguo o no tiene nombre accesible;
- la matriz parece progreso, paginación, selección o métrica;
- la pantalla simula el pulso físico;
- aparece una función no documentada en los wireframes o la memoria;
- se presenta como definitiva una forma, material o canal que sigue abierto;
- contiene culpa, premio, evaluación, racha o bloqueo.

### Criterios de mantenimiento

Una decisión puede mantenerse cuando:

- la tarea y la consecuencia se comprenden;
- los estados técnicos se separan de las decisiones personales;
- el sistema conserva salidas y recuperación;
- la jerarquía sobrevive a escala de grises y texto ampliado;
- la señal se percibe en el contexto probado;
- la pieza puede explicar su fuente, límite y condición de revisión;
- la integración entre soportes aporta algo más que repetición formal.

Los umbrales numéricos específicos se fijan antes de cada prueba cuando sean necesarios. No se inventa un porcentaje universal para declarar éxito; se documenta la razón de cada criterio y se considera crítica cualquier confusión recurrente sobre la función central.

## Registro reproducible

Cada resultado debe archivarse con esta ficha:

```text
ID de prueba:
Fecha y versión:
Pregunta principal:
Soporte:
Fuente de la decisión:
Hipótesis:
Participantes o condiciones:
Tareas:
Qué se observó:
Interpretaciones erróneas:
Datos técnicos o perceptuales:
Limitaciones:
Decisión: mantener / ajustar / reabrir / descartar
Consecuencia para el sistema:
Archivo o prototipo relacionado:
```

La ficha se enlaza desde el registro de decisiones visuales y desde el documento del soporte correspondiente. Si se modifica un archivo ya existente, el cambio y su motivo se agregan al disclaimer del documento.

## Matriz de fundamento y validación

| Principio | Fuente | Decisión posible | Límite | Validación |
|---|---|---|---|---|
| Hacer perceptible la acción y su consecuencia | Norman (2002) | Nombrar acciones y conservar salidas | La claridad teórica no garantiza comprensión | Recorrido cognitivo y tarea |
| Diseñar para errores reversibles | Norman (2002) | Separar reintento, cierre y desarme | Algunos fallos dependen de Android o BLE | Prueba de recuperación y ensayo técnico |
| Comparar color en contexto | Albers (2013) | Probar roles y cantidad de rojo | La percepción cambia entre pantalla, tinta y material | Variantes, contraste y escala de grises |
| Relacionar forma, comunicación y uso | Munari (1971) | Estudiar objeto, editorial y señal como partes funcionales | No selecciona forma industrial | Prototipos, fotografías y prueba situada |
| Integrar soportes sin repetirlos | Isaacson (2011), solo como caso histórico | Auditar experiencia Android–testigo–editorial | El caso biográfico no demuestra usabilidad | Comparación phygital y lectura editorial |
| Asegurar acceso técnico | W3C (2023), Google (2026) | Contraste, foco, texto escalable y objetivos táctiles | El estándar no cubre todo el contexto físico | Auditoría técnica y personas usuarias |

## Referencias

Albers, J. (2013). *Interaction of color* (4th ed.). Yale University Press.

Design Council. (s. f.). *Framework for innovation*. https://www.designcouncil.org.uk/resources/framework-for-innovation/

Google. (2023). *Accessibility*. Android Developers. https://developer.android.com/design/ui/mobile/guides/foundations/accessibility

Google. (2026). *Material Design 3 in Compose*. Android Developers. https://developer.android.com/develop/ui/compose/designsystems/material3

Isaacson, W. (2011). *Steve Jobs* (D. González-Iglesias González, Trad.). [Editorial y edición en español por confirmar].

Munari, B. (1971). *Design as art* (P. Creagh, Trad.). Penguin Books. (Trabajo original publicado en 1966).

Norman, D. A. (2002). *The design of everyday things*. Basic Books.

Sweller, J. (1988). Cognitive load during problem solving: Effects on learning. *Cognitive Science, 12*(2), 257–285. https://doi.org/10.1207/s15516709cog1202_4

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación del protocolo

- **Cambio:** se creó una metodología combinada para auditoría semántica, validación cromática, accesibilidad Android, prueba phygital, documentación editorial y cierre de decisiones.
- **Situación anterior:** v3 describía una secuencia general de evaluación, pero no separaba con suficiente precisión las preguntas, tareas, métricas no moralizantes, puertas de rechazo y registros necesarios para cada soporte.
- **Motivo:** transformar las reglas visuales en afirmaciones comprobables y evitar que una imagen o una preferencia se presente como validación del producto.
- **Decisión de continuidad:** Isaacson se mantiene solo como caso histórico de integración; Norman, Albers y Munari se aplican dentro de sus límites; WCAG y Android se utilizan como criterios técnicos, no como sustitutos de pruebas con personas.

### 2026-08-29 — Verificación de la referencia de accesibilidad

- **Cambio:** se corrigió el año de la guía de accesibilidad de Android a 2023.
- **Situación anterior:** la referencia confundía el año del proyecto con la fecha editorial de la fuente.
- **Motivo:** mantener consistencia APA 7 en el protocolo de validación.
- **Asuntos abiertos:** definir la primera ronda, su muestra y consentimiento, construir el prototipo funcional, preparar la notificación comparativa y realizar las pruebas situadas antes de cerrar color, canal, movimiento y forma física.
