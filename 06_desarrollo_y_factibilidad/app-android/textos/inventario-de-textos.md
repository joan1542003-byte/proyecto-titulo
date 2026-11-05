# Inventario de textos de la app

> Se genera con `node extraer-textos.js` desde el código de la app. Para cambiar un texto se cambia el código y se vuelve a generar. Los datos variables van entre corchetes, como [nombre] o [duración].

**Total:** 1195 textos, 5315 palabras, en 30 pantallas o grupos.


## 01 Bienvenida

10 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0001 | título | Anota algo que quieres hacer | `FirstRunScreens.kt:76` |
| T0002 | texto | Cuando llevas un rato en el teléfono, Relevo suena donde empiezas. | `FirstRunScreens.kt:76` |
| T0003 | botón | Empezar | `FirstRunScreens.kt:77` |
| T0004 | lector de pantalla | Relevo | `FirstRunScreens.kt:82` |
| T0005 | texto | Un recordatorio físico preparado desde el teléfono | `FirstRunScreens.kt:87` |
| T0006 | actividad | Leer | `FirstRunScreens.kt:93` |
| T0007 | texto | Abrir el libro | `FirstRunScreens.kt:94` |
| T0008 | texto | Para empezar | `FirstRunScreens.kt:94` |
| T0009 | texto | En el velador | `FirstRunScreens.kt:95` |
| T0010 | texto | Dónde empiezas | `FirstRunScreens.kt:95` |

## 02 Cómo funciona Relevo (guía; desde la 1.0.0, en Perfil)

26 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0011 | texto | Entendido | `HowItWorksScreen.kt:79` |
| T0012 | guía | Esto es Relevo | `HowItWorksScreen.kt:87` |
| T0013 | guía | Un video corto: cómo se prepara un relevo y qué pasa cuando suena. | `HowItWorksScreen.kt:87` |
| T0014 | guía | ¿Te ha pasado? | `HowItWorksScreen.kt:90` |
| T0015 | guía | Relevo suena a tiempo, en el lugar donde empiezas, para que lo que querías hacer no quede esperando. | `HowItWorksScreen.kt:90` |
| T0016 | texto | Abres una app para descansar. | `HowItWorksScreen.kt:94` |
| T0017 | texto | Se pasa el rato y lo que querías hacer queda esperando. | `HowItWorksScreen.kt:96` |
| T0018 | guía | Cómo funciona | `HowItWorksScreen.kt:99` |
| T0019 | guía | Cuando suena, dices qué decidiste con un toque. Ninguna respuesta es mejor que otra. | `HowItWorksScreen.kt:99` |
| T0020 | fila | Cuenta tu tiempo | `HowItWorksScreen.kt:102` |
| T0021 | subtítulo | En las apps que eliges. | `HowItWorksScreen.kt:102` |
| T0022 | fila | Te recuerda cómo empezar | `HowItWorksScreen.kt:103` |
| T0023 | subtítulo | Algo pequeño, que toma segundos. | `HowItWorksScreen.kt:103` |
| T0024 | fila | Suena donde empiezas | `HowItWorksScreen.kt:104` |
| T0025 | subtítulo | En el Tag que dejas ahí, en el teléfono o en un dispositivo de audio. | `HowItWorksScreen.kt:104` |
| T0026 | fila | Tú decides | `HowItWorksScreen.kt:105` |
| T0027 | subtítulo | Empezar, dejarlo para después o cambiar de idea. | `HowItWorksScreen.kt:105` |
| T0028 | acción | Saltar | `HowItWorksScreen.kt:122` |
| T0029 | botón | Seguir | `HowItWorksScreen.kt:125` |
| T0030 | lector de pantalla | Video de 30 segundos que explica Relevo. Tócalo para [dato]. | `HowItWorksScreen.kt:206` |
| T0031 | texto | Activar el sonido | `HowItWorksScreen.kt:234` |
| T0032 | texto | Quitar el sonido | `HowItWorksScreen.kt:234` |
| T0033 | texto | Ver de nuevo | `HowItWorksScreen.kt:240` |
| T0034 | texto | Pausar | `HowItWorksScreen.kt:240` |
| T0035 | texto | Reproducir | `HowItWorksScreen.kt:240` |
| T0036 | texto | Queda lista en Inicio para cuando quieras. | `RelevoApp.kt:433` |

## 03 Antes de empezar (consentimiento)

52 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0037 | texto | Relevo cambió | `FirstRunScreens.kt:136` |
| T0038 | texto | Antes de empezar | `FirstRunScreens.kt:136` |
| T0039 | texto | Ya no hay una prueba de 21 días. Lee lo que aceptas; tu código y tus datos se mantienen. | `FirstRunScreens.kt:137` |
| T0040 | texto | Lee lo que aceptas. Puedes dejar de usarlo cuando quieras. | `FirstRunScreens.kt:138` |
| T0041 | texto | Acepto usar Relevo con estas condiciones | `FirstRunScreens.kt:150` |
| T0042 | texto | Aceptar y seguir | `FirstRunScreens.kt:152` |
| T0043 | texto | Aceptar y empezar | `FirstRunScreens.kt:152` |
| T0044 | validación | Espera a que termine el borrado de tus datos. | `FirstRunScreens.kt:153` |
| T0045 | validación | Marca «Acepto usar Relevo con estas condiciones» para seguir. | `FirstRunScreens.kt:154` |
| T0046 | texto | Ocultar | `FirstRunScreens.kt:157` |
| T0047 | texto | No acepto | `FirstRunScreens.kt:157` |
| T0048 | texto | Está bien. Sin aceptar, Relevo deja de contar. Tus datos anteriores siguen guardados hasta que pidas borrarlos, o hasta el 30 de diciembre de 2026; puedes borrarlos en Privacidad y datos. | `FirstRunScreens.kt:160` |
| T0049 | texto | Está bien. Sin aceptar, Relevo no se puede usar: puedes cerrar la app y desinstalarla. No se guardó nada tuyo. | `FirstRunScreens.kt:161` |
| T0050 | acción | Abrir Privacidad y datos | `FirstRunScreens.kt:164` |
| T0051 | texto | Relevo es parte de un proyecto de título de Diseño de la Universidad Diego Portales. Mientras lo usas, guarda lo que haces en Relevo con un código, para estudiar cómo funciona. Tu nombre se guarda aparte. Puedes borrar tus datos cuando quieras. | `FirstRunScreens.kt:169` |
| T0052 | aviso | Todavía se están borrando tus datos. Mientras tanto, Relevo no guarda nada. | `FirstRunScreens.kt:176` |
| T0053 | acción | Abrir Privacidad y datos | `FirstRunScreens.kt:177` |
| T0054 | texto | Cómo funciona | `FirstRunScreens.kt:187` |
| T0055 | texto | Preparas un relevo: qué quieres hacer, cómo empiezas, dónde y cuánto tiempo en tus apps. | `FirstRunScreens.kt:188` |
| T0056 | texto | Cuando sumas ese tiempo, suena unos 30 segundos en el Tag, en el teléfono o en un dispositivo de audio, y se apaga solo. | `FirstRunScreens.kt:189` |
| T0057 | texto | Después puedes responder preguntas de un toque. Todas se pueden saltar. | `FirstRunScreens.kt:190` |
| T0058 | texto | Tú decides | `FirstRunScreens.kt:192` |
| T0059 | texto | Usar Relevo es voluntario. | `FirstRunScreens.kt:193` |
| T0060 | texto | Puedes saltar preguntas, silenciar el sonido, quitar los permisos o dejar de usarlo cuando quieras, sin dar explicaciones. | `FirstRunScreens.kt:194` |
| T0061 | texto | Nadie juzga lo que eliges hacer. | `FirstRunScreens.kt:195` |
| T0062 | texto | El sonido puede molestar a otras personas: puedes detenerlo cuando quieras. | `FirstRunScreens.kt:196` |
| T0063 | texto | Qué se guarda | `FirstRunScreens.kt:198` |
| T0064 | texto | Un código al azar, en lugar de tu nombre. | `FirstRunScreens.kt:199` |
| T0065 | texto | Lo que preparas: la actividad, cómo empiezas, dónde, las apps y el tiempo. | `FirstRunScreens.kt:200` |
| T0066 | texto | Cuándo activas un relevo, a mano o solo, cuándo suena y qué respondes. | `FirstRunScreens.kt:201` |
| T0067 | texto | Cuánto usaste las apps elegidas 10 minutos antes y después de que sonara. | `FirstRunScreens.kt:202` |
| T0068 | texto | Cada día, cuánto usas las apps que elegiste en Relevo y el tiempo total del teléfono. | `FirstRunScreens.kt:203` |
| T0069 | texto | El modelo del teléfono, los permisos que diste y cómo usas Relevo: cuándo lo abres, qué pantallas ves, tus intereses, tus actividades y tus ajustes. | `FirstRunScreens.kt:204` |
| T0070 | texto | Tu nombre se guarda aparte, solo con tu código, para saber quién usa Relevo. No va junto a lo que haces. | `FirstRunScreens.kt:205` |
| T0071 | texto | Dónde se guarda | `FirstRunScreens.kt:207` |
| T0072 | texto | En el teléfono y en la base de datos del proyecto, en Supabase, un servicio para guardar datos en internet. Si no hay internet, se envía después. | `FirstRunScreens.kt:208` |
| T0073 | texto | Una copia sin tu nombre queda en la carpeta Documentos/Relevo del teléfono. Se borra si borras tus datos. | `FirstRunScreens.kt:209` |
| T0074 | texto | Esta instalación no tiene configurada la base de datos del proyecto: todo queda en este teléfono. | `FirstRunScreens.kt:210` |
| T0075 | texto | Qué no se ve | `FirstRunScreens.kt:211` |
| T0076 | texto | El permiso de Tiempo de uso podría mostrar otras apps. Relevo cuenta solo las que eliges; de las demás no guarda el nombre. | `FirstRunScreens.kt:212` |
| T0077 | texto | Con la activación automática encendida, Relevo mira qué app tienes abierta, solo su nombre, para saber cuándo empezar. Puedes apagarla cuando quieras. | `FirstRunScreens.kt:213` |
| T0078 | texto | Relevo no lee mensajes, fotos, búsquedas ni lo que hay en tu pantalla. | `FirstRunScreens.kt:214` |
| T0079 | texto | Mensajes | `FirstRunScreens.kt:216` |
| T0080 | texto | El autor del proyecto puede enviarte mensajes sobre Relevo. Llegan como notificación. | `FirstRunScreens.kt:217` |
| T0081 | texto | Se guarda cuándo llegó y cuándo abriste cada uno. | `FirstRunScreens.kt:218` |
| T0082 | texto | Tu código | `FirstRunScreens.kt:220` |
| T0083 | texto | El código reemplaza tu nombre, pero no vuelve anónimos los datos: juntando actividades, lugares y horarios, alguien podría reconocerte. | `FirstRunScreens.kt:221` |
| T0084 | texto | Hasta cuándo | `FirstRunScreens.kt:223` |
| T0085 | texto | Puedes borrar tus datos desde Perfil, en Privacidad y datos, o escribiendo a [correo del investigador] con tu código. | `FirstRunScreens.kt:224` |
| T0086 | texto | Si no lo haces antes, se borran a más tardar el 30 de diciembre de 2026. | `FirstRunScreens.kt:225` |
| T0087 | texto | Ocultar | `FirstRunScreens.kt:237` |
| T0088 | texto | Leer | `FirstRunScreens.kt:237` |

## 04 Para contar tu tiempo (permiso de la primera vez)

10 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0089 | título | Para contar tu tiempo | `FirstRunScreens.kt:283` |
| T0090 | subtítulo | Relevo cuenta minutos solo en las apps que elijas. No ve lo que haces en ellas. | `FirstRunScreens.kt:284` |
| T0091 | botón | Seguir | `FirstRunScreens.kt:286` |
| T0092 | botón | Dar el permiso | `FirstRunScreens.kt:287` |
| T0093 | texto | Tiempo de uso | `FirstRunScreens.kt:292` |
| T0094 | texto | Listo | `FirstRunScreens.kt:292` |
| T0095 | texto | Necesario para contar | `FirstRunScreens.kt:292` |
| T0096 | texto | Toca «Dar el permiso». | `FirstRunScreens.kt:301` |
| T0097 | texto | En la lista, busca Relevo. En Android, el permiso se llama «Acceso a datos de uso». | `FirstRunScreens.kt:302` |
| T0098 | texto | Actívalo y vuelve: Relevo sigue solo. | `FirstRunScreens.kt:303` |

## 05 Tu perfil (desde la 1.0.0, después del primer relevo)

21 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0099 | texto | ¿Cómo te llamas? | `ProfileScreens.kt:244` |
| T0100 | texto | ¿Con qué te identificas? | `ProfileScreens.kt:244` |
| T0101 | texto | ¿Qué te gustaría hacer más seguido? | `ProfileScreens.kt:244` |
| T0102 | texto | Ahora no | `ProfileScreens.kt:247` |
| T0103 | texto | Volver | `ProfileScreens.kt:247` |
| T0104 | acción | Saltar | `ProfileScreens.kt:250` |
| T0105 | botón | Seguir | `ProfileScreens.kt:253` |
| T0106 | validación | Escribe tu nombre. | `ProfileScreens.kt:253` |
| T0107 | botón | Seguir | `ProfileScreens.kt:254` |
| T0108 | validación | Elige un emoji o toca «Saltar». | `ProfileScreens.kt:254` |
| T0109 | botón | Listo | `ProfileScreens.kt:255` |
| T0110 | validación | Elige al menos un interés o toca «Saltar». | `ProfileScreens.kt:256` |
| T0111 | validación | Escribe cuál es tu otro interés. | `ProfileScreens.kt:257` |
| T0112 | campo | Tu nombre | `ProfileScreens.kt:277` |
| T0113 | ayuda del campo | Tu nombre o como te dicen | `ProfileScreens.kt:277` |
| T0114 | texto | Se guarda aparte, solo con tu código, y no junto a lo que haces en Relevo. | `ProfileScreens.kt:280` |
| T0115 | texto | Elige un emoji para tu perfil. | `ProfileScreens.kt:283` |
| T0116 | texto | Elige una o varias. | `ProfileScreens.kt:290` |
| T0117 | opción rápida | Otra | `ProfileScreens.kt:338` |
| T0118 | campo | ¿Cuál? | `ProfileScreens.kt:342` |
| T0119 | ayuda del campo | Ej.: tejer | `ProfileScreens.kt:342` |

