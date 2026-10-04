// Datos de la propuesta 3.9, «Letras para lucirse»: 23 letras hermosas en cuatro familias.
// id = nombre del tablero; slug = página de la letra en su fundición.
const LIC = {
  pp: 'Gratis para probar: uso personal, portafolio y proyectos escolares. Un logotipo real requiere su licencia de pago (desde 40 USD).',
  fs: 'ITF Free Font License 2.0: gratis también para uso comercial; permite crear y registrar logotipos, pero no modificar ni redistribuir el archivo.',
  ofl: 'SIL Open Font License: libre, también para uso comercial.',
};
const URL = {
  pp: (s) => 'https://pangrampangram.com/products/' + s,
  fs: (s) => 'https://www.fontshare.com/fonts/' + s,
  ofl: (s) => 'https://velvetyne.fr/fonts/' + s + '/',
};
const G = [
  ['Cursivas con vuelo', 'Cursivas de contraste alto, hechas para una sola palabra grande. Son las que más lucen.', [
    ['acma-cursiva', 'Acma Cursiva', '500 cursiva', 'Francesca Bolognini', 'Pangram Pangram', 'pp', 'acma', 'Contraste alto y trazo ligero: la «r» termina en gota y la «v» sube con un trazo fino de pluma. Es la más aireada de las cursivas.', 'Los trazos finos pierden fuerza a 16 px.'],
    ['hatton-cursiva', 'Hatton Cursiva', '500 cursiva', 'Mat Desjardins', 'Pangram Pangram', 'pp', 'hatton', 'Cursiva rotunda de cuña marcada: curvas llenas y remates afilados. La «r» lleva una gota grande y el conjunto tiene presencia de portada.', 'Es pesada: sirve para una palabra, no para texto.'],
    ['migra-cursiva', 'Migra Cursiva', '700 cursiva', 'Valerio Monopoli', 'Pangram Pangram', 'pp', 'migra', 'El contraste más extremo de la lista: la «v» y la «r» terminan en cuñas finísimas. Parece un sello de revista.', 'Tiene un tono de moda y editorial; hay que ver si encaja con un tono casero.'],
    ['kyoto-cursiva', 'Kyoto Cursiva', '400 cursiva', 'Caio Kondo', 'Pangram Pangram', 'pp', 'kyoto', 'La «v» se cierra en un lazo y la «e» y la «o» son muy redondas. Es la cursiva más particular del grupo.', 'El lazo de la «v» se pierde en tamaños chicos.'],
    ['pangaia-cursiva', 'Pangaia Cursiva', '400 cursiva', 'Samuel Salminen', 'Pangram Pangram', 'pp', 'pangaia', 'Cursiva calmada de contraste medio, con la «v» en lazo suave. La más amable de las cursivas.', 'Tiene menos drama que Acma, Hatton o Migra.'],
    ['eiko-cursiva', 'Eiko Cursiva', '400 cursiva', 'Caio Kondo', 'Pangram Pangram', 'pp', 'eiko', 'Cursiva clásica de buen contraste y mucho aire entre letras; elegante y tranquila.', 'Se parece a muchas cursivas editoriales.'],
    ['editorial-cursiva', 'Editorial New Cursiva', '400 cursiva', 'Mat Desjardins', 'Pangram Pangram', 'pp', 'editorial-new', 'La cursiva editorial más conocida: contraste alto, ritmo vivo y una «r» de gota grande.', 'Está en demasiados portafolios y revistas.'],
    ['right-didone-cursiva', 'Right Didone Cursiva', 'subfamilia Italic', 'Alex Slobzheninov', 'Pangram Pangram', 'pp', 'right-didone', 'Didona gruesa y ancha en cursiva: llena el logotipo de cuerpo y brillo.', 'Es muy ancha para la barra de la app.'],
    ['telma', 'Telma', '700', 'Jitka Janečková', 'Fontshare', 'fs', 'telma', 'Serif de pincel: el trazo grueso se afina de golpe y la «o» sale en un hilo hacia la derecha, como una firma.', 'Fontshare la clasifica como script; hay que decidir si cuenta como letra a mano.'],
  ]],
  ['Contraste alto y afilado', 'Serif de trazos finísimos y remates afilados, en redondas. Dan un aire de lujo tranquilo.', [
    ['gatwick-glider', 'Gatwick Glider', 'subfamilia Glider', 'Valerio Monopoli', 'Pangram Pangram', 'pp', 'gatwick', 'Serif ancha de contraste alto y muy abierta; se siente lujosa y tranquila.', 'Es ancha: ocupa mucho de la barra de la app.'],
    ['boska', 'Boska', '500', 'Barbara Bigosinska', 'Fontshare', 'fs', 'boska', 'Serif de moda: trazos finísimos y remates afilados; se ve limpia en blanco sobre azul.', 'El contraste se pierde a 16 px.'],
    ['bonny', 'Bonny', '500', 'Barbara Bigosinska', 'Fontshare', 'fs', 'bonny', 'Didona condensada y alta, con aperturas generosas: elegante y vertical.', 'La «v» redondeada abajo se parece a una «u».'],
    ['melodrama', 'Melodrama', '500', 'Shaily Patel', 'Fontshare', 'fs', 'melodrama', 'Contraste alto con mucho aire y brazos finísimos en la «v» y la «r»; delicada y moderna.', 'Los brazos finísimos casi desaparecen en tamaños chicos.'],
    ['stardom', 'Stardom', '400', 'Indian Type Foundry', 'Fontshare', 'fs', 'stardom', 'Didona clásica de lujo, con la tensión de un Bodoni.', 'Es la más convencional del grupo.'],
  ]],
  ['Cálidas y con cuerpo', 'Serif de trazo lleno y remates suaves: las más cercanas a un objeto de casa.', [
    ['woodland', 'Woodland', '700', 'Mat Desjardins', 'Pangram Pangram', 'pp', 'woodland', 'Serif amable de remates suaves y mucho cuerpo; la más cercana a un objeto de casa.', 'Tiene menos drama que las otras.'],
    ['gambetta', 'Gambetta', '500', 'Paul Troppmar', 'Fontshare', 'fs', 'gambetta', 'Serif con tensión de pluma: el gesto de la mano se nota en la «e» y la «r».', 'En peso 500 se ve de libro; el 700 gana presencia.'],
    ['sentient', 'Sentient', '500', 'Noopur Choksi', 'Fontshare', 'fs', 'sentient', 'Serif robusta y clara, de curvas llenas y buena lectura.', 'Tiene poco gesto propio.'],
    ['zodiak', 'Zodiak', '800', 'Jérémie Hornus, Gaetan Baehr, Jean-Baptiste Morizot, Alisa Nowak y Théo Guillard', 'Fontshare', 'fs', 'zodiak', 'Serif negra de presencia, con un contraste que marca bien la «v» y la «r».', 'Es muy pesada: en 800 llena la barra de la app.'],
    ['ouroboros', 'Ouroboros', 'Regular', 'Ariel Martín Pérez con H·Alix Sanyas', 'Velvetyne', 'ofl', 'ouroboros', 'Gorda y setentera, con una espiral en la «o»: la más alegre y la que cuenta el «vuelve».', 'Es de familia serif y fantasía: solo como logotipo.'],
  ]],
  ['Decorativas, para una sola palabra', 'Letras con un adorno que las vuelve joyas: se ven mejor solas, grandes y con poco más alrededor.', [
    ['zina', 'Zina', '400', 'Théo Guillard', 'Fontshare', 'fs', 'zina', 'Didona con filete: un hilo blanco recorre cada trazo grueso y la hace parecer una joya.', 'Pide tamaños grandes: a 16 px el filete se pierde.'],
    ['chronos-serif', 'Chronos Serif', '200', 'Mat Desjardins', 'Pangram Pangram', 'pp', 'chronos-serif', 'En el peso 200 los trazos se llenan de rayado diagonal, como un grabado.', 'Pierde contraste en color y en tamaños chicos.'],
    ['aktura', 'Aktura', '400', 'Gaetan Baehr', 'Fontshare', 'fs', 'aktura', 'Blackletter de contraste alto: solemne y reconocible.', 'Su tono es gótico y no calza con una voz calmada.'],
    ['playground', 'Playground', '500', 'Francesca Bolognini', 'Pangram Pangram', 'pp', 'playground', 'Caligráfica de aire formal, con trazos finísimos y mucho vuelo en la «l».', 'Se acerca a la letra manuscrita y se vuelve ilegible a 16 px.'],
  ]],
];
module.exports = { LIC, URL, G };
