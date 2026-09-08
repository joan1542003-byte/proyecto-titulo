# Auditoría de integridad del repositorio — 7 de septiembre de 2026

**Última actualización:** 8 de septiembre de 2026.

## Objetivo

Comprobar que la documentación vigente sea localizable, coherente y reproducible; corregir desactualizaciones verificables; y separar los errores del repositorio de los pendientes reales del proyecto.

## Resultado ejecutivo

El repositorio tiene una fuente académica identificada, una definición común de Relevo, enlaces internos funcionales y entregables visuales reproducibles. Se corrigieron desajustes de estado, alcance, color, paginación y ejecución técnica. No se encontraron enlaces locales rotos, archivos JSON inválidos ni exportaciones PNG dañadas.

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
| Automatización web | Los scripts previos al desarrollo y compilación dependían de que `npm` estuviera disponible aunque el proyecto usa `pnpm`. | Se invocó directamente el control de integridad con Node para mantener compatibilidad entre gestores. |
| Maqueta editorial | La fuente generaba 86 páginas, pero la carpeta pública contenía 70 PNG y una advertencia antigua. | Se reconstruyeron HTML, manifiesto y 86 exportaciones desde la misma fuente. |
| Video 4K | El archivo maestro faltaba, dos parámetros de audio no eran compatibles con ffmpeg 8.1 y la paleta no coincidía con el sistema vigente. | Se corrigió la fuente, se aplicó la paleta oficial y se reconstruyó el video con audio y subtítulos. |
| Arquitectura técnica | Un documento podía hacer pensar que Bluetooth y el procesamiento local ya estaban integrados. | Se rotularon como arquitectura objetivo pendiente de construcción y comprobación. |
| Banco micro:bit | La plataforma seleccionada no tenía una implementación ejecutable y su matriz roja contradecía la luz cálida del protocolo. | Se añadió código compilable, un archivo instalable y una secuencia en dos niveles: matriz roja solo para banco; luz cálida externa antes de involucrar participantes. |

## Verificaciones ejecutadas

| Control | Resultado |
| --- | --- |
| Enlaces locales en Markdown | 341 archivos y 958 referencias locales comprobadas; 0 rotas. |
| Archivos JSON | 17 archivos comprobados con `JSON.parse`; 0 inválidos fuera de dependencias. |
| Wireframes | Compilación correcta; 44 exportaciones; 9 marcos principales y 35 estados; 824 × 1830 px; navegación correcta; sin simulación de teléfono, desborde ni errores de consola. |
| Trabajador de publicación web | 4 pruebas aprobadas. |
| Maqueta editorial | 86 PNG válidos y manifiesto sincronizado. |
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
| ¿Qué sistema visual está activo? | [`10_recursos_visuales/README.md`](../10_recursos_visuales/README.md) y [`sistema-v4`](../10_recursos_visuales/08_direccion_visual_relevo/sistema-v4/README.md) |
| ¿Qué impide probar con personas? | [`07_validacion/README.md`](../07_validacion/README.md) y las Issues [#8](https://github.com/joan1542003-byte/proyecto-titulo/issues/8), [#11](https://github.com/joan1542003-byte/proyecto-titulo/issues/11) y [#10](https://github.com/joan1542003-byte/proyecto-titulo/issues/10) |
| ¿Cuáles son las fechas de cierre? | [`plan-de-cierre-agosto-diciembre-2026.md`](plan-de-cierre-agosto-diciembre-2026.md) |

## Pendientes reales y orden inmediato

1. Conseguir acceso a una micro:bit V2, instalar el programa y ejecutar el banco BLE sin participantes.
2. Incorporar una luz blanca cálida externa, revisar el montaje y completar la ficha técnica de fase A.
3. Congelar el wireframe v1 antes del 12 de septiembre mediante un recorrido interno completo.
4. Construir la navegación Android mínima y probar internamente app, luz, sonido y silencio local.
5. Completar contacto y revisión académica del consentimiento antes de reclutar.
6. Ejecutar la prueba de asociación y, después, la comparación con una notificación.
7. Integrar resultados reales en la memoria, factibilidad y decisiones.

La encuesta de 70 participantes permanece como fuente pendiente. No debe utilizarse hasta documentar sus materiales, procedencia, consentimiento, anonimización y análisis.

## Criterio para futuras revisiones

Una auditoría documental puede comprobar coherencia, trazabilidad y funcionamiento de los entregables. No puede declarar que Relevo funciona para usuarios ni cerrar decisiones que dependen de prototipos. Cualquier avance posterior debe actualizar, como mínimo, el README del área, el resumen vigente, el plan si cambia una fecha y la Issue que controla el trabajo.

---

## Registro de cambios (disclaimer)

### 2026-09-08 — Implementación mínima incorporada

- **Qué cambió:** se incorporó al control transversal el programa micro:bit compilado, la separación entre banco rojo y material cálido, el nuevo orden inmediato de ejecución y una nueva comprobación de 958 referencias locales y 17 archivos JSON.
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
