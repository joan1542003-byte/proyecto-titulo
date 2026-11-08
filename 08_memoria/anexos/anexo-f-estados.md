# Anexo F. Estados del ciclo y wireframes

Muestra cómo se diseñó el recorrido completo de Relevo: primero, los 35 estados del ciclo que se definieron en agosto de 2026 para un testigo con control físico, con sus láminas; después, los wireframes de las 39 pantallas de la app de octubre, ordenados por recorrido.

## F.1 Los 35 estados del ciclo

En agosto de 2026, antes del Tag, el objeto se pensó como un testigo con control propio. Para comprobar que el ciclo podía representarse de principio a fin, con sus validaciones, decisiones voluntarias, fallos técnicos y estados límite, cada estado tuvo su wireframe. Eso no significa que la persona mire el teléfono durante todo el recorrido: lo central es la señal del testigo, y la app configura, informa el estado y ayuda a recuperarse de un fallo. En estas láminas, «armar» es activar un relevo, y el «pulso» es la señal.

Seis reglas delimitan el ciclo:

- Un ciclo tiene una intención, un primer paso, una condición, un testigo y una señal.
- La persona puede seguir, ignorar, silenciar, modificar, desarmar o cerrar, sin que el sistema juzgue lo que hace.
- Relevo no bloquea apps, no infiere estados de ánimo y no registra cumplimiento.
- Decidir algo distinto de la intención inicial es una salida válida, no un error.
- Después de un cierre, un vencimiento, un silencio o un desarme, nada se vuelve a armar solo.
- Los fallos se comunican como estados técnicos recuperables, no como incumplimientos.

**Tabla F1**

*Los 35 estados del ciclo*

| N.º | Estado | Cuándo ocurre | Qué se puede hacer | Sigue en |
| --- | --- | --- | --- | --- |
| **A. Configuración** | | | | |
| 01 | Sin configurar | No hay un ciclo activo. | Crear una intención. | 02 |
| 02 | Datos incompletos | Falta la intención, el primer paso, la condición o la vigencia. | Completar o corregir. | 03 o 05 |
| 03 | Permiso requerido | La condición necesita un permiso de Android. | Revisar y pedir el permiso. | 04 o 05 |
| 04 | Permiso denegado | La persona lo rechaza o Android no lo concede. | Abrir los ajustes o cambiar la condición. | 03, 02 o 06 |
| 05 | Revisión | Los datos mínimos están completos. | Confirmar o editar. | 07 o 02 |
| 06 | Salida voluntaria | La persona decide no continuar. | Descartar el borrador o volver. | 01 o 05 |
| **B. Vinculación y prueba física** | | | | |
| 07 | Buscando el testigo | Comienza la asociación física. | Esperar, reintentar o cancelar. | 08, 09 o 06 |
| 08 | Elegir y confirmar el testigo | Aparecen uno o más dispositivos. | Identificar y vincular el correcto. | 10 u 11 |
| 09 | Testigo incorrecto o no reconocido | El dispositivo no coincide o no responde. | Volver a buscar. | 07 |
| 10 | Batería baja | El testigo vinculado no asegura el ciclo. | Cargarlo o posponer. | 11 o 06 |
| 11 | Probar el lugar | El testigo está en el lugar elegido. | Emitir un pulso de prueba. | 12, 13 o 14 |
| 12 | Señal no percibida | La persona no detecta el pulso de prueba. | Ajustar la señal o reubicar. | 11 |
| 13 | Señal intrusiva | El pulso se percibe, pero interfiere con el contexto. | Reducir, reubicar o volver a probar. | 11 |
| 14 | Listo para armar | Lugar, enlace y pulso comprobados. | Armar de forma explícita. | 15 |
| **C. Armado** | | | | |
| 15 | Armando | Se pide armar el ciclo. | Esperar la confirmación o cancelar. | 16 o 17 |
| 16 | Armado | Android y el testigo confirman el ciclo. | Dejar el teléfono o desarmar. | 20 o 18 |
| 17 | Confirmación dudosa o fallo | No hay confirmación suficiente. | Reintentar, revisar el enlace o cancelar. | 15, 29 o 18 |
| 18 | Desarmado voluntario | La persona detiene el ciclo. | Cerrar o volver a preparar. | 01, 05 o 34 |
| 19 | Editar mientras está armado | Se intenta cambiar un ciclo activo. | Desarmar antes de editar o conservarlo. | 18, 02 o 20 |
| **D. Espera y señal** | | | | |
| 20 | Armado en espera | El ciclo está activo y la condición aún no ocurre. | Consultar el estado o desarmar. | 21, 18 o 33 |
| 21 | Condición cumplida | Android reconoce la condición dentro de la vigencia. | Enviar la orden al testigo. | 23 o 29 |
| 22 | Orden tardía o vencida | La orden llega fuera de la vigencia. | Cerrar sin pulso o preparar otro ciclo. | 33 o 34 |
| 23 | Señal activa | El testigo emite el único pulso. | Percibir y decidir libremente. | 24 o 25 |
| 24 | Silenciar, ignorar o seguir | La persona responde sin obligación de actuar. | Silenciar y cerrar; actuar queda fuera del registro. | 25 |
| **E. Cierre y recuperación** | | | | |
| 25 | Cierre | La persona decide terminar el ciclo. | Cerrar sin registrar cumplimiento. | 01 o 34 |
| 26 | Intención cambiada | La persona ya no quiere hacer lo que formuló. | Cerrar o reformular. | 01 o 02 |
| 27 | Permiso revocado | Android retira un permiso durante el ciclo. | Recuperar el permiso o cerrar. | 03, 18 o 33 |
| 28 | Restricción en segundo plano | Android no deja observar la condición con fiabilidad. | Ajustar la restricción o cerrar. | 20, 18 o 33 |
| 29 | Conexión perdida | Se corta el vínculo Bluetooth con el testigo. | Reconectar, reintentar o cerrar. | 20, 23 o 33 |
| 30 | Objeto movido | Cambia el lugar donde se probó la señal. | Repetir la prueba antes de seguir. | 11 |
| 31 | Batería crítica | La energía ya no asegura el pulso. | Cargar, desarmar o cerrar. | 10, 18 o 33 |
| 32 | Reinicio del objeto | El testigo pierde su estado por un momento. | Verificar el vínculo y volver a armar. | 07, 15 o 34 |
| 33 | Vencimiento sin señal | Termina la vigencia sin una señal válida. | Cerrar o preparar un ciclo nuevo. | 01 o 34 |
| 34 | Volver a armar | La persona quiere repetir un ciclo terminado. | Revisar y confirmar de nuevo. | 05 |
| 35 | Eliminar | La persona decide borrar el ciclo o el borrador. | Confirmar o cancelar. | 01 o el estado anterior |

