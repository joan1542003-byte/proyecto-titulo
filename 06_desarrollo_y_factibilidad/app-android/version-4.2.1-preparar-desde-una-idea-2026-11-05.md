# Android 4.2.1: preparar desde una idea abre lo que falta, no un relevo desde cero

**Fecha:** 5 de noviembre de 2026. **Corrige:** [Android 4.2](version-4.2-comentario-preguntas-borde-e-inicio-2026-11-05.md) (D-157). **Rama:** `android-4.0-rediseno`. **Versión:** 4.2.1, `versionCode` 53. **APK:** [relevo-android-4.2.1-revision-2026-11-05.apk](releases/relevo-android-4.2.1-revision-2026-11-05.apk), optimizado; se instala aparte como «Relevo 4.2.1».

## Qué reportó el autor

En Actividades › Ideas, «Leer manga» › «Preparar un relevo» no preparaba el relevo con esa idea: hacía crearlo desde cero.

## Qué pasaba

Preparar abre en el primer dato que falta: una idea ya trae la actividad, cómo empieza y en qué lugar, así que debería abrir en «¿Cuándo suena?». Pero mientras la persona no activa su primer relevo, la guía del primer relevo (D-088) forzaba el paso 1, «¿Qué quieres hacer?», con la lista completa de ideas. La idea quedaba escrita en el campo, pero la pantalla pedía elegir de nuevo, como si nada se hubiera elegido. Le pasaba a toda persona nueva que entrara por Ideas, por sus actividades o por un paso de la ruta, y a perfiles de prueba como el del emulador, que no activaron un relevo desde la app.

## Qué se hizo

Preparar ahora sabe desde dónde se abrió:

| Desde | Abre en |
| --- | --- |
| Una idea, una actividad guardada o un paso de la ruta | Lo primero que falta: con una idea, «¿Cuándo suena?» |
| Repetir el último relevo | «Todo listo», como antes |
| «Preparar un relevo» sin nada elegido, y «Elegir otra» | El paso 1, para elegir |
| «Tu primer relevo» (la guía) | El paso 1, para recorrer los seis pasos (D-088, D-156) |
| Editar el relevo que cuenta | «Todo listo», como antes |

Lo que la idea completó se ve y se cambia en «Todo listo», con la pregunta de cada paso sobre su dato. «Elegir otra» empieza por el paso 1 aunque quede un borrador, porque su nombre promete elegir. De paso, dos avisos de «Todo listo» usan las preguntas de la 4.2: «Falta cómo empiezas la actividad.» y «Falta en qué lugar empieza.».

## Lo que se encontró al revisarlo

Preparar desde una idea, desde «Creadas por ti» o desde «Tus actividades» en Inicio no se fijaba si ya había un relevo contando: lo pasaba a borrador sin avisar, y dejaba de estar activo. «Paso a paso» ya tenía la regla correcta: mientras un relevo cuenta, en vez de «Preparar este paso» dice «Cuando termine tu relevo, podrás preparar este paso.». Ahora la siguen todas:

- **Ideas y «Creadas por ti»:** la hoja de la actividad dice «Cuando termine tu relevo, podrás prepararla.» en lugar del botón; «Editar» sigue disponible.
- **Inicio:** los anillos de «Tus actividades» no preparan otro relevo y debajo se lee «Cuando termine tu relevo, podrás preparar otra.»; «Nueva» sigue disponible, porque crear una actividad no toca el relevo.
- **Por dentro:** preparar desde una idea, un paso o el último relevo no hace nada si un relevo está contando. Para cambiarlo está «Cambiar o desactivar», en Tu relevo.

**Inventario:** 1221 textos y 5201 palabras ([inventario](textos/inventario-de-textos.md)).

## Verificación

- **Compilación y pruebas:** `assembleDebug` y `assembleRelease` sin errores; pasan las 91 pruebas unitarias.
- **Causa:** en el perfil de prueba del emulador falta `guide_prepare_done`, así que la guía del primer relevo seguía encendida, como en una persona nueva.
- **Emulador** (Android 16, perfil de prueba), los tres casos:
  - Con un relevo contando, Ideas › «Leer manga» muestra «Cuando termine tu relevo, podrás prepararla.» en lugar del botón.
  - Sin relevo contando, Ideas › «Leer manga» › «Preparar un relevo» abre en «¿Cuándo suena?», con «Leer manga» arriba.
  - «Elegir otra», en Inicio, abre en «¿Qué quieres hacer?» y conserva lo escrito.
- **Sin verificar en pantalla:** el APK optimizado de 4.2.1; el emulador se cerró antes de armarlo porque saturaba el Mac (llegó a mostrar «System UI isn't responding»). El de 4.2 sí se recorrió.

## Registro de cambios (disclaimer)

### 2026-11-05 — Creación

- **Qué cambió:** se describió la corrección 4.2.1.
- **Cómo estaba antes:** preparar desde una idea, sin haber activado el primer relevo, abría en el paso 1, y con un relevo contando lo pasaba a borrador sin avisar.
- **Por qué:** error reportado por el autor.
