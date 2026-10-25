# Cómo habla Relevo: estudio de los textos de la app

> **Qué es:** un estudio de escritura de interfaces —la disciplina que decide las palabras de una app: títulos, botones, avisos, errores y preguntas— aplicado a Relevo 3.3. Reúne lo que recomiendan las guías y la investigación, revisa cómo escriben apps conocidas, describe cómo habla hoy Relevo y propone una voz, un tono y un vocabulario.
>
> **Qué no es:** no cambia ningún texto de la app. Es la base para la revisión de textos que el autor pedirá después.
>
> **Documentos hermanos:** [Pantallas de la app 3.3](pantallas-de-la-app-3.3.md) describe cada pantalla; el [inventario](inventario-de-textos.md) y la [tabla](textos-de-la-app.csv) listan cada texto con su identificador (T0001…). Los textos de la versión 2.33, la que se usa en la prueba, están en el [inventario de 2.33](inventario-de-textos-android-2.33.md).
>
> **Fecha:** 24 de octubre de 2026. **Versión estudiada:** 3.3 (ramas `android-2.7` y `main`), comparada con 2.33.

## En breve

1. **La base está bien hecha.** Relevo habla de tú, en frases cortas, sin mayúsculas sostenidas, sin «por favor», «lo sentimos» ni «¡Ups!», y sus botones tienen dos palabras en promedio. Es lo que recomiendan Apple, Google, Microsoft y el servicio digital del gobierno británico (GOV.UK).
2. **Los momentos delicados respetan la decisión.** La señal, las preguntas, los errores y el borrado de datos dicen qué pasó y qué se puede hacer, sin culpa, rachas ni premios. Aplican el criterio 4 de la memoria: abrir una elección, no imponer una conducta.
3. **Lo que más conviene revisar es la consistencia.** Un mismo concepto tiene varios nombres: la forma de empezar tiene cuatro y la señal, cinco. «Aviso» nombra cuatro cosas distintas, «contar» significa a la vez *sumar minutos* y *narrar*, y algunas etiquetas no coinciden con la pantalla a la que llevan ni con el nombre que usa Android.
4. **La app habla con tres voces:** «Relevo», «nosotros» y la forma impersonal. Se propone que Relevo hable de lo que hace la app y que «nosotros» quede para el equipo del proyecto.
5. **Se propone una voz con cuatro rasgos** —cercana, clara, respetuosa de la decisión y honesta— y un tono que cambia según el momento: acogedor al empezar, mínimo mientras cuenta, neutro cuando suena y sobrio al hablar de datos.
6. **Los textos ligados al protocolo no deberían cambiar durante la prueba.** La frase de la señal, las preguntas, los cierres de semana, la privacidad y las notificaciones son iguales en 2.33 y 3.3. Cambiarlos mientras dura la prueba afectaría la comparación entre semanas.

## 1. Qué se hizo

**Inventario.** El script [`extraer-textos.js`](extraer-textos.js) lee el código Kotlin de la app y anota cada texto que una persona puede ver o escuchar con el lector de pantalla, con su pantalla, su tipo, su archivo y su línea. La versión 3.3 tiene **1.287 textos y 5.837 palabras** (994 textos distintos) en 34 grupos; sin las listas de ideas ni las piezas de interfaz quedan 824 textos y 4.656 palabras. La versión 2.33 tiene 1.247 textos: 103 textos distintos aparecen solo en 3.3 y 51 solo en 2.33. Unos pocos textos siguen en el código de 3.3 pero ya no se muestran, y el inventario los incluye igual: la tarjeta antigua «Tu semana» (T0528–T0535), el botón de perfil de Inicio (T0150), el renglón «Vuelve a» (T1068) y un control de tiempo anterior (T1061–T1062).

**Fuentes.** Se revisaron cuatro tipos de fuentes:

- guías de plataformas: Apple (2024, 2025), Google (s. f.-b) y Android Developers (2026);
- guías de estilo: Microsoft (2021), en español neutro; Mailchimp (s. f.) y GOV.UK (2018);
- investigación sobre tono, errores, notificaciones y autonomía: Moran (2016), Neusesser y Sunwall (2023), Miller et al. (2007), Smit et al. (2019), Pielot y Rello (2017), Yancey y Settles (2020) y Grüning et al. (2023);
- normas del español y del lenguaje claro: el *Diccionario panhispánico de dudas* (Real Academia Española [RAE] y Asociación de Academias de la Lengua Española [ASALE], s. f.), la *Guía panhispánica de lenguaje claro y accesible* (RAE y ASALE, 2024) y la norma ISO 24495-1 (International Organization for Standardization [ISO], 2023).

**Apps.** Se compararon Bienestar digital (Google), Tiempo en pantalla (Apple), Duolingo y one sec, más las guías de voz de Microsoft y Mailchimp como modelos de escritura. De Google y Apple se analizaron sus páginas oficiales de ayuda en español, que reproducen los nombres de la interfaz; de Duolingo y one sec, la investigación publicada sobre ellas. No se analizaron capturas de esas apps.

**Decisiones previas del proyecto.** El estudio parte de la [guía de comunicación](../../../00_gobernanza/guia-comunicacion-relevo.md) (núcleo verbal del 16 de septiembre de 2026) y de dos decisiones del autor del 27 de septiembre ([registro de decisiones](../../../09_decisiones/registro-de-decisiones.md)):

- **D-083:** textos más naturales y breves; la privacidad se explica en el consentimiento y en Privacidad y datos, sin repetirla en cada pantalla.
- **D-084:** frases en lugar de rótulos sueltos, un vocabulario fijo («Para empezar», «Dónde empiezas», «paso» solo para la ruta), acciones que dicen qué pasa y ningún texto en mayúsculas sostenidas.

