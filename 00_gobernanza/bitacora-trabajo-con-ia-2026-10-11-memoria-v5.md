# Bitácora del trabajo con IA: borrador v5 de la memoria (11 de octubre de 2026)

**Estado:** registro de lo hecho con Claude Code el 11 de octubre de 2026 para revisar la memoria. Complementa la [bitácora del 8 al 11 de octubre](bitacora-trabajo-con-ia-2026-10-08-11.md). Los pedidos están en el [registro de pedidos](registro-de-pedidos-a-la-ia.md) y la aprobación, en D-123 del [registro de decisiones](../09_decisiones/registro-de-decisiones.md).

**Resultado:** [borrador v5 de la memoria](../08_memoria/borrador-memoria-v5-2026-10-11.md) y sus [notas](../08_memoria/notas-del-borrador-v5-2026-10-11.md), publicados en `main` y aprobados por el autor.

## 1. Qué se hizo

| Etapa | Trabajo | Resultado |
| --- | --- | --- |
| Comprensión | Nueve lectores, uno por área del repositorio (gobernanza, requisitos y feedback, usuarios, referentes, app y factibilidad, validación, decisiones, marca, controles de la memoria), contrastaron cada área con la memoria v4. | 204 hallazgos. El principal: la v4 quedó congelada el 29 de septiembre y describía la app 2.14 con un parlante y una prueba futura. |
| Referencias | Seis lotes verificaron las 64 referencias en su fuente (Crossref, editor, página viva) y cada afirmación que la memoria les atribuía. Tres auditorías más: APA 7 formal, estilo y una lectura como examinador. | 35 entradas correctas, 28 con errores menores y una con error grave; 58 afirmaciones más fuertes o distintas de lo que dice la fuente. |
| Redacción | Una pauta editorial común y ocho redactores por bloques de capítulos; después, lista de referencias, glosario y anexos a partir del texto. | 14 capítulos, 78 referencias, 11 tablas, 4 figuras como marcadores, anexos A–I. |
| Revisión | Ocho revisores independientes: APA, fidelidad a fuentes (dos), fidelidad al repositorio (tres), coherencia y estilo, y examinador en segunda vuelta. | 190 correcciones propuestas; se aplicaron salvo las que chocaban entre sí o cambiaban texto fijado por el autor. |
| Publicación | Subida a `main` con la cuenta del autor y documentación. | Commits `ee853e0` y el de esta bitácora. |

## 2. Decisiones tomadas durante el trabajo

Las tomó la IA al redactar y quedaron aprobadas con el borrador (D-123). Todas pueden revertirse.

- **Texto que no se tocó:** pregunta de investigación, hipótesis (D-091), los ocho criterios, los títulos y el orden de los capítulos 1 a 13, y los términos *testigo*, *pulso ambiental*, *ciclo* y *primer paso*. A la hipótesis y a la pregunta se les añadieron supuestos contrastables y subpreguntas, sin cambiar su redacción.
- **Objetivos:** solo cambió el específico 1, que ahora menciona la encuesta. Un revisor propuso «explorar» en lugar de «establecer» en el específico 3; no se aplicó.
- **Estructura:** «Conclusiones» pasa a ser el capítulo 14 y «Referencias» deja de numerarse. Apartados nuevos: enfoque metodológico y plan de trabajo, uso de inteligencia artificial, modelo de gestión, estado de avance, amenazas a la validez y consideraciones éticas.
- **El Tag como sustituto provisional del testigo**, no como objeto definitivo del proyecto. D-117 lo llama «el objeto del proyecto»; si esa es la intención, hay que reescribir los párrafos del testigo.
- **Datos que solo el autor conoce:** se dejaron 24 marcadores `[CONFIRMAR: …]` en vez de suponerlos. No se redactaron resultados de la prueba.
- **Formato:** números sin punto de millares (1315; 24 990) y «Ley 19628», según la norma académica del español y la Biblioteca del Congreso; términos definidos en cursiva y no en negrita; *phygital* siempre en cursiva; «diseño» en minúscula como disciplina; tres palabras clave.
- **Referencias:** las páginas con fecha visible llevan esa fecha y no «Recuperado el…»; las páginas de Android pasan a autor «Google»; la de Chrome pasa a Beaufort (2015); Peña-Albert con un solo guion; la entrada de Sanders (2026) como página web con sitio «Google». Entraron 16 fuentes nuevas verificadas y salieron dos que el texto ya no cita.
- **Fuentes sugeridas que no se citaron** por no poder verificarse a fondo: quedaron listadas en las notas del borrador.

