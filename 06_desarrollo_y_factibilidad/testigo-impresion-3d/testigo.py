#!/usr/bin/env python3
"""Testigo de Relevo para impresión 3D: carcasa propia para la placa y la pila del Tag.

Lee medidas.json, arma las piezas con geometría sólida (manifold3d) y escribe:
  imprimir/*.stl            piezas ya orientadas para imprimir, sin soportes
  imprimir/*.3mf            las piezas de un color en un plato de 256 × 256 mm (Bambu Lab X1 Carbon)
  imprimir/medallon-fondo-cuatro-colores/   el fondo del medallón partido en cinco piezas, para el AMS
  imprimir/prueba-de-calce/ dos cortes del cuerpo para probar la rosca y el medallón antes de todo
  montaje/*.stl             las piezas en su posición de uso (para las vistas y para revisar)

Uso:  pip install manifold3d trimesh numpy
      python3 testigo.py
"""
import json
import math
import os
import re
import sys

import manifold3d as m3
import numpy as np
import trimesh

AQUI = os.path.dirname(os.path.abspath(__file__))
DATOS = json.load(open(os.path.join(AQUI, 'medidas.json'), encoding='utf8'))
P = {k: v['valor'] for k, v in DATOS['placa'].items()}
G = {k: v['valor'] for k, v in DATOS['holguras'].items()}
SEG = 192                      # segmentos por vuelta: curvas lisas a este tamaño
m3.set_circular_segments(SEG)

# ---------------------------------------------------------------- Diseño (mm)
R_EXT = 23.0                   # planta circular de 46 mm: dentro de los 42–48 de la memoria
T_TECHO = 1.4                  # techo del cuerpo = grosor de la placa del medallón (queda a ras)
T_FONDO = 1.2                  # fondo del medallón, que hace de pestaña bajo el techo
RECORRIDO = 0.45               # cuánto baja el medallón: holgura + recorrido del botón + 0,05; el tope protege el botón
R_MED = 14.0                   # medallón visible: 28 mm
R_FONDO = 16.0                 # pestaña del medallón: 32 mm
R_REBAJE = 16.2                # rebaje del chasis donde se mueve la pestaña (centra el medallón)
R_CAV = 20.3                   # interior del cuerpo (= cresta de la rosca)
R_CHASIS = 20.1
LOGO_D = 21.0                  # el logo, de 21 mm, en el medallón de 28
# Rosca de la tapa: trapecio con flancos de 45°, sin soportes en ninguna orientación.
PASO, PROF, R_ROSCA = 2.5, 0.9, 20.0          # R_ROSCA: radio menor de la rosca de la tapa
Z_ROSCA, ALTO_ROSCA_CUERPO, ALTO_ROSCA_TAPA = 0.8, 4.8, 4.2
R_PESTANA, R_ASIENTO, T_PESTANA = 21.4, 21.6, 0.8   # pestaña de la tapa y su asiento en el cuerpo
T_TAPA = 1.8                   # piso de la tapa
R_TAPA_INT = 18.6              # hueco de la tapa, sobre el piso

# ---------------------------------------------------------------- Pila de piezas, de arriba abajo
holgura_comp = 0.3
sobre_placa = T_FONDO + RECORRIDO + holgura_comp + P['alto_componentes']   # techo → cara de la placa
z_c_min = max(2.2 + P['alto_bajo_placa'] + P['grosor'] + sobre_placa,      # la tapa alcanza la pila
              Z_ROSCA + ALTO_ROSCA_TAPA + 0.4 + 0.5 + P['grosor'] + sobre_placa)  # el chasis no choca con la tapa
