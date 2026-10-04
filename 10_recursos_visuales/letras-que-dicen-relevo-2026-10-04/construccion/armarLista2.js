// Segunda lista de candidatas display (las que aún no se habían mirado en grande).
const fs = require('fs');
const os = require('os');
const P = require('path');
const RF = P.join(os.tmpdir(), 'rf').split(P.sep).join('/');
const leer = (f) => JSON.parse(fs.readFileSync(f, 'utf8'));
const l75 = Object.fromEntries(leer('le75/items-l75.json').map((x) => [x.id, x]));
const un = Object.fromEntries(leer('../v38/uncut/items.json').map((x) => [x.id.split('/')[1], x]));
const web = leer('web-archivos.json');
const L = (ids) => ids.map((id) => ['l75:' + id, 'Le75', l75[id] && l75[id].nombre]);
const PEDIDAS = [
  ...L(['acte', 'elastic', 'infini', 'onlytrue', 'rami', 'metro-zine', 'ding-dong', 'ellipse', 'elemental', 'haslea', 'supernotoriousdot', 'spacenotoriousrounded', 'super-clip', 'parasitype', 'punctata', 'thalsa', 'frame', 'simple', 'barlowfold', 'paradox', 'outata', 'yunik', 'scorpius']),
  ...['granturismo', 'giphurs', 'blocks-on-blocks', 'frick', 'sunday-masthead', 'kulture-type', 'milkman', 'imogen', 'fibel-nord', 'zarathustra', 'cat-eckmann', 'heming', 'garamon-d-t', 'swansea', 'milford'].map((id) => ['un:' + id, 'UNCUT', un[id] && un[id].nombre]),
  ...[['backout', 'Backout'], ['basteleur', 'Basteleur'], ['facade', 'Façade'], ['picnic', 'Picnic'], ['gulax', 'Gulax'], ['outward', 'Outward'], ['resistance', 'Resistance'], ['steps-mono', 'Steps Mono'], ['lithops', 'Lithops'], ['ouvrieres', 'Ouvrières']].map(([id, n]) => ['vw:' + id, 'Velvetyne', n]),
  ...[['boxing', 'Boxing'], ['striper', 'Striper'], ['bevellier', 'Bevellier'], ['nippo', 'Nippo'], ['styro', 'Styro'], ['chubbo', 'Chubbo'], ['melodrama', 'Melodrama'], ['clash-display', 'Clash Display'], ['aktura', 'Aktura'], ['tanker', 'Tanker'], ['technor', 'Technor'], ['bespoke-stencil', 'Bespoke Stencil'], ['array', 'Array']].map(([id, n]) => ['fk:' + id, 'Fontshare', n]),
  ['cl:apfel', 'Collletttivo', 'Apfel Grotezk'],
  ['cl:borges', 'Collletttivo', 'Borges'],
];
const out = [];
for (const [k, origen, nombre] of PEDIDAS) {
  const [src, id] = k.split(':');
  let archivo = '', variable = false;
  if (src === 'l75') { const x = l75[id]; if (x) { archivo = x.archivo; variable = x.variable; } }
  else if (src === 'un') { const x = un[id]; if (x) { archivo = x.archivo; variable = x.variable; } }
  else if (src === 'vw') { const x = web[id]; if (x) archivo = x.archivo; }
  else if (src === 'fk') { archivo = RF + '/w-' + id + '.woff2'; }
  else if (src === 'cl') { archivo = RF + '/c-' + id + '.otf'; }
  if (!archivo || !fs.existsSync(archivo)) { console.log('FALTA', k, archivo); continue; }
  out.push({ k, nombre: nombre || id, origen, archivo, variable, peso: variable ? 700 : 400, n: 100 + out.length + 1 });
}
fs.writeFileSync('lista-analisis2.json', JSON.stringify(out, null, 1));
console.log('candidatas', out.length);
