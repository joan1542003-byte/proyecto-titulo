param(
  [string]$RepositoryRoot = (Resolve-Path (Join-Path $PSScriptRoot "../../../..")).Path
)

$ErrorActionPreference = "Stop"

$deliveryRoot = Join-Path $RepositoryRoot "00_admin/encargos/encargo-02-09-2026"
$routeSource = Join-Path $deliveryRoot "02_wireframes_ruta_principal"
$coverageSource = Join-Path $deliveryRoot "03_estados_cobertura"
$mapRoot = Join-Path $deliveryRoot "04_mapa_completo"
$explanationPath = Join-Path $deliveryRoot "EXPLICACION-Y-JUSTIFICACION.md"
$principalSource = Join-Path $deliveryRoot "01_pantalla_principal_alta_fidelidad/3-1-ciclo-activo-alta-fidelidad-v3.png"

$explanation = Get-Content -LiteralPath $explanationPath -Raw -Encoding UTF8

$routeGroups = @{
  "1" = "01_formular_y_preparar"
  "2" = "02_situar_probar_y_armar"
  "3" = "03_recibir_y_cerrar"
}

$visualNotes = @{
  "1.1" = "Los dos campos se presentan como líneas de escritura y no como tarjetas. La pregunta abre el recorrido, mientras la explicación breve aclara el nivel de concreción esperado sin competir con la acción de continuar."
  "1.2" = "Las tres decisiones se agrupan en controles equivalentes, con contorno visible y flecha lateral. La repetición permite comparar aplicación, condición y vigencia sin introducir una jerarquía que todavía no corresponde."
  "1.3" = "La revisión transforma lo ingresado en una lectura vertical estable. Los separadores ordenan cada dato y el aviso de estado distingue con claridad que el ciclo aún no está armado."
  "2.1" = "El testigo se describe mediante datos verificables y una sola acción principal. El bloque de apoyo se reconoce como información porque carece de contenedor y utiliza una línea inicial, no la apariencia de un botón."
  "2.2" = "La pantalla conserva a la vista la intención, el primer paso y el lugar durante la prueba. Emitir el pulso es la única acción delimitada; la evaluación de su percepción ocurre después y permanece bajo control de la persona."
  "2.3" = "El diagrama circular representa el control físico y se acompaña con una instrucción temporal. El estado de espera no se dibuja como botón: el armado se confirma en el testigo, mientras la pantalla solo permite abandonar el proceso."
  "3.1" = "El ciclo activo prioriza lectura y vigilancia del estado. La ausencia de rojo comunica que la señal situada todavía no ocurre; el único control disponible permite desarmar el ciclo de forma explícita."
  "3.2" = "El campo de puntos representa la transferencia de una señal, no un conjunto de opciones. Un único punto rojo identifica el momento situado. Los controles reales quedan separados en el borde inferior y mantienen etiquetas verbales; no se incluyen iconos sin una función definida."
  "3.3" = "El cierre se presenta como un estado neutral, sin recompensa ni evaluación de conducta. La última configuración queda disponible como referencia y las acciones permiten salir o preparar otro ciclo sin rearmarlo automáticamente."
}

$coverageGroups = @(
  @{ Start = 1; End = 6; Folder = "A_preparar_la_intencion" },
  @{ Start = 7; End = 14; Folder = "B_vincular_y_probar_el_testigo" },
  @{ Start = 15; End = 19; Folder = "C_armar_el_ciclo" },
  @{ Start = 20; End = 24; Folder = "D_esperar_y_emitir_la_senal" },
  @{ Start = 25; End = 35; Folder = "E_cerrar_y_recuperar" }
)

function Write-Utf8File {
  param([string]$Path, [string]$Content)
  $parent = Split-Path -Parent $Path
  New-Item -ItemType Directory -Path $parent -Force | Out-Null
  [System.IO.File]::WriteAllText($Path, $Content, [System.Text.UTF8Encoding]::new($false))
}

function Copy-Frame {
  param([string]$Source, [string]$DestinationFolder)
  New-Item -ItemType Directory -Path $DestinationFolder -Force | Out-Null
  Copy-Item -LiteralPath $Source -Destination (Join-Path $DestinationFolder "wireframe.png") -Force
}

New-Item -ItemType Directory -Path (Join-Path $mapRoot "00_mapa_general") -Force | Out-Null