H = math.ceil((max(12.0 - T_TECHO, z_c_min) + T_TECHO) * 10) / 10          # alto total
Z_C = H - T_TECHO              # cara de abajo del techo
Z_P = Z_C - sobre_placa        # cara de arriba de la placa del Tag
Z_PILA = Z_P - P['grosor'] - P['alto_bajo_placa']   # cara de afuera de la pila
Z_CHASIS = Z_P - P['grosor'] - 0.5
Z_TOPE = Z_C - T_FONDO         # cara de abajo del fondo del medallón
Z_PUNTA = Z_P + P['alto_boton'] + G['boton']        # punta que aprieta el botón
if not 12.0 <= H <= 16.0:
    print(f'Atención: el alto da {H} mm, fuera de los 12–16 de la memoria.')
if P['diametro'] / 2 + G['placa'] > R_CHASIS - 1.0:
    sys.exit('La placa no cabe en el chasis: el cuerpo tendría que crecer.')

# ---------------------------------------------------------------- Ayudas
def cil(r, z0, z1, n=SEG):
    return m3.Manifold.cylinder(z1 - z0, r, r, n).translate((0, 0, z0))

def cono(r0, r1, z0, z1, n=SEG):
    return m3.Manifold.cylinder(z1 - z0, r0, r1, n).translate((0, 0, z0))

def circulo(r, x=0.0, y=0.0, n=SEG):
    return m3.CrossSection.circle(r, n).translate((x, y))

def revolucion(perfil):
    return m3.Manifold.revolve(m3.CrossSection([perfil]), SEG)

def rosca(r_menor, z0, alto, holgura=0.0, n=120):
    """Sólido helicoidal (rosca derecha) por extrusión con giro de una sección de radio variable."""
    llano = (PASO - 2 * PROF) / 2
    def perfil(u):
        if u < llano: return r_menor
        if u < llano + PROF: return r_menor + (u - llano)
        if u < 2 * llano + PROF: return r_menor + PROF
        return r_menor + PROF - (u - 2 * llano - PROF)
    pts = []
    for k in range(n):
        th = 2 * math.pi * k / n
        r = perfil((-th * PASO / (2 * math.pi)) % PASO) + holgura
        pts.append((r * math.cos(th), r * math.sin(th)))
    vueltas = alto / PASO
    # Un giro de 360/n por división: cada vértice queda sobre el siguiente y la malla no hace escalones.
    return m3.CrossSection([pts]).extrude(alto, round(vueltas * n) - 1, 360 * vueltas).translate((0, 0, z0))

# ---------------------------------------------------------------- Marca de Relevo
def luces(diametro):
    """Las cuatro luces de la marca chica (D-132, documento 42): círculos de radio 29 a 21 del
    centro, en una unidad de 100; cada luz se recorta con el círculo siguiente, en el sentido del
    reloj, agrandado a 35,5. Orden: tiempo (arriba), primer paso, lugar y decisión."""
    k = diametro / 100
    centros = [(0, 21), (21, 0), (0, -21), (-21, 0)]
    out = []
    for i, (cx, cy) in enumerate(centros):
        nx, ny = centros[(i + 1) % 4]
        out.append(circulo(29 * k, cx * k, cy * k, 256) - circulo(35.5 * k, nx * k, ny * k, 256))
    return out

