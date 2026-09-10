# Revisión y limpieza de textos — 9 de septiembre de 2026

## Resultado y alcance

La revisión corrigió estados desactualizados, redundancias, enlaces y explicaciones ambiguas. La memoria conserva **15.033 palabras de texto académico**, sus catorce capítulos, 42 subtítulos temáticos y 52 referencias. La bibliografía y el registro administrativo se excluyen del objetivo aproximado de 15.000 palabras.

Por instrucción del autor, este cierre se limita a documentación. No incorpora cambios en wireframes, imágenes, video, código ni herramientas de exportación. Las versiones visuales anteriores se identifican por su fecha y función; no se presentan como copias de la memoria actual.

El inventario inicial comprende **1.214 archivos versionados y 355 documentos Markdown**. Los controles de estructura recorrieron todos esos textos, incluidos índices, entregas y archivo histórico. La revisión editorial se concentró en las fuentes que gobiernan el proyecto y en las contradicciones detectadas por esos controles. Esto no equivale a una nueva lectura completa de todos los libros, artículos o documentos originales citados.

## Correcciones por área

| Área | Qué se corrigió | Fuente responsable |
| --- | --- | --- |
| Decisiones | D-053–D-055 estaban intercaladas después de D-014. Se ordenó la secuencia, se reunieron los dos historiales y se precisaron decisiones sustituidas. D-021 tenía un estado ajeno a su tema; el presupuesto de D-028 era histórico. | [Registro de decisiones](../09_decisiones/registro-de-decisiones.md) |
| Usuarios | La tipología y sus entregables autónomos todavía aparecían parcialmente como trabajo futuro. El índice ahora enlaza perfiles, recorridos y requisitos existentes. | [Usuarios](../03_usuarios/README.md) |
| Ruta de trabajo | Se retiraron de la ruta pendiente los wireframes ya cerrados. El control del banco al 12 de septiembre se alineó con la Issue #9; el reclutamiento quedó condicionado al piloto técnico. | [Hoja de ruta](hoja-de-ruta.md) y [plan de cierre](plan-de-cierre-agosto-diciembre-2026.md) |
| Comunicación | Se simplificaron títulos, se corrigió el relato de cinco minutos para que sume 300 segundos y se distinguieron hipótesis, canales seleccionados y alcance del aviso comparativo. | [Guía de comunicación](guia-comunicacion-relevo.md) |
| Resúmenes | Se redujo la repetición del calendario y se actualizaron fuentes rectoras y extensión. Se corrigió una mención a un banco «construido»: existe un programa compilado, sin ejecución física acreditada. | [Resumen general](resumen-general-del-proyecto.md) y [resumen de la memoria](../08_memoria/resumen-vigente-proyecto.md) |
| Bibliografía y enlaces | Se reparó la ruta oficial de vinculación Android y dos vínculos mal formados de Focusaur. Se añadieron vías de consulta y erratas junto a fuentes históricas. | [Memoria](../08_memoria/memoria-vigente-v4.md), [mercado](../04_mercado_y_referentes/README.md) y notas archivísticas |
| Entregas fechadas | Se distinguió la entrega del 2 de septiembre de la línea base posterior. La explicación del objeto movido dejó de sugerir detección automática. | [Entrega del 2 de septiembre](../00_admin/encargos/encargo-02-09-2026/README.md) |
| Documentación visual | La maqueta de 87 páginas quedó identificada como anterior al texto del 9 de septiembre. Se rectificó la supuesta actualización cromática del video y la condición de una referencia descartada. | [Índice de recursos](../10_recursos_visuales/README.md) |
| Instrucciones | Se registró el alcance textual solicitado y se reunió el historial de la guía auxiliar, que interrumpía sus propias instrucciones. | [Instrucciones maestras](../INSTRUCCIONES_CHATGPT.md) |

## Qué significa limpiar el repositorio

Se retiraron repeticiones de estado y se reunieron historiales fragmentados. No se encontraron documentos Markdown idénticos, archivos versionados vacíos ni cachés de sistema dentro del inventario inicial. Por eso no se eliminaron fuentes por su antigüedad ni se borraron entregas para reducir el número de archivos.

Las copias de imágenes que cumplen funciones distintas —fuente, entrega fechada o respaldo— se mantienen. Los originales del corpus P1–P8, las referencias de trabajo, el protocolo y sus instrumentos conservan su contenido. Un antecedente con una errata recibe una nota visible; la corrección no se inserta como si hubiera pertenecido al documento entregado originalmente.

## Errata bibliográfica del archivo histórico

Tres documentos de E09 y E11 atribuían *Exploration and Explanation in Data-Driven Storytelling* a Thudt, Hinrichs y Carpendale (2020), como artículo de IEEE con DOI `10.1109/TVCG.2019.2934809`. Esa combinación no corresponde a la obra identificada y el DOI citado no se recuperó. La auditoría E09 incluso la marcaba como verificada; esa marca histórica no debe reutilizarse como certificación.

Los metadatos del DOI válido identifican esta referencia:

