# Anotaciones del 23 de septiembre: fundamento, respuesta escrita y límites

**Estado:** síntesis de investigación y criterios para revisión. No representa funciones implementadas ni resultados con personas. **Fuente de entrada:** notas entregadas por el autor el 23 de septiembre de 2026. **Base consultada:** revisión `fe416ca` de `main`, entrevistas P1–P8, memoria v4, sistema de marca vigente y prototipo Android 2.3.

## Qué está confirmado y qué permanece abierto

Relevo busca que una intención elegida vuelva a estar disponible durante una sesión digital que continúa. Su mecanismo se formula como sistema **phygital**: la app configura una intención, una condición y una manera concreta de comenzar; un objeto junto a ese comienzo emite una señal; la persona conserva la decisión. Las ocho entrevistas son exploratorias y describen situaciones, no segmentos permanentes ni eficacia. El prototipo Android 2.3 contiene una app y prevé un parlante Bluetooth; su salida física, segundo plano y comprensión todavía requieren prueba con dispositivos y participantes. La memoria y los requisitos vigentes excluyen puntajes, rachas y recompensas, y mantienen una intención activa por ciclo ([memoria v4](../08_memoria/memoria-vigente-v4.md), [requisitos RU-01–RU-14](../03_usuarios/matriz-requisitos-de-usuarios.md), [estado del APK](../06_desarrollo_y_factibilidad/app-android/README.md)).

La nota «la persona que no pondrá el objeto junto a las zapatillas no es el usuario» es demasiado concluyente. Elegir un lugar relacionado forma parte del mecanismo que se quiere estudiar, pero rechazar esa preparación también puede revelar carga excesiva o un límite del diseño. No debe excluirse ese caso para proteger la hipótesis. La [comparación de soporte y lugar](../07_validacion/protocolo-01-asociacion-y-comparacion.md) existe precisamente para comprobarlo.

## Posicionamiento para la comisión

**Texto de una lámina:** «Querer cambiar no implica querer dejar de usar el teléfono. Relevo se sitúa entre las herramientas que registran o restringen el uso y las que ayudan a recuperar una actividad elegida. Su pregunta es si una señal situada junto al comienzo devuelve esa intención a la decisión mejor que un aviso en el teléfono, con una carga aceptable».

**Explicación oral breve:** «El proyecto no diagnostica una adicción ni prescribe una vida más productiva. La persona define qué actividad le importa, cómo podría empezar y cuándo tendría sentido recordarla. Si el aviso llega, puede comenzar, seguir, posponer o detener el sistema. La contribución física sigue siendo una hipótesis: debemos demostrar qué aporta el lugar y cuándo el costo de preparar un objeto deja de valer la pena».

Esta posición contrasta mecanismos, no proclama que no exista ningún producto parecido. La [revisión de mercado](../04_mercado_y_referentes/investigacion-frontera-y-coincidencias.md) y la memoria v4 distinguen registro, bloqueo, pausa y recordatorio, pero la comparación empírica con notificación continúa pendiente.

## Usuario y personalización con respaldo

Los [perfiles situacionales](../03_usuarios/perfiles-situacionales.md) distinguen U1, continuidad con intención desplazada, y U2, ocio elegido y coherente. Una misma persona puede pasar por ambos. P2 y P3 sostienen con más claridad el patrón U1; P6–P8 delimitan casos donde interrumpir por duración o por aplicación sería improcedente. En las entrevistas aparecen leer, caminar, dibujar, manualidades, sueño y otras actividades; eso permite proponer ejemplos, pero no ordenar a cada persona en «perfil deportivo» o «perfil lector» como identidad fija ([matriz P1–P8](../03_usuarios/matriz-evidencia-p1-p8.md)).

**Criterio propuesto:** personalizar la intención y el primer comienzo, no inferir personalidad. Un nombre o avatar opcional puede mejorar apropiación, pero no se justifica como requisito de datos. Si se añadiera, habría que comprobar si mejora comprensión o continuidad y registrar su costo de privacidad. Los ejemplos progresivos —caminar antes de trotar, abrir un libro antes de terminarlo— son andamiajes editables. La persona puede escoger otro paso o rechazar la sugerencia. La app ya ofrece siete actividades predefinidas y conserva actividades creadas por la persona en almacenamiento local; por tanto, esas dos notas describen funciones presentes en 2.3 y requieren **verificación de uso**, no una especificación desde cero ([código de actividades](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/data/CustomActivityStore.kt), [lista actual](../06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/RelevoApp.kt)).

## Continuidad, regreso y formación de hábito

La propuesta puede acompañar la repetición de una decisión, pero **recordar una intención, iniciar una actividad, repetirla y adquirir automaticidad son resultados diferentes**. Lally y colaboradores observaron una amplia variación en el tiempo para aproximarse a la automaticidad de una conducta en un contexto estable: de 18 a 254 días entre quienes pudieron modelarse, con mediana de 66 días. Esto impide usar «21 días» como umbral universal o como prueba suficiente de un hábito. El índice SRBAI estudia automaticidad autopercibida; ni una racha ni un conteo de sesiones la sustituyen (Lally et al., 2010; Gardner et al., 2012).

