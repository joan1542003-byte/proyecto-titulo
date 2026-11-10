# Entrevista de cierre de la prueba, según la guía de los profesores

**Fecha:** 9 de noviembre de 2026. **Decisión:** D-177. **Reemplaza a:** la entrevista de nueve preguntas del [instrumento de cierre del 28 de octubre](instrumento-de-cierre-2026-10-28.md). El cuestionario de ese instrumento (partes A, B y C) sigue igual. **Se aplica:** en la app desde la [versión 4.7.2](../../06_desarrollo_y_factibilidad/app-android/version-4.7.2-entrevista-segun-la-guia-2026-11-09.md), o en persona con este mismo guion.

## Por qué cambió

El 2 de noviembre de 2026, los profesores entregaron una guía para la entrevista semiestructurada y el análisis del discurso. La entrevista del 28 de octubre no la cumplía: seis de sus nueve preguntas se podían responder con sí o no («¿Supiste…?», «¿Lo moviste?», «¿Sentiste…?», «¿Falló algo?», «¿Alguien más…?», «¿Hubo días…?») y no seguía un orden de lo general a lo particular.

## Qué pide la guía y cómo se cumple

| La guía pide | En esta entrevista |
| --- | --- |
| Un guion temático, no un cuestionario, con preguntas de seguimiento | Diez preguntas abiertas. Cada una lleva una o más repreguntas, como «Cuéntame un ejemplo». |
| Evitar las preguntas dicotómicas, de sí o no | Toda pregunta empieza con qué, cómo, dónde o cuál, o pide contar algo. Una prueba automática de la app lo comprueba. |
| El embudo: de lo general a lo particular | Introducción (pregunta 1), cuerpo (2 a 5), crítica (6 a 9) y cierre (10). |
| Un cierre de síntesis o proyectivo: «Si pudieras cambiar algo, ¿qué sería?» | La pregunta 10. |
| Consentimiento: participación voluntaria, sin respuestas correctas y con seudónimo | La app lo dice antes de empezar: se puede saltar cualquier pregunta, no hay respuestas buenas ni malas y todo se guarda con el código, aparte del nombre. |
| Derecho de retiro | La persona puede dejar la entrevista cuando quiera y borrar sus datos en Ajustes, en Datos. |
| Neutralidad: mostrar interés sin juzgar | Ninguna pregunta anticipa qué se espera del Tag o del teléfono. En persona: no asentir de más y sostener el silencio después de una respuesta. |
| Reflexividad: reconocer los propios prejuicios | Antes de leer las respuestas, el autor anota lo que espera encontrar, por ejemplo, que el lugar ayuda a recordar, para no leerlo donde no está. |

## La entrevista

**Antes de empezar:** «Gracias por estas semanas. No hay respuestas buenas ni malas: sirve saber qué te pasó, también lo que no funcionó. Puedes saltar cualquier pregunta».

| N.º | Fase del embudo | Pregunta | Repreguntas | Clave (`question`) |
| --- | --- | --- | --- | --- |
| 1 | Introducción: contexto | Para empezar, cuéntame cómo usaste Relevo en estas semanas: qué actividad elegiste y en qué momentos lo preparabas. | ¿Qué te llevó a elegir esa actividad? | `entrevista_uso` |
| 2 | Cuerpo: estructural | Piensa en una vez en que sonó. ¿Qué pasó desde que lo escuchaste? Cuéntalo paso a paso. | ¿En qué estabas pensando justo antes de que sonara? ¿Qué se te vino a la cabeza antes de mirar el teléfono? Cuéntame también de alguna vez en que sonó y no lo notaste, o lo notaste y seguiste en lo que estabas. | `entrevista_al_sonar` |
| 3 | Cuerpo: estructural | ¿Dónde estuvo el Tag la mayor parte del tiempo y cómo llegaste a dejarlo ahí? | Si lo cambiaste de lugar, ¿qué te hizo moverlo? | `entrevista_lugar` |
| 4 | Cuerpo: de contraste | ¿Qué fue distinto y qué fue igual entre las semanas en que sonó el Tag y la semana en que sonó el teléfono? | En la semana con el teléfono, ¿qué pasaba entre que sonaba y que leías la notificación? Cuéntame un ejemplo de cada una. | `entrevista_tag_y_telefono` |
| 5 | Cuerpo: de contraste | Cuéntame de los días en que no preparaste ningún relevo: ¿qué pasaba esos días? | ¿Qué te hizo volver a usarlo, o dejar de usarlo? | `entrevista_dias_sin_uso` |
| 6 | Crítica: sentimiento | Cuando sonaba, ¿cómo decidías qué hacer: empezar la actividad, dejarla para después o cambiar de idea? | ¿Qué sentías en ese momento? ¿Cómo hacías para callarlo o dejarlo para después? | `entrevista_decidir` |
| 7 | Crítica: opinión | ¿Qué te costó o te molestó de usar Relevo? Puede ser al prepararlo, el sonido, el Tag o el teléfono. | Cuéntame una vez en que pasó. | `entrevista_costo_y_molestia` |
| 8 | Crítica: opinión | ¿Qué cosas no funcionaron como esperabas? | Por ejemplo, que no sonara, que sonara cuando no lo esperabas o que el Tag o la app hicieran algo raro. | `entrevista_fallas` |
| 9 | Crítica: opinión | ¿Cómo fue usar Relevo con otras personas cerca? | ¿Qué dijeron o hicieron cuando sonó o cuando vieron lo que preparaste? | `entrevista_otras_personas` |
| 10 | Cierre: proyectiva | Si pudieras cambiar una sola cosa de Relevo, ¿cuál sería y por qué? | ¿Qué más te gustaría contar que no te haya preguntado? | `entrevista_cambiaria` |

