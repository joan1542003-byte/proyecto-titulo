# Exploración visual de Relevo: punto, pulso y lugar

**Fecha:** 25 de septiembre de 2026.
**Estado:** exploración con recomendación. Reabre parcialmente el [sistema de marca vigente](14_sistema-de-marca-vigente.md) y queda pendiente de la decisión del autor (propuesta D-067).
**Lámina visual:** [`lamina-exploracion-visual-2026-09-25.html`](lamina-exploracion-visual-2026-09-25.html). Abrir en un navegador; contiene las tres direcciones, la dirección recomendada aplicada a la app, al objeto, a la memoria y a una pieza de comunicación, y la tabla de contraste.

## Por qué rehacer la exploración

El sistema cerrado el 16 de septiembre es claro y sobrio, pero tiene tres problemas que aparecieron al construir la aplicación:

1. **Es poco reconocible.** Un logotipo solo tipográfico, una familia sans y un verde localizado describen correctamente una herramienta, pero no la distinguen. La propia investigación advertía este riesgo en la dirección «herramienta serena»: «puede parecer una aplicación genérica» ([direcciones](08_direcciones-y-recomendacion.md)).
2. **La aplicación ya se separó de la marca.** Android 2.6 usa verde `#087A69` en lugar de `#006B5F`, introdujo un coral (`#F47F68`) para el foco de la señal y un ícono con un punto coral y dos anillos sobre verde ([diseño de la app](../06_desarrollo_y_factibilidad/app-android/DISENO-Y-EXPERIENCIA.md)). Esas decisiones funcionan en la interfaz, pero la marca no las recoge.
3. **El coral actual no cumple el contraste mínimo como elemento de interfaz.** Sobre el fondo claro, `#F47F68` alcanza 2,44:1; las Pautas de Accesibilidad para el Contenido Web piden 3:1 para componentes gráficos y 4,5:1 para texto. Sirve como relleno detrás de texto oscuro (6,75:1 con grafito), pero no como texto ni como único indicador.

Además, las exploraciones anteriores se describieron **sin imágenes** para no fijar una forma antes de tiempo. Ahora existen una app, un objeto con dimensiones objetivo (42–48 mm de diámetro, 12–16 mm de grosor) y una señal definida para las pruebas (tres pulsos de luz blanca cálida en tres segundos), de modo que ya es posible y necesario ver las alternativas.

## Qué debe expresar la marca

La estrategia no cambia ([estrategia de marca](13_estrategia-de-marca-desde-el-producto.md)): Relevo es un **recordatorio físico que se prepara desde el teléfono**, relaciona una actividad elegida con un lugar y deja la decisión abierta. Sus cuatro atributos siguen siendo claro, considerado, discreto y útil. De la investigación se derivan cinco exigencias visuales:

- **Separar preparar de avisar.** La mayor parte del tiempo Relevo está en reposo; el aviso es un momento breve. La identidad debe tener un color de estructura y otro reservado para ese momento (criterio C4 y dirección C, «sistema de transición»).
- **Mostrar un lugar, no un teléfono.** El objeto está *junto a* algo. La marca debe poder dibujar esa relación sin ilustrar pantallas.
- **Calma y discreción.** Las personas entrevistadas pidieron señales calmadas, discretas o visuales (P3–P5 y P7–P8) y una rechazó las comparaciones entre días (P7). Nada de alarmas rojas, trofeos ni gráficos de progreso.
- **Un solo recurso reconocible**, útil en tamaños pequeños: ícono de la app, ícono monocromo de notificación, marca en el objeto, diagramas de la memoria.
- **Accesible en ambos temas** y sin depender solo del color (criterio C7 y pautas W3C).

## Tres direcciones

Las tres conservan el nombre, la frase, el descriptor y Source Sans 3. Difieren en el recurso de reconocimiento, el papel del color y la relación con el objeto.

### A. Tipográfica serena (sistema del 16 de septiembre)

