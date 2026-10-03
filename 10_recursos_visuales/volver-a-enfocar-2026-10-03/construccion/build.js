// «Volver a enfocar» (propuesta 3.3): la actividad fuera de foco en su color vivo y, nítidas encima,
// la frase de Relevo y las palabras de la persona sobre el renglón. Escribe enfoque/volver-a-enfocar.html.
const fs = require('fs');
const path = require('path');
const P = require('../vivo/palette-vivo.json');
const G = require('../out/logo-geometry.json');
const { icon } = require('../apps-lib.js');
const INK = P.base.INK, BLUE = P.base.BLUE, PAPER = P.base.PAPER;
const C = P.cats;
const ORDER = ['leer', 'moverme', 'crear', 'cuidar', 'aprender', 'compartir'];
// Foto del lugar donde empieza cada actividad (CC0 o generada con IA, ver documento 30) y la idea de la app (documento 23).
const A = {
  leer: { foto: 'foto_libro', word: 'leer', act: 'Leer', first: 'Abrir el libro', where: 'En el velador', icon: 'leer' },
  moverme: { foto: 'foto_caminar', word: 'salir a caminar', act: 'Salir a caminar', first: 'Ponerte las zapatillas', where: 'Junto a la puerta', icon: 'caminar' },
  crear: { foto: 'foto_pintar', word: 'pintar', act: 'Pintar', first: 'Preparar las acuarelas', where: 'En la mesa', icon: 'pintar' },
  cuidar: { foto: 'foto_perro', word: 'pasear al perro', act: 'Pasear al perro', first: 'Tomar la correa', where: 'Junto a la correa', icon: 'huella' },
  aprender: { foto: 'foto_aprender', word: 'estudiar', act: 'Estudiar', first: 'Abrir tus apuntes', where: 'En el escritorio', icon: 'estudiar' },
  compartir: { foto: 'foto_escribir', word: 'escribirle a alguien', act: 'Escribirle a alguien a mano', first: 'Sacar papel y lápiz', where: 'En el escritorio', icon: 'carta' },
};
const uri = (f) => 'data:image/jpeg;base64,' + fs.readFileSync(path.join(__dirname, 'fotos', f + '-g.jpg')).toString('base64');
const ic = (n, size = 18) => icon(n, { size, color: 'currentColor', accent: 'currentColor' });
const wm = (cls = '') => `<svg class="wm ${cls}" viewBox="0 -1500 6929.5 1840" role="img" aria-label="relevo"><rect class="wl" x="0" y="180" width="6929.5" height="160" rx="80"/><use class="ww" href="#wm-word"/></svg>`;
const luz = (cat) => `<div class="luz" aria-hidden="true" style="--c:${C[cat].campo.hex};--f:var(--foto-${cat})"><i></i><b></b></div>`;
const FOTOS = ORDER.map((k) => `--foto-${k}: url(${uri(A[k].foto)});`).join(' ');
const EXPLICA = 'Relevo te recuerda lo que querías hacer mientras todavía puedes hacerlo, en el lugar donde lo empiezas.';

const poster = (cat, id) => { const a = A[cat]; return `<figure class="poster" id="${id || 'afiche-' + cat}">${luz(cat)}<div class="pi">
  <span class="ptag">${ic(a.icon, 16)}${C[cat].name}</span>
  <div class="pmid"><div class="phead">Vuelve a</div><div class="pline"><span class="pvoz fit" data-max="0.9">${a.word}<span class="pdot">.</span></span></div></div>
  <div class="pfoot">${wm()}<span>${a.first}<br>${a.where}</span></div>
</div></figure>`; };

