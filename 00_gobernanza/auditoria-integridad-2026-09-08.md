# Auditoría de integridad del repositorio — 8 de septiembre de 2026

**Registro iniciado:** 8 de septiembre de 2026. Incluye adiciones posteriores identificadas en el historial.

**Vigencia:** antecedente de controles realizados entonces. El estado posterior se consulta en la [revisión textual del 9 de septiembre](auditoria-textual-2026-09-09.md); sus cifras no son un conteo permanente del repositorio.

## Objetivo

Comprobar que la documentación vigente sea localizable, coherente y reproducible; corregir desactualizaciones verificables; y separar los errores del repositorio de los pendientes reales del proyecto.

## Resultado ejecutivo

En el corte de esta auditoría se registraron una fuente académica identificada, una definición común de Relevo, enlaces internos funcionales y entregables visuales con fuentes de reproducción. Se corrigieron desajustes de estado, alcance, color, paginación y ejecución técnica. No se encontraron enlaces locales rotos, archivos JSON inválidos ni exportaciones PNG dañadas.

El proyecto no está terminado en términos empíricos o productivos. El programa de banco para micro:bit compila, pero permanecen pendientes el acceso a la placa, la instalación, la comprobación BLE, la salida cálida de fase A, la integración electrónica portátil, la construcción del prototipo Android, la encuesta complementaria y las pruebas con participantes. Estos asuntos no son fallas documentales: son trabajo futuro visible y ordenado.

## Definición común comprobada

Relevo es un sistema phygital que busca recuperar una intención personal cuando una sesión de ocio digital continúa y esa alternativa deja de orientar el siguiente paso. Una aplicación Android conserva la intención, su primer paso y la configuración del ciclo. Un testigo situado cerca de ese primer paso emite una señal breve cuando se cumple una condición todavía por validar. La persona puede actuar, continuar, silenciar o cambiar de idea.

El alcance excluye bloqueo, puntajes, rachas, evaluación de cumplimiento e inferencias sobre estados internos. El hogar es el primer contexto de prueba, no una conclusión generalizable. La dimensión física debe demostrar un aporte frente a una notificación; no se justifica solo por la forma del producto.

## Correcciones realizadas

| Área | Problema encontrado | Corrección |
| --- | --- | --- |
| Estado del proyecto | El README y las instrucciones aún afirmaban que la etapa no exigía visualidad. | Se registró que existe una dirección visual vigente y se mantuvo su carácter subordinado a investigación y pruebas. |
| Sistema visual | El índice declaraba una paleta vigente y luego presentaba la paleta histórica como si también lo fuera. | Se separaron el sistema actual y la exploración histórica, con códigos, tipografías y reglas de uso explícitas. |
| Alcance de desarrollo | Los nueve marcos y 35 estados no indicaban qué debía construirse primero. | Se definieron el recorrido imprescindible, ocho recuperaciones críticas, exclusiones y backlog. |
| Wireframes | El checklist de cobertura permanecía vacío pese a que la entrega estaba implementada. | Se comprobó el tablero y se registró el cierre de los 16 criterios, sin confundirlo con validación. |
| Runtime móvil | La capa decorativa del teléfono interceptaba entradas y dos gestos no podían comprobarse de forma fiable. | Se restauraron los estilos compartidos, se volvió no interactivo el marco decorativo, se acotó el diálogo al dispositivo simulado y se corrigió el gesto de cierre del teclado. |
| Automatización web | Los scripts previos al desarrollo y compilación dependían de que `npm` estuviera disponible aunque el proyecto usa `pnpm`. | Se invocó directamente el control de integridad con Node para mantener compatibilidad entre gestores. |
| Maqueta editorial | La fuente generaba 86 páginas, pero la carpeta pública contenía 70 PNG y una advertencia antigua. | Se reconstruyeron HTML, manifiesto y 87 exportaciones desde la misma fuente después de corregir las rutas técnicas. |
| Video 4K | El archivo maestro faltaba, dos parámetros de audio no eran compatibles con ffmpeg 8.1 y la paleta no coincidía con el sistema vigente. | Se registró la reconstrucción del video con audio y subtítulos. La revisión del 9 de septiembre corrige el alcance cromático: la fuente conserva la paleta de esa pieza, no el ámbar actual. |
| Arquitectura técnica | Un documento podía hacer pensar que Bluetooth y el procesamiento local ya estaban integrados. | Se rotularon como arquitectura objetivo pendiente de construcción y comprobación. |
| Banco micro:bit | La plataforma seleccionada no tenía una implementación ejecutable y su matriz roja contradecía la luz cálida del protocolo. | Se añadió código compilable, un archivo instalable y una secuencia en dos niveles: matriz roja solo para banco; luz cálida externa antes de involucrar participantes. |
| Cierre de wireframes | Las vistas estaban verificadas, pero no existía una línea base formal y el tablero conservaba el rojo de la etapa anterior. | Se adoptó el ámbar vigente, se regeneraron 44 vistas y tres mapas, y se congeló el wireframe v1 con criterios y límites explícitos. |

