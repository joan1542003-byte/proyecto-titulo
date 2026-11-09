// Escribe los anexos en un .docx sin dependencias: un ZIP con las partes de Office Open XML.
// Lo usa construir-anexos.js. Recibe los anexos ya leídos (título, intro y partes en Markdown)
// y las imágenes de las láminas y los diagramas, ya convertidas a PNG.
//
// Lo que entiende del Markdown de los anexos: encabezados, párrafos, listas (también anidadas),
// tablas, tablas de imágenes (galerías), citas, imágenes sueltas, negrita, cursiva, código y enlaces.
// Las tablas y figuras siguen APA 7: rótulo en negrita, título en cursiva y nota debajo.
// Es un documento formal, sin diseño propio: la pauta de la Biblioteca UDP, texto negro, los estilos de
// título, índice y tabla de Word, y la portada de la pauta con el logo de la Escuela de Diseño.

'use strict';
const fs = require('fs');
const path = require('path');
const zlib = require('zlib');

// ---------------------------------------------------------------- ZIP

const TABLA_CRC = (() => {
  const t = new Uint32Array(256);
  for (let n = 0; n < 256; n++) {
    let c = n;
    for (let k = 0; k < 8; k++) c = c & 1 ? 0xEDB88320 ^ (c >>> 1) : c >>> 1;
    t[n] = c >>> 0;
  }
  return t;
})();
function crc32(buf) {
  let c = 0xFFFFFFFF;
  for (let i = 0; i < buf.length; i++) c = TABLA_CRC[(c ^ buf[i]) & 0xFF] ^ (c >>> 8);
  return (c ^ 0xFFFFFFFF) >>> 0;
}

/** Un ZIP sin carpetas: cada entrada es un archivo, con su nombre en UTF-8. */
function zip(archivos, fecha) {
  const partes = [];
  const centrales = [];
  let offset = 0;
  const hora = ((fecha.getHours() << 11) | (fecha.getMinutes() << 5) | (fecha.getSeconds() >> 1)) & 0xFFFF;
  const dia = (((fecha.getFullYear() - 1980) << 9) | ((fecha.getMonth() + 1) << 5) | fecha.getDate()) & 0xFFFF;
  for (const { nombre, datos } of archivos) {
    const nom = Buffer.from(nombre, 'utf8');
    const comprimir = !/\.(png|jpe?g)$/i.test(nombre);
    const cuerpo = comprimir ? zlib.deflateRawSync(datos, { level: 9 }) : datos;
    const crc = crc32(datos);
    const local = Buffer.alloc(30);
    local.writeUInt32LE(0x04034b50, 0); local.writeUInt16LE(20, 4); local.writeUInt16LE(0x0800, 6);
    local.writeUInt16LE(comprimir ? 8 : 0, 8); local.writeUInt16LE(hora, 10); local.writeUInt16LE(dia, 12);
    local.writeUInt32LE(crc, 14); local.writeUInt32LE(cuerpo.length, 18); local.writeUInt32LE(datos.length, 22);
    local.writeUInt16LE(nom.length, 26); local.writeUInt16LE(0, 28);
    partes.push(local, nom, cuerpo);
    const central = Buffer.alloc(46);
    central.writeUInt32LE(0x02014b50, 0); central.writeUInt16LE(20, 4); central.writeUInt16LE(20, 6);
    central.writeUInt16LE(0x0800, 8); central.writeUInt16LE(comprimir ? 8 : 0, 10); central.writeUInt16LE(hora, 12);
    central.writeUInt16LE(dia, 14); central.writeUInt32LE(crc, 16); central.writeUInt32LE(cuerpo.length, 20);
    central.writeUInt32LE(datos.length, 24); central.writeUInt16LE(nom.length, 28);
    central.writeUInt32LE(offset, 42);
    centrales.push(central, nom);
    offset += 30 + nom.length + cuerpo.length;
  }
  const dir = Buffer.concat(centrales);
  const fin = Buffer.alloc(22);
  fin.writeUInt32LE(0x06054b50, 0); fin.writeUInt16LE(archivos.length, 8); fin.writeUInt16LE(archivos.length, 10);
  fin.writeUInt32LE(dir.length, 12); fin.writeUInt32LE(offset, 16);
  return Buffer.concat([...partes, dir, fin]);
}

// ---------------------------------------------------------------- Medidas

// Formato de la pauta de tesis de la Biblioteca UDP: carta, márgenes de 3,5 cm a la izquierda y 2,5 cm en los
// demás, Arial 12, interlineado 1,5 y el número de página centrado abajo.
const PAGINA = { ancho: 12240, alto: 15840 };      // carta, en vigésimos de punto (dxa)
const MARGEN = 1418;                                // 2,5 cm
const MARGEN_IZQ = 1984;                            // 3,5 cm
const TEXTO = PAGINA.ancho - MARGEN - MARGEN_IZQ;   // 8838 dxa, unos 15,6 cm
const EMU_POR_DXA = 635;
const LETRA = 'Arial';
const NEGRO = '000000';

const x = (s) => String(s).replace(/[\u0000-\u0008\u000B\u000C\u000E-\u001F]/g, '')
  .replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');

/** Ancho y alto en píxeles de un PNG o un JPEG. */
function medidas(buf) {
  if (buf[0] === 0x89 && buf[1] === 0x50) return { ancho: buf.readUInt32BE(16), alto: buf.readUInt32BE(20), tipo: 'png' };
  if (buf[0] === 0xFF && buf[1] === 0xD8) {
    let i = 2;
    while (i < buf.length) {
      if (buf[i] !== 0xFF) { i++; continue; }
      const m = buf[i + 1];
      if (m === 0xD8 || m === 0x01 || (m >= 0xD0 && m <= 0xD7)) { i += 2; continue; }
      const largo = buf.readUInt16BE(i + 2);
      if (m >= 0xC0 && m <= 0xCF && m !== 0xC4 && m !== 0xC8 && m !== 0xCC) return { ancho: buf.readUInt16BE(i + 7), alto: buf.readUInt16BE(i + 5), tipo: 'jpeg' };
      i += 2 + largo;
    }
  }
  throw new Error('Imagen desconocida (solo PNG o JPEG)');
}

// ---------------------------------------------------------------- Texto en línea

