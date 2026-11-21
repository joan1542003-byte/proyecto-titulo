# Cambios para la memoria final

**Fecha:** 10 de noviembre de 2026.
**Pedido del autor:** verificar con los cuatro PDF nuevos (Fogg, Guynn, Waggoner y la tesis de Kalchik) las citas que se apoyan en ellos, redactar las correcciones del [informe de fuentes gratuitas](fuentes-gratuitas-2026-11-10.md) y revisar en APA 7 toda la memoria, sin editarla.
**Base:** la [memoria v6](../../08_memoria/borrador-memoria-v6-2026-10-28.md) tal como estaba el 10 de noviembre a las 20:58 (SHA-256 que empieza por `325fdeb1`). Esa versión ya no tenía las referencias de Anthropic, OpenAI, Mindicador ni Springer Nature, ni sus citas, y ya sumaba Lucide Contributors (s. f.).
**Para aplicar:** [`cambios-memoria-final-2026-11-10.json`](cambios-memoria-final-2026-11-10.json), con 21 reemplazos literales que se aplican en orden. Cada «buscar» aparece una sola vez en la versión base, y también al aplicarlos uno tras otro. Si alguno no aparece, es que la memoria cambió en ese punto después de esa hora.

## Resumen

- **21 cambios:** 13 de fondo, en que la cita decía algo que la fuente no dice; 2 por decisión del autor, para sacar Ullmer et al. (2022), y 6 de forma.
- **De fondo:** Ball et al. (2025), O’Rear y Radvansky (2019, dos frases), Hermann et al. (2007), el texto de la Figura 2, Kirsh (1995), Waggoner et al. (2026), Kolko (2011), Miller et al. (2007), la norma ISO, Gembali (2023) y dos entradas del glosario: «Interacción tangible» y «Marco multiproceso».
- **Después de aplicarlos**, la lista tiene 87 referencias: todas se citan y todas las citas tienen su referencia.

## Los cuatro PDF nuevos

- **Fogg (2009).** El PDF de ACM tiene el mismo texto que la copia del autor: siete páginas sin número impreso, que Crossref registra como 1–7. La cita «p. 1» está bien: esa página dice que la motivación, la capacidad y el desencadenante deben darse en el mismo momento. La p. 3 suma el umbral de activación, y la p. 6, que con motivación y capacidad suficientes basta el desencadenante; ambas respaldan la Figura 24. Sin cambios.
- **Guynn et al. (1998).** Coincide con la referencia: *Memory & Cognition, 26*(2), 287–298. Lo que cita la memoria está en la discusión general (p. 296) y en el resumen (p. 287). Cambio 6.
- **Waggoner et al. (2026).** Define *phygital* en la p. 3, en la sección 2, «“Phygital” user experiences»; el resumen, en la p. 1, lo glosa como «físico y digital». Cambio 10; el glosario coincide.
- **Kalchik (2016).** Es la tesis de maestría en Psicología de Andrea E. Kalchik, de la Universidad de Notre Dame (julio de 2016), dirigida por Gabriel A. Radvansky y publicada en dominio público en CurateND. Tiene el mismo título, el mismo centro comercial virtual y los mismos dos experimentos que el resumen de O’Rear y Radvansky (2019). La primera autora del artículo tiene las mismas iniciales, la misma universidad y el mismo director, así que parece la misma investigadora, aunque no está confirmado.
  - **Para qué sirve:** para verificar, no para citar. Confirma que en el primer experimento el lugar funcionó como señal y que la demora no cambió el desempeño (págs. 37–38), pero muestra que en el segundo el desempeño sí bajó con más demora (págs. 45–47 y 56). De ahí salen los cambios 3 y 4.
  - **Por qué no se suma:** APA pide citar la versión publicada, y después de los cambios todo lo que la memoria toma de O’Rear y Radvansky está en su resumen. Si se quisiera citar, la referencia sería: Kalchik, A. E. (2016). *Location-based prospective memory* [Tesis de maestría, University of Notre Dame]. CurateND. https://doi.org/10.7274/g732d794219

## Lista de cambios

**1. Capítulo 3, «Causas» — Kleinberg et al. (2024). Forma.**

