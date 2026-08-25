---
id: AUD-MEM-ARQ-001
titulo: "Auditoría integral de arquitectura narrativa y tesis central"
agente: "Luna Max — Auditoría 1"
fecha: 2026-08-24
estado: "informe de auditoría; no sustituye la decisión de integración"
alcance: "arquitectura narrativa, tesis, dependencias, circularidad expositiva y correspondencia con Proyecto de Título"
restriccion: "no se modifica memoria-vigente.md; no se ejecutan commits ni push"
---

# Auditoría de arquitectura narrativa y tesis central

## Dictamen ejecutivo

La memoria vigente posee una base conceptual valiosa: distingue el ocio digital significativo de la continuidad poco deliberada, evita convertir el tiempo de pantalla en un indicador suficiente, reconoce un usuario límite, formula una hipótesis falsable y mantiene la restricción de que el objeto físico no tenga pantalla. También documenta flujos, factibilidad, costos preliminares y criterios de abandono.

Sin embargo, todavía no está organizada con la solidez narrativa exigible a una memoria de Proyecto de Título. El texto actual funciona mejor como una propuesta de diseño argumentada y como un plan de investigación mediante diseño que como una memoria que demuestra, de principio a fin, cómo los antecedentes y la investigación producen una decisión de diseño, cómo esa decisión se materializa, cómo se gestiona y qué fue efectivamente probado.

El problema principal no es la falta de contenido. Es la jerarquía del contenido:

1. La tesis central está distribuida entre el resumen, la introducción, el capítulo 5, la definición de Relevo y las conclusiones, pero no aparece al comienzo como una afirmación única con alcance, condición de validez y posible refutación.
2. El lector recibe una escena hipotética y detalles de funcionamiento antes de conocer con suficiente claridad qué parte corresponde a evidencia, qué parte a inferencia y qué parte a decisión proyectual.
3. El capítulo de entrevistas se denomina «consulta exploratoria» y no queda integrado a un marco metodológico completo antes de presentar sus hallazgos.
4. El salto entre investigación y propuesta carece de un capítulo de síntesis que muestre la cadena evidencia → interpretación → criterio → decisión → prueba.
5. La arquitectura de experiencia aparece después de la propuesta y de la factibilidad, aunque sus flujos son necesarios para entender la propuesta y evaluar su producción.
6. El requisito institucional de producción está presente de forma técnica, pero el modelo de gestión aparece solo de manera parcial en el rol profesional y en la factibilidad organizacional.
7. El texto mezcla con frecuencia lo realizado, lo diseñado, lo planificado y lo que todavía debe probarse. La memoria lo advierte en varios pasajes, pero la estructura general aún puede producir la impresión de que el sistema está más validado de lo que realmente está.

La recomendación es una reestructuración argumental completa, conservando la investigación, las fuentes, los anexos y las decisiones que tienen trazabilidad. No se recomienda una corrección superficial de títulos ni una eliminación masiva del contenido. El cambio debe consistir en hacer visible el argumento que ya existe, retirar duplicaciones y separar con rigor el estado actual del proyecto de sus proyecciones.

## 1. Base de lectura y criterios de evaluación

### 1.1 Documentos revisados

Se leyeron íntegramente:

- `INSTRUCCIONES_CHATGPT.md`.
- `00_gobernanza/directrices-de-trabajo.md`.
- `08_memoria/memoria-vigente.md`.
- `08_memoria/matriz-incorporacion-feedback-e15.md`.
- `INSTRUCTIVO EXAMEN PROYECTO DE TÍTULO 2026.docx`, ubicado en la carpeta institucional local `SEMESTRE 2/COORDINACIÓN TITULACIÓN S2. 2026/DOCUMENTOS BASE`.
- `Acta Examen PROYECTO DE TÍTULO 2026.docx`, para comprobar si añadía criterios narrativos o de contenido. El acta es principalmente administrativa y no modifica la arquitectura recomendada.

También se considera la síntesis del Reglamento entregada para esta auditoría: en Taller de Titulación, la memoria debe demostrar investigación, diseño proyectual, marco teórico y modelo de gestión; en Proyecto de Título debe contener antecedentes, investigación, diseño y producción.

### 1.2 Qué se considera evidencia y qué se considera orientación

La evaluación separa los niveles siguientes:

| Nivel | Aplicación en esta auditoría |
| --- | --- |
| Hecho documental | Lo que efectivamente aparece en la memoria, en el instructivo institucional o en las directrices del repositorio. |
| Evidencia empírica | El corpus de ocho entrevistas reales, semiestructuradas, presenciales y habladas, realizadas en Santiago en junio de 2026. |
| Interpretación | La lectura que vincula esos datos con una oportunidad o un problema de diseño. |
| Decisión proyectual | Una elección del proyecto, como usar un testigo sin pantalla o limitar la intervención a una intención activa. |
| Hipótesis | Una relación que todavía debe probarse, como el posible aporte de la ubicación congruente frente a una notificación. |
| Feedback docente | Orientación para corregir el proyecto y la memoria; no demuestra por sí mismo un comportamiento de usuario ni la eficacia de Relevo. |
| Pendiente | Una decisión o prueba necesaria que aún no cuenta con respaldo suficiente. |

Esta separación es especialmente importante porque la memoria utiliza una escena precisa —caminar, ponerse las zapatillas, usar Instagram, recibir luz, sonido y vibración— que funciona como ejemplo de uso, pero no como resultado de las entrevistas. Debe conservarse como escenario hipotético y no presentarse como el caso empírico que define a todos los usuarios.

