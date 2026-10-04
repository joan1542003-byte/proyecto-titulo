// «El traspaso» (propuesta 3.5): logotipo en Familjen Grotesk con el traspaso de la «l» a la «e», una familia de
// colores en que todos combinan con todos y el color solo cuando hace falta. Escribe v35/el-traspaso.html y v35/vista.html.
const fs = require('fs');
const path = require('path');
const { contrast, simulate, hex } = require('../color-lib.js');
const P = require('../vivo/palette-vivo.json');
const G = require('../out/logo-geometry.json');
const { icon } = require('../apps-lib.js');
const INK = P.base.INK, BLUE = P.base.BLUE, PAPER = P.base.PAPER;
const ERROR = '#B3261E';
const NEUTROS = [PAPER, '#FFFFFF', INK, '#5B5F68', '#E4E4DF'];

// Familia de color (OKLCH): los claros con luz 0,82 y croma 0,13; los profundos con luz 0,33 y croma 0,11 (v35/paleta-lab.js, opción B).
const CLAROS = { sol: '#E7BF57', naranja: '#FEB074', rosa: '#FEA4CF', menta: '#6FDEA7', celeste: '#54D6FE', lila: '#CEB5FE' };
const PROFUNDOS = { violeta: '#3F2364', petroleo: '#013C4C', bosque: '#014128', vino: '#5C153D' };
const NOMBRE = { sol: 'sol', naranja: 'naranja', rosa: 'rosa', menta: 'menta', celeste: 'celeste', lila: 'lila', violeta: 'violeta', petroleo: 'petróleo', bosque: 'bosque', vino: 'vino' };
// Cada actividad: su claro (la identidad) y un profundo de su mundo. g: curva para fotos claras.
const ACT = {
  leer: { act: 'Leer', claro: 'sol', prof: 'violeta', foto: 'libro', g: 1.3, head: 'El libro sigue en el velador.', why: 'La luz de la lámpara en la noche.' },
  moverme: { act: 'Salir a caminar', claro: 'naranja', prof: 'petroleo', foto: 'caminar', g: 1.9, head: 'Las zapatillas siguen junto a la puerta.', why: 'El atardecer y el cielo cuando sales.' },
  crear: { act: 'Pintar', claro: 'rosa', prof: 'violeta', foto: 'pintar', g: 1, head: 'Las acuarelas siguen en la mesa.', why: 'Dos pigmentos de la caja de acuarelas.' },
  cuidar: { act: 'Pasear al perro', claro: 'menta', prof: 'bosque', foto: 'perro', g: 1.1, head: 'La correa sigue donde la dejaste.', why: 'Las hojas y el pasto del paseo.' },
  aprender: { act: 'Estudiar', claro: 'celeste', prof: 'petroleo', foto: 'aprender', g: 1.7, head: 'Los apuntes siguen en el escritorio.', why: 'La tinta y los renglones del cuaderno.' },
  compartir: { act: 'Escribirle a alguien a mano', claro: 'lila', prof: 'vino', foto: 'escribir', g: 1.25, head: 'La carta sigue a medias.', why: 'El lacre del sobre y el papel de la carta.' },
};
const ORDER = Object.keys(ACT);
const COLOR_AFICHES = ['leer', 'moverme']; // uno de cada tres va en color
const SUPPORT = 'Relevo suena ahí cuando sumas el tiempo que elegiste en tus apps.';
const DATOS = [
  { id: 'dato-ganas', modo: 'marca', head: 'Las ganas estaban.', n: '43', de: 'de 47', cap: 'personas querían hacer otra cosa mientras seguían en el teléfono.', pie: 'Relevo te recuerda esa otra cosa donde empieza.' },
  { id: 'dato-casa', modo: 'calma', head: 'Pasa donde están tus cosas.', n: '44', de: 'de 47', cap: 'estaban en casa cuando siguieron en el teléfono más de lo que querían.', pie: 'Relevo se queda ahí, junto a lo que querías hacer.' },
  { id: 'dato-paso', modo: 'calma', head: 'Sabes por dónde empezar.', n: '42', de: 'de 43', cap: 'nombraron el primer paso de lo que querían hacer.', pie: 'Relevo te lo muestra cuando suena.' },
];
const SRC = 'Encuesta en línea, 53 respuestas, no representativa.';
const PCT = { calma: '0,7 %', presencia: '1 %', senal: '100 %' };

