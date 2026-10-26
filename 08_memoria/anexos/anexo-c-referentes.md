# Anexo C. Estado del arte y referentes

> Parte de los [anexos de la memoria](README.md). Se genera con `node construir-anexos.js` desde sus documentos fuente: para corregirlo, se corrige la fuente y se vuelve a generar.

Documenta cómo se buscaron y compararon los productos y antecedentes del capítulo 8: la pregunta, los términos, las fuentes y los criterios de la búsqueda; las fichas comparativas de cada referente, y la exploración acotada de patentes.

## C.1 Registro de la búsqueda

### 1. Pregunta de búsqueda

¿Qué mecanismos, productos y antecedentes técnicos permiten comprender el mercado actual de apoyo a la regulación del uso del teléfono, y qué límites de evidencia, adopción, compatibilidad, privacidad y modelo económico deben considerarse al investigar un sistema phygital como Relevo?

La búsqueda se delimitó a una comparación por mecanismos, no a una colección de productos visualmente parecidos. El foco específico fue identificar qué ocurre cuando una solución: mide, interrumpe, bloquea, dificulta el acceso, sitúa una clave en el entorno o vincula una acción digital con un objeto físico. También se examinó si el referente ofrece evidencia independiente o únicamente promesas de su fabricante.

### 2. Fecha de corte y carácter de la búsqueda

- **Fecha de corte:** 24 de agosto de 2026.
- **Carácter:** exploratorio y no sistemático.
- **Propósito:** construir un mapa de mecanismos y formular una oportunidad de diseño acotada para Relevo.
- **No es:** una revisión sistemática, un metaanálisis, un estudio de tamaño de mercado, una búsqueda exhaustiva de patentes ni una auditoría de disponibilidad internacional.

El 26 de agosto de 2026 se realizó una verificación puntual de vigencia en las páginas oficiales de los referentes nucleares. Esta comprobación actualizó compatibilidades y condiciones de despacho visibles, pero no amplió el corpus ni modificó la fecha de corte de la búsqueda.

Se empleó navegación exploratoria en la web, consultas en español e inglés, revisión de páginas oficiales y seguimiento de DOI, repositorios académicos, páginas de editoriales y registros de publicaciones. La búsqueda se detuvo cuando los mecanismos principales quedaron cubiertos y la información suficiente para comparar cada referente fue verificable. No se declara saturación bibliográfica ni se presenta el corpus como inventario completo del mercado.

### 3. Términos y combinaciones exploradas

Se combinaron términos de problema, mecanismo, soporte y producto. No se conservó un historial literal de cada consulta ni del buscador utilizado. Por ello, la tabla siguiente reconstruye las familias de términos que delimitaron la exploración y permite repetir una búsqueda equivalente, pero no reproducir exactamente el orden de navegación original.

| Campo | Términos en español | Términos en inglés |
|---|---|---|
| Problema | bienestar digital; autocontrol digital; uso poco deliberado; distracción del teléfono; continuidad digital | digital wellbeing; digital self-control; smartphone overuse; mindless scrolling; digital distraction |
| Intervención | fricción; pausa; recordatorio; bloqueo; límite; señal contextual | design friction; self-nudge; pause; reminder; app blocking; lockout; contextual cue |
| Memoria y entorno | memoria prospectiva; descarga de intenciones; recordatorio tangible; objeto situado | prospective memory; intention offloading; tangible reminder; situated reminder; ambient display |
| Soporte físico | objeto sin pantalla; clave física; etiqueta NFC; bloqueo Bluetooth; objeto phygital | screenless device; physical key; NFC tag; Bluetooth blocking; physical-digital wellbeing |
| Productos | Pause Point; Digital Wellbeing; Screen Time; one sec; Brick; Brick Zone; Unpluq; Screenless Breaker; Focusaur | mismos nombres comerciales y sus combinaciones con official, research, evidence, pricing y compatibility |
| Uso sostenido | adopción; abandono; habituación; retención; configuración | adoption; abandonment; habituation; retention; reconfiguration; sustained engagement |

La inclusión de términos de adopción y configuración fue necesaria porque una función puede existir técnicamente y, aun así, exigir una carga que provoque abandono. La inclusión de términos de evidencia permitió separar un resultado experimental de una afirmación de venta.

### 4. Fuentes consultadas y función de cada una

| Tipo de fuente | Fuentes consultadas | Uso en el análisis |
|---|---|---|
| Documentación oficial de plataformas | Google Android y Pixel Help; Apple Support | Verificar funciones nativas, condiciones de disponibilidad y límites de compatibilidad. |
| Sitios oficiales de productos | one sec; Brick y Brick Zone; Unpluq; Screenless; Focusaur | Registrar mecanismo declarado, precio visible, modelo económico, permisos o datos declarados y promesas comerciales. |
| Publicaciones académicas con DOI | Wiley; ACM; PNAS; CHI/ACM; Springer; Sage; JMIR; IET | Contrastar mecanismos con evidencia revisada por pares y registrar límites metodológicos. |
| Repositorios y registros académicos | PubMed, repositorios institucionales, páginas de autores y registros editoriales | Verificar DOI, autoría, año, páginas y acceso a resúmenes o versiones aceptadas. |
| Tiendas y reseñas | Se revisaron solo como señales secundarias cuando la página oficial las incorporaba | No se usaron para afirmar eficacia, adopción sostenida ni causalidad. |

#### 4.1 Corpus nuclear documentado

Las fichas comparativas conservan nueve referentes principales. Esta tabla identifica la fuente primaria y el peso que puede tener en el análisis.

