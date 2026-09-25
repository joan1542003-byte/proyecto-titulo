# Anotaciones de clase: texto original y estado al 25 de septiembre

**Procedencia:** notas propias del autor, tomadas en su última clase y entregadas en Markdown el 25 de septiembre de 2026. Coinciden punto por punto con las notas que el autor entregó el 23 de septiembre y que ya se analizaron en la [síntesis del 23 de septiembre](../02_investigacion/sintesis-anotaciones-2026-09-23.md) y en la [aplicación del feedback docente](../00_gobernanza/aplicacion-feedback-docente-2026-09-23.md). Hasta hoy el repositorio no guardaba el texto original. Si corresponden a una clase distinta, hay que corregir la fecha del nombre del archivo.

**Cómo leerlas:** son apuntes de lo dicho en clase, no resultados de pruebas ni decisiones tomadas. Algunas indicaciones chocan con criterios de la memoria; esas se marcan como decisiones pendientes del autor.

## Estado de cada anotación

Estado: **hecho** (implementado o documentado), **parcial**, **pendiente** o **decisión del autor** (choca con la memoria o requiere elegir).

### Datos y privacidad

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Cuidar la protección de datos personales; la comisión puede preguntar por la política de datos. | Parcial | La app pide consentimiento y permite solicitar el borrado; la [auditoría de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md) describe qué se guarda. Falta una política de privacidad breve, en lenguaje simple, para mostrar a la comisión, y comprobar el borrado de extremo a extremo. |

### Control, botones y permisos

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Poder volver un paso atrás, también con el gesto de deslizar; la persona debe tener el control. | Hecho (2.5) | Regreso por gesto en tutorial y preparación. Falta probarlo en un teléfono real. |
| Botones fijos y consistentes; si un botón se mueve, que sea por una razón. | Hecho (2.5) | El botón principal conserva su lugar. Revisar las 16 pantallas del kit con la misma regla. |
| El nombre del botón debe decir qué hace: verbo y sustantivo, como «Ir al inicio». | Parcial | La mayoría ya cumple («Preparar un relevo», «Silenciar y continuar», «Ir al inicio»). Quedan tres sin verbo: «Nuevo relevo», «Prueba de 15 s» y «Privacidad y datos». |
| El permiso debe estar activo para avanzar. | Hecho (2.5) | El permiso de Tiempo de uso es obligatorio para terminar el tutorial. |

### Contexto y regreso

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Una lámina sobre la app que dé contexto a la persona. | Parcial | El tutorial explica el uso; el [guion del 30 de septiembre](../00_gobernanza/guion-presentacion-correccion-cruzada-2026-09-30.md) tiene la diapositiva «Cómo funciona». |
| Qué pasa si la persona olvida la app y la abre días después. | Pendiente | La app 2.6 no tiene un estado para el regreso. La síntesis propone un texto: «Tu relevo anterior ya no está activo. Revisa si esta actividad, este lugar y este tiempo todavía te sirven». |

### Pantallas, texto e imagen

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Centrar el texto y hacerlo un poco más grande, según el estándar. | Parcial | La pantalla de señal ya muestra la actividad en tamaño grande. Quedan textos en `bodySmall`; revisar con el tamaño de letra ampliado de Android. Centrar sirve para títulos breves, no para párrafos. |
| Imágenes más grandes en el tutorial; evitar espacios en blanco grandes. | Parcial | Se revisó el tutorial en 2.5, pero falta verlo en un teléfono real. |
| Los textos son muy pequeños cuando Relevo se activa. | Hecho (2.6) | La actividad aparece en `displaySmall`; falta comprobarlo en el teléfono. |
| Cambiar «Querías hacer esto» por algo como «Es momento de hacer lo que querías». | Hecho | La pantalla dice «Es momento de volver a elegir». Si se aprueba D-073, el texto se ajusta a la firma. |
| Tratamiento de imagen coherente con las actividades predefinidas: realista, degradado suave, sin rostros; más actividades según las entrevistas. | Parcial | La marca D-073 define la fotografía. Faltan actividades nuevas tomadas de las entrevistas (dibujar, manualidades, dormir) y registrar el prompt de cada imagen. |

