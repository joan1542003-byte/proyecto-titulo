# Inventario de textos de la app (rama android-2.33)

> Se genera con `node extraer-textos.js` desde el código de la app. Para cambiar un texto se cambia el código y se vuelve a generar. Los datos variables van entre corchetes, como [nombre] o [duración].

**Total:** 1247 textos, 5709 palabras, en 34 pantallas o grupos.


## 01 Bienvenida

3 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0001 | botón | Empezar | `FirstRunScreens.kt:75` |
| T0002 | texto | lo que querías hacer | `FirstRunScreens.kt:80` |
| T0003 | texto | Anota algo que quieres hacer. Relevo te lo recuerda mientras todavía puedes hacerlo. | `FirstRunScreens.kt:82` |

## 02 Cómo funciona (guía de la primera vez)

30 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0004 | texto | Entendido | `HowItWorksScreen.kt:90` |
| T0005 | guía | Esto es Relevo | `HowItWorksScreen.kt:100` |
| T0006 | guía | Mira este video corto. Después te contamos cómo funciona y hacemos juntos tu primer relevo. | `HowItWorksScreen.kt:100` |
| T0007 | guía | ¿Te ha pasado? | `HowItWorksScreen.kt:103` |
| T0008 | guía | Relevo te recuerda lo que querías hacer mientras todavía puedes hacerlo, en el lugar donde lo empiezas. | `HowItWorksScreen.kt:103` |
| T0009 | texto | Abres una app para descansar. | `HowItWorksScreen.kt:107` |
| T0010 | texto | Se pasa el rato y lo que querías hacer queda esperando. | `HowItWorksScreen.kt:109` |
| T0011 | guía | Cómo funciona | `HowItWorksScreen.kt:112` |
| T0012 | guía | Cuando suene, nos cuentas qué hiciste con un toque. Ninguna respuesta es mejor que otra. | `HowItWorksScreen.kt:112` |
| T0013 | texto | La app | `HowItWorksScreen.kt:114` |
| T0014 | texto | Anotas qué quieres hacer y cómo empiezas. | `HowItWorksScreen.kt:114` |
| T0015 | texto | Lo que suena | `HowItWorksScreen.kt:116` |
| T0016 | texto | Un parlante, un reloj o un Tag que dejas donde empiezas. Suena cuando llevas en tus apps el tiempo que elegiste. | `HowItWorksScreen.kt:116` |
| T0017 | texto | Tú | `HowItWorksScreen.kt:118` |
| T0018 | texto | Decides si empiezas o sigues con lo que estabas haciendo. | `HowItWorksScreen.kt:118` |
| T0019 | guía | Una última pregunta | `HowItWorksScreen.kt:121` |
| T0020 | guía | Si pasas una semana sin abrir Relevo, ¿quieres que te avise una vez? Lo puedes cambiar cuando quieras en Perfil. | `HowItWorksScreen.kt:121` |
| T0021 | etiqueta | Relevo | `HowItWorksScreen.kt:123` |
| T0022 | etiqueta | ¿Quieres preparar un relevo esta semana? | `HowItWorksScreen.kt:125` |
| T0023 | texto | Saltar | `HowItWorksScreen.kt:142` |
| T0024 | botón | Seguir | `HowItWorksScreen.kt:145` |
| T0025 | botón | Sí, avísame | `HowItWorksScreen.kt:148` |
| T0026 | botón | No, gracias | `HowItWorksScreen.kt:149` |
| T0027 | lector de pantalla | Video de 30 segundos que explica Relevo. Tócalo para [dato]. | `HowItWorksScreen.kt:284` |
| T0028 | texto | Activar el sonido | `HowItWorksScreen.kt:312` |
| T0029 | texto | Quitar el sonido | `HowItWorksScreen.kt:312` |
| T0030 | texto | Ver de nuevo | `HowItWorksScreen.kt:318` |
| T0031 | texto | Pausar | `HowItWorksScreen.kt:318` |
| T0032 | texto | Reproducir | `HowItWorksScreen.kt:318` |
| T0033 | botón | Entendido | `RelevoApp.kt:281` |

## 03 Antes de empezar (consentimiento)

30 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0034 | título | Antes de empezar | `FirstRunScreens.kt:104` |
| T0035 | texto | Acepto participar durante 21 días. | `FirstRunScreens.kt:113` |
| T0036 | botón | Aceptar y empezar | `FirstRunScreens.kt:115` |
| T0037 | validación | Espera a que terminemos de borrar tus datos. | `FirstRunScreens.kt:116` |
| T0038 | validación | Marca «Acepto participar durante 21 días» para seguir. | `FirstRunScreens.kt:117` |
| T0039 | texto | Ocultar | `FirstRunScreens.kt:121` |
| T0040 | texto | No quiero participar | `FirstRunScreens.kt:121` |
| T0041 | texto | Está bien. Relevo solo se puede usar dentro de esta prueba, así que puedes cerrar la app y desinstalarla. No se guardó nada tuyo. | `FirstRunScreens.kt:124` |
| T0042 | texto | Relevo es parte de un proyecto de título de Diseño. Por 21 días lo usas en tu día a día: cada semana te decimos dónde dejar lo que suena y, de vez en cuando, te hacemos preguntas cortas. Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte. Puedes salir y borrar tus datos cuando quieras. | `FirstRunScreens.kt:131` |
| T0043 | texto | Ocultar | `FirstRunScreens.kt:135` |
| T0044 | texto | Leer más | `FirstRunScreens.kt:135` |
| T0045 | aviso | Todavía estamos borrando tus datos. Mientras tanto, Relevo no guarda nada. | `FirstRunScreens.kt:141` |
| T0046 | acción | Abrir Privacidad y datos | `FirstRunScreens.kt:142` |
| T0047 | texto | Cómo es | `FirstRunScreens.kt:152` |
| T0048 | texto | Empieza con un encuentro de unos 45 minutos para dejar todo listo. Cada semana la app te dice dónde suena: junto a donde empiezas, en otro lugar de tu casa o en el teléfono. Tú eliges si usas un parlante, un reloj o un Tag. Cuando se cumple el tiempo que elegiste, suena unos 30 segundos y se apaga. Después de cada aviso y al final de cada semana hay preguntas de un toque; puedes saltarlas. Al final te invitamos a conversar unos 15 minutos. El parlante es provisorio; no es el objeto final. | `FirstRunScreens.kt:152` |
| T0049 | texto | Tú decides | `FirstRunScreens.kt:153` |
| T0050 | texto | Participar es voluntario. Puedes saltar preguntas, silenciar el sonido, quitar los permisos o salir cuando quieras, sin dar explicaciones. Nadie va a juzgar lo que elijas hacer. El sonido puede molestar a otras personas; puedes detenerlo y contárnoslo. | `FirstRunScreens.kt:153` |
| T0051 | texto | Qué guardamos | `FirstRunScreens.kt:154` |
| T0052 | texto | Un código al azar; lo que preparas (actividad, cómo empiezas, dónde, apps y tiempo); cuándo lo activas, a mano o solo, cuándo suena y qué respondes; cuánto usaste las apps elegidas 10 minutos antes y después del aviso; cuánto usas cada día las apps que elegiste en Relevo y cuánto tiempo usas el teléfono en total, desde 7 días antes de aceptar; el modelo del teléfono y los permisos que diste; y cómo usas Relevo: cuándo lo abres y por cuánto tiempo, qué pantallas ves, cuánto del video ves, tus intereses, tus actividades y los ajustes que cambias. Tu nombre se guarda aparte, solo con tu código, para saber quién participa; no va junto a lo que haces en Relevo. | `FirstRunScreens.kt:154` |
| T0053 | texto | Dónde se guarda | `FirstRunScreens.kt:155` |
| T0054 | texto | En el teléfono y en la base de datos del proyecto (Supabase). Si no hay internet, se envía después. También queda una copia sin tu nombre en la carpeta Documentos/Relevo del teléfono; se borra si borras tus datos. | `FirstRunScreens.kt:155` |
| T0055 | texto | Esta instalación no tiene configurada la base remota: todo queda en este teléfono. | `FirstRunScreens.kt:156` |
| T0056 | texto | Qué no vemos | `FirstRunScreens.kt:157` |
| T0057 | texto | El permiso de Tiempo de uso podría mostrar el uso de otras apps. Relevo cuenta las que eliges mientras el relevo está activo y, cada día, cuánto las usas y el tiempo total del teléfono; de las demás apps no guarda el nombre. Si enciendes la activación automática, además mira qué app tienes abierta —solo su nombre— para saber cuándo empezar; puedes apagarla cuando quieras. No lee mensajes, fotos, búsquedas ni lo que hay en tu pantalla. | `FirstRunScreens.kt:157` |
| T0058 | texto | Mensajes | `FirstRunScreens.kt:158` |
| T0059 | texto | El investigador puede enviarte mensajes sobre el testeo; llegan como notificación de Relevo. Guardamos cuándo llegó y cuándo abriste cada uno. | `FirstRunScreens.kt:158` |
| T0060 | texto | Tu código | `FirstRunScreens.kt:159` |
| T0061 | texto | El código reemplaza tu nombre, pero no vuelve anónimos los datos: juntando actividades, lugares y horarios, alguien podría reconocerte. | `FirstRunScreens.kt:159` |
| T0062 | texto | Hasta cuándo | `FirstRunScreens.kt:160` |
| T0063 | texto | Puedes borrar tus datos desde Perfil, en Tus datos, o escribiendo a [correo del investigador] con tu código. Si no lo haces antes, los borramos a más tardar el 30 de diciembre de 2026. | `FirstRunScreens.kt:160` |

## 04 Para saber cuándo avisarte (permisos de la primera vez)

16 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0064 | título | Para saber cuándo avisarte | `FirstRunScreens.kt:205` |
| T0065 | botón | Seguir | `FirstRunScreens.kt:210` |
| T0066 | botón | Dar el permiso | `FirstRunScreens.kt:211` |
| T0067 | texto | Relevo necesita saber cuánto tiempo pasas en las apps que elijas. No ve lo que haces en ellas. | `FirstRunScreens.kt:214` |
| T0068 | texto | Tiempo de uso | `FirstRunScreens.kt:218` |
| T0069 | subtítulo | Necesario. | `FirstRunScreens.kt:218` |
| T0070 | etiqueta | Listo | `FirstRunScreens.kt:220` |
| T0071 | etiqueta | Falta | `FirstRunScreens.kt:220` |
| T0072 | etiqueta | Notificaciones | `FirstRunScreens.kt:223` |
| T0073 | subtítulo | Para avisarte aunque estés en otra app. | `FirstRunScreens.kt:223` |
| T0074 | etiqueta | Listo | `FirstRunScreens.kt:225` |
| T0075 | etiqueta | Activar | `FirstRunScreens.kt:225` |
| T0076 | etiqueta | Batería | `FirstRunScreens.kt:228` |
| T0077 | subtítulo | Para que Relevo siga funcionando aunque pasen días. | `FirstRunScreens.kt:228` |
| T0078 | etiqueta | Listo | `FirstRunScreens.kt:230` |
| T0079 | etiqueta | Activar | `FirstRunScreens.kt:230` |

## 05 Tu perfil (primera vez)

18 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0080 | texto | ¿Cómo te llamas? | `ProfileScreens.kt:245` |
| T0081 | validación | Elige tu emoji | `ProfileScreens.kt:245` |
| T0082 | texto | ¿Qué te gustaría hacer más seguido? | `ProfileScreens.kt:245` |
| T0083 | texto | Saltar | `ProfileScreens.kt:250` |
| T0084 | botón | Seguir | `ProfileScreens.kt:253` |
| T0085 | validación | Escribe tu nombre. | `ProfileScreens.kt:253` |
| T0086 | botón | Seguir | `ProfileScreens.kt:254` |
| T0087 | validación | Elige un emoji o toca «Saltar». | `ProfileScreens.kt:254` |
| T0088 | botón | Armar mi ruta | `ProfileScreens.kt:255` |
| T0089 | validación | Elige al menos un interés o toca «Saltar». | `ProfileScreens.kt:256` |
| T0090 | validación | Escribe cuál es tu otro interés. | `ProfileScreens.kt:257` |
| T0091 | campo | Tu nombre | `ProfileScreens.kt:277` |
| T0092 | ayuda del campo | Tu nombre o como te dicen | `ProfileScreens.kt:277` |
| T0093 | texto | Lo guardamos junto a tu código, aparte de lo que haces en Relevo. | `ProfileScreens.kt:280` |
| T0094 | texto | Elige una o varias. | `ProfileScreens.kt:288` |
| T0095 | texto | Otra | `ProfileScreens.kt:322` |
| T0096 | campo | ¿Cuál? | `ProfileScreens.kt:334` |
| T0097 | ayuda del campo | Ej.: tejer | `ProfileScreens.kt:334` |

## 06 Tu primer relevo

11 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0098 | botón | Empezar | `HowItWorksScreen.kt:200` |
| T0099 | botón | Lo hago después | `HowItWorksScreen.kt:201` |
| T0100 | texto | Hagamos tu primer relevo | `HowItWorksScreen.kt:205` |
| T0101 | texto | Empecemos con «[dato]», de tu ruta «[ruta]». Te guiamos paso a paso y puedes cambiar lo que quieras. | `HowItWorksScreen.kt:208` |
| T0102 | texto | Te guiamos paso a paso. Toma un par de minutos. | `HowItWorksScreen.kt:209` |
| T0103 | texto | Qué quieres hacer | `HowItWorksScreen.kt:214` |
| T0104 | texto | Cómo empiezas | `HowItWorksScreen.kt:214` |
| T0105 | texto | Dónde empiezas | `HowItWorksScreen.kt:214` |
| T0106 | texto | Cuándo suena | `HowItWorksScreen.kt:214` |
| T0107 | texto | Dónde suena | `HowItWorksScreen.kt:214` |
| T0108 | texto | Activarlo | `HowItWorksScreen.kt:214` |

## 07 Inicio

