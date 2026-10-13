// Memoria de Relevo en A3 horizontal como archivo editable (IDML) para Affinity o InDesign (D-132).
// Toma el texto de la v5 sin cambiarlo y lo compone con el rediseño pedido el 13 de octubre de 2026:
// tres columnas, texto de 11,5 pt, una escala única (8, 9,5, 11,5, 15, 20, 44 y 200 pt), una luz de
// color por capítulo, tablas y figuras a lo ancho y texto enlazado entre columnas.
//
// Cómo se arma:
//   1. Node lee la v5 y la parte en capítulos, párrafos, tablas y figuras.
//   2. Chrome sin ventana dibuja las luces, el logo y las figuras 1 y 4, y mide el alto de cada bloque
//      con la misma letra y las mismas medidas, para saber cuántas columnas ocupa cada capítulo.
//   3. Node reparte columnas, tablas y figuras en las páginas y escribe el IDML con idml.js.
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
  'Celda cabecera': { tamano: 9.5, interlineado: 13, estilo: 'SemiBold' },
  'Celda primera': { tamano: 9.5, interlineado: 13, estilo: 'Medium' },
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
const TABLA = { relleno: [0, 0, 6],   // el aire de cada fila lo da su alto mínimo, medido en Chrome: Affinity no lee el relleno de celda
   fuerte: 1, media: 0.75, fina: 0.35 };
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

function pdf(nombre, anchoMm, altoMm, cuerpo, css = '') {
  const f = path.join(TMP, nombre + '.html'); const salida = path.join(GEN, nombre + '.pdf');
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
  // Figura 1: seis nodos y tres salidas del mismo peso.
  const nodos = [['Intención personal', 'Lila'], ['Primer paso', 'Cielo'], ['Lugar elegido', 'Lima'], ['Condición configurada', 'Amarillo'], ['Pulso ambiental', 'Durazno'], ['Decisión de la persona', 'Rubor']];
  const rgb = (n) => 'rgb(' + LUCES.find((l) => l[0] === n)[1].join(',') + ')';
  const cssFig = `.f{display:flex;align-items:center;height:100%;gap:2.2mm;font-size:10.5pt;line-height:13.5pt;font-weight:500}
.n{flex:1;border-radius:4mm;padding:4mm 3.2mm;text-align:center;min-height:19mm;display:flex;align-items:center;justify-content:center}
.a{flex:none;font-size:13pt;color:#6E6964}.s{flex:1.25;display:flex;flex-direction:column;gap:1.8mm}.s div{border:.35mm solid #141312;border-radius:3mm;padding:2.2mm 3mm;font-size:9.5pt;line-height:12.5pt;font-weight:400;background:#fff}`;
  out.fig1 = pdf('figura-1', ANCHO, 44, `<div class="f">${nodos.map(([t, c]) => `<div class="n" style="background:${rgb(c)}">${h(t)}</div><div class="a">→</div>`).join('')}<div class="s"><div>Considerar la intención</div><div>Seguir en el teléfono</div><div>Silenciar la señal</div></div></div>`, cssFig);
  // Figura 4: línea de tiempo de la prueba.
  const etapas = [['Día 0', 'Sesión inicial en el hogar', 'Límite de 8 minutos, cuatro momentos observados y comprobación de autonomía', 'Amarillo', 1.15], ['Días 1–7', 'Primera condición', 'Preguntas tras cada señal y tarjeta semanal', 'Cielo', 1], ['Días 8–14', 'Segunda condición', 'Preguntas tras cada señal y tarjeta semanal', 'Lima', 1], ['Días 15–21', 'Tercera condición', 'Preguntas tras cada señal y tarjeta semanal', 'Rubor', 1], ['Día 21', 'Cierre', 'Preguntas de cierre y entrevista', 'Lila', .8]];
  out.fig4 = pdf('figura-4', ANCHO, 40, `<div class="t">${etapas.map(([d, t, x, c, w]) => `<div class="e" style="flex:${w};background:${rgb(c)}"><b>${h(d)}</b><span>${h(t)}</span><small>${h(x)}</small></div>`).join('')}</div>`,
    `.t{display:flex;gap:2.5mm;height:100%}.e{border-radius:4mm;padding:4.5mm 4mm;display:flex;flex-direction:column;gap:1.2mm}.e b{font-size:9.5pt;font-weight:600}.e span{font-size:13pt;line-height:16pt;font-weight:600}.e small{font-size:9.5pt;line-height:12.5pt}`);
  return out;
}

