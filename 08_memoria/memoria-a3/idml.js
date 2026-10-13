// Escritor mínimo de IDML (InDesign Markup Language): el formato de intercambio que abren InDesign y
// Affinity. Crea estilos de párrafo y de carácter, colores, capas, una página maestra con el folio,
// páginas con marcos de texto enlazados, marcos de imagen o PDF vinculados, rectángulos y tablas.
// Las medidas de entrada van en milímetros; IDML usa puntos.

const fs = require('fs');
const path = require('path');
const zlib = require('zlib');

const PT = 72 / 25.4;
const pt = (mm) => Math.round(mm * PT * 1000) / 1000;
const x = (s) => String(s).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
const NS = 'xmlns:idPkg="http://ns.adobe.com/AdobeInDesign/idml/1.0/packaging" DOMVersion="18.0"';
const XMLHEAD = '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>\n';

// ---------------------------------------------------------------- ZIP

const CRC = (() => { const t = new Int32Array(256); for (let n = 0; n < 256; n++) { let c = n; for (let k = 0; k < 8; k++) c = c & 1 ? 0xEDB88320 ^ (c >>> 1) : c >>> 1; t[n] = c; } return t; })();
const crc32 = (b) => { let c = -1; for (let i = 0; i < b.length; i++) c = CRC[(c ^ b[i]) & 255] ^ (c >>> 8); return (c ^ -1) >>> 0; };

const FECHA = (() => { const f = new Date(); return { t: (f.getHours() << 11) | (f.getMinutes() << 5) | (f.getSeconds() >> 1), d: ((f.getFullYear() - 1980) << 9) | ((f.getMonth() + 1) << 5) | f.getDate() }; })();

function zip(entries) {
  const partes = []; const central = []; let off = 0;
  for (const { name, data, store } of entries) {
    const nombre = Buffer.from(name, 'utf8');
    const crc = crc32(data);
    const comp = store ? data : zlib.deflateRawSync(data, { level: 9 });
    const lh = Buffer.alloc(30);
    lh.writeUInt32LE(0x04034b50, 0); lh.writeUInt16LE(20, 4); lh.writeUInt16LE(0x0800, 6); lh.writeUInt16LE(store ? 0 : 8, 8);
    lh.writeUInt16LE(FECHA.t, 10); lh.writeUInt16LE(FECHA.d, 12); lh.writeUInt32LE(crc, 14); lh.writeUInt32LE(comp.length, 18); lh.writeUInt32LE(data.length, 22);
    lh.writeUInt16LE(nombre.length, 26); lh.writeUInt16LE(0, 28);
    partes.push(lh, nombre, comp);
    const ch = Buffer.alloc(46);
    ch.writeUInt32LE(0x02014b50, 0); ch.writeUInt16LE(20, 4); ch.writeUInt16LE(20, 6); ch.writeUInt16LE(0x0800, 8); ch.writeUInt16LE(store ? 0 : 8, 10);
    ch.writeUInt16LE(FECHA.t, 12); ch.writeUInt16LE(FECHA.d, 14); ch.writeUInt32LE(crc, 16); ch.writeUInt32LE(comp.length, 20); ch.writeUInt32LE(data.length, 24);
    ch.writeUInt16LE(nombre.length, 28); ch.writeUInt32LE(off, 42);
    central.push(ch, nombre);
    off += 30 + nombre.length + comp.length;
  }
  const cd = Buffer.concat(central);
  const fin = Buffer.alloc(22);
  fin.writeUInt32LE(0x06054b50, 0); fin.writeUInt16LE(entries.length, 8); fin.writeUInt16LE(entries.length, 10);
  fin.writeUInt32LE(cd.length, 12); fin.writeUInt32LE(off, 16);
  return Buffer.concat([...partes, cd, fin]);
}

// ---------------------------------------------------------------- Medidas de archivos vinculados

function medidas(archivo) {
  const b = fs.readFileSync(archivo);
  if (b.readUInt32BE(0) === 0x89504e47) return { w: b.readUInt32BE(16), h: b.readUInt32BE(20), tipo: 'PNG' };
  if (b[0] === 0xff && b[1] === 0xd8) {
    let i = 2;
    while (i < b.length) {
      if (b[i] !== 0xff) { i++; continue; }
      const m = b[i + 1]; const len = b.readUInt16BE(i + 2);
      if (m >= 0xc0 && m <= 0xcf && ![0xc4, 0xc8, 0xcc].includes(m)) return { w: b.readUInt16BE(i + 7), h: b.readUInt16BE(i + 5), tipo: 'JPEG' };
      i += 2 + len;
    }
  }
  const s = b.toString('latin1');
  const mb = s.match(/\/MediaBox\s*\[\s*([\d.]+)\s+([\d.]+)\s+([\d.]+)\s+([\d.]+)\s*\]/);
  if (s.startsWith('%PDF') && mb) return { w: +mb[3] - +mb[1], h: +mb[4] - +mb[2], tipo: 'PDF' };
  throw new Error('Formato no reconocido: ' + archivo);
}