- Antes: «puede confundir ambas cosas (Kleinberg et al., 2023).»
- Después: «puede confundir ambas cosas (Kleinberg et al., 2024).»
- Motivo: El artículo ya está en un número de Management Science: volumen 70, número 9, de septiembre de 2024, págs. 6336–6355 (página de INFORMS, en la copia de Internet Archive del 29 de enero de 2026, y registro de RePEc; Crossref aún no lo actualiza). La memoria usa el año del número, como en de Segovia Vicente et al. (2024) y O’Rear y Radvansky (2019). Va junto con el cambio 18.

**2. Capítulo 5, «Recordatorios, lugares y objetos» — Ball et al. (2025). Fondo.**

- Antes: «Esa señal ayuda: con muchas cosas que recordar, una alarma mejoró el cumplimiento de intenciones tanto en personas jóvenes como en mayores (Ball et al., 2025).»
- Después: «Esa señal ayuda: en un experimento con muchas cosas que recordar, tenerlas a la vista en la pantalla mejoró el cumplimiento de intenciones tanto en personas jóvenes como en mayores (Ball et al., 2025).»
- Motivo: En el estudio no hubo alarma: el recordatorio era la lista de palabras por recordar, visible en lo alto de la pantalla durante toda la tarea. Con mucha carga, jóvenes y mayores se beneficiaron por igual en el experimento 1 (resumen y método del manuscrito aceptado en PubMed Central). La alarma para un medicamento aparece solo como ejemplo general en el resumen.

**3. Capítulo 5, mismo apartado — O’Rear y Radvansky (2019). Fondo.**

- Antes: «O’Rear y Radvansky (2019) probaron si el lugar basta como recordatorio.»
- Después: «O’Rear y Radvansky (2019) estudiaron si el lugar sirve como recordatorio.»
- Motivo: El estudio explora la memoria prospectiva basada en el lugar y no compara el lugar con otras señales, así que no prueba que «baste» (resumen de PubMed). La tesis de maestría de Kalchik (2016, p. 31), con el mismo título, el mismo director y el mismo diseño, plantea el primer experimento como una prueba de si el lugar es una señal eficaz.

**4. Capítulo 5, mismo apartado — O’Rear y Radvansky (2019). Fondo.**

- Antes: «Las señales del lugar favorecieron el recuerdo, y el desempeño no cambió según cuánto rato hubiera pasado desde que recibieron el encargo.»
- Después: «En el primer experimento, las señales del lugar fueron eficaces y el desempeño no cambió según cuánto rato hubiera pasado desde que recibieron el encargo.»
- Motivo: El resumen da ambos resultados solo para el experimento 1. En la tesis de Kalchik (2016, págs. 45–47 y 56), con los mismos dos experimentos, el segundo sí mostró que el desempeño bajaba con más demora; dicha en general, la frase contradecía ese resultado. «Favorecieron» suponía una comparación que el estudio no hizo; «fueron eficaces» es lo que dice el resumen («effective»).

**5. Capítulo 5, mismo apartado — Hermann et al. (2007). Fondo.**

- Antes: «The Tangible Reminder mostraba cada compromiso en un objeto cotidiano que cambiaba de color al acercarse el plazo (Hermann et al., 2007);»
- Después: «The Tangible Reminder asociaba cada compromiso a un objeto cotidiano que se dejaba en una bandeja, y la bandeja cambiaba de color al acercarse el plazo (Hermann et al., 2007);»
- Motivo: El objeto no cambia de color: se deja en una bandeja, y la pantalla de la bandeja, detrás del objeto, muestra un color según la cercanía del plazo (verde al comienzo) y parpadea cuando se acerca (Hermann et al., 2007, págs. 144 y 146).

**6. Capítulo 6, «Recordar con objetos y lugares» — Guynn et al. (1998). Forma.**

- Antes: «y los que solo anunciaban la ocasión no mejoraban el recuerdo (Guynn et al., 1998).»
- Después: «y los que solo mencionaban la ocasión no mejoraban el recuerdo (Guynn et al., 1998, p. 296).»
- Motivo: Precisión y página, verificadas en el PDF de Memory & Cognition. Esos recordatorios pedían recordar las tres palabras señal estudiadas al comienzo; no anunciaban que la ocasión había llegado. La conclusión está en la discusión general (p. 296) y en el resumen (p. 287).

**7. Capítulo 6, texto de la Figura 2 — McDaniel y Einstein (2000). Fondo.**

