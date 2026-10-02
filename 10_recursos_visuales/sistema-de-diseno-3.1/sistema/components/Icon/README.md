# Icon

Un ícono del kit de Relevo (135 dibujos propios) en trazo, con el grosor que pide su tamaño.

**Cuándo:** siempre junto a una palabra, salvo en botones redondos con nombre accesible (`label`).

**Qué entrega quien lo usa:**
- `name`: uno de `Icon.names`.
- `size`: 16, 18, 20, 22, 24, 34, 40 o 56 px.
- `strokeWidth`: por omisión sigue al tamaño (16 → 1,9; 20 → 1,8; 24 → 1,75; 32 → 1,6; más → 1,5). Junto a texto en 600 se usa 2,1.
- `color` (hereda `currentColor`), `mono` para pintar también el renglón y `label` si va sin palabra.

**Familias en 3.1:**
- *Interfaz* (102): las de la app, con las 31 redibujadas en D-098.
- *Lugares de la casa* (11): puerta, cama, velador, escritorio, mesa, sillón, estante, cocina, ventana, mochila y canasto. Son los «Dónde» del documento 23 y llevan el renglón como suelo, porque el renglón marca el lugar donde empieza la actividad (Kirsh, 1995).
- *Actividades* (14): las del documento 23 que no tenían ícono, como trotar, tejer, hornear, teclado o pasear al perro.
- *El ciclo, el objeto y los ámbitos* (8): armar y cerrar el ciclo, el testigo en reposo, sonando o con un problema técnico (memoria, capítulo 11), y los tres ámbitos del marco teórico (capítulo 6).

**Retícula:** 24 con área útil de 20, extremos y uniones redondeados; contorno para lo normal y lleno para lo elegido. Los recortes son máscaras.

Escrito a mano desde `ui/components/Icons.kt y KitIcons.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0. Los 33 nuevos se dibujaron para 3.1 con las mismas reglas.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** guía de Icon actualizada a 3.1.
- **Cómo estaba antes:** seguía las reglas de 3.0.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
