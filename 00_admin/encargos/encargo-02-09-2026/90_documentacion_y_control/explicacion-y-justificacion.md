# Explicación y justificación de los wireframes

## Ruta principal

### 1.1 Formular

Permite escribir una intención y convertirla en un primer paso concreto. Está primero porque Relevo necesita partir de una decisión expresada por la persona, no de una interpretación automática de su conducta. Si la información queda incompleta, se conserva como borrador. Su versión de alta fidelidad se conserva como exploración anterior del sistema visual.

### 1.2 Configurar condición provisional

Reúne la aplicación, la condición observable y la vigencia del ciclo. La condición se presenta como provisional porque todavía debe comprobarse que sea comprensible, técnicamente viable y pertinente. La persona puede corregirla, cambiarla o salir sin perder lo que ya formuló.

### 1.3 Revisar

Ordena en una sola lectura la intención, el primer paso, la condición y la vigencia. Esta pausa evita que el ciclo avance con datos ambiguos y permite editar antes de involucrar el testigo físico. Los permisos pendientes se comunican como una limitación técnica, no como un error personal.

### 2.1 Situar

Vincula el testigo con la intención y con el lugar donde podría comenzar el primer paso. Su función no es decidir automáticamente una ubicación, sino hacer explícita una relación elegida por la persona. Si el dispositivo no responde o tiene poca batería, el recorrido vuelve a búsqueda o preparación.

### 2.2 Probar el pulso

Permite emitir una señal breve antes de armar el ciclo. La prueba existe para que la persona determine si el pulso se percibe, resulta discreto y puede detenerse. El sistema no declara por sí mismo que la señal haya sido adecuada; ajustar o cambiar el lugar son resultados válidos.

### 2.3 Armar mediante control físico

Cierra la preparación mediante una acción deliberada. El armado no sucede automáticamente después de configurar la aplicación: exige una confirmación explícita vinculada al testigo. Si la confirmación no llega, se puede reintentar, revisar el vínculo o salir sin armar.

### 3.1 Esperar

Muestra que el ciclo está activo y que la condición sigue vigente. La pantalla evita contadores, premios o evaluaciones porque esperar no significa que la persona esté fallando. También mantiene visible la posibilidad de desarmar el ciclo en cualquier momento. Su desarrollo en alta fidelidad se eligió como pantalla destacada porque reúne intención, primer paso, condición, vigencia y testigo.

### 3.2 Recibir el pulso situado

Representa el momento físico en que el testigo emite el pulso cerca del primer paso. No es una pantalla del objeto. Se incluye para que el recorrido phygital no quede reducido a la aplicación. Después de percibir la señal, iniciar, continuar con otra actividad, ignorar o silenciar son decisiones equivalentes.

### 3.3 Cerrar o recuperar

Permite terminar el ciclo o resolver un fallo técnico sin abrir una cuarta interacción. El cierre describe el estado del sistema, no confirma que la persona haya realizado la actividad. La recuperación distingue problemas de vínculo, batería o permisos de cualquier juicio sobre la decisión personal.

## Estados de cobertura

Los siguientes estados completan el recorrido, pero no se presentan como una secuencia lineal. Cada uno aparece solo cuando su condición de entrada lo requiere.

### A. Preparar la intención

| Estado | Qué resuelve y por qué existe | Continuidad prevista |
|---|---|---|
| **01. Sin configurar** | Define el punto de partida cuando no hay ciclo. Evita mostrar datos, progreso o acciones que todavía no corresponden. | Crear una intención o permanecer inactivo. |
| **02. Datos incompletos** | Señala qué falta sin borrar lo ya escrito. Permite corregir o guardar un borrador. | Completar, revisar permisos o pasar a revisión. |
| **03. Permiso requerido** | Explica por qué una condición necesita acceso de Android antes de solicitarlo. | Conceder, cambiar la condición o volver. |
| **04. Permiso denegado** | Mantiene una salida cuando Android no permite observar la condición elegida. | Abrir ajustes, cambiar la condición o salir. |
| **05. Revisión** | Reúne los datos mínimos antes de vincular el testigo. Reduce errores de preparación y permite editar. | Continuar para situar o volver a configurar. |
| **06. Salida voluntaria** | Reconoce que la persona puede detener la preparación sin que eso se trate como fallo. | Guardar, descartar o seguir editando. |

### B. Vincular y probar el testigo

| Estado | Qué resuelve y por qué existe | Continuidad prevista |
|---|---|---|
| **07. Buscando testigo** | Hace visible que la búsqueda está en curso y que todavía no existe un vínculo confirmado. | Esperar, reintentar o cancelar. |
| **08. Elegir y confirmar testigo** | Permite comprobar que se vincula el dispositivo correcto antes de situarlo. | Confirmar, elegir otro o revisar batería. |
| **09. Testigo no reconocido** | Separa un problema de identificación de una acción incorrecta de la persona. | Volver a buscar o cancelar. |
| **10. Batería baja** | Advierte que la energía disponible puede no asegurar la prueba o el ciclo. | Cargar, posponer o salir. |
| **11. Probar lugar** | Relaciona el testigo con el primer paso y abre la prueba situada. | Emitir el pulso, ajustar o cambiar el lugar. |
| **12. Señal no percibida** | Registra el resultado declarado por la persona sin afirmar que el sistema mida percepción. | Ajustar y repetir la prueba. |
| **13. Señal intrusiva** | Permite reducir o reubicar una señal que interfiere con el contexto. | Ajustar, cambiar el lugar o no armar. |
| **14. Listo para armar** | Confirma que vínculo, lugar y prueba fueron revisados, pero aún no arma el ciclo. | Continuar al armado, volver a probar o salir. |

