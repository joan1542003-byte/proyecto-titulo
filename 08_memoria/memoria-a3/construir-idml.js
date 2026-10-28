// Memoria de Relevo en A3 horizontal: archivo editable (IDML) para Affinity o InDesign y PDF para leer.
// Toma el texto de la v5 sin cambiarlo y lo compone con la línea del 12 de octubre (D-132): papel, tinta,
// paneles de aura con grano, fichas blancas, cápsulas e Instrument Sans. Sobre esa línea aplica lo que el
// autor pidió el 13 de octubre: letra grande (texto de 14 pt), una escala única (9, 11, 14, 18, 28, 44 y
// 150 pt), más aire, tablas y cifras como piezas de la marca (D-134) y ninguna viuda. Desde el 28 de octubre
// (D-145), todo el texto corrido va en columnas de 118 mm, para que cada línea tenga de 8 a 12 palabras, y
// cada sección abre en una página nueva.
//
// Cómo se arma:
//   1. Node lee la v5 y la parte en secciones, párrafos, tablas y figuras.
//   2. Chrome sin ventana mide cada párrafo (cuántas líneas ocupa en su columna) y cada pieza.
//   3. Node reparte el texto línea por línea: ningún párrafo deja menos de dos líneas a cada lado de un
//      corte de columna y ningún subtítulo queda solo al pie. Las tablas y figuras van arriba de la página
//      siguiente a su mención; cada sección abre en una página nueva, con su panel de aura en la primera columna.
//   4. Con ese reparto se escriben dos archivos iguales: el IDML (texto vivo y enlazado; fondos de cada
//      pieza en PDF) y un HTML que Chrome imprime como PDF.
//
// Uso: node construir-idml.js   (necesita Google Chrome; en Affinity, Instrument Sans instalada)

const fs = require('fs');
const path = require('path');
const { execFileSync } = require('child_process');
const { Idml } = require('./idml.js');

const AQUI = __dirname;
const FUENTE = path.join(AQUI, '..', 'borrador-memoria-v5-2026-10-11.md');
const SALIDA = path.join(AQUI, 'memoria-relevo-a3.idml');
const SALIDA_HTML = path.join(AQUI, 'memoria-relevo-a3.html');
const SALIDA_PDF = path.join(AQUI, 'memoria-relevo-a3.pdf');
const GEN = path.join(AQUI, 'figuras', 'idml');
const AURAS = path.join(AQUI, 'figuras', 'aura');
const LETRA = '../../06_desarrollo_y_factibilidad/app-android/app/src/main/res/font/instrument_sans.ttf';
const CURSIVA = 'letra/InstrumentSans-Italic.ttf';
const MARCA = JSON.parse(fs.readFileSync(path.join(AQUI, 'marca-e-iconos.json'), 'utf8'));
const CHROME = [
  process.env.CHROME,
  '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome',
  'C:/Program Files/Google/Chrome/Application/chrome.exe',
  '/usr/bin/google-chrome',
].find((c) => c && fs.existsSync(c));
if (!CHROME) throw new Error('No se encontró Google Chrome. Indica su ruta en la variable CHROME.');

// ---------------------------------------------------------------- Medidas de la hoja

const PT = 25.4 / 72;                       // mm por punto
const W = 420, H = 297;                     // A3 horizontal (mm)
const MX = 22, TOP = 24, BOTTOM = 271;      // columna de 247 mm: 35 líneas de 20 pt
const COL = 118, MED = 11, ANCHO = 376, DOBLE = COL * 2 + MED;
const colX = (k) => MX + k * (COL + MED);
const AIRE_BANDA = 12;                      // entre las tablas o figuras de arriba y el texto
const AIRE_PIEZAS = 12;                     // entre dos tablas o figuras de una misma página
const MIN_TEXTO = 60;                       // con menos alto libre, la página queda solo para tablas y figuras
const HOLGURA = 2.4;                        // cada marco mide lo que ocupa su texto más esto: no cabe otra línea
// Por ahora, a pedido del autor (28 de octubre): sin agradecimientos y un índice solo de secciones. La Biblioteca
// exige los índices de tablas y de figuras para el depósito: se vuelven a poner con INDICE_DE_PIEZAS = true.
const OMITIR = ['Agradecimientos'];
const INDICE_DE_PIEZAS = false;

// Estilos de párrafo (pt). Los mismos números sirven para el IDML, para medir y para el PDF.
// Todo el aire vertical es «después»: así un subtítulo que cae arriba de una columna no arrastra espacio.
const E = {
  'Texto': { tamano: 14, interlineado: 20, despues: 10 },
  'Subtítulo': { tamano: 18, interlineado: 23, estilo: 'SemiBold', despues: 7, seguimiento: -15, conSiguiente: 2 },
  'Subtítulo menor': { tamano: 14, interlineado: 20, estilo: 'SemiBold', despues: 4, conSiguiente: 2 },
  'Lista': { tamano: 14, interlineado: 20, despues: 6, sangria: 22, primera: -22 },
  'Palabras clave': { tamano: 14, interlineado: 20 },
  'Frase': { tamano: 18, interlineado: 24, estilo: 'SemiBold', seguimiento: -15 },
  'Título de pieza': { tamano: 14, interlineado: 19, estilo: 'Italic' },
  'Nota': { tamano: 11, interlineado: 15, color: 'Color/Gris' },
  'Celda': { tamano: 11, interlineado: 15 },
  'Celda suave': { tamano: 11, interlineado: 15, color: 'Color/Gris' },
  'Celda cabecera': { tamano: 9, interlineado: 12, estilo: 'SemiBold', color: 'Color/Gris' },
  'Celda primera': { tamano: 11, interlineado: 15, estilo: 'SemiBold' },
  'Dato': { tamano: 44, interlineado: 46, estilo: 'SemiBold', seguimiento: -20 },
  'Referencia': { tamano: 11, interlineado: 15, despues: 6, sangria: 18, primera: -18 },
  'Glosario': { tamano: 11, interlineado: 15, despues: 7 },
  'Índice': { tamano: 14, interlineado: 18, estilo: 'SemiBold' },
  'Índice página': { tamano: 14, interlineado: 18, estilo: 'SemiBold', color: 'Color/Gris', alineacion: 'RightAlign' },
  'Índice menor': { tamano: 11, interlineado: 15, estilo: 'Medium' },
  'Índice menor página': { tamano: 11, interlineado: 15, estilo: 'SemiBold', color: 'Color/Gris', alineacion: 'RightAlign' },
  'Encabezado': { tamano: 9, interlineado: 12, estilo: 'SemiBold', color: 'Color/Gris' },
  'Encabezado sección': { tamano: 9, interlineado: 12, estilo: 'SemiBold', alineacion: 'RightAlign' },
  'Folio': { tamano: 11, interlineado: 14, estilo: 'SemiBold', alineacion: 'RightAlign' },
  'Portada institución': { tamano: 11, interlineado: 17, estilo: 'SemiBold' },
  'Portada título': { tamano: 44, interlineado: 47, estilo: 'SemiBold', seguimiento: -30 },
  'Portada dato': { tamano: 14, interlineado: 23 },
  'Contraportada': { tamano: 18, interlineado: 24, color: 'Color/Gris', alineacion: 'CenterAlign' },
};
const AIRE_SUBTITULO = { 'Subtítulo': 15, 'Subtítulo menor': 6 };   // aire extra sobre un subtítulo: lo lleva el párrafo anterior
const LUCES = [['Amarillo', [244, 228, 150]], ['Cielo', [179, 229, 252]], ['Lima', [198, 238, 174]], ['Rubor', [250, 200, 217]], ['Lila', [223, 209, 252]], ['Durazno', [251, 209, 179]]];
const rgb = (n) => 'rgb(' + LUCES.find((l) => l[0] === n)[1].join(',') + ')';
// Affinity apoya la primera línea de un marco en la altura de las mayúsculas; Chrome la centra en su interlineado.
// Esta es la diferencia (mm) para un estilo: se usa para que el texto vivo caiga donde Chrome lo dibujó.
const baja = (estilo) => { const e = E[estilo]; return ((e.interlineado - 1.22 * e.tamano) / 2 + 0.25 * e.tamano) * PT; };

// ---------------------------------------------------------------- Texto: de Markdown a bloques

