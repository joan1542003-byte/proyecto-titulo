// Propuesta 3.8, «Letras que dicen relevo»: catorce fichas de lectura (qué se ve en cada letra y qué concepto de Relevo evoca).
// Escribe lamina/letras-que-dicen-relevo.html (para publicar) y lamina/vista.html (copia local con charset).
const fs = require('fs');
const path = require('path');
const datos = require('./fichas-datos.js');
const dir = __dirname;
const img = (f) => 'data:image/jpeg;base64,' + fs.readFileSync(path.join(dir, 'fichas', f)).toString('base64');
const anchos = Object.fromEntries(JSON.parse(fs.readFileSync(path.join(dir, 'fichas', 'anchos32.json'), 'utf8')).map((x) => [x.id, x.ancho32]));
const cob = Object.fromEntries(JSON.parse(fs.readFileSync(path.join(dir, 'cobertura.json'), 'utf8')).map((x) => [x.k, x]));

const LIC = {
  ofl: 'SIL Open Font License: libre, también para uso comercial.',
  fs: 'ITF Free Font License 2.0: gratis para uso personal y comercial; permite crear y registrar logotipos, pero no modificar ni redistribuir el archivo.',
  gpl: 'GNU/GPL, declarada para toda la colección en el sitio de Le75; el zip no trae el texto, así que habría que confirmarla antes de usar la letra en una marca.',
};
const LIC_NOTA = { westgate: ' Según la página de Republish; el zip no trae el texto.', patriot: ' Según la página de Republish; el zip no trae el texto.' };
const CONCEPTOS = [
  ['Testigo', 'El objeto que pasa de una mano a otra: el que se intercambia en el lugar marcado.', 'Trazos de ancho parejo, extremos redondos y una vertical que se destaca, como una cápsula.'],
  ['Traspaso', 'Dos partes que se encuentran: una entrega y la otra recibe.', 'Huecos, cortes y piezas que encajan; trazos que se alcanzan sin tocarse.'],
  ['Lugar', 'El sitio acordado donde ocurre el relevo, y el «hazle lugar».', 'Rótulos públicos, plantillas, placas y casillas; vacíos con forma de letra.'],
  ['Señal', 'El aviso breve que llega cuando se cumple la condición.', 'Puntos y rayas, líneas paralelas, rayos y ondas, luz de pantalla.'],
  ['Volver', '«Vuelve a lo que querías hacer».', 'Espirales, bucles y remates que giran hacia adentro.'],
  ['Calma', 'Lo cotidiano y la casa, sin reproche.', 'Curvas anchas, formas blandas y contraformas abiertas, sin ángulos agudos.'],
  ['Pausa', 'El tiempo en intervalos y pasos.', 'Cortes a ritmo regular, módulos que se repiten, peldaños.'],
];
const GRUPOS = [
  ['logotipo', 'Para el logotipo', 'Tienen minúsculas propias y los acentos del español, y no son letra a mano. Ouroboros, que es de familia serif, solo podría ir en el logotipo.'],
  ['señal', 'Para los momentos de señal', 'Dibujan una luz, un eco o una escalera. Sirven para una palabra grande o un aviso, y quedan fuera del texto corrido.'],
  ['cartel', 'Para carteles', 'Solo tienen mayúsculas (o son muy pesadas) y llevan ideas fuertes. Sirven para una pieza impresa o una portada, y quedan fuera del logotipo en minúsculas.'],
];
const esc = (s) => s.replace(/&/g, '&amp;').replace(/</g, '&lt;');
const chip = (c, n) => `<span class="cp s${n}" title="${n === 2 ? 'La evoca con claridad' : 'La evoca en parte'}">${c}${n === 2 ? '' : ' (en parte)'}</span>`;
const reglas = (d) => {
  const c = cob[d.k] || {};
  const acentos = !c.faltan ? '' : (c.faltan.length === 0 ? 'acentos completos' : (c.faltan.length >= 8 ? 'sin acentos' : 'faltan ' + c.faltan.filter((x) => x !== 'Ñ').join(' ')));
  const items = [
    c.minusculas ? '<span class="rg ok">minúsculas propias</span>' : '<span class="rg no">solo mayúsculas</span>',
    acentos.startsWith('acentos') ? `<span class="rg ok">${acentos}</span>` : `<span class="rg no">${acentos}</span>`,
    `<span class="rg">«relevo» mide ${anchos[d.id]} px a 32 px</span>`,
  ];
  return items.join('');
};
const card = (d) => {
  const cs = Object.entries(d.c).sort((a, b) => b[1] - a[1]);
  const nums = d.n.map((n, i) => `<li value="${i + 1}">${esc(n.t)}</li>`).join('');
  return `<article class="fcard" id="l-${d.id}" data-c="${Object.keys(d.c).join(' ')}">
<header><h3>${d.nombre}</h3><p class="meta">${d.autoria} · ${d.origen}</p></header>
<figure><img src="${img(d.id + '.jpg')}" alt="Lámina de lectura de ${d.nombre}: la palabra «relevo» grande, cada letra suelta con los números de las notas, y pruebas en azul, en tamaños de 32, 22 y 16 px, con la firma y como ícono"></figure>
<div class="txt">
<div><h4>Lo que se ve</h4><ol class="vi">${nums}</ol></div>
<div><h4>Qué evoca de Relevo</h4><p class="cps">${cs.map(([c, n]) => chip(c, n)).join('')}</p>
<h4>Cuidado</h4><p>${esc(d.cuidado)}</p>
<h4>Fuente y licencia</h4><p>${esc(d.fuente)} <span class="lic">${LIC[d.lic]}${LIC_NOTA[d.id] || ''}</span> <a href="${d.enlace}">Página de la letra</a>.</p>
<p class="rgs">${reglas(d)}</p></div>
</div></article>`;
};
const grupos = GRUPOS.map(([rol, t, desc]) => {
  const items = datos.filter((d) => d.rol === rol);
  return `<section class="grp" id="g-${rol}"><div class="head"><p class="eyebrow">${items.length} letras</p><h2>${t}</h2><p>${desc}</p></div>${items.map(card).join('\n')}</section>`;
}).join('\n');
const matriz = `<div class="tablewrap"><table class="mx"><thead><tr><th>Letra</th>${CONCEPTOS.map(([c]) => `<th>${c}</th>`).join('')}</tr></thead><tbody>${datos.map((d) => `<tr><td><a href="#l-${d.id}">${d.nombre}</a></td>${CONCEPTOS.map(([c]) => { const n = d.c[c] || 0; return `<td class="m${n}" aria-label="${c}: ${['no', 'en parte', 'con claridad'][n]}">${['', '◐', '●'][n]}</td>`; }).join('')}</tr>`).join('')}</tbody></table></div>`;
const lectura = `<div class="tablewrap"><table><thead><tr><th>Concepto</th><th>De dónde sale</th><th>Qué busco en las letras</th></tr></thead><tbody>${CONCEPTOS.map(([c, a, b]) => `<tr><td>${c}</td><td>${a}</td><td>${b}</td></tr>`).join('')}</tbody></table></div>`;

