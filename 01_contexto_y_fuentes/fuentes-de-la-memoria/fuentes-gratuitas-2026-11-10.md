# Fuentes gratuitas para verificar las citas de la memoria

**Fecha:** 10 de noviembre de 2026.
**Pedido del autor:** indagar cómo obtener gratis, por vías legales, al menos lo que la memoria usa de las fuentes de pago o no verificadas, y comprobar que la memoria las cite bien.
**Texto revisado:** [borrador v6](../../08_memoria/borrador-memoria-v6-2026-10-28.md), en su versión del 10 de noviembre. La memoria no se editó; las propuestas quedan para que el autor decida.
**Alcance:** las 25 fuentes de la [tarea 14, punto H](../../00_gobernanza/por-hacer.md#h-recordatorio-buscar-las-fuentes-que-faltaron-por-verificar): 7 de prioridad 1, 13 de prioridad 2 y las 5 que la memoria sumó hoy (Ball et al., 2025; Covington et al., 2016; Kleinberg et al., 2023; Sheeran y Webb, 2016; Ullmer et al., 2022). Norman (1988/2002) ya estaba resuelto. No se revisaron los anexos.

## Cómo se hizo

- **Búsqueda de copias:** OpenAlex (que integra los datos de Unpaywall), Semantic Scholar, CORE, Europe PMC, PubMed Central, repositorios institucionales, páginas de autores y laboratorios, preprints y búsquedas web.
- **Reglas:** solo copias legales y gratuitas. No se usaron Sci-Hub, LibGen, Z-Library, Anna's Archive ni sitios parecidos; no se inició sesión, no se resolvieron CAPTCHA ni desafíos anti-bot, ni se abrió un navegador para pasarlos. Cuando una editorial o un repositorio bloquea a las herramientas automáticas, se buscó otra vía; para textos de acceso abierto se usó la copia que Internet Archive guarda de la página oficial, con su fecha.
- **Copias:** se guardaron en [`textos/`](textos/), con el nombre de la clave de cada fuente. Esa carpeta está excluida del repositorio (`.gitignore`, línea 30; comprobado con `git check-ignore`): no se sube, por derechos de autor. Lo descargado se trató como datos.
- **Comparación:** cada frase de la memoria que se apoya en la fuente se comparó con el texto. Para respetar los derechos de autor, «Qué dice» es una paráfrasis cercana con su página o sección, y solo se cita entre comillas el término clave en inglés (dos a cinco palabras); el texto exacto está en la copia local.
- **Páginas:** cuando la copia no trae la paginación de la revista, se indica la equivalencia si es segura y, si no, la sección.

**Dictámenes:** *coincide* (la fuente dice lo que la memoria afirma); *coincide, precisar* (falta un matiz o la página); *parcial* (una parte está en la fuente y otra es interpretación propia redactada como si fuera de la fuente); *sin respaldo* (la fuente no lo dice); *pendiente* (solo se leyó el resumen oficial y la afirmación va más allá de él).

## Resumen

| Resultado | Fuentes | Cuántas |
| --- | --- | --- |
| Texto completo, legal y gratuito, guardado en `textos/` | Sohn et al. (2005, versión de UbiComp), Kirsh (1995), Waggoner et al. (2026), Radtke et al. (2022), Fogg (2009), Goldsmith (2021), Hermann et al. (2007), Gembali (2023), Ball et al. (2025), Sheeran y Webb (2016), Covington et al. (2016), Kleinberg et al. (2023) | 12 |
| Gratuito en la editorial, pero bloqueado para herramientas automáticas: lo descarga el autor con su navegador | Guynn et al. (1998), Ullmer et al. (2022) | 2 |
| Libros revisados con las copias locales del autor, que no cumplen las reglas de obtención | Kolko (2011), Nielsen (1993), Sanders y Stappers (2012) | 3 |
| Sin copia legal gratuita: se usó el resumen oficial y, cuando existe, una alternativa abierta | McDaniel y Einstein (2000), O'Rear y Radvansky (2019), Miller et al. (2007), Edworthy et al. (1991), Hellier et al. (1993), Elliot y Maier (2014), Middlebrooks y Green (1991), ISO 3864-1 (2011) | 8 |
| **Total** | | **25** |

Se revisaron 52 citas o afirmaciones: 36 coinciden (5 de ellas conviene precisarlas, y 13 se contrastaron solo con el resumen oficial o con una alternativa abierta), 11 son parciales, 2 no tienen respaldo en lo leído y 3 quedan pendientes de un texto completo. Ninguna fuente resultó inexistente ni con datos inventados.

### Citas que conviene corregir

1. **Capítulo 5, «Recordatorios, lugares y objetos» (línea 182), Ball et al. (2025):** «una alarma mejoró el cumplimiento de intenciones». En el estudio, el recordatorio era una lista visible en la pantalla, no una alarma.
2. **Capítulo 5 (línea 184), O'Rear y Radvansky (2019):** «probaron si el lugar basta como recordatorio». El estudio explora si el lugar sirve como recordatorio; no prueba que baste.
3. **Capítulo 5 (línea 190), Hermann et al. (2007):** «un objeto cotidiano que cambiaba de color». El objeto se dejaba en una bandeja, y era la bandeja la que se iluminaba.
4. **Capítulo 6, «Recordar con objetos y lugares» (línea 240), Kirsh (1995):** el ejemplo de dejar algo junto a la puerta es de Kirsh (p. 38) y aparece como propio; «sin que haya que pensar en ella» no está en la fuente.
5. **Capítulo 6 (línea 250), Ullmer et al. (2022):** «que suma el cuerpo a los objetos y al espacio» es una glosa propia; la fuente habla de interacción tangible, corporizada y situada.
6. **Capítulo 6 (línea 254), Waggoner et al. (2026):** *phygital* nombra experiencias que se mueven entre lo físico y lo digital, no un sistema «que reparte su trabajo».
7. **Capítulo 9 (línea 380), Kolko (2011, p. 40):** la síntesis no convierte lo aprendido en una oportunidad; traduce la oportunidad en criterios de diseño.
8. **Capítulo 11, «Decisión abierta» (línea 504), Miller et al. (2007):** «y ofrecer una opción real ayuda más que insistir» queda pegado a la cita de Miller y se lee como suyo.
9. **Capítulo 11, «Paleta cromática» (línea 598), ISO (2011):** la convención de la señalética reserva el rojo para la prohibición y el peligro; no dice nada del negro ni del gris.
10. **Capítulo 12, «Del prototipo al producto» (línea 693), Gembali (2023, p. 53):** la tesis habla de revender dispositivos que ya existen, no de localizadores de otras marcas ni de una orden estándar de alerta.
11. **Glosario, «Marco multiproceso» (línea 1079), McDaniel y Einstein (2000):** «si la señal es llamativa y está fuertemente asociada a la acción» no está en el resumen; una revisión abierta de los mismos autores sostiene una versión distinta.

Además, fuera de las 25 fuentes: el **Glosario, «Interacción tangible» (línea 1073)** atribuye a Ishii y Ullmer (1997) que el campo «abarca sistemas basados en la interacción corporal… y la representación física de datos»; el artículo de 1997 no habla de interacción corporal. Conviene revisarlo con Ullmer et al. (2022).

### Citas pendientes de un texto completo

Edworthy et al. (1991) y Hellier et al. (1993): el sentido de cada efecto sobre la urgencia (sonido que baja, menos repeticiones). Middlebrooks y Green (1991): que muchas frecuencias a la vez ayuden a ubicar el sonido. Elliot y Maier (2014): que las asociaciones cambien según el contexto. ISO 3864-1: la tabla de colores de la propia norma. Guynn et al. (1998) y Ullmer et al. (2022): la página.

## Detalle por fuente

### Prioridad 1

#### 1. McDaniel y Einstein (2000)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Sin copia legal gratuita.** Wiley la vende; OpenAlex, Unpaywall y Semantic Scholar la marcan cerrada; CORE solo tiene los datos. La copia de CiteSeerX que lista OpenAlex ya no existe: el servicio redirige a Internet Archive, que no la guardó. No hay copia en las páginas de los autores. |
| Cómo conseguirla | Biblioteca UDP (Wiley Online Library, si está suscrita), préstamo interbibliotecario, o pedir el PDF a Mark A. McDaniel (Washington University in St. Louis). |
| Versión leída | Resumen oficial de la editorial (vía OpenAlex), p. S127. |
| URL | https://doi.org/10.1002/acp.775 |
| Alternativa abierta | McDaniel, M. A., Umanath, S., Einstein, G. O. y Waldum, E. R. (2015). Dual pathways to prospective remembering. *Frontiers in Human Neuroscience, 9*, Artículo 392. https://doi.org/10.3389/fnhum.2015.00392 (CC BY; mismos autores; texto de Europe PMC, PMC4500919). |
| Copia local | `textos/mcdaniel-einstein-2000-alternativa-abierta-mcdaniel-2015.xml` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 2 (l. 118): «La memoria prospectiva es la capacidad de recordar una acción que se quiere realizar cuando llega la ocasión de hacerla». | Coincide | Resumen, p. S127: formar intenciones y realizarlas en un momento apropiado del futuro. | — |
| Cap. 3, «Atención ocupada» (l. 146): «la persona puede vigilar si llegó el momento, o algo del entorno puede traerla de vuelta, y que ocurra lo segundo depende de la señal, de la actividad en curso y de la persona». | Coincide, precisar | Resumen: el peso de los procesos automáticos varía según cuatro factores: la tarea de memoria prospectiva, la señal («*target cue*»), la actividad en curso y la persona. | Opcional: «depende de la tarea, de la señal, de la actividad en curso y de la persona». |
| Cap. 6 (l. 218): «nadie pide explícitamente recordar». | Coincide | Resumen: el recuerdo ocurre «*without an explicit request*» para intentarlo. | — |
| Cap. 6 (l. 220): vigilar el entorno o un evento que trae la intención de vuelta; depende de la señal, la actividad y la persona. | Coincide | Resumen: vigilar estratégicamente o dejar que las condiciones del entorno reinstalen la acción de forma más o menos automática. | — |
| Figura 2 (l. 226): «Exige atención constante, Falla si otra actividad la absorbe» y «Funciona aunque la atención esté en otra parte». | Parcial | El resumen dice que vigilar consume recursos, no que «falle», ni que el otro camino funcione siempre. McDaniel et al. (2015) muestran que la vigilancia cuesta sostenerla y que la recuperación espontánea puede bastar cuando la actividad en curso lleva a procesar la señal («*focal processing*»). | «Exige vigilar; cuesta sostenerlo si otra actividad absorbe la atención» y «Puede funcionar sin vigilar, si la señal se nota en la actividad en curso». |
| Cap. 10, «Hipótesis y objetivos» (l. 430): «una intención puede volver sin esfuerzo cuando algo del entorno la trae de vuelta, y que ocurra depende de la señal, de la actividad en curso y de la persona». | Coincide | «Sin esfuerzo» corresponde a los procesos relativamente automáticos, opuestos a la vigilancia que demanda recursos. | — |
| Cap. 11, «Justificación del objeto» (l. 502): «algo del entorno puede traer de vuelta una intención». | Coincide | Igual que lo anterior. | — |
| Glosario, «Marco multiproceso» (l. 1079), segunda oración: «Cuando la actividad en curso absorbe la atención, lo segundo es más probable si la señal es llamativa y está fuertemente asociada a la acción». | Sin respaldo en el resumen | El resumen no lo dice. La revisión abierta de 2015 sostiene algo cercano, pero no igual: la recuperación espontánea es probable si la señal quedó bien asociada a la acción y la actividad en curso lleva a procesarla como se procesó al formar la intención. «Llamativa» no aparece. | **A**, sin sumar referencias: «Que ocurra lo segundo depende de la tarea, de la señal, de la actividad en curso y de la persona (McDaniel y Einstein, 2000)». **B**, sumando McDaniel et al. (2015) a las referencias: «Lo segundo es más probable cuando la señal quedó bien asociada a la acción y la actividad en curso lleva a fijarse en ella (McDaniel et al., 2015)». |

#### 2. Kirsh (1995)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida.** (a) Versión HTML del autor en el sitio de su laboratorio en UC San Diego; su nota dice que la revista la publicó «levemente revisada». (b) Escaneo de la versión publicada (págs. 31–68) archivado en PhilPapers; PhilPapers bloquea las herramientas automáticas (403) y se usó la copia de Internet Archive del 5 de septiembre de 2024. Elsevier también la ofrece gratis en ScienceDirect (acceso *bronze*), con el mismo bloqueo. El escaneo no tiene texto: se leyó con el OCR de macOS. |
| Versión | Publicada (escaneo) y del autor (HTML). |
| URL | (a) https://interactivity.ucsd.edu/articles/Space/AIJ1.html · (b) https://web.archive.org/web/20240905211131/https://philpapers.org/archive/kirtiu.pdf · editorial: https://www.sciencedirect.com/science/article/pii/000437029400017U/pdf |
| Copia local | `textos/kirsh-1995.pdf` (escaneo) y `textos/kirsh-1995.html` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 6 (l. 240): «la disposición de los objetos puede simplificar la elección, la percepción y el cálculo mental». | Coincide, precisar | p. 31 (resumen) y p. 35: tres categorías de disposiciones del espacio: las que simplifican la elección, la percepción y el cálculo interno («*internal computation*»). | Añadir la página: (Kirsh, 1995, p. 31). |
| Cap. 6 (l. 240): «Dejar algo junto a la puerta para no olvidar llevarlo es un ejemplo cotidiano: el lugar recuerda la intención sin que haya que pensar en ella». | Parcial | p. 38: el ejemplo es de Kirsh: dejar un rollo de película junto a la puerta para no salir sin llevarlo a revelar. Agrega que los recordatorios suelen valerse de algo que llama la atención —un color o un sonido inesperado, o estar en el lugar justo— y, en nota, que son una estrategia de la memoria prospectiva. «Sin que haya que pensar en ella» no está: el recordatorio capta la atención en el momento. | «Kirsh (1995, p. 38) da un ejemplo cotidiano: dejar un rollo de película junto a la puerta para no salir sin llevarlo a revelar. Esos recordatorios sirven porque llaman la atención en el momento oportuno, por ejemplo con un sonido inesperado o por estar en el lugar indicado.» |
| Cap. 10 (l. 430): «el lugar donde debe hacerse una acción puede ofrecer esa señal (Kirsh, 1995; …)». | Coincide | p. 38 (estar en el lugar justo como rasgo que hace recordar) y p. 66, Tabla 1: los recordatorios reducen la probabilidad de error de la memoria prospectiva. | Opcional: (Kirsh, 1995, p. 38). |

Con esto se cierra el pendiente de la verificación de los capítulos 1 a 6: el ejemplo existe, está en la p. 38, y la frase ya no está incompleta.

#### 3. O'Rear y Radvansky (2019)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Sin copia legal gratuita.** SAGE; cerrada según OpenAlex, Semantic Scholar y CORE. Pariente abierta: la tesis de maestría *Location-Based Prospective Memory* (Andrea E. Kalchik, Universidad de Notre Dame, 2016), dirigida por Radvansky, con el mismo título y el mismo centro comercial virtual; parece el origen del artículo, pero es otra obra y no reemplaza la cita. Su descarga respondió 403 a la consulta automática. |
| Cómo conseguirla | Biblioteca UDP (SAGE Journals) o pedirla a Gabriel A. Radvansky (Notre Dame). La tesis se abre en el navegador. |
| Versión leída | Resumen de PubMed (PMID 29364055). |
| URL | https://doi.org/10.1177/1747021818758608 · tesis: https://curate.nd.edu/articles/thesis/Location-Based_Prospective_Memory/24814542 |
| Copia local | Ninguna. |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 5 (l. 184): «probaron si el lugar basta como recordatorio». | Parcial | Resumen: el estudio explora la memoria prospectiva basada en el lugar. No prueba que el lugar «baste». | «estudiaron si el lugar sirve como recordatorio». |
| Cap. 5 (l. 184): centro comercial virtual, mensajes entre tiendas, encargos al llegar a cierta tienda. | Coincide | Resumen: como tarea en curso, las personas llevaban mensajes de tienda en tienda; los encargos eran hacer ciertas cosas en ciertas tiendas. | — |
| Cap. 5 (l. 184): «Las señales del lugar favorecieron el recuerdo, y el desempeño no cambió según cuánto rato hubiera pasado». | Coincide, precisar | Resumen: en el experimento 1, las señales del lugar fueron eficaces y el desempeño no varió con la demora (tres demoras). | «En el primer experimento, las señales del lugar…» |
| Cap. 6 (l. 220): «evalúan intenciones que se recuperan al estar en el sitio, no un sonido que llega desde él». | Coincide | Resumen. La hipótesis siguiente ya se presenta como del proyecto. | — |
| Cap. 9, criterio 8 (l. 410); cap. 10 (l. 430); cap. 11 (l. 502): el lugar puede ayudar a recordar o ser la señal. | Coincide | Resumen. Matiz: el lugar era virtual. | Opcional: «en un entorno virtual». |

#### 4. Sohn et al. (2005), versión de UbiComp 2005

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida.** PDF de los autores en Microsoft Research, donde trabaja el coautor James Scott: 19 páginas creadas el 20 de junio de 2005, que corresponden a las págs. 232–250 del libro. La copia anterior era el informe técnico de marzo. |
| Versión | Versión final de los autores para UbiComp 2005 (sin el número de página impreso). |
| URL | https://www.microsoft.com/en-us/research/wp-content/uploads/2016/02/ubicomp2005-placeits.pdf (ficha: https://www.microsoft.com/en-us/research/publication/place-its-a-study-of-location-based-reminders-on-mobile-phones/) |
| Copia local | `textos/sohn-2005.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 5 (l. 186): una aplicación para dejar una nota «colgada» de un lugar, que aparece al llegar o al irse. | Coincide | p. 241: recordatorios de llegada (67) y de salida (22). | — |
| Cap. 5 (l. 186): «Diez personas la usaron durante dos semanas y crearon 89 recordatorios». | Coincide | p. 239: estudio exploratorio con diez participantes durante dos semanas; p. 241: 89 recordatorios en total. | Opcional: (Sohn et al., 2005, pp. 239–241). |
| Cap. 5 (l. 186): «Hubo que volver a colgar diecinueve, porque saltaron en el lugar equivocado o en el correcto pero en un momento en que no se podían atender». | Coincide | p. 241: 19 recordatorios (21 %) se volvieron a colgar, 63 veces en total, porque saltaron en el lugar equivocado o en el correcto pero cuando no podían atenderse. | Opcional: «Diecinueve se volvieron a colgar», porque lo decidieron las personas. |

Las cifras de la versión publicada coinciden con las del informe técnico. Las páginas se dedujeron de la equivalencia de 19 páginas con las págs. 232–250; conviene confirmarlas en el libro si se citan.

#### 5. Waggoner et al. (2026)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida**, versión publicada (CC BY). Springer la ofrece gratis, pero responde a las herramientas automáticas con un desafío; se usó la copia de Internet Archive de la página del artículo, del 11 de diciembre de 2025. La versión aceptada está en HARVEST (Universidad de Saskatchewan), que no respondió. |
| Versión | Publicada, en HTML: sin páginas; se cita por sección. |
| URL | https://web.archive.org/web/20251211001653/https://link.springer.com/article/10.1007/s00799-025-00436-6 · PDF para el navegador del autor: https://link.springer.com/content/pdf/10.1007/s00799-025-00436-6.pdf · aceptada: https://harvest.usask.ca/handle/10388/17847 |
| Copia local | `textos/waggoner-2026.html` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Glosario, *Phygital* (l. 1089): término formado por *physical* y *digital* que designa experiencias que integran lo físico y lo digital. | Coincide | Sección 2, «"Phygital" user experiences»: es una combinación («*portmanteau*») de *physical* y *digital* y describe experiencias en que el recorrido del usuario atraviesa espacios físicos y digitales. | Opcional: (Waggoner et al., 2026, sección 2). |
| Cap. 6 (l. 254): «A un sistema así, que reparte su trabajo entre lo físico y lo digital, se le llama *phygital*». | Parcial | Los autores usan el término para experiencias de usuario que se mueven entre espacios físicos y digitales, no para sistemas que reparten su trabajo. | «A una experiencia que se mueve entre lo físico y lo digital se le llama *phygital* (Waggoner et al., 2026); en esta memoria, el término nombra un sistema que la produce.» |

La cita del capítulo 4 que la verificación del 2 de noviembre marcó sin respaldo ya no está en la v6.

#### 6. Radtke et al. (2022)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida**, versión publicada (CC BY). SAGE, ZORA (Universidad de Zúrich), Refubium (Universidad Libre de Berlín) y CORE bloquean las herramientas automáticas; se usó la copia de Internet Archive del PDF de SAGE, del 9 de diciembre de 2023. |
| Versión | Publicada, págs. 190–215. |
| URL | https://web.archive.org/web/20231209191435/https://journals.sagepub.com/doi/pdf/10.1177/20501579211028647 · aceptada: https://www.zora.uzh.ch/id/eprint/216712/1/20501579211028647.pdf |
| Copia local | `textos/radtke-2022.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 5 (l. 172): «revisaron intervenciones de desconexión digital y encontraron resultados positivos, nulos y negativos». | Coincide | p. 191: 21 estudios con 3625 participantes; algunos hallaron efectos positivos y otros ninguno o incluso negativos en el bienestar. | Opcional: «21 estudios con 3625 participantes» y la página. |
| Cap. 5 (l. 172): «reducir el uso no basta como criterio». | Coincide (inferencia propia, bien presentada) | p. 191: los autores hablan de resultados mixtos («*mixed findings*») y piden estudiar los mecanismos. | — |

#### 7. Guynn et al. (1998)

| Aspecto | Dato |
| --- | --- |
| Obtención | **No descargada.** Springer la ofrece gratis (acceso *bronze* según OpenAlex y Semantic Scholar), pero responde con un desafío a las herramientas automáticas, y la copia de Internet Archive (2018) solo guarda el resumen. |
| Cómo conseguirla | El autor la descarga con su navegador desde la URL y la guarda como `textos/guynn-1998.pdf`. |
| Versión leída | Resumen de PubMed (PMID 9584436). |
| URL | https://link.springer.com/content/pdf/10.3758/BF03201140.pdf |
| Copia local | Ninguna. |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 6 (l. 220): «Los recordatorios más eficaces aludían a la vez a la ocasión y a la acción prevista, y los que solo anunciaban la ocasión no mejoraban el recuerdo». | Coincide (resumen) | Resumen: los más eficaces mencionaban el evento señal y la actividad; los que solo mencionaban el evento no mejoraron frente a no recordar nada. Los que solo mencionaban la actividad mejoraron algo, menos que los completos. | Opcional: sumar el matiz de los que solo aludían a la acción. Falta la página. |

### Prioridad 2

#### 8. Fogg (2009)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida.** La copia local del autor es el PDF final de B. J. Fogg (título interno «BehaviorModelp09v8f-withNameandCnote», 4 de abril de 2009, 7 págs.), con la nota de derechos de ACM. La versión publicada es gratuita desde el 1 de enero de 2026, cuando la ACM Digital Library pasó a acceso abierto, pero bloquea las herramientas automáticas (403). |
| Versión | Final de los autores, igual a la publicada en su paginación (Artículo 40, págs. 1–7). |
| URL | https://dl.acm.org/doi/pdf/10.1145/1541948.1541999 |
| Copia local | `textos/fogg-2009.pdf` (copiada de la carpeta del autor) |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 13 (l. 772): «una señal lleva a actuar solo si coincide con la motivación y la capacidad del momento (Fogg, 2009, p. 1)». | Coincide | p. 1: motivación suficiente, capacidad y un desencadenante («*trigger*») deben darse en el mismo instante. p. 3: si la persona está bajo el umbral de activación, el desencadenante no lleva a la conducta. | — |
| Cap. 13 (l. 772): «Relevo actúa sobre la facilidad… y no sobre la motivación». | Coincide | p. 4: el diseño persuasivo puede aumentar la motivación, aumentar la capacidad («*simplicity*») o desencadenar la conducta. | — |
| Figura 24, nota (l. 780): «Elaboración propia a partir de Fogg (2009)». | Coincide, precisar | Fogg representa motivación y capacidad en dos ejes, con un umbral curvo (págs. 2–3); la matriz de dos por dos es una simplificación propia. | Opcional: «Elaboración propia, simplificada, a partir de Fogg (2009, pp. 2–3)». |

#### 9. Goldsmith (2021)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida**, versión publicada (CC BY-NC-SA). NSUWorks responde con un desafío; se usó la copia de Internet Archive del 31 de octubre de 2026. |
| Versión | Publicada, págs. 2061–2076; la primera hoja es la portada de NSUWorks. |
| URL | https://web.archive.org/web/20261031084238/https://nsuworks.nova.edu/cgi/viewcontent.cgi?context=tqr&article=5011 |
| Copia local | `textos/goldsmith-2021.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 7 (l. 270): «el método Framework, que ordena lo dicho en una matriz de personas y temas para compararlas entre sí». | Coincide | p. 2062: lo propio del método es indexar todos los datos, ordenarlos en una matriz y compararlos dentro de ella. p. 2068: la matriz tiene filas y columnas con las unidades de análisis y los componentes del marco. | Opcional: (Goldsmith, 2021, pp. 2062, 2068). |

#### 10. Hermann et al. (2007)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida.** Copia de los autores en el sitio del Instituto de Informática de Medios de la Universidad de Ulm. El tercer autor es Guido de Melo: «de Melo, G.» está bien. |
| Versión | De los autores (LaTeX, 26 de septiembre de 2007, 8 págs., equivalentes a las págs. 144–151 de las actas). |
| URL | https://www.uni-ulm.de/fileadmin/website_uni_ulm/iui.inst.100/institut/Papers/TTR_ie07.pdf |
| Copia local | `textos/hermann-2007.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 5 (l. 190): «mostraba cada compromiso en un objeto cotidiano que cambiaba de color al acercarse el plazo». | Parcial | págs. 144 y 146: cada compromiso se asocia a un objeto cotidiano que se deja en una bandeja; la pantalla detrás del objeto muestra un color según la cercanía del plazo (verde al comienzo) y parpadea al llegar. El objeto no cambia de color. | «asociaba cada compromiso a un objeto cotidiano, que se dejaba en una bandeja; la bandeja se iluminaba con un color según la cercanía del plazo y parpadeaba cuando llegaba (Hermann et al., 2007).» |
| Cap. 5 (l. 190): «servía a citas o tomas de medicamentos». | Coincide | págs. 145–146: citas y ejemplos con medicamentos, como una persona mayor con su pastillero. | — |
| Cap. 5 (l. 190): «no a intenciones que la persona puede decidir no realizar». | Coincide (interpretación propia, bien presentada) | p. 146: el parpadeo busca que la persona actúe. | — |

Las páginas suponen que la copia de Ulm tiene la misma paginación que las actas.

#### 11. Miller et al. (2007)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Sin copia legal gratuita** (Wiley, para la International Communication Association). |
| Cómo conseguirla | Biblioteca UDP o pedirla a Claude H. Miller (Universidad de Oklahoma). |
| Versión leída | Resumen oficial (vía OpenAlex). |
| URL | https://doi.org/10.1111/j.1468-2958.2007.00297.x |
| Alternativa abierta | Steindl, C., Jonas, E., Sittenthaler, S., Traut-Mattausch, E. y Greenberg, J. (2015). Understanding psychological reactance: New developments and findings. *Zeitschrift für Psychologie, 223*(4), 205–214. https://doi.org/10.1027/2151-2604/a000222 (CC BY-NC; PMC4675534). Resume a Miller et al. (2007). |
| Copia local | `textos/miller-2007-alternativa-abierta-steindl-2015.xml` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 11, «Decisión abierta» (l. 504): «los mensajes que parecen ser una orden despiertan rechazo, y recordar que la decisión es de la persona lo reduce». | Coincide (resumen) | Resumen: el lenguaje controlador tuvo varios efectos negativos, y las posdatas que restituyen la libertad («*restoration postscripts*»), efectos más positivos. Steindl et al. (2015, sección sobre cómo reducir la reactancia): una posdata que dice que la persona es libre de decidir ayuda. | — |
| Cap. 11, «Decisión abierta» (l. 504): «y ofrecer una opción real ayuda más que insistir (criterio 4)». | Sin respaldo (se lee como de Miller) | Miller et al. no comparan ofrecer opciones con insistir. | «…lo reduce (Miller et al., 2007). Además, ofrecer una opción real ayuda más que insistir (criterio 4).» |
| Cap. 11, «Voz de Relevo» (l. 582): «evita el lenguaje de la obligación, como "debes" o "tienes que", que despierta rechazo». | Coincide | Steindl et al. (2015), citando a Miller et al. (2007): palabras como *should*, *ought*, *must* y *need* generan más reactancia que *can*, *could* o *may*. | — |

#### 12. Edworthy et al. (1991)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Sin copia legal gratuita** (SAGE, *Human Factors*). La copia de CiteSeerX que lista OpenAlex ya no existe. |
| Cómo conseguirla | Biblioteca UDP (SAGE Journals) o préstamo interbibliotecario. |
| Versión leída | Resumen de PubMed (PMID 1860703). |
| URL | https://doi.org/10.1177/001872089103300206 |
| Alternativa abierta | No se encontró una que diga en qué sentido actúa cada rasgo. La revisión de Edworthy (2013) en PubMed Central trata la urgencia en general, sin ese detalle. |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 11, «Señal» (l. 632): «un sonido que desciende y es más grave se percibe menos urgente». | Pendiente | Resumen: la frecuencia fundamental, el rango de altura y la estructura melódica influyen de forma clara en la urgencia percibida; no dice en qué sentido. | Mantener hasta leer los experimentos de altura y contorno. Si no se consigue: «la altura y la forma melódica de un sonido cambian la urgencia que transmite (Edworthy et al., 1991)». |

#### 13. Hellier et al. (1993)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Sin copia legal gratuita** (SAGE, *Human Factors*). |
| Cómo conseguirla | Biblioteca UDP (SAGE Journals) o préstamo interbibliotecario. |
| Versión leída | Resumen de PubMed (PMID 8163282). |
| URL | https://doi.org/10.1177/001872089303500408 |
| Alternativa abierta | No se encontró. |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 11, «Señal» (l. 632): «menos repeticiones bajan la urgencia». | Pendiente | Resumen: las unidades de repetición están entre los cuatro parámetros cuya relación con la urgencia se midió; no dice el sentido. | Mantener hasta leer los resultados. Si no se consigue: «el número de repeticiones cambia la urgencia percibida (Hellier et al., 1993)». |

#### 14. Elliot y Maier (2014)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Sin copia legal gratuita** (Annual Reviews). |
| Cómo conseguirla | Biblioteca UDP o préstamo interbibliotecario. |
| Versión leída | Resumen de PubMed (PMID 23808916). |
| URL | https://doi.org/10.1146/annurev-psych-010213-115035 |
| Alternativa abierta | Elliot, A. J. (2015). Color and psychological functioning: A review of theoretical and empirical work. *Frontiers in Psychology, 6*, Artículo 368. https://doi.org/10.3389/fpsyg.2015.00368 (CC BY; PMC4383146). |
| Copia local | `textos/elliot-maier-2014-alternativa-abierta-elliot-2015.xml` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 11, «Paleta cromática» (l. 598): «Las asociaciones entre colores y emociones cambian según el contexto y la persona». | Parcial en el resumen; coincide en la alternativa | Resumen de 2014: el color puede influir en el afecto, la cognición y la conducta, y faltan estudios sobre condiciones límite y moderadores. Elliot (2015, sección sobre la teoría del color en contexto): el contexto físico y psicológico cambia el significado de un color; el azul es positivo en una cinta de premio y negativo en un trozo de carne. | Mantener. Para tener un respaldo leído: «(Elliot, 2015; Elliot y Maier, 2014; Jonauskaite et al., 2024)», sumando Elliot (2015) a las referencias. |

#### 15. Middlebrooks y Green (1991)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Sin copia legal gratuita** (Annual Reviews). |
| Cómo conseguirla | Biblioteca UDP o préstamo interbibliotecario. |
| Versión leída | Resumen de PubMed (PMID 2018391). |
| URL | https://doi.org/10.1146/annurev.ps.42.020191.001031 |
| Alternativa abierta | No se encontró. |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 11, «Señal» (l. 632): «un timbre con muchas frecuencias a la vez ayuda a saber de dónde viene». | Pendiente | Resumen: la dirección horizontal se estima por diferencias de tiempo o de intensidad entre los oídos, y la altura, por la forma del espectro que modifica la oreja («*spectral shape cues*»). Eso supone un sonido con energía en muchas frecuencias, pero el resumen no lo dice así. | Mantener hasta leer la revisión. Si no se consigue: «el oído ubica un sonido, en parte, por la forma de su espectro (Middlebrooks y Green, 1991)». |

#### 16. Gembali (2023)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida** (tesis abierta). DSpace@MIT respondió 429 (demasiadas solicitudes); se usó la copia local del autor, que es el PDF de la tesis (Word, 22 de mayo de 2023, 94 págs.) y coincide en título, autor y año. |
| Versión | Tesis depositada; la página impresa coincide con la del PDF. |
| URL | https://hdl.handle.net/1721.1/151254 |
| Copia local | `textos/gembali-2023.pdf` (copiada de la carpeta del autor) |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 12, «Del prototipo al producto» (l. 693): «Ambas podrían funcionar con localizadores de otras marcas, de modo que la persona use el que ya tiene, siempre que respondan a la orden estándar de alerta: es un camino que no obliga a fabricar electrónica, aunque depende de modelos que varían entre fabricantes (Gembali, 2023, p. 53)». | Parcial | p. 53: si el dispositivo ya existe, la empresa puede comprarlo a un fabricante, ponerle su marca y venderlo («*white labeling*»), sin invertir en desarrollarlo ni fabricarlo; la desventaja es que puede no tener justo las funciones necesarias. p. 54: también se puede aprovechar el hardware que la persona ya tiene, como su teléfono. La tesis no habla de localizadores de otras marcas ni de una orden estándar de alerta. | «Ambas podrían funcionar con localizadores de otras marcas, de modo que la persona use el que ya tiene, siempre que respondan a la orden estándar de alerta. Usar un dispositivo que ya existe evita desarrollar y fabricar electrónica, aunque limita las funciones a lo que ese dispositivo ofrece (Gembali, 2023, pp. 53–54).» |

#### 17. Kolko (2011)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Libro sin copia legal gratuita** (Oxford University Press). La copia local del autor viene de ilide.info, un sitio que reproduce documentos sin autorización (el PDF interno se llama «0199744335.pdf»). Sirvió para revisar la página, a pedido del autor, pero no cumple las reglas de obtención y no se copió a `textos/`. |
| Cómo conseguirla | Biblioteca UDP o compra. Conviene confirmar la página en un ejemplar legal. |
| URL | Sin URL abierta. |
| Alternativa abierta | Kolko, J. (2010). Abductive thinking and sensemaking: The drivers of design synthesis. *Design Issues, 26*(1), 15–28. Texto publicado por el autor en su sitio; copia de Internet Archive del 10 de octubre de 2022: https://web.archive.org/web/20221010145404/https://www.jonkolko.com/writingAbductiveThinking.php. Define la síntesis como un proceso abductivo de construcción de sentido, no como el paso a criterios. |
| Copia local | `textos/kolko-2011-alternativa-abierta-kolko-2010.html` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 9 (l. 380): «Kolko (2011, p. 40) llama síntesis a este paso, en que lo aprendido se convierte en una oportunidad concreta de diseño». | Parcial | p. 40: la investigación describe una oportunidad, y la síntesis la traduce en criterios de diseño específicos. p. 39: la síntesis da herramientas para pasar de la investigación a ideas de diseño concretas («*specific and actionable*»). | «Kolko (2011, p. 40) llama síntesis a este paso, que traduce la oportunidad descrita por la investigación en criterios de diseño específicos.» Calza mejor con el capítulo, que trata de criterios. |

#### 18. Nielsen (1993)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Libro sin copia legal gratuita** (Academic Press). La copia local es una impresión a PDF de un visor web de DjVu (djvu.js.org), de 375 páginas y origen desconocido; no cumple las reglas y no se copió. Las páginas se leyeron con OCR: la página impresa es la del PDF menos 13. |
| Cómo conseguirla | Biblioteca UDP. |
| URL | Sin URL abierta. |
| Alternativa abierta | Solo para la evaluación formativa: Kendrick, A. (2019, 28 de julio). *Formative vs. summative evaluations*. Nielsen Norman Group. https://www.nngroup.com/articles/formative-vs-summative-evaluations/ |
| Copia local | `textos/nielsen-1993-alternativa-abierta-nngroup-2019.html` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 10 (l. 438): «La evaluación es formativa: busca encontrar problemas y mejorar el diseño en cada vuelta (Nielsen, 1993, p. 170)». | Coincide | p. 170: la evaluación formativa ayuda a mejorar la interfaz dentro de un diseño iterativo; busca saber qué aspectos son buenos y malos y cómo mejorarlos. | — |
| Glosario, «Evaluación formativa» (l. 1061): «…no medir su eficacia (Nielsen, 1993)». | Coincide, precisar | p. 170: la sumativa evalúa la calidad general, por ejemplo para elegir entre dos alternativas. | Añadir la página: (Nielsen, 1993, p. 170). |
| Cap. 11, «Tag» (l. 610): «Un prototipo puede usar medios simples si conserva lo esencial (Nielsen, 1993, pp. 96–97)». | Coincide | pp. 96–97: medios de baja fidelidad, menos elaborados que la interfaz final, que conservan lo esencial de la interacción. | — |
| Cap. 13 (l. 740): el registro automático «muestra qué hizo la persona, pero no por qué (Nielsen, 1993, p. 221)». | Coincide | p. 221: el gran problema del registro es que muestra lo que hicieron, no por qué; propone combinarlo con entrevistas. | — |

#### 19. Sanders y Stappers (2012)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Libro sin copia legal gratuita** (BIS Publishers). La copia local viene de Z-Library, según su propio nombre de archivo: no cumple las reglas; se usó solo para comprobar la página, a pedido del autor, y no se copió. |
| Cómo conseguirla | Biblioteca UDP o compra. Conviene confirmar la página en un ejemplar legal. |
| URL | Sin URL abierta. |
| Alternativa abierta | Sanders, E. B.-N. (2002). From user-centered to participatory design approaches. En J. Frascara (Ed.), *Design and the social sciences: Making connections*. Taylor & Francis. Copia de la autora en maketools.com, archivada por Internet Archive el 12 de julio de 2019: https://web.archive.org/web/20190712084954/http://www.maketools.com/articles-papers/FromUsercenteredtoParticipatory_Sanders_%2002.pdf |
| Copia local | `textos/sanders-stappers-2012-alternativa-abierta-sanders-2002.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 7 (l. 270) y nota de la Figura 5 (l. 278): «lo que las personas dicen puede diferir de lo que hacen» (p. 69). | Coincide | p. 69: el dilema entre decir y hacer («*say/do dilemma*»): lo que las personas dicen difiere de lo que hacen. Sanders (2002, p. 3) lo dice de otro modo: escuchar lo que dicen da solo lo que quieren que oigamos. | — |

#### 20. ISO 3864-1:2011

| Aspecto | Dato |
| --- | --- |
| Obtención | **Norma de pago** (CHF 100 en iso.org). La página de ISO respondió 403 a la consulta automática; su vista previa oficial (Online Browsing Platform) no se pudo abrir en esta sesión. |
| Cómo conseguirla | Biblioteca UDP, si tiene acceso a normas, o compra. |
| URL | https://www.iso.org/standard/51021.html · vista previa: https://www.iso.org/obp/ui/#iso:std:iso:3864:-1:ed-2:v1:en |
| Alternativa abierta | Directiva 92/58/CEE del Consejo, de 24 de junio de 1992, sobre señalización de seguridad y de salud en el trabajo, anexo I, punto 4 (EUR-Lex, en español): https://eur-lex.europa.eu/legal-content/ES/TXT/HTML/?uri=CELEX:31992L0058. No es la norma ISO, pero fija la misma convención de colores de seguridad. |
| Copia local | `textos/international-organization-for-standardization-2011-alternativa-abierta-directiva-92-58-cee.html` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 11, «Paleta cromática» (l. 598): «el negro, el gris y el rojo quedan fuera de los estados de la persona, como en la convención de la señalética (International Organization for Standardization [ISO], 2011)». | Parcial (pendiente de la norma) | Directiva 92/58/CEE, anexo I, punto 4: rojo, prohibición, peligro o alarma; amarillo, advertencia; azul, obligación; verde, salvamento o situación de seguridad. La convención reserva el rojo para la prohibición y el peligro; no asigna significado al negro ni al gris. | «El rojo queda para los errores, como en la señalética de seguridad, que lo reserva para la prohibición y el peligro (International Organization for Standardization [ISO], 2011); el negro y el gris tampoco se usan para los estados de la persona.» |

### Fuentes sumadas el 10 de noviembre

#### 21. Ball et al. (2025)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida.** (a) Manuscrito aceptado en PubMed Central (programa de acceso público de los NIH); PMC pide una prueba de trabajo a las herramientas automáticas y se usó la copia de Internet Archive del 9 de octubre de 2026. (b) Preprint en PsyArXiv (OSF), de dominio público. La versión publicada (APA) es de acceso abierto según OpenAlex. |
| Versión | Aceptada (PMC) y preprint (OSF). |
| URL | https://web.archive.org/web/20261009051118/https://pmc.ncbi.nlm.nih.gov/articles/PMC11781985/ · https://osf.io/k7ctd · https://doi.org/10.1037/pag0000844 |
| Copia local | `textos/ball-2025.html` y `textos/ball-2025-preprint.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 5 (l. 182): «con muchas cosas que recordar, una alarma mejoró el cumplimiento de intenciones tanto en personas jóvenes como en mayores». | Parcial | Resumen y método: en el laboratorio, el recordatorio era la lista de palabras señal, visible en lo alto de la pantalla durante toda la tarea; la alarma para tomar un medicamento aparece solo como ejemplo general. Con mucha carga, jóvenes y mayores se beneficiaron por igual (experimento 1); con intenciones poco específicas, el recordatorio eliminó la desventaja de las personas mayores (experimento 2). | «Esa señal ayuda: con muchas cosas que recordar, tener a la vista lo pendiente mejoró el cumplimiento de intenciones en personas jóvenes y mayores, y en uno de los experimentos eliminó la desventaja de las mayores (Ball et al., 2025).» |

#### 22. Ullmer et al. (2022)

| Aspecto | Dato |
| --- | --- |
| Obtención | **No descargada.** Libro de ACM Books, gratuito desde el 1 de enero de 2026 en la ACM Digital Library, que bloquea las herramientas automáticas (403). Se leyó el resumen oficial en el portal de investigación de TU Eindhoven. |
| Cómo conseguirla | El autor descarga la introducción con su navegador y la guarda como `textos/ullmer-2022.pdf`. |
| URL | https://dl.acm.org/doi/book/10.1145/3544564 · resumen: https://research.tue.nl/en/publications/04ddf1fe-a45d-47a9-abe0-fceb25862768 |
| Copia local | Ninguna. |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 6 (l. 250): «Veinticinco años después, uno de esos autores y sus colegas describen el campo como interacción tangible y corporizada, que suma el cuerpo a los objetos y al espacio». | Parcial (resumen) | El título habla de interacción tangible y corporizada, y el resumen nombra la disciplina como interacción tangible, corporizada y situada («*Tangible, Embodied, and Embedded*»), que entrelaza lo físico y lo digital. Los 25 años y la coautoría de Ullmer son correctos; «que suma el cuerpo a los objetos y al espacio» es una glosa propia. | «…describen el campo como interacción tangible, corporizada y situada (*tangible, embodied and embedded interaction*), que entrelaza lo físico y lo digital (Ullmer et al., 2022).» Confirmar con la introducción del libro. |

#### 23. Sheeran y Webb (2016)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida.** Manuscrito aceptado en White Rose Research Online (Universidad de Sheffield). |
| Versión | Aceptada; sus páginas no son las de la revista (págs. 503–518). |
| URL | https://eprints.whiterose.ac.uk/id/eprint/107519/ |
| Copia local | `textos/sheeran-webb-2016.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 13 (l. 772): «la intención de hacer algo explica solo en parte lo que una persona hace después». | Coincide | Conclusión: las intenciones se traducen en acción cerca de la mitad de las veces. Cita un metaanálisis: un cambio mediano a grande en la intención produjo uno pequeño a mediano en la conducta (d = 0,36). | Opcional: «las intenciones se cumplen cerca de la mitad de las veces». El artículo, además, nombra olvidar actuar entre los problemas para empezar, lo que respalda el problema de Relevo. |

#### 24. Covington et al. (2016)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida.** Copia en el sitio de Google Research, con la nota de derechos de ACM; la de ACM es abierta (CC BY-NC-ND), pero bloquea las herramientas automáticas. |
| Versión | Publicada (págs. 191–198). |
| URL | https://research.google.com/pubs/archive/45530.pdf |
| Copia local | `textos/covington-2016.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 3 (l. 148): «un sistema elige qué viene después, y aprende más de lo que la persona hace que de lo que dice querer». | Coincide | p. 192: aunque YouTube tiene botones de «me gusta» y encuestas, el modelo se entrena con la retroalimentación implícita («*implicit feedback*») de lo que se ve; ver un video completo cuenta como ejemplo positivo. | — |
| Cap. 3 (l. 148): «el modelo que ordena las recomendaciones se entrenó para predecir cuánto tiempo se verá cada video». | Coincide | p. 192: el modelo de ordenamiento predice el tiempo de visionado esperado («*expected watch time*») en vez de la probabilidad de clic; p. 195: el objetivo es, en general, una función simple de ese tiempo por impresión. | Opcional: (Covington et al., 2016, p. 192). |

#### 25. Kleinberg et al. (2023)

| Aspecto | Dato |
| --- | --- |
| Obtención | **Conseguida.** Preprint en arXiv, versión 3, del 23 de octubre de 2023, anterior a la publicación en línea del 7 de noviembre de 2023. Crossref sigue registrando la versión de la revista como publicación anticipada, sin volumen: la referencia está bien. |
| Versión | Preprint (v3). |
| URL | https://arxiv.org/abs/2202.11776 |
| Copia local | `textos/kleinberg-2023.pdf` |

| Cita en la memoria | Dictamen | Qué dice la fuente | Propuesta |
| --- | --- | --- | --- |
| Cap. 3 (l. 148): «Lo que una persona elige en el momento no siempre coincide con lo que quiere, y un sistema que solo mira su conducta puede confundir ambas cosas». | Coincide | Resumen (p. 1): para saber qué quieren los usuarios, las plataformas miran lo que hacen («*revealed-preference*»), pero a menudo elegimos en el momento algo que no coincide con lo que queremos; proponen un modelo en que la plataforma solo observa el uso. | Opcional: aclarar que es un modelo teórico. |

## Qué falta y cómo conseguirlo

**Con el navegador del autor** (son gratuitas; solo bloquean a las herramientas automáticas). Guardar cada PDF en `textos/` con el nombre indicado:

1. Guynn et al. (1998): https://link.springer.com/content/pdf/10.3758/BF03201140.pdf → `guynn-1998.pdf`.
2. Ullmer et al. (2022), introducción: https://dl.acm.org/doi/book/10.1145/3544564 → `ullmer-2022.pdf`.
3. Opcionales, para citar con páginas: Waggoner et al. (2026), https://link.springer.com/content/pdf/10.1007/s00799-025-00436-6.pdf; Fogg (2009), versión publicada, https://dl.acm.org/doi/pdf/10.1145/1541948.1541999; la tesis ligada a O'Rear y Radvansky, https://curate.nd.edu/articles/thesis/Location-Based_Prospective_Memory/24814542; la vista previa de ISO 3864-1, https://www.iso.org/obp/ui/#iso:std:iso:3864:-1:ed-2:v1:en.

**Con la biblioteca de la UDP, préstamo interbibliotecario o pidiéndolas a sus autores:** McDaniel y Einstein (2000) y Miller et al. (2007), en Wiley; O'Rear y Radvansky (2019), Edworthy et al. (1991) y Hellier et al. (1993), en SAGE; Elliot y Maier (2014) y Middlebrooks y Green (1991), en Annual Reviews; ISO 3864-1:2011; y ejemplares legales de Kolko (2011), Nielsen (1993) y Sanders y Stappers (2012). No se comprobó a qué colecciones está suscrita la UDP.

**Sobre las copias locales de los tres libros:** las de Kolko (ilide.info) y Sanders y Stappers (Z-Library) vienen de sitios de copias no autorizadas, y la de Nielsen, de un visor web de origen desconocido. Sirvieron para confirmar las páginas, pero no deben compartirse ni subirse, y conviene confirmar esas páginas en un ejemplar legal antes de la entrega final.

## Lo que queda por actualizar

No se tocó ningún otro documento del repositorio. Quedan por actualizar, cuando el autor lo decida:

- El [manifiesto](manifiesto.json): sumar las claves `ball-2025`, `covington-2016`, `kleinberg-2023`, `sheeran-webb-2016` y `ullmer-2022`, y las nuevas vías de `sohn-2005` (Microsoft Research), `kirsh-1995` (UC San Diego), `hermann-2007` (Universidad de Ulm) y `gembali-2023`.
- El [estado de las fuentes](README.md#estado-al-2-de-noviembre-de-2026) y la [tarea 14, punto H](../../00_gobernanza/por-hacer.md#h-recordatorio-buscar-las-fuentes-que-faltaron-por-verificar), con lo conseguido y lo que sigue pendiente.
- El [registro de pedidos a la IA](../../00_gobernanza/registro-de-pedidos-a-la-ia.md), con este pedido.

## Registro de cambios (disclaimer)

### 2026-11-10 — Textos del autor y correcciones aplicadas

- **Qué cambió:** el autor consiguió Fogg (2009), en ACM; Guynn et al. (1998); Waggoner et al. (2026), y la tesis de Kalchik (2016), que dio origen a O’Rear y Radvansky (2019). Con ellos y con este informe, la memoria aplicó 21 cambios, detallados en [cambios de la memoria final](cambios-memoria-final-2026-11-10.md). Kleinberg et al. ya está publicado en 2024, y Ullmer et al. (2022) sale de la memoria. Los textos quedan solo en `textos/`, que no se sube.
- **Cómo estaba antes:** esas cuatro fuentes figuraban como no conseguidas o solo con su resumen, y las once frases por corregir seguían en la memoria.
- **Por qué:** pedido del autor del 10 de noviembre de 2026 (D-182).

### 2026-11-10 — Creación

- **Qué cambió:** se creó este documento con las vías gratuitas y legales de las 25 fuentes pendientes, la verificación de 52 citas o afirmaciones de la memoria v6 y las propuestas de redacción. Se guardaron en `textos/`, que no se versiona, 12 textos completos y 6 alternativas abiertas.
- **Cómo estaba antes:** 23 de esas fuentes figuraban como «solo resumen» o «sin acceso» en el estado del 2 de noviembre, y las cinco sumadas el 10 de noviembre solo se habían comprobado en Crossref. La carpeta `textos/` no existía en este equipo.
- **Por qué:** el autor pidió indagar cómo obtener gratis, de una fuente legal, al menos lo que usa la memoria, y comprobar que la memoria cite bien.
