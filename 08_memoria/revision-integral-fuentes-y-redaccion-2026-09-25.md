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

## Problemas pendientes y su estado

1. **Libros completos con derechos de autor en un repositorio público.** Resuelto en la rama el mismo día: se retiraron los PDF de Norman, Isaacson, Albers y Munari, porque ninguno tiene una edición gratuita legal; se conservan los resúmenes propios (D-066). Los archivos siguen en el historial de Git; eliminarlos por completo exige reescribir el historial de `main`.
2. **Correo en documentos públicos.** El autor confirmó que su correo es el contacto correcto del estudio. No requiere cambios.
3. **Registro de decisiones atrasado.** Resuelto: se añadieron D-063 a D-066 y se marcó D-058 (iTag) como no ejecutada.
4. **Recursos de terceros sin procedencia.** Los marcos de iPhone y Pixel del tablero de wireframes y la fotografía de la referencia visual 03 no tienen origen registrado; se documentó el problema en sus README.
5. **Precios y disponibilidad comercial.** Los precios citados en el capítulo 8 son observaciones de agosto de 2026. Coinciden con los sitios actuales en los casos de Brick y Focusaur, pero no se pueden verificar hacia atrás.
6. **Similitud textual.** Si la institución exige un informe de similitud (por ejemplo, Turnitin), debe ejecutarse sobre la versión final diagramada.

## Registro de cambios (disclaimer)

### 2026-09-25 — Estado de los pendientes

- **Qué cambió:** la lista de problemas indica cuáles se resolvieron (libros retirados, registro de decisiones) y cuáles siguen abiertos; el correo se retiró como problema por confirmación del autor. La memoria quedó en 15.137 palabras tras actualizar la tabla de soporte del capítulo 11.
- **Cómo estaba antes:** los cinco problemas aparecían sin resolver.
- **Por qué:** el autor pidió retirar los libros sin licencia gratuita y actualizar los documentos obsoletos.

### 2026-09-25 — Creación

- **Qué se añadió:** informe de la revisión completa de la memoria v4: verificación de las 64 referencias, contraste con el corpus P1–P8 y con Android 2.6, correcciones de redacción y problemas pendientes.
- **Cómo estaba antes:** la última comprobación bibliográfica (23 de septiembre) verificaba la correspondencia entre citas y lista, pero no la existencia ni los datos de cada fuente frente a su registro oficial; la última revisión textual completa era del 31 de agosto.
- **Por qué:** el autor pidió leer la memoria completa, corregir fallas, mejorar la escritura y comprobar que todas las fuentes sean reales y que no haya material tomado indebidamente.