const FUERA = [
  ['A mano o caligráficas', 'Regla del autor: nada de letra escrita a mano.', [
    ['Ductus', 'Le75', 'Trazo de mano con bucles; faltan í, ó, ú, ñ, ¿ y ¡.'],
    ['Lacollective', 'Le75', 'Itálica de rotulista, solo mayúsculas; la «L» y la «R» se alargan hacia la letra siguiente, pero faltan acentos.'],
    ['Azabache', 'Tunera', 'Cursiva hecha de cuentas.'],
    ['League Script Number One', 'The League of Moveable Type', 'Cursiva de una sola línea continua.'],
  ]],
  ['Serif o con adorno', 'Regla «sin serif» de la propuesta 3.4.', [
    ['Zina, Stardom y Melodrama', 'Fontshare', 'Serif de contraste alto; Zina parte cada trazo con un filete.'],
    ['Chunk, Combat y Destra', 'The League of Moveable Type, Velvetyne, UNCUT', 'Egipcias y serif pesadas; a Combat le falta la ñ y a Destra, ú, ñ, ¿ y ¡.'],
    ['Basteleur', 'Velvetyne', 'Serif gruesa de aire medieval.'],
  ]],
  ['Se leen mal', 'La palabra «relevo» no se reconoce a primera vista.', [
    ['Sharpie', 'Fontshare', 'La «r» se lee como «n»: «nelevo».'],
    ['Kihim', 'Fontshare', 'Bloques muy inclinados: las letras se confunden entre sí.'],
    ['Lobular', 'Tunera', 'Letras hinchadas con cruces en las contraformas: la palabra se reconoce con esfuerzo; solo mayúsculas.'],
    ['Kohinoor Zerone', 'Fontshare', 'Mitades y astillas: cada letra queda rota.'],
    ['Mourier y Borges', 'Velvetyne, Collletttivo', 'Laberintos de líneas: funcionan como ornamento.'],
    ['Cambrian y Saint', 'UNCUT', 'Espinas y manchas; no tienen acentos.'],
    ['Granturismo y Styro', 'UNCUT, Fontshare', 'Letras superpuestas y muy condensadas.'],
    ['Phosphène y Stairs', 'UNCUT, Le75', 'Píxeles y peldaños diminutos: se leen con esfuerzo; Stairs no tiene acentos.'],
    ['NulTien', 'UNCUT', 'La «v» se lee como «l» con una diagonal; solo mayúsculas y sin acentos.'],
  ]],
  ['Curiosidades', 'Dicen algo, pero no para una casa.', [
    ['Ouvrières', 'Velvetyne', 'Cada letra es una fila de hormigas. El relevo se vuelve literal, porque cada una recoge lo que otra deja, pero la imagen no encaja en una casa.'],
    ['Typefesse', 'Velvetyne', 'Según su página, es una letra en forma de glúteos, que se lee a través de los pliegues del cuerpo.'],
    ['Kaeru Kaeru', 'Velvetyne', 'Según su página, mezcla las manchas de una rana venenosa con músculos de grabados japoneses.'],
    ['Revival', 'Le75', 'Collage de formas cortadas; no tiene acentos.'],
  ]],
  ['Casi', 'Buenas, pero no encajan como display.', [
    ['Gulax', 'Velvetyne', 'Sans geométrica de «e» con ranura y mucho carácter; es más una sans con carácter que un display.'],
    ['Chubbo', 'Fontshare', 'Egipcia blanda y cálida; ya estaba entre las finalistas de la 3.7.'],
    ['Acte', 'Le75', 'La «l» altísima de hilo fino se ve como un testigo en pie; faltan acentos y es muy fina.'],
    ['Spacenotoriousrounded', 'Le75', 'Píxel redondeado y legible; faltan ¿, ¡ y Ñ.'],
    ['Infini y Marion', 'Le75', 'Monolínea fina y solo mayúsculas; sin acentos.'],
    ['Segment, Array y Supernotoriousdot', 'Fontshare, Le75', 'Guiones y puntos; Segment solo tiene mayúsculas y Supernotoriousdot, tampoco acentos.'],
    ['Barber y Danhda', 'Republish', 'Barber es un rótulo en relieve de solo mayúsculas; a Danhda le falta la ñ.'],
  ]],
];
const fuera = FUERA.map(([t, d, items]) => `<div class="out"><h3>${t}</h3><p class="outd">${d}</p><div class="tablewrap"><table class="ot"><tbody>${items.map(([n, o, m]) => `<tr><td>${n}</td><td>${o}</td><td>${m}</td></tr>`).join('')}</tbody></table></div></div>`).join('');
const nFuera = FUERA.reduce((n, g) => n + g[2].length, 0);

