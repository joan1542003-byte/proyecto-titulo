# Traspaso de Relevo a Claude

> **Actualización del 25 de septiembre de 2026:** después de este corte, el autor decidió que el objeto no tendrá luz (D-070 ampliada), que la señal durará unos 30 segundos (D-078) y que la prueba con participantes será de 21 días en casa y responderá también la hipótesis ([protocolo 02](../07_validacion/protocolo-02-prueba-21-dias.md), D-075 y D-079). También registró decisiones sobre perfil, ruta, privacidad y refuerzo (D-074 a D-077). Consulta el [registro de decisiones](../09_decisiones/registro-de-decisiones.md) antes de usar lo que esta guía dice sobre luz, fase A o una prueba de dos días.

**Corte documental:** 24 de septiembre de 2026.
**Repositorio:** [`joan1542003-byte/proyecto-titulo`](https://github.com/joan1542003-byte/proyecto-titulo).
**Rama:** `main`. **Commit comprobado:** `ad12e100506d024f4043b38d3153a5a18403e4c5` (`Android 2.6: seleccion multiple, audio y privacidad`).
**Autor:** Johan Yantén, estudiante de Diseño, Universidad Diego Portales.

## Para qué sirve esta guía

Este documento permite que una nueva conversación con Claude retome Relevo sin depender de conversaciones previas. Reúne la definición del proyecto, el origen de sus decisiones, el estado real del producto, las fuentes prioritarias, las contradicciones conocidas y el orden recomendado de trabajo. No sustituye los documentos enlazados ni convierte los planes en resultados.

## Relevo en una explicación

Relevo es un proyecto de titulación de Diseño que estudia cómo ayudar a una persona a volver a considerar una actividad que ella misma quería hacer cuando continúa usando una aplicación de ocio digital. La app Android permite preparar esa intención, elegir una o más aplicaciones y definir un límite de uso acumulado. La propuesta phygital contempla un objeto situado cerca del lugar o elemento que facilita esa actividad y que emite una señal breve de luz y sonido. Después del aviso, la persona conserva la decisión: puede empezar, continuar con el teléfono, silenciar o cambiar de idea.

Relevo no es un bloqueador, tratamiento clínico, control parental, medidor de productividad ni programa de reducción de pantalla. No debe culpabilizar, premiar obediencia, convertir una respuesta declarada en conducta observada ni prometer creación de hábitos. Su valor depende de que la intención elegida vuelva a estar presente en una situación concreta y de que la forma física aporte algo que una notificación no aporta. Eso todavía necesita pruebas.

La frase vigente de marca es **«Hazle lugar a lo que quieres hacer»** y el descriptor funcional es **«Un recordatorio físico preparado desde el teléfono»**. El nombre `Relevo` está cerrado para el proyecto académico, no para una eventual explotación comercial.

## Cómo evolucionó la idea

1. **In(Visible):** el trabajo partía de registrar retrospectivamente el descanso y su relación con el teléfono. Aportó una postura no punitiva y atención a la experiencia física, pero suponía efectos sobre memoria y culpa con más certeza de la que permitía la evidencia.
2. **Relevo inicial:** el foco pasó a una pausa en la toma de decisiones durante el ocio digital.
3. **Relevo actual:** la intervención se concreta en una intención elegida, una forma de comenzar, una condición de activación y una señal asociada a un lugar. El lugar y el objeto forman parte de la experiencia y no son decoración de una app independiente.

El relato no debe adelantarse a la investigación: en la memoria se avanza del problema y sus aristas hacia justificación, antecedentes, teoría, usuarios, estado del arte, criterios y propuesta. La formulación del producto no debe abrir el texto antes de que el lector entienda por qué existe.

La memoria organiza el problema en tres aristas conectadas: **experiencial y cognitiva** (una intención alternativa puede no orientar la decisión inmediata), **tecnológica** (las interfaces y sus secuencias afectan cierres y oportunidades de elección) y **evaluativa** (el sentido del ocio no puede deducirse de su duración). Su marco teórico desarrolla la experiencia del ocio digital, el diseño de la atención y el recuerdo con objetos y lugares. Estas distinciones evitan reducir el tema a «falta de disciplina» o a un supuesto daño general del teléfono.

## Evidencia y alcance

### Entrevistas

Se realizaron ocho entrevistas semiestructuradas, habladas y presenciales en Santiago el 11 y 12 de junio de 2026. Las personas tenían entre 19 y 27 años; el criterio de convocatoria fue 18–30 y el reclutamiento se hizo por referencias de la red personal. Hubo consentimiento informado oral. El autor realizó las preguntas y repreguntas; la transcripción se apoyó en una herramienta automatizada. P6 tiene 27 años. No se registró la duración individual. Son datos cualitativos exploratorios, no una muestra representativa.

El material analítico operativo está anonimizado como P1–P8. La carpeta `03_usuarios` contiene corpus, libro de códigos, reconstrucciones, matriz, dos tipos situacionales, perfiles, recorridos y requisitos. La decisión vigente es trabajar con un usuario principal y un usuario límite, ambos situacionales y revisables, no como identidades demográficas estables. La encuesta de 70 personas sigue pendiente de publicar, revisar e integrar: no usarla como evidencia vigente hasta comprobar materiales, procedencia, consentimiento, anonimización y análisis.

### Mercado y sustento

El mercado y los antecedentes se estudian en `04_mercado_y_referentes`; el fundamento teórico y metodológico está en `02_investigacion`, `01_contexto_y_fuentes` y la memoria. La oportunidad planteada es explorar una alternativa a contar, bloquear o interrumpir desde la pantalla: una señal voluntaria vinculada a una actividad y situada en el contexto donde podría empezar. No se debe afirmar que Relevo sea único ni eficaz sin comparación empírica.

El análisis de usuarios concluyó que conviene modelar un **usuario principal** y un **usuario límite**. El principal describe episodios en que hay una intención valorada que pierde capacidad de orientar la siguiente acción; el límite describe ocio que la persona elige y valora, donde intervenir no corresponde. Ambos patrones pueden aparecer en una misma persona según el episodio. El límite protege la autonomía y ayuda a diseñar cuándo Relevo debe permanecer en silencio.

Toda fuente debe indicar qué afirma, método y límites, y qué decisión informa. Preferir publicaciones desde 2019, sin excluir fuentes clásicas necesarias. En la memoria usar APA 7 en español y no referirse a talleres o encargos internos.

## Qué existe realmente a la fecha de corte

### Aplicación Android 2.6

El APK de depuración vigente se encuentra en `06_desarrollo_y_factibilidad/app-android/releases/relevo-android-2.6-2026-09-24.apk`. El proyecto portable de Android Studio está en `relevo-android-studio-2.6-2026-09-24.zip`. Es un prototipo para Android 12 o posterior (`API 31`, identificador `cl.udp.relevo`), no una app publicada ni validada con participantes.

La versión 2.6 permite configurar una actividad propia o preestablecida, seleccionar varias apps instaladas, sumar su tiempo de primer plano a un único límite, elegir una salida de audio (parlante Bluetooth multimedia o teléfono), probar la señal, seguir una sesión con notificación persistente, silenciar/cerrar, revisar historial y declarar opcionalmente qué decidió hacer. Incluye consentimiento previo, tutorial, permisos explicados, acceso a privacidad y solicitud de eliminación local/remota. Las notificaciones de la app son opcionales; el permiso de acceso a Tiempo de uso es necesario para contar las apps elegidas.

**Verificado:** compilación, diez pruebas unitarias y revisión visual en emulador de consentimiento, tutorial, Inicio y configuración con dos apps.
**Todavía no verificado:** sumar alternadamente el tiempo de varias apps en un teléfono real; ciclo completo; reproducción por Bluetooth; fallo y recuperación con dispositivos reales; envío de eventos a Supabase; borrado extremo a extremo. La base remota tenía sesiones y cero eventos en la revisión del 24 de septiembre. No hay resultados de pruebas de uso con personas.

La app y el objeto final no son equivalentes: el APK actual puede dirigir un tono a un parlante Bluetooth existente, que no es un dispositivo exclusivo de Relevo y puede reproducir audio de otras apps. Este ensayo no demuestra que el testigo físico final esté construido ni que el canal lumínico funcione. Las rutas de micro:bit y XIAO corresponden a documentación/propuesta técnica en sus respectivos estados; comprobar su estado real antes de tratarla como producto ejecutado.

### Datos y privacidad

El prototipo almacena primero sesiones y eventos en SQLite local y, cuando está configurado, intenta sincronizarlos de forma seudónima con Supabase. El consentimiento Android vigente indica finalidad académica, correo de contacto confirmado y plazo máximo hasta el 30 de diciembre de 2026. El identificador aleatorio no vuelve anónimos por sí mismos todos los datos: revisar el contenido y riesgo de reidentificación.

El código contiene un flujo para revocar consentimiento, detener el monitoreo, bloquear nueva sincronización y solicitar borrado remoto y local. Está implementado, pero no ha pasado prueba completa con los datos reales. No entregar el APK a participantes ni describir el borrado como comprobado hasta probar aceptación/rechazo, ausencia de registro antes del consentimiento, sincronización, borrado con conexión y sin conexión, reintento y verificación final. Revisar también permisos, políticas RLS, almacenamiento, respaldos y la información que se comunica a participantes. En el repositorio y APK solo debe existir clave publicable; nunca clave `service_role`.

### Identidad visual

La investigación visual escrita está en `10_recursos_visuales`. El documento 14 define sistema de marca vigente; el 15 documenta la aplicación implementada. La dirección actual prioriza claridad, autonomía, discreción y cuidado, con Source Sans 3 y una base neutra con verde Relevo. El documento 14 rige frente a exploraciones viejas; forma física, parámetros de luz/sonido y efecto de la marca requieren comprobación. No recrear por inercia el antiguo estilo de Nothing ni usar gráficos sin una función.

## Memoria académica

`08_memoria/memoria-vigente-v4.md` es la base textual académica vigente al corte. Mantiene la estructura de títulos acordada, el orden narrativo del semestre anterior y APA 7. La memoria debe tratarse como avanzada pero no final: la nueva aplicación, las decisiones físicas y cualquier resultado real deben integrarse solo después de comprobarlos. No adelantarse al producto en motivación o introducción, no inventar evidencia y no rellenar. Antes de intervenir, leer `08_memoria/README.md`, el capítulo afectado, las matrices de rúbrica/citas/feedback y la matriz histórica de encargos.

`08_memoria/resumen-vigente-proyecto.md` y `README.md` ahora reflejan Android 2.6. El resumen general, el plan de cierre y algunos instrumentos de validación tienen fechas de corte anteriores y deben contrastarse antes de citarlos como estado actual.

## Mapa de trabajo

| Ruta | Función | Lectura de entrada |
|---|---|---|
| `00_gobernanza` | Estado general, instrucciones, calendario, criterios e índices | `README.md`, `directrices-de-trabajo.md`, este traspaso |
| `01_contexto_y_fuentes` | Historia, procedencia y fuentes | `contexto-del-proyecto.md`, inventario de fuentes |
| `02_investigacion` | Preguntas, método y síntesis | `README.md` |
| `03_usuarios` | Corpus anonimizado y análisis | `README.md`; no copiar el corpus fuera del entorno autorizado |
| `04_mercado_y_referentes` | Mercado, productos, academia y oportunidad | `README.md` y registro de búsqueda fechado |
| `05_propuesta_phygital` | Arquitectura de experiencia, flujos y wireframes | `README.md`, alcance y wireframe v1 |
| `06_desarrollo_y_factibilidad` | App, dispositivo, energía, sonido, costo y construcción | `README.md`; para app, también `app-android/README.md` |
| `07_validacion` | Consentimientos, protocolos, pauta y datos | `README.md`; no confundir versiones fechadas con vigentes |
| `08_memoria` | Texto académico y auditorías | `README.md`, memoria v4 y resumen vigente |
| `09_decisiones` | Decisiones, alternativas y condiciones de revisión | `registro-de-decisiones.md` |
| `10_recursos_visuales` | Investigación textual del sistema gráfico | `README.md`, documento 14 y 15 |
| `00_admin/encargos` | Requisitos docentes y entregas fechadas | `README.md`; son contexto interno, no evidencia para la memoria |
| `99_archivo` | Versiones anteriores, materiales reemplazados y fuentes migradas | Consultar únicamente para rastrear evolución; nunca asumir vigencia |

## Orden de lectura inicial recomendado

Para entender el proyecto de principio a fin, leer en este orden:

1. `README.md` y este documento.
2. `00_gobernanza/directrices-de-trabajo.md`, `hoja-de-ruta.md` y `indice-del-repositorio.md`.
3. `01_contexto_y_fuentes/contexto-del-proyecto.md` y `matriz-historica-encargos-memoria.md`.
4. `02_investigacion/README.md` y `03_usuarios/README.md`; luego las fuentes específicas que la tarea necesite.
5. `04_mercado_y_referentes/README.md` y `05_propuesta_phygital/README.md`.
6. `06_desarrollo_y_factibilidad/README.md` y `app-android/README.md`, `revision-feedback-2026-09-23.md`, `conexion-base-remota-2026-09-21.md`.
7. `07_validacion/README.md`, consentimiento vigente, privacidad y pauta; identificar antes la versión de app a la que aplican.
8. `08_memoria/README.md`, resumen vigente y memoria v4; después las matrices de feedback y trazabilidad pertinentes.
9. `09_decisiones/registro-de-decisiones.md` y `10_recursos_visuales/README.md`.
10. Consultar `00_admin/encargos` o `99_archivo` si la pregunta lo requiere.

No hace falta volver a leer cada archivo antiguo en cada tarea. Los README de cada área conducen al material primario; abrir todos los documentos de una subcarpeta solo cuando se haga una auditoría global.

## Prioridades abiertas

1. **Alinear documentación operativa con 2.6.** Revisar pauta y ficha Android fechadas el 23 de septiembre, README de validación, modelo de datos e índice de gobernanza. Algunos citan 2.4/2.5; no aplicarlos sin revisión.
2. **Ensayar la privacidad antes de personas.** Ejecutar pruebas de consentimiento y borrado local/remoto con registros controlados, comprobar políticas RLS y documentar qué pasa ante fallos y desconexión. Confirmar con responsable académico los requisitos institucionales antes de reclutar.
3. **Comprobar app y señal en equipo real.** Selección de dos apps, conteo acumulado, pausas, permisos, notificación, salida Bluetooth, prueba de sonido, silenciamiento, reconexión y fallos. Registrar modelo y versión Android, resultados y límites.
4. **Resolver prototipo físico phygital.** Aclarar qué dispositivo/placa y qué señal real se utilizará, facilidad de armado, luz, sonido, alimentación, autonomía, seguridad, costos y si cumple la experiencia prevista. No confundir parlante comercial con testigo Relevo.
5. **Revisar relación entre investigación, prototipo y memoria.** Añadir solo resultados reales; revisar propuesta de valor, estados del usuario límite, explicación del rol físico y límites del producto.
6. **Sincronizar plan de cierre y resumen general.** El calendario fija como metas de trabajo cierre sustantivo del producto el 31 de octubre y cierre interno el 15 de noviembre de 2026; entrega académica 2 de diciembre y examen 14–18 diciembre. Confirmar fechas y progreso con documentos/Issues actualizados antes de reorganizar trabajo.
7. **Revisar GitHub Issues.** En el entorno usado para este corte `gh` no estaba instalado y el estado de Issues no se verificó. Consultarlas en GitHub antes de afirmar cuál está abierta, cerrada o asignada.

Estas prioridades son un diagnóstico al corte, no afirmación de que se hayan realizado nuevas pruebas. El autor puede cambiar el orden.

## Actualización del 25 de septiembre de 2026

Estos cambios se hicieron después del corte y están en la rama `claude/wizardly-ptolemy-5u3fl6` ([PR joan1542003-byte/proyecto-titulo#12](https://github.com/joan1542003-byte/proyecto-titulo/pull/12)):

- **Memoria:** se verificaron las 64 referencias contra Crossref, los textos oficiales y los sitios citados; se corrigieron datos bibliográficos, paráfrasis de P2 y Q13 y la descripción de Android 2.6. Detalle en la [revisión integral](../08_memoria/revision-integral-fuentes-y-redaccion-2026-09-25.md).
- **Prioridad 1 resuelta en lo documental:** la pauta, la ficha, el modelo de datos y el índice de validación ya describen 2.6. El resumen general, la hoja de ruta y el plan de cierre tienen corte al 25 de septiembre.
- **Derechos de autor:** se retiraron los PDF completos de Norman, Albers, Munari e Isaacson, que no tienen edición gratuita legal; siguen en el historial de Git. Se creó un registro de licencias de la app (la de Source Sans 3 ya estaba incluida). Los marcos de iPhone y Pixel de los wireframes y la fotografía de una referencia visual tienen origen no registrado.
- **Sin cambios:** no se hicieron pruebas con personas ni con equipos reales.
- **Android 2.7 (rama `android-2.7`, sobre la anterior):** la app que pide el protocolo 02 incluye:
  - señal de 30 segundos que termina sola;
  - condición de la semana;
  - notificación genérica en la condición «teléfono»;
  - preguntas tras cada señal, tarjetas semanales y cierre del día 21;
  - registro de respuesta y uso alrededor de la señal.

  También explica y corrige por qué la base tenía 0 eventos. Se verificó en emulador con datos ficticios; faltan el teléfono real, el parlante y el borrado sin conexión. Detalle en [Android 2.7](../06_desarrollo_y_factibilidad/app-android/version-2.7-prueba-21-dias-2026-09-25.md) y D-080.

## Actualización del 26 de septiembre de 2026

En la rama `android-2.7`, a pedido del autor:

- **Android 2.8:** aplica el sistema de marca D-073 con fotografías tratadas, suma perfil, ruta de actividades, aviso de regreso opcional, apariencia y uso sin participar, y completa las pantallas del diseño escrito. La lógica de la prueba de 21 días no cambia. Compila y pasan 47 pruebas unitarias; se recorrió en emulador con datos ficticios. Detalle en [Android 2.8](../06_desarrollo_y_factibilidad/app-android/version-2.8-rediseno-perfil-y-ruta-2026-09-26.md) y D-082.
- **Decisión pendiente del autor:** usar 2.8 o 2.7 en la prueba de 21 días; D-073 sigue siendo una propuesta para la marca completa.
- **Sin cambios:** no se hicieron pruebas con personas ni con equipos reales.

## Actualización del 27 de septiembre de 2026

- **Android 2.9:** a pedido del autor, la interfaz pasa al estilo de iOS 26 (D-083): pantalla completa, vidrio con desenfoque sutil en la navegación, cápsulas y esquinas amplias, emoji 3D de Google en el perfil y textos más naturales. No cambia la lógica ni los datos. Compila y pasan 50 pruebas unitarias; se recorrió en emulador con datos ficticios. Detalle en [Android 2.9](../06_desarrollo_y_factibilidad/app-android/version-2.9-vidrio-y-emoji-2026-09-27.md).
- **Android 2.10:** a pedido del autor (D-084), usar la app exige participar en la prueba, los rótulos pasan a frases claras y sin mayúsculas, el desenfoque se aleja del centro y baja en los botones, el texto sobre las fotos toma el tono de cada foto, el perfil ofrece 84 emoji y se rediseñan «Tu ruta» y «Tus actividades». Compila y pasan 58 pruebas unitarias; se recorrió en emulador sin red y con datos ficticios. Detalle en [Android 2.10](../06_desarrollo_y_factibilidad/app-android/version-2.10-participacion-y-claridad-2026-09-27.md).
- **Marca 2.0 en Figma:** a pedido del autor, un [sistema de marca 2.0](../10_recursos_visuales/22_sistema-de-marca-2.0-figma-2026-09-27.md) reúne D-073 con el vidrio, las cápsulas, el texto según la foto, las frases sin mayúsculas y los emoji de la app, con variables, 97 iconos, componentes, imágenes y aplicaciones. Es una propuesta (D-085) pendiente de aprobación; el archivo está en el equipo de Figma del autor y sus vistas, en el repositorio.
- **Sin cambios:** no se hicieron pruebas con personas ni con equipos reales.

## Actualización del 28 de septiembre de 2026

- **Presentación del 30 de septiembre:** el [guion](guion-presentacion-correccion-cruzada-2026-09-30.md) pasó a 13 diapositivas según las anotaciones del autor en Figma. También hay un [GIF de la app 2.10](../06_desarrollo_y_factibilidad/app-android/capturas/como-funciona-2.10/README.md) grabado en emulador y un [video de 30 segundos](../10_recursos_visuales/marca-2.0/video/README.md) que explica Relevo con la marca 2.0. Falta pasarlos a las diapositivas de Figma y ensayar.
- **Android 2.11 (D-086):** para el primer testeo real, la app explica su uso la primera vez con el video en vertical y guarda cada dato en Supabase y en una copia en Documentos/Relevo del teléfono; el consentimiento pasa a v7. En Supabase hay vistas de análisis en el esquema `analisis`. Se comprobó en emulador con conexión; faltan el teléfono y el parlante reales ([detalle y pasos](../06_desarrollo_y_factibilidad/app-android/version-2.11-primer-testeo-2026-09-28.md)).
- **Android 2.12 (D-087):** sin lenguaje de «prueba» en el uso diario, textos simples, notificaciones pedidas solas y avisos encendidos, código de 4 caracteres, modo claro, registro del uso de la app (`relevo_app_events`, vistas `analisis.uso` y `analisis.resumen_de_uso`), reacción con caras tras cada aviso y opinión rápida. La configuración de las tres semanas se abre manteniendo presionado el texto de la versión en el perfil. Consentimiento v8. Hay una [lista de 31 actividades](../10_recursos_visuales/23_actividades-e-imagenes-2026-09-29.md) para que el autor genere 18 imágenes nuevas ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.12-mas-simple-y-mas-datos-2026-09-29.md)).
- **Android 2.13 (D-088, D-089):** guía de la primera vez de nueve pantallas y notas en el primer relevo; doce intereses concretos de P1–P8 con su fuente en el código; nombre obligatorio, guardado aparte en `relevo_participants` (vista `analisis.participantes`); aviso semanal preguntado Sí/No; resumen del relevo activo; audio del video para teléfono; consentimiento v9. La [revisión de coherencia](../08_memoria/coherencia-app-con-la-memoria-2026-09-29.md) lista las contradicciones con la memoria y lo que falta actualizar en ella ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.13-guia-intereses-y-nombre-2026-09-29.md)).
- **Android 2.14 (D-090), versión del testeo real:** guía de tres pantallas de contexto y primer relevo acompañado con el primer paso de la ruta elegida; aviso al activar el primer relevo; defecto de la 2.10 corregido ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.14-guia-y-primer-relevo-2026-09-29.md)).
- **Registro de pedidos:** cada pedido del autor se anota el mismo día en el [registro de pedidos a la IA](registro-de-pedidos-a-la-ia.md); es una regla de `CLAUDE.md`.
- **Resumen:** la [bitácora del trabajo con IA](bitacora-trabajo-con-ia-2026-09-26-28.md) reúne lo hecho del 26 al 28 de septiembre, las decisiones, el uso de la IA y los pendientes.
- **Sin cambios:** no se hicieron pruebas con personas ni con equipos reales.

