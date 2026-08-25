---
capitulo: 7
titulo: "Estado del arte, mercado y referentes"
proyecto: Relevo
fecha_de_corte: 2026-08-24
estado: "borrador académico listo para integración; no constituye validación del producto"
documentos_de_apoyo:
  - ../dictamen-rector-reconstruccion-memoria.md
  - ../auditoria-agente-01-arquitectura.md
  - ../auditoria-agente-02-problema-teoria.md
  - ../auditoria-agente-03-metodo-usuarios.md
  - ../auditoria-agente-04-mercado.md
  - ../auditoria-agente-05-sistema-factibilidad.md
  - ../auditoria-agente-06-validacion-editorial.md
  - ../../04_mercado_y_referentes/README.md
---

# 7. Estado del arte, mercado y referentes

## 7.1 Alcance de la búsqueda y criterio de lectura

El estado del arte de Relevo se construye a partir de una pregunta comparativa: ¿qué mecanismos se han desarrollado para apoyar la regulación del uso del teléfono y qué espacio queda para investigar una señal física situada que no bloquee ni registre el cumplimiento? Esta pregunta impide reducir el análisis a una lista de productos parecidos. Un referente es pertinente cuando permite comprender una relación entre intención, condición de activación, señal, entorno, acceso, configuración, privacidad, adopción o modelo económico.

La búsqueda tuvo fecha de corte el 24 de agosto de 2026 y fue exploratoria, no sistemática. Se revisaron documentación oficial de Google y Apple, páginas oficiales de one sec, Brick, Brick Zone, Unpluq, Screenless y Focusaur, y publicaciones académicas localizadas y verificadas mediante DOI, editoriales, PubMed y repositorios institucionales. La estrategia, los términos, los criterios y los límites se conservan en los anexos digitales de búsqueda y fichas de mercado que acompañan este capítulo.

La inclusión priorizó publicaciones de 2019 en adelante, sin excluir antecedentes fundacionales. Así, *The Tangible Reminder* se conserva como antecedente histórico, Aro se retira del núcleo por disponibilidad actual no verificada y AirTag se excluye por pertenecer al rastreo de objetos, no a la autorregulación digital. Estas decisiones delimitan las afirmaciones sostenibles; no demuestran inexistencia ni falta de todo vínculo formal con Relevo.

La evidencia se jerarquizó según la pregunta: revisiones y metaanálisis para la consistencia del campo; estudios experimentales o longitudinales para mecanismos concretos; documentación oficial para compatibilidad y funcionamiento declarado; y páginas comerciales para oferta, precio visible y modelo de valor. Estas últimas no demuestran eficacia independiente. La búsqueda tampoco es un estudio de mercado, patentes o disponibilidad en Chile; por eso la oportunidad se formula dentro del corpus revisado.

## 7.2 Evidencia transversal sobre autocontrol, fricción y permanencia

La literatura muestra que el mercado no se organiza alrededor de una única solución. Biedermann, Schneider y Drachsler (2021) revisaron 28 intervenciones de conciencia, metas, bloqueo, modificación de características y recompensas o sanciones. Los resultados fueron variables: la conciencia aislada tuvo efectos limitados y los mecanismos restrictivos mostraron mejores resultados cuando eran difíciles de eludir. Esta observación no se generaliza a toda sanción ni a todo contexto. La confianza general fue baja por muestras pequeñas, periodos breves y contextos poco comparables; por ello, medir o informar el tiempo no basta para asumir una transición deliberada.

Monge Roffarello y De Russis (2023) sintetizaron 43 estudios. La duración mediana fue de 21 días y solo cinco estudios superaron dos meses; tras tratar valores atípicos, el metaanálisis final reunió siete estudios y estimó un efecto pequeño a medio sobre la reducción del uso no deseado (Hedges’ *g* = 0,47; intervalo de confianza del 95 % [0,27, 0,68]). El resultado no valida una modalidad específica ni equipara menor uso con bienestar. La aproximación a la línea base después de retirar intervenciones vuelve central para Relevo la permanencia de la relación entre intención, señal y contexto.

