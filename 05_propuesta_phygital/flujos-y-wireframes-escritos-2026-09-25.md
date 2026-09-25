# Flujos y wireframes escritos: perfil, ruta, regreso y prueba de 21 días

**Estado:** diseño escrito para trabajar más adelante, cuando el autor lo pida. No cambia todavía la app 2.6, la memoria, el consentimiento ni el protocolo.
**Origen:** respuesta del autor del 25 de septiembre a las [anotaciones de clase](../01_contexto_y_fuentes/anotaciones-clase-originales-2026-09-23.md); decisiones D-074 a D-077 del [registro](../09_decisiones/registro-de-decisiones.md).
**Base:** app Android 2.6, [kit de diseño D-073](../10_recursos_visuales/marca-a-tiempo/kit-relevo-2026-09-25.html), [revisión sobre hábitos y rachas](../02_investigacion/habitos-reconocimiento-y-rachas-2026-09-23.md) y entrevistas P1–P8.

## 1. Qué decidió el autor

| Tema | Decisión | Qué queda por hacer |
| --- | --- | --- |
| Hábito y refuerzo | No hacerlo como se planteó en clase (rachas, felicitar por usar menos una app, cuotas de uso), sino por un camino que acompañe sin caer en las malas prácticas que describe la memoria. | Implementar la sección 4 y probarla. |
| Regreso tras varios días | Debe existir algo que motive, que sea buena práctica y no un patrón oscuro. | Flujo F4. |
| Perfil | Debe existir: nombre, una imagen que represente a la persona e intereses. Los intereses ayudan a construir una ruta de actividades. | Pantallas P1 a P3 y R1 a R3. |
| Privacidad y bienvenida | Más breves y claras. Los datos se borran cuando la persona lo pide y, como máximo, el 30 de diciembre de 2026. | Textos de la sección 7. |
| Botones | Deben tener verbo. | Lista de la sección 7. |
| Prueba | El consentimiento pasará a 21 días. La evaluación se integra en la app de forma natural y aporta datos ricos a la prueba. | Sección 5; actualizar consentimiento, protocolo, pauta y memoria. |
| Teléfono real | La prueba en un teléfono real será pronto. | Usar la pauta 2.6 antes de implementar lo nuevo. |
| «Quien no deja el objeto junto a las zapatillas no es el usuario» | Afirmarlo es demasiado; hay que reformularlo o rechazarlo. | Opciones en la sección 8. |

## 2. Principios de diseño

1. **Reconocer hechos, no juzgar.** La app solo comenta lo que sabe: que la persona preparó un relevo, que sonó la señal o lo que ella declaró. Un comentario informativo apoya la motivación; uno que presiona la reduce (Ryan & Deci, 2000).
2. **La persona elige qué recibir.** Resúmenes, recordatorios de regreso y reconocimientos se activan en el perfil y se apagan con un toque.
3. **Sin patrones oscuros.** No hay avisos insistentes, obstáculos para salir, opciones escondidas, acciones forzadas (Gray et al., 2018), urgencias o escaseces falsas (Mathur et al., 2019).
4. **Nada de cuotas ni pérdidas.** No se muestran minutos de pantalla como meta, comparaciones entre personas ni pérdida de racha, y no se felicita por usar menos una app.
5. **Usuario límite:** si la persona no tiene nada en mente, la app no pide nada.
6. **Un botón, un verbo.** La acción principal ocupa siempre el mismo lugar.

## 3. Mapa de pantallas

La navegación tiene tres destinos, con icono arriba y texto abajo: **Inicio**, **Ruta** y **Perfil**. Los destinos se nombran con sustantivos, y las acciones, con verbos.

| Grupo | Pantallas |
| --- | --- |
| Primera vez | A1 Bienvenida · A2 Participar en la prueba · A3 Permiso de tiempo de uso |
| Perfil | P1 Tu nombre · P2 Tu imagen · P3 Tus intereses |
| Ruta | R1 Tu ruta · R2 Pasos de una actividad · R3 Siguiente paso |
| Relevo | B1 Inicio · B2 Preparar (seis pasos) · B3 Esperando · B4 Señal · B5 ¿Qué decidiste? |
| Regreso | V1 Regreso en Inicio · V2 Aviso de regreso (opcional) |
| Prueba | T1 Pregunta del día · T2 Cierre del día 21 |
| Ajustes | S1 Perfil · S2 Avisos y resúmenes · S3 Privacidad y datos |
| Fallos | E1 No sonó · E2 Permiso retirado |

