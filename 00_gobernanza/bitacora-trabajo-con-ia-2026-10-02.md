# Bitácora del trabajo con IA: 2 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code entre el 1 y el 2 de octubre de 2026, a pedido del autor. Continúa la [bitácora del 1 de octubre](bitacora-trabajo-con-ia-2026-10-01.md). Cada pedido está en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| Sistema de diseño 3.1 | Se publicó en la misma página de Claude Design y se documentó en el [documento 27](../10_recursos_visuales/27_sistema-de-diseno-3.1-2026-10-02.md), con su [copia de archivos](../10_recursos_visuales/sistema-de-diseno-3.1/README.md). | D-099 |
| Logotipo | «relevo» en Schibsted Grotesk 600 con un renglón en cápsula del grosor de la «e» que pasa la «o»; familia de 29 archivos; láminas de construcción y de exploración (seis posiciones del renglón y ocho ajustes). | D-099 |
| Tipografía | Dos voces: Relevo en Schibsted Grotesk y Newsreader romana; la persona en Newsreader itálica y en tinta; IBM Plex Mono para datos. Tres estilos nuevos en `tokens.json`. | D-099 |
| Color | Seis colores de la casa, uno por categoría de actividad, en OKLCH, con roles de renglón, texto y fondo en los dos temas; contraste y visión del color medidos. | D-099 |
| Recursos | 33 íconos nuevos (135 en total), 6 ilustraciones, 11 patrones, la lámina de color, 24 aplicaciones, el logotipo animado y la firma sonora. 106 recursos subidos. | D-099 |
| Páginas y libro de marca | 13 páginas de muestra con sus razones, portada nueva y libro de marca en diez secciones con referencias APA. | D-099 |

## 2. Cómo se usó la IA

- **El autor pidió y la IA desarrolló.** Las preferencias que el autor aún no decide se dejaron como supuestos (Newsreader, los colores de la casa, la itálica para la voz de la persona y la trama en íconos solo en momentos de marca).
- **Textos de fuentes reales:** las piezas usan textos de la app 2.18, de la guía de comunicación, de la memoria v4 y del documento 23. No se inventaron datos, citas ni participantes; los números son los de la memoria (8 entrevistas, 53 respuestas, una prueba de 21 días diseñada).
- **Herramientas propias:** un lector de la fuente variable para dibujar el logotipo en contornos, cálculo de la paleta en OKLCH con contraste WCAG y simulación de visión del color, y Chrome sin interfaz para capturar piezas, fichas y el logotipo animado.
- **Lo que la IA señaló:** el capítulo 11 de la memoria todavía describe la marca anterior (Source Sans 3 y verde `#006B5F`); no se cambió el texto académico.

## 3. Qué se comprobó y qué no

- **Comprobado:** las 60 vistas previas del sistema (46 componentes, la portada y 13 páginas) en un marco local; la portada y las páginas de logotipo, tipografía, paleta e iconografía también en tema oscuro; los contrastes de cada color de la casa; que los 106 recursos se subieron y quedaron en el índice; que la copia del repositorio no tiene rutas locales ni datos personales; las referencias nuevas en sus fuentes.
- **No comprobado:** la página publicada vista desde la cuenta del autor; la firma sonora en un parlante real; la impresión de afiches y tarjeta; si las personas reconocen la marca, los íconos o los colores.

## 4. Pendientes

- Que el autor decida los supuestos de D-099 (y los que siguen abiertos de D-098).
- Corregir el capítulo 11 de la memoria con la marca vigente, respetando sus límites de palabras.
- Aplicar 3.1 a la app 2.19, al archivo de marca de Figma y a la presentación.
- Siguen abiertos los pendientes técnicos del 30 de septiembre: teléfono real con la 2.18, Firebase y la revisión del consentimiento v11.

## Registro de cambios (disclaimer)

### 2026-10-02 — Creación

- **Qué se añadió:** resumen del trabajo del 1 y 2 de octubre: el sistema de diseño 3.1, cómo se hizo, qué se comprobó y qué falta.
- **Cómo estaba antes:** la última bitácora era la del 1 de octubre.
- **Por qué:** mantener el estado del proyecto al día para el autor y para la próxima sesión.
