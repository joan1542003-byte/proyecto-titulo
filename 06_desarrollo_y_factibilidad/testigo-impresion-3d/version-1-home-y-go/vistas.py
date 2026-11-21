#!/usr/bin/env python3
"""Vistas de la versión 1 para la memoria: arma las piezas, las corta por la mitad para el corte y las fotografía con
three.js en Chrome sin ventana, como en la versión 0. Las imágenes no llevan texto (el título y la nota de cada figura
los pone la memoria), van sobre blanco puro y se recortan dejando un margen parejo. Escribe vistas/relevo-*.png.

Uso:  venv/bin/python modelo.py && venv/bin/python vistas.py   (necesita Google Chrome y conexión, para three.js)
      venv/bin/python vistas.py relevo-go-vista-principal         (solo esa imagen)
"""
import base64
import json
import os
import re
import subprocess
import sys

import numpy as np
from PIL import Image

AQUI = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, AQUI)
import modelo as M  # noqa: E402

PIEZAS = os.path.join(AQUI, 'vistas', '_piezas')
CHROME = os.environ.get('CHROME', '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome')
ESCALA = 2                     # píxeles de imagen por píxel de página: 3200 × 2000 antes de recortar
MARGEN = 40                    # píxeles de blanco alrededor del objeto, después de recortar
EXPLOSION, CORTE = 'home', 'go'  # el núcleo es el mismo en las dos variantes: se muestra la que se lee mejor
TRABAJOS = [                   # (archivo, variante, vista)
    ('relevo-home-vista-principal', 'home', 'principal'),
    ('relevo-go-vista-principal', 'go', 'principal'),
    (f'relevo-{EXPLOSION}-explosion-nucleo-comun', EXPLOSION, 'explosion'),
    (f'relevo-{CORTE}-corte', CORTE, 'corte'),
    ('relevo-comparacion-tag-home-go', 'todas', 'comparacion'),
]

def exportar():
    nuc = M.nucleo()
    datos = {}
    for nv in ('home', 'go'):
        v, p = M.variante(nv)
        piezas = dict(nuc, base=p['base'], cupula=p['cupula'], **{f'color-{i}': p[f'cupula-color-{i}'] for i in range(1, 5)}, **M.modulo())
        for n, m in piezas.items():
            M.guardar(m, os.path.join(PIEZAS, nv, n + '.stl'))
            mitad = m.trim_by_plane((-1, 0, 0), 0.0)                       # deja la mitad x < 0, cerrada
            if not mitad.is_empty():
                M.guardar(mitad, os.path.join(PIEZAS, nv, 'corte-' + n + '.stl'))
        caja = p['base'].bounding_box()
        datos[nv] = {'H': v['H'], 'R': v['R'], 'R_pie': v['R_pie'], 'ymin': caja[1], 'ymax': caja[4]}
    M.guardar(M.tag_completo(), os.path.join(PIEZAS, 'tag', 'tag.stl'))
    json.dump(datos, open(os.path.join(PIEZAS, 'datos.json'), 'w'), indent=1)

def recortar(ruta):
    """Deja el objeto, con su sombra, y MARGEN píxeles de blanco alrededor. Falla si la captura salió vacía o si algo toca
    su borde, porque entonces estaría cortado."""
    im = Image.open(ruta).convert('RGBA')
    im = Image.alpha_composite(Image.new('RGBA', im.size, (255, 255, 255, 255)), im).convert('RGB')   # sobre blanco
    hay = (np.asarray(im) < 255).any(axis=2)
    if not hay.any():
        raise SystemExit(f'{os.path.basename(ruta)}: la captura salió en blanco (¿cargó three.js?)')
    ys, xs = np.nonzero(hay)
    x0, x1, y0, y1 = int(xs.min()), int(xs.max()) + 1, int(ys.min()), int(ys.max()) + 1
    if x0 == 0 or y0 == 0 or x1 == im.width or y1 == im.height:
        raise SystemExit(f'{os.path.basename(ruta)}: el objeto toca el borde de la captura')
    out = Image.new('RGB', (x1 - x0 + 2 * MARGEN, y1 - y0 + 2 * MARGEN), (255, 255, 255))
    out.paste(im.crop((x0, y0, x1, y1)), (MARGEN, MARGEN))
    out.save(ruta, optimize=True)
    return out.size

if __name__ == '__main__':
    exportar()
    html = os.path.join(AQUI, 'vistas', 'vistas.html')
    solo = sys.argv[1:]
    for nombre, v, vista in TRABAJOS:
        if solo and nombre not in solo:
            continue
        salida = os.path.join(AQUI, 'vistas', nombre + '.png')
        # Se lee el lienzo de la página (toDataURL), no una captura de la ventana: así el control de bordes es exacto.
        r = subprocess.run([CHROME, '--headless=new', '--hide-scrollbars', '--allow-file-access-from-files',
                            '--use-angle=swiftshader', '--enable-unsafe-swiftshader', '--window-size=1600,1000',
                            f'--force-device-scale-factor={ESCALA}', '--virtual-time-budget=60000', '--dump-dom',
                            f'file://{html}?v={v}&vista={vista}'], check=True, capture_output=True, text=True)
        png = re.search(r'data:image/png;base64,([A-Za-z0-9+/=]+)', r.stdout)
        if not png:
            raise SystemExit(f'{nombre}: la página no entregó la imagen (¿cargó three.js?)')
        with open(salida, 'wb') as f:
            f.write(base64.b64decode(png.group(1)))
        print('vista', nombre, recortar(salida))