| Referente | Familia | Fuente principal | Tipo de evidencia | Uso legítimo |
| --- | --- | --- | --- | --- |
| Digital Wellbeing y Pause Point | Medición y pausa nativa | Google Pixel Help y blog oficial de Google | Documentación de plataforma | Funciones y disponibilidad declaradas; no eficacia independiente. |
| Apple Screen Time | Medición, límites y horarios | Apple Support | Documentación de plataforma | Funciones y compatibilidad declaradas; no recuperación de intenciones. |
| one sec | Pausa y fricción | Sitio oficial; Grüning et al. (2023); Haliburton et al. (2024) | Comercial y académica específica | Resultados bajo protocolos concretos, considerando vínculos con el producto y selección de usuarios. |
| Brick | Llave física y bloqueo | Sitio y soporte oficial de Brick | Documentación comercial | Mecanismo, compatibilidad, permisos y precio observado; no eficacia sostenida. |
| Brick Zone | Bloqueo físico asociado al espacio | Sitio oficial de Brick | Documentación comercial | Automatización y precio declarados; no precisión espacial ni adopción. |
| Unpluq Tag | Llave NFC y bloqueo | Sitio oficial de Unpluq | Documentación comercial | Mecanismo y modelo de suscripción declarados; no resultados independientes. |
| Screenless Breaker | Llave NFC y bloqueo | Sitio oficial de Screenless | Documentación comercial | Función y precio observado; no eficacia ni disponibilidad chilena. |
| Focusaur | Objeto de foco y hábitos | Sitio oficial de Focusaur | Documentación comercial | Oferta, ritual y funciones declaradas; no eficacia independiente. |
| *The Tangible Reminder* | Recordatorio tangible y ambiental | Hermann et al. (2007) | Publicación académica histórica | Antecedente de asociación entre objetos y estados digitales; no evidencia sobre ocio digital actual. |

Las fichas especializadas incorporan antecedentes adicionales para ampliar mecanismos, investigación reciente y frontera técnica. Estos materiales no se confunden con el corpus comercial nuclear ni aumentan por sí solos la fuerza de la conclusión.

Las páginas comerciales se trataron como evidencia primaria de lo que el producto declara hacer, no de que ese mecanismo produzca el efecto prometido. Las publicaciones académicas se usaron para examinar eficacia, fricción, configuración, abandono y límites, pero no se transfirieron automáticamente a productos con hardware distinto.

### 5. Criterios de inclusión

Se incluyeron fuentes o referentes que cumplieran una o más de las siguientes condiciones:

1. Publicación académica de 2019 en adelante sobre autocontrol digital, fricción, intención, descarga de intenciones, uso sostenido o recordatorios situados.
2. Fuente anterior a 2019 cuando cumple una función fundacional que no fue reemplazada en el corpus; se mantuvo *The Tangible Reminder* (2007) como antecedente histórico de asociación entre objetos y estados digitales.
3. Producto vigente o documentado oficialmente al corte, con una página primaria que permitiera verificar su mecanismo, compatibilidad, precio o modelo económico.
4. Referente que ilumina una decisión de Relevo: señal dentro o fuera de la pantalla, bloqueo, condición de activación, lugar, configuración, privacidad, modelo de negocio, fricción o abandono.
5. Evidencia independiente o semiindependiente que permitiera distinguir entre resultado experimental, estudio observacional, encuesta, comunicación institucional y afirmación comercial.

### 6. Criterios de exclusión y disposición de referentes

Se excluyeron del núcleo los productos que no pudieron documentarse con una fuente oficial actual, los que solo ofrecían una semejanza formal sin relación con el mecanismo estudiado y los que correspondían a otra categoría de problema.

- **Aro:** se retira del núcleo del estado del arte porque su disponibilidad y condición comercial actual no quedaron verificadas con suficiente precisión en la búsqueda de corte. No se afirma que haya desaparecido; solo que no es responsable utilizarlo como referente vigente sin una fuente primaria comprobable.
- **AirTag:** se retira porque su función principal es localizar objetos y emitir alertas de separación, no apoyar la autorregulación del uso del teléfono, la recuperación de una intención ni una condición digital autoelegida. Su presencia física no basta para convertirlo en un antecedente pertinente.
- **Productos sin evidencia independiente:** no se excluyeron automáticamente si el mecanismo era relevante, pero se clasificaron como oferta comercial y no como prueba de eficacia.
- **Herramientas clínicas, control parental o vigilancia de terceros:** quedaron fuera del núcleo salvo cuando ayudaban a delimitar un riesgo de autonomía o privacidad. Relevo se investiga como apoyo autoelegido, no como supervisión.

### 7. Jerarquía de evidencia aplicada

La jerarquía orientó el peso de cada afirmación, no la existencia del producto:

1. **Revisiones sistemáticas y metaanálisis revisados por pares.** Permiten observar la consistencia y los límites del campo, aunque no prueban cada producto actual.
2. **Experimentos, estudios longitudinales y estudios de campo revisados por pares.** Permiten discutir cambios bajo un protocolo concreto; se revisaron muestra, duración, control, selección y posibles conflictos.
3. **Documentación oficial de plataformas.** Es la fuente primaria para disponibilidad, compatibilidad y funcionamiento declarado de una función.
4. **Documentación oficial del fabricante.** Es la fuente primaria para el mecanismo, el precio publicado, el modelo económico y las promesas del producto; no demuestra eficacia independiente.
5. **Tiendas de aplicaciones, reseñas y cifras de usuarios.** Pueden indicar actividad comercial o percepción declarada, pero no se interpretan como validación causal ni como adopción sostenida.
6. **Prensa, blogs, agregadores y páginas de terceros.** Solo sirven para localizar una fuente primaria o contextualizar; no sostienen por sí solos una conclusión del capítulo.

Cuando dos niveles entraron en conflicto, se mantuvo la formulación más limitada. Por ejemplo, una página oficial puede declarar que un dispositivo reduce distracciones, mientras que la revisión académica solo permite decir que el mecanismo tiene una eficacia variable o no evaluada. Ambas informaciones se conservaron, pero no se fusionaron.

### 8. Límites del registro

Este registro tiene los siguientes límites:

