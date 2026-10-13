// Memoria de Relevo en A3 horizontal (D-132). Toma el texto de la v5 sin cambiarlo y lo compone con la
// línea de Relevo: papel, tinta, aura con grano, fichas de color, cápsulas e Instrument Sans.
//
// Cómo se arma:
//   1. Node lee la v5 y escribe una página con todos los bloques y un paginador.
//   2. Chrome sin ventana corre el paginador: llena cada página de A3 bloque por bloque, corta los párrafos
//      donde termina la página y deja cada tabla o figura arriba de la página siguiente a su mención.
//      Al final escribe los números del índice. Se guarda el resultado ya paginado (HTML estático).
//   3. Chrome imprime ese HTML a PDF.
//
// Uso: node construir.js

const fs = require('fs');
const path = require('path');
const { execFileSync } = require('child_process');

const AQUI = __dirname;
const FUENTE = path.join(AQUI, '..', 'borrador-memoria-v5-2026-10-11.md');
const SALIDA_HTML = path.join(AQUI, 'memoria-relevo-a3.html');
const SALIDA_PDF = path.join(AQUI, 'memoria-relevo-a3.pdf');
const TEMPORAL = path.join(AQUI, '_paginar.html');
const AURAS = path.join(AQUI, 'figuras', 'aura');
const CHROME = 'C:/Program Files/Google/Chrome/Application/chrome.exe';
const MARCA = JSON.parse(fs.readFileSync(path.join(AQUI, 'marca-e-iconos.json'), 'utf8'));
const LETRA = '../../06_desarrollo_y_factibilidad/app-android/app/src/main/res/font/instrument_sans.ttf';

// ---------------------------------------------------------------- Texto

const esc = (s) => s.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');

/** Marcas en línea: negrita, cursiva, los «CONFIRMAR» y las direcciones web. */
function inline(s) {
  let t = esc(s);
  t = t.replace(/\[CONFIRMAR: ([^\]]+)\]/g, (_, x) => `<mark class="confirmar"><b>Confirmar</b> ${x}</mark>`);
  t = t.replace(/\*\*([^*]+)\*\*/g, '<strong>$1</strong>');
  t = t.replace(/\*([^*]+)\*/g, '<em>$1</em>');
  t = t.replace(/(^|[\s(>«—])_([^_\s][^_]*)_(?=[\s).,;:<»—]|$)/g, '$1<em>$2</em>');
  t = t.replace(/(https?:\/\/[^\s<]+[^\s<.,;)])/g, '<span class="url">$1</span>');
  return t;
}

