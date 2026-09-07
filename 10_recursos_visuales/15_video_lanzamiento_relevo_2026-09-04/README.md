# Video de lanzamiento de Relevo — 4 de septiembre de 2026

Esta carpeta contiene una pieza audiovisual promocional de 51 segundos que explica Relevo desde una situación cotidiana hasta su funcionamiento phygital y su principio de autonomía.

## Entregables

- `relevo-video-lanzamiento-4k.mp4`: video maestro 3840 × 2160 px, 30 fps, H.264, audio AAC y subtítulos en español.
- `voz-relevo.mp3`: locución en español de Chile.
- `voz-relevo.vtt`: subtítulos y transcripción temporizada.
- `guion-y-storyboard.md`: relato, tiempos, decisiones y procedencia.
- `render_video.py`: fuente reproducible del montaje y de sus diez láminas 4K.
- `frames/`: láminas maestras utilizadas por el montaje.
- `assets/`: imágenes de apoyo y copias locales de las tipografías utilizadas. Las licencias oficiales se conservan en [`../10_tipografias`](../10_tipografias/README.md).

## Concepto

La narración sigue el orden definido por la guía de comunicación:

> situación → tensión → propuesta → funcionamiento → autonomía → estado

El video no presenta el ocio digital como un problema universal. Explica un episodio específico en el que una intención elegida deja de orientar el siguiente paso. La aplicación organiza, la señal se sitúa cerca del comienzo y la persona decide.

## Reproducción técnica

El montaje se genera mediante Python, Pillow y ffmpeg. El script puede ejecutarse con:

```powershell
python render_video.py --ffmpeg C:\ruta\a\ffmpeg.exe
```

El render vuelve a construir las diez láminas antes de codificar. La voz y los subtítulos se mantienen como archivos fuente para facilitar futuras revisiones de ritmo o contenido.

La pieza utiliza los códigos vigentes del sistema: grafito `#111314`, blanco `#F1F1F1`, gris secundario `#B6B8B7` y rojo de señal `#D71921`. El rojo se reserva para la aparición o confirmación de una señal relevante.

## Límites

- La forma física mostrada es exploratoria y no representa un diseño industrial validado.
- La condición de activación, el canal final de señal y el aporte frente a una notificación continúan abiertos.
- Las escenas generadas son ilustraciones sintéticas, no registros de participantes.
- El titular `Que una intención vuelva a tener lugar` continúa pendiente de prueba de comprensión.

---

## Registro de cambios (disclaimer)

### 2026-09-04 — Creación del video promocional

- **Qué cambió:** se integraron guion, locución, imágenes, tipografía, movimiento, sonido y subtítulos en una pieza audiovisual 4K.
- **Cómo estaba antes:** existían recursos independientes y una guía de comunicación, pero no un video explicativo de lanzamiento.
- **Por qué se decidió:** disponer de una presentación breve que explique Relevo sin depender de una exposición oral adicional.
- **Alcance:** pieza promocional sintética; no demuestra validación del producto ni cierra su forma física.

### 2026-09-07 — Compatibilidad y coherencia cromática

- **Qué cambió:** se ajustaron los cuatro colores del montaje al sistema vigente y se corrigió la frecuencia mínima admitida por ffmpeg 8.1 para reconstruir la pista sonora.
- **Cómo estaba antes:** el montaje utilizaba aproximaciones cromáticas y dos frecuencias de trémolo inferiores al mínimo aceptado por la versión instalada de ffmpeg.
- **Por qué se decidió:** asegurar que la fuente sea reproducible y que el video no introduzca una paleta paralela.
- **Alcance:** no cambia el guion, la duración, la estructura narrativa ni las afirmaciones del video.
