// «Las ganas estaban» (propuesta 3.4): cada pieza dice algo que sabemos, con un par de colores y una sola letra.
// Escribe duo/las-ganas-estaban.html.
const fs = require('fs');
const path = require('path');
const { contrast } = require('../color-lib.js');
const P = require('../vivo/palette-vivo.json');
const G = require('../out/logo-geometry.json');
const { icon } = require('../apps-lib.js');
const INK = P.base.INK, BLUE = P.base.BLUE, PAPER = P.base.PAPER;

// Pares: d, el color profundo; l, el vivo. Cada uno sale de la actividad de su foto.
const PARES = {
  marca: { g: 1.3, d: '#3D38F5', l: '#D8FF4A', name: 'Azul y lima', foto: 'libro', from: 'El azul de Relevo con un lima de tono casi opuesto. Es el par de la marca.', uso: 'leer, la tarjeta, la app y el primer dato' },
  noche: { g: 1.9, d: '#1E1B5C', l: '#FF8636', name: 'Noche y naranja', foto: 'caminar', from: 'El cielo y el atardecer cuando sales a caminar.', uso: 'salir a caminar y el dato del primer paso' },
  violeta: { g: 1, d: '#4C1D95', l: '#FF9FD8', name: 'Violeta y rosa', foto: 'pintar', from: 'Dos pigmentos vecinos en la caja de acuarelas.', uso: 'pintar, el dato de la casa y la historia' },
  bosque: { g: 1.1, d: '#0B5D3B', l: '#8CFFB9', name: 'Bosque y menta', foto: 'perro', from: 'Las hojas y el pasto del paseo con el perro.', uso: 'pasear al perro' },
  mar: { g: 1.7, d: '#0F4C81', l: '#9EDCFF', name: 'Azul y celeste', foto: 'aprender', from: 'La tinta y los renglones celestes del cuaderno.', uso: 'estudiar y las portadas de sección' },
  rojo: { g: 1.25, d: '#B71A29', l: '#FFE1E8', name: 'Rojo y rosa pálido', foto: 'escribir', from: 'Un sobre rojo y el papel de una carta.', uso: 'escribirle a alguien a mano' },
};
// Objetos y lugares de las ideas de la app (documento 23).
const A = [
  { k: 'leer', par: 'marca', foto: 'libro', head: 'El libro sigue en el velador.' },
  { k: 'moverme', par: 'noche', foto: 'caminar', head: 'Las zapatillas siguen junto a la puerta.' },
  { k: 'crear', par: 'violeta', foto: 'pintar', head: 'Las acuarelas siguen en la mesa.' },
  { k: 'cuidar', par: 'bosque', foto: 'perro', head: 'La correa sigue donde la dejaste.' },
  { k: 'aprender', par: 'mar', foto: 'aprender', head: 'Los apuntes siguen en el escritorio.' },
  { k: 'compartir', par: 'rojo', foto: 'escribir', head: 'La carta sigue a medias.' },
];
const SUPPORT = 'Relevo suena ahí cuando sumas el tiempo que elegiste en tus apps.';
// Cifras de la encuesta de 53 respuestas (03_usuarios/encuesta-53-respuestas-2026-09.md).
const DATOS = [
  { id: 'dato-ganas', par: 'marca', head: 'Las ganas estaban.', n: '43', de: 'de 47', cap: 'personas querían hacer otra cosa mientras seguían en el teléfono.', pie: 'Relevo te recuerda esa otra cosa donde empieza.' },
  { id: 'dato-casa', par: 'violeta', head: 'Pasa donde están tus cosas.', n: '44', de: 'de 47', cap: 'estaban en casa cuando siguieron en el teléfono más de lo que querían.', pie: 'Relevo se queda ahí, junto a lo que querías hacer.' },
  { id: 'dato-paso', par: 'noche', head: 'Sabes por dónde empezar.', n: '42', de: 'de 43', cap: 'nombraron el primer paso de lo que querían hacer.', pie: 'Relevo te lo muestra cuando suena.' },
];
const SRC = 'Encuesta en línea, 53 respuestas, no representativa.';