- La fecha de corte fija una fotografía temporal de páginas, precios y compatibilidades que pueden cambiar.
- Los precios son los visibles en las páginas consultadas, expresados en la moneda original; no incluyen necesariamente envío, impuestos, importación ni disponibilidad en Chile.
- No se obtuvieron cifras comparables de ventas, retención, devoluciones, soporte, fallas o mercado total.
- No se conserva el número total de resultados recuperados, descartados o duplicados, ni un historial literal de consultas y motores de búsqueda.
- La disponibilidad comercial no equivale a adopción ni a uso sostenido.
- La mayor parte de la evidencia independiente estudia intervenciones digitales, no objetos físicos situados fuera de la pantalla.
- one sec cuenta con estudios específicos, pero estos trabajan con usuarios del propio producto o con vínculos de autoría que deben considerarse al interpretar independencia y generalización.
- Las encuestas y estudios de uso prolongado observan poblaciones y productos concretos; no demuestran que el mismo mecanismo funcione para Relevo.
- No se realizó una búsqueda exhaustiva de patentes, Kickstarter, minoristas, mercados regionales ni literatura no publicada.
- El corpus tiene sesgo lingüístico hacia fuentes en inglés y hacia productos con presencia web pública.
- La ausencia de un producto en este registro no demuestra inexistencia en el mercado.

Por estas razones, la conclusión de oportunidad se formulará como una delimitación del corpus revisado y no como una afirmación de novedad absoluta.

### 9. Consulta del 25 de octubre de 2026: memorias de título chilenas

- **Por qué:** el feedback del Pase de junio pidió incorporar al menos una tesis local de diseño sobre ocio o bienestar digital.
- **Dónde:** Repositorio Académico de la Universidad de Chile. La base de memorias de Diseño UC no respondió desde el equipo de trabajo, y no se encontraron en línea memorias de diseño de la UDP ni de la UDD sobre el tema.
- **Términos:** «celular», «smartphone», «redes sociales», «tiempo libre», «desconexión digital», «bienestar digital» y «uso del celular», combinados con «diseño» o «diseñadora».
- **Incluidas:** Venegas Álvarez (2026), de Diseño, sobre una aplicación de bienestar digital con gamificación narrativa; Riveros Oltra (2023), de Diseño, sobre gamificación y formación de hábitos en Betterfly; y Cortés Concha (2016), de Sociología, sobre el ocio digital de jóvenes en redes sociales.
- **Descartada:** Trincado Rivas (2020), de Diseño Gráfico, porque trata el acoso en redes sociales y no el ocio ni el bienestar digital.
- **Qué se leyó:** las fichas oficiales del repositorio, con su título, carrera, profesor guía y resumen. Los PDF están tras una verificación automática de acceso que no se intentó saltar; el autor puede descargarlos para revisarlos.

## C.2 Fichas de los referentes

Estas fichas registran lo que cada referente declara hacer y el peso que esa información puede tener para Relevo. La frase «afirmación comercial» identifica información proveniente del fabricante o de la plataforma. La frase «evidencia independiente» se reserva para estudios académicos o evaluaciones externas; una página oficial, una reseña de usuario o una cifra de ventas no se transforma en evidencia de eficacia por el solo hecho de estar publicada.

### 1. Google Digital Wellbeing y Pause Point

| Campo | Registro |
|---|---|
| **Familia / fecha** | Herramienta nativa de medición, límites y fricción en pantalla. Pause Point fue documentado oficialmente en 2026; la ayuda consultada fija una condición específica de disponibilidad. |
| **Problema declarado** | Ayudar a comprender y limitar el uso de aplicaciones y añadir una pausa de atención antes de continuar. |
| **Mecanismo** | Digital Wellbeing ofrece informes de uso, temporizadores, modos de desconexión y Focus Mode. Pause Point agrega una intervención de diez segundos al abrir aplicaciones seleccionadas, con opciones de respiración, temporizador, fotografías o alternativas. |
| **Condición** | Apertura o uso de una aplicación seleccionada y configuración previa de Pause Point. La documentación oficial no permite afirmar que detecte automatismo o intención desplazada. |
| **Salida** | Pausa y prompts en la pantalla; el blog oficial indica que desactivar la función requiere reiniciar el teléfono. |
| **Compatibilidad** | Digital Wellbeing varía según dispositivo. Pause Point está documentado oficialmente para la serie Pixel 11 con Android 17 o versiones posteriores; no debe generalizarse a todo Android. |
| **Modelo económico** | Función integrada en el sistema; no se presenta como compra separada. |
| **Datos o permisos** | La herramienta trabaja con estadísticas de uso, aperturas, notificaciones y límites del dispositivo. La documentación revisada no permite especificar aquí todos los permisos internos de Pause Point. |
| **Evidencia independiente** | No se localizó una evaluación independiente específica de Pause Point. Biedermann et al. (2021) y Monge Roffarello y De Russis (2023) permiten contextualizar la variabilidad de las intervenciones digitales, no validar esta función concreta. |
| **Fricción** | Interrumpe dentro del teléfono y exige una pausa antes de continuar; la desactivación añade una fricción técnica. |
| **Límite** | Mantiene la señal, el significado y la decisión en la pantalla; depende de una plataforma y de una familia de dispositivos concreta. La disponibilidad declarada es más estrecha que la de Digital Wellbeing en general. |
| **Aprendizaje para Relevo** | Es un competidor directo parcial: muestra que una plataforma puede interrumpir sin bloquear completamente, pero establece una notificación/prompt como control mínimo. Relevo solo puede justificar un objeto si la señal situada aporta algo que esa pausa en pantalla no aporta. |
| **Fecha y fuente oficial** | Google. (s. f.). *Manage how you spend time on your Pixel phone or Pixel tablet with Digital Wellbeing*. Recuperado el 24 de agosto de 2026, de https://support.google.com/pixelphone/answer/9137850?hl=en ; Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/ |

### 2. Apple Screen Time