### 1.3 Correspondencia con el instructivo institucional

El instructivo oficial establece dos niveles de exigencia relevantes para la arquitectura:

1. La memoria debe dar cuenta de la construcción del problema, los objetivos, el marco metodológico y el plan de trabajo, el marco teórico y/o estudio de casos, el usuario y el contexto, la solución de diseño y los criterios de factibilidad.
2. Para el Examen de Proyecto de Título, el documento debe contener la información completa de la investigación, el diseño y la producción del proyecto. La presentación debe exponer los antecedentes de la exploración, la investigación, el diseño y la producción, con un discurso técnicamente preciso.

El documento institucional presenta señales de reutilización de una plantilla: una sección del archivo titulado como Proyecto de Título todavía menciona el Examen de Seminario de Título, aparece una fecha de entrega de noviembre y otra tabla sitúa los exámenes entre el 14 y el 23 de diciembre. Esta inconsistencia administrativa no debe trasladarse a la arquitectura de la memoria. Para esta auditoría se toman como criterios estables los contenidos exigidos —antecedentes, investigación, diseño y producción— y no las fechas o etiquetas contradictorias del archivo.

La síntesis del Reglamento agrega un requisito que hoy no es suficientemente visible: el modelo de gestión. La memoria menciona factibilidad organizacional y el rol del diseñador, pero todavía no presenta con claridad quién hace qué, con qué recursos, en qué secuencia, bajo qué riesgos, cómo se produce, cómo se mantiene y bajo qué condiciones el proyecto se modifica o se abandona. Ese modelo debe pasar de un anexo técnico a una parte reconocible del argumento principal.

## 2. Auditoría de la tesis central

### 2.1 Lo que la memoria ya sostiene correctamente

La formulación vigente contiene cuatro aciertos que deben mantenerse:

- El problema no se reduce a la cantidad de tiempo frente a una pantalla.
- El ocio digital no se trata como una conducta intrínsecamente negativa.
- La intervención no busca bloquear, castigar, calificar ni determinar cuál es el ocio correcto.
- La propuesta phygital combina aplicación, objeto físico sin pantalla y lugar elegido; no son dos productos independientes.

También es correcto que la memoria no declare que Relevo detecta un estado subjetivo de automatismo. La condición operacional debe seguir siendo aproximada y técnica hasta que las pruebas definan otra cosa.

### 2.2 Debilidad actual

La tesis aparece fragmentada en formulaciones compatibles, pero con funciones distintas. El resumen habla de una intención que deja de estar disponible; la introducción presenta una escena; el capítulo 5 formula una pregunta de investigación y una hipótesis; el capítulo 8 define el sistema; y las conclusiones explican el desplazamiento conceptual. El lector puede reconstruir el argumento, pero debe hacerlo por su cuenta.

Además, el comienzo de la memoria entrega demasiados detalles de solución antes de explicar por qué esos detalles son necesarios. La escena inicial menciona Android, Instagram, un testigo junto al calzado y tres modalidades de señal. Eso acelera la visualización del producto, pero también produce el riesgo señalado en el feedback docente: que el lector entienda el objeto antes de entender el proyecto.

### 2.3 Tesis central recomendada

La memoria debería declarar tempranamente una tesis de proyecto, sin presentarla como un resultado ya demostrado:

> Relevo explora la hipótesis de que una señal física sin texto, configurada digitalmente y situada junto al primer paso de una actividad elegida, puede devolver esa intención a la consideración de una persona durante una sesión digital de continuidad poco deliberada, sin bloquear su ocio ni evaluar su respuesta.

Esta tesis debe acompañarse de una condición de refutación:

> La hipótesis pierde fundamento si la asociación entre señal, lugar e intención no puede recuperarse sin consultar nuevamente el teléfono, si el objeto no aporta un valor reconocible frente a una notificación o si la intervención se percibe como vigilancia, castigo o carga desproporcionada.

La tesis no afirma que Relevo reduzca el tiempo de pantalla, mejore el bienestar, aumente la productividad, provoque actividad física o funcione para cualquier persona. Tampoco afirma que el hogar sea un contexto universal. Esas afirmaciones solo podrían incorporarse si una investigación posterior las respalda y si permanecen dentro del alcance del proyecto.

### 2.4 Cuatro niveles que deben distinguirse en la apertura

La primera parte de la memoria debería presentar, en este orden, cuatro frases diferentes:

| Nivel | Formulación recomendada | Función |
| --- | --- | --- |
| Problema | En algunas sesiones de ocio digital que se prolongan sin una elección renovada, una intención alternativa que la persona valoraba puede perder disponibilidad para orientar la acción. | Define el fenómeno sin convertirlo en diagnóstico. |
| Pregunta | ¿Bajo qué condiciones una señal externa, autoelegida y situada puede apoyar la recuperación de esa intención sin bloquear ni evaluar? | Delimita lo que la investigación debe responder. |
| Propuesta | Relevo es un sistema phygital compuesto por una aplicación Android, un testigo físico sin pantalla y un lugar elegido. | Explica qué se diseña. |
| Contribución | El proyecto investiga cómo traducir la descarga de una intención a una relación entre interfaz, objeto y contexto, manteniendo la decisión posterior fuera del sistema. | Explica por qué el proyecto tiene valor disciplinar. |