## Verificaciones ejecutadas

| Control | Resultado |
| --- | --- |
| Enlaces locales en Markdown | 348 archivos y 1.036 referencias locales comprobadas; 0 rotas. |
| Archivos JSON | 14 archivos comprobados; 0 inválidos fuera de dependencias. |
| Wireframes | Compilación correcta; 44 exportaciones; 9 marcos principales y 35 estados; 824 × 1830 px; navegación correcta; sin simulación de teléfono, desborde ni errores de consola. |
| Trabajador de publicación web | 4 pruebas aprobadas. |
| Runtime móvil | 8 pruebas aprobadas: carrusel, desplazamiento, activación, lámina inferior, teclado, Android y navegación apilada. |
| Maqueta editorial | 87 PNG válidos y manifiesto sincronizado al 8 de septiembre. |
| Integridad de archivos | 743 PNG y 5 contenedores ZIP/DOCX/PPTX/XLSX comprobados; 0 firmas, dimensiones o contenedores inválidos; 0 colisiones de rutas por mayúsculas. |
| Video explicativo | H.264, 3840 × 2160 px, 30 fps, 51,1 segundos, audio AAC y subtítulos en español. |
| Programa micro:bit | Compilación MakeCode correcta; fuente, parámetros, montaje, uso y límites documentados; archivo HEX disponible. No se comprobó en hardware. |
| Diferencias de Git | Sin errores de espacios o marcas de conflicto después de las correcciones. |

## Fuentes que gobiernan cada área