## Actualización del 29 de septiembre de 2026

- **Hipótesis final (D-091):** «Si se diseña un sistema phygital que vincula una actividad elegida con el lugar donde comienza, entonces la persona la recordará a tiempo durante el ocio digital, porque una intención se recupera cuando aparece una señal asociada a ella». Su «porque» viene del marco multiproceso (McDaniel y Einstein, 2000), que la memoria incorpora en el capítulo 6. Las reglas de la cátedra para hipótesis están en los encargos 06, 10, 12 y 14.
- **Memoria:** citas en APA 7 en español («y», no «&»); capítulos 11 y 13 al día con la app 2.14 y la prueba con una persona; títulos simples de los ámbitos (D-094); encuesta de 53 respuestas como evidencia complementaria (D-092), usada solo con recuentos y sin subir el archivo de respuestas.
- **Presentación:** [archivo en Figma](https://www.figma.com/slides/zhLK5LTPQWXPHIQeq4wuE8) de 15 diapositivas y respaldo; [estado y cómo se hizo](../10_recursos_visuales/24_presentacion-correccion-cruzada-2026-09-30.md). El autor comenta dejando notas «*Claude…» dentro de los textos.
- **Objetos que suenan (D-093):** Android 2.15 con la salida experimental «El reloj», sin probar con hardware; el llavero iTag clásico se puede controlar con el servicio Bluetooth estándar de alerta inmediata ([estudio](../06_desarrollo_y_factibilidad/objetos-que-suenan-2026-09-29.md)).
- **Resumen del día:** [bitácora del 29 de septiembre](bitacora-trabajo-con-ia-2026-09-29.md).
- **Rama:** `main` avanzó hasta `android-2.7`, sin conflictos. Desde el 29 de septiembre, ambas tienen el mismo trabajo.
- **Sin cambios:** no se hicieron pruebas con personas ni con equipos reales.

## Actualización del 30 de septiembre de 2026

- **Android 2.16 (D-095 y D-096):** activación automática opcional, también en el testeo, y mensajes del proyecto que llegan como notificación. Consentimiento v10. Probada en emulador; falta el teléfono real ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.16-activacion-automatica-y-mensajes-2026-09-30.md)).
- **Android 2.17:** los mensajes llegan al instante mientras Relevo cuenta o espera, por Realtime ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.17-mensajes-al-instante-2026-09-30.md)). Para que lleguen siempre al instante haría falta Firebase Cloud Messaging.
- **Android 2.18 (D-097):** uso diario de las apps elegidas y tiempo total de pantalla desde 7 días antes de aceptar, estado del teléfono, «Eliminar este relevo» y avisos de campos faltantes. Consentimiento v11, pendiente de revisión docente. Probada en emulador, incluido el borrado de las tablas nuevas ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.18-registro-completo-y-avisos-2026-09-30.md)).
- **Panel privado:** [Panel de Relevo](https://claude.ai/artifact/QMsAiSqpkuivix6FJzh9uM), en claude.ai, con el diseño de la app y cuatro pestañas. Lee Supabase con el conector del autor, envía mensajes (con 12 mensajes listos), muestra el uso y la configuración de cada persona y descarga sus datos ([cómo funciona](../06_desarrollo_y_factibilidad/panel-admin/README.md)). Para cambiarlo hay que volver a publicarlo en la misma dirección; declara los permisos `mcp` (Supabase, `execute_sql`) y `downloads`.
- **Supabase:** migraciones `relevo_auto_activation_and_messages` (columna `activation` y tablas `relevo_messages` y `relevo_message_receipts`, con RLS), `relevo_messages_realtime` y `relevo_state_usage_and_deleted` (tablas `relevo_participant_state` y `relevo_daily_usage`, con RLS, y el resultado `deleted`).
- **Presentación:** la diapositiva 14 es una carta Gantt de lo que sigue, en tercera persona ([documento 24](../10_recursos_visuales/24_presentacion-correccion-cruzada-2026-09-30.md)).
- **Identidad (D-098, propuesta):** la corrección cruzada recordó la presentación pero no la reconoció en la app. La propuesta une ambas alrededor del subrayado azul, con el azul `#3D38F5`, Schibsted Grotesk e íconos redibujados ([documento 25](../10_recursos_visuales/25_identidad-el-subrayado-2026-09-30.md); [lámina](https://claude.ai/artifact/Je5eJkLaCQX8JFcuDsbfVU)). Falta la decisión del autor antes de aplicarla.
- **Resumen del día:** [bitácora del 30 de septiembre](bitacora-trabajo-con-ia-2026-09-30.md).
- **Sistema de diseño 3.0 (1 de octubre):** la identidad D-098 desarrollada como sistema en el tipo Design System de claude.ai ([sistema publicado](https://claude.ai/artifact/SsGWeeHPHxxkXrCKN1WW8x), privado; [documento 26](../10_recursos_visuales/26_sistema-de-diseno-3.0-2026-10-01.md); [archivos](../10_recursos_visuales/sistema-de-diseno-3.0/README.md)). Usa como supuestos Newsreader, una tinta y trama en íconos solo en momentos de marca; falta aplicarlo a la app 2.19, a Figma y a la presentación ([bitácora del 1 de octubre](bitacora-trabajo-con-ia-2026-10-01.md)).
- **Sistema de diseño 3.1 (2 de octubre, D-099):** sobre la misma página publicada ([documento 27](../10_recursos_visuales/27_sistema-de-diseno-3.1-2026-10-02.md); [archivos](../10_recursos_visuales/sistema-de-diseno-3.1/README.md)). Logotipo en Schibsted Grotesk 600 con un renglón que pasa la «o»; Relevo en grotesca y romana, la persona en Newsreader itálica; el azul como único color del sistema y seis colores de la casa para las categorías de actividad; 135 íconos, ilustraciones, patrones, aplicaciones y movimiento. Supuestos: Newsreader, los colores de la casa, la itálica para la persona y trama en íconos solo en momentos de marca. Falta corregir el capítulo 11 de la memoria, que aún describe la marca anterior ([bitácora del 2 de octubre](bitacora-trabajo-con-ia-2026-10-02.md)).
- **Exploración de color y letra (2 de octubre):** el autor pidió seguir explorando con referencias de Behance. [Documento 28](../10_recursos_visuales/28_exploracion-color-y-letra-2026-10-02.md) y [lámina](https://claude.ai/artifact/T8FY5qmRDCa7T5Mmfk5oxP): cuatro direcciones de color y cinco pares de letra. Recomendación: cuaderno (renglón azul y margen rojo que marca dónde empieza) con la persona escribiendo en Playwrite CL. Pendiente de su elección.
- **Relevo vivo, propuesta 3.2 (3 de octubre, D-100):** colores vivos y más personalidad, a pedido del autor. Regla: un color, una frase, un renglón. Seis colores de la casa vivos con campo, tinta y fondo suave; Schibsted Grotesk 800 para Relevo y Playwrite CL para la persona ([documento 29](../10_recursos_visuales/29_relevo-vivo-2026-10-03.md); [lámina](https://claude.ai/artifact/VyeLFYsuWgkyJ45pkfywJL)). Quita la serif de titulares de D-098: el autor debe decidir. Falta el tema oscuro y, si se aprueba, llevarla al sistema publicado, a la app y a la presentación.
- **Volver a enfocar, propuesta 3.3 (3 de octubre, D-101):** el autor rechazó Playwrite (no usar letras escritas a mano) y pidió fundamentar siempre con diseñadores recientes, famosos y de buena reputación, no antiguos. La actividad aparece fuera de foco (foto de su lugar desenfocada sobre su color vivo) y, nítidas, la frase de Relevo en Newsreader y las palabras de la persona en itálica sobre el renglón azul ([documento 30](../10_recursos_visuales/30_volver-a-enfocar-2026-10-03.md); [lámina](https://claude.ai/artifact/AQn4nbdQbPAPwkX4Pzw5tn)). Pendiente: que el autor la apruebe para llevarla al sistema publicado y a la app. **Versión 2:** el autor pidió no abusar de la raya ni de la serif; los titulares van en Schibsted Grotesk, la serif solo para las palabras de la persona y el renglón solo bajo ellas.
- **Las ganas estaban, propuesta 3.4 (3 de octubre, D-102):** el autor pidió comunicar con lo que se sabe y no citar palabras de usuario como titular, quitar la serif, no poner el marcador azul en todas las piezas y usar colores que combinen. Cada pieza dice una cifra de la encuesta, el principio de la señal o lo que hace Relevo; solo Schibsted Grotesk; el renglón azul solo en el logotipo y donde se escribe; seis pares de color con fotos en duotono ([documento 31](../10_recursos_visuales/31_las-ganas-estaban-2026-10-03.md); [lámina](https://claude.ai/artifact/TLqwUeq6KhgbFXvbVRsXff)). Pendiente: que el autor la apruebe para llevarla al sistema publicado y a la app. **Versión 2 (D-103):** el autor pidió saber cuándo usar los colores; [Cuándo va color](../10_recursos_visuales/32_cuando-va-color-2026-10-03.md) fija tres niveles (calma, presencia y señal), cinco papeles (neutros, sistema, marca, actividad y estado) y cambia tres pares para que ningún color tenga dos significados.
- **El traspaso, propuesta 3.5 (3 de octubre, D-104):** el autor pidió no abusar de los colores, un logotipo con carácter en una sans, colores que combinen todos entre sí y otras ideas en vez del subrayado. La marca pasa a la idea del testigo (RAE, relevo y testigo); el logotipo, a Familjen Grotesk con el gancho de la «l» tocando la «e»; el color, a una familia de seis claros y cuatro profundos con la misma luz por nivel, y el color pleno queda en 5 de 19 piezas ([documento 33](../10_recursos_visuales/33_el-traspaso-2026-10-03.md); [lámina](https://claude.ai/artifact/EG2Ta5ahzMU55sJrijL3fA)). Pendiente: que el autor apruebe y, con su permiso, descargar la fuente para dibujar el logotipo en curvas.
- **Letra con identidad, propuesta 3.6 (4 de octubre, D-105):** el azul pasa a `#1C3891` porque el anterior no combinaba con la familia. El autor descartó los logotipos dibujados y pidió letras gratuitas con identidad, que no sean una sans simple: se recomienda Chubbo Bold (Fontshare, licencia comercial gratuita), con Calistoga y Fraunces Soft como alternativas ([documento 34](../10_recursos_visuales/34_letra-con-identidad-2026-10-04.md); [lámina](https://claude.ai/artifact/XPgDvNQEcgjZ1nnTWX3GXS)). Pendiente: que el autor elija, y con su permiso descargar la fuente para dibujar el logotipo en curvas; retomar la exploración de los visuales generales.
- **Letras para relevo, propuesta 3.7 (4 de octubre, D-106):** el autor pidió más variedad de tipografías, con más licencias porque el proyecto no sale a la venta y sin Google Fonts en el logotipo. Se miraron 176 letras de Pangram Pangram, Fontshare, Velvetyne y Collletttivo; hay dieciocho finalistas en cuatro familias y una recomendación por familia (Chubbo, Erode, Combat y Gosha Sans) ([documento 35](../10_recursos_visuales/35_letras-para-relevo-2026-10-04.md); [lámina](https://claude.ai/artifact/R9eHYeUaWooRcPjXqvC2B6)). Las de Pangram Pangram sirven para la tesis, no para un producto real sin licencia. Pendiente: que el autor elija y autorice descargar los archivos de la o las elegidas; retomar la exploración de los visuales generales. **Versión 2:** el autor autorizó descargar de cualquier fuente; se sumaron 88 letras de UNCUT y Open Foundry (264 en total) y doce finalistas nuevas, todas OFL, hasta treinta. Destacan Bagnard y Hauora Sans. La descarga de los archivos de la letra elegida ya está autorizada.
- **Letras que dicen relevo, propuesta 3.8 (4 de octubre, D-107):** el autor pidió más letras de tipo display y analizarlas viéndolas y leyendo qué conceptos de Relevo evocan. Se sumaron 61 letras de cinco fuentes (Le75, Tunera, Republish, The League of Moveable Type y Klotter Supply), hasta 325; 108 se miraron en grande y catorce pasaron a ficha: para el logotipo Struggle, Bespoke Stencil, Manosque, Kola y Ouroboros; para la señal Striper, Ampoule y Linea; para carteles seis de solo mayúsculas ([documento 36](../10_recursos_visuales/36_letras-que-dicen-relevo-2026-10-04.md); [lámina](https://claude.ai/artifact/C8C9apN8tayiAoPERJ9gxZ)). La lectura de conceptos es una hipótesis de diseño sin probar con personas. El autor la descartó el mismo día por genérica; la reemplaza la 3.9.
- **Letras para lucirse, propuesta 3.9 (4 de octubre, D-108):** el autor rechazó la 3.8 («genéricas, sin carácter, estilo ni diseño») y aclaró que display es una letra hecha para verse linda y lucirse en un logotipo, no para pantallas. Se buscó belleza: 113 especímenes y 23 letras en cuatro familias, con su tablero: cursivas con vuelo (Acma, Hatton, Migra, Kyoto, Pangaia, Eiko, Editorial New, Right Didone y Telma), contraste alto y afilado (Gatwick Glider, Boska, Bonny, Melodrama y Stardom), cálidas y con cuerpo (Woodland, Gambetta, Sentient, Zodiak y Ouroboros) y decorativas (Zina, Chronos Serif, Aktura y Playground) ([documento 37](../10_recursos_visuales/37_letras-para-lucirse-2026-10-04.md); [lámina](https://claude.ai/artifact/YAVi4rd5H4tKPPXSAnn3rp)). Las de Pangram Pangram son «gratis para probar» (sirven para la tesis; un logotipo real pide licencia). Pendiente: que el autor elija tres o más y diga si autoriza usar su nombre y correo para las pruebas de Reckless, GT Super, GT Alpina y Domaine Display; retomar la exploración de los visuales generales.

## Actualización del 5 de octubre de 2026

- **Android 2.19 (D-109):** salida «El llavero». Relevo busca un llavero iTag, lo prueba, mantiene la conexión mientras el relevo espera y lo hace pitar seis veces en 30 s; su botón calla la señal (`signal_end = 'object'`). Probada en emulador solo en su pantalla; **falta probarla con un llavero real** ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.19-llavero-itag-2026-10-05.md)).
- **Compra:** el autor comprará un iTag; hay publicaciones de MercadoLibre que indican iSearching, de CLP 5.930 a 7.990. Probarlo al llegar con los pasos de la 2.19.
- **Supabase:** migración `relevo_2_19_llavero` (valores `tag`, `object` y `silenced_object`). **Panel:** versión 4, reconoce el llavero.
- **Resumen del día:** [bitácora del 5 de octubre](bitacora-trabajo-con-ia-2026-10-05.md).
- **Android 2.29 (D-119, 7 de octubre), versión del primer testeo:** igual que la 2.28, pero la prueba del Tag empieza por el nivel medio, el que pitó ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.29-nivel-medio-primero-2026-10-07.md)).
- **Android 2.28 (D-117, 7 de octubre):** Tag por defecto con búsqueda automática, lugares concretos, «Volver al inicio» y una app optimizada; el APK ya no es de depuración ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.28-tag-por-defecto-y-fluidez-2026-10-07.md)). **Panel 12** (D-118): eliminar en dos clics; la ficha abre con un resumen y muestra cada relevo con lo que respondió y el flujo de uso. Mantiene el tiempo en cada app y los perfiles en la barra lateral del panel 11.
- **Android 2.27 (D-116, 7 de octubre):** el Tag suena en la señal (FFE2 en 1 junto con la alerta) y pita seguido 30 segundos ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.27-el-tag-suena-en-la-senal-2026-10-07.md)). Falta probarla con el Tag real.
- **Android 2.26 (D-115, 7 de octubre):** el Tag se conectaba pero no pitaba; Relevo ya no apaga a ciegas su interruptor FFE2 y la prueba pregunta si se escuchó ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.26-el-tag-pita-2026-10-07.md)). Falta probarla con el Tag real.
- **Android 2.25 (D-114, 7 de octubre):** «Tag» en pantalla y guía paso a paso que se abre sola la primera vez ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.25-tag-y-guia-paso-a-paso-2026-10-07.md)). **Panel 10:** borrar datos (un relevo, grupos o la persona completa, confirmando con su código), barra lateral, búsqueda y filtros.
- **Android 2.24 (7 de octubre):** la 2.23 con la hoja «Cómo usar el llavero» ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.24-tutorial-del-llavero-2026-10-07.md)).
- **Android 2.23 (D-113, 7 de octubre):** degradados de tres colores, videojuegos y otras actividades de ocio del corpus, y opciones de un toque para el primer paso y el lugar ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.23-colores-y-opciones-listas-2026-10-07.md); [bitácora](bitacora-trabajo-con-ia-2026-10-07.md)).
- **Android 2.22 (D-112, 6 de octubre):** vuelven las semanas A, B y C asignadas por secuencia; el objeto va donde la persona escribió que empieza; lenguaje claro; consentimiento v13; panel por condiciones. D-110 queda reemplazada ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.22-comparar-y-lenguaje-claro-2026-10-06.md)).
- **Android 2.21 (D-111, 6 de octubre):** icono con degradado en vez de fotos, ninguna salida marcada, textos neutros, «No quiero participar». Pendiente: ajustar la memoria a D-110 y D-111 ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.21-iconos-y-sin-sugerencias-2026-10-06.md)).
- **Android 2.20 (D-110, 6 de octubre):** la persona elige dónde suena; la app registra A, B o C según su elección. La prueba de 21 días ya no asigna secuencias. Consentimiento v12, pendiente de revisión docente ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.20-eleccion-libre-2026-10-06.md)). Panel 6 con «Qué elige».
- **Panel 5 (6 de octubre):** pestañas Resultados (estadísticas por condición y por persona) y Exportar (Excel, CSV y JSON). Pendiente: preguntar al profesor cuántas personas espera para el Pase de Examen ([bitácora del 6 de octubre](bitacora-trabajo-con-ia-2026-10-06.md)).

