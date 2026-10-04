// Tablero de cada letra hermosa: el logotipo grande, en cinco tintas, en cuatro tamaños, como ícono y en uso.
// Pangram Pangram se prueba dentro de su propia página (la que ya carga su webfont); Fontshare y Velvetyne, con los archivos bajados a una carpeta de trabajo.
// uso: node tableros3.js <puerto-base> <carpeta-salida> [id ...]
const fs = require('fs');
const os = require('os');
const path = require('path');
const { launch, sleep } = require('../cdp.js');
const AZUL = '#1C3891', INK = '#141519', PAPER = '#FAFAF7';
const [PUERTO, OUT, ...solo] = process.argv.slice(2);
fs.mkdirSync(OUT, { recursive: true });
const RF = path.join(os.tmpdir(), 'rf').split(path.sep).join('/');
const fsE = JSON.parse(fs.readFileSync('fs-estilos.json', 'utf8'));
const pp = (slug) => 'https://pangrampangram.com/products/' + slug;

// grupo, id, nombre, autoría, origen, vía, referencia (url de página o archivo), familia CSS, peso, estilo, espaciado
const F = [
  ['Cursivas con vuelo', 'acma-cursiva', 'Acma Cursiva', 'Francesca Bolognini', 'Pangram Pangram', 'pp', pp('acma'), 'acma', 500, 'italic', -0.01],
  ['Cursivas con vuelo', 'hatton-cursiva', 'Hatton Cursiva', 'Mat Desjardins', 'Pangram Pangram', 'pp', pp('hatton'), 'hatton', 500, 'italic', -0.01],
  ['Cursivas con vuelo', 'migra-cursiva', 'Migra Cursiva', 'Valerio Monopoli', 'Pangram Pangram', 'pp', pp('migra'), 'migra', 700, 'italic', -0.02],
  ['Cursivas con vuelo', 'kyoto-cursiva', 'Kyoto Cursiva', 'Caio Kondo', 'Pangram Pangram', 'pp', pp('kyoto'), 'kyoto', 400, 'italic', -0.01],
  ['Cursivas con vuelo', 'pangaia-cursiva', 'Pangaia Cursiva', 'Samuel Salminen', 'Pangram Pangram', 'pp', pp('pangaia'), 'pangaia', 400, 'italic', -0.01],
  ['Cursivas con vuelo', 'eiko-cursiva', 'Eiko Cursiva', 'Caio Kondo', 'Pangram Pangram', 'pp', pp('eiko'), 'eiko', 400, 'italic', -0.01],
  ['Cursivas con vuelo', 'editorial-cursiva', 'Editorial New Cursiva', 'Mat Desjardins', 'Pangram Pangram', 'pp', pp('editorial-new'), 'editorial-new', 400, 'italic', -0.01],
  ['Cursivas con vuelo', 'right-didone-cursiva', 'Right Didone Cursiva', 'Alex Slobzheninov', 'Pangram Pangram', 'pp', pp('right-didone'), 'right-didone-italic-medium', 470, 'normal', -0.02],
  ['Cursivas con vuelo', 'telma', 'Telma', 'Jitka Janečková', 'Fontshare', 'fs', 'telma-700', 'Telma', 700, 'normal', -0.01],
  ['Contraste alto y afilado', 'gatwick-glider', 'Gatwick Glider', 'Valerio Monopoli', 'Pangram Pangram', 'pp', pp('gatwick'), 'gatwick-glider-regular', 500, 'normal', -0.01],
  ['Contraste alto y afilado', 'boska', 'Boska', 'Barbara Bigosinska', 'Fontshare', 'fs', 'boska-500', 'Boska', 500, 'normal', -0.02],
  ['Contraste alto y afilado', 'bonny', 'Bonny', 'Barbara Bigosinska', 'Fontshare', 'fs', 'bonny-500', 'Bonny', 500, 'normal', -0.02],
  ['Contraste alto y afilado', 'melodrama', 'Melodrama', 'Shaily Patel', 'Fontshare', 'fs', 'melodrama-500', 'Melodrama', 500, 'normal', -0.02],
  ['Contraste alto y afilado', 'stardom', 'Stardom', 'Indian Type Foundry', 'Fontshare', 'fs', 'stardom-400', 'Stardom', 400, 'normal', -0.02],
  ['Cálidas y con cuerpo', 'woodland', 'Woodland', 'Mat Desjardins', 'Pangram Pangram', 'pp', pp('woodland'), 'woodland', 700, 'normal', -0.02],
  ['Cálidas y con cuerpo', 'gambetta', 'Gambetta', 'Paul Troppmar', 'Fontshare', 'fs', 'gambetta-500', 'Gambetta', 500, 'normal', -0.02],
  ['Cálidas y con cuerpo', 'sentient', 'Sentient', 'Noopur Choksi', 'Fontshare', 'fs', 'sentient-500', 'Sentient', 500, 'normal', -0.02],
  ['Cálidas y con cuerpo', 'zodiak', 'Zodiak', 'Jérémie Hornus, Gaetan Baehr, Jean-Baptiste Morizot, Alisa Nowak y Théo Guillard', 'Fontshare', 'fs', 'zodiak-800', 'Zodiak', 800, 'normal', -0.02],
  ['Cálidas y con cuerpo', 'ouroboros', 'Ouroboros', 'Ariel Martín Pérez con H·Alix Sanyas', 'Velvetyne', 'vw', RF + '/w-ouroboros.woff2', 'Ouroboros', 400, 'normal', -0.01],
  ['Decorativas, para una sola palabra', 'zina', 'Zina', 'Théo Guillard', 'Fontshare', 'fs', 'zina-400', 'Zina', 400, 'normal', -0.02],
  ['Decorativas, para una sola palabra', 'chronos-serif', 'Chronos Serif', 'Mat Desjardins', 'Pangram Pangram', 'pp', pp('chronos-serif'), 'chronos-serif', 200, 'normal', -0.01],
  ['Decorativas, para una sola palabra', 'aktura', 'Aktura', 'Gaetan Baehr', 'Fontshare', 'fs', 'aktura-400', 'Aktura', 400, 'normal', -0.02],
  ['Decorativas, para una sola palabra', 'playground', 'Playground', 'Francesca Bolognini', 'Pangram Pangram', 'pp', pp('playground'), 'playground', 500, 'normal', -0.01],
];