/** Parte la v5 en secciones de primer nivel y cada una en bloques. */
function leer() {
  const lineas = fs.readFileSync(FUENTE, 'utf8').replace(/\r\n/g, '\n').split('\n');
  const secciones = [];
  let actual = { titulo: '__portada__', lineas: [] };
  for (const l of lineas) {
    if (/^# /.test(l)) { secciones.push(actual); actual = { titulo: l.slice(2).trim(), lineas: [] }; }
    else actual.lineas.push(l);
  }
  secciones.push(actual);
  return secciones.map((s) => ({ titulo: s.titulo, bloques: bloques(s.lineas), palabras: s.lineas.join(' ').split(/\s+/).filter(Boolean).length }));
}

function bloques(lineas) {
  const out = [];
  let i = 0;
  while (i < lineas.length) {
    const l = lineas[i];
    if (!l.trim()) { i++; continue; }
    if (/^## /.test(l)) { out.push({ t: 'h2', x: l.slice(3).trim() }); i++; continue; }
    if (/^### /.test(l)) { out.push({ t: 'h3', x: l.slice(4).trim() }); i++; continue; }
    if (/^> /.test(l)) { out.push({ t: 'cita', x: l.slice(2).trim() }); i++; continue; }
    if (/^\|/.test(l)) {
      const filas = [];
      while (i < lineas.length && /^\|/.test(lineas[i])) { filas.push(lineas[i]); i++; }
      out.push({ t: 'tabla', filas });
      continue;
    }
    if (/^- /.test(l)) {
      const items = [];
      while (i < lineas.length && /^- /.test(lineas[i])) { items.push(lineas[i].slice(2)); i++; }
      out.push({ t: 'ul', items });
      continue;
    }
    if (/^\d+\. /.test(l)) {
      const items = [];
      while (i < lineas.length && /^\d+\. /.test(lineas[i])) { items.push(lineas[i].replace(/^\d+\. /, '')); i++; }
      out.push({ t: 'ol', items });
      continue;
    }
    const partes = [];
    while (i < lineas.length && lineas[i].trim() && !/^(#|>|\||- |\d+\. )/.test(lineas[i])) { partes.push(lineas[i].trim()); i++; }
    out.push({ t: 'p', x: partes.join(' ') });
  }
  return out;
}

// ---------------------------------------------------------------- Aura y cielos con grano

/*
 * El aura (D-121) y el cielo de «Leer» (D-126) se dibujan en un lienzo con grano, como en la app y en la
 * lámina, y se guardan como JPEG: los degradados con transparencia se volvían imágenes pesadas en el PDF.
 * Cada fondo tiene una semilla: la misma semilla da siempre la misma imagen.
 */
const LUCES_AURA = ['#FFD54A', '#F6A3CB', '#9DD6F4', '#C5B2F6', '#FFF3D6'];
const FONDOS = {}; // nombre → { w, h, semilla, tipo }
const fondo = (nombre, w, h, semilla, tipo = 'aura') => { FONDOS[nombre] = { w, h, semilla, tipo }; return `background-image:url('figuras/aura/${nombre}.jpg')`; };

function generarFondos() {
  fs.mkdirSync(AURAS, { recursive: true });
  const faltan = Object.entries(FONDOS).filter(([n]) => !fs.existsSync(path.join(AURAS, `${n}.jpg`)));
  if (!faltan.length) return;
  const script = `
  const LUCES = ${JSON.stringify(LUCES_AURA)};
  const CIELO = { base: '#8DB9EA', blobs: [['#2559C9', .2, .85, .6], ['#E9F3FF', .6, .35, .45], ['#7EA9E8', .85, .7, .45], ['#F7FBFF', .35, .2, .35], ['#3B6BD2', .9, .1, .35]] };
  function azar(s) { return () => { s = (s * 1664525 + 1013904223) % 4294967296; return s / 4294967296; }; }
  const hexA = (h, a) => { const n = parseInt(h.slice(1), 16); return 'rgba(' + (n >> 16) + ',' + ((n >> 8) & 255) + ',' + (n & 255) + ',' + a + ')'; };
  function dibujar([nombre, { w, h, semilla, tipo }]) {
    const c = document.createElement('canvas'); c.width = w; c.height = h; const g = c.getContext('2d'); const r = azar(semilla * 7919 + 17); const m = Math.max(w, h);
    let base, blobs;
    if (tipo === 'cielo') { base = CIELO.base; blobs = CIELO.blobs.map(([col, x, y, rad]) => [col, x, y, rad, 1]); }
    else { base = '#F7F4F0'; blobs = LUCES.map((col) => [col, .08 + r() * .84, .06 + r() * .88, .32 + r() * .26, .86]); }
    g.fillStyle = base; g.fillRect(0, 0, w, h);
    for (const [col, x, y, rad, a] of blobs) {
      const gr = g.createRadialGradient(x * w, y * h, 0, x * w, y * h, rad * m);
      gr.addColorStop(0, hexA(col, a)); gr.addColorStop(.55, hexA(col, a * .45)); gr.addColorStop(1, hexA(col, 0));
      g.fillStyle = gr; g.fillRect(0, 0, w, h);
    }
    const img = g.getImageData(0, 0, w, h), d = img.data; const rg = azar(semilla + 3);
    for (let i = 0; i < d.length; i += 4) { const n = (rg() - .5) * 14; d[i] += n; d[i + 1] += n; d[i + 2] += n; }
    g.putImageData(img, 0, 0);
    return [nombre, c.toDataURL('image/jpeg', .84)];
  }
  document.body.textContent = JSON.stringify(Object.fromEntries(${JSON.stringify(faltan)}.map(dibujar)));`;
  const html = path.join(AURAS, '_generar.html');
  fs.writeFileSync(html, `<!doctype html><html><body><script>${script}</script></body></html>`);
  const salida = chrome(['--virtual-time-budget=20000', '--dump-dom', url(html)]).toString();
  const json = JSON.parse(salida.slice(salida.indexOf('{'), salida.lastIndexOf('}') + 1).replace(/&quot;/g, '"').replace(/&amp;/g, '&'));
  for (const [n, u] of Object.entries(json)) fs.writeFileSync(path.join(AURAS, `${n}.jpg`), Buffer.from(u.split(',')[1], 'base64'));
  fs.unlinkSync(html);
  console.log('fondos generados:', Object.keys(json).length);
}

// ---------------------------------------------------------------- Piezas

const svgIcono = (id) => {
  const d = MARCA.icons[id];
  if (!d) return '';
  return `<svg class="i" viewBox="0 0 24 24" aria-hidden="true">${d.replace(/<circle fill="currentColor" stroke="none"/g, '<circle class="f"')}</svg>`;
};
let uid = 0;
const marca = (plana = false) => (plana ? MARCA.markFlat : MARCA.mark).replace(/IDX_/g, `m${uid++}_`).replace('<svg ', '<svg class="marca" aria-hidden="true" ');
const lockup = () => MARCA.lockup.replace(/IDX_/g, `l${uid++}_`).replace('<svg ', '<svg class="lockup" role="img" aria-label="Relevo" ');

/** Ancho y alto de un PNG, para que la figura ocupe su lugar antes de cargar. */
function medidasPng(archivo) {
  const b = fs.readFileSync(archivo);
  return { w: b.readUInt32BE(16), h: b.readUInt32BE(20) };
}

function tabla(filas) {
  const celdas = (f) => f.replace(/^\||\|$/g, '').split('|').map((c) => c.trim());
  const cab = celdas(filas[0]);
  const alin = celdas(filas[1]).map((c) => (c.endsWith(':') ? ' class="num"' : ''));
  const cuerpo = filas.slice(2).map(celdas);
  return `<table><thead><tr>${cab.map((c, k) => `<th${alin[k]}>${inline(c)}</th>`).join('')}</tr></thead>` +
    `<tbody>${cuerpo.map((f) => `<tr>${f.map((c, k) => `<td${alin[k]}>${inline(c)}</td>`).join('')}</tr>`).join('')}</tbody></table>`;
}

// Figuras que el texto pide «por insertar» y que se pueden dibujar con lo que dice la propia memoria.
// Se reconocen por su descripción, no por su número, para que renumerarlas no las cambie de lugar.
const tipoFigura = (spec) => (/datos en tarjetas/.test(spec) ? 'datos' : /^diagrama/.test(spec) ? 'diagrama' : /capturas/.test(spec) ? 'capturas' : /^línea de tiempo/.test(spec) ? 'tiempo' : 'foto');
const FIG = {
  datos: (spec) => {
    const datos = spec.replace(/^[^:]*: /, '').split('; ').map((d) => d.match(/^(\d+) de (\d+), (.*)$/)).filter(Boolean);
    return `<div style="display:grid;grid-template-columns:repeat(${datos.length},1fr);gap:4mm">${datos.map(([, k, n, t]) =>
      `<div style="background:#fff;border-radius:5mm;padding:5mm"><div style="font-size:34pt;line-height:1;font-weight:600">${k} <span style="font-size:16pt;font-weight:500;color:#6E6964">de ${n}</span></div><p style="margin-top:3mm">${inline(t.replace(/^./, (c) => c.toUpperCase()))}</p></div>`).join('')}</div>`;
  },
  diagrama: () => {
    const nodos = [['estrella', 'stone', 'Intención personal'], ['primer-paso', 'sky', 'Primer paso'], ['lugar', 'lime', 'Lugar elegido'],
      ['tiempo', 'butter', 'Condición configurada'], ['suena', 'lime', 'Pulso ambiental'], ['decidir', 'blush', 'Decisión de la persona']];
    const ramas = [['empece', 'Considerar la intención'], ['telefono', 'Seguir en el teléfono'], ['silenciar', 'Silenciar la señal']];
    return `<div class="fig1"><div class="fig1-fila">${nodos.map(([i, c, t], k) => `${k ? '<span class="flecha">' + svgIcono('siguiente') + '</span>' : ''}<div class="nodo"><span class="ficha ${c}">${svgIcono(i)}</span><b>${t}</b></div>`).join('')}</div>` +
      `<div class="fig1-llave"></div><div class="fig1-ramas">${ramas.map(([i, t]) => `<div class="rama"><span class="ficha stone">${svgIcono(i)}</span><b>${t}</b></div>`).join('')}</div></div>`;
  },
  capturas: () => {
    const pasos = [['p1', '¿Qué quieres hacer?'], ['p2', '¿Cómo empiezas?'], ['p3', '¿Dónde empiezas?'], ['p4', '¿Cuándo suena?'], ['p5', '¿Dónde suena?'], ['p6', 'Todo listo']];
    return `<div class="fig2">${pasos.map(([f, t], k) => {
      const { w, h } = medidasPng(path.join(AQUI, 'figuras', `preparar-${f}.png`));
      return `<figure><img src="figuras/preparar-${f}.png" width="${w}" height="${h}" alt="Pantalla «${t}»"><figcaption><span class="n">${k + 1}</span>${t}</figcaption></figure>`;
    }).join('')}</div>`;
  },
  foto: (spec) => `<div class="fig-pendiente"><span class="pastilla">Fotografía pendiente</span><p>${inline(spec.replace(/^./, (c) => c.toUpperCase()))}.</p></div>`,
  tiempo: () => {
    const semana = (n, dias) => `<div class="etapa semana"><span class="dia">Días ${dias}</span><b>Semana ${n}</b><span class="conds"><i>A</i><i>B</i><i>C</i></span><ul><li>Una condición, según la secuencia</li><li>Preguntas tras cada señal</li><li>Escalas semanales</li></ul></div>`;
    return `<div class="fig4"><div class="etapa inicio"><span class="dia">Día 0</span><b>Sesión inicial en el hogar</b><ul><li>Límite de 8 minutos</li><li>Cuatro momentos observados</li><li>Comprobación de autonomía</li></ul></div>` +
      semana(1, '1–7') + semana(2, '8–14') + semana(3, '15–21') +
      `<div class="etapa cierre"><span class="dia">Día 21</span><b>Cierre</b><ul><li>Preguntas de cierre</li><li>Entrevista</li></ul></div></div>` +
      `<div class="fig4-leyenda"><span><i>A</i> Junto al primer paso</span><span><i>B</i> Lugar neutro</span><span><i>C</i> Teléfono</span></div>`;
  },
};

/** Convierte los bloques de una sección en elementos sueltos que el paginador acomoda uno por uno. */
function cuerpo(bloquesSec, registro, capitulo) {
  let html = '';
  for (let k = 0; k < bloquesSec.length; k++) {
    const b = bloquesSec[k];
    const sig = bloquesSec[k + 1];
    if (b.t === 'h2') { html += `<h2>${inline(b.x)}</h2>`; continue; }
    if (b.t === 'h3') { html += `<h3>${inline(b.x)}</h3>`; continue; }
    if (b.t === 'ul' || b.t === 'ol') {
      html += b.items.map((x, j) => `<div class="item ${b.t === 'ul' ? 'punto' : 'num'}${j === b.items.length - 1 ? ' ultimo' : ''}" data-n="${j + 1}">${inline(x)}</div>`).join('');
      continue;
    }
    if (b.t === 'cita') {
      // La pregunta y la hipótesis, destacadas sobre el aura, dentro de la columna.
      const previo = (bloquesSec[k - 1] || {}).x || '';
      const rotulo = /hipótesis/i.test(previo) ? 'Hipótesis' : /pregunta/i.test(previo) ? 'Pregunta de investigación' : 'Cita';
      html += `<div class="frase" style="${fondo(`frase-${capitulo}-${k}`, 900, 760, capitulo * 31 + k)}"><span class="pastilla">${rotulo}</span><p>${inline(b.x)}</p></div>`;
      continue;
    }
    if (b.t === 'p') {
      const tab = b.x.match(/^\*\*Tabla (\d+)\*\*$/);
      const fig = b.x.match(/^\*\*Figura (\d+)\*\*$/);
      if (tab || fig) {
        const n = Number((tab || fig)[1]);
        const titulo = (sig && sig.t === 'p' && /^\*[^*].*\*$/.test(sig.x)) ? sig.x.slice(1, -1) : '';
        let j = k + (titulo ? 2 : 1);
        let contenido = ''; let tipo = null;
        if (tab && bloquesSec[j] && bloquesSec[j].t === 'tabla') { contenido = tabla(bloquesSec[j].filas); j++; }
        if (fig && bloquesSec[j] && bloquesSec[j].t === 'p' && /^\[FIGURA POR INSERTAR/.test(bloquesSec[j].x)) {
          const spec = bloquesSec[j].x.replace(/^\[FIGURA POR INSERTAR: /, '').replace(/\]$/, '');
          tipo = tipoFigura(spec);
          contenido = FIG[tipo](spec);
          j++;
        }
        let nota = '';
        if (bloquesSec[j] && bloquesSec[j].t === 'p' && /^\*Nota\.\*/.test(bloquesSec[j].x)) {
          let texto = bloquesSec[j].x;
          if (tipo === 'capturas') texto += ' En este borrador, las capturas son de la versión 3.2, en emulador y con datos de prueba; el texto describe la 2.30. [CONFIRMAR: versión que se presentará]';
          nota = `<p class="nota">${inline(texto)}</p>`; j++;
        }
        const id = `${tab ? 'tabla' : 'figura'}-${n}`;
        registro.push({ id, tipo: tab ? 'Tabla' : 'Figura', n, titulo, capitulo });
        html += `<div class="pieza ${tab ? 'pieza-tabla' : 'pieza-figura'}" id="${id}"><div class="rotulo"><span class="pastilla">${tab ? 'Tabla' : 'Figura'} ${n}</span><span class="titulo-pieza">${inline(titulo)}</span></div>${contenido}${nota}</div>`;
        k = j - 1;
        continue;
      }
      const crit = b.x.match(/^\*\*Criterio (\d+): ([^*]+)\*\*\s*(.*)$/);
      if (crit) { html += `<div class="criterio"><span class="n">${crit[1]}</span><p><strong>${inline(crit[2])}</strong> ${inline(crit[3])}</p></div>`; continue; }
      if (/^\*Nota\.\*/.test(b.x)) { html += `<p class="nota">${inline(b.x)}</p>`; continue; }
      html += `<p>${inline(b.x)}</p>`;
      continue;
    }
    if (b.t === 'tabla') { html += `<div class="pieza pieza-tabla">${tabla(b.filas)}</div>`; continue; }
  }
  return html;
}

/** Columna de apertura de cada parte: el aura, el número, el título y sus secciones. */
function panel({ n, rotulo, tituloHtml, secciones = [], semilla }) {
  const lista = secciones.length
    ? `<ol class="secciones">${secciones.map((s, k) => `<li><span class="ficha stone">${k + 1}</span><span>${inline(s)}</span></li>`).join('')}</ol>` : '';
  return `<div class="panel" style="${fondo(`panel-${semilla}`, 700, 1530, semilla)}">` +
    `<div class="panel-arriba"><span class="pastilla">${rotulo}</span><span class="panel-marca">${marca(true)}</span></div>` +
    (n ? `<div class="panel-numero">${String(n).padStart(2, '0')}</div>` : '<div class="panel-hueco"></div>') +
    `<h1 class="panel-titulo">${tituloHtml}</h1>${lista}</div>`;
}

// ---------------------------------------------------------------- Documento

function documento() {
  const secs = leer();
  const porTitulo = (t) => secs.find((s) => s.titulo === t);
  const capitulos = secs.filter((s) => /^\d+\. /.test(s.titulo));
  const registro = [];
  const partes = [];
  const estatica = (id, contenido) => partes.push(`<section class="parte" data-estatica data-id="${id}">${contenido}</section>`);

  // Portada: la marca, el título y, como en la bienvenida de la app, una actividad con su primer paso y su lugar.
  const portada = secs[0].bloques.map((b) => b.x);
  const rel = porTitulo('Relevo').bloques.map((b) => b.x);
  estatica('portada', `<div class="pagina portada" id="portada" style="page:portada;${fondo('portada', 2480, 1754, 3)}">
      <div class="portada-inst">${portada.map((x) => `<span>${inline(x)}</span>`).join('')}</div>
      <div class="portada-marca">${lockup()}</div>
      <div class="portada-titulo"><p class="descriptor">Memoria de título</p><h1>${inline(rel[0])}</h1></div>
      <div class="portada-ejemplo">
        <div class="cielo" style="${fondo('cielo-leer', 700, 700, 1, 'cielo')}"><span class="capsula">Leer</span></div>
        <div class="fila flota uno"><span class="ficha sky">${svgIcono('primer-paso')}</span><span><b>Abrir el libro</b><small>Tu primer paso</small></span></div>
        <div class="fila flota dos"><span class="ficha lime">${svgIcono('lugar')}</span><span><b>En el velador</b><small>Donde empiezas</small></span></div>
      </div>
      <div class="portada-datos">${rel.slice(1).map((x) => `<span>${inline(x)}</span>`).join('')}</div>
    </div>`);

  // Resumen y abstract
  const res = porTitulo('Resumen').bloques, abs = porTitulo('Abstract').bloques;
  const bloque = (b) => b.map((x) => /^\*(Palabras clave|Keywords):\*/.test(x.x)
    ? `<p class="claves">${x.x.replace(/^\*[^*]+\*\s*/, '').split(', ').map((c) => `<span class="pastilla blanca">${inline(c)}</span>`).join('')}</p>`
    : `<p>${inline(x.x)}</p>`).join('');
  estatica('resumen', `<div class="pagina con-panel" id="resumen" style="page:resumen">${panel({ rotulo: 'Memoria', tituloHtml: 'Resumen <span class="suave">y abstract</span>', semilla: 2 })}` +
    `<div class="area dos"><div class="resumen"><h2>Resumen</h2>${bloque(res)}</div><div class="resumen" lang="en"><h2>Abstract</h2>${bloque(abs)}</div></div></div>`);

  // Capítulos (se componen antes del índice para conocer sus tablas y figuras)
  const htmlCapitulos = capitulos.map((c) => {
    const [, num, t] = c.titulo.match(/^(\d+)\. (.*)$/);
    const secciones = c.bloques.filter((b) => b.t === 'h2').map((b) => b.x);
    // Los capítulos breves se leen en letra mayor: el más corto, a una columna, como una lectura.
    const modo = c.palabras < 300 ? 'lectura' : c.palabras < 550 ? 'ajustar' : 'normal';
    return `<section class="parte" data-id="cap-${num}" data-pagina="c${num}" data-modo="${modo}">${panel({ n: Number(num), rotulo: 'Capítulo', tituloHtml: inline(t), secciones, semilla: Number(num) + 10 })}` +
      `<div class="bloques">${cuerpo(c.bloques, registro, Number(num))}</div></section>`;
  });

  // Índice: los números de página los escribe el paginador.
  const filasCap = capitulos.map((c) => {
    const [, num, t] = c.titulo.match(/^(\d+)\. (.*)$/);
    return `<li><span class="ficha stone">${num}</span><span class="t">${inline(t)}</span><span class="pag" data-ref="cap-${num}"></span></li>`;
  }).join('') + ['Referencias', 'Glosario', 'Anexos'].map((t) => `<li><span class="ficha blanca"></span><span class="t">${t}</span><span class="pag" data-ref="${t.toLowerCase()}"></span></li>`).join('');
  const filasPiezas = (tipo) => registro.filter((p) => p.tipo === tipo).map((p) => `<li><span class="pastilla blanca">${tipo} ${p.n}</span><span class="t">${inline(p.titulo)}</span><span class="pag" data-ref="${p.id}"></span></li>`).join('');
  estatica('indice', `<div class="pagina con-panel" id="indice" style="page:indice">${panel({ rotulo: 'Memoria', tituloHtml: 'Índice', semilla: 5 })}` +
    `<div class="area dos"><div class="indice"><h2>Capítulos</h2><ol class="indice-lista">${filasCap}</ol></div>` +
    `<div class="indice"><h2>Tablas</h2><ol class="indice-lista piezas">${filasPiezas('Tabla')}</ol><h2>Figuras</h2><ol class="indice-lista piezas">${filasPiezas('Figura')}</ol></div></div></div>`);

  partes.push(...htmlCapitulos);

  // Referencias y glosario, a tres columnas; anexos, en fichas.
  [['Referencias', 'referencias', 30, 'ref'], ['Glosario', 'glosario', 31, 'glos']].forEach(([titulo, id, semilla, clase]) => {
    const s = porTitulo(titulo);
    partes.push(`<section class="parte" data-id="${id}" data-pagina="${id}" data-modo="normal"${id === 'glosario' ? ' data-apretar' : ''}>${panel({ rotulo: 'Memoria', tituloHtml: titulo, semilla })}` +
      `<div class="bloques">${s.bloques.map((b) => `<p class="${clase}">${inline(b.x)}</p>`).join('')}</div></section>`);
  });
  const anexos = porTitulo('Anexos').bloques.find((b) => b.t === 'ul').items;
  estatica('anexos', `<div class="pagina con-panel" id="anexos" style="page:anexos">${panel({ rotulo: 'Memoria', tituloHtml: 'Anexos', semilla: 32 })}` +
    `<div class="area anexos">${anexos.map((x) => { const m = x.match(/^\*\*Anexo ([A-Z])\.\*\* (.*)$/); return `<div class="anexo"><span class="ficha letra">${m[1]}</span><p>${inline(m[2])}</p></div>`; }).join('')}</div></div>`);

  // Contraportada
  estatica('contraportada', `<div class="pagina portada contraportada" style="page:portada;${fondo('contraportada', 2480, 1754, 41)}"><div class="contra-marca">${lockup()}</div><p class="descriptor">Un recordatorio físico preparado desde el teléfono</p></div>`);

  return { html: plantilla(partes.join('\n'), capitulos), registro };
}

// ---------------------------------------------------------------- Paginador (corre en Chrome)

async function paginador() {
  const raiz = document.documentElement;
  const avisos = [];
  try {
    const MM = 96 / 25.4;
    await Promise.all(['400 10pt "Instrument Sans"', '600 10pt "Instrument Sans"'].map((f) => document.fonts.load(f)));
    await document.fonts.ready;
    const salida = document.getElementById('paginas');

    // Puntos donde se puede cortar un párrafo: después de cada espacio dentro de un texto.
    const puntos = (el) => {
      const out = []; const w = document.createTreeWalker(el, NodeFilter.SHOW_TEXT); let n;
      while ((n = w.nextNode())) { const re = /\s+/g; let m; while ((m = re.exec(n.data))) if (m.index + m[0].length < n.data.length) out.push([n, m.index + m[0].length]); }
      return out;
    };
    // Corta copias del elemento en el punto k: devuelve [lo que va antes, lo que sigue].
    const cortar = (el, k) => {
      const a = el.cloneNode(true), b = el.cloneNode(true);
      const pa = puntos(a)[k], pb = puntos(b)[k];
      const ra = document.createRange(); ra.setStart(pa[0], pa[1]); ra.setEndAfter(a.lastChild); ra.deleteContents();
      const rb = document.createRange(); rb.setStartBefore(b.firstChild); rb.setEnd(pb[0], pb[1]); rb.deleteContents();
      a.classList.add('corta'); b.classList.add('sigue');
      return [a, b];
    };
    // ¿Cabe todo en las columnas? Si no, Chrome agrega columnas hacia la derecha.
    const cabe = (t) => {
      if (t.scrollWidth > t.clientWidth + 1) return false;
      const r = t.getBoundingClientRect(); const u = t.lastElementChild && t.lastElementChild.getBoundingClientRect();
      return !u || (u.right <= r.right + 1 && u.bottom <= r.bottom + 1);
    };
    // Deja en la página la parte del párrafo que cabe (al menos dos líneas) y devuelve el resto.
    const partir = (el, t, sola) => {
      const n = puntos(el).length;
      t.removeChild(el);
      let lo = 0, hi = n - 1, mejor = -1;
      while (lo <= hi) {
        const m = (lo + hi) >> 1; const [a] = cortar(el, m);
        t.appendChild(a); const ok = cabe(t); a.remove();
        if (ok) { mejor = m; lo = m + 1; } else hi = m - 1;
      }
      const MIN = sola ? 0 : 14;
      if (mejor < MIN) return null;
      if (n - 1 - mejor < 14) mejor = n - 1 - 14;
      if (mejor < MIN) return null;
      const [a, b] = cortar(el, mejor); t.appendChild(a);
      return b;
    };

    let p = null; // página abierta
    const cola = []; // tablas y figuras que esperan la página siguiente

    function nuevaPagina(parte, conPanel) {
      const pg = document.createElement('div');
      pg.className = `pagina ${conPanel ? 'con-panel' : 'sin-panel'}`;
      pg.style.page = parte.dataset.pagina;
      if (conPanel) { const panel = conPanel === true ? parte.querySelector('.panel') : conPanel; panel.id = parte.dataset.id; pg.appendChild(panel); }
      const area = document.createElement('div'); area.className = 'area flujo';
      const arriba = document.createElement('div'); arriba.className = 'arriba';
      const t = document.createElement('div'); t.className = 'texto';
      area.append(arriba, t); pg.appendChild(area); salida.appendChild(pg);
      p = { pg, area, arriba, t, abajo: null, parte };
      return p;
    }
    // Las piezas pendientes van arriba de la página y dejan sitio para lo que sigue.
    function ponerPiezas(reserva) {
      while (cola.length) {
        p.arriba.appendChild(cola[0]);
        const libre = p.area.clientHeight - p.arriba.offsetHeight;
        if (libre >= reserva) { cola.shift(); continue; }
        if (p.arriba.children.length === 1) { if (libre < 0) avisos.push('pieza más alta que la página: ' + cola[0].id); cola.shift(); }
        else p.arriba.removeChild(cola[0]);
        break;
      }
    }
    const abrir = (parte) => { nuevaPagina(parte, false); ponerPiezas(50 * MM); };
    const tienePanel = (q) => !!q.t.querySelector('.panel');

    // Cierra la página abierta: columnas parejas y, debajo, las piezas pendientes que quepan.
    // Las que no caben pasan a páginas propias; la última queda abierta si se puede seguir escribiendo.
    function vaciarCola(parte, seguir) {
      if (p && p.t.children.length && !tienePanel(p)) {
        p.t.classList.add('final');
        while (cola.length) {
          if (!p.abajo) { p.abajo = document.createElement('div'); p.abajo.className = 'abajo'; p.area.appendChild(p.abajo); }
          p.abajo.appendChild(cola[0]);
          if (p.area.scrollHeight <= p.area.clientHeight + 1) { cola.shift(); continue; }
          p.abajo.removeChild(cola[0]);
          if (!p.abajo.children.length) { p.abajo.remove(); p.abajo = null; }
          break;
        }
      }
      if (!cola.length) { if (!seguir) p = null; else if (p && p.t.classList.contains('final')) p = null; return; }
      const ref = p ? p.parte : parte;
      while (cola.length) { nuevaPagina(ref, false); ponerPiezas(0); }
    }
    function cerrar(parte) {
      if (!p) return;
      vaciarCola(parte, false);
      if (p && !p.t.children.length) p.t.remove();
      else if (p && !tienePanel(p)) p.t.classList.add('final');
      p = null;
    }

    // Un capítulo empieza en la columna libre que deja el anterior; si no hay, en una página nueva.
    function empezar(parte) {
      const panel = parte.querySelector('.panel');
      if (p && parte.dataset.modo === 'normal') {
        const t = p.t;
        // Las piezas que quedaron al pie suben arriba: así no quedan bajo el capítulo siguiente.
        if (p.abajo) { [...p.abajo.children].forEach((x) => p.arriba.appendChild(x)); p.abajo.remove(); p.abajo = null; }
        panel.classList.add('en-flujo'); panel.id = parte.dataset.id;
        // Altura que el panel necesita, normal o compacto, medida fuera de la página.
        const necesita = (talla) => {
          const m = document.createElement('div'); m.style.cssText = 'position:absolute;left:-1000mm;top:0;width:var(--col)';
          panel.classList.remove('compacto', 'mini'); if (talla) panel.classList.add(talla); panel.style.height = 'auto';
          m.appendChild(panel); document.body.appendChild(m); const h = panel.offsetHeight; m.remove(); return h;
        };
        // La altura exacta de las columnas, sin redondear hacia arriba: un panel apenas más alto se partiría.
        const alto = Math.floor(t.getBoundingClientRect().height) - 1;
        let ok = alto >= 95 * MM && ['', 'compacto', 'mini'].some((talla) => necesita(talla) <= alto);
        if (ok) {
          panel.style.height = alto + 'px';
          t.appendChild(panel);
          ok = cabe(t) && panel.getClientRects().length === 1;
        }
        if (ok) { p.pg.style.page = parte.dataset.pagina; p.parte = parte; return; }
        panel.remove(); panel.classList.remove('en-flujo', 'compacto', 'mini'); panel.style.height = '';
        if (!t.children.length) t.remove(); else if (!tienePanel(p)) t.classList.add('final');
      }
      nuevaPagina(parte, panel);
    }

    function fluir(parte) {
      const pend = [...parte.querySelector('.bloques').children];
      while (pend.length) {
        const b = pend.shift();
        const t = p.t;
        if (b.classList.contains('pieza')) {
          cola.push(b);
          if (p.pg.classList.contains('con-panel')) continue;
          // Si la página todavía no tiene texto, la pieza va arriba de inmediato.
          if (!t.children.length) { ponerPiezas(50 * MM); continue; }
          // Si no, al pie de esta misma página, siempre que el texto ya puesto siga cabiendo.
          if (cola.length === 1 && !tienePanel(p)) {
            if (!p.abajo) { p.abajo = document.createElement('div'); p.abajo.className = 'abajo'; p.area.appendChild(p.abajo); }
            p.abajo.appendChild(b);
            if (cabe(t) && t.clientHeight >= 60 * MM) { cola.shift(); continue; }
            p.abajo.removeChild(b);
            if (!p.abajo.children.length) { p.abajo.remove(); p.abajo = null; }
          }
          continue;
        }
        if (/^H[23]$/.test(b.tagName)) {
          // Un título no queda solo al pie: debe caber con las primeras líneas de lo que sigue.
          t.appendChild(b);
          const sig = pend.find((x) => !x.classList.contains('pieza'));
          let prueba = null;
          if (sig) { prueba = sig.matches('p, .item') && puntos(sig).length > 24 ? cortar(sig, 20)[0] : sig.cloneNode(true); t.appendChild(prueba); }
          const ok = cabe(t); if (prueba) prueba.remove();
          if (!ok && t.children.length > 1) { b.remove(); pend.unshift(b); abrir(parte); }
          continue;
        }
        t.appendChild(b);
        if (cabe(t)) continue;
        const sola = t.children.length === 1 || (t.children.length === 2 && t.firstElementChild.classList.contains('panel'));
        if (b.matches('p, .item')) {
          const resto = partir(b, t, sola);
          if (resto) { pend.unshift(resto); abrir(parte); continue; }
          if (sola) { t.appendChild(b); avisos.push('párrafo sin cortar: ' + b.textContent.slice(0, 40)); continue; }
          pend.unshift(b); abrir(parte); continue;
        }
        if (sola) { avisos.push('bloque más alto que la columna: ' + b.className); continue; }
        b.remove(); pend.unshift(b); abrir(parte);
      }
    }

    // Capítulos breves: en su propia página, con la letra que la llena.
    function ajustar(parte) {
      const t = p.t; const modo = parte.dataset.modo;
      t.classList.add(modo);
      let lo = 10, hi = modo === 'lectura' ? 21 : 14, mejor = 10;
      for (let k = 0; k < 9; k++) { const m = (lo + hi) / 2; t.style.fontSize = m + 'pt'; if (cabe(t)) { mejor = m; lo = m; } else hi = m; }
      t.style.fontSize = (mejor * 0.96).toFixed(2) + 'pt';
    }

    for (const parte of [...document.querySelectorAll('#fuente > .parte')]) {
      if (parte.hasAttribute('data-estatica')) { cerrar(parte); [...parte.children].forEach((x) => salida.appendChild(x)); continue; }
      const especial = parte.dataset.modo !== 'normal';
      if (especial) cerrar(parte);
      const antes = salida.children.length;
      const copia = parte.hasAttribute('data-apretar') ? parte.cloneNode(true) : null;
      const guardado = p && { p, hijos: p.t.children.length, pagina: p.pg.style.page };
      empezar(parte);
      fluir(parte);
      if (copia && salida.children.length > antes) {
        // Si la última página queda casi vacía, se compone de nuevo con la letra un poco menor.
        p.t.classList.add('final'); const lleno = p.t.offsetHeight / p.area.clientHeight; p.t.classList.remove('final');
        if (lleno < 0.25) {
          while (salida.children.length > antes) salida.lastElementChild.remove();
          p = guardado ? guardado.p : null;
          if (p) { while (p.t.children.length > guardado.hijos) p.t.lastElementChild.remove(); p.pg.style.page = guardado.pagina; p.t.classList.remove('final'); if (!p.t.isConnected) p.area.appendChild(p.t); }
          copia.querySelectorAll('.bloques > *').forEach((x) => x.classList.add('apretado'));
          empezar(copia);
          fluir(copia);
        }
      }
      if (especial) { if (salida.children.length - antes === 1) ajustar(parte); cerrar(parte); }
      else if (cola.length) vaciarCola(parte, true);
    }
    cerrar(null);

    for (const pg of salida.children) {
      const area = pg.querySelector('.area');
      if (area && area.scrollHeight > area.clientHeight + 1) avisos.push('página desbordada: ' + (pg.style.page || pg.id));
    }
    // Números de página: la portada es la 1.
    const todas = [...salida.children];
    todas.forEach((pg, k) => { pg.dataset.n = k + 1; });
    document.querySelectorAll('[data-ref]').forEach((s) => {
      const el = document.getElementById(s.dataset.ref); const pg = el && el.closest('.pagina');
      s.textContent = pg ? pg.dataset.n : '?';
      if (!pg) avisos.push('sin página: ' + s.dataset.ref);
    });
    document.getElementById('fuente').remove();
    raiz.dataset.paginas = todas.length;
    raiz.dataset.listo = '1';
  } catch (e) {
    raiz.dataset.error = String((e && e.stack) || e);
  }
  raiz.dataset.avisos = avisos.join(' | ');
  document.getElementById('paginador').remove();
}

// ---------------------------------------------------------------- Estilo

function plantilla(partesHtml, capitulos) {
  const encabezados = capitulos.map((c) => {
    const [, num, t] = c.titulo.match(/^(\d+)\. (.*)$/);
    return `@page c${num} { @top-right { content: "${num} · ${t}"; } }`;
  }).join('\n') + '\n' + ['resumen:Resumen y abstract', 'indice:Índice', 'referencias:Referencias', 'glosario:Glosario', 'anexos:Anexos']
    .map((x) => { const [p, t] = x.split(':'); return `@page ${p} { @top-right { content: "${t}"; } }`; }).join('\n');
  return `<!doctype html>
<html lang="es"><head><meta charset="utf-8"><title>Relevo · Memoria de título (A3)</title>
<style>
@font-face { font-family: "Instrument Sans"; src: url("${LETRA}") format("truetype"); font-weight: 400 700; font-style: normal; }
:root {
  --paper: #F7F4F0; --stone: #EEE9E3; --line: #E4DED6; --ink: #141312; --graphite: #6B655F; --white: #FFFFFF;
  --butter: #F4E496; --sky: #B3E5FC; --lime: #C6EEAE; --blush: #FAC8D9; --lilac: #DFD1FC; --peach: #FBD1B3;
  --ancho: 376mm; --alto: 258mm; --col: 118mm; --gap: 11mm;
}
@page { size: 420mm 297mm; margin: 20mm 22mm 19mm 22mm; background: #F7F4F0;
  @top-left { content: "Relevo · Memoria de título"; font: 600 7.6pt "Instrument Sans"; color: #6B655F; vertical-align: middle; }
  @top-right { font: 600 7.6pt "Instrument Sans"; color: #141312; vertical-align: middle; }
  @bottom-left { content: "Borrador de diseño · texto de la v5 del 11 de octubre de 2026"; font: 400 7.2pt "Instrument Sans"; color: #6B655F; vertical-align: middle; }
  @bottom-right { content: counter(page); font: 600 9pt "Instrument Sans"; color: #141312; vertical-align: middle; }
}
@page portada { margin: 0; @top-left { content: none; } @bottom-left { content: none; } @bottom-right { content: none; } }
${encabezados}
* { box-sizing: border-box; }
html { background: var(--paper); -webkit-print-color-adjust: exact; print-color-adjust: exact; }
body { margin: 0; font-family: "Instrument Sans", "Helvetica Neue", Arial, sans-serif; font-size: 10pt; line-height: 1.5; color: var(--ink);
  font-kerning: normal; hyphens: auto; -webkit-hyphens: auto; text-rendering: geometricPrecision; }
h1, h2, h3, p { margin: 0; }
h1, h2, h3 { text-wrap: balance; letter-spacing: -0.02em; hyphens: manual; }
svg.i { width: 100%; height: 100%; fill: none; stroke: currentColor; stroke-width: 1.7; stroke-linecap: round; stroke-linejoin: round; display: block; }
svg.i .f { fill: currentColor; stroke: none; }
svg.marca, svg.lockup { display: block; width: 100%; height: auto; }
[style*="background-image"] { background-size: cover; background-position: center; background-repeat: no-repeat; }
#fuente { display: none; }

/* Página: el área de A3 dentro de los márgenes. */
.pagina { width: var(--ancho); height: var(--alto); overflow: hidden; position: relative; display: grid; grid-template-columns: minmax(0, 1fr); column-gap: var(--gap); }
.pagina + .pagina { break-before: page; }
.pagina.con-panel { grid-template-columns: var(--col) minmax(0, 1fr); }
.area { min-width: 0; height: var(--alto); overflow: hidden; }
.flujo { display: flex; flex-direction: column; gap: 7mm; }
.arriba, .abajo { flex: none; display: flex; flex-direction: column; gap: 7mm; }
.arriba:empty { display: none; }
.texto { flex: 1 1 0; min-height: 0; font-size: 10pt; column-count: 3; column-gap: var(--gap); column-fill: auto; overflow: hidden; widows: 2; orphans: 2; }
.con-panel .texto { column-count: 2; }
.texto.final { flex: 0 0 auto; column-fill: balance; }
.texto.lectura { column-count: 1; line-height: 1.38; letter-spacing: -0.01em; }
.texto.ajustar { line-height: 1.44; }
.texto > :first-child { margin-top: 0; }

/* Portada y contraportada: el aura a sangre. */
.pagina.portada { width: 420mm; height: 297mm; display: block; }
.portada-inst { position: absolute; left: 26mm; top: 24mm; display: grid; gap: 1.2mm; font-size: 10pt; font-weight: 600; }
.portada-marca { position: absolute; left: 26mm; top: 64mm; width: 150mm; }
.portada-titulo { position: absolute; left: 26mm; top: 118mm; width: 215mm; }
.portada-titulo .descriptor { font-size: 12pt; font-weight: 600; color: var(--graphite); margin-bottom: 4mm; }
.portada-titulo h1 { font-size: 40pt; line-height: 1.04; font-weight: 600; letter-spacing: -0.03em; }
.portada-datos { position: absolute; left: 26mm; bottom: 24mm; width: 240mm; display: grid; gap: 1.6mm; font-size: 11pt; }
.portada-datos span:first-child { font-weight: 600; }
.portada-ejemplo { position: absolute; right: 30mm; top: 46mm; width: 150mm; height: 200mm; }
.portada-ejemplo .cielo { position: absolute; left: 30mm; top: 0; width: 100mm; height: 100mm; border-radius: 13mm; }
.capsula { position: absolute; left: 5mm; bottom: 5mm; background: rgba(255,255,255,.94); border-radius: 99px; padding: 1.4mm 5mm; font-weight: 600; font-size: 13pt; }
.fila { display: flex; align-items: center; gap: 4mm; background: var(--white); border-radius: 9mm; padding: 4mm 7mm 4mm 4mm; }
.fila b { display: block; font-size: 13pt; } .fila small { display: block; font-size: 10pt; color: var(--graphite); }
.fila .ficha { width: 15mm; height: 15mm; border-radius: 4.6mm; padding: 3.2mm; }
.flota { position: absolute; } .flota.uno { left: 0; top: 112mm; width: 100mm; } .flota.dos { right: 0; top: 146mm; width: 92mm; }
.pagina.contraportada { display: grid; place-content: center; justify-items: center; gap: 8mm; }
.contra-marca { width: 170mm; } .contraportada .descriptor { font-size: 14pt; color: var(--graphite); }

/* Panel: la columna de apertura. */
.panel { height: var(--alto); border-radius: 9mm; padding: 9mm 9mm 10mm; display: flex; flex-direction: column; box-shadow: inset 0 0 0 .3mm rgba(20,19,18,.06); }
.panel.en-flujo { break-before: column; break-inside: avoid; }
.panel.compacto .panel-numero { font-size: 100pt; margin-top: 8mm; }
.panel.compacto .panel-titulo { font-size: 22pt; margin-top: 5mm; }
.panel.compacto .secciones { gap: 1.4mm; }
.panel.compacto .secciones li { padding: 1.4mm 3mm 1.4mm 1.6mm; font-size: 8.4pt; }
.panel.mini .secciones { display: none; }
.panel.mini .panel-numero { font-size: 80pt; margin-top: 6mm; }
.panel.mini .panel-titulo { font-size: 20pt; margin-top: auto; padding-top: 4mm; }
.panel-arriba { display: flex; justify-content: space-between; align-items: center; }
.panel-marca { width: 9mm; }
.panel-numero { font-size: 150pt; line-height: .82; font-weight: 600; letter-spacing: -0.06em; margin-top: 18mm; font-feature-settings: "tnum"; }
.panel-hueco { flex: 1; }
.panel-titulo { font-size: 28pt; line-height: 1.06; font-weight: 600; letter-spacing: -0.03em; margin-top: 7mm; }
.panel-titulo .suave { color: var(--graphite); }
.secciones { list-style: none; padding: 0; margin: auto 0 0; display: grid; gap: 2mm; }
.secciones li { display: flex; align-items: center; gap: 3mm; background: rgba(255,255,255,.9); border-radius: 5mm; padding: 2mm 4mm 2mm 2mm; font-size: 9pt; font-weight: 600; line-height: 1.25; }
.ficha { display: inline-grid; place-items: center; flex: none; width: 8mm; height: 8mm; border-radius: 2.6mm; padding: 1.6mm; font-size: 8pt; font-weight: 600; font-feature-settings: "tnum"; }
.ficha.stone { background: var(--stone); } .ficha.blanca { background: var(--white); box-shadow: inset 0 0 0 .3mm var(--line); }
.ficha.sky { background: var(--sky); } .ficha.lime { background: var(--lime); } .ficha.butter { background: var(--butter); } .ficha.blush { background: var(--blush); } .ficha.lilac { background: var(--lilac); }
.pastilla { display: inline-block; background: var(--white); border-radius: 99px; padding: .7mm 3mm; font-size: 7.6pt; font-weight: 600; line-height: 1.4; white-space: nowrap; }

/* Texto corrido */
.texto > p { margin: 0 0 2.4mm; }
.texto.lectura > p, .texto.ajustar > p { margin-bottom: .62em; }
.texto > p.corta, .texto > .item.corta { margin-bottom: 0; }
h2 { font-size: 14.5pt; line-height: 1.16; font-weight: 600; margin: 5.5mm 0 2.4mm; break-after: avoid; }
h3 { font-size: 11pt; font-weight: 600; margin: 4mm 0 1.6mm; break-after: avoid; }
em { font-style: italic; }
strong { font-weight: 600; }
.item { position: relative; margin: 0 0 1.4mm; }
.item.ultimo { margin-bottom: 2.6mm; }
.item.punto { padding-left: 4.4mm; }
.item.punto::before { content: ""; position: absolute; left: .6mm; top: .55em; width: 1.6mm; height: 1.6mm; border-radius: 50%; background: var(--ink); }
.item.num { padding-left: 8mm; }
.item.num::before { content: attr(data-n); position: absolute; left: 0; top: .1em; width: 5.6mm; height: 5.6mm; border-radius: 1.8mm; background: var(--stone); font-size: 7.6pt; font-weight: 600; display: grid; place-items: center; }
.item.sigue::before { display: none; }
mark.confirmar { background: var(--butter); color: var(--ink); border-radius: 1.4mm; padding: .1mm 1.2mm; font-size: .84em; -webkit-box-decoration-break: clone; box-decoration-break: clone; }
mark.confirmar b { font-weight: 600; margin-right: .6mm; }
.url { overflow-wrap: anywhere; word-break: break-word; hyphens: none; }
.nota { font-size: 7.8pt; line-height: 1.42; color: var(--graphite); margin: 2mm 0 0; }
.criterio { display: grid; grid-template-columns: 7mm 1fr; gap: 2.6mm; break-inside: avoid; margin-bottom: 2.4mm; }
.criterio .n { width: 7mm; height: 7mm; border-radius: 50%; background: var(--ink); color: var(--white); font-size: 8.4pt; font-weight: 600; display: grid; place-items: center; margin-top: .4mm; }
.frase { break-inside: avoid; border-radius: 7mm; padding: 6mm 7mm 7mm; margin: 1mm 0 4mm; box-shadow: inset 0 0 0 .3mm rgba(20,19,18,.06); }
.frase p { font-size: 14.5pt; line-height: 1.28; font-weight: 600; letter-spacing: -0.015em; margin-top: 3.4mm; hyphens: manual; }

/* Tablas y figuras: a lo ancho, arriba o al pie de la página. */
.rotulo { display: flex; align-items: baseline; gap: 3mm; margin-bottom: 3mm; }
.rotulo .pastilla { background: var(--ink); color: var(--white); }
.titulo-pieza { font-size: 11.5pt; font-style: italic; font-weight: 500; }
table { width: 100%; border-collapse: separate; border-spacing: 0; background: var(--white); border-radius: 4mm; overflow: hidden; font-size: 8.4pt; line-height: 1.34; }
th { text-align: left; font-weight: 600; background: var(--stone); padding: 1.9mm 3.2mm; vertical-align: bottom; }
td { padding: 1.7mm 3.2mm; border-top: .25mm solid var(--line); vertical-align: top; }
th.num, td.num { text-align: right; font-feature-settings: "tnum"; }
tbody tr td:first-child { font-weight: 600; }

.fig1 { display: grid; grid-template-columns: 1fr 8mm 62mm; align-items: center; background: var(--white); border-radius: 6mm; padding: 7mm; }
.fig1-fila { display: flex; align-items: center; gap: 2mm; }
.nodo { flex: 1; display: grid; justify-items: center; gap: 3mm; text-align: center; font-size: 9pt; line-height: 1.2; }
.nodo .ficha, .rama .ficha { width: 15mm; height: 15mm; border-radius: 4.6mm; padding: 3.4mm; }
.flecha { width: 6mm; color: var(--graphite); flex: none; }
.fig1-llave { height: 46mm; border: .4mm solid var(--ink); border-left: 0; border-radius: 0 4mm 4mm 0; margin-left: -2mm; }
.fig1-ramas { display: grid; gap: 2.4mm; }
.rama { display: flex; align-items: center; gap: 3mm; background: var(--paper); border-radius: 4mm; padding: 2mm 3mm 2mm 2mm; font-size: 9pt; }
.rama .ficha { width: 10mm; height: 10mm; padding: 2.2mm; border-radius: 3mm; }

.fig2 { display: grid; grid-template-columns: repeat(6, 1fr); gap: 6mm; }
.fig2 figure { margin: 0; }
.fig2 img { width: 100%; height: auto; display: block; border-radius: 6mm; border: .3mm solid var(--line); }
.fig2 figcaption { display: flex; align-items: center; gap: 2mm; margin-top: 3mm; font-size: 9pt; font-weight: 600; }
.fig2 .n { width: 5.6mm; height: 5.6mm; border-radius: 50%; background: var(--ink); color: var(--white); font-size: 7.4pt; display: grid; place-items: center; }

.fig-pendiente { border: .5mm dashed var(--graphite); border-radius: 6mm; padding: 9mm 12mm; min-height: 46mm; display: grid; align-content: center; gap: 3mm; background: rgba(255,255,255,.5); }
.fig-pendiente p { font-size: 10pt; color: var(--graphite); max-width: 220mm; }
.fig-pendiente .pastilla { background: var(--butter); justify-self: start; }

.fig4 { display: grid; grid-template-columns: 1fr 1.2fr 1.2fr 1.2fr .9fr; gap: 3mm; }
.etapa { background: var(--white); border-radius: 5mm; padding: 5mm; display: grid; gap: 2.4mm; align-content: start; font-size: 9pt; }
.etapa b { font-size: 11pt; }
.etapa .dia { font-size: 7.8pt; font-weight: 600; color: var(--graphite); }
.etapa ul { display: grid; gap: 1.2mm; padding: 0; margin: 0; list-style: none; }
.etapa ul li { position: relative; padding-left: 3.4mm; }
.etapa ul li::before { content: ""; position: absolute; left: 0; top: 1.9mm; width: 1.4mm; height: 1.4mm; border-radius: 50%; background: var(--ink); }
.etapa.inicio { background: var(--lime); } .etapa.cierre { background: var(--blush); }
.conds { display: flex; gap: 1.4mm; }
.conds i, .fig4-leyenda i { font-style: normal; width: 6.4mm; height: 6.4mm; border-radius: 2mm; display: inline-grid; place-items: center; font-weight: 600; font-size: 8pt; background: var(--stone); }
.conds i:first-child, .fig4-leyenda span:first-child i { background: var(--lime); }
.fig4-leyenda { display: flex; gap: 7mm; margin-top: 3mm; font-size: 8.4pt; color: var(--graphite); }
.fig4-leyenda span { display: inline-flex; align-items: center; gap: 2mm; }

/* Resumen, índice, referencias, glosario y anexos */
.area.dos { display: grid; grid-template-columns: 1fr 1fr; gap: var(--gap); align-content: start; }
.resumen h2, .indice h2 { margin-top: 0; }
.resumen p { font-size: 10.4pt; margin-bottom: 2.4mm; }
.claves { display: flex; flex-wrap: wrap; gap: 1.6mm; margin-top: 3mm; }
.pastilla.blanca { background: var(--white); box-shadow: inset 0 0 0 .3mm var(--line); }
.indice-lista { list-style: none; padding: 0; display: grid; gap: 1.6mm; margin: 0 0 7mm; }
.indice-lista li { display: grid; grid-template-columns: auto 1fr auto; align-items: center; gap: 3mm; background: var(--white); border-radius: 3.6mm; padding: 1.4mm 4mm 1.4mm 1.6mm; font-size: 9.6pt; font-weight: 600; }
.indice-lista.piezas li { font-size: 8.6pt; font-weight: 500; padding: 1.6mm 4mm 1.6mm 2mm; }
.indice-lista .pag { font-feature-settings: "tnum"; color: var(--graphite); font-weight: 600; }
.indice-lista .ficha { width: 7mm; height: 7mm; }
.texto > p.ref { font-size: 8pt; line-height: 1.38; padding-left: 5mm; text-indent: -5mm; margin: 0 0 1.9mm; }
.texto > p.ref.sigue { text-indent: 0; }
.texto > p.glos { font-size: 8.9pt; line-height: 1.42; margin: 0 0 2.2mm; }
.texto > p.glos.apretado { font-size: 8.5pt; line-height: 1.38; margin-bottom: 1.8mm; }
.area.anexos { display: grid; grid-template-columns: 1fr 1fr; gap: 3.4mm var(--gap); align-content: start; }
.anexo { display: grid; grid-template-columns: 11mm 1fr; gap: 3mm; background: var(--white); border-radius: 5mm; padding: 3.4mm; }
.anexo p { font-size: 9.4pt; line-height: 1.42; }
.ficha.letra { width: 11mm; height: 11mm; border-radius: 3.4mm; background: var(--lilac); font-size: 11pt; }

/* En pantalla, ya paginada, cada página se ve como una hoja con sus márgenes. */
@media screen {
  html[data-listo] body { background: #D9D4CE; padding: 10mm 0; }
  html[data-listo] .pagina { box-sizing: content-box; margin: 0 auto 10mm; padding: 20mm 22mm 19mm; background-color: var(--paper); box-shadow: 0 2mm 8mm rgba(0,0,0,.12); }
  html[data-listo] .pagina.portada { padding: 0; }
}
</style></head><body>
<div id="paginas"></div>
<div id="fuente">
${partesHtml}
</div>
<script id="paginador">(${paginador.toString()})();</script>
</body></html>`;
}

// ---------------------------------------------------------------- Impresión

function chrome(args) {
  return execFileSync(CHROME, ['--headless=new', '--disable-gpu', '--hide-scrollbars', ...args], { maxBuffer: 400 * 1024 * 1024, stdio: ['ignore', 'pipe', 'ignore'] });
}
const url = (archivo) => 'file:///' + archivo.replace(/\\/g, '/');
const contarPaginas = (pdf) => (pdf.toString('latin1').match(/\/Type\s*\/Page[^s]/g) || []).length;

function principal() {
  const inicio = Date.now();
  const { html, registro } = documento();
  generarFondos();
  fs.writeFileSync(TEMPORAL, html);
  let dom = chrome(['--window-size=1800,1200', '--virtual-time-budget=120000', '--dump-dom', url(TEMPORAL)]).toString();
  fs.unlinkSync(TEMPORAL);
  const atributo = (n) => { const m = dom.match(new RegExp(`<html[^>]*\\sdata-${n}="([^"]*)"`)); return m ? m[1].replace(/&quot;/g, '"').replace(/&amp;/g, '&') : ''; };
  if (atributo('error')) throw new Error('El paginador falló:\n' + atributo('error'));
  if (!atributo('listo')) throw new Error('El paginador no terminó.');
  if (atributo('avisos')) console.log('Avisos:', atributo('avisos'));
  if (!/^<!doctype/i.test(dom)) dom = '<!doctype html>\n' + dom;
  fs.writeFileSync(SALIDA_HTML, dom);
  if (fs.existsSync(SALIDA_PDF)) fs.unlinkSync(SALIDA_PDF);
  chrome(['--no-pdf-header-footer', '--run-all-compositor-stages-before-draw', '--virtual-time-budget=15000', `--print-to-pdf=${SALIDA_PDF}`, url(SALIDA_HTML)]);
  const pdf = fs.readFileSync(SALIDA_PDF);
  const n = contarPaginas(pdf);
  console.log(`PDF listo: ${n} páginas (paginador: ${atributo('paginas')}), ${(pdf.length / 1048576).toFixed(1)} MB, ${registro.length} tablas y figuras, ${((Date.now() - inicio) / 1000).toFixed(0)} s`);
  if (String(n) !== atributo('paginas')) console.log('Atención: el PDF no tiene las mismas páginas que calculó el paginador.');
}

principal();
