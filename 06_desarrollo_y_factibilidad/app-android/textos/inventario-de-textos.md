# Inventario de textos de la app

> Se genera con `node extraer-textos.js` desde el código de la app. Para cambiar un texto se cambia el código y se vuelve a generar. Los datos variables van entre corchetes, como [nombre] o [duración].

**Total:** 1335 textos, 5320 palabras, en 30 pantallas o grupos.


## 01 Bienvenida

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0001 | botón | Empezar | `FirstRunScreens.kt:66` |
| T0002 | lector de pantalla | Relevo | `FirstRunScreens.kt:69` |
| T0003 | texto | Anota algo que quieres hacer | `FirstRunScreens.kt:73` |
| T0004 | texto | Cuando cumplas el tiempo que elegiste en tus apps, sonará un aviso donde empieza esa actividad. | `FirstRunScreens.kt:75` |
| T0005 | texto | Leer | `FirstRunScreens.kt:82` |
| T0006 | fila | Abrir el libro | `FirstRunScreens.kt:85` |
| T0007 | fila | En el velador | `FirstRunScreens.kt:86` |

## 02 Cómo funciona (guía de la primera vez)

18 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0008 | texto | Entendido | `HowItWorksScreen.kt:57` |
| T0009 | guía | ¿Te ha pasado? | `HowItWorksScreen.kt:61` |
| T0010 | guía | Cuando se cumple el tiempo que elegiste en tus apps, Relevo suena donde empieza lo que querías hacer. | `HowItWorksScreen.kt:61` |
| T0011 | texto | Abres una app para descansar. | `HowItWorksScreen.kt:65` |
| T0012 | texto | Se pasa el rato y lo que querías hacer queda esperando. | `HowItWorksScreen.kt:67` |
| T0013 | guía | Cómo funciona | `HowItWorksScreen.kt:70` |
| T0014 | fila | Cuenta el tiempo | `HowItWorksScreen.kt:73` |
| T0015 | subtítulo | En las apps que eliges | `HowItWorksScreen.kt:73` |
| T0016 | fila | Te recuerda cómo empezar | `HowItWorksScreen.kt:74` |
| T0017 | subtítulo | Con un primer paso, como abrir el libro | `HowItWorksScreen.kt:74` |
| T0018 | fila | Suena donde empiezas | `HowItWorksScreen.kt:75` |
| T0019 | subtítulo | En el Tag o en un dispositivo de audio, junto a lo que quieres hacer | `HowItWorksScreen.kt:75` |
| T0020 | fila | Tú decides | `HowItWorksScreen.kt:76` |
| T0021 | subtítulo | Empezar, dejarlo o cambiar de idea | `HowItWorksScreen.kt:76` |
| T0022 | acción | Saltar | `HowItWorksScreen.kt:96` |
| T0023 | botón | Seguir | `HowItWorksScreen.kt:99` |
| T0024 | botón | Entendido | `RelevoApp.kt:304` |
| T0025 | texto | Queda lista en Inicio para cuando quieras. | `RelevoApp.kt:455` |

## 03 Antes de empezar (consentimiento)

52 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0026 | texto | Relevo cambió | `FirstRunScreens.kt:108` |
| T0027 | texto | Antes de empezar | `FirstRunScreens.kt:108` |
| T0028 | texto | Ya no hay una prueba de 21 días. Tu código y tus datos se mantienen. | `FirstRunScreens.kt:109` |
| T0029 | texto | Lee lo que aceptas. Puedes dejar de usarlo cuando quieras. | `FirstRunScreens.kt:110` |
| T0030 | texto | Acepto usar Relevo con estas condiciones | `FirstRunScreens.kt:122` |
| T0031 | texto | Aceptar y seguir | `FirstRunScreens.kt:124` |
| T0032 | texto | Aceptar y empezar | `FirstRunScreens.kt:124` |
| T0033 | validación | Espera a que termine el borrado de los datos. | `FirstRunScreens.kt:125` |
| T0034 | validación | Marca «Acepto usar Relevo con estas condiciones» para seguir. | `FirstRunScreens.kt:126` |
| T0035 | texto | Ocultar | `FirstRunScreens.kt:129` |
| T0036 | texto | No acepto | `FirstRunScreens.kt:129` |
| T0037 | texto | Está bien. Sin aceptar, Relevo deja de contar. Los datos anteriores siguen guardados hasta que pidas borrarlos, o hasta el 30 de diciembre de 2026. | `FirstRunScreens.kt:132` |
| T0038 | texto | Está bien. Sin aceptar, Relevo no se puede usar: puedes cerrar la app y desinstalarla. No se guardó nada. | `FirstRunScreens.kt:133` |
| T0039 | acción | Abrir Tus datos | `FirstRunScreens.kt:136` |
| T0040 | texto | Relevo es parte de un proyecto de título de Diseño de la Universidad Diego Portales. Mientras lo usas, guarda lo que haces en Relevo con un código, para estudiar cómo funciona. El nombre se guarda aparte. Puedes borrar los datos cuando quieras. | `FirstRunScreens.kt:141` |
| T0041 | aviso | Todavía se están borrando los datos. Mientras tanto, Relevo no guarda nada. | `FirstRunScreens.kt:148` |
| T0042 | acción | Abrir Tus datos | `FirstRunScreens.kt:149` |
| T0043 | texto | Cómo funciona | `FirstRunScreens.kt:159` |
| T0044 | texto | Preparas un relevo: qué quieres hacer, cómo empiezas, dónde y cuánto tiempo en tus apps. | `FirstRunScreens.kt:160` |
| T0045 | texto | Cuando sumas ese tiempo, suena unos 30 segundos en el Tag, en el teléfono o en un dispositivo de audio, y se apaga solo. | `FirstRunScreens.kt:161` |
| T0046 | texto | Después puedes responder preguntas de un toque. Todas se pueden saltar. | `FirstRunScreens.kt:162` |
| T0047 | texto | Tú decides | `FirstRunScreens.kt:164` |
| T0048 | texto | Usar Relevo es voluntario. | `FirstRunScreens.kt:165` |
| T0049 | texto | Puedes saltar preguntas, silenciar el sonido, quitar los permisos o dejar de usarlo cuando quieras, sin dar explicaciones. | `FirstRunScreens.kt:166` |
| T0050 | texto | Nadie juzga lo que eliges hacer. | `FirstRunScreens.kt:167` |
| T0051 | texto | El sonido puede molestar a otras personas: puedes detenerlo cuando quieras. | `FirstRunScreens.kt:168` |
| T0052 | texto | Qué se guarda | `FirstRunScreens.kt:170` |
| T0053 | texto | Un código al azar, en lugar de tu nombre. | `FirstRunScreens.kt:171` |
| T0054 | texto | Lo que preparas: la actividad, cómo empiezas, dónde, las apps y el tiempo. | `FirstRunScreens.kt:172` |
| T0055 | texto | Cuándo activas un relevo, a mano o solo, cuándo suena y qué respondes. | `FirstRunScreens.kt:173` |
| T0056 | texto | Cuánto usaste las apps elegidas 10 minutos antes y después de que sonara. | `FirstRunScreens.kt:174` |
| T0057 | texto | Cada día, cuánto usas las apps que elegiste en Relevo y el tiempo total del teléfono. | `FirstRunScreens.kt:175` |
| T0058 | texto | El modelo del teléfono, los permisos que diste y cómo usas Relevo: cuándo lo abres, qué pantallas ves, tus intereses, tus actividades y tus ajustes. | `FirstRunScreens.kt:176` |
| T0059 | texto | El nombre se guarda aparte, solo con el código, para saber quién usa Relevo. No va junto a lo que haces. | `FirstRunScreens.kt:177` |
| T0060 | texto | Dónde se guarda | `FirstRunScreens.kt:179` |
| T0061 | texto | En el teléfono y en la base de datos del proyecto, en Supabase, un servicio para guardar datos en internet. Si no hay internet, se envía después. | `FirstRunScreens.kt:180` |
| T0062 | texto | Una copia sin el nombre queda en la carpeta Documentos/Relevo del teléfono. Se borra si borras los datos. | `FirstRunScreens.kt:181` |
| T0063 | texto | Esta instalación no tiene configurada la base de datos del proyecto: todo queda en este teléfono. | `FirstRunScreens.kt:182` |
| T0064 | texto | Qué no se ve | `FirstRunScreens.kt:183` |
| T0065 | texto | El permiso de Tiempo de uso podría mostrar otras apps. Relevo cuenta solo las que eliges; de las demás no guarda el nombre. | `FirstRunScreens.kt:184` |
| T0066 | texto | Con la activación automática encendida, Relevo mira qué app tienes abierta, solo su nombre, para saber cuándo empezar. Puedes apagarla cuando quieras. | `FirstRunScreens.kt:185` |
| T0067 | texto | Relevo no lee mensajes, fotos, búsquedas ni lo que hay en la pantalla. | `FirstRunScreens.kt:186` |
| T0068 | texto | Mensajes | `FirstRunScreens.kt:188` |
| T0069 | texto | El autor del proyecto puede enviar mensajes sobre Relevo. Llegan como notificación. | `FirstRunScreens.kt:189` |
| T0070 | texto | Se guarda cuándo llegó y cuándo se abrió cada uno. | `FirstRunScreens.kt:190` |
| T0071 | texto | El código | `FirstRunScreens.kt:192` |
| T0072 | texto | El código reemplaza el nombre, pero no vuelve anónimos los datos: juntando actividades, lugares y horarios, alguien podría reconocerte. | `FirstRunScreens.kt:193` |
| T0073 | texto | Hasta cuándo | `FirstRunScreens.kt:195` |
| T0074 | texto | Puedes borrar los datos desde Perfil, en Tus datos, o escribiendo a [correo del investigador] con el código. | `FirstRunScreens.kt:196` |
| T0075 | texto | Si no lo haces antes, se borran a más tardar el 30 de diciembre de 2026. | `FirstRunScreens.kt:197` |
| T0076 | texto | Ocultar | `FirstRunScreens.kt:209` |
| T0077 | texto | Leer | `FirstRunScreens.kt:209` |

## 04 Para saber cuándo avisarte (permisos de la primera vez)

10 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0078 | título | Para saber cuándo avisarte | `FirstRunScreens.kt:262` |
| T0079 | subtítulo | Relevo solo cuenta minutos en las apps que elijas. No ve lo que haces en ellas. | `FirstRunScreens.kt:263` |
| T0080 | botón | Seguir | `FirstRunScreens.kt:265` |
| T0081 | botón | Dar el permiso | `FirstRunScreens.kt:266` |
| T0082 | texto | Tiempo de uso | `FirstRunScreens.kt:271` |
| T0083 | subtítulo | Necesario. En Android: Acceso a datos de uso | `FirstRunScreens.kt:271` |
| T0084 | texto | Dar el permiso | `FirstRunScreens.kt:273` |
| T0085 | texto | Toca «Dar el permiso». | `FirstRunScreens.kt:279` |
| T0086 | texto | En la lista, busca Relevo. | `FirstRunScreens.kt:280` |
| T0087 | texto | Actívalo y vuelve: Relevo sigue solo. | `FirstRunScreens.kt:281` |

## 05 Perfil (primera vez)

34 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0088 | texto | ¿Cómo te llamas? | `ProfileScreens.kt:211` |
| T0089 | texto | ¿Con qué te identificas? | `ProfileScreens.kt:211` |
| T0090 | texto | ¿Qué te gustaría hacer más seguido? | `ProfileScreens.kt:211` |
| T0091 | acción | Saltar | `ProfileScreens.kt:216` |
| T0092 | botón | Seguir | `ProfileScreens.kt:219` |
| T0093 | validación | Escribe tu nombre. | `ProfileScreens.kt:219` |
| T0094 | botón | Seguir | `ProfileScreens.kt:220` |
| T0095 | validación | Elige uno o salta este paso. | `ProfileScreens.kt:220` |
| T0096 | botón | Listo | `ProfileScreens.kt:221` |
| T0097 | validación | Elige al menos uno o salta este paso. | `ProfileScreens.kt:222` |
| T0098 | validación | Escribe cuál es tu otro interés. | `ProfileScreens.kt:223` |
| T0099 | campo | Nombre | `ProfileScreens.kt:243` |
| T0100 | ayuda del campo | Como te dicen | `ProfileScreens.kt:243` |
| T0101 | texto | Se guarda con tu código, aparte de lo que haces en Relevo. | `ProfileScreens.kt:246` |
| T0102 | texto | Elige una o varias. | `ProfileScreens.kt:254` |
| T0103 | texto | Otra | `ProfileScreens.kt:300` |
| T0104 | campo | ¿Cuál? | `ProfileScreens.kt:305` |
| T0105 | ayuda del campo | Ej.: tejer | `ProfileScreens.kt:305` |
| T0106 | texto | Dormir | `ProfileScreens.kt:356` |
| T0107 | texto | Leer | `ProfileScreens.kt:357` |
| T0108 | texto | Ejercicio | `ProfileScreens.kt:358` |
| T0109 | texto | Bicicleta | `ProfileScreens.kt:359` |
| T0110 | texto | Perro | `ProfileScreens.kt:360` |
| T0111 | texto | Dibujar | `ProfileScreens.kt:361` |
| T0112 | texto | Manualidades | `ProfileScreens.kt:362` |
| T0113 | texto | Cocinar | `ProfileScreens.kt:363` |
| T0114 | texto | Ordenar | `ProfileScreens.kt:364` |
| T0115 | texto | Meditar | `ProfileScreens.kt:365` |
| T0116 | texto | Estudiar | `ProfileScreens.kt:366` |
| T0117 | texto | Videojuegos | `ProfileScreens.kt:367` |
| T0118 | texto | Música | `ProfileScreens.kt:368` |
| T0119 | texto | Películas | `ProfileScreens.kt:369` |
| T0120 | texto | Compartir | `ProfileScreens.kt:370` |
| T0121 | texto | Otra | `ProfileScreens.kt:371` |

## 07 Inicio

