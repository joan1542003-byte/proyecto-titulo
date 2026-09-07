from __future__ import annotations

import argparse
import math
import os
import subprocess
from pathlib import Path

from PIL import Image, ImageChops, ImageDraw, ImageEnhance, ImageFilter, ImageFont


W, H = 3840, 2160
FPS = 30
BG = (17, 19, 20)
WHITE = (241, 241, 241)
MUTED = (182, 184, 183)
RED = (215, 25, 33)


ROOT = Path(__file__).resolve().parent
ASSETS = ROOT / "assets"
FRAMES = ROOT / "frames"
OUTPUT = ROOT / "relevo-video-lanzamiento-4k.mp4"


def font(path: str, size: int) -> ImageFont.FreeTypeFont:
    return ImageFont.truetype(str(ASSETS / path), size=size)


SANS_240 = font("ibm-plex-sans.ttf", 240)
SANS_190 = font("ibm-plex-sans.ttf", 190)
SANS_150 = font("ibm-plex-sans.ttf", 150)
SANS_110 = font("ibm-plex-sans.ttf", 110)
SANS_72 = font("ibm-plex-sans.ttf", 72)
SANS_54 = font("ibm-plex-sans.ttf", 54)
MONO_56 = font("ibm-plex-mono.ttf", 56)
MONO_42 = font("ibm-plex-mono.ttf", 42)


def cover(path: Path, focal_x: float = 0.5, focal_y: float = 0.5) -> Image.Image:
    img = Image.open(path).convert("RGB")
    scale = max(W / img.width, H / img.height)
    nw, nh = math.ceil(img.width * scale), math.ceil(img.height * scale)
    img = img.resize((nw, nh), Image.Resampling.LANCZOS)
    left = int((nw - W) * focal_x)
    top = int((nh - H) * focal_y)
    left = max(0, min(left, nw - W))
    top = max(0, min(top, nh - H))
    return img.crop((left, top, left + W, top + H))


def vertical_gradient(size: tuple[int, int], top_alpha: int, bottom_alpha: int) -> Image.Image:
    grad = Image.new("L", (1, size[1]))
    grad.putdata([
        round(top_alpha + (bottom_alpha - top_alpha) * y / max(1, size[1] - 1))
        for y in range(size[1])
    ])
    return grad.resize(size)


def horizontal_gradient(size: tuple[int, int], left_alpha: int, right_alpha: int) -> Image.Image:
    grad = Image.new("L", (size[0], 1))
    grad.putdata([
        round(left_alpha + (right_alpha - left_alpha) * x / max(1, size[0] - 1))
        for x in range(size[0])
    ])
    return grad.resize(size)


def darken(img: Image.Image, opacity: int = 90) -> Image.Image:
    shade = Image.new("RGB", img.size, BG)
    return Image.blend(img, shade, opacity / 255)


def left_scrim(img: Image.Image, strength: int = 235, end: int = 25) -> Image.Image:
    overlay = Image.new("RGB", img.size, BG)
    return Image.composite(overlay, img, horizontal_gradient(img.size, strength, end))


