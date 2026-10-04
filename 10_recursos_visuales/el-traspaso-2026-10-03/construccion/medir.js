// Mide qué parte de cada pantalla ocupa el color de actividad (elementos con data-par), en % del área del teléfono.
const path = require('path');
const { launch, sleep } = require('../cdp.js');
(async () => {
  const ch = await launch(9348);
  try {
    await ch.size(1280, 900);
    await ch.open('file:///' + path.join(__dirname, 'vista.html').split(path.sep).join('/'));
    await sleep(2500);
    const r = await ch.eval(`(() => { const out = {}; for (const id of ['app-preparar', 'app-inicio', 'app-senal']) { const ph = document.getElementById(id); const b = ph.getBoundingClientRect(); const A = b.width * b.height; let a = 0; const els = ph.matches('[data-par]') ? [ph] : [...ph.querySelectorAll('[data-par]')]; for (const e of els) { const r = e.getBoundingClientRect(); a += r.width * r.height; } out[id] = +(100 * a / A).toFixed(1); } return out; })()`);
    console.log(JSON.stringify(r));
  } finally { await ch.close(); }
})();
