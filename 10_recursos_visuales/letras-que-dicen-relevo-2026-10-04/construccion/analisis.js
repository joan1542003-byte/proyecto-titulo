// Mesa de análisis: cada candidata display, escrita en grande («relevo», «RELEVO», la firma y los acentos) para mirar sus letras una por una.
// uso: node analisis.js <puerto> <lista.json> <carpeta-salida> [tamañoDeTanda]
// lista.json: [{ k, nombre, origen, archivo, peso }]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [PORT, LISTA, OUT, TANDA = '8'] = process.argv.slice(2);
const lista = JSON.parse(fs.readFileSync(LISTA, 'utf8'));
fs.mkdirSync(OUT, { recursive: true });
const T = Number(TANDA);

const card = (it, i, n) => {
  const fam = 'f' + i;
  const w = it.peso || 400;
  return `<div class="c" id="c${i}"><div class="m"><b>${n}</b><em>${it.nombre}</em><span>${it.origen}</span></div>
<div class="r"><span class="w" style="font-family:'${fam}';font-weight:${w}">relevo</span></div>
<div class="r"><span class="w2" style="font-family:'${fam}';font-weight:${w}">RELEVO</span></div>
<div class="r"><span class="f" style="font-family:'${fam}';font-weight:${w}">Vuelve a lo que querías hacer.</span></div>
<div class="r"><span class="a" style="font-family:'${fam}';font-weight:${w}">á é í ó ú ñ ¿ ¡ — hazle lugar</span></div></div>`;
};

(async () => {
  const css = lista.map((it, i) => `@font-face{font-family:"f${i}";src:url("file:///${it.archivo.split(path.sep).join('/')}");${it.variable ? 'font-weight:100 900;' : ''}}`).join('\n');
  const base = `<style>${css}
body{margin:0;background:#EDEDE8;font-family:system-ui;width:1520px;padding:10px;box-sizing:border-box;display:grid;grid-template-columns:1fr 1fr;gap:10px}
.c{background:#fff;padding:12px 18px 14px;overflow:hidden;color:#141519}
.m{font:600 13px system-ui;color:#333;display:flex;justify-content:space-between;margin-bottom:6px}.m b{background:#141519;color:#fff;border-radius:9px;padding:1px 7px;margin-right:6px}.m span{color:#999;font-weight:400}.m em{font-style:normal;flex:1}.r{white-space:nowrap}.r span{display:inline-block}
.w{font-size:210px;line-height:1.05;white-space:nowrap;letter-spacing:-.01em}
.w2{font-size:84px;line-height:1.1;white-space:nowrap}
.f{font-size:34px;line-height:1.25;white-space:nowrap}
.a{font-size:26px;line-height:1.3;white-space:nowrap;color:#444}
</style>`;
  const ch = await launch(Number(PORT));
  try {
    for (let t = 0; t * T < lista.length; t++) {
      const parte = lista.slice(t * T, t * T + T);
      const html = `<!doctype html><meta charset="utf-8">${base.replace(/f(\d+)"/g, (m) => m)}<body>${parte.map((it, j) => card(it, t * T + j, it.n || t * T + j + 1)).join('')}</body>`;
      const hf = path.resolve(OUT, 'tanda-' + (t + 1) + '.html');
      fs.writeFileSync(hf, html);
      await ch.size(1520, 900);
      await ch.open('file:///' + hf.split(path.sep).join('/'));
      await sleep(2500);
      // ajusta cada palabra al ancho de su tarjeta
      await ch.eval(`(() => { document.querySelectorAll('.c').forEach(c => { for (const [sel, max] of [['.w', 210], ['.w2', 84], ['.f', 34], ['.a', 26]]) { const e = c.querySelector(sel); let s = max; e.style.fontSize = s + 'px'; while (e.getBoundingClientRect().width > 706 && s > 10) { s -= 4; e.style.fontSize = s + 'px'; } } }); })()`);
      const h = await ch.eval('document.documentElement.scrollHeight');
      await ch.size(1520, h); await sleep(400);
      const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: 0, y: 0, width: 1520, height: h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(OUT, 'tanda-' + (t + 1) + '.png'), Buffer.from(s.data, 'base64'));
      console.log('tanda', t + 1, parte.map((x) => x.nombre).join(', '));
    }
  } finally { await ch.close(); }
})();