// Logotipo: Familjen Grotesk 700, minúsculas, apretado; el gancho de la «l» toca la «e» (el traspaso).
const LOGO_K = [-0.02, -0.025, -0.075, -0.03, -0.04, 0];
const logo = (cls = '') => `<span class="logo ${cls}" role="img" aria-label="relevo">${'relevo'.split('').map((c, i) => `<span aria-hidden="true"${i === 2 ? ' class="t"' : ''} style="margin-right:${LOGO_K[i]}em">${c}</span>`).join('')}</span>`;
const wmViejo = () => `<svg class="wm" viewBox="0 -1500 6929.5 1840" role="img" aria-label="relevo, logotipo anterior"><rect class="wl" x="0" y="180" width="6929.5" height="160" rx="80"/><use class="ww" href="#wm-word"/></svg>`;

const rgb = (h) => [1, 3, 5].map((i) => parseInt(h.slice(i, i + 2), 16) / 255);
const filtro = (id, d, l, g) => { const D = rgb(d), L = rgb(l), t = (i) => `${D[i].toFixed(4)} ${L[i].toFixed(4)}`; return `<filter id="${id}" color-interpolation-filters="sRGB" x="0" y="0" width="100%" height="100%"><feColorMatrix type="saturate" values="0"/><feComponentTransfer>${['R', 'G', 'B'].map((c) => `<feFunc${c} type="gamma" amplitude="1" exponent="${g}" offset="0"/>`).join('')}</feComponentTransfer><feComponentTransfer><feFuncR type="table" tableValues="${t(0)}"/><feFuncG type="table" tableValues="${t(1)}"/><feFuncB type="table" tableValues="${t(2)}"/></feComponentTransfer></filter>`; };
const FILTROS = ORDER.map((k) => filtro('duo-' + k, PROFUNDOS[ACT[k].prof], CLAROS[ACT[k].claro], ACT[k].g) + filtro('gris-' + k, INK, PAPER, ACT[k].g)).join('');
const FOTOS = ORDER.map((k) => `--foto-${ACT[k].foto}: url(data:image/jpeg;base64,${fs.readFileSync(path.join(__dirname, '..', 'duo', 'fotos', 'foto_' + ACT[k].foto + '.jpg')).toString('base64')});`).join(' ');

const vars = (bg, fg) => `--d:${bg};--l:${fg}`;
const actVars = (k) => vars(PROFUNDOS[ACT[k].prof], CLAROS[ACT[k].claro]);
const foto = (k, color) => `<div class="foto" aria-hidden="true"><i style="background-image:var(--foto-${ACT[k].foto});filter:contrast(1.08) url(#${color ? 'duo' : 'gris'}-${k})"></i></div>`;
const ic = (n, size = 18) => icon(n, { size, color: 'currentColor', accent: 'currentColor' });
const cr = (a, b) => contrast(a, b).toFixed(1).replace('.', ',');
const crSim = (a, b) => Math.min(...['protan', 'deutan', 'tritan'].map((t) => contrast(hex(simulate(a, t)), hex(simulate(b, t)))));