La contribución es una contribución de diseño y de conocimiento proyectual, no una promesa de eficacia clínica o conductual.

## 3. Diagnóstico de la arquitectura vigente

### 3.1 Secuencia actual

La memoria está organizada actualmente así:

```text
Introducción → problema → teoría → entrevistas → formulación → mercado
→ familias formales → propuesta → factibilidad → validación
→ arquitectura de experiencia → conclusiones
```

La secuencia tiene una dirección reconocible, pero presenta cuatro desplazamientos problemáticos:

1. **Método y resultados están separados de manera insuficiente.** El capítulo 4 presenta procedencia, límites y hallazgos, pero no constituye todavía un marco metodológico completo. La denominación «consulta exploratoria» subestima que existieron ocho entrevistas semiestructuradas reales. A la vez, el lector conoce los hallazgos antes de ver con claridad cómo se analizaron.
2. **La síntesis está implícita.** El capítulo 5 convierte investigación y teoría en preguntas, hipótesis y criterios, pero no muestra en una unidad argumental qué hallazgo produce cada criterio ni qué alternativas fueron descartadas por cada razón.
3. **La arquitectura de experiencia está retrasada.** Los flujos de usuario, estados y flujo técnico aparecen después de que la propuesta ya fue descrita y de que la factibilidad ya fue introducida. Deben explicar la propuesta antes de evaluar su producción.
4. **La validación es principalmente futura.** La memoria contiene protocolos, tamaños orientativos y puertas de decisión, pero aún no debe leerse como si hubiera demostrado el desempeño del sistema. El capítulo de validación necesita separar resultados realizados, pruebas en curso, protocolos previstos y criterios de abandono.

### 3.2 Lo que funciona en la circularidad actual

La escena inicial y la conclusión ya intentan cerrar un arco: la pregunta sobre el recuerdo de una sesión se transforma en una pregunta sobre una intención futura. También reaparece la relación entre aplicación, objeto y lugar en la propuesta y en la conclusión. Esa circularidad debe conservarse.

Lo que falta es una circularidad controlada, no una repetición. El mismo escenario debería volver tres veces con funciones distintas:

1. **Al inicio:** escena hipotética breve para hacer comprensible el problema.
2. **Después de la investigación:** descomposición de la escena en elementos respaldados, inferidos y todavía hipotéticos.
3. **En la propuesta y el cierre:** secuencia del sistema y evaluación de qué parte fue diseñada, qué parte fue probada y qué parte quedó abierta.

La escena no debe reaparecer completa en cada capítulo. Debe servir como hilo conductor mediante las variables intención, primer paso, condición, señal, lugar y decisión posterior.

### 3.3 Transición investigación → propuesta

La memoria dispone de los materiales para demostrar la transición, pero no los presenta todavía como una cadena explícita. La estructura que debe quedar visible es:

```text
Antecedentes y contexto
        ↓
Problema delimitado
        ↓
Preguntas y objetivos
        ↓
Método y corpus
        ↓
Hallazgos de usuarios + teoría + mercado
        ↓
Síntesis de oportunidad y criterios
        ↓
Alternativas comparadas
        ↓
Decisión: Relevo sin pantalla
        ↓
Sistema, flujos y producción
        ↓
Prototipos, pruebas y resultados
        ↓
Conclusiones, límites y decisión siguiente
```

El capítulo que falta es **Síntesis de investigación y oportunidad de diseño**. Sin este capítulo, la selección del testigo transportable puede parecer una preferencia formal del autor, aunque la memoria sí contenga razones parciales para preferirlo.

## 4. Matriz de mantener, reemplazar, ampliar y retirar

