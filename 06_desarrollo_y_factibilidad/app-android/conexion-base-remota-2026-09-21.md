# Conexión de la base remota

## Estado

La base local funciona y registra eventos seudónimos junto con la versión del consentimiento. La sincronización remota no está activada porque este repositorio no contiene una dirección de proyecto ni una clave pública de acceso. No se deben incorporar credenciales privadas al código ni usar una base pública sin políticas de seguridad.

## Servicio propuesto

Supabase permite usar PostgreSQL, políticas de acceso por fila y una API HTTPS sin añadir un SDK pesado a la aplicación. El esquema mínimo se encuentra en `base-remota-supabase.sql`.

Para finalizar la conexión se requieren:

1. un proyecto Supabase bajo control del responsable de la investigación;
2. `SUPABASE_URL`;
3. una clave publicable, limitada mediante políticas; no se utiliza una clave secreta;
4. una fecha de eliminación de los datos;
5. un correo o medio de contacto para retirar el consentimiento;
6. aprobación del texto definitivo de términos y condiciones.

La aplicación debe autenticar a cada instalación como usuario anónimo, conservar primero cada evento en SQLite y sincronizarlo cuando exista conexión. Así, cada inserción queda asociada a `auth.uid()` y no se pierde una sesión por falta de internet. La app nunca debe incorporar una clave secreta o `service_role`, porque eluden las políticas de acceso.

## Datos permitidos

- identificador aleatorio de sesión;
- código seudónimo;
- tipo de evento;
- aplicación elegida;
- segundos acumulados;
- fecha y hora;
- versión de consentimiento.

No se enviarán nombres, correos, contenido de pantalla, mensajes, historial completo ni identificadores publicitarios.

## Registro de cambios (disclaimer)

### 2026-09-21 — Preparación del backend

- **Cambio:** se definieron el servicio, el esquema mínimo y las condiciones de seguridad para la sincronización.
- **Versión anterior:** solo existía la base SQLite privada del teléfono.
- **Motivo:** permitir consolidar sesiones sin presentar como terminada una conexión que todavía no tiene credenciales ni responsable configurado.