Esa guía explica el proyecto a quien no lo conoce. Este estudio se ocupa de otra capa: las palabras dentro de la app.

## 2. Qué recomiendan las fuentes

### 2.1 Voz y tono

- **La voz se mantiene; el tono cambia.** Mailchimp (s. f.) lo resume así: se tiene la misma voz todo el tiempo, pero el tono se ajusta al estado de ánimo de quien lee, y ser claro importa más que ser entretenido. Apple (2025) pide lo mismo: una voz reconocible y un tono que se adapte al contexto.
- **El tono tiene cuatro dimensiones:** formal o casual, serio o divertido, respetuoso o irreverente, y objetivo o entusiasta (Moran, 2016). Sirven para describir un tono sin adjetivos vagos como «amigable».
- **En español, Microsoft (2021) define su voz como cálida y relajada, nítida y clara, y lista para ayudar.** En la práctica: lenguaje de conversación, palabras cotidianas («querer» antes que «desear», «usar» antes que «utilizar», «pedir» antes que «solicitar», «pero» antes que «sin embargo») y frases que hablan directo a la persona.

### 2.2 Claridad y brevedad

- **«Tan largo como necesite, tan corto como pueda»**, dice el equipo de escritura de Apple (2024): una oración por idea y cada oración lo más corta posible.
- **Segmentos breves y fáciles de recorrer, lenguaje simple, segunda persona y tiempo presente** para describir lo que hace el producto; los controles se nombran por su etiqueta, no por su tipo (Google, s. f.-b).
- **Las mismas palabras que usan las personas, lo importante al principio y mayúscula solo al inicio** (GOV.UK, 2018).
- **Lenguaje claro:** la información debe ser pertinente, fácil de encontrar, de entender y de usar (ISO, 2023). La guía panhispánica lo plantea como parte del derecho a comprender (RAE y ASALE, 2024).

### 2.3 Botones y acciones

- **Un botón dice qué va a pasar,** con un verbo («Enviar» mejor que un genérico «¡Vamos!»), y un flujo de varios pasos sigue un patrón estable: empezar, seguir y terminar (Apple, 2025).
- **Un ajuste se describe por lo que hace cuando está encendido,** y un campo puede mostrar un ejemplo como ayuda (Apple, 2025).
- **El texto de un enlace o botón se entiende solo,** sin depender de lo que lo rodea (GOV.UK, 2018).

### 2.4 Errores y validaciones

- **Un buen mensaje de error se ve cerca del problema, usa lenguaje simple, dice qué pasó y qué hacer, no culpa a la persona, no hace bromas y conserva lo que ya escribió** (Neusesser y Sunwall, 2023).
- **En español,** Microsoft (2021) separa con un punto el problema y la solución, evita los signos de exclamación en los errores, prefiere «No se puede…» o «No se pudo…» y desaconseja «Ocurrió un error».
- **«Por favor» y «lo sentimos» sobran** en la mayoría de los mensajes; «lo sentimos» queda para fallos graves (GOV.UK, 2018).

### 2.5 Notificaciones

- **Título de hasta 30 caracteres y texto de hasta 40; sin el nombre de la app,** que Android ya muestra en el encabezado (Android Developers, 2026).
- **No se usa una notificación solo para que la persona vuelva a la app** sin darle un valor directo («Hace tiempo que no te vemos»), y en la pantalla bloqueada se muestra una versión que no revele datos personales (Android Developers, 2026).
- **El permiso de notificaciones se pide en contexto,** explicando qué se gana con él y qué pasa si no se da (Android Developers, 2026).
- **Antes de enviar una notificación, tres preguntas:** ¿hace falta ahora?, ¿le evita a la persona abrir la app?, ¿dice algo que no se haya dicho? (Apple, 2024).
- **La repetición desgasta.** En Duolingo, los recordatorios que la persona no había visto hace poco funcionaron mejor; repetir la misma plantilla insensibiliza (Yancey y Settles, 2020).
- **Las notificaciones también acompañan.** En un día sin alertas, 30 personas se sintieron menos distraídas y más productivas, pero también más ansiosas y menos conectadas con otros (Pielot y Rello, 2017).

### 2.6 Palabras que respetan la autonomía

- **El lenguaje controlador provoca rechazo.** Mensajes con «debes» o «tienes que» aumentaron la reactancia —la sensación de que alguien amenaza la propia libertad—, y recordar que la decisión es de la persona la redujo (Miller et al., 2007).
- **Pero la amabilidad no reemplaza la elección.** Ofrecer opciones reales mejoró la evaluación de una intervención digital; cambiar solo el lenguaje no produjo diferencias significativas (Smit et al., 2019). En one sec, la opción explícita de no abrir la app tuvo el mayor efecto y el mensaje de reflexión, por sí solo, no fue eficaz (Grüning et al., 2023).
- **Esto encaja con la memoria:** la autonomía es una necesidad psicológica básica (Ryan y Deci, 2000) y las rachas pueden volverse una meta en sí mismas (Silverman y Barasch, 2023).

La conclusión para Relevo: el texto amable no basta si no hay opciones; cuando las hay, el texto debe nombrarlas con el mismo peso.

### 2.7 Normas del español