61 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0122 | texto | Muy mal | `Feedback.kt:50` |
| T0123 | texto | Mal | `Feedback.kt:51` |
| T0124 | texto | Normal | `Feedback.kt:52` |
| T0125 | texto | Bien | `Feedback.kt:53` |
| T0126 | texto | Muy bien | `Feedback.kt:54` |
| T0127 | texto | ¿Qué tal te va con Relevo? | `Feedback.kt:90` |
| T0128 | acción | Escribir un comentario | `Feedback.kt:94` |
| T0129 | acción | Ahora no | `Feedback.kt:95` |
| T0130 | texto | Para que Relevo siga contando aunque pasen días. | `HomeScreen.kt:108` |
| T0131 | texto | Hola de nuevo, [nombre] | `HomeScreen.kt:162` |
| T0132 | texto | Hola de nuevo | `HomeScreen.kt:163` |
| T0133 | texto | Hola, [nombre] | `HomeScreen.kt:164` |
| T0134 | texto | Hola | `HomeScreen.kt:165` |
| T0135 | texto | Inicio | `HomeScreen.kt:171` |
| T0136 | aviso | El nombre y lo que te gustaría hacer más seguido. Toma un minuto. | `HomeScreen.kt:173` |
| T0137 | título | Completa el perfil | `HomeScreen.kt:173` |
| T0138 | acción | Completar | `HomeScreen.kt:174` |
| T0139 | aviso | Ya sonó 3 veces. Si al sonar ya llevas mucho rato en una app, prueba con menos tiempo. | `HomeScreen.kt:179` |
| T0140 | título | ¿El tiempo queda bien? | `HomeScreen.kt:179` |
| T0141 | acción | Cambiar el tiempo | `HomeScreen.kt:180` |
| T0142 | acción | Está bien así | `HomeScreen.kt:181` |
| T0143 | texto | Al abrir [apps elegidas], empieza a contar «[actividad]». | `HomeScreen.kt:188` |
| T0144 | título | Se activa solo | `HomeScreen.kt:189` |
| T0145 | acción | Apagar | `HomeScreen.kt:190` |
| T0146 | texto | Horas sin sonar: vuelve a contar a las [dato]:00 | `HomeScreen.kt:200` |
| T0147 | subtítulo | Faltan [duración] | `HomeScreen.kt:207` |
| T0148 | botón | Preparar otro relevo | `HomeScreen.kt:215` |
| T0149 | aviso | Falta el permiso de Tiempo de uso. | `HomeScreen.kt:218` |
| T0150 | título | Relevo no puede contar | `HomeScreen.kt:218` |
| T0151 | acción | Dar el permiso | `HomeScreen.kt:219` |
| T0152 | título | Batería | `HomeScreen.kt:224` |
| T0153 | acción | Quitar la restricción | `HomeScreen.kt:225` |
| T0154 | texto | Siguiente paso en [lugar] | `HomeScreen.kt:261` |
| T0155 | botón | Preparar un relevo | `HomeScreen.kt:265` |
| T0156 | acción | Elegir otra | `HomeScreen.kt:266` |
| T0157 | subtítulo | Repetir el último · [duración] | `HomeScreen.kt:273` |
| T0158 | texto | Último relevo | `HomeScreen.kt:284` |
| T0159 | botón | Preparar de nuevo | `HomeScreen.kt:287` |
| T0160 | acción | Elegir otra | `HomeScreen.kt:288` |
| T0161 | botón | Preparar un relevo | `HomeScreen.kt:291` |
| T0162 | texto | Esta semana | `HomeScreen.kt:362` |
| T0163 | texto | Aquí verás lo que hagas esta semana. | `HomeScreen.kt:371` |
| T0164 | texto | Elegiste [dato] por semana. | `HomeScreen.kt:384` |
| T0165 | rótulo | Actividades | `HomeScreen.kt:393` |
| T0166 | rótulo | Ver todas | `HomeScreen.kt:393` |
| T0167 | lector de pantalla | Preparar «[nombre]» | `HomeScreen.kt:400` |
| T0168 | texto | Nueva | `HomeScreen.kt:403` |
| T0169 | texto | Guarda lo que haces seguido y prepáralo en un toque. | `HomeScreen.kt:407` |
| T0170 | acción | Ver ideas | `HomeScreen.kt:408` |
| T0171 | texto | ¿Cambias este paso por otra actividad? | `HomeScreen.kt:437` |
| T0172 | botón | Cambiar | `HomeScreen.kt:439` |
| T0173 | acción | Ahora no | `HomeScreen.kt:440` |
| T0174 | texto | Contando | `HomeScreen.kt:459` |
| T0175 | texto | En pausa | `HomeScreen.kt:459` |
| T0176 | texto | Suena | `HomeScreen.kt:459` |
| T0177 | texto | Ver el relevo | `HomeScreen.kt:460` |
| T0178 | texto | Faltan [duración] | `HomeScreen.kt:467` |
| T0179 | texto | La última vez | `HomeScreen.kt:520` |
| T0180 | botón | Preparar de nuevo | `HomeScreen.kt:522` |
| T0181 | acción | Elegir otra | `HomeScreen.kt:524` |
| T0182 | acción | Ahora no | `HomeScreen.kt:526` |

## 08 Preparar un relevo

108 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0183 | texto | pila al [dato] %, cámbiala pronto | `TagProtocol.kt:39` |
| T0184 | texto | pila al [dato] % | `TagProtocol.kt:39` |
| T0185 | texto | Muy cerca | `TagProtocol.kt:83` |
| T0186 | texto | Cerca | `TagProtocol.kt:84` |
| T0187 | texto | Lejos | `TagProtocol.kt:85` |
| T0188 | texto | ¿Qué quieres hacer? | `PrepareScreen.kt:117` |
| T0189 | texto | ¿Cuándo suena? | `PrepareScreen.kt:120` |
| T0190 | texto | ¿Dónde suena? | `PrepareScreen.kt:121` |
| T0191 | texto | Todo listo | `PrepareScreen.kt:122` |
| T0192 | validación | Escribe qué quieres hacer o elige una idea. | `PrepareScreen.kt:160` |
| T0193 | validación | Escribe cómo empiezas la actividad: lo primero que harías. | `PrepareScreen.kt:161` |
| T0194 | validación | Escribe en qué lugar empieza. | `PrepareScreen.kt:162` |
| T0195 | texto | Da el permiso de Tiempo de uso. | `PrepareScreen.kt:164` |
| T0196 | validación | Elige al menos una app que cuente. | `PrepareScreen.kt:165` |
| T0197 | validación | Elige dónde quieres que suene. | `PrepareScreen.kt:169` |
| T0198 | validación | Busca y elige el Tag, o elige otra forma de avisar. | `PrepareScreen.kt:170` |
| T0199 | validación | Falta el permiso de Tiempo de uso. | `PrepareScreen.kt:174` |
| T0200 | validación | Falta elegir dónde suena. | `PrepareScreen.kt:175` |
| T0201 | validación | Falta elegir el Tag. | `PrepareScreen.kt:176` |
| T0202 | validación | Falta qué quieres hacer. | `PrepareScreen.kt:177` |
| T0203 | validación | Falta cómo empiezas la actividad. | `PrepareScreen.kt:178` |
| T0204 | validación | Falta en qué lugar empieza. | `PrepareScreen.kt:179` |
| T0205 | validación | Faltan las apps que cuentan. | `PrepareScreen.kt:180` |
| T0206 | texto | Cerrar | `PrepareScreen.kt:259` |
| T0207 | texto | Volver | `PrepareScreen.kt:259` |
| T0208 | texto | Guardar y activar | `PrepareScreen.kt:268` |
| T0209 | texto | Activar el relevo | `PrepareScreen.kt:268` |
| T0210 | texto | Listo | `PrepareScreen.kt:276` |
| T0211 | texto | Seguir | `PrepareScreen.kt:276` |
| T0212 | texto | Estás editando tu relevo. Al guardarlo vuelve a contar, con el tiempo que llevabas si las apps son las mismas. | `PrepareScreen.kt:303` |
| T0213 | texto | Guardar la actividad para la próxima vez | `PrepareScreen.kt:327` |
| T0214 | título | Batería | `PrepareScreen.kt:332` |
| T0215 | acción | Quitar la restricción | `PrepareScreen.kt:333` |
| T0216 | subtítulo | Actividad | `PrepareScreen.kt:349` |
| T0217 | ayuda del campo | Ej.: leer 10 páginas | `PrepareScreen.kt:359` |
| T0218 | texto | Pasos | `PrepareScreen.kt:362` |
| T0219 | texto | Creadas por ti | `PrepareScreen.kt:367` |
| T0220 | ayuda del campo | Ej.: en el velador | `PrepareScreen.kt:410` |
| T0221 | aviso | Relevo necesita el permiso de Tiempo de uso para contar. | `PrepareScreen.kt:421` |
| T0222 | título | Falta un permiso | `PrepareScreen.kt:421` |
| T0223 | acción | Dar el permiso | `PrepareScreen.kt:422` |
| T0224 | validación | Elige las apps | `PrepareScreen.kt:428` |
| T0225 | subtítulo | Apps que cuentan | `PrepareScreen.kt:429` |
| T0226 | texto | Después de [duración] | `PrepareScreen.kt:439` |
| T0227 | texto | Sumando las [número de apps] apps | `PrepareScreen.kt:440` |
| T0228 | texto | En esas apps | `PrepareScreen.kt:440` |
| T0229 | texto | Al empezar, conviene un tiempo breve: suena antes de que te pierdas en las apps. | `PrepareScreen.kt:452` |
| T0230 | texto | Volumen | `PrepareScreen.kt:489` |
| T0231 | texto | El volumen multimedia del teléfono también cuenta. | `PrepareScreen.kt:490` |
| T0232 | texto | Suave | `PrepareScreen.kt:493` |
| T0233 | texto | Medio | `PrepareScreen.kt:493` |
| T0234 | texto | Fuerte | `PrepareScreen.kt:493` |
| T0235 | botón | Probar el sonido | `PrepareScreen.kt:498` |
| T0236 | texto | Sonó [salida]. | `PrepareScreen.kt:502` |
| T0237 | texto | Si el dispositivo de audio se apaga solo, no sonará. | `PrepareScreen.kt:509` |
| T0238 | texto | Conecta un parlante o audífonos por Bluetooth para que suene. | `PrepareScreen.kt:509` |
| T0239 | validación | Falta el permiso de dispositivos cercanos. | `PrepareScreen.kt:526` |
| T0240 | texto | El Bluetooth del teléfono está apagado. | `PrepareScreen.kt:527` |
| T0241 | texto | Ese aparato no acepta la orden para pitar: no es un Tag compatible. | `PrepareScreen.kt:528` |
| T0242 | texto | No lo encontramos. Revisa que esté encendido y cerca, y que ninguna otra app, como iSearching, esté conectada a él: acepta una conexión a la vez. | `PrepareScreen.kt:529` |
| T0243 | texto | Buscar mi Tag | `PrepareScreen.kt:558` |
| T0244 | texto | Entendido | `PrepareScreen.kt:558` |
| T0245 | aviso | Relevo necesita el permiso de dispositivos cercanos para encontrar el Tag. Solo lo usa para eso. | `PrepareScreen.kt:579` |
| T0246 | título | Falta un permiso | `PrepareScreen.kt:579` |
| T0247 | acción | Abrir los ajustes de Relevo | `PrepareScreen.kt:580` |
| T0248 | aviso | Enciende el Bluetooth del teléfono para encontrar el Tag. | `PrepareScreen.kt:594` |
| T0249 | título | Bluetooth apagado | `PrepareScreen.kt:594` |
| T0250 | acción | Encender Bluetooth | `PrepareScreen.kt:595` |
| T0251 | texto | Buscando Tags cerca. Si está apagado, mantén apretado su botón 3 segundos, hasta que pite dos veces. | `PrepareScreen.kt:604` |
| T0252 | texto | Enciende el Tag: mantén apretado su botón 3 segundos, hasta que pite dos veces. Después elígelo en la lista. | `PrepareScreen.kt:605` |
| T0253 | acción | Cómo usar el Tag | `PrepareScreen.kt:609` |
| T0254 | texto | Buscando… | `PrepareScreen.kt:612` |
| T0255 | texto | Buscar de nuevo | `PrepareScreen.kt:612` |
| T0256 | texto | Buscar el Tag | `PrepareScreen.kt:612` |
| T0257 | texto | Para buscarlo, Android te pedirá permiso para encontrar dispositivos cercanos. Relevo solo recuerda el Tag que elijas, en este teléfono; no usa tu ubicación. | `PrepareScreen.kt:618` |
| T0258 | texto | Aparatos cerca | `PrepareScreen.kt:625` |
| T0259 | texto | Tags cerca | `PrepareScreen.kt:625` |
| T0260 | texto | Si es compatible, pita una vez al elegirlo. | `PrepareScreen.kt:626` |
| T0261 | texto | Al elegirlo, pita una vez para confirmarlo. | `PrepareScreen.kt:626` |
| T0262 | texto | No apareció ningún aparato con Bluetooth cerca. Revisa que el Tag esté encendido y cerca del teléfono, y búscalo de nuevo. | `PrepareScreen.kt:635` |
| T0263 | texto | No apareció ningún Tag. Revisa que esté encendido y cerca del teléfono, y búscalo de nuevo. Si lo usa otra app, como iSearching, ciérrala: el Tag acepta una conexión a la vez. | `PrepareScreen.kt:636` |
| T0264 | acción | Ver todos los aparatos cercanos | `PrepareScreen.kt:639` |
| T0265 | aviso | Ese aparato no aceptó la orden para pitar: no es un Tag compatible. Búscalo de nuevo y elige otro. | `PrepareScreen.kt:644` |
| T0266 | texto | Sirve un iTag, el llavero que se usa con la app iSearching. Mientras tanto, elige «Notificaciones». | `PrepareScreen.kt:649` |
| T0267 | fila | ¿No tienes un Tag? | `PrepareScreen.kt:650` |
| T0268 | subtítulo | Consíguelo en Mercado Libre | `PrepareScreen.kt:650` |
| T0269 | texto | Probando de otra forma… | `PrepareScreen.kt:658` |
| T0270 | texto | Probando… | `PrepareScreen.kt:659` |
| T0271 | texto | Probar el Tag | `PrepareScreen.kt:660` |
| T0272 | texto | Sonó. Al cumplirse el tiempo, pita hasta 30 segundos. | `PrepareScreen.kt:674` |
| T0273 | texto | Un toque a su botón lo calla; mantenerlo apretado lo apaga. | `PrepareScreen.kt:675` |
| T0274 | texto | Este Tag mantiene su alarma de alejamiento: si el teléfono se aleja mucho mientras espera, puede pitar solo. Para callarlo, tócalo una vez. | `PrepareScreen.kt:677` |
| T0275 | texto | Recibió la orden, pero no pitó. Apágalo y vuelve a encenderlo: mantén su botón apretado 3 segundos hasta que pite largo, y otra vez hasta que pite dos veces. Después pruébalo de nuevo. Si sigue sin pitar, elige otra salida. | `PrepareScreen.kt:681` |
| T0276 | título | El Tag no pitó | `PrepareScreen.kt:682` |
| T0277 | título | No sonó en el Tag | `PrepareScreen.kt:684` |
| T0278 | acción | Cómo usar el Tag | `PrepareScreen.kt:688` |
| T0279 | acción | Elegir otro Tag | `PrepareScreen.kt:690` |
| T0280 | texto | Déjalo encendido donde empiezas. Relevo se conecta a él al activar el relevo y lo mantiene así hasta que suene. | `PrepareScreen.kt:693` |
| T0281 | texto | ¿Lo escuchaste pitar? | `PrepareScreen.kt:705` |
| T0282 | texto | Lo probamos de otra forma. Debió pitar 3 segundos seguidos. | `PrepareScreen.kt:707` |
| T0283 | texto | Debió pitar 3 segundos seguidos. | `PrepareScreen.kt:707` |
| T0284 | botón | Sí, pitó | `PrepareScreen.kt:711` |
| T0285 | botón | No pitó | `PrepareScreen.kt:712` |
| T0286 | título | Elige las apps | `PrepareScreen.kt:723` |
| T0287 | botón | Listo | `PrepareScreen.kt:723` |
| T0288 | campo | Buscar | `PrepareScreen.kt:724` |
| T0289 | texto | Ej.: | `PrepareScreen.kt:739` |
| T0290 | texto | Abrir el libro | `PrepareScreen.kt:739` |