| Campo | Registro |
|---|---|
| **Familia / fecha** | Herramienta nativa de medición, programación y restricción en el ecosistema Apple; documentación vigente consultada el 24 de agosto de 2026. |
| **Problema declarado** | Informar cuánto tiempo se utiliza el dispositivo y permitir programar periodos de desconexión, límites de aplicaciones y restricciones. |
| **Mecanismo** | App & Website Activity genera informes; App Limits fija límites por aplicación o categoría; Downtime programa periodos; también permite bloquear aplicaciones, sitios y funciones. |
| **Condición** | Tiempo de uso, calendario de Downtime o regla de aplicación/categoría definida por la persona. El informe no equivale a una lectura del valor subjetivo de la actividad. |
| **Salida** | Reportes, notificaciones, límites y bloqueo o restricción de acceso. El usuario puede modificar o eliminar límites desde la configuración documentada por Apple. |
| **Compatibilidad** | iPhone; la guía indica que los ajustes e informes pueden compartirse entre iPhone, iPad y Mac con la misma cuenta de Apple. |
| **Modelo económico** | Función integrada del sistema; no se presenta como producto separado. |
| **Datos o permisos** | App & Website Activity registra actividad de aplicaciones y sitios; al activar Share Across Devices, los informes, límites y horarios pueden sincronizarse entre dispositivos. |
| **Evidencia independiente** | No se localizó evidencia independiente que demuestre que Screen Time produzca recuperación de intenciones. La literatura de autocontrol digital sirve para evaluar la familia de mecanismo, no esta implementación específica. |
| **Fricción** | Puede medir y restringir sin hardware adicional; su carga se concentra en la configuración y en volver a la misma interfaz para revisar o cambiar reglas. |
| **Límite** | Es una referencia de medición y control, no de señal situada. Puede juzgar por duración o categoría si se configura así, aunque la función no determine por sí misma que una actividad sea problemática. |
| **Aprendizaje para Relevo** | La notificación o límite nativo es el contraste de menor carga. Relevo no debe demostrar solo que puede señalar: debe comparar recuperación de intención, consulta del teléfono, intrusión y valor situado. |
| **Fecha y fuente oficial** | Apple. (s. f.). *Get started with Screen Time on iPhone*. Recuperado el 24 de agosto de 2026, de https://support.apple.com/en-euro/guide/iphone/iphbfa595995/ios |

### 3. one sec

| Campo | Registro |
|---|---|
| **Familia / fecha** | Fricción e interrupción en el momento de abrir una aplicación o sitio. Página oficial consultada el 24 de agosto de 2026. |
| **Problema declarado** | Reducir aperturas impulsivas, scrolling y uso que la persona considera distractor. |
| **Mecanismo** | Intercepta aperturas configuradas y ofrece pausas o intervenciones personalizables; permite horarios, tipos de intervención, seguimiento de intenciones y, según la página oficial, bloqueos completos. |
| **Condición** | Intento de abrir una aplicación o sitio configurado; algunos modos pueden operar por horario o por regla de uso. |
| **Salida** | Interrupción en pantalla, mensaje, pausa y posibilidad de cancelar o bloquear según configuración. El contenido semántico permanece en la interfaz digital. |
| **Compatibilidad** | iOS y Android; la página oficial también declara extensión para Windows, macOS y Linux y uso entre dispositivos con una cuenta. |
| **Modelo económico** | Modelo freemium: la página declara que las funciones esenciales son gratuitas y ofrece funciones premium; la forma exacta de cobro debe verificarse en la tienda correspondiente. |
| **Datos o permisos** | El fabricante afirma que la lógica de intervención funciona localmente y que no perfila ni vende datos. La página no sustituye una auditoría independiente de permisos, almacenamiento o arquitectura. |
| **Evidencia independiente** | Existe evidencia específica, pero no completamente independiente del producto. Grüning et al. (2023) estudiaron one sec en un experimento de seis semanas y observaron menos aperturas de las aplicaciones objetivo; el vínculo de parte del equipo con el producto exige cautela. Haliburton et al. (2024) analizaron datos orgánicos de 1.039 usuarios durante un promedio de 13,4 semanas y encontraron pausas de uso y rebote después de ellas; el diseño no fue aleatorizado y la muestra fue de usuarios existentes. |
| **Fricción** | Se repite en cada apertura o según la programación. Puede aumentar la deliberación, pero también fatigar y ser desactivada. |
| **Límite** | La señal no sale del teléfono; la app puede ser abandonada, modificada o sustituida por otro dispositivo. Los estudios no prueban que el mecanismo recupere un primer paso situado ni que la materialidad sea innecesaria. |
| **Aprendizaje para Relevo** | Es el referente digital más cercano a la idea de intención y reconsideración. Obliga a comparar qué aporta una señal periférica y situada frente a una pausa repetida en pantalla, y a considerar el abandono después de periodos de uso. |
| **Fecha y fuente oficial** | one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/ |

### 4. Brick original

| Campo | Registro |
|---|---|
| **Familia / fecha** | Bloqueo físico-digital mediante dispositivo de contacto. Producto vigente en la página oficial consultada. |
| **Problema declarado** | Evitar aplicaciones y notificaciones consideradas distractoras mediante una separación física del medio de desbloqueo. |
| **Mecanismo** | La persona selecciona aplicaciones y modos en la aplicación y toca el teléfono con Brick para activar el bloqueo; el dispositivo funciona como llave física para revertirlo. |
| **Condición** | Activación por toque o programación; la salida depende de volver a escanear/tocar el dispositivo o utilizar una vía de emergencia. |
| **Salida** | Retira temporalmente aplicaciones y notificaciones seleccionadas; la persona puede desbloquear mediante el Brick o los mecanismos de emergencia declarados por el fabricante. |
| **Compatibilidad** | La página oficial indica Android 12 o posterior e iOS 17 o posterior. |
| **Modelo económico** | Compra única visible de USD 59; la página oficial declara aplicación complementaria y ausencia de suscripción. El precio es una fotografía comercial, no una base para fijar el precio de Relevo. |
| **Datos o permisos** | La documentación de soporte para Android menciona acceso de uso, alarmas y recordatorios, superposición, acceso a notificaciones y servicio de accesibilidad, además de permisos asociados al modo estricto. Son permisos relevantes para el bloqueo, no equivalentes a una privacidad sin acceso a actividad. |
| **Evidencia independiente** | No se localizó una evaluación académica independiente de eficacia del Brick original. Sus reseñas, cifras de valoración y testimonios son señales comerciales o de experiencia declarada, no prueba causal. |
| **Fricción** | Añade separación física, toque, configuración de modos y posibilidad de quedar bloqueado; la emergencia reduce el riesgo, pero también debilita la barrera. |
| **Límite** | El mecanismo principal es impedir acceso, no devolver una intención ni preservar una decisión abierta. Depende de permisos de sistema y de que la persona mantenga disponible la llave física. |
| **Aprendizaje para Relevo** | Demuestra que existe una disposición de mercado a comprar una barrera física, pero no que el bloqueo sea el medio adecuado para Relevo. Sirve como contraste de máxima restricción y como advertencia sobre permisos, recuperación y carga. |
| **Fecha y fuente oficial** | Brick LLC. (s. f.-a). *Brick: Take back your time*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/ ; Brick LLC. (s. f.-b). *What permissions does Brick need access to on my device and why?* Recuperado el 24 de agosto de 2026, de https://support.getbrick.com/en/articles/7950977 |

