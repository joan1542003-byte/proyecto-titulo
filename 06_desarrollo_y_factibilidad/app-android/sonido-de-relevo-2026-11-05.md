# El sonido de Relevo: cuatro opciones y su fundamento

**Fecha:** 5 de noviembre de 2026. **Decisión:** [D-158](../../09_decisiones/registro-de-decisiones.md). **Versión:** [Android 4.3](version-4.3-sugerencias-relevos-y-sonido-2026-11-05.md). **Código:** [FirmaSonora.kt](app/src/main/java/com/example/relevo/signal/FirmaSonora.kt). **Muestras para escuchar:** [sonidos](sonidos/README.md).

## Qué se pidió y qué se hizo

El autor pidió poder elegir el sonido en los ajustes, con fundamento en estudios. Desde la 4.3, **Ajustes › Sonido** ofrece cuatro sonidos, y el que se elige suena una vez en el teléfono.

- **Madera** sigue siendo el sonido por defecto. Es la firma sonora de [D-071](../../09_decisiones/registro-de-decisiones.md), sin cambios.
- **Fieltro, Claro y Tonada** cambian uno o dos de los rasgos que la investigación relaciona con la urgencia y la molestia: altura, ritmo, espectro y envolvente.
- **Lo común:** los cuatro duran unos 30 segundos ([D-078](../../09_decisiones/registro-de-decisiones.md)), empiezan más suaves, terminan solos y cierran con una cuarta descendente, que es el gesto de la firma.
- **El Tag** suena siempre con su propio pitido. El iTag tiene un tono fijo y agudo que no se puede cambiar ([objetos que suenan](../objetos-que-suenan-2026-09-29.md)).
- **Registro:** si la persona aceptó participar, el sonido elegido queda en el registro de la investigación, para leerlo junto a los datos de la señal.

## Qué dice la investigación

- **Urgencia percibida.** Un sonido parece más urgente cuanto más rápido y agudo es, cuanto más irregulares son sus armónicos y cuanto más se repite. La velocidad es el rasgo que más pesa (Edworthy et al., 1991; Hellier et al., 1993). La irregularidad en el tiempo también capta la atención (Suied et al., 2008).
- **Molestia.** No crece al mismo ritmo que la urgencia. El intervalo entre pulsos mueve más la urgencia que la molestia, y en los avisos leves la molestia decide si el aviso parece apropiado (Marshall et al., 2007). Subir la altura aumenta las dos (Baldwin y Lewis, 2014).
- **Envolvente**, es decir, cómo sube y cae el volumen de cada golpe. Una envolvente que decae, como la de una campana, molesta menos que una plana y se detecta mejor. Acortar los armónicos agudos baja la molestia y la detección cae menos (Foley et al., 2022). Ese tipo de envolvente no dificulta aprender el sonido (Sreetharan et al., 2021).
- **Aspereza.** Dos componentes más cercanos que una banda crítica, el rango en que el oído no logra separarlos, suenan ásperos (Plomp y Levelt, 1965). Las modulaciones de 30 a 150 Hz caracterizan a los gritos y las alarmas (Arnal et al., 2015).
- **Sobresalto.** Lo favorecen la intensidad alta y la subida brusca (Turpin et al., 1999). Patterson (1990) propone que el sonido suba en unos 20 ms, empiece bajo, crezca pulso a pulso y, en su forma no urgente, se repita cada 4 segundos.
- **Ubicación.** Un tono puro es lo más difícil de ubicar. Sumarle ruido o armónicos ayuda a encontrar su origen y evita que otros sonidos lo tapen (Catchpole et al., 2004; Edworthy et al., 2017). En una habitación, el inicio del sonido orienta aunque dure apenas 100 ms (Rakerd y Hartmann, 1986). Patterson (1990) recomienda cuatro componentes o más, entre 15 y 25 dB sobre el umbral que impone el ruido.
- **Habituación**, es decir, dejar de reaccionar a un estímulo repetido. Ocurre más rápido con estímulos débiles y frecuentes, es propia de cada estímulo y puede durar semanas (Rankin et al., 2009). La fatiga de alarmas viene sobre todo de las falsas alarmas, porque las personas responden según cuánto confían en el aviso (Bliss et al., 1995; Edworthy, 2013). Ningún timbre compensa un aviso que llega en mal momento.
- **Íconos auditivos y *earcons*.** Un ícono auditivo imita un sonido cotidiano (Gaver, 1986); un *earcon* es un motivo musical abstracto (Blattner et al., 1989). En notificaciones móviles, los íconos resultaron más intuitivos, más fáciles de aprender y recordar, y fueron los preferidos (Garzonis et al., 2009). Las melodías de la norma de alarmas médicas se aprendían mal (Sanderson et al., 2006), y su enmienda de 2020 agregó íconos auditivos (International Electrotechnical Commission [IEC], 2020). La firma de Relevo es un híbrido: un motivo de dos notas con el timbre de un objeto golpeado.
- **Melodía.** En un cuestionario a 50 personas, los sonidos de despertador descritos como melódicos se asociaron con menos inercia del sueño declarada (McFarlane et al., 2020). Es una asociación, no un efecto comprobado, y trata del despertar, no de recordatorios.
- **El teléfono.** Las notificaciones del teléfono hacen más lentas las respuestas en una tarea (Upshaw et al., 2022), y el cerebro procesa antes el tono propio que uno ajeno (Roye et al., 2010). *Interpretación:* elegir el sonido puede hacerlo propio, pero ninguno debe parecer una notificación, porque invitaría a mirar el teléfono.

