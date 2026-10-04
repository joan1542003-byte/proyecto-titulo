// Sonda: abre la página de una fundición, lista las familias web que la página ya carga y escribe «relevo» con cada una (sin descargar nada).
// uso: node sonda.js <puerto> <carpeta-salida> <id=url> [<id=url> ...]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [PORT, OUT, ...pares] = process.argv.slice(2);
fs.mkdirSync(OUT, { recursive: true });
(async () => {
  const ch = await launch(Number(PORT));
  const meta = {};
  try {
    await ch.size(1400, 900);
    for (const par of pares) {
      const i = par.indexOf('=');
      const id = par.slice(0, i), url = par.slice(i + 1);
      try {
        await ch.open(url);
        await sleep(3500);
        for (let k = 0; k < 6; k++) { await ch.eval('window.scrollBy(0, 900)'); await sleep(500); }
        await ch.eval('window.scrollTo(0, 0)'); await sleep(500);
        const info = await ch.eval(`(async () => {
          const seen = new Map();
          document.fonts.forEach(f => { const fam = f.family.replace(/["']/g, '').trim(); const k = fam + '|' + f.weight + '|' + f.style; if (!seen.has(k)) seen.set(k, { fam, w: f.weight, st: f.style, status: f.status }); });
          const all = [...seen.values()];
          await Promise.all(all.map(x => document.fonts.load((x.st === 'italic' ? 'italic ' : '') + String(x.w).split(' ')[0] + ' 80px "' + x.fam + '"').catch(() => 0)));
          await document.fonts.ready; await new Promise(r => setTimeout(r, 500));
          const ok = []; document.fonts.forEach(f => { if (f.status === 'loaded') ok.push(f.family.replace(/["']/g, '').trim() + '|' + f.weight + '|' + f.style); });
          return { total: all.length, loaded: [...new Set(ok)] };
        })()`);
        const usar = info.loaded.slice(0, 14);
        const r = await ch.eval(`(async () => {
          const old = document.getElementById('rl'); if (old) old.remove();
          const box = document.createElement('div'); box.id = 'rl';
          box.style.cssText = 'position:absolute;left:0;top:0;z-index:2147483647;background:#fff;color:#141519;padding:12px 20px;width:1200px;font:12px monospace';
          for (const k of ${JSON.stringify(usar)}) { const [fam, w, st] = k.split('|'); const row = document.createElement('div'); row.style.cssText = 'border-bottom:1px solid #ddd;padding:2px 0'; const lab = document.createElement('div'); lab.textContent = fam + ' · ' + w + ' · ' + st; lab.style.cssText = 'font:11px monospace;color:#666'; const t = document.createElement('div'); t.textContent = 'relevo RELEVO'; t.style.cssText = 'font-family:"' + fam + '";font-weight:' + String(w).split(' ')[0] + ';font-style:' + st + ';font-size:90px;line-height:1.1;white-space:nowrap'; row.append(lab, t); box.append(row); }
          document.body.appendChild(box); window.scrollTo(0, 0);
          await new Promise(r => setTimeout(r, 600));
          const b = box.getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height };
        })()`);
        const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: Math.min(r.h, 5000), scale: 1 }, captureBeyondViewport: true });
        fs.writeFileSync(path.join(OUT, id + '.png'), Buffer.from(s.data, 'base64'));
        meta[id] = { url, total: info.total, cargadas: usar };
        console.log(id, '|', info.total, 'familias,', usar.length, 'cargadas');
      } catch (e) { console.log(id, 'ERROR', e.message.slice(0, 90)); }
    }
  } finally { fs.writeFileSync(path.join(OUT, 'meta.json'), JSON.stringify(meta, null, 1)); await ch.close(); }
})();
