# Ficha de escalas semanales y cierre, en papel

**Fecha:** 20 de octubre de 2026. **Archivos:** [ficha en PDF](ficha-escalas-y-cierre.pdf) (2 páginas A4, para imprimir) y su [fuente HTML](ficha-escalas-y-cierre.html).

## Por qué existe

La app muestra la tarjeta semanal (los días 7, 14 y 21) y las cinco preguntas de cierre solo si la prueba de 21 días se inició en el teléfono, con «Empezar la prueba hoy». En los teléfonos de la prueba en curso no se inició: los relevos no tienen condición ni día, según la revisión del [estado del proyecto](../../00_gobernanza/estado-del-proyecto-2026-10-19.md). Sin esta ficha, la memoria quedaría sin las escalas de carga, molestia y relación con el lugar, y sin el cierre.

## Qué contiene

- **Página 1, escalas semanales:** las mismas tres preguntas de la tarjeta de la app, con la misma escala de 1 («Nada») a 5 («Mucho»), y un comentario opcional, para las semanas 1, 2 y 3.
  - ¿Te costó preparar Relevo?
  - ¿Te molestó el sonido?
  - ¿El sonido tenía que ver con el lugar donde sonó?
- **Página 2, cierre:**
  - Las cinco preguntas de cierre de la app. La segunda, «¿Qué semana te ayudó más?», solo se hace si hubo semanas con el objeto en lugares distintos o con el teléfono.
  - Una guía de entrevista de unos 15 minutos, con los temas del [protocolo 02](../protocolo-02-prueba-21-dias.md): qué ayudó más a recordar y por qué, qué molestó, dónde estuvo el objeto y qué cambiaría. Suma además dos preguntas que el protocolo revisa en la sesión inicial: si la persona supo de dónde venía la señal y qué quería hacer sin mirar el teléfono, y si sintió que podía elegir.

## Cómo se aplica

1. **Cuándo:** al cumplir 7, 14 y 21 días desde que la persona empezó a usar Relevo, o lo más cerca posible. Se anota la fecha real.
2. **Cómo:** el investigador lee las preguntas o entrega la hoja, sin sugerir respuestas. Toda pregunta se puede saltar.
3. **Qué anotar:** solo el código de participación, nunca el nombre. Las respuestas abiertas, con las palabras de la persona.
4. **Las fichas llenas** no se suben al repositorio. Se guardan con los datos de la prueba, en `datos_sensibles/`.

## Cómo se transcribe

Cada respuesta se escribe en una planilla con las mismas claves que usa la app, para analizarla junto con los datos de Supabase y de los teléfonos:

| Columna | Valor |
| --- | --- |
| `participant_code` | El código de participación. |
| `question` | La clave: `semana1_costo_preparar`, `semana1_molestia_senal`, `semana1_relacion_lugar`, `semana1_comentario` (y lo mismo para las semanas 2 y 3); `cierre_seguiria_usando`, `cierre_semana_que_ayudo`, `cierre_que_molesto`, `cierre_que_cambiaria`, `cierre_lugar_parlante`; `entrevista_1` a `entrevista_6`. |
| `answer` | El número de la escala, la opción marcada o el texto. |
| `fecha` | La fecha en que se respondió. |
| `fuente` | `papel`, para distinguirla de las respuestas de la app. |

## Con la 2.33

Para la persona que pasa a la semana con el teléfono, la app 2.33 hace en el teléfono las escalas de las semanas anteriores, la tarjeta del día 7 y el cierre (D-138). Para ella, la ficha solo hace falta para la entrevista. Las claves de la app son `semanas_previas_*`, `semana1_*` y `cierre_*`.

## Límites

- Responder en papel frente al investigador puede cambiar las respuestas respecto de la tarjeta en la app, que la persona contesta sola. Hay que declararlo en la memoria.
- Si la persona empezó otro día, las semanas no coinciden con las del protocolo; se anota el día real de uso.

## Registro de cambios (disclaimer)

### 2026-10-20 — Con la 2.33

- **Qué cambió:** se aclara que la 2.33 cubre en la app las escalas y el cierre de la semana con el teléfono.
- **Cómo estaba antes:** la ficha era la única vía para esas respuestas.
- **Por qué:** pedido del autor (D-138).

### 2026-10-20 — Creación

- **Qué se añadió:** una ficha imprimible con las escalas semanales, las preguntas de cierre y la guía de entrevista, y la forma de transcribirlas.
- **Cómo estaba antes:** las escalas y el cierre existían solo dentro de la app, que no las muestra si la prueba no se inició en el teléfono.
- **Por qué:** pendiente detectado en el estado del proyecto del 19 de octubre; el autor pidió ir cerrando pendientes.