## 07 Inicio

67 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0120 | texto | Muy mal | `Feedback.kt:50` |
| T0121 | texto | Mal | `Feedback.kt:51` |
| T0122 | texto | Normal | `Feedback.kt:52` |
| T0123 | texto | Bien | `Feedback.kt:53` |
| T0124 | texto | Muy bien | `Feedback.kt:54` |
| T0125 | texto | ¿Qué tal te va con Relevo? | `Feedback.kt:90` |
| T0126 | texto | Toca una cara. Ayuda a mejorar Relevo. | `Feedback.kt:91` |
| T0127 | acción | Contar más | `Feedback.kt:95` |
| T0128 | acción | Ahora no | `Feedback.kt:96` |
| T0129 | texto | Para que Relevo siga contando aunque pasen días, deja su batería en «Sin restricciones». | `HomeScreen.kt:117` |
| T0130 | texto | Hola de nuevo. | `HomeScreen.kt:166` |
| T0131 | texto | Hola de nuevo, [nombre]. | `HomeScreen.kt:166` |
| T0132 | texto | Hola. | `HomeScreen.kt:167` |
| T0133 | texto | Hola, [nombre]. | `HomeScreen.kt:168` |
| T0134 | texto | Tu relevo está en pausa. | `HomeScreen.kt:171` |
| T0135 | texto | Tu relevo está contando. | `HomeScreen.kt:172` |
| T0136 | texto | ¿Sigue siendo lo que quieres? | `HomeScreen.kt:173` |
| T0137 | texto | ¿Qué quieres hacer hoy? | `HomeScreen.kt:174` |
| T0138 | texto | Inicio | `HomeScreen.kt:186` |
| T0139 | guía | Empieza aquí: toca «Preparar un relevo». Relevo te guía paso a paso. | `HomeScreen.kt:193` |
| T0140 | texto | Completa tu perfil | `HomeScreen.kt:198` |
| T0141 | texto | Tu nombre, un emoji y lo que te gustaría hacer más seguido. Toma un minuto. | `HomeScreen.kt:199` |
| T0142 | botón | Completar mi perfil | `HomeScreen.kt:201` |
| T0143 | texto | ¿El tiempo te queda bien? | `HomeScreen.kt:207` |
| T0144 | texto | Ya sonó 3 veces. Si cuando suena ya llevas mucho rato en una app, prueba con menos tiempo. | `HomeScreen.kt:208` |
| T0145 | botón | Cambiar el tiempo | `HomeScreen.kt:211` |
| T0146 | acción | Está bien así | `HomeScreen.kt:212` |
| T0147 | texto | Cuando abras [apps elegidas], Relevo empieza a contar para «[actividad]». | `HomeScreen.kt:224` |
| T0148 | título | Se activa solo | `HomeScreen.kt:225` |
| T0149 | acción | Apagar | `HomeScreen.kt:226` |
| T0150 | texto | Horas sin sonar: vuelve a contar a las [dato]:00. | `HomeScreen.kt:236` |
| T0151 | aviso | Falta el permiso de Tiempo de uso. | `HomeScreen.kt:240` |
| T0152 | título | Relevo no puede contar el tiempo | `HomeScreen.kt:240` |
| T0153 | acción | Dar el permiso | `HomeScreen.kt:241` |
| T0154 | título | Batería | `HomeScreen.kt:246` |
| T0155 | acción | Cambiar la batería | `HomeScreen.kt:247` |
| T0156 | texto | ¿Tienes algo en mente? | `HomeScreen.kt:256` |
| T0157 | texto | Anótalo y Relevo suena cuando lleves un rato en el teléfono. | `HomeScreen.kt:257` |
| T0158 | botón | Preparar un relevo | `HomeScreen.kt:260` |
| T0159 | rótulo | Ideas | `HomeScreen.kt:266` |
| T0160 | rótulo | Ver todas | `HomeScreen.kt:266` |
| T0161 | rótulo | Tus actividades | `HomeScreen.kt:273` |
| T0162 | texto | Guarda lo que haces seguido y prepáralo en un toque. | `HomeScreen.kt:282` |
| T0163 | rótulo | La última vez | `HomeScreen.kt:288` |
| T0164 | lector de pantalla | Ajustes de tus relevos | `HomeScreen.kt:309` |
| T0165 | texto | Crear una actividad | `HomeScreen.kt:326` |
| T0166 | texto | ¿Quieres cambiar este paso por otra actividad? | `HomeScreen.kt:355` |
| T0167 | botón | Cambiar la actividad | `HomeScreen.kt:357` |
| T0168 | acción | Ahora no | `HomeScreen.kt:358` |
| T0169 | lector de pantalla | Ver tu relevo | `HomeScreen.kt:378` |
| T0170 | texto | Contando | `HomeScreen.kt:383` |
| T0171 | texto | En pausa | `HomeScreen.kt:383` |
| T0172 | texto | Faltan [tiempo que falta] | `HomeScreen.kt:390` |
| T0173 | rótulo | Para después | `HomeScreen.kt:403` |
| T0174 | lector de pantalla | Activar «[actividad]» | `HomeScreen.kt:406` |
| T0175 | botón | Activar ahora | `HomeScreen.kt:414` |
| T0176 | acción | Ahora no | `HomeScreen.kt:416` |
| T0177 | rótulo | La última vez | `HomeScreen.kt:453` |
| T0178 | botón | Preparar otra vez | `HomeScreen.kt:460` |
| T0179 | acción | Elegir otra | `HomeScreen.kt:464` |
| T0180 | acción | Ahora no | `HomeScreen.kt:466` |
| T0181 | rótulo | Tu siguiente paso | `HomeScreen.kt:475` |
| T0182 | lector de pantalla | Preparar «[actividad]» | `HomeScreen.kt:478` |
| T0183 | subtítulo | Para empezar | `HomeScreen.kt:483` |
| T0184 | subtítulo | Dónde empiezas | `HomeScreen.kt:484` |
| T0185 | botón | Preparar este paso | `HomeScreen.kt:488` |
| T0186 | acción | Preparar otro relevo | `HomeScreen.kt:490` |

## 08 Preparar un relevo

