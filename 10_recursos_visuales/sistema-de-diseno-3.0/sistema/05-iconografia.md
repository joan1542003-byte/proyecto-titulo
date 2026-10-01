# Iconografía

Relevo tiene 102 íconos propios. Se dibujaron para Relevo: de Material Design se tomaron la retícula y las figuras guía, y de SF Symbols, la idea de que el trazo siga al peso del texto. No se copió ningún dibujo, y las formas comunes (una casa, una papelera) son convenciones. Los SF Symbols solo se pueden usar en apps para sistemas de Apple.

## Reglas de dibujo

- **Retícula** de 24 con área útil de 20 y figuras guía: círculo de 20, cuadrado de 18 y rectángulos de 16 × 20 y 20 × 16 (Google, s. f.).
- **Trazo** de 1,75 a 24 px, con extremos y uniones redondeados. Cambia con el tamaño para que el peso se vea parejo: 1,9 a 16 px, 1,8 a 20, 1,75 a 24, 1,6 a 32 y 1,5 desde 48 (`stroke-*`). Junto a texto en 600 se usa 2,1, como SF Symbols empareja cada peso con la letra (Apple, s. f.).
- **Estados:** contorno para lo normal y lleno para lo elegido, como el eje de relleno de Material Symbols. Hay versión llena para las tres pestañas: `inicio-lleno`, `ruta-llena` y `perfil-lleno`.
- **Recortes:** donde una forma tapa a otra (los tiradores de `ajustes`, la cara de `perfil-lleno`), se recorta con una máscara. El ícono funciona sobre cualquier fondo.
- **El renglón:** los íconos propios de Relevo llevan una línea en `blue` en la base: `actividad`, `primer-paso`, `lugar`, `parlante` y `apps` (el cuadro elegido).

## Uso

- Siempre junto a una palabra. Solo los botones redondos (volver, cerrar, más opciones) van sin palabra, con un nombre accesible.
- Tamaños: 16 (flecha de fila), 18 (chips y botones compactos), 20 (botones), 22 (filas), 24 (pestañas), 34 (estrellas), 40 y 56 (fichas sin foto).
- Color: `ink`, o `graphite` en pestañas sin elegir. Nunca en azul, salvo el renglón.
- Al principio se reconoce mejor un ícono cercano a lo que hace y, con el uso, uno familiar (Isherwood et al., 2007). Por eso los de acción son formas conocidas y los propios de Relevo llevan palabra siempre.

## Inventario

**Dibujados para la propuesta D-098 (31):** 26 reemplazan a su par de la app 2.18, 2 son nuevos (`ruta`, que reemplaza a la escalera en la pestaña Ruta, y `senal`) y 3 son versiones llenas. actividad, advertencia, agregar, ajustes, apps, borrar, cambie, cerrar, comence, despues, editar, esperando, info, inicio, inicio-lleno, listo, lugar, parlante, perfil, perfil-lleno, permiso, primer-paso, privacidad, ruta, ruta-llena, senal, siguiente, silenciar, telefono, tiempo y volver.

**De la app 2.18 (71):** accesibilidad, avisos, ayuda, bateria, bicicleta, buscar, calendario, caminar, carta, cerrar-sesion, cocinar, codigo, comentario, conexion, consentimiento, contraer, copiar, datos, decision, desbloqueado, descargar, detener, dibujar, dormir, ejercicio, enlace-externo, entrevistas, enviar, error, escribir, estirar, estrella, estrella-llena, estrella-media, estudiar, expandir, exportar, filtrar, fotografia, guitarra, hipotesis, historial, investigacion, juego-de-mesa, leer, llamar, manualidades, mas, menu, mostrar, musica, objeto, ocultar, ordenar, pausar, pintar, plantas, probar, problema, reintentar, relevos, reproducir, salir, sin-conexion, sincronizar, sistema, tema, texto, uso, usuario y validacion.

Para la app 2.19 conviene revisar estos 71 con las reglas de arriba, para que todo el kit tenga el mismo dibujo que los 31 nuevos.

## Archivos

- Grupo Iconos: un SVG por ícono, de 24 × 24, trazo de 1,75 en `tinta` (`#17181C`) y renglón en `azul-500` (`#3D38F5`). Para otro color, usar el componente `Icon`, que dibuja con `currentColor`.
- Grupo Trama: `icono-trama-actividad`, `-lugar`, `-parlante`, `-senal`, `-inicio` y `-apps`, en 16 × 16 puntos.

## Registro de cambios (disclaimer)

### 2026-10-01 — Creación

- **Qué cambió:** se creó como parte del sistema de diseño 3.0 de Relevo, publicado en el tipo Design System de claude.ai.
- **Cómo estaba antes:** no existía; la identidad estaba en la propuesta D-098 (documento 25) y los componentes, solo en la app 2.18.
- **Por qué:** el autor pidió desarrollar y perfeccionar el sistema gráfico (comunicación, tono, colores y variantes) y pasarlo a Claude Design.