La duración y el abandono aparecen en estudios de uso real. Grüning et al. (2023) estudiaron one sec durante seis semanas y observaron menos aperturas de aplicaciones objetivo. Haliburton et al. (2024) analizaron datos orgánicos de 1.039 usuarios durante 13,4 semanas y respuestas de 249 personas; observaron pausas y rebote al retomar la intervención. Ambos estudios son específicos de una fricción digital, no de un objeto situado; además, la relación de autores o participantes con el producto limita independencia y transferencia.

Biedermann et al. (2024) encuestaron a 273 estudiantes y observaron que las funciones más conocidas no son necesariamente las más útiles, que una misma plataforma puede servir para estudiar y entretenerse y que existen obstáculos para mantener las herramientas. Entre las razones de interrupción aparecen dejar de necesitarlas, sortear restricciones o encontrarlas demasiado limitantes. Aunque el contexto limita la transferencia a Relevo, el hallazgo advierte que una herramienta puede abandonarse porque su regla ya no coincide con la intención o porque la carga supera su valor.

La evidencia sobre recordatorios agrega un costo que el mercado suele ocultar. Chiu y Gilbert (2024) observaron en dos experimentos preregistrados que aumentar el esfuerzo físico de establecer un recordatorio reducía la descarga de intenciones. El estudio no evalúa un objeto doméstico, pero es directamente pertinente: lugar, armado, prueba de señal, traslado y rearmado son costos de Relevo. La materialidad debe demostrar que el valor de estar situada compensa ese trabajo.

Estas investigaciones obligan a distinguir reducción del uso, interrupción de una apertura, recuerdo de una intención, reconsideración y ejecución de una actividad alternativa. Las herramientas revisadas ofrecen principalmente los dos primeros; Relevo formula como hipótesis los dos siguientes y deja la ejecución fuera del cumplimiento del sistema.

## 7.3 Familias de mecanismos y límites comparativos

### 7.3.1 Medición y pausa nativa en la pantalla

Apple Screen Time y Google Digital Wellbeing representan la infraestructura instalada de medición, programación y restricción. Screen Time muestra actividad de aplicaciones y sitios, permite límites por aplicación o categoría y programa periodos de Downtime; también puede sincronizar ajustes e informes entre dispositivos Apple con una misma cuenta (Apple, s. f.). Digital Wellbeing ofrece informes, temporizadores y modos de desconexión. En ambos casos, la condición se expresa como tiempo, apertura, horario o categoría, y la salida ocurre en la pantalla.

Pause Point acerca más este mecanismo a la pregunta de Relevo. La comunicación oficial de Google lo presenta como una pausa de diez segundos al abrir una aplicación seleccionada, con respiración, temporizador, fotografías o alternativas, y la ayuda de Pixel lo documenta para la serie Pixel 11 con Android 17 o versiones posteriores (Google, s. f.; Sanders, 2026). Por esta condición de disponibilidad debe tratarse como competidor directo parcial, no como una función general de todo Android. Su importancia conceptual es mayor que su alcance comercial: prueba que una plataforma nativa está explorando una intervención intermedia entre ignorar un límite y bloquear por completo.

Estas herramientas son el control de menor costo para Relevo. No requieren comprar, cargar, trasladar ni mantener un objeto. Al mismo tiempo, la señal, el contenido de la intención y la decisión permanecen dentro del flujo del teléfono. La documentación oficial no demuestra que una pausa nativa recupere un primer paso situado, pero sí establece la pregunta que el testigo debe superar: ¿la presencia fuera de la pantalla permite recuperar algo que una pausa con contenido en pantalla no permite, o solo agrega componentes?

### 7.3.2 Fricción y reconsideración en el teléfono