## 4. Wireframes escritos

Cada pantalla se lee de arriba abajo. **[Botón]** es la acción principal; *[enlace]* es una acción secundaria.

### A1 Bienvenida

```
relevo
Anota algo que quieres hacer.
Relevo te lo recuerda mientras todavía puedes hacerlo.
Tú decides qué hacer después.
[imagen: zapatillas junto a la puerta]
[Empezar]
```

- **No hace:** no pide datos ni muestra varias páginas de explicación; el resto se aprende al usarla.

### A2 Participar en la prueba

```
Participar en la prueba
Durante 21 días usarás Relevo y responderás preguntas breves.
Guardamos lo que preparas y lo que respondes, con un código en vez de tu nombre.
Puedes pedir que borremos todo cuando quieras.
*[Leer los detalles]*   → hoja completa del consentimiento
[Aceptar y seguir]
*[No participar]*
```

- **Estados:** si la persona no participa, la app funciona igual pero no envía datos.

### A3 Permiso de tiempo de uso

```
Para contar el tiempo de las apps que elijas,
Android pide un permiso. Relevo no lee lo que haces dentro de ellas.
[Abrir ajustes de Android]
```

- **Regla:** el permiso es obligatorio para avanzar (hecho en 2.5). Al volver con el permiso activo, la app avanza sola.

### P1 Tu nombre

```
¿Cómo te llamamos?
[campo renglón: Tu nombre]
Solo lo verás tú. No sale del teléfono.
[Seguir]    *[Saltar]*
```

- **Privacidad:** el nombre no se sincroniza con la base de la prueba.

### P2 Tu imagen

```
Elige una imagen
[cuadrícula 3×4 de iconos del kit: zapatilla, libro, lápiz, guitarra, olla, planta…]
[Seguir]    *[Saltar]*
```

- **Criterio:** son imágenes prehechas del kit. No se suben fotos, para no guardar rostros.

### P3 Tus intereses

```
¿Qué te gustaría hacer más seguido?
Elige una o varias.
( ) Moverme          ( ) Leer
( ) Crear con las manos   ( ) Cuidar la casa y a mí
( ) Aprender algo    ( ) Otra: [campo]
[Armar mi ruta]    *[Saltar]*
```

- **Criterio:** son intereses, no perfiles fijos; la persona puede cambiarlos cuando quiera.
- **Estados:** si salta, Inicio ofrece preparar un relevo libre y la ruta queda vacía.

### R1 Tu ruta

```
Tu ruta
Moverme
  ● Salir a caminar 15 minutos      ← estás aquí
  ○ Caminar 30 minutos
  ○ Trotar un tramo
  *[Editar pasos]*
Leer
  ● Leer 10 páginas
  ○ Leer un capítulo
[Preparar un relevo con este paso]
```

- **Criterio:** los pasos son sugerencias editables. La persona puede quedarse en un paso todo el tiempo que quiera, saltarlo o borrarlo.
- **No hace:** no avanza sola, no muestra porcentajes, puntos ni «nivel».

### R2 Pasos de una actividad

```
Moverme
1. Salir a caminar 15 minutos   · Empiezas: ponerte las zapatillas · Lugar: junto a la puerta
2. Caminar 30 minutos
3. Trotar un tramo
[Guardar cambios]   *[Agregar un paso]*
```

### R3 Siguiente paso

Aparece solo después de que la persona responde «Comencé la actividad» varias veces en el mismo paso, dentro de B5. El número de veces se ajusta en la prueba; se propone tres.

```
Ya empezaste a caminar tres veces.
¿Quieres probar el siguiente paso de tu ruta?
Caminar 30 minutos
[Probar el siguiente paso]   *[Seguir en este paso]*
```

- **Criterio:** la frase repite lo que la persona declaró y no afirma que se formó un hábito. Las dos opciones pesan lo mismo.

### B1 Inicio

| Estado | Qué muestra | Acción principal |
| --- | --- | --- |
| Sin relevo, con ruta | «Hola, [nombre]». Tarjeta con el paso actual de la ruta y su primer paso. | **[Preparar un relevo]** |
| Sin relevo, sin ruta | «¿Tienes algo en mente? Puedes preparar un relevo cuando quieras». | **[Preparar un relevo]** |
| Relevo activo | Actividad, tiempo contado y dónde sonará. | **[Ver mi relevo]** · *[Desactivar el relevo]* |
| Regreso tras días | Ver V1. | **[Preparar de nuevo]** |
| Pregunta de la prueba pendiente | Tarjeta pequeña bajo el contenido principal (T1). | La del contenido principal |

