# Android 2.20: la persona elige dónde suena

**Fecha:** 6 de octubre de 2026. **Decisión:** D-110. **Estado:** compilada desde cero, 83 pruebas unitarias aprobadas y recorrida completa en el emulador como persona nueva, desde la bienvenida hasta la respuesta después de la señal. No se ha probado en un teléfono real. El consentimiento pasa a `2026-10-06-v12`.

## Qué pidió el autor

Que la app no imponga las condiciones A, B y C por semana: la persona elige, y así se sabe a qué tiende. También que el flujo de navegación sea perfecto y fácil de entender, porque el primer testeo empieza el 7 de octubre.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Prueba de 21 días | «Empezar la prueba hoy» ya no pide una secuencia: el plan es libre (`LIBRE`). Cuenta los días, abre las tarjetas de cada semana y el cierre del día 21, pero no fija dónde suena. Los planes con secuencia siguen funcionando si ya existían. |
| ¿Cómo te avisa? | Todas las salidas están disponibles siempre. Con un objeto (parlante, reloj o llavero) aparece «¿Dónde dejarás el parlante?» con dos opciones: «Donde empiezas» o «En otro lugar». Hay que elegir una para seguir. |
| Qué se registra | Cada relevo guarda lo que eligió la persona en `study_condition`: A, un objeto donde empieza; B, un objeto en otro lugar; C, el teléfono. También queda el evento de uso `lugar_del_objeto`. No cambia la base de datos. |
| Textos neutros | Se quitaron los textos que empujaban a dejar el parlante junto al comienzo: la nota de «¿Dónde empiezas?», la foto del parlante junto a la puerta, la tarjeta del primer día y la guía. La guía dice ahora que la persona elige qué suena y dónde lo deja. |
| Señal y notificación | La notificación del teléfono muestra la actividad (antes era genérica en la semana C). La frase de la señal siempre dice dónde empieza. |
| Inicio | El relevo activo muestra «Suena: El parlante, donde empiezas» en vez de la condición de la semana. |
| Cierre del día 21 | «¿Dónde te sirvió más que sonara?» (un objeto donde empiezo, un objeto en otro lugar, el teléfono o en ninguno) y «¿Dónde dejabas lo que sonaba la mayor parte del tiempo?». |
| Consentimiento | «Cómo es» dice que la persona elige cada vez dónde suena y dónde deja el objeto. Versión `2026-10-06-v12`. |
| Panel | Versión 6: «Qué elige», en total y por semana, y los resultados por elección ([panel](../panel-admin/README.md)). |

## Recorrido en el emulador

Sin red, con un respaldo de los datos del emulador que se devolvió al terminar:

1. Bienvenida, video, «Cómo funciona», aviso semanal y consentimiento.
2. Permisos, nombre, emoji e intereses.
3. Primer relevo guiado: actividad, cómo empieza, dónde empieza, apps y tiempo, dónde suena y revisión.
4. Activación con 15 segundos, uso de Chrome, señal con notificación que muestra la actividad, pantalla de la señal, preguntas y vuelta a Inicio.
5. Configuración de la prueba: «Empezar la prueba hoy» sin secuencia, con «Dónde suena: lo elige la persona».

El relevo quedó registrado con `study_condition = C`, porque la persona eligió el teléfono. No hubo cierres inesperados.

**Ajustes hechos durante el recorrido:** se quitaron los textos que sesgaban la elección y una frase repetida en la pantalla de permisos.

## Pendientes y límites

- **La salida que aparece marcada:** el parlante viene elegido por defecto, como antes. Puede inclinar la elección. La pregunta del lugar, en cambio, empieza sin respuesta.
- **Lo que no se puede atribuir a la elección:** como la persona elige, las diferencias entre A, B y C pueden deberse a la actividad, al día o a sus preferencias, no solo al lugar. El protocolo 02 lo registra como límite (D-110).
- **Dos detalles visuales sin corregir:** en la pantalla del primer relevo, la lista de pasos queda en parte bajo los botones. Dos tarjetas de intereses («Dormir a tiempo» y «Salir en bicicleta») no tienen foto.
- **Sin teléfono real:** la app no se ha probado en un teléfono real ni con el parlante, el reloj o el llavero.

**APK:** [relevo-android-2.20-2026-10-06.apk](releases/relevo-android-2.20-2026-10-06.apk), SHA-256 `B85A05FD0CF089D8E9D253111F9368E589858DF49629310BAF30D8530C3959F8` (41,3 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-10-06 — Creación

- **Qué se añadió:** la versión 2.20, con elección libre de dónde suena y el registro de la condición elegida, los textos neutros, el consentimiento v12 y el recorrido completo en el emulador.
- **Cómo estaba antes:** en la 2.19, durante la prueba, cada semana imponía una condición (A, B o C) según una secuencia asignada.
- **Por qué:** el autor pidió que la persona elija, para saber a qué tiende, y un flujo fácil de entender antes del primer testeo (D-110).