/** Mide en Chrome una lista de piezas { id, ancho (mm), html } y devuelve sus altos en mm. */
function medir(piezas) {
  const css = Object.entries(E).map(([n, e], i) => `.e${i}{font-size:${e.tamano}pt;line-height:${e.interlineado}pt;font-weight:${PESO[e.estilo] || 400};${e.estilo === 'Italic' ? 'font-style:italic;' : ''}padding-top:${e.antes || 0}pt;padding-bottom:${e.despues || 0}pt;padding-left:${e.sangria || 0}pt;text-indent:${e.primera || 0}pt;tab-size:${e.sangria || 17}pt;white-space:pre-wrap;overflow-wrap:break-word}`).join('\n');
  const f = path.join(TMP, 'medir.html');
  fs.writeFileSync(f, `<!doctype html><meta charset="utf-8"><style>${CSS_LETRA}${css}
.m{position:absolute;left:0;top:0;visibility:hidden}b{font-weight:600}i{font-style:italic}
table{border-collapse:collapse;table-layout:fixed;width:100%}td{vertical-align:top;padding:3.5pt ${TABLA.relleno[2]}pt;border-bottom:.5pt solid #000}</style>
${piezas.map((p) => `<div class="m" data-id="${p.id}" style="width:${p.ancho}mm">${p.html}</div>`).join('\n')}
<pre id="out"></pre><script>document.fonts.ready.then(()=>{const o={};document.querySelectorAll('.m').forEach(e=>{o[e.dataset.id]=e.getBoundingClientRect().height;const f=e.querySelectorAll('tr');if(f.length)o[e.dataset.id+'F']=[...f].map(r=>r.getBoundingClientRect().height).join(',')});document.getElementById('out').textContent='@@'+btoa(JSON.stringify(o))+'@@'})</script>`);
  const dom = chrome(['--virtual-time-budget=20000', '--dump-dom', url(f)]).toString('utf8');
  const m = dom.match(/@@([A-Za-z0-9+/=]+)@@/);
  if (!m) throw new Error('Chrome no devolvió las medidas.');
  const px = JSON.parse(Buffer.from(m[1], 'base64').toString('utf8'));
  return Object.fromEntries(Object.entries(px).map(([k, v]) => [k, typeof v === 'string' ? v.split(',').map((n) => +n * 0.75) : v * PX]));   // filas de tabla: en puntos
}
const clase = (estilo) => 'e' + Object.keys(E).indexOf(estilo);
const htmlTramos = (partes) => partes.map((r) => { const t = h(r.texto); return r.estilo === 'Negrita' ? `<b>${t}</b>` : r.estilo === 'Cursiva' ? `<i>${t}</i>` : r.estilo === 'Negrita cursiva' ? `<b><i>${t}</i></b>` : t; }).join('');
const htmlParrafo = (b) => `<div class="${clase(b.estilo)}">${htmlTramos(b.partes)}</div>`;

/** Anchos de columna de una tabla según el largo de su contenido. */
function anchosTabla(t, total) {
  const cols = t.filas[0].length;
  const peso = Array.from({ length: cols }, (_, k) => {
    const largos = t.filas.map((f) => plano(f[k] || '').length);
    const max = Math.max(...largos); const med = largos.reduce((a, b) => a + b, 0) / largos.length;
    return max <= 6 ? 0.45 : max <= 14 ? 0.8 : Math.max(1, Math.sqrt(med) / 3.2);
  });
  const suma = peso.reduce((a, b) => a + b, 0);
  return peso.map((p) => Math.round((p / suma) * total * 10) / 10);
}
const htmlTabla = (t, anchos) => `<table><colgroup>${anchos.map((w) => `<col style="width:${w}mm">`).join('')}</colgroup>${t.filas.map((f, r) => `<tr>${f.map((c) => `<td><div class="${clase(r === 0 ? 'Celda cabecera' : 'Celda')}">${htmlTramos(tramos(c))}</div></td>`).join('')}</tr>`).join('')}</table>`;

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
    b.angosta = b.flotante === 'tabla' && b.filas[0].length <= 3;
    const anchoTitulo = b.angosta ? COL : ANCHO;
    piezas.push({ id: b.id + 'T', ancho: anchoTitulo, html: `<div class="${clase('Rótulo')}">x</div><div class="${clase('Título de tabla')}">${h(b.titulo)}</div>` });
    if (b.nota) piezas.push({ id: b.id + 'N', ancho: anchoTitulo, html: htmlParrafo({ estilo: 'Nota', partes: tramos(b.nota) }) });
    if (b.flotante === 'tabla') { b.anchoTabla = b.angosta ? COL * 2 + MED : ANCHO; b.anchos = anchosTabla(b, b.anchoTabla); piezas.push({ id: b.id + 'X', ancho: b.anchoTabla, html: htmlTabla(b, b.anchos) }); }
  });
});
const resumenB = bloques(sec('Resumen').lineas), abstractB = bloques(sec('Abstract').lineas);
console.log(`Midiendo ${piezas.length} piezas en Chrome…`);
const alto = medir(piezas);

// ---------------------------------------------------------------- Reparto en páginas

