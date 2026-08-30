# Preparación escrita de Encargo 17

## Estado de preparación

Este documento registra la preparación utilizada para desarrollar los wireframes del Encargo 17. La memoria v2 fue su base durante esa etapa; para cualquier revisión posterior, la fuente académica activa es la [memoria v4](../08_memoria/memoria-vigente-v4.md). La entrega no fija eficacia, forma, materialidad, canal sensorial ni condición definitiva: traduce la arquitectura a un recorrido estructural de baja fidelidad.

## Ciclo mínimo representado

El recorrido se acota a una persona, una intención, un primer paso, una aplicación seleccionada, una condición observable provisional, un testigo situado y un pulso ambiental. La persona configura el ciclo en Android, sitúa y prueba el testigo, y confirma el armado mediante una pulsación prolongada en el control físico. Cuando la condición se cumple, el testigo emite un único pulso. El ciclo termina después de la señal, al silenciarse, al vencer o al desarmarse; nunca se rearma automáticamente ni registra cumplimiento.

El armado físico es una decisión provisional de interacción para esta entrega. Permite que la última confirmación ocurra donde se situó el testigo y no demuestra que ese gesto sea comprensible, accesible o definitivo.

## Recorrido conectado

1. **Formular y preparar:** intención → primer paso → condición provisional → revisión.
2. **Situar, probar y armar:** lugar elegido → prueba perceptiva → confirmación física del armado.
3. **Recibir y cerrar:** espera → pulso situado → reposo o recuperación técnica.

La salida de cada interacción habilita la siguiente. El teléfono organiza el significado y los estados técnicos; el testigo representa la intención en el lugar elegido y emite la señal; la persona interpreta y decide.

## Interacción 1 — Formular y preparar una intención

### Objetivo

Convertir una intención autoformulada en un ciclo comprensible antes de vincularla con el testigo y el lugar.

### Marcos

1. **Intención y primer paso:** campos para registrar la actividad y la acción concreta que puede iniciarla.
2. **Condición del ciclo:** selección de aplicación, alternativa de condición observable y ventana; la condición mostrada es un ejemplo estructural, no una decisión validada.
3. **Revisión:** síntesis editable y acción principal `Continuar para situar`.

### Información crítica

Intención, primer paso, aplicación seleccionada, condición observable, ventana, alcance del permiso y estado de edición.

### Acción esperada

Revisar que la intención y el primer paso sean reconocibles y continuar hacia la asociación física. El ciclo todavía no queda armado.

### Jerarquía

1. Intención y primer paso.
2. Condición y ventana.
3. Alcance técnico del permiso.
4. Revisión y continuidad.

### Validaciones, errores y salida

- Campo incompleto: señalar qué falta sin interpretar la motivación.
- Permiso ausente: explicar el alcance y abrir la configuración del sistema.
- Condición no observable: impedir el armado técnico, no calificar la intención.
- Salida voluntaria: permitir abandonar sin penalización y guardar borrador solo si la persona lo elige.

### Leyenda para la entrega

Esta interacción transforma una intención propia en un ciclo configurable.
La secuencia prioriza intención y primer paso antes de la condición técnica.
Android conserva el significado y explica el permiso sin inferir el estado subjetivo.
La revisión evita trasladar errores de contenido al momento de situar el testigo.

## Interacción 2 — Situar, probar y armar el testigo

### Objetivo

Crear una relación explícita entre intención, primer paso, lugar y señal antes de dejar el ciclo en espera.

### Marcos

1. **Situar:** instrucción para colocar el testigo junto al primer paso y declarar el lugar mediante texto; Android no detecta esa ubicación.
2. **Probar el pulso:** estado de vínculo y batería, acción `Probar pulso` y respuesta `Lo percibí` o `Ajustar`.
3. **Armar en el lugar:** Android informa que el ciclo está listo; la persona mantiene presionado el control físico y recibe confirmación técnica de estado armado.

### Información crítica

Lugar elegido, intención asociada, estado del vínculo, batería, resultado de prueba, ventana y estado listo/armado.

### Acción esperada

Situar el testigo, comprobar que la señal es perceptible y tolerable, y armar el ciclo de forma explícita desde el lugar elegido.

### Jerarquía

1. Relación con el lugar.
2. Percepción y tolerancia de la prueba.
3. Estado técnico indispensable.
4. Confirmación física del armado.

### Errores y salida

- Testigo incorrecto o desconectado: detener el avance y permitir revincular.
- Batería insuficiente: no permitir un armado que aparente fiabilidad.
- Señal no percibida o intrusiva: ajustar canal, intensidad o lugar antes de continuar.
- Armado ambiguo: mantener estado `Listo para armar` y ofrecer repetición guiada.

### Leyenda para la entrega

Esta interacción vincula el ciclo digital con el lugar donde puede comenzar el primer paso.
La prueba separa disponibilidad técnica de percepción y tolerancia.
El armado físico confirma que la persona se encuentra junto al testigo situado.
La asociación permanece manual: Android no detecta ni valida el lugar.

## Interacción 3 — Recibir el pulso y cerrar el ciclo

### Objetivo

Representar el momento principal de Relevo y cerrar el ciclo sin convertir la decisión posterior en cumplimiento.

