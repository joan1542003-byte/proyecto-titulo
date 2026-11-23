#!/usr/bin/env bash
# GIF del logotipo que pasa por los cuatro colores.
# Uso, desde esta carpeta: bash render-gif.sh papel   (o: tinta)
# Necesita Node, Google Chrome y ffmpeg. Los cuadros se dibujan en una carpeta temporal.
set -e
M="${1:-papel}"
AQUI="$(cd "$(dirname "$0")" && pwd)"
T="$(mktemp -d)"
node "$AQUI/anim.js" "$T" "$M"
eval "$(node -e "const i=JSON.parse(require('fs').readFileSync(process.argv[1]));console.log('W='+i.W,'H='+i.H,'PP='+i.POR_PAGINA,'NP='+i.paginas)" "$(cygpath -m "$T/info.json" 2>/dev/null || echo "$T/info.json")")"
CH="${CHROME:-/c/Program Files/Google/Chrome/Application/chrome.exe}"
win(){ cygpath -w "$1" 2>/dev/null || echo "$1"; }
url(){ echo "file:///$(cygpath -m "$1" 2>/dev/null || echo "$1")"; }
: > "$T/list.txt"
for p in $(seq 0 $((NP-1))); do
  pp=$(printf %02d $p)
  "$CH" --headless=new --disable-gpu --hide-scrollbars --force-device-scale-factor=1 --window-size=$W,$((H*PP)) --screenshot="$(win "$T/p$pp.png")" "$(url "$T/p$pp.html")" 2>/dev/null
  # cada página trae $PP cuadros, uno bajo otro
  ffmpeg -y -loglevel error -i "$T/p$pp.png" -vf "untile=1x$PP,setpts=N/25/TB" -r 25 -c:v libx264 -crf 12 -pix_fmt yuv444p "$T/p$pp.mp4"
  echo "file 'p$pp.mp4'" >> "$T/list.txt"
done
ffmpeg -y -loglevel error -f concat -safe 0 -i "$T/list.txt" -c copy "$T/todo.mp4"
mkdir -p "$AQUI/../gif"
ffmpeg -y -loglevel error -i "$T/todo.mp4" -vf "fps=25,scale=720:-1:flags=lanczos,split[a][b];[a]palettegen=max_colors=128:stats_mode=full[p];[b][p]paletteuse=dither=bayer:bayer_scale=4" -loop 0 "$AQUI/../gif/relevo-colores-$M.gif"
ffmpeg -y -loglevel error -i "$T/todo.mp4" -vf "scale=720:-2" -c:v libx264 -preset slow -crf 20 -pix_fmt yuv420p -movflags +faststart "$AQUI/../gif/relevo-colores-$M.mp4"
rm -rf "$T"
echo "Listo: gif/relevo-colores-$M.gif y .mp4"
