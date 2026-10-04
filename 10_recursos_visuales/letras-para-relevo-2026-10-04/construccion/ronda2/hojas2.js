// Hojas de contacto de la segunda ronda: UNCUT (descargadas) y Open Foundry. Numeración continúa desde 177.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const V = path.join(__dirname, '..');
const items = [];
const un = JSON.parse(fs.readFileSync(path.join(V, 'uncut/items.json'), 'utf8'));
for (const it of un) items.push({ k: 'un-' + it.id.replace(/\//g, '__'), src: 'UNCUT', label: it.nombre, lic: it.lic, by: it.by, img: 'uncut/img/' + it.id.replace(/\//g, '__') + '.png', flag: it.sinCargar ? 'sin cargar' : '' });
const of = JSON.parse(fs.readFileSync(path.join(V, 'of/items.json'), 'utf8'));
for (const it of of) items.push({ k: 'of-' + it.slug, src: 'Open Foundry', label: it.slug, img: 'of/img/' + it.slug + '.png', flag: '' });
items.forEach((it, i) => { it.n = 177 + i; });
fs.writeFileSync(path.join(__dirname, 'indice2.json'), JSON.stringify(items, null, 1));
const PER = 40;
(async () => {
  const ch = await launch(9423);
  try {
    for (let s = 0; s * PER < items.length; s++) {
      const part = items.slice(s * PER, (s + 1) * PER);
      const html = `<!doctype html><meta charset="utf-8"><style>body{margin:0;padding:14px;background:#EDEDE8;font-family:system-ui;display:grid;grid-template-columns:repeat(4,1fr);gap:8px;width:1500px;box-sizing:border-box}.c{background:#fff;position:relative;overflow:hidden}.c img{display:block;width:100%;height:92px;object-fit:cover;object-position:left top}.l{font:600 12px/1.2 system-ui;padding:3px 8px 6px;color:#333;display:flex;justify-content:space-between;gap:8px}.l i{font-style:normal;color:#999;font-weight:400}.n{position:absolute;left:6px;top:4px;font:700 12px system-ui;color:#fff;background:#141519;border-radius:9px;padding:1px 6px}</style>${part.map((it) => `<div class="c"><span class="n">${it.n}</span><img src="file:///${path.join(V, it.img).split(path.sep).join('/')}"><div class="l"><span>${it.label}</span><i>${it.src}</i></div></div>`).join('')}`;
      fs.writeFileSync(path.join(__dirname, `hoja2-${s + 1}.html`), html);
      await ch.size(1500, 900); await ch.open('file:///' + path.join(__dirname, `hoja2-${s + 1}.html`).split(path.sep).join('/')); await sleep(900);
      const h = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1500, h); await sleep(300);
      await ch.shot(path.join(__dirname, `hoja2-${s + 1}.png`), 1500, h);
      console.log('hoja2', s + 1, part[0].n + '–' + part[part.length - 1].n);
    }
  } finally { await ch.close(); }
})();
