# Auditoría 4 — Estado del arte, mercado actual y referentes

**Proyecto:** Relevo, Proyecto de Título de Diseño, Universidad Diego Portales

**Agente:** Luna Max, auditoría especializada de mercado y referentes

**Fecha de corte:** 24 de agosto de 2026

**Estado:** informe de auditoría para integración; no sustituye todavía el capítulo 6 de la memoria vigente
**Alcance:** estado del arte, mercado, mecanismos de intervención, modelos de valor, fricciones, adopción, límites, tendencias y referentes de Relevo.

## 1. Resultado ejecutivo

El capítulo 6 de la memoria vigente tiene una dirección conceptual correcta: organiza el mercado por mecanismos de intervención y advierte que las afirmaciones comerciales no equivalen a evidencia independiente. Para un Proyecto de Título, sin embargo, todavía no alcanza un estándar suficiente de estado del arte. La principal debilidad no es la falta de productos mencionados, sino la ausencia de una arquitectura documental que permita responder, con fuentes diferenciadas, qué mecanismo se ofrece, qué problema resuelve, para quién, bajo qué condiciones se adopta, qué evidencia existe, qué costos introduce y qué queda sin resolver.

La revisión externa realizada hasta el 24 de agosto de 2026 modifica una conclusión importante de la memoria: ya no es defendible presentar el mercado como si estuviera concentrado únicamente en medir, bloquear o retrasar. Esas familias continúan siendo dominantes, pero el campo actual también incluye fricciones deliberativas en el sistema operativo, aplicaciones que introducen pausas configurables, objetos físicos para activar restricciones, dispositivos de foco y hábitos con etiquetas situadas, y propuestas que intentan recuperar el compromiso mediante adaptación o reconfiguración. Google, por ejemplo, incorporó Pause Point como una pausa de diez segundos con alternativas y preguntas de intención, aunque la documentación vigente indica que su disponibilidad está limitada a teléfonos Pixel 11 con Android 17 (Google, 2026; Google, s. f.-a). Esa función convierte a la notificación reflexiva en un competidor más directo para Relevo de lo que la memoria actual reconoce.

La oportunidad de Relevo sigue siendo defendible, pero debe formularse con mayor precisión y modestia. No consiste en descubrir un mercado sin antecedentes ni en afirmar que nadie ha diseñado un objeto para el bienestar digital. Tampoco consiste en ser un bloqueador físico más. La opción de oportunidad es investigar si una intención autoelegida puede externalizarse parcialmente mediante un sistema en que:

- la aplicación conserva el contenido semántico de la intención;
- un objeto físico sin pantalla funciona como clave perceptible, no como llave de bloqueo;
- el objeto se sitúa junto al primer paso de una actividad elegida;
- la señal devuelve la intención sin calificar la conducta;
- continuar usando el teléfono permanece disponible; y
- el conjunto aporta un valor perceptible frente a una notificación equivalente.

La frase decisiva es **si aporta un valor perceptible**. La literatura sobre herramientas de autocontrol digital muestra efectos pequeños o medios en reducción de uso, pero también estudios breves, retorno de hábitos al retirar la intervención, dificultades de adopción y abandono. La literatura sobre descarga de intenciones respalda la utilidad de las claves externas y muestra que el costo físico de configurarlas afecta su uso; no demuestra que el testigo de Relevo recupere una intención de ocio en un hogar chileno. Por tanto, el capítulo debe presentar la combinación propuesta como una hipótesis de diseño abierta a comparación, no como una ventaja ya demostrada.

### Veredicto general

| Dimensión auditada | Veredicto | Acción necesaria |
| --- | --- | --- |
| Organización por mecanismos | Mantener | Conservar la lógica del capítulo, pero hacer explícitos los criterios de comparación. |
| Evidencia académica | Ampliar y actualizar | Incorporar metaanálisis, estudios longitudinales, adopción y descarga de intenciones. |
| Mercado actual | Reemplazar parcialmente | Añadir herramientas nativas, Pause Point y referentes físicos vigentes con compatibilidad y modelo económico actualizados. |
| Referentes comerciales | Depurar | Separar prestaciones verificables de promesas de eficacia y de testimonios comerciales. |
| Oportunidad de Relevo | Reemplazar la formulación actual | Pasar de un vacío casi categórico a una oportunidad acotada por el corpus consultado. |
| Adopción y sostenibilidad de uso | Ampliar críticamente | Incorporar costos de configuración, compatibilidad, habituación, abandono, mantenimiento y modelo de pago. |
| Comparación con notificación | Elevar a criterio central | Debe ser una puerta temprana de decisión, no una comparación secundaria. |
| Relación con el objeto sin pantalla | Mantener con cautela | La ausencia de pantalla es una decisión de investigación, no una prueba de valor ni de novedad. |

## 2. Corpus revisado y calidad de las afirmaciones

Se leyeron completos `INSTRUCCIONES_CHATGPT.md`, `00_gobernanza/directrices-de-trabajo.md`, `08_memoria/memoria-vigente.md`, `08_memoria/matriz-incorporacion-feedback-e15.md` y `04_mercado_y_referentes/README.md`. La carpeta `04_mercado_y_referentes` contiene actualmente solo su README; no existe todavía un registro de búsqueda, una ficha por fuente, una matriz de inclusión y exclusión ni un archivo que conserve la fecha y el criterio con que se verificó cada referente. Por eso, el capítulo 6 de la memoria contiene más desarrollo que la carpeta que debería sostenerlo.

La comprobación complementaria se realizó con DOI, páginas de editoriales o repositorios académicos y sitios oficiales de los productos. Se priorizaron fuentes de 2019 en adelante. Las páginas comerciales se consultaron para verificar funciones, compatibilidad, precio mostrado, disponibilidad declarada y modelo de negocio; no se usaron para probar eficacia.

### 2.1 Jerarquía de evidencia que debe conservarse

| Tipo de material | Puede sostener | No puede sostener por sí solo |
| --- | --- | --- |
| Revisión sistemática o metaanálisis | Tendencias de mecanismos, calidad global de la evidencia, límites metodológicos y magnitud agregada cuando está disponible. | Que una solución específica funcione para el público de Relevo. |
| Estudio experimental o longitudinal | Efectos observados bajo un protocolo, población y duración concretos. | Transferir el resultado a otro mecanismo, otra población o un objeto distinto. |
| Artículo de diseño o estudio de campo | Decisiones de interacción, experiencias, adopción y problemas de uso dentro de su contexto. | Una ley general del mercado o una prueba de demanda. |
| Sitio oficial del producto | Funciones declaradas, compatibilidad, precio visible, requisitos, modelo de pago y promesas del fabricante. | Eficacia independiente, satisfacción representativa o adopción real. |
| Tienda de aplicaciones o plataforma | Disponibilidad, versión, permisos o descripción declarada. | Validación científica de sus resultados. |
| Reseña, testimonio o nota de prensa | Recepción pública, lenguaje de mercado o indicios de circulación. | Evidencia de que el mecanismo produce el resultado prometido. |
| Entrevistas P1–P8 | Necesidades, experiencias y contrapuntos situados en el corpus de Relevo. | Tamaño del mercado, prevalencia o preferencia general por un producto. |
| Feedback docente | Problemas de claridad, prioridades y exigencias de desarrollo. | Evidencia empírica sobre eficacia, mercado o usuarios. |

