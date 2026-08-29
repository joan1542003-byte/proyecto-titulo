# Tokens y especificaciones del sistema visual v4

## Cómo leer este documento

Un **token de diseño** es un nombre que representa una decisión reutilizable, por ejemplo, `color.text.primary` o `space.screen.margin`. Permite cambiar una implementación sin perder el significado común entre pantallas y soportes.

Cada valor tiene un estado:

- **Vigente:** se utiliza en nuevas reconstrucciones.
- **Hipótesis:** se propone como punto de partida y requiere comparación.
- **Por validar:** todavía no debe tratarse como especificación cerrada.
- **Histórico:** pertenece a v3 o a una exploración anterior.

Los valores de Android se expresan en `dp` para geometría y `sp` para texto. Los valores del editorial se expresan en `mm` o `pt` cuando corresponda. Las imágenes rasterizadas no son una fuente de medidas.

## Tokens de color oscuro

| Token semántico | Valor | Estado | Uso | No usar para | Validación |
|---|---|---|---|---|---|
| `color.canvas` | `#111314` | Vigente | Fondo general de nuevas pantallas digitales | Degradados o fondos fotográficos | Escala de grises, brillo bajo y texto ampliado |
| `color.surface.functional` | `#1B1D1E` | Vigente | Agrupación funcional puntual | Convertir cada dato en tarjeta | Distinguir grupo, elección y estado |
| `color.surface.quiet` | `#242728` | Vigente | Estado secundario no interactivo | Selecciones, acciones o foco | Comprobar que no parezca pulsable |
| `color.text.primary` | `#F1F1F1` | Vigente | Contenido, títulos y acciones principales | Jerarquía única para todo | Contraste por tamaño y peso |
| `color.text.secondary` | `#B6B8B7` | Vigente | Ayuda, metadatos y estados secundarios | Información crítica aislada | Contraste y comprensión sin color |
| `color.rule` | `#3A3D3E` | Vigente | Separación no informativa | Foco, selección o error | Verificar que su ausencia no quite significado |
| `color.border.functional` | `#767A79` | Vigente | Campo, foco y control delineado | Decoración pura | Contraste no textual y foco visible |
| `color.signal.situated` | `#EF3E45` | Vigente como rol; valor por validar | Único nodo de señal situada | Error, batería, vínculo, selección, acción o decoración | Asociación, escala de grises, contraste y daltonismo |

No existe una paleta clara vigente para nuevas piezas. Los valores claros documentados en v3 y las pantallas claras de v4 son históricos. El papel puede exigir una adaptación física de contraste, pero esa adaptación no crea un tema claro de interfaz.

### Reglas cromáticas

1. El rojo no aparece antes de que exista una señal situada en el flujo.
2. El rojo siempre se acompaña de texto, posición o forma equivalente.
3. Ningún estado técnico depende solo del color.
4. La regla `color.rule` no puede codificar información indispensable.
5. La paleta se prueba como combinación: fondo, superficie, texto, tamaño, luz y soporte.

La base teórica para estas pruebas es la relatividad perceptual del color descrita por Albers (2013). WCAG 2.2 aporta criterios de contraste, pero la conformidad no se presume por el valor hexadecimal.

## Tokens tipográficos

| Token | Familia | Tamaño inicial | Interlínea | Estado | Aplicación |
|---|---|---:|---:|---|---|
| `type.display` | IBM Plex Sans | 32 sp | 40 sp | Vigente como punto de partida | Título principal breve |
| `type.screen-title` | IBM Plex Sans | 24 sp | 32 sp | Vigente como punto de partida | Título de pantalla |
| `type.section` | IBM Plex Sans | 20 sp | 28 sp | Vigente como punto de partida | Sección o agrupación |
| `type.body` | IBM Plex Sans | 16 sp | 24 sp | Vigente como punto de partida | Lectura e instrucciones |
| `type.secondary` | IBM Plex Sans | 14 sp | 20 sp | Vigente como punto de partida | Ayuda y explicación secundaria |
| `type.label` | IBM Plex Mono | 12 sp | 16 sp | Hipótesis de trabajo | Metadatos y etiquetas breves |
| `type.technical` | IBM Plex Mono | 14 sp | 20 sp | Hipótesis de trabajo | Valores, estados técnicos y datos |
| `type.dot-mark` | Alfabeto puntual en estudio | N/A | N/A | Por validar | Marca, numeral o señal expresiva breve |