71 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0109 | texto | Muy mal | `Feedback.kt:50` |
| T0110 | texto | Mal | `Feedback.kt:51` |
| T0111 | texto | Normal | `Feedback.kt:52` |
| T0112 | texto | Bien | `Feedback.kt:53` |
| T0113 | texto | Muy bien | `Feedback.kt:54` |
| T0114 | texto | ¿Qué tal te va con Relevo? | `Feedback.kt:91` |
| T0115 | texto | Toca una cara. Nos ayuda a mejorarlo. | `Feedback.kt:92` |
| T0116 | acción | Contar más | `Feedback.kt:96` |
| T0117 | acción | Ahora no | `Feedback.kt:97` |
| T0118 | texto | Para que Relevo siga contando aunque pasen días, quítale la restricción de batería. | `HomeScreen.kt:119` |
| T0119 | texto | Hola de nuevo. | `HomeScreen.kt:162` |
| T0120 | texto | Hola de nuevo, [nombre]. | `HomeScreen.kt:162` |
| T0121 | texto | Hola. | `HomeScreen.kt:163` |
| T0122 | texto | Hola, [nombre]. | `HomeScreen.kt:164` |
| T0123 | botón | Ver mi relevo | `HomeScreen.kt:176` |
| T0124 | botón | Preparar de nuevo | `HomeScreen.kt:177` |
| T0125 | botón | Preparar un relevo | `HomeScreen.kt:178` |
| T0126 | guía | Empieza aquí: toca «Preparar un relevo». Te acompañamos paso a paso. | `HomeScreen.kt:184` |
| T0127 | texto | Cuando abras [apps elegidas], Relevo empieza a contar para «[actividad]». | `HomeScreen.kt:194` |
| T0128 | título | Se activa solo | `HomeScreen.kt:195` |
| T0129 | acción | Apagar | `HomeScreen.kt:196` |
| T0130 | aviso | Falta el permiso de Tiempo de uso. | `HomeScreen.kt:208` |
| T0131 | título | Relevo no puede contar el tiempo | `HomeScreen.kt:208` |
| T0132 | acción | Dar el permiso | `HomeScreen.kt:209` |
| T0133 | título | Batería | `HomeScreen.kt:214` |
| T0134 | acción | Quitar la restricción | `HomeScreen.kt:215` |
| T0135 | texto | Preparar un relevo | `HomeScreen.kt:221` |
| T0136 | texto | ¿Tienes algo en mente? | `HomeScreen.kt:222` |
| T0137 | texto | Anótalo y Relevo te avisa cuando lleves un rato en el teléfono. | `HomeScreen.kt:224` |
| T0138 | rótulo | Ideas | `HomeScreen.kt:230` |
| T0139 | rótulo | Tus actividades | `HomeScreen.kt:239` |
| T0140 | texto | Guarda lo que haces seguido y prepáralo en un toque. | `HomeScreen.kt:243` |
| T0141 | botón | Crear una actividad | `HomeScreen.kt:244` |
| T0142 | título | La última vez | `HomeScreen.kt:258` |
| T0143 | lector de pantalla | Perfil | `HomeScreen.kt:282` |
| T0144 | texto | ¿Quieres cambiar la actividad de tu ruta? | `HomeScreen.kt:309` |
| T0145 | botón | Cambiar la actividad | `HomeScreen.kt:311` |
| T0146 | acción | Ahora no | `HomeScreen.kt:312` |
| T0147 | texto | Ver mi relevo | `HomeScreen.kt:328` |
| T0148 | etiqueta | Contando | `HomeScreen.kt:330` |
| T0149 | etiqueta | En pausa | `HomeScreen.kt:330` |
| T0150 | texto | Sonará [lugar]. | `HomeScreen.kt:334` |
| T0151 | texto | de [duración] | `HomeScreen.kt:340` |
| T0152 | texto | La última vez | `HomeScreen.kt:403` |
| T0153 | texto | ¿Sigue siendo lo que quieres? | `HomeScreen.kt:407` |
| T0154 | botón | Elegir otra | `HomeScreen.kt:410` |
| T0155 | acción | Ahora no | `HomeScreen.kt:411` |
| T0156 | texto | Preparar un relevo con este paso | `HomeScreen.kt:423` |
| T0157 | texto | Tu ruta · [ruta] | `HomeScreen.kt:425` |
| T0158 | botón | Preparar | `HomeScreen.kt:436` |
| T0159 | tarjeta | Hoy | `StudyScreens.kt:54` |
| T0160 | tarjeta | Tu primer relevo | `StudyScreens.kt:54` |
| T0161 | tarjeta | Prepáralo con calma. Deja el parlante, el reloj o el Tag junto a lo que usas para empezar. | `StudyScreens.kt:54` |
| T0162 | tarjeta | Esta semana | `StudyScreens.kt:57` |
| T0163 | acción | Entendido | `StudyScreens.kt:58` |
| T0164 | tarjeta | Antes de esta semana | `StudyScreens.kt:63` |
| T0165 | tarjeta | ¿Cómo te fue hasta ahora? | `StudyScreens.kt:63` |
| T0166 | tarjeta | Tres preguntas de un toque sobre las semanas anteriores, con el objeto que ya usabas. | `StudyScreens.kt:63` |
| T0167 | acción | Responder | `StudyScreens.kt:64` |
| T0168 | tarjeta | Tu semana | `StudyScreens.kt:67` |
| T0169 | tarjeta | ¿Cómo te fue esta semana? | `StudyScreens.kt:67` |
| T0170 | tarjeta | Cuatro preguntas de un toque. | `StudyScreens.kt:67` |
| T0171 | tarjeta | Tres preguntas de un toque. | `StudyScreens.kt:67` |
| T0172 | acción | Responder | `StudyScreens.kt:68` |
| T0173 | tarjeta | Cierre | `StudyScreens.kt:73` |
| T0174 | tarjeta | Día 21 | `StudyScreens.kt:73` |
| T0175 | tarjeta | Terminaste la prueba. Gracias. | `StudyScreens.kt:73` |
| T0176 | tarjeta | ¡Llegaste al día 21! Gracias. | `StudyScreens.kt:73` |
| T0177 | texto | Siete preguntas cortas, unos 3 minutos. | `StudyScreens.kt:73` |
| T0178 | texto | Cinco preguntas cortas, unos 2 minutos. | `StudyScreens.kt:73` |
| T0179 | acción | Responder | `StudyScreens.kt:74` |

## 08 Preparar un relevo

143 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0180 | texto | pila al [dato] %, cámbiala pronto | `TagProtocol.kt:39` |
| T0181 | texto | pila al [dato] % | `TagProtocol.kt:39` |
| T0182 | texto | Muy cerca | `TagProtocol.kt:84` |
| T0183 | texto | Cerca | `TagProtocol.kt:85` |
| T0184 | texto | Lejos | `TagProtocol.kt:86` |
| T0185 | texto | ¿Qué quieres hacer? | `PrepareScreen.kt:111` |
| T0186 | texto | ¿Cómo empiezas? | `PrepareScreen.kt:112` |
| T0187 | texto | ¿Dónde empiezas? | `PrepareScreen.kt:113` |
| T0188 | texto | ¿Cuándo suena? | `PrepareScreen.kt:114` |
| T0189 | texto | ¿Dónde suena? | `PrepareScreen.kt:115` |
| T0190 | texto | Todo listo | `PrepareScreen.kt:116` |
| T0191 | texto | Te propusimos «[actividad]». Puedes dejarla o escribir otra cosa que quieras hacer. | `PrepareScreen.kt:121` |
| T0192 | validación | Escribe algo que quieras hacer o toca una idea. Mientras más concreto, mejor: «leer 10 páginas» en vez de «leer más». | `PrepareScreen.kt:122` |
| T0193 | texto | El primer paso es «[primer paso]». Mientras más pequeño, menos cuesta empezar. | `PrepareScreen.kt:123` |
| T0194 | texto | Toca un primer paso o escribe el tuyo: algo que tome segundos. | `PrepareScreen.kt:124` |
| T0195 | texto | Esta semana deja lo que suena en otro lugar de tu casa y anota dónde. | `PrepareScreen.kt:125` |
| T0196 | texto | Toca el que más se parezca. Si ninguno calza, escríbelo como lo dirías en voz alta. | `PrepareScreen.kt:126` |
| T0197 | validación | Elige las apps donde se te pasa el rato. Para ver ahora cómo funciona, toca «Probar con 15 segundos». | `PrepareScreen.kt:127` |
| T0198 | validación | Elige el que tienes y pruébalo antes de seguir. | `PrepareScreen.kt:128` |
| T0199 | validación | Elige con qué suena. El parlante, el reloj o el Tag se dejan donde empiezas; el teléfono suena donde esté. | `PrepareScreen.kt:129` |
| T0200 | texto | Revisa que todo esté bien. Toca cualquier dato para cambiarlo y después «Activar el relevo». | `PrepareScreen.kt:130` |
| T0201 | texto | ¿Dónde dejas lo que suena? | `PrepareScreen.kt:135` |
| T0202 | validación | Escribe qué quieres hacer o toca una idea. | `PrepareScreen.kt:170` |
| T0203 | validación | Escribe cómo empiezas: lo primero que harías. | `PrepareScreen.kt:171` |
| T0204 | validación | Escribe dónde dejas lo que suena. | `PrepareScreen.kt:173` |
| T0205 | validación | Escribe dónde empiezas. | `PrepareScreen.kt:173` |
| T0206 | validación | Falta el permiso de Tiempo de uso. Tócalo arriba para darlo. | `PrepareScreen.kt:175` |
| T0207 | validación | Elige al menos una app que cuente. | `PrepareScreen.kt:176` |
| T0208 | validación | Elige dónde quieres que suene. | `PrepareScreen.kt:180` |
| T0209 | validación | Busca y elige tu Tag, o elige otra forma de avisar. | `PrepareScreen.kt:181` |
| T0210 | validación | Falta el permiso de Tiempo de uso. | `PrepareScreen.kt:185` |
| T0211 | validación | Falta elegir dónde suena. | `PrepareScreen.kt:186` |
| T0212 | validación | Falta elegir el Tag. | `PrepareScreen.kt:187` |
| T0213 | validación | Falta qué quieres hacer. | `PrepareScreen.kt:188` |
| T0214 | validación | Falta cómo empiezas. | `PrepareScreen.kt:189` |
| T0215 | validación | Falta dónde empiezas. | `PrepareScreen.kt:190` |
| T0216 | validación | Faltan las apps que cuentan. | `PrepareScreen.kt:191` |
| T0217 | texto | Cerrar | `PrepareScreen.kt:258` |
| T0218 | texto | Volver | `PrepareScreen.kt:258` |
| T0219 | texto | Guardar y activar | `PrepareScreen.kt:267` |
| T0220 | texto | Activar el relevo | `PrepareScreen.kt:267` |
| T0221 | texto | Listo | `PrepareScreen.kt:275` |
| T0222 | texto | Seguir | `PrepareScreen.kt:275` |
| T0223 | texto | Toca una opción o escribe la tuya: lo primero que harías. | `PrepareScreen.kt:296` |
| T0224 | campo | Para empezar | `PrepareScreen.kt:300` |
| T0225 | ayuda del campo | O escríbelo aquí | `PrepareScreen.kt:300` |
| T0226 | texto | Estás editando tu relevo. Al guardarlo vuelve a contar, con el tiempo que llevabas si las apps son las mismas. | `PrepareScreen.kt:311` |
| T0227 | texto | Qué quieres hacer | `PrepareScreen.kt:316` |
| T0228 | texto | Para empezar | `PrepareScreen.kt:317` |
| T0229 | texto | Lo que suena está | `PrepareScreen.kt:318` |
| T0230 | texto | Dónde empiezas | `PrepareScreen.kt:318` |
| T0231 | texto | Apps que cuentan | `PrepareScreen.kt:319` |
| T0232 | texto | Suena después de | `PrepareScreen.kt:320` |
| T0233 | texto | Suena | `PrepareScreen.kt:321` |
| T0234 | texto | Sin elegir | `PrepareScreen.kt:321` |
| T0235 | texto | Guardar en tus actividades para la próxima vez | `PrepareScreen.kt:332` |
| T0236 | título | Batería | `PrepareScreen.kt:337` |
| T0237 | acción | Quitar la restricción | `PrepareScreen.kt:338` |
| T0238 | lector de pantalla | Cambiar la actividad | `PrepareScreen.kt:354` |
| T0239 | campo | Actividad | `PrepareScreen.kt:367` |
| T0240 | ayuda del campo | Ej.: leer | `PrepareScreen.kt:367` |
| T0241 | texto | Tu ruta | `PrepareScreen.kt:371` |
| T0242 | texto | Ideas | `PrepareScreen.kt:378` |
| T0243 | texto | Tus actividades | `PrepareScreen.kt:384` |
| T0244 | texto | Toca el lugar donde está lo que usas para empezar, o escríbelo. | `PrepareScreen.kt:424` |
| T0245 | texto | Dónde dejas lo que suena | `PrepareScreen.kt:441` |
| T0246 | texto | Dónde empiezas | `PrepareScreen.kt:442` |
| T0247 | ayuda del campo | O escríbelo aquí | `PrepareScreen.kt:445` |
| T0248 | texto | Suena cuando sumes este tiempo en las apps que elijas. | `PrepareScreen.kt:462` |
| T0249 | aviso | Relevo necesita el permiso de Tiempo de uso para contar. | `PrepareScreen.kt:465` |
| T0250 | título | Falta un permiso | `PrepareScreen.kt:465` |
| T0251 | acción | Dar el permiso | `PrepareScreen.kt:466` |
| T0252 | título | Apps que cuentan | `PrepareScreen.kt:470` |
| T0253 | texto | Elegir apps | `PrepareScreen.kt:474` |
| T0254 | texto | Cambiar apps | `PrepareScreen.kt:474` |
| T0255 | texto | en esas apps | `PrepareScreen.kt:477` |
| T0256 | acción | Probar con 15 segundos | `PrepareScreen.kt:485` |
| T0257 | texto | Suena en el Tag. Si prefieres otra cosa, elígela. | `PrepareScreen.kt:502` |
| T0258 | texto | Esta semana suena en el teléfono. | `PrepareScreen.kt:503` |
| T0259 | texto | Esta semana suena donde empiezas. Elige con qué: el parlante, el reloj o el Tag. | `PrepareScreen.kt:504` |
| T0260 | texto | Esta semana suena en otro lugar de tu casa. Elige con qué: el parlante, el reloj o el Tag. | `PrepareScreen.kt:505` |
| T0261 | texto | El Tag | `PrepareScreen.kt:511` |
| T0262 | texto | El parlante | `PrepareScreen.kt:513` |
| T0263 | texto | Conectado por Bluetooth | `PrepareScreen.kt:513` |
| T0264 | texto | Sin parlante conectado | `PrepareScreen.kt:513` |
| T0265 | texto | El reloj | `PrepareScreen.kt:515` |
| T0266 | texto | Suena como una llamada | `PrepareScreen.kt:515` |
| T0267 | texto | Sin reloj conectado para llamadas | `PrepareScreen.kt:515` |
| T0268 | texto | El teléfono | `PrepareScreen.kt:517` |
| T0269 | texto | Suena donde esté el teléfono | `PrepareScreen.kt:517` |
| T0270 | botón | Probar el sonido | `PrepareScreen.kt:527` |
| T0271 | texto | Así va a sonar. | `PrepareScreen.kt:531` |
| T0272 | texto | Si tu parlante se apaga solo, no sonará. | `PrepareScreen.kt:537` |
| T0273 | texto | Deja el reloj donde empiezas, con las llamadas por Bluetooth activadas. | `PrepareScreen.kt:541` |
| T0274 | texto | Un Tag que pita | `PrepareScreen.kt:549` |
| T0275 | validación | Falta el permiso de dispositivos cercanos. | `PrepareScreen.kt:556` |
| T0276 | texto | El Bluetooth del teléfono está apagado. | `PrepareScreen.kt:557` |
| T0277 | texto | Ese aparato no acepta la orden para pitar: no es un Tag compatible. | `PrepareScreen.kt:558` |
| T0278 | texto | No lo encontramos. Revisa que esté encendido y cerca, y que ninguna otra app, como iSearching, esté conectada a él: acepta una conexión a la vez. | `PrepareScreen.kt:559` |
| T0279 | texto | Buscar mi Tag | `PrepareScreen.kt:587` |
| T0280 | texto | Entendido | `PrepareScreen.kt:587` |
| T0281 | aviso | Relevo necesita el permiso de dispositivos cercanos para encontrar el Tag. Solo lo usa para eso. | `PrepareScreen.kt:608` |
| T0282 | título | Falta un permiso | `PrepareScreen.kt:608` |
| T0283 | acción | Abrir los ajustes de Relevo | `PrepareScreen.kt:609` |
| T0284 | aviso | Enciende el Bluetooth del teléfono para encontrar el Tag. | `PrepareScreen.kt:623` |
| T0285 | título | Bluetooth apagado | `PrepareScreen.kt:623` |
| T0286 | acción | Encender Bluetooth | `PrepareScreen.kt:624` |
| T0287 | texto | Buscando Tags cerca. Si el tuyo está apagado, mantén apretado su botón 3 segundos, hasta que pite dos veces. | `PrepareScreen.kt:633` |
| T0288 | texto | Enciende el Tag: mantén apretado su botón 3 segundos, hasta que pite dos veces. Después toca el tuyo en la lista. | `PrepareScreen.kt:634` |
| T0289 | acción | Cómo usar el Tag | `PrepareScreen.kt:638` |
| T0290 | texto | Buscando… | `PrepareScreen.kt:641` |
| T0291 | texto | Buscar de nuevo | `PrepareScreen.kt:641` |
| T0292 | texto | Buscar el Tag | `PrepareScreen.kt:641` |
| T0293 | texto | Para buscarlo, Android te pedirá permiso para encontrar dispositivos cercanos. Relevo solo recuerda el Tag que elijas, en este teléfono; no usa tu ubicación. | `PrepareScreen.kt:647` |
| T0294 | texto | Aparatos cerca | `PrepareScreen.kt:654` |
| T0295 | texto | Tags cerca | `PrepareScreen.kt:654` |
| T0296 | texto | Toca tu Tag. Si es compatible, va a pitar una vez. | `PrepareScreen.kt:655` |
| T0297 | texto | Toca el tuyo. Va a pitar una vez para confirmarlo. | `PrepareScreen.kt:655` |
| T0298 | texto | No apareció ningún aparato con Bluetooth cerca. Revisa que el Tag esté encendido y cerca del teléfono, y búscalo de nuevo. | `PrepareScreen.kt:664` |
| T0299 | texto | No apareció ningún Tag. Revisa que esté encendido y cerca del teléfono, y búscalo de nuevo. Si lo usa otra app, como iSearching, ciérrala: el Tag acepta una conexión a la vez. | `PrepareScreen.kt:665` |
| T0300 | acción | Ver todos los aparatos cercanos | `PrepareScreen.kt:668` |
| T0301 | aviso | Ese aparato no aceptó la orden para pitar: no es un Tag compatible. Búscalo de nuevo y elige otro. | `PrepareScreen.kt:673` |
| T0302 | texto | Probando de otra forma… | `PrepareScreen.kt:679` |
| T0303 | texto | Probando… | `PrepareScreen.kt:680` |
| T0304 | texto | Probar el Tag | `PrepareScreen.kt:681` |
| T0305 | texto | Pruébalo y cuéntanos si lo escuchas pitar: así Relevo sabe cómo hacerlo sonar. | `PrepareScreen.kt:689` |
| T0306 | texto | Así va a sonar: cuando se cumpla el tiempo, pitará seguido hasta 30 segundos. | `PrepareScreen.kt:702` |
| T0307 | texto | Para callarlo, toca su botón una vez. Si lo mantienes apretado, se apaga. | `PrepareScreen.kt:703` |
| T0308 | texto | Este Tag mantiene su alarma de alejamiento: si el teléfono se aleja mucho mientras espera, puede pitar solo. Para callarlo, tócalo una vez. | `PrepareScreen.kt:705` |
| T0309 | texto | Recibió la orden, pero no pitó. Apágalo y vuelve a encenderlo: mantén su botón apretado 3 segundos hasta que pite largo, y otra vez hasta que pite dos veces. Después pruébalo de nuevo. Si sigue sin pitar, elige otra salida. | `PrepareScreen.kt:709` |
| T0310 | título | El Tag no pitó | `PrepareScreen.kt:710` |
| T0311 | título | No sonó en el Tag | `PrepareScreen.kt:712` |
| T0312 | acción | Cómo usar el Tag | `PrepareScreen.kt:716` |
| T0313 | acción | Elegir otro Tag | `PrepareScreen.kt:718` |
| T0314 | texto | Déjalo encendido donde empiezas. Relevo se conecta a él al activar el relevo y lo mantiene así hasta que suene. | `PrepareScreen.kt:721` |
| T0315 | texto | ¿Lo escuchaste pitar? | `PrepareScreen.kt:733` |
| T0316 | texto | Lo probamos de otra forma. Debió pitar 3 segundos seguidos. | `PrepareScreen.kt:735` |
| T0317 | texto | Debió pitar 3 segundos seguidos. | `PrepareScreen.kt:735` |
| T0318 | botón | Sí, pitó | `PrepareScreen.kt:739` |
| T0319 | botón | No pitó | `PrepareScreen.kt:740` |
| T0320 | título | Elige las apps | `PrepareScreen.kt:777` |
| T0321 | botón | Listo | `PrepareScreen.kt:777` |
| T0322 | campo | Buscar | `PrepareScreen.kt:778` |

