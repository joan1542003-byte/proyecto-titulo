#!/usr/bin/env python3
"""Relevo, versión 1: Relevo Home y Relevo Go, con un núcleo común para la placa y la pila del Tag.

Lee medidas.json, arma las piezas con geometría sólida (manifold3d) y escribe:
  imprimir/nucleo/*.stl   chasis, pulsador y tapa: iguales en Home y en Go
  imprimir/home/*.stl     base y cúpula de Home (cúpula en cinco cuerpos para el AMS y en un color)
  imprimir/go/*.stl       base y cúpula de Go
  montaje/*.3mf           cada variante armada, con la placa y la pila como volúmenes de referencia
Todas las piezas de imprimir/ ya están orientadas para imprimir sin soportes.

Uso:  python3 -m venv venv && venv/bin/pip install manifold3d trimesh numpy networkx lxml
      venv/bin/python modelo.py
"""
import json
import math
import os
import re

import manifold3d as m3
import numpy as np
import trimesh

AQUI = os.path.dirname(os.path.abspath(__file__))
D = json.load(open(os.path.join(AQUI, 'medidas.json'), encoding='utf8'))
P = {k: v['valor'] for k, v in D['placa'].items()}
G = {k: v['valor'] for k, v in D['holguras'].items()}
N = {k: v['valor'] for k, v in D['nucleo'].items()}
SEG = 192
m3.set_circular_segments(SEG)
COLORES = ['tiempo-amarillo', 'primer-paso-celeste', 'lugar-verde-lima', 'decision-rosado']

# ---------------------------------------------------------------- Núcleo: radios, de adentro hacia afuera
R_PLACA = P['diametro'] / 2
R_BORE = R_PLACA + G['placa']                 # falda del chasis que centra la placa
R_CH = R_BORE + N['pared']                    # exterior del chasis
R_VENT = R_PLACA - 1.0                        # ventana del chasis sobre los componentes
R_PATA_IN = R_CH + G['juego']                 # patas del pulsador, por fuera del chasis
R_PATA_OUT = R_PATA_IN + 0.8
R_REPISA = R_PATA_OUT + G['juego']            # agujero de la repisa de la base
R_PESTANA = R_REPISA + N['solape']            # pestañas del pulsador y postes del chasis
R_PASO = R_PESTANA + G['juego']               # por aquí entran pulsador y chasis desde abajo
R_ROSCA = R_PASO - G['rosca']                 # radio menor de la rosca de la tapa
PASO, PROF = N['paso_rosca'], N['profundidad_rosca']
R_ROSCA_MAYOR = R_ROSCA + PROF + G['rosca']   # fondo de la rosca en la base
ANG_POSTES = (90.0, 210.0, 330.0)            # el poste de 90° queda hacia +y (la punta de Go)
ANG_PATAS = (30.0, 150.0, 270.0)              # la pata de 270° queda entre las trabas de Go, opuesta a la punta

# ---------------------------------------------------------------- Núcleo: alturas, de abajo hacia arriba
RECORRIDO = G['boton'] + P['recorrido_boton'] + 0.05   # cuánto baja la cúpula; el tope protege el botón
T_TAPA = N['piso_tapa']
Z_PILA = T_TAPA - G['apoyo_pila']             # cara de afuera de la pila
Z_PB = Z_PILA + P['alto_bajo_placa']          # cara de abajo de la placa
Z_P = Z_PB + P['grosor']                      # cara de arriba de la placa
Z_COMP = Z_P + P['alto_componentes']
S = Z_COMP + G['componentes'] + RECORRIDO     # cara de abajo de la cúpula = cara de abajo de los rayos
Z_BASE = S - RECORRIDO                        # cara de arriba de la base: la junta mide RECORRIDO
Z_REPISA = Z_BASE - N['repisa']               # cara de abajo de la repisa
Z_EMB = Z_P + P['alto_boton'] + G['boton']    # punta del émbolo
Z_CH = Z_PB - 0.6                             # cara de abajo del chasis = tope de la tapa
Z_CH_TOP = Z_P + 1.0
Z_ROSCA0 = 0.8                                 # la rosca de la tapa empieza 1 mm sobre su cara de afuera
ENTRADA = 0.5                                  # chaflán de entrada de la rosca de la base, que llega hasta la cara de abajo

