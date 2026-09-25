# Revisión integral de la memoria v4: fuentes, evidencia y redacción

**Fecha:** 25 de septiembre de 2026.
**Documento revisado:** [memoria vigente v4](memoria-vigente-v4.md), completa, desde el resumen hasta las referencias.
**Base contrastada:** corpus anonimizado P1–P8, instrumento aplicado, aplicación Android 2.6, protocolo 01, pauta Android, registro de decisiones y memorias anteriores (cierre del primer semestre, v1–v3).

## Qué se preguntó

1. ¿Existen todas las fuentes citadas y coinciden sus datos bibliográficos?
2. ¿Lo que la memoria atribuye a cada fuente corresponde a lo que la fuente dice?
3. ¿Las paráfrasis de entrevistas corresponden al corpus?
4. ¿La memoria describe correctamente el estado real del prototipo?
5. ¿Hay texto copiado sin atribución o material ajeno usado indebidamente?
6. ¿Qué pasajes repiten ideas o dificultan la lectura?

## Método

- **Referencias con DOI (33):** se consultó cada DOI en Crossref y se compararon autores, año, título, revista, volumen, número y páginas. Cuando la cita atribuía cifras o conclusiones, se revisó el resumen oficial o el texto completo de acceso abierto.
- **Referencias web (31):** se comprobó que cada dirección respondiera y que el título de la página coincidiera con el citado. Los precios y la disponibilidad comercial son observaciones fechadas y no pueden reconstruirse hacia atrás; se verificó que los productos existan y que las funciones descritas coincidan con sus sitios actuales.
- **Libros y artículos sin DOI:** Aaker (1996) y Keller et al. (2002) se comprobaron por datos editoriales conocidos y por la dirección oficial de HBR.
- **Corpus:** cada afirmación del capítulo 7 con código P/Q se contrastó con [el corpus](../03_usuarios/corpus-anonimizado.md) y con el [instrumento aplicado](../99_archivo/fuentes-locales/instrumentos/instrumento-aplicado.md).
- **Estado del prototipo:** se contrastaron los capítulos 9–13 con el [README de Android 2.6](../06_desarrollo_y_factibilidad/app-android/README.md), el [índice de validación](../07_validacion/README.md) y el [protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md). No se compiló ni se ejecutó la app en esta revisión; el estado técnico se toma de su documentación.
- **Originalidad:** se revisó que la memoria no contenga citas textuales sin comillas ni traducciones literales de los resúmenes consultados. El texto está redactado en español a partir de fuentes en inglés; no se encontraron pasajes trasladados literalmente. Esta comprobación manual no reemplaza un software institucional de detección de similitud.

## Resultado de las fuentes

Las 64 referencias existen. No se encontró ninguna fuente inventada. Se corrigieron seis errores bibliográficos y dos direcciones que ya no llevaban al documento citado.

| Referencia | Problema encontrado | Corrección |
| --- | --- | --- |
| Peña-Albert et al. (2026) | Figuraba como «Kidel Peña-Albert, A.». El nombre de pila es Awen Kidel; el apellido es Peña-Albert. | `Peña-Albert, A. K.` en la cita y en la lista, ordenada alfabéticamente bajo P. |
| Lyngs et al. (2019) | Figuraba como «Paper 21». | Artículo 131, según las actas de CHI 2019. |
| Haliburton et al. (2024) | Figuraba como «Artículo 243»; ese número no pudo verificarse en Crossref, OpenAlex ni en la versión del autor. | Se retiró el número y se conservan las páginas 1–16 y el DOI. |
| Google Play (s. f.) | La dirección citada ahora abre la política general del programa para desarrolladores, no la página sobre servicios en primer plano. | Se sustituyó por *Understanding foreground service and full-screen intent requirements* (answer/13392821), consultada el 25 de septiembre de 2026. |
| Kitchen Safe (s. f.) | `intl.thekitchensafe.com` no responde. | Se usa el sitio oficial `www.thekitchensafe.com`, que describe el mismo producto. |
| Subsecretaría de Telecomunicaciones | El informe de la encuesta está fechado el 14 de noviembre de 2025, aunque se publicó en 2026. | El informe pasa a 2025 y la página de equipos de alcance reducido a 2026; desaparecen los sufijos a/b. Las cifras de 96,6 % y 99,1 % se verificaron en el PDF. |
| McDaniel y Einstein (2000), Motta-Filho (2021), Ward et al. (2020) | Faltaba el número de la revista. | Se añadieron 14(7), 15(5) y 27(4). |
| Apple Developer (s. f.-a) | Core Bluetooth aparecía en la lista, pero el texto no decía para qué se citaba. | El capítulo 12 menciona Core Bluetooth para la comunicación con accesorios. |

