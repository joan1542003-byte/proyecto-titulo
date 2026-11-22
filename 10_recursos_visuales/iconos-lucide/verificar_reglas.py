"""Verifica los íconos adaptados y propios de Relevo contra las reglas medibles de Lucide (D-187)."""
import math, re, json, sys
import numpy as np
NUM = re.compile(r"[-+]?(?:\d+\.?\d*|\.\d+)(?:[eE][-+]?\d+)?")
P = {"M": 2, "L": 2, "H": 1, "V": 1, "C": 6, "S": 4, "Q": 4, "T": 2, "A": 7, "Z": 0}
def tokens(cmd, s):
    out, i, k = [], 0, 0
    while True:
        while i < len(s) and s[i] in " ,\t\n": i += 1
        if i >= len(s): break
        if cmd in "Aa" and k % 7 in (3, 4): out.append(float(s[i])); i += 1
        else:
            m = NUM.match(s, i); out.append(float(m.group(0))); i = m.end()
        k += 1
    return out
def arco(x1, y1, rx, ry, phi, fa, fs, x2, y2, n=40):
    if rx == 0 or ry == 0: return [(x2, y2)]
    phi = math.radians(phi); c, s = math.cos(phi), math.sin(phi)
    dx, dy = (x1 - x2) / 2, (y1 - y2) / 2
    x1p, y1p = c * dx + s * dy, -s * dx + c * dy
    rx, ry = abs(rx), abs(ry)
    lam = x1p ** 2 / rx ** 2 + y1p ** 2 / ry ** 2
    if lam > 1: rx *= math.sqrt(lam); ry *= math.sqrt(lam)
    num = rx * rx * ry * ry - rx * rx * y1p * y1p - ry * ry * x1p * x1p
    den = rx * rx * y1p * y1p + ry * ry * x1p * x1p
    co = math.sqrt(max(0, num / den)) * (-1 if fa == fs else 1)
    cxp, cyp = co * rx * y1p / ry, -co * ry * x1p / rx
    cx, cy = c * cxp - s * cyp + (x1 + x2) / 2, s * cxp + c * cyp + (y1 + y2) / 2
    ang = lambda ux, uy, vx, vy: math.atan2(ux * vy - uy * vx, ux * vx + uy * vy)
    t1 = ang(1, 0, (x1p - cxp) / rx, (y1p - cyp) / ry)
    dt = ang((x1p - cxp) / rx, (y1p - cyp) / ry, (-x1p - cxp) / rx, (-y1p - cyp) / ry)
    if not fs and dt > 0: dt -= 2 * math.pi
    if fs and dt < 0: dt += 2 * math.pi
    pts = []
    for i in range(1, n + 1):
        t = t1 + dt * i / n
        pts.append((cx + rx * math.cos(t) * c - ry * math.sin(t) * s, cy + rx * math.cos(t) * s + ry * math.sin(t) * c))
    return pts
def muestrear(d, paso=0.1):
    """Puntos a lo largo del trazado (línea central)."""
    pts = []; cx = cy = sx = sy = 0.0; pc = None
    for cmd, args in re.findall(r"([MmLlHhVvCcSsQqTtAaZz])([^MmLlHhVvCcSsQqTtAaZz]*)", d):
        t = tokens(cmd, args); U = cmd.upper(); rel = cmd.islower(); n = P[U]
        if U == "Z":
            pts += lin(cx, cy, sx, sy, paso); cx, cy = sx, sy; pc = None; continue
        for j in range(0, len(t), n):
            g = t[j:j + n]
            if U == "M":
                x, y = (cx + g[0], cy + g[1]) if rel else g
                if j == 0: cx, cy = sx, sy = x, y; pts.append((x, y))
                else: pts += lin(cx, cy, x, y, paso); cx, cy = x, y
                pc = None
            elif U == "L":
                x, y = (cx + g[0], cy + g[1]) if rel else g; pts += lin(cx, cy, x, y, paso); cx, cy = x, y; pc = None
            elif U == "H":
                x = g[0] + (cx if rel else 0); pts += lin(cx, cy, x, cy, paso); cx = x; pc = None
            elif U == "V":
                y = g[0] + (cy if rel else 0); pts += lin(cx, cy, cx, y, paso); cy = y; pc = None
            elif U in ("C", "S"):
                if U == "C":
                    x1, y1, x2, y2, x, y = g
                    if rel: x1, y1, x2, y2, x, y = cx + x1, cy + y1, cx + x2, cy + y2, cx + x, cy + y
                else:
                    x2, y2, x, y = g
                    if rel: x2, y2, x, y = cx + x2, cy + y2, cx + x, cy + y
                    x1, y1 = (2 * cx - pc[0], 2 * cy - pc[1]) if pc else (cx, cy)
                for i in range(1, 41):
                    u = i / 40; a = (1 - u) ** 3; b = 3 * (1 - u) ** 2 * u; c_ = 3 * (1 - u) * u * u; e = u ** 3
                    pts.append((a * cx + b * x1 + c_ * x2 + e * x, a * cy + b * y1 + c_ * y2 + e * y))
                pc = (x2, y2); cx, cy = x, y
            elif U == "Q":
                x1, y1, x, y = g
                if rel: x1, y1, x, y = cx + x1, cy + y1, cx + x, cy + y
                for i in range(1, 31):
                    u = i / 30; pts.append(((1-u)**2*cx + 2*(1-u)*u*x1 + u*u*x, (1-u)**2*cy + 2*(1-u)*u*y1 + u*u*y))
                cx, cy = x, y; pc = None
            elif U == "A":
                rx, ry, ph, fa, fs, x, y = g
                if rel: x, y = cx + x, cy + y
                pts += arco(cx, cy, rx, ry, ph, int(fa), int(fs), x, y); cx, cy = x, y; pc = None
    return pts