def cil(r, z0, z1, n=SEG):
    return m3.Manifold.cylinder(z1 - z0, r, r, n).translate((0, 0, z0))

def cono(r0, r1, z0, z1, n=SEG):
    return m3.Manifold.cylinder(z1 - z0, r0, r1, n).translate((0, 0, z0))

def circulo(r, x=0.0, y=0.0, n=SEG):
    return m3.CrossSection.circle(r, n).translate((x, y))

def revolucion(perfil):
    return m3.Manifold.revolve(m3.CrossSection([perfil]), SEG)

def franja(ancho, largo, ang):
    """Rectángulo que sale del centro hacia el ángulo dado (grados)."""
    return m3.CrossSection.square((largo, ancho)).translate((0, -ancho / 2)).rotate(ang)

def sector(r0, r1, ang, ancho):
    return (circulo(r1) - circulo(r0)) ^ franja(ancho, r1 + 2, ang)

def arco(cx, cz, r, a0, a1, n=24):
    return [(cx + r * math.cos(math.radians(a)), cz + r * math.sin(math.radians(a))) for a in np.linspace(a0, a1, n)]

def rosca(r_menor, z0, alto, holgura=0.0, n=96):
    """Rosca derecha con flancos de 45°, por extrusión con giro (mismo método que la versión 0)."""
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
    return m3.CrossSection([pts]).extrude(alto, round(vueltas * n) - 1, 360 * vueltas).translate((0, 0, z0))

# ---------------------------------------------------------------- Marca
def formas_del_logo(diametro):
    """Las cuatro formas de color de la marca chica (como en la versión 0): círculos de radio 29 a 21 del centro, en una
    unidad de 100, cada uno recortado por el siguiente agrandado a 35,5. Tiempo arriba (+y), luego en el
    sentido del reloj: primer paso, lugar y decisión. Es la orientación de relevo-marca-chica.svg mirada desde arriba;
    en Go, el tiempo apunta a la punta, así que el logo queda derecho cuando cuelga de la argolla."""
    k = diametro / 100
    c = [(0, 21), (21, 0), (0, -21), (-21, 0)]
    return [circulo(29 * k, x * k, y * k, 256) - circulo(35.5 * k, c[(i + 1) % 4][0] * k, c[(i + 1) % 4][1] * k, 256)
            for i, (x, y) in enumerate(c)]

def logotipo(ancho, espejo=False):
    """La palabra «relevo» del SVG oficial, copiado en la carpeta de la versión 0."""
    d = re.search(r' d="([^"]+)"', open(os.path.join(AQUI, '..', 'relevo-logotipo.svg'), encoding='utf8').read()).group(1)
    f = re.findall(r'[MLCZ]|-?\d*\.?\d+', d)
    cont, act, i, p = [], [], 0, (0.0, 0.0)
    while i < len(f):
        t = f[i]; i += 1
        if t == 'M':
            if act: cont.append(act)
            p = (float(f[i]), float(f[i + 1])); i += 2; act = [p]
        elif t == 'L':
            p = (float(f[i]), float(f[i + 1])); i += 2; act.append(p)
        elif t == 'C':
            c1 = (float(f[i]), float(f[i + 1])); c2 = (float(f[i + 2]), float(f[i + 3])); q = (float(f[i + 4]), float(f[i + 5])); i += 6
            for s in np.linspace(0, 1, 13)[1:]:
                a, b, c, e = (1 - s) ** 3, 3 * (1 - s) ** 2 * s, 3 * (1 - s) * s ** 2, s ** 3
                act.append((a * p[0] + b * c1[0] + c * c2[0] + e * q[0], a * p[1] + b * c1[1] + c * c2[1] + e * q[1]))
            p = q
        elif t == 'Z':
            if act: cont.append(act); act = []
        else:
            p = (float(t), float(f[i])); i += 1; act.append(p)
    if act: cont.append(act)
    xs = [x for c in cont for x, _ in c]; ys = [y for c in cont for _, y in c]
    k = ancho / (max(xs) - min(xs)); cx = (max(xs) + min(xs)) / 2; cy = (max(ys) + min(ys)) / 2
    s = -1 if espejo else 1
    return m3.CrossSection([[(s * (x - cx) * k, -(y - cy) * k) for x, y in c] for c in cont], m3.FillRule.EvenOdd)