## Seguridad, privacidad y GitHub

El README informó que el repositorio fue público al 9 de septiembre de 2026; esa visibilidad debe verificarse antes de cargar material nuevo. No subir notas personales, consentimientos firmados, nombres, contactos de participantes, registros brutos identificables ni archivos locales que no estén preparados para difusión. Mantener solo corpus anonimizado autorizado. No guardar credenciales, `.env`, `local.properties`, claves privadas o copias de bases de datos. El archivo `local.properties.example` es una plantilla, no una credencial.

En este corte, `main` local y `origin/main` coinciden en `ad12e100506d024f4043b38d3153a5a18403e4c5`; el repositorio local estaba limpio. Antes de continuar, recuperar el último estado remoto y preservar cambios locales. No atribuir estado de Issues sin consultarlo.

## Cómo continuar una tarea

Antes de editar, decir brevemente cuál es la pregunta o entrega, qué evidencia local se revisará y qué no se puede afirmar todavía. Desarrollar una sola línea sustantiva a la vez. Al cierre: verificar enlaces y formato, registrar disclaimer, actualizar índices y resumen afectados, correr pruebas relevantes, guardar un commit claro y confirmar si se hizo push. No realizar pruebas con personas ni enviar mensajes a terceros sin una instrucción expresa y sin instrumentos/consentimientos vigentes.

