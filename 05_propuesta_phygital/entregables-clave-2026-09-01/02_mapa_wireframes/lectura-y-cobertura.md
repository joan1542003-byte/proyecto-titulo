# Lectura del mapa completo de wireframes

## Alcance

El mapa reúne **44 vistas**: nueve momentos de la ruta principal y 35 estados alternativos o excepcionales. La primera secuencia permite evaluar el recorrido completo; la segunda cobertura evita que permisos, fallos técnicos, cancelaciones y recuperaciones aparezcan tardíamente durante el desarrollo.

## Ruta principal

1. Formular la intención.
2. Configurar una condición observable y su vigencia.
3. Revisar antes de situar.
4. Vincular el testigo con el primer paso y el lugar.
5. Probar el pulso físico.
6. Armar mediante un control físico deliberado.
7. Esperar sin medir cumplimiento.
8. Percibir la señal en el entorno.
9. Cerrar o recuperar el ciclo.

El momento 3.2 no debe interpretarse como una pantalla que reproduce el pulso. Representa un acontecimiento externo al teléfono y se conserva en el mapa para mostrar la continuidad entre las dos capas del sistema.

## Familias de cobertura

| Familia | Estados | Pregunta que resuelve |
|---|---:|---|
| Preparar la intención | 01–06 | ¿Qué ocurre si faltan datos, permisos o la persona decide salir? |
| Vincular y situar | 07–14 | ¿Qué ocurre durante la búsqueda, la prueba o una señal inadecuada? |
| Armar | 15–19 | ¿Cómo se confirma, cancela o edita un ciclo ya preparado? |
| Esperar y emitir | 20–24 | ¿Cómo se distingue espera, orden válida, expiración y señal física? |
| Cerrar y recuperar | 25–35 | ¿Cómo se resuelven cambios, fallos técnicos, movimiento, batería o vencimiento? |

## Criterios de baja fidelidad

La imagen prioriza estructura y cobertura. El color se reduce, los marcos comparten escala y cada vista se identifica mediante número y nombre. El mapa no debe utilizarse como especificación estética: su función es comprobar que cada acción tenga respuesta, que exista una salida voluntaria y que los estados físicos y digitales no se confundan.

## Fuente

El contenido se deriva de `05_propuesta_phygital/wireframes-media-html/public/exports/manifest.json`, `05_propuesta_phygital/wireframes-media-html/src/wireframes.ts` y `05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md`.

---

## Registro de cambios (disclaimer)

### 2026-09-01 — Mapa unificado

- **Cambio:** se integraron la ruta evaluable y la cobertura de estados en una sola imagen de gran formato.
- **Situación anterior:** las 44 vistas existían como exportaciones separadas y exigían reconstruir mentalmente su relación.
- **Motivo:** permitir una auditoría panorámica sin perder el detalle de cada estado.