one sec se ubica en una familia distinta: no mide solamente, sino que introduce una fricción en el momento de abrir una aplicación o sitio configurado. Su página oficial declara intervenciones personalizables, horarios, seguimiento de intenciones, funcionamiento local de la lógica y una opción de bloqueo (one sec, s. f.). El producto ha sido estudiado con más detalle que los demás referentes comerciales del corpus. Grüning et al. (2023) observaron cambios en aperturas y Haliburton et al. (2024) documentaron pausas y rebotes durante un uso prolongado. Es una evidencia relevante para la idea de reconsideración, pero no valida una señal física, un lugar congruente ni la ausencia de registro de cumplimiento.

La ventaja de one sec es su cercanía conceptual: la persona puede establecer una intención antes de abrir una aplicación y encontrarse con una intervención que le pide detenerse. Su límite es que la ayuda aparece en la misma superficie que concentra la atención. Además, una intervención repetida puede perder fuerza o ser abandonada. Para Relevo, one sec es un competidor de mecanismo y una referencia de evaluación, no un antecedente que demuestre la necesidad de un objeto. La comparación debe observar si una clave externa reduce la consulta del teléfono o si la señal física termina provocando una nueva consulta para descifrarla.

### 7.3.3 Barreras físico-digitales y llaves de acceso

Brick, Unpluq y Screenless Breaker muestran una oferta comercial más directamente material. Brick utiliza un dispositivo físico como llave para activar y revertir modos que bloquean aplicaciones; la página oficial declara una compra visible de USD 59, aplicación sin suscripción y compatibilidad con Android 12 o posterior e iOS 17 o posterior (Brick LLC, s. f.-a). Unpluq combina una etiqueta NFC, barreras digitales, horarios y estadísticas; la página consultada ofrece una suscripción con duraciones seleccionables y un Tag asociado, compatible con iOS 16 o posterior y Android (Unpluq, s. f.). Screenless Breaker usa NFC pasivo y una llave física para volver a abrir aplicaciones bloqueadas; su precio visible es de €45 (Screenless, s. f.).

Estos productos resuelven una fricción de acceso: si la llave no está disponible, la aplicación permanece bloqueada. Su materialidad no funciona como recordatorio semántico, sino como separación, demora o control de disponibilidad. El cuerpo del objeto representa la posibilidad de acceso y no la actividad alternativa que la persona había elegido. Las páginas oficiales comunican privacidad local, ausencia de nube o ausencia de suscripción en algunos casos, pero esas afirmaciones no equivalen a una auditoría independiente de permisos, retención o funcionamiento.

Brick Zone introduce una variación importante y actual. Su página oficial describe un dispositivo Bluetooth que bloquea aplicaciones automáticamente en espacios como dormitorio, oficina o living; declara que no requiere un toque y que puede acompañar distintos lugares. El precio visible al corte es de USD 99 (Brick LLC, s. f.-b). La página no documenta con precisión una detección de habitaciones, una matriz de compatibilidad específica o el comportamiento ante desconexiones; por eso debe analizarse como bloqueo automático asociado a un espacio declarado, no como prueba de geolocalización. Brick Zone se acerca a Relevo por la combinación Bluetooth–objeto–entorno, pero se distancia por su salida coercitiva: el teléfono queda restringido en vez de emitir una clave que la persona pueda ignorar.

La familia de barreras permite observar dos límites para Relevo. Primero, el objeto físico puede justificar su existencia porque hace difícil el acceso, pero esa dificultad no demuestra que apoye una transición autoelegida. Segundo, la automatización reduce acciones de configuración y, a la vez, puede producir falsos positivos, desconexiones o una sensación de pérdida de control. Relevo conserva la decisión posterior fuera del sistema; por eso debe probar si puede ofrecer presencia situada sin importar la lógica de castigo o cumplimiento propia de una barrera.

### 7.3.4 Objetos de foco, hábitos y recordatorios tangibles