- Antes: «Exige atención constante, Falla si otra actividad la absorbe; Recuperar ante una señal | Algo del entorno trae de vuelta la intención | Funciona aunque la atención esté en otra parte»
- Después: «Exige atención constante, Se vuelve difícil si otra actividad la absorbe; Recuperar ante una señal | Algo del entorno trae de vuelta la intención | Puede funcionar aunque la atención esté en otra parte»
- Motivo: La nota atribuye la figura a McDaniel y Einstein (2000), cuyo resumen (p. S127) dice que vigilar consume recursos y que la probabilidad de que el camino automático funcione varía según la tarea, la señal, la actividad en curso y la persona: no dice que vigilar «falle» ni que el otro camino funcione siempre. Se usa la misma idea del capítulo 3 («vigilar se vuelve difícil»). El autor, que dibuja las figuras, debe llevar esta redacción a la Figura 2.

**8. Capítulo 6, «Recordar con objetos y lugares» — Kirsh (1995). Fondo.**

- Antes: «Kirsh (1995) muestra que la disposición de los objetos puede simplificar la elección, la percepción y el cálculo mental. Dejar algo junto a la puerta para no olvidar llevarlo es un ejemplo cotidiano: el lugar recuerda la intención sin que haya que pensar en ella.»
- Después: «Kirsh (1995, p. 31) muestra que la disposición de los objetos puede simplificar la elección, la percepción y el cálculo mental. Dejar algo junto a la puerta para no olvidar llevarlo es uno de sus ejemplos: el objeto, puesto en el lugar indicado, llama la atención en el momento oportuno y trae de vuelta la intención (Kirsh, 1995, p. 38).»
- Motivo: El ejemplo es de Kirsh (p. 38: un rollo de película junto a la puerta para no salir sin llevarlo a revelar) y se leía como propio. «Sin que haya que pensar en ella» no está en la fuente: según Kirsh, esos recordatorios sirven porque llaman la atención en el momento justo, por ejemplo por estar en el lugar indicado, y suelen llevar a pensar en la tarea. La p. 31 (resumen) sostiene las tres categorías.

**9. Capítulo 6, mismo apartado — Ullmer et al. (2022). Decisión del autor.**

- Antes: «Veinticinco años después, uno de esos autores y sus colegas describen el campo como interacción tangible y corporizada, que suma el cuerpo a los objetos y al espacio (Ullmer et al., 2022).»
- Después: se elimina.
- Motivo: Ullmer et al. (2022) sale de la memoria porque no se consiguió y no es imprescindible; además, «que suma el cuerpo a los objetos y al espacio» era una glosa propia. El párrafo sigue correcto con Ishii y Ullmer (1997, p. 234): objetos y superficies del espacio en primer plano y medios del ambiente en segundo plano, que es de donde sale «el espacio» de la frase siguiente. Va junto con el cambio 19.

**10. Capítulo 6, cierre del capítulo — Waggoner et al. (2026). Fondo.**

- Antes: «A un sistema así, que reparte su trabajo entre lo físico y lo digital, se le llama *phygital* (Waggoner et al., 2026).»
- Después: «A una experiencia así, que se mueve entre lo físico y lo digital, se le llama *phygital* (Waggoner et al., 2026, p. 3); en esta memoria, el término nombra también el sistema que la hace posible.»
- Motivo: Waggoner et al. definen *phygital* en la p. 3 (sección 2, «“Phygital” user experiences»): una combinación de *physical* y *digital* para experiencias en que el recorrido del usuario pasa por espacios físicos y digitales, y los autores lo usan para experiencias de usuario que se mueven entre esos espacios. No hablan de un sistema que reparte su trabajo. Que el término nombre también al sistema es un uso de esta memoria, como ya dice el glosario.

**11. Capítulo 7, «Fuentes de información» — Sanders y Stappers (2012). Forma.**

- Antes: «Sanders y Stappers (2012, p. 69), en su guía de investigación generativa,»
- Después: «E. B.-N. Sanders y Stappers (2012, p. 69), en su guía de investigación generativa,»
- Motivo: Dos referencias tienen primeros autores con el mismo apellido e iniciales distintas (E. B.-N. Sanders y S. Sanders): APA pide las iniciales en todas sus citas en el texto. Van juntos los cambios 11, 12 y 13.

