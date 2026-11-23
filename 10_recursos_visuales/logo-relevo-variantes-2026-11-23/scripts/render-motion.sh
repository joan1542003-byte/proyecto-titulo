#!/usr/bin/env bash
# Familia de animaciones del logo.
# Uso, desde esta carpeta: bash render-motion.sh <escena> <texto> <fondo> <formato> <nombre>
#   ej.: bash render-motion.sh revela cuatro papel horizontal relevo-revela-texto-cuatro-colores
# Necesita Node, Google Chrome y ffmpeg. Dibuja a 50 cuadros por segundo y al doble de resolución.
set -e
E="$1"; X="$2"; B="$3"; F="$4"; NOMBRE="$5"
AQUI="$(cd "$(dirname "$0")" && pwd)"
T="$(mktemp -d)"
node "$AQUI/motion.js" "$T" "$E" "$X" "$B" "$F"
eval "$(node -e "const i=JSON.parse(require('fs').readFileSync(process.argv[1]));console.log('N='+i.N,'W='+i.W,'H='+i.H,'PP='+i.POR_PAGINA,'NP='+i.paginas)" "$(cygpath -m "$T/info.json" 2>/dev/null || echo "$T/info.json")")"
CH="${CHROME:-/c/Program Files/Google/Chrome/Application/chrome.exe}"
win(){ cygpath -w "$1" 2>/dev/null || echo "$1"; }
url(){ echo "file:///$(cygpath -m "$1" 2>/dev/null || echo "$1")"; }
: > "$T/list.txt"
for p in $(seq 0 $((NP-1))); do
  pp=$(printf %02d $p)
  "$CH" --headless=new --disable-gpu --hide-scrollbars --force-device-scale-factor=2 --window-size=$W,$((H*PP)) --screenshot="$(win "$T/p$pp.png")" "$(url "$T/p$pp.html")" 2>/dev/null
  ffmpeg -y -loglevel error -i "$T/p$pp.png" -vf "untile=1x$PP,setpts=N/50/TB" -r 50 -c:v libx264 -crf 10 -pix_fmt yuv444p "$T/p$pp.mp4"
  echo "file 'p$pp.mp4'" >> "$T/list.txt"
done
ffmpeg -y -loglevel error -f concat -safe 0 -i "$T/list.txt" -frames:v $N -c:v libx264 -crf 10 -pix_fmt yuv444p "$T/todo.mp4"
mkdir -p "$AQUI/../animacion-logo"
O="$AQUI/../animacion-logo/$NOMBRE"
if [ "$F" = marca ]; then S=400; else S=720; fi
# GIF a 25 cuadros: cada uno mezcla dos de los de 50, un desenfoque de movimiento leve
ffmpeg -y -loglevel error -i "$T/todo.mp4" -vf "tmix=frames=2,fps=25,scale=$S:-1:flags=lanczos,split[a][b];[a]palettegen=max_colors=160:stats_mode=full[p];[b][p]paletteuse=dither=bayer:bayer_scale=4" -loop 0 "$O.gif"
ffmpeg -y -loglevel error -i "$T/todo.mp4" -vf "scale=$((S*2)):-2:flags=lanczos" -r 50 -c:v libx264 -preset slow -crf 18 -pix_fmt yuv420p -movflags +faststart "$O.mp4"
rm -rf "$T"
echo "Listo: animacion-logo/$NOMBRE"
