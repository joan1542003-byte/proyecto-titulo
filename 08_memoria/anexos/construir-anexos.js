// Anexos A–I de la memoria. Cada anexo es un Markdown de esta carpeta (anexo-<letra>-<slug>.md), escrito
// para el anexo: recopila lo más relevante de los documentos del proyecto. Este constructor lo lee y arma:
//   1. anexos-relevo.html, con la línea de Relevo: papel, tinta, fichas de color e Instrument Sans;
//   2. anexos-relevo.pdf en A4, impreso por Chrome sin ventana, con la página de cada anexo en el índice;
//   3. anexos-relevo.docx, para Word, con el formato de la pauta de tesis de la Biblioteca UDP (carta, Arial 12,
//      interlineado 1,5): estilos de título y párrafo, tablas, imágenes e índice automático.
// El orden, el color y el resumen de cada anexo están en contenido-anexos.js. Los Markdown no se reescriben.
//
// Uso: node construir-anexos.js            HTML, PDF y Word
//      node construir-anexos.js --sin-pdf  HTML y Word

const fs = require('fs');
const os = require('os');
const crypto = require('crypto');
const path = require('path');
const { execFileSync } = require('child_process');
const { portada, anexos } = require('./contenido-anexos.js');
const { construirWord } = require('./word.js');

const AQUI = __dirname;
const RAIZ = path.resolve(AQUI, '..', '..');
const SALIDA_HTML = path.join(AQUI, 'anexos-relevo.html');
const SALIDA_PDF = path.join(AQUI, 'anexos-relevo.pdf');
const SALIDA_WORD = path.join(AQUI, 'anexos-relevo.docx');
const CHROME = 'C:/Program Files/Google/Chrome/Application/chrome.exe';
const APP = '06_desarrollo_y_factibilidad/app-android';
const KT = `${APP}/app/src/main/java/com/example/relevo`;
const LOGOS = '10_recursos_visuales/logo-relevo-2026-10-11';
const ICONOS = '10_recursos_visuales/iconos-relevo-2026-10-11/svg';
const MEMORIA = '08_memoria/borrador-memoria-v6-2026-10-28.md';
const AURA = '08_memoria/memoria-a3/figuras/aura/portada.jpg';
const DIR_DIAGRAMAS = path.join(AQUI, 'imagenes', 'diagramas');
const DIR_WORD = path.join(AQUI, 'imagenes', 'word');
// Solo se usa cuando falta el SVG de un diagrama: Chrome lo dibuja una vez y el SVG queda en imagenes/diagramas.
const MERMAID = 'https://cdn.jsdelivr.net/npm/mermaid@10.9.1/dist/mermaid.min.js';
const LETRA = '06_desarrollo_y_factibilidad/app-android/app/src/main/res/font/instrument_sans.ttf';
const LETRA_CURSIVA = '08_memoria/memoria-a3/letra/InstrumentSans-Italic.ttf';
const ANCHO_WORD_MM = 155; // el ancho del texto en el Word: carta, con márgenes de 3,5 y 2,5 cm

const MESES = ['enero', 'febrero', 'marzo', 'abril', 'mayo', 'junio', 'julio', 'agosto', 'septiembre', 'octubre', 'noviembre', 'diciembre'];
const hoy = new Date();
const FECHA = `${hoy.getDate()} de ${MESES[hoy.getMonth()]} de ${hoy.getFullYear()}`;

// ---------------------------------------------------------------- Utilidades