| Área de la memoria vigente | Acción | Diagnóstico | Corrección concreta |
| --- | --- | --- | --- |
| Título, resumen y abstract | Mantener y ajustar | Definen el sistema y la hipótesis con mayor claridad que las versiones anteriores. | Reemplazar la formulación de «propuesta» por una distinción explícita entre problema, hipótesis, sistema diseñado y estado de validación. |
| Escena inicial | Mantener y reducir | Hace visible el problema rápidamente, pero adelanta demasiadas decisiones y parece una experiencia comprobada. | Conservarla como escena hipotética; retirar del primer párrafo marcas concretas como Instagram, duración, tres canales y secuencia técnica. Llevar esos detalles al capítulo de propuesta. |
| Evolución del problema | Mantener y reubicar | Explica el giro desde tiempo de pantalla hacia intención prospectiva. | Convertirla en parte de Antecedentes y construcción del problema, no en una explicación aislada dentro de la introducción. |
| Capítulo 2, problema y contexto | Ampliar y reordenar | Tiene buenas fuentes y evita equiparar duración con daño, pero mezcla antecedentes, literatura y estado de herramientas. | Separar antecedentes/contexto de estado del arte; cerrar con una formulación del problema, alcance y vacío específico. |
| Marco teórico | Mantener y profundizar | Memoria prospectiva, descarga de intenciones, intención de implementación, espacio y autonomía son pertinentes. | Explicitar qué concepto responde a qué pregunta y qué no permite inferir. Evitar que el marco parezca escrito para justificar una solución ya decidida. |
| «Consulta exploratoria» | Reemplazar | El rótulo reduce el peso metodológico de ocho entrevistas semiestructuradas reales. | Usar «Diseño metodológico» para procedimiento y «Estudio de usuarios» o «Hallazgos del estudio exploratorio» para resultados. No convertir el estudio en muestra representativa. |
| Procedencia de entrevistas | Mantener y ampliar | La memoria corrige modalidad, fechas, Santiago, consentimiento oral, P1–P8 y uso posterior de asistencia automatizada. | Integrar método de reclutamiento, criterio común de edad, límites de notas y duración, estrategia de análisis y relación entre pregunta, patrón y decisión. |
| Dos tipos situacionales | Mantener | Es mejor que una segmentación demográfica rígida y conserva el caso negativo. | Presentarlos después del método y los hallazgos; agregar necesidades, tensiones, condiciones de intervención y condiciones de no intervención, siempre marcando interpretación. |
| Formulación de preguntas y objetivos | Mantener y adelantar | La pregunta de investigación y la pregunta proyectual son pertinentes. | Ubicarlas después de antecedentes y antes del método; diferenciar objetivo de investigar, diseñar, producir y evaluar. |
| Estado del arte y mercado | Mantener y ampliar | Organizar por mecanismos es más útil que un catálogo de productos. | Incorporar una conclusión comparativa que indique qué problema resuelve cada familia, qué carga introduce y qué aprendizaje habilita para Relevo. |
| Criterios de diseño | Mantener y convertir en matriz de trazabilidad | La tabla traduce teoría y entrevistas a requisitos. | Añadir columnas: origen, evidencia o supuesto, decisión afectada, prueba requerida y estado. Mover la síntesis antes de la ideación formal. |
| Capítulo «Del criterio a la forma» | Mantener y reubicar | La comparación entre pinza, faro y testigo transportable contiene una decisión útil. | Convertirlo en «Desarrollo de diseño y selección de dirección» después de la síntesis; declarar que la matriz es del autor y no una preferencia de usuarios. |
| Restricción sin pantalla | Mantener como decisión central | Es el núcleo investigable de la propuesta y una condición explícita del proyecto. | Justificarla desde la hipótesis de asociación, privacidad, autonomía y carga; retirar toda insinuación de que la ausencia de pantalla garantiza recuerdo. |
| Definición de Relevo | Mantener y adelantar dentro de la propuesta | La definición es comprensible y distingue app, testigo, lugar y persona. | Crear una definición de una página al inicio y conservar una versión técnica ampliada después de alternativas. |
| Sistema y secuencia | Mantener y separar | La tabla de partes y límites es sólida. | Ubicar la arquitectura funcional junto con los flujos; reservar el capítulo de propuesta para el sentido del sistema y el de experiencia para estados, acciones y fallos. |
| Modalidad y control | Mantener, pero dejar como hipótesis | Los canales configurables y la ausencia de evaluación están bien planteados. | Retirar del cuerpo principal los parámetros exactos no probados o marcarlos como especificaciones provisionales; llevar detalles a factibilidad/protocolo. |
| Factibilidad tecnológica | Mantener y jerarquizar | Demuestra conciencia de permisos, segundo plano, BLE, energía y restricciones. | Presentar solo las decisiones necesarias para entender el sistema en el cuerpo; dejar hojas de datos y detalle de componentes en anexo. No fijar arquitectura final antes de pruebas. |
| Producción y costos | Ampliar | La BOM y los rangos son transparentes, pero todavía son escenarios de ingeniería. | Añadir ruta de producción, responsables, proveedores, mantenimiento, reparación, cumplimiento, escala y diferencias entre costo de prototipo, costo de producción y precio. |
| Modelo de gestión | Reemplazar/ampliar | Hoy está disperso entre rol profesional, producción y factibilidad organizacional. | Crear un apartado visible con actores, tareas, recursos, hitos, puertas, dependencias, riesgos, mantenimiento y condiciones de continuidad o abandono. |
| Validación | Mantener y separar estado | Las pruebas están planteadas como puertas de diseño y no como inferencia estadística, lo que es correcto. | Distinguir protocolo previsto, prueba realizada, resultado, interpretación, cambio y limitación. No presentar umbrales como evidencia si aún no se han probado. |
| Arquitectura de experiencia | Reubicar | Tiene flujos de usuario, estados, técnica y diseño, pero aparece después de factibilidad. | Integrarla inmediatamente después de la definición del sistema; usarla como base para producir, probar y especificar. |
| Conclusiones | Ampliar | Recuperan el giro conceptual y reconocen la hipótesis principal. | Responder una por una las preguntas, declarar la contribución disciplinar, separar logros de pendientes y explicar qué resultado podría cambiar o abandonar Relevo. |
| Índice y figuras | Mantener solo como soporte | El índice tiene paginación fija y las figuras dependen de marcadores de la fuente DOCX. | Generar el índice al cerrar la edición; no permitir que marcadores de imagen sustituyan explicaciones textuales. La visualidad puede quedar para la actualización, pero la arquitectura debe ser legible sin ella. |
| Anexos | Mantener y vincular mejor | Los anexos conservan trazabilidad, instrumentos y factibilidad. | Cada anexo debe ser convocado desde el capítulo principal y responder a una función; no usar anexos para esconder decisiones esenciales. |

## 5. Arquitectura completa recomendada para Proyecto de Título