- **Tú en productos de uso personal.** Microsoft (2021) usa tú en sus productos de consumo y usted en los de empresa.
- **Mayúscula solo en la primera palabra** de títulos, botones, menús y opciones (Microsoft, 2021).
- **Sin punto final** en los títulos que ocupan su propia línea ni en las expresiones simples dentro de espacios bien delimitados, como un botón; los letreros también pueden prescindir de él (RAE y ASALE, s. f.). Los signos de interrogación y exclamación sí se escriben.
- **Género:** conviene preguntarse si nombrar el género es necesario (Apple, 2024) y preferir formas que no lo marquen (Microsoft, 2021).
- **Sin modismos innecesarios:** el tono se logra sin frases hechas (Apple, 2024); si una expresión coloquial se puede quitar sin perder sentido, se quita (Microsoft, 2021).
- **Accesibilidad:** frases cortas con una idea, que se entiendan leídas en voz alta por un lector de pantalla, y palabras en lugar de símbolos como «&» o «+» (Microsoft, 2021).

## 3. Cómo escriben otras apps

| App | Cómo nombra | Cómo pide | Cómo avisa o cuenta | Qué toma Relevo | Qué no toma |
| --- | --- | --- | --- | --- | --- |
| **Bienestar digital** (Google, s. f.-a) | Funciones como sustantivos: «Temporizadores de apps», «Modo sin distracciones», «Modo Hora de dormir». | Verbos en infinitivo: «Establecer temporizador», «Tomar un descanso», «Activar ahora». | Al acabarse el tiempo, la app se cierra y su ícono se atenúa. | Nombres cortos y botones en infinitivo. | El bloqueo: Relevo no cierra apps. |
| **Tiempo en pantalla** (Apple, s. f.) | «Horario de Tiempo en pantalla», «Límites de tiempo», «Compartir entre dispositivos». | Instrucciones con «Toca…». | Un reporte semanal describe el uso sin juzgarlo. | Resumen con hechos, sin metas. | Los límites y los promedios diarios como centro. |
| **Duolingo** (Yancey y Settles, 2020) | Un personaje que habla en primera persona. | Recordatorios diarios para practicar. | Plantillas variadas, personalizadas y algunas basadas en rachas. | Variar o personalizar puede evitar el desgaste. | Rachas, presión y personaje insistente. |
| **one sec** (Grüning et al., 2023) | Una pausa antes de abrir la app. | Pregunta si se quiere seguir y ofrece no abrirla. | Respiración breve y opción explícita de desistir. | La decisión explícita con opciones equivalentes. | Interrumpir la app elegida. |
| **Microsoft** (2021) y **Mailchimp** (s. f.) | Guías de voz escritas. | Tú, frases cortas, palabras cotidianas. | Errores sin exclamaciones ni culpa. | Una guía de voz y tono con ejemplos. | El humor seco de Mailchimp: no calza con una señal sobre las propias intenciones. |

**Lo que muestra la comparación.** Las apps de bienestar digital de Google y Apple escriben de forma sobria y funcional: nombran funciones y dan instrucciones, pero su lógica es medir y limitar. Duolingo muestra el otro extremo: personalidad fuerte y recordatorios optimizados para que la persona vuelva, con rachas que Relevo excluye por diseño. one sec es el referente más cercano: interrumpe con una decisión explícita, y su evidencia sugiere que importa más ofrecer la opción que el texto que la acompaña. Relevo puede tomar la sobriedad de Google y Apple, la idea de no repetir siempre lo mismo y la decisión explícita de one sec, sin medir, limitar ni insistir.

## 4. Cómo habla Relevo hoy

### 4.1 Lo que ya funciona

- **Tú en toda la app, sin usted.** Ningún texto trata a la persona de usted y ninguno usa adjetivos con género dirigidos a ella, como «listo» o «lista».
- **Sin fórmulas vacías.** Ningún texto dice «por favor», «lo sentimos» ni «¡Ups!». Solo tres textos llevan exclamación, y los tres celebran el cierre de la prueba (T0189, T0718, T0719).
- **Mayúscula solo al inicio y nada en mayúsculas sostenidas**, como fijó D-084.
- **Botones cortos y con verbo.** Los 62 botones tienen 2 palabras en promedio: «Activar el relevo», «Guardar el paso», «Probar el sonido».
- **Errores que dicen qué hacer.** «No sonó en el parlante. Revisa que esté encendido y conectado.» (T0803); «No se pudo guardar el archivo. Prueba otra vez.» (T0656).
- **Respuestas con el mismo peso.** «¿Qué decidiste?» ofrece tres respuestas iguales en tamaño, color y lugar (T0450–T0452). El agradecimiento no evalúa: «Gracias por contarlo.», «Queda guardado. Puedes prepararlo cuando quieras.», «Está bien. Puedes elegir otra actividad cuando quieras.» (T0810–T0812).
- **Hechos sin metas.** «Tu semana» dice cuántos relevos se prepararon, sin compararlos con otras semanas (T0522–T0527).
- **Confirmaciones que explican las consecuencias.** «Se quita de tus actividades. Los relevos que ya hiciste se mantienen.» (T0643); el borrado de datos dice qué se borra y dónde (T0672).
- **Un consentimiento honesto.** Está ordenado por secciones con títulos claros, incluye «Qué no vemos» y advierte que el código no vuelve anónimos los datos (T0064–T0069).
- **Vocabulario de la casa chilena.** Velador, pieza, mesón de la cocina y sillón (T1040–T1047) nombran lugares reconocibles; la regla de 2.28 evita habitaciones enteras como lugar.
- **Acciones que dicen qué pasa,** como pidió D-084: «Pasar a este paso», «Volver a este paso» (T0465, T0466).

### 4.2 Lo que conviene revisar

Cada punto indica su prioridad: **alta** si puede confundir o desorientar, **media** si resta claridad, **baja** si es de estilo. Son observaciones, no cambios.