// Piezas
const afiche = (k, id) => { const color = COLOR_AFICHES.includes(k); return `<figure class="afiche${color ? '' : ' calma'}" id="${id || 'afiche-' + k}" style="${color ? actVars(k) : vars(PAPER, INK)}">${foto(k, color)}<div class="tx"><h3>${ACT[k].head}</h3><p>${SUPPORT}</p>${logo()}</div></figure>`; };
const dato = (d, id) => `<figure class="dato" id="${id || d.id}" style="${d.modo === 'marca' ? vars(PAPER, BLUE) : vars(INK, PAPER)}"><div class="pi"><h3>${d.head}</h3><div class="num"><b>${d.n}</b><span>${d.de}</span></div><p class="cap2">${d.cap}</p><div class="pie">${logo()}<p>${d.pie}</p></div><p class="src">${SRC}</p></div></figure>`;
const sb = () => '<div class="sb"><span>21:42</span><span class="sbi"><i></i><i></i><i></i></span></div>';
const tabs = () => `<nav class="tabs"><span class="on">${ic('inicio-lleno', 22)}<b>Inicio</b></span><span>${ic('ruta', 22)}<b>Ruta</b></span><span>${ic('perfil', 22)}<b>Perfil</b></span></nav>`;
const appInicio = () => `<figure class="phone" id="app-inicio">${sb()}<div class="scr">
  <div class="abar">${logo()}<span class="ava">${ic('perfil', 20)}</span></div>
  <h3 class="stitle">Hola.</h3>
  <div class="active blanca">${foto('leer', false)}<div class="ain">
    <div class="arow"><span class="chip on" data-par style="${actVars('leer')}">Contando</span></div>
    <div class="ahead">Vuelve a</div>
    <div class="avoz">leer 10 páginas.</div>
    <div class="dots15" style="color:${PROFUNDOS[ACT.leer.prof]}">${'<i data-par></i>'.repeat(6)}${'<i class="off"></i>'.repeat(9)}</div>
    <div class="atime"><b>6 min</b> de 15 en tus apps</div>
  </div></div>
  <div class="facts"><div>${ic('primer-paso', 20)}<span>Cómo empiezas</span><span class="fv">Abrir el libro</span></div><div>${ic('lugar', 20)}<span>Dónde</span><span class="fv">En el velador</span></div></div>
</div>${tabs()}</figure>`;
const IDEAS = [['leer', 'leer', 'Leer'], ['caminar', 'moverme', 'Salir a caminar'], ['pintar', 'crear', 'Pintar'], ['huella', 'cuidar', 'Pasear al perro'], ['estudiar', 'aprender', 'Estudiar'], ['carta', 'compartir', 'Escribirle a alguien a mano']];
const appPreparar = () => `<figure class="phone" id="app-preparar">${sb()}<div class="scr">
  <div class="steps"><i class="on"></i><i></i><i></i><i></i><i></i></div>
  <h3 class="qtitle">¿Qué quieres hacer?</h3>
  <label class="field"><span>Actividad</span><span class="fieldv">leer 10 páginas</span></label>
  <p class="peyebrow">Ideas</p>
  <div class="ideas">${IDEAS.map(([i, k, t]) => `<span class="tag${k === 'leer' ? ' on' : ''}"${k === 'leer' ? ' data-par' : ''} style="${actVars(k)}">${ic(i, 16)}${t}</span>`).join('')}</div>
  <div class="btn">Seguir</div>
</div></figure>`;
const appSenal = () => `<figure class="phone senal" id="app-senal" data-par style="${actVars('leer')}">${sb()}<div class="scr">
  <div class="sgtop">${logo()}<span class="chip">${ic('parlante', 15)}Suena en el parlante</span></div>
  <div class="sghead">Vuelve a</div>
  <div class="sgvoz">leer 10 páginas.</div>
  <p class="sgsub">Abrir el libro · En el velador</p>
  ${foto('leer', true)}
  <div class="btn">Silenciar y continuar</div>
</div></figure>`;
const historia = () => `<figure class="story calma" id="historia" style="${vars(PAPER, INK)}">${foto('crear', false)}<div class="tx"><h3>¿Qué querías hacer hoy?</h3><div class="wl2"></div><p>Escríbelo sobre la línea.</p>${logo()}</div></figure>`;
const tarjeta = () => `<div class="cards"><figure class="pcard par" id="tarjeta-frente" style="${vars(BLUE, PAPER)}"><div class="pi">${logo()}<div class="vw"><b>Vuelve a</b><i></i></div></div></figure>
<figure class="pcard papel" id="tarjeta-reverso"><div class="pi"><p>Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad que quieres tener presente y, cuando se cumple la condición que elegiste, emite una señal breve. Tú decides qué hacer después.</p>${logo()}</div></figure></div>`;
const laminas = () => `<figure class="slide" id="lamina-dato"><div class="pi"><div class="sltop"><span>Lo que sabemos</span><span>05</span></div>
  <div class="sl-dato"><div class="n"><b>43</b><span>de 47</span></div><div><h3>Las ganas estaban.</h3><p>43 de 47 personas querían hacer otra cosa mientras seguían en el teléfono.</p><p class="src">${SRC}</p></div></div></div></figure>
<figure class="slide" id="lamina-mecanismo"><div class="pi"><div class="sltop"><span>Por qué funciona</span><span>06</span></div>
  <div class="sl-mec"><h3>Lo que querías hacer vuelve cuando algo te lo recuerda.</h3><p>Cuando estás absorto en otra cosa, una intención se recupera si aparece una señal ligada a ella. Relevo pone esa señal en el lugar donde empieza la actividad.</p><p class="src">McDaniel y Einstein (2000)</p></div></div></figure>
<figure class="slide" id="lamina-funciona"><div class="pi"><div class="sltop"><span>Cómo funciona</span><span>07</span></div>
  <ol class="sl-fun"><li>Escribes qué quieres hacer y cómo empieza.</li><li>Dejas el parlante donde empieza.</li><li>Suena ahí cuando sumas el tiempo que elegiste en tus apps.</li><li class="yo">Tú decides si empiezas o sigues en lo que estabas.</li></ol></div></figure>
<figure class="slide marca" id="lamina-seccion" style="${vars(INK, PAPER)}"><div class="pi"><div class="sltop"><span>Sección</span><span>03</span></div><h3>Vuelve a lo que querías hacer.</h3>${logo()}</div></figure>`;