136 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0187 | texto | pila al [dato] %, cámbiala pronto | `TagProtocol.kt:39` |
| T0188 | texto | pila al [dato] % | `TagProtocol.kt:39` |
| T0189 | texto | Muy cerca | `TagProtocol.kt:83` |
| T0190 | texto | Cerca | `TagProtocol.kt:84` |
| T0191 | texto | Lejos | `TagProtocol.kt:85` |
| T0192 | texto | ¿Qué quieres hacer? | `PrepareScreen.kt:106` |
| T0193 | texto | ¿Cómo empiezas? | `PrepareScreen.kt:107` |
| T0194 | texto | ¿Dónde empiezas? | `PrepareScreen.kt:108` |
| T0195 | texto | ¿Cuándo suena? | `PrepareScreen.kt:109` |
| T0196 | texto | ¿Dónde suena? | `PrepareScreen.kt:110` |
| T0197 | texto | Todo listo | `PrepareScreen.kt:111` |
| T0198 | texto | Relevo propone «[actividad]». Puedes dejarla o escribir otra cosa que quieras hacer. | `PrepareScreen.kt:116` |
| T0199 | validación | Escribe algo que quieras hacer o toca una idea. Mientras más concreto, mejor: «leer 10 páginas» en vez de «leer más». | `PrepareScreen.kt:117` |
| T0200 | texto | Para empezar: «[primer paso]». Mientras más pequeño, menos cuesta empezar. | `PrepareScreen.kt:118` |
| T0201 | texto | Toca una opción o escribe la tuya: algo que tome segundos. | `PrepareScreen.kt:119` |
| T0202 | texto | Toca el lugar que más se parezca. Si ninguno calza, escríbelo como lo dirías en voz alta. | `PrepareScreen.kt:120` |
| T0203 | validación | Elige las apps donde se te pasa el rato. Para empezar, 15 minutos funciona bien: suena antes de que te pierdas en ellas. | `PrepareScreen.kt:121` |
| T0204 | validación | Elige con qué suena. El Tag se deja donde empiezas; la notificación suena en el teléfono, donde esté. | `PrepareScreen.kt:122` |
| T0205 | texto | Revisa que todo esté bien. Toca cualquier dato para cambiarlo y después «Activar el relevo». | `PrepareScreen.kt:123` |
| T0206 | validación | Escribe qué quieres hacer o toca una idea. | `PrepareScreen.kt:161` |
| T0207 | validación | Escribe cómo empiezas: lo primero que harías. | `PrepareScreen.kt:162` |
| T0208 | validación | Escribe dónde empiezas. | `PrepareScreen.kt:163` |
| T0209 | validación | Falta el permiso de Tiempo de uso. Tócalo arriba para darlo. | `PrepareScreen.kt:165` |
| T0210 | validación | Elige al menos una app que cuente. | `PrepareScreen.kt:166` |
| T0211 | validación | Elige con qué quieres que suene. | `PrepareScreen.kt:170` |
| T0212 | validación | Busca y elige tu Tag, o elige la notificación. | `PrepareScreen.kt:171` |
| T0213 | validación | Falta el permiso de Tiempo de uso. | `PrepareScreen.kt:175` |
| T0214 | validación | Falta elegir con qué suena. | `PrepareScreen.kt:176` |
| T0215 | validación | Falta elegir el Tag. | `PrepareScreen.kt:177` |
| T0216 | validación | Falta qué quieres hacer. | `PrepareScreen.kt:178` |
| T0217 | validación | Falta cómo empiezas. | `PrepareScreen.kt:179` |
| T0218 | validación | Falta dónde empiezas. | `PrepareScreen.kt:180` |
| T0219 | validación | Faltan las apps que cuentan. | `PrepareScreen.kt:181` |
| T0220 | texto | Cerrar | `PrepareScreen.kt:251` |
| T0221 | texto | Volver | `PrepareScreen.kt:251` |
| T0222 | texto | Guardar y activar | `PrepareScreen.kt:260` |
| T0223 | texto | Activar el relevo | `PrepareScreen.kt:260` |
| T0224 | texto | Listo | `PrepareScreen.kt:268` |
| T0225 | texto | Seguir | `PrepareScreen.kt:268` |
| T0226 | campo | Para empezar | `PrepareScreen.kt:291` |
| T0227 | ayuda del campo | O escríbelo aquí | `PrepareScreen.kt:291` |
| T0228 | consejo | Mientras más pequeño, menos cuesta empezar. | `PrepareScreen.kt:295` |
| T0229 | texto | Estás editando tu relevo. Al guardarlo vuelve a contar, con el tiempo que llevabas si las apps son las mismas. | `PrepareScreen.kt:303` |
| T0230 | texto | Qué quieres hacer | `PrepareScreen.kt:309` |
| T0231 | texto | Cómo empiezas | `PrepareScreen.kt:312` |
| T0232 | texto | Dónde empiezas | `PrepareScreen.kt:313` |
| T0233 | texto | Cuándo suena | `PrepareScreen.kt:314` |
| T0234 | texto | Con qué suena | `PrepareScreen.kt:315` |
| T0235 | texto | Guardar en tus actividades para la próxima vez | `PrepareScreen.kt:326` |
| T0236 | título | Batería | `PrepareScreen.kt:331` |
| T0237 | acción | Cambiar la batería | `PrepareScreen.kt:332` |
| T0238 | lector de pantalla | Cambiar la actividad | `PrepareScreen.kt:350` |
| T0239 | campo | Qué quieres hacer | `PrepareScreen.kt:357` |
| T0240 | ayuda del campo | Escríbelo o toca una idea | `PrepareScreen.kt:357` |
| T0241 | texto | Tus pasos | `PrepareScreen.kt:360` |
| T0242 | texto | Tus actividades | `PrepareScreen.kt:365` |
| T0243 | campo | Dónde empiezas | `PrepareScreen.kt:399` |
| T0244 | ayuda del campo | O escríbelo aquí | `PrepareScreen.kt:399` |
| T0245 | aviso | Relevo necesita el permiso de Tiempo de uso para contar. | `PrepareScreen.kt:415` |
| T0246 | título | Falta un permiso | `PrepareScreen.kt:415` |
| T0247 | acción | Dar el permiso | `PrepareScreen.kt:416` |
| T0248 | validación | Elige las apps | `PrepareScreen.kt:422` |
| T0249 | subtítulo | Apps que cuentan | `PrepareScreen.kt:423` |
| T0250 | texto | Después de [duración] | `PrepareScreen.kt:433` |
| T0251 | texto | Sumando las [número de apps] apps | `PrepareScreen.kt:434` |
| T0252 | texto | En esas apps | `PrepareScreen.kt:434` |
| T0253 | consejo | Al empezar, conviene un tiempo breve: suena antes de que te pierdas en las apps. Después lo ajustas. | `PrepareScreen.kt:445` |
| T0254 | subtítulo | Dónde empiezas | `PrepareScreen.kt:462` |
| T0255 | validación | Elige con qué suena. | `PrepareScreen.kt:466` |
| T0256 | texto | Suena [salida]. Si prefieres otra cosa, elígela. | `PrepareScreen.kt:466` |
| T0257 | opción | Tag | `PrepareScreen.kt:471` |
| T0258 | opción | Notificación | `PrepareScreen.kt:473` |
| T0259 | subtítulo | Suena en el teléfono, donde esté | `PrepareScreen.kt:474` |
| T0260 | opción | Dispositivo de audio | `PrepareScreen.kt:475` |
| T0261 | texto | Un parlante o audífonos, conectado | `PrepareScreen.kt:476` |
| T0262 | texto | Un parlante o audífonos Bluetooth | `PrepareScreen.kt:476` |
| T0263 | texto | Volumen | `PrepareScreen.kt:486` |
| T0264 | texto | El volumen multimedia del teléfono también cuenta. | `PrepareScreen.kt:486` |
| T0265 | texto | Suave | `PrepareScreen.kt:487` |
| T0266 | texto | Medio | `PrepareScreen.kt:487` |
| T0267 | texto | Fuerte | `PrepareScreen.kt:487` |
| T0268 | botón | Probar el sonido | `PrepareScreen.kt:490` |
| T0269 | texto | Así va a sonar. | `PrepareScreen.kt:494` |
| T0270 | texto | Déjalo encendido donde empiezas. Si se apaga solo, no sonará. | `PrepareScreen.kt:500` |
| T0271 | texto | Se deja donde empiezas | `PrepareScreen.kt:522` |
| T0272 | validación | Falta el permiso de dispositivos cercanos. | `PrepareScreen.kt:529` |
| T0273 | texto | El Bluetooth del teléfono está apagado. | `PrepareScreen.kt:530` |
| T0274 | texto | Ese aparato no acepta la orden de pitar: no es un Tag compatible. | `PrepareScreen.kt:531` |
| T0275 | texto | No apareció. Revisa que esté encendido y cerca. Si iSearching, la app que trae el Tag, está conectada a él, ciérrala: el Tag acepta una conexión a la vez. | `PrepareScreen.kt:532` |
| T0276 | texto | Buscar mi Tag | `PrepareScreen.kt:560` |
| T0277 | texto | Entendido | `PrepareScreen.kt:560` |
| T0278 | aviso | Relevo necesita el permiso de dispositivos cercanos para encontrar el Tag. Solo lo usa para eso. | `PrepareScreen.kt:581` |
| T0279 | título | Falta un permiso | `PrepareScreen.kt:581` |
| T0280 | acción | Abrir los ajustes de Relevo | `PrepareScreen.kt:582` |
| T0281 | aviso | Enciende el Bluetooth del teléfono para encontrar el Tag. | `PrepareScreen.kt:596` |
| T0282 | título | Bluetooth apagado | `PrepareScreen.kt:596` |
| T0283 | acción | Encender el Bluetooth | `PrepareScreen.kt:597` |
| T0284 | texto | Buscando Tags cerca. Si el tuyo está apagado, mantén apretado su botón 3 segundos, hasta que pite dos veces. | `PrepareScreen.kt:606` |
| T0285 | texto | Enciende el Tag: mantén apretado su botón 3 segundos, hasta que pite dos veces. Después toca el tuyo en la lista. | `PrepareScreen.kt:607` |
| T0286 | acción | Cómo usar el Tag | `PrepareScreen.kt:611` |
| T0287 | texto | Buscando… | `PrepareScreen.kt:614` |
| T0288 | texto | Buscar otra vez | `PrepareScreen.kt:614` |
| T0289 | texto | Buscar el Tag | `PrepareScreen.kt:614` |
| T0290 | texto | Para buscarlo, Android pide permiso para encontrar dispositivos cercanos. Relevo solo recuerda el Tag que elijas, en este teléfono; no usa tu ubicación. | `PrepareScreen.kt:620` |
| T0291 | texto | Aparatos cerca | `PrepareScreen.kt:627` |
| T0292 | texto | Tags cerca | `PrepareScreen.kt:627` |
| T0293 | texto | Toca tu Tag. Si es compatible, va a pitar una vez. | `PrepareScreen.kt:628` |
| T0294 | texto | Toca el tuyo. Va a pitar una vez para confirmarlo. | `PrepareScreen.kt:628` |
| T0295 | texto | No apareció ningún aparato con Bluetooth cerca. Revisa que el Tag esté encendido y cerca del teléfono, y búscalo otra vez. | `PrepareScreen.kt:637` |
| T0296 | texto | No apareció ningún Tag. Revisa que esté encendido y cerca del teléfono, y búscalo otra vez. Si iSearching, la app que trae el Tag, está conectada a él, ciérrala: el Tag acepta una conexión a la vez. | `PrepareScreen.kt:638` |
| T0297 | acción | Ver todos los aparatos cercanos | `PrepareScreen.kt:641` |
| T0298 | aviso | Ese aparato no aceptó la orden de pitar: no es un Tag compatible. Búscalo otra vez y elige otro. | `PrepareScreen.kt:646` |
| T0299 | texto | Sirve un iTag, el llavero que se usa con la app iSearching. Mientras tanto, elige «Notificación». | `PrepareScreen.kt:651` |
| T0300 | fila | ¿No tienes un Tag? | `PrepareScreen.kt:652` |
| T0301 | subtítulo | Consíguelo en Mercado Libre | `PrepareScreen.kt:652` |
| T0302 | texto | Probando de otra forma… | `PrepareScreen.kt:660` |
| T0303 | texto | Probando… | `PrepareScreen.kt:661` |
| T0304 | texto | Probar el Tag | `PrepareScreen.kt:662` |
| T0305 | texto | Pruébalo y di si lo escuchaste pitar: así Relevo sabe cómo hacerlo sonar. | `PrepareScreen.kt:670` |
| T0306 | texto | Así va a sonar: cuando se cumpla el tiempo, pitará seguido hasta 30 segundos. | `PrepareScreen.kt:683` |
| T0307 | texto | Para callarlo, toca su botón una vez. Si lo mantienes apretado, se apaga. | `PrepareScreen.kt:684` |
| T0308 | texto | Este Tag mantiene su alarma de alejamiento: si el teléfono se aleja mucho mientras espera, puede pitar solo. Para callarlo, tócalo una vez. | `PrepareScreen.kt:686` |
| T0309 | texto | Recibió la orden, pero no pitó. Apágalo y vuelve a encenderlo: mantén su botón apretado 3 segundos hasta que pite largo, y otra vez hasta que pite dos veces. Después pruébalo otra vez. Si sigue sin pitar, elige «Notificación». | `PrepareScreen.kt:690` |
| T0310 | título | El Tag no pitó | `PrepareScreen.kt:691` |
| T0311 | título | No sonó en el Tag | `PrepareScreen.kt:693` |
| T0312 | acción | Cómo usar el Tag | `PrepareScreen.kt:697` |
| T0313 | acción | Elegir otro Tag | `PrepareScreen.kt:699` |
| T0314 | texto | Déjalo encendido donde empiezas. Relevo se conecta a él al activar el relevo y, si no responde al cumplirse el tiempo, suena en el teléfono. El Tag pita con su propio volumen. | `PrepareScreen.kt:702` |
| T0315 | texto | ¿Lo escuchaste pitar? | `PrepareScreen.kt:714` |
| T0316 | texto | Se probó de otra forma. Debió pitar 3 segundos seguidos. | `PrepareScreen.kt:716` |
| T0317 | texto | Debió pitar 3 segundos seguidos. | `PrepareScreen.kt:716` |
| T0318 | botón | Sí, pitó | `PrepareScreen.kt:720` |
| T0319 | botón | No pitó | `PrepareScreen.kt:721` |
| T0320 | título | Elige las apps | `PrepareScreen.kt:732` |
| T0321 | botón | Listo | `PrepareScreen.kt:732` |
| T0322 | campo | Buscar | `PrepareScreen.kt:733` |

## 09 Cómo usar el Tag

22 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0323 | guía del Tag | Tu Tag | `TagGuide.kt:49` |
| T0324 | guía del Tag | Es un llavero Bluetooth con un solo botón. En muchos modelos el botón no se ve: es el centro de la cara de arriba, y al apretarlo firme se siente un clic. | `TagGuide.kt:49` |
| T0325 | guía del Tag | Enciéndelo | `TagGuide.kt:50` |
| T0326 | guía del Tag | Mantén apretado el botón 3 segundos, hasta que pite dos veces. Queda encendido: no hay que hacerlo cada vez. | `TagGuide.kt:50` |
| T0327 | guía del Tag | Búscalo en Relevo | `TagGuide.kt:51` |
| T0328 | guía del Tag | Con el Tag cerca del teléfono, toca «Buscar el Tag» y elígelo en la lista. Va a pitar una vez para confirmarlo. | `TagGuide.kt:51` |
| T0329 | guía del Tag | Déjalo donde empiezas | `TagGuide.kt:52` |
| T0330 | guía del Tag | Ponlo junto a lo que usas para empezar, como el libro o la guitarra. Sonará ahí cuando sumes el tiempo que elegiste en tus apps. | `TagGuide.kt:52` |
| T0331 | guía del Tag | Para callarlo, un toque | `TagGuide.kt:53` |
| T0332 | guía del Tag | Cuando suene, toca el botón una vez. No lo mantengas apretado: así se apaga. | `TagGuide.kt:53` |
| T0333 | guía del Tag | Para apagarlo | `TagGuide.kt:54` |
| T0334 | guía del Tag | Mantén apretado el botón 3 segundos, hasta que dé un pitido largo. Mientras uses Relevo, conviene dejarlo encendido. | `TagGuide.kt:54` |
| T0335 | guía del Tag | La pila dura meses | `TagGuide.kt:55` |
| T0336 | guía del Tag | Usa una pila de botón CR2032. Para cambiarla, abre la tapa por la ranura del borde con una uña o una moneda. | `TagGuide.kt:55` |
| T0337 | guía del Tag | Si no aparece o no pita | `TagGuide.kt:56` |
| T0338 | guía del Tag | El Tag se conecta a un solo teléfono a la vez: cierra iSearching, la app que trae el Tag, y, si lo usaste con otro teléfono, apaga el Bluetooth de ese teléfono. Si se conecta pero no pita, o si suena lento y sin parar, sácale la pila unos segundos y vuelve a ponerla. | `TagGuide.kt:56` |
| T0339 | texto | Entendido | `TagGuide.kt:64` |
| T0340 | título | Cómo usar el Tag | `TagGuide.kt:68` |
| T0341 | botón | Cerrar | `TagGuide.kt:68` |
| T0342 | texto | Paso [dato] de [dato] | `TagGuide.kt:83` |
| T0343 | botón | Atrás | `TagGuide.kt:93` |
| T0344 | texto | Siguiente | `TagGuide.kt:95` |

## 10 Hojas sobre Inicio

16 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0345 | texto | Tu primer relevo está activo | `HomeScreen.kt:427` |
| T0346 | texto | Usa el teléfono como siempre. Cuando sumes [duración] en [apps elegidas], sonará [lugar]. | `HomeScreen.kt:430` |
| T0347 | texto | Cuando suene, Relevo te dice qué hacer. Puedes ver o desactivar el relevo en Inicio. | `HomeScreen.kt:434` |
| T0348 | texto | Mientras tanto, completa tu perfil: tu nombre, un emoji y lo que te gustaría hacer más seguido. | `HomeScreen.kt:437` |
| T0349 | botón | Completar mi perfil | `HomeScreen.kt:439` |
| T0350 | botón | Ahora no | `HomeScreen.kt:441` |
| T0351 | botón | Entendido | `HomeScreen.kt:444` |
| T0352 | texto | 1 vez | `RouteScreens.kt:356` |
| T0353 | texto | Dijiste que empezaste «[actividad]» [dato]. | `RouteScreens.kt:358` |
| T0354 | texto | ¿Quieres probar el siguiente paso? | `RouteScreens.kt:360` |
| T0355 | botón | Probar el siguiente paso | `RouteScreens.kt:375` |
| T0356 | botón | Seguir en este paso | `RouteScreens.kt:376` |
| T0357 | texto | ¿Apagar el aviso semanal? | `RouteScreens.kt:385` |
| T0358 | texto | Puedes volver a encenderlo en Perfil, en Ajustes de tus relevos. | `RouteScreens.kt:387` |
| T0359 | botón | Apagarlo | `RouteScreens.kt:390` |
| T0360 | botón | Mantenerlo | `RouteScreens.kt:391` |

## 11 Tu relevo (contando)