## Los cuatro sonidos

Los perfiles son decisiones de diseño apoyadas en esa investigación, no resultados. La rampa indica el volumen de cada repetición respecto del máximo de la señal.

| Sonido | Para qué | Notas | Timbre | Ritmo | Ataque | Rampa |
| --- | --- | --- | --- | --- | --- | --- |
| **Madera** (por defecto) | La firma de Relevo | Re5 (587 Hz) y La4 (440 Hz) | Parciales 1 : 3,9 : 9,2, como un golpe de madera, más un ruido de 4 ms | Dos golpes separados por 0,46 s; cada 4,4 s; 7 veces | 4 ms | 40 %, 60 %, 80 % y después 100 % |
| **Fieltro** | Una casa silenciosa | La4 (440 Hz) y Mi4 (330 Hz) | Armónicos 1 : 2 : 3 que se apagan pronto; sin ruido | Dos golpes separados por 0,6 s; cada 6,5 s; 5 veces | 20 ms | 30 %, 50 %, 70 %, 60 % y 50 % |
| **Claro** | Una casa con ruido | Re5, Re5 y La4, corto y largo | Seis armónicos, de 0,4 a 3,5 kHz, más breves cuanto más agudos; ruido de 6 ms | Tres golpes, a 0, 0,25 y 0,71 s; cada 3,3 s; 9 veces | 5 ms | 50 %, 75 % y después 100 % |
| **Tonada** | Quien prefiere una melodía | La4, Re5, Fa♯5, Fa♯5, Re5 y La4 | Armónicos 1 : 2 : 3, percusivos | Una nota cada 0,35 s; la frase cada 6 s; 5 veces | 10 ms | 40 %, 60 %, 80 % y después 100 % |