La siguiente propuesta mantiene una extensión manejable y hace visibles los cuatro bloques exigibles: antecedentes, investigación, diseño y producción. El orden es argumental: no pretende negar que el proyecto haya avanzado de forma iterativa. La cronología del proceso puede aparecer en un apartado propio y en el Anexo D, pero el lector debe recibir primero la cadena causal del proyecto.

### Elementos preliminares

Antes del capítulo 1 deberían aparecer portada, resumen, palabras clave, abstract, índice y una ficha breve de proyecto. La ficha no reemplaza la introducción: permite que el lector entienda en una página qué es Relevo, qué problema aborda, qué no hace, cuál es su estado y cuál es la pregunta que guía la evaluación.

La ficha debe contener únicamente:

- problema delimitado;
- usuario principal y usuario límite como situaciones, no como segmentos rígidos;
- pregunta de investigación;
- tesis provisional;
- sistema phygital propuesto;
- aporte esperado;
- estado de desarrollo y pendientes críticos.

### Capítulo 1. Introducción: problema, tesis y proyecto

**Propósito:** ubicar al lector desde el inicio y evitar que la memoria se perciba como un catálogo de componentes.

**Contenido mínimo:** escena hipotética breve; problema; pregunta; tesis provisional; definición sintética de Relevo; aporte disciplinar; exclusiones; recorrido de la memoria.

**Depende de:** ninguna sección previa; debe condensar el proyecto sin fingir resultados.

**Habilita:** la lectura de antecedentes, método y propuesta con una expectativa correcta.

La escena debe terminar con una advertencia: el proyecto aún debe comprobar si la asociación física aporta algo que una notificación no aporta. Así la propuesta aparece temprano, pero su eficacia no se da por demostrada.

### Capítulo 2. Antecedentes, contexto y construcción del problema

**Propósito:** explicar de dónde surge el problema y por qué no se formula como reducción del tiempo de pantalla.

**Contenido mínimo:** evolución del proyecto; acceso y prácticas digitales pertinentes; ocio digital significativo; continuidad poco deliberada; conflicto de metas; herramientas existentes como antecedente del problema; límites de las métricas temporales; contexto doméstico como alcance a investigar, no como hecho universal.

**Depende de:** la tesis inicial y las fuentes de contexto.

**Habilita:** una formulación del problema que sea específica, no moralizante y verificable.

Aquí debe terminar el capítulo con una frase de oportunidad: falta explorar una ayuda autoelegida, situada y no evaluativa para recuperar una intención, siempre que el objeto físico demuestre un valor adicional.

### Capítulo 3. Pregunta, objetivos, alcance y criterios de investigación

**Propósito:** convertir el problema en un programa de trabajo explícito.

**Contenido mínimo:** pregunta de investigación; pregunta proyectual; objetivo general; objetivos específicos de investigar, diseñar, producir y evaluar; hipótesis; alcance; exclusiones; criterios iniciales de éxito, cambio y abandono.

**Depende de:** capítulo 2.

**Habilita:** el diseño metodológico y la evaluación de decisiones.

La hipótesis debe conservar la comparación entre ubicación congruente, ubicación neutra y, en una segunda etapa, notificación. Debe aclararse cuál es el contraste primario y cuál es secundario.

### Capítulo 4. Diseño metodológico y plan de trabajo

**Propósito:** demostrar cómo se produjo el conocimiento utilizado para diseñar.

**Contenido mínimo:** enfoque cualitativo exploratorio; entrevistas semiestructuradas presenciales; reclutamiento por referencias; criterio común de edad; corpus P1–P8; consentimiento oral; anonimización; asistencia automatizada posterior limitada a transcripción y formalización; límites del registro; estrategia de análisis; revisión bibliográfica; análisis de mercado; investigación mediante diseño; plan de prototipos y criterios de decisión.

**Depende de:** preguntas y objetivos del capítulo 3.

**Habilita:** la lectura válida de los hallazgos de usuarios, del mercado y de las pruebas.

La memoria no debe llamar «repregunta IA» a ninguna pregunta realizada en las entrevistas. Si el rótulo aparece en archivos históricos, debe quedar fuera del registro vigente porque contradice el origen confirmado del levantamiento.

### Capítulo 5. Marco teórico y conceptual

**Propósito:** explicar los mecanismos que permiten interpretar el problema y orientar el diseño sin convertir la teoría en una garantía de eficacia.

**Contenido mínimo:** memoria prospectiva; descarga de intenciones; intenciones de implementación; cognición situada y uso del espacio; percepción y autonomía; límites de aplicar estos conceptos al ocio doméstico.

**Depende de:** preguntas del capítulo 3 y método de revisión del capítulo 4.

**Habilita:** categorías de análisis y criterios para la síntesis.

Cada subapartado debe cerrar con una traducción prudente: qué requisito sugiere, qué no demuestra y qué prueba requiere. La tabla de síntesis teórica debe trasladarse o ampliarse en el capítulo 8, donde se conectará con usuarios y mercado.

### Capítulo 6. Estudio de usuarios y contextos de uso

**Propósito:** mostrar qué se aprendió de las ocho entrevistas y cómo se construyen los dos tipos situacionales.

**Contenido mínimo:** procedencia del corpus; hallazgos respaldados; casos afirmativos, parciales y negativos; ocio digital valorado; conflictos situacionales; alternativas concretas; necesidades, tensiones y límites de intervención; usuario principal; usuario límite; contexto doméstico como hipótesis; implicaciones de diseño.

**Depende de:** método del capítulo 4 y categorías del capítulo 5.

