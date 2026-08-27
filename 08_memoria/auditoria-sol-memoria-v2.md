# Auditoría rectora de la memoria v2

- **Fecha:** 24 de agosto de 2026
- **Documento auditado:** [`memoria-vigente-v2.md`](memoria-vigente-v2.md)
- **Estado documental:** auditoría histórica de la v2; sustituida posteriormente por la memoria v4 y su auditoría de redacción.
- **Dictamen original:** aprobada como memoria integral activa al 24 de agosto de 2026; condicionada a incorporar resultados cuando se ejecuten los prototipos.

## 1. Alcance del dictamen

La auditoría revisó la memoria como Proyecto de Título de Diseño y no como cierre de una etapa preliminar. El criterio principal fue comprobar que la investigación, la formulación, el desarrollo de diseño, la producción, la gestión y la evaluación formaran una cadena argumental única. También se verificó que el documento distinguiera evidencia, inferencia, hipótesis, decisión y pendiente.

La versión v2 contiene 14 capítulos, referencias y anexos selectivos. Registra 20.603 palabras totales y 18.313 palabras antes de referencias y anexos al momento de esta auditoría. La extensión no se utiliza como indicador de calidad; se informa para confirmar que la reconstrucción no quedó reducida a un resumen ni se expandió mediante repetición deliberada.

## 2. Dictamen por dimensión

| Dimensión | Estado | Dictamen |
| --- | --- | --- |
| Formulación | Sólida | El problema se delimita por una relación situacional entre continuidad digital e intención alternativa, no por tiempo de pantalla, aplicación, adicción o juicio moral del ocio. Pregunta, objetivos, tesis, exclusiones e hipótesis son recíprocos. |
| Investigación | Sólida con límites explícitos | La literatura y el mercado sostienen el campo; las entrevistas se presentan como estudio cualitativo exploratorio y no como prevalencia. El corpus real P1–P8 está anonimizado, P6 figura con 27 años y Q13 queda limitada a In(Visible). |
| Usuarios | Sólida | El usuario principal y el usuario límite son patrones episódicos. La edad describe la muestra y no reemplaza necesidades, tensiones, deseos, estrategias y condiciones de no intervención. |
| Estado del arte y mercado | Sólido y actual | Se diferencia evidencia académica, documentación oficial y afirmación comercial. El mercado se organiza por mecanismos, incluye desarrollos de 2026 y no utiliza precio, compatibilidad o publicidad como prueba de eficacia. |
| Desarrollo de diseño | Coherente, aún no validado | La investigación se traduce a principios, familias, decisiones y criterios de refutación. El testigo transportable es una dirección provisional; forma, color, medidas, peso, señal y materiales no se presentan como especificaciones cerradas. |
| Sistema phygital | Coherente | Relevo articula aplicación Android, condición observable, objeto físico sin pantalla, lugar elegido y persona. La ausencia de pantalla es una restricción firme; su valor asociativo frente a una notificación es la hipótesis. |
| Flujos y técnica | Sólidos como arquitectura | Se distinguen flujo de usuario, sistema, técnica y diseño; estados, precondiciones, vencimiento y fallos. Android, BLE, energía y compatibilidad permanecen como hipótesis técnicas. |
| Producción y gestión | Suficiente para el estado actual | Se documentan componentes candidatos, fabricación, reparación, actores, cumplimiento, mantenimiento y fin de vida. La lista de materiales corregida es planificación no cotizada; no existe precio ni costo de producción validado. |
| Evaluación | Metodológicamente honesta | P0–P4 avanza por dependencias y no inventa número de participantes, duración, umbrales ni resultados. La notificación funciona como control y no como producto final. |
| Conclusión | Correcta | Separa contribuciones actuales de investigación, formulación, arquitectura y método del aporte esperado del artefacto. No atribuye a Relevo efectos aún inexistentes. |

## 3. Correcciones aplicadas durante la auditoría

1. Se corrigió el cálculo económico introducido erróneamente en una auditoría intermedia. La base es CLP 51.140–92.640; con 15 % de contingencia resulta CLP 58.811–106.536 y se comunica como CLP 59.000–107.000.
2. Se reformuló la ausencia de pantalla como restricción firme. La pregunta falsable es si esa decisión aporta una asociación comprensible, no si el proyecto puede convertirse en una aplicación.
3. Se retiró una comparación prematura entre baterías específicas y se mantuvo la energía como decisión de ingeniería dependiente de mediciones.
4. Se definieron siglas y conceptos técnicos en su primera aparición; se eliminaron abreviaturas no explicadas y anglicismos prescindibles.
5. Se incorporó la investigación de Kidel Peña-Albert et al. (2026) para registrar la tendencia reciente hacia la reconfiguración de intervenciones.
6. Se numeró la tabla de contribuciones y se regularizó la estructura de anexos.
7. Se eliminó la repetición de la matriz P1–P8 en el anexo; la tabla individual permanece en el capítulo de usuarios y el anexo conserva una ficha metodológica.
8. Se reemplazó el disclaimer parcial por un registro completo de qué se mantuvo, reemplazó y retiró respecto de la versión anterior.

