// Tablero de una letra candidata para el logotipo: grande, tintas, tamaños, ícono y usos reales con el azul y la familia nueva.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const AZUL = '#1C3891', INK = '#141519', PAPER = '#FAFAF7';
const FUENTES = {
  chubbo: { css: 'https://api.fontshare.com/v2/css?f[]=chubbo@700&display=block', st: "font-family:'Chubbo';font-weight:700;letter-spacing:-0.02em", n: 'Chubbo Bold', ls: '−2 %' },
  calistoga: { css: 'https://fonts.googleapis.com/css2?family=Calistoga&display=block', st: "font-family:'Calistoga';font-weight:400;letter-spacing:-0.01em", n: 'Calistoga', ls: '−1 %' },
  fraunces: { css: 'https://fonts.googleapis.com/css2?family=Fraunces:opsz,wght,SOFT,WONK@9..144,800,100,1&display=block', st: "font-family:'Fraunces';font-weight:800;font-variation-settings:'SOFT' 100,'WONK' 1,'opsz' 144;letter-spacing:-0.02em", n: 'Fraunces Soft', ls: '−2 %' },
};
const k = process.argv[2] || 'chubbo';
const F = FUENTES[k];
const lg = (sz, color = 'inherit') => `<span style="${F.st};font-size:${sz};color:${color};line-height:1;white-space:nowrap">relevo</span>`;
const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="${F.css}"><link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Schibsted+Grotesk:wght@400;500;600;800&family=IBM+Plex+Mono&display=block">
<style>body{margin:0;background:${PAPER};color:${INK};font-family:'Schibsted Grotesk';width:1600px}
.w{padding:60px 64px;display:grid;gap:36px}.hero{display:flex;align-items:flex-end;justify-content:space-between;gap:30px}.meta{font:400 13px/1.5 'IBM Plex Mono';color:#5B5F68;max-width:360px;text-align:right}
.tiles{display:grid;grid-template-columns:repeat(5,1fr);gap:12px}.t{aspect-ratio:16/10;display:grid;place-items:center;position:relative}.t small{position:absolute;left:12px;bottom:10px;font:400 11px 'IBM Plex Mono';opacity:.8}
.sizes{display:flex;align-items:flex-end;gap:40px;border-top:1px solid #E4E4DF;padding-top:26px}.sz{display:grid;gap:8px}.sz small{font:400 12px 'IBM Plex Mono';color:#5B5F68}
.ic{width:120px;height:120px;border-radius:27px;background:${AZUL};display:grid;place-items:center;color:${PAPER}}.ic span{${F.st};font-size:92px;line-height:1;margin-top:-14px}
.apps{display:grid;grid-template-columns:1.05fr 1fr 1fr 1.25fr;gap:14px;align-items:start}
.phone{border-radius:34px;background:#fff;box-shadow:0 0 0 1px #E4E4DF;padding:22px 20px;display:grid;gap:16px;aspect-ratio:9/16;align-content:start}.bar{display:flex;justify-content:space-between;align-items:center}.bar i{width:30px;height:30px;border-radius:50%;background:#EDEDE8}.hola{font:800 30px/1 'Schibsted Grotesk';letter-spacing:-.045em}.card{border-radius:18px;box-shadow:inset 0 0 0 1px #E4E4DF;padding:16px;display:grid;gap:6px}.card small{font:500 12px 'Schibsted Grotesk';color:#5B5F68}.card b{font:800 24px/1 'Schibsted Grotesk';letter-spacing:-.04em}.chip{justify-self:start;align-self:start;background:#E7BF57;color:#3F2364;border-radius:99px;padding:4px 10px;font:600 12px 'Schibsted Grotesk'}
.pz{aspect-ratio:4/5;padding:28px;display:flex;flex-direction:column;justify-content:space-between}.pz h3{margin:0;font:800 34px/.98 'Schibsted Grotesk';letter-spacing:-.045em}.pz p{margin:0;font:500 14px/1.35 'Schibsted Grotesk'}
.tarj{aspect-ratio:85.6/54;border-radius:14px;padding:22px 26px;display:flex;flex-direction:column;justify-content:space-between}.tarj b{font:800 40px/1 'Schibsted Grotesk';letter-spacing:-.05em;display:flex;align-items:baseline;gap:12px}.tarj b i{flex:1;height:3px;background:currentColor;border-radius:2px}
.lbl{font:600 13px 'Schibsted Grotesk';color:#5B5F68;margin-bottom:-22px}</style>
<div class="w">
<div class="hero">${lg('290px')}<p class="meta">${F.n}<br>minúsculas · espaciado ${F.ls}<br>una tinta</p></div>
<div class="lbl">Tintas</div>
<div class="tiles"><div class="t" style="background:#fff;box-shadow:inset 0 0 0 1px #E4E4DF">${lg('64px', INK)}<small>tinta sobre papel</small></div><div class="t" style="background:${INK};color:${PAPER}">${lg('64px', PAPER)}<small>papel sobre tinta</small></div><div class="t" style="background:${AZUL};color:${PAPER}">${lg('64px', PAPER)}<small>papel sobre azul</small></div><div class="t" style="background:#3F2364;color:#E7BF57">${lg('64px', '#E7BF57')}<small>pieza de color</small></div><div class="t" style="background:#014128;color:#6FDEA7">${lg('64px', '#6FDEA7')}<small>pieza de color</small></div></div>
<div class="sizes"><span class="sz">${lg('64px')}<small>64 px</small></span><span class="sz">${lg('32px')}<small>32 px</small></span><span class="sz">${lg('20px')}<small>20 px</small></span><span class="sz">${lg('16px')}<small>16 px</small></span><span class="sz" style="margin-left:auto"><span class="ic"><span>r</span></span><small>ícono</small></span></div>
<div class="lbl">En uso</div>
<div class="apps">
<div class="phone"><div class="bar">${lg('26px')}<i></i></div><div class="hola">Hola.</div><div class="card"><span class="chip">Contando</span><small>Vuelve a</small><b>leer 10 páginas.</b><small>6 min de 15 en tus apps</small></div></div>
<div class="pz" style="background:#fff;box-shadow:inset 0 0 0 1px #E4E4DF"><h3>El libro sigue en el velador.</h3><div><p>Relevo suena ahí cuando sumas el tiempo que elegiste en tus apps.</p><div style="margin-top:14px">${lg('30px')}</div></div></div>
<div class="pz" style="background:${AZUL};color:${PAPER}"><h3>Las ganas estaban.</h3><div><p>43 de 47 personas querían hacer otra cosa mientras seguían en el teléfono.</p><div style="margin-top:14px">${lg('30px', PAPER)}</div></div></div>
<div style="display:grid;gap:14px"><div class="tarj" style="background:${AZUL};color:${PAPER}">${lg('34px', PAPER)}<b>Vuelve a <i></i></b></div><div class="tarj" style="background:#fff;box-shadow:inset 0 0 0 1px #E4E4DF;color:${INK}"><p style="margin:0;font:400 14px/1.45 'Schibsted Grotesk'">Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad y, cuando se cumple la condición que elegiste, emite una señal breve.</p>${lg('28px')}</div></div>
</div></div>`;
fs.writeFileSync(path.join(__dirname, `tablero-${k}.html`), html);
(async () => {
  const ch = await launch(9393);
  try {
    await ch.size(1600, 900); await ch.open('file:///' + path.join(__dirname, `tablero-${k}.html`).split(path.sep).join('/')); await sleep(3000);
    const h = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1600, h); await sleep(500);
    await ch.shot(path.join(__dirname, `tablero-${k}.png`), 1600, h); console.log('ok', k, h);
  } finally { await ch.close(); }
})();
