// Íconos en trama y foto en trama: se calculan en Chrome sin interfaz (Path2D y lienzo) y se guardan como SVG.
const fs = require('fs'), path = require('path');
const icons = require('./bundle-icons.json');
const jpg = fs.readFileSync(path.join(__dirname, '../../../06_desarrollo_y_factibilidad/app-android/app/src/main/res/drawable-nodpi/foto_libro.jpg')).toString('base64');
const html = `<!doctype html><meta charset=utf-8><body><pre id=out></pre><script>
const ICONS = ${JSON.stringify(icons)};
const INK = '#17181C', BLUE = '#3D38F5';
function dotIcon(name, n) {
  const S = 8, R = 24 * S;
  const mk = () => { const c = document.createElement('canvas'); c.width = R; c.height = R; const x = c.getContext('2d', { willReadFrequently: true }); x.scale(S, S); return x; };
  const o = mk(), a = mk();
  for (const [d, f] of ICONS[name]) {
    const t = f.includes('a') ? a : o, p = new Path2D(d);
    t.lineCap = 'round'; t.lineJoin = 'round'; t.lineWidth = 2.4; t.fillStyle = '#000'; t.strokeStyle = '#000';
    if (f.includes('i')) t.fill(p);
    if (f.includes('s')) t.stroke(p);
  }
  const d1 = o.getImageData(0, 0, R, R).data, d2 = a.getImageData(0, 0, R, R).data, cell = R / n;
  let faint = '', inks = '', blues = '';
  const step = 24 / n;
  for (let j = 0; j < n; j++) for (let i = 0; i < n; i++) {
    let s1 = 0, s2 = 0, cnt = 0;
    for (let y = Math.floor(j * cell); y < Math.floor((j + 1) * cell); y += 2) for (let x = Math.floor(i * cell); x < Math.floor((i + 1) * cell); x += 2) { const k = (y * R + x) * 4 + 3; s1 += d1[k]; s2 += d2[k]; cnt++; }
    const c1 = s1 / (cnt * 255), c2 = s2 / (cnt * 255), cov = Math.max(c1, c2);
    const cx = +(i * step + step / 2).toFixed(3), cy = +(j * step + step / 2).toFixed(3);
    if (cov < 0.08) { faint += '<circle cx="' + cx + '" cy="' + cy + '" r="' + (step * 0.12).toFixed(3) + '"/>'; continue; }
    const r = (step * 0.5 * Math.min(1, 0.35 + 0.75 * Math.sqrt(cov))).toFixed(3);
    const c = '<circle cx="' + cx + '" cy="' + cy + '" r="' + r + '"/>';
    if (c2 > c1) blues += c; else inks += c;
  }
  return '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="96" height="96"><g fill="#78788C24">' + faint + '</g><g fill="' + INK + '">' + inks + '</g><g fill="' + BLUE + '">' + blues + '</g></svg>';
}
async function photoTrama() {
  const img = new Image(); img.src = 'data:image/jpeg;base64,${jpg}'; await img.decode();
  const W = 640, H = 800, pitch = 8, cols = W / pitch, rows = H / pitch;
  const c = document.createElement('canvas'); c.width = cols; c.height = rows;
  const x = c.getContext('2d', { willReadFrequently: true }); x.drawImage(img, 0, 0, cols, rows);
  const data = x.getImageData(0, 0, cols, rows).data; let lo = 1, hi = 0; const dk = new Float32Array(cols * rows);
  for (let k = 0; k < cols * rows; k++) { const d = 1 - (0.2126 * data[k * 4] + 0.7152 * data[k * 4 + 1] + 0.0722 * data[k * 4 + 2]) / 255; dk[k] = d; lo = Math.min(lo, d); hi = Math.max(hi, d); }
  const span = Math.max(0.05, hi - lo); let faint = '', dots = '';
  for (let j = 0; j < rows; j++) for (let i = 0; i < cols; i++) {
    const d = (dk[j * cols + i] - lo) / span, cx = i * pitch + pitch / 2, cy = j * pitch + pitch / 2;
    if (d < 0.06) { faint += '<circle cx="' + cx + '" cy="' + cy + '" r="' + (pitch * 0.14).toFixed(2) + '"/>'; continue; }
    dots += '<circle cx="' + cx + '" cy="' + cy + '" r="' + (pitch * 0.5 * (0.16 + 0.88 * Math.pow(d, 0.85))).toFixed(2) + '"/>';
  }
  return '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 800" width="640" height="800"><title>Leer: la foto en trama de una sola tinta azul</title><rect width="640" height="800" fill="#FFFFFF"/><g fill="#3C3C781F">' + faint + '</g><g fill="' + BLUE + '">' + dots + '</g></svg>';
}
(async () => {
  const out = {};
  for (const n of ['actividad', 'lugar', 'parlante', 'senal', 'inicio', 'apps']) out['icono-trama-' + n] = dotIcon(n, 16);
  out['foto-libro-trama'] = await photoTrama();
  document.getElementById('out').textContent = JSON.stringify(out);
})();
</script>`;
fs.writeFileSync(path.join(__dirname, 'gen-dots.html'), html);