### C. Armar el ciclo

| Estado | Qué resuelve y por qué existe | Continuidad prevista |
|---|---|---|
| **15. Vinculando o armando** | Comunica la transición mientras se espera una confirmación técnica. | Confirmar, reintentar o cancelar. |
| **16. Armado** | Indica que Android y testigo reconocen el ciclo activo. No significa que la actividad ya haya comenzado. | Esperar o desarmar. |
| **17. Confirmación ambigua o fallo** | Evita declarar un armado cuando el vínculo no entrega certeza suficiente. | Reintentar, revisar el enlace o desarmar. |
| **18. Desarmado voluntario** | Permite detener el ciclo sin sanción y evita cualquier pulso posterior. | Cerrar, preparar de nuevo o rearmar explícitamente. |
| **19. Editar mientras está armado** | Impide modificar silenciosamente un ciclo vigente. Primero se debe desarmar o conservar la configuración actual. | Desarmar y editar, o mantener el ciclo. |

### D. Esperar y emitir la señal

| Estado | Qué resuelve y por qué existe | Continuidad prevista |
|---|---|---|
| **20. Armado en espera** | Mantiene visible el estado sin interpretar la actividad digital ni convertir el tiempo en progreso. | Seguir esperando, consultar o desarmar. |
| **21. Condición cumplida y orden válida** | Informa que la condición fue reconocida dentro de la vigencia y que la orden puede enviarse. | Entregar al testigo o recuperar el vínculo. |
| **22. Orden tardía o expirada** | Evita emitir una señal fuera de contexto cuando la vigencia ya terminó. | Cerrar o preparar otro ciclo. |
| **23. Señal física activa** | Representa el único pulso situado del testigo. Es el único estado donde aparece el rojo semántico. | Percibir, silenciar, continuar o cerrar. |
| **24. Silenciar, ignorar o continuar** | Mantiene abiertas las respuestas posteriores sin registrar cumplimiento. | Silenciar y cerrar; cualquier acción personal queda fuera del registro. |

### E. Cerrar y recuperar

| Estado | Qué resuelve y por qué existe | Continuidad prevista |
|---|---|---|
| **25. Intención cumplida o cierre** | Cierra el ciclo sin exigir evidencia de que la actividad se realizó. | Terminar o preparar otro ciclo. |
| **26. Intención cambiada** | Reconoce que cambiar de idea es una decisión válida, no un error. | Cerrar o reformular. |
| **27. Permiso revocado** | Explica que Android dejó de permitir la observación de la condición. | Revisar el permiso, cambiar la condición o cerrar. |
| **28. Restricción en segundo plano** | Hace visible que el sistema no puede observar la condición con fiabilidad. | Ajustar la restricción, mantener o cerrar. |
| **29. Pérdida de BLE o reconexión** | Informa una interrupción del vínculo sin alterar silenciosamente el ciclo. | Reconectar, reintentar o cerrar. |
| **30. Objeto movido** | Advierte que el lugar probado cambió y que la señal podría comportarse de otra manera. | Repetir la prueba de lugar. |
| **31. Batería crítica** | Evita prometer un pulso cuando la energía no permite asegurarlo. | Cargar, desarmar o cerrar. |
| **32. Reinicio del objeto** | Comunica que el testigo perdió temporalmente su estado. | Verificar el vínculo y rearmar de forma explícita. |
| **33. Vencimiento sin activación** | Cierra una vigencia que terminó sin una señal válida. | Cerrar o preparar un nuevo ciclo. |
| **34. Rearme explícito** | Impide que un ciclo terminado vuelva a activarse por sí solo. | Revisar y confirmar nuevamente. |
| **35. Eliminar configuración** | Permite borrar un ciclo o borrador mediante una decisión confirmada y reversible antes de ejecutarse. | Eliminar o regresar al estado anterior. |

## Decisión general

La cobertura busca que Relevo pueda fallar, detenerse o cambiar de dirección sin convertir esas situaciones en incumplimiento. La aplicación organiza y comunica; el testigo emite el pulso situado; la persona conserva la decisión. Esa separación orienta tanto la estructura de las pantallas como el tratamiento de errores y salidas.

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Actualización de la pantalla destacada

- **Qué se incorporó:** la relación entre 3.1 Esperar y su desarrollo de alta fidelidad.
- **Cómo estaba antes:** la explicación asociaba la muestra visual principal únicamente con 1.1 Formular.
- **Qué se reemplazó:** la exploración 1.1 se mantiene, pero 3.1 pasa a representar la dirección principal.
- **Por qué se hizo:** destacar una pantalla que explique mejor el funcionamiento del ciclo activo.

### 2026-09-02 — Explicación individual de la entrega

- **Qué se incorporó:** explicación y justificación de los nueve marcos y los 35 estados de cobertura.
- **Cómo estaba antes:** la información existía en matrices técnicas, el código del prototipo y documentos separados.
- **Qué se reemplazó:** no se reemplazó contenido de investigación; se reorganizó en un lenguaje más directo para acompañar las imágenes.
- **Por qué se hizo:** permitir que cada archivo se entienda por su función y no solo por su apariencia o número.
- **Alcance:** las justificaciones describen la estructura vigente; no demuestran eficacia, accesibilidad o funcionamiento técnico.

### 2026-09-02 — Normalización del nombre del archivo

- **Qué cambió:** el archivo pasó de `EXPLICACION-Y-JUSTIFICACION.md` a `explicacion-y-justificacion.md`.
- **Por qué se hizo:** unificar nombres descriptivos en minúscula y facilitar la navegación, sin alterar las explicaciones.
