// Tablero de cada finalista: logotipo grande, cinco tintas, cuatro tamaños, ícono y usos (afiche, barra de la app, tarjeta).
// Las tipografías de Pangram Pangram y Velvetyne se prueban dentro de su propia página (la que ya carga su webfont); las de Fontshare, con su hoja de estilo pública.
// No se guardan archivos de fuentes.
const fs = require('fs');
const path = require('path');
const { launch, sleep } = require('../../cdp.js');
const AZUL = '#1C3891', INK = '#141519', PAPER = '#FAFAF7';

const F = [
  // grupo, id, nombre, origen, sitio ('pp' | 'fs' | 've' | 'cl'), url (si es página), familia CSS, peso, espaciado, nota
  ['Sans con carácter', 'gosha-sans', 'Gosha Sans', 'Pangram Pangram', 'pp', 'https://pangrampangram.com/products/gosha-sans', 'gosha-sans', 700, -0.01],
  ['Sans con carácter', 'cabinet-grotesk', 'Cabinet Grotesk', 'Fontshare', 'fs', '', 'Cabinet Grotesk', 700, -0.02],
  ['Sans con carácter', 'pally', 'Pally', 'Fontshare', 'fs', '', 'Pally', 700, -0.01],
  ['Sans con carácter', 'mattone', 'Mattone', 'Collletttivo', 'cl', 'https://www.collletttivo.it/typefaces/mattone', 'Mattone', 700, -0.02],
  ['Sans con carácter', 'ronzino', 'Ronzino', 'Collletttivo', 'cl', 'https://www.collletttivo.it/typefaces/ronzino', 'Ronzino', 500, -0.02],
  ['Blandas y cálidas', 'chubbo', 'Chubbo', 'Fontshare', 'fs', '', 'Chubbo', 700, -0.02],
  ['Blandas y cálidas', 'paquito', 'Paquito', 'Fontshare', 'fs', '', 'Paquito', 700, -0.01],
  ['Blandas y cálidas', 'combat', 'Combat', 'Velvetyne', 've', 'https://velvetyne.fr/fonts/combat/', 'combat', 700, -0.01],
  ['Blandas y cálidas', 'ouroboros', 'Ouroboros', 'Velvetyne', 've', 'https://velvetyne.fr/fonts/ouroboros/', 'ouroboros-regular', 400, -0.01],
  ['Serif con identidad', 'editorial-new', 'Editorial New', 'Pangram Pangram', 'pp', 'https://pangrampangram.com/products/editorial-new', 'editorial-new', 600, -0.02],
  ['Serif con identidad', 'migra', 'Migra', 'Pangram Pangram', 'pp', 'https://pangrampangram.com/products/migra', 'migra', 700, -0.02],
  ['Serif con identidad', 'eiko', 'Eiko', 'Pangram Pangram', 'pp', 'https://pangrampangram.com/products/eiko', 'eiko', 700, -0.02],
  ['Serif con identidad', 'pangaia', 'Pangaia', 'Pangram Pangram', 'pp', 'https://pangrampangram.com/products/pangaia', 'pangaia', 700, -0.02],
  ['Serif con identidad', 'erode', 'Erode', 'Fontshare', 'fs', '', 'Erode', 700, -0.02],
  ['Serif con identidad', 'neco', 'Neco', 'Fontshare', 'fs', '', 'Neco', 700, -0.02],
  ['Anchas y firmes', 'agrandir', 'Agrandir', 'Pangram Pangram', 'pp', 'https://pangrampangram.com/products/agrandir', 'agrandir-wide-bold', 700, -0.01],
  ['Anchas y firmes', 'frama', 'Frama', 'Pangram Pangram', 'pp', 'https://pangrampangram.com/products/frama', 'frama', 700, -0.03],
  ['Anchas y firmes', 'watch', 'Watch', 'Pangram Pangram', 'pp', 'https://pangrampangram.com/products/watch', 'watch', 700, -0.02],
];

