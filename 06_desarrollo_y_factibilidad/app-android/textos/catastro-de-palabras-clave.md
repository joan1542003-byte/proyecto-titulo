# Catastro de palabras clave

**Qué es:** las palabras y frases con que la app reconoce una actividad que la persona escribe al crear un relevo propio, y lo que le sugiere después: con qué empezar y dónde dejar el Tag. **Fuente:** [`Catastro.kt`](../app/src/main/java/com/example/relevo/ui/Catastro.kt). Este documento se genera desde ese archivo con `node generar-catastro.js`, así que dice lo mismo que la app. **Versión:** 4.5 (D-163).

## En números

- **34 conceptos** en siete familias.
- **634 palabras**, **121 frases** y **31 palabras débiles**.
- **91 primeros pasos** y **61 lugares** sugeridos.

## Cómo reconoce una actividad

1. **Se normaliza el texto:** minúsculas y sin tildes, así «Película» y «pelicula» son lo mismo.
2. **Cada palabra se compara entera.** Las que terminan en «…» valen también con lo que siga: «dibuj…» reconoce dibujar, dibujo y dibujando.
3. **Puntos por concepto:**
   - cada palabra suma 1;
   - cada frase completa suma 2;
   - cada palabra débil suma medio punto, porque sola no decide, como «ver», «jugar» o «tocar».
4. **Gana el concepto con más puntos, si suma al menos 1.** Ante un empate, gana el que va primero en la lista.
5. **Si nada suma 1,** la app no sugiere nada y muestra un ejemplo en el campo.

Las frases resuelven los casos dudosos:
- «Maratón de series» es de películas y no de correr.
- «Leer una novela gráfica» es de manga y no de leer.
- «Dar una vuelta en bici» es de bicicleta y no de caminar.

Ninguna palabra pertenece a dos conceptos.

## Conceptos

### Moverte

#### perro · ícono perro

- **Palabras (13):** «perro», «perros», «perrito», «perritos», «perrita», «perra», «cachorro», «cachorra», «quiltro», «quiltra», «mascota», «mascotas», «correa».
- **Frases (6):** «pasear al perro», «sacar al perro», «jugar con el perro», «pasear a la perrita», «dar una vuelta con el perro», «sacar a pasear al perro».
- **Con qué empezar:** «Tomar la correa», «Sacar su pelota», «Llenar su botella de agua».
- **Dónde:** «Junto a la puerta», «Donde está la correa».

#### correr · ícono correr

- **Palabras (13):** «correr», «corro», «corriendo», «corrida», «trotar», «troto», «trotando», «trote», «running», «maraton», «maratones», «trotadora», «trail».
- **Frases (3):** «salir a correr», «salir a trotar», «ir a correr».
- **Con qué empezar:** «Ponerte las zapatillas», «Ponerte ropa deportiva», «Llenar la botella de agua».
- **Dónde:** «Junto a la puerta», «Junto a las zapatillas».

#### caminar · ícono caminar

- **Palabras (15):** «caminar», «camino», «caminando», «caminata», «caminatas», «pasear», «paseo», «paseos», «cerro», «cerros», «parque», «plaza», «trekking», «senderismo», «excursion».
- **Frases (5):** «salir a caminar», «salir a pasear», «dar una vuelta», «ir al parque», «subir el cerro».
- **Palabras débiles:** «salir», «vuelta».
- **Con qué empezar:** «Ponerte las zapatillas», «Llenar la botella de agua», «Elegir el recorrido».
- **Dónde:** «Junto a la puerta», «Junto a las zapatillas».

#### bici · ícono bicicleta

- **Palabras (10):** «bici», «bicis», «bicicleta», «bicicletas», «pedalear», «pedaleo», «ciclismo», «ciclovia», «cicletada», «mtb».
- **Frases (6):** «andar en bici», «andar en bicicleta», «salir en bici», «salir en bicicleta», «vuelta en bici», «vuelta en bicicleta».
- **Con qué empezar:** «Sacar la bici», «Inflar las ruedas», «Ponerte el casco».
- **Dónde:** «Junto a la puerta», «Junto a la bici».

