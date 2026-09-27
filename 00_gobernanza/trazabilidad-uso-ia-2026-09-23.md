# Trazabilidad del uso de IA en la investigación y el diseño de Relevo

**Estado:** reconstrucción documental parcial y formato de registro para las siguientes iteraciones. **Fecha de corte:** 23 de septiembre de 2026, revisión `fe416ca`. No se reconstruyen conversaciones completas que no estén conservadas en el repositorio.

## Texto utilizable en la memoria o en la defensa

«Durante el desarrollo de Relevo utilicé herramientas de IA generativa como apoyo para explorar composiciones visuales, redactar variantes, revisar consistencia entre documentos y organizar información. La herramienta recibió contexto explícito: la memoria, las entrevistas anonimizadas, los criterios de autonomía, los recorridos y las restricciones del objeto. Sus salidas fueron propuestas sometidas a selección, corrección o descarte. La definición del problema, las entrevistas y repreguntas, la elección de criterios, la selección de variantes y la responsabilidad por citas y conclusiones corresponden al autor. Las imágenes generadas se identifican como visualizaciones conceptuales, nunca como fotografías de un prototipo o evidencia de uso. Donde no se conserva el prompt literal, registro una síntesis y no finjo una transcripción».

Esta formulación se apoya en la [declaración histórica de IA de la memoria v1](../99_archivo/antiguo/memoria/memoria-v1.md#anexo-e-declaración-de-uso-de-inteligencia-artificial), la [procedencia de imágenes conceptuales](../99_archivo/fuentes-locales/semestre-2/proceso/visualizacion-y-entrega/procedencia-imagenes-conceptuales.md) y los [registros de producción de wireframes](../05_propuesta_phygital/wireframes-referencia-4k/registro-laminas-07-14.md). Para la memoria vigente, debe revisarse de nuevo contra el proceso realmente ejecutado hasta la entrega; este texto no demuestra por sí solo cada interacción con una herramienta.

## Cómo cambió el proceso de diseño

| Etapa documentada | Aporte de IA registrado | Control y decisión humana documentados | Límite de la evidencia |
| --- | --- | --- | --- |
| Imágenes conceptuales del 17 de agosto | Generación de siete visualizaciones para explicar objeto, contexto y flujos; el archivo histórico conserva propósito y síntesis de prompt por imagen. | El autor las incorporó como apoyo de comunicación y las distinguió de mapas vectoriales y prototipo construido. | No hay en esa ficha un prompt literal por cada imagen ni pruebas con personas. |
| Referencias visuales de estados 07–14 y 15–24 | Prompt base, restricciones, copias específicas y variantes raster para discutir y reconstruir en Figma. | Se descartaron salidas con forma inconsistente o conectores fuera de marco; se corrigió un botón que decía «Desarmar» antes de armar. | Son referencias de baja/media fidelidad, no interfaz final ni validación. |
| Investigación y redacción | Los archivos históricos declaran apoyo en búsqueda dirigida, consistencia y corrección editorial. | La memoria vigente, perfiles situacionales y criterios deben conservar evidencia, procedencia y revisión del autor. | No hay registro exhaustivo de prompts y respuestas de todas las conversaciones. No cuantificar horas ahorradas ni atribuir mejoras causales sin datos. |
| Revisión documental del 23 de septiembre | La petición inicial fue revisar el repositorio y desarrollar la parte escrita de las anotaciones. La IA ordenó notas, contrastó documentación y fuentes y redactó borradores. | Las anotaciones y el alcance son del autor; la primera iteración no implementó la app. | Ningún texto de esa fase aporta resultados con participantes. |
| Revisión de Android 2.5 del 23 de septiembre | El autor pidió aplicar el feedback a la app, con reconocimiento positivo sin culpa. Un agente revisó el repositorio y modificó tutorial, navegación, progreso y mensaje de Inicio; el agente principal auditó el código, corrigió la continuidad del código de participación, el consentimiento, el tiempo máximo y la documentación. | El autor fijó el criterio de tono y el correo y plazo de datos; las correcciones se seleccionaron por relación con el flujo real, no por aceptación automática de todas las notas. | La compilación y un recorrido parcial en emulador no sustituyen pruebas con personas, audio físico ni verificación de borrado. |
| Android 2.8 del 25 y 26 de septiembre | Claude Code programó el rediseño con D-073, el perfil, la ruta y el regreso; trató con la receta de D-073 las fotografías generadas antes y seis CC0; compiló, probó en emulador con datos ficticios y documentó. No generó imágenes nuevas. | El autor rechazó una primera versión sin fotos y fijó el objetivo: D-073, fotografías, más personalización y las pantallas que faltaban. Las decisiones de detalle quedan en D-082 para su revisión. | Compilación, 47 pruebas unitarias y recorrido en emulador; sin teléfono real ni personas. |
| Android 2.9 del 27 de septiembre | Claude Code revisó referentes (pautas de Liquid Glass de Apple, Laws of UX, transitions.dev) y la disponibilidad y licencia de los emoji Noto 3D de Google; programó el vidrio, las formas en cápsula, las hojas flotantes, el selector de emoji y los textos nuevos; probó en emulador y documentó. Los emoji son de Google, no se generaron. | El autor fijó el objetivo: pantalla completa, desenfoques sutiles sin brillo, bordes redondeados, solo iconos o emoji en el perfil, textos naturales y sin avisos de privacidad repetidos. Registrado como D-083. | Compilación, 50 pruebas unitarias y recorrido en emulador; sin teléfono real ni personas. |

Lo que puede sostenerse documentalmente es que la IA permitió **producir variantes y dejar rastros de descarte y corrección**. El repositorio no mide ahorro de tiempo ni permite afirmar que la IA mejoró la calidad de uso de Relevo: eso exigiría comparación y observación con personas. La responsabilidad académica tampoco se transfiere a la herramienta por haber escrito un borrador.

## Registro de prompts existentes

| Pieza | Prompt conservado | Uso, fin y resultado | Decisión atribuible |
| --- | --- | --- | --- |
| [Estados 07–14](../05_propuesta_phygital/wireframes-referencia-4k/registro-laminas-07-14.md#prompt-base-común) | Base redactada en español, más instrucciones específicas por lámina; algunas solicitudes están resumidas. | Producir láminas trazables para Figma; B2a y B2b se corrigieron tras auditoría. | El registro documenta selección y descarte de salidas; no atribuir a IA la aprobación final. |
| [Estados 15–24](../05_propuesta_phygital/wireframes-referencia-4k/registro-laminas-15-24.md#prompt-común) | Prompt base literal en inglés y especificaciones de C1, C2, D1 y D2. | Visualizar armado, espera, señal y respuestas; D1 recibió corrección focalizada. | La cobertura y las restricciones proceden de memoria y contrato visual; la generación ejecutó una propuesta. |
| [Imágenes conceptuales históricas](../99_archivo/fuentes-locales/semestre-2/proceso/visualizacion-y-entrega/procedencia-imagenes-conceptuales.md#contenido-migrado) | Síntesis por imagen; no prompt literal íntegro. | Ilustrar contextos y arquitectura del Encargo 16. | No reutilizar forma, paleta o funciones antiguas como dirección actual sin contraste con el [sistema de marca vigente](../10_recursos_visuales/14_sistema-de-marca-vigente.md). |

El prompt original de las siete fotografías de actividades predefinidas del prototipo Android 2.3 **no se localizó** en los documentos vigentes consultados. Su apariencia no permite reconstruirlo fielmente. Antes de generar nuevas imágenes, buscar el registro original fuera del repositorio o documentar la nueva instrucción como una iteración distinta, con su fecha, herramienta y resultado.

## Ficha obligatoria para futuras producciones con IA

Copiar una ficha por tarea o conjunto de variantes. Conservar el prompt literal cuando exista. Si solo se dispone de una reconstrucción, marcarla como **síntesis posterior**.

```text
ID, fecha y autor responsable:
Fase y pregunta de diseño:
Herramienta/modelo (si se conoce):
Tipo de uso: búsqueda / análisis / redacción / imagen / código / auditoría
Fuentes entregadas: archivo, versión, enlace y restricciones de privacidad
Prompt literal (o «síntesis posterior», nunca entrecomillada como original):
Resultado recibido: archivo/enlace, variantes y fecha
Revisión humana: fuentes comprobadas, errores, exclusiones, licencias, accesibilidad
Decisión del autor: adoptar / editar / descartar y motivo
Efecto en Relevo: documento/artefacto modificado y prueba pendiente
Límite: qué no demuestra la salida
```

No introducir transcripciones identificables de P1–P8, hojas firmadas, claves ni datos remotos en un prompt sin base de tratamiento, autorización y necesidad documentadas. Para explicar la evolución ante la comisión, mostrar un ejemplo **antes → prompt y contexto → salida → corrección humana → versión incorporada**, con el archivo del prompt y la decisión verificables. Los registros de B2a/B2b y D1 ofrecen ejemplos reales de esa secuencia.

## Registro de esta tarea

- **Entrada del autor:** lista de anotaciones del 23 de septiembre y corrección posterior que fijó `proyecto-titulo` de GitHub como único repositorio de contexto.
- **Contexto consultado:** `README.md`, directrices, memoria v4, perfiles P1–P8, requisitos, estado de Android 2.3, consentimiento, datos, diseño y registros de prompts. También se contrastaron fuentes primarias de ley, plataforma y estudios de hábitos.
- **Resultado de la primera revisión:** [síntesis de las anotaciones](../02_investigacion/sintesis-anotaciones-2026-09-23.md), [auditoría de privacidad](../07_validacion/privacidad-prototipo-android-2026-09-23.md) y esta trazabilidad.
- **Decisión no atribuida a la herramienta:** adoptar rachas, ampliar el piloto o cambiar la arquitectura del producto; esas opciones permanecen abiertas o incompatibles con criterios vigentes.

## Registro de la iteración Android 2.5

- **Pedido literal del autor:** «Este es el feedback de hoy, aplícalo a la app. [...] rachas quizás no pero sí felicitar al usuario, sin sentir culpa». La lista completa se consultó en el texto pegado en la conversación; su contenido se ordenó en la [síntesis de feedback](../02_investigacion/sintesis-anotaciones-2026-09-23.md).
- **Contexto entregado al agente:** repositorio, notas docentes y archivos de la app. La primera instrucción operativa se conserva solo como síntesis en este registro: corregir el regreso por pasos, tutorial, permiso, legibilidad, navegación y reconocimiento ligado a la respuesta voluntaria; no añadir perfiles, rachas ni datos nuevos. No se presenta como prompt literal íntegro.
- **Corrección literal enviada durante la revisión:** «Revisé el diff preliminar: en FloatingTabBar cambiaste Row a Column pero quedó `verticalAlignment = Alignment.CenterVertically` (parámetro de Row), probablemente no compila; corrígelo en tu build. También verifica que el gesto atrás no cierre la actividad desde página 0 de tutorial y que la confirmación de consentimiento muestre correo/fecha completos. Gracias».
- **Resultado comprobable:** [interfaz y lógica en Android 2.5](../06_desarrollo_y_factibilidad/app-android/README.md). Pasaron siete pruebas unitarias y la compilación; se inspeccionaron consentimiento y tutorial en emulador. El agente principal detectó y corrigió un código de participación que cambiaba al cerrar cada ciclo y un permiso que podía omitirse desde el tutorial.
- **Decisiones del autor:** reconocer sin culpa una respuesta voluntaria; no convertirla en éxito observado ni usar rachas. El autor confirmó `joan1542003@gmail.com` y el 30 de diciembre de 2026 como datos para el borrador de privacidad.
- **Lo que no se afirma:** que la IA probó la experiencia de uso, que la actividad ocurrió realmente, que el borrado remoto funciona o que la ruta de audio fue comprobada con el equipo final.

## Registro de la iteración Android 2.8

- **Fecha y herramienta:** 25 y 26 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5.
- **Pedidos literales del autor:** «quitaria la de agendar una reunion/entrevista. [...] el diseño es muy mejorable, quiero algo al nivel swift ui. ademas, hay nuevas diretrices de diseño, leelas»; después de ver una primera versión sin fotografías: «visualkmente era mejor antes, tenia imagenes, era mejor diseñado ,estilo ios16 / 26. Tenia imagenes, era mas personalizable, faltaban mas pantallas. por favor hazlo bien»; y por último: «debes ajustarlo al nuevo directrices de diseño que hicimos, lee le reposotorio. [...] debe estar a lla altura de las mejores aplicaicones del mercado. bue ndiseñlo, interacciones, animaciones.»
- **Contexto usado:** el repositorio (D-073 y su kit, el diseño escrito de flujos, el protocolo 02 y la app 2.7). No se entregaron datos de participantes.
- **Qué hizo la herramienta:** programó la app 2.8 (tema, componentes, navegación y animaciones; pantallas de perfil, ruta, regreso y ajustes; uso sin participar y descarga de datos), trató las imágenes existentes con la receta de D-073, escribió pruebas unitarias, recorrió la app en un emulador con datos ficticios, borró de Supabase las sesiones de prueba y redactó la documentación.
- **Decisiones del autor:** aplicar D-073 a la app, recuperar las fotografías, permitir más personalización, completar las pantallas y retirar la pregunta sobre la entrevista. Las decisiones de detalle que tomó la herramienta están en D-082, pendientes de su revisión.
- **Lo que no se afirma:** que la app funcione en el teléfono y el parlante de la prueba, ni que la nueva interfaz se entienda mejor o se prefiera: no hubo pruebas con personas.

## Registro de la iteración Android 2.9

- **Fecha y herramienta:** 26 y 27 de septiembre de 2026; Claude Code con el modelo Claude Opus 5.5.
- **Pedido literal del autor (fragmentos):** «"Solo lo ves tu, no sale del telefono" no creo necesari oestar diciendole constantemente al usaurio que su info es privada [...] el diseño es mejorahble, aun mas moderno, con blur, pantalla completa. Bordes redondeados, algo al estilo de iOS 26 sin recurrir a "brillo" sino a esas trasnaprencias hermosas y con desenfoques sutiles. Las fotos del eprfil del usaurio deberian ser solo iconos, puedes crear iconos, o emojis (google lanzo recientemente emojsi en3d que podrian servirnos) [...] Debe estar perfectamente diseñado, ser hermoso, pero facil de usar, sin sobrediseñar ni sobre explicar. perfecciona la interfaz de cada pantalla. y nada de bloques cuadrados.»
- **Fuentes consultadas por la herramienta:** Laws of UX, transitions.dev y React Bits, que el autor recomendó; videos y resúmenes de Liquid Glass de Apple; el blog de Google y el repositorio googlefonts/noto-emoji, para confirmar la publicación de los emoji 3D y su licencia.
- **Qué hizo la herramienta:** programó el vidrio de la capa de navegación con Haze, el marco de pantalla a sangre, la barra de pestañas flotante, las hojas de vidrio, los controles en cápsula, las marcas redondas, el catálogo de 24 emoji con equivalencias para las imágenes antiguas y los textos nuevos; escribió una prueba unitaria; recorrió la app en emulador, respaldando y restaurando los datos de prueba del autor; borró de Supabase la sesión de prueba, y documentó la versión.
- **Decisiones del autor:** las de D-083. La selección concreta de emoji y los textos nuevos son propuestas de la herramienta, pendientes de su revisión.
- **Lo que no se afirma:** que la nueva interfaz se entienda mejor o se prefiera, ni que el desenfoque sea fluido en el teléfono de la prueba.

## Registro de cambios (disclaimer)

### 2026-09-27 — Iteración Android 2.9

- **Qué cambió:** se añadieron una fila y un registro de la iteración Android 2.9, con el pedido literal del autor, las fuentes consultadas, lo que hizo la herramienta y lo que no se afirma.
- **Antes:** el registro llegaba hasta la iteración Android 2.8.
- **Por qué:** mantener trazable qué hizo la IA y qué decidió el autor.

### 2026-09-26 — Iteración Android 2.8

- **Qué cambió:** se añadieron una fila y un registro de la iteración Android 2.8, con los pedidos literales del autor, lo que hizo la herramienta y lo que no se afirma.
- **Antes:** el registro llegaba hasta la iteración Android 2.5.
- **Por qué:** mantener trazable qué parte del trabajo hizo la IA y qué decidió el autor.

### 2026-09-23 — Implementación Android 2.5

- **Qué cambió:** se separó la revisión documental de la iteración de código, se registró un prompt de corrección literal y se atribuyeron decisiones y verificaciones.
- **Antes:** el documento decía que la tarea del día no modificaba la app, porque describía únicamente la primera revisión escrita.
- **Por qué:** dejar una historia verificable del proceso sin atribuir al autor o a la herramienta trabajo que no hicieron ni inventar prompts perdidos.

### 2026-09-23 — Creación

- **Qué cambió:** se reunió evidencia dispersa sobre IA, se propuso un texto de declaración y una ficha de trazabilidad para nuevos prompts.
- **Antes:** existían registros por pieza e informes históricos, pero no una lectura de proceso que distinguiera contexto, salida y decisión del autor para la etapa actual.
- **Por qué:** permitir explicar a la comisión cómo se usó la herramienta sin inventar prompts ni confundir generación con autoría o validación.
- **Alcance:** reconstrucción parcial; debe actualizarse con registros originales que el autor conserve fuera del repositorio y revisarse antes de la entrega final.