const rgb = (h) => [1, 3, 5].map((i) => parseInt(h.slice(i, i + 2), 16) / 255);
const FILTROS = Object.entries(PARES).map(([k, p]) => {
  const D = rgb(p.d), L = rgb(p.l), t = (i) => `${D[i].toFixed(4)} ${L[i].toFixed(4)}`;
  return `<filter id="duo-${k}" color-interpolation-filters="sRGB" x="0" y="0" width="100%" height="100%"><feColorMatrix type="saturate" values="0"/><feComponentTransfer>${["R","G","B"].map((c) => `<feFunc${c} type="gamma" amplitude="1" exponent="${p.g}" offset="0"/>`).join("")}</feComponentTransfer><feComponentTransfer><feFuncR type="table" tableValues="${t(0)}"/><feFuncG type="table" tableValues="${t(1)}"/><feFuncB type="table" tableValues="${t(2)}"/></feComponentTransfer></filter>`;
}).join('');
const FOTOS = [...new Set(A.map((a) => a.foto))].map((f) => `--foto-${f}: url(data:image/jpeg;base64,${fs.readFileSync(path.join(__dirname, 'fotos', 'foto_' + f + '.jpg')).toString('base64')});`).join(' ');

const par = (k) => `--d:${PARES[k].d};--l:${PARES[k].l}`;
const foto = (f, k) => `<div class="foto" aria-hidden="true"><i style="background-image:var(--foto-${f});filter:contrast(1.08) url(#duo-${k})"></i></div>`;
const wm = (cls = '') => `<svg class="wm ${cls}" viewBox="0 -1500 6929.5 1840" role="img" aria-label="relevo"><rect class="wl" x="0" y="180" width="6929.5" height="160" rx="80"/><use class="ww" href="#wm-word"/></svg>`;
const ic = (n, size = 18) => icon(n, { size, color: 'currentColor', accent: 'currentColor' });

const afiche = (a, id) => `<figure class="afiche" id="${id || 'afiche-' + a.k}" style="${par(a.par)}">${foto(a.foto, a.par)}<div class="tx"><h3>${a.head}</h3><p>${SUPPORT}</p>${wm('mono')}</div></figure>`;
const dato = (d, id) => `<figure class="dato" id="${id || d.id}" style="${par(d.par)}"><div class="pi"><h3>${d.head}</h3><div class="num"><b>${d.n}</b><span>${d.de}</span></div><p class="cap2">${d.cap}</p><div class="pie">${wm('mono')}<p>${d.pie}</p></div><p class="src">${SRC}</p></div></figure>`;

