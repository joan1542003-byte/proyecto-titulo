# Inventario de textos de la app

> Se genera con `node extraer-textos.js` desde el código de la app. Para cambiar un texto se cambia el código y se vuelve a generar. Los datos variables van entre corchetes, como [nombre] o [duración].

**Total:** 1221 textos, 5201 palabras, en 34 pantallas o grupos.


## 01 Bienvenida

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0001 | botón | Empezar | `FirstRunScreens.kt:78` |
| T0002 | lector de pantalla | Relevo | `FirstRunScreens.kt:81` |
| T0003 | texto | Anota algo que quieres hacer | `FirstRunScreens.kt:85` |
| T0004 | texto | Cuando llevas un rato en el teléfono, suena donde empiezas. | `FirstRunScreens.kt:87` |
| T0005 | texto | Leer | `FirstRunScreens.kt:94` |
| T0006 | fila | Abrir el libro | `FirstRunScreens.kt:97` |
| T0007 | fila | En el velador | `FirstRunScreens.kt:98` |

## 02 Cómo funciona (guía de la primera vez)

30 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0008 | texto | Entendido | `HowItWorksScreen.kt:93` |
| T0009 | guía | Esto es Relevo | `HowItWorksScreen.kt:103` |
| T0010 | guía | ¿Te ha pasado? | `HowItWorksScreen.kt:106` |
| T0011 | guía | Relevo suena a tiempo, donde empiezas, para que no quede esperando. | `HowItWorksScreen.kt:106` |
| T0012 | texto | Abres una app para descansar. | `HowItWorksScreen.kt:110` |
| T0013 | texto | Se pasa el rato y lo que querías hacer queda esperando. | `HowItWorksScreen.kt:112` |
| T0014 | guía | Cómo funciona | `HowItWorksScreen.kt:115` |
| T0015 | fila | Cuenta tu tiempo | `HowItWorksScreen.kt:118` |
| T0016 | subtítulo | En las apps que eliges | `HowItWorksScreen.kt:118` |
| T0017 | fila | Te recuerda cómo empezar | `HowItWorksScreen.kt:119` |
| T0018 | subtítulo | Algo pequeño, de segundos | `HowItWorksScreen.kt:119` |
| T0019 | fila | Suena donde empiezas | `HowItWorksScreen.kt:120` |
| T0020 | subtítulo | En el Tag, el parlante o el reloj | `HowItWorksScreen.kt:120` |
| T0021 | fila | Tú decides | `HowItWorksScreen.kt:121` |
| T0022 | subtítulo | Empezar, dejarlo o cambiar de idea | `HowItWorksScreen.kt:121` |
| T0023 | guía | Una última pregunta | `HowItWorksScreen.kt:124` |
| T0024 | guía | Si pasas una semana sin abrir Relevo, ¿quieres que te avise una vez? Puedes apagarlo cuando quieras. | `HowItWorksScreen.kt:124` |
| T0025 | etiqueta | Relevo | `HowItWorksScreen.kt:126` |
| T0026 | etiqueta | ¿Quieres preparar un relevo esta semana? | `HowItWorksScreen.kt:128` |
| T0027 | acción | Saltar | `HowItWorksScreen.kt:145` |
| T0028 | botón | Seguir | `HowItWorksScreen.kt:148` |
| T0029 | botón | Sí, avísame | `HowItWorksScreen.kt:151` |
| T0030 | botón | No, gracias | `HowItWorksScreen.kt:152` |
| T0031 | lector de pantalla | Video de 30 segundos que explica Relevo. Tócalo para [dato]. | `HowItWorksScreen.kt:253` |
| T0032 | texto | Activar el sonido | `HowItWorksScreen.kt:281` |
| T0033 | texto | Quitar el sonido | `HowItWorksScreen.kt:281` |
| T0034 | texto | Ver de nuevo | `HowItWorksScreen.kt:287` |
| T0035 | texto | Pausar | `HowItWorksScreen.kt:287` |
| T0036 | texto | Reproducir | `HowItWorksScreen.kt:287` |
| T0037 | botón | Entendido | `RelevoApp.kt:291` |

## 03 Antes de empezar (consentimiento)

31 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0038 | título | Antes de empezar | `FirstRunScreens.kt:121` |
| T0039 | subtítulo | Lee lo que aceptas. Puedes salir cuando quieras. | `FirstRunScreens.kt:122` |
| T0040 | texto | Acepto participar durante 21 días. | `FirstRunScreens.kt:134` |
| T0041 | botón | Aceptar y empezar | `FirstRunScreens.kt:136` |
| T0042 | validación | Espera a que terminemos de borrar tus datos. | `FirstRunScreens.kt:137` |
| T0043 | validación | Marca «Acepto participar durante 21 días» para seguir. | `FirstRunScreens.kt:138` |
| T0044 | texto | Ocultar | `FirstRunScreens.kt:142` |
| T0045 | texto | No quiero participar | `FirstRunScreens.kt:142` |
| T0046 | texto | Está bien. Relevo solo se puede usar dentro de esta prueba, así que puedes cerrar la app y desinstalarla. No se guardó nada tuyo. | `FirstRunScreens.kt:145` |
| T0047 | texto | Relevo es parte de un proyecto de título de Diseño. Por 21 días lo usas en tu día a día: cada semana te decimos dónde dejar lo que suena y, de vez en cuando, te hacemos preguntas cortas. Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte. Puedes salir y borrar tus datos cuando quieras. | `FirstRunScreens.kt:152` |
| T0048 | aviso | Todavía estamos borrando tus datos. Mientras tanto, Relevo no guarda nada. | `FirstRunScreens.kt:159` |
| T0049 | acción | Abrir Privacidad y datos | `FirstRunScreens.kt:160` |
| T0050 | texto | Cómo es | `FirstRunScreens.kt:170` |
| T0051 | texto | Empieza con un encuentro de unos 45 minutos para dejar todo listo. Cada semana la app te dice dónde suena: junto a donde empiezas, en otro lugar de tu casa o en el teléfono. Tú eliges si usas un parlante, un reloj o un Tag. Cuando se cumple el tiempo que elegiste, suena unos 30 segundos y se apaga. Después de cada aviso y al final de cada semana hay preguntas de un toque; puedes saltarlas. Al final te invitamos a conversar unos 15 minutos. El parlante es provisorio; no es el objeto final. | `FirstRunScreens.kt:170` |
| T0052 | texto | Tú decides | `FirstRunScreens.kt:171` |
| T0053 | texto | Participar es voluntario. Puedes saltar preguntas, silenciar el sonido, quitar los permisos o salir cuando quieras, sin dar explicaciones. Nadie va a juzgar lo que elijas hacer. El sonido puede molestar a otras personas; puedes detenerlo y contárnoslo. | `FirstRunScreens.kt:171` |
| T0054 | texto | Qué guardamos | `FirstRunScreens.kt:172` |
| T0055 | texto | Un código al azar; lo que preparas (actividad, cómo empiezas, dónde, apps y tiempo); cuándo lo activas, a mano o solo, cuándo suena y qué respondes; cuánto usaste las apps elegidas 10 minutos antes y después del aviso; cuánto usas cada día las apps que elegiste en Relevo y cuánto tiempo usas el teléfono en total, desde 7 días antes de aceptar; el modelo del teléfono y los permisos que diste; y cómo usas Relevo: cuándo lo abres y por cuánto tiempo, qué pantallas ves, cuánto del video ves, tus intereses, tus actividades y los ajustes que cambias. Tu nombre se guarda aparte, solo con tu código, para saber quién participa; no va junto a lo que haces en Relevo. | `FirstRunScreens.kt:172` |
| T0056 | texto | Dónde se guarda | `FirstRunScreens.kt:173` |
| T0057 | texto | En el teléfono y en la base de datos del proyecto (Supabase). Si no hay internet, se envía después. También queda una copia sin tu nombre en la carpeta Documentos/Relevo del teléfono; se borra si borras tus datos. | `FirstRunScreens.kt:173` |
| T0058 | texto | Esta instalación no tiene configurada la base remota: todo queda en este teléfono. | `FirstRunScreens.kt:174` |
| T0059 | texto | Qué no vemos | `FirstRunScreens.kt:175` |
| T0060 | texto | El permiso de Tiempo de uso podría mostrar el uso de otras apps. Relevo cuenta las que eliges mientras el relevo está activo y, cada día, cuánto las usas y el tiempo total del teléfono; de las demás apps no guarda el nombre. Si enciendes la activación automática, además mira qué app tienes abierta —solo su nombre— para saber cuándo empezar; puedes apagarla cuando quieras. No lee mensajes, fotos, búsquedas ni lo que hay en tu pantalla. | `FirstRunScreens.kt:175` |
| T0061 | texto | Mensajes | `FirstRunScreens.kt:176` |
| T0062 | texto | El investigador puede enviarte mensajes sobre el testeo; llegan como notificación de Relevo. Guardamos cuándo llegó y cuándo abriste cada uno. | `FirstRunScreens.kt:176` |
| T0063 | texto | Tu código | `FirstRunScreens.kt:177` |
| T0064 | texto | El código reemplaza tu nombre, pero no vuelve anónimos los datos: juntando actividades, lugares y horarios, alguien podría reconocerte. | `FirstRunScreens.kt:177` |
| T0065 | texto | Hasta cuándo | `FirstRunScreens.kt:178` |
| T0066 | texto | Puedes borrar tus datos desde Perfil, en Tus datos, o escribiendo a [correo del investigador] con tu código. Si no lo haces antes, los borramos a más tardar el 30 de diciembre de 2026. | `FirstRunScreens.kt:178` |
| T0067 | texto | Ocultar | `FirstRunScreens.kt:189` |
| T0068 | texto | Leer | `FirstRunScreens.kt:189` |

## 04 Para saber cuándo avisarte (permisos de la primera vez)

13 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0069 | título | Para saber cuándo avisarte | `FirstRunScreens.kt:243` |
| T0070 | subtítulo | Relevo solo cuenta minutos en las apps que elijas. No ve lo que haces en ellas. | `FirstRunScreens.kt:244` |
| T0071 | botón | Seguir | `FirstRunScreens.kt:246` |
| T0072 | botón | Dar el permiso | `FirstRunScreens.kt:247` |
| T0073 | texto | Tiempo de uso | `FirstRunScreens.kt:252` |
| T0074 | subtítulo | Necesario. En Android: Acceso a datos de uso | `FirstRunScreens.kt:252` |
| T0075 | texto | Dar el permiso | `FirstRunScreens.kt:254` |
| T0076 | texto | Notificaciones | `FirstRunScreens.kt:257` |
| T0077 | subtítulo | Para avisarte aunque estés en otra app | `FirstRunScreens.kt:257` |
| T0078 | texto | Activar | `FirstRunScreens.kt:259` |
| T0079 | texto | Batería | `FirstRunScreens.kt:262` |
| T0080 | subtítulo | Para que siga contando aunque pasen días | `FirstRunScreens.kt:262` |
| T0081 | texto | Activar | `FirstRunScreens.kt:264` |

## 05 Tu perfil (primera vez)

18 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0082 | texto | ¿Cómo te llamas? | `ProfileScreens.kt:206` |
| T0083 | texto | ¿Con qué te identificas? | `ProfileScreens.kt:206` |
| T0084 | texto | ¿Qué te gustaría hacer más seguido? | `ProfileScreens.kt:206` |
| T0085 | acción | Saltar | `ProfileScreens.kt:211` |
| T0086 | botón | Seguir | `ProfileScreens.kt:214` |
| T0087 | validación | Escribe tu nombre. | `ProfileScreens.kt:214` |
| T0088 | botón | Seguir | `ProfileScreens.kt:215` |
| T0089 | validación | Elige uno o salta este paso. | `ProfileScreens.kt:215` |
| T0090 | botón | Listo | `ProfileScreens.kt:216` |
| T0091 | validación | Elige al menos uno o salta este paso. | `ProfileScreens.kt:217` |
| T0092 | validación | Escribe cuál es tu otro interés. | `ProfileScreens.kt:218` |
| T0093 | campo | Tu nombre | `ProfileScreens.kt:238` |
| T0094 | ayuda del campo | Tu nombre o como te dicen | `ProfileScreens.kt:238` |
| T0095 | texto | Se guarda con tu código, aparte de lo que haces en Relevo. | `ProfileScreens.kt:241` |
| T0096 | texto | Elige una o varias. | `ProfileScreens.kt:249` |
| T0097 | opción rápida | Otra | `ProfileScreens.kt:297` |
| T0098 | campo | ¿Cuál? | `ProfileScreens.kt:301` |
| T0099 | ayuda del campo | Ej.: tejer | `ProfileScreens.kt:301` |

## 06 Tu primer relevo

4 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0100 | título | Tu primer relevo | `HowItWorksScreen.kt:189` |
| T0101 | botón | Preparar un relevo | `HowItWorksScreen.kt:192` |
| T0102 | botón | Lo hago después | `HowItWorksScreen.kt:193` |
| T0103 | texto | Tu actividad | `HowItWorksScreen.kt:199` |

## 07 Inicio

