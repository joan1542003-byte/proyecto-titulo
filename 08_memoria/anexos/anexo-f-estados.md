# Anexo F. Estados del ciclo y *wireframes*

Antes de llamarse Relevo, el proyecto pasó por otros conceptos, desde In(Visible), y este anexo los muestra primero. Después, el recorrido de Relevo se diseñó dos veces. En agosto de 2026 fue un ciclo de estados que debía funcionar de principio a fin, también cuando algo falla; en octubre, las pantallas de la app que se usó en la prueba. Este anexo muestra los dos momentos: los 35 estados del ciclo con sus *wireframes*, y los bocetos del primer uso con los *wireframes* de las 39 pantallas de la app, ordenados por recorrido. Al final muestra cómo quedó la app después de la prueba, con 18 capturas de la versión 4.7.2; la 4.8 cambió solo los íconos (Anexo H).

## F.1 Estados del ciclo

En agosto, antes de que el prototipo usara el Tag, el objeto se pensaba con un control propio. Para comprobar que el ciclo podía representarse completo —con sus validaciones, sus decisiones voluntarias, sus fallos técnicos y sus estados límite—, cada estado tuvo su *wireframe*. Eso no significa que la persona mire el teléfono durante todo el recorrido: lo central es la señal del objeto, y la app sirve para configurar, informar el estado y recuperarse de un fallo. En estos *wireframes*, “armar” es activar un relevo, y el “pulso” es la señal.

El ciclo se rige por seis reglas:

- Un ciclo tiene una intención, un primer paso, una condición, un objeto y una señal.
- La persona puede seguir, ignorar, silenciar, modificar, desarmar o cerrar, sin que el sistema juzgue lo que hace.
- Relevo no bloquea apps, no infiere estados de ánimo y no registra cumplimiento.
- Decidir algo distinto de la intención inicial es una salida válida, no un error.
- Después de un cierre, un vencimiento, un silencio o un desarme, nada se vuelve a armar solo.
- Los fallos se comunican como estados técnicos recuperables, no como incumplimientos.

Con esas reglas, los 35 estados se agrupan por fase, de la configuración al cierre (Tabla F1).

**Tabla F1**

*Estados del ciclo*

| Estado | Momento en que ocurre | Acciones posibles |
| --- | --- | --- |
| **Configuración** |  |  |
| Sin configurar | No hay un ciclo activo. | Crear una intención. |
| Datos incompletos | Falta la intención, el primer paso, la condición o la vigencia. | Completar o corregir. |
| Permiso requerido | La condición necesita un permiso de Android. | Revisar y pedir el permiso. |
| Permiso denegado | La persona lo rechaza o Android no lo concede. | Abrir los ajustes o cambiar la condición. |
| Revisión | Los datos mínimos están completos. | Confirmar o editar. |
| Salida voluntaria | La persona decide no continuar. | Descartar el borrador o volver. |
| **Vinculación y prueba física** |  |  |
| Buscando el objeto | Comienza la asociación física. | Esperar, reintentar o cancelar. |
| Elegir y confirmar el objeto | Aparecen uno o más dispositivos. | Identificar y vincular el correcto. |
| Objeto incorrecto o no reconocido | El dispositivo no coincide o no responde. | Volver a buscar. |
| Batería baja | El objeto vinculado no asegura el ciclo. | Cargarlo o posponer. |
| Probar el lugar | El objeto ya está en su lugar. | Emitir un pulso de prueba. |
| Señal no percibida | La persona no detecta el pulso de prueba. | Ajustar la señal o reubicar. |
| Señal intrusiva | El pulso se percibe, pero interfiere con el contexto. | Reducir, reubicar o volver a probar. |
| Listo para armar | Lugar, enlace y pulso comprobados. | Armar de forma explícita. |
| **Armado** |  |  |
| Armando | Se pide armar el ciclo. | Esperar la confirmación o cancelar. |
| Armado | Android y el objeto confirman el ciclo. | Dejar el teléfono o desarmar. |
| Confirmación dudosa o fallo | No hay confirmación suficiente. | Reintentar, revisar el enlace o cancelar. |
| Desarmado voluntario | La persona detiene el ciclo. | Cerrar o volver a preparar. |
| Editar mientras está armado | Se intenta cambiar un ciclo activo. | Desarmar antes de editar o conservarlo. |
| **Espera y señal** |  |  |
| Armado en espera | El ciclo está activo y la condición aún no ocurre. | Consultar el estado o desarmar. |
| Condición cumplida | Android reconoce la condición dentro de la vigencia. | Enviar la orden al objeto. |
| Orden tardía o vencida | La orden llega fuera de la vigencia. | Cerrar sin pulso o preparar otro ciclo. |
| Señal activa | El objeto emite el único pulso. | Percibir y decidir libremente. |
| Silenciar, ignorar o seguir | La persona responde sin obligación de actuar. | Silenciar y cerrar; actuar queda fuera del registro. |
| **Cierre y recuperación** |  |  |
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

