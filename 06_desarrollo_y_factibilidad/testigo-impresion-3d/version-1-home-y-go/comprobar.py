#!/usr/bin/env python3
"""Comprobaciones de la versión 1: sólidos cerrados, calce con la placa supuesta, choques en reposo y con la
cúpula apretada, voladizos al imprimir, gramos y costo de material. Lo llama modelo.py al final y escribe
comprobaciones.json."""
import json
import math
import os

import manifold3d as m3
import numpy as np
import trimesh

import modelo as M

PLA = 1.24                      # g/cm³, el mismo valor de la versión 0
PRECIO_KG = (9690, 13890)       # CLP por rollo de 1 kg (presupuesto del 27 de octubre, TodoToner, s. f.)

def cerrado(ruta):
    t = trimesh.load(ruta, force='mesh')
    return bool(t.is_watertight and t.is_winding_consistent and t.volume > 0), float(t.volume)

def voladizos(man, lim=47.0):
    """Caras que miran hacia abajo más de lim grados desde la vertical, fuera de la cama, agrupadas por altura."""
    t = M.malla(man)
    nz = t.face_normals[:, 2]
    zc = t.triangles[:, :, 2]
    sel = (nz < -math.sin(math.radians(lim))) & (zc.min(axis=1) > 0.01)
    grupos = {}
    for i in np.nonzero(sel)[0]:
        z = round(float(zc[i].mean()), 2)
        g = grupos.setdefault(z, {'area': 0.0, 'pts': []})
        g['area'] += float(t.area_faces[i]); g['pts'].append(t.triangles[i][:, :2])
    out = []
    for z, g in sorted(grupos.items()):
        if g['area'] < 0.05:
            continue
        pts = np.concatenate(g['pts'])
        out.append({'z': z, 'area_mm2': round(g['area'], 2), 'caja_mm': [round(float(x), 1) for x in pts.max(0) - pts.min(0)]})
    return out

def choque(a, b):
    return (a ^ b).volume()

def quiebre_maximo(seccion):
    """Mayor giro, en grados, entre dos tramos seguidos del contorno: en una curva con tangentes continuas no pasa del
    paso de la discretización; un quiebre lo haría saltar."""
    p = np.array(seccion.to_polygons()[0])
    t = np.roll(p, -1, axis=0) - p
    a = np.degrees(np.arctan2(t[:, 1], t[:, 0]))
    giro = (np.roll(a, -1) - a + 180) % 360 - 180
    return float(np.abs(giro).max())

def giro_libre(pulsador, base, paso=0.1, tope=5.0):
    """Cuánto puede girar el pulsador (y con él la cúpula) antes de tocar la base, en grados, hacia cada lado."""
    libre = []
    for signo in (1, -1):
        a = 0.0
        while a + paso <= tope and choque(pulsador.rotate((0, 0, signo * (a + paso))), base) <= 1e-3:
            a += paso
        libre.append(round(a, 1))
    return libre

