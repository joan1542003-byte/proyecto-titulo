# Inventario de pantallas oscuras de Relevo

## Propósito

Este inventario convierte la cobertura del Encargo 17 en una guía visual para Android. Incluye las tres interacciones evaluables, los nueve marcos principales y los 35 estados documentados en el anexo. No agrega funciones ni convierte todos los estados en destinos que la persona deba recorrer.

La fuente estructural es `05_propuesta_phygital/wireframes-media-html/src/wireframes.ts`. La fuente de continuidad es `05_propuesta_phygital/anexo-cobertura-interacciones-encargo-17.md`. La función del sistema está limitada por `08_memoria/memoria-vigente-v4.md` y por D-023, D-024, D-027, D-031, D-032 y D-034 en `09_decisiones/registro-de-decisiones.md`.

## Categorías

- **Contenido:** información que debe comprenderse.
- **Icono:** signo convencional de una acción o entidad.
- **Elección:** alternativa seleccionable con estados distinguibles.
- **Acción:** control que ejecuta o avanza.
- **Estado:** información no pulsable del sistema o del ciclo.
- **Gráfico informativo:** relación visual que necesita texto equivalente.
- **Decoración:** elemento prescindible que no contiene función ni información indispensable.

El hecho de que un elemento sea visualmente atractivo no lo convierte en información. Si un punto, círculo, cápsula o línea comunica algo, debe clasificarse por lo que comunica y no como decoración.

## Interacciones evaluables

| Interacción | Marcos | Función | Regla visual dominante |
| --- | --- | --- | --- |
| 1. Formular y preparar | 1.1, 1.2, 1.3 | Convertir una intención en un ciclo revisable. | Contenido primero; sin rojo ni señal situada. |
| 2. Situar, probar y armar | 2.1, 2.2, 2.3 | Relacionar intención, primer paso, lugar y testigo. | El testigo emite el pulso en el lugar elegido; la aplicación organiza y confirma el vínculo. |
| 3. Recibir el pulso y cerrar | 3.1, 3.2, 3.3 | Esperar, percibir la señal y cerrar o recuperar. | El estado físico y el fallo técnico no se confunden. |

## Anatomía semántica de los nueve marcos principales

| Marco | Elementos y categoría | Acción principal | Riesgo de confusión |
| --- | --- | --- | --- |
| **1.1 Formular** | Título, explicación, campos de intención y primer paso: **contenido**. Retorno: **icono/acción**. Crear intención: **acción**. Reglas o puntos: **decoración prohibida** salvo que tengan texto equivalente. | Crear intención y continuar. | Que el primer paso parezca una meta evaluada o que los campos parezcan una selección cerrada. |
| **1.2 Configurar condición provisional** | Aplicación y condición: **elecciones**. Vigencia y permiso: **contenido/estado**. Iconos de aplicación: **iconos convencionales**. Revisar: **acción**. | Seleccionar una condición comprensible y revisar. | Que la condición parezca diagnóstico, límite moral o promesa de detección subjetiva. |
| **1.3 Revisar** | Resumen de intención, primer paso, condición y vigencia: **contenido**. Estado por validar: **estado**. Editar y continuar: **acciones**. | Continuar para situar. | Que los resúmenes parezcan tarjetas seleccionables o que la condición parezca validada. |
| **2.1 Situar** | Escena actividad–testigo: **gráfico informativo** con texto equivalente. Testigo, vínculo y lugar: **contenido/estado**. Vincular: **acción**. Elegir otro: **acción secundaria**. | Vincular y situar el testigo. | Que el dibujo cierre la forma del objeto o que el lugar parezca detectado automáticamente. |
| **2.2 Probar el pulso** | Relación entre primer paso, lugar y testigo: **contenido/gráfico informativo**. Vínculo y batería: **estados**. Emitir pulso y ajustar lugar: **acciones**. Resultado declarado después: **elección posterior**, no de este marco. | Emitir pulso de prueba físico. | Que se confunda con armar, notificación telefónica o señal situada definitiva. |
| **2.3 Armar mediante control físico** | Resumen del ciclo: **contenido**. Testigo listo: **estado**. Instrucción de pulsación prolongada: **contenido**. Continuar al armado: **acción**. Salir sin armar: **acción**. | Iniciar armado explícito. | Que el gesto provisional parezca una especificación cerrada o que el teléfono arme automáticamente. |
| **3.1 Esperar** | Intención, primer paso, condición y vigencia: **contenido**. Ciclo armado y testigo situado: **estados**. Desarmar: **acción**. | Dejar el teléfono o desarmar. | Que la espera parezca progreso, contador o seguimiento de cumplimiento. |
| **3.2 Recibir el pulso situado** | Escena física y relación con el primer paso: **gráfico informativo**. Testigo situado: **contenido**. Pulso: **estado físico representado**, no control. Silenciar: **acción**. | Percibir y decidir libremente. | Que el testigo parezca exigir consulta continua o que la respuesta posterior parezca evaluada. |
| **3.3 Cerrar o recuperar** | Cierre del ciclo: **estado**. Fallo técnico: **estado**. Explicación: **contenido**. Cerrar, reintentar, reconectar o revisar: **acciones**. | Cerrar o recuperar. | Que un fallo técnico parezca incumplimiento o que el cierre produzca rearme automático. |