## 09 Cómo usar el Tag

22 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0291 | guía del Tag | El Tag | `TagGuide.kt:49` |
| T0292 | guía del Tag | Es un llavero Bluetooth con un solo botón. En muchos modelos el botón no se ve: es el centro de la cara de arriba, y al apretarlo firme se siente un clic. | `TagGuide.kt:49` |
| T0293 | guía del Tag | Enciéndelo | `TagGuide.kt:50` |
| T0294 | guía del Tag | Mantén apretado el botón 3 segundos, hasta que pite dos veces. Queda encendido: no hay que hacerlo cada vez. | `TagGuide.kt:50` |
| T0295 | guía del Tag | Búscalo en Relevo | `TagGuide.kt:51` |
| T0296 | guía del Tag | Ten el Tag cerca del teléfono y elígelo cuando aparezca en la lista. Pita una vez para confirmarlo. | `TagGuide.kt:51` |
| T0297 | guía del Tag | Déjalo donde empiezas | `TagGuide.kt:52` |
| T0298 | guía del Tag | Ponlo junto a lo que usas para empezar, como el libro o la guitarra. Sonará ahí cuando sumes el tiempo que elegiste en tus apps. | `TagGuide.kt:52` |
| T0299 | guía del Tag | Para callarlo, un toque | `TagGuide.kt:53` |
| T0300 | guía del Tag | Cuando suene, toca el botón una vez. No lo mantengas apretado: así se apaga. | `TagGuide.kt:53` |
| T0301 | guía del Tag | Para apagarlo | `TagGuide.kt:54` |
| T0302 | guía del Tag | Mantén apretado el botón 3 segundos, hasta que dé un pitido largo. Mientras uses Relevo, conviene dejarlo encendido. | `TagGuide.kt:54` |
| T0303 | guía del Tag | La pila dura meses | `TagGuide.kt:55` |
| T0304 | guía del Tag | Usa una pila de botón CR2032. Para cambiarla, abre la tapa por la ranura del borde con una uña o una moneda. | `TagGuide.kt:55` |
| T0305 | guía del Tag | Si no aparece o no pita | `TagGuide.kt:56` |
| T0306 | guía del Tag | El Tag se conecta a un solo teléfono a la vez: cierra iSearching, la app que trae el Tag, y, si lo usaste con otro teléfono, apaga el Bluetooth de ese teléfono. Si se conecta pero no pita, o si suena lento y sin parar, sácale la pila unos segundos y vuelve a ponerla. | `TagGuide.kt:56` |
| T0307 | texto | Entendido | `TagGuide.kt:64` |
| T0308 | título | Cómo usar el Tag | `TagGuide.kt:68` |
| T0309 | botón | Cerrar | `TagGuide.kt:68` |
| T0310 | texto | Paso [dato] de [dato] | `TagGuide.kt:83` |
| T0311 | botón | Atrás | `TagGuide.kt:93` |
| T0312 | texto | Siguiente | `TagGuide.kt:95` |

## 10 Hojas sobre Inicio

14 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0313 | texto | El relevo está contando | `HomeScreen.kt:480` |
| T0314 | texto | Suena [dato] cuando sumes [duración] en [apps elegidas]. | `HomeScreen.kt:483` |
| T0315 | texto | Mientras tanto, puedes completar el perfil: el nombre y lo que te gustaría hacer más seguido. | `HomeScreen.kt:489` |
| T0316 | botón | Completar el perfil | `HomeScreen.kt:491` |
| T0317 | botón | Más tarde | `HomeScreen.kt:493` |
| T0318 | botón | Entendido | `HomeScreen.kt:495` |
| T0319 | texto | Dijiste que empezaste «[actividad]» [dato]. | `RouteScreens.kt:152` |
| T0320 | texto | ¿Quieres probar el siguiente paso? | `RouteScreens.kt:154` |
| T0321 | botón | Probar el siguiente paso | `RouteScreens.kt:168` |
| T0322 | botón | Seguir en este paso | `RouteScreens.kt:169` |
| T0323 | texto | ¿Apagar el aviso semanal? | `RouteScreens.kt:178` |
| T0324 | texto | Puedes volver a encenderlo en Perfil › Ajustes › Avisos. | `RouteScreens.kt:180` |
| T0325 | botón | Apagarlo | `RouteScreens.kt:183` |
| T0326 | botón | Mantenerlo | `RouteScreens.kt:184` |

## 11 Tu relevo (contando)

29 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0327 | volver | Inicio | `HomeScreen.kt:559` |
| T0328 | texto | Contando | `HomeScreen.kt:560` |
| T0329 | texto | En pausa | `HomeScreen.kt:560` |
| T0330 | botón | Cambiar o desactivar | `HomeScreen.kt:561` |
| T0331 | texto | Faltan | `HomeScreen.kt:568` |
| T0332 | texto | de [duración] en [apps elegidas] | `HomeScreen.kt:571` |
| T0333 | fragmento | las apps que elegiste | `HomeScreen.kt:571` |
| T0334 | texto | Se activó solo. | `HomeScreen.kt:579` |
| T0335 | texto | Horas sin sonar: vuelve a contar a las [dato]:00 | `HomeScreen.kt:583` |
| T0336 | aviso | Falta el permiso de Tiempo de uso. | `HomeScreen.kt:588` |
| T0337 | título | Relevo no puede contar | `HomeScreen.kt:588` |
| T0338 | acción | Dar el permiso | `HomeScreen.kt:589` |
| T0339 | título | Batería | `HomeScreen.kt:594` |
| T0340 | acción | Quitar la restricción | `HomeScreen.kt:595` |
| T0341 | texto | Relevo | `HomeScreen.kt:601` |
| T0342 | fila | Editar | `HomeScreen.kt:604` |
| T0343 | subtítulo | Mientras lo editas no cuenta. | `HomeScreen.kt:604` |
| T0344 | fila | Desactivar | `HomeScreen.kt:605` |
| T0345 | subtítulo | Deja de contar y no suena. | `HomeScreen.kt:605` |
| T0346 | fila | Eliminar | `HomeScreen.kt:606` |
| T0347 | subtítulo | Si lo activaste por error. | `HomeScreen.kt:606` |
| T0348 | texto | ¿Eliminar este relevo? | `HomeScreen.kt:612` |
| T0349 | texto | Deja de contar, no suena y no queda en Relevos. | `HomeScreen.kt:614` |
| T0350 | botón | Eliminar | `HomeScreen.kt:616` |
| T0351 | botón | Mantenerlo | `HomeScreen.kt:618` |
| T0352 | texto | ¿Desactivar el relevo? | `HomeScreen.kt:623` |
| T0353 | texto | Deja de contar y no suena. Después puedes decir qué decidiste. | `HomeScreen.kt:625` |
| T0354 | botón | Desactivar | `HomeScreen.kt:627` |
| T0355 | botón | Mantenerlo | `HomeScreen.kt:629` |

## 12 Suena

13 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0356 | etiqueta | No sonó | `SignalScreens.kt:99` |
| T0357 | etiqueta | Suena | `SignalScreens.kt:100` |
| T0358 | etiqueta | Ya dejó de sonar | `SignalScreens.kt:101` |
| T0359 | texto | Es momento de volver a elegir | `SignalScreens.kt:105` |
| T0360 | texto | El Tag no respondió; sonó en tu teléfono. | `SignalScreens.kt:114` |
| T0361 | título | Se cumplió el tiempo | `SignalScreens.kt:119` |
| T0362 | acción | Probar otra vez | `SignalScreens.kt:121` |
| T0363 | acción | Sonar en el teléfono | `SignalScreens.kt:122` |
| T0364 | texto | Ahora sonó. | `SignalScreens.kt:123` |
| T0365 | texto | Todavía no suena. | `SignalScreens.kt:123` |
| T0366 | texto | Silenciar y continuar | `SignalScreens.kt:127` |
| T0367 | texto | Continuar | `SignalScreens.kt:127` |
| T0368 | texto | Un toque al botón del Tag también lo calla. | `SignalScreens.kt:129` |

## 13 Preguntas y ¿Qué decidiste?

31 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0369 | texto | Bien | `Feedback.kt:43` |
| T0370 | texto | Normal | `Feedback.kt:44` |
| T0371 | texto | Mal | `Feedback.kt:45` |
| T0372 | etiqueta | Después de la señal | `SignalScreens.kt:173` |
| T0373 | acción | Saltar | `SignalScreens.kt:174` |
| T0374 | texto | Cuatro preguntas de un toque | `SignalScreens.kt:175` |
| T0375 | texto | ¿La dejas lista para después? | `SignalScreens.kt:175` |
| T0376 | texto | Queda en Inicio para activarla con un toque. No suena sola. | `SignalScreens.kt:176` |
| T0377 | botón | Seguir | `SignalScreens.kt:178` |
| T0378 | botón | Dejarla lista | `SignalScreens.kt:181` |
| T0379 | botón | No, gracias | `SignalScreens.kt:182` |
| T0380 | pregunta | ¿Notaste el aviso apenas sonó? | `SignalScreens.kt:195` |
| T0381 | texto | Enseguida | `SignalScreens.kt:196` |
| T0382 | texto | Un rato después | `SignalScreens.kt:196` |
| T0383 | texto | No lo noté | `SignalScreens.kt:196` |
| T0384 | pregunta | ¿Cómo te cayó el sonido? | `SignalScreens.kt:199` |
| T0385 | pregunta | Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla? | `SignalScreens.kt:201` |
| T0386 | texto | Sí | `SignalScreens.kt:202` |
| T0387 | texto | A medias | `SignalScreens.kt:202` |
| T0388 | texto | No | `SignalScreens.kt:202` |
| T0389 | pregunta | ¿Recordaste cómo empezar? | `SignalScreens.kt:205` |
| T0390 | texto | Sí | `SignalScreens.kt:206` |
| T0391 | texto | No | `SignalScreens.kt:206` |
| T0392 | texto | Sonó [lugar]. | `SignalScreens.kt:216` |
| T0393 | fragmento | en tu teléfono | `SignalScreens.kt:216` |
| T0394 | texto | Desactivaste el relevo. | `SignalScreens.kt:217` |
| T0395 | texto | ¿Qué decidiste? | `SignalScreens.kt:221` |
| T0396 | texto | Ninguna respuesta es mejor que otra. | `SignalScreens.kt:224` |
| T0397 | opción | Comencé la actividad | `SignalScreens.kt:229` |
| T0398 | opción | La dejé para después | `SignalScreens.kt:230` |
| T0399 | opción | Cambié de idea | `SignalScreens.kt:231` |

## 14 Actividades (antes Ruta)

28 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0400 | texto | Creadas por ti | `ActivitiesScreens.kt:75` |
| T0401 | texto | Paso a paso | `ActivitiesScreens.kt:75` |
| T0402 | texto | Ideas | `ActivitiesScreens.kt:75` |
| T0403 | título | Actividades | `ActivitiesScreens.kt:110` |
| T0404 | texto | Todavía no tienes actividades | `ActivitiesScreens.kt:138` |
| T0405 | texto | Guarda lo que haces seguido, con cómo empiezas y dónde. Después lo preparas en un toque. | `ActivitiesScreens.kt:139` |
| T0406 | botón | Crear una actividad | `ActivitiesScreens.kt:141` |
| T0407 | texto | Nueva | `ActivitiesScreens.kt:147` |
| T0408 | texto | Preparar un relevo | `ActivitiesScreens.kt:155` |
| T0409 | texto | Editar | `ActivitiesScreens.kt:156` |
| T0410 | texto | Preparar un relevo | `ActivitiesScreens.kt:180` |
| T0411 | texto | ¿Qué te gustaría hacer más seguido? | `ActivitiesScreens.kt:236` |
| T0412 | texto | Elige intereses y te sugerimos pasos pequeños. | `ActivitiesScreens.kt:237` |
| T0413 | botón | Elegir intereses | `ActivitiesScreens.kt:239` |
| T0414 | texto | Todavía no tiene pasos. | `ActivitiesScreens.kt:256` |
| T0415 | botón | Agregar pasos | `ActivitiesScreens.kt:257` |
| T0416 | texto | Paso actual | `ActivitiesScreens.kt:267` |
| T0417 | texto | Ahora | `ActivitiesScreens.kt:268` |
| T0418 | texto | Hecho | `ActivitiesScreens.kt:268` |
| T0419 | texto | Siguiente | `ActivitiesScreens.kt:268` |
| T0420 | botón | Preparar este paso | `ActivitiesScreens.kt:277` |
| T0421 | acción | Editar los pasos | `ActivitiesScreens.kt:280` |
| T0422 | acción | Cambiar intereses | `ActivitiesScreens.kt:282` |
| T0423 | texto | Ahora | `ActivitiesScreens.kt:299` |
| T0424 | texto | Paso [número] de [dato] | `ActivitiesScreens.kt:299` |
| T0425 | botón | Preparar este paso | `ActivitiesScreens.kt:310` |
| T0426 | texto | Pasar a este paso | `ActivitiesScreens.kt:313` |
| T0427 | texto | Volver a este paso | `ActivitiesScreens.kt:313` |

## 15 Editar la ruta