La ruta principal pasa por nueve estados: sin configurar, revisión, elegir y confirmar el objeto, probar el lugar, listo para armar, armado, armado en espera, señal activa y cierre. Los demás no son una segunda experiencia: muestran las bifurcaciones que hacen el sistema comprensible y recuperable. En total hay cinco tipos de ruta —la principal, la validación previa, la salida voluntaria, el fallo técnico y el estado límite—, y la Figura F3 los recorre en *wireframes*.

## F.2 Los primeros conceptos (marzo a julio de 2026)

Antes de llamarse Relevo, el proyecto se llamó In(Visible). En el Seminario de Título, de marzo a junio de 2026, abordaba la *amnesia del ocio digital*: horas de entretenimiento en el teléfono que después no se recuerdan como propias y dejan culpa. La propuesta era un objeto *phygital* de registro pasivo, una base donde la persona dejaba el teléfono al llegar a su espacio de descanso y que, al retirarlo, le mostraba su registro (Figura F1).

**Figura F1**

*Recorrido de In(Visible), primer semestre de 2026*

![Recorrido de In(Visible)](imagenes/conceptos-invisible-recorrido.png)

*Nota.* Elaboración propia, primer semestre de 2026.

En julio, al cerrar el semestre, el proyecto ya se llamaba Relevo y había cambiado de foco: en vez de alejar el teléfono, buscaba que las intenciones propias volvieran a la decisión durante el ocio digital. Se compararon tres propuestas —una pausa en el teléfono, preparar el entorno antes del ocio y una pausa con apoyo físico— y se eligió la tercera, que unía la app con un objeto en el lugar (Figura F2).

**Figura F2**

*Tres propuestas del cierre del primer semestre*

![Tres propuestas del cierre del primer semestre](imagenes/conceptos-julio-tres-propuestas.png)

*Nota.* Elaboración propia, julio de 2026. Se eligió la propuesta C.

## F.3 *Wireframes* de agosto de 2026

**Figura F3**

*Recorrido del ciclo en *wireframes*, agosto de 2026*

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

## F.4 La primera versión de la app

Antes de los *wireframes* de octubre, la app tuvo una primera versión, en oscuro, que llamaba *testigo* al objeto y probaba su pulso antes de armar el ciclo. Dos de sus pantallas muestran cómo se formulaba la intención, con su primer paso, y cómo llegaba la señal desde el lugar (Figura F4).

**Figura F4**

*Dos pantallas de la primera versión de la app*

| Formular la intención | Señal situada |
| --- | --- |
| ![Formular la intención](imagenes/app-primera-version-formular.png) | ![Señal situada](imagenes/app-primera-version-senal.png) |

*Nota.* Elaboración propia, anterior a octubre de 2026.

## F.5 *Wireframes* de la app (octubre de 2026)

En octubre, el recorrido ya era una app. Antes de dibujar sus *wireframes*, el primer uso se bocetó a mano en tres pantallas: una bienvenida que da contexto; los términos y condiciones, obligatorios porque la app usa datos, y el perfil, con nombre, intereses, foto y tal vez un color (Figura F5).

**Figura F5**

*Bocetos del primer uso*

![Bocetos del primer uso](imagenes/pase-F2-bocetos-del-primer-uso.jpg)

*Nota.* Elaboración propia.

En los *wireframes*, los términos pasaron a ser el consentimiento de la prueba, y la foto, un emoji (Figura F6). Son las 39 pantallas de la app que se usó en la prueba, en muy baja fidelidad y con sus textos reales, en cinco recorridos: el primer uso, la preparación de un relevo, el conteo con la señal y la decisión, las tres pestañas de la app y el perfil (Figuras F6 a F7). Se dibujaron sobre una retícula común, con cada elemento en la posición que tenía en la app.

**Figura F6**

*Primer uso*