73 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0104 | texto | Muy mal | `Feedback.kt:50` |
| T0105 | texto | Mal | `Feedback.kt:51` |
| T0106 | texto | Normal | `Feedback.kt:52` |
| T0107 | texto | Bien | `Feedback.kt:53` |
| T0108 | texto | Muy bien | `Feedback.kt:54` |
| T0109 | texto | ¿Qué tal te va con Relevo? | `Feedback.kt:90` |
| T0110 | acción | Escribir un comentario | `Feedback.kt:94` |
| T0111 | acción | Ahora no | `Feedback.kt:95` |
| T0112 | texto | Para que Relevo siga contando aunque pasen días. | `HomeScreen.kt:108` |
| T0113 | texto | Hola de nuevo, [nombre] | `HomeScreen.kt:153` |
| T0114 | texto | Hola de nuevo | `HomeScreen.kt:154` |
| T0115 | texto | Hola, [nombre] | `HomeScreen.kt:155` |
| T0116 | texto | Hola | `HomeScreen.kt:156` |
| T0117 | texto | Inicio | `HomeScreen.kt:160` |
| T0118 | texto | Al abrir [apps elegidas], empieza a contar «[actividad]». | `HomeScreen.kt:165` |
| T0119 | título | Se activa solo | `HomeScreen.kt:166` |
| T0120 | acción | Apagar | `HomeScreen.kt:167` |
| T0121 | aviso | Falta el permiso de Tiempo de uso. | `HomeScreen.kt:177` |
| T0122 | título | Relevo no puede contar | `HomeScreen.kt:177` |
| T0123 | acción | Dar el permiso | `HomeScreen.kt:178` |
| T0124 | título | Batería | `HomeScreen.kt:183` |
| T0125 | acción | Quitar la restricción | `HomeScreen.kt:184` |
| T0126 | texto | Tu paso en [lugar] | `HomeScreen.kt:219` |
| T0127 | botón | Preparar un relevo | `HomeScreen.kt:223` |
| T0128 | acción | Elegir otra | `HomeScreen.kt:224` |
| T0129 | subtítulo | Repetir el último · [duración] | `HomeScreen.kt:231` |
| T0130 | texto | Tu último relevo | `HomeScreen.kt:242` |
| T0131 | botón | Preparar de nuevo | `HomeScreen.kt:245` |
| T0132 | acción | Elegir otra | `HomeScreen.kt:246` |
| T0133 | botón | Preparar un relevo | `HomeScreen.kt:249` |
| T0134 | texto | Tu semana | `HomeScreen.kt:320` |
| T0135 | texto | Aquí verás lo que hagas esta semana. | `HomeScreen.kt:329` |
| T0136 | texto | Elegiste [dato] por semana. | `HomeScreen.kt:342` |
| T0137 | rótulo | Tus actividades | `HomeScreen.kt:355` |
| T0138 | rótulo | Ver todas | `HomeScreen.kt:355` |
| T0139 | texto | Preparar «[nombre]» | `HomeScreen.kt:362` |
| T0140 | texto | Nueva | `HomeScreen.kt:365` |
| T0141 | texto | Cuando termine tu relevo, podrás preparar otra. | `HomeScreen.kt:369` |
| T0142 | texto | Guarda lo que haces seguido y prepáralo en un toque. | `HomeScreen.kt:373` |
| T0143 | acción | Ver ideas | `HomeScreen.kt:374` |
| T0144 | texto | ¿Cambias este paso por otra actividad? | `HomeScreen.kt:403` |
| T0145 | botón | Cambiar | `HomeScreen.kt:405` |
| T0146 | acción | Ahora no | `HomeScreen.kt:406` |
| T0147 | texto | Contando | `HomeScreen.kt:425` |
| T0148 | texto | En pausa | `HomeScreen.kt:425` |
| T0149 | texto | Suena | `HomeScreen.kt:425` |
| T0150 | texto | Ver tu relevo | `HomeScreen.kt:426` |
| T0151 | texto | Faltan [duración] | `HomeScreen.kt:433` |
| T0152 | texto | La última vez | `HomeScreen.kt:461` |
| T0153 | botón | Preparar de nuevo | `HomeScreen.kt:463` |
| T0154 | acción | Elegir otra | `HomeScreen.kt:465` |
| T0155 | acción | Ahora no | `HomeScreen.kt:467` |
| T0156 | tarjeta | Hoy | `StudyScreens.kt:54` |
| T0157 | tarjeta | Tu primer relevo | `StudyScreens.kt:54` |
| T0158 | tarjeta | Prepáralo con calma. Deja el parlante, el reloj o el Tag junto a lo que usas para empezar. | `StudyScreens.kt:54` |
| T0159 | tarjeta | Esta semana | `StudyScreens.kt:57` |
| T0160 | acción | Entendido | `StudyScreens.kt:58` |
| T0161 | tarjeta | Antes de esta semana | `StudyScreens.kt:63` |
| T0162 | tarjeta | ¿Cómo te fue hasta ahora? | `StudyScreens.kt:63` |
| T0163 | tarjeta | Tres preguntas de un toque sobre las semanas anteriores, con el objeto que ya usabas. | `StudyScreens.kt:63` |
| T0164 | acción | Responder | `StudyScreens.kt:64` |
| T0165 | tarjeta | Tu semana | `StudyScreens.kt:67` |
| T0166 | tarjeta | ¿Cómo te fue esta semana? | `StudyScreens.kt:67` |
| T0167 | tarjeta | Cuatro preguntas de un toque. | `StudyScreens.kt:67` |
| T0168 | tarjeta | Tres preguntas de un toque. | `StudyScreens.kt:67` |
| T0169 | acción | Responder | `StudyScreens.kt:68` |
| T0170 | tarjeta | Cierre | `StudyScreens.kt:73` |
| T0171 | tarjeta | Día 21 | `StudyScreens.kt:73` |
| T0172 | tarjeta | Terminaste la prueba. Gracias. | `StudyScreens.kt:73` |
| T0173 | tarjeta | ¡Llegaste al día 21! Gracias. | `StudyScreens.kt:73` |
| T0174 | texto | Siete preguntas cortas, unos 3 minutos. | `StudyScreens.kt:73` |
| T0175 | texto | Cinco preguntas cortas, unos 2 minutos. | `StudyScreens.kt:73` |
| T0176 | acción | Responder | `StudyScreens.kt:74` |

## 08 Preparar un relevo

116 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0177 | texto | pila al [dato] %, cámbiala pronto | `TagProtocol.kt:39` |
| T0178 | texto | pila al [dato] % | `TagProtocol.kt:39` |
| T0179 | texto | Muy cerca | `TagProtocol.kt:84` |
| T0180 | texto | Cerca | `TagProtocol.kt:85` |
| T0181 | texto | Lejos | `TagProtocol.kt:86` |
| T0182 | texto | ¿Qué quieres hacer? | `PrepareScreen.kt:117` |
| T0183 | texto | ¿Cuándo suena? | `PrepareScreen.kt:120` |
| T0184 | texto | ¿Dónde suena? | `PrepareScreen.kt:121` |
| T0185 | texto | Todo listo | `PrepareScreen.kt:122` |
| T0186 | texto | ¿Dónde dejas lo que suena? | `PrepareScreen.kt:127` |
| T0187 | validación | Escribe qué quieres hacer o elige una idea. | `PrepareScreen.kt:162` |
| T0188 | validación | Escribe cómo empiezas la actividad: lo primero que harías. | `PrepareScreen.kt:163` |
| T0189 | validación | Escribe dónde dejas lo que suena. | `PrepareScreen.kt:165` |
| T0190 | validación | Escribe en qué lugar empieza. | `PrepareScreen.kt:165` |
| T0191 | texto | Da el permiso de Tiempo de uso. | `PrepareScreen.kt:167` |
| T0192 | validación | Elige al menos una app que cuente. | `PrepareScreen.kt:168` |
| T0193 | validación | Elige dónde quieres que suene. | `PrepareScreen.kt:172` |
| T0194 | validación | Busca y elige tu Tag, o elige otra forma de avisar. | `PrepareScreen.kt:173` |
| T0195 | validación | Falta el permiso de Tiempo de uso. | `PrepareScreen.kt:177` |
| T0196 | validación | Falta elegir dónde suena. | `PrepareScreen.kt:178` |
| T0197 | validación | Falta elegir el Tag. | `PrepareScreen.kt:179` |
| T0198 | validación | Falta qué quieres hacer. | `PrepareScreen.kt:180` |
| T0199 | validación | Falta cómo empiezas la actividad. | `PrepareScreen.kt:181` |
| T0200 | validación | Falta en qué lugar empieza. | `PrepareScreen.kt:182` |
| T0201 | validación | Faltan las apps que cuentan. | `PrepareScreen.kt:183` |
| T0202 | texto | Cerrar | `PrepareScreen.kt:254` |
| T0203 | texto | Volver | `PrepareScreen.kt:254` |
| T0204 | texto | Guardar y activar | `PrepareScreen.kt:263` |
| T0205 | texto | Activar el relevo | `PrepareScreen.kt:263` |
| T0206 | texto | Listo | `PrepareScreen.kt:271` |
| T0207 | texto | Seguir | `PrepareScreen.kt:271` |
| T0208 | ayuda del campo | Algo que tome segundos | `PrepareScreen.kt:291` |
| T0209 | texto | Estás editando tu relevo. Al guardarlo vuelve a contar, con el tiempo que llevabas si las apps son las mismas. | `PrepareScreen.kt:298` |
| T0210 | texto | Guardar en tus actividades para la próxima vez | `PrepareScreen.kt:322` |
| T0211 | título | Batería | `PrepareScreen.kt:327` |
| T0212 | acción | Quitar la restricción | `PrepareScreen.kt:328` |
| T0213 | subtítulo | Tu actividad | `PrepareScreen.kt:344` |
| T0214 | ayuda del campo | Ej.: leer 10 páginas | `PrepareScreen.kt:354` |
| T0215 | texto | Tus pasos | `PrepareScreen.kt:357` |
| T0216 | texto | Tus actividades | `PrepareScreen.kt:362` |
| T0217 | ayuda del campo | Ej.: en el velador | `PrepareScreen.kt:413` |
| T0218 | aviso | Relevo necesita el permiso de Tiempo de uso para contar. | `PrepareScreen.kt:433` |
| T0219 | título | Falta un permiso | `PrepareScreen.kt:433` |
| T0220 | acción | Dar el permiso | `PrepareScreen.kt:434` |
| T0221 | validación | Elige las apps | `PrepareScreen.kt:440` |
| T0222 | subtítulo | Apps que cuentan | `PrepareScreen.kt:441` |
| T0223 | texto | Después de [duración] | `PrepareScreen.kt:451` |
| T0224 | texto | Sumando las [número de apps] apps | `PrepareScreen.kt:452` |
| T0225 | texto | En esas apps | `PrepareScreen.kt:452` |
| T0226 | acción | Probar con 15 segundos | `PrepareScreen.kt:462` |
| T0227 | subtítulo | El lugar donde empiezas | `PrepareScreen.kt:478` |
| T0228 | texto | Esta semana suena en el teléfono. | `PrepareScreen.kt:484` |
| T0229 | texto | Esta semana suena donde empiezas. Elige con qué: el parlante, el reloj o el Tag. | `PrepareScreen.kt:485` |
| T0230 | texto | Esta semana suena en otro lugar de tu casa. Elige con qué: el parlante, el reloj o el Tag. | `PrepareScreen.kt:486` |
| T0231 | opción | En tu Tag | `PrepareScreen.kt:493` |
| T0232 | opción | En el parlante | `PrepareScreen.kt:495` |
| T0233 | texto | Conectado por Bluetooth | `PrepareScreen.kt:496` |
| T0234 | texto | Sin parlante conectado | `PrepareScreen.kt:496` |
| T0235 | opción | En el reloj | `PrepareScreen.kt:497` |
| T0236 | texto | Suena como una llamada | `PrepareScreen.kt:498` |
| T0237 | texto | Sin reloj conectado para llamadas | `PrepareScreen.kt:498` |
| T0238 | opción | En el teléfono | `PrepareScreen.kt:499` |
| T0239 | subtítulo | Suena donde esté el teléfono | `PrepareScreen.kt:500` |
| T0240 | botón | Probar el sonido | `PrepareScreen.kt:511` |
| T0241 | texto | Sonó | `PrepareScreen.kt:515` |
| T0242 | texto | en el | `PrepareScreen.kt:515` |
| T0243 | texto | Si tu parlante se apaga solo, no sonará. | `PrepareScreen.kt:521` |
| T0244 | texto | Deja el reloj donde empiezas, con las llamadas por Bluetooth activadas. | `PrepareScreen.kt:525` |
| T0245 | texto | Un Tag que pita | `PrepareScreen.kt:533` |
| T0246 | validación | Falta el permiso de dispositivos cercanos. | `PrepareScreen.kt:540` |
| T0247 | texto | El Bluetooth del teléfono está apagado. | `PrepareScreen.kt:541` |
| T0248 | texto | Ese aparato no acepta la orden para pitar: no es un Tag compatible. | `PrepareScreen.kt:542` |
| T0249 | texto | No lo encontramos. Revisa que esté encendido y cerca, y que ninguna otra app, como iSearching, esté conectada a él: acepta una conexión a la vez. | `PrepareScreen.kt:543` |
| T0250 | texto | Buscar mi Tag | `PrepareScreen.kt:571` |
| T0251 | texto | Entendido | `PrepareScreen.kt:571` |
| T0252 | aviso | Relevo necesita el permiso de dispositivos cercanos para encontrar el Tag. Solo lo usa para eso. | `PrepareScreen.kt:592` |
| T0253 | título | Falta un permiso | `PrepareScreen.kt:592` |
| T0254 | acción | Abrir los ajustes de Relevo | `PrepareScreen.kt:593` |
| T0255 | aviso | Enciende el Bluetooth del teléfono para encontrar el Tag. | `PrepareScreen.kt:607` |
| T0256 | título | Bluetooth apagado | `PrepareScreen.kt:607` |
| T0257 | acción | Encender Bluetooth | `PrepareScreen.kt:608` |
| T0258 | texto | Buscando Tags cerca. Si el tuyo está apagado, mantén apretado su botón 3 segundos, hasta que pite dos veces. | `PrepareScreen.kt:617` |
| T0259 | texto | Enciende el Tag: mantén apretado su botón 3 segundos, hasta que pite dos veces. Después elige el tuyo en la lista. | `PrepareScreen.kt:618` |
| T0260 | acción | Cómo usar el Tag | `PrepareScreen.kt:622` |
| T0261 | texto | Buscando… | `PrepareScreen.kt:625` |
| T0262 | texto | Buscar de nuevo | `PrepareScreen.kt:625` |
| T0263 | texto | Buscar el Tag | `PrepareScreen.kt:625` |
| T0264 | texto | Para buscarlo, Android te pedirá permiso para encontrar dispositivos cercanos. Relevo solo recuerda el Tag que elijas, en este teléfono; no usa tu ubicación. | `PrepareScreen.kt:631` |
| T0265 | texto | Aparatos cerca | `PrepareScreen.kt:638` |
| T0266 | texto | Tags cerca | `PrepareScreen.kt:638` |
| T0267 | texto | Si es compatible, pita una vez al elegirlo. | `PrepareScreen.kt:639` |
| T0268 | texto | Al elegirlo, pita una vez para confirmarlo. | `PrepareScreen.kt:639` |
| T0269 | texto | No apareció ningún aparato con Bluetooth cerca. Revisa que el Tag esté encendido y cerca del teléfono, y búscalo de nuevo. | `PrepareScreen.kt:648` |
| T0270 | texto | No apareció ningún Tag. Revisa que esté encendido y cerca del teléfono, y búscalo de nuevo. Si lo usa otra app, como iSearching, ciérrala: el Tag acepta una conexión a la vez. | `PrepareScreen.kt:649` |
| T0271 | acción | Ver todos los aparatos cercanos | `PrepareScreen.kt:652` |
| T0272 | aviso | Ese aparato no aceptó la orden para pitar: no es un Tag compatible. Búscalo de nuevo y elige otro. | `PrepareScreen.kt:657` |
| T0273 | texto | Probando de otra forma… | `PrepareScreen.kt:663` |
| T0274 | texto | Probando… | `PrepareScreen.kt:664` |
| T0275 | texto | Probar el Tag | `PrepareScreen.kt:665` |
| T0276 | texto | Sonó. Al cumplirse el tiempo, pita hasta 30 segundos. | `PrepareScreen.kt:679` |
| T0277 | texto | Un toque a su botón lo calla; mantenerlo apretado lo apaga. | `PrepareScreen.kt:680` |
| T0278 | texto | Este Tag mantiene su alarma de alejamiento: si el teléfono se aleja mucho mientras espera, puede pitar solo. Para callarlo, tócalo una vez. | `PrepareScreen.kt:682` |
| T0279 | texto | Recibió la orden, pero no pitó. Apágalo y vuelve a encenderlo: mantén su botón apretado 3 segundos hasta que pite largo, y otra vez hasta que pite dos veces. Después pruébalo de nuevo. Si sigue sin pitar, elige otra salida. | `PrepareScreen.kt:686` |
| T0280 | título | El Tag no pitó | `PrepareScreen.kt:687` |
| T0281 | título | No sonó en el Tag | `PrepareScreen.kt:689` |
| T0282 | acción | Cómo usar el Tag | `PrepareScreen.kt:693` |
| T0283 | acción | Elegir otro Tag | `PrepareScreen.kt:695` |
| T0284 | texto | Déjalo encendido donde empiezas. Relevo se conecta a él al activar el relevo y lo mantiene así hasta que suene. | `PrepareScreen.kt:698` |
| T0285 | texto | ¿Lo escuchaste pitar? | `PrepareScreen.kt:710` |
| T0286 | texto | Lo probamos de otra forma. Debió pitar 3 segundos seguidos. | `PrepareScreen.kt:712` |
| T0287 | texto | Debió pitar 3 segundos seguidos. | `PrepareScreen.kt:712` |
| T0288 | botón | Sí, pitó | `PrepareScreen.kt:716` |
| T0289 | botón | No pitó | `PrepareScreen.kt:717` |
| T0290 | título | Elige las apps | `PrepareScreen.kt:754` |
| T0291 | botón | Listo | `PrepareScreen.kt:754` |
| T0292 | campo | Buscar | `PrepareScreen.kt:755` |