30 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0361 | volver | Inicio | `HomeScreen.kt:520` |
| T0362 | texto | Contando | `HomeScreen.kt:521` |
| T0363 | texto | En pausa | `HomeScreen.kt:521` |
| T0364 | botón | Cambiar o desactivar | `HomeScreen.kt:524` |
| T0365 | texto | Faltan | `HomeScreen.kt:529` |
| T0366 | texto | en [apps elegidas] | `HomeScreen.kt:532` |
| T0367 | fragmento | las apps que elegiste | `HomeScreen.kt:532` |
| T0368 | texto | Horas sin sonar: vuelve a contar a las [dato]:00. | `HomeScreen.kt:537` |
| T0369 | aviso | Falta el permiso de Tiempo de uso. | `HomeScreen.kt:541` |
| T0370 | título | Relevo no puede contar el tiempo | `HomeScreen.kt:541` |
| T0371 | acción | Dar el permiso | `HomeScreen.kt:542` |
| T0372 | título | Batería | `HomeScreen.kt:547` |
| T0373 | acción | Cambiar la batería | `HomeScreen.kt:548` |
| T0374 | texto | Suena [dato], al sumar [duración]. | `HomeScreen.kt:559` |
| T0375 | texto | Se activó solo, con la activación automática. | `HomeScreen.kt:560` |
| T0376 | botón | Editar el relevo | `HomeScreen.kt:565` |
| T0377 | botón | Desactivar el relevo | `HomeScreen.kt:567` |
| T0378 | acción | Lo activé por error: eliminarlo | `HomeScreen.kt:570` |
| T0379 | texto | ¿Editar el relevo? | `HomeScreen.kt:576` |
| T0380 | texto | Puedes cambiar cualquier dato sin borrarlo. Mientras lo editas no cuenta; al activarlo otra vez, sigue con el tiempo que llevabas si las apps son las mismas. | `HomeScreen.kt:578` |
| T0381 | botón | Editar | `HomeScreen.kt:580` |
| T0382 | botón | Mantenerlo así | `HomeScreen.kt:582` |
| T0383 | texto | ¿Eliminar este relevo? | `HomeScreen.kt:587` |
| T0384 | texto | Deja de contar, no sonará y no queda en tus relevos. Sirve si lo activaste por error. | `HomeScreen.kt:589` |
| T0385 | botón | Eliminar | `HomeScreen.kt:591` |
| T0386 | botón | Mantenerlo | `HomeScreen.kt:593` |
| T0387 | texto | ¿Desactivar el relevo? | `HomeScreen.kt:598` |
| T0388 | texto | Deja de contar el tiempo y no sonará. Después puedes decir qué decidiste. | `HomeScreen.kt:600` |
| T0389 | botón | Desactivar | `HomeScreen.kt:602` |
| T0390 | botón | Mantenerlo | `HomeScreen.kt:604` |

## 12 Suena

14 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0391 | guía | Así suena Relevo. Toca «Silenciar y seguir» y después di qué decidiste. | `SignalScreens.kt:96` |
| T0392 | etiqueta | No sonó | `SignalScreens.kt:101` |
| T0393 | etiqueta | Suena | `SignalScreens.kt:102` |
| T0394 | etiqueta | Ya dejó de sonar | `SignalScreens.kt:103` |
| T0395 | texto | El Tag no respondió, así que sonó el teléfono. Revisa que esté encendido y cerca. | `SignalScreens.kt:114` |
| T0396 | texto | También puedes hacerlo sonar en el teléfono. | `SignalScreens.kt:119` |
| T0397 | título | Se cumplió el tiempo | `SignalScreens.kt:120` |
| T0398 | acción | Probar otra vez | `SignalScreens.kt:122` |
| T0399 | acción | Sonar en el teléfono | `SignalScreens.kt:123` |
| T0400 | texto | Ahora sonó. | `SignalScreens.kt:124` |
| T0401 | texto | Todavía no suena. | `SignalScreens.kt:124` |
| T0402 | texto | Silenciar y seguir | `SignalScreens.kt:128` |
| T0403 | texto | Seguir | `SignalScreens.kt:128` |
| T0404 | texto | Para callarlo en el Tag, toca su botón una vez. | `SignalScreens.kt:130` |

## 13 Preguntas y ¿Qué decidiste?

31 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0405 | texto | Bien | `Feedback.kt:43` |
| T0406 | texto | Normal | `Feedback.kt:44` |
| T0407 | texto | Mal | `Feedback.kt:45` |
| T0408 | etiqueta | Después de sonar | `SignalScreens.kt:180` |
| T0409 | acción | Saltar | `SignalScreens.kt:181` |
| T0410 | texto | Cuatro preguntas de un toque | `SignalScreens.kt:182` |
| T0411 | texto | ¿La dejas lista para después? | `SignalScreens.kt:182` |
| T0412 | texto | Queda en Inicio para activarla con un toque cuando quieras. No suena sola. | `SignalScreens.kt:183` |
| T0413 | botón | Seguir | `SignalScreens.kt:185` |
| T0414 | botón | Dejarla lista | `SignalScreens.kt:188` |
| T0415 | botón | No, gracias | `SignalScreens.kt:189` |
| T0416 | guía | Responde lo que pasó de verdad. No hay respuestas buenas ni malas: todas ayudan a mejorar Relevo. | `SignalScreens.kt:196` |
| T0417 | pregunta | ¿Notaste el sonido apenas empezó? | `SignalScreens.kt:201` |
| T0418 | texto | Enseguida | `SignalScreens.kt:202` |
| T0419 | texto | Un rato después | `SignalScreens.kt:202` |
| T0420 | texto | No lo noté | `SignalScreens.kt:202` |
| T0421 | pregunta | ¿Qué te pareció el sonido? | `SignalScreens.kt:205` |
| T0422 | pregunta | Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla? | `SignalScreens.kt:207` |
| T0423 | texto | Sí | `SignalScreens.kt:208` |
| T0424 | texto | A medias | `SignalScreens.kt:208` |
| T0425 | texto | No | `SignalScreens.kt:208` |
| T0426 | pregunta | ¿Recordaste cómo empezar? | `SignalScreens.kt:211` |
| T0427 | texto | Sí | `SignalScreens.kt:212` |
| T0428 | texto | No | `SignalScreens.kt:212` |
| T0429 | texto | Desactivaste el relevo. | `SignalScreens.kt:232` |
| T0430 | texto | Sonó en el teléfono. | `SignalScreens.kt:233` |
| T0431 | texto | Sonó [lugar]. | `SignalScreens.kt:234` |
| T0432 | texto | ¿Qué decidiste? | `SignalScreens.kt:239` |
| T0433 | opción | Comencé la actividad | `SignalScreens.kt:244` |
| T0434 | opción | La dejé para después | `SignalScreens.kt:245` |
| T0435 | opción | Cambié de idea | `SignalScreens.kt:246` |

## 14 Actividades (antes Ruta)

25 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0436 | título | Actividades | `RouteScreens.kt:101` |
| T0437 | segunda línea del título | para lo que te gustaría hacer más seguido. | `RouteScreens.kt:103` |
| T0438 | texto | Elige qué te gustaría hacer más seguido | `RouteScreens.kt:108` |
| T0439 | texto | Relevo propone pasos pequeños para empezar, y los puedes cambiar. | `RouteScreens.kt:109` |
| T0440 | botón | Elegir intereses | `RouteScreens.kt:112` |
| T0441 | texto | Esta ruta todavía no tiene pasos. | `RouteScreens.kt:136` |
| T0442 | botón | Agregar pasos | `RouteScreens.kt:138` |
| T0443 | fila | Agregar un paso | `RouteScreens.kt:145` |
| T0444 | texto | Tienes un relevo activo. Cuando termine, puedes preparar otro con este paso. | `RouteScreens.kt:149` |
| T0445 | botón | Preparar este paso | `RouteScreens.kt:151` |
| T0446 | texto | Paso [número] de [dato] | `RouteScreens.kt:169` |
| T0447 | botón | Preparar este paso | `RouteScreens.kt:179` |
| T0448 | texto | Pasar a este paso | `RouteScreens.kt:183` |
| T0449 | texto | Volver a este paso | `RouteScreens.kt:183` |
| T0450 | texto | Tus actividades | `RouteScreens.kt:193` |
| T0451 | texto | Guarda las que haces seguido | `RouteScreens.kt:194` |
| T0452 | texto | 1 actividad guardada | `RouteScreens.kt:194` |
| T0453 | acción | Editar los pasos | `RouteScreens.kt:204` |
| T0454 | acción | Cambiar intereses | `RouteScreens.kt:206` |
| T0455 | texto | Ahora | `RouteScreens.kt:214` |
| T0456 | texto | Paso actual | `RouteScreens.kt:249` |
| T0457 | texto | Paso actual | `RouteScreens.kt:250` |
| T0458 | texto | Hecho | `RouteScreens.kt:250` |
| T0459 | texto | Siguiente | `RouteScreens.kt:250` |
| T0460 | texto | Paso [número] | `RouteScreens.kt:250` |

## 15 Editar los pasos

22 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0461 | subtítulo | Toca un paso para cambiarlo. Con los tres puntos, puedes moverlo o borrarlo. | `RouteScreens.kt:275` |
| T0462 | volver | Cancelar | `RouteScreens.kt:276` |
| T0463 | botón | Guardar | `RouteScreens.kt:277` |
| T0464 | texto | No hay cambios que guardar. | `RouteScreens.kt:277` |
| T0465 | lector de pantalla | Más opciones de [actividad] | `RouteScreens.kt:289` |
| T0466 | texto | Editar | `RouteScreens.kt:294` |
| T0467 | texto | Subir | `RouteScreens.kt:295` |
| T0468 | texto | Bajar | `RouteScreens.kt:296` |
| T0469 | texto | Pasar a este paso | `RouteScreens.kt:298` |
| T0470 | texto | Volver a este paso | `RouteScreens.kt:298` |
| T0471 | texto | Borrar | `RouteScreens.kt:300` |
| T0472 | botón | Agregar un paso | `RouteScreens.kt:309` |
| T0473 | texto | Nuevo paso | `RouteScreens.kt:336` |
| T0474 | texto | Editar el paso | `RouteScreens.kt:336` |
| T0475 | campo | Actividad | `RouteScreens.kt:338` |
| T0476 | ayuda del campo | Ej.: caminar 30 minutos | `RouteScreens.kt:338` |
| T0477 | campo | Para empezar | `RouteScreens.kt:340` |
| T0478 | ayuda del campo | Ej.: ponerte las zapatillas | `RouteScreens.kt:340` |
| T0479 | campo | Dónde empiezas | `RouteScreens.kt:342` |
| T0480 | ayuda del campo | Ej.: junto a la puerta | `RouteScreens.kt:342` |
| T0481 | botón | Guardar el paso | `RouteScreens.kt:344` |
| T0482 | validación | Escribe la actividad del paso. | `RouteScreens.kt:345` |

## 16 Perfil

35 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0483 | texto | Tu semana | `ProfileScreens.kt:134` |
| T0484 | fila | Tus relevos | `ProfileScreens.kt:138` |
| T0485 | texto | relevo terminado | `ProfileScreens.kt:138` |
| T0486 | texto | relevos terminados | `ProfileScreens.kt:138` |
| T0487 | texto | Todavía no terminas ninguno | `ProfileScreens.kt:138` |
| T0488 | fila | Actividades | `ProfileScreens.kt:139` |
| T0489 | texto | Ahora: [dato] | `ProfileScreens.kt:139` |
| T0490 | texto | Tus pasos y tus actividades | `ProfileScreens.kt:139` |
| T0491 | fila | Apariencia y aura | `ProfileScreens.kt:143` |
| T0492 | subtítulo | Tu aura, tema y letra | `ProfileScreens.kt:143` |
| T0493 | fila | Ajustes de tus relevos | `ProfileScreens.kt:144` |
| T0494 | subtítulo | Activación automática, horas sin sonar y aviso semanal | `ProfileScreens.kt:144` |
| T0495 | fila | Permisos | `ProfileScreens.kt:145` |
| T0496 | subtítulo | Tiempo de uso, notificaciones y batería | `ProfileScreens.kt:145` |
| T0497 | fila | Privacidad y datos | `ProfileScreens.kt:146` |
| T0498 | fila | Cómo funciona Relevo | `ProfileScreens.kt:150` |
| T0499 | fila | Cómo usar el Tag | `ProfileScreens.kt:151` |
| T0500 | fila | Tu opinión | `ProfileScreens.kt:152` |
| T0501 | fila | Reportar un problema | `ProfileScreens.kt:153` |
| T0502 | texto | Relevo [dato] · Proyecto de Título de Diseño, Universidad Diego Portales | `ProfileScreens.kt:157` |
| T0503 | lector de pantalla | Editar el perfil | `ProfileScreens.kt:174` |
| T0504 | texto | Tu perfil | `ProfileScreens.kt:182` |
| T0505 | texto | Toca para editar tu perfil | `ProfileScreens.kt:183` |
| T0506 | texto | Esta semana todavía no preparaste relevos | `ProfileScreens.kt:191` |
| T0507 | texto | Preparaste 1 relevo | `ProfileScreens.kt:192` |
| T0508 | texto | Preparaste [dato] relevos | `ProfileScreens.kt:193` |
| T0509 | texto | ; empezaste 1 vez | `ProfileScreens.kt:196` |
| T0510 | texto | ; empezaste [dato] veces | `ProfileScreens.kt:197` |
| T0511 | texto | · elegiste [dato] por semana | `ProfileScreens.kt:199` |
| T0512 | título | ¿Qué te ayudó? | `ProfileScreens.kt:210` |
| T0513 | texto | Ayuda a mejorar Relevo. | `ProfileScreens.kt:211` |
| T0514 | campo | Tu respuesta | `ProfileScreens.kt:213` |
| T0515 | validación | Escribe aquí | `ProfileScreens.kt:213` |
| T0516 | botón | Enviar | `ProfileScreens.kt:215` |
| T0517 | validación | Escribe qué te ayudó. | `ProfileScreens.kt:215` |

## 17 Editar el perfil

