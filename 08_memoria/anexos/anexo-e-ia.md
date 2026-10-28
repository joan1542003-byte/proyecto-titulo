# Anexo E. Uso de inteligencia artificial

> Parte de los [anexos de la memoria](README.md). Se genera con `node construir-anexos.js` desde sus documentos fuente: para corregirlo, se corrige la fuente y se vuelve a generar.

Declara qué herramientas de inteligencia artificial se usaron, en qué tareas ayudaron y qué decidió el autor en cada caso. El registro de cada pedido, que se lleva a diario desde el 29 de septiembre de 2026, no se imprime aquí: está abierto en el repositorio del proyecto.

## E.1 Declaración

**Fecha:** 27 de octubre de 2026. **Para qué:** declarar el uso de herramientas de inteligencia artificial generativa en el desarrollo de Relevo, las tareas en que intervinieron y las decisiones que corresponden al autor. Es la fuente del Anexo E de la memoria.

### Herramientas

El proyecto utilizó herramientas de inteligencia artificial generativa de dos proveedores, con funciones distintas.

**ChatGPT**, de OpenAI, se empleó desde marzo de 2026. Es un asistente conversacional de propósito general: recibe texto y devuelve texto, sin acceso a los archivos del proyecto, de modo que cada consulta exigió pegar el material pertinente y trasladar después el resultado al documento. Acompañó la etapa de investigación y la primera redacción de la memoria.

**Codex**, el agente de programación de OpenAI, opera en cambio sobre los archivos: recibe una instrucción, modifica el proyecto y devuelve el resultado. Con él se escribieron las primeras versiones de la aplicación y las piezas web del repositorio, que conservan las instrucciones de trabajo redactadas para esa herramienta.

**Claude Code**, de Anthropic, se empleó desde fines de septiembre de 2026 y fue la herramienta principal de la etapa final. Trabaja también dentro del repositorio y, además, deja constancia de cada cambio en el control de versiones, lo que permite revisarlo, atribuirlo y revertirlo. Esa trazabilidad es la que sostiene el registro que se describe más adelante.

### Tareas

**Redacción y corrección.** Las herramientas propusieron reescrituras de párrafos poco claros, señalaron repeticiones, unificaron el tono entre documentos de distintas fechas y corrigieron ortografía y puntuación. El contenido y el criterio son del autor; la herramienta ofreció formas de expresarlo.

**Búsqueda y selección de fuentes.** La búsqueda bibliográfica se apoyó en la herramienta para revisar un volumen de referencias mayor al que permitía el tiempo disponible y para descartar las que no respondían a la pregunta. El procedimiento fue el mismo en cada caso: la herramienta propuso candidatas con su ficha; el autor las revisó una por una y, cuando una servía al proyecto, la leyó antes de incorporarla. Así se construyeron el estado del arte del capítulo 8 y la auditoría de la categoría, y así se identificaron las memorias de título chilenas que exigía el Pase de junio.

**Verificación de citas.** Se revisó la correspondencia entre citas y referencias en ambos sentidos, y la uniformidad del formato APA 7 en las cien referencias de la memoria.

**Desarrollo de la aplicación Android.** Es la intervención de mayor alcance. El autor no programa en Kotlin, y el prototipo existe porque estas herramientas escribieron el código a partir de especificaciones suyas: qué debía ocurrir, en qué pantalla y con qué palabras. El Anexo G documenta las versiones resultantes, entre ellas las que resolvieron problemas detectados durante la prueba de uso. El autor instaló y probó cada versión, informó las fallas y decidió cuáles se incorporaban.

**Organización documental.** Mantención del estado del proyecto, el registro de riesgos, el registro de decisiones y el propio registro de pedidos.

### Decisiones

Corresponden al autor la definición del problema, la pregunta, la hipótesis y los objetivos; la selección de las personas entrevistadas y las repreguntas; la formulación de los ocho criterios de diseño; la elección de la identidad visual entre las propuestas recibidas; la versión de la aplicación instalada en los teléfonos de la prueba, y la responsabilidad por las citas y por las conclusiones. Cada salida de la herramienta constituyó una propuesta sujeta a revisión, corrección o descarte.

### Límites y resguardos

No se generaron datos, participantes, citas ni resultados. Las imágenes producidas con estas herramientas se identifican como visualizaciones conceptuales y en ningún caso como registro fotográfico de un prototipo o de su uso. Cuando no se conservó el texto literal de un pedido, se consigna una síntesis y no se reconstruye una transcripción.

### Trazabilidad

El [registro de pedidos a la IA](../../00_gobernanza/registro-de-pedidos-a-la-ia.md) consigna, desde el 29 de septiembre de 2026 y con periodicidad diaria, cada pedido del autor, su tipo, el resultado obtenido y la decisión asociada. El período anterior está reconstruido parcialmente en la [trazabilidad del 23 de septiembre](../../00_gobernanza/trazabilidad-uso-ia-2026-09-23.md). Ambos registros permanecen en el repositorio público del proyecto y no se reproducen en la memoria.

## E.2 Ficha para cada producción con IA

Copiar una ficha por tarea o conjunto de variantes. Conservar el prompt literal cuando exista. Si solo se dispone de una reconstrucción, marcarla como **síntesis posterior**.

```text
ID, fecha y autor responsable:
Fase y pregunta de diseño:
Herramienta/modelo (si se conoce):
Tipo de uso: búsqueda / análisis / redacción / imagen / código / auditoría
Fuentes entregadas: archivo, versión, enlace y restricciones de privacidad
Prompt literal (o «síntesis posterior», nunca entrecomillada como original):
Resultado recibido: archivo/enlace, variantes y fecha
Revisión humana: fuentes comprobadas, errores, exclusiones, licencias, accesibilidad
Decisión del autor: adoptar / editar / descartar y motivo
Efecto en Relevo: documento/artefacto modificado y prueba pendiente
Límite: qué no demuestra la salida
```

No introducir transcripciones identificables de P1–P8, hojas firmadas, claves ni datos remotos en un prompt sin base de tratamiento, autorización y necesidad documentadas. Para explicar la evolución ante la comisión, mostrar un ejemplo **antes → prompt y contexto → salida → corrección humana → versión incorporada**, con el archivo del prompt y la decisión verificables. Los registros de B2a/B2b y D1 ofrecen ejemplos reales de esa secuencia.

## Registro de cambios (disclaimer)

### 2026-10-24 — Creación

- **Qué cambió:** el anexo se arma desde sus documentos fuente, con el resto de los anexos A–I de la memoria v5.
- **Cómo estaba antes:** la carpeta de anexos solo tenía un README de la v4, con cinco anexos y sin su contenido.
- **Por qué:** el autor pidió elegir un pendiente de prioridad alta y terminarlo; la memoria v5 remite a nueve anexos que no estaban armados.
