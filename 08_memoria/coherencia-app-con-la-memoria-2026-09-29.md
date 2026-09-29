# Coherencia de la app con la memoria (Android 2.11 a 2.13)

**Estado:** revisión del 29 de septiembre de 2026, pedida por el autor: «Si algo se contradice me lo haces saber; si algo es nuevo pero se fundamenta con el marco, perfecto». Compara lo que cambió en la app entre la 2.11 y la 2.13 con la [memoria v4](memoria-vigente-v4.md), sus criterios de diseño y el registro de decisiones. **No cambia el texto de la memoria:** señala qué contradice, qué se fundamenta y qué hay que actualizar.

## 1. Contradicciones

| Cambio en la app | Qué dice la memoria | Estado |
| --- | --- | --- |
| **Nombre guardado en Supabase** (2.13, D-089) | Sección 11, «Autonomía, privacidad y accesibilidad»: los registros se envían «mediante un código aleatorio. Ese código separa el registro del nombre». D-076 decía que el nombre «no sale del teléfono». | **Contradicción aceptada por el autor.** Se redujo: el nombre va en una tabla aparte, solo con el código; las tablas de relevos, respuestas y uso siguen sin nombre. Hay que actualizar la sección 11, el consentimiento (ya en v9) y la [ficha de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md). La Ley 21.719 rige desde el 1 de diciembre de 2026 y la revisión ética debe hacerse antes. |
| **Aviso semanal encendido por defecto** (2.12, D-087) | Sección 7: los requisitos incluyen «configuración voluntaria»; sección 11: «la ausencia de respuesta no debe generar recordatorios repetidos». | **Corregido en 2.13 (D-088).** Empieza apagado y la guía pregunta Sí o No, sin respuesta marcada. |
| **Notificación de la semana del teléfono** (2.12) | El [protocolo 02](../07_validacion/protocolo-02-prueba-21-dias.md) fija el texto genérico «Relevo · Tu intención está disponible». | **Diferencia menor.** Ahora dice «Es momento de volver a elegir», también genérico. Hay que actualizar el protocolo o volver al texto anterior. |
| **Resumen semanal encendido por defecto** (2.12) | Sección 7: P7 rechazó «las notas o comparaciones entre días» (Q13). | **Tensión, no contradicción.** El resumen muestra hechos de la semana en curso, sin comparar días ni dar metas. Conviene decidir si empieza encendido. |

## 2. Cambios nuevos que se fundamentan en la memoria

| Cambio | Fundamento en la memoria |
| --- | --- |
| **Intereses y rutas concretos** (2.13): dormir a tiempo, leer, hacer ejercicio, salir en bicicleta, pasear al perro, dibujar o pintar, manualidades o maquetas, cocinar, ordenar la pieza, meditar, estudiar, compartir con alguien. | Sección 7: los hallazgos se basan en episodios y actividades concretas («dormir puede empezar al dejar el teléfono…; caminar, al ponerse las zapatillas; leer, al abrir el libro»). D-076: «las entrevistas respaldan actividades concretas, no tipos de usuario». Cada interés cita en el código las respuestas de P1–P8 que lo sostienen (Q1, Q2 y Q12). |
| **Ideas de Inicio solo de las entrevistas** (2.13). | Criterio 1: partir de una intención propia; sección 7: el hogar como contexto de actividades materiales. Se quitaron «Tocar un instrumento», «Cuidar las plantas» y «Escribir», que no aparecen como actividades en el corpus. |
| **Guía de la primera vez** (2.13, rehecha en 2.14): pocas pantallas de contexto —el problema y las tres partes del sistema— y el primer relevo hecho con la persona, con notas en cada paso. | Tabla 5: «Conocer y aceptar: entender propósito, límites»; sección 3, el problema; sección 11: la condición «debe explicarse con ejemplos»; criterio 6: en 2.14 la explicación se reduce y se aprende haciendo el primer relevo. |
| **Resumen del relevo activo en Inicio** (2.13). | Sección 6, memoria prospectiva: la intención debe estar disponible a tiempo; tabla 5: «Recuperar un fallo: saber si el ciclo sigue activo y poder detenerlo»; criterio 4: salida siempre disponible. Muestra lo preparado y lo que falta, sin rachas ni comparaciones (criterios 4 y 7). |
| **Preguntas tras cada aviso, siempre** (2.12). | Sección 6: percibir la señal, recordar la intención y decidir son resultados distintos que conviene separar; objetivo específico 4. |
| **Reacción con caras tras el aviso** (2.12). | Criterio 7: la señal no debe molestar; objetivo 4: evaluar percepción y convivencia. Evalúa el aviso, no a la persona. |
| **Opinión rápida sobre la app** (2.12). | Objetivo 4 y evaluación formativa (sección 10). Califica la app, no la conducta: no es un puntaje del criterio 4. |
| **Registro del uso de la app** (2.12). | Objetivo 4: evaluar comprensión, autonomía y carga de uso; criterio 6: cada paso debe justificarse (el registro muestra dónde se abandona la preparación). La sección 11 debe describir estos datos. |
| **Textos simples y sin lenguaje de prueba** (2.12). | Criterio 3 (una condición comprensible) y tabla 5. El consentimiento sigue diciendo que es un estudio: la memoria exige que la persona entienda el propósito antes de aceptar. |

## 3. Tensiones que conviene vigilar

- **Carga de la guía (criterio 6).** En 2.14 la guía bajó a tres pantallas de contexto y el resto se aprende haciendo el primer relevo, que igual hay que preparar. La prueba debe mostrar si ayuda o si pesa.
- **Más datos y minimización.** El registro de uso sirve al objetivo 4, pero amplía lo que se guarda. Conviene decidir en el análisis qué datos se usan de verdad y declararlo.
- **«Que no se sienta como un testeo».** La app lo logra en el uso diario, pero el consentimiento, la sesión inicial y la entrevista final siguen siendo parte de un estudio. La memoria no permite ocultarlo.

## 4. Qué hay que actualizar en la memoria

Esto no se ha hecho; requiere cuidar los límites de palabras de la memoria.

1. **Sección 11, «Autonomía, privacidad y accesibilidad»:** el nombre guardado aparte con el código, la copia en Documentos/Relevo, el registro del uso de la app, la reacción y la opinión rápida.
2. **Sección 11, «Preparación, señal y cierre del ciclo»:** el párrafo del prototipo aún dice que el tono sigue hasta silenciarlo y que «la versión siguiente lo limitará a unos treinta segundos»; eso ya existe desde la 2.7. También falta la guía de la primera vez.
3. **Tabla 5:** «Conocer y aceptar» (guía y consentimiento v9) y «Recibir y cerrar» (señal de 30 s, preguntas y reacción).
4. **Sección 13, «Registro de evidencia»:** qué datos del registro de uso se analizarán.
5. **Protocolo 02:** texto de la notificación genérica.

## Registro de cambios (disclaimer)

### 2026-09-29 — Android 2.14

- **Qué cambió:** la guía se describe como en 2.14: contexto breve y primer relevo acompañado.
- **Cómo estaba antes:** describía las nueve pantallas de la 2.13.
- **Por qué:** el autor pidió una guía con contexto que deje hacer el primer relevo.

### 2026-09-29 — Creación

- **Qué se añadió:** la comparación entre los cambios de la app 2.11 a 2.13 y la memoria v4: contradicciones, cambios fundamentados, tensiones y actualizaciones pendientes.
- **Cómo estaba antes:** los documentos de cada versión no contrastaban los cambios con la memoria.
- **Por qué:** el autor pidió que todo responda a la memoria y al marco teórico, y que se le avise de cualquier contradicción.
