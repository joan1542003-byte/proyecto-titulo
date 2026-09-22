# Aplicación Android de Relevo

Prototipo funcional para preparar una intención, elegir una aplicación y emitir una señal cuando esa aplicación permanece en primer plano durante el tiempo definido.

## Estado

**Versión:** 1.7 de prueba

**Fecha:** 22 de septiembre de 2026

**Identificador:** `cl.udp.relevo`

**Android mínimo:** 8.0, API 26

**APK vigente:** [relevo-android-1.7-2026-09-22.apk](releases/relevo-android-1.7-2026-09-22.apk)

La aplicación compila, sus pruebas unitarias pasan y la condición automática fue comprobada en Android: al mantener la aplicación elegida en primer plano durante el tiempo configurado, el recordatorio cambia a señal emitida.

## Qué permite hacer

1. escribir una actividad y una forma concreta de comenzar;
2. elegir una aplicación instalada;
3. partir de un preestablecido o escribir una actividad propia;
4. definir el tiempo acumulado entre 1 y 60 minutos mediante un deslizador, además de accesos rápidos y una prueba de 15 segundos;
5. reconocer las aplicaciones por su icono real;
6. consultar Inicio, Actividad y el historial de relevos;
7. ver dónde quedó situada la última señal;
8. autorizar el acceso de uso y las notificaciones exigidas por Android;
9. crear un identificador aleatorio que agrupa los datos sin solicitar nombre, correo ni teléfono;
10. activar un monitoreo visible mediante una notificación persistente;
11. emitir alarma, vibración y notificación cuando se cumple la condición;
12. pausar el conteo si la persona sale de la aplicación y retomarlo cuando vuelve;
13. desactivar, silenciar y cerrar el ciclo.
14. responder opcionalmente qué decidió hacer después de la señal;
15. contar cuántas veces se eligió cada actividad;
16. conservar sesiones y eventos sin conexión y enviarlos a Supabase cuando la base está configurada.
17. solicitar una sola vez el consentimiento para uso académico antes de mostrar el tutorial o iniciar cualquier registro;
18. enseñar el recorrido mediante cinco escenas ilustradas: elegir, configurar, situar, recibir el aviso y conceder los permisos necesarios.

## Límites

Relevo reconoce qué aplicación está en primer plano, pero no lee mensajes, imágenes, búsquedas ni contenidos. Sesiones y eventos se guardan primero en SQLite y luego se sincronizan con Supabase. La autenticación anónima, las tablas y las políticas RLS fueron comprobadas mediante una escritura y lectura reales; el registro de verificación se eliminó al terminar la prueba.

La señal se reproduce mediante Android. Si el teléfono está conectado a un parlante Bluetooth, Android puede dirigir el audio al parlante. La integración directa con un objeto físico independiente sigue siendo una etapa posterior.

## Instalación y permiso

1. instalar el APK;
2. abrir Relevo;
3. leer y aceptar el uso académico de los datos;
4. recorrer el tutorial;
5. autorizar **Tiempo de uso** en la última escena;
6. autorizar notificaciones si se quiere recibir el aviso con otra aplicación abierta.

Android muestra una notificación mientras el recordatorio está activo. Esta visibilidad comunica que existe observación en curso y no debe eliminarse.

## Datos de prueba

La estructura y sus límites están descritos en [detección de uso y datos](arquitectura-deteccion-uso-y-datos-2026-09-21.md). Para pruebas académicas se debe usar un código como `P01`; nunca el nombre de la persona. Antes de una base remota se deben aprobar responsable, plazo de conservación, acceso y procedimiento de eliminación.

## Compilación

```powershell
$env:JAVA_HOME='C:\Program Files\Android\Android Studio\jbr'
$env:ANDROID_HOME='D:\AndroidSdk'
$env:RELEVO_BUILD_DIR='D:\AndroidBuild'
.\gradlew.bat :app:testDebugUnitTest :app:assembleDebug --no-configuration-cache
```

## Estructura relevante

- `domain/Reminder.kt`: estados y condiciones del ciclo;
- `monitor/AppUsageMonitorService.kt`: observación visible del primer plano;
- `monitor/UsageAccess.kt`: comprobación del permiso;
- `data/ResearchLogStore.kt`: eventos seudónimos en SQLite;
- `data/ReminderStore.kt`: estado local del recordatorio;
- `signal/SignalPlayer.kt`: sonido y vibración;
- `ui/RelevoViewModel.kt`: coordinación;
- `ui/RelevoApp.kt`: recorrido reducido a inicio, configuración, estado activo y señal.

## Registro de cambios (disclaimer)

### 2026-09-22 — Lenguaje directo, permisos y sincronización verificada

