// Conector del panel de Relevo fuera de claude.ai.
//
// El panel nació como página de claude.ai y pide sus datos con `window.claude.use('mcp')` (el conector de
// Supabase) y descarga archivos con `window.claude.use('downloads')`. Este archivo ofrece lo mismo cuando el
// panel se abre en un navegador común:
//   · Con `node servidor.js` y un token de Supabase: lee y escribe los datos reales del proyecto.
//   · Sin servidor o sin token (por ejemplo, al abrir el archivo con doble clic): muestra datos de ejemplo
//     (datos-de-ejemplo.js), que son inventados. Nada de lo que se haga en ese modo llega a Supabase.
// En claude.ai no hace nada: allí `window.claude` ya existe.
(function () {
  if (window.claude && typeof window.claude.use === 'function') return;

  const token = (document.querySelector('meta[name="relevo-panel-token"]') || {}).content || '';
  const pedirEjemplo = /[?&]ejemplo\b/.test(location.search);

  // Descarga normal del navegador: crea el archivo y lo guarda en la carpeta de descargas.
  const descargas = {
    async save({ filename, data }) {
      const blob = data instanceof Blob ? data : new Blob([data], { type: typeof data === 'string' ? 'text/plain;charset=utf-8' : 'application/octet-stream' });
      const url = URL.createObjectURL(blob);
      const a = document.createElement('a'); a.href = url; a.download = filename; document.body.appendChild(a); a.click(); a.remove();
      setTimeout(() => URL.revokeObjectURL(url), 5000);
      return { status: 'saved' };
    },
  };

  // Datos reales: el servidor local reenvía cada consulta a la API de administración de Supabase.
  const vivo = {
    async callTool(_servidor, _herramienta, entrada) {
      const r = await fetch('api/sql', { method: 'POST', headers: { 'Content-Type': 'application/json', 'X-Relevo-Panel': token }, body: JSON.stringify({ query: entrada.query }) });
      let cuerpo = null; try { cuerpo = await r.json(); } catch (e) { /* respuesta sin JSON */ }
      if (!r.ok) throw { code: (cuerpo && cuerpo.code) || 'tool_error', message: (cuerpo && cuerpo.message) || 'El servidor local respondió ' + r.status };
      return { payload: JSON.stringify(cuerpo) };
    },
  };

  // Datos de ejemplo: se cargan solo si hacen falta.
  let cargaEjemplo = null;
  const ejemplo = {
    async callTool(_servidor, _herramienta, entrada) {
      if (!cargaEjemplo) cargaEjemplo = new Promise((ok, mal) => { const s = document.createElement('script'); s.src = 'datos-de-ejemplo.js'; s.onload = ok; s.onerror = () => mal({ code: 'tool_error', message: 'Falta datos-de-ejemplo.js junto al panel.' }); document.head.appendChild(s); });
      await cargaEjemplo;
      return { payload: JSON.stringify(window.RELEVO_EJEMPLO.filas(entrada.query)) };
    },
  };

  function aviso(texto) {
    const poner = () => {
      const d = document.createElement('div');
      d.setAttribute('role', 'status');
      d.style.cssText = 'position:fixed;left:50%;transform:translateX(-50%);bottom:calc(16px + env(safe-area-inset-bottom,0px));z-index:60;background:#17181C;color:#F2F2EF;border-radius:999px;padding:9px 16px;font:600 13px/18px system-ui,sans-serif;max-width:calc(100% - 32px);text-align:center;box-shadow:0 6px 20px rgba(0,0,0,.2)';
      d.textContent = texto;
      document.body.appendChild(d);
    };
    if (document.body) poner(); else document.addEventListener('DOMContentLoaded', poner);
  }

  const modo = (async () => {
    if (pedirEjemplo || location.protocol === 'file:' || !token) return 'ejemplo';
    try {
      const r = await fetch('api/estado', { headers: { 'X-Relevo-Panel': token } });
      const j = await r.json();
      return j && j.conectado ? 'vivo' : 'ejemplo';
    } catch (e) { return 'ejemplo'; }
  })();
  modo.then((m) => aviso(m === 'vivo'
    ? 'Datos reales de Supabase, leídos con tu token desde este computador'
    : 'Datos de ejemplo: no son personas reales y nada se guarda en Supabase'));

  window.claude = {
    async use(nombre) {
      if (nombre === 'downloads') return descargas;
      if (nombre === 'mcp') return (await modo) === 'vivo' ? vivo : ejemplo;
      return null;
    },
  };
})();