## 09 Cómo usar el Tag

29 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0323 | guía del Tag | Este es tu Tag | `TagGuide.kt:66` |
| T0324 | guía del Tag | Es redondo y su botón no se ve: es el centro de la cara de arriba. Al apretarlo firme se siente un clic. Relevo lo hace sonar por Bluetooth. | `TagGuide.kt:66` |
| T0325 | texto | El centro es el botón | `TagGuide.kt:66` |
| T0326 | guía del Tag | Enciéndelo | `TagGuide.kt:67` |
| T0327 | guía del Tag | Mantén apretado el botón 3 segundos, hasta que pite dos veces. Queda encendido: no hay que hacerlo cada vez. | `TagGuide.kt:67` |
| T0328 | guía del Tag | 3 segundos · pita dos veces | `TagGuide.kt:67` |
| T0329 | guía del Tag | Búscalo en Relevo | `TagGuide.kt:68` |
| T0330 | guía del Tag | Con el Tag cerca del teléfono, toca «Buscar el Tag» y elígelo en la lista. Va a pitar una vez para confirmarlo. | `TagGuide.kt:68` |
| T0331 | texto | Cerca del teléfono | `TagGuide.kt:68` |
| T0332 | guía del Tag | Déjalo en su lugar | `TagGuide.kt:69` |
| T0333 | guía del Tag | Ponlo donde te indica Relevo esta semana. Sonará cuando sumes el tiempo que elegiste en tus apps. | `TagGuide.kt:69` |
| T0334 | guía del Tag | Donde te indica la semana | `TagGuide.kt:69` |
| T0335 | guía del Tag | Para callarlo, un toque | `TagGuide.kt:70` |
| T0336 | guía del Tag | Cuando suene, toca el botón una vez. No lo mantengas apretado: así se apaga. | `TagGuide.kt:70` |
| T0337 | guía del Tag | Un toque | `TagGuide.kt:70` |
| T0338 | guía del Tag | Para apagarlo | `TagGuide.kt:71` |
| T0339 | guía del Tag | Mantén apretado el botón 3 segundos, hasta que dé un pitido largo. Durante la prueba, mejor déjalo encendido. | `TagGuide.kt:71` |
| T0340 | texto | 3 segundos · pitido largo | `TagGuide.kt:71` |
| T0341 | guía del Tag | La pila dura meses | `TagGuide.kt:72` |
| T0342 | guía del Tag | Usa una pila de botón CR2032. Para cambiarla, abre la tapa por la ranura del borde con una uña o una moneda. | `TagGuide.kt:72` |
| T0343 | texto | Pila CR2032 | `TagGuide.kt:72` |
| T0344 | guía del Tag | Si no aparece o no pita | `TagGuide.kt:73` |
| T0345 | guía del Tag | El Tag se conecta a un solo teléfono a la vez: cierra apps como iSearching y, si lo usaste con otro teléfono, apaga su Bluetooth. Si se conecta pero no pita, o si suena lento y sin parar, sácale la pila unos segundos y vuelve a ponerla. | `TagGuide.kt:73` |
| T0346 | texto | Un teléfono a la vez | `TagGuide.kt:73` |
| T0347 | texto | Entendido | `TagGuide.kt:81` |
| T0348 | título | Cómo usar el Tag | `TagGuide.kt:84` |
| T0349 | botón | Cerrar | `TagGuide.kt:84` |
| T0350 | botón | Atrás | `TagGuide.kt:109` |
| T0351 | texto | Siguiente | `TagGuide.kt:111` |

## 10 Hojas sobre Inicio

12 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0352 | texto | Tu primer relevo está activo | `HomeScreen.kt:373` |
| T0353 | texto | Usa el teléfono como siempre. Cuando sumes [duración] en [apps elegidas], sonará [lugar]. | `HomeScreen.kt:376` |
| T0354 | texto | Cuando suene, la app te dirá qué hacer. Puedes ver o desactivar el relevo en Inicio. | `HomeScreen.kt:380` |
| T0355 | botón | Entendido | `HomeScreen.kt:382` |
| T0356 | texto | Dijiste que empezaste «[actividad]» [dato]. | `RouteScreens.kt:361` |
| T0357 | texto | ¿Quieres probar el siguiente paso? | `RouteScreens.kt:363` |
| T0358 | botón | Probar el siguiente paso | `RouteScreens.kt:378` |
| T0359 | botón | Seguir en este paso | `RouteScreens.kt:379` |
| T0360 | texto | ¿Apagar el aviso semanal? | `RouteScreens.kt:388` |
| T0361 | texto | Puedes volver a activarlo en Perfil, en Avisos y resúmenes. | `RouteScreens.kt:390` |
| T0362 | botón | Apagarlo | `RouteScreens.kt:393` |
| T0363 | botón | Mantenerlo | `RouteScreens.kt:394` |

## 11 Tu relevo (contando)

30 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0364 | volver | Inicio | `HomeScreen.kt:482` |
| T0365 | botón | Volver al inicio | `HomeScreen.kt:490` |
| T0366 | botón | Desactivar el relevo | `HomeScreen.kt:492` |
| T0367 | etiqueta | Contando | `HomeScreen.kt:496` |
| T0368 | etiqueta | En pausa | `HomeScreen.kt:496` |
| T0369 | texto | Sonará [lugar] después de [duración] en las apps que elegiste. | `HomeScreen.kt:500` |
| T0370 | texto | de [duración] | `HomeScreen.kt:506` |
| T0371 | aviso | Falta el permiso de Tiempo de uso. | `HomeScreen.kt:510` |
| T0372 | título | Relevo no puede contar el tiempo | `HomeScreen.kt:510` |
| T0373 | acción | Dar el permiso | `HomeScreen.kt:511` |
| T0374 | texto | Para empezar | `HomeScreen.kt:517` |
| T0375 | texto | Dónde empiezas | `HomeScreen.kt:518` |
| T0376 | texto | Suena | `HomeScreen.kt:519` |
| T0377 | texto | Apps que cuentan | `HomeScreen.kt:521` |
| T0378 | título | Batería | `HomeScreen.kt:530` |
| T0379 | acción | Quitar la restricción | `HomeScreen.kt:531` |
| T0380 | acción | Editar este relevo | `HomeScreen.kt:535` |
| T0381 | acción | Eliminar este relevo | `HomeScreen.kt:538` |
| T0382 | texto | ¿Editar el relevo? | `HomeScreen.kt:542` |
| T0383 | texto | Puedes cambiar cualquier dato sin borrarlo. Mientras lo editas no cuenta; al activarlo de nuevo, sigue con el tiempo que llevabas si las apps son las mismas. | `HomeScreen.kt:544` |
| T0384 | botón | Editar | `HomeScreen.kt:546` |
| T0385 | botón | Cancelar | `HomeScreen.kt:548` |
| T0386 | texto | ¿Eliminar este relevo? | `HomeScreen.kt:553` |
| T0387 | texto | Deja de contar, no sonará y no queda en tus relevos. Sirve si lo activaste por error. | `HomeScreen.kt:555` |
| T0388 | botón | Eliminar | `HomeScreen.kt:557` |
| T0389 | botón | Mantenerlo | `HomeScreen.kt:559` |
| T0390 | texto | ¿Desactivar el relevo? | `HomeScreen.kt:564` |
| T0391 | texto | Dejará de contar el tiempo y no sonará. Después podrás decir qué decidiste. | `HomeScreen.kt:566` |
| T0392 | botón | Desactivar | `HomeScreen.kt:568` |
| T0393 | botón | Mantenerlo | `HomeScreen.kt:570` |