**12. Capítulo 7, nota de la Figura 5 — Sanders y Stappers (2012). Forma.**

- Antes: «*Nota.* Elaboración propia a partir de Sanders y Stappers (2012, p. 69).»
- Después: «*Nota.* Elaboración propia a partir de E. B.-N. Sanders y Stappers (2012, p. 69).»
- Motivo: Igual que el cambio 11 (APA 7, 8.20).

**13. Capítulo 8, «Herramientas digitales de medición y pausa» — Sanders (2026). Forma.**

- Antes: «que sea considerada distractora (Sanders, 2026).»
- Después: «que sea considerada distractora (S. Sanders, 2026).»
- Motivo: Igual que el cambio 11 (APA 7, 8.20).

**14. Capítulo 9, introducción — Kolko (2011). Fondo.**

- Antes: «Kolko (2011, p. 40) llama síntesis a este paso, en que lo aprendido se convierte en una oportunidad concreta de diseño.»
- Después: «Kolko (2011, p. 40) llama síntesis a este paso, que traduce en criterios de diseño específicos la oportunidad que describe la investigación.»
- Motivo: En la p. 40, la investigación describe una oportunidad y la síntesis la traduce en criterios de diseño específicos («specific design criteria»). La memoria lo decía al revés: lo aprendido se convertía en la oportunidad. La nueva versión calza con el capítulo, que trata de criterios.

**15. Capítulo 11, «Decisión abierta» — Miller et al. (2007). Fondo.**

- Antes: «lo reduce (Miller et al., 2007), y ofrecer una opción real ayuda más que insistir (criterio 4).»
- Después: «lo reduce (Miller et al., 2007); además, ofrecer una opción real ayuda más que insistir (criterio 4).»
- Motivo: La segunda parte quedaba pegada a la cita y se leía como de Miller et al., que no comparan ofrecer opciones con insistir; viene del criterio 4 (Grüning et al., 2023). El punto y coma la separa sin sacarla de la segunda razón.

**16. Capítulo 11, «Paleta cromática» — ISO (2011). Fondo.**

- Antes: «queda para los errores, y el negro, el gris y el rojo quedan fuera de los estados de la persona, como en la convención de la señalética (International Organization for Standardization [ISO], 2011).»
- Después: «queda para los errores, como en la señalética, cuya norma fija colores de seguridad para prevenir accidentes (International Organization for Standardization, 2011); el negro y el gris tampoco se usan para los estados de la persona.»
- Motivo: Dejar fuera el negro y el gris no está en el resumen oficial de la norma ni en la convención de colores que recoge la Directiva 92/58/CEE, la alternativa abierta que usó el informe previo; queda como decisión propia. Como la norma es de pago, la cita se ajusta a su resumen oficial en iso.org (leído en la copia de Internet Archive del 18 de octubre de 2026): establece los colores de seguridad para prevenir accidentes, proteger contra incendios, informar riesgos para la salud y evacuar. Sale «[ISO]», porque el grupo autor aparece una sola vez en la memoria y APA no abrevia lo que no se repite.

**17. Capítulo 12, «Del prototipo al producto» — Gembali (2023). Fondo.**

- Antes: «siempre que respondan a la orden estándar de alerta: es un camino que no obliga a fabricar electrónica, aunque depende de modelos que varían entre fabricantes (Gembali, 2023, p. 53).»
- Después: «siempre que respondan a la orden estándar de alerta. Aprovechar un dispositivo que ya existe evita desarrollar y fabricar electrónica, aunque puede no ofrecer justo las funciones que se necesitan (Gembali, 2023, p. 53).»
- Motivo: La tesis no habla de localizadores de otras marcas ni de una orden estándar de alerta, que quedan como propuesta del proyecto, sin cita. Lo que sí dice, en la p. 53: comprar un dispositivo que ya existe y venderlo con marca propia evita invertir en desarrollarlo y fabricarlo, aunque puede no tener justo las funciones que se necesitan.

**18. Referencias — Kleinberg et al. (2024). Forma.**

