// «Las ganas estaban» (propuesta 3.4, versión 2): cada pieza dice algo que sabemos, y cada color tiene un papel
// y un momento. Escribe duo/las-ganas-estaban.html (para publicar) y duo/vista.html (copia local con charset).
const fs = require('fs');
const path = require('path');
const { contrast } = require('../color-lib.js');
const P = require('../vivo/palette-vivo.json');
const G = require('../out/logo-geometry.json');
const { icon } = require('../apps-lib.js');
const INK = P.base.INK, BLUE = P.base.BLUE, PAPER = P.base.PAPER;
const ERROR = '#B3261E';
const NEUTROS = ['#FAFAF7', '#FFFFFF', INK, '#5B5F68', '#E4E4DF'];

// Pares: d, el color profundo; l, el vivo. El de la marca es solo de Relevo; los otros seis salen de la
// actividad de su foto. Ninguno usa el azul del sistema ni el rojo de error. g: curva para fotos claras.
const PARES = {
  marca: { g: 1, d: BLUE, l: '#D8FF4A', name: 'Azul y lima', from: 'El azul de Relevo con un lima de tono casi opuesto.' },
  cafe: { g: 1.3, d: '#3B2416', l: '#FFC94D', name: 'Café y sol', act: 'Leer', foto: 'libro', from: 'La luz de la lámpara sobre la madera del velador.' },
  noche: { g: 1.9, d: '#1E1B5C', l: '#FF8636', name: 'Noche y naranja', act: 'Salir a caminar', foto: 'caminar', from: 'El cielo y el atardecer cuando sales a caminar.' },
  violeta: { g: 1, d: '#4C1D95', l: '#FF9FD8', name: 'Violeta y rosa', act: 'Pintar', foto: 'pintar', from: 'Dos pigmentos vecinos en la caja de acuarelas.' },
  bosque: { g: 1.1, d: '#0B5D3B', l: '#8CFFB9', name: 'Bosque y menta', act: 'Pasear al perro', foto: 'perro', from: 'Las hojas y el pasto del paseo con el perro.' },
  petroleo: { g: 1.7, d: '#0B4A55', l: '#9EDCFF', name: 'Petróleo y celeste', act: 'Estudiar', foto: 'aprender', from: 'La tinta de la pluma y los renglones celestes del cuaderno.' },
  vino: { g: 1.25, d: '#7D1838', l: '#FFE1E8', name: 'Vino y rosa pálido', act: 'Escribirle a alguien a mano', foto: 'escribir', from: 'El lacre de un sobre y el papel de una carta.' },
};
// Objetos y lugares de las ideas de la app (documento 23).
const A = [
  { k: 'leer', par: 'cafe', foto: 'libro', head: 'El libro sigue en el velador.' },
  { k: 'moverme', par: 'noche', foto: 'caminar', head: 'Las zapatillas siguen junto a la puerta.' },
  { k: 'crear', par: 'violeta', foto: 'pintar', head: 'Las acuarelas siguen en la mesa.' },
  { k: 'cuidar', par: 'bosque', foto: 'perro', head: 'La correa sigue donde la dejaste.' },
  { k: 'aprender', par: 'petroleo', foto: 'aprender', head: 'Los apuntes siguen en el escritorio.' },
  { k: 'compartir', par: 'vino', foto: 'escribir', head: 'La carta sigue a medias.' },
];
const SUPPORT = 'Relevo suena ahí cuando sumas el tiempo que elegiste en tus apps.';
// Cifras de la encuesta de 53 respuestas (03_usuarios/encuesta-53-respuestas-2026-09.md). Habla Relevo: par de la marca.
const DATOS = [
  { id: 'dato-ganas', par: 'marca', head: 'Las ganas estaban.', n: '43', de: 'de 47', cap: 'personas querían hacer otra cosa mientras seguían en el teléfono.', pie: 'Relevo te recuerda esa otra cosa donde empieza.' },
  { id: 'dato-casa', par: 'marca', inv: true, head: 'Pasa donde están tus cosas.', n: '44', de: 'de 47', cap: 'estaban en casa cuando siguieron en el teléfono más de lo que querían.', pie: 'Relevo se queda ahí, junto a lo que querías hacer.' },
  { id: 'dato-paso', par: 'marca', head: 'Sabes por dónde empezar.', n: '42', de: 'de 43', cap: 'nombraron el primer paso de lo que querían hacer.', pie: 'Relevo te lo muestra cuando suena.' },
];
const SRC = 'Encuesta en línea, 53 respuestas, no representativa.';
// Color de actividad medido en cada pantalla (duo/medir.js), en % del área del teléfono.
const PCT = { calma: '0,7 %', presencia: '35 %', senal: '100 %' };