Focusaur representa una familia de productos de foco con múltiples capas: inicio físico, detección del movimiento del teléfono, etiquetas NFC, sonidos, recompensas gamificadas y aplicación. Su página oficial ofrece el dispositivo a USD 129 en oferta frente a un precio de referencia de USD 169 y declara 1.300 patrocinadores de una campaña de Kickstarter de 2026 (Focusaur, s. f.). Estas cifras son señales comerciales de lanzamiento, no evidencia independiente de adopción sostenida. El producto puede hacer visible un compromiso y vincular lugares con hábitos, pero su lógica de recompensa y su barrera para evitar levantar el teléfono se orientan a foco, productividad y cumplimiento. No es un equivalente de Relevo y no debe utilizarse para justificar puntos, rachas o una métrica de obediencia.

*The Tangible Reminder* es un antecedente histórico más preciso para la dimensión situada. Hermann et al. (2007) diseñaron un sistema en que objetos cotidianos identificados por RFID se asociaban con citas y se ubicaban en bandejas; un display ambiental mostraba colores según la urgencia y parpadeaba cuando la cita estaba próxima. El prototipo fue evaluado heurísticamente con 11 participantes. Su valor para Relevo no es comercial ni estadístico: muestra que un objeto elegido puede vincular información digital con un contexto cotidiano y que una señal ambiental puede permanecer periférica hasta volverse más llamativa. Su diferencia es decisiva: utiliza display, colores semánticos y citas temporales. Relevo investiga un testigo sin pantalla, una intención de ocio y una condición digital, por lo que debe demostrar que la asociación puede recuperarse sin repetir el significado en el objeto.

La comparación entre Focusaur y *The Tangible Reminder* muestra que la materialidad puede cumplir funciones distintas: bloquear, premiar, ambientar, representar un estado o servir como clave. No existe una eficacia genérica de lo tangible. El objeto tiene que ser evaluado por la relación específica que organiza.

## 7.4 Adopción, abandono, modelos económicos y restricciones de uso

El mercado revisado ofrece cuatro modelos económicos principales. Las funciones nativas de Apple y Google se integran al sistema operativo y no se venden como dispositivos independientes. one sec opera con funciones esenciales gratuitas y prestaciones premium. Unpluq incorpora una suscripción asociada al Tag y a barreras digitales. Brick y Screenless venden un dispositivo con aplicación complementaria, mientras Focusaur combina hardware, aplicación gratuita y funciones Pro. Los precios visibles de Brick, Brick Zone, Screenless y Focusaur describen una oferta al corte, no una disposición de pago para el público de Relevo ni un costo comparable de producción en Chile; el monto dinámico mostrado por Unpluq no se incorpora a esta comparación porque la interfaz no permite establecer un precio total equivalente.

La adopción tampoco puede inferirse de la existencia de una tienda, de un precio o de una cifra de patrocinadores. Las reseñas, valoraciones y testimonios publicados por las marcas sirven para entender el lenguaje de valor y las fricciones que los usuarios describen, pero están sujetos a selección y no permiten atribuir un cambio al producto. La evidencia más sólida del corpus sobre permanencia proviene de estudios académicos de herramientas concretas. one sec muestra que una fricción puede sostener cambios de apertura durante un periodo y que, al mismo tiempo, existen pausas y rebotes (Grüning et al., 2023; Haliburton et al., 2024). El estudio de Biedermann et al. (2024) indica que la herramienta puede dejar de usarse cuando ya no se necesita, resulta demasiado restrictiva o se puede sortear. Chiu y Gilbert (2024) añaden que la configuración física no es gratuita desde el punto de vista cognitivo y conductual.

Una tendencia reciente es diseñar para la reconfiguración. Kidel Peña-Albert et al. (2026) estudiaron una invitación a reconfigurar nudges en una herramienta digital y encontraron que 46 % de los usuarios del grupo experimental aceptó la propuesta; quienes aceptaron aumentaron su interacción posterior con la intervención. El estudio es cuasiexperimental, se realizó con usuarios pasivos de una aplicación concreta y cuenta con autores vinculados al desarrollo de la herramienta. Aporta una lección acotada: una regla configurada una vez puede dejar de ser pertinente y el sistema debe permitir revisarla sin convertir esa revisión en una sanción. No demuestra que Relevo necesite personalización algorítmica ni que la inteligencia artificial mejore la retención.