const uri = (archivo) => 'file:' + path.resolve(archivo).replace(/\\/g, '/').split('/').map((p, i) => (i === 0 ? p : encodeURIComponent(p))).join('/');

// ---------------------------------------------------------------- Documento

class Idml {
  constructor({ ancho, alto, sangrado = 3, margenes, columnas = 1, medianil = 5 }) {
    Object.assign(this, { ancho, alto, sangrado, margenes, columnas, medianil });
    this.colores = []; this.pStyles = []; this.cStyles = []; this.historias = []; this.paginas = []; this.maestra = [];
    this.capas = ['Papel', 'Imágenes', 'Texto', 'Folios'];
    this.n = 0;
  }
  id(p = 'u') { return p + (++this.n).toString(16); }
  color(nombre, rgb) { this.colores.push({ nombre, rgb }); return `Color/${nombre}`; }
  parrafo(nombre, props) { this.pStyles.push({ nombre, props }); }
  caracter(nombre, props) { this.cStyles.push({ nombre, props }); }
  // Historia: lista de párrafos { estilo, partes: [{ texto, estilo? }] } o { tabla }.
  historia(parrafos) { const id = this.id('st'); this.historias.push({ id, parrafos }); return id; }
  pagina(items) { this.paginas.push(items); }

  // -------- XML de estilos
  propsXml(p) {
    const a = []; const props = [];
    const map = {
      tamano: 'PointSize', estilo: 'FontStyle', color: 'FillColor', antes: 'SpaceBefore', despues: 'SpaceAfter',
      sangria: 'LeftIndent', primera: 'FirstLineIndent', derecha: 'RightIndent', alineacion: 'Justification', seguimiento: 'Tracking',
      conSiguiente: 'KeepWithNext', primeras: 'KeepFirstLines', ultimas: 'KeepLastLines', juntas: 'KeepLinesTogether', todas: 'KeepAllLinesTogether',
      empieza: 'StartParagraph', cifras: 'OTFFigureStyle', subrayado: 'Underline', subColor: 'UnderlineColor', subGrosor: 'UnderlineWeight', subDesplaz: 'UnderlineOffset',
      reglaArriba: 'RuleAbove', reglaArribaGrosor: 'RuleAboveLineWeight', reglaArribaColor: 'RuleAboveColor', reglaArribaDesplaz: 'RuleAboveOffset', reglaArribaAncho: 'RuleAboveWidth',
      reglaArribaFin: 'RuleAboveRightIndent', guiones: 'Hyphenation', idioma: 'AppliedLanguage', ligaduras: 'Ligatures',
    };
    for (const [k, v] of Object.entries(p)) {
      if (k === 'interlineado') props.push(`<Leading type="unit">${v}</Leading>`);
      else if (k === 'letra') props.push(`<AppliedFont type="string">${x(v)}</AppliedFont>`);
      else if (k === 'base') props.push(`<BasedOn type="object">${x(v)}</BasedOn>`);
      else if (k === 'tabs') props.push(`<TabList type="list">${v.map((t) => `<ListItem type="record"><Alignment type="enumeration">${t.alin || 'LeftAlign'}</Alignment><AlignmentCharacter type="string">.</AlignmentCharacter><Leader type="string"></Leader><Position type="unit">${t.pos}</Position></ListItem>`).join('')}</TabList>`);
      else if (k === 'sigueEstilo') props.push(`<NextStyle type="object">ParagraphStyle/${x(v)}</NextStyle>`);
      else if (map[k]) a.push(`${map[k]}="${x(v)}"`);
      else throw new Error('Propiedad desconocida: ' + k);
    }
    return { attrs: a.join(' '), props: props.join('') };
  }

