// Anexos A–I de la memoria. Cada anexo es un Markdown de esta carpeta (anexo-<letra>-<slug>.md), escrito
// para el anexo: recopila lo más relevante de los documentos del proyecto. Este constructor lo lee y arma un
// documento formal, sin diseño propio:
//   1. anexos-relevo.docx, con el formato de la pauta de tesis de la Biblioteca UDP (carta, márgenes de 3,5 cm
//      a la izquierda y 2,5 cm en los demás, Arial 12, interlineado 1,5 y número de página centrado) y su
//      portada, con el logo de la Escuela de Diseño: estilos de Word, tablas, figuras e índice automático;
//   2. anexos-relevo.pdf, el mismo Word exportado por LibreOffice, con la página de cada título en el índice.
// El orden y el título de cada anexo están en contenido-anexos.js. Los Markdown no se reescriben.
//
// Uso: node construir-anexos.js            Word y PDF
//      node construir-anexos.js --sin-pdf  solo el Word; su índice toma las páginas cuando Word actualiza los campos
//
// Necesita Node 18 o posterior y Google Chrome, que convierte en imágenes los diagramas y las figuras de la
// identidad. Para el PDF, LibreOffice y pdftotext (Poppler), que dice en qué página quedó cada título.

'use strict';
const fs = require('fs');
const os = require('os');
const crypto = require('crypto');
const path = require('path');
const { execFileSync } = require('child_process');
const { anexos } = require('./contenido-anexos.js');
const { construirWord } = require('./word.js');

const AQUI = __dirname;
const RAIZ = path.resolve(AQUI, '..', '..');
const SALIDA_WORD = path.join(AQUI, 'anexos-relevo.docx');
const SALIDA_PDF = path.join(AQUI, 'anexos-relevo.pdf');
const CHROME = 'C:/Program Files/Google/Chrome/Application/chrome.exe';
const SOFFICE = ['C:/Program Files/LibreOffice/program/soffice.exe', 'C:/Program Files (x86)/LibreOffice/program/soffice.exe',
  '/usr/bin/soffice', '/Applications/LibreOffice.app/Contents/MacOS/soffice'].find((f) => fs.existsSync(f));
const APP = '06_desarrollo_y_factibilidad/app-android';
const KT = `${APP}/app/src/main/java/com/example/relevo`;
const LOGOS = '10_recursos_visuales/logo-relevo-2026-10-11';
const ICONOS = '10_recursos_visuales/iconos-relevo-2026-10-11/svg';
const LOGO_ESCUELA = '01_contexto_y_fuentes/documentos_institucionales/logotipos-udp-faad/faad-udp-escuela-de-diseno-negro.png';
const MEMORIA = '08_memoria/borrador-memoria-v6-2026-10-28.md';
const DIR_DIAGRAMAS = path.join(AQUI, 'imagenes', 'diagramas');
const DIR_WORD = path.join(AQUI, 'imagenes', 'word');
const MERMAID = 'https://cdn.jsdelivr.net/npm/mermaid@10.9.1/dist/mermaid.min.js';
const ANCHO_WORD_MM = 155; // el ancho del texto en el Word: carta, con márgenes de 3,5 y 2,5 cm
const ESTILO_DIAGRAMAS = 'formal: Arial, negro sobre blanco'; // si cambia, los diagramas se dibujan de nuevo

// ---------------------------------------------------------------- Utilidades