// Logotipo: exploración
const FUENTES = [
  ['Schibsted Grotesk', "font-family:'Schibsted Grotesk';font-weight:650", 'La actual. Limpia, pero sin un rasgo propio que se recuerde.'],
  ['Bricolage Grotesque', "font-family:'Bricolage Grotesque';font-weight:700;font-variation-settings:'opsz' 96", 'Cálida y con carácter, más editorial que cercana. Segunda opción.'],
  ['Funnel Display', "font-family:'Funnel Display';font-weight:700", 'Su «r» se recuerda, pero el conjunto se siente técnico.'],
  ['Syne', "font-family:'Syne';font-weight:700", 'Expresiva y ancha; ocupa demasiado en la barra de la app.'],
  ['Gabarito', "font-family:'Gabarito';font-weight:700", 'Amable y firme, con pocos rasgos propios.'],
  ['Familjen Grotesk', "font-family:'Familjen Grotesk';font-weight:700", 'Cercana, con trampas de tinta y una «l» con gancho que puede pasar a la «e». Elegida.'],
];
const fuentes = FUENTES.map(([n, st, v]) => `<article class="fnt${n === 'Familjen Grotesk' ? ' pick' : ''}"><div class="w" style="${st}">relevo</div><b>${n}</b><p>${v}</p></article>`).join('');

// Color: matriz de todos con todos
const matriz = `<div class="mxwrap"><div class="mx"><span class="h"></span>${Object.keys(CLAROS).map((c) => `<span class="h">${NOMBRE[c]}</span>`).join('')}${Object.entries(PROFUNDOS).map(([pk, pv]) => `<span class="h">${NOMBRE[pk]}</span>${Object.values(CLAROS).map((cv) => `<div class="c" style="background:${pv};color:${cv}"><b>Aa</b><span>${cr(pv, cv)}:1</span></div>`).join('')}`).join('')}</div></div>`;
let minMx = 99, minMxSim = 99;
for (const pv of Object.values(PROFUNDOS)) for (const cv of Object.values(CLAROS)) { minMx = Math.min(minMx, contrast(pv, cv)); minMxSim = Math.min(minMxSim, crSim(pv, cv)); }
const chord = (o) => `<div class="chord">${Object.values(o).map((c) => `<i style="background:${c}"></i>`).join('')}</div>`;
const EJ = [['violeta', 'menta'], ['bosque', 'lila'], ['vino', 'celeste'], ['petroleo', 'rosa']];
const ejemplos = EJ.map(([p, c]) => `<div class="ej" style="background:${PROFUNDOS[p]};color:${CLAROS[c]}"><b>${NOMBRE[p][0].toUpperCase() + NOMBRE[p].slice(1)} con ${NOMBRE[c]}</b><span>${cr(PROFUNDOS[p], CLAROS[c])}:1</span></div>`).join('');
const actTabla = `<table class="roles-t act-t"><colgroup><col class="c1"><col class="c2"><col class="c3"><col class="c4"></colgroup><thead><tr><th>Actividad</th><th>Claro, su identidad</th><th>Profundo, su fondo</th><th>De dónde sale</th></tr></thead><tbody>${ORDER.map((k) => { const a = ACT[k]; return `<tr><td>${a.act}</td><td><span class="sw1" style="background:${CLAROS[a.claro]}"></span>${NOMBRE[a.claro]} <code>${CLAROS[a.claro]}</code></td><td><span class="sw1" style="background:${PROFUNDOS[a.prof]}"></span>${NOMBRE[a.prof]} <code>${PROFUNDOS[a.prof]}</code></td><td>${a.why}</td></tr>`; }).join('')}</tbody></table>`;

