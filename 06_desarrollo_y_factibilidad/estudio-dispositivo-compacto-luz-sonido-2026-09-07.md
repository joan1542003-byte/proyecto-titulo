# Estudio de un testigo compacto con luz y sonido

**Fecha de corte:** 7 de septiembre de 2026; ruta de prueba actualizada el 11 de septiembre de 2026
**Estado:** arquitectura de integración posterior; antes se probarán dos productos terminados. No constituye un circuito aprobado ni una orden de compra de componentes.

**Actualización de alcance:** la arquitectura XIAO sigue siendo la opción de integración si Relevo necesita un objeto propio, pero ya no es el primer paso. La [búsqueda de productos terminados en Chile](busqueda-productos-terminados-chile-2026-09-11.md) prioriza dos iTag clásicos para comprobar si el vínculo Android–objeto y el sonido pueden resolverse sin fabricar electrónica. La luz y el comportamiento completo continúan sujetos a ensayo.

## Pregunta de diseño

¿Cómo construir un testigo físico pequeño y fácil de trasladar que reciba una orden desde Android y emita una señal breve de luz y sonido, sin convertir el proyecto en un desarrollo electrónico desproporcionado?

El objetivo no es fabricar un localizador. El parecido con esa categoría sirve para establecer una escala de referencia: un objeto ligero, reconocible, autónomo y suficientemente discreto para quedar junto a unas zapatillas, un libro o unas pesas. Relevo no necesita rastreo, geolocalización, banda ultraancha, red comunitaria ni búsqueda de objetos perdidos.

## Requisitos que gobiernan la decisión

1. **Salida acotada:** una luz y un sonido breve; no una pantalla ni mensajes extensos.
2. **Control de la persona:** la señal debe poder silenciarse localmente y desde la aplicación.
3. **Portabilidad:** el objeto debe cambiar de lugar sin instalación fija.
4. **Conectividad local:** Android transmite pocos datos a corta distancia mediante Bluetooth de baja energía (BLE).
5. **Construcción accesible:** piezas disponibles, pocas uniones y carcasa de dos partes; no una placa electrónica propia en la primera versión.
6. **Mantenimiento comprensible:** pila reemplazable o carga por USB-C, con su estado o periodo de recambio explicado a la persona.
7. **Seguridad:** batería protegida, volumen moderado, bordes redondeados y cierre que impida acceder a la electrónica durante el uso.
8. **Honestidad:** tamaño, autonomía y fiabilidad se presentan como metas hasta medirlos en un prototipo.

## Qué enseña el mercado

| Referente | Tamaño y energía | Recursos pertinentes | Aprendizaje para Relevo |
|---|---|---|---|
| Apple AirTag, segunda generación | 31,9 mm de diámetro, 8 mm de grosor, 11,8 g y pila CR2032 reemplazable | BLE y altavoz integrado | Demuestra que una señal acústica cabe en un objeto muy pequeño, pero alcanza esa escala mediante hardware y carcasa desarrollados específicamente. No es una ruta de construcción rápida con módulos. |
| Samsung Galaxy SmartTag2 | 28,8 × 52,44 × 8 mm, 13,75 g y CR2032 | BLE 5.3, zumbador y botón | Confirma que un único control físico y una señal sonora bastan para una interacción básica. Sus funciones de rastreo, UWB y red distribuida no son necesarias para Relevo. |
| Chipolo ONE | 37,9 mm de diámetro y 6,4 mm de grosor | BLE, sonido y pila CR2032 | Su volumen máximo, declarado en 120 dB, responde a la búsqueda de objetos. Relevo necesita una señal cercana, regulable y no alarmista; no debe imitar esa intensidad. |
| Nordic Thingy:53 | Plataforma de prototipado con batería recargable | BLE, LED RGB, zumbador y botones ya integrados | Reduce trabajo electrónico, pero incorpora sensores y capacidad que el proyecto no utiliza. Es útil como referencia funcional, no como solución mínima. |

Los productos comparados resuelven bien la portabilidad, el consumo y la integración. Ninguno está especializado en trasladar una intención elegida desde el teléfono hasta el lugar donde puede comenzar una actividad. Esa diferencia no autoriza a afirmar novedad universal: debe demostrarse comparando Relevo con una notificación y con alternativas más simples.

## Cuatro rutas posibles

