# Forma adaptable y ubicación del objeto

**Estado:** criterios de diseño vigentes; forma, fijaciones y desempeño pendientes de prueba.
**Preguntas:** ¿cómo responde un objeto a muchas actividades?, ¿qué alternativas tiene?, ¿cómo se diseña esa adaptabilidad?, ¿dónde vive?

## Respuesta

Relevo propone un objeto reubicable con un mismo comportamiento: emitir una señal breve y permitir silenciarla. Su significado cambia cuando la persona configura otra intención, elige su primer paso y vuelve a situarlo. El alcance inicial es una persona, una intención activa, un primer paso y un objeto por ciclo. Adaptabilidad entre ciclos no equivale a atender muchas tareas simultáneamente ni a garantizar uso universal.

La forma no necesita parecerse a cada actividad. La asociación se construye entre intención, objeto y lugar. La primera ubicación prevista es una superficie doméstica próxima a lo necesario para empezar; el hogar es una hipótesis de contexto, no una conclusión observacional de las entrevistas.

## Dónde vive

Los ejemplos siguientes son escenarios de diseño, no testimonios ni resultados.

| Intención | Primer paso realizable | Ubicación posible | Condición que puede invalidarla |
| --- | --- | --- | --- |
| Leer | Abrir el libro elegido. | Junto al libro. | El libro u otro objeto tapa la señal. |
| Hacer ejercicio en casa | Ponerse las zapatillas. | Sobre una superficie estable junto a ellas. | El objeto queda en el suelo fuera del campo perceptivo. |
| Dibujar | Abrir el cuaderno y tomar un lápiz. | Junto al cuaderno. | El lugar se confunde con una mesa genérica sin materiales preparados. |
| Preparar una salida de buceo ya planificada | Comenzar a preparar la bolsa. | Junto a la bolsa y el equipo guardado. | Se interpreta como equipo para usar bajo el agua o el comienzo requiere recursos ausentes. |

Antes de armar, la persona debe poder explicar la relación con el lugar y percibir/detener el pulso desde la situación de uso. Si la señal queda en otra habitación, demasiado lejos, cubierta o junto a un comienzo que ya no está disponible, se reubica y se prueba de nuevo. Si eso no resulta viable, ese contexto queda fuera del alcance probado. Relevo no detecta automáticamente dónde fue colocado.

## Proceso de diseño y alternativas

El método sigue la separación entre comprender/definir el problema y desarrollar/probar alternativas del Double Diamond (Design Council, s. f.). Se aplica al caso de Relevo; no se presenta como una receta que produzca universalidad.

1. Delimitar situaciones y primeros pasos a partir de los [perfiles](../03_usuarios/perfiles-situacionales.md) y los [recorridos](../03_usuarios/recorridos-situacionales.md).
2. Comprobar primero asociación y aporte del lugar mediante el [Protocolo 01](../07_validacion/protocolo-01-asociacion-y-comparacion.md).
3. Comparar las dos formas previstas en la Issue #10: circular y rectangular redondeada con volumen interno equivalente. Usar maquetas sin electrónica antes de fabricar carcasas funcionales.
4. Mantener el mismo patrón y control al comparar formas; registrar superficie, orientación, acceso al botón, estabilidad y percepción. No atribuir a la forma un cambio causado por brillo o volumen distintos.
5. Integrar únicamente la candidata que permita alojar, abrir y mantener los componentes reales. La meta circular de 42–48 mm por 12–16 mm sigue siendo una envolvente objetivo, no un tamaño verificado.
6. Estudiar soporte, anilla o clip solo si una ubicación necesaria falla con apoyo libre. Esas son alternativas de fijación por justificar, no accesorios aprobados para construir.

| Comparación | Evidencia que decide | Mantener o revisar |
| --- | --- | --- |
| Circular / rectangular redondeada | Vuelco, rodadura, orientación de luz y acceso al control. | Mantener la que cumpla mejor esas tareas; registrar si no aparece una diferencia. |
| Apoyo libre / fijación eventual | Desplazamiento, caída y esfuerzo de reubicación. | Añadir fijación solo si resuelve una necesidad observada sin bloquear luz o control. |
| Lugar relacionado / lugar neutro | Recuperación de intención y primer paso, carga e intrusión. | Aplicar los criterios de fase B; no elegir solo por preferencia estética. |

La [ficha UGREEN](../04_mercado_y_referentes/ugreen-localizador-como-referente.md) informa portabilidad y relaciones de fijación. Sus características no se convierten automáticamente en requisitos de Relevo.

## Qué falta para cerrar

Faltan pruebas, medidas y una comparación registrada. No se afirma que una misma forma resuelva todos los hogares, actividades o necesidades de accesibilidad. Si solo funciona para una familia de comienzos, se declara ese alcance y se revisa la configuración física cuando corresponda. Seguimiento: [Issue #8](https://github.com/joan1542003-byte/proyecto-titulo/issues/8) y, después, [Issue #10](https://github.com/joan1542003-byte/proyecto-titulo/issues/10).

## Referencias

Design Council. (s. f.). *The Double Diamond*. Recuperado el 9 de septiembre de 2026, de https://www.designcouncil.org.uk/resources/the-double-diamond/

## Registro de cambios (disclaimer)

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se definieron adaptabilidad, ubicación, alternativas y criterios de selección sin prometer universalidad.
- **Versión anterior:** No existía un documento específico.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.