14 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0518 | título | Tu perfil | `ProfileScreens.kt:357` |
| T0519 | volver | Cancelar | `ProfileScreens.kt:358` |
| T0520 | botón | Guardar | `ProfileScreens.kt:360` |
| T0521 | validación | Escribe tu nombre. | `ProfileScreens.kt:361` |
| T0522 | validación | Escribe cuál es tu otro interés. | `ProfileScreens.kt:362` |
| T0523 | texto | No hay cambios que guardar. | `ProfileScreens.kt:363` |
| T0524 | lector de pantalla | Cambiar el emoji | `ProfileScreens.kt:372` |
| T0525 | acción | Cambiar el emoji | `ProfileScreens.kt:375` |
| T0526 | campo | Tu nombre | `ProfileScreens.kt:378` |
| T0527 | ayuda del campo | Como quieras que te diga Relevo | `ProfileScreens.kt:378` |
| T0528 | rótulo | Intereses | `ProfileScreens.kt:380` |
| T0529 | subtítulo | Elige una o varias. | `ProfileScreens.kt:380` |
| T0530 | título | ¿Con qué te identificas? | `ProfileScreens.kt:384` |
| T0531 | botón | Listo | `ProfileScreens.kt:384` |

## 18 Ajustes de tus relevos (antes Avisos y resúmenes)

27 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0532 | título | Ajustes de tus relevos | `SettingsScreens.kt:116` |
| T0533 | volver | Perfil | `SettingsScreens.kt:116` |
| T0534 | texto | Activación automática | `SettingsScreens.kt:118` |
| T0535 | subtítulo | Cuando abras las apps de tu último relevo, empieza a contar solo. | `SettingsScreens.kt:119` |
| T0536 | texto | Primero prepara y termina un relevo: la activación automática repite ese. | `SettingsScreens.kt:123` |
| T0537 | texto | Mientras esté encendida, Relevo mira qué app tienes abierta —solo su nombre— para saber cuándo empezar. Después de cada relevo espera 30 minutos antes de activarse otra vez. | `SettingsScreens.kt:124` |
| T0538 | texto | Horas sin sonar | `SettingsScreens.kt:129` |
| T0539 | texto | De [dato]. En esas horas, Relevo no cuenta ni suena. | `SettingsScreens.kt:130` |
| T0540 | validación | Elige unas horas en que Relevo no cuenta ni suena, como la noche. | `SettingsScreens.kt:131` |
| T0541 | texto | Desde las [dato]:00 | `SettingsScreens.kt:135` |
| T0542 | texto | Hasta las [dato]:00 | `SettingsScreens.kt:136` |
| T0543 | texto | Un relevo activo sigue activo: vuelve a contar solo cuando terminan. | `SettingsScreens.kt:137` |
| T0544 | texto | Volumen | `SettingsScreens.kt:142` |
| T0545 | texto | En el teléfono y en un dispositivo de audio. El Tag pita con su propio volumen. | `SettingsScreens.kt:142` |
| T0546 | texto | Suave | `SettingsScreens.kt:143` |
| T0547 | texto | Medio | `SettingsScreens.kt:143` |
| T0548 | texto | Fuerte | `SettingsScreens.kt:143` |
| T0549 | texto | Resumen semanal | `SettingsScreens.kt:148` |
| T0550 | subtítulo | Lo que preparaste esta semana, en tu perfil. | `SettingsScreens.kt:149` |
| T0551 | texto | Aviso semanal | `SettingsScreens.kt:150` |
| T0552 | subtítulo | Si pasas una semana sin abrir Relevo, te avisa una vez. | `SettingsScreens.kt:153` |
| T0553 | texto | Mensaje después de responder | `SettingsScreens.kt:154` |
| T0554 | subtítulo | Unas palabras cuando dices qué decidiste. | `SettingsScreens.kt:155` |
| T0555 | texto | Veces por semana | `SettingsScreens.kt:156` |
| T0556 | subtítulo | Cuántas veces por semana quieres hacerlo. Aparece en tu resumen. | `SettingsScreens.kt:157` |
| T0557 | texto | Retomar | `SettingsScreens.kt:163` |
| T0558 | texto | Pausar | `SettingsScreens.kt:163` |

## 19 Apariencia

16 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0559 | título | Apariencia y aura | `SettingsScreens.kt:181` |
| T0560 | volver | Perfil | `SettingsScreens.kt:181` |
| T0561 | texto | Tu aura | `SettingsScreens.kt:187` |
| T0562 | subtítulo | Aparece mientras cuenta un relevo. Es de la pantalla: el Tag no se ilumina. | `SettingsScreens.kt:188` |
| T0563 | texto | Intensidad | `SettingsScreens.kt:192` |
| T0564 | texto | Cuánto color tiene el aura. | `SettingsScreens.kt:192` |
| T0565 | texto | Suave | `SettingsScreens.kt:193` |
| T0566 | texto | Media | `SettingsScreens.kt:193` |
| T0567 | texto | Viva | `SettingsScreens.kt:193` |
| T0568 | texto | Tema | `SettingsScreens.kt:199` |
| T0569 | texto | Claro, oscuro o como esté tu teléfono. | `SettingsScreens.kt:199` |
| T0570 | texto | Claro | `SettingsScreens.kt:200` |
| T0571 | texto | Oscuro | `SettingsScreens.kt:200` |
| T0572 | texto | Automático | `SettingsScreens.kt:200` |
| T0573 | texto | Letra grande | `SettingsScreens.kt:204` |
| T0574 | subtítulo | Se suma al tamaño que usas en el teléfono. | `SettingsScreens.kt:204` |

## 20 Permisos

15 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0575 | título | Permisos | `SettingsScreens.kt:214` |
| T0576 | volver | Perfil | `SettingsScreens.kt:214` |
| T0577 | texto | Tiempo de uso es necesario para contar. Lo demás es opcional, pero ayuda. | `SettingsScreens.kt:216` |
| T0578 | fila | Tiempo de uso | `SettingsScreens.kt:217` |
| T0579 | subtítulo | Para contar el tiempo en las apps que elijas. En Android: «Acceso a datos de uso». | `SettingsScreens.kt:217` |
| T0580 | texto | Permitido | `SettingsScreens.kt:217` |
| T0581 | validación | Falta | `SettingsScreens.kt:217` |
| T0582 | fila | Notificaciones | `SettingsScreens.kt:218` |
| T0583 | subtítulo | Para mostrar cuando suena, aunque estés en otra app. | `SettingsScreens.kt:218` |
| T0584 | texto | Permitidas | `SettingsScreens.kt:218` |
| T0585 | texto | Apagadas | `SettingsScreens.kt:218` |
| T0586 | fila | Batería | `SettingsScreens.kt:220` |
| T0587 | subtítulo | Para que Android no detenga a Relevo. En Android: «Sin restricciones». | `SettingsScreens.kt:220` |
| T0588 | texto | Sin restricciones | `SettingsScreens.kt:220` |
| T0589 | texto | Optimizada | `SettingsScreens.kt:220` |

## 21 Tus relevos

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0590 | título | Tus relevos | `SettingsScreens.kt:229` |
| T0591 | volver | Perfil | `SettingsScreens.kt:229` |
| T0592 | texto | Aquí verás los relevos que termines. | `SettingsScreens.kt:231` |
| T0593 | texto | Hoy | `SettingsScreens.kt:237` |
| T0594 | texto | Ayer | `SettingsScreens.kt:238` |
| T0595 | texto | Sonó | `SettingsScreens.kt:245` |
| T0596 | texto | Terminó antes de sonar | `SettingsScreens.kt:245` |

## 22 Tus actividades

8 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0597 | título | Tus actividades | `SettingsScreens.kt:271` |
| T0598 | segunda línea del título | listas para prepararlas en un toque. | `SettingsScreens.kt:272` |
| T0599 | volver | Actividades | `SettingsScreens.kt:273` |
| T0600 | botón | Crear una actividad | `SettingsScreens.kt:274` |
| T0601 | texto | Todavía no tienes actividades | `SettingsScreens.kt:278` |
| T0602 | texto | Anota qué haces, cómo empiezas y dónde. Después la encuentras en Inicio y al preparar un relevo. | `SettingsScreens.kt:279` |
| T0603 | botón | Preparar un relevo | `SettingsScreens.kt:302` |
| T0604 | botón | Editar | `SettingsScreens.kt:304` |

## 23 Crear o editar una actividad

28 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0605 | texto | Nueva actividad | `SettingsScreens.kt:331` |
| T0606 | texto | Editar la actividad | `SettingsScreens.kt:331` |
| T0607 | volver | Cancelar | `SettingsScreens.kt:332` |
| T0608 | botón | Guardar | `SettingsScreens.kt:334` |
| T0609 | validación | Escribe el nombre de la actividad. | `SettingsScreens.kt:337` |
| T0610 | texto | El nombre es muy largo: usa hasta 60 caracteres. | `SettingsScreens.kt:338` |
| T0611 | texto | Ya existe una actividad con ese nombre. | `SettingsScreens.kt:339` |
| T0612 | validación | Escribe cómo empiezas. | `SettingsScreens.kt:340` |
| T0613 | validación | Escribe dónde empiezas. | `SettingsScreens.kt:341` |
| T0614 | texto | Tu actividad | `SettingsScreens.kt:346` |
| T0615 | lector de pantalla | Cambiar la imagen | `SettingsScreens.kt:346` |
| T0616 | acción | Cambiar la imagen | `SettingsScreens.kt:348` |
| T0617 | campo | Actividad | `SettingsScreens.kt:350` |
| T0618 | ayuda del campo | Ej.: practicar guitarra | `SettingsScreens.kt:350` |
| T0619 | texto | Ya tienes una actividad con ese nombre. | `SettingsScreens.kt:351` |
| T0620 | campo | Para empezar | `SettingsScreens.kt:353` |
| T0621 | ayuda del campo | Ej.: sacar la guitarra del estuche | `SettingsScreens.kt:353` |
| T0622 | campo | Dónde empiezas | `SettingsScreens.kt:355` |
| T0623 | ayuda del campo | Ej.: junto a la guitarra | `SettingsScreens.kt:355` |
| T0624 | botón | Borrar la actividad | `SettingsScreens.kt:358` |
| T0625 | título | Elige una imagen | `SettingsScreens.kt:362` |
| T0626 | botón | Listo | `SettingsScreens.kt:362` |
| T0627 | texto | Fotos | `SettingsScreens.kt:363` |
| T0628 | texto | Iconos | `SettingsScreens.kt:372` |
| T0629 | texto | ¿Borrar «[nombre]»? | `SettingsScreens.kt:384` |
| T0630 | texto | Se quita de tus actividades. Los relevos que ya hiciste se mantienen. | `SettingsScreens.kt:386` |
| T0631 | botón | Borrar | `SettingsScreens.kt:388` |
| T0632 | botón | Cancelar | `SettingsScreens.kt:390` |

## 24 Privacidad y datos

29 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0633 | texto | Todo está enviado. | `Common.kt:325` |
| T0634 | texto | Algunos datos se enviarán cuando haya internet. | `Common.kt:325` |
| T0635 | texto | Último envío: [dato]. | `Common.kt:326` |
| T0636 | texto | En Documentos/Relevo. Última copia: [dato]. | `Common.kt:331` |
| T0637 | texto | Se crea en Documentos/Relevo con el primer relevo. | `Common.kt:331` |
| T0638 | texto | Borrando tus datos… | `RelevoViewModel.kt:1055` |
| T0639 | texto | Relevo dejó de guardar datos, pero no se pudo confirmar el borrado en la base del proyecto. Tus datos siguen en el teléfono. Prueba otra vez o escribe a [correo del investigador]. | `RelevoViewModel.kt:1099` |
| T0640 | texto | Tus datos se borraron. Si quieres volver a usar Relevo, tendrás que aceptar otra vez. | `RelevoViewModel.kt:1149` |
| T0641 | texto | Tus datos quedaron en el archivo que elegiste. | `SettingsScreens.kt:420` |
| T0642 | texto | No se pudo guardar el archivo. Prueba otra vez. | `SettingsScreens.kt:420` |
| T0643 | título | Privacidad y datos | `SettingsScreens.kt:423` |
| T0644 | volver | Perfil | `SettingsScreens.kt:423` |
| T0645 | botón | Volver a comenzar | `SettingsScreens.kt:424` |
| T0646 | texto | Relevo guarda lo que haces en Relevo con un código; tu nombre se guarda aparte, solo con ese código. No ve lo que haces dentro de otras apps. Si no borras tus datos antes, se borran el 30 de diciembre de 2026. | `SettingsScreens.kt:427` |
| T0647 | fila | Tu código | `SettingsScreens.kt:434` |
| T0648 | texto | Sin código | `SettingsScreens.kt:434` |
| T0649 | fila | Lo que aceptaste | `SettingsScreens.kt:437` |
| T0650 | fila | Datos enviados | `SettingsScreens.kt:438` |
| T0651 | fila | Copia en el teléfono | `SettingsScreens.kt:439` |
| T0652 | texto | Primero se borra en la base del proyecto. Si no se puede, Relevo deja de guardar datos y conserva lo del teléfono para intentarlo otra vez. | `SettingsScreens.kt:443` |
| T0653 | fila | Descargar mis datos | `SettingsScreens.kt:444` |
| T0654 | subtítulo | Un archivo con todo lo guardado en el teléfono. | `SettingsScreens.kt:444` |
| T0655 | fila | Borrar mis datos | `SettingsScreens.kt:446` |
| T0656 | subtítulo | También dejas de usar Relevo. | `SettingsScreens.kt:446` |
| T0657 | texto | ¿Dudas, o prefieres pedir el borrado por correo? Escribe a [correo del investigador] con tu código. | `SettingsScreens.kt:451` |
| T0658 | texto | ¿Borrar tus datos? | `SettingsScreens.kt:461` |
| T0659 | texto | Se borran tus relevos, actividades, perfil, pasos y respuestas, también en la base del proyecto y en la copia de Documentos/Relevo. Relevo deja de contar. | `SettingsScreens.kt:463` |
| T0660 | botón | Borrar mis datos | `SettingsScreens.kt:465` |
| T0661 | botón | Cancelar | `SettingsScreens.kt:467` |