19 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0428 | volver | Cancelar | `RouteScreens.kt:69` |
| T0429 | botón | Guardar | `RouteScreens.kt:70` |
| T0430 | texto | No hay cambios que guardar. | `RouteScreens.kt:70` |
| T0431 | lector de pantalla | Más opciones de [actividad] | `RouteScreens.kt:82` |
| T0432 | texto | Editar | `RouteScreens.kt:87` |
| T0433 | texto | Subir | `RouteScreens.kt:88` |
| T0434 | texto | Bajar | `RouteScreens.kt:89` |
| T0435 | texto | Pasar a este paso | `RouteScreens.kt:91` |
| T0436 | texto | Volver a este paso | `RouteScreens.kt:91` |
| T0437 | texto | Borrar | `RouteScreens.kt:93` |
| T0438 | botón | Agregar un paso | `RouteScreens.kt:102` |
| T0439 | texto | Nuevo paso | `RouteScreens.kt:129` |
| T0440 | texto | Editar el paso | `RouteScreens.kt:129` |
| T0441 | campo | Actividad | `RouteScreens.kt:131` |
| T0442 | ayuda del campo | Ej.: caminar 30 minutos | `RouteScreens.kt:131` |
| T0443 | ayuda del campo | Ej.: ponerte las zapatillas | `RouteScreens.kt:133` |
| T0444 | ayuda del campo | Ej.: junto a la puerta | `RouteScreens.kt:135` |
| T0445 | botón | Guardar el paso | `RouteScreens.kt:137` |
| T0446 | validación | Escribe la actividad del paso. | `RouteScreens.kt:138` |

## 16 Perfil

26 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0447 | texto | Perfil | `ProfileScreens.kt:117` |
| T0448 | fila | Relevos | `ProfileScreens.kt:121` |
| T0449 | texto | relevo terminado | `ProfileScreens.kt:121` |
| T0450 | texto | relevos terminados | `ProfileScreens.kt:121` |
| T0451 | texto | Todavía no terminas ninguno | `ProfileScreens.kt:121` |
| T0452 | fila | Actividades | `ProfileScreens.kt:122` |
| T0453 | texto | actividad guardada | `ProfileScreens.kt:122` |
| T0454 | texto | actividades guardadas | `ProfileScreens.kt:122` |
| T0455 | texto | Guarda las que haces seguido | `ProfileScreens.kt:122` |
| T0456 | fila | Pasos | `ProfileScreens.kt:123` |
| T0457 | texto | Ahora: [dato] | `ProfileScreens.kt:123` |
| T0458 | validación | Elige intereses | `ProfileScreens.kt:123` |
| T0459 | texto | Apps | `ProfileScreens.kt:126` |
| T0460 | texto | Las que cuentan el tiempo | `ProfileScreens.kt:127` |
| T0461 | fila | Ajustes | `ProfileScreens.kt:134` |
| T0462 | subtítulo | Sonido, avisos, apariencia y datos | `ProfileScreens.kt:134` |
| T0463 | título | Ayuda | `ProfileScreens.kt:137` |
| T0464 | fila | Cómo funciona Relevo | `ProfileScreens.kt:138` |
| T0465 | fila | Cómo usar el Tag | `ProfileScreens.kt:139` |
| T0466 | fila | Envíanos un comentario | `ProfileScreens.kt:140` |
| T0467 | fila | Reportar un problema | `ProfileScreens.kt:141` |
| T0468 | texto | Relevo [dato] · Proyecto de Título de Diseño, Universidad Diego Portales | `ProfileScreens.kt:145` |
| T0469 | texto | Ajustes | `ProfileScreens.kt:154` |
| T0470 | lector de pantalla | Editar el perfil | `ProfileScreens.kt:166` |
| T0471 | texto | Perfil | `ProfileScreens.kt:173` |
| T0472 | acción | Editar el perfil | `ProfileScreens.kt:176` |

## 17 Editar el perfil

14 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0473 | título | Perfil | `ProfileScreens.kt:320` |
| T0474 | volver | Cancelar | `ProfileScreens.kt:321` |
| T0475 | botón | Guardar | `ProfileScreens.kt:323` |
| T0476 | validación | Escribe tu nombre. | `ProfileScreens.kt:324` |
| T0477 | validación | Escribe cuál es tu otro interés. | `ProfileScreens.kt:325` |
| T0478 | texto | No hay cambios que guardar. | `ProfileScreens.kt:326` |
| T0479 | lector de pantalla | Cambiar el emoji | `ProfileScreens.kt:335` |
| T0480 | acción | Cambiar el emoji | `ProfileScreens.kt:338` |
| T0481 | campo | Nombre | `ProfileScreens.kt:341` |
| T0482 | ayuda del campo | Como quieras que te diga Relevo | `ProfileScreens.kt:341` |
| T0483 | rótulo | Intereses | `ProfileScreens.kt:343` |
| T0484 | subtítulo | Elige una o varias. | `ProfileScreens.kt:343` |
| T0485 | título | Emoji | `ProfileScreens.kt:347` |
| T0486 | botón | Listo | `ProfileScreens.kt:347` |

## 18 Avisos y resúmenes

16 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0487 | título | Avisos | `SettingsScreens.kt:189` |
| T0488 | volver | Ajustes | `SettingsScreens.kt:189` |
| T0489 | texto | Primero prepara y termina un relevo: la activación automática repite ese. | `SettingsScreens.kt:194` |
| T0490 | texto | Mientras está encendida, Relevo mira qué app tienes abierta, solo su nombre. Después de cada relevo espera 30 minutos. | `SettingsScreens.kt:195` |
| T0491 | texto | Activación automática | `SettingsScreens.kt:198` |
| T0492 | subtítulo | Al abrir las apps del último relevo, empieza a contar solo. | `SettingsScreens.kt:199` |
| T0493 | texto | Resumen semanal | `SettingsScreens.kt:203` |
| T0494 | subtítulo | «Esta semana», en Inicio. | `SettingsScreens.kt:204` |
| T0495 | texto | Aviso semanal | `SettingsScreens.kt:205` |
| T0496 | subtítulo | Si pasas una semana sin abrir Relevo, te avisa una vez. | `SettingsScreens.kt:208` |
| T0497 | texto | Mensaje al responder | `SettingsScreens.kt:209` |
| T0498 | subtítulo | Unas palabras después de decir qué decidiste. | `SettingsScreens.kt:210` |
| T0499 | texto | Veces por semana | `SettingsScreens.kt:211` |
| T0500 | subtítulo | Cuántas veces quieres hacerlo. Aparece en «Esta semana». | `SettingsScreens.kt:212` |
| T0501 | texto | Retomar | `SettingsScreens.kt:218` |
| T0502 | texto | Pausar | `SettingsScreens.kt:218` |

## 19 Apariencia

9 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0503 | título | Apariencia | `SettingsScreens.kt:228` |
| T0504 | volver | Ajustes | `SettingsScreens.kt:228` |
| T0505 | texto | Tema | `SettingsScreens.kt:230` |
| T0506 | texto | Claro, oscuro o como esté el teléfono. | `SettingsScreens.kt:230` |
| T0507 | texto | Claro | `SettingsScreens.kt:231` |
| T0508 | texto | Oscuro | `SettingsScreens.kt:231` |
| T0509 | texto | Automático | `SettingsScreens.kt:231` |
| T0510 | texto | Se suma al tamaño que usas en el teléfono. | `SettingsScreens.kt:235` |
| T0511 | texto | Letra grande | `SettingsScreens.kt:236` |

## 20 Permisos

15 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0512 | título | Permisos | `SettingsScreens.kt:247` |
| T0513 | volver | Ajustes | `SettingsScreens.kt:247` |
| T0514 | texto | Tiempo de uso es necesario para contar. En Android se llama «Acceso a datos de uso». Lo demás es opcional. | `SettingsScreens.kt:248` |
| T0515 | fila | Tiempo de uso | `SettingsScreens.kt:249` |
| T0516 | subtítulo | Para contar el tiempo en las apps que elijas | `SettingsScreens.kt:249` |
| T0517 | texto | Permitido | `SettingsScreens.kt:249` |
| T0518 | validación | Falta | `SettingsScreens.kt:249` |
| T0519 | fila | Notificaciones | `SettingsScreens.kt:250` |
| T0520 | subtítulo | Para avisarte aunque estés en otra app | `SettingsScreens.kt:250` |
| T0521 | texto | Permitidas | `SettingsScreens.kt:250` |
| T0522 | texto | Apagadas | `SettingsScreens.kt:250` |
| T0523 | fila | Batería | `SettingsScreens.kt:252` |
| T0524 | subtítulo | Para que Android no detenga a Relevo | `SettingsScreens.kt:252` |
| T0525 | texto | Sin restricciones | `SettingsScreens.kt:252` |
| T0526 | texto | Con restricciones | `SettingsScreens.kt:252` |

## 21 Relevos

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0527 | título | Tus relevos | `SettingsScreens.kt:261` |
| T0528 | volver | Perfil | `SettingsScreens.kt:261` |
| T0529 | texto | Aquí verás los relevos que termines. | `SettingsScreens.kt:263` |
| T0530 | texto | Hoy | `SettingsScreens.kt:269` |
| T0531 | texto | Ayer | `SettingsScreens.kt:270` |
| T0532 | texto | Sonó | `SettingsScreens.kt:277` |
| T0533 | texto | Terminó antes de sonar | `SettingsScreens.kt:277` |

## 22 Ajustes

26 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0534 | texto | Claro | `SettingsScreens.kt:106` |
| T0535 | texto | Oscuro | `SettingsScreens.kt:106` |
| T0536 | texto | Automático | `SettingsScreens.kt:106` |
| T0537 | título | Ajustes | `SettingsScreens.kt:110` |
| T0538 | volver | Perfil | `SettingsScreens.kt:110` |
| T0539 | fila | Sonido | `SettingsScreens.kt:112` |
| T0540 | fila | Horas sin sonar | `SettingsScreens.kt:113` |
| T0541 | texto | Apagadas | `SettingsScreens.kt:113` |
| T0542 | fila | Avisos | `SettingsScreens.kt:114` |
| T0543 | texto | Aviso semanal encendido | `SettingsScreens.kt:114` |
| T0544 | texto | Aviso semanal apagado | `SettingsScreens.kt:114` |
| T0545 | fila | Apariencia | `SettingsScreens.kt:115` |
| T0546 | texto | · letra grande | `SettingsScreens.kt:115` |
| T0547 | fila | Permisos | `SettingsScreens.kt:116` |
| T0548 | texto | Todo listo para contar | `SettingsScreens.kt:116` |
| T0549 | validación | Falta Tiempo de uso | `SettingsScreens.kt:116` |
| T0550 | fila | Datos | `SettingsScreens.kt:117` |
| T0551 | subtítulo | Privacidad, código y borrado | `SettingsScreens.kt:117` |
| T0552 | título | Sonido | `SettingsScreens.kt:157` |
| T0553 | botón | Listo | `SettingsScreens.kt:157` |
| T0554 | texto | Volumen | `SettingsScreens.kt:167` |
| T0555 | texto | El volumen multimedia del teléfono también cuenta. | `SettingsScreens.kt:167` |
| T0556 | texto | Suave | `SettingsScreens.kt:168` |
| T0557 | texto | Medio | `SettingsScreens.kt:168` |
| T0558 | texto | Fuerte | `SettingsScreens.kt:168` |
| T0559 | texto | En el Tag suena siempre su propio pitido, con su volumen. | `SettingsScreens.kt:172` |

## 23 Crear o editar una actividad

30 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0560 | título | Nueva actividad | `ActivitiesScreens.kt:385` |
| T0561 | volver | Cancelar | `ActivitiesScreens.kt:386` |
| T0562 | botón | Crear una propia | `ActivitiesScreens.kt:387` |
| T0563 | texto | Ya guardaste todas las predefinidas. | `ActivitiesScreens.kt:390` |
| T0564 | texto | Nueva actividad | `ActivitiesScreens.kt:430` |
| T0565 | texto | Editar la actividad | `ActivitiesScreens.kt:430` |
| T0566 | texto | Volver | `ActivitiesScreens.kt:431` |
| T0567 | texto | Cancelar | `ActivitiesScreens.kt:431` |
| T0568 | botón | Guardar | `ActivitiesScreens.kt:433` |
| T0569 | validación | Escribe el nombre de la actividad. | `ActivitiesScreens.kt:436` |
| T0570 | texto | Usa hasta 60 caracteres en el nombre. | `ActivitiesScreens.kt:437` |
| T0571 | texto | Ya tienes una actividad con ese nombre. | `ActivitiesScreens.kt:438` |
| T0572 | validación | Escribe cómo empiezas la actividad. | `ActivitiesScreens.kt:439` |
| T0573 | validación | Escribe en qué lugar empieza. | `ActivitiesScreens.kt:440` |
| T0574 | lector de pantalla | Cambiar el ícono | `ActivitiesScreens.kt:446` |
| T0575 | acción | Cambiar el ícono | `ActivitiesScreens.kt:447` |
| T0576 | campo | Actividad | `ActivitiesScreens.kt:450` |
| T0577 | ayuda del campo | Ej.: practicar guitarra | `ActivitiesScreens.kt:450` |
| T0578 | texto | Ya tienes una actividad con ese nombre. | `ActivitiesScreens.kt:451` |
| T0579 | botón | Borrar la actividad | `ActivitiesScreens.kt:461` |
| T0580 | texto | Ej.: sacar la guitarra del estuche | `ActivitiesScreens.kt:465` |
| T0581 | texto | Ej.: junto a la guitarra | `ActivitiesScreens.kt:466` |
| T0582 | título | Elige un ícono | `ActivitiesScreens.kt:470` |
| T0583 | botón | Listo | `ActivitiesScreens.kt:470` |
| T0584 | texto | ¿Borrar «[nombre]»? | `ActivitiesScreens.kt:489` |
| T0585 | texto | Se quita de «Creadas por ti». Los relevos que ya hiciste se mantienen. | `ActivitiesScreens.kt:491` |
| T0586 | botón | Borrar | `ActivitiesScreens.kt:493` |
| T0587 | botón | Cancelar | `ActivitiesScreens.kt:495` |
| T0588 | botón | Listo | `ActivitiesScreens.kt:506` |
| T0589 | campo | O escríbelo | `ActivitiesScreens.kt:509` |

## 24 Privacidad y datos