/** Divide un texto de Markdown en tramos con su formato: negrita, cursiva, código y enlace. */
function tramos(s, estilo = {}) {
  const out = [];
  let buf = '';
  const soltar = () => { if (buf) { out.push({ ...estilo, t: buf }); buf = ''; } };
  let i = 0;
  while (i < s.length) {
    const resto = s.slice(i);
    const antes = i ? s[i - 1] : ' ';
    let m;
    if ((m = resto.match(/^!\[([^\]]*)\]\(([^)\s]+)\)/))) { soltar(); i += m[0].length; continue; }
    if ((m = resto.match(/^\[([^\]]+)\]\(([^)\s]+)\)/))) {
      soltar();
      out.push(...tramos(m[1], { ...estilo, href: /^https?:/.test(m[2]) ? m[2] : estilo.href }));
      i += m[0].length; continue;
    }
    if ((m = resto.match(/^`([^`]+)`/))) { soltar(); out.push({ ...estilo, t: m[1], code: true }); i += m[0].length; continue; }
    if ((m = resto.match(/^\*\*(?=\S)(.+?)\*\*/))) { soltar(); out.push(...tramos(m[1], { ...estilo, b: true })); i += m[0].length; continue; }
    if (!/[\w*]/.test(antes) && (m = resto.match(/^\*(?=\S)((?:\*\*[^*]+\*\*|[^*])+?)\*(?![\w*])/))) {
      soltar(); out.push(...tramos(m[1], { ...estilo, i: true })); i += m[0].length; continue;
    }
    if (!estilo.href && (m = resto.match(/^https?:\/\/[^\s<>()]+[^\s<>().,;:»”]/))) { soltar(); out.push({ ...estilo, t: m[0], href: m[0] }); i += m[0].length; continue; }
    if (resto.startsWith('\\|')) { buf += '|'; i += 2; continue; }
    buf += s[i];
    i++;
  }
  soltar();
  return out;
}

// ---------------------------------------------------------------- Documento

class Documento {
  constructor(opciones) {
    this.raiz = opciones.raiz;            // carpeta desde la que se resuelven las imágenes
    this.laminas = opciones.laminas;      // clave → { archivo, anchoMm }
    this.medios = [];                     // { nombre, datos }
    this.relaciones = [];                 // { id, tipo, destino, externo }
    this.porArchivo = new Map();
    this.porUrl = new Map();
    this.idDibujo = 1;
    this.idMarca = 1;
    this.numeros = [];                    // listas numeradas: cada una reinicia
    this.indice = [];                     // { nivel, texto, marca }
    this.piezas = [];                     // tablas y figuras: { tipo, rotulo, titulo, marca }
    this.orden = [];                      // títulos y piezas en el orden del documento, para buscar su página
    this.avisos = [];
  }

  relacion(tipo, destino, externo = false) {
    const id = `rId${this.relaciones.length + 10}`;
    this.relaciones.push({ id, tipo, destino, externo });
    return id;
  }

  enlace(url) {
    if (!this.porUrl.has(url)) this.porUrl.set(url, this.relacion('http://schemas.openxmlformats.org/officeDocument/2006/relationships/hyperlink', url, true));
    return this.porUrl.get(url);
  }

  imagen(archivo) {
    const abs = path.resolve(archivo);
    if (!this.porArchivo.has(abs)) {
      const datos = fs.readFileSync(abs);
      const m = medidas(datos);
      const nombre = `imagen${this.medios.length + 1}.${m.tipo === 'png' ? 'png' : 'jpeg'}`;
      this.medios.push({ nombre: `word/media/${nombre}`, datos });
      const id = this.relacion('http://schemas.openxmlformats.org/officeDocument/2006/relationships/image', `media/${nombre}`);
      this.porArchivo.set(abs, { id, ...m });
    }
    return this.porArchivo.get(abs);
  }

  /** Una imagen en línea, de ancho dado en dxa (y alto máximo opcional), sin deformar. */
  dibujo(archivo, anchoDxa, altoMaxDxa, descripcion = '') {
    const img = this.imagen(archivo);
    let w = anchoDxa;
    let h = Math.round(w * img.alto / img.ancho);
    if (altoMaxDxa && h > altoMaxDxa) { h = altoMaxDxa; w = Math.round(h * img.ancho / img.alto); }
    const cx = w * EMU_POR_DXA;
    const cy = h * EMU_POR_DXA;
    const id = this.idDibujo++;
    return `<w:r><w:drawing><wp:inline distT="0" distB="0" distL="0" distR="0"><wp:extent cx="${cx}" cy="${cy}"/><wp:effectExtent l="0" t="0" r="0" b="0"/>` +
      `<wp:docPr id="${id}" name="Imagen ${id}" descr="${x(descripcion)}"/><wp:cNvGraphicFramePr><a:graphicFrameLocks xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main" noChangeAspect="1"/></wp:cNvGraphicFramePr>` +
      `<a:graphic xmlns:a="http://schemas.openxmlformats.org/drawingml/2006/main"><a:graphicData uri="http://schemas.openxmlformats.org/drawingml/2006/picture">` +
      `<pic:pic xmlns:pic="http://schemas.openxmlformats.org/drawingml/2006/picture"><pic:nvPicPr><pic:cNvPr id="${id}" name="Imagen ${id}" descr="${x(descripcion)}"/><pic:cNvPicPr/></pic:nvPicPr>` +
      `<pic:blipFill><a:blip r:embed="${img.id}"/><a:stretch><a:fillRect/></a:stretch></pic:blipFill>` +
      `<pic:spPr><a:xfrm><a:off x="0" y="0"/><a:ext cx="${cx}" cy="${cy}"/></a:xfrm><a:prstGeom prst="rect"><a:avLst/></a:prstGeom></pic:spPr></pic:pic>` +
      `</a:graphicData></a:graphic></wp:inline></w:drawing></w:r>`;
  }

  /** Los tramos de un texto como runs de Word; los enlaces externos, como hipervínculos. */
  runs(texto, base = {}) {
    const ts = tramos(texto);
    let out = '';
    let i = 0;
    while (i < ts.length) {
      const href = ts[i].href;
      let grupo = '';
      while (i < ts.length && ts[i].href === href) grupo += this.run(ts[i++], base, Boolean(href));
      out += href ? `<w:hyperlink r:id="${this.enlace(href)}" w:history="1">${grupo}</w:hyperlink>` : grupo;
    }
    return out;
  }

  run(t, base, enlace) {
    const props = [];
    if (enlace) props.push('<w:rStyle w:val="Hyperlink"/>');
    if (t.b || base.b) props.push('<w:b/><w:bCs/>');
    if (t.i || base.i) props.push('<w:i/><w:iCs/>');
    if (base.color) props.push(`<w:color w:val="${base.color}"/>`);
    if (base.sz) props.push(`<w:sz w:val="${base.sz}"/><w:szCs w:val="${base.sz}"/>`);
    return `<w:r>${props.length ? `<w:rPr>${props.join('')}</w:rPr>` : ''}<w:t xml:space="preserve">${x(t.t)}</w:t></w:r>`;
  }

  parrafo(texto, estilo, extra = '', base = {}) {
    const pPr = `<w:pPr>${estilo ? `<w:pStyle w:val="${estilo}"/>` : ''}${extra}</w:pPr>`;
    return `<w:p>${pPr}${this.runs(texto, base)}</w:p>`;
  }

  encabezado(nivel, texto, { aIndice = nivel <= 2 } = {}) {
    const limpio = tramos(texto).map((t) => t.t).join('');
    if (!aIndice) return this.parrafo(texto, `Heading${nivel}`);
    const marca = `_Toc${String(this.idMarca).padStart(6, '0')}`;
    const id = this.idMarca++;
    this.indice.push({ nivel, texto: limpio, marca });
    this.orden.push({ clase: 'titulo', i: this.indice.length - 1 });
    return `<w:p><w:pPr><w:pStyle w:val="Heading${nivel}"/></w:pPr><w:bookmarkStart w:id="${id}" w:name="${marca}"/>${this.runs(texto)}<w:bookmarkEnd w:id="${id}"/></w:p>`;
  }

  // ------------------------------------------------------------ Bloques

  /** Convierte las líneas de una parte en párrafos, listas, tablas e imágenes de Word. */
  bloques(lineas, { referencias = false } = {}) {
    const out = [];
    let i = 0;
    let anterior = '';
    const MARCA = /^(\s*)([-*+]|\d+[.)])\s+(.*)$/;
    while (i < lineas.length) {
      const l = lineas[i];
      if (!l.trim()) { i++; continue; }
      const h = l.match(/^(#{1,6})\s+(.+?)\s*$/);
      if (h) { out.push(this.encabezado(Math.min(4, h[1].length), h[2], { aIndice: false })); anterior = 'h'; i++; continue; }
      const ficha = l.trim().match(/^\[\[(.+)\]\]$/);
      if (ficha) {
        const lam = this.laminas[ficha[1]];
        if (!lam) throw new Error(`Falta la imagen de ${ficha[1]} para el Word`);
        const ancho = Math.min(TEXTO, Math.round(lam.anchoMm * 56.6929));
        out.push(`<w:p><w:pPr><w:pStyle w:val="Imagen"/></w:pPr>${this.dibujo(lam.archivo, ancho, 7400, ficha[1])}</w:p>`);
        anterior = 'img'; i++; continue;
      }
      if (/^\s*```/.test(l)) {
        const codigo = [];
        i++;
        while (i < lineas.length && !/^\s*```/.test(lineas[i])) codigo.push(lineas[i++]);
        i++;
        for (const c of codigo) out.push(`<w:p><w:pPr><w:pStyle w:val="Codigo"/></w:pPr><w:r><w:t xml:space="preserve">${x(c)}</w:t></w:r></w:p>`);
        anterior = 'code'; continue;
      }
      if (/^\s*\|/.test(l)) {
        const filas = [];
        while (i < lineas.length && /^\s*\|/.test(lineas[i])) filas.push(lineas[i++]);
        out.push(this.tabla(filas));
        anterior = 'tabla'; continue;
      }
      if (/^\s*>/.test(l)) {
        const cita = [];
        while (i < lineas.length && /^\s*>/.test(lineas[i])) cita.push(lineas[i++].replace(/^\s*>\s?/, ''));
        const parrafos = cita.join('\n').split(/\n\s*\n/).map((p) => p.replace(/\s*\n\s*/g, ' ').trim()).filter(Boolean);
        for (const p of parrafos) out.push(this.parrafo(p, 'Cita'));
        anterior = 'cita'; continue;
      }
      if (MARCA.test(l)) {
        const r = this.lista(lineas, i, MARCA);
        out.push(...r.parrafos);
        i = r.i; anterior = 'lista'; continue;
      }
      const parrafo = [];
      while (i < lineas.length && lineas[i].trim() && !/^(#{1,6}\s|\s*\||\s*>|\s*```)/.test(lineas[i]) && !MARCA.test(lineas[i]) && !/^\[\[/.test(lineas[i].trim())) parrafo.push(lineas[i++].trim());
      const texto = parrafo.join(' ');
      const img = texto.match(/^!\[([^\]]*)\]\(([^)\s]+)\)$/);
      if (img) {
        const archivo = path.resolve(this.raiz, decodeURI(img[2]));
        out.push(`<w:p><w:pPr><w:pStyle w:val="Imagen"/></w:pPr>${this.dibujo(archivo, TEXTO, 11500, img[1])}</w:p>`);
        anterior = 'img'; continue;
      }
      const rot = texto.match(/^\*\*((Tabla|Figura) [A-I]?\d+)\*\*$/);
      if (rot) { out.push(this.rotulo(rot[1], rot[2])); anterior = 'rotulo'; continue; }
      if (anterior === 'rotulo' && /^\*[^*].*\*$/.test(texto)) {
        this.piezas[this.piezas.length - 1].titulo = tramos(texto.slice(1, -1)).map((t) => t.t).join('');
        out.push(this.parrafo(texto.slice(1, -1), 'TituloPieza')); anterior = 'titulo'; continue;
      }
      if (/^\*Nota\.\*/.test(texto)) { out.push(this.parrafo(texto, 'NotaPieza')); anterior = 'nota'; continue; }
      out.push(this.parrafo(texto, referencias ? 'Referencia' : null));
      anterior = 'p';
    }
    return out.join('');
  }

  lista(lineas, inicio, MARCA) {
    const sangria = (l) => l.match(/^(\s*)/)[1].replace(/\t/g, '    ').length;
    const items = [];
    let i = inicio;
    const base = sangria(lineas[i]);
    while (i < lineas.length) {
      const l = lineas[i];
      const m = l.match(MARCA);
      if (m) {
        items.push({ nivel: Math.min(2, Math.floor((sangria(l) - base) / 2)), ordenada: /\d/.test(m[2]), numero: parseInt(m[2], 10), texto: [m[3]] });
        i++; continue;
      }
      if (!l.trim()) {
        let j = i + 1;
        while (j < lineas.length && !lineas[j].trim()) j++;
        if (j < lineas.length && MARCA.test(lineas[j]) && sangria(lineas[j]) >= base) { i = j; continue; }
        break;
      }
      if (items.length && !/^\s*(#|\||>|```|\[\[)/.test(l)) { items[items.length - 1].texto.push(l.trim()); i++; continue; }
      break;
    }
    // Cada lista ordenada es una numeración propia, que empieza en su primer número; las viñetas usan la 1.
    const actual = {};
    const parrafos = items.map((it, k) => {
      for (const n of Object.keys(actual)) if (+n > it.nivel) delete actual[n];
      let num = 1;
      if (it.ordenada) {
        if (!actual[it.nivel]) { this.numeros.push(it.numero || 1); actual[it.nivel] = this.numeros.length + 1; }
        num = actual[it.nivel];
      } else {
        delete actual[it.nivel];
      }
      const ultimo = k === items.length - 1;
      return `<w:p><w:pPr><w:pStyle w:val="${ultimo ? 'ListaFin' : 'Lista'}"/><w:numPr><w:ilvl w:val="${it.nivel}"/><w:numId w:val="${num}"/></w:numPr></w:pPr>${this.runs(it.texto.join(' '))}</w:p>`;
    });
    return { parrafos, i };
  }

  // ------------------------------------------------------------ Tablas

  tabla(filas) {
    const celdas = (fila) => {
      const out = [];
      let actual = '';
      let codigo = false;
      const t = fila.trim().replace(/^\|/, '').replace(/\|$/, '');
      for (let i = 0; i < t.length; i++) {
        const c = t[i];
        if (c === '\\' && t[i + 1] === '|') { actual += '\\|'; i++; continue; }
        if (c === '`') codigo = !codigo;
        if (c === '|' && !codigo) { out.push(actual.trim()); actual = ''; continue; }
        actual += c;
      }
      out.push(actual.trim());
      return out;
    };
    const cab = celdas(filas[0]);
    const cuerpo = filas.slice(2).map(celdas);
    const esImagen = (c) => /^!\[[^\]]*\]\([^)\s]+\)$/.test(c);
    if (cuerpo.length && cuerpo.every((f) => f.every(esImagen))) return this.galeria(cab, cuerpo);

    const n = cab.length;
    const plano = (s) => tramos(s).map((t) => t.t).join('');
    const esGrupo = (f) => n > 1 && f[0] && f.slice(1).every((c) => !c);
    const chica = n >= 5 || cuerpo.length > 30;
    const anchoLetra = chica ? 104 : 116;         // dxa por carácter, aproximado, a 9 y 10 puntos
    // Anchos como los de una tabla web: cada columna va de lo que ocupa su palabra más larga (para no cortarla) a lo que
    // ocupa su texto más largo en una línea, y el espacio que sobra se reparte en proporción a esa diferencia. Así, una
    // columna de rótulos cortos no queda angosta junto a una de párrafos. La negrita ocupa un 10 % más.
    const medidas = cab.map((h, k) => {
      const celdasCol = [h, ...cuerpo.filter((f) => !esGrupo(f)).map((f) => f[k] || '')];
      const factor = (c, j) => (j === 0 || /^\*\*/.test(c) ? 1.1 : 1);
      const palabra = Math.max(...celdasCol.flatMap((c, j) => plano(c).split(/\s+/).map((p) => p.length * factor(c, j))));
      const largo = Math.max(...celdasCol.map((c, j) => plano(c).length * factor(c, j)));
      const minimo = Math.min(Math.round(TEXTO * 1.6 / n), Math.ceil(palabra * anchoLetra) + 220);
      return { minimo, maximo: Math.max(minimo, Math.min(TEXTO, Math.ceil(largo * anchoLetra) + 220)) };
    });
    const sMin = medidas.reduce((a, m) => a + m.minimo, 0);
    const sMax = medidas.reduce((a, m) => a + m.maximo, 0);
    let anchos;
    if (sMax <= TEXTO) anchos = medidas.map((m) => Math.floor(m.maximo * TEXTO / sMax));
    else if (sMin >= TEXTO) anchos = medidas.map((m) => Math.floor(m.minimo * TEXTO / sMin));
    else anchos = medidas.map((m) => Math.floor(m.minimo + (m.maximo - m.minimo) * (TEXTO - sMin) / (sMax - sMin)));
    anchos[anchos.length - 1] += TEXTO - anchos.reduce((a, b) => a + b, 0);

    const estiloCelda = chica ? 'TablaTextoChico' : 'TablaTexto';
    const celda = (texto, k, encabezado) => `<w:tc><w:tcPr><w:tcW w:w="${anchos[k]}" w:type="dxa"/></w:tcPr>` +
      `<w:p><w:pPr><w:pStyle w:val="${estiloCelda}"/></w:pPr>${this.runs(texto, encabezado ? { b: true } : {})}</w:p></w:tc>`;
    const grupo = (texto) => `<w:tc><w:tcPr><w:tcW w:w="${TEXTO}" w:type="dxa"/><w:gridSpan w:val="${n}"/></w:tcPr>` +
      `<w:p><w:pPr><w:pStyle w:val="${estiloCelda}"/><w:keepNext/></w:pPr>${this.runs(texto.replace(/^\*\*(.*)\*\*$/, '$1'), { b: true })}</w:p></w:tc>`;

    const filasXml = [
      `<w:tr><w:trPr><w:tblHeader/><w:cantSplit/></w:trPr>${cab.map((c, k) => celda(c, k, true)).join('')}</w:tr>`,
      ...cuerpo.map((f) => {
        const vacias = f.slice(1).every((c) => !c);
        if (n > 1 && f[0] && vacias) return `<w:tr><w:trPr><w:cantSplit/></w:trPr>${grupo(f[0])}</w:tr>`;
        return `<w:tr><w:trPr><w:cantSplit/></w:trPr>${cab.map((_, k) => celda(f[k] || '', k, false)).join('')}</w:tr>`;
      }),
    ];
    return `<w:tbl><w:tblPr><w:tblStyle w:val="TableGrid"/><w:tblW w:w="${TEXTO}" w:type="dxa"/><w:tblLayout w:type="fixed"/><w:tblLook w:val="04A0" w:firstRow="1" w:lastRow="0" w:firstColumn="0" w:lastColumn="0" w:noHBand="1" w:noVBand="1"/></w:tblPr>` +
      `<w:tblGrid>${anchos.map((w) => `<w:gridCol w:w="${w}"/>`).join('')}</w:tblGrid>${filasXml.join('')}</w:tbl>` + this.parrafoVacio();
  }

  /** Una tabla de imágenes: cada celda lleva la imagen y, debajo, su nombre. */
  galeria(cab, cuerpo) {
    const n = cab.length;
    const ancho = Math.floor(TEXTO / n);
    const altoMax = n >= 4 ? 5200 : n === 1 ? 11000 : 6000;
    const filas = [];
    for (const f of cuerpo) {
      const celdas = f.map((c, k) => {
        const m = c.match(/^!\[([^\]]*)\]\(([^)\s]+)\)$/);
        const archivo = path.resolve(this.raiz, decodeURI(m[2]));
        return `<w:tc><w:tcPr><w:tcW w:w="${ancho}" w:type="dxa"/></w:tcPr>` +
          `<w:p><w:pPr><w:pStyle w:val="ImagenGaleria"/></w:pPr>${this.dibujo(archivo, ancho - 160, altoMax, m[1])}</w:p>` +
          `<w:p><w:pPr><w:pStyle w:val="PieGaleria"/></w:pPr>${this.runs(cab[k] || m[1])}</w:p></w:tc>`;
      });
      filas.push(`<w:tr><w:trPr><w:cantSplit/></w:trPr>${celdas.join('')}</w:tr>`);
    }
    return `<w:tbl><w:tblPr><w:tblStyle w:val="TablaGaleria"/><w:tblW w:w="${ancho * n}" w:type="dxa"/><w:tblLayout w:type="fixed"/><w:tblLook w:val="0000" w:firstRow="0" w:lastRow="0" w:firstColumn="0" w:lastColumn="0" w:noHBand="1" w:noVBand="1"/></w:tblPr>` +
      `<w:tblGrid>${cab.map(() => `<w:gridCol w:w="${ancho}"/>`).join('')}</w:tblGrid>${filas.join('')}</w:tbl>` + this.parrafoVacio();
  }

  parrafoVacio() { return '<w:p><w:pPr><w:pStyle w:val="TrasTabla"/></w:pPr></w:p>'; }

  // ------------------------------------------------------------ Índice

  /** El rótulo de una tabla o figura, con un marcador para su índice. */
  rotulo(texto, tipo) {
    const marca = `_Pie${String(this.idMarca).padStart(6, '0')}`;
    const id = this.idMarca++;
    this.piezas.push({ tipo, rotulo: texto, titulo: '', marca });
    this.orden.push({ clase: 'pieza', i: this.piezas.length - 1 });
    return `<w:p><w:pPr><w:pStyle w:val="RotuloPieza"/></w:pPr><w:bookmarkStart w:id="${id}" w:name="${marca}"/>${this.runs(texto)}<w:bookmarkEnd w:id="${id}"/></w:p>`;
  }

  /** El índice de tablas o de figuras: cada rótulo con su título y su página, que Word actualiza con los campos. */
  listaXml(tipo, titulo, paginas, nuevaPagina) {
    const items = this.piezas.map((p, k) => ({ ...p, pagina: paginas ? paginas[k] : '' })).filter((p) => p.tipo === tipo);
    if (!items.length) return '';
    const cabeza = `<w:p><w:pPr><w:pStyle w:val="TituloIndice"/>${nuevaPagina ? '<w:pageBreakBefore/>' : '<w:spacing w:before="480"/>'}</w:pPr><w:r><w:t>${x(titulo)}</w:t></w:r></w:p>`;
    return cabeza + items.map((p) => `<w:p><w:pPr><w:pStyle w:val="TableofFigures"/><w:tabs><w:tab w:val="right" w:leader="dot" w:pos="${TEXTO}"/></w:tabs></w:pPr>` +
      `<w:hyperlink w:anchor="${p.marca}" w:history="1"><w:r><w:t xml:space="preserve">${x(`${p.rotulo}. ${p.titulo}`)}</w:t></w:r><w:r><w:tab/></w:r>` +
      `<w:r><w:fldChar w:fldCharType="begin"/></w:r><w:r><w:instrText xml:space="preserve"> PAGEREF ${p.marca} \\h </w:instrText></w:r><w:r><w:fldChar w:fldCharType="separate"/></w:r><w:r><w:t>${p.pagina || ''}</w:t></w:r><w:r><w:fldChar w:fldCharType="end"/></w:r></w:hyperlink></w:p>`).join('');
  }

  /** El índice como campo TOC de Word, con sus entradas ya escritas y, si se conocen, sus páginas. */
  indiceXml(paginas) {
    const entradas = this.indice.map((e, k) => {
      const inicio = k === 0 ? '<w:r><w:fldChar w:fldCharType="begin"/></w:r><w:r><w:instrText xml:space="preserve"> TOC \\o "1-2" \\h \\z \\u </w:instrText></w:r><w:r><w:fldChar w:fldCharType="separate"/></w:r>' : '';
      return `<w:p><w:pPr><w:pStyle w:val="TOC${e.nivel}"/><w:tabs><w:tab w:val="right" w:leader="dot" w:pos="${TEXTO}"/></w:tabs></w:pPr>${inicio}` +
        `<w:hyperlink w:anchor="${e.marca}" w:history="1"><w:r><w:t xml:space="preserve">${x(e.texto)}</w:t></w:r><w:r><w:tab/></w:r>` +
        `<w:r><w:fldChar w:fldCharType="begin"/></w:r><w:r><w:instrText xml:space="preserve"> PAGEREF ${e.marca} \\h </w:instrText></w:r><w:r><w:fldChar w:fldCharType="separate"/></w:r><w:r><w:t>${paginas && paginas[k] ? paginas[k] : ''}</w:t></w:r><w:r><w:fldChar w:fldCharType="end"/></w:r></w:hyperlink></w:p>`;
    });
    return entradas.join('') + '<w:p><w:r><w:fldChar w:fldCharType="end"/></w:r></w:p>';
  }
}

