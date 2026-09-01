# Auditoría parcial — estados Android

## Cobertura

Las ocho pantallas producidas representan estados ya documentados en el Encargo 17 y todavía no desarrollados en la colección anterior:

| Archivo | Estado | Evaluación |
|---|---|---|
| `android-11-permiso-requerido-oscuro-v1.png` | 03 · Permiso requerido | Candidata sólida. Explica la necesidad y permite cambiar la condición. |
| `android-12-permiso-denegado-oscuro-v1.png` | 04 · Permiso denegado | Candidata sólida. Evita rojo y conserva una salida voluntaria. |
| `android-13-salida-voluntaria-oscuro-v1.png` | 06 · Salida voluntaria | Candidata. Las tres acciones se distinguen, pero los puntos dentro de controles deben simplificarse al reconstruir. |
| `android-14-buscando-testigo-oscuro-v1.png` | 07 · Buscando testigo | Candidata sólida. La búsqueda se representa como estado estático, no como progreso. |
| `android-15-testigo-no-reconocido-oscuro-v1.png` | 09 · Testigo no reconocido | Candidata sólida. Comunica un fallo técnico sin atribuir culpa. |
| `android-16-bateria-baja-oscuro-v1.png` | 10 · Batería baja | Candidata con corrección. El icono es comprensible; cualquier acento rojizo accidental debe eliminarse. |
| `android-17-senal-no-percibida-oscuro-v1.png` | 12 · Señal no percibida | Candidata sólida. La pantalla comunica una declaración de la persona y no una detección automática. |
| `android-18-senal-intrusiva-oscuro-v1.png` | 13 · Señal intrusiva | Candidata sólida. Ofrece ajustar, cambiar ubicación o no armar. |

## Hallazgos

La familia se acerca mejor a la referencia seleccionada que las primeras exploraciones: usa menos contenedores, concede mayor importancia a la tipografía y limita los puntos a relaciones informativas. Las pantallas de recuperación funcionan cuando explican qué permanece sin cambios y ofrecen más de una salida.

Los textos generados se consideran microcopias de trabajo. Antes de implementar deben contrastarse con el flujo vigente, tamaños táctiles de 48 × 48 dp, contraste, texto ampliado y lectura mediante TalkBack.

## Registro de cambios

### 2026-09-01 — Primera auditoría

- **Cambio:** se revisaron ocho pantallas complementarias y se identificaron dos correcciones de reconstrucción.
- **Versión anterior:** los archivos aún no tenían una evaluación común.
- **Motivo:** impedir que la generación visual se convierta automáticamente en aprobación.
- **Alcance:** la revisión cubre jerarquía y coherencia; no valida comprensión, accesibilidad ni funcionamiento.