### Marcos

1. **Espera:** estado Android resumido; permite desarmar, pero no exige mantener la aplicación abierta.
2. **Momento phygital:** marco contextual del testigo emitiendo el pulso junto al primer paso. Las salidas válidas son iniciar, continuar, ignorar o silenciar; ninguna se registra.
3. **Cierre o fallo:** estado Android disponible después, con ciclo terminado y rearme explícito; una variante alternativa del mismo marco muestra fallo técnico y descarta comandos vencidos. Los estados normal y de error no aparecen simultáneamente durante el uso.

### Información crítica

Estado armado, vigencia de la ventana, estado técnico de entrega, cierre del ciclo y acciones de desarmar, editar, eliminar o rearmar.

### Acción esperada

Percibir e interpretar el pulso sin consultar el teléfono. La respuesta queda abierta. Android solo interviene después para comunicar cierre o recuperar un fallo técnico.

### Jerarquía

1. Pulso situado y relación con el primer paso.
2. Decisión autónoma de la persona.
3. Cierre del ciclo.
4. Recuperación técnica excepcional.

### Errores técnicos y salidas válidas

- Comando vencido: descartar, informar y volver a reposo; no reproducir tarde.
- Pérdida de enlace o batería: registrar fallo técnico sin atribuirlo a la persona.
- Señal ignorada o silenciada: salida válida; no pertenece a los errores.
- Rearmado: siempre explícito; nunca automático.

### Leyenda para la entrega

El pulso situado constituye el centro de esta interacción y ocurre fuera del teléfono.
El lugar busca devolver la intención al contexto donde su primer paso puede comenzar.
La persona puede iniciar, continuar, ignorar o silenciar sin ser evaluada.
Android solo comunica el cierre del ciclo o un fallo técnico posterior.

## Componentes que se etiquetarán

Encabezado; progreso; campo de texto; selector; tarjeta de estado; aviso técnico; acción principal; acción secundaria; estado del testigo; control físico; pulso ambiental; conexión entre marcos; variante de error.

## Reglas de representación

- Máximo tres marcos por interacción.
- Baja fidelidad, escala de grises y tipografía utilitaria Roboto; no constituye identidad visual.
- La condición presentada se rotula como provisional.
- El marco físico no contiene una interfaz de consulta instalada en el testigo.
- No se incorporan bloqueo, puntos, rachas, historial de cumplimiento ni juicio sobre la respuesta.
- Los fallos técnicos se distinguen de las decisiones de la persona.
- El recorrido normal no exige consultar Android después del pulso.

## Decisiones que permanecen abiertas después de la entrega

Condición de activación definitiva; canal, duración e intensidad del pulso; forma, materialidad y control final del testigo; gesto de salida; accesibilidad; convivencia; electrónica; costos reales y valor frente a una notificación equivalente. Estas decisiones requieren el Protocolo 01, comparaciones posteriores de modalidad y soporte, y pruebas técnicas de Android y del testigo; no bloquean un wireframe estructural.

---

## Registro de cambios (disclaimer)

### 2026-08-30 — Nomenclatura de validación vigente

- **Cambio:** la secuencia genérica P0–P4 fue reemplazada por las dependencias operativas vigentes: Protocolo 01, comparaciones posteriores y pruebas técnicas.
- **Versión anterior:** todas las decisiones abiertas se remitían a una nomenclatura anterior del plan de evaluación.
- **Motivo:** mantener esta preparación alineada con la matriz de requisitos y la Issue #8 sin alterar su valor histórico.
- **Alcance:** no se modificaron el ciclo, las tres interacciones ni los nueve marcos.

### 2026-08-26 — Sincronización documental con la memoria v4

- **Cambio:** se distinguió la base histórica de creación de la fuente académica que gobierna futuras revisiones.
- **Versión anterior:** la preparación seguía presentando la memoria v2 como activa.
- **Motivo:** conservar la trazabilidad del Encargo 17 sin permitir que una versión sustituida gobierne nuevos cambios.
- **Alcance:** no se alteraron el ciclo, las interacciones ni los wireframes.

### 2026-08-25 — Cierre estructural para wireframes

- **Cambio:** se reemplazó la tercera interacción centrada en estado técnico por `Recibir el pulso y cerrar el ciclo`, cuyo centro es el momento físico situado.
- **Versión anterior:** la tercera interacción era una pantalla Android provisional de estado y recuperación.
- **Motivo:** representar el valor phygital de Relevo sin convertir Android en el producto completo.
- **Cambio:** se cerró provisionalmente el armado mediante pulsación prolongada en el control físico y un único pulso por ciclo.
- **Versión anterior:** el armado podía ocurrir en Android, en el testigo o en ambas superficies; el rearme no estaba resuelto.
- **Motivo:** construir un recorrido coherente y comprobable para E17, manteniendo el gesto sujeto a evaluación.
- **Cambio:** se sustituyeron las preguntas abiertas por decisiones de entrega y por una lista separada de variables que requieren prototipado.
- **Versión anterior:** cinco preguntas impedían avanzar a Figma.
- **Motivo:** distinguir bloqueos de estructura de decisiones que pueden permanecer como hipótesis.