Esta separación debe aparecer en la memoria mediante verbos precisos. Una página oficial **declara**, un paper **observa** o **estima**, una entrevista **relata**, y el investigador **interpreta** o **propone**. No debe utilizarse el mismo tono para las cuatro operaciones.

## 3. Diagnóstico de la memoria vigente

### 3.1 Lo que debe mantenerse

1. La decisión de organizar el estado del arte por mecanismos y no por semejanza formal es acertada. Evita que una lista de objetos parecidos se convierta artificialmente en argumento.

2. La distinción entre literatura académica, documentación técnica y comunicación comercial es indispensable y debe conservarse como regla explícita de lectura.

3. La memoria reconoce correctamente que un bloqueo no es necesariamente incorrecto y que una intervención no restrictiva no es automáticamente superior. Esa cautela debe mantenerse.

4. La comparación con una notificación aparece como condición de valor. Debe conservarse, pero pasar de una comparación secundaria a una prueba temprana y estructurante.

5. La formulación del vacío es provisional y evita declarar una inexistencia absoluta. La intención es correcta; la redacción todavía necesita acotar el corpus y hacer visible el método de búsqueda.

6. El objeto físico sin pantalla se presenta como una decisión de diseño con un problema investigable: la asociación entre testigo, lugar e intención. Esto es más sólido que tratar la ausencia de pantalla como una cualidad estética suficiente.

### 3.2 Lo que debe reemplazarse o profundizarse

#### a. El capítulo describe el mercado, pero no registra cómo fue construido

El lector no puede saber qué bases se consultaron, qué términos se usaron, qué periodo se cubrió, por qué se eligieron esos referentes, qué productos quedaron fuera ni en qué fecha se verificó cada afirmación. La frase «en la revisión preliminar» no basta para un proyecto de título porque transforma una búsqueda no documentada en una base de conclusión.

**Corrección:** crear un registro de búsqueda y fichas de fuente antes de cerrar la nueva versión del capítulo. El registro no necesita fingir una revisión sistemática si no se realizó como tal; debe declarar honestamente que se trata de una búsqueda exploratoria orientada por mecanismos, con fecha de corte, fuentes consultadas, palabras clave, criterios de inclusión y límites.

#### b. El panorama actual está desactualizado por una modificación del propio sistema operativo

La memoria coloca a Pause Point como un ejemplo de fricción, pero la referencia actual lo trata como una comunicación de Google de mayo de 2026 y no registra su disponibilidad limitada a Pixel 11 con Android 17. Este detalle cambia el análisis de compatibilidad y competencia: el mecanismo existe, pero no es universal dentro de Android.

**Corrección:** actualizar el referente como función nativa reciente, señalar alcance de plataforma y distinguir tres cosas: disponibilidad anunciada, disponibilidad efectiva según dispositivo y evidencia independiente de eficacia. Google describe la pausa, las alternativas y el reinicio requerido para desactivar la función; esa descripción no equivale a una evaluación independiente.

#### c. Las aplicaciones de fricción tienen evidencia desigual y la memoria la agrupa demasiado rápido

one sec es un referente comercial, pero también cuenta con estudios académicos específicos. El estudio de Grüning et al. (2023) encontró, en un experimento de campo de seis semanas con 280 participantes, una reducción de las aperturas de las aplicaciones objetivo y observó que la opción de descartar la apertura fue el componente con mayor efecto en el experimento desagregado. Esto informa el mecanismo de interrupción, no demuestra que una señal física produzca el mismo resultado. Además, la participación de un autor vinculado a la empresa obliga a explicitar el conflicto de interés al interpretar el resultado.

La investigación longitudinal de Haliburton et al. (2024), con datos de uso real de 1.039 usuarios de una aplicación comercial, es valiosa para hablar de duración y patrones de uso, pero no funciona como experimento aleatorizado. Debe presentarse como evidencia de comportamiento en contexto real, con límites de selección y causalidad.

**Corrección:** cada referente comercial que tenga investigación propia debe tener dos fichas: una de producto y otra de evidencia. No se deben fusionar características, resultados publicados, testimonios y promesas en una sola celda.

#### d. La categoría de objetos físicos está descrita casi exclusivamente como restricción

Brick, Unpluq y Screenless sí son relevantes, pero la memoria actual los reúne como si el objeto físico fuera una sola solución. Los tres usan el objeto principalmente como llave, barrera o mecanismo de desbloqueo. Sus diferencias son significativas:

- Brick declara un dispositivo físico que activa sesiones de bloqueo mediante contacto, con aplicación para Android e iOS, sin suscripción y con precio visible de 59 dólares estadounidenses.
- Unpluq utiliza una etiqueta NFC y una aplicación para bloquear aplicaciones; la página oficial muestra una suscripción y barreras digitales adicionales.
- Screenless Breaker utiliza NFC pasivo, no requiere batería ni internet según su sitio, pero la compatibilidad vigente está restringida a iOS y iPadOS; Android aparece como plan futuro.

La semejanza material no debe ocultar la diferencia de valor: para estos productos el objeto agrega distancia y dificultad de acceso; para Relevo el objeto debería agregar contexto y recuperación sin convertirse en barrera.

**Corrección:** separar «objeto como llave de restricción» de «objeto como clave de recuperación». Esta última es la categoría donde Relevo puede formular una contribución investigable, no un hecho de mercado.

#### e. Falta un referente físico actual que trabaje el inicio de una actividad y la construcción de hábitos

Focusaur debe mantenerse, pero con una clasificación más precisa. Su sitio presenta un dispositivo físico con controles, sesiones de foco, detección del movimiento del teléfono, etiquetas NFC para iniciar sesiones o registrar hábitos, recompensas gamificadas y aplicación para iOS y Android. El precio mostrado al momento de la revisión es de 129 dólares en oferta frente a 169 dólares, y la empresa informa que el producto proviene de una campaña de Kickstarter de 2026. Es un referente importante porque muestra una tendencia de mercado hacia objetos físicos que acompañan la activación de actividades y hábitos.

No debe presentarse como evidencia de que el formato funciona. Sus funciones persiguen foco, productividad y seguimiento de hábitos; además, incorpora gamificación, planificación y funciones de aplicación que lo alejan del objetivo de Relevo. Es un referente de categoría, modelo de valor y riesgos de expansión, no un antecedente que valide la hipótesis de memoria prospectiva.

#### f. El vacío se formula todavía demasiado cerca de la exclusividad