Las restricciones técnicas también intervienen en la adopción. Las herramientas nativas dependen de cada sistema operativo; los bloqueadores requieren permisos amplios para observar o restringir aplicaciones; las etiquetas NFC dependen de que el teléfono sea compatible; y los objetos Bluetooth agregan emparejamiento, batería, reconexión y estados de error. La afirmación «local» o «sin nube» de un fabricante debe separarse de la pregunta sobre qué permisos se conceden y qué datos se retienen. Un objeto situado puede sacar la señal del teléfono, pero no elimina por sí mismo la necesidad de que una aplicación conozca una condición de uso.

Para Relevo, el costo de adopción incluye formular una intención, elegir un primer paso, seleccionar una condición digital, conceder permisos, vincular el testigo, situarlo, probar la señal y rearmar el ciclo. Cada operación puede ser válida como parte de la experiencia, pero también puede hacer que la persona abandone. La hipótesis de una sola intención activa y la ausencia de registro de cumplimiento reducen complejidad y protegen autonomía; no garantizan adopción. La validación deberá registrar configuración, reubicación, consulta del teléfono, pérdida de enlace, silenciamiento, abandono y motivos de cambio.

## 7.5 Tendencias y límites del desarrollo actual

El corpus muestra cuatro tendencias convergentes. Primero, las plataformas nativas están desplazándose desde la medición hacia pausas, prompts y opciones de reconfiguración; Pause Point es una señal relevante porque convierte la reconsideración en una función del sistema, aunque su disponibilidad sea restringida. Segundo, el mercado de hardware está probando que una llave física puede convertirse en barrera, y Brick Zone extiende esa lógica hacia el bloqueo automático por Bluetooth y espacio declarado. Tercero, los productos comerciales combinan cada vez más configuración, horarios, estadísticas, gamificación y personalización; esa expansión puede aumentar el valor percibido, pero dificulta saber qué mecanismo produce qué efecto. Cuarto, la investigación longitudinal muestra que la novedad inicial no basta: las pausas, el abandono y el rebote deben formar parte de la evaluación.

La tendencia no resuelve el vacío de Relevo. La evidencia independiente se concentra en intervenciones digitales y en usuarios que ya aceptaron utilizarlas. Para los objetos físicos revisados no se encontró una evaluación independiente que pruebe una combinación de intención autoformulada, condición digital, señal no textual situada junto a un primer paso y respuesta libre. Esta formulación no significa que tal producto no exista en ningún lugar; indica que el corpus público consultado no permite sostenerlo.

## 7.6 Oportunidad acotada e implicancias para Relevo

La oportunidad debe formularse con el alcance que permite la búsqueda:

> En el corpus académico, técnico y comercial consultado hasta el 24 de agosto de 2026 no se encontró un producto vigente que, según la información pública revisada, combine explícitamente una intención de ocio formulada por la persona, una condición digital seleccionada, un objeto físico sin pantalla situado junto a un primer paso fuera de la pantalla y ausencia de bloqueo o registro de cumplimiento. Este resultado delimita una oportunidad de investigación dentro del corpus revisado; no demuestra inexistencia absoluta ni superioridad de Relevo.

La formulación no describe una ventaja adquirida. Describe una combinación que vale la pena poner a prueba porque los referentes existentes separan sus componentes. one sec y Pause Point trabajan la reconsideración, pero dentro de la pantalla. Brick, Brick Zone, Unpluq y Screenless aportan materialidad, pero principalmente como llave o barrera. Focusaur utiliza objetos, lugares y hábitos, pero añade foco, recompensa y cumplimiento. *The Tangible Reminder* prueba históricamente la asociación entre objeto y estado digital, pero utiliza un display y se ocupa de citas. El corpus, por tanto, permite plantear una pregunta específica: si una señal física situada puede conservar la intención fuera de la pantalla sin convertirla en una instrucción, un bloqueo o una métrica.

