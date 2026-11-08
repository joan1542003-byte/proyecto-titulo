# Anexo E. Uso de inteligencia artificial

Declara qué herramientas de inteligencia artificial se usaron en el proyecto, en qué tareas ayudaron y qué decidió el autor. El registro de cada pedido, que se lleva a diario desde el 29 de septiembre de 2026, está abierto en el repositorio del proyecto y no se reproduce aquí.

## E.1 Herramientas

El proyecto usó dos herramientas de inteligencia artificial generativa, de proveedores distintos. Ambas son agentes que trabajan sobre los archivos del proyecto —los leen, los modifican y devuelven el resultado—, y eso permitió encargarles tareas sostenidas, como programar la app o mantener la coherencia entre documentos escritos en meses distintos.

- **Codex, de OpenAI**, desde marzo de 2026, en la primera etapa: la investigación, la redacción inicial de la memoria y las primeras versiones de la app y de las piezas web. El repositorio conserva sus instrucciones de trabajo.
- **Claude Code, de Anthropic**, desde fines de septiembre de 2026, como herramienta principal de la etapa final. Registra cada cambio en el control de versiones del repositorio, con su autoría, de modo que puede revisarse, atribuirse y revertirse. El repositorio conserva también su archivo de reglas.

## E.2 Cinco tareas

1. **Programar la app y su base de datos.** Es la intervención de mayor alcance. El autor no programa en Kotlin: el prototipo existe porque estas herramientas escribieron el código a partir de sus especificaciones —qué debía ocurrir, en qué pantalla y con qué palabras—. El autor instaló y probó cada versión, informó las fallas y decidió qué se incorporaba (Anexo G).
2. **Generar alternativas visuales.** Propuestas de identidad, láminas, íconos y el modelo 3D del objeto, entre las que el autor eligió, corrigió o descartó (Anexo H).
3. **Redactar y revisar.** Borradores de la memoria, reescrituras de párrafos poco claros, repeticiones señaladas, un tono común entre documentos de distintas fechas y correcciones de ortografía y puntuación. El contenido y el criterio son del autor; la herramienta propuso formas de decirlo.
4. **Clasificar las respuestas abiertas de la encuesta**, con reglas explícitas y un control automático de los totales (Anexo B).
5. **Buscar fuentes y verificar citas.** La herramienta propuso fuentes sin muro de pago, cada una con su ficha; el autor las revisó una por una y leyó las que servían antes de incorporarlas. Así se armó el estado del arte del capítulo 8 y se encontraron las memorias de título chilenas que pidió el Pase de junio (Anexo C). También se revisó que cada cita tuviera su referencia, y cada referencia su cita, y el formato APA 7 de la lista.

## E.3 Lo que decidió el autor

El autor definió el problema, la pregunta, la hipótesis y los objetivos; eligió a las personas entrevistadas e hizo las entrevistas y sus repreguntas; formuló los ocho criterios de diseño; eligió la identidad visual entre las propuestas; decidió qué versión de la app se instaló en los teléfonos de la prueba, y responde por las citas y por las conclusiones. Cada resultado de una herramienta fue una propuesta que el autor revisó, corrigió o descartó.

## E.4 Resguardos y registro

- Ninguna herramienta generó datos, participantes, citas ni resultados.
- Las imágenes hechas con estas herramientas se presentan como visualizaciones, nunca como fotografía de un prototipo o de su uso.
- Cuando no se conservó el texto literal de un pedido, se anota una síntesis, sin reconstruir una transcripción.
- Desde el 29 de septiembre de 2026, el registro de pedidos a la IA anota el mismo día cada pedido del autor, su tipo, el resultado y la decisión asociada; la trazabilidad del 23 de septiembre reconstruye en parte el periodo anterior. Las herramientas también mantienen el estado del proyecto, el registro de riesgos y el registro de decisiones. Todo está en el repositorio público del proyecto, en las carpetas `00_gobernanza` y `09_decisiones`.

## Registro de cambios (disclaimer)

### 2026-11-08 — Anexo recopilado y listo para Word

- **Qué cambió:** la declaración se ordena en herramientas, las cinco tareas que nombra la memoria v6 —programar, generar alternativas visuales, redactar y revisar, clasificar la encuesta y buscar fuentes y verificar citas—, lo que decidió el autor y los resguardos. Sale la ficha en blanco para cada producción con IA, que es un instrumento de trabajo y no un antecedente, y la cifra de «cien referencias», que no corresponde a la memoria v6. Desde ahora este archivo es la fuente del anexo.
- **Cómo estaba antes:** copiaba la declaración del 27 de octubre, con tareas agrupadas de otra forma que la memoria, y la plantilla de la ficha.
- **Por qué:** el autor pidió revisar todos los anexos y dejarlos listos para Word: directos, sin sobreexplicar, con su forma de escribir y con lo más relevante (D-168).

### 2026-10-24 — Creación

- **Qué cambió:** el anexo se arma desde sus documentos fuente, con el resto de los anexos A–I de la memoria v5.
- **Cómo estaba antes:** la carpeta de anexos solo tenía un README de la v4, con cinco anexos y sin su contenido.
- **Por qué:** el autor pidió elegir un pendiente de prioridad alta y terminarlo; la memoria v5 remite a nueve anexos que no estaban armados.