  stylesXml() {
    const ps = this.pStyles.map(({ nombre, props }) => {
      const { attrs, props: pr } = this.propsXml({ base: 'ParagraphStyle/$ID/NormalParagraphStyle', ...props });
      return `<ParagraphStyle Self="ParagraphStyle/${x(nombre)}" Name="${x(nombre)}" Imported="false" ${attrs}><Properties>${pr}</Properties></ParagraphStyle>`;
    }).join('\n');
    const cs = this.cStyles.map(({ nombre, props }) => {
      const { attrs, props: pr } = this.propsXml(props);
      return `<CharacterStyle Self="CharacterStyle/${x(nombre)}" Name="${x(nombre)}" Imported="false" ${attrs}><Properties>${pr}</Properties></CharacterStyle>`;
    }).join('\n');
    return XMLHEAD + `<idPkg:Styles ${NS}>
<RootCharacterStyleGroup Self="u79"><CharacterStyle Self="CharacterStyle/$ID/[No character style]" Imported="false" Name="$ID/[No character style]"/>
${cs}
</RootCharacterStyleGroup>
<RootParagraphStyleGroup Self="u78"><ParagraphStyle Self="ParagraphStyle/$ID/[No paragraph style]" Name="$ID/[No paragraph style]" Imported="false"/>
<ParagraphStyle Self="ParagraphStyle/$ID/NormalParagraphStyle" Name="$ID/NormalParagraphStyle" Imported="false" PointSize="11" FontStyle="Regular" FillColor="Color/Tinta" Hyphenation="false" KeepLinesTogether="true" KeepFirstLines="2" KeepLastLines="2"><Properties><BasedOn type="object">ParagraphStyle/$ID/[No paragraph style]</BasedOn><AppliedFont type="string">Instrument Sans</AppliedFont><Leading type="unit">15</Leading></Properties></ParagraphStyle>
${ps}
</RootParagraphStyleGroup>
<RootCellStyleGroup Self="u8a"><CellStyle Self="CellStyle/$ID/[None]" Name="$ID/[None]" AppliedParagraphStyle="ParagraphStyle/$ID/[No paragraph style]"/></RootCellStyleGroup>
<RootTableStyleGroup Self="u8c"><TableStyle Self="TableStyle/$ID/[No table style]" Name="$ID/[No table style]"/><TableStyle Self="TableStyle/$ID/[Basic Table]" Name="$ID/[Basic Table]"/></RootTableStyleGroup>
<RootObjectStyleGroup Self="u93"><ObjectStyle Self="ObjectStyle/$ID/[None]" Name="$ID/[None]"/><ObjectStyle Self="ObjectStyle/$ID/[Normal Graphics Frame]" Name="$ID/[Normal Graphics Frame]"/><ObjectStyle Self="ObjectStyle/$ID/[Normal Text Frame]" Name="$ID/[Normal Text Frame]"/><ObjectStyle Self="ObjectStyle/$ID/[Normal Grid]" Name="$ID/[Normal Grid]"/></RootObjectStyleGroup>
</idPkg:Styles>`;
  }

  graphicXml() {
    const cs = this.colores.map(({ nombre, rgb }) => `<Color Self="Color/${x(nombre)}" Model="Process" Space="RGB" ColorValue="${rgb.join(' ')}" ColorOverride="Normal" AlternateSpace="NoAlternateColor" AlternateColorValue="" Name="${x(nombre)}" ColorEditable="true" ColorRemovable="true" Visible="true" SwatchCreatorID="7937"/>`).join('\n');
    return XMLHEAD + `<idPkg:Graphic ${NS}>
<Color Self="Color/Black" Model="Process" Space="CMYK" ColorValue="0 0 0 100" ColorOverride="Specialblack" AlternateSpace="NoAlternateColor" AlternateColorValue="" Name="Black" ColorEditable="false" ColorRemovable="false" Visible="true" SwatchCreatorID="7937"/>
<Color Self="Color/Paper" Model="Process" Space="CMYK" ColorValue="0 0 0 0" ColorOverride="Specialpaper" AlternateSpace="NoAlternateColor" AlternateColorValue="" Name="Paper" ColorEditable="true" ColorRemovable="false" Visible="true" SwatchCreatorID="7937"/>
<Color Self="Color/Registration" Model="Registration" Space="CMYK" ColorValue="100 100 100 100" ColorOverride="Specialregistration" AlternateSpace="NoAlternateColor" AlternateColorValue="" Name="Registration" ColorEditable="false" ColorRemovable="false" Visible="true" SwatchCreatorID="7937"/>
${cs}
<Swatch Self="Swatch/None" Name="None" ColorEditable="false" ColorRemovable="false" Visible="true" SwatchCreatorID="7937"/>
<StrokeStyle Self="StrokeStyle/$ID/Solid" Name="$ID/Solid"/>
<StrokeStyle Self="StrokeStyle/$ID/Dashed" Name="$ID/Dashed"/>
</idPkg:Graphic>`;
  }