La frase vigente afirma que no se identificó una solución que reúna simultáneamente varios atributos de Relevo. Aunque está acompañada por una cautela, la formulación sigue siendo débil porque la búsqueda no está documentada y porque los atributos pueden combinarse en proyectos, prototipos o productos no indexados de distintas maneras.

**Corrección recomendada:**

> En el corpus académico, técnico y comercial consultado hasta el 24 de agosto de 2026 no se encontró un producto vigente que, según la información pública revisada, combine explícitamente una intención de ocio formulada por la persona, una condición digital seleccionada, un objeto físico sin pantalla situado junto a un primer paso fuera de la pantalla y ausencia de bloqueo o registro de cumplimiento. Este resultado delimita una oportunidad de investigación dentro del corpus revisado; no demuestra inexistencia absoluta ni superioridad de Relevo.

La formulación solo debe permanecer si se acompaña por un registro de búsqueda que permita reconstruir qué significa «corpus consultado».

## 4. Síntesis por mecanismos

El mercado debe leerse como un conjunto de estrategias que modifican la relación entre una persona, una aplicación, una intención y el contexto de acción. La pregunta no es qué producto se parece visualmente a Relevo, sino qué operación realiza y qué costo introduce.

### 4.1 Medición, autoconocimiento y límites nativos

Android Digital Wellbeing permite visualizar tiempo de uso, aperturas, notificaciones, temporizadores, Focus mode y Bedtime mode. Apple Screen Time permite consultar actividad, definir límites por aplicación o categoría, programar periodos de desconexión y compartir configuraciones entre dispositivos. Estos servicios tienen una ventaja estructural: están integrados al sistema operativo, no exigen comprar un objeto y poseen acceso privilegiado a los datos de uso.

Su modelo de valor es de infraestructura incluida: la persona recibe información y controles sin pagar directamente por la función. Su fricción principal es de descubrimiento, configuración y mantenimiento. Además, la intervención permanece en el dispositivo que concentra la atención. Google declara expresamente que Digital Wellbeing es informativo y no garantiza resultados específicos; esa advertencia es significativa porque la propia plataforma distingue entre proporcionar control y producir bienestar.

La evidencia académica limita la idea de que ver estadísticas sea suficiente. Biedermann et al. (2021) encontraron que las intervenciones basadas únicamente en aumentar conciencia mostraban efectos escasos. Monge Roffarello y De Russis (2023) encontraron que las herramientas evaluadas se apoyaban con frecuencia en autoseguimiento, temporizadores y bloqueo, y que el campo necesitaba estudios más largos y medidas comparables.

**Qué informa a Relevo:** una notificación o un límite nativo es la alternativa de menor costo y mayor disponibilidad. Si Relevo no demuestra un aporte que una solución integrada no puede ofrecer —por ejemplo, recuperación situada sin reabrir la pantalla—, el hardware no está justificado.

**Qué no debe afirmarse:** que las herramientas nativas no funcionan. Lo correcto es decir que su mecanismo principal es medir, limitar o pausar dentro del dispositivo y que no aborda directamente la asociación material entre una intención futura y un lugar de acción.

### 4.2 Fricción, pausa y deliberación dentro del teléfono

La fricción aumenta el tiempo, el esfuerzo o la deliberación necesarios para acceder a una aplicación sin necesariamente eliminarla. one sec intercepta la apertura de aplicaciones configuradas y ofrece intervenciones como respiración, espera, reflexión o salida. Grüning et al. (2023) observaron una reducción relevante en las aperturas de aplicaciones objetivo durante seis semanas; el efecto no debe generalizarse a cualquier fricción ni a cualquier público. Haliburton et al. (2024) analizaron la interacción de usuarios reales con fricciones durante un periodo longitudinal, aportando información sobre uso sostenido que los estudios breves suelen omitir.

Pause Point amplía esta familia dentro del sistema operativo: Google lo describe como una pausa de diez segundos que puede incluir respiración, temporizador, fotografías o sugerencias de otras aplicaciones; la desactivación exige reiniciar el teléfono. La función responde de forma directa al uso automático, pero sigue dependiendo de que la persona mire e interactúe con el teléfono en el instante de la intervención.

El trabajo de Monge Roffarello y De Russis (2024) sobre StepByStep también es relevante porque desplaza el propósito desde la simple restricción hacia el aprendizaje de una regulación más intencional. Sus dos estudios en contexto real, con 8 y 41 participantes, deben interpretarse como exploración acotada, no como evidencia general de eficacia.

**Fortalezas del mecanismo:** baja barrera material, configuración centralizada, posibilidad de intervenir justo al abrir la aplicación y opción de conservar el acceso.

**Fricciones y límites:** la intervención usa el mismo dispositivo que se intenta dejar; puede sentirse repetitiva o molesta; puede exigir configuración por aplicación; no necesariamente ofrece una alternativa situada; y puede perder efecto con la habituación. En plataformas de doble propósito, bloquear o pausar una aplicación puede impedir tanto el uso problemático como el uso legítimo.

**Qué informa a Relevo:** la comparación con una pausa en pantalla debe medir si el objeto permite recuperar la intención sin aumentar la exposición al teléfono. La sola existencia de una señal física no constituye valor agregado.

### 4.3 Bloqueo, barrera y separación física

Brick, Unpluq y Screenless representan una familia distinta: el objeto no recuerda una actividad alternativa, sino que hace más difícil acceder a aplicaciones seleccionadas o volver a habilitarlas.

| Referente | Mecanismo declarado | Modelo de valor | Fricción principal | Límite para Relevo |
| --- | --- | --- | --- | --- |
| Brick | El teléfono se toca con un objeto físico para activar modos de bloqueo. | Compra única de hardware y aplicación sin suscripción declarada. | Requiere tener el objeto y aceptar una restricción; agrega distancia física. | Resuelve control de acceso, no recuperación de una intención alternativa. |
| Unpluq | Una etiqueta NFC y barreras digitales bloquean aplicaciones; la etiqueta permite abrirlas. | Hardware más suscripción premium, con horarios y estadísticas. | Dependencia de NFC, aplicación, suscripción y disponibilidad de la etiqueta. | El objeto funciona como llave, no como señal contextual no semántica. |
| Screenless Breaker | Un objeto NFC pasivo permite desbloquear aplicaciones bloqueadas. | Compra de objeto; el sitio declara ausencia de cuenta, nube y batería. | Compatibilidad vigente con iOS/iPadOS y dependencia de la aplicación. | La barrera es incompatible con el alcance no punitivo de Relevo. |

Sus propuestas muestran que hay disposición de mercado para comprar una acción física cuando el software se considera fácil de ignorar. También muestran el costo de la estrategia: una barrera debe ser suficientemente difícil de superar para tener sentido, pero esa misma dificultad puede volverla inaceptable cuando las aplicaciones tienen usos legítimos o cuando la necesidad de acceso cambia.