30 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0590 | texto | Todo está enviado. | `Common.kt:294` |
| T0591 | texto | Algunos datos se enviarán cuando haya internet. | `Common.kt:294` |
| T0592 | texto | Último envío: [dato]. | `Common.kt:295` |
| T0593 | texto | En Documentos/Relevo. Última copia: [dato]. | `Common.kt:300` |
| T0594 | texto | Se crea en Documentos/Relevo con el primer relevo. | `Common.kt:300` |
| T0595 | texto | Borrando tus datos… | `RelevoViewModel.kt:1107` |
| T0596 | texto | Relevo dejó de guardar datos, pero no se pudo confirmar el borrado en la base del proyecto. Tus datos siguen en el teléfono. Prueba otra vez o escribe a [correo del investigador]. | `RelevoViewModel.kt:1151` |
| T0597 | texto | Tus datos se borraron. Si quieres volver a usar Relevo, tendrás que aceptar otra vez. | `RelevoViewModel.kt:1203` |
| T0598 | texto | Tus datos quedaron en el archivo que elegiste. | `SettingsScreens.kt:312` |
| T0599 | texto | No se pudo guardar el archivo. Prueba otra vez. | `SettingsScreens.kt:312` |
| T0600 | título | Tus datos | `SettingsScreens.kt:315` |
| T0601 | volver | Ajustes | `SettingsScreens.kt:315` |
| T0602 | botón | Volver a comenzar | `SettingsScreens.kt:316` |
| T0603 | texto | Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte, solo con ese código. No vemos lo que haces dentro de otras apps. Si no borras tus datos antes, los borramos el 30 de diciembre de 2026. | `SettingsScreens.kt:319` |
| T0604 | fila | Tu código | `SettingsScreens.kt:326` |
| T0605 | texto | Sin código | `SettingsScreens.kt:326` |
| T0606 | fila | Lo que aceptaste | `SettingsScreens.kt:329` |
| T0607 | fila | Datos enviados | `SettingsScreens.kt:330` |
| T0608 | fila | Copia en el teléfono | `SettingsScreens.kt:331` |
| T0609 | texto | Primero se borra en la base del proyecto. Si no se puede, Relevo deja de guardar datos y conserva lo del teléfono para intentarlo otra vez. | `SettingsScreens.kt:335` |
| T0610 | fila | Descargar mis datos | `SettingsScreens.kt:336` |
| T0611 | subtítulo | Un archivo con todo lo guardado en el teléfono. | `SettingsScreens.kt:336` |
| T0612 | fila | Borrar mis datos | `SettingsScreens.kt:338` |
| T0613 | subtítulo | También sales del proyecto. | `SettingsScreens.kt:338` |
| T0614 | texto | ¿Dudas, o prefieres pedir el borrado por correo? Escribe a [correo del investigador] con tu código. | `SettingsScreens.kt:343` |
| T0615 | texto | ¿Borrar tus datos? | `SettingsScreens.kt:353` |
| T0616 | texto | Se borran tus relevos, actividades, perfil, ruta y respuestas, también en la base del proyecto y en la copia de Documentos/Relevo. Sales del proyecto y Relevo deja de contar. | `SettingsScreens.kt:355` |
| T0617 | botón | Borrar mis datos | `SettingsScreens.kt:357` |
| T0618 | botón | Cancelar | `SettingsScreens.kt:359` |
| T0619 | texto | Código de participación | `SettingsScreens.kt:365` |

## 25 Lo que aceptaste

2 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0620 | título | Lo que aceptaste | `FirstRunScreens.kt:234` |
| T0621 | subtítulo | Aceptaste usar Relevo con este texto. | `FirstRunScreens.kt:234` |

## 29 Envíanos un comentario (antes, Opinar sobre Relevo)

7 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0622 | título | Envíanos un comentario | `SettingsScreens.kt:375` |
| T0623 | volver | Cerrar | `SettingsScreens.kt:376` |
| T0624 | botón | Enviar | `SettingsScreens.kt:377` |
| T0625 | validación | Escribe un comentario o elige las estrellas. | `SettingsScreens.kt:377` |
| T0626 | campo | Comentario | `SettingsScreens.kt:379` |
| T0627 | texto | Ej.: me gustaría elegir otro sonido | `SettingsScreens.kt:379` |
| T0628 | texto | ¿Cómo te resultó Relevo? | `SettingsScreens.kt:381` |

## 30 Reportar un problema

8 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0629 | título | Reportar un problema | `SettingsScreens.kt:393` |
| T0630 | volver | Cerrar | `SettingsScreens.kt:394` |
| T0631 | botón | Enviar | `SettingsScreens.kt:395` |
| T0632 | validación | Escribe qué pasó. | `SettingsScreens.kt:395` |
| T0633 | campo | ¿Qué pasó? | `SettingsScreens.kt:397` |
| T0634 | texto | Ej.: no sonó en el parlante | `SettingsScreens.kt:397` |
| T0635 | texto | Adjuntar datos técnicos | `SettingsScreens.kt:407` |
| T0636 | texto | Versión, permisos y estado del envío. Nada de lo que haces en tus apps. | `SettingsScreens.kt:408` |

## 31 Notificaciones

37 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0637 | texto | Se activa solo | `AppUsageMonitorService.kt:134` |
| T0638 | texto | En pausa | `AppUsageMonitorService.kt:135` |
| T0639 | texto | Contando [dato] relevos | `AppUsageMonitorService.kt:136` |
| T0640 | texto | Contando para «[actividad]» | `AppUsageMonitorService.kt:137` |
| T0641 | texto | Contando | `AppUsageMonitorService.kt:138` |
| T0642 | texto | Al abrir las apps del último relevo | `AppUsageMonitorService.kt:141` |
| T0643 | texto | Horas sin sonar, hasta las [dato]:00 | `AppUsageMonitorService.kt:142` |
| T0644 | texto | El Tag no responde; si sigue así, suena en tu teléfono | `AppUsageMonitorService.kt:143` |
| T0645 | texto | El próximo en sonar: «[actividad]» | `AppUsageMonitorService.kt:144` |
| T0646 | texto | Suena al sumar [dato] | `AppUsageMonitorService.kt:145` |
| T0647 | texto | Hasta que lo desactives | `AppUsageMonitorService.kt:146` |
| T0648 | notificación | Contando | `AppUsageMonitorService.kt:150` |
| T0649 | notificación | Se activa solo | `AppUsageMonitorService.kt:150` |
| T0650 | notificación: título | Dejó de contar | `AppUsageMonitorService.kt:449` |
| T0651 | notificación: texto | Falta el permiso de Tiempo de uso | `AppUsageMonitorService.kt:450` |
| T0652 | notificación: texto | Falta el permiso de Tiempo de uso. Sin él, Relevo no puede contar. | `AppUsageMonitorService.kt:451` |
| T0653 | lector de pantalla | Muestra que Relevo está contando el tiempo en las apps que elegiste o esperando para activarse solo. | `AppUsageMonitorService.kt:473` |
| T0654 | lector de pantalla | Suena cuando sumas el tiempo que elegiste. | `AppUsageMonitorService.kt:478` |
| T0655 | lector de pantalla | Avisa si Relevo dejó de contar, por ejemplo al retirar un permiso. | `AppUsageMonitorService.kt:485` |
| T0656 | notificación: título | Relevo | `AppUsageMonitorService.kt:499` |
| T0657 | texto | No sonó en el dispositivo de audio | `AppUsageMonitorService.kt:504` |
| T0658 | texto | No sonó en el Tag ni en tu teléfono | `AppUsageMonitorService.kt:505` |
| T0659 | texto | No sonó en tu teléfono | `AppUsageMonitorService.kt:506` |
| T0660 | texto | El Tag no respondió; sonó en tu teléfono | `AppUsageMonitorService.kt:507` |
| T0661 | texto | Empieza por [primer paso] | `AppUsageMonitorService.kt:509` |
| T0662 | notificación | Relevo | `AppUsageMonitorService.kt:515` |
| T0663 | notificación | Es momento de volver a elegir | `AppUsageMonitorService.kt:538` |
| T0664 | lector de pantalla | Mensajes del autor del proyecto sobre Relevo. | `ProjectMessages.kt:116` |
| T0665 | notificación: título | Relevo | `ProjectMessages.kt:128` |
| T0666 | notificación: texto | Tienes un mensaje nuevo | `ProjectMessages.kt:129` |
| T0667 | notificación | ¿Quieres preparar un relevo esta semana? | `ReturnNotice.kt:31` |
| T0668 | lector de pantalla | Una vez por semana como máximo, si no abriste Relevo. Se apaga en Perfil › Ajustes › Avisos. | `ReturnNotice.kt:67` |
| T0669 | notificación | Esta semana | `ReturnNotice.kt:72` |
| T0670 | notificación | ¿Sigue en pie esta semana? | `ReturnNotice.kt:73` |
| T0671 | notificación: título | Relevo | `ReturnNotice.kt:77` |
| T0672 | notificación: botón | Preparar | `ReturnNotice.kt:97` |
| T0673 | notificación: botón | Ahora no | `ReturnNotice.kt:98` |

## 32 Textos compartidos

36 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0674 | texto | ¿Cómo empiezas la actividad? | `Common.kt:53` |
| T0675 | texto | ¿En qué lugar empieza? | `Common.kt:54` |
| T0676 | texto | Para empezar: [primer paso], [lugar]. | `Common.kt:218` |
| T0677 | texto | Para empezar: [primer paso]. | `Common.kt:219` |
| T0678 | texto | Empieza [lugar]. | `Common.kt:220` |
| T0679 | texto | donde lo dejaste | `Common.kt:228` |
| T0680 | texto | detrás | `Common.kt:230` |
| T0681 | texto | en «[dato]» | `Common.kt:231` |
| T0682 | texto | Dispositivo de audio | `Common.kt:263` |
| T0683 | texto | Tag | `Common.kt:264` |
| T0684 | texto | Teléfono | `Common.kt:265` |
| T0685 | texto | Notificaciones | `Common.kt:273` |
| T0686 | texto | en tu teléfono | `Common.kt:277` |
| T0687 | texto | en el | `Common.kt:278` |
| T0688 | texto | No sonó en el dispositivo de audio. Revisa que esté encendido y conectado. | `Common.kt:288` |
| T0689 | texto | No sonó en el Tag. Revisa que esté encendido y cerca del teléfono. | `Common.kt:289` |
| T0690 | texto | No sonó en tu teléfono. Revisa el volumen. | `Common.kt:290` |
| T0691 | texto | Dijiste que empezaste | `Common.kt:312` |
| T0692 | texto | La dejaste para después | `Common.kt:313` |
| T0693 | texto | Cambiaste de idea | `Common.kt:314` |
| T0694 | texto | Queda anotado. Gracias por decirlo. | `Common.kt:330` |
| T0695 | texto | Queda anotado. Puedes prepararlo cuando quieras. | `Common.kt:331` |
| T0696 | texto | Está bien. Puedes elegir otra actividad cuando quieras. | `Common.kt:332` |
| T0697 | texto | , donde empiezas | `Common.kt:354` |
| T0698 | texto | Para después | `HomeScreen.kt:507` |
| T0699 | botón | Activar ahora | `HomeScreen.kt:511` |
| T0700 | acción | Ahora no | `HomeScreen.kt:512` |
| T0701 | texto | Suave | `SettingsScreens.kt:125` |
| T0702 | texto | Medio | `SettingsScreens.kt:126` |
| T0703 | texto | Fuerte | `SettingsScreens.kt:127` |
| T0704 | título | Horas sin sonar | `SettingsScreens.kt:136` |
| T0705 | botón | Listo | `SettingsScreens.kt:136` |
| T0706 | texto | En esas horas Relevo no cuenta ni suena. El relevo sigue activo y retoma al terminar. | `SettingsScreens.kt:137` |
| T0707 | texto | Horas sin sonar | `SettingsScreens.kt:138` |
| T0708 | texto | Desde las [dato]:00 | `SettingsScreens.kt:143` |
| T0709 | texto | Hasta las [dato]:00 | `SettingsScreens.kt:144` |

## 33 Ideas, sugerencias y rutas