**Habilita:** criterios de usuario y condiciones de no intervención.

No se deben presentar las edades ni los casos como segmentación de mercado. El usuario principal describe una situación de intención desplazada; el usuario límite muestra cuándo Relevo debe permanecer silencioso o no intervenir.

### Capítulo 7. Estado del arte, mercado y referentes

**Propósito:** situar Relevo frente a lo que ya existe y explicar por qué el proyecto no es simplemente otro bloqueador.

**Contenido mínimo:** literatura sobre herramientas de autocontrol digital; familias de mecanismos; productos comerciales; objetos y proyectos tangibles; qué problema resuelve cada mecanismo; cargas, límites, evidencia disponible, modelo de uso y espacio de oportunidad.

**Depende de:** problema, preguntas, método de búsqueda y marco teórico.

**Habilita:** una oportunidad de diseño defendible y una comparación posterior con notificación.

La conclusión no debe ser «no existe nada igual» en sentido absoluto. Debe indicar que, en el corpus revisado, no se identificó una combinación determinada y que esa ausencia es provisional. La oportunidad debe formularse como una pregunta de diseño, no como una superioridad de Relevo.

### Capítulo 8. Síntesis de investigación y oportunidad de diseño

**Propósito:** ser el puente explícito entre investigación y decisiones de diseño.

**Contenido mínimo:** matriz de evidencia; hallazgo; interpretación; requisito; no requisito; hipótesis; alternativa descartada; decisión; prueba asociada; estado.

**Depende de:** capítulos 5, 6 y 7.

**Habilita:** desarrollo formal, propuesta, producción y evaluación.

La síntesis debe responder cinco preguntas:

1. ¿Qué problema se conserva después de mirar la evidencia?
2. ¿Para quién y en qué situación es pertinente?
3. ¿Por qué una intervención física podría ser necesaria o valiosa?
4. ¿Qué debe hacer y qué debe evitar el sistema?
5. ¿Qué resultado obligaría a cambiar o abandonar la propuesta?

Este capítulo debe justificar, entre otras decisiones, que el objeto no tenga pantalla, que una sola intención permanezca activa, que la persona configure la regla y que el sistema no registre cumplimiento. La decisión sin pantalla no debe aparecer solamente como una preferencia formal.

### Capítulo 9. Desarrollo de diseño y selección de dirección

**Propósito:** demostrar cómo se llegó a la forma y a la arquitectura elegidas.

**Contenido mínimo:** familias objetuales; criterios comparativos; alternativas; ventajas y riesgos; descarte de cuna, e-paper u otras variantes cuando corresponda; selección del testigo transportable; estado de las metas formales; relación entre forma, ubicación, percepción, privacidad, autonomía y costo.

**Depende de:** capítulo 8.

**Habilita:** la descripción de Relevo como sistema y no como intuición formal.

La matriz de alternativas debe indicar que es una evaluación del autor. Las siluetas no demuestran preferencia de usuarios. La forma coral, el diámetro, el grosor, el ojal y los canales deben clasificarse como decisiones, metas o hipótesis, según el grado de respaldo alcanzado.

### Capítulo 10. Relevo: sistema y propuesta phygital

**Propósito:** definir qué se diseñó, cuál es su sentido y cómo se relacionan sus partes.

**Contenido mínimo:** aplicación Android; testigo físico sin pantalla; lugar; intención; primer paso; condición; señal; controles; límites; privacidad; autonomía; interacción entre lo físico y lo digital; definición de lo que el sistema hace y no hace.

**Depende de:** capítulos 8 y 9.

**Habilita:** flujos de experiencia, arquitectura técnica y producción.

La propuesta debe presentarse antes del detalle electrónico. La aplicación no debe parecer el producto principal y el testigo no debe parecer un accesorio decorativo. El valor es la relación entre configuración digital, señal física y contexto situado.

### Capítulo 11. Arquitectura de experiencia y flujos del sistema

**Propósito:** hacer comprensible cómo se usa y cómo funciona Relevo antes de evaluar si puede producirse.

**Contenido mínimo:** flujo de usuario; flujo del sistema; estados; controles; flujo técnico; excepciones; permisos; señal tardía; pérdida de enlace; batería; privacidad; accesibilidad; separación entre decisión de la persona y operación automática.

**Depende de:** capítulo 10.

**Habilita:** especificación de prototipos, costos, roles y pruebas.

Debe diferenciarse claramente:

- **Flujo de usuario:** lo que la persona configura, sitúa, arma, percibe y decide.
- **Flujo del sistema:** estados y respuestas de la aplicación y del testigo.
- **Flujo técnico:** permisos, consulta de uso, comando BLE, confirmación, pérdida de enlace y expiración.
- **Flujo de diseño:** cómo cada prueba cambia o conserva una decisión.

La versión vigente ya posee estos materiales; el ajuste principal es trasladarlos a la posición argumental correcta y evitar repetir la misma definición en los capítulos 8 y 11.

### Capítulo 12. Producción, factibilidad y modelo de gestión

**Propósito:** demostrar que el proyecto puede organizarse, fabricarse, mantenerse y evaluarse con recursos y responsabilidades identificables.

**Contenido mínimo:** niveles de prototipo; materiales y componentes; energía; producción y ensamblaje; costos separados por etapa; costo profesional; precio como hipótesis; cumplimiento regulatorio; reparación; fin de vida; privacidad; accesibilidad; mantenimiento; actores; responsabilidades; recursos; hitos; riesgos; proveedores; dependencia técnica; criterios para continuar, modificar o abandonar.

