# Avatar

La imagen de la persona: el emoji que eligió, en un círculo. Sin emoji, la inicial de su nombre o el ícono de perfil.

**Qué entrega quien lo usa:** `size`, `name` y, si eligió uno, `src` (el PNG del emoji Noto 3D de la app) o `emoji` (el carácter, solo en maquetas web). `label` para el lector de pantalla.

**Nota:** la app usa los emoji Noto 3D de Google (OFL) como imagen; aquí el carácter es un sustituto para maquetas.

Escrito a mano desde `ui/components/Photos.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