# ---------------------------------------------------------------- Núcleo: chasis, pulsador y tapa
def chasis():
    cuerpo = revolucion([(R_BORE, Z_CH), (R_CH, Z_CH), (R_CH, Z_CH_TOP), (R_VENT, Z_CH_TOP),
                         (R_BORE, Z_P - (R_BORE - R_PLACA))])          # cono a 45°: toca el canto de la placa en Z_P
    postes = [sector(R_CH - 0.4, R_PESTANA, a, N['ancho_poste']).extrude(Z_REPISA - Z_CH).translate((0, 0, Z_CH))
              for a in ANG_POSTES]
    return m3.Manifold.batch_boolean([cuerpo] + postes, m3.OpType.Add)

def pulsador():
    zt = S + N['canal']
    partes = [cil(N['radio_embolo'], Z_EMB, zt, 64)]
    for a in ANG_PATAS:
        partes.append(franja(N['ancho_rayo'], R_PATA_OUT - 0.2, a).extrude(N['canal']).translate((0, 0, S)))
        partes.append(sector(R_PATA_IN, R_PATA_OUT, a, N['ancho_pata']).extrude(zt - (Z_REPISA - 0.8)).translate((0, 0, Z_REPISA - 0.8)))
        partes.append(sector(R_PATA_IN + 0.2, R_PESTANA, a, N['ancho_pata']).extrude(0.8).translate((0, 0, Z_REPISA - 0.8)))
    return m3.Manifold.batch_boolean(partes, m3.OpType.Add)

def tapa():
    r_in = R_ROSCA - N['pared']
    t = cil(R_ROSCA - 0.05, 0, Z_CH) - cil(r_in, T_TAPA, Z_CH + 1)
    largo = Z_CH - 0.2 - Z_ROSCA0 - 0.2
    t += rosca(R_ROSCA, Z_ROSCA0 + 0.2, largo) - cil(r_in + 0.1, Z_ROSCA0, Z_CH + 1)
    zs, cresta = Z_ROSCA0 + 0.2, R_ROSCA + PROF + 0.1        # la rosca nace y termina a 45°: sin voladizos
    t ^= (cil(R_ROSCA - 0.05, -1, zs + 0.01) + cono(R_ROSCA - 0.05, cresta, zs, zs + cresta - R_ROSCA + 0.05)
          + cil(cresta, zs + cresta - R_ROSCA, Z_CH - 0.9) + cono(cresta, R_ROSCA - 0.05, Z_CH - 0.91, Z_CH))
    t -= m3.CrossSection.square((12, 1.6), True).extrude(0.9).translate((0, 0, -0.2))          # ranura para la moneda
    t -= logotipo(10, espejo=True).translate((0, -9.0)).extrude(0.6).translate((0, 0, -0.2))  # «relevo», leído desde abajo
    if Z_PILA < T_TAPA:
        t -= cil(10.4, Z_PILA, T_TAPA + 1)
    return t

