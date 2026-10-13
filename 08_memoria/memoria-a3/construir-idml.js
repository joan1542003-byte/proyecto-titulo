// Memoria de Relevo en A3 horizontal como archivo editable (IDML) para Affinity o InDesign (D-132).
// Toma el texto de la v5 sin cambiarlo y lo compone con el rediseño pedido el 13 de octubre de 2026:
// tres columnas, texto de 11,5 pt, una escala única (8, 9,5, 11,5, 15, 20, 44 y 200 pt), una luz de
// color por capítulo, tablas y figuras a lo ancho y texto enlazado entre columnas.
// Las tablas y las cifras no son tablas de procesador de texto: son piezas de la marca (fichas blancas
// sobre el papel, círculos de tinta con iconos de la aplicación, cápsulas de estado y barras de color).
//
// Cómo se arma:
//   1. Node lee la v5 y la parte en capítulos, párrafos, tablas y figuras.
//   2. Chrome sin ventana dibuja las luces, el logo y los diagramas, y mide el alto de cada bloque con
//      la misma letra y las mismas medidas, para saber cuántas columnas ocupa cada capítulo.
//   3. Cada tabla y cada figura de cifras se compone en Chrome: su fondo (fichas, círculos, cápsulas,
//      barras) se guarda como PDF vectorial y su texto se coloca encima como texto vivo de Affinity.
//   4. Node reparte columnas, tablas y figuras en las páginas y escribe el IDML con idml.js.
//
// Uso: node construir-idml.js   (necesita Google Chrome; en Affinity, Instrument Sans instalada)

const fs = require('fs');
const path = require('path');
const os = require('os');
const { execFileSync } = require('child_process');
const { Idml, pt } = require('./idml.js');

const AQUI = __dirname;
const FUENTE = path.join(AQUI, '..', 'borrador-memoria-v5-2026-10-11.md');
const SALIDA = path.join(AQUI, 'memoria-relevo-a3.idml');
const GEN = path.join(AQUI, 'figuras', 'idml');
const LETRA = path.join(AQUI, '..', '..', '06_desarrollo_y_factibilidad', 'app-android', 'app', 'src', 'main', 'res', 'font', 'instrument_sans.ttf');
const MARCA = JSON.parse(fs.readFileSync(path.join(AQUI, 'marca-e-iconos.json'), 'utf8'));
const CHROME = [
  process.env.CHROME,
  '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome',
  'C:/Program Files/Google/Chrome/Application/chrome.exe',
  '/usr/bin/google-chrome',
].find((c) => c && fs.existsSync(c));
if (!CHROME) throw new Error('No se encontró Google Chrome. Indica su ruta en la variable CHROME.');

// ---------------------------------------------------------------- Medidas de la hoja (mm)

const W = 420, H = 297;
const M = { arriba: 20, derecha: 22, abajo: 19, izquierda: 22 };
const COL = 118, MED = 11, ANCHO = 376;
const TOP = M.arriba, BOTTOM = H - M.abajo;
const colX = (k) => M.izquierda + k * (COL + MED);
const SEGURIDAD = 1.04;          // el alto medido en Chrome se agranda un poco: mejor sobrar que desbordar
const PX = 25.4 / 96;            // mm por píxel de CSS
const ALTO_FIG = { diagrama: 46, capturas: 112, foto: 86, tiempo: 42 };   // alto de las figuras que no se miden (mm)

// Estilos de párrafo: los mismos números sirven para el IDML y para medir en Chrome (pt).
const E = {
  'Texto': { tamano: 11.5, interlineado: 16.5, despues: 8 },
  'Subtítulo': { tamano: 15, interlineado: 19, estilo: 'SemiBold', antes: 10, despues: 5, conSiguiente: 2 },
  'Subtítulo menor': { tamano: 11.5, interlineado: 16.5, estilo: 'SemiBold', antes: 4, despues: 3, conSiguiente: 2 },
  'Lista': { tamano: 11.5, interlineado: 16.5, despues: 5, sangria: 17, primera: -17 },
  'Destacado': { tamano: 15, interlineado: 21, estilo: 'Medium', antes: 4, despues: 12 },
  'Capítulo número': { tamano: 200, interlineado: 170, estilo: 'SemiBold' },
  'Capítulo título': { tamano: 20, interlineado: 24, estilo: 'SemiBold' },
  'Rótulo': { tamano: 9.5, interlineado: 13, estilo: 'SemiBold', despues: 1 },
  'Título de tabla': { tamano: 11.5, interlineado: 15, estilo: 'Italic', despues: 6 },
  'Nota': { tamano: 9.5, interlineado: 13, antes: 5 },
  'Celda': { tamano: 9.5, interlineado: 13 },
  'Celda suave': { tamano: 9.5, interlineado: 13, color: 'Color/Gris' },
  'Celda cabecera': { tamano: 8, interlineado: 11, estilo: 'SemiBold', color: 'Color/Gris' },
  'Celda primera': { tamano: 9.5, interlineado: 13, estilo: 'SemiBold' },
  'Dato': { tamano: 44, interlineado: 44, estilo: 'SemiBold' },
  'Agradecimiento': { tamano: 15, interlineado: 21, despues: 9 },
  'Referencia': { tamano: 9.5, interlineado: 13.5, despues: 5, sangria: 17, primera: -17 },
  'Glosario': { tamano: 9.5, interlineado: 13.5, despues: 5 },
  'Encabezado': { tamano: 8, interlineado: 11, color: 'Color/Gris' },
  'Folio': { tamano: 8, interlineado: 11, color: 'Color/Gris', alineacion: 'RightAlign' },
  'Índice título': { tamano: 9.5, interlineado: 13, estilo: 'SemiBold', antes: 10, despues: 4 },
  'Índice': { tamano: 9.5, interlineado: 14.5 },
  'Portada subtítulo': { tamano: 20, interlineado: 26, estilo: 'Medium' },
  'Portada dato': { tamano: 11.5, interlineado: 16.5 },
  'Título de sección': { tamano: 20, interlineado: 24, estilo: 'SemiBold', despues: 10 },
  'Palabras clave': { tamano: 9.5, interlineado: 13, antes: 4 },
  'Pendiente': { tamano: 9.5, interlineado: 13, color: 'Color/Gris', alineacion: 'CenterAlign' },
};
const LUCES = [['Amarillo', [244, 228, 150]], ['Cielo', [179, 229, 252]], ['Lima', [198, 238, 174]], ['Rubor', [250, 200, 217]], ['Lila', [223, 209, 252]], ['Durazno', [251, 209, 179]]];

// ---------------------------------------------------------------- Texto: de Markdown a bloques

