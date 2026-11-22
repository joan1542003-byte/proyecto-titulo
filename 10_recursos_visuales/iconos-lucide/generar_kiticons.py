"""Genera KitIcons.kt, los íconos de la app, desde Lucide y los íconos propios (D-187).

Uso, desde la raíz del repositorio:

    python3 10_recursos_visuales/iconos-lucide/generar_kiticons.py

Lee mapeo.json, que dice de dónde sale cada ícono de la app: un ícono de Lucide tal cual
(carpeta lucide/), uno adaptado de Lucide o uno propio dibujado con sus reglas (carpeta propios/).
Conserva el orden y el nombre accesible de cada ícono tal como están en KitIcons.kt, y reescribe
solo sus trazados. Convierte los círculos, rectángulos, líneas y polilíneas de los SVG en trazados,
porque la app dibuja trazados.
"""

from __future__ import annotations

import json
import re
import sys
import xml.etree.ElementTree as ET
from pathlib import Path

AQUI = Path(__file__).resolve().parent
RAIZ = AQUI.parent.parent
KOTLIN = RAIZ / "06_desarrollo_y_factibilidad/app-android/app/src/main/java/com/example/relevo/ui/components/KitIcons.kt"
SVG = "{http://www.w3.org/2000/svg}"


def numero(valor: float) -> str:
    texto = f"{valor:.3f}".rstrip("0").rstrip(".")
    return "0" if texto in ("-0", "") else texto


def flotante(elemento: ET.Element, nombre: str, defecto: float = 0.0) -> float:
    valor = elemento.get(nombre)
    return float(valor) if valor is not None else defecto


NUMERO = re.compile(r"[-+]?(?:\d+\.?\d*|\.\d+)(?:[eE][-+]?\d+)?")
PARAMETROS = {"M": 2, "L": 2, "H": 1, "V": 1, "C": 6, "S": 4, "Q": 4, "T": 2, "A": 7, "Z": 0}


def normalizar(d: str) -> str:
    """Reescribe un trazado con cada número separado.

    El SVG permite escribir pegadas las banderas de un arco («A5 5 0 0012 5»), y varios íconos de Lucide lo hacen.
    El lector de trazados de Android podría leer «0012» como un solo número, así que se separan: «A5 5 0 0 0 12 5».
    """
    salida = []
    for comando, argumentos in re.findall(r"([MmLlHhVvCcSsQqTtAaZz])([^MmLlHhVvCcSsQqTtAaZz]*)", d):
        valores, i, k = [], 0, 0
        while True:
            while i < len(argumentos) and argumentos[i] in " ,\t\r\n":
                i += 1
            if i >= len(argumentos):
                break
            if comando in "Aa" and k % 7 in (3, 4):
                if argumentos[i] not in "01":
                    raise ValueError(f"Bandera de arco inválida en «{d}»")
                valores.append(argumentos[i])
                i += 1
            else:
                encontrado = NUMERO.match(argumentos, i)
                if not encontrado:
                    raise ValueError(f"No se entiende «{argumentos[i:]}» en «{d}»")
                valores.append(numero(float(encontrado.group(0))))
                i = encontrado.end()
            k += 1
        cuantos = PARAMETROS[comando.upper()]
        if (cuantos == 0 and valores) or (cuantos and (not valores or len(valores) % cuantos)):
            raise ValueError(f"El comando {comando} tiene {len(valores)} números en «{d}»")
        salida.append(comando + " ".join(valores))
    return "".join(salida)


def trazado(elemento: ET.Element) -> str:
    """Un elemento de SVG como trazado («path data»)."""
    tipo = elemento.tag.replace(SVG, "")
    n = numero
    if tipo == "path":
        return normalizar(elemento.get("d").strip())
    if tipo in ("circle", "ellipse"):
        cx, cy = flotante(elemento, "cx"), flotante(elemento, "cy")
        rx = flotante(elemento, "r") if tipo == "circle" else flotante(elemento, "rx")
        ry = flotante(elemento, "r") if tipo == "circle" else flotante(elemento, "ry")
        return (f"M{n(cx - rx)} {n(cy)}A{n(rx)} {n(ry)} 0 1 0 {n(cx + rx)} {n(cy)}"
                f"A{n(rx)} {n(ry)} 0 1 0 {n(cx - rx)} {n(cy)}Z")
    if tipo == "rect":
        x, y = flotante(elemento, "x"), flotante(elemento, "y")
        w, h = flotante(elemento, "width"), flotante(elemento, "height")
        rx = elemento.get("rx")
        ry = elemento.get("ry")
        rx = float(rx) if rx is not None else (float(ry) if ry is not None else 0.0)
        ry = float(ry) if ry is not None else rx
        rx, ry = min(rx, w / 2), min(ry, h / 2)
        if rx == 0 or ry == 0:
            return f"M{n(x)} {n(y)}H{n(x + w)}V{n(y + h)}H{n(x)}Z"
        return (f"M{n(x + rx)} {n(y)}H{n(x + w - rx)}A{n(rx)} {n(ry)} 0 0 1 {n(x + w)} {n(y + ry)}"
                f"V{n(y + h - ry)}A{n(rx)} {n(ry)} 0 0 1 {n(x + w - rx)} {n(y + h)}"
                f"H{n(x + rx)}A{n(rx)} {n(ry)} 0 0 1 {n(x)} {n(y + h - ry)}"
                f"V{n(y + ry)}A{n(rx)} {n(ry)} 0 0 1 {n(x + rx)} {n(y)}Z")
    if tipo == "line":
        return (f"M{n(flotante(elemento, 'x1'))} {n(flotante(elemento, 'y1'))}"
                f"L{n(flotante(elemento, 'x2'))} {n(flotante(elemento, 'y2'))}")
    if tipo in ("polyline", "polygon"):
        numeros = [float(v) for v in re.split(r"[\s,]+", elemento.get("points").strip())]
        puntos = [f"{n(numeros[i])} {n(numeros[i + 1])}" for i in range(0, len(numeros), 2)]
        return "M" + "L".join(puntos) + ("Z" if tipo == "polygon" else "")
    raise ValueError(f"Elemento de SVG que el generador no conoce: {tipo}")