## Registro de cambios (disclaimer)

### 2026-10-07 — Android 2.29

- **Qué cambió:** el estado suma la 2.29.
- **Cómo estaba antes:** terminaba en la 2.28.
- **Por qué:** D-119.

### 2026-10-07 — Panel 12

- **Qué cambió:** el estado suma el panel 12.
- **Cómo estaba antes:** mencionaba el panel 11.
- **Por qué:** D-118.

### 2026-10-07 — Android 2.28

- **Qué cambió:** el estado suma la 2.28 y el panel 11.
- **Cómo estaba antes:** terminaba en la 2.27.
- **Por qué:** D-117.

### 2026-10-07 — Android 2.27

- **Qué cambió:** el estado suma la 2.27.
- **Cómo estaba antes:** terminaba en la 2.26.
- **Por qué:** D-116.

### 2026-10-07 — Android 2.26

- **Qué cambió:** el estado suma la 2.26.
- **Cómo estaba antes:** terminaba en la 2.25.
- **Por qué:** D-115.

### 2026-10-07 — Android 2.25 y panel 10

- **Qué cambió:** el estado suma la 2.25 y el panel 10.
- **Cómo estaba antes:** terminaba en la 2.24.
- **Por qué:** pedido del autor.

### 2026-10-07 — Android 2.24

