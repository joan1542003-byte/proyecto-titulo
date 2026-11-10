# Las decisiones de diseño de Relevo

> **Qué es:** un documento interno que explica cada decisión de diseño de Relevo —el sistema, la señal, el objeto, la marca, la letra, el color, los íconos, la interfaz, la experiencia, la escritura y la memoria diseñada—, por qué se tomó, qué se descartó, en qué se apoya y qué falta. Incluye los errores encontrados y cómo se corrige cada uno.
>
> **Para qué sirve:** para defender las decisiones ante la comisión, que pidió justificarlas porque son «lo más relevante de la memoria» ([tarea 10](../00_gobernanza/por-hacer.md)), y para corregir lo que no calza antes del Pase del 25 de noviembre.
>
> **Qué no es:** no reemplaza [La marca Relevo](42_marca-relevo-2026-10-25.md), que sigue siendo la referencia para usar la identidad, ni el capítulo 11 de la memoria. Los ordena, los verifica y los completa donde no llegaban: la aplicación como experiencia, la usabilidad, el objeto modelado y el diseño editorial.
>
> **Fecha:** 2 de noviembre de 2026. **Base:** la memoria que el autor envió al profesor el 30 de octubre (PDF de 58 páginas), el borrador v6, el código de la aplicación 3.3, los documentos 38 a 42 de esta carpeta y el registro de decisiones.

## Cómo se verificó

Este documento no copia cifras de otros documentos sin comprobarlas. Se verificaron de forma independiente:

- **El color:** la luminosidad perceptual (OKLCH; Ottosson, 2020) y el contraste (World Wide Web Consortium [W3C], 2024) de cada color se calcularon desde sus valores hexadecimales.
- **La letra:** la escala de la aplicación se leyó en su código (`theme/Type.kt`) y se comparó con la escala oficial de iOS (Apple, s. f.) y con la de Material 3 en su código fuente (Android Open Source Project, s. f.).
- **La interfaz:** los colores, radios, áreas táctiles y tiempos de animación se leyeron en el código de la 3.3.
- **La memoria:** las fuentes incrustadas y el texto del PDF enviado se revisaron con herramientas de lectura de PDF.

Cuando algo no se pudo verificar, se dice. Los hallazgos de esa verificación están en la sección 13.

**Sobre la rúbrica:** la Universidad evalúa la propuesta de diseño por su fundamentación, creatividad e innovación, su factibilidad y producción, la aplicación de tecnologías y su marco ético ([criterios oficiales](../01_contexto_y_fuentes/criterios-oficiales-memoria-proyecto-titulo.md)). La matriz de pase pide además coherencia entre concepto y propuesta (4.2) y que el prototipo exprese las decisiones del proyecto (7.3). Los descriptores de cada nivel de la rúbrica no están en el repositorio; este documento se apoya en esos criterios y en los subcriterios de la matriz.

## Cómo leer cada decisión

Cada decisión sigue la misma ficha:

- **Decisión:** qué se hizo.
- **Por qué:** el fundamento, con su fuente.
- **Se descartó:** las alternativas y por qué no.
- **Evidencia:** de dónde sale el respaldo: una fuente externa, un dato del proyecto (entrevistas, encuesta, prueba, registro de decisiones), una verificación propia o una inferencia, dicha como tal.
- **Estado:** si está implementado, probado con personas o pendiente.

---

## 1. En breve: un principio y una restricción

Todo el diseño de Relevo sale de dos ideas.

**El principio: la decisión es de la persona.** Relevo devuelve una intención; no decide qué hacer con ella. La autonomía es una necesidad psicológica básica (Ryan y Deci, 2000), los mensajes que suenan a orden despiertan rechazo (Miller et al., 2007) y, en un estudio con la aplicación one sec, ofrecer la opción explícita de no seguir funcionó mejor que el mensaje de reflexión (Grüning et al., 2023). La memoria lo dice así: «Este principio ordena todas las demás decisiones».

**La restricción: la atención está en la pantalla.** Cuando una actividad absorbe la atención, una intención vuelve con más facilidad ante una señal llamativa y ligada a la acción que por el esfuerzo de recordar (McDaniel y Einstein, 2000). Una notificación llega por el mismo canal que ya tiene la atención ocupada.

| De la restricción salen… | Del principio salen… |
| --- | --- |
| una señal desde fuera de la pantalla, en un objeto | tres respuestas del mismo peso después de la señal |
| sonido y no luz, porque la luz pide mirar | sin rachas, puntos, niveles ni porcentajes |
| el máximo color solo cuando suena | una voz que ofrece y no ordena |
| una señal que dice qué era sin pedir que se lea nada | sin rojo, negro ni gris en los estados de la persona |
| una aplicación que se hace a un lado mientras cuenta | una señal que termina sola |

Esta tabla es la respuesta corta a «¿por qué está diseñado así?». Las secciones que siguen la desarrollan pieza por pieza.

## 2. Cómo se llegó aquí

El diseño no salió de una vez. Entre septiembre y octubre de 2026 pasó por más de veinte propuestas y exploraciones visuales, documentadas en los documentos 16 a 42 de esta carpeta. Mostrar ese camino es parte de lo que pidió la comisión: contar el proceso y no solo el resultado.

| Fecha | Qué se decidió | Qué quedó y qué se dejó |
| --- | --- | --- |
| 16 sep. | Primera marca: nombre, descriptor y frase; señal sonora sin luz (D-070). | Quedan el nombre, el descriptor, la frase y el sonido sin luz. |
| 26–27 sep. | La aplicación adopta las pautas de Apple como referencia: vidrio, formas redondeadas y emoji (D-083); rótulos sin mayúsculas (D-084). | Queda la referencia de Apple y la escritura en frase. |
| 30 sep.–2 oct. | «El subrayado azul» como identidad, y los sistemas 3.0 y 3.1 (D-098, D-099). | Se deja el subrayado: venía de «relevar» como resaltar, se repetía en todas las piezas y no decía qué hace Relevo (documento 33). |
| 2–4 oct. | Exploraciones de color y letra: serif, manuscrita, letras de exhibición (D-100 a D-108). | El autor descarta la serif y la manuscrita. |
| 3 oct. | El color sube con el momento (D-103). | Queda: calma, presencia y señal. |
| 10 oct. | «Relevo con aura»: la luz es de la pantalla, no del objeto (D-121, D-122). | Queda como dirección visual. |
| 11 oct. | 72 íconos propios y la paleta de seis papeles (D-124); el logo de cuatro luces (D-125); los cielos de las actividades (D-126); el lugar como tercera luz (D-127). | Es la identidad vigente. |
| 12 oct. | La aplicación 3.0 a 3.2 aplica la identidad (D-128 a D-131). | Hoy, la 3.3. |
| 24 oct. | Estudio de los textos de la aplicación. | Define la voz. |
| 28 oct. | Modelo 3D del objeto propio (D-143). | Listo para imprimir. |
| 28–29 oct. | La memoria se reescribe en torno a las decisiones de diseño y se diseña en 1920 × 1080 (D-146 a D-152). | Es la memoria vigente. |

**Lo que hay que decir con franqueza:** las personas de la prueba usaron la versión 2.33, con la interfaz de la 2.30 y la marca anterior. La identidad de octubre y la interfaz 3.3 **no se han probado con personas**. Lo que la prueba mostró sobre el uso vale para el recorrido, que es el mismo en las dos versiones, no para la gráfica nueva.

## 3. El sistema y la señal

### 3.1 Un objeto en el lugar donde empieza la actividad