**Ruta de evaluación propuesta:** conservar la prueba formativa inmediata y los dos días previstos en el [consentimiento actual](../07_validacion/entrega-23-09-2026/fuentes-md/04-consentimiento.md). Si el prototipo supera comprensión, fiabilidad, privacidad y carga, diseñar un piloto voluntario de 21 días como observación de continuidad y habituación a la señal, con revisión al inicio, días 7, 14 y 21 y una conversación posterior. Registrar por separado: activación técnica, señal percibida, intención recordada, decisión declarada, lugar del objeto, carga de preparación, molestias, silenciamientos y abandono. Preguntar si la actividad se hizo más fácil de iniciar y si la señal perdió fuerza con los días; no inferirlo de minutos de pantalla. Si se quiere estudiar *hábito*, definir una conducta repetida y su contexto, adaptar un instrumento de automaticidad con revisión metodológica y extender el seguimiento según la variabilidad observada en la literatura. El protocolo, consentimiento, plazo de retención y tratamiento remoto deben revisarse antes de reclutar; hoy no existe evidencia de ese piloto.

**Regreso tras días sin abrir la app:** mostrar el estado verificable del ciclo y una opción breve para revisar intención, condición y lugar. No suponer desinterés, no felicitar por una ausencia y no rearmar un ciclo vencido sin decisión explícita. La investigación sobre reconfiguración de nudges citada en la [memoria](../08_memoria/memoria-vigente-v4.md) apoya estudiar una invitación a revisar; no demuestra que una notificación insistente sea eficaz en Relevo.

**Tono de acompañamiento:** reconocer la agencia y un paso concreto sin convertir la respuesta en una nota. Por ejemplo: «Elegiste volver a caminar. ¿Sigue siendo tu plan para esta semana?» o «El aviso quedó silenciado. Puedes revisar cuándo quieres que aparezca». La formulación vigente de RU-13 excluye rachas y recompensas, pero esa exclusión debe poder revisarse ante el feedback docente. «Tres semanas de racha» requeriría definir qué conducta se registra y cómo se conoce; «usaste todo tu tiempo de Instagram» supone una cuota saludable que Relevo no puede justificar. La [revisión específica de hábitos, reconocimiento y rachas](habitos-reconocimiento-y-rachas-2026-09-23.md) documenta evidencia a favor y en contra y propone estudiar primero apoyo positivo verificable. La decisión de modificar memoria y requisitos queda abierta.

**Recordatorio de continuidad propuesto:** si la persona acepta avisos de seguimiento, ofrecer una invitación ocasional a revisar un ciclo inactivo: «¿Siguen las zapatillas donde quieres empezar? Puedes cambiar el lugar o dejar Relevo apagado». Debe existir control de frecuencia y apagado, sin inferir que no abrir la app fue un fallo. Probar primero si ese aviso ayuda a recuperar contexto o añade intrusión; ninguna entrevista evaluó esta función.

## Criterios escritos para la experiencia actual

Estas notas orientan una auditoría de la interfaz 2.3; no certifican defectos visuales sin inspección en teléfonos concretos.

| Grupo de anotaciones | Criterio y comprobación antes de implementar |
| --- | --- |
| Contexto al entrar y tutorial | Explicar con una secuencia breve qué elige la persona, qué observa Android, dónde estará la señal y qué decisión puede tomar. Cada ilustración debe enseñar una relación real. Probar paráfrasis sin explicación del investigador. |
| Atrás, control y permiso | Permitir corregir el paso anterior sin perder entradas. El permiso de acceso a uso es condición para el **modo que observa apps**; una salida de demostración o revisión no debe presentarse como funcionamiento real. Separar consentimiento académico, autorización del sistema y activación del ciclo. |
| Botones y progreso | Mantener posición y etiqueta de la acción principal dentro de un flujo cuando sea posible; si cambia, probar si la persona anticipa la acción. Usar verbos concretos como «Volver al inicio» o «Revisar mi relevo». Una barra única o segmentos son alternativas a comparar por comprensión del avance, sin animación que sugiera carga o urgencia inexistente. |
| Texto, imágenes y espacios | Verificar lectura a tamaño de letra ampliado, contraste, recorte y targets de al menos 48 dp; aumentar ilustraciones si mejoran la tarea y no desplazan controles. «Centrar todo» no es una regla universal: titulares breves pueden centrarse y párrafos largos requieren lectura probada. Revisar pantallas pequeñas y orientación. |
| Navegación y marca | La barra inferior debe conservar destinos y rótulos legibles; icono sobre texto es un patrón reconocible, pero su proporción se valida en Android. La marca no necesita repetirse en el mismo punto de cada vista si no orienta; consultar la [especificación vigente](../10_recursos_visuales/14_sistema-de-marca-vigente.md). |
| Animación y desenfoque | Animar transiciones que aclaren estado, origen y destino, con opción de movimiento reducido. Medir legibilidad y rendimiento del desenfoque en Android real. Liquid Glass de Apple describe materiales de iOS para navegación y controles; es referente comparativo, no especificación de la app Android. |
| Regla, tiempo y varias apps | «60 minutos» debe expresarse como tiempo configurable, no duración recomendada. Varias apps por una intención podrían reducir configuración, pero cambian atribución, conteo y carga; ensayar una app primero y comparar una variante multiapp si aparece necesidad. |
| Señal sin dispositivo | El parlante Bluetooth actual es un material de ensayo; el teléfono puede servir como control comparativo, pero una salida solo telefónica no acredita el mecanismo phygital final. Explicitar el canal activo y el fallo de conexión. |
| Imágenes de actividades | Mantener coherencia con el sistema visual vigente y registrar procedencia, prompt, edición y licencia de cada imagen. No ampliar la biblioteca por cantidad: priorizar actividades observadas en entrevistas y comprobar reconocimiento sin atribuir preferencias a P1–P8. |
| Evaluación sutil | Una pregunta opcional, de una acción, después del cierre puede captar percepción o decisión declarada. Informar que es investigación, permitir omitirla y no usarla como requisito para salir. |