const paginas = [];                                   // páginas del cuerpo: { marcos, flotantes, banda, capitulo }
const pag = (p) => { while (paginas.length <= p) paginas.push({ marcos: [], flotantes: [], banda: 0, aperturas: [] }); return paginas[p]; };
const SEP = 7;                                        // aire entre la banda de tablas y figuras y el texto
const colTop = (p) => TOP + (pag(p).banda ? pag(p).banda + SEP : 0);
const BANDA_CON_TEXTO = 150;                           // con una banda más alta, la página queda solo para tablas y figuras
const soloFlotantes = (q) => pag(q).banda > BANDA_CON_TEXTO;
const ALTO_FIG = { 1: 44, 2: 112, 3: 86, 4: 40 };

function altoFlotante(b) {
  const tit = alto[b.id + 'T'] || 0, nota = b.nota ? alto[b.id + 'N'] : 0;
  if (b.flotante === 'tabla') {
    const tabla = alto[b.id + 'X'] * 1.06 + 3;
    b.altoTabla = tabla; b.altoTit = tit; b.altoNota = nota;
    return b.angosta ? Math.max(tabla, tit + nota + 4) : tit + tabla + nota + 3;
  }
  b.altoTit = tit; b.altoNota = nota;
  return tit + 3 + ALTO_FIG[b.n] + (nota ? nota + 2 : 0);
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

// Página 2: resumen, abstract e índice. Los números de página se conocen ya: los fijó el reparto.
const PRIMERA = 3;                                    // número de la primera página del cuerpo
const numPag = (q) => String(q + PRIMERA);
const clave = (lineas, patron) => (lineas.find((l) => patron.test(l)) || '').trim();
const indice = [P('Título de sección', 'Índice')];
cuerpo.forEach((c) => indice.push(P('Índice', `${c.n != null ? c.n + '. ' : ''}${c.titulo}\t${numPag(c.pagina)}`)));
const flot = cuerpo.flatMap((c) => c.bloques.filter((b) => b.flotante));
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
function tablaIdml(b) {
  return { filas: b.filas.map((f) => f.map((c) => tramos(c))), anchos: b.anchos, reglaFuerte: TABLA.fuerte, reglaMedia: TABLA.media, reglaFina: TABLA.fina, tinta: TINTA, linea: LINEA, relleno: TABLA.relleno, estiloCab: 'Celda cabecera', estiloPrimera: 'Celda primera', estiloCelda: 'Celda', numericas: b.numericas, altos: alto[b.id + 'XF'].map((a) => Math.round(a * 10) / 10), vertical: 'CenterAlign' };
}
function itemsFlotante(b) {
  const out = []; const x0 = M.izquierda; const rot = [P('Rótulo', `${b.flotante === 'tabla' ? 'Tabla' : 'Figura'} ${b.n}`), P('Título de tabla', b.titulo)];
  const nota = b.nota ? [P('Nota', tramos(b.nota))] : [];
  if (b.flotante === 'tabla') {
    if (b.angosta) {
      out.push(marcoTexto([x0, b.y, b.anchoTabla, b.altoTabla], [{ estilo: 'Celda', tabla: tablaIdml(b) }], { nombre: `Tabla ${b.n}` }));
      out.push(marcoTexto([colX(2), b.y, COL, b.alto], [...rot, ...nota], { nombre: `Tabla ${b.n}: título y nota` }));
    } else out.push(marcoTexto([x0, b.y, ANCHO, b.alto], [...rot, { estilo: 'Celda', tabla: tablaIdml(b) }, ...nota], { nombre: `Tabla ${b.n}` }));
    return out;
  }
  out.push(marcoTexto([x0, b.y, ANCHO, b.altoTit + 2], rot, { nombre: `Figura ${b.n}: título` }));
  const yi = b.y + b.altoTit + 3, hi = ALTO_FIG[b.n];
  if (b.n === 1) out.push({ tipo: 'imagen', archivo: dib.fig1, rect: [x0, yi, ANCHO, hi], ajuste: 'contener', nombre: 'Figura 1' });
  else if (b.n === 4) out.push({ tipo: 'imagen', archivo: dib.fig4, rect: [x0, yi, ANCHO, hi], ajuste: 'contener', nombre: 'Figura 4' });
  else if (b.n === 2) {
    const w = hi * 540 / 1200, sep = 9;
    for (let i = 0; i < 6; i++) out.push({ tipo: 'imagen', archivo: path.join(AQUI, 'figuras', `preparar-p${i + 1}.png`), rect: [x0 + i * (w + sep), yi, w, hi], ajuste: 'contener', nombre: `Figura 2, pantalla ${i + 1}` });
  } else {
    out.push({ tipo: 'rect', rect: [x0, yi, 150, hi], relleno: BLANCO, borde: LINEA, grosor: 0.75, discontinuo: true, radio: 4, capa: 'Imágenes', nombre: 'Figura 3: fotografía pendiente' });
    out.push(marcoTexto([x0 + 12, yi + hi / 2 - 12, 126, 28], [P('Pendiente', 'Fotografía pendiente'), P('Pendiente', b.descripcion)], { nombre: 'Figura 3: descripción' }));
  }
  if (b.nota) out.push(marcoTexto([x0, yi + hi + 2, ANCHO, b.altoNota + 2], nota, { nombre: `Figura ${b.n}: nota` }));
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