## 3. Errores y correcciones

**Errores de la IA en esta sesión**

- **Clonó el repositorio sin preguntar.** El autor lo detuvo: el material es privado para él. Se borró la copia y el resto se leyó en línea. Para subir los archivos se hizo después una copia mínima (solo `08_memoria`, `00_gobernanza` y `09_decisiones`), con autorización del autor.
- **Un revisor envió el correo del autor a un servicio externo** (OpenAlex) como parámetro de contacto al verificar referencias. No se envió contenido de la memoria. Se prohibió en los pasos siguientes.
- **La primera subida llevaba una línea de coautoría de Claude** y quedó en una rama aparte. El autor pidió `main` y solo su cuenta: se rehízo el commit sin esa línea y se borró la rama.
- **La pauta editorial tenía tres hechos equivocados**, que los revisores detectaron contra el código y se corrigieron en el texto: decía que «todas» las versiones se recorrieron en emulador (no consta para la 2.26, la 2.27 y la 2.29); que tres correcciones resolvieron el sonido del Tag (tras la primera sonó en la prueba, pero el único ciclo real documentado falló); y que el resumen semanal venía apagado (viene encendido desde la 2.12).
- **La primera redacción quedó sobre el tope** de 20 000 palabras tras aplicar las correcciones; se recortó a 19 933 con el método del control.
- **El entorno guardó por su cuenta salidas largas** con fragmentos del repositorio en la carpeta de la sesión, en el equipo del autor.

**Errores de la memoria v4 que se corrigieron**

- Describía un objeto, una versión y un estado de la prueba que ya no eran los del proyecto.
- Seis personas, y no cinco, pidieron señales calmadas, discretas o visuales; Q3 a Q7, y no Q3 a Q10, tratan de la última sesión.
- No declaraba el uso de IA, ni que la clasificación de las respuestas abiertas de la encuesta la hizo una herramienta y está sin revisar.
- Afirmaba que one sec «no conserva otra actividad» y que el anuncio de Pause Point no precisaba dispositivos; ubicaba Brick Zone en la familia equivocada.
- Citaba a Meier y Reinecke (2021) y a Aaker (1996) para afirmaciones que esas fuentes no sostienen.
- Describía una tipografía y una paleta que ningún artefacto vigente usa.
- Tenía una nota de trabajo en la portada, siete enlaces a archivos del repositorio en el cuerpo y una «figura» que era una línea de texto.

**Hallazgos sobre el prototipo que la memoria ahora declara**

- La notificación de las semanas con objeto y de la sesión inicial muestra la actividad y «Empieza por…», lo que contamina lo que la prueba pregunta.
- La app incluye funciones de continuidad (ruta de pasos, conteo de comienzos, frecuencia semanal) que tensionan el criterio 4.
- El consentimiento no nombra el panel del investigador ni la plataforma donde opera; la copia remota se aloja en Canadá.

## 4. Qué se comprobó y qué no

- **Comprobado:** correspondencia exacta entre citas y referencias (por script y por dos revisores); los 44 DOI en Crossref; las cifras de la encuesta y las atribuciones a P1–P8 contra el repositorio; los hechos del prototipo contra las notas de versión y el código de la 2.30.
- **No comprobado:** el texto completo de varias fuentes de pago (solo su resumen); los precios del 7 de septiembre, que no pueden verificarse hacia atrás; nada de lo que depende de los 24 marcadores.

## 5. Pendientes

- Completar los 24 marcadores y los resultados de la prueba.
- Producir las cuatro figuras.
- Revisar la clasificación de la encuesta y el consentimiento con los profesores guía.
- Decidir la notificación de la señal y las funciones de continuidad durante la prueba.
- Actualizar los documentos que irán a los anexos y aún dicen «parlante» (protocolo 02, hoja de consentimiento).
- Cambiar la visibilidad del repositorio si debe ser privado: hoy es público.

## Registro de cambios (disclaimer)

### 2026-10-11 — Creación

- **Qué se añadió:** la bitácora de la revisión de la memoria: etapas, decisiones, errores y pendientes.
- **Cómo estaba antes:** el trabajo solo constaba en el registro de pedidos y en las notas del borrador.
- **Por qué:** el autor aprobó el borrador y pidió documentar los cambios, las decisiones y los errores.