![La primera vez](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/1-primera-vez.png)

**Figura F7**

*Preparación de un relevo*

![Preparar un relevo](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/2-preparar-un-relevo.png)

**Figura F8**

*Conteo, señal y decisión*

![Contar, sonar y decidir](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/3-contar-sonar-y-decidir.png)

**Figura F9**

*Inicio, ruta y perfil*

![Inicio, ruta y perfil](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/4-inicio-ruta-y-perfil.png)

**Figura F10**

*Perfil*

![Perfil](../../06_desarrollo_y_factibilidad/relevo-como-sistema-2026-10-18/wireframes-png/hojas/5-perfil.png)

*Nota.* Elaboración propia, a partir de las pantallas de la app que se usó en la prueba, en octubre de 2026.

## F.6 Pantallas de la aplicación 4.7.2

Después de la prueba, la app siguió cambiando: el 5 de noviembre de 2026 llegó el rediseño, y el 9, la versión 4.7.2 (Anexo G). Desde la 4.8, del 22 de noviembre, los íconos salen de Lucide (Anexo H); las pantallas no cambiaron. Dieciocho capturas la recorren en el orden de su uso: el primer uso y los seis pasos con que se prepara un relevo (Figura F11); el conteo del tiempo, la señal, las preguntas, la decisión y el cierre de la prueba, hasta volver a Inicio (Figura F12), y el perfil y los ajustes (Figura F13).

**Figura F11**

*Primer uso y preparación de un relevo*

| Bienvenida | Consentimiento | Actividad (1 de 6) | Primer paso (2 de 6) |
| --- | --- | --- | --- |
| ![Bienvenida](imagenes/app-4.7.2-pantalla-01-bienvenida.jpg) | ![Consentimiento](imagenes/app-4.7.2-pantalla-02-consentimiento.jpg) | ![Actividad (1 de 6)](imagenes/app-4.7.2-pantalla-03-que-quieres-hacer.jpg) | ![Primer paso (2 de 6)](imagenes/app-4.7.2-pantalla-04-como-empiezas.jpg) |

| Lugar (3 de 6) | Cuándo suena (4 de 6) | Dónde suena (5 de 6) | Todo listo (6 de 6) |
| --- | --- | --- | --- |
| ![Lugar (3 de 6)](imagenes/app-4.7.2-pantalla-05-en-que-lugar.jpg) | ![Cuándo suena (4 de 6)](imagenes/app-4.7.2-pantalla-06-cuando-suena.jpg) | ![Dónde suena (5 de 6)](imagenes/app-4.7.2-pantalla-07-donde-suena.jpg) | ![Todo listo (6 de 6)](imagenes/app-4.7.2-pantalla-08-todo-listo.jpg) |

*Nota.* Capturas de la versión 4.7.2, tomadas el 10 de noviembre de 2026 en un teléfono Android emulado, con un perfil de prueba y datos inventados. El relevo de ejemplo, “Leer”, suena en el teléfono tras 15 minutos en Chrome.

**Figura F12**

*Conteo, señal, decisión y cierre*

| Inicio mientras cuenta | Señal | Cuatro preguntas | Decisión |
| --- | --- | --- | --- |
| ![Inicio mientras cuenta](imagenes/app-4.7.2-pantalla-09-inicio-contando.jpg) | ![Señal](imagenes/app-4.7.2-pantalla-10-volver-a-elegir.jpg) | ![Cuatro preguntas](imagenes/app-4.7.2-pantalla-11-cuatro-preguntas.jpg) | ![Decisión](imagenes/app-4.7.2-pantalla-12-que-decidiste.jpg) |

| Cierre de la prueba | Semanas con el Tag | Entrevista final | Inicio después del relevo |
| --- | --- | --- | --- |
| ![Cierre de la prueba](imagenes/app-4.7.2-pantalla-13-cierre-de-la-prueba.jpg) | ![Semanas con el Tag](imagenes/app-4.7.2-pantalla-14-cierre-semanas-con-el-tag.jpg) | ![Entrevista final](imagenes/app-4.7.2-pantalla-15-entrevista-final.jpg) | ![Inicio después del relevo](imagenes/app-4.7.2-pantalla-16-inicio-preparar-de-nuevo.jpg) |

*Nota.* Capturas de la versión 4.7.2, con el mismo perfil de prueba. Para mostrar el cierre de la prueba se usó una copia de la app marcada como la de alguien que ya usaba Relevo; de las cinco partes del cierre se ven la primera y la cuarta.

