# Plan del rediseño 3.0: la app con la línea nueva, sin perder nada

**Fecha:** 11 de octubre de 2026. **Decisión:** D-128, plan propuesto y pendiente de la aprobación del autor. **Diseño de referencia:** [«Relevo, la app»](../../10_recursos_visuales/rediseno-app-2026-10-11/relevo-la-app.html), también publicada como [página privada en claude.ai](https://claude.ai/artifact/E6nkPDDmDrDF9Gw8zNxnqM). **Parte de:** la app 2.30 (versionCode 42).

## Pedido

El autor pidió:

- un rediseño total de la app, con el estilo de las pantallas de «Relevo con aura» y la línea nueva: logo, paleta 2, íconos propios y cielos de las actividades;
- conservar las pantallas y las decisiones tomadas;
- que la persona pueda actualizar sin problemas y sin perder ni borrar nada.

## Principio

**Cambia cómo se ve, no lo que la app sabe.** El rediseño toca solo la capa visual (`ui/`, `theme/` y los recursos gráficos). La versión 3.0 se instala encima de la 2.30, como todas las anteriores. Al abrirla, la persona encuentra lo mismo que tenía:

- sus relevos y su relevo activo;
- sus actividades, su ruta y su perfil;
- el Tag vinculado y sus permisos;
- lo que ya se envió a la investigación.

## Lo que no cambia

| Qué | Dónde está | Cómo se protege |
| --- | --- | --- |
| Paquete | `applicationId = "cl.udp.relevo"` en `app/build.gradle.kts` | No se toca |
| Firma | La versión de entrega se firma con la clave de depuración de este computador (certificado `fdbe6bbe…`, D-117) | Se respalda la clave antes de empezar. Antes de publicar se comprueba el certificado con `apksigner verify --print-certs`. Si cambia, Android no deja instalar encima y la persona tendría que desinstalar y perder sus datos |
| Número de versión | `versionCode = 42` | Sube a 43 (`versionName = "3.0"`). Nunca baja |
| Preferencias | 14 archivos: `relevo_auto`, `relevo_custom_activities`, `relevo_history`, `relevo_experience` (también la usa `Participation`), `relevo_profile`, `relevo_reminder`, `relevo_last_reminder`, `relevo_remote`, `relevo_backup`, `relevo_route`, `relevo_settings`, `relevo_study`, `relevo_tag` y `relevo_messages` | Mismos nombres de archivo y de clave. Los ajustes nuevos del aura se agregan con valores por defecto; no se borra ni se renombra ninguna clave |
| Base local | `relevo_research.db`, versión 9 (`ResearchLogStore`) | Sigue en la versión 9: no hay migración ni `onUpgrade` nuevo |
| Valores guardados que tocan lo visual | `icon` y `color` de cada actividad propia; `image` del perfil (emoji); `theme` | Se leen tal como están y se traducen al dibujo nuevo con una tabla fija. Al actualizar no se reescribe ningún valor |
| Base del proyecto (Supabase) | Tablas `relevo_*`, eventos y respuestas | Sin cambios de esquema. Solo cambia el valor de `app_version` |
| Pantallas y recorrido | 26 rutas (`Route` en `RelevoApp.kt`), los 6 pasos de preparar y las hojas | Mismas rutas en el mismo orden; cambia su aspecto |
| Decisiones de diseño | D-084 (sin mayúsculas sostenidas), D-103 (el color sube con el momento), D-111 (sin rachas), D-120 (editar sin borrar), D-122 (íconos después de la palabra) | Se mantienen y se comprueban en cada pantalla |
| Investigación | Preguntas tras la señal, cierre de 21 días, condiciones A, B y C, textos del consentimiento | No cambian sus textos ni sus nombres internos. El consentimiento no cambia de versión, así que nadie debe aceptarlo de nuevo |
| Relevo activo al actualizar | `RestoreMonitorReceiver` escucha `MY_PACKAGE_REPLACED` y retoma el conteo | Se mantiene, y se prueba actualizando con un relevo contando |

## Cuándo instalarla

Cambiar el aspecto de la app en medio de la prueba de 21 días agregaría una diferencia entre semanas que no está en el diseño de la prueba, y sería una amenaza a la validez. Por eso:

- La 3.0 no se instala a una persona que esté en medio de su prueba.
- Se instala al terminar la prueba, o al empezar una tanda nueva.
- Si el autor decide instalarla igual, se registra la fecha. Cada relevo ya guarda su `app_version`.

## Fases

Cada fase termina con la app compilada, las pruebas unitarias en verde y capturas antes y después.

1. **Preparar:**
   - Respaldar `%USERPROFILE%\.android\debug.keystore` fuera del computador.
   - Respaldar los datos del emulador con la 2.30 instalada, como en las versiones anteriores.
   - Capturar las 26 rutas y las hojas de la 2.30 como referencia.
   - Fijar la regla del rediseño: no se modifican `data/`, `domain/`, `monitor/` ni `signal/`. Se comprueba con `git diff --stat` antes de cada entrega.
2. **Tokens:**
   - `RelevoColors` toma la paleta nueva: papel `#F7F4F0`, piedra `#EEE9E3`, tinta `#141312`, las seis fichas de la paleta 2 y el rojo solo para errores.
   - `Type.kt` usa Instrument Sans, que va dentro de la app con su licencia OFL en `licencias/`.
   - Las formas pasan a píldoras y radios de 14 a 22 dp.
   - Con esto toda la app cambia de piel sin tocar ninguna pantalla.
3. **Íconos y piezas:**
   - Los 72 íconos se generan como `ImageVector` desde [el JSON](../../10_recursos_visuales/iconos-relevo-2026-10-11/iconos-relevo.json). Cada uno ocupa el lugar del `KitIcon` que indica su campo `kitIcon`, y los nombres del enum no cambian porque se guardan en las actividades.
   - Se rehacen las piezas: botón en píldora de tinta, ficha de color con ícono en tinta, cápsula blanca sobre los cielos, vidrio para la barra y las hojas, opción con anillo de tinta y barra de pestañas con texto.
4. **Pantallas**, por grupos y en este orden:
   - pestañas;
   - preparar;
   - el relevo (contando, suena, qué decidiste);
   - primera vez;
   - lo tuyo (actividades, color, apariencia y aura, semana, guía del Tag);
   - las demás rutas: historial, avisos, permisos, privacidad, editar perfil y ruta, estudio, cierre, opinión y reporte. Estas usan las mismas piezas.
5. **Aura, cielos y logo:**
   - **Aura:** se dibuja con un sombreador (`RuntimeShader`) en Android 13 o superior. En Android 12 (la versión mínima es la 31) se usa un degradado fijo.
   - **Movimiento:** respeta «reducir movimiento» y se detiene fuera de pantalla.
   - **Cielos:** reemplazan a `ActivityArt`, con grano de una textura precalculada.
   - **Logo:** el ícono adaptable usa la marca plana sobre blanco. La notificación usa la silueta blanca, porque Android la pinta de un color. La pantalla de carga usa la marca con degradado «Luz».
   - **Ajustes nuevos en Apariencia:** tu aura (encendida o apagada), intensidad, color y movimiento. Se guardan en `relevo_settings` con claves nuevas.
6. **Verificar y publicar:**
   - **Actualizar con datos:** se instala la 2.30 de depuración con datos reales del emulador y un relevo contando. Se guardan las preferencias y la base con `run-as`. Se instala la 3.0 de depuración encima y se vuelve a guardar. Las dos copias deben ser iguales, salvo los ajustes nuevos.
   - **Relevo activo:** el conteo sigue tras actualizar, y el Tag vinculado suena en la prueba de sonido.
   - **Pruebas y accesibilidad:** las 85 pruebas unitarias; TalkBack; letra grande al 200 %; contraste de cada pantalla (4,5:1 en texto, 3:1 en íconos); fluidez medida con `gfxinfo`, como en la 2.28.
   - **Versión de entrega:** se instala la 3.0 de entrega sobre la 2.30 de entrega en un teléfono real. Se comprueba la firma y se guarda el SHA-256 del APK en el documento de la versión.

## Mapa de pantallas

| Ruta | Pantalla en el diseño |
| --- | --- |
| `WELCOME`, `HOW_IT_WORKS`, `CONSENT`, `PERMISSION`, `PROFILE_SETUP`, `FIRST_RELEVO` | Bienvenida, Cómo funciona, Antes de empezar, Permisos, Tu perfil, Tu primer relevo |
| `TABS` | Inicio, Tu ruta, Perfil |
| `PREPARE` | Los seis pasos |
| `ACTIVE`, `SIGNAL`, `DECIDE` | Contando, Suena, ¿Qué decidiste? y Tres preguntas |
| `ACTIVITIES`, `ACTIVITY_EDIT`, `APPEARANCE`, `WEEK` | Tus actividades, Elige su color, Apariencia y aura, Tu semana |
| `ROUTE_EDIT`, `PROFILE_EDIT`, `NOTICES`, `PERMISSIONS`, `HISTORY`, `PRIVACY`, `CONSENT_DETAILS`, `STUDY`, `CLOSING`, `FEEDBACK`, `REPORT` | No tienen pantalla propia en el diseño. Se arman con las piezas: filas con ficha, campos, interruptores y botones en píldora |
| Hojas: guía del Tag, editar el relevo, primer relevo activo, notas de la guía | Hoja de vidrio sobre la pantalla, como «Cómo usar el Tag» |

## Riesgos y cómo se cubren

| Riesgo | Qué se hace |
| --- | --- |
| Perder la clave de firma o compilar en otro computador | Respaldar la clave en la fase 1 y comprobar el certificado antes de cada publicación |
| R8 quita recursos que se piden por nombre, como los emoji del perfil | Reglas `tools:keep` para los recursos que se buscan por nombre, y una prueba del perfil con emoji en la versión de entrega |
| El sombreador del aura hace lenta la app, como pasó con los desenfoques en la 2.28 | Medir con `gfxinfo`, pausar el aura fuera de pantalla y ofrecer apagarla |
| El texto sobre los cielos no se lee | Cápsula blanca con letra de tinta, medida entre 15:1 y 17,8:1 |
| Tema oscuro | La línea nueva es clara. La 2.30 guarda `theme` = `DARK` para quien lo eligió; ese valor se respeta con una variante «Noche» de los tokens, o se decide quitarlo. **Decisión del autor** |
| Cambiar la app en medio de la prueba | Instalarla solo entre tandas (ver arriba) |

## Decisiones pendientes del autor

- Aprobar el plan (D-128), el logo con degradado y el lugar como tercera luz (D-127).
- El tema oscuro: mantenerlo con una variante «Noche» o dejar la app solo en claro.
- El momento de instalar la 3.0, según la tanda de la prueba.
- Si «Apariencia» pasa a llamarse «Apariencia y aura».

## Después de publicar

- La memoria (capítulo 11) describe la identidad que el prototipo aplica. Al publicar la 3.0 hay que:
  - reemplazar su tercer párrafo por la versión breve del [documento 41](../../10_recursos_visuales/41_fundamento-del-color-texto-academico-2026-10-11.md);
  - actualizar la Figura 2 con capturas de la 3.0.
- Hay que registrar la versión en el README de la app, en el panel de administración (última versión) y en el traspaso.

## Registro de cambios (disclaimer)

### 2026-10-11 — Creación

- **Qué se añadió:** el plan del rediseño 3.0, con lo que no cambia, cuándo instalarla, seis fases, el mapa de las 26 rutas, los riesgos y las decisiones pendientes.
- **Cómo estaba antes:** la línea nueva existía solo en láminas, y no había un plan para llevarla a la app sin perder datos.
- **Por qué:** pedido del autor (D-128).
