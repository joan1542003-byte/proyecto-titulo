# Android 4.6: la encuesta del rediseño

**Fecha:** 6 de noviembre de 2026. **Decisión:** [D-164](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.6`, sobre la 4.5. **Versión:** 4.6, `versionCode` 57. **APK:** [relevo-android-4.6-2026-11-06.apk](releases/relevo-android-4.6-2026-11-06.apk), 10,7 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.5 y de las anteriores. SHA-256: `65FE22B5D588B442FF94F2C11525BC20D4412963D3AB7309D372616BC3EFFB9C`.

## Qué pidió el autor

Que quienes ya usaban Relevo, al abrir la versión nueva, vean una encuesta sobre el rediseño y lo demás. Debe aparecer al activar un relevo o tras un minuto de uso, y una sola vez.

## Quién la ve, cuándo y cuántas veces

- **Quién:** quien ya usaba Relevo cuando abre la 4.6 por primera vez. Cuenta si cumple cualquiera de estas condiciones:
  - terminó la primera vez;
  - aceptó alguna versión del consentimiento;
  - tiene relevos guardados.

  Una instalación nueva no la ve: su primer arranque ocurre antes de todo eso. La decisión se toma esa primera vez y no cambia después.
- **Cuándo:** lo que ocurra primero.
  - **Al activar un relevo.**
  - **Tras un minuto con la app abierta.** El minuto se suma entre aperturas: si alguien la abre 20 segundos tres veces, aparece en la tercera.
- **Dónde:** sobre las pestañas, como una hoja. Nunca aparece en medio del consentimiento, de la primera vez, de preparar un relevo ni de una señal; si el minuto se cumple ahí, espera a que la persona vuelva a las pestañas. Tampoco aparece junto a las otras hojas de Inicio.
- **Una vez:** queda marcada al aparecer. Aunque se cierre con «Ahora no», no vuelve.
- **Solo con el consentimiento al día:** quien viene de la 2.33 o la 3.3 primero acepta la v14, y desde ahí empieza a contar el minuto.

## Las preguntas

Son seis y se pueden saltar todas, como dice el consentimiento. «Enviar» se activa con una respuesta.

| Pregunta | Respuesta | Clave en `relevo_answers` |
| --- | --- | --- |
| ¿Qué te parece el diseño nuevo? | Cinco caras, de «Muy mal» (1) a «Muy bien» (5) | `rediseno_impresion` |
| Comparado con la versión anterior, el diseño es… | Mejor, Igual, Peor o No me acuerdo | `rediseno_comparado` (`mejor`, `igual`, `peor`, `no_recuerdo`) |
| Relevo hace lo que necesito | De 1, nada de acuerdo, a 7, muy de acuerdo | `umux_lite_funciones` |
| Relevo es fácil de usar | De 1 a 7 | `umux_lite_facil` |
| ¿Qué te gusta más? | Varias: los colores, los íconos, los anillos, Inicio, las sugerencias, los sonidos y los textos | `rediseno_gusta` (claves separadas por comas) |
| ¿Qué cambiarías? | Comentario opcional, hasta 600 caracteres | `rediseno_cambiaria` |

### Por qué estas

- **El UMUX-Lite.** Son dos ítems de 1 a 7, «este sistema cubre lo que necesito» y «este sistema es fácil de usar». Lewis et al. (2013) lo propusieron para medir la usabilidad percibida cuando no hay tiempo para los diez ítems del SUS. Sirve para comparar Relevo con otras apps y con versiones futuras.
  - **Puntaje de 0 a 100:** (ítem 1 + ítem 2 − 2) × 100/12.
  - **Equivalente aproximado al SUS:** 0,65 × puntaje + 22,9 (Lewis et al., 2013).
  - **Traducción:** la de la app es propia, sin validar en español; hay que decirlo al reportarla.
- **Corta a propósito.** En una encuesta web, una duración anunciada más larga baja la participación y la calidad de las respuestas al final (Galesic y Bosnjak, 2009). Por eso son seis preguntas de un toque, el aviso de que toma menos de un minuto y un solo comentario opcional, al final.
- **El diseño en concreto.**
  - La impresión y la comparación con la versión anterior responden al rediseño de la 4.0 a la 4.5.
  - Lo que más gusta usa las partes que cambiaron: colores, íconos, anillos, Inicio, sugerencias, sonidos y textos.
  - El comentario cubre «lo demás».

## Datos y consentimiento

- **Dónde quedan:** las respuestas van a la tabla `relevo_answers`, como las demás preguntas de un toque, y se suben a Supabase con lo pendiente. También se registran tres eventos de uso:
  - `encuesta_rediseno_elegible`, con sí o no;
  - `encuesta_rediseno_vista`;
  - `encuesta_rediseno_enviada` o `encuesta_rediseno_cerrada`.
- **Consentimiento:** la v14 ya cubre estas respuestas: «qué respondes», preguntas que «se pueden saltar». No cambia el consentimiento ni el código de nadie.
- **Panel:** muestra cada pregunta con su nombre, por ejemplo «UMUX-Lite: es fácil de usar (1 a 7)», y reconoce la 4.6 como la versión más nueva.

## Verificación

- **Compilación desde cero:** sin advertencias y con 97 pruebas unitarias. Las cuatro nuevas fijan:
  - quién la ve;
  - el minuto sumado entre aperturas;
  - que lo vacío no se envía;
  - que las claves caben en la tabla.
- **APK:** paquete `cl.udp.relevo`, versión 4.6 (`versionCode` 57), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **Emulador, sin conexión y sobre los datos del autor**, que son de alguien que ya usaba Relevo:
  - a los 30 segundos no aparece; al minuto, sí;
  - se respondieron cinco preguntas: quedaron guardadas para enviarse y se registraron sus tres eventos;
  - al volver a abrir la app y esperar otro minuto, no apareció de nuevo.
- **Al terminar:** los datos del autor se restauraron idénticos antes de volver a conectar el emulador, así que las respuestas de prueba no llegaron a Supabase. Al abrir la app de nuevo, el emulador mostrará la encuesta como a cualquier persona que ya usaba Relevo.

**Falta probar:**

- Que aparezca al activar un relevo.
- Que no aparezca en una instalación nueva. Las pruebas unitarias lo cubren, pero en el emulador habría que borrar los datos del autor.
- La 4.6 en un teléfono real.

## Referencias

Galesic, M. y Bosnjak, M. (2009). Effects of questionnaire length on participation and indicators of response quality in a web survey. *Public Opinion Quarterly, 73*(2), 349–360. https://doi.org/10.1093/poq/nfp031

Lewis, J. R., Utesch, B. S. y Maher, D. E. (2013). UMUX-LITE: When there's no time for the SUS. En *Proceedings of the SIGCHI Conference on Human Factors in Computing Systems* (pp. 2099–2102). ACM. https://doi.org/10.1145/2470654.2481287

## Registro de cambios (disclaimer)

### 2026-11-06 — Creación

- **Qué cambió:** se documenta la versión 4.6.
- **Cómo estaba antes:** la versión actualizable era la 4.5.
- **Por qué:** el autor pidió una encuesta sobre el rediseño para quienes ya usaban Relevo, una sola vez.
