# Conexión de la base remota

## Estado

La base local registra sesiones y eventos seudónimos junto con la versión del consentimiento. El proyecto remoto `Relevo` está activo; el esquema, sus privilegios y las políticas RLS fueron desplegados el 22 de septiembre de 2026. La aplicación dispone localmente de la URL y la clave publicable. No se incorporan credenciales privadas al repositorio.

## Servicio propuesto

Supabase permite usar PostgreSQL, políticas de acceso por fila y una API HTTPS sin añadir un SDK pesado a la aplicación. El esquema mínimo se encuentra en `base-remota-supabase.sql`.

La conexión requiere:

1. el proyecto Supabase `Relevo`, bajo control del responsable de la investigación;
2. `SUPABASE_URL` en `local.properties`;
3. `SUPABASE_PUBLISHABLE_KEY` en `local.properties`; no se utiliza una clave secreta;
4. una fecha de eliminación de los datos;
5. un correo o medio de contacto para retirar el consentimiento;
6. aprobación del texto definitivo de términos y condiciones.

La aplicación autentica cada instalación como usuario anónimo, conserva primero cada sesión y evento en SQLite y reintenta la sincronización al activar, emitir y cerrar un relevo. Cada inserción queda asociada a `auth.uid()` y no se pierde una sesión por falta de internet. La app nunca debe incorporar una clave secreta o `service_role`, porque eluden las políticas de acceso.

## Datos permitidos

- identificador aleatorio de sesión;
- identificador aleatorio del participante, sin nombre, correo ni teléfono;
- tipo de evento;
- aplicación elegida;
- segundos acumulados;
- fecha y hora;
- versión de consentimiento;
- actividad elegida, forma de comenzar y lugar declarado;
- umbral configurado y resultado opcional declarado al finalizar.

No se enviarán nombres, correos, contenido de pantalla, mensajes, historial completo ni identificadores publicitarios.

## Conexión comprobada

El 22 de septiembre de 2026 se comprobó el recorrido remoto completo:

1. Supabase Auth creó un usuario anónimo;
2. la clave publicable permitió insertar una sesión de verificación;
3. la misma instalación pudo leer su propia fila bajo RLS;
4. el registro de verificación fue eliminado;
5. el asesor de seguridad no informó vulnerabilidades.

La configuración local utiliza:

```properties
SUPABASE_URL=https://TU-PROYECTO.supabase.co
SUPABASE_PUBLISHABLE_KEY=sb_publishable_...
```

La aplicación puede leer, actualizar y borrar únicamente sus propias sesiones; actualizar permite repetir un envío sin duplicarlo. Los eventos y las respuestas se insertan una vez y no se actualizan, pero cada instalación puede leer y borrar los suyos. La lectura no es opcional: sin ella, PostgreSQL rechaza las inserciones con `on_conflict` que usa la app. La revisión consolidada utiliza un entorno administrativo protegido.

## Estado comprobado el 24 y 25 de septiembre de 2026

- **Región y políticas.** Una consulta de solo lectura confirmó que el proyecto está en `ca-central-1` (Canadá) y que las políticas coinciden con [`base-remota-supabase.sql`](base-remota-supabase.sql).
- **Eventos.** La base tenía 4 sesiones técnicas del 22 y 23 de septiembre y **ningún evento**. La causa fue la falta del permiso de lectura sobre `relevo_events`, que se concedió el 24 de septiembre, y que la app dejaba de enviar en el primer rechazo.
- **Migraciones.** `relevo_monitor_interruption_events` (24 de septiembre) y `relevo_prueba_21_dias` (25 de septiembre) añadieron tipos de evento, columnas de la prueba de 21 días y la tabla `relevo_answers`.
- **Verificación con Android 2.7.** En emulador, con datos ficticios, llegaron sesiones, eventos y respuestas, y el borrado desde la app los eliminó ([detalle](version-2.7-prueba-21-dias-2026-09-25.md)).

## Registro de cambios (disclaimer)

### 2026-09-25 — Eventos, respuestas y Android 2.7

- **Qué cambió:** se corrigieron los permisos descritos, se añadieron la causa de la falta de eventos, las dos migraciones y la verificación con la versión 2.7.
- **Cómo estaba antes:** los eventos figuraban como de solo inserción, sin permiso de lectura, y el documento no registraba que la base tenía 0 eventos.
- **Por qué:** el documento debe coincidir con la base desplegada y explicar por qué la lectura es necesaria.

### 2026-09-21 — Preparación del backend

- **Cambio:** se definieron el servicio, el esquema mínimo y las condiciones de seguridad para la sincronización.
- **Versión anterior:** solo existía la base SQLite privada del teléfono.
- **Motivo:** permitir consolidar sesiones sin presentar como terminada una conexión que todavía no tiene credenciales ni responsable configurado.

### 2026-09-22 — Cola de sincronización implementada

- **Cambio:** se incorporaron autenticación anónima, cola local, reintentos idempotentes y tablas separadas para sesiones y eventos.
- **Versión anterior:** solo existían el esquema propuesto y el registro local de eventos.
- **Motivo:** recopilar actividad seleccionada, condición, señal, tiempo observado y respuesta opcional sin depender de conectividad permanente.
- **Límite:** la prueba remota respondió `anonymous_provider_disabled`; falta activar el acceso anónimo antes de comprobar la escritura desde una instalación.

### 2026-09-22 — Infraestructura remota desplegada

- **Cambio:** se desplegaron las tablas, restricciones, índices, privilegios mínimos y políticas RLS en el proyecto remoto.
- **Versión anterior:** el esquema existía únicamente como archivo local.
- **Motivo:** asegurar que el testeo pueda consolidar datos reales sin exponer claves administrativas ni permitir lectura entre participantes.
- **Verificación:** el asesor de seguridad no informó vulnerabilidades; se eliminó un índice duplicado señalado por el asesor de rendimiento.

### 2026-09-22 — Segunda comprobación de conexión

- **Cambio:** se repitió una autenticación real contra el proyecto `Relevo` después de integrar la versión 1.6.
- **Resultado:** el proyecto, la URL, la clave publicable, las tablas y RLS responden; Auth continúa devolviendo `anonymous_provider_disabled`.
- **Decisión:** no se abrieron inserciones públicas ni se incorporó una clave privilegiada para evitar el control de acceso. La conexión quedará operativa inmediatamente después de activar el proveedor anónimo en el panel del proyecto.

### 2026-09-22 — Conexión operativa

- **Cambio:** se habilitó la autenticación anónima y se repitió la prueba con la misma ruta HTTPS que utiliza la aplicación.
- **Resultado:** autenticación `200`, inserción `201`, lectura `200` y una fila visible únicamente para la instalación autenticada.
- **Limpieza:** la sesión de verificación se eliminó; no quedó información de prueba en las tablas.
- **Motivo:** distinguir una infraestructura configurada de una conexión realmente comprobada antes del testeo con participantes.