**R1. La forma de empezar tiene cuatro nombres (alta).** «Para empezar» (T0110, T0168, T0236, T0491, T0633), «¿Cómo empiezas?» (T0199, T0241, T0216, T0227), «Tu primer paso» y «primer paso» (T0008, T0022, T0206, T0207, T0388) y la frase «Empieza por…» (T0793–T0795). D-084 fijó «Para empezar» y reservó «paso» para la ruta, y la guía de comunicación advirtió que «primer paso» no viene de las entrevistas y puede entenderse de varias maneras. «Tu primer paso» también choca con la ruta, donde «paso» es otra cosa («Paso 2 de 3», T0463). *Propuesta:* volver a D-084: «Para empezar» como rótulo, «¿Cómo empiezas?» como pregunta y «primer paso» solo en la memoria.

**R2. La señal tiene cinco nombres y «aviso» nombra cuatro cosas (alta).** La señal es «el aviso» (T0434), «la señal» (T0429, T0698), «el sonido» (T0438, T0709, T0710), «lo que suena» y «la notificación» (T0823). A la vez, «aviso» es el aviso semanal (T0564), la sección «Avisos y resúmenes» (T0508), el permiso de notificaciones («Para avisarte aunque estés en otra app», T0082) y lo que hace Relevo («Relevo te avisa a tiempo», T0002). Usar una palabra por concepto es una de las primeras reglas de escritura de interfaces (Google, s. f.-b). *Propuesta:* «suena» como verbo y «el sonido» como sustantivo en la app; «aviso semanal» solo para esa notificación; «Notificaciones» solo para el permiso de Android.

**R3. «Contar» significa dos cosas (media).** Relevo *cuenta* minutos («Tu relevo está contando», T0127; «Apps que cuentan», T0261), pero también pide que la persona *cuente* qué hizo («nos cuentas qué hiciste», T0019; «Gracias por contarlo», T0810). En la guía inicial aparecen juntas: «Cuenta tu tiempo» (T0020), justo después de «nos cuentas qué hiciste». Y «Contar más» (T0120), junto a las caras de la opinión rápida, puede leerse como «sumar más». *Propuesta:* «contar» solo para el tiempo; para narrar, «decir» o «responder» («Dinos qué decidiste», «Escribir un comentario»).

**R4. El objeto y la ruta tienen varios nombres (media).** El objeto es «el parlante, el reloj o el Tag» (T0174, T0819), «lo que suena» (T0214, T0242) y «el objeto» (T0730, T0738, T0747). La ruta es la pestaña «Ruta» (T1286), el título «Paso a paso» (T0453), la fila «Tus pasos» (T0504) y la tarjeta «Tu siguiente paso» (T0166). *Propuesta:* «lo que suena» como genérico y el nombre concreto cuando se sabe; un solo nombre para la ruta en pestaña, título y Perfil. Las preguntas de cierre que dicen «objeto» son del protocolo: se revisan después de la prueba.

**R5. Etiquetas que no coinciden con su destino (alta).** El consentimiento dice que los datos se borran «desde Perfil, en Tus datos» (T0071), pero en Perfil la fila se llama «Privacidad y datos» (T0513) y la pantalla se titula «Tus datos» (T0657). Algo parecido, más leve: la fila «Tu opinión» (T0516) abre una pantalla titulada «¿Cómo te resultó Relevo?» (T0750). *Propuesta:* que la fila y el título digan lo mismo y que el consentimiento use ese nombre. Como el texto del consentimiento es el que se aceptó, su cambio debe registrarse.

**R6. Nombres distintos a los de Android (alta).** Relevo llama «Tiempo de uso» (T0078, T0591) a un permiso que Android, en español de América, llama «Acceso a datos de uso» dentro de «Acceso especial de apps» (Android Open Source Project, s. f.). Quien busque «Tiempo de uso» en los ajustes no lo encontrará. En batería, Relevo dice «Sin restricción» y «Con restricción» (T0601, T0602); Android dice «Sin restricciones», «Optimizado» y «Restringido». Los fabricantes pueden cambiar estos nombres. *Propuesta:* conservar el nombre propio si se prefiere, pero decir el de Android en el momento de enviar a los ajustes: «En Android aparece como «Acceso a datos de uso»».

**R7. Tres voces (media).** Relevo habla de sí en tercera persona («Relevo te avisa a tiempo», T0002), en 26 textos aparece un «nosotros» («Te guiamos paso a paso», T0106; «Guardamos lo que haces…», T0659) y otros textos son impersonales («Se borran tus relevos…», T0672). El «nosotros» a veces es el equipo que guarda los datos y a veces la app que guía. *Propuesta:* ver la sección 5.2.

**R8. Títulos con y sin punto (baja).** La mayoría de los títulos no lleva punto final («Antes de empezar», «Tu primer relevo»), pero algunos sí: «Anota algo que quieres hacer.» (T0001) y los saludos de Inicio, «Hola, [nombre].» (T0126). Las segundas líneas de los títulos en dos tonos también terminan en punto (T0127, T0454, T0611). La norma dice que un título aislado no lleva punto (RAE y ASALE, s. f.). *Propuesta:* títulos sin punto final; el título en dos tonos se escribe como una frase de dos partes con un solo criterio.

**R9. Dos palabras para la misma acción (baja).** «Seguir» (T0033, T0091) y «Continuar» (T0424, T0423); «Mantenerlo» (T0406, T0410) y «Cancelar» (T0402, T0674) como opción segura de una confirmación; «Probar otra vez» (T0419) y «Inténtalo de nuevo» (T0653). *Propuesta:* «Seguir» para avanzar, «otra vez» para repetir, y en las confirmaciones una opción segura que diga qué pasa, como «Mantenerlo».