### Navegación, progreso y movimiento

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Barra de progreso continua en vez de barras separadas, que avance con una animación lenta. | Hecho (2.5) | Progreso continuo. |
| Selector de tiempo más bonito y lúdico, pero funcional; por qué 60 minutos y no horas. | Hecho (2.2 y 2.5) | Deslizador de 1 minuto a 6 horas y accesos de 15 minutos, 1 hora y 2 horas. Se puede seguir mejorando el diseño. |
| Barra de navegación ilegible y desenfoque que se ve como un bloque; icono arriba y texto abajo, al nivel de iOS 26. | Parcial | La legibilidad se reforzó en 2.5. El desenfoque y las microanimaciones siguen sin revisarse en un teléfono. Liquid Glass de Apple sirve como referente, no como especificación de Android. |
| ¿El logotipo «relevo» debe estar siempre presente y en el mismo lugar? | Decisión del autor | Revisar cómo lo resuelven otras apps y decidirlo junto con D-073. |
| La app no debe ser seria ni aburrida: animaciones más interesantes sin perder la esencia. | Parcial | El kit D-073 define el movimiento; falta implementarlo. |

### Funciones

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Poder elegir varias apps, no solo una. | Hecho (2.6) | Se suma el tiempo de varias apps bajo un mismo límite. |
| ¿Se puede usar Relevo sin el dispositivo? ¿Sonar en el teléfono rompe el relato? | Hecho (2.6) | Se puede elegir el teléfono como salida, declarado como comparación y no como experiencia *phygital*. |
| Integrar la evaluación en la app, de forma sutil y en un solo paso. | Hecho | Pregunta opcional «¿Qué decidiste?», de un toque, que se puede omitir. |
| Guardar las actividades que crea la persona. | Hecho | Se guardan en el teléfono (`CustomActivityStore`). |
| Crear un perfil: nombre, imágenes o iconos prehechos, para que la app se sienta propia y ayude a recoger datos. | Pendiente y decisión del autor | El kit D-073 propone una pantalla de perfil; la app no la tiene. Recoger más datos exige revisar el consentimiento. |

### Hábito, refuerzo y perfiles de progreso

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Ayudar a crear un hábito; hacer un seguimiento para que la persona mejore y no se quede en un solo relevo. | Decisión del autor | La memoria distingue recordar, empezar y formar un hábito, y no atribuye hábitos a un aviso (capítulo 6). Adoptarlo exige cambiar objetivos, criterios y pruebas. |
| Capa emotiva: felicitar por usar menos una app, por rachas de relevos exitosos o por no agotar el tiempo de una app. | Decisión del autor | La app muestra un reconocimiento breve al declarar «Comencé la actividad». Las rachas y las felicitaciones por usar menos el teléfono contradicen hoy los criterios 4 y 5 de la memoria y el usuario límite. La [revisión sobre hábitos y rachas](../02_investigacion/habitos-reconocimiento-y-rachas-2026-09-23.md) reúne la evidencia a favor y en contra. |
| Recordar que las zapatillas están ahí, con notificaciones o un recordatorio dinámico en la app. | Decisión del autor | Un recordatorio adicional cambia el principio de «sin insistencia». La síntesis propone una invitación ocasional, apagable, para revisar un relevo inactivo. |
| Mensajes como «Esta semana usaste todo tu tiempo de Instagram» o «Llevas tres semanas cumpliendo tu desafío», visibles al abrir la app. | Decisión del autor | Suponen una cuota de uso correcta y una conducta que Relevo no verifica; hoy chocan con la memoria. |
| Perfiles por tipo de persona con progresión: la persona deportiva empieza caminando y luego trota; la lectora parte por libros breves o géneros conocidos. | Parcial y decisión del autor | Las entrevistas respaldan actividades concretas, no perfiles fijos. Se pueden ofrecer como pasos sugeridos y editables, sin clasificar a la persona. |
| Probar al menos 21 días para saber si se creó un hábito o hubo mejora. | Decisión del autor | 21 días no bastan para afirmar un hábito: en Lally et al. (2010) la mediana fue de 66 días. Puede diseñarse un piloto de 21 días como observación de continuidad, con otro consentimiento; hoy el consentimiento es de dos días. |

### Usuario y posicionamiento

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Ayudar a la comisión a entender dónde se ubica Relevo en el universo de «quiero cambiar»; ¿junto a quién se posiciona? | Hecho | Diapositiva «Lo que ya existe» del guion, capítulo 8 de la memoria y texto de lámina en la síntesis. |
| Analogía: aprender inglés con Open English o con Duolingo es muy distinto. | Pendiente | Sirve para explicar que el mismo objetivo admite mecanismos distintos. Puede sumarse al guion como frase oral. |
| La persona que no va a dejar el objeto junto a las zapatillas no es el usuario. | Decisión del autor | Es coherente con el usuario principal, pero excluir ese caso impediría detectar si la preparación es demasiado costosa. La síntesis recomienda no descartarlo. |
| Diseñar desde el usuario: releer las entrevistas y el marco teórico antes de definir perfiles. | Pendiente | Usar la [matriz P1–P8](../03_usuarios/matriz-evidencia-p1-p8.md) antes de cualquier perfil. |