388 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T0710 | texto | Dormir a tiempo | `Route.kt:59` |
| T0711 | texto | Acostarte sin el teléfono | `Route.kt:60` |
| T0712 | texto | Dejar el teléfono cargando lejos de la cama | `Route.kt:60` |
| T0713 | texto | Junto al cargador | `Route.kt:60` |
| T0714 | texto | Leer un rato antes de dormir | `Route.kt:61` |
| T0715 | texto | Dejar el libro en el velador | `Route.kt:61` |
| T0716 | texto | En el velador | `Route.kt:61` |
| T0717 | texto | Acostarte a la misma hora | `Route.kt:62` |
| T0718 | texto | Apagar la luz grande | `Route.kt:62` |
| T0719 | texto | Junto al interruptor | `Route.kt:62` |
| T0720 | texto | Leer | `Route.kt:65` |
| T0721 | texto | Leer 10 páginas | `Route.kt:66` |
| T0722 | texto | Abrir el libro | `Route.kt:66` |
| T0723 | texto | En el velador | `Route.kt:66` |
| T0724 | texto | Leer un capítulo de manga | `Route.kt:67` |
| T0725 | texto | Sacar el tomo del estante | `Route.kt:67` |
| T0726 | texto | Junto al estante | `Route.kt:67` |
| T0727 | texto | Leer un capítulo | `Route.kt:68` |
| T0728 | texto | Abrir el libro en el marcador | `Route.kt:68` |
| T0729 | texto | En el velador | `Route.kt:68` |
| T0730 | texto | Hacer ejercicio | `Route.kt:71` |
| T0731 | texto | Hacer una serie corta | `Route.kt:72` |
| T0732 | texto | Ponerte ropa cómoda | `Route.kt:72` |
| T0733 | texto | Junto al clóset | `Route.kt:72` |
| T0734 | texto | Entrenar 20 minutos | `Route.kt:73` |
| T0735 | texto | Estirar la colchoneta | `Route.kt:73` |
| T0736 | texto | Donde guardas la colchoneta | `Route.kt:73` |
| T0737 | texto | Ir a entrenar | `Route.kt:74` |
| T0738 | texto | Preparar el bolso | `Route.kt:74` |
| T0739 | texto | Junto a la puerta | `Route.kt:74` |
| T0740 | texto | Salir en bicicleta | `Route.kt:77` |
| T0741 | texto | Dar una vuelta corta | `Route.kt:78` |
| T0742 | texto | Sacar la bici | `Route.kt:78` |
| T0743 | texto | Junto a la puerta | `Route.kt:78` |
| T0744 | texto | Andar 30 minutos | `Route.kt:79` |
| T0745 | texto | Inflar las ruedas | `Route.kt:79` |
| T0746 | texto | Junto a la bici | `Route.kt:79` |
| T0747 | texto | Ir en bici a algún lugar | `Route.kt:80` |
| T0748 | texto | Ponerte el casco | `Route.kt:80` |
| T0749 | texto | Junto a la puerta | `Route.kt:80` |
| T0750 | texto | Pasear o jugar con el perro | `Route.kt:83` |
| T0751 | texto | Salir 10 minutos con el perro | `Route.kt:84` |
| T0752 | texto | Tomar la correa | `Route.kt:84` |
| T0753 | texto | Junto a la puerta | `Route.kt:84` |
| T0754 | texto | Jugar con el perro | `Route.kt:85` |
| T0755 | texto | Sacar su pelota | `Route.kt:85` |
| T0756 | texto | Donde está su pelota | `Route.kt:85` |
| T0757 | texto | Salir con el perro sin el teléfono | `Route.kt:86` |
| T0758 | texto | Dejar el teléfono en casa | `Route.kt:86` |
| T0759 | texto | Junto a la puerta | `Route.kt:86` |
| T0760 | texto | Dibujar o pintar | `Route.kt:89` |
| T0761 | texto | Dibujar 10 minutos | `Route.kt:90` |
| T0762 | texto | Sacar el cuaderno y un lápiz | `Route.kt:90` |
| T0763 | texto | En el escritorio | `Route.kt:90` |
| T0764 | texto | Pintar | `Route.kt:91` |
| T0765 | texto | Preparar las acuarelas | `Route.kt:91` |
| T0766 | texto | En la mesa | `Route.kt:91` |
| T0767 | texto | Terminar un dibujo | `Route.kt:92` |
| T0768 | texto | Abrir el cuaderno en ese dibujo | `Route.kt:92` |
| T0769 | texto | En el escritorio | `Route.kt:92` |
| T0770 | texto | Manualidades o maquetas | `Route.kt:95` |
| T0771 | texto | Avanzar 15 minutos | `Route.kt:96` |
| T0772 | texto | Sacar los materiales | `Route.kt:96` |
| T0773 | texto | En la mesa de trabajo | `Route.kt:96` |
| T0774 | texto | Armar una parte de la maqueta | `Route.kt:97` |
| T0775 | texto | Abrir la caja de la maqueta | `Route.kt:97` |
| T0776 | texto | En la mesa | `Route.kt:97` |
| T0777 | texto | Terminar lo que empezaste | `Route.kt:98` |
| T0778 | texto | Dejar la pieza a la vista | `Route.kt:98` |
| T0779 | texto | En la mesa | `Route.kt:98` |
| T0780 | texto | Cocinar | `Route.kt:101` |
| T0781 | texto | Cocinar algo simple | `Route.kt:102` |
| T0782 | texto | Reunir los ingredientes | `Route.kt:102` |
| T0783 | texto | En el mesón de la cocina | `Route.kt:102` |
| T0784 | texto | Probar una receta nueva | `Route.kt:103` |
| T0785 | texto | Dejar la receta a la vista | `Route.kt:103` |
| T0786 | texto | En el mesón de la cocina | `Route.kt:103` |
| T0787 | texto | Preparar la comida de mañana | `Route.kt:104` |
| T0788 | texto | Sacar los táper | `Route.kt:104` |
| T0789 | texto | En el mesón de la cocina | `Route.kt:104` |
| T0790 | texto | Ordenar la pieza | `Route.kt:107` |
| T0791 | texto | Ordenar un cajón | `Route.kt:108` |
| T0792 | texto | Vaciar el cajón sobre la cama | `Route.kt:108` |
| T0793 | texto | Junto al cajón | `Route.kt:108` |
| T0794 | texto | Hacer la cama | `Route.kt:109` |
| T0795 | texto | Estirar las sábanas | `Route.kt:109` |
| T0796 | texto | Junto a la cama | `Route.kt:109` |
| T0797 | texto | Ordenar la ropa | `Route.kt:110` |
| T0798 | texto | Juntar la ropa en el canasto | `Route.kt:110` |
| T0799 | texto | Junto al canasto | `Route.kt:110` |
| T0800 | texto | Meditar | `Route.kt:113` |
| T0801 | texto | Respirar 5 minutos | `Route.kt:114` |
| T0802 | texto | Sentarte en el cojín | `Route.kt:114` |
| T0803 | texto | Junto al cojín | `Route.kt:114` |
| T0804 | texto | Meditar 10 minutos | `Route.kt:115` |
| T0805 | texto | Apagar la luz grande | `Route.kt:115` |
| T0806 | texto | Junto al interruptor | `Route.kt:115` |
| T0807 | texto | Estirar antes de dormir | `Route.kt:116` |
| T0808 | texto | Desenrollar la colchoneta | `Route.kt:116` |
| T0809 | texto | Junto a la cama | `Route.kt:116` |
| T0810 | texto | Estudiar o hacer tareas | `Route.kt:119` |
| T0811 | texto | Estudiar 20 minutos | `Route.kt:120` |
| T0812 | texto | Abrir los apuntes | `Route.kt:120` |
| T0813 | texto | En el escritorio | `Route.kt:120` |
| T0814 | texto | Hacer una tarea | `Route.kt:121` |
| T0815 | texto | Abrir el cuaderno en la tarea | `Route.kt:121` |
| T0816 | texto | En el escritorio | `Route.kt:121` |
| T0817 | texto | Repasar para una prueba | `Route.kt:122` |
| T0818 | texto | Sacar los resúmenes | `Route.kt:122` |
| T0819 | texto | En el escritorio | `Route.kt:122` |
| T0820 | texto | Jugar videojuegos | `Route.kt:125` |
| T0821 | texto | Jugar una partida | `Route.kt:126` |
| T0822 | texto | Encender la consola | `Route.kt:126` |
| T0823 | texto | Junto a la tele | `Route.kt:126` |
| T0824 | texto | Avanzar en el juego | `Route.kt:127` |
| T0825 | texto | Dejar el control cargado | `Route.kt:127` |
| T0826 | texto | Junto a la tele | `Route.kt:127` |
| T0827 | texto | Jugar con alguien | `Route.kt:128` |
| T0828 | texto | Avisar a quien juega contigo | `Route.kt:128` |
| T0829 | texto | Junto al computador | `Route.kt:128` |
| T0830 | texto | Escuchar música | `Route.kt:131` |
| T0831 | texto | Escuchar un disco entero | `Route.kt:132` |
| T0832 | texto | Elegir el disco | `Route.kt:132` |
| T0833 | texto | Junto a los discos | `Route.kt:132` |
| T0834 | texto | Escuchar música sin hacer nada más | `Route.kt:133` |
| T0835 | texto | Ponerte los audífonos | `Route.kt:133` |
| T0836 | texto | En el sillón | `Route.kt:133` |
| T0837 | texto | Tocar una canción | `Route.kt:134` |
| T0838 | texto | Sacar el instrumento | `Route.kt:134` |
| T0839 | texto | Junto al instrumento | `Route.kt:134` |
| T0840 | texto | Ver una película o serie | `Route.kt:137` |
| T0841 | texto | Ver una película | `Route.kt:138` |
| T0842 | texto | Elegir la película | `Route.kt:138` |
| T0843 | texto | Junto a la tele | `Route.kt:138` |
| T0844 | texto | Ver un capítulo con alguien | `Route.kt:139` |
| T0845 | texto | Avisar a quien ve contigo | `Route.kt:139` |
| T0846 | texto | Junto a la tele | `Route.kt:139` |
| T0847 | texto | Ver una película sin el teléfono | `Route.kt:140` |
| T0848 | texto | Dejar el teléfono cargando | `Route.kt:140` |
| T0849 | texto | Junto al cargador | `Route.kt:140` |
| T0850 | texto | Compartir con alguien | `Route.kt:143` |
| T0851 | texto | Comer sin el teléfono | `Route.kt:144` |
| T0852 | texto | Poner la mesa | `Route.kt:144` |
| T0853 | texto | En la mesa del comedor | `Route.kt:144` |
| T0854 | texto | Jugar un juego de mesa | `Route.kt:145` |
| T0855 | texto | Sacar la caja | `Route.kt:145` |
| T0856 | texto | En la mesa | `Route.kt:145` |
| T0857 | texto | Juntarte a jugar a la pelota | `Route.kt:146` |
| T0858 | texto | Preparar las zapatillas | `Route.kt:146` |
| T0859 | texto | Junto a la puerta | `Route.kt:146` |
| T0860 | texto | Llamar a alguien | `Route.kt:148` |
| T0861 | texto | Buscar su número | `Route.kt:148` |
| T0862 | texto | En el sillón | `Route.kt:148` |
| T0863 | texto | Otra actividad | `Route.kt:158` |
| T0864 | texto | En tu pieza | `Route.kt:165` |
| T0865 | texto | En el living | `Route.kt:165` |
| T0866 | texto | En la cocina | `Route.kt:165` |
| T0867 | texto | En el comedor | `Route.kt:165` |
| T0868 | texto | Tomar la correa | `Catastro.kt:56` |
| T0869 | texto | Sacar su pelota | `Catastro.kt:56` |
| T0870 | texto | Llenar su botella de agua | `Catastro.kt:56` |
| T0871 | texto | Junto a la puerta | `Catastro.kt:57` |
| T0872 | texto | Donde está la correa | `Catastro.kt:57` |
| T0873 | texto | Ponerte las zapatillas | `Catastro.kt:63` |
| T0874 | texto | Ponerte ropa deportiva | `Catastro.kt:63` |
| T0875 | texto | Llenar la botella de agua | `Catastro.kt:63` |
| T0876 | texto | Junto a la puerta | `Catastro.kt:64` |
| T0877 | texto | Junto a las zapatillas | `Catastro.kt:64` |
| T0878 | texto | Ponerte las zapatillas | `Catastro.kt:70` |
| T0879 | texto | Llenar la botella de agua | `Catastro.kt:70` |
| T0880 | texto | Elegir el recorrido | `Catastro.kt:70` |
| T0881 | texto | Junto a la puerta | `Catastro.kt:71` |
| T0882 | texto | Junto a las zapatillas | `Catastro.kt:71` |
| T0883 | texto | Sacar la bici | `Catastro.kt:77` |
| T0884 | texto | Inflar las ruedas | `Catastro.kt:77` |
| T0885 | texto | Ponerte el casco | `Catastro.kt:77` |
| T0886 | texto | Junto a la puerta | `Catastro.kt:78` |
| T0887 | texto | Junto a la bici | `Catastro.kt:78` |
| T0888 | texto | Ponerte ropa deportiva | `Catastro.kt:85` |
| T0889 | texto | Estirar la colchoneta | `Catastro.kt:85` |
| T0890 | texto | Preparar el bolso | `Catastro.kt:85` |
| T0891 | texto | Junto al clóset | `Catastro.kt:86` |
| T0892 | texto | Donde guardas la colchoneta | `Catastro.kt:86` |
| T0893 | texto | Junto a la puerta | `Catastro.kt:86` |
| T0894 | texto | Desenrollar la colchoneta | `Catastro.kt:92` |
| T0895 | texto | Ponerte ropa cómoda | `Catastro.kt:92` |
| T0896 | texto | Donde guardas la colchoneta | `Catastro.kt:93` |
| T0897 | texto | Junto a la cama | `Catastro.kt:93` |
| T0898 | texto | Preparar el traje de baño | `Catastro.kt:98` |
| T0899 | texto | Echar la toalla al bolso | `Catastro.kt:98` |
| T0900 | texto | Junto a la puerta | `Catastro.kt:99` |
| T0901 | texto | Junto al bolso | `Catastro.kt:99` |
| T0902 | texto | Preparar las zapatillas | `Catastro.kt:104` |
| T0903 | texto | Inflar la pelota | `Catastro.kt:104` |
| T0904 | texto | Avisar al equipo | `Catastro.kt:104` |
| T0905 | texto | Junto a la puerta | `Catastro.kt:105` |
| T0906 | texto | Llenar la regadera | `Catastro.kt:110` |
| T0907 | texto | Ponerte los guantes | `Catastro.kt:110` |
| T0908 | texto | Junto a las plantas | `Catastro.kt:111` |
| T0909 | texto | Junto a la regadera | `Catastro.kt:111` |
| T0910 | texto | Sacar el tomo del estante | `Catastro.kt:119` |
| T0911 | texto | Abrir el tomo donde quedaste | `Catastro.kt:119` |
| T0912 | texto | Junto al estante | `Catastro.kt:120` |
| T0913 | texto | En el velador | `Catastro.kt:120` |
| T0914 | texto | Elegir el libro | `Catastro.kt:126` |
| T0915 | texto | Abrir el libro en el marcador | `Catastro.kt:126` |
| T0916 | texto | Dejar el libro a la vista | `Catastro.kt:126` |
| T0917 | texto | En el velador | `Catastro.kt:127` |
| T0918 | texto | En el sillón | `Catastro.kt:127` |
| T0919 | texto | Junto al estante | `Catastro.kt:127` |
| T0920 | texto | Abrir los apuntes | `Catastro.kt:134` |
| T0921 | texto | Despejar el escritorio | `Catastro.kt:134` |
| T0922 | texto | Abrir el cuaderno en la tarea | `Catastro.kt:134` |
| T0923 | texto | En el escritorio | `Catastro.kt:135` |
| T0924 | texto | Abrir el cuaderno de vocabulario | `Catastro.kt:142` |
| T0925 | texto | Abrir el libro del curso | `Catastro.kt:142` |
| T0926 | texto | En el escritorio | `Catastro.kt:143` |
| T0927 | texto | Abrir el cuaderno | `Catastro.kt:148` |
| T0928 | texto | Dejar un lápiz sobre el cuaderno | `Catastro.kt:148` |
| T0929 | texto | En el escritorio | `Catastro.kt:149` |
| T0930 | texto | En el velador | `Catastro.kt:149` |
| T0931 | texto | Sacar el cuaderno y un lápiz | `Catastro.kt:156` |
| T0932 | texto | Abrir el cuaderno en ese dibujo | `Catastro.kt:156` |
| T0933 | texto | Sacar los lápices | `Catastro.kt:156` |
| T0934 | texto | En el escritorio | `Catastro.kt:157` |
| T0935 | texto | En la mesa | `Catastro.kt:157` |
| T0936 | texto | Preparar las acuarelas | `Catastro.kt:163` |
| T0937 | texto | Llenar un vaso con agua | `Catastro.kt:163` |
| T0938 | texto | Sacar los pinceles | `Catastro.kt:163` |
| T0939 | texto | En la mesa | `Catastro.kt:164` |
| T0940 | texto | En el escritorio | `Catastro.kt:164` |
| T0941 | texto | Sacar el tejido | `Catastro.kt:170` |
| T0942 | texto | Enhebrar la aguja | `Catastro.kt:170` |
| T0943 | texto | Dejar la lana a mano | `Catastro.kt:170` |
| T0944 | texto | En el sillón | `Catastro.kt:171` |
| T0945 | texto | En la mesa | `Catastro.kt:171` |
| T0946 | texto | Abrir la caja de la maqueta | `Catastro.kt:177` |
| T0947 | texto | Dejar la pieza a la vista | `Catastro.kt:177` |
| T0948 | texto | Ordenar las piezas | `Catastro.kt:177` |
| T0949 | texto | En la mesa | `Catastro.kt:178` |
| T0950 | texto | En la mesa de trabajo | `Catastro.kt:178` |
| T0951 | texto | Sacar los materiales | `Catastro.kt:183` |
| T0952 | texto | Despejar la mesa | `Catastro.kt:183` |
| T0953 | texto | Dejar la tijera y el pegamento a mano | `Catastro.kt:183` |
| T0954 | texto | En la mesa de trabajo | `Catastro.kt:184` |
| T0955 | texto | En la mesa | `Catastro.kt:184` |
| T0956 | texto | Cargar la batería de la cámara | `Catastro.kt:190` |
| T0957 | texto | Sacar la cámara del estuche | `Catastro.kt:190` |
| T0958 | texto | Junto a la puerta | `Catastro.kt:191` |
| T0959 | texto | En el escritorio | `Catastro.kt:191` |
| T0960 | texto | Abrir la tapa del piano | `Catastro.kt:198` |
| T0961 | texto | Dejar la partitura a la vista | `Catastro.kt:198` |
| T0962 | texto | Junto al piano | `Catastro.kt:199` |
| T0963 | texto | Sacar {x} del estuche | `Catastro.kt:205` |
| T0964 | texto | Afinar {x} | `Catastro.kt:205` |
| T0965 | texto | Dejar la partitura a la vista | `Catastro.kt:205` |
| T0966 | texto | la guitarra | `Catastro.kt:209` |
| T0967 | texto | el ukelele | `Catastro.kt:209` |
| T0968 | texto | el violín | `Catastro.kt:209` |
| T0969 | texto | el charango | `Catastro.kt:209` |
| T0970 | texto | la flauta | `Catastro.kt:210` |
| T0971 | texto | la trompeta | `Catastro.kt:210` |
| T0972 | texto | el saxofón | `Catastro.kt:210` |
| T0973 | texto | el saxofón | `Catastro.kt:210` |
| T0974 | texto | el cello | `Catastro.kt:210` |
| T0975 | texto | el bajo | `Catastro.kt:211` |
| T0976 | texto | Elegir la canción | `Catastro.kt:217` |
| T0977 | texto | Tomar un vaso de agua | `Catastro.kt:217` |
| T0978 | texto | En el sillón | `Catastro.kt:218` |
| T0979 | texto | Ponerte los audífonos | `Catastro.kt:224` |
| T0980 | texto | Elegir el disco | `Catastro.kt:224` |
| T0981 | texto | En el sillón | `Catastro.kt:225` |
| T0982 | texto | Junto a los discos | `Catastro.kt:225` |
| T0983 | texto | Encender la consola | `Catastro.kt:232` |
| T0984 | texto | Dejar el control cargado | `Catastro.kt:232` |
| T0985 | texto | Avisar a quien juega contigo | `Catastro.kt:232` |
| T0986 | texto | Junto a la tele | `Catastro.kt:233` |
| T0987 | texto | Junto al computador | `Catastro.kt:233` |
| T0988 | texto | Elegir la película | `Catastro.kt:239` |
| T0989 | texto | Elegir el capítulo | `Catastro.kt:239` |
| T0990 | texto | Preparar cabritas | `Catastro.kt:239` |
| T0991 | texto | Avisar a quien ve contigo | `Catastro.kt:239` |
| T0992 | texto | Junto a la tele | `Catastro.kt:240` |
| T0993 | texto | En el sillón | `Catastro.kt:240` |
| T0994 | texto | Sacar el mazo | `Catastro.kt:246` |
| T0995 | texto | Despejar la mesa | `Catastro.kt:246` |
| T0996 | texto | Avisar a quien juega contigo | `Catastro.kt:246` |
| T0997 | texto | En la mesa | `Catastro.kt:247` |
| T0998 | texto | juego de mesa | `Catastro.kt:250` |
| T0999 | texto | Sacar la caja | `Catastro.kt:253` |
| T1000 | texto | Despejar la mesa | `Catastro.kt:253` |
| T1001 | texto | Avisar a quien juega contigo | `Catastro.kt:253` |
| T1002 | texto | En la mesa | `Catastro.kt:254` |
| T1003 | texto | Reunir los ingredientes | `Catastro.kt:262` |
| T1004 | texto | Dejar la receta a la vista | `Catastro.kt:262` |
| T1005 | texto | Lavar la tabla de picar | `Catastro.kt:262` |
| T1006 | texto | En el mesón de la cocina | `Catastro.kt:263` |
| T1007 | texto | Juntar la ropa en el canasto | `Catastro.kt:271` |
| T1008 | texto | Vaciar el cajón sobre la cama | `Catastro.kt:271` |
| T1009 | texto | Abrir la ventana | `Catastro.kt:271` |
| T1010 | texto | Junto al cajón | `Catastro.kt:272` |
| T1011 | texto | Junto al canasto | `Catastro.kt:272` |
| T1012 | texto | Junto a la cama | `Catastro.kt:272` |
| T1013 | texto | Dejar el teléfono cargando lejos de la cama | `Catastro.kt:280` |
| T1014 | texto | Apagar la luz grande | `Catastro.kt:280` |
| T1015 | texto | Ponerte el pijama | `Catastro.kt:280` |
| T1016 | texto | Junto al cargador | `Catastro.kt:281` |
| T1017 | texto | Junto a la cama | `Catastro.kt:281` |
| T1018 | texto | Sentarte en el cojín | `Catastro.kt:286` |
| T1019 | texto | Apagar la luz grande | `Catastro.kt:286` |
| T1020 | texto | Junto al cojín | `Catastro.kt:287` |
| T1021 | texto | Junto a la cama | `Catastro.kt:287` |
| T1022 | texto | Buscar su número | `Catastro.kt:294` |
| T1023 | texto | Escribirle que vas a llamar | `Catastro.kt:294` |
| T1024 | texto | En el sillón | `Catastro.kt:295` |
| T1025 | texto | Avisar que vas | `Catastro.kt:302` |
| T1026 | texto | Preparar algo para llevar | `Catastro.kt:302` |
| T1027 | texto | Poner la mesa | `Catastro.kt:302` |
| T1028 | texto | Junto a la puerta | `Catastro.kt:303` |
| T1029 | texto | En la mesa del comedor | `Catastro.kt:303` |
| T1030 | texto | el instrumento | `Catastro.kt:340` |
| T1031 | texto | Junto al [dato] | `Catastro.kt:341` |
| T1032 | texto | Junto a [dato] | `Catastro.kt:341` |
| T1033 | texto | Leer | `Common.kt:63` |
| T1034 | texto | Abrir el libro | `Common.kt:63` |
| T1035 | texto | En el velador | `Common.kt:63` |
| T1036 | texto | Dormir a tiempo | `Common.kt:64` |
| T1037 | texto | Dejar el teléfono cargando lejos | `Common.kt:64` |
| T1038 | texto | Junto al cargador | `Common.kt:64` |
| T1039 | texto | Hacer ejercicio | `Common.kt:65` |
| T1040 | texto | Ponerte ropa cómoda | `Common.kt:65` |
| T1041 | texto | Junto al clóset | `Common.kt:65` |
| T1042 | texto | Pasear al perro | `Common.kt:66` |
| T1043 | texto | Tomar la correa | `Common.kt:66` |
| T1044 | texto | Junto a la puerta | `Common.kt:66` |
| T1045 | texto | Dibujar | `Common.kt:67` |
| T1046 | texto | Sacar el cuaderno y un lápiz | `Common.kt:67` |
| T1047 | texto | En el escritorio | `Common.kt:67` |
| T1048 | texto | Pintar | `Common.kt:68` |
| T1049 | texto | Preparar las acuarelas | `Common.kt:68` |
| T1050 | texto | En la mesa | `Common.kt:68` |
| T1051 | texto | Cocinar | `Common.kt:69` |
| T1052 | texto | Reunir los ingredientes | `Common.kt:69` |
| T1053 | texto | En el mesón de la cocina | `Common.kt:69` |
| T1054 | texto | Estudiar | `Common.kt:70` |
| T1055 | texto | Abrir los apuntes | `Common.kt:70` |
| T1056 | texto | En el escritorio | `Common.kt:70` |
| T1057 | texto | Ordenar la pieza | `Common.kt:71` |
| T1058 | texto | Despejar una superficie | `Common.kt:71` |
| T1059 | texto | En el escritorio | `Common.kt:71` |
| T1060 | texto | Hacer manualidades | `Common.kt:72` |
| T1061 | texto | Preparar los materiales | `Common.kt:72` |
| T1062 | texto | En la mesa de trabajo | `Common.kt:72` |
| T1063 | texto | Armar una maqueta | `Common.kt:73` |
| T1064 | texto | Abrir la caja de la maqueta | `Common.kt:73` |
| T1065 | texto | En la mesa | `Common.kt:73` |
| T1066 | texto | Salir en bicicleta | `Common.kt:74` |
| T1067 | texto | Sacar la bici | `Common.kt:74` |
| T1068 | texto | Junto a la puerta | `Common.kt:74` |
| T1069 | texto | Meditar | `Common.kt:75` |
| T1070 | texto | Sentarte en el cojín | `Common.kt:75` |
| T1071 | texto | Junto al cojín | `Common.kt:75` |
| T1072 | texto | Leer manga | `Common.kt:76` |
| T1073 | texto | Sacar el tomo del estante | `Common.kt:76` |
| T1074 | texto | Junto al estante | `Common.kt:76` |
| T1075 | texto | Jugar videojuegos | `Common.kt:78` |
| T1076 | texto | Encender la consola | `Common.kt:78` |
| T1077 | texto | Junto a la tele | `Common.kt:78` |
| T1078 | texto | Escuchar música | `Common.kt:79` |
| T1079 | texto | Ponerte los audífonos | `Common.kt:79` |
| T1080 | texto | En el sillón | `Common.kt:79` |
| T1081 | texto | Ver una película | `Common.kt:80` |
| T1082 | texto | Elegir la película | `Common.kt:80` |
| T1083 | texto | Junto a la tele | `Common.kt:80` |
| T1084 | texto | Llamar a alguien | `Common.kt:81` |
| T1085 | texto | Buscar su número | `Common.kt:81` |
| T1086 | texto | En el sillón | `Common.kt:81` |
| T1087 | texto | Jugar un juego de mesa | `Common.kt:82` |
| T1088 | texto | Sacar la caja | `Common.kt:82` |
| T1089 | texto | En la mesa | `Common.kt:82` |
| T1090 | texto | Moverte | `Sky.kt:134` |
| T1091 | texto | Leer y aprender | `Sky.kt:135` |
| T1092 | texto | Crear | `Sky.kt:136` |
| T1093 | texto | Jugar y disfrutar | `Sky.kt:137` |
| T1094 | texto | En casa | `Sky.kt:138` |
| T1095 | texto | Descansar | `Sky.kt:139` |
| T1096 | texto | Con otras personas | `Sky.kt:140` |
| T1097 | texto | Otras | `Sky.kt:141` |

