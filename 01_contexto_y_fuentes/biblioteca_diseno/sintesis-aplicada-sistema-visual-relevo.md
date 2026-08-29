# Síntesis aplicada al sistema visual de Relevo

## Propósito y alcance

Esta síntesis traduce cuatro lecturas de diseño al sistema visual vigente de Relevo. No pretende convertirlas en una receta ni cerrar decisiones que todavía necesitan prueba. El proyecto se entiende aquí como un sistema phygital: una aplicación Android organiza y confirma una intención, un primer paso, una condición, un lugar y la relación con un testigo físico; el testigo emite una señal breve situada en el entorno; la persona conserva la decisión de iniciar o no la actividad.

El alcance visual comprende tres superficies relacionadas pero no idénticas: Android, editorial y objeto físico. La investigación de Norman aporta criterios de comprensión y acción; Albers aporta una forma experimental de estudiar el color en contexto; Munari aporta relación entre comunicación, función, material y uso; Isaacson aporta un caso histórico de integración de producto y experiencia. Ninguna de las cuatro obras sustituye las entrevistas, las pruebas con usuarios, la accesibilidad, la factibilidad técnica ni la evaluación del objeto.

## Qué se conserva de cada lectura

| Fuente | Aporte principal | Tipo de fuente | Precaución |
|---|---|---|---|
| Norman (2002) | Affordances percibidas, claves visibles, mapeo, retroalimentación, restricciones, modelos conceptuales, errores y diseño centrado en las personas | Teórica y profesional | No basta para demostrar que una pantalla concreta sea comprensible; debe probarse |
| Albers (2013) | Relatividad perceptual del color, influencia del contexto y aprendizaje mediante ejercicios comparativos | Teórica y experimental | No entrega una paleta universal ni reemplaza pruebas de contraste y accesibilidad |
| Munari (1971) | Comunicación visual, precisión del signo, relación entre forma, material, función, producción y uso | Teórica y profesional | La copia no incluye las secciones finales anunciadas; sus ejemplos no son plantillas |
| Isaacson (2011) | Integración de producto, iteración, simplificación situada y experiencia de extremo a extremo como caso histórico | Histórica y biográfica | No es metodología de diseño ni evidencia de usabilidad; describe un caso particular |

## Principios traducidos a Relevo

### 1. Cada elemento debe poder explicar su papel

Una clave visible permite reconocer qué puede hacerse o qué significa un elemento. El mapeo relaciona una acción con su resultado; la retroalimentación informa qué ocurrió; una restricción reduce acciones erróneas; y un modelo conceptual ayuda a anticipar cómo funciona un sistema (Norman, 2002). En Relevo, estos principios exigen que una persona pueda distinguir entre contenido, elección, acción, icono, estado y gráfico informativo. Esta formulación evita atribuir a la edición revisada el término *signifier*, que no aparece en su capa textual.

La matriz de puntos no debe asumir una función por su apariencia. Si expresa la transferencia entre intención, primer paso y señal situada, es un gráfico informativo y debe acompañarse de texto equivalente. Si no comunica una relación necesaria, es decoración y debe quedar subordinada. El color rojo queda reservado al nodo de señal situada; antes de situar la intención no se utiliza como llamada de acción, selección, advertencia o adorno.

### 2. La configuración precede a la señal

El ciclo debe poder entenderse como una secuencia: definir qué se quiere iniciar, precisar el primer paso observable, escoger la condición pertinente, situar el testigo, comprobar la preparación y dejar que el pulso ocurra físicamente. La aplicación organiza y confirma; no simula el pulso en la pantalla.

Esta secuencia traduce el ciclo de acción de Norman: una intención necesita una acción ejecutable y una evaluación comprensible. También evita que la interfaz prometa una automatización que el sistema no ofrece. La redacción debe describir qué queda configurado y qué ocurrirá después, sin presentar una intención como conducta cumplida.

### 3. El color se decide en relación

Albers muestra que la percepción de un color cambia según el fondo, los colores próximos, la cantidad, la iluminación y el soporte. Por eso, la paleta de Relevo no puede cerrarse mediante valores hexadecimales aislados. Cada combinación debe revisarse en la pantalla Android, en impresos editoriales y junto a los materiales del objeto.

La dirección vigente parte de un modo oscuro: canvas `#111314`, superficie `#1B1D1E`, superficie quiet `#242728`, texto principal `#F1F1F1`, texto secundario `#B6B8B7`, regla `#3A3D3E`, borde funcional `#767A79` y señal `#EF3E45`. Estos valores son puntos de partida del sistema, no una garantía automática de accesibilidad. El rojo tiene una sola función semántica: identificar la señal situada una vez que esa condición forma parte del ciclo. Su contraste y su lectura deben probarse junto a blanco, gris y negro, y no deben ser la única manera de comunicar un estado.