def lin(x1, y1, x2, y2, paso):
    n = max(1, int(math.hypot(x2 - x1, y2 - y1) / paso)); return [(x1 + (x2 - x1) * i / n, y1 + (y2 - y1) * i / n) for i in range(1, n + 1)]
def a_trazado(tag, at):
    f = lambda k, d=0.0: float(at.get(k, d))
    if tag == "path": return at["d"]
    if tag == "circle":
        cx, cy, r = f("cx"), f("cy"), f("r"); return f"M{cx-r} {cy}A{r} {r} 0 1 0 {cx+r} {cy}A{r} {r} 0 1 0 {cx-r} {cy}Z"
    if tag == "rect":
        x, y, w, h = f("x"), f("y"), f("width"), f("height"); r = min(f("rx"), w / 2, h / 2)
        return (f"M{x+r} {y}H{x+w-r}A{r} {r} 0 0 1 {x+w} {y+r}V{y+h-r}A{r} {r} 0 0 1 {x+w-r} {y+h}H{x+r}A{r} {r} 0 0 1 {x} {y+h-r}V{y+r}A{r} {r} 0 0 1 {x+r} {y}Z")
    if tag == "line": return f"M{f('x1')} {f('y1')}L{f('x2')} {f('y2')}"
    raise ValueError(tag)
def elementos(inner):
    out = []
    for m in re.finditer(r"<(path|circle|rect|line)\s([^>]*)/>", inner):
        at = dict(re.findall(r'(\w[\w-]*)="([^"]*)"', m.group(2)))
        out.append((m.group(1), at, a_trazado(m.group(1), at)))
    return out
def verificar(inner, tocan=()):
    els = elementos(inner); P_ = [np.array(muestrear(e[2])) for e in els]
    todos = np.vstack(P_)
    margen = min(todos[:, 0].min(), todos[:, 1].min(), 24 - todos[:, 0].max(), 24 - todos[:, 1].max()) - 1  # borde del trazo al lienzo
    gaps = []
    for i in range(len(P_)):
        for j in range(i + 1, len(P_)):
            a, b = P_[i], P_[j]
            dmin = min(np.sqrt(((a[k:k+400, None, :] - b[None, :, :]) ** 2).sum(-1)).min() for k in range(0, len(a), 400))
            gaps.append((i, j, round(dmin - 2, 2), (i, j) in tocan or (j, i) in tocan))
    nums = [float(x) for e in els for x in (NUM.findall(e[2]) if e[0] == "path" else [e[1].get(k) for k in ("cx", "cy", "r", "x", "y", "width", "height", "rx", "x1", "y1", "x2", "y2") if e[1].get(k)])]
    fuera = sorted({n for n in nums if abs(n * 2 - round(n * 2)) > 1e-6})
    caja = [round(todos[:, 0].min() - 1, 2), round(todos[:, 1].min() - 1, 2), round(todos[:, 0].max() + 1, 2), round(todos[:, 1].max() + 1, 2)]
    return {"margen": round(margen, 2), "separaciones": gaps, "fuera_de_reticula": fuera[:12], "n_fuera": len(fuera), "n_numeros": len(nums), "caja": caja}


if __name__ == "__main__":
    # Uso, desde la raíz del repositorio (necesita numpy):
    #     python3 10_recursos_visuales/iconos-lucide/verificar_reglas.py
    # Revisa, para cada ícono adaptado o propio del mapeo: que el trazo quede a 1 o más del borde del lienzo;
    # que entre elementos distintos haya 2 o más de aire, salvo las uniones que el mapeo declara como parte del
    # dibujo («uniones»: pares de elementos, contados desde 0), y cuántos números quedan fuera de la retícula de 0,5.
    import os
    aqui = os.path.dirname(os.path.abspath(__file__))
    mapeo = json.load(open(os.path.join(aqui, "mapeo.json"), encoding="utf-8"))["iconos"]
    fallas = 0
    for nombre, entrada in mapeo.items():
        if entrada["categoria"] == "lucide":
            continue
        texto = open(os.path.join(aqui, entrada["archivo"]), encoding="utf-8").read()
        interior = re.search(r"<svg[^>]*>(.*)</svg>", texto, re.S).group(1)
        r = verificar(interior, [tuple(u) for u in entrada.get("uniones", [])])
        malas = [(i, j, g) for i, j, g, unida in r["separaciones"] if g < 1.99 and not unida]
        ok = r["margen"] >= 0.99 and not malas
        fallas += not ok
        print(f"{'cumple' if ok else 'FALLA ':7s} {nombre:12s} margen {r['margen']:4.2f}  aire bajo 2: {malas or 'ninguno'}  "
              f"fuera de la retícula: {r['n_fuera']} de {r['n_numeros']}")
    raise SystemExit(1 if fallas else 0)