- **Decisión:** Relevo reparte su trabajo entre una aplicación, que prepara y cuenta, y un objeto, que suena junto al primer paso de la actividad: sobre el libro, al lado de la guitarra.
- **Por qué:** la disposición de los objetos simplifica la elección y el recuerdo, como un rollo de película dejado junto a la puerta (Kirsh, 1995). El lugar donde debe hacerse una acción funciona como clave de recuerdo (O'Rear y Radvansky, 2019). Y una señal fuera de la pantalla no compite por el canal que ya tiene ocupada la atención.
- **Se descartó:** bloquear o pausar aplicaciones, que actúan sobre lo que la persona hace y no sobre lo que quería hacer; y una notificación como única señal.
- **Evidencia:** fuente externa para el lugar como clave. Que **sonar** desde el lugar ayude más que una notificación es la hipótesis del proyecto: los estudios sobre lugar evalúan intenciones que vuelven al estar en el sitio, no un sonido que llega desde él. La semana de comparación, que debía cerrar el 30 de octubre, dará la primera evidencia propia.
- **Estado:** implementado y probado en tres hogares.

### 3.2 Sonido, no luz

- **Decisión:** la señal es un sonido. El objeto no se ilumina, y en la gráfica se dibuja con anillos de tinta, nunca con luz (D-070, D-121).
- **Por qué:** una luz pide que la persona mire hacia el objeto, y la persona está mirando la pantalla, a veces desde otra habitación. El sonido se percibe aunque la atención esté en otra parte. Ese mismo rasgo lo vuelve intrusivo (Norman, 1988/1990, p. 103): por eso la señal está diseñada para ser breve y amable.
- **Se descartó:** la luz, porque no alcanza a quien no mira; la vibración, porque el objeto está lejos de la persona.
- **Evidencia:** fuente externa e inferencia de diseño. En las entrevistas, ninguna persona pidió una señal sonora, y seis pidieron señales simples, calmadas o visuales: el sonido es una decisión tomada **contra** una preferencia declarada, y hay que decirlo.
- **Estado:** implementado.

### 3.3 Cómo suena: una firma que termina sola

- **Decisión:** la firma sonora son dos golpes de un timbre de madera que bajan de tono, de 587 a 440 Hz, y se repiten con pausas, más suaves al comienzo (D-071). La señal termina sola a los 30 segundos (D-078).
- **Por qué:** un sonido que desciende y es más grave se percibe menos urgente (Edworthy et al., 1991); menos repeticiones bajan la urgencia (Hellier et al., 1993); un timbre rico en frecuencias ayuda a saber de dónde viene (Middlebrooks y Green, 1991). Terminar solo distingue una invitación de una alarma.
- **Se descartó:** una alarma que insiste hasta que se apaga, y una señal de 3 segundos que no alcanzaría a oírse.
- **Evidencia:** fuentes externas. **Hay una tensión que se declara:** en la encuesta, 41 de 53 personas prefirieron un sonido de 15 segundos o menos. La duración se mantuvo para la prueba y puede acortarse.
- **Estado:** la firma suena en el teléfono y el parlante. **Con el Tag suena su pitido de fábrica**, continuo y de volumen fijo: es el límite más grande del prototipo, y en la prueba una persona lo sintió como una alarma.

### 3.4 El Tag, para probar antes de fabricar

- **Decisión:** el prototipo usa un llavero antipérdida Bluetooth comercial, el Tag.
- **Por qué:** un prototipo puede usar medios simples si conserva lo esencial (Nielsen, 1993, pp. 96–97). Aquí lo esencial era el lugar y el sonido, no la forma.
- **Se descartó:** localizadores de ecosistema cerrado, que no responden a una aplicación propia.
- **Estado:** probado en tres hogares durante dos semanas.

### 3.5 Cuando la señal no llega

- **Decisión:** si se cumple el tiempo y el Tag no responde, la aplicación lo dice, explica por qué pudo fallar y ofrece sonar en el teléfono.
- **Lo que falta:** la comisión pidió que la aplicación **busque el Tag antes de que termine el tiempo** y, si no lo encuentra, suene en el teléfono. Es un cambio de comportamiento, no de aviso: hoy la falla se descubre recién cuando debía sonar.
- **Estado:** decidido; por implementar ([Tabla 4 de la memoria](../08_memoria/borrador-memoria-v6-2026-10-28.md)).

## 4. El objeto

El objeto propio está [modelado](../06_desarrollo_y_factibilidad/testigo-impresion-3d/README.md) y listo para imprimir, pero **no se ha impreso**: las medidas de la placa del Tag son supuestas.

| Decisión | Por qué | Evidencia |
| --- | --- | --- |
| **Una carcasa redonda de 46 × 12,3 mm** que lleva adentro la placa y la pila del Tag. | Conserva el sonido ya probado y suma forma, control y marca. Cumple la especificación de la memoria: planta de 42 a 48 mm, de 12 a 16 mm de alto. | Proyecto |
| **Sin frente.** | Puede dejarse en cualquier posición junto al primer paso. | Proyecto |
| **Más grande que el Tag**, por tres razones. | **Encontrarlo:** un objeto que hay que hallar para callarlo no puede quedar tapado. **Controlarlo:** una persona de la prueba nunca encontró el botón del Tag, y la señal se calló con su botón en 5 ciclos y desde el teléfono en 9. **Fabricarlo:** los detalles necesitan espacio para imprimirse. | Prueba en hogares |
| **El logo es el botón.** | Un botón del tamaño del logo se ve y se siente. Al apretar, el medallón baja 0,45 mm y un tope protege el botón del Tag. | Proyecto; modelo |
| **El sonido sale por el halo** que rodea el logo, una ranura de 0,35 mm, y por ocho agujeros de la tapa. | Que la carcasa no ahogue la señal. | **Pendiente:** medir el volumen con la carcasa puesta y sin ella. |
| **La tapa se abre con una moneda.** | La pila de botón es peligrosa si se traga. | Proyecto |
| **El logo calado, no grabado.** | Grabado en la cara que toca la placa de impresión, el fondo de cada luz quedaría colgando y se imprimiría mal. Calado, cada luz es un agujero limpio y el color va en otra pieza. | Modelo |
| **La versión chica del logo.** | Sus tabiques de 1,37 mm se imprimen con la boquilla de 0,4 mm. | Modelo |
| **Sin soportes:** ninguna cara pasa de 47° desde la vertical, salvo puentes cortos de 1,6 mm o menos. | Las piezas salen limpias, sin marcas que lijar. | Comprobado en el modelo |
| **Solo una pieza depende del Tag**, el chasis. | La carcasa se vuelve un **porta-Tag**: otro Tag cabe cambiando una pieza que se imprime en minutos. Es la idea que pidió desarrollar la comisión. | Modelo |
| **Sin luz.** | La luz de fábrica del Tag queda tapada, como pide D-070. | Modelo |

**Estado:** modelo paramétrico con cinco piezas, tres proyectos de impresión configurados (25, 32 y 6 minutos de máquina) y las instrucciones de armado. **Falta:** medir la placa, imprimir, probar el calce y el sonido, fotografiar y levantar los planos acotados ([tarea 13, bloque A](../00_gobernanza/por-hacer.md)). Es el único subcriterio no logrado de la matriz de pase (5.2).

## 5. La marca

Los detalles y las reglas de uso están en [La marca Relevo](42_marca-relevo-2026-10-25.md). Aquí, el porqué.

### 5.1 Nombre, descriptor y frase

- **Decisión:** «Relevo», acompañado del descriptor «Un recordatorio físico preparado desde el teléfono» donde la marca todavía no se conoce.
- **Por qué:** un relevo es el momento en que algo pasa de una mano a otra; el nombre dice lo que el sistema busca: que la atención pase de la pantalla a lo que la persona quería hacer. Viene del mundo de los turnos, no de las prohibiciones. El descriptor sigue la evidencia de que los logos que comunican qué hace una marca se evalúan mejor, sobre todo en marcas nuevas (Luffarelli et al., 2019).
- **Pendiente:** la frase de marca está por confirmar en la memoria. No se ha buscado en INAPI si hay marcas registradas parecidas.

### 5.2 El logo: cuatro luces que se pasan el turno

- **Decisión:** cuatro círculos, en el sentido del reloj desde arriba, cada uno bajo el siguiente, con el centro abierto. Cada luz es una parte de un relevo: tu tiempo, tu primer paso, el lugar donde empiezas y lo que decides.
- **Por qué:**
  - **El logo dibuja el modelo del proyecto,** no un objeto: la marca explica cómo funciona Relevo (Luffarelli et al., 2019).
  - **La tercera luz es el lugar y no el Tag** (D-127): el Tag es provisional, y que el lugar aporte a la señal es justamente la hipótesis. La marca sigue siendo válida si el objeto cambia.
  - **Círculos:** en cinco experimentos, las formas circulares activaron con más frecuencia atributos de suavidad y cuidado (Jiang et al., 2016). Un sistema que no quiere vigilar necesita eso.
  - **El centro abierto** es el instante del traspaso, de la pantalla a la actividad.
  - **Trazados planos, sin transparencias:** se reproduce igual en pantalla, en papel, en una tinta y calado en el objeto.
- **Se descartó:** el subrayado azul de las propuestas de septiembre: venía de «relevar» como resaltar, se repetía en todas las piezas y no decía qué hace Relevo (documento 33).
- **Estado:** aprobado por el autor (D-125, D-127); no probado con personas.

### 5.3 El logotipo

- **Decisión:** «relevo» en minúsculas, en Chillax Semibold convertida a trazos.
- **Por qué:** se compararon 20 letras sin serifa. Chillax ganó porque su «o» es casi un círculo y conversa con las luces, la «e» y la «r» terminan en curvas abiertas que hacen la palabra amable, y en tamaños chicos no pierde la forma.
- **Se descartó:** las letras de Google Fonts y las dibujadas a mano, por regla del autor; la serif y la manuscrita (D-100 a D-103).

## 6. La letra

### 6.1 Dos letras, cada una con su tarea

| Letra | Dónde | Por qué |
| --- | --- | --- |
| **Chillax Semibold** | Solo el logotipo. | Redonda como las luces y con identidad propia para lucirse en grande. |
| **Instrument Sans** | Todo lo demás: la aplicación, la memoria, los anexos y las láminas. | Grotesca de código abierto, codiseñada por Rodrigo Fuenzalida, diseñador radicado en Santiago, y Jordan Egstad. Se lee bien en pantalla y en papel; sus ejes de peso y ancho resuelven toda la jerarquía con una familia; su dibujo sobrio deja el carácter al logotipo. El trazo de los íconos se midió sobre su asta. |

### 6.2 La escala de la aplicación, y por qué se parece a Apple

La comisión observó que la aplicación tiene una inspiración fuerte de Apple. La respuesta está en los números. La tabla compara la escala de Relevo, leída en su código, con la escala de iOS en el tamaño de texto por defecto (Apple, s. f.) y con la de Material 3, el sistema de Google para Android (Android Open Source Project, s. f.).

| Estilo | iOS, tamaño «Grande» por defecto | Material 3 | **Relevo** |
| --- | --- | --- | --- |
| Título grande | 34 / 41, regular | — | **34 / 38, seminegrita, −3 %** |
| Título | 28 / 34, regular | 28 / 36 (*Headline medium*) | **28 / 32, seminegrita, −2,5 %** |
| Título 2 | 22 / 28, regular | 22 / 28 (*Title large*) | **22 / 27, seminegrita** |
| Encabezado | 17 / 22, seminegrita | 16 / 24 (*Title medium*) | **17 / 22, seminegrita** |
| Texto | 17 / 22, regular | 16 / 24 (*Body large*) | **17 / 26, regular** |
| Llamada | 16 / 21 | — | **16 / 23** |
| Subtítulo | 15 / 20 | 14 / 20 (*Body medium*) | **15 / 21** |
| Nota | 13 / 18 | — | **13 / 18** |
| Leyenda | 12 / 16 | 12 / 16 (*Body small*) | **12 / 16** |

*Nota.* Tamaño / interlineado, en puntos (iOS) o sp (Android). Verificado el 2 de noviembre de 2026.

**Lo que muestra:**

- **Los tamaños son los de iOS, nivel por nivel.** El texto corrido mide 17, como en iOS, y no 16, como en Material.
- **El interlineado del texto no es el de Apple.** iOS usa 17/22, una proporción de 1,29; Material usa 1,50; Relevo usa 17/26, **1,53**. Relevo toma los tamaños de iOS y el aire de lectura de Material.
- **Los títulos son propios:** en seminegrita y con interletrado cerrado, donde iOS los deja en regular.

**La respuesta a «¿por qué se parece a Apple?», en tres partes:**

1. **Es una decisión del autor, tomada el 27 de septiembre de 2026** frente a una versión plana de la aplicación: buscaba una interfaz hermosa y fácil, sin sobrediseñar ni sobreexplicar (D-083).
2. **Lo que se tomó de Apple son principios, no una apariencia:** jerarquía hecha con orden y agrupación, armonía por concentricidad y consistencia de componentes (Apple, 2025a); y una escala tipográfica probada.
3. **Relevo no es una aplicación de iOS:** lo que pertenece a Android —los permisos, las notificaciones, el gesto atrás— se ve como en Android, para que la persona lo reconozca; el interlineado de lectura se acerca al de Material; y las áreas táctiles deben seguir los 48 dp de Android (sección 9.6).

**¿Por qué no Material Design completo?** Porque su escala es de texto más chico (16 y no 17) y sus títulos van en regular, y el autor buscaba una interfaz hermosa y fácil, sin sobrediseñar ni sobreexplicar, en una aplicación que se abre pocas veces al día. El borrador v6 nombraba «Material Design completo» como alternativa descartada en la Tabla 1; la versión enviada el 30 de octubre lo quitó, y conviene reponerlo: responde de antemano una pregunta segura.

### 6.3 Reglas de la letra

- **Sin mayúsculas sostenidas ni letras espaciadas:** los rótulos se escriben como una frase (D-084). Se leen como lo que son, frases, y no como carteles.
- **Sin serif ni manuscrita** en ninguna pieza (D-100 a D-103).
- **«Letra grande» suma un 15 %** al tamaño que la persona ya usa en Android y nunca lo reemplaza: respeta el ajuste del sistema en vez de pisarlo.

## 7. El color

### 7.1 El principio: función, no emoción

**Decisión:** el color de Relevo se decide por la función que cumple en la interfaz. Distingue de forma estable las partes de un relevo, las actividades de cada persona y los momentos del ciclo.

**Por qué no por emoción.** La investigación sobre psicología del color está en una etapa inicial y sus efectos dependen del contexto (Elliot y Maier, 2014). Y hay una razón más, que es la que señaló la comisión: **las asociaciones entre color y emoción son tendencias de la mayoría, no acuerdos.**

> La corrección de los profesores, en los apuntes del autor: «La decisión cromática no se apoya en promedios», porque una cifra agregada esconde cómo se reparten las respuestas ([tarea 10](../00_gobernanza/por-hacer.md)).

El ejemplo está en el propio fundamento del color. El [documento 41](41_fundamento-del-color-texto-academico-2026-10-11.md) justifica el rosa porque, según Jonauskaite et al. (2024), el 53,2 % de los participantes lo asocia con el amor. Eso también dice que **casi la mitad no lo hace**. Una mayoría tan estrecha no puede fundar un color: si el rosa significa amor para unos y no para otros, el diseño no puede contar con ese significado.

**Cómo queda el fundamento, entonces:**

1. **Las razones de cada color son funcionales:** un color para cada papel, la misma luminosidad para todos, el contraste medido, la convención de la señalética donde coincide y nunca solo color.
2. **La emoción se usa solo para descartar.** Negro, gris y rojo se dejan fuera de los estados de la persona porque son los colores más asociados con el miedo y la tristeza entre países (Jonauskaite et al., 2024). Aquí el uso es prudente por una asimetría: elegir un color por una asociación positiva que media muestra no comparte es apostar; evitar uno por una asociación negativa fuerte es solo precaución.
3. **Ninguna cifra agregada se presenta como si fuera un consenso.** Cuando se cite una, se dice qué parte de la muestra **no** hace la asociación.

La memoria v6 ya escribe el color así: «Las asociaciones entre colores y emociones cambian según el contexto y la persona, así que no fundan la elección». **Lo que falta** es corregir el documento 42 y el Anexo H, que todavía justifican cada color por una emoción (sección 13).

### 7.2 La base

| Nombre | Color | Uso | Contraste verificado |
| --- | --- | --- | --- |
| Papel | `#F7F4F0` | Fondo general: tibio, no blanco de hospital. | — |
| Tarjeta | `#FFFFFF` | Contenido agrupado, más claro que el papel. | — |
| Tinta | `#141312` | Texto, acciones, la selección y lo que escribe la persona. | **16,9:1** sobre papel |
| Grafito | `#6B655F` | Texto secundario. | **5,2:1** sobre papel; 5,8:1 sobre tarjeta |
| Error | `#B3261E` | Solo errores, siempre con ícono y texto. | **6,0:1** sobre papel |
| Gris | `#A9A197` | Solo lo deshabilitado; nunca texto. | 2,3:1 (exento: WCAG no exige contraste a lo deshabilitado) |
| Piedra | `#EEE9E3` | Controles secundarios. | 1,1:1 sobre papel: el control se reconoce por su texto, no por su borde |

**Por qué casi negro y papel tibio:** la tinta casi negra sobre papel tibio da el contraste más alto del sistema (16,9:1) sin el brillo del blanco puro. El tema oscuro **Noche** conserva los mismos papeles: tinta sobre papel 16,1:1; grafito 7,5:1.

### 7.3 Los seis papeles

**Decisión:** seis fichas claras, una por papel. La tabla da la luminosidad perceptual (L) y la saturación (C) en OKLCH, y el contraste de la tinta encima, todo calculado para este documento.

| Papel | Ficha | Color | L | C | Tinta encima | Por qué ese color |
| --- | --- | --- | ---: | ---: | ---: | --- |
| Tu tiempo | Mantequilla | `#F4E496` | 0,914 | 0,099 | 14,5:1 | Amarillo: en la señalética pide atención sin prohibir (International Organization for Standardization [ISO], 2011). |
| Tu primer paso | Cielo | `#B3E5FC` | 0,895 | 0,060 | 13,7:1 | Azul: en la señalética indica una acción (ISO, 2011). |
| El lugar donde empiezas | Lima | `#C6EEAE` | 0,905 | 0,094 | 14,4:1 | Verde: en la señalética indica dónde está algo, como una salida (ISO, 2011). |
| Lo que decides | Rubor | `#FAC8D9` | 0,881 | 0,061 | 12,7:1 | Distinto de los otros cinco a igual luminosidad y lejos del rojo, que en Relevo es solo para errores: la decisión de la persona nunca se lee como una falla. |
| Tu aura | Lila | `#DFD1FC` | 0,886 | 0,060 | 13,0:1 | El único papel que no comunica una función del ciclo: es la personalización. |
| Después de la señal | Durazno | `#FBD1B3` | 0,889 | 0,062 | 13,1:1 | Distinto de los otros cinco y lejos del rojo. |

**Por qué la misma luminosidad:** las seis fichas van de 0,881 a 0,914, una diferencia de 0,03. Por eso pesan lo mismo a la vista y **ningún momento se impone a otro**: el color distingue sin jerarquizar. Es la traducción visual del principio: «Tu tiempo» no vale más que «Lo que decides». Albers (2013) mostró que un color cambia de apariencia según los que tiene al lado; igualar la luminosidad en un espacio perceptual, y no en los valores RGB, es la forma de que el peso se mantenga cuando las fichas aparecen juntas.

**Por qué claras y poco saturadas:** la saturación y el brillo elevan la activación (Wilms y Oberfeld, 2018), y lo que acompaña no debería activar de más. Es el ideal de la tecnología calma: informar desde la periferia de la atención (Weiser y Brown, 1997).

**Un color, un papel:** cada color significa siempre lo mismo, y **la selección va en tinta, no en color** (D-122). Si la selección usara el amarillo, el amarillo significaría dos cosas.

### 7.4 Dos capas que no hay que confundir: el logo y las fichas

El sistema tiene **dos juegos de color de la misma familia**: las luces del logo, más saturadas, y las fichas de la interfaz, más claras. Solo las fichas tienen el mismo peso.

| Luz del logo | Color | L | C |
| --- | --- | ---: | ---: |
| Amarillo | `#FFD54A` | 0,886 | 0,157 |
| Celeste | `#9DD6F4` | 0,847 | 0,072 |
| Lima | `#B3E788` | 0,870 | 0,135 |
| Rosa | `#F6A3CB` | 0,808 | 0,110 |

Las luces del logo van de 0,808 a 0,886 de luminosidad, y la saturación del amarillo duplica la del celeste. Está bien que así sea: el logo es una figura, no una escala de estados. **El problema está en la memoria:** su Figura 16 muestra los colores **del logo** con el nombre de las preguntas («¿Cuándo suena? `#FFD54A`»), y el texto de al lado dice que son «seis tonos pastel con el mismo peso visual». Quien revise los valores encontrará que la figura no sostiene lo que dice el texto (sección 13).

### 7.5 Los cielos de las actividades

- **Decisión:** lo que la persona quiere hacer no es un papel de Relevo, y por eso tiene otro material: un cielo, un degradado con grano y volumen, distinto de las fichas planas (D-126). Siete familias: moverte, leer y aprender, crear, jugar, en casa, descansar y con otras personas.
- **Por qué:** así el color de una actividad nunca se confunde con el de una función. Cada persona puede cambiar el color de una actividad.
- **El nombre va en una cápsula blanca.** Verificado: el texto blanco directo sobre los cielos claros da entre **1,35:1 y 2,47:1**, lejos del 4,5:1 que piden las WCAG para el texto (W3C, 2024). En la cápsula, la tinta sobre blanco supera los 15:1.
- **El cielo aparece solo donde está la actividad:** su tarjeta, el encabezado al preparar y la pantalla completa cuando suena.

### 7.6 El color sube con el momento

- **Decisión:** calma al abrir, presencia mientras cuenta y el máximo color cuando suena (D-103).
- **Por qué:** el color es la herramienta de jerarquía más fuerte de la interfaz, y se guarda para el único momento que debe pasar al primer plano: la señal. El resto del tiempo, Relevo informa desde la periferia (Weiser y Brown, 1997).
- **Cómo se ve:** al abrir, papel y tinta; mientras cuenta, el aura en movimiento lento; cuando suena, el cielo de la actividad en toda la pantalla.

### 7.7 Nunca solo color

- **Decisión:** cada dato va también con ícono y palabra (W3C, 2024, criterio 1.4.1).
- **Por qué:** la simulación de la visión con daltonismo (Machado et al., 2009) muestra dos pares que se confunden: el celeste y el lila con deuteranopia, y el rosa y el durazno con tritanopia. El color ayuda; el ícono y la palabra informan.

## 8. Los íconos

- **Decisión:** 72 íconos propios en una retícula de 24 con un trazo de 1,6, siempre con su palabra (D-124).
- **Por qué:** el trazo de 1,6 es el grosor del asta de Instrument Sans junto a un texto de 15 px, para que el ícono y su palabra pesen lo mismo. Lo propio de Relevo se dibuja con sus ideas: el sonido como anillos, nunca como luz; el primer paso como un punto en el primer peldaño; el tiempo como un cronómetro. Lo común usa formas conocidas.
- **Fuentes:** detalladas en [La marca Relevo](42_marca-relevo-2026-10-25.md), sección 7.

## 9. La interfaz

### 9.1 Tres destinos, nombrados con sustantivos

- **Decisión:** una barra inferior con Inicio, Ruta y Perfil. Los destinos se nombran con sustantivos y las acciones con verbos: «Preparar un relevo», «Activar el relevo».
- **Por qué:** la persona distingue dónde está de lo que puede hacer. Tres destinos son pocos a propósito: elegir entre pocas opciones toma menos tiempo (Yablonski, s. f., ley de Hick).
- **Se descartó:** un tablero con todo a la vista, que convertiría a Relevo en algo que hay que revisar.

### 9.2 Inicio muestra solo lo más próximo

- **Decisión:** una tarjeta principal que es una de cuatro: el relevo que cuenta, el regreso después de unos días, el siguiente paso de la ruta o la invitación a preparar uno.
- **Por qué:** la aplicación acompaña sin pedir atención. Se abre pocas veces al día y su trabajo es devolver la atención a otra actividad.
- **Un detalle que es diseño:** el regreso dice «Hola de nuevo» y «¿Sigue siendo lo que quieres?», **sin decir cuántos días pasaron**. Contar los días convertiría el regreso en una falta.

### 9.3 Formas redondas y concéntricas

- **Decisión:** botones y controles en cápsula; tarjetas, fichas y hojas con esquinas redondeadas que comparten centro con las del teléfono.
- **Por qué:** coherencia con las formas circulares de la marca y con el principio de armonía por concentricidad (Apple, 2025a).
- **Verificado:** el código usa **ocho radios distintos** (20, 21, 22, 24, 28 dp y otros menores), y el más frecuente es 20 dp; el documento 42 describe tres. **Propuesta:** reducirlos a una escala corta y nombrada, para que la consistencia que la memoria afirma se cumpla también en el código.

### 9.4 El vidrio, solo en la navegación

- **Decisión:** las barras, los botones flotantes, las pestañas y las hojas llevan un desenfoque sutil, sin brillos; el contenido nunca lleva vidrio.
- **Por qué:** las pautas de Apple ponen el vidrio en una capa de navegación separada del contenido (Apple, 2025b). En Android se implementa con un desenfoque propio, que no equivale al material de iOS.
- **Se descartó:** el vidrio en el contenido, que baja el contraste del texto.

### 9.5 El aura: la luz es de la pantalla

- **Decisión:** cinco luces que se mueven despacio sobre el papel, con grano. Está a pantalla completa en la bienvenida y mientras un relevo cuenta. La persona elige su intensidad o la apaga (D-121, D-122).
- **Por qué:** la luz vive en la pantalla y no en el objeto, que solo suena. El aura da presencia al relevo que cuenta sin un contador que apure.
- **Accesibilidad:** queda quieta si Android pide quitar las animaciones.

### 9.6 Áreas táctiles: un error que hay que corregir

- **Lo que debería ser:** Android pide que todo elemento que se toca reserve al menos **48 dp** en cada dirección (Android Developers, s. f.).
- **Lo que hay, verificado en el código:**
  - el botón de ícono de `Screen.kt` está bien: dibuja un círculo de 40 dp dentro de un área táctil de 48;
  - **las opciones de un toque** de `Controls.kt` —«Abrir el libro», «En el velador»— tienen una altura mínima de **40 dp**;
  - los botones redondos y el selector de minutos de `Controls.kt` miden **44 dp**.

  Son las piezas que más se tocan al preparar un relevo.
- **El documento 42 también lo dice mal:** afirma que las áreas táctiles miden al menos 44 dp, que es la cifra de Apple, no la de Android.
- **Solución:** aplicar el modificador `minimumInteractiveComponentSize` a esas tres piezas. Reserva los 48 dp **sin cambiar el tamaño dibujado** (Android Developers, s. f.): el aspecto no cambia y se toca mejor. Es una línea por componente.

### 9.7 Movimiento

- **Decisión:** transiciones breves y sin rebotes; nada se gira ni se inclina: se mueve la luz, no las tarjetas (D-121).
- **Verificado:** las transiciones del código duran entre 170 y 260 ms; las más largas son ciclos que se repiten: el anillo del aura (2,4 s) y el dibujo animado de la guía del Tag (0,9 y 1,4 s). El documento 42 dice «200 a 250 ms»: es una simplificación aceptable.
- **Por qué:** una interfaz que responde sin hacer esperar se siente fluida (Yablonski, s. f., umbral de Doherty), y la calma pide evitar el rebote.

### 9.8 Lo personal

- **Perfil con emoji y no con foto:** personal sin pedir una foto (D-083).
- **Tema claro y tema Noche;** «Letra grande»; movimiento reducido.
- **Pendiente:** comprobar el lector de pantalla TalkBack y la letra grande en un teléfono real.

## 10. La experiencia: el recorrido

### 10.1 Cuatro momentos, cada uno diseñado para pedir lo mínimo

| Momento | Decisión | Por qué |
| --- | --- | --- |
| **Preparar** | Seis pasos, **una pregunta por pantalla**: «¿Qué quieres hacer?», «¿Cómo empiezas?», «¿Dónde empiezas?», «¿Cuándo suena?», «¿Dónde suena?» y «Todo listo». Respuestas de un toque; escribir sigue disponible. | Elegir cuesta menos que escribir, y cada esfuerzo de más hace menos probable que un recordatorio se prepare (Chiu y Gilbert, 2024). En la encuesta, el esfuerzo de prepararlo fue uno de los motivos más citados para no probar la propuesta. |
| | «Seguir» siempre en el mismo lugar, al alcance del pulgar. | Un objetivo grande y cercano se alcanza antes (Yablonski, s. f., ley de Fitts). |
| | Si falta algo, una frase dice qué escribir o elegir. | El error indica qué hacer, no solo qué está mal. |
| | **Probar el sonido antes de activar,** y confirmar que se oyó. | La persona sabe desde el primer día que la señal la va a alcanzar. Se agregó al incorporar el Tag: que reciba la orden no asegura que haya sonado (Tabla 2 de la memoria). |
| | El resumen final se puede tocar para cambiar cualquier dato. | Revisar antes de activar evita errores sin agregar un paso de confirmación. |
| **Seguir en el teléfono** | La aplicación se hace a un lado: una sola tarjeta en Inicio. El tiempo es el que suman las apps elegidas, de 1 minuto a 6 horas. | Una regla fácil de entender y de ajustar (criterio 3): la persona pone la condición, no el sistema. |
| | **Editar un relevo activo** sin borrarlo. | Lo pidió una persona de la prueba. |
| **Oír la señal** | El cielo de la actividad en toda la pantalla, lo que suena y una frase con la actividad, cómo empezar y dónde. «Silenciar y continuar». | El momento de más color: la actividad pasa al primer plano. |
| **Decidir** | Una pregunta, «¿Qué decidiste?», con tres respuestas del **mismo tamaño, color y lugar**, ninguna marcada de antemano. | Las tres valen lo mismo. Seguir en el teléfono no siempre es un error; a veces es el descanso que la persona eligió. |
| | Cuatro preguntas de un toque antes, que siempre se pueden saltar. | Completan el registro automático, que muestra qué pasó pero no por qué (Nielsen, 1993, p. 221). |

### 10.2 Lo que no se hace

- **Sin rachas, puntos ni niveles:** una racha puede volverse una meta en sí misma y desanimar cuando se rompe (Silverman y Barasch, 2023).
- **Sin porcentajes en la ruta:** los pasos van en escalera y la ruta no avanza sola ni mide (D-074).
- **Sin culpa ni urgencia:** el regreso no cuenta días; la señal no ordena dejar el teléfono.
- **Confirmaciones que dicen la consecuencia antes de actuar:** «¿Desactivar el relevo?» explica que deja de contar y que no sonará; la opción segura dice su resultado, «Mantenerlo».

### 10.3 La primera vez: el problema que hay que resolver

- **Lo que hay:** once pantallas antes del primer relevo: bienvenida, cómo funciona, consentimiento, permisos, perfil y el primer relevo.
- **Lo que mostró la prueba:** las tres personas las completaron, pero el recorrido les resultó largo. La comisión pidió partirlo.
- **Solución:**
  1. **Antes de empezar, solo lo indispensable:** la bienvenida, el consentimiento y el permiso de tiempo de uso, sin el cual Relevo no puede contar.
  2. **Preparar el primer relevo enseguida,** que ya enseña cómo funciona Relevo haciéndolo.
  3. **El resto, después y en su momento:** el perfil (nombre, emoji e intereses) después del primer relevo —el nombre sigue siendo obligatorio (D-089); solo cambia el momento—; los permisos de notificaciones y batería, en el momento en que hacen falta; el video, en Perfil › «Cómo funciona Relevo».
- **Estado:** por implementar.

## 11. La escritura: la voz de Relevo

### 11.1 La voz

- **Decisión:** una voz con cuatro rasgos: cercana y tranquila, clara y concreta, respetuosa de la decisión y honesta. El tono cambia según el momento: acogedor la primera vez, práctico al preparar, mínimo mientras cuenta, neutro cuando suena, sobrio en la privacidad.
- **Por qué:** el [estudio de los textos](../06_desarrollo_y_factibilidad/app-android/textos/estudio-escritura-de-interfaces-2026-10-24.md) reunió las guías de escritura de Apple, Google, Microsoft y GOV.UK y la investigación sobre tono y autonomía. Relevo sigue la regla del equipo de escritura de Apple —tan largo como haga falta y tan corto como se pueda (Apple, 2024)— y evita el lenguaje de la obligación, que despierta rechazo (Miller et al., 2007). Un texto amable no reemplaza la posibilidad real de elegir (Smit et al., 2019): por eso las opciones se nombran con el mismo peso.
- **El vocabulario también es decisión:** «actividad» y «sonar», nunca «meta», «tarea» ni «alarma», que convertirían la intención en un deber.

### 11.2 Los problemas encontrados y su solución

El estudio revisó los 1287 textos de la versión 3.3 y encontró catorce problemas. Los de prioridad alta y media:

| Problema | Ejemplo | Solución |
| --- | --- | --- |
| **R1. La forma de empezar tiene cuatro nombres.** | «Para empezar», «¿Cómo empiezas?», «Tu primer paso», «Empieza por…». | «Para empezar» como rótulo y «¿Cómo empiezas?» como pregunta; «primer paso» solo en la memoria. |
| **R2. La señal tiene cinco nombres.** | «el aviso», «la señal», «el sonido», «lo que suena», «la notificación». | «suena» como verbo y «el sonido» como sustantivo. |
| **R5. Etiquetas que no calzan con su destino.** | La fila «Privacidad y datos» abre una pantalla titulada «Tus datos». | Que la fila y el título digan lo mismo. |
| **R6. Nombres distintos a los de Android.** | Relevo dice «Tiempo de uso»; Android, «Acceso a datos de uso». | Decir el nombre de Android al enviar a los ajustes. |
| **R3. «Contar» significa dos cosas.** | Relevo cuenta minutos y pide que la persona «cuente» qué hizo. | «Contar» solo para el tiempo; para narrar, «decir». |
| **R4. El objeto y la ruta tienen varios nombres.** | «Ruta», «Paso a paso», «Tus pasos». | Un solo nombre en pestaña, título y Perfil. |
| **R11. Notificaciones largas.** | Lo útil queda al final y se corta. | Lo importante al principio y en menos de 40 caracteres. |
| **R12. Textos largos.** | Párrafos de 120 palabras en el consentimiento. | Listas, pasos numerados y botones más cortos. |

Los otros seis (puntos en los títulos, dos palabras para la misma acción, cifras y palabras mezcladas, tres voces, frases abstractas y restos técnicos) están en el estudio. **Los textos del consentimiento y las preguntas del protocolo no se cambian durante la prueba;** se revisan al terminarla.

### 11.3 «Elige tu emoji»

- **El problema:** describe lo que la persona ve en vez de preguntar por ella. Que va a elegir un emoji ya se ve.
- **Solución:** «¿Con qué te identificas?», como pidió la comisión. Sigue la regla de la voz: preguntar en vez de rotular, como «¿Cómo empiezas?».

## 12. Usabilidad: lo que se vio y cómo se resuelve

### 12.1 Lo que mostró la prueba

La prueba en tres hogares es evidencia por caso: con tres personas, cada comentario pesa, pero ninguno se generaliza. La prueba usó la interfaz de la 2.30. Conviene separar los problemas técnicos, la mayoría del objeto comprado, de los de uso.

| Hallazgo | Tipo | Solución | Estado |
| --- | --- | --- | --- |
| El Tag siguió sonando tras la prueba de sonido y, más tarde, sin parar. | Técnico, del Tag | Callar con confirmación. | Hecho durante la prueba |
| Tras horas sin uso, el Tag sonaba lento. | Técnico, del Tag | Esperar más a un Tag que responde lento. | Hecho durante la prueba |
| El Tag no sonó en un relevo. | Técnico | Buscar el Tag antes de que termine el tiempo y, si no responde, sonar en el teléfono. | Decidido; por implementar |
| Corregir un relevo exigía borrarlo. | Uso | Editar un relevo activo. | Hecho durante la prueba |
| El botón del Tag no se encuentra: la señal se calló con él en 5 ciclos y desde el teléfono en 9. | Uso, del Tag | El logo de Relevo como botón. | Diseñado; por imprimir |
| El pitido sonó como una alarma. | Uso, del Tag | Volumen regulable; la firma propia, cuando el objeto tenga electrónica propia. | Pendiente |
| La primera vez es larga: once pantallas. | Uso | Partirla (sección 10.3). | Por implementar |
| La pantalla del relevo activo muestra demasiado. | Uso | Dejar solo la actividad, el tiempo que falta y una acción. | Por implementar |
| Un límite de 45 minutos resultó largo: al sonar, la persona ya estaba inmersa. | Uso | Proponer un límite breve al empezar y sugerir revisarlo tras las primeras señales. | Propuesta |
| De noche, la señal se oye desde la cama y no lleva a levantarse. | Uso | Permitir excluir horas del día. | Propuesta |
| «La dejé para después» en 9 de 21 respuestas. | Uso | Ofrecer desde esa respuesta preparar el relevo para otro momento, sin repetir la señal. | Propuesta |
| Sin el objeto, no hay cómo empezar. | Uso | «¿Tienes un Tag? No: consíguelo acá». | Por implementar |

**Una lectura de fondo:** en 10 de 21 respuestas la persona empezó la actividad. Recordar no obliga a empezar: una señal lleva a actuar solo si coincide con la motivación y la capacidad del momento (Fogg, 2009). Relevo actúa sobre la facilidad —deja la señal junto a un primer paso concreto— y no sobre la motivación, porque esa decisión es de la persona.

### 12.2 Lo que mostró la revisión del código

| Hallazgo | Solución |
| --- | --- |
| Opciones de un toque de 40 dp y botones de 44 dp, bajo los 48 dp de Android. | `minimumInteractiveComponentSize` (sección 9.6). |
| Ocho radios de esquina distintos. | Una escala corta y nombrada (sección 9.3). |
| Controles secundarios en piedra sobre papel, con 1,1:1 de contraste de borde. | Aceptable mientras cada uno tenga texto; si alguno queda solo con ícono, darle un borde de 3:1 (W3C, 2024, criterio 1.4.11). |

## 13. Incoherencias entre documentos, verificadas

Cada fila se comprobó en el código, en el PDF o con un cálculo.

| Dónde | Qué dice | Lo verificado | Corrección |
| --- | --- | --- | --- |
| Memoria, Figura 16 | Los colores del logo con el nombre de las preguntas, junto al texto «mismo peso visual». | Las luces del logo van de 0,808 a 0,886 de luminosidad; las fichas, de 0,881 a 0,914. | Mostrar en la figura las fichas de la interfaz, o rotular aparte los colores del logo. |
| Documento 42 (sección 4) y Anexo H (Tabla H1) | Justifican cada color por una emoción, con cifras agregadas. | Contradice a la memoria v6 y es justo lo que señaló la comisión. | Reescribir con las razones funcionales de la sección 7.3. |
| Documento 42 (sección 8) | Áreas táctiles de al menos 44 dp. | El código usa 40, 44 y 48; Android pide 48. | Corregir el código y el documento a 48 dp. |
| Documento 42 y código (`Color.kt`) | Grafito sobre papel, 5,3:1. | 5,24:1. | Escribir 5,2:1. |
| Documento 41 | Texto blanco sobre los cielos claros, entre 2,6:1 y 3,7:1. | Sobre los colores base, entre 1,35:1 y 2,47:1; el valor cambia en el degradado. | Dar el rango de los colores base. La conclusión no cambia: la cápsula es necesaria. |
| Documento 42 (sección 12) | La memoria en A3 horizontal. | Desde D-146 es de 1920 × 1080. | Actualizar. |
| Memoria, Tabla 1 (PDF del 30 de octubre) | Arquitectura: «Un inicio claro, un momento de ocio digital y una decisión». | El texto y la Figura 14 dicen Inicio, Ruta y Perfil. | Volver a «Tres destinos; Inicio muestra solo lo más próximo». |
| Memoria, pág. 36 (PDF del 30 de octubre) | Las esquinas «comparten ergonomía» con las del teléfono. | La concentricidad es compartir **centro**. | «comparten centro». |

## 14. El diseño editorial de la memoria

### 14.1 Las decisiones

| Decisión | Por qué |
| --- | --- |
| **1920 × 1080 puntos**, tres columnas (D-146). | Lo pidió la comisión, y reemplaza el A3 horizontal. |
| **Instrument Sans de 23 pt con interlineado de 34,6** (1,5 veces la letra), unas 8 palabras por línea. | La comisión pidió subir la letra y el interlineado. |
| **Las aperturas** con el número en regular y el título más grande, sobre un panel de aura. | Manda el título; la apertura repite la identidad de la aplicación. |
| **Rótulos como en APA:** «Figura 1» en negrita y el título en cursiva, debajo; «*Nota.*» al pie. | Formato de tesis (D-148). |
| **Tablas en fichas blancas**, una fila por ficha (D-150). | Se leen como piezas de la marca sin perder el orden de una tabla. |
| **Ningún párrafo partido en un trozo de menos de tres líneas**, y ningún capítulo que termine en una columna sola (D-149, D-152). | Lo pidió la comisión: sin páginas de un solo párrafo ni columnas solas. |
| **Las figuras al pie de la página siguiente a su mención;** el texto nunca sigue debajo de una figura (D-151). | La lectura va hacia el lado, como en una página doble. |
| **Los miles con un espacio que no se corta.** | «1 577 000» nunca se parte entre dos líneas. |

### 14.2 Los errores del PDF enviado el 30 de octubre

El detalle y los arreglos están en la [tarea 12](../00_gobernanza/por-hacer.md). Los que son de diseño gráfico:

- **Trece marcas de edición a la vista:** resaltados, un párrafo tachado en el Resumen y notas como «\*ORDENAR FIGURAS» y «EN DESARROLLO» en los títulos de figura. Se quitan en el texto y se regenera.
- **La Tabla 3 se imprime invisible.** Su contenido está en el PDF, pero no se ve: es un problema de color o de capas en el generador.
- **Las etiquetas de la Figura 9 están cortadas** en el propio archivo: «Relev», «Focusau», «MindPhon». El generador trunca el campo.
- **La Figura 23 no tiene título.**
- **Cinco títulos de figura no calzan con el índice.**
- **Se perdió la cursiva.** Verificado: el PDF que genera el repositorio incrusta la itálica regular de Instrument Sans; el enviado, que pasó por Affinity y después por iLovePDF, solo trae la itálica seminegrita de la portada. Por eso los títulos de figuras y tablas, las «*Nota.*» y los términos extranjeros como *phygital* salieron en redonda, y APA 7 los pide en cursiva. **Solución:** instalar en el computador `08_memoria/memoria-1920x1080/letra/estaticas/InstrumentSans-Italic.ttf` antes de abrir el IDML, exportar de nuevo y comprobar que la fuente `InstrumentSans-Italic` aparezca entre las incrustadas.

## 15. Cómo defender cada decisión

Respuestas cortas, cada una con su evidencia, para las preguntas que la comisión puede hacer.

**¿Por qué se parece a Apple?**
Porque toma de las pautas de Apple sus principios —jerarquía, armonía y consistencia— y su escala de tamaños, que es la de iOS nivel por nivel. No es una copia: el interlineado de lectura es más amplio que el de Apple, los títulos son propios y lo que es de Android se ve como en Android. Es una decisión mía, tomada el 27 de septiembre, frente a una versión plana que no lograba ser clara.

**¿Por qué no Material Design, si es Android?**
Porque Material usa texto más chico y títulos en regular, y yo buscaba una interfaz hermosa y fácil, sin sobrediseñar, en una aplicación que se abre pocas veces al día. De Material conservé lo que importa en Android: los controles del sistema y el área táctil de 48 dp.

**¿Por qué esos colores?**
Por su función, no por una emoción. Las asociaciones de color son tendencias de la mayoría —el rosa con el amor, por ejemplo, la hace algo más de la mitad—, y una mayoría así no puede fundar un diseño. Cada color tiene un papel fijo, los seis pesan lo mismo a la vista y el texto encima supera 12:1. La emoción solo la usé para descartar: no hay rojo, negro ni gris en los estados de la persona.

**¿Por qué sonido y no luz?**
Porque la persona está mirando la pantalla, a veces desde otra habitación, y una luz pide que mire. Sé que en las entrevistas nadie pidió sonido; por eso la señal es breve, desciende de tono y termina sola.

**¿Por qué un objeto, si el Tag funcionó?**
Porque el Tag no se encuentra ni se controla: una persona nunca encontró su botón, y la señal se calló más veces desde el teléfono que desde el objeto. La carcasa resuelve eso con un botón del tamaño del logo, y como solo una pieza depende de la placa, sirve para otros Tag.

**¿Por qué las tres respuestas son iguales?**
Porque las tres valen lo mismo. Seguir en el teléfono a veces es justo el descanso que la persona eligió, y si Relevo premiara empezar, decidiría por ella.

**¿Probaste la marca con personas?**
No. La prueba usó la versión anterior de la interfaz. Lo que probé es el recorrido, que es el mismo; la gráfica nueva queda para la siguiente ronda.

## 16. Lo que falta

Dicho una vez:

- **Probar con personas** la identidad de octubre y la interfaz 3.3.
- **Imprimir el objeto,** medir su sonido con la carcasa puesta y levantar los planos.
- **Implementar** la búsqueda del Tag antes de que termine el tiempo, la primera vez partida, la pantalla del relevo simplificada, «¿Con qué te identificas?» y las áreas táctiles de 48 dp.
- **Corregir** la Figura 16, el documento 42 y el Anexo H.
- **Comprobar** TalkBack y la letra grande en un teléfono real.
- **Buscar** en INAPI marcas parecidas a «Relevo» y confirmar la frase de marca.
- **Evidencia de Chile:** no hay un estudio de color hecho solo con población chilena.

## Referencias

Albers, J. (2013). *Interaction of color* (4.ª ed.). Yale University Press.

Android Developers. (s. f.). *API defaults*. Jetpack Compose. Recuperado el 2 de noviembre de 2026, de https://developer.android.com/develop/ui/compose/accessibility/api-defaults

Android Open Source Project. (s. f.). *TypeScaleTokens.kt* [Código fuente]. AndroidX, Compose Material 3. Recuperado el 2 de noviembre de 2026, de https://github.com/androidx/androidx/blob/androidx-main/compose/material3/material3/src/commonMain/kotlin/androidx/compose/material3/tokens/TypeScaleTokens.kt

Apple. (s. f.). *Typography*. Human Interface Guidelines. Recuperado el 2 de noviembre de 2026, de https://developer.apple.com/design/human-interface-guidelines/typography

Apple. (2024, 8 de febrero). *Q&A with the Apple UX writing team*. Apple Developer. https://developer.apple.com/news/?id=5mcfho5g

Apple. (2025a). *Get to know the new design system* [Video]. WWDC25. https://developer.apple.com/videos/play/wwdc2025/356/

Apple. (2025b). *Meet Liquid Glass* [Video]. WWDC25. https://developer.apple.com/videos/play/wwdc2025/219/

Chiu, G. y Gilbert, S. J. (2024). Influence of the physical effort of reminder-setting on strategic offloading of delayed intentions. *Quarterly Journal of Experimental Psychology, 77*(6), 1295–1311. https://doi.org/10.1177/17470218231199977

Edworthy, J., Loxley, S. y Dennis, I. (1991). Improving auditory warning design: Relationship between warning sound parameters and perceived urgency. *Human Factors, 33*(2), 205–231. https://doi.org/10.1177/001872089103300206

Elliot, A. J. y Maier, M. A. (2014). Color psychology: Effects of perceiving color on psychological functioning in humans. *Annual Review of Psychology, 65*, 95–120. https://doi.org/10.1146/annurev-psych-010213-115035

Fogg, B. J. (2009). A behavior model for persuasive design. En *Proceedings of the 4th International Conference on Persuasive Technology* (Artículo 40). Association for Computing Machinery. https://doi.org/10.1145/1541948.1541999

Grüning, D. J., Riedel, F. y Lorenz-Spreen, P. (2023). Directing smartphone use through the self-nudge app one sec. *Proceedings of the National Academy of Sciences, 120*(8), Artículo e2213114120. https://doi.org/10.1073/pnas.2213114120

Hellier, E. J., Edworthy, J. y Dennis, I. (1993). Improving auditory warning design: Quantifying and predicting the effects of different warning parameters on perceived urgency. *Human Factors, 35*(4), 693–706. https://doi.org/10.1177/001872089303500408

International Organization for Standardization. (2011). *Graphical symbols — Safety colours and safety signs — Part 1: Design principles for safety signs and safety markings* (ISO 3864-1:2011).

Jiang, Y., Gorn, G. J., Galli, M. y Chattopadhyay, A. (2016). Does your company have the right logo? How and why circular- and angular-logo shapes influence brand attribute judgments. *Journal of Consumer Research, 42*(5), 709–726. https://doi.org/10.1093/jcr/ucv049

Jonauskaite, D., Epicoco, D., Al-Rasheed, A. S., Aruta, J. J. B. R., Bogushevskaya, V., Brederoo, S. G., Corona, V., Fomins, S., Gizdic, A., Griber, Y. A., Havelka, J., Hirnstein, M., John, G., Jopp, D. S., Karlsson, B., Konstantinou, N., Laurent, É., Marquardt, L., Mefoh, P. C., … Mohr, C. (2024). A comparative analysis of colour–emotion associations in 16–88-year-old adults from 31 countries. *British Journal of Psychology, 115*(2), 275–305. https://doi.org/10.1111/bjop.12687

Kirsh, D. (1995). The intelligent use of space. *Artificial Intelligence, 73*(1–2), 31–68. https://doi.org/10.1016/0004-3702(94)00017-U

Luffarelli, J., Mukesh, M. y Mahmood, A. (2019). Let the logo do the talking: The influence of logo descriptiveness on brand equity. *Journal of Marketing Research, 56*(5), 862–878. https://doi.org/10.1177/0022243719845000

Machado, G. M., Oliveira, M. M. y Fernandes, L. A. F. (2009). A physiologically-based model for simulation of color vision deficiency. *IEEE Transactions on Visualization and Computer Graphics, 15*(6), 1291–1298. https://doi.org/10.1109/TVCG.2009.113

McDaniel, M. A. y Einstein, G. O. (2000). Strategic and automatic processes in prospective memory retrieval: A multiprocess framework. *Applied Cognitive Psychology, 14*(7), S127–S144. https://doi.org/10.1002/acp.775

Middlebrooks, J. C. y Green, D. M. (1991). Sound localization by human listeners. *Annual Review of Psychology, 42*, 135–159. https://doi.org/10.1146/annurev.ps.42.020191.001031

Miller, C. H., Lane, L. T., Deatrick, L. M., Young, A. M. y Potts, K. A. (2007). Psychological reactance and promotional health messages: The effects of controlling language, lexical concreteness, and the restoration of freedom. *Human Communication Research, 33*(2), 219–240. https://doi.org/10.1111/j.1468-2958.2007.00297.x

Nielsen, J. (1993). *Usability engineering*. Academic Press.

Norman, D. A. (1990). *The design of everyday things*. Doubleday/Currency. (Obra original publicada en 1988)

O'Rear, A. E. y Radvansky, G. A. (2019). Location-based prospective memory. *Quarterly Journal of Experimental Psychology, 72*(3), 491–507. https://doi.org/10.1177/1747021818758608

Ottosson, B. (2020). *A perceptual color space for image processing*. https://bottosson.github.io/posts/oklab/

Ryan, R. M. y Deci, E. L. (2000). Self-determination theory and the facilitation of intrinsic motivation, social development, and well-being. *American Psychologist, 55*(1), 68–78. https://doi.org/10.1037/0003-066X.55.1.68

Silverman, J. y Barasch, A. (2023). On or off track: How (broken) streaks affect consumer decisions. *Journal of Consumer Research, 49*(6), 1095–1117. https://doi.org/10.1093/jcr/ucac029

Smit, E. S., Zeidler, C., Resnicow, K. y de Vries, H. (2019). Identifying the most autonomy-supportive message frame in digital health communication: A 2x2 between-subjects experiment. *Journal of Medical Internet Research, 21*(10), Artículo e14074. https://doi.org/10.2196/14074

Weiser, M. y Brown, J. S. (1997). The coming age of calm technology. En P. J. Denning y R. M. Metcalfe (Eds.), *Beyond calculation: The next fifty years of computing* (pp. 75–85). Copernicus. https://doi.org/10.1007/978-1-4612-0685-9_6

Wilms, L. y Oberfeld, D. (2018). Color and emotion: Effects of hue, saturation, and brightness. *Psychological Research, 82*(5), 896–914. https://doi.org/10.1007/s00426-017-0880-8

World Wide Web Consortium. (2024, 12 de diciembre). *Web content accessibility guidelines (WCAG) 2.2*. https://www.w3.org/TR/2024/REC-WCAG22-20241212/

Yablonski, J. (s. f.). *Laws of UX*. https://lawsofux.com/

## Registro de cambios (disclaimer)

### 2026-11-02 — Creación

- **Qué cambió:** se escribió un documento interno con cada decisión de diseño de Relevo —sistema, señal, objeto, marca, letra, color, íconos, interfaz, experiencia, escritura y memoria diseñada—, su fundamento, lo descartado, su evidencia y su estado; los errores encontrados con su solución; las incoherencias entre documentos, y respuestas cortas para defender cada decisión.
- **Cómo estaba antes:** las decisiones estaban repartidas entre los documentos 38 a 42, el capítulo 11 de la memoria, el estudio de los textos, el inventario de pantallas, el modelo del objeto y el registro de decisiones. Ninguno explicaba la aplicación como experiencia ni la usabilidad, y nadie había verificado las cifras de color, letra y áreas táctiles contra el código y las fuentes oficiales.
- **Por qué:** el autor pidió un documento interno que explique cada decisión de diseño, en especial la cromática, la tipográfica y la de la aplicación, con los errores vistos y cómo se solucionan, la usabilidad, la experiencia, la interfaz y el diseño gráfico, respetando los requisitos de la Universidad y APA 7. La comisión había pedido justificar las decisiones de diseño y explicar el parecido con Apple, y no apoyar el color en promedios.