## 12 Suena

13 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0394 | texto | Silenciar y continuar | `SignalScreens.kt:74` |
| T0395 | texto | Continuar | `SignalScreens.kt:74` |
| T0396 | guía | Así suena Relevo. Toca «Silenciar y continuar» y después cuéntanos qué hiciste. | `SignalScreens.kt:78` |
| T0397 | etiqueta | No sonó | `SignalScreens.kt:83` |
| T0398 | etiqueta | Ya dejó de sonar | `SignalScreens.kt:85` |
| T0399 | texto | Para callarlo en el Tag, toca su botón una vez. | `SignalScreens.kt:90` |
| T0400 | texto | Es momento de volver a elegir | `SignalScreens.kt:93` |
| T0401 | texto | También puedes hacerlo sonar en el teléfono. | `SignalScreens.kt:106` |
| T0402 | título | Se cumplió el tiempo | `SignalScreens.kt:107` |
| T0403 | acción | Probar otra vez | `SignalScreens.kt:109` |
| T0404 | acción | Sonar en el teléfono | `SignalScreens.kt:110` |
| T0405 | texto | Ahora sonó. | `SignalScreens.kt:111` |
| T0406 | texto | Todavía no suena. | `SignalScreens.kt:111` |

## 13 Preguntas y ¿Qué decidiste?

24 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0407 | texto | Bien | `Feedback.kt:43` |
| T0408 | texto | Normal | `Feedback.kt:44` |
| T0409 | texto | Mal | `Feedback.kt:45` |
| T0410 | acción | Saltar | `SignalScreens.kt:154` |
| T0411 | guía | Responde lo que pasó de verdad. No hay respuestas buenas ni malas; todas nos ayudan a mejorar Relevo. | `SignalScreens.kt:158` |
| T0412 | texto | Sonó [lugar]. | `SignalScreens.kt:166` |
| T0413 | fragmento | en el teléfono | `SignalScreens.kt:166` |
| T0414 | texto | Desactivaste el relevo. | `SignalScreens.kt:167` |
| T0415 | pregunta | ¿Notaste el aviso apenas sonó? | `SignalScreens.kt:176` |
| T0416 | texto | Enseguida | `SignalScreens.kt:177` |
| T0417 | texto | Un rato después | `SignalScreens.kt:177` |
| T0418 | texto | No lo noté | `SignalScreens.kt:177` |
| T0419 | pregunta | ¿Cómo te cayó el sonido? | `SignalScreens.kt:180` |
| T0420 | pregunta | Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla? | `SignalScreens.kt:184` |
| T0421 | texto | Sí | `SignalScreens.kt:185` |
| T0422 | texto | A medias | `SignalScreens.kt:185` |
| T0423 | texto | No | `SignalScreens.kt:185` |
| T0424 | pregunta | ¿Recordaste cómo empezar? | `SignalScreens.kt:188` |
| T0425 | texto | Sí | `SignalScreens.kt:189` |
| T0426 | texto | No | `SignalScreens.kt:189` |
| T0427 | texto | ¿Qué decidiste? | `SignalScreens.kt:193` |
| T0428 | botón | Comencé la actividad | `SignalScreens.kt:196` |
| T0429 | botón | La dejé para después | `SignalScreens.kt:197` |
| T0430 | botón | Cambié de idea | `SignalScreens.kt:198` |

## 14 Ruta

21 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0431 | título | Tu ruta | `RouteScreens.kt:103` |
| T0432 | texto | Pasos pequeños hacia lo que te gustaría hacer más seguido. | `RouteScreens.kt:104` |
| T0433 | botón | Elegir intereses | `RouteScreens.kt:107` |
| T0434 | botón | Preparar un relevo con este paso | `RouteScreens.kt:108` |
| T0435 | texto | Arma tu ruta | `RouteScreens.kt:114` |
| T0436 | texto | Elige lo que te gustaría hacer más seguido y te proponemos pasos pequeños, que puedes cambiar. | `RouteScreens.kt:116` |
| T0437 | texto | Esta ruta todavía no tiene pasos. | `RouteScreens.kt:139` |
| T0438 | botón | Agregar pasos | `RouteScreens.kt:141` |
| T0439 | texto | Ver el paso | `RouteScreens.kt:148` |
| T0440 | texto | Tienes un relevo activo. Cuando termine, puedes preparar otro. | `RouteScreens.kt:164` |
| T0441 | título | Todos los pasos | `RouteScreens.kt:167` |
| T0442 | texto | Paso [número] de [dato] | `RouteScreens.kt:184` |
| T0443 | botón | Preparar un relevo con este paso | `RouteScreens.kt:194` |
| T0444 | texto | Pasar a este paso | `RouteScreens.kt:198` |
| T0445 | texto | Volver a este paso | `RouteScreens.kt:198` |
| T0446 | botón | Editar los pasos | `RouteScreens.kt:209` |
| T0447 | botón | Cambiar intereses | `RouteScreens.kt:210` |
| T0448 | texto | Ahora | `RouteScreens.kt:218` |
| T0449 | lector de pantalla | Ver el paso | `RouteScreens.kt:245` |
| T0450 | texto | Paso actual | `RouteScreens.kt:246` |
| T0451 | texto | Ahora | `RouteScreens.kt:261` |

## 15 Editar la ruta

22 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0452 | subtítulo | Toca un paso para cambiarlo. Con los tres puntos, puedes moverlo o borrarlo. | `RouteScreens.kt:277` |
| T0453 | volver | Cancelar | `RouteScreens.kt:278` |
| T0454 | botón | Guardar | `RouteScreens.kt:279` |
| T0455 | texto | No hay cambios que guardar. | `RouteScreens.kt:279` |
| T0456 | lector de pantalla | Más opciones de [actividad] | `RouteScreens.kt:291` |
| T0457 | texto | Editar | `RouteScreens.kt:296` |
| T0458 | texto | Subir | `RouteScreens.kt:297` |
| T0459 | texto | Bajar | `RouteScreens.kt:298` |
| T0460 | texto | Pasar a este paso | `RouteScreens.kt:300` |
| T0461 | texto | Volver a este paso | `RouteScreens.kt:300` |
| T0462 | texto | Borrar | `RouteScreens.kt:302` |
| T0463 | botón | Agregar un paso | `RouteScreens.kt:311` |
| T0464 | texto | Nuevo paso | `RouteScreens.kt:338` |
| T0465 | texto | Editar el paso | `RouteScreens.kt:338` |
| T0466 | campo | Actividad | `RouteScreens.kt:340` |
| T0467 | ayuda del campo | Ej.: caminar 30 minutos | `RouteScreens.kt:340` |
| T0468 | campo | Para empezar | `RouteScreens.kt:342` |
| T0469 | ayuda del campo | Ej.: ponerte las zapatillas | `RouteScreens.kt:342` |
| T0470 | campo | Dónde empiezas | `RouteScreens.kt:344` |
| T0471 | ayuda del campo | Ej.: junto a la puerta | `RouteScreens.kt:344` |
| T0472 | botón | Guardar el paso | `RouteScreens.kt:346` |
| T0473 | validación | Escribe la actividad del paso. | `RouteScreens.kt:347` |

## 16 Perfil

33 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0474 | título | Relevos | `ProfileScreens.kt:130` |
| T0475 | fila | Tus relevos | `ProfileScreens.kt:131` |
| T0476 | fila | Tus actividades | `ProfileScreens.kt:132` |
| T0477 | fila | Tu ruta | `ProfileScreens.kt:133` |
| T0478 | título | Ajustes | `ProfileScreens.kt:136` |
| T0479 | fila | Avisos y resúmenes | `ProfileScreens.kt:137` |
| T0480 | fila | Apariencia | `ProfileScreens.kt:138` |
| T0481 | fila | Permisos | `ProfileScreens.kt:139` |
| T0482 | título | Privacidad | `ProfileScreens.kt:142` |
| T0483 | fila | Tus datos | `ProfileScreens.kt:143` |
| T0484 | título | Ayuda | `ProfileScreens.kt:146` |
| T0485 | fila | Cómo funciona Relevo | `ProfileScreens.kt:147` |
| T0486 | fila | Cómo usar el Tag | `ProfileScreens.kt:148` |
| T0487 | fila | Tu opinión | `ProfileScreens.kt:149` |
| T0488 | fila | Reportar un problema | `ProfileScreens.kt:150` |
| T0489 | texto | Relevo [dato] · Proyecto de Título de Diseño, Universidad Diego Portales | `ProfileScreens.kt:154` |
| T0490 | lector de pantalla | Editar el perfil | `ProfileScreens.kt:175` |
| T0491 | texto | Tu perfil | `ProfileScreens.kt:178` |
| T0492 | botón | Editar | `ProfileScreens.kt:184` |
| T0493 | texto | Tu semana | `ProfileScreens.kt:193` |
| T0494 | texto | Esta semana todavía no preparaste relevos. | `ProfileScreens.kt:196` |
| T0495 | texto | Preparaste 1 relevo. | `ProfileScreens.kt:197` |
| T0496 | texto | Preparaste [dato] relevos. | `ProfileScreens.kt:198` |
| T0497 | texto | Dijiste que empezaste 1 vez. | `ProfileScreens.kt:201` |
| T0498 | texto | Dijiste que empezaste [dato] veces. | `ProfileScreens.kt:202` |
| T0499 | texto | Elegiste hacerlo [dato] [dato] por semana. | `ProfileScreens.kt:208` |
| T0500 | acción | ¿Qué te ayudó? | `ProfileScreens.kt:210` |
| T0501 | título | ¿Qué te ayudó? | `ProfileScreens.kt:217` |
| T0502 | texto | Nos ayuda a mejorar Relevo. | `ProfileScreens.kt:218` |
| T0503 | campo | Tu respuesta | `ProfileScreens.kt:220` |
| T0504 | validación | Escribe aquí | `ProfileScreens.kt:220` |
| T0505 | botón | Enviar | `ProfileScreens.kt:222` |
| T0506 | validación | Escribe qué te ayudó. | `ProfileScreens.kt:222` |

## 17 Editar el perfil

13 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0507 | título | Tu perfil | `ProfileScreens.kt:349` |
| T0508 | volver | Cancelar | `ProfileScreens.kt:350` |
| T0509 | botón | Guardar | `ProfileScreens.kt:352` |
| T0510 | validación | Escribe tu nombre. | `ProfileScreens.kt:353` |
| T0511 | validación | Escribe cuál es tu otro interés. | `ProfileScreens.kt:354` |
| T0512 | texto | No hay cambios que guardar. | `ProfileScreens.kt:355` |
| T0513 | lector de pantalla | Cambiar el emoji | `ProfileScreens.kt:364` |
| T0514 | acción | Cambiar el emoji | `ProfileScreens.kt:367` |
| T0515 | campo | Tu nombre | `ProfileScreens.kt:370` |
| T0516 | ayuda del campo | Como quieras que te diga Relevo | `ProfileScreens.kt:370` |
| T0517 | texto | Intereses | `ProfileScreens.kt:372` |
| T0518 | título | Tu emoji | `ProfileScreens.kt:376` |
| T0519 | botón | Listo | `ProfileScreens.kt:376` |

## 18 Avisos y resúmenes

26 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0520 | título | Avisos y resúmenes | `SettingsScreens.kt:101` |
| T0521 | volver | Perfil | `SettingsScreens.kt:101` |
| T0522 | texto | Activación automática | `SettingsScreens.kt:104` |
| T0523 | texto | Cuando abras las apps de tu último relevo, Relevo empieza a contar solo. | `SettingsScreens.kt:104` |
| T0524 | texto | No | `SettingsScreens.kt:105` |
| T0525 | texto | Sí | `SettingsScreens.kt:105` |
| T0526 | texto | Primero prepara y termina un relevo: la activación automática repite ese. | `SettingsScreens.kt:116` |
| T0527 | texto | Mientras esté encendida, Relevo mira qué app tienes abierta —solo su nombre— para saber cuándo empezar. Después de cada relevo espera 30 minutos antes de activarse otra vez. | `SettingsScreens.kt:119` |
| T0528 | texto | Resumen semanal | `SettingsScreens.kt:125` |
| T0529 | texto | Lo que preparaste esta semana, en tu perfil. | `SettingsScreens.kt:125` |
| T0530 | texto | No | `SettingsScreens.kt:126` |
| T0531 | texto | Sí | `SettingsScreens.kt:126` |
| T0532 | texto | Aviso semanal | `SettingsScreens.kt:131` |
| T0533 | texto | Si pasas una semana sin abrir Relevo, te avisa una vez. | `SettingsScreens.kt:131` |
| T0534 | texto | No | `SettingsScreens.kt:132` |
| T0535 | texto | Sí | `SettingsScreens.kt:132` |
| T0536 | texto | Mensaje después de responder | `SettingsScreens.kt:140` |
| T0537 | texto | Unas palabras cuando cuentas qué decidiste. | `SettingsScreens.kt:140` |
| T0538 | texto | No | `SettingsScreens.kt:141` |
| T0539 | texto | Sí | `SettingsScreens.kt:141` |
| T0540 | texto | Veces por semana | `SettingsScreens.kt:146` |
| T0541 | texto | Cuántas veces por semana quieres hacerlo. Aparece en tu resumen semanal. | `SettingsScreens.kt:146` |
| T0542 | texto | No | `SettingsScreens.kt:147` |
| T0543 | texto | Sí | `SettingsScreens.kt:147` |
| T0544 | texto | Retomar | `SettingsScreens.kt:153` |
| T0545 | texto | Pausar | `SettingsScreens.kt:153` |

## 19 Apariencia