### Contenido atribuido a las fuentes

| Fuente | Qué se comprobó | Ajuste |
| --- | --- | --- |
| De Segovia Vicente et al. (2024) | 1.315 adultos y 67.762 evaluaciones; el desplazamiento prolongado se asocia con más culpa, en parte a través del conflicto entre metas. | Se precisó el mecanismo y la muestra; se eliminaron dos repeticiones del mismo hallazgo en los capítulos 5 y 6. |
| Monge Roffarello y De Russis (2023) | 43 estudios, mediana de 21 días, cinco de más de dos meses; efecto pequeño a medio (g = 0,47) calculado con siete estudios y sobre el tiempo dedicado. | Se aclaró que el efecto se estimó con siete estudios y sobre el tiempo. |
| Biedermann et al. (2021) | 28 intervenciones; las que solo buscaban aumentar la conciencia del uso fueron poco eficaces. | Se añadió ese hallazgo, pertinente para distinguir medir de apoyar. |
| Grüning et al. (2023) | La opción explícita de desistir tuvo más efecto que el mensaje de reflexión, que no fue eficaz. | Se añadió, porque respalda el criterio de ofrecer salidas reales. |
| Haliburton et al. (2024) | 1.039 personas, 13,4 semanas de promedio. | Se añadió la escala del estudio. |
| Lyngs et al. (2019) | 367 aplicaciones y extensiones de navegador. | Se precisó el tipo de herramientas. |
| Sanders (2026) | Pause Point introduce diez segundos al abrir una app elegida; desactivarlo exige reiniciar. El anuncio no indica versiones compatibles. | Se describió con precisión y se retiró la frase ambigua «amplía el conteo». |
| Chiu y Gilbert (2024) | Dos experimentos: más esfuerzo físico, menos recordatorios. | Se retiró la extrapolación «puede abandonarse antes de cumplir su función». |
| O’Rear y Radvansky (2019) | Estudio en un centro comercial virtual. | Se indicó que fue en un entorno virtual. |
| Montag et al. (2019), Smit et al. (2019), Silverman y Barasch (2023), Tonietto et al. (2021), Radtke et al. (2022), Peña-Albert et al. (2026) | Las afirmaciones corresponden a los resúmenes y textos oficiales. | Sin cambios de contenido. |

## Resultado del corpus P1–P8

Las edades, fechas, lugar, reclutamiento y la mayoría de las paráfrasis coinciden con el corpus. Se corrigieron cuatro imprecisiones:

1. **P2:** la memoria decía que «evaluó su cierre como incompleto». El corpus registra que dudó de que la sesión hubiera sido descanso porque siguió en el teléfono con sueño (Q5, Q7).
2. **Q13:** la memoria la describía como «una propuesta preliminar basada en una señal ambiental». La pregunta real presentó otra idea: depositar el teléfono en un objeto que después devolvía una señal del descanso. Ahora se dice así y se aclara por qué no valida Relevo.
3. **Rechazo de notas o comparaciones entre días:** solo P7 lo expresó, pero se atribuía a P3–P5 y P7–P8. Se corrigió en los capítulos 7 y 9.
4. **Límites no declarados:** se añadieron el rango de convocatoria de 18 a 30 años, la estrategia de P4 de desinstalar temporalmente una aplicación y la pérdida de las notas originales de Q12–Q13.

## Resultado frente al estado real del proyecto

La memoria aún describía el prototipo anterior a la versión 2.6. Se actualizó sin presentar como comprobado lo que no lo está:

- una o varias aplicaciones sumadas bajo un mismo límite, en lugar de «una aplicación seleccionada»;
- salida por parlante Bluetooth o por el teléfono, con la advertencia de que el parlante no es el testigo;
- confirmación breve ante la respuesta «Comencé la actividad», que ya existe y deberá probarse;
- consentimiento previo, notificación persistente y flujo de eliminación implementados, pero no verificados de extremo a extremo;
- un párrafo en el capítulo 11 que describe qué hace el prototipo y qué no se ha comprobado;
- una etapa en el capítulo 13 para comprobar el prototipo en equipos reales y, después, evaluarlo con cinco o seis personas, de acuerdo con la pauta Android;
- el programa de micro:bit descrito como compilado, pero no instalado ni medido; los verbos de funcionamiento actual se cambiaron a futuro.

No se añadió ningún resultado con personas, porque no existe.