- **Idea:** la identidad es el nombre bien compuesto y un verde localizado.
- **Logotipo:** «Relevo» en Source Sans 3 Semibold; `R` para espacios pequeños.
- **Color:** base neutra, verde `#006B5F`; sin color de señal.
- **Objeto:** superficie neutra con el nombre grabado.
- **Fortalezas:** mínimo costo, máxima legibilidad, ya documentada.
- **Riesgos:** genérica; no explica el mecanismo; la `R` no se distingue en un cajón de aplicaciones; no ordena el coral que la app ya usa.

### B. Punto y pulso (recomendada)

- **Idea:** el símbolo representa al testigo y su señal: un **punto** (el objeto) con **arcos** que se abren a un lado (el pulso), apoyado sobre una **línea** corta (el lugar donde queda). En reposo se usa el punto solo; en el momento de aviso aparecen los arcos.
- **Logotipo:** símbolo a la izquierda del nombre, alineado a la altura de la x. El punto mide lo mismo que el grosor de la letra `o` escalado, para que el conjunto se lea como una sola pieza.
- **Color:** verde Relevo para estructura y acciones; **coral de señal** reservado al momento del aviso y al punto del símbolo; coral profundo para texto e íconos sobre fondo claro.
- **Objeto:** disco de 44 mm de diámetro y 14 mm de grosor, cuerpo neutro cálido, difusor claro en la cara superior y un punto coral grabado en el borde que indica dónde mirar. La luz sigue siendo blanca cálida: el coral es una marca del objeto, no el color de la señal luminosa.
- **Movimiento:** el pulso se anima como tres arcos que aparecen en tres segundos, igual que el patrón de prueba, y se detiene. Con movimiento reducido, los arcos aparecen sin animación.
- **Fortalezas:** el símbolo explica el mecanismo en una imagen; ordena la app actual (el ícono ya es un punto con anillos); funciona a 24 dp en monocromo; da un recurso gráfico único para diagramas.
- **Riesgos:** puede leerse como ícono de Wi-Fi o de transmisión (hay que probarlo); el coral puede asociarse a alerta si se usa en exceso.

### C. Lugar reservado

- **Idea:** parte de la frase «Hazle lugar»: un **corchete abierto** que reserva un espacio en el que aparece un punto.
- **Tipografía:** titulares en Source Serif 4 y texto en Source Sans 3, para un tono editorial y doméstico.
- **Color:** neutros cálidos (arena, lino), verde oscuro y un ocre suave.
- **Objeto:** base de madera clara o textil con un punto luminoso.
- **Fortalezas:** conecta con la frase de marca y con el hogar; cálida.
- **Riesgos:** se acerca a la estética genérica de bienestar; baja el contraste; agrega una segunda familia; el corchete no se entiende a tamaño pequeño y no explica la señal.

## Comparación

| Criterio | A. Tipográfica serena | B. Punto y pulso | C. Lugar reservado |
| --- | --- | --- | --- |
| Reconocimiento | Bajo | Alto | Medio |
| Explica el mecanismo | No | Sí: objeto, lugar y pulso | Parcial: el lugar |
| Coherencia con la app 2.6 | Baja: no recoge coral ni ícono | Alta: formaliza lo implementado | Baja: exige rediseño |
| Funciona a 24 dp | Sí, como `R` | Sí, punto y un arco | No |
| Accesibilidad | Alta | Alta con los valores corregidos | Media: neutros de bajo contraste |
| Riesgo de lectura errónea | Aplicación genérica | Señal inalámbrica o alerta | Producto de bienestar o decoración |
| Costo de producción | Mínimo | Bajo: símbolo simple y tokens | Medio: segunda familia, fotografía propia |

## Recomendación: B, con la regla fotográfica de C

La dirección B es la única que resuelve los tres problemas de partida: da un recurso reconocible, explica el mecanismo sin palabras y convierte en sistema lo que la aplicación ya hace. De la dirección C se conserva la fotografía de objetos cotidianos sobre fondos claros con luz suave, que la app ya usa en sus tarjetas de actividad.