- **Madera.** Se parece al «ding-dong» que la norma médica admite para la prioridad baja (Edworthy et al., 2017). Tiene dos puntos por revisar. Sus parciales inarmónicos, que no son múltiplos exactos de la nota, elevan la urgencia (Hellier et al., 1993), aunque aquí son débiles y se apagan pronto. Además, su ataque podría alargarse a 10 o 20 ms sin perder la pista del inicio (Rakerd y Hartmann, 1986). No se cambió para conservar la firma.
- **Fieltro.** Es más grave, más lento y se repite menos. Si el dispositivo de audio no reproduce bien la nota más grave, los armónicos conservan la altura que se oye, y el final baja como en la forma no urgente de Patterson (1990). Su costo es que se ubica peor y que, por ser más débil, la persona puede acostumbrarse antes (Rankin et al., 2009).
- **Claro.** Se hace notar por su espectro y su ritmo, no por la altura (Patterson, 1990; Marshall et al., 2007; Baldwin y Lewis, 2014). Su costo es que repetir más y sumar ruido elevan la urgencia (Hellier et al., 1993; Catchpole et al., 2004).
- **Tonada.** Usa solo notas de un mismo acorde, sin segundas que rocen entre sí (Plomp y Levelt, 1965), y repite una nota, un rasgo que ayuda a reconocer melodías (Gillard y Schutz, 2016). Su costo es que reconocerla depende de la formación musical (Sanderson et al., 2006).

## Medición

Los cuatro sonidos se generaron con el mismo código de la app, mediante una prueba temporal que los escribió en WAV a 44,1 kHz, y se midieron. El **centroide espectral** es el centro de gravedad del espectro: cuanto más alto, más brillante se oye. El **nivel medio** es la raíz cuadrática media de toda la señal, en decibeles bajo el máximo digital (dBFS); 6 dB menos equivalen a la mitad de amplitud. Cada motivo llega a −3 dBFS.

| Sonido | Motivo | Centroide | Nivel medio de la señal | Repeticiones | Se oye hasta |
| --- | --- | --- | --- | --- | --- |
| Madera | 2,2 s | 676 Hz | −19,2 dBFS | 7 | 28,5 s |
| Fieltro | 3,0 s | 476 Hz | −25,1 dBFS | 5 | 28,8 s |
| Claro | 1,8 s | 1344 Hz | −20,0 dBFS | 9 | 28,1 s |
| Tonada | 2,7 s | 799 Hz | −19,2 dBFS | 5 | 26,6 s |

- **Fieltro** es el más oscuro y, en promedio, unos 6 dB más suave que Madera.
- **Claro** duplica el brillo de Madera y se repite más, sin subir el nivel medio.
- **Madera** coincide muestra a muestra con [firma-relevo.wav](../../10_recursos_visuales/marca-suena-donde-empieza/sonido/firma-relevo.wav) (correlación 1,0000): la firma no cambió.
- **Pruebas unitarias:** [SonidosTest](app/src/test/java/com/example/relevo/signal/SonidosTest.kt) comprueba que cada señal dura 30 s, que ninguna satura, que la prueba de sonido es un solo motivo y que un valor desconocido vuelve a Madera.

## Límites y pendientes

- **Sin escucha en contexto:** nadie ha oído los cuatro sonidos en una casa, en el teléfono ni en un dispositivo de audio. Las [muestras](sonidos/README.md) permiten hacerlo antes de la prueba.
- **Evidencia de otros contextos:** toda viene de alarmas, conducción y hospitales. Ningún estudio citado prueba recordatorios en el hogar.
- **Una afirmación sin comprobar:** el documento [19](../../10_recursos_visuales/19_marca-suena-donde-empieza-2026-09-25.md), el sistema de diseño y la memoria v6 dicen que un contorno descendente suena menos urgente (Edworthy et al., 1991). En esta revisión no se pudo leer el texto original; la dirección del efecto se tomó del resumen de Suied et al. (2008). Queda por comprobar.
- **La memoria** v6 describe solo el sonido por defecto. Si las opciones se mantienen después de la prueba, conviene mencionarlas. Esta revisión no cambió la memoria.
- **En la prueba de 21 días** conviene leer qué sonido eligió cada persona, si lo cambió y si eso se relaciona con silenciar la señal o dejarla terminar.

## Referencias