### Proceso y uso de IA

| Anotación | Estado | Evidencia o próximo paso |
| --- | --- | --- |
| Documentar cómo cambió el diseño de interfaces al crear la app con IA: prompts, contexto entregado, recursos, y qué decisiones son del autor y cuáles de la IA. | Parcial | Existe la [trazabilidad del uso de IA](../00_gobernanza/trazabilidad-uso-ia-2026-09-23.md). Falta un registro continuo por versión de la app, con prompt, uso, fin y resultado. |
| Documentar siempre los prompts de imagen: prompt, uso, fin y resultado. | Parcial | Registrar el prompt original de las imágenes de actividades. |
| Seguir buenas prácticas de apps sin patrones oscuros; que la persona sienta la app como suya. | Criterio vigente | Coincide con los criterios 4 y 6 de la memoria y con la marca D-073. |

## Decisiones que necesita el autor

1. **Hábito y refuerzo:** la clase pide ayudar a crear hábitos, felicitar y mostrar rachas o desafíos; la memoria sostiene lo contrario, con respaldo en fuentes y entrevistas. Hay que decidir si se mantiene esa postura y se argumenta ante la comisión, o si se cambia la formulación del proyecto.
2. **Duración de las pruebas:** dos días o un piloto de 21 días como observación de continuidad, con otro consentimiento.
3. **Perfil de usuario:** si se implementa y qué datos recoge.
4. **Regreso tras días sin uso:** si se programa ahora o después de la prueba.

## Texto original

Se transcribe sin cambios, salvo los escapes de Markdown del archivo convertido.