### A. Adaptar un localizador comercial

**Ventaja:** forma, batería y carcasa ya resueltas.  
**Problema:** sus aplicaciones y firmware no permiten controlar libremente el momento, patrón y significado de la señal. Abrir o modificar el equipo añade riesgo, dependencia de ingeniería inversa y poca reproducibilidad.

**Decisión:** descartado como núcleo. Puede conservarse como referencia de escala y acabados.

### B. XIAO ESP32-C3, luz y zumbador

**Ventaja:** placa económica y ya considerada en el repositorio. Permite demostrar rápidamente el envío BLE, la luz y el sonido.  
**Problema:** su consumo y la puesta a punto del modo de bajo consumo son menos convenientes para una pieza que debe permanecer encendida. El anillo de doce LED y la electrónica de 5 V estudiados antes agrandan el conjunto sin aportar a la función mínima.

**Uso recomendado:** prueba de mesa o respaldo si la placa ya está disponible. No es la arquitectura portátil preferida.

### C. XIAO nRF52840, batería recargable, luz única y transductor pequeño

La placa mide 21 × 17,8 mm, integra BLE, carga para batería de 3,7 V y un LED RGB programable. Para Relevo solo necesita añadir un emisor sonoro de 9 a 12 mm, un control local y una batería protegida. El módulo se ofrece actualmente en Chile por CLP 16.590 con IVA; el precio debe volver a verificarse al comprar.

**Ventajas:** pocas piezas, USB-C, mejor base de bajo consumo que una solución Wi-Fi, firmware actualizable y tamaño compatible con una carcasa de bolsillo.  
**Límites:** no alcanza el grosor de un AirTag con una placa de desarrollo y batería apiladas. Las cifras de consumo del chip nRF52840 no equivalen al consumo de la placa terminada; la autonomía debe medirse.

**Decisión:** arquitectura recomendada para el primer prototipo portátil.

### D. Placa propia con nRF52 y pila tipo moneda

**Ventaja:** permitiría acercarse a 32–38 mm de diámetro y menos de 10 mm de grosor.  
**Problema:** exige diseño y fabricación de PCB, selección RF, protección de batería, programación, ensamble fino y varias iteraciones. Una CR2032 posee capacidad suficiente para cargas muy bajas, pero tolera pulsos modestos; luz y sonido deben dimensionarse con cuidado. También se requiere un compartimiento seguro frente al acceso infantil.

**Decisión:** posible evolución posterior, no requisito para validar el valor del proyecto de título.

## Matriz de decisión

Escala de 1 a 5, donde 5 es más favorable. La ponderación privilegia construcción y adecuación a la prueba, no miniaturización industrial.

| Criterio | Peso | Comercial adaptado | ESP32-C3 | XIAO nRF52840 | PCB propia |
|---|---:|---:|---:|---:|---:|
| Control de la señal | 25 % | 1 | 5 | 5 | 5 |
| Poca mano de obra | 20 % | 2 | 4 | 4 | 1 |
| Portabilidad | 20 % | 5 | 3 | 4 | 5 |
| Autonomía esperable | 15 % | 5 | 2 | 4 | 5 |
| Costo de iteración | 10 % | 2 | 5 | 4 | 1 |
| Reproducibilidad | 10 % | 1 | 4 | 4 | 2 |
| **Resultado ponderado** | **100 %** | **2,55** | **3,85** | **4,30** | **3,55** |

## Arquitectura recomendada

```text
Android
  │  condición elegida + permiso de uso explícito
  │  orden breve mediante BLE
  ▼
XIAO nRF52840
  ├── LED único detrás de un difusor
  ├── transductor sonoro pequeño
  ├── control local de silencio / emparejamiento
  └── batería LiPo protegida + carga USB-C
```

La aplicación actúa como dispositivo central y el testigo como periférico BLE. No conviene mantener una conexión permanente si una conexión breve al cumplirse la condición resulta fiable. Android recomienda el emparejamiento de dispositivos acompañantes y ofrece mecanismos específicos para encontrarlos y comunicarse en segundo plano; aun así, el sistema puede cerrar procesos o restringir tareas. Por eso el comportamiento debe probarse con pantalla apagada, ahorro de batería, reinicio del teléfono y pérdida temporal de alcance.