// ---------------------------------------------------------------- Partes fijas del paquete

const NS = 'xmlns:wpc="http://schemas.microsoft.com/office/word/2010/wordprocessingCanvas" xmlns:mc="http://schemas.openxmlformats.org/markup-compatibility/2006" ' +
  'xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships" xmlns:wp="http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing" ' +
  'xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main" xmlns:w14="http://schemas.microsoft.com/office/word/2010/wordml" mc:Ignorable="w14"';
const XML = '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>\n';

function estilos() {
  const fuente = `<w:rFonts w:ascii="${LETRA}" w:hAnsi="${LETRA}" w:eastAsia="${LETRA}" w:cs="${LETRA}"/>`;
  const tam = (n) => `<w:sz w:val="${n}"/><w:szCs w:val="${n}"/>`;
  const negrita = '<w:b/><w:bCs/>';
  const cursiva = '<w:i/><w:iCs/>';
  const parrafo = (id, nombre, { basado = 'Normal', siguiente, ppr = '', rpr = '', nivel, oculto = false, prioridad = 20, integrado = false } = {}) =>
    `<w:style w:type="paragraph"${integrado ? '' : ' w:customStyle="1"'} w:styleId="${id}"><w:name w:val="${nombre}"/>${basado ? `<w:basedOn w:val="${basado}"/>` : ''}${siguiente ? `<w:next w:val="${siguiente}"/>` : ''}` +
    `<w:uiPriority w:val="${prioridad}"/>${oculto ? '<w:semiHidden/>' : '<w:qFormat/>'}<w:pPr>${ppr}${nivel !== undefined ? `<w:outlineLvl w:val="${nivel}"/>` : ''}</w:pPr><w:rPr>${rpr}</w:rPr></w:style>`;
  // Los títulos de Word, en negro: el del anexo en negrita de 14 puntos; los demás, de 12.
  const titulo = (n, forma, puntos, antes, despues) => parrafo(`Heading${n}`, `heading ${n}`, {
    siguiente: 'Normal', nivel: n - 1, prioridad: 9, integrado: true,
    ppr: `<w:keepNext/><w:keepLines/>${n === 1 ? '<w:pageBreakBefore/>' : ''}<w:spacing w:before="${antes}" w:after="${despues}" w:line="240" w:lineRule="auto"/>`,
    rpr: `${fuente}${forma}<w:color w:val="${NEGRO}"/>${tam(puntos * 2)}`,
  });
  const borde = (lado) => `<w:${lado} w:val="single" w:sz="4" w:space="0" w:color="${NEGRO}"/>`;
  return XML + `<w:styles xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main">
<w:docDefaults><w:rPrDefault><w:rPr>${fuente}<w:color w:val="${NEGRO}"/>${tam(24)}<w:lang w:val="es-CL" w:eastAsia="es-CL" w:bidi="ar-SA"/></w:rPr></w:rPrDefault>
<w:pPrDefault><w:pPr><w:spacing w:after="120" w:line="360" w:lineRule="auto"/></w:pPr></w:pPrDefault></w:docDefaults>
<w:style w:type="paragraph" w:default="1" w:styleId="Normal"><w:name w:val="Normal"/><w:qFormat/><w:pPr><w:widowControl/><w:spacing w:after="120" w:line="360" w:lineRule="auto"/></w:pPr><w:rPr>${fuente}${tam(24)}</w:rPr></w:style>
<w:style w:type="character" w:default="1" w:styleId="DefaultParagraphFont"><w:name w:val="Default Paragraph Font"/><w:uiPriority w:val="1"/><w:semiHidden/></w:style>
<w:style w:type="table" w:default="1" w:styleId="TableNormal"><w:name w:val="Normal Table"/><w:uiPriority w:val="99"/><w:semiHidden/><w:tblPr><w:tblInd w:w="0" w:type="dxa"/><w:tblCellMar><w:top w:w="0" w:type="dxa"/><w:left w:w="108" w:type="dxa"/><w:bottom w:w="0" w:type="dxa"/><w:right w:w="108" w:type="dxa"/></w:tblCellMar></w:tblPr></w:style>
<w:style w:type="numbering" w:default="1" w:styleId="NoList"><w:name w:val="No List"/><w:uiPriority w:val="99"/><w:semiHidden/></w:style>
${titulo(1, negrita, 14, 0, 360)}
${titulo(2, negrita, 12, 360, 120)}
${titulo(3, negrita + cursiva, 12, 240, 80)}
${titulo(4, cursiva, 12, 200, 60)}
${parrafo('Portada', 'Portada', { ppr: '<w:spacing w:after="0" w:line="240" w:lineRule="auto"/><w:jc w:val="center"/>' })}
${parrafo('TituloIndice', 'Título del índice', { siguiente: 'Normal', ppr: '<w:keepNext/><w:spacing w:after="360" w:line="240" w:lineRule="auto"/>', rpr: negrita + tam(28) })}
${parrafo('TOC1', 'toc 1', { siguiente: 'Normal', oculto: true, prioridad: 39, integrado: true, ppr: '<w:spacing w:before="120" w:after="40" w:line="276" w:lineRule="auto"/>', rpr: negrita })}
${parrafo('TableofFigures', 'table of figures', { siguiente: 'Normal', oculto: true, prioridad: 99, integrado: true, ppr: '<w:spacing w:after="40" w:line="276" w:lineRule="auto"/>' })}
${parrafo('TOC2', 'toc 2', { siguiente: 'Normal', oculto: true, prioridad: 39, integrado: true, ppr: '<w:spacing w:after="40" w:line="276" w:lineRule="auto"/><w:ind w:left="284"/>' })}
${parrafo('Lista', 'Lista', { ppr: '<w:spacing w:after="60"/>' })}
${parrafo('ListaFin', 'Lista, último elemento', { basado: 'Lista', ppr: '<w:spacing w:after="160"/>' })}
${parrafo('RotuloPieza', 'Rótulo de tabla o figura', { siguiente: 'TituloPieza', ppr: '<w:keepNext/><w:spacing w:before="240" w:after="0"/>', rpr: negrita })}
${parrafo('TituloPieza', 'Título de tabla o figura', { siguiente: 'Normal', ppr: '<w:keepNext/><w:spacing w:after="120"/>', rpr: cursiva })}
${parrafo('NotaPieza', 'Nota de tabla o figura', { ppr: '<w:spacing w:before="60" w:after="240" w:line="240" w:lineRule="auto"/>', rpr: tam(20) })}
${parrafo('TablaTexto', 'Texto de tabla', { ppr: '<w:spacing w:before="20" w:after="20" w:line="240" w:lineRule="auto"/>', rpr: tam(20) })}
${parrafo('TablaTextoChico', 'Texto de tabla, chico', { basado: 'TablaTexto', rpr: tam(18) })}
${parrafo('TrasTabla', 'Espacio tras tabla', { ppr: '<w:spacing w:after="0" w:line="120" w:lineRule="exact"/>', rpr: tam(8), oculto: true })}
${parrafo('Imagen', 'Imagen', { ppr: '<w:spacing w:before="60" w:after="60" w:line="240" w:lineRule="auto"/><w:jc w:val="center"/>' })}
${parrafo('ImagenGaleria', 'Imagen de galería', { ppr: '<w:keepNext/><w:spacing w:before="80" w:after="40" w:line="240" w:lineRule="auto"/><w:jc w:val="center"/>' })}
${parrafo('PieGaleria', 'Pie de imagen de galería', { ppr: '<w:spacing w:after="120" w:line="240" w:lineRule="auto"/><w:jc w:val="center"/>', rpr: tam(20) })}
${parrafo('Cita', 'Cita en bloque', { ppr: '<w:spacing w:before="60" w:after="160"/><w:ind w:left="720"/>' })}
${parrafo('Referencia', 'Referencia (APA 7)', { ppr: '<w:spacing w:after="120"/><w:ind w:left="720" w:hanging="720"/>' })}
${parrafo('TituloReferencias', 'Título de las referencias', { siguiente: 'Referencia', ppr: '<w:keepNext/><w:keepLines/><w:spacing w:before="360" w:after="120" w:line="240" w:lineRule="auto"/>', rpr: negrita })}
${parrafo('Codigo', 'Código', { ppr: '<w:spacing w:after="0" w:line="240" w:lineRule="auto"/><w:ind w:left="284"/>', rpr: tam(20) })}
${parrafo('PiePagina', 'Número de página', { ppr: '<w:spacing w:after="0" w:line="240" w:lineRule="auto"/><w:jc w:val="center"/>', rpr: tam(20), oculto: true })}
<w:style w:type="character" w:styleId="Hyperlink"><w:name w:val="Hyperlink"/><w:basedOn w:val="DefaultParagraphFont"/><w:uiPriority w:val="99"/><w:rPr><w:color w:val="${NEGRO}"/><w:u w:val="none"/></w:rPr></w:style>
<w:style w:type="table" w:styleId="TableGrid"><w:name w:val="Table Grid"/><w:basedOn w:val="TableNormal"/><w:uiPriority w:val="39"/><w:tblPr>
<w:tblBorders>${['top', 'left', 'bottom', 'right', 'insideH', 'insideV'].map(borde).join('')}</w:tblBorders>
<w:tblCellMar><w:top w:w="57" w:type="dxa"/><w:left w:w="85" w:type="dxa"/><w:bottom w:w="57" w:type="dxa"/><w:right w:w="85" w:type="dxa"/></w:tblCellMar></w:tblPr></w:style>
<w:style w:type="table" w:customStyle="1" w:styleId="TablaGaleria"><w:name w:val="Tabla de imágenes"/><w:uiPriority w:val="40"/><w:tblPr><w:tblCellMar><w:top w:w="0" w:type="dxa"/><w:left w:w="80" w:type="dxa"/><w:bottom w:w="0" w:type="dxa"/><w:right w:w="80" w:type="dxa"/></w:tblCellMar></w:tblPr></w:style>
</w:styles>`;
}