Arnal, L. H., Flinker, A., Kleinschmidt, A., Giraud, A.-L. y Poeppel, D. (2015). Human screams occupy a privileged niche in the communication soundscape. *Current Biology, 25*(15), 2051–2056. https://doi.org/10.1016/j.cub.2015.06.043

Baldwin, C. L. y Lewis, B. A. (2014). Perceived urgency mapping across modalities within a driving context. *Applied Ergonomics, 45*(5), 1270–1277. https://doi.org/10.1016/j.apergo.2013.05.002

Blattner, M., Sumikawa, D. y Greenberg, R. (1989). Earcons and icons: Their structure and common design principles. *Human-Computer Interaction, 4*(1), 11–44. https://doi.org/10.1207/s15327051hci0401_1

Bliss, J. P., Gilson, R. D. y Deaton, J. E. (1995). Human probability matching behaviour in response to alarms of varying reliability. *Ergonomics, 38*(11), 2300–2312. https://doi.org/10.1080/00140139508925269

Catchpole, K. R., McKeown, J. D. y Withington, D. J. (2004). Localizable auditory warning pulses. *Ergonomics, 47*(7), 748–771. https://doi.org/10.1080/00140130310001629739

Edworthy, J. (2013). Medical audible alarms: A review. *Journal of the American Medical Informatics Association, 20*(3), 584–589. https://doi.org/10.1136/amiajnl-2012-001061

Edworthy, J., Loxley, S. y Dennis, I. (1991). Improving auditory warning design: Relationship between warning sound parameters and perceived urgency. *Human Factors, 33*(2), 205–231. https://doi.org/10.1177/001872089103300206

Edworthy, J., Reid, S., McDougall, S., Edworthy, J., Hall, S., Bennett, D., Khan, J. y Pye, E. (2017). The recognizability and localizability of auditory alarms: Setting global medical device standards. *Human Factors, 59*(7), 1108–1127. https://doi.org/10.1177/0018720817712004

Foley, L., Schlesinger, J. y Schutz, M. (2022). More detectable, less annoying: Temporal variation in amplitude envelope and spectral content improves auditory interface efficacy. *The Journal of the Acoustical Society of America, 151*(5), 3189–3196. https://doi.org/10.1121/10.0010447

Garzonis, S., Jones, S., Jay, T. y O'Neill, E. (2009). Auditory icon and earcon mobile service notifications: Intuitiveness, learnability, memorability and preference. En *Proceedings of the SIGCHI Conference on Human Factors in Computing Systems* (pp. 1513–1522). Association for Computing Machinery. https://doi.org/10.1145/1518701.1518932

Gaver, W. (1986). Auditory icons: Using sound in computer interfaces. *Human-Computer Interaction, 2*(2), 167–177. https://doi.org/10.1207/s15327051hci0202_3

Gillard, J. y Schutz, M. (2016). Composing alarms: Considering the musical aspects of auditory alarm design. *Neurocase, 22*(6), 566–576. https://doi.org/10.1080/13554794.2016.1253751

Hellier, E. J., Edworthy, J. y Dennis, I. (1993). Improving auditory warning design: Quantifying and predicting the effects of different warning parameters on perceived urgency. *Human Factors, 35*(4), 693–706. https://doi.org/10.1177/001872089303500408

International Electrotechnical Commission. (2020). *Medical electrical equipment – Part 1-8: General requirements for basic safety and essential performance – Collateral standard: General requirements, tests and guidance for alarm systems in medical electrical equipment and medical electrical systems* (IEC 60601-1-8:2006/AMD2:2020). https://webstore.iec.ch/en/publication/59648

Marshall, D. C., Lee, J. D. y Austria, P. A. (2007). Alerts for in-vehicle information systems: Annoyance, urgency, and appropriateness. *Human Factors, 49*(1), 145–157. https://doi.org/10.1518/001872007779598145

McFarlane, S. J., Garcia, J. E., Verhagen, D. S. y Dyer, A. G. (2020). Alarm tones, music and their elements: Analysis of reported waking sounds to counteract sleep inertia. *PLOS ONE, 15*(1), Artículo e0215788. https://doi.org/10.1371/journal.pone.0215788

