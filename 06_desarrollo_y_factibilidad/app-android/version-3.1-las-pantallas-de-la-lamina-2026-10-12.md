# Android 3.1: las pantallas de «Relevo, la app»

**Fecha:** 12 de octubre de 2026. **Decisión:** D-130. **APK:** [relevo-android-3.1-2026-10-12.apk](releases/relevo-android-3.1-2026-10-12.apk), versión optimizada de 12,8 MB. **SHA-256:** `6F7AA2BDCE29955EE742D8603C36B4F8A171D5ABE5769B3B17410F5E86A0DA77`. **versionCode:** 44.

## Pedido

El autor revisó la 3.0 y dijo que no se parecía a la lámina [«Relevo, la app»](https://claude.ai/artifact/E6nkPDDmDrDF9Gw8zNxnqM) ni a los últimos artefactos. Pidió mejorarla, sin errores.

## Por qué no se parecía

La 3.0 cambió los colores, la letra, los íconos y los cielos, pero conservó la composición de la 2.30:

- fotos grandes en la parte superior;
- listas agrupadas en un solo panel con separadores, como los ajustes de iOS;
- títulos muy grandes.

La lámina compone de otra forma: tarjetas blancas separadas, una ficha de color por fila, el nombre de cada actividad en una cápsula sobre su cielo, y el aura o el cielo a pantalla completa en los momentos clave (bienvenida, contando y suena). La 3.1 cambia la composición. La paleta, la letra y los íconos son los mismos de la 3.0.

## Qué cambia

### Piezas que usan todas las pantallas

- **Filas:** cada fila es su propia tarjeta blanca, con una ficha de color de 38 dp a la izquierda. Antes compartían un panel y se separaban con líneas.
- **Datos del relevo:** el valor va primero, en grande, y lo que significa va debajo, en gris. Un campo vacío dice «Sin completar». Si se puede editar, lleva un lápiz.
- **Actividades:** el cielo lleva el nombre en una cápsula blanca abajo y el ícono en un círculo pequeño arriba. La cápsula garantiza el contraste en cualquier cielo, porque el texto es tinta sobre blanco.
- **Encabezado con cielo:** es una franja más baja, dentro de una tarjeta.
- **Progreso de pasos:** un segmento por paso en lugar de una línea continua.
- **Títulos:** un tamaño menor, como en la lámina.
- **Barra de pestañas:** la cápsula de tinta tiene un ancho fijo y va centrada en su pestaña.
- **Fondo de pantalla completa:** el aura o el cielo pueden ir detrás de toda la pantalla.

### Pantalla por pantalla

| Pantalla | Cómo queda |
| --- | --- |
| Bienvenida | El aura ocupa toda la pantalla, con la marca, el logotipo y el descriptor encima. |
| Inicio | La tarjeta del relevo activo va sobre el aura pastel, con su estado, el avance («X de Y») y dónde sonará. Las ideas son cielos con cápsulas. |
| Contando | El aura ocupa toda la pantalla. El tiempo va grande al centro, con el total elegido debajo. |
| Suena | El cielo de la actividad ocupa toda la pantalla. El ícono va en un círculo blanco con los anillos del sonido, y las preguntas van en una tarjeta blanca. |
| ¿Qué decidiste? | Una etiqueta «Después de la señal», la miniatura del cielo y las tres respuestas en tarjetas con ficha rosada. |
| Ruta | Los pasos bajan en escalera, en tarjetas numeradas. El paso actual lleva borde de tinta y dice «Ahora». |
| Preparar | Una franja con el cielo y el nombre de la actividad en una cápsula. Al elegir actividad, una cuadrícula de cielos con cápsulas. |
| Perfil | El emoji, el nombre, los intereses y «Editar» van en una tarjeta. Los ajustes y la ayuda van en filas sueltas. |
| Cómo funciona | La app, lo que suena y tú van en tarjetas con ficha celeste, lima y rosada. Era un pendiente de la 3.0, que todavía usaba círculos de piedra. |

## Qué no cambia

- **Código:** solo cambian `ui/` y el número de versión. `data/`, `domain/`, `monitor/` y `signal/` son idénticos a los de la 3.0: `git diff` no muestra diferencias.
- **Datos:** las 14 preferencias, la base `relevo_research.db` (versión 9), Supabase y el consentimiento v13 son los mismos. No hay migración.
- **Instalación:** el paquete y la firma son los mismos (`cl.udp.relevo`, certificado `fdbe6bbe…`), así que se instala encima de la 3.0 o de la 2.30.
- **Pantallas y recorrido:** las mismas pantallas, en el mismo orden y con los mismos textos. Solo se agregaron dos rótulos: «Sin completar» y «Después de la señal».
- **Respuestas:** las tres respuestas de «¿Qué decidiste?» mantienen el orden y los valores que se guardan. Siguen iguales entre sí en tamaño, color y forma, para no inclinar la respuesta.

## Verificación

**Emulador** (Android 16), sin conexión mientras se probaba, para no enviar datos a Supabase:

| Prueba | Resultado |
| --- | --- |
| Compilación limpia y pruebas unitarias | 85 aprobadas, ningún fallo |
| Inicio, Ruta y Perfil | Coinciden con la lámina, con datos de prueba |
| Preparar (actividad, paso, apps, tiempo, lugar y revisión) | Correcto |
| Relevo de prueba completo | Contando, suena y «¿Qué decidiste?», sin errores |
| Primera vez, con datos limpios | Bienvenida sobre el aura, Cómo funciona, consentimiento, permisos, perfil, intereses y primer relevo |
| Tema oscuro | Correcto en Inicio, Ruta y Perfil |
| Datos del autor | Restaurados desde el respaldo: 15 archivos idénticos (MD5). Con la 3.1 muestran el mismo perfil, ruta e ideas |
| Firma | Mismo certificado que la 3.0 (`apksigner`) |

## Lo que no se probó

- No se probó en un teléfono real ni con el Tag.
- No se revisaron TalkBack ni la letra grande al 200 %.
- No se recorrieron una por una las pantallas menos usadas: historial, avisos, permisos, privacidad, editar perfil y ruta, estudio, cierre, opinión y reporte. Usan las mismas piezas nuevas.
- No se instaló la 3.1 encima de la 3.0 con un relevo contando. Como la capa de datos y el servicio no cambian, rige la prueba hecha en la 3.0.

## Pendiente

- **Cuándo instalarla:** no conviene hacerlo a mitad de la prueba de 21 días. Lo decide el autor.
- **Video de «Cómo funciona»:** todavía muestra la identidad anterior.
- **Elige su color:** no está implementado.
- **Memoria, capítulo 11:** describe la identidad de la 2.30. Si la 3.1 es la versión del prototipo, hay que actualizar su tercer párrafo y la Figura 2.

## Registro de cambios (disclaimer)

### 2026-10-12 — Creación

- **Qué se añadió:** la versión 3.1, por qué la 3.0 no se parecía a la lámina, lo que cambia, lo que no, su verificación y lo pendiente.
- **Cómo estaba antes:** la última versión era la 3.0, con la línea nueva aplicada sobre la composición de la 2.30.
- **Por qué:** pedido del autor (D-130).
