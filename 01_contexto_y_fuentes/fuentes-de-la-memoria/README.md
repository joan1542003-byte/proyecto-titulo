# Fuentes de la memoria

Esta carpeta reúne, en un solo lugar, las 78 fuentes de la lista de referencias de la memoria, para poder revisar cada cita contra el texto original y no contra un resumen o contra la memoria de quien escribe.

## Qué contiene

| Archivo | Qué es | ¿Se versiona? |
| --- | --- | --- |
| [`manifiesto.json`](manifiesto.json) | Las 78 referencias con su clave, su referencia en APA 7, sus vías de acceso legal y el estado de lo que se pudo leer. | Sí |
| [`construir.py`](construir.py) | Script que descarga cada fuente desde sus vías legales y la convierte a Markdown, con la página del PDF marcada. | Sí |
| [`verificacion-capitulos-1-a-6.md`](verificacion-capitulos-1-a-6.md) | Las 40 citas de los capítulos 1 a 6 contrastadas con sus originales, con página, fragmento y dictamen. | Sí |
| `textos/` | Un archivo `.md` por fuente: texto completo, resumen o constancia de por qué no hay texto. | **No** |

`textos/` está excluida del repositorio en `.gitignore`. Muchos de esos textos tienen derechos de autor y el repositorio es público; por eso se guardan solo en el equipo y se vuelven a generar con el script. El mismo criterio llevó a retirar los PDF de la [biblioteca de diseño](../biblioteca_diseno/README.md).

## Cómo regenerar los textos

Requiere Python 3, `pdftotext` y `pdftoppm` (Poppler) y `pandoc`. `tesseract` solo hace falta para el capítulo de Gollwitzer y Sheeran, que está escaneado.

```bash
python3 construir.py                 # las 78 fuentes
python3 construir.py lukoff-2018     # solo las claves indicadas
```

El script indica el resultado de cada fuente: `✓` texto completo, `r` solo resumen y `✗` sin texto, con el motivo. Cada archivo empieza con la referencia, la dirección de donde se obtuvo y una advertencia de uso interno. En los PDF, el marcador `<!-- pág. PDF n -->` señala la página del documento descargado, que no siempre coincide con la de la revista; el manifiesto lo advierte en cada caso.

## Reglas que sigue

- Solo copias legales: editoriales de acceso abierto, Europe PMC y PubMed Central, repositorios institucionales, páginas de los autores, arXiv y sitios oficiales.
- No se usan sitios de copias no autorizadas, ni copias de terceros como SlideShare o Scribd.
- No se eluden desafíos antibots (Cloudflare, Anubis) ni se usan archivos web para sortear un bloqueo. Esas fuentes quedan como «solo resumen» o «sin acceso».
- Un resumen sirve para comprobar la idea central de una fuente, no para citar páginas ni detalles.

## Estado al 2 de noviembre de 2026

| Estado | Fuentes |
| --- | --- |
| Texto completo | 29 |
| Página consultada (sitios, documentación técnica e informes en línea, leídos completos) | 26 |
| Solo resumen (PubMed u OpenAlex) | 9 |
| Sin acceso, con el motivo | 14 |
| **Total** | **78** |

Detalle por fuente, generado desde el manifiesto:

| Fuente | Texto | Origen | Versión, motivo o nota |
| --- | --- | --- | --- |
| Chiu y Gilbert (2024) | completo | Europe PMC |  |
| de Segovia Vicente et al. (2024) | completo | Biblio (Universidad de Gante) |  |
| Gollwitzer y Sheeran (2006) | completo | kops.uni-konstanz.de | versión publicada escaneada (KOPS), leída con OCR: revisar el escaneo antes de citar textualmente |
| Grüning et al. (2023) | completo | pmc.ncbi.nlm.nih.gov |  |
| Haliburton et al. (2024) | completo | medien.ifi.lmu.de |  |
| Ishii y Ullmer (1997) | completo | trackr-media.tangiblemedia.org |  |
| Jiang et al. (2016) | completo | ira.lib.polyu.edu.hk | versión aceptada previa a la edición (PolyU); páginas del manuscrito |
| Jonauskaite et al. (2024) | completo | Serval (Universidad de Lausana) |  |
| Keppel et al. (2025) | completo | sven-mayer.com |  |
| Ley 19.628 (1999) | completo | leychile.cl | texto vigente de la BCN, versión del 10-11-2022 |
| Ley 21.719 (2024) | completo | nuevo.leychile.cl |  |
| Luffarelli et al. (2019) | completo | Figshare (repositorio institucional) | manuscrito de los autores (Sussex) |
| Lukoff et al. (2018) | completo | faculty.washington.edu |  |
| Lyngs et al. (2019) | completo | arxiv.org | versión de arXiv del artículo de CHI 2019 |
| Meier y Reinecke (2021) | completo | OSF | manuscrito de los autores (OSF); páginas del manuscrito |
| Monge Roffarello y De Russis (2023) | completo | iris.polito.it | manuscrito de los autores (Politecnico di Torino); páginas del manuscrito |
| Montag et al. (2019) | completo | pmc.ncbi.nlm.nih.gov |  |
| Peña-Albert et al. (2026) | completo | Infoscience (EPFL) |  |
| Risko y Gilbert (2016) | completo | discovery.ucl.ac.uk | manuscrito aceptado de los autores (UCL); páginas del manuscrito, no de la revista |
| Ryan y Deci (2000) | completo | selfdeterminationtheory.org |  |
| Silverman y Barasch (2023) | completo | udspace.udel.edu |  |
| Smit et al. (2019) | completo | pure.uva.nl |  |
| Sohn et al. (2005) | completo | escholarship.org | informe técnico de UC San Diego (marzo de 2005), anterior a la versión publicada en UbiComp 2005 |
| Stapley et al. (2022) | completo | Figshare (repositorio institucional) |  |
| Terzimehić et al. (2022) | completo | medien.ifi.lmu.de |  |
| Tonietto et al. (2021) | completo | business.rutgers.edu |  |
| Weiser y Brown (1997) | completo | calmtech.com | versión de Xerox PARC del 5 de octubre de 1996 (calmtech.com); sin las páginas del libro |
| Zekveld et al. (2017) | completo | opus.lib.uts.edu.au | última versión de los autores en Word (UTS); sin paginación |
| Zimmerman et al. (2007) | completo | Figshare (repositorio institucional) |  |
| Anthropic (s. f.) | página consultada | claude.com |  |
| Apple (2024) | página consultada | developer.apple.com |  |
| Apple (2025a) | página consultada | developer.apple.com |  |
| Apple (2025b) | página consultada | developer.apple.com |  |
| Apple Developer (s. f.) | página consultada | developer.apple.com | página breve o dinámica: confirmar en el sitio la cifra o el dato que se cita |
| Apple (s. f.) | página consultada | support.apple.com |  |
| Brick LLC (s. f.-a) | página consultada | getbrick.com |  |
| Brick LLC (s. f.-b) | página consultada | getbrick.com | página breve o dinámica: confirmar en el sitio la cifra o el dato que se cita |
| Focusaur (s. f.) | página consultada | focusaur.com |  |
| Google (2026a) | página consultada | developer.android.com |  |
| Google (2026b) | página consultada | developer.android.com |  |
| Google (s. f.) | página consultada | support.google.com |  |
| Kitchen Safe (s. f.) | página consultada | thekitchensafe.com |  |
| MCI Electronics (s. f.) | página consultada | mcielectronics.cl |  |
| Microsoft (2021) | página consultada | download.microsoft.com |  |
| Mindicador (2026) | página consultada | mindicador.cl | página breve o dinámica: confirmar en el sitio la cifra o el dato que se cita |
| Ministerio de Educación (s. f.) | página consultada | mifuturo.cl |  |
| one sec (s. f.) | página consultada | one-sec.app |  |
| Rabbit Hole (s. f.) | página consultada | rabbithole.cl |  |
| Sanders (2026) | página consultada | blog.google | página breve o dinámica: confirmar en el sitio la cifra o el dato que se cita |
| Screenless (s. f.) | página consultada | screenlessapp.com |  |
| Subsecretaría de Telecomunicaciones (2025) | página consultada | subtel.gob.cl |  |
| Supabase (s. f.) | página consultada | supabase.com |  |
| Unpluq (s. f.) | página consultada | unpluq.com |  |
| World Wide Web Consortium (2024) | página consultada | w3.org |  |
| Yablonski (s. f.) | página consultada | lawsofux.com |  |
| Edworthy et al. (1991) | solo resumen | PubMed vía Europe PMC | el texto completo está cerrado o exige navegador |
| Elliot y Maier (2014) | solo resumen | PubMed vía Europe PMC | el texto completo está cerrado o exige navegador |
| Guynn et al. (1998) | solo resumen | PubMed vía Europe PMC | el texto completo está cerrado o exige navegador |
| Hellier et al. (1993) | solo resumen | PubMed vía Europe PMC | el texto completo está cerrado o exige navegador |
| McDaniel y Einstein (2000) | solo resumen | OpenAlex (resumen de la editorial) | el texto completo está cerrado o exige navegador |
| Middlebrooks y Green (1991) | solo resumen | PubMed vía Europe PMC | el texto completo está cerrado o exige navegador |
| O’Rear y Radvansky (2019) | solo resumen | OpenAlex (resumen de la editorial) | el texto completo está cerrado o exige navegador |
| Radtke et al. (2022) | solo resumen | OpenAlex (resumen de la editorial) | el texto completo está cerrado o exige navegador |
| Waggoner et al. (2026) | solo resumen | OpenAlex (resumen de la editorial) | el texto completo está cerrado o exige navegador |
| Fogg (2009) | sin acceso | — | la ACM Digital Library bloquea la descarga automática (403); la copia de SlideShare es de terceros; descargar a mano con navegador o por la biblioteca de la UDP |
| Gembali (2023) | sin acceso | — | DSpace@MIT respondió 429 (demasiadas solicitudes); reintentar o descargar a mano con navegador o por la biblioteca de la UDP |
| Goldsmith (2021) | sin acceso | — | acceso abierto (CC BY-NC-SA), pero NSUWorks exige un desafío de navegador; descargar a mano con navegador o por la biblioteca de la UDP |
| Hermann et al. (2007) | sin acceso | — | actas de IET sin copia abierta; descargar a mano con navegador o por la biblioteca de la UDP |
| International Organization for Standardization (2011) | sin acceso | — | norma de pago; requiere la copia del autor |
| Kirsh (1995) | sin acceso | — | la copia del autor (UCSD) falla por el certificado TLS del servidor y la editorial bloquea la descarga automática; descargar a mano con navegador o por la biblioteca de la UDP |
| Kolko (2011) | sin acceso | — | libro; requiere la copia del autor |
| Miller et al. (2007) | sin acceso | — | revista sin copia abierta; descargar a mano con navegador o por la biblioteca de la UDP |
| Nielsen (1993) | sin acceso | — | libro; requiere la copia del autor |
| Norman (1990) | sin acceso | — | libro; la copia que el autor leyó (biblioteca_diseno) es de la edición de 2002 y se retiró del repositorio por derechos de autor |
| OpenAI (s. f.) | sin acceso | — | chatgpt.com respondió 403 a la consulta automática; revisar la página a mano |
| Riveros Oltra (2023) | sin acceso | — | el Repositorio de la Universidad de Chile exige un desafío antibots (Anubis); el autor tiene el PDF |
| Sanders y Stappers (2012) | sin acceso | — | libro; requiere la copia del autor |
| Venegas Álvarez (2026) | sin acceso | — | el Repositorio de la Universidad de Chile exige un desafío antibots (Anubis); el autor tiene el PDF |