#### ejercicio · ícono ejercicio

- **Palabras (42):** «ejercicio», «ejercicios», «ejercitar», «ejercitarme», «entrenar», «entreno», «entrenamiento», «entrenamientos», «gimnasio», «gym», «pesas», «rutina», «rutinas», «cardio», «hiit», «calistenia», «spinning», «zumba», «abdominales», «flexiones», «lagartijas», «sentadillas», «crossfit», «funcional», «boxeo», «kickboxing», «karate», «judo», «taekwondo», «jiujitsu», «mma», «escalada», «escalar», «patinar», «patines», «skate», «surf», «remo», «gimnasia», «bailar», «baile», «danza».
- **Frases (7):** «hacer una serie», «serie corta», «artes marciales», «ir al gimnasio», «ir al gym», «hacer ejercicio», «muay thai».
- **Con qué empezar:** «Ponerte ropa deportiva», «Estirar la colchoneta», «Preparar el bolso».
- **Dónde:** «Junto al clóset», «Donde guardas la colchoneta», «Junto a la puerta».

#### yoga · ícono estirar

- **Palabras (14):** «yoga», «estirar», «estiro», «estirarme», «estirarte», «elongar», «elongacion», «elongaciones», «estiramiento», «estiramientos», «pilates», «flexibilidad», «movilidad», «colchoneta».
- **Frases (2):** «hacer yoga», «clase de yoga».
- **Con qué empezar:** «Desenrollar la colchoneta», «Ponerte ropa cómoda».
- **Dónde:** «Donde guardas la colchoneta», «Junto a la cama».

#### nadar · ícono nadar

- **Palabras (8):** «nadar», «nado», «nadando», «natacion», «piscina», «piscinas», «acuagym», «brazadas».
- **Frases (2):** «ir a nadar», «ir a la piscina».
- **Con qué empezar:** «Preparar el traje de baño», «Echar la toalla al bolso».
- **Dónde:** «Junto a la puerta», «Junto al bolso».

#### pelota · ícono pelota

- **Palabras (28):** «futbol», «futbolito», «babyfutbol», «pichanga», «pichangas», «pelota», «basquetbol», «basquet», «basket», «basketball», «voleibol», «voley», «volley», «handball», «rugby», «hockey», «tenis», «padel», «squash», «badminton», «pingpong», «beisbol», «partido», «partidos», «cancha», «raqueta», «deporte», «deportes».
- **Frases (6):** «jugar a la pelota», «jugar futbol», «jugar una pichanga», «ping pong», «baby futbol», «hacer deporte».
- **Con qué empezar:** «Preparar las zapatillas», «Inflar la pelota», «Avisar al equipo».
- **Dónde:** «Junto a la puerta».

#### plantas · ícono plantas

- **Palabras (23):** «planta», «plantas», «plantar», «regar», «riego», «jardin», «jardineria», «huerto», «huertos», «macetero», «maceteros», «suculentas», «cactus», «bonsai», «flores», «podar», «sembrar», «almacigo», «almacigos», «compost», «abonar», «trasplantar», «cultivar».
- **Frases (3):** «regar las plantas», «cuidar las plantas», «trabajar en el jardin».
- **Con qué empezar:** «Llenar la regadera», «Ponerte los guantes».
- **Dónde:** «Junto a las plantas», «Junto a la regadera».

### Leer y aprender

#### manga · ícono manga

- **Palabras (14):** «manga», «mangas», «manhwa», «manhua», «comic», «comics», «historieta», «historietas», «tomo», «tomos», «webtoon», «shonen», «seinen», «shojo».
- **Frases (2):** «novela grafica», «novelas graficas».
- **Palabras débiles:** «leer», «capitulo», «capitulos».
- **Con qué empezar:** «Sacar el tomo del estante», «Abrir el tomo donde quedaste».
- **Dónde:** «Junto al estante», «En el velador».