### 4. La identidad debe servir a la comunicación

Munari relaciona signos, formas, colores y relaciones con la posibilidad de evitar interpretaciones equivocadas. La identidad de Relevo puede usar una retícula precisa, tipografía funcional, puntos y reglas, pero debe dejar que el contenido sea el primer nivel de lectura. La expresión visual no puede convertir una elección en una ilustración ni un estado en un botón.

El alfabeto de puntos queda acotado a la marca y a una señal expresiva breve. Para textos largos se usa IBM Plex Sans; para metadatos y valores técnicos, IBM Plex Mono. La escala, el espaciado y el ancho de lectura deben ajustarse a la distancia y al tiempo disponible. El editorial puede ampliar el lenguaje gráfico mediante diagramas, secuencias y ejemplos; no debe exigir que el lector descifre un código que la aplicación nunca explica.

### 5. El sistema incluye condiciones materiales

Munari y el enfoque de integración descrito por Isaacson permiten preguntar por el ciclo completo: fabricación, montaje, transporte, instalación, limpieza, reparación, energía y desgaste. En Relevo, el testigo físico no se resuelve solo por su apariencia. Su forma industrial, material y mecanismo permanecen abiertos hasta que existan pruebas de visibilidad de la señal, seguridad, mantenimiento, costo y pertinencia contextual.

El principio de integración no significa que todas las superficies deban verse iguales. Android debe permitir configurar y confirmar; el objeto debe emitir una señal ambiental breve y reconocible; el editorial debe explicar, documentar y hacer visible la relación entre ambos. La coherencia se busca en principios, proporciones, ritmo y semántica, no en repetir componentes literalmente.

## Traducción por superficie

### Android

La aplicación debe priorizar comprensión y recuperación. Cada pantalla necesita un objetivo principal, una acción dominante cuando corresponda y un estado que no parezca pulsable. Las elecciones deben tener límites visibles y estados seleccionado/no seleccionado que no dependan solamente del color. Los iconos deben ser convencionales, escasos, etiquetados para tecnologías de asistencia y provistos de un objetivo táctil suficiente cuando sean interactivos.

El modo oscuro vigente se organiza con una retícula estable, pocas formas redondeadas, jerarquía tipográfica y reglas de separación. Las tarjetas no deben convertirse en la unidad universal de contenido. Una agrupación lineal, una lista o una secuencia de reglas puede comunicar mejor la relación entre pasos y reducir la apariencia de un tablero de métricas. Se excluyen rachas, progreso, premios, evaluación, culpa, moralización y métricas de cumplimiento porque cambiarían el sentido del proyecto: Relevo devuelve una intención a la situación, no califica a la persona.

### Editorial

El editorial puede funcionar como una explicación del sistema y de sus decisiones. Conviene organizarlo en capas: propósito y problema; personas y situaciones; funcionamiento; relación entre aplicación, señal y contexto; criterios visuales; exploraciones; pruebas; límites y próximos pasos. La matriz de puntos puede actuar como diagrama cuando incluya una leyenda verbal y una secuencia legible. Las fotografías deben mostrar situación, escala y relación con el entorno; no deberían fijar como definitiva una forma de objeto todavía en exploración.

El texto debe diferenciar evidencia de interpretación. Una observación de las entrevistas se presenta como hallazgo de esas entrevistas; una regla de color, como decisión de diseño sustentada en Albers y comprobada mediante contraste; una decisión del objeto, como hipótesis hasta que existan prototipos y pruebas. El editorial no debe presentar una referencia histórica como prueba de que Relevo funcionará.

### Objeto phygital

El objeto debe estudiarse mediante prototipos antes de decidir su forma final. Las preguntas inmediatas son: ¿se reconoce cuándo está preparado?, ¿la señal se percibe sin exigir mirar el teléfono?, ¿la intensidad es breve y suficiente?, ¿se confunde con una notificación del entorno?, ¿se puede instalar y mantener?, ¿qué ocurre con la energía y la conexión?, ¿qué información necesita la persona para confiar en el sistema?

La señal física no debe ser reemplazada por una animación equivalente en Android. La aplicación puede mostrar preparación, enlace, condición y fallos; el evento situado debe ocurrir en el testigo. La forma, la materialidad, el mecanismo y la escala son variables de investigación, no conclusiones de esta síntesis.

## Criterios de accesibilidad y comprensión