def formas(archivo: Path) -> list[tuple[str, bool]]:
    """Cada forma del SVG como trazado, y si va rellena del color del trazo.

    Lucide rellena con «currentColor» algunos puntos chicos, como los de la paleta: la app los rellena con tinta.
    """
    raiz = ET.parse(archivo).getroot()
    resultado = []
    for elemento in raiz.iter():
        if elemento is raiz:
            continue
        tipo = elemento.tag.replace(SVG, "")
        if tipo in ("title", "desc"):
            continue
        if tipo == "g":
            raise ValueError(f"{archivo.name}: tiene grupos; aplanarlos antes de usarlo")
        relleno = elemento.get("fill")
        if relleno not in (None, "none", "currentColor"):
            raise ValueError(f"{archivo.name}: tiene un relleno de otro color ({relleno})")
        resultado.append((trazado(elemento), relleno == "currentColor"))
    return resultado


def iconos_actuales(texto: str) -> list[tuple[str, str]]:
    """Nombre y nombre accesible de cada ícono, en el orden de KitIcons.kt."""
    return re.findall(r'\n  ([A-Z_0-9]+)\(\n    "([^"]*)"', texto)


def comentario(entrada: dict) -> str:
    nota = entrada.get("nota", "")
    if entrada["categoria"] == "lucide":
        base = f"Lucide «{entrada['lucide']}»."
    elif entrada["categoria"] == "adaptado":
        base = "Adaptado de Lucide (D-187)."
    else:
        base = "Propio, con las reglas de construcción de Lucide (D-187)."
    return f"{base} {nota}".strip()


def generar() -> str:
    mapeo = json.loads((AQUI / "mapeo.json").read_text(encoding="utf-8"))
    entradas = mapeo["iconos"]
    actual = KOTLIN.read_text(encoding="utf-8")
    iconos = iconos_actuales(actual)
    faltan = [nombre for nombre, _ in iconos if nombre not in entradas]
    sobran = [nombre for nombre in entradas if nombre not in dict(iconos)]
    if faltan or sobran:
        raise SystemExit(f"mapeo.json no calza con KitIcons.kt. Faltan: {faltan}. Sobran: {sobran}.")

    lineas = [
        "package com.example.relevo.ui.components",
        "",
        "// Generado por 10_recursos_visuales/iconos-lucide/generar_kiticons.py desde mapeo.json (D-187).",
        f"// Los íconos salen de Lucide {mapeo['lucide_version']} (https://lucide.dev), tal cual, adaptados o dibujados",
        "// con sus reglas cuando Lucide no tiene lo que la persona hace. Retícula de 24, trazo redondeado; el grosor",
        "// lo pone la app según el tamaño (D-124). No se edita a mano: se cambia mapeo.json o un SVG y se vuelve a generar.",
        "//",
        "// Lucide: ISC License, Copyright (c) 2026 Lucide Icons and Contributors. Los íconos que vienen de Feather",
        "// tienen además la MIT License, Copyright (c) 2013-present Cole Bemis. El texto completo de ambas está en",
        "// app/licenses/LUCIDE_LICENSE.md y en app/src/main/assets/licencias/LUCIDE_LICENSE.txt.",
        "",
        "internal enum class KitFill { NONE, INK, PAPER }",
        "",
        "internal class KitShape(val pathData: String, val stroke: Boolean, val fill: KitFill)",
        "",
        "/** Íconos de Relevo (D-187): de Lucide, adaptados o propios. [label] es su nombre accesible; en pantalla siempre van con una palabra. */",
        "enum class KitIcon(val label: String, internal val shapes: List<KitShape>) {",
    ]
    for nombre, etiqueta in iconos:
        entrada = entradas[nombre]
        lineas.append(f"  /** {comentario(entrada)} */")
        lineas.append(f"  {nombre}(")
        lineas.append(f'    "{etiqueta}",')
        lineas.append("    listOf(")
        for forma, rellena in formas(AQUI / entrada["archivo"]):
            relleno = "KitFill.INK" if entrada.get("relleno") or rellena else "KitFill.NONE"
            lineas.append(f'      KitShape("{forma}", true, {relleno}),')
        lineas.append("    ),")
        lineas.append("  ),")
    lineas.append("}")
    return "\n".join(lineas) + "\n"


if __name__ == "__main__":
    texto = generar()
    if "--revisar" in sys.argv:
        print(texto)
    else:
        KOTLIN.write_text(texto, encoding="utf-8")
        print(f"Escrito {KOTLIN.relative_to(RAIZ)}")
