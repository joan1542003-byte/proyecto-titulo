// Reúne las candidatas display de todas las fuentes (archivos ya bajados) en una sola lista para la mesa de análisis.
const fs = require('fs');
const os = require('os');
const RF = require('path').join(os.tmpdir(), 'rf').split(require('path').sep).join('/');
const leer = (f) => JSON.parse(fs.readFileSync(f, 'utf8'));
const l75 = Object.fromEntries(leer('le75/items-l75.json').map((x) => [x.id, x]));
const nw = Object.fromEntries(leer('dl/items-nw.json').map((x) => [x.id, x]));
const un = Object.fromEntries(leer('../v38/uncut/items.json').map((x) => [x.id.split('/')[1], x]));
const web = leer('web-archivos.json');

// [clave, origen, nombre, grupo]
const PEDIDAS = [
  ['nw:struggle', 'Klotter Supply', 'Struggle', 'Pastilla'],
  ['nw:lobular', 'Tunera', 'Lobular', 'Pastilla'],
  ['vw:pilowlava', 'Velvetyne', 'Pilowlava', 'Pastilla'],
  ['vw:combat', 'Velvetyne', 'Combat', 'Pastilla'],
  ['l75:touillette', 'Le75', 'Touillette', 'Pastilla'],
  ['l75:revival', 'Le75', 'Revival', 'Pastilla'],
  ['vw:mourier', 'Velvetyne', 'Mourier', 'Traspaso'],
  ['vw:hyper-scrypt', 'Velvetyne', 'Hyper Scrypt', 'Traspaso'],
  ['fk:kohinoor-zerone-200', 'Fontshare', 'Kohinoor Zerone', 'Traspaso'],
  ['fk:sharpie', 'Fontshare', 'Sharpie', 'Traspaso'],
  ['nw:azabache', 'Tunera', 'Azabache', 'Traspaso'],
  ['l75:lacollective', 'Le75', 'Lacollective', 'Traspaso'],
  ['l75:ductus', 'Le75', 'Ductus', 'Traspaso'],
  ['vw:trickster', 'Velvetyne', 'Trickster', 'Traspaso'],
  ['vw:typefesse', 'Velvetyne', 'Typefesse', 'Traspaso'],
  ['l75:marion', 'Le75', 'Marion', 'Traspaso'],
  ['nw:manosque', 'Tunera', 'Manosque', 'Lugar'],
  ['nw:patriot', 'Republish', 'Patriot', 'Lugar'],
  ['nw:barber', 'Republish', 'Barber', 'Lugar'],
  ['nw:westgate', 'Republish', 'Westgate', 'Lugar'],
  ['nw:danhda', 'Republish', 'Danhda', 'Lugar'],
  ['nw:blackout', 'The League of Moveable Type', 'Blackout', 'Lugar'],
  ['nw:chunk', 'The League of Moveable Type', 'Chunk', 'Lugar'],
  ['nw:choso', 'Tunera', 'Choso', 'Lugar'],
  ['nw:roubaix', 'Tunera', 'Roubaix Industrielle', 'Lugar'],
  ['un:cat-neuzeit', 'UNCUT', 'CAT Neuzeit', 'Lugar'],
  ['nw:ampoule', 'Tunera', 'Ampoule', 'Señal'],
  ['un:phosphene', 'UNCUT', 'Phosphène', 'Señal'],
  ['l75:linea', 'Le75', 'Linea', 'Señal'],
  ['l75:wavy', 'Le75', 'Wavy', 'Señal'],
  ['fk:segment', 'Fontshare', 'Segment', 'Señal'],
  ['fk:kola', 'Fontshare', 'Kola', 'Señal'],
  ['un:hikaru-mono', 'UNCUT', 'Hikaru Mono', 'Señal'],
  ['vw:ouroboros', 'Velvetyne', 'Ouroboros', 'Volver'],
  ['vw:kaeru-kaeru', 'Velvetyne', 'Kaeru Kaeru', 'Volver'],
  ['un:cambrian', 'UNCUT', 'Cambrian', 'Volver'],
  ['un:saint', 'UNCUT', 'Saint', 'Volver'],
  ['fk:kihim', 'Fontshare', 'Kihim', 'Avance'],
  ['vw:karrik', 'Velvetyne', 'Karrik', 'Avance'],
  ['un:destra', 'UNCUT', 'Destra', 'Avance'],
  ['un:nultien', 'UNCUT', 'NulTien', 'Avance'],
  ['un:escapist-diaries', 'UNCUT', 'Escapist Diaries', 'Avance'],
  ['l75:stairs', 'Le75', 'Stairs', 'Avance'],
  ['fk:zina', 'Fontshare', 'Zina', 'Avance'],
  ['fk:stardom', 'Fontshare', 'Stardom', 'Avance'],
];

const out = [];
for (const [k, origen, nombre, grupo] of PEDIDAS) {
  const [src, id] = k.split(':');
  let archivo = '', variable = false;
  if (src === 'l75') { const x = l75[id]; if (x) { archivo = x.archivo; variable = x.variable; } }
  else if (src === 'nw') { const x = nw[id]; if (x) { archivo = x.archivo; variable = x.variable; } }
  else if (src === 'un') { const x = un[id]; if (x) { archivo = x.archivo; variable = x.variable; } }
  else if (src === 'vw') { const x = web[id]; if (x) archivo = x.archivo; }
  else if (src === 'fk') { archivo = RF + '/w-' + id + '.woff2'; if (!fs.existsSync(archivo)) archivo = web[id] && web[id].archivo; }
  if (!archivo || !fs.existsSync(archivo)) { console.log('FALTA', k, archivo); continue; }
  out.push({ k, nombre, origen, grupo, archivo, variable, peso: variable ? 700 : 400, n: out.length + 1 });
}
fs.writeFileSync('lista-analisis.json', JSON.stringify(out, null, 1));
console.log('candidatas', out.length);