### B2 Preparar (seis pasos, barra de progreso continua)

1. **Qué quieres hacer:** el paso actual de la ruta ya viene elegido, con *[Elegir otra actividad]*.
2. **Cómo empiezas:** «¿Cómo empezarás?», con la sugerencia de la ruta.
3. **Dónde lo dejas:** el lugar sugerido por la ruta, editable.
4. **Qué apps cuentan y cuánto tiempo:** varias apps; tiempo de 1 minuto a 6 horas.
5. **Dónde suena:** parlante o teléfono, con *[Probar el sonido]*.
6. **Revisar:** resumen y **[Activar el relevo]**.

- **Regla:** **[Seguir]** ocupa siempre el mismo lugar; volver atrás con el gesto conserva lo escrito.

### B3 Esperando

```
Tu relevo está activo
Leer 10 páginas · Empiezas: abrir el libro
Llevas 23 de 45 minutos en las apps elegidas
Sonará en: el parlante
[Ver los detalles]   *[Desactivar el relevo]*
```

### B4 Señal

```
Es momento de volver a elegir
Leer 10 páginas                ← texto grande
Empiezas: abrir el libro
Está en: la mesa del living
[Silenciar y continuar]
```

- **Duración del tono (propuesta):** en 2.6 el tono suena hasta silenciarlo. Se propone un patrón breve, de unos 3 segundos como en el protocolo, que suena una vez. La pantalla y la notificación quedan visibles en silencio hasta que la persona responde. La app registra, solo para la investigación, si la persona silenció la señal o esta terminó sola, cuánto tardó en responder y cuánto tiempo siguió en las apps elegidas después de la señal. Ese tiempo no se muestra como «tiempo excedido». Si la prueba muestra muchas señales que nadie notó, se evalúa como variante una única repetición suave.

### B5 ¿Qué decidiste?

```
¿Qué decidiste?
[Comencé la actividad]
[La dejé para después]
[Cambié de idea]
*[Omitir]*
— si participa en la prueba, debajo y con un toque:
¿Cómo se sintió el aviso?   (Útil)  (Neutro)  (Molesto)
```

- **Reconocimiento:**
  - «Comencé»: «Gracias por contarlo». Si es la tercera vez en el mismo paso, se muestra R3.
  - «Después»: «Queda guardado. Puedes prepararlo cuando quieras».
  - «Cambié de idea»: «Está bien. ¿Quieres cambiar la actividad de tu ruta?», con *[Cambiar la actividad]*.
  - Las tres respuestas pesan lo mismo y ninguna recibe reproche.

### V1 Regreso en Inicio

Se muestra la primera vez que la persona abre la app después de tres días o más sin abrirla.

```
Hola de nuevo, [nombre].
La última vez preparaste: Leer 10 páginas.
¿Sigue siendo lo que quieres?
[Preparar de nuevo]
*[Elegir otra actividad]*   *[Ahora no]*
```

- **Criterio:** no dice cuántos días pasaron ni sugiere que la persona falló. «Ahora no» oculta la tarjeta hasta el próximo regreso.
- **Si el relevo seguía activo y venció:** «Tu relevo anterior terminó sin sonar. ¿Lo preparamos de nuevo?».

### V2 Aviso de regreso (opcional)

Por defecto está apagado; la persona lo activa en S2. Llega como máximo una vez por semana y solo si no abrió la app en ese tiempo.

```
Relevo · ¿Sigue en pie leer esta semana?
[Preparar]  [Ahora no]
```

- **Regla:** tras dos «Ahora no» seguidos, la app pregunta una sola vez si quiere apagar estos avisos.

### S1 Perfil

```
[imagen]  [nombre]         *[Editar el perfil]*
Intereses: Moverme · Leer
Tu semana (si está activo):
  Preparaste 3 relevos. Dijiste que empezaste 2 veces.
  ¿Qué te ayudó?  *[Contar]*
Prueba: día 8 de 21
*[Avisos y resúmenes]*   *[Privacidad y datos]*
```

- **Criterio:** «Tu semana» solo cuenta hechos, sin metas ni comparación con semanas anteriores, y se puede apagar.