| Pregunta | Fuente vigente |
| --- | --- |
| ¿Qué es Relevo y en qué estado está? | [`README.md`](../README.md) y [`resumen-vigente-proyecto.md`](../08_memoria/resumen-vigente-proyecto.md) |
| ¿Cómo debe explicarse? | [`guia-comunicacion-relevo.md`](guia-comunicacion-relevo.md) |
| ¿Cuál es la memoria activa? | [`memoria-vigente-v4.md`](../08_memoria/memoria-vigente-v4.md) |
| ¿Qué se construye primero? | [`alcance-primer-prototipo-y-backlog-2026-09-07.md`](../05_propuesta_phygital/alcance-primer-prototipo-y-backlog-2026-09-07.md) |
| ¿Qué wireframes están vigentes? | [`wireframes-media-html`](../05_propuesta_phygital/wireframes-media-html/README.md) |
| ¿Qué sistema visual está activo? | [`10_recursos_visuales/README.md`](../10_recursos_visuales/README.md) y [comunicación, nombre y color](../10_recursos_visuales/comunicacion-naming-y-paleta-2026-09-07.md) |
| ¿Qué impide probar con personas? | [`07_validacion/README.md`](../07_validacion/README.md) y las Issues [#8](https://github.com/joan1542003-byte/proyecto-titulo/issues/8), [#11](https://github.com/joan1542003-byte/proyecto-titulo/issues/11) y [#10](https://github.com/joan1542003-byte/proyecto-titulo/issues/10) |
| ¿Cuáles son las fechas de cierre? | [`plan-de-cierre-agosto-diciembre-2026.md`](plan-de-cierre-agosto-diciembre-2026.md) |

## Pendientes reales y orden inmediato

1. Conseguir acceso a una micro:bit V2, instalar el programa y ejecutar el banco BLE sin participantes.
2. Incorporar una luz blanca cálida externa, revisar el montaje y completar la ficha técnica de fase A.
3. Construir la navegación Android mínima desde el wireframe v1 y probar internamente app, luz, sonido y silencio local.
4. Completar contacto y revisión académica del consentimiento antes de reclutar.
5. Ejecutar la prueba de asociación y, después, la comparación con una notificación.
6. Integrar resultados reales en la memoria, factibilidad y decisiones.

La encuesta de 70 participantes permanece como fuente pendiente. No debe utilizarse hasta documentar sus materiales, procedencia, consentimiento, anonimización y análisis.

## Criterio para futuras revisiones

Una auditoría documental puede comprobar coherencia, trazabilidad y funcionamiento de los entregables. No puede declarar que Relevo funciona para usuarios ni cerrar decisiones que dependen de prototipos. Cualquier avance posterior debe actualizar, como mínimo, el README del área, el resumen vigente, el plan si cambia una fecha y la Issue que controla el trabajo.

---

## Registro de cambios (disclaimer)


### 2026-09-09 — Limpieza y vigencia documental

- **Cambio:** se explicitó la fecha de corte y se rectificó la afirmación sobre el color del video.
- **Antes:** el informe podía leerse como certificación actual y afirmaba que el montaje adoptaba la paleta vigente.
- **Motivo:** preservar el control histórico sin trasladar sus resultados a versiones posteriores.
- **Alcance:** Revisión documental; no añade resultados ni modifica el protocolo o los artefactos.

### 2026-09-09 — Wireframe v1 cerrado

- **Cambio:** se añadió el cierre de la línea base y se retiró su congelamiento de los pendientes inmediatos.
- **Versión anterior:** la auditoría reconocía la cobertura, pero aún exigía un recorrido interno y un cierre formal.
- **Motivo:** la corrección cromática, las exportaciones y la comprobación reproducible quedaron completas.
- **Alcance:** no cambia el estado pendiente de Android, hardware o validación.

### 2026-09-08 — Runtime móvil comprobado

- **Cambio:** se incorporó el resultado de la suite interactiva y las correcciones que permitieron ejecutarla con el gestor y el navegador disponibles.
- **Versión anterior:** la compilación y la publicación web estaban comprobadas, pero la suite de gestos no tenía un cierre reproducible.
- **Motivo:** distinguir una interfaz compilable de una base interactiva efectivamente comprobada.
- **Resultado:** 8 pruebas del runtime, 4 del trabajador de publicación y la compilación de producción terminaron correctamente.

### 2026-09-08 — Autoridad visual corregida

- **Cambio:** la tabla de fuentes vigentes remite a la dirección de comunicación del 7 de septiembre y no al sistema v4 anterior.
- **Versión anterior:** la auditoría trataba v4 como autoridad activa pese a que el índice visual ya la declaraba sustituida para piezas nuevas.
- **Motivo:** mantener una única fuente cromática, tipográfica y comunicacional.
- **Alcance:** v4 permanece disponible para auditar piezas producidas en esa etapa.

### 2026-09-08 — Conteos de integridad sincronizados

- **Cambio:** se actualizaron la fecha del informe, el conteo editorial y los conteos de Markdown, enlaces, JSON, PNG y contenedores después de la reorganización.
- **Versión anterior:** el título y una corrección editorial conservaban el corte del 7 de septiembre y 86 páginas, mientras el control final ya registraba 87.
- **Motivo:** evitar que una auditoría modificada el 8 de septiembre informe un inventario anterior.
- **Resultado:** 1.036 enlaces locales, 14 JSON, 743 PNG y 5 contenedores comprobados sin errores.

### 2026-09-08 — Implementación mínima incorporada

- **Qué cambió:** se incorporó al control transversal el programa micro:bit compilado, la separación entre banco rojo y material cálido y el nuevo orden inmediato de ejecución. Los conteos posteriores a la reorganización se registran en la entrada siguiente.
- **Cómo estaba antes:** la auditoría solo registraba la plataforma como pendiente y situaba la comprobación física después del cierre de wireframes.
- **Por qué se decidió:** distinguir con precisión lo que ya puede instalarse de lo que todavía requiere hardware, medición y revisión.
- **Alcance:** la compilación comprueba el código, no el enlace real, la seguridad, la percepción ni la comprensión.

### 2026-09-07 — Ruta física sincronizada

- **Qué cambió:** se reemplazó la puerta B1/B2 por una comprobación con plataforma existente y una integración posterior con XIAO nRF52840.
- **Cómo estaba antes:** la auditoría indicaba inventario y revisión de dos montajes de 5 V como segundo paso inmediato.
- **Por qué se decidió:** mantener el control transversal alineado con D-047 y con las Issues #11 y #10.
- **Alcance:** la nueva secuencia sigue sin acreditar construcción, seguridad, funcionamiento o resultados con participantes.

### 2026-09-07 — Creación

- **Qué cambió:** se consolidaron los controles de integridad, las correcciones realizadas, las fuentes vigentes y los pendientes comprobados.
- **Cómo estaba antes:** existían auditorías parciales de organización, memoria, mercado y entregables, pero no un control transversal posterior a las piezas del 2–4 de septiembre.
- **Por qué se decidió:** ofrecer evidencia verificable del estado del repositorio y evitar que una corrección documental se confunda con cierre técnico o validación.
- **Alcance:** auditoría del repositorio y sus artefactos actuales; no incluye resultados con usuarios ni certificación eléctrica.