## Inventario completo de estados 01–35

Las categorías de cada fila indican el mínimo que debe aparecer si el estado se representa visualmente. Los estados no deben compartir necesariamente una pantalla ni exigir atención continua.

| Estado | Familia / nombre | Categorías mínimas | Acción o elección | Riesgo de confusión |
| ---: | --- | --- | --- | --- |
| 01 | Sin configurar | Contenido, acción, decoración mínima | Crear intención | Que una pantalla vacía parezca un panel de productividad. |
| 02 | Datos incompletos | Contenido, estado, acción | Completar, corregir o guardar borrador | Que la ausencia de un dato parezca error personal. |
| 03 | Permiso requerido | Contenido, estado, icono convencional, acción | Revisar permiso o cambiar condición | Que el permiso parezca una exigencia moral. |
| 04 | Permiso denegado | Contenido, estado, acción | Abrir ajustes, cambiar condición o salir | Que el rojo de error se confunda con señal situada. |
| 05 | Revisión | Contenido, estado, acción | Editar o continuar | Que el resumen parezca una selección. |
| 06 | Salida voluntaria | Contenido, elección, acción | Guardar, descartar o seguir editando | Que salir parezca fracaso o pérdida obligatoria. |
| 07 | Buscando testigo | Estado, contenido, icono convencional, acción | Esperar, buscar de nuevo o cancelar | Que una animación de búsqueda parezca progreso del ciclo. |
| 08 | Elegir y confirmar testigo | Contenido, elección, estado, icono | Elegir y vincular el correcto | Que batería o vínculo parezcan opciones de configuración. |
| 09 | Testigo no reconocido | Contenido, estado, acción | Buscar de nuevo o cancelar | Que el error se atribuya a la persona. |
| 10 | Batería baja | Contenido, estado, icono, acción | Cargar o posponer | Que la batería use rojo como único significado. |
| 11 | Probar lugar / probar el pulso | Contenido, gráfico informativo, estado, acción | Emitir pulso o ajustar lugar | Que emitir el pulso arme el ciclo o ocurra en el teléfono. |
| 12 | Señal no percibida | Contenido, estado, elección, acción | Declarar resultado, ajustar o cambiar lugar | Que el sistema afirme medir la percepción. |
| 13 | Señal intrusiva | Contenido, estado, elección, acción | Declarar interferencia, ajustar o no armar | Que la intrusión sea tratada como incumplimiento. |
| 14 | Listo para armar | Contenido, estado, acción | Continuar al armado o volver a probar | Que “listo” se interprete como ya armado. |
| 15 | Vinculando o armando | Estado, contenido, acción | Esperar confirmación o cancelar | Que el proceso se convierta en progreso visual. |
| 16 | Armado | Contenido, estado, acción | Dejar el teléfono o desarmar | Que activo signifique cumplimiento. |
| 17 | Armado no confirmado | Contenido, estado, acción | Reintentar, revisar enlace o desarmar | Que el fallo técnico parezca falta de voluntad. |
| 18 | Desarmado voluntario | Contenido, estado, acción | Preparar de nuevo o cerrar | Que desarmar produzca una sanción. |
| 19 | Editar mientras está armado | Contenido, estado, acción, elección | Desarmar y editar o conservar ciclo | Que una edición cambie el ciclo silenciosamente. |
| 20 | Armado en espera | Contenido, estado, acción | Consultar o desarmar | Que la espera parezca contador o racha. |
| 21 | Condición cumplida y orden válida | Contenido, estado, gráfico informativo, acción | Enviar orden al testigo | Que la orden técnica parezca señal final o éxito. |
| 22 | Orden tardía o expirada | Contenido, estado, acción | Cerrar o preparar otro ciclo | Que una señal tardía parezca válida. |
| 23 | Señal física activa | Contenido, estado físico, gráfico informativo | Percibir y decidir | Que el testigo parezca una interfaz consultable. |
| 24 | Silenciar, ignorar o continuar | Contenido, elección, acción, estado | Elegir una respuesta sin registro | Que solo una respuesta parezca correcta. |
| 25 | Intención cumplida o cierre | Contenido, estado, acción | Cerrar o preparar otro ciclo | Que cerrar confirme que la intención se cumplió. |
| 26 | Intención cambiada | Contenido, estado, acción, elección | Cerrar o reformular | Que cambiar de idea parezca error. |
| 27 | Permiso revocado | Contenido, estado, acción | Recuperar permiso o cerrar | Que el estado técnico se comunique con alarma. |
| 28 | Restricción en segundo plano | Contenido, estado, acción | Ajustar restricción, mantener o cerrar | Que Android prometa observar algo que no puede confirmar. |
| 29 | Pérdida de BLE o reconexión | Contenido, estado, icono convencional, acción | Reconectar, reintentar o cerrar | Que desconectar parezca fallo de la persona. |
| 30 | Objeto movido | Contenido, estado, acción | Reubicar y probar | Que el sistema sugiera detectar el lugar por sí mismo. |
| 31 | Batería crítica | Contenido, estado, acción | Cargar, desarmar o cerrar | Que la batería se confunda con una urgencia moral. |
| 32 | Reinicio del objeto | Contenido, estado, acción | Verificar vínculo y repetir prueba | Que el sistema rearme automáticamente. |
| 33 | Vencimiento sin activación | Contenido, estado, acción | Cerrar o preparar otro ciclo | Que vencer indique fracaso o cumplimiento. |
| 34 | Rearme explícito | Contenido, estado, acción | Revisar y confirmar nuevamente | Que el sistema repita el ciclo sin autorización. |
| 35 | Eliminar configuración | Contenido, elección, acción, estado | Confirmar eliminación o cancelar | Que eliminar sea fácil de activar por accidente. |

