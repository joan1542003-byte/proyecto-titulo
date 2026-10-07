# Android 2.24: cómo usar el llavero

**Fecha:** 7 de octubre de 2026. **Decisión:** D-109 (llavero). **Estado:** compilada desde cero, con 83 pruebas unitarias aprobadas. La guía se revisó en el emulador. No se ha probado en un teléfono real. El consentimiento no cambia (v13).

## Qué pidió el autor

Un tutorial dentro de la app para encender y apagar el llavero. El modelo comprado es el NEWOTAG-BL de Netexpertos, un iTag clásico que se usa con iSearching.

## Qué cambia

| Parte | Cambio |
| --- | --- |
| «Cómo usar el llavero» | Una hoja con seis pasos breves: encenderlo, callarlo cuando suena, apagarlo, saber si está encendido, la pila y qué hacer si no aparece. |
| Dónde se abre | En «¿Dónde suena?» › «El llavero», antes y después de elegirlo, y en Perfil › Ayuda. |
| Señal | Mientras suena el llavero, la pantalla dice «Para callarlo en el llavero, toca su botón una vez.». |
| Prueba del llavero | «Para callarlo, toca su botón una vez. Si lo mantienes apretado, se apaga.» reemplaza a «aprieta su botón», que podía llevar a apagarlo. |

## De dónde salen las instrucciones

La publicación de Netexpertos no trae instrucciones de uso. Se usaron las del iTag clásico:

- **Encender y apagar:** mantener el botón 3 segundos. Se enciende con dos pitidos y se apaga con un pitido largo, según el manual de iSearching.
- **Estado al desconectarse:** el llavero vuelve a esperar conexión, sin apagarse ([RevSpace, s. f.](https://www.revspace.nl/AntiLost)).
- **Pila:** el vendedor indica que usa una CR2032.

No se pudo comprobar en este modelo cómo se abre la tapa: la guía dice «por la ranura del borde con una uña o una moneda».

**APK:** [relevo-android-2.24-2026-10-07.apk](releases/relevo-android-2.24-2026-10-07.apk), SHA-256 `B6F1F08E225747946E0036383F52CD4BFD8EB8511755FEBDCCA5F3A51E88B0D8` (41,3 MB), compilación limpia de depuración.

## Registro de cambios (disclaimer)

### 2026-10-07 — Creación

- **Qué se añadió:** la versión 2.24, con la guía «Cómo usar el llavero» y los avisos para callarlo sin apagarlo.
- **Cómo estaba antes:** la app solo decía cómo encender el llavero al buscarlo.
- **Por qué:** pedido del autor del 7 de octubre.
