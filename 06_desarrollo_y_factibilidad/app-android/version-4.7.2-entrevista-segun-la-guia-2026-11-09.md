# Android 4.7.2: la entrevista final según la guía de los profesores

**Fecha:** 9 de noviembre de 2026. **Decisión:** [D-177](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.6`. **Versión:** 4.7.2, `versionCode` 63. **APK:** [relevo-android-4.7.2-2026-11-09.apk](releases/relevo-android-4.7.2-2026-11-09.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.7.1 y de las anteriores sin perder datos. SHA-256: `CA775FC214244E664E711FF6E9BAFED8CA450BBDD03462F044DDBC0D508D7C07`.

## Qué se pidió

El autor pidió ajustar la entrevista final del cierre de la prueba a la guía de sus profesores para la entrevista semiestructurada.

## Qué cambió

- **La entrevista:** pasa de nueve preguntas, seis de ellas de sí o no, a diez preguntas abiertas, ordenadas de lo general a lo particular y con una pregunta final proyectiva. El guion, lo que valida cada pregunta y cómo se analiza están en la [entrevista de cierre del 9 de noviembre](../../07_validacion/instrumentos/entrevista-de-cierre-2026-11-09.md).
- **Dos pantallas de cinco preguntas** en vez de una de nueve: «Entrevista final, primera parte» (cómo fue) y «segunda parte» (lo que sintió y lo que cambiaría). El cierre tiene ahora cinco partes.
- **Claves por tema:** `entrevista_uso`, `entrevista_al_sonar`, `entrevista_lugar`, `entrevista_tag_y_telefono`, `entrevista_dias_sin_uso`, `entrevista_decidir`, `entrevista_costo_y_molestia`, `entrevista_fallas`, `entrevista_otras_personas` y `entrevista_cambiaria`. Las claves numeradas quedan para la entrevista anterior, así las dos redacciones nunca se mezclan.
- **Lo escrito no se pierde al cerrar:** mientras la persona responde, lo que escribe se guarda en el teléfono. Si cierra la pantalla a medias, al volver lo encuentra en sus campos. Al enviar la parte, sale de ese borrador y va a Supabase. «Borrar mis datos» también lo borra.
- **El registro de uso** anota la versión del instrumento con cada parte guardada (`instrumento=2026-11-09`).
- **La hoja inicial** dice «diez preguntas» y que las respuestas se guardan con el código, aparte del nombre.
- **El cuestionario** (las semanas con el Tag, la semana con el teléfono y el cierre) no cambió.

## Quien ya tenía la 4.7 o la 4.7.1

- **Si quedó a medias,** sigue donde iba: quien estaba en la entrevista ve las dos partes nuevas.
- **Si ya terminó la entrevista anterior,** no se le vuelve a preguntar. Sus respuestas quedan con las claves numeradas, y el panel las muestra aparte, como «versión del 28 de octubre».

## El panel

- **«Entrevista final»** muestra las diez preguntas nuevas con sus respuestas y fechas.
- **«Entrevista final, versión del 28 de octubre»** aparece solo si alguien respondió la anterior.
- **El artefacto de claude.ai** se publicó de nuevo (versión 21, el mismo enlace).

## Verificación

- **Compilación desde cero:** 106 pruebas unitarias sin fallas. Dos son nuevas: una comprueba que ninguna pregunta de la entrevista se pueda responder con sí o no, y otra, que las claves nombran su tema y no reutilizan las numeradas. Las únicas advertencias son las de siempre, de la API experimental de Haze.
- **APK:** paquete `cl.udp.relevo`, versión 4.7.2 (`versionCode` 63), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **En una copia aparte** (paquete `cl.udp.relevo.prueba`), sin conexión de principio a fin:
  - **Quien quedó en la entrevista:** Ajustes dijo «Te faltan 2 de 5 partes» y abrió «Entrevista final, primera parte» en «4 de 5».
  - **Cerrar a medias:** se escribió una respuesta, se cerró con la X y, al volver, el texto estaba en su campo.
  - **Enviar:** las respuestas quedaron con sus claves nuevas, el registro anotó `instrumento=2026-11-09` y el borrador quedó vacío.
  - **Al terminar:** la copia se desinstaló y el emulador volvió a tener conexión. La app del autor no se tocó.
- **Panel:** en modo de ejemplo, la ficha muestra «Entrevista final · 1 de 10 preguntas respondidas» y no muestra la versión anterior cuando no hay respuestas.

**Falta probar:** el envío a Supabase desde un teléfono real con conexión y el panel publicado con la cuenta del autor.

## Pendiente fuera de esta rama

El Anexo I de la memoria (rama `anexos-para-word`) todavía presenta la entrevista del 28 de octubre. Hay que actualizarlo con la entrevista que efectivamente se aplique.

## Registro de cambios (disclaimer)

### 2026-11-09 — Creación

- **Qué cambió:** se documenta la entrevista nueva en la app, sus claves, el borrador que guarda lo escrito y el panel.
- **Cómo estaba antes:** la app tenía la entrevista del 28 de octubre en una sola pantalla, y lo escrito se perdía al cerrar a medias.
- **Por qué:** el autor pidió ajustar la entrevista final a la guía de sus profesores.