Los principios visuales deben verificarse junto a criterios de accesibilidad, no solo por semejanza estética. Como mínimo, el sistema debe considerar:

- contraste suficiente entre texto y fondo, y entre controles y superficies;
- información redundante mediante texto, forma, posición o patrón, sin depender solo del color;
- tamaños legibles y objetivos táctiles adecuados para Android;
- orden de foco y nombres accesibles para controles interactivos;
- lenguaje directo para condiciones, confirmaciones, errores y recuperación;
- ausencia de movimiento o destellos que puedan distraer o causar malestar;
- percepción de la señal física en condiciones de luz, ruido y distancia plausibles;
- equivalentes editoriales para diagramas, puntos y fotografías informativas.

Estos criterios deben contrastarse con la versión vigente de las pautas de accesibilidad que se adopte para la implementación. Las lecturas de esta biblioteca no sustituyen esa especificación.

## Experimentos y pruebas necesarias

| Pregunta | Prueba propuesta | Evidencia esperada |
|---|---|---|
| ¿Se comprende la diferencia entre intención y primer paso? | Mostrar una pantalla de configuración sin explicación oral y pedir que se reformule cada término | Reformulaciones correctas y registro de ambigüedades |
| ¿Las elecciones se distinguen de acciones y estados? | Prueba de clasificación con pantallas estáticas y prototipo navegable | Identificación del elemento que se puede escoger, activar o solo leer |
| ¿La secuencia de configuración prepara la situación real? | Recorrido completo Android–testigo–actividad con una tarea concreta | Errores, dudas, retrocesos y puntos donde se pierde el modelo conceptual |
| ¿El gráfico de puntos comunica transferencia? | Comparar versión con puntos, texto equivalente y versión sin puntos | Explicación espontánea de la relación; el gráfico no se aprueba por gusto |
| ¿El rojo conserva un único significado? | Presentar estados previos y posteriores a situar la señal en condiciones claras y oscuras | El rojo se identifica solo con señal situada, sin aparecer antes ni competir con acciones |
| ¿La paleta se mantiene legible en contexto? | Pruebas de contraste y percepción con fondos, tamaños, brillo y soportes reales | Valores documentados, fallos y ajustes por combinación, no solo por color aislado |
| ¿El testigo se percibe y no interrumpe? | Prototipos de baja fidelidad en el lugar de uso, con variaciones de luz y distancia | Detección, interpretación, tiempo de respuesta y falsas alarmas |
| ¿La forma del objeto puede producirse y mantenerse? | Revisión de materiales, montaje, energía, reparación, limpieza y costos | Restricciones y decisiones justificadas antes de cerrar la forma |
| ¿La explicación editorial permite reconstruir el sistema? | Lectura independiente del documento y entrevista breve de comprensión | Qué puede explicar la persona sin ayuda y qué debe reescribirse |

## Matriz de principio, decisión y límite

| Principio | Fuente | Decisión posible en Relevo | Límite | Validación |
|---|---|---|---|---|
| Hacer visible qué puede hacerse | Norman (2002) | Diferenciar elecciones, acciones y estados con estructura, texto y estados explícitos | Una convención visual puede no ser conocida por todos | Clasificación y prueba de tarea |
| Relacionar acción y consecuencia | Norman (2002) | Informar qué se configura y qué ocurrirá con el testigo antes de confirmar | El texto no compensa una lógica técnica confusa | Recorrido Android–objeto y análisis de errores |
| Usar retroalimentación pertinente | Norman (2002) | Confirmar enlace, preparación y fallos sin simular el pulso físico | Más avisos pueden aumentar ruido y dependencia del teléfono | Prueba de comprensión de estados y recuperación |
| Diseñar para el error y la reversibilidad | Norman (2002) | Permitir revisar o deshacer una configuración sin castigo ni evaluación | No todo fallo técnico puede revertirse desde la interfaz | Prueba de recuperación y revisión técnica |
| Entender el color en contexto | Albers (2013) | Probar la paleta oscura y el rojo situado en combinaciones reales | La percepción varía con soporte, iluminación y persona | Contraste, simulación y pruebas situadas |
| Enseñar mediante comparación y experimento | Albers (2013) | Comparar variantes de fondo, señal y texto antes de cerrar el sistema | Un experimento visual no prueba preferencia de uso prolongado | Registro de resultados y prueba de comprensión |
| Hacer que los signos reduzcan errores de lectura | Munari (1971) | Acompañar los puntos con una leyenda y conservar una jerarquía verbal | El significado depende de contexto y convenciones | Lectura editorial sin explicación oral |
| Relacionar forma, material y uso | Munari (1971) | Investigar instalación, señal, mantenimiento y transporte del testigo | Los ejemplos del libro no predicen el material adecuado | Prototipos y revisión de producción |
| Diseñar la experiencia de extremo a extremo | Isaacson (2011) | Auditar la continuidad entre app, testigo y editorial | El caso descrito es particular y no prueba eficacia | Prueba de sistema completo con usuarios |
| Resolver complejidad antes de exponerla | Isaacson (2011) | Reducir decisiones visibles solo donde la lógica ya esté clara | La reducción puede ocultar información necesaria | Comparación de alternativas y registro de omisiones |
| Iterar sin confundir refinamiento con validación | Isaacson (2011) | Mantener versiones y criterios de revisión para app, gráfica y objeto | Pulir una apariencia no demuestra que funcione | Prototipos, pruebas y decisión documentada |

