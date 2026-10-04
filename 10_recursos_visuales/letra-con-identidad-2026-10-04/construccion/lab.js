// Exploración de letras display con identidad para el logotipo (gratis para uso comercial: Fontshare ITF FFL y Google Fonts OFL).
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
// [nombre CSS, origen, slug o familia GF, peso, ajustes extra, grupo]
const F = [
  ['Pally', 'fs', 'pally', 700, '', 'Redondas'], ['Chillax', 'fs', 'chillax', 600, '', 'Redondas'], ['Chubbo', 'fs', 'chubbo', 700, '', 'Redondas'],
  ['Calistoga', 'gf', 'Calistoga', 400, '', 'Redondas'], ['Bagel Fat One', 'gf', 'Bagel+Fat+One', 400, '', 'Redondas'],
  ['Cabinet Grotesk', 'fs', 'cabinet-grotesk', 800, '', 'Grotescas raras'], ['Clash Display', 'fs', 'clash-display', 600, '', 'Grotescas raras'], ['Melodrama', 'fs', 'melodrama', 700, '', 'Grotescas raras'],
  ['New Title', 'fs', 'new-title', 700, '', 'Grotescas raras'], ['Nippo', 'fs', 'nippo', 700, '', 'Grotescas raras'], ['Excon', 'fs', 'excon', 700, '', 'Grotescas raras'],
  ['Bricolage Grotesque', 'gf', 'Bricolage+Grotesque:opsz,wght@12..96,800', 800, "font-variation-settings:'opsz' 96", 'Grotescas raras'],
  ['Kola', 'fs', 'kola', 400, '', 'Display'], ['Zina', 'fs', 'zina', 400, '', 'Display'], ['Styro', 'fs', 'styro', 700, '', 'Display'], ['Sharpie', 'fs', 'sharpie', 700, '', 'Display'],
  ['Kihim', 'fs', 'kihim', 400, '', 'Display'], ['Stardom', 'fs', 'stardom', 400, '', 'Display'], ['Segment', 'fs', 'segment', 400, '', 'Display'], ['Bevellier', 'fs', 'bevellier', 700, '', 'Display'],
  ['Tilt Warp', 'gf', 'Tilt+Warp', 400, '', 'Display'], ['Dela Gothic One', 'gf', 'Dela+Gothic+One', 400, '', 'Display'],
  ['Panchang', 'fs', 'panchang', 700, '', 'Ancho y peso'], ['Tanker', 'fs', 'tanker', 400, '', 'Ancho y peso'], ['Anybody', 'gf', 'Anybody:wdth,wght@50..150,900', 900, "font-stretch:150%", 'Ancho y peso'], ['Array', 'fs', 'array', 700, '', 'Ancho y peso'],
  ['Bespoke Stencil', 'fs', 'bespoke-stencil', 700, '', 'Fuera de la sans'], ['Bonny', 'fs', 'bonny', 700, '', 'Fuera de la sans'],
  ['Fraunces', 'gf', 'Fraunces:opsz,wght,SOFT,WONK@9..144,800,100,1', 800, "font-variation-settings:'SOFT' 100,'WONK' 1,'opsz' 144", 'Fuera de la sans'],
];
const fsCss = 'https://api.fontshare.com/v2/css?' + F.filter((f) => f[1] === 'fs').map((f) => `f[]=${f[2]}@${f[3]}`).join('&') + '&display=block';
const gfCss = 'https://fonts.googleapis.com/css2?' + F.filter((f) => f[1] === 'gf').map((f) => 'family=' + f[2]).join('&') + '&display=block';
const card = ([n, src, , w, extra, g]) => `<div class="c"><div class="w" style="font-family:'${n}';font-weight:${w};${extra}">relevo</div><div class="s" style="font-family:'${n}';font-weight:${w};${extra}">relevo</div><b>${n}</b><small>${src === 'fs' ? 'Fontshare' : 'Google Fonts'} · ${g}</small></div>`;
const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="${fsCss}"><link rel="stylesheet" href="${gfCss}"><style>body{margin:0;padding:20px;background:#FAFAF7;color:#141519;font-family:system-ui;display:grid;grid-template-columns:repeat(4,1fr);gap:12px}.c{background:#fff;padding:14px 16px;display:grid;gap:4px;overflow:hidden}.w{font-size:62px;line-height:1.15;letter-spacing:-.01em;white-space:nowrap}.s{font-size:18px}b{font:600 13px system-ui}small{font:12px system-ui;color:#777}</style>${F.map(card).join('')}`;
fs.writeFileSync(path.join(__dirname, 'lab.html'), html);
(async () => {
  const ch = await launch(9391);
  try {
    await ch.size(1500, 900); await ch.open('file:///' + path.join(__dirname, 'lab.html').split(path.sep).join('/')); await sleep(4000);
    const miss = await ch.eval(`(async () => { await document.fonts.ready; return [...new Set([...document.querySelectorAll('.w')].map(e => getComputedStyle(e).fontFamily))].filter(f => !document.fonts.check('40px ' + f)); })()`);
    const h = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1500, h); await sleep(600);
    await ch.shot(path.join(__dirname, 'lab.png'), 1500, h); console.log('ok', h, 'sin cargar:', JSON.stringify(miss));
  } finally { await ch.close(); }
})();