  // -------- Historias
  runs(partes) {
    return partes.map((r) => {
      const cs = r.estilo ? `CharacterStyle/${x(r.estilo)}` : 'CharacterStyle/$ID/[No character style]';
      const contenido = r.folio ? '<Content><?ACE 18?></Content>' : `<Content>${x(r.texto)}</Content>`;
      return `<CharacterStyleRange AppliedCharacterStyle="${cs}">${contenido}`;
    });
  }
  tablaXml(t) {
    const id = this.id('tb'); const filas = t.filas.length; const cols = t.anchos.length;
    const col = t.anchos.map((w, i) => `<Column Self="${id}c${i}" Name="${i}" SingleColumnWidth="${pt(w)}"/>`).join('');
    const row = t.filas.map((_, i) => `<Row Self="${id}r${i}" Name="${i}" SingleRowHeight="${t.altos ? t.altos[i] : 12}" MinimumHeight="${t.altos ? t.altos[i] : 12}" AutoGrow="true"/>`).join('');
    const borde = (lado, grosor, color) => `${lado}EdgeStrokeWeight="${grosor}" ${lado}EdgeStrokeColor="${grosor ? color : 'Swatch/None'}" ${lado}EdgeStrokeType="StrokeStyle/$ID/Solid" ${lado}EdgeStrokeTint="100"`;
    const celdas = [];
    t.filas.forEach((f, r) => f.forEach((c, k) => {
      const cab = r === 0; const ult = r === filas - 1;
      const top = cab ? borde('Top', t.reglaFuerte, t.tinta) : borde('Top', t.reglaFina, t.linea);
      const bot = cab ? borde('Bottom', t.reglaMedia, t.tinta) : ult ? borde('Bottom', t.reglaMedia, t.tinta) : borde('Bottom', t.reglaFina, t.linea);
      const ins = `TopInset="${t.relleno[0]}" BottomInset="${t.relleno[1]}" LeftInset="${k === 0 ? 0 : t.relleno[2]}" RightInset="${k === cols - 1 ? 0 : t.relleno[2]}"`;
      const estilo = cab ? t.estiloCab : k === 0 ? t.estiloPrimera : t.estiloCelda;
      const alin = t.numericas && t.numericas[k] ? ' Justification="RightAlign"' : '';
      celdas.push(`<Cell Self="${id}i${k}_${r}" Name="${k}:${r}" RowSpan="1" ColumnSpan="1" AppliedCellStyle="CellStyle/$ID/[None]" FillColor="Swatch/None" VerticalJustification="${t.vertical || 'TopAlign'}" ${ins} ${top} ${bot} ${borde('Left', 0)} ${borde('Right', 0)}>` +
        `<ParagraphStyleRange AppliedParagraphStyle="ParagraphStyle/${x(estilo)}"${alin}>${this.runs(c).map((s) => s + '</CharacterStyleRange>').join('')}</ParagraphStyleRange></Cell>`);
    }));
    return `<Table Self="${id}" HeaderRowCount="1" FooterRowCount="0" BodyRowCount="${filas - 1}" ColumnCount="${cols}" AppliedTableStyle="TableStyle/$ID/[Basic Table]" TableDirection="LeftToRightDirection" ` +
      `TopBorderStrokeWeight="${t.reglaFuerte}" TopBorderStrokeColor="${t.tinta}" BottomBorderStrokeWeight="${t.reglaMedia}" BottomBorderStrokeColor="${t.tinta}" LeftBorderStrokeWeight="0" RightBorderStrokeWeight="0" LeftBorderStrokeColor="Swatch/None" RightBorderStrokeColor="Swatch/None" ` +
      `StartRowFillCount="0" EndRowFillCount="0" StartColumnFillCount="0" EndColumnFillCount="0" StartRowStrokeCount="0" EndRowStrokeCount="0" StartColumnStrokeCount="0" EndColumnStrokeCount="0">${row}${col}${celdas.join('')}</Table>`;
  }
  storyXml({ id, parrafos }) {
    const ps = parrafos.map((p, i) => {
      const fin = i < parrafos.length - 1 ? '<Br/>' : '';
      if (p.tabla) return `<ParagraphStyleRange AppliedParagraphStyle="ParagraphStyle/${x(p.estilo)}"><CharacterStyleRange AppliedCharacterStyle="CharacterStyle/$ID/[No character style]">${this.tablaXml(p.tabla)}${fin}</CharacterStyleRange></ParagraphStyleRange>`;
      const rs = this.runs(p.partes.length ? p.partes : [{ texto: '' }]);
      return `<ParagraphStyleRange AppliedParagraphStyle="ParagraphStyle/${x(p.estilo)}">${rs.map((s, k) => s + (k === rs.length - 1 ? fin : '') + '</CharacterStyleRange>').join('')}</ParagraphStyleRange>`;
    }).join('\n');
    return XMLHEAD + `<idPkg:Story ${NS}><Story Self="${id}" AppliedTOCStyle="n" UserText="true" IsEndnoteStory="false" TrackChanges="false" StoryTitle="$ID/" AppliedNamedGrid="n">` +
      `<StoryPreference OpticalMarginAlignment="false" OpticalMarginSize="12" FrameType="TextFrameType" StoryOrientation="Horizontal" StoryDirection="LeftToRightDirection"/>` +
      `<InCopyExportOption IncludeGraphicProxies="true" IncludeAllResources="false"/>\n${ps}\n</Story></idPkg:Story>`;
  }