function numeracion(reinicios) {
  const vineta = ['•', '◦', '▪'];
  const nivelV = (n) => `<w:lvl w:ilvl="${n}"><w:start w:val="1"/><w:numFmt w:val="bullet"/><w:lvlText w:val="${vineta[n]}"/><w:lvlJc w:val="left"/><w:pPr><w:ind w:left="${360 + n * 360}" w:hanging="284"/></w:pPr><w:rPr><w:rFonts w:ascii="${LETRA}" w:hAnsi="${LETRA}"/></w:rPr></w:lvl>`;
  const formato = ['decimal', 'decimal', 'decimal'];
  const nivelN = (n) => `<w:lvl w:ilvl="${n}"><w:start w:val="1"/><w:numFmt w:val="${formato[n]}"/><w:lvlText w:val="%${n + 1}."/><w:lvlJc w:val="left"/><w:pPr><w:ind w:left="${397 + n * 397}" w:hanging="397"/></w:pPr></w:lvl>`;
  const abstractos = `<w:abstractNum w:abstractNumId="0"><w:multiLevelType w:val="hybridMultilevel"/>${[0, 1, 2].map(nivelV).join('')}</w:abstractNum>` +
    `<w:abstractNum w:abstractNumId="1"><w:multiLevelType w:val="hybridMultilevel"/>${[0, 1, 2].map(nivelN).join('')}</w:abstractNum>`;
  const nums = ['<w:num w:numId="1"><w:abstractNumId w:val="0"/></w:num>',
    ...reinicios.map((inicio, k) => `<w:num w:numId="${k + 2}"><w:abstractNumId w:val="1"/>${[0, 1, 2].map((n) => `<w:lvlOverride w:ilvl="${n}"><w:startOverride w:val="${n === 0 ? inicio : 1}"/></w:lvlOverride>`).join('')}</w:num>`)];
  return XML + `<w:numbering xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main">${abstractos}${nums.join('')}</w:numbering>`;
}