El acceso al historial de uso requiere `PACKAGE_USAGE_STATS` y una autorización manual en Ajustes. Relevo debe explicar para qué se solicita, procesar los datos localmente y evitar registrar historiales innecesarios. La autorización permite consultar uso; no garantiza por sí sola una activación exacta ni un servicio permanente.

## Forma y montaje provisional

- **Envolvente objetivo:** 42–48 mm de diámetro y 12–16 mm de grosor. Es una meta de prototipo, no una dimensión validada.
- **Construcción:** carcasa superior e inferior impresas en 3D, unidas con tornillos pequeños o encaje revisable; sin adhesivo permanente durante las iteraciones.
- **Luz:** un punto o halo difuso visible desde el ángulo normal de aproximación. No hace falta un anillo de LED.
- **Sonido:** patrón breve y regulable; el primer ensayo debe partir bajo y subir solo si la señal no se percibe. No se adopta el volumen de los rastreadores.
- **Control:** un botón de perfil bajo o una zona superior pulsable. Una pulsación silencia; una pulsación prolongada inicia el emparejamiento. El significado debe distinguirse también por duración y respuesta luminosa.
- **Carga:** USB-C accesible sin abrir el cuerpo.
- **Sujeción:** base estable y una abertura opcional para cordón. No se incorpora adhesivo hasta observar dónde lo sitúan las personas.

## Lista mínima de materiales

| Pieza | Cantidad | Estado de precio | Observación |
|---|---:|---|---|
| Seeed Studio XIAO nRF52840 | 1 | CLP 16.590 observado el 7-09-2026 | Proveedor chileno; verificar stock y precio. |
| Batería LiPo protegida, 3,7 V, 150–300 mAh | 1 | Por cotizar | Elegir dimensiones después de una maqueta volumétrica. No comprar una celda sin protección ni datos técnicos. |
| Transductor sonoro de 9–12 mm, 3 V | 1 | CLP 500–1.500 estimados | La oferta local confirma disponibilidad de piezas de 12 mm; validar consumo y presión sonora. |
| Pulsador de perfil bajo | 1 | Por cotizar | Puede sustituirse por una tapa pulsable que accione el componente. |
| Interruptor de transporte | 1 | Por cotizar | Evita descarga durante almacenamiento; evaluar si la lógica de apagado basta. |
| Conductores, resistencia y transistor si el transductor lo exige | 1 conjunto | Por cotizar | Depende del componente sonoro medido. |
| Carcasa impresa y difusor | 1 | Por cotizar | Dos piezas y máximo una operación de acabado. |

No se publica un total artificial mientras batería, transductor, carcasa y envío no tengan proveedor y fecha. La placa representa hoy el costo confirmado principal. El presupuesto debe separar piezas reutilizables, desembolso de paquetes, carcasa y horas de fabricación.

## Secuencia de construcción con poca mano de obra

1. Probar por USB el enlace BLE, LED integrado y un zumbador externo.
2. Medir corriente en reposo, publicidad BLE, conexión y señal.
3. Probar tres patrones de sonido y luz con volumen limitado.
4. Construir una maqueta volumétrica sin electrónica para decidir diámetro, grosor, apertura, apoyo y acceso a carga.
5. Integrar una batería protegida y verificar carga, temperatura y apagado.
6. Imprimir dos carcasas, no una familia extensa: una redonda y una rectangular redondeada con el mismo volumen interno.
7. Elegir forma por manipulación, estabilidad y lectura de la señal; no solo por preferencia visual.

## Pruebas necesarias antes de presentar la arquitectura como resuelta

- emparejamiento inicial y recuperación después de perder alcance;
- activación con la pantalla apagada y la aplicación en segundo plano;
- latencia entre condición y señal;
- corriente y autonomía en uso real;
- percepción de la luz de día y de noche;
- audibilidad a uno, tres y cinco metros sin resultar alarmante;
- silencio local inmediato;
- calentamiento durante la carga;
- resistencia de la carcasa a una caída doméstica;
- comparación con una notificación equivalente;
- comprensión de dónde dejar el objeto y por qué.

## Conclusión

