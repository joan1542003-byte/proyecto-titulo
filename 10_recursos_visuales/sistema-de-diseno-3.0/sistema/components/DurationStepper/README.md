# DurationStepper

Selector de tiempo con − y +: la cifra cambia con un leve desenfoque y mantener presionado repite el paso.

**Cuándo:** cuánto uso en las apps elegidas antes de que suene (Preparar). Pasos de 1 minuto hasta 10, de 5 hasta 60, de 15 hasta 120 y de 30 después; de 1 minuto a 6 horas.

**Qué entrega quien lo usa:** `seconds`, `onChange` y `label` («Después de este uso en tus apps»).

Escrito a mano desde `ui/components/Controls.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