const esc = (s) => String(s).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
const attr = (s) => esc(s).replace(/"/g, '&quot;');
const sinTildes = (s) => s.normalize('NFD').replace(/[\u0300-\u036f]/g, '');
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
      const id = crypto.createHash('sha1').update(`${ESTILO_DIAGRAMAS}\n${codigo}`).digest('hex').slice(0, 10);
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

/** Los datos de la portada, tomados de la portada de la memoria. */
function datosDeMemoria() {
  const l = leer(MEMORIA).split('\n');
  const fin = l.findIndex((x) => /^# Agradecimientos/.test(x));
  const r = l.findIndex((x) => /^# \S/.test(x));
  const limpia = (x) => x.replace(/\s*\[CONFIRMAR:[^\]]*\]/g, '').trim();
  const institucion = l.slice(0, r).map(limpia).filter(Boolean);
  const resto = l.slice(r + 1, fin).map(limpia).filter(Boolean);
  const busca = (lista, re) => {
    const v = lista.find((x) => re.test(x));
    if (!v) throw new Error(`La portada de la memoria no tiene la línea ${re}`);
    return v;
  };
  const subtitulo = resto[0];
  const grado = busca(resto, /^Memoria para optar/);
  const profesores = busca(resto, /^Profesor/);
  const modalidad = busca(resto, /^Modalidad/);
  const lugar = busca(resto, /^Santiago/);
  const autor = resto.find((x) => ![subtitulo, grado, profesores, modalidad, lugar].includes(x));
  const [, ciudad, fecha = ''] = lugar.match(/^(.*?Chile)(?:,\s*(.+))?$/) || [, lugar];
  return {
    titulo: l[r].replace(/^#\s+/, '').trim(), subtitulo, grado, autor, profesores, modalidad, ciudad, fecha,
    facultad: busca(institucion, /^Facultad/), escuela: busca(institucion, /^Escuela/),
  };
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

// ---------------------------------------------------------------- Diagramas y figuras

const svgDiagrama = (id) => fs.readFileSync(path.join(DIR_DIAGRAMAS, `${id}.svg`), 'utf8');

/** Dibuja con mermaid, en Chrome, los diagramas que aún no tienen SVG: Arial, negro sobre blanco. */
function dibujarDiagramas() {
  fs.mkdirSync(DIR_DIAGRAMAS, { recursive: true });
  const faltan = [...DIAGRAMAS].filter(([id]) => !fs.existsSync(path.join(DIR_DIAGRAMAS, `${id}.svg`)));
  if (faltan.length) {
    const letra = 'Arial, Helvetica, sans-serif';
    const tema = {
      fontFamily: letra, fontSize: '13px', background: '#FFFFFF', textColor: '#000000',
      primaryColor: '#FFFFFF', primaryTextColor: '#000000', primaryBorderColor: '#000000', lineColor: '#000000',
      secondaryColor: '#FFFFFF', tertiaryColor: '#FFFFFF', clusterBkg: '#FFFFFF', clusterBorder: '#000000',
      edgeLabelBackground: '#FFFFFF', labelBackgroundColor: '#FFFFFF', noteBkgColor: '#FFFFFF', noteBorderColor: '#000000',
    };
    const datos = JSON.stringify(faltan).replace(/<\//g, '<\\/');
    const guion = String.raw`(async () => {
      mermaid.initialize({ startOnLoad: false, theme: 'base', fontFamily: LETRA, themeVariables: TEMA, flowchart: { curve: 'basis', padding: 12 } });
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
    })();`.replace('LETRA', JSON.stringify(letra)).replace('TEMA', JSON.stringify(tema)).replace('DATOS', datos);
    const tmp = path.join(AQUI, `_diagramas-${process.pid}.html`);
    fs.writeFileSync(tmp, `<!doctype html><html><head><meta charset="utf-8"><style>body { font-family: ${letra}; }</style>` +
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
  // Los que ya no se usan, fuera.
  for (const f of fs.readdirSync(DIR_DIAGRAMAS)) if (f.endsWith('.svg') && !DIAGRAMAS.has(f.slice(0, -4))) fs.unlinkSync(path.join(DIR_DIAGRAMAS, f));
}

/** Cada ficha como HTML, para fotografiarla: un diagrama o una figura armada con los archivos de la marca. */
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
  if (token === 'CIELOS') return `<div class="lamina-cielos">${cielos().map((c) => `<figure><div class="cielo" style="background:${fondoCielo(c, 34)}"></div><figcaption><b>${esc(c.nombre)}</b><small>${c.base}</small></figcaption></figure>`).join('')}</div>`;
  if (token === 'ICONOS') return `<div class="lamina-iconos">${iconos().map((x) => `<figure><svg class="i" viewBox="0 0 24 24" aria-hidden="true">${x.cuerpo}</svg><figcaption>${esc(x.nombre)}</figcaption></figure>`).join('')}</div>`;
  throw new Error(`Ficha desconocida: ${token}`);
}

/** Las figuras siguen el documento: Arial, negro sobre blanco, sin fondos ni adornos. */
const ESTILO_FIGURAS = `* { box-sizing: border-box; margin: 0; padding: 0; }
html, body { background: transparent; }
body { font-family: Arial, Helvetica, sans-serif; font-size: 9pt; line-height: 1.3; color: #000; -webkit-print-color-adjust: exact; print-color-adjust: exact; }
b { font-weight: 700; } small { font-size: inherit; }
.pieza { overflow: hidden; }
svg.i { width: 100%; height: 100%; fill: none; stroke: currentColor; stroke-width: 1.6; stroke-linecap: round; stroke-linejoin: round; display: block; }
.diagrama { text-align: center; line-height: normal; }
.diagrama svg { max-width: 100%; max-height: 160mm; height: auto; }
.diagrama p { margin: 0; max-width: none; }
.logo-grande { width: 96mm; margin: 0 auto 8mm; } .logo-grande img { width: 100%; display: block; }
.logo-versiones { display: grid; grid-template-columns: repeat(7, 1fr); gap: 2.5mm; }
.logo-versiones figure { text-align: center; }
.logo-versiones .caja { height: 20mm; display: grid; place-items: center; border: .25mm solid #000; padding: 2.5mm; }
.logo-versiones .caja img { max-height: 14mm; max-width: 100%; }
.logo-versiones .oscuro .caja { background: #000; }
.logo-versiones figcaption { font-size: 8pt; margin-top: 1.5mm; }
.luces { display: grid; grid-template-columns: repeat(4, 1fr); gap: 3mm; margin-top: 7mm; }
.luz { display: flex; align-items: center; gap: 2mm; }
.luz .punto { width: 7mm; height: 7mm; border-radius: 50%; flex: none; }
.luz b, .base b, .papel b { display: block; font-size: 8.5pt; }
.luz small, .base small, .papel small { display: block; font-size: 8pt; }
.papeles { display: grid; grid-template-columns: repeat(6, 1fr); gap: 3mm; }
.papel .muestra { height: 28mm; display: grid; place-items: center; margin-bottom: 1.5mm; border: .25mm solid #000; }
.ficha-icono { width: 10mm; height: 10mm; display: block; }
.bases { display: grid; grid-template-columns: repeat(3, 1fr); gap: 3mm; margin-top: 6mm; }
.base { display: flex; align-items: center; gap: 2mm; }
.base .muestra { width: 9mm; height: 9mm; flex: none; border: .25mm solid #000; }
.lamina-cielos { display: grid; grid-template-columns: repeat(7, 1fr); gap: 2.5mm; }
.lamina-cielos .cielo { aspect-ratio: 1; border: .25mm solid #000; }
.lamina-cielos figcaption { margin-top: 1.5mm; font-size: 8pt; } .lamina-cielos figcaption b { display: block; }
.lamina-iconos { display: grid; grid-template-columns: repeat(9, 1fr); gap: 3mm 1.5mm; }
.lamina-iconos figure { text-align: center; }
.lamina-iconos svg.i { width: 7mm; height: 7mm; margin: 0 auto 1mm; }
.lamina-iconos figcaption { font-size: 6.5pt; line-height: 1.2; }`;

/**
 * Convierte en PNG las figuras y los diagramas que el Word no puede dibujar: Chrome mide cada pieza y la
 * fotografía sola, a tres veces su tamaño. Se guardan en imagenes/word con una huella de su contenido, así que
 * solo se rehacen si cambian.
 */
function rasterizar(piezas) {
  fs.mkdirSync(DIR_WORD, { recursive: true });
  const pagina = (cuerpo, guion = '') => `<!doctype html><html lang="es"><head><meta charset="utf-8"><style>${ESTILO_FIGURAS}</style></head><body>${cuerpo}${guion}</body></html>`;
  const piezaHtml = (p) => `<div class="pieza" style="width:${p.anchoMm}mm">${p.html}</div>`;
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
    if (!/data-listo="1"/.test(dom) || !m || !m[1]) throw new Error('No se pudieron medir las figuras para el Word');
    const altos = JSON.parse(m[1]);
    faltan.forEach((p, k) => {
      const ancho = Math.ceil(p.anchoMm * 96 / 25.4);
      const alto = Math.ceil(altos[k]);
      const t = path.join(AQUI, `_pieza-${process.pid}-${k}.html`);
      fs.writeFileSync(t, pagina(piezaHtml(p)));
      try { chrome([`--window-size=${ancho},${alto}`, '--force-device-scale-factor=3', '--default-background-color=00000000', `--screenshot=${p.archivo}`, url(t)]); } finally { fs.unlinkSync(t); }
      if (!fs.existsSync(p.archivo)) throw new Error(`No se pudo convertir ${p.clave} en imagen`);
    });
    console.log(`Figuras para el Word: ${faltan.length}`);
  }
  // Las imágenes que ya no se usan, fuera.
  const vigentes = new Set(Object.values(resultado).map((r) => path.basename(r.archivo)));
  for (const f of fs.readdirSync(DIR_WORD)) if (f.endsWith('.png') && !vigentes.has(f)) fs.unlinkSync(path.join(DIR_WORD, f));
  return resultado;
}

// ---------------------------------------------------------------- Chrome, LibreOffice y comprobaciones

function chrome(args) {
  return execFileSync(CHROME, ['--headless=new', '--disable-gpu', '--hide-scrollbars', '--run-all-compositor-stages-before-draw', '--virtual-time-budget=30000', ...args], { maxBuffer: 200 * 1024 * 1024, stdio: ['ignore', 'pipe', 'ignore'] });
}
const url = (archivo) => 'file:///' + archivo.replace(/\\/g, '/');

/** Exporta el Word a PDF con LibreOffice, con un perfil propio para no chocar con un LibreOffice abierto. */
function exportarPdf(docx, carpeta) {
  const perfil = 'file:///' + path.join(carpeta, 'perfil').replace(/\\/g, '/');
  const pdf = path.join(carpeta, path.basename(docx).replace(/\.docx$/, '.pdf'));
  if (fs.existsSync(pdf)) fs.unlinkSync(pdf);
  execFileSync(SOFFICE, [`-env:UserInstallation=${perfil}`, '--headless', '--norestore', '--convert-to', 'pdf', '--outdir', carpeta, docx], { stdio: 'ignore', timeout: 600000 });
  if (!fs.existsSync(pdf)) throw new Error('LibreOffice no pudo exportar el PDF');
  return pdf;
}

/**
 * La página de cada título del índice, leída del PDF con pdftotext. El índice nombra todos los títulos, así que
 * se buscan después de la página donde el índice nombra el último. Devuelve null si falta pdftotext.
 */
function paginasDeTitulos(pdf, titulos) {
  let texto;
  try { texto = execFileSync('pdftotext', ['-enc', 'UTF-8', pdf, '-'], { maxBuffer: 200 * 1024 * 1024, stdio: ['ignore', 'pipe', 'ignore'] }).toString('utf8'); } catch { return null; }
  const norma = (s) => s.normalize('NFC').replace(/\s+/g, '');
  const paginas = texto.split('\f').map(norma);
  let desde = paginas.findIndex((p, i) => i > 0 && p.includes(norma(titulos[titulos.length - 1]))) + 1;
  if (desde <= 0) throw new Error('No se encontró el índice en el PDF');
  return titulos.map((t) => {
    const k = paginas.findIndex((p, i) => i >= desde && p.includes(norma(t)));
    if (k < 0) throw new Error(`No se encontró en el PDF el título «${t}»`);
    desde = k;
    return k + 1;
  });
}

/** Nada de correos en lo que se publica. */
function comprobar(nombre, texto) {
  const correo = texto.match(/[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+\.[A-Za-z]{2,}/g);
  if (correo) throw new Error(`${nombre} contiene un correo: ${[...new Set(correo)].join(', ')}`);
}

// ---------------------------------------------------------------- Armado

function principal() {
  const inicio = Date.now();
  const conPdf = !process.argv.includes('--sin-pdf');
  const arts = anexos.map(leerAnexo);
  dibujarDiagramas();

  // Los diagramas y las figuras de la identidad entran al Word como imágenes; el resto, como texto con estilos.
  const fichas = new Set(arts.flatMap((a) => a.partes.flatMap((p) => p.lineas)).map((l) => (l.trim().match(/^\[\[(.+)\]\]$/) || [])[1]).filter(Boolean));
  const laminas = rasterizar([...fichas].map((f) => ({ clave: f, html: fichaHtml(f), anchoMm: ANCHO_WORD_MM })));
  const m = datosDeMemoria();
  const opciones = {
    salida: SALIDA_WORD, raiz: AQUI, laminas, anexos: arts,
    titulo: `${m.titulo}: anexos de la memoria`, autor: m.autor,
    portada: { ...m, documento: 'Anexos', logo: { archivo: path.join(RAIZ, LOGO_ESCUELA), anchoMm: 60, descripcion: 'Escuela de Diseño, Facultad de Arquitectura, Arte y Diseño, Universidad Diego Portales' } },
  };
  let word = construirWord(opciones);

  // El PDF es el mismo Word, exportado por LibreOffice. Para que el índice tenga páginas, pdftotext dice dónde
  // quedó cada título y el Word se arma otra vez con ellas; se repite hasta que las páginas no cambian.
  let paginas = null;
  if (conPdf && !SOFFICE) console.log('Sin LibreOffice no hay PDF: queda solo el Word.');
  if (conPdf && SOFFICE) {
    const carpeta = fs.mkdtempSync(path.join(os.tmpdir(), 'anexos-relevo-'));
    try {
      for (let vuelta = 1; ; vuelta++) {
        const pdf = exportarPdf(SALIDA_WORD, carpeta);
        const nuevas = paginasDeTitulos(pdf, word.indice);
        const iguales = nuevas && paginas && nuevas.every((p, k) => p === paginas[k]);
        if (!nuevas || iguales || vuelta === 4) {
          fs.copyFileSync(pdf, SALIDA_PDF);
          if (!nuevas) console.log('Sin pdftotext, el índice queda sin páginas hasta que Word actualice los campos.');
          else if (!iguales) console.log('Atención: las páginas del índice no se estabilizaron.');
          break;
        }
        paginas = nuevas;
        word = construirWord({ ...opciones, paginas });
      }
    } finally { fs.rmSync(carpeta, { recursive: true, force: true }); }
  }

  console.log(`Word: ${word.indice.length} entradas en el índice, ${word.imagenes} imágenes, ${(word.peso / 1048576).toFixed(1)} MB`);
  if (paginas) console.log(`PDF: ${(fs.statSync(SALIDA_PDF).size / 1048576).toFixed(1)} MB; los anexos empiezan en las páginas ${arts.map((a) => `${a.letra} ${paginas[word.indice.indexOf(`Anexo ${a.letra}. ${a.titulo}`)]}`).join(', ')}`);
  for (const a of arts) console.log(`Anexo ${a.letra}: ${a.palabras} palabras · ${a.archivo}`);
  console.log(`Listo en ${((Date.now() - inicio) / 1000).toFixed(0)} s`);
}

principal();
