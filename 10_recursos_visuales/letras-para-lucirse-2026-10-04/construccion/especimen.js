// Especímenes en la página de cada fundición: escribe «relevo» con familias y pesos concretos, sin descargar archivos.
// uso: node especimen.js <puerto> <lista.json> <carpeta-salida>
// lista.json: [{ page, items: [{ id, fam, w, st, label }] }]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [PORT, LISTA, OUT] = process.argv.slice(2);
const lista = JSON.parse(fs.readFileSync(LISTA, 'utf8'));
fs.mkdirSync(OUT, { recursive: true });
(async () => {
  const ch = await launch(Number(PORT));
  const hechos = [];
  try {
    await ch.size(1300, 900);
    for (const grupo of lista) {
      try {
        await ch.open(grupo.page);
        await sleep(3500);
        for (let k = 0; k < 5; k++) { await ch.eval('window.scrollBy(0, 900)'); await sleep(400); }
        await ch.eval('window.scrollTo(0, 0)'); await sleep(400);
        const rects = await ch.eval(`(async () => {
          const items = ${JSON.stringify(grupo.items)};
          const old = document.getElementById('rl'); if (old) old.remove();
          const box = document.createElement('div'); box.id = 'rl';
          box.style.cssText = 'position:absolute;left:0;top:0;z-index:2147483647;background:#fff;width:1200px;';
          items.forEach((it, i) => { const row = document.createElement('div'); row.id = 'row' + i; row.style.cssText = 'padding:10px 24px 8px;background:#fff;border-bottom:1px solid #e4e4df;box-sizing:border-box;width:1200px'; const lab = document.createElement('div'); lab.textContent = it.label || it.id; lab.style.cssText = 'font:12px monospace;color:#666;height:16px'; const t = document.createElement('div'); t.textContent = 'relevo'; t.style.cssText = 'font-family:"' + it.fam + '";font-weight:' + String(it.w).split(' ')[0] + ';font-style:' + (it.st || 'normal') + ';font-size:170px;line-height:1.15;white-space:nowrap;color:#141519'; row.append(lab, t); box.append(row); });
          document.body.appendChild(box);
          await Promise.all(items.map(it => document.fonts.load((it.st === 'italic' ? 'italic ' : '') + String(it.w).split(' ')[0] + ' 100px "' + it.fam + '"').catch(() => 0)));
          await document.fonts.ready; await new Promise(r => setTimeout(r, 700)); window.scrollTo(0, 0);
          return items.map((it, i) => { const b = document.getElementById('row' + i).getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height, ok: document.fonts.check((it.st === 'italic' ? 'italic ' : '') + String(it.w).split(' ')[0] + ' 40px "' + it.fam + '"') }; });
        })()`);
        for (let i = 0; i < grupo.items.length; i++) {
          const r = rects[i];
          const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
          fs.writeFileSync(path.join(OUT, grupo.items[i].id + '.png'), Buffer.from(s.data, 'base64'));
          hechos.push({ id: grupo.items[i].id, nombre: grupo.items[i].label || grupo.items[i].id });
        }
        console.log(grupo.page, grupo.items.length);
      } catch (e) { console.log(grupo.page, 'ERROR', e.message.slice(0, 90)); }
    }
  } finally { fs.writeFileSync(path.join(OUT, 'items.json'), JSON.stringify(hechos, null, 1)); await ch.close(); }
})();