const rgb = (h) => [1, 3, 5].map((i) => parseInt(h.slice(i, i + 2), 16) / 255);
const FILTROS = Object.entries(PARES).map(([k, p]) => {
  const D = rgb(p.d), L = rgb(p.l), t = (i) => `${D[i].toFixed(4)} ${L[i].toFixed(4)}`;
  return `<filter id="duo-${k}" color-interpolation-filters="sRGB" x="0" y="0" width="100%" height="100%"><feColorMatrix type="saturate" values="0"/><feComponentTransfer>${['R', 'G', 'B'].map((c) => `<feFunc${c} type="gamma" amplitude="1" exponent="${p.g}" offset="0"/>`).join('')}</feComponentTransfer><feComponentTransfer><feFuncR type="table" tableValues="${t(0)}"/><feFuncG type="table" tableValues="${t(1)}"/><feFuncB type="table" tableValues="${t(2)}"/></feComponentTransfer></filter>`;
}).join('');
const FOTOS = [...new Set(A.map((a) => a.foto))].map((f) => `--foto-${f}: url(data:image/jpeg;base64,${fs.readFileSync(path.join(__dirname, 'fotos', 'foto_' + f + '.jpg')).toString('base64')});`).join(' ');

const par = (k, inv) => (inv ? `--d:${PARES[k].l};--l:${PARES[k].d}` : `--d:${PARES[k].d};--l:${PARES[k].l}`);
const foto = (f, k) => `<div class="foto" aria-hidden="true"><i style="background-image:var(--foto-${f});filter:contrast(1.08) url(#duo-${k})"></i></div>`;
const wm = (cls = '') => `<svg class="wm ${cls}" viewBox="0 -1500 6929.5 1840" role="img" aria-label="relevo"><rect class="wl" x="0" y="180" width="6929.5" height="160" rx="80"/><use class="ww" href="#wm-word"/></svg>`;
const ic = (n, size = 18) => icon(n, { size, color: 'currentColor', accent: 'currentColor' });
const cr = (k) => contrast(PARES[k].d, PARES[k].l).toFixed(1).replace('.', ',');

const afiche = (a, id) => `<figure class="afiche" id="${id || 'afiche-' + a.k}" style="${par(a.par)}">${foto(a.foto, a.par)}<div class="tx"><h3>${a.head}</h3><p>${SUPPORT}</p>${wm('mono')}</div></figure>`;
const dato = (d, id, k = d.par, inv = d.inv) => `<figure class="dato" id="${id || d.id}" style="${par(k, inv)}"><div class="pi"><h3>${d.head}</h3><div class="num"><b>${d.n}</b><span>${d.de}</span></div><p class="cap2">${d.cap}</p><div class="pie">${wm('mono')}<p>${d.pie}</p></div><p class="src">${SRC}</p></div></figure>`;

