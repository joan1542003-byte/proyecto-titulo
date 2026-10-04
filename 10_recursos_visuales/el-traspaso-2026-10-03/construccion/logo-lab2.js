// Primer plano de las cuatro finalistas, en tinta sobre papel y en tamaño de ícono.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const C = [
  ['Bricolage Grotesque', 700, "'opsz' 96, 'wdth' 100", 'wght 700, opsz 96'],
  ['Bricolage Grotesque', 650, "'opsz' 96, 'wdth' 82", 'wght 650, ancho 82'],
  ['Familjen Grotesk', 700, 'normal', 'wght 700'],
  ['Funnel Display', 700, 'normal', 'wght 700'],
  ['Syne', 700, 'normal', 'wght 700'],
  ['Gabarito', 700, 'normal', 'wght 700'],
];
const link = 'https://fonts.googleapis.com/css2?family=Bricolage+Grotesque:opsz,wdth,wght@12..96,75..100,200..800&family=Familjen+Grotesk:wght@400..700&family=Funnel+Display:wght@300..800&family=Syne:wght@400..800&family=Gabarito:wght@400..900&display=block';
const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="${link}"><style>body{margin:0;padding:24px;background:#FAFAF7;color:#141519;display:grid;grid-template-columns:1fr 1fr;gap:18px;font-family:system-ui}.c{background:#fff;padding:22px 26px;display:grid;gap:10px}.c b{font:600 13px system-ui}.c small{color:#888;font:400 12px system-ui}.big{font-size:150px;line-height:1;letter-spacing:-.03em}.row{display:flex;gap:16px;align-items:center}.ic{width:72px;height:72px;border-radius:17px;background:#3D38F5;color:#fff;display:grid;place-items:center;font-size:56px;line-height:1}.sm{font-size:15px}</style>${C.map(([f, w, v, n]) => `<div class="c"><b>${f} <small>${n}</small></b><div class="big" style="font-family:'${f}';font-weight:${w};font-variation-settings:${v}">relevo</div><div class="row"><div class="ic" style="font-family:'${f}';font-weight:${w};font-variation-settings:${v}">r</div><div class="sm" style="font-family:'${f}';font-weight:${w};font-variation-settings:${v}">relevo</div><div style="font-family:'${f}';font-weight:${w};font-size:28px;font-variation-settings:${v};letter-spacing:-.02em">relevo</div></div></div>`).join('')}`;
fs.writeFileSync(path.join(__dirname, 'logo-lab2.html'), html);
(async () => {
  const ch = await launch(9353);
  try {
    await ch.size(1500, 900);
    await ch.open('file:///' + path.join(__dirname, 'logo-lab2.html').split(path.sep).join('/'));
    await sleep(3500);
    const h = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1500, h); await sleep(500);
    await ch.shot(path.join(__dirname, 'logo-lab2.png'), 1500, h);
    console.log('ok', h);
  } finally { await ch.close(); }
})();
