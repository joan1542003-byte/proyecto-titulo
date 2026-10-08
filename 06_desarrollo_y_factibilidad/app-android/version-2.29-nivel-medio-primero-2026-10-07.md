# Android 2.29: la prueba del Tag empieza por la forma que pita

**Fecha:** 7 de octubre de 2026. **Decisión:** D-119. **Estado:** compilada desde cero en su versión optimizada, con 85 pruebas unitarias aprobadas. No se ha probado en un teléfono real. El consentimiento no cambia (v13).

## Qué pasó

Con la 2.28, el autor probó el Tag dos veces seguidas: el primer intento no pitó y, tras responder «No pitó», el segundo sí. Según el registro, el primer intento usó el nivel de alerta alto (2) y el segundo, el medio (1). Con el alto no pitó en ninguna de las dos pruebas.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| Orden de la prueba | Primero el nivel medio (1) y después el alto (2). Antes era al revés. |
| Nivel por defecto | Un Tag recién elegido pita con el nivel medio. El que la persona ya confirmó se mantiene. |
| Prueba sin confirmar | Si la persona nunca confirmó que lo escuchó, la prueba empieza por el primer nivel, aunque haya quedado guardado otro. |

**APK:** [relevo-android-2.29-2026-10-07.apk](releases/relevo-android-2.29-2026-10-07.apk), SHA-256 `8F2E3BBA10AEF324D5338896B5D42BF57FC24DF47CB3B9D4F428E10C9BD558C9` (12,1 MB), versión optimizada, firmada con la misma clave de las anteriores.

## Registro de cambios (disclaimer)

### 2026-10-07 — Creación

- **Qué se añadió:** la versión 2.29: la prueba del Tag empieza por el nivel medio, el que pitó en el Tag del autor.
- **Cómo estaba antes:** la 2.28 empezaba por el nivel alto, que no pitaba, y el segundo intento usaba el medio.
- **Por qué:** pedido del autor (D-119).
