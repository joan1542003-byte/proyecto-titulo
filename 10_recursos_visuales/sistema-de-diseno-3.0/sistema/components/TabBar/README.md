# TabBar

Barra de pestañas flotante: una cápsula de vidrio separada de los bordes, con una cápsula más clara que se desliza al destino elegido.

**Qué entrega quien lo usa:** `items` (`label`, `icon` e `iconSelected`), `selected` y `onSelect`. Los destinos de la app son Inicio, Ruta y Perfil.

**3.0:** la pestaña elegida lleva el ícono lleno y su nombre sobre el renglón azul (dónde estás). Ruta cambia de escalera a recorrido con inicio y meta, y Perfil, de credencial a persona.

Escrito a mano desde `ui/components/TabBar.kt` de la app 2.18 (`06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/`), con las reglas de 3.0.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