### 5. Brick Zone

| Campo | Registro |
|---|---|
| **Familia / fecha** | Bloqueo físico-digital automático y situado por espacio; página oficial revisada el 24 de agosto de 2026. |
| **Problema declarado** | Reducir distracciones automáticamente en espacios como dormitorio, oficina o living sin exigir recordar un toque. |
| **Mecanismo** | Dispositivo Bluetooth que se empareja con el teléfono y, según la página oficial, bloquea las aplicaciones por sí mismo. El fabricante lo presenta como «space agnostic» y transportable entre escritorio, mesa y otros lugares. |
| **Condición** | Presencia y vínculo Bluetooth dentro del sistema de bloqueo configurado. La página pública no documenta con precisión la lógica de distancia, zonas, excepciones ni latencia; no se debe afirmar que detecte una habitación de manera independiente. |
| **Salida** | Bloqueo automático de aplicaciones consideradas distractoras. No es una señal de reconsideración ni un recordatorio de una actividad alternativa. |
| **Compatibilidad** | La página de Brick Zone enlaza con aplicaciones iOS y Android, pero la ficha pública específica no entrega una matriz de versiones para este modelo. La compatibilidad detallada queda pendiente de verificación antes de usarla como parámetro técnico. |
| **Modelo económico** | Precio visible de USD 99 en la página oficial. No se infiere si existen costos adicionales, suscripción o diferencias regionales más allá de lo publicado. |
| **Datos o permisos** | El producto depende del ecosistema Brick y de su comunicación Bluetooth; la página de Brick Zone no detalla por sí sola todos los permisos, datos retenidos o fallos de reconexión. |
| **Evidencia independiente** | No se localizó evidencia independiente sobre eficacia, detección espacial o adopción sostenida de Brick Zone. La afirmación de automatización es comercial. |
| **Fricción** | Reduce la acción de toque, pero aumenta la automatización del bloqueo y el riesgo de una restricción inesperada, una desconexión o una condición espacial mal interpretada. |
| **Límite** | Es un competidor directo parcial por la relación entre objeto, Bluetooth y espacio, pero su salida es el bloqueo. No investiga una clave sin texto que la persona pueda ignorar ni la recuperación de un primer paso. |
| **Aprendizaje para Relevo** | Obliga a comparar dos materialidades distintas: objeto como barrera automática frente a objeto como señal situada. También exige documentar si la autonomía y la tolerancia mejoran cuando la persona decide la respuesta en lugar de sufrir un bloqueo. |
| **Fecha y fuente oficial** | Brick LLC. (s. f.-c). *Brick Zone*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/pages/brick-zone |

### 6. Unpluq Tag

| Campo | Registro |
|---|---|
| **Familia / fecha** | Etiqueta física NFC y barreras digitales para bloqueo de aplicaciones; página oficial consultada el 24 de agosto de 2026. |
| **Problema declarado** | Reducir scrolling y accesos considerados automáticos mediante una llave física o barreras digitales. |
| **Mecanismo** | La persona elige aplicaciones, horarios y hasta siete barreras digitales; para abrir una aplicación bloqueada utiliza el Unpluq Tag o una barrera alternativa. |
| **Condición** | Regla de bloqueo por aplicación y horario; el tag NFC funciona como llave de acceso. |
| **Salida** | Bloqueo/desbloqueo de aplicaciones y estadísticas de tiempo de pantalla. |
| **Compatibilidad** | iPhone con iOS 16 o posterior y dispositivos Android, con NFC requerido para el Tag según la información oficial. |
| **Modelo económico** | La página muestra una suscripción premium con selector de 3, 6 o 12 meses y opciones con o sin Tag. La interfaz presenta un monto dinámico, pero no se registra como precio total comparable ni se usa para contrastar costos. |
| **Datos o permisos** | NFC y estadísticas de uso; la página declara seguimiento de hábitos, pero no entrega en la ficha pública un mapa completo de permisos, retención o eliminación. |
| **Evidencia independiente** | No se localizó una evaluación académica independiente de Unpluq. Las cifras de reducción de tiempo y cantidad de usuarios visibles en el sitio se clasifican como afirmaciones comerciales. |
| **Fricción** | Exige llevar o alcanzar el tag, configurar reglas y aceptar una barrera; el bloqueo es intencionalmente difícil de atravesar sin la llave. |
| **Límite** | La clave física controla acceso, pero no contiene ni recupera el significado de una intención. La suscripción añade una condición económica y el NFC depende del dispositivo. |
| **Aprendizaje para Relevo** | Confirma la existencia de un modelo de valor basado en una llave tangible, pero muestra la diferencia entre modificar disponibilidad y apoyar una transición. Relevo no debería reproducir la lógica de bloqueo ni las estadísticas de cumplimiento. |
| **Fecha y fuente oficial** | Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/ |

### 7. Screenless Breaker