Los tamaños no son una escala de reducción de contenido. Si el usuario amplía el texto hasta 200 %, la jerarquía debe conservar la información y permitir desplazamiento. IBM Plex Sans se mantiene como familia de lectura mientras no exista una prueba comparativa que indique otra solución. IBM Plex Mono no debe ocupar párrafos ni mensajes largos.

### Pesos y estilo

El peso exacto se define en la reconstrucción con las familias disponibles y sus licencias. Como criterio inicial, el cuerpo debe mantenerse regular, los títulos pueden usar un peso mayor y las acciones deben distinguirse por texto, posición y contraste antes que por una cantidad excesiva de peso. El peso definitivo es **por validar** mediante lectura real, Android y editorial.

## Tokens espaciales y retícula

| Token | Valor | Estado | Uso |
|---|---:|---|---|
| `space.unit` | 4 dp | Vigente | Subunidad de ajuste |
| `space.grid` | 8 dp | Vigente | Retícula principal Android |
| `space.screen.margin` | 24 dp | Vigente como base | Margen lateral Android |
| `space.group` | 32 dp | Hipótesis | Separación entre agrupaciones mayores |
| `space.section` | 48 dp | Hipótesis | Cambio de sección o zona de acción |
| `space.touch.min` | 48 dp | Requisito de trabajo | Área táctil mínima de control |
| `space.editorial.base` | 4 mm | Hipótesis | Ritmo de composición impresa |
| `space.editorial.margin.outer` | 18 mm | Hipótesis histórica | Margen exterior A4 de la exploración v3 |
| `space.editorial.margin.inner` | 22 mm | Hipótesis histórica | Margen interior A4 de la exploración v3 |

El margen Android se mide desde el borde útil de la ventana, no desde una imagen del teléfono. El objetivo táctil puede ser mayor que el glifo visible. La especificación de 48 dp se basa en Android Accessibility y se debe comprobar con interacción, foco y lectores de pantalla.

## Tokens de forma y borde

| Token | Valor | Estado | Uso | Restricción |
|---|---:|---|---|---|
| `radius.field` | 8 dp | Hipótesis | Campo funcional delimitado | No aplicar a texto estático |
| `radius.group` | 16 dp | Hipótesis | Agrupación puntual | No volver toda la pantalla una tarjeta |
| `radius.exceptional` | 24 dp | Por validar | Control dominante solo si la prueba lo exige | No usar por defecto |
| `border.functional.width` | 1 dp | Hipótesis | Campo, división funcional y control delineado | Revisar con escala y foco |
| `border.focus.width` | 2 dp | Hipótesis | Foco visible | No usar como decoración |
| `border.rule.width` | 1 dp | Vigente como base | Regla no informativa | No codificar estado |
| `shadow.default` | 0 | Vigente | No usar sombra como jerarquía | Sustituir por espacio y contraste |
| `texture.default` | 0 | Vigente | Superficies planas | La textura solo aparece en fotografía documentada |

Las cápsulas no son un token general. Solo pueden utilizarse si el contenido es compacto y su contenedor comunica una función concreta; la aprobación queda **por validar**.

## Tokens de iconografía

| Token | Valor inicial | Estado | Uso |
|---|---:|---|---|
| `icon.box` | 24 × 24 dp | Hipótesis | Área visual del icono convencional |
| `icon.touch` | 48 × 48 dp | Vigente como mínimo | Área interactiva, incluso si el glifo es menor |
| `icon.stroke` | 2 dp | Hipótesis | Consistencia de trazo |
| `icon.color` | `color.text.primary` o `color.text.secondary` | Vigente | No usar rojo salvo el nodo situado, que no es un icono de acción |
| `icon.label` | Texto accesible obligatorio si interactivo | Vigente | Nombre de acción o entidad |

El tamaño y trazo se comparan con la biblioteca de iconos elegida durante la implementación. No se inventan símbolos para funciones críticas. Si el icono no aporta comprensión adicional, se elimina.

## Tokens de opacidad

La jerarquía no debe depender principalmente de transparencias. Por eso, no existe una opacidad decorativa definitiva. Como punto de partida de exploración se puede usar:

| Token | Valor inicial | Estado | Regla |
|---|---:|---|---|
| `opacity.decorative` | 0,32 | Hipótesis | Solo elementos prescindibles y nunca contenido crítico |
| `opacity.disabled` | 0,48 | Hipótesis | Solo si el control está realmente inactivo y conserva legibilidad suficiente |
| `opacity.overlay` | 0,80 | Por validar | Solo para diálogo o separación temporal, no para glassmorphism |