## 09 Cómo usar el Tag

29 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0293 | guía del Tag | Este es tu Tag | `TagGuide.kt:64` |
| T0294 | guía del Tag | Es redondo y su botón no se ve: es el centro de la cara de arriba. Al apretarlo firme se siente un clic. Relevo lo hace sonar por Bluetooth. | `TagGuide.kt:64` |
| T0295 | texto | El centro es el botón | `TagGuide.kt:64` |
| T0296 | guía del Tag | Enciéndelo | `TagGuide.kt:65` |
| T0297 | guía del Tag | Mantén apretado el botón 3 segundos, hasta que pite dos veces. Queda encendido: no hay que hacerlo cada vez. | `TagGuide.kt:65` |
| T0298 | guía del Tag | 3 segundos · pita dos veces | `TagGuide.kt:65` |
| T0299 | guía del Tag | Búscalo en Relevo | `TagGuide.kt:66` |
| T0300 | guía del Tag | Ten el Tag cerca del teléfono y elígelo cuando aparezca en la lista. Pita una vez para confirmarlo. | `TagGuide.kt:66` |
| T0301 | guía del Tag | Cerca del teléfono | `TagGuide.kt:66` |
| T0302 | guía del Tag | Déjalo en su lugar | `TagGuide.kt:67` |
| T0303 | guía del Tag | Ponlo donde te indica Relevo esta semana. Sonará cuando sumes el tiempo que elegiste en tus apps. | `TagGuide.kt:67` |
| T0304 | guía del Tag | Donde te indica la semana | `TagGuide.kt:67` |
| T0305 | guía del Tag | Para callarlo, un toque | `TagGuide.kt:68` |
| T0306 | guía del Tag | Cuando suene, toca el botón una vez. No lo mantengas apretado: así se apaga. | `TagGuide.kt:68` |
| T0307 | guía del Tag | Un toque | `TagGuide.kt:68` |
| T0308 | guía del Tag | Para apagarlo | `TagGuide.kt:69` |
| T0309 | guía del Tag | Mantén apretado el botón 3 segundos, hasta que dé un pitido largo. Durante la prueba, mejor déjalo encendido. | `TagGuide.kt:69` |
| T0310 | texto | 3 segundos · pitido largo | `TagGuide.kt:69` |
| T0311 | guía del Tag | La pila dura meses | `TagGuide.kt:70` |
| T0312 | guía del Tag | Usa una pila de botón CR2032. Para cambiarla, abre la tapa por la ranura del borde con una uña o una moneda. | `TagGuide.kt:70` |
| T0313 | texto | Pila CR2032 | `TagGuide.kt:70` |
| T0314 | guía del Tag | Si no aparece o no pita | `TagGuide.kt:71` |
| T0315 | guía del Tag | El Tag se conecta a un solo teléfono a la vez: cierra apps como iSearching y, si lo usaste con otro teléfono, apaga su Bluetooth. Si se conecta pero no pita, o si suena lento y sin parar, sácale la pila unos segundos y vuelve a ponerla. | `TagGuide.kt:71` |
| T0316 | texto | Un teléfono a la vez | `TagGuide.kt:71` |
| T0317 | texto | Entendido | `TagGuide.kt:79` |
| T0318 | título | Cómo usar el Tag | `TagGuide.kt:82` |
| T0319 | botón | Cerrar | `TagGuide.kt:82` |
| T0320 | botón | Atrás | `TagGuide.kt:107` |
| T0321 | texto | Siguiente | `TagGuide.kt:109` |

## 10 Hojas sobre Inicio

11 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0322 | texto | Tu relevo está contando | `HomeScreen.kt:446` |
| T0323 | texto | Suena [dato] cuando sumes [duración] en [apps elegidas]. | `HomeScreen.kt:449` |
| T0324 | botón | Entendido | `HomeScreen.kt:453` |
| T0325 | texto | Dijiste que empezaste «[actividad]» [dato]. | `RouteScreens.kt:193` |
| T0326 | texto | ¿Quieres probar el siguiente paso? | `RouteScreens.kt:195` |
| T0327 | botón | Probar el siguiente paso | `RouteScreens.kt:209` |
| T0328 | botón | Seguir en este paso | `RouteScreens.kt:210` |
| T0329 | texto | ¿Apagar el aviso semanal? | `RouteScreens.kt:219` |
| T0330 | texto | Puedes volver a encenderlo en Perfil › Ajustes › Avisos. | `RouteScreens.kt:221` |
| T0331 | botón | Apagarlo | `RouteScreens.kt:224` |
| T0332 | botón | Mantenerlo | `RouteScreens.kt:225` |

## 11 Tu relevo (contando)

28 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0333 | volver | Inicio | `HomeScreen.kt:498` |
| T0334 | texto | Contando | `HomeScreen.kt:499` |
| T0335 | texto | En pausa | `HomeScreen.kt:499` |
| T0336 | botón | Cambiar o desactivar | `HomeScreen.kt:500` |
| T0337 | texto | Faltan | `HomeScreen.kt:507` |
| T0338 | texto | de [duración] en [apps elegidas] | `HomeScreen.kt:510` |
| T0339 | fragmento | las apps que elegiste | `HomeScreen.kt:510` |
| T0340 | texto | Se activó solo. | `HomeScreen.kt:518` |
| T0341 | aviso | Falta el permiso de Tiempo de uso. | `HomeScreen.kt:523` |
| T0342 | título | Relevo no puede contar | `HomeScreen.kt:523` |
| T0343 | acción | Dar el permiso | `HomeScreen.kt:524` |
| T0344 | título | Batería | `HomeScreen.kt:529` |
| T0345 | acción | Quitar la restricción | `HomeScreen.kt:530` |
| T0346 | texto | Tu relevo | `HomeScreen.kt:536` |
| T0347 | fila | Editar | `HomeScreen.kt:539` |
| T0348 | subtítulo | Mientras lo editas no cuenta. | `HomeScreen.kt:539` |
| T0349 | fila | Desactivar | `HomeScreen.kt:540` |
| T0350 | subtítulo | Deja de contar y no suena. | `HomeScreen.kt:540` |
| T0351 | fila | Eliminar | `HomeScreen.kt:541` |
| T0352 | subtítulo | Si lo activaste por error. | `HomeScreen.kt:541` |
| T0353 | texto | ¿Eliminar este relevo? | `HomeScreen.kt:547` |
| T0354 | texto | Deja de contar, no suena y no queda en tus relevos. | `HomeScreen.kt:549` |
| T0355 | botón | Eliminar | `HomeScreen.kt:551` |
| T0356 | botón | Mantenerlo | `HomeScreen.kt:553` |
| T0357 | texto | ¿Desactivar el relevo? | `HomeScreen.kt:558` |
| T0358 | texto | Deja de contar y no suena. Después puedes decir qué decidiste. | `HomeScreen.kt:560` |
| T0359 | botón | Desactivar | `HomeScreen.kt:562` |
| T0360 | botón | Mantenerlo | `HomeScreen.kt:564` |

## 12 Suena

12 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0361 | etiqueta | No sonó | `SignalScreens.kt:101` |
| T0362 | etiqueta | Suena en | `SignalScreens.kt:102` |
| T0363 | etiqueta | Ya dejó de sonar | `SignalScreens.kt:103` |
| T0364 | texto | Es momento de volver a elegir | `SignalScreens.kt:107` |
| T0365 | título | Se cumplió el tiempo | `SignalScreens.kt:119` |
| T0366 | acción | Probar otra vez | `SignalScreens.kt:121` |
| T0367 | acción | Sonar en el teléfono | `SignalScreens.kt:122` |
| T0368 | texto | Ahora sonó. | `SignalScreens.kt:123` |
| T0369 | texto | Todavía no suena. | `SignalScreens.kt:123` |
| T0370 | texto | Silenciar y continuar | `SignalScreens.kt:127` |
| T0371 | texto | Continuar | `SignalScreens.kt:127` |
| T0372 | texto | Un toque al botón del Tag también lo calla. | `SignalScreens.kt:129` |

## 13 Preguntas y ¿Qué decidiste?

27 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0373 | texto | Bien | `Feedback.kt:43` |
| T0374 | texto | Normal | `Feedback.kt:44` |
| T0375 | texto | Mal | `Feedback.kt:45` |
| T0376 | etiqueta | Después de la señal | `SignalScreens.kt:167` |
| T0377 | acción | Saltar | `SignalScreens.kt:168` |
| T0378 | texto | Cuatro preguntas de un toque | `SignalScreens.kt:169` |
| T0379 | botón | Seguir | `SignalScreens.kt:170` |
| T0380 | pregunta | ¿Notaste el aviso apenas sonó? | `SignalScreens.kt:174` |
| T0381 | texto | Enseguida | `SignalScreens.kt:175` |
| T0382 | texto | Un rato después | `SignalScreens.kt:175` |
| T0383 | texto | No lo noté | `SignalScreens.kt:175` |
| T0384 | pregunta | ¿Cómo te cayó el sonido? | `SignalScreens.kt:178` |
| T0385 | pregunta | Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla? | `SignalScreens.kt:180` |
| T0386 | texto | Sí | `SignalScreens.kt:181` |
| T0387 | texto | A medias | `SignalScreens.kt:181` |
| T0388 | texto | No | `SignalScreens.kt:181` |
| T0389 | pregunta | ¿Recordaste cómo empezar? | `SignalScreens.kt:184` |
| T0390 | texto | Sí | `SignalScreens.kt:185` |
| T0391 | texto | No | `SignalScreens.kt:185` |
| T0392 | texto | Sonó [lugar]. | `SignalScreens.kt:195` |
| T0393 | fragmento | en el teléfono | `SignalScreens.kt:195` |
| T0394 | texto | Desactivaste el relevo. | `SignalScreens.kt:196` |
| T0395 | texto | ¿Qué decidiste? | `SignalScreens.kt:200` |
| T0396 | texto | Ninguna respuesta es mejor que otra. | `SignalScreens.kt:203` |
| T0397 | opción | Comencé la actividad | `SignalScreens.kt:208` |
| T0398 | opción | La dejé para después | `SignalScreens.kt:209` |
| T0399 | opción | Cambié de idea | `SignalScreens.kt:210` |

