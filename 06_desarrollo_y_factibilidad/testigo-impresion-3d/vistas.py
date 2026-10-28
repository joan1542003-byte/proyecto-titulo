#!/usr/bin/env python3
"""Vistas del testigo: arma las piezas, las corta por la mitad para el corte y las fotografía con
three.js en Chrome sin ventana. Escribe vistas/testigo-*.png.

Uso:  python3 testigo.py && python3 vistas.py      (necesita Google Chrome y conexión, para three.js)
"""
import os
import subprocess

import sys

AQUI = os.path.dirname(os.path.abspath(__file__))
sys.path.insert(0, AQUI)
import testigo as T  # noqa: E402

PIEZAS = os.path.join(AQUI, 'vistas', '_piezas')
CHROME = os.environ.get('CHROME', '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome')

def piezas_de_montaje():
    pcb, pila, boton = T.modulo()
    base, colores = T.fondo_colores()
    p = {'cuerpo': T.cuerpo(), 'tapa': T.tapa(), 'chasis': T.chasis(), 'medallon-placa': T.placa_medallon(),
         'tag-placa': pcb, 'tag-pila': pila, 'tag-boton': boton, 'fondo-base': base}
    p.update({f'fondo-luz-{i + 1}': c for i, c in enumerate(colores)})
    return p

if __name__ == '__main__':
    for n, p in piezas_de_montaje().items():
        T.guardar(p, os.path.join(PIEZAS, n + '.stl'))
        mitad = p.trim_by_plane((-1, 0, 0), 0.0)                         # deja la mitad x < 0, cerrada
        if not mitad.is_empty():
            T.guardar(mitad, os.path.join(PIEZAS, 'corte-' + n + '.stl'))
    html = os.path.join(AQUI, 'vistas', 'vistas.html')
    for vista in ('heroe', 'explosion', 'corte', 'logo'):
        salida = os.path.join(AQUI, 'vistas', f'testigo-{vista}.png')
        subprocess.run([CHROME, '--headless=new', '--hide-scrollbars', '--allow-file-access-from-files',
                        '--use-angle=swiftshader', '--enable-unsafe-swiftshader', '--window-size=1600,1000',
                        '--virtual-time-budget=30000', f'--screenshot={salida}', f'file://{html}?vista={vista}'],
                       check=True, capture_output=True)
        print('vista', vista, '→', os.path.relpath(salida, AQUI))