const esc = (s) => String(s).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
const attr = (s) => esc(s).replace(/"/g, '&quot;');
const sinTildes = (s) => s.normalize('NFD').replace(/[\u0300-\u036f]/g, '');
/** Texto de comparación: sin tildes, sin marcas ni numeración inicial, en minúsculas. */
const clave = (s) => sinTildes(s).replace(/[*_`«»"“”]/g, '').replace(/^\s*\d+(\.\d+)*\.?\s+/, '').trim().toLowerCase();
const slug = (s) => sinTildes(s).toLowerCase().replace(/<[^>]+>/g, '').replace(/[^a-z0-9]+/g, '-').replace(/^-|-$/g, '');
const desdeAqui = (rel) => path.relative(AQUI, path.join(RAIZ, rel)).split(path.sep).join('/');
const leer = (rel) => fs.readFileSync(path.join(RAIZ, rel), 'utf8').replace(/^\uFEFF/, '').replace(/\r\n?/g, '\n');

// ---------------------------------------------------------------- Lectura de los anexos

const DIAGRAMAS = new Map(); // identificador → código mermaid

/**
 * Lee el Markdown de un anexo: su título, su introducción y sus partes (una por «## »).
 * El registro de cambios queda fuera; cada diagrama mermaid y cada lámina pasan a una ficha [[…]].
 */
function leerAnexo(a) {
  const archivo = `anexo-${a.letra.toLowerCase()}-${a.slug}.md`;
  const texto = fs.readFileSync(path.join(AQUI, archivo), 'utf8').replace(/^\uFEFF/, '').replace(/\r\n?/g, '\n');
  comprobar(archivo, texto);
  const lineas = texto.split('\n');
  const fin = lineas.findIndex((l) => /^##\s+Registro de cambios/.test(l));
  const util = fin >= 0 ? lineas.slice(0, fin) : lineas;

  const limpias = [];
  let mermaid = null;
  let lamina = null;
  for (const l of util) {
    const abre = l.match(/^\s*<!--\s*lamina:\s*([A-Z]+)\s*-->\s*$/);
    if (abre) { lamina = abre[1]; continue; }
    if (lamina) { if (/^\s*<!--\s*\/lamina\s*-->\s*$/.test(l)) { limpias.push(`[[${lamina}]]`); lamina = null; } continue; }
    if (/^\s*```mermaid/.test(l)) { mermaid = []; continue; }
    if (mermaid) {
      if (!/^\s*```\s*$/.test(l)) { mermaid.push(l); continue; }
      const codigo = mermaid.join('\n');
      const id = crypto.createHash('sha1').update(codigo).digest('hex').slice(0, 10);
      DIAGRAMAS.set(id, codigo);
      limpias.push(`[[DIAGRAMA ${id}]]`);
      mermaid = null;
      continue;
    }
    if (/^\s*<!--[\s\S]*-->\s*$/.test(l)) continue;
    limpias.push(l);
  }
  if (lamina || mermaid) throw new Error(`${archivo}: una lámina o un diagrama quedó sin cerrar`);

  const h1 = limpias.findIndex((l) => /^# /.test(l));
  const titulo = limpias[h1].replace(/^#\s+Anexo [A-I]\.\s*/, '').trim();
  if (titulo !== a.titulo) throw new Error(`${archivo}: el título «${titulo}» no coincide con contenido-anexos.js («${a.titulo}»)`);
  const primera = limpias.findIndex((l, i) => i > h1 && /^## /.test(l));
  const intro = limpias.slice(h1 + 1, primera < 0 ? undefined : primera).join('\n').trim().split(/\n\s*\n/).map((p) => p.replace(/\s*\n\s*/g, ' '));
  if (intro.length !== 1) throw new Error(`${archivo}: la introducción debe ser un solo párrafo`);

  const partes = [];
  for (let i = primera; i >= 0 && i < limpias.length; i++) {
    const h = limpias[i].match(/^##\s+(.+?)\s*$/);
    if (h) { partes.push({ titulo: h[1], clase: /^referencias$/i.test(clave(h[1])) ? 'referencias' : '', lineas: [] }); continue; }
    partes[partes.length - 1].lineas.push(limpias[i]);
  }
  for (const p of partes) p.lineas = p.lineas.join('\n').replace(/\n{3,}/g, '\n\n').trim().split('\n');
  return { ...a, archivo, intro: intro[0], partes, palabras: util.join('\n').split(/\s+/).filter(Boolean).length };
}

// ---------------------------------------------------------------- Marca, color e íconos

const LUCES = [['Arriba', '#FFD54A', 'Tu tiempo'], ['Derecha', '#9DD6F4', 'Tu primer paso'], ['Abajo', '#B3E788', 'El lugar donde empiezas'], ['Izquierda', '#F6A3CB', 'Lo que decides']];
const PAPELES = [
  ['butter', '#F4E496', 'Tu tiempo', 'Mantequilla', 'tiempo'], ['sky', '#B3E5FC', 'Tu primer paso', 'Cielo', 'primer-paso'],
  ['lime', '#C6EEAE', 'El lugar', 'Lima', 'lugar'], ['blush', '#FAC8D9', 'Lo que decides', 'Rubor', 'decidir'],
  ['lilac', '#DFD1FC', 'Tu aura', 'Lila', 'aura'], ['peach', '#FBD1B3', 'Después', 'Durazno', 'despues'],
];
const BASE = [['Papel', '#F7F4F0', 'Fondo'], ['Piedra', '#EEE9E3', 'Superficies y el medio'], ['Línea', '#E4DED6', 'Bordes'], ['Grafito', '#6B655F', 'Texto secundario'], ['Tinta', '#141312', 'Texto y selección'], ['Error', '#B3261E', 'Solo errores, con ícono y texto']];
const VERSIONES_LOGO = [
  ['relevo-logo-vertical.svg', 'Vertical'], ['relevo-marca.svg', 'Marca, desde 24 px'], ['relevo-marca-chica.svg', 'Marca chica, de 16 a 23 px'],
  ['relevo-marca-degradado.svg', 'Luz, desde 48 px'], ['relevo-marca-tinta.svg', 'Una tinta'], ['relevo-marca-blanca.svg', 'Sobre fondo oscuro'], ['relevo-icono-app.svg', 'Ícono de la app'],
];

function iconos() {
  const dir = path.join(RAIZ, ICONOS);
  return fs.readdirSync(dir).filter((f) => f.endsWith('.svg')).sort().map((f) => {
    const svg = fs.readFileSync(path.join(dir, f), 'utf8');
    const nombre = (svg.match(/<title>([^<]+)<\/title>/) || [])[1] || f.replace('.svg', '');
    const cuerpo = svg.replace(/^[\s\S]*?<svg[^>]*>/, '').replace(/<\/svg>\s*$/, '').replace(/<title>[^<]*<\/title>/, '').trim();
    return { archivo: f, nombre, cuerpo };
  });
}
const icono = (id) => {
  const i = iconos().find((x) => x.archivo === `${id}.svg`);
  return i ? `<svg class="i" viewBox="0 0 24 24" aria-hidden="true">${i.cuerpo}</svg>` : '';
};

/** Los cielos de las actividades, leídos del código de la app: base, luces y nombre de cada familia. */
function cielos() {
  const kt = leer(`${KT}/ui/components/Sky.kt`);
  const nombres = Object.fromEntries([...kt.matchAll(/Sky\.(\w+) -> "([^"]+)"/g)].filter((m) => m.index > kt.indexOf('familyName')).map((m) => [m[1], m[2]]));
  return [...kt.matchAll(/\/\*\* ([^*]+?) \*\/\s*\n\s*([A-Z]+)\(Color\(0xFF([0-9A-F]{6})\), listOf\(([^\n]+)\)\)\)?,?/g)].map((m) => ({
    id: m[2], nota: m[1], base: `#${m[3]}`, nombre: nombres[m[2]] || m[2],
    luces: [...m[4].matchAll(/SkyBlob\(Color\(0xFF([0-9A-F]{6})\)(?:\.copy\(alpha = ([.\d]+)f\))?, ([.\d]+)f, ([.\d]+)f, ([.\d]+)f\)/g)]
      .map((b) => ({ color: `#${b[1]}`, alfa: b[2] ? +b[2] : 1, x: +b[3], y: +b[4], r: +b[5] })),
  })).filter((c) => c.id !== 'AURA');
}
const rgba = (hex, a) => { const n = parseInt(hex.slice(1), 16); return `rgba(${n >> 16},${(n >> 8) & 255},${n & 255},${+a.toFixed(3)})`; };
/** El mismo dibujo que la app: cada luz es un degradado radial de 0,95 a 0,45 (al 55 %) y a 0, sobre la base. */
const fondoCielo = (c, lado) => c.luces.slice().reverse().map((l) => `radial-gradient(circle ${(l.r * lado).toFixed(1)}mm at ${l.x * 100}% ${l.y * 100}%, ${rgba(l.color, 0.95 * l.alfa)} 0%, ${rgba(l.color, 0.45 * l.alfa)} 55%, ${rgba(l.color, 0)} 100%)`).join(', ') + `, ${c.base}`;

// ---------------------------------------------------------------- Fichas

const svgDiagrama = (id) => fs.readFileSync(path.join(DIR_DIAGRAMAS, `${id}.svg`), 'utf8');

