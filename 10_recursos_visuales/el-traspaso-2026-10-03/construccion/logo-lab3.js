// Gestos para el logotipo: espaciado fino, el traspaso (la «l» toca la «e») y el punto lleno.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const link = 'https://fonts.googleapis.com/css2?family=Bricolage+Grotesque:opsz,wdth,wght@12..96,75..100,200..800&family=Familjen+Grotesk:wght@400..700&display=block';
const BR = "font-family:'Bricolage Grotesque';font-weight:700;font-variation-settings:'opsz' 96,'wdth' 100";
const FA = "font-family:'Familjen Grotesk';font-weight:700";
// k: espaciado de cada letra en em (después de la letra)
const word = (st, k, extra = '') => `<div class="big" style="${st}">${'relevo'.split('').map((ch, i) => `<span style="margin-right:${k[i] || 0}em${extra && i === 2 ? ';' + extra : ''}">${ch}</span>`).join('')}</div>`;
const V = [
  ['Bricolage · espaciado fino', word(BR, [-0.025, -0.03, -0.03, -0.035, -0.045, 0])],
  ['Bricolage · el traspaso (la «l» toca la «e»)', word(BR, [-0.025, -0.03, -0.085, -0.035, -0.045, 0])],
  ['Bricolage · el traspaso en color', word(BR, [-0.025, -0.03, -0.085, -0.035, -0.045, 0], 'color:#3D38F5')],
  ['Familjen · espaciado fino', word(FA, [-0.02, -0.025, -0.02, -0.03, -0.04, 0])],
  ['Familjen · el traspaso (el gancho de la «l» toca la «e»)', word(FA, [-0.02, -0.025, -0.075, -0.03, -0.04, 0])],
  ['Familjen · el traspaso en color', word(FA, [-0.02, -0.025, -0.075, -0.03, -0.04, 0], 'color:#3D38F5')],
];
const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="${link}"><style>body{margin:0;padding:24px;background:#FAFAF7;color:#141519;display:grid;grid-template-columns:1fr 1fr;gap:16px;font-family:system-ui}.c{background:#fff;padding:20px 26px;display:grid;gap:8px}.c b{font:600 13px system-ui}.big{font-size:170px;line-height:1.02;white-space:nowrap}.big span{display:inline-block}</style>${V.map(([n, w]) => `<div class="c"><b>${n}</b>${w}</div>`).join('')}`;
fs.writeFileSync(path.join(__dirname, 'logo-lab3.html'), html);
(async () => {
  const ch = await launch(9354);
  try {
    await ch.size(1500, 900);
    await ch.open('file:///' + path.join(__dirname, 'logo-lab3.html').split(path.sep).join('/'));
    await sleep(3500);
    const h = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1500, h); await sleep(500);
    await ch.shot(path.join(__dirname, 'logo-lab3.png'), 1500, h);
    console.log('ok', h);
  } finally { await ch.close(); }
})();
