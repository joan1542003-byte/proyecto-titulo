# Iniciar una conversación de Claude sobre Relevo

Claude debe tener acceso al repositorio completo de GitHub o a una copia local actualizada. En una copia local, abre la raíz que contiene `CLAUDE.md`. Luego pega este mensaje:

> Este es mi proyecto de titulación de Diseño UDP, Relevo. Lee primero `CLAUDE.md` y sigue su protocolo. Después lee `00_gobernanza/traspaso-a-claude-2026-09-24.md` y los documentos primarios que indique para la tarea. Comprueba el último commit y los cambios locales antes de editar. No des por vigentes los archivos históricos ni confundas una función implementada con una prueba validada. Antes de empezar, dime en pocas líneas qué entiendes del proyecto, cuál es el estado confirmado y qué pendiente concreto abordarás. Mantén el repositorio como registro central y documenta el resultado.

Para la primera sesión se recomienda pedirle una **auditoría de continuidad**, no una reescritura general: que compare Android 2.6 con la pauta, privacidad, hoja de ruta, README de validación y memoria; liste las contradicciones con enlaces y resuelva solo la prioridad más urgente. Así podrá demostrar que leyó las fuentes antes de alterar el proyecto.

## Registro de cambios (disclaimer)

### 2026-09-24 — Guía de inicio creada

- **Qué se añadió:** un mensaje inicial listo para copiar y una primera tarea de comprobación acotada.
- **Cómo estaba antes:** no había un prompt corto para iniciar Claude y conducirlo hacia las instrucciones completas del repositorio.
- **Por qué:** facilitar el comienzo sin intentar cargar todo el archivo histórico en el primer mensaje.
