# Proyecto de título — Relevo

Repositorio de investigación, desarrollo y documentación del proyecto de titulación de Johan Yantén, carrera de Diseño, Universidad Diego Portales.


**Base académica:** [memoria vigente v4](08_memoria/memoria-vigente-v4.md), con revisión de coherencia y edición de lectura en los documentos enlazados desde `08_memoria/README.md`. La síntesis y el prototipo se actualizaron después; la memoria requiere integrar evidencia nueva cuando exista.

**Revisión y limpieza de textos:** [Correcciones y comprobaciones del 9 de septiembre](00_gobernanza/auditoria-textual-2026-09-09.md). Estados, decisiones, enlaces y referencias reconciliados; las entregas antiguas conservan su fecha y sus límites.

**Feedback más reciente:** [aplicación de anotaciones del 23 de septiembre](00_gobernanza/aplicacion-feedback-docente-2026-09-23.md) y [auditoría en Android 2.6](06_desarrollo_y_factibilidad/app-android/revision-feedback-2026-09-23.md). La comprensión y el comportamiento siguen sin validación con participantes.

**Visibilidad registrada el 9 de septiembre de 2026:** pública según la API de GitHub de esa fecha. Vuelve a comprobarla antes de subir información nueva; los datos identificables de participantes deben mantenerse fuera del repositorio.

## Propósito del repositorio

Este repositorio es la fuente central de trazabilidad del proyecto. Ordena y relaciona:

- contexto, antecedentes y evolución de Relevo;
- fuentes y niveles de evidencia;
- decisiones de investigación y diseño;
- análisis de usuarios;
- estado del arte y mercado;
- flujos de usuario, diseño y funcionamiento técnico;
- desarrollo del producto phygital;
- factibilidad, producción y costos;
- validaciones;
- versiones de la memoria;
- tareas pendientes mediante GitHub Issues.

## Síntesis vigente

A veces una persona sigue viendo contenido en el teléfono aunque antes quería leer, caminar, dibujar o comenzar otra actividad. No necesariamente olvidó esa intención: mientras la sesión continúa, esa posibilidad puede dejar de participar en la siguiente decisión.

Relevo busca que esa intención vuelva a estar presente. La persona registra la actividad y responde cómo podría comenzar en una aplicación Android, y deja un objeto pequeño en ese lugar. Si se cumple una condición configurada, el objeto emite una señal breve de luz y sonido. La persona puede iniciar la actividad, seguir con el teléfono, silenciar la señal o cambiar de idea. La documentación llama `primer paso` a esa acción breve y concreta; la interfaz utiliza lenguaje cotidiano.

En términos de diseño, Relevo es un sistema phygital: la aplicación organiza, el objeto señala, el lugar aporta significado y la persona conserva la decisión. No pretende prohibir aplicaciones, reducir el tiempo de pantalla como fin en sí mismo ni evaluar el comportamiento.

Esta formulación continúa abierta a revisión. El producto final deberá responder a la investigación y a la evidencia, no antecederlas.

La versión breve y mantenida después de cada actualización está en el [resumen vigente de Relevo](08_memoria/resumen-vigente-proyecto.md).

Para una lectura ejecutiva del proyecto completo, con su evolución desde el Pase, el feedback aplicado, las investigaciones, decisiones, propuesta de valor y pendientes, consultar el [resumen general del proyecto](00_gobernanza/resumen-general-del-proyecto.md).

Para explicarlo a público general, comisiones, posibles usuarios o equipos de desarrollo, consultar la [guía de comunicación y explicación de Relevo](00_gobernanza/guia-comunicacion-relevo.md).

La definición física más reciente se encuentra en el [estudio del testigo compacto](06_desarrollo_y_factibilidad/estudio-dispositivo-compacto-luz-sonido-2026-09-07.md). El [sistema de marca vigente](10_recursos_visuales/14_sistema-de-marca-vigente.md) cierra nombre, categoría, frase, descriptor, tipografía, paleta y reglas por soporte. La ruta de fabricación distingue una prueba temprana con una plataforma existente de la integración portátil y se detalla en [plataformas físicas existentes y modificables](06_desarrollo_y_factibilidad/plataformas-existentes-modificables-2026-09-07.md).

