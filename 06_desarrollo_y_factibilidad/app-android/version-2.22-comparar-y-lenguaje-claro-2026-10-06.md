# Android 2.22: volver a comparar y lenguaje claro

**Fecha:** 6 de octubre de 2026. **Decisión:** D-112, que reemplaza D-110. **Estado:** compilada desde cero, con 83 pruebas unitarias aprobadas y revisada en el emulador en las semanas A y C, desde la preparación hasta la activación. No se ha probado en un teléfono real. El consentimiento pasa a `2026-10-06-v13`.

## Qué pidió el autor

- **Corregir las discrepancias:** la persona elige porque sabe dónde está su primer paso.
- **Decidir entre comparar o dejar elegir:** el autor pidió aplicar lo que fuera óptimo.
- **Mejorar el lenguaje:** quitar lo ambiguo y lo que contradice las acciones de la app.

## Por qué comparar

- **La hipótesis lo pide.** La hipótesis (D-091) dice que una señal en el lugar donde comienza la actividad ayuda a recordarla. Para ponerla a prueba hay que ver qué pasa con la señal ahí y sin ella. Si la persona elige siempre dónde suena, no se puede saber si el lugar ayudó o si eligió lo que ya le acomodaba.
- **La memoria y el protocolo 02 ya lo dicen.** El objetivo específico 3 y el protocolo 02 (D-079) piden comparar la señal junto al primer paso con la misma señal en un lugar neutro y con el teléfono. Volver a comparar quita las discrepancias que había abierto D-110.
- **La persona sigue eligiendo lo que le corresponde.** Elige su actividad, su primer paso, el lugar donde empieza, las apps y el objeto (parlante, reloj o llavero). La semana solo decide si lo que suena va donde ella empieza (A), en otro lugar de su casa (B) o en el teléfono (C). Se le dice desde el consentimiento y cada semana, sin ocultarlo.
- **Su preferencia también queda registrada.** El cierre del día 21 pregunta «¿Qué semana te ayudó más?».

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Prueba | La configuración vuelve a pedir una de las seis secuencias. Cada semana fija dónde suena, como en el protocolo 02. |
| Dónde se deja lo que suena | Se quitó la pregunta «¿Dónde dejarás…?»: el objeto va donde la persona escribió que empieza, salvo en la semana B. |
| Elegir el objeto en las semanas A y B | Se corrigió un error de antes: la persona no podía elegir entre el parlante, el reloj y el llavero. Ahora puede elegir cualquiera de los tres, pero no el teléfono. En la semana C suena el teléfono. |
| Nada marcado de antemano | Se mantiene lo de la 2.21: ninguna salida viene marcada por defecto, ni siquiera en las semanas A y B. |
| Notificación de la semana C | Vuelve a ser genérica, como pide el protocolo 02. |
| Un solo verbo | La señal «suena»: «¿Cuándo suena?», «¿Dónde suena?», «Suena después de», «Suena», «¿Cómo te cayó el sonido?». |
| Semanas | Las semanas se llaman «Suena donde empiezas», «Suena en otro lugar» y «Suena en el teléfono». Las instrucciones nombran el parlante, el reloj o el llavero, no solo el parlante. |
| Frases que contradecían la app | El aviso de error ya no ofrece «elige el teléfono» cuando la semana no lo permite. «Suena en el parlante» ya no aparece cuando suena el reloj o el llavero. «¿Supiste qué querías hacer sin mirar el teléfono?» pasa a «…antes de leerlo en la pantalla?», que también sirve en la semana C. |
| Dónde sonará | Inicio y la hoja del primer relevo dicen con qué y dónde sonará: «Sonará en el reloj, en el velador». |
| Ayudas sin repetir | En las semanas de la prueba, las notas de la guía ya no repiten la instrucción de la semana. |
| Consentimiento | Ya no dice «lo usas como quieras»: «cada semana te decimos dónde dejar lo que suena». En «Cómo es» se explican las tres semanas. Versión `2026-10-06-v13`. |
| Panel | Vuelve a la versión por condiciones (la 5) y exige la app 2.22. |

## Lo que se comprobó en el emulador

- **Semana A** (secuencia 1, día 1): apareció la tarjeta «Suena donde empiezas». En «¿Dónde suena?» no había nada marcado y el teléfono aparecía deshabilitado. Se eligió el reloj y el relevo se activó con `study_condition = A` y `signal_route = WATCH`.
- **Semana C** (secuencia 5, día 1): apareció la tarjeta «Suena en el teléfono», con la nota de que no se necesita el parlante, el reloj ni el llavero.
- **Configuración:** las seis secuencias y la descripción de las tres semanas.

Los datos del emulador se devolvieron al terminar.

**APK:** [relevo-android-2.22-2026-10-06.apk](releases/relevo-android-2.22-2026-10-06.apk), SHA-256 `B36443C4FF568A3F97B921168F3FCB150528A0F8B1FB6EBEAD5A0AB297CD60AE` (41,3 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-10-06 — Creación

- **Qué se añadió:** la versión 2.22, que vuelve a comparar las tres semanas y aclara el lenguaje, con la corrección para elegir el objeto en las semanas A y B y el consentimiento v13.
- **Cómo estaba antes:** la 2.20 y la 2.21 dejaban elegir libremente dónde sonaba (D-110), en contra de la memoria, y varios textos se contradecían con lo que hacía la app.
- **Por qué:** pedido del autor (D-112).