**Depende de:** capítulos 10 y 11.

**Habilita:** la producción del prototipo y la evaluación de factibilidad.

El modelo de gestión debe especificar, al menos:

| Elemento | Pregunta que debe responder |
| --- | --- |
| Dirección de diseño | ¿Qué decisiones coordina el diseñador y cuáles requieren colaboración especializada? |
| Desarrollo técnico | ¿Quién implementa Android, BLE, firmware y pruebas de compatibilidad? |
| Producción | ¿Quién fabrica, ensambla, prueba y repara el testigo? |
| Operación | ¿Qué debe hacer la persona para configurar y mantener el sistema? |
| Recursos | ¿Qué tiempo, materiales, herramientas y presupuesto requiere cada etapa? |
| Riesgos | ¿Qué permisos, fallos, molestias o restricciones pueden detener el proyecto? |
| Escala | ¿Qué cambia entre prototipo académico, pequeña serie y producto comercial? |
| Abandono | ¿Qué resultado vuelve desproporcionada la carga física, técnica o económica? |

La BOM actual no debe desaparecer, pero sí debe presentarse como una parte de este modelo y no como sustituto de la gestión.

### Capítulo 13. Prototipado, evaluación y resultados

**Propósito:** mostrar qué se probó, qué se observó y cómo esas observaciones modifican la propuesta.

**Contenido mínimo:** pregunta de cada prototipo; fidelidad; participantes o condiciones; procedimiento; indicadores; resultados reales; contraejemplos; interpretación; cambio; límite; siguiente puerta.

**Depende de:** propuesta, flujos, factibilidad y protocolo.

**Habilita:** conclusiones defendibles.

Mientras las pruebas no existan, el capítulo solo puede presentar protocolo, estado y criterios. No debe usar frases como «se comprobó», «la persona recupera» o «el objeto funciona» si solo existe una hipótesis o una simulación. Los umbrales 4/5, 90 % y 6–8 personas son puertas de prototipo, no resultados ni evidencia poblacional.

### Capítulo 14. Conclusiones, contribución y límites

**Propósito:** cerrar la tesis respondiendo las preguntas y haciendo explícito qué valor aporta el proyecto de diseño.

**Contenido mínimo:** respuesta a la pregunta de investigación; respuesta a la pregunta proyectual; decisiones conservadas; decisiones modificadas; contribución disciplinar; resultado de prototipos; límites del corpus; límites técnicos; límites de mercado; condiciones de transferencia; próximos pasos únicos y verificables.

**Depende de:** todos los capítulos, especialmente síntesis, producción y resultados.

**Habilita:** una conclusión que no confunda coherencia interna con eficacia demostrada.

La conclusión debe volver a la escena inicial y marcar qué parte quedó apoyada, qué parte sigue siendo hipótesis y qué parte debe abandonarse si la comparación con notificación no muestra un aporte físico específico.

### Referencias y anexos

Las referencias deben conservar APA 7 y distinguir papers, documentación técnica, fuentes institucionales y comunicación comercial. Los anexos actuales son valiosos, pero deben funcionar como evidencia ampliada, no como lugar donde se ocultan el método o las decisiones principales.

El Anexo A debe respaldar el estudio de junio; el Anexo B, instrumentos futuros; el Anexo C, factibilidad; el Anexo D, protocolo y cronología; y el Anexo E, declaración de uso de inteligencia artificial. Cada anexo debe ser citado desde un capítulo principal y declarar si contiene material realizado, planificado o histórico.

## 6. Riesgos críticos para la memoria

| Prioridad | Riesgo | Por qué compromete el Proyecto de Título | Acción requerida |
| --- | --- | --- | --- |
| P0 | Tesis central implícita | El lector puede conocer el objeto, pero no el problema ni el aporte antes de llegar al final. | Insertar tesis, límites y refutación en la introducción y desarrollar el arco completo. |
| P0 | Falta de capítulo explícito de antecedentes y síntesis | La relación entre fuentes, entrevistas y decisiones queda reconstruible, no demostrada. | Crear capítulos visibles de antecedentes y síntesis de oportunidad. |
| P0 | Producción sin modelo de gestión reconocible | El instructivo y la síntesis del Reglamento exigen investigación, diseño y producción, y el Reglamento agrega gestión. | Integrar un capítulo de producción, factibilidad y gestión con actores, recursos, etapas y riesgos. |
| P0 | Futuro presentado como estado actual | Protocolos, costos y pruebas previstas pueden parecer resultados. | Etiquetar cada afirmación como realizado, en curso, planificado, hipótesis o decisión. |
| P1 | Método insuficientemente visible | Los hallazgos de usuarios aparecen sin una explicación metodológica completa en la secuencia principal. | Separar diseño metodológico de hallazgos; conservar límites sin invalidar el corpus. |
| P1 | Duplicación entre propuesta y arquitectura de experiencia | Relevo se define varias veces y el lector no sabe cuál descripción es normativa. | Definir una vez el sentido del sistema y una vez su operación detallada. |
| P1 | El objeto puede absorber el proyecto | La forma, la electrónica y el costo ocupan espacio antes de demostrar el aporte físico. | Reordenar: problema → evidencia → oportunidad → dirección → sistema → producción. |
| P1 | Justificación física aún no probada | Si una notificación entrega el mismo valor con menor carga, la materialidad pierde fundamento. | Mantener comparación explícita como prueba de falsación, no como promesa de superioridad. |
| P1 | Condición operacional sin resolver | Sin definir qué significa que la sesión alcance la condición, el sistema no puede evaluarse ni producirse con precisión. | Tratarla como decisión pendiente central y no como detalle técnico secundario. |
| P2 | Contexto doméstico sobregeneralizado | Las entrevistas no observaron sistemáticamente hogares ni distribución espacial. | Presentar el hogar como alcance provisional y probar asociación, convivencia y disponibilidad de superficies. |
| P2 | Parámetros exactos adelantados | Diámetro, duración, corriente, costo y precio pueden adquirir apariencia de especificación final sin validación. | Separar meta, supuesto de ingeniería, cotización y resultado medido. |
| P2 | Índice y marcadores visuales heredados del DOCX | Paginaciones fijas y figuras no disponibles pueden producir una lectura de documento incompleto. | Generar índice al final y garantizar que el argumento sea comprensible aunque la visualidad se actualice después. |

