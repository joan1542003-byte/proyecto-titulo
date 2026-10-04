// Tableros de la segunda ronda: letras descargadas de UNCUT (archivos locales) y de Open Foundry (su hoja de estilo pública).
// Mismo tablero que la primera ronda: logotipo grande, cinco tintas, cuatro tamaños, ícono y usos.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const AZUL = '#1C3891', INK = '#141519', PAPER = '#FAFAF7';
const OFL = 'licencia SIL Open Font License';

// grupo, id, nombre, origen, modo ('local' | 'of'), clave (nombre en items.json o slug de Open Foundry), peso, espaciado
const F = [
  ['Sans con carácter', 'hauora-sans', 'Hauora Sans', 'UNCUT · Wayne Shih', 'local', 'Hauora Sans', -0.02],
  ['Sans con carácter', 'rag', 'Rag', 'UNCUT · Dennis Grauel', 'local', 'Rag', -0.02],
  ['Sans con carácter', 'tanklager', 'Tanklager', 'UNCUT · Ariel Martín Pérez', 'local', 'Tanklager', -0.02],
  ['Sans con carácter', 'gap-sans', 'Gap Sans', 'UNCUT · Antoine Sigur', 'local', 'Gap Sans', -0.01],
  ['Sans con carácter', 'violet-sans', 'Violet Sans', 'UNCUT · Violet Office', 'local', 'Violet Sans', -0.02],
  ['Sans con carácter', 'cooper-hewitt', 'Cooper Hewitt', 'Open Foundry · Chester Jenkins', 'of', 'cooper-hewitt', -0.02],
  ['Blandas y firmes', 'solitus', 'Solitus', 'UNCUT · J Hudson', 'local', 'Solitus', -0.01],
  ['Blandas y firmes', 'perun', 'Perun', 'UNCUT · Stefan Peev', 'local', 'Perun', -0.02],
  ['Serif con identidad', 'bagnard', 'Bagnard', 'Open Foundry · Sebastien Sanfilippo', 'of', 'bagnard', -0.01],
  ['Serif con identidad', 'bluu-next', 'Bluu Next', 'Open Foundry · Jean-Baptiste Morizot', 'of', 'bluu-next', -0.02],
  ['Serif con identidad', 'sprat', 'Sprat', 'UNCUT · Ethan Nakache', 'local', 'Sprat', -0.02],
  ['Serif con identidad', 'career', 'Career', 'UNCUT · Antoine Gelgon', 'local', 'Career', -0.01],
];

const board = (fam, wt, ls, name, origen) => {
  const lg = (px, color) => `<span style="font-family:'${fam}';font-weight:${wt};letter-spacing:${ls}em;font-size:${px}px;line-height:1;color:${color};white-space:nowrap;display:inline-block">relevo</span>`;
  const tile = (bg, fg, t) => `<div style="background:${bg};color:${fg};height:132px;display:grid;place-items:center;position:relative;${bg === '#FFFFFF' ? 'box-shadow:inset 0 0 0 1px #E4E4DF;' : ''}">${lg(52, fg).replace('<span ', '<span class="tl" ')}<small style="position:absolute;left:10px;bottom:8px;font:400 11px 'Consolas',monospace;opacity:.8">${t}</small></div>`;
  return `<div style="padding:34px 40px 36px;font-family:'Segoe UI',system-ui,sans-serif;color:${INK};background:${PAPER};width:1200px;box-sizing:border-box">
<div style="display:flex;justify-content:space-between;align-items:baseline;font:600 15px 'Segoe UI',system-ui,sans-serif"><span>${name}</span><span style="font:400 12px 'Consolas',monospace;color:#5B5F68">${origen}</span></div>
<div id="hero" style="margin:20px 0 26px;height:250px;display:flex;align-items:center">${lg(250, INK)}</div>
<div style="display:grid;grid-template-columns:repeat(5,1fr);gap:10px">${tile('#FFFFFF', INK, 'tinta sobre papel')}${tile(INK, PAPER, 'papel sobre tinta')}${tile(AZUL, PAPER, 'papel sobre azul')}${tile('#3F2364', '#E7BF57', 'pieza de color')}${tile('#014128', '#6FDEA7', 'pieza de color')}</div>
<div style="display:flex;align-items:flex-end;gap:36px;margin:26px 0;padding-top:20px;border-top:1px solid #E4E4DF">${[64, 32, 20, 16].map((s) => `<div style="display:grid;gap:8px">${lg(s, INK)}<small style="font:400 11px 'Consolas',monospace;color:#5B5F68">${s} px</small></div>`).join('')}<div style="margin-left:auto;display:grid;gap:8px;justify-items:end"><div style="width:108px;height:108px;border-radius:25px;background:${AZUL};display:grid;place-items:center;overflow:hidden"><span style="font-family:'${fam}';font-weight:${wt};font-size:84px;line-height:1;color:${PAPER};margin-top:-8px">r</span></div><small style="font:400 11px 'Consolas',monospace;color:#5B5F68">ícono</small></div></div>
<div style="display:grid;grid-template-columns:300px minmax(0,1fr) minmax(0,1fr);gap:14px;align-items:start">
<div style="background:${AZUL};color:${PAPER};aspect-ratio:4/5;width:300px;min-width:0;box-sizing:border-box;overflow:hidden;padding:24px;display:flex;flex-direction:column;justify-content:space-between"><div style="font:800 31px/1 'Segoe UI',system-ui,sans-serif;letter-spacing:-.04em">Las ganas estaban.</div><div><div style="font:500 12.5px/1.35 'Segoe UI',system-ui,sans-serif;margin-bottom:12px">43 de 47 personas querían hacer otra cosa mientras seguían en el teléfono.</div>${lg(34, PAPER)}</div></div>
<div style="display:grid;gap:14px;align-content:start"><div style="background:#fff;box-shadow:0 0 0 1px #E4E4DF;border-radius:18px;padding:16px 18px"><div style="display:flex;justify-content:space-between;align-items:center">${lg(30, INK)}<span style="width:30px;height:30px;border-radius:50%;background:#EDEDE8;display:block"></span></div><div style="font:800 28px/1 'Segoe UI',system-ui,sans-serif;letter-spacing:-.04em;margin:18px 0 12px">Hola.</div><div style="box-shadow:inset 0 0 0 1px #E4E4DF;border-radius:14px;padding:12px 14px;font:800 20px/1.1 'Segoe UI',system-ui,sans-serif;letter-spacing:-.03em">leer 10 páginas.<div style="font:500 12px 'Segoe UI',system-ui,sans-serif;color:#5B5F68;margin-top:6px;letter-spacing:0">6 min de 15 en tus apps</div></div></div></div>
<div style="display:grid;gap:14px;align-content:start"><div style="background:${AZUL};color:${PAPER};border-radius:12px;aspect-ratio:85.6/54;padding:18px 20px;display:flex;flex-direction:column;justify-content:space-between">${lg(30, PAPER)}<div style="font:800 30px/1 'Segoe UI',system-ui,sans-serif;letter-spacing:-.05em;display:flex;align-items:baseline;gap:10px">Vuelve a <i style="flex:1;height:3px;background:currentColor;display:block"></i></div></div><div style="background:#fff;box-shadow:0 0 0 1px #E4E4DF;border-radius:12px;aspect-ratio:85.6/54;padding:16px 20px;display:flex;flex-direction:column;justify-content:space-between"><div style="font:400 12px/1.45 'Segoe UI',system-ui,sans-serif">Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad y, cuando se cumple la condición que elegiste, emite una señal breve.</div>${lg(26, INK)}</div></div>
</div></div>`;
};

