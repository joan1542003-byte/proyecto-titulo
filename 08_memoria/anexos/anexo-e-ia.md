# Anexo E. Uso de inteligencia artificial

> Parte de los [anexos de la memoria](README.md). Se genera con `node construir-anexos.js` desde sus documentos fuente: para corregirlo, se corrige la fuente y se vuelve a generar.

Declara qué herramientas de inteligencia artificial se usaron, en qué tareas ayudaron y qué decidió el autor en cada caso. El registro de cada pedido, que se lleva a diario desde el 29 de septiembre de 2026, no se imprime aquí: está abierto en el repositorio del proyecto.

## E.1 Qué se usó y en qué ayudó

**Fecha:** 27 de octubre de 2026. **Para qué:** declarar, en pocas páginas, qué herramientas de inteligencia artificial se usaron, en qué ayudaron y qué decidió el autor. El registro detallado de cada pedido sigue en el repositorio; aquí va el resumen.

### Qué se usó

Dos herramientas, en dos momentos distintos:

- **ChatGPT**, de OpenAI, en su plan Plus, desde marzo de 2026. Acompañó la primera mitad del proyecto: leer, redactar, ordenar ideas y buscar. De ese período no quedó registro de qué modelo respondió en cada conversación.
- **Claude**, de Anthropic, desde fines de septiembre de 2026, sobre todo a través de **Claude Code**, que trabaja dentro del repositorio: lee los archivos, propone cambios y los deja escritos. Los modelos constan en la firma de cada cambio guardado: Opus 5.5 en 158, Opus 5 en 13 y Sonnet 5.5 en 5.

Entre el 24 de septiembre y el 27 de octubre, **176 cambios del repositorio están cofirmados** por esa herramienta, y el registro diario reúne **172 pedidos del autor** con su resultado.

### En qué ayudó

**Redacción y ortografía.** Reescribir párrafos que no se entendían, quitar repeticiones, mantener un mismo tono en documentos escritos en meses distintos y corregir la ortografía. El criterio y el contenido son del autor; la herramienta propuso formas de decirlo.

**Buscar fuentes en volumen y filtrarlas.** Revisar muchas más referencias de las que alcanzaría a leer una persona en el tiempo disponible, descartar las que no servían y quedarse con las pertinentes. Así se armaron el estado del arte del capítulo 8 y la auditoría de la categoría, y así se encontraron las memorias de título chilenas que pedía el Pase de junio.

**Revisar las citas en APA 7.** Comprobar que cada cita del texto tuviera su referencia, que cada referencia estuviera citada, y que el formato fuera el mismo en las 100 referencias de la memoria.

**El desarrollo de la aplicación Android.** Es el aporte más grande. El autor no programa en Kotlin, y la aplicación existe porque la herramienta escribió el código a partir de lo que él especificó: qué debía ocurrir, en qué pantalla y con qué palabras. Están documentadas **31 versiones**, desde la 2.4 hasta la 3.3, incluidas las que resolvieron problemas reales de la prueba —que el Tag se callara siempre, que un relevo se pudiera editar sin borrarlo, que el aviso también pudiera salir por el teléfono—. El autor probó cada versión en el teléfono, reportó lo que fallaba y decidió qué entraba.

**Ordenar y registrar.** Mantener al día el estado del proyecto, los riesgos, las decisiones y este mismo registro.

### Qué decidió el autor

La pregunta, la hipótesis y los objetivos; a quién entrevistar y qué repreguntar; los ocho criterios de diseño; qué versión se instalaba en los teléfonos de la prueba; la identidad visual, elegida entre propuestas; y la responsabilidad por las citas y por las conclusiones. Cada salida de la herramienta fue una propuesta que él aceptó, corrigió o descartó, y eso queda anotado en el registro.

### Lo que no se hizo

No se generaron datos, participantes, citas ni resultados. Las imágenes conceptuales se identifican como tales y nunca como fotografía de un prototipo. Donde no se conservó el pedido literal, se anota una síntesis y no se finge una transcripción.

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