## Orden de producción visual

Para no generar variaciones cosméticas ni trabajar dos áreas a la vez, las primeras pantallas oscuras deben cubrir funciones distintas:

1. inicio sin ciclo activo — estado 01;
2. formular intención y primer paso — estado 01/02;
3. configurar condición provisional — estado 02;
4. revisar antes de situar — estado 05;
5. situar y vincular testigo — estado 08;
6. probar el pulso — estado 11;
7. ciclo activo en espera — estado 20;
8. señal situada — estado 23;
9. fallo técnico recuperable — estados 17/29;
10. salida o cierre voluntario — estados 06/25.

Esta secuencia cubre primero el recorrido principal y luego dos clases de recuperación. Los estados 03, 04, 07, 09, 10, 12–16, 18–19, 21–22, 24, 26–28 y 30–35 permanecen documentados para la siguiente expansión.

## Resultados visuales de esta fase

Las imágenes finales se encuentran en `android/oscuro/`. El registro detallado de cada pieza está en `android/oscuro/README.md`.

| Archivo | Cobertura | Estado de auditoría |
| --- | --- | --- |
| `01-inicio-sin-ciclo-oscuro-v1.png` | 1.1 / 01 | Aprobada como referencia; fondo y tipografía se reconstruyen manualmente. |
| `02-formular-intencion-oscuro-v2.png` | 1.1 / 01–02 | Dirección aprobada; reconstrucción manual pendiente. |
| `03-condicion-provisional-oscuro-v2.png` | 1.2 / 02 | Candidata; debe conservar un solo control de retorno. |
| `04-revisar-ciclo-oscuro-v2.png` | 1.3 / 05 | Dirección aprobada; reconstrucción manual pendiente. |
| `05-vincular-testigo-oscuro-v2.png` | 2.1 / 08 | Candidata; no fija la forma física, pero debe normalizar la acción principal. |
| `06-probar-pulso-oscuro-v2.png` | 2.2 / 11 | Dirección aprobada; reconstrucción manual pendiente. |
| `07-ciclo-activo-espera-oscuro-v2.png` | 3.1 / 16–20 | Dirección aprobada; reconstrucción manual pendiente. |
| `08-senal-situada-oscuro-v2.png` | 3.2–3.3 / 23–24 | Dirección aprobada y referencia principal de la señal situada. |
| `09-fallo-vinculo-oscuro-v2.png` | 3.3 / 17–29 | Candidata; debe reducir la repetición del estado y normalizar la acción. |
| `10-ciclo-cerrado-oscuro-v2.png` | 3.3 / 25–34 | Dirección aprobada; el cierre no evalúa cumplimiento. |