Si una información desaparece al reducir opacidad, no era decoración. Los controles inactivos deben conservar nombre, foco y explicación; no se debe simular una desactivación únicamente con gris.

## Tokens de movimiento

| Token | Valor inicial | Estado | Uso |
|---|---:|---|---|
| `motion.duration.short` | 150 ms | Hipótesis | Cambio simple de estado |
| `motion.duration.standard` | 220 ms | Hipótesis | Transición entre superficies relacionadas |
| `motion.duration.long` | 300 ms | Por validar | Solo cuando la relación necesite ser observada |
| `motion.easing.standard` | Curva estándar de plataforma | Por validar | Implementación, no dirección visual cerrada |
| `motion.reduced` | Sin movimiento no esencial | Vigente | Respeto de preferencia de reducción |
| `motion.loop` | No permitido | Vigente | No usar bucles permanentes |
| `motion.flash` | No usar como recurso de señal | Vigente | No simular el pulso físico en Android |

Las duraciones son hipótesis técnicas. Se prueban con lectura, foco y recuperación; un movimiento agradable no es motivo suficiente para mantenerlo.

## Contraste y accesibilidad

| Criterio | Valor de trabajo | Estado | Cómo se comprueba |
|---|---:|---|---|
| Texto pequeño | ≥ 4,5:1 | Requisito de trabajo | Herramienta de contraste y prueba visual |
| Texto grande | ≥ 3:1 | Requisito de trabajo | Herramienta y lectura situada |
| Elemento no textual relevante | ≥ 3:1 | Requisito de trabajo | Comparación contra fondos cercanos |
| Información por color | 0 usos exclusivos | Vigente | Escala de grises y prueba de clasificación |
| Texto ampliado | Hasta 200 % sin pérdida de contenido | Vigente como objetivo | Android y recorrido completo |
| Objetivo táctil | ≥ 48 × 48 dp | Requisito de trabajo | Auditoría de layout y dispositivo |
| Orden de foco | Lógico y completo | Vigente como criterio | TalkBack, teclado si corresponde y recorrido manual |

Estos valores se basan en WCAG 2.2 y guías de accesibilidad de Android. No convierten una pantalla en accesible automáticamente: también se debe comprobar lenguaje, foco, interacción, movimiento, percepción física y recuperación.

## Estados de madurez y cambio

Un token cambia de **hipótesis** a **vigente** solo cuando se documenta el soporte, la prueba, el resultado y la consecuencia. Si una prueba contradice el valor, se conserva el valor anterior hasta registrar la nueva decisión; no se cambia silenciosamente el token en el código.

## Referencias

Albers, J. (2013). *Interaction of color* (4th ed.). Yale University Press.

Google. (2023). *Accessibility*. Android Developers. https://developer.android.com/design/ui/mobile/guides/foundations/accessibility

Design Tokens Community Group. (2025). *Design Tokens Format Module 2025.10*. https://www.designtokens.org/TR/2025.10/format/

Norman, D. A. (2002). *The design of everyday things*. Basic Books.

World Wide Web Consortium. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

## Registro de cambios (disclaimer)

### 2026-08-29 — Creación de tokens v4

- **Cambio:** se creó una tabla operativa de tokens semánticos para color, tipografía, espaciado, retícula, formas, iconos, opacidad, movimiento y accesibilidad.
- **Situación anterior:** los valores estaban repartidos entre v3, el contrato oscuro y las pantallas Android, con diferencias de tema y sin estado de madurez común.
- **Motivo:** consolidar una fuente técnica para reconstrucción, distinguir decisiones vigentes de hipótesis y evitar precisión falsa en valores todavía no probados.
- **Decisión de continuidad:** los valores de v3 para tema claro permanecen históricos; el canvas oscuro y la reserva semántica del rojo gobiernan las nuevas piezas digitales.
- **Asuntos abiertos:** validar peso tipográfico, radios, opacidades, movimiento, contraste contextual, escalamiento y respuesta del rojo en cada soporte.

### 2026-08-29 — Verificación de la referencia de accesibilidad

- **Cambio:** se corrigió el año de la guía de accesibilidad de Android a 2023.
- **Situación anterior:** la referencia utilizaba el año de trabajo del proyecto como fecha editorial.
- **Motivo:** citar la fecha publicada por la fuente oficial y conservar trazabilidad APA 7.
