# Android 2.14: guía con contexto y primer relevo acompañado

**Fecha:** 29 de septiembre de 2026. **Versión:** 2.14 (`versionCode 26`). **Rama:** `android-2.7`. **Consentimiento en la app:** `2026-09-29-v9`, sin cambios de fondo.
**Base:** [Android 2.13](version-2.13-guia-intereses-y-nombre-2026-09-29.md). Es la revisión final antes del testeo real: la guía de la primera vez da contexto y termina haciendo el primer relevo con la persona.

## Qué pidió el autor

Reescribir las frases que sonaban poco naturales («Relevo solo cuenta el tiempo», «suena… y para solo», «Si estás bien donde estás, sigue»); mostrar el video más grande; hacer una guía más fácil y guiada, que no solo explique el proyecto, la app y el sistema, sino que deje hacer el primer relevo, con contexto; dejar la app lista para el testeo real, y registrar cada pedido a la IA para auditar su uso (ver el [registro de pedidos](../../00_gobernanza/registro-de-pedidos-a-la-ia.md)).

## Qué cambió

| Pedido | En la app |
| --- | --- |
| Frases más naturales | Se quitaron las tres frases de la guía. El consentimiento dice «suena unos 30 segundos y se apaga» en vez de «y para solo». Las notas del primer relevo ya no repiten lo que la pantalla dice: explican para qué sirve cada paso. |
| Video más grande | En la guía ocupa el 84 % del ancho (antes el 56 %). |
| Guía con contexto | Tres pantallas antes del consentimiento: «Esto es Relevo» (el video), «¿Te ha pasado?» (abres una app para descansar y lo que querías hacer queda esperando: el problema de la memoria, secciones 3 y 7) y «Cómo funciona», con las tres partes del sistema: la app, el parlante y tú, que decides. La primera vez sigue una cuarta pantalla con la pregunta del aviso semanal. |
| Hacer el primer relevo | Después del nombre y los intereses aparece «Hagamos tu primer relevo», con la foto y el primer paso de la ruta que la persona eligió como ejemplo («Empecemos con “Acostarte sin el teléfono”, de tu ruta “Dormir a tiempo”»). La preparación recorre los seis pasos, aunque vengan completos, con una nota contextual en cada uno («Te propusimos…», «El primer paso es…»). Al activarlo, Inicio muestra «Tu primer relevo está activo» con lo que pasará: cuándo y dónde sonará. Se puede dejar para después. |
| Revisión final | Se corrigió el defecto registrado en la 2.10: al responder, la pantalla dejaba ver por un instante «Desactivaste el relevo. Vuelve a .». Ahora sale completa, con las preguntas, hasta desaparecer. |

## Fundamento en la memoria

- **Contexto antes de aceptar:** tabla 5, «Conocer y aceptar: entender propósito, límites»; sección 3, el problema de la intención que pierde presencia.
- **Aprender haciendo:** criterio 6, carga proporcional. La explicación queda en pocas pantallas y el resto se aprende en el primer relevo real, que la persona igual tiene que preparar.
- **El ejemplo sale de la persona:** criterio 1, partir de una intención propia; la propuesta viene de la ruta que ella eligió y se puede cambiar.
- **Qué pasa después de activar:** sección 6, memoria prospectiva; tabla 5, saber que el ciclo sigue activo.

## Comprobaciones

En un emulador Android 16, con conexión y datos de prueba:

- 61 pruebas unitarias pasan; el APK sale de una compilación limpia.
- **Guía:** las cuatro pantallas, con el video más grande.
- **Primer relevo:** con el interés «Dormir a tiempo», la pantalla propuso «Acostarte sin el teléfono»; la preparación empezó en el paso 1 con las notas contextuales; al activar, apareció «Tu primer relevo está activo» con «Cuando sumes 15 s en YouTube, sonará en el teléfono».
- **Salida de la respuesta:** una captura tomada justo al responder muestra la pantalla completa; antes se veía el encabezado vacío.
- **Borrar mis datos:** dejó en 0 las filas del código de prueba en las cinco tablas.

Los datos de prueba se borraron desde la app y los del emulador se restauraron (código `9P6E`).

## Lo que no se comprobó

- El teléfono real, el parlante y el sonido en ellos.
- Si la guía se entiende sin ayuda: se sabrá en la sesión inicial con la primera persona.
- El borrado sin conexión.

## Antes de la sesión inicial

1. Instalar el [APK 2.14](releases/relevo-android-2.14-2026-09-29.apk) en el teléfono de la persona.
2. Dejar que haga la guía y el primer relevo sola, observando dónde duda.
3. Configurar las tres semanas manteniendo presionado el texto de la versión al final del perfil.
4. Anotar el código (Perfil › Tus datos) en la hoja firmada.

## Registro de cambios (disclaimer)

### 2026-09-29 — Creación

- **Qué se añadió:** el registro de Android 2.14: frases corregidas, video más grande, guía con contexto, primer relevo acompañado, aviso tras activar y corrección del defecto de la 2.10.
- **Cómo estaba antes:** la 2.13 explicaba cada parte en nueve pantallas, con algunas frases poco naturales, y el primer relevo empezaba desde Inicio.
- **Por qué:** pedidos del autor (D-090).