$routeText = ($explanation -split "## Estados de cobertura")[0]
Get-ChildItem -LiteralPath $routeSource -File -Filter "*.png" | Sort-Object Name | ForEach-Object {
  if ($_.BaseName -notmatch "^(\d)-(\d)-(.+)$") { return }
  $major = $Matches[1]
  $minor = $Matches[2]
  $id = "$major.$minor"
  $slug = $_.BaseName
  $pattern = "(?ms)^###\s+$([regex]::Escape($id))\s+([^\r\n]+)\r?\n\r?\n(.+?)(?=\r?\n###|\z)"
  $match = [regex]::Match($routeText, $pattern)
  if (-not $match.Success) { throw "No se encontró la explicación de $id" }
  $title = $match.Groups[1].Value.Trim()
  $body = $match.Groups[2].Value.Trim()
  $target = Join-Path $mapRoot "01_ruta_principal/$($routeGroups[$major])/$slug"
  Copy-Frame -Source $_.FullName -DestinationFolder $target
  $development = ""
  $incorporated = "el wireframe, su explicación y su ubicación dentro del mapa organizado"
  if ($id -eq "3.1" -and (Test-Path -LiteralPath $principalSource)) {
    Copy-Item -LiteralPath $principalSource -Destination (Join-Path $target "pantalla-alta-fidelidad.png") -Force
    $development = @"

## Desarrollo visual relacionado

`pantalla-alta-fidelidad.png` desarrolla este marco con el sistema visual oscuro vigente. Se eligió como pantalla destacada porque reúne las variables centrales del ciclo y representa una vista real de la aplicación. El pulso situado todavía no ocurre, por lo que el rojo permanece ausente.
"@
    $incorporated = "el wireframe, su explicación, su ubicación dentro del mapa organizado y la versión relacionada de alta fidelidad"
  }
  $readme = @"
# $id $title

![Wireframe $id $title](wireframe.png)

## Qué muestra y por qué existe

$body

## Lugar dentro del recorrido

Este marco pertenece a la interacción $major de la ruta principal. La numeración permite reconocer su posición sin confundirla con los estados técnicos y las excepciones de cobertura.

## Decisiones visuales

$($visualNotes[$id])
$development

---

## Registro de cambios (disclaimer)

- **Qué se incorporó:** $incorporated.
- **Cómo estaba antes:** la imagen estaba disponible únicamente en una carpeta plana junto a los demás marcos.
- **Por qué se hizo:** facilitar la revisión individual sin perder la relación con la sección y el recorrido completo.
- **Alcance:** este archivo documenta una decisión estructural; no acredita validación con personas ni funcionamiento técnico.
"@
  Write-Utf8File -Path (Join-Path $target "README.md") -Content $readme
}

$coverageRows = [regex]::Matches(
  $explanation,
  '(?m)^\| \*\*(\d{2})\.\s+(.+?)\*\* \| (.+?) \| (.+?) \|\s*$'
)

foreach ($row in $coverageRows) {
  $id = $row.Groups[1].Value
  $title = $row.Groups[2].Value.Trim()
  $reason = $row.Groups[3].Value.Trim()
  $continuity = $row.Groups[4].Value.Trim()
  $number = [int]$id
  $family = $coverageGroups | Where-Object { $number -ge $_.Start -and $number -le $_.End } | Select-Object -First 1
  if (-not $family) { throw "No se encontró familia para el estado $id" }
  $source = Get-ChildItem -LiteralPath $coverageSource -File -Filter "cobertura-$id-*.png" | Select-Object -First 1
  if (-not $source) { throw "No se encontró PNG para el estado $id" }
  $target = Join-Path $mapRoot "02_cobertura/$($family.Folder)/$($source.BaseName)"
  Copy-Frame -Source $source.FullName -DestinationFolder $target
  $readme = @"
# Estado $id — $title

![Wireframe del estado $id — $title](wireframe.png)

## Qué resuelve

$reason

## Qué puede ocurrir después

$continuity

Este estado forma parte de la cobertura del sistema. Aparece solo cuando se cumple su condición y no agrega un paso obligatorio a la ruta principal.

---

## Registro de cambios (disclaimer)

- **Qué se incorporó:** el wireframe y una explicación breve de su función y continuidad.
- **Cómo estaba antes:** la imagen estaba reunida en una carpeta plana con los demás estados.
- **Por qué se hizo:** permitir una lectura individual y mantener visible la familia a la que pertenece.
- **Alcance:** este archivo anticipa un estado posible; no demuestra que la condición técnica ya haya sido implementada o validada.
"@
  Write-Utf8File -Path (Join-Path $target "README.md") -Content $readme
}

$mapReadme = @"
# Mapa organizado de wireframes

Esta carpeta permite revisar la propuesta en tres escalas complementarias:

1. **00_mapa_general/mapa-general-jerarquico.png** presenta la arquitectura completa sin reducir los marcos a miniaturas ilegibles.
2. **00_mapa_general/mapa-ruta-principal-legible.png** muestra las nueve pantallas en orden y con tamaño suficiente para leerlas.
3. **00_mapa_general/mapa-cobertura-por-familias.png** reúne los 35 estados técnicos, salidas y recuperaciones según cinco familias.

Las carpetas **01_ruta_principal** y **02_cobertura** permiten continuar desde esos mapas hasta cada pieza individual.

Cada wireframe tiene una carpeta propia con **wireframe.png** y **README.md**. La organización separa el recorrido que una persona podría seguir de los estados que solo aparecen en condiciones particulares.

El marco **3.2 Recibir el pulso situado** representa un momento físico del recorrido. No corresponde a una pantalla instalada en el testigo.

---

## Registro de cambios (disclaimer)

- **Qué se incorporó:** un mapa jerárquico, un atlas legible de la ruta, una lámina de cobertura y navegación hasta cada wireframe individual.
- **Cómo estaba antes:** una sola imagen reunía 44 miniaturas, cuyo contenido no podía leerse a una escala normal de revisión.
- **Por qué se hizo:** separar niveles de información y permitir que cada mapa cumpla una función concreta sin perder la arquitectura completa.
- **Alcance:** la estructura ordena los archivos vigentes; no altera el contenido funcional de los wireframes.
"@
Write-Utf8File -Path (Join-Path $mapRoot "README.md") -Content $mapReadme

Write-Output "Ruta principal organizada: $((Get-ChildItem -LiteralPath (Join-Path $mapRoot '01_ruta_principal') -Recurse -File -Filter 'wireframe.png').Count)"
Write-Output "Estados organizados: $((Get-ChildItem -LiteralPath (Join-Path $mapRoot '02_cobertura') -Recurse -File -Filter 'wireframe.png').Count)"