## 25 Lo que aceptaste

3 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0662 | título | Lo que aceptaste | `FirstRunScreens.kt:262` |
| T0663 | subtítulo | Aceptaste usar Relevo con este texto. | `FirstRunScreens.kt:262` |
| T0664 | volver | Privacidad y datos | `FirstRunScreens.kt:262` |

## 29 Tu opinión

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0665 | título | Tu opinión | `SettingsScreens.kt:482` |
| T0666 | subtítulo | ¿Cómo te resultó Relevo? | `SettingsScreens.kt:483` |
| T0667 | volver | Cerrar | `SettingsScreens.kt:484` |
| T0668 | botón | Enviar | `SettingsScreens.kt:485` |
| T0669 | validación | Elige las estrellas o escribe un comentario. | `SettingsScreens.kt:485` |
| T0670 | campo | Comentario | `SettingsScreens.kt:489` |
| T0671 | texto | ¿Qué cambiarías? | `SettingsScreens.kt:489` |

## 30 Reportar un problema

8 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0672 | título | Reportar un problema | `SettingsScreens.kt:499` |
| T0673 | volver | Cerrar | `SettingsScreens.kt:500` |
| T0674 | botón | Enviar | `SettingsScreens.kt:501` |
| T0675 | validación | Escribe qué pasó. | `SettingsScreens.kt:501` |
| T0676 | campo | ¿Qué pasó? | `SettingsScreens.kt:503` |
| T0677 | texto | Ej.: el Tag no sonó | `SettingsScreens.kt:503` |
| T0678 | texto | Adjuntar datos técnicos | `SettingsScreens.kt:513` |
| T0679 | texto | Versión, permisos y estado del envío. Nada de lo que haces en tus apps. | `SettingsScreens.kt:514` |

## 31 Notificaciones

33 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0680 | texto | Tu relevo está contando | `AppUsageMonitorService.kt:126` |
| T0681 | notificación | Suena al sumar [dato] min en tus apps | `AppUsageMonitorService.kt:126` |
| T0682 | texto | Tu relevo está en pausa | `AppUsageMonitorService.kt:127` |
| T0683 | notificación | Horas sin sonar, hasta las [dato]:00 | `AppUsageMonitorService.kt:127` |
| T0684 | texto | Activación automática | `AppUsageMonitorService.kt:128` |
| T0685 | notificación | Cuenta cuando abras las apps de tu último relevo | `AppUsageMonitorService.kt:128` |
| T0686 | texto | Tu relevo está contando | `AppUsageMonitorService.kt:129` |
| T0687 | notificación | El Tag no responde; si sigue así, sonará el teléfono | `AppUsageMonitorService.kt:129` |
| T0688 | notificación: título | Tu relevo dejó de contar | `AppUsageMonitorService.kt:392` |
| T0689 | notificación: texto | Falta el permiso de Tiempo de uso | `AppUsageMonitorService.kt:393` |
| T0690 | notificación: texto | Falta el permiso de Tiempo de uso. Abre Relevo para darlo o para desactivar el relevo. | `AppUsageMonitorService.kt:394` |
| T0691 | lector de pantalla | Muestra que tu relevo está contando o que la activación automática está encendida. | `AppUsageMonitorService.kt:416` |
| T0692 | lector de pantalla | Aparece cuando sumas el tiempo que elegiste. El sonido lo pone Relevo. | `AppUsageMonitorService.kt:421` |
| T0693 | lector de pantalla | Avisa si tu relevo dejó de contar, por ejemplo al quitar un permiso. | `AppUsageMonitorService.kt:428` |
| T0694 | notificación: título | Relevo | `AppUsageMonitorService.kt:442` |
| T0695 | texto | No sonó en [salida]. Abre Relevo para revisarlo | `AppUsageMonitorService.kt:447` |
| T0696 | texto | El Tag no respondió y sonó el teléfono | `AppUsageMonitorService.kt:448` |
| T0697 | texto | Para empezar: [dato] | `AppUsageMonitorService.kt:449` |
| T0698 | notificación | Relevo | `AppUsageMonitorService.kt:456` |
| T0699 | texto | el Tag | `AppUsageMonitorService.kt:471` |
| T0700 | texto | el dispositivo de audio | `AppUsageMonitorService.kt:472` |
| T0701 | texto | el teléfono | `AppUsageMonitorService.kt:473` |
| T0702 | notificación | Suena tu relevo | `AppUsageMonitorService.kt:478` |
| T0703 | lector de pantalla | Mensajes del autor del proyecto sobre Relevo. | `ProjectMessages.kt:116` |
| T0704 | notificación: título | Relevo | `ProjectMessages.kt:128` |
| T0705 | notificación: texto | Tienes un mensaje nuevo | `ProjectMessages.kt:129` |
| T0706 | notificación | ¿Quieres preparar un relevo esta semana? | `ReturnNotice.kt:31` |
| T0707 | lector de pantalla | Una vez por semana como máximo, si no abriste Relevo. Se apaga en Perfil, en Ajustes de tus relevos. | `ReturnNotice.kt:67` |
| T0708 | notificación | ¿Sigue en pie [actividad] esta semana? | `ReturnNotice.kt:72` |
| T0709 | notificación: título | Relevo | `ReturnNotice.kt:76` |
| T0710 | notificación: título | Relevo | `ReturnNotice.kt:93` |
| T0711 | notificación: botón | Preparar | `ReturnNotice.kt:96` |
| T0712 | notificación: botón | Ahora no | `ReturnNotice.kt:97` |

## 32 Textos compartidos

25 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0713 | texto | Para empezar: [primer paso], [lugar]. | `Common.kt:255` |
| T0714 | texto | Para empezar: [primer paso]. | `Common.kt:256` |
| T0715 | texto | Empieza [lugar]. | `Common.kt:257` |
| T0716 | texto | donde lo dejaste | `Common.kt:265` |
| T0717 | texto | detrás | `Common.kt:267` |
| T0718 | texto | en «[dato]» | `Common.kt:268` |
| T0719 | texto | Tag | `Common.kt:300` |
| T0720 | texto | Notificación | `Common.kt:301` |
| T0721 | texto | Dispositivo de audio | `Common.kt:302` |
| T0722 | texto | en el Tag | `Common.kt:307` |
| T0723 | texto | en el teléfono | `Common.kt:308` |
| T0724 | texto | en el dispositivo de audio | `Common.kt:309` |
| T0725 | texto | No sonó en el Tag. Revisa que esté encendido y cerca del teléfono. | `Common.kt:319` |
| T0726 | texto | No sonó en el teléfono. Revisa el volumen multimedia. | `Common.kt:320` |
| T0727 | texto | No sonó en el dispositivo de audio. Revisa que esté encendido y conectado. | `Common.kt:321` |
| T0728 | texto | Dijiste que empezaste | `Common.kt:343` |
| T0729 | texto | La dejaste para después | `Common.kt:344` |
| T0730 | texto | Cambiaste de idea | `Common.kt:345` |
| T0731 | texto | Queda anotado. Gracias por decirlo. | `Common.kt:361` |
| T0732 | texto | Queda anotado. Puedes prepararlo cuando quieras. | `Common.kt:362` |
| T0733 | texto | Está bien. Puedes elegir otra actividad cuando quieras. | `Common.kt:363` |
| T0734 | texto | , en el teléfono | `Common.kt:381` |
| T0735 | texto | , donde empiezas | `Common.kt:382` |
| T0736 | texto | en el teléfono | `Common.kt:387` |
| T0737 | texto | Código de participación | `SettingsScreens.kt:473` |

## 33 Ideas, sugerencias y rutas