**R10. Cifras y palabras mezcladas (baja).** La hoja del siguiente paso escribe las veces con letras, «Dijiste que empezaste «Leer» tres veces.» (T0372), mientras Perfil usa cifras, «Preparaste 3 relevos» (T0524); y en un mismo texto se lee «Cinco preguntas cortas, unos 2 minutos» (T0191). *Propuesta:* cifras para lo que se cuenta o se mide («5 preguntas», «2 minutos», «3 segundos»), como recomiendan las guías de interfaz para leer de un vistazo.

**R11. Notificaciones largas o con el nombre de la app (media).** La notificación de la señal pone la actividad como título, una buena decisión, y su texto dice «Es momento de volver a elegir. Empieza por [primer paso].» (T0780). Con unos 60 caracteres, la forma de empezar, que es lo más útil, queda al final y puede cortarse en la vista cerrada. La notificación permanente se titula «Relevo está contando tu tiempo en las apps que elegiste» (T0764): 54 caracteres y empieza con el nombre de la app. «Relevo dejó de contar» (T0768) y el aviso semanal (T0789) también ponen «Relevo» en el título, y los textos de fallo (T0775–T0778) superan los 40 caracteres. Lo que sí está bien: en la pantalla bloqueada se muestra una versión genérica que no revela la actividad, y el aviso semanal es opcional, sale como máximo una vez por semana, trae la actividad de la persona y, tras dos «Ahora no», ofrece apagarse. Eso lo aleja de las notificaciones que solo buscan que la persona vuelva. *Propuesta:* la actividad o lo importante en el título; el texto, con lo útil al principio y en menos de 40 caracteres. La frase genérica de la semana del teléfono es del protocolo y se mantiene.

**R12. Textos largos (media).** El consentimiento tiene párrafos de 120, 94 y 77 palabras (T0060, T0056, T0065); el de 120 enumera datos en una sola oración. La ayuda del Tag junta varias instrucciones en un párrafo (T0361, 47 palabras; T0325, 40 palabras con cuatro acciones). El botón «Preparar un relevo con este paso» (T0170, T0462, T0464) tiene 6 palabras. *Propuesta:* listas en el consentimiento, pasos numerados en la ayuda del Tag y botones más cortos («Preparar este paso»). Cambiar el consentimiento requiere registrar la nueva versión.

**R13. Frases abstractas o coloquiales (baja).** «Es momento de volver a elegir» (T0416, T0779) no dice qué se elige; en la pantalla de la señal, la actividad y la forma de empezar aparecen debajo, pero en la notificación genérica no. «¿Cómo te cayó el sonido?» (T0438) es natural en Chile, aunque es un modismo. Las dos son frases del protocolo: si se cambian, debe ser después de la prueba.

**R14. Restos técnicos (baja).** «Detalle técnico: [dato]» (T0649) muestra a la participante el texto crudo de un error de envío. «Supabase» en el consentimiento (T0062) y el nombre de la app iSearching en la ayuda del Tag (T0294, T0361) son necesarios para ser transparentes o para resolver un problema, pero conviene explicarlos la primera vez. El consentimiento dice «testeo» (T0067) donde el resto de la app dice «prueba».

### 4.3 Lo que ve quien participa (versión 2.33)

Las participantes usan 2.33, con la interfaz de 2.30. Las diferencias con 3.3 están sobre todo en Perfil, Preparar, Inicio, Ruta y Apariencia. Por ejemplo, 2.33 dice «Tu ruta» y «Arma tu ruta» donde 3.3 dice «Paso a paso» y «Tus pasos»; «Hagamos tu primer relevo» donde 3.3 dice «Tu primer relevo»; y «Leer más» donde 3.3 dice «Leer». Los textos que importan para la investigación son iguales en las dos versiones: la notificación y la frase de la señal, las preguntas (2.33 no tiene el título «Cuatro preguntas de un toque», pero sí las mismas cuatro preguntas), la privacidad, los cierres de semana y el cierre de la prueba. El cuerpo del consentimiento también es igual; 3.3 solo agrega un subtítulo («Lee lo que aceptas. Puedes salir cuando quieras.») y cambia el botón que despliega cada sección.

## 5. Propuesta: la voz de Relevo

### 5.1 Cuatro rasgos

La voz no cambia de una pantalla a otra. Los ejemplos «Sí» son textos de la app; los ejemplos «No» son inventados para mostrar el contraste.

| Rasgo | Qué significa | Sí | No |
| --- | --- | --- | --- |
| **Cercana y tranquila** | Acompaña sin apurar ni vigilar. Habla de tú, en frases cortas y con calma. | «Prepáralo con calma.» (T0174) | «¡Vamos, tú puedes!» |
| **Clara y concreta** | Dice qué pasa y qué se puede hacer, con objetos y lugares reales. | «No sonó en el parlante. Revisa que esté encendido y conectado.» (T0803) | «Error en la salida de audio.» |
| **Respetuosa de la decisión** | Ofrece, no ordena. Todas las respuestas valen lo mismo y ninguna se premia. | «Ninguna respuesta es mejor que otra.» (T0019) | «No pierdas tu racha.» |
| **Honesta** | Dice qué guarda, qué no ve y cuándo algo falla, sin prometer resultados. | «El código reemplaza tu nombre, pero no vuelve anónimos los datos…» (T0069) | «Tus datos están 100 % seguros.» |

En las cuatro dimensiones de Moran (2016), Relevo se ubica entre casual y formal, serio, respetuoso y objetivo. El humor y el entusiasmo quedan para pocos momentos, como el cierre de la prueba.

### 5.2 Quién habla

