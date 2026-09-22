# Conexión de la base remota

## Estado

La base local registra sesiones y eventos seudónimos junto con la versión del consentimiento. La aplicación incorpora una cola de sincronización para Supabase, pero permanece inactiva mientras `SUPABASE_URL` y `SUPABASE_PUBLISHABLE_KEY` no estén definidas en `local.properties`. No se deben incorporar credenciales privadas al repositorio.

## Servicio propuesto

Supabase permite usar PostgreSQL, políticas de acceso por fila y una API HTTPS sin añadir un SDK pesado a la aplicación. El esquema mínimo se encuentra en `base-remota-supabase.sql`.

Para finalizar la conexión se requieren:

1. un proyecto Supabase bajo control del responsable de la investigación;
2. `SUPABASE_URL` en `local.properties`;
3. `SUPABASE_PUBLISHABLE_KEY` en `local.properties`; no se utiliza una clave secreta;
4. una fecha de eliminación de los datos;
5. un correo o medio de contacto para retirar el consentimiento;
6. aprobación del texto definitivo de términos y condiciones.

La aplicación autentica cada instalación como usuario anónimo, conserva primero cada sesión y evento en SQLite y reintenta la sincronización al activar, emitir y cerrar un relevo. Cada inserción queda asociada a `auth.uid()` y no se pierde una sesión por falta de internet. La app nunca debe incorporar una clave secreta o `service_role`, porque eluden las políticas de acceso.

## Datos permitidos

- identificador aleatorio de sesión;
- código seudónimo;
- tipo de evento;
- aplicación elegida;
- segundos acumulados;
- fecha y hora;
- versión de consentimiento;
- actividad elegida, forma de comenzar y lugar declarado;
- umbral configurado y resultado opcional declarado al finalizar.

No se enviarán nombres, correos, contenido de pantalla, mensajes, historial completo ni identificadores publicitarios.

## Activación

1. ejecutar `base-remota-supabase.sql` en el editor SQL del proyecto;
2. habilitar usuarios anónimos en Supabase Auth;
3. añadir a `local.properties`:

```properties
SUPABASE_URL=https://TU-PROYECTO.supabase.co
SUPABASE_PUBLISHABLE_KEY=sb_publishable_...
```

4. recompilar e instalar el APK;
5. crear y cerrar un relevo de prueba;
6. comprobar que `relevo_sessions` y `relevo_events` reciban filas asociadas al mismo `session_id`.

La aplicación puede leer y actualizar únicamente sus propias sesiones, condición necesaria para repetir un envío sin duplicarlo. Los eventos son de solo inserción. La revisión consolidada utiliza un entorno administrativo protegido.

## Registro de cambios (disclaimer)

### 2026-09-21 — Preparación del backend

- **Cambio:** se definieron el servicio, el esquema mínimo y las condiciones de seguridad para la sincronización.
- **Versión anterior:** solo existía la base SQLite privada del teléfono.
- **Motivo:** permitir consolidar sesiones sin presentar como terminada una conexión que todavía no tiene credenciales ni responsable configurado.

### 2026-09-22 — Cola de sincronización implementada

- **Cambio:** se incorporaron autenticación anónima, cola local, reintentos idempotentes y tablas separadas para sesiones y eventos.
- **Versión anterior:** solo existían el esquema propuesto y el registro local de eventos.
- **Motivo:** recopilar actividad seleccionada, condición, señal, tiempo observado y respuesta opcional sin depender de conectividad permanente.
- **Límite:** falta incorporar las credenciales publicables del proyecto y ejecutar el esquema para comprobar el envío remoto real.