232 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0738 | texto | Dormir a tiempo | `Route.kt:59` |
| T0739 | texto | Acostarte sin el teléfono | `Route.kt:60` |
| T0740 | texto | Dejar el teléfono cargando lejos de la cama | `Route.kt:60` |
| T0741 | texto | Junto al cargador | `Route.kt:60` |
| T0742 | texto | Leer un rato antes de dormir | `Route.kt:61` |
| T0743 | texto | Dejar el libro en el velador | `Route.kt:61` |
| T0744 | texto | En el velador | `Route.kt:61` |
| T0745 | texto | Acostarte a la misma hora | `Route.kt:62` |
| T0746 | texto | Apagar la luz grande | `Route.kt:62` |
| T0747 | texto | Junto al interruptor | `Route.kt:62` |
| T0748 | texto | Leer | `Route.kt:65` |
| T0749 | texto | Leer 10 páginas | `Route.kt:66` |
| T0750 | texto | Abrir el libro | `Route.kt:66` |
| T0751 | texto | En el velador | `Route.kt:66` |
| T0752 | texto | Leer un capítulo de manga | `Route.kt:67` |
| T0753 | texto | Sacar el tomo del estante | `Route.kt:67` |
| T0754 | texto | Junto al estante | `Route.kt:67` |
| T0755 | texto | Leer un capítulo | `Route.kt:68` |
| T0756 | texto | Abrir el libro en el marcador | `Route.kt:68` |
| T0757 | texto | En el velador | `Route.kt:68` |
| T0758 | texto | Hacer ejercicio | `Route.kt:71` |
| T0759 | texto | Hacer una serie corta | `Route.kt:72` |
| T0760 | texto | Ponerte ropa cómoda | `Route.kt:72` |
| T0761 | texto | Junto al clóset | `Route.kt:72` |
| T0762 | texto | Entrenar 20 minutos | `Route.kt:73` |
| T0763 | texto | Estirar la colchoneta | `Route.kt:73` |
| T0764 | texto | Donde guardas la colchoneta | `Route.kt:73` |
| T0765 | texto | Ir a entrenar | `Route.kt:74` |
| T0766 | texto | Preparar el bolso | `Route.kt:74` |
| T0767 | texto | Junto a la puerta | `Route.kt:74` |
| T0768 | texto | Salir en bicicleta | `Route.kt:77` |
| T0769 | texto | Dar una vuelta corta | `Route.kt:78` |
| T0770 | texto | Sacar la bici | `Route.kt:78` |
| T0771 | texto | Junto a la puerta | `Route.kt:78` |
| T0772 | texto | Andar 30 minutos | `Route.kt:79` |
| T0773 | texto | Inflar las ruedas | `Route.kt:79` |
| T0774 | texto | Junto a la bici | `Route.kt:79` |
| T0775 | texto | Ir en bici a algún lugar | `Route.kt:80` |
| T0776 | texto | Ponerte el casco | `Route.kt:80` |
| T0777 | texto | Junto a la puerta | `Route.kt:80` |
| T0778 | texto | Pasear o jugar con tu perro | `Route.kt:83` |
| T0779 | texto | Salir 10 minutos con el perro | `Route.kt:84` |
| T0780 | texto | Tomar la correa | `Route.kt:84` |
| T0781 | texto | Junto a la puerta | `Route.kt:84` |
| T0782 | texto | Jugar con el perro | `Route.kt:85` |
| T0783 | texto | Sacar su pelota | `Route.kt:85` |
| T0784 | texto | Donde está su pelota | `Route.kt:85` |
| T0785 | texto | Salir con el perro sin el teléfono | `Route.kt:86` |
| T0786 | texto | Dejar el teléfono en casa | `Route.kt:86` |
| T0787 | texto | Junto a la puerta | `Route.kt:86` |
| T0788 | texto | Dibujar o pintar | `Route.kt:89` |
| T0789 | texto | Dibujar 10 minutos | `Route.kt:90` |
| T0790 | texto | Sacar el cuaderno y un lápiz | `Route.kt:90` |
| T0791 | texto | En el escritorio | `Route.kt:90` |
| T0792 | texto | Pintar | `Route.kt:91` |
| T0793 | texto | Preparar las acuarelas | `Route.kt:91` |
| T0794 | texto | En la mesa | `Route.kt:91` |
| T0795 | texto | Terminar un dibujo | `Route.kt:92` |
| T0796 | texto | Abrir el cuaderno en ese dibujo | `Route.kt:92` |
| T0797 | texto | En el escritorio | `Route.kt:92` |
| T0798 | texto | Manualidades o maquetas | `Route.kt:95` |
| T0799 | texto | Avanzar 15 minutos | `Route.kt:96` |
| T0800 | texto | Sacar los materiales | `Route.kt:96` |
| T0801 | texto | En la mesa de trabajo | `Route.kt:96` |
| T0802 | texto | Armar una parte de la maqueta | `Route.kt:97` |
| T0803 | texto | Abrir la caja de la maqueta | `Route.kt:97` |
| T0804 | texto | En la mesa | `Route.kt:97` |
| T0805 | texto | Terminar lo que empezaste | `Route.kt:98` |
| T0806 | texto | Dejar la pieza a la vista | `Route.kt:98` |
| T0807 | texto | En la mesa | `Route.kt:98` |
| T0808 | texto | Cocinar | `Route.kt:101` |
| T0809 | texto | Cocinar algo simple | `Route.kt:102` |
| T0810 | texto | Reunir los ingredientes | `Route.kt:102` |
| T0811 | texto | En el mesón de la cocina | `Route.kt:102` |
| T0812 | texto | Probar una receta nueva | `Route.kt:103` |
| T0813 | texto | Dejar la receta a la vista | `Route.kt:103` |
| T0814 | texto | En el mesón de la cocina | `Route.kt:103` |
| T0815 | texto | Preparar la comida de mañana | `Route.kt:104` |
| T0816 | texto | Sacar los táper | `Route.kt:104` |
| T0817 | texto | En el mesón de la cocina | `Route.kt:104` |
| T0818 | texto | Ordenar tu pieza | `Route.kt:107` |
| T0819 | texto | Ordenar un cajón | `Route.kt:108` |
| T0820 | texto | Vaciar el cajón sobre la cama | `Route.kt:108` |
| T0821 | texto | Junto al cajón | `Route.kt:108` |
| T0822 | texto | Hacer la cama | `Route.kt:109` |
| T0823 | texto | Estirar las sábanas | `Route.kt:109` |
| T0824 | texto | Junto a la cama | `Route.kt:109` |
| T0825 | texto | Ordenar la ropa | `Route.kt:110` |
| T0826 | texto | Juntar la ropa en el canasto | `Route.kt:110` |
| T0827 | texto | Junto al canasto | `Route.kt:110` |
| T0828 | texto | Meditar | `Route.kt:113` |
| T0829 | texto | Respirar 5 minutos | `Route.kt:114` |
| T0830 | texto | Sentarte en el cojín | `Route.kt:114` |
| T0831 | texto | Junto al cojín | `Route.kt:114` |
| T0832 | texto | Meditar 10 minutos | `Route.kt:115` |
| T0833 | texto | Apagar la luz grande | `Route.kt:115` |
| T0834 | texto | Junto al interruptor | `Route.kt:115` |
| T0835 | texto | Estirar antes de dormir | `Route.kt:116` |
| T0836 | texto | Desenrollar la colchoneta | `Route.kt:116` |
| T0837 | texto | Junto a la cama | `Route.kt:116` |
| T0838 | texto | Estudiar o hacer tareas | `Route.kt:119` |
| T0839 | texto | Estudiar 20 minutos | `Route.kt:120` |
| T0840 | texto | Abrir tus apuntes | `Route.kt:120` |
| T0841 | texto | En el escritorio | `Route.kt:120` |
| T0842 | texto | Hacer una tarea | `Route.kt:121` |
| T0843 | texto | Abrir el cuaderno en la tarea | `Route.kt:121` |
| T0844 | texto | En el escritorio | `Route.kt:121` |
| T0845 | texto | Repasar para una prueba | `Route.kt:122` |
| T0846 | texto | Sacar tus resúmenes | `Route.kt:122` |
| T0847 | texto | En el escritorio | `Route.kt:122` |
| T0848 | texto | Jugar videojuegos | `Route.kt:125` |
| T0849 | texto | Jugar una partida | `Route.kt:126` |
| T0850 | texto | Encender la consola | `Route.kt:126` |
| T0851 | texto | Junto a la tele | `Route.kt:126` |
| T0852 | texto | Avanzar en tu juego | `Route.kt:127` |
| T0853 | texto | Dejar el control cargado | `Route.kt:127` |
| T0854 | texto | Junto a la tele | `Route.kt:127` |
| T0855 | texto | Jugar con alguien | `Route.kt:128` |
| T0856 | texto | Avisar a quien juega contigo | `Route.kt:128` |
| T0857 | texto | Junto al computador | `Route.kt:128` |
| T0858 | texto | Escuchar música | `Route.kt:131` |
| T0859 | texto | Escuchar un disco entero | `Route.kt:132` |
| T0860 | texto | Elegir el disco | `Route.kt:132` |
| T0861 | texto | Junto a los discos | `Route.kt:132` |
| T0862 | texto | Escuchar música sin hacer nada más | `Route.kt:133` |
| T0863 | texto | Ponerte los audífonos | `Route.kt:133` |
| T0864 | texto | En el sillón | `Route.kt:133` |
| T0865 | texto | Tocar una canción | `Route.kt:134` |
| T0866 | texto | Sacar el instrumento | `Route.kt:134` |
| T0867 | texto | Junto al instrumento | `Route.kt:134` |
| T0868 | texto | Ver una película o serie | `Route.kt:137` |
| T0869 | texto | Ver una película | `Route.kt:138` |
| T0870 | texto | Elegir la película | `Route.kt:138` |
| T0871 | texto | Junto a la tele | `Route.kt:138` |
| T0872 | texto | Ver un capítulo con alguien | `Route.kt:139` |
| T0873 | texto | Avisar a quien ve contigo | `Route.kt:139` |
| T0874 | texto | Junto a la tele | `Route.kt:139` |
| T0875 | texto | Ver una película sin el teléfono | `Route.kt:140` |
| T0876 | texto | Dejar el teléfono cargando | `Route.kt:140` |
| T0877 | texto | Junto al cargador | `Route.kt:140` |
| T0878 | texto | Compartir con alguien | `Route.kt:143` |
| T0879 | texto | Comer sin el teléfono | `Route.kt:144` |
| T0880 | texto | Poner la mesa | `Route.kt:144` |
| T0881 | texto | En la mesa del comedor | `Route.kt:144` |
| T0882 | texto | Jugar un juego de mesa | `Route.kt:145` |
| T0883 | texto | Sacar la caja | `Route.kt:145` |
| T0884 | texto | En la mesa | `Route.kt:145` |
| T0885 | texto | Juntarte a jugar a la pelota | `Route.kt:146` |
| T0886 | texto | Preparar las zapatillas | `Route.kt:146` |
| T0887 | texto | Junto a la puerta | `Route.kt:146` |
| T0888 | texto | Llamar a alguien | `Route.kt:148` |
| T0889 | texto | Buscar su número | `Route.kt:148` |
| T0890 | texto | En el sillón | `Route.kt:148` |
| T0891 | texto | Otra actividad | `Route.kt:158` |
| T0892 | texto | En tu pieza | `Route.kt:165` |
| T0893 | texto | En el living | `Route.kt:165` |
| T0894 | texto | En la cocina | `Route.kt:165` |
| T0895 | texto | En el comedor | `Route.kt:165` |
| T0896 | texto | Leer | `Common.kt:56` |
| T0897 | texto | Abrir el libro | `Common.kt:56` |
| T0898 | texto | En el velador | `Common.kt:56` |
| T0899 | texto | Dormir a tiempo | `Common.kt:57` |
| T0900 | texto | Dejar el teléfono cargando lejos | `Common.kt:57` |
| T0901 | texto | Junto al cargador | `Common.kt:57` |
| T0902 | texto | Hacer ejercicio | `Common.kt:58` |
| T0903 | texto | Ponerte ropa cómoda | `Common.kt:58` |
| T0904 | texto | Junto al clóset | `Common.kt:58` |
| T0905 | texto | Pasear al perro | `Common.kt:59` |
| T0906 | texto | Tomar la correa | `Common.kt:59` |
| T0907 | texto | Junto a la puerta | `Common.kt:59` |
| T0908 | texto | Dibujar | `Common.kt:60` |
| T0909 | texto | Sacar el cuaderno y un lápiz | `Common.kt:60` |
| T0910 | texto | En el escritorio | `Common.kt:60` |
| T0911 | texto | Pintar | `Common.kt:61` |
| T0912 | texto | Preparar las acuarelas | `Common.kt:61` |
| T0913 | texto | En la mesa | `Common.kt:61` |
| T0914 | texto | Cocinar | `Common.kt:62` |
| T0915 | texto | Reunir los ingredientes | `Common.kt:62` |
| T0916 | texto | En el mesón de la cocina | `Common.kt:62` |
| T0917 | texto | Estudiar | `Common.kt:63` |
| T0918 | texto | Abrir tus apuntes | `Common.kt:63` |
| T0919 | texto | En el escritorio | `Common.kt:63` |
| T0920 | texto | Ordenar tu pieza | `Common.kt:64` |
| T0921 | texto | Despejar una superficie | `Common.kt:64` |
| T0922 | texto | En el escritorio | `Common.kt:64` |
| T0923 | texto | Hacer manualidades | `Common.kt:65` |
| T0924 | texto | Preparar los materiales | `Common.kt:65` |
| T0925 | texto | En la mesa de trabajo | `Common.kt:65` |
| T0926 | texto | Armar una maqueta | `Common.kt:66` |
| T0927 | texto | Abrir la caja de la maqueta | `Common.kt:66` |
| T0928 | texto | En la mesa | `Common.kt:66` |
| T0929 | texto | Salir en bicicleta | `Common.kt:67` |
| T0930 | texto | Sacar la bici | `Common.kt:67` |
| T0931 | texto | Junto a la puerta | `Common.kt:67` |
| T0932 | texto | Meditar | `Common.kt:68` |
| T0933 | texto | Sentarte en el cojín | `Common.kt:68` |
| T0934 | texto | Junto al cojín | `Common.kt:68` |
| T0935 | texto | Leer manga | `Common.kt:69` |
| T0936 | texto | Sacar el tomo del estante | `Common.kt:69` |
| T0937 | texto | Junto al estante | `Common.kt:69` |
| T0938 | texto | Jugar videojuegos | `Common.kt:71` |
| T0939 | texto | Encender la consola | `Common.kt:71` |
| T0940 | texto | Junto a la tele | `Common.kt:71` |
| T0941 | texto | Escuchar música | `Common.kt:72` |
| T0942 | texto | Ponerte los audífonos | `Common.kt:72` |
| T0943 | texto | En el sillón | `Common.kt:72` |
| T0944 | texto | Ver una película | `Common.kt:73` |
| T0945 | texto | Elegir la película | `Common.kt:73` |
| T0946 | texto | Junto a la tele | `Common.kt:73` |
| T0947 | texto | Llamar a alguien | `Common.kt:74` |
| T0948 | texto | Buscar su número | `Common.kt:74` |
| T0949 | texto | En el sillón | `Common.kt:74` |
| T0950 | texto | Jugar un juego de mesa | `Common.kt:75` |
| T0951 | texto | Sacar la caja | `Common.kt:75` |
| T0952 | texto | En la mesa | `Common.kt:75` |
| T0953 | texto | En el velador | `Common.kt:81` |
| T0954 | texto | En el escritorio | `Common.kt:81` |
| T0955 | texto | En la mesa | `Common.kt:81` |
| T0956 | texto | En el sillón | `Common.kt:81` |
| T0957 | texto | Junto a la cama | `Common.kt:81` |
| T0958 | texto | Junto a la tele | `Common.kt:81` |
| T0959 | texto | En el mesón de la cocina | `Common.kt:81` |
| T0960 | texto | Junto a la puerta | `Common.kt:81` |
| T0961 | texto | Dejar el teléfono en otro lugar | `Common.kt:102` |
| T0962 | texto | Moverte | `Sky.kt:114` |
| T0963 | texto | Leer y aprender | `Sky.kt:115` |
| T0964 | texto | Crear | `Sky.kt:116` |
| T0965 | texto | Jugar y disfrutar | `Sky.kt:117` |
| T0966 | texto | En casa | `Sky.kt:118` |
| T0967 | texto | Descansar | `Sky.kt:119` |
| T0968 | texto | Con otras personas | `Sky.kt:120` |
| T0969 | texto | Otras | `Sky.kt:121` |

## 34 Piezas de la interfaz

