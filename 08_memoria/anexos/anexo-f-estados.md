# Anexo F. Estados del ciclo y wireframes

> Parte de los [anexos de la memoria](README.md). Se genera con `node construir-anexos.js` desde sus documentos fuente: para corregirlo, se corrige la fuente y se vuelve a generar.

Muestra cómo se diseñó el recorrido completo. Primero, la cobertura de 35 estados definida en agosto de 2026 para un testigo con control físico, con sus wireframes. Después, los wireframes de las 39 pantallas de la app de octubre, ordenados por recorrido.

## F.1 Cobertura de los estados del ciclo

### Propósito

Este anexo amplía el tablero evaluable de nueve marcos sin reemplazarlo. Su función es comprobar que el ciclo mínimo de Relevo pueda representarse desde el inicio hasta su cierre, incluyendo validaciones, decisiones voluntarias, fallos técnicos y estados límite.

- **Figma:** [Anexo · Cobertura de estados](https://www.figma.com/design/kjzrPcLGWfoJZAVANivEo4?node-id=13-2)
- **Página:** `13:2`.
- **Tablero:** `13:3`.
- **Referencias detalladas para calcar:** [catorce láminas 4K con los 35 estados](../../05_propuesta_phygital/wireframes-referencia-4k/README.md).

La cobertura se construyó respecto del ciclo mínimo documentado entonces en la memoria v2. Para cualquier revisión posterior debe interpretarse bajo la [memoria v4](../memoria-vigente-v4.md), no como autorización para agregar funciones futuras. Cada estado tiene un wireframe independiente para poder revisarlo; esto no significa que la persona deba mirar el teléfono durante todo el recorrido. En uso, el pulso situado del testigo conserva el papel central y Android se limita a configurar, informar estado y facilitar recuperación.

### Reglas que delimitan la cobertura

- Un ciclo contiene una intención, un primer paso, una condición provisional, un testigo y un pulso.
- La persona puede continuar, ignorar, silenciar, modificar, desarmar o cerrar sin que el sistema juzgue su conducta.
- Relevo no bloquea aplicaciones, no infiere estados subjetivos y no registra cumplimiento.
- Una decisión personal distinta de la intención inicial es una salida válida, no un error.
- Después del cierre, vencimiento, silencio o desarmado no existe rearme automático.
- Los fallos se comunican como estados técnicos recuperables y no como incumplimientos.

### Matriz de wireframes

#### A. Configuración

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 01 | Sin configurar | No existe un ciclo activo. | Crear una intención. | 02 |
| 02 | Datos incompletos | Falta intención, primer paso, condición o vigencia. | Completar o corregir. | 03 o 05 |
| 03 | Permiso requerido | La condición necesita un permiso de Android. | Revisar y solicitar permiso. | 04 o 05 |
| 04 | Permiso denegado | La persona rechaza o Android no concede el permiso. | Abrir ajustes o cambiar condición. | 03, 02 o 06 |
| 05 | Revisión | Los datos mínimos están completos. | Confirmar preparación o editar. | 07 o 02 |
| 06 | Salida voluntaria | La persona decide no continuar. | Descartar borrador o volver. | 01 o 05 |

#### B. Vinculación y prueba física

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 07 | Buscando testigo | Comienza la asociación física. | Esperar, reintentar o cancelar. | 08, 09 o 06 |
| 08 | Elegir y confirmar testigo | Se encuentra uno o más dispositivos. | Identificar y vincular el correcto. | 10 u 11 |
| 09 | Testigo incorrecto o no reconocido | El dispositivo no coincide o no responde. | Volver a buscar. | 07 |
| 10 | Batería baja | El testigo vinculado no asegura el ciclo. | Cargarlo o posponer. | 11 o 06 |
| 11 | Probar lugar | El testigo se ubica en el lugar elegido. | Emitir pulso de prueba. | 12, 13 o 14 |
| 12 | Señal no percibida | La persona no detecta el pulso de prueba. | Ajustar señal o reubicar. | 11 |
| 13 | Señal intrusiva | El pulso se percibe, pero interfiere con el contexto. | Reducir, reubicar o volver a probar. | 11 |
| 14 | Listo para armar | Lugar, enlace y pulso fueron comprobados. | Iniciar armado explícito. | 15 |

#### C. Armado

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 15 | Vinculando o armando | Se solicita el armado. | Esperar confirmación o cancelar. | 16 o 17 |
| 16 | Armado | Android y testigo confirman el ciclo activo. | Dejar el teléfono o desarmar. | 20 o 18 |
| 17 | Confirmación ambigua o fallo | No existe confirmación suficiente del armado. | Reintentar, revisar enlace o cancelar. | 15, 29 o 18 |
| 18 | Desarmado voluntario | La persona detiene el ciclo. | Cerrar o volver a preparar. | 01, 05 o 34 |
| 19 | Editar mientras está armado | Se intenta cambiar un ciclo activo. | Desarmar antes de editar o conservarlo. | 18, 02 o 20 |

#### D. Espera y señal

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 20 | Armado en espera | El ciclo está activo y la condición aún no ocurre. | Consultar estado o desarmar. | 21, 18 o 33 |
| 21 | Condición cumplida y orden válida | Android reconoce la condición provisional dentro de la vigencia. | Enviar la orden al testigo. | 23 o 29 |
| 22 | Orden tardía o expirada | La orden llega fuera de la vigencia definida. | Cerrar sin pulso o preparar otro ciclo. | 33 o 34 |
| 23 | Señal física activa | El testigo emite el único pulso situado. | Percibir y decidir libremente. | 24 o 25 |
| 24 | Silenciar, ignorar o continuar | La persona responde al pulso sin obligación de actuar. | Silenciar y cerrar; actuar queda fuera del registro. | 25 |

#### E. Cierre y recuperación

| N.º | Estado | Disparador | Acción o salida principal | Continuidad |
| --- | --- | --- | --- | --- |
| 25 | Intención cumplida o cierre | La persona decide terminar el ciclo. | Cerrar sin registrar cumplimiento. | 01 o 34 |
| 26 | Intención cambiada | La persona ya no desea realizar lo formulado. | Cerrar o reformular. | 01 o 02 |
| 27 | Permiso revocado | Android retira un permiso durante el ciclo. | Recuperar permiso o cerrar. | 03, 18 o 33 |
| 28 | Restricción en segundo plano | Android impide observar la condición con fiabilidad. | Ajustar la restricción o cerrar. | 20, 18 o 33 |
| 29 | Pérdida de BLE o reconexión | Se interrumpe el vínculo con el testigo. | Reconectar, reintentar o cerrar. | 20, 23 o 33 |
| 30 | Objeto movido | Cambia el lugar cuya percepción fue probada. | Repetir prueba antes de continuar. | 11 |
| 31 | Batería crítica | La energía deja de asegurar la entrega del pulso. | Cargar, desarmar o cerrar. | 10, 18 o 33 |
| 32 | Reinicio del objeto | El testigo pierde temporalmente su estado. | Verificar vínculo y rearmar explícitamente. | 07, 15 o 34 |
| 33 | Vencimiento sin activación | Termina la vigencia sin una señal válida. | Cerrar o preparar un nuevo ciclo. | 01 o 34 |
| 34 | Rearme explícito | La persona desea repetir un ciclo terminado. | Revisar y confirmar nuevamente. | 05 |
| 35 | Eliminar configuración | La persona decide borrar el ciclo o borrador. | Confirmar eliminación o cancelar. | 01 o estado anterior |

### Criterio de lectura

Las pantallas 01, 05, 08, 11, 14, 16, 20, 23 y 25 forman la ruta principal. Las demás no componen una segunda experiencia: hacen visibles las bifurcaciones necesarias para que el sistema sea comprensible y recuperable. El anexo distingue cinco tipos de ruta: principal, validación previa, salida voluntaria, fallo técnico y estado límite.

## F.2 Wireframes de agosto de 2026

Catorce láminas del recorrido con el testigo y su control físico: configuración, vinculación, prueba, armado, espera, señal, cierre y recuperación.

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

## F.3 Wireframes de la app (octubre de 2026)

Las 39 pantallas de la versión 2.32 en muy baja fidelidad, con sus textos reales, en cinco recorridos. Se dibujaron pieza por pieza sobre una retícula común, a partir de la posición de cada elemento en el emulador.

**1. La primera vez**

![1. La primera vez](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/1-primera-vez.png)

**2. Preparar un relevo**

![2. Preparar un relevo](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/2-preparar-un-relevo.png)

**3. Contar, sonar y decidir**

![3. Contar, sonar y decidir](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/3-contar-sonar-y-decidir.png)

**4. Inicio, ruta y perfil**

![4. Inicio, ruta y perfil](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/4-inicio-ruta-y-perfil.png)

**5. Perfil**

![5. Perfil](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/5-perfil.png)

## Registro de cambios (disclaimer)

### 2026-10-24 — Creación

- **Qué cambió:** el anexo se arma desde sus documentos fuente, con el resto de los anexos A–I de la memoria v5.
- **Cómo estaba antes:** la carpeta de anexos solo tenía un README de la v4, con cinco anexos y sin su contenido.
- **Por qué:** el autor pidió elegir un pendiente de prioridad alta y terminarlo; la memoria v5 remite a nueve anexos que no estaban armados.