| Campo | Registro |
|---|---|
| **Familia / fecha** | Llave física NFC pasiva para bloquear aplicaciones; producto oficial vigente, con información funcional revisada el 24 de agosto de 2026. |
| **Problema declarado** | Impedir el acceso a aplicaciones seleccionadas mediante una barrera que no pueda resolverse desde la pantalla. |
| **Mecanismo** | La aplicación configura aplicaciones bloqueadas y el Breaker funciona como llave NFC física para volver a abrirlas. |
| **Condición** | Escaneo NFC para desbloquear; el bloqueo se arma desde la aplicación. El fabricante también declara modo parental y una salida de emergencia demorada. |
| **Salida** | Bloqueo de aplicaciones y sitios; desbloqueo mediante toque del Breaker o recuperación prevista por la aplicación. |
| **Compatibilidad** | La página contiene una especificación genérica que menciona iOS y Android, pero su FAQ funcional declara que actualmente es compatible con iOS/iPadOS y que Android está planificado. Esta contradicción se registra y no se resuelve a favor de una disponibilidad que no está clara. |
| **Modelo económico** | Precio visible de €45; la página declara ausencia de suscripción y envío gratuito dentro de Alemania. No se infiere disponibilidad en Chile. |
| **Datos o permisos** | El fabricante afirma que no necesita internet, cuenta ni nube y que los datos permanecen en el teléfono. No se localizó una auditoría independiente del modelo de datos ni una lista completa de permisos del sistema. |
| **Evidencia independiente** | No se localizó evidencia académica independiente sobre eficacia o retención de Screenless Breaker. Las 100+ reseñas verificadas declaradas por el fabricante son evidencia comercial de valoración, no de eficacia. |
| **Fricción** | El teléfono queda bloqueado hasta alcanzar el objeto; el dispositivo es pasivo y no requiere batería, pero la pérdida del Breaker y el modo de emergencia son problemas de recuperación. |
| **Límite** | Es una barrera, no un apoyo a la recuperación de una intención. Además, la información de compatibilidad no es internamente consistente. |
| **Aprendizaje para Relevo** | La autonomía puede preservarse mediante una llave elegida, pero el mecanismo produce una consecuencia obligatoria. Relevo debe distinguir físicamente estar presente de físicamente controlar el acceso. |
| **Fecha y fuente oficial** | Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1 |

### 8. Focusaur

| Campo | Registro |
|---|---|
| **Familia / fecha** | Dispositivo de foco, hábitos y barrera física; página oficial vigente consultada el 24 de agosto de 2026. |
| **Problema declarado** | Facilitar sesiones de concentración, reducir la consulta impulsiva del teléfono y convertir hábitos en sesiones con progreso visible. |
| **Mecanismo** | Inicio físico mediante dial y botón; modo de barrera que detecta movimiento del teléfono; etiquetas NFC para hábitos y lugares; sonidos integrados; recompensas con dinosaurios; aplicación y función comercial denominada AI Focus Coach. |
| **Condición** | Inicio de una sesión de foco, colocación del dispositivo sobre el teléfono y/o toque de una etiqueta NFC. La página no permite separar con precisión qué funciones son obligatorias en cada modo. |
| **Salida** | Sesión de foco, sonido, progreso visual en la aplicación, recompensa gamificada y posible fallo de recompensa si se levanta el teléfono, según la presentación comercial. |
| **Compatibilidad** | La página oficial presenta aplicación para iOS y Android. Su política de despacho limita esta tienda a Estados Unidos y remite a otra tienda para Europa; no permite inferir disponibilidad en Chile. |
| **Modelo económico** | Hardware visible a USD 129 en oferta frente a USD 169; kits superiores y plan gratuito/Pro de aplicación. La página declara 1.300+ patrocinadores de Kickstarter 2026, señal comercial de lanzamiento, no prueba de uso sostenido. |
| **Datos o permisos** | El sitio menciona calendarios de Google y Apple, mensajes y correos para organización, además de aplicación y coach. No se asume qué permisos son necesarios ni qué datos se almacenan sin una política técnica específica. |
| **Evidencia independiente** | No se localizó evaluación académica independiente de Focusaur. Las afirmaciones de detección, hábitos, batería, patrocinadores y recompensas son del fabricante. |
| **Fricción** | Carga, dependencia de una sesión, barrera física, recompensa, posible suscripción y aprendizaje de varios modos. La gamificación añade una lógica de evaluación que Relevo excluye. |
| **Límite** | Orienta a foco y productividad, no a ocio digital valorado ni a recuperación de una intención alternativa. Combina muchas funciones y puede dificultar aislar qué mecanismo aporta valor. |
| **Aprendizaje para Relevo** | Muestra que un objeto puede actuar como ancla espacial y ritual, pero también que la materialidad puede convertirse en barrera, recompensa y sistema de cumplimiento. Relevo debe conservar una sola pregunta: si una señal situada aporta valor sin castigo, puntos ni verificación. |
| **Fecha y fuente oficial** | Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits |

### 9. The Tangible Reminder — antecedente histórico

| Campo | Registro |
|---|---|
| **Familia / fecha** | Sistema tangible y display ambiental para recordatorios; antecedente académico de 2007, no producto comercial vigente del mercado revisado. |
| **Problema declarado** | Mantener citas y estados de urgencia presentes sin exigir revisar continuamente un calendario digital. |
| **Mecanismo** | Objetos cotidianos con RFID se asocian a citas; al situarlos en bandejas, un display ambiental muestra colores según la cercanía de la cita y parpadea cuando es urgente. La configuración se realiza con un computador/tableta. |
| **Condición** | Asociación manual entre objeto y cita, ubicación del objeto en una bandeja y proximidad temporal del evento. |
| **Salida** | Color ambiental periférico y parpadeo para atraer atención cuando la cita se aproxima o vence. |
| **Compatibilidad** | Prototipo académico basado en RFID, computador y hardware propio; no corresponde a compatibilidad móvil de mercado actual. |
| **Modelo económico** | Prototipo de investigación; no se documenta precio comercial ni modelo de sostenibilidad. |
| **Datos o permisos** | RFID, aplicación de configuración y base de citas en el prototipo; no se debe transferir su arquitectura de datos a Relevo sin análisis actual. |
| **Evidencia independiente** | El artículo reporta un prototipo y una evaluación heurística con 11 participantes, pero no es una prueba de Relevo ni una evaluación longitudinal de adopción. |
| **Fricción** | Requiere elegir un objeto, asociarlo con una cita, ubicarlo y aprender la relación entre color y urgencia. La señal puede permanecer periférica hasta volverse llamativa. |
| **Límite** | Usa display y colores semánticos; trabaja con citas temporales, no con una intención de ocio autoformulada ni con un objeto sin pantalla. Su vigencia es histórica y conceptual. |
| **Aprendizaje para Relevo** | Sustenta que un objeto elegido puede vincular un significado digital con el entorno y que la señal ambiental puede operar en la periferia. También advierte que la asociación debe ser comprensible: retirar la pantalla no garantiza que la clave sea recuperable. |
| **Fecha y fuente** | Hermann, M., Mahler, T., de Melo, G. y Weber, M. (2007). *The tangible reminder*. En *Proceedings of the 3rd IET International Conference on Intelligent Environments* (pp. 144–151). IET. https://doi.org/10.1049/cp:20070359 |