def logotipo(ancho, espejo=False):
    """La palabra «relevo» del SVG oficial (Chillax Semibold en trazos), como sección 2D centrada."""
    d = re.search(r' d="([^"]+)"', open(os.path.join(AQUI, 'relevo-logotipo.svg'), encoding='utf8').read()).group(1)
    fichas = re.findall(r'[MLCZ]|-?\d*\.?\d+', d)
    contornos, actual, i, p = [], [], 0, (0.0, 0.0)
    while i < len(fichas):
        t = fichas[i]; i += 1
        if t == 'M':
            if actual: contornos.append(actual)
            p = (float(fichas[i]), float(fichas[i + 1])); i += 2; actual = [p]
        elif t == 'L':
            p = (float(fichas[i]), float(fichas[i + 1])); i += 2; actual.append(p)
        elif t == 'C':
            c1 = (float(fichas[i]), float(fichas[i + 1])); c2 = (float(fichas[i + 2]), float(fichas[i + 3]))
            q = (float(fichas[i + 4]), float(fichas[i + 5])); i += 6
            for s in np.linspace(0, 1, 13)[1:]:
                a = (1 - s) ** 3; b = 3 * (1 - s) ** 2 * s; c = 3 * (1 - s) * s ** 2; e = s ** 3
                actual.append((a * p[0] + b * c1[0] + c * c2[0] + e * q[0], a * p[1] + b * c1[1] + c * c2[1] + e * q[1]))
            p = q
        elif t == 'Z':
            if actual: contornos.append(actual); actual = []
        else:  # coordenadas sueltas tras L implícito
            p = (float(t), float(fichas[i])); i += 1; actual.append(p)
    if actual: contornos.append(actual)
    xs = [x for c in contornos for x, _ in c]; ys = [y for c in contornos for _, y in c]
    k = ancho / (max(xs) - min(xs)); cx = (max(xs) + min(xs)) / 2; cy = (max(ys) + min(ys)) / 2
    s = -1 if espejo else 1
    polis = [[(s * (x - cx) * k, -(y - cy) * k) for x, y in c] for c in contornos]
    return m3.CrossSection(polis, m3.FillRule.EvenOdd)

# ---------------------------------------------------------------- Cuerpo
def cuerpo():
    # Borde de arriba: bisel de 45° y arco de 2,4 mm. Se imprime boca abajo: nada pasa de 45°.
    z1 = H - 0.8 - 2.4 * math.sin(math.radians(45))
    perfil = [(0, 0), (R_EXT - 0.4, 0), (R_EXT, 0.4), (R_EXT, z1)]
    for a in np.linspace(0, 45, 12)[1:]:
        perfil.append((R_EXT - 2.4 + 2.4 * math.cos(math.radians(a)), z1 + 2.4 * math.sin(math.radians(a))))
    perfil += [(perfil[-1][0] - 0.8, H), (0, H)]
    c = revolucion(perfil)
    c -= cil(R_ASIENTO, -1, T_PESTANA)                                   # asiento de la pestaña de la tapa
    c -= rosca(R_ROSCA, Z_ROSCA, ALTO_ROSCA_CUERPO, G['rosca'])          # rosca interior
    c -= cono(R_ROSCA + PROF + G['rosca'] + 0.3, R_ROSCA + G['rosca'], Z_ROSCA - 0.01, Z_ROSCA + 1.2)  # entrada
    c -= cil(R_CAV, Z_ROSCA + ALTO_ROSCA_CUERPO - 0.01, Z_C)            # interior
    c -= cil(R_MED + G['halo'], Z_C - 0.01, H + 1)                      # ventana del medallón
    return c

# ---------------------------------------------------------------- Tapa
def tapa():
    t = cil(R_PESTANA, 0, T_PESTANA) + rosca(R_ROSCA, T_PESTANA - 0.01, ALTO_ROSCA_TAPA)
    tope = T_PESTANA + ALTO_ROSCA_TAPA
    t ^= cil(R_PESTANA + 2, -1, tope - 2.6) + cono(R_PESTANA + 2, R_ROSCA - 0.2, tope - 2.6, tope)  # punta en chaflán
    t -= cil(R_TAPA_INT, T_TAPA, tope + 1)                               # hueco
    t += cil(9.0, T_TAPA - 0.01, Z_PILA - G['apoyo_pila'])              # apoyo de la pila
    ranura = m3.CrossSection.square((14, 1.6), True).extrude(1.2).translate((0, 0, -0.2))
    t -= ranura                                                          # para abrir con una moneda
    for k in range(8):                                                   # salida de sonido
        a = math.radians(22.5 + 45 * k)
        t -= cil(0.9, -1, T_TAPA + 1).translate((14.5 * math.cos(a), 14.5 * math.sin(a), 0))
    t -= logotipo(17, espejo=True).translate((0, -8.2)).extrude(0.7).translate((0, 0, -0.2))  # «relevo», legible desde abajo
    return t

