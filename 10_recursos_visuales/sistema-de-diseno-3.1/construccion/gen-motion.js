// Logotipo animado con la firma sonora (D-071): el renglón se escribe bajo la palabra, aparecen las letras y el
// renglón pasa la «o» en una altura de x («hace lugar»). Dos notas de madera en descenso, 587 → 440 Hz, 2,2 s.
const fs = require('fs');
const path = require('path');
const { execFileSync } = require('child_process');
const { Font, contourToPath } = require('./ttf.js');
const { launch } = require('./cdp.js');
const font = new Font(path.join(__dirname, 'schibsted.ttf'));
const g = require('./out/logo-geometry.json');
const OUT = path.join(__dirname, 'out', 'Movimiento');
const FR = path.join(__dirname, 'frames');
fs.mkdirSync(OUT, { recursive: true });
fs.rmSync(FR, { recursive: true, force: true });
fs.mkdirSync(FR, { recursive: true });

// Letras por separado, con el mismo espaciado y kerning del logotipo.
const G = g.G, coords = font.normalize({ wght: G.weight }), size = 2048, s = size / font.upm;
const chars = [...'relevo'];
let pen = 0;
const raw = chars.map((ch, i) => {
  const gl = font.glyph(font.gid(ch), coords);
  let d = '';
  for (const ct of gl.contours) d += contourToPath(ct, pen, 0, s);
  pen += gl.adv * s + G.tracking * size + ((G.kern[ch + (chars[i + 1] || '')] || 0) * s);
  return d;
});
const minX = Math.min(...raw.join(' ').match(/-?[\d.]+/g).filter((_, i) => i % 2 === 0).map(Number));
const letters = chars.map((ch, i) => {
  let d = '';
  const gl = font.glyph(font.gid(ch), coords);
  // Recalcula con el desplazamiento que deja el asta de la «r» en x = 0.
  let p = -minX;
  for (let k = 0; k < i; k++) { const gk = font.glyph(font.gid(chars[k]), coords); p += gk.adv * s + G.tracking * size + ((G.kern[chars[k] + chars[k + 1]] || 0) * s); }
  for (const ct of gl.contours) d += contourToPath(ct, p, 0, s);
  return d;
});

const W = 1920, H = 1080, FPS = 30, DUR = 4.0;
const k = 250 / G.asc;
const tx = (W - g.LINE.w * k) / 2, ty = H / 2 + ((G.asc - (g.LINE.y + g.LINE.h)) / 2) * k;
const html = `<!doctype html><html><head><meta charset="utf-8"><style>html,body{margin:0;width:${W}px;height:${H}px;overflow:hidden;background:#F2F2EF}</style></head><body>
<svg width="${W}" height="${H}" viewBox="0 0 ${W} ${H}"><g transform="translate(${tx.toFixed(1)} ${ty.toFixed(1)}) scale(${k.toFixed(5)})">
<rect id="ln" x="0" y="${g.LINE.y}" height="${g.LINE.h}" rx="${g.LINE.h / 2}" width="0" fill="#3D38F5"/>
${letters.map((d, i) => `<path id="l${i}" d="${d}" fill="#17181C" opacity="0"/>`).join('')}
</g></svg>
<script>
const right = ${g.W.right}, full = ${g.LINE.w}, h = ${g.LINE.h};
const outC = (x) => 1 - Math.pow(1 - x, 3), inOut = (x) => x < .5 ? 4 * x * x * x : 1 - Math.pow(-2 * x + 2, 3) / 2;
const clamp = (x) => Math.max(0, Math.min(1, x));
window.setT = (t) => {
  // 0,35–1,05 s: el renglón se escribe bajo la palabra; 1,45–1,95 s: pasa la «o» (hace lugar).
  const a = outC(clamp((t - 0.35) / 0.7)), b = inOut(clamp((t - 1.45) / 0.5));
  const w = a * right + b * (full - right);
  const ln = document.getElementById('ln');
  ln.setAttribute('width', Math.max(0, w).toFixed(1));
  ln.setAttribute('opacity', w > h * 0.2 ? 1 : 0);
  // Letras: aparecen de a una, 70 ms entre cada una, subiendo 40 unidades.
  for (let i = 0; i < 6; i++) {
    const p = outC(clamp((t - 0.55 - i * 0.07) / 0.32));
    const el = document.getElementById('l' + i);
    el.setAttribute('opacity', p.toFixed(3));
    el.setAttribute('transform', 'translate(0 ' + ((1 - p) * 60).toFixed(1) + ')');
  }
  return true;
};
</script></body></html>`;
fs.writeFileSync(path.join(__dirname, 'apps', 'logo-animado.html'), html);

// Firma sonora: dos notas de timbre de madera (fundamental, parcial 3,93 y 9,2 que se apagan rápido) con un ataque
// de banda ancha de 4 ms. Primera nota cuando el renglón termina bajo la palabra; la segunda, mientras hace lugar.
const note = (t0, f) => `if(gte(t,${t0}),(sin(2*PI*${f}*(t-${t0}))*exp(-(t-${t0})/0.34)+0.32*sin(2*PI*${(f * 3.93).toFixed(1)}*(t-${t0}))*exp(-(t-${t0})/0.07)+0.12*sin(2*PI*${(f * 9.2).toFixed(1)}*(t-${t0}))*exp(-(t-${t0})/0.02)+0.22*(2*random(0)-1)*exp(-(t-${t0})/0.004)),0)`;
const expr = `0.42*(${note(1.05, 587.33)}+0.92*${note(1.6, 440)})`;
const wav = path.join(__dirname, 'firma-sonora.wav');
execFileSync('ffmpeg', ['-y', '-hide_banner', '-loglevel', 'error', '-f', 'lavfi', '-i', `aevalsrc=exprs='${expr}|${expr}':s=48000:d=${DUR}`, '-af', 'highpass=f=120,lowpass=f=9000,afade=t=out:st=3.4:d=0.6', wav]);

(async () => {
  const ch = await launch(9334);
  try {
    await ch.size(W, H);
    await ch.open('file:///' + path.join(__dirname, 'apps', 'logo-animado.html').replace(/\\/g, '/'));
    const n = Math.round(DUR * FPS);
    for (let i = 0; i < n; i++) {
      await ch.eval(`setT(${(i / FPS).toFixed(4)})`);
      await ch.shot(path.join(FR, `f${String(i).padStart(4, '0')}.png`), W, H);
    }
    await ch.eval('setT(3.5)');
    await ch.shot(path.join(OUT, 'logo-animado-cuadro-final.png'), W, H);
  } finally { await ch.close(); }
  const mp4 = path.join(OUT, 'logo-animado.mp4');
  execFileSync('ffmpeg', ['-y', '-hide_banner', '-loglevel', 'error', '-framerate', String(FPS), '-i', path.join(FR, 'f%04d.png'), '-i', wav, '-c:v', 'libx264', '-pix_fmt', 'yuv420p', '-crf', '18', '-preset', 'slow', '-movflags', '+faststart', '-c:a', 'aac', '-b:a', '160k', '-shortest', mp4]);
  // Solo la firma sonora (WAV de 2,45 s), para el repositorio, la app y las presentaciones.
  execFileSync('ffmpeg', ['-y', '-hide_banner', '-loglevel', 'error', '-i', wav, '-ss', '0.95', '-t', '2.45', '-af', 'afade=t=out:st=2.0:d=0.45', path.join(OUT, 'firma-sonora.wav')]);
  for (const f of fs.readdirSync(OUT)) console.log(f, Math.round(fs.statSync(path.join(OUT, f)).size / 1024) + ' KB');
})();
