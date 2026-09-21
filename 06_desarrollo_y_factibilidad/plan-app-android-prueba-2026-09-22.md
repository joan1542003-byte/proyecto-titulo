# Plan de desarrollo de la aplicación Android para prueba

> **Plan superado parcialmente:** la espera temporal descrita aquí fue reemplazada por detección de uso continuo de la aplicación elegida. Consultar `app-android/README.md` para el estado implementado.

**Fecha de planificación:** 21 de septiembre de 2026  
**Hito ejecutable:** 22 de septiembre de 2026  
**Estado:** APK compilado y recorrido principal aprobado en emulador; verificación en teléfono real pendiente

## Objetivo del hito

Disponer de una aplicación Android instalable que permita recorrer, sin asistencia del investigador, el ciclo mínimo de Relevo: preparar una actividad, precisar cómo comenzarla, definir una condición temporal de prueba, revisar lo configurado, relacionarlo con un lugar, comprobar la señal, dejar el recordatorio activo, recibir la señal y cerrar el ciclo.

Este hito sirve para evaluar comprensión, continuidad y control del recorrido. No demostrará todavía eficacia conductual, detección fiable del uso de otras aplicaciones ni integración con el objeto físico definitivo.

## Decisión de alcance

La versión del 22 de septiembre será un **prototipo funcional de interacción**. Debe poder instalarse, conservar la configuración local y ejecutar el recorrido completo. La condición se resolverá con un temporizador local y un control de prueba claramente identificado. La señal se reproducirá desde Android; si existe un parlante Bluetooth emparejado, Android podrá dirigir allí el audio mediante su salida habitual.

No se incorporarán en este hito:

- cuentas, nube o sincronización;
- historial, estadísticas, rachas o evaluación de cumplimiento;
- detección de aplicaciones mediante `UsageStats`;
- control propietario de un rastreador o integración BLE no verificada;
- múltiples recordatorios simultáneos;
- personalización extensa de la señal;
- afirmaciones sobre si la persona realizó o no la actividad.

Estas exclusiones evitan que una dependencia todavía no comprobada impida probar el valor central del recorrido.

## Recorrido que debe funcionar

1. **Actividad:** escribir qué se quiere hacer.
2. **Cómo empezar:** escribir una acción pequeña y concreta que permita comenzar.
3. **Condición de prueba:** elegir cuánto esperar antes de emitir la señal.
4. **Revisión:** comprobar y editar los datos antes de activar el recordatorio.
5. **Lugar:** declarar dónde quedará el objeto o parlante junto al comienzo de la actividad.
6. **Prueba de señal:** reproducir, detener y volver a probar la señal antes de activar.
7. **Activación:** confirmar de forma explícita que el recordatorio queda en espera.
8. **Espera:** mostrar qué está activo, cuánto falta y permitir desactivarlo.
9. **Señal y cierre:** emitir una señal breve, ofrecer silencio inmediato y cerrar sin preguntar si la persona obedeció.

La representación del pulso físico pertenece al relato del sistema, pero no se presentará como una pantalla instalada en el objeto.

## Estados prioritarios de recuperación

La aplicación debe resolver antes de la prueba:

- datos obligatorios incompletos;
- salida voluntaria antes de activar;
- salida de audio no disponible o volumen insuficiente;
- señal no percibida o considerada intrusiva durante la prueba;
- activación sin confirmación clara;
- desactivación voluntaria durante la espera;
- vencimiento o interrupción sin señal;
- cierre después de silenciar o ignorar la señal.

Los fallos se comunicarán como estados del sistema y nunca como errores de la persona.

## Arquitectura prevista

- **Plataforma:** Android nativo.
- **Lenguaje:** Kotlin.
- **Interfaz:** Jetpack Compose con componentes Material 3 adaptados al sistema visual vigente.
- **Estructura:** una actividad, navegación declarativa y un estado de sesión compartido.
- **Persistencia:** almacenamiento local de una sola configuración y de su estado; sin datos personales ni conexión remota.
- **Temporización:** temporizador local con cálculo desde una marca de tiempo, para que el tiempo restante no dependa de mantener una pantalla abierta.
- **Señal:** audio breve controlado por la aplicación y vibración solo como apoyo del teléfono durante el ensayo técnico; el canal físico definitivo permanece separado.
- **Modo de prueba:** intervalos breves y activación manual accesible únicamente desde una sección identificada para el investigador.

La lógica de condición y la emisión de señal quedarán detrás de interfaces internas separadas. Esto permite sustituir el temporizador y el audio por `UsageStats` y un canal físico verificado sin rehacer las pantallas.

