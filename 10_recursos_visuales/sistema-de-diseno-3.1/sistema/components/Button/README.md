# Button

El botón en cápsula: 56 px de alto y ancho completo, o compacto dentro de una tarjeta.

**Cuándo:** `primary` (tinta) para la acción principal, una por pantalla y abajo, al alcance del pulgar. `secondary` (niebla) para la alternativa. `destructive` solo para borrar o eliminar, siempre con confirmación.

**Qué entrega quien lo usa:**
- la etiqueta como `children`: un verbo, sin punto final («Seguir», «Probar el sonido», «Eliminar este relevo»);
- `kind`, `compact`, `icon` (nombre de Icon) y `onClick`;
- `disabled` solo si no hay nada que explicar; si falta algo, usar GuardedButton.

**Comportamiento:** al presionar se hunde a 97 % (95 % el compacto) y el relleno pasa a `slate`, `line` o `error` al 15 %. Sin ondas ni rebotes.

**No:** botones azules (el azul es el renglón y el tiempo) ni más de una acción principal por pantalla.

Escrito a mano desde `ui/components/Controls.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** se copia a la carpeta 3.1 sin cambios de contenido.
- **Cómo estaba antes:** solo estaba en la carpeta 3.0.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
