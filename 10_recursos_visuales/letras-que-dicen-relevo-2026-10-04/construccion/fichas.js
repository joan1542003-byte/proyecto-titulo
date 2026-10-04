// Lámina de cada ficha: la palabra grande, cada letra suelta con su número, y las pruebas (azul, tamaños, firma, ícono).
// uso: node fichas.js <puerto> <carpeta-salida> [id ...]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const datos = require('./fichas-datos.js');
const [PORT, OUT, ...solo] = process.argv.slice(2);
fs.mkdirSync(OUT, { recursive: true });
const lista = [...JSON.parse(fs.readFileSync('lista-analisis.json', 'utf8')), ...JSON.parse(fs.readFileSync('lista-analisis2.json', 'utf8'))];
const AZUL = '#1C3891', INK = '#141519', PAPER = '#FAFAF7';
const fichas = datos.filter((d) => !solo.length || solo.includes(d.id));

const lamina = (d, i, it) => {
  const st = `font-family:'g${i}';font-weight:${it.variable ? 700 : 400}`;
  const letras = [...'relevo'];
  // numeración de las notas: 1, 2, 3 en el orden de datos; las de «todo» van a la palabra grande
  const num = {};
  d.n.forEach((n, j) => { if (n.l !== 'todo') num[n.l] = num[n.l] || j + 1; });
  const todo = d.n.map((n, j) => (n.l === 'todo' ? j + 1 : 0)).filter(Boolean);
  const cell = (c, k) => `<div class="cell">${num[c] && letras.indexOf(c) === k ? `<i class="b">${num[c]}</i>` : ''}<span class="ch" style="${st}">${c}</span></div>`;
  const logo = (px, color) => `<span class="lg" style="${st};font-size:${px}px;color:${color}">relevo</span>`;
  return `<div class="f" id="f${i}">
<div class="hero">${todo.length ? `<i class="b bt">${todo.join(' · ')}</i>` : ''}<span class="hw" style="${st}">relevo</span></div>
<div class="strip">${letras.map(cell).join('')}</div>
<div class="tests">
<div class="t" style="background:#fff;box-shadow:inset 0 0 0 1px #E4E4DF">${logo(60, AZUL)}<small>azul sobre papel</small></div>
<div class="t" style="background:${AZUL}">${logo(60, PAPER)}<small style="color:#DDE3F6">papel sobre azul</small></div>
<div class="t ladder" style="background:#fff;box-shadow:inset 0 0 0 1px #E4E4DF"><div>${logo(32, INK)}${logo(22, INK)}${logo(16, INK)}</div><small>32, 22 y 16 px</small></div>
<div class="t" style="background:#fff;box-shadow:inset 0 0 0 1px #E4E4DF;align-content:center"><span class="sig" style="${st}">Vuelve a lo que querías hacer.</span><small>la firma</small></div>
<div class="t" style="background:#fff;box-shadow:inset 0 0 0 1px #E4E4DF"><div class="ico"><span style="${st}">r</span></div><small>ícono</small></div>
</div></div>`;
};

