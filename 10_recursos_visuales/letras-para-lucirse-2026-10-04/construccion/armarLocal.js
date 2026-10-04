// Arma la lista de especímenes locales: Fontshare (varios pesos), GitHub (Velvetyne y Collletttivo) y algunas de UNCUT y Le75.
const fs = require('fs');
const fsE = JSON.parse(fs.readFileSync('fs-estilos.json', 'utf8'));
const gh = JSON.parse(fs.readFileSync('gh-archivos.json', 'utf8'));
const un = Object.fromEntries(JSON.parse(fs.readFileSync('../v38/uncut/items.json', 'utf8')).map((x) => [x.id.split('/')[1], x]));
const l75 = Object.fromEntries(JSON.parse(fs.readFileSync('../v39/le75/items-l75.json', 'utf8')).map((x) => [x.id, x]));
const out = [];
const PESOS = { boska: [300, 500, 900], gambetta: [300, 500, 700], gambarino: [400], sentient: [300, 500, 700], zodiak: [100, 400, 800], bonny: [300, 500, 700], recia: [400, 700], rowan: [400, 700], erode: [400, 700], neco: [500, 900], quilon: [500, 700], melodrama: [300, 500, 700], stardom: [400], zina: [400], telma: [300, 700, 900], hoover: [400, 700], paquito: [700], aktura: [400] };
for (const [slug, ws] of Object.entries(PESOS)) {
  const f = fsE[slug]; if (!f) continue;
  for (const w of ws) { const e = f.estilos.find((x) => x.w === w && x.st !== 'italic'); if (e) out.push({ id: 'fs-' + slug + '-' + w, label: `${f.nombre} ${w} · Fontshare`, archivo: e.archivo }); }
}
const NOM = { 'bluu-next': 'Bluu Next · Velvetyne', 'mazius-display': 'Mazius Display · Collletttivo', messapia: 'Messapia · Collletttivo', ortica: 'Ortica · Collletttivo', 'sneaky-times': 'Sneaky Times · Collletttivo', sprat: 'Sprat · Collletttivo', sinistre: 'Sinistre · Collletttivo', ribes: 'Ribes · Collletttivo', halibut: 'Halibut · Collletttivo', aujournuit: 'Aujourd’hui · Collletttivo' };
for (const [id, x] of Object.entries(gh)) out.push({ id: 'gh-' + id, label: NOM[id] || id, archivo: x.archivo });
for (const id of ['zarathustra', 'cat-eckmann', 'garamon-d-t', 'fibel-nord', 'kulture-type', 'imogen', 'milford']) { const x = un[id]; if (x) out.push({ id: 'un-' + id, label: x.nombre + ' · UNCUT', archivo: x.archivo, variable: x.variable }); }
if (l75.thalsa) out.push({ id: 'l75-thalsa', label: 'Thalsa · Le75', archivo: l75.thalsa.archivo });
fs.writeFileSync('local-lista.json', JSON.stringify(out, null, 1));
console.log('especímenes locales', out.length);