Biedermann et al. (2021) encontraron que las sanciones o bloqueos tienden a operar cuando son difíciles de eludir; Biedermann et al. (2024) documentaron que algunos usuarios abandonaron herramientas por ser demasiado restrictivas o porque interferían con tareas que necesitaban realizar. Esto no invalida el bloqueo: define para quién, cuándo y con qué intensidad puede funcionar.

**Qué informa a Relevo:** la propuesta no debe competir prometiendo una restricción más fuerte. Debe demostrar que el objeto puede ser útil precisamente cuando la persona no quiere un bloqueo, sino recordar una alternativa elegida. La prueba contra una notificación debe ir acompañada por una prueba contra un objeto de bloqueo para verificar que el valor no proviene simplemente de introducir dificultad.

### 4.4 Objetos físicos para foco, hábitos y activación de actividades

Focusaur es el referente vigente más útil para esta familia. Su página presenta un objeto con controles físicos, sesiones de foco, modo de concentración que detecta el movimiento del teléfono, etiquetas NFC para iniciar sesiones o registrar hábitos, recompensas de dinosaurios, agenda y aplicación móvil. El sitio declara funcionamiento parcial sin conexión y un modelo de aplicación básica más funciones Pro. También declara un precio de lanzamiento y una campaña de Kickstarter, que deben conservarse como datos comerciales observados en la fecha de corte, no como garantía de sostenibilidad.

Focusaur informa tres cuestiones relevantes:

1. El mercado acepta que un objeto físico pueda iniciar una actividad sin abrir primero la aplicación.
2. El objeto puede funcionar como interfaz ritual o recordatorio de un contexto, especialmente mediante etiquetas NFC.
3. La acumulación de funciones —foco, hábitos, agenda, recompensas y entrenador— puede desplazar el producto desde una intervención clara hacia una plataforma de productividad.

Relevo debe conservar el aprendizaje de la activación física, pero proteger su alcance: una intención activa, un primer paso, una señal y una salida autónoma. Si el producto incorpora seguimiento, rachas, puntos, agenda, múltiples intenciones o recomendaciones, aumentará la carga y perderá la diferencia que intenta investigar.

### 4.5 Descarga de intenciones y recordatorios externos

La descarga de intenciones es el mecanismo académico que más directamente informa Relevo. Consiste en usar señales, objetos, listas o arreglos del entorno para reducir la carga de mantener una intención en la memoria. Gilbert et al. (2023) revisan la evidencia y concluyen que la descarga puede ser eficaz y está guiada por decisiones metacognitivas. Chiu y Gilbert (2024) realizaron dos experimentos preregistrados y observaron que, cuando configurar un recordatorio exigía más esfuerzo físico, las personas lo utilizaban menos; los recordatorios de bajo esfuerzo ayudaban a compensar el aumento de carga de memoria con más eficacia que los de alto esfuerzo.

Este resultado impone una restricción concreta a Relevo: el valor de ser físico no autoriza una configuración pesada. Emparejar, escribir la intención, elegir la condición, situar el objeto, comprobar la señal y armar la regla deben formar una secuencia corta, comprensible y reversible. El objeto no puede exigir un ritual más costoso que la acción que pretende volver disponible.

Los estudios de memoria prospectiva situada y los antecedentes de recordatorios tangibles respaldan la plausibilidad del mecanismo, pero no validan la propuesta completa. Un recordatorio colocado junto a unas zapatillas no garantiza que una persona se levante; un objeto sin texto puede ser perceptible y, aun así, no recuperar qué intención representa. El punto exacto que todavía falta investigar es la relación entre señal no semántica, ubicación congruente y recuperación de una intención de ocio.

La referencia *The Tangible Reminder* (Hermann et al., 2007) debe mantenerse solo como antecedente histórico de interacción tangible. No debe presentarse como evidencia del mercado actual ni como prueba contemporánea de adopción.

### 4.6 Señales ambientales y multimodales

Las señales de luz, sonido y vibración pertenecen a una familia de comunicación ambiental. La literatura sobre notificaciones multisensoriales y perceptibilidad permite discutir alcance, atención, intrusión, superficie, línea de visión y convivencia. No permite afirmar que un patrón concreto de diez segundos, un color coral o una frecuencia determinada sea universalmente accesible o tolerable.

La modalidad debe analizarse como una decisión contextual:

- la luz puede ser discreta, pero depende de visibilidad, luminosidad y contraste;
- el sonido puede superar la distancia, pero puede molestar, interrumpir a terceros o revelar una regla privada;
- la vibración puede aportar intimidad, pero pierde sentido si el objeto está sobre una superficie y no se toca;
- combinar canales puede mejorar perceptibilidad, pero aumenta intrusión, consumo y complejidad.

**Qué informa a Relevo:** no existe un canal universal. La investigación debe comparar modalidades y superficies sin afirmar previamente que una es accesible para todas las personas.

## 5. Modelos de valor y economía de la categoría

El mercado no se entiende solo enumerando características. También debe mostrar cómo cada propuesta captura valor y qué carga transfiere al usuario.

| Modelo | Ejemplo | Valor que se ofrece | Carga trasladada a la persona | Riesgo para Relevo |
| --- | --- | --- | --- | --- |
| Función incluida en el sistema operativo | Digital Wellbeing, Screen Time, Pause Point | Control y reflexión sin compra adicional. | Descubrir, configurar y aceptar la intervención dentro del teléfono. | Una solución gratuita puede entregar suficiente valor para volver innecesario el hardware. |
| Aplicación gratuita o de suscripción | one sec | Fricción configurable, estadísticas y funciones de intervención. | Permisos, configuración, atención recurrente y posible pago. | El usuario puede preferir una solución sin objeto; la suscripción exige valor sostenido. |
| Hardware de compra única | Brick, Screenless | Separación física, llave o barrera. | Costo inicial, disponibilidad del objeto, compatibilidad y pérdida. | Relevo debe justificar el precio con una experiencia que el software no entregue. |
| Hardware más suscripción | Unpluq | Barrera física, horarios, estadísticas y funciones digitales. | Compra, pago recurrente, NFC, aplicación y mantenimiento. | El modelo puede limitar adopción y no coincide con una propuesta mínima. |
| Hardware más aplicación multifunción | Focusaur | Foco, hábitos, agenda, ritual físico y recompensas. | Aprendizaje de varias funciones, carga de datos y posible suscripción Pro. | La expansión de funciones puede diluir el problema original de Relevo. |
| Prototipo o producto temprano financiado por comunidad | Focusaur en su etapa de Kickstarter | Validar interés y financiar producción inicial. | Riesgo de disponibilidad, madurez y soporte posterior. | No confundir circulación inicial con adopción estable. |

El precio de un producto no equivale a disposición de pago. Las páginas de Brick, Unpluq, Screenless y Focusaur permiten registrar precios visibles y condiciones de compra, pero no permiten inferir que el público chileno pagaría por ellos. La memoria debe mantener sus rangos de costo como escenarios de producción y separar tres preguntas:

1. ¿Cuánto cuesta construir un prototipo?
2. ¿Cuánto cuesta producir una unidad en una escala definida?
3. ¿Qué precio podría aceptar el usuario y frente a qué alternativas?

El capítulo de mercado debe informar la tercera pregunta con investigación propia o declararla pendiente. No debe derivarla del precio internacional de otro producto.

## 6. Qué parece funcionar, qué falla y qué no está resuelto

### 6.1 Mecanismos con respaldo útil, pero condicionado

- Las fricciones que introducen una pausa y conservan una salida pueden reducir aperturas o favorecer reconsideración en ciertos contextos. El resultado más claro en one sec no provino solamente de un mensaje reflexivo; la posibilidad de descartar la apertura fue un componente importante en el estudio de Grüning et al. (2023).
- Los bloqueos pueden reducir acceso cuando la barrera es suficientemente difícil de eludir y el usuario acepta esa intensidad. No son adecuados para todos los usos ni todas las aplicaciones.
- Los recordatorios externos pueden apoyar la recuperación de intenciones, sobre todo cuando la señal tiene bajo costo y la persona decide que la intención merece ser externalizada.
- Las claves situadas son plausibles cuando se relacionan con una acción o contexto reconocible, pero su eficacia depende de la asociación y no de la simple presencia de un objeto.
- Los estudios longitudinales son más informativos que una prueba inmediata para observar habituación, abandono y retorno de hábitos, aunque aumentan el costo de investigación.

### 6.2 Mecanismos que no deben tratarse como solución suficiente

- La conciencia o visualización de estadísticas por sí sola no constituye una intervención suficiente.
- Reducir minutos de pantalla no es equivalente a aumentar bienestar, autonomía o satisfacción; el tiempo puede corresponder a ocio significativo, comunicación, trabajo o descanso.
- Un recordatorio que solo se repite puede transformarse en ruido y perder saliencia.
- La gamificación no es intrínsecamente negativa, pero puntos, rachas y rankings pueden introducir evaluación, obligación o comparación. La decisión de no usarlos en Relevo debe fundamentarse en el objetivo del sistema y en riesgos de diseño, no atribuirse a una preferencia general de los entrevistados si esa preferencia no fue preguntada explícitamente.
- La palabra «intencional» no demuestra que una persona haya deliberado. Debe reservarse para una formulación o elección declarada por la persona o para una condición operacional explícita.

### 6.3 Variables de adopción que la memoria todavía subestima

La adopción tiene al menos cuatro momentos distintos:

1. **Descubrimiento:** la persona conoce la posibilidad y entiende qué problema aborda.
2. **Configuración inicial:** puede instalar, otorgar permisos, formular la intención y asociar el objeto sin ayuda excesiva.
3. **Uso situado:** la intervención aparece en el momento correcto, se percibe y no interfiere con un uso legítimo.
4. **Persistencia o reactivación:** la persona vuelve a usarla cuando la necesita, incluso si no la emplea todos los días.

Biedermann et al. (2024) muestran que dejar de usar una herramienta no siempre significa que fue inútil: en su encuesta de 273 estudiantes, la razón más común fue que ya no la necesitaban, con una asociación clara a periodos de examen o circunstancias temporales. También registraron rodeos a las restricciones y abandono por exceso de rigidez. Esto es importante para Relevo: un uso ocasional o estacional no debe definirse automáticamente como fracaso. El producto puede ser pertinente solo en episodios en que una persona formula una intención concreta.

Monge Roffarello y De Russis (2023) señalan que la mayoría de las evaluaciones eran breves, con una duración mediana de 21 días, y que pocos estudios incluían una fase de retiro. En los estudios con retiro, el tiempo de uso tendía a volver cerca de la línea base. La memoria no debe prometer formación de hábito ni cambio permanente. Relevo puede proponerse como apoyo episódico y reactivable; esa formulación es más congruente con la evidencia.

## 7. Tendencias actuales que deben incorporarse

### 7.1 De la medición a la pausa contextual

Las plataformas siguen ofreciendo reportes y límites, pero la aparición de Pause Point muestra una tendencia hacia intervenciones breves que intentan interrumpir el automatismo sin aplicar de inmediato un bloqueo total. La consecuencia para Relevo es estratégica: «no bloquear» ya no basta para diferenciarse. La diferencia debe ser la salida del circuito de pantalla y la vinculación con una intención situada.

### 7.2 Del software al objeto de separación

Brick, Unpluq y Screenless muestran que la categoría física se consolidó alrededor de la separación y el acceso. El objeto funciona como llave, barrera o recordatorio de una regla. Relevo puede ocupar otra posición solo si prueba que el objeto no es una llave de bloqueo disfrazada y que la ubicación aporta información funcional.

### 7.3 Del dispositivo puntual a la plataforma de foco y hábitos

Focusaur muestra la expansión de los productos físicos hacia agendas, hábitos, gamificación, NFC, sonido, estadísticas y asistentes. Esta tendencia puede aumentar atractivo comercial, pero también aumenta la superficie de datos, la complejidad y el riesgo de que el producto se convierta en una plataforma de productividad. Relevo debe aprender de esa categoría sin replicar su amplitud.

### 7.4 De la promesa de control a la atención sobre retención y abandono

La investigación reciente está desplazando la pregunta desde «¿la intervención reduce el uso?» hacia «¿quién la mantiene, cuándo la desactiva y por qué?». Kidel Peña-Albert et al. (2026), en un estudio cuasiexperimental con 252 usuarios de una herramienta digital de autocontrol, estudiaron la reconfiguración de nudges después de que estos quedaran inactivos. El estudio reportó que una parte de los usuarios aceptó reconfigurarlos y que los indicadores de comportamiento dentro de la aplicación diferenciaban mejor la receptividad que algunas medidas autorreportadas. El resultado es relevante como tendencia metodológica, pero debe leerse con cautela: los autores desarrollaron la aplicación estudiada y el contexto es un producto digital específico.

### 7.5 De los reclamos de eficacia a la necesidad de evaluación independiente

Los sitios comerciales utilizan expresiones como «científicamente probado», «ahorra tiempo» o «reduce el uso». La tendencia de mercado es apoyarse en papers, encuestas propias, testimonios y cifras de usuarios para construir confianza. La memoria debe responder con una ficha de procedencia: qué fuente produjo el número, qué muestra tuvo, qué diseño usó, quién financió, qué resultado midió y qué no midió. Un porcentaje publicado en una landing page no debe ingresar a la memoria como resultado científico.

## 8. Formulación de la oportunidad de Relevo

### 8.1 Hechos que pueden sostenerse

