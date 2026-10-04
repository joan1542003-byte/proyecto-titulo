// Renderiza «relevo» con las letras de Open Foundry a través de su hoja de estilo pública (no se guarda ningún archivo de fuente).
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
(async () => {
  const goog = new Set(JSON.parse(fs.readFileSync('../google-families.json', 'utf8')).map((f) => f.toLowerCase().replace(/[^a-z0-9]/g, '')));
  const all = JSON.parse(fs.readFileSync('lista.json', 'utf8')).filter((o) => o.fams && o.fams.length);
  const list = all.filter((o) => !goog.has(o.fams[0].toLowerCase().replace(/[^a-z0-9]/g, '')) && !goog.has(o.slug.replace(/[^a-z0-9]/g, '')));
  console.log('omitidas por estar en Google Fonts:', all.filter((o) => !list.includes(o)).map((o) => o.slug).join(', '));
  const items = list.map((o) => { const w = o.ws.includes(700) ? 700 : o.ws.includes(600) ? 600 : o.ws[o.ws.length - 1] || 400; return { ...o, fam: o.fams[0], w }; });
  const html = `<!doctype html><meta charset="utf-8">${items.map((o) => `<link rel="stylesheet" href="${o.u}">`).join('')}<body style="margin:0;background:#fff">${items.map((o, i) => `<div id="r${i}" style="width:900px;padding:18px 26px;box-sizing:border-box;font-family:'${o.fam}';font-weight:${o.w};font-size:150px;line-height:1.1;white-space:nowrap;letter-spacing:-0.02em;color:#141519;background:#fff">relevo</div>`).join('')}</body>`;
  fs.writeFileSync('run.html', html);
  const ch = await launch(9421);
  try {
    await ch.size(1000, 900);
    await ch.open('file:///' + path.join(__dirname, 'run.html').split(path.sep).join('/'));
    await sleep(5000);
    const bad = await ch.eval(`(async () => { await document.fonts.ready; const it = ${JSON.stringify(items.map((o) => [o.fam, o.w]))}; return it.filter(([f, w]) => !document.fonts.check(w + ' 40px "' + f + '"')).map(x => x[0]); })()`);
    const H = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1000, H); await sleep(700);
    for (let i = 0; i < items.length; i++) {
      const r = await ch.eval(`(() => { const b = document.getElementById('r${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join('img', items[i].slug + '.png'), Buffer.from(s.data, 'base64'));
    }
    fs.writeFileSync('items.json', JSON.stringify(items.map((o) => ({ slug: o.slug, fam: o.fam, w: o.w })), null, 1));
    console.log('renders', items.length, 'sin cargar:', JSON.stringify(bad));
  } finally { await ch.close(); }
})();
