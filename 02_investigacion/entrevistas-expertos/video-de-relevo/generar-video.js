// Genera «relevo-en-un-minuto.mp4», el video breve que se envió a Denis Parra.
// Qué muestra y de dónde sale cada dato: ../guion-parra.md#correo-con-el-video
//
// Uso, desde la raíz del repositorio (necesita Playwright con Chromium y ffmpeg):
//   NODE_PATH=$(npm root -g) node 02_investigacion/entrevistas-expertos/video-de-relevo/generar-video.js
//
// Cada escena es una página HTML de 1920 × 1080 que se fotografía con Chromium;
// ffmpeg las une con fundidos de 0,6 s. El video no tiene sonido.

const { chromium } = require('playwright');
const fs = require('fs');
const os = require('os');
const path = require('path');
const { execFileSync } = require('child_process');

const AQUI = __dirname;
const RAIZ = path.resolve(AQUI, '../../..');
const TMP = fs.mkdtempSync(path.join(os.tmpdir(), 'relevo-video-'));
const SALIDA = path.join(AQUI, 'relevo-en-un-minuto.mp4');

const url = (p) => 'file://' + p;
const enRaiz = (p) => url(path.join(RAIZ, p));
const figura = (f) => enRaiz('08_memoria/memoria-1920x1080/figuras/' + f);
const anexo = (f) => enRaiz('08_memoria/anexos/imagenes/' + f);
const logo = enRaiz('10_recursos_visuales/logo-relevo-2026-10-11/relevo-logo-horizontal.svg');
const marca = enRaiz('10_recursos_visuales/logo-relevo-2026-10-11/relevo-marca.svg');
const letra = path.join(RAIZ, '08_memoria/memoria-1920x1080/letra/estaticas/');

// La vista del modelo 3D, sin la leyenda de la imagen original.
execFileSync('ffmpeg', [
  '-v', 'error', '-y',
  '-i', path.join(RAIZ, '06_desarrollo_y_factibilidad/testigo-impresion-3d/vistas/testigo-heroe.png'),
  '-vf', 'crop=1300:820:150:40',
  path.join(TMP, 'objeto.png'),
]);

const css = `
@font-face{font-family:IS;src:url(${url(letra + 'InstrumentSans-Regular.ttf')});font-weight:400}
@font-face{font-family:IS;src:url(${url(letra + 'InstrumentSans-Medium.ttf')});font-weight:500}
@font-face{font-family:IS;src:url(${url(letra + 'InstrumentSans-SemiBold.ttf')});font-weight:600}
*{box-sizing:border-box;margin:0;padding:0}
html,body{width:1920px;height:1080px;background:#F7F4F0;color:#141312;font-family:IS,sans-serif;overflow:hidden}
.wrap{display:flex;align-items:center;gap:90px;height:100%;padding:0 130px}
.txt{flex:0 0 760px}
.eyebrow{font-size:30px;font-weight:600;letter-spacing:.01em;color:#6b665e;margin-bottom:26px}
h1{font-size:62px;line-height:1.14;font-weight:600;letter-spacing:-.01em}
p.sub{font-size:34px;line-height:1.35;color:#3d3a35;margin-top:30px}
p.note{font-size:24px;line-height:1.4;color:#857f75;margin-top:40px}
.shots{display:flex;gap:40px;align-items:center}
.shot{height:860px;border-radius:40px;box-shadow:0 18px 50px rgba(20,19,18,.16)}
.center{display:flex;flex-direction:column;align-items:center;justify-content:center;height:100%;text-align:center;padding:0 200px}
.center h1{font-size:66px}
.center p.sub{max-width:1300px}
.nums{display:flex;gap:120px;margin-top:70px;justify-content:center}
.num b{display:block;font-size:150px;font-weight:600;letter-spacing:-.02em;line-height:1}
.num span{display:block;font-size:32px;color:#3d3a35;margin-top:18px;max-width:520px;line-height:1.3}
`;

