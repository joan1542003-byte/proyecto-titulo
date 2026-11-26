/* Repaso Relevo: guarda la página en el teléfono para usarla sin internet. Con internet trae siempre la versión más
   nueva. No guarda el avance: el avance vive en el navegador (localStorage) y no pasa por aquí. */
const CACHE = "repaso-relevo-2026-11-26";
const ARCHIVOS = ["./", "./index.html", "./manifest.webmanifest", "./icono-180.png", "./icono-192.png", "./icono-512.png", "./icono-maskable-512.png"];
self.addEventListener("install", (e) => {
  e.waitUntil(caches.open(CACHE).then((c) => c.addAll(ARCHIVOS)).then(() => self.skipWaiting()));
});
self.addEventListener("activate", (e) => {
  e.waitUntil(caches.keys()
    .then((ks) => Promise.all(ks.filter((k) => k.startsWith("repaso-relevo-") && k !== CACHE).map((k) => caches.delete(k))))
    .then(() => self.clients.claim()));
});
self.addEventListener("fetch", (e) => {
  const req = e.request;
  if (req.method !== "GET" || new URL(req.url).origin !== location.origin) return;
  if (req.mode === "navigate") {
    e.respondWith(fetch(req)
      .then((r) => { if (r.ok) { const copia = r.clone(); caches.open(CACHE).then((c) => c.put("./index.html", copia)); } return r; })
      .catch(() => caches.match("./index.html").then((r) => r || caches.match("./"))));
    return;
  }
  e.respondWith(caches.match(req).then((r) => r || fetch(req).then((res) => {
    if (res.ok) { const copia = res.clone(); caches.open(CACHE).then((c) => c.put(req, copia)); }
    return res;
  })));
});