/** Marcas en línea → tramos { texto, estilo }. */
function tramos(s) {
  const out = [];
  const pon = (texto, estilo) => { if (texto) out.push(estilo ? { texto, estilo } : { texto }); };
  const cursivas = (t, base) => t.split(/(_[^_]+_|\*[^*]+\*)/).forEach((p) => {
    if (/^_[^_]+_$/.test(p) || /^\*[^*]+\*$/.test(p)) pon(p.slice(1, -1), base ? 'Negrita cursiva' : 'Cursiva');
    else pon(p, base);
  });
  s.split(/(\[CONFIRMAR:[^\]]+\]|\*\*\*[^*]+\*\*\*|\*\*(?:[^*]|\*(?!\*))+\*\*)/).forEach((p) => {
    if (!p) return;
    if (/^\[CONFIRMAR:/.test(p)) pon(p.replace(/^\[CONFIRMAR: /, '[Confirmar: '), 'Confirmar');
    else if (/^\*\*\*/.test(p)) pon(p.slice(3, -3), 'Negrita cursiva');
    else if (/^\*\*/.test(p)) cursivas(p.slice(2, -2), 'Negrita');
    else cursivas(p, null);
  });
  return out;
}
const plano = (s) => tramos(s).map((r) => r.texto).join('');
const textoDe = (partes) => partes.map((r) => r.texto).join('');

/**
 * Ninguna palabra sola al final de un párrafo: une las últimas palabras con espacios fijos hasta que el
 * último renglón tenga, como mínimo, unas doce letras.
 */
function sinViuda(partes, minimo = 12, desde = 50) {
  if (!partes.length || textoDe(partes).length < desde) return partes;
  const u = partes[partes.length - 1]; let t = u.texto.replace(/\s+$/, ''); let corte = t.length;
  for (let pegadas = 0; pegadas < 3; pegadas++) {
    const sp = t.lastIndexOf(' ', corte - 1);
    if (sp <= 0) break;
    t = t.slice(0, sp) + '\u00A0' + t.slice(sp + 1); corte = sp;
    const anterior = t.lastIndexOf(' ', sp - 1);
    if (t.length - anterior - 1 >= minimo) break;
  }
  const out = partes.slice(); out[out.length - 1] = { ...u, texto: t }; return out;
}
const tituloSinViuda = (partes) => sinViuda(partes, 8, 24);

function leer() {
  const lineas = fs.readFileSync(FUENTE, 'utf8').replace(/\r\n/g, '\n').split('\n');
  const secciones = []; let actual = { titulo: '__inicio__', lineas: [] };
  for (const l of lineas) {
    if (/^# /.test(l)) { secciones.push(actual); actual = { titulo: l.slice(2).trim(), lineas: [] }; } else actual.lineas.push(l);
  }
  secciones.push(actual);
  return secciones;
}

/** Bloques de una sección: párrafos, subtítulos, listas, frases destacadas, tablas y figuras. */
function bloques(lineas, estiloTexto = 'Texto') {
  const out = []; let i = 0;
  const sig = () => { while (i < lineas.length && !lineas[i].trim()) i++; };
  const viuda = estiloTexto === 'Referencia' ? (p) => p : sinViuda;
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
        f.filas = [filas[0], ...filas.slice(2)];
      } else if (/^!\[/.test(lineas[i])) {
        // Fotografías: ![pie](ruta relativa a la memoria), varias en una línea.
        f.fotos = [...lineas[i].matchAll(/!\[([^\]]*)\]\(([^)]+)\)/g)].map((m) => ({ pie: m[1], src: path.relative(AQUI, path.join(path.dirname(FUENTE), m[2])) }));
        f.descripcion = ''; i++;
      } else {
        f.descripcion = lineas[i].trim().replace(/^\[FIGURA POR INSERTAR: |\]$/g, ''); i++;
      }
      sig();
      if (i < lineas.length && /^\*Nota\.\*/.test(lineas[i])) { f.nota = lineas[i].trim(); i++; }
      out.push(f); continue;
    }
    if (/^### /.test(l)) { out.push({ estilo: 'Subtítulo menor', partes: tituloSinViuda(tramos(l.slice(4).trim())) }); i++; continue; }
    if (/^## /.test(l)) { out.push({ estilo: 'Subtítulo', partes: tituloSinViuda(tramos(l.slice(3).trim())), seccion: plano(l.slice(3).trim()) }); i++; continue; }
    if (/^> /.test(l)) {
      const previo = textoDe((out.filter((b) => b.partes).pop() || { partes: [] }).partes);
      out.push({ frase: true, partes: sinViuda(tramos(l.slice(2).trim())), rotulo: /hipótesis/i.test(previo) ? 'Hipótesis' : /pregunta/i.test(previo) ? 'Pregunta de investigación' : 'Cita' });
      i++; continue;
    }
    if ((m = l.match(/^(\d+)\. (.*)$/))) { out.push({ estilo: 'Lista', partes: sinViuda([{ texto: m[1] + '.\t' }, ...tramos(m[2])]) }); i++; continue; }
    if ((m = l.match(/^- (.*)$/))) { out.push({ estilo: estiloTexto === 'Texto' ? 'Lista' : estiloTexto, partes: viuda(estiloTexto === 'Texto' ? [{ texto: '•\t' }, ...tramos(m[1])] : tramos(m[1])) }); i++; continue; }
    out.push({ estilo: estiloTexto, partes: viuda(tramos(l.trim())) }); i++;
  }
  return out;
}

// ---------------------------------------------------------------- Chrome: medir, dibujar e imprimir

const temporales = new Set();
const tmp = (nombre) => { const f = path.join(AQUI, `_${nombre}.html`); temporales.add(f); return f; };
const url = (f) => 'file://' + f.split(path.sep).map(encodeURIComponent).join('/').replace(/%3A/g, ':');
// Chrome sin ventana a veces termina con error sin motivo aparente: se reintenta hasta tres veces.
const chrome = (args) => {
  for (let intento = 1; ; intento++) {
    try { return execFileSync(CHROME, ['--headless=new', '--disable-gpu', '--no-sandbox', '--hide-scrollbars', '--allow-file-access-from-files', ...args], { stdio: ['ignore', 'pipe', 'ignore'], maxBuffer: 1 << 29 }); }
    catch (e) { if (intento === 3) throw e; }
  }
};
const h = (s) => String(s).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
const PESO = { Regular: 400, Italic: 400, Medium: 500, SemiBold: 600, Bold: 700 };
const clase = (estilo) => 'e' + Object.keys(E).indexOf(estilo);
const tieneCursiva = fs.existsSync(path.join(AQUI, CURSIVA));

