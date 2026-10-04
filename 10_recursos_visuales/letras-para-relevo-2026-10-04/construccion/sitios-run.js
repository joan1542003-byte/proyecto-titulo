// Renderiza «relevo» con la tipografía que carga la página de cada tipografía en su propio sitio.
// uso: node run.js <puerto> <sitio> <ids...>   (sitio: velvetyne | collletttivo | url:<plantilla con {id}>)
// No guarda archivos de fuentes: la página carga su webfont y se captura el resultado.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const [port, site, ...ids] = process.argv.slice(2);
const SITES = {
  velvetyne: { url: (id) => `https://velvetyne.fr/fonts/${id}/`, skip: '^(vtf-|inter$)' },
};
const cfg = SITES[site] || { url: (id) => site.replace('{id}', id), skip: process.env.SKIP || '^$' };
const out = path.join(__dirname, 'img', site.replace(/[^a-z]/g, '').slice(0, 24));
fs.mkdirSync(out, { recursive: true });
const metaFile = path.join(__dirname, 'meta-' + site.replace(/[^a-z]/g, '').slice(0, 24) + '.json');
(async () => {
  const ch = await launch(Number(port));
  const meta = fs.existsSync(metaFile) ? JSON.parse(fs.readFileSync(metaFile, 'utf8')) : {};
  try {
    await ch.size(1400, 700);
    for (const id of ids) {
      try {
        await ch.open(cfg.url(id));
        await sleep(2500);
        const info = await ch.eval(`(async () => {
          const skip = new RegExp(${JSON.stringify(cfg.skip)}, 'i');
          const seen = new Map(); document.fonts.forEach(f => { const fam = f.family.replace(/["']/g, '').trim(); if (f.style !== 'normal' || skip.test(fam)) return; if (!seen.has(fam)) seen.set(fam, f.weight); });
          const use = [...seen.entries()].map(([f, w]) => ({ f, w })).slice(0, 3);
          const old = document.getElementById('rl'); if (old) old.remove();
          const box = document.createElement('div'); box.id = 'rl';
          box.style.cssText = 'position:fixed;left:0;top:0;z-index:2147483647;background:#fff;color:#141519;padding:18px 26px;width:900px;';
          for (const x of use) { const row = document.createElement('div'); const rg = String(x.w).split(' ').map(Number); const wt = rg.length > 1 ? Math.min(Math.max(700, rg[0]), rg[1]) : (rg[0] || 400); row.style.cssText = 'font-family:"' + x.f + '";font-weight:' + wt + ';font-size:150px;line-height:1.1;white-space:nowrap;letter-spacing:-0.02em'; row.textContent = 'relevo'; box.appendChild(row); }
          document.body.appendChild(box);
          await Promise.all(use.map(x => document.fonts.load('700 100px "' + x.f + '"').catch(() => 0))); await document.fonts.ready;
          await new Promise(r => setTimeout(r, 400));
          const b = box.getBoundingClientRect();
          return { fams: use.map(x => x.f), rect: { x: b.left, y: b.top, w: b.width, h: b.height }, title: document.title };
        })()`);
        if (!info.fams.length) { console.log(id, 'sin familias'); continue; }
        const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: info.rect.x, y: info.rect.y, width: info.rect.w, height: info.rect.h, scale: 1 }, captureBeyondViewport: false });
        fs.writeFileSync(path.join(out, id.split('/').join('__') + '.png'), Buffer.from(s.data, 'base64'));
        meta[id] = { fams: info.fams, title: info.title };
        console.log(id, '|', info.fams.join(', '));
      } catch (e) { console.log(id, 'ERROR', e.message.slice(0, 80)); }
    }
  } finally { fs.writeFileSync(metaFile, JSON.stringify(meta, null, 1)); await ch.close(); }
})();
