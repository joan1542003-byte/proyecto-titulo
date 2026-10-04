// Recorta la parte de arriba de cada tablero (nombre y palabra grande) a 600 px de ancho, para el muestrario de la lámina.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const ids = fs.readdirSync('tableros').filter((f) => f.endsWith('.jpg')).map((f) => f.replace('.jpg', ''));
fs.mkdirSync('recortes', { recursive: true });
(async () => {
  const html = `<!doctype html><meta charset="utf-8"><style>body{margin:0;background:#FAFAF7}.c{width:1200px;height:300px;overflow:hidden;position:relative}.c img{display:block;width:1200px;height:auto}</style><body>${ids.map((id) => `<div class="c" id="c-${id}"><img src="file:///${path.resolve('tableros', id + '.jpg').split(path.sep).join('/')}"></div>`).join('')}</body>`;
  const hf = path.resolve('recortes', 'recortes.html');
  fs.writeFileSync(hf, html);
  const ch = await launch(9801);
  try {
    await ch.size(1200, 900);
    await ch.open('file:///' + hf.split(path.sep).join('/'));
    await sleep(2500);
    const H = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1200, H); await sleep(500);
    for (const id of ids) {
      const r = await ch.eval(`(() => { const b = document.getElementById('c-${id}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'jpeg', quality: 86, clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 0.5 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join('recortes', id + '.jpg'), Buffer.from(s.data, 'base64'));
    }
    console.log('recortes', ids.length);
  } finally { await ch.close(); }
})();