Thudt, A., Walny, J., Gschwandtner, T., Dykes, J., & Stasko, J. (2018). Exploration and explanation in data-driven storytelling. En N. H. Riche, C. Hurter, N. Diakopoulos y S. Carpendale (Eds.), *Data-driven storytelling* (pp. 59–83). A K Peters/CRC Press. https://doi.org/10.1201/9781315281575-3

La comprobación utiliza el [registro de Crossref](https://api.crossref.org/works/10.1201%2F9781315281575-3) y la [ficha del libro de la editorial](https://www.routledge.com/data-driven-storytelling/riche-hurter-diakopoulos-carpendale/p/book/9781138197107). Las tres notas archivísticas enlazan esta corrección. La obra no se añadió a la bibliografía de la memoria vigente.

## Enlaces externos y alcance de la comprobación

Se consultaron **256 direcciones externas normalizadas**, excluyendo vistas locales y enlaces del propio proyecto en GitHub. De ellas, 192 respondieron 200 o 206, ocho devolvieron 404 y las restantes presentaron restricciones, respuestas intermedias o fallos de acceso. Un bloqueo automatizado no se clasificó como enlace roto.

| Incidencia | Tratamiento |
| --- | --- |
| Vinculación Android | Se corrigió la URL en la memoria hacia [Companion device pairing](https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing), con fecha de consulta actualizada. |
| Dos rutas de Focusaur | Se sustituyeron por la [ficha oficial accesible](https://www.focusaur.com/products/focusaur-the-phone-free-focus-device-for-deep-work-habits). Los precios del estudio siguen identificados como observaciones del 24 de agosto. |
| Página antigua de Nothing Phone (1) | Se conservó la procedencia y se añadió la [explicación oficial de Glyph Interface](https://support.nothing.tech/hc/en-us/articles/7456213120273-What-is-the-Glyph-Interface) para consultar esa función concreta. |
| Paper Phone | Las notas históricas enlazan la [ficha oficial con guion](https://experiments.withgoogle.com/paper-phone) y aclaran la atribución a Special Projects. |
| DOI atribuido a Thudt | Se documentó la errata y la referencia correcta en el apartado anterior. |
| Catálogo paginado de Electrónica Real y URL histórica de Aro | Se identificó su falta de acceso junto a los documentos afectados. No se inventó una página sustituta ni se afirmó disponibilidad comercial actual. |

También se consultaron **73 DOI distintos** presentes en los textos: 71 cuentan con metadatos recuperados de Crossref; el de la tesis de Maturana Retamal se confirmó mediante [DataCite](https://api.datacite.org/dois/10.58011/sesj-rx16); la combinación atribuida a Thudt se corrigió como errata histórica. La disponibilidad de metadatos comprueba identidad bibliográfica, no que cada afirmación del repositorio esté respaldada por una lectura completa de la obra.

## Condición de cierre y límites

La memoria mantiene su texto académico y sus parámetros experimentales; la única modificación en su bibliografía es la reparación del enlace de Android. Los controles finales confirmaron enlaces internos, anclas, registros de cambios de los documentos modificados y conservación de las fuentes. El cierre contiene 38 documentos existentes corregidos y este informe nuevo.

| Control final | Resultado |
| --- | --- |
| Inventario | 1.215 archivos, incluidos 356 Markdown. |
| Navegación | 1.218 enlaces locales y 126 anclas comprobados; ningún destino ausente. |
| Memoria | 15.033 palabras académicas, 14 capítulos, 42 subtítulos y 52 referencias. |
| Citas del cuerpo académico | 84 instancias parentéticas conservadas; el texto anterior a la bibliografía no cambió. |
| Feedback | 23 respuestas con sus documentos responsables conservadas. |
| Registro de decisiones | D-001–D-056 ordenadas; las 46 entradas históricas anteriores se conservaron. |
| Archivos modificados | Exclusivamente Markdown; ninguna eliminación de archivos versionados. |
| Evidencia y protocolo | Corpus P1–P8, instrumentos y parámetros sin cambios. |
| Integridad de edición | Sin marcas de conflicto, destinos locales rotos ni errores de espacios en las diferencias de Git. |

La documentación del feedback conserva las 23 respuestas y sus fuentes responsables. Siguen pendientes el banco físico, la asociación con participantes, la comparación, la integración portátil y los datos complementarios todavía no aportados. Esos pendientes permanecen en sus documentos e Issues; esta limpieza no los convierte en resultados.

## Registro de cambios (disclaimer)

### 2026-09-09 — Creación del control textual

- **Cambio:** se documentaron correcciones de redacción, vigencia, navegación y bibliografía, junto con el alcance real de la limpieza.
- **Antes:** los controles anteriores no reflejaban las últimas revisiones de la memoria y conservaban algunas afirmaciones de estado contradictorias.
- **Motivo:** permitir que el autor y futuros lectores comprueben qué se corrigió y qué documento gobierna cada tema.
- **Alcance:** cambios exclusivamente documentales; sin nuevas piezas visuales ni resultados de validación.
