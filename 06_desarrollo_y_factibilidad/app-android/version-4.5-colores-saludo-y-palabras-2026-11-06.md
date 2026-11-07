# Android 4.5: menos amarillo, el saludo del relevo y más palabras

**Fecha:** 6 de noviembre de 2026. **Decisiones:** [D-162 y D-163](../../09_decisiones/registro-de-decisiones.md). **Rama:** `android-4.5`, sobre `iconos-propios` (los íconos de D-162) y la 4.4. **Versión:** 4.5, `versionCode` 56. **APK:** [relevo-android-4.5-2026-11-06.apk](releases/relevo-android-4.5-2026-11-06.apk), 10,6 MB, optimizada. Paquete `cl.udp.relevo`, firmada con el certificado de siempre (`fdbe6bbe…`) y con Supabase: se instala encima de la 4.4 y de las anteriores. SHA-256: `7D72FC4D5100A7A913FE26A272B631EB5824D236B68CD0B0C732A02B84A2B550`.

## Qué pidió el autor

- Más palabras y frases clave para cuando una persona crea un relevo propio, y documentarlas todas.
- Bajar lo amarillo: los temas claro y oscuro se veían demasiado amarillentos.
- Que el saludo de Inicio, «Hola, nombre», lleve el degradado del relevo activo: si el relevo es azul, el saludo es azul.
- Arreglar un error del selector de íconos: al elegir uno de otra familia mientras pasaba la animación, el color quedaba pegado en el nombre de la familia.

## Qué cambió

### Los íconos de D-162

La 4.5 trae los once íconos rehechos según lo que pide la app ([documento 44](../../10_recursos_visuales/44_iconos-desde-lo-que-pide-la-app-2026-11-06.md)).

### Palabras y frases clave

- **El catastro creció:**
  - de 322 a **634 palabras**;
  - de 20 a **121 frases**;
  - de 21 a **31 palabras débiles**.

  Siguen siendo 34 conceptos, y ninguna palabra pertenece a dos.
- **Qué se sumó:**
  - conjugaciones («caminando», «pintando»);
  - sinónimos;
  - nombres de juegos, instrumentos, materias y deportes;
  - palabras del español de Chile, como «pichanga», «carioca», «once», «carrete», «lagartijas», «quiltro», «greda», «preu» y «PAES».
- **Las frases deciden los casos dudosos:**
  - «maratón de series» es de películas y no de correr;
  - «novela gráfica» es de manga y no de leer;
  - «dar una vuelta en bici» es de bicicleta y no de caminar;
  - «llamar a mi mamá» es llamar y no compartir.
- **Clase y curso suman poco**, porque pueden ser de cualquier cosa: «clase de yoga» es yoga.
- **Instrumentos:** se suman la batería, el acordeón, el arpa, el clarinete, la armónica y otros, cada uno con su objeto («Sacar la batería del estuche»).
- **Documentado:** el [catastro de palabras clave](textos/catastro-de-palabras-clave.md) lista, por concepto, sus palabras, frases, palabras débiles, primeros pasos y lugares. Se genera desde `Catastro.kt` con `node generar-catastro.js`, así que dice lo mismo que la app.
- **Pruebas:** tres pruebas nuevas fijan los casos de arriba.

### Menos amarillo

Los neutros tenían el tono de la crema (OKLCH h 68–75°). Ahora tienen un 40 % de su croma y el tono en 60°: un papel apenas tibio, no crema. La luminosidad no cambia, así que los contrastes tampoco: la tinta sobre el papel sigue en 16,9:1 y el grafito, en 5,2:1.

| Color | Claro, antes | Claro, ahora | Oscuro, antes | Oscuro, ahora |
| --- | --- | --- | --- | --- |
| Papel | `#F7F4F0` | `#F6F4F3` | `#141312` | `#141313` |
| Tarjeta | `#FFFFFF` | `#FFFFFF` | `#1F1D1B` | `#1E1D1C` |
| Piedra | `#EEE9E3` | `#ECE9E7` | `#2A2724` | `#292726` |
| Línea | `#E4DED6` | `#E2DEDC` | `#36322E` | `#343231` |
| Gris | `#A9A197` | `#A6A19E` | `#6E6862` | `#6B6966` |
| Grafito | `#6B655F` | `#686663` | `#ABA49C` | `#A8A4A2` |
| Tinta | `#141312` | `#141313` | `#F2EEE9` | `#F0EEED` |

El fondo de la pantalla de inicio de Android cambia igual, en `themes.xml`.

### El saludo, con el color del relevo

Con un relevo contando, «Hola, nombre» va en el degradado del anillo de su actividad, de izquierda a derecha. Si hay varios, toma el de la tarjeta, que es el que sonará primero.

Algunos colores del anillo, como el menta o el ámbar, quedan bajo el contraste mínimo para texto grande (3:1, WCAG 2.2). Esos colores se acercan a la tinta solo lo necesario para alcanzarlo. Sin un relevo contando, el saludo vuelve a la tinta.

### El color pegado del selector

**La causa:** al elegir un ícono de otra familia, la primera recibía la señal de no pulsar y su animación se cancelaba sin terminar. El degradado quedaba a medio camino en las letras.

**El arreglo:** ahora esa familia vuelve a la tinta en un cuarto de segundo (`FamilyLabel.kt`).

## Verificación

- **Compilación desde cero:** sin advertencias y con 93 pruebas unitarias, tres más que en la 4.4.
- **APK:** paquete `cl.udp.relevo`, versión 4.5 (`versionCode` 56), certificado `fdbe6bbe…` y la dirección de Supabase incluida.
- **Emulador, sin conexión y sobre los datos del autor**, respaldados antes y restaurados idénticos al terminar:
  - **Inicio:** con «Hacer manualidades» contando, el saludo va de naranja a violeta, como su anillo, en el tema claro y en el oscuro.
  - **Fondos:** el papel y el fondo oscuro ya no se ven crema.
  - **Selector:** dos toques rápidos en familias distintas («Moverte» y «Leer y aprender») dejan las dos en tinta.

**Falta probar:**

- El reconocimiento de las palabras nuevas con lo que escriben personas reales.
- La 4.5 en un teléfono real.

## Registro de cambios (disclaimer)

### 2026-11-06 — Creación

- **Qué cambió:** se documenta la versión 4.5.
- **Cómo estaba antes:** la versión actualizable era la 4.4.
- **Por qué:** el autor pidió más palabras clave, menos amarillo, el saludo con el color del relevo y arreglar el selector.