const CSS_BASE = `@font-face{font-family:"Instrument Sans";src:url("${LETRA}");font-weight:400 700;font-stretch:75% 100%;font-style:normal}
${tieneCursiva ? `@font-face{font-family:"Instrument Sans";src:url("${CURSIVA}");font-weight:400 700;font-stretch:75% 100%;font-style:italic}` : ''}
*{box-sizing:border-box;margin:0;padding:0;-webkit-print-color-adjust:exact;print-color-adjust:exact}
html,body{background:transparent}
body{font-family:"Instrument Sans",sans-serif;color:#141312;font-kerning:normal;-webkit-font-smoothing:antialiased}
b{font-weight:600}i{font-style:italic}.cf{background:#F4E496;border-radius:1.2mm;-webkit-box-decoration-break:clone;box-decoration-break:clone}.pd{color:#6E6964}.dr{font-size:18pt;font-weight:500;color:#6E6964;letter-spacing:0}
svg.ic{fill:none;stroke:currentColor;stroke-width:1.7;stroke-linecap:round;stroke-linejoin:round;display:block}
`;
// Una clase por estilo de párrafo, con los números del IDML.
const CSS_E = Object.entries(E).map(([n, e], i) => `.e${i}{font-size:${e.tamano}pt;line-height:${e.interlineado}pt;font-weight:${PESO[e.estilo] || 400};${e.estilo === 'Italic' ? 'font-style:italic;' : ''}${e.color === 'Color/Gris' ? 'color:#6E6964;' : ''}${e.seguimiento ? `letter-spacing:${e.seguimiento / 1000}em;` : ''}${e.alineacion === 'RightAlign' ? 'text-align:right;' : e.alineacion === 'CenterAlign' ? 'text-align:center;' : ''}padding-left:${e.sangria || 0}pt;text-indent:${e.primera || 0}pt;tab-size:${e.sangria || 22}pt;white-space:pre-wrap;overflow-wrap:break-word}`).join('\n') + '\n';
// Piezas de la marca: fichas blancas, círculos de tinta, cápsulas, barras, paneles de aura.
const CSS_PIEZAS = `.n{padding-right:3%}
.cir{flex:none;width:9.5mm;height:9.5mm;border-radius:50%;background:#141312;color:#F7F4F0;display:flex;align-items:center;justify-content:center;font-size:10pt;font-weight:600;line-height:1}
.cir svg{width:5.6mm;height:5.6mm}
.fic{flex:none;width:8.5mm;height:8.5mm;border-radius:2.8mm;background:#EEE9E3;display:flex;align-items:center;justify-content:center;font-size:9pt;font-weight:600;line-height:1}
.pil{display:inline-flex;flex:none;align-items:center;height:6.4mm;padding:0 3.2mm;border-radius:3.2mm;border:.3mm solid #141312;font-size:9pt;font-weight:600;line-height:1;white-space:nowrap}
.pil.lleno{background:#141312;color:#fff}.pil.hueco{border:.3mm dashed #6E6964;color:#6E6964}.pil.blanca{background:#fff;border-color:#fff}.pil.clara{background:#fff;border-color:#E4DED6}.pil.amarilla{background:#F4E496;border-color:#F4E496}
.chip{width:6.4mm;height:6.4mm;border-radius:50%;border:.3mm solid #141312;display:flex;align-items:center;justify-content:center;font-size:9pt;font-weight:600;line-height:1}
.rot{display:flex;align-items:center;gap:3.5mm;margin-bottom:5mm}.rot .tp{flex:1}
.nota{margin-top:4mm;max-width:${COL}mm}.nota.dos{max-width:${DOBLE}mm}.n.dos{column-count:2;column-gap:${MED}mm}
.ang{display:grid;grid-template-columns:${DOBLE}mm 1fr;column-gap:${MED}mm;align-items:start}
.ang .rot{flex-direction:column;align-items:flex-start;gap:3.5mm;margin-bottom:0}.ang .rot .tp{flex:none;align-self:stretch}
.tb{display:flex;flex-direction:column;gap:1.8mm}
.cab,.fila{display:grid;column-gap:7mm;padding-left:4.5mm;padding-right:6mm;border:.35mm solid transparent}
.cab{padding-bottom:.4mm;align-items:end}.cab .h0{margin-left:13.5mm}
.fila{background:#fff;border-color:#fff;border-radius:5mm;padding-top:3.4mm;padding-bottom:3.6mm;align-items:start}
.fila.total{border-color:#141312}
.pri{display:flex;gap:4mm;align-items:flex-start;min-width:0}
.pri .tx{display:flex;flex-direction:column;gap:.5mm;padding-top:2.1mm;min-width:0;flex:1}
.c{padding-top:2.1mm;min-width:0}
.est{display:flex;flex-direction:column;align-items:flex-start;gap:1.5mm;padding-top:1.55mm;min-width:0}.est .n{align-self:stretch}
.chips{display:flex;gap:1.4mm;padding-top:1.55mm}
.per{display:grid;grid-template-columns:repeat(4,1fr);gap:3.5mm}
.pc{background:#fff;border-radius:5mm;padding:5mm;display:flex;gap:4mm;align-items:flex-start}
.pc .cir{width:12.5mm;height:12.5mm;font-size:11pt}
.pc .tx{display:flex;flex-direction:column;gap:1mm;padding-top:.3mm;min-width:0;flex:1}
.mz{display:grid;column-gap:3.5mm}
.mz .mh0{align-self:end;padding:0 0 2.6mm 1mm}
.mz .mh{border-radius:5mm 5mm 0 0;padding:3.4mm 5mm 3.4mm 4mm;display:flex;gap:3.5mm;align-items:center}.mz .mh .n{flex:1}
.mz .ma{padding:3.2mm 0 3.2mm 1mm;border-top:.25mm solid #CCC6BE}
.mz .mc{background:#fff;padding:3.2mm 5mm;border-top:.25mm solid #E9E4DD}.mz .mc.p{border-top-color:#fff}
.mz .mu{border-radius:0 0 5mm 5mm;padding-bottom:4mm}
.dt{display:grid;gap:4.5mm}
.dc{background:#fff;border-radius:6mm;padding:6mm 6.5mm 6.5mm;display:flex;flex-direction:column}
.dc .cir{margin-bottom:9mm}.dc .dx{flex:1;margin-top:2mm}
.bar{display:flex;align-items:flex-end;gap:.45mm;height:9mm;margin-top:7mm}
.bar span{flex:1;height:38%;border-radius:.6mm;background:#DDD7CF}.bar span.s{height:100%;background:var(--c)}.bar span.m{height:68%;background:var(--c)}
.pts{display:flex;gap:2mm;height:9mm;margin-top:7mm}
.pts span{width:9mm;height:9mm;border-radius:50%;border:.3mm solid #CCC6BE}.pts span.s{background:var(--c);border-color:var(--c)}.pts span.m{background:linear-gradient(90deg,var(--c) 50%,#fff 50%);border-color:var(--c)}
.blanco{background:#fff;border-radius:6mm;padding:8mm}
.fig1{display:grid;grid-template-columns:1fr 8mm 78mm;align-items:center}
.fig1-fila{display:flex;align-items:flex-start;gap:2mm}
.nodo{flex:1;display:grid;justify-items:center;gap:3.5mm;text-align:center;font-size:11pt;line-height:14pt;font-weight:600}
.cuad{flex:none;width:16mm;height:16mm;border-radius:5mm;display:flex;align-items:center;justify-content:center}.cuad svg{width:8.6mm;height:8.6mm}
.flecha{width:6mm;height:6mm;color:#6E6964;flex:none;margin-top:5mm}.flecha svg{width:100%;height:100%}
.fig1-llave{height:54mm;border:.4mm solid #141312;border-left:0;border-radius:0 4mm 4mm 0;margin-left:-2mm}
.fig1-ramas{display:grid;gap:3mm}
.rama{display:flex;align-items:center;gap:3.5mm;background:#F7F4F0;border-radius:5mm;padding:2.6mm 4mm 2.6mm 2.6mm;font-size:11pt;line-height:14pt;font-weight:600}
.rama .cuad{width:11mm;height:11mm;border-radius:3.4mm;background:#EEE9E3}.rama .cuad svg{width:6mm;height:6mm}
.fig4{display:grid;grid-template-columns:1fr 1.15fr 1.15fr 1.15fr .9fr;gap:3.5mm}
.etapa{background:#fff;border-radius:6mm;padding:6mm;display:grid;gap:3mm;align-content:start;font-size:11pt;line-height:15pt}
.etapa b{font-size:14pt;line-height:18pt}.etapa .dia{font-size:9pt;line-height:12pt;font-weight:600;color:#6E6964}
.etapa ul{display:grid;gap:1.4mm;list-style:none}.etapa li{position:relative;padding-left:4mm}
.etapa li::before{content:"";position:absolute;left:0;top:2.1mm;width:1.5mm;height:1.5mm;border-radius:50%;background:#141312}
.etapa.inicio{background:${rgb('Lima')}}.etapa.cierre{background:${rgb('Rubor')}}
.conds{display:flex;gap:1.6mm}
.conds u,.fig4-ley u{text-decoration:none;width:7.4mm;height:7.4mm;border-radius:2.4mm;display:inline-flex;align-items:center;justify-content:center;font-weight:600;font-size:9pt;line-height:1;background:#EEE9E3}
.conds u:nth-child(1),.fig4-ley span:nth-child(1) u{background:${rgb('Cielo')}}.conds u:nth-child(2),.fig4-ley span:nth-child(2) u{background:${rgb('Lima')}}.conds u:nth-child(3),.fig4-ley span:nth-child(3) u{background:${rgb('Amarillo')}}
.fig4-ley{display:flex;gap:9mm;margin-top:4mm;font-size:11pt;line-height:15pt;color:#6E6964}.fig4-ley span{display:inline-flex;align-items:center;gap:2.4mm}
.fig2{display:grid;grid-template-columns:repeat(6,49mm);justify-content:space-between}
.fig2 img{width:100%;height:auto;display:block;border-radius:5.5mm;border:.3mm solid #E4DED6}
.fig2 .pie{display:flex;align-items:center;gap:2.4mm;margin-top:3.5mm;font-size:11pt;line-height:14pt;font-weight:600}
.fig2 .cir{width:6.6mm;height:6.6mm;font-size:9pt}
.fot{display:grid;gap:5mm}
.fot img{width:100%;aspect-ratio:3/4;object-fit:cover;display:block;border-radius:5.5mm}
.fot .pie{display:flex;align-items:flex-start;gap:2.4mm;margin-top:3.5mm}.fot .pie .n{flex:1;padding-top:.3mm}
.fot .cir{width:6.6mm;height:6.6mm;font-size:9pt}
.pend{border:.5mm dashed #6E6964;border-radius:6mm;padding:10mm 12mm;min-height:60mm;width:${DOBLE}mm;display:grid;align-content:center;justify-items:start;gap:4mm;background:rgba(255,255,255,.5);font-size:14pt;line-height:20pt;color:#6E6964}
.fondo{position:absolute;left:0;top:0;width:100%;height:100%;object-fit:cover;display:block}
.panel{width:${COL}mm;border-radius:9mm;padding:9mm 9mm 9.5mm;display:flex;flex-direction:column;position:relative;border:.3mm solid rgba(20,19,18,.06);overflow:hidden}.panel>*{position:relative}.panel>.fondo{position:absolute}
.panel>.pm{position:absolute;right:9mm;top:9mm;width:11mm;height:11mm}.panel .pm svg{width:100%;height:100%;display:block}
.panel .pn{font-size:150pt;line-height:.82;font-weight:600;letter-spacing:-.06em;margin:16mm 0 0 -1.5mm;font-feature-settings:"tnum"}
.panel.corto .pn{margin-top:4mm}
.panel .pt{font-size:28pt;line-height:31pt;font-weight:600;letter-spacing:-.03em;margin-top:8mm}
.panel .ph{flex:1}
.panel ol{list-style:none;margin-top:auto;padding-top:8mm;display:grid;gap:2.2mm}
.panel li{display:flex;align-items:center;gap:3.5mm;background:rgba(255,255,255,.9);border-radius:5.4mm;padding:2.2mm 4.5mm 2.2mm 2.2mm;font-size:11pt;line-height:14pt;font-weight:600}
.frase{width:${COL}mm;border-radius:7mm;padding:6.5mm 7.5mm 8mm;position:relative;overflow:hidden;border:.3mm solid rgba(20,19,18,.06)}.frase>*{position:relative}.frase>.fondo{position:absolute}
.frase .n{margin-top:4.5mm}
.idx{display:grid;grid-template-columns:${COL}mm ${COL}mm;column-gap:${MED}mm;align-items:start}
.idx .ih{margin-bottom:5.5mm}.idx .ih.dos{margin-top:8mm}
.ir{display:grid;grid-template-columns:auto 1fr 12mm;align-items:center;column-gap:3.5mm;background:#fff;border-radius:4.4mm;padding:1.5mm 4.5mm 1.5mm 1.8mm;margin-bottom:1.7mm;min-height:11.5mm}
.ir.m{padding:1.9mm 4.5mm 1.9mm 2.2mm;min-height:10.2mm}
.fic.vacia{background:#fff;border:.3mm solid #E4DED6}
.anx{display:grid;grid-template-columns:1fr 1fr;gap:3.5mm ${MED}mm;align-items:start}
.anexo{display:grid;grid-template-columns:12mm 1fr;gap:4mm;background:#fff;border-radius:5.5mm;padding:4.5mm 5mm 5mm 4.5mm}
.anexo .fic{width:12mm;height:12mm;border-radius:3.8mm;background:${rgb('Lila')};font-size:14pt}
.portada{width:${W}mm;height:${H}mm;position:relative}
.portada .p-inst{position:absolute;left:26mm;top:24mm;width:160mm}
.portada .p-marca{position:absolute;left:26mm;top:60mm;width:150mm}.portada .p-marca svg{width:100%;height:auto;display:block}
.portada .p-tit{position:absolute;left:26mm;top:116mm;width:230mm}
.portada .p-datos{position:absolute;left:26mm;bottom:24mm;width:${COL + 50}mm}
`;

/** Guarda un PDF con el cuerpo dado, del tamaño exacto de la pieza. */
function pdf(nombre, anchoMm, altoMm, cuerpo, css = '') {
  const f = tmp('pieza'); const salida = path.join(GEN, nombre + '.pdf');
  fs.writeFileSync(f, `<!doctype html><meta charset="utf-8"><style>${CSS_BASE}${CSS_E}${CSS_PIEZAS}@page{size:${anchoMm}mm ${altoMm}mm;margin:0}html,body{width:${anchoMm}mm;height:${altoMm}mm;overflow:hidden}${css}</style>${cuerpo}`);
  chrome(['--no-pdf-header-footer', '--virtual-time-budget=5000', `--print-to-pdf=${salida}`, url(f)]);
  return salida;
}

