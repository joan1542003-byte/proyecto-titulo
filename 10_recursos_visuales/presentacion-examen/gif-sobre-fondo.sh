#!/bin/bash
# Rehace una animación de Relevo como GIF opaco sobre el fondo exacto de una lámina,
# y saca un cuadro fijo (póster) para ponerlo debajo del GIF en Figma Slides.
#
# Uso: gif-sobre-fondo.sh entrada.webm salida ANCHO ALTO FONDO SEGUNDO_DEL_POSTER
#   entrada.webm  animación con transparencia real (VP9 con alfa)
#   salida        nombre base: crea salida.gif y salida-poster.png
#   ANCHO ALTO    tamaño del GIF, en píxeles (1,5 veces el tamaño en la lámina)
#   FONDO         «white» o la ruta de un PNG del mismo tamaño (por ejemplo, el aura recortada)
#   SEGUNDO       segundo de la animación que se usa como póster
#
# Usos en la presentación del examen (24 de noviembre de 2026), desde 10_recursos_visuales/:
#   portada:  logo-relevo-variantes-2026-11-23/animacion-logo/relevo-turno-texto-tinta-sin-fondo.webm 1056 312, aura de portada recortada, 0
#   cierre:   la misma, 1160 343, aura de contraportada recortada, 0
#   identidad: logo-relevo-variantes-2026-11-23/animacion-logo/relevo-turno-sin-fondo.webm 960 284 white 0
#   Relevo:   animaciones-de-relevo-2026-11-23/animaciones/relevo-como-funciona.webm 1280 720 white 9.2
#   momentos: relevo-tu-primer-paso (2.9), relevo-tu-tiempo (4.2), relevo-suena-donde-empieza (0.9)
#             y relevo-tu-decides (1.7), en 480 480 white
# El aura se recorta con la misma escala con que Figma la ajusta a la lámina (relleno, centrada).
set -e
IN=$1; OUT=$2; W=$3; H=$4; BG=$5; PT=$6
if [ "$BG" = "white" ]; then BGIN=(-f lavfi -i "color=c=white:s=${W}x${H}:r=25"); else BGIN=(-loop 1 -framerate 25 -i "$BG"); fi
FC="[1:v]scale=${W}:${H},format=rgba[bg];[0:v]fps=25,scale=${W}:${H}:flags=lanczos,format=rgba[fg];[bg][fg]overlay=shortest=1:format=auto,format=rgb24"
ffmpeg -v error -y -c:v libvpx-vp9 -i "$IN" "${BGIN[@]}" -filter_complex "$FC,split[a][b];[a]palettegen=max_colors=256:stats_mode=full[p];[b][p]paletteuse=dither=bayer:bayer_scale=4:diff_mode=rectangle" -loop 0 "$OUT.gif"
ffmpeg -v error -y -c:v libvpx-vp9 -ss "$PT" -i "$IN" "${BGIN[@]}" -filter_complex "$FC" -frames:v 1 "$OUT-poster.png"