## 14 Actividades (antes Ruta)

31 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0400 | texto | Creadas por ti | `ActivitiesScreens.kt:70` |
| T0401 | texto | Paso a paso | `ActivitiesScreens.kt:70` |
| T0402 | texto | Ideas | `ActivitiesScreens.kt:70` |
| T0403 | título | Actividades | `ActivitiesScreens.kt:106` |
| T0404 | texto | Todavía no tienes actividades | `ActivitiesScreens.kt:134` |
| T0405 | texto | Guarda lo que haces seguido, con cómo empiezas y dónde. Después lo preparas en un toque. | `ActivitiesScreens.kt:135` |
| T0406 | botón | Crear una actividad | `ActivitiesScreens.kt:137` |
| T0407 | texto | Nueva | `ActivitiesScreens.kt:143` |
| T0408 | texto | Preparar un relevo | `ActivitiesScreens.kt:151` |
| T0409 | texto | Editar | `ActivitiesScreens.kt:152` |
| T0410 | texto | Preparar un relevo | `ActivitiesScreens.kt:176` |
| T0411 | texto | Cuando termine tu relevo, podrás prepararla. | `ActivitiesScreens.kt:211` |
| T0412 | texto | ¿Qué te gustaría hacer más seguido? | `ActivitiesScreens.kt:237` |
| T0413 | texto | Elige tus intereses y te sugerimos pasos pequeños. | `ActivitiesScreens.kt:238` |
| T0414 | botón | Elegir intereses | `ActivitiesScreens.kt:240` |
| T0415 | texto | Todavía no tiene pasos. | `ActivitiesScreens.kt:257` |
| T0416 | botón | Agregar pasos | `ActivitiesScreens.kt:258` |
| T0417 | texto | Paso actual | `ActivitiesScreens.kt:268` |
| T0418 | texto | Ahora | `ActivitiesScreens.kt:269` |
| T0419 | texto | Hecho | `ActivitiesScreens.kt:269` |
| T0420 | texto | Siguiente | `ActivitiesScreens.kt:269` |
| T0421 | texto | Cuando termine tu relevo, podrás preparar este paso. | `ActivitiesScreens.kt:279` |
| T0422 | botón | Preparar este paso | `ActivitiesScreens.kt:281` |
| T0423 | acción | Editar los pasos | `ActivitiesScreens.kt:285` |
| T0424 | acción | Cambiar intereses | `ActivitiesScreens.kt:287` |
| T0425 | texto | Ahora | `ActivitiesScreens.kt:304` |
| T0426 | texto | Paso [número] de [dato] | `ActivitiesScreens.kt:304` |
| T0427 | botón | Preparar este paso | `ActivitiesScreens.kt:316` |
| T0428 | texto | Pasar a este paso | `ActivitiesScreens.kt:320` |
| T0429 | texto | Volver a este paso | `ActivitiesScreens.kt:320` |
| T0430 | texto | Ahora | `RouteScreens.kt:86` |

## 15 Editar la ruta

19 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0431 | volver | Cancelar | `RouteScreens.kt:110` |
| T0432 | botón | Guardar | `RouteScreens.kt:111` |
| T0433 | texto | No hay cambios que guardar. | `RouteScreens.kt:111` |
| T0434 | lector de pantalla | Más opciones de [actividad] | `RouteScreens.kt:123` |
| T0435 | texto | Editar | `RouteScreens.kt:128` |
| T0436 | texto | Subir | `RouteScreens.kt:129` |
| T0437 | texto | Bajar | `RouteScreens.kt:130` |
| T0438 | texto | Pasar a este paso | `RouteScreens.kt:132` |
| T0439 | texto | Volver a este paso | `RouteScreens.kt:132` |
| T0440 | texto | Borrar | `RouteScreens.kt:134` |
| T0441 | botón | Agregar un paso | `RouteScreens.kt:143` |
| T0442 | texto | Nuevo paso | `RouteScreens.kt:170` |
| T0443 | texto | Editar el paso | `RouteScreens.kt:170` |
| T0444 | campo | Actividad | `RouteScreens.kt:172` |
| T0445 | ayuda del campo | Ej.: caminar 30 minutos | `RouteScreens.kt:172` |
| T0446 | ayuda del campo | Ej.: ponerte las zapatillas | `RouteScreens.kt:174` |
| T0447 | ayuda del campo | Ej.: junto a la puerta | `RouteScreens.kt:176` |
| T0448 | botón | Guardar el paso | `RouteScreens.kt:178` |
| T0449 | validación | Escribe la actividad del paso. | `RouteScreens.kt:179` |

## 16 Perfil

22 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0450 | texto | Perfil | `ProfileScreens.kt:128` |
| T0451 | fila | Tus relevos | `ProfileScreens.kt:132` |
| T0452 | texto | relevo terminado | `ProfileScreens.kt:132` |
| T0453 | texto | relevos terminados | `ProfileScreens.kt:132` |
| T0454 | texto | Todavía no terminas ninguno | `ProfileScreens.kt:132` |
| T0455 | fila | Tus actividades | `ProfileScreens.kt:133` |
| T0456 | texto | actividad guardada | `ProfileScreens.kt:133` |
| T0457 | texto | actividades guardadas | `ProfileScreens.kt:133` |
| T0458 | texto | Guarda las que haces seguido | `ProfileScreens.kt:133` |
| T0459 | fila | Tus pasos | `ProfileScreens.kt:134` |
| T0460 | texto | Ahora: [dato] | `ProfileScreens.kt:134` |
| T0461 | validación | Elige tus intereses | `ProfileScreens.kt:134` |
| T0462 | fila | Envíanos un comentario | `ProfileScreens.kt:135` |
| T0463 | título | Ayuda | `ProfileScreens.kt:138` |
| T0464 | fila | Cómo funciona Relevo | `ProfileScreens.kt:139` |
| T0465 | fila | Cómo usar el Tag | `ProfileScreens.kt:140` |
| T0466 | fila | Reportar un problema | `ProfileScreens.kt:141` |
| T0467 | texto | Relevo [dato] · Proyecto de Título de Diseño, Universidad Diego Portales | `ProfileScreens.kt:145` |
| T0468 | texto | Ajustes | `ProfileScreens.kt:155` |
| T0469 | lector de pantalla | Editar el perfil | `ProfileScreens.kt:167` |
| T0470 | texto | Tu perfil | `ProfileScreens.kt:174` |
| T0471 | acción | Editar el perfil | `ProfileScreens.kt:177` |

## 17 Editar el perfil

14 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0472 | título | Tu perfil | `ProfileScreens.kt:316` |
| T0473 | volver | Cancelar | `ProfileScreens.kt:317` |
| T0474 | botón | Guardar | `ProfileScreens.kt:319` |
| T0475 | validación | Escribe tu nombre. | `ProfileScreens.kt:320` |
| T0476 | validación | Escribe cuál es tu otro interés. | `ProfileScreens.kt:321` |
| T0477 | texto | No hay cambios que guardar. | `ProfileScreens.kt:322` |
| T0478 | lector de pantalla | Cambiar el emoji | `ProfileScreens.kt:331` |
| T0479 | acción | Cambiar el emoji | `ProfileScreens.kt:334` |
| T0480 | campo | Tu nombre | `ProfileScreens.kt:337` |
| T0481 | ayuda del campo | Como quieras que te diga Relevo | `ProfileScreens.kt:337` |
| T0482 | rótulo | Intereses | `ProfileScreens.kt:339` |
| T0483 | subtítulo | Elige una o varias. | `ProfileScreens.kt:339` |
| T0484 | título | Tu emoji | `ProfileScreens.kt:343` |
| T0485 | botón | Listo | `ProfileScreens.kt:343` |

## 18 Avisos y resúmenes

16 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0486 | título | Avisos | `SettingsScreens.kt:132` |
| T0487 | volver | Ajustes | `SettingsScreens.kt:132` |
| T0488 | texto | Primero prepara y termina un relevo: la activación automática repite ese. | `SettingsScreens.kt:137` |
| T0489 | texto | Mientras está encendida, Relevo mira qué app tienes abierta, solo su nombre. Después de cada relevo espera 30 minutos. | `SettingsScreens.kt:138` |
| T0490 | texto | Activación automática | `SettingsScreens.kt:141` |
| T0491 | subtítulo | Al abrir las apps de tu último relevo, empieza a contar solo. | `SettingsScreens.kt:142` |
| T0492 | texto | Resumen semanal | `SettingsScreens.kt:146` |
| T0493 | subtítulo | Tu semana, en Inicio. | `SettingsScreens.kt:147` |
| T0494 | texto | Aviso semanal | `SettingsScreens.kt:148` |
| T0495 | subtítulo | Si pasas una semana sin abrir Relevo, te avisa una vez. | `SettingsScreens.kt:151` |
| T0496 | texto | Mensaje al responder | `SettingsScreens.kt:152` |
| T0497 | subtítulo | Unas palabras después de decir qué decidiste. | `SettingsScreens.kt:153` |
| T0498 | texto | Veces por semana | `SettingsScreens.kt:154` |
| T0499 | subtítulo | Cuántas veces quieres hacerlo. Aparece en tu semana. | `SettingsScreens.kt:155` |
| T0500 | texto | Retomar | `SettingsScreens.kt:161` |
| T0501 | texto | Pausar | `SettingsScreens.kt:161` |

## 19 Apariencia

9 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0502 | título | Apariencia | `SettingsScreens.kt:171` |
| T0503 | volver | Ajustes | `SettingsScreens.kt:171` |
| T0504 | texto | Tema | `SettingsScreens.kt:173` |
| T0505 | texto | Claro, oscuro o como esté tu teléfono. | `SettingsScreens.kt:173` |
| T0506 | texto | Claro | `SettingsScreens.kt:174` |
| T0507 | texto | Oscuro | `SettingsScreens.kt:174` |
| T0508 | texto | Automático | `SettingsScreens.kt:174` |
| T0509 | texto | Se suma al tamaño que usas en el teléfono. | `SettingsScreens.kt:178` |
| T0510 | texto | Letra grande | `SettingsScreens.kt:179` |

## 20 Permisos

15 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0511 | título | Permisos | `SettingsScreens.kt:190` |
| T0512 | volver | Ajustes | `SettingsScreens.kt:190` |
| T0513 | texto | Tiempo de uso es necesario para contar. En Android se llama «Acceso a datos de uso». Lo demás es opcional. | `SettingsScreens.kt:191` |
| T0514 | fila | Tiempo de uso | `SettingsScreens.kt:192` |
| T0515 | subtítulo | Para contar el tiempo en las apps que elijas | `SettingsScreens.kt:192` |
| T0516 | texto | Permitido | `SettingsScreens.kt:192` |
| T0517 | validación | Falta | `SettingsScreens.kt:192` |
| T0518 | fila | Notificaciones | `SettingsScreens.kt:193` |
| T0519 | subtítulo | Para avisarte aunque estés en otra app | `SettingsScreens.kt:193` |
| T0520 | texto | Permitidas | `SettingsScreens.kt:193` |
| T0521 | texto | Apagadas | `SettingsScreens.kt:193` |
| T0522 | fila | Batería | `SettingsScreens.kt:195` |
| T0523 | subtítulo | Para que Android no detenga a Relevo | `SettingsScreens.kt:195` |
| T0524 | texto | Sin restricciones | `SettingsScreens.kt:195` |
| T0525 | texto | Con restricciones | `SettingsScreens.kt:195` |

## 21 Tus relevos

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0526 | título | Tus relevos | `SettingsScreens.kt:204` |
| T0527 | volver | Perfil | `SettingsScreens.kt:204` |
| T0528 | texto | Aquí verás los relevos que termines. | `SettingsScreens.kt:206` |
| T0529 | texto | Hoy | `SettingsScreens.kt:212` |
| T0530 | texto | Ayer | `SettingsScreens.kt:213` |
| T0531 | texto | Sonó | `SettingsScreens.kt:220` |
| T0532 | texto | Terminó antes de sonar | `SettingsScreens.kt:220` |

## 22 Ajustes

15 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0533 | texto | Claro | `SettingsScreens.kt:109` |
| T0534 | texto | Oscuro | `SettingsScreens.kt:109` |
| T0535 | texto | Automático | `SettingsScreens.kt:109` |
| T0536 | título | Ajustes | `SettingsScreens.kt:110` |
| T0537 | volver | Perfil | `SettingsScreens.kt:110` |
| T0538 | fila | Avisos | `SettingsScreens.kt:112` |
| T0539 | texto | Aviso semanal encendido | `SettingsScreens.kt:112` |
| T0540 | texto | Aviso semanal apagado | `SettingsScreens.kt:112` |
| T0541 | fila | Apariencia | `SettingsScreens.kt:113` |
| T0542 | texto | · letra grande | `SettingsScreens.kt:113` |
| T0543 | fila | Permisos | `SettingsScreens.kt:114` |
| T0544 | texto | Todo listo para contar | `SettingsScreens.kt:114` |
| T0545 | validación | Falta Tiempo de uso | `SettingsScreens.kt:114` |
| T0546 | fila | Tus datos | `SettingsScreens.kt:115` |
| T0547 | subtítulo | Privacidad, tu código y el borrado | `SettingsScreens.kt:115` |

## 23 Crear o editar una actividad

