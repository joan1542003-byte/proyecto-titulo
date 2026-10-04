// Lee las 163 páginas de UNCUT y anota el enlace de descarga principal, la licencia y la autoría de cada letra.
const fs = require('fs');
const ids = fs.readFileSync('../../v37/sitios/uncut-ids.txt', 'utf8').trim().split(/\s+/);
(async () => {
  const out = [];
  for (const id of ids) {
    try {
      const html = await (await fetch(`https://uncut.wtf/${id}/`)).text();
      const main = html.split('Submit a font')[0];
      const dl = [...main.matchAll(/<a href="([^"]+)"[^>]*aria-label="Download [^"]*"/gi)].map((m) => m[1].replace(/[?]ref=uncut[.]wtf$/, ''));
      const lic = (main.match(/(SIL Open Font License[^<]*|Apache[^<]*|CC0[^<]*|CC BY[^<]*|MIT[^<]*|GPL[^<]*|Creative Commons[^<]*)/i) || [''])[0].trim();
      const by = (main.match(/by ([^<—]{3,60}) —/) || ['', ''])[1].trim();
      const cuts = (main.match(/Cuts[^0-9]*(\d+)/) || ['', ''])[1];
      const variable = /Variable[^A-Za-z]*Yes/i.test(main.replace(/<[^>]+>/g, ' '));
      out.push({ id, dl: dl[0] || '', lic, by, cuts, variable });
    } catch (e) { out.push({ id, error: e.message }); }
  }
  fs.writeFileSync('enlaces.json', JSON.stringify(out, null, 1));
  const hosts = {}; out.forEach((o) => { try { const h = new URL(o.dl).hostname; hosts[h] = (hosts[h] || 0) + 1; } catch (e) { hosts['(sin enlace)'] = (hosts['(sin enlace)'] || 0) + 1; } });
  console.log(out.length, JSON.stringify(hosts, null, 1));
  const lics = {}; out.forEach((o) => { lics[o.lic.slice(0, 40) || '(sin licencia)'] = (lics[o.lic.slice(0, 40) || '(sin licencia)'] || 0) + 1; }); console.log(JSON.stringify(lics, null, 1));
})();