- Antes: «Kleinberg, J., Mullainathan, S. y Raghavan, M. (2023). The challenge of understanding what users want: Inconsistent preferences and engagement optimization. *Management Science*. Publicación anticipada en línea. https://doi.org/10.1287/mnsc.2022.03683»
- Después: «Kleinberg, J., Mullainathan, S. y Raghavan, M. (2024). The challenge of understanding what users want: Inconsistent preferences and engagement optimization. *Management Science, 70*(9), 6336–6355. https://doi.org/10.1287/mnsc.2022.03683»
- Motivo: El artículo dejó de ser publicación anticipada; está en el volumen 70, número 9 (septiembre de 2024), págs. 6336–6355, según INFORMS y RePEc. Mismo orden alfabético. Va junto con el cambio 1.

**19. Referencias — Ullmer et al. (2022). Decisión del autor.**

- Antes: «Ullmer, B., Shaer, O., Mazalek, A. y Hummels, C. (2022). *Weaving fire into form: Aspirations for tangible and embodied interaction*. Association for Computing Machinery. https://doi.org/10.1145/3544564»
- Después: se elimina.
- Motivo: Sale la referencia, con su línea en blanco, porque su única cita sale con el cambio 9.

**20. Glosario, «Interacción tangible» — Ishii y Ullmer (1997). Fondo.**

- Antes: «Abarca sistemas basados en la interacción corporal, la manipulación de objetos, la representación física de datos y su inserción en el espacio real (Ishii y Ullmer, 1997).»
- Después: «En su formulación inicial, une esa información a objetos que se pueden tomar y a superficies del espacio, y usa medios del ambiente, como la luz y el sonido, para informar en segundo plano (Ishii y Ullmer, 1997).»
- Motivo: El artículo de 1997 no habla de interacción corporal; esa enumeración corresponde a definiciones posteriores del campo. Su resumen (p. 234, versión oficial de las actas de CHI 97 en acm.org) propone tomar y manipular la información unida a objetos cotidianos y a superficies del espacio, y percibirla en segundo plano con medios del ambiente como la luz, el sonido, el aire o el agua. Coincide con lo que dice el capítulo 6.

**21. Glosario, «Marco multiproceso» — McDaniel y Einstein (2000). Fondo.**

- Antes: «Cuando la actividad en curso absorbe la atención, lo segundo es más probable si la señal es llamativa y está fuertemente asociada a la acción (McDaniel y Einstein, 2000).»
- Después: «Que ocurra lo segundo depende de la señal, de la actividad en curso y de la persona (McDaniel y Einstein, 2000).»
- Motivo: Que la señal sea «llamativa» y esté «fuertemente asociada» no está en el resumen (p. S127), que es lo que se pudo leer. Ajustada al resumen: que la intención vuelva sola depende de la tarea, la señal, la actividad en curso y la persona. Se usan los mismos tres factores que los capítulos 3, 6 y 10.

## Lo que queda sin cambios

- **Edworthy et al. (1991), Hellier et al. (1993) y Middlebrooks y Green (1991),** en «Señal» (capítulo 11): se dejan como están, según la decisión del autor. Sus resúmenes oficiales dicen que la altura, la estructura melódica y las repeticiones influyen en la urgencia percibida, y que el oído estima la altura de un sonido por la forma de su espectro, pero no dicen en qué sentido actúa cada rasgo.
- **Elliot y Maier (2014):** se deja. Su resumen pide estudiar las condiciones límite y los moderadores, y Jonauskaite et al. (2024) respalda las diferencias entre personas.
- **Coinciden con la fuente:** Fogg (2009), Sheeran y Webb (2016), Covington et al. (2016), Kleinberg et al. (salvo el año, cambios 1 y 18), Sohn et al. (2005), Radtke et al. (2022), Goldsmith (2021) y las demás citas de McDaniel y Einstein (2000), Guynn et al. (1998), Waggoner et al. (2026) y O’Rear y Radvansky (2019).
- La memoria no menciona la falsabilidad, la autorización de las fotos ni qué fuentes se leyeron completas.

## Revisión APA 7

**Qué se revisó:** cada cita en el texto, en tablas, en notas de figuras y en el glosario, contra la lista de referencias y al revés; el orden alfabético; «y» entre autores; «et al.» desde tres autores; «s. f.» con letras; los años con letra; «p.» y «pp.»; las cursivas de títulos, revistas y volúmenes; los DOI como https://doi.org/…; «Recuperado el … de» solo en páginas sin fecha; la comunicación personal de D. Parra, que va solo en el texto; las mayúsculas tipo oración; las leyes y la norma.