def todo(nuc, variantes):
    res = {'alturas': {k: round(v, 3) for k, v in M.resumen_alturas().items()}, 'variantes': {}}
    mod = M.modulo()
    bajar = lambda m, d: m.translate((0, 0, -d))
    errores = []
    for nv, (v, piezas) in variantes.items():
        r = {'diametro_pie': round(2 * v['R_pie'], 2), 'diametro_junta': round(2 * v['R'], 2), 'alto': round(v['H'], 2),
             'radio_abombado': round(v['radio_abombado'], 1)}
        if 'gota' in v:
            g, bb = v['gota'], piezas['base'].bounding_box()
            r['ancho'], r['largo'] = round(bb[3] - bb[0], 2), round(bb[4] - bb[1], 2)
            borde_agujero = g['distancia_agujero'] - g['radio_agujero'] - g['chaflan_agujero']
            r['gota'] = {'centro_del_agujero_desde_el_centro': round(g['distancia_agujero'], 2),
                         'base_lisa_entre_cupula_y_agujero': round(borde_agujero - v['R'], 2),
                         'material_entre_agujero_y_punta': round(g['radio_punta'] - g['radio_agujero'], 2),
                         'material_entre_agujero_y_rosca': round(borde_agujero - (M.R_ROSCA_MAYOR + 0.1), 2),
                         'quiebre_maximo_del_contorno_grados': round(quiebre_maximo(M.contorno_gota(v)), 2)}
        if 'traba_de_giro' in v:
            r['cupula_gira_libre_grados'] = giro_libre(nuc['pulsador'], piezas['base'])
            if max(r['cupula_gira_libre_grados']) >= 5.0:
                errores.append(f'{nv}: la traba de giro no detiene la cúpula')
        fijas = {'base': piezas['base'], 'chasis': nuc['chasis'], 'tapa': nuc['tapa'], 'tag-placa': mod['tag-placa'],
                 'tag-pila': mod['tag-pila'], 'tag-componente': mod['tag-componente']}
        moviles = {'pulsador': nuc['pulsador'], 'cupula': piezas['cupula-un-color']}
        for estado, d in (('arriba', 0.0), ('en reposo', M.G['boton']), ('apretado a fondo', M.RECORRIDO)):
            todas = dict(fijas, **{k: bajar(m, d) for k, m in moviles.items()})
            nombres = list(todas)
            for i in range(len(nombres)):
                for j in range(i + 1, len(nombres)):
                    vol = choque(todas[nombres[i]], todas[nombres[j]])
                    if vol > 1e-3 and {nombres[i], nombres[j]} != {'pulsador', 'cupula'}:
                        errores.append(f'{nv}, {estado}: {nombres[i]} choca con {nombres[j]} ({vol:.4f} mm³)')
        # La tapa entra girando: se baja por la hélice (rosca derecha) hasta salir, sin chocar con la base.
        recorrido = []
        for d in np.arange(0.25, M.Z_CH + 0.6, 0.25):
            vol = choque(nuc['tapa'].rotate((0, 0, -360 * d / M.PASO)).translate((0, 0, -d)), piezas['base'])
            recorrido.append(vol)
            if vol > 1e-3:
                errores.append(f'{nv}: la tapa choca con la base al desenroscarla {d:.2f} mm ({vol:.3f} mm³)')
        r['tapa_entra_girando'] = bool(max(recorrido) <= 1e-3)
        # El pulsador y el chasis entran desde abajo por la rosca de la base.
        r['pulsador_y_chasis_pasan_por_abajo'] = bool(M.R_PESTANA + 0.1 < M.R_PASO)
        # el émbolo y el botón
        r['boton'] = {'espacio_arriba': round(M.Z_EMB - (M.Z_P + M.P['alto_boton']), 3),
                      'hunde_el_boton_apretado': round(M.RECORRIDO - M.G['boton'], 3),
                      'junta_en_reposo': round(M.RECORRIDO - M.G['boton'], 3), 'junta_arriba': round(M.RECORRIDO, 3)}
        # gramos
        gramos = {}
        for n in ('base', 'cupula-un-color'):
            gramos[n] = round(piezas[n].volume() / 1000 * PLA, 2)
        r['gramos_macizo'] = gramos
        res['variantes'][nv] = r
    # núcleo: gramos
    res['nucleo_gramos_macizo'] = {n: round(p.volume() / 1000 * PLA, 2) for n, p in nuc.items()}
    for nv in variantes:
        total = sum(res['variantes'][nv]['gramos_macizo'].values()) + sum(res['nucleo_gramos_macizo'].values())
        res['variantes'][nv]['total_gramos_macizo'] = round(total, 1)
        res['variantes'][nv]['costo_material_clp'] = [round(total * p / 1000) for p in PRECIO_KG]
    # calce de la placa supuesta
    vgo = variantes['go'][0]
    rr, av = vgo['radio_canto_inferior'], vgo['alto_canto_inferior']
    pared_go = vgo['R_pie'] - rr + rr * math.sqrt(1 - ((av - M.ENTRADA) / av) ** 2) - M.R_ROSCA_MAYOR
    res['calce'] = {
        'pared_go_junto_a_la_rosca_a_0_5_mm': round(pared_go, 2),
        'placa_en_chasis_radial': round(M.R_BORE - M.R_PLACA, 3),
        'canto_de_la_placa_toca_el_cono_en_z': round(M.Z_P, 3),
        'ventana_sobre_componentes_radio': round(M.R_VENT, 2),
        'aire_sobre_componentes_apretado': round(M.S - M.RECORRIDO - M.Z_COMP, 3),
        'chasis_pasa_por_la_rosca': bool(M.R_PESTANA < M.R_PASO),
        'tapa_a_ras_tope_en_postes_z': round(M.Z_CH, 3),
    }
    # sólidos cerrados y voladizos de cada STL
    arch = {}
    raiz = os.path.join(M.AQUI, 'imprimir')
    for carpeta, _, archivos in sorted(os.walk(raiz)):
        for a in sorted(archivos):
            if a.endswith('.stl'):
                ok, vol = cerrado(os.path.join(carpeta, a))
                arch[os.path.relpath(os.path.join(carpeta, a), M.AQUI)] = {'cerrado': ok, 'volumen_mm3': round(vol, 1)}
                if not ok:
                    errores.append('no es un sólido cerrado: ' + a)
    res['archivos'] = arch
    vol = {}
    for n, p in nuc.items():
        vol[n] = voladizos(M.para_imprimir(n, p))
    for nv, (v, piezas) in variantes.items():
        vol[f'{nv}/base'] = voladizos(M.para_imprimir('base', piezas['base']))
        vol[f'{nv}/cupula-un-color'] = voladizos(M.para_imprimir('cupula', piezas['cupula-un-color']))
    res['voladizos_mas_de_47_grados'] = vol
    # Go con otra placa: el diámetro sale de la placa más un margen fijo, y el largo, del diámetro más la punta
    margen = M.R_ROSCA_MAYOR - M.R_PLACA
    def medidas_go(d):                       # la misma regla de modelo.variante('go'), con otra placa
        pared = vgo['radio_minimo_pared']
        R = math.ceil((d / 2 + margen + pared) * 2) / 2
        while R - rr + rr * math.sqrt(1 - ((av - M.ENTRADA) / av) ** 2) - (d / 2 + margen) < pared:
            R += 0.5
        return {'diametro': 2 * R, 'largo': 2 * R + vgo['gota']['separacion_agujero'] + vgo['gota']['radio_punta']}
    res['go_segun_placa'] = {str(d): medidas_go(d) for d in (24, 27, 30, 32, 35)}
    res['errores'] = errores
    json.dump(res, open(os.path.join(M.AQUI, 'comprobaciones.json'), 'w', encoding='utf8'), ensure_ascii=False, indent=1)
    print(json.dumps({k: res[k] for k in ('alturas', 'variantes', 'nucleo_gramos_macizo', 'calce', 'go_segun_placa', 'errores')},
                     ensure_ascii=False, indent=1))
    print('voladizos:', json.dumps(vol, ensure_ascii=False))
    print('sólidos cerrados:', sum(x['cerrado'] for x in arch.values()), 'de', len(arch))