# ---------------------------------------------------------------- Variantes: cúpula y base
def perfil_cupula(R, alto, lado, rc, ch, meseta=0.0):
    """Perfil (r, z) de la cúpula: meseta plana al centro (donde va el logo), abombado de radio grande y canto
    redondo, todos tangentes entre sí, sobre una cara de apoyo plana."""
    a, b = R - rc - meseta, lado - alto
    rd = (rc * rc - a * a - b * b) / (2 * (b + rc))           # radio del abombado, tangente a la meseta y al canto
    cz = alto - rd
    u = np.array([a, lado - cz]) / (rd - rc)
    ang = math.degrees(math.atan2(u[1], u[0]))
    pts = [(0, 0), (R - ch, 0), (R, ch), (R, lado)] + arco(R - rc, lado, rc, 0, ang, 20)[1:]
    a1 = math.degrees(math.atan2(pts[-1][1] - cz, pts[-1][0] - meseta))
    pts += [(meseta + x, z) for x, z in arco(0, cz, rd, a1, 90, 60)[1:]]
    pts[-1] = (meseta, alto)
    if meseta > 0:
        pts.append((0, alto))
    return pts, rd

def cupula(v):
    """Cúpula en coordenadas de uso: devuelve (cuerpo, cuatro incrustaciones, versión en un color con relieve)."""
    R, alto = v['R'], v['alto_cupula']
    pts, v['radio_abombado'] = perfil_cupula(R, alto, v['lado_cupula'], v['radio_canto_cupula'], N['chaflan'], v['radio_meseta'])
    c = revolucion(pts)
    # Canales de abajo: aquí van pegados los rayos, las patas y el émbolo del pulsador.
    canales = [circulo(N['radio_embolo'] + 0.15, n=64)]
    for a in ANG_PATAS:
        canales.append(franja(N['ancho_rayo'] + 0.3, R_PATA_OUT, a))
        canales.append(sector(R_PATA_IN - 0.15, R_PATA_OUT + 0.15, a, N['ancho_pata'] + 0.3))
    c -= m3.CrossSection.batch_boolean(canales, m3.OpType.Add).extrude(N['canal'] + 1.05).translate((0, 0, -1))
    # El logo va en la meseta plana: incrustado a ras, 0,4 mm de hondo, o en relieve de 0,3 mm en la versión de un color.
    formas = formas_del_logo(v['diametro_logo'])
    incrust = [l.extrude(0.4).translate((0, 0, alto - 0.4)) for l in formas]
    cuerpo = c - m3.Manifold.batch_boolean([l.extrude(1.4).translate((0, 0, alto - 0.4)) for l in formas], m3.OpType.Add)
    un_color = c + m3.Manifold.batch_boolean([l.extrude(0.4).translate((0, 0, alto - 0.1)) for l in formas], m3.OpType.Add)
    sube = lambda m: m.translate((0, 0, S))
    return sube(cuerpo), [sube(i) for i in incrust], sube(un_color)

def perfil_base(v):
    """Perfil exterior (r, z) de la base: canto de abajo redondo y lado inclinado hasta la junta."""
    rr, inc, ch = v['radio_canto_inferior'], v['inclinacion_lado'], N['chaflan']
    av = v.get('alto_canto_inferior', rr)                     # canto elíptico: rr de ancho y av de alto
    cx = v['R_pie'] - rr
    t1 = math.degrees(math.atan((av / rr) * math.tan(math.radians(inc))))
    pts = [(0, 0), (cx, 0)] + [(cx + rr * math.cos(math.radians(t)), av + av * math.sin(math.radians(t))) for t in np.linspace(-90, t1, 28)][1:]
    x1, z1 = pts[-1]
    r_junta = x1 - (Z_BASE - ch - z1) * math.tan(math.radians(inc))
    pts += [(r_junta, Z_BASE - ch), (r_junta - ch, Z_BASE), (0, Z_BASE)]
    return pts, r_junta

