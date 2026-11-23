#!/usr/bin/env bash
# Rehace toda la familia de animaciones del logo. Desde esta carpeta: bash render-familia.sh
set -e
cd "$(dirname "$0")"
r(){ bash render-motion.sh "$@"; }
r revela tinta    papel horizontal relevo-revela-texto-tinta
r revela cuatro   papel horizontal relevo-revela-texto-cuatro-colores
r revela amarillo papel horizontal relevo-revela-texto-amarillo
r revela cielo    papel horizontal relevo-revela-texto-cielo
r revela lima     papel horizontal relevo-revela-texto-lima
r revela rubor    papel horizontal relevo-revela-texto-rubor
r revela cuatro   tinta horizontal relevo-revela-fondo-tinta-texto-cuatro-colores
r revela blanco   tinta horizontal relevo-revela-fondo-tinta-texto-blanco
r turno  turno    papel horizontal relevo-turno-texto-color-del-turno
r turno  turno    tinta horizontal relevo-turno-fondo-tinta-texto-color-del-turno
r turno  tinta    papel horizontal relevo-turno-texto-tinta
r revela tinta    papel marca      relevo-marca-revela
r turno  tinta    papel marca      relevo-marca-turno
# Degradado sutil: cada color va de su original a su tono claro (puntas claras o centro claro)
r turno  turno    papel horizontal relevo-turno-sutil-puntas-claras-texto-color-del-turno puntas-claras
r turno  turno    tinta horizontal relevo-turno-sutil-puntas-claras-fondo-tinta-texto-color-del-turno puntas-claras
r turno  tinta    papel horizontal relevo-turno-sutil-puntas-claras-texto-tinta puntas-claras
r turno  tinta    papel marca      relevo-marca-turno-sutil-puntas-claras puntas-claras
r turno  turno    papel horizontal relevo-turno-sutil-centro-claro-texto-color-del-turno centro-claro
r turno  tinta    papel marca      relevo-marca-turno-sutil-centro-claro centro-claro