const board = (fam, wt, ls, name, origen) => {
  const lg = (px, color) => `<span style="font-family:'${fam}';font-weight:${wt};letter-spacing:${ls}em;font-size:${px}px;line-height:1;color:${color};white-space:nowrap;display:inline-block">relevo</span>`;
  const tile = (bg, fg, t) => `<div style="background:${bg};color:${fg};height:132px;display:grid;place-items:center;position:relative;${bg === '#FFFFFF' ? 'box-shadow:inset 0 0 0 1px #E4E4DF;' : ''}">${lg(52, fg).replace("<span ", "<span class=\"tl\" ")}<small style="position:absolute;left:10px;bottom:8px;font:400 11px 'Consolas',monospace;opacity:.8">${t}</small></div>`;
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
  const outDir = __dirname;
  const only = process.argv.slice(2);
  const list = F.filter((f) => !only.length || only.includes(f[1]));
  const ch = await launch(9411);
  try {
    // Fontshare: una sola página local con la hoja de estilo pública.
    const fsList = list.filter((f) => f[4] === 'fs');
    if (fsList.length) {
      const css = 'https://api.fontshare.com/v2/css?' + fsList.map((f) => `f[]=${f[1]}@${f[7]}`).join('&') + '&display=block';
      const html = `<!doctype html><meta charset="utf-8"><link rel="stylesheet" href="${css}"><body style="margin:0;background:#FAFAF7">${fsList.map((f, i) => `<div id="b${i}">${board(f[6], f[7], f[8], f[2], f[3] + ' · licencia ITF Free Font License')}</div>`).join('')}</body>`;
      fs.writeFileSync(path.join(outDir, 'fontshare.html'), html);
      await ch.size(1200, 900);
      await ch.open('file:///' + path.join(outDir, 'fontshare.html').split(path.sep).join('/'));
      await sleep(4500);
      await ch.eval(`document.fonts.ready.then(() => true)`);
      for (let i = 0; i < fsList.length; i++) {
        // ajusta el logotipo grande al ancho disponible
        await ch.eval(`(() => { const b = document.getElementById('b${i}'); const h = b.querySelector('#hero span'); let fs = 250; while (h.scrollWidth > 1110 && fs > 80) { fs -= 6; h.style.fontSize = fs + 'px'; } b.querySelectorAll('.tl').forEach(e => { let s = 52; while (e.scrollWidth > 190 && s > 20) { s -= 2; e.style.fontSize = s + 'px'; } }); })()`);
      }
      const H = await ch.eval('document.documentElement.scrollHeight');
      await ch.size(1200, H); await sleep(600);
      for (let i = 0; i < fsList.length; i++) {
        const r = await ch.eval(`(() => { const b = document.getElementById('b${i}').getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height }; })()`);
        const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
        fs.writeFileSync(path.join(outDir, fsList[i][1] + '.png'), Buffer.from(s.data, 'base64'));
        console.log('listo', fsList[i][1]);
      }
    }
    // Páginas de cada tipografía: se inyecta el tablero dentro de la página que ya cargó su fuente.
    for (const f of list.filter((x) => x[4] !== 'fs')) {
      try {
        await ch.size(1300, 900);
        await ch.open(f[5]);
        await sleep(2500);
        const lic = f[4] === 'pp' ? 'licencia «free to try»: uso personal, portafolio y proyectos escolares' : 'licencia SIL Open Font License';
        const markup = board(f[6], f[7], f[8], f[2], f[3] + ' · ' + lic);
        const r = await ch.eval(`(async () => {
          const old = document.getElementById('rl'); if (old) old.remove();
          const box = document.createElement('div'); box.id = 'rl'; box.style.cssText = 'position:absolute;left:0;top:0;z-index:2147483647;background:#FAFAF7;width:1200px;';
          box.innerHTML = ${JSON.stringify(markup)}; document.body.appendChild(box);
          await Promise.all([document.fonts.load('${f[7]} 100px "${f[6]}"').catch(() => 0)]); await document.fonts.ready; await new Promise(r => setTimeout(r, 500));
          const h = box.querySelector('#hero span'); let fs = 250; while (h.scrollWidth > 1110 && fs > 80) { fs -= 6; h.style.fontSize = fs + 'px'; } box.querySelectorAll('.tl').forEach(e => { let s = 52; while (e.scrollWidth > 190 && s > 20) { s -= 2; e.style.fontSize = s + 'px'; } });
          window.scrollTo(0, 0);
          const b = box.getBoundingClientRect(); return { x: b.left + scrollX, y: b.top + scrollY, w: b.width, h: b.height, ok: document.fonts.check('${f[7]} 40px "${f[6]}"') };
        })()`);
        const s = await ch.send('Page.captureScreenshot', { format: 'png', clip: { x: r.x, y: r.y, width: r.w, height: r.h, scale: 1 }, captureBeyondViewport: true });
        fs.writeFileSync(path.join(outDir, f[1] + '.png'), Buffer.from(s.data, 'base64'));
        console.log('listo', f[1], 'fuente cargada:', r.ok);
      } catch (e) { console.log(f[1], 'ERROR', e.message.slice(0, 100)); }
    }
  } finally { await ch.close(); }
})();