const board = (fam, wt, st, ls, name, origen) => {
  const lg = (px, color) => `<span style="font-family:'${fam}';font-weight:${wt};font-style:${st};letter-spacing:${ls}em;font-size:${px}px;line-height:1;color:${color};white-space:nowrap;display:inline-block;padding-right:.12em">relevo</span>`;
  const tile = (bg, fg, t) => `<div style="background:${bg};color:${fg};height:132px;display:grid;place-items:center;position:relative;${bg === '#FFFFFF' ? 'box-shadow:inset 0 0 0 1px #E4E4DF;' : ''}">${lg(52, fg).replace('<span ', '<span class="tl" ')}<small style="position:absolute;left:10px;bottom:8px;font:400 11px Consolas,monospace;opacity:.8">${t}</small></div>`;
  return `<div style="padding:34px 40px 36px;font-family:'Segoe UI',system-ui,sans-serif;color:${INK};background:${PAPER};width:1200px;box-sizing:border-box">
<div style="display:flex;justify-content:space-between;align-items:baseline;font:600 15px 'Segoe UI',system-ui,sans-serif"><span>${name}</span><span style="font:400 12px Consolas,monospace;color:#5B5F68">${origen}</span></div>
<div id="hero" style="margin:20px 0 26px;height:250px;display:flex;align-items:center">${lg(250, INK)}</div>
<div style="display:grid;grid-template-columns:repeat(5,1fr);gap:10px">${tile('#FFFFFF', INK, 'tinta sobre papel')}${tile(INK, PAPER, 'papel sobre tinta')}${tile(AZUL, PAPER, 'papel sobre azul')}${tile('#3F2364', '#E7BF57', 'pieza de color')}${tile('#014128', '#6FDEA7', 'pieza de color')}</div>
<div style="display:flex;align-items:flex-end;gap:36px;margin:26px 0;padding-top:20px;border-top:1px solid #E4E4DF">${[64, 32, 20, 16].map((s) => `<div style="display:grid;gap:8px">${lg(s, INK)}<small style="font:400 11px Consolas,monospace;color:#5B5F68">${s} px</small></div>`).join('')}<div style="margin-left:auto;display:grid;gap:8px;justify-items:end"><div style="width:108px;height:108px;border-radius:25px;background:${AZUL};display:grid;place-items:center;overflow:hidden"><span style="font-family:'${fam}';font-weight:${wt};font-style:${st};font-size:84px;line-height:1;color:${PAPER};margin-top:-8px">r</span></div><small style="font:400 11px Consolas,monospace;color:#5B5F68">ícono</small></div></div>
<div style="display:grid;grid-template-columns:300px minmax(0,1fr) minmax(0,1fr);gap:14px;align-items:start">
<div style="background:${AZUL};color:${PAPER};aspect-ratio:4/5;width:300px;min-width:0;box-sizing:border-box;overflow:hidden;padding:24px;display:flex;flex-direction:column;justify-content:space-between"><div style="font:800 31px/1 'Segoe UI',system-ui,sans-serif;letter-spacing:-.04em">Las ganas estaban.</div><div><div style="font:500 12.5px/1.35 'Segoe UI',system-ui,sans-serif;margin-bottom:12px">43 de 47 personas querían hacer otra cosa mientras seguían en el teléfono.</div>${lg(34, PAPER)}</div></div>
<div style="display:grid;gap:14px;align-content:start"><div style="background:#fff;box-shadow:0 0 0 1px #E4E4DF;border-radius:18px;padding:16px 18px"><div style="display:flex;justify-content:space-between;align-items:center">${lg(30, INK)}<span style="width:30px;height:30px;border-radius:50%;background:#EDEDE8;display:block"></span></div><div style="font:800 28px/1 'Segoe UI',system-ui,sans-serif;letter-spacing:-.04em;margin:18px 0 12px">Hola.</div><div style="box-shadow:inset 0 0 0 1px #E4E4DF;border-radius:14px;padding:12px 14px;font:800 20px/1.1 'Segoe UI',system-ui,sans-serif;letter-spacing:-.03em">leer 10 páginas.<div style="font:500 12px 'Segoe UI',system-ui,sans-serif;color:#5B5F68;margin-top:6px;letter-spacing:0">6 min de 15 en tus apps</div></div></div></div>
<div style="display:grid;gap:14px;align-content:start"><div style="background:${AZUL};color:${PAPER};border-radius:12px;aspect-ratio:85.6/54;padding:18px 20px;display:flex;flex-direction:column;justify-content:space-between">${lg(30, PAPER)}<div style="font:800 30px/1 'Segoe UI',system-ui,sans-serif;letter-spacing:-.05em">Vuelve a lo que querías hacer.</div></div><div style="background:#fff;box-shadow:0 0 0 1px #E4E4DF;border-radius:12px;aspect-ratio:85.6/54;padding:16px 20px;display:flex;flex-direction:column;justify-content:space-between"><div style="font:400 12px/1.45 'Segoe UI',system-ui,sans-serif">Relevo es un recordatorio físico que preparas desde el teléfono. Lo dejas cerca de una actividad y, cuando se cumple la condición que elegiste, emite una señal breve.</div>${lg(26, INK)}</div></div>
</div></div>`;
};