/** Marcas en línea → tramos { texto, estilo }. */
function tramos(s) {
  const out = [];
  const pon = (texto, estilo) => { if (texto) out.push(estilo ? { texto, estilo } : { texto }); };
  const cursivas = (t, base) => t.split(/(_[^_]+_|\*[^*]+\*)/).forEach((p) => {
    if (/^_[^_]+_$/.test(p) || /^\*[^*]+\*$/.test(p)) pon(p.slice(1, -1), base ? 'Negrita cursiva' : 'Cursiva');
    else pon(p, base);
  });
  s.split(/(\[CONFIRMAR:[^\]]+\]|\[FIGURA POR INSERTAR:[^\]]+\]|\*\*\*[^*]+\*\*\*|\*\*(?:[^*]|\*(?!\*))+\*\*)/).forEach((p) => {
    if (!p) return;
    if (/^\[(CONFIRMAR|FIGURA POR INSERTAR):/.test(p)) pon(p.replace(/^\[CONFIRMAR: /, '[Confirmar: '), 'Confirmar');
    else if (/^\*\*\*/.test(p)) pon(p.slice(3, -3), 'Negrita cursiva');
    else if (/^\*\*/.test(p)) cursivas(p.slice(2, -2), 'Negrita');
    else cursivas(p, null);
  });
  return out;
}
const plano = (s) => tramos(s).map((r) => r.texto).join('');

/** Espacio fijo entre las dos últimas palabras, para que la última línea no quede con una sola. */
function sinViuda(partes) {
  const largo = partes.reduce((n, r) => n + r.texto.split(/\s+/).length, 0);
  if (largo < 9 || !partes.length) return partes;
  const u = partes[partes.length - 1];
  const i = u.texto.trimEnd().lastIndexOf(' ');
  if (i > 0) partes[partes.length - 1] = { ...u, texto: u.texto.slice(0, i) + '\u00A0' + u.texto.slice(i + 1) };
  return partes;
}

function leer() {
  const lineas = fs.readFileSync(FUENTE, 'utf8').replace(/\r\n/g, '\n').split('\n');
  const secciones = []; let actual = { titulo: '__inicio__', lineas: [] };
  for (const l of lineas) {
    if (/^# /.test(l)) { secciones.push(actual); actual = { titulo: l.slice(2).trim(), lineas: [] }; } else actual.lineas.push(l);
  }
  secciones.push(actual);
  return secciones;
}

/** Bloques de una sección: párrafos, subtítulos, listas, destacados, tablas y figuras. */
function bloques(lineas, estiloTexto = 'Texto') {
  const out = []; let i = 0;
  const sig = () => { while (i < lineas.length && !lineas[i].trim()) i++; };
  while (i < lineas.length) {
    const l = lineas[i];
    if (!l.trim()) { i++; continue; }
    let m;
    if ((m = l.match(/^\*\*(Tabla|Figura) (\d+)\*\*\s*$/))) {
      const f = { flotante: m[1] === 'Tabla' ? 'tabla' : 'figura', n: +m[2] };
      i++; sig();
      f.titulo = lineas[i].trim().replace(/^\*|\*$/g, ''); i++; sig();
      if (f.flotante === 'tabla') {
        const filas = [];
        while (i < lineas.length && /^\|/.test(lineas[i])) { filas.push(lineas[i].trim().replace(/^\||\|$/g, '').split('|').map((c) => c.trim())); i++; }
        f.numericas = filas[1].map((c) => /:\s*$/.test(c));
        f.filas = [filas[0], ...filas.slice(2)];
      } else {
        f.descripcion = lineas[i].trim().replace(/^\[FIGURA POR INSERTAR: |\]$/g, ''); i++;
      }
      sig();
      if (i < lineas.length && /^\*Nota\.\*/.test(lineas[i])) { f.nota = lineas[i].trim(); i++; }
      out.push(f); continue;
    }
    if (/^### /.test(l)) { out.push({ estilo: 'Subtítulo menor', partes: tramos(l.slice(4).trim()) }); i++; continue; }
    if (/^## /.test(l)) { out.push({ estilo: 'Subtítulo', partes: tramos(l.slice(3).trim()) }); i++; continue; }
    if (/^> /.test(l)) { out.push({ estilo: 'Destacado', partes: sinViuda(tramos(l.slice(2).trim())) }); i++; continue; }
    if ((m = l.match(/^(\d+)\. (.*)$/))) { out.push({ estilo: 'Lista', partes: sinViuda([{ texto: m[1] + '.\t' }, ...tramos(m[2])]) }); i++; continue; }
    if ((m = l.match(/^- (.*)$/))) { out.push({ estilo: estiloTexto === 'Texto' ? 'Lista' : estiloTexto, partes: sinViuda(estiloTexto === 'Texto' ? [{ texto: '—\t' }, ...tramos(m[1])] : tramos(m[1])) }); i++; continue; }
    out.push({ estilo: estiloTexto, partes: sinViuda(tramos(l.trim())) }); i++;
  }
  return out;
}

// ---------------------------------------------------------------- Chrome: dibujar y medir

const TMP = fs.mkdtempSync(path.join(os.tmpdir(), 'relevo-idml-'));
const url = (f) => 'file://' + f.split(path.sep).map(encodeURIComponent).join('/').replace(/%3A/g, ':');
const chrome = (args, opts = {}) => execFileSync(CHROME, ['--headless=new', '--disable-gpu', '--no-sandbox', '--hide-scrollbars', '--allow-file-access-from-files', ...args], { stdio: ['ignore', 'pipe', 'ignore'], maxBuffer: 1 << 28, ...opts });
const h = (s) => String(s).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
const CSS_LETRA = `@font-face{font-family:"Instrument Sans";src:url("${url(LETRA)}");font-weight:400 700;font-stretch:75% 100%}
*{box-sizing:border-box;margin:0;padding:0}body{font-family:"Instrument Sans",sans-serif;color:#141312;font-kerning:normal;-webkit-font-smoothing:antialiased}`;
const PESO = { Regular: 400, Italic: 400, Medium: 500, SemiBold: 600, Bold: 700 };
const rgb = (n) => 'rgb(' + LUCES.find((l) => l[0] === n)[1].join(',') + ')';
// Una clase de CSS por estilo de párrafo, con los mismos números que el IDML.
const CSS_E = Object.entries(E).map(([n, e], i) => `.e${i}{font-size:${e.tamano}pt;line-height:${e.interlineado}pt;font-weight:${PESO[e.estilo] || 400};${e.estilo === 'Italic' ? 'font-style:italic;' : ''}${e.color === 'Color/Gris' ? 'color:#6E6964;' : ''}padding-top:${e.antes || 0}pt;padding-bottom:${e.despues || 0}pt;padding-left:${e.sangria || 0}pt;text-indent:${e.primera || 0}pt;tab-size:${e.sangria || 17}pt;white-space:pre-wrap;overflow-wrap:break-word}`).join('\n') +
  '\nb{font-weight:600}i{font-style:italic}.dr{font-size:20pt;font-weight:500;color:#6E6964}\n';
// Piezas de la marca para tablas y cifras: fichas blancas, círculos de tinta, cápsulas y barras.
const CSS_FICHAS = `*{-webkit-print-color-adjust:exact;print-color-adjust:exact}
.n{padding-right:3%}
.cir{flex:none;width:8mm;height:8mm;border-radius:50%;background:#141312;color:#F7F4F0;display:flex;align-items:center;justify-content:center;font-size:8.5pt;font-weight:600;line-height:1}
.cir svg{width:4.9mm;height:4.9mm;fill:none;stroke:currentColor;stroke-width:1.7;stroke-linecap:round;stroke-linejoin:round;display:block}
.pil{display:inline-flex;align-items:center;height:5.6mm;padding:0 2.8mm;border-radius:2.8mm;border:.3mm solid #141312;font-size:8pt;font-weight:600;line-height:1;white-space:nowrap}
.pil.lleno{background:#141312;color:#F7F4F0}.pil.hueco{border:.3mm dashed #6E6964;color:#6E6964}
.chip{width:5.6mm;height:5.6mm;border-radius:50%;border:.3mm solid #141312;display:flex;align-items:center;justify-content:center;font-size:8pt;font-weight:600;line-height:1}
.tb{display:flex;flex-direction:column;gap:1.4mm}
.cab,.fila{display:grid;column-gap:6mm;padding-left:4mm;padding-right:5mm;border:.35mm solid transparent}
.cab{padding-bottom:.2mm;align-items:end}.cab .h0{margin-left:11.2mm}
.fila{background:#fff;border-color:#fff;border-radius:4mm;padding-top:2.8mm;padding-bottom:2.8mm;align-items:start}
.fila.total{border-color:#141312}
.pri{display:flex;gap:3.2mm;align-items:flex-start;min-width:0}
.pri .tx{display:flex;flex-direction:column;gap:.3mm;padding-top:1.7mm;min-width:0;flex:1}
.c{padding-top:1.7mm;min-width:0}
.est{display:flex;flex-direction:column;align-items:flex-start;gap:1.1mm;padding-top:1.2mm;min-width:0}.est .n{align-self:stretch}
.chips{display:flex;gap:1.2mm;padding-top:1.2mm}
.per{display:grid;grid-template-columns:repeat(4,1fr);gap:3mm}
.pc{background:#fff;border-radius:4mm;padding:4mm 4mm 4.6mm 4mm;display:flex;gap:3.5mm;align-items:flex-start}
.pc .cir{width:11mm;height:11mm;font-size:10pt}
.pc .tx{display:flex;flex-direction:column;gap:.8mm;padding-top:.5mm;min-width:0;flex:1}
.mz{display:grid;column-gap:3mm}
.mz .mh0{align-self:end;padding:0 0 2.2mm 1mm}
.mz .mh{border-radius:4mm 4mm 0 0;padding:3mm 4.5mm 3mm 3.5mm;display:flex;gap:3mm;align-items:center}.mz .mh .n{flex:1}
.mz .ma{padding:2.7mm 0 2.7mm 1mm;border-top:.25mm solid #CCC6BE}
.mz .mc{background:#fff;padding:2.7mm 4.5mm;border-top:.25mm solid #E9E4DD}.mz .mc.p{border-top-color:#fff}
.mz .mu{border-radius:0 0 4mm 4mm;padding-bottom:3.4mm}
.dt{display:grid;gap:4mm}
.dc{background:#fff;border-radius:5mm;padding:5mm 5.5mm 5.5mm;display:flex;flex-direction:column}
.dc .cir{margin-bottom:8mm}.dc .dx{flex:1;margin-top:1.5mm}
.bar{display:flex;align-items:flex-end;gap:.45mm;height:8mm;margin-top:5.5mm}
.bar span{flex:1;height:38%;border-radius:.6mm;background:#DDD7CF}.bar span.s{height:100%;background:var(--c)}.bar span.m{height:68%;background:var(--c)}
.pts{display:flex;gap:1.8mm;height:8mm;margin-top:5.5mm}
.pts span{width:8mm;height:8mm;border-radius:50%;border:.3mm solid #CCC6BE}.pts span.s{background:var(--c);border-color:var(--c)}.pts span.m{background:linear-gradient(90deg,var(--c) 50%,#fff 50%);border-color:var(--c)}
`;
const PREVIA = process.env.PREVIA;   // carpeta donde dejar, además, cada pieza con su texto a la vista

function pdf(nombre, anchoMm, altoMm, cuerpo, css = '', carpeta = GEN) {
  const f = path.join(TMP, nombre + '.html'); const salida = path.join(carpeta, nombre + '.pdf');
  fs.writeFileSync(f, `<!doctype html><meta charset="utf-8"><style>${CSS_LETRA}@page{size:${anchoMm}mm ${altoMm}mm;margin:0}html,body{width:${anchoMm}mm;height:${altoMm}mm;overflow:hidden}${css}</style>${cuerpo}`);
  chrome(['--no-pdf-header-footer', '--virtual-time-budget=4000', `--print-to-pdf=${salida}`, url(f)]);
  return salida;
}
function png(nombre, px, cuerpo, css = '') {
  const f = path.join(TMP, nombre + '.html'); const salida = path.join(GEN, nombre + '.png');
  fs.writeFileSync(f, `<!doctype html><meta charset="utf-8"><style>*{margin:0}html,body{width:${px}px;height:${px}px;background:transparent}${css}</style>${cuerpo}`);
  chrome(['--default-background-color=00000000', `--window-size=${px},${px}`, `--screenshot=${salida}`, url(f)]);
  return salida;
}

function dibujar() {
  fs.mkdirSync(GEN, { recursive: true });
  const out = { luces: [] };
  for (const [nombre, [r, g, b]] of LUCES) {
    out.luces.push(png('luz-' + nombre.toLowerCase(), 900, '<div class="l"></div>', `.l{width:900px;height:900px;background:radial-gradient(circle at 50% 50%,rgba(${r},${g},${b},1) 0%,rgba(${r},${g},${b},.85) 32%,rgba(${r},${g},${b},.35) 55%,rgba(${r},${g},${b},0) 70%)}`));
  }
  out.logo = pdf('logo', 120, 25.2, MARCA.lockup.replace('<svg ', '<svg style="width:120mm;height:25.2mm;display:block" '));
  out.marca = pdf('marca', 30, 30, MARCA.mark.replace('<svg ', '<svg style="width:30mm;height:30mm;display:block" '));
  // Diagrama: seis nodos, cada uno con el color y el icono de su papel, y tres salidas del mismo peso.
  const nodos = [['Intención personal', 'Lila', 'estrella'], ['Primer paso', 'Cielo', 'primer-paso'], ['Lugar elegido', 'Lima', 'lugar'], ['Condición configurada', 'Amarillo', 'tiempo'], ['Pulso ambiental', 'Durazno', 'suena'], ['Decisión de la persona', 'Rubor', 'decidir']];
  const salidas = [['Considerar la intención', 'empece'], ['Seguir en el teléfono', 'telefono'], ['Silenciar la señal', 'silenciar']];
  const cssDiag = `.f{display:flex;align-items:stretch;height:100%;gap:1.6mm;font-size:10.5pt;line-height:13.5pt;font-weight:600}
.nd{flex:1;border-radius:4mm;padding:3.5mm;display:flex;flex-direction:column;justify-content:space-between;align-items:flex-start}
.a{flex:none;align-self:center;width:4.4mm;height:4.4mm}.a svg{width:100%;height:100%;fill:none;stroke:#6E6964;stroke-width:1.7;stroke-linecap:round;stroke-linejoin:round;display:block}
.s{flex:1.35;display:flex;flex-direction:column;gap:1.6mm}.s div{flex:1;background:#fff;border-radius:4mm;padding:0 3mm;display:flex;align-items:center;gap:2.6mm;font-size:9.5pt;line-height:12.5pt;font-weight:500}`;
  const flecha = `<span class="a">${svgIcono('siguiente')}</span>`;
  out.diagrama = pdf('diagrama', ANCHO, ALTO_FIG.diagrama, `<div class="f">${nodos.map(([t, c, ic]) => `<div class="nd" style="background:${rgb(c)}">${circulo(svgIcono(ic))}<span>${h(t)}</span></div>${flecha}`).join('')}<div class="s">${salidas.map(([t, ic]) => `<div>${circulo(svgIcono(ic))}${h(t)}</div>`).join('')}</div></div>`, CSS_FICHAS + cssDiag);
  // Línea de tiempo de la prueba.
  const etapas = [['Día 0', 'Sesión inicial en el hogar', 'Límite de 8 minutos, cuatro momentos observados y comprobación de autonomía', 'Amarillo', 1.15], ['Días 1–7', 'Primera condición', 'Preguntas tras cada señal y tarjeta semanal', 'Cielo', 1], ['Días 8–14', 'Segunda condición', 'Preguntas tras cada señal y tarjeta semanal', 'Lima', 1], ['Días 15–21', 'Tercera condición', 'Preguntas tras cada señal y tarjeta semanal', 'Rubor', 1], ['Día 21', 'Cierre', 'Preguntas de cierre y entrevista', 'Lila', .8]];
  out.tiempo = pdf('linea-de-tiempo', ANCHO, ALTO_FIG.tiempo, `<div class="t">${etapas.map(([d, t, x, c, w]) => `<div class="e" style="flex:${w};background:${rgb(c)}"><span class="pil lleno">${h(d)}</span><b>${h(t)}</b><small>${h(x)}</small></div>`).join('')}</div>`,
    CSS_FICHAS + `.t{display:flex;gap:1.6mm;height:100%}.e{border-radius:4mm;padding:3.5mm 4mm 4mm 3.5mm;display:flex;flex-direction:column;align-items:flex-start;gap:1.2mm}.e b{font-size:13pt;line-height:16pt;font-weight:600;margin-top:auto}.e small{font-size:9.5pt;line-height:12.5pt}`);
  return out;
}

/** Mide en Chrome una lista de piezas { id, ancho (mm), html }: su alto y, si llevan texto vivo, dónde cae cada uno (mm). */
function medir(piezas) {
  const f = path.join(TMP, 'medir.html');
  fs.writeFileSync(f, `<!doctype html><meta charset="utf-8"><style>${CSS_LETRA}${CSS_E}${CSS_FICHAS}
.m{position:absolute;left:0;top:0;visibility:hidden}</style>
${piezas.map((p) => `<div class="m" data-id="${p.id}" style="width:${p.ancho}mm">${p.html}</div>`).join('\n')}
<pre id="out"></pre><script>document.fonts.ready.then(()=>{const o={};document.querySelectorAll('.m').forEach(e=>{const a=e.getBoundingClientRect();o[e.dataset.id]=a.height;const t=e.querySelectorAll('[data-t]');if(t.length){const R={};t.forEach(n=>{const r=n.getBoundingClientRect();R[n.dataset.t]=[r.left-a.left,r.top-a.top,r.width,r.height]});o[e.dataset.id+'R']=R}});document.getElementById('out').textContent='@@'+btoa(JSON.stringify(o))+'@@'})</script>`);
  const dom = chrome(['--virtual-time-budget=20000', '--dump-dom', url(f)]).toString('utf8');
  const m = dom.match(/@@([A-Za-z0-9+/=]+)@@/);
  if (!m) throw new Error('Chrome no devolvió las medidas.');
  const px = JSON.parse(Buffer.from(m[1], 'base64').toString('utf8'));
  return Object.fromEntries(Object.entries(px).map(([k, v]) => [k, typeof v === 'number' ? v * PX : Object.fromEntries(Object.entries(v).map(([t, r]) => [t, r.map((n) => n * PX)]))]));
}
const clase = (estilo) => 'e' + Object.keys(E).indexOf(estilo);
const htmlTramos = (partes) => partes.map((r) => { const t = h(r.texto); return r.estilo === 'Negrita' ? `<b>${t}</b>` : r.estilo === 'Cursiva' ? `<i>${t}</i>` : r.estilo === 'Negrita cursiva' ? `<b><i>${t}</i></b>` : r.estilo === 'Dato resto' ? `<span class="dr">${t}</span>` : t; }).join('');
const htmlParrafo = (b) => `<div class="${clase(b.estilo)}">${htmlTramos(b.partes)}</div>`;

// ---------------------------------------------------------------- Tablas y cifras como piezas de la marca

const svgIcono = (id) => `<svg viewBox="0 0 24 24">${MARCA.icons[id]}</svg>`;
const circulo = (contenido) => `<span class="cir">${contenido}</span>`;
const mayus = (s) => s.replace(/^\p{Ll}/u, (c) => c.toUpperCase());
const ESTADO = /^(Implementado|Cumplido|Parcial|Pendiente)\b[;:,]?\s*/;
const CAPSULA = { Implementado: 'lleno', Cumplido: 'lleno', Parcial: '', Pendiente: 'hueco' };
// Icono de la aplicación que acompaña a cada fila, según cómo empieza su primera celda. Sin icono, la fila lleva su número.
const ICONOS = [
  [/^Medición del uso/, 'avance'], [/^Pausa antes/, 'pausar'], [/^Intención preguntada/, 'ayuda'], [/^Bloqueo/, 'privacidad'], [/^Separación física/, 'telefono'], [/^Objeto de foco/, 'estrella'], [/^Recordatorio tangible/, 'avisos'], [/^Localizador/, 'tag'],
  [/^Usuario principal/, 'perfil'], [/^Usuario límite/, 'pelicula'], [/^Convivientes/, 'inicio'], [/^Autor/, 'dibujar'], [/^Herramientas de inteligencia/, 'aura'], [/^Profesores/, 'leer'], [/^Electrónica/, 'maqueta'],
  [/^Sin intención/, 'mas'], [/^Preparación/, 'editar'], [/^Vinculación/, 'conexion'], [/^Situado/, 'lugar'], [/^Activo/, 'contando'], [/^Señal activa/, 'suena'], [/^Fallo técnico/, 'advertencia'], [/^Ciclo cerrado/, 'listo'],
  [/^Tag con pila/, 'tag'], [/^Teléfono Android/, 'telefono'], [/^Servicio remoto/, 'enviar'], [/^Placas/, 'maqueta'],
];
// Cifras: el icono y el color del papel que cumple cada dato en el sistema («un color, un papel»).
const ROL_DATO = [[/primer paso/, 'primer-paso', 'Cielo'], [/sonido|sonó|suena/, 'suena', 'Durazno'], [/en casa|lugar/, 'lugar', 'Lima'], [/empezado|empezó/, 'empece', 'Rubor'], [/tiempo/, 'tiempo', 'Amarillo'], [/./, 'estrella', 'Lila']];

function tipoFigura(b) {
  const d = b.descripcion;
  return /datos en tarjetas/.test(d) ? 'datos' : /^diagrama/.test(d) ? 'diagrama' : /capturas/.test(d) ? 'capturas' : /^línea de tiempo/.test(d) ? 'tiempo' : 'foto';
}

/** Compone una tabla o una figura de cifras. Devuelve su HTML y deja en b.textos los textos que irán vivos en el IDML. */
function disenar(b) {
  const textos = [];
  const T = (estilo, contenido, cls = '') => {
    const partes = typeof contenido === 'string' ? tramos(contenido) : contenido;
    textos.push({ estilo, partes });
    return `<div class="${clase(estilo)} n ${cls}" data-t="${textos.length - 1}">${htmlTramos(partes)}</div>`;
  };
  b.textos = textos;
  if (b.flotante === 'figura') return fichasDatos(b, T);
  if (/^Participantes/.test(b.titulo)) return fichasPersonas(b, T);
  if (b.filas[0].slice(1).every((c) => /^[A-Z]\. /.test(c))) return matriz(b, T);
  return tablaFichas(b, T);
}

/** Tabla general: una ficha blanca por fila; la primera celda lleva un círculo con icono, número o versión. */
function tablaFichas(b, T) {
  const [cab, ...filas] = b.filas; const cols = cab.length, ult = cols - 1;
  const conEstado = filas.every((f) => ESTADO.test(plano(f[ult])));
  const chips = cab.map((_, k) => k > 0 && filas.every((f) => /^(\d+( y \d+)*|Todos)$/.test(f[k])));
  const version = filas.every((f) => /^(Hasta la )?[\d.–]+, /.test(f[0]));
  const peso = cab.map((_, k) => {
    if (chips[k]) return 0.42;
    const largos = b.filas.map((f) => plano(f[k] || '').length); const max = Math.max(...largos), med = largos.reduce((x, y) => x + y, 0) / largos.length;
    return max <= 14 ? 0.8 : Math.max(1, Math.sqrt(med) / 3.2);
  });
  if (version) peso[0] = 0.72;
  const util = b.anchoTabla - 0.7 - 4 - 5 - 6 * (cols - 1) - (version ? 0 : 11.2);
  const suma = peso.reduce((x, y) => x + y, 0);
  const anchos = peso.map((p, k) => Math.round(((p / suma) * util + (k === 0 && !version ? 11.2 : 0)) * 100) / 100);
  const rejilla = `style="grid-template-columns:${anchos.map((w) => w + 'mm').join(' ')}"`;
  const cabecera = `<div class="cab" ${rejilla}>${cab.map((c, k) => T('Celda cabecera', c, k === 0 && !version ? 'h0' : '')).join('')}</div>`;
  const cuerpo = filas.map((f, r) => {
    const primera = plano(f[0]); let pri;
    if (version) {
      const m = f[0].match(/^((?:Hasta la )?[\d.–]+), (.*)$/);
      pri = `<div class="est"><span class="pil lleno">${h(m[1])}</span>${T('Celda cabecera', mayus(m[2]))}</div>`;
    } else {
      const ic = ICONOS.find(([re]) => re.test(primera));
      const num = f[0].match(/^(\d+)\. (.*)$/), par = f[0].match(/^(.+?) \(([^)]+)\)$/);
      const marca = ic ? svgIcono(ic[1]) : /^Total/.test(primera) ? '=' : num ? num[1] : String(r + 1);
      const etiqueta = num ? num[2] : par ? par[1] : f[0];
      pri = `<div class="pri">${circulo(marca)}<div class="tx">${T(plano(etiqueta).length > 45 ? 'Celda' : 'Celda primera', etiqueta)}${par && !num ? T('Celda cabecera', mayus(par[2])) : ''}</div></div>`;
    }
    const resto = f.slice(1).map((c, i) => {
      const k = i + 1;
      if (chips[k]) return `<div class="chips">${c === 'Todos' ? '<span class="pil">Todos</span>' : c.split(' y ').map((n) => `<span class="chip">${n}</span>`).join('')}</div>`;
      if (k === ult && conEstado) {
        const estado = plano(c).match(ESTADO)[1], detalle = c.replace(ESTADO, '');
        return `<div class="est"><span class="pil ${CAPSULA[estado]}">${estado}</span>${detalle ? T('Celda', mayus(detalle)) : ''}</div>`;
      }
      return `<div class="c">${T(c === '—' ? 'Celda suave' : 'Celda', c)}</div>`;
    }).join('');
    return `<div class="fila${/^Total/.test(primera) ? ' total' : ''}" ${rejilla}>${pri}${resto}</div>`;
  }).join('');
  return `<div class="tb">${cabecera}${cuerpo}</div>`;
}

/** Participantes: una ficha por persona, con su código en el círculo. */
function fichasPersonas(b, T) {
  return `<div class="per">${b.filas.slice(1).map((f) => `<div class="pc">${circulo(h(f[0]))}<div class="tx">${T('Celda cabecera', `${f[1]} años`)}${T('Celda', f[2])}</div></div>`).join('')}</div>`;
}

/** Comparación entre condiciones: una columna por condición, con el color de su papel en la cabecera. */
function matriz(b, T) {
  const [cab, ...filas] = b.filas;
  const rol = (t) => (/primer paso/i.test(t) ? 'Cielo' : /lugar/i.test(t) ? 'Lima' : /teléfono/i.test(t) ? 'Amarillo' : 'Lila');
  let out = `<div class="mz" style="grid-template-columns:50mm repeat(${cab.length - 1},1fr)"><div class="mh0">${T('Celda cabecera', cab[0])}</div>`;
  out += cab.slice(1).map((c) => { const m = c.match(/^([A-Z])\. (.*)$/); return `<div class="mh" style="background:${rgb(rol(c))}">${circulo(m[1])}${T('Celda primera', m[2])}</div>`; }).join('');
  filas.forEach((f, r) => {
    const cls = (r === 0 ? ' p' : '') + (r === filas.length - 1 ? ' mu' : '');
    out += `<div class="ma">${T('Celda primera', f[0])}</div>` + f.slice(1).map((c) => `<div class="mc${cls}">${T(/^(El mismo|La misma)$/.test(c) ? 'Celda suave' : 'Celda', c)}</div>`).join('');
  });
  return out + '</div>';
}

/** Cifras: una ficha por dato, con el valor en grande, su explicación y una barra o un punto por cada caso. */
function fichasDatos(b, T) {
  const datos = b.descripcion.replace(/^[^:]*: /, '').split('; ').map((d) => d.match(/^(\d+) de (\d+), (.*)$/)).filter(Boolean);
  return `<div class="dt" style="grid-template-columns:repeat(${datos.length},1fr)">${datos.map(([, k, n, t]) => {
    const [, ic, color] = ROL_DATO.find(([re]) => re.test(t)); const medias = /una a medias/.test(t);
    const marcas = Array.from({ length: +n }, (_, i) => `<span class="${i < +k ? 's' : medias && i === +k ? 'm' : ''}"></span>`).join('');
    return `<div class="dc" style="--c:${rgb(color)}">${circulo(svgIcono(ic))}${T('Dato', [{ texto: k }, { texto: ` de ${n}`, estilo: 'Dato resto' }])}${T('Celda', mayus(t), 'dx')}<div class="${+n <= 10 ? 'pts' : 'bar'}">${marcas}</div></div>`;
  }).join('')}</div>`;
}

// ---------------------------------------------------------------- Documento

const secciones = leer();
const sec = (titulo) => secciones.find((s) => s.titulo === titulo);
const inicio = secciones[0].lineas.filter((l) => l.trim());           // líneas antes de «# Relevo»
const portada = sec('Relevo').lineas.filter((l) => l.trim());
const capitulos = secciones.filter((s) => /^\d+\. /.test(s.titulo)).map((s) => ({ n: +s.titulo.match(/^(\d+)/)[1], titulo: s.titulo.replace(/^\d+\. /, ''), bloques: bloques(s.lineas) }));
const finales = [
  { titulo: 'Referencias', bloques: bloques(sec('Referencias').lineas, 'Referencia') },
  { titulo: 'Glosario', bloques: bloques(sec('Glosario').lineas, 'Glosario') },
  { titulo: 'Anexos', bloques: bloques(sec('Anexos').lineas, 'Glosario') },
];
const cuerpo = [...capitulos, ...finales];

console.log('Dibujando luces, logo y figuras…');
const dib = dibujar();

// Piezas que hay que medir.
const piezas = [];
cuerpo.forEach((c, ci) => {
  piezas.push({ id: `t${ci}`, ancho: COL, html: `<div class="${clase('Capítulo título')}">${h(c.titulo)}</div>` });
  c.bloques.forEach((b, bi) => {
    if (!b.flotante) { piezas.push({ id: `c${ci}b${bi}`, ancho: COL * 0.985, html: htmlParrafo(b) }); return; }
    b.id = `c${ci}b${bi}`;
    b.tipo = b.flotante === 'tabla' ? 'tabla' : tipoFigura(b);
    b.angosta = b.flotante === 'tabla' && b.filas[0].length <= 3 && !/^Participantes/.test(b.titulo);   // dos columnas de ancho; el título va en la tercera
    b.anchoTabla = b.angosta ? COL * 2 + MED : ANCHO;
    const anchoTitulo = b.angosta ? COL : ANCHO;
    piezas.push({ id: b.id + 'T', ancho: anchoTitulo, html: `<div class="${clase('Rótulo')}">x</div><div class="${clase('Título de tabla')}">${h(b.titulo)}</div>` });
    if (b.nota) piezas.push({ id: b.id + 'N', ancho: anchoTitulo, html: htmlParrafo({ estilo: 'Nota', partes: tramos(b.nota) }) });
    if (b.tipo === 'tabla' || b.tipo === 'datos') { b.html = disenar(b); piezas.push({ id: b.id + 'X', ancho: b.anchoTabla, html: b.html }); }
  });
});
const resumenB = bloques(sec('Resumen').lineas), abstractB = bloques(sec('Abstract').lineas);
const gracias = sec('Agradecimientos') ? bloques(sec('Agradecimientos').lineas, 'Agradecimiento') : null;
console.log(`Midiendo ${piezas.length} piezas en Chrome…`);
const alto = medir(piezas);

// Fondo de cada tabla y de cada figura de cifras: la misma composición que se midió, sin su texto.
const flot = cuerpo.flatMap((c) => c.bloques.filter((b) => b.flotante));
console.log('Dibujando tablas y cifras…');
flot.filter((b) => b.html).forEach((b) => {
  const nombre = `${b.flotante}-${b.n}`, cuerpoHtml = `<div style="width:${b.anchoTabla}mm">${b.html}</div>`, a = alto[b.id + 'X'];
  b.fondo = pdf(nombre, b.anchoTabla, a, cuerpoHtml, CSS_E + CSS_FICHAS + '[data-t]{visibility:hidden}');
  if (PREVIA) pdf(nombre, b.anchoTabla, a, cuerpoHtml, CSS_E + CSS_FICHAS + 'body{background:#F7F4F0}', PREVIA);
});
// Muestra de todas las tablas y cifras con su texto, una por página, para revisarlas sin abrir Affinity.
{
  const f = path.join(TMP, 'muestra.html');
  const hojas = flot.filter((b) => b.html).map((b) => `<section><div class="${clase('Rótulo')}">${b.flotante === 'tabla' ? 'Tabla' : 'Figura'} ${b.n}</div><div class="${clase('Título de tabla')}">${h(b.titulo)}</div><div style="width:${b.anchoTabla}mm;margin-top:3mm">${b.html}</div>${b.nota ? htmlParrafo({ estilo: 'Nota', partes: tramos(b.nota) }) : ''}</section>`).join('');
  fs.writeFileSync(f, `<!doctype html><meta charset="utf-8"><style>${CSS_LETRA}${CSS_E}${CSS_FICHAS}@page{size:${W}mm ${H}mm;margin:0}section{width:${W}mm;height:${H}mm;padding:${M.arriba}mm ${M.derecha}mm;background:#F7F4F0;page-break-after:always;overflow:hidden}</style>${hojas}`);
  chrome(['--no-pdf-header-footer', '--virtual-time-budget=6000', `--print-to-pdf=${path.join(AQUI, 'tablas-y-cifras.pdf')}`, url(f)]);
}

// ---------------------------------------------------------------- Reparto en páginas

const paginas = [];                                   // páginas del cuerpo: { marcos, flotantes, banda, capitulo }
const pag = (p) => { while (paginas.length <= p) paginas.push({ marcos: [], flotantes: [], banda: 0, aperturas: [] }); return paginas[p]; };
const SEP = 7;                                        // aire entre la banda de tablas y figuras y el texto
const colTop = (p) => TOP + (pag(p).banda ? pag(p).banda + SEP : 0);
const BANDA_CON_TEXTO = 185;                           // con una banda más alta, la página queda solo para tablas y figuras
const soloFlotantes = (q) => pag(q).banda > BANDA_CON_TEXTO;

function altoFlotante(b) {
  const tit = alto[b.id + 'T'] || 0, nota = b.nota ? alto[b.id + 'N'] : 0;
  b.altoTit = tit; b.altoNota = nota; b.altoCuerpo = b.html ? alto[b.id + 'X'] : ALTO_FIG[b.tipo];
  return b.angosta ? Math.max(b.altoCuerpo, tit + nota + 4) : tit + 3 + b.altoCuerpo + (nota ? nota + 2 : 0);
}
function programar(b, p) {
  const a = altoFlotante(b); let q = p + 1;
  while (pag(q).banda > 0 && pag(q).banda + a > BOTTOM - TOP) q++;
  b.pagina = q; b.y = TOP + pag(q).banda; b.alto = a;
  pag(q).flotantes.push(b); pag(q).banda += a + (pag(q).banda ? 0 : 0) + 6;
}

let p = 0, k = 0, y = TOP;
const libre = () => BOTTOM - y;
function siguienteColumna() {
  k++; if (k === 3) { k = 0; p++; }
  while (soloFlotantes(p)) { p++; k = 0; }               // página llena de tablas o figuras
  y = colTop(p);
}
cuerpo.forEach((c, ci) => {
  const conNumero = c.n != null;
  const apertura = (conNumero ? 62 : 0) + alto[`t${ci}`] + 7;
  if (y > colTop(p) + 0.5) siguienteColumna();
  while (libre() < apertura + 45) siguienteColumna();
  c.pagina = p; c.marcos = [];
  pag(p).aperturas.push({ c, ci, k, y, apertura, conNumero });
  y += apertura;
  let marco = { p, k, y0: y }; c.marcos.push(marco);
  for (const b of c.bloques) {
    if (b.flotante) { programar(b, p); continue; }
    let resto = alto[`c${ci}b${c.bloques.indexOf(b)}`] * SEGURIDAD;
    while (resto > 0.01) {
      if (libre() < 5.5) { siguienteColumna(); marco = { p, k, y0: y }; c.marcos.push(marco); continue; }
      const toma = Math.min(resto, libre()); y += toma; resto -= toma;
    }
  }
  c.finPagina = p;
});
const ultimaFlotante = Math.max(0, ...cuerpo.flatMap((c) => c.bloques.filter((b) => b.flotante).map((b) => b.pagina)));
pag(Math.max(p, ultimaFlotante));

// ---------------------------------------------------------------- IDML

const doc = new Idml({ ancho: W, alto: H, sangrado: 3, margenes: [M.arriba, M.derecha, M.abajo, M.izquierda], columnas: 3, medianil: MED });
const TINTA = doc.color('Tinta', [20, 19, 18]);
const PAPEL = doc.color('Papel Relevo', [247, 244, 240]);
doc.color('Gris', [110, 105, 100]);
const LINEA = doc.color('Línea', [204, 198, 190]);
const BLANCO = doc.color('Blanco', [255, 255, 255]);
const MARCADOR = doc.color('Marcador', [255, 229, 126]);
LUCES.forEach(([n, rgb]) => doc.color(n, rgb));

const tabsDe = (n) => (n === 'Lista' || n === 'Referencia' ? [{ pos: 17 }] : n === 'Índice' ? [{ pos: pt(COL), alin: 'RightAlign' }] : null);
for (const [nombre, e] of Object.entries(E)) {
  const props = { letra: 'Instrument Sans', idioma: '$ID/Spanish: Castilian', guiones: 'false', alineacion: 'LeftAlign', estilo: 'Regular', ...e };
  if (tabsDe(nombre)) props.tabs = tabsDe(nombre);
  doc.parrafo(nombre, props);
}
doc.caracter('Cursiva', { estilo: 'Italic' });
doc.caracter('Negrita', { estilo: 'SemiBold' });
doc.caracter('Negrita cursiva', { estilo: 'SemiBold Italic' });
doc.caracter('Dato resto', { tamano: 20, estilo: 'Medium', color: 'Color/Gris' });
doc.caracter('Confirmar', { subrayado: 'true', subColor: MARCADOR, subGrosor: 11, subDesplaz: -3 });

const P = (estilo, texto) => ({ estilo, partes: typeof texto === 'string' ? [{ texto }] : texto });
const marcoTexto = (rect, parrafos, extra = {}) => ({ tipo: 'texto', rect, historia: doc.historia(parrafos), ...extra });

// Maestra: papel, encabezado y folio.
doc.maestra.push({ tipo: 'rect', rect: [-3, -3, W + 6, H + 6], relleno: PAPEL, nombre: 'Papel' });
doc.maestra.push(marcoTexto([M.izquierda, 9, 140, 5], [P('Encabezado', 'Relevo · Memoria de título')], { capa: 'Folios', nombre: 'Encabezado' }));
doc.maestra.push(marcoTexto([W - M.derecha - 30, H - 13, 30, 5], [{ estilo: 'Folio', partes: [{ folio: true }] }], { capa: 'Folios', nombre: 'Folio' }));

// Página 1: portada.
const lineaSub = portada[0];
const datos = portada.slice(1);
const pPortada = [
  { tipo: 'imagen', archivo: path.join(AQUI, 'figuras', 'aura', 'portada.jpg'), rect: [-3, -3, W + 6, H + 6], nombre: 'Aura de la portada' },
  { tipo: 'imagen', archivo: dib.logo, rect: [M.izquierda, 24, 150, 31.5], ajuste: 'contener', nombre: 'Logo' },
  marcoTexto([M.izquierda, 70, 230, 60], [P('Portada subtítulo', tramos(lineaSub))], { nombre: 'Subtítulo' }),
  marcoTexto([M.izquierda, 196, 200, 82], [...inicio.map((l) => P('Portada dato', tramos(l))), P('Portada dato', ''), ...datos.map((l) => P('Portada dato', tramos(l)))], { vertical: 'BottomAlign', nombre: 'Identificación' }),
];
pPortada.sinMaestra = true;
doc.pagina(pPortada);

// Agradecimientos: una página quieta, con una luz y el texto abajo.
if (gracias) {
  doc.pagina([
    { tipo: 'imagen', archivo: dib.luces[3], rect: [W - 250, -70, 330, 330], ajuste: 'contener', nombre: 'Luz de los agradecimientos' },
    marcoTexto([colX(0), TOP, COL * 2 + MED, BOTTOM - TOP], [P('Título de sección', 'Agradecimientos'), ...gracias], { vertical: 'BottomAlign', nombre: 'Agradecimientos' }),
  ]);
}

// Resumen, abstract e índice. Los números de página se conocen ya: los fijó el reparto.
const PRIMERA = gracias ? 4 : 3;                      // número de la primera página del cuerpo
const numPag = (q) => String(q + PRIMERA);
const clave = (lineas, patron) => (lineas.find((l) => patron.test(l)) || '').trim();
const indice = [P('Título de sección', 'Índice')];
cuerpo.forEach((c) => indice.push(P('Índice', `${c.n != null ? c.n + '. ' : ''}${c.titulo}\t${numPag(c.pagina)}`)));
indice.push(P('Índice título', 'Tablas'));
flot.filter((b) => b.flotante === 'tabla').forEach((b) => indice.push(P('Índice', `${b.n}. ${b.titulo}\t${numPag(b.pagina)}`)));
indice.push(P('Índice título', 'Figuras'));
flot.filter((b) => b.flotante === 'figura').forEach((b) => indice.push(P('Índice', `${b.n}. ${b.titulo}\t${numPag(b.pagina)}`)));
doc.pagina([
  marcoTexto([colX(0), TOP, COL, BOTTOM - TOP], [P('Título de sección', 'Resumen'), ...resumenB.filter((b) => !/Palabras clave/.test(b.partes.map((r) => r.texto).join(''))), P('Palabras clave', tramos(clave(sec('Resumen').lineas, /Palabras clave/)))], { nombre: 'Resumen' }),
  marcoTexto([colX(1), TOP, COL, BOTTOM - TOP], [P('Título de sección', 'Abstract'), ...abstractB.filter((b) => !/Keywords/.test(b.partes.map((r) => r.texto).join(''))), P('Palabras clave', tramos(clave(sec('Abstract').lineas, /Keywords/)))], { nombre: 'Abstract' }),
  marcoTexto([colX(2), TOP, COL, BOTTOM - TOP], indice, { nombre: 'Índice' }),
]);

// Cuerpo.
function itemsFlotante(b) {
  const out = []; const x0 = M.izquierda; const nombre = `${b.flotante === 'tabla' ? 'Tabla' : 'Figura'} ${b.n}`;
  const rot = [P('Rótulo', nombre), P('Título de tabla', b.titulo)];
  const nota = b.nota ? [P('Nota', tramos(b.nota))] : [];
  const yi = b.angosta ? b.y : b.y + b.altoTit + 3, hi = b.altoCuerpo;
  if (b.angosta) out.push(marcoTexto([colX(2), b.y, COL, b.alto], [...rot, ...nota], { nombre: `${nombre}: título y nota` }));
  else {
    out.push(marcoTexto([x0, b.y, ANCHO, b.altoTit + 2], rot, { nombre: `${nombre}: título` }));
    if (b.nota) out.push(marcoTexto([x0, yi + hi + 2, ANCHO, b.altoNota + 2], nota, { nombre: `${nombre}: nota` }));
  }
  if (b.fondo) {
    // El fondo es un PDF; cada texto va encima, vivo, donde Chrome lo midió.
    out.push({ tipo: 'imagen', archivo: b.fondo, rect: [x0, yi, b.anchoTabla, hi], ajuste: 'contener', nombre: `${nombre}: fichas` });
    const donde = alto[b.id + 'XR'] || {};
    b.textos.forEach((t, k) => {
      const [rx, ry, rw, rh] = donde[k]; const baja = 0.4;   // Affinity apoya la primera línea en el ascendente, algo más arriba que Chrome
      out.push(marcoTexto([x0 + rx, yi + ry + baja, rw, rh + 1.4], [P(t.estilo, t.partes)], { nombre: `${nombre}: ${t.partes.map((r) => r.texto).join('').slice(0, 30)}` }));
    });
  } else if (b.tipo === 'diagrama') out.push({ tipo: 'imagen', archivo: dib.diagrama, rect: [x0, yi, ANCHO, hi], ajuste: 'contener', nombre });
  else if (b.tipo === 'tiempo') out.push({ tipo: 'imagen', archivo: dib.tiempo, rect: [x0, yi, ANCHO, hi], ajuste: 'contener', nombre });
  else if (b.tipo === 'capturas') {
    const w = hi * 540 / 1200, sep = 9;
    for (let i = 0; i < 6; i++) out.push({ tipo: 'imagen', archivo: path.join(AQUI, 'figuras', `preparar-p${i + 1}.png`), rect: [x0 + i * (w + sep), yi, w, hi], ajuste: 'contener', nombre: `${nombre}, pantalla ${i + 1}` });
  } else {
    out.push({ tipo: 'rect', rect: [x0, yi, 150, hi], relleno: BLANCO, borde: LINEA, grosor: 0.75, discontinuo: true, radio: 4, capa: 'Imágenes', nombre: `${nombre}: fotografía pendiente` });
    out.push(marcoTexto([x0 + 12, yi + hi / 2 - 12, 126, 28], [P('Pendiente', 'Fotografía pendiente'), P('Pendiente', b.descripcion)], { nombre: `${nombre}: descripción` }));
  }
  return out;
}

const historiaDe = new Map();
cuerpo.forEach((c) => historiaDe.set(c, doc.historia(c.bloques.filter((b) => !b.flotante))));
let vigente = null;
paginas.forEach((pg, q) => {
  const items = [];
  pg.flotantes.forEach((b) => items.push(...itemsFlotante(b)));
  pg.aperturas.forEach(({ c, ci, k: col, y: y0, conNumero }) => {
    if (conNumero) {
      const luz = dib.luces[(c.n - 1) % dib.luces.length];
      items.push({ tipo: 'imagen', archivo: luz, rect: [colX(col) - 14, y0 - 12, 96, 96], ajuste: 'contener', nombre: `Luz del capítulo ${c.n}` });
      items.push(marcoTexto([colX(col), y0, COL, 60], [P('Capítulo número', String(c.n))], { nombre: `Número del capítulo ${c.n}` }));
    }
    items.push(marcoTexto([colX(col), y0 + (conNumero ? 62 : 0), COL, alto[`t${ci}`] + 3], [P('Capítulo título', c.titulo)], { nombre: `Título: ${c.titulo}` }));
  });
  cuerpo.forEach((c) => c.marcos.filter((m) => m.p === q).forEach((m) => items.push({ tipo: 'texto', rect: [colX(m.k), m.y0, COL, BOTTOM - m.y0], historia: historiaDe.get(c), nombre: c.titulo })));
  const empiezan = pg.aperturas.map((a) => a.c);
  const arriba = empiezan.length && pg.aperturas[0].k === 0 && pg.aperturas[0].y <= colTop(q) + 0.5 ? empiezan[0] : vigente || empiezan[0];
  if (arriba) items.push(marcoTexto([W - M.derecha - 190, 9, 190, 5], [{ estilo: 'Folio', partes: [{ texto: (arriba.n != null ? arriba.n + ' · ' : '') + arriba.titulo }] }], { capa: 'Folios', nombre: 'Capítulo de la página' }));
  if (empiezan.length) vigente = empiezan[empiezan.length - 1];
  doc.pagina(items);
});

// Contraportada.
const pFinal = [
  { tipo: 'imagen', archivo: path.join(AQUI, 'figuras', 'aura', 'contraportada.jpg'), rect: [-3, -3, W + 6, H + 6], nombre: 'Aura de la contraportada' },
  { tipo: 'imagen', archivo: dib.logo, rect: [(W - 150) / 2, (H - 31.5) / 2 - 8, 150, 31.5], ajuste: 'contener', nombre: 'Logo' },
  marcoTexto([(W - 240) / 2, H / 2 + 22, 240, 12], [{ estilo: 'Pendiente', partes: [{ texto: 'Un recordatorio físico preparado desde el teléfono' }] }], { nombre: 'Descriptor' }),
];
pFinal.sinMaestra = true;
doc.pagina(pFinal);

doc.escribir(SALIDA);
fs.rmSync(TMP, { recursive: true, force: true });

if (process.env.DIAG) {
  cuerpo.forEach((c, ci) => { const hs = c.bloques.filter((b) => !b.flotante).map((b) => alto[`c${ci}b${c.bloques.indexOf(b)}`]); const pal = c.bloques.filter((b) => !b.flotante).reduce((n, b) => n + b.partes.map((r) => r.texto).join('').split(/\s+/).length, 0); console.log('DIAG', c.titulo.slice(0, 24).padEnd(24), 'mm', Math.round(hs.reduce((x, y) => x + y, 0)), 'palabras', pal, 'marcos', c.marcos.map((m) => `${m.p}:${m.k}@${Math.round(m.y0)}`).join(' ')); });
  paginas.forEach((pg, q) => console.log('PAG', q + PRIMERA, 'banda', Math.round(pg.banda), pg.flotantes.map((b) => `${b.flotante[0]}${b.n}:${Math.round(b.alto)}`).join(' ')));
}
const columnas = cuerpo.reduce((n, c) => n + c.marcos.length, 0);
console.log(`Listo: ${path.basename(SALIDA)} · ${doc.paginas.length} páginas · ${cuerpo.length} historias enlazadas en ${columnas} columnas · ${flot.length} tablas y figuras.`);
cuerpo.forEach((c) => console.log(`  ${String(c.pagina + PRIMERA).padStart(2)}  ${c.n != null ? c.n + '. ' : ''}${c.titulo} (${c.marcos.length} columnas)`));