1. Existen herramientas nativas que miden, limitan o pausan el uso de aplicaciones.
2. Existen aplicaciones de fricción que interrumpen el acceso y algunas cuentan con estudios académicos específicos.
3. Existen objetos físicos que bloquean o desbloquean aplicaciones mediante contacto o NFC.
4. Existen objetos y sistemas phygital orientados a foco, hábitos y activación de actividades.
5. La literatura sobre descarga de intenciones respalda el uso de claves externas, pero también muestra que configurar una clave tiene un costo que afecta su adopción.
6. La evidencia sobre herramientas de autocontrol digital es heterogénea, con efectos acotados, evaluaciones breves y problemas de abandono.

### 8.2 Interpretación que puede orientar el proyecto

Dentro del corpus revisado, las familias dominantes utilizan el objeto para restringir acceso, o utilizan la pantalla para medir, pausar y sugerir. Hay una combinación menos desarrollada en la oferta observada: que el objeto físico funcione como una clave no textual para una alternativa elegida, situada junto a un primer paso, sin bloquear ni registrar la conducta posterior.

Esta interpretación no afirma que la combinación no exista en ningún lugar. Afirma que ofrece una pregunta de diseño suficientemente diferenciada para ser investigada dentro del alcance del Proyecto de Título.

### 8.3 Hipótesis de oportunidad

> Si una persona formula una sola intención de ocio y la asocia con un primer paso ubicado en su entorno, un testigo físico sin pantalla podría aportar una recuperación más situada y menos dependiente de volver a mirar el teléfono que una notificación equivalente. Esta hipótesis solo justifica continuar mientras el testigo sea perceptible, de bajo esfuerzo, no punitivo y capaz de entregar un valor que compense su costo material y técnico.

### 8.4 Lo que Relevo no debe prometer

- No debe prometer reducir el tiempo total de pantalla.
- No debe prometer tratar adicción, insomnio, ansiedad o falta de disciplina.
- No debe prometer que la señal hará que la persona realice la actividad.
- No debe prometer que la ubicación es efectiva sin comparar una ubicación congruente con una neutral.
- No debe prometer que el objeto es mejor que una notificación antes de probarlo.
- No debe usar la inexistencia de una pantalla como argumento suficiente de innovación.

## 9. Matriz mantener, reemplazar, ampliar y retirar

| ID | Elemento de la memoria vigente | Acción | Corrección concreta | Prioridad |
| --- | --- | --- | --- | --- |
| M-04-01 | Organización del capítulo por mecanismos | Mantener | Conservarla y añadir en cada familia mecanismo, valor, fricción, evidencia, adopción y límite. | Alta |
| M-04-02 | Distinción entre paper, documentación técnica y comunicación comercial | Mantener y ampliar | Convertirla en etiquetas visibles en la tabla de fuentes y en las fichas. | Alta |
| M-04-03 | Biedermann et al. (2021) | Mantener | Usarlo como revisión crítica de conciencia, bloqueo y baja confianza de evidencia. | Alta |
| M-04-04 | Monge Roffarello y De Russis (2023) | Ampliar | Incorporar 43 estudios evaluados, metaanálisis final de 7 estudios, Hedges g = 0,47, intervalo de confianza de 0,27 a 0,68, duración breve y retorno durante retiro. | Alta |
| M-04-05 | Biedermann et al. (2024) | Añadir | Incorporar adopción, uso temporal, rodeo de restricciones y abandono por rigidez. | Alta |
| M-04-06 | Grüning et al. (2023) sobre one sec | Añadir y separar | Registrar el resultado de 280 participantes durante 6 semanas, aclarar el componente de descartar la apertura y señalar vínculo comercial. | Alta |
| M-04-07 | Haliburton et al. (2024) | Añadir | Usarlo para discutir uso longitudinal en contexto real, no causalidad universal. | Alta |
| M-04-08 | one sec como página oficial | Mantener solo como fuente comercial | No usar sus porcentajes como evidencia independiente; vincularlos a los papers correspondientes. | Alta |
| M-04-09 | Pause Point | Reemplazar parcialmente | Actualizar disponibilidad: Pixel 11 y Android 17 según la ayuda oficial consultada; separar anuncio, capacidad y eficacia. | Alta |
| M-04-10 | Google Digital Wellbeing y Apple Screen Time | Añadir | Incluirlos como competidores de menor costo y mayor distribución, con sus mecanismos nativos. | Alta |
| M-04-11 | Brick | Mantener y profundizar | Explicar el objeto como barrera, registrar Android/iOS, precio mostrado y ausencia de suscripción declarada; no usar testimonios como eficacia. | Alta |
| M-04-12 | Unpluq | Mantener y profundizar | Registrar NFC, suscripción, barreras y estadísticas; diferenciar llave de recuperación. | Alta |
| M-04-13 | Screenless Breaker | Mantener con límite | Registrar iOS/iPadOS vigente, Android planificado, NFC pasivo, ausencia de batería declarada y precio mostrado. | Media |
| M-04-14 | Focusaur | Mantener como tendencia emergente | Clasificar como foco/hábitos y modelo hardware-aplicación; explicitar gamificación, amplitud funcional y ausencia de evidencia independiente de Relevo. | Alta |
| M-04-15 | Aro | Retirar del núcleo | La disponibilidad comercial no está suficientemente verificada en la memoria; si se conserva, debe ir a antecedentes históricos con estado explícito. | Media |
| M-04-16 | *The Tangible Reminder* (2007) | Mover | Mantener como antecedente histórico de interacción tangible, no como referente actual de mercado. | Media |
| M-04-17 | AirTag | Retirar del estado del arte | No es un referente de bienestar digital; si se usa para comparar compacidad, trasladarlo a factibilidad formal y declarar que no informa el mecanismo. | Media |
| M-04-18 | «No se identificó una solución...» | Reemplazar | Usar una formulación acotada al corpus, fecha y criterios de búsqueda, sin afirmar inexistencia absoluta. | Alta |
| M-04-19 | Gamificación excluida | Reformular | Presentarla como decisión proyectual por riesgo de evaluación y por alcance, no como resultado directo de las entrevistas. | Alta |
| M-04-20 | Comparación con notificación | Elevar | Convertirla en criterio de decisión temprana y no en comparación secundaria. | Alta |
| M-04-21 | Mercado y precio | Ampliar | Separar precio observado, costo de prototipo, costo de producción y disposición de pago. | Alta |
| M-04-22 | Privacidad y compatibilidad | Ampliar | Registrar cuentas, nube, permisos, NFC/BLE, plataforma, actualización y soporte como fricciones de adopción. | Media |
| M-04-23 | Carpeta `04_mercado_y_referentes` | Reemplazar su estado documental | Añadir registro de búsqueda, fichas de fuente, fichas de producto y fecha de verificación. | Alta |
| M-04-24 | Referencias comerciales con fechas de recuperación | Auditar | Uniformar APA 7 y registrar que los precios y funciones son dinámicos. | Alta |

## 10. Riesgos críticos para Relevo