// [segundos en pantalla, contenido]
const escenas = [
  [4.5, `<div class="center"><img src="${logo}" style="height:150px"><h1 style="margin-top:70px;font-weight:500">Un recordatorio físico preparado desde el teléfono</h1><p class="note">Proyecto de título · Diseño UDP · Johan Yantén · 2026</p></div>`],
  [7, `<div class="center"><div class="eyebrow">El punto de partida</div><h1>A veces una sesión en el teléfono sigue sin que uno vuelva a decidir, y algo que quería hacer queda en pausa.</h1><p class="sub">Relevo no bloquea el teléfono: ayuda a recordar eso a tiempo.</p></div>`],
  [6.5, `<div class="wrap"><div class="txt"><div class="eyebrow">1 · Preparar</div><h1>La persona elige qué quiere hacer y cómo empieza.</h1><p class="note">Pantallas reales de la aplicación, con un perfil de prueba.</p></div><div class="shots"><img class="shot" src="${figura('preparar-p1.png')}"><img class="shot" src="${figura('preparar-p2.png')}"></div></div>`],
  [6.5, `<div class="wrap"><div class="txt"><div class="eyebrow">2 · Preparar</div><h1>Elige dónde empieza y cuánto tiempo quiere darse en ciertas apps.</h1></div><div class="shots"><img class="shot" src="${figura('preparar-p3.png')}"><img class="shot" src="${figura('preparar-p4.png')}"></div></div>`],
  [7, `<div class="wrap" style="gap:60px"><div class="txt" style="flex:0 0 640px"><div class="eyebrow">3 · Dejar el objeto</div><h1>Deja el objeto donde empieza esa actividad, por ejemplo junto al libro.</h1><p class="sub">El teléfono sigue libre.</p><p class="note">Modelo 3D del objeto. En la prueba se usó un llavero Bluetooth comprado.</p></div><div class="shots"><img style="width:900px" src="${url(path.join(TMP, 'objeto.png'))}"></div></div>`],
  [6.5, `<div class="wrap"><div class="txt"><div class="eyebrow">4 · La señal</div><h1>Cuando se cumple el tiempo, suena unos 30 segundos: en el objeto o en el teléfono.</h1></div><div class="shots"><img class="shot" src="${anexo('app-3.3-4-suena.jpg')}"></div></div>`],
  [7, `<div class="wrap"><div class="txt"><div class="eyebrow">5 · Decidir</div><h1>La persona decide, sin presión: comenzar, dejarlo para después o cambiar de idea.</h1></div><div class="shots"><img class="shot" src="${anexo('app-3.3-6-decidir.jpg')}"><img class="shot" src="${anexo('app-3.3-5-preguntas.jpg')}"></div></div>`],
  [8.5, `<div class="center"><div class="eyebrow">La prueba</div><h1>Tres personas usaron Relevo dos semanas en sus casas.</h1><div class="nums"><div class="num"><b>19 de 21</b><span>veces dijeron que sabían qué querían hacer antes de leerlo en la pantalla</span></div><div class="num"><b>10 de 21</b><span>veces empezaron la actividad</span></div></div><p class="note">Respuestas en la aplicación después de cada aviso, del 8 al 19 de octubre de 2026.</p></div>`],
  [4.5, `<div class="center"><img src="${marca}" style="height:130px"><h1 style="margin-top:60px">Gracias por mirarlo.</h1><p class="sub">Las preguntas van en el correo.</p></div>`],
];
const FUNDIDO = 0.6;

(async () => {
  const navegador = await chromium.launch();
  const pagina = await navegador.newPage({ viewport: { width: 1920, height: 1080 } });
  for (let i = 0; i < escenas.length; i++) {
    const html = path.join(TMP, `escena-${i}.html`);
    fs.writeFileSync(html, `<!doctype html><html lang="es"><head><meta charset="utf-8"><style>${css}</style></head><body>${escenas[i][1]}</body></html>`);
    await pagina.goto(url(html));
    await pagina.evaluate(() => document.fonts.ready);
    await pagina.waitForTimeout(300);
    await pagina.screenshot({ path: path.join(TMP, `escena-${i}.png`) });
  }
  await navegador.close();

  const args = ['-v', 'error', '-y'];
  escenas.forEach(([seg], i) => {
    args.push('-loop', '1', '-framerate', '30', '-t', String(seg), '-i', path.join(TMP, `escena-${i}.png`));
  });
  const filtros = [];
  let anterior = '[0:v]';
  let inicio = 0;
  for (let i = 1; i < escenas.length; i++) {
    inicio += escenas[i - 1][0] - FUNDIDO;
    const ultimo = i === escenas.length - 1;
    const salida = ultimo ? '[v]' : `[v${i}]`;
    filtros.push(`${anterior}[${i}:v]xfade=transition=fade:duration=${FUNDIDO}:offset=${inicio.toFixed(2)}${ultimo ? ',format=yuv420p' : ''}${salida}`);
    anterior = salida;
  }
  args.push('-filter_complex', filtros.join(';'), '-map', '[v]', '-r', '30',
    '-c:v', 'libx264', '-pix_fmt', 'yuv420p', '-crf', '22', '-movflags', '+faststart', SALIDA);
  execFileSync('ffmpeg', args);
  fs.rmSync(TMP, { recursive: true, force: true });
  console.log('Listo:', SALIDA);
})();