def contorno_gota(v, h=0.0):
    """Planta de Go, una gota como el llavero del boceto: el círculo del cuerpo, dos lados convexos de radio grande y la
    punta, redonda y concéntrica con el agujero de la argolla, todos tangentes entre sí. h la mete hacia adentro con los
    mismos centros y radios h menores: así se dibuja el canto, igual en todo el contorno."""
    g = v['gota']
    d, R, rt, Rs = g['distancia_agujero'], v['R_pie'] - h, g['radio_punta'] - h, g['radio_lados'] - h
    yc = (d * d - (Rs - rt) ** 2 + (Rs - R) ** 2) / (2 * d)     # centro del lado derecho: toca por dentro los dos círculos
    xc = -math.sqrt((Rs - R) ** 2 - yc ** 2)
    a_cuerpo = math.degrees(math.atan2(-yc, -xc))               # las tangencias, vistas desde ese centro
    a_punta = math.degrees(math.atan2(d - yc, -xc))
    paso = 360 / SEG
    mitad = arco(0, 0, R, -90, a_cuerpo, max(4, round((a_cuerpo + 90) / paso)))
    mitad += arco(xc, yc, Rs, a_cuerpo, a_punta, 48)[1:]
    mitad += arco(0, d, rt, a_punta, 90, max(8, round(2 * (90 - a_punta) / paso)))[1:]
    return m3.CrossSection([mitad + [(-x, y) for x, y in reversed(mitad[1:-1])]])

def cuerpo_gota(v):
    """Sólido exterior de la base de Go: la gota con el alto entero de la base y el mismo canto en todo el contorno,
    elíptico abajo y con chaflán en la junta. La gota es convexa, así que basta la envolvente de sus capas."""
    rr, av, ch = v['radio_canto_inferior'], v['alto_canto_inferior'], N['chaflan']
    capa = lambda h, z: contorno_gota(v, h).extrude(0.001).translate((0, 0, z))
    capas = [capa(rr - rr * math.cos(math.radians(t)), av + av * math.sin(math.radians(t))) for t in np.linspace(-90, 0, 28)]
    capas += [capa(0.0, Z_BASE - ch - 0.001), capa(ch, Z_BASE - 0.001)]
    return m3.Manifold.batch_hull(capas)

def agujero_argolla(v):
    """Agujero vertical de la argolla, en la punta, con chaflán de 45° en las dos bocas."""
    g = v['gota']
    ra, ca = g['radio_agujero'], g['chaflan_agujero']
    return (cil(ra, -1, Z_BASE + 1, 64) + cono(ra + ca, ra, -0.01, ca, 64)
            + cono(ra, ra + ca, Z_BASE - ca, Z_BASE + 0.01, 64)).translate((0, g['distancia_agujero'], 0))

def traba_de_giro(v):
    """Dos trabas en la repisa de Go, a los lados de la pata de 270° (la opuesta a la punta), con el mismo juego que las
    demás piezas móviles: la cúpula ya no gira y el logo queda derecho respecto de la punta."""
    w, a = v['traba_de_giro']['ancho'], 270.0
    off = N['ancho_pata'] / 2 + G['juego']
    r0, r1 = R_PATA_IN, R_REPISA + 0.4                                  # cruza todo el ancho de la pata y entra en la repisa
    trabas = [m3.CrossSection.square((r1 - r0, w)).translate((r0, s * (off + w / 2) - w / 2)).rotate(a) for s in (-1, 1)]
    return m3.CrossSection.batch_boolean(trabas, m3.OpType.Add).extrude(Z_BASE - Z_REPISA).translate((0, 0, Z_REPISA))