#### leer · ícono leer

- **Palabras (23):** «leer», «leo», «leyendo», «lectura», «lector», «libro», «libros», «novela», «novelas», «cuento», «cuentos», «pagina», «paginas», «poesia», «ensayo», «ensayos», «revista», «revistas», «biografia», «kindle», «ebook», «audiolibro», «biblioteca».
- **Frases (3):** «leer un libro», «terminar el libro», «club de lectura».
- **Palabras débiles:** «capitulo», «capitulos».
- **Con qué empezar:** «Elegir el libro», «Abrir el libro en el marcador», «Dejar el libro a la vista».
- **Dónde:** «En el velador», «En el sillón», «Junto al estante».

#### estudiar · ícono estudiar

- **Palabras (37):** «estudiar», «estudio», «estudiando», «estudios», «apuntes», «tarea», «tareas», «prueba», «pruebas», «examen», «examenes», «certamen», «certamenes», «repasar», «repaso», «resumen», «resumenes», «materia», «ramo», «ramos», «informe», «informes», «tesis», «universidad», «facultad», «colegio», «liceo», «preu», «paes», «matematica», «matematicas», «calculo», «fisica», «quimica», «biologia», «programar», «programacion».
- **Frases (5):** «hacer la tarea», «repasar la materia», «estudiar para la prueba», «preparar el examen», «trabajo de la u».
- **Palabras débiles:** «clase», «clases», «curso», «cursos».
- **Con qué empezar:** «Abrir los apuntes», «Despejar el escritorio», «Abrir el cuaderno en la tarea».
- **Dónde:** «En el escritorio».

#### idiomas · ícono idiomas

- **Palabras (19):** «ingles», «english», «idioma», «idiomas», «frances», «portugues», «aleman», «japones», «coreano», «italiano», «chino», «ruso», «arabe», «lengua», «lenguas», «vocabulario», «gramatica», «pronunciacion», «duolingo».
- **Frases (3):** «lengua de senas», «aprender ingles», «aprender un idioma».
- **Con qué empezar:** «Abrir el cuaderno de vocabulario», «Abrir el libro del curso».
- **Dónde:** «En el escritorio».

#### escribir · ícono escribir

- **Palabras (20):** «escribir», «escribo», «escribiendo», «escritura», «escribirle», «diario», «diarios», «journal», «journaling», «bitacora», «carta», «postal», «postales», «poema», «poemas», «relato», «relatos», «guion», «guiones», «blog».
- **Frases (5):** «escribir un cuento», «escribir una novela», «escribir en el diario», «escribir una carta», «escribir un poema».
- **Con qué empezar:** «Abrir el cuaderno», «Dejar un lápiz sobre el cuaderno».
- **Dónde:** «En el escritorio», «En el velador».

### Crear

#### dibujar · ícono dibujar

- **Palabras (17):** «dibuj…» (y lo que siga), «boceto», «bocetos», «bocetear», «ilustrar», «ilustracion», «ilustraciones», «croquis», «sketch», «retrato», «retratos», «caligrafia», «lettering», «garabatear», «garabatos», «carboncillo», «procreate».
- **Frases (1):** «hacer un boceto».
- **Con qué empezar:** «Sacar el cuaderno y un lápiz», «Abrir el cuaderno en ese dibujo», «Sacar los lápices».
- **Dónde:** «En el escritorio», «En la mesa».

#### pintar · ícono pintar

- **Palabras (21):** «pintar», «pinto», «pintando», «pintura», «pinturas», «acuarela», «acuarelas», «oleo», «oleos», «acrilico», «acrilicos», «gouache», «lienzo», «tempera», «temperas», «pincel», «pinceles», «mural», «murales», «cuadro», «cuadros».
- **Frases (1):** «pintar un cuadro».
- **Con qué empezar:** «Preparar las acuarelas», «Llenar un vaso con agua», «Sacar los pinceles».
- **Dónde:** «En la mesa», «En el escritorio».

