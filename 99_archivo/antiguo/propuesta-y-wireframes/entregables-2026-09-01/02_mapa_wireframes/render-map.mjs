import { chromium } from '../../wireframes-media-html/node_modules/@playwright/test/index.mjs';
import { readFile, readdir } from 'node:fs/promises';
import { dirname, join } from 'node:path';
import { fileURLToPath } from 'node:url';

const here = dirname(fileURLToPath(import.meta.url));
const source = join(here, '..', '..', 'wireframes-media-html', 'public', 'exports');
const output = join(here, 'mapa-completo-wireframes-baja-fidelidad.png');
const files = await readdir(source);

const coreOrder = [
  '1-1-formular.png', '1-2-configurar-condicion.png', '1-3-revisar.png',
  '2-1-situar.png', '2-2-probar-pulso.png', '2-3-armar-control-fisico.png',
  '3-1-esperar.png', '3-2-recibir-pulso-situado.png', '3-3-cerrar-o-recuperar.png'
];

const phases = [
  { code: 'A', title: 'Preparar la intención', range: [1, 6] },
  { code: 'B', title: 'Vincular y situar el testigo', range: [7, 14] },
  { code: 'C', title: 'Armar el ciclo', range: [15, 19] },
  { code: 'D', title: 'Esperar y emitir la señal', range: [20, 24] },
  { code: 'E', title: 'Cerrar, recuperar o resolver fallos', range: [25, 35] }
];

function label(file) {
  return file
    .replace(/^cobertura-\d+-/, '')
    .replace(/^\d-\d-/, '')
    .replace(/\.png$/, '')
    .replaceAll('-', ' ')
    .replace(/^./, (letter) => letter.toUpperCase());
}

async function dataUri(file) {
  const data = await readFile(join(source, file));
  return `data:image/png;base64,${data.toString('base64')}`;
}

const core = await Promise.all(coreOrder.map(async (file, index) => ({
  id: `${Math.floor(index / 3) + 1}.${(index % 3) + 1}`,
  file,
  title: label(file),
  image: await dataUri(file)
})));

const coverageFiles = files.filter((file) => file.startsWith('cobertura-')).sort((a, b) => a.localeCompare(b, 'es', { numeric: true }));
const coverage = await Promise.all(coverageFiles.map(async (file) => ({
  id: Number(file.match(/cobertura-(\d+)/)[1]),
  file,
  title: label(file),
  image: await dataUri(file)
})));

const cards = (items, className = '') => items.map((item) => `
  <article class="card ${className}">
    <div class="card-head"><strong>${String(item.id).padStart(2, '0')}</strong><span>${item.title}</span></div>
    <img src="${item.image}" alt="Wireframe ${item.id}: ${item.title}">
  </article>`).join('');

const html = `<!doctype html><html lang="es"><head><meta charset="utf-8"><style>
  *{box-sizing:border-box} html,body{margin:0;background:#f4f2ed;color:#181a1b;font-family:Arial,sans-serif}
  body{width:5000px;padding:180px 190px 220px} h1,h2,p{margin:0} header{display:grid;grid-template-columns:1.4fr 1fr;gap:120px;border-bottom:4px solid #181a1b;padding-bottom:72px}
  h1{font-size:112px;letter-spacing:-4px} header p{font-size:34px;line-height:1.45;align-self:end;color:#55595a}
  .legend{display:flex;gap:42px;margin:48px 0 100px;font-size:28px}.legend span:before{content:'';display:inline-block;width:18px;height:18px;border:3px solid #181a1b;margin-right:14px}.legend span:last-child:before{border-style:dashed}
  section{margin-top:104px}.section-head{display:grid;grid-template-columns:140px 1fr auto;align-items:end;gap:24px;margin-bottom:38px}.section-head b{font:700 34px monospace}.section-head h2{font-size:54px}.section-head p{font-size:25px;color:#666}
  .route{display:grid;grid-template-columns:repeat(9,1fr);gap:24px;position:relative}.route:before{content:'';position:absolute;left:5%;right:5%;top:47px;height:3px;background:#181a1b;z-index:0}
  .grid{display:grid;grid-template-columns:repeat(11,1fr);gap:24px}.card{min-width:0;background:#fff;border:3px solid #181a1b;padding:16px;position:relative;z-index:1}.card-head{height:86px;display:flex;gap:16px;align-items:flex-start;font-size:22px;line-height:1.15}.card-head strong{font:700 21px monospace;background:#181a1b;color:#fff;padding:8px 9px}.card img{display:block;width:100%;height:430px;object-fit:cover;object-position:top;filter:grayscale(1) contrast(.92);border-top:2px solid #aaa}.route .card img{height:500px}.route .card{border-style:solid}.grid .card{border-color:#747878}
  .phase{border-top:3px solid #181a1b;padding-top:34px}.phase .section-head{margin-bottom:28px}.phase .grid{grid-template-columns:repeat(11,1fr)}
  footer{margin-top:120px;border-top:3px solid #181a1b;padding-top:38px;display:flex;justify-content:space-between;font-size:25px;color:#555}.red{color:#d71921}
</style></head><body>
  <header><div><h1>Mapa completo de wireframes</h1><p class="red">RELEVO · baja fidelidad · 44 vistas</p></div><p>La ruta principal reúne nueve momentos evaluables. Los treinta y cinco estados de cobertura muestran permisos, fallos, recuperaciones y salidas voluntarias sin confundirlos con nuevos pasos obligatorios.</p></header>
  <div class="legend"><span>Ruta principal</span><span>Estado alternativo o excepcional</span></div>
  <section><div class="section-head"><b>00</b><h2>Ruta principal</h2><p>9 momentos · de formular a cerrar</p></div><div class="route">${cards(core, 'core')}</div></section>
  ${phases.map((phase) => {
    const items = coverage.filter(({ id }) => id >= phase.range[0] && id <= phase.range[1]);
    return `<section class="phase"><div class="section-head"><b>${phase.code}</b><h2>${phase.title}</h2><p>${items.length} estados · ${String(phase.range[0]).padStart(2,'0')}–${String(phase.range[1]).padStart(2,'0')}</p></div><div class="grid">${cards(items)}</div></section>`;
  }).join('')}
  <footer><span>Los wireframes representan estructura, decisiones y estados; no definen todavía el acabado visual.</span><span>RELEVO · 01.09.2026</span></footer>
</body></html>`;

const browser = await chromium.launch({
  headless: true,
  executablePath: 'C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe'
});
const page = await browser.newPage({ viewport: { width: 5000, height: 5400 }, deviceScaleFactor: 1 });
await page.setContent(html, { waitUntil: 'load' });
await page.screenshot({ path: output, fullPage: true });
await browser.close();
console.log(output);