28 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0548 | título | Nueva actividad | `ActivitiesScreens.kt:384` |
| T0549 | volver | Cancelar | `ActivitiesScreens.kt:385` |
| T0550 | botón | Crear una propia | `ActivitiesScreens.kt:386` |
| T0551 | texto | Ya guardaste todas las predefinidas. | `ActivitiesScreens.kt:389` |
| T0552 | texto | Nueva actividad | `ActivitiesScreens.kt:427` |
| T0553 | texto | Editar la actividad | `ActivitiesScreens.kt:427` |
| T0554 | texto | Volver | `ActivitiesScreens.kt:428` |
| T0555 | texto | Cancelar | `ActivitiesScreens.kt:428` |
| T0556 | botón | Guardar | `ActivitiesScreens.kt:430` |
| T0557 | validación | Escribe el nombre de la actividad. | `ActivitiesScreens.kt:433` |
| T0558 | texto | Usa hasta 60 caracteres en el nombre. | `ActivitiesScreens.kt:434` |
| T0559 | texto | Ya tienes una actividad con ese nombre. | `ActivitiesScreens.kt:435` |
| T0560 | validación | Escribe cómo empiezas la actividad. | `ActivitiesScreens.kt:436` |
| T0561 | validación | Escribe en qué lugar empieza. | `ActivitiesScreens.kt:437` |
| T0562 | lector de pantalla | Cambiar el ícono | `ActivitiesScreens.kt:443` |
| T0563 | acción | Cambiar el ícono | `ActivitiesScreens.kt:444` |
| T0564 | campo | Actividad | `ActivitiesScreens.kt:447` |
| T0565 | ayuda del campo | Ej.: practicar guitarra | `ActivitiesScreens.kt:447` |
| T0566 | texto | Ya tienes una actividad con ese nombre. | `ActivitiesScreens.kt:448` |
| T0567 | ayuda del campo | Ej.: sacar la guitarra del estuche | `ActivitiesScreens.kt:450` |
| T0568 | ayuda del campo | Ej.: junto a la guitarra | `ActivitiesScreens.kt:452` |
| T0569 | botón | Borrar la actividad | `ActivitiesScreens.kt:455` |
| T0570 | título | Elige un ícono | `ActivitiesScreens.kt:459` |
| T0571 | botón | Listo | `ActivitiesScreens.kt:459` |
| T0572 | texto | ¿Borrar «[nombre]»? | `ActivitiesScreens.kt:469` |
| T0573 | texto | Se quita de tus actividades. Los relevos que ya hiciste se mantienen. | `ActivitiesScreens.kt:471` |
| T0574 | botón | Borrar | `ActivitiesScreens.kt:473` |
| T0575 | botón | Cancelar | `ActivitiesScreens.kt:475` |

## 24 Privacidad y datos

30 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0576 | texto | Todo está enviado. | `Common.kt:330` |
| T0577 | texto | Algunos datos se enviarán cuando haya internet. | `Common.kt:330` |
| T0578 | texto | Último envío: [dato]. | `Common.kt:331` |
| T0579 | texto | Detalle técnico: [dato] | `Common.kt:333` |
| T0580 | texto | En Documentos/Relevo. Última copia: [dato]. | `Common.kt:337` |
| T0581 | texto | Se crea en Documentos/Relevo con el primer relevo. | `Common.kt:337` |
| T0582 | texto | Borrando tus datos… | `RelevoViewModel.kt:1097` |
| T0583 | texto | Relevo dejó de guardar datos, pero no pudimos confirmar el borrado. Tus datos siguen en el teléfono. Inténtalo de nuevo o escribe a [correo del investigador]. | `RelevoViewModel.kt:1141` |
| T0584 | texto | Tus datos se borraron y saliste del proyecto. Si quieres volver, tendrás que aceptar de nuevo. | `RelevoViewModel.kt:1193` |
| T0585 | texto | Tus datos quedaron en el archivo que elegiste. | `SettingsScreens.kt:255` |
| T0586 | texto | No se pudo guardar el archivo. Prueba otra vez. | `SettingsScreens.kt:255` |
| T0587 | título | Tus datos | `SettingsScreens.kt:258` |
| T0588 | volver | Ajustes | `SettingsScreens.kt:258` |
| T0589 | botón | Volver a comenzar | `SettingsScreens.kt:259` |
| T0590 | texto | Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte, solo con ese código. No vemos lo que haces dentro de otras apps. Si no borras tus datos antes, los borramos el 30 de diciembre de 2026. | `SettingsScreens.kt:262` |
| T0591 | fila | Tu código | `SettingsScreens.kt:269` |
| T0592 | texto | Sin código | `SettingsScreens.kt:269` |
| T0593 | fila | Lo que aceptaste | `SettingsScreens.kt:272` |
| T0594 | fila | Datos enviados | `SettingsScreens.kt:273` |
| T0595 | fila | Copia en el teléfono | `SettingsScreens.kt:274` |
| T0596 | texto | Primero se borra en la base del proyecto. Si no se puede, Relevo deja de guardar datos y conserva lo del teléfono para intentarlo otra vez. | `SettingsScreens.kt:278` |
| T0597 | fila | Descargar mis datos | `SettingsScreens.kt:279` |
| T0598 | subtítulo | Un archivo con todo lo guardado en el teléfono. | `SettingsScreens.kt:279` |
| T0599 | fila | Borrar mis datos | `SettingsScreens.kt:281` |
| T0600 | subtítulo | También sales del proyecto. | `SettingsScreens.kt:281` |
| T0601 | texto | ¿Dudas, o prefieres pedir el borrado por correo? Escribe a [correo del investigador] con tu código. | `SettingsScreens.kt:286` |
| T0602 | texto | ¿Borrar tus datos? | `SettingsScreens.kt:296` |
| T0603 | texto | Se borran tus relevos, actividades, perfil, ruta y respuestas, también en la base del proyecto y en la copia de Documentos/Relevo. Sales del proyecto y Relevo deja de contar. | `SettingsScreens.kt:298` |
| T0604 | botón | Borrar mis datos | `SettingsScreens.kt:300` |
| T0605 | botón | Cancelar | `SettingsScreens.kt:302` |

## 25 Lo que aceptaste

2 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0606 | título | Lo que aceptaste | `FirstRunScreens.kt:207` |
| T0607 | subtítulo | Aceptaste participar con este texto. | `FirstRunScreens.kt:207` |

## 26 Prueba de 21 días (investigador)

25 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0608 | texto | Secuencia no válida: [dato] | `Study.kt:39` |
| T0609 | título | Prueba de 21 días | `StudyScreens.kt:108` |
| T0610 | texto | Empezar la semana hoy | `StudyScreens.kt:109` |
| T0611 | texto | Empezar la prueba hoy | `StudyScreens.kt:109` |
| T0612 | validación | Elige una secuencia o una semana. | `StudyScreens.kt:109` |
| T0613 | texto | Para configurar la prueba, primero hay que aceptar participar. | `StudyScreens.kt:112` |
| T0614 | texto | Para el investigador, en la sesión inicial. Elige la secuencia asignada; hoy será el día 0. | `StudyScreens.kt:114` |
| T0615 | título | Condiciones | `StudyScreens.kt:116` |
| T0616 | título | Secuencia | `StudyScreens.kt:120` |
| T0617 | fila | Secuencia [número] | `StudyScreens.kt:122` |
| T0618 | título | Una semana para comparar | `StudyScreens.kt:127` |
| T0619 | fila | Semana [dato]: [condición] | `StudyScreens.kt:130` |
| T0620 | subtítulo | Empieza hoy (día 1) y dura 7 días. Antes, pregunta por las semanas anteriores. | `StudyScreens.kt:130` |
| T0621 | texto | La semana de comparación terminó. | `StudyScreens.kt:136` |
| T0622 | texto | La prueba terminó el día 21. | `StudyScreens.kt:136` |
| T0623 | texto | Hoy es la sesión inicial (día 0). | `StudyScreens.kt:137` |
| T0624 | texto | Día [día] de 7 · semana de comparación: [condición]. | `StudyScreens.kt:138` |
| T0625 | texto | Día [día] de 21 · semana [semana]: [condición]. | `StudyScreens.kt:139` |
| T0626 | fila | Secuencia | `StudyScreens.kt:145` |
| T0627 | fila | Día 0 | `StudyScreens.kt:146` |
| T0628 | fila | Código de participación | `StudyScreens.kt:147` |
| T0629 | texto | La condición de cada semana fija dónde suena la señal. Las preguntas y las tarjetas aparecen solas. | `StudyScreens.kt:150` |
| T0630 | botón | Terminar la prueba | `StudyScreens.kt:153` |
| T0631 | acción | Cancelar | `StudyScreens.kt:154` |
| T0632 | acción | Terminar la prueba | `StudyScreens.kt:156` |

## 27 ¿Cómo te fue esta semana?

16 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0633 | texto | ¿Cómo te fue hasta ahora? | `StudyScreens.kt:172` |
| T0634 | texto | ¿Cómo te fue esta semana? | `StudyScreens.kt:172` |
| T0635 | texto | Las semanas antes de esta, con el objeto que ya usabas. | `StudyScreens.kt:173` |
| T0636 | volver | Después | `StudyScreens.kt:174` |
| T0637 | botón | Enviar | `StudyScreens.kt:176` |
| T0638 | acción | Saltar | `StudyScreens.kt:177` |
| T0639 | pregunta | ¿Te costó preparar Relevo? | `StudyScreens.kt:180` |
| T0640 | pregunta | ¿Te molestó el sonido? | `StudyScreens.kt:182` |
| T0641 | pregunta | ¿El sonido tenía que ver con el lugar donde sonó? | `StudyScreens.kt:184` |
| T0642 | pregunta | Comparado con las semanas anteriores, ¿esta semana te ayudó a recordar lo que querías hacer… | `StudyScreens.kt:188` |
| T0643 | texto | Más | `StudyScreens.kt:189` |
| T0644 | texto | Igual | `StudyScreens.kt:189` |
| T0645 | texto | Menos | `StudyScreens.kt:189` |
| T0646 | texto | ¿Por qué? ¿Algo más que quieras contarnos? | `StudyScreens.kt:193` |
| T0647 | texto | ¿Algo más que quieras contarnos? | `StudyScreens.kt:193` |
| T0648 | validación | Escribe aquí, si quieres | `StudyScreens.kt:193` |

## 28 Cierre de la prueba

32 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0649 | texto | ¡Terminaste la prueba! | `StudyScreens.kt:212` |
| T0650 | texto | ¡Terminaste los 21 días! | `StudyScreens.kt:212` |
| T0651 | texto | Gracias. Siete preguntas cortas; puedes saltar las que quieras. | `StudyScreens.kt:213` |
| T0652 | texto | Gracias. Cinco preguntas cortas; puedes saltar las que quieras. | `StudyScreens.kt:213` |
| T0653 | volver | Después | `StudyScreens.kt:214` |
| T0654 | botón | Enviar | `StudyScreens.kt:216` |
| T0655 | pregunta | 1. ¿Seguirías usando Relevo? | `StudyScreens.kt:229` |
| T0656 | texto | Sí | `StudyScreens.kt:230` |
| T0657 | texto | Tal vez | `StudyScreens.kt:230` |
| T0658 | texto | No | `StudyScreens.kt:230` |
| T0659 | texto | 2. ¿Qué te ayudó más a recordar lo que querías hacer? | `StudyScreens.kt:234` |
| T0660 | texto | 2. ¿Qué semana te ayudó más? | `StudyScreens.kt:234` |
| T0661 | texto | El objeto donde empiezo | `StudyScreens.kt:235` |
| T0662 | texto | El aviso en el teléfono | `StudyScreens.kt:235` |
| T0663 | texto | Los dos por igual | `StudyScreens.kt:235` |
| T0664 | texto | Ninguno | `StudyScreens.kt:235` |
| T0665 | texto | Ninguna | `StudyScreens.kt:236` |
| T0666 | campo | 3. ¿Por qué? | `StudyScreens.kt:245` |
| T0667 | validación | Escribe aquí | `StudyScreens.kt:245` |
| T0668 | pregunta | 4. Si siguieras usando Relevo, ¿con qué te gustaría que sonara? | `StudyScreens.kt:247` |
| T0669 | texto | Un objeto | `StudyScreens.kt:248` |
| T0670 | texto | El teléfono | `StudyScreens.kt:248` |
| T0671 | texto | Me da igual | `StudyScreens.kt:248` |
| T0672 | texto | 5. ¿Qué te molestó? | `StudyScreens.kt:252` |
| T0673 | texto | 3. ¿Qué te molestó? | `StudyScreens.kt:252` |
| T0674 | validación | Escribe aquí | `StudyScreens.kt:252` |
| T0675 | texto | 6. ¿Qué cambiarías? | `StudyScreens.kt:254` |
| T0676 | texto | 4. ¿Qué cambiarías? | `StudyScreens.kt:254` |
| T0677 | validación | Escribe aquí | `StudyScreens.kt:254` |
| T0678 | texto | 7. ¿Dónde quedó el objeto la mayor parte del tiempo? | `StudyScreens.kt:256` |
| T0679 | texto | 5. ¿Dónde quedó lo que sonaba la mayor parte del tiempo? | `StudyScreens.kt:256` |
| T0680 | texto | Ejemplo: junto a la puerta | `StudyScreens.kt:256` |

## 29 Envíanos un comentario (antes, Opinar sobre Relevo)

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0681 | título | Envíanos un comentario | `SettingsScreens.kt:318` |
| T0682 | volver | Cerrar | `SettingsScreens.kt:319` |
| T0683 | botón | Enviar | `SettingsScreens.kt:320` |
| T0684 | validación | Escribe un comentario o elige las estrellas. | `SettingsScreens.kt:320` |
| T0685 | campo | Comentario | `SettingsScreens.kt:322` |
| T0686 | texto | Ej.: me gustaría elegir otro sonido | `SettingsScreens.kt:322` |
| T0687 | texto | ¿Cómo te resultó Relevo? | `SettingsScreens.kt:324` |