Relevo no debe intentar ser un AirTag artesanal. La ruta inmediata más proporcionada es comprobar dos iTag clásicos y conservar únicamente las capacidades que demuestren. Si ninguno ofrece el control y la estabilidad necesarios, o si la luz obliga a una integración propia, la opción siguiente es un testigo de bolsillo basado en XIAO nRF52840, batería recargable, una luz, un sonido y un control local. La placa propia solo cobra sentido si las pruebas justifican ese trabajo adicional.

## Fuentes

- Android Developers. (2026). *Communicate in the background*. https://developer.android.com/develop/connectivity/bluetooth/ble/background
- Android Developers. (s. f.). *Companion device pairing*. https://developer.android.com/develop/connectivity/bluetooth/companion-device-pairing
- Android Developers. (s. f.). *UsageStatsManager*. https://developer.android.com/reference/android/app/usage/UsageStatsManager
- Apple. (2026). *AirTag (2nd generation)—Technical specifications*. https://support.apple.com/id-id/126203
- Chipolo. (s. f.). *Chipolo ONE*. https://chipolo.net/en-us/products/chipolo-one
- Energizer. (2020). *Ultimate Lithium CR2032: Product datasheet*. https://www.data.energizer.com/pdfs/ultimatecr2032EU0920.pdf
- MechatronicStore. (s. f.). *Seeed Studio XIAO nRF52840*. https://www.mechatronicstore.cl/seed-studio-xiao-nrf52840/
- Nordic Semiconductor. (s. f.). *nRF52840*. https://www.nordicsemi.com/products/nrf52840
- Nordic Semiconductor. (s. f.). *Nordic Thingy:53*. https://www.nordicsemi.com/Products/Development-hardware/Nordic-Thingy-53
- Samsung. (s. f.). *Galaxy SmartTag2*. https://www.samsung.com/latin/mobile-accessories/galaxy-smarttag2-black-ei-t5600kwegww/
- Seeed Studio. (2026). *Getting started with Seeed Studio XIAO nRF52840 series*. https://wiki.seeedstudio.com/XIAO_BLE/

## Referente y decisiones complementarias del feedback

El localizador UGREEN mencionado por el autor se analiza en la [ficha FineTrack](../04_mercado_y_referentes/ugreen-localizador-como-referente.md). Informa portabilidad y fijación, pero depende de una plataforma de localización y no sustituye la ruta iTag de prueba ni el respaldo micro:bit/XIAO. Los criterios de forma y lugar se mantienen en [forma adaptable y ubicación](../05_propuesta_phygital/forma-adaptable-y-ubicacion.md), y la alternativa háptica en [luz, sonido y vibración](senal-luz-sonido-y-vibracion.md).

## Registro de cambios (disclaimer)

### 2026-09-11 — Arquitectura posterior a la prueba comercial

- **Cambio:** la XIAO dejó de presentarse como primer paso y quedó condicionada al resultado de dos iTag clásicos; también se admitió la pila reemplazable como mantenimiento válido.
- **Versión anterior:** el documento recomendaba construir directamente un testigo recargable basado en XIAO nRF52840.
- **Motivo:** reducir costo, mano de obra y fabricación antes de comprobar si un producto terminado puede resolver el vínculo Android–objeto y la señal sonora.
- **Alcance:** no se afirma que los iTag cumplan luz, patrón o estabilidad. La arquitectura XIAO sigue vigente como integración posterior si las pruebas la hacen necesaria.

### 2026-09-09 — Respuesta al feedback del 2 de septiembre

- **Cambio:** Se conectaron referente, forma y modalidades con sus respuestas específicas.
- **Versión anterior:** La respuesta estaba dispersa o conservaba formulaciones anteriores.
- **Motivo:** mantener una respuesta localizable, clara y coherente con las decisiones vigentes.
- **Alcance:** No se incorporan resultados de pruebas ni se modifica el protocolo vigente.

### 2026-09-07 — Creación

- **Qué cambió:** se compararon cuatro rutas y se seleccionó una arquitectura portátil basada en XIAO nRF52840 para el siguiente prototipo.
- **Cómo era antes:** la factibilidad se concentraba en montajes de mesa de 5 y 12 V con XIAO ESP32-C3 y fuentes luminosas mayores.
- **Por qué:** la nueva definición física exige un testigo pequeño, transportable y autónomo que emita luz y sonido con pocas piezas y poca mano de obra.
- **Límite:** no hay compra, construcción, medición de autonomía ni validación de tamaño, volumen o fiabilidad Android.
