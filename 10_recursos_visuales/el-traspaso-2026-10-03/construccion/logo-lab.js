// Compara tipografías sans con carácter para el logotipo «relevo» (Google Fonts, licencia OFL).
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const F = [
  ['Schibsted Grotesk', 'Schibsted+Grotesk:wght@400..900', 'actual'],
  ['Bricolage Grotesque', 'Bricolage+Grotesque:opsz,wdth,wght@12..96,75..100,200..800', ''],
  ['Familjen Grotesk', 'Familjen+Grotesk:wght@400..700', ''],
  ['Funnel Display', 'Funnel+Display:wght@300..800', ''],
  ['Gabarito', 'Gabarito:wght@400..900', ''],
  ['Geologica', 'Geologica:wght,SHRP@100..900,0..100', 'SHRP 100'],
  ['Instrument Sans', 'Instrument+Sans:wdth,wght@75..100,400..700', ''],
  ['Syne', 'Syne:wght@400..800', ''],
  ['Epilogue', 'Epilogue:wght@100..900', ''],
  ['Darker Grotesque', 'Darker+Grotesque:wght@300..900', ''],
  ['Unbounded', 'Unbounded:wght@200..900', ''],
  ['Hanken Grotesk', 'Hanken+Grotesk:wght@100..900', ''],
];
const link = `https://fonts.googleapis.com/css2?${F.map((f) => 'family=' + f[1]).join('&')}&display=block`;
const row = ([fam, , note]) => `<div class="r"><div class="n">${fam}<small>${note}</small></div>${[500, 700, 800].map((w) => `<div class="w" style="font-family:'${fam}';font-weight:${w};${fam === 'Geologica' ? "font-variation-settings:'SHRP' 100;" : ''}">relevo</div>`).join('')}<div class="s" style="font-family:'${fam}';font-weight:700">relevo · Vuelve a leer 10 páginas</div></div>`;
const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="${link}"><style>body{margin:0;padding:20px;background:#FAFAF7;color:#141519;font-family:system-ui}.r{display:grid;grid-template-columns:150px repeat(3,1fr) 260px;align-items:center;gap:10px;border-top:1px solid #DADBD6;padding:6px 0}.n{font:600 13px/1.2 system-ui}.n small{display:block;color:#888;font-weight:400}.w{font-size:76px;line-height:1.1;letter-spacing:-.025em;white-space:nowrap}.s{font-size:18px}</style>${F.map(row).join('')}`;
fs.writeFileSync(path.join(__dirname, 'logo-lab.html'), html);
(async () => {
  const ch = await launch(9352);
  try {
    await ch.size(1400, 900);
    await ch.open('file:///' + path.join(__dirname, 'logo-lab.html').split(path.sep).join('/'));
    await sleep(3500);
    const h = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1400, h); await sleep(500);
    await ch.shot(path.join(__dirname, 'logo-lab.png'), 1400, h);
    console.log('ok', h);
  } finally { await ch.close(); }
})();