const sb = () => '<div class="sb"><span>21:42</span><span class="sbi"><i></i><i></i><i></i></span></div>';
const tabs = () => `<nav class="tabs"><span class="on">${ic('inicio-lleno', 22)}<b>Inicio</b></span><span>${ic('ruta', 22)}<b>Ruta</b></span><span>${ic('perfil', 22)}<b>Perfil</b></span></nav>`;
const appInicio = () => `<figure class="phone" id="app-inicio">${sb()}<div class="scr">
  <div class="abar">${wm()}<span class="ava">${ic('perfil', 20)}</span></div>
  <h3 class="stitle">Hola.</h3>
  <div class="active" style="${par('marca')}">${foto('libro', 'marca')}<div class="ain">
    <div class="arow"><span class="chip">Contando</span></div>
    <div class="ahead">Vuelve a</div>
    <div class="avoz">leer 10 páginas.</div>
    <div class="dots15">${'<i></i>'.repeat(6)}${'<i class="off"></i>'.repeat(9)}</div>
    <div class="atime"><b>6 min</b> de 15 en tus apps</div>
  </div></div>
  <div class="facts"><div>${ic('primer-paso', 20)}<span>Cómo empiezas</span><span class="fv">Abrir el libro</span></div><div>${ic('lugar', 20)}<span>Dónde</span><span class="fv">En el velador</span></div></div>
</div>${tabs()}</figure>`;
const IDEAS = [['leer', 'marca', 'Leer'], ['caminar', 'noche', 'Salir a caminar'], ['pintar', 'violeta', 'Pintar'], ['huella', 'bosque', 'Pasear al perro'], ['estudiar', 'mar', 'Estudiar'], ['carta', 'rojo', 'Escribirle a alguien a mano']];
const appPreparar = () => `<figure class="phone" id="app-preparar">${sb()}<div class="scr">
  <div class="steps"><i class="on"></i><i></i><i></i><i></i><i></i></div>
  <h3 class="qtitle">¿Qué quieres hacer?</h3>
  <label class="field"><span>Actividad</span><span class="fieldv">leer 10 páginas</span></label>
  <p class="peyebrow">Ideas</p>
  <div class="ideas">${IDEAS.map(([i, k, t]) => `<span class="tag" style="${par(k)}">${ic(i, 16)}${t}</span>`).join('')}</div>
  <div class="btn">Seguir</div>
</div></figure>`;
const appSenal = () => `<figure class="phone senal" id="app-senal" style="${par('marca')}">${sb()}<div class="scr">
  <div class="sgtop">${wm('mono')}<span class="chip">${ic('parlante', 15)}Suena en el parlante</span></div>
  <div class="sghead">Vuelve a</div>
  <div class="sgvoz">leer 10 páginas.</div>
  <p class="sgsub">Abrir el libro · En el velador</p>
  ${foto('libro', 'marca')}
  <div class="btn">Silenciar y continuar</div>
</div></figure>`;
const historia = () => `<figure class="story" id="historia" style="${par('violeta')}">${foto('pintar', 'violeta')}<div class="tx"><h3>¿Qué querías hacer hoy?</h3><div class="wl2"></div><p>Escríbelo sobre la línea.</p>${wm('mono')}</div></figure>`;
const tarjeta = () => `<div class="cards"><figure class="pcard par" id="tarjeta-frente" style="${par('marca')}"><div class="pi">${wm('mono')}<div class="vw"><b>Vuelve a</b><i></i></div></div></figure>
<figure class="pcard papel" id="tarjeta-reverso"><div class="pi"><p>Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad que quieres tener presente y, cuando se cumple la condición que elegiste, emite una señal breve. Tú decides qué hacer después.</p>${wm()}</div></figure></div>`;
const laminas = () => `
<figure class="slide" id="lamina-dato"><div class="pi"><div class="sltop"><span>Lo que sabemos</span><span>05</span></div>
  <div class="sl-dato"><div class="n"><b>43</b><span>de 47</span></div><div><h3>Las ganas estaban.</h3><p>43 de 47 personas querían hacer otra cosa mientras seguían en el teléfono.</p><p class="src">${SRC}</p></div></div></div></figure>
<figure class="slide" id="lamina-mecanismo"><div class="pi"><div class="sltop"><span>Por qué funciona</span><span>06</span></div>
  <div class="sl-mec"><h3>Lo que querías hacer vuelve cuando algo te lo recuerda.</h3><p>Cuando estás absorto en otra cosa, una intención se recupera si aparece una señal ligada a ella. Relevo pone esa señal en el lugar donde empieza la actividad.</p><p class="src">McDaniel y Einstein (2000)</p></div></div></figure>
<figure class="slide" id="lamina-funciona"><div class="pi"><div class="sltop"><span>Cómo funciona</span><span>07</span></div>
  <ol class="sl-fun"><li>Escribes qué quieres hacer y cómo empieza.</li><li>Dejas el parlante donde empieza.</li><li>Suena ahí cuando sumas el tiempo que elegiste en tus apps.</li><li class="yo">Tú decides si empiezas o sigues en lo que estabas.</li></ol></div></figure>
<figure class="slide par" id="lamina-seccion" style="${par('mar')}"><div class="pi"><div class="sltop"><span>Sección</span><span>03</span></div><h3>Vuelve a lo que querías hacer.</h3>${wm('mono')}</div>${foto('aprender', 'mar')}</figure>`;