Patterson, R. D. (1990). Auditory warning sounds in the work environment. *Philosophical Transactions of the Royal Society of London. B, Biological Sciences, 327*(1241), 485–492. https://doi.org/10.1098/rstb.1990.0091

Plomp, R. y Levelt, W. J. M. (1965). Tonal consonance and critical bandwidth. *The Journal of the Acoustical Society of America, 38*(4), 548–560. https://doi.org/10.1121/1.1909741

Rakerd, B. y Hartmann, W. M. (1986). Localization of sound in rooms, III: Onset and duration effects. *The Journal of the Acoustical Society of America, 80*(6), 1695–1706. https://doi.org/10.1121/1.394282

Rankin, C. H., Abrams, T., Barry, R. J., Bhatnagar, S., Clayton, D. F., Colombo, J., Coppola, G., Geyer, M. A., Glanzman, D. L., Marsland, S., McSweeney, F. K., Wilson, D. A., Wu, C.-F. y Thompson, R. F. (2009). Habituation revisited: An updated and revised description of the behavioral characteristics of habituation. *Neurobiology of Learning and Memory, 92*(2), 135–138. https://doi.org/10.1016/j.nlm.2008.09.012

Roye, A., Schröger, E., Jacobsen, T. y Gruber, T. (2010). Is my mobile ringing? Evidence for rapid processing of a personally significant sound in humans. *The Journal of Neuroscience, 30*(21), 7310–7313. https://doi.org/10.1523/JNEUROSCI.1113-10.2010

Sanderson, P. M., Wee, A. y Lacherez, P. (2006). Learnability and discriminability of melodic medical equipment alarms. *Anaesthesia, 61*(2), 142–147. https://doi.org/10.1111/j.1365-2044.2005.04502.x

Sreetharan, S., Schlesinger, J. J. y Schutz, M. (2021). Decaying amplitude envelopes reduce alarm annoyance: Exploring new approaches to improving auditory interfaces. *Applied Ergonomics, 96*, Artículo 103432. https://doi.org/10.1016/j.apergo.2021.103432

Suied, C., Susini, P. y McAdams, S. (2008). Evaluating warning sound urgency with reaction times. *Journal of Experimental Psychology: Applied, 14*(3), 201–212. https://doi.org/10.1037/1076-898X.14.3.201

Turpin, G., Schaefer, F. y Boucsein, W. (1999). Effects of stimulus intensity, risetime, and duration on autonomic and behavioral responding: Implications for the differentiation of orienting, startle, and defense responses. *Psychophysiology, 36*(4), 453–463. https://doi.org/10.1111/1469-8986.3640453

Upshaw, J. D., Stevens, C. E., Ganis, G. y Zabelina, D. L. (2022). The hidden cost of a smartphone: The effects of smartphone notifications on cognitive control from a behavioral and electrophysiological perspective. *PLOS ONE, 17*(11), Artículo e0277220. https://doi.org/10.1371/journal.pone.0277220

**Comprobación:** el 5 de noviembre de 2026 se contrastaron los 25 DOI con Crossref (título, año, revista, volumen, páginas y autores); todos coinciden. La norma IEC se cita por su ficha en la tienda del organismo. Edworthy et al. (1991) y Hellier et al. (1993) ya estaban en el repositorio con su DOI comprobado. Edworthy et al. (2017) tiene dos autores llamados J. Edworthy: Judy y Jonathan.

## Registro de cambios (disclaimer)

### 2026-11-05 — Creación

- **Qué cambió:** se documentaron los cuatro sonidos de la 4.3, su fundamento, su medición, sus límites y 26 referencias.
- **Cómo estaba antes:** había un solo sonido, la firma de D-071, sin opción en los ajustes.
- **Por qué:** el autor pidió elegir el sonido en los ajustes, con fundamento en estudios.