## 30 Reportar un problema

8 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0688 | título | Reportar un problema | `SettingsScreens.kt:336` |
| T0689 | volver | Cerrar | `SettingsScreens.kt:337` |
| T0690 | botón | Enviar | `SettingsScreens.kt:338` |
| T0691 | validación | Escribe qué pasó. | `SettingsScreens.kt:338` |
| T0692 | campo | ¿Qué pasó? | `SettingsScreens.kt:340` |
| T0693 | texto | Ej.: no sonó en el parlante | `SettingsScreens.kt:340` |
| T0694 | texto | Adjuntar datos técnicos | `SettingsScreens.kt:350` |
| T0695 | texto | Versión, permisos y estado del envío. Nada de lo que haces en tus apps. | `SettingsScreens.kt:351` |

## 31 Notificaciones

32 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0696 | texto | Se activa solo | `AppUsageMonitorService.kt:121` |
| T0697 | texto | Contando para «[actividad]» | `AppUsageMonitorService.kt:122` |
| T0698 | texto | Contando | `AppUsageMonitorService.kt:123` |
| T0699 | notificación | Suena al sumar [dato] | `AppUsageMonitorService.kt:125` |
| T0700 | notificación | Hasta que lo desactives | `AppUsageMonitorService.kt:125` |
| T0701 | notificación | Al abrir las apps de tu último relevo | `AppUsageMonitorService.kt:125` |
| T0702 | notificación | Contando | `AppUsageMonitorService.kt:128` |
| T0703 | notificación | Se activa solo | `AppUsageMonitorService.kt:128` |
| T0704 | notificación: título | Dejó de contar | `AppUsageMonitorService.kt:355` |
| T0705 | notificación: texto | Falta el permiso de Tiempo de uso | `AppUsageMonitorService.kt:356` |
| T0706 | notificación: texto | Falta el permiso de Tiempo de uso. Sin él, Relevo no puede contar. | `AppUsageMonitorService.kt:357` |
| T0707 | lector de pantalla | Muestra que Relevo está contando el tiempo en las apps que elegiste o esperando para activarse solo. | `AppUsageMonitorService.kt:379` |
| T0708 | lector de pantalla | Suena cuando sumas el tiempo que elegiste. | `AppUsageMonitorService.kt:384` |
| T0709 | lector de pantalla | Avisa si Relevo dejó de contar, por ejemplo al retirar un permiso. | `AppUsageMonitorService.kt:391` |
| T0710 | notificación: título | Relevo | `AppUsageMonitorService.kt:406` |
| T0711 | texto | No sonó en el parlante | `AppUsageMonitorService.kt:411` |
| T0712 | texto | No sonó en el reloj | `AppUsageMonitorService.kt:412` |
| T0713 | texto | No sonó en el Tag | `AppUsageMonitorService.kt:413` |
| T0714 | texto | No sonó en el teléfono | `AppUsageMonitorService.kt:414` |
| T0715 | texto | Empieza por [primer paso] | `AppUsageMonitorService.kt:417` |
| T0716 | notificación | Relevo | `AppUsageMonitorService.kt:423` |
| T0717 | notificación | Es momento de volver a elegir | `AppUsageMonitorService.kt:446` |
| T0718 | lector de pantalla | Mensajes del investigador sobre el testeo. | `ProjectMessages.kt:116` |
| T0719 | notificación: título | Relevo | `ProjectMessages.kt:128` |
| T0720 | notificación: texto | Tienes un mensaje nuevo | `ProjectMessages.kt:129` |
| T0721 | notificación | ¿Quieres preparar un relevo esta semana? | `ReturnNotice.kt:30` |
| T0722 | lector de pantalla | Una vez por semana como máximo, si no abriste Relevo. Se apaga en Perfil › Ajustes › Avisos. | `ReturnNotice.kt:66` |
| T0723 | notificación | Esta semana | `ReturnNotice.kt:71` |
| T0724 | notificación | ¿Sigue en pie esta semana? | `ReturnNotice.kt:72` |
| T0725 | notificación: título | Relevo | `ReturnNotice.kt:76` |
| T0726 | notificación: botón | Preparar | `ReturnNotice.kt:96` |
| T0727 | notificación: botón | Ahora no | `ReturnNotice.kt:97` |

## 32 Textos compartidos

34 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0728 | texto | ¿Cómo empiezas la actividad? | `Common.kt:54` |
| T0729 | texto | ¿En qué lugar empieza? | `Common.kt:55` |
| T0730 | texto | Empieza por [primer paso], [lugar]. | `Common.kt:263` |
| T0731 | texto | Empieza por [primer paso]. | `Common.kt:264` |
| T0732 | texto | Empieza [lugar]. | `Common.kt:265` |
| T0733 | texto | donde lo dejaste | `Common.kt:273` |
| T0734 | texto | detrás | `Common.kt:275` |
| T0735 | texto | en «[dato]» | `Common.kt:276` |
| T0736 | texto | El parlante | `Common.kt:304` |
| T0737 | texto | El reloj | `Common.kt:305` |
| T0738 | texto | El Tag | `Common.kt:306` |
| T0739 | texto | El teléfono | `Common.kt:307` |
| T0740 | texto | No sonó en el parlante. Revisa que esté encendido y conectado. | `Common.kt:318` |
| T0741 | texto | No sonó en el reloj. Revisa que esté conectado y con las llamadas por Bluetooth activadas. | `Common.kt:319` |
| T0742 | texto | No sonó en el Tag. Revisa que esté encendido y cerca del teléfono. | `Common.kt:320` |
| T0743 | texto | No sonó en el teléfono. Revisa el volumen. | `Common.kt:321` |
| T0744 | texto | Dijiste que empezaste | `Common.kt:349` |
| T0745 | texto | La dejaste para después | `Common.kt:350` |
| T0746 | texto | Cambiaste de idea | `Common.kt:351` |
| T0747 | texto | Gracias por contarlo. | `Common.kt:364` |
| T0748 | texto | Queda guardado. Puedes prepararlo cuando quieras. | `Common.kt:365` |
| T0749 | texto | Está bien. Puedes elegir otra actividad cuando quieras. | `Common.kt:366` |
| T0750 | texto | , en otro lugar de tu casa | `Common.kt:388` |
| T0751 | texto | , donde empiezas | `Common.kt:389` |
| T0752 | texto | en el teléfono | `Common.kt:394` |
| T0753 | texto | Suena donde empiezas | `Common.kt:399` |
| T0754 | texto | Suena en otro lugar | `Common.kt:400` |
| T0755 | texto | Suena en el teléfono | `Common.kt:401` |
| T0756 | texto | Esta semana deja el parlante, el reloj o el Tag junto a lo que usas para empezar. | `Common.kt:406` |
| T0757 | texto | Esta semana déjalo en otro lugar de tu casa, que no tenga que ver con la actividad. | `Common.kt:407` |
| T0758 | texto | Esta semana suena en tu teléfono. | `Common.kt:408` |
| T0759 | texto | Un lugar visible, a más de un metro de lo que necesitas para empezar y fuera de tu camino. | `Common.kt:412` |
| T0760 | texto | No necesitas el parlante, el reloj ni el Tag: puedes apagar el Tag manteniendo apretado su centro 3 segundos. La notificación solo dirá «Es momento de volver a elegir». | `Common.kt:413` |
| T0761 | texto | Código de participación | `SettingsScreens.kt:308` |

## 33 Ideas, sugerencias y rutas

