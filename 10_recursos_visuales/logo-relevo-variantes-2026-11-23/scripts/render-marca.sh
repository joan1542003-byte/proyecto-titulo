#!/usr/bin/env bash
# Animaciones de la marca (los cuatro círculos).
# Uso, desde esta carpeta: bash render-marca.sh arma marca   (arma|turno, marca|horizontal)
# Necesita Node, Google Chrome y ffmpeg. Los cuadros se dibujan en una carpeta temporal.
set -e
A="${1:-arma}"; F="${2:-marca}"
AQUI="$(cd "$(dirname "$0")" && pwd)"
T="$(mktemp -d)"
node "$AQUI/marca-anim.js" "$T" "$A" "$F"
eval "$(node -e "const i=JSON.parse(require('fs').readFileSync(process.argv[1]));console.log('N='+i.N,'W='+i.W,'H='+i.H,'PP='+i.POR_PAGINA,'NP='+i.paginas)" "$(cygpath -m "$T/info.json" 2>/dev/null || echo "$T/info.json")")"
CH="${CHROME:-/c/Program Files/Google/Chrome/Application/chrome.exe}"
win(){ cygpath -w "$1" 2>/dev/null || echo "$1"; }
url(){ echo "file:///$(cygpath -m "$1" 2>/dev/null || echo "$1")"; }
: > "$T/list.txt"
for p in $(seq 0 $((NP-1))); do
  pp=$(printf %02d $p)
  "$CH" --headless=new --disable-gpu --hide-scrollbars --force-device-scale-factor=1 --window-size=$W,$((H*PP)) --screenshot="$(win "$T/p$pp.png")" "$(url "$T/p$pp.html")" 2>/dev/null
  ffmpeg -y -loglevel error -i "$T/p$pp.png" -vf "untile=1x$PP,setpts=N/25/TB" -r 25 -c:v libx264 -crf 12 -pix_fmt yuv444p "$T/p$pp.mp4"
  echo "file 'p$pp.mp4'" >> "$T/list.txt"
done
# la última página puede traer cuadros vacíos al final: se corta en N
ffmpeg -y -loglevel error -f concat -safe 0 -i "$T/list.txt" -frames:v $N -c:v libx264 -crf 12 -pix_fmt yuv444p "$T/todo.mp4"
mkdir -p "$AQUI/../animacion-marca"
O="$AQUI/../animacion-marca/relevo-marca-$A-$F"
if [ "$F" = marca ]; then S=440; else S=720; fi
ffmpeg -y -loglevel error -i "$T/todo.mp4" -vf "fps=25,scale=$S:-1:flags=lanczos,split[a][b];[a]palettegen=max_colors=128:stats_mode=full[p];[b][p]paletteuse=dither=bayer:bayer_scale=4" -loop 0 "$O.gif"
ffmpeg -y -loglevel error -i "$T/todo.mp4" -vf "scale=$S:-2" -c:v libx264 -preset slow -crf 20 -pix_fmt yuv420p -movflags +faststart "$O.mp4"
cp "$T/todo.mp4" "${TMPDIR:-/tmp}/ultimo-$A-$F.mp4" 2>/dev/null || true
rm -rf "$T"
echo "Listo: animacion-marca/relevo-marca-$A-$F.gif y .mp4"