  // -------- Elementos de página (coordenadas del pliego: x desde el borde izquierdo, y desde el centro)
  geom([x0, y0, w, h]) {
    const X0 = pt(x0), X1 = pt(x0 + w), Y0 = pt(y0) - pt(this.alto) / 2, Y1 = pt(y0 + h) - pt(this.alto) / 2;
    const p = (a, b) => `<PathPointType Anchor="${a} ${b}" LeftDirection="${a} ${b}" RightDirection="${a} ${b}"/>`;
    return { xml: `<Properties><PathGeometry><GeometryPathType PathOpen="false"><PathPointArray>${p(X0, Y0)}${p(X0, Y1)}${p(X1, Y1)}${p(X1, Y0)}</PathPointArray></GeometryPathType></PathGeometry></Properties>`, X0, Y0, X1, Y1 };
  }
  capa(nombre) { return 'uL' + (this.capas.indexOf(nombre) + 1); }
  itemXml(it, marcos) {
    const g = this.geom(it.rect);
    const capa = this.capa(it.capa || (it.tipo === 'texto' ? 'Texto' : it.tipo === 'imagen' ? 'Imágenes' : 'Papel'));
    if (it.tipo === 'texto') {
      const m = marcos.get(it); const cols = it.columnas || 1;
      return `<TextFrame Self="${m.id}" ParentStory="${it.historia}" PreviousTextFrame="${m.prev || 'n'}" NextTextFrame="${m.next || 'n'}" ContentType="TextType" AppliedObjectStyle="ObjectStyle/$ID/[Normal Text Frame]" ItemLayer="${capa}" Visible="true" Name="${x(it.nombre || '$ID/')}" ItemTransform="1 0 0 1 0 0" FillColor="Swatch/None" StrokeColor="Swatch/None" StrokeWeight="0">${g.xml}` +
        `<TextFramePreference TextColumnCount="${cols}" TextColumnGutter="${pt(it.medianil || this.medianil)}" UseFixedColumnWidth="false" FirstBaselineOffset="${it.primeraLinea || 'AscentOffset'}" VerticalJustification="${it.vertical || 'TopAlign'}" VerticalBalanceColumns="${it.equilibrar ? 'true' : 'false'}" AutoSizingType="Off" IgnoreWrap="false" InsetSpacing="0 0 0 0"/></TextFrame>`;
    }
    if (it.tipo === 'rect') {
      return `<Rectangle Self="${this.id('r')}" ContentType="Unassigned" AppliedObjectStyle="ObjectStyle/$ID/[None]" ItemLayer="${capa}" Visible="true" Name="${x(it.nombre || '$ID/')}" ItemTransform="1 0 0 1 0 0" FillColor="${it.relleno || 'Swatch/None'}" StrokeColor="${it.borde || 'Swatch/None'}" StrokeWeight="${it.grosor || 0}" StrokeType="${it.discontinuo ? 'StrokeStyle/$ID/Dashed' : 'StrokeStyle/$ID/Solid'}" CornerRadius="${pt(it.radio || 0)}" TopLeftCornerOption="${it.radio ? 'RoundedCorner' : 'None'}" TopRightCornerOption="${it.radio ? 'RoundedCorner' : 'None'}" BottomLeftCornerOption="${it.radio ? 'RoundedCorner' : 'None'}" BottomRightCornerOption="${it.radio ? 'RoundedCorner' : 'None'}" TopLeftCornerRadius="${pt(it.radio || 0)}" TopRightCornerRadius="${pt(it.radio || 0)}" BottomLeftCornerRadius="${pt(it.radio || 0)}" BottomRightCornerRadius="${pt(it.radio || 0)}">${g.xml}</Rectangle>`;
    }
    if (it.tipo === 'imagen') {
      const md = medidas(it.archivo);
      const w = g.X1 - g.X0, h = g.Y1 - g.Y0;
      const s = it.ajuste === 'contener' ? Math.min(w / md.w, h / md.h) : Math.max(w / md.w, h / md.h);
      const tx = g.X0 + (w - md.w * s) / 2, ty = g.Y0 + (it.ajuste === 'contener' ? 0 : (h - md.h * s) / 2);
      const pdf = md.tipo === 'PDF';
      const tag = pdf ? 'PDF' : 'Image';
      const fmt = pdf ? '$ID/Adobe Portable Document Format (PDF)' : `$ID/${md.tipo}`;
      const extra = pdf ? '<PDFAttribute PageNumber="1" PDFCrop="CropMedia" TransparentBackground="true"/>' : '';
      return `<Rectangle Self="${this.id('r')}" ContentType="GraphicType" AppliedObjectStyle="ObjectStyle/$ID/[Normal Graphics Frame]" ItemLayer="${capa}" Visible="true" Name="${x(it.nombre || '$ID/')}" ItemTransform="1 0 0 1 0 0" FillColor="Swatch/None" StrokeColor="Swatch/None" StrokeWeight="0">${g.xml}` +
        `<FrameFittingOption AutoFit="false" FittingOnEmptyFrame="${it.ajuste === 'contener' ? 'Proportionally' : 'FillProportionally'}" FittingAlignment="CenterAnchor"/>` +
        `<${tag} Self="${this.id('g')}" ItemTransform="${s} 0 0 ${s} ${tx} ${ty}"><Properties><Profile type="string">$ID/None</Profile><GraphicBounds Left="0" Top="0" Right="${md.w}" Bottom="${md.h}"/></Properties>${extra}` +
        `<Link Self="${this.id('lk')}" AssetURL="$ID/" AssetID="$ID/" LinkResourceURI="${x(uri(it.archivo))}" LinkResourceFormat="${fmt}" StoredState="Normal" LinkClassID="35906" LinkClientID="257" LinkResourceModified="false" LinkObjectModified="false" ShowInUI="true" CanEmbed="true" CanUnembed="true" CanPackage="true" ImportPolicy="NoAutoImport" ExportPolicy="NoAutoExport" LinkImportStamp="file 0 0" LinkImportModificationTime="2026-10-12T00:00:00" LinkImportTime="2026-10-12T00:00:00" LinkResourceSize="0~0"/></${tag}></Rectangle>`;
    }
    throw new Error('Tipo de elemento desconocido: ' + it.tipo);
  }
  pageXml(id, nombre, master) {
    const m = this.margenes;
    return `<Page Self="${id}" Name="${nombre}" AppliedMaster="${master || 'n'}" GeometricBounds="0 0 ${pt(this.alto)} ${pt(this.ancho)}" ItemTransform="1 0 0 1 0 ${-pt(this.alto) / 2}" MasterPageTransform="1 0 0 1 0 0" OverrideList="" TabOrder="" GridStartingPoint="TopOutside" UseMasterGrid="true">` +
      `<Properties><PageColor type="enumeration">UseMasterColor</PageColor></Properties>` +
      `<MarginPreference ColumnCount="${this.columnas}" ColumnGutter="${pt(this.medianil)}" Top="${pt(m[0])}" Bottom="${pt(m[2])}" Left="${pt(m[3])}" Right="${pt(m[1])}" ColumnDirection="Horizontal" ColumnsPositions="${this.posColumnas()}"/></Page>`;
  }
  posColumnas() {
    const m = this.margenes; const util = pt(this.ancho - m[1] - m[3]); const g = pt(this.medianil); const c = (util - g * (this.columnas - 1)) / this.columnas;
    const out = [0]; for (let i = 0; i < this.columnas; i++) { if (i) out.push(out[out.length - 1] + g); out.push(out[out.length - 1] + c); }
    return out.map((v) => Math.round(v * 1000) / 1000).join(' ');
  }