## 4. Verificaciones críticas superadas

- Entrevistas presenciales, habladas y semiestructuradas: 11 y 12 de junio de 2026, Santiago.
- Reclutamiento por referencias; edad como único criterio común confirmado; rango observado de 19 a 27 años.
- P6 tiene 27 años.
- Consentimiento informado oral; no se inventa el texto exacto entregado.
- Preguntas y repreguntas realizadas por el investigador; apoyo automatizado solo posterior al levantamiento.
- Q12 y Q13 presenciales; Q13 se refiere a In(Visible), no a Relevo.
- Usuario principal y límite situacionales; hogar como hipótesis de diseño, no contexto observado.
- Relevo phygital y objeto físico sin pantalla sin contradicciones en la formulación vigente.
- Activación abierta entre continuidad, acumulación y horario.
- Sin resultados de prototipo, accesibilidad, convivencia, autonomía, producción o disposición de pago inventados.
- 45 referencias y 45 enlaces en la bibliografía, sin duplicados; todas las referencias aparecen citadas en el cuerpo.
- Tablas del cuerpo numeradas del 1 al 13; anexos identificados como A1, B1 y C1.
- Sin referencias a instrucciones docentes o etapas ajenas al cuerpo académico.
- Revisión de espacios y sintaxis de diferencias sin errores mediante `git diff --check`.

## 5. Pendientes que la escritura no puede resolver

La memoria está completa para el estado real del proyecto, pero el Proyecto de Título no está empíricamente cerrado. Las decisiones siguientes deben abordarse en este orden:

1. cerrar el protocolo y el consentimiento de P0;
2. ejecutar P0 y verificar asociación sin texto;
3. comparar lugar congruente, lugar neutro y notificación en P1;
4. decidir señal y salida física en P2;
5. escoger y probar la condición de activación, Android, BLE y fallos en P3;
6. definir participantes, duración y contexto del piloto P4;
7. actualizar producción, costos, mantenimiento y conclusión con resultados reales.

La condición de activación es el pendiente crítico más cercano. Elegir continuidad, acumulación u horario antes de P0–P2 podría cerrar una solución técnica sin demostrar el valor físico. La forma final tampoco debe cerrarse antes de comparar el testigo situado con la notificación.

## 6. Decisión de activación documental adoptada el 24 de agosto de 2026

En esa fecha, `memoria-vigente-v2.md` sustituyó a la v1 como documento activo del repositorio. La v1 se conservó como antecedente. Los siete módulos, las seis auditorías y el dictamen rector quedaron como capa de proceso y trazabilidad. Esta decisión fue sustituida posteriormente por D-033, que declara activa la v4.

---

## Registro de cambios (disclaimer)

### 2026-08-26 — Reclasificación como auditoría histórica

- **Cambio:** el dictamen y su decisión de activación quedaron fechados y subordinados a D-033.
- **Versión anterior:** el documento seguía afirmando en presente que la v2 era la única formulación integral vigente.
- **Motivo:** conservar el resultado de la auditoría sin convertir una decisión temporal en instrucción actual.
- **Alcance:** no se modificaron las verificaciones realizadas sobre la v2.

### 2026-08-24 — Creación de la auditoría rectora

- **Cambio:** se creó un dictamen independiente posterior al montaje y corrección de la memoria v2.
- **Versión anterior:** existían seis auditorías especializadas y un dictamen de arquitectura, pero no un control final único sobre el documento integrado.
- **Contenido incorporado:** evaluación por dimensiones, correcciones aplicadas, verificaciones críticas, pendientes por dependencia y decisión de activación documental.
- **Motivo:** registrar por qué la v2 puede convertirse en memoria activa sin ocultar que la evaluación del artefacto permanece pendiente.
- **Alcance:** este archivo no agrega evidencia, resultados, preferencias, costos ni decisiones de producto. Documenta el control editorial y metodológico realizado sobre `memoria-vigente-v2.md`.
