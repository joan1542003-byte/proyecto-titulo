// Segunda ronda: las candidatas más fuertes, más grandes.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const V = path.join(__dirname, '..');
const idx = JSON.parse(fs.readFileSync(path.join(__dirname, 'indice.json'), 'utf8'));
const keys = process.argv.slice(2);
const items = keys.map((k) => idx.find((i) => i.k === k)).filter(Boolean);
(async () => {
  const ch = await launch(9408);
  try {
    const html = `<!doctype html><meta charset="utf-8"><style>body{margin:0;padding:14px;background:#EDEDE8;font-family:system-ui;display:grid;grid-template-columns:repeat(3,1fr);gap:8px;width:1500px;box-sizing:border-box}.c{background:#fff;position:relative;overflow:hidden}.c img{display:block;width:100%;height:150px;object-fit:cover;object-position:left top}.l{font:600 13px/1.2 system-ui;padding:3px 10px 7px;color:#333;display:flex;justify-content:space-between}.l i{font-style:normal;color:#999;font-weight:400}.n{position:absolute;left:6px;top:4px;font:700 12px system-ui;color:#fff;background:#141519;border-radius:9px;padding:1px 6px}</style>${items.map((it) => `<div class="c"><span class="n">${it.n}</span><img src="file:///${path.join(V, it.img).split(path.sep).join('/')}"><div class="l"><span>${it.label}</span><i>${it.src}</i></div></div>`).join('')}`;
    fs.writeFileSync(path.join(__dirname, 'cortas.html'), html);
    await ch.size(1500, 900); await ch.open('file:///' + path.join(__dirname, 'cortas.html').split(path.sep).join('/')); await sleep(800);
    const h = await ch.eval('document.documentElement.scrollHeight'); await ch.size(1500, h); await sleep(300);
    await ch.shot(path.join(__dirname, 'cortas.png'), 1500, h); console.log('ok', items.length, h);
  } finally { await ch.close(); }
})();
