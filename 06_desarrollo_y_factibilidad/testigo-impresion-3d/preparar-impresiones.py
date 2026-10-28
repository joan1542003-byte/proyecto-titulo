#!/usr/bin/env python3
"""Prepara las impresiones del testigo para una Bambu Lab X1 Carbon con Bambu Studio.

Toma los perfiles oficiales instalados con Bambu Studio (impresora X1 Carbon con boquilla de 0,4,
proceso «0.12mm Fine» y Bambu PLA Matte), resuelve su herencia, les suma los ajustes del testigo y
lamina cada impresión con la línea de comandos de Bambu Studio. Escribe en imprimir/bambu/ un
proyecto .3mf por impresión, listo para abrir, laminar y enviar, y un resumen con tiempo y gramos.

Uso:  python3 testigo.py && python3 preparar-impresiones.py
      (Bambu Studio en /Applications, o su carpeta en la variable BAMBU_STUDIO)
"""
import glob
import json
import os
import subprocess
import sys
import tempfile
import zipfile

AQUI = os.path.dirname(os.path.abspath(__file__))
APP = os.environ.get('BAMBU_STUDIO', '/Applications/BambuStudio.app')
CLI = os.path.join(APP, 'Contents', 'MacOS', 'BambuStudio')
BBL = os.path.join(APP, 'Contents', 'Resources', 'profiles', 'BBL')
PIEZAS = os.path.join(AQUI, 'imprimir')
SALIDA = os.path.join(PIEZAS, 'bambu')

MAQUINA, PROCESO, FILAMENTO = 'Bambu Lab X1 Carbon 0.4 nozzle', '0.12mm Fine @BBL X1C', 'Bambu PLA Matte @BBL X1C'
# Ajustes del testigo sobre el proceso oficial (README, «Ajustes en Bambu Studio»).
AJUSTES = {
    'curr_bed_type': 'Textured PEI Plate',   # las caras visibles van contra la placa texturada
    'wall_loops': '3',
    'sparse_infill_density': '15%',
    'sparse_infill_pattern': 'gyroid',
    'wall_generator': 'arachne',             # líneas de ancho variable: tabiques del logo y paredes finas
    'enable_support': '0',
    'brim_type': 'no_brim',                  # sin borde: no marca las caras visibles
    'seam_position': 'aligned',
    'wipe_tower_x': ['172'],               # torre de purga (solo con varios colores), lejos de la pieza
    'wipe_tower_y': ['150'],
}
PAPEL = '#F2EEE6'
LUCES = [('#FFD54A', 'luz-1-tiempo-amarillo'), ('#9DD6F4', 'luz-2-primer-paso-celeste'),
         ('#B3E788', 'luz-3-lugar-verde-lima'), ('#F6A3CB', 'luz-4-decision-rosado')]

def perfiles(directorio):
    """Índice de los perfiles del sistema y una función que los aplana."""
    indice = {}
    for tipo in ('machine', 'process', 'filament'):
        for f in glob.glob(os.path.join(BBL, tipo, '*.json')):
            try:
                d = json.load(open(f, encoding='utf8'))
            except (OSError, ValueError):
                continue
            if 'name' in d:
                indice[(tipo, d['name'])] = d
    meta = {'inherits', 'include', 'instantiation', 'setting_id', 'description', 'from', 'type', 'name'}

    def resolver(tipo, nombre):
        d = indice[(tipo, nombre)]
        out = resolver(tipo, d['inherits']) if d.get('inherits') else {}
        for inc in d.get('include', []):
            out.update(resolver(tipo, inc))
        out.update({k: v for k, v in d.items() if k not in meta})
        return out

    def aplanar(tipo, nombre, extra=None, archivo=None):
        out = resolver(tipo, nombre)
        out.update(extra or {})
        out.update({'type': tipo, 'name': nombre, 'from': 'system', 'instantiation': 'true'})
        ruta = os.path.join(directorio, (archivo or nombre) + '.json')
        json.dump(out, open(ruta, 'w', encoding='utf8'), ensure_ascii=False, indent=1)
        return ruta
    return aplanar

def renombrar(archivo, nombres):
    """Cambia en el proyecto los nombres que pone Bambu Studio (archivo.stl, assemble_1) por los de las piezas."""
    tmp = archivo + '.tmp'
    with zipfile.ZipFile(archivo) as zin, zipfile.ZipFile(tmp, 'w', zipfile.ZIP_DEFLATED) as zout:
        for info in zin.infolist():
            datos = zin.read(info.filename)
            if info.filename in ('Metadata/model_settings.config', 'Metadata/plate_1.json', 'Metadata/slice_info.config'):
                texto = datos.decode('utf8')
                for viejo, nuevo in nombres.items():
                    texto = texto.replace(f'"{viejo}"', f'"{nuevo}"')
                datos = texto.encode('utf8')
            zout.writestr(info, datos)
    os.replace(tmp, archivo)