const ajusta = `(box) => { const h = box.querySelector('#hero span'); let fs = 250; while ((h.scrollWidth > 1110 || h.getBoundingClientRect().height > 240) && fs > 70) { fs -= 6; h.style.fontSize = fs + 'px'; } box.querySelectorAll('.tl').forEach(e => { let s = 52; while (e.scrollWidth > 190 && s > 20) { s -= 2; e.style.fontSize = s + 'px'; } }); }`;

(async () => {
  const lista = F.filter((f) => !solo.length || solo.includes(f[1]));
  const ch = await launch(Number(PUERTO));
  const hechos = [];
  try {
    // Fontshare y Velvetyne: una sola página local con @font-face de los archivos bajados.
    const locales = lista.filter((f) => f[5] !== 'pp');
    if (locales.length) {
      const css = locales.map((f, i) => { const arch = f[5] === 'fs' ? RF + '/fs-' + f[6] + '.woff2' : f[6]; return `@font-face{font-family:"${f[7]}";font-weight:${f[8]};font-style:${f[9]};src:url("file:///${arch}")}`; }).join('\n');
      const html = `<!doctype html><meta charset="utf-8"><style>${css}</style><body style="margin:0;background:#FAFAF7">${locales.map((f, i) => `<div id="b${i}">${board(f[7], f[8], f[9], f[10], f[2], f[4])}</div>`).join('')}</body>`;
      const hf = path.resolve(OUT, 'locales.html');
      fs.writeFileSync(hf, html);
      await ch.size(1200, 900);
      await ch.open('file:///' + hf.split(path.sep).join('/'));
      await sleep(4500);
      await ch.eval(`(async () => { await document.fonts.ready; document.querySelectorAll('[id^=b]').forEach(b => (${ajusta})(b)); })()`);
      const H = await ch.eval('document.documentElement.scrollHeight');
      await ch.size(1200, H); await sleep(700);
      for (let i = 0; i < locales.length; i++) {
        const r = await ch.eval(`(() => { const b = document.getElementById('b${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
        const s = await ch.send('Page.captureScreenshot', { format: 'jpeg', quality: 90, clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
        fs.writeFileSync(path.join(OUT, locales[i][1] + '.jpg'), Buffer.from(s.data, 'base64'));
        hechos.push(locales[i][1]); console.log('listo', locales[i][1]);
      }
    }
    // Pangram Pangram: se inyecta el tablero dentro de la página que ya cargó su fuente.
    for (const f of lista.filter((x) => x[5] === 'pp')) {
      try {
        await ch.size(1300, 900);
        await ch.open(f[6]);
        await sleep(3000);
        for (let k = 0; k < 4; k++) { await ch.eval('window.scrollBy(0, 900)'); await sleep(300); }
        const markup = board(f[7], f[8], f[9], f[10], f[2], f[4] + ' · licencia «gratis para probar»');
        const r = await ch.eval(`(async () => {
          const old = document.getElementById('rl'); if (old) old.remove();
          const box = document.createElement('div'); box.id = 'rl'; box.style.cssText = 'position:absolute;left:0;top:0;z-index:2147483647;background:#FAFAF7;width:1200px;';
          box.innerHTML = ${JSON.stringify(markup)}; document.body.appendChild(box);
          await document.fonts.load('${f[9] === 'italic' ? 'italic ' : ''}${f[8]} 100px "${f[7]}"').catch(() => 0); await document.fonts.ready; await new Promise(r => setTimeout(r, 700));
          (${ajusta})(box); window.scrollTo(0, 0);
          const b = box.getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height, ok: document.fonts.check('${f[9] === 'italic' ? 'italic ' : ''}${f[8]} 40px "${f[7]}"') };
        })()`);
        const s = await ch.send('Page.captureScreenshot', { format: 'jpeg', quality: 90, clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
        fs.writeFileSync(path.join(OUT, f[1] + '.jpg'), Buffer.from(s.data, 'base64'));
        hechos.push(f[1]); console.log('listo', f[1], 'fuente cargada:', r.ok);
      } catch (e) { console.log(f[1], 'ERROR', e.message.slice(0, 100)); }
    }
  } finally { await ch.close(); }
})();