### Paleta propuesta

| Token | Valor | Uso | Contraste |
| --- | --- | --- | --- |
| Verde Relevo | `#006B5F` | Acciones, selección, navegación, logotipo sobre claro | 6,03:1 sobre fondo; texto AA |
| Verde claro | `#72DBC7` | Equivalente en tema oscuro | 11,13:1 sobre oscuro |
| Coral de señal | `#F47F68` | Punto del símbolo, momento de aviso, rellenos con texto grafito encima | 6,75:1 con grafito; no usar como texto sobre claro |
| Coral profundo | `#C4492F` | Texto o ícono de señal sobre fondo claro | 4,54:1 sobre fondo; texto AA |
| Grafito | `#171A18` | Texto, logotipo principal | 16,46:1 sobre fondo |
| Blanco cálido | `#F7F8F6` | Fondo claro y editorial | — |
| Gris medio | `#555B58` | Texto secundario | 6,52:1 sobre fondo |
| Superficie | `#EEF2EF` | Agrupaciones | — |

Se unifica el verde en `#006B5F`: tiene más contraste que `#087A69` (6,03:1 frente a 4,93:1) y ya es el valor documentado. Adoptar la propuesta exige cambiar una línea del tema de la app (`RelevoTeal`) y reemplazar el coral en los casos en que funciona como texto o como único indicador.

### Reglas

- **Un momento coral por pantalla o pieza.** El coral aparece solo cuando hay una señal (activa, en prueba o en el historial de una señal emitida) y en el punto del símbolo. Nunca en errores: el error mantiene su rojo propio (`#BA1A1A`) y un texto.
- **Reposo y aviso se distinguen por forma, no solo por color.** Reposo: punto. Aviso: punto con arcos. En la app, el estado se nombra además con texto («Recordatorio activo», «Aviso emitido»).
- **Tamaños mínimos del símbolo:** 24 dp en monocromo (notificación, solo punto y un arco), 48 dp a color (ícono), 8 mm grabado en el objeto.
- **Fotografía:** objetos de la actividad sobre fondo claro, luz natural y sin personas posando; el objeto Relevo aparece junto a esos objetos, a escala real.
- **Memoria:** fondo claro, texto grafito, verde para navegación y referencias cruzadas; el símbolo se usa solo en diagramas del ciclo, y el coral solo para marcar el momento de la señal en esos diagramas.

## Qué no se puede afirmar

Esta exploración es una decisión de diseño fundamentada, no un resultado con personas. Antes de cerrarla conviene comprobar, con la [pauta Android](../07_validacion/pauta-testeo-prototipo-android-2026-09-23.md) o una prueba breve de reconocimiento:

1. si el símbolo se asocia con «algo que te avisa junto a un lugar» o se confunde con Wi-Fi o transmisión;
2. si el coral se percibe como invitación y no como alarma;
3. si el ícono se reconoce entre otras aplicaciones a tamaño real;
4. si los contrastes calculados se sostienen en el teléfono de prueba con brillo bajo.

## Consecuencias si se aprueba

- Actualizar el [sistema de marca](14_sistema-de-marca-vigente.md) y registrar la decisión como D-067.
- Ajustar el tema de la app (verde único y coral accesible) y el ícono de notificación.
- Aplicar el símbolo en los diagramas del ciclo de la memoria.
- Mantener la luz del objeto en blanco cálido: el color de la marca no define el color de la señal luminosa.

## Registro de cambios (disclaimer)

### 2026-09-25 — Creación

- **Qué se añadió:** una nueva exploración visual con tres direcciones dibujadas, una comparación, una recomendación con paleta y contrastes calculados, y una lámina HTML.
- **Cómo estaba antes:** las direcciones del 11 de septiembre se describieron solo con texto, y el sistema cerrado el 16 de septiembre no recogía el coral ni el ícono que la app incorporó después.
- **Por qué:** el autor pidió rehacer la exploración para definir cómo debe verse Relevo como marca, y la app y la marca habían empezado a divergir.