- **Qué cambió:** el estado suma la 2.24.
- **Cómo estaba antes:** terminaba en la 2.23.
- **Por qué:** pedido del autor.

### 2026-10-07 — Android 2.23

- **Qué cambió:** el estado suma la 2.23.
- **Cómo estaba antes:** terminaba en la 2.22.
- **Por qué:** pedido del autor.

### 2026-10-06 — Android 2.22

- **Qué cambió:** el estado suma la 2.22 y D-112.
- **Cómo estaba antes:** terminaba en la 2.21.
- **Por qué:** pedido del autor.

### 2026-10-06 — Android 2.21

- **Qué cambió:** el estado suma la 2.21.
- **Cómo estaba antes:** terminaba en la 2.20.
- **Por qué:** pedido del autor.

### 2026-10-06 — Android 2.20

- **Qué cambió:** el estado suma la elección libre (D-110) y el panel 6.
- **Cómo estaba antes:** terminaba en el panel 5.
- **Por qué:** pedido del autor antes del primer testeo.

### 2026-10-06 — Panel 5

- **Qué cambió:** el estado suma el panel 5 y la pregunta pendiente al profesor sobre el número de personas.
- **Cómo estaba antes:** terminaba en Android 2.19.
- **Por qué:** pedido del autor del 6 de octubre.