**Qué se encontró:**

- Kleinberg et al. ya no es publicación anticipada: está en *Management Science, 70*(9), 6336–6355, de 2024 (cambios 1 y 18). El informe previo la daba por buena porque Crossref no lo ha actualizado.
- Dos primeros autores con el mismo apellido, E. B.-N. Sanders y S. Sanders, llevan iniciales en el texto (cambios 11 a 13).
- «[ISO]» sobraba, porque la norma se cita una sola vez (cambio 16).
- Todo lo demás está bien: orden, autores, fechas, letras, páginas, cursivas, DOI y fechas de consulta. Las leyes llevan su título oficial y su fecha de publicación, con el número sin punto, como en la Biblioteca del Congreso Nacional; la norma lleva su tipo y su número.

**Datos comprobados hoy:**

- **En Crossref:** Ball et al. (2025), Sheeran y Webb (2016), Covington et al. (2016), Fogg (2009), Guynn et al. (1998), Waggoner et al. (2026) y O’Rear y Radvansky (2019) coinciden con sus referencias. Kleinberg et al. se comprobó además en INFORMS y RePEc.
- **En las páginas oficiales:** Fondart Nacional, línea de Investigación (hasta 15 millones de pesos por proyecto de diseño; cerró el 14 y el 16 de septiembre de 2026); Semilla Inicia de Corfo (hasta 15 millones y el 75 % del proyecto; personas mayores de 18 años con residencia en Chile; validación técnica y comercial), y Capital Semilla Emprende de Sercotec (3,5 millones; aporte propio del 3 %; sin inicio de actividades). Coinciden con lo que dice la memoria.
- **Lucide Contributors (s. f.):** la página se titula «Lucide design language», no tiene fecha y su sitio es Lucide; la referencia está bien.
- **Ullmer et al. (2022)** sale de la memoria (cambios 9 y 19).

## Qué no se pudo verificar

- **Textos completos:** de McDaniel y Einstein (2000), Miller et al. (2007), O’Rear y Radvansky (2019), Edworthy et al. (1991), Hellier et al. (1993), Elliot y Maier (2014), Middlebrooks y Green (1991) y la norma ISO 3864-1 solo se leyó el resumen oficial; de O’Rear y Radvansky, también la tesis de Kalchik.
- **Páginas de libros:** Kolko (2011, p. 40), Nielsen (1993) y Sanders y Stappers (2012, p. 69) se comprobaron en copias del autor de origen no autorizado; conviene confirmarlas en un ejemplar de la biblioteca.
- **Glosario, «Descarga de intenciones»:** no se comprobó que el ejemplo del objeto junto a la puerta sea de Risko y Gilbert (2016), porque el repositorio de UCL bloquea las herramientas automáticas.
- **Kleinberg et al.:** la página de INFORMS se leyó en su copia de Internet Archive, porque el sitio bloquea las herramientas automáticas.

## Pendiente fuera de la memoria

- **Figura 2:** el autor, que dibuja las figuras, debe usar la redacción del cambio 7.
- **Documentos por actualizar:** el [registro de pedidos a la IA](../../00_gobernanza/registro-de-pedidos-a-la-ia.md), el [manifiesto](manifiesto.json) y el [README](README.md) de las fuentes, con la tesis de Kalchik y las copias nuevas de Fogg, Guynn y Waggoner, y el [informe de fuentes gratuitas](fuentes-gratuitas-2026-11-10.md), que daba por buena la referencia de Kleinberg et al. No se tocaron en esta tarea.

## Registro de cambios (disclaimer)

### 2026-11-10 — Creación

- **Qué cambió:** se creó este documento y su versión para aplicar en JSON, con 21 cambios a la memoria v6 que salen de los cuatro PDF nuevos, del informe de fuentes gratuitas y de una revisión APA 7 de toda la memoria.
- **Cómo estaba antes:** las correcciones eran propuestas del informe de fuentes gratuitas, sin redactar para aplicarlas; Fogg, Guynn y Waggoner no tenían su página verificada en la versión publicada, la tesis de Kalchik no se había leído y la referencia de Kleinberg et al. seguía como publicación anticipada.
- **Por qué:** el autor pidió dejar la memoria final limpia y ordenada, con cada cita respaldada por su fuente y en APA 7.
