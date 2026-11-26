#!/usr/bin/env python3
"""Planos acotados de Relevo Home y Relevo Go (26 de noviembre de 2026): planta y alzado de cada variante, con sus
medidas exteriores en milímetros. Usa las mismas funciones de perfil de modelo.py y medidas.json, así que los planos
cambian solos si cambian las medidas. No necesita manifold3d ni numpy: solo el cálculo de los perfiles.

Escribe vistas/relevo-planos-home-y-go.svg y, con Chrome sin ventana, vistas/relevo-planos-home-y-go.png.
Uso:  python3 planos.py
"""
import math
import os
import subprocess
import sys
import types

AQUI = os.path.dirname(os.path.abspath(__file__))

# ---------------------------------------------------------------- modelo.py sin sus bibliotecas de sólidos
np = types.ModuleType('numpy')
np.linspace = lambda a, b, n: [a + (b - a) * i / (n - 1) for i in range(n)] if n > 1 else [a]


class _Vec(list):
    def __truediv__(self, k):
        return _Vec(x / k for x in self)


np.array = lambda xs: _Vec(xs)
m3 = types.ModuleType('manifold3d')
m3.set_circular_segments = lambda n: None


class _Corte:          # CrossSection: aquí solo guarda los puntos del contorno
    def __init__(self, polys):
        self.polys = polys


m3.CrossSection = _Corte
sys.modules.update({'numpy': np, 'manifold3d': m3, 'trimesh': types.ModuleType('trimesh')})
sys.path.insert(0, AQUI)
import modelo as M  # noqa: E402


def _base(v):
    _, v['R'] = M.perfil_base(v)


def _cupula(v):
    _, v['radio_abombado'] = M.perfil_cupula(v['R'], v['alto_cupula'], v['lado_cupula'], v['radio_canto_cupula'], M.N['chaflan'], v['radio_meseta'])
    return None, [None] * 4, None


M.base, M.cupula = _base, _cupula
HOME, _ = M.variante('home')
GO, _ = M.variante('go')

# ---------------------------------------------------------------- Dibujo
K = 11.0                     # píxeles por milímetro
TINTA, COTA = '#141312', '#55504B'
F = 'font-family="Instrument Sans, Helvetica, Arial, sans-serif"'
from decimal import Decimal, ROUND_HALF_UP
# Un decimal, redondeando la mitad hacia arriba, como el texto de la memoria (13,35 → 13,4); sin «,0».
mm = lambda x: str(Decimal(str(round(x, 6))).quantize(Decimal('0.1'), ROUND_HALF_UP)).rstrip('0').rstrip('.').replace('.', ',')


def poli(pts, ox, oy, ancho=2.2, cerrar=True, color=TINTA, extra=''):
    d = ' '.join(f'{ox + x * K:.2f},{oy - y * K:.2f}' for x, y in pts)
    return f'<{"polygon" if cerrar else "polyline"} points="{d}" fill="none" stroke="{color}" stroke-width="{ancho}" stroke-linejoin="round" {extra}/>'


def circ(cx, cy, r, ox, oy, ancho=2.2, color=TINTA, extra=''):
    return f'<circle cx="{ox + cx * K:.2f}" cy="{oy - cy * K:.2f}" r="{r * K:.2f}" fill="none" stroke="{color}" stroke-width="{ancho}" {extra}/>'


def texto(x, y, s, tam=30, ancla='middle', peso=500, color=COTA, rot=0):
    r = f' transform="rotate({rot} {x:.1f} {y:.1f})"' if rot else ''
    return f'<text x="{x:.1f}" y="{y:.1f}" {F} font-size="{tam}" font-weight="{peso}" text-anchor="{ancla}" fill="{color}"{r}>{s}</text>'


def cota_h(x0, x1, y, rot, ox, oy, aux_desde=None):
    """Cota horizontal entre x0 y x1 (mm), a la altura y (mm); aux_desde: altura de donde salen las líneas auxiliares."""
    X0, X1, Y = ox + x0 * K, ox + x1 * K, oy - y * K
    s = ''
    if aux_desde is not None:
        Ya = oy - aux_desde * K
        for X in (X0, X1):
            s += f'<line x1="{X:.1f}" y1="{Ya + (6 if Y > Ya else -6):.1f}" x2="{X:.1f}" y2="{Y + (8 if Y > Ya else -8):.1f}" stroke="{COTA}" stroke-width="1.2"/>'
    s += f'<line x1="{X0:.1f}" y1="{Y:.1f}" x2="{X1:.1f}" y2="{Y:.1f}" stroke="{COTA}" stroke-width="1.4" marker-start="url(#f)" marker-end="url(#f)"/>'
    return s + texto((X0 + X1) / 2, Y - 10, rot)