#### tejer · ícono tejer

- **Palabras (21):** «tejer», «tejo», «tejiendo», «tejido», «tejidos», «palillos», «crochet», «croche», «bordar», «bordado», «bordados», «coser», «costura», «zurcir», «lana», «ovillo», «hilo», «telar», «macrame», «patchwork», «amigurumi».
- **Frases (2):** «punto cruz», «maquina de coser».
- **Con qué empezar:** «Sacar el tejido», «Enhebrar la aguja», «Dejar la lana a mano».
- **Dónde:** «En el sillón», «En la mesa».

#### maqueta · ícono maqueta

- **Palabras (12):** «maqueta», «maquetas», «modelismo», «aeromodelismo», «lego», «legos», «armable», «armables», «miniatura», «miniaturas», «gunpla», «gundam».
- **Frases (2):** «armar la maqueta», «armar el lego».
- **Palabras débiles:** «armar».
- **Con qué empezar:** «Abrir la caja de la maqueta», «Dejar la pieza a la vista», «Ordenar las piezas».
- **Dónde:** «En la mesa», «En la mesa de trabajo».

#### manualidades · ícono manualidades

- **Palabras (18):** «manualidad», «manualidades», «recortar», «collage», «origami», «scrapbook», «artesania», «artesanias», «ceramica», «arcilla», «greda», «plasticina», «bisuteria», «mostacillas», «pulseras», «decoupage», «carpinteria», «tallar».
- **Frases (1):** «hacer pulseras».
- **Con qué empezar:** «Sacar los materiales», «Despejar la mesa», «Dejar la tijera y el pegamento a mano».
- **Dónde:** «En la mesa de trabajo», «En la mesa».

#### foto · ícono fotografia

- **Palabras (12):** «foto», «fotos», «fotografia», «fotografias», «fotografiar», «fotografo», «camara», «camaras», «rollo», «analogica», «revelar», «revelado».
- **Frases (3):** «sacar fotos», «editar fotos», «salir a fotografiar».
- **Con qué empezar:** «Cargar la batería de la cámara», «Sacar la cámara del estuche».
- **Dónde:** «Junto a la puerta», «En el escritorio».

### Jugar y disfrutar

#### piano · ícono piano

- **Palabras (3):** «piano», «organo», «sintetizador».
- **Frases (0):** —.
- **Palabras débiles:** «teclado», «tocar», «practicar».
- **Con qué empezar:** «Abrir la tapa del piano», «Dejar la partitura a la vista».
- **Dónde:** «Junto al piano».

#### instrumento · ícono guitarra

- **Palabras (20):** «guitarra», «ukelele», «violin», «charango», «flauta», «trompeta», «saxo», «saxofon», «cello», «contrabajo», «bateria», «acordeon», «arpa», «clarinete», «armonica», «mandolina», «quena», «zampona», «ocarina», «instrumento».
- **Frases (2):** «practicar un instrumento», «tocar un instrumento».
- **Palabras débiles:** «tocar», «practicar», «bajo».
- **Con qué empezar:** «Sacar {x} del estuche», «Afinar {x}», «Dejar la partitura a la vista».
- **Dónde:** «{junto}».

#### cantar · ícono musica

- **Palabras (6):** «cantar», «canto», «cantando», «coro», «karaoke», «vocalizar».
- **Frases (1):** «clases de canto».
- **Con qué empezar:** «Elegir la canción», «Tomar un vaso de agua».
- **Dónde:** «En el sillón».

#### musica · ícono musica

