# Prompts y producción

## Referencias utilizadas

Las generaciones utilizaron como referencias visuales las cuatro imágenes entregadas por el autor el 31 de agosto de 2026. Se tomaron de ellas jerarquía, relación claro–oscuro, retícula editorial, matriz de puntos, tipografía continua y reserva del rojo. No se solicitó reproducir una marca, interfaz o composición de terceros.

## Estructura común de los prompts

Cada instrucción indicó: uso de la pieza, soporte, relación semántica, composición, paleta, tipografía, contenido permitido, restricciones y errores que debían evitarse. Todas las generaciones pidieron una sola pieza independiente.

## Registro de generaciones

| Archivo | Solicitud central | Restricciones principales |
|---|---|---|
| `01_android/android-formular-intencion-oscuro-v1.png` | Formular intención y primer paso en Android oscuro. | Sin rojo, sin marco de teléfono, sin métricas, una acción principal. |
| `01_android/android-revisar-ciclo-claro-exploratorio-v1.png` | Revisar intención, primer paso, condición y vigencia en claro. | Sin rojo, filas legibles, tema claro comparativo. |
| `02_editorial/editorial-estado-del-arte-claro-v1.png` | Doble página con tabla comparativa y gráfico de relación. | APA 7, texto mínimo, rojo solo en señal, sin citas inventadas. |
| `02_editorial/editorial-viaje-usuario-oscuro-v1.png` | Viaje de usuario horizontal para presentación. | Sin progreso, sin métricas, señal roja solo al final. |
| `03_carteles/cartel-transferencia-situada-claro-v1.png` | Cartel vertical de origen, transferencia y señal. | Texto español exacto, sin objeto ni interfaz. |
| `99_descartados/cartel-transferencia-situada-oscuro-rechazado-v1.png` | Contraparte oscura del cartel. | El resultado incumplió la reserva del rojo y fue descartado. |
| `04_modulos_transparentes/modulo-transferencia-grafito-transparente-v1.png` | Campo grafito que se reduce hasta un nodo situado. | Alfa real, sin texto, sin progreso ni botón. |
| `04_modulos_transparentes/modulo-transferencia-blanco-transparente-exploratorio-v1.png` | Contraparte blanca para fondos oscuros. | Alfa real, sin canvas, sin brillo. |
| `04_modulos_transparentes/simbolo-senal-orbita-abierta-exploratorio-v1.png` | Señal central con anillos abiertos. | Sin selector, objetivo, carga ni botón. |
| `04_modulos_transparentes/simbolo-vinculo-neutral-transparente-v1.png` | Conector neutral sin dirección. | Sin rojo, flechas, control deslizante ni progreso. |
| `05_fondos/fondo-campo-transferencia-claro-v1.png` | Fondo editorial claro con campo lateral y espacio negativo. | Sin texto, objeto, interfaz ni flechas. |
| `05_fondos/fondo-campo-transferencia-oscuro-v1.png` | Contraparte oscura para presentación. | Sin brillo, gradiente ni efecto de partículas luminosas. |

## Producción y límites

El generador integrado produjo resoluciones entre 852 × 1846 px y 1774 × 887 px, según la proporción solicitada. Solicitar 4K orientó la composición, pero no produjo archivos 4K nativos. Por ello, estas imágenes son objetivos visuales y recursos de exploración; no se deben presentar como artes finales 4K.

Los cuatro archivos solicitados con transparencia tienen canal alfa y esquinas con alfa 0. Dos de ellos requieren limpieza visual antes de uso. Los textos generados deben sustituirse durante la reconstrucción, incluso cuando parecen correctos.

## Registro de cambios

### 2026-08-31 — Creación del registro de producción

- **Cambio:** se registraron las doce generaciones, sus objetivos y restricciones.
- **Versión anterior:** las imágenes tenían nombres descriptivos, pero no una relación explícita con las instrucciones que las originaron.
- **Motivo:** permitir repetición, corrección y auditoría del proceso.
- **Alcance:** los resúmenes conservan la intención del prompt; los archivos rasterizados siguen siendo exploraciones.
