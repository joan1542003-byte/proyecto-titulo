# Auditoría de organización del repositorio — 2 de septiembre de 2026

## Propósito

Este documento registra la revisión global realizada para comprobar que el repositorio tenga una estructura comprensible, fuentes vigentes identificables, nombres navegables y una política clara para conservar o retirar archivos. La auditoría se concentra en la organización y la trazabilidad; no reemplaza las revisiones académicas, técnicas, visuales ni de validación del proyecto.

## Alcance revisado

Se revisaron:

- el estado de Git, la rama principal y la sincronización con GitHub;
- los README de la raíz, de gobernanza, de las áreas numeradas, del archivo y de las entregas fechadas;
- las rutas internas de Markdown, imágenes, tipografías, documentos, scripts y exportaciones;
- los enlaces locales de los documentos Markdown;
- los nombres de archivos y carpetas que podían inducir a confusión;
- las coincidencias exactas por huella SHA-256 para distinguir copias funcionales de redundancias;
- las reglas de privacidad, Git LFS y exclusión de archivos temporales.

## Fuentes vigentes que deben orientar la lectura

| Necesidad | Fuente de entrada | Estado |
| --- | --- | --- |
| Estado general | [`README.md`](../README.md) | Vigente |
| Reglas y recorrido de lectura | [`indice-del-repositorio.md`](indice-del-repositorio.md) y [`directrices-de-trabajo.md`](directrices-de-trabajo.md) | Vigentes |
| Texto académico | [`memoria-vigente-v4.md`](../08_memoria/memoria-vigente-v4.md) | Vigente |
| Síntesis breve del proyecto | [`resumen-vigente-proyecto.md`](../08_memoria/resumen-vigente-proyecto.md) | Vigente |
| Entrega fechada del 2 de septiembre | [`00_admin/encargos/encargo-02-09-2026/README.md`](../00_admin/encargos/encargo-02-09-2026/README.md) | Vigente para esa entrega |
| Propuesta y estructura de interacción | [`05_propuesta_phygital/README.md`](../05_propuesta_phygital/README.md) | Vigente y en desarrollo |
| Factibilidad y costos | [`06_desarrollo_y_factibilidad/README.md`](../06_desarrollo_y_factibilidad/README.md) | Vigente y provisional |
| Validación | [`07_validacion/README.md`](../07_validacion/README.md) | Preparada; ejecución pendiente |
| Sistema visual | [`10_recursos_visuales/08_direccion_visual_relevo/README.md`](../10_recursos_visuales/08_direccion_visual_relevo/README.md) | Vigente y exploratorio |
| Material superado | [`99_archivo/README.md`](../99_archivo/README.md) | Histórico |

## Resultados de la revisión

### Estructura

- Se confirmó una numeración coherente desde `00_gobernanza` hasta `10_recursos_visuales`, con `99_archivo` como espacio histórico.
- Se añadió un README propio a `00_admin`, que antes no tenía un punto de entrada aunque sí contenía la entrega fechada.
- La entrega `encargo-02-09-2026` queda separada en sus cuatro resultados principales, documentación de control, referencias y herramientas.
- Los 44 wireframes individuales tienen una imagen y un README propio; los mapas generales están separados de las pantallas para que cada nivel de lectura cumpla una función.

### Nombres

- Los documentos de control de la entrega fechada se normalizaron a nombres descriptivos en minúscula.
- Se actualizaron los enlaces y la herramienta de construcción del mapa para usar las nuevas rutas.
- Se conservaron nombres técnicos cuando cumplen una función obligatoria o de procedencia: `AGENTS.md`, archivos de paquetes, UUID de archivo visual y nombres originales recuperados.
- Las carpetas históricas mantienen su denominación cuando cambiarla dificultaría reconstruir el proceso.

### Duplicados

La comparación por SHA-256 encontró copias exactas en distintos contextos. La mayoría tiene una función explícita:

- una exportación plana facilita revisar o presentar una pieza;
- una copia dentro del tablero permite ejecutar o reconstruir la interfaz;
- una tipografía dentro del proyecto visual funciona como fuente de diseño y otra dentro del tablero como dependencia de ejecución;
- una copia en el archivo conserva la procedencia de una generación o una entrega anterior.

Por esa razón, esas copias no se consideran prescindibles. En la entrega fechada sí se encontró una redundancia sin función adicional: `mapa-anterior-miniaturas-duplicado.png` era idéntico a `mapa-anterior-miniaturas.png`. Se retiró el duplicado y se conservó la copia histórica con su explicación.

### Enlaces y archivos temporales

- La auditoría de enlaces locales se ejecutó sobre los documentos Markdown y no detectó rutas rotas.
- Las carpetas temporales y de trabajo local permanecen fuera del repositorio mediante `.gitignore`.
- Los binarios visuales grandes y las tipografías tienen reglas Git LFS donde corresponde.
- No se incorporaron datos identificables, audios de entrevistas ni fuentes privadas.

## Criterio para futuras limpiezas

Antes de retirar un archivo se debe responder afirmativamente a estas preguntas:

1. ¿Existe otra copia idéntica o una fuente vigente que conserve toda su función?
2. ¿El archivo no aporta procedencia, contraste, uso técnico, respaldo de entrega o aprendizaje histórico?
3. ¿La eliminación no rompe enlaces, scripts, manifiestos ni reconstrucción del proceso?
4. ¿La decisión queda registrada en el README o índice correspondiente?

Si alguna respuesta es negativa, el archivo se conserva y se clasifica mejor en lugar de eliminarlo.

## Resultado de la auditoría

El repositorio tiene una fuente vigente identificable por área, una ruta de lectura global, una entrega fechada navegable, documentación individual para los wireframes y una distinción explícita entre material activo, respaldo e histórico. La limpieza segura realizada en esta fecha se limitó a la redundancia comprobada del mapa antiguo y a la normalización de nombres de control.

La organización no significa que el proyecto esté terminado: memoria, prototipo, señal, factibilidad y validación mantienen los estados declarados en sus respectivos README.

---

## Registro de cambios (disclaimer)

### 2026-09-02 — Auditoría inicial de organización

- **Qué cambió:** se documentó la revisión global de estructura, fuentes, nombres, duplicados, enlaces, privacidad y reglas de conservación.
- **Cómo estaba antes:** los criterios estaban repartidos entre distintos índices y la decisión sobre copias se explicaba solo en carpetas particulares.
- **Qué se conservó:** fuentes, entregas, dependencias técnicas y material histórico con función comprobable.
- **Qué se retiró:** una copia idéntica del mapa histórico de miniaturas dentro de la entrega fechada.
- **Por qué se decidió:** dejar una base única para futuras limpiezas sin borrar procedencia ni confundir archivos de respaldo con basura.
- **Alcance:** auditoría organizativa; no modifica la formulación, los resultados de investigación ni las decisiones aún abiertas.
