# Gobernanza del proyecto

Este directorio define cómo se investiga, documenta, decide y revisa el proyecto de título. Sus reglas prevalecen sobre los borradores históricos cuando existe una contradicción de método o de nomenclatura.


**Feedback más reciente:** [aplicación de anotaciones del 23 de septiembre](aplicacion-feedback-docente-2026-09-23.md) y [auditoría Android 2.6](../06_desarrollo_y_factibilidad/app-android/revision-feedback-2026-09-23.md). La validación con participantes sigue pendiente.

**Migración a Claude:** usa [`INICIO-CLAUDE.md`](INICIO-CLAUDE.md) y el [traspaso integral del proyecto](traspaso-a-claude-2026-09-24.md). El archivo raíz `CLAUDE.md` aplica estas reglas cuando Claude Code abre el repositorio.

## Función

La gobernanza busca que cada resultado pueda responder cuatro preguntas:

1. ¿De qué fuente proviene?
2. ¿Qué nivel de certeza tiene?
3. ¿Qué decisión permite tomar?
4. ¿Qué falta verificar?

**Revisión más reciente:** [Limpieza y vigencia de textos](auditoria-textual-2026-09-09.md), con correcciones, erratas bibliográficas y alcance de los controles.

## Documentos

- `directrices-de-trabajo.md`: mandato integral de investigación, desarrollo, escritura, trazabilidad y colaboración.
- `guia-comunicacion-relevo.md`: arquitectura de mensaje, explicaciones por duración, ejemplos de uso, preguntas frecuentes y control de afirmaciones.
- `hoja-de-ruta.md`: secuencia de trabajo y condiciones para avanzar.
- `plan-de-cierre-agosto-diciembre-2026.md`: estado actual, ruta crítica, calendario, hitos y criterios de cierre hasta la entrega.
- `criterios-de-calidad.md`: estándares de evidencia, escritura, APA 7, privacidad y control de cambios.
- [Trazabilidad del uso de IA](trazabilidad-uso-ia-2026-09-23.md): declaración candidata, registros de prompts existentes, distinción entre salida generada y decisión del autor, y ficha para futuras iteraciones.
- [Aplicación del feedback docente del 23 de septiembre](aplicacion-feedback-docente-2026-09-23.md): cambios incorporados, opciones no adoptadas y condiciones antes de trabajar con participantes.
- [Traspaso a Claude](traspaso-a-claude-2026-09-24.md): contexto, evidencia, estado del producto, mapa documental, riesgos y prioridades.
- [Inicio rápido para Claude](INICIO-CLAUDE.md): instrucción inicial para comenzar sin reconstruir conversaciones.
- `indice-del-repositorio.md`: orden de lectura, estado de cada carpeta y fuentes que deben tomarse como referencia.
- `auditoria-organizacion-2026-09-02.md`: revisión global de estructura, duplicados, nombres, enlaces y archivos conservados.
- GitHub Issues: tareas operativas, bloqueos y criterios de cierre.

## Regla principal

Solo puede existir una fase sustantiva activa a la vez. Las tareas menores pueden apoyar esa fase, pero no abrir una línea independiente de desarrollo.

## Jerarquía de fuentes

1. Registro primario contemporáneo al levantamiento.
2. Documento académico entregado o comentario docente verificable.
3. Transcripción o síntesis derivada cuya procedencia esté documentada.
4. Borrador, hipótesis o material generado para explorar.
5. Contenido sin procedencia verificable.

Una fuente de menor nivel no puede corregir silenciosamente una de mayor nivel. Toda discrepancia debe quedar registrada.

---

## Registro de cambios (disclaimer)

### 2026-09-23 — Trazabilidad de IA

- **Cambio:** se enlazó la reconstrucción parcial y el formato de registro de prompts.
- **Antes:** la evidencia se encontraba distribuida entre imágenes, wireframes y memorias históricas.
- **Motivo:** permitir explicar el proceso de diseño sin atribuir a la IA entrevistas, decisiones o validación.
- **Alcance:** el registro es parcial y requiere contraste con cualquier prompt original que conserve el autor.