def cota_v(y0, y1, x, rot, ox, oy, aux_desde=None):
    Y0, Y1, X = oy - y0 * K, oy - y1 * K, ox + x * K
    s = ''
    if aux_desde is not None:    # un número, o uno para cada extremo: dónde empieza cada línea auxiliar (mm)
        desde = aux_desde if isinstance(aux_desde, tuple) else (aux_desde, aux_desde)
        for Y, a in zip((Y0, Y1), desde):
            Xa = ox + a * K
            s += f'<line x1="{Xa + (6 if X > Xa else -6):.1f}" y1="{Y:.1f}" x2="{X + (8 if X > Xa else -8):.1f}" y2="{Y:.1f}" stroke="{COTA}" stroke-width="1.2"/>'
    s += f'<line x1="{X:.1f}" y1="{Y0:.1f}" x2="{X:.1f}" y2="{Y1:.1f}" stroke="{COTA}" stroke-width="1.4" marker-start="url(#f)" marker-end="url(#f)"/>'
    return s + texto(X + (14 if X >= ox else -14), (Y0 + Y1) / 2 + 8, rot, ancla='start' if X >= ox else 'end')


def espejo(pts):
    return [(-x, z) for x, z in reversed(pts)]


def perfil_cupula(v):
    pts, _ = M.perfil_cupula(v['R'], v['alto_cupula'], v['lado_cupula'], v['radio_canto_cupula'], M.N['chaflan'], v['radio_meseta'])
    medio = [(r, z + M.S) for r, z in pts if r > 0]
    return espejo(medio) + medio


def perfil_base_home(v):
    pts, _ = M.perfil_base(v)
    medio = [p for p in pts if p[0] > 0]
    return espejo(medio) + medio


def alzado_go(v):
    """Silueta lateral de Go (la punta a la derecha): el mismo canto elíptico en los dos extremos y chaflán en la junta."""
    rr, av, ch = v['radio_canto_inferior'], v['alto_canto_inferior'], M.N['chaflan']
    g = v['gota']
    izq, der = -v['R_pie'], g['distancia_agujero'] + g['radio_punta']
    canto = [(rr - rr * math.cos(math.radians(t)), av + av * math.sin(math.radians(t))) for t in np.linspace(-90, 0, 24)]
    derecha = [(der - h, z) for h, z in canto] + [(der, M.Z_BASE - ch), (der - ch, M.Z_BASE)]
    izquierda = [(izq + ch, M.Z_BASE), (izq, M.Z_BASE - ch)] + [(izq + h, z) for h, z in reversed(canto)]
    return derecha + izquierda, izq, der


def planta_go(v):
    return M.contorno_gota(v, 0.0).polys[0]


ANCHO, ALTO = 1860, 1100
partes = []
TOPE, BASE = 92, 1010        # altura de los rótulos de vista y línea de apoyo de los alzados (px)

def vista(ox, nombre, titulo_x=None):
    x = ox if titulo_x is None else titulo_x
    partes.append(texto(x, 54, nombre, tam=40, peso=650, color=TINTA))
    partes.append(texto(x, TOPE + 4, 'Planta', tam=30))
    partes.append(texto(x, 836, 'Alzado', tam=30))

# Relevo Home: planta arriba, alzado abajo
ox, oy = 560, 420
vista(ox, 'Relevo Home')
partes.append(circ(0, 0, HOME['R_pie'], ox, oy))
partes.append(circ(0, 0, HOME['R'], ox, oy, 1.4))
partes.append(circ(0, 0, HOME['diametro_logo'] / 2, ox, oy, 1.2, extra='stroke-dasharray="6 5"'))
partes.append(cota_h(-HOME['R_pie'], HOME['R_pie'], -HOME['R_pie'] - 4.5, 'Ø ' + mm(2 * HOME['R_pie']), ox, oy, aux_desde=0))
partes.append(cota_h(-HOME['diametro_logo'] / 2, HOME['diametro_logo'] / 2, 0, '', ox, oy))
partes.append(texto(ox, oy - 12, 'logo Ø ' + mm(HOME['diametro_logo']), tam=28))
partes.append(poli(perfil_base_home(HOME), ox, BASE))
partes.append(poli(perfil_cupula(HOME), ox, BASE))
partes.append(f'<line x1="{ox - 32 * K:.1f}" y1="{BASE}" x2="{ox + 32 * K:.1f}" y2="{BASE}" stroke="{COTA}" stroke-width="1" stroke-dasharray="2 6"/>')
partes.append(cota_v(0, HOME['H'], HOME['R_pie'] + 4, mm(HOME['H']), ox, BASE, aux_desde=(HOME['R_pie'] - 2, HOME['radio_meseta'] + 1)))
partes.append(cota_v(M.S, HOME['H'], -HOME['R_pie'] - 4, 'cúpula ' + mm(HOME['alto_cupula']), ox, BASE, aux_desde=(-HOME['R'] - 0.5, -HOME['radio_meseta'] - 1)))

