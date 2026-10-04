// Seis finalistas en uso: grande, en una pieza de color, en la barra de la app, en el ícono y en chico.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const AZUL = '#1C3891', INK = '#141519', PAPER = '#FAFAF7';
const F = [
  ['Chubbo', 700, '', '-0.02em'], ['Calistoga', 400, '', '-0.01em'], ['Pally', 700, '', '-0.02em'],
  ['Chillax', 600, '', '-0.02em'], ['Panchang', 700, '', '-0.03em'], ['Fraunces', 800, "font-variation-settings:'SOFT' 100,'WONK' 1,'opsz' 144", '-0.02em'],
];
const PARES = [['#3F2364', '#E7BF57'], ['#014128', '#6FDEA7'], ['#5C153D', '#CEB5FE'], ['#013C4C', '#FEB074'], ['#3F2364', '#FEA4CF'], ['#014128', '#E7BF57']];
const css = 'https://api.fontshare.com/v2/css?f[]=chubbo@700&f[]=pally@700&f[]=chillax@600&f[]=panchang@700&display=block';
const gf = 'https://fonts.googleapis.com/css2?family=Calistoga&family=Fraunces:opsz,wght,SOFT,WONK@9..144,800,100,1&family=Schibsted+Grotesk:wght@400;600;800&display=block';
const st = ([n, w, x, ls]) => `font-family:'${n}';font-weight:${w};letter-spacing:${ls};${x}`;
const card = (f, i) => { const [d, l] = PARES[i]; return `<section class="c"><h2>${f[0]}</h2>
<div class="big" style="${st(f)}">relevo</div>
<div class="row"><div class="pz" style="background:${d};color:${l}"><div class="h">Las ganas estaban.</div><div class="lg" style="${st(f)}">relevo</div></div>
<div class="bl" style="background:${AZUL};color:${PAPER}"><div class="lg2" style="${st(f)}">relevo</div></div>
<div class="ic" style="background:${AZUL}"><span style="${st(f)}">r</span></div></div>
<div class="row2"><div class="bar"><span style="${st(f)}">relevo</span><i></i></div><span class="s32" style="${st(f)}">relevo</span><span class="s16" style="${st(f)}">relevo</span><span class="s16" style="${st(f)};color:${AZUL}">relevo</span></div></section>`; };
const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="${css}"><link rel="stylesheet" href="${gf}"><style>body{margin:0;padding:20px;background:#EDEDE8;color:${INK};display:grid;grid-template-columns:1fr 1fr;gap:14px;font-family:'Schibsted Grotesk'}.c{background:${PAPER};padding:18px 20px;display:grid;gap:12px}h2{margin:0;font:600 14px 'Schibsted Grotesk';color:#5B5F68}.big{font-size:120px;line-height:1.05;white-space:nowrap}.row{display:grid;grid-template-columns:1.1fr 1fr 96px;gap:10px;align-items:stretch}.pz{padding:14px;display:flex;flex-direction:column;justify-content:space-between;min-height:150px}.pz .h{font:800 26px/1 'Schibsted Grotesk';letter-spacing:-.04em}.pz .lg{font-size:26px}.bl{display:grid;place-items:center}.lg2{font-size:44px}.ic{width:96px;height:96px;border-radius:22px;display:grid;place-items:center;color:${PAPER};align-self:center}.ic span{font-size:70px;line-height:1;margin-top:-10px}.row2{display:flex;gap:22px;align-items:center}.bar{flex:1;display:flex;justify-content:space-between;align-items:center;background:#fff;padding:10px 14px;border-radius:14px;box-shadow:0 0 0 1px #E4E4DF}.bar span{font-size:24px}.bar i{width:28px;height:28px;border-radius:50%;background:#EDEDE8}.s32{font-size:32px}.s16{font-size:16px}</style>${F.map(card).join('')}`;
fs.writeFileSync(path.join(__dirname, 'corta.html'), html);
(async () => {
  const ch = await launch(9392);
  try {
    await ch.size(1500, 900); await ch.open('file:///' + path.join(__dirname, 'corta.html').split(path.sep).join('/')); await sleep(3500);
    const h = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1500, h); await sleep(500);
    await ch.shot(path.join(__dirname, 'corta.png'), 1500, h); console.log('ok', h);
  } finally { await ch.close(); }
})();
