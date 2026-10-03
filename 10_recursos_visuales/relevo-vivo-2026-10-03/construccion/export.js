// Exporta cada pieza de la lámina como PNG (para el repositorio), a 2x.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const IDS = ['afiche-leer', 'afiche-moverme', 'afiche-crear', 'afiche-cuidar', 'afiche-aprender', 'afiche-compartir', 'app-inicio', 'app-preparar', 'app-senal', 'historia', 'tarjeta-frente', 'tarjeta-reverso', 'lamina', 'lamina-seccion'];
(async () => {
  const ch = await launch(9344);
  const out = path.join(__dirname, 'piezas');
  fs.mkdirSync(out, { recursive: true });
  try {
    await ch.size(1280, 900);
    await ch.open('file:///' + path.join(__dirname, 'relevo-vivo.html').split(path.sep).join('/'));
    await sleep(2500);
    const H = await ch.eval('Math.ceil(document.documentElement.scrollHeight)');
    await ch.size(1280, H);
    await sleep(1200);
    for (const id of IDS) {
      const r = await ch.eval(`(() => { const b = document.getElementById('${id}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 2 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(out, id + '.png'), Buffer.from(s.data, 'base64'));
    }
    console.log('piezas', IDS.length);
  } finally { await ch.close(); }
})();
