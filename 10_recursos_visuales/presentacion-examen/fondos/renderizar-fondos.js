// Renderiza los fondos de aura y los paneles de color de la presentación del examen.
// Usa el mismo motor del Taller de auras (10_recursos_visuales/relevo-con-aura-2026-10-10/),
// con presets ordenados por significado: marca (los cuatro colores), amarillo (tu tiempo),
// cielo (tu primer paso), lima (el lugar y el sonido) y rubor (lo que decides), en cinco
// posiciones (der, ardr, abdr, hor, izq), más un panel de cada color para las fichas.
// Uso: node renderizar-fondos.js <carpeta de salida>
// Necesita Playwright con Chromium. Los PNG no se guardan en el repositorio: se subieron a Figma.
const { chromium } = require('playwright'); const fs = require('fs'); const path = require('path');
(async () => {
  const out = process.argv[2] || '.';
  const ids = [];
  for (const f of ['marca', 'amarillo', 'lima', 'cielo', 'rubor']) for (const p of ['der', 'ardr', 'abdr', 'hor', 'izq']) ids.push([`${p}-${f}`, 1920, 1080]);
  for (const f of ['amarillo', 'lima', 'cielo', 'rubor', 'marca', 'neutro']) ids.push([`panel-${f}`, 1200, 800]);
  const b = await chromium.launch({ args: ['--use-angle=swiftshader', '--enable-unsafe-swiftshader', '--ignore-gpu-blocklist'] });
  const p = await b.newPage();
  await p.goto('file://' + path.join(__dirname, 'generador-de-fondos.html'));
  for (const [id, w, h] of ids) {
    const d = await p.evaluate(([id, w, h]) => window.render(id, w, h, 3), [id, w, h]);
    fs.writeFileSync(path.join(out, id + '.png'), Buffer.from(d.split(',')[1], 'base64'));
  }
  await b.close();
})();