# ---------------------------------------------------------------- Chasis (se ajusta a la placa del Tag)
def chasis():
    r_s = P['diametro'] / 2 + G['placa']
    r_v = min(P['diametro'] / 2 - 1.0, R_REBAJE)
    ch = cil(R_CHASIS, Z_CHASIS, Z_C)
    ch -= cil(r_s, Z_CHASIS - 1, Z_P)                                    # falda que centra la placa
    ch -= cil(r_v, Z_P - 0.01, Z_C + 1)                                  # ventana para los componentes
    ch -= cil(R_REBAJE, Z_C - T_FONDO - RECORRIDO, Z_C + 1)              # rebaje donde se mueve el medallón
    return ch

# ---------------------------------------------------------------- Medallón: placa calada y fondo
PERNOS = [(12.3, 30.0), (12.3, 170.0)]   # asimétricos: el fondo solo calza en una posición

def _pernos(r, z0, z1):
    return m3.Manifold.batch_boolean([cil(r, z0, z1, 48).translate((d * math.cos(math.radians(a)), d * math.sin(math.radians(a)), 0)) for d, a in PERNOS], m3.OpType.Add)

def placa_medallon():
    pl = cil(R_MED, Z_C, H)
    for luz in luces(LOGO_D):
        pl -= luz.extrude(T_TECHO + 2).translate((0, 0, Z_C - 1))        # luces caladas
    return pl + _pernos(0.8, Z_C - 0.7, Z_C + 0.01)

def fondo_medallon():
    f = cil(R_FONDO, Z_TOPE, Z_C) + cil(2.0, Z_PUNTA, Z_TOPE + 0.01)
    return f - _pernos(0.95, Z_C - 0.9, Z_C + 1)

def fondo_colores():
    """El fondo partido para el AMS: cada luz, con 0,45 mm de margen bajo la placa, en su color."""
    f = fondo_medallon()
    piezas = []
    for luz in luces(LOGO_D):
        zona = (luz.offset(0.45, m3.JoinType.Round) ^ circulo(R_FONDO - 0.5)).extrude(0.4).translate((0, 0, Z_C - 0.4))
        piezas.append(zona ^ f)
    base = f - m3.Manifold.batch_boolean(piezas, m3.OpType.Add)
    return base, piezas

# ---------------------------------------------------------------- Módulo del Tag (solo para las vistas)
def modulo():
    pcb = cil(P['diametro'] / 2, Z_P - P['grosor'], Z_P)
    pila = cil(10.0, Z_PILA, Z_P - P['grosor'])
    boton = m3.Manifold.cube((3.0, 4.0, P['alto_boton']), True).translate((0, 0, Z_P + P['alto_boton'] / 2))
    return pcb, pila, boton

# ---------------------------------------------------------------- Salida
def malla(man):
    me = man.to_mesh()
    return trimesh.Trimesh(np.array(me.vert_properties)[:, :3], np.array(me.tri_verts), process=True)

def boca_abajo(man, z_arriba):
    """Gira 180° sobre X (no espeja) y apoya en la cama la cara que estaba en z_arriba."""
    return man.rotate((180, 0, 0)).translate((0, 0, z_arriba))

def guardar(man, ruta):
    os.makedirs(os.path.dirname(ruta), exist_ok=True)
    malla(man).export(ruta)