- **Relevo, en tercera persona,** para lo que hace la app: «Relevo cuenta minutos en las apps que elijas.»
- **«Nosotros» solo para el equipo del proyecto:** lo que se guarda, quién lo ve, los mensajes del investigador y las preguntas de la prueba. «Guardamos lo que haces en Relevo con un código.»
- **Tú para la persona,** siempre como protagonista de las decisiones: «Tú decides.»
- **La forma impersonal** cuando la persona no necesita saber quién actúa: «Se borran tus relevos…»
- **Nunca «yo»:** la app no tiene personaje.

### 5.3 El tono según el momento

El estado de ánimo de cada columna es una suposición de diseño, no un resultado de la prueba.

| Momento | Pantallas | Cómo puede llegar la persona | Tono | Ejemplo actual | Cuidar |
| --- | --- | --- | --- | --- | --- |
| Primera vez | 01–06 | Curiosa, sin saber qué es Relevo. | Acogedor y explicativo, una idea por pantalla. | «Anota algo que quieres hacer.» (T0001) | No prometer resultados. |
| Preparar | 08, 09 | Con una intención y poco tiempo. | Práctico, de guía. | «Toca un primer paso o escribe el tuyo: algo que tome segundos.» (T0207) | Una instrucción por línea. |
| Contando | 07, 11 | Usando el teléfono como siempre. | Sereno y mínimo. | «Tu relevo está contando.» (T0127) | No hablar de tiempo perdido. |
| Suena | 12 y notificación | Concentrada en otra cosa. | Neutro y breve, sin urgencia ni culpa. | «Es momento de volver a elegir» (T0416) | Nada de imperativos como «Deja el teléfono». |
| Preguntas | 13, 27, 28 | Interrumpida, con poca paciencia. | Neutral, sin juicio. | «No hay respuestas buenas ni malas…» (T0433) | Opciones equivalentes y siempre saltables. |
| Errores | Tag, permisos, archivos | Frustrada. | Sereno y específico, sin humor. | «No se pudo guardar el archivo. Prueba otra vez.» (T0656) | Decir siempre qué hacer. |
| Datos y privacidad | 03, 24, 25 | Atenta o desconfiada. | Sobrio y exacto. | «Qué no vemos» (T0064) | No minimizar riesgos. |
| Cierre | 28 | Al final de 21 días. | Agradecido; aquí cabe una exclamación. | «¡Terminaste los 21 días!» (T0719) | Agradecer la participación, no felicitar por resultados. |

## 6. Reglas por tipo de texto

| Tipo | Regla | Ejemplo |
| --- | --- | --- |
| Título de pantalla | Frase corta, mayúscula inicial y sin punto final. Pregunta cuando la pantalla pide algo. | «¿Qué quieres hacer?» |
| Título en dos tonos | Se lee como una frase en dos partes (D-073); un solo criterio de puntuación para todos. | «Paso a paso / hacia lo que te gustaría hacer más seguido» |
| Botón | Verbo en infinitivo, más un objeto si hace falta; de 1 a 3 palabras; dice el resultado. | «Activar el relevo» |
| Acción de texto | Igual que un botón. «Ahora no» para posponer una sugerencia y «Saltar» para dejar una pregunta. | «Ahora no» |
| Volver | El nombre del destino, o «Cancelar» si se descartan cambios; «Cerrar» en lo que no guarda. | «Perfil» |
| Campo | Rótulo como sustantivo; la ayuda es un ejemplo que empieza con «Ej.:» y nunca reemplaza el rótulo. | «Actividad» / «Ej.: practicar guitarra» |
| Validación | Una instrucción con verbo, junto al campo, sin «error» ni «inválido». | «Escribe dónde empiezas.» |
| Error | Qué pasó y qué hacer, separados por punto; sin culpa, humor ni exclamaciones. | «No sonó en el teléfono. Revisa el volumen.» |
| Estado vacío | Qué aparecerá aquí y cómo empezar. | «Aquí verás los relevos que termines.» |
| Confirmación que borra | Pregunta con la acción y el objeto; cuerpo con lo que se pierde y lo que se mantiene; botones con la acción y una opción segura. | «¿Borrar «Leer»?» / «Borrar» / «Cancelar» |
| Interruptor | El título nombra la función; el subtítulo dice qué pasa cuando está encendido. | «Aviso semanal» / «Si pasas una semana sin abrir Relevo, te avisa una vez.» |
| Permiso | Para qué sirve en palabras de la persona, qué no hace Relevo y cómo se llama en Android. | «Para contar el tiempo en las apps que elijas.» |
| Consentimiento | Secciones con títulos claros, listas en vez de párrafos largos y los riesgos dichos. La versión aceptada sigue a la vista. | «Qué no vemos» |
| Pregunta | Una idea, sobre el momento concreto; opciones equivalentes; siempre se puede saltar. | «¿Recordaste cómo empezar?» |
| Agradecimiento | Agradece sin evaluar; el mismo peso para cualquier respuesta. | «Gracias por contarlo.» |
| Notificación | Título con lo importante, hasta 30 caracteres y sin el nombre de la app, salvo en la versión de la pantalla bloqueada. Texto de hasta 40 caracteres, con lo útil al principio. | Título «Leer», texto «Empieza por abrir el libro» |
| Lector de pantalla | Describe la función, no la forma, y el estado cuando importa. | «Editar el perfil», «Paso actual» |
| Números y fechas | Cifras para lo que se cuenta o se mide; días y meses en minúscula. | «3 segundos», «jueves 25 de septiembre» |
| Comillas y puntos suspensivos | Comillas latinas para nombres de botones y palabras de la persona; el carácter «…». | «Toca «Buscar el Tag»», «Buscando…» |
| Nombres propios | Relevo (la app) y Tag con mayúscula; relevo (lo que se prepara) con minúscula. | «Relevo cuenta…», «tu relevo» |

