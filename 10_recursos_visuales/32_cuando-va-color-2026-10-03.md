# Cuándo va color

**Fecha:** 3 de octubre de 2026. **Estado:** propuesta D-103, versión 2 de la [propuesta 3.4](31_las-ganas-estaban-2026-10-03.md). Actualizada en parte por la [propuesta 3.5](33_el-traspaso-2026-10-03.md) (D-104): la presencia baja a 1 % de color, la marca pasa a azul y papel, y la paleta pasa a una familia en que todo combina. Son las reglas para decidir dónde va cada color de Relevo, en la app y en las piezas. No cambia todavía la app ni el sistema publicado. **Dónde está:**

- Lámina publicada en claude.ai: [Las ganas estaban](https://claude.ai/artifact/TLqwUeq6KhgbFXvbVRsXff), sección «Cuándo va color» (privada del autor).
- Copia en el repositorio: [`las-ganas-estaban-v2.html`](las-ganas-estaban-2026-10-03/las-ganas-estaban-v2.html), con las piezas en [`piezas-v2/`](las-ganas-estaban-2026-10-03/piezas-v2/).

## Qué pidió el autor

La propuesta 3.4 le pareció mucho mejor, pero pidió saber cuándo usar los colores y cuándo no, y aprender de diseño de interfaces, diseño y color para decidirlo.

## Lo que se aprendió

| Fuente | Qué dice | Qué se toma para Relevo |
| --- | --- | --- |
| Apple, *Human Interface Guidelines: Color* | Usar el color con criterio, no darle dos significados al mismo color y no depender solo de él. Sobre el vidrio de iOS 26, poco color y en la acción principal. | Un significado por color, y siempre con ícono o nombre. |
| Google Design (2025), investigación de Material 3 Expressive | 46 estudios con más de 18.000 personas. Con color, forma y tamaño puestos en lo importante, la gente encontró los elementos clave hasta cuatro veces más rápido, y las personas mayores tan rápido como las jóvenes. | El color va en lo único que importa en cada pantalla. |
| Material Design 3, *Color roles* | Separa los colores de acento, que llevan la marca, de las superficies neutras y del color de error. | Cinco papeles para el color. |
| Wolfe y Horowitz (2017) | La atención la guían rasgos como el color, y un objetivo se encuentra rápido cuando se distingue de lo que lo rodea. | Para que la señal se note, alrededor tiene que haber calma. |
| W3C (2023), WCAG 2.2 | El color no puede ser el único medio para comunicar algo (criterio 1.4.1). El texto necesita 4,5:1 de contraste (1.4.3) y los componentes, 3:1 (1.4.11). | Ícono y nombre junto a cada color, y contrastes medidos. |

## El principio: el color sube con el momento

Relevo existe para que una señal se note cuando importa. Si todo tiene color, nada destaca. Por eso cada color tiene un trabajo: decir de quién es algo y cuánto importa ahora. Hay tres niveles:

| Nivel | Cuándo | Color | Ejemplo | Color de actividad medido |
| --- | --- | --- | --- | --- |
| 0 · Calma | Escribir, elegir, revisar, leer | Papel y tinta; el azul marca dónde escribes y dónde estás | Preparar, perfil, ajustes, consentimiento, la memoria, láminas de ideas | 0,7 % de la pantalla de Preparar (la idea elegida) |
| 1 · Presencia | Tu actividad está en curso | El par de la actividad en un solo elemento; el resto, en calma | Inicio con la tarjeta del relevo activo | 35 % de la pantalla de Inicio |
| 2 · Señal | Es el momento de volver | El par llena la pantalla o la pieza | La señal; afiches, historia y portadas, cuya tarea es hacerse notar | 100 % de la pantalla de la señal |

Los porcentajes se midieron en las maquetas de la lámina como el área de los elementos en el par de la actividad sobre el área del teléfono.

## Cinco papeles, uno por color

| Papel | Colores | Qué dice | Dónde va | Dónde no |
| --- | --- | --- | --- | --- |
| Neutros | Papel `#FAFAF7`, blanco `#FFFFFF`, tinta `#141519`, grafito `#5B5F68`, línea `#E4E4DF` | «Aquí se lee y se decide.» | El fondo y el texto de la app, la memoria, los formularios y las láminas de ideas | Son la base: están en todo |
| Sistema | Azul `#3D38F5` | «Aquí estás, aquí escribes.» | El logotipo, el campo con foco, la pestaña activa, lo seleccionado y los enlaces | Fondos grandes, botones y actividades |
| Marca | Azul `#3D38F5` y lima `#D8FF4A` | «Habla Relevo.» | Afiches de dato, portadas de sección, la tarjeta de bolsillo y el ícono de la app | Dentro de la app, salvo el logotipo; nunca por una actividad |
| Actividad | Seis pares | «Es la actividad de alguien.» | Su tarjeta activa, su señal, su foto, su afiche y la idea elegida; en listas, un punto chico junto a su ícono y su nombre | Botones, estados, adornos y dos pares grandes en la misma vista |
| Estado | Rojo de error `#B3261E` (6,3:1 sobre papel) | «Algo salió mal o no se puede deshacer.» | Errores y «Borrar», siempre con ícono y texto | Actividades y adornos |

El azul es de Relevo en sus dos papeles: en la app marca dónde estás y dónde escribes, y afuera es su marca. Por eso ninguna actividad es azul. El rojo es de los errores, así que ninguna actividad es roja.

## Dónde va cada color

| Superficie | Nivel | Color |
| --- | --- | --- |
| Preparar | 0 | Papel y tinta; el azul bajo el campo donde escribes. Las ideas van neutras, con ícono y nombre, y la elegida toma su par. |
| Inicio | 1 | La tarjeta del relevo activo en el par de su actividad; lo demás en calma. |
| Listas (por ejemplo, la ruta) | 0 | Neutras; un punto chico del par junto al ícono y el nombre de cada actividad. No se maquetó. |
| La señal | 2 | El par de la actividad en toda la pantalla. |
| Perfil, ajustes y consentimiento | 0 | Papel y tinta; el azul para lo seleccionado. |
| Errores y «Borrar» | Estado | Rojo de error con ícono y texto. |
| Afiches de dato | 2 | Par de la marca, porque habla Relevo. El del medio lo invierte para dar ritmo. |
| Afiches del objeto | 2 | El par de su actividad: el color sigue a la foto. |
| Historia | 2 | El par de la actividad de su foto. |
| Tarjeta de bolsillo | 2 | Frente en el par de la marca; reverso en papel y tinta. |
| Láminas de ideas | 0 | Papel y tinta, porque se leen. |
| Portada de sección | 2 | Par de la marca, porque marca un cambio. |
| Ícono de la app | 2 | Par de la marca. |
| Memoria y documentos | 0 | Papel y tinta. |

## Cambios de color

Al aplicar «un significado por color» aparecieron tres choques en la paleta de la versión 1:

| Actividad | Antes | Ahora | Por qué |
| --- | --- | --- | --- |
| Leer | Azul `#3D38F5` y lima `#D8FF4A` (el par de la marca) | Café `#3B2416` y sol `#FFC94D` | El mismo color decía «Relevo» y «leer». Café y sol: la luz de la lámpara sobre la madera del velador. |
| Escribirle a alguien | Rojo `#B71A29` y rosa pálido `#FFE1E8` | Vino `#7D1838` y rosa pálido | Su rojo y el de error apenas se distinguían (ΔE de 1,9 en OKLab). El vino es el color del lacre. |
| Estudiar | Azul `#0F4C81` y celeste `#9EDCFF` | Petróleo `#0B4A55` y celeste | Era azul, junto al azul del sistema. |

Los siete pares quedan así:

| Par | Uso | Contraste | Peor caso con visión del color simulada |
| --- | --- | --- | --- |
| Azul y lima | La marca | 5,9:1 | 4,2:1 (protanopía) |
| Café y sol | Leer | 9,5:1 | 8,7:1 |
| Noche y naranja | Salir a caminar | 6,4:1 | 4,9:1 (protanopía) |
| Violeta y rosa | Pintar | 5,8:1 | 4,7:1 (protanopía) |
| Bosque y menta | Pasear al perro | 6,5:1 | 6,4:1 (tritanopía) |
| Petróleo y celeste | Estudiar | 6,7:1 | 6,5:1 |
| Vino y rosa pálido | Escribirle a alguien a mano | 8,3:1 | 7,6:1 |

La simulación sigue a Machado et al. (2009). El par de la marca es el único que baja de 4,5:1, porque su azul no se cambia.

## Cómo revisar una pieza nueva

1. **¿Qué papel cumple cada color?** Neutro, sistema, marca, actividad o estado. Si un color no tiene papel, sale.
2. **¿Quién habla?** Si habla Relevo, va el par de la marca. Si la pieza trata de una actividad, va su par. Si es para leer o decidir, van papel y tinta.
3. **¿En qué momento está?** Calma, presencia o señal. El color no pasa del nivel que corresponde.
4. **¿Hay un solo par grande?** Varios pares solo como puntos chicos en una lista.
5. **¿El color va con ícono o nombre?** Nunca solo.
6. **¿Se lee?** 4,5:1 para texto y 3:1 para íconos y bordes.

## Límites

- Las reglas y los porcentajes se probaron en maquetas, no en la app ni con personas.
- Falta revisar cómo muestra hoy la app 2.18 los errores y el botón de borrar antes de fijar el rojo de error.
- No se maquetó una lista con varias actividades ni el tema oscuro de la app.

## Referencias

Apple. (s. f.). *Color*. Human Interface Guidelines. https://developer.apple.com/design/human-interface-guidelines/color

Google. (s. f.). *Color roles*. Material Design 3. https://m3.material.io/styles/color/roles

Google Design. (2025). *Expressive design: Google's UX research*. https://design.google/library/expressive-material-design-google-research

Machado, G. M., Oliveira, M. M. y Fernandes, L. A. F. (2009). A physiologically-based model for simulation of color vision deficiency. *IEEE Transactions on Visualization and Computer Graphics, 15*(6), 1291–1298. https://doi.org/10.1109/TVCG.2009.113

W3C. (2023). *Web Content Accessibility Guidelines (WCAG) 2.2*. https://www.w3.org/TR/WCAG22/

Wolfe, J. M. y Horowitz, T. S. (2017). Five factors that guide attention in visual search. *Nature Human Behaviour, 1*(3), Artículo 0058. https://doi.org/10.1038/s41562-017-0058

## Registro de cambios (disclaimer)

### 2026-10-03 — Actualizada en parte por la 3.5

- **Qué cambió:** se avisa qué reglas cambia la propuesta 3.5.
- **Cómo estaba antes:** las reglas de este documento eran las vigentes.
- **Por qué:** el autor pidió no abusar de los colores, un logotipo con más carácter en una sans, colores que combinen todos entre sí y otras ideas en vez del subrayado.

### 2026-10-03 — Creación

- **Qué cambió:** se escribieron las reglas de cuándo va color: tres niveles según el momento, cinco papeles, dónde va cada color en la app y en las piezas, tres cambios de la paleta y una lista para revisar piezas nuevas.
- **Cómo estaba antes:** la propuesta 3.4 tenía pares de color sin reglas de uso; el par de la marca era también el de leer, el rojo de escribirle a alguien coincidía con el de error y las ideas de Preparar mostraban seis colores a la vez.
- **Por qué:** el autor pidió saber cuándo usar los colores y cuándo no, aprendiendo de diseño de interfaces, diseño y color.