const ajustes = () => XML + `<w:settings xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main"><w:defaultTabStop w:val="709"/><w:hyphenationZone w:val="425"/><w:characterSpacingControl w:val="doNotCompress"/><w:updateFields w:val="true"/><w:compat><w:compatSetting w:name="compatibilityMode" w:uri="http://schemas.microsoft.com/office/word" w:val="15"/></w:compat><w:themeFontLang w:val="es-CL"/></w:settings>`;

const fuentes = () => XML + `<w:fonts xmlns:w="http://schemas.openxmlformats.org/wordprocessingml/2006/main">` +
  `<w:font w:name="${LETRA}"><w:panose1 w:val="020B0604020202020204"/><w:charset w:val="00"/><w:family w:val="swiss"/><w:pitch w:val="variable"/></w:font></w:fonts>`;

const pie = () => XML + `<w:ftr ${NS}><w:p><w:pPr><w:pStyle w:val="PiePagina"/></w:pPr>` +
  '<w:r><w:fldChar w:fldCharType="begin"/></w:r><w:r><w:instrText xml:space="preserve"> PAGE </w:instrText></w:r><w:r><w:fldChar w:fldCharType="separate"/></w:r><w:r><w:t>1</w:t></w:r><w:r><w:fldChar w:fldCharType="end"/></w:r></w:p></w:ftr>';
