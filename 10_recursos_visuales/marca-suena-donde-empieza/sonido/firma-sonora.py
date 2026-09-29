"""Genera la firma sonora de Relevo (propuesta D-071).

Dos golpes de timbre de madera, en descenso de una cuarta justa (Re5 → La4),
una sola vez. Cada decisión busca baja urgencia y un sonido fácil de ubicar:

- altura media y contorno descendente, dos notas lentas y sin repetición
  (la urgencia percibida sube con la altura, la velocidad y las repeticiones;
  Edworthy et al., 1991; Hellier et al., 1993);
- parciales armónicos 1 : 3,9 : 9,2, como una lámina de marimba, y un ataque
  breve de banda ancha, porque un tono puro es difícil de localizar
  (Middlebrooks & Green, 1991);
- decaimiento libre, sin sostén: el sonido termina solo.

Uso: python3 firma-sonora.py [salida.wav]
Requiere NumPy.
"""
import sys
import wave

import numpy as np

SR = 44_100
DURACION = 2.2  # segundos, incluida la cola
NOTAS = [(0.00, 587.33, 1.00), (0.46, 440.00, 0.92)]  # inicio, Hz, nivel
PARCIALES = [(1.0, 1.00, 0.95), (3.9, 0.30, 0.22), (9.2, 0.10, 0.07)]  # razón, amplitud, tau (s)


def golpe(f0, n):
    t = np.arange(n) / SR
    s = np.zeros(n)
    for razon, amp, tau in PARCIALES:
        s += amp * np.sin(2 * np.pi * f0 * razon * t) * np.exp(-t / tau)
    ataque = np.clip(t / 0.004, 0, 1)
    s *= 0.5 - 0.5 * np.cos(np.pi * ataque)
    # transitorio de banda ancha (4 ms): ruido suavizado que ayuda a ubicar la fuente
    rng = np.random.default_rng(7)
    k = int(0.004 * SR)
    ruido = rng.standard_normal(k) * np.hanning(k)
    ruido = np.convolve(ruido, np.ones(3) / 3, mode="same")
    s[:k] += 0.18 * ruido
    return s


def firma():
    n = int(DURACION * SR)
    out = np.zeros(n)
    for inicio, f0, nivel in NOTAS:
        i = int(inicio * SR)
        out[i:] += nivel * golpe(f0, n - i)
    cola = int(0.25 * SR)
    out[-cola:] *= np.linspace(1, 0, cola)
    return out / np.max(np.abs(out)) * 10 ** (-3 / 20)  # pico a −3 dBFS


if __name__ == "__main__":
    destino = sys.argv[1] if len(sys.argv) > 1 else "firma-relevo.wav"
    datos = (firma() * 32767).astype("<i2")
    with wave.open(destino, "wb") as w:
        w.setnchannels(1)
        w.setsampwidth(2)
        w.setframerate(SR)
        w.writeframes(datos.tobytes())
    print(destino, f"{len(datos) / SR:.2f} s")
