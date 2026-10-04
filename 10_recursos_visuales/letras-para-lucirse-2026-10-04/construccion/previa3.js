// Vista previa de la lámina 3.9: recortes de las secciones, en escritorio o teléfono, con tema claro u oscuro.
// uso: node previa3.js <puerto> <vista.html> <carpeta-salida> <ancho> [claro|oscuro]
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const [PORT, HTML, OUT, ANCHO = '1280', TEMA = 'oscuro'] = process.argv.slice(2);
fs.mkdirSync(OUT, { recursive: true });
(async () => {
  const ch = await launch(Number(PORT));
  try {
    const w = Number(ANCHO);
    await ch.size(w, 900);
    await ch.send('Emulation.setEmulatedMedia', { features: [{ name: 'prefers-color-scheme', value: TEMA === 'claro' ? 'light' : 'dark' }] });
    await ch.open('file:///' + path.resolve(HTML).split(path.sep).join('/'));
    await sleep(3500);
    const H = await ch.eval('document.documentElement.scrollHeight');
    if (w >= 700) { await ch.size(w, H); await sleep(600); }
    const s = await ch.eval(`(() => { const o = {}; for (const id of ['criterio', 'g1', 'g2', 'g3', 'g4', 'licencias', 'mas', 'decidir']) { const e = document.getElementById(id); if (e) { const b = e.getBoundingClientRect(); o[id] = { y: Math.round(b.top + scrollY), h: Math.round(b.height) }; } } return { o, ancho: document.documentElement.scrollWidth }; })()`);
    console.log('alto', H, 'ancho de documento', s.ancho, JSON.stringify(s.o));
    const cortes = [['arriba', 0, 1400], ['criterio', s.o.criterio.y, Math.min(s.o.criterio.h, 1000)], ['g1', s.o.g1.y, 1500], ['g4', s.o.g4.y, Math.min(s.o.g4.h, 1500)], ['licencias', s.o.licencias.y, s.o.licencias.h + s.o.mas.h + 120], ['decidir', s.o.decidir.y, Math.min(H - s.o.decidir.y, 900)]];
    for (const [n, y, h] of cortes) {
      const r = await ch.send('Page.captureScreenshot', { format: 'jpeg', quality: 80, clip: { x: 0, y, width: w, height: h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(OUT, n + '-' + w + '-' + TEMA + '.jpg'), Buffer.from(r.data, 'base64'));
    }
    console.log('listo');
  } finally { await ch.close(); }
})();