const html = `<title>Letras que dicen relevo</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Schibsted+Grotesk:wght@400..900&family=IBM+Plex+Mono:wght@400&display=swap">
<style>
/* Una columna de lectura. La página es papel y tinta; el azul solo marca lo que se puede tocar y los conceptos fuertes. */
:root {
  --bg: #FAFAF7; --surface: #FFFFFF; --fg: #141519; --muted: #5B5F68; --line: #E4E4DF; --accent: #1C3891; --accent-bg: #E8ECF9; --on-accent: #FFFFFF; --ok: #1C6B3A; --no: #8A3B12;
  --f-ui: "Schibsted Grotesk", "Segoe UI", system-ui, sans-serif; --f-data: "IBM Plex Mono", ui-monospace, monospace;
}
@media (prefers-color-scheme: dark) { :root:not([data-theme="light"]) { --bg: #111215; --surface: #1B1C20; --fg: #ECEDEF; --muted: #A0A4AC; --line: #2E3036; --accent: #87A8F7; --accent-bg: #1D2540; --on-accent: #101322; --ok: #7FD39B; --no: #F0A27A; color-scheme: dark; } }
:root[data-theme="dark"] { --bg: #111215; --surface: #1B1C20; --fg: #ECEDEF; --muted: #A0A4AC; --line: #2E3036; --accent: #87A8F7; --accent-bg: #1D2540; --on-accent: #101322; --ok: #7FD39B; --no: #F0A27A; color-scheme: dark; }
* { box-sizing: border-box; }
body { margin: 0; background: var(--bg); color: var(--fg); font: 400 16px/1.55 var(--f-ui); padding-inline: 16px; -webkit-font-smoothing: antialiased; }
.wrap { max-width: 1160px; margin: 0 auto; padding-block: 28px 100px; }
figure { margin: 0; }
a { color: inherit; text-decoration-color: var(--accent); text-underline-offset: .18em; }
:focus-visible { outline: 2px solid var(--accent); outline-offset: 3px; }
.top { display: flex; justify-content: space-between; align-items: center; gap: 16px; flex-wrap: wrap; font: 600 14px/20px var(--f-ui); color: var(--muted); }
.top nav { display: flex; gap: 18px; flex-wrap: wrap; } .top nav a { text-decoration: none; } .top nav a:hover { color: var(--fg); }
.eyebrow { font: 600 13px/18px var(--f-ui); color: var(--muted); margin: 0; }
h1 { font: 800 clamp(44px, 7.2vw, 96px)/.94 var(--f-ui); letter-spacing: -.05em; margin: 12px 0 0; text-wrap: balance; }
h2 { font: 780 clamp(28px, 4vw, 46px)/1 var(--f-ui); letter-spacing: -.045em; margin: 0; text-wrap: balance; }
h3 { font: 700 24px/1.15 var(--f-ui); letter-spacing: -.03em; margin: 0 0 6px; }
h4 { font: 650 14px/20px var(--f-ui); margin: 14px 0 4px; color: var(--fg); }
.lead { font-size: 19px; line-height: 1.5; color: var(--muted); max-width: 62ch; margin: 18px 0 0; }
.lead b { color: var(--fg); font-weight: 650; }
section { margin-top: 96px; scroll-margin-top: 24px; }
.head { display: grid; gap: 12px; margin-bottom: 28px; max-width: 760px; }
.head p { margin: 0; color: var(--muted); font-size: 17px; }
.facts { display: grid; grid-template-columns: repeat(auto-fit, minmax(230px, 1fr)); gap: 0 28px; list-style: none; padding: 0; margin: 36px 0 0; max-width: 1100px; }
.facts li { border-top: 1px solid var(--fg); padding: 14px 0 16px; font-size: 15px; line-height: 22px; color: var(--muted); }
.facts li b { display: block; color: var(--fg); font-size: 17px; margin-bottom: 4px; }
.tablewrap { overflow-x: auto; }
table { width: 100%; border-collapse: collapse; min-width: 640px; font-size: 15px; line-height: 22px; }
th { text-align: left; font: 600 13px/18px var(--f-ui); color: var(--muted); padding: 0 16px 10px 0; border-bottom: 1px solid var(--fg); }
td { vertical-align: top; padding: 12px 16px 12px 0; border-bottom: 1px solid var(--line); color: var(--muted); }
td:first-child { color: var(--fg); font-weight: 650; white-space: nowrap; }
.mx td, .mx th { text-align: center; padding-inline: 6px; } .mx td:first-child, .mx th:first-child { text-align: left; white-space: nowrap; }
.mx td.m2 { color: var(--accent); font-size: 18px; } .mx td.m1 { color: var(--muted); font-size: 18px; }
.mx a { text-decoration: none; border-bottom: 1px solid var(--accent); }
.chips { display: flex; flex-wrap: wrap; gap: 8px; margin: 0 0 26px; }
.chips button { font: 600 14px/1 var(--f-ui); padding: 9px 14px; border-radius: 999px; border: 1px solid var(--line); background: var(--surface); color: var(--fg); cursor: pointer; }
.chips button[aria-pressed="true"] { background: var(--accent); border-color: var(--accent); color: var(--on-accent); }
.fcard { margin-top: 44px; padding-top: 22px; border-top: 1px solid var(--fg); display: grid; grid-template-columns: minmax(0, 1.9fr) minmax(0, 1fr); column-gap: 28px; row-gap: 12px; }
.fcard[hidden] { display: none; }
.fcard header { grid-column: 1 / -1; }
.fcard h3 { font-size: 30px; margin: 0; }
.meta { margin: 4px 0 0; font: 400 12.5px/18px var(--f-data); color: var(--muted); }
.fcard figure img { width: 100%; height: auto; display: block; background: #FAFAF7; box-shadow: 0 0 0 1px var(--line); cursor: zoom-in; }
.fcard.wide { grid-template-columns: minmax(0, 1fr); } .fcard.wide figure img { cursor: zoom-out; }
.txt { display: grid; gap: 4px; align-content: start; font-size: 14.5px; line-height: 21px; color: var(--muted); }
.fcard.wide .txt { grid-template-columns: repeat(2, minmax(0, 1fr)); gap: 24px; }
.txt p { margin: 0; }
.vi { margin: 0; padding-left: 22px; display: grid; gap: 8px; }
.vi li::marker { font-weight: 700; color: var(--fg); }
.cps { display: flex; flex-wrap: wrap; gap: 6px; }
.cp { font: 600 12.5px/1 var(--f-ui); padding: 6px 10px; border-radius: 999px; border: 1px solid var(--accent); color: var(--accent); }
.cp.s2 { background: var(--accent); color: var(--on-accent); }
.lic { display: block; margin-top: 4px; font-size: 13px; line-height: 19px; }
.rgs { display: flex; flex-wrap: wrap; gap: 6px; margin-top: 10px !important; }
.rg { font: 400 12px/1 var(--f-data); padding: 6px 8px; border-radius: 6px; background: var(--surface); box-shadow: inset 0 0 0 1px var(--line); color: var(--muted); }
.rg.ok { color: var(--ok); } .rg.no { color: var(--no); }
.out { margin-top: 38px; } .out h3 { font-size: 20px; margin-bottom: 2px; } .outd { margin: 0 0 8px; color: var(--muted); font-size: 15px; }
.ot { min-width: 560px; } .ot td:first-child { width: 22%; white-space: normal; } .ot td:nth-child(2) { width: 22%; font-size: 13.5px; }
.qs { margin: 0; padding-left: 22px; display: grid; gap: 10px; font-size: 18px; line-height: 26px; max-width: 780px; }
.ref { margin: 0; padding: 0; list-style: none; display: grid; gap: 8px; font-size: 13.5px; line-height: 20px; color: var(--muted); max-width: 900px; }
.ref li { padding-left: 1.6em; text-indent: -1.6em; }
.foot { margin-top: 70px; padding-top: 18px; border-top: 1px solid var(--line); font-size: 13.5px; line-height: 20px; color: var(--muted); display: grid; gap: 8px; max-width: 900px; }
.foot p { margin: 0; }
.hint { font-size: 13.5px; color: var(--muted); margin: 14px 0 0; }
@media (max-width: 900px) { .fcard { grid-template-columns: minmax(0, 1fr); } .fcard.wide .txt { grid-template-columns: minmax(0, 1fr); } }
</style>
<div class="wrap">
  <header class="top"><span>Relevo · propuesta 3.8</span><nav aria-label="Secciones"><a href="#lectura">Cómo se lee</a><a href="#g-logotipo">Fichas</a><a href="#matriz">Matriz</a><a href="#fuera">Descartadas</a><a href="#decidir">Decidir</a></nav></header>
  <div>
    <p class="eyebrow" style="margin-top:48px">Propuesta 3.8 · 4 de octubre de 2026</p>
    <h1>Letras que dicen relevo.</h1>
    <p class="lead">Busqué más letras display y las miré en grande, una por una, preguntándome qué concepto de Relevo evoca cada una. Se sumaron <b>61 letras de cinco fuentes nuevas</b> y se miraron <b>108 en grande</b>, con la palabra a tamaño de cartel y cada letra suelta. <b>Catorce pasaron a ficha</b>: cinco para el logotipo, tres para los momentos de señal y seis para carteles.</p>
    <ul class="facts">
      <li><b>Le75, 43</b>Taller de estudiantes de la escuela ESA le 75 de Bruselas; muy experimentales. Declara licencia GNU/GPL.</li>
      <li><b>Tunera, 9</b>Fundición abierta con letras de Ariel Martín Pérez (París) y de Ando, todas en OFL. Entre ellas, Manosque, Roubaix Industrielle y Ampoule.</li>
      <li><b>Republish, 4</b>Proyecto de Behalf Studio que investiga los restos de rotulación escondidos en el paisaje urbano; estas cuatro vienen de Vietnam. OFL.</li>
      <li><b>The League of Moveable Type, 4</b>Colectivo de letras abiertas. Blackout, de Tyler Finck, viene de aquí.</li>
      <li><b>Klotter Supply, 1</b>Struggle, una letra abierta para la comunicación de base (OFL).</li>
      <li><b>Ya vistas, 64 más</b>Letras de Velvetyne, Fontshare, UNCUT, Collletttivo y Le75 que se volvieron a mirar en grande, ahora con ojo de concepto.</li>
    </ul>
  </div>

  <section id="lectura">
    <div class="head"><p class="eyebrow">Cómo se lee</p><h2>Siete conceptos, siete rasgos</h2><p>Cada concepto sale de lo que Relevo es: el testigo que pasa de mano, el traspaso, el lugar marcado, la señal, el volver. Para cada uno busqué un rasgo concreto en las letras y anoté solo lo que se ve en la lámina.</p></div>
    ${lectura}
    <p class="hint">Es una lectura de diseño y falta probarla con personas. La investigación muestra que los rasgos de una letra comunican una personalidad (Brumberger, 2003; Henderson et al., 2004; Kulahcioglu y de Melo, 2018), que las formas curvas se prefieren a las angulosas (Bar y Neta, 2006) y que importa que la letra encaje con lo que representa (Doyle y Bottomley, 2006). Ninguno de esos estudios dice qué letra comunica «relevo», así que las asociaciones de abajo son una hipótesis.</p>
    <div class="head" style="margin-top:44px"><h3>Qué filtros se aplicaron</h3><p>Antes de leer las letras se aplicaron las reglas que el autor fue dando: minúsculas propias (el logotipo va en minúsculas y la app nunca escribe todo en mayúsculas), los acentos del español (á é í ó ú ñ ¿ ¡), nada de letra a mano y, en los titulares, nada de serif (el logotipo sí puede ser un display blando). Cada ficha muestra al pie cómo cumple las dos primeras, medidas en el archivo de la letra, y cuánto mide «relevo» a 32 px, para comparar cuánto espacio ocupa en la barra de la app.</p></div>
  </section>

  <section id="fichas">
    <div class="head"><p class="eyebrow">Fichas</p><h2>Catorce letras leídas</h2><p>Cada lámina muestra la palabra grande, cada letra suelta con los números de las notas, y pruebas en azul, a tres tamaños, con la firma y como ícono. Toca una lámina para verla más grande.</p></div>
    <div class="chips" role="group" aria-label="Filtrar por concepto"><button type="button" aria-pressed="true" data-f="">Todas</button>${CONCEPTOS.map(([c]) => `<button type="button" aria-pressed="false" data-f="${c}">${c}</button>`).join('')}</div>
  </section>
${grupos}

  <section id="matriz">
    <div class="head"><p class="eyebrow">Matriz</p><h2>Qué concepto lee cada letra</h2><p>● la evoca con claridad; ◐ la evoca en parte. Es mi lectura de lo que se ve.</p></div>
    ${matriz}
  </section>

  <section id="fuera">
    <div class="head"><p class="eyebrow">Descartadas</p><h2>${nFuera} entradas que se miraron y no pasaron</h2><p>Se agrupan por el motivo. Algunas aparecen en pareja porque se parecen.</p></div>
    ${fuera}
  </section>

  <section id="decidir">
    <div class="head"><p class="eyebrow">Para decidir</p><h2>Mi lectura y cuatro preguntas</h2><p>Si hubiera que elegir hoy, mi voto va a <b>Struggle</b> y a <b>Kola</b>. La primera pone el testigo en la «l» y la cápsula en el cuerpo de las letras; la segunda pone el hueco del traspaso en cada letra y termina todos los trazos en cápsula. Ouroboros cuenta el «vuelve» mejor que ninguna, pero es de familia serif. Bespoke Stencil es la más calmada, aunque a 16 px sus cortes casi no se ven. Es una lectura de diseño, sin probar con personas.</p></div>
    <ol class="qs">
      <li>De las cinco para el logotipo, ¿cuál te dice más «relevo»? Struggle y Manosque son cálidas y pesadas; Bespoke Stencil y Kola llevan los cortes como gesto; Ouroboros tiene la espiral del volver.</li>
      <li>¿Quieres una segunda letra para los momentos de señal? Ampoule, Striper y Linea sirven a ese papel.</li>
      <li>Los seis carteles solo tienen mayúsculas. La regla «nada todo en mayúsculas» se escribió para la app: ¿vale también para una pieza impresa?</li>
      <li>¿Pruebo las que te interesen a 16 px y dentro de la app, con espaciado y acentos?</li>
    </ol>
  </section>

  <footer class="foot">
    <p>Las autorías y las licencias salen de la página de cada letra: Tunera, Velvetyne, Republish, The League of Moveable Type, Klotter Supply, Le75 y Fontshare. Las láminas usan el azul de Relevo <code>#1C3891</code>. Las letras se cargaron desde los archivos descargados, que están fuera del repositorio; no se instaló nada.</p>
    <p><b>Referencias</b></p>
    <ul class="ref">
      <li>Bar, M. y Neta, M. (2006). Humans prefer curved visual objects. <i>Psychological Science, 17</i>(8), 645–648.</li>
      <li>Brumberger, E. R. (2003). The rhetoric of typography: The persona of typeface and text. <i>Technical Communication, 50</i>(2), 206–223.</li>
      <li>Doyle, J. R. y Bottomley, P. A. (2006). Dressed for the occasion: Font-product congruity in the perception of logotype. <i>Journal of Consumer Psychology, 16</i>(2), 112–123.</li>
      <li>Henderson, P. W., Giese, J. L. y Cote, J. A. (2004). Impression management using typeface design. <i>Journal of Marketing, 68</i>(4), 60–72. https://doi.org/10.1509/jmkg.68.4.60.42736</li>
      <li>Kulahcioglu, T. y de Melo, G. (2018). FontLex: A typographical lexicon based on affective associations. <i>Proceedings of the Eleventh International Conference on Language Resources and Evaluation (LREC 2018)</i>. https://aclanthology.org/L18-1010/</li>
      <li>Real Academia Española y Asociación de Academias de la Lengua Española. (2014). Relevo; Testigo. En <i>Diccionario de la lengua española</i> (23.ª ed., versión 23.8.1 en línea). https://dle.rae.es</li>
    </ul>
  </footer>
</div>
<script>
(function () {
  // Toca una lámina para ampliarla; vuelve a tocarla para reducirla.
  document.querySelectorAll('.fcard figure img').forEach(function (im) {
    im.addEventListener('click', function () { im.closest('.fcard').classList.toggle('wide'); });
  });
  // Filtro por concepto: muestra solo las fichas que lo evocan.
  var botones = document.querySelectorAll('.chips button');
  botones.forEach(function (b) {
    b.addEventListener('click', function () {
      var f = b.getAttribute('data-f');
      botones.forEach(function (x) { x.setAttribute('aria-pressed', x === b ? 'true' : 'false'); });
      document.querySelectorAll('.fcard').forEach(function (c) {
        var cs = (c.getAttribute('data-c') || '').split(' ');
        c.hidden = !!f && cs.indexOf(f) < 0;
      });
      document.querySelectorAll('.grp').forEach(function (g) { g.hidden = !g.querySelector('.fcard:not([hidden])'); });
    });
  });
})();
</script>`;
fs.mkdirSync(path.join(dir, 'lamina'), { recursive: true });
fs.writeFileSync(path.join(dir, 'lamina', 'letras-que-dicen-relevo.html'), html);
fs.writeFileSync(path.join(dir, 'lamina', 'vista.html'), '<meta charset="utf-8">\n' + html);
console.log('ok', Math.round(html.length / 1024) + ' KB', datos.length + ' fichas', nFuera + ' descartadas');