const statusBar = (light) => `<div class="sb${light ? ' on-luz' : ''}"><span>21:42</span><span class="sbi"><i></i><i></i><i></i></span></div>`;
const tabbar = () => `<nav class="tabs"><span class="on">${ic('inicio-lleno', 22)}<b>Inicio</b></span><span>${ic('ruta', 22)}<b>Ruta</b></span><span>${ic('perfil', 22)}<b>Perfil</b></span></nav>`;
const appInicio = () => `<figure class="phone" id="app-inicio">${statusBar()}<div class="scr">
  <div class="abar">${wm()}<span class="ava">${ic('perfil', 20)}</span></div>
  <h3 class="stitle">Hola.</h3>
  <div class="active">${luz('leer')}<div class="ain">
    <div class="arow"><span class="chip">${ic('leer', 15)}Leer</span><span class="chip ink">Contando</span></div>
    <div class="ahead">Vuelve a</div>
    <div class="aline"><span class="avoz fit" data-max="0.92">leer 10 páginas<span>.</span></span></div>
    <div class="dots15">${'<i></i>'.repeat(6)}${'<i class="off"></i>'.repeat(9)}</div>
    <div class="atime"><b>6 min</b> de 15 en tus apps</div>
  </div></div>
  <div class="facts">
    <div>${ic('primer-paso', 20)}<span>Cómo empiezas</span><span class="fv">Abrir el libro</span></div>
    <div>${ic('lugar', 20)}<span>Dónde</span><span class="fv">En el velador</span></div>
  </div>
</div>${tabbar()}</figure>`;
const appPreparar = () => `<figure class="phone" id="app-preparar">${statusBar()}<div class="scr">
  <div class="steps"><i class="on"></i><i></i><i></i><i></i><i></i></div>
  <h3 class="qtitle">¿Qué quieres hacer?</h3>
  <label class="field"><span>Actividad</span><span class="fieldv">leer 10 páginas</span></label>
  <p class="eyebrow">Ideas</p>
  <div class="ideas">${ORDER.map((k) => `<span class="tag" style="--suave:${C[k].suave.hex};--tinta:${C[k].tinta.hex}">${ic(A[k].icon, 16)}${A[k].act}</span>`).join('')}</div>
  <div class="btn">Seguir</div>
</div></figure>`;
const appSenal = () => `<figure class="phone senal" id="app-senal">${luz('leer')}${statusBar(true)}<div class="scr">
  <div class="sgtop">${wm()}<span class="chip ink">${ic('parlante', 15)}Suena en el parlante</span></div>
  <div class="sghead">Vuelve a</div>
  <div class="sgline"><span class="sgvoz fit" data-max="0.92">leer 10 páginas<span>.</span></span></div>
  <p class="sgsub">Abrir el libro · En el velador</p>
  <div class="btn">Silenciar y continuar</div>
</div></figure>`;
const historia = () => `<figure class="story" id="historia">${luz('crear')}<div class="pi">
  ${wm()}<div class="sthead">Vuelve a</div><div class="stline"></div><p>Escribe sobre el renglón lo que quieres hacer.</p>
</div></figure>`;
const tarjeta = () => `<div class="cards"><figure class="pcard" id="tarjeta-frente">${luz('aprender')}<div class="pi">${wm()}<div class="pchead">Vuelve a</div><div class="pcline"></div></div></figure>
<figure class="pcard paper" id="tarjeta-reverso"><div class="pi"><p>Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad que quieres tener presente y, cuando se cumple la condición que elegiste, emite una señal breve. Tú decides qué hacer después.</p>${wm()}</div></figure></div>`;
const laminas = () => `<figure class="slide" id="lamina"><div class="pi">
  <div class="sltop"><span>Problema</span><span>04</span></div>
  <h3>Algunas sesiones de ocio digital se prolongan sin que la persona <span class="rg">vuelva a decidir</span> si quiere continuar.</h3>
  <span class="slsrc">Memoria, resumen</span>
</div></figure>
<figure class="slide luzs" id="lamina-seccion">${luz('moverme')}<div class="pi">
  <div class="sltop"><span>Sección</span><span>03</span></div>
  <h3 class="big">Planteamiento del problema</h3>
  ${wm()}
</div></figure>`;
const swatches = `<div class="sw-blue"><div class="big" style="background:${BLUE};color:#fff"><b>Azul Relevo</b><span>${BLUE}</span></div><p>El sistema: logotipo, renglón, tiempo y dónde estás.</p></div>
${ORDER.map((k) => { const c = C[k]; return `<div><div class="big luzbox">${luz(k)}<b>${c.name}</b><span>${c.campo.hex}</span></div>
<div class="sm" style="background:${c.tinta.hex};color:#fff"><span>tinta ${c.tinta.hex}</span></div>
<div class="sm" style="background:${c.suave.hex};color:${INK}"><span>${ic(A[k].icon, 14)}fondo suave ${c.suave.hex}</span></div></div>`; }).join('\n')}`;