12 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0546 | título | Apariencia | `SettingsScreens.kt:164` |
| T0547 | volver | Perfil | `SettingsScreens.kt:164` |
| T0548 | texto | Sonará junto al sillón después de 40 min. | `SettingsScreens.kt:167` |
| T0549 | texto | Tema | `SettingsScreens.kt:171` |
| T0550 | texto | Claro, oscuro o como esté tu teléfono. | `SettingsScreens.kt:171` |
| T0551 | texto | Automático | `SettingsScreens.kt:172` |
| T0552 | texto | Claro | `SettingsScreens.kt:172` |
| T0553 | texto | Oscuro | `SettingsScreens.kt:172` |
| T0554 | texto | Tamaño del texto | `SettingsScreens.kt:177` |
| T0555 | texto | Se suma al tamaño que usas en el teléfono. | `SettingsScreens.kt:177` |
| T0556 | texto | Estándar | `SettingsScreens.kt:178` |
| T0557 | texto | Grande | `SettingsScreens.kt:178` |

## 20 Permisos

15 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0558 | título | Permisos | `SettingsScreens.kt:190` |
| T0559 | volver | Perfil | `SettingsScreens.kt:190` |
| T0560 | texto | Tiempo de uso es necesario para contar. Lo demás es opcional. | `SettingsScreens.kt:191` |
| T0561 | fila | Tiempo de uso | `SettingsScreens.kt:192` |
| T0562 | subtítulo | Para contar el tiempo en las apps que elijas. | `SettingsScreens.kt:192` |
| T0563 | texto | Permitido | `SettingsScreens.kt:192` |
| T0564 | validación | Falta | `SettingsScreens.kt:192` |
| T0565 | fila | Notificaciones | `SettingsScreens.kt:193` |
| T0566 | subtítulo | Para avisarte aunque estés en otra app. | `SettingsScreens.kt:193` |
| T0567 | texto | Permitidas | `SettingsScreens.kt:193` |
| T0568 | texto | Apagadas | `SettingsScreens.kt:193` |
| T0569 | fila | Batería | `SettingsScreens.kt:195` |
| T0570 | subtítulo | Para que Android no detenga a Relevo. | `SettingsScreens.kt:195` |
| T0571 | texto | Sin restricción | `SettingsScreens.kt:195` |
| T0572 | texto | Con restricción | `SettingsScreens.kt:195` |

## 21 Tus relevos

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0573 | título | Tus relevos | `SettingsScreens.kt:204` |
| T0574 | volver | Perfil | `SettingsScreens.kt:204` |
| T0575 | texto | Aquí verás los relevos que termines. | `SettingsScreens.kt:206` |
| T0576 | texto | Hoy | `SettingsScreens.kt:212` |
| T0577 | texto | Ayer | `SettingsScreens.kt:213` |
| T0578 | texto | Sonó | `SettingsScreens.kt:220` |
| T0579 | texto | Terminó antes de sonar | `SettingsScreens.kt:220` |

## 22 Tus actividades

8 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0580 | título | Tus actividades | `SettingsScreens.kt:247` |
| T0581 | subtítulo | Lo que haces seguido, listo para preparar en un toque. | `SettingsScreens.kt:248` |
| T0582 | volver | Perfil | `SettingsScreens.kt:249` |
| T0583 | botón | Crear una actividad | `SettingsScreens.kt:250` |
| T0584 | texto | Todavía no tienes actividades | `SettingsScreens.kt:257` |
| T0585 | texto | Anota qué haces, cómo empiezas y dónde. Después la encuentras en Inicio y al preparar un relevo. | `SettingsScreens.kt:258` |
| T0586 | botón | Preparar un relevo | `SettingsScreens.kt:284` |
| T0587 | botón | Editar | `SettingsScreens.kt:286` |

## 23 Crear o editar una actividad

27 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0588 | texto | Nueva actividad | `SettingsScreens.kt:314` |
| T0589 | texto | Editar la actividad | `SettingsScreens.kt:314` |
| T0590 | volver | Cancelar | `SettingsScreens.kt:315` |
| T0591 | botón | Guardar | `SettingsScreens.kt:317` |
| T0592 | validación | Escribe el nombre de la actividad. | `SettingsScreens.kt:320` |
| T0593 | texto | El nombre es muy largo: usa hasta 60 caracteres. | `SettingsScreens.kt:321` |
| T0594 | texto | Ya existe una actividad con ese nombre. | `SettingsScreens.kt:322` |
| T0595 | validación | Escribe cómo empiezas. | `SettingsScreens.kt:323` |
| T0596 | validación | Escribe dónde empiezas. | `SettingsScreens.kt:324` |
| T0597 | lector de pantalla | Cambiar la imagen | `SettingsScreens.kt:333` |
| T0598 | acción | Cambiar la imagen | `SettingsScreens.kt:337` |
| T0599 | campo | Actividad | `SettingsScreens.kt:340` |
| T0600 | ayuda del campo | Ej.: practicar guitarra | `SettingsScreens.kt:340` |
| T0601 | texto | Ya tienes una actividad con ese nombre. | `SettingsScreens.kt:341` |
| T0602 | campo | Para empezar | `SettingsScreens.kt:343` |
| T0603 | ayuda del campo | Ej.: sacar la guitarra del estuche | `SettingsScreens.kt:343` |
| T0604 | campo | Dónde empiezas | `SettingsScreens.kt:345` |
| T0605 | ayuda del campo | Ej.: junto a la guitarra | `SettingsScreens.kt:345` |
| T0606 | botón | Borrar la actividad | `SettingsScreens.kt:348` |
| T0607 | título | Elige una imagen | `SettingsScreens.kt:352` |
| T0608 | botón | Listo | `SettingsScreens.kt:352` |
| T0609 | texto | Fotos | `SettingsScreens.kt:353` |
| T0610 | texto | Iconos | `SettingsScreens.kt:362` |
| T0611 | texto | ¿Borrar «[nombre]»? | `SettingsScreens.kt:374` |
| T0612 | texto | Se quita de tus actividades. Los relevos que ya hiciste se mantienen. | `SettingsScreens.kt:376` |
| T0613 | botón | Borrar | `SettingsScreens.kt:378` |
| T0614 | botón | Cancelar | `SettingsScreens.kt:380` |

## 24 Privacidad y datos

29 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0615 | texto | Todo está enviado. | `Common.kt:290` |
| T0616 | texto | Algunos datos se enviarán cuando haya internet. | `Common.kt:290` |
| T0617 | texto | Último envío: [dato]. | `Common.kt:291` |
| T0618 | texto | Detalle técnico: [dato] | `Common.kt:293` |
| T0619 | texto | En Documentos/Relevo. Última copia: [dato]. | `Common.kt:297` |
| T0620 | texto | Se crea en Documentos/Relevo con el primer relevo. | `Common.kt:297` |
| T0621 | texto | Borrando tus datos… | `RelevoViewModel.kt:1098` |
| T0622 | texto | Relevo dejó de guardar datos, pero no pudimos confirmar el borrado. Tus datos siguen en el teléfono. Inténtalo de nuevo o escribe a [correo del investigador]. | `RelevoViewModel.kt:1142` |
| T0623 | texto | Tus datos se borraron y saliste del proyecto. Si quieres volver, tendrás que aceptar de nuevo. | `RelevoViewModel.kt:1194` |
| T0624 | texto | Tus datos quedaron en el archivo que elegiste. | `SettingsScreens.kt:409` |
| T0625 | texto | No se pudo guardar el archivo. Prueba otra vez. | `SettingsScreens.kt:409` |
| T0626 | título | Tus datos | `SettingsScreens.kt:412` |
| T0627 | botón | Volver a comenzar | `SettingsScreens.kt:413` |
| T0628 | texto | Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte, solo con ese código. No vemos lo que haces dentro de otras apps. Si no borras tus datos antes, los borramos el 30 de diciembre de 2026. | `SettingsScreens.kt:416` |
| T0629 | fila | Tu código | `SettingsScreens.kt:423` |
| T0630 | texto | Sin código | `SettingsScreens.kt:423` |
| T0631 | fila | Lo que aceptaste | `SettingsScreens.kt:426` |
| T0632 | fila | Datos enviados | `SettingsScreens.kt:427` |
| T0633 | fila | Copia en el teléfono | `SettingsScreens.kt:428` |
| T0634 | texto | Primero se borra en la base del proyecto. Si no se puede, Relevo deja de guardar datos y conserva lo del teléfono para intentarlo otra vez. | `SettingsScreens.kt:432` |
| T0635 | fila | Descargar mis datos | `SettingsScreens.kt:433` |
| T0636 | subtítulo | Un archivo con todo lo guardado en el teléfono. | `SettingsScreens.kt:433` |
| T0637 | fila | Borrar mis datos | `SettingsScreens.kt:435` |
| T0638 | subtítulo | También sales del proyecto. | `SettingsScreens.kt:435` |
| T0639 | texto | ¿Dudas, o prefieres pedir el borrado por correo? Escribe a [correo del investigador] con tu código. | `SettingsScreens.kt:440` |
| T0640 | texto | ¿Borrar tus datos? | `SettingsScreens.kt:450` |
| T0641 | texto | Se borran tus relevos, actividades, perfil, ruta y respuestas, también en la base del proyecto y en la copia de Documentos/Relevo. Sales del proyecto y Relevo deja de contar. | `SettingsScreens.kt:452` |
| T0642 | botón | Borrar mis datos | `SettingsScreens.kt:454` |
| T0643 | botón | Cancelar | `SettingsScreens.kt:456` |

## 25 Lo que aceptaste

2 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0644 | título | Lo que aceptaste | `FirstRunScreens.kt:175` |
| T0645 | texto | Aceptaste participar con este texto. | `FirstRunScreens.kt:176` |

## 26 Prueba de 21 días (investigador)

25 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0646 | texto | Secuencia no válida: [dato] | `Study.kt:39` |
| T0647 | título | Prueba de 21 días | `StudyScreens.kt:108` |
| T0648 | texto | Empezar la semana hoy | `StudyScreens.kt:109` |
| T0649 | texto | Empezar la prueba hoy | `StudyScreens.kt:109` |
| T0650 | validación | Elige una secuencia o una semana. | `StudyScreens.kt:109` |
| T0651 | texto | Para configurar la prueba, primero hay que aceptar participar. | `StudyScreens.kt:112` |
| T0652 | texto | Para el investigador, en la sesión inicial. Elige la secuencia asignada; hoy será el día 0. | `StudyScreens.kt:114` |
| T0653 | título | Condiciones | `StudyScreens.kt:116` |
| T0654 | título | Secuencia | `StudyScreens.kt:120` |
| T0655 | fila | Secuencia [número] | `StudyScreens.kt:122` |
| T0656 | título | Una semana para comparar | `StudyScreens.kt:127` |
| T0657 | fila | Semana [dato]: [condición] | `StudyScreens.kt:130` |
| T0658 | subtítulo | Empieza hoy (día 1) y dura 7 días. Antes, pregunta por las semanas anteriores. | `StudyScreens.kt:130` |
| T0659 | texto | La semana de comparación terminó. | `StudyScreens.kt:136` |
| T0660 | texto | La prueba terminó el día 21. | `StudyScreens.kt:136` |
| T0661 | texto | Hoy es la sesión inicial (día 0). | `StudyScreens.kt:137` |
| T0662 | texto | Día [día] de 7 · semana de comparación: [condición]. | `StudyScreens.kt:138` |
| T0663 | texto | Día [día] de 21 · semana [semana]: [condición]. | `StudyScreens.kt:139` |
| T0664 | fila | Secuencia | `StudyScreens.kt:145` |
| T0665 | fila | Día 0 | `StudyScreens.kt:146` |
| T0666 | fila | Código de participación | `StudyScreens.kt:147` |
| T0667 | texto | La condición de cada semana fija dónde suena la señal. Las preguntas y las tarjetas aparecen solas. | `StudyScreens.kt:150` |
| T0668 | botón | Terminar la prueba | `StudyScreens.kt:153` |
| T0669 | acción | Cancelar | `StudyScreens.kt:154` |
| T0670 | acción | Terminar la prueba | `StudyScreens.kt:156` |

## 27 ¿Cómo te fue esta semana?

16 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0671 | texto | ¿Cómo te fue hasta ahora? | `StudyScreens.kt:172` |
| T0672 | texto | ¿Cómo te fue esta semana? | `StudyScreens.kt:172` |
| T0673 | texto | Las semanas antes de esta, con el objeto que ya usabas. | `StudyScreens.kt:173` |
| T0674 | volver | Después | `StudyScreens.kt:174` |
| T0675 | botón | Enviar | `StudyScreens.kt:176` |
| T0676 | acción | Saltar | `StudyScreens.kt:177` |
| T0677 | pregunta | ¿Te costó preparar Relevo? | `StudyScreens.kt:180` |
| T0678 | pregunta | ¿Te molestó el sonido? | `StudyScreens.kt:182` |
| T0679 | pregunta | ¿El sonido tenía que ver con el lugar donde sonó? | `StudyScreens.kt:184` |
| T0680 | pregunta | Comparado con las semanas anteriores, ¿esta semana te ayudó a recordar lo que querías hacer… | `StudyScreens.kt:188` |
| T0681 | texto | Más | `StudyScreens.kt:189` |
| T0682 | texto | Igual | `StudyScreens.kt:189` |
| T0683 | texto | Menos | `StudyScreens.kt:189` |
| T0684 | texto | ¿Por qué? ¿Algo más que quieras contarnos? | `StudyScreens.kt:193` |
| T0685 | texto | ¿Algo más que quieras contarnos? | `StudyScreens.kt:193` |
| T0686 | validación | Escribe aquí, si quieres | `StudyScreens.kt:193` |

## 28 Cierre de la prueba