def base(v):
    pts, v['R'] = perfil_base(v)
    b = cuerpo_gota(v) if 'gota' in v else revolucion(pts)
    zf = Z_ROSCA0 + 0.2 - 2 * PASO                                    # dos pasos bajo la de la tapa: hélices en fase
    b -= rosca(R_ROSCA, zf, Z_CH - zf, G['rosca'])                   # llega hasta abajo: la tapa entra girando
    b -= cil(R_PASO, -1, Z_REPISA)
    b -= cono(R_ROSCA_MAYOR + 0.1, R_ROSCA_MAYOR - 0.3, -0.01, 0.4)   # chaflán de entrada, corto: no afina el borde de Go
    b -= cil(R_REPISA, Z_REPISA - 0.01, Z_BASE + 1)
    if 'gota' in v:
        b -= agujero_argolla(v)
    if 'traba_de_giro' in v:
        b += traba_de_giro(v)
    if 'goma' in v:
        g = v['goma']
        b -= cil(g['radio_exterior'], -1, g['profundidad']) - cil(g['radio_interior'], -2, g['profundidad'] + 1)
    return b

def variante(nombre):
    raw = D['variantes'][nombre]
    v = {k: (x['valor'] if isinstance(x, dict) and 'valor' in x else x) for k, x in raw.items()}
    if nombre == 'go':   # el diámetro mínimo, en pasos de 0,5 mm, que deja la pared mínima junto al comienzo de la rosca
        rr, av = v['radio_canto_inferior'], v['alto_canto_inferior']
        R = math.ceil((R_ROSCA_MAYOR + v['radio_minimo_pared']) * 2) / 2
        while R - rr + rr * math.sqrt(max(0.0, 1 - ((av - ENTRADA) / av) ** 2)) - R_ROSCA_MAYOR < v['radio_minimo_pared']:
            R += 0.5
        v['R_pie'] = R
        v['gota']['distancia_agujero'] = R + v['gota']['separacion_agujero']
    else:
        v['R_pie'] = v['radio_pie']
    v['nombre'] = nombre
    piezas = {'base': base(v)}
    cuerpo, incrust, un_color = cupula(v)
    piezas['cupula'] = cuerpo
    piezas.update({f'cupula-color-{i + 1}': m for i, m in enumerate(incrust)})
    piezas['cupula-un-color'] = un_color
    v['H'] = S + v['alto_cupula']
    return v, piezas

# ---------------------------------------------------------------- Tag de referencia (solo para vistas y comprobaciones)
def modulo():
    pcb = cil(R_PLACA, Z_PB, Z_P)
    pila = cil(10.0, Z_PILA, Z_PB)
    boton = m3.Manifold.cube((3.0, 4.0, P['alto_boton']), True).translate((0, 0, Z_P + P['alto_boton'] / 2))
    comp = m3.Manifold.cube((8.0, 5.0, P['alto_componentes']), True).translate((6.5, -3.0, Z_P + P['alto_componentes'] / 2))
    return {'tag-placa': pcb, 'tag-pila': pila, 'tag-boton': boton, 'tag-componente': comp}

def tag_completo(diam=38.0, alto=7.0):
    """El Tag como lo describe el vendedor (38 × 7 mm): disco abombado con junta cerca de la base."""
    pts, _ = perfil_cupula(diam / 2, alto - 1.6, 1.2, 2.2, 0.3)
    arriba = revolucion(pts).translate((0, 0, 1.6))
    abajo = revolucion([(0, 0), (diam / 2 - 1.0, 0)] + arco(diam / 2 - 1.0, 1.0, 1.0, -90, 0, 10)[1:] + [(diam / 2, 1.45), (0, 1.45)])
    return abajo + arriba

# ---------------------------------------------------------------- Salida
def malla(man, dec=4):
    """Malla para exportar. Las uniones de caras coplanares dejan triángulos de grosor casi nulo que, al guardar en
    STL (precisión simple), funden vértices y abren el sólido: se funden aquí a 0,1 µm y se quitan los pares de
    triángulos que quedan repetidos."""
    me = man.to_mesh()
    v = np.round(np.array(me.vert_properties)[:, :3].astype(np.float64), dec)
    u, inv = np.unique(v, axis=0, return_inverse=True)
    f = inv.reshape(-1)[np.array(me.tri_verts)]
    f = f[(f[:, 0] != f[:, 1]) & (f[:, 1] != f[:, 2]) & (f[:, 0] != f[:, 2])]
    _, idx, cuenta = np.unique(np.sort(f, axis=1), axis=0, return_inverse=True, return_counts=True)
    f = f[cuenta[idx.reshape(-1)] == 1]
    t = trimesh.Trimesh(u, f, process=False)
    t.remove_unreferenced_vertices()
    return t