/** Dibuja con mermaid, en Chrome, los diagramas que aún no tienen SVG. */
function dibujarDiagramas() {
  fs.mkdirSync(DIR_DIAGRAMAS, { recursive: true });
  const faltan = [...DIAGRAMAS].filter(([id]) => !fs.existsSync(path.join(DIR_DIAGRAMAS, `${id}.svg`)));
  if (!faltan.length) return;
  const tema = {
    fontFamily: '"Instrument Sans", sans-serif', fontSize: '13px', primaryColor: '#FFFFFF', primaryTextColor: '#141312', primaryBorderColor: '#141312',
    lineColor: '#6B655F', secondaryColor: '#EEE9E3', tertiaryColor: '#F7F4F0', clusterBkg: '#F7F4F0', clusterBorder: '#E4DED6', edgeLabelBackground: '#F7F4F0',
  };
  const datos = JSON.stringify(faltan).replace(/<\//g, '<\\/');
  const guion = String.raw`(async () => {
    await document.fonts.load('13px "Instrument Sans"');
    mermaid.initialize({ startOnLoad: false, theme: 'base', fontFamily: '"Instrument Sans", sans-serif', themeVariables: TEMA, flowchart: { curve: 'basis', padding: 12 } });
    const out = {};
    const proporcion = (svg) => { const v = (svg.match(/viewBox="([^"]+)"/) || [, '0 0 1 1'])[1].split(/\s+/).map(Number); return v[2] / v[3]; };
    for (const [id, codigo] of DATOS) {
      try {
        let svg = (await mermaid.render('diagrama-' + id, codigo)).svg;
        // Una cadena larga de izquierda a derecha no se lee a lo ancho de una página: se dibuja de arriba abajo.
        if (proporcion(svg) > 3.5 && /^\s*(flowchart|graph)\s+LR/m.test(codigo)) svg = (await mermaid.render('diagrama-' + id, codigo.replace(/^(\s*(?:flowchart|graph)\s+)LR/m, '$1TB'))).svg;
        out[id] = svg;
      } catch (e) { out[id] = 'ERROR ' + ((e && e.message) || e); }
    }
    document.getElementById('salida').textContent = JSON.stringify(out).replace(/<\//g, '<\\/');
    document.documentElement.setAttribute('data-listo', '1');
  })();`.replace('TEMA', JSON.stringify(tema)).replace('DATOS', datos);
  const tmp = path.join(AQUI, `_diagramas-${process.pid}.html`);
  fs.writeFileSync(tmp, `<!doctype html><html><head><meta charset="utf-8"><style>@font-face { font-family: "Instrument Sans"; src: url("${desdeAqui(LETRA)}") format("truetype"); font-weight: 400 700; } body { font-family: "Instrument Sans"; }</style>` +
    `<script src="${MERMAID}"></script></head><body><script id="salida" type="application/json"></script><script>${guion}</script></body></html>`);
  let dom;
  try { dom = chrome(['--virtual-time-budget=60000', '--dump-dom', url(tmp)]).toString(); } finally { fs.unlinkSync(tmp); }
  const m = dom.match(/<script id="salida" type="application\/json">([\s\S]*?)<\/script>/);
  if (!/data-listo="1"/.test(dom) || !m || !m[1]) throw new Error('No se pudieron dibujar los diagramas: mermaid se carga desde internet la primera vez.');
  for (const [id, svg] of Object.entries(JSON.parse(m[1]))) {
    if (svg.startsWith('ERROR')) throw new Error(`El diagrama ${id} tiene un error: ${svg}`);
    fs.writeFileSync(path.join(DIR_DIAGRAMAS, `${id}.svg`), svg);
  }
  console.log(`Diagramas dibujados: ${faltan.length}`);
}

function fichaHtml(token) {
  if (token.startsWith('DIAGRAMA')) return `<figure class="diagrama">${svgDiagrama(token.split(' ')[1])}</figure>`;
  if (token === 'LOGO') return `<div class="lamina-logo">
    <div class="logo-grande"><img src="${desdeAqui(`${LOGOS}/relevo-logo-horizontal.svg`)}" alt="Logo de Relevo"></div>
    <div class="logo-versiones">${VERSIONES_LOGO.map(([f, t]) => `<figure${/blanca/.test(f) ? ' class="oscuro"' : ''}><div class="caja"><img src="${desdeAqui(`${LOGOS}/${f}`)}" alt="${attr(t)}"></div><figcaption>${esc(t)}</figcaption></figure>`).join('')}</div>
    <div class="luces">${LUCES.map(([d, c, p]) => `<div class="luz"><span class="punto" style="background:${c}"></span><span><b>${esc(p)}</b><small>${esc(d)} · ${c}</small></span></div>`).join('')}</div>
  </div>`;
  if (token === 'PALETA') return `<div class="lamina-color">
    <div class="papeles">${PAPELES.map(([, c, p, n, ic]) => `<div class="papel"><div class="muestra" style="background:${c}"><span class="ficha-icono">${icono(ic)}</span></div><b>${esc(p)}</b><small>${esc(n)} · ${c}</small></div>`).join('')}</div>
    <div class="bases">${BASE.map(([n, c, u]) => `<div class="base"><span class="muestra" style="background:${c}"></span><span><b>${esc(n)}</b><small>${esc(u)} · ${c}</small></span></div>`).join('')}</div>
  </div>`;
  if (token === 'CIELOS') return `<div class="lamina-cielos">${cielos().map((c) => `<figure><div class="cielo" style="background:${fondoCielo(c, 34)}"><span class="capsula">${esc(c.nombre)}</span></div><figcaption><b>${esc(c.nota.split(':')[0])}</b><small>${c.base}</small></figcaption></figure>`).join('')}</div>`;
  if (token === 'ICONOS') return `<div class="lamina-iconos">${iconos().map((x) => `<figure><svg class="i" viewBox="0 0 24 24" aria-hidden="true">${x.cuerpo}</svg><figcaption>${esc(x.nombre)}</figcaption></figure>`).join('')}</div>`;
  throw new Error(`Ficha desconocida: ${token}`);
}

// ---------------------------------------------------------------- Markdown → HTML

function inline(s) {
  const guardado = [];
  const guardar = (h) => `\u0000${guardado.push(h) - 1}\u0000`;
  let t = String(s);
  // Primero imágenes y enlaces, con su texto crudo: el texto de un enlace puede llevar código.
  t = t.replace(/!\[([^\]]*)\]\(([^)\s]+)\)/g, (_, alt, src) => guardar(`<img src="${attr(decodeURI(src))}" alt="${attr(alt)}">`));
  t = t.replace(/\[([^\]]+)\]\(([^)\s]+)\)/g, (_, txt, url) => guardar(/^https?:/.test(url) ? `<a href="${attr(url)}">${inline(txt)}</a>` : `<span class="enlace">${inline(txt)}</span>`));
  t = t.replace(/`([^`]+)`/g, (_, c) => guardar(`<code>${esc(c)}</code>`));
  t = t.replace(/(https?:\/\/[^\s<>()]+[^\s<>().,;:»”])/g, (u) => guardar(`<a class="url" href="${attr(u)}">${esc(u)}</a>`));
  t = t.replace(/<br\s*\/?>/gi, () => guardar('<br>'));
  t = esc(t);
  t = t.replace(/\*\*(.+?)\*\*/g, '<strong>$1</strong>');
  t = t.replace(/(^|[^*\w])\*(?=\S)(.+?)\*(?!\w)/g, '$1<em>$2</em>');
  t = t.replace(/(^|[\s(«—“])_(?=\S)([^_]+?)_(?=[\s).,;:»—”]|$)/g, '$1<em>$2</em>');
  return t.replace(/\u0000(\d+)\u0000/g, (_, k) => guardado[k]);
}

function celdas(fila) {
  const out = [];
  let actual = '';
  let codigo = false;
  const t = fila.trim().replace(/^\|/, '').replace(/\|$/, '');
  for (let i = 0; i < t.length; i++) {
    const c = t[i];
    if (c === '\\' && t[i + 1] === '|') { actual += '|'; i++; continue; }
    if (c === '`') codigo = !codigo;
    if (c === '|' && !codigo) { out.push(actual.trim()); actual = ''; continue; }
    actual += c;
  }
  out.push(actual.trim());
  return out;
}

const IMAGEN_SOLA = /^!\[([^\]]*)\]\(([^)\s]+)\)$/;

/** Una tabla; si todas sus celdas son imágenes, una galería con el encabezado como pie de cada imagen. */
function tabla(filas) {
  const cab = celdas(filas[0]);
  const alin = celdas(filas[1] || '').map((c) => (/^:-+:$/.test(c) ? ' class="centro"' : /^-+:$/.test(c) ? ' class="num"' : ''));
  const cuerpo = filas.slice(2).map(celdas);
  if (cuerpo.length && cuerpo.every((f) => f.every((c) => IMAGEN_SOLA.test(c)))) {
    const items = cuerpo.flatMap((f) => f.map((c, k) => { const m = c.match(IMAGEN_SOLA); return { src: m[2], pie: cab[k] || m[1] }; }));
    return `<div class="galeria g${cab.length}">${items.map((it) => `<figure><img src="${attr(decodeURI(it.src))}" alt="${attr(it.pie)}"><figcaption>${inline(it.pie)}</figcaption></figure>`).join('')}</div>`;
  }
  const fila = (f) => (cab.length > 1 && f[0] && f.slice(1).every((c) => !c)
    ? `<tr class="grupo"><td colspan="${cab.length}">${inline(f[0])}</td></tr>`
    : `<tr>${cab.map((_, k) => `<td${alin[k] || ''}>${inline(f[k] || '')}</td>`).join('')}</tr>`);
  return `<div class="tabla"><table><thead><tr>${cab.map((c, k) => `<th${alin[k] || ''}>${inline(c)}</th>`).join('')}</tr></thead>` +
    `<tbody>${cuerpo.map(fila).join('')}</tbody></table></div>`;
}