232 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0762 | texto | Dormir a tiempo | `Route.kt:59` |
| T0763 | texto | Acostarte sin el teléfono | `Route.kt:60` |
| T0764 | texto | Dejar el teléfono cargando lejos de la cama | `Route.kt:60` |
| T0765 | texto | Junto al cargador | `Route.kt:60` |
| T0766 | texto | Leer un rato antes de dormir | `Route.kt:61` |
| T0767 | texto | Dejar el libro en el velador | `Route.kt:61` |
| T0768 | texto | En el velador | `Route.kt:61` |
| T0769 | texto | Acostarte a la misma hora | `Route.kt:62` |
| T0770 | texto | Apagar la luz grande | `Route.kt:62` |
| T0771 | texto | Junto al interruptor | `Route.kt:62` |
| T0772 | texto | Leer | `Route.kt:65` |
| T0773 | texto | Leer 10 páginas | `Route.kt:66` |
| T0774 | texto | Abrir el libro | `Route.kt:66` |
| T0775 | texto | En el velador | `Route.kt:66` |
| T0776 | texto | Leer un capítulo de manga | `Route.kt:67` |
| T0777 | texto | Sacar el tomo del estante | `Route.kt:67` |
| T0778 | texto | Junto al estante | `Route.kt:67` |
| T0779 | texto | Leer un capítulo | `Route.kt:68` |
| T0780 | texto | Abrir el libro en el marcador | `Route.kt:68` |
| T0781 | texto | En el velador | `Route.kt:68` |
| T0782 | texto | Hacer ejercicio | `Route.kt:71` |
| T0783 | texto | Hacer una serie corta | `Route.kt:72` |
| T0784 | texto | Ponerte ropa cómoda | `Route.kt:72` |
| T0785 | texto | Junto al clóset | `Route.kt:72` |
| T0786 | texto | Entrenar 20 minutos | `Route.kt:73` |
| T0787 | texto | Estirar la colchoneta | `Route.kt:73` |
| T0788 | texto | Donde guardas la colchoneta | `Route.kt:73` |
| T0789 | texto | Ir a entrenar | `Route.kt:74` |
| T0790 | texto | Preparar el bolso | `Route.kt:74` |
| T0791 | texto | Junto a la puerta | `Route.kt:74` |
| T0792 | texto | Salir en bicicleta | `Route.kt:77` |
| T0793 | texto | Dar una vuelta corta | `Route.kt:78` |
| T0794 | texto | Sacar la bici | `Route.kt:78` |
| T0795 | texto | Junto a la puerta | `Route.kt:78` |
| T0796 | texto | Andar 30 minutos | `Route.kt:79` |
| T0797 | texto | Inflar las ruedas | `Route.kt:79` |
| T0798 | texto | Junto a la bici | `Route.kt:79` |
| T0799 | texto | Ir en bici a algún lugar | `Route.kt:80` |
| T0800 | texto | Ponerte el casco | `Route.kt:80` |
| T0801 | texto | Junto a la puerta | `Route.kt:80` |
| T0802 | texto | Pasear o jugar con tu perro | `Route.kt:83` |
| T0803 | texto | Salir 10 minutos con el perro | `Route.kt:84` |
| T0804 | texto | Tomar la correa | `Route.kt:84` |
| T0805 | texto | Junto a la puerta | `Route.kt:84` |
| T0806 | texto | Jugar con el perro | `Route.kt:85` |
| T0807 | texto | Sacar su pelota | `Route.kt:85` |
| T0808 | texto | Donde está su pelota | `Route.kt:85` |
| T0809 | texto | Salir con el perro sin el teléfono | `Route.kt:86` |
| T0810 | texto | Dejar el teléfono en casa | `Route.kt:86` |
| T0811 | texto | Junto a la puerta | `Route.kt:86` |
| T0812 | texto | Dibujar o pintar | `Route.kt:89` |
| T0813 | texto | Dibujar 10 minutos | `Route.kt:90` |
| T0814 | texto | Sacar el cuaderno y un lápiz | `Route.kt:90` |
| T0815 | texto | En el escritorio | `Route.kt:90` |
| T0816 | texto | Pintar | `Route.kt:91` |
| T0817 | texto | Preparar las acuarelas | `Route.kt:91` |
| T0818 | texto | En la mesa | `Route.kt:91` |
| T0819 | texto | Terminar un dibujo | `Route.kt:92` |
| T0820 | texto | Abrir el cuaderno en ese dibujo | `Route.kt:92` |
| T0821 | texto | En el escritorio | `Route.kt:92` |
| T0822 | texto | Manualidades o maquetas | `Route.kt:95` |
| T0823 | texto | Avanzar 15 minutos | `Route.kt:96` |
| T0824 | texto | Sacar los materiales | `Route.kt:96` |
| T0825 | texto | En la mesa de trabajo | `Route.kt:96` |
| T0826 | texto | Armar una parte de la maqueta | `Route.kt:97` |
| T0827 | texto | Abrir la caja de la maqueta | `Route.kt:97` |
| T0828 | texto | En la mesa | `Route.kt:97` |
| T0829 | texto | Terminar lo que empezaste | `Route.kt:98` |
| T0830 | texto | Dejar la pieza a la vista | `Route.kt:98` |
| T0831 | texto | En la mesa | `Route.kt:98` |
| T0832 | texto | Cocinar | `Route.kt:101` |
| T0833 | texto | Cocinar algo simple | `Route.kt:102` |
| T0834 | texto | Reunir los ingredientes | `Route.kt:102` |
| T0835 | texto | En el mesón de la cocina | `Route.kt:102` |
| T0836 | texto | Probar una receta nueva | `Route.kt:103` |
| T0837 | texto | Dejar la receta a la vista | `Route.kt:103` |
| T0838 | texto | En el mesón de la cocina | `Route.kt:103` |
| T0839 | texto | Preparar la comida de mañana | `Route.kt:104` |
| T0840 | texto | Sacar los táper | `Route.kt:104` |
| T0841 | texto | En el mesón de la cocina | `Route.kt:104` |
| T0842 | texto | Ordenar tu pieza | `Route.kt:107` |
| T0843 | texto | Ordenar un cajón | `Route.kt:108` |
| T0844 | texto | Vaciar el cajón sobre la cama | `Route.kt:108` |
| T0845 | texto | Junto al cajón | `Route.kt:108` |
| T0846 | texto | Hacer la cama | `Route.kt:109` |
| T0847 | texto | Estirar las sábanas | `Route.kt:109` |
| T0848 | texto | Junto a la cama | `Route.kt:109` |
| T0849 | texto | Ordenar la ropa | `Route.kt:110` |
| T0850 | texto | Juntar la ropa en el canasto | `Route.kt:110` |
| T0851 | texto | Junto al canasto | `Route.kt:110` |
| T0852 | texto | Meditar | `Route.kt:113` |
| T0853 | texto | Respirar 5 minutos | `Route.kt:114` |
| T0854 | texto | Sentarte en el cojín | `Route.kt:114` |
| T0855 | texto | Junto al cojín | `Route.kt:114` |
| T0856 | texto | Meditar 10 minutos | `Route.kt:115` |
| T0857 | texto | Apagar la luz grande | `Route.kt:115` |
| T0858 | texto | Junto al interruptor | `Route.kt:115` |
| T0859 | texto | Estirar antes de dormir | `Route.kt:116` |
| T0860 | texto | Desenrollar la colchoneta | `Route.kt:116` |
| T0861 | texto | Junto a la cama | `Route.kt:116` |
| T0862 | texto | Estudiar o hacer tareas | `Route.kt:119` |
| T0863 | texto | Estudiar 20 minutos | `Route.kt:120` |
| T0864 | texto | Abrir tus apuntes | `Route.kt:120` |
| T0865 | texto | En el escritorio | `Route.kt:120` |
| T0866 | texto | Hacer una tarea | `Route.kt:121` |
| T0867 | texto | Abrir el cuaderno en la tarea | `Route.kt:121` |
| T0868 | texto | En el escritorio | `Route.kt:121` |
| T0869 | texto | Repasar para una prueba | `Route.kt:122` |
| T0870 | texto | Sacar tus resúmenes | `Route.kt:122` |
| T0871 | texto | En el escritorio | `Route.kt:122` |
| T0872 | texto | Jugar videojuegos | `Route.kt:125` |
| T0873 | texto | Jugar una partida | `Route.kt:126` |
| T0874 | texto | Encender la consola | `Route.kt:126` |
| T0875 | texto | Junto a la tele | `Route.kt:126` |
| T0876 | texto | Avanzar en tu juego | `Route.kt:127` |
| T0877 | texto | Dejar el control cargado | `Route.kt:127` |
| T0878 | texto | Junto a la tele | `Route.kt:127` |
| T0879 | texto | Jugar con alguien | `Route.kt:128` |
| T0880 | texto | Avisar a quien juega contigo | `Route.kt:128` |
| T0881 | texto | Junto al computador | `Route.kt:128` |
| T0882 | texto | Escuchar música | `Route.kt:131` |
| T0883 | texto | Escuchar un disco entero | `Route.kt:132` |
| T0884 | texto | Elegir el disco | `Route.kt:132` |
| T0885 | texto | Junto a los discos | `Route.kt:132` |
| T0886 | texto | Escuchar música sin hacer nada más | `Route.kt:133` |
| T0887 | texto | Ponerte los audífonos | `Route.kt:133` |
| T0888 | texto | En el sillón | `Route.kt:133` |
| T0889 | texto | Tocar una canción | `Route.kt:134` |
| T0890 | texto | Sacar el instrumento | `Route.kt:134` |
| T0891 | texto | Junto al instrumento | `Route.kt:134` |
| T0892 | texto | Ver una película o serie | `Route.kt:137` |
| T0893 | texto | Ver una película | `Route.kt:138` |
| T0894 | texto | Elegir la película | `Route.kt:138` |
| T0895 | texto | Junto a la tele | `Route.kt:138` |
| T0896 | texto | Ver un capítulo con alguien | `Route.kt:139` |
| T0897 | texto | Avisar a quien ve contigo | `Route.kt:139` |
| T0898 | texto | Junto a la tele | `Route.kt:139` |
| T0899 | texto | Ver una película sin el teléfono | `Route.kt:140` |
| T0900 | texto | Dejar el teléfono cargando | `Route.kt:140` |
| T0901 | texto | Junto al cargador | `Route.kt:140` |
| T0902 | texto | Compartir con alguien | `Route.kt:143` |
| T0903 | texto | Comer sin el teléfono | `Route.kt:144` |
| T0904 | texto | Poner la mesa | `Route.kt:144` |
| T0905 | texto | En la mesa del comedor | `Route.kt:144` |
| T0906 | texto | Jugar un juego de mesa | `Route.kt:145` |
| T0907 | texto | Sacar la caja | `Route.kt:145` |
| T0908 | texto | En la mesa | `Route.kt:145` |
| T0909 | texto | Juntarte a jugar a la pelota | `Route.kt:146` |
| T0910 | texto | Preparar las zapatillas | `Route.kt:146` |
| T0911 | texto | Junto a la puerta | `Route.kt:146` |
| T0912 | texto | Llamar a alguien | `Route.kt:148` |
| T0913 | texto | Buscar su número | `Route.kt:148` |
| T0914 | texto | En el sillón | `Route.kt:148` |
| T0915 | texto | Otra actividad | `Route.kt:158` |
| T0916 | texto | En tu pieza | `Route.kt:165` |
| T0917 | texto | En el living | `Route.kt:165` |
| T0918 | texto | En la cocina | `Route.kt:165` |
| T0919 | texto | En el comedor | `Route.kt:165` |
| T0920 | texto | Leer | `Common.kt:64` |
| T0921 | texto | Abrir el libro | `Common.kt:64` |
| T0922 | texto | En el velador | `Common.kt:64` |
| T0923 | texto | Dormir a tiempo | `Common.kt:65` |
| T0924 | texto | Dejar el teléfono cargando lejos | `Common.kt:65` |
| T0925 | texto | Junto al cargador | `Common.kt:65` |
| T0926 | texto | Hacer ejercicio | `Common.kt:66` |
| T0927 | texto | Ponerte ropa cómoda | `Common.kt:66` |
| T0928 | texto | Junto al clóset | `Common.kt:66` |
| T0929 | texto | Pasear al perro | `Common.kt:67` |
| T0930 | texto | Tomar la correa | `Common.kt:67` |
| T0931 | texto | Junto a la puerta | `Common.kt:67` |
| T0932 | texto | Dibujar | `Common.kt:68` |
| T0933 | texto | Sacar el cuaderno y un lápiz | `Common.kt:68` |
| T0934 | texto | En el escritorio | `Common.kt:68` |
| T0935 | texto | Pintar | `Common.kt:69` |
| T0936 | texto | Preparar las acuarelas | `Common.kt:69` |
| T0937 | texto | En la mesa | `Common.kt:69` |
| T0938 | texto | Cocinar | `Common.kt:70` |
| T0939 | texto | Reunir los ingredientes | `Common.kt:70` |
| T0940 | texto | En el mesón de la cocina | `Common.kt:70` |
| T0941 | texto | Estudiar | `Common.kt:71` |
| T0942 | texto | Abrir tus apuntes | `Common.kt:71` |
| T0943 | texto | En el escritorio | `Common.kt:71` |
| T0944 | texto | Ordenar tu pieza | `Common.kt:72` |
| T0945 | texto | Despejar una superficie | `Common.kt:72` |
| T0946 | texto | En el escritorio | `Common.kt:72` |
| T0947 | texto | Hacer manualidades | `Common.kt:73` |
| T0948 | texto | Preparar los materiales | `Common.kt:73` |
| T0949 | texto | En la mesa de trabajo | `Common.kt:73` |
| T0950 | texto | Armar una maqueta | `Common.kt:74` |
| T0951 | texto | Abrir la caja de la maqueta | `Common.kt:74` |
| T0952 | texto | En la mesa | `Common.kt:74` |
| T0953 | texto | Salir en bicicleta | `Common.kt:75` |
| T0954 | texto | Sacar la bici | `Common.kt:75` |
| T0955 | texto | Junto a la puerta | `Common.kt:75` |
| T0956 | texto | Meditar | `Common.kt:76` |
| T0957 | texto | Sentarte en el cojín | `Common.kt:76` |
| T0958 | texto | Junto al cojín | `Common.kt:76` |
| T0959 | texto | Leer manga | `Common.kt:77` |
| T0960 | texto | Sacar el tomo del estante | `Common.kt:77` |
| T0961 | texto | Junto al estante | `Common.kt:77` |
| T0962 | texto | Jugar videojuegos | `Common.kt:79` |
| T0963 | texto | Encender la consola | `Common.kt:79` |
| T0964 | texto | Junto a la tele | `Common.kt:79` |
| T0965 | texto | Escuchar música | `Common.kt:80` |
| T0966 | texto | Ponerte los audífonos | `Common.kt:80` |
| T0967 | texto | En el sillón | `Common.kt:80` |
| T0968 | texto | Ver una película | `Common.kt:81` |
| T0969 | texto | Elegir la película | `Common.kt:81` |
| T0970 | texto | Junto a la tele | `Common.kt:81` |
| T0971 | texto | Llamar a alguien | `Common.kt:82` |
| T0972 | texto | Buscar su número | `Common.kt:82` |
| T0973 | texto | En el sillón | `Common.kt:82` |
| T0974 | texto | Jugar un juego de mesa | `Common.kt:83` |
| T0975 | texto | Sacar la caja | `Common.kt:83` |
| T0976 | texto | En la mesa | `Common.kt:83` |
| T0977 | texto | En el velador | `Common.kt:89` |
| T0978 | texto | En el escritorio | `Common.kt:89` |
| T0979 | texto | En la mesa | `Common.kt:89` |
| T0980 | texto | En el sillón | `Common.kt:89` |
| T0981 | texto | Junto a la cama | `Common.kt:89` |
| T0982 | texto | Junto a la tele | `Common.kt:89` |
| T0983 | texto | En el mesón de la cocina | `Common.kt:89` |
| T0984 | texto | Junto a la puerta | `Common.kt:89` |
| T0985 | texto | Dejar el teléfono en otro lugar | `Common.kt:110` |
| T0986 | texto | Moverte | `Sky.kt:132` |
| T0987 | texto | Leer y aprender | `Sky.kt:133` |
| T0988 | texto | Crear | `Sky.kt:134` |
| T0989 | texto | Jugar y disfrutar | `Sky.kt:135` |
| T0990 | texto | En casa | `Sky.kt:136` |
| T0991 | texto | Descansar | `Sky.kt:137` |
| T0992 | texto | Con otras personas | `Sky.kt:138` |
| T0993 | texto | Otras | `Sky.kt:139` |

## 34 Piezas de la interfaz