const sb = () => '<div class="sb"><span>21:42</span><span class="sbi"><i></i><i></i><i></i></span></div>';
const tabs = () => `<nav class="tabs"><span class="on">${ic('inicio-lleno', 22)}<b>Inicio</b></span><span>${ic('ruta', 22)}<b>Ruta</b></span><span>${ic('perfil', 22)}<b>Perfil</b></span></nav>`;
const appInicio = () => `<figure class="phone" id="app-inicio">${sb()}<div class="scr">
  <div class="abar">${wm()}<span class="ava">${ic('perfil', 20)}</span></div>
  <h3 class="stitle">Hola.</h3>
  <div class="active" data-par style="${par('cafe')}">${foto('libro', 'cafe')}<div class="ain">
    <div class="arow"><span class="chip">Contando</span></div>
    <div class="ahead">Vuelve a</div>
    <div class="avoz">leer 10 páginas.</div>
    <div class="dots15">${'<i></i>'.repeat(6)}${'<i class="off"></i>'.repeat(9)}</div>
    <div class="atime"><b>6 min</b> de 15 en tus apps</div>
  </div></div>
  <div class="facts"><div>${ic('primer-paso', 20)}<span>Cómo empiezas</span><span class="fv">Abrir el libro</span></div><div>${ic('lugar', 20)}<span>Dónde</span><span class="fv">En el velador</span></div></div>
</div>${tabs()}</figure>`;
const IDEAS = [['leer', 'cafe', 'Leer'], ['caminar', 'noche', 'Salir a caminar'], ['pintar', 'violeta', 'Pintar'], ['huella', 'bosque', 'Pasear al perro'], ['estudiar', 'petroleo', 'Estudiar'], ['carta', 'vino', 'Escribirle a alguien a mano']];
// todas: así estaban en la versión 1 (seis colores a la vez); si no, neutras y solo la elegida en su par.
const ideas = (todas) => `<div class="ideas">${IDEAS.map(([i, k, t]) => `<span class="tag${todas || k === 'cafe' ? ' on' : ''}"${!todas && k === 'cafe' ? ' data-par' : ''} style="${par(k)}">${ic(i, 16)}${t}</span>`).join('')}</div>`;
const appPreparar = () => `<figure class="phone" id="app-preparar">${sb()}<div class="scr">
  <div class="steps"><i class="on"></i><i></i><i></i><i></i><i></i></div>
  <h3 class="qtitle">¿Qué quieres hacer?</h3>
  <label class="field"><span>Actividad</span><span class="fieldv">leer 10 páginas</span></label>
  <p class="peyebrow">Ideas</p>
  ${ideas(false)}
  <div class="btn">Seguir</div>
</div></figure>`;
const appSenal = () => `<figure class="phone senal" id="app-senal" data-par style="${par('cafe')}">${sb()}<div class="scr">
  <div class="sgtop">${wm('mono')}<span class="chip">${ic('parlante', 15)}Suena en el parlante</span></div>
  <div class="sghead">Vuelve a</div>
  <div class="sgvoz">leer 10 páginas.</div>
  <p class="sgsub">Abrir el libro · En el velador</p>
  ${foto('libro', 'cafe')}
  <div class="btn">Silenciar y continuar</div>
</div></figure>`;
const historia = () => `<figure class="story" id="historia" style="${par('violeta')}">${foto('pintar', 'violeta')}<div class="tx"><h3>¿Qué querías hacer hoy?</h3><div class="wl2"></div><p>Escríbelo sobre la línea.</p>${wm('mono')}</div></figure>`;
const tarjeta = () => `<div class="cards"><figure class="pcard par" id="tarjeta-frente" style="${par('marca')}"><div class="pi">${wm('mono')}<div class="vw"><b>Vuelve a</b><i></i></div></div></figure>
<figure class="pcard papel" id="tarjeta-reverso"><div class="pi"><p>Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad que quieres tener presente y, cuando se cumple la condición que elegiste, emite una señal breve. Tú decides qué hacer después.</p>${wm()}</div></figure></div>`;
const laminas = () => `<figure class="slide" id="lamina-dato"><div class="pi"><div class="sltop"><span>Lo que sabemos</span><span>05</span></div>
  <div class="sl-dato"><div class="n"><b>43</b><span>de 47</span></div><div><h3>Las ganas estaban.</h3><p>43 de 47 personas querían hacer otra cosa mientras seguían en el teléfono.</p><p class="src">${SRC}</p></div></div></div></figure>
<figure class="slide" id="lamina-mecanismo"><div class="pi"><div class="sltop"><span>Por qué funciona</span><span>06</span></div>
  <div class="sl-mec"><h3>Lo que querías hacer vuelve cuando algo te lo recuerda.</h3><p>Cuando estás absorto en otra cosa, una intención se recupera si aparece una señal ligada a ella. Relevo pone esa señal en el lugar donde empieza la actividad.</p><p class="src">McDaniel y Einstein (2000)</p></div></div></figure>
<figure class="slide" id="lamina-funciona"><div class="pi"><div class="sltop"><span>Cómo funciona</span><span>07</span></div>
  <ol class="sl-fun"><li>Escribes qué quieres hacer y cómo empieza.</li><li>Dejas el parlante donde empieza.</li><li>Suena ahí cuando sumas el tiempo que elegiste en tus apps.</li><li class="yo">Tú decides si empiezas o sigues en lo que estabas.</li></ol></div></figure>
<figure class="slide marca" id="lamina-seccion" style="${par('marca')}"><div class="pi"><div class="sltop"><span>Sección</span><span>03</span></div><h3>Vuelve a lo que querías hacer.</h3>${wm('mono')}</div></figure>`;

