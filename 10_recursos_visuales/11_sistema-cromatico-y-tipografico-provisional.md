# Sistema cromático y tipográfico provisional

**Estado:** valores para prototipos de interfaz, identidad y editorial. No constituyen todavía una especificación validada.

**Fecha:** 15 de septiembre de 2026.

## Criterios de selección

Color y tipografía deben cumplir primero funciones de lectura, jerarquía y estado. Las asociaciones del tipo `azul significa confianza` o `verde significa calma` no son fundamento suficiente: la percepción depende de luminosidad, saturación, cantidad, contexto, cultura y experiencia. Por eso la paleta se define mediante roles, contraste medido y pruebas en soportes reales, en concordancia con Albers (2013), Android Developers (s. f.-d) y WCAG 2.2 (World Wide Web Consortium [W3C], 2023).

La tipografía se evaluó según legibilidad en español, rendimiento en interfaz, lectura editorial, disponibilidad de pesos, cifras, cursivas, licencia y continuidad entre pantalla e impresión.

## Tipografía principal: Source Sans 3

Source Sans 3 fue diseñada para entornos de interfaz y se distribuye con licencia abierta. Incluye una familia amplia, versión variable, cursivas, signos del español y cifras adecuadas para tablas y datos (Adobe Fonts, s. f.-a, s. f.-b).

Se recomienda por cuatro razones:

1. sus formas humanistas mantienen una voz cercana sin parecer informal;
2. funciona tanto en tamaños de interfaz como en lectura prolongada;
3. permite resolver el sistema con una sola familia;
4. su licencia y formatos reducen dependencias de producción.

### Alternativas consideradas

| Familia | Ventaja | Riesgo | Decisión |
| --- | --- | --- | --- |
| Roboto | familiaridad y disponibilidad nativa en Android | identidad muy próxima al valor por defecto de la plataforma | respaldo técnico, no primera elección de marca |
| Noto Sans | cobertura lingüística extensa y lectura estable | amplitud innecesaria para el alcance actual; carácter muy neutral | alternativa si aumenta el repertorio lingüístico |
| Atkinson Hyperlegible Next | caracteres muy diferenciados | su apariencia puede dominar la identidad y no reemplaza las pruebas de accesibilidad | útil para una comparación, no selección inicial |
| Source Sans 3 | interfaz, lectura editorial, repertorio y licencia | debe cargarse y comprobarse correctamente en Android y Google Docs | seleccionada para prototipar |

## Escala tipográfica para Android

Los tamaños se expresan en `sp` para respetar las preferencias de texto del sistema. Android utiliza una retícula de 4 y 8 dp y recomienda jerarquías por función, no por decoración (Android Developers, s. f.-e).

| Rol | Tamaño / interlínea | Peso | Uso |
| --- | --- | --- | --- |
| Titular destacado | 36/44 sp | Semibold 600 | intención o estado principal, máximo una vez por pantalla |
| Título de pantalla | 28/36 sp | Semibold 600 | ubicación dentro del recorrido |
| Título de sección | 22/28 sp | Semibold 600 | agrupación de contenido |
| Cuerpo principal | 18/26 sp | Regular 400 | instrucciones y explicación breve |
| Cuerpo | 16/24 sp | Regular 400 | contenido habitual y campos |
| Etiqueta de acción | 16/20 sp | Semibold 600 | botones y controles |
| Apoyo | 14/20 sp | Regular 400 | consecuencias, ayuda y metadatos |
| Mínimo excepcional | 12/16 sp | Medium 500 | información secundaria no esencial |

Reglas:

- no se usa Light para información necesaria;
- los textos se escriben en estilo oración;
- las mayúsculas sostenidas se reservan para códigos breves cuando mejoren la exploración;
- los botones no dependen de espaciado amplio entre letras para parecer importantes;
- el diseño debe resistir aumento de texto sin recortar contenido ni acciones;
- el ancho del párrafo móvil se controla mediante márgenes y no reduciendo el cuerpo.

## Escala editorial inicial

Estos valores sirven para una primera maqueta horizontal cercana a A3. Deben comprobarse impresos a tamaño real y en PDF.

| Rol | Tamaño / interlínea | Peso |
| --- | --- | --- |
| Apertura de capítulo | 40/44 pt | Semibold 600 |
| Título principal | 28/34 pt | Semibold 600 |
| Título de sección | 18/24 pt | Semibold 600 |
| Bajada | 14/20 pt | Regular 400 |
| Cuerpo | 10,5/15 pt | Regular 400 |
| Cita destacada | 16/23 pt | Regular 400 |
| Tabla y nota | 8,5/12 pt | Regular 400 |

La columna de lectura debe mantenerse aproximadamente entre 55 y 75 caracteres. El formato horizontal no autoriza líneas extensas ni bloques de texto repartidos solo para llenar la página.

## Comparación de direcciones cromáticas

| Dirección | Ventaja funcional | Riesgo principal | Estado |
| --- | --- | --- | --- |
| Neutros + verde turquesa | se separa de error y advertencia; conserva contraste en ambos temas | puede acercarse a códigos genéricos de bienestar si se usa en exceso | recomendada para prototipar |
| Neutros + azul cobalto | alta disponibilidad digital y asociaciones conocidas de acción | puede parecer una aplicación tecnológica genérica o una extensión del sistema | control de comparación |
| Neutros + ámbar | elevada visibilidad y relación posible con una señal luminosa | coincide con advertencia, puede sugerir urgencia y pierde contraste en tonos claros | no usar como primario antes de una prueba específica |

