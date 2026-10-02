# Movimiento y sonido

## En la interfaz

- Transiciones de 200 a 250 ms con `cubic-bezier(.2, 0, 0, 1)`: salen rápido y llegan suave. Sin rebotes ni resortes.
- Al presionar, los controles se hunden a 92–97 %.
- La trama de la señal late mientras suena y se detiene fuera de la vista.

## La animación de marca: escribir sobre el renglón

Es la única animación con carácter, y siempre dice lo mismo: algo se escribe sobre un renglón.

- **En la firma** (`Signature` con `animate`): la palabra de la persona aparece de izquierda a derecha sobre el renglón en 450 ms, lineal.
- **En el logotipo** (`logo-animado.mp4`, 4 s a 30 cuadros):

| Tiempo | Qué pasa |
| --- | --- |
| 0,35 – 1,05 s | El renglón se escribe bajo la palabra, con salida suave. |
| 0,55 – 1,22 s | Las letras aparecen de a una, cada 70 ms, subiendo un poco. |
| 1,05 s | Primera nota de la firma sonora. |
| 1,45 – 1,95 s | El renglón pasa la «o»: hace lugar. |
| 1,60 s | Segunda nota. |

Úsala al abrir una presentación, al final de un video y en la primera pantalla de la guía. No en cada apertura de la app.

## Firma sonora

Dos notas de timbre de madera que bajan, 587 Hz (re) y 440 Hz (la), una sola vez, con un ataque breve de banda ancha; 2,2 s en total (D-071). Va con el logotipo animado y puede sonar al terminar la guía. No reemplaza la señal del parlante, que dura unos 30 segundos y es otra cosa: un aviso, no una marca.

**Por qué así:** los sonidos más graves y más lentos se perciben menos urgentes (Edworthy et al., 1991); Relevo avisa sin alarmar. Los logos sonoros pueden cambiar cómo se percibe una marca (Krishnan et al., 2012): por eso este es breve, tranquilo y siempre igual.

## Menos movimiento

Si el sistema pide reducir el movimiento, no hay animaciones: se muestra el estado final (el logotipo completo, la firma escrita, la trama quieta). El sonido de marca solo suena si la persona lo activó; nunca en silencio del teléfono.

## Registro de cambios (disclaimer)

### 2026-10-02 — Sistema 3.1

- **Qué cambió:** sección nueva: movimiento de la interfaz, el logotipo animado y la firma sonora.
- **Cómo estaba antes:** el movimiento se describía en el README y no había animación de logotipo ni sonido.
- **Por qué:** el autor pidió el 1 de octubre seguir con iconografía, tipografías y diseños, con muchos recursos argumentados en la memoria o en principios de diseño, un logotipo y una selección tipográfica cuidados, y libertad para usar más de un color.
