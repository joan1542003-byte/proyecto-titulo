// Hoja de contacto genérica: node hoja.js <items.json> <carpeta-img> <salida.png> <puerto> <fuente> [numeroInicial]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [itemsF, imgDir, salida, PORT, fuente, ini = '1'] = process.argv.slice(2);
(async () => {
  const items = JSON.parse(fs.readFileSync(itemsF, 'utf8'));
  const html = `<!doctype html><meta charset="utf-8"><style>body{margin:0;padding:14px;background:#EDEDE8;font-family:system-ui;display:grid;grid-template-columns:repeat(4,1fr);gap:8px;width:1500px;box-sizing:border-box}.c{background:#fff;position:relative;overflow:hidden}.c img{display:block;width:100%;height:92px;object-fit:cover;object-position:left top}.l{font:600 12px/1.2 system-ui;padding:3px 8px 6px;color:#333;display:flex;justify-content:space-between;gap:8px}.l i{font-style:normal;color:#999;font-weight:400}.n{position:absolute;left:6px;top:4px;font:700 12px system-ui;color:#fff;background:#141519;border-radius:9px;padding:1px 6px}</style>${items.map((it, i) => `<div class="c"><span class="n">${Number(ini) + i}</span><img src="file:///${path.resolve(imgDir, it.id + '.png').split(path.sep).join('/')}"><div class="l"><span>${it.nombre}</span><i>${fuente}</i></div></div>`).join('')}`;
  const htmlF = path.resolve(salida.replace(/\.png$/, '.html'));
  fs.writeFileSync(htmlF, html);
  const ch = await launch(Number(PORT));
  try {
    await ch.size(1500, 900);
    await ch.open('file:///' + htmlF.split(path.sep).join('/'));
    await sleep(900);
    const h = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1500, h); await sleep(300);
    await ch.shot(path.resolve(salida), 1500, h);
    console.log('ok', items.length, h);
  } finally { await ch.close(); }
})();
