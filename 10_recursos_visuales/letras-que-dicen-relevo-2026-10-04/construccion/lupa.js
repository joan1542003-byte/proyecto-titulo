// Lupa: la palabra a tamaño de cartel y cada letra suelta (r, e, l, v, o), para mirar los trazos de cerca.
// uso: node lupa.js <puerto> <lista.json> <carpeta-salida> <clave1> <clave2> ...   (claves de lista-analisis.json, p. ej. vw:typefesse)
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [PORT, LISTA, OUT, ...claves] = process.argv.slice(2);
const lista = JSON.parse(fs.readFileSync(LISTA, 'utf8'));
fs.mkdirSync(OUT, { recursive: true });
(async () => {
  const sel = claves.map((k) => lista.find((x) => x.k === k)).filter(Boolean);
  const css = sel.map((it, i) => `@font-face{font-family:"g${i}";src:url("file:///${it.archivo.split(path.sep).join('/')}");${it.variable ? 'font-weight:100 900;' : ''}}`).join('\n');
  const html = `<!doctype html><meta charset="utf-8"><style>${css}
body{margin:0;background:#EDEDE8;width:1500px;padding:10px;box-sizing:border-box;display:grid;gap:10px}
.c{background:#fff;padding:14px 22px 18px;color:#141519;overflow:hidden}
.m{font:600 14px system-ui;color:#333;margin-bottom:4px}.m span{color:#999;font-weight:400;margin-left:10px}
.w{white-space:nowrap;line-height:1.05;display:inline-block}
.l{display:flex;gap:26px;align-items:flex-end;margin-top:6px}.l span{font-size:240px;line-height:1.05;display:block;min-width:60px}
</style><body>${sel.map((it, i) => { const st = `font-family:'g${i}';font-weight:${it.peso || 400}`; return `<div class="c" id="c${i}"><div class="m">${it.nombre}<span>${it.origen}</span></div><div class="r"><span class="w" style="${st}">relevo</span></div><div class="l" style="${st}">${[...'relevo'].map((c) => `<span>${c}</span>`).join('')}<span style="margin-left:30px">R</span><span>E</span><span>L</span><span>V</span><span>O</span></div></div>`; }).join('')}</body>`;
  const hf = path.resolve(OUT, 'lupa.html');
  fs.writeFileSync(hf, html);
  const ch = await launch(Number(PORT));
  try {
    await ch.size(1500, 900);
    await ch.open('file:///' + hf.split(path.sep).join('/'));
    await sleep(2500);
    await ch.eval(`(() => { document.querySelectorAll('.c').forEach(c => { const e = c.querySelector('.w'); let s = 360; e.style.fontSize = s + 'px'; while (e.getBoundingClientRect().width > 1450 && s > 40) { s -= 6; e.style.fontSize = s + 'px'; } const l = c.querySelector('.l'); let t = 240; l.querySelectorAll('span').forEach(x => x.style.fontSize = t + 'px'); while (l.scrollWidth > 1450 && t > 40) { t -= 6; l.querySelectorAll('span').forEach(x => x.style.fontSize = t + 'px'); } }); })()`);
    const h = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1500, h); await sleep(400);
    for (let i = 0; i < sel.length; i += 2) {
      const ids = [i, i + 1].filter((j) => j < sel.length);
      const rs = [];
      for (const j of ids) rs.push(await ch.eval(`(() => { const b = document.getElementById('c${j}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`));
      const x = rs[0].x, y = rs[0].y, w = rs[0].w, hh = rs[rs.length - 1].y + rs[rs.length - 1].h - rs[0].y;
      const sh = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x, y, width: w, height: hh, scale: 1 }, captureBeyondViewport: true });
      const nombre = ids.map((j) => sel[j].k.replace(/[^a-z0-9-]/gi, '_')).join('+');
      fs.writeFileSync(path.join(OUT, nombre + '.png'), Buffer.from(sh.data, 'base64'));
      console.log('lupa', nombre);
    }
  } finally { await ch.close(); }
})();