## Estado actual — 24 de septiembre de 2026

La aplicación Android vigente es **Relevo 2.6**, prototipo de depuración para Android 12 o posterior. Permite elegir varias aplicaciones cuyos tiempos se suman en un límite, preparar actividades, elegir la salida de sonido y probarla, consultar historial y gestionar consentimiento y eliminación. Compila y pasó diez pruebas unitarias; se revisaron algunas pantallas en emulador. Aún no se ha comprobado el ciclo completo, audio Bluetooth con hardware real, sincronización de eventos ni borrado extremo a extremo. No hay resultados de validación con participantes. Consulta el [README de Android](06_desarrollo_y_factibilidad/app-android/README.md) y la [auditoría del feedback docente](06_desarrollo_y_factibilidad/app-android/revision-feedback-2026-09-23.md).

El proyecto sigue siendo **phygital**: la app organiza la intención y el testigo físico propuesto devuelve una señal en el lugar asociado a la actividad. El parlante Bluetooth actual es una salida de prueba, no el objeto final de Relevo. El valor diferencial —que una señal física y situada aporte más que una notificación— sigue pendiente de evaluación.

La fuente académica vigente es la [memoria v4](08_memoria/memoria-vigente-v4.md), avanzada pero no final. La [investigación visual escrita](10_recursos_visuales/README.md) y el [sistema de marca vigente](10_recursos_visuales/14_sistema-de-marca-vigente.md) orientan su desarrollo; la forma del objeto y sus parámetros de luz y sonido requieren pruebas. La [síntesis vigente del proyecto](08_memoria/resumen-vigente-proyecto.md) registra qué existe y qué falta sin atribuir resultados.

La investigación de usuarios se basa en ocho entrevistas presenciales realizadas en Santiago el 11 y 12 de junio de 2026, con personas de 19 a 27 años, reclutadas por referencias y con consentimiento oral. El análisis es cualitativo exploratorio, no representativo. La encuesta separada de 70 personas sigue pendiente de revisar y no integra todavía la evidencia vigente.

Las prioridades inmediatas son alinear instrumentos y gobernanza con Android 2.6, comprobar el consentimiento y la eliminación de datos, ensayar el prototipo en un teléfono y parlante reales, y resolver la ruta de construcción física. El plan de cierre conserva como metas el 31 de octubre para el producto casi terminado, el 15 de noviembre para el cierre interno, el 2 de diciembre para la memoria y el 14–18 de diciembre para el examen; verificar su vigencia en el plan y en las Issues.

Para migrar el trabajo a Claude, abre el repositorio con `CLAUDE.md` disponible y sigue [`00_gobernanza/INICIO-CLAUDE.md`](00_gobernanza/INICIO-CLAUDE.md) y el [traspaso completo](00_gobernanza/traspaso-a-claude-2026-09-24.md). El estado de GitHub Issues debe consultarse directamente; no se verificó al preparar este corte.

## Inicio para nuevas conversaciones

Para ChatGPT o Codex, usa [Instrucciones maestras para conversaciones](INSTRUCCIONES_CHATGPT.md). Para Claude, el archivo raíz [`CLAUDE.md`](CLAUDE.md) remite a las [instrucciones de inicio](00_gobernanza/INICIO-CLAUDE.md) y al traspaso completo del proyecto.

Para ubicar rápidamente cada área, consulta el [índice operativo del repositorio](00_gobernanza/indice-del-repositorio.md).

## Principios de trabajo

- Investigar antes de concluir o diseñar.
- Desarrollar una sola área principal a la vez.
- Vincular cada decisión del producto con evidencia, una hipótesis o una restricción explícita.
- Distinguir hechos, interpretaciones, hipótesis y decisiones.
- Preferir bibliografía académica publicada desde 2019; usar fuentes anteriores cuando sean fundamentales o no exista evidencia reciente equivalente.
- Redactar en español claro y académico, con citas y referencias según APA 7.
- Explicar los conceptos especializados en su primera aparición.
- Evitar contenido de relleno, reiteraciones y afirmaciones no respaldadas.
- Usar consistentemente el término **phygital**.
- No mencionar encargos, talleres o procesos docentes internos dentro del cuerpo definitivo de la memoria.
- Mantener los datos identificables fuera del repositorio.
- Cerrar cada documento Markdown con un registro de cambios.
- Registrar tanto lo que se decide como la evidencia y la razón de la decisión.
- Sincronizar el [resumen vigente](08_memoria/resumen-vigente-proyecto.md) cada vez que se modifique la memoria.