Las dos pantallas claras descritas en `android/README.md` son históricas. No forman parte de esta dirección vigente.

## Criterios de aprobación

Una pantalla puede conservarse como exploración solo si:

- corresponde a un estado o marco documentado;
- tiene una tarea principal reconocible;
- distingue contenido, elección, acción y estado;
- no utiliza rojo fuera de la señal situada;
- no presenta puntos como progreso, selección o botón;
- mantiene texto en tipografía legible;
- expresa la función del testigo como una señal situada y breve;
- no introduce métricas, bloqueo, culpa, evaluación ni rearme automático;
- puede reconstruirse manualmente con medidas dp/sp y componentes identificables.

La conformidad visual no acredita comprensión, accesibilidad o funcionamiento. Esas propiedades requieren prototipo, revisión con tecnologías de asistencia y pruebas con personas.

---

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación

- **Cambio:** se creó el inventario de tres interacciones, nueve marcos evaluables y 35 estados documentados.
- **Versión anterior:** la cobertura existía en el Encargo 17, pero no estaba traducida a una clasificación visual común para Android oscuro.
- **Motivo:** controlar que cada pantalla tenga una función, una jerarquía y un riesgo de confusión explícitos antes de generar imágenes.
- **Alcance:** el inventario no agrega estados ni cierra decisiones abiertas de condición, señal, forma, materialidad o gesto físico.

### 2026-08-29 — Registro de generación

- **Cambio:** se añadió la relación entre diez imágenes oscuras finales y los marcos/estados que cubren.
- **Versión anterior:** el orden de producción estaba definido, pero no registraba resultados concretos ni rechazos de generación.
- **Motivo:** dejar trazabilidad entre requisito, imagen, auditoría y reconstrucción manual.

### 2026-08-29 — Auditoría comparativa v1/v2

- **Cambio:** se sustituyeron las referencias v1 superadas por sus versiones v2 y se diferenciaron direcciones aprobadas de candidatas por corregir.
- **Versión anterior:** la tabla nombraba las v1 como aprobadas aunque ya existían segundas generaciones con cambios sustantivos.
- **Motivo:** evitar que una exploración histórica se utilice como referencia de implementación y describir al testigo por la señal que emite.