- **Palabras (19):** «musica», «disco», «discos», «album», «albumes», «cancion», «canciones», «playlist», «vinilo», «vinilos», «podcast», «podcasts», «radio», «spotify», «audifonos», «componer», «composicion», «beats», «dj».
- **Frases (4):** «escuchar musica», «escuchar un disco», «escuchar un podcast», «hacer musica».
- **Palabras débiles:** «escuchar».
- **Con qué empezar:** «Ponerte los audífonos», «Elegir el disco».
- **Dónde:** «En el sillón», «Junto a los discos».

#### videojuegos · ícono videojuegos

- **Palabras (20):** «videojuego», «videojuegos», «consola», «consolas», «play», «playstation», «xbox», «nintendo», «steam», «gamer», «gaming», «gamear», «partida», «partidas», «minecraft», «fortnite», «roblox», «valorant», «zelda», «joystick».
- **Frases (4):** «jugar en el computador», «jugar en el pc», «jugar play», «jugar en linea».
- **Palabras débiles:** «jugar», «juego», «switch», «pc», «mando».
- **Con qué empezar:** «Encender la consola», «Dejar el control cargado», «Avisar a quien juega contigo».
- **Dónde:** «Junto a la tele», «Junto al computador».

#### peliculas · ícono pelicula

- **Palabras (20):** «pelicula», «peliculas», «peli», «pelis», «serie», «series», «temporada», «temporadas», «documental», «documentales», «cine», «anime», «dorama», «doramas», «kdrama», «teleserie», «teleseries», «netflix», «teatro», «capitulo».
- **Frases (4):** «maraton de series», «ver una pelicula», «ver una serie», «ir al cine».
- **Palabras débiles:** «ver», «tele».
- **Con qué empezar:** «Elegir la película», «Elegir el capítulo», «Preparar cabritas», «Avisar a quien ve contigo».
- **Dónde:** «Junto a la tele», «En el sillón».

#### cartas · ícono cartas

- **Palabras (11):** «cartas», «naipe», «naipes», «mazo», «carioca», «poker», «truco», «brisca», «solitario», «blackjack», «yugioh».
- **Frases (3):** «jugar a las cartas», «jugar cartas», «jugar carioca».
- **Con qué empezar:** «Sacar el mazo», «Despejar la mesa», «Avisar a quien juega contigo».
- **Dónde:** «En la mesa».

#### juego de mesa · ícono juego de mesa

- **Palabras (17):** «ajedrez», «puzzle», «puzzles», «rompecabezas», «domino», «ludo», «jenga», «monopoly», «scrabble», «catan», «dixit», «pictionary», «bingo», «dados», «sudoku», «crucigrama», «crucigramas».
- **Frases (4):** «juego de mesa», «juegos de mesa», «jugar damas», «sopa de letras».
- **Con qué empezar:** «Sacar la caja», «Despejar la mesa», «Avisar a quien juega contigo».
- **Dónde:** «En la mesa».

### En casa

#### cocinar · ícono cocinar

- **Palabras (27):** «cocinar», «cocino», «cocinando», «cocina», «receta», «recetas», «hornear», «horno», «reposteria», «pasteleria», «pan», «masa», «queque», «kuchen», «galletas», «brownies», «torta», «postre», «postres», «pizza», «empanadas», «sopaipillas», «ensalada», «almuerzo», «cena», «desayuno», «comida».
- **Frases (6):** «preparar la cena», «preparar el almuerzo», «hacer pan», «pan amasado», «tomar once», «preparar la once».
- **Palabras débiles:** «preparar».
- **Con qué empezar:** «Reunir los ingredientes», «Dejar la receta a la vista», «Lavar la tabla de picar».
- **Dónde:** «En el mesón de la cocina».

#### ordenar · ícono ordenar

