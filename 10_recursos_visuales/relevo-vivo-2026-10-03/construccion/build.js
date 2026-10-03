// «Relevo vivo» (propuesta 3.2): paleta viva, dos letras y las piezas armadas con una sola regla:
// un color, una frase, un renglón. Escribe vivo/relevo-vivo.html.
const fs = require('fs');
const path = require('path');
const P = require('./palette-vivo.json');
const G = require('../out/logo-geometry.json');
const { icon } = require('../apps-lib.js');
const INK = P.base.INK, BLUE = P.base.BLUE, PAPER = P.base.PAPER;
const C = P.cats;
const ORDER = ['leer', 'moverme', 'crear', 'cuidar', 'aprender', 'compartir'];
const ICON = { leer: 'leer', moverme: 'caminar', crear: 'pintar', cuidar: 'plantas', aprender: 'estudiar', compartir: 'juego-de-mesa' };
const WORD = { leer: 'leer', moverme: 'salir a caminar', crear: 'pintar', cuidar: 'regar las plantas', aprender: 'estudiar', compartir: 'jugar con alguien' };
const DATA = { leer: ['Leer', 'Abrir el libro', 'Junto al sillón'], moverme: ['Salir a caminar', 'Ponerte las zapatillas', 'Junto a la puerta'], crear: ['Pintar', 'Preparar las acuarelas', 'En la mesa'], cuidar: ['Cuidar las plantas', 'Llenar la regadera', 'Junto a las plantas'], aprender: ['Estudiar', 'Abrir tus apuntes', 'En el escritorio'], compartir: ['Jugar un juego de mesa', 'Sacar la caja', 'En la mesa'] };
const ic = (n, size = 18) => icon(n, { size, color: 'currentColor', accent: 'currentColor' });
const wm = (cls = '') => `<svg class="wm ${cls}" viewBox="0 -1500 6929.5 1840" role="img" aria-label="relevo"><rect class="wl" x="0" y="180" width="6929.5" height="160" rx="80"/><use class="ww" href="#wm-word"/></svg>`;
const EXPLICA = 'Relevo te recuerda lo que querías hacer mientras todavía puedes hacerlo, en el lugar donde lo empiezas.';

// ---------- Piezas ----------
const poster = (cat, id) => { const c = C[cat], d = DATA[cat]; return `<figure class="poster" id="${id || 'afiche-' + cat}" style="--campo:${c.campo.hex}"><div class="pi">
  <div class="ptop"><span>${c.name}</span></div>
  <div class="pmid"><div class="phead">Vuelve<br>a</div><div class="pline"><span class="hand fit" data-max="0.86">${WORD[cat]}</span></div></div>
  <div class="pbot"><p>${EXPLICA}</p><div class="pfoot">${wm()}<span>${d[1]}<br>${d[2]}</span></div></div>
</div></figure>`; };