32 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0687 | texto | ¡Terminaste la prueba! | `StudyScreens.kt:212` |
| T0688 | texto | ¡Terminaste los 21 días! | `StudyScreens.kt:212` |
| T0689 | texto | Gracias. Siete preguntas cortas; puedes saltar las que quieras. | `StudyScreens.kt:213` |
| T0690 | texto | Gracias. Cinco preguntas cortas; puedes saltar las que quieras. | `StudyScreens.kt:213` |
| T0691 | volver | Después | `StudyScreens.kt:214` |
| T0692 | botón | Enviar | `StudyScreens.kt:216` |
| T0693 | pregunta | 1. ¿Seguirías usando Relevo? | `StudyScreens.kt:229` |
| T0694 | texto | Sí | `StudyScreens.kt:230` |
| T0695 | texto | Tal vez | `StudyScreens.kt:230` |
| T0696 | texto | No | `StudyScreens.kt:230` |
| T0697 | texto | 2. ¿Qué te ayudó más a recordar lo que querías hacer? | `StudyScreens.kt:234` |
| T0698 | texto | 2. ¿Qué semana te ayudó más? | `StudyScreens.kt:234` |
| T0699 | texto | El objeto donde empiezo | `StudyScreens.kt:235` |
| T0700 | texto | El aviso en el teléfono | `StudyScreens.kt:235` |
| T0701 | texto | Los dos por igual | `StudyScreens.kt:235` |
| T0702 | texto | Ninguno | `StudyScreens.kt:235` |
| T0703 | texto | Ninguna | `StudyScreens.kt:236` |
| T0704 | campo | 3. ¿Por qué? | `StudyScreens.kt:245` |
| T0705 | validación | Escribe aquí | `StudyScreens.kt:245` |
| T0706 | pregunta | 4. Si siguieras usando Relevo, ¿con qué te gustaría que sonara? | `StudyScreens.kt:247` |
| T0707 | texto | Un objeto | `StudyScreens.kt:248` |
| T0708 | texto | El teléfono | `StudyScreens.kt:248` |
| T0709 | texto | Me da igual | `StudyScreens.kt:248` |
| T0710 | texto | 5. ¿Qué te molestó? | `StudyScreens.kt:252` |
| T0711 | texto | 3. ¿Qué te molestó? | `StudyScreens.kt:252` |
| T0712 | validación | Escribe aquí | `StudyScreens.kt:252` |
| T0713 | texto | 6. ¿Qué cambiarías? | `StudyScreens.kt:254` |
| T0714 | texto | 4. ¿Qué cambiarías? | `StudyScreens.kt:254` |
| T0715 | validación | Escribe aquí | `StudyScreens.kt:254` |
| T0716 | texto | 7. ¿Dónde quedó el objeto la mayor parte del tiempo? | `StudyScreens.kt:256` |
| T0717 | texto | 5. ¿Dónde quedó lo que sonaba la mayor parte del tiempo? | `StudyScreens.kt:256` |
| T0718 | texto | Ejemplo: junto a la puerta | `StudyScreens.kt:256` |

## 29 Opinar sobre Relevo

6 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0719 | título | ¿Cómo te resultó Relevo? | `SettingsScreens.kt:471` |
| T0720 | volver | Cerrar | `SettingsScreens.kt:472` |
| T0721 | botón | Enviar | `SettingsScreens.kt:473` |
| T0722 | validación | Elige las estrellas o escribe un comentario. | `SettingsScreens.kt:473` |
| T0723 | campo | Comentario | `SettingsScreens.kt:477` |
| T0724 | texto | ¿Qué cambiarías? | `SettingsScreens.kt:477` |

## 30 Reportar un problema

8 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0725 | título | Reportar un problema | `SettingsScreens.kt:487` |
| T0726 | volver | Cerrar | `SettingsScreens.kt:488` |
| T0727 | botón | Enviar | `SettingsScreens.kt:489` |
| T0728 | validación | Escribe qué pasó. | `SettingsScreens.kt:489` |
| T0729 | campo | ¿Qué pasó? | `SettingsScreens.kt:491` |
| T0730 | texto | Ej.: no sonó en el parlante | `SettingsScreens.kt:491` |
| T0731 | texto | Adjuntar datos técnicos | `SettingsScreens.kt:501` |
| T0732 | texto | Versión, permisos y estado del envío. Nada de lo que haces en tus apps. | `SettingsScreens.kt:502` |

## 31 Notificaciones

29 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0733 | notificación | Relevo está contando tu tiempo en las apps que elegiste | `AppUsageMonitorService.kt:117` |
| T0734 | notificación | Relevo se activará solo | `AppUsageMonitorService.kt:117` |
| T0735 | notificación | Deja de contar cuando desactivas el relevo. | `AppUsageMonitorService.kt:118` |
| T0736 | notificación | Empieza a contar cuando abras las apps de tu último relevo. | `AppUsageMonitorService.kt:118` |
| T0737 | notificación: título | Relevo dejó de contar | `AppUsageMonitorService.kt:337` |
| T0738 | notificación: texto | Falta el permiso de Tiempo de uso. Abre Relevo para darlo o desactivar el relevo. | `AppUsageMonitorService.kt:338` |
| T0739 | notificación: texto | Falta el permiso de Tiempo de uso. Abre Relevo para darlo o desactivar el relevo. | `AppUsageMonitorService.kt:339` |
| T0740 | lector de pantalla | Muestra que Relevo está contando el tiempo en las apps que elegiste o esperando para activarse solo. | `AppUsageMonitorService.kt:361` |
| T0741 | lector de pantalla | Suena cuando sumas el tiempo que elegiste. | `AppUsageMonitorService.kt:366` |
| T0742 | lector de pantalla | Avisa si Relevo dejó de contar, por ejemplo al retirar un permiso. | `AppUsageMonitorService.kt:373` |
| T0743 | notificación: título | Relevo | `AppUsageMonitorService.kt:388` |
| T0744 | texto | No se encontró el parlante. Abre Relevo para revisarlo. | `AppUsageMonitorService.kt:392` |
| T0745 | texto | No se encontró el reloj. Abre Relevo para revisarlo. | `AppUsageMonitorService.kt:393` |
| T0746 | texto | No se encontró el Tag. Abre Relevo para revisarlo. | `AppUsageMonitorService.kt:394` |
| T0747 | texto | No sonó en el teléfono. Abre Relevo para revisarlo. | `AppUsageMonitorService.kt:395` |
| T0748 | texto | Es momento de volver a elegir. | `AppUsageMonitorService.kt:397` |
| T0749 | texto | Es momento de volver a elegir. Empieza por [primer paso]. | `AppUsageMonitorService.kt:398` |
| T0750 | notificación | Relevo | `AppUsageMonitorService.kt:404` |
| T0751 | notificación | Es momento de volver a elegir | `AppUsageMonitorService.kt:419` |
| T0752 | lector de pantalla | Mensajes del investigador sobre el testeo. | `ProjectMessages.kt:116` |
| T0753 | notificación: título | Relevo | `ProjectMessages.kt:128` |
| T0754 | notificación: texto | Tienes un mensaje nuevo | `ProjectMessages.kt:129` |
| T0755 | notificación | ¿Quieres preparar un relevo esta semana? | `ReturnNotice.kt:31` |
| T0756 | lector de pantalla | Una vez por semana como máximo, si no abriste Relevo. Se apaga en Perfil, en Avisos y resúmenes. | `ReturnNotice.kt:67` |
| T0757 | notificación | ¿Sigue en pie [actividad] esta semana? | `ReturnNotice.kt:72` |
| T0758 | notificación: título | Relevo | `ReturnNotice.kt:76` |
| T0759 | notificación: título | Relevo | `ReturnNotice.kt:93` |
| T0760 | notificación: botón | Preparar | `ReturnNotice.kt:96` |
| T0761 | notificación: botón | Ahora no | `ReturnNotice.kt:97` |

## 32 Textos compartidos

43 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0762 | texto | Empieza por [primer paso], [lugar]. | `Common.kt:223` |
| T0763 | texto | Empieza por [primer paso]. | `Common.kt:224` |
| T0764 | texto | Empieza [lugar]. | `Common.kt:225` |
| T0765 | texto | donde lo dejaste | `Common.kt:233` |
| T0766 | texto | detrás | `Common.kt:235` |
| T0767 | texto | en «[dato]» | `Common.kt:236` |
| T0768 | texto | El parlante | `Common.kt:264` |
| T0769 | texto | El reloj | `Common.kt:265` |
| T0770 | texto | El Tag | `Common.kt:266` |
| T0771 | texto | El teléfono | `Common.kt:267` |
| T0772 | texto | No sonó en el parlante. Revisa que esté encendido y conectado. | `Common.kt:278` |
| T0773 | texto | No sonó en el reloj. Revisa que esté conectado y con las llamadas por Bluetooth activadas. | `Common.kt:279` |
| T0774 | texto | No sonó en el Tag. Revisa que esté encendido y cerca del teléfono. | `Common.kt:280` |
| T0775 | texto | No sonó en el teléfono. Revisa el volumen. | `Common.kt:281` |
| T0776 | texto | Dijiste que empezaste | `Common.kt:309` |
| T0777 | texto | La dejaste para después | `Common.kt:310` |
| T0778 | texto | Cambiaste de idea | `Common.kt:311` |
| T0779 | texto | Gracias por contarlo. | `Common.kt:324` |
| T0780 | texto | Queda guardado. Puedes prepararlo cuando quieras. | `Common.kt:325` |
| T0781 | texto | Está bien. Puedes elegir otra actividad cuando quieras. | `Common.kt:326` |
| T0782 | texto | , en otro lugar de tu casa | `Common.kt:348` |
| T0783 | texto | , donde empiezas | `Common.kt:349` |
| T0784 | texto | en el teléfono | `Common.kt:354` |
| T0785 | texto | Suena donde empiezas | `Common.kt:359` |
| T0786 | texto | Suena en otro lugar | `Common.kt:360` |
| T0787 | texto | Suena en el teléfono | `Common.kt:361` |
| T0788 | texto | Esta semana deja el parlante, el reloj o el Tag junto a lo que usas para empezar. | `Common.kt:366` |
| T0789 | texto | Esta semana déjalo en otro lugar de tu casa, que no tenga que ver con la actividad. | `Common.kt:367` |
| T0790 | texto | Esta semana suena en tu teléfono. | `Common.kt:368` |
| T0791 | texto | Un lugar visible, a más de un metro de lo que necesitas para empezar y fuera de tu camino. | `Common.kt:372` |
| T0792 | texto | No necesitas el parlante, el reloj ni el Tag: puedes apagar el Tag manteniendo apretado su centro 3 segundos. La notificación solo dirá «Es momento de volver a elegir». | `Common.kt:373` |
| T0793 | título | Tu relevo | `HomeScreen.kt:354` |
| T0794 | texto | Para empezar | `HomeScreen.kt:355` |
| T0795 | texto | Dónde empiezas | `HomeScreen.kt:356` |
| T0796 | fila | Suena | `HomeScreen.kt:357` |
| T0797 | fila | Apps que cuentan | `HomeScreen.kt:358` |
| T0798 | fila | Falta | `HomeScreen.kt:359` |
| T0799 | fila | Cómo empezó | `HomeScreen.kt:360` |
| T0800 | texto | Se activó solo | `HomeScreen.kt:360` |
| T0801 | fila | Ver, editar o desactivar | `HomeScreen.kt:361` |
| T0802 | texto | Nueva actividad | `HomeScreen.kt:454` |
| T0803 | texto | Código de participación | `SettingsScreens.kt:462` |
| T0804 | texto | Suena en | `SignalScreens.kt:129` |

## 33 Ideas, sugerencias y rutas