// Cuándo va color
const NIVELES = [
  ['Calma', 'Nivel 0 · Preparar', appPreparar(), `<b>Escribir, elegir, revisar.</b> Papel y tinta; el azul marca dónde escribes. Solo la idea elegida toma su claro: ${PCT.calma} de la pantalla.`],
  ['Presencia', 'Nivel 1 · Inicio', appInicio(), `<b>Tu actividad está en curso.</b> La tarjeta es blanca y la foto, gris. Su color queda en dos detalles, el estado y los minutos: ${PCT.presencia} de la pantalla.`],
  ['Señal', 'Nivel 2 · La señal', appSenal(), `<b>Es el momento de volver.</b> El único momento en que el color llena la pantalla (${PCT.senal}).`],
];
const niveles = NIVELES.map(([t, sub, phone, txt]) => `<div class="lv"><div class="lv-h"><b>${t}</b><span>${sub}</span></div>${phone}<p>${txt}</p></div>`).join('\n');
const sws = (cs) => `<div class="sws">${cs.map((c) => `<i style="background:${c}" title="${c}"></i>`).join('')}</div>`;
const ROLES = [
  ['Neutros', NEUTROS, 'papel, blanco, tinta, grafito y línea', 'Aquí se lee y se decide.', 'Casi todo: la app, la memoria, las láminas y la mayoría de las piezas.', 'Son la base.'],
  ['Sistema', [BLUE], 'el azul de Relevo', 'Aquí estás, aquí escribes.', 'El campo con foco, la pestaña activa, lo seleccionado, los enlaces y el ícono de la app.', 'Fondos grandes y actividades.'],
  ['Marca', [BLUE, PAPER], 'azul y papel', 'Habla Relevo.', 'La pieza clave de una serie, la tarjeta de bolsillo y el ícono.', 'Junto a los colores de actividad.'],
  ['Actividad', [...Object.values(CLAROS), ...Object.values(PROFUNDOS)], 'seis claros y cuatro profundos', 'Es la actividad de alguien.', 'La idea elegida, dos detalles de la tarjeta activa, la señal y las piezas de color de esa actividad.', 'Botones, estados, adornos y más de una pareja por pieza.'],
  ['Estado', [ERROR], 'rojo de error', 'Algo salió mal o no se puede deshacer.', 'Errores y «Borrar», siempre con ícono y texto.', 'Actividades y adornos.'],
];
const roles = `<table class="roles-t"><colgroup><col class="c1"><col class="c2"><col class="c3"><col class="c4"></colgroup><thead><tr><th>Papel</th><th>Qué dice</th><th>Dónde va</th><th>Dónde no</th></tr></thead><tbody>${ROLES.map(([n, cs, what, says, si, no]) => `<tr><td>${n}<span class="lv-h"><span>${what}</span></span>${sws(cs)}</td><td class="qd">«${says}»</td><td>${si}</td><td>${no}</td></tr>`).join('')}</tbody></table>`;
const pp = (cs) => `<span class="pp">${cs.map((c) => `<i style="background:${c}"></i>`).join('')}</span>`;
const CAMBIOS = [
  [`<span class="chg-l">${wmViejo()}</span>`, `<span class="chg-l">${logo()}</span>`, '<b>Logotipo.</b> De Schibsted Grotesk con un renglón debajo a Familjen Grotesk con el traspaso: el gancho de la «l» toca la «e».'],
  [pp(['#3B2416', '#FFC94D', '#1E1B5C', '#FF8636', '#4C1D95', '#FF9FD8']), pp([PROFUNDOS.violeta, CLAROS.sol, PROFUNDOS.petroleo, CLAROS.naranja, PROFUNDOS.violeta, CLAROS.rosa]), '<b>Color.</b> Los pares de la 3.4 tenían luces distintas y no siempre combinaban entre sí. Ahora todos los claros tienen la misma luz y todos los profundos también, así que cualquiera combina con cualquiera.'],
  [pp([BLUE, '#D8FF4A']), pp([BLUE, PAPER]), '<b>Marca.</b> El azul con lima pasa a azul con papel. Un color menos.'],
  ['<span class="chg-t">13 de 19</span>', '<span class="chg-t">5 de 19</span>', '<b>Piezas en color pleno.</b> En la 3.4 iban en color pleno 13 de las 19 piezas. Ahora van 5: el primer dato, dos afiches, la tarjeta y la señal.'],
];
const cambios = CAMBIOS.map(([a, b, txt]) => `<li><span class="chg">${a}<span class="arr">→</span>${b}</span><span>${txt}</span></li>`).join('\n');

