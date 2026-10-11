# Bitácora del trabajo con IA: 8 al 11 de octubre de 2026

**Estado:** registro de lo hecho con Claude Code entre el 8 y el 11 de octubre de 2026. Continúa la [bitácora del 7 de octubre](bitacora-trabajo-con-ia-2026-10-07.md). Cada pedido está, con sus palabras resumidas, en el [registro de pedidos](registro-de-pedidos-a-la-ia.md).

**Rama:** `android-2.7` y `main` quedan en el mismo commit en GitHub.

## 1. Qué se hizo

| Fecha | Trabajo | Resultado | Decisión |
| --- | --- | --- | --- |
| 8 oct. | Apps y productos parecidos | Respuesta en la conversación: one sec, Brick, Unpluq, ScreenZen y Tiempo de pantalla resuelven partes del problema, pero ninguno recuerda una actividad propia con su primer paso ni avisa desde un objeto ubicado donde se empieza. Se recomendó no llamar «único» a Relevo y hacer una revisión formal para la memoria. | — |
| 9 oct. | Android 2.30 | Editar un relevo sin borrarlo, antes y después de activarlo; si cuenta las mismas apps, sigue con el tiempo que llevaba ([detalle](../06_desarrollo_y_factibilidad/app-android/version-2.30-editar-sin-borrar-2026-10-09.md)). | D-120 |
| 10 oct. | Relevo con aura, versiones 1 y 2 | Exploración inspirada en Dafi (Behance). El autor pidió perfeccionarla, verla en blanco y no traer nada de lo que ya existe de Relevo; la versión 2 tiene solo modo claro, aura dibujada en tiempo real con grano, cielos por actividad, seis pantallas y piezas nuevas ([documento 38](../10_recursos_visuales/38_relevo-con-aura-2026-10-10.md)). | D-121 |
| 11 oct. | Relevo con aura, versión 3 | El aura es de la pantalla y se personaliza en Perfil › Tu aura; el Tag solo suena. Tablero de presentaciones. | D-121 |
| 11 oct. | Taller de auras, versión 1 | Generador de fondos con aura: presets de presentación, auras, cielos y elementos; formatos para diapositivas y la memoria; descarga en PNG. | D-121 |
| 11 oct. | Taller de auras, versión 2 | El autor pidió las piezas con diseño de la exploración, como «3 de 5». Ahora son 39 piezas editables (datos, fichas, tarjetas, controles, marca y siete pantallas), que salen solas en PNG transparente, copiadas, en lámina o en ZIP ([taller](../10_recursos_visuales/relevo-con-aura-2026-10-10/taller-de-auras.html)). | D-121 |
| 11 oct. | Sin giros | Las tarjetas y las piezas quedan derechas en el taller y en la lámina de la exploración. | D-121 |
| 11 oct. | Relevo con aura, versión 4 | Una gráfica propia: íconos después de lo que nombran, un color con un solo papel, la marca de los cuatro peldaños, el Tag que suena en anillos, y los tableros «El traspaso» y «Sistema» ([documento 38](../10_recursos_visuales/38_relevo-con-aura-2026-10-10.md)). | D-122 |
| 11 oct. | Íconos y color con fundamento | 72 íconos propios y la paleta 2. Cada color tiene un papel, fundado en estudios de 31 países, en ISO 3864 y en medidas en OKLCH, contraste y daltonismo ([documento 39](../10_recursos_visuales/39_iconos-y-color-con-fundamento-2026-10-11.md); [lámina](https://claude.ai/artifact/NHpnEr63JXn6JqCfDotPC2)). | D-124 |
| 11 oct. | Logo, colores y recorrido | Un logo de cuatro luces planas con Chillax Semibold; la evidencia de color de Chile y Latinoamérica; siete familias de cielos para las actividades; y el recorrido en 12 wireframes con notas ([documento 40](../10_recursos_visuales/40_logo-colores-y-recorrido-2026-10-11.md); [lámina](https://claude.ai/artifact/5FCdqi76iF52dfNoFyYoeX)). | D-125 y D-126 |
| 11 oct. | Documentación | El autor preguntó si todo estaba documentado. Faltaban esta bitácora, el estado en el README general y en el traspaso desde la app 2.24, y la decisión de la dirección visual; se completaron. | D-121 |

## 2. Cómo se usó la IA

- **La referencia se miró, no se copió:** las imágenes y videos de Dafi se revisaron en el navegador, sin descargarlos ni guardarlos. Todo lo de la exploración y del taller se dibujó de nuevo, sin material de la referencia.
- **El autor corrigió el rumbo cuatro veces:**
  - La versión 1 «no era similar» y se veía en oscuro.
  - El Tag no emite luz, así que el aura pasó a ser de la pantalla.
  - El taller no traía las piezas diseñadas.
  - Las piezas no debían girarse.

  En los cuatro casos la IA propuso y ejecutó, y el autor decidió.
- **Revisión con capturas:** cada versión se revisó en Chrome sin ventana, con capturas de escritorio y de teléfono y hojas de contacto con todas las piezas exportadas. Así se encontraron:
  - un grano con patrón diagonal en algunas pantallas, que se cambió por otro generador de ruido;
  - capturas en blanco por el desplazamiento de la página;
  - un error del taller que perdía lo editado: cada lectura recreaba los valores de la pieza;
  - miniaturas de pantallas demasiado chicas;
  - y el collage de la lámina disperso tras quitar los giros, que se ordenó en dos filas.
- **Referencias verificadas:** para la versión 4 se buscaron y se leyeron las fuentes de Apple (2024), Google Gemini e Instagram antes de citarlas; una afirmación sobre Instagram («momentos de descubrimiento») no se pudo confirmar en la fuente y se dejó fuera.
- **Medir antes de afirmar:**
  - Para los íconos se midió el asta de Instrument Sans en el navegador.
  - Para el color se calcularon la luminosidad y la saturación en OKLCH, el contraste según WCAG y la separación entre colores con daltonismo simulado. Así apareció que el amarillo y el lima casi se confundían, y se corrigió.
  - Los datos de las citas se comprobaron en Crossref.
  - Para los cielos se midió el contraste del texto en capturas, sobre el píxel más desfavorable del fondo. El texto blanco quedaba entre 2,6:1 y 3,7:1 en los cielos claros; con la cápsula blanca sube a entre 15:1 y 17,8:1.
- **Buscar evidencia local antes de suponerla:** se buscó un estudio de color hecho en Chile y no se encontró. Se usó una encuesta que incluye a Chile, presentada por la UNAM; por ser un boletín de prensa se marcó como apoyo y no como prueba. Una cifra del estudio de Medellín se corrigió antes de publicar: el azul tiene cerca de 75 % de aceptación, pero no es el color preferido.
- **El logo se probó en lo difícil:** la primera marca, con las luces mezcladas, dejaba un centro turbio; la elegida usa cortes planos. Se compararon 20 letras antes de elegir Chillax, y la fuente quedó fuera del repositorio.
- **Datos honestos:** las cifras de las piezas («3 de 5», «12 de 30 min», los minutos por app) son ejemplos de interfaz, no resultados. La única cifra real es la de las 53 respuestas de la encuesta (D-092). El saludo de la pantalla de inicio ya no usa un nombre de persona.

## 3. Qué se comprobó y qué no

- **Comprobado:**
  - En el taller se exportaron las 39 piezas sin errores y se recorrieron con clics la edición, la lámina, el respaldo cuando no hay descarga, los fondos y la persistencia al recargar.
  - Se generó y se abrió un ZIP.
  - Ni el taller ni la lámina se desbordan a lo ancho en un teléfono de 390 px.
  - La 2.30 se compiló, pasó sus pruebas unitarias y se revisó en el emulador.
- **No comprobado:**
  - La descarga y el botón «Copiar» dentro de claude.ai con la confirmación real; en la prueba solo se vio el respaldo.
  - La 2.30 en un teléfono real, incluido que siga con el tiempo contado al editar.
  - El aura en la app Android, que no está implementada.

## 4. Pendientes

- Que el autor revise el logo (D-125) y los colores de las actividades (D-126), y buscar en INAPI si hay marcas parecidas.
- Llevar el aura a la app solo si el autor lo pide. Se sugirió empezar por Perfil › Tu aura.
- Probar la 2.30 en un teléfono real.
- Revisar el consentimiento v13 con el profesor.
- Hacer la revisión formal de apps y productos parecidos para la memoria.
- Probar en claude.ai la descarga, el ZIP y «Copiar» del taller.

## Registro de cambios (disclaimer)

### 2026-10-11 — Logo, colores y recorrido

- **Qué cambió:** se sumaron el logo, la evidencia regional, los colores de las actividades y el recorrido, con cómo se midieron.
- **Cómo estaba antes:** terminaba en los íconos y la paleta 2.
- **Por qué:** pedido del autor (D-125 y D-126).

### 2026-10-11 — Íconos y color

- **Qué cambió:** se sumaron los íconos y la paleta 2, y cómo se midieron.
- **Cómo estaba antes:** terminaba en la versión 4 de la gráfica.
- **Por qué:** pedido del autor (D-124).

### 2026-10-11 — Versión 4

- **Qué cambió:** se sumó la versión 4 de la gráfica y cómo se verificaron sus referencias.
- **Cómo estaba antes:** la bitácora terminaba en la documentación pendiente.
- **Por qué:** pedido del autor (D-122).

### 2026-10-11 — Creación

- **Qué se añadió:** la bitácora del 8 al 11 de octubre: apps parecidas, Android 2.30, «Relevo con aura» de la versión 1 a la 3, el Taller de auras en sus dos versiones, las piezas sin giros y la documentación que faltaba.
- **Cómo estaba antes:** la última bitácora era la del 7 de octubre; lo hecho después solo estaba en el registro de pedidos y en los documentos de cada entrega.
- **Por qué:** el autor preguntó si todo estaba documentado y la revisión mostró este vacío.