## Criterios de aceptación del APK

El hito se considera listo solo si:

1. compila un APK instalable sin errores;
2. abre en un teléfono Android sin conexión a internet;
3. permite completar los nueve momentos del recorrido;
4. impide activar cuando faltan actividad, comienzo, condición o lugar;
5. conserva el recordatorio al cerrar y volver a abrir la aplicación;
6. reproduce y permite detener la señal de prueba;
7. activa un temporizador, muestra su estado y permite desactivarlo;
8. emite una sola señal al cumplirse la condición;
9. no emite una señal tardía después de desactivar o cerrar;
10. permite cerrar sin registrar cumplimiento;
11. ofrece reinicio de datos para repetir una sesión;
12. incluye una guía breve de instalación, uso y limitaciones.

## Verificación antes de participantes

Se realizarán, como mínimo:

- una revisión de navegación de principio a fin;
- una prueba de persistencia tras cerrar la aplicación;
- tres temporizadores consecutivos;
- una interrupción y reanudación durante la espera;
- una desactivación anterior al vencimiento;
- una prueba con volumen bajo o silenciado;
- una prueba de salida por el teléfono y, si está disponible, por parlante Bluetooth;
- una revisión del tamaño de texto, contraste y áreas táctiles.

Una falla que impida preparar, activar, percibir, silenciar o cerrar detiene el uso con participantes hasta ser corregida.

## Plan de trabajo

### 21 de septiembre

1. cerrar alcance, arquitectura y criterios de aceptación;
2. instalar y verificar el entorno Android;
3. crear el proyecto, navegación y modelo de estado;
4. implementar preparación, revisión y persistencia;
5. implementar señal de prueba, espera, activación y cierre;
6. aplicar el sistema visual vigente sin agregar una nueva exploración de marca.

### 22 de septiembre

1. compilar e instalar el APK;
2. ejecutar la matriz de recorridos y recuperaciones;
3. corregir fallos críticos;
4. congelar una versión de prueba identificable;
5. entregar APK, código, guía de instalación y pauta de verificación interna.

## Entregables

- código fuente del proyecto Android;
- APK de prueba con número de versión y fecha;
- guía de instalación y uso;
- matriz de pruebas con resultado por criterio;
- registro de limitaciones conocidas;
- actualización del índice, decisiones y estado del repositorio.

## Riesgos y respuesta

| Riesgo | Consecuencia | Respuesta del hito |
|---|---|---|
| Entorno Android no disponible o instalación incompleta | No se puede producir un APK | Instalar y comprobar compilación al inicio, no al final. |
| No existe un objeto controlable desde la aplicación | La señal no representa todavía el producto final | Usar salida Android o parlante Bluetooth como material de ensayo y declarar el límite. |
| Segundo plano restringido | El temporizador puede demorarse | Calcular desde una marca de tiempo y comprobar reanudación; no prometer detección permanente. |
| Recorrido demasiado largo | Fatiga o abandono durante la prueba | Mantener una decisión principal por pantalla y permitir editar sin perder datos. |
| Señal imperceptible o intrusiva | Se invalida la comprensión del momento | Probar volumen y salida antes de activar; ofrecer silencio inmediato. |

## Registro de cambios (disclaimer)

### 2026-09-21 — Primer hito ejecutable alcanzado

- **Cambio:** se compiló el APK, aprobaron ocho pruebas unitarias y se completó el recorrido principal en un emulador Android después de corregir dos bloqueos de estado.
- **Versión anterior:** el documento solo planificaba la construcción y no disponía de resultados técnicos.
- **Motivo:** mantener el plan sincronizado con el estado verificable del desarrollo.
- **Alcance:** la instalación, el audio y la salida Bluetooth siguen pendientes de comprobación en el teléfono que se utilizará en la sesión.

### 2026-09-21 — Creación del plan ejecutable

- **Cambio:** se definieron alcance, recorrido, arquitectura, criterios de aceptación, verificación, tiempos y entregables para la primera aplicación Android instalable.
- **Versión anterior:** el repositorio contenía el wireframe cerrado, la decisión Android y criterios de validación, pero no un plan integrado de construcción con fecha de APK.
- **Motivo:** convertir decisiones dispersas en una ruta verificable para disponer de una aplicación funcional el 22 de septiembre de 2026.
- **Alcance:** el documento planifica un prototipo funcional de interacción; no afirma que exista todavía un APK, una integración física definitiva ni resultados con participantes.