const RAE = [
  ['relevo', 'acepción 3', 'En una carrera por equipos, cuando un corredor reemplaza a otro al recibir de él el testigo.', 'https://dle.rae.es/relevo', 'Relevo es ese momento: el teléfono le pasa el testigo a lo que querías hacer.'],
  ['testigo', 'acepción 12', 'En las carreras de relevos, el objeto que los corredores se intercambian en el lugar marcado.', 'https://dle.rae.es/testigo', 'En el proyecto, el objeto se llama testigo y queda en el lugar marcado: donde empieza la actividad.'],
  ['testigo', 'acepción 11', 'Una señal de aviso en un tablero de instrumentos.', 'https://dle.rae.es/testigo', 'La misma palabra nombra la señal: el aviso que te devuelve a la actividad.'],
];
const rae = RAE.map(([w, a, d, url, take]) => `<article class="ref"><span class="rwhat">${a}</span><h3><a href="${url}">${w}</a></h3><p>${d}</p><p class="take">${take}</p></article>`).join('');
const REFS = [
  ['Real Academia Española y ASALE', 'Diccionario de la lengua española', 'Las acepciones de relevo y testigo que dan la idea del traspaso.', 'https://dle.rae.es/testigo', 'el traspaso reemplaza al subrayado como idea de la marca.'],
  ['Pentagram (Michael Bierut)', 'Mastercard, 2016', 'Dejó un solo gesto, los dos círculos que se cruzan, y eligió una letra minúscula, FF Mark, porque su geometría circular repetía la del símbolo.', 'https://www.creativereview.co.uk/new-mastercard-logo-pentagram/', 'un solo gesto en el logotipo y una letra elegida porque permite ese gesto.'],
  ['Familjen STHLM', 'Familjen Grotesk, 2022', 'Grotesca para texto y titulares, con trampas de tinta, altura de x grande y licencia libre (OFL).', 'https://fonts.google.com/specimen/Familjen+Grotesk', 'el logotipo; la «l» con gancho hace posible el traspaso.'],
  ['Google, Material Design', 'Material Color Utilities y HCT', 'Arma sus paletas en un espacio de color en que el tono es la luz percibida: con el mismo tono, cualquier color da el mismo contraste. También armoniza colores entre sí.', 'https://github.com/material-foundation/material-color-utilities', 'misma luz para todos los claros y para todos los profundos, así que todo combina con todo.'],
  ['Apple', 'Human Interface Guidelines: Color', 'Pide usar el color con criterio y no darle dos significados al mismo color.', 'https://developer.apple.com/design/human-interface-guidelines/color', 'papel y tinta por defecto; el color, solo cuando dice algo.'],
  ['Wolfe y Horowitz', 'Nature Human Behaviour, 2017', 'Un objetivo se encuentra rápido cuando se distingue de lo que lo rodea.', 'https://doi.org/10.1038/s41562-017-0058', 'si casi todo está en calma, la señal se nota.'],
];
const refs = REFS.map(([who, what, saw, url, take]) => `<article class="ref"><span class="rwhat">${what}</span><h3><a href="${url}">${who}</a></h3><p>${saw}</p><p class="take">${take}</p></article>`).join('');

