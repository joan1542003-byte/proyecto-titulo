// Lee los ejes variables (tabla fvar) de un archivo TTF/OTF.
const fs = require('fs');
for (const f of process.argv.slice(2)) {
  const b = fs.readFileSync(f);
  const n = b.readUInt16BE(4);
  let off = null;
  for (let i = 0; i < n; i++) { const t = b.toString('latin1', 12 + i * 16, 16 + i * 16); if (t === 'fvar') off = b.readUInt32BE(20 + i * 16); }
  if (off === null) { console.log(f.split('/').pop(), 'sin fvar'); continue; }
  const axesOff = b.readUInt16BE(off + 4), count = b.readUInt16BE(off + 8), size = b.readUInt16BE(off + 10);
  const ejes = [];
  for (let i = 0; i < count; i++) { const o = off + axesOff + i * size; ejes.push(b.toString('latin1', o, o + 4) + ' ' + (b.readInt32BE(o + 4) / 65536) + '..' + (b.readInt32BE(o + 12) / 65536) + ' (def ' + (b.readInt32BE(o + 8) / 65536) + ')'); }
  console.log(f.split('/').pop(), '→', ejes.join(' | '));
}