### 2026-09-09 — Limpieza y vigencia documental

- **Cambio:** se enlazó el control textual actual y se aclaró la consulta de versiones.
- **Antes:** el recorrido de lectura no distinguía todos los cambios posteriores a las auditorías y exportaciones anteriores.
- **Motivo:** facilitar una entrada única a la revisión y evitar estados contradictorios.
- **Alcance:** Revisión documental; no añade resultados ni modifica el protocolo o los artefactos.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se añadió acceso directo a la respuesta responsable del feedback.
- **Versión anterior:** La respuesta estaba dispersa o conservaba formulaciones anteriores.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.

### 2026-09-04 — Guía transversal de comunicación

- **Cambio:** se agregó `guia-comunicacion-relevo.md` al conjunto de documentos de gobernanza.
- **Versión anterior:** la explicación del proyecto estaba distribuida entre el README, la memoria, la propuesta y los documentos visuales.
- **Motivo:** mantener una narrativa coherente entre presentaciones, demostraciones, paneles y conversaciones sin alterar la formulación académica.
- **Alcance:** la guía organiza el mensaje; su comprensión todavía debe probarse con personas.

### 2026-09-02 — Creación del índice operativo

- **Cambio:** se agregó `indice-del-repositorio.md` al conjunto de documentos de gobernanza.
- **Versión anterior:** la descripción de las carpetas estaba repartida entre distintos README.
- **Motivo:** ofrecer un único punto de entrada para distinguir fuentes vigentes, entregas fechadas y archivo histórico.

### 2026-08-29 — Plan de cierre temporal

- **Cambio:** se incorporó el plan de cierre entre agosto y diciembre de 2026.
- **Versión anterior:** la gobernanza definía una secuencia por fases, pero no un calendario de término con hitos fechados.
- **Motivo:** coordinar prototipado, validación, producto, memoria y preparación de entrega bajo un cierre interno al 15 de noviembre.

### 2026-08-23 — Incorporación de directrices

- **Cambio:** incorporación de `directrices-de-trabajo.md` al índice de gobernanza.
- **Versión anterior:** los principios generales estaban distribuidos entre el README principal, la hoja de ruta y mensajes de trabajo.
- **Motivo:** reunir en un documento normativo único las exigencias de investigación, escritura, proceso y trazabilidad.

### 2026-08-23 — Creación

- **Cambio:** creación de la política general de gobernanza.
- **Versión anterior:** no existía un documento equivalente.
- **Motivo:** impedir que borradores, fuentes primarias y síntesis derivadas se mezclen durante el desarrollo.

### 2026-09-02 — Auditoría global de organización

- **Cambio:** se incorporó un registro específico para explicar la revisión del repositorio completo, el tratamiento de duplicados y los criterios de conservación.
- **Versión anterior:** la gobernanza describía las reglas, pero no reunía en un documento único el resultado de la auditoría estructural.
- **Motivo:** dejar evidencia de por qué se mantienen las copias funcionales y por qué solo se retiran redundancias comprobadas.

### 2026-09-23 — Trazabilidad de decisiones del feedback

- **Cambio:** se enlazó un registro que separa decisiones aplicadas, alternativas por estudiar y requisitos previos a la validación.
- **Versión anterior:** el índice reunía la síntesis y la trazabilidad de IA, pero no mostraba en una sola entrada qué observaciones pasaron a la memoria o a los requisitos.
- **Motivo:** hacer visible el alcance de los cambios sin presentar propuestas ni resultados pendientes como hechos concluidos.

### 2026-09-24 — Continuidad en Claude

- **Qué cambió:** se enlazaron desde la gobernanza las instrucciones para Claude y el traspaso integral con fecha de corte.
- **Cómo estaba antes:** las referencias de feedback y continuidad se centraban en documentos anteriores al Android 2.6.
- **Por qué:** orientar la próxima conversación al estado actual del repositorio y sus pruebas todavía pendientes.
