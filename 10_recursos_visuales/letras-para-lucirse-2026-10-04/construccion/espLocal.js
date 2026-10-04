// Especímenes con archivos locales: «relevo» a 170 px en el mismo formato que especimen.js (para mezclarlos en una galería).
// uso: node espLocal.js <puerto> <lista.json> <carpeta-salida>
// lista.json: [{ id, label, archivo, variable?, w? }]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [PORT, LISTA, OUT] = process.argv.slice(2);
const lista = JSON.parse(fs.readFileSync(LISTA, 'utf8'));
fs.mkdirSync(OUT, { recursive: true });
(async () => {
  const css = lista.map((it, i) => `@font-face{font-family:"e${i}";src:url("file:///${it.archivo.split(path.sep).join('/')}");${it.variable ? 'font-weight:100 900;' : ''}}`).join('\n');
  const html = `<!doctype html><meta charset="utf-8"><style>${css}
body{margin:0;background:#fff}
.r{padding:10px 24px 8px;background:#fff;border-bottom:1px solid #e4e4df;box-sizing:border-box;width:1200px}
.l{font:12px monospace;color:#666;height:16px}
.t{font-size:170px;line-height:1.15;white-space:nowrap;color:#141519;display:inline-block}
</style><body>${lista.map((it, i) => `<div class="r" id="r${i}"><div class="l">${it.label}</div><div class="t" style="font-family:'e${i}';font-weight:${it.variable ? (it.w || 500) : 400}">relevo</div></div>`).join('')}</body>`;
  const hf = path.resolve(OUT, 'esp.html');
  fs.writeFileSync(hf, html);
  const ch = await launch(Number(PORT));
  try {
    await ch.size(1300, 900);
    await ch.open('file:///' + hf.split(path.sep).join('/'));
    await sleep(3500);
    await ch.eval(`(async () => { await document.fonts.ready; document.querySelectorAll('.t').forEach(t => { let s = 170; while (t.getBoundingClientRect().width > 1150 && s > 40) { s -= 6; t.style.fontSize = s + 'px'; } }); })()`);
    const H = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1300, H); await sleep(500);
    for (let i = 0; i < lista.length; i++) {
      const r = await ch.eval(`(() => { const b = document.getElementById('r${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(OUT, lista[i].id + '.png'), Buffer.from(s.data, 'base64'));
    }
    fs.writeFileSync(path.join(OUT, 'items.json'), JSON.stringify(lista.map((x) => ({ id: x.id, nombre: x.label })), null, 1));
    console.log('especímenes', lista.length);
  } finally { await ch.close(); }
})();
