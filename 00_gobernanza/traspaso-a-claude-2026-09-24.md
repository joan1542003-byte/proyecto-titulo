# Traspaso de Relevo a Claude

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

La memoria organiza el problema en tres aristas conectadas: **experiencial y cognitiva** (una intención alternativa puede no orientar la decisión inmediata), **tecnológica** (las interfaces y sus secuencias afectan cierres y oportunidades de elección) y **evaluativa** (el sentido del ocio no puede deducirse de su duración). Su marco teórico desarrolla experiencia subjetiva del ocio digital, arquitecturas de atención/bienestar digital y mediación material de información personal. Estas distinciones evitan reducir el tema a «falta de disciplina» o a un supuesto daño general del teléfono.

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

## Seguridad, privacidad y GitHub

El README informó que el repositorio fue público al 9 de septiembre de 2026; esa visibilidad debe verificarse antes de cargar material nuevo. No subir notas personales, consentimientos firmados, nombres, contactos de participantes, registros brutos identificables ni archivos locales que no estén preparados para difusión. Mantener solo corpus anonimizado autorizado. No guardar credenciales, `.env`, `local.properties`, claves privadas o copias de bases de datos. El archivo `local.properties.example` es una plantilla, no una credencial.

En este corte, `main` local y `origin/main` coinciden en `ad12e100506d024f4043b38d3153a5a18403e4c5`; el repositorio local estaba limpio. Antes de continuar, recuperar el último estado remoto y preservar cambios locales. No atribuir estado de Issues sin consultarlo.

## Cómo continuar una tarea

Antes de editar, decir brevemente cuál es la pregunta o entrega, qué evidencia local se revisará y qué no se puede afirmar todavía. Desarrollar una sola línea sustantiva a la vez. Al cierre: verificar enlaces y formato, registrar disclaimer, actualizar índices y resumen afectados, correr pruebas relevantes, guardar un commit claro y confirmar si se hizo push. No realizar pruebas con personas ni enviar mensajes a terceros sin una instrucción expresa y sin instrumentos/consentimientos vigentes.

## Registro de cambios (disclaimer)

### 2026-09-24 — Documento de traspaso creado

- **Qué se añadió:** contexto integral, evolución, evidencia, decisiones, estado real de Android 2.6, privacidad, sistema visual, memoria, mapa, lecturas y prioridades.
- **Cómo estaba antes:** el contexto de continuidad estaba dividido entre README, instrucciones dirigidas a ChatGPT/Codex, documentos fechados y conversaciones; varias síntesis aún describían versiones 2.4 o 2.5.
- **Por qué:** facilitar la migración a Claude y distinguir de manera verificable la propuesta, la implementación y las pruebas pendientes.