// Ensambla: cabeza y estilos de la 3.4 (duo/plantilla.html), estilos nuevos y cuerpo nuevo.
const base = fs.readFileSync(path.join(__dirname, '..', 'duo', 'plantilla.html'), 'utf8');
const i = base.indexOf('<div class="wrap">'), j = base.indexOf('<script>');
let head = base.slice(0, i).replace('<title>Las ganas estaban</title>', '<title>El traspaso</title>')
  .replace(/<link rel="stylesheet" href="https:\/\/fonts\.googleapis\.com[^"]*">/, '<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Familjen+Grotesk:wght@400..700&family=Schibsted+Grotesk:wght@400..900&family=IBM+Plex+Mono:wght@400&family=Bricolage+Grotesque:opsz,wght@12..96,700&family=Funnel+Display:wght@700&family=Syne:wght@700&family=Gabarito:wght@700&display=swap">')
  .replace('</style>', fs.readFileSync(path.join(__dirname, 'extra.css'), 'utf8') + '\n</style>');
const T = head + fs.readFileSync(path.join(__dirname, 'cuerpo.html'), 'utf8') + '\n' + base.slice(j);
let html = T.replace('{{WORD}}', G.wordPath).replace('{{FILTROS}}', FILTROS).replace('{{WMTOP}}', logo())
  .replace('{{FOTOS}}', FOTOS)
  .replace('{{HEROLOGO}}', logo()).replace('{{LOGOS}}', [[PAPER, INK, 'Tinta sobre papel'], [INK, PAPER, 'Papel sobre tinta'], [BLUE, PAPER, 'Papel sobre azul']].map(([bg, fg, n]) => `<figure class="lvar" style="background:${bg};color:${fg}">${logo()}<figcaption>${n}</figcaption></figure>`).join(''))
  .replace('{{SIZES}}', [64, 32, 20, 16].map((s) => `<span class="sz"><span style="font-size:${s}px">${logo()}</span><small>${s} px</small></span>`).join(''))
  .replace('{{FUENTES}}', fuentes).replace('{{RAE}}', rae).replace('{{MATRIZ}}', matriz)
  .replace('{{CLAROS}}', chord(CLAROS)).replace('{{PROFUNDOS}}', chord(PROFUNDOS)).replace('{{EJEMPLOS}}', ejemplos).replace('{{ACTTABLA}}', actTabla)
  .replace('{{MINMX}}', minMx.toFixed(1).replace('.', ',')).replace('{{MINMXSIM}}', minMxSim.toFixed(1).replace('.', ','))
  .replace('{{AZULCLARO}}', Math.min(...Object.values(CLAROS).map((c) => contrast(BLUE, c))).toFixed(1).replace('.', ',')).replace('{{AZULPAPEL}}', cr(BLUE, PAPER))
  .replace('{{NIVELES}}', niveles).replace('{{ROLES}}', roles).replace('{{CAMBIOS}}', cambios).replace('{{REFS}}', refs)
  .replace('{{DATOS}}', DATOS.map((d) => dato(d)).join('\n'))
  .replace('{{AFICHES}}', ORDER.map((k) => afiche(k)).join('\n'))
  .replace('{{HISTORIA}}', historia()).replace('{{TARJETA}}', tarjeta()).replace('{{LAMINAS}}', laminas())
  .replace(/\{\{INK\}\}/g, INK).replace(/\{\{BLUE\}\}/g, BLUE).replace(/\{\{PAPER\}\}/g, PAPER);
const borrador = process.argv.includes('--borrador');
const quedan = html.match(/\{\{[A-Z_]+\}\}/g) || [];
if (quedan.some((m) => !m.startsWith('{{PCT_')) || (!borrador && quedan.length)) throw new Error('Quedó un marcador: ' + quedan.join(' '));
fs.writeFileSync(path.join(__dirname, 'el-traspaso.html'), html);
fs.writeFileSync(path.join(__dirname, 'vista.html'), '<meta charset="utf-8">\n' + html);
console.log('matriz profundo/claro: min', minMx.toFixed(2), '· con visión simulada', minMxSim.toFixed(2), '· azul/claros', Math.min(...Object.values(CLAROS).map((c) => contrast(BLUE, c))).toFixed(2), '· azul/papel', contrast(BLUE, PAPER).toFixed(2));
console.log('ok', Math.round(html.length / 1024) + ' KB', borrador ? '(borrador)' : '');