/** Mide piezas { id, ancho (mm), html }: su alto y dónde cae cada texto vivo (mm). */
function medir(piezas) {
  const f = tmp('medir');
  fs.writeFileSync(f, `<!doctype html><meta charset="utf-8"><style>${CSS_BASE}${CSS_E}${CSS_PIEZAS}
.m{position:absolute;left:0;top:0;visibility:hidden}</style>
${piezas.map((p) => `<div class="m" data-id="${p.id}" style="width:${p.ancho}mm">${p.html}</div>`).join('\n')}
<pre id="out"></pre><script>document.fonts.ready.then(()=>{const o={};document.querySelectorAll('.m').forEach(e=>{const a=e.getBoundingClientRect();o[e.dataset.id]=a.height;const t=e.querySelectorAll('[data-t]');if(t.length){const R={};t.forEach(n=>{const r=n.getBoundingClientRect();R[n.dataset.t]=[r.left-a.left,r.top-a.top,r.width,r.height]});o[e.dataset.id+'#']=R}});document.getElementById('out').textContent='@@'+btoa(JSON.stringify(o))+'@@'})</script>`);
  const dom = chrome(['--virtual-time-budget=30000', '--dump-dom', url(f)]).toString('utf8');
  const m = dom.match(/@@([A-Za-z0-9+/=]+)@@/);
  if (!m) throw new Error('Chrome no devolvió las medidas.');
  const px = JSON.parse(Buffer.from(m[1], 'base64').toString('utf8')); const MM = 25.4 / 96;
  return Object.fromEntries(Object.entries(px).map(([k, v]) => [k, typeof v === 'number' ? v * MM : Object.fromEntries(Object.entries(v).map(([t, r]) => [t, r.map((n) => n * MM)]))]));
}

const htmlTramos = (partes) => partes.map((r) => { const t = h(r.texto); return r.estilo === 'Negrita' ? `<b>${t}</b>` : r.estilo === 'Cursiva' ? `<i>${t}</i>` : r.estilo === 'Negrita cursiva' ? `<b><i>${t}</i></b>` : r.estilo === 'Dato resto' ? `<span class="dr">${t}</span>` : r.estilo === 'Confirmar' ? `<span class="cf">${t}</span>` : r.estilo === 'Pendiente' ? `<span class="pd">${t}</span>` : t; }).join('');
const htmlParrafo = (b) => `<div class="${clase(b.estilo)}">${htmlTramos(b.partes)}</div>`;

/** Aura con grano, como en la app (D-121): la misma semilla da siempre la misma imagen. Solo dibuja las que faltan. */
function auras(lista) {
  const faltan = lista.filter(([n]) => !fs.existsSync(path.join(AURAS, n + '.jpg')));
  if (!faltan.length) return;
  const f = tmp('aura');
  fs.writeFileSync(f, `<!doctype html><body><script>
  const LUCES=['#FFD54A','#F6A3CB','#9DD6F4','#C5B2F6','#FFF3D6'];
  function azar(s){return()=>{s=(s*1664525+1013904223)%4294967296;return s/4294967296}}
  const hexA=(x,a)=>{const n=parseInt(x.slice(1),16);return 'rgba('+(n>>16)+','+((n>>8)&255)+','+(n&255)+','+a+')'};
  function dibujar([nombre,w,h,semilla]){const c=document.createElement('canvas');c.width=w;c.height=h;const g=c.getContext('2d');const r=azar(semilla*7919+17);const m=Math.max(w,h);
    g.fillStyle='#F7F4F0';g.fillRect(0,0,w,h);
    for(const col of LUCES){const x=.08+r()*.84,y=.06+r()*.88,rad=.32+r()*.26;const gr=g.createRadialGradient(x*w,y*h,0,x*w,y*h,rad*m);gr.addColorStop(0,hexA(col,.86));gr.addColorStop(.55,hexA(col,.387));gr.addColorStop(1,hexA(col,0));g.fillStyle=gr;g.fillRect(0,0,w,h)}
    const img=g.getImageData(0,0,w,h),d=img.data;const rg=azar(semilla+3);for(let i=0;i<d.length;i+=4){const n=(rg()-.5)*14;d[i]+=n;d[i+1]+=n;d[i+2]+=n}g.putImageData(img,0,0);
    return [nombre,c.toDataURL('image/jpeg',.84)]}
  document.body.textContent='@@'+btoa(JSON.stringify(Object.fromEntries(${JSON.stringify(faltan)}.map(dibujar))))+'@@';</script>`);
  const dom = chrome(['--virtual-time-budget=20000', '--dump-dom', url(f)]).toString('utf8');
  const json = JSON.parse(Buffer.from(dom.match(/@@([A-Za-z0-9+/=]+)@@/)[1], 'base64').toString('utf8'));
  for (const [n, u] of Object.entries(json)) fs.writeFileSync(path.join(AURAS, n + '.jpg'), Buffer.from(u.split(',')[1], 'base64'));
}

// ---------------------------------------------------------------- Piezas

const svgIcono = (id) => `<svg class="ic" viewBox="0 0 24 24">${MARCA.icons[id]}</svg>`;
const circulo = (contenido) => `<span class="cir">${contenido}</span>`;
let uid = 0;
const marca = () => MARCA.mark.replace(/IDX_/g, `m${uid++}_`);
const lockup = () => MARCA.lockup.replace(/IDX_/g, `l${uid++}_`);
const mayus = (s) => s.replace(/^\p{Ll}/u, (c) => c.toUpperCase());
const ESTADO = /^(Implementado|Cumplido|Avanzado|En curso|Parcial|Pendiente)\b[;:,]?\s*/;
const CAPSULA = { Implementado: 'lleno', Cumplido: 'lleno', Avanzado: '', 'En curso': '', Parcial: '', Pendiente: 'hueco' };
// Icono de la aplicación que acompaña a cada fila, según cómo empieza su primera celda. Sin icono, la fila lleva su número.
const ICONOS = [
  [/^Medición del uso/, 'avance'], [/^Pausa antes/, 'pausar'], [/^Intención preguntada/, 'ayuda'], [/^Bloqueo/, 'privacidad'], [/^Separación física/, 'telefono'], [/^Objeto de foco/, 'estrella'], [/^Recordatorio tangible/, 'avisos'], [/^Localizador/, 'tag'],
  [/^Usuario principal/, 'perfil'], [/^Usuario límite/, 'pelicula'], [/^Convivientes/, 'inicio'], [/^Autor/, 'dibujar'], [/^Herramientas de inteligencia/, 'aura'], [/^Profesores/, 'leer'], [/^Electrónica/, 'maqueta'],
  [/^Sin intención/, 'mas'], [/^Preparación/, 'editar'], [/^Vinculación/, 'conexion'], [/^Situado/, 'lugar'], [/^Activo/, 'contando'], [/^Señal activa/, 'suena'], [/^Fallo técnico/, 'advertencia'], [/^Ciclo cerrado/, 'listo'],
  [/^Tag con pila/, 'tag'], [/^Teléfono Android/, 'telefono'], [/^Servicio remoto/, 'enviar'], [/^Placas/, 'maqueta'],
];
// Cifras: el icono y el color del papel que cumple cada dato en el sistema («un color, un papel»).
const ROL_DATO = [[/primer paso/, 'primer-paso', 'Cielo'], [/sonido|sonó|suena/, 'suena', 'Durazno'], [/en casa|lugar/, 'lugar', 'Lima'], [/empezado|empezó/, 'empece', 'Rubor'], [/tiempo/, 'tiempo', 'Amarillo'], [/./, 'estrella', 'Lila']];

/** Una pieza es un trozo de página compuesto en Chrome: su fondo va al IDML como PDF y sus textos, vivos encima. */
function pieza(id, ancho, armar) {
  const textos = [];
  const T = (estilo, contenido, cls = '') => {
    let partes = typeof contenido === 'string' ? tramos(contenido) : contenido;
    if (/^(Celda|Nota|Índice)/.test(estilo) && estilo !== 'Celda cabecera') partes = sinViuda(partes, 6, 40);
    textos.push({ estilo, partes, columnas: /\bdos\b/.test(cls) ? 2 : 1 });
    return `<div class="${clase(estilo)} n ${cls}" data-t="${textos.length - 1}">${htmlTramos(partes)}</div>`;
  };
  return { id, ancho, html: armar(T), textos };
}

function tipoFigura(b) {
  if (b.fotos) return 'fotos';
  const d = b.descripcion;
  return /datos en tarjetas/.test(d) ? 'datos' : /^diagrama/.test(d) ? 'diagrama' : /capturas/.test(d) ? 'capturas' : /^línea de tiempo/.test(d) ? 'tiempo' : 'foto';
}

/** Tabla o figura completa: rótulo en cápsula, título, cuerpo y nota. Las tablas angostas llevan título y nota al lado. */
function piezaFlotante(b) {
  const nombre = `${b.flotante === 'tabla' ? 'Tabla' : 'Figura'} ${b.n}${b.continua ? ' (continuación)' : ''}`;
  return pieza(`${b.flotante}-${b.n}${b.continua ? '-2' : ''}`, ANCHO, (T) => {
    const rot = `<div class="rot"><span class="pil lleno">${nombre}</span>${T('Título de pieza', b.titulo, 'tp')}</div>`;
    // La nota va en una columna de 118 mm, como el texto; si es larga, en dos.
    const larga = b.nota && !b.angosta && plano(b.nota).length > 240;
    const nota = b.nota ? `<div class="nota${larga ? ' dos' : ''}">${T('Nota', b.nota, larga ? 'dos' : '')}</div>` : '';
    if (b.angosta) return `<div class="ang"><div>${cuerpoFlotante(b, T, DOBLE)}</div><div>${rot}${nota}</div></div>`;
    return rot + cuerpoFlotante(b, T, ANCHO) + nota;
  });
}
function cuerpoFlotante(b, T, ancho) {
  if (b.tipo === 'datos') return fichasDatos(b, T);
  if (b.tipo === 'diagrama') return diagrama();
  if (b.tipo === 'tiempo') return lineaDeTiempo();
  if (b.tipo === 'capturas') return capturas(b);
  if (b.tipo === 'fotos') return fotos(b, T);
  if (b.tipo === 'foto') return `<div class="pend"><span class="pil amarilla">Fotografía pendiente</span><p>${h(mayus(b.descripcion))}.</p></div>`;
  if (/^Participantes/.test(b.titulo)) return fichasPersonas(b, T);
  if (b.filas[0].slice(1).every((c) => /^[A-Z]\. /.test(c))) return matriz(b, T);
  return tablaFichas(b, T, ancho);
}

