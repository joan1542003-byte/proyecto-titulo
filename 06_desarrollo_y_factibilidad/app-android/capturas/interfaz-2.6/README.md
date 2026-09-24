# Inspección visual de Android 2.6

Capturas de un emulador Android de 1080 × 2400 píxeles. Se usaron Chrome y Calendar como aplicaciones de ejemplo para revisar la selección múltiple; no se activó un ciclo ni se creó una sesión de prueba en la base remota. Las capturas muestran interfaz, no resultados con usuarios ni prueba del parlante físico.

| Captura | Qué permite comprobar |
| --- | --- |
| [Consentimiento](01-consentimiento.png) | Lectura previa, datos y decisión de participar. |
| [Permisos](02-permisos.png) | Diferencia entre Tiempo de uso y notificaciones. |
| [Inicio](03-inicio.png) | Marca, tarjetas reconocibles y navegación inferior. |
| [Selección de dos apps](04-seleccion-dos-apps.png) | Dos aplicaciones marcadas en un único selector. |
| [Límite compartido](05-limite-compartido.png) | Explicación de la suma y control de tiempo. |
| [Salida de sonido](06-salida-de-sonido.png) | Elección explícita entre parlante y teléfono. |
| [Revisión y prueba](07-revision-y-prueba.png) | Resumen editable y prueba de sonido visible antes de activar. |

La inspección permitió corregir dos problemas observables: el deslizador estándar se dibujaba como un trazo vertical y el efecto de desenfoque de la navegación dejaba una franja. La versión vigente usa un control de tiempo propio y una barra estable. El contenido, contraste y áreas táctiles deben verificarse aún en teléfonos reales, con letra ampliada y lector de pantalla.

## Registro de cambios (disclaimer)

- **Qué cambió:** se añadieron capturas de la versión 2.6 y el alcance de su revisión visual.
- **Cómo era antes:** el repositorio solo mostraba capturas de iteraciones anteriores, insuficientes para comprobar esta interfaz.
- **Por qué:** distinguir una inspección en emulador de la validación de uso o audio con personas y dispositivos físicos.