(async () => {
  const items = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'uncut', 'items.json'), 'utf8'));
  const of = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'of', 'items.json'), 'utf8'));
  const ofl = JSON.parse(fs.readFileSync(path.join(__dirname, '..', 'of', 'lista.json'), 'utf8'));
  const only = process.argv.slice(2);
  const list = F.filter((f) => !only.length || only.includes(f[1]));
  const faces = [], links = [];
  const spec = list.map((f) => {
    if (f[4] === 'local') {
      const it = items.find((x) => x.nombre === f[5]);
      if (!it) throw new Error('sin archivo: ' + f[5]);
      const fam = 'L_' + f[1].replace(/-/g, '_');
      faces.push(`@font-face{font-family:"${fam}";src:url("file:///${it.archivo.split(path.sep).join('/')}");${it.variable ? 'font-weight:100 900;font-stretch:50% 200%;' : ''}}`);
      return { f, fam, wt: it.variable ? 700 : 400 };
    }
    const o = ofl.find((x) => x.slug === f[5]); const ow = of.find((x) => x.slug === f[5]);
    links.push(o.u);
    return { f, fam: ow.fam, wt: ow.w };
  });
  const html = `<!doctype html><meta charset="utf-8">${links.map((u) => `<link rel="stylesheet" href="${u}">`).join('')}<style>${faces.join('\n')}</style><body style="margin:0;background:#FAFAF7">${spec.map((s, i) => `<div id="b${i}">${board(s.fam, s.wt, s.f[6], s.f[2], s.f[3] + ' · ' + OFL)}</div>`).join('')}</body>`;
  fs.writeFileSync(path.join(__dirname, 'ronda2.html'), html);
  const ch = await launch(9431);
  try {
    await ch.size(1200, 900);
    await ch.open('file:///' + path.join(__dirname, 'ronda2.html').split(path.sep).join('/'));
    await sleep(5000);
    await ch.eval('document.fonts.ready.then(() => true)');
    for (let i = 0; i < spec.length; i++) {
      await ch.eval(`(() => { const b = document.getElementById('b${i}'); const h = b.querySelector('#hero span'); let fs = 250; while (h.scrollWidth > 1110 && fs > 80) { fs -= 6; h.style.fontSize = fs + 'px'; } b.querySelectorAll('.tl').forEach(e => { let s = 52; while (e.scrollWidth > 190 && s > 20) { s -= 2; e.style.fontSize = s + 'px'; } }); })()`);
    }
    const H = await ch.eval('document.documentElement.scrollHeight');
    await ch.size(1200, H); await sleep(700);
    for (let i = 0; i < spec.length; i++) {
      const r = await ch.eval(`(() => { const b = document.getElementById('b${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
      const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
      fs.writeFileSync(path.join(__dirname, spec[i].f[1] + '.png'), Buffer.from(s.data, 'base64'));
      console.log('listo', spec[i].f[1]);
    }
  } finally { await ch.close(); }
})();
