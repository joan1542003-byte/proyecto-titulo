# Android 4.7: el cierre de la prueba en la app

**Fecha:** 9 de noviembre de 2026. **Decisión:** [D-175](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.6`. **Versión:** 4.7, `versionCode` 61. **APK:** [relevo-android-4.7-2026-11-09.apk](releases/relevo-android-4.7-2026-11-09.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.6.3 y de las anteriores sin perder datos. SHA-256: `B3FEE09AB42AB9714CE28ED110C3A66A5E732BE829245BE48BD22854010FA22B`.

## Qué se pidió

El autor pidió llevar a la app la encuesta y la entrevista finales del cierre de la prueba, para que las respondan las personas que ya usan Relevo. Debe aparecer al abrir la app o, si no se responde, quedar en Ajustes, y todo debe guardarse en Supabase.

## Qué hace

- **Quién la ve:** quien ya usaba Relevo al abrir la 4.7 por primera vez, es decir, quien terminó la primera vez, aceptó el consentimiento alguna vez o tiene relevos. Una instalación nueva no la ve. Es la misma regla de la encuesta del rediseño (D-164).
- **Al abrir la app:** aparece una vez una hoja, «Cierre de la prueba», que dice qué es y cuánto toma, con «Empezar» y «Ahora no». Sale sobre Inicio, después del consentimiento y nunca encima de otra hoja.
- **En Ajustes:** mientras no se termine, la primera fila es «Cierre de la prueba», con lo que falta («Sin responder · unos 15 minutos» o «Te faltan 2 de 4 partes»). Al terminar, la fila desaparece.
- **Cuatro partes, una por pantalla, con su avance («2 de 4»):**
  1. **Las semanas con el Tag:** tres escalas de 1 («Nada») a 5 («Mucho») y un comentario.
  2. **La semana con el teléfono:** las mismas escalas, la comparación con las semanas anteriores (más, igual o menos) y por qué.
  3. **¡Terminaste la prueba!:** las siete preguntas de cierre.
  4. **Entrevista final:** las nueve preguntas abiertas. Las repreguntas del instrumento aparecen bajo cada una, como ayuda.
- **Todo se puede saltar.** Cada parte se guarda al tocar «Seguir», así que lo respondido no se pierde si la persona la deja a medias. Desde Ajustes sigue donde quedó.
- **No repite:** las preguntas que la persona ya respondió en este teléfono, por ejemplo en la app 2.33, no se muestran. Una parte respondida entera se salta.
- **La encuesta del rediseño** espera un día después de ofrecer el cierre, para no pedir dos encuestas seguidas.

## Las preguntas y dónde se guardan

Son las del [instrumento de cierre del 28 de octubre](../../07_validacion/instrumentos/instrumento-de-cierre-2026-10-28.md), con las mismas palabras, opciones y claves. Por eso el análisis trata igual lo que llegue en papel y en la app.

| Parte | Claves (`question`) | Valores (`answer`) |
| --- | --- | --- |
| Las semanas con el Tag | `semanas_previas_costo_preparar`, `semanas_previas_molestia_senal`, `semanas_previas_relacion_lugar`, `semanas_previas_comentario` | 1 a 5; texto |
| La semana con el teléfono | `semana1_costo_preparar`, `semana1_molestia_senal`, `semana1_relacion_lugar`, `semana1_comparacion`, `semana1_comentario` | 1 a 5; `mas`, `igual` o `menos`; texto |
| ¡Terminaste la prueba! | `cierre_seguiria_usando`, `cierre_semana_que_ayudo`, `cierre_por_que_ayudo`, `cierre_prefiere_que_suene`, `cierre_que_molesto`, `cierre_que_cambiaria`, `cierre_lugar_parlante` | `si`, `tal_vez` o `no`; `A`, `C`, `igual` o `ninguna`; `objeto`, `telefono` o `da_igual`; texto |
| Entrevista final | `entrevista_1` a `entrevista_9` | Texto |

- **Dónde:** cada respuesta va a la tabla `relevo_answers` de Supabase con el código de la persona, igual que las demás preguntas. Si no hay conexión, espera en el teléfono y se envía después.
- **Límites de la base:** la clave admite hasta 40 caracteres y la respuesta hasta 600. Los textos se cortan en 600, igual que el campo.
- **Registro de uso:** quedan los eventos `encuesta_cierre_elegible`, `encuesta_cierre_ofrecida` (`empezar`, `ahora_no` o `ajustes`), `encuesta_cierre_parte` (`parte=N;respuestas=M`) y `encuesta_cierre_terminada`.
- **El panel** muestra cada clave con su pregunta, por ejemplo «Entrevista final 5: si sintió que podía elegir», y los eventos en palabras.

## Qué no está

- **Los fallos críticos:** en el instrumento los marca el investigador. Se marcan al leer las respuestas de la entrevista.
- **Las repreguntas como conversación:** en la app no hay quien repregunte. Aparecen como ayuda bajo cada pregunta, con las palabras del instrumento.

## También arreglado

- **Escribir al final de una pantalla larga:** con el teclado abierto, el campo quedaba escondido detrás del botón flotante («Seguir»). Ahora sube hasta quedar sobre el teclado y sobre el botón (`ui/components/Fields.kt` y `ui/components/Screen.kt`). Sirve para todos los campos de la app.

## Verificación

- **Compilación desde cero:** 104 pruebas unitarias sin fallas, cinco de ellas nuevas para el cierre: claves, quién lo ve, qué partes se saltan, orden y recorte de respuestas, y el texto de Ajustes. Las únicas advertencias son las de siempre, de la API experimental de Haze.
- **APK:** paquete `cl.udp.relevo`, versión 4.7 (`versionCode` 61), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **En una copia aparte** (paquete `cl.udp.relevo.prueba`), sin conexión de principio a fin:
  - **Una instalación nueva no lo ve:** quedó marcada como no elegible y no apareció.
  - **Una persona que ya usaba Relevo sí:** para simularla, se borraron solo las marcas del cierre, como en la revisión de la 4.6.1. Al abrir la app apareció la hoja, «Ahora no» la cerró y Ajustes mostró la fila.
  - **Las partes:** se respondió la primera, se cerró a mitad de la segunda y Ajustes dijo «Te faltan 3 de 4 partes». Al volver, siguió en «2 de 4». Al terminar apareció «Gracias» y la fila desapareció.
  - **Dos errores encontrados en la prueba y arreglados:**
    - al guardar una parte se saltaba la siguiente;
    - el campo de texto quedaba bajo el botón con el teclado abierto.
  - **Lo guardado:** las nueve respuestas quedaron en el teléfono con sus claves y el código de la persona, listas para enviarse, junto con los eventos. Como la copia estuvo sin conexión, no llegó nada de prueba a Supabase. El envío usa el mismo camino que las demás respuestas.
  - **Al terminar:** la copia se desinstaló y el emulador volvió a tener conexión. La app del autor no se tocó.

**Falta probar:** el envío a Supabase desde un teléfono real con conexión y la actualización desde la versión que tiene cada persona de la prueba. Quien venga de una versión con el consentimiento anterior verá primero «Relevo cambió» y, al aceptarlo, el cierre.

## Registro de cambios (disclaimer)

### 2026-11-09 — Corregido en la 4.7.1

- **Qué cambió:** se anota que la 4.7.1 ya no salta las preguntas respondidas antes: las muestra todas ([Android 4.7.1](version-4.7.1-cierre-sin-perder-respuestas-2026-11-09.md), D-176).
- **Cómo estaba antes:** la 4.7 no repetía lo ya respondido en el teléfono, y eso podía dejar sin preguntar la semana con el teléfono.
- **Por qué:** el autor pidió no perder ningún dato ni respuesta.

### 2026-11-09 — Creación

- **Qué cambió:** se documenta el cierre de la prueba en la app: quién lo ve, cuándo aparece, sus cuatro partes, dónde se guarda y cómo se verificó.
- **Cómo estaba antes:** el cierre existía solo como instrumento en papel y entrevista, y la memoria marcaba sus resultados como pendientes.
- **Por qué:** el autor pidió que las personas de la prueba respondan el cierre en la app y que todo quede en Supabase.