/** Tabla general: una ficha blanca por fila; la primera celda lleva un círculo con icono, número o versión. */
function tablaFichas(b, T, ancho) {
  const [cab, ...filas] = b.filas; const cols = cab.length, ult = cols - 1;
  const todas = (b.todas || b.filas).slice(1);                        // en una tabla partida, las dos partes miden igual
  const conEstado = todas.every((f) => ESTADO.test(plano(f[ult])));
  const chips = cab.map((_, k) => k > 0 && todas.every((f) => /^(\d+( y \d+)*|Todos)$/.test(f[k])));
  const version = todas.every((f) => /^(Hasta la )?[\d.–]+, /.test(f[0]));
  const peso = cab.map((_, k) => {
    if (chips[k]) return 0.46;
    const largos = [cab, ...todas].map((f) => plano(f[k] || '').length); const max = Math.max(...largos), med = largos.reduce((x, y) => x + y, 0) / largos.length;
    return max <= 14 ? 0.8 : Math.max(1, Math.sqrt(med) / 3.2);
  });
  if (version) peso[0] = 0.72;
  const propio = version ? 0 : 13.5;                                   // el círculo y su aire
  const util = ancho - 0.7 - 4.5 - 6 - 7 * (cols - 1) - propio;
  const suma = peso.reduce((x, y) => x + y, 0);
  const anchos = peso.map((p, k) => Math.round(((p / suma) * util + (k === 0 ? propio : 0)) * 100) / 100);
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
      const signo = ic ? svgIcono(ic[1]) : /^Total/.test(primera) ? '=' : num ? num[1] : String(r + 1 + (b.desde || 0));
      const etiqueta = num ? num[2] : par ? par[1] : f[0];
      pri = `<div class="pri">${circulo(signo)}<div class="tx">${T(num ? 'Celda' : 'Celda primera', etiqueta)}${par && !num ? T('Celda cabecera', mayus(par[2])) : ''}</div></div>`;
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
  let out = `<div class="mz" style="grid-template-columns:56mm repeat(${cab.length - 1},1fr)"><div class="mh0">${T('Celda cabecera', cab[0])}</div>`;
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

/** Diagrama del sistema: seis nodos con el icono y el color de su papel y tres salidas del mismo peso. */
function diagrama() {
  const nodos = [['estrella', 'Lila', 'Intención personal'], ['primer-paso', 'Cielo', 'Primer paso'], ['lugar', 'Lima', 'Lugar elegido'], ['tiempo', 'Amarillo', 'Condición configurada'], ['suena', 'Durazno', 'Pulso ambiental'], ['decidir', 'Rubor', 'Decisión de la persona']];
  const ramas = [['empece', 'Considerar la intención'], ['telefono', 'Seguir en el teléfono'], ['silenciar', 'Silenciar la señal']];
  return `<div class="blanco"><div class="fig1"><div class="fig1-fila">${nodos.map(([i, c, t], k) => `${k ? `<span class="flecha">${svgIcono('siguiente')}</span>` : ''}<div class="nodo"><span class="cuad" style="background:${rgb(c)}">${svgIcono(i)}</span><span>${t}</span></div>`).join('')}</div>` +
    `<div class="fig1-llave"></div><div class="fig1-ramas">${ramas.map(([i, t]) => `<div class="rama"><span class="cuad">${svgIcono(i)}</span><span>${t}</span></div>`).join('')}</div></div></div>`;
}

/** Línea de tiempo de la prueba de 21 días. */
function lineaDeTiempo() {
  const semana = (n, dias) => `<div class="etapa"><span class="dia">Días ${dias}</span><b>Semana ${n}</b><span class="conds"><u>A</u><u>B</u><u>C</u></span><ul><li>Una condición, según la secuencia</li><li>Preguntas tras cada señal</li><li>Escalas semanales</li></ul></div>`;
  return `<div class="fig4"><div class="etapa inicio"><span class="dia">Día 0</span><b>Sesión inicial en el hogar</b><ul><li>Límite de 8 minutos</li><li>Cuatro momentos observados</li><li>Comprobación de autonomía</li></ul></div>` +
    semana(1, '1–7') + semana(2, '8–14') + semana(3, '15–21') +
    `<div class="etapa cierre"><span class="dia">Día 21</span><b>Cierre</b><ul><li>Preguntas de cierre</li><li>Entrevista</li></ul></div></div>` +
    `<div class="fig4-ley"><span><u>A</u> Junto al primer paso</span><span><u>B</u> Lugar neutro</span><span><u>C</u> Teléfono</span></div>`;
}

/** Las seis pantallas de «Preparar», con su número y su nombre. */
function capturas(b) {
  const nombres = [...b.descripcion.matchAll(/«([^»]+)»/g)].map((m) => m[1]);
  return `<div class="fig2">${[1, 2, 3, 4, 5, 6].map((i) => `<div><img src="figuras/preparar-p${i}.png" alt=""><div class="pie">${circulo(i)}<span>${h(nombres[i - 1] || '')}</span></div></div>`).join('')}</div>`;
}

/** Fotografías en fila, del mismo alto, cada una con su letra y su pie. */
function fotos(b, T) {
  return `<div class="fot" style="grid-template-columns:repeat(${b.fotos.length},1fr)">${b.fotos.map((f) => {
    const m = f.pie.match(/^([a-z])\. (.*)$/);
    return `<div><img src="${h(f.src.split(path.sep).join('/'))}" alt=""><div class="pie">${circulo(m ? m[1] : '')}${T('Celda', m ? m[2] : f.pie)}</div></div>`;
  }).join('')}</div>`;
}

/** Panel de apertura: el aura, el número, el título y las secciones. */
function panelHtml({ n, titulo, secciones = [], aura, alto }) {
  const lista = secciones.length && alto >= 128 + secciones.length * 13.6 ? `<ol>${secciones.map((s, k) => `<li><span class="fic">${k + 1}</span><span>${h(s)}</span></li>`).join('')}</ol>` : '';
  return `<div class="panel${alto < 150 ? ' corto' : ''}" style="height:${alto}mm"><img class="fondo" src="figuras/aura/${aura}.jpg" alt=""><div class="pm">${marca()}</div>` +
    (n != null ? `<div class="pn">${String(n).padStart(2, '0')}</div><div class="pt">${h(titulo)}</div>${lista}` : `<div class="ph"></div><div class="pt">${h(titulo)}</div>`) + '</div>';
}

// ---------------------------------------------------------------- Documento

const secciones = leer();
const sec = (titulo) => secciones.find((s) => s.titulo === titulo);
const inicio = secciones[0].lineas.filter((l) => l.trim());          // institución, antes de «# Relevo»
const portada = sec('Relevo').lineas.filter((l) => l.trim());       // subtítulo e identificación
const capitulos = secciones.filter((s) => /^\d+\. /.test(s.titulo)).map((s) => {
  const n = +s.titulo.match(/^(\d+)/)[1];
  return { n, titulo: s.titulo.replace(/^\d+\. /, ''), bloques: bloques(s.lineas), aura: `panel-${10 + n}` };
});
const finales = [
  { titulo: 'Referencias', bloques: bloques(sec('Referencias').lineas, 'Referencia'), aura: 'panel-30' },
  { titulo: 'Glosario', bloques: bloques(sec('Glosario').lineas, 'Glosario'), aura: 'panel-31' },
];
const cuerpo = [...capitulos, ...finales];
const anexos = sec('Anexos').lineas.filter((l) => /^- /.test(l)).map((l) => l.slice(2).match(/^\*\*Anexo ([A-Z])\.\*\* (.*)$/));
// Páginas de entrada: resumen y abstract, con su panel y el texto en columnas, como el cuerpo.
const entradaDe = (titulo, clave) => {
  if (!sec(titulo) || OMITIR.includes(titulo)) return null;
  const bl = bloques(sec(titulo).lineas);
  bl.forEach((b) => { if (clave && clave.test(textoDe(b.partes))) b.estilo = 'Palabras clave'; });
  return bl;
};
const entradas = [
  { titulo: 'Agradecimientos', aura: 'panel-3', bloques: entradaDe('Agradecimientos') },
  { titulo: 'Resumen', aura: 'panel-2', bloques: entradaDe('Resumen', /^Palabras clave/) },
  { titulo: 'Abstract', aura: 'panel-4', bloques: entradaDe('Abstract', /^Keywords/) },
].filter((e) => e.bloques);
const PRIMERA = entradas.length + 3;                                  // portada + entradas + índice; número de la primera página del cuerpo

fs.mkdirSync(GEN, { recursive: true });
for (const f of fs.readdirSync(GEN)) fs.unlinkSync(path.join(GEN, f));
auras([['panel-3', 700, 1530, 3], ['panel-4', 700, 1530, 4]]);

// Piezas fijas y piezas flotantes.
const flot = cuerpo.flatMap((c) => c.bloques.filter((b) => b.flotante));
flot.forEach((b) => {
  b.tipo = b.flotante === 'tabla' ? 'tabla' : tipoFigura(b);
  b.angosta = b.tipo === 'fotos' || (b.flotante === 'tabla' && b.filas[0].length <= 3 && !/^Participantes/.test(b.titulo));   // dos columnas de ancho; título y nota en la tercera
  b.pieza = piezaFlotante(b);
});
const frases = cuerpo.flatMap((c) => c.bloques.filter((b) => b.frase));
const aurasFrase = fs.readdirSync(AURAS).filter((f) => /^frase-/.test(f)).sort((a, b) => parseInt(a.split('-')[2], 10) - parseInt(b.split('-')[2], 10));
frases.forEach((b, i) => {
  b.pieza = pieza(`frase-${i + 1}`, COL, (T) => `<div class="frase"><img class="fondo" src="figuras/aura/${aurasFrase[i % aurasFrase.length]}" alt=""><span class="pil blanca">${h(b.rotulo)}</span>${T('Frase', b.partes)}</div>`);
});
const subtitulo = (portada[0] || '').replace(/ (?=intenciones |durante )/g, '\n').split('\n');
// Portada limpia: institución, logo, título y datos. Lo que falta confirmar va en gris, sin resaltar.
const enGris = (partes) => partes.map((r) => (r.estilo === 'Confirmar' ? { ...r, estilo: 'Pendiente' } : r));
const pPortada = pieza('portada', W, (T) => `<div class="portada">
<div class="p-inst">${inicio.map((l) => T('Portada institución', l)).join('')}</div>
<div class="p-marca">${lockup()}</div>
<div class="p-tit">${subtitulo.map((l) => T('Portada título', l)).join('')}</div>
<div class="p-datos">${portada.slice(1).map((l) => T('Portada dato', enGris(tramos(l)))).join('')}</div></div>`);
const pAnexos = pieza('anexos', DOBLE, (T) => `<div class="anx">${anexos.map((m) => `<div class="anexo"><span class="fic">${m[1]}</span>${T('Celda', m[2])}</div>`).join('')}</div>`);

// Primera medida: cada párrafo en su columna y cada pieza.
const medibles = [];
cuerpo.forEach((c, ci) => c.bloques.forEach((b, bi) => {
  if (b.partes && !b.frase) { b.id = `c${ci}b${bi}`; medibles.push({ id: b.id, ancho: COL, html: htmlParrafo(b) }); }
}));
entradas.forEach((e, ei) => e.bloques.forEach((b, bi) => { b.id = `e${ei}b${bi}`; medibles.push({ id: b.id, ancho: COL, html: htmlParrafo(b) }); }));
[...flot, ...frases].forEach((b) => medibles.push(b.pieza));
medibles.push(pPortada, pAnexos);
console.log(`Midiendo ${medibles.length} párrafos y piezas en Chrome…`);
const alto = medir(medibles);
const lineasDe = (b) => Math.max(1, Math.round(alto[b.id] / PT / E[b.estilo].interlineado));
[...cuerpo, ...entradas].forEach((c) => c.bloques.forEach((b) => { if (b.id) b.lineas = lineasDe(b); }));
[...flot, ...frases, { pieza: pPortada }, { pieza: pAnexos }].forEach((b) => { b.pieza.alto = alto[b.pieza.id]; b.pieza.donde = alto[b.pieza.id + '#'] || {}; });
// Una tabla que no cabe en la página se parte en dos: la segunda parte repite la cabecera y lleva la nota.
const partidas = [];
cuerpo.forEach((c) => {
  for (let i = 0; i < c.bloques.length; i++) {
    const b = c.bloques[i];
    if (b.flotante !== 'tabla' || b.continua || !(b.pieza.alto > BOTTOM - TOP)) continue;
    const [cab, ...filas] = b.filas; const mitad = Math.ceil(filas.length / 2);
    const sigue = { ...b, filas: [cab, ...filas.slice(mitad)], todas: b.filas, desde: mitad, continua: true };
    b.todas = b.filas; b.filas = [cab, ...filas.slice(0, mitad)]; delete b.nota;
    b.pieza = piezaFlotante(b); sigue.pieza = piezaFlotante(sigue);
    c.bloques.splice(i + 1, 0, sigue); flot.splice(flot.indexOf(b) + 1, 0, sigue); partidas.push(b, sigue);
    i++;
  }
});
if (partidas.length) {
  const m = medir(partidas.map((b) => b.pieza));
  partidas.forEach((b) => { b.pieza.alto = m[b.pieza.id]; b.pieza.donde = m[b.pieza.id + '#'] || {}; });
}
flot.forEach((b) => { if (b.pieza.alto > BOTTOM - TOP) console.log(`Atención: la ${b.flotante} ${b.n} mide ${Math.round(b.pieza.alto)} mm y no cabe en la página.`); });

// ---------------------------------------------------------------- Reparto en páginas, línea por línea

let paginas = [];                                      // páginas del cuerpo
const pag = (i) => { while (paginas.length <= i) paginas.push({ banda: 0, flot: [], paneles: [], frases: [], marcos: [], rotulo: null, rotuloPieza: null }); return paginas[i]; };
const colTop = (i) => TOP + (pag(i).banda ? pag(i).banda + AIRE_BANDA : 0);
const altoCol = (i) => BOTTOM - colTop(i);
const soloPiezas = (i) => pag(i).banda > 0 && altoCol(i) < MIN_TEXTO;
let cur = { p: 0, k: 0 };                              // la primera columna libre
const normalizar = () => { while (soloPiezas(cur.p)) { cur.p++; cur.k = 0; } };
const siguiente = () => { cur.k++; if (cur.k === 3) { cur.k = 0; cur.p++; } normalizar(); };
const paginaNueva = () => { if (cur.k !== 0) { cur.k = 0; cur.p++; } normalizar(); };
let ultimaConPieza = 0;

function ubicar(b, q, seccion) {
  const pg = pag(q);
  b.pagina = q; b.y = TOP + (pg.banda ? pg.banda + AIRE_PIEZAS : 0);
  pg.banda = b.y - TOP + b.pieza.alto; pg.flot.push(b); if (!pg.rotulo) pg.rotuloPieza = seccion;
}
/** Una tabla o figura va arriba de la página siguiente a su mención; si no cabe con las que ya hay, en la que sigue. */
function programar(b, p, seccion) {
  if (b.reservada) { ultimaConPieza = Math.max(ultimaConPieza, b.pagina); return; }
  const a = b.pieza.alto; let q = Math.max(p + 1, ultimaConPieza);
  while (pag(q).banda > 0 && pag(q).banda + AIRE_PIEZAS + a > BOTTOM - TOP) q++;
  ubicar(b, q, seccion); ultimaConPieza = q;
}

function componer(c) {
  // Cada sección abre en una página nueva, sin tablas ni figuras de la anterior: el panel en la primera
  // columna y el texto desde la segunda.
  paginaNueva(); while (pag(cur.p).banda > 0) cur.p++;
  c.pagina = cur.p; pag(cur.p).rotulo = c;                // la página lleva el nombre de la sección que abre en ella
  pag(cur.p).paneles.push({ c, k: 0, y: TOP, alto: BOTTOM - TOP });
  // Las tablas y figuras que en una pasada anterior quedaron después del texto de su sección se reservan
  // arriba de su última página de texto, para que no queden solas en una página.
  c.bloques.filter((b) => b.flotante && b.rel).forEach((b) => {
    let q = c.pagina + b.rel;
    while (pag(q).banda > 0 && pag(q).banda + AIRE_PIEZAS + b.pieza.alto > BOTTOM - TOP) q++;
    ubicar(b, q, c); b.reservada = true;
  });
  siguiente();

  c.marcos = [];
  let y = 0, marco = null, previo = null;              // y: puntos desde arriba de la columna
  const cap = () => altoCol(cur.p) / PT;
  const abrir = () => {
    if (marco) return;
    marco = { c, p: cur.p, k: cur.k, y0: y, usado: 0, cont: [] };
    c.marcos.push(marco); pag(cur.p).marcos.push(marco); if (!pag(cur.p).rotulo) pag(cur.p).rotulo = c;
  };
  const saltar = () => { marco = null; previo = null; siguiente(); y = 0; };
  const textos = c.bloques.filter((b) => b.partes && !b.frase);
  for (const b of c.bloques) {
    if (b.flotante) { programar(b, cur.p, c); continue; }
    if (b.frase) {
      const a = b.pieza.alto / PT; const antes = y > 0 ? 5 : 0;
      if (y + antes + a > cap() + 0.5) saltar(); else y += antes;
      pag(cur.p).frases.push({ b, k: cur.k, y: colTop(cur.p) + y * PT }); if (!pag(cur.p).rotulo) pag(cur.p).rotulo = c;
      marco = null; previo = null; y += a + 16; continue;
    }
    const L = E[b.estilo].interlineado, despues = E[b.estilo].despues || 0, n = b.lineas;
    const titulo = b.estilo in AIRE_SUBTITULO;
    const sig = textos[textos.indexOf(b) + 1];
    // Una frase destacada viaja con el párrafo corto que la anuncia: si no caben juntos, saltan juntos.
    const anuncia = (x) => x && x.lineas <= 3 && (c.bloques[c.bloques.indexOf(x) + 1] || {}).frase ? x.lineas * E[x.estilo].interlineado + (E[x.estilo].despues || 0) + 5 + c.bloques[c.bloques.indexOf(x) + 1].pieza.alto / PT : 0;
    if (titulo) {
      // Un subtítulo necesita sitio para sí y para dos líneas de lo que sigue; arriba de una columna no lleva aire.
      const aire = previo ? AIRE_SUBTITULO[b.estilo] : 0;
      const pide = aire + n * L + despues + (anuncia(sig) || (sig ? Math.min(2, sig.lineas) * E[sig.estilo].interlineado : 0));
      if (y + pide > cap() + 0.5 && y > 0) saltar();
      else if (aire) { previo.extra = aire; y += aire; }
    } else if (anuncia(b) && y + anuncia(b) > cap() + 0.5 && y > 0) saltar();
    let resto = n, desde = 0;
    while (resto > 0) {
      const caben = Math.floor((cap() - y + 0.5) / L);
      let toma;
      if (caben >= resto) toma = resto;
      else if (titulo || n < 4) toma = 0;
      else { toma = Math.min(caben, resto - 2); if (toma < 2) toma = 0; }
      if (toma === 0) {
        if (y === 0) { toma = Math.max(1, Math.min(caben, resto)); console.log(`Atención: un párrafo de «${c.titulo}» se cortó a la fuerza.`); } else { saltar(); continue; }
      }
      abrir(); marco.cont.push({ b, desde, n: toma, fin: toma === resto });
      y += toma * L; marco.usado = y - marco.y0; desde += toma; resto -= toma;
      if (resto > 0) saltar(); else { y += despues; previo = b; }
    }
  }
  if (c.marcos.length) c.marcos[c.marcos.length - 1].ultimo = true;
  if (marco || y > 0) siguiente();
}
/** Una página de entrada (resumen, abstract): su texto, en las columnas dadas, con las mismas reglas de viudas. */
function fluir(c, xs) {
  c.marcos = []; let k = 0, y = 0, marco = null;
  const cap = (BOTTOM - TOP) / PT;
  const saltar = () => { marco = null; k++; y = 0; };
  for (const b of c.bloques.filter((x) => x.partes)) {
    const L = E[b.estilo].interlineado, despues = E[b.estilo].despues || 0;
    let resto = b.lineas, desde = 0;
    while (resto > 0) {
      if (k === xs.length) { console.log(`Atención: «${c.titulo}» no cabe en su página.`); return; }
      const caben = Math.floor((cap - y + 0.5) / L);
      let toma = caben >= resto ? resto : b.lineas < 4 ? 0 : Math.min(caben, resto - 2);
      if (toma < resto && toma < 2) toma = 0;
      if (toma === 0) { if (y > 0) { saltar(); continue; } toma = Math.max(1, Math.min(caben, resto)); }
      if (!marco) { marco = { c, x: xs[k], y: TOP + y * PT, ancho: COL, y0: y, cont: [] }; c.marcos.push(marco); }
      marco.cont.push({ b, desde, n: toma, fin: toma === resto });
      y += toma * L; marco.usado = y - marco.y0; desde += toma; resto -= toma;
      if (resto > 0) saltar(); else y += despues;
    }
  }
  c.marcos.forEach((m, i) => { m.ultimo = i === c.marcos.length - 1; m.alto = m.ultimo ? BOTTOM - m.y : Math.min(BOTTOM - m.y, m.usado * PT + HOLGURA); });
}
/** Reparte todo el cuerpo y devuelve la página de los anexos. */
function repartir() {
  paginas = []; cur = { p: 0, k: 0 }; ultimaConPieza = 0;
  cuerpo.forEach((c) => c.bloques.forEach((b) => { delete b.extra; b.reservada = false; }));
  cuerpo.forEach(componer);
  // Anexos: página propia, con su panel y sus fichas.
  paginaNueva(); while (pag(cur.p).banda > 0) cur.p++;
  return cur.p;
}
let pgAnexos = repartir();
// Una tabla o figura que quedó después del último texto de su sección se reserva en esa última página
// (si no es la de apertura) y se reparte de nuevo, hasta que no cambie nada.
for (let pasada = 0; pasada < 3; pasada++) {
  let cambio = false;
  cuerpo.forEach((c) => {
    const ultima = Math.max(...c.marcos.map((m) => m.p));
    c.bloques.filter((b) => b.flotante && !b.rel && b.pagina > ultima && ultima > c.pagina).forEach((b) => { b.rel = ultima - c.pagina; cambio = true; });
  });
  if (!cambio) break;
  pgAnexos = repartir();
}
pag(pgAnexos).rotulo = { titulo: 'Anexos' };
const total = Math.max(pgAnexos, ultimaConPieza) + 1; pag(total - 1);
paginas.forEach((pg, q) => { if (!pg.rotulo) pg.rotulo = pg.rotuloPieza || (paginas.slice(0, q).reverse().find((x) => x.rotulo) || {}).rotulo; });
const numPag = (q) => q + PRIMERA;

// Índice: se compone ahora, con los números de página ya fijos.
const pIndice = pieza('indice', DOBLE, (T) => {
  const fila = (ficha, titulo, n) => `<div class="ir">${ficha}${T('Índice', titulo)}${T('Índice página', String(n))}</div>`;
  const menor = (rot, titulo, n) => `<div class="ir m"><span class="pil clara">${rot}</span>${T('Índice menor', titulo)}${T('Índice menor página', String(n))}</div>`;
  const filas = [...cuerpo.map((c) => fila(c.n != null ? `<span class="fic">${c.n}</span>` : '<span class="fic vacia"></span>', c.titulo, numPag(c.pagina))), fila('<span class="fic vacia"></span>', 'Anexos', numPag(pgAnexos))];
  if (!INDICE_DE_PIEZAS) {
    // Solo las secciones, repartidas en dos columnas.
    const mitad = Math.ceil(filas.length / 2);
    return `<div class="idx"><div>${filas.slice(0, mitad).join('')}</div><div>${filas.slice(mitad).join('')}</div></div>`;
  }
  const piezas = (tipo, nombre) => flot.filter((b) => b.flotante === tipo && !b.continua).map((b) => menor(`${nombre} ${b.n}`, b.titulo, numPag(b.pagina))).join('');
  return `<div class="idx"><div><div class="ih">${T('Subtítulo', 'Capítulos')}</div>${filas.join('')}</div><div><div class="ih">${T('Subtítulo', 'Tablas')}</div>${piezas('tabla', 'Tabla')}<div class="ih dos">${T('Subtítulo', 'Figuras')}</div>${piezas('figura', 'Figura')}</div></div>`;
});
{ const m = medir([pIndice]); pIndice.alto = m.indice; pIndice.donde = m['indice#']; }
if (pIndice.alto > BOTTOM - TOP) console.log(`Atención: el índice mide ${Math.round(pIndice.alto)} mm y no cabe en su página.`);
if (pAnexos.alto > BOTTOM - TOP) console.log(`Atención: los anexos miden ${Math.round(pAnexos.alto)} mm y no caben en su página.`);

// ---------------------------------------------------------------- Modelo de páginas: lo mismo para el IDML y para el PDF

// Cada elemento: { tipo: 'pieza', pieza, x, y } · { tipo: 'panel', html, nombre, x, y, alto } · { tipo: 'marco', marco } · { tipo: 'imagen', archivo, rect }
const hojas = [];
const sinTildes = (s) => s.toLowerCase().normalize('NFD').replace(/[^a-z]/g, '');
const panelDe = (o, x, y, a) => ({ tipo: 'panel', nombre: 'panel-' + (o.n != null ? o.n : sinTildes(o.titulo)), html: panelHtml({ n: o.n, titulo: o.titulo, secciones: (o.bloques || []).filter((b) => b.seccion).map((b) => b.seccion), aura: o.aura, alto: a }), x, y, alto: a });
hojas.push({ sinMaestra: true, items: [{ tipo: 'imagen', archivo: 'figuras/aura/portada.jpg', rect: [-3, -3, W + 6, H + 6], nombre: 'Aura de la portada' }, { tipo: 'pieza', pieza: pPortada, x: 0, y: 0, nombre: 'Portada' }] });
entradas.forEach((e) => {
  fluir(e, [colX(1), colX(2)]);
  hojas.push({ rotulo: e.titulo, items: [panelDe(e, colX(0), TOP, BOTTOM - TOP), ...e.marcos.map((m) => ({ tipo: 'marco', marco: m }))] });
});
hojas.push({ rotulo: 'Índice', items: [panelDe({ titulo: 'Índice', aura: 'panel-5' }, colX(0), TOP, BOTTOM - TOP), { tipo: 'pieza', pieza: pIndice, x: colX(1), y: TOP, nombre: 'Índice' }] });
paginas.forEach((pg, q) => {
  const items = [];
  pg.flot.forEach((b) => items.push({ tipo: 'pieza', pieza: b.pieza, x: MX, y: b.y, nombre: `${b.flotante === 'tabla' ? 'Tabla' : 'Figura'} ${b.n}` }));
  pg.paneles.forEach((pn) => items.push(panelDe(pn.c, colX(pn.k), pn.y, pn.alto)));
  pg.frases.forEach((f) => items.push({ tipo: 'pieza', pieza: f.b.pieza, x: colX(f.k), y: f.y, nombre: f.b.rotulo }));
  pg.marcos.forEach((m) => {
    if (m.x == null) { m.x = colX(m.k); m.y = colTop(m.p) + m.y0 * PT; m.ancho = COL; m.alto = m.ultimo ? BOTTOM - m.y : Math.min(BOTTOM - m.y, m.usado * PT + HOLGURA); }
    items.push({ tipo: 'marco', marco: m });
  });
  if (q === pgAnexos) items.push(panelDe({ titulo: 'Anexos', aura: 'panel-32' }, colX(0), TOP, BOTTOM - TOP), { tipo: 'pieza', pieza: pAnexos, x: colX(1), y: TOP, nombre: 'Anexos' });
  const r = pg.rotulo; hojas.push({ rotulo: r ? (r.n != null ? `${r.n} · ` : '') + r.titulo : '', items });
});
hojas.push({ sinMaestra: true, contra: true, items: [{ tipo: 'imagen', archivo: 'figuras/aura/contraportada.jpg', rect: [-3, -3, W + 6, H + 6], nombre: 'Aura de la contraportada' }] });

// Fondos en PDF: cada pieza sin su texto vivo, y cada panel.
const piezasUnicas = [...new Set(hojas.flatMap((hj) => hj.items.filter((it) => it.tipo === 'pieza').map((it) => it.pieza)))];
console.log(`Dibujando ${piezasUnicas.length} piezas y ${hojas.flatMap((hj) => hj.items).filter((it) => it.tipo === 'panel').length} paneles…`);
piezasUnicas.forEach((pz) => { pz.fondo = pdf(pz.id, pz.ancho, pz.alto, `<div style="width:${pz.ancho}mm">${pz.html}</div>`, '[data-t]{visibility:hidden}'); });
hojas.forEach((hj) => hj.items.forEach((it) => { if (it.tipo === 'panel') it.fondo = pdf(it.nombre, COL, it.alto, it.html); }));
const logo = pdf('logo', 150, 31.5, lockup().replace('<svg ', '<svg style="width:150mm;height:31.5mm;display:block" '));
const DESCRIPTOR = 'Un recordatorio físico preparado desde el teléfono';

// ---------------------------------------------------------------- IDML

const doc = new Idml({ ancho: W, alto: H, sangrado: 3, margenes: [TOP, MX, H - BOTTOM, MX], columnas: 3, medianil: MED });
doc.color('Tinta', [20, 19, 18]);
const PAPEL = doc.color('Papel Relevo', [247, 244, 240]);
doc.color('Gris', [110, 105, 100]);
doc.color('Línea', [204, 198, 190]);
doc.color('Blanco', [255, 255, 255]);
const MARCADOR = doc.color('Marcador', [244, 228, 150]);
LUCES.forEach(([n, c]) => doc.color(n, c));
const tabsDe = (n) => (n === 'Lista' ? [{ pos: 22 }] : n === 'Referencia' ? [{ pos: 18 }] : null);
for (const [nombre, e] of Object.entries(E)) {
  const props = { letra: 'Instrument Sans', idioma: '$ID/Spanish: Castilian', guiones: 'false', alineacion: 'LeftAlign', estilo: 'Regular', ...e };
  if (tabsDe(nombre)) props.tabs = tabsDe(nombre);
  doc.parrafo(nombre, props);
}
doc.caracter('Cursiva', { estilo: 'Italic' });
doc.caracter('Negrita', { estilo: 'SemiBold' });
doc.caracter('Negrita cursiva', { estilo: 'SemiBold Italic' });
doc.caracter('Dato resto', { tamano: 18, estilo: 'Medium', color: 'Color/Gris', seguimiento: 0 });
doc.caracter('Confirmar', { subrayado: 'true', subColor: MARCADOR, subGrosor: 15, subDesplaz: -4 });
doc.caracter('Pendiente', { color: 'Color/Gris' });

const conPeso = (estilo, partes) => (E[estilo] && E[estilo].estilo === 'SemiBold' ? partes.map((r) => (r.estilo === 'Cursiva' ? { ...r, estilo: 'Negrita cursiva' } : r)) : partes);
const P = (estilo, texto) => ({ estilo, partes: typeof texto === 'string' ? [{ texto }] : conPeso(estilo, texto) });
const marcoTexto = (rect, parrafos, extra = {}) => ({ tipo: 'texto', rect, historia: doc.historia(parrafos), ...extra });
const abs = (rel) => path.join(AQUI, rel);

doc.maestra.push({ tipo: 'rect', rect: [-3, -3, W + 6, H + 6], relleno: PAPEL, nombre: 'Papel' });
doc.maestra.push(marcoTexto([MX, 10.5, 150, 6], [P('Encabezado', 'Relevo · Memoria de título')], { capa: 'Folios', nombre: 'Encabezado' }));
doc.maestra.push(marcoTexto([W - MX - 30, 280.5, 30, 7], [{ estilo: 'Folio', partes: [{ folio: true }] }], { capa: 'Folios', nombre: 'Folio' }));

// Una historia por sección: todos sus párrafos, enlazados de marco en marco.
const historiaDe = new Map();
[...entradas, ...cuerpo].forEach((c) => historiaDe.set(c, doc.historia(c.bloques.filter((b) => b.partes && !b.frase).map((b) => ({ estilo: b.estilo, partes: conPeso(b.estilo, b.partes), despues: b.extra ? (E[b.estilo].despues || 0) + b.extra : undefined })))));

function itemsPieza(it) {
  const pz = it.pieza; const out = [{ tipo: 'imagen', archivo: pz.fondo, rect: [it.x, it.y, pz.ancho, pz.alto], ajuste: 'contener', nombre: `${it.nombre}: fondo` }];
  pz.textos.forEach((t, k) => {
    const [rx, ry, rw, rh] = pz.donde[k];
    const cols = t.columnas > 1 ? { columnas: t.columnas, medianil: MED, equilibrar: true } : {};
    out.push(marcoTexto([it.x + rx, it.y + ry + baja(t.estilo), rw, rh + 1.6], [P(t.estilo, t.partes)], { nombre: `${it.nombre}: ${textoDe(t.partes).slice(0, 32)}`, ...cols }));
  });
  return out;
}
hojas.forEach((hj) => {
  const items = [];
  for (const it of hj.items) {
    if (it.tipo === 'imagen') items.push({ tipo: 'imagen', archivo: abs(it.archivo), rect: it.rect, nombre: it.nombre });
    else if (it.tipo === 'pieza') items.push(...itemsPieza(it));
    else if (it.tipo === 'panel') items.push({ tipo: 'imagen', archivo: it.fondo, rect: [it.x, it.y, COL, it.alto], ajuste: 'contener', nombre: 'Panel' });
    else { const m = it.marco; items.push({ tipo: 'texto', rect: [m.x, m.y, m.ancho, m.alto], historia: historiaDe.get(m.c), nombre: m.c.titulo }); }
  }
  if (hj.contra) {
    items.push({ tipo: 'imagen', archivo: logo, rect: [(W - 170) / 2, H / 2 - 30, 170, 35.7], ajuste: 'contener', nombre: 'Logo' });
    items.push(marcoTexto([(W - 260) / 2, H / 2 + 18, 260, 12], [P('Contraportada', DESCRIPTOR)], { nombre: 'Descriptor' }));
  }
  if (hj.rotulo) items.push(marcoTexto([W - MX - 200, 10.5, 200, 6], [P('Encabezado sección', hj.rotulo)], { capa: 'Folios', nombre: 'Sección de la página' }));
  if (hj.sinMaestra) items.sinMaestra = true;
  doc.pagina(items);
});
doc.escribir(SALIDA);

// ---------------------------------------------------------------- El mismo reparto, en HTML y en PDF

const cajaMm = (x, y, w, a, cuerpoHtml) => `<div class="it" style="left:${x}mm;top:${y}mm;width:${w}mm;${a != null ? `height:${a}mm;` : ''}">${cuerpoHtml}</div>`;
function htmlMarco(m) {
  const primero = m.cont[0].b.estilo;
  const dentro = m.cont.map(({ b, desde, n, fin }) => {
    const L = E[b.estilo].interlineado; const mb = fin ? (E[b.estilo].despues || 0) + (b.extra || 0) : 0;
    return `<div style="height:${n * L}pt;overflow:hidden;margin-bottom:${mb}pt"><div class="${clase(b.estilo)}"${desde ? ` style="margin-top:-${desde * L}pt"` : ''}>${htmlTramos(b.partes)}</div></div>`;
  }).join('');
  return cajaMm(m.x, m.y - baja(primero), m.ancho, null, dentro);   // sube lo que Affinity sube: las mayúsculas quedan a ras del marco
}
const htmlHojas = hojas.map((hj, i) => {
  let s = '';
  for (const it of hj.items) {
    if (it.tipo === 'imagen') s += `<img class="it" src="${it.archivo}" alt="" style="left:${it.rect[0]}mm;top:${it.rect[1]}mm;width:${it.rect[2]}mm;height:${it.rect[3]}mm;object-fit:cover">`;
    else if (it.tipo === 'pieza') s += cajaMm(it.x, it.y, it.pieza.ancho, null, it.pieza.html);
    else if (it.tipo === 'panel') s += cajaMm(it.x, it.y, COL, it.alto, it.html);
    else s += htmlMarco(it.marco);
  }
  if (hj.contra) s += cajaMm((W - 170) / 2, H / 2 - 30, 170, null, lockup().replace('<svg ', '<svg style="width:170mm;height:auto;display:block" ')) + cajaMm((W - 260) / 2, H / 2 + 18, 260, null, `<div class="${clase('Contraportada')}">${DESCRIPTOR}</div>`);
  if (!hj.sinMaestra) s += cajaMm(MX, 10.5, 150, null, `<div class="${clase('Encabezado')}">Relevo · Memoria de título</div>`) + cajaMm(W - MX - 200, 10.5, 200, null, `<div class="${clase('Encabezado sección')}">${h(hj.rotulo || '')}</div>`) + cajaMm(W - MX - 30, 280.5, 30, null, `<div class="${clase('Folio')}">${i + 1}</div>`);
  return `<section class="hoja">${s}</section>`;
}).join('\n');
fs.writeFileSync(SALIDA_HTML, `<!doctype html><html lang="es"><head><meta charset="utf-8"><title>Relevo · Memoria de título</title><style>${CSS_BASE}${CSS_E}${CSS_PIEZAS}
@page{size:${W}mm ${H}mm;margin:0}html,body{background:#F7F4F0}
.hoja{width:${W}mm;height:${H}mm;position:relative;overflow:hidden;background:#F7F4F0;break-after:page}.it{position:absolute}
@media screen{body{background:#D9D4CE;padding:8mm 0}.hoja{margin:0 auto 8mm;box-shadow:0 2mm 8mm rgba(0,0,0,.12)}}
</style></head><body>
${htmlHojas}
</body></html>`);
if (fs.existsSync(SALIDA_PDF)) fs.unlinkSync(SALIDA_PDF);
chrome(['--no-pdf-header-footer', '--run-all-compositor-stages-before-draw', '--virtual-time-budget=20000', `--print-to-pdf=${SALIDA_PDF}`, url(SALIDA_HTML)]);
temporales.forEach((f) => { if (fs.existsSync(f)) fs.unlinkSync(f); });

if (process.env.DIAG) paginas.forEach((pg, q) => console.log('PAG', numPag(q), 'banda', Math.round(pg.banda), pg.flot.map((b) => `${b.flotante[0]}${b.n}:${Math.round(b.pieza.alto)}`).join(' '), '| paneles', pg.paneles.map((x) => x.k).join(','), '| marcos', pg.marcos.map((m) => `${m.k != null ? m.k : 'L'}@${Math.round(m.y)}+${Math.round(m.alto)}`).join(' ')));
const nMarcos = cuerpo.reduce((n, c) => n + c.marcos.length, 0);
console.log(`Listo: ${hojas.length} páginas · ${historiaDe.size} historias enlazadas en ${nMarcos} marcos · ${flot.length} tablas y figuras · IDML, HTML y PDF.`);
cuerpo.forEach((c) => console.log(`  ${String(numPag(c.pagina)).padStart(2)}  ${c.n != null ? c.n + '. ' : ''}${c.titulo}`));
console.log(`  ${String(numPag(pgAnexos)).padStart(2)}  Anexos`);