**Figura F13**

*Perfil y ajustes*

| Perfil | Ajustes |
| --- | --- |
| ![Perfil](imagenes/app-4.7.2-pantalla-17-perfil.jpg) | ![Ajustes](imagenes/app-4.7.2-pantalla-18-ajustes.jpg) |

*Nota.* Capturas de la versión 4.7.2, con el mismo perfil de prueba. Ajustes muestra cuántas partes del cierre de la prueba faltan.

## Registro de cambios (disclaimer)

### 2026-11-25 — Comillas

- **Qué cambió:** las comillas angulares pasan a “ ”.
- **Cómo estaba antes:** el anexo usaba comillas angulares.
- **Por qué:** el autor pidió evitarlas en la memoria y sus anexos.

### 2026-11-25 — Los primeros conceptos

- **Qué cambió:** se suma F.2, con In(Visible), el concepto del primer semestre (Figura F1), y las tres propuestas del cierre de julio (Figura F2), y F.4, con dos pantallas de la primera versión de la app (Figura F4). Las demás secciones y figuras se renumeran: F.3 a F.6 y F3 a F13. La introducción y F.6 dicen que la 4.8 cambió solo los íconos.
- **Cómo estaba antes:** el anexo empezaba en los *wireframes* de agosto, tenía diez figuras y llamaba a la 4.7.2 la versión más reciente.
- **Por qué:** el autor pidió poner en los anexos los primeros conceptos de Relevo, de cuando se llamaba Invisible, y un par de *wireframes* viejos.

### 2026-11-24 — Pantallas de la versión 4.7.2

- **Qué cambió:** se suma «F.4 Pantallas de la aplicación 4.7.2», con las 18 [capturas de la versión 4.7.2](../../06_desarrollo_y_factibilidad/app-android/capturas/interfaz-4.7.2/README.md) en el orden del recorrido, cada una con su pie, en tres figuras: F8, primer uso y preparación de un relevo; F9, conteo, señal, decisión y cierre, y F10, perfil y ajustes. La introducción del anexo y la de F.4 las anuncian. Las capturas se copiaron a `imagenes/` (`app-4.7.2-pantalla-01-bienvenida.jpg` a `app-4.7.2-pantalla-18-ajustes.jpg`) como JPG de 540 × 1200, igual que las demás capturas de la app; los PNG originales siguen en su carpeta. Van cuatro por fila, para que cada figura de ocho pantallas quepa en una página, y perfil y ajustes, dos.
- **Cómo estaba antes:** el anexo terminaba en los *wireframes* de octubre (Figura F7) y no mostraba la app actual; solo el Anexo G tenía siete de sus pantallas.
- **Por qué:** el autor pidió agregar todas las pantallas de la app, y la versión vigente es la 4.7.2.

### 2026-11-18 — Texto del PDF de anexos del Pase

- **Qué cambió:** el texto pasó a ser el del PDF de anexos del Pase: cambiaron 11 de sus 61 párrafos, ítems y filas de tabla. Se suma la Figura F2, «Bocetos del primer uso», y los *wireframes* de octubre pasan a ser las Figuras F3 a F7. En el PDF esas hojas aparecen recortadas, sin su título ni sus rótulos; aquí se enlazan las hojas completas, con los mismos dibujos. El texto se copió tal como está en el PDF, con sus erratas; los errores y las mejoras están en la [tarea 15 de Por hacer](../../00_gobernanza/por-hacer.md#15-errores-y-mejoras-de-la-memoria-y-los-anexos-del-pase).
- **Cómo estaba antes:** este Markdown tenía la versión del 10 de noviembre; el texto siguió cambiando fuera del repositorio hasta el PDF del Pase, que entregó el autor el 18 de noviembre.
- **Por qué:** el autor pidió que el repositorio coincida con la memoria y los anexos en PDF del Pase, con sus errores.

### 2026-11-09 — Títulos formales

- **Qué cambió:** los títulos de la sección F.1, de la Tabla F1, de sus columnas y de las figuras son formales («Primer uso», «Conteo, señal y decisión»).
- **Cómo estaba antes:** decían «Los 35 estados del ciclo», «La primera vez» o «Contar, sonar y decidir».
- **Por qué:** el autor pidió títulos formales: sin artículo al comienzo ni segunda persona (D-172).

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