# Relevo Go: planta arriba, con la punta y su argolla hacia arriba; alzado abajo, con la punta a la derecha
ox, oy = 1330, 480
d, ra, rt = GO['gota']['distancia_agujero'], GO['gota']['radio_agujero'], GO['gota']['radio_punta']
vista(ox, 'Relevo Go', titulo_x=ox + 5 * K)
partes.append(poli(planta_go(GO), ox, oy))
partes.append(circ(0, 0, GO['R'], ox, oy, 1.4))
partes.append(circ(0, 0, GO['diametro_logo'] / 2, ox, oy, 1.2, extra='stroke-dasharray="6 5"'))
partes.append(circ(0, d, ra, ox, oy, 1.6))
largo_y0, largo_y1 = -GO['R_pie'], d + rt
partes.append(cota_h(-GO['R_pie'], GO['R_pie'], -GO['R_pie'] - 4.5, mm(2 * GO['R_pie']), ox, oy, aux_desde=0))
partes.append(cota_v(largo_y0, largo_y1, GO['R_pie'] + 5, mm(largo_y1 - largo_y0), ox, oy, aux_desde=0))
partes.append(f'<line x1="{ox - ra * 0.7 * K:.1f}" y1="{oy - d * K:.1f}" x2="{ox - (rt + 6.5) * K:.1f}" y2="{oy - d * K:.1f}" stroke="{COTA}" stroke-width="1.2"/>')
partes.append(texto(ox - (rt + 7.2) * K, oy - d * K + 8, 'agujero Ø ' + mm(2 * ra), tam=28, ancla='end'))
partes.append(texto(ox, oy - 12, 'logo Ø ' + mm(GO['diametro_logo']), tam=28))
sil, izq, der = alzado_go(GO)
partes.append(poli(sil, ox, BASE))
partes.append(poli(perfil_cupula(GO), ox, BASE))
partes.append(f'<line x1="{ox + (izq - 4) * K:.1f}" y1="{BASE}" x2="{ox + (der + 4) * K:.1f}" y2="{BASE}" stroke="{COTA}" stroke-width="1" stroke-dasharray="2 6"/>')
partes.append(cota_v(0, GO['H'], der + 4, mm(GO['H']), ox, BASE, aux_desde=(der - 1.5, GO['radio_meseta'] + 1)))

partes.append(texto(ANCHO - 40, ALTO - 30, 'Medidas en milímetros', tam=28, ancla='end'))
svg = (f'<svg xmlns="http://www.w3.org/2000/svg" width="{ANCHO}" height="{ALTO}" viewBox="0 0 {ANCHO} {ALTO}">'
       f'<defs><marker id="f" viewBox="0 0 10 10" refX="5" refY="5" markerWidth="7" markerHeight="7" orient="auto-start-reverse">'
       f'<path d="M0,1 L9,5 L0,9 z" fill="{COTA}"/></marker></defs>'
       f'<rect width="100%" height="100%" fill="#FFFFFF"/>' + ''.join(partes) + '</svg>')
salida = os.path.join(AQUI, 'vistas', 'relevo-planos-home-y-go')
open(salida + '.svg', 'w', encoding='utf8').write(svg)
chrome = os.environ.get('CHROME', '/Applications/Google Chrome.app/Contents/MacOS/Google Chrome')
html = salida + '-tmp.html'
open(html, 'w', encoding='utf8').write(f'<!doctype html><meta charset="utf-8"><style>html,body{{margin:0;background:#fff}}</style>{svg}')
subprocess.run([chrome, '--headless=new', '--disable-gpu', '--hide-scrollbars', '--force-device-scale-factor=2',
                f'--window-size={ANCHO},{ALTO}', f'--screenshot={salida}.png', 'file://' + html], check=True, capture_output=True)
os.remove(html)
print('Home: Ø', mm(2 * HOME['R_pie']), '× alto', mm(HOME['H']), '· cúpula', mm(HOME['alto_cupula']), '· junta Ø', mm(2 * HOME['R']))
print('Go:', mm(2 * GO['R_pie']), '×', mm(largo_y1 - largo_y0), '× alto', mm(GO['H']), '· cúpula', mm(GO['alto_cupula']), '· agujero Ø', mm(2 * ra))
print('Escrito:', salida + '.png')