La comparación considera función y riesgo, no personalidad supuestamente universal. En las pruebas, las tres variantes deben conservar contenido, tipografía y calidad de composición para que el color sea la diferencia relevante.

## Paleta recomendada

La primera dirección utiliza una base neutra ligeramente verdosa y un acento verde turquesa. La selección no afirma que ese matiz sea tranquilizador. Responde a tres condiciones funcionales: se distingue de error y advertencia, puede mantener contraste alto en temas claro y oscuro, y permite una presencia visible sin usar rojo como color de marca.

### Tema claro

| Rol | Valor | Uso |
| --- | --- | --- |
| Fondo | `#F7F8F6` | lienzo principal |
| Superficie | `#FFFFFF` | campos, hojas y elementos elevados necesarios |
| Superficie secundaria | `#EEF2EF` | agrupación suave, no decoración |
| Texto principal | `#171A18` | títulos y cuerpo |
| Texto secundario | `#555B58` | apoyo y metadatos |
| Contorno | `#707772` | límites y componentes esenciales |
| Primario | `#006B5F` | acción principal, selección o estado destacado |
| Sobre primario | `#FFFFFF` | contenido sobre el primario |
| Contenedor primario | `#B8EFE4` | énfasis extendido excepcional |
| Sobre contenedor | `#003730` | contenido del contenedor primario |

### Tema oscuro

| Rol | Valor | Uso |
| --- | --- | --- |
| Fondo | `#101412` | lienzo principal |
| Superficie | `#181C1A` | campos y agrupaciones |
| Superficie secundaria | `#222825` | separación de nivel |
| Texto principal | `#F1F5F2` | títulos y cuerpo |
| Texto secundario | `#B9C1BD` | apoyo y metadatos |
| Contorno | `#89928C` | límites y componentes esenciales |
| Primario | `#72DBC7` | acción principal, selección o estado destacado |
| Sobre primario | `#00372F` | contenido sobre el primario |
| Contenedor primario | `#004F46` | énfasis extendido excepcional |
| Sobre contenedor | `#A9F2E3` | contenido del contenedor primario |

### Estados independientes de la marca

| Estado | Tema claro | Tema oscuro | Condición de uso |
| --- | --- | --- | --- |
| Error | `#BA1A1A` sobre `#FFFFFF` | `#FFB4AB` sobre `#690005` | fallo que requiere corrección; siempre con texto e icono |
| Advertencia | `#7A5200` sobre `#FFF3CD` | `#FFDA75` sobre `#3B2F00` | condición que merece atención, no urgencia |

No se define un color de éxito permanente. Estados como `preparado`, `vinculado` o `cerrado` deben escribirse y acompañarse con un indicador comprensible. Esto evita confundir el color principal con una evaluación positiva de la conducta.

## Contraste comprobado

Los siguientes pares se calcularon con la fórmula de luminancia relativa de WCAG 2.2:

| Par | Contraste |
| --- | ---: |
| Texto principal claro / fondo claro | 16,46:1 |
| Texto secundario claro / fondo claro | 6,52:1 |
| Primario claro / fondo claro | 6,03:1 |
| Blanco / primario claro | 6,43:1 |
| Texto principal oscuro / fondo oscuro | 16,88:1 |
| Texto secundario oscuro / fondo oscuro | 10,10:1 |
| Primario oscuro / fondo oscuro | 11,21:1 |
| Sobre primario oscuro / primario oscuro | 7,98:1 |

Los valores superan el mínimo de 4,5:1 para texto normal. Esto no valida la paleta por sí solo: todavía debe comprobarse con visión cromática alterada, brillo reducido, luz ambiental, impresión y componentes reales. Además, el color nunca será el único medio para indicar información o una acción (W3C, 2023).

## Reglas de uso

- una pantalla tiene como máximo una zona de énfasis primario dominante;
- el color principal identifica la acción o el estado relevante, no decora;
- error y advertencia conservan roles propios;
- el tema sigue la preferencia claro u oscuro del sistema;
- una selección combina color con contorno, marca e identificación textual;
- enlaces, foco, estado presionado y deshabilitado deben distinguirse por más de una variación cromática;
- la luz física se estudia por separado y no hereda automáticamente el verde turquesa;
- fotografías e ilustraciones no se tiñen para hacerlas coincidir con la marca.

## Condiciones de revisión

La tipografía debe cambiar si falla la lectura con tamaño aumentado, cursivas, cifras, tablas o exportación a Google Docs. El color principal debe cambiar si se confunde con éxito, reduce la visibilidad de acciones, falla en condiciones reales o recibe significados incompatibles de manera reiterada.

---

## Registro de cambios (disclaimer)

### 2026-09-15 — Primera selección tipográfica y cromática

- **Qué cambió:** se seleccionó Source Sans 3, se definieron escalas iniciales para Android y editorial, y se asignó una paleta por roles para temas claro y oscuro.
- **Cómo era antes:** tipografía y color permanecían abiertos y solo existían criterios generales de accesibilidad y sobriedad.
- **Por qué se decidió:** transformar los criterios en materiales concretos para prototipar, medir y comparar.
- **Límite:** los contrastes están calculados, pero la comprensión, percepción y reproducción aún deben probarse con personas y soportes reales.