// Cuándo va color
const NIVELES = [
  ['Calma', 'Nivel 0 · Preparar', appPreparar(), `<b>Escribir, elegir, revisar.</b> Papel y tinta. El azul marca dónde escribes y dónde estás; el par aparece solo en la idea que eliges. Color de actividad: ${PCT.calma} de la pantalla.`],
  ['Presencia', 'Nivel 1 · Inicio', appInicio(), `<b>Tu actividad está en curso.</b> Su par ocupa una sola tarjeta y el resto queda en calma. Color de actividad: ${PCT.presencia} de la pantalla.`],
  ['Señal', 'Nivel 2 · La señal', appSenal(), `<b>Es el momento de volver.</b> El par llena la pantalla (${PCT.senal}). Los afiches, la historia y las portadas trabajan en este nivel, porque su tarea es hacerse notar.`],
];
const niveles = NIVELES.map(([t, sub, phone, txt]) => `<div class="lv"><div class="lv-h"><b>${t}</b><span>${sub}</span></div>${phone}<p>${txt}</p></div>`).join('\n');
const sws = (cs) => `<div class="sws">${cs.map((c) => `<i style="background:${c}" title="${c}"></i>`).join('')}</div>`;
const ACT = Object.keys(PARES).filter((k) => k !== 'marca');
const ROLES = [
  ['Neutros', NEUTROS, 'papel, blanco, tinta, grafito y línea', 'Aquí se lee y se decide.', 'El fondo y el texto de la app, la memoria, los formularios y las láminas de ideas.', 'Son la base: están en todo.'],
  ['Sistema', [BLUE], 'el azul de Relevo', 'Aquí estás, aquí escribes.', 'El logotipo, el campo con foco, la pestaña activa, lo seleccionado y los enlaces.', 'Fondos grandes, botones y actividades.'],
  ['Marca', [BLUE, PARES.marca.l], 'azul y lima', 'Habla Relevo.', 'Afiches de dato, portadas de sección, la tarjeta de bolsillo y el ícono de la app.', 'Dentro de la app, salvo el logotipo. Nunca por una actividad.'],
  ['Actividad', ACT.flatMap((k) => [PARES[k].d, PARES[k].l]), 'seis pares', 'Es la actividad de alguien.', 'Su tarjeta activa, su señal, su foto, su afiche y la idea elegida. En listas, un punto chico junto a su ícono y su nombre.', 'Botones, estados, adornos y dos pares grandes en la misma vista.'],
  ['Estado', [ERROR], 'rojo de error', 'Algo salió mal o no se puede deshacer.', 'Errores y «Borrar», siempre con ícono y texto.', 'Actividades y adornos.'],
];
const roles = `<table class="roles-t"><colgroup><col class="c1"><col class="c2"><col class="c3"><col class="c4"></colgroup><thead><tr><th>Papel</th><th>Qué dice</th><th>Dónde va</th><th>Dónde no</th></tr></thead><tbody>${ROLES.map(([n, cs, what, says, si, no]) => `<tr><td>${n}<span class="lv-h"><span>${what}</span></span>${sws(cs)}</td><td class="qd">«${says}»</td><td>${si}</td><td>${no}</td></tr>`).join('')}</tbody></table>`;
const mini = (todas) => `<div class="mini"><p class="peyebrow">Ideas</p>${ideas(todas)}<div class="btn">Seguir</div></div>`;
const antes = `<div class="cmp"><div class="cmp-row"><div><span class="tl">Antes</span>${mini(true)}</div><div><span class="tl">Ahora</span>${mini(false)}</div></div><p><b>Las ideas de Preparar.</b> Seis colores a la vez competían con «Seguir» y no decían nada que el ícono y el nombre no dijeran. Ahora van neutras y la que eliges toma su par, para confirmar la elección.</p></div>
<div class="cmp"><div class="cmp-row"><div><span class="tl">Antes</span>${dato(DATOS[1], 'cmp-dato-antes', 'violeta', false)}</div><div><span class="tl">Ahora</span>${dato(DATOS[1], 'cmp-dato-ahora')}</div></div><p><b>Los afiches de dato.</b> El dato de la casa no trata de pintar, pero llevaba el violeta de pintar. Ahora los datos llevan el par de la marca, porque habla Relevo.</p></div>`;
const pp = (d, l) => `<span class="pp"><i style="background:${d}"></i><i style="background:${l}"></i></span>`;
const CAMBIOS = [
  [[BLUE, '#D8FF4A'], 'cafe', '<b>Leer.</b> Usaba el par de la marca, así que un mismo color decía dos cosas. Ahora la marca es solo de Relevo y leer tiene su par: café y sol, la luz de la lámpara sobre el velador.'],
  [['#B71A29', '#FFE1E8'], 'vino', '<b>Escribirle a alguien.</b> Su rojo y el de error apenas se distinguían (ΔE de 1,9 en OKLab). Ahora es vino, el color del lacre, y el rojo queda para los errores.'],
  [['#0F4C81', '#9EDCFF'], 'petroleo', '<b>Estudiar.</b> Era azul y celeste, junto al azul del sistema. Ahora es petróleo y celeste.'],
];
const cambios = CAMBIOS.map(([[d0, l0], k, txt]) => `<li><span class="chg">${pp(d0, l0)}→${pp(PARES[k].d, PARES[k].l)}</span><span>${txt}</span></li>`).join('\n');
const APRENDI = [
  ['Apple', 'Human Interface Guidelines: Color', 'Pide usar el color con criterio, no darle dos significados al mismo color y no depender solo de él. Sobre el vidrio de iOS 26, poco color y en la acción principal.', 'https://developer.apple.com/design/human-interface-guidelines/color', 'un significado por color, y siempre con ícono o nombre.'],
  ['Google', 'Expressive Design: Google’s UX Research, 2025', '46 estudios con más de 18.000 personas. Con color, forma y tamaño puestos en lo importante, la gente encontró los elementos clave hasta cuatro veces más rápido, y las personas mayores tan rápido como las jóvenes.', 'https://design.google/library/expressive-material-design-google-research', 'el color va en lo único que importa en cada pantalla.'],
  ['Material Design 3', 'Color roles', 'Separa los colores de acento, que llevan la marca, de las superficies neutras y del color de error, y asigna cada uno a un tipo de elemento.', 'https://m3.material.io/styles/color/roles', 'cinco papeles: neutros, sistema, marca, actividad y estado.'],
  ['Wolfe y Horowitz', 'Nature Human Behaviour, 2017', 'La atención la guían rasgos como el color, y un objetivo se encuentra rápido cuando se distingue de lo que lo rodea.', 'https://doi.org/10.1038/s41562-017-0058', 'para que la señal se note, alrededor tiene que haber calma.'],
  ['W3C', 'WCAG 2.2, 2023', 'El color no puede ser el único medio para comunicar algo. El texto necesita 4,5:1 de contraste y los componentes, 3:1.', 'https://www.w3.org/TR/WCAG22/', 'ícono y nombre junto a cada color, y contrastes medidos.'],
];
const aprendi = APRENDI.map(([who, what, saw, url, take]) => `<article class="ref"><span class="rwhat">${what}</span><h3><a href="${url}">${who}</a></h3><p>${saw}</p><p class="take">${take}</p></article>`).join('');