## 7. Vocabulario de Relevo

| Término | Qué nombra | Úsalo así | Evita | Estado |
| --- | --- | --- | --- | --- |
| Relevo | La app. | «Relevo te avisa a tiempo» | Repetir «la app Relevo». | Vigente |
| relevo | Lo que se prepara y se activa: actividad, cómo empiezas, dónde, apps, tiempo y con qué suena. | «Preparar un relevo», «Tu relevo está contando» | recordatorio, alarma, tarea | Vigente; conviene definirlo la primera vez que aparece |
| actividad | Lo que la persona quiere hacer. | «¿Qué quieres hacer?» | meta, objetivo, hábito, tarea | Vigente |
| Para empezar / ¿Cómo empiezas? | Lo primero que haría la persona. | Rótulo «Para empezar»; pregunta «¿Cómo empiezas?» | «primer paso» como rótulo | Vigente según D-084; la app se desvió (R1) |
| Dónde empiezas | El lugar donde está lo que se usa para empezar. | «Dónde empiezas» | Una habitación entera, como «en tu pieza» | Vigente |
| lo que suena | El parlante, el reloj, el Tag o el teléfono. | «¿Dónde dejas lo que suena?» | dispositivo, alarma | Propuesta (R4) |
| Tag | El objeto Bluetooth que pita. | «tu Tag» | llavero, rastreador | Vigente |
| sonar / el sonido | Lo que pasa cuando se cumple el tiempo. | «Suena en el parlante», «¿Te molestó el sonido?» | alarma; «aviso» para esto | Propuesta (R2) |
| aviso semanal | La notificación opcional tras una semana sin abrir Relevo. | «Aviso semanal» | recordatorio | Vigente |
| Notificaciones | El permiso de Android. | «Notificaciones: para avisarte aunque estés en otra app» | avisos | Propuesta (R2) |
| contar | Sumar minutos en las apps elegidas. | «Tu relevo está contando», «En pausa» | medir, vigilar; «contar» por narrar | Propuesta (R3) |
| silenciar | Detener el sonido. | «Silenciar y continuar» | apagar, para el sonido | Vigente |
| desactivar | Detener un relevo activo; después se dice qué se decidió. | «Desactivar» | cancelar, terminar | Vigente |
| eliminar | Quitar un relevo activado por error; no queda en «Tus relevos». | «Lo activé por error: eliminarlo» | borrar, para esto | Vigente |
| borrar | Quitar para siempre datos, actividades o pasos. | «Borrar mis datos» | eliminar, para esto | Vigente |
| encender / apagar | Ajustes y el Tag. | «Apagar el aviso semanal» | desactivar, para ajustes | Vigente |
| ruta, paso, interés | Sugerencias de actividades por interés, ordenadas en pasos editables. | «Pasar a este paso» | nivel, progreso, logro, meta | Por decidir: un solo nombre para la pestaña, el título y Perfil (R4) |
| aura | El color en la pantalla mientras cuenta un relevo. | «Tu aura» | — | Vigente |
| apps que cuentan | Las apps que la persona eligió. | «Apps que cuentan» | apps bloqueadas, apps prohibidas | Vigente |
| Tiempo de uso | El permiso que Android llama «Acceso a datos de uso». | «Tiempo de uso (en Android, Acceso a datos de uso)» | — | Propuesta (R6) |
| prueba | El estudio de 21 días. | «la prueba de 21 días» | testeo, experimento | Propuesta (R14) |

## 8. Cómo usar este estudio cuando se revisen los textos

**Qué no tocar mientras dura la prueba.** Estos textos forman parte del protocolo o del consentimiento aceptado. Cambiarlos durante la prueba haría que unas semanas y otras no fueran comparables:

- la frase y la notificación de la señal (T0416, T0779–T0782);
- las preguntas después de la señal y «¿Qué decidiste?» (T0434–T0452);
- las instrucciones de cada semana (T0816–T0823);
- los cierres de semana y de la prueba (T0702–T0749);
- el consentimiento (T0043–T0073), cuyo texto aceptado se muestra en «Lo que aceptaste».

**Orden sugerido para después.**

1. **Lo que desorienta:** R5 (etiquetas que no coinciden), R6 (nombres de Android), R1 y R2 (un concepto, varios nombres).
2. **Lo que resta claridad:** R3 («contar»), R4 (objeto y ruta), R7 (quién habla), R11 (notificaciones) y R12 (textos largos).
3. **El estilo:** R8 a R10, R13 y R14.

**Cómo hacerlo.**

1. Cambiar el texto en el código Kotlin; los textos no están en un archivo de recursos.
2. Ejecutar `node extraer-textos.js` y comparar el inventario nuevo con el anterior.
3. Compilar, probar las pantallas cambiadas en el emulador y revisar que nada se corte en un teléfono pequeño ni con letra grande.
4. Registrar la decisión y el cambio en el registro de decisiones y en las notas de la versión.

**Decisiones que quedan para el autor.**

- El nombre de la forma de empezar: volver a «Para empezar» (D-084) o adoptar otro (R1).
- El nombre de la señal y el uso de «aviso» (R2).
- El nombre de la ruta en la pestaña, el título y Perfil (R4).
- Si «nosotros» queda solo para el equipo del proyecto (R7).
- El punto final en los títulos en dos tonos (R8).
- La frase de marca: la guía de comunicación fija «Hazle lugar a lo que quieres hacer»; la versión 2.33 escribe la actividad como «Vuelve a ___.» al preparar y en Inicio, y 3.3 ya no muestra ese renglón. No se resuelve aquí.

