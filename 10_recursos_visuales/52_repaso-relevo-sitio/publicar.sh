#!/usr/bin/env bash
# Publica Repaso Relevo en GitHub Pages, en la rama gh-pages: la página (../52_repaso-relevo.html) como index.html,
# más el manifiesto, el service worker y los íconos de esta carpeta. No cambia la rama de trabajo ni los archivos.
# Uso, desde la raíz del repositorio:  bash 10_recursos_visuales/52_repaso-relevo-sitio/publicar.sh
set -euo pipefail
AQUI="$(cd "$(dirname "$0")" && pwd)"
cd "$AQUI"
cd "$(git rev-parse --show-toplevel)"
TMP="$(mktemp -d)"
trap 'rm -rf "$TMP"' EXIT
export GIT_INDEX_FILE="$TMP/indice"
git read-tree --empty
agregar() { local blob; blob="$(git hash-object -w "$1")"; git update-index --add --cacheinfo "100644,$blob,$2"; }
agregar "$AQUI/../52_repaso-relevo.html" index.html
for f in manifest.webmanifest sw.js icono-180.png icono-192.png icono-512.png icono-maskable-512.png; do agregar "$AQUI/$f" "$f"; done
: > "$TMP/vacio"
agregar "$TMP/vacio" .nojekyll
ARBOL="$(git write-tree)"
PADRE=""
if git fetch -q origin gh-pages 2>/dev/null; then PADRE="$(git rev-parse FETCH_HEAD)"; fi
if [ -n "$PADRE" ] && [ "$(git rev-parse "$PADRE^{tree}")" = "$ARBOL" ]; then echo "Nada nuevo que publicar."; exit 0; fi
COMMIT="$(git commit-tree "$ARBOL" ${PADRE:+-p "$PADRE"} -m "Publica Repaso Relevo ($(date +%F))")"
git push -q origin "$COMMIT:refs/heads/gh-pages"
echo "Publicado en https://joan1542003-byte.github.io/proyecto-titulo/ (GitHub tarda uno o dos minutos en mostrarlo)."
