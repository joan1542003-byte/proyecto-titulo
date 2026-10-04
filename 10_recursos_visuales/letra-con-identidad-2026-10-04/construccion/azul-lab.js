// El azul de Relevo dentro de la familia: candidatos con la luz de los profundos y algo más de croma.
const fs = require('fs');
const path = require('path');
const L = require('../../color-lib.js');
const { launch, sleep } = require('../../cdp.js');
const CLAROS = { sol: '#E7BF57', naranja: '#FEB074', rosa: '#FEA4CF', menta: '#6FDEA7', celeste: '#54D6FE', lila: '#CEB5FE' };
const PROF = { violeta: '#3F2364', petroleo: '#013C4C', bosque: '#014128', vino: '#5C153D' };
const mk = (l, c, h) => L.hex(L.oklchToRgb(l, Math.min(c, L.maxChroma(l, h) * 0.98), h).rgb);
const CAND = [
  ['actual', '#3D38F5'],
  ['A · profundo exacto', mk(0.33, 0.11, 266)],
  ['B · profundo + croma', mk(0.36, 0.14, 266)],
  ['C · un punto más claro', mk(0.40, 0.16, 266)],
  ['D · índigo', mk(0.36, 0.14, 278)],
  ['E · azul marino', mk(0.33, 0.12, 258)],
];
const PAPER = '#FAFAF7', INK = '#141519';
const card = ([n, b]) => `<div class="cd"><h3>${n} <code>${b}</code></h3>
<div class="row">${Object.values(PROF).map((c) => `<i style="background:${c}"></i>`).join('')}<i style="background:${b};outline:3px solid #141519;outline-offset:-3px"></i></div>
<div class="row">${Object.values(CLAROS).map((c) => `<i style="background:${c}"></i>`).join('')}</div>
<div class="mx">${Object.values(CLAROS).map((c) => `<span style="background:${b};color:${c}">Aa<small>${L.contrast(b, c).toFixed(1)}</small></span>`).join('')}</div>
<div class="ui"><div class="fld"><small>Actividad</small><b style="border-color:${b}">leer 10 páginas<em style="background:${b}"></em></b></div><div class="tab" style="color:${b}">● Inicio</div><div class="ic" style="background:${b}">r</div><div class="pz" style="background:${b};color:${PAPER}">Las ganas<br>estaban.</div><div class="pz" style="background:${PAPER};color:${b};box-shadow:inset 0 0 0 1px #ddd">43 de 47</div></div>
<p>papel ${L.contrast(b, PAPER).toFixed(1)}:1 · claros mín ${Math.min(...Object.values(CLAROS).map((c) => L.contrast(b, c))).toFixed(1)}:1</p></div>`;
const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Schibsted+Grotesk:wght@400;700&family=IBM+Plex+Mono&display=block"><style>body{margin:0;padding:20px;background:#EDEDE8;font-family:'Schibsted Grotesk';display:grid;grid-template-columns:1fr 1fr 1fr;gap:14px}.cd{background:#FAFAF7;padding:14px;display:grid;gap:8px}h3{margin:0;font-size:15px}code{font:12px 'IBM Plex Mono';color:#666}.row{display:grid;grid-auto-flow:column;height:34px}.row i{display:block}.mx{display:grid;grid-template-columns:repeat(6,1fr);gap:3px}.mx span{font:700 20px/1 'Schibsted Grotesk';padding:8px 6px;display:grid;gap:4px}.mx small{font:11px 'IBM Plex Mono'}.ui{display:grid;grid-template-columns:1.4fr .8fr .5fr;gap:8px;align-items:center}.fld{grid-column:1/-1;display:grid;gap:4px}.fld small{font-size:11px;color:#666}.fld b{font:600 18px 'Schibsted Grotesk';border-bottom:3px solid;padding-bottom:4px;display:flex;gap:2px;align-items:center}.fld em{width:2px;height:20px}.tab{font:700 13px 'Schibsted Grotesk'}.ic{width:52px;height:52px;border-radius:12px;color:#FAFAF7;display:grid;place-items:center;font:700 34px/1 'Schibsted Grotesk'}.pz{grid-column:span 1;font:800 18px/1 'Schibsted Grotesk';padding:14px 10px;min-height:70px}p{margin:0;font:12px 'IBM Plex Mono';color:#444}</style>${CAND.map(card).join('')}`;
fs.writeFileSync(path.join(__dirname, 'lab.html'), html);
fs.writeFileSync(path.join(__dirname, 'cand.json'), JSON.stringify(CAND));
(async () => {
  const ch = await launch(9371);
  try {
    await ch.size(1500, 900); await ch.open('file:///' + path.join(__dirname, 'lab.html').split(path.sep).join('/')); await sleep(1500);
    const h = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1500, h); await sleep(400);
    await ch.shot(path.join(__dirname, 'lab.png'), 1500, h); console.log('ok', h, JSON.stringify(CAND));
  } finally { await ch.close(); }
})();