| Riesgo | Severidad | Evidencia o razón | Consecuencia | Puerta de decisión |
| --- | --- | --- | --- | --- |
| Redundancia frente a Pause Point o una notificación | Crítica | La intervención digital ya puede pausar y ofrecer alternativas. | El objeto agrega costo sin aportar una diferencia funcional. | Comparar señal situada con notificación textual equivalente antes de cerrar forma. |
| Convertir el testigo en un bloqueo encubierto | Crítica | El mercado físico existente usa objetos como llaves y barreras. | Se contradice la autonomía declarada y se pierde el problema propio. | Definir explícitamente qué no puede hacer el objeto y probar que continuar es una salida válida. |
| Transferir eficacia de one sec a Relevo | Crítica | one sec estudia una fricción en pantalla, no un testigo situado. | Se comete una inferencia causal inválida. | Citar el estudio solo para el mecanismo probado y evaluar Relevo desde cero. |
| Vacío no reproducible | Crítica | No existe aún registro de búsqueda en la carpeta de mercado. | La novedad queda expuesta a una refutación fácil. | Documentar alcance, consultas, fuentes incluidas y exclusiones. |
| Costo de configuración demasiado alto | Alta | Chiu y Gilbert muestran que el esfuerzo físico reduce la descarga de intenciones. | La persona abandona antes de armar la intención. | Medir tiempo, errores y ayuda requerida en la primera configuración. |
| Habituación y pérdida de saliencia | Alta | La literatura exige estudios longitudinales y registra retorno de hábitos. | El objeto se vuelve ruido o queda olvidado. | Probar reactivación y tolerancia en más de un episodio; no prometer cambio permanente. |
| Interferencia con usos legítimos de una aplicación | Alta | Las plataformas tienen usos duales y los bloqueos se desactivan cuando son demasiado rígidos. | La persona percibe el sistema como obstáculo. | Permitir condición autoelegida, salida inmediata y desarmado claro. |
| Incompatibilidad Android o permisos frágiles | Alta | Digital Wellbeing, UsageStats, BLE y funciones nativas dependen de versión y fabricante. | La señal llega tarde o no llega. | Mantener el mercado como contexto y probar primero la factibilidad real del MVP. |
| Desajuste cultural y económico | Alta | La evidencia y los productos revisados son principalmente internacionales. | El precio, la vivienda y la percepción del ocio pueden diferir en Santiago. | No inferir demanda chilena; explorar disposición de pago y condiciones domésticas posteriormente. |
| Modalidad intrusiva o inaccesible | Alta | Luz, sonido y vibración dependen de superficie, distancia, percepción y convivencia. | El usuario silencia o retira el objeto. | Evaluar por canal, contexto y persona, sin declarar un canal universal. |
| Expansión de alcance | Media | Los productos actuales tienden a sumar hábitos, agenda, gamificación y datos. | La memoria termina describiendo una plataforma, no un mecanismo. | Mantener una intención activa y un primer paso como límite del MVP. |
| Privacidad aparente | Media | «Local» o «sin nube» son promesas que requieren inventario técnico. | Se comunica una garantía que la arquitectura no puede sostener. | Registrar datos, permisos, almacenamiento, retención, borrado y dependencias de terceros. |

## 11. Correcciones concretas para la nueva versión de la memoria

### 11.1 Reordenar el capítulo 6

La nueva versión debería seguir esta secuencia:

1. **Criterio y alcance de búsqueda:** fecha de corte, mecanismos, fuentes, límites y distinción entre evidencia y oferta.
2. **Evidencia académica transversal:** qué se sabe sobre autocontrol digital, fricción, adopción, abandono y descarga de intenciones.
3. **Familias de mercado:** nativo, fricción, bloqueo físico, foco/hábitos y recordatorios tangibles.
4. **Comparación por mecanismo:** valor, fricción, restricciones, compatibilidad, modelo económico y evidencia.
5. **Tendencias:** pausa contextual, objetos de separación, dispositivos multifunción, privacidad y retención.
6. **Implicación para Relevo:** qué se mantiene, qué se excluye, qué debe probarse y por qué el objeto sin pantalla sigue siendo una hipótesis.
7. **Oportunidad acotada:** formulación no absoluta y vinculada a la comparación con notificación.

El capítulo no debe empezar con una lista de productos. Debe empezar explicando cómo se decidió que un producto era relevante.

### 11.2 Construir una ficha mínima por fuente académica

Para cada paper que se utilice en el cuerpo, registrar internamente:

- pregunta o propósito;
- tipo de estudio;
- muestra y contexto;
- mecanismo evaluado;
- resultado principal;
- duración;
- limitación declarada por los autores;
- qué decisión de Relevo informa;
- qué afirmación no permite realizar.

Esta ficha evita que un metaanálisis se convierta en una frase general sobre «la tecnología» y permite distinguir reducción de uso, recuerdo, intención, satisfacción, autonomía y adopción.

### 11.3 Construir una ficha mínima por producto

Registrar por producto:

- problema declarado;
- público declarado;
- mecanismo;
- objeto o interfaz;
- condición de activación;
- modalidad de salida;
- compatibilidad vigente;
- cuenta, nube, permisos y datos;
- precio visible y moneda;
- suscripción o compra única;
- evidencia independiente disponible;
- promesas comerciales no verificadas;
- fricción de adopción;
- límite relevante para Relevo;
- fecha de verificación.

### 11.4 Cambiar la redacción del aporte

La memoria no debería decir que Relevo «resuelve» el problema. Debería decir que **propone investigar** una relación entre una condición digital, una clave física y una actividad elegida. Tampoco debería afirmar que la persona «recuerda hacer» por recibir una señal; la primera prueba debe distinguir:

1. si percibe la señal;
2. si identifica la intención;
3. si identifica el primer paso;
4. si recuerda la asociación espacial;
5. si considera la alternativa disponible; y
6. qué decide hacer después.

### 11.5 Incorporar una tabla de evidencia versus promesa

La tabla siguiente puede orientar la reescritura, sin copiarse necesariamente de manera literal al cuerpo:

| Afirmación | Tipo correcto | Fuente | Formulación válida |
| --- | --- | --- | --- |
| Las herramientas digitales tienen efectos variables | Evidencia académica | Biedermann et al., 2021; Monge Roffarello y De Russis, 2023 | La evidencia es heterogénea y está limitada por estudios breves y medidas no comparables. |
| one sec reduce aperturas de aplicaciones objetivo en un estudio | Evidencia de un producto | Grüning et al., 2023 | El estudio observó una reducción en ese producto, población y periodo. |
| Brick no requiere suscripción | Característica comercial declarada | Brick LLC, s. f. | La página oficial declara aplicación sin suscripción y precio de 59 dólares. |
| Unpluq exige suscripción premium para sus funciones principales | Característica comercial declarada | Unpluq, s. f. | La página oficial declara suscripción y etiqueta NFC como parte del sistema. |
| Screenless funciona actualmente en Android | Afirmación incorrecta o no verificada | Screenless, s. f. | La página vigente indica compatibilidad con iOS/iPadOS y Android planificado. |
| Pause Point compite directamente con Relevo | Interpretación de mercado | Google, 2026; Google, s. f.-a | Es un competidor de mecanismo parcial, con alcance de plataforma limitado. |
| No existe una solución equivalente | Afirmación no autorizada | Búsqueda incompleta | Reemplazar por «no se encontró en el corpus consultado». |
| El objeto situado recuperará una intención | Hipótesis | Diseño de Relevo | Debe comprobarse mediante recuperación semántica y comparación de ubicación. |

