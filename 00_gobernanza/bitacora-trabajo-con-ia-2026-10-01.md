# Bitácora del trabajo con IA: 1 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code el 1 de octubre de 2026, a pedido del autor. Continúa la [bitácora del 30 de septiembre](bitacora-trabajo-con-ia-2026-09-30.md). Cada pedido está en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Trabajo | Resultado | Decisión |
| --- | --- | --- |
| Sistema de diseño 3.0 | La identidad D-098 se desarrolló como sistema completo y se publicó en el tipo Design System de claude.ai ([documento 26](../10_recursos_visuales/26_sistema-de-diseno-3.0-2026-10-01.md)). Libro de marca con principios y siete secciones (voz y tono, color y variantes, logotipo, trama, iconografía, aplicaciones y fundamentos), tokens en tema claro y oscuro, 43 componentes en React escritos desde los de la app 2.18, 124 recursos (102 íconos, logotipo, ícono de la app, trama y 6 fotos CC0) y una portada. Los archivos y los programas que los generan quedaron en el [repositorio](../10_recursos_visuales/sistema-de-diseno-3.0/README.md). | D-098, decidida en parte |

## 2. Cómo se usó la IA

- **El autor pidió y la IA desarrolló.** Para no dejar el sistema a medias, la IA usó lo recomendado en las tres decisiones que el autor aún no cierra (Newsreader, una sola tinta y trama en íconos solo en momentos de marca) y lo dejó escrito como supuesto.
- **Fuentes reales:** los colores, la escala de texto, las medidas y los íconos salen del código de la app; el logotipo, de su archivo SVG; la identidad, de la lámina v3. No se inventaron valores.
- **Límites que la IA hizo explícitos:** dos pares de color de la app no llegaban a 3:1 y 3.0 los corrige; los emoji Noto 3D se reemplazan en las maquetas por el carácter del sistema; la página publicada no se pudo abrir desde el navegador integrado porque requiere la sesión del autor.

## 3. Qué se comprobó y qué no

- **Comprobado:** las 45 vistas previas (43 componentes, la página «Pantallas» y la portada) en un marco local con React 18 y los tokens compilados, en tema claro, y diez de ellas en tema oscuro; los contrastes de cada par de texto y fondo en ambos temas; que la copia del repositorio vuelve a generar archivos idénticos a los publicados; y que los 124 recursos se subieron y quedaron registrados en el índice.
- **No comprobado:** la página publicada vista desde la cuenta del autor; el sistema aplicado en la app, en Figma o en la presentación; si las personas reconocen la marca y los íconos.

## 4. Pendientes

- Cerrar las tres decisiones abiertas de D-098: la serif, una tinta o azul a celeste, y la trama en los íconos.
- Aplicar 3.0 a la app 2.19, al archivo de marca de Figma y a la presentación.
- Redibujar con las reglas nuevas los 71 íconos que vienen de la app 2.18.
- Siguen abiertos los pendientes del 30 de septiembre: teléfono real con la 2.18, Firebase y la revisión del consentimiento v11.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué se añadió:** resumen del trabajo del 1 de octubre: el sistema de diseño 3.0, cómo se hizo, qué se comprobó y qué falta.
- **Cómo estaba antes:** la última bitácora era la del 30 de septiembre.
- **Por qué:** mantener el estado del proyecto al día para el autor y para la próxima sesión.