## Tensiones entre las fuentes

Las lecturas no dicen exactamente lo mismo. Norman prioriza la comprensión de la acción y la prevención del error; una interfaz de Relevo debe ser explícita aunque eso agregue texto. Munari valora la precisión y la comunicación visual, pero también advierte que el significado depende del contexto; por eso una solución gráfica no debe considerarse universal. Albers impulsa la experimentación perceptual, mientras que la accesibilidad exige que el sistema no dependa de una impresión cromática particular. Isaacson muestra el valor de la integración y la reducción de complejidad en un caso histórico, pero Norman recuerda que hacer algo simple en apariencia puede esconder un modelo conceptual pobre.

Estas tensiones se resuelven por función y prueba. La economía visual se mantiene si no reduce la comprensión; la expresividad cromática se conserva si no elimina redundancias; la integración se busca si respeta los límites de cada soporte; y la iteración se considera avance solo cuando responde a un criterio observado.

## No usar como justificación

Las cuatro obras no deben usarse para justificar por sí solas:

- que el sistema phygital cambiará la conducta, reducirá el tiempo de pantalla o mejorará la memoria;
- que Android es superior a la web o a iOS sin una comparación de alcance, factibilidad, privacidad, permisos, mantenimiento y usuarios;
- que una pantalla, una paleta, una tipografía o una matriz de puntos es accesible porque se ve ordenada;
- que una forma específica del testigo físico es la correcta antes de probar señal, instalación, material, energía, seguridad y costo;
- que una referencia biográfica constituye una metodología o una prueba de usabilidad;
- que una intención configurada equivale a una actividad iniciada o cumplida;
- que el gusto del equipo o la semejanza con un referente reemplaza la evidencia de investigación;
- que la ausencia de una métrica significa que no puede evaluarse el sistema: Relevo puede medir comprensión, errores, recuperación, detección de señal y adecuación contextual sin calificar moralmente a la persona.

## Cierre operativo

La biblioteca sostiene una dirección clara, pero no una solución cerrada. El siguiente desarrollo debe tomar una sola pregunta prioritaria y producir una evidencia concreta: comprensión de una configuración, percepción de una señal o viabilidad de un prototipo. Cada avance debe registrar qué se decidió, con qué fuente o hallazgo se relaciona, qué queda como hipótesis y cómo se probará. Así, el lenguaje visual no se separa de la memoria ni del producto: expresa una investigación que todavía puede corregirse.

---

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación de la síntesis aplicada

- **Cambio:** se integraron los cuatro resúmenes en principios para Android, editorial y objeto phygital; se añadieron criterios de accesibilidad, experimentos, matriz de decisiones, tensiones entre fuentes y una sección explícita de límites de justificación.
- **Situación anterior:** las obras estaban disponibles como archivos independientes y algunas ideas aparecían dispersas en la memoria y en la dirección visual, sin una traducción común ni una separación sistemática entre evidencia, decisión e hipótesis.
- **Motivo:** convertir la biblioteca en una herramienta de trabajo para cerrar decisiones con fundamento y validación, manteniendo abierta la forma industrial del objeto.
- **Asunto abierto:** completar las pruebas con usuarios, accesibilidad, prototipos físicos, costos y factibilidad técnica; confirmar los datos editoriales faltantes antes de cerrar la bibliografía de la memoria.

### 2026-08-29 — Precisión terminológica de Norman

- **Cambio:** se reemplazó la atribución de significantes a la edición de 2002 por affordances percibidas y claves visibles.
- **Situación anterior:** la síntesis mezclaba el contenido comprobado en esta copia con terminología desarrollada por Norman en ediciones posteriores.
- **Motivo:** mantener la trazabilidad entre cada principio y la fuente efectivamente leída.