*Nota.* Elaboración propia, agosto de 2026.

Los estados 01, 05, 08, 11, 14, 16, 20, 23 y 25 forman la ruta principal. Los demás no son una segunda experiencia: hacen visibles las bifurcaciones que vuelven el sistema comprensible y recuperable. Hay cinco tipos de ruta: la principal, la validación previa, la salida voluntaria, el fallo técnico y el estado límite.

## F.2 Láminas de agosto de 2026

**Figura F1**

*Las catorce láminas del recorrido con el testigo*

| A1 Configuración | A2 Configuración |
| --- | --- |
| ![A1 Configuración](imagenes/agosto-A1-configuracion.jpg) | ![A2 Configuración](imagenes/agosto-A2-configuracion.jpg) |

| B1a Vinculación | B1b Vinculación |
| --- | --- |
| ![B1a Vinculación](imagenes/agosto-B1a-vinculacion.jpg) | ![B1b Vinculación](imagenes/agosto-B1b-vinculacion.jpg) |

| B2a Prueba | B2b Prueba |
| --- | --- |
| ![B2a Prueba](imagenes/agosto-B2a-prueba.jpg) | ![B2b Prueba](imagenes/agosto-B2b-prueba.jpg) |

| C1 Armado | C2 Armado |
| --- | --- |
| ![C1 Armado](imagenes/agosto-C1-armado.jpg) | ![C2 Armado](imagenes/agosto-C2-armado.jpg) |

| D1 Espera | D2 Señal |
| --- | --- |
| ![D1 Espera](imagenes/agosto-D1-espera.jpg) | ![D2 Señal](imagenes/agosto-D2-senal.jpg) |

| E1 Cierre | E2 Recuperación |
| --- | --- |
| ![E1 Cierre](imagenes/agosto-E1-cierre.jpg) | ![E2 Recuperación](imagenes/agosto-E2-recuperacion.jpg) |

| E3 Recuperación | E4 Estados finales |
| --- | --- |
| ![E3 Recuperación](imagenes/agosto-E3-recuperacion.jpg) | ![E4 Estados finales](imagenes/agosto-E4-finales.jpg) |

*Nota.* Elaboración propia. Configuración, vinculación, prueba, armado, espera, señal, cierre y recuperación. Son copias livianas de las láminas 4K del repositorio.

## F.3 Wireframes de la app (octubre de 2026)

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

### 2026-11-08 — Anexo recopilado y listo para Word

- **Qué cambió:** la cobertura de agosto se presenta en una sola tabla de 35 estados, agrupada por fase, con sus seis reglas y la ruta principal; salen las referencias internas a Figma y a versiones antiguas de la memoria. Las láminas de agosto y los wireframes de octubre se numeran como Figuras F1 a F6. Desde ahora este archivo es la fuente del anexo.
- **Cómo estaba antes:** copiaba el anexo de cobertura del encargo 17, con cinco tablas, los nodos de Figma y la indicación de leerlo bajo la memoria v4.
- **Por qué:** el autor pidió revisar todos los anexos y dejarlos listos para Word: directos, sin sobreexplicar, con su forma de escribir y con lo más relevante (D-168).

### 2026-10-24 — Creación

- **Qué cambió:** el anexo se arma desde sus documentos fuente, con el resto de los anexos A–I de la memoria v5.
- **Cómo estaba antes:** la carpeta de anexos solo tenía un README de la v4, con cinco anexos y sin su contenido.
- **Por qué:** el autor pidió elegir un pendiente de prioridad alta y terminarlo; la memoria v5 remite a nueve anexos que no estaban armados.