224 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0805 | texto | Dormir a tiempo | `Route.kt:59` |
| T0806 | texto | Acostarte sin el teléfono | `Route.kt:60` |
| T0807 | texto | Dejar el teléfono cargando lejos de la cama | `Route.kt:60` |
| T0808 | texto | Junto al cargador | `Route.kt:60` |
| T0809 | texto | Leer un rato antes de dormir | `Route.kt:61` |
| T0810 | texto | Dejar el libro en el velador | `Route.kt:61` |
| T0811 | texto | En el velador | `Route.kt:61` |
| T0812 | texto | Acostarte a la misma hora | `Route.kt:62` |
| T0813 | texto | Apagar la luz grande | `Route.kt:62` |
| T0814 | texto | Junto al interruptor | `Route.kt:62` |
| T0815 | texto | Leer | `Route.kt:65` |
| T0816 | texto | Leer 10 páginas | `Route.kt:66` |
| T0817 | texto | Abrir el libro | `Route.kt:66` |
| T0818 | texto | En el velador | `Route.kt:66` |
| T0819 | texto | Leer un capítulo de manga | `Route.kt:67` |
| T0820 | texto | Sacar el tomo del estante | `Route.kt:67` |
| T0821 | texto | Junto al estante | `Route.kt:67` |
| T0822 | texto | Leer un capítulo | `Route.kt:68` |
| T0823 | texto | Abrir el libro en el marcador | `Route.kt:68` |
| T0824 | texto | En el velador | `Route.kt:68` |
| T0825 | texto | Hacer ejercicio | `Route.kt:71` |
| T0826 | texto | Hacer una serie corta | `Route.kt:72` |
| T0827 | texto | Ponerte ropa cómoda | `Route.kt:72` |
| T0828 | texto | Junto al clóset | `Route.kt:72` |
| T0829 | texto | Entrenar 20 minutos | `Route.kt:73` |
| T0830 | texto | Estirar la colchoneta | `Route.kt:73` |
| T0831 | texto | Donde guardas la colchoneta | `Route.kt:73` |
| T0832 | texto | Ir a entrenar | `Route.kt:74` |
| T0833 | texto | Preparar el bolso | `Route.kt:74` |
| T0834 | texto | Junto a la puerta | `Route.kt:74` |
| T0835 | texto | Salir en bicicleta | `Route.kt:77` |
| T0836 | texto | Dar una vuelta corta | `Route.kt:78` |
| T0837 | texto | Sacar la bici | `Route.kt:78` |
| T0838 | texto | Junto a la puerta | `Route.kt:78` |
| T0839 | texto | Andar 30 minutos | `Route.kt:79` |
| T0840 | texto | Inflar las ruedas | `Route.kt:79` |
| T0841 | texto | Junto a la bici | `Route.kt:79` |
| T0842 | texto | Ir en bici a algún lugar | `Route.kt:80` |
| T0843 | texto | Ponerte el casco | `Route.kt:80` |
| T0844 | texto | Junto a la puerta | `Route.kt:80` |
| T0845 | texto | Pasear o jugar con tu perro | `Route.kt:83` |
| T0846 | texto | Salir 10 minutos con el perro | `Route.kt:84` |
| T0847 | texto | Tomar la correa | `Route.kt:84` |
| T0848 | texto | Junto a la puerta | `Route.kt:84` |
| T0849 | texto | Jugar con el perro | `Route.kt:85` |
| T0850 | texto | Sacar su pelota | `Route.kt:85` |
| T0851 | texto | Donde está su pelota | `Route.kt:85` |
| T0852 | texto | Salir con el perro sin el teléfono | `Route.kt:86` |
| T0853 | texto | Dejar el teléfono en casa | `Route.kt:86` |
| T0854 | texto | Junto a la puerta | `Route.kt:86` |
| T0855 | texto | Dibujar o pintar | `Route.kt:89` |
| T0856 | texto | Dibujar 10 minutos | `Route.kt:90` |
| T0857 | texto | Sacar el cuaderno y un lápiz | `Route.kt:90` |
| T0858 | texto | En el escritorio | `Route.kt:90` |
| T0859 | texto | Pintar | `Route.kt:91` |
| T0860 | texto | Preparar las acuarelas | `Route.kt:91` |
| T0861 | texto | En la mesa | `Route.kt:91` |
| T0862 | texto | Terminar un dibujo | `Route.kt:92` |
| T0863 | texto | Abrir el cuaderno en ese dibujo | `Route.kt:92` |
| T0864 | texto | En el escritorio | `Route.kt:92` |
| T0865 | texto | Manualidades o maquetas | `Route.kt:95` |
| T0866 | texto | Avanzar 15 minutos | `Route.kt:96` |
| T0867 | texto | Sacar los materiales | `Route.kt:96` |
| T0868 | texto | En la mesa de trabajo | `Route.kt:96` |
| T0869 | texto | Armar una parte de la maqueta | `Route.kt:97` |
| T0870 | texto | Abrir la caja de la maqueta | `Route.kt:97` |
| T0871 | texto | En la mesa | `Route.kt:97` |
| T0872 | texto | Terminar lo que empezaste | `Route.kt:98` |
| T0873 | texto | Dejar la pieza a la vista | `Route.kt:98` |
| T0874 | texto | En la mesa | `Route.kt:98` |
| T0875 | texto | Cocinar | `Route.kt:101` |
| T0876 | texto | Cocinar algo simple | `Route.kt:102` |
| T0877 | texto | Reunir los ingredientes | `Route.kt:102` |
| T0878 | texto | En el mesón de la cocina | `Route.kt:102` |
| T0879 | texto | Probar una receta nueva | `Route.kt:103` |
| T0880 | texto | Dejar la receta a la vista | `Route.kt:103` |
| T0881 | texto | En el mesón de la cocina | `Route.kt:103` |
| T0882 | texto | Preparar la comida de mañana | `Route.kt:104` |
| T0883 | texto | Sacar los táper | `Route.kt:104` |
| T0884 | texto | En el mesón de la cocina | `Route.kt:104` |
| T0885 | texto | Ordenar tu pieza | `Route.kt:107` |
| T0886 | texto | Ordenar un cajón | `Route.kt:108` |
| T0887 | texto | Vaciar el cajón sobre la cama | `Route.kt:108` |
| T0888 | texto | Junto al cajón | `Route.kt:108` |
| T0889 | texto | Hacer la cama | `Route.kt:109` |
| T0890 | texto | Estirar las sábanas | `Route.kt:109` |
| T0891 | texto | Junto a la cama | `Route.kt:109` |
| T0892 | texto | Ordenar la ropa | `Route.kt:110` |
| T0893 | texto | Juntar la ropa en el canasto | `Route.kt:110` |
| T0894 | texto | Junto al canasto | `Route.kt:110` |
| T0895 | texto | Meditar | `Route.kt:113` |
| T0896 | texto | Respirar 5 minutos | `Route.kt:114` |
| T0897 | texto | Sentarte en el cojín | `Route.kt:114` |
| T0898 | texto | Junto al cojín | `Route.kt:114` |
| T0899 | texto | Meditar 10 minutos | `Route.kt:115` |
| T0900 | texto | Apagar la luz grande | `Route.kt:115` |
| T0901 | texto | Junto al interruptor | `Route.kt:115` |
| T0902 | texto | Estirar antes de dormir | `Route.kt:116` |
| T0903 | texto | Desenrollar la colchoneta | `Route.kt:116` |
| T0904 | texto | Junto a la cama | `Route.kt:116` |
| T0905 | texto | Estudiar o hacer tareas | `Route.kt:119` |
| T0906 | texto | Estudiar 20 minutos | `Route.kt:120` |
| T0907 | texto | Abrir tus apuntes | `Route.kt:120` |
| T0908 | texto | En el escritorio | `Route.kt:120` |
| T0909 | texto | Hacer una tarea | `Route.kt:121` |
| T0910 | texto | Abrir el cuaderno en la tarea | `Route.kt:121` |
| T0911 | texto | En el escritorio | `Route.kt:121` |
| T0912 | texto | Repasar para una prueba | `Route.kt:122` |
| T0913 | texto | Sacar tus resúmenes | `Route.kt:122` |
| T0914 | texto | En el escritorio | `Route.kt:122` |
| T0915 | texto | Jugar videojuegos | `Route.kt:125` |
| T0916 | texto | Jugar una partida | `Route.kt:126` |
| T0917 | texto | Encender la consola | `Route.kt:126` |
| T0918 | texto | Junto a la tele | `Route.kt:126` |
| T0919 | texto | Avanzar en tu juego | `Route.kt:127` |
| T0920 | texto | Dejar el control cargado | `Route.kt:127` |
| T0921 | texto | Junto a la tele | `Route.kt:127` |
| T0922 | texto | Jugar con alguien | `Route.kt:128` |
| T0923 | texto | Avisar a quien juega contigo | `Route.kt:128` |
| T0924 | texto | Junto al computador | `Route.kt:128` |
| T0925 | texto | Escuchar música | `Route.kt:131` |
| T0926 | texto | Escuchar un disco entero | `Route.kt:132` |
| T0927 | texto | Elegir el disco | `Route.kt:132` |
| T0928 | texto | Junto a los discos | `Route.kt:132` |
| T0929 | texto | Escuchar música sin hacer nada más | `Route.kt:133` |
| T0930 | texto | Ponerte los audífonos | `Route.kt:133` |
| T0931 | texto | En el sillón | `Route.kt:133` |
| T0932 | texto | Tocar una canción | `Route.kt:134` |
| T0933 | texto | Sacar el instrumento | `Route.kt:134` |
| T0934 | texto | Junto al instrumento | `Route.kt:134` |
| T0935 | texto | Ver una película o serie | `Route.kt:137` |
| T0936 | texto | Ver una película | `Route.kt:138` |
| T0937 | texto | Elegir la película | `Route.kt:138` |
| T0938 | texto | Junto a la tele | `Route.kt:138` |
| T0939 | texto | Ver un capítulo con alguien | `Route.kt:139` |
| T0940 | texto | Avisar a quien ve contigo | `Route.kt:139` |
| T0941 | texto | Junto a la tele | `Route.kt:139` |
| T0942 | texto | Ver una película sin el teléfono | `Route.kt:140` |
| T0943 | texto | Dejar el teléfono cargando | `Route.kt:140` |
| T0944 | texto | Junto al cargador | `Route.kt:140` |
| T0945 | texto | Compartir con alguien | `Route.kt:143` |
| T0946 | texto | Comer sin el teléfono | `Route.kt:144` |
| T0947 | texto | Poner la mesa | `Route.kt:144` |
| T0948 | texto | En la mesa del comedor | `Route.kt:144` |
| T0949 | texto | Jugar un juego de mesa | `Route.kt:145` |
| T0950 | texto | Sacar la caja | `Route.kt:145` |
| T0951 | texto | En la mesa | `Route.kt:145` |
| T0952 | texto | Juntarte a jugar a la pelota | `Route.kt:146` |
| T0953 | texto | Preparar las zapatillas | `Route.kt:146` |
| T0954 | texto | Junto a la puerta | `Route.kt:146` |
| T0955 | texto | Llamar a alguien | `Route.kt:148` |
| T0956 | texto | Buscar su número | `Route.kt:148` |
| T0957 | texto | En el sillón | `Route.kt:148` |
| T0958 | texto | Otra actividad | `Route.kt:158` |
| T0959 | texto | En tu pieza | `Route.kt:165` |
| T0960 | texto | En el living | `Route.kt:165` |
| T0961 | texto | En la cocina | `Route.kt:165` |
| T0962 | texto | En el comedor | `Route.kt:165` |
| T0963 | texto | Leer | `Common.kt:53` |
| T0964 | texto | Abrir el libro | `Common.kt:53` |
| T0965 | texto | En el velador | `Common.kt:53` |
| T0966 | texto | Dormir a tiempo | `Common.kt:54` |
| T0967 | texto | Dejar el teléfono cargando lejos | `Common.kt:54` |
| T0968 | texto | Junto al cargador | `Common.kt:54` |
| T0969 | texto | Hacer ejercicio | `Common.kt:55` |
| T0970 | texto | Ponerte ropa cómoda | `Common.kt:55` |
| T0971 | texto | Junto al clóset | `Common.kt:55` |
| T0972 | texto | Pasear al perro | `Common.kt:56` |
| T0973 | texto | Tomar la correa | `Common.kt:56` |
| T0974 | texto | Junto a la puerta | `Common.kt:56` |
| T0975 | texto | Dibujar | `Common.kt:57` |
| T0976 | texto | Sacar el cuaderno y un lápiz | `Common.kt:57` |
| T0977 | texto | En el escritorio | `Common.kt:57` |
| T0978 | texto | Pintar | `Common.kt:58` |
| T0979 | texto | Preparar las acuarelas | `Common.kt:58` |
| T0980 | texto | En la mesa | `Common.kt:58` |
| T0981 | texto | Cocinar | `Common.kt:59` |
| T0982 | texto | Reunir los ingredientes | `Common.kt:59` |
| T0983 | texto | En el mesón de la cocina | `Common.kt:59` |
| T0984 | texto | Estudiar | `Common.kt:60` |
| T0985 | texto | Abrir tus apuntes | `Common.kt:60` |
| T0986 | texto | En el escritorio | `Common.kt:60` |
| T0987 | texto | Ordenar tu pieza | `Common.kt:61` |
| T0988 | texto | Despejar una superficie | `Common.kt:61` |
| T0989 | texto | En el escritorio | `Common.kt:61` |
| T0990 | texto | Hacer manualidades | `Common.kt:62` |
| T0991 | texto | Preparar los materiales | `Common.kt:62` |
| T0992 | texto | En la mesa de trabajo | `Common.kt:62` |
| T0993 | texto | Armar una maqueta | `Common.kt:63` |
| T0994 | texto | Abrir la caja de la maqueta | `Common.kt:63` |
| T0995 | texto | En la mesa | `Common.kt:63` |
| T0996 | texto | Salir en bicicleta | `Common.kt:64` |
| T0997 | texto | Sacar la bici | `Common.kt:64` |
| T0998 | texto | Junto a la puerta | `Common.kt:64` |
| T0999 | texto | Meditar | `Common.kt:65` |
| T1000 | texto | Sentarte en el cojín | `Common.kt:65` |
| T1001 | texto | Junto al cojín | `Common.kt:65` |
| T1002 | texto | Leer manga | `Common.kt:66` |
| T1003 | texto | Sacar el tomo del estante | `Common.kt:66` |
| T1004 | texto | Junto al estante | `Common.kt:66` |
| T1005 | texto | Jugar videojuegos | `Common.kt:68` |
| T1006 | texto | Encender la consola | `Common.kt:68` |
| T1007 | texto | Junto a la tele | `Common.kt:68` |
| T1008 | texto | Escuchar música | `Common.kt:69` |
| T1009 | texto | Ponerte los audífonos | `Common.kt:69` |
| T1010 | texto | En el sillón | `Common.kt:69` |
| T1011 | texto | Ver una película | `Common.kt:70` |
| T1012 | texto | Elegir la película | `Common.kt:70` |
| T1013 | texto | Junto a la tele | `Common.kt:70` |
| T1014 | texto | Llamar a alguien | `Common.kt:71` |
| T1015 | texto | Buscar su número | `Common.kt:71` |
| T1016 | texto | En el sillón | `Common.kt:71` |
| T1017 | texto | Jugar un juego de mesa | `Common.kt:72` |
| T1018 | texto | Sacar la caja | `Common.kt:72` |
| T1019 | texto | En la mesa | `Common.kt:72` |
| T1020 | texto | En el velador | `Common.kt:78` |
| T1021 | texto | En el escritorio | `Common.kt:78` |
| T1022 | texto | En la mesa | `Common.kt:78` |
| T1023 | texto | En el sillón | `Common.kt:78` |
| T1024 | texto | Junto a la cama | `Common.kt:78` |
| T1025 | texto | Junto a la tele | `Common.kt:78` |
| T1026 | texto | En el mesón de la cocina | `Common.kt:78` |
| T1027 | texto | Junto a la puerta | `Common.kt:78` |
| T1028 | texto | Dejar el teléfono en otro lugar | `Common.kt:99` |

## 34 Piezas de la interfaz

