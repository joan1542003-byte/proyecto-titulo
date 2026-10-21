# Herramientas de Relevo

**Fecha:** 13 de octubre de 2026. **Decisión:** D-133.

Esta guía reúne lo que se construyó para el proyecto: el panel del testeo, la app Android, las láminas de diseño, el taller para armar piezas de presentación, los íconos, el logo y la memoria en A3. Todo vive en este repositorio y funciona sin claude.ai: cada página se abre con doble clic o con un servidor local.

La escribí para dos lectores:

- **El autor**, que necesita saber cómo se usa cada cosa.
- **Otro Claude** que abra el repositorio: dónde está cada pieza, cómo se ejecuta, qué no se puede tocar y qué falta.

La entrada visual es [herramientas.html](herramientas.html): una página con los enlaces a todo.

## Resumen

| Herramienta | Archivo | Para qué sirve | Cómo se abre |
| --- | --- | --- | --- |
| Panel del testeo | [06_desarrollo_y_factibilidad/panel-admin/](06_desarrollo_y_factibilidad/panel-admin/) | Ver a cada participante, sus relevos, respuestas y uso; enviar mensajes; exportar; borrar datos | `node servidor.js` (datos reales con token) o doble clic en `panel-relevo.html` (datos de ejemplo) |
| App Android | [06_desarrollo_y_factibilidad/app-android/](06_desarrollo_y_factibilidad/app-android/) | La app que usa cada participante | Instalar el APK de `releases/` |
| «Relevo, la app» | [10_recursos_visuales/rediseno-app-2026-10-11/relevo-la-app.html](10_recursos_visuales/rediseno-app-2026-10-11/relevo-la-app.html) | Las 25 pantallas del rediseño, la referencia de la app 3.x | Doble clic |
| «Relevo aplicado» | [10_recursos_visuales/logo-relevo-2026-10-11/relevo-aplicado.html](10_recursos_visuales/logo-relevo-2026-10-11/relevo-aplicado.html) | Logo, colores de las actividades y recorrido, con su fundamento | Doble clic |
| «Relevo con aura» | [10_recursos_visuales/relevo-con-aura-2026-10-10/relevo-con-aura.html](10_recursos_visuales/relevo-con-aura-2026-10-10/relevo-con-aura.html) | La exploración visual aprobada (D-121, D-122) | Doble clic |
| Taller de auras | [10_recursos_visuales/relevo-con-aura-2026-10-10/taller-de-auras.html](10_recursos_visuales/relevo-con-aura-2026-10-10/taller-de-auras.html) | Editor de piezas y láminas para presentaciones y la memoria | Doble clic |
| Íconos de Relevo | [10_recursos_visuales/iconos-relevo-2026-10-11/iconos-relevo.html](10_recursos_visuales/iconos-relevo-2026-10-11/iconos-relevo.html) | Los 72 íconos, sus reglas y la paleta | Doble clic |
| Logo | [10_recursos_visuales/logo-relevo-2026-10-11/](10_recursos_visuales/logo-relevo-2026-10-11/) | Archivos SVG del logo, la marca y el ícono de la app | Usar los SVG |
| Memoria en A3 | [08_memoria/memoria-a3/](08_memoria/memoria-a3/) | La memoria v5 compuesta en A3 horizontal | `node construir.js` |

Las páginas usan Instrument Sans desde Google Fonts. Sin internet se ven con otra letra, pero funcionan. El Excel del panel también necesita internet: carga SheetJS desde cdnjs.

## Panel del testeo

### Qué es

Es la página donde el autor sigue el testeo. Lee los datos que la app envía a Supabase (proyecto `rwzslwtxabmfofqppgwu`). Tiene cinco secciones:

- **Ahora:** cifras del día, quién está para revisar y lo último que llegó.
- **Personas:** cada participante y su ficha, con resumen, tiempo en sus apps con un relevo activo, relevos y respuestas, flujo de uso, teléfono y ajustes. Desde la ficha se le escribe, se descargan sus datos o se borran.
- **Resultados:** comparación de las condiciones A, B y C.
- **Mensajes:** notificaciones a todos o a una persona, con mensajes listos.
- **Exportar:** Excel, CSV y JSON, siempre sin nombres.

El detalle de cada versión está en su [README](06_desarrollo_y_factibilidad/panel-admin/README.md).