## Redacción

- Se retiraron repeticiones: el estudio de De Segovia Vicente et al. aparecía tres veces, Tonietto et al. dos, *The Tangible Reminder* y Place-Its tres, y las fricciones de one sec dos. Cada idea queda desarrollada una vez y se remite a ella después.
- Se unieron párrafos de una o dos frases que repetían la conclusión del anterior en los capítulos 5, 7, 8, 11 y 12.
- Se aclararon expresiones internas: «banco técnico» se define la primera vez que aparece; «ocho minutos» y «tres segundos» se presentan como parámetros del ensayo.
- La extensión pasó de 14.990 a 15.111 palabras según `wc -w` sobre preliminares y capítulos 1–13; se mantiene cerca del objetivo de 15.000.
- Se conservan los catorce títulos de capítulo, los subtítulos existentes, el orden, la pregunta, la hipótesis, los objetivos y los umbrales del protocolo.

## Segunda revisión: redacción y pauta UDP

A pedido del autor se hizo una segunda pasada editorial. Como las memorias de otros estudiantes no se guardan en el repositorio, se tomaron como referencia la [pauta oficial de presentación de memorias de la UDP](https://bibliotecas.udp.cl/wp-content/uploads/2020/04/tesis_pauta_udp_2020.pdf) y las versiones anteriores de la propia memoria. La pauta exige en la portada nota de título, profesor guía, facultad, escuela, lugar y fecha; un resumen con objetivo, metodología, procedimientos y resultados, y dos o tres palabras clave; índice de tablas e ilustraciones; y conclusiones que juzguen la hipótesis y declaren alcances y limitaciones. Todo eso se incorporó. Los profesores guía, Sergio Majluf y Simón Gallardo, se tomaron de las versiones anteriores de la memoria; la denominación exacta del título queda por confirmar.

Además se reescribieron los capítulos 1–10 y 13 para reducir repeticiones y unir párrafos fragmentados, se numeraron los criterios C1–C8, se titularon las tablas y la figura según APA 7 y se añadió un glosario. No cambiaron datos, fuentes, pregunta, hipótesis ni umbrales.

## Tercera revisión: página por página

El autor pidió revisar cada página para que la memoria esté bien escrita, se entienda con facilidad y no invente nada. Se leyó el texto completo y se contrastó con los resúmenes oficiales de las fuentes, con el código y la documentación de Android 2.6 y con el archivo del proyecto.

| Hallazgo | Evidencia | Corrección |
| --- | --- | --- |
| Biedermann et al. (2021) no dicen que las intervenciones de conciencia sean «las menos eficaces». | Resumen en Crossref: «barely effective»; baja confianza por muestras pequeñas, estudios breves y contextos poco claros. | «apenas tuvieron efecto»; se corrigen los límites citados. |
| Lukoff et al. (2018) no comparan usos de igual duración. | Resumen: el uso habitual para pasar el tiempo, el entretenimiento y las redes sociales pasivas se asocian con menos sentido; hay «micro escapes» valorados. | Se describe el hallazgo real en los capítulos 5, 6 y 9. |
| Meier y Reinecke (2021) no proponen mirar «quién, qué y contexto». | Resumen: 34 revisiones; asociación negativa pequeña, con efectos que dependen de los indicadores. | Se describe el hallazgo real en los capítulos 5 y 6. |
| Waggoner et al. (2026) no piden comparar el objeto con una notificación. | Resumen: los métodos de UX deben adaptarse a contextos *phygital*. | La comparación se presenta como inferencia del proyecto. |
| El capítulo 12 afirmaba prototipos armados con componentes sueltos. | La [lista de materiales B1–B2](../99_archivo/antiguo/desarrollo-fisico/antecedentes-mesa-2026-08-30/lista-materiales-b1-b2.md) registra que el montaje de 12 V no se compró ni se construyó. | Se habla de montajes de mesa estudiados que no se construyeron. |
| El resumen llamaba «funcional» al prototipo. | La app compila y pasa pruebas, pero el recorrido no se ha probado en un teléfono real. | Se declara que falta esa prueba. |
| La memoria no decía que el tono de la app sigue hasta silenciarlo. | `SignalPlayer.kt` reproduce el tono hasta que el estado deja de ser «señal» y hace vibrar el teléfono una vez; el README de la app lo documenta. | El capítulo 11 y la tabla 5 lo declaran como diferencia con el pulso breve previsto. |
| El glosario y el capítulo 11 citaban «¿Cómo podrías empezar?» como texto de la app. | La app 2.6 pregunta «¿Cómo empezarás?». | Se corrige y la otra fórmula queda como alternativa por comparar. |
| La introducción y la justificación estaban bajo su extensión mínima. | 574 y 297 palabras frente a mínimos de 600 y 300. | Un párrafo de orientación y el aporte esperado las dejan en 656 y 328. |

También se precisaron Kirsh (1995), *The Tangible Reminder* y Smit et al. (2019), se explicaron términos al primer uso y se corrigieron el orden de dos referencias y dos entradas del glosario. El detalle está en el registro de cambios de la [memoria](memoria-vigente-v4.md). La extensión queda en 15.443 palabras.

## Cuarta revisión: fuentes, APA 7 y lenguaje claro

El autor pidió comprobar otra vez que las fuentes y las citas sean reales y correctas, que el APA 7 esté bien aplicado y que la comisión entienda todo sin términos complejos.

**Método.** Se consultaron de nuevo en Crossref los 33 DOI y se compararon autores, año, título, revista, volumen, número y páginas. Se abrieron las 31 direcciones web y se comparó el título de cada página. Las cifras atribuidas se contrastaron con los resúmenes oficiales (Crossref y OpenAlex) o con el texto completo de acceso abierto: Lyngs et al. (2019) en arXiv, Tonietto et al. (2021) en la versión de los autores y el informe de Subtel en su PDF oficial. Un script comprobó que cada cita tenga su referencia con el mismo año y que las 64 referencias estén citadas.

| Hallazgo | Evidencia | Corrección |
| --- | --- | --- |
| La dirección de Apple llevaba a la página de horarios de Tiempo de uso, no a la página citada. | La página `iphb0c7313c9` se titula *Set Screen Time Schedules and Time Allowances*; la guía general es `iphbfa595995`, hoy titulada *Set up Screen Time for yourself on iPhone*. | Dirección, título y fecha de consulta actualizados. |
| Lyngs et al. (2019) se describían con proporciones vagas. | Texto completo: 74 % de las herramientas bloqueaba o quitaba distracciones y 35 % ayudaba a avanzar hacia una meta. | «Tres de cada cuatro» y «alrededor de un tercio». |
| Pause Point «ofrecía elegir otra actividad». | El anuncio sugiere respirar, fijar un temporizador, mirar fotos o pasar a otra aplicación, como un audiolibro. | Se describe con esas opciones. |
| *The Tangible Reminder* se describía para «citas y plazos». | El resumen habla de citas y avisos de eventos próximos. | Se retira «plazos». |
| Lally et al. (2010) se citaba con «automaticidad» sin explicar. | Mediana de 66 días y rango de 18 a 254 días para alcanzar el 95 % del nivel máximo de automatismo. | Se explica en palabras simples con el rango. |
| Autor del repositorio BleenyButton. | GitHub y el sitio de la fundación usan «AsTeRICS Foundation». | Se corrige el nombre. |
| Keller et al. (2002). | PubMed registra las páginas 80–86 y 125. | Se añade la página 125. |
| Monge Roffarello y De Russis (2023). | ACM registra el artículo 53. APA 7 usa el número de artículo en lugar del rango de páginas. | Se retira «1–66». |
| Sohn et al. (2005). | APA 7 no pide la serie editorial en capítulos de libros. | Se retira «Lecture Notes in Computer Science, Vol. 3660». |
| Seeed Studio (2026). | La página indica su última actualización el 16 de septiembre de 2026. | Se agrega la fecha completa. |
| Tablas y figura. | APA 7 pone el número en negrita y el título en cursiva. | Se aplican las negritas. |

Todas las demás referencias coinciden con sus fuentes. Las cifras citadas (1.315 personas, 34 revisiones, 28 intervenciones, 1.039 usuarios, 526 participantes, 63 de 138, 96,6 % y 99,1 %) aparecen en las fuentes. La convención `y` en citas narrativas y `&` en citas entre paréntesis y en la lista se mantiene según APA 7.

**Lenguaje.** Se revisó el texto completo para un lector sin formación en psicología, informática o investigación. Se reemplazaron o explicaron, entre otros, «heterogénea», «corpus», «inferir», «representatividad estadística», «causalidad», «precompromiso» (que aparecía antes de su definición), «fricción» (que aparecía en la justificación antes de definirse), «automaticidad», «habituación», «seudónimos», «compila», «emulador», «iteración correctiva», «intrusión», «capa» y «trazabilidad». La extensión sube a 16.174 palabras, dentro del rango institucional.

## Problemas pendientes y su estado

1. **Libros completos con derechos de autor en un repositorio público.** Resuelto en la rama el mismo día: se retiraron los PDF de Norman, Isaacson, Albers y Munari, porque ninguno tiene una edición gratuita legal; se conservan los resúmenes propios (D-066). Los archivos siguen en el historial de Git; eliminarlos por completo exige reescribir el historial de `main`.
2. **Correo en documentos públicos.** El autor confirmó que su correo es el contacto correcto del estudio. No requiere cambios.
3. **Registro de decisiones atrasado.** Resuelto: se añadieron D-063 a D-066 y se marcó D-058 (iTag) como no ejecutada.
4. **Recursos de terceros sin procedencia.** Los marcos de iPhone y Pixel del tablero de wireframes y la fotografía de la referencia visual 03 no tienen origen registrado; se documentó el problema en sus README.
5. **Precios y disponibilidad comercial.** Los precios citados en el capítulo 8 son observaciones de agosto de 2026. Coinciden con los sitios actuales en los casos de Brick y Focusaur, pero no se pueden verificar hacia atrás.
6. **Similitud textual.** Si la institución exige un informe de similitud (por ejemplo, Turnitin), debe ejecutarse sobre la versión final diagramada.
7. **Luz y sonido.** Resuelto: el autor decidió que el objeto emita solo sonido (D-070 ampliada y D-078), y la memoria lo describe así. Como el feedback del 2 de septiembre pidió luz y sonido (F02-17) y algunas personas entrevistadas pidieron señales visuales, la memoria lo declara como límite.
8. **Frase de marca.** El capítulo 11 conserva la frase vigente de D-062; si se aprueba D-073, debe reemplazarse.
9. **Denominación del título y palabras clave.** La portada sigue pidiendo confirmar la denominación oficial y la mención. La pauta de la Biblioteca pide destacar de 2 a 3 términos en el resumen; la memoria, como sus versiones anteriores, usa cuatro palabras clave.

## Registro de cambios (disclaimer)

### 2026-09-25 — Cuarta revisión

- **Qué cambió:** se agregó la cuarta revisión, con fuentes vueltas a verificar, correcciones de APA 7 y lenguaje claro. El pendiente sobre luz y sonido pasa a resuelto.
- **Cómo estaba antes:** el documento terminaba en la tercera revisión y decía que la memoria seguía describiendo luz y sonido.
- **Por qué:** el autor pidió comprobar fuentes, citas y APA 7, y que la comisión entienda el texto; la memoria ya describe una señal solo sonora.

### 2026-09-25 — Tercera revisión

- **Qué cambió:** se añadió la revisión página por página, con sus nueve hallazgos, y tres pendientes: luz y sonido, frase de marca, y denominación del título con palabras clave.
- **Cómo estaba antes:** el informe cubría la verificación de fuentes y la revisión según la pauta UDP; varias paráfrasis se habían dado por conformes sin contrastarlas con el resumen de la fuente.
- **Por qué:** el autor pidió revisar cada página para que la memoria no invente nada ni tenga errores.

### 2026-09-25 — Profesores guía

- **Qué cambió:** se indica que los profesores guía ya figuran en la portada.
- **Cómo estaba antes:** el profesor guía aparecía como pendiente.
- **Por qué:** el autor señaló que los nombres constaban en versiones anteriores de la memoria.

### 2026-09-25 — Estado de los pendientes

- **Qué cambió:** la lista de problemas indica cuáles se resolvieron (libros retirados, registro de decisiones) y cuáles siguen abiertos; el correo se retiró como problema por confirmación del autor. La memoria quedó en 15.137 palabras tras actualizar la tabla de soporte del capítulo 11.
- **Cómo estaba antes:** los cinco problemas aparecían sin resolver.
- **Por qué:** el autor pidió retirar los libros sin licencia gratuita y actualizar los documentos obsoletos.

### 2026-09-25 — Creación

- **Qué se añadió:** informe de la revisión completa de la memoria v4: verificación de las 64 referencias, contraste con el corpus P1–P8 y con Android 2.6, correcciones de redacción y problemas pendientes.
- **Cómo estaba antes:** la última comprobación bibliográfica (23 de septiembre) verificaba la correspondencia entre citas y lista, pero no la existencia ni los datos de cada fuente frente a su registro oficial; la última revisión textual completa era del 31 de agosto.
- **Por qué:** el autor pidió leer la memoria completa, corregir fallas, mejorar la escritura y comprobar que todas las fuentes sean reales y que no haya material tomado indebidamente.
