# Android 2.30: editar un relevo sin borrarlo

**Fecha:** 9 de octubre de 2026. **Decisión:** D-120. **Estado:** compilada desde cero en su versión optimizada, con 85 pruebas unitarias aprobadas. Revisada en el emulador: activar un relevo, editarlo desde la pantalla del relevo, cambiar un dato y guardarlo. **No se verificó** que siga con el tiempo contado, porque en el emulador el conteo quedó en 0 s. El consentimiento no cambia (v13).

## El comentario

Llegó como comentario sobre la app: «podrían implementar que se pueda actualizar o editar las opciones que uno ya eligió antes de iniciar el plan de relevo, así no tenemos que borrarlo y crearlo de nuevo si hubo alguna equivocación».

## Qué cambia

| Parte | Cambio |
| --- | --- |
| «Todo listo», antes de activar | Suma la fila «Qué quieres hacer»: antes la actividad no se podía cambiar desde ahí. Al tocar cualquier dato y cambiarlo, el botón dice «Listo» y vuelve a «Todo listo», sin recorrer los pasos siguientes. El texto de ayuda dice «Toca cualquier dato para cambiarlo». |
| Relevo activo | «Editar este relevo», y también tocar cualquiera de sus datos, pregunta «¿Editar el relevo?». Al aceptar, abre «Todo listo» con el aviso «Estás editando tu relevo» y el botón «Guardar y activar». |
| Tiempo contado | Mientras se edita no cuenta. Al guardar, si cuenta las mismas apps, sigue con el tiempo que llevaba; si cambiaron las apps, empieza de cero. |
| Inicio | La fila del relevo activo dice «Ver, editar o desactivar». |
| Registro | El relevo anterior queda como `deleted`, con el evento `relevo_editado`; al guardar empieza una sesión nueva. El panel lo muestra como «Editó un relevo activo». |

**Límite:** si Android cierra la app justo mientras se edita, se pierde el tiempo que llevaba y el botón vuelve a decir «Activar el relevo».

**APK:** [relevo-android-2.30-2026-10-09.apk](releases/relevo-android-2.30-2026-10-09.apk), SHA-256 `A86FFEE9CC8376204B778D75C4B6694793B99ADEC64C522428468DC83AA9710D` (12,1 MB), versión optimizada, firmada con la misma clave de las anteriores.

## Registro de cambios (disclaimer)

### 2026-10-09 — Creación

- **Qué se añadió:** la versión 2.30: editar lo elegido antes y después de activar, sin borrar el relevo.
- **Cómo estaba antes:** en «Todo listo» la actividad no tenía fila y cambiar un dato obligaba a recorrer los pasos siguientes; un relevo activo solo se podía desactivar o eliminar.
- **Por qué:** comentario de una persona que usó la app (D-120).
