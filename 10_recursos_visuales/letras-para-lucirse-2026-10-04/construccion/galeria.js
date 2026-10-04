// Galería: reúne imágenes de especímenes en hojas numeradas, con la imagen completa en cada celda.
// uso: node galeria.js <items.json> <carpeta-img> <prefijo-salida> <puerto> <porHoja> <columnas> [numeroInicial]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [itemsF, imgDir, prefijo, PORT, porHoja = '24', cols = '3', ini = '1'] = process.argv.slice(2);
(async () => {
  const items = JSON.parse(fs.readFileSync(itemsF, 'utf8'));
  const P = Number(porHoja), C = Number(cols);
  const ch = await launch(Number(PORT));
  try {
    for (let h = 0; h * P < items.length; h++) {
      const parte = items.slice(h * P, h * P + P);
      const html = `<!doctype html><meta charset="utf-8"><style>body{margin:0;padding:10px;background:#EDEDE8;font-family:system-ui;width:1500px;box-sizing:border-box;display:grid;grid-template-columns:repeat(${C},1fr);gap:8px}.c{background:#fff;position:relative;overflow:hidden}.c img{display:block;width:100%;height:${process.env.CROP ? process.env.CROP + 'px' : 'auto'};object-fit:cover;object-position:left top}.n{position:absolute;right:6px;top:4px;font:700 12px system-ui;color:#fff;background:#141519;border-radius:9px;padding:1px 7px}</style>${parte.map((it, i) => `<div class="c"><span class="n">${Number(ini) + h * P + i}</span><img src="file:///${path.resolve(imgDir, it.id + (fs.existsSync(path.resolve(imgDir, it.id + '.png')) ? '.png' : '.jpg')).split(path.sep).join('/')}"></div>`).join('')}`;
      const hf = path.resolve(prefijo + '-' + (h + 1) + '.html');
      fs.writeFileSync(hf, html);
      await ch.size(1500, 900);
      await ch.open('file:///' + hf.split(path.sep).join('/'));
      await sleep(1200);
      const H = await ch.eval('document.documentElement.scrollHeight');
      await ch.size(1500, H); await sleep(300);
      await ch.shot(path.resolve(prefijo + '-' + (h + 1) + '.png'), 1500, H);
      console.log('hoja', h + 1, parte.length, H);
    }
  } finally { await ch.close(); }
})();