### Tres formas de abrirlo

1. **Con datos reales, en este computador.** Hace falta Node 18 o posterior y un token personal de Supabase.
   1. Crear el token en [supabase.com/dashboard/account/tokens](https://supabase.com/dashboard/account/tokens), con la cuenta dueña del proyecto.
   2. Crear el archivo `06_desarrollo_y_factibilidad/panel-admin/.env.local` con una línea: `SUPABASE_ACCESS_TOKEN=sbp_...`. El archivo queda fuera de Git (`.gitignore`).
   3. En esa carpeta, ejecutar:

      ```bash
      node servidor.js
      ```

      Se abre `http://127.0.0.1:8765/`. Abajo aparece «Datos reales de Supabase».
2. **Con datos de ejemplo.** Abrir `panel-relevo.html` con doble clic, o ejecutar `node servidor.js` sin token. Las personas son inventadas («Ejemplo Uno», códigos EJ-01 y EJ-02), y enviar o borrar no cambia nada en Supabase. Sirve para mostrar el panel o probar cambios.
3. **En claude.ai.** El artefacto privado sigue existiendo y usa el conector de Supabase. Ya no es necesario.

### Cómo funciona por dentro

- **`panel-relevo.html`:** la página completa: estilos, consultas SQL y dibujo. Pide los datos con `window.claude.use('mcp')`, la forma de claude.ai.
- **`conector-local.js`:** fuera de claude.ai, crea ese mismo `window.claude`:
  - con el servidor, envía cada consulta a `api/sql`;
  - sin servidor, responde con `datos-de-ejemplo.js`;
  - las descargas son las normales del navegador.
- **`servidor.js`:**
  - Reenvía cada consulta a la API de administración de Supabase (`POST /v1/projects/{ref}/database/query`) con el token.
  - Escucha solo en `127.0.0.1` y exige una clave nueva en cada arranque, así otra página web no puede usarlo.
  - Nunca entrega el token al navegador.
  - No tiene dependencias.

### Cuidado

- **El token puede todo** lo que puede la cuenta en Supabase: leer, escribir y borrar. No se comparte, no se sube al repositorio y conviene revocarlo cuando termine el testeo.
- **Borrar es definitivo.** «Eliminar» borra a la persona y todos sus datos con dos clics. Antes conviene descargar sus datos.
- **Los mensajes llegan de verdad** a los teléfonos.
- **Datos personales:** la ficha muestra nombres. No se publican capturas del panel con datos reales.

### Lo que no se probó

- El modo con token no se probó con un token real: la sesión no tenía uno. Se probaron el servidor sin token, la clave, el bloqueo de otros dominios y el modo de ejemplo completo: pestañas, fichas y resultados, sin errores.
- La primera vez con datos reales hay que mirar que «Ahora» cargue sin aviso de error.

## App Android

### Instalar

- **Para el testeo:** [releases/relevo-android-2.33-2026-10-20.apk](06_desarrollo_y_factibilidad/app-android/releases/relevo-android-2.33-2026-10-20.apk) (D-138). Es la 2.32 con una semana para comparar, con la señal en el teléfono, y sus preguntas. Se inicia en Perfil, manteniendo apretado el texto de la versión. Su código está en la rama `android-2.33`.
- **Con el diseño nuevo:** [releases/relevo-android-3.3-2026-10-20.apk](06_desarrollo_y_factibilidad/app-android/releases/relevo-android-3.3-2026-10-20.apk) (D-138). Trae los arreglos del Tag y la semana para comparar. La próxima versión debe usar `versionCode` 50 o más.
- **Cómo instalar:** se copia al teléfono y se abre. Android pide permitir la instalación desde esa app.
- **Actualizar:** las dos se instalan encima de versiones anteriores, porque tienen la misma firma, y conservan los datos. La 3.3 tiene un número de versión mayor: para volver de ella a la 2.33 hay que instalar con `adb install -r -d`.
- **Durante el testeo:** no conviene cambiar de versión a mitad de la prueba de 21 días.

### Usarla

1. **Primera vez:** bienvenida, video breve, aviso semanal (sí o no), consentimiento, permisos (Tiempo de uso, notificaciones y batería), nombre, emoji e intereses. Después propone el primer relevo.
2. **Preparar un relevo** (seis pasos):
   1. Qué quieres hacer.
   2. Cómo empiezas: el primer paso.
   3. Dónde empiezas.
   4. Cuándo suena: las apps que cuentan y después de cuánto tiempo.
   5. Dónde suena: el Tag, un parlante, un reloj o el teléfono.
   6. Revisar y «Activar el relevo». «Probar con 15 segundos» sirve para ver el ciclo completo.
3. **Mientras cuenta:** Inicio muestra el relevo activo; «Contando» muestra el tiempo.
4. **Cuando suena:** el Tag o la salida elegida suena 30 segundos. Un toque en el Tag lo calla. Después vienen tres preguntas de un toque y «¿Qué decidiste?».
5. **Pestañas:**
   - **Inicio:** el siguiente paso, ideas y tus actividades.
   - **Ruta:** los pasos hacia lo que te gustaría hacer más seguido.
   - **Perfil:** tus relevos, actividades, pasos, apariencia y aura, avisos, permisos, privacidad (borrar mis datos), cómo funciona, cómo usar el Tag, opinión y reportar un problema.
6. **Prueba de 21 días (solo el investigador):** mantener presionada la línea de la versión, al final de Perfil, y elegir la secuencia.

### Compilar y probar

- **Código y compilación:** están en el [README de la app](06_desarrollo_y_factibilidad/app-android/README.md) y en las notas de cada versión.
- **Emulador:** antes de probar, respaldar los datos del autor y activar el modo avión. Al terminar, restaurar los datos y comprobar que el MD5 sea idéntico. El autor también usa el emulador.

## «Relevo, la app»

- **Qué es:** el rediseño en 25 pantallas de alta fidelidad: primera vez, pestañas, preparar, el relevo y lo tuyo. Incluye el logo con degradado, la línea (un color, un papel), los cielos de las actividades y el plan para actualizar sin perder datos.
- **Para qué sirve:** es la referencia que siguió la app 3.2: las medidas de la lámina por 1,5 dan las de la app.
- **Cómo se usa:** se abre y se recorre; no tiene controles. Para comparar con la app, conviene capturar la lámina a 411 px de ancho.

## «Relevo aplicado»

Fundamenta el logo (cuatro luces: tu tiempo, tu primer paso, el lugar y lo que decides) y los colores de las actividades, con evidencia de Chile y Latinoamérica (D-125 a D-127). También muestra el recorrido de la app en wireframes, con dónde va cada color y cada ícono. Se abre y se lee.

## «Relevo con aura»

Es la exploración visual aprobada, inspirada en Dafi (D-121, D-122). Muestra el aura de la pantalla, las fichas de color, las pantallas y las láminas. Sus botones abren el taller.

**Regla de contenido:** el aura es de la pantalla y la persona la personaliza. El Tag no emite luz: solo suena.

## Taller de auras: el editor de piezas para presentaciones

### Qué hace

Arma piezas con el diseño de Relevo para diapositivas y para la memoria. Tiene dos modos.

**Piezas.** Hay 39 piezas editables, en seis grupos:

- Datos, como «3 de 5» (7);
- Fichas y frases (6);
- Tarjetas (9);
- Controles (6);
- Marca (4);
- Pantallas (7).

Se usa así:

1. Elegir una pieza en la biblioteca, a la izquierda.
2. Cambiar sus textos y colores en «Contenido», a la derecha. Hay atajos de texto:
   - `|` pasa a gris lo que sigue;
   - `**palabra**` va en negrita;
   - `{tiempo butter}` pone un ícono con su ficha (los nombres de íconos y colores están en «Atajos para escribir»).
3. Elegir cómo sale:
   - **Sola:** PNG con fondo transparente y recortado, a 1×, 2×, 3× o 4×.
   - **En una lámina:** la pieza sobre papel, aura o cielo, con título. Formatos: diapositiva 16:9, 4K o 4:3, A4 vertical u horizontal, figura para la memoria, cuadrado o vertical 9:16.
4. Descargar:
   - **«Descargar PNG»:** guarda la pieza.
   - **«Copiar»:** la deja lista para pegar en Google Slides, Keynote, PowerPoint, Figma o Word.
   - **«Este grupo en ZIP»** o **«Todas las piezas en ZIP»:** descargan en lote.

**Fondos.** Genera fondos de aura (WebGL): presets de presentación, auras, cielos y elementos.

- Formato, forma, colores y ajustes; texto opcional para la diapositiva.
- «Otra forma» cambia la composición y «Mover» la anima.
- «Descargar PNG» guarda el fondo.

**Guardar.**

- Los cambios quedan en el navegador (`localStorage`, clave `taller-relevo-piezas-v2`).
- «Guardar» suma una copia a «Guardadas».
- «Copiar receta» da un texto JSON para rehacer la misma pieza en otro equipo o guardarla en el repositorio.

### Para modificarlo

Cada pieza se registra con `piece({ id, group, name, f, d, build })`:

- `f`: los campos;
- `d`: los valores por defecto;
- `build`: devuelve el tamaño y una función que dibuja en canvas.

Los íconos son los de D-124. Las tarjetas van siempre derechas, sin giros.

## Íconos de Relevo

- **Qué hay:** 72 íconos propios en cuatro grupos (Relevo, actividades, navegación, acciones y estados), dibujados en una retícula de 24 con trazo 1,6 redondeado.
- **Tamaños ópticos:** el trazo cambia con el tamaño: 16 px → 2,0; 20 → 1,8; 24 → 1,6; 32 → 1,4; 48 → 1,3.
- **Cómo se usa la lámina:**
  - Tocar un ícono lo muestra grande, con su archivo, su equivalente en la app (`KitIcon`) y su color.
  - «Copiar SVG» y «Descargar SVG» sirven para un ícono; «Todos en ZIP», para el juego completo.
- **Archivos:**
  - `svg/` (uno por ícono);
  - `iconos-relevo.svg` (sprite);
  - `iconos-relevo.json` (datos, grupos y `kitIcon`).
- **Un color, un papel:**

  | Color | Papel |
  | --- | --- |
  | Mantequilla | Tiempo |
  | Cielo | Primer paso |
  | Lima | El lugar y lo que suena |
  | Rubor | Lo que decides |
  | Lila | El aura |
  | Durazno | Después |

  El color nunca va solo: siempre lleva ícono y palabra (WCAG 1.4.1). El fundamento está en el [documento 39](10_recursos_visuales/39_iconos-y-color-con-fundamento-2026-10-11.md).

## Logo

Los SVG están en [10_recursos_visuales/logo-relevo-2026-10-11/](10_recursos_visuales/logo-relevo-2026-10-11/):

- logo horizontal y vertical, en tinta, blanco o con degradado;
- la marca sola;
- el logotipo;
- el ícono de la app;
- la versión para la notificación.

Cuándo va cada versión:

- **Con degradado:** desde 48 px.
- **Plana:** en 32 px o menos y en impresión.

El logotipo usa Chillax convertido a trazos, por eso no hace falta la letra. Antes de usar el logo en público conviene revisar el registro en INAPI.

## Memoria en A3

- **Composición actual:** el generador [construir.js](08_memoria/memoria-a3/construir.js) compone la v5 en A3 horizontal: un PDF y un HTML de 32 páginas (D-132). Se ejecuta con `node construir.js` en esa carpeta, necesita Chrome y tarda unos 10 segundos.
- **Rediseño en curso:**
  - El autor pidió letra más grande, una escala de tamaños coherente, mejores tablas, sin viudas, sin etiquetas innecesarias, aperturas menos repetidas y un archivo que se pueda editar en InDesign o Affinity.
  - Se empezó un escritor de IDML ([idml.js](08_memoria/memoria-a3/idml.js)), el formato que abren InDesign y Affinity. Una página de muestra se abrió bien en Affinity, con estilos, texto enlazado, tabla, imágenes, PDF colocado e idioma español.
  - El rediseño completo quedó en pausa por pedido del autor: es lo siguiente.
- **Letra:** Instrument Sans, redonda y cursiva (OFL), está instalada para el usuario de Windows. Quien edite el IDML necesita tenerla instalada.

## Para otro Claude

- **Antes de empezar:** leer [CLAUDE.md](CLAUDE.md) y el [traspaso](00_gobernanza/traspaso-a-claude-2026-09-24.md). Registrar cada pedido del autor el mismo día en el [registro de pedidos](00_gobernanza/registro-de-pedidos-a-la-ia.md) y agregar un registro de cambios a cada Markdown que se toque.
- **Ramas:** se trabaja en `android-2.7` y se sube también a `main`, siempre después de `git fetch`, porque otras sesiones también suben.
- **Lo que nunca va al repositorio:**
  - tokens ni claves de servicio de Supabase (solo la clave publicable);
  - datos de participantes (los únicos del corpus son P1–P8, anónimos);
  - nombres en capturas;
  - archivos de letra que no sean OFL. Chillax no va.
- **Las páginas HTML** se editan directamente. Si alguna vez se publica de nuevo en claude.ai, el archivo ya trae su esqueleto (`<!doctype html>…<body>`) y la herramienta lo reconoce. En claude.ai, el conector local del panel no hace nada.
- **Panel:** las consultas están dentro de `panel-relevo.html` (`SNAPSHOT_SQL` para lo general y `STATS_SQL` para Resultados; las de la ficha, exportar, enviar y borrar están dentro de sus funciones). `datos-de-ejemplo.js` responde según el nombre de la columna que pide cada consulta (`as snapshot`, `as detail`, `as stats`, `as export`, `as nombres`, `as deleted`). Si se agrega una consulta nueva, conviene sumar su respuesta de ejemplo.
- **Probar sin claude.ai:** con un servidor local cualquiera (por ejemplo `npx serve`, o el `servidor.js` del panel) y un navegador. Los `file://` también sirven, salvo el modo con datos reales del panel.

## Wireframes de la app

- **Qué es:** [la lámina](06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-relevo.html) con las 39 pantallas de la 2.32 en muy baja fidelidad, agrupadas por recorrido y con una nota por pantalla. Cada pantalla está en PNG a 3× en `06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/`, y cada recorrido en una hoja en `wireframes-png/hojas/`.
- **Cómo se regeneran:** en `06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/generador/`, se editan las pantallas en `pantallas.js` y se ejecutan `node exportar.js` (los PNG, con Chrome) y `node generar-lamina.js` (la lámina).
- **Contexto:** el [documento del sistema](06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/relevo-frontend-y-backend.md) explica la app, el Tag, Supabase y el panel.

## Registro de cambios (disclaimer)

### 2026-10-20 — Android 3.3

- **Qué cambió:** la app con el diseño nuevo pasa a ser la 3.3.
- **Cómo estaba antes:** era la 3.2.
- **Por qué:** el autor pidió continuar con lo pendiente: llevar la 2.33 a la línea 3.x (D-138).

### 2026-10-20 — Android 2.33

- **Qué cambió:** la app para el testeo pasa a ser la 2.33.
- **Cómo estaba antes:** era la 2.32.
- **Por qué:** pedido del autor (D-138).

### 2026-10-20 — Wireframes en PNG

- **Qué cambió:** los wireframes se rehicieron y se exportan en PNG por pantalla y por recorrido.
- **Cómo estaba antes:** eran SVG generados automáticamente y tenían errores.
- **Por qué:** pedido del autor.

### 2026-10-18 — Wireframes

- **Qué cambió:** se suma la lámina de wireframes y el documento del sistema.
- **Cómo estaba antes:** no había wireframes de la app actual.
- **Por qué:** pedido del autor.

### 2026-10-17 — Android 2.32

- **Qué cambió:** la app para el testeo pasa a ser la 2.32.
- **Cómo estaba antes:** era la 2.31.
- **Por qué:** reporte de una participante (D-137).

### 2026-10-14 — Android 2.31

- **Qué cambió:** la app para el testeo pasa a ser la 2.31; la 3.2 queda como la del diseño nuevo.
- **Cómo estaba antes:** el APK vigente era la 3.2.
- **Por qué:** reporte de una participante (D-136).

### 2026-10-13 — Creación

- **Qué se añadió:** la guía de las herramientas del proyecto (panel, app, láminas, taller, íconos, logo y memoria en A3), cómo se abre y se usa cada una sin claude.ai, y notas para otro Claude.
- **Cómo estaba antes:** el panel y las láminas dependían de claude.ai, y no había una guía de uso que las reuniera.
- **Por qué:** el autor pidió subir el panel y los últimos artefactos a GitHub como algo funcional, documentar todo y que otro Claude pueda leerlo (D-133).