> ### Anotaciones Correcciones  Politica de privacidad:
>
> Peoteccion de datos personales: Tener cuidado con eso
>
> Comision podría preguntarnos sobre la politica de daros
>
> (Cuando?) **QUA**: Volver atras de un paso Laws of ux: el usuario debe tener el control Swipe para volver atras en un paso
>
> Eñ usuario debe tener el control
>
> Mayor contenido: una lamina sobre la app, darle al usuario el contexto de la app Considerar qué pasa cuando una persona se olvida de la app y la abre días después
>
> Diseñar desde el usuario
>
> Centrar todo incluso el texto y un poco más grande (ver el estandar)
>
> Imagenes más grandes en el tutorial. aprovechar el espacio   Evitar dejar espacios en blanco tan grandes
>
> Comsiderar el boton que se mueve (Por ejemplo si el boton de continuar esta en un lugar, pero luego en una pantalla se mueve porque aparece otro botón debajo o arriba)
>
> Botones fijos, consistencia, evitar mover un boton (cuando el boton se mueve, es por decisión, es par evidenciar algo)
>
> Que quede claro lo que hace el boton, basicamente su nombre (Al pulsar el boton se que tendre que hacer una tarea esto esta bien hecho)
>
> (Ejemplo de buena practica) Ir al inicio : verbo + sustantivo
>
> El permiso debe estar activo si o si para avanzar.
>
> Tengo toda la pantalla disponible, evitar espacios en blanco grandes.
>
> - *Externo a la app: Como usamos la herramienta de IA, Documentar como ha cambiado el diseño de interfaces, durante nuestro proceso de crear una app con ia , **PROMPTS**, documentar los contextos que se le dan, lso prompts, las decisiones que son mías y cuales son de la IA, cómo lo alimentamos con recursos que le ayudarán
>
> Ayudar a la comision a entender como mi herramienta (relevo) se posiciona en el universo de *quiero cambiar*
>
> La persona que NO va a ponerlo cerca de la zapatilla no es el usuario
>
> Junto a quien se posicion nuestra app?
>
> "aprender ingles en openinglish y diolingo es muy distinto*
>
> *Esta guia paso a paso…”
>
> Cuanto control tengo
>
> Debemos ayudar a crear un habito
>
> Agregar una capa emotiva, felicitar al usuario (si uso menos una app, o por una racha de relevo exitosas, o por no haber cumplido el uso de una app también ayuda)
>
> Recordar al usuario que las zapatillas estan ahi (quizas notificaciones, o añadir un recordatorio dinámico en la app, o ambos) (felicitar al usuario, reforzar pro activamente)
>
> "Esta semana usaste todo tu tiempo de instagram, hagamos que la próxima semana sea diatitno" Esto no solo debe ser una notificación, debe ser algo que ves al abrir una app y claramente se cumpla una condición.
>
> Debemos ayudar a crear un habito
>
> "llevas tres semanas cumpliendo tu desafio de... cual es tu proximo desafio"?
>
> Ayudar al usuario a definir un perfil: diferentes actividades swgun perfil, quizas establecer las actividades que desea “recuperar” o ir paso a paso, por ejemplo el perfil deportivo deberia empezar pro salir a caminar, luego trotrar, luego hacer pesas ya si…  El usuario lector empieza por libros de diferentes paginas o explorar primero géneros que le gustan y luego nuevos  hay que definir bien el usuario, leer entrevistas en el repositorio y otra documentación que forma parte de nuestro marco teórico y referencias oficiales de la memoria.
>
> Hay un seguimiento, ayudamos al usuario a mejorae y no quedarse en un Relevo.
>
> Aumentar los dias de testeo (debemos testar la menso 21 días para saber is e creo un hábito o hubo una mejoría)
>
> La evaluacion dentro de la app (es decir la evaluación del testo integrarla en la app, de forma sutil, peor que suceda, que no sea inbvasiva y sea facil y rápido de responder, por ejemplo que no requiera uan confirmación de varios pasos.  ¿No puedo activar relevo sin el dispositivo? Si no lo hago con e dispositivo que esa? No puedo usarlo? Deberia haber quizas otra alternativa. ¿Seria posible hacer que suene en el telefonillo directamente? O rompería nuestro “storytellign” que hacer ene este caso?  ¿Por que 60 minutos de una app y no 1 hora o mas? Yo mejoraría la selección de horas, haría mas innovador y bonito todo eso, mas divertido, juguetón pero funcional. (No usar kill de ponytail)  - Los pasos tiene “barras separadas” arriba, por qué no poner mejor una barra n separada, del progreso, que se anima lentamente am medida que avanzas de paso?   -La app no debe ser seria ni aburrida, es decir debe estar bien diseñada, conservar la esencia, pero no por eso no deberíamos no implementar animaciones mas interesantes.  - La barra de navegación apenas s logra leer, ademas esta bugeado el desenfoque progresivo, se sigue sintiendo como u bloque y no es suave ni al nivel de iOS 26, busca como es como funciona el desenfoque progresivo de iOS.  La barra de navegación esta ma diseñada, yo la mejoraría: icono arriba, texto abajo. *Revisar aniamciones y mciroaniamciones, com odies espero algo al nivel de iso26.  el tetxo icono de “relevo” deberia estar siempre presente, centrado en el mismo lugar? Otras apps hacen eso?  El tratamiento de imagen debe seguir el de las imagenes que se usan con las actividades predefinidas *agregar mas actividades segun las entrevistas a los usuarios (Imagen realista, con iluminación de degradado sutil, evitar que se vean caras, idealmente revisa rl epromp origina que se uso)  - Documentar los prompts siempre, prompt, uso, fin u resultado (resumir el promp o mejorarlo para que este bie escrito)  - Entender las mejores practicas de las aplicaciones, sin caer en los dark pateros. Queremos que el usuario se sienta cómodo con la app, que la sienta “suya”  - Seria útil crear el “perfil”. Del usuario, la pantalla que permite personalizarlo ,establecer nombre, quizas unas fotos pre hechas o iconos que lo ayuden a sentirse como “el” ademas esto nso ayudará a la recopilación de datos.  - ¿Por qué solo una app y no varias? Quizás seria bueno poder elegir entre más apps, porque el usuario no usa solo una normalmente.  “Querías hacer esto” quizas sea por; Es momento de hacer lo que querías.  Los textos estan muy pequeños cuando relevo se activa.  - La aplicación de las actividades creadas pro el usuario, deberia guardarse

## Referencias

Lally, P., van Jaarsveld, C. H. M., Potts, H. W. W., & Wardle, J. (2010). How are habits formed: Modelling habit formation in the real world. *European Journal of Social Psychology, 40*(6), 998–1009. https://doi.org/10.1002/ejsp.674

---

## Registro de cambios (disclaimer)

### 2026-09-25 — Creación

- **Qué se añadió:** el texto original de las anotaciones de clase y una tabla con el estado de cada una frente a la app 2.6 y al repositorio, más las decisiones que necesita el autor.
- **Cómo estaba antes:** el repositorio tenía la síntesis y la aplicación de estas notas (23 de septiembre), pero no el texto original ni su estado después de la app 2.6.
- **Por qué:** el autor pidió analizarlas y guardarlas para un trabajo posterior.
