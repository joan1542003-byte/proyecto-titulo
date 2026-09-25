"""Receta de corrección de imagen de Relevo (propuesta D-069).

Uso: python3 receta-imagen.py entrada.jpg salida.jpg [4:5|3:2] [foco_horizontal 0-1]
Requiere Pillow y NumPy. Encuadra, baja la saturación 16 %, levanta las sombras,
enfría levemente las sombras, entibia las altas luces y agrega grano fino.
"""
import sys
import numpy as np
from PIL import Image


def encuadrar(im, proporcion, foco):
    ancho, alto = im.size
    if ancho / alto > proporcion:
        nuevo = int(alto * proporcion)
        x0 = int(max(0, min(ancho - nuevo, foco * ancho - nuevo / 2)))
        return im.crop((x0, 0, x0 + nuevo, alto))
    nuevo = int(ancho / proporcion)
    y0 = int((alto - nuevo) / 2)
    return im.crop((0, y0, ancho, y0 + nuevo))


def corregir(im, semilla=1):
    a = np.asarray(im).astype(np.float32) / 255
    lum = (0.2126 * a[..., 0] + 0.7152 * a[..., 1] + 0.0722 * a[..., 2])[..., None]
    a = lum + (a - lum) * 0.84                     # saturación −16 %
    a = 0.035 + a * 0.93                           # sombras levantadas, altas luces contenidas
    lum = (0.2126 * a[..., 0] + 0.7152 * a[..., 1] + 0.0722 * a[..., 2])[..., None]
    sombras = np.clip(1 - lum * 2, 0, 1)
    altas = np.clip(lum * 2 - 1, 0, 1)
    a = a + sombras * np.array([-0.014, -0.004, 0.032]) + altas * np.array([0.022, 0.008, -0.018])
    grano = np.random.default_rng(semilla).normal(0, 0.02, a.shape[:2])[..., None]
    return Image.fromarray((np.clip(a + grano, 0, 1) * 255).astype(np.uint8))


if __name__ == "__main__":
    entrada, salida = sys.argv[1], sys.argv[2]
    proporcion = {"4:5": 4 / 5, "3:2": 3 / 2}[sys.argv[3] if len(sys.argv) > 3 else "4:5"]
    foco = float(sys.argv[4]) if len(sys.argv) > 4 else 0.5
    imagen = encuadrar(Image.open(entrada).convert("RGB"), proporcion, foco)
    corregir(imagen).save(salida, quality=85, optimize=True, progressive=True)