## Qué valida cada pregunta

Los aspectos son los mismos del instrumento del 28 de octubre; cambia la pregunta que los recoge.

| Qué se quiere saber | Antes | Ahora | Responde a |
| --- | --- | --- | --- |
| Si, al sonar, recordó qué quería hacer y cómo empezar sin mirar el teléfono, y si notó la señal | E1 | 2 | Supuesto 1, asociación; objetivo 4, percepción |
| Si el objeto ayudó más, igual o menos que el teléfono | E2 | 4 | Supuesto 3, soporte; objetivo 3 |
| Cuánto costó y cuánto molestó | E3 | 7 | Objetivo 4, carga |
| Si el sonido tuvo que ver con el lugar | E4 | 3 | Supuesto 2, lugar, solo de forma descriptiva |
| Si sintió que podía elegir, y si sabía callarlo | E5 | 6 | Autonomía |
| Qué falló | E6 | 8 | Funcionamiento técnico |
| Cómo convivió con otras personas | E7 | 9 | Convivencia |
| Cuándo lo usó y cuándo lo dejó | E8 | 1 y 5 | Uso y abandono |
| Qué cambiaría | E9 | 10 | Mejoras para la siguiente iteración |

Las repreguntas de la 2 y la 4 mantienen lo que el instrumento anterior cuidaba: distinguir «no la oí» de «la ignoré», saber si la actividad ya estaba presente antes del sonido y separar lo que la persona supo al sonar de lo que leyó en la notificación.

## Fallos críticos

Como antes, los marca el investigador al leer las respuestas, con los seis fallos del protocolo: obligación o sanción (pregunta 6), exposición ante otras personas (9), no saber callar la señal o dejar la prueba (6), una señal fuera de un relevo activado (8), una barrera de accesibilidad (2 y 8) y algo que el consentimiento no contempla.

## Claves y versiones

- **Las claves llevan el tema, no un número.** Las respuestas no guardan la versión de la app, así que una clave numerada no diría a qué redacción responde. `entrevista_1` a `entrevista_9` quedan reservadas para la entrevista del 28 de octubre, por si alguien la respondió en papel o con la app 4.7 o 4.7.1.
- **El registro de uso** anota la versión del instrumento junto a cada parte guardada: `instrumento=2026-11-09`.
- **En papel:** una fila por respuesta, con las mismas claves, como indica el instrumento del 28 de octubre. El PDF para imprimir de ese instrumento todavía trae la entrevista anterior.

## Cómo se analiza

Según la misma guía:

1. **Leer dos veces** cada entrevista antes de codificar y anotar las primeras impresiones.
2. **Codificar** de forma deductiva, con los tres supuestos de la hipótesis y los criterios de diseño, e inductiva, con lo que aparezca y no estaba previsto.
3. **Ordenar en una matriz:** categoría, hallazgo, cita y lo que implica para el proyecto.
4. **Triangular** con las respuestas que la app pidió tras cada señal, el cuestionario de cierre y los registros de uso.

Con tres personas, la lectura es por caso y sin porcentajes, como el resto de la prueba. La guía habla de saturación teórica; aquí no se busca: se describe lo que pasó en tres hogares.

## Límites

- **Por escrito no hay quien repregunte.** En la app, las repreguntas aparecen bajo cada pregunta, como ayuda. Si una respuesta queda corta, el autor puede retomarla en una conversación.
- **Las respuestas escritas suelen ser más breves** que las habladas.
- **La semana con el teléfono vino después** de las semanas con el Tag: la pregunta 4 describe la experiencia de cada persona, no mide un efecto.

## Registro de cambios (disclaimer)

### 2026-11-09 — Creación

- **Qué cambió:** se redacta la entrevista de cierre según la guía de los profesores: diez preguntas abiertas, en embudo y con una pregunta final proyectiva, con sus claves por tema.
- **Cómo estaba antes:** la entrevista del 28 de octubre tenía nueve preguntas, seis de ellas de sí o no, sin orden de embudo y con claves numeradas.
- **Por qué:** el autor pidió ajustar la entrevista final a la guía de sus profesores (D-177).
