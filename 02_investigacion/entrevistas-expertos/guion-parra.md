# Guion de entrevista: Denis Parra

**Disciplina:** ciencia de la computación; sistemas de recomendación, interfaces inteligentes e inteligencia artificial centrada en las personas. **Institución:** profesor asociado, Departamento de Ciencia de la Computación, Pontificia Universidad Católica de Chile. **Duración:** 30 a 35 minutos. **Formato:** videollamada. **Trato:** de tú. **Idioma:** español.

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

> Su participación es voluntaria y no hay respuestas correctas: me interesa tu opinión. Puede pedirme detener la grabación o borrar una parte, o terminar cuando quiera.

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

> Este es el párrafo de la memoria que explica por qué una sesión continúa: el desplazamiento infinito y la reproducción automática mantienen abierta la secuencia y quitan los momentos de cierre. Desde los sistemas de recomendación, ¿qué corregiríías o agregaríías?

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
- *Repreguntas:* «¿Qué señales usaríías y cuáles evitaríías?», «¿Qué riesgo ves en que el sistema decida cuándo intervenir?».
- *Va a:* capítulo 13, «Iterar con los resultados», y capítulo 14, proyecciones.

**4. Explicar por qué sonó**

> En tus interfaces de recomendación, la explicación ayuda a entender lo que hace el sistema. ¿Cómo podría Relevo explicar por qué sonó, por ejemplo «sumaste 25 minutos en TikTok», sin que se lea como un juicio?

- *Va a:* capítulo 11, «Cómo habla Relevo».

**5. ★ Qué medir y qué no afirmar**

> Con tres personas, Relevo registró cuándo se activó cada relevo, si sonó, cómo se calló y qué respondió cada persona. ¿Qué medida del registro del teléfono sumaríías, y qué no debería afirmar la memoria con estos datos?

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

Enviar solo cinco preguntas: A, B, 1, 2 y «¿A quién más consultarías?».

## Después

Llenar la ficha de la [guía](guia-de-entrevista.md#cómo-registrar-la-entrevista) el mismo día. Si propone otra condición para que suene Relevo, anotarla como propuesta: la decide el autor y no cambia la prueba ya hecha.

## Referencias

Montag, C., Lachmann, B., Herrlich, M. y Zweig, K. (2019). Addictive features of social media/messenger platforms and freemium games against the background of psychological and economic theories. *International Journal of Environmental Research and Public Health, 16*(14), Artículo 2612. https://doi.org/10.3390/ijerph16142612

Parra, D. y Brusilovsky, P. (2015). User-controllable personalization: A case study with SetFusion. *International Journal of Human-Computer Studies, 78*, 43–67. https://doi.org/10.1016/j.ijhcs.2015.01.007

## Registro de cambios (disclaimer)

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