## Lo que falta

Para cerrar la verificación de los capítulos 1 a 6 hacen falta seis textos, que el autor puede descargar con navegador o mediante la biblioteca de la UDP: McDaniel y Einstein (2000), Kirsh (1995), O'Rear y Radvansky (2019), la versión publicada de Sohn et al. (2005), Waggoner et al. (2026) y Radtke et al. (2022); además, confirmar en su copia de Norman la edición y las páginas 73 y 103. Para los capítulos 7 a 14 faltan los libros (Kolko, Nielsen, Sanders y Stappers), la norma ISO 3864-1, las dos memorias de la Universidad de Chile y las fuentes marcadas «sin acceso». El detalle está en la [verificación](verificacion-capitulos-1-a-6.md#fuentes-que-faltan-para-cerrar-la-verificación).

El recordatorio de conseguirlas, ordenado por prioridad, está en [Por hacer, tarea 14, punto H](../../00_gobernanza/por-hacer.md#h-recordatorio-buscar-las-fuentes-que-faltaron-por-verificar).

Un PDF descargado a mano puede dejarse en `textos/` con el nombre de su clave y la extensión `.pdf`, sin subirlo al repositorio, y convertirse con `pdftotext`.

## Registro de cambios (disclaimer)

### 2026-11-02 — Recordatorio en Por hacer

- **Qué cambió:** «Lo que falta» enlaza el recordatorio de la tarea 14.
- **Cómo estaba antes:** la lista de fuentes por conseguir solo estaba aquí y en la verificación.
- **Por qué:** el autor pidió que se le recordara buscar las fuentes que faltan.

### 2026-11-02 — Creación

- **Qué cambió:** se creó la carpeta con el manifiesto de las 78 fuentes, el script que obtiene sus textos, la verificación de los capítulos 1 a 6 y este índice.
- **Cómo estaba antes:** las referencias solo podían revisarse una a una, con resúmenes, matrices de citas o los PDF que el autor tenía en su equipo.
- **Por qué:** el autor pidió leer cada referente completo y tener acceso fácil a los textos originales para revisar las citas con rigor.