(async () => {
  const css = fichas.map((d, i) => { const it = lista.find((x) => x.k === d.k); if (!it) throw new Error('sin fuente ' + d.k); return `@font-face{font-family:"g${i}";src:url("file:///${it.archivo.split(path.sep).join('/')}");${it.variable ? 'font-weight:100 900;' : ''}}`; }).join('\n');
  const base = `<style>${css}
body{margin:0;background:${PAPER}}
.f{width:1200px;box-sizing:border-box;padding:26px 40px 30px;background:${PAPER};color:${INK};font-family:'Segoe UI',system-ui,sans-serif}
.hero{position:relative;height:290px;display:flex;align-items:center}
.hw{white-space:nowrap;line-height:1;display:inline-block;font-size:260px}
.b{position:absolute;left:4px;top:2px;background:${INK};color:#fff;font:700 15px/22px 'Segoe UI',system-ui,sans-serif;font-style:normal;min-width:22px;height:22px;border-radius:11px;text-align:center;padding:0 6px;box-sizing:border-box}
.bt{left:0;top:0}
.strip{display:flex;border-top:1px solid #E4E4DF;border-bottom:1px solid #E4E4DF;margin:8px 0 18px}
.cell{position:relative;flex:1;display:flex;align-items:center;justify-content:center;height:270px;border-left:1px solid #E4E4DF;min-width:0;overflow:hidden}
.cell:first-child{border-left:0}
.cell .b{left:8px;top:8px}
.ch{font-size:210px;line-height:1;display:block}
.tests{display:grid;grid-template-columns:1fr 1fr 1.2fr 1.4fr .75fr;gap:10px}
.t{height:140px;display:grid;place-items:center;position:relative;overflow:hidden;padding:0 10px;box-sizing:border-box}
.t small{position:absolute;left:10px;bottom:8px;font:400 11px 'Consolas',monospace;opacity:.8;color:#5B5F68}
.lg{white-space:nowrap;line-height:1.1;display:inline-block}
.ladder>div{display:grid;gap:4px;justify-items:start;align-self:center}
.sig{font-size:26px;line-height:1.15;display:block;text-align:center;white-space:normal;max-width:300px}
.ico{width:84px;height:84px;border-radius:20px;background:${AZUL};display:grid;place-items:center;overflow:hidden}
.ico span{font-size:66px;line-height:1;color:${PAPER}}
</style>`;
  const html = `<!doctype html><meta charset="utf-8">${base}<body>${fichas.map((d, i) => lamina(d, i, lista.find((x) => x.k === d.k))).join('')}</body>`;
  const hf = path.resolve(OUT, 'fichas.html');
  fs.writeFileSync(hf, html);
  const ch = await launch(Number(PORT));
  try {
    await ch.size(1200, 900);
    await ch.open('file:///' + hf.split(path.sep).join('/'));
    await sleep(3000);
    await ch.eval(`(async () => { await document.fonts.ready; await new Promise(r => setTimeout(r, 600));
      document.querySelectorAll('.f').forEach(f => {
        const h = f.querySelector('.hw'); let s = 260; h.style.fontSize = s + 'px';
        while ((h.getBoundingClientRect().width > 1110 || h.getBoundingClientRect().height > 280) && s > 60) { s -= 6; h.style.fontSize = s + 'px'; }
        const cells = [...f.querySelectorAll('.cell')]; let t = 210; const apply = () => f.querySelectorAll('.ch').forEach(x => x.style.fontSize = t + 'px');
        apply(); const fits = () => [...f.querySelectorAll('.ch')].every(x => x.getBoundingClientRect().width <= cells[0].getBoundingClientRect().width - 14);
        while (!fits() && t > 40) { t -= 6; apply(); }
        f.querySelectorAll('.t .lg').forEach(l => { const box = l.closest('.t'); let px = parseFloat(l.style.fontSize); if (px >= 40 && !box.classList.contains('ladder')) { while (l.getBoundingClientRect().width > box.getBoundingClientRect().width - 24 && px > 20) { px -= 2; l.style.fontSize = px + 'px'; } } });
        const sg = f.querySelector('.sig'); let q = 26; while (sg.getBoundingClientRect().height > 100 && q > 14) { q -= 1; sg.style.fontSize = q + 'px'; }
      }); })()`);
    const anchos = await ch.eval(`(() => { const o = {}; document.querySelectorAll('.f').forEach((f, i) => { const l = f.querySelector('.ladder .lg'); const c = document.createElement('span'); c.textContent = 'relevo'; c.style.cssText = l.style.cssText + ';font-size:32px;position:absolute;visibility:hidden;white-space:nowrap'; document.body.appendChild(c); o[i] = Math.round(c.getBoundingClientRect().width); c.remove(); }); return o; })()`);
    const af = path.join(OUT, 'anchos32.json'); const previo = fs.existsSync(af) ? JSON.parse(fs.readFileSync(af, 'utf8')) : []; const mapa = Object.fromEntries(previo.map((x) => [x.id, x.ancho32])); fichas.forEach((d, i) => { mapa[d.id] = anchos[i]; }); fs.writeFileSync(af, JSON.stringify(Object.entries(mapa).map(([id, ancho32]) => ({ id, ancho32 })), null, 1));
    console.log('anchos a 32 px:', fichas.map((d, i) => d.id + '=' + anchos[i]).join(' '));
    const H = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1200, H); await sleep(500);
    for (let i = 0; i < fichas.length; i++) {
      const r = await ch.eval(`(() => { const b = document.getElementById('f${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'jpeg', quality: 90, clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(OUT, fichas[i].id + '.jpg'), Buffer.from(s.data, 'base64'));
      console.log('ficha', fichas[i].id, Math.round(r.h));
    }
  } finally { await ch.close(); }
})();