228 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0994 | texto | Nada | `Controls.kt:283` |
| T0995 | texto | Mucho | `Controls.kt:283` |
| T0996 | texto | 1 · [dato] | `Controls.kt:287` |
| T0997 | texto | 5 · [dato] | `Controls.kt:288` |
| T0998 | texto | Restar tiempo | `Controls.kt:340` |
| T0999 | texto | Sumar tiempo | `Controls.kt:342` |
| T1000 | texto | Restar | `Controls.kt:352` |
| T1001 | texto | Sumar | `Controls.kt:354` |
| T1002 | lector de pantalla | Borrar la búsqueda | `Fields.kt:136` |
| T1003 | texto | Accesibilidad | `KitIcons.kt:13` |
| T1004 | texto | Actividad | `KitIcons.kt:22` |
| T1005 | texto | Advertencia | `KitIcons.kt:30` |
| T1006 | texto | Agregar | `KitIcons.kt:38` |
| T1007 | texto | Ajustes | `KitIcons.kt:44` |
| T1008 | texto | Apps elegidas | `KitIcons.kt:52` |
| T1009 | texto | Avisos del teléfono | `KitIcons.kt:61` |
| T1010 | texto | Ayuda | `KitIcons.kt:68` |
| T1011 | texto | Batería del objeto | `KitIcons.kt:76` |
| T1012 | texto | Andar en bicicleta | `KitIcons.kt:84` |
| T1013 | texto | Borrar | `KitIcons.kt:93` |
| T1014 | texto | Buscar | `KitIcons.kt:102` |
| T1015 | texto | Calendario | `KitIcons.kt:109` |
| T1016 | texto | Cambié de idea | `KitIcons.kt:117` |
| T1017 | texto | Caminar | `KitIcons.kt:124` |
| T1018 | texto | Escribirle a alguien | `KitIcons.kt:133` |
| T1019 | texto | Cerrar sesión | `KitIcons.kt:140` |
| T1020 | texto | Cerrar | `KitIcons.kt:148` |
| T1021 | texto | Cocinar | `KitIcons.kt:154` |
| T1022 | texto | Código de participante | `KitIcons.kt:163` |
| T1023 | texto | Comencé | `KitIcons.kt:169` |
| T1024 | texto | Comentario | `KitIcons.kt:176` |
| T1025 | texto | Conexión | `KitIcons.kt:182` |
| T1026 | texto | Consentimiento | `KitIcons.kt:188` |
| T1027 | texto | Contraer | `KitIcons.kt:196` |
| T1028 | texto | Copiar | `KitIcons.kt:202` |
| T1029 | texto | Datos del estudio | `KitIcons.kt:209` |
| T1030 | texto | Decisión | `KitIcons.kt:217` |
| T1031 | texto | Acceso abierto | `KitIcons.kt:224` |
| T1032 | texto | Descargar | `KitIcons.kt:231` |
| T1033 | texto | La dejé para después | `KitIcons.kt:238` |
| T1034 | texto | Detener | `KitIcons.kt:246` |
| T1035 | texto | Dibujar | `KitIcons.kt:252` |
| T1036 | texto | Dormir | `KitIcons.kt:259` |
| T1037 | texto | Editar | `KitIcons.kt:266` |
| T1038 | texto | Hacer ejercicio | `KitIcons.kt:274` |
| T1039 | texto | Abrir fuera de la app | `KitIcons.kt:283` |
| T1040 | texto | Entrevistas | `KitIcons.kt:291` |
| T1041 | texto | Enviar | `KitIcons.kt:298` |
| T1042 | texto | Error | `KitIcons.kt:305` |
| T1043 | texto | Escribir | `KitIcons.kt:312` |
| T1044 | texto | Esperando | `KitIcons.kt:321` |
| T1045 | texto | Estirar | `KitIcons.kt:329` |
| T1046 | texto | Estrella llena | `KitIcons.kt:338` |
| T1047 | texto | Media estrella | `KitIcons.kt:344` |
| T1048 | texto | Estrella vacía | `KitIcons.kt:351` |
| T1049 | texto | Estudiar | `KitIcons.kt:357` |
| T1050 | texto | Expandir | `KitIcons.kt:365` |
| T1051 | texto | Exportar o compartir | `KitIcons.kt:371` |
| T1052 | texto | Filtrar | `KitIcons.kt:379` |
| T1053 | texto | Fotografiar | `KitIcons.kt:385` |
| T1054 | texto | Tocar un instrumento | `KitIcons.kt:394` |
| T1055 | texto | Hipótesis y prueba | `KitIcons.kt:404` |
| T1056 | texto | Historial | `KitIcons.kt:412` |
| T1057 | texto | Información | `KitIcons.kt:418` |
| T1058 | texto | Inicio | `KitIcons.kt:426` |
| T1059 | texto | Investigación | `KitIcons.kt:432` |
| T1060 | texto | Jugar un juego de mesa | `KitIcons.kt:441` |
| T1061 | texto | Leer | `KitIcons.kt:450` |
| T1062 | texto | Listo | `KitIcons.kt:457` |
| T1063 | texto | Jugar videojuegos | `KitIcons.kt:463` |
| T1064 | texto | Llamar a alguien | `KitIcons.kt:472` |
| T1065 | texto | Lugar | `KitIcons.kt:478` |
| T1066 | texto | Hacer manualidades | `KitIcons.kt:485` |
| T1067 | texto | Más opciones | `KitIcons.kt:493` |
| T1068 | texto | Menú | `KitIcons.kt:501` |
| T1069 | texto | Mostrar | `KitIcons.kt:507` |
| T1070 | texto | Escuchar música | `KitIcons.kt:514` |
| T1071 | texto | Objeto | `KitIcons.kt:522` |
| T1072 | texto | Ocultar | `KitIcons.kt:530` |
| T1073 | texto | Ordenar | `KitIcons.kt:538` |
| T1074 | texto | Parlante | `KitIcons.kt:546` |
| T1075 | texto | Pausar | `KitIcons.kt:554` |
| T1076 | texto | Perfil | `KitIcons.kt:560` |
| T1077 | texto | Permiso | `KitIcons.kt:567` |
| T1078 | texto | Pintar | `KitIcons.kt:574` |
| T1079 | texto | Cuidar las plantas | `KitIcons.kt:581` |
| T1080 | texto | Cómo empieza | `KitIcons.kt:590` |
| T1081 | texto | Privacidad | `KitIcons.kt:597` |
| T1082 | texto | Probar sonido | `KitIcons.kt:605` |
| T1083 | texto | Reportar un problema | `KitIcons.kt:613` |
| T1084 | texto | Reintentar | `KitIcons.kt:622` |
| T1085 | texto | Relevos | `KitIcons.kt:629` |
| T1086 | texto | Reproducir | `KitIcons.kt:638` |
| T1087 | texto | Salir | `KitIcons.kt:644` |
| T1088 | texto | Siguiente | `KitIcons.kt:654` |
| T1089 | texto | Silenciar | `KitIcons.kt:660` |
| T1090 | texto | Sin conexión | `KitIcons.kt:669` |
| T1091 | texto | Sincronizar datos | `KitIcons.kt:676` |
| T1092 | texto | Sistema phygital | `KitIcons.kt:683` |
| T1093 | texto | Este teléfono | `KitIcons.kt:691` |
| T1094 | texto | Tema claro u oscuro | `KitIcons.kt:698` |
| T1095 | texto | Tamaño del texto | `KitIcons.kt:705` |
| T1096 | texto | Tiempo | `KitIcons.kt:712` |
| T1097 | texto | Después de cuánto uso | `KitIcons.kt:721` |
| T1098 | texto | Persona | `KitIcons.kt:730` |
| T1099 | texto | Validación | `KitIcons.kt:737` |
| T1100 | texto | Volver | `KitIcons.kt:744` |
| T1101 | texto | Suena | `KitIcons.kt:750` |
| T1102 | texto | Ruta | `KitIcons.kt:760` |
| T1103 | texto | Avance | `KitIcons.kt:768` |
| T1104 | texto | Abrir | `KitIcons.kt:773` |
| T1105 | texto | Ajustes | `KitIcons.kt:778` |
| T1106 | texto | Actividades | `KitIcons.kt:786` |
| T1107 | texto | Elegido | `Lists.kt:183` |
| T1108 | texto | Sin completar | `Lists.kt:214` |
| T1109 | texto | Encendido | `Lists.kt:300` |
| T1110 | texto | Apagado | `Lists.kt:300` |
| T1111 | texto | Caminar | `Photos.kt:83` |
| T1112 | texto | Hacer ejercicio | `Photos.kt:84` |
| T1113 | texto | Leer | `Photos.kt:85` |
| T1114 | texto | Estudiar | `Photos.kt:86` |
| T1115 | texto | Dibujar | `Photos.kt:87` |
| T1116 | texto | Cocinar | `Photos.kt:88` |
| T1117 | texto | Ordenar | `Photos.kt:89` |
| T1118 | texto | Salir con el perro | `Photos.kt:90` |
| T1119 | texto | Manualidades | `Photos.kt:91` |
| T1120 | texto | Tocar guitarra | `Photos.kt:92` |
| T1121 | texto | Escribir | `Photos.kt:93` |
| T1122 | texto | Leer un libro | `Photos.kt:94` |
| T1123 | texto | Aprender | `Photos.kt:95` |
| T1124 | texto | Hacer pan | `Photos.kt:96` |
| T1125 | texto | Pintar | `Photos.kt:97` |
| T1126 | texto | Empezar | `Photos.kt:98` |
| T1127 | texto | Salir | `Photos.kt:99` |
| T1128 | texto | El tiempo en el teléfono | `Photos.kt:100` |
| T1129 | texto | Caras | `Photos.kt:107` |
| T1130 | texto | Animales | `Photos.kt:107` |
| T1131 | texto | Naturaleza | `Photos.kt:107` |
| T1132 | texto | Comida | `Photos.kt:107` |
| T1133 | texto | Actividades | `Photos.kt:107` |
| T1134 | texto | Cara sonriente | `Photos.kt:117` |
| T1135 | texto | Cara contenta | `Photos.kt:118` |
| T1136 | texto | Cara con lentes de sol | `Photos.kt:119` |
| T1137 | texto | Cara que abraza | `Photos.kt:120` |
| T1138 | texto | Cara con ojos de estrella | `Photos.kt:121` |
| T1139 | texto | Cara con corazones | `Photos.kt:122` |
| T1140 | texto | Cara de fiesta | `Photos.kt:123` |
| T1141 | texto | Cara pensativa | `Photos.kt:124` |
| T1142 | texto | Cara dormida | `Photos.kt:125` |
| T1143 | texto | Cara con sombrero de vaquero | `Photos.kt:126` |
| T1144 | texto | Robot | `Photos.kt:127` |
| T1145 | texto | Fantasma | `Photos.kt:128` |
| T1146 | texto | Perro | `Photos.kt:130` |
| T1147 | texto | Gato | `Photos.kt:131` |
| T1148 | texto | Zorro | `Photos.kt:132` |
| T1149 | texto | Tortuga | `Photos.kt:133` |
| T1150 | texto | Conejo | `Photos.kt:134` |
| T1151 | texto | Oso | `Photos.kt:135` |
| T1152 | texto | Panda | `Photos.kt:136` |
| T1153 | texto | Koala | `Photos.kt:137` |
| T1154 | texto | Tigre | `Photos.kt:138` |
| T1155 | texto | León | `Photos.kt:139` |
| T1156 | texto | Rana | `Photos.kt:140` |
| T1157 | texto | Pingüino | `Photos.kt:141` |
| T1158 | texto | Búho | `Photos.kt:142` |
| T1159 | texto | Abeja | `Photos.kt:143` |
| T1160 | texto | Mariposa | `Photos.kt:144` |
| T1161 | texto | Pulpo | `Photos.kt:145` |
| T1162 | texto | Ballena | `Photos.kt:146` |
| T1163 | texto | Unicornio | `Photos.kt:147` |
| T1164 | texto | Perezoso | `Photos.kt:148` |
| T1165 | texto | Dinosaurio | `Photos.kt:149` |
| T1166 | texto | Planta | `Photos.kt:151` |
| T1167 | texto | Girasol | `Photos.kt:152` |
| T1168 | texto | Ola | `Photos.kt:153` |
| T1169 | texto | Luna | `Photos.kt:154` |
| T1170 | texto | Sol | `Photos.kt:155` |
| T1171 | texto | Arcoíris | `Photos.kt:156` |
| T1172 | texto | Estrella | `Photos.kt:157` |
| T1173 | texto | Nube | `Photos.kt:158` |
| T1174 | texto | Copo de nieve | `Photos.kt:159` |
| T1175 | texto | Fuego | `Photos.kt:160` |
| T1176 | texto | Cactus | `Photos.kt:161` |
| T1177 | texto | Árbol | `Photos.kt:162` |
| T1178 | texto | Trébol de cuatro hojas | `Photos.kt:163` |
| T1179 | texto | Tulipán | `Photos.kt:164` |
| T1180 | texto | Hongo | `Photos.kt:165` |
| T1181 | texto | Montaña nevada | `Photos.kt:166` |
| T1182 | texto | Planeta con anillo | `Photos.kt:167` |
| T1183 | texto | Taza de café | `Photos.kt:169` |
| T1184 | texto | Pan | `Photos.kt:170` |
| T1185 | texto | Sartén con un huevo | `Photos.kt:171` |
| T1186 | texto | Palta | `Photos.kt:172` |
| T1187 | texto | Frutilla | `Photos.kt:173` |
| T1188 | texto | Sandía | `Photos.kt:174` |
| T1189 | texto | Limón | `Photos.kt:175` |
| T1190 | texto | Pizza | `Photos.kt:176` |
| T1191 | texto | Dona | `Photos.kt:177` |
| T1192 | texto | Helado | `Photos.kt:178` |
| T1193 | texto | Té de burbujas | `Photos.kt:179` |
| T1194 | texto | Zapatilla | `Photos.kt:181` |
| T1195 | texto | Libros | `Photos.kt:182` |
| T1196 | texto | Guitarra | `Photos.kt:183` |
| T1197 | texto | Paleta de pintura | `Photos.kt:184` |
| T1198 | texto | Ovillo de lana | `Photos.kt:185` |
| T1199 | texto | Bicicleta | `Photos.kt:186` |
| T1200 | texto | Cámara | `Photos.kt:187` |
| T1201 | texto | Audífonos | `Photos.kt:188` |
| T1202 | texto | Lápiz | `Photos.kt:189` |
| T1203 | texto | Pieza de rompecabezas | `Photos.kt:190` |
| T1204 | texto | Teclado de piano | `Photos.kt:191` |
| T1205 | texto | Pelota | `Photos.kt:192` |
| T1206 | texto | Pelota de básquetbol | `Photos.kt:193` |
| T1207 | texto | Raqueta de tenis | `Photos.kt:194` |
| T1208 | texto | Skate | `Photos.kt:195` |
| T1209 | texto | Dado | `Photos.kt:196` |
| T1210 | texto | Peón de ajedrez | `Photos.kt:197` |
| T1211 | texto | Control de videojuegos | `Photos.kt:198` |
| T1212 | texto | Volantín | `Photos.kt:199` |
| T1213 | texto | Micrófono | `Photos.kt:200` |
| T1214 | texto | Violín | `Photos.kt:201` |
| T1215 | texto | Telescopio | `Photos.kt:202` |
| T1216 | texto | Carpa | `Photos.kt:203` |
| T1217 | texto | Cohete | `Photos.kt:204` |
| T1218 | texto | Volver | `Screen.kt:95` |
| T1219 | texto | Inicio | `RelevoApp.kt:88` |
| T1220 | texto | Actividades | `RelevoApp.kt:89` |
| T1221 | texto | Perfil | `RelevoApp.kt:90` |

## Registro de cambios (disclaimer)

### 2026-11-05 — Textos de 4.2.1

- **Qué cambió:** se volvió a generar con el código de 4.2.1.
- **Cómo estaba antes:** no tenía los avisos que piden esperar a que termine el relevo ni las preguntas en los avisos de «Todo listo».
- **Por qué:** corrección de preparar desde una idea, reportada por el autor.

### 2026-11-05 — Textos de 4.2

- **Qué cambió:** se volvió a generar con el código de 4.2 (D-157).
- **Cómo estaba antes:** tenía los textos de 4.1, con «Para empezar», «Dónde empiezas», «Tuyas» y «¿Qué te ayudó?».
- **Por qué:** el autor cambió esos textos al ver la 4.1.

### 2026-11-05 — Textos de 4.1

- **Qué cambió:** se volvió a generar con el código de 4.1 (D-155 y D-156).
- **Cómo estaba antes:** tenía los textos de 3.3, con las notas de guía de la primera vez y los textos del aura.
- **Por qué:** 4.0 y 4.1 quitaron y acortaron textos; el inventario se rehace cada vez que cambian.

### 2026-10-24 — Creación

- **Qué cambió:** se creó el inventario, generado desde el código.
- **Cómo estaba antes:** los textos solo estaban dentro del código Kotlin.
- **Por qué:** el autor pidió estudiar y documentar cada palabra de la app antes de actualizar los textos.
