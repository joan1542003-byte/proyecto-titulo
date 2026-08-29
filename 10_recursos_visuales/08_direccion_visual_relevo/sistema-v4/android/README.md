# Android v4

## Propósito

Este directorio indexa las referencias visuales del flujo Android de Relevo. Las imágenes son material de dirección y reconstrucción: no sustituyen el wireframe, el prototipo funcional ni las pruebas de interacción.

La aplicación organiza una intención, un primer paso, una condición, una vigencia, un lugar y un testigo. El testigo emite la señal situada en el lugar elegido. La aplicación informa, confirma y ofrece recuperación; no registra si la persona comenzó la actividad ni convierte la señal en una evaluación.

## Estado de la dirección

El modo oscuro es la única dirección vigente para nuevas pantallas. Las tres piezas iniciales conservadas en este directorio son exploraciones históricas:

- 01-inicio-ciclo-activo-claro-v1.png
- 02-configurar-intencion-claro-v1.png
- 03-senal-situada-oscuro-v1.png

No deben utilizarse como referencia de implementación. Las imágenes oscuras y sus estados detallados están documentados en oscuro/README.md.

## Índice de pantallas

| Orden | Función | Referencia actual | Estado | Ajuste antes de reconstruir |
|---|---|---|---|---|
| 01 | Inicio sin ciclo | oscuro/01-inicio-sin-ciclo-oscuro-v1.png | Vigente; candidata principal | Sustituir texto raster por texto real y validar el estado vacío |
| 02 | Formular intención | oscuro/02-formular-intencion-oscuro-v2.png | Aprobada como dirección | Reconstrucción manual de campos, foco y validación |
| 03 | Configurar condición | oscuro/03-condicion-provisional-oscuro-v2.png | Candidata | Resolver el retorno duplicado y validar elecciones |
| 04 | Revisar ciclo | oscuro/04-revisar-ciclo-oscuro-v2.png | Aprobada como dirección | Reconstruir filas, reglas y jerarquía de acciones |
| 05 | Vincular testigo | oscuro/05-vincular-testigo-oscuro-v2.png | Candidata | Normalizar alineación y jerarquía de la acción principal |
| 06 | Probar señal | oscuro/06-probar-pulso-oscuro-v2.png | Aprobada como dirección | Validar emisión de prueba y declaración posterior |
| 07 | Ciclo activo en espera | oscuro/07-ciclo-activo-espera-oscuro-v2.png | Aprobada como dirección | Reemplazar copy heredado y validar desarme |
| 08 | Señal situada | oscuro/08-senal-situada-oscuro-v2.png | Aprobada; mejor referencia de esta etapa | Reconstruir gráfico con texto equivalente y un único nodo rojo |
| 09 | Recuperar vínculo | oscuro/09-fallo-vinculo-oscuro-v2.png | Candidata | Reducir la repetición del estado y normalizar la acción |
| 10 | Ciclo cerrado | oscuro/10-ciclo-cerrado-oscuro-v2.png | Aprobada como dirección | Reconstruir cierre, salida y preparación explícita de otro ciclo |

Se revisaron visualmente los 19 PNG de android/oscuro. Las versiones v1 de 02 a 10 son históricas, superadas o rechazadas; cuando existe v2, ninguna v1 funciona como referencia de implementación. La tabla completa de descarte y las fichas de las versiones vigentes o candidatas están en oscuro/README.md.

## Documentación relacionada

- oscuro/README.md: auditoría individual, riesgos, prompts y reconstrucción necesaria.
- inventario-pantallas-oscuras.md: cobertura de interacciones y estados.
- ../manual-sistema-visual-relevo.md: reglas generales del sistema.
- ../tokens-y-especificaciones.md: valores técnicos y estados de madurez.
- ../componentes-y-semantica.md: contrato entre contenido, icono, elección, acción, estado, gráfico y decoración.

## Reglas que gobiernan estas pantallas

- Canvas #111314; superficie funcional #1B1D1E; texto principal #F1F1F1; texto secundario #B6B8B7; reglas #3A3D3E.
- IBM Plex Sans para lectura, instrucciones y acciones; IBM Plex Mono para metadatos breves.
- El rojo #EF3E45 se reserva al nodo de señal situada. No representa acción, error, batería, vínculo ni selección.
- Los puntos solo pueden aparecer como marca, señal expresiva breve o gráfico informativo acompañado de texto equivalente.
- Una elección debe mostrar sus límites y estados; una acción debe expresar qué ejecuta; un estado no debe parecer pulsable.
- El testigo emite la señal situada; la aplicación comunica la configuración y el estado de esa relación.
- No se incorporan métricas, rachas, premios, culpa, evaluación, moralización ni rearme automático.

## Registro de cambios (disclaimer)

### 2026-08-29 — Corrección del índice Android v4

- Qué se modificó: se reemplazó el índice anterior por una tabla de estado para las diez pantallas, con enlaces a la dirección oscura, documentos operativos y estados diferenciados para cada versión.
- Cómo estaba antes: el README trataba varias v1 como referencias aprobadas y mezclaba exploraciones claras, imágenes históricas y dirección vigente sin una jerarquía única.
- Qué se conservó: los archivos PNG y las tres exploraciones iniciales; se mantienen como registro del proceso, no como guía de implementación.
- Por qué: al existir v2 para las pantallas 02–10, las v1 deben leerse como antecedentes. La nueva clasificación evita que una exploración superada, en particular la silueta industrial de 05 v1, se interprete como decisión cerrada.
- Corrección de lenguaje: se eliminó la descripción del testigo por ausencia y se explicitó su función: emite la señal situada en el lugar elegido.
- Alcance: esta actualización no modifica imágenes, wireframes, memoria, inventario ni decisiones técnicas del testigo. Tampoco cierra su forma industrial.
