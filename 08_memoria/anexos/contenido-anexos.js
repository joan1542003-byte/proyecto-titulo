// Contenido de los anexos A–I de la memoria v5. Cada anexo se arma con partes:
//   { titulo, fuente, tomar: [encabezados], quitar: [encabezados] }  → secciones de un documento del repositorio
//   { titulo, md }                                                     → texto escrito para el anexo
//   { titulo, generar: 'versiones' | 'consentimiento' }                → contenido calculado desde el repositorio
//   { titulo, referencias: [{ fuente, tomar }] }                       → referencias de varios documentos, sin repetir
// Los encabezados se buscan por su texto, sin la numeración (el comienzo basta). Las rutas son relativas a la raíz
// del repositorio. `reemplazar` corrige una remisión que cambia fuera de su documento: cada texto debe aparecer.
// Las fichas [[GALERIA]], [[LOGO]], [[PALETA]], [[CIELOS]] e [[ICONOS]] se dibujan en el HTML y el PDF.

const portada = {
  titulo: 'Anexos',
  bajada: 'Memoria de Proyecto de Título · Escuela de Diseño UDP',
  descriptor: 'Un sistema phygital para volver a lo que querías hacer',
  fecha: 'Octubre de 2026',
};

const anexos = [
  {
    letra: 'A', slug: 'entrevistas', color: 'sky',
    titulo: 'Entrevistas: pauta, corpus y análisis',
    resumen: 'La pauta de 13 preguntas, la síntesis anonimizada de las ocho entrevistas y su análisis.',
    intro: 'Las ocho entrevistas semiestructuradas se hicieron en Santiago el 11 y el 12 de junio de 2026. Este anexo reúne la pauta y sus condiciones, el corpus anonimizado (P1–P8, Q1–Q13) y los documentos del análisis: el método, el libro de códigos, la reconstrucción de cada caso y la comparación entre casos que sostiene el capítulo 7.',
    partes: [
      { titulo: 'A.1 Pauta y condiciones del levantamiento', fuente: '99_archivo/fuentes-locales/instrumentos/instrumento-aplicado.md', tomar: ['Resultado confirmado', 'Ficha metodológica', 'Secuencia principal aplicada', 'Bloque adicional aplicado', 'Alcance y límites'] },
      { titulo: 'A.2 Corpus anonimizado P1–P8', fuente: '03_usuarios/corpus-anonimizado.md' },
      { titulo: 'A.3 Método de análisis', fuente: '03_usuarios/metodo-de-analisis.md', tomar: ['Condiciones del corpus', 'Decisión metodológica', 'Unidad de análisis', 'Niveles de confianza', 'Protocolo de calidad'] },
      { titulo: 'A.4 Libro de códigos', fuente: '03_usuarios/libro-de-codigos.md' },
      { titulo: 'A.5 Reconstrucción de cada caso', fuente: '03_usuarios/reconstrucciones-de-caso.md' },
      { titulo: 'A.6 Comparación entre casos y tipos de usuario', fuente: '03_usuarios/comparacion-y-tipos-de-usuario.md', quitar: ['Criterio de revisión'] },
    ],
  },
  {
    letra: 'B', slug: 'encuesta', color: 'butter',
    titulo: 'Encuesta: 53 respuestas',
    resumen: 'Las 16 preguntas, el método, los recuentos y la codificación de cada respuesta.',
    intro: 'La encuesta en línea contrastó los hallazgos de las entrevistas con 53 respuestas analizadas. Se informa en recuentos y categorías, sin citas textuales; la codificación por respuesta permite rehacer cada cifra que usa la memoria.',
    partes: [
      { titulo: 'B.1 Encuesta en línea', fuente: '03_usuarios/encuesta-53-respuestas-2026-09.md' },
    ],
  },
  {
    letra: 'C', slug: 'referentes', color: 'lime',
    titulo: 'Estado del arte y referentes',
    resumen: 'El registro de la búsqueda, las fichas de cada referente y la exploración de patentes.',
    intro: 'Documenta cómo se buscaron y compararon los productos y antecedentes del capítulo 8: la pregunta, los términos, las fuentes y los criterios de la búsqueda; las fichas comparativas de cada referente, y la exploración acotada de patentes.',
    partes: [
      { titulo: 'C.1 Registro de la búsqueda', fuente: '04_mercado_y_referentes/registro-busqueda-2026-08-24.md' },
      { titulo: 'C.2 Fichas de los referentes', fuente: '04_mercado_y_referentes/fichas-mercado-2026-08-24.md' },
      { titulo: 'C.3 Patentes y coincidencias', fuente: '04_mercado_y_referentes/investigacion-frontera-y-coincidencias.md', tomar: ['Respuesta breve', 'Patentes y riesgo de coincidencia', 'Vacío defendible y decisión para Relevo', 'Referencias primarias consultadas'] },
    ],
  },
  {
    letra: 'D', slug: 'criterios', color: 'blush',
    titulo: 'Trazabilidad de los criterios de diseño',
    resumen: 'Cada criterio con la evidencia que lo sustenta, cómo lo aplica Relevo, qué mostró la prueba y qué sigue.',
    intro: 'Relaciona cada uno de los ocho criterios del capítulo 9 con su evidencia —revisión bibliográfica, entrevistas y encuesta—, con la forma en que el prototipo lo aplica y con lo que mostró la prueba en casa hasta el 19 de octubre de 2026.',
    partes: [
      { titulo: 'D.1 Matriz de trazabilidad', md: `| Criterio | Evidencia | Cómo lo aplica Relevo | En la prueba y lo que sigue |
| --- | --- | --- | --- |
| **1. Partir de una intención propia** | Lukoff et al. (2018); Meier y Reinecke (2021); contraste de P2 y P3 con P6, P7 y P8. | La persona elige o escribe su actividad; la app no la deduce del uso. | Cada persona eligió las suyas: estudiar, ordenar su pieza, dibujar y tocar guitarra. |
| **2. Relacionar la intención con un primer paso** | Gollwitzer y Sheeran (2006); P2 (Q10); en la encuesta, 42 de las 43 personas que deseaban otra actividad nombraron un primer paso. | Dos pasos de la preparación: «¿Cómo empiezas?» y «¿Dónde empiezas?». | Recordaron el primer paso en las 21 respuestas. Sigue: distinguir un primer paso propuesto por la app de uno escrito por la persona. |
| **3. Usar una condición comprensible** | Google (2026c), consulta del uso de cada app con permiso; en la encuesta, 18 de 53 valoraron usar el teléfono para aprender o resolver algo. | El tiempo en las apps que la persona elige, con un límite que ella fija y cambia. | Límites de 15 a 45 minutos, elegidos por cada persona; una bajó el suyo de 45 a 35. |
| **4. Abrir una elección, no imponer una conducta** | Radtke et al. (2022); Grüning et al. (2023); Silverman y Barasch (2023). | La señal no bloquea nada; las tres respuestas pesan lo mismo; sin rachas ni premios. | De 21 respuestas: empezaron la actividad en 10, la dejaron para después en 9 y cambiaron de idea en 2. |
| **5. Reconocer cuándo no intervenir** | Tonietto et al. (2021); P6 y P7; P4, P6 y P8. | Sin una intención activa, Relevo no suena; la activación automática es opcional y empieza apagada. | Las tres personas activaron a mano sus 31 relevos. |
| **6. Mantener una carga proporcional** | Chiu y Gilbert (2024); en la encuesta, 7 de 53 descartarían Relevo por prepararlo y mantenerlo. | Cinco pasos de un toque; «Preparar de nuevo» repite el último relevo. | Lo miden las escalas semanales y la entrevista de cierre. |
| **7. Proteger la privacidad y la convivencia** | P1, P3–P5, P7 y P8 (Q13); en la encuesta, 7 de 53 por ruido y convivencia, y 12 aceptarían solo un registro local o ninguno. | El objeto no muestra la intención; los datos van con un código y se borran desde la app. | Una persona encontró el pitido fuerte para su departamento compartido: respalda el volumen regulable que pide el testigo propio. |
| **8. Demostrar el valor de la capa física** | O’Rear y Radvansky (2019); Hermann et al. (2007). | Tres condiciones implementadas: junto al primer paso, en un lugar neutro y en el teléfono. | El Tag sonó en 23 de 24 ciclos. Sigue: la comparación; la primera semana con el teléfono comenzó el 20 de octubre. |

*Fuentes:* criterios y evidencia, capítulo 9 de la memoria; soporte implementado, capítulo 11; resultados, capítulo 13.` },
    ],
  },
  {
    letra: 'E', slug: 'ia', color: 'lilac',
    titulo: 'Uso de inteligencia artificial',
    resumen: 'Qué herramientas se usaron, en qué ayudaron y qué decidió el autor.',
    intro: 'Declara qué herramientas de inteligencia artificial se usaron, en qué tareas ayudaron y qué decidió el autor en cada caso. El registro de cada pedido, que se lleva a diario desde el 29 de septiembre de 2026, no se imprime aquí: está abierto en el repositorio del proyecto.',
    partes: [
      { titulo: 'E.1 Declaración', fuente: '00_gobernanza/uso-de-ia-2026-10-27.md' },
      { titulo: 'E.2 Ficha para cada producción con IA', fuente: '00_gobernanza/trazabilidad-uso-ia-2026-09-23.md', tomar: ['Ficha obligatoria para futuras producciones con IA'] },
    ],
  },
  {
    letra: 'F', slug: 'estados', color: 'peach',
    titulo: 'Estados del ciclo y wireframes',
    resumen: 'Los 35 estados del ciclo con sus wireframes de agosto y los wireframes de las 39 pantallas de la app.',
    intro: 'Muestra cómo se diseñó el recorrido completo. Primero, la cobertura de 35 estados definida en agosto de 2026 para un testigo con control físico, con sus wireframes. Después, los wireframes de las 39 pantallas de la app de octubre, ordenados por recorrido.',
    partes: [
      { titulo: 'F.1 Cobertura de los estados del ciclo', fuente: '05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md', tomar: ['Propósito', 'Reglas que delimitan la cobertura', 'Matriz de wireframes', 'Criterio de lectura'] },
      { titulo: 'F.2 Wireframes de agosto de 2026', md: `Catorce láminas del recorrido con el testigo y su control físico: configuración, vinculación, prueba, armado, espera, señal, cierre y recuperación.

[[GALERIA 2|08_memoria/anexos/imagenes/agosto-A1-configuracion.jpg:A1 Configuración|08_memoria/anexos/imagenes/agosto-A2-configuracion.jpg:A2 Configuración|08_memoria/anexos/imagenes/agosto-B1a-vinculacion.jpg:B1a Vinculación|08_memoria/anexos/imagenes/agosto-B1b-vinculacion.jpg:B1b Vinculación|08_memoria/anexos/imagenes/agosto-B2a-prueba.jpg:B2a Prueba|08_memoria/anexos/imagenes/agosto-B2b-prueba.jpg:B2b Prueba|08_memoria/anexos/imagenes/agosto-C1-armado.jpg:C1 Armado|08_memoria/anexos/imagenes/agosto-C2-armado.jpg:C2 Armado|08_memoria/anexos/imagenes/agosto-D1-espera.jpg:D1 Espera|08_memoria/anexos/imagenes/agosto-D2-senal.jpg:D2 Señal|08_memoria/anexos/imagenes/agosto-E1-cierre.jpg:E1 Cierre|08_memoria/anexos/imagenes/agosto-E2-recuperacion.jpg:E2 Recuperación|08_memoria/anexos/imagenes/agosto-E3-recuperacion.jpg:E3 Recuperación|08_memoria/anexos/imagenes/agosto-E4-finales.jpg:E4 Estados finales]]` },
      { titulo: 'F.3 Wireframes de la app (octubre de 2026)', clase: 'nueva-pagina', md: `Las 39 pantallas de la versión 2.32 en muy baja fidelidad, con sus textos reales, en cinco recorridos. Se dibujaron pieza por pieza sobre una retícula común, a partir de la posición de cada elemento en el emulador.

[[GALERIA 1|06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/1-primera-vez.png:1. La primera vez|06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/2-preparar-un-relevo.png:2. Preparar un relevo|06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/3-contar-sonar-y-decidir.png:3. Contar, sonar y decidir|06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/4-inicio-ruta-y-perfil.png:4. Inicio, ruta y perfil|06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/5-perfil.png:5. Perfil]]` },
    ],
  },
  {
    letra: 'G', slug: 'android', color: 'sky',
    titulo: 'Prototipo Android y registro de versiones',
    resumen: 'Cómo funciona la app, su arquitectura, sus datos y cada versión desde la 2.7.',
    intro: 'Describe el prototipo funcional: la app Android, su conexión con el Tag, la base de datos de la prueba y el panel, con el registro de las versiones desde la 2.7, la primera preparada para la prueba de 21 días. La descripción técnica es la del 18 de octubre de 2026; la versión 3.3 suma la semana para comparar sobre la misma arquitectura.',
    partes: [
      { titulo: 'G.1 La app en la versión 3.3', md: `Capturas de la app en un teléfono Android: elegir qué hacer, dejar el relevo listo, la señal, las preguntas de un toque y la decisión.

[[GALERIA 5|08_memoria/anexos/imagenes/app-3.3-1-inicio.jpg:Inicio|08_memoria/anexos/imagenes/app-3.3-2-todo-listo.jpg:Todo listo|08_memoria/anexos/imagenes/app-3.3-4-suena.jpg:Suena|08_memoria/anexos/imagenes/app-3.3-5-preguntas.jpg:Cuatro preguntas|08_memoria/anexos/imagenes/app-3.3-6-decidir.jpg:¿Qué decidiste?]]` },
      { titulo: 'G.2 El sistema completo', fuente: '06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/relevo-frontend-y-backend.md', tomar: ['El sistema completo'] },
      { titulo: 'G.3 La app', fuente: '06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/relevo-frontend-y-backend.md', tomar: ['Frontend: la app Android'] },
      { titulo: 'G.4 Los datos y el panel', fuente: '06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/relevo-frontend-y-backend.md', tomar: ['Backend: datos remotos y panel'] },
      { titulo: 'G.5 Registro de versiones', generar: 'versiones' },
    ],
  },
  {
    letra: 'H', slug: 'identidad', color: 'lime',
    titulo: 'Identidad visual y sistema de marca',
    resumen: 'El logo, las letras, los íconos y el color, cada uno con su fundamento, y las propuestas que los precedieron.',
    intro: 'Documenta la identidad aprobada en octubre de 2026 y cómo se llegó a ella: el logo de cuatro luces, las dos letras, los 72 íconos propios y el color por función, cada decisión con su fuente; lo que se mantiene de la marca del 16 de septiembre, y las propuestas anteriores.',
    partes: [
      { titulo: 'H.1 El logo', md: '[[LOGO]]' },
      { fuente: '10_recursos_visuales/40_logo-colores-y-recorrido-2026-10-11.md', tomar: ['Concepto', 'Construcción', 'Versiones y reglas de uso'] },
      { fuente: '10_recursos_visuales/41_fundamento-del-color-texto-academico-2026-10-11.md', tomar: ['La marca'], titular: 'Fundamento', reemplazar: [['(Figura 1)', '(Figura 2 de la memoria)']] },
      { titulo: 'H.2 Las dos letras', md: `La identidad usa dos letras sin serifa: una para el nombre y otra para todo lo demás.

| Letra | Uso | Autoría y licencia | Por qué |
| --- | --- | --- | --- |
| **Chillax Semibold** | El logotipo, convertido a trazos. | Indian Type Foundry, en Fontshare; ITF Free Font License. | Sus formas son redondas como las luces y en tamaño chico no pierde la forma. |
| **Instrument Sans** | La app, la memoria, estos anexos y las láminas. | Rodrigo Fuenzalida, diseñador radicado en Santiago, y Jordan Egstad; Google Fonts, SIL Open Font License. | Una grotesca con ejes de peso y ancho, legible en pantalla y en papel; el trazo de los íconos se midió sobre su asta. |` },
      { fuente: '10_recursos_visuales/40_logo-colores-y-recorrido-2026-10-11.md', tomar: ['Letra'], titular: 'Cómo se eligió la letra del logotipo' },
      { titulo: 'H.3 Los íconos', md: '[[ICONOS]]' },
      { fuente: '10_recursos_visuales/39_iconos-y-color-con-fundamento-2026-10-11.md', tomar: ['Cómo se eligieron', 'Construcción'] },
      { titulo: 'H.4 El color', md: '[[PALETA]]' },
      { fuente: '10_recursos_visuales/41_fundamento-del-color-texto-academico-2026-10-11.md', tomar: ['El color como función', 'Evidencia sobre asociaciones entre color y emoción', 'Criterios de diseño', 'Los papeles de Relevo'] },
      { md: '[[CIELOS]]' },
      { fuente: '10_recursos_visuales/41_fundamento-del-color-texto-academico-2026-10-11.md', tomar: ['Las actividades', 'Verificación y límites'] },
      { titulo: 'H.5 Lo que se mantiene de la marca del 16 de septiembre', fuente: '10_recursos_visuales/14_sistema-de-marca-vigente.md', tomar: ['Nombre', 'Frase de marca', 'Descriptor funcional'] },
      { titulo: 'H.6 Propuestas anteriores', md: `La identidad se buscó en propuestas sucesivas, revisadas por el autor. Cada una dejó algo en la identidad final.

| Fecha | Propuesta | Qué proponía | Qué pasó |
| --- | --- | --- | --- |
| 16 sep. | Sistema de marca del proyecto (D-062) | Nombre, descriptor, frase, letra, paleta y logotipo. | Se mantienen el nombre, el descriptor y la frase; la letra, la paleta y el logotipo se reemplazaron en octubre. |
| 25 sep. | Punto y pulso (D-067) | Una identidad a partir de un punto que late. | Reemplazada el mismo día por pedido del autor. |
| 25 sep. | «Antes de que sea después» (D-072) | Una plataforma de marca sobre el momento en que aún se puede elegir. | Reemplazada por D-073: el autor la juzgó confusa para la comisión. |
| 25 sep. | «Vuelve a lo que querías hacer» (D-073) | El mismo centro, en palabras directas. | Se aplicó en la app de la 2.8 a la 2.30. |
| 27 sep. | Sistema de marca 2.0 en Figma (D-085) | Variables, componentes y pantallas en Figma. | Superada por las propuestas de fines de septiembre. |
| 30 sep. | El subrayado (D-098) | Una identidad alrededor de un renglón azul. | Decidida en parte; el renglón quedó como línea de escritura. |
| 2 oct. | Sistema de diseño 3.1 (D-099) | Un renglón que hace lugar, dos voces y los colores de la casa. | Base de las propuestas 3.2 a 3.5. |
| 3 oct. | Relevo vivo, Volver a enfocar, Las ganas estaban y Cuándo va color (D-100 a D-103) | Color vivo, letra manuscrita, serif y reglas de cuándo usar color. | El autor descartó la letra manuscrita y la serif; quedó la regla de cuándo va color. |
| 3 oct. | El traspaso (D-104) | La marca como el paso del testigo. | La idea del traspaso sigue en el logo de cuatro luces. |
| 4 oct. | Letras para el logotipo (D-105 a D-108) | Una búsqueda amplia de letras display. | Llevó a elegir Chillax en el logo del 11 de octubre (D-125). |
| 10–11 oct. | Relevo con aura (D-121 a D-127) | Aura, fichas por papel, íconos propios, cielos y el logo de cuatro luces. | **Aprobada:** es la identidad actual, aplicada en la app desde la 3.0. |` },
      { titulo: 'H.7 Referencias visuales del autor', fuente: '10_recursos_visuales/39_iconos-y-color-con-fundamento-2026-10-11.md', tomar: ['Lo que se tomó de las referencias del autor'] },
      { titulo: 'Referencias del anexo', referencias: [
        { fuente: '10_recursos_visuales/40_logo-colores-y-recorrido-2026-10-11.md', tomar: ['Referencias'] },
        { fuente: '10_recursos_visuales/39_iconos-y-color-con-fundamento-2026-10-11.md', tomar: ['Referencias'] },
        { fuente: '10_recursos_visuales/41_fundamento-del-color-texto-academico-2026-10-11.md', tomar: ['Referencias nuevas para la memoria'] },
      ] },
    ],
  },
  {
    letra: 'I', slug: 'prueba', color: 'butter',
    titulo: 'Protocolo de la prueba, consentimiento e instrumentos',
    resumen: 'El protocolo de 21 días, la semana para comparar, el consentimiento vigente, las preguntas de la app y las fichas de registro.',
    intro: 'Reúne lo necesario para repetir la prueba: el protocolo de 21 días con sus condiciones, procedimiento y reglas de decisión; la semana para comparar de la versión 2.33; el texto del consentimiento vigente desde el 6 de octubre de 2026; las preguntas de la app, y las fichas de la sesión inicial y del cierre.',
    partes: [
      { titulo: 'I.1 Protocolo de la prueba de 21 días', md: `El protocolo se preparó el 25 de septiembre de 2026 para seis personas, una por cada orden posible de las tres condiciones, con un parlante como objeto provisional. La primera etapa lo aplica desde octubre de 2026 con tres personas que usan un Tag junto al primer paso (capítulo 13 de la memoria), y la semana para comparar de la versión 2.33 suma la condición del teléfono. Las condiciones y las reglas de decisión no cambiaron; las preguntas que hace hoy la app están en I.3.` },
      { fuente: '07_validacion/protocolo-02-prueba-21-dias.md', tomar: ['Qué responde', 'Procedimiento', 'Reglas de decisión', 'Fallos críticos', 'Datos y conservación', 'Semana para comparar'] },
      { titulo: 'I.2 Consentimiento vigente (6 de octubre de 2026)', generar: 'consentimiento' },
      { titulo: 'I.3 Preguntas de la app', md: `Todas se responden con un toque y se pueden saltar.

**Después de cada señal** («Cuatro preguntas de un toque»):

1. ¿Notaste el aviso apenas sonó? — Enseguida · Un rato después · No lo noté. Desde la versión 2.33.
2. ¿Cómo te cayó el sonido? — Bien · Normal · Mal.
3. Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla? — Sí · A medias · No.
4. ¿Recordaste cómo empezar? — Sí · No.

Después: «¿Qué decidiste?» — Comencé la actividad · La dejé para después · Cambié de idea. Las tres respuestas tienen el mismo tamaño y el mismo color.

**Al final de cada semana** («¿Cómo te fue esta semana?»), con una escala de 1 («Nada») a 5 («Mucho»):

1. ¿Te costó preparar Relevo?
2. ¿Te molestó el sonido?
3. ¿El sonido tenía que ver con el lugar donde sonó?
4. ¿Algo más que quieras contarnos? Respuesta abierta.

**Al cierre de los 21 días** («¡Terminaste los 21 días!»):

1. ¿Seguirías usando Relevo? — Sí · Tal vez · No.
2. ¿Qué semana te ayudó más? — Suena donde empiezas · Suena en otro lugar · Suena en el teléfono · Ninguna.
3. ¿Qué te molestó?
4. ¿Qué cambiarías?
5. ¿Dónde quedó lo que sonaba la mayor parte del tiempo?

**En la semana para comparar** (desde la versión 2.33):

- Antes de empezar, «¿Cómo te fue hasta ahora?»: las tres escalas semanales sobre las semanas anteriores, con el objeto que ya usaba.
- El día 7, la tarjeta semanal suma «Comparado con las semanas anteriores, ¿esta semana te ayudó a recordar lo que querías hacer…» — Más · Igual · Menos, y «¿Por qué?».
- El cierre («¡Terminaste la prueba!») tiene siete preguntas:
  1. ¿Seguirías usando Relevo? — Sí · Tal vez · No.
  2. ¿Qué te ayudó más a recordar lo que querías hacer? — El objeto donde empiezo · El aviso en el teléfono · Los dos por igual · Ninguno.
  3. ¿Por qué?
  4. Si siguieras usando Relevo, ¿con qué te gustaría que sonara? — Un objeto · El teléfono · Me da igual.
  5. ¿Qué te molestó?
  6. ¿Qué cambiarías?
  7. ¿Dónde quedó el objeto la mayor parte del tiempo?

*Fuente:* pantallas de la app en las versiones 2.33 y 3.3.` },
      { titulo: 'I.4 Ficha de la sesión inicial', md: 'Es la plantilla del protocolo 01 que usa la sesión inicial del protocolo 02 desde el 25 de septiembre de 2026. Valen la identificación, la configuración, la cadena de asociación y la comprobación de autonomía; los campos de luz no aplican, porque la señal es solo sonora (D-070).' },
      { fuente: '07_validacion/ficha-registro-protocolo-01.md', tomar: ['Identificación de la sesión', 'Configuración', 'Fase A', 'Incidentes técnicos', 'Fallos críticos', 'Decisión de diseño'] },
      { titulo: 'I.5 Ficha en papel: escalas, cierre y entrevista', fuente: '07_validacion/instrumentos/ficha-escalas-y-cierre-2026-10-20.md', tomar: ['Por qué existe', 'Qué contiene'] },
    ],
  },
];

module.exports = { portada, anexos };
