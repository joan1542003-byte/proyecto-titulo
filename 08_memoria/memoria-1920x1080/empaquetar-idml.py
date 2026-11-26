# Copia los vínculos de un IDML a una carpeta estable y reescribe sus rutas para que Affinity los encuentre ahí.
# Uso, desde esta carpeta: python3 empaquetar-idml.py memoria-relevo-v8-1920x1080.idml .. <carpeta de destino>
# Escribe <destino>/<nombre>.idml y <destino>/vinculos/; el IDML debe quedar junto a su carpeta de vínculos.
import sys, os, re, zipfile, shutil, urllib.parse
idml, base, destino = sys.argv[1], os.path.realpath(sys.argv[2]), sys.argv[3]
vinc = os.path.join(destino, 'vinculos')
os.makedirs(vinc, exist_ok=True)
zin = zipfile.ZipFile(idml)
nombres = zin.namelist()
assert nombres[0] == 'mimetype', nombres[0]
copiados, faltan = {}, []
def reescribe(m):
    uri = m.group(1)
    ruta = urllib.parse.unquote(uri[len('file:'):]) if uri.startswith('file:') else None
    if not ruta: return m.group(0)
    real = os.path.realpath(ruta)
    if not real.startswith(base + os.sep):
        faltan.append(('fuera de la base', ruta)); return m.group(0)
    rel = os.path.relpath(real, base)
    nuevo = os.path.join(vinc, rel)
    if rel not in copiados:
        if not os.path.exists(real): faltan.append(('no existe', real)); return m.group(0)
        os.makedirs(os.path.dirname(nuevo), exist_ok=True); shutil.copy2(real, nuevo); copiados[rel] = os.path.getsize(real)
    return 'LinkResourceURI="file:' + urllib.parse.quote(nuevo) + '"'
salida = os.path.join(destino, os.path.basename(idml))
with zipfile.ZipFile(salida, 'w') as zout:
    for n in nombres:
        datos = zin.read(n)
        if n.endswith('.xml'):
            t = datos.decode('utf-8')
            t2 = re.sub(r'LinkResourceURI="([^"]*)"', reescribe, t)
            datos = t2.encode('utf-8')
        if n == 'mimetype':
            zout.writestr(zipfile.ZipInfo('mimetype'), datos, compress_type=zipfile.ZIP_STORED)
        else:
            zout.writestr(n, datos, compress_type=zipfile.ZIP_DEFLATED)
print('vínculos copiados:', len(copiados), 'MB:', round(sum(copiados.values()) / 1e6, 1))
print('problemas:', faltan[:10], len(faltan))