def laminar(nombre, maquina, proceso, filamentos, modelos=None, lista=None, nombres=None):
    """Lamina un plato y deja el proyecto en imprimir/bambu/<nombre>.3mf. Devuelve el resumen."""
    trabajo = tempfile.mkdtemp(prefix='testigo-')
    datos = tempfile.mkdtemp(prefix='bambu-datos-')
    orden = [CLI, '--datadir', datos, '--debug', '1', '--orient', '0',
             '--load-settings', f'{maquina};{proceso}', '--load-filaments', ';'.join(filamentos),
             '--slice', '0', '--outputdir', trabajo, '--export-3mf', nombre + '.3mf']
    if lista:
        orden += ['--allow-multicolor-oneplate', '--load-assemble-list', lista]
    else:
        orden += ['--arrange', '1'] + modelos
    r = subprocess.run(orden, cwd=trabajo, capture_output=True, text=True)
    resultado = json.load(open(os.path.join(trabajo, 'result.json'), encoding='utf8'))
    if r.returncode != 0 or resultado.get('return_code') != 0:
        sys.exit(f'{nombre}: Bambu Studio no pudo laminar ({resultado.get("error_string")}).\n{r.stdout[-2000:]}')
    os.makedirs(SALIDA, exist_ok=True)
    destino = os.path.join(SALIDA, nombre + '.3mf')
    os.replace(os.path.join(trabajo, nombre + '.3mf'), destino)
    if nombres:
        renombrar(destino, nombres)
    with zipfile.ZipFile(destino) as z:                       # vista del plato, para la guía
        open(os.path.join(SALIDA, nombre + '.png'), 'wb').write(z.read('Metadata/plate_1.png'))
    plato = resultado['sliced_plates'][0]
    gramos = sum(f['total_used_g'] for f in plato['filaments'])
    return {'impresion': nombre, 'minutos': round(plato['main_predication'] / 60), 'gramos': round(gramos, 1),
            'filamentos': [{'id': f['id'], 'gramos': round(f['total_used_g'], 2)} for f in plato['filaments']],
            'cambios_de_filamento': plato.get('filament_change_times', 0)}

if __name__ == '__main__':
    if not os.path.exists(CLI):
        sys.exit('No se encontró Bambu Studio. Indica su carpeta .app en la variable BAMBU_STUDIO.')
    carpeta = tempfile.mkdtemp(prefix='perfiles-')
    aplanar = perfiles(carpeta)
    maquina = aplanar('machine', MAQUINA)
    proceso = aplanar('process', PROCESO, AJUSTES)
    papel = aplanar('filament', FILAMENTO, {'filament_colour': [PAPEL]}, 'papel')
    colores = [aplanar('filament', FILAMENTO, {'filament_colour': [c]}, n) for c, n in LUCES]
    p = lambda *r: os.path.join(PIEZAS, *r)
    resumen = []
    # 1. Prueba de calce: la boca con la rosca, la tapa, el techo con la ventana y el medallón.
    resumen.append(laminar('1-prueba-de-calce', maquina, proceso, [papel],
                           [p('prueba-de-calce', 'rosca.stl'), p('tapa.stl'), p('prueba-de-calce', 'medallon.stl'),
                            p('medallon-placa.stl'), p('medallon-fondo.stl')],
                           nombres={'rosca.stl': 'prueba-rosca', 'medallon.stl': 'prueba-ventana', 'tapa.stl': 'tapa',
                                    'medallon-placa.stl': 'medallon-placa', 'medallon-fondo.stl': 'medallon-fondo'}))
    # 2. El testigo completo, en un color.
    resumen.append(laminar('2-testigo-un-color', maquina, proceso, [papel],
                           [p('cuerpo.stl'), p('chasis.stl'), p('tapa.stl'), p('medallon-placa.stl'), p('medallon-fondo.stl')],
                           nombres={f'{n}.stl': n for n in ('cuerpo', 'chasis', 'tapa', 'medallon-placa', 'medallon-fondo')}))
    # 3. El fondo del medallón en los cuatro colores de la marca (AMS). La base usa el primer color.
    partes = [('base', 1)] + [(n, i + 1) for i, (_, n) in enumerate(LUCES)]
    lista = {'plates': [{'plate_name': 'Fondo en cuatro colores', 'need_arrange': False, 'objects': [
        {'path': p('medallon-fondo-cuatro-colores', n + '.stl'), 'count': 1, 'filaments': [f], 'assemble_index': [1],
         'pos_x': [128.0], 'pos_y': [128.0], 'pos_z': [0.0]} for n, f in partes]}]}
    ruta_lista = os.path.join(carpeta, 'fondo-cuatro-colores.json')
    json.dump(lista, open(ruta_lista, 'w', encoding='utf8'), ensure_ascii=False, indent=1)
    resumen.append(laminar('3-fondo-cuatro-colores', maquina, proceso, colores, lista=ruta_lista,
                           nombres=dict({'assemble_1': 'medallon-fondo-cuatro-colores'}, **{f'{n}_1': n for n, _ in partes})))
    json.dump(resumen, open(os.path.join(SALIDA, 'resumen.json'), 'w', encoding='utf8'), ensure_ascii=False, indent=1)
    for r in resumen:
        print(f"{r['impresion']:26s} ≈ {r['minutos']:3d} min · {r['gramos']:5.1f} g · cambios de filamento: {r['cambios_de_filamento']}")
