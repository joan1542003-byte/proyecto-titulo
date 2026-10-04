// Compara tres familias de color armonizadas: misma luz y mismo croma en cada nivel, para que todo combine con todo.
const fs = require('fs');
const path = require('path');
const L = require('../color-lib.js');
const { launch, sleep } = require('../cdp.js');
const H = { sol: 88, naranja: 58, rosa: 350, menta: 160, celeste: 222, lila: 300, lima: 122 };
const mk = (Lv, C, h) => L.hex(L.oklchToRgb(Lv, Math.min(C, L.maxChroma(Lv, h) * 0.98), h).rgb);
const OPC = [
  ['A · claros pastel', 0.88, null, 0.39, 0.10],
  ['B · vivos medios', 0.82, 0.13, 0.33, 0.11],
  ['C · vivos plenos', 0.78, 0.15, 0.30, 0.12],
];
const fams = OPC.map(([name, Lv, Cv, Ld, Cd]) => {
  const cv = Cv ?? Math.min(...Object.values(H).map((h) => L.maxChroma(Lv, h) * 0.98));
  const viv = Object.fromEntries(Object.entries(H).map(([k, h]) => [k, mk(Lv, cv, h)]));
  const deep = Object.fromEntries(Object.entries(H).filter(([k]) => k !== 'lima').map(([k, h]) => [k, mk(Ld, Cd, h)]));
  let minC = 99, minB = 99;
  for (const d of Object.values(deep)) for (const v of Object.values(viv)) minC = Math.min(minC, L.contrast(d, v));
  for (const v of Object.values(viv)) minB = Math.min(minB, L.contrast('#3D38F5', v));
  return { name, Lv, cv, Ld, Cd, viv, deep, minC, minB };
});
const sw = (bg, fg, t) => `<div style="background:${bg};color:${fg};padding:10px 8px;font:700 15px/1 'Schibsted Grotesk'">${t}</div>`;
const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Schibsted+Grotesk:wght@400;700&display=block"><style>body{margin:0;padding:24px;background:#FAFAF7;font-family:'Schibsted Grotesk';display:grid;gap:30px}.f{display:grid;gap:8px}.row{display:grid;grid-template-columns:repeat(7,1fr);gap:4px}.mx{display:grid;grid-template-columns:repeat(7,1fr);gap:4px}h2{margin:0;font:700 18px/1.2 'Schibsted Grotesk'}p{margin:0;font:400 13px/1.3 'Schibsted Grotesk';color:#5B5F68}.blk{height:70px}</style>
${fams.map((f) => `<div class="f"><h2>${f.name}</h2><p>claros L ${f.Lv} C ${f.cv.toFixed(3)} · profundos L ${f.Ld} C ${f.Cd} · peor contraste profundo/claro ${f.minC.toFixed(2)} · azul sobre claros ${f.minB.toFixed(2)}</p>
<div class="row">${Object.values(f.viv).map((c) => `<div class="blk" style="background:${c}"></div>`).join('')}</div>
<div class="row">${Object.values(f.deep).map((c) => `<div class="blk" style="background:${c}"></div>`).join('')}<div class="blk" style="background:#3D38F5"></div></div>
<div class="mx">${Object.values(f.deep).map((d) => Object.entries(f.viv).map(([k, v]) => sw(d, v, k)).join('')).join('')}</div></div>`).join('')}`;
fs.writeFileSync(path.join(__dirname, 'paleta-lab.html'), html);
fs.writeFileSync(path.join(__dirname, 'paleta-lab.json'), JSON.stringify(fams.map(({ name, viv, deep, minC, minB }) => ({ name, viv, deep, minC, minB })), null, 1));
(async () => {
  const ch = await launch(9351);
  try {
    await ch.size(1100, 900);
    await ch.open('file:///' + path.join(__dirname, 'paleta-lab.html').split(path.sep).join('/'));
    await sleep(1800);
    const h = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1100, h); await sleep(400);
    await ch.shot(path.join(__dirname, 'paleta-lab.png'), 1100, h);
    console.log('ok', h);
  } finally { await ch.close(); }
})();