226 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0970 | texto | Restar tiempo | `Controls.kt:330` |
| T0971 | texto | Sumar tiempo | `Controls.kt:332` |
| T0972 | texto | Restar tiempo | `Controls.kt:347` |
| T0973 | texto | Sumar tiempo | `Controls.kt:349` |
| T0974 | texto | Restar | `Controls.kt:359` |
| T0975 | texto | Sumar | `Controls.kt:361` |
| T0976 | lector de pantalla | Borrar la búsqueda | `Fields.kt:125` |
| T0977 | texto | Vuelve a | `Fields.kt:140` |
| T0978 | texto | Accesibilidad | `KitIcons.kt:13` |
| T0979 | texto | Actividad | `KitIcons.kt:22` |
| T0980 | texto | Advertencia | `KitIcons.kt:30` |
| T0981 | texto | Agregar | `KitIcons.kt:38` |
| T0982 | texto | Ajustes | `KitIcons.kt:44` |
| T0983 | texto | Apps elegidas | `KitIcons.kt:52` |
| T0984 | texto | Avisos del teléfono | `KitIcons.kt:61` |
| T0985 | texto | Ayuda | `KitIcons.kt:68` |
| T0986 | texto | Batería del objeto | `KitIcons.kt:76` |
| T0987 | texto | Andar en bicicleta | `KitIcons.kt:84` |
| T0988 | texto | Borrar | `KitIcons.kt:93` |
| T0989 | texto | Buscar | `KitIcons.kt:102` |
| T0990 | texto | Calendario | `KitIcons.kt:109` |
| T0991 | texto | Cambié de idea | `KitIcons.kt:117` |
| T0992 | texto | Caminar | `KitIcons.kt:124` |
| T0993 | texto | Escribirle a alguien | `KitIcons.kt:133` |
| T0994 | texto | Cerrar sesión | `KitIcons.kt:140` |
| T0995 | texto | Cerrar | `KitIcons.kt:148` |
| T0996 | texto | Cocinar | `KitIcons.kt:154` |
| T0997 | texto | Código de participante | `KitIcons.kt:163` |
| T0998 | texto | Comencé | `KitIcons.kt:169` |
| T0999 | texto | Comentario | `KitIcons.kt:176` |
| T1000 | texto | Conexión | `KitIcons.kt:182` |
| T1001 | texto | Consentimiento | `KitIcons.kt:188` |
| T1002 | texto | Contraer | `KitIcons.kt:196` |
| T1003 | texto | Copiar | `KitIcons.kt:202` |
| T1004 | texto | Datos del estudio | `KitIcons.kt:209` |
| T1005 | texto | Decisión | `KitIcons.kt:217` |
| T1006 | texto | Acceso abierto | `KitIcons.kt:224` |
| T1007 | texto | Descargar | `KitIcons.kt:231` |
| T1008 | texto | La dejé para después | `KitIcons.kt:238` |
| T1009 | texto | Detener | `KitIcons.kt:246` |
| T1010 | texto | Dibujar | `KitIcons.kt:252` |
| T1011 | texto | Dormir | `KitIcons.kt:259` |
| T1012 | texto | Editar | `KitIcons.kt:266` |
| T1013 | texto | Hacer ejercicio | `KitIcons.kt:274` |
| T1014 | texto | Abrir fuera de la app | `KitIcons.kt:283` |
| T1015 | texto | Entrevistas | `KitIcons.kt:291` |
| T1016 | texto | Enviar | `KitIcons.kt:298` |
| T1017 | texto | Error | `KitIcons.kt:305` |
| T1018 | texto | Escribir | `KitIcons.kt:312` |
| T1019 | texto | Esperando | `KitIcons.kt:321` |
| T1020 | texto | Estirar | `KitIcons.kt:329` |
| T1021 | texto | Estrella llena | `KitIcons.kt:338` |
| T1022 | texto | Media estrella | `KitIcons.kt:344` |
| T1023 | texto | Estrella vacía | `KitIcons.kt:351` |
| T1024 | texto | Estudiar | `KitIcons.kt:357` |
| T1025 | texto | Expandir | `KitIcons.kt:365` |
| T1026 | texto | Exportar o compartir | `KitIcons.kt:371` |
| T1027 | texto | Filtrar | `KitIcons.kt:379` |
| T1028 | texto | Fotografiar | `KitIcons.kt:385` |
| T1029 | texto | Tocar un instrumento | `KitIcons.kt:394` |
| T1030 | texto | Hipótesis y prueba | `KitIcons.kt:404` |
| T1031 | texto | Historial | `KitIcons.kt:412` |
| T1032 | texto | Información | `KitIcons.kt:418` |
| T1033 | texto | Inicio | `KitIcons.kt:426` |
| T1034 | texto | Investigación | `KitIcons.kt:432` |
| T1035 | texto | Jugar un juego de mesa | `KitIcons.kt:441` |
| T1036 | texto | Leer | `KitIcons.kt:450` |
| T1037 | texto | Listo | `KitIcons.kt:457` |
| T1038 | texto | Jugar videojuegos | `KitIcons.kt:463` |
| T1039 | texto | Llamar a alguien | `KitIcons.kt:472` |
| T1040 | texto | Lugar | `KitIcons.kt:478` |
| T1041 | texto | Hacer manualidades | `KitIcons.kt:485` |
| T1042 | texto | Más opciones | `KitIcons.kt:493` |
| T1043 | texto | Menú | `KitIcons.kt:501` |
| T1044 | texto | Mostrar | `KitIcons.kt:507` |
| T1045 | texto | Escuchar música | `KitIcons.kt:514` |
| T1046 | texto | Objeto | `KitIcons.kt:522` |
| T1047 | texto | Ocultar | `KitIcons.kt:530` |
| T1048 | texto | Ordenar | `KitIcons.kt:538` |
| T1049 | texto | Parlante | `KitIcons.kt:546` |
| T1050 | texto | Pausar | `KitIcons.kt:554` |
| T1051 | texto | Perfil | `KitIcons.kt:560` |
| T1052 | texto | Permiso | `KitIcons.kt:567` |
| T1053 | texto | Pintar | `KitIcons.kt:574` |
| T1054 | texto | Cuidar las plantas | `KitIcons.kt:581` |
| T1055 | texto | Cómo empieza | `KitIcons.kt:590` |
| T1056 | texto | Privacidad | `KitIcons.kt:597` |
| T1057 | texto | Probar sonido | `KitIcons.kt:605` |
| T1058 | texto | Reportar un problema | `KitIcons.kt:613` |
| T1059 | texto | Reintentar | `KitIcons.kt:622` |
| T1060 | texto | Relevos | `KitIcons.kt:629` |
| T1061 | texto | Reproducir | `KitIcons.kt:638` |
| T1062 | texto | Salir | `KitIcons.kt:644` |
| T1063 | texto | Siguiente | `KitIcons.kt:654` |
| T1064 | texto | Silenciar | `KitIcons.kt:660` |
| T1065 | texto | Sin conexión | `KitIcons.kt:669` |
| T1066 | texto | Sincronizar datos | `KitIcons.kt:676` |
| T1067 | texto | Sistema phygital | `KitIcons.kt:683` |
| T1068 | texto | Este teléfono | `KitIcons.kt:691` |
| T1069 | texto | Tema claro u oscuro | `KitIcons.kt:698` |
| T1070 | texto | Tamaño del texto | `KitIcons.kt:705` |
| T1071 | texto | Tiempo | `KitIcons.kt:712` |
| T1072 | texto | Después de cuánto uso | `KitIcons.kt:721` |
| T1073 | texto | Persona | `KitIcons.kt:730` |
| T1074 | texto | Validación | `KitIcons.kt:737` |
| T1075 | texto | Volver | `KitIcons.kt:744` |
| T1076 | texto | Suena | `KitIcons.kt:750` |
| T1077 | texto | Ruta | `KitIcons.kt:760` |
| T1078 | texto | Aura | `KitIcons.kt:768` |
| T1079 | texto | Avance | `KitIcons.kt:776` |
| T1080 | texto | Abrir | `KitIcons.kt:781` |
| T1081 | texto | Elegido | `Lists.kt:136` |
| T1082 | texto | Sin completar | `Lists.kt:166` |
| T1083 | texto | Encendido | `Lists.kt:251` |
| T1084 | texto | Apagado | `Lists.kt:251` |
| T1085 | texto | Caminar | `Photos.kt:73` |
| T1086 | texto | Hacer ejercicio | `Photos.kt:74` |
| T1087 | texto | Leer | `Photos.kt:75` |
| T1088 | texto | Estudiar | `Photos.kt:76` |
| T1089 | texto | Dibujar | `Photos.kt:77` |
| T1090 | texto | Cocinar | `Photos.kt:78` |
| T1091 | texto | Ordenar | `Photos.kt:79` |
| T1092 | texto | Salir con el perro | `Photos.kt:80` |
| T1093 | texto | Manualidades | `Photos.kt:81` |
| T1094 | texto | Tocar guitarra | `Photos.kt:82` |
| T1095 | texto | Escribir | `Photos.kt:83` |
| T1096 | texto | Leer un libro | `Photos.kt:84` |
| T1097 | texto | Aprender | `Photos.kt:85` |
| T1098 | texto | Hacer pan | `Photos.kt:86` |
| T1099 | texto | Pintar | `Photos.kt:87` |
| T1100 | texto | Empezar | `Photos.kt:88` |
| T1101 | texto | Salir | `Photos.kt:89` |
| T1102 | texto | El tiempo en el teléfono | `Photos.kt:90` |
| T1103 | texto | Caras | `Photos.kt:97` |
| T1104 | texto | Animales | `Photos.kt:97` |
| T1105 | texto | Naturaleza | `Photos.kt:97` |
| T1106 | texto | Comida | `Photos.kt:97` |
| T1107 | texto | Actividades | `Photos.kt:97` |
| T1108 | texto | Cara sonriente | `Photos.kt:107` |
| T1109 | texto | Cara contenta | `Photos.kt:108` |
| T1110 | texto | Cara con lentes de sol | `Photos.kt:109` |
| T1111 | texto | Cara que abraza | `Photos.kt:110` |
| T1112 | texto | Cara con ojos de estrella | `Photos.kt:111` |
| T1113 | texto | Cara con corazones | `Photos.kt:112` |
| T1114 | texto | Cara de fiesta | `Photos.kt:113` |
| T1115 | texto | Cara pensativa | `Photos.kt:114` |
| T1116 | texto | Cara dormida | `Photos.kt:115` |
| T1117 | texto | Cara con sombrero de vaquero | `Photos.kt:116` |
| T1118 | texto | Robot | `Photos.kt:117` |
| T1119 | texto | Fantasma | `Photos.kt:118` |
| T1120 | texto | Perro | `Photos.kt:120` |
| T1121 | texto | Gato | `Photos.kt:121` |
| T1122 | texto | Zorro | `Photos.kt:122` |
| T1123 | texto | Tortuga | `Photos.kt:123` |
| T1124 | texto | Conejo | `Photos.kt:124` |
| T1125 | texto | Oso | `Photos.kt:125` |
| T1126 | texto | Panda | `Photos.kt:126` |
| T1127 | texto | Koala | `Photos.kt:127` |
| T1128 | texto | Tigre | `Photos.kt:128` |
| T1129 | texto | León | `Photos.kt:129` |
| T1130 | texto | Rana | `Photos.kt:130` |
| T1131 | texto | Pingüino | `Photos.kt:131` |
| T1132 | texto | Búho | `Photos.kt:132` |
| T1133 | texto | Abeja | `Photos.kt:133` |
| T1134 | texto | Mariposa | `Photos.kt:134` |
| T1135 | texto | Pulpo | `Photos.kt:135` |
| T1136 | texto | Ballena | `Photos.kt:136` |
| T1137 | texto | Unicornio | `Photos.kt:137` |
| T1138 | texto | Perezoso | `Photos.kt:138` |
| T1139 | texto | Dinosaurio | `Photos.kt:139` |
| T1140 | texto | Planta | `Photos.kt:141` |
| T1141 | texto | Girasol | `Photos.kt:142` |
| T1142 | texto | Ola | `Photos.kt:143` |
| T1143 | texto | Luna | `Photos.kt:144` |
| T1144 | texto | Sol | `Photos.kt:145` |
| T1145 | texto | Arcoíris | `Photos.kt:146` |
| T1146 | texto | Estrella | `Photos.kt:147` |
| T1147 | texto | Nube | `Photos.kt:148` |
| T1148 | texto | Copo de nieve | `Photos.kt:149` |
| T1149 | texto | Fuego | `Photos.kt:150` |
| T1150 | texto | Cactus | `Photos.kt:151` |
| T1151 | texto | Árbol | `Photos.kt:152` |
| T1152 | texto | Trébol de cuatro hojas | `Photos.kt:153` |
| T1153 | texto | Tulipán | `Photos.kt:154` |
| T1154 | texto | Hongo | `Photos.kt:155` |
| T1155 | texto | Montaña nevada | `Photos.kt:156` |
| T1156 | texto | Planeta con anillo | `Photos.kt:157` |
| T1157 | texto | Taza de café | `Photos.kt:159` |
| T1158 | texto | Pan | `Photos.kt:160` |
| T1159 | texto | Sartén con un huevo | `Photos.kt:161` |
| T1160 | texto | Palta | `Photos.kt:162` |
| T1161 | texto | Frutilla | `Photos.kt:163` |
| T1162 | texto | Sandía | `Photos.kt:164` |
| T1163 | texto | Limón | `Photos.kt:165` |
| T1164 | texto | Pizza | `Photos.kt:166` |
| T1165 | texto | Dona | `Photos.kt:167` |
| T1166 | texto | Helado | `Photos.kt:168` |
| T1167 | texto | Té de burbujas | `Photos.kt:169` |
| T1168 | texto | Zapatilla | `Photos.kt:171` |
| T1169 | texto | Libros | `Photos.kt:172` |
| T1170 | texto | Guitarra | `Photos.kt:173` |
| T1171 | texto | Paleta de pintura | `Photos.kt:174` |
| T1172 | texto | Ovillo de lana | `Photos.kt:175` |
| T1173 | texto | Bicicleta | `Photos.kt:176` |
| T1174 | texto | Cámara | `Photos.kt:177` |
| T1175 | texto | Audífonos | `Photos.kt:178` |
| T1176 | texto | Lápiz | `Photos.kt:179` |
| T1177 | texto | Pieza de rompecabezas | `Photos.kt:180` |
| T1178 | texto | Teclado de piano | `Photos.kt:181` |
| T1179 | texto | Pelota | `Photos.kt:182` |
| T1180 | texto | Pelota de básquetbol | `Photos.kt:183` |
| T1181 | texto | Raqueta de tenis | `Photos.kt:184` |
| T1182 | texto | Skate | `Photos.kt:185` |
| T1183 | texto | Dado | `Photos.kt:186` |
| T1184 | texto | Peón de ajedrez | `Photos.kt:187` |
| T1185 | texto | Control de videojuegos | `Photos.kt:188` |
| T1186 | texto | Volantín | `Photos.kt:189` |
| T1187 | texto | Micrófono | `Photos.kt:190` |
| T1188 | texto | Violín | `Photos.kt:191` |
| T1189 | texto | Telescopio | `Photos.kt:192` |
| T1190 | texto | Carpa | `Photos.kt:193` |
| T1191 | texto | Cohete | `Photos.kt:194` |
| T1192 | texto | Volver | `Screen.kt:96` |
| T1193 | texto | Inicio | `RelevoApp.kt:87` |
| T1194 | texto | Actividades | `RelevoApp.kt:88` |
| T1195 | texto | Perfil | `RelevoApp.kt:89` |

## Registro de cambios (disclaimer)

### 2026-10-24 — Creación

- **Qué cambió:** se creó el inventario, generado desde el código.
- **Cómo estaba antes:** los textos solo estaban dentro del código Kotlin.
- **Por qué:** el autor pidió estudiar y documentar cada palabra de la app antes de actualizar los textos.
