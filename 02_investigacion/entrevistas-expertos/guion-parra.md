# Guion de entrevista: Denis Parra

**Disciplina:** ciencia de la computación; sistemas de recomendación, interfaces inteligentes e inteligencia artificial centrada en las personas. **Institución:** profesor asociado, Departamento de Ciencia de la Computación, Pontificia Universidad Católica de Chile. **Duración:** 30 a 35 minutos. **Formato:** videollamada. **Trato:** de tú. **Idioma:** español.

**Estado al 3 de noviembre de 2026:** respondió que tiene la agenda llena hasta mediados de diciembre y pidió un video o algo corto por correo. No habrá videollamada; ver el [correo con el video](#correo-con-el-video).

Este guion aplica la [guía general](guia-de-entrevista.md) a su trabajo. Las preguntas marcadas con ★ son imprescindibles; las demás se hacen si queda tiempo.

## Por qué esta persona

Relevo parte de que muchas aplicaciones no tienen un final: recomiendan y reproducen lo siguiente sin que la persona vuelva a decidir. Parra estudia justamente los sistemas de recomendación y cómo darles control a las personas:

- **Parra y Brusilovsky (2015)** estudiaron SetFusion, una interfaz que deja a la persona controlar cómo se combinan las recomendaciones.
- Su sitio también presenta TalkExplorer y Moodplay, interfaces que explican o hacen visibles las recomendaciones, y un trabajo de 2024 sobre aprendizaje por refuerzo para *recomendación secuencial*, la que elige qué mostrar después según lo anterior.

## Qué debe dejar la entrevista

1. Una revisión técnica de cómo la memoria describe la continuidad de las aplicaciones (capítulo 3), para que no simplifique ni exagere.
2. Qué hace real, y no ilusorio, el control que Relevo le da a la persona sobre cuándo suena.
3. Una interpretación de lo que mostró la prueba sobre el límite de tiempo —una persona lo acortó porque, al sonar, ya estaba inmersa en un video— y qué condición conviene probar después.

## Antes de la entrevista

- **Leer:** el resumen de Parra y Brusilovsky (2015) y la lista de proyectos de su [sitio](https://denisparra.github.io/).
- **Mostrar:** si hace falta, la [página para mostrar](material-para-mostrar.md), compartiendo pantalla. La invitación no lleva adjuntos.
- **Tener a mano:** el párrafo «La interfaz sostiene la continuidad» del capítulo 3 de la v6, para compartir pantalla; el teléfono con la pantalla «¿Cuándo suena?», y el Tag.

## Guion

### 1. Apertura (2 minutos)

> Gracias por tu tiempo. Te cuento brevemente el proyecto y después me interesa tu opinión desde los sistemas de recomendación y el control que tienen las personas sobre ellos. ¿Puedo grabar el audio solo para revisar mis notas? Lo borro al terminar la memoria. ¿Puedo citarte con tu nombre como comunicación personal? Antes de entregar te envío el párrafo donde aparezca tu opinión para que lo revises.

> Tu participación es voluntaria y no hay respuestas correctas: me interesa tu opinión. Puedes pedirme detener la grabación o borrar una parte, o terminar cuando quieras.

Anotar: grabación sí o no · cita con nombre sí o no · revisión del párrafo sí o no.

### 2. Relevo en tres minutos

Contar el problema, el ciclo y los resultados de la página. **Subrayar en esta entrevista:** Relevo no bloquea ni mide para juzgar; la persona elige las aplicaciones y fija el tiempo, de 1 minuto a 6 horas, y Relevo suena cuando esas aplicaciones suman ese tiempo.

### 3. Preguntas (25 minutos)

La entrevista ocurre después de la prueba, así que lo primero es interpretar los resultados y fortalecer el marco teórico; las preguntas sobre el diseño futuro van al final. Las preguntas van de lo general a lo particular, como pide la guía de los profesores: primero su trabajo, después los resultados y la teoría, y al final su crítica. Si una respuesta queda corta, repreguntar: «¿Me puedes dar un ejemplo?».

**Para empezar (2 minutos)**

> Para empezar, ¿qué te llevó a estudiar el control que tienen las personas sobre los sistemas de recomendación?

- *Por qué:* crea confianza y sitúa la conversación en su experiencia.

**A. ★ Recordar no basta para empezar**

> En la prueba, en las 21 respuestas la persona recordó cómo empezar, y en 19 supo qué quería hacer antes de leerlo en la pantalla, pero empezó la actividad solo en 10. Desde tu campo, ¿cómo explicas esa distancia entre recordar y empezar?

- *Por qué:* es el resultado que más necesita teoría; hoy la memoria lo explica con Fogg (2009).
- *Repregunta:* «¿Qué factor pesaría más, según tu experiencia?».
- *Va a:* capítulo 13, «Resultados», y capítulo 6.

**B. ★ Lo que falta en el marco teórico**

> Con estos resultados a la vista, ¿qué concepto, autor o estudio de tu campo debería estar en el marco teórico de la memoria para explicarlos?

- *Por qué:* la entrevista es posterior a la prueba; su mayor aporte es a la interpretación y a la teoría.
- *Va a:* capítulo 6 y referencias.

**1. ★ Cómo se describe el problema**

> Este es el párrafo de la memoria que explica por qué una sesión continúa: el desplazamiento infinito y la reproducción automática mantienen abierta la secuencia y quitan los momentos de cierre. Desde los sistemas de recomendación, ¿qué corregirías o agregarías?

- *Por qué:* la memoria se apoya en Montag et al. (2019) para este punto; una revisión experta lo hace más preciso.
- *Repregunta:* «¿Qué papel tiene la recomendación secuencial en que la siguiente pieza llegue sin que la persona decida?».
- *Va a:* capítulo 3, «Por qué ocurre».

**2. ★ Control real o control ilusorio**

> En SetFusion estudiaste cómo dar control a las personas sobre las recomendaciones. Relevo le da a la persona el control de cuándo suena: elige las aplicaciones y el tiempo. ¿Qué hace que ese control sea real y no solo aparente?

- *Por qué:* el criterio 3 dice que la persona decide cuándo suena; conviene saber si basta con un tiempo fijo.
- *Qué escuchar:* condiciones como entender el efecto de cada ajuste, poder cambiarlo en el momento o ver por qué ocurrió algo.
- *Va a:* criterio 3 y capítulo 11, «El recorrido del usuario».

**3. ★ Una condición más inteligente**

> Hoy Relevo suena por tiempo. Una persona bajó su límite de 45 a 35 minutos porque, al sonar, ya estaba inmersa en un video. Con señales que el teléfono ya tiene, ¿cómo podría Relevo reconocer una sesión que continúa sin una nueva decisión, sin inferir demasiado sobre la persona?

- *Por qué:* es la principal mejora posible de la condición, pero choca con la autonomía y la privacidad.
- *Repreguntas:* «¿Qué señales usarías y cuáles evitarías?», «¿Qué riesgo ves en que el sistema decida cuándo intervenir?».
- *Va a:* capítulo 13, «Iterar con los resultados», y capítulo 14, proyecciones.

**4. Explicar por qué sonó**

> En tus interfaces de recomendación, la explicación ayuda a entender lo que hace el sistema. ¿Cómo podría Relevo explicar por qué sonó, por ejemplo «sumaste 25 minutos en TikTok», sin que se lea como un juicio?

- *Va a:* capítulo 11, «Cómo habla Relevo».

**5. ★ Qué medir y qué no afirmar**

> Con tres personas, Relevo registró cuándo se activó cada relevo, si sonó, cómo se calló y qué respondió cada persona. ¿Qué medida del registro del teléfono sumarías, y qué no debería afirmar la memoria con estos datos?

- *Va a:* capítulo 13.

**Si queda tiempo:**

- «Moodplay usaba el estado de ánimo para recomendar. De noche, una persona oía la señal desde la cama y no se levantaba. ¿Qué papel deberían tener la hora o el estado de la persona, y qué debería quedar solo en sus manos?»
- «¿Qué riesgos ves en llevar a Relevo técnicas que las propias aplicaciones usan para retener a las personas?»

### 4. Cierre (3 minutos)

- «Si pudieras cambiar una sola cosa de Relevo, ¿cuál sería?»
- «¿Hay algo que no te pregunté y que debería saber?»
- «¿A quién más consultarías, por ejemplo en la Escuela de Diseño UC?»
- Confirmar cómo quiere aparecer en la memoria y ofrecer el envío del párrafo y, al final, de la memoria.

## Si responde por escrito

Enviar solo cinco preguntas: A, B, 1, 2 y «¿A quién más consultarías?». Denis pidió un video o algo corto, así que se le envía el [correo con el video](#correo-con-el-video), con tres preguntas.

## Correo con el video

Denis respondió el 3 de noviembre de 2026: tiene la agenda llena hasta mediados de diciembre y, si le mandan un video o algo corto por correo, lo verá cuando tenga tiempo y dará su opinión. No habrá videollamada. El correo va en el mismo hilo, con un video de menos de un minuto y tres preguntas que se responden en pocas líneas. Explica Relevo sin términos técnicos.

**Cómo enviarlo:** responder su correo desde el de la UDP y adjuntar [`relevo-en-un-minuto.mp4`](video-de-relevo/relevo-en-un-minuto.mp4) (53 segundos, 1,8 MB, sin sonido). Si se prefiere un enlace, subirlo a Google Drive con acceso para «Cualquier persona con el enlace» y cambiar la primera frase por: «¡Muchas gracias por responder! Te dejo un video de menos de un minuto, sin sonido: [enlace]. Abajo van tres preguntas; con dos o tres líneas por pregunta me ayudas mucho».

> Hola, Denis:
>
> ¡Muchas gracias por responder! Te adjunto un video de menos de un minuto, sin sonido, y tres preguntas; con dos o tres líneas por pregunta me ayudas mucho.
>
> En corto: Relevo es mi proyecto de título en Diseño UDP. Es una aplicación y un objeto pequeño que la persona deja junto a algo que quiere hacer, por ejemplo un libro. Cuando lleva en ciertas apps el tiempo que ella misma fijó, el objeto suena para que lo recuerde, y ella decide si empieza o sigue.
>
> Mis preguntas
> 1. En la memoria explico que una sesión sigue porque el desplazamiento infinito y la reproducción automática quitan los finales: un capítulo o una canción terminan; el feed, no. Pero no digo nada del sistema que elige qué viene después. Desde los sistemas de recomendación, ¿qué falta en esa explicación, y qué concepto o autor me recomiendas?
> 2. Con Xavier Amatriain estudiaste cómo se relaciona lo que una persona hace, por ejemplo cuántas veces escucha un álbum, con lo que declara al calificarlo. Entiendo que muchas plataformas aprenden sobre todo de lo que se hace: seguir mirando cuenta como interés. Relevo, en cambio, parte de lo que la persona dijo de antemano que quería hacer. ¿Cómo trata hoy tu campo esa diferencia, y qué cuidado tendrías al usarla para explicar Relevo?
> 3. En Relevo, la persona elige las apps y el tiempo, y el sistema no infiere nada: el teléfono sabe cuánto se usa una app, pero no para qué. Desde tu trabajo en SetFusion, ¿qué hace que un control así sea real y no solo aparente? Y si Relevo intentara reconocer por sí mismo el momento oportuno, ¿qué ganaría y qué perdería la persona?
>
> No hay respuestas correctas; si alguna no te hace sentido, sáltala. ¿Puedo citarte con tu nombre en la memoria? Antes de usar tu respuesta te envío el párrafo para que lo revises.
>
> Sin apuro: si alcanzas antes del 2 de diciembre, lo sumo a la memoria; si no, igual me sirve para el examen de título, a mediados de diciembre.
>
> ¡Muchas gracias!
> Johan

**Por qué estas tres.** Cada una cae en su trabajo publicado: los sistemas de recomendación y la recomendación secuencial (pregunta 1), la relación entre lo que la persona hace y lo que declara, llamadas retroalimentación implícita y explícita (Parra y Amatriain, 2011; pregunta 2), y las interfaces que dan control a las personas (Parra y Brusilovsky, 2015; pregunta 3). Las preguntas del guion sobre los resultados (A), la explicación de por qué sonó (4) y la medición (5) quedan fuera para que el correo sea corto.

**Qué aporta cada pregunta a la memoria**

| Pregunta | Vacío que llena | Va a |
| --- | --- | --- |
| 1. Por qué una sesión sigue | Los capítulos 3 («Por qué ocurre») y 6 («El diseño de la atención») explican la continuidad solo con patrones de interfaz (Montag et al., 2019). La v6 no menciona el sistema que elige qué contenido viene después, y la *arquitectura de atención* se define solo con decisiones de interfaz. | Capítulos 3 y 6 y glosario |
| 2. Lo que se hace y lo que se quiere | La memoria trata la distancia entre intención y conducta solo desde la psicología: memoria prospectiva e intenciones de implementación. Falta decir, desde los datos que usan las plataformas, en qué se distingue Relevo —parte de lo que la persona declaró, no de lo que hace— y dónde está el límite de esa idea. | Capítulos 6 y 14 |
| 3. Quién decide cuándo suena | El criterio 3 se apoya en un argumento propio: el teléfono mide cuánto se usa una app, pero no para qué. Falta respaldo de la investigación sobre el control de las personas en sistemas de recomendación, y una opinión experta sobre qué se arriesga al inferir el momento. | Criterio 3, capítulo 6 («autonomía») y capítulo 14, «Alcances y proyecciones» |

**Qué muestra el video**

| Escena | Qué dice | De dónde sale |
| --- | --- | --- |
| 1 | Logo y «Un recordatorio físico preparado desde el teléfono». | Marca vigente. |
| 2 | Una sesión sigue sin que uno vuelva a decidir; Relevo no bloquea el teléfono. | Capítulo 3. |
| 3 y 4 | Preparar: qué hacer, cómo empezar, dónde y cuánto tiempo en ciertas apps. | Pantallas de la app con un perfil de prueba (figuras de la memoria). |
| 5 | Dejar el objeto junto al libro; el teléfono sigue libre. | [Modelo 3D del objeto](../../06_desarrollo_y_factibilidad/testigo-impresion-3d/README.md), aún sin imprimir, con la nota de que en la prueba se usó un llavero Bluetooth comprado. |
| 6 | Suena unos 30 segundos, en el objeto o en el teléfono. | Capítulo 11, «La señal», y pantalla del anexo de la app. |
| 7 | La persona decide sin presión: comenzar, dejarlo para después o cambiar de idea. | Criterio 4 y pantallas del anexo de la app. |
| 8 | Tres personas, dos semanas en sus casas; 19 de 21 y 10 de 21, del 8 al 19 de octubre de 2026. | Capítulo 13, «Resultados». |
| 9 | Gracias; las preguntas van en el correo. | — |

El video no muestra datos ni imágenes de las personas de la prueba, ni la semana con la señal solo en el teléfono, cuyos resultados no están en la v6. Se genera con [`generar-video.js`](video-de-relevo/generar-video.js), que toma las imágenes del repositorio.

## Después

Llenar la ficha de la [guía](guia-de-entrevista.md#cómo-registrar-la-entrevista) el mismo día. Si propone otra condición para que suene Relevo, anotarla como propuesta: la decide el autor y no cambia la prueba ya hecha.

Si responde el correo, su respuesta escrita se registra igual en la ficha, con la fecha del correo. Se cita como comunicación personal solo si autorizó su nombre, y antes de usarla se le envía el párrafo. Si recomienda autores, hay que buscarlos y leerlos antes de citarlos: su sugerencia no reemplaza la lectura.

## Referencias

Montag, C., Lachmann, B., Herrlich, M. y Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), Artículo 2612. https://doi.org/10.3390/ijerph16142612

Parra, D. y Amatriain, X. (2011). Walk the talk: Analyzing the relation between implicit and explicit feedback for preference elicitation. En J. A. Konstan, R. Conejo, J. L. Marzo y N. Oliver (Eds.), *User modeling, adaption and personalization* (pp. 255–268). Springer. https://doi.org/10.1007/978-3-642-22362-4_22

Parra, D. y Brusilovsky, P. (2015). User-controllable personalization: A case study with SetFusion. *International Journal of Human-Computer Studies, 78*, 43–67. https://doi.org/10.1016/j.ijhcs.2015.01.007

## Registro de cambios (disclaimer)

### 2026-11-03 — Correo con el video

- **Qué cambió:** se registra la respuesta de Denis y se suma el correo que se le envía: un video de menos de un minuto, sin sonido, y tres preguntas desde su trabajo publicado, con lo que aporta cada una a la memoria, lo que muestra el video y cómo usar su respuesta. Se suma la referencia de Parra y Amatriain (2011).
- **Cómo estaba antes:** el guion suponía una videollamada, y la versión escrita era una lista de cinco preguntas del guion.
- **Por qué:** Denis tiene la agenda llena hasta mediados de diciembre y pidió un video o algo corto por correo; el autor pidió preguntas que aporten desde su experiencia y explicar Relevo sin tecnicismos.

### 2026-11-03 — Erratas del trato de tú

- **Qué cambió:** la frase del consentimiento en la apertura pasa a tú («Tu participación…, Puedes pedirme…, cuando quieras»), y los verbos con una tilde de más quedan bien escritos (por ejemplo, «harías»).
- **Cómo estaba antes:** esa frase seguía en usted («Su participación…, Puede pedirme…, cuando quiera») y varios verbos tenían la tilde duplicada («haríías»).
- **Por qué:** el autor pidió tratar de tú; los errores se encontraron al preparar el correo para Parra.

### 2026-11-02 — Entrevista posterior a la prueba

- **Qué cambió:** el guion prioriza interpretar los resultados y fortalecer el marco teórico: cambian los objetivos y se suman las preguntas A (recordar no basta para empezar) y B (lo que falta en el marco teórico), que también encabezan la versión escrita.
- **Cómo estaba antes:** los objetivos miraban sobre todo al diseño y a pruebas futuras.
- **Por qué:** el autor aclaró que las entrevistas son posteriores a la prueba.

### 2026-11-02 — Sin adjuntos

- **Qué cambió:** la página para mostrar ya no se envía antes; se comparte en pantalla si hace falta.
- **Cómo estaba antes:** se enviaba dos días antes de la entrevista.
- **Por qué:** el autor pidió que la invitación no lleve adjuntos.

### 2026-11-02 — De tú y por videollamada

- **Qué cambió:** todo lo que se le dice a la persona trata de tú, y la entrevista es siempre por videollamada, con el Tag y las figuras mostrados por cámara o pantalla.
- **Cómo estaba antes:** trataba de usted y proponía también una reunión en persona.
- **Por qué:** pedido del autor.

### 2026-11-02 — Guía de los profesores

- **Qué cambió:** se suma una pregunta inicial sobre su trabajo y una de cierre («Si pudieras cambiar una sola cosa…»); las preguntas de sí o no pasan a ser abiertas, y la apertura dice que la participación es voluntaria y que puede detener la grabación o borrar una parte.
- **Cómo estaba antes:** empezaba directo en Relevo, tenía preguntas que se respondían con sí o no y no mencionaba esos derechos.
- **Por qué:** el autor entregó la guía de entrevista semiestructurada de sus profesores.

### 2026-11-02 — Creación

- **Qué cambió:** se creó el guion para entrevistar a Denis Parra, a partir de su trabajo en sistemas de recomendación e interfaces que dan control a las personas.
- **Cómo estaba antes:** solo existía la guía general, con preguntas comunes y por disciplina.
- **Por qué:** el autor pidió un guion para cada persona en Chile.