### S2 Avisos y resúmenes

| Opción | Valores | Por defecto |
| --- | --- | --- |
| Resumen «Tu semana» | Sí / No | No |
| Aviso de regreso | Nunca / Una vez por semana | Nunca |
| Mensajes de reconocimiento | Con mensajes / Solo registrar | Con mensajes |
| Constancia elegida (variante de prueba) | Apagada / «Quiero hacerlo _ veces por semana» | Apagada |

**Constancia elegida:** es la alternativa a las rachas. La persona fija su propia frecuencia; si una semana no la cumple, la app no dice nada y la semana siguiente empieza en cero sin mensajes. Se puede **[Pausar la constancia]**. Es una variante para comparar en la prueba, no una función decidida (Silverman & Barasch, 2023).

### S3 Privacidad y datos

```
Tus datos
Guardamos lo que preparas y respondes, con el código RLV-4821.
Tu nombre y tu imagen se quedan en el teléfono.
[Descargar mis datos]
[Borrar mis datos]   → confirmación en un paso
*[Leer la política completa]*
```

### T1 Pregunta del día (prueba de 21 días)

Es una tarjeta en Inicio, no una notificación: una pregunta por día como máximo, que se puede omitir y nunca bloquea el uso.

| Día | Pregunta | Formato |
| --- | --- | --- |
| 1 | ¿Qué te gustaría recuperar con Relevo? | Intereses del perfil y texto opcional |
| 1 y 21 | Cuatro frases sobre la actividad elegida («La hago sin pensarlo», etc.) | Escala de 1 a 5 |
| 3 | ¿Te costó preparar el relevo? | 1 a 5 |
| 7 | ¿El aviso te ayudó a recordar lo que querías? | Sí / A veces / No |
| 10 | ¿Dónde dejaste el parlante o el objeto? ¿Lo cambiaste? | Opciones y texto |
| 14 | ¿Algo te molestó? | Texto opcional |
| 21 | Ver T2 | — |

- **Cuatro frases:** son las del índice breve de automaticidad (Gardner et al., 2012). Compararlas entre el día 1 y el 21 puede mostrar un cambio, pero 21 días no bastan para afirmar un hábito (Lally et al., 2010).

### T2 Cierre del día 21

```
Terminaste la prueba. Gracias.
Cinco preguntas breves (2 minutos)
¿Seguirías usando Relevo?  ·  ¿Qué cambiarías?  ·  …
[Responder]   *[Responder después]*
¿Aceptas una conversación de 15 minutos?  [Sí]  [No]
```

### E1 No sonó

«Se cumplió el tiempo, pero no pudimos reproducir el sonido en el parlante. Revisa la conexión». Acción: **[Probar el sonido]**.

### E2 Permiso retirado

«Relevo dejó de contar porque se retiró el permiso de tiempo de uso». Acción: **[Abrir ajustes de Android]**.

## 5. Flujos

| Flujo | Recorrido |
| --- | --- |
| F1 Primera vez | A1 → A2 → A3 → P1 → P2 → P3 → R1 → B2 → B3. Nombre, imagen e intereses se pueden saltar. |
| F2 Preparar desde la ruta | B1 → B2.1 con el paso ya elegido → B2.2 a B2.6 → B3. |
| F3 Recibir y decidir | B3 → B4 → B5 → R3 (a la tercera vez) → B1. |
| F4 Regreso tras días | Abrir la app tras 3 días o más → V1 → B2 o Inicio. Con aviso activo: V2 → B2. |
| F5 Editar perfil y ruta | S1 → P1, P2 o P3 → R1 → R2. |
| F6 Borrar datos | S1 → S3 → **[Borrar mis datos]** → confirmación → A1. |
| F7 Prueba de 21 días | A2 → T1 los días 1, 3, 7, 10 y 14 → T2 el día 21. |
| F8 Fallo | B4 no suena → E1 → B2.5. Permiso retirado → E2 → A3. |

## 6. Variantes por tipo de usuario y preferencias

### Por situación