### 10. Disposiciones de núcleo: Aro y AirTag

| Referente | Disposición | Razón documentada |
|---|---|---|
| Aro | **Retirado del núcleo; no se afirma inexistencia.** | La disponibilidad y el estado comercial actual no quedaron verificados con una fuente primaria suficientemente estable al corte. No debe sostener el estado del arte como producto vigente. |
| AirTag | **Retirado del núcleo.** | Su función es localizar objetos y advertir separaciones; no bloquea aplicaciones, no interrumpe una sesión ni externaliza una intención de ocio. La semejanza material no constituye pertinencia de mecanismo. |

### 11. Evidencia transversal que no pertenece a un solo producto

Estas fuentes no son fichas comerciales, pero permiten interpretar las fichas:

- Biedermann, Schneider y Drachsler (2021) revisaron 28 intervenciones y encontraron resultados variables, baja confianza general, poca eficacia de intervenciones basadas solo en conciencia y mayor exigencia para que las sanciones sean difíciles de eludir.
- Monge Roffarello y De Russis (2023) sintetizaron la literatura de herramientas de autocontrol digital y observaron estudios breves y medidas heterogéneas; su metaanálisis debe leerse como evidencia de un efecto promedio de un conjunto de estudios, no como garantía para un producto específico.
- Biedermann, Kister, Breitwieser, Weidlich y Drachsler (2024) estudiaron 273 estudiantes de educación superior y mostraron que la utilidad percibida, el conocimiento de las funciones, el uso cotidiano y las restricciones no se distribuyen de manera simple. El contexto estudiantil limita la transferencia hacia un hogar adulto joven.
- Chiu y Gilbert (2024) mostraron en dos experimentos preregistrados que aumentar el esfuerzo físico de establecer un recordatorio reduce la descarga de intenciones. Este resultado es especialmente relevante para Relevo: el objeto debe justificar su costo de configuración, traslado y rearmado.
- Kidel Peña-Albert et al. (2026) estudiaron con un diseño cuasiexperimental la reconfiguración de nudges en 252 usuarios pasivos de una herramienta digital; 46 % aceptó la invitación y el grupo aceptante mostró mayor interacción posterior. Es una señal reciente a favor de diseñar para la reconfiguración y la retención, pero proviene de una aplicación específica, de registros de configuración y de un equipo vinculado al desarrollo de la herramienta; no demuestra que la personalización automática sea necesaria para Relevo.

## C.3 Patentes y coincidencias

### 2. Respuesta breve: ¿existe Relevo ya?

**No identifiqué un producto, patente o prototipo documentado que reúna simultáneamente**: una intención alternativa autoformulada en una aplicación; un objeto físico situado deliberadamente junto al primer paso de esa alternativa; una condición vinculada a una sesión de ocio digital poco deliberada; una señal ambiental no textual emitida desde ese lugar; y una respuesta voluntaria que no bloquee, premie, castigue ni evalúe el cumplimiento.

Sí existen todas esas piezas por separado y varias combinaciones parciales. Por ello, Relevo no puede defenderse por tener una aplicación, un objeto conectado, una señal ambiental o una relación con el teléfono. Su vacío defendible está en investigar y demostrar —frente a una notificación convencional— si esa combinación situada ayuda a recuperar una intención sin convertirla en una orden.

### 4. Patentes y riesgo de coincidencia

- **US7577522B2**: recordatorio personal escrito por el usuario y asociado a un área; coincidencia funcional alta, salida digital.
- **US11321677B1**: dispositivo situado donde comienza una acción y recordatorio pasivo; coincidencia formal alta, pero usa display y no teléfono.
- **US20230267422A1**: intención, posición de objeto, ubicación y recordatorio cuando el objeto es visible; coincidencia contextual alta, salida electrónica.
- **US20260082231A1**: objeto próximo que cambia la configuración del teléfono; coincidencia teléfono-objeto alta, pero el mecanismo es bloqueo.

Estos documentos elevan el riesgo de afirmar novedad sobre el concepto amplio. No permiten concluir infracción, patentabilidad ni libertad de operación: para eso se requiere una búsqueda profesional de familias, jurisdicciones, reivindicaciones y estado legal.

### 5. Vacío defendible y decisión para Relevo

El mercado desarrolla tres respuestas: **bloquear** con una llave física; **interrumpir** dentro del teléfono o adherido a él; y **recordar** mediante objetos, lugares o señales ambientales. La evidencia independiente estudia mejor los mecanismos generales que los productos emergentes. Las campañas muestran interés comercial, no eficacia.

El vacío defendible de Relevo es, por tanto, una **pregunta de diseño investigable**: si una intención alternativa elegida por la persona puede permanecer asociada a un lugar de inicio y reaparecer mediante una señal ambiental breve cuando la continuidad digital pierde deliberación, dejando abierta la decisión. La memoria no debe afirmar que esta combinación es inédita; debe demostrar si aporta algo frente a una notificación convencional en recuerdo, identificación del primer paso, autonomía, convivencia y costo de configuración.

### Referencias primarias consultadas

AxLab. (2026). *FocuShift: Actuated intervention to prevent smartphone overuse via phone-attached shape-changing device*. University of Chicago. https://www.axlab.cs.uchicago.edu/projects/focushift

Focusaur. (2026). *Focusaur: The phone-free focus device for deep work and habits*. Kickstarter. https://www.kickstarter.com/projects/focusaur/focusaur-the-ai-focus-console-for-deep-work-and-habits

Hermann, M., Mahler, T., de Melo, G. y Weber, M. (2007). *The tangible reminder*. https://doi.org/10.1049/cp:20070359

