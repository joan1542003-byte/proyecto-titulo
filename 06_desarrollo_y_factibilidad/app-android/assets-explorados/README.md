# Actividades visuales exploradas para Android 2.6

Las tarjetas de actividad usan imágenes como apoyo al reconocimiento; el nombre escrito es siempre la información principal. Este registro permite reconstruir por qué se añadieron dos opciones y por qué una tercera quedó fuera de la interfaz. No son fotografías de participantes ni pruebas del objeto físico.

| Actividad | Archivo | Relación con la investigación | Decisión |
| --- | --- | --- | --- |
| Pasear al perro | [`activity_dog_walk.png`](fotos-app-hasta-2.7/activity_dog_walk.png) | P1 relata el valor del tiempo con sus perros y P4 menciona los paseos con el suyo ([corpus](../../../03_usuarios/corpus-anonimizado.md)). | Incorporada como acceso opcional. La imagen muestra una correa junto a calzado, sin representar a una persona. |
| Manualidades | [`activity_crafts.png`](fotos-app-hasta-2.7/activity_crafts.png) | P2 menciona manualidades, pintura y dibujo como actividades que desea retomar ([corpus](../../../03_usuarios/corpus-anonimizado.md)). | Incorporada como acceso opcional. El material en la imagen ayuda a reconocer la acción sin definir un oficio particular. |
| Descansar | [`descansar-no-incorporado.png`](descansar-no-incorporado.png) | El descanso aparece en el corpus, pero una señal sonora cerca del dormitorio podría ser inoportuna. P6 plantea reservas sobre el sonido. | Imagen conservada como exploración; no se añadió una tarjeta. Antes de hacerlo habría que decidir si el aviso es pertinente y qué control tendría la persona. |

## Dirección de imagen y registro del encargo visual

Los encargos de generación se resumieron en tres decisiones verificables: objetos cotidianos vinculados a la acción; composición cuadrada y despejada para una tarjeta con rótulo superpuesto; fotografía realista sobre fondo claro, iluminación suave, sin rostro, letras, logos ni dispositivos. Para el paseo se solicitaron correa y elementos de salida; para manualidades, materiales sobre mesa; para descanso, objetos de una situación tranquila. El tratamiento no se usa para atribuir resultados a las entrevistas: las entrevistas sustentan las actividades, no las fotografías concretas.

Los PNG incorporados se inspeccionaron visualmente y permanecen como recursos reemplazables. Su función debe contrastarse con usuarios: si una imagen se confunde, distrae o sugiere una actividad distinta, el texto y la elección de la persona prevalecen.

## Fotografías de la app desde 2.8

La versión 2.8 dejó de usar estos PNG directamente. Los originales pasaron a [`fotos-app-hasta-2.7`](fotos-app-hasta-2.7) y la app usa copias en JPEG recortadas y tratadas con la receta de imagen de D-073 ([`receta-imagen.py`](../../../10_recursos_visuales/marca-desde-cero/receta-imagen.py), reproducida en C#): encuadre 4:5 a 720 px o 3:2 a 1080 px, saturación −16 %, sombras levantadas y frías, altas luces tibias, grano de 2 % y calidad 86. `onboarding_signal.png` y `relevo_tutorial.png` no se usan en 2.8.

| Original | En la app (`drawable-nodpi`) |
| --- | --- |
| `activity_walk.png` | `foto_caminar.jpg` |
| `activity_train.png` | `foto_ejercicio.jpg` |
| `activity_tidy.png` | `foto_ordenar.jpg` |
| `activity_dog_walk.png` | `foto_perro.jpg` |
| `activity_crafts.png` | `foto_manualidades.jpg` |
| `activity_cook.png` | `foto_cocinar.jpg` |
| `activity_read.png` | `foto_leer.jpg` |
| `activity_study.png` | `foto_estudiar.jpg` |
| `activity_draw.png` | `foto_dibujar.jpg` |
| `onboarding_place.png` | `foto_puerta.jpg` y `foto_puerta_ancha.jpg` |
| `onboarding_activity.png` | `foto_salida.jpg` y `foto_salida_ancha.jpg` |
| `onboarding_condition.png` | `foto_tiempo.jpg` y `foto_tiempo_ancha.jpg` |

Las otras seis fotografías de la app son CC0 y están registradas en [licencias](../licencias/README.md). Todas son provisionales: D-073 pide una sesión propia en hogares reales, con consentimiento.

## Registro de cambios (disclaimer)

### 2026-09-26 — Fotografías de la 2.8

- **Qué cambió:** se añadió qué original corresponde a cada foto de la 2.8 y cómo se trató; los enlaces de la tabla apuntan a `fotos-app-hasta-2.7`.
- **Cómo estaba antes:** los enlaces llevaban a `drawable-nodpi`, de donde la 2.8 retiró los PNG, y no se decía qué foto de la app salía de cada original.
- **Por qué:** mantener rastreable la procedencia de las imágenes después del cambio de formato y de carpeta.

### Android 2.6 — Registro inicial

- **Qué cambió:** se documentaron dos recursos incorporados y uno descartado, con su vínculo al corpus y una síntesis de los encargos visuales utilizados.
- **Cómo era antes:** las imágenes nuevas no tenían un registro que explicara su procedencia, uso o rechazo.
- **Por qué:** hacer rastreables las decisiones visuales y evitar que una imagen exploratoria se confunda con evidencia de validación.
