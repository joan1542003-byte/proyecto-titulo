# Repaso Relevo en GitHub Pages

**Dirección:** https://joan1542003-byte.github.io/proyecto-titulo/
**Fecha:** 26 de noviembre de 2026

Esta carpeta publica [Repaso Relevo](../52_repaso-relevo.html), la herramienta del [plan de estudio](../52_plan-de-estudio-examen-2026-12.md), como un sitio de GitHub Pages. Así se abre en el teléfono, se instala como app y funciona sin internet. La página es la misma que se abre con doble clic: no hay otra copia que mantener.

## Qué hay

| Archivo | Para qué sirve |
| --- | --- |
| `manifest.webmanifest` | El nombre, los colores y los íconos con que se instala en el teléfono. |
| `sw.js` | Guarda la página para usarla sin internet. Con internet, trae siempre la versión más nueva. No toca el avance. |
| `icono-180.png`, `icono-192.png`, `icono-512.png`, `icono-maskable-512.png` | El ícono de la app, hecho con el ícono oficial de Relevo ([`relevo-icono-app.svg`](../logo-relevo-2026-10-11/relevo-icono-app.svg)). |
| `publicar.sh` | Sube la página y estos archivos a la rama `gh-pages`, que es la que muestra GitHub Pages. |

## Cómo se publica un cambio

Se edita `../52_repaso-relevo.html`, se sube a `main` y se corre, desde la raíz del repositorio:

```bash
bash 10_recursos_visuales/52_repaso-relevo-sitio/publicar.sh
```

El script arma la rama `gh-pages` con `index.html` (la página), estos archivos y `.nojekyll`, sin cambiar la rama de trabajo. GitHub tarda uno o dos minutos en mostrar el cambio. Si se cambia `sw.js`, conviene cambiar también el nombre de su caché.

## El avance

El avance se guarda solo en el navegador de cada dispositivo (`localStorage`, clave `repaso-relevo-v1`). No hay servidor ni cuentas, y nada pasa por la nube de Claude. En Mi avance se descarga una copia o se crea un código para unir el avance de dos dispositivos. La página es pública para quien tenga el enlace, como el repositorio, y pide a los buscadores no mostrarla (`noindex`).

## Registro de cambios (disclaimer)

### 2026-11-26 — Creación

- **Qué cambió:** se creó el sitio de Repaso Relevo en GitHub Pages, con su manifiesto, su service worker, los íconos y el script que lo publica.
- **Cómo estaba antes:** Repaso Relevo solo se abría con doble clic en el computador.
- **Por qué:** el autor pidió subirlo a GitHub Pages para estudiar con su avance guardado.