const pieVacio = () => XML + `<w:ftr ${NS}><w:p><w:pPr><w:pStyle w:val="PiePagina"/></w:pPr></w:p></w:ftr>`;

// ---------------------------------------------------------------- Armado

/**
 * @param {object} o
 * @param {string} o.salida   ruta del .docx
 * @param {string} o.raiz     carpeta desde la que se leen las imágenes de los anexos
 * @param {object} o.portada  { titulo, subtitulo, documento, autor, grado, profesores, modalidad, facultad, escuela, ciudad, fecha,
 *                             logo: { archivo, anchoMm, descripcion } }
 * @param {Array}  [o.paginas] la página de cada entrada del índice, si ya se conoce
 * @param {Array}  o.anexos   [{ letra, titulo, intro, partes: [{ titulo, lineas, clase }] }]
 * @param {object} o.laminas  clave → { archivo, anchoMm } para [[LOGO]], [[ICONOS]], [[DIAGRAMA id]]…
 * @param {string} o.autor
 */
function construirWord(o) {
  const d = new Documento({ raiz: o.raiz, laminas: o.laminas });

  // Portada copiada de la de ejemplo de la Biblioteca UDP (biblioteca-portada-ejemplo.pdf): el logo de la Universidad
  // arriba; el título en mayúsculas con su subtítulo; el autor en mayúsculas; el título al que se opta; el profesor
  // guía; FACULTAD y ESCUELA en mayúsculas, y la ciudad y la fecha. Todo en Arial 12, interlineado sencillo, centrado
  // en la página. Cada bloque queda a la altura que tiene en la portada de ejemplo, medida en puntos; la modalidad,
  // que pide el instructivo de la Escuela, va bajo los profesores guía, y «Anexos», bajo el subtítulo.
  const p = o.portada;
  const mayus = (s) => s.toLocaleUpperCase('es-CL');
  const centrada = '<w:ind w:left="-283" w:right="283"/>'; // los márgenes son 3,5 y 2,5 cm: así queda al centro de la hoja
  const linea = (texto, antes = 0) => d.parrafo(texto, 'Portada', `${antes ? `<w:spacing w:before="${antes}"/>` : ''}${centrada}`);
  const portada = [
    `<w:p><w:pPr><w:pStyle w:val="Portada"/>${centrada}</w:pPr>${d.dibujo(p.logo.archivo, Math.round(p.logo.anchoMm * 56.6929), null, p.logo.descripcion)}</w:p>`,
    linea(mayus(p.titulo), 2218),
    linea(p.subtitulo),
    linea(p.documento),
    linea(mayus(p.autor), 1652),
    linea(p.grado, 1144),
    linea(p.profesores, 1104),
    linea(p.modalidad),
    linea(mayus(p.facultad), 1338),
    linea(mayus(p.escuela)),
    linea(p.ciudad, 878),
    ...(p.fecha ? [linea(mayus(p.fecha[0]) + p.fecha.slice(1))] : []),
  ].join('');

  // Anexos
  const cuerpo = o.anexos.map((a) => {
    const inicio = d.encabezado(1, `Anexo ${a.letra}. ${a.titulo}`) + d.parrafo(a.intro, null);
    const partes = a.partes.map((p) => {
      const ref = p.clase === 'referencias';
      const titulo = !p.titulo ? '' : ref ? d.parrafo(p.titulo, 'TituloReferencias') : d.encabezado(2, p.titulo);
      return titulo + d.bloques(p.lineas, { referencias: ref });
    });
    return inicio + partes.join('');
  }).join('');

  // El índice se arma al final, cuando ya se conocen todos los encabezados.
  // Las páginas llegan en el orden del documento, títulos y piezas mezclados: se reparten entre los índices.
  const pagina = new Map((o.paginas || []).map((pg, k) => [`${d.orden[k].clase}:${d.orden[k].i}`, pg]));
  const pagTitulos = d.indice.map((_, i) => pagina.get(`titulo:${i}`));
  const pagPiezas = d.piezas.map((_, i) => pagina.get(`pieza:${i}`));
  const indice = `<w:p><w:pPr><w:pStyle w:val="TituloIndice"/><w:pageBreakBefore/></w:pPr><w:r><w:t>Índice</w:t></w:r></w:p>` + d.indiceXml(pagTitulos) +
    d.listaXml('Tabla', 'Índice de tablas', pagPiezas, true) + d.listaXml('Figura', 'Índice de figuras', pagPiezas, false);

  const ftr = d.relacion('http://schemas.openxmlformats.org/officeDocument/2006/relationships/footer', 'footer1.xml');
  const ftrPortada = d.relacion('http://schemas.openxmlformats.org/officeDocument/2006/relationships/footer', 'footer2.xml');
  const seccion = `<w:sectPr><w:footerReference w:type="default" r:id="${ftr}"/><w:footerReference w:type="first" r:id="${ftrPortada}"/>` +
    `<w:pgSz w:w="${PAGINA.ancho}" w:h="${PAGINA.alto}"/><w:pgMar w:top="${MARGEN}" w:right="${MARGEN}" w:bottom="${MARGEN}" w:left="${MARGEN_IZQ}" w:header="709" w:footer="709" w:gutter="0"/><w:titlePg/></w:sectPr>`;
  const documento = XML + `<w:document ${NS}><w:body>${portada}${indice}${cuerpo}${seccion}</w:body></w:document>`;

  // Ninguna marca de Markdown debe llegar al Word.
  const textos = [...documento.matchAll(/<w:t(?: [^>]*)?>([^<]*)<\/w:t>/g)].map((m) => m[1]);
  const marcas = textos.filter((t) => /\*\*|`|\]\(|^\s*#{1,6}\s|\[\[|<!--|^\s*\|/.test(t.replace(/&lt;/g, '<')));
  if (marcas.length) throw new Error(`El Word conserva marcas de Markdown: ${marcas.slice(0, 5).join(' · ')}`);

  const rels = XML + `<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships">` +
    '<Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles" Target="styles.xml"/>' +
    '<Relationship Id="rId2" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/numbering" Target="numbering.xml"/>' +
    '<Relationship Id="rId3" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/settings" Target="settings.xml"/>' +
    '<Relationship Id="rId4" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/fontTable" Target="fontTable.xml"/>' +
    d.relaciones.map((r) => `<Relationship Id="${r.id}" Type="${r.tipo}" Target="${x(r.destino)}"${r.externo ? ' TargetMode="External"' : ''}/>`).join('') + '</Relationships>';
  const ahora = new Date();
  const iso = ahora.toISOString().replace(/\.\d{3}Z$/, 'Z');
  const archivos = [
    { nombre: '[Content_Types].xml', datos: XML + '<Types xmlns="http://schemas.openxmlformats.org/package/2006/content-types">' +
      '<Default Extension="rels" ContentType="application/vnd.openxmlformats-package.relationships+xml"/><Default Extension="xml" ContentType="application/xml"/>' +
      '<Default Extension="png" ContentType="image/png"/><Default Extension="jpeg" ContentType="image/jpeg"/>' +
      '<Override PartName="/word/document.xml" ContentType="application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml"/>' +
      '<Override PartName="/word/styles.xml" ContentType="application/vnd.openxmlformats-officedocument.wordprocessingml.styles+xml"/>' +
      '<Override PartName="/word/numbering.xml" ContentType="application/vnd.openxmlformats-officedocument.wordprocessingml.numbering+xml"/>' +
      '<Override PartName="/word/settings.xml" ContentType="application/vnd.openxmlformats-officedocument.wordprocessingml.settings+xml"/>' +
      '<Override PartName="/word/fontTable.xml" ContentType="application/vnd.openxmlformats-officedocument.wordprocessingml.fontTable+xml"/>' +
      '<Override PartName="/word/footer1.xml" ContentType="application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml"/>' +
      '<Override PartName="/word/footer2.xml" ContentType="application/vnd.openxmlformats-officedocument.wordprocessingml.footer+xml"/>' +
      '<Override PartName="/docProps/core.xml" ContentType="application/vnd.openxmlformats-package.core-properties+xml"/>' +
      '<Override PartName="/docProps/app.xml" ContentType="application/vnd.openxmlformats-officedocument.extended-properties+xml"/></Types>' },
    { nombre: '_rels/.rels', datos: XML + '<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships">' +
      '<Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument" Target="word/document.xml"/>' +
      '<Relationship Id="rId2" Type="http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties" Target="docProps/core.xml"/>' +
      '<Relationship Id="rId3" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/extended-properties" Target="docProps/app.xml"/></Relationships>' },
    { nombre: 'docProps/core.xml', datos: XML + '<cp:coreProperties xmlns:cp="http://schemas.openxmlformats.org/package/2006/metadata/core-properties" xmlns:dc="http://purl.org/dc/elements/1.1/" xmlns:dcterms="http://purl.org/dc/terms/" xmlns:dcmitype="http://purl.org/dc/dcmitype/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">' +
      `<dc:title>${x(o.titulo)}</dc:title><dc:creator>${x(o.autor)}</dc:creator><dc:language>es-CL</dc:language>` +
      `<dcterms:created xsi:type="dcterms:W3CDTF">${iso}</dcterms:created><dcterms:modified xsi:type="dcterms:W3CDTF">${iso}</dcterms:modified></cp:coreProperties>` },
    { nombre: 'docProps/app.xml', datos: XML + '<Properties xmlns="http://schemas.openxmlformats.org/officeDocument/2006/extended-properties"><Application>Relevo: construir-anexos.js</Application></Properties>' },
    { nombre: 'word/document.xml', datos: documento },
    { nombre: 'word/styles.xml', datos: estilos() },
    { nombre: 'word/numbering.xml', datos: numeracion(d.numeros) },
    { nombre: 'word/settings.xml', datos: ajustes() },
    { nombre: 'word/fontTable.xml', datos: fuentes() },
    { nombre: 'word/footer1.xml', datos: pie() },
    { nombre: 'word/footer2.xml', datos: pieVacio() },
    { nombre: 'word/_rels/document.xml.rels', datos: rels },
    ...d.medios,
  ].map((a) => ({ nombre: a.nombre, datos: Buffer.isBuffer(a.datos) ? a.datos : Buffer.from(a.datos, 'utf8') }));
  fs.writeFileSync(o.salida, zip(archivos, ahora));
  const buscar = d.orden.map((e) => (e.clase === 'titulo' ? d.indice[e.i].texto : `${d.piezas[e.i].rotulo}${d.piezas[e.i].titulo}`));
  return { imagenes: d.medios.length, indice: d.indice.map((e) => e.texto), buscar, tablas: d.piezas.filter((p) => p.tipo === 'Tabla').length, figuras: d.piezas.filter((p) => p.tipo === 'Figura').length, peso: fs.statSync(o.salida).size };
}

module.exports = { construirWord, tramos };