const DICE = [
  ['Las ganas estaban.', 'Abajo: «Relevo te recuerda esa otra cosa donde empieza».', '<b>43 de 47</b> personas querían hacer otra cosa mientras seguían en el teléfono.', 'Encuesta en línea, 53 respuestas'],
  ['Pasa donde están tus cosas.', 'Abajo: «Relevo se queda ahí, junto a lo que querías hacer».', '<b>44 de 47</b> estaban en casa cuando siguieron en el teléfono más de lo que querían.', 'Encuesta en línea, 53 respuestas'],
  ['Sabes por dónde empezar.', 'Abajo: «Relevo te lo muestra cuando suena».', '<b>42 de 43</b> nombraron el primer paso de lo que querían hacer.', 'Encuesta en línea, 53 respuestas'],
  ['Lo que querías hacer vuelve cuando algo te lo recuerda.', 'Lámina «Por qué funciona».', 'Cuando estás absorto en otra cosa, una intención se recupera si aparece <b>una señal ligada a ella</b>.', 'McDaniel y Einstein (2000); hipótesis D-091'],
  ['El libro sigue en el velador.', 'Y los otros cinco objetos. Abajo: «Relevo suena ahí cuando sumas el tiempo que elegiste en tus apps».', 'Relevo guarda qué quieres hacer, cómo empieza y dónde, y <b>suena en ese lugar</b>.', 'App 2.18; ideas de actividades (documento 23)'],
];
const dice = DICE.map(([k, small, know, src]) => `<div class="say"><div class="k">${k}<small>${small}</small></div><p>${know}</p><p class="src">${src}</p></div>`).join('');
const pares = [`<div class="pair marca" style="${par('marca')}"><div class="logo-sw">${wm('mono')}</div><div class="a"><b>Aa</b><span>${BLUE}</span></div><div class="b"><b>Aa</b><span>${PARES.marca.l}</span></div><h3>Azul y lima · la marca</h3><p>${PARES.marca.from}</p><p class="cr">${cr('marca')}:1 · habla Relevo: datos, portadas, tarjeta e ícono</p></div>`]
  .concat(ACT.map((k) => { const p = PARES[k]; return `<div class="pair" style="${par(k)}">${foto(p.foto, k)}<div class="a"><b>Aa</b><span>${p.d}</span></div><div class="b"><b>Aa</b><span>${p.l}</span></div><h3>${p.name} · ${p.act.toLowerCase()}</h3><p>${p.from}</p><p class="cr">${cr(k)}:1 · solo con su actividad</p></div>`; })).join('\n');
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
let html = T.replace('{{WORD}}', G.wordPath).replace('{{FILTROS}}', FILTROS).replace('{{WMTOP}}', wm())
  .replace('{{FOTOS}}', FOTOS)
  .replace('{{HERO}}', dato(DATOS[0], 'portada-dato') + afiche(A[0], 'portada-afiche'))
  .replace('{{DICE}}', dice).replace('{{PARES}}', pares).replace('{{REFS}}', refs)
  .replace('{{NIVELES}}', niveles).replace('{{ROLES}}', roles).replace('{{ANTES}}', antes).replace('{{CAMBIOS}}', cambios).replace('{{APRENDI}}', aprendi)
  .replace('{{DATOS}}', DATOS.map((d) => dato(d)).join('\n'))
  .replace('{{AFICHES}}', A.map((a) => afiche(a)).join('\n'))
  .replace('{{HISTORIA}}', historia()).replace('{{TARJETA}}', tarjeta()).replace('{{LAMINAS}}', laminas())
  .replace(/\{\{INK\}\}/g, INK).replace(/\{\{BLUE\}\}/g, BLUE).replace(/\{\{PAPER\}\}/g, PAPER);
const borrador = process.argv.includes('--borrador');
const quedan = html.match(/\{\{[A-Z_]+\}\}/g) || [];
if (quedan.some((m) => !m.startsWith('{{PCT_')) || (!borrador && quedan.length)) throw new Error('Quedó un marcador: ' + quedan.join(' '));
if (/Newsreader|Georgia|Fraunces|Instrument Serif/.test(html)) throw new Error('Quedó una serif');
fs.writeFileSync(path.join(__dirname, 'las-ganas-estaban.html'), html);
// Copia local con charset para revisar y exportar fuera de claude.ai.
fs.writeFileSync(path.join(__dirname, 'vista.html'), '<meta charset="utf-8">\n' + html);
for (const k of Object.keys(PARES)) console.log(k.padEnd(9), cr(k));
console.log('ok', Math.round(html.length / 1024) + ' KB', borrador ? '(borrador)' : '');
