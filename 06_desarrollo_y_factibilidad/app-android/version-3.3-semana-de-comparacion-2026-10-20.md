# Android 3.3: la línea nueva con la semana para comparar

**Fecha:** 20 de octubre de 2026. **Decisión:** D-138. **APK:** [relevo-android-3.3-2026-10-20.apk](releases/relevo-android-3.3-2026-10-20.apk), versión optimizada de 12,8 MB. **SHA-256:** `32261D0F28FDF184A7B3009F6B10D07E0E18886EDF02E8008AAFF9A567E225A8`. **versionCode:** 49. **Firma:** la misma de todas las versiones (`fdbe6bbe…`).

La 3.3 es la 3.2 con todo lo que la línea 2.x sumó para el testeo desde el 12 de octubre. El consentimiento sigue en v13 y los datos guardados no cambian.

## Qué trae respecto de la 3.2

| Origen | Cambio |
| --- | --- |
| [2.31](version-2.31-el-tag-se-calla-2026-10-14.md) (D-136) | El Tag se calla con confirmación, y la app muestra y registra la carga de su pila. |
| [2.32](version-2.32-el-tag-no-se-corta-2026-10-17.md) (D-137) | La app nunca corta la conexión con la alarma del Tag encendida y espera más a un Tag lento. |
| [2.33](version-2.33-semana-de-comparacion-2026-10-20.md) (D-138) | Una semana para comparar, con preguntas antes de la semana, tras cada relevo, el día 7 y al cierre. |
| Textos del 20 de octubre | «Armar mi ruta» pasa a «Listo», y «¿Dónde suena?» dice la salida elegida en vez de nombrar siempre el Tag. |

Los cambios de la 2.33 se llevaron con el mismo código. Solo cambia una cosa en la interfaz: en la 3.x, las preguntas tras la señal van en una pantalla propia. Su título pasa de «Tres preguntas de un toque» a «Cuatro preguntas de un toque», y la primera es «¿Notaste el aviso apenas sonó?».

## Verificación

- **Compilación y pruebas:** compilación limpia, con 87 pruebas unitarias aprobadas.
- **Emulador:** la 3.3 se instaló sin conexión sobre los datos del autor. Se recorrió con la fecha adelantada 6 días:
  - Perfil › pantalla del investigador › «Una semana para comparar» › «Semana C» › «Empezar la semana hoy».
  - En Inicio, la instrucción de la semana C, con el aviso para apagar el Tag, y «Antes de esta semana».
  - Un relevo de 15 segundos sonó en el teléfono con la notificación «Es momento de volver a elegir».
  - Aparecieron las cuatro preguntas tras la señal.
  - El día 7, la tarjeta de la semana mostró la comparación y después el cierre de siete preguntas.
  - Se guardaron las claves `semanas_previas_costo_preparar`, `percepcion_senal`, `semana1_comparacion`, `cierre_seguiria_usando`, `cierre_semana_que_ayudo` y `cierre_prefiere_que_suene`.
  - Al final se restauraron los datos del autor (MD5 idénticos), la fecha y la conexión. Queda instalada la 3.3 de depuración.
- **No probado:** en un teléfono real ni con el Tag.

## Uso

La prueba en curso sigue con la 2.33, para no cambiar la interfaz a mitad de la prueba. La 3.3 es la base de la línea nueva. La próxima versión debe usar `versionCode` 50 o más.

## Registro de cambios (disclaimer)

### 2026-10-20 — Creación

- **Qué se añadió:** la versión 3.3, con los cambios de la 2.31, la 2.32 y la 2.33 sobre la interfaz de la 3.2.
- **Cómo estaba antes:** esos cambios solo estaban en la línea 2.x. La 3.2 publicada no los tenía.
- **Por qué:** quedaba pendiente llevar la semana para comparar a la línea 3.x (D-138). El autor pidió continuar.
