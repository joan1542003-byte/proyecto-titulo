# Anexo F. Estados del ciclo y *wireframes*

Muestra cómo se diseñó el recorrido completo de Relevo: primero, los 35 estados del ciclo que se definieron en agosto de 2026, con sus *wireframes*; después, los *wireframes* de las 39 pantallas de la app de octubre, ordenados por recorrido.

## F.1 Los 35 estados del ciclo

En agosto de 2026, antes del Tag, el objeto se pensó con un control propio. Para comprobar que el ciclo podía representarse de principio a fin, con sus validaciones, decisiones voluntarias, fallos técnicos y estados límite, cada estado tuvo su *wireframe*. Eso no significa que la persona mire el teléfono durante todo el recorrido: lo central es la señal del objeto, y la app configura, informa el estado y ayuda a recuperarse de un fallo. En estos *wireframes*, «armar» es activar un relevo, y el «pulso» es la señal.

Seis reglas delimitan el ciclo:

- Un ciclo tiene una intención, un primer paso, una condición, un objeto y una señal.
- La persona puede seguir, ignorar, silenciar, modificar, desarmar o cerrar, sin que el sistema juzgue lo que hace.
- Relevo no bloquea apps, no infiere estados de ánimo y no registra cumplimiento.
- Decidir algo distinto de la intención inicial es una salida válida, no un error.
- Después de un cierre, un vencimiento, un silencio o un desarme, nada se vuelve a armar solo.
- Los fallos se comunican como estados técnicos recuperables, no como incumplimientos.

**Tabla F1**

*Los 35 estados del ciclo*

| Estado | Cuándo ocurre | Qué se puede hacer |
| --- | --- | --- |
| **Configuración** | | |
| Sin configurar | No hay un ciclo activo. | Crear una intención. |
| Datos incompletos | Falta la intención, el primer paso, la condición o la vigencia. | Completar o corregir. |
| Permiso requerido | La condición necesita un permiso de Android. | Revisar y pedir el permiso. |
| Permiso denegado | La persona lo rechaza o Android no lo concede. | Abrir los ajustes o cambiar la condición. |
| Revisión | Los datos mínimos están completos. | Confirmar o editar. |
| Salida voluntaria | La persona decide no continuar. | Descartar el borrador o volver. |
| **Vinculación y prueba física** | | |
| Buscando el objeto | Comienza la asociación física. | Esperar, reintentar o cancelar. |
| Elegir y confirmar el objeto | Aparecen uno o más dispositivos. | Identificar y vincular el correcto. |
| Objeto incorrecto o no reconocido | El dispositivo no coincide o no responde. | Volver a buscar. |
| Batería baja | El objeto vinculado no asegura el ciclo. | Cargarlo o posponer. |
| Probar el lugar | El objeto ya está en su lugar. | Emitir un pulso de prueba. |
| Señal no percibida | La persona no detecta el pulso de prueba. | Ajustar la señal o reubicar. |
| Señal intrusiva | El pulso se percibe, pero interfiere con el contexto. | Reducir, reubicar o volver a probar. |
| Listo para armar | Lugar, enlace y pulso comprobados. | Armar de forma explícita. |
| **Armado** | | |
| Armando | Se pide armar el ciclo. | Esperar la confirmación o cancelar. |
| Armado | Android y el objeto confirman el ciclo. | Dejar el teléfono o desarmar. |
| Confirmación dudosa o fallo | No hay confirmación suficiente. | Reintentar, revisar el enlace o cancelar. |
| Desarmado voluntario | La persona detiene el ciclo. | Cerrar o volver a preparar. |
| Editar mientras está armado | Se intenta cambiar un ciclo activo. | Desarmar antes de editar o conservarlo. |
| **Espera y señal** | | |
| Armado en espera | El ciclo está activo y la condición aún no ocurre. | Consultar el estado o desarmar. |
| Condición cumplida | Android reconoce la condición dentro de la vigencia. | Enviar la orden al objeto. |
| Orden tardía o vencida | La orden llega fuera de la vigencia. | Cerrar sin pulso o preparar otro ciclo. |
| Señal activa | El objeto emite el único pulso. | Percibir y decidir libremente. |
| Silenciar, ignorar o seguir | La persona responde sin obligación de actuar. | Silenciar y cerrar; actuar queda fuera del registro. |
| **Cierre y recuperación** | | |
| Cierre | La persona decide terminar el ciclo. | Cerrar sin registrar cumplimiento. |
| Intención cambiada | La persona ya no quiere hacer lo que formuló. | Cerrar o reformular. |
| Permiso revocado | Android retira un permiso durante el ciclo. | Recuperar el permiso o cerrar. |
| Restricción en segundo plano | Android no deja observar la condición con fiabilidad. | Ajustar la restricción o cerrar. |
| Conexión perdida | Se corta el vínculo Bluetooth con el objeto. | Reconectar, reintentar o cerrar. |
| Objeto movido | Cambia el lugar donde se probó la señal. | Repetir la prueba antes de seguir. |
| Batería crítica | La energía ya no asegura el pulso. | Cargar, desarmar o cerrar. |
| Reinicio del objeto | El objeto pierde su estado por un momento. | Verificar el vínculo y volver a armar. |
| Vencimiento sin señal | Termina la vigencia sin una señal válida. | Cerrar o preparar un ciclo nuevo. |
| Volver a armar | La persona quiere repetir un ciclo terminado. | Revisar y confirmar de nuevo. |
| Eliminar | La persona decide borrar el ciclo o el borrador. | Confirmar o cancelar. |