La guía de Android fija áreas táctiles mínimas de 48 dp y recomienda revisar tamaño y contraste; Apple describe Liquid Glass y barras de pestañas para sus propias plataformas. Estos son criterios técnicos y referentes de interacción, no pruebas de que una variante de Relevo sea mejor. La revisión del prototipo debe usar la [pauta Android](../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md), actualizada a 2.3 antes de aplicarse.

## Redacción candidata para pantallas y avisos

| Momento | Texto propuesto | Condición de uso |
| --- | --- | --- |
| Presentación | «Elige algo que quieres hacer y una forma sencilla de empezar. Relevo te avisará si se cumple el tiempo que definas para una app. Tú decides qué hacer después». | Resumen del flujo; no prometer detección de estados de ánimo. |
| Permiso | «Para contar el tiempo de la app que elijas, Android te pedirá acceso a datos de uso. Relevo no lee el contenido de esa app. Puedes retirar el acceso en Ajustes». | Complementar con información de qué se guarda y sincroniza; ver anexo de privacidad. |
| Volver tras ausencia | «Tu relevo anterior ya no está activo. Revisa si esta actividad, este lugar y este tiempo todavía te sirven». | Solo si el estado realmente venció o está desactivado. |
| Señal | «Es momento de considerar lo que querías hacer: [actividad]. Puedes empezar por [paso] o seguir como estás». | Ajustar a canal y espacio disponible; ambas salidas legítimas. |
| Cierre | «¿Qué decidiste después del aviso? Puedes omitir esta pregunta». | Autorregistro opcional; sin confirmación de varios pasos. |

## Referencias externas verificadas

- Android Developers. (s. f.). *Make apps more accessible*. https://developer.android.com/guide/topics/ui/accessibility/views/apps-views
- Android Developers. (s. f.). *UsageStatsManager*. https://developer.android.com/reference/android/app/usage/UsageStatsManager
- Apple. (s. f.). *Materials*. https://developer.apple.com/design/human-interface-guidelines/materials
- Apple. (s. f.). *Tab bars*. https://developer.apple.com/design/human-interface-guidelines/tab-bars
- Gardner, B., Abraham, C., Lally, P., & de Bruijn, G.-J. (2012). Towards parsimony in habit measurement: Testing the convergent and predictive validity of an automaticity subscale of the Self-Report Habit Index. *International Journal of Behavioral Nutrition and Physical Activity, 9*, 102. https://doi.org/10.1186/1479-5868-9-102
- Lally, P., van Jaarsveld, C. H. M., Potts, H. W. W., & Wardle, J. (2010). How are habits formed: Modelling habit formation in the real world. *European Journal of Social Psychology, 40*(6), 998–1009. https://doi.org/10.1002/ejsp.674

## Registro de cambios (disclaimer)

### 2026-09-23 — Matiz sobre rachas y reconocimiento

- **Qué cambió:** se distinguió la exclusión vigente de rachas de su evaluación futura y se enlazó la revisión de estudios.
- **Antes:** el apartado presentaba las rachas solo como contradicción con RU-13 y la memoria, sin desarrollar evidencia favorable y desfavorable.
- **Por qué:** incorporar el feedback docente y evitar tratar una decisión de diseño revisable como conclusión científica.
- **Alcance:** ajuste documental; memoria, requisitos y prototipo permanecen como estaban.

### 2026-09-23 — Creación

- **Qué cambió:** se cruzaron las anotaciones del autor con el estado, entrevistas, memoria, prototipo y fuentes externas; se redactaron criterios, textos candidatos y una ruta de evaluación longitudinal.
- **Antes:** las notas no tenían una respuesta integrada y podían confundirse con órdenes de implementación o resultados de investigación.
- **Por qué:** documentar la parte escrita sin modificar la app ni atribuir eficacia a decisiones todavía no ensayadas.
- **Alcance:** propuestas para revisión, no nueva política de producto; privacidad y trazabilidad de IA se desarrollan en documentos específicos. Ninguna prueba con personas fue ejecutada para este texto.