## 12. Decisión recomendada para la auditoría

### Mantener

- la lectura por mecanismos;
- la distinción entre evidencia y promesa comercial;
- el objeto sin pantalla como hipótesis de asociación y no como adorno;
- la exclusión de bloqueo, puntuación y registro conductual como decisiones de alcance, no como verdades universales;
- la comparación con una notificación como criterio de valor.

### Reemplazar

- la formulación del vacío por una oportunidad acotada al corpus;
- la descripción de Pause Point por su disponibilidad vigente y su posición competitiva;
- la agrupación indiferenciada de objetos físicos;
- la idea de que el mercado actual solo mide, bloquea o demora;
- toda frase que derive eficacia de un producto ajeno a la propuesta.

### Ampliar

- evidencia cuantitativa y límites del metaanálisis de Monge Roffarello y De Russis;
- estudios sobre uso longitudinal, abandono y reconfiguración;
- esfuerzo de configuración y descarga de intenciones;
- modelos económicos, compatibilidad y adopción;
- Focusaur como referente de activación física y expansión de alcance;
- herramientas nativas y competidores de costo marginal bajo.

### Retirar del núcleo

- Aro mientras su disponibilidad no esté documentada;
- AirTag como referente de bienestar digital;
- *The Tangible Reminder* como supuesto referente de mercado actual;
- cifras comerciales y testimonios sin ficha de procedencia independiente;
- cualquier afirmación de inexistencia absoluta.

El siguiente paso sustantivo único debería ser reconstruir el capítulo 6 a partir de un registro documental de búsqueda y de fichas de fuente. No conviene seguir diseñando modalidades, carcasa o arquitectura técnica hasta que la memoria pueda explicar con claridad qué mecanismo de mercado se está diferenciando y qué hipótesis exacta se pondrá a prueba.

## 13. Referencias verificadas y recomendadas en APA 7

Apple. (s. f.). *Get started with Screen Time on iPhone*. Apple Support. Recuperado el 24 de agosto de 2026, de https://support.apple.com/en-euro/guide/iphone/iphbfa595995/ios

Biedermann, D., Kister, S., Breitwieser, J., Weidlich, J., y Drachsler, H. (2024). Use of digital self-control tools in higher education—A survey study. *Education and Information Technologies, 29*, 9645–9666. https://doi.org/10.1007/s10639-023-12198-2

Biedermann, D., Schneider, J., y Drachsler, H. (2021). Digital self-control interventions for distracting media multitasking—A systematic review. *Journal of Computer Assisted Learning, 37*(5), 1217–1231. https://doi.org/10.1111/jcal.12581

Brick LLC. (s. f.). *Brick: Take back control of your screen time*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/

Chiu, G., y Gilbert, S. J. (2024). Influence of the physical effort of reminder-setting on strategic offloading of delayed intentions. *Quarterly Journal of Experimental Psychology, 77*(6), 1295–1311. https://doi.org/10.1177/17470218231199977

Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits

Gilbert, S. J., Boldt, A., Sachdeva, C., Scarampi, C., y Tsai, P.-C. (2023). Outsourcing memory to external tools: A review of “intention offloading”. *Psychonomic Bulletin & Review, 30*(1), 60–76. https://doi.org/10.3758/s13423-022-02139-4

Google. (s. f.-a). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Pixel Phone Help. Recuperado el 24 de agosto de 2026, de https://support.google.com/pixelphone/answer/9137850?hl=en

Google. (2026, 12 de mayo). *Reclaim your time with Pause Point*. The Keyword. https://blog.google/products-and-platforms/platforms/android/pause-point/

Grüning, D. J., Riedel, F., y Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences of the United States of America, 120*(8), e2213114120. https://doi.org/10.1073/pnas.2213114120

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A., y Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the 2024 CHI Conference on Human Factors in Computing Systems* (Artículo 243, pp. 1–16). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Hermann, M., Mahler, T., de Melo, G., y Weber, M. (2007). The tangible reminder. En *3rd IET International Conference on Intelligent Environments* (pp. 144–151). Institution of Engineering and Technology. https://doi.org/10.1049/cp:20070359

Kidel Peña-Albert, A., Ingram, S., Khazaal, Y., Litrico, L., Farah, J. C., y Gillet, D. (2026). Restoring engagement in digital self-control tools using nudge reconfiguration prompts: Quasi-experimental study. *JMIR Formative Research, 10*, e85349. https://doi.org/10.2196/85349

Monge Roffarello, A., y De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53, 1–66. https://doi.org/10.1145/3571810

Monge Roffarello, A., y De Russis, L. (2024). Hey StepByStep! Can you teach me how to use my phone better? *International Journal of Human-Computer Studies, 183*, 103195. https://doi.org/10.1016/j.ijhcs.2023.103195

one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/

O’Rear, A. E., y Radvansky, G. A. (2019). Location-based prospective memory. *Quarterly Journal of Experimental Psychology, 72*(3), 491–507. https://doi.org/10.1177/1747021818758608

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

## Registro de cambios (disclaimer)

### 2026-08-24 — Creación del informe de Auditoría 4

- **Cambio:** se creó `08_memoria/auditoria-agente-04-mercado.md` con una auditoría integral del estado del arte, mercado actual y referentes de Relevo.
- **Versión anterior:** no existía un informe especializado para esta auditoría. La memoria vigente contenía un capítulo 6 con una matriz de productos y una formulación provisional de oportunidad, mientras `04_mercado_y_referentes` contenía únicamente su README.
- **Motivo:** evaluar el mercado como sistema de mecanismos, modelos de valor, fricciones, adopción, límites y tendencias; actualizar referentes vigentes; separar evidencia independiente de promesas comerciales; y evitar que la oportunidad se sostenga en una afirmación de inexistencia no reproducible.
- **Fuentes incorporadas:** papers y revisiones académicas desde 2021, estudios de 2023–2026, y sitios oficiales de Google, Apple, Brick, Unpluq, Screenless, Focusaur y one sec, verificados con fecha de corte 24 de agosto de 2026.
- **Alcance:** este archivo propone mantener, reemplazar, ampliar y retirar elementos del capítulo 6. No modifica `08_memoria/memoria-vigente.md`, no constituye validación de Relevo, no demuestra eficacia del objeto sin pantalla y no autoriza a presentar promesas comerciales como resultados científicos.
- **Pendiente derivado:** crear el registro de búsqueda y las fichas de fuente/producto en `04_mercado_y_referentes` antes de integrar la reescritura en la memoria.