La materialidad debe compararse con una notificación equivalente. El testigo podría aportar presencia periférica, separación del flujo visual del teléfono, asociación con el lugar del primer paso y una señal que no exponga el contenido de la intención a la pantalla. También puede introducir ambigüedad, carga de configuración, pérdida, batería, enlace Bluetooth, interferencia doméstica, consulta obligada de la aplicación y una sensación de vigilancia. Ningún beneficio puede darse por supuesto. La prueba debe medir por separado si la persona identifica la intención, identifica el primer paso, atribuye la señal, consulta el teléfono, puede ignorarla o silenciarla y reconoce un valor físico que una notificación no entrega.

La siguiente matriz condensa las decisiones que el mercado informa:

| Resultado del estado del arte | Implicación para Relevo | Resultado que debilitaría la decisión |
|---|---|---|
| Las pausas digitales pueden reducir aperturas, pero pierden fuerza o se abandonan. | La señal no debe depender solo de repetición ni de novedad; debe probarse su permanencia y su tono. | La señal situada no se recuerda o se vuelve una molestia después de pocos usos. |
| Las barreras físicas justifican su costo mediante restricción de acceso. | Relevo debe justificar el objeto mediante recuperación y asociación, no mediante bloqueo. | La persona no identifica un valor físico específico frente a una notificación. |
| La configuración y el esfuerzo reducen la descarga de intenciones. | El armado, rearmado y traslado deben ser mínimos, comprensibles y reversibles. | La carga física/técnica supera el beneficio o impide que la persona arme la regla. |
| El contexto y la intención cambian la utilidad de una herramienta. | El usuario principal y el usuario límite deben conservarse como situaciones; el sistema debe permanecer silencioso sin intención alternativa. | La regla activa la señal por duración o aplicación aunque la persona no quiera intervenir. |
| Los productos comerciales hacen afirmaciones de eficacia sin evidencia independiente equivalente. | La memoria debe separar fuente oficial, evidencia académica y resultado propio. | La argumentación depende de testimonios, cifras de marketing o disponibilidad comercial. |

En consecuencia, Relevo puede mantenerse como hipótesis de medio dentro del Proyecto de Título, no como solución ya legitimada por el mercado. Su contribución esperada consiste en documentar las condiciones bajo las cuales una relación phygital —aplicación que conserva el significado, testigo sin pantalla que emite una clave y lugar elegido que puede aportar contexto— ofrece un valor reconocible sin bloqueo, puntaje, racha ni registro de cumplimiento. La comparación con una notificación no es una validación secundaria: es la condición que decide si la capa física merece existir.

El estado de este capítulo permite conservar la organización por mecanismos, retirar Aro y AirTag del núcleo, incorporar Pause Point y Brick Zone como desarrollos actuales y sostener *The Tangible Reminder* como antecedente histórico. También obliga a no afirmar que el producto será adoptado, que la señal funcionará o que la materialidad mejorará el bienestar. Esas afirmaciones pertenecen a la etapa de prototipado y evaluación, donde deberán traducirse en decisiones de mantener, modificar o abandonar.

## Referencias

Apple. (s. f.). *Get started with Screen Time on iPhone*. Recuperado el 24 de agosto de 2026, de https://support.apple.com/en-euro/guide/iphone/iphbfa595995/ios

Biedermann, D., Kister, S., Breitwieser, J., Weidlich, J. y Drachsler, H. (2024). Use of digital self-control tools in higher education: A survey study. *Education and Information Technologies, 29*, 9645–9666. https://doi.org/10.1007/s10639-023-12198-2

Biedermann, D., Schneider, J. y Drachsler, H. (2021). Digital self-control interventions for distracting media multitasking: A systematic review. *Journal of Computer Assisted Learning, 37*(5), 1217–1231. https://doi.org/10.1111/jcal.12581

Brick LLC. (s. f.-a). *Brick: Take back your time*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/

Brick LLC. (s. f.-b). *Brick Zone*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/pages/brick-zone