*Nota.* Elaboración propia, agosto de 2026.

La ruta principal pasa por nueve estados: sin configurar, revisión, elegir y confirmar el objeto, probar el lugar, listo para armar, armado, armado en espera, señal activa y cierre. Los demás no son una segunda experiencia: hacen visibles las bifurcaciones que vuelven el sistema comprensible y recuperable. Hay cinco tipos de ruta: la principal, la validación previa, la salida voluntaria, el fallo técnico y el estado límite.

## F.2 *Wireframes* de agosto de 2026

**Figura F1**

*Los catorce *wireframes* del recorrido*

| Configuración 1 | Configuración 2 |
| --- | --- |
| ![Configuración 1](imagenes/agosto-A1-configuracion.jpg) | ![Configuración 2](imagenes/agosto-A2-configuracion.jpg) |

| Vinculación 1 | Vinculación 2 |
| --- | --- |
| ![Vinculación 1](imagenes/agosto-B1a-vinculacion.jpg) | ![Vinculación 2](imagenes/agosto-B1b-vinculacion.jpg) |

| Prueba 1 | Prueba 2 |
| --- | --- |
| ![Prueba 1](imagenes/agosto-B2a-prueba.jpg) | ![Prueba 2](imagenes/agosto-B2b-prueba.jpg) |

| Armado 1 | Armado 2 |
| --- | --- |
| ![Armado 1](imagenes/agosto-C1-armado.jpg) | ![Armado 2](imagenes/agosto-C2-armado.jpg) |

| Espera | Señal |
| --- | --- |
| ![Espera](imagenes/agosto-D1-espera.jpg) | ![Señal](imagenes/agosto-D2-senal.jpg) |

| Cierre | Recuperación 1 |
| --- | --- |
| ![Cierre](imagenes/agosto-E1-cierre.jpg) | ![Recuperación 1](imagenes/agosto-E2-recuperacion.jpg) |

| Recuperación 2 | Estados finales |
| --- | --- |
| ![Recuperación 2](imagenes/agosto-E3-recuperacion.jpg) | ![Estados finales](imagenes/agosto-E4-finales.jpg) |

*Nota.* Elaboración propia, agosto de 2026.

## F.3 *Wireframes* de la app (octubre de 2026)

Las 39 pantallas de la versión 2.32, en muy baja fidelidad y con sus textos reales, en cinco recorridos. Se dibujaron pieza por pieza sobre una retícula común, a partir de la posición de cada elemento en el emulador.

**Figura F2**

*La primera vez*

![La primera vez](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/1-primera-vez.png)

**Figura F3**

*Preparar un relevo*

![Preparar un relevo](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/2-preparar-un-relevo.png)

**Figura F4**

*Contar, sonar y decidir*

![Contar, sonar y decidir](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/3-contar-sonar-y-decidir.png)

**Figura F5**

*Inicio, ruta y perfil*

![Inicio, ruta y perfil](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/4-inicio-ruta-y-perfil.png)

**Figura F6**

*Perfil*

![Perfil](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/5-perfil.png)

*Nota.* Elaboración propia, a partir de la versión 2.32 de la app en el emulador.

## Registro de cambios (disclaimer)

### 2026-11-08 — Extranjerismos en cursiva

- **Qué cambió:** *wireframes*, *feed* y *hobbies* van en cursiva, como en la memoria.
- **Cómo estaba antes:** iban en redonda.
- **Por qué:** el autor pidió corregir los errores de formato (D-170).

### 2026-11-08 — Correcciones del autor

- **Qué cambió:** sale el «testigo», un concepto que el proyecto dejó atrás: el ciclo habla del objeto. La tabla de estados pierde los números y la columna «Sigue en», que no se entendían, y la ruta principal se nombra con palabras. Las láminas de agosto se llaman wireframes, con nombres sin códigos, y sale la mención al repositorio.
- **Cómo estaba antes:** los estados iban numerados del 01 al 35, con una columna de números de destino, y las láminas se nombraban A1, B1a…
- **Por qué:** el autor revisó los anexos y pidió un texto sin códigos ni menciones al repositorio, con palabras claras y la declaración de IA corregida (D-170).

### 2026-11-08 — Anexo recopilado y listo para Word

- **Qué cambió:** la cobertura de agosto se presenta en una sola tabla de 35 estados, agrupada por fase, con sus seis reglas y la ruta principal; salen las referencias internas a Figma y a versiones antiguas de la memoria. Las láminas de agosto y los wireframes de octubre se numeran como Figuras F1 a F6. Desde ahora este archivo es la fuente del anexo.
- **Cómo estaba antes:** copiaba el anexo de cobertura del encargo 17, con cinco tablas, los nodos de Figma y la indicación de leerlo bajo la memoria v4.
- **Por qué:** el autor pidió revisar todos los anexos y dejarlos listos para Word: directos, sin sobreexplicar, con su forma de escribir y con lo más relevante (D-168).

### 2026-10-24 — Creación

- **Qué cambió:** el anexo se arma desde sus documentos fuente, con el resto de los anexos A–I de la memoria v5.
- **Cómo estaba antes:** la carpeta de anexos solo tenía un README de la v4, con cinco anexos y sin su contenido.
- **Por qué:** el autor pidió elegir un pendiente de prioridad alta y terminarlo; la memoria v5 remite a nueve anexos que no estaban armados.