def guardar(man, ruta):
    os.makedirs(os.path.dirname(ruta), exist_ok=True)
    malla(man).export(ruta)

def boca_abajo(man, z_arriba):
    """Gira 180° sobre X (no espeja) y apoya en la cama la cara que estaba en z_arriba."""
    return man.rotate((180, 0, 0)).translate((0, 0, z_arriba))

def nucleo():
    return {'chasis': chasis(), 'pulsador': pulsador(), 'tapa': tapa()}

def para_imprimir(nombre, man):
    """Orientación de impresión de cada pieza (todas sin soportes)."""
    if nombre == 'chasis':
        return man.translate((0, 0, -Z_CH))                  # de pie, sobre su cara de abajo
    if nombre == 'pulsador':
        return boca_abajo(man, S + N['canal'])                # sobre la cara que se pega
    if nombre == 'tapa':
        return man                                            # sobre la cara de afuera
    if nombre == 'base':
        return boca_abajo(man, Z_BASE)                        # sobre la cara de la junta
    if nombre.startswith('cupula'):
        return man.translate((0, 0, -S))                      # de pie, sobre su cara plana
    raise ValueError(nombre)

def resumen_alturas():
    return {'Z_PILA': Z_PILA, 'Z_PB': Z_PB, 'Z_P': Z_P, 'Z_COMP': Z_COMP, 'S': S, 'Z_BASE': Z_BASE, 'Z_REPISA': Z_REPISA,
            'Z_EMB': Z_EMB, 'Z_CH': Z_CH, 'RECORRIDO': RECORRIDO, 'R_CH': R_CH, 'R_REPISA': R_REPISA, 'R_PASO': R_PASO,
            'R_ROSCA': R_ROSCA, 'R_ROSCA_MAYOR': R_ROSCA_MAYOR}

if __name__ == '__main__':
    import comprobar
    nuc = nucleo()
    variantes = {n: variante(n) for n in ('home', 'go')}
    for n, p in nuc.items():
        guardar(para_imprimir(n, p), os.path.join(AQUI, 'imprimir', 'nucleo', n + '.stl'))
    for nv, (v, piezas) in variantes.items():
        guardar(para_imprimir('base', piezas['base']), os.path.join(AQUI, 'imprimir', nv, 'base.stl'))
        guardar(para_imprimir('cupula', piezas['cupula-un-color']), os.path.join(AQUI, 'imprimir', nv, 'cupula-un-color.stl'))
        carpeta = os.path.join(AQUI, 'imprimir', nv, 'cupula-cuatro-colores')
        guardar(para_imprimir('cupula', piezas['cupula']), os.path.join(carpeta, 'cupula-cuerpo.stl'))
        for i, c in enumerate(COLORES):
            guardar(para_imprimir('cupula', piezas[f'cupula-color-{i + 1}']), os.path.join(carpeta, f'color-{i + 1}-{c}.stl'))
        escena = trimesh.Scene()
        for n, p in dict(nuc, base=piezas['base'], cupula=piezas['cupula-un-color'], **modulo()).items():
            escena.add_geometry(malla(p), node_name=n, geom_name=n)
        os.makedirs(os.path.join(AQUI, 'montaje'), exist_ok=True)
        escena.export(os.path.join(AQUI, 'montaje', f'relevo-{nv}-montado.3mf'))
    comprobar.todo(nuc, variantes)