const DICE = [
  ['Las ganas estaban.', 'Abajo: «Relevo te recuerda esa otra cosa donde empieza».', '<b>43 de 47</b> personas querían hacer otra cosa mientras seguían en el teléfono.', 'Encuesta en línea, 53 respuestas'],
  ['Pasa donde están tus cosas.', 'Abajo: «Relevo se queda ahí, junto a lo que querías hacer».', '<b>44 de 47</b> estaban en casa cuando siguieron en el teléfono más de lo que querían.', 'Encuesta en línea, 53 respuestas'],
  ['Sabes por dónde empezar.', 'Abajo: «Relevo te lo muestra cuando suena».', '<b>42 de 43</b> nombraron el primer paso de lo que querían hacer.', 'Encuesta en línea, 53 respuestas'],
  ['Lo que querías hacer vuelve cuando algo te lo recuerda.', 'Lámina «Por qué funciona».', 'Cuando estás absorto en otra cosa, una intención se recupera si aparece <b>una señal ligada a ella</b>.', 'McDaniel y Einstein (2000); hipótesis D-091'],
  ['El libro sigue en el velador.', 'Y los otros cinco objetos. Abajo: «Relevo suena ahí cuando sumas el tiempo que elegiste en tus apps».', 'Relevo guarda qué quieres hacer, cómo empieza y dónde, y <b>suena en ese lugar</b>.', 'App 2.18; ideas de actividades (documento 23)'],
];
const dice = DICE.map(([k, small, know, src]) => `<div class="say"><div class="k">${k}<small>${small}</small></div><p>${know}</p><p class="src">${src}</p></div>`).join('');
const pares = Object.entries(PARES).map(([k, p]) => `<div class="pair" style="${par(k)}">${foto(p.foto, k)}<div class="a"><b>Aa</b><span>${p.d}</span></div><div class="b"><b>Aa</b><span>${p.l}</span></div><h3>${p.name}</h3><p>${p.from}</p><p class="cr">${contrast(p.d, p.l).toFixed(1).replace('.', ',')}:1 · ${p.uso}</p></div>`).join('\n');
const REFS = [
  ['Collins', 'Spotify, 2015', 'Llevó la paleta de Spotify de 2 a 31 colores y tiñó sus fotos con dos colores a la vez, en duotono, con un programa propio: «The Colorizer».', 'https://www.designweek.co.uk/spotify-undergoes-colourful-brand-refresh/', 'cada foto teñida con un par, y un par por pieza.'],
  ['Collins', 'Twitch, 2019', 'Un morado propio, «Extruded Purple», acompañado de una paleta secundaria de colores vivos.', 'https://www.creativebloq.com/news/twitch-rebrand', 'el azul de Relevo como color de marca y, a su lado, un vivo de tono opuesto: el lima.'],
  ['Spotify, equipo creativo propio', '«Thanks 2016, It’s Been Weird», 2016', 'Su mayor campaña hasta entonces, en 14 países: afiches con datos reales de escucha, cada uno dicho en una frase con humor.', 'https://www.thedrum.com/news/spotify-celebrates-weird-2016-largest-ever-campaign-push', 'un dato real de la encuesta, dicho en una frase cercana y con su fuente.'],
  ['Bakken & Bæck (Henrik Kongsvoll)', 'Schibsted Grotesk', 'Grotesca pensada primero para interfaces digitales, con licencia libre y pesos de 400 a 900.', 'https://github.com/schibsted/schibsted-grotesk', 'una sola letra: gruesa en titulares y números, regular en textos.'],
  ['McDaniel y Einstein', 'Marco multiproceso, 2000', 'Cuando una persona está absorta en otra tarea, recordar lo que tenía que hacer depende de que aparezca una señal ligada a esa acción.', 'https://doi.org/10.1002/acp.775', 'los afiches del objeto y la lámina «Por qué funciona».'],
  ['Encuesta del proyecto', '53 respuestas en línea', 'En 43 de 47 relatos había otra actividad que la persona quería hacer; 44 de 47 pasaron en casa; 42 de 43 nombraron un primer paso concreto.', '', 'los tres afiches de dato, siempre con su fuente.'],
];
const refs = REFS.map(([who, what, saw, url, take]) => `<article class="ref"><span class="rwhat">${what}</span><h3>${url ? `<a href="${url}">${who}</a>` : who}</h3><p>${saw}</p><p class="take">${take}</p></article>`).join('');

const T = fs.readFileSync(path.join(__dirname, 'plantilla.html'), 'utf8');
const html = T.replace('{{WORD}}', G.wordPath).replace('{{FILTROS}}', FILTROS).replace('{{WMTOP}}', wm())
  .replace('{{FOTOS}}', FOTOS)
  .replace('{{HERO}}', dato(DATOS[0], 'portada-dato') + afiche(A[0], 'portada-afiche'))
  .replace('{{DICE}}', dice).replace('{{PARES}}', pares).replace('{{REFS}}', refs)
  .replace('{{DATOS}}', DATOS.map((d) => dato(d)).join('\n'))
  .replace('{{AFICHES}}', A.map((a) => afiche(a)).join('\n'))
  .replace('{{APP}}', appInicio() + appPreparar() + appSenal())
  .replace('{{HISTORIA}}', historia()).replace('{{TARJETA}}', tarjeta()).replace('{{LAMINAS}}', laminas())
  .replace(/\{\{INK\}\}/g, INK).replace(/\{\{BLUE\}\}/g, BLUE).replace(/\{\{PAPER\}\}/g, PAPER);
if (/\{\{[A-Z]+\}\}/.test(html)) throw new Error('Quedó un marcador: ' + html.match(/\{\{[A-Z]+\}\}/)[0]);
if (/Newsreader|Georgia|Fraunces|Instrument Serif/.test(html)) throw new Error('Quedó una serif');
fs.writeFileSync(path.join(__dirname, 'las-ganas-estaban.html'), html);
// Copia local con charset para revisar y exportar fuera de claude.ai.
fs.writeFileSync(path.join(__dirname, 'vista.html'), '<meta charset="utf-8">\n' + html);
for (const [k, p] of Object.entries(PARES)) console.log(k.padEnd(8), contrast(p.d, p.l).toFixed(2));
console.log('ok', Math.round(html.length / 1024) + ' KB');