if __name__ == '__main__':
    piezas = {'cuerpo': cuerpo(), 'tapa': tapa(), 'chasis': chasis(),
              'medallon-placa': placa_medallon(), 'medallon-fondo': fondo_medallon()}
    pcb, pila, boton = modulo()
    base_m, colores_m = fondo_colores()
    montaje = dict(piezas, **{'tag-placa': pcb, 'tag-pila': pila, 'tag-boton': boton, 'fondo-base': base_m},
                   **{f'fondo-luz-{i + 1}': p for i, p in enumerate(colores_m)})
    escena_m = trimesh.Scene()
    for n, p in montaje.items():
        assert p.status() == m3.Error.NoError and not p.is_empty(), n
        guardar(p, os.path.join(AQUI, 'vistas', '_piezas', n + '.stl'))     # para las vistas; no se suben
        if not n.startswith('fondo-'):
            escena_m.add_geometry(malla(p), node_name=n, geom_name=n)
    os.makedirs(os.path.join(AQUI, 'montaje'), exist_ok=True)
    escena_m.export(os.path.join(AQUI, 'montaje', 'testigo-montado.3mf'))

    # Orientación de impresión: cuerpo, placa y fondo boca abajo (su cara visible sobre la cama).
    impresion = {'cuerpo': boca_abajo(piezas['cuerpo'], H),
                 'medallon-placa': boca_abajo(piezas['medallon-placa'], H),
                 'medallon-fondo': boca_abajo(piezas['medallon-fondo'], Z_C),
                 'tapa': piezas['tapa'],
                 'chasis': piezas['chasis'].translate((0, 0, -Z_CHASIS))}
    for n, p in impresion.items():
        guardar(p, os.path.join(AQUI, 'imprimir', n + '.stl'))
    base, colores = fondo_colores()
    nombres = ['luz-1-tiempo-amarillo', 'luz-2-primer-paso-celeste', 'luz-3-lugar-verde-lima', 'luz-4-decision-rosado']
    guardar(boca_abajo(base, Z_C), os.path.join(AQUI, 'imprimir', 'medallon-fondo-cuatro-colores', 'base.stl'))
    for n, p in zip(nombres, colores):
        guardar(boca_abajo(p, Z_C), os.path.join(AQUI, 'imprimir', 'medallon-fondo-cuatro-colores', n + '.stl'))
    # Pruebas de calce: la boca con la rosca (6,4 mm) y el techo con la ventana (3 mm), impresos como el cuerpo.
    c = piezas['cuerpo']
    guardar(boca_abajo(c ^ cil(R_EXT + 1, -1, 6.4), 6.4), os.path.join(AQUI, 'imprimir', 'prueba-de-calce', 'rosca.stl'))
    guardar(boca_abajo(c ^ cil(R_EXT + 1, H - 3.0, H + 1), H), os.path.join(AQUI, 'imprimir', 'prueba-de-calce', 'medallon.stl'))

    # Un plato con las cinco piezas de un color, separadas, para abrir directo en Bambu Studio.
    escena = trimesh.Scene()
    sitios = {'cuerpo': (-35, 35), 'tapa': (35, 35), 'chasis': (-35, -35), 'medallon-placa': (25, -30), 'medallon-fondo': (55, -30)}
    for n, (x, y) in sitios.items():
        mm = malla(impresion[n]); mm.apply_translation((128 + x, 128 + y, 0))
        escena.add_geometry(mm, node_name=n, geom_name=n)
    escena.export(os.path.join(AQUI, 'imprimir', 'testigo-un-color.3mf'))

    # Resumen
    print(f'Alto total {H:.1f} mm, diámetro {2 * R_EXT:.0f} mm')
    print(f'Techo abajo {Z_C:.2f} | placa del Tag arriba {Z_P:.2f} | pila abajo {Z_PILA:.2f} | apoyo de la tapa {Z_PILA - T_TAPA:.2f} mm de alto')
    total = 0
    for n, p in piezas.items():
        v = p.volume() / 1000; total += v
        print(f'{n:16s} {v:6.2f} cm³  ≈ {v * 1.24:5.1f} g de PLA (macizo)')
    print(f'{"total":16s} {total:6.2f} cm³  ≈ {total * 1.24:5.1f} g de PLA (macizo)')