### 2026-10-05 — Llavero iTag

- **Qué cambió:** el estado suma Android 2.19 con el llavero, la migración `relevo_2_19_llavero`, el panel 4 y la compra en MercadoLibre.
- **Cómo estaba antes:** terminaba en la propuesta 3.9 del 4 de octubre.
- **Por qué:** el autor decidió comprar un llavero iTag y pidió que la app lo haga sonar (D-109).

### 2026-10-04 — Letras para lucirse

- **Qué cambió:** el estado suma la propuesta 3.9 y marca la 3.8 como descartada.
- **Cómo estaba antes:** terminaba en la propuesta 3.8.
- **Por qué:** el autor rechazó la propuesta 3.8 por genérica y pidió letras display hermosas, hechas para lucirse en un logotipo.

### 2026-10-04 — Letras que dicen relevo

- **Qué cambió:** el estado suma la propuesta 3.8.
- **Cómo estaba antes:** terminaba en la versión 2 de la 3.7.
- **Por qué:** el autor pidió buscar más letras de tipo display y analizarlas, viéndolas y leyendo qué conceptos de Relevo evocan.

### 2026-10-04 — Letras para relevo, versión 2

- **Qué cambió:** el estado suma la versión 2 de la 3.7 y la autorización de descargar.
- **Cómo estaba antes:** describía la primera versión de la 3.7.
- **Por qué:** el autor dio permiso para descargar lo que quisiera de las fuentes que quisiera y pidió explorar más.