## 34 Piezas de la interfaz

238 textos.

| Id | Tipo | Texto | Dónde |
| --- | --- | --- | --- |
| T1098 | texto | Restar tiempo | `Controls.kt:323` |
| T1099 | texto | Sumar tiempo | `Controls.kt:325` |
| T1100 | texto | Restar | `Controls.kt:335` |
| T1101 | texto | Sumar | `Controls.kt:337` |
| T1102 | lector de pantalla | Borrar la búsqueda | `Fields.kt:122` |
| T1103 | texto | Sugerencias | `Fields.kt:141` |
| T1104 | texto | Accesibilidad | `KitIcons.kt:13` |
| T1105 | texto | Actividad | `KitIcons.kt:22` |
| T1106 | texto | Advertencia | `KitIcons.kt:30` |
| T1107 | texto | Agregar | `KitIcons.kt:38` |
| T1108 | texto | Ajustes | `KitIcons.kt:44` |
| T1109 | texto | Apps elegidas | `KitIcons.kt:52` |
| T1110 | texto | Avisos del teléfono | `KitIcons.kt:61` |
| T1111 | texto | Ayuda | `KitIcons.kt:68` |
| T1112 | texto | Batería del objeto | `KitIcons.kt:76` |
| T1113 | texto | Andar en bicicleta | `KitIcons.kt:84` |
| T1114 | texto | Borrar | `KitIcons.kt:93` |
| T1115 | texto | Buscar | `KitIcons.kt:102` |
| T1116 | texto | Calendario | `KitIcons.kt:109` |
| T1117 | texto | Cambié de idea | `KitIcons.kt:117` |
| T1118 | texto | Caminar | `KitIcons.kt:124` |
| T1119 | texto | Escribirle a alguien | `KitIcons.kt:133` |
| T1120 | texto | Cerrar sesión | `KitIcons.kt:140` |
| T1121 | texto | Cerrar | `KitIcons.kt:148` |
| T1122 | texto | Cocinar | `KitIcons.kt:154` |
| T1123 | texto | Código de participante | `KitIcons.kt:163` |
| T1124 | texto | Comencé | `KitIcons.kt:169` |
| T1125 | texto | Comentario | `KitIcons.kt:176` |
| T1126 | texto | Conexión | `KitIcons.kt:182` |
| T1127 | texto | Consentimiento | `KitIcons.kt:188` |
| T1128 | texto | Contraer | `KitIcons.kt:196` |
| T1129 | texto | Copiar | `KitIcons.kt:202` |
| T1130 | texto | Datos del estudio | `KitIcons.kt:209` |
| T1131 | texto | Decisión | `KitIcons.kt:217` |
| T1132 | texto | Acceso abierto | `KitIcons.kt:224` |
| T1133 | texto | Descargar | `KitIcons.kt:231` |
| T1134 | texto | La dejé para después | `KitIcons.kt:238` |
| T1135 | texto | Detener | `KitIcons.kt:246` |
| T1136 | texto | Dibujar | `KitIcons.kt:252` |
| T1137 | texto | Dormir | `KitIcons.kt:259` |
| T1138 | texto | Editar | `KitIcons.kt:266` |
| T1139 | texto | Hacer ejercicio | `KitIcons.kt:274` |
| T1140 | texto | Abrir fuera de la app | `KitIcons.kt:283` |
| T1141 | texto | Entrevistas | `KitIcons.kt:291` |
| T1142 | texto | Enviar | `KitIcons.kt:298` |
| T1143 | texto | Error | `KitIcons.kt:305` |
| T1144 | texto | Escribir | `KitIcons.kt:312` |
| T1145 | texto | Esperando | `KitIcons.kt:321` |
| T1146 | texto | Estirar | `KitIcons.kt:329` |
| T1147 | texto | Estrella llena | `KitIcons.kt:338` |
| T1148 | texto | Media estrella | `KitIcons.kt:344` |
| T1149 | texto | Estrella vacía | `KitIcons.kt:351` |
| T1150 | texto | Estudiar | `KitIcons.kt:357` |
| T1151 | texto | Expandir | `KitIcons.kt:365` |
| T1152 | texto | Exportar o compartir | `KitIcons.kt:371` |
| T1153 | texto | Filtrar | `KitIcons.kt:379` |
| T1154 | texto | Fotografiar | `KitIcons.kt:385` |
| T1155 | texto | Tocar un instrumento | `KitIcons.kt:394` |
| T1156 | texto | Hipótesis y prueba | `KitIcons.kt:404` |
| T1157 | texto | Historial | `KitIcons.kt:412` |
| T1158 | texto | Información | `KitIcons.kt:418` |
| T1159 | texto | Inicio | `KitIcons.kt:426` |
| T1160 | texto | Investigación | `KitIcons.kt:432` |
| T1161 | texto | Jugar un juego de mesa | `KitIcons.kt:441` |
| T1162 | texto | Leer | `KitIcons.kt:450` |
| T1163 | texto | Listo | `KitIcons.kt:457` |
| T1164 | texto | Jugar videojuegos | `KitIcons.kt:463` |
| T1165 | texto | Llamar a alguien | `KitIcons.kt:472` |
| T1166 | texto | Lugar | `KitIcons.kt:478` |
| T1167 | texto | Hacer manualidades | `KitIcons.kt:485` |
| T1168 | texto | Más opciones | `KitIcons.kt:493` |
| T1169 | texto | Menú | `KitIcons.kt:501` |
| T1170 | texto | Mostrar | `KitIcons.kt:507` |
| T1171 | texto | Escuchar música | `KitIcons.kt:514` |
| T1172 | texto | Objeto | `KitIcons.kt:522` |
| T1173 | texto | Ocultar | `KitIcons.kt:530` |
| T1174 | texto | Ordenar | `KitIcons.kt:538` |
| T1175 | texto | Parlante | `KitIcons.kt:546` |
| T1176 | texto | Pausar | `KitIcons.kt:554` |
| T1177 | texto | Perfil | `KitIcons.kt:560` |
| T1178 | texto | Permiso | `KitIcons.kt:567` |
| T1179 | texto | Pintar | `KitIcons.kt:574` |
| T1180 | texto | Cuidar las plantas | `KitIcons.kt:581` |
| T1181 | texto | Cómo empieza | `KitIcons.kt:590` |
| T1182 | texto | Privacidad | `KitIcons.kt:597` |
| T1183 | texto | Probar sonido | `KitIcons.kt:605` |
| T1184 | texto | Reportar un problema | `KitIcons.kt:613` |
| T1185 | texto | Reintentar | `KitIcons.kt:622` |
| T1186 | texto | Relevos | `KitIcons.kt:629` |
| T1187 | texto | Reproducir | `KitIcons.kt:638` |
| T1188 | texto | Salir | `KitIcons.kt:644` |
| T1189 | texto | Siguiente | `KitIcons.kt:654` |
| T1190 | texto | Silenciar | `KitIcons.kt:660` |
| T1191 | texto | Sin conexión | `KitIcons.kt:669` |
| T1192 | texto | Sincronizar datos | `KitIcons.kt:676` |
| T1193 | texto | Sistema phygital | `KitIcons.kt:683` |
| T1194 | texto | Este teléfono | `KitIcons.kt:691` |
| T1195 | texto | Tema claro u oscuro | `KitIcons.kt:698` |
| T1196 | texto | Tamaño del texto | `KitIcons.kt:705` |
| T1197 | texto | Tiempo | `KitIcons.kt:712` |
| T1198 | texto | Después de cuánto uso | `KitIcons.kt:721` |
| T1199 | texto | Persona | `KitIcons.kt:730` |
| T1200 | texto | Validación | `KitIcons.kt:737` |
| T1201 | texto | Volver | `KitIcons.kt:744` |
| T1202 | texto | Suena | `KitIcons.kt:750` |
| T1203 | texto | Ruta | `KitIcons.kt:760` |
| T1204 | texto | Avance | `KitIcons.kt:768` |
| T1205 | texto | Abrir | `KitIcons.kt:773` |
| T1206 | texto | Ajustes | `KitIcons.kt:778` |
| T1207 | texto | Actividades | `KitIcons.kt:786` |
| T1208 | texto | Perro | `KitIcons.kt:797` |
| T1209 | texto | Correr | `KitIcons.kt:809` |
| T1210 | texto | Nadar | `KitIcons.kt:818` |
| T1211 | texto | Pelota | `KitIcons.kt:827` |
| T1212 | texto | Ver una película | `KitIcons.kt:835` |
| T1213 | texto | Leer manga | `KitIcons.kt:843` |
| T1214 | texto | Armar una maqueta | `KitIcons.kt:851` |
| T1215 | texto | Tejer o coser | `KitIcons.kt:858` |
| T1216 | texto | Tocar el piano | `KitIcons.kt:868` |
| T1217 | texto | Meditar | `KitIcons.kt:876` |
| T1218 | texto | Aprender un idioma | `KitIcons.kt:885` |
| T1219 | texto | Jugar a las cartas | `KitIcons.kt:894` |
| T1220 | texto | Con otras personas | `KitIcons.kt:902` |
| T1221 | texto | Elegido | `Lists.kt:183` |
| T1222 | texto | Sin completar | `Lists.kt:214` |
| T1223 | texto | Encendido | `Lists.kt:300` |
| T1224 | texto | Apagado | `Lists.kt:300` |
| T1225 | texto | Caminar | `Photos.kt:60` |
| T1226 | texto | Hacer ejercicio | `Photos.kt:61` |
| T1227 | texto | Leer | `Photos.kt:62` |
| T1228 | texto | Estudiar | `Photos.kt:63` |
| T1229 | texto | Dibujar | `Photos.kt:64` |
| T1230 | texto | Cocinar | `Photos.kt:65` |
| T1231 | texto | Ordenar | `Photos.kt:66` |
| T1232 | texto | Salir con el perro | `Photos.kt:67` |
| T1233 | texto | Manualidades | `Photos.kt:68` |
| T1234 | texto | Tocar guitarra | `Photos.kt:69` |
| T1235 | texto | Escribir | `Photos.kt:70` |
| T1236 | texto | Leer un libro | `Photos.kt:71` |
| T1237 | texto | Aprender | `Photos.kt:72` |
| T1238 | texto | Hacer pan | `Photos.kt:73` |
| T1239 | texto | Pintar | `Photos.kt:74` |
| T1240 | texto | Empezar | `Photos.kt:75` |
| T1241 | texto | Salir | `Photos.kt:76` |
| T1242 | texto | El tiempo en el teléfono | `Photos.kt:77` |
| T1243 | texto | Caras | `Photos.kt:84` |
| T1244 | texto | Animales | `Photos.kt:84` |
| T1245 | texto | Naturaleza | `Photos.kt:84` |
| T1246 | texto | Comida | `Photos.kt:84` |
| T1247 | texto | Actividades | `Photos.kt:84` |
| T1248 | texto | Cara sonriente | `Photos.kt:94` |
| T1249 | texto | Cara contenta | `Photos.kt:95` |
| T1250 | texto | Cara con lentes de sol | `Photos.kt:96` |
| T1251 | texto | Cara que abraza | `Photos.kt:97` |
| T1252 | texto | Cara con ojos de estrella | `Photos.kt:98` |
| T1253 | texto | Cara con corazones | `Photos.kt:99` |
| T1254 | texto | Cara de fiesta | `Photos.kt:100` |
| T1255 | texto | Cara pensativa | `Photos.kt:101` |
| T1256 | texto | Cara dormida | `Photos.kt:102` |
| T1257 | texto | Cara con sombrero de vaquero | `Photos.kt:103` |
| T1258 | texto | Robot | `Photos.kt:104` |
| T1259 | texto | Fantasma | `Photos.kt:105` |
| T1260 | texto | Perro | `Photos.kt:107` |
| T1261 | texto | Gato | `Photos.kt:108` |
| T1262 | texto | Zorro | `Photos.kt:109` |
| T1263 | texto | Tortuga | `Photos.kt:110` |
| T1264 | texto | Conejo | `Photos.kt:111` |
| T1265 | texto | Oso | `Photos.kt:112` |
| T1266 | texto | Panda | `Photos.kt:113` |
| T1267 | texto | Koala | `Photos.kt:114` |
| T1268 | texto | Tigre | `Photos.kt:115` |
| T1269 | texto | León | `Photos.kt:116` |
| T1270 | texto | Rana | `Photos.kt:117` |
| T1271 | texto | Pingüino | `Photos.kt:118` |
| T1272 | texto | Búho | `Photos.kt:119` |
| T1273 | texto | Abeja | `Photos.kt:120` |
| T1274 | texto | Mariposa | `Photos.kt:121` |
| T1275 | texto | Pulpo | `Photos.kt:122` |
| T1276 | texto | Ballena | `Photos.kt:123` |
| T1277 | texto | Unicornio | `Photos.kt:124` |
| T1278 | texto | Perezoso | `Photos.kt:125` |
| T1279 | texto | Dinosaurio | `Photos.kt:126` |
| T1280 | texto | Planta | `Photos.kt:128` |
| T1281 | texto | Girasol | `Photos.kt:129` |
| T1282 | texto | Ola | `Photos.kt:130` |
| T1283 | texto | Luna | `Photos.kt:131` |
| T1284 | texto | Sol | `Photos.kt:132` |
| T1285 | texto | Arcoíris | `Photos.kt:133` |
| T1286 | texto | Estrella | `Photos.kt:134` |
| T1287 | texto | Nube | `Photos.kt:135` |
| T1288 | texto | Copo de nieve | `Photos.kt:136` |
| T1289 | texto | Fuego | `Photos.kt:137` |
| T1290 | texto | Cactus | `Photos.kt:138` |
| T1291 | texto | Árbol | `Photos.kt:139` |
| T1292 | texto | Trébol de cuatro hojas | `Photos.kt:140` |
| T1293 | texto | Tulipán | `Photos.kt:141` |
| T1294 | texto | Hongo | `Photos.kt:142` |
| T1295 | texto | Montaña nevada | `Photos.kt:143` |
| T1296 | texto | Planeta con anillo | `Photos.kt:144` |
| T1297 | texto | Taza de café | `Photos.kt:146` |
| T1298 | texto | Pan | `Photos.kt:147` |
| T1299 | texto | Sartén con un huevo | `Photos.kt:148` |
| T1300 | texto | Palta | `Photos.kt:149` |
| T1301 | texto | Frutilla | `Photos.kt:150` |
| T1302 | texto | Sandía | `Photos.kt:151` |
| T1303 | texto | Limón | `Photos.kt:152` |
| T1304 | texto | Pizza | `Photos.kt:153` |
| T1305 | texto | Dona | `Photos.kt:154` |
| T1306 | texto | Helado | `Photos.kt:155` |
| T1307 | texto | Té de burbujas | `Photos.kt:156` |
| T1308 | texto | Zapatilla | `Photos.kt:158` |
| T1309 | texto | Libros | `Photos.kt:159` |
| T1310 | texto | Guitarra | `Photos.kt:160` |
| T1311 | texto | Paleta de pintura | `Photos.kt:161` |
| T1312 | texto | Ovillo de lana | `Photos.kt:162` |
| T1313 | texto | Bicicleta | `Photos.kt:163` |
| T1314 | texto | Cámara | `Photos.kt:164` |
| T1315 | texto | Audífonos | `Photos.kt:165` |
| T1316 | texto | Lápiz | `Photos.kt:166` |
| T1317 | texto | Pieza de rompecabezas | `Photos.kt:167` |
| T1318 | texto | Teclado de piano | `Photos.kt:168` |
| T1319 | texto | Pelota | `Photos.kt:169` |
| T1320 | texto | Pelota de básquetbol | `Photos.kt:170` |
| T1321 | texto | Raqueta de tenis | `Photos.kt:171` |
| T1322 | texto | Skate | `Photos.kt:172` |
| T1323 | texto | Dado | `Photos.kt:173` |
| T1324 | texto | Peón de ajedrez | `Photos.kt:174` |
| T1325 | texto | Control de videojuegos | `Photos.kt:175` |
| T1326 | texto | Volantín | `Photos.kt:176` |
| T1327 | texto | Micrófono | `Photos.kt:177` |
| T1328 | texto | Violín | `Photos.kt:178` |
| T1329 | texto | Telescopio | `Photos.kt:179` |
| T1330 | texto | Carpa | `Photos.kt:180` |
| T1331 | texto | Cohete | `Photos.kt:181` |
| T1332 | texto | Volver | `Screen.kt:95` |
| T1333 | texto | Inicio | `RelevoApp.kt:83` |
| T1334 | texto | Actividades | `RelevoApp.kt:84` |
| T1335 | texto | Perfil | `RelevoApp.kt:85` |

## Registro de cambios (disclaimer)

### 2026-11-05 — Textos de 4.3

- **Qué cambió:** se volvió a generar con el código de 4.3 (D-158): suma las sugerencias del catastro, los sonidos de Ajustes y la hoja de opciones al editar una actividad, y deja fuera las palabras con que el catastro reconoce cada actividad, que no se ven.
- **Cómo estaba antes:** tenía los 1221 textos de 4.2.1, con «Tu perfil», «Tus relevos», «En tu Tag», «En el parlante» y el video de «Cómo funciona».
- **Por qué:** revisión del autor de la 4.2.1 y de la primera versión de la 4.3.

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