Las reglas completas están en [Directrices de trabajo](https://github.com/joan1542003-byte/proyecto-titulo/blob/main/00_gobernanza/directrices-de-trabajo.md).

## Arquitectura

| Directorio | Función |
|---|---|
| `00_admin` | Entregas fechadas, controles y herramientas de apoyo para revisión. |
| `00_gobernanza` | Reglas, metodología de trabajo, hoja de ruta y criterios de calidad. |
| `01_contexto_y_fuentes` | Contexto, inventario, procedencia y evaluación de las fuentes. |
| `02_investigacion` | Preguntas, marco conceptual, fichas bibliográficas y síntesis de evidencia. |
| `03_usuarios` | Datos anonimizados, análisis, patrones, tipos de usuario y recorridos. |
| `04_mercado_y_referentes` | Estado del arte, mercado, comparaciones y oportunidades. |
| `05_propuesta_phygital` | Propósito, arquitectura, interacción, forma y propuesta de valor. |
| `06_desarrollo_y_factibilidad` | Tecnología, producción, costos, riesgos, ventajas y límites. |
| `07_validacion` | Hipótesis, protocolos, resultados y criterios de decisión. |
| `08_memoria` | Memoria activa, anexos, matrices y controles editoriales vigentes. |
| `09_decisiones` | Registro cronológico de decisiones y cambios de dirección. |
| `10_recursos_visuales` | Investigación escrita sobre interfaz, testigo, marca, producto, memoria editorial, alternativas y pruebas. |
| `99_archivo` | Fuentes locales migradas y material antiguo, reemplazado o histórico, con estado y procedencia explícitos. |

## Gestión de tareas

Las acciones pendientes se registran como GitHub Issues. Los documentos Markdown conservan el razonamiento, la evidencia y los resultados; las Issues conservan el estado operativo y los criterios de cierre.

## Registro de cambios (disclaimer)

### 2026-09-24 — Actualización para migración a Claude

- **Qué cambió:** se reemplazó el estado principal que seguía describiendo el banco micro:bit y la planificación de Android previa, por el estado comprobado de Android 2.6; se añadieron enlaces directos al paquete de traspaso.
- **Cómo estaba antes:** la síntesis mezclaba documentación de septiembre temprano con el prototipo actual y podía hacer creer que la primera etapa activa seguía siendo una versión anterior del banco físico.
- **Por qué:** ofrecer una puerta de entrada coherente con el commit vigente y preparar la continuidad del proyecto en Claude sin borrar los antecedentes.

### 2026-09-16 — Sistema de marca cerrado

- **Cambio:** la entrada principal enlaza una única especificación vigente y presenta nombre, frase, descriptor, tipografía y paleta como decisiones del proyecto.
- **Versión anterior:** esos elementos aparecían como materiales provisionales para comparar.
- **Motivo:** pasar de exploración a producción consistente sin atribuir resultados que todavía requieren prueba.
- **Alcance:** el cierre es de diseño; no acredita eficacia, comprensión ni factibilidad técnica completa.

### 2026-09-15 — Síntesis de marca corregida

- **Cambio:** la portada del repositorio reemplaza el relato de transferencia y el color de presencia por una estrategia basada en posición, experiencia y prueba.
- **Versión anterior:** la síntesis presentaba el turquesa y una interpretación del nombre como fundamento provisional de marca.
- **Motivo:** evitar que recursos expresivos anticipen una identidad que todavía no ha sido comparada.
- **Alcance:** los materiales visuales actuales siguen disponibles para prototipos; no son una marca cerrada.

### 2026-09-15 — Lenguaje y relato de marca sincronizados

- **Cambio:** la síntesis diferencia el término analítico `primer paso` de la pregunta pública, e incorpora el color de presencia y el traspaso entre soportes como relato.
- **Versión anterior:** la entrada utilizaba `primer paso` directamente y describía el turquesa solo como un acento funcional.
- **Motivo:** hacer comprensible el producto sin jerga y conectar la identidad con su comportamiento real.
- **Alcance:** nombre, descriptor y paleta continúan pendientes de prueba. El conteo académico vigente es de 15.274 palabras.

### 2026-09-15 — Primera dirección visual especificada

- **Cambio:** la entrada principal incorpora Presencia útil, Source Sans 3 y una paleta neutra con acento verde turquesa como hipótesis para prototipar.
- **Versión anterior:** después del reinicio, tipografía y color permanecían completamente abiertos y Herramienta serena solo describía una orientación general.
- **Motivo:** permitir comparaciones concretas y trazables sin presentar una preferencia estética como identidad final.
- **Alcance:** no existen resultados de validación; el descriptor, el logotipo definitivo, la forma física y el color de la señal siguen abiertos. El conteo académico se actualizó de 15.033 a 15.127 palabras mediante el mismo método reproducible.

### 2026-09-11 — Reinicio de la investigación visual

- **Cambio:** la entrada principal enlaza el nuevo estudio visual y vuelve a declarar abiertos nombre comercial, descriptor, paleta, tipografía, logotipo y forma.
- **Versión anterior:** presentaba como vigente una dirección del 7 de septiembre con tipografías y color ámbar ya seleccionados.
- **Motivo:** la auditoría encontró decisiones gráficas incompatibles y una producción mayor que su validación.
- **Alcance:** se retiró la apariencia anterior, no la estructura funcional del proyecto ni el wireframe v1.


### 2026-09-09 — Limpieza y vigencia documental

- **Cambio:** se enlazó el control textual actual y se aclaró la consulta de versiones.
- **Antes:** el recorrido de lectura no distinguía todos los cambios posteriores a las auditorías y exportaciones anteriores.
- **Motivo:** facilitar una entrada única a la revisión y evitar estados contradictorios.
- **Alcance:** Revisión documental; no añade resultados ni modifica el protocolo o los artefactos.

### 2026-09-09 — Extensión aproximada de 15.000 palabras

- **Cambio:** se sincronizó el objetivo y el conteo después de condensar la memoria.
- **Versión anterior:** se informaban 17.920 palabras previas a la bibliografía, sin un objetivo editorial acotado a 15.000.
- **Motivo:** aplicar el límite aproximado solicitado por el autor y conservar un criterio de conteo explícito.
- **Alcance:** preliminares y capítulos 1–13; bibliografía y registro administrativo se cuentan aparte. No se añaden resultados ni cambian las pruebas.

### 2026-09-09 — Jerarquía y lectura de la memoria

- **Cambio:** se actualizó la referencia a la memoria después de agrupar apartados, mejorar transiciones y sustituir la numeración secundaria por títulos temáticos.
- **Versión anterior:** conservaba ubicaciones o controles correspondientes a los subapartados numerados.
- **Motivo:** mantener la trazabilidad sin obligar al lector a reconstruir la estructura anterior.
- **Alcance:** revisión editorial; fuentes, protocolo y resultados pendientes se mantienen.

### 2026-09-09 — Coherencia de la memoria

- **Cambio:** se sincronizó este documento con la revisión de la memoria y su auditoría de cobertura.
- **Versión anterior:** describía el estado previo a la reconciliación del recorrido, soporte y alcance comparativo.
- **Motivo:** mantener una base académica consistente y pendientes localizables.
- **Alcance:** documental; no incorpora resultados ni modifica el protocolo.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se añadió acceso directo a la matriz del feedback y se corrigió la descripción de visibilidad con el estado público comprobado en GitHub.
- **Versión anterior:** La respuesta estaba dispersa o conservaba formulaciones anteriores.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.

### 2026-09-09 — Wireframe v1 cerrado

- **Cambio:** el estado actual enlaza la línea base congelada y sitúa la navegación Android como siguiente trabajo de interfaz.
- **Versión anterior:** el README todavía presentaba el congelamiento como tarea de la semana.
- **Motivo:** mantener la entrada del repositorio sincronizada con el cierre comprobado.
- **Alcance:** no se modifican las pruebas físicas ni el estado de validación.

### 2026-09-08 — Separación de fuentes activas y material antiguo

- **Cambio:** se enlazó el archivo central de versiones, prototipos y exploraciones reemplazadas; también se precisó el contenido vigente de `08_memoria`.
- **Versión anterior:** los antecedentes convivían dentro de cuatro áreas activas y la migración general todavía figuraba en pausa.
- **Motivo:** ofrecer una sola ruta de lectura por área sin borrar el proceso que fundamentó decisiones posteriores.
- **Alcance:** la reorganización no modifica la formulación, la evidencia ni los resultados pendientes del proyecto.

### 2026-09-08 — Programa micro:bit y límite luminoso

- **Cambio:** el estado principal enlaza el programa compilado, separa el banco con matriz roja de la señal cálida de fase A y actualiza los bloqueos anteriores a participantes.
- **Versión anterior:** `firmware` aparecía como un pendiente total y la plataforma existente no advertía su incompatibilidad cromática.
- **Motivo:** mostrar el avance real sin confundir compilación con funcionamiento ni una luz roja con el material definido por el protocolo.
- **Alcance:** no se ha instalado el binario ni montado o medido la luz externa; no existen resultados.

### 2026-09-07 — Testigo portátil, prueba temprana y comunicación funcional

- **Cambio:** la síntesis explicita luz y sonido, enlaza la arquitectura nRF52840, separa una prueba con plataforma existente de la integración portátil, vincula las Issues #11 y #10 y reemplaza la dirección visual anterior por una comunicación basada en función.
- **Versión anterior:** el estado principal priorizaba la comparación B1/B2 de mesa y una gramática de puntos con rojo de señal; no diferenciaba entre una plataforma de ensayo y el objeto que se integrará después.
- **Motivo:** responder a un objeto pequeño y transportable, reducir mano de obra al inicio y separar la identidad de referentes comerciales.
- **Límite:** no hay compra, construcción, mediciones ni validación; el nombre requiere despeje antes de un uso comercial y la plataforma existente no define el acabado final.

### 2026-09-07 — Estado de prototipado y sistema visual

- **Cambio:** se actualizó la etapa vigente, se enlazó el alcance del primer prototipo y se distinguieron las decisiones visuales ya seleccionadas de las que siguen abiertas.
- **Versión anterior:** el README afirmaba que el trabajo no exigía visualidad, mantenía la tipografía como pendiente y no separaba los 35 estados del alcance inicial de construcción.
- **Motivo:** ofrecer una entrada coherente con los entregables y pendientes reales del repositorio.
- **Alcance:** no acredita validación ni resuelve la revisión electrónica pendiente.

### 2026-09-04 — Entrada del proyecto explicada desde una situación

- **Cambio:** la síntesis comienza con una escena cotidiana, presenta después el funcionamiento y enlaza la guía transversal de comunicación.
- **Versión anterior:** la primera explicación abría con la categoría `proyecto phygital` y una formulación abstracta antes de mostrar una situación de uso.
- **Motivo:** permitir que una persona nueva comprenda primero el problema, el aporte y la decisión abierta, y conozca después la categoría técnica.
- **Alcance:** no se modificaron la formulación académica, el producto ni su estado de validación.

### 2026-09-02 — Encuesta complementaria registrada

- **Cambio:** se añadió al estado principal una encuesta de 70 participantes pendiente de publicación, revisión metodológica e integración al repositorio y a la memoria.
- **Motivo:** hacer visible esta línea de investigación sin confundirla con el corpus P1–P8 ni con resultados ya analizados.
- **Alcance:** la fuente queda documentada como pendiente; no se agregaron conclusiones ni datos identificables.

### 2026-09-02 — Administración incorporada al mapa principal

- **Qué cambió:** se añadió `00_admin` a la arquitectura visible de la portada y se vinculó conceptualmente con las entregas fechadas y sus controles.
- **Cómo estaba antes:** la carpeta existía y era navegable desde otros índices, pero no aparecía en el mapa principal del repositorio.
- **Por qué se decidió:** completar el recorrido de lectura desde la raíz y evitar que las entregas administrativas parezcan una parte ausente del proyecto.
- **Alcance:** no se modificó el contenido de las entregas ni la jerarquía de las áreas de investigación y desarrollo.

### 2026-08-30 — Esquema B2 completado para revisión

- **Cambio:** el estado principal registra que B1 y B2 ya poseen esquemas equivalentes y desplaza la puerta inmediata al inventario y la revisión competente.
- **Versión anterior:** B2 todavía figuraba como una especificación pendiente.
- **Motivo:** mantener el acceso principal sincronizado con el desarrollo técnico real.
- **Alcance:** ninguna variante ha sido revisada, construida, energizada ni seleccionada.

### 2026-08-30 — Ruta técnica sincronizada con la comparación de 5 V

- **Cambio:** el estado principal reemplaza el montaje de 12 V como siguiente compra por una comparación previa entre B1 y B2 de 5 V, gestionada en la Issue #10.
- **Versión anterior:** la portada todavía presentaba Nano, tira de 12 V y su circuito como la única arquitectura preparada para avanzar.
- **Motivo:** la revisión posterior demostró que deben compararse fuentes luminosas pequeñas antes de consolidar potencia, forma y costo.
- **Alcance:** la activación cableada y la Issue #8 se mantienen; no se compraron piezas, no se energizó un circuito y 12 V continúa disponible como respaldo.

### 2026-08-30 — Puerta eléctrica explicitada

- **Cambio:** la portada distingue el costo parcial del montaje, enlaza el esquema de conexión y declara las condiciones que impiden energizar el circuito.
- **Versión anterior:** resumía esos pendientes como una revisión general y podía dar a entender que la lista de materiales estaba completa.
- **Motivo:** evitar que la portada contradiga la documentación técnica y que una arquitectura provisional se interprete como un montaje seguro o validado.
- **Alcance:** no se modificó el diseño del circuito ni se añadieron costos, componentes o resultados.

### 2026-08-30 — Montaje de fase A y calendario sincronizados

- **Cambio:** el estado principal enlaza la arquitectura cableada, sus costos, el firmware provisional y las puertas que siguen pendientes; también corrige la entrega de memoria al 2 de diciembre y el examen al periodo del 14 al 18.
- **Versión anterior:** solo informaba requisitos e instrumentos, por lo que no distinguía el avance de diseño técnico de una construcción todavía inexistente, y conservaba el 11 de diciembre como fecha estimada.
- **Motivo:** mantener visible el siguiente paso real sin presentar código o lista de materiales como funcionamiento comprobado.
- **Alcance:** no se compraron componentes, no se compiló el firmware y no se ejecutaron ensayos.

### 2026-08-29 — Plan de cierre hasta la entrega

- **Cambio:** se incorporaron el estado de madurez, los hitos de cierre de octubre, noviembre y diciembre, y la Issue #9 como tablero operativo.
- **Versión anterior:** el README identificaba la línea activa, pero no comunicaba el plazo total ni la función de cada periodo.
- **Motivo:** permitir que cualquier conversación o colaborador comprenda de inmediato qué debe terminarse y cuándo.
- **Alcance:** no se modificó la memoria ni se añadieron resultados de validación.

### 2026-08-28 — Aplicaciones del sistema visual

- **Cambio:** se enlazaron las exploraciones coordinadas para objeto, memoria y aplicación.
- **Versión anterior:** el estado principal informaba la selección visual, pero no sus aplicaciones por soporte.
- **Motivo:** facilitar acceso a las piezas, fundamentos, auditoría y decisiones asociadas.

### 2026-08-28 — Dirección visual seleccionada

- **Cambio:** se actualizó el estado visual desde exploración abierta a dirección conceptual seleccionada.
- **Versión anterior:** el repositorio informaba tres alternativas sin selección.
- **Motivo:** reflejar la decisión del autor y mantener visibles los aspectos que todavía requieren desarrollo o validación.

### 2026-08-28 — Dirección visual en exploración

- **Cambio:** se enlazó el nuevo proceso visual y se distinguieron alternativas, criterios y decisiones todavía abiertas.
- **Versión anterior:** el estado principal no permitía localizar una investigación visual sistemática.
- **Motivo:** mantener accesible la documentación sin presentar una exploración como identidad final.
- **Alcance:** la memoria y la arquitectura funcional de Relevo no cambiaron.

### 2026-08-28 — Estado operativo de la primera validación

- **Cambio:** se enlazaron los instrumentos preparados y se distinguieron las condiciones pendientes de las fases A y B.
- **Versión anterior:** el estado solo indicaba que la prueba de asociación era la línea activa.
- **Motivo:** evitar que la preparación documental se confunda con ejecución o resultados.
- **Alcance:** no se construyó el prototipo, no se reclutaron participantes y no se registraron datos.

### 2026-08-26 — Activación de la memoria v4

- **Cambio:** se declaró `08_memoria/memoria-vigente-v4.md` como base académica activa y se actualizó la descripción breve del proyecto.
- **Versión anterior:** la raíz remitía a la v3, empleaba una denominación compleja para el fenómeno y nombraba la siguiente prueba mediante un código interno.
- **Motivo:** mantener el repositorio sincronizado con una memoria más fiel al orden del primer semestre y más clara para lectores externos.
- **Alcance:** la definición funcional de Relevo se mantiene; cambia la forma de narrarla y documentarla.

### 2026-08-26 — Activación de la memoria v3

- **Cambio:** se declaró `08_memoria/memoria-vigente-v3.md` como base académica activa y se enlazó su auditoría narrativa.
- **Versión anterior:** la v2 era el cierre editorial vigente y presentaba la formulación antes de completar el fundamento investigativo.
- **Motivo:** recuperar el orden del cierre del primer semestre y cumplir la rúbrica mediante aristas, justificación, tres ámbitos teóricos, usuarios, estado del arte y criterios antes de la formulación.
- **Alcance:** la definición funcional de Relevo se mantiene; no se añadieron resultados de prototipo.

### 2026-08-25 — Cierre editorial de la memoria

- **Cambio:** se declaró la memoria activa como cierre editorial del estado real y se registró la cobertura estructural de 35 estados.
- **Versión anterior:** la memoria v2 estaba auditada, pero el desarrollo posterior de wireframes permanecía documentado solo en la propuesta phygital.
- **Motivo:** mantener sincronizados investigación, diseño y estado operativo del repositorio.
- **Alcance:** el siguiente trabajo sustantivo continúa en la Issue #8 dedicada a P0; no se agregaron resultados de validación inexistentes.

### 2026-08-25 — Cierre del Encargo 17

- **Cambio:** se registró la entrega de nueve wireframes estructurales en Figma y se cerró la Issue #6.
- **Versión anterior:** el Encargo 17 permanecía en pausa mientras la memoria integral tenía prioridad.
- **Motivo:** la memoria v2 permitió cerrar el ciclo mínimo, desarrollar tres interacciones conectadas y auditarlas contra la pauta.
- **Alcance:** la entrega resuelve estructura; condición, señal, forma y factibilidad pasan a P0–P4.

### 2026-08-25 — Primera colección visual exploratoria

- **Cambio:** se añadió `10_recursos_visuales` con escenas, texturas, recursos transparentes, variantes cromáticas y una hoja de contacto para explorar una línea visual de Relevo.
- **Motivo:** disponer de material gráfico coherente con la relación entre intención, primer paso, lugar y pulso ambiental.
- **Límite:** los recursos son sintéticos y exploratorios; no representan evidencia de usuarios ni cierran la forma, materialidad o señal final del testigo.

### 2026-08-24 — Definición positiva del testigo

- **Cambio:** se reemplazó la descripción negativa del objeto por su función concreta como testigo físico situado de una intención activa.
- **Versión anterior:** la síntesis lo definía principalmente mediante una exclusión técnica.
- **Motivo:** una propuesta de valor debe explicar qué hace y qué relación construye, no enumerar componentes ausentes.
- **Alcance:** la interfaz objetual seguirá basada en señales ambientales; canal, forma y electrónica se cerrarán mediante desarrollo y prueba.

### 2026-08-24 — Recuperación del historial estructural

- **Cambio:** se enlazaron el resumen vigente y la matriz histórica de encargos, y se estableció su actualización junto con la memoria.
- **Versión anterior:** el README enlazaba la memoria y su auditoría, pero no ofrecía una síntesis breve ni la trazabilidad de requisitos acumulativos.
- **Motivo:** permitir que el autor y nuevas conversaciones comprendan rápidamente qué es Relevo y por qué la memoria adopta su estructura.
- **Alcance:** el resumen no sustituye la memoria; la matriz histórica orienta organización y no se cita como evidencia académica del problema.

### 2026-08-24 — Activación de la memoria integral v2

- **Cambio:** se declaró `memoria-vigente-v2.md` como base académica activa y se enlazó su auditoría rectora.
- **Versión anterior:** `memoria-vigente.md` era la base activa y la preparación escrita de la Issue #6 compartía prioridad.
- **Motivo:** la v2 integra investigación, usuarios, mercado, propuesta, flujos, producción, gestión y evaluación con estados de evidencia explícitos.
- **Alcance:** la v1 se preserva; las Issues #4 y #6 permanecen pausadas; la Issue #7 conserva el seguimiento de los pendientes críticos de la memoria.

### 2026-08-24 — Memoria vigente y Encargo 17

- **Cambio:** se actualizó la línea activa y se enlazaron memoria y preparación escrita.
- **Versión anterior:** la migración documental era la única línea activa.
- **Motivo:** priorizar escritura antes de visualidad.
- **Alcance:** la migración queda pausada; el canal y la forma del testigo siguen abiertos a desarrollo y prueba.


### 2026-08-23 — Instrucciones para nuevas conversaciones

- **Cambio:** se añadió un acceso directo a las instrucciones maestras para ChatGPT y Codex.
- **Versión anterior:** una conversación nueva debía reconstruir el protocolo desde varios documentos y mensajes previos.
- **Motivo:** asegurar continuidad, lectura correcta de GitHub y recuperación del estado vigente desde las Issues.
- **Decisión derivada:** toda conversación nueva debe comenzar por el repositorio y no por recuerdos aislados.

### 2026-08-23 — Activación de la migración documental

- **Cambio:** se pausó el desarrollo de personas, se registró que la edad es el único criterio común y se enlazó la nueva arquitectura de fuentes locales.
- **Versión anterior:** el siguiente paso activo era construir personas y recorridos.
- **Motivo:** el autor priorizó convertir y ordenar la documentación local antes de continuar el desarrollo analítico.
- **Decisión derivada:** trabajar una sola línea principal mediante la Issue #4; no añadir visualidad de personas mientras no sea exigida.

### 2026-08-23 — Integridad del corpus y tipología

- **Cambio:** se precisó el rango observado y se actualizó el estado después de construir corpus anonimizado, libro de códigos, casos, matriz y dos tipos situacionales.
- **Versión anterior:** el README solo indicaba el criterio amplio de 18 a 30 años y situaba la fase antes de la matriz.
- **Motivo:** reflejar los datos efectivos P1–P8 y el avance verificable del análisis.
- **Decisión derivada:** continuar con personas y recorridos sin volver a segmentar por demografía.

### 2026-08-23 — Consolidación metodológica de las entrevistas

- **Cambio:** se incorporaron fecha, rango etario, modalidad, reclutamiento, consentimiento, autoría de preguntas, edad de P6 y estado del corpus.
- **Versión anterior:** la procedencia y el alcance del registro no estaban diferenciados con claridad.
- **Motivo:** el autor confirmó que todo el levantamiento fue hablado, presencial y dirigido por él.
- **Decisión derivada:** usar la transcripción digital anonimizada como corpus operativo y privilegiar paráfrasis en el análisis.

### 2026-08-23 — Inicio de la fase 1

- **Cambio:** se actualizó el estado del proyecto y se enlazaron las Issues de trabajo.
- **Versión anterior:** el repositorio permanecía en fase 0 y describía la procedencia de las entrevistas como una duda abierta.
- **Motivo:** existían antecedentes suficientes para iniciar el análisis de usuarios.

### 2026-08-23 — Inicialización documental

- **Cambio:** se reemplazó el README mínimo por el contexto, propósito, principios y arquitectura del repositorio.
- **Versión anterior:** el archivo contenía únicamente `# proyecto-titulo`.
- **Motivo:** establecer una fuente central, legible y trazable antes de incorporar investigación o desarrollo.