### 2026-10-04 — Letras para relevo

- **Qué cambió:** el estado suma la propuesta 3.7.
- **Cómo estaba antes:** describía la 3.6 como última propuesta.
- **Por qué:** el autor pidió explorar más tipografías, usar más licencias porque el proyecto no sale a la venta, no usar Google Fonts en el logotipo y tener una variedad de elecciones.

### 2026-10-04 — Letra con identidad

- **Qué cambió:** el estado suma la propuesta 3.6.
- **Cómo estaba antes:** describía la 3.5 como última propuesta.
- **Por qué:** el autor pidió arreglar el azul y diseñar el logotipo; después encontró feos los dibujados y pidió letras gratuitas con identidad, que no fueran una sans simple.

### 2026-10-03 — El traspaso

- **Qué cambió:** el estado suma la propuesta 3.5 y las reglas del autor sobre el logotipo, el color y el subrayado.
- **Cómo estaba antes:** describía la 3.4 como última propuesta.
- **Por qué:** el autor pidió no abusar de los colores, un logotipo con más carácter en una sans, colores que combinen todos entre sí y otras ideas en vez del subrayado.

### 2026-10-03 — Cuándo va color

- **Qué cambió:** el estado suma la versión 2 de la 3.4 y las reglas de uso del color.
- **Cómo estaba antes:** describía solo la versión 1 de la 3.4.
- **Por qué:** el autor encontró la 3.4 mucho mejor y pidió saber cuándo usar los colores y cuándo no, aprendiendo de diseño de interfaces, diseño y color.

### 2026-10-03 — Las ganas estaban

- **Qué cambió:** el estado suma la propuesta 3.4 y las reglas del autor sobre la voz, la serif, el marcador azul y el color.
- **Cómo estaba antes:** describía la 3.3 como última propuesta.
- **Por qué:** el autor señaló que los afiches citaban palabras de usuario sin comunicar lo que se sabe, que la serif no funcionaba y que el marcador azul no podía estar en todas las piezas, y pidió colores que combinen.

### 2026-10-03 — Volver a enfocar, versión 2

- **Qué cambió:** el estado suma la versión 2 de la propuesta 3.3 y la regla del autor sobre la raya y la serif.
- **Cómo estaba antes:** describía solo la versión 1.
- **Por qué:** el autor dijo que era mejorable y pidió no abusar de la raya ni de la serif, que no es obligatoria.