def add_grain(img: Image.Image, opacity: float = 0.055) -> Image.Image:
    noise = Image.effect_noise((W // 2, H // 2), 28).resize((W, H), Image.Resampling.BILINEAR)
    noise_rgb = Image.merge("RGB", (noise, noise, noise))
    return Image.blend(img, noise_rgb, opacity)


def label(draw: ImageDraw.ImageDraw, text: str, xy: tuple[int, int], fill=MUTED) -> None:
    draw.text(xy, text, font=MONO_42, fill=fill, spacing=12)


def dot_field(draw: ImageDraw.ImageDraw, cx: int, cy: int, radius: int, red_tip: bool = False) -> None:
    for ring in range(1, 18):
        count = 10 + ring * 4
        rr = radius * ring / 18
        for i in range(count):
            a = i * math.tau / count + ring * 0.19
            x = cx + math.cos(a) * rr * (1.0 + 0.08 * math.sin(i * 1.7))
            y = cy + math.sin(a) * rr * 0.62
            s = max(3, 11 - ring // 3)
            alpha = max(65, 230 - ring * 8)
            c = (alpha, alpha, alpha)
            draw.ellipse((x - s, y - s, x + s, y + s), fill=c)
    if red_tip:
        draw.ellipse((cx + radius - 28, cy - 28, cx + radius + 28, cy + 28), fill=RED)


def save(img: Image.Image, index: int, name: str) -> None:
    FRAMES.mkdir(parents=True, exist_ok=True)
    add_grain(img).save(FRAMES / f"{index:02d}-{name}.png", compress_level=2)


def slide_01() -> None:
    img = cover(ASSETS / "01-sesion-digital.png", focal_x=0.58)
    img = left_scrim(darken(img, 35), 245, 15)
    d = ImageDraw.Draw(img)
    label(d, "UNA SITUACIÓN COTIDIANA", (260, 300))
    d.text((250, 500), "A VECES SABES\nQUÉ QUIERES HACER.", font=SANS_190, fill=WHITE, spacing=16)
    d.line((260, 1720, 1130, 1720), fill=(105, 105, 102), width=3)
    d.ellipse((1130, 1704, 1162, 1736), fill=RED)
    save(img, 1, "situacion")


def slide_02() -> None:
    img = Image.new("RGB", (W, H), BG)
    d = ImageDraw.Draw(img)
    label(d, "INTENCIONES ELEGIDAS", (260, 250))
    words = [("LEER.", 430, WHITE), ("CAMINAR.", 900, (200, 200, 195)), ("DIBUJAR.", 1370, WHITE)]
    for text, y, color in words:
        d.text((250, y), text, font=SANS_240, fill=color)
        d.line((2160, y + 155, 3420, y + 155), fill=(82, 82, 80), width=3)
    dot_field(d, 3260, 1080, 380, red_tip=True)
    save(img, 2, "intenciones")


def slide_03() -> None:
    img = cover(ASSETS / "01-sesion-digital.png", focal_x=0.72)
    img = left_scrim(darken(ImageEnhance.Contrast(img).enhance(1.08), 75), 250, 45)
    d = ImageDraw.Draw(img)
    label(d, "CONTINUIDAD DIGITAL", (260, 260))
    d.text((250, 470), "EL SIGUIENTE\nCONTENIDO\nYA ESTÁ AHÍ.", font=SANS_190, fill=WHITE, spacing=4)
    d.text((265, 1660), "La intención deja de orientar\nel próximo paso.", font=SANS_72, fill=(205, 204, 198), spacing=10)
    save(img, 3, "continuidad")


def slide_04() -> None:
    img = Image.new("RGB", (W, H), BG)
    d = ImageDraw.Draw(img)
    dot_field(d, 780, 1110, 600, red_tip=False)
    d.line((1400, 1110, 2230, 1110), fill=(125, 125, 120), width=3)
    d.ellipse((2212, 1092, 2248, 1128), fill=WHITE)
    d.line((2248, 1110, 3100, 1110), fill=(125, 125, 120), width=3)
    d.ellipse((3070, 1080, 3130, 1140), fill=RED)
    label(d, "RELEVO", (1400, 610), WHITE)
    d.text((1390, 740), "TRAE LA INTENCIÓN\nDE VUELTA.", font=SANS_150, fill=WHITE, spacing=14)
    save(img, 4, "relevo")


def rounded_image(img: Image.Image, size: tuple[int, int], radius: int) -> Image.Image:
    img = img.resize(size, Image.Resampling.LANCZOS)
    mask = Image.new("L", size, 0)
    ImageDraw.Draw(mask).rounded_rectangle((0, 0, size[0], size[1]), radius=radius, fill=255)
    out = Image.new("RGBA", size)
    out.paste(img.convert("RGBA"), (0, 0), mask)
    return out


def slide_05() -> None:
    img = Image.new("RGB", (W, H), BG)
    d = ImageDraw.Draw(img)
    label(d, "01 / CONFIGURA", (260, 260))
    d.text((250, 500), "ELIGE UNA\nINTENCIÓN.", font=SANS_190, fill=WHITE, spacing=12)
    d.text((260, 1120), "DEFINE CÓMO\nEMPEZAR.", font=SANS_110, fill=(198, 198, 192), spacing=12)
    d.line((260, 1590, 1640, 1590), fill=(90, 90, 88), width=3)
    d.text((260, 1650), "La aplicación organiza.", font=SANS_54, fill=MUTED)
    phone = rounded_image(Image.open(ASSETS / "03-app-formular.png").convert("RGB"), (890, 1920), 72)
    shadow = Image.new("RGBA", (1100, 2070), (0, 0, 0, 0))
    sd = ImageDraw.Draw(shadow)
    sd.rounded_rectangle((105, 65, 995, 1985), radius=80, fill=(0, 0, 0, 180))
    shadow = shadow.filter(ImageFilter.GaussianBlur(35))
    img.paste(shadow, (2480, 40), shadow)
    img.paste(phone, (2580, 100), phone)
    d = ImageDraw.Draw(img)
    d.rounded_rectangle((2578, 98, 3472, 2022), radius=76, outline=(98, 98, 95), width=4)
    save(img, 5, "configura")


def slide_06() -> None:
    img = cover(ASSETS / "04-contexto-fisico.png", focal_x=0.50)
    img = left_scrim(darken(img, 20), 235, 8)
    d = ImageDraw.Draw(img)
    label(d, "02 / SITÚA", (260, 260))
    d.text((250, 510), "JUNTO AL\nPRIMER PASO.", font=SANS_190, fill=WHITE, spacing=8)
    d.text((260, 1470), "El lugar relaciona la señal\ncon una forma de comenzar.", font=SANS_72, fill=(210, 209, 202), spacing=10)
    d.text((260, 1860), "Forma física exploratoria", font=MONO_42, fill=MUTED)
    save(img, 6, "situa")


def slide_07() -> None:
    img = cover(ASSETS / "02-primer-paso-lectura.png", focal_x=0.45)
    img = left_scrim(darken(img, 18), 238, 10)
    d = ImageDraw.Draw(img)
    label(d, "03 / PULSO", (260, 260))
    d.text((250, 510), "UNA SEÑAL BREVE\nLA HACE PRESENTE.", font=SANS_150, fill=WHITE, spacing=15)
    d.text((260, 1440), "Fuera del teléfono.\nCerca de donde puede empezar.", font=SANS_72, fill=(210, 209, 202), spacing=10)
    d.ellipse((248, 1840, 296, 1888), fill=RED)
    d.line((296, 1864, 1430, 1864), fill=(112, 112, 108), width=3)
    save(img, 7, "pulso")


def slide_08() -> None:
    img = Image.new("RGB", (W, H), BG)
    d = ImageDraw.Draw(img)
    label(d, "AUTONOMÍA", (260, 260))
    rows = [("NO BLOQUEA.", 510), ("NO CASTIGA.", 970), ("NO DECIDE POR TI.", 1430)]
    for idx, (text, y) in enumerate(rows):
        d.text((250, y), text, font=SANS_190, fill=WHITE)
        d.ellipse((3230, y + 85, 3280, y + 135), fill=RED if idx == 2 else (105, 105, 101))
        d.line((2850, y + 110, 3230, y + 110), fill=(85, 85, 82), width=3)
    save(img, 8, "autonomia")


def slide_09() -> None:
    img = Image.new("RGB", (W, H), BG)
    d = ImageDraw.Draw(img)
    label(d, "DESPUÉS DEL PULSO", (260, 250))
    d.text((250, 440), "PUEDES", font=SANS_110, fill=MUTED)
    options = ["EMPEZAR", "CONTINUAR", "CAMBIAR DE IDEA"]
    y = 730
    for idx, option in enumerate(options):
        d.rounded_rectangle((250, y, 3500, y + 300), radius=22, outline=RED if idx == 0 else (102, 102, 98), width=4)
        d.text((350, y + 45), option, font=SANS_150, fill=WHITE)
        d.text((3280, y + 105), f"0{idx + 1}", font=MONO_42, fill=RED if idx == 0 else MUTED)
        y += 365
    d.text((250, 1900), "LA DECISIÓN SIGUE SIENDO TUYA.", font=SANS_72, fill=WHITE)
    save(img, 9, "decision")


def slide_10() -> None:
    img = Image.new("RGB", (W, H), BG)
    d = ImageDraw.Draw(img)
    dot_field(d, 3200, 420, 300, red_tip=True)
    d.text((230, 520), "RELEVO", font=SANS_240, fill=WHITE)
    d.text((250, 940), "QUE UNA INTENCIÓN\nVUELVA A TENER LUGAR.", font=SANS_110, fill=(215, 214, 207), spacing=16)
    d.line((250, 1510, 3380, 1510), fill=(88, 88, 84), width=3)
    d.text((250, 1580), "SISTEMA PHYGITAL PARA RECUPERAR INTENCIONES PERSONALES", font=MONO_42, fill=MUTED)
    d.text((250, 1880), "PROPUESTA EN DESARROLLO · APORTE FÍSICO PENDIENTE DE VALIDACIÓN", font=MONO_42, fill=(126, 126, 122))
    save(img, 10, "cierre")


def build_frames() -> list[Path]:
    for fn in (slide_01, slide_02, slide_03, slide_04, slide_05, slide_06, slide_07, slide_08, slide_09, slide_10):
        fn()
    return sorted(FRAMES.glob("*.png"))


def locate_ffmpeg(explicit: str | None) -> str:
    if explicit:
        return explicit
    try:
        import imageio_ffmpeg

        return imageio_ffmpeg.get_ffmpeg_exe()
    except Exception as exc:  # pragma: no cover - environment fallback
        raise RuntimeError("Provide --ffmpeg or install imageio-ffmpeg") from exc


def render(ffmpeg: str, frames: list[Path]) -> None:
    durations = [4.0, 5.3, 7.2, 3.8, 5.0, 4.8, 7.8, 4.8, 6.8, 7.0]
    fade = 0.6
    total = sum(durations) - fade * (len(durations) - 1)
    cmd = [ffmpeg, "-y"]
    for frame, duration in zip(frames, durations):
        cmd += ["-loop", "1", "-t", str(duration), "-i", str(frame)]
    cmd += ["-i", str(ROOT / "voz-relevo.mp3")]
    cmd += ["-f", "lavfi", "-i", f"sine=frequency=55:sample_rate=48000:duration={total}"]
    cmd += ["-f", "lavfi", "-i", f"sine=frequency=82.41:sample_rate=48000:duration={total}"]
    cmd += ["-f", "lavfi", "-i", "sine=frequency=520:sample_rate=48000:duration=0.55"]
    cmd += ["-i", str(ROOT / "voz-relevo.vtt")]

    vf: list[str] = []
    for i, duration in enumerate(durations):
        frames_count = round(duration * FPS)
        direction = 1 if i % 2 == 0 else -1
        x_expr = "iw/2-(iw/zoom/2)" if direction == 1 else "iw-iw/zoom"
        vf.append(
            f"[{i}:v]scale=3960:2228,crop=3840:2160,"
            f"zoompan=z='1+0.025*on/{max(1, frames_count - 1)}':x='{x_expr}':"
            f"y='ih/2-(ih/zoom/2)':d={frames_count}:s=3840x2160:fps={FPS},"
            f"format=yuv420p[v{i}]"
        )

    last = "v0"
    elapsed = durations[0]
    for i in range(1, len(durations)):
        offset = elapsed - fade
        out = f"x{i}"
        transition = "fade" if i in (3, 7, 9) else ("smoothleft" if i % 2 else "smoothright")
        vf.append(f"[{last}][v{i}]xfade=transition={transition}:duration={fade}:offset={offset:.3f}[{out}]")
        last = out
        elapsed += durations[i] - fade

    vf += [
        "[10:a]highpass=f=75,volume=1.18[voice]",
        f"[11:a]volume=0.034,tremolo=f=0.1:d=0.35,afade=t=in:st=0:d=2,afade=t=out:st={total-3:.2f}:d=3[pad1]",
        f"[12:a]volume=0.018,tremolo=f=0.1:d=0.25,afade=t=in:st=0:d=3,afade=t=out:st={total-4:.2f}:d=4[pad2]",
        "[13:a]asplit=4[p0][p1][p2][p3]",
        "[p0]volume=0.055,afade=t=out:st=0.08:d=0.45,adelay=1800|1800[q0]",
        "[p1]volume=0.045,afade=t=out:st=0.08:d=0.45,adelay=15500|15500[q1]",
        "[p2]volume=0.060,afade=t=out:st=0.08:d=0.45,adelay=26700|26700[q2]",
        "[p3]volume=0.050,afade=t=out:st=0.08:d=0.45,adelay=44700|44700[q3]",
        f"[voice][pad1][pad2][q0][q1][q2][q3]amix=inputs=7:normalize=0,alimiter=limit=0.92,atrim=0:{total}[aout]",
    ]

    cmd += [
        "-filter_complex", ";".join(vf),
        "-map", f"[{last}]",
        "-map", "[aout]",
        "-map", "14:s:0",
        "-c:v", "libx264",
        "-preset", "medium",
        "-crf", "17",
        "-profile:v", "high",
        "-level:v", "5.2",
        "-pix_fmt", "yuv420p",
        "-r", str(FPS),
        "-c:a", "aac",
        "-b:a", "256k",
        "-c:s", "mov_text",
        "-metadata:s:s:0", "language=spa",
        "-metadata:s:s:0", "title=Español",
        "-movflags", "+faststart",
        "-t", f"{total:.3f}",
        str(OUTPUT),
    ]
    subprocess.run(cmd, check=True)


def main() -> None:
    parser = argparse.ArgumentParser(description="Renderiza el video promocional 4K de Relevo")
    parser.add_argument("--ffmpeg", help="Ruta explícita al binario de ffmpeg")
    parser.add_argument("--frames-only", action="store_true")
    args = parser.parse_args()
    frames = build_frames()
    if not args.frames_only:
        render(locate_ffmpeg(args.ffmpeg), frames)
        print(OUTPUT)


if __name__ == "__main__":
    main()
