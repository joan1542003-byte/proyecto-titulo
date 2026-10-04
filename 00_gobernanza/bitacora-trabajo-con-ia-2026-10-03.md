# Bitácora del trabajo con IA: 3 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code el 3 de octubre de 2026, a pedido del autor. Continúa la [bitácora del 2 de octubre](bitacora-trabajo-con-ia-2026-10-02.md). Cada pedido está en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| Propuesta 3.2, «Relevo vivo» | [Lámina](https://claude.ai/artifact/VyeLFYsuWgkyJ45pkfywJL) y [documento 29](../10_recursos_visuales/29_relevo-vivo-2026-10-03.md). Regla: un color, una frase, un renglón. Seis colores de la casa vivos, cada uno con campo, tinta y fondo suave; la frase de Relevo en Schibsted Grotesk 800 y la palabra de la persona escrita a mano en Playwrite CL sobre un renglón azul de borde a borde. Catorce piezas: seis afiches, tres pantallas, historia, tarjeta y dos láminas. | D-100 |
| Propuesta 3.3, «Volver a enfocar» | El autor rechazó Playwrite y compartió seis referencias. [Lámina](https://claude.ai/artifact/AQn4nbdQbPAPwkX4Pzw5tn) y [documento 30](../10_recursos_visuales/30_volver-a-enfocar-2026-10-03.md): la actividad fuera de foco (la foto de su lugar, desenfocada sobre su color vivo) y, nítidas, la frase de Relevo en Newsreader y las palabras de la persona en itálica sobre el renglón azul. Catorce piezas. Fundamento en Rose Pilkington (Instagram, 2022), Special Offer (brat, 2024), Pentagram (Atlantic Theater, 2022-2023), Production Type (Newsreader) y Bakken & Bæck (Schibsted Grotesk). | D-101 |
| Propuesta 3.3, versión 2 | A pedido del autor, menos serif y menos renglón: titulares en Schibsted Grotesk, la serif solo para las palabras de la persona y el renglón solo bajo ellas. Misma [lámina](https://claude.ai/artifact/AQn4nbdQbPAPwkX4Pzw5tn), versión 2. | D-101 |
| Propuesta 3.4, «Las ganas estaban» | A pedido del autor: titulares con lo que se sabe (cifras de la encuesta, el principio de la señal, lo que hace Relevo), solo Schibsted Grotesk, el renglón azul solo donde se escribe y seis pares de color. [Lámina](https://claude.ai/artifact/TLqwUeq6KhgbFXvbVRsXff) y [documento 31](../10_recursos_visuales/31_las-ganas-estaban-2026-10-03.md). | D-102 |
| Propuesta 3.4, versión 2: cuándo va color | A pedido del autor, reglas de uso del color apoyadas en Apple, Google, Material Design 3, Wolfe y Horowitz (2017) y WCAG: tres niveles, cinco papeles y tres pares cambiados. Misma [lámina](https://claude.ai/artifact/TLqwUeq6KhgbFXvbVRsXff), versión 2, y [documento 32](../10_recursos_visuales/32_cuando-va-color-2026-10-03.md). | D-103 |

## 2. Cómo se usó la IA

- **El autor dio la dirección y la IA la armó:** primero se compararon tres tratamientos de letra sobre el mismo afiche (serif liviana, grotesca gruesa con letra a mano, grotesca con itálica) y se eligió la grotesca gruesa con letra a mano.
- **Medido, no a ojo:** la paleta se calculó en OKLCH y se revisó con contraste WCAG y simulación de visión del color; se corrigió el texto de las etiquetas, que daba 4,1:1, y se separaron las luces de los colores hasta que todos se distinguieran con protanopía, deuteranopía y tritanopía.
- **Tres tratamientos antes de elegir:** para la 3.3 se compararon la foto desenfocada mezclada en color, en multiplicar y sobre color pleno en luz suave; se eligió la última porque mantiene el color vivo y el texto legible.
- **Fundamento reciente:** a pedido del autor, las razones se apoyan en diseñadores y estudios recientes y reconocidos, verificados en sus fuentes, y no en antecedentes antiguos.
- **Comunicar con datos:** para la 3.4, cada titular sale de una cifra de la encuesta, del marco multiproceso o de lo que hace la app; cada cifra lleva su fuente y sus límites quedan en el documento 31.
- **Pares medidos:** el contraste de cada par se midió con visión típica y simulada; se aclaró el naranja y se oscureció el rojo hasta pasar 4,5:1. El par de la marca queda en 4,2:1 con protanopía porque su azul no cambia.
- **Color medido:** para la versión 2 de la 3.4 se midió qué parte de cada pantalla ocupa el color de actividad (0,7 %, 35 % y 100 %) y cuánto se diferenciaban los colores que podían confundirse: el rojo de escribirle a alguien y el de error daban ΔE 1,9 en OKLab.
- **Lo que la IA señaló:** la propuesta quita la serif de titulares que el autor eligió el 30 de septiembre (D-098); queda como pregunta.

## 3. Qué se comprobó y qué no

- **Comprobado:** la lámina a 1280 y a 400 px de ancho, sin desbordes; las catorce piezas exportadas; los contrastes y las distancias de color. Para la 3.4: la lámina a 1280 y 400 px, sin desbordes; las diecinueve piezas; el contraste de los seis pares con visión típica y simulada. Para la versión 2: la lámina a 1280 y 400 px sin desbordes, las diecinueve piezas, el área de color por pantalla y los contrastes de los siete pares.
- **No comprobado:** las piezas con personas, en un teléfono real o impresas; un tema oscuro para 3.2.

## 4. Pendientes

- Que el autor responda las tres preguntas de la versión 2 de la 3.4 (si las reglas de color le sirven para revisar piezas nuevas; si acepta los tres cambios de color; si se lleva al sistema y a la app). La 3.2 y la 3.3 quedan como antecedentes.
- Si la aprueba: llevar 3.2 al sistema publicado en Claude Design, a la app 2.19 y a la presentación, y diseñar su tema oscuro.
- Siguen abiertos los pendientes técnicos: teléfono real con la 2.18, Firebase y la revisión del consentimiento v11.

## Registro de cambios (disclaimer)

### 2026-10-03 — Cuándo va color

- **Qué cambió:** se suma la versión 2 de la propuesta 3.4, con lo hecho, lo medido y lo pendiente.
- **Cómo estaba antes:** la bitácora terminaba en la versión 1 de la 3.4.
- **Por qué:** el autor encontró la 3.4 mucho mejor y pidió saber cuándo usar los colores y cuándo no, aprendiendo de diseño de interfaces, diseño y color.

### 2026-10-03 — Propuesta 3.4

- **Qué cambió:** se suma la propuesta 3.4, «Las ganas estaban», con lo que se hizo, cómo se usó la IA, lo comprobado y lo pendiente.
- **Cómo estaba antes:** la bitácora terminaba en la versión 2 de la 3.3.
- **Por qué:** el autor señaló que los afiches citaban palabras de usuario sin comunicar lo que se sabe, que la serif no funcionaba y que el marcador azul no podía estar en todas las piezas, y pidió colores que combinen.

### 2026-10-03 — Versión 2 de la 3.3

- **Qué cambió:** se suma la versión 2 de la propuesta 3.3.
- **Cómo estaba antes:** la bitácora terminaba en la versión 1.
- **Por qué:** el autor dijo que era mejorable y pidió no abusar de la raya ni de la serif, que no es obligatoria.

### 2026-10-03 — Volver a enfocar

- **Qué cambió:** se suma la propuesta 3.3.
- **Cómo estaba antes:** la bitácora terminaba en la propuesta 3.2.
- **Por qué:** el autor rechazó la letra escrita a mano, compartió seis referencias y pidió fundamentar con diseñadores recientes y reconocidos.

### 2026-10-03 — Creación

- **Qué cambió:** resumen del trabajo del 3 de octubre: la propuesta 3.2, cómo se hizo, qué se comprobó y qué falta.
- **Cómo estaba antes:** la última bitácora era la del 2 de octubre.
- **Por qué:** mantener el estado del proyecto al día para el autor y para la próxima sesión.