const REFS_AUTOR = [
  ['Scribbit', 'Un paisaje luminoso arriba y la interfaz en tarjetas blancas, con mucho aire.', 'La app en blanco y la luz en un solo lugar.'],
  ['bird', 'Luz de colores que atraviesa fotos, titular en serif y el resto en gris.', 'La serif como voz tranquila; el color como luz, no como fondo plano.'],
  ['bloop', 'Un solo verde, fotos de árboles movidos y mucho blanco.', 'Un color por pieza; el movimiento de la foto como carácter.'],
  ['furion', 'Fotos en blanco y negro con movimiento y un logotipo con símbolo.', 'La foto desenfocada cuenta un instante; la marca queda nítida.'],
  ['Meristem', 'Flores desenfocadas en colores suaves, letra liviana y líneas finas.', 'El desenfoque de algo real se ve natural, no sintético.'],
  ['Wanderly', 'Titular en serif liviana y tarjetas con un halo de color detrás de cada imagen.', 'Cada tarjeta, su color; el texto siempre afuera, sobre blanco.'],
];
const refsAutor = REFS_AUTOR.map(([n, saw, take]) => `<article class="ref"><h3>${n}</h3><p>${saw}</p><p class="take">${take}</p></article>`).join('');
const REFS_D = [
  ['Rose Pilkington', 'Instagram, 2022', 'Hizo el degradado de Instagram «iluminado desde dentro», a partir de una paleta de cinco colores vivos; su trabajo parte de texturas de la naturaleza.', 'https://www.meta.com/design-at-meta/blog/behind-instagrams-brand-evolution-movement-inclusivity-and-a-new-purpose/', 'El color de la casa como luz que sale de la foto.'],
  ['Brent David Freaney (Special Offer, Inc.)', 'brat, 2024', 'Una palabra sobre un verde, probado entre unos 500 tonos, y una letra desenfocada. Ganó el Grammy al mejor diseño de empaque en 2025.', 'https://itsnicethat.com/articles/special-offer-graphic-design-project-141124', 'Un color y una frase alcanzan para una identidad.'],
  ['Pentagram', 'Atlantic Theater Company, temporada 2022-2023', 'Imágenes con los bordes desenfocados para cada obra, con la «A» del teatro como forma fija.', 'https://pentagram.com/work/atlantic-theater-2022-2023-season/story', 'El desenfoque como lenguaje de una serie, con una forma fija encima: aquí, el renglón.'],
  ['Production Type (Hugues Gentile y Jean-Baptiste Levée)', 'Newsreader, 2020-2021', 'Serif con tamaños ópticos, encargada por Google Fonts para leer en pantalla; preseleccionada en los premios D&AD 2021.', 'https://www.productiontype.com/news/new_fonts_from_production_type_newsreader', 'La voz de Relevo y, en itálica, la de la persona.'],
  ['Bakken & Bæck (Henrik Kongsvoll)', 'Schibsted Grotesk', 'Grotesca pensada primero para interfaces digitales, con licencia libre.', 'https://github.com/schibsted/schibsted-grotesk', 'La interfaz y el logotipo, sin cambios.'],
];
const refsD = REFS_D.map(([who, what, saw, url, take]) => `<article class="ref"><span class="rwhat">${what}</span><h3><a href="${url}">${who}</a></h3><p>${saw}</p><p class="take">${take}</p></article>`).join('');

const T = fs.readFileSync(path.join(__dirname, 'plantilla.html'), 'utf8');
let html = T.replace('{{WORD}}', G.wordPath).replace('{{WMTOP}}', wm())
  .replace('{{HERO}}', poster('leer', 'afiche-portada'))
  .replace('{{REFSAUTOR}}', refsAutor).replace('{{REFSD}}', refsD)
  .replace('{{SWATCHES}}', swatches).replace('{{FOTOS}}', FOTOS)
  .replace('{{POSTERS}}', ORDER.map((k) => poster(k)).join('\n'))
  .replace('{{APP}}', appInicio() + appPreparar() + appSenal())
  .replace('{{HISTORIA}}', historia()).replace('{{TARJETA}}', tarjeta()).replace('{{LAMINAS}}', laminas())
  .replace(/\{\{INK\}\}/g, INK).replace(/\{\{BLUE\}\}/g, BLUE).replace(/\{\{PAPER\}\}/g, PAPER);
if (/\{\{[A-Z]+\}\}/.test(html)) throw new Error('Quedó un marcador: ' + html.match(/\{\{[A-Z]+\}\}/)[0]);
fs.writeFileSync(path.join(__dirname, 'volver-a-enfocar.html'), html);
console.log('ok', Math.round(html.length / 1024) + ' KB');