### 2026-10-03 — Volver a enfocar

- **Qué cambió:** el estado suma la propuesta 3.3 y las reglas del autor sobre letra y fundamentos.
- **Cómo estaba antes:** terminaba en la propuesta 3.2.
- **Por qué:** el autor rechazó la letra escrita a mano, compartió seis referencias y pidió fundamentar con diseñadores recientes y reconocidos.

### 2026-10-03 — Relevo vivo

- **Qué cambió:** el estado suma la propuesta 3.2.
- **Cómo estaba antes:** terminaba en la exploración de color y letra.
- **Por qué:** el autor pidió colores más vivos y más personalidad, sin diseño genérico ni recargado.

### 2026-10-02 — Exploración de color y letra

- **Qué cambió:** el estado suma la exploración de color y letra.
- **Cómo estaba antes:** terminaba en el sistema de diseño 3.1.
- **Por qué:** el autor pidió seguir explorando colores y tipografía, con referencias de Behance.

### 2026-10-02 — Sistema de diseño 3.1

- **Qué cambió:** el estado suma el sistema de diseño 3.1, sus supuestos y lo que falta.
- **Cómo estaba antes:** el estado terminaba en el sistema de diseño 3.0.
- **Por qué:** pedido del autor del 1 de octubre, retomado el 2.

### 2026-10-01 — Sistema de diseño 3.0

- **Qué cambió:** el estado suma el sistema de diseño 3.0, sus supuestos y lo que falta aplicar.
- **Cómo estaba antes:** la identidad D-098 figuraba solo como propuesta y lámina.
- **Por qué:** pedido del autor del 1 de octubre.

### 2026-09-30 — Identidad D-098

- **Qué cambió:** la actualización del 30 de septiembre suma la propuesta de identidad «el subrayado».
- **Cómo estaba antes:** terminaba en la presentación.
- **Por qué:** comentario de la corrección cruzada y pedido del autor.

### 2026-09-30 — Android 2.18 y panel v3

- **Qué cambió:** la actualización del 30 de septiembre suma Android 2.18, el panel con mensajes listos y la migración `relevo_state_usage_and_deleted`.
- **Cómo estaba antes:** llegaba hasta la 2.17 y el panel rediseñado.
- **Por qué:** pedido del autor (D-097).

### 2026-09-30 — Actualización del 30 de septiembre

- **Qué cambió:** se añadieron Android 2.16 y 2.17, el panel privado con el diseño de la app, las migraciones de Supabase y la carta Gantt de la presentación.
- **Cómo estaba antes:** la última actualización era la del 29 de septiembre.
- **Por qué:** pedidos del autor del 30 de septiembre (D-095 y D-096).

### 2026-09-29 — Rama principal

- **Qué cambió:** la actualización del 29 de septiembre indica que `main` quedó igual a `android-2.7`.
- **Cómo estaba antes:** el trabajo desde la app 2.7 estaba solo en `android-2.7`.
- **Por qué:** el autor pidió enviar el trabajo a `main`.

### 2026-09-29 — Actualización del 29 de septiembre

- **Qué cambió:** se añadió la actualización del 29 de septiembre: hipótesis final, memoria, presentación, objetos que suenan y bitácora del día.
- **Cómo estaba antes:** la última actualización era la del 28 de septiembre.
- **Por qué:** el autor pidió documentar el estado.

### 2026-09-29 — Títulos de los ámbitos

- **Qué cambió:** los enlaces y menciones a los ámbitos del capítulo 6 usan los títulos nuevos: «La experiencia del ocio digital», «El diseño de la atención» y «Recordar con objetos y lugares».
- **Cómo estaba antes:** «Experiencia subjetiva del ocio digital», «Arquitecturas de atención y bienestar digital» y «Mediación material de información personal».
- **Por qué:** el autor simplificó los títulos tras el feedback del examen de julio (D-094); los enlaces antiguos quedaban rotos.

### 2026-09-28 — Actualización del 28 de septiembre

- **Qué cambió:** se añadió una actualización con el guion, el GIF, el video, la bitácora del trabajo con IA y Android 2.11.
- **Cómo estaba antes:** la última actualización era la del 27 de septiembre.
- **Por qué:** mantener el traspaso al día, a pedido del autor.

### 2026-09-27 — Marca 2.0 en Figma

- **Qué cambió:** se añadió el sistema de marca 2.0 en Figma (D-085) al estado.
- **Cómo estaba antes:** el estado terminaba en Android 2.10.
- **Por qué:** pedido del autor del 27 de septiembre.

### 2026-09-27 — Android 2.10

- **Qué cambió:** se añadió la 2.10 a la actualización del 27 de septiembre.
- **Cómo estaba antes:** el traspaso llegaba hasta Android 2.9.
- **Por qué:** la próxima sesión debe partir del estado real de la app.

### 2026-09-27 — Android 2.9

- **Qué cambió:** se añadió la actualización del 27 de septiembre con la app 2.9.
- **Cómo estaba antes:** el traspaso llegaba hasta Android 2.8.
- **Por qué:** la próxima sesión debe partir del estado real de la app.

### 2026-09-26 — Android 2.8

- **Qué cambió:** se añadió la actualización del 26 de septiembre con la app 2.8 y la decisión pendiente entre 2.8 y 2.7.
- **Cómo estaba antes:** el traspaso llegaba hasta Android 2.7.
- **Por qué:** la próxima sesión debe partir del estado real de la app.

### 2026-09-25 — Android 2.7

- **Qué cambió:** la actualización del 25 de septiembre registra la app 2.7 del protocolo 02 y su verificación en emulador.
- **Cómo estaba antes:** la app 2.7 figuraba como requisito futuro.
- **Por qué:** la próxima sesión debe partir del estado real de la app.

### 2026-09-25 — Aviso de actualización

- **Qué cambió:** se añadió un aviso con las decisiones posteriores al corte.
- **Cómo estaba antes:** la guía describía luz, fase A y prueba de dos días sin aviso.
- **Por qué:** es el documento de entrada y no debe mezclar el estado del 24 con decisiones nuevas.

### 2026-09-25 — Actualización posterior al corte

- **Qué se añadió:** una sección con la verificación de la memoria, la sincronización documental con Android 2.6 y el retiro de libros protegidos.
- **Cómo estaba antes:** el traspaso solo describía el estado al 24 de septiembre.
- **Por qué:** es la entrada obligatoria para nuevas sesiones; debe indicar qué prioridades ya se atendieron sin reescribir el corte original.

### 2026-09-24 — Documento de traspaso creado

- **Qué se añadió:** contexto integral, evolución, evidencia, decisiones, estado real de Android 2.6, privacidad, sistema visual, memoria, mapa, lecturas y prioridades.
- **Cómo estaba antes:** el contexto de continuidad estaba dividido entre README, instrucciones dirigidas a ChatGPT/Codex, documentos fechados y conversaciones; varias síntesis aún describían versiones 2.4 o 2.5.
- **Por qué:** facilitar la migración a Claude y distinguir de manera verificable la propuesta, la implementación y las pruebas pendientes.
