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
| `servidor-supabase.sql` | Las tablas y funciones del servidor que guarda el avance. No se publica en el sitio. |

## Cómo se publica un cambio

Se edita `../52_repaso-relevo.html`, se sube a `main` y se corre, desde la raíz del repositorio:

```bash
bash 10_recursos_visuales/52_repaso-relevo-sitio/publicar.sh
```

El script arma la rama `gh-pages` con `index.html` (la página), estos archivos y `.nojekyll`, sin cambiar la rama de trabajo. GitHub tarda uno o dos minutos en mostrar el cambio. Si se cambia `sw.js`, conviene cambiar también el nombre de su caché.

## El avance y el servidor

- **Servidor:** un proyecto de Supabase propio, `repaso-relevo` (`vogqmiuhlgcajhhzvrws`, plan gratuito, región de América), en la cuenta de Supabase del autor a la que se entra con GitHub. Está aparte del proyecto de la app y de la prueba. Lo creó Claude el 26 de noviembre, a pedido del autor.
- **Qué guarda:** una fila con el avance (`repaso_avance`) por cada clave registrada (`repaso_claves`). Nadie lee ni escribe las tablas directo: solo las funciones `repaso_leer` y `repaso_guardar`, y solo con una clave registrada. Se guarda la huella SHA-256 de la clave, nunca la clave. Lo instala [`servidor-supabase.sql`](servidor-supabase.sql), que se corre una vez en el editor SQL de Supabase.
- **La clave:** está solo en el computador del autor, en Documentos, “Repaso Relevo - clave del servidor”. Cada dispositivo se conecta una vez en Mi avance. La página la guarda aparte del avance (`localStorage`, clave `repaso-relevo-servidor`), así que no va en las copias ni en los códigos.
- **En el navegador:** el avance también queda en cada dispositivo (`localStorage`, clave `repaso-relevo-v1`), para usarlo sin internet. Al abrir la página, se une lo del servidor con lo del dispositivo: de cada tarjeta queda la versión más repasada.
- **La clave publicable** del proyecto va en la página, como la de la app (D-161): sin una clave registrada no da acceso a nada.
- **Cambiar la clave o borrar todo:** el final de `servidor-supabase.sql` lo explica. El servidor gratuito se pausa tras una semana sin uso; se reactiva en supabase.com.
- **Comprobado el 26 de noviembre:** una clave falsa recibe 403, la tabla no se puede leer directo y el avance de dos navegadores se unió en el servidor.

La página es pública para quien tenga el enlace, como el repositorio, y pide a los buscadores no mostrarla (`noindex`). El avance no es público.

## Registro de cambios (disclaimer)

### 2026-11-26 — Servidor para el avance

- **Qué cambió:** se creó el proyecto de Supabase `repaso-relevo` con dos tablas y dos funciones que guardan el avance con la clave del autor, y la página se conecta a él.
- **Cómo estaba antes:** el avance vivía solo en el navegador de cada dispositivo.
- **Por qué:** el autor pidió guardar el avance en un servidor. Eligió Supabase y pidió crear un proyecto, porque su cuenta no tiene el de la app.

### 2026-11-26 — Creación

- **Qué cambió:** se creó el sitio de Repaso Relevo en GitHub Pages, con su manifiesto, su service worker, los íconos y el script que lo publica.
- **Cómo estaba antes:** Repaso Relevo solo se abría con doble clic en el computador.
- **Por qué:** el autor pidió subirlo a GitHub Pages para estudiar con su avance guardado.
