// Renderiza «relevo» con la tipografía que carga cada página de producto de Pangram Pangram (tipografías «free to try»).
// No guarda archivos de fuentes: la página carga su propia webfont y se captura el resultado.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const SLUGS = `neue-gstaad palma altera neue-montreal neue-york frama kyoto mori museum neue-corp watch monument model lettra-mono valve editorial-sans playground nikkei gatwick talisman right-grotesk-mono right-serif-mono pangaia neue-montreal-mono hatton air editorial-old fragment right-didone right-serif right-slab acma writer telegraf neue-machina-collection right-sans formula rader neue-world radio-grotesk eiko pangram-sans editorial-new migra pangram-sans-rounded agrandir right-gothic supply right-grotesk object-sans cirka grafier gosha-sans woodland fuji-sans stellar-sans pier-sans charlevoix-pro casa-stencil chronos-serif`.split(/\s+/);
const only = process.argv.slice(2);
const list = only.length ? only : SLUGS;
const out = path.join(__dirname, 'img');
fs.mkdirSync(out, { recursive: true });
(async () => {
  const ch = await launch(9402);
  const meta = fs.existsSync(path.join(__dirname, 'meta.json')) ? JSON.parse(fs.readFileSync(path.join(__dirname, 'meta.json'), 'utf8')) : {};
  try {
    await ch.size(1400, 700);
    for (const slug of list) {
      try {
        await ch.open('https://pangrampangram.com/products/' + slug);
        await sleep(2500);
        const info = await ch.eval(`(async () => {
          const seen = new Map(); document.fonts.forEach(f => { const fam = f.family.replace(/["']/g, '').trim(); if (f.style !== 'normal') return; if (!seen.has(fam)) seen.set(fam, f.weight); });
          let use = [...seen.entries()].map(([f, w]) => ({ f, w })).filter(x => (x.f !== 'Neue Montreal' || location.pathname.includes('neue-montreal')) && !/text$/i.test(x.f));
          const pref = use.filter(x => !/variable/i.test(x.f)); if (pref.length) use = pref; use = use.slice(0, 3);
          const old = document.getElementById('rl'); if (old) old.remove();
          const box = document.createElement('div'); box.id = 'rl';
          box.style.cssText = 'position:fixed;left:0;top:0;z-index:2147483647;background:#fff;color:#141519;padding:18px 26px;width:900px;';
          for (const x of use) { const row = document.createElement('div'); const rg = String(x.w).split(' ').map(Number); const wt = rg.length > 1 ? Math.min(Math.max(700, rg[0]), rg[1]) : rg[0] || 400; row.style.cssText = 'font-family:"' + x.f + '";font-weight:' + wt + ';font-size:150px;line-height:1.1;white-space:nowrap;letter-spacing:-0.02em'; row.textContent = 'relevo'; box.appendChild(row); }
          document.body.appendChild(box);
          await Promise.all(use.map(x => document.fonts.load('700 100px "' + x.f + '"').catch(() => 0))); await document.fonts.ready;
          await new Promise(r => setTimeout(r, 400));
          const b = box.getBoundingClientRect();
          return { fams: use.map(x => x.f), rect: { x: b.left, y: b.top, w: b.width, h: b.height }, title: document.title };
        })()`);
        if (!info.fams.length) { console.log(slug, 'sin familias'); continue; }
        const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: info.rect.x, y: info.rect.y, width: info.rect.w, height: info.rect.h, scale: 1 }, captureBeyondViewport: false });
        fs.writeFileSync(path.join(out, slug + '.png'), Buffer.from(s.data, 'base64'));
        meta[slug] = { fams: info.fams, title: info.title.replace(/ – Pangram Pangram Foundry/, '') };
        console.log(slug, '|', info.fams.join(', '));
      } catch (e) { console.log(slug, 'ERROR', e.message.slice(0, 80)); }
    }
  } finally { fs.writeFileSync(path.join(__dirname, 'meta.json'), JSON.stringify(meta, null, 1)); await ch.close(); }
})();
