// Renderizador de animaciones con fondo transparente.
// Uso: node render.js <generador.js (ruta desde la carpeta actual)> <nombre> <carpeta de salida> [opciones] -- [argumentos del generador]
//   --dpr 2          resolución de dibujo (2 = el doble)
//   --gif 720        ancho del GIF (px)
//   --mates claro,oscuro   GIF sin fondo con bordes preparados para fondo claro (blanco) y/o oscuro (tinta)
//   --webm           también un WebM con transparencia real (VP9 con canal alfa)
//   --mp4            también un MP4 sobre blanco
// El generador escribe páginas HTML con varios cuadros, uno bajo otro, y un info.json
// ({ N, FPS, W, H, POR_PAGINA, paginas }). Chrome las fotografía con fondo transparente y ffmpeg las arma.
const fs = require('fs');
const os = require('os');
const path = require('path');
const { spawnSync } = require('child_process');

const argv = process.argv.slice(2);
const corte = argv.indexOf('--');
const propios = corte >= 0 ? argv.slice(0, corte) : argv;
const delGenerador = corte >= 0 ? argv.slice(corte + 1) : [];
const [GEN, NOMBRE, SALIDA] = propios;
const opt = (k, d) => { const i = propios.indexOf(k); return i >= 0 ? propios[i + 1] : d; };
const flag = k => propios.includes(k);
const DPR = +opt('--dpr', 2);
const GIFW = +opt('--gif', 720);
const MATES = opt('--mates', 'claro').split(',').filter(Boolean);
const CHROME = process.env.CHROME || 'C:/Program Files/Google/Chrome/Application/chrome.exe';

const T = fs.mkdtempSync(path.join(os.tmpdir(), 'relevo-'));
const run = (cmd, args) => { const r = spawnSync(cmd, args, { stdio: ['ignore', 'pipe', 'pipe'], maxBuffer: 1 << 26 }); if (r.status !== 0) { console.error(String(r.stderr).slice(-2000)); throw new Error(`${path.basename(cmd)} falló`); } return String(r.stdout); };
const ff = args => run('ffmpeg', ['-y', '-loglevel', 'error', ...args]);

console.log(run('node', [path.resolve(GEN), T, ...delGenerador]).trim().split('\n').slice(-1)[0]);
const info = JSON.parse(fs.readFileSync(path.join(T, 'info.json'), 'utf8'));
const { N, FPS, W, H, POR_PAGINA: PP, paginas } = info;
const frames = path.join(T, 'f');
fs.mkdirSync(frames);
for (let p = 0; p < paginas; p++) {
  const pp = String(p).padStart(2, '0');
  const html = path.join(T, `p${pp}.html`), png = path.join(T, `p${pp}.png`);
  run(CHROME, ['--headless=new', '--disable-gpu', '--hide-scrollbars', `--force-device-scale-factor=${DPR}`, '--default-background-color=00000000', `--window-size=${W},${H * PP}`, `--screenshot=${png}`, 'file:///' + html.replace(/\\/g, '/')]);
  ff(['-i', png, '-vf', `untile=1x${PP}`, '-start_number', String(p * PP), path.join(frames, '%05d.png')]);
  fs.unlinkSync(png);
}
const entrada = ['-framerate', String(FPS), '-i', path.join(frames, '%05d.png'), '-frames:v', String(N)];
fs.mkdirSync(SALIDA, { recursive: true });
const destino = ext => path.join(SALIDA, `${NOMBRE}${ext}`);

// GIF sin fondo, a 25 cuadros por segundo (uno de cada dos, nítidos). El alfa de un GIF es todo o nada, así que los bordes suaves y las sombras se funden
// antes con el color del fondo donde se va a usar (blanco o tinta) y después se recorta.
const mate = { claro: 'white', oscuro: '0x141312' };
for (const m of MATES) {
  const sufijo = m === 'claro' ? '' : '-para-fondo-oscuro';
  const filtro = [
    `[0:v]format=rgba,premultiply=inplace=1,fps=25,scale=${GIFW}:-2:flags=lanczos,unpremultiply=inplace=1,split=3[c][a][f]`,
    `[a]alphaextract,lut=y='if(gte(val\\,8)\\,255\\,0)'[m]`,
    `[f]drawbox=c=${mate[m]}@1:t=fill:replace=1[bg]`,
    `[bg][c]overlay=format=rgb[comp]`,
    `[comp][m]alphamerge,split[x][y]`,
    `[x]palettegen=max_colors=255:reserve_transparent=1:stats_mode=full[p]`,
    `[y][p]paletteuse=dither=sierra2_4a:alpha_threshold=128`,
  ].join(';');
  ff([...entrada, '-filter_complex', filtro, '-loop', '0', destino(`${sufijo}.gif`)]);
}
if (flag('--webm')) ff([...entrada, '-c:v', 'libvpx-vp9', '-pix_fmt', 'yuva420p', '-b:v', '0', '-crf', '28', '-row-mt', '1', '-auto-alt-ref', '0', destino('.webm')]);
if (flag('--mp4')) ff([...entrada, '-filter_complex', `color=c=white:s=${W * DPR}x${H * DPR}:r=${FPS}[bg];[bg][0:v]overlay=shortest=1,format=yuv420p`, '-c:v', 'libx264', '-preset', 'slow', '-crf', '17', '-movflags', '+faststart', destino('.mp4')]);
fs.rmSync(T, { recursive: true, force: true });
console.log('Listo:', NOMBRE);
