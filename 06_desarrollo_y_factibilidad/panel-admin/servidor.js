// Servidor local del panel de Relevo.
//
// Abre el panel en el navegador de este computador y le da acceso a los datos reales del proyecto en
// Supabase. Reenvía cada consulta del panel a la API de administración de Supabase
// (POST /v1/projects/{ref}/database/query) con un token personal que solo vive en este computador.
//
// Uso (Node 18 o posterior, sin instalar nada):
//   1. Crea un token en https://supabase.com/dashboard/account/tokens
//   2. Guárdalo en un archivo .env.local junto a este (no se sube al repositorio):
//        SUPABASE_ACCESS_TOKEN=sbp_...
//      o pásalo como variable de entorno.
//   3. node servidor.js        → abre http://127.0.0.1:8765
// Sin token, el panel abre igual, con datos de ejemplo.
//
// Seguridad: escucha solo en 127.0.0.1, exige la cabecera X-Relevo-Panel con una clave nueva en cada
// arranque (así otra página web no puede usarlo) y nunca envía el token al navegador.

const http = require('http');
const fs = require('fs');
const path = require('path');
const crypto = require('crypto');
const { exec } = require('child_process');

const AQUI = __dirname;
const PUERTO = Number(process.env.PORT || 8765);
const env = leerEnv(path.join(AQUI, '.env.local'));
const TOKEN = process.env.SUPABASE_ACCESS_TOKEN || env.SUPABASE_ACCESS_TOKEN || '';
const PROYECTO = process.env.SUPABASE_PROJECT_REF || env.SUPABASE_PROJECT_REF || 'rwzslwtxabmfofqppgwu';
const CLAVE = crypto.randomBytes(18).toString('hex');
const ARCHIVOS = { '/conector-local.js': 'application/javascript', '/datos-de-ejemplo.js': 'application/javascript' };

function leerEnv(archivo) {
  const out = {};
  try {
    for (const linea of fs.readFileSync(archivo, 'utf8').split(/\r?\n/)) {
      const m = linea.match(/^\s*([A-Z0-9_]+)\s*=\s*(.*?)\s*$/);
      if (m) out[m[1]] = m[2].replace(/^["']|["']$/g, '');
    }
  } catch (e) { /* sin archivo .env.local */ }
  return out;
}

function responder(res, estado, cuerpo, tipo = 'application/json; charset=utf-8') {
  res.writeHead(estado, { 'Content-Type': tipo, 'Cache-Control': 'no-store', 'X-Content-Type-Options': 'nosniff' });
  res.end(typeof cuerpo === 'string' || Buffer.isBuffer(cuerpo) ? cuerpo : JSON.stringify(cuerpo));
}

function leerCuerpo(req) {
  return new Promise((ok, mal) => {
    let datos = ''; req.setEncoding('utf8');
    req.on('data', (t) => { datos += t; if (datos.length > 1_000_000) { mal(new Error('demasiado grande')); req.destroy(); } });
    req.on('end', () => ok(datos)); req.on('error', mal);
  });
}

async function consultar(query) {
  const r = await fetch(`https://api.supabase.com/v1/projects/${PROYECTO}/database/query`, {
    method: 'POST',
    headers: { Authorization: `Bearer ${TOKEN}`, 'Content-Type': 'application/json' },
    body: JSON.stringify({ query }),
  });
  const texto = await r.text();
  let json = null; try { json = JSON.parse(texto); } catch (e) { /* no es JSON */ }
  if (!r.ok) {
    const code = r.status === 401 || r.status === 403 ? 'needs_reauth' : r.status >= 500 ? 'server_unavailable' : 'tool_error';
    throw { status: r.status, code, message: (json && (json.message || json.error)) || texto.slice(0, 300) };
  }
  return Array.isArray(json) ? json : json && Array.isArray(json.result) ? json.result : [];
}

const servidor = http.createServer(async (req, res) => {
  // Solo este computador, y nunca a través de otro nombre de dominio.
  const host = String(req.headers.host || '');
  if (host !== `127.0.0.1:${PUERTO}` && host !== `localhost:${PUERTO}`) return responder(res, 403, { code: 'host', message: 'Host no permitido' });
  const ruta = new URL(req.url, `http://${host}`).pathname;

  if (req.method === 'GET' && (ruta === '/' || ruta === '/panel-relevo.html')) {
    let html = fs.readFileSync(path.join(AQUI, 'panel-relevo.html'), 'utf8');
    html = html.replace(/<head>/i, `<head><meta name="relevo-panel-token" content="${CLAVE}">`);
    return responder(res, 200, html, 'text/html; charset=utf-8');
  }
  if (req.method === 'GET' && ARCHIVOS[ruta]) return responder(res, 200, fs.readFileSync(path.join(AQUI, ruta.slice(1))), ARCHIVOS[ruta] + '; charset=utf-8');

  if (ruta.startsWith('/api/')) {
    if (req.headers['x-relevo-panel'] !== CLAVE) return responder(res, 403, { code: 'clave', message: 'Abre el panel desde la dirección que muestra el servidor.' });
    if (req.method === 'GET' && ruta === '/api/estado') return responder(res, 200, { conectado: Boolean(TOKEN), proyecto: PROYECTO });
    if (req.method === 'POST' && ruta === '/api/sql') {
      if (!TOKEN) return responder(res, 400, { code: 'sin_token', message: 'Falta SUPABASE_ACCESS_TOKEN: el panel muestra datos de ejemplo.' });
      try {
        const { query } = JSON.parse(await leerCuerpo(req));
        if (typeof query !== 'string' || !query.trim()) return responder(res, 400, { code: 'tool_error', message: 'Consulta vacía' });
        return responder(res, 200, await consultar(query));
      } catch (e) {
        return responder(res, e.status && e.status < 500 ? 502 : 500, { code: e.code || 'tool_error', message: e.message || String(e) });
      }
    }
  }
  responder(res, 404, { code: 'no_encontrado', message: 'No existe' });
});

servidor.listen(PUERTO, '127.0.0.1', () => {
  const url = `http://127.0.0.1:${PUERTO}/`;
  console.log(`Panel de Relevo: ${url}`);
  console.log(TOKEN ? `Datos reales del proyecto ${PROYECTO}.` : 'Sin SUPABASE_ACCESS_TOKEN: el panel muestra datos de ejemplo.');
  console.log('Para cerrar, Ctrl+C.');
  if (!process.argv.includes('--sin-abrir')) {
    const abrir = process.platform === 'win32' ? `start "" "${url}"` : process.platform === 'darwin' ? `open "${url}"` : `xdg-open "${url}"`;
    exec(abrir, () => {});
  }
});