## Referencias

Android Developers. (2026, 2 de marzo). *Notifications*. https://developer.android.com/design/ui/mobile/guides/home-screen/notifications

Android Open Source Project. (s. f.). *strings.xml (values-es-rUS)* [Código fuente de la app Configuración de Android]. Recuperado el 24 de octubre de 2026, de https://android.googlesource.com/platform/packages/apps/Settings/+/refs/heads/main/res/values-es-rUS/strings.xml

Apple. (2024, 8 de febrero). *Q&A with the Apple UX writing team*. Apple Developer. https://developer.apple.com/news/?id=5mcfho5g

Apple. (2025, 16 de diciembre). *Writing*. Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/writing

Apple. (s. f.). *Configurar Tiempo en pantalla para ti en el iPhone*. Manual de uso del iPhone. Recuperado el 24 de octubre de 2026, de https://support.apple.com/es-lamr/guide/iphone/iphbfa595995/ios

Google. (s. f.-a). *Administra el tiempo que usas tu teléfono Android con Bienestar digital*. Ayuda de Android. Recuperado el 24 de octubre de 2026, de https://support.google.com/android/answer/9346420?hl=es-419

Google. (s. f.-b). *Material's communication principles: Intro to UX writing* [Codelab]. Google Codelabs. Recuperado el 24 de octubre de 2026, de https://codelabs.developers.google.com/codelabs/material-communication-guidance

GOV.UK. (2018, 16 de abril). *Writing for user interfaces*. Service Manual. https://www.gov.uk/service-manual/design/writing-for-user-interfaces

Grüning, D. J., Riedel, F. y Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), Artículo e2213114120. https://doi.org/10.1073/pnas.2213114120

International Organization for Standardization. (2023). *Plain language — Part 1: Governing principles and guidelines* (ISO 24495-1:2023). https://www.iso.org/standard/78907.html

Mailchimp. (s. f.). *Voice and tone*. Mailchimp Content Style Guide. Recuperado el 24 de octubre de 2026, de https://styleguide.mailchimp.com/voice-and-tone/

Microsoft. (2021). *Spanish (Neutral) style guide*. https://download.microsoft.com/download/4/3/1/431d9836-40dc-4f2b-aafc-def5c7b5d0f3/spa-neu-StyleGuide.pdf

Miller, C. H., Lane, L. T., Deatrick, L. M., Young, A. M. y Potts, K. A. (2007). Psychological reactance and promotional health messages: The effects of controlling language, lexical concreteness, and the restoration of freedom. *Human Communication Research, 33*(2), 219–240. https://doi.org/10.1111/j.1468-2958.2007.00297.x

Moran, K. (2016, 17 de julio). *The four dimensions of tone of voice*. Nielsen Norman Group. https://www.nngroup.com/articles/tone-of-voice-dimensions/

Neusesser, T. y Sunwall, E. (2023, 14 de mayo). *Error-message guidelines*. Nielsen Norman Group. https://www.nngroup.com/articles/error-message-guidelines/

Pielot, M. y Rello, L. (2017). Productive, anxious, lonely: 24 hours without push notifications. En *Proceedings of the 19th International Conference on Human-Computer Interaction with Mobile Devices and Services* (pp. 1–11). Association for Computing Machinery. https://doi.org/10.1145/3098279.3098526

Real Academia Española y Asociación de Academias de la Lengua Española. (2024). *Guía panhispánica de lenguaje claro y accesible*. Espasa.

Real Academia Española y Asociación de Academias de la Lengua Española. (s. f.). Punto. En *Diccionario panhispánico de dudas* (2.ª ed.). Recuperado el 24 de octubre de 2026, de https://www.rae.es/dpd/punto

Ryan, R. M. y Deci, E. L. (2000). Self-determination theory and the facilitation of intrinsic motivation, social development, and well-being. *American Psychologist, 55*(1), 68–78. https://doi.org/10.1037/0003-066X.55.1.68

Silverman, J. y Barasch, A. (2023). On or off track: How (broken) streaks affect consumer decisions. *Journal of Consumer Research, 49*(6), 1095–1117. https://doi.org/10.1093/jcr/ucac029

Smit, E. S., Zeidler, C., Resnicow, K. y de Vries, H. (2019). Identifying the most autonomy-supportive message frame in digital health communication: A 2x2 between-subjects experiment. *Journal of Medical Internet Research, 21*(10), Artículo e14074. https://doi.org/10.2196/14074

Yancey, K. P. y Settles, B. (2020). A sleeping, recovering bandit algorithm for optimizing recurring notifications. En *Proceedings of the 26th ACM SIGKDD International Conference on Knowledge Discovery & Data Mining* (pp. 3008–3016). Association for Computing Machinery. https://doi.org/10.1145/3394486.3403351

## Registro de cambios (disclaimer)

### 2026-10-24 — Creación

- **Qué cambió:** se creó el estudio de escritura de interfaces de Relevo 3.3: fuentes, comparación con apps conocidas, diagnóstico de los textos con sus identificadores, voz, tono, reglas por tipo de texto y vocabulario.
- **Cómo estaba antes:** la [guía de comunicación](../../../00_gobernanza/guia-comunicacion-relevo.md) explicaba el proyecto hacia afuera y D-083 y D-084 fijaban algunas reglas de texto, pero no existía una guía de voz y tono para la app ni un diagnóstico de sus textos.
- **Por qué:** el autor pidió estudiar cómo comunicarse en la app, aprender de apps populares y documentarlo antes de pedir que se actualicen los textos.
