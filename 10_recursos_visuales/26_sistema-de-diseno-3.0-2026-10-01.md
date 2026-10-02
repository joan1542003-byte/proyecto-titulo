# Sistema de diseño 3.0 de Relevo

**Fecha:** 1 de octubre de 2026. **Estado:** sistema de trabajo de la identidad D-098, con tres decisiones aún abiertas (ver «Supuestos»). **Dónde está:**

- Sistema publicado en el tipo Design System de claude.ai: [página privada](https://claude.ai/artifact/SsGWeeHPHxxkXrCKN1WW8x).
- Copia en el repositorio: [`sistema-de-diseno-3.0/`](sistema-de-diseno-3.0/README.md), con los programas que lo generan.
- **Actualización del 2 de octubre:** la página publicada pasó a la versión 3.1, descrita en el [documento 27](27_sistema-de-diseno-3.1-2026-10-02.md). Este documento describe 3.0, que se conserva como antecedente.

## Qué pidió el autor

Desarrollar, mejorar y perfeccionar el sistema gráfico (comunicación, tono, colores, variantes y lo demás) y, si era posible, pasarlo a Claude Design. Venía de la propuesta D-098 ([documento 25](25_identidad-el-subrayado-2026-09-30.md)) y de sus decisiones del 30 de septiembre.

## Qué es

Un sistema de diseño completo en el formato de Claude: libro de marca, tokens, componentes que funcionan, recursos y una portada. Se armó con las fuentes reales del proyecto, no con valores aproximados:

- **Tokens de la app 2.18:** colores de `theme/Color.kt`, escala de `Type.kt`, formas de `Theme.kt` y medidas de cada componente en `ui/components`.
- **Identidad de la lámina D-098 v3:** azul eléctrico, renglón, trama y serif de titulares.
- **Contornos del logotipo** del archivo `relevo-tinta.svg`.
- **Íconos:** los 97 de `KitIcons.kt` y los 28 redibujados de la lámina.
- **Fotos:** las seis fotografías CC0 de la app.

## Contenido

| Parte | Qué tiene |
| --- | --- |
| Libro de marca | Principios, voz, color, tipografía, renglón, trama, logotipo, íconos, imágenes, forma y vidrio, movimiento, accesibilidad y componentes. Siete secciones: voz y tono, color y variantes, logotipo, trama, iconografía, aplicaciones y fundamentos con referencias. |
| Tokens | 33 colores en tema claro y oscuro, 20 estilos de texto en tres grupos (Interfaz, Titulares y Datos), 15 espacios, 5 radios, 3 sombras, 12 tamaños, 8 grosores de trazo y 8 medidas de la trama. Cada token dice dónde se usa y, si es texto, sobre qué fondos y con qué contraste. |
| Componentes | 43 componentes en React 18, escritos a mano desde los de la app con las reglas de 3.0, cada uno con su guía y una vista previa que funciona. La página «Pantallas» arma Inicio, Preparar y la señal solo con ellos. |
| Recursos | 124 archivos: 102 íconos, el logotipo en tres versiones, el ícono de la app en tres, 10 piezas de trama y 6 fotos CC0. |
| Portada | Bandas desiguales como renglones, la trama de puntos que crece y «relevo» con su renglón. |

## Qué se desarrolló respecto del documento 25

- **Comunicación y tono:** quién habla (Relevo en tercera persona, el equipo en primera plural, la persona con sus palabras), principios, formas que se repiten, formato, vocabulario propio y ejemplos de sí y no, todos tomados de los textos de la app.
- **Color:** escala fija del azul (`azul-700` a `azul-50`) más `tinta`, `papel` y `blanco` para piezas fijas; tokens semánticos por tema; tabla de combinaciones con su contraste; proporción (cerca del 10 % de azul en una pantalla); la variante «azul a celeste» limitada a piezas de comunicación.
- **Variantes:** tema claro y oscuro completos; logotipo en tinta, papel y blanco; ícono de la app en azul, tinta y trama; firma en tarjeta, título, señal y sans; botones principal, secundario, destructivo y compacto.
- **Tipografía:** escala de la app sin cambios para la interfaz y cinco estilos de serif (`displayPoster` a `displayCard`), solo desde 28 px y uno por pantalla.
- **Trama:** medidas en pantalla e impresión, tamaño del punto según la sombra y sus cuatro usos. Funciona en vivo: la señal late, una foto se vuelve trama y un ícono se pasa a puntos.
- **El tiempo en puntos** (`TimeDots`): un punto por minuto; sobre 60 minutos, uno cada 5.
- **Accesibilidad:** se midió cada par de texto y fondo en los dos temas. Dos pares de la app no llegaban a 3:1 y 3.0 los corrige: el borde de CheckMark y RadioMark sin marcar y la flecha de las filas pasan de `gray` a `graphite`.

## Cambios de 3.0 respecto de la app 2.18

| Elemento | App 2.18 | 3.0 |
| --- | --- | --- |
| Azul | `#2A4BD7`, solo en lo que escribe la persona | `#3D38F5` (`#9A97FF` en oscuro): renglón, tiempo, dónde estás, foco y la voz de la persona |
| Campo de la actividad | Texto azul sobre línea de tinta | Texto en tinta sobre línea azul |
| Firma «Vuelve a ___.» | Sans 650, frase en azul con línea de tinta | Serif, frase en tinta sobre el renglón azul |
| Avance del tiempo | Barra de tinta | Puntos o barra azul |
| Pestaña elegida | Ícono más grueso | Ícono lleno y nombre sobre el renglón |
| Íconos Ruta y Perfil | Escalera y credencial | Recorrido con inicio y meta, y persona |
| Logotipo | Sin renglón | Con renglón |

## Supuestos

Para no dejar el sistema a medias, se usó lo recomendado donde el autor aún no decidió:

1. **Serif:** Newsreader. Si el autor elige Instrument Serif, cambia solo la familia `serif` en `tokens.json`.
2. **Color:** una sola tinta azul; «azul a celeste» queda descrita como variante.
3. **Trama en íconos:** solo en momentos de marca.

## Cómo se comprobó

- Las 45 vistas previas (43 componentes, «Pantallas» y la portada) se abrieron en un marco local que imita al de claude.ai, con React 18, los tokens compilados y los recursos. Se revisaron las capturas de todas en tema claro y de diez en tema oscuro. Se corrigieron siete detalles: chips estirados, alturas, la firma en capturas estáticas, los tonos del logotipo en fondos fijos, el fondo blanco de la foto en trama, los puntos del tiempo y el texto real de la señal.
- Los contrastes se calcularon con la fórmula de WCAG 2 y están en la nota de cada color.
- La copia del repositorio vuelve a generar archivos idénticos a los publicados.
- **No se comprobó** la página publicada en claude.ai: el navegador integrado no tiene la sesión del autor y la IA no inicia sesión. Tampoco se probó con personas si reconocen la marca o los íconos.

## Lo que falta

- Que el autor cierre las tres decisiones de «Supuestos».
- Aplicar 3.0 a la app (2.19), al archivo de Figma y a la presentación, en el orden que propone la sección «Aplicaciones».
- Redibujar con las reglas nuevas los 71 íconos que vienen de la app 2.18.
- Emoji: la app usa imágenes Noto 3D. En el sistema, `Avatar` y `EmojiTile` reciben esa imagen por `src`, y en las maquetas se usó el carácter del sistema operativo como sustituto.

## Registro de cambios (disclaimer)

### 2026-10-02 — Paso a 3.1

- **Qué cambió:** se avisa que la página publicada pasó a la versión 3.1 (documento 27).
- **Cómo estaba antes:** el documento describía la versión publicada.
- **Por qué:** el autor pidió seguir desarrollando el sistema.

### 2026-10-01 — Creación

- **Qué cambió:** se documentó el sistema de diseño 3.0: qué tiene, de qué fuentes salió, qué cambia respecto de la app, los supuestos, cómo se comprobó y lo que falta.
- **Cómo estaba antes:** la identidad D-098 era una lámina de propuesta (documento 25) sin tokens, componentes ni recursos utilizables.
- **Por qué:** pedido del autor del 1 de octubre.