219 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T1029 | texto | Nada | `Controls.kt:276` |
| T1030 | texto | Mucho | `Controls.kt:276` |
| T1031 | texto | 1 · [dato] | `Controls.kt:280` |
| T1032 | texto | 5 · [dato] | `Controls.kt:281` |
| T1033 | texto | Restar tiempo | `Controls.kt:341` |
| T1034 | texto | Sumar tiempo | `Controls.kt:343` |
| T1035 | texto | Restar | `Controls.kt:353` |
| T1036 | texto | Sumar | `Controls.kt:355` |
| T1037 | lector de pantalla | Borrar la búsqueda | `Fields.kt:117` |
| T1038 | texto | Vuelve a | `Fields.kt:131` |
| T1039 | texto | Accesibilidad | `KitIcons.kt:13` |
| T1040 | texto | Actividad | `KitIcons.kt:22` |
| T1041 | texto | Advertencia | `KitIcons.kt:30` |
| T1042 | texto | Agregar | `KitIcons.kt:38` |
| T1043 | texto | Ajustes | `KitIcons.kt:44` |
| T1044 | texto | Apps elegidas | `KitIcons.kt:52` |
| T1045 | texto | Avisos del teléfono | `KitIcons.kt:61` |
| T1046 | texto | Ayuda | `KitIcons.kt:70` |
| T1047 | texto | Batería del objeto | `KitIcons.kt:78` |
| T1048 | texto | Andar en bicicleta | `KitIcons.kt:86` |
| T1049 | texto | Borrar | `KitIcons.kt:97` |
| T1050 | texto | Buscar | `KitIcons.kt:106` |
| T1051 | texto | Calendario | `KitIcons.kt:113` |
| T1052 | texto | Cambié de idea | `KitIcons.kt:121` |
| T1053 | texto | Caminar | `KitIcons.kt:130` |
| T1054 | texto | Escribirle a alguien | `KitIcons.kt:138` |
| T1055 | texto | Cerrar sesión | `KitIcons.kt:145` |
| T1056 | texto | Cerrar | `KitIcons.kt:153` |
| T1057 | texto | Cocinar | `KitIcons.kt:159` |
| T1058 | texto | Código de participante | `KitIcons.kt:169` |
| T1059 | texto | Comencé | `KitIcons.kt:175` |
| T1060 | texto | Comentario | `KitIcons.kt:181` |
| T1061 | texto | Conexión | `KitIcons.kt:187` |
| T1062 | texto | Consentimiento | `KitIcons.kt:195` |
| T1063 | texto | Contraer | `KitIcons.kt:203` |
| T1064 | texto | Copiar | `KitIcons.kt:209` |
| T1065 | texto | Datos del estudio | `KitIcons.kt:216` |
| T1066 | texto | Decisión | `KitIcons.kt:224` |
| T1067 | texto | Acceso abierto | `KitIcons.kt:232` |
| T1068 | texto | Descargar | `KitIcons.kt:239` |
| T1069 | texto | La dejé para después | `KitIcons.kt:247` |
| T1070 | texto | Detener | `KitIcons.kt:253` |
| T1071 | texto | Dibujar | `KitIcons.kt:259` |
| T1072 | texto | Dormir | `KitIcons.kt:266` |
| T1073 | texto | Editar | `KitIcons.kt:274` |
| T1074 | texto | Hacer ejercicio | `KitIcons.kt:281` |
| T1075 | texto | Abrir fuera de la app | `KitIcons.kt:287` |
| T1076 | texto | Entrevistas | `KitIcons.kt:295` |
| T1077 | texto | Enviar | `KitIcons.kt:302` |
| T1078 | texto | Error | `KitIcons.kt:309` |
| T1079 | texto | Escribir | `KitIcons.kt:317` |
| T1080 | texto | Esperando | `KitIcons.kt:325` |
| T1081 | texto | Estirar | `KitIcons.kt:333` |
| T1082 | texto | Estrella llena | `KitIcons.kt:342` |
| T1083 | texto | Media estrella | `KitIcons.kt:348` |
| T1084 | texto | Estrella vacía | `KitIcons.kt:355` |
| T1085 | texto | Estudiar | `KitIcons.kt:361` |
| T1086 | texto | Expandir | `KitIcons.kt:369` |
| T1087 | texto | Exportar o compartir | `KitIcons.kt:375` |
| T1088 | texto | Filtrar | `KitIcons.kt:383` |
| T1089 | texto | Fotografiar | `KitIcons.kt:389` |
| T1090 | texto | Tocar un instrumento | `KitIcons.kt:396` |
| T1091 | texto | Hipótesis y prueba | `KitIcons.kt:405` |
| T1092 | texto | Historial | `KitIcons.kt:413` |
| T1093 | texto | Información | `KitIcons.kt:421` |
| T1094 | texto | Inicio | `KitIcons.kt:429` |
| T1095 | texto | Investigación | `KitIcons.kt:436` |
| T1096 | texto | Jugar un juego de mesa | `KitIcons.kt:445` |
| T1097 | texto | Leer | `KitIcons.kt:454` |
| T1098 | texto | Listo | `KitIcons.kt:462` |
| T1099 | texto | Jugar videojuegos | `KitIcons.kt:469` |
| T1100 | texto | Llamar a alguien | `KitIcons.kt:478` |
| T1101 | texto | Lugar | `KitIcons.kt:484` |
| T1102 | texto | Hacer manualidades | `KitIcons.kt:491` |
| T1103 | texto | Más opciones | `KitIcons.kt:499` |
| T1104 | texto | Menú | `KitIcons.kt:507` |
| T1105 | texto | Mostrar | `KitIcons.kt:513` |
| T1106 | texto | Escuchar música | `KitIcons.kt:520` |
| T1107 | texto | Objeto | `KitIcons.kt:528` |
| T1108 | texto | Ocultar | `KitIcons.kt:536` |
| T1109 | texto | Ordenar | `KitIcons.kt:544` |
| T1110 | texto | Parlante | `KitIcons.kt:552` |
| T1111 | texto | Pausar | `KitIcons.kt:560` |
| T1112 | texto | Perfil | `KitIcons.kt:566` |
| T1113 | texto | Permiso | `KitIcons.kt:575` |
| T1114 | texto | Pintar | `KitIcons.kt:583` |
| T1115 | texto | Cuidar las plantas | `KitIcons.kt:591` |
| T1116 | texto | Cómo empieza | `KitIcons.kt:600` |
| T1117 | texto | Privacidad | `KitIcons.kt:606` |
| T1118 | texto | Probar sonido | `KitIcons.kt:613` |
| T1119 | texto | Reportar un problema | `KitIcons.kt:621` |
| T1120 | texto | Reintentar | `KitIcons.kt:630` |
| T1121 | texto | Relevos | `KitIcons.kt:637` |
| T1122 | texto | Reproducir | `KitIcons.kt:646` |
| T1123 | texto | Salir | `KitIcons.kt:652` |
| T1124 | texto | Siguiente | `KitIcons.kt:660` |
| T1125 | texto | Silenciar | `KitIcons.kt:666` |
| T1126 | texto | Sin conexión | `KitIcons.kt:673` |
| T1127 | texto | Sincronizar datos | `KitIcons.kt:680` |
| T1128 | texto | Sistema phygital | `KitIcons.kt:687` |
| T1129 | texto | Este teléfono | `KitIcons.kt:695` |
| T1130 | texto | Tema claro u oscuro | `KitIcons.kt:702` |
| T1131 | texto | Tamaño del texto | `KitIcons.kt:709` |
| T1132 | texto | Tiempo | `KitIcons.kt:716` |
| T1133 | texto | Después de cuánto uso | `KitIcons.kt:723` |
| T1134 | texto | Persona | `KitIcons.kt:732` |
| T1135 | texto | Validación | `KitIcons.kt:739` |
| T1136 | texto | Volver | `KitIcons.kt:746` |
| T1137 | texto | Caminar | `Photos.kt:82` |
| T1138 | texto | Hacer ejercicio | `Photos.kt:83` |
| T1139 | texto | Leer | `Photos.kt:84` |
| T1140 | texto | Estudiar | `Photos.kt:85` |
| T1141 | texto | Dibujar | `Photos.kt:86` |
| T1142 | texto | Cocinar | `Photos.kt:87` |
| T1143 | texto | Ordenar | `Photos.kt:88` |
| T1144 | texto | Salir con el perro | `Photos.kt:89` |
| T1145 | texto | Manualidades | `Photos.kt:90` |
| T1146 | texto | Tocar guitarra | `Photos.kt:91` |
| T1147 | texto | Escribir | `Photos.kt:92` |
| T1148 | texto | Leer un libro | `Photos.kt:93` |
| T1149 | texto | Aprender | `Photos.kt:94` |
| T1150 | texto | Hacer pan | `Photos.kt:95` |
| T1151 | texto | Pintar | `Photos.kt:96` |
| T1152 | texto | Empezar | `Photos.kt:97` |
| T1153 | texto | Salir | `Photos.kt:98` |
| T1154 | texto | El tiempo en el teléfono | `Photos.kt:99` |
| T1155 | texto | Caras | `Photos.kt:106` |
| T1156 | texto | Animales | `Photos.kt:106` |
| T1157 | texto | Naturaleza | `Photos.kt:106` |
| T1158 | texto | Comida | `Photos.kt:106` |
| T1159 | texto | Actividades | `Photos.kt:106` |
| T1160 | texto | Cara sonriente | `Photos.kt:116` |
| T1161 | texto | Cara contenta | `Photos.kt:117` |
| T1162 | texto | Cara con lentes de sol | `Photos.kt:118` |
| T1163 | texto | Cara que abraza | `Photos.kt:119` |
| T1164 | texto | Cara con ojos de estrella | `Photos.kt:120` |
| T1165 | texto | Cara con corazones | `Photos.kt:121` |
| T1166 | texto | Cara de fiesta | `Photos.kt:122` |
| T1167 | texto | Cara pensativa | `Photos.kt:123` |
| T1168 | texto | Cara dormida | `Photos.kt:124` |
| T1169 | texto | Cara con sombrero de vaquero | `Photos.kt:125` |
| T1170 | texto | Robot | `Photos.kt:126` |
| T1171 | texto | Fantasma | `Photos.kt:127` |
| T1172 | texto | Perro | `Photos.kt:129` |
| T1173 | texto | Gato | `Photos.kt:130` |
| T1174 | texto | Zorro | `Photos.kt:131` |
| T1175 | texto | Tortuga | `Photos.kt:132` |
| T1176 | texto | Conejo | `Photos.kt:133` |
| T1177 | texto | Oso | `Photos.kt:134` |
| T1178 | texto | Panda | `Photos.kt:135` |
| T1179 | texto | Koala | `Photos.kt:136` |
| T1180 | texto | Tigre | `Photos.kt:137` |
| T1181 | texto | León | `Photos.kt:138` |
| T1182 | texto | Rana | `Photos.kt:139` |
| T1183 | texto | Pingüino | `Photos.kt:140` |
| T1184 | texto | Búho | `Photos.kt:141` |
| T1185 | texto | Abeja | `Photos.kt:142` |
| T1186 | texto | Mariposa | `Photos.kt:143` |
| T1187 | texto | Pulpo | `Photos.kt:144` |
| T1188 | texto | Ballena | `Photos.kt:145` |
| T1189 | texto | Unicornio | `Photos.kt:146` |
| T1190 | texto | Perezoso | `Photos.kt:147` |
| T1191 | texto | Dinosaurio | `Photos.kt:148` |
| T1192 | texto | Planta | `Photos.kt:150` |
| T1193 | texto | Girasol | `Photos.kt:151` |
| T1194 | texto | Ola | `Photos.kt:152` |
| T1195 | texto | Luna | `Photos.kt:153` |
| T1196 | texto | Sol | `Photos.kt:154` |
| T1197 | texto | Arcoíris | `Photos.kt:155` |
| T1198 | texto | Estrella | `Photos.kt:156` |
| T1199 | texto | Nube | `Photos.kt:157` |
| T1200 | texto | Copo de nieve | `Photos.kt:158` |
| T1201 | texto | Fuego | `Photos.kt:159` |
| T1202 | texto | Cactus | `Photos.kt:160` |
| T1203 | texto | Árbol | `Photos.kt:161` |
| T1204 | texto | Trébol de cuatro hojas | `Photos.kt:162` |
| T1205 | texto | Tulipán | `Photos.kt:163` |
| T1206 | texto | Hongo | `Photos.kt:164` |
| T1207 | texto | Montaña nevada | `Photos.kt:165` |
| T1208 | texto | Planeta con anillo | `Photos.kt:166` |
| T1209 | texto | Taza de café | `Photos.kt:168` |
| T1210 | texto | Pan | `Photos.kt:169` |
| T1211 | texto | Sartén con un huevo | `Photos.kt:170` |
| T1212 | texto | Palta | `Photos.kt:171` |
| T1213 | texto | Frutilla | `Photos.kt:172` |
| T1214 | texto | Sandía | `Photos.kt:173` |
| T1215 | texto | Limón | `Photos.kt:174` |
| T1216 | texto | Pizza | `Photos.kt:175` |
| T1217 | texto | Dona | `Photos.kt:176` |
| T1218 | texto | Helado | `Photos.kt:177` |
| T1219 | texto | Té de burbujas | `Photos.kt:178` |
| T1220 | texto | Zapatilla | `Photos.kt:180` |
| T1221 | texto | Libros | `Photos.kt:181` |
| T1222 | texto | Guitarra | `Photos.kt:182` |
| T1223 | texto | Paleta de pintura | `Photos.kt:183` |
| T1224 | texto | Ovillo de lana | `Photos.kt:184` |
| T1225 | texto | Bicicleta | `Photos.kt:185` |
| T1226 | texto | Cámara | `Photos.kt:186` |
| T1227 | texto | Audífonos | `Photos.kt:187` |
| T1228 | texto | Lápiz | `Photos.kt:188` |
| T1229 | texto | Pieza de rompecabezas | `Photos.kt:189` |
| T1230 | texto | Teclado de piano | `Photos.kt:190` |
| T1231 | texto | Pelota | `Photos.kt:191` |
| T1232 | texto | Pelota de básquetbol | `Photos.kt:192` |
| T1233 | texto | Raqueta de tenis | `Photos.kt:193` |
| T1234 | texto | Skate | `Photos.kt:194` |
| T1235 | texto | Dado | `Photos.kt:195` |
| T1236 | texto | Peón de ajedrez | `Photos.kt:196` |
| T1237 | texto | Control de videojuegos | `Photos.kt:197` |
| T1238 | texto | Volantín | `Photos.kt:198` |
| T1239 | texto | Micrófono | `Photos.kt:199` |
| T1240 | texto | Violín | `Photos.kt:200` |
| T1241 | texto | Telescopio | `Photos.kt:201` |
| T1242 | texto | Carpa | `Photos.kt:202` |
| T1243 | texto | Cohete | `Photos.kt:203` |
| T1244 | texto | Volver | `Screen.kt:99` |
| T1245 | texto | Inicio | `RelevoApp.kt:86` |
| T1246 | texto | Ruta | `RelevoApp.kt:87` |
| T1247 | texto | Perfil | `RelevoApp.kt:88` |

## Registro de cambios (disclaimer)

### 2026-10-24 — Creación

- **Qué cambió:** se creó el inventario, generado desde el código.
- **Cómo estaba antes:** los textos solo estaban dentro del código Kotlin.
- **Por qué:** el autor pidió estudiar y documentar cada palabra de la app antes de actualizar los textos.
