// Previsualiza la lámina en escritorio y en teléfono: recortes de las secciones principales.
// uso: node previa.js <puerto> <vista.html> <carpeta-salida> <ancho>
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [PORT, HTML, OUT, ANCHO = '1280'] = process.argv.slice(2);
fs.mkdirSync(OUT, { recursive: true });
(async () => {
  const ch = await launch(Number(PORT));
  try {
    const w = Number(ANCHO);
    await ch.size(w, 900);
    await ch.open('file:///' + path.resolve(HTML).split(path.sep).join('/'));
    await sleep(3500);
    const H = await ch.eval('document.documentElement.scrollHeight');
    if (w >= 700) { await ch.size(w, H); await sleep(600); }
    const secs = await ch.eval(`(() => { const o = {}; for (const id of ['lectura', 'fichas', 'l-struggle', 'g-señal', 'l-kola', 'g-cartel', 'matriz', 'fuera', 'decidir']) { const e = document.getElementById(id); if (e) { const b = e.getBoundingClientRect(); o[id] = { y: Math.round(b.top + scrollY), h: Math.round(b.height) }; } } return { o, ancho: document.documentElement.scrollWidth }; })()`);
    console.log('alto', H, 'ancho de documento', secs.ancho, JSON.stringify(secs.o));
    const cortes = [['arriba', 0, 1500], ['lectura', secs.o.lectura.y, 1500], ['struggle', secs.o['l-struggle'].y - 20, Math.min(secs.o['l-struggle'].h + 40, 1500)], ['cartel', (secs.o['g-cartel'] || secs.o.fichas).y, 1300], ['matriz', secs.o.matriz.y, secs.o.matriz.h + 40], ['fuera', secs.o.fuera.y, Math.min(secs.o.fuera.h, 1700)], ['decidir', secs.o.decidir.y, Math.min(H - secs.o.decidir.y, 1300)]];
    for (const [n, y, h] of cortes) {
      const s = await ch.send('Page.captureScreenshot', { format: 'jpeg', quality: 80, clip: { x: 0, y, width: w, height: h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(OUT, n + '-' + w + '.jpg'), Buffer.from(s.data, 'base64'));
    }
    console.log('listo', cortes.map((c) => c[0]).join(', '));
  } finally { await ch.close(); }
})();