| Situación | Qué cambia |
| --- | --- |
| **Usuario principal:** tiene una actividad en mente. | Flujo completo F1 a F3 y ruta activa. |
| **Usuario límite:** su ocio digital tiene sentido o no tiene otra actividad en mente. | Puede saltar intereses; Inicio no pide nada; sin avisos de regreso por defecto. |
| **No quiere o no puede dejar el objeto junto al comienzo.** | Elige que suene en el teléfono. La app registra esa elección como dato de la prueba, porque muestra el costo de preparar el lugar (sección 8). |
| **Vuelve tras varios días.** | V1 y, si lo activó, V2. |
| **Baja audición.** | La señal es solo sonora (D-070); el teléfono vibra una vez. Hay que resolver una alternativa accesible antes de probar con personas con baja audición. |

### Por interés: rutas sugeridas

Son ejemplos editables, tomados de actividades mencionadas en las entrevistas y en la memoria: caminar y hacer ejercicio, leer, armar y dibujar, ordenar, cocinar y dormir. No se asigna un perfil a ningún participante.

| Interés | Pasos sugeridos | Primer paso y lugar |
| --- | --- | --- |
| Moverme | Caminar 15 min → caminar 30 min → trotar un tramo | Ponerte las zapatillas · junto a la puerta |
| Leer | Leer 10 páginas → un capítulo → probar un género nuevo | Abrir el libro · en el velador |
| Crear con las manos | Dibujar 10 min → terminar un boceto → probar otra técnica | Sacar el cuaderno y un lápiz · en el escritorio |
| Cuidar la casa y a mí | Ordenar un cajón → cocinar algo simple → acostarte sin el teléfono | Dejar el teléfono cargando lejos · en el velador |
| Aprender algo | Practicar 10 min → una lección → contarle a alguien | Abrir el cuaderno o el instrumento · donde estudias |

### Por preferencias

- **Sonido:** en el parlante, junto a la actividad, o en el teléfono como comparación.
- **Reconocimiento:** con mensajes breves o solo registrar.
- **Resumen semanal y aviso de regreso:** apagados por defecto.
- **Constancia elegida:** apagada por defecto; variante de la prueba.
- **Texto grande y movimiento reducido:** respetan los ajustes de Android.

## 7. Textos breves y botones

**Bienvenida (A1), 27 palabras:** «Anota algo que quieres hacer. Relevo te lo recuerda mientras todavía puedes hacerlo. Tú decides qué hacer después».

**Privacidad breve (A2 y S3), 60 palabras:** «Guardamos lo que preparas, cuándo suena el aviso y lo que respondes, con un código en vez de tu nombre. No leemos lo que haces dentro de otras apps. Tu nombre y tu imagen se quedan en el teléfono. Puedes descargar o borrar tus datos cuando quieras desde Perfil. Si no los borras antes, los eliminamos el 30 de diciembre de 2026».

**Conservación de los datos:** decidido por el autor el 25 de septiembre: los datos se borran cuando la persona lo pide y, como máximo, el 30 de diciembre de 2026, como dice el consentimiento vigente. La política breve debe decirlo: «Si no los borras antes, los eliminamos el 30 de diciembre de 2026».

**Botones con verbo:** sí, las acciones llevan verbo; los destinos de navegación y los títulos de sección se nombran con sustantivos (Inicio, Ruta, Perfil, Privacidad y datos).

| Hoy (2.6) | Propuesto |
| --- | --- |
| Nuevo relevo | Preparar otro relevo |
| Prueba de 15 s | Probar 15 segundos |
| Crear relevo | Crear un relevo |
| Ver todas | Ver todas las actividades |

## 8. «Quien no deja el objeto junto a las zapatillas no es el usuario»

| Opción | Redacción | Efecto |
| --- | --- | --- |
| Reformular (adoptada por el autor) | «Relevo está pensado para quien está dispuesto a preparar el comienzo de su actividad. Si esa preparación resulta demasiado costosa, es un hallazgo sobre el diseño, no sobre la persona». | Mantiene el foco sin excluir a nadie; convierte el rechazo en dato de la prueba. |
| Rechazar | No se usa la frase. | Evita el problema, pero pierde una condición útil del usuario principal. |
| Mantener | «Quien no prepara el lugar no es el usuario». | Protege la hipótesis de que el lugar importa, pero impide ver si la preparación pesa demasiado. |

## 8 b. Qué responde cada prueba

El hábito no es el centro de la memoria ni algo que la prueba pueda afirmar. La memoria pregunta: **¿qué condiciones pueden ayudar a que una persona vuelva a considerar una actividad elegida cuando, durante una sesión de ocio digital, esa intención deja de orientar su decisión inmediata?** Su hipótesis es que, si la persona registra una intención y su primer paso, sitúa una señal física junto a ese comienzo y la recibe cuando se cumple una condición configurada, esa intención podría volver a estar disponible para decidir, sin bloquear la actividad digital ni imponer su ejecución.