const statusBar = '<div class="sb"><span>21:42</span><span class="sbi"><i></i><i></i><i></i></span></div>';
const tabbar = (sel) => `<nav class="tabs">${[['inicio', 'Inicio'], ['ruta', 'Ruta'], ['perfil', 'Perfil']].map(([n, l]) => `<span class="${n === sel ? 'on' : ''}">${ic(n === sel ? (n === 'ruta' ? 'ruta-llena' : n + '-lleno') : n, 22)}<b>${l}</b></span>`).join('')}</nav>`;
const appInicio = () => { const c = C.leer; return `<figure class="phone" id="app-inicio">${statusBar}<div class="scr">
  <div class="abar">${wm()}<span class="ava">${ic('perfil', 20)}</span></div>
  <p class="eyebrow">Ahora</p>
  <div class="active" style="--campo:${c.campo.hex}">
    <div class="arow"><span class="chip">${ic('leer', 16)}Leer</span><span class="chip ink">Contando</span></div>
    <div class="ahead">Vuelve a</div>
    <div class="aline"><span class="hand fit" data-max="0.92">leer 10 páginas</span></div>
    <div class="dots15">${'<i></i>'.repeat(6)}${'<i class="off"></i>'.repeat(9)}</div>
    <div class="atime"><b>6 min</b> de 15 en tus apps</div>
  </div>
  <div class="facts">
    <div>${ic('primer-paso', 20)}<span>Cómo empiezas</span><span class="hand sm">Abrir el libro</span></div>
    <div>${ic('lugar', 20)}<span>Dónde</span><span class="hand sm">Junto al sillón</span></div>
  </div>
</div>${tabbar('inicio')}</figure>`; };
const appPreparar = () => `<figure class="phone" id="app-preparar">${statusBar}<div class="scr">
  <div class="steps"><i class="on"></i><i></i><i></i><i></i><i></i></div>
  <h3 class="qtitle">¿Qué quieres hacer?</h3>
  <label class="field"><span>Actividad</span><span class="hand fieldv">leer 10 páginas</span></label>
  <p class="eyebrow">Ideas</p>
  <div class="ideas">${ORDER.map((k) => `<span class="tag" style="--suave:${C[k].suave.hex};--tinta:${C[k].tinta.hex}">${ic(ICON[k], 16)}${DATA[k][0]}</span>`).join('')}</div>
  <div class="btn">Seguir</div>
</div></figure>`;
const appSenal = () => { const c = C.leer; return `<figure class="phone senal" id="app-senal" style="--campo:${c.campo.hex}">${statusBar}<div class="scr">
  <div class="sgtop">${wm()}<span class="chip ink">${ic('parlante', 16)}Suena en el parlante</span></div>
  <div class="sghead">Vuelve<br>a</div>
  <div class="sgline"><span class="hand fit" data-max="0.9">leer 10 páginas</span></div>
  <p class="sgsub">Abrir el libro · Junto al sillón</p>
  <div class="btn">Silenciar y continuar</div>
</div></figure>`; };
const historia = () => { const c = C.crear; return `<figure class="story" id="historia" style="--campo:${c.campo.hex}"><div class="pi">
  ${wm()}
  <div class="sthead">Vuelve<br>a</div>
  <div class="stline"></div>
  <p>Escribe sobre el renglón lo que quieres hacer.</p>
</div></figure>`; };
const tarjeta = () => { const c = C.aprender; return `<div class="cards"><figure class="pcard" id="tarjeta-frente" style="--campo:${c.campo.hex}"><div class="pi">${wm()}<div class="pchead">Vuelve a</div><div class="pcline"></div></div></figure>
<figure class="pcard ink" id="tarjeta-reverso"><div class="pi"><p>Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad que quieres tener presente y, cuando se cumple la condición que elegiste, emite una señal breve. Tú decides qué hacer después.</p>${wm()}</div></figure></div>`; };
const lamina = () => `<figure class="slide" id="lamina"><div class="pi">
  <div class="sltop"><span>Problema</span><span>04</span></div>
  <h3>Algunas sesiones de ocio digital se prolongan sin que la persona <span class="rg">vuelva a decidir</span> si quiere continuar.</h3>
  <span class="slsrc">Memoria, resumen</span>
</div></figure>`;
const laminaColor = () => { const c = C.moverme; return `<figure class="slide campo" id="lamina-seccion" style="--campo:${c.campo.hex}"><div class="pi">
  <div class="sltop"><span>Sección</span><span>03</span></div>
  <h3 class="big">Planteamiento<br>del problema</h3>
  ${wm()}
</div></figure>`; };

// ---------- Color ----------
const swatches = `<div class="sw-blue"><div class="big" style="background:${BLUE};color:#fff"><b>Azul Relevo</b><span>${BLUE}</span></div><p>El sistema: logotipo, renglón, tiempo y dónde estás. Blanco encima: 6,8:1.</p></div>
${ORDER.map((k) => { const c = C[k]; return `<div class="sw-cat"><div class="big" style="background:${c.campo.hex};color:${INK}"><b>${c.name}</b><span>${c.campo.hex}</span></div>
<div class="sm" style="background:${c.tinta.hex};color:#fff"><span>tinta ${c.tinta.hex}</span></div>
<div class="sm" style="background:${c.suave.hex};color:${c.tinta.hex}"><span>${ic(ICON[k], 14)}fondo suave</span></div>
<p>${c.why}. Tinta sobre el campo: ${String(c.k.inkOnCampo).replace('.', ',')}:1. Su tinta sobre papel: ${String(c.k.tintaOnPaper).replace('.', ',')}:1.</p></div>`; }).join('\n')}`;

const T = fs.readFileSync(path.join(__dirname, 'plantilla.html'), 'utf8');
let html = T.replace('{{WORD}}', G.wordPath).replace('{{WMTOP}}', wm())
  .replace('{{HERO}}', poster('leer', 'afiche-portada'))
  .replace('{{SWATCHES}}', swatches)
  .replace('{{POSTERS}}', ORDER.map((k) => poster(k)).join('\n'))
  .replace('{{APP}}', appInicio() + appPreparar() + appSenal())
  .replace('{{HISTORIA}}', historia())
  .replace('{{TARJETA}}', tarjeta())
  .replace('{{LAMINAS}}', lamina() + laminaColor())
  .replace(/\{\{INK\}\}/g, INK).replace(/\{\{BLUE\}\}/g, BLUE).replace(/\{\{PAPER\}\}/g, PAPER)
  .replace('{{DIST}}', `${String(P.dist.protan.min).replace('.', ',')} con protanopía, ${String(P.dist.deutan.min).replace('.', ',')} con deuteranopía y ${String(P.dist.tritan.min).replace('.', ',')} con tritanopía`);
if (/\{\{[A-Z]+\}\}/.test(html)) throw new Error('Quedó un marcador: ' + html.match(/\{\{[A-Z]+\}\}/)[0]);
fs.writeFileSync(path.join(__dirname, 'relevo-vivo.html'), html);
console.log('ok', Math.round(html.length / 1024) + ' KB');
