const fs = require('fs');
const src = fs.readFileSync(process.argv[2], 'utf8');
const out = {};
const re = /^  ([A-Z_]+)\(\n    "([^"]*)",\n    listOf\(\n([\s\S]*?)\n    \),\n  \),/gm;
let m;
while ((m = re.exec(src))) {
  const shapes = [];
  const sre = /KitShape\("([^"]*)", (true|false), KitFill\.([A-Z]+)\)/g; let s;
  while ((s = sre.exec(m[3]))) shapes.push({ d: s[1], stroke: s[2] === 'true', fill: s[3].toLowerCase() });
  out[m[1]] = { label: m[2], shapes };
}
fs.writeFileSync('kit-icons.json', JSON.stringify(out, null, 1));
console.log(Object.keys(out).length, 'icons');