## 7. Preguntas que deben resolverse antes de cerrar la reestructuración

Estas preguntas no deben responderse con redacción especulativa:

1. ¿La condición de activación será tiempo acumulado en una aplicación, continuidad dentro de una misma sesión, una ventana horaria o una combinación? La respuesta cambia la pregunta de investigación, el flujo técnico y la validación.
2. ¿Qué prototipos y pruebas existirán efectivamente al momento de la memoria final? La estructura debe reservar un espacio para resultados reales, no llenar ese espacio con protocolos.
3. ¿El hogar es un alcance del MVP —producto mínimo viable— o solo el primer contexto de prueba? Esta diferencia afecta usuario, mercado, producción y generalización.
4. ¿Qué modelo de gestión se quiere demostrar: prototipo académico individual, pequeña serie, producto comercial o sistema transferible a un equipo? No es válido mezclar los cuatro sin declarar escenarios.
5. ¿Cuál es el mínimo de valor que Relevo debe aportar frente a una notificación para justificar objeto, batería, carga, costo y mantenimiento?
6. ¿Qué se considera una señal correctamente recuperada: recordar la intención, recordar el primer paso, identificar el lugar, no consultar el teléfono o una combinación? Debe existir una definición antes de presentar resultados.
7. ¿Qué decisión se tomará si la asociación sin texto falla pero la señal física sí se percibe? La alternativa de añadir una marca táctil o visual debe quedar prevista sin contradecir la restricción de no incorporar pantalla.

Las dos preguntas con mayor impacto inmediato son la condición operacional y el estado real de prototipos/resultados. Si no se resuelven, cualquier capítulo técnico o de validación puede quedar escrito sobre una arquitectura provisional.

## 8. Secuencia de corrección recomendada

La reestructuración debe ejecutarse en una sola línea sustantiva y en este orden:

1. Aprobar la tesis central, su alcance y su condición de refutación.
2. Reordenar los títulos principales según la arquitectura propuesta, sin borrar aún contenido.
3. Separar antecedentes, método, hallazgos, teoría, mercado y síntesis.
4. Construir la matriz evidencia → criterio → decisión → prueba.
5. Reubicar desarrollo formal, propuesta y arquitectura de experiencia.
6. Integrar producción, costos, factibilidad y modelo de gestión en un bloque principal.
7. Actualizar validación con una separación visible entre realizado, planificado y pendiente.
8. Reescribir la introducción y las conclusiones cuando el cuerpo ya esté estable.
9. Ejecutar una auditoría final de afirmaciones, referencias, privacidad, redundancia, ortografía y estados documentales.

No se recomienda comenzar por la forma, el diseño visual ni el detalle de la electrónica. La forma y la implementación deben recibir el argumento ya ordenado para que no vuelvan a ocupar el lugar de la investigación.

## Registro de cambios (disclaimer)

### 2026-08-24 — Creación del informe de auditoría

- **Cambio:** se creó este informe con el diagnóstico de la arquitectura narrativa, la auditoría de la tesis central, la comparación con el instructivo institucional, una matriz de mantener/reemplazar/ampliar/retirar, una arquitectura completa de Proyecto de Título, riesgos críticos y preguntas pendientes.
- **Versión anterior:** no existía un informe específico de Auditoría 1 sobre arquitectura narrativa y tesis central.
- **Motivo:** hacer visible la diferencia entre la coherencia conceptual actual de Relevo y las exigencias estructurales de una memoria de Proyecto de Título, especialmente antecedentes, método, síntesis, producción y modelo de gestión.
- **Fuentes de contraste:** `INSTRUCCIONES_CHATGPT.md`, `00_gobernanza/directrices-de-trabajo.md`, `08_memoria/memoria-vigente.md`, `08_memoria/matriz-incorporacion-feedback-e15.md`, `INSTRUCTIVO EXAMEN PROYECTO DE TÍTULO 2026.docx`, `Acta Examen PROYECTO DE TÍTULO 2026.docx` y la síntesis del Reglamento entregada en la instrucción de esta auditoría.
- **Alcance:** informe interno para la integración posterior por el modelo principal. No modifica `08_memoria/memoria-vigente.md`, no reemplaza decisiones del autor, no inventa resultados de entrevistas o validaciones y no contiene commit ni push.