| Prueba | Qué responde | Qué no responde |
| --- | --- | --- |
| Teléfono real | Si la app funciona: conteo, sonido, silencio, permisos, envío y borrado de datos. | Nada sobre personas. |
| 21 días con la app | Si las personas entienden la preparación, qué carga les supone, si conservan el control, si la señal se nota y se entiende en casa, y si la usan de forma sostenida o la abandonan. | Si el lugar aporta más que una notificación, ni si se formó un hábito. |
| Asociación y comparación (protocolo 01) | La hipótesis: si la señal devuelve la intención y el primer paso sin mirar el teléfono, y si junto al primer paso funciona mejor que en un lugar neutro o que una notificación. | Eficacia en la población. |

## 9. Qué cambiará cuando se implemente

- **App:** A1, A2, P1 a P3, R1 a R3, V1, V2, S2, T1, T2, textos y botones; límite de duración del tono.
- **Consentimiento:** 21 días, preguntas integradas y nombre local; se mantiene el 30 de diciembre de 2026 como plazo de eliminación.
- **Protocolo y pauta:** prueba de 21 días, preguntas por día, variante de constancia elegida.
- **Memoria:** capítulos 10 y 13 (dos días pasan a 21, evaluación integrada) y criterio 4 (reconocimiento y ruta), manteniendo que 21 días no demuestran un hábito.
- **Kit:** pantallas de perfil, ruta y regreso con el sistema D-073.

## Referencias

Gardner, B., Abraham, C., Lally, P., & de Bruijn, G.-J. (2012). Towards parsimony in habit measurement: Testing the convergent and predictive validity of an automaticity subscale of the Self-Report Habit Index. *International Journal of Behavioral Nutrition and Physical Activity, 9*, Artículo 102. https://doi.org/10.1186/1479-5868-9-102

Gray, C. M., Kou, Y., Battles, B., Hoggatt, J., & Toombs, A. L. (2018). The dark (patterns) side of UX design. En *Proceedings of the 2018 CHI Conference on Human Factors in Computing Systems* (pp. 1–14). Association for Computing Machinery. https://doi.org/10.1145/3173574.3174108

Lally, P., van Jaarsveld, C. H. M., Potts, H. W. W., & Wardle, J. (2010). How are habits formed: Modelling habit formation in the real world. *European Journal of Social Psychology, 40*(6), 998–1009. https://doi.org/10.1002/ejsp.674

Mathur, A., Acar, G., Friedman, M. J., Lucherini, E., Mayer, J., Chetty, M., & Narayanan, A. (2019). Dark patterns at scale: Findings from a crawl of 11K shopping websites. *Proceedings of the ACM on Human-Computer Interaction, 3*(CSCW), 1–32. https://doi.org/10.1145/3359183

Ryan, R. M., & Deci, E. L. (2000). Self-determination theory and the facilitation of intrinsic motivation, social development, and well-being. *American Psychologist, 55*(1), 68–78. https://doi.org/10.1037/0003-066X.55.1.68

Silverman, J., & Barasch, A. (2023). On or off track: How (broken) streaks affect consumer decisions. *Journal of Consumer Research, 49*(6), 1095–1117. https://doi.org/10.1093/jcr/ucac029

---

## Registro de cambios (disclaimer)

### 2026-09-25 — Respuestas del autor

- **Qué cambió:** plazo de datos al 30 de diciembre de 2026; reformulación de la frase sobre el usuario adoptada; propuesta de duración del tono; nueva sección sobre qué responde cada prueba.
- **Cómo estaba antes:** esos puntos figuraban como pendientes o recomendaciones.
- **Por qué:** el autor respondió el mismo día.

### 2026-09-25 — Creación

- **Qué se añadió:** decisiones del autor del 25 de septiembre, principios, mapa de pantallas, 23 wireframes escritos, ocho flujos, variantes por situación, interés y preferencias, textos breves, botones con verbo y opciones para la frase sobre el usuario.
- **Cómo estaba antes:** las anotaciones de clase estaban analizadas, pero no había un diseño de perfil, ruta, regreso, prueba de 21 días ni textos breves.
- **Por qué:** el autor pidió anotar los pendientes y diseñar por escrito wireframes y flujos para trabajarlos más adelante.