- **Cambio:** el texto visible explica el identificador aleatorio sin recurrir al término técnico “código seudónimo”.
- **Versión anterior:** el consentimiento empleaba un concepto que podía resultar ambiguo para una persona ajena a la investigación.
- **Motivo:** informar con precisión qué dato se crea y qué información personal no se solicita.
- **Cambio:** el tutorial elimina rótulos redundantes y agrega una escena final que explica y solicita Tiempo de uso y Notificaciones.
- **Versión anterior:** los permisos aparecían más tarde y sin formar parte del aprendizaje inicial.
- **Motivo:** explicar cada solicitud antes de abrir el ajuste del sistema y evitar permisos sin contexto.
- **Cambio visual:** se retiró la marca repetida de las pantallas internas, los botones con apariencia predeterminada y el selector emergente de aplicaciones.
- **Versión anterior:** la jerarquía dependía de títulos pequeños, mayúsculas y componentes reconocibles del sistema visual anterior.
- **Motivo:** dejar que el contenido guíe la lectura y reservar la marca para el inicio.
- **Verificación:** Supabase aceptó autenticación anónima, inserción y lectura bajo RLS. El registro técnico se eliminó después de comprobar el recorrido.

### 2026-09-22 — Consentimiento inicial y tutorial ilustrado

- **Cambio:** el consentimiento académico aparece antes del tutorial, exige una aceptación explícita y persiste durante los usos siguientes.
- **Versión anterior:** los términos se aceptaban dentro de cada configuración y competían con el permiso técnico de Android.
- **Motivo:** separar la decisión de participar de la autorización del sistema operativo y evitar cualquier registro previo al consentimiento.
- **Cambio visual:** cada etapa del tutorial incorpora una ilustración propia y la configuración reemplaza campos y chips predeterminados por componentes de Relevo.
- **Versión anterior:** el tutorial utilizaba iconos aislados y la configuración mantenía patrones visuales genéricos.
- **Motivo:** enseñar acciones reales, mantener continuidad narrativa y elevar la identidad del producto.
- **Alcance:** antes de una prueba formal todavía debe añadirse el contacto del responsable y aprobarse el texto definitivo de consentimiento.

### 2026-09-22 — Introducción progresiva y navegación propia

- **Cambio:** el primer inicio presenta cinco escenas breves y no vuelve a mostrarlas después de completarlas.
- **Versión anterior:** cada creación pasaba por una pantalla tutorial extensa.
- **Motivo:** explicar una idea por vez y evitar instrucciones repetidas en usos posteriores.
- **Cambio visual:** se sustituyó la barra inferior predeterminada, se eliminó la sombra del llamado principal y se ampliaron las transiciones entre estados.
- **Versión anterior:** la navegación y varias superficies conservaban una apariencia reconocible de Material Design.
- **Motivo:** consolidar una experiencia propia de Relevo con profundidad contenida y continuidad espacial.

### 2026-09-22 — Registro evaluativo y movimiento continuo

- **Cambio:** se añadieron sesiones estructuradas, respuesta final opcional, recuento por actividad y cola de sincronización remota.
- **Versión anterior:** solo se almacenaban eventos técnicos locales y el historial no sintetizaba actividades.
- **Motivo:** evaluar elecciones y comportamiento del sistema sin afirmar acciones que la aplicación no puede observar.
- **Cambio visual:** se retiraron sombras de tarjetas, se limitaron a elementos flotantes, se suavizaron transiciones y se incorporó un degradado lento en la acción principal.

### 2026-09-22 — Jerarquía visual y datos vinculados

- **Cambio:** Inicio elimina saludos y estados genéricos, el tutorial concentra la explicación visual y Actividad muestra únicamente aplicaciones elegidas por la persona.
- **Versión anterior:** la ilustración aparecía en Inicio y el resumen de uso incluía todas las aplicaciones registradas por Android.
- **Motivo:** cada elemento debe comunicar una función del sistema y las métricas deben corresponder a decisiones tomadas dentro de Relevo.
- **Cambio visual:** se incorporaron profundidad moderada, un degradado reservado para la acción principal, superficie translúcida elevada en navegación y un selector temporal con mayor jerarquía.

### 2026-09-22 — Tablero, tiempos y retroalimentación

- **Cambio:** se incorporaron navegación inferior, resumen diario, historial, ubicación de la señal, preestablecidos, iconos reales, deslizador de tiempo, transiciones, alarma y notificación final.
- **Versión anterior:** la aplicación comenzaba directamente en una portada y la configuración solo ofrecía tres duraciones.
- **Motivo:** hacer visible el estado del sistema, reducir escritura repetida y permitir configurar condiciones reales sin aumentar la cantidad de pantallas.
- **Corrección técnica:** Android 13 o superior ahora solicita el permiso de notificaciones durante la ejecución.

### 2026-09-21 — Condición automática por aplicación

- **Cambio:** el temporizador pasivo fue reemplazado por la selección de una aplicación y la medición de uso acumulado en primer plano.

### 2026-09-21 — Simplificación del recorrido

- **Cambio:** nueve pantallas fueron reducidas a cuatro momentos y toda la configuración quedó reunida en una sola vista.
- **Versión anterior:** el recorrido separaba formulación, condición, revisión, ubicación, prueba y activación.
- **Motivo:** reducir carga, evitar repeticiones y hacer visible desde el inicio qué hace Relevo.
- **Versión anterior:** la señal aparecía después de una espera, sin reconocer el uso de otras aplicaciones.
- **Motivo:** hacer comprobable la relación central de Relevo entre el uso prolongado de una aplicación elegida y una señal situada.
- **Privacidad:** se incorporaron consentimiento explícito, un identificador aleatorio no nominal, notificación persistente y almacenamiento local limitado.