Jaye. (2026). *Jaye Band: Frequently asked questions*. Kickstarter. https://www.kickstarter.com/projects/jaye-band/jaye-band-the-worlds-most-discreet-minimalist-smartwatch/faqs

Kim, I. y Xu, M. (2019). *Remind Holder*. https://inhaekim.com/project/remind-holder-2

Menheere, D., de Haan, A., Vos, S. y Lallemand, C. (2021). *Raya: A tangible exercise buddy reminding oneself of the commitment to exercise*. https://doi.org/10.1007/978-3-030-85607-6_60

Newman, J. J. y Newman, R. G. (2022). *Action reminder device and method* (U.S. Patent No. US11321677B1). https://patents.google.com/patent/US11321677B1/en

Smits, T. (2022). *Digital distraction barrier design* [Tesis de magíster, Delft University of Technology]. https://repository.tudelft.nl/record/uuid:b4cff558-72d8-4d16-a7f9-ff26a86bba22

Zekveld, J. E., Bakker, S., Zijlema, A. F. y van den Hoven, E. (2017). *Wobble: Shaping unobtrusive reminders for prospective memories in the home context*. https://doi.org/10.1145/3024969.3024984

Apple Inc. (2023). *Contextual reminders* (U.S. Patent Application Publication No. US20230267422A1). https://patents.google.com/patent/US20230267422A1/en

Brick LLC. (2026). *Electronic device program blocker* (U.S. Patent Application Publication No. US20260082231A1). https://patents.google.com/patent/US20260082231A1/en

Rosenberg, L. B. (2009). *Spatially associated personal reminder system and method* (U.S. Patent No. US7577522B2). https://patents.google.com/patent/US7577522B2/en

Pavclock. (s. f.). *A physical cue for follow-through*. Recuperado el 24 de agosto de 2026, de https://pavclock.com/

Todas las páginas web y registros fueron consultados el 24 de agosto de 2026.

## Referencias

Apple. (s. f.). *Set up Screen Time for yourself on iPhone*. Apple Support. Recuperado el 25 de septiembre de 2026, de https://support.apple.com/en-ie/guide/iphone/iphbfa595995/ios

Biedermann, D., Schneider, J. y Drachsler, H. (2021). Digital self-control interventions for distracting media multitasking: A systematic review. *Journal of Computer Assisted Learning, 37*(5), 1217–1231. https://doi.org/10.1111/jcal.12581

Brick LLC. (s. f.-a). *Brick — Take back control of your screen time*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/

Brick LLC. (s. f.-b). *Brick Zone*. Recuperado el 24 de agosto de 2026, de https://getbrick.com/pages/brick-zone

Chiu, G. y Gilbert, S. J. (2024). Influence of the physical effort of reminder-setting on strategic offloading of delayed intentions. *Quarterly Journal of Experimental Psychology, 77*(6), 1295–1311. https://doi.org/10.1177/17470218231199977

Cortés Concha, O. S. (2016). *Ocio digital y vida cotidiana: alcances de la experiencia social de ocio en las social media por parte de jóvenes nativos y nativas digitales* [Memoria de título, Universidad de Chile]. Repositorio Académico de la Universidad de Chile. https://repositorio.uchile.cl/handle/2250/164071

Focusaur. (s. f.). *Focusaur: The phone-free focus device for deep work & habits*. Recuperado el 24 de agosto de 2026, de https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits

Grüning, D. J., Riedel, F. y Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), Artículo e2213114120. https://doi.org/10.1073/pnas.2213114120

Haliburton, L., Grüning, D. J., Riedel, F., Schmidt, A. y Terzimehić, N. (2024). A longitudinal in-the-wild investigation of design frictions to prevent smartphone overuse. En *Proceedings of the CHI Conference on Human Factors in Computing Systems* (Artículo 243). Association for Computing Machinery. https://doi.org/10.1145/3613904.3642370

Monge Roffarello, A. y De Russis, L. (2023). Achieving digital wellbeing through digital self-control tools: A systematic review and meta-analysis. *ACM Transactions on Computer-Human Interaction, 30*(4), Artículo 53. https://doi.org/10.1145/3571810

one sec. (s. f.). *Cut your screen time in half*. Recuperado el 24 de agosto de 2026, de https://one-sec.app/

Peña-Albert, A. K., Ingram, S., Khazaal, Y., Litrico, L., Farah, J. C. y Gillet, D. (2026). Restoring engagement in digital self-control tools using nudge reconfiguration prompts: Quasi-experimental study. *JMIR Formative Research, 10*, Artículo e85349. https://doi.org/10.2196/85349

Riveros Oltra, J. (2023). *BetterHumans: explorando la gamificación y la formación de hábitos en la retención de usuarios: un estudio de caso de Betterfly* [Memoria de título, Universidad de Chile]. Repositorio Académico de la Universidad de Chile. https://doi.org/10.58011/khxf-cq52

Sanders, S. (2026, 12 de mayo). *Reclaim your time with Pause Point*. Google. https://blog.google/products-and-platforms/platforms/android/pause-point/

Screenless. (s. f.). *Screenless Breaker*. Recuperado el 24 de agosto de 2026, de https://screenlessapp.com/en/products/screenless-breaker-v1

Unpluq. (s. f.). *Unpluq: Stop scrolling. Reduce distractions. Reduce screentime*. Recuperado el 24 de agosto de 2026, de https://www.unpluq.com/

Venegas Álvarez, S. A. (2026). *Gratitud digitalizada: un enfoque en el diseño de aplicaciones para fomentar la gratitud a través de la gamificación narrativa* [Memoria de título, Universidad de Chile]. Repositorio Académico de la Universidad de Chile. https://repositorio.uchile.cl/handle/2250/216623

## Registro de cambios (disclaimer)

### 2026-10-24 — Creación

- **Qué cambió:** el anexo se arma desde sus documentos fuente, con el resto de los anexos A–I de la memoria v5.
- **Cómo estaba antes:** la carpeta de anexos solo tenía un README de la v4, con cinco anexos y sin su contenido.
- **Por qué:** el autor pidió elegir un pendiente de prioridad alta y terminarlo; la memoria v5 remite a nueve anexos que no estaban armados.