const MARCA_LISTA = /^(\s*)([-*+]|\d+[.)])\s+(.*)$/;
const sangria = (l) => l.match(/^(\s*)/)[1].replace(/\t/g, '    ').length;

/** Una lista con sus sublistas, por sangría. */
function lista(lineas, i) {
  const m0 = lineas[i].match(MARCA_LISTA);
  const base = sangria(lineas[i]);
  const ordenada = /\d/.test(m0[2]);
  const items = [];
  while (i < lineas.length) {
    const l = lineas[i];
    const m = l.match(MARCA_LISTA);
    if (m && sangria(l) === base && /\d/.test(m[2]) === ordenada) { items.push({ texto: [m[3]], hijos: [] }); i++; continue; }
    if (m && sangria(l) > base && items.length) { const r = lista(lineas, i); items[items.length - 1].hijos.push(r.html); i = r.i; continue; }
    if (!l.trim()) {
      let j = i + 1;
      while (j < lineas.length && !lineas[j].trim()) j++;
      const mj = j < lineas.length && lineas[j].match(MARCA_LISTA);
      if (mj && (sangria(lineas[j]) > base || (sangria(lineas[j]) === base && /\d/.test(mj[2]) === ordenada))) { i = j; continue; }
      if (j < lineas.length && items.length && sangria(lineas[j]) > base && !mj) { i = j; continue; }
      break;
    }
    if (m) break;
    if (items.length && (sangria(l) > base || !/^\s*(#|\||>|```|\[\[)/.test(l))) { items[items.length - 1].texto.push(l.trim()); i++; continue; }
    break;
  }
  const inicio = ordenada ? parseInt(m0[2], 10) : 1;
  const etiqueta = ordenada ? 'ol' : 'ul';
  const html = `<${etiqueta}${ordenada && inicio !== 1 ? ` start="${inicio}"` : ''}>${items.map((it) => `<li>${inline(it.texto.join(' '))}${it.hijos.join('')}</li>`).join('')}</${etiqueta}>`;
  return { html, i };
}

/** Bloques de Markdown a HTML. `ids` da a cada encabezado un identificador único. */
function bloquesHtml(lineas, ids, enReferencias = false) {
  const out = [];
  let i = 0;
  while (i < lineas.length) {
    const l = lineas[i];
    if (!l.trim()) { i++; continue; }
    const h = l.match(/^(#{1,6})\s+(.+?)\s*$/);
    if (h) {
      const n = h[1].length;
      out.push(`<h${n} id="${ids(h[2])}">${inline(h[2])}</h${n}>`);
      i++;
      continue;
    }
    const ficha = l.trim().match(/^\[\[(.+)\]\]$/);
    if (ficha) { out.push(fichaHtml(ficha[1])); i++; continue; }
    if (/^\s*```/.test(l)) {
      const codigo = [];
      i++;
      while (i < lineas.length && !/^\s*```/.test(lineas[i])) codigo.push(lineas[i++]);
      i++;
      out.push(`<pre><code>${esc(codigo.join('\n'))}</code></pre>`);
      continue;
    }
    if (/^\s*\|/.test(l)) {
      const filas = [];
      while (i < lineas.length && /^\s*\|/.test(lineas[i])) filas.push(lineas[i++]);
      out.push(tabla(filas));
      continue;
    }
    if (/^\s*>/.test(l)) {
      const cita = [];
      while (i < lineas.length && /^\s*>/.test(lineas[i])) cita.push(lineas[i++].replace(/^\s*>\s?/, ''));
      out.push(`<blockquote>${bloquesHtml(cita, ids)}</blockquote>`);
      continue;
    }
    if (MARCA_LISTA.test(l)) { const r = lista(lineas, i); out.push(r.html); i = r.i; continue; }
    const parrafo = [];
    while (i < lineas.length && lineas[i].trim() && !/^(#{1,6}\s|\s*\||\s*>|\s*```)/.test(lineas[i]) && !MARCA_LISTA.test(lineas[i]) && !/^\[\[/.test(lineas[i].trim())) parrafo.push(lineas[i++].trim());
    const texto = parrafo.join(' ');
    const soloImagen = texto.match(IMAGEN_SOLA);
    // El rótulo y el título de una tabla o figura no se separan de ella.
    const rotulo = /^\*\*(Tabla|Figura) [A-I]?\d+\*\*$/.test(texto);
    const tituloPieza = /^\*[^*].*\*$/.test(texto) && /class="rotulo-pieza"/.test(out[out.length - 1] || '');
    const nota = /^\*Nota\.\*/.test(texto);
    if (soloImagen) out.push(`<figure class="suelta"><img src="${attr(decodeURI(soloImagen[2]))}" alt="${attr(soloImagen[1])}"></figure>`);
    else out.push(`<p${rotulo ? ' class="rotulo-pieza"' : tituloPieza ? ' class="titulo-pieza"' : nota ? ' class="nota"' : enReferencias ? ' class="ref"' : ''}>${inline(texto)}</p>`);
  }
  return out.join('\n');
}

function htmlDeAnexo(a) {
  const k = a.letra.toLowerCase();
  const usados = new Set();
  const ids = (t) => { const base = `${k}-${slug(t)}`.slice(0, 60); let id = base; let n = 2; while (usados.has(id)) id = `${base}-${n++}`; usados.add(id); return id; };
  const conTitulo = a.partes.filter((p) => p.titulo);
  conTitulo.forEach((p) => { p.id = ids(p.titulo); });
  const titulo = (t) => { const m = t.match(/^([A-I]\.\d+)\s+(.*)$/); return m ? `<span class="num">${m[1]}</span> ${inline(m[2])}` : inline(t); };
  return `<section class="anexo" id="anexo-${k}" style="page:anexo-${k}">
  <header class="apertura">
    <div class="apertura-fila"><span class="letra ${a.color}">${a.letra}</span><span class="rotulo">Anexo ${a.letra}</span></div>
    <h1>${inline(a.titulo)}</h1>
    <p class="intro">${inline(a.intro)}</p>
    <ol class="contenido">${conTitulo.map((p) => `<li><a href="#${p.id}">${titulo(p.titulo)}</a></li>`).join('')}</ol>
  </header>
  ${a.partes.map((p) => `<div class="parte${p.clase ? ' ' + p.clase : ''}">${p.titulo ? `<h2 id="${p.id}">${titulo(p.titulo)}</h2>` : ''}${bloquesHtml(p.lineas, ids, p.clase === 'referencias')}</div>`).join('\n')}
</section>`;
}

// ---------------------------------------------------------------- Portada, índice y estilo

/** Datos de la memoria para la portada: institución, título, autor y profesores. */
function datosDeMemoria() {
  const l = leer(MEMORIA).split('\n');
  const fin = l.findIndex((x) => /^# Agradecimientos/.test(x));
  const r = l.findIndex((x) => /^# Relevo\s*$/.test(x));
  const limpia = (x) => x.replace(/\s*\[CONFIRMAR:[^\]]*\]/g, '').trim();
  const institucion = l.slice(0, r).map(limpia).filter(Boolean);
  const resto = l.slice(r + 1, fin).map(limpia).filter((x) => x && !/^Memoria para optar/.test(x));
  return { institucion, subtitulo: resto[0], datos: resto.slice(1) };
}

function portadaHtml() {
  const m = datosDeMemoria();
  return `<section class="portada" style="page:portada;background-image:url('${desdeAqui(AURA)}')">
  <div class="portada-inst">${m.institucion.map((x) => `<span>${inline(x)}</span>`).join('')}</div>
  <div class="portada-marca"><img src="${desdeAqui(`${LOGOS}/relevo-logo-horizontal.svg`)}" alt="Relevo"></div>
  <div class="portada-titulo"><h1>${esc(portada.titulo)}</h1><p>${inline(m.subtitulo)}</p></div>
  <div class="portada-letras">${anexos.map((a) => `<span class="letra ${a.color}">${a.letra}</span>`).join('')}</div>
  <div class="portada-datos">${m.datos.map((x) => `<span>${inline(x)}</span>`).join('')}<span class="fecha">Versión del ${FECHA}</span></div>
</section>`;
}

function indiceHtml(arts, paginas) {
  return `<section class="indice" style="page:indice">
  <h1>Índice</h1>
  <p class="intro">${inline(portada.bajada)}. Nueve anexos que recopilan la evidencia, el diseño y la prueba de Relevo.</p>
  <ol class="indice-lista">${arts.map((a) => `<li><a href="#anexo-${a.letra.toLowerCase()}"><span class="letra ${a.color}">${a.letra}</span><span class="t"><b>${inline(a.titulo)}</b><small>${inline(a.resumen)}</small></span><span class="pag">${paginas ? paginas[a.letra] : ''}</span></a></li>`).join('')}</ol>
</section>`;
}

/** La hoja de estilo de los anexos, compartida por el HTML, el PDF y las láminas del Word. */
function estilo(cabeceras = '') {
  return `@font-face { font-family: "Instrument Sans"; src: url("${desdeAqui(LETRA)}") format("truetype"); font-weight: 400 700; font-style: normal; }
@font-face { font-family: "Instrument Sans"; src: url("${desdeAqui(LETRA_CURSIVA)}") format("truetype"); font-weight: 400 700; font-style: italic; }
:root {
  --paper: #F7F4F0; --stone: #EEE9E3; --line: #E4DED6; --ink: #141312; --graphite: #6B655F; --white: #FFFFFF;
  --butter: #F4E496; --sky: #B3E5FC; --lime: #C6EEAE; --blush: #FAC8D9; --lilac: #DFD1FC; --peach: #FBD1B3;
}
@page { size: A4; margin: 19mm 17mm 18mm 19mm; background: #F7F4F0;
  @top-left { content: "Relevo · Anexos de la memoria"; font: 500 7.2pt "Instrument Sans"; color: #6B655F; vertical-align: bottom; padding-bottom: 3mm; }
  @top-right { font: 600 7.2pt "Instrument Sans"; color: #141312; vertical-align: bottom; padding-bottom: 3mm; }
  @bottom-left { content: "Memoria de Proyecto de Título · Diseño UDP · 2026"; font: 400 7pt "Instrument Sans"; color: #6B655F; vertical-align: top; padding-top: 3mm; }
  @bottom-right { content: counter(page); font: 600 8.4pt "Instrument Sans"; color: #141312; vertical-align: top; padding-top: 3mm; }
}
@page portada { margin: 0; @top-left { content: none; } @top-right { content: none; } @bottom-left { content: none; } @bottom-right { content: none; } }
@page indice { @top-right { content: "Índice"; } }
${cabeceras}
* { box-sizing: border-box; }
html { background: var(--paper); -webkit-print-color-adjust: exact; print-color-adjust: exact; }
body { margin: 0; font-family: "Instrument Sans", "Helvetica Neue", Arial, sans-serif; font-size: 9.4pt; line-height: 1.5; color: var(--ink);
  font-kerning: normal; hyphens: auto; -webkit-hyphens: auto; text-rendering: geometricPrecision; orphans: 2; widows: 2; }
h1, h2, h3, h4, h5, h6, p, figure, blockquote { margin: 0; }
h1, h2, h3, h4, h5, h6 { text-wrap: balance; hyphens: manual; break-after: avoid; font-weight: 600; letter-spacing: -0.012em; }
a { color: inherit; text-decoration: none; }
code { font-family: "Cascadia Mono", Consolas, monospace; font-size: .86em; background: var(--stone); border-radius: 1mm; padding: 0 .8mm; }
pre { background: var(--white); border-radius: 3mm; padding: 3mm 4mm; margin: 0 0 3mm; font-size: 7.8pt; line-height: 1.45; white-space: pre-wrap; break-inside: avoid; box-shadow: inset 0 0 0 .25mm var(--line); }
pre code { background: none; padding: 0; font-size: inherit; }
svg.i { width: 100%; height: 100%; fill: none; stroke: currentColor; stroke-width: 1.6; stroke-linecap: round; stroke-linejoin: round; display: block; }
img { max-width: 100%; }
.url { overflow-wrap: anywhere; hyphens: none; }
mark.confirmar { background: var(--butter); border-radius: 1.2mm; padding: 0 1mm; font-size: .9em; }
mark.confirmar b { font-weight: 600; margin-right: .6mm; }
.letra { display: inline-grid; place-items: center; width: 9mm; height: 9mm; border-radius: 2.8mm; font-weight: 600; font-size: 11pt; background: var(--stone); flex: none; }
.letra.sky { background: var(--sky); } .letra.butter { background: var(--butter); } .letra.lime { background: var(--lime); }
.letra.blush { background: var(--blush); } .letra.lilac { background: var(--lilac); } .letra.peach { background: var(--peach); }

/* Portada: el aura a sangre, como la memoria en A3. */
.portada { width: 210mm; height: 297mm; position: relative; background-size: cover; background-position: center; break-after: page; overflow: hidden; }
.portada-inst { position: absolute; left: 20mm; top: 20mm; display: grid; gap: .8mm; font-size: 9pt; font-weight: 600; }
.portada-marca { position: absolute; left: 20mm; top: 52mm; width: 92mm; }
.portada-marca img { width: 100%; display: block; }
.portada-titulo { position: absolute; left: 20mm; top: 104mm; right: 20mm; }
.portada-titulo h1 { font-size: 64pt; line-height: .95; letter-spacing: -0.035em; }
.portada-titulo p { font-size: 14pt; line-height: 1.3; margin-top: 6mm; max-width: 140mm; font-weight: 500; }
.portada-letras { position: absolute; left: 20mm; top: 178mm; display: flex; gap: 2.4mm; }
.portada-letras .letra { width: 13mm; height: 13mm; border-radius: 4mm; font-size: 14pt; box-shadow: 0 .6mm 2mm rgba(20,19,18,.08); }
.portada-datos { position: absolute; left: 20mm; bottom: 20mm; display: grid; gap: 1.2mm; font-size: 10pt; }
.portada-datos span:first-child { font-weight: 600; }
.portada-datos .fecha { margin-top: 3mm; font-size: 8.6pt; color: var(--graphite); }

/* Índice */
.indice { break-after: page; }
.indice h1 { font-size: 30pt; letter-spacing: -0.03em; margin: 2mm 0 4mm; }
.indice .intro { font-size: 10.4pt; line-height: 1.45; max-width: 150mm; margin-bottom: 8mm; color: var(--graphite); }
.indice-lista { list-style: none; padding: 0; margin: 0; display: grid; gap: 2.2mm; }
.indice-lista a { display: grid; grid-template-columns: 11mm 1fr 12mm; align-items: center; gap: 4mm; background: var(--white); border-radius: 4.4mm; padding: 2.6mm 4mm 2.6mm 2.6mm; }
.indice-lista .letra { width: 11mm; height: 11mm; border-radius: 3.4mm; font-size: 12pt; }
.indice-lista .t b { display: block; font-size: 10.6pt; line-height: 1.25; font-weight: 600; }
.indice-lista .t small { display: block; font-size: 8.4pt; line-height: 1.35; color: var(--graphite); margin-top: .6mm; }
.indice-lista .pag { justify-self: end; font-size: 11pt; font-weight: 600; font-feature-settings: "tnum"; }

/* Apertura de cada anexo */
.anexo { break-before: page; }
.apertura { margin-bottom: 7mm; }
.apertura-fila { display: flex; align-items: center; gap: 3.4mm; }
.apertura .letra { width: 17mm; height: 17mm; border-radius: 5mm; font-size: 22pt; }
.apertura .rotulo { font-size: 10pt; font-weight: 600; color: var(--graphite); }
.apertura h1 { font-size: 25pt; line-height: 1.08; letter-spacing: -0.028em; margin: 5mm 0 3.4mm; max-width: 165mm; }
.apertura .intro { font-size: 10.6pt; line-height: 1.48; max-width: 152mm; }
.contenido { list-style: none; padding: 0; margin: 5mm 0 0; display: flex; flex-wrap: wrap; gap: 1.6mm; }
.contenido a { display: inline-flex; align-items: baseline; gap: 1.4mm; background: var(--white); border-radius: 99px; padding: 1mm 3.4mm 1mm 1.2mm; font-size: 8.2pt; font-weight: 500; box-shadow: inset 0 0 0 .25mm var(--line); }
.contenido .num { font-size: 7.2pt; }

/* Texto */
.parte { margin-bottom: 4mm; }
h2 { font-size: 15pt; line-height: 1.16; margin: 8mm 0 3.4mm; display: flex; align-items: baseline; gap: 2.4mm; }
.parte:first-of-type h2 { margin-top: 2mm; }
h2 .num, .contenido .num { display: inline-block; background: var(--ink); color: var(--white); border-radius: 99px; padding: .5mm 2.2mm; font-size: 8.4pt; font-weight: 600; letter-spacing: 0; font-feature-settings: "tnum"; position: relative; top: -.3mm; flex: none; }
h3 { font-size: 11.6pt; line-height: 1.22; margin: 5.4mm 0 2mm; }
h4 { font-size: 10pt; margin: 4mm 0 1.4mm; }
h5, h6 { font-size: 9.4pt; margin: 3mm 0 1mm; color: var(--graphite); }
p { margin: 0 0 2.2mm; max-width: 158mm; }
ul, ol { margin: 0 0 2.4mm; padding-left: 5mm; max-width: 158mm; }
li { margin: 0 0 .9mm; }
li > ul, li > ol { margin: .9mm 0 0; }
ul { list-style: none; }
ul > li { position: relative; }
ul > li::before { content: ""; position: absolute; left: -3.8mm; top: .62em; width: 1.4mm; height: 1.4mm; border-radius: 50%; background: var(--ink); }
ul ul > li::before { background: none; box-shadow: inset 0 0 0 .3mm var(--ink); }
ul > li.tarea::before { display: none; }
.casilla { display: inline-block; width: 3mm; height: 3mm; border: .3mm solid var(--ink); border-radius: .8mm; margin: 0 1.8mm 0 -4.6mm; vertical-align: -.4mm; background: var(--white); }
.casilla.marcada { background: var(--ink); }
ol { padding-left: 5.6mm; }
ol > li::marker { font-weight: 600; font-feature-settings: "tnum"; }
blockquote { background: var(--white); border-radius: 3.4mm; padding: 3mm 4.4mm .8mm; margin: 0 0 3mm; max-width: 158mm; box-shadow: inset 0 0 0 .25mm var(--line); }
strong { font-weight: 600; }
.enlace { text-decoration: underline; text-decoration-color: var(--line); text-underline-offset: .6mm; }
p.ref { padding-left: 5mm; text-indent: -5mm; font-size: 8.4pt; line-height: 1.42; margin-bottom: 1.6mm; }

/* Tablas */
.tabla { margin: 1mm 0 3.4mm; }
/* El fondo va en las celdas, no en la tabla: así una tabla que sigue en otra página no deja un hueco blanco. */
table { width: 100%; border-collapse: separate; border-spacing: 0; font-size: 7.9pt; line-height: 1.36; }
thead { display: table-header-group; }
tr { break-inside: avoid; }
th { text-align: left; font-weight: 600; background: var(--stone); padding: 1.5mm 2.4mm; vertical-align: bottom; border-top: .25mm solid var(--line); }
td { padding: 1.4mm 2.4mm; border-top: .25mm solid var(--line); vertical-align: top; background: var(--white); }
th:first-child, td:first-child { border-left: .25mm solid var(--line); }
th:last-child, td:last-child { border-right: .25mm solid var(--line); }
tbody tr:last-child td { border-bottom: .25mm solid var(--line); }
thead th:first-child { border-top-left-radius: 3mm; } thead th:last-child { border-top-right-radius: 3mm; }
tbody tr:last-child td:first-child { border-bottom-left-radius: 3mm; } tbody tr:last-child td:last-child { border-bottom-right-radius: 3mm; }
th.num, td.num { text-align: right; font-feature-settings: "tnum"; } th.centro, td.centro { text-align: center; }
td code { white-space: nowrap; }
.registro table { font-size: 7.3pt; line-height: 1.34; }
.registro td:nth-child(1), .registro th:nth-child(1) { width: 11mm; white-space: nowrap; }
.registro td:nth-child(2), .registro th:nth-child(2) { width: 15mm; }
.registro td:nth-child(5), .registro th:nth-child(5) { width: 14mm; }

/* Imágenes */
.galeria { display: grid; gap: 5mm 4mm; margin: 2mm 0 5mm; }
.galeria.g1 { grid-template-columns: 1fr; } .galeria.g2 { grid-template-columns: 1fr 1fr; } .galeria.g5 { grid-template-columns: repeat(5, 1fr); gap: 3mm; }
.galeria figure { break-inside: avoid; }
.galeria img { width: 100%; height: auto; display: block; border-radius: 2.6mm; border: .25mm solid var(--line); background: var(--white); }
.parte.nueva-pagina { break-before: page; }
.diagrama { background: var(--white); border-radius: 4mm; padding: 5mm; margin: 1mm 0 3mm; break-inside: avoid; text-align: center; line-height: normal; hyphens: none; text-rendering: auto; }
.diagrama svg { max-width: 100%; max-height: 160mm; height: auto; }
.diagrama p { margin: 0; max-width: none; }
p.rotulo-pieza { margin: 4mm 0 .4mm; break-after: avoid; }
p.titulo-pieza { margin-bottom: 2mm; break-after: avoid; }
.galeria.g5 img { border-radius: 3.4mm; }
.galeria figcaption { font-size: 8pt; font-weight: 600; margin-top: 1.6mm; }
figure.suelta { margin: 1mm 0 4mm; break-inside: avoid; } figure.suelta img { display: block; border-radius: 2.6mm; }
figure.suelta figcaption { font-size: 8pt; color: var(--graphite); margin-top: 1.4mm; }

/* Láminas de la identidad */
.lamina-logo { background: var(--white); border-radius: 5mm; padding: 9mm 8mm 6mm; margin: 1mm 0 5mm; break-inside: avoid; }
.logo-grande { width: 110mm; margin: 0 auto 9mm; } .logo-grande img { width: 100%; display: block; }
.logo-versiones { display: grid; grid-template-columns: repeat(7, 1fr); gap: 3mm; }
.logo-versiones figure { text-align: center; }
.logo-versiones .caja { height: 21mm; display: grid; place-items: center; background: var(--paper); border-radius: 3mm; padding: 3mm; }
.logo-versiones .caja img { max-height: 15mm; max-width: 100%; }
.logo-versiones .oscuro .caja { background: var(--ink); }
.logo-versiones figcaption { font-size: 7pt; line-height: 1.3; margin-top: 1.4mm; color: var(--graphite); }
.luces { display: grid; grid-template-columns: repeat(4, 1fr); gap: 3mm; margin-top: 6mm; }
.luz { display: flex; align-items: center; gap: 2.4mm; background: var(--paper); border-radius: 99px; padding: 1.6mm 3mm 1.6mm 1.6mm; }
.luz .punto { width: 7mm; height: 7mm; border-radius: 50%; flex: none; }
.luz b, .base b, .papel b { display: block; font-size: 8.4pt; font-weight: 600; line-height: 1.2; }
.luz small, .base small, .papel small { display: block; font-size: 7pt; color: var(--graphite); font-feature-settings: "tnum"; }
.lamina-color { margin: 1mm 0 5mm; break-inside: avoid; }
.papeles { display: grid; grid-template-columns: repeat(6, 1fr); gap: 3mm; }
.papel .muestra { height: 30mm; border-radius: 4mm; display: grid; place-items: center; margin-bottom: 1.8mm; }
.ficha-icono { width: 11mm; height: 11mm; display: block; }
.bases { display: grid; grid-template-columns: repeat(3, 1fr); gap: 2.4mm; margin-top: 4mm; }
.base { display: flex; align-items: center; gap: 2.4mm; background: var(--white); border-radius: 3mm; padding: 1.8mm; }
.base .muestra { width: 9mm; height: 9mm; border-radius: 2.4mm; flex: none; box-shadow: inset 0 0 0 .25mm rgba(20,19,18,.08); }
.lamina-cielos { display: grid; grid-template-columns: repeat(7, 1fr); gap: 2.6mm; margin: 2mm 0 5mm; break-inside: avoid; }
.lamina-cielos .cielo { aspect-ratio: 1; border-radius: 4mm; position: relative; }
.lamina-cielos .capsula { position: absolute; left: 1.4mm; right: 1.4mm; bottom: 1.6mm; background: rgba(255,255,255,.94); border-radius: 99px; padding: .7mm 1.4mm; font-size: 6.4pt; font-weight: 600; text-align: center; line-height: 1.2; }
.lamina-cielos figcaption { margin-top: 1.4mm; } .lamina-cielos figcaption b { display: block; font-size: 7.6pt; line-height: 1.2; } .lamina-cielos figcaption small { font-size: 6.8pt; color: var(--graphite); }
.lamina-iconos { display: grid; grid-template-columns: repeat(9, 1fr); gap: 1.6mm; margin: 2mm 0 5mm; }
.lamina-iconos figure { background: var(--white); border-radius: 2.6mm; padding: 2.6mm 1mm 1.6mm; text-align: center; break-inside: avoid; }
.lamina-iconos svg.i { width: 7mm; height: 7mm; margin: 0 auto 1.2mm; }
.lamina-iconos figcaption { font-size: 6pt; line-height: 1.2; color: var(--graphite); hyphens: auto; }

@media screen {
  body { background: #D9D4CE; padding: 8mm 0; }
  .portada, .indice, .anexo { width: 210mm; margin: 0 auto 8mm; background-color: var(--paper); box-shadow: 0 2mm 8mm rgba(0,0,0,.12); }
  .indice, .anexo { padding: 19mm 17mm 18mm 19mm; }
}
/* Desde el 8 de noviembre de 2026 */
p.nota { font-size: 8pt; line-height: 1.4; color: var(--graphite); margin: 1.4mm 0 4mm; }
tr.grupo td { background: var(--paper); font-weight: 600; }
.galeria + .galeria { margin-top: -1mm; }
.galeria.g3 { grid-template-columns: repeat(3, 1fr); } .galeria.g4 { grid-template-columns: repeat(4, 1fr); }`;
}

function documento(cuerpo, arts) {
  const cabeceras = arts.map((a) => `@page anexo-${a.letra.toLowerCase()} { @top-right { content: "Anexo ${a.letra} · ${a.titulo.replace(/"/g, '\\"')}"; } }`).join('\n');
  return `<!doctype html>
<html lang="es"><head><meta charset="utf-8"><title>Relevo · Anexos de la memoria</title>
<style>
${estilo(cabeceras)}
</style></head><body>
${cuerpo}
</body></html>`;
}

// ---------------------------------------------------------------- Láminas para el Word

/**
 * Convierte en PNG las láminas y los diagramas que el Word no puede dibujar: Chrome mide cada pieza
 * y la fotografía sola, a tres veces su tamaño. Se guardan en imagenes/word con una huella de su
 * contenido, así que solo se rehacen si cambian.
 */
function rasterizar(piezas) {
  fs.mkdirSync(DIR_WORD, { recursive: true });
  const extra = 'html, body { background: transparent !important; margin: 0 !important; padding: 0 !important; }\n' +
    '.pieza { box-sizing: border-box; overflow: hidden; } .pieza.con-fondo { background: #F7F4F0; border-radius: 4mm; padding: 5mm; }\n' +
    '.pieza > :first-child { margin-top: 0 !important; } .pieza > :last-child { margin-bottom: 0 !important; } .pieza .diagrama { margin: 0; }';
  const pagina = (cuerpo, guion = '') => `<!doctype html><html lang="es"><head><meta charset="utf-8"><style>${estilo()}\n${extra}</style></head><body>${cuerpo}${guion}</body></html>`;
  const piezaHtml = (p) => `<div class="pieza${p.fondo === false ? '' : ' con-fondo'}" style="width:${p.anchoMm}mm">${p.html}</div>`;
  const resultado = {};
  const faltan = [];
  for (const p of piezas) {
    const huella = crypto.createHash('sha1').update(pagina(piezaHtml(p))).digest('hex').slice(0, 10);
    const archivo = path.join(DIR_WORD, `${slug(p.clave)}-${huella}.png`);
    resultado[p.clave] = { archivo, anchoMm: p.anchoMm };
    if (!fs.existsSync(archivo)) faltan.push({ ...p, archivo });
  }
  if (faltan.length) {
    const guion = '<script id="salida" type="application/json"></script><script>(async () => {' +
      'await document.fonts.ready; await Promise.all([...document.images].map((im) => im.complete ? 0 : new Promise((r) => { im.onload = im.onerror = r; })));' +
      'document.getElementById("salida").textContent = JSON.stringify([...document.querySelectorAll(".pieza")].map((el) => el.getBoundingClientRect().height));' +
      'document.documentElement.setAttribute("data-listo", "1"); })();</script>';
    const tmp = path.join(AQUI, `_medir-${process.pid}.html`);
    fs.writeFileSync(tmp, pagina(faltan.map(piezaHtml).join('<div style="height:24px"></div>'), guion));
    let dom;
    try { dom = chrome(['--window-size=1400,1000', '--dump-dom', url(tmp)]).toString(); } finally { fs.unlinkSync(tmp); }
    const m = dom.match(/<script id="salida" type="application\/json">([\s\S]*?)<\/script>/);
    if (!/data-listo="1"/.test(dom) || !m || !m[1]) throw new Error('No se pudieron medir las láminas para el Word');
    const altos = JSON.parse(m[1]);
    faltan.forEach((p, k) => {
      const ancho = Math.ceil(p.anchoMm * 96 / 25.4);
      const alto = Math.ceil(altos[k]);
      const t = path.join(AQUI, `_pieza-${process.pid}-${k}.html`);
      fs.writeFileSync(t, pagina(piezaHtml(p)));
      try { chrome([`--window-size=${ancho},${alto}`, '--force-device-scale-factor=3', '--default-background-color=00000000', `--screenshot=${p.archivo}`, url(t)]); } finally { fs.unlinkSync(t); }
      if (!fs.existsSync(p.archivo)) throw new Error(`No se pudo convertir ${p.clave} en imagen`);
    });
    console.log(`Láminas para el Word: ${faltan.length}`);
  }
  // Las imágenes que ya no se usan, fuera.
  const vigentes = new Set(Object.values(resultado).map((r) => path.basename(r.archivo)));
  for (const f of fs.readdirSync(DIR_WORD)) if (f.endsWith('.png') && !vigentes.has(f)) fs.unlinkSync(path.join(DIR_WORD, f));
  return resultado;
}

// ---------------------------------------------------------------- Impresión y comprobaciones

function chrome(args) {
  return execFileSync(CHROME, ['--headless=new', '--disable-gpu', '--hide-scrollbars', '--no-pdf-header-footer', '--run-all-compositor-stages-before-draw', '--virtual-time-budget=30000', ...args], { maxBuffer: 200 * 1024 * 1024, stdio: ['ignore', 'pipe', 'ignore'] });
}
const url = (archivo) => 'file:///' + archivo.replace(/\\/g, '/');
const contarPaginas = (pdf) => (pdf.toString('latin1').match(/\/Type\s*\/Page[^s]/g) || []).length;

/** Imprime un HTML (escrito junto a este archivo, para que sus rutas funcionen) y cuenta sus páginas. */
function imprimir(html, pdf, extra = []) {
  const tmp = path.join(AQUI, `_imprimir-${process.pid}.html`);
  fs.writeFileSync(tmp, html);
  try {
    if (fs.existsSync(pdf)) fs.unlinkSync(pdf);
    chrome([...extra, `--print-to-pdf=${pdf}`, url(tmp)]);
  } finally { fs.unlinkSync(tmp); }
  return contarPaginas(fs.readFileSync(pdf));
}

/** Nada de correos ni de fichas sin dibujar en lo que se publica. */
function comprobar(nombre, texto) {
  const correo = texto.match(/[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+\.[A-Za-z]{2,}/g);
  if (correo) throw new Error(`${nombre} contiene un correo: ${[...new Set(correo)].join(', ')}`);
  if (/\[\[(GALERIA|LOGO|PALETA|CIELOS|ICONOS|DIAGRAMA)/.test(texto) && !/\.md$/.test(nombre)) throw new Error(`${nombre} tiene una ficha sin dibujar`);
}

function principal() {
  const inicio = Date.now();
  const conPdf = !process.argv.includes('--sin-pdf');
  const arts = anexos.map(leerAnexo);
  dibujarDiagramas();
  const htmlAnexos = arts.map(htmlDeAnexo);

  // Páginas: cada anexo empieza en una página nueva, así que se cuentan por separado.
  let paginas = null;
  const tmpPdf = path.join(os.tmpdir(), `anexos-relevo-${process.pid}.pdf`);
  if (conPdf) {
    paginas = {};
    let siguiente = imprimir(documento(portadaHtml() + indiceHtml(arts, null), arts), tmpPdf) + 1;
    arts.forEach((a, k) => {
      a.paginas = imprimir(documento(htmlAnexos[k], arts), tmpPdf);
      paginas[a.letra] = siguiente;
      siguiente += a.paginas;
    });
    fs.unlinkSync(tmpPdf);
  }
  const html = documento([portadaHtml(), indiceHtml(arts, paginas), ...htmlAnexos].join('\n'), arts);
  comprobar('anexos-relevo.html', html);
  fs.writeFileSync(SALIDA_HTML, html);

  if (conPdf) {
    const n = imprimir(html, SALIDA_PDF, ['--generate-pdf-document-outline']);
    const esperado = paginas.I + arts[arts.length - 1].paginas - 1;
    const peso = fs.statSync(SALIDA_PDF).size / 1048576;
    console.log(`PDF: ${n} páginas, ${peso.toFixed(1)} MB${n !== esperado ? ` (atención: el índice esperaba ${esperado})` : ''}`);
  }

  // Word: las láminas y los diagramas van como imágenes; el resto, como texto con estilos.
  const fichas = new Set(arts.flatMap((a) => a.partes.flatMap((p) => p.lineas)).map((l) => (l.trim().match(/^\[\[(.+)\]\]$/) || [])[1]).filter(Boolean));
  const piezas = [...fichas].map((f) => ({ clave: f, html: fichaHtml(f), anchoMm: ANCHO_WORD_MM, fondo: !f.startsWith('DIAGRAMA') }));
  piezas.push({ clave: 'LOGOTIPO', html: `<img src="${desdeAqui(`${LOGOS}/relevo-logo-horizontal.svg`)}" alt="Relevo" style="width:100%;display:block">`, anchoMm: 70, fondo: false });
  const laminas = rasterizar(piezas);
  const m = datosDeMemoria();
  const word = construirWord({
    salida: SALIDA_WORD, raiz: AQUI, laminas, anexos: arts,
    titulo: 'Relevo · Anexos de la memoria', autor: m.datos[0] || 'Relevo',
    portada: { institucion: m.institucion, titulo: portada.titulo, subtitulo: m.subtitulo, datos: m.datos, fecha: `Versión del ${FECHA}`, logo: laminas.LOGOTIPO },
  });
  console.log(`Word: ${word.encabezados} entradas en el índice, ${word.imagenes} imágenes, ${(word.peso / 1048576).toFixed(1)} MB`);

  for (const a of arts) console.log(`Anexo ${a.letra}: ${a.palabras} palabras${a.paginas ? `, ${a.paginas} páginas desde la ${paginas[a.letra]}` : ''} · ${a.archivo}`);
  console.log(`Listo en ${((Date.now() - inicio) / 1000).toFixed(0)} s`);
}

principal();
