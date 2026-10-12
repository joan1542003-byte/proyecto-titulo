# Android 3.0: la línea nueva, sin perder nada

**Fecha:** 12 de octubre de 2026. **Decisión:** D-129, que aplica D-128. **APK:** [relevo-android-3.0-2026-10-12.apk](releases/relevo-android-3.0-2026-10-12.apk), versión optimizada de 12,8 MB. **SHA-256:** `7731B0013B8AC90D850B4FB7C1C6B4AE75C99ED515D2A6F89538F8E3A052E840`. **versionCode:** 43.

## Pedido

El autor pidió implementar la actualización del diseño de la app, «perfecta, sin errores», siguiendo el [plan del rediseño 3.0](plan-rediseno-3.0-2026-10-11.md): la línea nueva sin perder pantallas, decisiones ni datos.

## Qué cambia

- **Colores:** tema nuevo con papel `#F7F4F0`, tinta `#141312` y las seis fichas de la paleta 2.
  - Cada ícono de fila va en una ficha con el color de su papel (D-124, D-127). El lugar es lima. El Tag y el teléfono van en piedra, porque son el medio.
  - La selección va en tinta, y lo que escribe la persona también.
- **Letra:** Instrument Sans variable (OFL), dentro de la app. Reemplaza a Schibsted Grotesk.
- **Íconos:** 67 nombres del kit se dibujan con los íconos propios de D-124, y se suman «Suena» y «Ruta».
  - Los nombres del enum no cambian, porque se guardan en las actividades.
  - El trazo sigue los tamaños ópticos (2,0 a 16 dp; 1,6 a 24 dp).
- **Actividades:** se pintan con los siete cielos de D-126 (con grano) y su ícono en tinta sobre un círculo blanco.
- **Aura (D-121):**
  - Se dibuja con un sombreador en Android 13 o superior y queda quieta en Android 12 o si se quita el movimiento.
  - Aparece en la bienvenida, mientras cuenta un relevo y en Apariencia.
  - En Apariencia se elige apagada, suave, media o viva; parte en media.
- **Suena:** el cielo de la actividad, con el sonido en anillos de tinta alrededor del ícono. No hay luz: el Tag solo suena.
- **Logo (D-125, D-127):**
  - La bienvenida muestra la marca con degradado «Luz», el logotipo y el descriptor.
  - Inicio muestra la marca pequeña junto al logotipo.
  - El ícono de la app es la marca con degradado sobre blanco, y hay una silueta para el ícono temático.
  - La notificación muestra la marca en silueta.
- **Piezas:**
  - Los botones secundarios son blancos con contorno de tinta.
  - Las opciones rápidas son blancas con borde fino, y la elegida va en tinta.
  - Los campos de texto son cajas blancas.
  - La barra de pestañas marca el destino con una cápsula de tinta.
  - Los títulos con las palabras de la persona van en dos tonos, sin subrayado.
- **Guía del Tag:** el halo de colores detrás del Tag pasa a ser una superficie de piedra. Un halo sugería que el Tag emite luz.
- **Tema oscuro «Noche»:** se conserva para quien lo eligió, con los mismos papeles.

## Qué no cambia

- **Instalación y firma:** el paquete y la firma son los mismos (`cl.udp.relevo`, certificado `fdbe6bbe…`). La 3.0 se instala encima de la 2.30.
- **Código:** no se modificaron `domain/`, `monitor/` ni `signal/`. En `data/` solo se agregó la preferencia del aura (siete líneas, clave nueva `aura` con valor por defecto).
- **Datos en el teléfono:** los 14 archivos de preferencias y la base `relevo_research.db` siguen en la versión 9, sin migración.
- **Datos en Supabase:** no cambia el esquema ni los eventos. El estado que se envía no incluye el ajuste del aura.
- **Recorrido:** las 26 rutas, los seis pasos de preparar, los textos de la investigación y la versión del consentimiento son los mismos.
- **Respuestas:** las tres respuestas de «¿Qué decidiste?» siguen con el mismo tamaño, color y lugar.

## Verificación

**Emulador** (Android 16), con los datos que tenía con la 2.30 y sin conexión, para no enviar nada a Supabase:

| Prueba | Resultado |
| --- | --- |
| Instalar la 3.0 encima de la 2.30, sin abrirla | Las 13 preferencias y la base quedaron **idénticas byte a byte** (MD5) |
| Abrir la 3.0 | Mismo perfil, emoji, intereses, ruta y relevo preparado, con el diseño nuevo |
| Actualizar con un relevo contando | Android reinició el servicio tras la actualización (`MY_PACKAGE_REPLACED`) y el relevo siguió en espera |
| Recorrido completo de un relevo de 15 segundos con el Reloj | Preparar, activar, contar, sonar en el teléfono, preguntas y decidir, sin errores |
| Primera vez, con datos limpios | Bienvenida con la marca sobre el aura, cómo funciona y el consentimiento |
| Tema oscuro | Correcto, con los mismos papeles |
| Versión optimizada (R8) sobre los mismos datos | Abre, muestra los emoji del perfil y dibuja el aura; ningún cierre en el registro de fallos |
| Fluidez (`gfxinfo`) | Desplazar Inicio: 4 % de cuadros lentos y 20 ms de mediana (2.28: 6 % y 19 ms). Aura animada: 0,95 % de cuadros lentos, unos 52 cuadros por segundo |
| Pruebas unitarias | 85, todas aprobadas, tras una compilación limpia |
| Firma | Mismo certificado que la 2.30 (`apksigner`) |

- **Datos restaurados:** al terminar, el emulador quedó con la 3.0 y con sus datos originales restaurados desde el respaldo, idénticos (MD5). No se escribieron archivos nuevos en Documentos/Relevo.
- **Clave respaldada:** la clave de firma se respaldó fuera de la carpeta de compilación, en `OneDrive/Documents/Relevo-respaldo-firma`.

## Lo que no se probó

- No se probó en un teléfono real ni con el Tag real.
- No se revisaron TalkBack ni la letra grande al 200 %. El contraste de las fichas y del texto se calculó en las láminas, no en el teléfono.
- No se revisaron una por una las rutas menos usadas: historial, avisos, permisos, privacidad, editar perfil y ruta, estudio, cierre, opinión y reporte. Usan las mismas piezas, pero no se recorrieron en esta versión.

## Pendiente

- **Cuándo instalarla:** no conviene hacerlo a mitad de la prueba de 21 días (plan 3.0). Lo decide el autor.
- **Material antiguo:**
  - El video de «Cómo funciona» todavía muestra la identidad anterior: números en azul.
  - Las filas de «Cómo funciona» siguen en círculos de piedra.
- **Elige su color:** no está implementado. Cada actividad propia tiene un campo `color` guardado y sin uso; se puede activar con valores desde 100.
- **Memoria, capítulo 11:** describe la identidad de la 2.30 (Schibsted y azul). Si la 3.0 es la versión del prototipo, hay que reemplazar su tercer párrafo por la versión breve del [documento 41](../../10_recursos_visuales/41_fundamento-del-color-texto-academico-2026-10-11.md) y actualizar la Figura 2.

## Registro de cambios (disclaimer)

### 2026-10-12 — Creación

- **Qué se añadió:** la versión 3.0, lo que cambia y lo que no, su verificación y lo pendiente.
- **Cómo estaba antes:** la última versión era la 2.30, con la identidad D-073 ajustada (Schibsted Grotesk, azul para lo escrito y degradados de seis colores).
- **Por qué:** pedido del autor (D-128 y D-129).