Chiu, G. y Gilbert, S. J. (2024). Influence of the physical effort of reminder-setting on strategic offloading of delayed intentions. *Quarterly Journal of Experimental Psychology, 77*(6), 1295–1311. https://doi.org/10.1177/17470218231199977

Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits

Google. (s. f.). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Recuperado el 24 de agosto de 2026, de https://support.google.com/pixelphone/answer/9137850?hl=en

Grüning, D. J., Riedel, F. y Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), e2213114120. https://doi.org/10.1073/pnas.2213114120

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A. y Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the CHI Conference on Human Factors in Computing Systems* (Artículo 243, pp. 1–16). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Hermann, M., Mahler, T., de Melo, G. y Weber, M. (2007). The tangible reminder. En *Proceedings of the 3rd IET International Conference on Intelligent Environments* (pp. 144–151). IET. https://doi.org/10.1049/cp:20070359

Kidel Peña-Albert, A., Ingram, S., Khazaal, Y., Litrico, L., Farah, J. C. y Gillet, D. (2026). Restoring engagement in digital self-control tools using nudge reconfiguration prompts: Quasi-experimental study. *JMIR Formative Research, 10*, e85349. https://doi.org/10.2196/85349

Monge Roffarello, A. y De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53, 1–66. https://doi.org/10.1145/3571810

one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

## Registro de cambios (disclaimer)

### 2026-08-24 — Creación del capítulo 7

- **Cambio:** se creó el capítulo académico `04-mercado-referentes.md`, organizado por alcance de búsqueda, evidencia transversal, familias de mecanismos, adopción y abandono, modelos económicos, compatibilidad, privacidad, tendencias y oportunidad acotada.
- **Versión anterior:** el capítulo 6 de `08_memoria/memoria-vigente.md` resumía el estado del arte en una tabla breve por mecanismos, sin registro de búsqueda separado, fichas comparables, Brick Zone, análisis de adopción/abandono ni una lista de referencias específica para el bloque.
- **Decisiones aplicadas:** se conserva la organización por mecanismos; se incorporan Google Digital Wellbeing/Pause Point, Apple Screen Time, one sec, Brick, Brick Zone, Unpluq, Screenless Breaker, Focusaur y *The Tangible Reminder*; Aro queda fuera del núcleo por disponibilidad no verificada y AirTag por diferencia de mecanismo.
- **Correcciones de alcance:** la oportunidad se formula como una combinación no identificada dentro del corpus revisado, no como inexistencia absoluta ni como superioridad de Relevo. Las afirmaciones comerciales se distinguen de la evidencia independiente y los precios se tratan como fotografías de páginas oficiales al 24 de agosto de 2026.
- **Motivo:** convertir el mercado en una base argumental para el Proyecto de Título y preparar la comparación decisiva entre un testigo físico situado y una notificación.
- **Restricción:** este borrador no modifica `08_memoria/memoria-vigente.md`, no agrega resultados de prototipos, no inventa disponibilidad o eficacia y no contiene commit ni push.

### 2026-08-24 — Corrección editorial solicitada

- **Antes:** el cuerpo remitía a rutas de carpetas mediante texto técnico; el registro bibliográfico fechaba como 2026 algunas páginas oficiales sin fecha; Unpluq aparecía con un monto dinámico dentro de la comparación económica; la formulación sobre sanciones podía leerse como una generalización.
- **Después:** el cuerpo indica que el registro de búsqueda y las fichas se conservan como anexos digitales; Apple Support, Google Help y las páginas de Brick pasan a `s. f.` con fecha de recuperación y sufijos `s. f.-a/b`; se retira el monto de Unpluq de la comparación y se aclara que su interfaz no ofrece un total comparable; los mecanismos restrictivos se describen solo bajo la condición de ser difíciles de eludir.
- **Motivo:** eliminar metalenguaje de repositorio, aplicar la convención APA 7 en español del proyecto, evitar una comparación económica engañosa y precisar el alcance de la evidencia sobre restricciones.