  escribir(salida) {
    // Enlaces entre marcos: cada historia recorre sus marcos en el orden de las páginas.
    const marcos = new Map(); const porHistoria = new Map();
    const todos = [...this.maestra, ...this.paginas.flat()];
    for (const it of todos) if (it.tipo === 'texto') {
      const m = { id: this.id('tf') }; marcos.set(it, m);
      if (!porHistoria.has(it.historia)) porHistoria.set(it.historia, []);
      porHistoria.get(it.historia).push(m);
    }
    for (const lista of porHistoria.values()) lista.forEach((m, i) => { m.prev = lista[i - 1] && lista[i - 1].id; m.next = lista[i + 1] && lista[i + 1].id; });

    const archivos = [];
    archivos.push({ name: 'mimetype', data: Buffer.from('application/vnd.adobe.indesign-idml-package'), store: true });
    archivos.push({ name: 'META-INF/container.xml', data: Buffer.from(XMLHEAD + '<container version="1.0" xmlns="urn:oasis:names:tc:opendocument:xmlns:container"><rootfiles><rootfile full-path="designmap.xml" media-type="text/xml"/></rootfiles></container>') });
    archivos.push({ name: 'Resources/Graphic.xml', data: Buffer.from(this.graphicXml()) });
    archivos.push({ name: 'Resources/Styles.xml', data: Buffer.from(this.stylesXml()) });
    archivos.push({ name: 'Resources/Fonts.xml', data: Buffer.from(XMLHEAD + `<idPkg:Fonts ${NS}><FontFamily Self="di1" Name="Instrument Sans">` +
      ['Regular', 'Medium', 'SemiBold', 'Bold', 'Italic', 'Medium Italic', 'SemiBold Italic', 'Bold Italic'].map((s, i) => `<Font Self="di1f${i}" FontFamily="Instrument Sans" Name="Instrument Sans ${s}" PostScriptName="$ID/InstrumentSans-${s.replace(/ /g, '')}" Status="Installed" FontStyleName="${s}" FontType="OpenTypeTT" WritingScript="0" FullName="Instrument Sans ${s}" FullNameNative="Instrument Sans ${s}" FontStyleNameNative="${s}" PlatformName="$ID/" Version="1.0"/>`).join('') +
      `</FontFamily></idPkg:Fonts>`) });
    const m = this.margenes; const b = pt(this.sangrado);
    archivos.push({ name: 'Resources/Preferences.xml', data: Buffer.from(XMLHEAD + `<idPkg:Preferences ${NS}>` +
      `<DocumentPreference PageHeight="${pt(this.alto)}" PageWidth="${pt(this.ancho)}" PagesPerDocument="${this.paginas.length}" FacingPages="false" DocumentBleedTopOffset="${b}" DocumentBleedBottomOffset="${b}" DocumentBleedInsideOrLeftOffset="${b}" DocumentBleedOutsideOrRightOffset="${b}" DocumentBleedUniformSize="true" SlugTopOffset="0" SlugBottomOffset="0" SlugInsideOrLeftOffset="0" SlugRightOrOutsideOffset="0" DocumentSlugUniformSize="false" PreserveLayoutWhenShuffling="true" AllowPageShuffle="true" OverprintBlack="true" PageBinding="LeftToRight" ColumnDirection="Horizontal" ColumnGuideLocked="true" MasterTextFrame="false" SnippetImportUsesOriginalLocation="false" Intent="PrintIntent"/>` +
      `<MarginPreference ColumnCount="${this.columnas}" ColumnGutter="${pt(this.medianil)}" Top="${pt(m[0])}" Bottom="${pt(m[2])}" Left="${pt(m[3])}" Right="${pt(m[1])}" ColumnDirection="Horizontal" ColumnsPositions="${this.posColumnas()}"/>` +
      `<ViewPreference HorizontalMeasurementUnits="Millimeters" VerticalMeasurementUnits="Millimeters" RulerOrigin="PageOrigin"/>` +
      `</idPkg:Preferences>`) });
    archivos.push({ name: 'XML/Tags.xml', data: Buffer.from(XMLHEAD + `<idPkg:Tags ${NS}><XMLTag Self="XMLTag/Root" Name="Root"><Properties><TagColor type="enumeration">LightBlue</TagColor></Properties></XMLTag></idPkg:Tags>`) });
    archivos.push({ name: 'XML/BackingStory.xml', data: Buffer.from(XMLHEAD + `<idPkg:BackingStory ${NS}><XmlStory Self="ubs" AppliedTOCStyle="n" UserText="true" IsEndnoteStory="false" TrackChanges="false" StoryTitle="$ID/" AppliedNamedGrid="n"><ParagraphStyleRange AppliedParagraphStyle="ParagraphStyle/$ID/NormalParagraphStyle"><CharacterStyleRange AppliedCharacterStyle="CharacterStyle/$ID/[No character style]"/></ParagraphStyleRange></XmlStory></idPkg:BackingStory>`) });

    // Maestra
    const mi = this.maestra.map((it) => this.itemXml(it, marcos)).join('\n');
    archivos.push({ name: 'MasterSpreads/MasterSpread_uMA.xml', data: Buffer.from(XMLHEAD + `<idPkg:MasterSpread ${NS}><MasterSpread Self="uMA" Name="A-Página" NamePrefix="A" BaseName="Página" ShowMasterItems="true" PageCount="1" OverriddenPageItemProps="" ItemTransform="1 0 0 1 0 0" PrimaryTextFrame="n"><Properties><PageColor type="enumeration">UseMasterColor</PageColor></Properties>` +
      this.pageXml('uMAp', 'A', null) + mi + `</MasterSpread></idPkg:MasterSpread>`) });

    // Pliegos
    const spreads = [];
    this.paginas.forEach((items, i) => {
      const sid = `sp${i + 1}`; const pid = `pg${i + 1}`;
      const xml = XMLHEAD + `<idPkg:Spread ${NS}><Spread Self="${sid}" PageCount="1" BindingLocation="0" AllowPageShuffle="true" ItemTransform="1 0 0 1 0 0" ShowMasterItems="true" PageTransitionType="None" PageTransitionDirection="NotApplicable" PageTransitionDuration="Medium" FlattenerOverride="Default">` +
        this.pageXml(pid, String(i + 1), items.sinMaestra ? 'n' : 'uMA') + items.map((it) => this.itemXml(it, marcos)).join('\n') + `</Spread></idPkg:Spread>`;
      archivos.push({ name: `Spreads/Spread_${sid}.xml`, data: Buffer.from(xml) });
      spreads.push(sid);
    });
    for (const h of this.historias) archivos.push({ name: `Stories/Story_${h.id}.xml`, data: Buffer.from(this.storyXml(h)) });

    const capas = this.capas.map((c, i) => `<Layer Self="uL${i + 1}" Name="${x(c)}" Visible="true" Locked="${c === 'Papel' ? 'true' : 'false'}" IgnoreWrap="false" ShowGuides="true" LockGuides="false" UI="true" Expendable="true" Printable="true"><Properties><LayerColor type="enumeration">${['Gray', 'LightBlue', 'Red', 'Green'][i]}</LayerColor></Properties></Layer>`).join('');
    const design = XMLHEAD + `<?aid style="50" type="document" readerVersion="6.0" featureSet="257" product="18.0(51)" ?>\n` +
      `<Document ${NS} Self="d" StoryList="${this.historias.map((h) => h.id).join(' ')}" Name="memoria.indd" ZeroPoint="0 0" ActiveLayer="uL3" CMYKProfile="Coated FOGRA39 (ISO 12647-2:2004)" RGBProfile="sRGB IEC61966-2.1" SolidColorIntent="UseColorSettings" AfterBlendingIntent="UseColorSettings" DefaultImageIntent="UseColorSettings" RGBPolicy="PreserveEmbeddedProfiles" CMYKPolicy="CombinationOfPreserveAndSafeCmyk" AccurateLABSpots="false">\n` +
      `<idPkg:Graphic src="Resources/Graphic.xml"/>\n<idPkg:Fonts src="Resources/Fonts.xml"/>\n<idPkg:Styles src="Resources/Styles.xml"/>\n<idPkg:Preferences src="Resources/Preferences.xml"/>\n<idPkg:Tags src="XML/Tags.xml"/>\n${capas}\n` +
      `<idPkg:MasterSpread src="MasterSpreads/MasterSpread_uMA.xml"/>\n${spreads.map((s) => `<idPkg:Spread src="Spreads/Spread_${s}.xml"/>`).join('\n')}\n` +
      `<Section Self="uSec" Length="${this.paginas.length}" Name="" ComponentName="" AlternateLayoutLength="${this.paginas.length}" AlternateLayout="" IncludeSectionPrefix="false" Marker="" PageStart="pg1" SectionPrefix="" PageNumberStyle="Arabic" ContinueNumbering="true" PageNumberStart="1"/>\n` +
      `<idPkg:BackingStory src="XML/BackingStory.xml"/>\n${this.historias.map((h) => `<idPkg:Story src="Stories/Story_${h.id}.xml"/>`).join('\n')}\n</Document>`;
    archivos.splice(1, 0, { name: 'designmap.xml', data: Buffer.from(design) });
    fs.writeFileSync(salida, zip(archivos));
  }
}

module.exports = { Idml, medidas, pt };
