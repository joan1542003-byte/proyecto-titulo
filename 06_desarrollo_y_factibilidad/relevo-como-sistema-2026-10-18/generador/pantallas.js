// Contenido de cada pantalla de Relevo 2.32 para los wireframes de baja fidelidad.
// Los textos salen del recorrido real en el emulador (18 de octubre de 2026). Cada pantalla es una lista
// de piezas; wireframes.html las dibuja con una sola retícula, así que nada se superpone.
// Piezas: ver el diccionario `pieces` en wireframes.html.

const NAME = "Nombre";

window.RELEVO_GROUPS = {
  "Primera vez": "Se ven una sola vez: presentan la idea, piden el consentimiento y los permisos, y arman el perfil y la ruta.",
  "Preparar un relevo": "Seis pasos para pasar de una intención a una condición que suena en un lugar.",
  "Contar, sonar y decidir": "Después de activar: la app cuenta, la señal suena y la persona cuenta qué decidió.",
  "Inicio, Ruta y Perfil": "Las tres pestañas de la app.",
  "Perfil": "Historial, actividades, ajustes, datos, ayuda y la configuración de la prueba.",
};

window.RELEVO_SCREENS = [
  // ---------- Primera vez ----------
  { id: "01-bienvenida", title: "Bienvenida", group: "Primera vez",
    note: "La promesa de Relevo y un solo botón para empezar.",
    body: [["img", 300, "Ilustración", true], ["logo"], ["h1", "Vuelve a lo que querías hacer."], ["p", "Anota algo que quieres hacer. Relevo te lo recuerda mientras todavía puedes hacerlo."]],
    bottom: [["primary", "Empezar"]] },

  { id: "02-esto-es-relevo", title: "Esto es Relevo", group: "Primera vez",
    note: "Video de 30 segundos que muestra la idea completa.",
    top: { back: true, progress: [1, 4], skip: true },
    body: [["h1", "Esto es Relevo"], ["video", 330], ["p", "Mira este video corto. Después te contamos cómo funciona y hacemos juntos tu primer relevo."]],
    bottom: [["primary", "Seguir"]] },

  { id: "03-te-ha-pasado", title: "¿Te ha pasado?", group: "Primera vez",
    note: "El problema en palabras de la persona: el rato se pasa y lo que quería hacer queda esperando.",
    top: { back: true, progress: [2, 4], skip: true },
    body: [["h1", "¿Te ha pasado?"], ["card", [["img", 130, "Ilustración"], ["b", "Abres una app para descansar."], ["p", "Se pasa el rato y lo que querías hacer queda esperando."]]],
      ["p", "Relevo te recuerda lo que querías hacer mientras todavía puedes hacerlo, en el lugar donde lo empiezas."]],
    bottom: [["primary", "Seguir"]] },

  { id: "04-como-funciona", title: "Cómo funciona", group: "Primera vez",
    note: "Las tres partes del sistema: la app, lo que suena y la persona que decide.",
    top: { back: true, progress: [3, 4], skip: true },
    body: [["h1", "Cómo funciona"], ["explain", [["La app", "Anotas qué quieres hacer y cómo empiezas."], ["Lo que suena", "Un parlante, un reloj o un Tag que dejas donde empiezas. Suena cuando llevas en tus apps el tiempo que elegiste."], ["Tú", "Decides si empiezas o sigues con lo que estabas haciendo."]]],
      ["p", "Cuando suene, nos cuentas qué hiciste con un toque. Ninguna respuesta es mejor que otra."]],
    bottom: [["primary", "Seguir"]] },

  { id: "05-aviso-semanal", title: "Una última pregunta", group: "Primera vez",
    note: "Pregunta si quiere un aviso después de una semana sin abrir la app. Lo puede cambiar en Perfil.",
    top: { back: true, progress: [4, 4] },
    body: [["h1", "Una última pregunta"], ["notif", "Relevo", "¿Quieres preparar un relevo esta semana?"], ["p", "Si pasas una semana sin abrir Relevo, ¿quieres que te avise una vez? Lo puedes cambiar cuando quieras en Perfil."]],
    bottom: [["primary", "Sí, avísame"], ["secondary", "No, gracias"]] },

  { id: "06-consentimiento", title: "Consentimiento", group: "Primera vez",
    note: "Consentimiento para 21 días, con «Leer más». Aceptar exige marcar la casilla; «No quiero participar» siempre está.",
    body: [["space", 8], ["h1", "Antes de empezar"], ["p", "Relevo es parte de un proyecto de título de Diseño. Por 21 días lo usas en tu día a día: cada semana te decimos dónde dejar lo que suena y, de vez en cuando, te hacemos preguntas cortas. Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte. Puedes salir y borrar tus datos cuando quieras."], ["chip", "Leer más"]],
    bottom: [["check", "Acepto participar durante 21 días.", true], ["primary", "Aceptar y empezar"], ["ghost", "No quiero participar"]] },

  { id: "07-permisos", title: "Permisos", group: "Primera vez",
    note: "Tiempo de uso es necesario para contar; notificaciones y batería son opcionales. Cada uno dice para qué sirve.",
    body: [["img", 170, "El tiempo en el teléfono", true], ["h1", "Para saber cuándo avisarte"], ["p", "Relevo necesita saber cuánto tiempo pasas en las apps que elijas. No ve lo que haces en ellas."],
      ["group", [["Tiempo de uso", "Listo", "Necesario."], ["Notificaciones", "Listo", "Para avisarte aunque estés en otra app."], ["Batería", "Activar", "Para que Relevo siga funcionando aunque pasen días."]]]],
    bottom: [["primary", "Seguir"]] },

  { id: "08-nombre", title: "¿Cómo te llamas?", group: "Primera vez",
    note: "El nombre se guarda aparte del resto, solo junto al código.",
    top: { progress: [1, 3] },
    body: [["h1", "¿Cómo te llamas?"], ["field", "Tu nombre", "", "Tu nombre o como te dicen"], ["small", "Lo guardamos junto a tu código, aparte de lo que haces en Relevo."]],
    bottom: [["primary", "Seguir"]] },

  { id: "09-emoji", title: "Elige tu emoji", group: "Primera vez",
    note: "La imagen del perfil: emoji por grupos, sin fotos.",
    top: { back: true, progress: [2, 3], skip: true },
    body: [["h1", "Elige tu emoji"], ["avatar", "N", 76], ["label", "Caras"], ["emoji", 10, 1], ["label", "Animales"], ["emoji", 10, -1]],
    bottom: [["primary", "Seguir"]] },

  { id: "10-intereses", title: "Intereses", group: "Primera vez",
    note: "Lo que le gustaría hacer más seguido. Con esto se arma la ruta de pasos.",
    top: { back: true, progress: [3, 3], skip: true },
    body: [["h1", "¿Qué te gustaría hacer más seguido?"], ["small", "Elige una o varias."], ["tiles", ["Dormir a tiempo", "Leer", "Hacer ejercicio", "Salir en bicicleta", "Pasear a tu perro", "Dibujar o pintar"], 2, [1]]],
    bottom: [["primary", "Armar mi ruta"]] },

  { id: "11-primer-relevo", title: "Tu primer relevo", group: "Primera vez",
    note: "El primer relevo se prepara acompañado: los seis pasos a la vista.",
    body: [["img", 160, "Ilustración de la actividad", true], ["h1", `${NAME}, hagamos tu primer relevo`], ["p", "Empecemos con «Leer 10 páginas», de tu ruta «Leer». Te guiamos paso a paso y puedes cambiar lo que quieras."],
      ["steps", ["Qué quieres hacer", "Cómo empiezas", "Dónde empiezas", "Cuándo suena", "Dónde suena", "Activarlo"]]],
    bottom: [["primary", "Empezar"], ["secondary", "Lo hago después"]] },

  // ---------- Preparar ----------
  { id: "12-que-quieres-hacer", title: "Preparar 1 de 6 · ¿Qué quieres hacer?", group: "Preparar un relevo",
    note: "La actividad: la que propone la ruta, una idea o una escrita por la persona.",
    top: { close: true, progress: [1, 6] },
    body: [["h1", "¿Qué quieres hacer?"], ["hint", "Te propusimos «Leer 10 páginas». Puedes dejarla o escribir otra cosa que quieras hacer."], ["field", "Actividad", "Leer 10 páginas"],
      ["label", "Tu ruta"], ["chips", ["Leer 10 páginas"], [0]], ["label", "Ideas"], ["tiles", ["Leer", "Dormir a tiempo", "Hacer ejercicio"], 3, []]],
    bottom: [["primary", "Seguir"]] },

  { id: "13-como-empiezas", title: "Preparar 2 de 6 · ¿Cómo empiezas?", group: "Preparar un relevo",
    note: "El primer paso, con opciones de un toque o texto propio.",
    top: { back: true, progress: [2, 6] },
    body: [["context", "Vuelve a leer 10 páginas."], ["h1", "¿Cómo empiezas?"], ["hint", "El primer paso es «abrir el libro». Mientras más pequeño, menos cuesta empezar."], ["small", "Toca una opción o escribe la tuya: lo primero que harías."],
      ["chips", ["Abrir el libro", "Sacar el tomo del estante", "Abrir el libro en el marcador", "Dejar el libro en el velador", "Dejar el teléfono en otro lugar"], [0]], ["field", "Para empezar", "Abrir el libro"]],
    bottom: [["primary", "Seguir"]] },

  { id: "14-donde-empiezas", title: "Preparar 3 de 6 · ¿Dónde empiezas?", group: "Preparar un relevo",
    note: "El lugar donde empieza la actividad: opciones concretas, nunca habitaciones enteras.",
    top: { back: true, progress: [3, 6] },
    body: [["context", "Vuelve a leer 10 páginas."], ["h1", "¿Dónde empiezas?"], ["hint", "Toca el que más se parezca. Si ninguno calza, escríbelo como lo dirías en voz alta."],
      ["chips", ["En el velador", "Junto al estante", "En el escritorio", "En la mesa", "En el sillón", "Junto a la cama", "Junto a la tele", "En el mesón de la cocina"], [0]], ["field", "Dónde empiezas", "En el velador"]],
    bottom: [["primary", "Seguir"]] },

  { id: "15-cuando-suena", title: "Preparar 4 de 6 · ¿Cuándo suena?", group: "Preparar un relevo",
    note: "La condición: las apps que cuentan y el tiempo acumulado, de 1 minuto a 6 horas. «Probar con 15 segundos» sirve para ensayar.",
    top: { back: true, progress: [4, 6] },
    body: [["context", "Vuelve a leer 10 páginas."], ["h1", "¿Cuándo suena?"], ["hint", "Elige las apps donde se te pasa el rato. Para ver ahora cómo funciona, toca «Probar con 15 segundos»."],
      ["group", [["Apps que cuentan", "Elegir apps ›"]]], ["stepper", "15 min", "en esas apps"], ["chips", ["15 min", "30 min", "1 h", "2 h"], [0]], ["chip", "Probar con 15 segundos"]],
    bottom: [["primary", "Seguir"]] },

  { id: "16-elegir-apps", title: "Elegir las apps", group: "Preparar un relevo",
    note: "Las apps instaladas, con búsqueda; se pueden elegir varias.",
    behind: "15-cuando-suena",
    sheet: { title: "Elige las apps", action: "Listo", body: [["field", "", "", "Buscar"], ["apps", ["Calendar", "Camera", "Chrome", "Clock", "Contacts", "Drive", "Files", "Gmail", "Maps"], [3]]] } },

  { id: "17-donde-suena", title: "Preparar 5 de 6 · ¿Dónde suena?", group: "Preparar un relevo",
    note: "Con qué suena: el Tag, un parlante, un reloj o el teléfono, con su estado. Desde aquí se busca y se prueba el Tag.",
    top: { back: true, progress: [5, 6] },
    body: [["context", "Vuelve a leer 10 páginas."], ["h1", "¿Dónde suena?"], ["small", "El parlante, el reloj o el Tag se dejan donde empiezas; el teléfono suena donde esté."],
      ["options", [["El Tag", "iTAG, elegido · pila al 75 %"], ["El parlante", "Sin parlante conectado"], ["El reloj", "Sin reloj conectado para llamadas"], ["El teléfono", "Suena donde esté el teléfono"]], 0], ["link", "Cómo usar el Tag"]],
    bottom: [["secondary", "Probar el Tag"], ["primary", "Seguir"]] },

  { id: "18-guia-del-tag", title: "Cómo usar el Tag", group: "Preparar un relevo",
    note: "Guía del Tag en ocho pasos, que se abre sola la primera vez: dónde está el botón, encenderlo, callarlo y la pila.",
    behind: "17-donde-suena",
    sheet: { title: "Cómo usar el Tag", action: "Cerrar", body: [["tagart"], ["center", "El centro es el botón"], ["h2", "Este es tu Tag"], ["p", "Es redondo y su botón no se ve: es el centro de la cara de arriba. Al apretarlo firme se siente un clic. Relevo lo hace sonar por Bluetooth."], ["dots", 8, 0]], bottom: [["primary", "Siguiente"]] } },

  { id: "19-todo-listo", title: "Preparar 6 de 6 · Todo listo", group: "Preparar un relevo",
    note: "Revisión: cada dato se toca para cambiarlo. «Activar el relevo» empieza a contar.",
    top: { back: true, progress: [6, 6] },
    body: [["h1", "Todo listo"], ["hint", "Revisa que todo esté bien. Toca cualquier dato para cambiarlo y después «Activar el relevo»."],
      ["group", [["Qué quieres hacer", "Leer 10 páginas ›"], ["Para empezar", "Abrir el libro ›"], ["Dónde empiezas", "En el velador ›"], ["Apps que cuentan", "Clock ›"], ["Suena después de", "15 min ›"], ["Suena", "El Tag ›"]]],
      ["check", "Guardar en tus actividades para la próxima vez", false]],
    bottom: [["primary", "Activar el relevo"]] },

  // ---------- Contar, sonar y decidir ----------
  { id: "20-relevo-activado", title: "Tu primer relevo está activo", group: "Contar, sonar y decidir",
    note: "Confirmación del primer relevo, con lo que va a pasar.",
    behind: "21-inicio-contando",
    sheet: { body: [["icon"], ["h2", "Tu primer relevo está activo"], ["p", "Usa el teléfono como siempre. Cuando sumes 15 min en Clock, sonará en el Tag."], ["p", "Cuando suene, la app te dirá qué hacer. Puedes ver o desactivar el relevo en Inicio."]], bottom: [["primary", "Entendido"]] } },

  { id: "21-inicio-contando", title: "Inicio · contando", group: "Contar, sonar y decidir",
    note: "Inicio mientras cuenta: el avance y el resumen del relevo.",
    tab: 0,
    body: [["header"], ["date", "Lunes 19 de octubre"], ["h1", `Hola, ${NAME}.`],
      ["card", [["img", 110, "Ilustración"], ["pill", "Contando"], ["b", "Vuelve a leer 10 páginas."], ["small", "Sonará en el Tag."], ["progress", 0.35, "5 min de 15 min"]]],
      ["label", "Tu relevo"], ["group", [["Para empezar", "Abrir el libro"], ["Dónde empiezas", "En el velador"], ["Suena", "El Tag"]]]],
    float: ["primary", "Ver mi relevo"] },

  { id: "22-relevo-activo", title: "Tu relevo (activo)", group: "Contar, sonar y decidir",
    note: "El relevo en curso: avance, datos que se tocan para editar, volver al inicio o desactivar.",
    body: [["img", 200, "Ilustración de la actividad", true, true], ["pill", "Contando"], ["h1", "Vuelve a leer 10 páginas."], ["small", "Sonará en el Tag después de 15 min en las apps que elegiste."], ["progress", 0.35, "5 min de 15 min"],
      ["group", [["Para empezar", "Abrir el libro ›"], ["Dónde empiezas", "En el velador ›"], ["Apps que cuentan", "Clock ›"]]]],
    bottom: [["primary", "Volver al inicio"], ["secondary", "Desactivar el relevo"]] },

  { id: "23-suena", title: "Suena", group: "Contar, sonar y decidir",
    note: "La señal: la actividad y su primer paso. «Silenciar y continuar» la detiene; también se calla con el botón del Tag.",
    body: [["img", 230, "Ilustración de la actividad", true], ["pill", "Suena en el Tag"], ["small", "Es momento de volver a elegir"], ["h1", "Vuelve a leer 10 páginas."], ["p", "Empieza por abrir el libro, en el velador."]],
    bottom: [["primary", "Silenciar y continuar"]] },

  { id: "24-que-decidiste", title: "¿Qué decidiste?", group: "Contar, sonar y decidir",
    note: "Preguntas de un toque después de la señal, todas omitibles. «¿Qué decidiste?» tiene tres respuestas del mismo peso.",
    body: [["context", "Sonó en el Tag · Vuelve a leer 10 páginas."], ["q", "¿Cómo te cayó el sonido?"], ["faces", ["Bien", "Normal", "Mal"]],
      ["q", "Cuando sonó, ¿supiste qué querías hacer antes de leerlo en la pantalla?"], ["seg", ["Sí", "A medias", "No"], -1], ["q", "¿Recordaste cómo empezar?"], ["seg", ["Sí", "No"], -1],
      ["h2", "¿Qué decidiste?"], ["choices", ["Comencé la actividad", "La dejé para después", "Cambié de idea"]]],
    bottom: [["ghost", "Saltar"]] },

  // ---------- Pestañas ----------
  { id: "25-inicio", title: "Inicio", group: "Inicio, Ruta y Perfil",
    note: "Inicio sin relevo: el paso actual de la ruta e ideas para preparar otro.",
    tab: 0,
    body: [["header"], ["date", "Lunes 19 de octubre"], ["h1", `Hola, ${NAME}.`],
      ["card", [["img", 120, "Ilustración"], ["small", "Tu ruta · Leer"], ["b", "Leer 10 páginas"], ["rowbtn", "Empieza por abrir el libro, en el velador.", "Preparar"]]],
      ["label", "Ideas"], ["tiles", ["Leer", "Dormir a tiempo", "Hacer ejercicio"], 3, []]],
    float: ["primary", "Preparar un relevo"] },

  { id: "26-ruta", title: "Tu ruta", group: "Inicio, Ruta y Perfil",
    note: "La ruta: el paso actual y todos los pasos. Tras tres «Comencé», ofrece el siguiente.",
    tab: 1,
    body: [["space", 8], ["h1", "Tu ruta"], ["small", "Pasos pequeños hacia lo que te gustaría hacer más seguido."],
      ["card", [["img", 110, "Ilustración"], ["pill", "Ahora"], ["small", "Leer · paso 1 de 3"], ["b", "Leer 10 páginas"], ["small", "Empieza por abrir el libro, en el velador."]]],
      ["label", "Todos los pasos"], ["numbered", [["Leer 10 páginas", "Ahora"], ["Leer un capítulo de manga", ""]]]],
    float: ["primary", "Preparar un relevo con este paso"] },

  { id: "27-perfil", title: "Perfil", group: "Inicio, Ruta y Perfil",
    note: "Perfil: la semana, los relevos, las actividades y la ruta.",
    tab: 2,
    body: [["space", 10], ["avatar", "N", 76], ["center", NAME, true], ["center", "Leer"], ["centerchip", "Editar"],
      ["card", [["small", "Tu semana"], ["b", "Preparaste 1 relevo. Dijiste que empezaste 1 vez."], ["link", "¿Qué te ayudó?"]]],
      ["label", "Relevos"], ["group", [["Tus relevos", "1 ›"], ["Tus actividades", "›"], ["Tu ruta", "1 interés ›"]]]] },

  { id: "28-perfil-ajustes", title: "Perfil · ajustes y ayuda", group: "Inicio, Ruta y Perfil",
    note: "Más abajo en Perfil: ajustes, privacidad, ayuda y la versión de la app.",
    tab: 2,
    body: [["label", "Ajustes"], ["group", [["Avisos y resúmenes", "›"], ["Apariencia", "›"], ["Permisos", "›"]]], ["label", "Privacidad"], ["group", [["Tus datos", "›"]]],
      ["label", "Ayuda"], ["group", [["Cómo funciona Relevo", "›"], ["Cómo usar el Tag", "›"], ["Tu opinión", "›"], ["Reportar un problema", "›"]]], ["tiny", "Relevo 2.32 · Proyecto de Título de Diseño, Universidad Diego Portales"]] },

  // ---------- Perfil ----------
  { id: "29-tus-relevos", title: "Tus relevos", group: "Perfil",
    note: "Historial de relevos, por día, con lo que la persona dijo que hizo.",
    top: { back: true },
    body: [["h1", "Tus relevos"], ["label", "Hoy"], ["group", [["Leer 10 páginas", "", "Clock · 15 min · Dijiste que empezaste"]]]] },

  { id: "30-tus-actividades", title: "Tus actividades", group: "Perfil",
    note: "Actividades propias, para preparar en un toque.",
    top: { back: true },
    body: [["h1", "Tus actividades"], ["small", "Lo que haces seguido, listo para preparar en un toque."], ["empty", "Todavía no tienes actividades", "Anota qué haces, cómo empiezas y dónde. Después la encuentras en Inicio y al preparar un relevo."]],
    bottom: [["primary", "Crear una actividad"]] },

  { id: "31-nueva-actividad", title: "Nueva actividad", group: "Perfil",
    note: "Crear una actividad: nombre, primer paso y lugar.",
    top: { cancel: true },
    body: [["h1", "Nueva actividad"], ["imgpick", "Cambiar la imagen"], ["field", "Actividad", "", "Ej.: practicar guitarra"], ["field", "Para empezar", "", "Ej.: sacar la guitarra del estuche"], ["field", "Dónde empiezas", "", "Ej.: junto a la guitarra"]],
    bottom: [["primary", "Guardar"]] },

  { id: "32-tu-perfil", title: "Editar el perfil", group: "Perfil",
    note: "Editar el perfil: emoji, nombre e intereses.",
    top: { cancel: true },
    body: [["h1", "Tu perfil"], ["avatar", "N", 64], ["centerchip", "Cambiar el emoji"], ["field", "Tu nombre", NAME], ["label", "Intereses"], ["tiles", ["Dormir a tiempo", "Leer", "Hacer ejercicio", "Salir en bicicleta"], 2, [1]]],
    bottom: [["primary", "Guardar"]] },

  { id: "33-avisos", title: "Avisos y resúmenes", group: "Perfil",
    note: "Activación automática (apagada por defecto, con la explicación de qué mira), resumen semanal, aviso semanal y mensaje después de responder.",
    top: { back: true },
    body: [["h1", "Avisos y resúmenes"],
      ["setting", "Activación automática", "Cuando abras las apps de tu último relevo, Relevo empieza a contar solo.", ["No", "Sí"], 0],
      ["setting", "Resumen semanal", "Lo que preparaste esta semana, en tu perfil.", ["No", "Sí"], 1],
      ["setting", "Aviso semanal", "Si pasas una semana sin abrir Relevo, te avisa una vez.", ["No", "Sí"], 0],
      ["setting", "Mensaje después de responder", "Unas palabras cuando cuentas qué decidiste.", ["No", "Sí"], 1]] },

  { id: "34-apariencia", title: "Apariencia", group: "Perfil",
    note: "Tema claro, oscuro o automático, y tamaño del texto, con una vista previa.",
    top: { back: true },
    body: [["h1", "Apariencia"], ["card", [["b", "Vuelve a leer."], ["small", "Sonará junto al sillón después de 40 min."]]],
      ["setting", "Tema", "Claro, oscuro o como esté tu teléfono.", ["Automático", "Claro", "Oscuro"], 0],
      ["setting", "Tamaño del texto", "Se suma al tamaño que usas en el teléfono.", ["Estándar", "Grande"], 0]] },

  { id: "35-permisos", title: "Permisos", group: "Perfil",
    note: "El estado de cada permiso y para qué sirve.",
    top: { back: true },
    body: [["h1", "Permisos"], ["group", [["Tiempo de uso", "Permitido", "Para contar el tiempo en las apps que elijas."], ["Notificaciones", "Permitidas", "Para avisarte aunque estés en otra app."], ["Batería", "Con restricción ›", "Para que Android no detenga a Relevo."]]],
      ["small", "Tiempo de uso es necesario para contar. Lo demás es opcional."]] },

  { id: "36-tus-datos", title: "Tus datos", group: "Perfil",
    note: "El código, lo que aceptó, el estado del envío, la copia en el teléfono, descargar y borrar los datos.",
    top: { back: true },
    body: [["h1", "Tus datos"], ["small", "Guardamos lo que haces en Relevo con un código; tu nombre se guarda aparte. No vemos lo que haces dentro de otras apps."],
      ["group", [["Tu código", "XXXX"], ["Lo que aceptaste", "›"], ["Datos enviados", "Al día"], ["Copia en el teléfono", "", "En Documentos/Relevo"]]],
      ["group", [["Descargar mis datos", "›", "Un archivo con todo lo guardado en el teléfono."], ["Borrar mis datos", "›", "También sales del proyecto."]]], ["tiny", "¿Dudas, o prefieres pedir el borrado por correo? Escribe al correo del proyecto con tu código."]] },

  { id: "37-tu-opinion", title: "Tu opinión", group: "Perfil",
    note: "Opinión sobre la app: de 1 a 5 y un comentario.",
    top: { close: true },
    body: [["h1", "¿Cómo te resultó Relevo?"], ["stars"], ["field", "Comentario", "", "¿Qué cambiarías?", 110]],
    bottom: [["primary", "Enviar"]] },

  { id: "38-reportar", title: "Reportar un problema", group: "Perfil",
    note: "Reportar un problema, con datos técnicos opcionales.",
    top: { close: true },
    body: [["h1", "Reportar un problema"], ["field", "¿Qué pasó?", "", "Ej.: no sonó en el parlante", 120], ["check", "Adjuntar datos técnicos", true, "Versión, permisos y estado del envío. Nada de lo que haces en tus apps."]],
    bottom: [["primary", "Enviar"]] },

  { id: "39-prueba-21-dias", title: "Prueba de 21 días (investigador)", group: "Perfil",
    note: "Solo para el investigador, en la sesión inicial: condiciones A, B y C y la secuencia asignada. Se abre manteniendo apretada la versión en Perfil.",
    top: { back: true },
    body: [["h1", "Prueba de 21 días"], ["small", "Para el investigador, en la sesión inicial. Elige la secuencia asignada; hoy será el día 0."],
      ["label", "Condiciones"], ["group", [["A. Suena donde empiezas", "", "El objeto junto a lo que usas para empezar."], ["B. Suena en otro lugar", "", "En otro lugar de la casa, sin relación con la actividad."], ["C. Suena en el teléfono", "", "Esta semana suena en tu teléfono."]]],
      ["label", "Secuencia"], ["options", [["Secuencia 1", "A → B → C"], ["Secuencia 2", "A → C → B"], ["Secuencia 3", "B → A → C"]], 0, true]],
    bottom: [["primary", "Empezar la prueba hoy"]] },
];
