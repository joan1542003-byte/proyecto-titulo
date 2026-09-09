$ErrorActionPreference = 'Stop'

$repo = (Resolve-Path (Join-Path $PSScriptRoot '..')).Path
$broken = @()
$checked = 0

git -C $repo -c core.quotepath=false ls-files --cached --others --exclude-standard '*.md' | ForEach-Object {
    $relative = $_
    $file = Join-Path $repo $relative
    $content = [System.IO.File]::ReadAllText($file)

    [regex]::Matches($content, '!?(?:\[[^\]]*\])\(([^)]+)\)') | ForEach-Object {
        $target = $_.Groups[1].Value.Trim()
        if ($target -match '^(https?://|mailto:|#|data:|codex:|app:)' -or $target -eq '') { return }
        if ($target.StartsWith('<') -and $target.EndsWith('>')) { $target = $target.Substring(1, $target.Length - 2) }
        $target = $target -replace '\s+"[^"]*"$', ''
        $path = ($target -split '#', 2)[0]
        if ($path -eq '') { return }

        $checked += 1
        $candidate = Join-Path (Split-Path $file) ([System.Uri]::UnescapeDataString($path))
        if (-not (Test-Path -LiteralPath $candidate)) {
            $broken += "$relative -> $target"
        }
    }
}

if ($broken.Count -gt 0) {
    $broken | Sort-Object -Unique | ForEach-Object { Write-Error $_ }
    exit 1
}

Write-Output "Enlaces locales Markdown: $checked comprobados; 0 rotos."
