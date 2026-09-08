// Relevo — prueba técnica Android → BLE → luz/sonido.
// Cambiar a true solo después de conectar y revisar la luz cálida externa.
const USE_EXTERNAL_WARM_LIGHT = false

// Parámetros de ensayo: registrar cualquier cambio en la ficha técnica.
const MATRIX_BRIGHTNESS = 96
const EXTERNAL_LIGHT_LEVEL = 640
const SOUND_VOLUME = 72
const TONE_HZ = 523
const TONE_MS = 180
const PULSE_MS = 600
const GAP_MS = 600

let signalActive = false
let silenceRequested = false

function lightOn(): void {
    if (USE_EXTERNAL_WARM_LIGHT) {
        pins.analogWritePin(AnalogPin.P1, EXTERNAL_LIGHT_LEVEL)
    } else {
        led.setBrightness(MATRIX_BRIGHTNESS)
        led.plotAll()
    }
}

function lightOff(): void {
    pins.analogWritePin(AnalogPin.P1, 0)
    basic.clearScreen()
}

function silenceLocally(): void {
    if (!signalActive) {
        return
    }

    silenceRequested = true
    lightOff()
    music.stopAllSounds()
    bluetooth.uartWriteLine("silenciada")
}

function runSignal(): void {
    if (signalActive) {
        return
    }

    signalActive = true
    silenceRequested = false
    bluetooth.uartWriteLine("recibida")

    music.setVolume(SOUND_VOLUME)
    music.play(
        music.tonePlayable(TONE_HZ, TONE_MS),
        music.PlaybackMode.InBackground
    )

    for (let pulse = 0; pulse < 3; pulse++) {
        if (silenceRequested) {
            break
        }

        lightOn()
        basic.pause(PULSE_MS)
        lightOff()

        if (silenceRequested) {
            break
        }

        if (pulse < 2) {
            basic.pause(GAP_MS)
        }
    }

    lightOff()
    music.stopAllSounds()

    if (!silenceRequested) {
        bluetooth.uartWriteLine("terminada")
    }

    signalActive = false
}

input.onButtonPressed(Button.A, function () {
    silenceLocally()
})

input.onButtonPressed(Button.B, function () {
    silenceLocally()
})

bluetooth.onBluetoothConnected(function () {
    bluetooth.uartWriteLine("lista")
})

bluetooth.onUartDataReceived(
    serial.delimiters(Delimiters.NewLine),
    function () {
        const command = bluetooth.uartReadUntil(
            serial.delimiters(Delimiters.NewLine)
        ).trim()

        if (command == "activar" && !signalActive) {
            control.inBackground(function () {
                runSignal()
            })
        }
    }
)

lightOff()
bluetooth.startUartService()