- **Palabras (24):** «ordenar», «ordeno», «ordenando», «orden», «limpiar», «limpio», «limpieza», «aseo», «barrer», «aspirar», «trapear», «lavar», «lavadora», «planchar», «ropa», «loza», «platos», «basura», «reciclar», «cajon», «cajones», «closet», «ropero», «doblar».
- **Frases (12):** «hacer la cama», «lavar la loza», «lavar la ropa», «colgar la ropa», «doblar la ropa», «limpiar la cocina», «ordenar la cocina», «ordenar la pieza», «ordenar el escritorio», «limpiar el bano», «sacar la basura», «sacar el polvo».
- **Palabras débiles:** «pieza», «guardar».
- **Con qué empezar:** «Juntar la ropa en el canasto», «Vaciar el cajón sobre la cama», «Abrir la ventana».
- **Dónde:** «Junto al cajón», «Junto al canasto», «Junto a la cama».

### Descansar

#### dormir · ícono dormir

- **Palabras (12):** «dormir», «duermo», «dormirme», «dormirte», «acostarme», «acostarte», «acostarse», «acostar», «siesta», «descansar», «descanso», «sueno».
- **Frases (5):** «ir a dormir», «irme a acostar», «dormir temprano», «dormir a tiempo», «apagar la luz».
- **Palabras débiles:** «cama».
- **Con qué empezar:** «Dejar el teléfono cargando lejos de la cama», «Apagar la luz grande», «Ponerte el pijama».
- **Dónde:** «Junto al cargador», «Junto a la cama».

#### meditar · ícono meditar

- **Palabras (17):** «meditar», «medito», «meditacion», «meditaciones», «respirar», «respiracion», «respiraciones», «mindfulness», «relajarme», «relajarte», «relajar», «calma», «rezar», «orar», «oracion», «rosario», «qigong».
- **Frases (2):** «respirar profundo», «tai chi».
- **Con qué empezar:** «Sentarte en el cojín», «Apagar la luz grande».
- **Dónde:** «Junto al cojín», «Junto a la cama».

### Con otras personas

#### llamar · ícono llamar

- **Palabras (11):** «llamar», «llamo», «llamarla», «llamarlo», «llamarle», «llamada», «llamadas», «videollamada», «videollamar», «facetime», «conversar».
- **Frases (0):** —.
- **Palabras débiles:** «hablar».
- **Con qué empezar:** «Buscar su número», «Escribirle que vas a llamar».
- **Dónde:** «En el sillón».

#### compartir · ícono compartir

- **Palabras (47):** «visitar», «visita», «juntarme», «juntarte», «juntarnos», «juntarse», «junta», «carrete», «asado», «cumpleanos», «abuela», «abuelo», «abuelos», «abuelita», «abuelito», «amigos», «amigas», «amiga», «amigo», «amistades», «familia», «mama», «papa», «hermano», «hermana», «hermanos», «tia», «tio», «tias», «tios», «primo», «prima», «primos», «sobrino», «sobrina», «vecino», «vecina», «pareja», «polola», «pololo», «novia», «novio», «esposa», «esposo», «hijos», «hija», «hijo».
- **Frases (6):** «comer juntos», «almorzar con», «cenar con», «tomar un cafe», «salir con amigos», «juntarme con».
- **Con qué empezar:** «Avisar que vas», «Preparar algo para llevar», «Poner la mesa».
- **Dónde:** «Junto a la puerta», «En la mesa del comedor».

## Para sumar palabras

1. Agregar la palabra en minúsculas y sin tildes a `words`, o la frase a `phrases`, del concepto en `Catastro.kt`.
2. Si la palabra también puede ser de otra actividad («clase», «jugar»), va en `weak`.
3. Comprobar que no esté en otro concepto, sumar un caso a `CatastroTest.kt` y volver a generar este documento.

## Registro de cambios (disclaimer)

### 2026-11-06 — Creación (4.5, D-163)

- **Qué cambió:** se documentan todas las palabras, frases, palabras débiles, primeros pasos y lugares del catastro, generados desde el código.
- **Cómo estaba antes:** el catastro de la 4.3 tenía 322 palabras, 20 frases y 21 palabras débiles, y solo se podía leer en el código.
- **Por qué:** el autor pidió más palabras y frases clave para los relevos personalizados, y documentarlas todas.
